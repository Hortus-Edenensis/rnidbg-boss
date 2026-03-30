use std::collections::{BTreeMap, HashMap};
use std::path::{Path, PathBuf};
use std::process::{Command, Output, Stdio};
use std::time::Duration;

use anyhow::{anyhow, Context, Result};
use base64::engine::general_purpose::URL_SAFE;
use base64::Engine as _;
use reqwest::blocking::Client;
use reqwest::header::{HeaderMap, HeaderName, HeaderValue};
use reqwest::{Url, Version};
use serde_json::{json, Value};

use super::proxy_pool::{build_reqwest_client, resolve_socks5_proxy_for_opts, SelectedSocks5Proxy};
use super::qr_login::{build_stage_inbound_headers, load_session, DeviceConfig, SessionConfig};
use super::yzwg::{compiled_backend_names, LabConfig};

const USER_AGENT: &str = concat!(
    "Mozilla/5.0 (Linux; Android 14; RMX3560 Build/UP1A.231005.007; wv) ",
    "AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/118.0.0.0 ",
    "Mobile Safari/537.36 BossZhipin/14.010"
);
const APP_VERSION: &str = "14.010";
const APP_VERSION_CODE: &str = "1401010";
const APP_ID: &str = "1003";
const OS_NAME: &str = "Android";
const OS_VERSION: &str = "34";
const APP_CHANNEL: &str = "15";
const ABI: i32 = 1;
const SP_TRUNCATE_THRESHOLD: usize = 5000;
const DEFAULT_HOST: &str = "https://api.zhipin.com";
const ALT_HOST: &str = "https://api5.zhipin.com";
const DEFAULT_TIMEOUT_SECONDS: u64 = 30;
const DEFAULT_HTTP_BRIDGE_URL: &str = "http://127.0.0.1:28080";
const BOSS_APK_OKHTTP_TIMEOUT_SECONDS: u64 = 60;
const DEFAULT_CITY_CODE: &str = "101010100";
const USER_ACCOUNT_GEEK_BATCH_PATH: &str = "batch/batchRunV2";
const USER_ACCOUNT_GEEK_BASEINFO_METHOD: &str = "zpgeek.cvapp.geek.baseinfo.query";
const BZP_BODY_MAGIC: &[u8; 8] = b"BZPBlock";
const BZP_BODY_HEADER_SIZE: usize = 24;
const USER_ACCOUNT_GEEK_BATCH_METHODS: &[&str] = &[
    "zpgeek.app.bluecollar.topic.banner.v2",
    "zpuser.user.getBottomBtns",
    "zpuser.dynamicBar.get",
    "zpgeek.cvapp.f1.tab.config",
    "zpgeek.app.geek.common.config",
    USER_ACCOUNT_GEEK_BASEINFO_METHOD,
    "zpp.app.user.unBzbOrderList",
    "zpitemGeek.geek.vip.info",
    "zpuser.user.check",
    "zpgeek.app.interaction.query",
    "zpitemGeek.geek.getItemMallF4",
    "zpapptips.app.tip.f4.query",
    "zpgeek.app.geek.expectposition.suggest.reddot.query",
    "certification.security.get",
    "zpgeek.app.student.feature.query",
    "zpgeek.app.studentparttime.topic.banner.v2",
    "zpgeek.cvapp.identity.switch.entrance",
    "zpchat.wechat.get.WxNotify.commonSetting",
];
const ANALYSIS_ROOT: &str =
    "/Users/haojiejack/github/drizzle-dumper-rust/boss_purecalc/analysis/2026-03-14-private-info-runtime";
const MONITOR_REPORT: &str =
    "/Users/haojiejack/github/drizzle-dumper-rust/boss_purecalc/private_info_runtime_monitor.py";

#[derive(Clone, Copy)]
enum RequestContract {
    Direct,
    UserAccountGeekBatch,
}

struct EndpointSpec {
    family: &'static str,
    name: &'static str,
    path: &'static str,
    contract: RequestContract,
}

const ENDPOINTS: &[EndpointSpec] = &[
    EndpointSpec {
        family: "legacy_geek",
        name: "getGeekInfo",
        path: "zpgeek/geek/getGeekInfo",
        contract: RequestContract::Direct,
    },
    EndpointSpec {
        family: "legacy_geek",
        name: "getExpectedPosition",
        path: "zpgeek/geek/getExpectedPosition",
        contract: RequestContract::Direct,
    },
    EndpointSpec {
        family: "java_cvapp",
        name: "getGeekInfo",
        path: "zpgeek/cvapp/geek/baseinfo/query",
        contract: RequestContract::UserAccountGeekBatch,
    },
    EndpointSpec {
        family: "java_cvapp",
        name: "getExpectedPosition",
        path: "zpgeek/cvapp/geek/expectposition/config",
        contract: RequestContract::Direct,
    },
];

#[derive(Clone, Debug)]
struct RequestAlignmentContext {
    city_code: Option<String>,
    city_code_source: &'static str,
    sub_location: String,
    user_id: String,
}

impl RequestAlignmentContext {
    fn from_opts(opts: &HashMap<String, String>) -> Self {
        let city_code = opts
            .get("--city-code")
            .cloned()
            .or_else(|| std::env::var("RNIDBG_BOSS_CITY_CODE").ok())
            .map(|value| value.trim().to_string())
            .filter(|value| !value.is_empty());
        Self {
            city_code_source: if city_code.is_some() {
                "cli_or_env"
            } else {
                "default"
            },
            city_code,
            sub_location: normalized_numeric_opt(opts.get("--sub-location"), "0"),
            user_id: normalized_numeric_opt(opts.get("--user-id"), "0"),
        }
    }

    fn city_code_for_expect_position(&self) -> String {
        self.city_code
            .as_deref()
            .filter(|value| !value.trim().is_empty())
            .unwrap_or(DEFAULT_CITY_CODE)
            .to_string()
    }

    fn observe_response(&mut self, endpoint: &EndpointSpec, response: Option<&Value>) {
        if self.city_code.is_some() {
            return;
        }
        let Some(response) = response else {
            return;
        };
        if let Some(city_code) = extract_city_code_from_response(response) {
            self.city_code = Some(city_code);
            self.city_code_source = match endpoint.name {
                "getGeekInfo" => "geek_detail_response",
                _ => "response",
            };
        }
    }

    fn describe(&self) -> Value {
        json!({
            "city_code": self.city_code_for_expect_position(),
            "city_code_source": self.city_code_source,
            "user_id": self.user_id,
            "sub_location": self.sub_location,
        })
    }
}

struct PreparedRequest {
    request_path: String,
    signing_params: BTreeMap<String, String>,
    clear_params: BTreeMap<String, String>,
    unsigned_params: BTreeMap<String, String>,
    batch_response_key: Option<&'static str>,
    batch_method_feed: Option<String>,
}

fn session_only_supported(endpoint: &EndpointSpec) -> bool {
    matches!(endpoint.contract, RequestContract::Direct)
}

