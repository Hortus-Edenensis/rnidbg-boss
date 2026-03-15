use std::collections::{BTreeMap, HashMap};
use std::path::PathBuf;
use std::thread;
use std::time::Duration;

use anyhow::{anyhow, Context, Result};
use serde_json::{json, Value};

use super::job_detail::{
    build_common_params, build_traceid, canonicalize_params, execute_post, normalize_host, now_ms,
    parse_bool_flag, redact_headers, resolve_output_path, resolved_session_path, response_code,
    truncate_for_sig, BossSigner, HttpTransport, RnIdbgSoInvoker, TransportRuntime,
};
use super::qr_codec::{decode_login_qr_image, DecodedQrImage};
use super::qr_login::{build_stage_inbound_headers, load_session, DeviceConfig, SessionConfig};
use super::yzwg::LabConfig;

const REAL_USER_AGENT: &str = concat!(
    "Mozilla/5.0 (Linux; Android 14; RMX3560 Build/UP1A.231005.007; wv) ",
    "AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/118.0.0.0 ",
    "Mobile Safari/537.36 BossZhipin/14.010"
);
const DEFAULT_REAL_EDIT_TYPE: &str = "4";
const DEFAULT_REAL_ACTION_ID: &str = "";
const DEFAULT_REAL_EXTRA_INFO: &str = "";
const DEFAULT_LOGIN_TYPE: i32 = 1;
const DEFAULT_SLEEP_BEFORE_LOGIN_MS: u64 = 2100;
const APP_ID: &str = "1003";
const SP_TRUNCATE_THRESHOLD: usize = 5000;
const PASSPORT_WEB_SCAN_EDIT_PATH: &str = "/api/zppassport/qrcode/webScanEdit";
const PASSPORT_WEB_SECOND_SCAN_PATH: &str = "/api/zppassport/qrcode/webSecondScan";
const PASSPORT_QRCODE_LOGIN_PATH: &str = "/api/zppassport/qrcode/login";

pub fn run_qr_authorize(opts: &HashMap<String, String>) -> Result<Value> {
    let image_path = opts
        .get("--image")
        .cloned()
        .or_else(|| opts.get("_0").cloned())
        .ok_or_else(|| anyhow!("missing required qr image path, use qr-authorize <image-path>"))?;
    let decoded = decode_login_qr_image(PathBuf::from(&image_path).as_path())?;
    let second_decoded = resolve_second_qr_payload(opts)?;
    let login_type = opts
        .get("--login-type")
        .and_then(|value| value.parse::<i32>().ok())
        .unwrap_or(DEFAULT_LOGIN_TYPE);
    let sleep_before_login_ms = opts
        .get("--sleep-before-login-ms")
        .and_then(|value| value.parse::<u64>().ok())
        .unwrap_or(DEFAULT_SLEEP_BEFORE_LOGIN_MS);
    let edit_type = opts
        .get("--edit-type")
        .cloned()
        .unwrap_or_else(|| DEFAULT_REAL_EDIT_TYPE.to_string());
    let action_id = opts
        .get("--action-id")
        .cloned()
        .unwrap_or_else(|| DEFAULT_REAL_ACTION_ID.to_string());
    let extra_info = opts
        .get("--extra-info")
        .cloned()
        .unwrap_or_else(|| DEFAULT_REAL_EXTRA_INFO.to_string());
    let location = LocationHint::from_opts(opts)?;

    let session_path = opts.get("--session-path").map(String::as_str);
    let resolved_session_path = resolved_session_path(session_path);
    let output_path = resolve_output_path(
        opts.get("--out").map(String::as_str),
        "qr_authorize_result.json",
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
    let signer = RnIdbgSoInvoker::new(config_path, &lab_config, opts)?;
    let transport_runtime = TransportRuntime::parse(
        opts.get("--transport-runtime")
            .map(String::as_str)
            .or(Some("okhttp-bridge")),
    )?;
    let http1_only = parse_bool_flag(opts, "--http1-only");
    let transport = HttpTransport::discover(transport_runtime, &lab_config, opts, http1_only)?;
    let hosts = host_candidates(opts.get("--host").map(String::as_str));
    let secret_candidates = secret_key_candidates(&session);

    let mut attempts = Vec::new();
    let mut success: Option<Value> = None;

    'outer: for host in &hosts {
        for secret_key in &secret_candidates {
            let chain = execute_qr_chain(
                host,
                &decoded,
                second_decoded.as_ref(),
                &edit_type,
                &action_id,
                &extra_info,
                login_type,
                sleep_before_login_ms,
                &location,
                &device,
                &session,
                &*signer,
                &transport,
                secret_key,
            )?;
            let ok = chain
                .get("login")
                .and_then(|value| value.get("response"))
                .and_then(|value| response_code(Some(value)))
                == Some(0);
            attempts.push(chain.clone());
            if ok {
                success = Some(chain);
                break 'outer;
            }
        }
    }

    let output = json!({
        "ok": success.is_some(),
        "session_path": resolved_session_path,
        "transport_runtime": transport.label(),
        "original_okhttp_available": transport.original_okhttp_available(),
        "transport": transport.describe(),
        "native_invoker": signer.describe(),
        "decoded_first": serde_json::to_value(&decoded)?,
        "decoded_second": second_decoded
            .as_ref()
            .map(serde_json::to_value)
            .transpose()?
            .unwrap_or(Value::Null),
        "edit_type": edit_type,
        "action_id": action_id,
        "extra_info": extra_info,
        "login_type": login_type,
        "sleep_before_login_ms": sleep_before_login_ms,
        "location_hint": location.describe(),
        "attempts": attempts,
        "success": success,
    });

    if let Some(parent) = output_path.parent() {
        std::fs::create_dir_all(parent)
            .with_context(|| format!("failed to create output parent dir: {}", parent.display()))?;
    }
    std::fs::write(&output_path, serde_json::to_vec_pretty(&output)?).with_context(|| {
        format!(
            "failed to write qr-authorize result: {}",
            output_path.display()
        )
    })?;

    Ok(output)
}

