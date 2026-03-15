use std::collections::{BTreeMap, HashMap};
use std::path::{Path, PathBuf};
use std::process::{Command, Output, Stdio};
use std::time::Duration;

use anyhow::{anyhow, Context, Result};
use base64::engine::general_purpose::{STANDARD, URL_SAFE};
use base64::Engine as _;
use reqwest::blocking::Client;
use reqwest::header::{HeaderMap, HeaderName, HeaderValue};
use reqwest::{Url, Version};
use serde_json::{json, Value};

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
const DEFAULT_TIMEOUT_SECONDS: u64 = 30;
const DEFAULT_HTTP_BRIDGE_URL: &str = "http://127.0.0.1:28080";
const BOSS_APK_OKHTTP_TIMEOUT_SECONDS: u64 = 60;
const JOB_DETAIL_BATCH_HOST: &str = "https://api-and.zhipin.com";
const JOB_DETAIL_BATCH_REQUEST_PATH: &str = "/api/batch/requests";
const JOB_DETAIL_SUBREQ_PATH: &str = "/api/zpgeek/jobapp/geek/job/querydetail";
const BZP_BODY_MAGIC: &[u8; 8] = b"BZPBlock";
const BZP_BODY_HEADER_SIZE: usize = 24;

pub fn run_job_detail(opts: &HashMap<String, String>) -> Result<Value> {
    let security_id = required_security_id(opts)?;
    let session_path = opts.get("--session-path").map(String::as_str);
    let resolved_session_path = resolved_session_path(session_path);
    let output_path = resolve_output_path(
        opts.get("--out").map(String::as_str),
        "job_detail_result.json",
    );
    let config_path = PathBuf::from(
        opts.get("--config")
            .cloned()
            .unwrap_or_else(super::default_config_path),
    );
    let lab_config = LabConfig::load(&config_path)?
        .with_backend_override(opts.get("--backend").map(String::as_str))?;
    let session = load_session(session_path)?;
    let device = DeviceConfig::from_session(&session);
    let signer = RnIdbgSoInvoker::new(config_path.clone(), &lab_config, opts)?;
    let transport_runtime =
        TransportRuntime::parse(opts.get("--transport-runtime").map(String::as_str))?;
    let http1_only = parse_bool_flag(opts, "--http1-only");
    let transport = HttpTransport::discover(transport_runtime, &lab_config, opts, http1_only)?;
    let host = normalize_host(
        opts.get("--host")
            .map(String::as_str)
            .unwrap_or(JOB_DETAIL_BATCH_HOST),
    );
    let request_opts = JobDetailRequestOptions::from_opts(opts, security_id.clone());
    let prepared = PreparedJobDetailRequest::sign(
        &request_opts,
        &host,
        &device,
        &session,
        &*signer,
        now_ms(),
        &build_traceid(),
    )?;
    let response_raw = execute_post(
        &transport,
        &prepared.url,
        &prepared.headers,
        &prepared.body_bytes,
        Some(&*signer),
        session.secret_key.as_str(),
    )?;
    let response = normalize_job_detail_response(&response_raw);
    let summary = summarize_job_detail_payload(&response);
    let ok = response_code(Some(&response)) == Some(0);

    let output = json!({
        "ok": ok,
        "route": "security_id_batch",
        "session_path": resolved_session_path,
        "host": host,
        "transport_runtime": transport.label(),
        "original_okhttp_available": transport.original_okhttp_available(),
        "native_invoker": signer.describe(),
        "transport": transport.describe(),
        "request_contract": prepared.contract,
        "request": {
            "url": prepared.url,
            "traceid": prepared.traceid,
            "request_headers": redact_headers(&prepared.headers),
            "body_json": prepared.body_json,
            "body_len": prepared.body_bytes.len(),
            "security_id": request_opts.security_id,
        },
        "response": response,
        "raw_response": response_raw,
        "summary": summary,
    });

    if let Some(parent) = output_path.parent() {
        std::fs::create_dir_all(parent)
            .with_context(|| format!("failed to create output parent dir: {}", parent.display()))?;
    }
    std::fs::write(&output_path, serde_json::to_vec_pretty(&output)?).with_context(|| {
        format!(
            "failed to write job-detail result: {}",
            output_path.display()
        )
    })?;

    Ok(output)
}

#[derive(Clone, Debug)]
struct JobDetailRequestOptions {
    security_id: String,
    lid: String,
    need_related_job: bool,
    page: i32,
    request_source: String,
    source_type: String,
    way_type: String,
    keyword: String,
    query: String,
}