pub fn run_private_info(opts: &HashMap<String, String>) -> Result<Value> {
    let session_path = opts.get("--session-path").map(String::as_str);
    let output_path = resolve_output_path(opts.get("--out").map(String::as_str));
    let config_path = PathBuf::from(
        opts.get("--config")
            .cloned()
            .unwrap_or_else(super::default_config_path),
    );
    let lab_config = LabConfig::load(&config_path)?
        .with_backend_override(opts.get("--backend").map(String::as_str))?;
    let hosts = build_host_candidates(opts.get("--host").map(String::as_str));
    let session = load_session(session_path)?;
    let device = DeviceConfig::from_session(&session);
    let requested_backend = lab_config.backend.clone();
    let default_native_invoker = json!({
        "status": "not_used",
        "requested_backend": requested_backend.clone(),
        "compiled_backends": compiled_backend_names(),
    });
    let transport_runtime =
        TransportRuntime::parse(opts.get("--transport-runtime").map(String::as_str))?;
    let http1_only = parse_bool_flag(opts, "--http1-only");
    let direct_proxy = resolve_socks5_proxy_for_opts(opts)?;
    let client = build_reqwest_client(
        Duration::from_secs(DEFAULT_TIMEOUT_SECONDS),
        http1_only,
        direct_proxy.as_ref(),
    )?;
    let direct_transport = DirectRequestTransport::new(client, direct_proxy);
    let okhttp_bridge = OkHttpBridgeTransport::discover(transport_runtime, &lab_config, opts)?;
    let okhttp_bridge_meta = okhttp_bridge
        .as_ref()
        .map(OkHttpBridgeTransport::describe)
        .unwrap_or_else(|| {
            json!({
                "status": "unavailable",
                "transport_runtime": "okhttp_bridge",
            })
        });

    let mut endpoint_results = serde_json::Map::new();
    let mut any_success = false;
    let mut request_alignment = RequestAlignmentContext::from_opts(opts);
    let force_so = opts
        .get("--force-so")
        .map(|value| value.eq_ignore_ascii_case("true"))
        .unwrap_or(false);
    let mut so_invoker: Option<RnIdbgSoInvoker> = None;

    for endpoint in ENDPOINTS {
        let mut attempts = Vec::new();
        let mut success_payload: Option<Value> = None;

        if !force_so && transport_runtime.allows_direct() && session_only_supported(endpoint) {
            for host in &hosts {
                let attempt = match request_private_info(
                    RequestTransport::Direct(&direct_transport),
                    RequestMode::SessionOnly,
                    host,
                    endpoint,
                    &device,
                    &session,
                    &request_alignment,
                    None,
                    None,
                ) {
                    Ok(attempt) => attempt,
                    Err(err) => attempt_error(
                        RequestMode::SessionOnly,
                        host,
                        endpoint,
                        Some(RequestTransport::Direct(&direct_transport).label()),
                        None,
                        &format!("{err:#}"),
                    ),
                };
                let ok = response_is_success(attempt.get("response"));
                request_alignment.observe_response(endpoint, attempt.get("response"));
                attempts.push(attempt);
                if ok {
                    success_payload = attempts.last().cloned();
                    any_success = true;
                    break;
                }
            }
        }

        if success_payload.is_none() && !force_so && session_only_supported(endpoint) {
            if let Some(bridge) = okhttp_bridge.as_ref() {
                for host in &hosts {
                    let attempt = match request_private_info(
                        RequestTransport::OkHttpBridge(bridge),
                        RequestMode::SessionOnly,
                        host,
                        endpoint,
                        &device,
                        &session,
                        &request_alignment,
                        None,
                        None,
                    ) {
                        Ok(attempt) => attempt,
                        Err(err) => attempt_error(
                            RequestMode::SessionOnly,
                            host,
                            endpoint,
                            Some(RequestTransport::OkHttpBridge(bridge).label()),
                            None,
                            &format!("{err:#}"),
                        ),
                    };
                    let ok = response_is_success(attempt.get("response"));
                    request_alignment.observe_response(endpoint, attempt.get("response"));
                    attempts.push(attempt);
                    if ok {
                        success_payload = attempts.last().cloned();
                        any_success = true;
                        break;
                    }
                }
            }
        }

        if success_payload.is_none() && transport_runtime.allows_direct() {
            if so_invoker.is_none() {
                so_invoker = Some(RnIdbgSoInvoker::new(
                    config_path.clone(),
                    &lab_config,
                    opts,
                )?);
            }
            let secret_candidates = secret_key_candidates_for_endpoint(&session, endpoint);
            for host in &hosts {
                for secret_key in &secret_candidates {
                    let key_mode = if secret_key.is_empty() {
                        "empty"
                    } else {
                        "secret"
                    };
                    let attempt = match request_private_info(
                        RequestTransport::Direct(&direct_transport),
                        RequestMode::RnIdbgSo,
                        host,
                        endpoint,
                        &device,
                        &session,
                        &request_alignment,
                        so_invoker.as_ref(),
                        Some(secret_key),
                    ) {
                        Ok(attempt) => attempt,
                        Err(err) => attempt_error(
                            RequestMode::RnIdbgSo,
                            host,
                            endpoint,
                            Some(RequestTransport::Direct(&direct_transport).label()),
                            Some(key_mode),
                            &format!("{err:#}"),
                        ),
                    };
                    let ok = response_is_success(attempt.get("response"));
                    request_alignment.observe_response(endpoint, attempt.get("response"));
                    attempts.push(attempt);
                    if ok {
                        success_payload = attempts.last().cloned();
                        any_success = true;
                        break;
                    }
                }
                if success_payload.is_some() {
                    break;
                }
            }
        }

        if success_payload.is_none() {
            if let Some(bridge) = okhttp_bridge.as_ref() {
                if so_invoker.is_none() {
                    so_invoker = Some(RnIdbgSoInvoker::new(
                        config_path.clone(),
                        &lab_config,
                        opts,
                    )?);
                }
                let secret_candidates = secret_key_candidates_for_endpoint(&session, endpoint);
                for host in &hosts {
                    for secret_key in &secret_candidates {
                        let key_mode = if secret_key.is_empty() {
                            "empty"
                        } else {
                            "secret"
                        };
                        let attempt = match request_private_info(
                            RequestTransport::OkHttpBridge(bridge),
                            RequestMode::RnIdbgSo,
                            host,
                            endpoint,
                            &device,
                            &session,
                            &request_alignment,
                            so_invoker.as_ref(),
                            Some(secret_key),
                        ) {
                            Ok(attempt) => attempt,
                            Err(err) => attempt_error(
                                RequestMode::RnIdbgSo,
                                host,
                                endpoint,
                                Some(RequestTransport::OkHttpBridge(bridge).label()),
                                Some(key_mode),
                                &format!("{err:#}"),
                            ),
                        };
                        let ok = response_is_success(attempt.get("response"));
                        request_alignment.observe_response(endpoint, attempt.get("response"));
                        attempts.push(attempt);
                        if ok {
                            success_payload = attempts.last().cloned();
                            any_success = true;
                            break;
                        }
                    }
                    if success_payload.is_some() {
                        break;
                    }
                }
            }
        }

        let conclusion = success_payload
            .as_ref()
            .map(|payload| {
                json!({
                    "status": "success",
                    "mode": payload.get("mode").cloned().unwrap_or(Value::Null),
                    "host": payload.get("host").cloned().unwrap_or(Value::Null),
                })
            })
            .unwrap_or_else(|| {
                let last_code = attempts
                    .last()
                    .and_then(|value| value.get("response"))
                    .and_then(|response| response_code(Some(response)))
                    .unwrap_or(-1);
                json!({
                    "status": "failed",
                    "last_code": last_code,
                    "reason": "request contract remains misaligned or an additional runtime/TLS gate is still active",
                })
            });

        endpoint_results.insert(
            format!("{}:{}", endpoint.family, endpoint.name),
            json!({
                "family": endpoint.family,
                "name": endpoint.name,
                "path": endpoint.path,
                "attempts": attempts,
                "result": success_payload.unwrap_or(Value::Null),
                "conclusion": conclusion,
            }),
        );
    }

    let result = json!({
        "status": if any_success { "ok" } else { "failed" },
        "session_path": resolved_session_path(session_path),
        "config_path": config_path,
        "requested_backend": requested_backend,
        "compiled_backends": compiled_backend_names(),
        "native_invoker": so_invoker
            .as_ref()
            .map(RnIdbgSoInvoker::describe)
            .unwrap_or(default_native_invoker),
        "transport_profile": {
            "direct_client": "reqwest+rustls",
            "runtime_policy": transport_runtime.as_str(),
            "http1_only": http1_only,
            "original_okhttp_available": okhttp_bridge.is_some(),
        },
        "okhttp_bridge": okhttp_bridge_meta,
        "analysis_refs": analysis_refs(),
        "session": {
            "uid": session.uid,
            "identity": session.identity,
            "token2_present": !session.token2.trim().is_empty(),
            "zp_at_present": !session.zp_at.trim().is_empty(),
            "secret_key_present": !session.secret_key.trim().is_empty(),
        },
        "device": {
            "uniqid": device.uniqid,
            "did": device.did,
            "oaid_present": !device.oaid.trim().is_empty(),
            "oaid_honor_present": !device.oaid_honor.trim().is_empty(),
            "brand": device.brand,
            "model": device.model,
            "network": device.network,
            "operator": device.operator,
            "tinker_id": device.tinker_id,
        },
        "request_alignment": request_alignment.describe(),
        "hosts": hosts,
        "endpoints": endpoint_results,
        "output_path": output_path,
    });

    std::fs::write(&output_path, serde_json::to_vec_pretty(&result)?).with_context(|| {
        format!(
            "failed to write private-info result: {}",
            output_path.display()
        )
    })?;

    Ok(result)
}

#[derive(Clone, Copy)]
enum RequestMode {
    SessionOnly,
    RnIdbgSo,
}

impl RequestMode {
    fn as_str(self) -> &'static str {
        match self {
            Self::SessionOnly => "session_only",
            Self::RnIdbgSo => "rnidbg_so",
        }
    }
}

#[derive(Clone, Copy)]
enum InvokeRuntime {
    Auto,
    Local,
    Bridge,
}

impl InvokeRuntime {
    fn parse(value: Option<&str>) -> Result<Self> {
        match value.unwrap_or("auto").trim().to_ascii_lowercase().as_str() {
            "" | "auto" => Ok(Self::Auto),
            "local" => Ok(Self::Local),
            "bridge" | "docker" => Ok(Self::Bridge),
            other => Err(anyhow!("unsupported invoke runtime: {other}")),
        }
    }
}

#[derive(Clone, Copy)]
enum TransportRuntime {
    Auto,
    Direct,
    OkHttpBridge,
}

impl TransportRuntime {
    fn parse(value: Option<&str>) -> Result<Self> {
        match value.unwrap_or("auto").trim().to_ascii_lowercase().as_str() {
            "" | "auto" => Ok(Self::Auto),
            "direct" => Ok(Self::Direct),
            "okhttp-bridge" | "okhttp_bridge" | "okhttp" => Ok(Self::OkHttpBridge),
            other => Err(anyhow!("unsupported transport runtime: {other}")),
        }
    }

    fn as_str(self) -> &'static str {
        match self {
            Self::Auto => "auto",
            Self::Direct => "direct",
            Self::OkHttpBridge => "okhttp_bridge",
        }
    }

    fn allows_direct(self) -> bool {
        !matches!(self, Self::OkHttpBridge)
    }
}

#[derive(Clone, Copy)]
enum RequestTransport<'a> {
    Direct(&'a DirectRequestTransport),
    OkHttpBridge(&'a OkHttpBridgeTransport),
}

impl<'a> RequestTransport<'a> {
    fn label(self) -> &'static str {
        match self {
            Self::Direct(_) => "direct",
            Self::OkHttpBridge(_) => "okhttp_bridge",
        }
    }
}

struct DirectRequestTransport {
    client: Client,
    proxy: Option<SelectedSocks5Proxy>,
}

impl DirectRequestTransport {
    fn new(client: Client, proxy: Option<SelectedSocks5Proxy>) -> Self {
        Self { client, proxy }
    }

    fn proxy_description(&self) -> Value {
        self.proxy
            .as_ref()
            .map(SelectedSocks5Proxy::describe)
            .unwrap_or(Value::Null)
    }
}

fn parse_bool_flag(opts: &HashMap<String, String>, key: &str) -> bool {
    opts.get(key)
        .map(|value| value.eq_ignore_ascii_case("true"))
        .unwrap_or(false)
}

fn local_binary_supports_backend(requested_backend: &str) -> bool {
    match requested_backend.trim().to_ascii_lowercase().as_str() {
        "" | "auto" => true,
        "dynarmic" => cfg!(feature = "dynarmic"),
        "unicorn" | "unicorn2" => cfg!(feature = "unicorn"),
        _ => false,
    }
}

