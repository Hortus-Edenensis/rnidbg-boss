use std::collections::HashMap;
use std::fs;
use std::path::{Path, PathBuf};

use anyhow::{Context, Result};
use base64::engine::general_purpose::URL_SAFE_NO_PAD;
use base64::Engine;
use serde::Serialize;
use serde_json::{json, Value};

use super::qr_login::{default_session_candidates, load_session, DeviceConfig, SessionConfig};

const DEFAULT_BRAND: &str = "realme";
const DEFAULT_MODEL_NAME: &str = "RMX3560";
const DEFAULT_NETWORK_TYPE: &str = "wifi";
const DEFAULT_OPERATOR_NAME: &str = "CHN-CT";
const DEFAULT_TINKER_ID: &str = "Prod-arm64-v8a-release-14.010.1401010_0130-16-18-42";
const DEFAULT_OAID_HONOR: &str = "00000000-0000-0000-0000-000000000000";

const OPERATOR_MAP: &[(&str, &str)] = &[
    ("CMCC", "4E2D56FD79FB52A8"),
    ("CHN-CT", "4E2D56FD75354FE1"),
    ("CHN-UNICOM", "4E2D56FD806054085408"),
    ("CHN-CR", "4E2D56FD5E7F64AD"),
];

#[derive(Clone, Debug, Serialize)]
pub struct FingerprintOptions {
    pub brand: String,
    pub model_name: String,
    pub network_type: String,
    pub operator_name: String,
    pub is_huawei: bool,
}

impl Default for FingerprintOptions {
    fn default() -> Self {
        Self {
            brand: DEFAULT_BRAND.to_string(),
            model_name: DEFAULT_MODEL_NAME.to_string(),
            network_type: DEFAULT_NETWORK_TYPE.to_string(),
            operator_name: DEFAULT_OPERATOR_NAME.to_string(),
            is_huawei: false,
        }
    }
}

#[derive(Clone, Debug, Serialize)]
pub struct FingerprintUpdate {
    pub session_path: String,
    pub device: DeviceConfig,
    pub contract_alignment: Value,
}

pub fn run_fingerprint_randomize(opts: &HashMap<String, String>) -> Result<Value> {
    let session_path = find_existing_session_path(opts.get("--session-path").map(String::as_str))?;
    let mut session = load_session(Some(session_path.to_string_lossy().as_ref()))?;
    let device = randomize_session_fingerprint(&mut session, &options_from_opts(opts));
    save_session(&session_path, &session)?;

    Ok(serde_json::to_value(FingerprintUpdate {
        session_path: session_path.display().to_string(),
        contract_alignment: fingerprint_contract_alignment(),
        device,
    })?)
}

pub fn randomize_session_fingerprint(
    session: &mut SessionConfig,
    options: &FingerprintOptions,
) -> DeviceConfig {
    let device = generate_device_fingerprint(
        Some(session),
        options,
        identity_from_session(session.identity.as_str()),
    );
    apply_device_to_session(session, &device);
    device
}

pub fn generate_device_fingerprint(
    session: Option<&SessionConfig>,
    options: &FingerprintOptions,
    identity: i32,
) -> DeviceConfig {
    let brand = choose_string(
        session.map(|current| current.fp_brand.as_str()),
        &options.brand,
        DEFAULT_BRAND,
    );
    let model_name = choose_model_name(
        session.map(|current| current.fp_model.as_str()),
        &options.model_name,
    );
    let network = choose_string(
        session.map(|current| current.fp_network.as_str()),
        &options.network_type,
        DEFAULT_NETWORK_TYPE,
    );
    let operator_name = choose_string(None, &options.operator_name, DEFAULT_OPERATOR_NAME);

    DeviceConfig {
        uniqid: generate_uuid4(),
        did: generate_did(),
        oaid: generate_oaid(),
        oaid_honor: generate_oaid_honor(options.is_huawei),
        brand: brand.to_string(),
        model: format!("{brand}||{model_name}"),
        network: network.to_string(),
        operator: operator_code(operator_name),
        tinker_id: DEFAULT_TINKER_ID.to_string(),
        curidentity: identity,
        secret_key: session
            .map(|current| current.secret_key.clone())
            .unwrap_or_default(),
    }
}

