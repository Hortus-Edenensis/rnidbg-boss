//! Real captcha construction for the Boss GT3 machine-verify flow.
//!
//! DEX evidence (jadx, `gt3-geetest-static-analysis.md`):
//!   - `ir.a.f120141v3` → `m.a("zpsecureflow/captcha/gettype")`
//!   - `ir.a.f120143w3` → `m.a("zpsecureflow/captcha/validate")`
//!   - `GetCaptchaTypeResponse`: captchaType / captchaName / randKey / startCaptcha / wyCaptchaId / wyCaptchaType
//!   - `MachineVerifyActivity.Re(String)` sets `MachineVerifyConfirmRequest.captcha_info = str` then executes
//!   - `p50.d$a.onDialogResult`: builds captcha_info = {"type":N,"challenge":"...","validate":"...","secCode":"..."}
//!
//! SO evidence (`libyzwg.so` stripped, `com.twl.signer.YZWG`):
//!   - `nativeEncodeRequest`  → builds `sp`
//!   - `nativeSignature`      → builds `sig`
//!   - `nativeEncodeRequestBody` / `nativeDecodeContent` for body codec
//!   - `net.bosszhipin.base.m` calls `a.d(canonical, secretKey)` → sp,
//!     `a.i(path + canonical_tail, secretKey)` → sig; captcha endpoints reuse the same signer chain.

use std::collections::{BTreeMap, HashMap};
use std::fs;
use std::path::{Path, PathBuf};

use anyhow::{Context, Result};
use reqwest::Url;
use serde::{Deserialize, Serialize};
use serde_json::{json, Value};

use super::job_detail::{
    build_common_params, build_traceid, canonicalize_params, execute_get, execute_post,
    normalize_host, now_ms, parse_bool_flag, redact_headers, resolved_session_path, response_code,
    truncate_for_sig, BossSigner, HttpTransport, RnIdbgSoInvoker, TransportRuntime,
};
use super::qr_login::{build_stage_inbound_headers, load_session, DeviceConfig, SessionConfig};
use super::yzwg::LabConfig;

// ── constants ──────────────────────────────────────────────────────────────────

/// Default host used for the machine-verify / secure-flow endpoints.
/// Evidence: `qr_authorize.rs` and login-related calls all target `api5.zhipin.com`.
const DEFAULT_HOST: &str = "https://api5.zhipin.com";
const DEFAULT_HOST_BARE: &str = "api5.zhipin.com";

/// DEX: `ir.a.f120141v3 = m.a("zpsecureflow/captcha/gettype")`
const CAPTCHA_GETTYPE_PATH: &str = "/zpsecureflow/captcha/gettype";

/// DEX: `ir.a.f120143w3 = m.a("zpsecureflow/captcha/validate")`
const CAPTCHA_VALIDATE_PATH: &str = "/zpsecureflow/captcha/validate";

const APP_ID: &str = "1003";
const USER_AGENT: &str = concat!(
    "Mozilla/5.0 (Linux; Android 14; RMX3560 Build/UP1A.231005.007; wv) ",
    "AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/118.0.0.0 ",
    "Mobile Safari/537.36 BossZhipin/14.010"
);

/// SP/sig canonical-string truncation threshold (matches other endpoints).
const SP_TRUNCATE_THRESHOLD: usize = 5000;

// ── types ──────────────────────────────────────────────────────────────────────

/// The three fields the GT3 SDK returns in `onDialogResult`.
///
/// DEX:
/// ```
/// jSONObject2.put("challenge", jSONObject.optString("geetest_challenge"));
/// jSONObject2.put("validate",  jSONObject.optString("geetest_validate"));
/// jSONObject2.put("secCode",   jSONObject.optString("geetest_seccode"));
/// ```
#[derive(Debug, Clone, Serialize, Deserialize)]
struct DialogResult {
    geetest_challenge: String,
    geetest_validate: String,
    geetest_seccode: String,
}