fn local_process_usable(lab_config: &LabConfig) -> bool {
    local_binary_supports_backend(&lab_config.backend)
        && lab_config.apk_path.is_file()
        && lab_config.so_path.is_file()
        && lab_config.asset_sign_encrypt_path.is_file()
}

fn attach_transport(mut payload: Value, transport: Value) -> Value {
    if let Some(object) = payload.as_object_mut() {
        object.insert("transport".to_string(), transport);
        return payload;
    }
    json!({
        "payload": payload,
        "transport": transport,
    })
}

fn http_version_label(version: Version) -> &'static str {
    match version {
        Version::HTTP_09 => "HTTP/0.9",
        Version::HTTP_10 => "HTTP/1.0",
        Version::HTTP_11 => "HTTP/1.1",
        Version::HTTP_2 => "HTTP/2",
        Version::HTTP_3 => "HTTP/3",
        _ => "unknown",
    }
}

fn headers_to_json(headers: &reqwest::header::HeaderMap) -> Value {
    let mut object = serde_json::Map::new();
    for (name, value) in headers {
        object.insert(
            name.as_str().to_string(),
            Value::String(value.to_str().unwrap_or_default().to_string()),
        );
    }
    Value::Object(object)
}

fn normalize_bridge_url(url: &str) -> Result<String> {
    let parsed = Url::parse(url).with_context(|| format!("invalid bridge url: {url}"))?;
    let mut host = parsed
        .host_str()
        .ok_or_else(|| anyhow!("bridge url missing host: {url}"))?;
    let port = parsed
        .port_or_known_default()
        .ok_or_else(|| anyhow!("bridge url missing port: {url}"))?;
    if std::env::var("RNIDBG_CONTAINER_REPO_ROOT").is_ok() && host == "127.0.0.1" && port == 28080 {
        host = "host.docker.internal";
    }
    Ok(format!("{}://{}:{}", parsed.scheme(), host, port))
}

fn ensure_http_bridge_ready(base_url: &str, lab_config: &LabConfig) -> Result<()> {
    if http_bridge_health(base_url)?.is_some() {
        return Ok(());
    }

    if !base_url.starts_with(DEFAULT_HTTP_BRIDGE_URL) {
        return Err(anyhow!(
            "rnidbg http bridge is not reachable at {base_url}; start it first or pass --invoke-runtime local"
        ));
    }

    start_local_http_bridge(lab_config, base_url)?;
    if http_bridge_health(base_url)?.is_some() {
        return Ok(());
    }

    Err(anyhow!(
        "rnidbg http bridge did not become healthy at {base_url} after startup"
    ))
}

fn http_bridge_health(base_url: &str) -> Result<Option<Value>> {
    let url = format!("{}/health", base_url.trim_end_matches('/'));
    let client = Client::builder()
        .timeout(Duration::from_secs(3))
        .build()
        .context("failed to build bridge health client")?;
    match client.get(&url).send() {
        Ok(response) if response.status().is_success() => {
            let payload: Value = response
                .json()
                .with_context(|| format!("failed to parse http bridge health payload: {url}"))?;
            Ok(Some(payload))
        }
        Ok(_) => Ok(None),
        Err(_) => Ok(None),
    }
}

fn start_local_http_bridge(lab_config: &LabConfig, base_url: &str) -> Result<()> {
    let script = resolve_repo_root().join("bin/start-http-bridge.sh");
    if !script.is_file() {
        return Err(anyhow!(
            "bridge bootstrap script not found: {}",
            script.display()
        ));
    }

    let port = Url::parse(base_url)
        .ok()
        .and_then(|url| url.port_or_known_default())
        .unwrap_or(28080);
    let repo_root = resolve_repo_root();
    let mut command = Command::new(&script);
    command.env("RNIDBG_REPO_ROOT", &repo_root);
    command.env("RNIDBG_HTTP_PORT", port.to_string());
    command.env(
        "RNIDBG_LAB_CONFIG",
        "/workspace/rnidbg/config/lab-config.container.json",
    );
    if let Some(assets_root) = detect_assets_root(lab_config) {
        command.env("RNIDBG_ASSETS_ROOT", assets_root);
    }

    let output = command.output().with_context(|| {
        format!(
            "failed to start rnidbg http bridge via {}",
            script.display()
        )
    })?;
    if !output.status.success() {
        let stderr = String::from_utf8_lossy(&output.stderr).to_string();
        let stdout = String::from_utf8_lossy(&output.stdout).to_string();
        return Err(anyhow!(
            "failed to start rnidbg http bridge: status={:?}, stderr={}, stdout={}",
            output.status.code(),
            truncate(&stderr, 1200),
            truncate(&stdout, 1200),
        ));
    }
    Ok(())
}

fn resolve_repo_root() -> PathBuf {
    PathBuf::from(env!("CARGO_MANIFEST_DIR"))
}

fn detect_assets_root(lab_config: &LabConfig) -> Option<PathBuf> {
    if let Some(path) = std::env::var_os("RNIDBG_ASSETS_ROOT") {
        return Some(PathBuf::from(path));
    }

    for candidate in [
        &lab_config.apk_path,
        &lab_config.so_path,
        &lab_config.asset_sign_encrypt_path,
    ] {
        for ancestor in candidate.ancestors() {
            if ancestor.file_name().and_then(|value| value.to_str()) == Some("drizzle-dumper-rust")
            {
                return Some(ancestor.to_path_buf());
            }
        }
    }
    None
}

enum OkHttpBridgeTransport {
    Remote(RemoteOkHttpBridgeTransport),
    BossApk(BossApkOkHttpTransport),
}

impl OkHttpBridgeTransport {
    fn discover(
        mode: TransportRuntime,
        lab_config: &LabConfig,
        opts: &HashMap<String, String>,
    ) -> Result<Option<Self>> {
        let configured_url = opts
            .get("--okhttp-bridge-url")
            .cloned()
            .or_else(|| std::env::var("RNIDBG_OKHTTP_BRIDGE_URL").ok())
            .filter(|value| !value.trim().is_empty());

        match mode {
            TransportRuntime::Direct => Ok(None),
            TransportRuntime::OkHttpBridge => {
                if let Some(configured_url) = configured_url {
                    let base_url = normalize_bridge_url(&configured_url)?;
                    Ok(Some(Self::Remote(RemoteOkHttpBridgeTransport::connect(
                        &base_url,
                    )?)))
                } else {
                    Ok(Some(Self::BossApk(BossApkOkHttpTransport::new(
                        lab_config, opts,
                    )?)))
                }
            }
            TransportRuntime::Auto => {
                let Some(configured_url) = configured_url else {
                    return Ok(None);
                };
                let base_url = normalize_bridge_url(&configured_url)?;
                Ok(Some(Self::Remote(RemoteOkHttpBridgeTransport::connect(
                    &base_url,
                )?)))
            }
        }
    }

    fn describe(&self) -> Value {
        match self {
            Self::Remote(transport) => transport.describe(),
            Self::BossApk(transport) => transport.describe(),
        }
    }

    fn request_get(
        &self,
        url: &str,
        headers: &HashMap<String, String>,
        so_invoker: Option<&RnIdbgSoInvoker>,
        session_secret_key: &str,
    ) -> Result<Value> {
        match self {
            Self::Remote(transport) => {
                transport.request_get(url, headers, so_invoker, session_secret_key)
            }
            Self::BossApk(transport) => {
                transport.request_get(url, headers, so_invoker, session_secret_key)
            }
        }
    }
}

struct RemoteOkHttpBridgeTransport {
    base_url: String,
    health: Value,
    client: Client,
}

impl RemoteOkHttpBridgeTransport {
    fn connect(base_url: &str) -> Result<Self> {
        if let Some(health) = okhttp_bridge_health(base_url)? {
            return Ok(Self::new(base_url.to_string(), health)?);
        }

        Err(anyhow!(
            "original OkHttp bridge is not reachable at {base_url}; start the Boss-side bridge first or pass --transport-runtime direct"
        ))
    }

    fn new(base_url: String, health: Value) -> Result<Self> {
        Ok(Self {
            base_url,
            health,
            client: Client::builder()
                .timeout(Duration::from_secs(DEFAULT_TIMEOUT_SECONDS))
                .build()
                .context("failed to build okhttp-bridge client")?,
        })
    }

    fn describe(&self) -> Value {
        json!({
            "status": "ready",
            "transport_runtime": "okhttp_bridge",
            "base_url": self.base_url,
            "flow": "original_okhttp_remote",
            "health": self.health,
        })
    }

    fn request_get(
        &self,
        url: &str,
        headers: &HashMap<String, String>,
        so_invoker: Option<&RnIdbgSoInvoker>,
        session_secret_key: &str,
    ) -> Result<Value> {
        let request_url = format!("{}/request", self.base_url);
        let envelope = self
            .client
            .post(&request_url)
            .json(&json!({
                "method": "GET",
                "url": url,
                "headers": headers,
                "body": "",
                "body_b64": Value::Null,
            }))
            .send()
            .with_context(|| format!("failed to call okhttp bridge: {request_url}"))?;
        let payload: Value = envelope
            .json()
            .with_context(|| format!("failed to parse okhttp bridge response: {request_url}"))?;

        let status = payload.get("status").and_then(Value::as_u64).unwrap_or(0) as u16;
        let body = payload
            .get("body")
            .and_then(Value::as_str)
            .unwrap_or_default()
            .to_string();
        let transport = json!({
            "transport_runtime": "okhttp_bridge",
            "bridge_url": self.base_url,
            "bridge_flow": "original_okhttp_remote",
            "bridge_engine": self.health.get("engine").cloned().unwrap_or(Value::Null),
            "bridge_status": status,
        });

        if let Some(error) = payload.get("error").and_then(Value::as_str) {
            return Ok(json!({
                "code": -1,
                "message": format!("okhttp bridge error: {error}"),
                "transport": transport,
            }));
        }

        if let Some(value) = parse_response_body(&body, so_invoker, session_secret_key)? {
            return Ok(attach_transport(value, transport));
        }

        Ok(json!({
            "code": status,
            "message": format!("okhttp bridge returned non-json body (status={status})"),
            "raw": truncate(&body, 1200),
            "transport": transport,
        }))
    }
}