fn execute_qr_chain(
    host: &str,
    first: &DecodedQrImage,
    second: Option<&DecodedQrImage>,
    edit_type: &str,
    action_id: &str,
    extra_info: &str,
    login_type: i32,
    sleep_before_login_ms: u64,
    location: &LocationHint,
    device: &DeviceConfig,
    session: &SessionConfig,
    signer: &dyn BossSigner,
    transport: &HttpTransport,
    secret_key: &str,
) -> Result<Value> {
    let first_scan = execute_passport_request(
        host,
        PassportStep::WebScanEdit {
            qr_id: first.recognized.qr_id.as_str(),
            edit_type,
            action_id,
            extra_info,
        },
        location,
        device,
        session,
        signer,
        transport,
        secret_key,
    )?;

    let second_scan = if let Some(second) = second {
        Some(execute_passport_request(
            host,
            PassportStep::WebSecondScan {
                qr_id: second.recognized.qr_id.as_str(),
            },
            location,
            device,
            session,
            signer,
            transport,
            secret_key,
        )?)
    } else {
        None
    };

    if second_scan.is_none() && sleep_before_login_ms > 0 {
        thread::sleep(Duration::from_millis(sleep_before_login_ms));
    }

    let login = execute_passport_request(
        host,
        PassportStep::Login {
            qr_id: first.recognized.qr_id.as_str(),
            second_qr_id: second
                .map(|value| value.recognized.qr_id.as_str())
                .unwrap_or(""),
            login_type,
        },
        location,
        device,
        session,
        signer,
        transport,
        secret_key,
    )?;

    Ok(json!({
        "host": host,
        "secret_key_mode": if secret_key.trim().is_empty() { "empty" } else { "secret" },
        "first_scan": first_scan,
        "second_scan": second_scan,
        "login": login,
    }))
}