struct SignedGetRequest {
    url: String,
    traceid: String,
    headers: HashMap<String, String>,
}

struct SignedPostRequest {
    url: String,
    traceid: String,
    headers: HashMap<String, String>,
    body: String,
}

// ── public entry-point ─────────────────────────────────────────────────────────

pub fn run_captcha_mock(opts: &HashMap<String, String>) -> Result<Value> {
    // ── setup ────────────────────────────────────────────────────────────────
    let session_path = opts.get("--session-path").map(String::as_str);
    let resolved_session = resolved_session_path(session_path);
    let config_path = PathBuf::from(
        opts.get("--config")
            .cloned()
            .unwrap_or_else(super::default_config_path),
    );
    let lab_config = LabConfig::load(&config_path)?
        .with_backend_override(opts.get("--backend").map(String::as_str))?;

    let session = load_session(session_path)?;
    let device = DeviceConfig::from_session(&session);

    // Initialise the libyzwg.so signer (nativeEncodeRequest / nativeSignature).
    let signer = RnIdbgSoInvoker::new(config_path.clone(), &lab_config, opts)?;

    let transport_runtime =
        TransportRuntime::parse(opts.get("--transport-runtime").map(String::as_str))?;
    let http1_only = parse_bool_flag(opts, "--http1-only");
    let transport = HttpTransport::discover(transport_runtime, &lab_config, opts, http1_only)?;

    let host = normalize_host(
        opts.get("--host")
            .map(String::as_str)
            .unwrap_or(DEFAULT_HOST),
    );

    // ── step 1: GET /zpsecureflow/captcha/gettype ─────────────────────────────
    //
    // DEX: `c4.f(LActivity)` calls `SimpleApiRequest.GET(ir.a.f120141v3).setRequestCallback(...).execute()`
    // The request uses the standard YZWG signing chain (sp + sig via libyzwg.so).
    let gettype_req = build_signed_get(
        &host,
        CAPTCHA_GETTYPE_PATH,
        BTreeMap::new(),
        &session,
        &device,
        &*signer,
    )?;

    let gettype_response = execute_get(
        &transport,
        &gettype_req.url,
        &gettype_req.headers,
        Some(&*signer),
        session.secret_key.as_str(),
    )?;

    // Parse GetCaptchaTypeResponse fields – may be wrapped in `zpData` or top-level.
    //
    // DEX `GetCaptchaTypeResponse`:
    //   public String captchaName;
    //   public int    captchaType;
    //   public String randKey;
    //   public String startCaptcha;
    //   public String wyCaptchaId;
    //   public String wyCaptchaType;
    let gettype_data = gettype_response.get("zpData").unwrap_or(&gettype_response);

    let captcha_type = gettype_data
        .get("captchaType")
        .and_then(Value::as_i64)
        .map(|v| v as i32)
        .unwrap_or(1);

    let captcha_name = gettype_data
        .get("captchaName")
        .and_then(Value::as_str)
        .unwrap_or("geetest")
        .to_string();

    let rand_key = gettype_data
        .get("randKey")
        .and_then(Value::as_str)
        .unwrap_or("")
        .to_string();

    let start_captcha_raw = gettype_data
        .get("startCaptcha")
        .and_then(Value::as_str)
        .unwrap_or("{}")
        .to_string();

    let wy_captcha_id = gettype_data
        .get("wyCaptchaId")
        .cloned()
        .unwrap_or(Value::Null);
    let wy_captcha_type = gettype_data
        .get("wyCaptchaType")
        .cloned()
        .unwrap_or(Value::Null);

    let gettype_ok = response_code(Some(&gettype_response)) == Some(0);

    // ── step 2: user-provided GT3 SDK dialog result ───────────────────────────
    //
    // The GT3 challenge/solve step is handled by the device-side GT3 SDK
    // (`p50.d`, `GT3GeetestUtils.startCustomFlow()`).  The caller must supply
    // the three proof fields that `onDialogResult` would normally deliver.
    //
    // DEX `p50.d$a.onDialogResult(String)`:
    //   jSONObject2.put("challenge", jSONObject.optString("geetest_challenge"));
    //   jSONObject2.put("validate",  jSONObject.optString("geetest_validate"));
    //   jSONObject2.put("secCode",   jSONObject.optString("geetest_seccode"));
    let dialog_result_raw = load_inline_or_file(
        opts,
        "--dialog-result-json",
        "--dialog-result-file",
        default_dialog_result_json(),
    )?;
    let dialog_result: DialogResult =
        serde_json::from_str(&dialog_result_raw).context("failed to parse dialog result json")?;

    // ── step 3: build captcha_info ────────────────────────────────────────────
    //
    // DEX: assembled inside `p50.d$a.onDialogResult` then passed to
    // `MachineVerifyActivity.Re(String)` as a JSON string.
    let captcha_info = json!({
        "type":     captcha_type,
        "challenge": dialog_result.geetest_challenge,
        "validate":  dialog_result.geetest_validate,
        "secCode":   dialog_result.geetest_seccode,
    });
    let captcha_info_raw = serde_json::to_string(&captcha_info)?;

    // ── step 4: POST /zpsecureflow/captcha/validate ───────────────────────────
    //
    // DEX `MachineVerifyActivity.Re(String)`:
    //   MachineVerifyConfirmRequest req = new MachineVerifyConfirmRequest(new c());
    //   req.captcha_info = str;
    //   req.execute();
    //
    // `MachineVerifyConfirmRequest.getUrl()` returns `ir.a.f120143w3`
    // which resolves to "zpsecureflow/captcha/validate".
    //
    // `captcha_info` is the only business-specific signed form param;
    // common params (client_info, curidentity, req_time, uniqid, v) are
    // injected by the base request class and included in the sp/sig canonical.
    let validate_form_params =
        BTreeMap::from([("captcha_info".to_string(), captcha_info_raw.clone())]);

    let validate_req = build_signed_post(
        &host,
        CAPTCHA_VALIDATE_PATH,
        validate_form_params,
        &session,
        &device,
        &*signer,
    )?;

    let validate_response = execute_post(
        &transport,
        &validate_req.url,
        &validate_req.headers,
        validate_req.body.as_bytes(),
        Some(&*signer),
        session.secret_key.as_str(),
    )?;

    let validate_ok = response_code(Some(&validate_response)) == Some(0);
    let provider_name = provider_name(captcha_type);

    // Parse startCaptcha as JSON for the sdk_input field (best-effort).
    let sdk_input = serde_json::from_str::<Value>(&start_captcha_raw)
        .unwrap_or(Value::String(start_captcha_raw.clone()));

    let output = json!({
        "status": if gettype_ok && validate_ok { "ok" } else { "partial" },
        "mode": "real",
        "session_path": resolved_session,
        "host": host,
        "transport_runtime": transport.label(),
        "original_okhttp_available": transport.original_okhttp_available(),
        "transport": transport.describe(),
        "native_invoker": signer.describe(),

        // provider info derived from gettype response
        "provider": provider_name,
        "captcha_type": captcha_type,
        "captcha_name": captcha_name,
        "rand_key": rand_key,
        "wy_captcha_id": wy_captcha_id,
        "wy_captcha_type": wy_captcha_type,

        // step 1 – gettype
        "gettype_request": {
            "url":     gettype_req.url,
            "traceid": gettype_req.traceid,
            "headers": redact_headers(&gettype_req.headers),
        },
        "gettype_response": gettype_response,

        // step 2 – GT3 sdk input (startCaptcha fed as api1Json)
        "sdk_input": sdk_input,

        // step 3 – dialog result (from GT3 onDialogResult)
        "dialog_result": {
            "geetest_challenge": dialog_result.geetest_challenge,
            "geetest_validate":  dialog_result.geetest_validate,
            "geetest_seccode":   dialog_result.geetest_seccode,
        },

        // step 4 – validate
        "captcha_info":     captcha_info,
        "captcha_info_raw": captcha_info_raw,
        "validate_request": {
            "url":      validate_req.url,
            "traceid":  validate_req.traceid,
            "headers":  redact_headers(&validate_req.headers),
            "body_form": validate_req.body,
        },
        "validate_response": validate_response,

        // hook targets kept for reference
        "hook_targets": [
            "com.hpbr.bosszhipin.utils.c4.e(GetCaptchaTypeResponse)",
            "p50.d$a.onButtonClick()",
            "p50.d$a.onDialogResult(String)",
            "com.hpbr.bosszhipin.login.activity.MachineVerifyActivity.Re(String)",
        ],
    });

    if let Some(path) = opts.get("--out") {
        write_json(Path::new(path), &output)?;
    }

    Ok(output)
}