struct BossApkOkHttpTransport {
    apk_path: PathBuf,
    script_path: PathBuf,
    proxy: Option<SelectedSocks5Proxy>,
}

impl BossApkOkHttpTransport {
    fn new(lab_config: &LabConfig, opts: &HashMap<String, String>) -> Result<Self> {
        let script_path = resolve_repo_root().join("scripts/run-boss-apk-okhttp.sh");
        if !script_path.is_file() {
            return Err(anyhow!(
                "boss apk okhttp runner script not found: {}",
                script_path.display()
            ));
        }
        if !lab_config.apk_path.is_file() {
            return Err(anyhow!(
                "boss apk for okhttp extraction not found: {}",
                lab_config.apk_path.display()
            ));
        }
        Ok(Self {
            apk_path: lab_config.apk_path.clone(),
            script_path,
            proxy: resolve_socks5_proxy_for_opts(opts)?,
        })
    }

    fn describe(&self) -> Value {
        json!({
            "status": "ready",
            "transport_runtime": "okhttp_bridge",
            "flow": "boss_apk_okhttp",
            "apk_path": self.apk_path.display().to_string(),
            "proxy": self.proxy.as_ref().map(SelectedSocks5Proxy::describe).unwrap_or(Value::Null),
        })
    }

    fn request_get(
        &self,
        url: &str,
        headers: &HashMap<String, String>,
        so_invoker: Option<&RnIdbgSoInvoker>,
        session_secret_key: &str,
    ) -> Result<Value> {
        let mut command = Command::new(&self.script_path);
        command
            .arg("--apk")
            .arg(&self.apk_path)
            .arg("--method")
            .arg("GET")
            .arg("--url")
            .arg(url);
        for (key, value) in headers {
            command.arg("--header").arg(format!("{key}: {value}"));
        }
        if let Some(proxy) = &self.proxy {
            proxy.append_java_cli_args(&mut command);
        }

        let output = run_command_with_timeout(
            &mut command,
            Duration::from_secs(BOSS_APK_OKHTTP_TIMEOUT_SECONDS),
        )
        .with_context(|| {
            format!(
                "failed to execute boss apk okhttp runner: {}",
                self.script_path.display()
            )
        })?;
        if !output.status.success() {
            let stderr = String::from_utf8_lossy(&output.stderr).to_string();
            let stdout = String::from_utf8_lossy(&output.stdout).to_string();
            return Err(anyhow!(
                "boss apk okhttp runner failed: status={:?}, stderr={}, stdout={}",
                output.status.code(),
                truncate(&stderr, 1200),
                truncate(&stdout, 1200),
            ));
        }

        let payload: Value = serde_json::from_slice(&output.stdout)
            .context("failed to parse boss apk okhttp runner output")?;
        let status = payload.get("status").and_then(Value::as_u64).unwrap_or(0) as u16;
        let body = payload
            .get("body")
            .and_then(Value::as_str)
            .unwrap_or_default()
            .to_string();
        let transport = json!({
            "transport_runtime": "okhttp_bridge",
            "bridge_mode": "boss_apk_okhttp",
            "bridge_flow": "boss_apk_dex_extract",
            "apk_path": self.apk_path.display().to_string(),
            "bridge_engine": payload.get("engine").cloned().unwrap_or_else(|| Value::String("boss_apk_okhttp".to_string())),
            "bridge_status": status,
            "bridge_protocol": payload.get("protocol").cloned().unwrap_or(Value::Null),
            "bridge_message": payload.get("message").cloned().unwrap_or(Value::Null),
            "response_headers": payload.get("headers").cloned().unwrap_or(Value::Null),
        });

        if let Some(error) = payload.get("error").and_then(Value::as_str) {
            return Ok(json!({
                "code": -1,
                "message": format!("boss apk okhttp error: {error}"),
                "transport": transport,
            }));
        }

        if let Some(value) = parse_response_body(&body, so_invoker, session_secret_key)? {
            return Ok(attach_transport(value, transport));
        }

        Ok(json!({
            "code": status,
            "message": format!("boss apk okhttp returned non-json body (status={status})"),
            "raw": truncate(&body, 1200),
            "transport": transport,
        }))
    }
}

fn run_command_with_timeout(command: &mut Command, timeout: Duration) -> Result<Output> {
    command.stdout(Stdio::piped()).stderr(Stdio::piped());
    let mut child = command.spawn()?;
    let started = std::time::Instant::now();

    loop {
        if child.try_wait()?.is_some() {
            return child
                .wait_with_output()
                .context("failed to collect command output");
        }
        if started.elapsed() >= timeout {
            let _ = child.kill();
            let output = child
                .wait_with_output()
                .context("failed to collect timed out command output")?;
            let stderr = String::from_utf8_lossy(&output.stderr).to_string();
            let stdout = String::from_utf8_lossy(&output.stdout).to_string();
            return Err(anyhow!(
                "command timed out after {}s, stderr={}, stdout={}",
                timeout.as_secs(),
                truncate(&stderr, 1200),
                truncate(&stdout, 1200),
            ));
        }
        std::thread::sleep(Duration::from_millis(100));
    }
}

fn okhttp_bridge_health(base_url: &str) -> Result<Option<Value>> {
    let url = format!("{}/health", base_url.trim_end_matches('/'));
    let client = Client::builder()
        .timeout(Duration::from_secs(3))
        .build()
        .context("failed to build okhttp-bridge health client")?;
    match client.get(&url).send() {
        Ok(response) if response.status().is_success() => {
            let payload: Value = response
                .json()
                .with_context(|| format!("failed to parse okhttp bridge health payload: {url}"))?;
            if payload.get("ok") == Some(&Value::Bool(true)) {
                Ok(Some(payload))
            } else {
                Ok(None)
            }
        }
        Ok(_) => Ok(None),
        Err(_) => Ok(None),
    }
}

fn request_private_info(
    transport: RequestTransport<'_>,
    mode: RequestMode,
    host: &str,
    endpoint: &EndpointSpec,
    device: &DeviceConfig,
    session: &SessionConfig,
    request_alignment: &RequestAlignmentContext,
    so_invoker: Option<&RnIdbgSoInvoker>,
    secret_key: Option<&str>,
) -> Result<Value> {
    let req_time_ms = now_ms();
    let mut prepared = prepare_request(endpoint, device, request_alignment, req_time_ms);
    let traceid;
    let mut zp_tag = None;
    let final_query_params;

    if matches!(mode, RequestMode::RnIdbgSo) {
        let invoker =
            so_invoker.ok_or_else(|| anyhow!("rnidbg SO request requires initialized invoker"))?;
        traceid = build_traceid();
        let tag = invoker
            .encode_request(traceid.as_bytes(), "")
            .context("failed to build zp-tag via rnidbg so")?;
        zp_tag = Some(tag);

        let canonical = canonicalize_params(&prepared.signing_params);
        let effective_key = secret_key.unwrap_or_default();
        let sp = invoker
            .encode_request(canonical.as_bytes(), effective_key)
            .context("failed to build sp via rnidbg so")?;
        let sig_tail = truncate_for_sig(&canonical, SP_TRUNCATE_THRESHOLD);
        let sig_input = if matches!(endpoint.contract, RequestContract::UserAccountGeekBatch) {
            format!("/api/{}{}", prepared.request_path, sig_tail)
        } else {
            let crc = encoded_body_crc32(&sp)?;
            format!("/api/{}{}{}", prepared.request_path, sig_tail, crc)
        };
        let sig = invoker
            .signature(sig_input.as_bytes(), effective_key)
            .context("failed to build sig via rnidbg so")?;
        final_query_params = match endpoint.contract {
            RequestContract::Direct => {
                let mut params = prepared.clear_params.clone();
                params.insert("sp".to_string(), sp);
                params.insert("sig".to_string(), sig);
                params
            }
            RequestContract::UserAccountGeekBatch => {
                BTreeMap::from([("sp".to_string(), sp), ("sig".to_string(), sig)])
            }
        };
    } else {
        traceid = build_traceid();
        final_query_params = prepared.clear_params.clone();
    }

    let url = build_url(
        host,
        &prepared.request_path,
        &final_query_params,
        &prepared.unsigned_params,
    )?;
    let headers = request_headers(host, device, session, &traceid, zp_tag.as_deref())?;
    let redacted_headers = redact_headers(&headers);
    let raw_payload = execute_request(
        transport,
        &url,
        &headers,
        so_invoker,
        session.secret_key.as_str(),
    )?;
    let payload = normalize_endpoint_response(endpoint, &prepared, raw_payload);

    Ok(json!({
        "mode": mode.as_str(),
        "host": host,
        "family": endpoint.family,
        "name": endpoint.name,
        "path": endpoint.path,
        "request_path": prepared.request_path,
        "transport_runtime": transport.label(),
        "url": url,
        "traceid": traceid,
        "request_contract": describe_request_contract(endpoint, &prepared, request_alignment),
        "key_mode": match (mode, secret_key.unwrap_or_default().is_empty()) {
            (RequestMode::RnIdbgSo, true) => Value::String("empty".to_string()),
            (RequestMode::RnIdbgSo, false) => Value::String("secret".to_string()),
            _ => Value::Null,
        },
        "native_invoker": match mode {
            RequestMode::RnIdbgSo => so_invoker
                .map(RnIdbgSoInvoker::describe)
                .unwrap_or(Value::Null),
            RequestMode::SessionOnly => Value::Null,
        },
        "request_headers": redacted_headers,
        "response": payload,
    }))
}

