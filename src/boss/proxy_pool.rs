use std::collections::HashMap;
use std::fs::{self, OpenOptions};
use std::io::{ErrorKind, Write};
use std::path::{Path, PathBuf};
use std::time::Duration;

use anyhow::{anyhow, Context, Result};
use reqwest::blocking::Client;
use reqwest::{Proxy, Url};
use serde::{Deserialize, Serialize};
use serde_json::{json, Value};

const DEFAULT_PROXY_POOL_FILE: &str = ".local/boss_socks5_pool.txt";
const LOCK_RETRY_MS: u64 = 20;

#[derive(Clone, Debug)]
struct Socks5ProxyEntry {
    host: String,
    port: u16,
    username: String,
    password: String,
    line_number: usize,
    source: String,
}

#[derive(Clone, Debug)]
pub struct SelectedSocks5Proxy {
    entry: Socks5ProxyEntry,
    state_path: PathBuf,
    selection_index: u64,
    pool_size: usize,
}

impl SelectedSocks5Proxy {
    pub fn describe(&self) -> Value {
        json!({
            "type": "socks5",
            "host": self.entry.host,
            "port": self.entry.port,
            "username_preview": preview_secret(&self.entry.username),
            "password_preview": preview_secret(&self.entry.password),
            "source": self.entry.source,
            "line_number": self.entry.line_number,
            "selection_index": self.selection_index,
            "pool_size": self.pool_size,
            "state_path": self.state_path.display().to_string(),
        })
    }

    pub fn to_reqwest_proxy(&self) -> Result<Proxy> {
        let mut url = Url::parse(&format!(
            "socks5h://{}:{}",
            self.entry.host, self.entry.port
        ))
        .with_context(|| {
            format!(
                "failed to build socks5 proxy url for {}:{}",
                self.entry.host, self.entry.port
            )
        })?;
        url.set_username(&self.entry.username)
            .map_err(|_| anyhow!("invalid socks5 proxy username"))?;
        url.set_password(Some(&self.entry.password))
            .map_err(|_| anyhow!("invalid socks5 proxy password"))?;
        Proxy::all(url.as_str()).context("failed to configure socks5 proxy")
    }

    pub fn append_java_cli_args(&self, command: &mut std::process::Command) {
        command
            .arg("--socks5-host")
            .arg(&self.entry.host)
            .arg("--socks5-port")
            .arg(self.entry.port.to_string())
            .arg("--socks5-username")
            .arg(&self.entry.username)
            .arg("--socks5-password")
            .arg(&self.entry.password);
    }
}

#[derive(Clone, Debug, Default, Serialize, Deserialize)]
struct ProxyPoolState {
    next_index: usize,
    total_selections: u64,
}

struct ProxyPoolLock {
    path: PathBuf,
    _file: fs::File,
}

impl ProxyPoolLock {
    fn acquire(path: &Path) -> Result<Self> {
        loop {
            match OpenOptions::new().write(true).create_new(true).open(path) {
                Ok(mut file) => {
                    let _ = file.write_all(b"locked");
                    return Ok(Self {
                        path: path.to_path_buf(),
                        _file: file,
                    });
                }
                Err(err) if err.kind() == ErrorKind::AlreadyExists => {
                    std::thread::sleep(Duration::from_millis(LOCK_RETRY_MS));
                }
                Err(err) => {
                    return Err(err).with_context(|| {
                        format!("failed to acquire socks5 proxy lock: {}", path.display())
                    });
                }
            }
        }
    }
}

impl Drop for ProxyPoolLock {
    fn drop(&mut self) {
        let _ = fs::remove_file(&self.path);
    }
}

pub fn resolve_socks5_proxy_for_opts(
    opts: &HashMap<String, String>,
) -> Result<Option<SelectedSocks5Proxy>> {
    let entries = load_proxy_entries(opts)?;
    if entries.is_empty() {
        return Ok(None);
    }

    let state_path = proxy_pool_state_path(opts, &entries[0].source);
    if let Some(parent) = state_path.parent() {
        fs::create_dir_all(parent).with_context(|| {
            format!(
                "failed to create socks5 proxy state dir: {}",
                parent.display()
            )
        })?;
    }
    let lock_path = state_path.with_extension("lock");
    let _lock = ProxyPoolLock::acquire(&lock_path)?;

    let mut state = read_state(&state_path)?;
    let index = state.next_index % entries.len();
    let entry = entries[index].clone();
    state.total_selections += 1;
    state.next_index = (index + 1) % entries.len();
    write_state(&state_path, &state)?;

    Ok(Some(SelectedSocks5Proxy {
        entry,
        state_path,
        selection_index: state.total_selections,
        pool_size: entries.len(),
    }))
}

pub fn build_reqwest_client(
    timeout: Duration,
    http1_only: bool,
    proxy: Option<&SelectedSocks5Proxy>,
) -> Result<Client> {
    let mut builder = Client::builder().timeout(timeout);
    if http1_only {
        builder = builder.http1_only();
    }
    if let Some(proxy) = proxy {
        builder = builder.proxy(proxy.to_reqwest_proxy()?);
    }
    builder
        .build()
        .context("failed to build reqwest client with socks5 settings")
}