// ── signing helpers ────────────────────────────────────────────────────────────

/// Build a signed GET request for a captcha endpoint.
///
/// Signing pattern (matches `net.bosszhipin.base.m` DEX evidence):
///   canonical = join(sort(common_params + extra_params), "&")
///   sp  = nativeEncodeRequest(canonical, secret_key)
///   sig = nativeSignature(path + truncate(canonical, 5000), secret_key)
///   zp-tag = nativeEncodeRequest(traceid, "")
fn build_signed_get(
    host: &str,
    path: &str,
    mut extra_params: BTreeMap<String, String>,
    session: &SessionConfig,
    device: &DeviceConfig,
    signer: &dyn BossSigner,
) -> Result<SignedGetRequest> {
    let traceid = build_traceid();
    let req_time_ms = now_ms();

    let common_params = build_common_params(device, req_time_ms);
    let mut signing_params = common_params;
    signing_params.append(&mut extra_params);

    let canonical = canonicalize_params(&signing_params);
    let secret_key = session.secret_key.as_str();

    let sp = signer
        .encode_request(canonical.as_bytes(), secret_key)
        .with_context(|| format!("libyzwg.so: failed to build sp for {path}"))?;

    let sig_input = format!(
        "{}{}",
        path,
        truncate_for_sig(&canonical, SP_TRUNCATE_THRESHOLD)
    );
    let sig = signer
        .signature(sig_input.as_bytes(), secret_key)
        .with_context(|| format!("libyzwg.so: failed to build sig for {path}"))?;

    let zp_tag = signer
        .encode_request(traceid.as_bytes(), "")
        .with_context(|| format!("libyzwg.so: failed to build zp-tag for {path}"))?;

    let mut final_query = signing_params;
    final_query.insert("sp".to_string(), sp);
    final_query.insert("sig".to_string(), sig);

    // app_id is unsigned (not included in sp/sig canonical), appended to URL only.
    let unsigned_params = BTreeMap::from([("app_id".to_string(), APP_ID.to_string())]);

    let url = build_url(host, path, &final_query, &unsigned_params)?;

    let mut extra_headers = HashMap::new();
    extra_headers.insert("traceid".to_string(), traceid.clone());
    extra_headers.insert("zp-tag".to_string(), zp_tag);

    let mut headers = build_stage_inbound_headers(
        USER_AGENT,
        &host_header(host)?,
        device,
        Some(session),
        Some(extra_headers),
    );
    headers.insert("Content-Type".to_string(), "application/json".to_string());

    Ok(SignedGetRequest {
        url,
        traceid,
        headers,
    })
}

