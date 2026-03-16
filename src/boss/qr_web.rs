use std::collections::HashMap;
use std::fs;
use std::io::Read;
use std::net::UdpSocket;
use std::path::{Path, PathBuf};

use anyhow::{anyhow, Context, Result};
use base64::engine::general_purpose::STANDARD;
use base64::Engine;
use serde::Deserialize;
use serde_json::{json, Value};
use tiny_http::{Header, Method, Response, Server, StatusCode};

use super::qr_authorize::authorize_decoded_qrs;
use super::qr_codec::{decode_login_qr_bytes, manual_login_qr_payload, DecodedQrImage};

const DEFAULT_BIND_HOST: &str = "0.0.0.0";
const DEFAULT_PORT: u16 = 8786;
const DEFAULT_STATE_DIR: &str = "artifacts/qr-web";

#[derive(Clone)]
struct QrWebRuntime {
    bind_host: String,
    port: u16,
    authorize_opts: HashMap<String, String>,
    lan_origin: Option<String>,
    public_origin: Option<String>,
    state_dir: PathBuf,
}

#[derive(Debug, Default, Deserialize)]
#[serde(default)]
struct DecodeRequest {
    image_b64: String,
    image_name: Option<String>,
    qr_text: Option<String>,
}

#[derive(Debug, Default, Deserialize)]
#[serde(default)]
struct AuthorizeRequest {
    first_image_b64: String,
    first_image_name: Option<String>,
    first_qr_text: Option<String>,
    second_image_b64: String,
    second_image_name: Option<String>,
    second_qr_text: Option<String>,
    login_type: Option<i32>,
    edit_type: Option<String>,
    action_id: Option<String>,
    extra_info: Option<String>,
    sleep_before_login_ms: Option<u64>,
    loc_per: Option<bool>,
    latitude: Option<String>,
    longitude: Option<String>,
    ssid: Option<String>,
    bssid: Option<String>,
}

pub fn run_qr_web(opts: &HashMap<String, String>) -> Result<()> {
    let bind_host = resolve_bind_host(opts);
    let port = opts
        .get("--port")
        .and_then(|value| value.parse::<u16>().ok())
        .unwrap_or(DEFAULT_PORT);
    let state_dir = resolve_state_dir(opts);
    ensure_state_layout(&state_dir)?;
    let runtime = QrWebRuntime {
        bind_host: bind_host.clone(),
        port,
        authorize_opts: build_authorize_opts(opts),
        lan_origin: detect_lan_origin(port),
        public_origin: resolve_public_origin(opts, port),
        state_dir,
    };
    let server = Server::http((bind_host.as_str(), port))
        .map_err(|err| anyhow!("failed to bind qr web server on {bind_host}:{port}: {err}"))?;

    println!("[boss-qr-web] listening on http://{}:{}", bind_host, port);
    if let Some(origin) = &runtime.lan_origin {
        println!("[boss-qr-web] lan origin: {origin}");
    }
    if let Some(origin) = &runtime.public_origin {
        println!("[boss-qr-web] public origin: {origin}");
    }
    println!("[boss-qr-web] state dir: {}", runtime.state_dir.display());
    println!("[boss-qr-web] endpoints:");
    println!("  GET  /");
    println!("  GET  /health");
    println!("  GET  /api/state/latest");
    println!("  POST /api/decode");
    println!("  POST /api/authorize");
    println!(
        "[boss-qr-web] qr auth target host: {}",
        runtime
            .authorize_opts
            .get("--host")
            .map(String::as_str)
            .unwrap_or("auto(api5/api-and)")
    );

    for mut request in server.incoming_requests() {
        let response = match (request.method(), request.url()) {
            (&Method::Get, "/") => html_response(render_index_html(&runtime)),
            (&Method::Get, "/health") => json_response(
                StatusCode(200),
                json!({
                    "status": "ok",
                    "bind_host": runtime.bind_host,
                    "port": runtime.port,
                    "lan_origin": runtime.lan_origin,
                    "public_origin": runtime.public_origin,
                    "state_dir": runtime.state_dir.display().to_string(),
                    "authorize_target_host": runtime.authorize_opts.get("--host"),
                    "transport_runtime": runtime.authorize_opts.get("--transport-runtime"),
                    "session_path": runtime.authorize_opts.get("--session-path"),
                    "config_path": runtime.authorize_opts.get("--config"),
                }),
            ),
            (&Method::Get, "/api/state/latest") => match read_latest_state(&runtime.state_dir) {
                Ok(body) => json_response(StatusCode(200), body),
                Err(err) => error_response(err),
            },
            (&Method::Post, "/api/decode") => match read_json(&mut request)
                .and_then(|body| {
                    serde_json::from_value::<DecodeRequest>(body).context("invalid decode request")
                })
                .and_then(|body| handle_decode(&runtime, body))
            {
                Ok(body) => json_response(StatusCode(200), body),
                Err(err) => error_response(err),
            },
            (&Method::Post, "/api/authorize") => match read_json(&mut request)
                .and_then(|body| {
                    serde_json::from_value::<AuthorizeRequest>(body)
                        .context("invalid authorize request")
                })
                .and_then(|body| handle_authorize(&runtime, body))
            {
                Ok(body) => json_response(StatusCode(200), body),
                Err(err) => error_response(err),
            },
            _ => json_response(StatusCode(404), json!({ "error": "not found" })),
        };

        if let Err(err) = request.respond(response) {
            eprintln!("failed to write qr web response: {err}");
        }
    }

    Ok(())
}