fn execute_request(
    transport: RequestTransport<'_>,
    url: &str,
    headers: &HashMap<String, String>,
    so_invoker: Option<&RnIdbgSoInvoker>,
    session_secret_key: &str,
) -> Result<Value> {
    if let RequestTransport::OkHttpBridge(proxy) = transport {
        return proxy.request_get(url, headers, so_invoker, session_secret_key);
    }

    let RequestTransport::Direct(client) = transport else {
        unreachable!()
    };
    let mut request = client.client.get(url);
    request = request.headers(to_header_map(headers)?);
    let response = request.send();
    match response {
        Ok(resp) => {
            let status = resp.status();
            let final_url = resp.url().to_string();
            let http_version = http_version_label(resp.version());
            let response_headers = headers_to_json(resp.headers());
            let text = resp.text().unwrap_or_default();
            let transport = json!({
                "http_status": status.as_u16(),
                "http_version": http_version,
                "final_url": final_url,
                "response_headers": response_headers,
                "proxy": client.proxy_description(),
            });
            if let Some(value) = parse_response_body(&text, so_invoker, session_secret_key)? {
                return Ok(attach_transport(value, transport));
            }
            Ok(json!({
                "code": status.as_u16(),
                "message": format!("HTTP {} non-json response", status.as_u16()),
                "raw": truncate(&text, 1200),
                "transport": transport,
            }))
        }
        Err(err) => Ok(json!({
            "code": -1,
            "message": format!("request failed: {err}"),
        })),
    }
}

fn parse_response_body(
    body: &str,
    so_invoker: Option<&RnIdbgSoInvoker>,
    session_secret_key: &str,
) -> Result<Option<Value>> {
    let trimmed = body.trim();
    if trimmed.is_empty() {
        return Ok(Some(json!({
            "code": -1,
            "message": "empty response body",
        })));
    }
    if let Ok(value) = serde_json::from_str::<Value>(trimmed) {
        return Ok(Some(value));
    }

    let Some(invoker) = so_invoker else {
        return Ok(None);
    };
    let mut best_payload: Option<(u8, Value)> = None;
    for key in secret_key_candidates_inline(session_secret_key) {
        if let Ok(decoded) = invoker.decode_content(trimmed, &key) {
            if let Some((score, value)) = classify_decoded_payload(&decoded, &key)? {
                if score >= 3 {
                    return Ok(Some(value));
                }
                if best_payload
                    .as_ref()
                    .map(|(best_score, _)| score > *best_score)
                    .unwrap_or(true)
                {
                    best_payload = Some((score, value));
                }
            }
        }
    }
    Ok(best_payload.map(|(_, value)| value))
}

fn classify_decoded_payload(decoded: &[u8], key: &str) -> Result<Option<(u8, Value)>> {
    if let Some(value) = parse_json_bytes(decoded) {
        return Ok(Some((3, value)));
    }

    if let Some(plain) = try_parse_bzp_block(decoded)? {
        if let Some(value) = parse_json_bytes(&plain) {
            return Ok(Some((3, value)));
        }
        if let Some(text) = utf8_text(&plain) {
            return Ok(Some((
                2,
                json!({
                    "code": -2,
                    "message": "decoded BZPBlock non-json payload",
                    "decoded_text": truncate(&text, 1200),
                    "decode_key_mode": if key.is_empty() { "empty" } else { "secret" },
                }),
            )));
        }
        return Ok(Some((
            2,
            json!({
                "code": -2,
                "message": "decoded BZPBlock binary payload",
                "decoded_hex": truncate(&hex::encode(plain), 1200),
                "decode_key_mode": if key.is_empty() { "empty" } else { "secret" },
            }),
        )));
    }

    if let Some(text) = utf8_text(decoded) {
        return Ok(Some((
            1,
            json!({
                "code": -2,
                "message": "decoded non-json payload",
                "decoded_text": truncate(&text, 1200),
                "decode_key_mode": if key.is_empty() { "empty" } else { "secret" },
            }),
        )));
    }

    Ok(Some((
        0,
        json!({
            "code": -2,
            "message": "decoded binary payload",
            "decoded_hex": truncate(&hex::encode(decoded), 1200),
            "decode_key_mode": if key.is_empty() { "empty" } else { "secret" },
        }),
    )))
}

fn parse_json_bytes(bytes: &[u8]) -> Option<Value> {
    let text = std::str::from_utf8(bytes).ok()?.trim();
    if text.is_empty() {
        return None;
    }
    serde_json::from_str::<Value>(text).ok()
}

fn utf8_text(bytes: &[u8]) -> Option<String> {
    let text = std::str::from_utf8(bytes).ok()?.trim().to_string();
    if text.is_empty() {
        None
    } else {
        Some(text)
    }
}

fn try_parse_bzp_block(bytes: &[u8]) -> Result<Option<Vec<u8>>> {
    if bytes.len() < BZP_BODY_HEADER_SIZE || !bytes.starts_with(BZP_BODY_MAGIC) {
        return Ok(None);
    }

    let compressed_len = le_u32(bytes, 12)? as usize;
    let plain_len = le_u32(bytes, 16)? as usize;
    let checksum = le_u32(bytes, 20)?;
    let expected_checksum = ((compressed_len as u32) ^ (plain_len as u32)) & 0xFFFF_FFFF;
    if checksum != expected_checksum {
        return Err(anyhow!(
            "invalid BZPBlock checksum: compressed_len={compressed_len}, plain_len={plain_len}, checksum={checksum}, expected={expected_checksum}"
        ));
    }

    let payload_start = BZP_BODY_HEADER_SIZE;
    let payload_end = payload_start
        .checked_add(compressed_len)
        .ok_or_else(|| anyhow!("BZPBlock compressed length overflow"))?;
    if payload_end > bytes.len() {
        return Err(anyhow!(
            "invalid BZPBlock length: need={payload_end}, actual={}",
            bytes.len()
        ));
    }

    let plain = lz4_flex::block::decompress(&bytes[payload_start..payload_end], plain_len)
        .context("failed to decompress BZPBlock payload")?;
    Ok(Some(plain))
}

fn le_u32(bytes: &[u8], offset: usize) -> Result<u32> {
    let chunk = bytes
        .get(offset..offset + 4)
        .ok_or_else(|| anyhow!("missing u32 at offset {offset}"))?;
    Ok(u32::from_le_bytes([chunk[0], chunk[1], chunk[2], chunk[3]]))
}

fn encoded_body_crc32(sp: &str) -> Result<u32> {
    Ok(crc32fast::hash(&decode_sp_to_bytes(sp)?))
}

fn decode_sp_to_bytes(sp: &str) -> Result<Vec<u8>> {
    let text = sp.trim();
    if text.is_empty() {
        return Err(anyhow!("empty sp"));
    }
    let b64 = text.replace('~', "=");
    let pad_len = (4 - (b64.len() % 4)) % 4;
    let mut padded = b64;
    padded.extend(std::iter::repeat_n('=', pad_len));
    URL_SAFE
        .decode(padded.as_bytes())
        .context("failed to decode sp payload")
}

fn prepare_request(
    endpoint: &EndpointSpec,
    device: &DeviceConfig,
    request_alignment: &RequestAlignmentContext,
    req_time_ms: u64,
) -> PreparedRequest {
    let mut signing_params = build_common_params(device, req_time_ms);
    let mut unsigned_params = BTreeMap::new();

    match endpoint.contract {
        RequestContract::Direct => {
            if matches!(
                (endpoint.family, endpoint.name),
                ("java_cvapp", "getExpectedPosition")
            ) {
                signing_params.insert(
                    "cityCode".to_string(),
                    request_alignment.city_code_for_expect_position(),
                );
            }
            PreparedRequest {
                request_path: endpoint.path.to_string(),
                clear_params: signing_params.clone(),
                signing_params,
                unsigned_params,
                batch_response_key: None,
                batch_method_feed: None,
            }
        }
        RequestContract::UserAccountGeekBatch => {
            let batch_method_feed = build_user_account_batch_method_feed(
                &request_alignment.user_id,
                &request_alignment.sub_location,
            );
            signing_params.insert("batch_method_feed".to_string(), batch_method_feed.clone());
            unsigned_params.insert("app_id".to_string(), APP_ID.to_string());
            PreparedRequest {
                request_path: USER_ACCOUNT_GEEK_BATCH_PATH.to_string(),
                signing_params,
                clear_params: BTreeMap::new(),
                unsigned_params,
                batch_response_key: Some(USER_ACCOUNT_GEEK_BASEINFO_METHOD),
                batch_method_feed: Some(batch_method_feed),
            }
        }
    }
}

fn build_user_account_batch_method_feed(user_id: &str, sub_location: &str) -> String {
    let methods = USER_ACCOUNT_GEEK_BATCH_METHODS
        .iter()
        .map(|method| {
            if *method == USER_ACCOUNT_GEEK_BASEINFO_METHOD {
                format!("method={method}&subLocation={sub_location}&userId={user_id}")
            } else {
                format!("method={method}")
            }
        })
        .map(|value| serde_json::to_string(&value).unwrap_or_else(|_| "\"\"".to_string()))
        .collect::<Vec<_>>();
    format!("[{}]", methods.join(", "))
}

fn normalize_endpoint_response(
    endpoint: &EndpointSpec,
    prepared: &PreparedRequest,
    payload: Value,
) -> Value {
    let Some(batch_key) = prepared.batch_response_key else {
        return payload;
    };

    let Some(code) = response_code(Some(&payload)) else {
        return payload;
    };
    if code != 0 {
        return payload;
    }

    let Some(node) = extract_batch_response_node(&payload, batch_key) else {
        return json!({
            "code": -1,
            "message": format!("batch response missing node for {}", endpoint.name),
            "batch_response_key": batch_key,
            "batch_request_path": prepared.request_path,
            "batch_transport": payload.get("transport").cloned().unwrap_or(Value::Null),
        });
    };

    let mut normalized = node;
    if let Some(object) = normalized.as_object_mut() {
        object
            .entry("transport".to_string())
            .or_insert_with(|| payload.get("transport").cloned().unwrap_or(Value::Null));
        object.insert(
            "batch".to_string(),
            json!({
                "request_path": prepared.request_path,
                "response_key": batch_key,
                "method_feed": prepared.batch_method_feed.clone(),
            }),
        );
    }
    normalized
}