/// Build a signed POST request for a captcha endpoint.
///
/// Signing pattern matches the standard form-post path in `net.bosszhipin.base.m`.
/// Business-specific params (e.g. `captcha_info`) are signed alongside common params.
fn build_signed_post(
    host: &str,
    path: &str,
    mut form_params: BTreeMap<String, String>,
    session: &SessionConfig,
    device: &DeviceConfig,
    signer: &dyn BossSigner,
) -> Result<SignedPostRequest> {
    let traceid = build_traceid();
    let req_time_ms = now_ms();

    let common_params = build_common_params(device, req_time_ms);
    let mut signing_params = common_params;
    signing_params.append(&mut form_params);

    let canonical = canonicalize_params(&signing_params);
    let secret_key = session.secret_key.as_str();

    let sp = signer
        .encode_request(canonical.as_bytes(), secret_key)
        .with_context(|| format!("libyzwg.so: failed to build sp for {path}"))?;

    let sig_input = format!(
        "{}{}",
        path,
        truncate_for_sig(&canonical, SP_TRUNCATE_THRESHOLD)
    );
    let sig = signer
        .signature(sig_input.as_bytes(), secret_key)
        .with_context(|| format!("libyzwg.so: failed to build sig for {path}"))?;

    let zp_tag = signer
        .encode_request(traceid.as_bytes(), "")
        .with_context(|| format!("libyzwg.so: failed to build zp-tag for {path}"))?;

    let mut final_form = signing_params;
    final_form.insert("sp".to_string(), sp);
    final_form.insert("sig".to_string(), sig);
    // app_id is unsigned – append to form body after signing.
    final_form.insert("app_id".to_string(), APP_ID.to_string());

    let url = format!(
        "{}/{}",
        host.trim_end_matches('/'),
        path.trim_start_matches('/')
    );

    let mut extra_headers = HashMap::new();
    extra_headers.insert("traceid".to_string(), traceid.clone());
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
        "application/x-www-form-urlencoded".to_string(),
    );

    let body = encode_form_body(&final_form);

    Ok(SignedPostRequest {
        url,
        traceid,
        headers,
        body,
    })
}