fn handle_decode(runtime: &QrWebRuntime, body: DecodeRequest) -> Result<Value> {
    let first_upload = persist_upload(
        &runtime.state_dir,
        "first",
        body.image_b64.as_str(),
        body.image_name.as_deref(),
    )?;
    let saved_first_upload = first_upload
        .saved_path
        .as_ref()
        .map(|value| value.display().to_string());
    let decoded = decode_source("first", body.qr_text.as_deref(), &first_upload)?;
    let output = json!({
        "ok": true,
        "decoded": serde_json::to_value(&decoded)?,
        "persistence": {
            "state_dir": runtime.state_dir.display().to_string(),
            "saved_first_upload": saved_first_upload,
            "latest_decode_path": runtime.state_dir.join("latest_decode.json").display().to_string(),
        }
    });
    write_json_file(
        &runtime.state_dir.join("latest_decode.json"),
        &json!({
            "request": {
                "image_name": body.image_name,
                "qr_text_present": body.qr_text.as_ref().is_some_and(|value| !value.trim().is_empty()),
            },
            "result": output,
        }),
    )?;
    Ok(json!({
        "ok": true,
        "decoded": serde_json::to_value(decoded)?,
        "persistence": {
            "state_dir": runtime.state_dir.display().to_string(),
            "saved_first_upload": saved_first_upload,
            "latest_decode_path": runtime.state_dir.join("latest_decode.json").display().to_string(),
        }
    }))
}

fn handle_authorize(runtime: &QrWebRuntime, body: AuthorizeRequest) -> Result<Value> {
    let first_upload = persist_upload(
        &runtime.state_dir,
        "first",
        body.first_image_b64.as_str(),
        body.first_image_name.as_deref(),
    )?;
    let second_upload = persist_upload(
        &runtime.state_dir,
        "second",
        body.second_image_b64.as_str(),
        body.second_image_name.as_deref(),
    )?;
    let saved_first_upload = first_upload
        .saved_path
        .as_ref()
        .map(|value| value.display().to_string());
    let saved_second_upload = second_upload
        .saved_path
        .as_ref()
        .map(|value| value.display().to_string());
    let first = decode_source("first", body.first_qr_text.as_deref(), &first_upload)?;
    let second = optional_decode_source("second", body.second_qr_text.as_deref(), &second_upload)?;
    let mut authorize_opts = runtime.authorize_opts.clone();
    patch_request_overrides(&mut authorize_opts, &body);
    let result = authorize_decoded_qrs(&first, second.as_ref(), &authorize_opts)?;
    let output = json!({
        "ok": result.get("ok").and_then(Value::as_bool).unwrap_or(false),
        "entrypoint": "boss_qr_web_lan",
        "decoded_first": serde_json::to_value(&first)?,
        "decoded_second": second.map(serde_json::to_value).transpose()?.unwrap_or(Value::Null),
        "authorization": result,
        "persistence": {
            "state_dir": runtime.state_dir.display().to_string(),
            "saved_first_upload": saved_first_upload,
            "saved_second_upload": saved_second_upload,
            "latest_authorize_path": runtime.state_dir.join("latest_authorize.json").display().to_string(),
        },
        "contract_alignment": {
            "web_entry": "separate boss::qr_web module",
            "decode_chain": "qr_codec::decode_login_qr_bytes/manual_login_qr_payload",
            "authorize_chain": "qr_authorize::authorize_decoded_qrs -> webScanEdit/webSecondScan/login",
            "bind_scope": "0.0.0.0 LAN exposed",
        }
    });
    write_json_file(
        &runtime.state_dir.join("latest_authorize.json"),
        &json!({
            "request": {
                "first_image_name": body.first_image_name,
                "first_qr_text_present": body.first_qr_text.as_ref().is_some_and(|value| !value.trim().is_empty()),
                "second_image_name": body.second_image_name,
                "second_qr_text_present": body.second_qr_text.as_ref().is_some_and(|value| !value.trim().is_empty()),
                "login_type": body.login_type,
                "edit_type": body.edit_type,
                "action_id": body.action_id,
                "extra_info": body.extra_info,
                "sleep_before_login_ms": body.sleep_before_login_ms,
            },
            "result": output,
        }),
    )?;
    Ok(output)
}