fn load_proxy_entries(opts: &HashMap<String, String>) -> Result<Vec<Socks5ProxyEntry>> {
    if let Some(raw) = opts
        .get("--socks5-proxy")
        .map(String::as_str)
        .filter(|value| !value.trim().is_empty())
    {
        return Ok(vec![parse_proxy_entry(raw, 1, "cli_inline".to_string())?]);
    }
    if let Ok(raw) = std::env::var("RNIDBG_SOCKS5_PROXY") {
        if !raw.trim().is_empty() {
            return Ok(vec![parse_proxy_entry(&raw, 1, "env_inline".to_string())?]);
        }
    }

    let pool_file = opts
        .get("--socks5-proxy-pool-file")
        .cloned()
        .or_else(|| std::env::var("RNIDBG_SOCKS5_PROXY_POOL_FILE").ok())
        .map(PathBuf::from)
        .or_else(default_proxy_pool_file);

    let Some(pool_file) = pool_file else {
        return Ok(Vec::new());
    };
    if !pool_file.is_file() {
        return Ok(Vec::new());
    }

    let content = fs::read_to_string(&pool_file).with_context(|| {
        format!(
            "failed to read socks5 proxy pool file: {}",
            pool_file.display()
        )
    })?;
    let mut entries = Vec::new();
    for (index, line) in content.lines().enumerate() {
        let trimmed = line.trim();
        if trimmed.is_empty() || trimmed.starts_with('#') {
            continue;
        }
        entries.push(parse_proxy_entry(
            trimmed,
            index + 1,
            pool_file.display().to_string(),
        )?);
    }
    Ok(entries)
}

fn parse_proxy_entry(raw: &str, line_number: usize, source: String) -> Result<Socks5ProxyEntry> {
    let parts = raw.splitn(4, ':').collect::<Vec<_>>();
    if parts.len() != 4 {
        return Err(anyhow!(
            "invalid socks5 proxy entry at {}:{} (expected host:port:user:pass)",
            source,
            line_number
        ));
    }
    Ok(Socks5ProxyEntry {
        host: parts[0].trim().to_string(),
        port: parts[1]
            .trim()
            .parse::<u16>()
            .with_context(|| format!("invalid socks5 proxy port at {}:{}", source, line_number))?,
        username: parts[2].trim().to_string(),
        password: parts[3].trim().to_string(),
        line_number,
        source,
    })
}

fn default_proxy_pool_file() -> Option<PathBuf> {
    let repo_root = PathBuf::from(env!("CARGO_MANIFEST_DIR"));
    let path = repo_root.join(DEFAULT_PROXY_POOL_FILE);
    if path.is_file() {
        Some(path)
    } else {
        None
    }
}

fn proxy_pool_state_path(opts: &HashMap<String, String>, source: &str) -> PathBuf {
    if let Some(path) = opts
        .get("--socks5-proxy-state-file")
        .filter(|value| !value.trim().is_empty())
    {
        return PathBuf::from(path);
    }
    if let Ok(path) = std::env::var("RNIDBG_SOCKS5_PROXY_STATE_FILE") {
        if !path.trim().is_empty() {
            return PathBuf::from(path);
        }
    }
    let repo_root = PathBuf::from(env!("CARGO_MANIFEST_DIR"));
    let source_name = Path::new(source)
        .file_name()
        .and_then(|value| value.to_str())
        .unwrap_or("boss_socks5_pool");
    repo_root
        .join(".local")
        .join("proxy-state")
        .join(format!("{source_name}.state.json"))
}

fn read_state(path: &Path) -> Result<ProxyPoolState> {
    if !path.is_file() {
        return Ok(ProxyPoolState::default());
    }
    let content = fs::read_to_string(path)
        .with_context(|| format!("failed to read socks5 proxy state: {}", path.display()))?;
    match serde_json::from_str::<ProxyPoolState>(&content) {
        Ok(state) => Ok(state),
        Err(_) => Ok(ProxyPoolState::default()),
    }
}

fn write_state(path: &Path, state: &ProxyPoolState) -> Result<()> {
    let payload =
        serde_json::to_vec_pretty(state).context("failed to serialize socks5 proxy state")?;
    fs::write(path, payload)
        .with_context(|| format!("failed to write socks5 proxy state: {}", path.display()))
}

fn preview_secret(value: &str) -> String {
    let text = value.trim();
    if text.len() <= 6 {
        return "*".repeat(text.len().max(1));
    }
    format!("{}…{}", &text[..4], &text[text.len() - 2..])
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn parse_proxy_entry_reads_expected_fields() {
        let entry = parse_proxy_entry(
            "geo.iproyal.com:12321:user_name:pass_word",
            2,
            "inline".to_string(),
        )
        .unwrap();
        assert_eq!(entry.host, "geo.iproyal.com");
        assert_eq!(entry.port, 12321);
        assert_eq!(entry.username, "user_name");
        assert_eq!(entry.password, "pass_word");
        assert_eq!(entry.line_number, 2);
    }
}