// ── small utilities ────────────────────────────────────────────────────────────

fn build_url(
    host: &str,
    path: &str,
    params: &BTreeMap<String, String>,
    unsigned_params: &BTreeMap<String, String>,
) -> Result<String> {
    let base = format!(
        "{}/{}",
        host.trim_end_matches('/'),
        path.trim_start_matches('/')
    );
    let mut url = Url::parse(&base).with_context(|| format!("invalid captcha host url: {host}"))?;
    {
        let mut pairs = url.query_pairs_mut();
        for (key, value) in params {
            pairs.append_pair(key, value);
        }
        for (key, value) in unsigned_params {
            pairs.append_pair(key, value);
        }
    }
    Ok(url.to_string())
}

fn host_header(host: &str) -> Result<String> {
    let parsed = Url::parse(host).with_context(|| format!("invalid captcha host url: {host}"))?;
    Ok(match parsed.port() {
        Some(port) => format!(
            "{}:{}",
            parsed.host_str().unwrap_or(DEFAULT_HOST_BARE),
            port
        ),
        None => parsed.host_str().unwrap_or(DEFAULT_HOST_BARE).to_string(),
    })
}

/// URL-encode form values for `application/x-www-form-urlencoded` body.
/// Follows the same charset as `contact.rs::query_component`.
fn encode_form_body(params: &BTreeMap<String, String>) -> String {
    params
        .iter()
        .map(|(key, value)| format!("{key}={}", form_encode_value(value)))
        .collect::<Vec<_>>()
        .join("&")
}

fn form_encode_value(value: &str) -> String {
    let mut out = String::with_capacity(value.len());
    for byte in value.as_bytes() {
        match byte {
            b'0'..=b'9' | b'a'..=b'z' | b'A'..=b'Z' | b'-' | b'_' | b'.' | b'~' => {
                out.push(*byte as char)
            }
            b' ' => out.push('+'),
            _ => out.push_str(&format!("%{byte:02X}")),
        }
    }
    out
}