#[derive(Clone)]
struct PersistedUpload {
    image_bytes: Vec<u8>,
    source_label: String,
    saved_path: Option<PathBuf>,
}

fn decode_source(
    label: &str,
    qr_text: Option<&str>,
    upload: &PersistedUpload,
) -> Result<DecodedQrImage> {
    if let Some(text) = qr_text.map(str::trim).filter(|value| !value.is_empty()) {
        return manual_login_qr_payload(&format!("<web-{label}-text>"), text);
    }
    if upload.image_bytes.is_empty() {
        return Err(anyhow!("missing {label} qr image payload"));
    }
    decode_login_qr_bytes(&upload.source_label, &upload.image_bytes)
}

fn optional_decode_source(
    label: &str,
    qr_text: Option<&str>,
    upload: &PersistedUpload,
) -> Result<Option<DecodedQrImage>> {
    let has_text = qr_text
        .map(str::trim)
        .is_some_and(|value| !value.is_empty());
    let has_image = !upload.image_bytes.is_empty();
    if !has_text && !has_image {
        return Ok(None);
    }
    decode_source(label, qr_text, upload).map(Some)
}

fn decode_image_b64(image_b64: &str) -> Result<Vec<u8>> {
    let trimmed = image_b64.trim();
    if trimmed.is_empty() {
        return Err(anyhow!("missing qr image payload"));
    }
    let raw = trimmed
        .split_once(',')
        .map(|(_, payload)| payload)
        .unwrap_or(trimmed);
    STANDARD
        .decode(raw.as_bytes())
        .context("failed to decode image_b64")
}

fn patch_request_overrides(opts: &mut HashMap<String, String>, body: &AuthorizeRequest) {
    insert_optional_string(
        opts,
        "--login-type",
        body.login_type.map(|value| value.to_string()),
    );
    insert_optional_string(opts, "--edit-type", body.edit_type.clone());
    insert_optional_string(opts, "--action-id", body.action_id.clone());
    insert_optional_string(opts, "--extra-info", body.extra_info.clone());
    insert_optional_string(
        opts,
        "--sleep-before-login-ms",
        body.sleep_before_login_ms.map(|value| value.to_string()),
    );
    insert_optional_string(opts, "--latitude", normalize_option(body.latitude.clone()));
    insert_optional_string(
        opts,
        "--longitude",
        normalize_option(body.longitude.clone()),
    );
    insert_optional_string(opts, "--ssid", normalize_option(body.ssid.clone()));
    insert_optional_string(opts, "--bssid", normalize_option(body.bssid.clone()));
    if let Some(loc_per) = body.loc_per {
        opts.insert(
            "--loc-per".to_string(),
            if loc_per { "true" } else { "false" }.to_string(),
        );
    }
}