fn extract_batch_response_node(payload: &Value, batch_key: &str) -> Option<Value> {
    if let Some(zp_data) = payload.get("zpData").and_then(Value::as_object) {
        for (key, value) in zp_data {
            if key == batch_key || key.starts_with(batch_key) {
                return Some(value.clone());
            }
        }
    }
    payload.get(batch_key).cloned()
}

fn describe_request_contract(
    endpoint: &EndpointSpec,
    prepared: &PreparedRequest,
    request_alignment: &RequestAlignmentContext,
) -> Value {
    match endpoint.contract {
        RequestContract::Direct => json!({
            "type": "direct",
            "request_path": prepared.request_path,
            "city_code": if matches!((endpoint.family, endpoint.name), ("java_cvapp", "getExpectedPosition")) {
                Value::String(request_alignment.city_code_for_expect_position())
            } else {
                Value::Null
            },
        }),
        RequestContract::UserAccountGeekBatch => json!({
            "type": "batchRunV2",
            "request_path": prepared.request_path,
            "app_id": APP_ID,
            "batch_response_key": prepared.batch_response_key,
            "batch_method_feed": prepared.batch_method_feed.clone(),
        }),
    }
}

enum RnIdbgSoInvoker {
    Local(LocalProcessInvoker),
    Bridge(HttpBridgeInvoker),
}

impl RnIdbgSoInvoker {
    fn new(
        config_path: PathBuf,
        lab_config: &LabConfig,
        opts: &HashMap<String, String>,
    ) -> Result<Self> {
        let runtime = InvokeRuntime::parse(opts.get("--invoke-runtime").map(String::as_str))?;
        let bridge_url = opts
            .get("--bridge-url")
            .cloned()
            .unwrap_or_else(|| DEFAULT_HTTP_BRIDGE_URL.to_string());

        match runtime {
            InvokeRuntime::Local => Ok(Self::Local(LocalProcessInvoker::new(
                config_path,
                lab_config.backend.clone(),
            )?)),
            InvokeRuntime::Bridge => Ok(Self::Bridge(HttpBridgeInvoker::new(
                bridge_url, lab_config,
            )?)),
            InvokeRuntime::Auto => {
                if local_process_usable(lab_config) {
                    Ok(Self::Local(LocalProcessInvoker::new(
                        config_path,
                        lab_config.backend.clone(),
                    )?))
                } else {
                    Ok(Self::Bridge(HttpBridgeInvoker::new(
                        bridge_url, lab_config,
                    )?))
                }
            }
        }
    }

    fn encode_request(&self, data: &[u8], key: &str) -> Result<String> {
        match self {
            Self::Local(invoker) => invoker.encode_request(data, key),
            Self::Bridge(invoker) => invoker.encode_request(data, key),
        }
    }

    fn signature(&self, data: &[u8], key: &str) -> Result<String> {
        match self {
            Self::Local(invoker) => invoker.signature(data, key),
            Self::Bridge(invoker) => invoker.signature(data, key),
        }
    }

    fn decode_content(&self, content: &str, key: &str) -> Result<Vec<u8>> {
        match self {
            Self::Local(invoker) => invoker.decode_content(content, key),
            Self::Bridge(invoker) => invoker.decode_content(content, key),
        }
    }

    fn describe(&self) -> Value {
        match self {
            Self::Local(invoker) => invoker.describe(),
            Self::Bridge(invoker) => invoker.describe(),
        }
    }
}

struct LocalProcessInvoker {
    executable: PathBuf,
    config_path: PathBuf,
    backend: String,
}

impl LocalProcessInvoker {
    fn new(config_path: PathBuf, backend: String) -> Result<Self> {
        Ok(Self {
            executable: std::env::current_exe()
                .context("failed to locate current rnidbg executable")?,
            config_path,
            backend,
        })
    }

    fn describe(&self) -> Value {
        json!({
            "status": "ready",
            "strategy": "local_subprocess",
            "backend": self.backend,
            "executable": self.executable.display().to_string(),
            "config_path": self.config_path.display().to_string(),
        })
    }

    fn encode_request(&self, data: &[u8], key: &str) -> Result<String> {
        let value = self.invoke_bytes("nativeEncodeRequest", data, key)?;
        value
            .get("output")
            .and_then(Value::as_str)
            .map(str::to_string)
            .ok_or_else(|| anyhow!("rnidbg invoke missing output field"))
    }

    fn signature(&self, data: &[u8], key: &str) -> Result<String> {
        let value = self.invoke_bytes("nativeSignature", data, key)?;
        value
            .get("output")
            .and_then(Value::as_str)
            .map(str::to_string)
            .ok_or_else(|| anyhow!("rnidbg invoke missing signature output"))
    }

    fn decode_content(&self, content: &str, key: &str) -> Result<Vec<u8>> {
        let value = self.invoke_str("nativeDecodeContent", content, key)?;
        if let Some(text) = value.get("output_utf8").and_then(Value::as_str) {
            return Ok(text.as_bytes().to_vec());
        }
        if let Some(hex) = value.get("output_hex").and_then(Value::as_str) {
            return hex::decode(hex)
                .context("failed to decode rnidbg nativeDecodeContent hex output");
        }
        Err(anyhow!("rnidbg invoke missing decode output"))
    }

    fn invoke_bytes(&self, method: &str, data: &[u8], key: &str) -> Result<Value> {
        let arg1 = String::from_utf8(data.to_vec())
            .unwrap_or_else(|_| format!("hex:{}", hex::encode(data)));
        self.invoke_str(method, &arg1, key)
    }

    fn invoke_str(&self, method: &str, arg1: &str, key: &str) -> Result<Value> {
        let output = Command::new(&self.executable)
            .arg("boss-yzwg")
            .arg("invoke")
            .arg("--config")
            .arg(&self.config_path)
            .arg("--backend")
            .arg(&self.backend)
            .arg("--method")
            .arg(method)
            .arg("--arg1")
            .arg(arg1)
            .arg("--arg2")
            .arg(key)
            .output()
            .with_context(|| format!("failed to spawn rnidbg invoke subprocess for {method}"))?;

        if !output.status.success() {
            let stderr = String::from_utf8_lossy(&output.stderr).to_string();
            let stdout = String::from_utf8_lossy(&output.stdout).to_string();
            return Err(anyhow!(
                "rnidbg invoke subprocess failed: status={:?}, stderr={}, stdout={}",
                output.status.code(),
                truncate(&stderr, 1200),
                truncate(&stdout, 1200),
            ));
        }

        serde_json::from_slice(&output.stdout)
            .with_context(|| format!("failed to parse rnidbg invoke output for {method}"))
    }
}

struct HttpBridgeInvoker {
    base_url: String,
    backend: String,
    client: Client,
}

impl HttpBridgeInvoker {
    fn new(base_url: String, lab_config: &LabConfig) -> Result<Self> {
        let normalized = normalize_bridge_url(&base_url)?;
        ensure_http_bridge_ready(&normalized, lab_config)?;
        Ok(Self {
            base_url: normalized,
            backend: lab_config.backend.clone(),
            client: Client::builder()
                .timeout(Duration::from_secs(DEFAULT_TIMEOUT_SECONDS))
                .build()
                .context("failed to build http-bridge client")?,
        })
    }

    fn describe(&self) -> Value {
        json!({
            "status": "ready",
            "strategy": "http_bridge",
            "backend": self.backend,
            "base_url": self.base_url,
        })
    }

    fn encode_request(&self, data: &[u8], key: &str) -> Result<String> {
        let plain = std::str::from_utf8(data)
            .context("http bridge encode only supports utf-8 request payloads")?;
        let value = self.post_json("/api/encode", json!({ "plain": plain, "key": key }))?;
        value
            .get("sp")
            .and_then(Value::as_str)
            .map(str::to_string)
            .ok_or_else(|| anyhow!("http bridge encode response missing sp"))
    }

    fn signature(&self, data: &[u8], key: &str) -> Result<String> {
        let payload = std::str::from_utf8(data)
            .context("http bridge sign only supports utf-8 request payloads")?;
        let value = self.post_json("/api/sign", json!({ "data": payload, "key": key }))?;
        value
            .get("sig")
            .and_then(Value::as_str)
            .map(str::to_string)
            .ok_or_else(|| anyhow!("http bridge sign response missing sig"))
    }

    fn decode_content(&self, content: &str, key: &str) -> Result<Vec<u8>> {
        let value = self.post_json("/api/decode", json!({ "cipher": content, "key": key }))?;
        value
            .get("plain")
            .and_then(Value::as_str)
            .map(|text| text.as_bytes().to_vec())
            .ok_or_else(|| anyhow!("http bridge decode response missing plain"))
    }

    fn post_json(&self, path: &str, body: Value) -> Result<Value> {
        let url = format!("{}{}", self.base_url, path);
        let response = self
            .client
            .post(&url)
            .json(&body)
            .send()
            .with_context(|| format!("failed to call rnidbg http bridge: {url}"))?;
        let status = response.status();
        let payload: Value = response
            .json()
            .with_context(|| format!("failed to parse rnidbg http bridge response: {url}"))?;
        if !status.is_success() {
            return Err(anyhow!(
                "rnidbg http bridge returned HTTP {}: {}",
                status.as_u16(),
                payload
            ));
        }
        if let Some(error) = payload.get("error").and_then(Value::as_str) {
            return Err(anyhow!("rnidbg http bridge returned error: {error}"));
        }
        Ok(payload)
    }
}