fn execute_passport_request(
    host: &str,
    step: PassportStep<'_>,
    location: &LocationHint,
    device: &DeviceConfig,
    session: &SessionConfig,
    signer: &dyn BossSigner,
    transport: &HttpTransport,
    secret_key: &str,
) -> Result<Value> {
    let prepared =
        PreparedPassportRequest::sign(host, &step, location, device, session, signer, secret_key)?;
    let response = execute_post(
        transport,
        &prepared.url,
        &prepared.headers,
        &prepared.body_bytes,
        Some(signer),
        secret_key,
    )?;
    Ok(json!({
        "request": {
            "step": step.name(),
            "url": prepared.url,
            "traceid": prepared.traceid,
            "request_headers": redact_headers(&prepared.headers),
            "body": prepared.body_preview,
            "contract": prepared.contract,
        },
        "response": response,
    }))
}

struct PreparedPassportRequest {
    url: String,
    traceid: String,
    headers: HashMap<String, String>,
    body_bytes: Vec<u8>,
    body_preview: Value,
    contract: Value,
}

impl PreparedPassportRequest {
    fn sign(
        host: &str,
        step: &PassportStep<'_>,
        location: &LocationHint,
        device: &DeviceConfig,
        session: &SessionConfig,
        signer: &dyn BossSigner,
        secret_key: &str,
    ) -> Result<Self> {
        let traceid = build_traceid();
        let req_time_ms = now_ms();
        let mut params = build_common_params(device, req_time_ms);
        patch_client_info(&mut params, location, step.needs_location())?;
        for (key, value) in
            step.endpoint_params(login_step_location_params(location, step.needs_location()))
        {
            params.insert(key, value);
        }

        let canonical = canonicalize_params(&params);
        let sp = signer
            .encode_request(canonical.as_bytes(), secret_key)
            .with_context(|| format!("failed to encode passport params for {}", step.name()))?;
        let sig_input = format!(
            "{}{}",
            step.path(),
            truncate_for_sig(&canonical, SP_TRUNCATE_THRESHOLD)
        );
        let sig = signer
            .signature(sig_input.as_bytes(), secret_key)
            .with_context(|| format!("failed to sign passport params for {}", step.name()))?;
        let zp_tag = signer
            .encode_request(traceid.as_bytes(), "")
            .with_context(|| format!("failed to build zp-tag for {}", step.name()))?;

        let mut final_params = params.clone();
        final_params.insert("sp".to_string(), sp);
        final_params.insert("sig".to_string(), sig);
        final_params.insert("app_id".to_string(), APP_ID.to_string());
        let body_text = canonicalize_params(&final_params);
        let body_bytes = body_text.as_bytes().to_vec();

        let mut headers = build_stage_inbound_headers(
            REAL_USER_AGENT,
            &host_header(host)?,
            device,
            Some(session),
            Some(HashMap::from([
                ("traceId".to_string(), traceid.clone()),
                ("zp-tag".to_string(), zp_tag),
                ("zp-accept-encoding".to_string(), "1".to_string()),
                ("zp-accept-encrypting".to_string(), "1".to_string()),
                ("zp-accept-compressing".to_string(), "3".to_string()),
            ])),
        );
        headers.insert(
            "Content-Type".to_string(),
            "application/x-www-form-urlencoded; charset=UTF-8".to_string(),
        );
        headers.insert("Accept".to_string(), "*/*".to_string());

        Ok(Self {
            url: format!("{}{}", host.trim_end_matches('/'), step.path()),
            traceid,
            headers,
            body_bytes,
            body_preview: json!({
                "form_keys": final_params.keys().cloned().collect::<Vec<_>>(),
                "annotated_fields": step.annotated_fields(),
                "has_location_payload": step.needs_location() && location.has_location_permission,
                "second_qr_present": step.second_qr_present(),
            }),
            contract: json!({
                "type": "boss_passport_qr_authorize",
                "step": step.name(),
                "path": step.path(),
                "signing_secret_mode": if secret_key.trim().is_empty() { "empty" } else { "secret" },
                "signed_form_keys": params.keys().cloned().collect::<Vec<_>>(),
                "clear_exempt_keys": ["app_id"],
                "headers_from_dex": ["User-Agent", "traceId", "zp-tag", "t2", "zp-accept-encoding", "zp-accept-encrypting", "zp-accept-compressing"],
                "source_evidence": {
                    "base_api_request": "net.bosszhipin.base.BaseApiRequest",
                    "request_sign_pipeline": "net.bosszhipin.base.m.c/e",
                    "headers_pipeline": "net.bosszhipin.base.e.a",
                    "qr_request_class": step.request_class_name(),
                }
            }),
        })
    }
}