pub fn overlay_random_device(session: &SessionConfig) -> DeviceConfig {
    let identity = identity_from_session(session.identity.as_str());
    let options = FingerprintOptions {
        brand: choose_string(Some(session.fp_brand.as_str()), "", DEFAULT_BRAND).to_string(),
        model_name: choose_model_name(Some(session.fp_model.as_str()), DEFAULT_MODEL_NAME)
            .to_string(),
        network_type: choose_string(Some(session.fp_network.as_str()), "", DEFAULT_NETWORK_TYPE)
            .to_string(),
        operator_name: operator_name_from_session(session.fp_operator.as_str()).to_string(),
        is_huawei: false,
    };
    let mut device = generate_device_fingerprint(Some(session), &options, identity);

    if !session.fp_uniqid.trim().is_empty() {
        device.uniqid = session.fp_uniqid.clone();
    }
    if !session.fp_did.trim().is_empty() {
        device.did = session.fp_did.clone();
    }
    if !session.fp_oaid.trim().is_empty() {
        device.oaid = session.fp_oaid.clone();
    }
    if !session.fp_oaid_honor.trim().is_empty() {
        device.oaid_honor = session.fp_oaid_honor.clone();
    }
    if !session.fp_brand.trim().is_empty() {
        device.brand = session.fp_brand.clone();
    }
    if !session.fp_model.trim().is_empty() {
        device.model = session.fp_model.clone();
    }
    if !session.fp_network.trim().is_empty() {
        device.network = session.fp_network.clone();
    }
    if !session.fp_operator.trim().is_empty() {
        device.operator = session.fp_operator.clone();
    }
    if !session.fp_tinker_id.trim().is_empty() {
        device.tinker_id = session.fp_tinker_id.clone();
    }

    device.secret_key = session.secret_key.clone();
    device.curidentity = identity;
    device
}

fn apply_device_to_session(session: &mut SessionConfig, device: &DeviceConfig) {
    session.fp_uniqid = device.uniqid.clone();
    session.fp_did = device.did.clone();
    session.fp_oaid = device.oaid.clone();
    session.fp_oaid_honor = device.oaid_honor.clone();
    session.fp_brand = device.brand.clone();
    session.fp_model = device.model.clone();
    session.fp_network = device.network.clone();
    session.fp_operator = device.operator.clone();
    session.fp_tinker_id = device.tinker_id.clone();
}

fn options_from_opts(opts: &HashMap<String, String>) -> FingerprintOptions {
    FingerprintOptions {
        brand: opts
            .get("--brand")
            .cloned()
            .filter(|value| !value.trim().is_empty())
            .unwrap_or_else(|| DEFAULT_BRAND.to_string()),
        model_name: opts
            .get("--model-name")
            .or_else(|| opts.get("--model"))
            .cloned()
            .filter(|value| !value.trim().is_empty())
            .unwrap_or_else(|| DEFAULT_MODEL_NAME.to_string()),
        network_type: opts
            .get("--network")
            .cloned()
            .filter(|value| !value.trim().is_empty())
            .unwrap_or_else(|| DEFAULT_NETWORK_TYPE.to_string()),
        operator_name: opts
            .get("--operator-name")
            .or_else(|| opts.get("--operator"))
            .cloned()
            .filter(|value| !value.trim().is_empty())
            .unwrap_or_else(|| DEFAULT_OPERATOR_NAME.to_string()),
        is_huawei: parse_bool_flag(opts.get("--huawei")),
    }
}

fn fingerprint_contract_alignment() -> Value {
    json!({
        "source": "boss_purecalc/fingerprint.py + config.py + c2/m/DUHelper evidence",
        "randomized_fields": ["uniqid", "did", "oaid", "oaid_honor"],
        "stable_fields": ["brand", "model", "network", "operator", "tinker_id"],
        "notes": [
            "uniqid follows UUID.randomUUID() semantics from c2.j(context)",
            "did follows DUq- + base64url(no padding) approximation because libdu.so JNI internals are not recoverable from Java",
            "oaid follows 64-char uppercase hex approximation because Main.getOpenAnmsID native internals are opaque",
            "oaid_honor stays zeroed for non-Huawei devices, matching boss_purecalc and APK runtime evidence"
        ]
    })
}

fn find_existing_session_path(session_path: Option<&str>) -> Result<PathBuf> {
    let candidates = if let Some(path) = session_path {
        vec![PathBuf::from(path)]
    } else {
        default_session_candidates()
    };
    for candidate in candidates {
        if candidate.is_file() {
            let raw = fs::read_to_string(&candidate)
                .with_context(|| format!("failed to read session file: {}", candidate.display()))?;
            let session: SessionConfig = serde_json::from_str(&raw).with_context(|| {
                format!("failed to parse session file: {}", candidate.display())
            })?;
            if session.is_valid() {
                return Ok(candidate);
            }
        }
    }
    load_session(session_path)?;
    unreachable!("load_session already returned a structured error")
}

fn save_session(path: &Path, session: &SessionConfig) -> Result<()> {
    let payload = serde_json::to_string_pretty(session)?;
    fs::write(path, format!("{payload}\n"))
        .with_context(|| format!("failed to write session file: {}", path.display()))
}