fn request_headers(
    host: &str,
    device: &DeviceConfig,
    session: &SessionConfig,
    traceid: &str,
    zp_tag: Option<&str>,
) -> Result<HashMap<String, String>> {
    let host_header = host_header(host)?;
    let mut extra = HashMap::new();
    if !traceid.trim().is_empty() {
        extra.insert("traceid".to_string(), traceid.to_string());
    }
    if let Some(zp_tag) = zp_tag.filter(|value| !value.trim().is_empty()) {
        extra.insert("zp-tag".to_string(), zp_tag.to_string());
    }
    Ok(build_stage_inbound_headers(
        USER_AGENT,
        &host_header,
        device,
        Some(session),
        Some(extra),
    ))
}

fn normalized_numeric_opt(value: Option<&String>, default: &str) -> String {
    value
        .map(|value| value.trim())
        .filter(|value| !value.is_empty())
        .unwrap_or(default)
        .to_string()
}

fn build_common_params(device: &DeviceConfig, req_time_ms: u64) -> BTreeMap<String, String> {
    let now = req_time_ms.to_string();
    let client_info = build_client_info(device, &now, &now);
    BTreeMap::from([
        ("client_info".to_string(), client_info),
        ("curidentity".to_string(), device.curidentity.to_string()),
        ("req_time".to_string(), now),
        ("uniqid".to_string(), device.uniqid.clone()),
        ("v".to_string(), APP_VERSION.to_string()),
    ])
}

fn build_client_info(device: &DeviceConfig, start_time: &str, resume_time: &str) -> String {
    format!(
        concat!(
            "{{",
            "\"version\":\"14\",",
            "\"os\":{},",
            "\"start_time\":{},",
            "\"resume_time\":{},",
            "\"channel\":{},",
            "\"model\":{},",
            "\"dzt\":0,",
            "\"loc_per\":0,",
            "\"uniqid\":{},",
            "\"oaid\":{},",
            "\"oaid_honor\":{},",
            "\"did\":{},",
            "\"tinker_id\":{},",
            "\"is_bg_req\":0,",
            "\"network\":{},",
            "\"operator\":{},",
            "\"abi\":{},",
            "\"version_flag\":{}",
            "}}"
        ),
        json_string(OS_NAME),
        json_string(start_time),
        json_string(resume_time),
        json_string(APP_CHANNEL),
        json_string(&device.model),
        json_string(&device.uniqid),
        json_string(&device.oaid),
        json_string(&device.oaid_honor),
        json_string(&device.did),
        json_string(&device.tinker_id),
        json_string(&device.network),
        json_string(&device.operator),
        ABI,
        json_string(APP_VERSION_CODE),
    )
}

fn canonicalize_params(params: &BTreeMap<String, String>) -> String {
    params
        .iter()
        .map(|(key, value)| format!("{key}={}", canonicalize_value(value)))
        .collect::<Vec<_>>()
        .join("&")
}

fn canonicalize_value(value: &str) -> String {
    let mut out = String::new();
    for byte in value.as_bytes() {
        match byte {
            b'0'..=b'9' | b'a'..=b'z' | b'A'..=b'Z' | b'-' | b'_' | b'.' | b'*' => {
                out.push(*byte as char)
            }
            b' ' => out.push('+'),
            _ => out.push_str(&format!("%{byte:02X}")),
        }
    }
    out
}

fn build_url(
    host: &str,
    path: &str,
    params: &BTreeMap<String, String>,
    url_only_params: &BTreeMap<String, String>,
) -> Result<String> {
    let base = format!(
        "{}/api/{}",
        host.trim_end_matches('/'),
        path.trim_start_matches('/')
    );
    let mut url =
        Url::parse(&base).with_context(|| format!("invalid private-info host: {host}"))?;
    {
        let mut pairs = url.query_pairs_mut();
        for (key, value) in params {
            pairs.append_pair(key, value);
        }
        for (key, value) in url_only_params {
            pairs.append_pair(key, value);
        }
    }
    Ok(url.to_string())
}

fn to_header_map(headers: &HashMap<String, String>) -> Result<HeaderMap> {
    let mut out = HeaderMap::new();
    for (key, value) in headers {
        let name = HeaderName::from_bytes(key.as_bytes())
            .with_context(|| format!("invalid request header name: {key}"))?;
        let value = HeaderValue::from_str(value)
            .with_context(|| format!("invalid request header value for {key}"))?;
        out.insert(name, value);
    }
    Ok(out)
}

fn response_code(value: Option<&Value>) -> Option<i64> {
    value
        .and_then(|payload| payload.get("code"))
        .and_then(Value::as_i64)
}

fn response_is_success(value: Option<&Value>) -> bool {
    response_code(value) == Some(0)
}

fn attempt_error(
    mode: RequestMode,
    host: &str,
    endpoint: &EndpointSpec,
    transport_runtime: Option<&str>,
    key_mode: Option<&str>,
    message: &str,
) -> Value {
    json!({
        "mode": mode.as_str(),
        "host": host,
        "family": endpoint.family,
        "name": endpoint.name,
        "path": endpoint.path,
        "transport_runtime": transport_runtime,
        "key_mode": key_mode,
        "response": {
            "code": -1,
            "message": message,
        }
    })
}

fn build_host_candidates(preferred_host: Option<&str>) -> Vec<String> {
    if let Some(host) = preferred_host {
        let normalized = normalize_host(host);
        if !normalized.is_empty() {
            return vec![normalized];
        }
    }
    vec![DEFAULT_HOST.to_string()]
}

fn normalize_host(host: &str) -> String {
    let text = host.trim();
    if text.is_empty() {
        String::new()
    } else if text.starts_with("http://") || text.starts_with("https://") {
        text.trim_end_matches('/').to_string()
    } else {
        format!("https://{}", text.trim_end_matches('/'))
    }
}

fn host_header(host: &str) -> Result<String> {
    let parsed = Url::parse(host).with_context(|| format!("invalid host url: {host}"))?;
    Ok(match parsed.port() {
        Some(port) => format!("{}:{}", parsed.host_str().unwrap_or("api.zhipin.com"), port),
        None => parsed.host_str().unwrap_or("api.zhipin.com").to_string(),
    })
}

fn secret_key_candidates_for_endpoint(
    session: &SessionConfig,
    endpoint: &EndpointSpec,
) -> Vec<String> {
    let mut keys = Vec::new();
    let secret = session.secret_key.trim();
    let prefer_empty_key = matches!(endpoint.contract, RequestContract::UserAccountGeekBatch);

    if prefer_empty_key {
        keys.push(String::new());
    }
    if !secret.is_empty() {
        keys.push(secret.to_string());
    }
    if !prefer_empty_key {
        keys.push(String::new());
    }

    let mut unique = Vec::new();
    for key in keys {
        if !unique.iter().any(|existing: &String| existing == &key) {
            unique.push(key);
        }
    }
    unique
}

fn secret_key_candidates_inline(secret_key: &str) -> Vec<String> {
    let mut keys = Vec::new();
    let trimmed = secret_key.trim();
    if !trimmed.is_empty() {
        keys.push(trimmed.to_string());
    }
    if !keys.iter().any(|value| value.is_empty()) {
        keys.push(String::new());
    }
    keys
}

fn extract_city_code_from_response(response: &Value) -> Option<String> {
    let geek_detail = if let Some(zp_data) = response.get("zpData").and_then(Value::as_object) {
        if let Some(geek_detail) = zp_data.get("geekDetail").and_then(Value::as_object) {
            Some(geek_detail)
        } else {
            zp_data
                .values()
                .find_map(|value| value.get("zpData"))
                .and_then(Value::as_object)
                .and_then(|zp_data| zp_data.get("geekDetail"))
                .and_then(Value::as_object)
        }
    } else {
        None
    }?;

    let expect_list = geek_detail.get("expectPositionList")?.as_array()?;
    for item in expect_list {
        let Some(item) = item.as_object() else {
            continue;
        };
        for key in ["location", "cityCode"] {
            let Some(raw) = item.get(key) else {
                continue;
            };
            let text = match raw {
                Value::String(value) => value.trim().to_string(),
                Value::Number(value) => value.to_string(),
                _ => continue,
            };
            if !text.is_empty() && text.chars().all(|ch| ch.is_ascii_digit()) {
                return Some(text);
            }
        }
    }
    None
}

fn resolve_output_path(path: Option<&str>) -> PathBuf {
    if let Some(path) = path {
        return PathBuf::from(path);
    }
    std::env::current_dir()
        .unwrap_or_else(|_| PathBuf::from("."))
        .join("private_info_result.json")
}

fn resolved_session_path(session_path: Option<&str>) -> String {
    if let Some(path) = session_path {
        return PathBuf::from(path).display().to_string();
    }
    for candidate in [
        std::env::current_dir()
            .unwrap_or_else(|_| PathBuf::from("."))
            .join(".boss_purecalc/session.json"),
        PathBuf::from("/Users/haojiejack/github/drizzle-dumper-rust/boss_purecalc/.boss_purecalc/session.json"),
    ] {
        if candidate.is_file() {
            return candidate.display().to_string();
        }
    }
    ".boss_purecalc/session.json".to_string()
}

fn analysis_refs() -> Vec<String> {
    let mut refs = vec![MONITOR_REPORT.to_string()];
    for relative in [
        "alignment_02/private_info_context_alignment.json",
        "unidbg_replay_02/private_info_unidbg_replay.json",
        "decode_01/private_info_decode.json",
    ] {
        let path = Path::new(ANALYSIS_ROOT).join(relative);
        if path.is_file() {
            refs.push(path.display().to_string());
        }
    }
    refs
}

fn redact_headers(headers: &HashMap<String, String>) -> Value {
    let mut map = serde_json::Map::new();
    for (key, value) in headers {
        let normalized = key.to_ascii_lowercase();
        let redacted = match normalized.as_str() {
            "cookie" => redact_cookie(value),
            "t2" | "zp-at" => preview_secret(value),
            _ => value.clone(),
        };
        map.insert(key.clone(), Value::String(redacted));
    }
    Value::Object(map)
}