enum PassportStep<'a> {
    WebScanEdit {
        qr_id: &'a str,
        edit_type: &'a str,
        action_id: &'a str,
        extra_info: &'a str,
    },
    WebSecondScan {
        qr_id: &'a str,
    },
    Login {
        qr_id: &'a str,
        second_qr_id: &'a str,
        login_type: i32,
    },
}

impl PassportStep<'_> {
    fn name(&self) -> &'static str {
        match self {
            Self::WebScanEdit { .. } => "webScanEdit",
            Self::WebSecondScan { .. } => "webSecondScan",
            Self::Login { .. } => "login",
        }
    }

    fn path(&self) -> &'static str {
        match self {
            Self::WebScanEdit { .. } => PASSPORT_WEB_SCAN_EDIT_PATH,
            Self::WebSecondScan { .. } => PASSPORT_WEB_SECOND_SCAN_PATH,
            Self::Login { .. } => PASSPORT_QRCODE_LOGIN_PATH,
        }
    }

    fn request_class_name(&self) -> &'static str {
        match self {
            Self::WebScanEdit { .. } => "net.bosszhipin.api.QrCodeScanRequest",
            Self::WebSecondScan { .. } => "net.bosszhipin.api.QrCodeSecondScanRequest",
            Self::Login { .. } => "net.bosszhipin.api.QrCodeScanLoginRequest",
        }
    }

    fn needs_location(&self) -> bool {
        matches!(self, Self::Login { .. })
    }

    fn second_qr_present(&self) -> bool {
        match self {
            Self::Login { second_qr_id, .. } => !second_qr_id.trim().is_empty(),
            _ => false,
        }
    }

    fn annotated_fields(&self) -> Vec<&'static str> {
        match self {
            Self::WebScanEdit { .. } => vec!["qrId", "editType", "action_id", "extraInfo"],
            Self::WebSecondScan { .. } => vec!["qrId"],
            Self::Login { .. } => vec!["loginType", "qrId", "secondQrId"],
        }
    }

    fn endpoint_params(&self, location_params: Vec<(String, String)>) -> Vec<(String, String)> {
        let mut params = match self {
            Self::WebScanEdit {
                qr_id,
                edit_type,
                action_id,
                extra_info,
            } => vec![
                ("qrId".to_string(), (*qr_id).to_string()),
                ("editType".to_string(), (*edit_type).to_string()),
                ("action_id".to_string(), (*action_id).to_string()),
                ("extraInfo".to_string(), (*extra_info).to_string()),
            ],
            Self::WebSecondScan { qr_id } => {
                vec![("qrId".to_string(), (*qr_id).to_string())]
            }
            Self::Login {
                qr_id,
                second_qr_id,
                login_type,
            } => vec![
                ("loginType".to_string(), login_type.to_string()),
                ("qrId".to_string(), (*qr_id).to_string()),
                ("secondQrId".to_string(), (*second_qr_id).to_string()),
            ],
        };
        params.extend(location_params);
        params
    }
}

#[derive(Clone, Debug)]
struct LocationHint {
    has_location_permission: bool,
    latitude: Option<String>,
    longitude: Option<String>,
    ssid: Option<String>,
    bssid: Option<String>,
}

impl LocationHint {
    fn from_opts(opts: &HashMap<String, String>) -> Result<Self> {
        let has_location_permission = parse_bool_flag(opts, "--loc-per");
        let latitude = normalize_optional_number(opts.get("--latitude"))?;
        let longitude = normalize_optional_number(opts.get("--longitude"))?;
        Ok(Self {
            has_location_permission,
            latitude,
            longitude,
            ssid: normalize_optional_text(opts.get("--ssid")),
            bssid: normalize_optional_text(opts.get("--bssid")),
        })
    }