fn choose_string<'a>(
    session_value: Option<&'a str>,
    requested: &'a str,
    fallback: &'a str,
) -> &'a str {
    if let Some(value) = session_value {
        if !value.trim().is_empty() {
            return value.trim();
        }
    }
    if !requested.trim().is_empty() {
        requested.trim()
    } else {
        fallback
    }
}

fn choose_model_name<'a>(session_model: Option<&'a str>, requested: &'a str) -> &'a str {
    if let Some(value) = session_model {
        if !value.trim().is_empty() {
            return value.split("||").nth(1).unwrap_or(value).trim();
        }
    }
    if !requested.trim().is_empty() {
        requested.trim()
    } else {
        DEFAULT_MODEL_NAME
    }
}

fn operator_code(name: &str) -> String {
    OPERATOR_MAP
        .iter()
        .find(|(key, _)| *key == name)
        .map(|(_, value)| (*value).to_string())
        .unwrap_or_else(|| OPERATOR_MAP[1].1.to_string())
}

fn operator_name_from_session(code: &str) -> &str {
    OPERATOR_MAP
        .iter()
        .find(|(_, value)| *value == code)
        .map(|(key, _)| *key)
        .unwrap_or(DEFAULT_OPERATOR_NAME)
}

fn identity_from_session(identity: &str) -> i32 {
    match identity.trim() {
        "1" | "boss" => 1,
        _ => 0,
    }
}

fn parse_bool_flag(value: Option<&String>) -> bool {
    value
        .map(|current| matches!(current.trim(), "1" | "true" | "yes" | "on"))
        .unwrap_or(false)
}

fn generate_uuid4() -> String {
    let mut bytes = [0u8; 16];
    for byte in &mut bytes {
        *byte = rand::random::<u8>();
    }
    bytes[6] = (bytes[6] & 0x0f) | 0x40;
    bytes[8] = (bytes[8] & 0x3f) | 0x80;
    format!(
        "{:02x}{:02x}{:02x}{:02x}-{:02x}{:02x}-{:02x}{:02x}-{:02x}{:02x}-{:02x}{:02x}{:02x}{:02x}{:02x}{:02x}",
        bytes[0],
        bytes[1],
        bytes[2],
        bytes[3],
        bytes[4],
        bytes[5],
        bytes[6],
        bytes[7],
        bytes[8],
        bytes[9],
        bytes[10],
        bytes[11],
        bytes[12],
        bytes[13],
        bytes[14],
        bytes[15]
    )
}

fn generate_did() -> String {
    let mut bytes = vec![0u8; 48];
    for byte in &mut bytes {
        *byte = rand::random::<u8>();
    }
    format!("DUq-{}", URL_SAFE_NO_PAD.encode(bytes))
}

fn generate_oaid() -> String {
    const HEX: &[u8] = b"0123456789ABCDEF";
    (0..64)
        .map(|_| HEX[(rand::random::<u8>() as usize) % HEX.len()] as char)
        .collect()
}

fn generate_oaid_honor(is_huawei: bool) -> String {
    if is_huawei {
        generate_uuid4()
    } else {
        DEFAULT_OAID_HONOR.to_string()
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn generated_fingerprint_matches_boss_shape() {
        let device = generate_device_fingerprint(None, &FingerprintOptions::default(), 0);

        assert_eq!(device.uniqid.len(), 36);
        assert_eq!(&device.uniqid[14..15], "4");
        assert!(device.did.starts_with("DUq-"));
        assert_eq!(device.oaid.len(), 64);
        assert!(device.oaid.chars().all(|ch| ch.is_ascii_hexdigit()));
        assert_eq!(device.oaid_honor, DEFAULT_OAID_HONOR);
        assert_eq!(device.brand, DEFAULT_BRAND);
        assert_eq!(device.model, "realme||RMX3560");
        assert_eq!(device.network, DEFAULT_NETWORK_TYPE);
        assert_eq!(device.operator, "4E2D56FD75354FE1");
        assert_eq!(device.tinker_id, DEFAULT_TINKER_ID);
    }

    #[test]
    fn overlay_random_device_replaces_mock_fallbacks() {
        let session = SessionConfig {
            uid: "722593826".to_string(),
            identity: "0".to_string(),
            token2: "tok2".to_string(),
            secret_key: "secret".to_string(),
            ..SessionConfig::default()
        };

        let device = overlay_random_device(&session);

        assert!(!device.uniqid.starts_with("mock-uniqid-"));
        assert!(!device.did.starts_with("mock-did-"));
        assert_eq!(device.brand, DEFAULT_BRAND);
        assert_eq!(device.model, "realme||RMX3560");
        assert_eq!(device.operator, "4E2D56FD75354FE1");
        assert_eq!(device.secret_key, "secret");
    }
}