fn redact_cookie(cookie: &str) -> String {
    cookie
        .split(';')
        .map(|chunk| {
            let text = chunk.trim();
            if let Some((key, value)) = text.split_once('=') {
                format!("{}={}", key.trim(), preview_secret(value.trim()))
            } else {
                text.to_string()
            }
        })
        .collect::<Vec<_>>()
        .join("; ")
}

fn preview_secret(value: &str) -> String {
    let text = value.trim();
    if text.len() <= 12 {
        return "*".repeat(text.len().max(1));
    }
    format!("{}…{}", &text[..6], &text[text.len() - 4..])
}

fn build_traceid() -> String {
    let a = rand::random::<u32>();
    let b = rand::random::<u16>();
    let c = rand::random::<u16>();
    let d = rand::random::<u16>();
    let e_hi = rand::random::<u16>();
    let e_lo = rand::random::<u32>();
    format!("A-{a:08x}-{b:04x}-{c:04x}-{d:04x}-{e_hi:04x}{e_lo:08x}")
}

fn now_ms() -> u64 {
    std::time::SystemTime::now()
        .duration_since(std::time::UNIX_EPOCH)
        .unwrap_or_default()
        .as_millis() as u64
}

fn truncate_for_sig(value: &str, max_len: usize) -> String {
    if value.len() <= max_len {
        value.to_string()
    } else {
        value[..max_len].to_string()
    }
}

fn truncate(value: &str, max_len: usize) -> String {
    if value.len() <= max_len {
        value.to_string()
    } else {
        value[..max_len].to_string()
    }
}

fn json_string(value: &str) -> String {
    serde_json::to_string(value).unwrap_or_else(|_| "\"\"".to_string())
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn canonicalize_params_sorts_and_encodes_values() {
        let params = BTreeMap::from([
            ("b".to_string(), "hello world".to_string()),
            ("a".to_string(), "{\"x\":1}".to_string()),
        ]);
        assert_eq!(
            canonicalize_params(&params),
            "a=%7B%22x%22%3A1%7D&b=hello+world"
        );
    }

    #[test]
    fn build_client_info_keeps_expected_field_order() {
        let device = DeviceConfig {
            uniqid: "u".to_string(),
            oaid: "o".to_string(),
            oaid_honor: "h".to_string(),
            did: "d".to_string(),
            tinker_id: "t".to_string(),
            brand: "realme".to_string(),
            model: "realme||RMX3560".to_string(),
            network: "wifi".to_string(),
            operator: "op".to_string(),
            ..DeviceConfig::default()
        };
        let text = build_client_info(&device, "1", "2");
        assert!(text.starts_with("{\"version\":\"14\",\"os\":\"Android\",\"start_time\":\"1\",\"resume_time\":\"2\",\"channel\":\"15\""));
        assert!(text.contains("\"model\":\"realme||RMX3560\""));
        assert!(text.ends_with("\"version_flag\":\"1401010\"}"));
    }

    #[test]
    fn transport_runtime_accepts_okhttp_bridge_aliases() {
        for value in ["okhttp-bridge", "okhttp_bridge", "okhttp"] {
            assert!(matches!(
                TransportRuntime::parse(Some(value)).unwrap(),
                TransportRuntime::OkHttpBridge
            ));
        }
    }

    #[test]
    fn transport_runtime_auto_does_not_assume_external_bridge() {
        let opts = HashMap::new();
        let config = LabConfig {
            package_name: "com.hpbr.bosszhipin".to_string(),
            apk_path: PathBuf::from("/tmp/base.apk"),
            so_path: PathBuf::from("/tmp/libyzwg.so"),
            asset_sign_encrypt_path: PathBuf::from("/tmp/sign_encrypt"),
            purecalc_lookup_path: PathBuf::from("/tmp/purecalc_lookup.json"),
            trace_out_dir: PathBuf::from("/tmp/rnidbg-trace"),
            android_api: 23,
            backend: "dynarmic".to_string(),
        };
        let bridge =
            OkHttpBridgeTransport::discover(TransportRuntime::Auto, &config, &opts).unwrap();
        assert!(bridge.is_none());
    }

    #[test]
    fn user_account_batch_feed_matches_app_shape() {
        let feed = build_user_account_batch_method_feed("0", "0");
        assert!(feed.starts_with("[\"method=zpgeek.app.bluecollar.topic.banner.v2\", "));
        assert!(feed.contains("\"method=zpgeek.cvapp.geek.baseinfo.query&subLocation=0&userId=0\""));
        assert!(feed.ends_with("\"method=zpchat.wechat.get.WxNotify.commonSetting\"]"));
    }

    #[test]
    fn batch_response_extracts_baseinfo_node() {
        let endpoint = EndpointSpec {
            family: "java_cvapp",
            name: "getGeekInfo",
            path: "zpgeek/cvapp/geek/baseinfo/query",
            contract: RequestContract::UserAccountGeekBatch,
        };
        let prepared = PreparedRequest {
            request_path: USER_ACCOUNT_GEEK_BATCH_PATH.to_string(),
            signing_params: BTreeMap::new(),
            clear_params: BTreeMap::new(),
            unsigned_params: BTreeMap::from([("app_id".to_string(), APP_ID.to_string())]),
            batch_response_key: Some(USER_ACCOUNT_GEEK_BASEINFO_METHOD),
            batch_method_feed: Some(build_user_account_batch_method_feed("0", "0")),
        };
        let normalized = normalize_endpoint_response(
            &endpoint,
            &prepared,
            json!({
                "code": 0,
                "transport": {"bridge_protocol": "http/1.1"},
                "zpData": {
                    USER_ACCOUNT_GEEK_BASEINFO_METHOD: {
                        "code": 0,
                        "message": "ok",
                        "zpData": {
                            "geekDetail": {
                                "expectPositionList": [{"location": "101010100"}]
                            }
                        }
                    }
                }
            }),
        );
        assert_eq!(response_code(Some(&normalized)), Some(0));
        assert_eq!(
            extract_city_code_from_response(&normalized).as_deref(),
            Some("101010100")
        );
        assert_eq!(
            normalized
                .get("transport")
                .and_then(|value| value.get("bridge_protocol"))
                .and_then(Value::as_str),
            Some("http/1.1")
        );
    }

    #[test]
    fn batch_requests_prefer_empty_key_first() {
        let endpoint = EndpointSpec {
            family: "java_cvapp",
            name: "getGeekInfo",
            path: "zpgeek/cvapp/geek/baseinfo/query",
            contract: RequestContract::UserAccountGeekBatch,
        };
        let session = SessionConfig {
            secret_key: "secret".to_string(),
            ..SessionConfig::default()
        };
        let keys = secret_key_candidates_for_endpoint(&session, &endpoint);
        assert_eq!(keys, vec![String::new(), "secret".to_string()]);
    }

    #[test]
    fn direct_request_contract_does_not_append_app_id() {
        let endpoint = EndpointSpec {
            family: "legacy_geek",
            name: "getGeekInfo",
            path: "zpgeek/geek/getGeekInfo",
            contract: RequestContract::Direct,
        };
        let prepared = prepare_request(
            &endpoint,
            &DeviceConfig::default(),
            &RequestAlignmentContext::from_opts(&HashMap::new()),
            123,
        );
        assert!(prepared.unsigned_params.is_empty());
        assert_eq!(prepared.clear_params, prepared.signing_params);
    }

    #[test]
    fn batch_request_contract_hides_method_feed_from_url() {
        let endpoint = EndpointSpec {
            family: "java_cvapp",
            name: "getGeekInfo",
            path: "zpgeek/cvapp/geek/baseinfo/query",
            contract: RequestContract::UserAccountGeekBatch,
        };
        let prepared = prepare_request(
            &endpoint,
            &DeviceConfig::default(),
            &RequestAlignmentContext::from_opts(&HashMap::new()),
            123,
        );
        assert!(prepared.clear_params.is_empty());
        assert!(prepared.signing_params.contains_key("batch_method_feed"));
        assert_eq!(
            prepared.unsigned_params.get("app_id").map(String::as_str),
            Some(APP_ID)
        );
    }

    #[test]
    fn parse_decoded_payload_handles_bzp_block() {
        let plain = br#"{"code":0,"message":"ok"}"#;
        let compressed = lz4_flex::block::compress(plain);
        let checksum = (compressed.len() as u32) ^ (plain.len() as u32);
        let mut block = vec![0u8; BZP_BODY_HEADER_SIZE];
        block[..8].copy_from_slice(BZP_BODY_MAGIC);
        block[12..16].copy_from_slice(&(compressed.len() as u32).to_le_bytes());
        block[16..20].copy_from_slice(&(plain.len() as u32).to_le_bytes());
        block[20..24].copy_from_slice(&checksum.to_le_bytes());
        block.extend_from_slice(&compressed);

        let payload = classify_decoded_payload(&block, "").unwrap().unwrap().1;
        assert_eq!(response_code(Some(&payload)), Some(0));
    }

    #[test]
    fn request_alignment_discovers_city_code_from_geek_detail() {
        let mut context = RequestAlignmentContext::from_opts(&HashMap::new());
        let endpoint = EndpointSpec {
            family: "java_cvapp",
            name: "getGeekInfo",
            path: "zpgeek/cvapp/geek/baseinfo/query",
            contract: RequestContract::UserAccountGeekBatch,
        };
        context.observe_response(
            &endpoint,
            Some(&json!({
                "code": 0,
                "zpData": {
                    "geekDetail": {
                        "expectPositionList": [
                            {"location": "101191100"}
                        ]
                    }
                }
            })),
        );
        assert_eq!(context.city_code.as_deref(), Some("101191100"));
        assert_eq!(context.city_code_for_expect_position(), "101191100");
    }

    #[test]
    fn extract_city_code_accepts_numeric_location() {
        let response = json!({
            "code": 0,
            "zpData": {
                "geekDetail": {
                    "expectPositionList": [
                        {"location": 101191100}
                    ]
                }
            }
        });
        assert_eq!(
            extract_city_code_from_response(&response).as_deref(),
            Some("101191100")
        );
    }
}
