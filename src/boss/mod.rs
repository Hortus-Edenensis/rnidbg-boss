use std::collections::HashMap;
use std::path::PathBuf;

use anyhow::{anyhow, Result};

pub mod http_bridge;
pub mod private_info;
pub mod qr_login;
pub mod yzwg;

pub use yzwg::BossYzwgLab;

pub fn run(mut args: Vec<String>) -> Result<()> {
    if args.is_empty() {
        print_usage();
        return Ok(());
    }

    let command = args.remove(0);
    let opts = parse_options(&args);
    match command.as_str() {
        "help" | "--help" | "-h" => {
            print_usage();
            return Ok(());
        }
        "private-info" | "profile" => {
            let output = private_info::run_private_info(&opts)?;
            println!("{}", serde_json::to_string_pretty(&output)?);
            return Ok(());
        }
        "qr-serve" => return qr_login::run_qr_serve(&opts),
        "qr-consume" => {
            let output = qr_login::run_qr_consume(&opts)?;
            println!("{}", serde_json::to_string_pretty(&output)?);
            return Ok(());
        }
        _ => {}
    }

    let config_path = PathBuf::from(
        opts.get("--config")
            .cloned()
            .unwrap_or_else(default_config_path),
    );
    let mut lab = yzwg::BossYzwgLab::load_with_backend(
        &config_path,
        opts.get("--backend").map(String::as_str),
    )?;
    let output = match command.as_str() {
        "smoke" => lab.run_smoke()?,
        "trace" => lab.run_trace(&opts)?,
        "invoke" => lab.run_invoke(&opts)?,
        "replay" => lab.run_replay(&opts)?,
        _ => return Err(anyhow!("unknown boss-yzwg command: {command}")),
    };

    println!("{}", serde_json::to_string_pretty(&output)?);
    Ok(())
}

pub fn serve_http_bridge(args: Vec<String>) -> Result<()> {
    let opts = parse_options(&args);
    let config_path = PathBuf::from(
        opts.get("--config")
            .cloned()
            .unwrap_or_else(default_config_path),
    );
    let port = opts
        .get("--port")
        .map(|value| value.parse::<u16>())
        .transpose()?
        .unwrap_or(18080);
    http_bridge::serve(config_path, port, opts.get("--backend").map(String::as_str))
}

pub fn print_usage() {
    eprintln!("boss-yzwg commands:");
    eprintln!("  smoke   [--config <path>] [--backend <auto|dynarmic|unicorn>]");
    eprintln!("  trace   [--config <path>] [--backend <auto|dynarmic|unicorn>] [--method-filter <method|all>] [--lookup <path>]");
    eprintln!(
        "  invoke  [--config <path>] [--backend <auto|dynarmic|unicorn>] --method <name> --arg1 <utf8|hex:...> [--arg2 <key>] [--dump-rc4 true]"
    );
    eprintln!("  replay  [--config <path>] [--backend <auto|dynarmic|unicorn>] [--lookup <path>] [--limit <N>] [--mode <sp|sig|both>]");
    eprintln!(
        "  private-info|profile [--session-path <path>] [--host <host>] [--city-code <code>] [--user-id <id>] [--sub-location <id>] [--config <path>] [--backend <auto|dynarmic|unicorn>] [--invoke-runtime <auto|local|bridge>] [--bridge-url <url>] [--transport-runtime <auto|direct|okhttp-bridge>] [--okhttp-bridge-url <url>] [--http1-only true] [--out <path>] [--force-so true]"
    );
    eprintln!(
        "  qr-serve    [--host <addr>] [--port <port>] [--edit-type <type>] [--action-id <id>] [--extra-info <text>]"
    );
    eprintln!(
        "  qr-consume  --producer-id <id> [--base-url <url>] [--login-type <1|2>] [--session-path <path>]"
    );
}

pub fn default_config_path() -> String {
    if let Ok(path) = std::env::var("RNIDBG_LAB_CONFIG") {
        return path;
    }

    for candidate in [
        "config/lab-config.json",
        "config/lab-config.container.json",
        "/workspace/rnidbg/config/lab-config.container.json",
    ] {
        if PathBuf::from(candidate).exists() {
            return candidate.to_string();
        }
    }

    "config/lab-config.container.json".to_string()
}

fn parse_options(args: &[String]) -> HashMap<String, String> {
    let mut opts = HashMap::new();
    let mut index = 0;
    while index < args.len() {
        let current = &args[index];
        if current.starts_with("--") {
            if index + 1 < args.len() && !args[index + 1].starts_with("--") {
                opts.insert(current.clone(), args[index + 1].clone());
                index += 2;
            } else {
                opts.insert(current.clone(), "true".to_string());
                index += 1;
            }
        } else {
            opts.insert(format!("_{index}"), current.clone());
            index += 1;
        }
    }
    opts
}