impl JobDetailRequestOptions {
    fn from_opts(opts: &HashMap<String, String>, security_id: String) -> Self {
        Self {
            security_id,
            lid: opts.get("--lid").cloned().unwrap_or_default(),
            need_related_job: parse_bool_flag(opts, "--need-related-job"),
            page: opts
                .get("--page")
                .and_then(|value| value.parse::<i32>().ok())
                .unwrap_or(0),
            request_source: opts
                .get("--request-source")
                .cloned()
                .unwrap_or_else(|| "0".to_string()),
            source_type: opts
                .get("--source-type")
                .cloned()
                .unwrap_or_else(|| "0".to_string()),
            way_type: opts
                .get("--way-type")
                .cloned()
                .unwrap_or_else(|| "0".to_string()),
            keyword: opts.get("--keyword").cloned().unwrap_or_default(),
            query: opts.get("--query").cloned().unwrap_or_default(),
        }
    }
}

struct PreparedJobDetailRequest {
    url: String,
    traceid: String,
    headers: HashMap<String, String>,
    body_json: String,
    body_bytes: Vec<u8>,
    contract: Value,
}

impl PreparedJobDetailRequest {
    fn sign(
        options: &JobDetailRequestOptions,
        host: &str,
        device: &DeviceConfig,
        session: &SessionConfig,
        signer: &dyn BossSigner,
        req_time_ms: u64,
        traceid: &str,
    ) -> Result<Self> {
        let common_params = build_common_params(device, req_time_ms);
        let canonical = canonicalize_params(&common_params);
        let body_json = build_job_detail_body_json(options);
        let body_bytes = signer
            .encode_request_body(body_json.as_bytes(), "")
            .context("failed to encode /api/batch/requests body via rnidbg so")?;
        let crc = crc32fast::hash(&body_bytes);
        let sp = signer
            .encode_request(canonical.as_bytes(), "")
            .context("failed to encode /api/batch/requests query via rnidbg so")?;
        let sig_input = format!(
            "{}{}{}",
            JOB_DETAIL_BATCH_REQUEST_PATH,
            truncate_for_sig(&canonical, SP_TRUNCATE_THRESHOLD),
            crc
        );
        let sig = signer
            .signature(sig_input.as_bytes(), "")
            .context("failed to sign /api/batch/requests query via rnidbg so")?;
        let zp_tag = signer
            .encode_request(traceid.as_bytes(), "")
            .context("failed to build local zp-tag for job-detail")?;

        let mut final_query_params = common_params.clone();
        final_query_params.insert("sp".to_string(), sp);
        final_query_params.insert("sig".to_string(), sig);
        final_query_params.insert("app_id".to_string(), APP_ID.to_string());

        let url = build_url(host, JOB_DETAIL_BATCH_REQUEST_PATH, &final_query_params)?;
        let mut extra_headers = HashMap::new();
        extra_headers.insert("traceid".to_string(), traceid.to_string());
        extra_headers.insert("zp-tag".to_string(), zp_tag);
        let mut headers = build_stage_inbound_headers(
            USER_AGENT,
            &host_header(host)?,
            device,
            Some(session),
            Some(extra_headers),
        );
        headers.insert(
            "Content-Type".to_string(),
            "application/octet-stream".to_string(),
        );

        Ok(Self {
            url,
            traceid: traceid.to_string(),
            headers,
            body_json: body_json.clone(),
            body_bytes,
            contract: json!({
                "type": "batch_requests_job_detail",
                "host": host,
                "endpoint": JOB_DETAIL_BATCH_REQUEST_PATH,
                "query_keys": sorted_query_keys(&final_query_params),
                "signed_query_keys": ["client_info", "curidentity", "req_time", "uniqid", "v"],
                "clear_exempt_query_keys": ["app_id"],
                "sub_request": {
                    "method": "GET",
                    "path": JOB_DETAIL_SUBREQ_PATH,
                    "query": stage2_query_pairs(options),
                }
            }),
        })
    }
}

pub(crate) trait BossSigner {
    fn encode_request(&self, data: &[u8], key: &str) -> Result<String>;
    fn encode_request_body(&self, data: &[u8], key: &str) -> Result<Vec<u8>>;
    fn signature(&self, data: &[u8], key: &str) -> Result<String>;
    fn decode_content(&self, content: &str, key: &str) -> Result<Vec<u8>>;
    fn describe(&self) -> Value;
}

pub(crate) enum RnIdbgSoInvoker {
    Local(LocalProcessInvoker),
    Bridge(HttpBridgeInvoker),
}

impl RnIdbgSoInvoker {
    pub(crate) fn new(
        config_path: PathBuf,
        lab_config: &LabConfig,
        opts: &HashMap<String, String>,
    ) -> Result<Box<dyn BossSigner>> {
        let runtime = InvokeRuntime::parse(opts.get("--invoke-runtime").map(String::as_str))?;
        let bridge_url = opts
            .get("--bridge-url")
            .cloned()
            .unwrap_or_else(|| DEFAULT_HTTP_BRIDGE_URL.to_string());

        let invoker = match runtime {
            InvokeRuntime::Local => Self::Local(LocalProcessInvoker::new(
                config_path,
                lab_config.backend.clone(),
            )?),
            InvokeRuntime::Bridge => Self::Bridge(HttpBridgeInvoker::new(bridge_url, lab_config)?),
            InvokeRuntime::Auto => {
                if local_process_usable(lab_config) {
                    Self::Local(LocalProcessInvoker::new(
                        config_path,
                        lab_config.backend.clone(),
                    )?)
                } else {
                    Self::Bridge(HttpBridgeInvoker::new(bridge_url, lab_config)?)
                }
            }
        };
        Ok(Box::new(invoker))
    }
}