fn normalize_option(value: Option<String>) -> Option<String> {
    value
        .map(|text| text.trim().to_string())
        .filter(|text| !text.is_empty())
}

fn insert_optional_string(opts: &mut HashMap<String, String>, key: &str, value: Option<String>) {
    if let Some(value) = value {
        opts.insert(key.to_string(), value);
    }
}

fn build_authorize_opts(cli_opts: &HashMap<String, String>) -> HashMap<String, String> {
    let mut out = HashMap::new();
    for key in [
        "--session-path",
        "--config",
        "--backend",
        "--invoke-runtime",
        "--bridge-url",
        "--transport-runtime",
        "--okhttp-bridge-url",
        "--http1-only",
        "--edit-type",
        "--action-id",
        "--extra-info",
        "--login-type",
        "--sleep-before-login-ms",
        "--loc-per",
        "--latitude",
        "--longitude",
        "--ssid",
        "--bssid",
    ] {
        if let Some(value) = cli_opts.get(key) {
            out.insert(key.to_string(), value.clone());
        }
    }
    if let Some(api_host) = resolve_api_host(cli_opts) {
        out.insert("--host".to_string(), api_host);
    }
    out
}

fn resolve_bind_host(opts: &HashMap<String, String>) -> String {
    if let Some(value) = opts
        .get("--bind-host")
        .or_else(|| opts.get("--listen-host"))
    {
        return value.clone();
    }
    if let Some(value) = opts.get("--host") {
        if !looks_like_api_host(value) {
            return value.clone();
        }
    }
    DEFAULT_BIND_HOST.to_string()
}

fn resolve_api_host(opts: &HashMap<String, String>) -> Option<String> {
    if let Some(value) = opts.get("--api-host") {
        return Some(value.clone());
    }
    opts.get("--host")
        .filter(|value| looks_like_api_host(value))
        .cloned()
}

fn looks_like_api_host(value: &str) -> bool {
    value.starts_with("http://") || value.starts_with("https://")
}

fn detect_lan_origin(port: u16) -> Option<String> {
    let socket = UdpSocket::bind("0.0.0.0:0").ok()?;
    socket.connect("8.8.8.8:80").ok()?;
    let ip = socket.local_addr().ok()?.ip();
    Some(format!("http://{}:{port}", ip))
}

fn resolve_public_origin(opts: &HashMap<String, String>, port: u16) -> Option<String> {
    if let Some(origin) = opts.get("--public-origin") {
        let trimmed = origin.trim();
        if !trimmed.is_empty() {
            return Some(trimmed.to_string());
        }
    }
    std::env::var("RNIDBG_QR_WEB_PUBLIC_ORIGIN")
        .ok()
        .filter(|value| !value.trim().is_empty())
        .or_else(|| detect_lan_origin(port))
}

fn resolve_state_dir(opts: &HashMap<String, String>) -> PathBuf {
    if let Some(path) = opts.get("--state-dir") {
        let trimmed = path.trim();
        if !trimmed.is_empty() {
            return PathBuf::from(trimmed);
        }
    }
    if let Ok(path) = std::env::var("RNIDBG_QR_WEB_STATE_DIR") {
        if !path.trim().is_empty() {
            return PathBuf::from(path);
        }
    }
    PathBuf::from(DEFAULT_STATE_DIR)
}

fn ensure_state_layout(state_dir: &Path) -> Result<()> {
    fs::create_dir_all(state_dir.join("uploads")).with_context(|| {
        format!(
            "failed to create qr web state dir: {}",
            state_dir.join("uploads").display()
        )
    })
}

fn read_latest_state(state_dir: &Path) -> Result<Value> {
    Ok(json!({
        "state_dir": state_dir.display().to_string(),
        "latest_decode": read_optional_json_file(&state_dir.join("latest_decode.json"))?,
        "latest_authorize": read_optional_json_file(&state_dir.join("latest_authorize.json"))?,
    }))
}

fn read_optional_json_file(path: &Path) -> Result<Value> {
    if !path.exists() {
        return Ok(Value::Null);
    }
    let bytes = fs::read(path)
        .with_context(|| format!("failed to read persisted state file: {}", path.display()))?;
    serde_json::from_slice(&bytes)
        .with_context(|| format!("failed to parse persisted state file: {}", path.display()))
}