/// DEX `p50.b.a(int)` – captchaType to provider class mapping.
fn provider_name(captcha_type: i32) -> &'static str {
    match captcha_type {
        1 => "p50.d (GT3 provider)",
        4 => "p50.h (Netease provider)",
        _ => "unknown provider",
    }
}

fn load_inline_or_file(
    opts: &HashMap<String, String>,
    inline_key: &str,
    file_key: &str,
    default_value: String,
) -> Result<String> {
    if let Some(value) = opts.get(inline_key) {
        return Ok(value.clone());
    }
    if let Some(path) = opts.get(file_key) {
        return fs::read_to_string(path).with_context(|| format!("failed to read {}", path));
    }
    Ok(default_value)
}

/// Placeholder dialog result used when no `--dialog-result-*` flag is supplied.
/// Replace with real GT3 SDK output obtained from a live device / hook session.
fn default_dialog_result_json() -> String {
    serde_json::json!({
        "geetest_challenge": "9196fd975b68171924c9e9c4bdda70cb8z",
        "geetest_validate":  "placeholder-validate-token",
        "geetest_seccode":   "placeholder-seccode|jordan",
    })
    .to_string()
}

fn write_json(path: &Path, value: &Value) -> Result<()> {
    if let Some(parent) = path.parent() {
        fs::create_dir_all(parent)
            .with_context(|| format!("failed to create parent dir for {}", path.display()))?;
    }
    let serialized = serde_json::to_string_pretty(value)?;
    fs::write(path, serialized).with_context(|| format!("failed to write {}", path.display()))
}

// ── tests ──────────────────────────────────────────────────────────────────────

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn form_encode_value_percent_encodes_special_chars() {
        // Braces and quotes in captcha_info JSON must be percent-encoded.
        let raw = r#"{"type":1,"challenge":"abc"}"#;
        let encoded = form_encode_value(raw);
        assert!(encoded.contains("%7B"), "open brace should be encoded");
        assert!(encoded.contains("%7D"), "close brace should be encoded");
        assert!(encoded.contains("%22"), "quote should be encoded");
        assert!(!encoded.contains('{'));
        assert!(!encoded.contains('"'));
    }

    #[test]
    fn form_encode_value_keeps_safe_chars_and_encodes_space() {
        assert_eq!(form_encode_value("hello world"), "hello+world");
        assert_eq!(form_encode_value("abc123-_.~"), "abc123-_.~");
    }

    #[test]
    fn encode_form_body_is_ampersand_delimited() {
        let mut params = BTreeMap::new();
        params.insert("captcha_info".to_string(), "x".to_string());
        params.insert("sp".to_string(), "y".to_string());
        let body = encode_form_body(&params);
        // BTreeMap is sorted so captcha_info < sp
        assert_eq!(body, "captcha_info=x&sp=y");
    }

    #[test]
    fn provider_name_maps_known_types() {
        assert!(provider_name(1).contains("GT3"));
        assert!(provider_name(4).contains("Netease"));
        assert_eq!(provider_name(99), "unknown provider");
    }

    #[test]
    fn host_header_strips_scheme_and_path() {
        let h = host_header("https://api5.zhipin.com").unwrap();
        assert_eq!(h, "api5.zhipin.com");
    }

    #[test]
    fn host_header_preserves_non_standard_port() {
        let h = host_header("https://api5.zhipin.com:8443").unwrap();
        assert_eq!(h, "api5.zhipin.com:8443");
    }

    #[test]
    fn default_dialog_result_is_valid_json() {
        let raw = default_dialog_result_json();
        let v: Value =
            serde_json::from_str(&raw).expect("default dialog result must be valid JSON");
        assert!(v.get("geetest_challenge").is_some());
        assert!(v.get("geetest_validate").is_some());
        assert!(v.get("geetest_seccode").is_some());
    }
}