impl BossSigner for RnIdbgSoInvoker {
    fn encode_request(&self, data: &[u8], key: &str) -> Result<String> {
        match self {
            Self::Local(invoker) => invoker.encode_request(data, key),
            Self::Bridge(invoker) => invoker.encode_request(data, key),
        }
    }

    fn encode_request_body(&self, data: &[u8], key: &str) -> Result<Vec<u8>> {
        match self {
            Self::Local(invoker) => invoker.encode_request_body(data, key),
            Self::Bridge(invoker) => invoker.encode_request_body(data, key),
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

pub(crate) struct LocalProcessInvoker {
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
            "compiled_backends": compiled_backend_names(),
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

    fn encode_request_body(&self, data: &[u8], key: &str) -> Result<Vec<u8>> {
        let value = self.invoke_bytes("nativeEncodeRequestBody", data, key)?;
        if let Some(output_hex) = value.get("output_hex").and_then(Value::as_str) {
            return hex::decode(output_hex)
                .context("failed to decode rnidbg nativeEncodeRequestBody hex output");
        }
        if let Some(output_utf8) = value.get("output_utf8").and_then(Value::as_str) {
            return Ok(output_utf8.as_bytes().to_vec());
        }
        Err(anyhow!("rnidbg invoke missing encodeRequestBody output"))
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

pub(crate) struct HttpBridgeInvoker {
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

    fn encode_request_body(&self, data: &[u8], key: &str) -> Result<Vec<u8>> {
        let plain = std::str::from_utf8(data)
            .context("http bridge encodeRequestBody only supports utf-8 payloads")?;
        let value = self.post_json(
            "/api/encodeRequestBody",
            json!({ "plain": plain, "key": key }),
        )?;
        let body = value
            .get("body")
            .and_then(Value::as_str)
            .ok_or_else(|| anyhow!("http bridge encodeRequestBody response missing body"))?;
        STANDARD
            .decode(body.as_bytes())
            .context("failed to decode http bridge encodeRequestBody payload")
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

#[derive(Clone, Copy)]
pub(crate) enum TransportRuntime {
    Auto,
    Direct,
    OkHttpBridge,
}

impl TransportRuntime {
    pub(crate) fn parse(value: Option<&str>) -> Result<Self> {
        match value.unwrap_or("auto").trim().to_ascii_lowercase().as_str() {
            "" | "auto" => Ok(Self::Auto),
            "direct" => Ok(Self::Direct),
            "okhttp-bridge" | "okhttp_bridge" | "okhttp" => Ok(Self::OkHttpBridge),
            other => Err(anyhow!("unsupported transport runtime: {other}")),
        }
    }
}

pub(crate) enum HttpTransport {
    Direct(Client),
    Remote(RemoteOkHttpBridgeTransport),
    BossApk(BossApkOkHttpTransport),
}

impl HttpTransport {
    pub(crate) fn discover(
        mode: TransportRuntime,
        lab_config: &LabConfig,
        opts: &HashMap<String, String>,
        http1_only: bool,
    ) -> Result<Self> {
        let configured_url = opts
            .get("--okhttp-bridge-url")
            .cloned()
            .or_else(|| std::env::var("RNIDBG_OKHTTP_BRIDGE_URL").ok())
            .filter(|value| !value.trim().is_empty());

        match mode {
            TransportRuntime::Direct => Self::build_direct(http1_only),
            TransportRuntime::OkHttpBridge => {
                if let Some(configured_url) = configured_url {
                    let base_url = normalize_bridge_url(&configured_url)?;
                    Ok(Self::Remote(RemoteOkHttpBridgeTransport::connect(
                        &base_url,
                    )?))
                } else {
                    Ok(Self::BossApk(BossApkOkHttpTransport::new(lab_config)?))
                }
            }
            TransportRuntime::Auto => {
                if let Some(configured_url) = configured_url {
                    let base_url = normalize_bridge_url(&configured_url)?;
                    Ok(Self::Remote(RemoteOkHttpBridgeTransport::connect(
                        &base_url,
                    )?))
                } else {
                    Self::build_direct(http1_only)
                }
            }
        }
    }

    fn build_direct(http1_only: bool) -> Result<Self> {
        let mut builder = Client::builder().timeout(Duration::from_secs(DEFAULT_TIMEOUT_SECONDS));
        if http1_only {
            builder = builder.http1_only();
        }
        Ok(Self::Direct(
            builder
                .build()
                .context("failed to build direct reqwest client")?,
        ))
    }

    pub(crate) fn label(&self) -> &'static str {
        match self {
            Self::Direct(_) => "direct",
            Self::Remote(_) | Self::BossApk(_) => "okhttp_bridge",
        }
    }

    pub(crate) fn original_okhttp_available(&self) -> bool {
        matches!(self, Self::Remote(_) | Self::BossApk(_))
    }

    pub(crate) fn describe(&self) -> Value {
        match self {
            Self::Direct(_) => json!({
                "status": "ready",
                "transport_runtime": "direct",
                "flow": "reqwest_direct",
            }),
            Self::Remote(transport) => transport.describe(),
            Self::BossApk(transport) => transport.describe(),
        }
    }
}

pub(crate) struct RemoteOkHttpBridgeTransport {
    base_url: String,
    health: Value,
    client: Client,
}

impl RemoteOkHttpBridgeTransport {
    fn connect(base_url: &str) -> Result<Self> {
        if let Some(health) = okhttp_bridge_health(base_url)? {
            return Ok(Self {
                base_url: base_url.to_string(),
                health,
                client: Client::builder()
                    .timeout(Duration::from_secs(DEFAULT_TIMEOUT_SECONDS))
                    .build()
                    .context("failed to build okhttp-bridge client")?,
            });
        }

        Err(anyhow!(
            "original OkHttp bridge is not reachable at {base_url}; start the Boss-side bridge first or pass --transport-runtime direct"
        ))
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

    fn request_post(
        &self,
        url: &str,
        headers: &HashMap<String, String>,
        body: &[u8],
        signer: Option<&dyn BossSigner>,
        session_secret_key: &str,
    ) -> Result<Value> {
        let request_url = format!("{}/request", self.base_url);
        let envelope = self
            .client
            .post(&request_url)
            .json(&json!({
                "method": "POST",
                "url": url,
                "headers": headers,
                "body": Value::Null,
                "body_b64": STANDARD.encode(body),
            }))
            .send()
            .with_context(|| format!("failed to call okhttp bridge: {request_url}"))?;
        let payload: Value = envelope
            .json()
            .with_context(|| format!("failed to parse okhttp bridge response: {request_url}"))?;

        let status = payload.get("status").and_then(Value::as_u64).unwrap_or(0) as u16;
        let response_body = payload
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

        if let Some(value) = parse_response_body(&response_body, signer, session_secret_key)? {
            return Ok(attach_transport(value, transport));
        }

        Ok(json!({
            "code": status,
            "message": format!("okhttp bridge returned non-json body (status={status})"),
            "raw": truncate(&response_body, 1200),
            "transport": transport,
        }))
    }

    fn request_get(
        &self,
        url: &str,
        headers: &HashMap<String, String>,
        signer: Option<&dyn BossSigner>,
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
        let response_body = payload
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

        if let Some(value) = parse_response_body(&response_body, signer, session_secret_key)? {
            return Ok(attach_transport(value, transport));
        }

        Ok(json!({
            "code": status,
            "message": format!("okhttp bridge returned non-json body (status={status})"),
            "raw": truncate(&response_body, 1200),
            "transport": transport,
        }))
    }
}

pub(crate) struct BossApkOkHttpTransport {
    apk_path: PathBuf,
    script_path: PathBuf,
}

impl BossApkOkHttpTransport {
    fn new(lab_config: &LabConfig) -> Result<Self> {
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
        })
    }

    fn describe(&self) -> Value {
        json!({
            "status": "ready",
            "transport_runtime": "okhttp_bridge",
            "flow": "boss_apk_okhttp",
            "apk_path": self.apk_path.display().to_string(),
        })
    }

    fn request_post(
        &self,
        url: &str,
        headers: &HashMap<String, String>,
        body: &[u8],
        signer: Option<&dyn BossSigner>,
        session_secret_key: &str,
    ) -> Result<Value> {
        let mut command = Command::new(&self.script_path);
        let content_type = headers
            .get("Content-Type")
            .cloned()
            .unwrap_or_else(|| "application/octet-stream".to_string());
        command
            .arg("--apk")
            .arg(&self.apk_path)
            .arg("--method")
            .arg("POST")
            .arg("--url")
            .arg(url)
            .arg("--content-type")
            .arg(content_type)
            .arg("--body-base64")
            .arg(STANDARD.encode(body));
        for (key, value) in headers {
            command.arg("--header").arg(format!("{key}: {value}"));
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
        let response_body = payload
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

        if let Some(value) = parse_response_body(&response_body, signer, session_secret_key)? {
            return Ok(attach_transport(value, transport));
        }

        Ok(json!({
            "code": status,
            "message": format!("boss apk okhttp returned non-json body (status={status})"),
            "raw": truncate(&response_body, 1200),
            "transport": transport,
        }))
    }

    fn request_get(
        &self,
        url: &str,
        headers: &HashMap<String, String>,
        signer: Option<&dyn BossSigner>,
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
        let response_body = payload
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

        if let Some(value) = parse_response_body(&response_body, signer, session_secret_key)? {
            return Ok(attach_transport(value, transport));
        }

        Ok(json!({
            "code": status,
            "message": format!("boss apk okhttp returned non-json body (status={status})"),
            "raw": truncate(&response_body, 1200),
            "transport": transport,
        }))
    }
}

pub(crate) fn execute_post(
    transport: &HttpTransport,
    url: &str,
    headers: &HashMap<String, String>,
    body: &[u8],
    signer: Option<&dyn BossSigner>,
    session_secret_key: &str,
) -> Result<Value> {
    match transport {
        HttpTransport::Direct(client) => {
            let response = client
                .post(url)
                .headers(to_header_map(headers)?)
                .body(body.to_vec())
                .send();
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
                    });
                    if let Some(value) = parse_response_body(&text, signer, session_secret_key)? {
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
        HttpTransport::Remote(transport) => {
            transport.request_post(url, headers, body, signer, session_secret_key)
        }
        HttpTransport::BossApk(transport) => {
            transport.request_post(url, headers, body, signer, session_secret_key)
        }
    }
}

pub(crate) fn execute_get(
    transport: &HttpTransport,
    url: &str,
    headers: &HashMap<String, String>,
    signer: Option<&dyn BossSigner>,
    session_secret_key: &str,
) -> Result<Value> {
    match transport {
        HttpTransport::Direct(client) => {
            let response = client.get(url).headers(to_header_map(headers)?).send();
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
                    });
                    if let Some(value) = parse_response_body(&text, signer, session_secret_key)? {
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
        HttpTransport::Remote(transport) => {
            transport.request_get(url, headers, signer, session_secret_key)
        }
        HttpTransport::BossApk(transport) => {
            transport.request_get(url, headers, signer, session_secret_key)
        }
    }
}

fn parse_response_body(
    body: &str,
    signer: Option<&dyn BossSigner>,
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

    let Some(signer) = signer else {
        return Ok(None);
    };
    let mut best_payload: Option<(u8, Value)> = None;
    for key in decode_secret_key_candidates(session_secret_key) {
        if let Ok(decoded) = signer.decode_content(trimmed, &key) {
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

fn decode_secret_key_candidates(secret_key: &str) -> Vec<String> {
    let mut keys = vec![String::new()];
    let trimmed = secret_key.trim();
    if !trimmed.is_empty() {
        keys.push(trimmed.to_string());
    }
    keys
}

fn normalize_job_detail_response(payload: &Value) -> Value {
    let Some(node) = extract_job_detail_subresp(payload) else {
        return payload.clone();
    };

    let mut normalized = node;
    if let Some(object) = normalized.as_object_mut() {
        object
            .entry("transport".to_string())
            .or_insert_with(|| payload.get("transport").cloned().unwrap_or(Value::Null));
        object.insert(
            "batch".to_string(),
            json!({
                "request_path": JOB_DETAIL_BATCH_REQUEST_PATH,
                "response_key": JOB_DETAIL_SUBREQ_PATH,
            }),
        );
    }
    normalized
}

fn extract_job_detail_subresp(payload: &Value) -> Option<Value> {
    let zp_data = payload.get("zpData").and_then(Value::as_object)?;
    let candidates = [
        JOB_DETAIL_SUBREQ_PATH.to_string(),
        JOB_DETAIL_SUBREQ_PATH
            .trim_start_matches("/api/")
            .to_string(),
        JOB_DETAIL_SUBREQ_PATH
            .trim_start_matches("/api/")
            .replace('/', "."),
    ];
    for candidate in candidates {
        if let Some(node) = zp_data.get(&candidate) {
            return Some(node.clone());
        }
    }
    for (key, value) in zp_data {
        if key == JOB_DETAIL_SUBREQ_PATH
            || key.starts_with(JOB_DETAIL_SUBREQ_PATH)
            || key.ends_with("/job/querydetail")
        {
            return Some(value.clone());
        }
    }
    None
}

fn summarize_job_detail_payload(payload: &Value) -> Value {
    let Some(node) = payload.as_object() else {
        return json!({});
    };
    if response_code(Some(payload)) != Some(0) {
        return json!({});
    }
    let zp_data = node.get("zpData").and_then(Value::as_object);
    let Some(zp_data) = zp_data else {
        return json!({});
    };
    let job_base = zp_data
        .get("jobBaseInfo")
        .and_then(Value::as_object)
        .cloned()
        .unwrap_or_default();
    let brand = zp_data
        .get("brandComInfo")
        .and_then(Value::as_object)
        .cloned()
        .unwrap_or_default();
    json!({
        "position_name": coerce_text(job_base.get("positionName").or_else(|| job_base.get("jobName"))),
        "salary_desc": coerce_text(job_base.get("salaryDesc")),
        "location": coerce_text(job_base.get("locationName").or_else(|| job_base.get("locationDesc"))),
        "company_name": coerce_text(brand.get("brandName").or_else(|| brand.get("comName"))),
        "job_id": coerce_text(job_base.get("jobId")),
        "security_id": coerce_text(zp_data.get("securityId").or_else(|| job_base.get("securityId"))),
    })
}

fn coerce_text(value: Option<&Value>) -> String {
    match value {
        Some(Value::String(text)) => text.to_string(),
        Some(Value::Number(number)) => number.to_string(),
        Some(Value::Object(object)) => {
            for key in ["name", "text", "content", "title"] {
                if let Some(Value::String(text)) = object.get(key) {
                    return text.to_string();
                }
            }
            String::new()
        }
        Some(other) => other.to_string(),
        None => String::new(),
    }
}

fn build_job_detail_body_json(options: &JobDetailRequestOptions) -> String {
    let body = json!({
        "subReqs": [
            {
                "method": "GET",
                "path": JOB_DETAIL_SUBREQ_PATH,
                "query": encode_stage2_query(&stage2_query_pairs(options)),
            }
        ]
    });
    escape_batch_body_json(
        &serde_json::to_string(&body).unwrap_or_else(|_| "{\"subReqs\":[]}".to_string()),
    )
}

fn stage2_query_pairs(options: &JobDetailRequestOptions) -> Vec<(String, String)> {
    vec![
        ("jobType".to_string(), "-1".to_string()),
        ("keyword".to_string(), options.keyword.clone()),
        ("lid".to_string(), options.lid.clone()),
        (
            "needRelatedJob".to_string(),
            if options.need_related_job {
                "true".to_string()
            } else {
                "false".to_string()
            },
        ),
        ("page".to_string(), options.page.to_string()),
        ("query".to_string(), options.query.clone()),
        ("requestSource".to_string(), options.request_source.clone()),
        ("securityId".to_string(), options.security_id.clone()),
        ("sourceType".to_string(), options.source_type.clone()),
        ("wayType".to_string(), options.way_type.clone()),
    ]
}

fn encode_stage2_query(pairs: &[(String, String)]) -> String {
    pairs
        .iter()
        .map(|(key, value)| {
            format!(
                "{}={}",
                stage2_query_component(key),
                stage2_query_component(value)
            )
        })
        .collect::<Vec<_>>()
        .join("&")
}

fn stage2_query_component(value: &str) -> String {
    let mut out = String::new();
    for byte in value.as_bytes() {
        match byte {
            b'0'..=b'9' | b'a'..=b'z' | b'A'..=b'Z' | b'-' | b'.' | b'_' => out.push(*byte as char),
            b' ' => out.push('+'),
            _ => out.push_str(&format!("%{byte:02X}")),
        }
    }
    out
}

fn escape_batch_body_json(body_json: &str) -> String {
    body_json
        .replace('=', "\\u003d")
        .replace('&', "\\u0026")
        .replace('\'', "\\u0027")
        .replace('<', "\\u003c")
        .replace('>', "\\u003e")
}

pub(crate) fn build_common_params(
    device: &DeviceConfig,
    req_time_ms: u64,
) -> BTreeMap<String, String> {
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

pub(crate) fn canonicalize_params(params: &BTreeMap<String, String>) -> String {
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

fn build_url(host: &str, path: &str, params: &BTreeMap<String, String>) -> Result<String> {
    let base = format!(
        "{}/{}",
        host.trim_end_matches('/'),
        path.trim_start_matches('/')
    );
    let mut url = Url::parse(&base).with_context(|| format!("invalid host url: {host}"))?;
    {
        let mut pairs = url.query_pairs_mut();
        for (key, value) in params {
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

pub(crate) fn response_code(value: Option<&Value>) -> Option<i64> {
    value
        .and_then(|payload| payload.get("code"))
        .and_then(Value::as_i64)
}

fn sorted_query_keys(params: &BTreeMap<String, String>) -> Vec<String> {
    params.keys().cloned().collect()
}

fn host_header(host: &str) -> Result<String> {
    let parsed = Url::parse(host).with_context(|| format!("invalid host url: {host}"))?;
    Ok(match parsed.port() {
        Some(port) => format!(
            "{}:{}",
            parsed.host_str().unwrap_or("api-and.zhipin.com"),
            port
        ),
        None => parsed
            .host_str()
            .unwrap_or("api-and.zhipin.com")
            .to_string(),
    })
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

fn required_security_id(opts: &HashMap<String, String>) -> Result<String> {
    let candidate = opts
        .get("--security-id")
        .or_else(|| opts.get("_0"))
        .map(|value| value.trim().to_string())
        .filter(|value| !value.is_empty());
    candidate.ok_or_else(|| {
        anyhow!("job-detail requires --security-id <value> or positional <securityId>")
    })
}

pub(crate) fn parse_bool_flag(opts: &HashMap<String, String>, key: &str) -> bool {
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

fn normalize_bridge_url(url: &str) -> Result<String> {
    let parsed = Url::parse(url).with_context(|| format!("invalid bridge url: {url}"))?;
    let host = parsed
        .host_str()
        .ok_or_else(|| anyhow!("bridge url missing host: {url}"))?;
    let port = parsed
        .port_or_known_default()
        .ok_or_else(|| anyhow!("bridge url missing port: {url}"))?;
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

fn resolve_repo_root() -> PathBuf {
    PathBuf::from(env!("CARGO_MANIFEST_DIR"))
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

pub(crate) fn redact_headers(headers: &HashMap<String, String>) -> Value {
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

pub(crate) fn resolve_output_path(path: Option<&str>, default_name: &str) -> PathBuf {
    if let Some(path) = path {
        return PathBuf::from(path);
    }
    std::env::current_dir()
        .unwrap_or_else(|_| PathBuf::from("."))
        .join(default_name)
}

pub(crate) fn resolved_session_path(session_path: Option<&str>) -> String {
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

pub(crate) fn normalize_host(host: &str) -> String {
    let text = host.trim();
    if text.is_empty() {
        JOB_DETAIL_BATCH_HOST.to_string()
    } else if text.starts_with("http://") || text.starts_with("https://") {
        text.trim_end_matches('/').to_string()
    } else {
        format!("https://{}", text.trim_end_matches('/'))
    }
}

pub(crate) fn build_traceid() -> String {
    let a = rand::random::<u32>();
    let b = rand::random::<u16>();
    let c = rand::random::<u16>();
    let d = rand::random::<u16>();
    let e_hi = rand::random::<u16>();
    let e_lo = rand::random::<u32>();
    format!("A-{a:08x}-{b:04x}-{c:04x}-{d:04x}-{e_hi:04x}{e_lo:08x}")
}

pub(crate) fn now_ms() -> u64 {
    std::time::SystemTime::now()
        .duration_since(std::time::UNIX_EPOCH)
        .unwrap_or_default()
        .as_millis() as u64
}

pub(crate) fn truncate_for_sig(value: &str, max_len: usize) -> String {
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

    #[derive(Default)]
    struct FakeSigner {
        encoded_body: Vec<u8>,
        signature_inputs: Vec<String>,
        body_inputs: Vec<String>,
        query_inputs: Vec<String>,
    }

    impl BossSigner for std::cell::RefCell<FakeSigner> {
        fn encode_request(&self, data: &[u8], _key: &str) -> Result<String> {
            let text = String::from_utf8_lossy(data).to_string();
            self.borrow_mut().query_inputs.push(text.clone());
            if text.starts_with("A-") {
                Ok("ZP_TAG".to_string())
            } else {
                Ok("SP".to_string())
            }
        }

        fn encode_request_body(&self, data: &[u8], _key: &str) -> Result<Vec<u8>> {
            let text = String::from_utf8_lossy(data).to_string();
            self.borrow_mut().body_inputs.push(text);
            Ok(self.borrow().encoded_body.clone())
        }

        fn signature(&self, data: &[u8], _key: &str) -> Result<String> {
            let text = String::from_utf8_lossy(data).to_string();
            self.borrow_mut().signature_inputs.push(text);
            Ok("SIG".to_string())
        }

        fn decode_content(&self, _content: &str, _key: &str) -> Result<Vec<u8>> {
            Ok(Vec::new())
        }

        fn describe(&self) -> Value {
            json!({})
        }
    }

    fn sample_session() -> SessionConfig {
        SessionConfig {
            uid: "1".to_string(),
            identity: "0".to_string(),
            token: "tok1".to_string(),
            token2: "tok2".to_string(),
            wt: "wt".to_string(),
            zp_at: "zp".to_string(),
            secret_key: "secret".to_string(),
            fp_uniqid: "uniq".to_string(),
            fp_did: "did".to_string(),
            fp_oaid: "oaid".to_string(),
            fp_oaid_honor: "honor".to_string(),
            fp_brand: "realme".to_string(),
            fp_model: "realme||RMX3560".to_string(),
            fp_network: "wifi".to_string(),
            fp_operator: "operator".to_string(),
            fp_tinker_id: "tinker".to_string(),
            ..SessionConfig::default()
        }
    }

    #[test]
    fn encode_stage2_query_matches_complex_contract_shape() {
        let options = JobDetailRequestOptions {
            security_id: "sec_test".to_string(),
            lid: "lid_1".to_string(),
            need_related_job: true,
            page: 1,
            request_source: "0".to_string(),
            source_type: "0".to_string(),
            way_type: "0".to_string(),
            keyword: "python".to_string(),
            query: String::new(),
        };
        let query = encode_stage2_query(&stage2_query_pairs(&options));
        assert!(query.contains("securityId=sec_test"));
        assert!(query.contains("needRelatedJob=true"));
        assert!(query.contains("page=1"));
        assert!(query.contains("lid=lid_1"));
        assert!(query.contains("keyword=python"));
    }

    #[test]
    fn prepared_job_detail_request_keeps_business_params_in_body_and_app_id_clear() {
        let session = sample_session();
        let device = DeviceConfig::from_session(&session);
        let signer = std::cell::RefCell::new(FakeSigner {
            encoded_body: b"encoded-body".to_vec(),
            ..FakeSigner::default()
        });
        let prepared = PreparedJobDetailRequest::sign(
            &JobDetailRequestOptions {
                security_id: "sec_test".to_string(),
                lid: "lid_1".to_string(),
                need_related_job: true,
                page: 1,
                request_source: "0".to_string(),
                source_type: "0".to_string(),
                way_type: "0".to_string(),
                keyword: String::new(),
                query: String::new(),
            },
            JOB_DETAIL_BATCH_HOST,
            &device,
            &session,
            &signer,
            123,
            "A-fixed-trace",
        )
        .unwrap();

        let parsed = Url::parse(&prepared.url).unwrap();
        let query = parsed
            .query_pairs()
            .into_owned()
            .collect::<HashMap<String, String>>();
        assert_eq!(query.get("app_id").map(String::as_str), Some(APP_ID));
        assert!(query.contains_key("client_info"));
        assert!(query.contains_key("curidentity"));
        assert!(query.contains_key("req_time"));
        assert!(query.contains_key("uniqid"));
        assert!(query.contains_key("v"));
        assert_eq!(query.get("sp").map(String::as_str), Some("SP"));
        assert_eq!(query.get("sig").map(String::as_str), Some("SIG"));
        assert!(!query.contains_key("securityId"));
        assert!(!query.contains_key("lid"));

        let body: Value = serde_json::from_str(&prepared.body_json).unwrap();
        assert_eq!(
            body.get("subReqs")
                .and_then(Value::as_array)
                .and_then(|items| items.first())
                .and_then(|item| item.get("path"))
                .and_then(Value::as_str),
            Some(JOB_DETAIL_SUBREQ_PATH)
        );
    }

    #[test]
    fn prepared_job_detail_request_signs_with_body_crc32() {
        let session = sample_session();
        let device = DeviceConfig::from_session(&session);
        let signer = std::cell::RefCell::new(FakeSigner {
            encoded_body: b"encoded-body".to_vec(),
            ..FakeSigner::default()
        });
        let prepared = PreparedJobDetailRequest::sign(
            &JobDetailRequestOptions {
                security_id: "sec_test".to_string(),
                lid: String::new(),
                need_related_job: false,
                page: 0,
                request_source: "0".to_string(),
                source_type: "0".to_string(),
                way_type: "0".to_string(),
                keyword: String::new(),
                query: String::new(),
            },
            JOB_DETAIL_BATCH_HOST,
            &device,
            &session,
            &signer,
            123,
            "A-fixed-trace",
        )
        .unwrap();

        let crc = crc32fast::hash(b"encoded-body");
        let borrow = signer.borrow();
        let sig_input = borrow.signature_inputs.first().cloned().unwrap();
        assert!(sig_input.starts_with(JOB_DETAIL_BATCH_REQUEST_PATH));
        assert!(sig_input.ends_with(&crc.to_string()));
        let body_input = borrow.body_inputs.first().cloned().unwrap();
        assert!(body_input.contains("\\u003d"));
        assert!(body_input.contains("\\u0026"));
        assert_eq!(prepared.traceid, "A-fixed-trace");
    }

    #[test]
    fn extract_job_detail_subresp_accepts_path_style_key() {
        let payload = json!({
            "code": 0,
            "zpData": {
                JOB_DETAIL_SUBREQ_PATH: {
                    "code": 0,
                    "zpData": {
                        "securityId": "sec_a",
                    }
                }
            }
        });
        let node = extract_job_detail_subresp(&payload).unwrap();
        assert_eq!(response_code(Some(&node)), Some(0));
    }

    #[test]
    fn summarize_job_detail_payload_extracts_core_fields() {
        let response = json!({
            "code": 0,
            "message": "Success",
            "zpData": {
                "securityId": "sec_a",
                "jobBaseInfo": {
                    "positionName": "Python开发工程师",
                    "salaryDesc": "15-25K",
                    "locationName": "上海",
                    "jobId": 123456
                },
                "brandComInfo": {
                    "brandName": "Acme"
                }
            }
        });
        let summary = summarize_job_detail_payload(&response);
        assert_eq!(
            summary.get("position_name").and_then(Value::as_str),
            Some("Python开发工程师")
        );
        assert_eq!(
            summary.get("salary_desc").and_then(Value::as_str),
            Some("15-25K")
        );
        assert_eq!(
            summary.get("location").and_then(Value::as_str),
            Some("上海")
        );
        assert_eq!(
            summary.get("company_name").and_then(Value::as_str),
            Some("Acme")
        );
        assert_eq!(
            summary.get("job_id").and_then(Value::as_str),
            Some("123456")
        );
        assert_eq!(
            summary.get("security_id").and_then(Value::as_str),
            Some("sec_a")
        );
    }
}