    fn describe(&self) -> Value {
        json!({
            "has_location_permission": self.has_location_permission,
            "latitude": self.latitude,
            "longitude": self.longitude,
            "ssid": self.ssid,
            "bssid": self.bssid,
        })
    }
}

fn patch_client_info(
    params: &mut BTreeMap<String, String>,
    location: &LocationHint,
    include_location_fields: bool,
) -> Result<()> {
    let raw = params
        .get("client_info")
        .cloned()
        .ok_or_else(|| anyhow!("missing client_info in common params"))?;
    let mut client_info: Value = serde_json::from_str(&raw).context("invalid client_info json")?;
    let object = client_info
        .as_object_mut()
        .ok_or_else(|| anyhow!("client_info is not an object"))?;
    object.insert(
        "loc_per".to_string(),
        Value::from(if location.has_location_permission {
            1
        } else {
            0
        }),
    );
    if include_location_fields && location.has_location_permission {
        if let Some(value) = &location.latitude {
            object.insert("latitude".to_string(), Value::String(value.clone()));
        }
        if let Some(value) = &location.longitude {
            object.insert("longitude".to_string(), Value::String(value.clone()));
        }
        if let Some(value) = &location.ssid {
            object.insert("ssid".to_string(), Value::String(value.clone()));
        }
        if let Some(value) = &location.bssid {
            object.insert("bssid".to_string(), Value::String(value.clone()));
        }
    }
    params.insert(
        "client_info".to_string(),
        serde_json::to_string(&client_info).context("failed to serialize client_info")?,
    );
    Ok(())
}

fn login_step_location_params(
    location: &LocationHint,
    include_location_fields: bool,
) -> Vec<(String, String)> {
    if !include_location_fields || !location.has_location_permission {
        return Vec::new();
    }
    let mut params = Vec::new();
    if let Some(value) = &location.latitude {
        params.push(("latitude".to_string(), value.clone()));
    }
    if let Some(value) = &location.longitude {
        params.push(("longitude".to_string(), value.clone()));
    }
    if let Some(value) = &location.ssid {
        params.push(("ssid".to_string(), value.clone()));
    }
    if let Some(value) = &location.bssid {
        params.push(("bssid".to_string(), value.clone()));
    }
    params
}

fn resolve_second_qr_payload(opts: &HashMap<String, String>) -> Result<Option<DecodedQrImage>> {
    if let Some(second_image) = opts.get("--second-image") {
        return decode_login_qr_image(PathBuf::from(second_image).as_path()).map(Some);
    }
    if let Some(second_qr_id) = opts
        .get("--second-qr")
        .map(|value| value.trim())
        .filter(|value| !value.is_empty())
    {
        return Ok(Some(DecodedQrImage {
            image_path: "<manual-second-qr>".to_string(),
            image_width: 0,
            image_height: 0,
            decoder_backend: "manual".to_string(),
            decoder_variant: "manual-second-qr".to_string(),
            recognized: super::qr_codec::recognize_login_qr_text(second_qr_id)?,
            contract_alignment: Value::Null,
        }));
    }
    Ok(None)
}

fn host_candidates(host: Option<&str>) -> Vec<String> {
    if let Some(host) = host {
        return vec![normalize_host(host)];
    }
    vec![
        normalize_host("https://api5.zhipin.com"),
        normalize_host("https://api-and.zhipin.com"),
    ]
}

fn host_header(host: &str) -> Result<String> {
    let parsed = reqwest::Url::parse(host).with_context(|| format!("invalid host url: {host}"))?;
    Ok(match parsed.port() {
        Some(port) => format!(
            "{}:{}",
            parsed.host_str().unwrap_or("api5.zhipin.com"),
            port
        ),
        None => parsed.host_str().unwrap_or("api5.zhipin.com").to_string(),
    })
}

fn secret_key_candidates(session: &SessionConfig) -> Vec<String> {
    let mut out = Vec::new();
    let trimmed = session.secret_key.trim();
    if !trimmed.is_empty() {
        out.push(trimmed.to_string());
    }
    out.push(String::new());
    out
}

fn normalize_optional_text(value: Option<&String>) -> Option<String> {
    value
        .map(|text| text.trim().to_string())
        .filter(|text| !text.is_empty())
}