fn write_json_file(path: &Path, value: &Value) -> Result<()> {
    if let Some(parent) = path.parent() {
        fs::create_dir_all(parent)
            .with_context(|| format!("failed to create state dir: {}", parent.display()))?;
    }
    fs::write(path, serde_json::to_vec_pretty(value)?)
        .with_context(|| format!("failed to write state file: {}", path.display()))
}

fn persist_upload(
    state_dir: &Path,
    label: &str,
    image_b64: &str,
    image_name: Option<&str>,
) -> Result<PersistedUpload> {
    let trimmed = image_b64.trim();
    if trimmed.is_empty() {
        return Ok(PersistedUpload {
            image_bytes: Vec::new(),
            source_label: format!("<web-{label}:missing>"),
            saved_path: None,
        });
    }
    let image_bytes = decode_image_b64(trimmed)?;
    let file_name = sanitize_file_name(image_name.unwrap_or("qr-upload.jpg"));
    let saved_path = state_dir
        .join("uploads")
        .join(format!("latest-{label}-{file_name}"));
    fs::write(&saved_path, &image_bytes)
        .with_context(|| format!("failed to persist upload: {}", saved_path.display()))?;
    Ok(PersistedUpload {
        image_bytes,
        source_label: format!("<web-{label}:{file_name}>"),
        saved_path: Some(saved_path),
    })
}

fn sanitize_file_name(input: &str) -> String {
    let mut output = String::with_capacity(input.len());
    for ch in input.chars() {
        if ch.is_ascii_alphanumeric() || matches!(ch, '.' | '-' | '_') {
            output.push(ch);
        } else {
            output.push('_');
        }
    }
    let trimmed = output.trim_matches(|ch| ch == '_' || ch == '.');
    if trimmed.is_empty() {
        "qr-upload.jpg".to_string()
    } else {
        trimmed.to_string()
    }
}

fn read_json(request: &mut tiny_http::Request) -> Result<Value> {
    let mut body = String::new();
    request
        .as_reader()
        .read_to_string(&mut body)
        .context("failed to read request body")?;
    if body.trim().is_empty() {
        return Ok(json!({}));
    }
    serde_json::from_str(&body).context("failed to parse request json")
}

fn json_response(status: StatusCode, body: Value) -> Response<std::io::Cursor<Vec<u8>>> {
    let data = serde_json::to_vec(&body)
        .unwrap_or_else(|_| b"{\"error\":\"serialization failed\"}".to_vec());
    let mut response = Response::from_data(data).with_status_code(status);
    response.add_header(Header::from_bytes("Content-Type", "application/json").unwrap());
    response.add_header(Header::from_bytes("Access-Control-Allow-Origin", "*").unwrap());
    response
}

fn html_response(body: String) -> Response<std::io::Cursor<Vec<u8>>> {
    let mut response = Response::from_string(body);
    response.add_header(Header::from_bytes("Content-Type", "text/html; charset=utf-8").unwrap());
    response
}

fn error_response(err: anyhow::Error) -> Response<std::io::Cursor<Vec<u8>>> {
    json_response(StatusCode(500), json!({ "error": format!("{err:#}") }))
}

fn render_index_html(runtime: &QrWebRuntime) -> String {
    let preferred_origin = runtime
        .public_origin
        .as_deref()
        .or(runtime.lan_origin.as_deref());
    let lan_origin = preferred_origin.unwrap_or("请使用当前机器的局域网 IP");
    let target_host = runtime
        .authorize_opts
        .get("--host")
        .map(String::as_str)
        .unwrap_or("自动探测 api5/api-and");
    let state_dir = runtime.state_dir.display();
    format!(
        r#"<!doctype html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>rnidbg Boss QR Web</title>
  <style>
    :root {{
      color-scheme: light;
      --bg: #f4efe6;
      --card: #fffaf3;
      --ink: #1f241f;
      --accent: #13795b;
      --line: #d7ccb9;
      --muted: #645c52;
    }}
    body {{
      margin: 0;
      font-family: "PingFang SC", "Helvetica Neue", sans-serif;
      background:
        radial-gradient(circle at top left, rgba(19,121,91,0.12), transparent 32%),
        linear-gradient(180deg, #f8f3ea 0%, var(--bg) 100%);
      color: var(--ink);
    }}
    .shell {{
      max-width: 980px;
      margin: 0 auto;
      padding: 24px 18px 40px;
    }}
    .hero {{
      background: var(--card);
      border: 1px solid var(--line);
      border-radius: 24px;
      padding: 24px;
      box-shadow: 0 20px 40px rgba(31,36,31,0.08);
    }}
    h1 {{
      margin: 0 0 8px;
      font-size: 34px;
      line-height: 1.1;
    }}
    .hero p {{
      margin: 0;
      color: var(--muted);
    }}
    .grid {{
      display: grid;
      grid-template-columns: repeat(auto-fit, minmax(280px, 1fr));
      gap: 18px;
      margin-top: 18px;
    }}
    .card {{
      background: var(--card);
      border: 1px solid var(--line);
      border-radius: 20px;
      padding: 18px;
      box-shadow: 0 10px 22px rgba(31,36,31,0.05);
    }}
    label {{
      display: block;
      margin-top: 12px;
      font-size: 13px;
      color: var(--muted);
    }}
    input, textarea, select, button {{
      width: 100%;
      box-sizing: border-box;
      margin-top: 6px;
      border-radius: 12px;
      border: 1px solid var(--line);
      padding: 12px 14px;
      background: #fff;
      font: inherit;
    }}
    textarea {{
      min-height: 88px;
      resize: vertical;
    }}
    button {{
      cursor: pointer;
      background: var(--accent);
      color: #fff;
      border: none;
      font-weight: 600;
    }}
    .ghost {{
      background: transparent;
      color: var(--accent);
      border: 1px solid var(--accent);
    }}
    .actions {{
      display: grid;
      grid-template-columns: 1fr 1fr;
      gap: 10px;
      margin-top: 18px;
    }}
    .camera-shell {{
      margin-top: 14px;
      border: 1px solid var(--line);
      border-radius: 18px;
      overflow: hidden;
      background: #efe7da;
    }}
    video {{
      display: block;
      width: 100%;
      min-height: 220px;
      background: #191c19;
      object-fit: cover;
    }}
    .hint {{
      margin-top: 10px;
      font-size: 12px;
      color: var(--muted);
      line-height: 1.5;
    }}
    pre {{
      margin: 0;
      white-space: pre-wrap;
      word-break: break-word;
      font-size: 12px;
      line-height: 1.45;
      background: #f7f3eb;
      border: 1px solid var(--line);
      border-radius: 14px;
      padding: 14px;
      min-height: 180px;
    }}
    .meta {{
      margin-top: 14px;
      padding: 12px 14px;
      border-radius: 14px;
      background: rgba(19,121,91,0.08);
      font-size: 13px;
      color: var(--muted);
    }}
  </style>
</head>
<body>
  <div class="shell">
    <section class="hero">
      <h1>Boss QR LAN 授权入口</h1>
      <p>这个页面只做局域网采图和触发，二维码识别与授权仍走 rnidbg 现有的 dex/so 对齐链。</p>
      <div class="meta">
        局域网访问建议: {lan_origin}<br>
        远端授权 Host: {target_host}<br>
        持久化目录: {state_dir}
      </div>
    </section>
    <div class="grid">
      <section class="card">
        <h2>扫码输入</h2>
        <div class="camera-shell">
          <video id="cameraPreview" playsinline muted></video>
        </div>
        <canvas id="cameraCanvas" hidden></canvas>
        <div class="actions">
          <button id="startCameraBtn" class="ghost">启动摄像头</button>
          <button id="stopCameraBtn" class="ghost">停止摄像头</button>
        </div>
        <div class="actions">
          <button id="cameraDecodeBtn" class="ghost">识别当前画面</button>
          <button id="cameraAuthorizeBtn">授权当前画面</button>
        </div>
        <div class="hint">
          优先尝试实时摄像头取流。如果浏览器因为局域网 HTTP 不允许摄像头权限，下面的“图片”输入仍可直接调用手机相机拍照，不需要先保存到相册。
        </div>
        <label>首扫二维码图片 / 拍照回退
          <input id="firstImage" type="file" accept="image/*" capture="environment">
        </label>
        <label>首扫二维码文本（可选，优先于图片）
          <textarea id="firstText" placeholder="可直接粘贴 bosszp-... 或带 qrcode= 的 URL"></textarea>
        </label>
        <label>二扫二维码图片 / 拍照回退（可选）
          <input id="secondImage" type="file" accept="image/*" capture="environment">
        </label>
        <label>二扫二维码文本（可选）
          <textarea id="secondText" placeholder="如果需要 secondQrId，可直接贴这里"></textarea>
        </label>
        <label>loginType
          <select id="loginType">
            <option value="1" selected>1 授权登录</option>
            <option value="2">2 取消授权</option>
          </select>
        </label>
        <div class="actions">
          <button id="decodeBtn" class="ghost">只识别二维码</button>
          <button id="authorizeBtn">识别并授权</button>
        </div>
        <div class="actions">
          <button id="stateBtn" class="ghost">查看最近持久化结果</button>
          <button id="healthBtn" class="ghost">查看服务状态</button>
        </div>
      </section>
      <section class="card">
        <h2>链路结果</h2>
        <pre id="output">等待操作…</pre>
      </section>
    </div>
  </div>
  <script>
    let currentCameraStream = null;
    const cameraPreview = document.getElementById("cameraPreview");
    const cameraCanvas = document.getElementById("cameraCanvas");

    async function fileToDataUrl(input) {{
      const file = input.files && input.files[0];
      if (!file) return {{ name: "", dataUrl: "" }};
      return await new Promise((resolve, reject) => {{
        const reader = new FileReader();
        reader.onload = () => resolve({{ name: file.name, dataUrl: reader.result || "" }});
        reader.onerror = () => reject(new Error("读取图片失败"));
        reader.readAsDataURL(file);
      }});
    }}

    async function ensureCameraStarted() {{
      if (currentCameraStream) {{
        return currentCameraStream;
      }}
      if (!navigator.mediaDevices || !navigator.mediaDevices.getUserMedia) {{
        throw new Error("当前浏览器不支持实时摄像头，请改用下方拍照输入。");
      }}
      currentCameraStream = await navigator.mediaDevices.getUserMedia({{
        audio: false,
        video: {{
          facingMode: {{ ideal: "environment" }},
          width: {{ ideal: 1280 }},
          height: {{ ideal: 720 }}
        }}
      }});
      cameraPreview.srcObject = currentCameraStream;
      await cameraPreview.play();
      return currentCameraStream;
    }}

    function stopCamera() {{
      if (currentCameraStream) {{
        for (const track of currentCameraStream.getTracks()) {{
          track.stop();
        }}
      }}
      currentCameraStream = null;
      cameraPreview.srcObject = null;
    }}

    function captureCameraFrame() {{
      if (!currentCameraStream || !cameraPreview.videoWidth || !cameraPreview.videoHeight) {{
        throw new Error("摄像头还没准备好，请先启动摄像头。");
      }}
      cameraCanvas.width = cameraPreview.videoWidth;
      cameraCanvas.height = cameraPreview.videoHeight;
      const ctx = cameraCanvas.getContext("2d");
      ctx.drawImage(cameraPreview, 0, 0, cameraCanvas.width, cameraCanvas.height);
      return {{
        name: `camera-${{Date.now()}}.jpg`,
        dataUrl: cameraCanvas.toDataURL("image/jpeg", 0.92),
      }};
    }}

    async function collectPayload(options = {{}}) {{
      const useCameraForFirst = Boolean(options.useCameraForFirst);
      const useCameraForSecond = Boolean(options.useCameraForSecond);
      const firstImage = await fileToDataUrl(document.getElementById("firstImage"));
      const secondImage = await fileToDataUrl(document.getElementById("secondImage"));
      const firstText = document.getElementById("firstText").value.trim();
      const secondText = document.getElementById("secondText").value.trim();
      let firstPayload = firstImage;
      let secondPayload = secondImage;
      if (useCameraForFirst && !firstPayload.dataUrl && !firstText) {{
        firstPayload = captureCameraFrame();
      }}
      if (useCameraForSecond && !secondPayload.dataUrl && !secondText) {{
        secondPayload = captureCameraFrame();
      }}
      return {{
        first_image_b64: firstPayload.dataUrl,
        first_image_name: firstPayload.name,
        first_qr_text: firstText,
        second_image_b64: secondPayload.dataUrl,
        second_image_name: secondPayload.name,
        second_qr_text: secondText,
        login_type: Number(document.getElementById("loginType").value || "1"),
      }};
    }}

    async function postJson(url, body) {{
      const response = await fetch(url, {{
        method: "POST",
        headers: {{ "Content-Type": "application/json" }},
        body: JSON.stringify(body),
      }});
      return await response.json();
    }}

    function render(value) {{
      document.getElementById("output").textContent = JSON.stringify(value, null, 2);
    }}

    document.getElementById("startCameraBtn").addEventListener("click", async () => {{
      try {{
        await ensureCameraStarted();
        render({{ status: "camera_ready", mode: "live_preview" }});
      }} catch (err) {{
        render({{
          error: String(err),
          hint: "如果浏览器不允许局域网 HTTP 直接开摄像头，请继续用下面的拍照输入，它会直接调起手机相机。"
        }});
      }}
    }});

    document.getElementById("stopCameraBtn").addEventListener("click", async () => {{
      stopCamera();
      render({{ status: "camera_stopped" }});
    }});

    document.getElementById("decodeBtn").addEventListener("click", async () => {{
      try {{
        const payload = await collectPayload();
        const result = await postJson("/api/decode", {{
          image_b64: payload.first_image_b64,
          image_name: payload.first_image_name,
          qr_text: payload.first_qr_text,
        }});
        render(result);
      }} catch (err) {{
        render({{ error: String(err) }});
      }}
    }});

    document.getElementById("cameraDecodeBtn").addEventListener("click", async () => {{
      try {{
        await ensureCameraStarted();
        const payload = await collectPayload({{ useCameraForFirst: true }});
        const result = await postJson("/api/decode", {{
          image_b64: payload.first_image_b64,
          image_name: payload.first_image_name,
          qr_text: payload.first_qr_text,
        }});
        render(result);
      }} catch (err) {{
        render({{ error: String(err) }});
      }}
    }});

    document.getElementById("authorizeBtn").addEventListener("click", async () => {{
      try {{
        const payload = await collectPayload();
        const result = await postJson("/api/authorize", payload);
        render(result);
      }} catch (err) {{
        render({{ error: String(err) }});
      }}
    }});

    document.getElementById("cameraAuthorizeBtn").addEventListener("click", async () => {{
      try {{
        await ensureCameraStarted();
        const payload = await collectPayload({{ useCameraForFirst: true }});
        const result = await postJson("/api/authorize", payload);
        render(result);
      }} catch (err) {{
        render({{ error: String(err) }});
      }}
    }});

    document.getElementById("stateBtn").addEventListener("click", async () => {{
      try {{
        render(await (await fetch("/api/state/latest")).json());
      }} catch (err) {{
        render({{ error: String(err) }});
      }}
    }});

    document.getElementById("healthBtn").addEventListener("click", async () => {{
      try {{
        render(await (await fetch("/health")).json());
      }} catch (err) {{
        render({{ error: String(err) }});
      }}
    }});

    window.addEventListener("beforeunload", () => {{
      stopCamera();
    }});
  </script>
</body>
</html>"#
    )
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn resolve_hosts_keeps_bind_and_api_separate() {
        let opts = HashMap::from([
            ("--bind-host".to_string(), "0.0.0.0".to_string()),
            (
                "--api-host".to_string(),
                "https://api5.zhipin.com".to_string(),
            ),
        ]);
        assert_eq!(resolve_bind_host(&opts), "0.0.0.0");
        assert_eq!(
            resolve_api_host(&opts).as_deref(),
            Some("https://api5.zhipin.com")
        );
    }

    #[test]
    fn decode_image_b64_accepts_data_url() {
        let payload = decode_image_b64("data:image/jpeg;base64,aGVsbG8=").unwrap();
        assert_eq!(payload, b"hello");
    }

    #[test]
    fn sanitize_file_name_rejects_unsafe_chars() {
        assert_eq!(sanitize_file_name("../a b?.jpg"), "a_b_.jpg");
    }
}