fn normalize_optional_number(value: Option<&String>) -> Result<Option<String>> {
    let Some(value) = value else {
        return Ok(None);
    };
    let text = value.trim();
    if text.is_empty() {
        return Ok(None);
    }
    let parsed = text
        .parse::<f64>()
        .with_context(|| format!("invalid numeric location value: {text}"))?;
    Ok(Some(parsed.to_string()))
}

#[cfg(test)]
mod tests {
    use super::*;

    struct FakeSigner;

    impl BossSigner for FakeSigner {
        fn encode_request(&self, data: &[u8], _key: &str) -> Result<String> {
            Ok(format!("sp:{}", data.len()))
        }

        fn encode_request_body(&self, data: &[u8], _key: &str) -> Result<Vec<u8>> {
            Ok(data.to_vec())
        }

        fn signature(&self, data: &[u8], _key: &str) -> Result<String> {
            Ok(format!("sig:{}", data.len()))
        }

        fn decode_content(&self, content: &str, _key: &str) -> Result<Vec<u8>> {
            Ok(content.as_bytes().to_vec())
        }

        fn describe(&self) -> Value {
            json!({"strategy": "fake"})
        }
    }

    fn build_session() -> SessionConfig {
        SessionConfig {
            uid: "722593826".to_string(),
            identity: "0".to_string(),
            token: "tok-user".to_string(),
            token2: "tok2-user".to_string(),
            wt: "wt-user".to_string(),
            zp_at: "zp-at-user".to_string(),
            secret_key: "deadbeefdeadbeefdeadbeefdeadbeef".to_string(),
            phone: "13800138000".to_string(),
            fp_uniqid: "uniq-1".to_string(),
            fp_did: "did-1".to_string(),
            fp_brand: "realme".to_string(),
            fp_model: "RMX3560||RMX3560".to_string(),
            fp_network: "wifi".to_string(),
            fp_operator: "china-mobile".to_string(),
            fp_tinker_id: "tinker-1".to_string(),
            ..SessionConfig::default()
        }
    }

    #[test]
    fn passport_login_request_can_leave_second_qr_empty() {
        let session = build_session();
        let device = DeviceConfig::from_session(&session);
        let signer = FakeSigner;
        let location = LocationHint {
            has_location_permission: false,
            latitude: None,
            longitude: None,
            ssid: None,
            bssid: None,
        };

        let prepared = PreparedPassportRequest::sign(
            "https://api5.zhipin.com",
            &PassportStep::Login {
                qr_id: "bosszp-first",
                second_qr_id: "",
                login_type: 1,
            },
            &location,
            &device,
            &session,
            &signer,
            session.secret_key.as_str(),
        )
        .unwrap();

        let body = String::from_utf8(prepared.body_bytes).unwrap();
        assert!(body.contains("qrId=bosszp-first"));
        assert!(body.contains("secondQrId="));
        assert!(body.contains("loginType=1"));
        assert!(body.contains("sp="));
        assert!(body.contains("sig="));
        assert!(body.contains("app_id=1003"));
    }

    #[test]
    fn login_step_client_info_includes_location_when_enabled() {
        let mut params =
            build_common_params(&DeviceConfig::from_session(&build_session()), now_ms());
        let location = LocationHint {
            has_location_permission: true,
            latitude: Some("31.2304".to_string()),
            longitude: Some("121.4737".to_string()),
            ssid: Some("BOSS-WIFI".to_string()),
            bssid: Some("aa:bb:cc:dd:ee:ff".to_string()),
        };
        patch_client_info(&mut params, &location, true).unwrap();

        let client_info: Value = serde_json::from_str(params.get("client_info").unwrap()).unwrap();
        assert_eq!(client_info["loc_per"], 1);
        assert_eq!(client_info["latitude"], "31.2304");
        assert_eq!(client_info["longitude"], "121.4737");
        assert_eq!(client_info["ssid"], "BOSS-WIFI");
        assert_eq!(client_info["bssid"], "aa:bb:cc:dd:ee:ff");
    }
}
