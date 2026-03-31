use std::any::Any;
use std::cell::{RefCell, UnsafeCell};
use std::collections::{BTreeMap, HashMap, HashSet, VecDeque};
use std::fs::{self, File, OpenOptions};
use std::io::{self, Read, Write};
use std::net::{TcpListener, TcpStream};
use std::os::unix::fs::symlink;
use std::path::{Path, PathBuf};
use std::process::{Command, Output, Stdio};
use std::rc::Rc;
use std::time::Duration;

use anyhow::{anyhow, Context, Result};
use base64::engine::general_purpose::STANDARD as BASE64_STANDARD;
use base64::Engine as _;
use boa_engine::{Context as BoaContext, Source};
use chrono::{SecondsFormat, Utc};
use emulator::android::dvm::class::DvmClass;
use emulator::android::dvm::class_resolver::ClassResolver;
use emulator::android::dvm::member::DvmMethod;
use emulator::android::dvm::object::DvmObject;
use emulator::android::dvm::DalvikVM64;
use emulator::android::jni::{self, Jni, JniValue, MethodAcc, VaList};
use emulator::android::virtual_library::libc::SystemPropertyService;
use emulator::linux::errno::Errno;
use emulator::linux::file_system::{FileIO, StMode};
use emulator::linux::fs::direction::{Direction, DirectionEntry};
use emulator::linux::fs::linux_file::LinuxFileIO;
use emulator::linux::fs::ByteArrayFileIO;
use emulator::linux::PAGE_ALIGN;
use emulator::memory::svc_memory::SvcCallResult::RET;
use emulator::memory::svc_memory::{SimpleArm64Svc, SvcCallResult};
#[cfg(feature = "unicorn")]
use emulator::UnicornRegisterARM64;
use emulator::{AndroidEmulator, Backend, BackendKind, Permission, RegisterARM64, UnicornArg};
use rand::Rng;
use reqwest::blocking::Client;
use reqwest::header::{HeaderMap, HeaderName, HeaderValue};
use serde::{Deserialize, Serialize};
use serde_json::{json, Map, Value};
use sha2::{Digest, Sha256};
use std::mem::size_of;
use std::time::SystemTime;
use std::time::UNIX_EPOCH;
#[cfg(feature = "unicorn")]
use unicorn_engine::unicorn_const::HookType;
#[cfg(feature = "unicorn")]
use unicorn_engine::Unicorn;
use url::Url;
use zip::ZipArchive;

const PID: u32 = 2667;
const PPID: u32 = 2427;
const V7_FINGERPRINT_KEYS: &[&str] = &[
    "mobile",
    "countryCode",
    "captcha",
    "paramNum",
    "verifyStatus",
    "modeType",
    "rid",
    "diffTime",
    "platform",
    "versionCode",
    "autoLogin",
    "dfp",
    "appList",
    "ipInfo",
    "sdid",
    "oaid",
    "androidId",
    "appId",
    "channelId",
    "did",
    "mac",
    "imei",
    "oneId",
    "dhid",
];
const V7_CAPTCHA_BRIDGE_KEYS: &[&str] = &["verifyStatus", "rid", "modeType", "diffTime", "captcha"];
const V7_STAGE_BASE_REQUIRED_KEYS: &[&str] = &[
    "mobile",
    "countryCode",
    "paramNum",
    "verifyStatus",
    "platform",
    "versionCode",
    "autoLogin",
    "dfp",
    "appList",
    "ipInfo",
    "sdid",
    "oaid",
    "androidId",
    "appId",
    "channelId",
];
const V7_STAGE2_REQUIRED_KEYS: &[&str] = &["modeType", "rid", "diffTime"];

#[derive(Clone, Debug, Deserialize)]
struct PalmchatConfig {
    #[serde(rename = "package")]
    package_name: String,
    apk_path: PathBuf,
    #[serde(default)]
    app_version_code: Option<String>,
    #[serde(default)]
    app_version_name: Option<String>,
    #[serde(default)]
    app_manifest_path: Option<PathBuf>,
    so_path: PathBuf,
    #[serde(default)]
    hash_key_fast: Option<String>,
    #[serde(default)]
    wksec_so_path: Option<PathBuf>,
    #[serde(default)]
    got_seed_path: Option<PathBuf>,
    #[serde(default)]
    runtime_page_patches: Vec<PalmchatPagePatchEntry>,
    #[serde(default)]
    runtime_raw_maps: Vec<PalmchatRawMemoryMapEntry>,
    #[serde(default)]
    runtime_page_patches_after_create_ckey: Vec<PalmchatPagePatchEntry>,
    #[serde(default)]
    hidden_symbol_offsets: HashMap<String, String>,
    #[serde(default)]
    system_lib_overrides: HashMap<String, PathBuf>,
    #[serde(default)]
    target_sdk: Option<i32>,
    #[serde(default)]
    identity_probe: PalmchatIdentityProbeConfig,
    trace_out_dir: PathBuf,
    android_api: i32,
    backend: String,
}

#[derive(Clone, Debug)]
struct PalmchatAppContextFs {
    legacy_data_dir: String,
    user0_data_dir: String,
    files_dir: String,
    cache_dir: String,
    host_data_dir: PathBuf,
    host_files_dir: PathBuf,
    host_cache_dir: PathBuf,
}

impl PalmchatAppContextFs {
    fn new(trace_out_dir: &Path, package_name: &str) -> Result<Self> {
        let host_data_dir = trace_out_dir
            .join("app_ctx_fs")
            .join("data")
            .join("data")
            .join(package_name);
        let host_files_dir = host_data_dir.join("files");
        let host_cache_dir = host_data_dir.join("cache");
        fs::create_dir_all(host_files_dir.join("hash")).with_context(|| {
            format!(
                "failed to create palmchat app files dir: {}",
                host_files_dir.display()
            )
        })?;
        fs::create_dir_all(&host_cache_dir).with_context(|| {
            format!(
                "failed to create palmchat app cache dir: {}",
                host_cache_dir.display()
            )
        })?;
        Ok(Self {
            legacy_data_dir: format!("/data/data/{package_name}"),
            user0_data_dir: format!("/data/user/0/{package_name}"),
            files_dir: format!("/data/data/{package_name}/files"),
            cache_dir: format!("/data/data/{package_name}/cache"),
            host_data_dir,
            host_files_dir,
            host_cache_dir,
        })
    }

    fn host_path_for_guest(&self, guest_path: &str) -> Option<PathBuf> {
        for base in [&self.legacy_data_dir, &self.user0_data_dir] {
            if guest_path == base {
                return Some(self.host_data_dir.clone());
            }
            if let Some(suffix) = guest_path.strip_prefix(&(base.clone() + "/")) {
                return Some(self.host_data_dir.join(suffix));
            }
        }
        None
    }

    fn guest_dir_for_name(&self, name: &str) -> String {
        format!("{}/app_{}", self.legacy_data_dir, name)
    }

    fn ensure_host_dir_for_guest(&self, guest_path: &str) -> Result<PathBuf> {
        let host_path = self
            .host_path_for_guest(guest_path)
            .ok_or_else(|| anyhow!("guest path is outside palmchat app context fs: {guest_path}"))?;
        fs::create_dir_all(&host_path).with_context(|| {
            format!(
                "failed to create palmchat guest directory mapping {} -> {}",
                guest_path,
                host_path.display()
            )
        })?;
        Ok(host_path)
    }

    fn file_state_for_path(&self, requested_path: &str) -> PalmchatFileState {
        let trimmed = requested_path.trim();
        if let Some(host_path) = self.host_path_for_guest(trimmed) {
            PalmchatFileState {
                guest_path: trimmed.to_string(),
                host_path,
            }
        } else {
            PalmchatFileState {
                guest_path: trimmed.to_string(),
                host_path: PathBuf::from(trimmed),
            }
        }
    }
}

#[derive(Clone, Debug, Default, Deserialize)]
struct PalmchatIdentityProbeConfig {
    #[serde(default)]
    privacy_agree: Option<bool>,
    #[serde(default)]
    read_phone_state_granted: Option<bool>,
    #[serde(default)]
    priv_info_initialized: Option<bool>,
    #[serde(default)]
    android_id: Option<String>,
    #[serde(default)]
    imei: Option<String>,
    #[serde(default)]
    mac: Option<String>,
    #[serde(default)]
    sdid: Option<String>,
    #[serde(default)]
    local_smid: Option<String>,
    #[serde(default)]
    device_label: Option<String>,
    #[serde(default)]
    process_name: Option<String>,
}

#[derive(Clone, Debug, Deserialize, Serialize)]
struct PalmchatIdentityRuntimeState {
    privacy_agree: Option<bool>,
    read_phone_state_granted: Option<bool>,
    priv_info_initialized: bool,
    android_id: String,
    imei: String,
    mac: String,
    sdid: String,
    local_smid: String,
    device_label: String,
    process_name: String,
}

impl PalmchatIdentityRuntimeState {
    fn from_config(config: &PalmchatIdentityProbeConfig) -> Self {
        Self {
            privacy_agree: config.privacy_agree,
            read_phone_state_granted: config.read_phone_state_granted,
            priv_info_initialized: config.priv_info_initialized.unwrap_or(false),
            android_id: config.android_id.clone().unwrap_or_default(),
            imei: config.imei.clone().unwrap_or_default(),
            mac: config.mac.clone().unwrap_or_default(),
            sdid: config.sdid.clone().unwrap_or_default(),
            local_smid: config.local_smid.clone().unwrap_or_default(),
            device_label: config.device_label.clone().unwrap_or_default(),
            process_name: config.process_name.clone().unwrap_or_default(),
        }
    }

    fn effective_privacy_agree(&self) -> bool {
        self.privacy_agree.unwrap_or(false)
    }

    fn effective_read_phone_state(&self) -> bool {
        self.read_phone_state_granted.unwrap_or(false)
    }

    fn effective_android_id(&self) -> String {
        if self.android_id.trim().is_empty() {
            "unknown".to_string()
        } else {
            self.android_id.clone()
        }
    }

    fn effective_imei(&self) -> String {
        if self.effective_read_phone_state() {
            self.imei.clone()
        } else {
            String::new()
        }
    }

    fn effective_mac(&self) -> String {
        self.mac.clone()
    }

    fn effective_sdid(&self) -> String {
        self.sdid.clone()
    }

    fn effective_local_smid(&self) -> String {
        self.local_smid.clone()
    }

    fn effective_device_label(&self) -> String {
        self.device_label.clone()
    }

    fn effective_process_name(&self, package_name: &str) -> String {
        if self.process_name.trim().is_empty() {
            package_name.to_string()
        } else {
            self.process_name.clone()
        }
    }
}

#[derive(Clone, Debug, Default, Serialize)]
struct PalmchatLiveDeviceProfile {
    source: String,
    android_id: Option<String>,
    sdid: Option<String>,
    device_label: Option<String>,
    tray_device_id: Option<String>,
    account_uid: Option<String>,
    account_exid: Option<String>,
    account_phone: Option<String>,
    account_session_id_enc: Option<String>,
    account_refresh_key_enc: Option<String>,
    oaid: Option<String>,
    channel_id: Option<String>,
    ip_info: Option<String>,
    installed_packages: Vec<String>,
    data_dir_packages: Vec<String>,
    app_version_code: Option<String>,
    app_version_name: Option<String>,
    build_fingerprint: Option<String>,
    build_display: Option<String>,
    build_incremental: Option<String>,
    build_time_millis: Option<i64>,
    build_tags: Option<String>,
    build_bootloader: Option<String>,
    build_version_codename: Option<String>,
    build_host: Option<String>,
    build_id: Option<String>,
    product_model: Option<String>,
    product_brand: Option<String>,
    product_manufacturer: Option<String>,
    product_device: Option<String>,
    product_name: Option<String>,
    product_board: Option<String>,
    product_abi_list: Vec<String>,
    build_release: Option<String>,
    locale_tag: Option<String>,
    display_density: Option<String>,
    build_security_patch: Option<String>,
    hardware: Option<String>,
    usb_state: Option<String>,
    wlan_ipv4: Option<String>,
    wifi_ssid: Option<String>,
    network_type: Option<String>,
    network_state: Option<String>,
    mobile_data_enabled: Option<bool>,
    webview_user_agent: Option<String>,
    baseband_version: Option<String>,
    cpu_cores: Option<i64>,
    cpu_features: Option<String>,
    cpu_processor: Option<String>,
    cpuinfo_hardware: Option<String>,
    cpu_max_freq: Option<String>,
    cpu_min_freq: Option<String>,
    kernel_version: Option<String>,
    http_proxy_host: Option<String>,
    http_proxy_port: Option<i64>,
    boot_time_millis: Option<i64>,
    resolution: Option<String>,
    screen_brightness: Option<i64>,
    screen_on: Option<bool>,
    sensor_name_list: Vec<String>,
    enabled_accessibility_packages: Vec<String>,
    input_method_ids: Vec<String>,
    input_method_labels: Vec<String>,
    secinfo_json: Option<String>,
}

#[derive(Clone, Debug, Default)]
struct PalmchatSmssendUrlAuth {
    uid: Option<String>,
    token: Option<String>,
    session_id: Option<String>,
    callback_id: Option<String>,
    p_id: Option<String>,
    sys_uid: Option<String>,
}

#[derive(Clone, Debug, Default, Serialize)]
struct PalmchatRecoveredAuthState {
    uid: Option<String>,
    session_id: Option<String>,
    refresh_key: Option<String>,
    source: String,
    token_after_bootstrap: Option<String>,
    skey_available_before: bool,
    skey_available_after: bool,
    uid_present: bool,
    session_id_present: bool,
    refresh_key_present: bool,
    refresh_server_key_invoked: bool,
    messaging_service_secret_present: bool,
    app_context_secret_present_before: bool,
    app_context_secret_present_after: bool,
    token_present_after: bool,
    failure_reason: Option<String>,
}

#[derive(Clone, Debug, Default)]
struct PalmchatSecretPair {
    key: Vec<u8>,
    iv: Vec<u8>,
}

#[derive(Clone, Debug)]
struct PalmchatAAssetHandle {
    name: String,
    handle_ptr: u64,
    data_ptr: u64,
    len: usize,
    cursor: usize,
    bytes: Vec<u8>,
}

#[derive(Clone, Debug)]
struct PalmchatAssetShimState {
    manager_ptr: u64,
    apk_path: PathBuf,
    arena_base: u64,
    arena_cursor: u64,
    arena_end: u64,
    open_handles: HashMap<u64, PalmchatAAssetHandle>,
}

impl PalmchatAssetShimState {
    fn alloc(&mut self, size: usize, align: u64) -> Option<u64> {
        let aligned = align_up_u64(self.arena_cursor, align.max(1));
        let end = aligned.checked_add(size.max(1) as u64)?;
        if end > self.arena_end {
            return None;
        }
        self.arena_cursor = end;
        Some(aligned)
    }

    fn handle(&self, ptr: u64) -> Option<&PalmchatAAssetHandle> {
        self.open_handles.get(&ptr)
    }

    fn handle_mut(&mut self, ptr: u64) -> Option<&mut PalmchatAAssetHandle> {
        self.open_handles.get_mut(&ptr)
    }
}

#[derive(Clone, Copy, Debug, Eq, PartialEq)]
enum PalmchatTransportRuntime {
    Auto,
    Direct,
    OkHttpBridge,
}

impl PalmchatTransportRuntime {
    fn parse(value: Option<&str>) -> Result<Self> {
        match value.unwrap_or("auto").trim().to_ascii_lowercase().as_str() {
            "" | "auto" => Ok(Self::Auto),
            "direct" => Ok(Self::Direct),
            "okhttp-bridge" | "okhttp_bridge" | "okhttp" => Ok(Self::OkHttpBridge),
            other => Err(anyhow!("unsupported transport runtime: {other}")),
        }
    }
}

#[derive(Debug)]
struct PalmchatHttpTransportResponse {
    status: u16,
    headers: HashMap<String, String>,
    body_bytes: Vec<u8>,
    transport: Value,
}

#[derive(Clone, Debug, Default)]
struct PalmchatSecretStringCandidate {
    value: String,
    source: String,
    addr: u64,
    offset: usize,
}

#[derive(Clone, Default)]
struct PalmchatPairState {
    first: Option<DvmObject>,
    second: Option<DvmObject>,
}

#[derive(Clone, Default)]
struct PalmchatSw4State {
    url: String,
    body_map: Map<String, Value>,
    encrypted_body_type: i32,
    encrypted_request: bool,
}

#[derive(Clone, Debug, Default)]
struct PalmchatRecoveredAuthCandidates {
    cli_uid: Option<String>,
    cli_session_id: Option<String>,
    live_uid: Option<String>,
    live_session_id: Option<String>,
    live_refresh_key: Option<String>,
    java_uid: Option<String>,
    java_session_id: Option<String>,
    java_refresh_key: Option<String>,
}

#[derive(Clone, Debug, Default)]
struct PalmchatRuntimeProbeOverrides {
    source_path: String,
    android_id: Option<String>,
    ip_info: Option<String>,
    secinfo_json: Option<String>,
    network_type: Option<String>,
    network_state: Option<String>,
    wifi_ssid: Option<String>,
    wlan_ipv4: Option<String>,
    resolution: Option<String>,
    screen_brightness: Option<i64>,
    screen_on: Option<bool>,
    sensor_name_list: Option<Vec<String>>,
    device_label: Option<String>,
    baseband_version: Option<String>,
    kernel_version: Option<String>,
    boot_time_millis: Option<i64>,
    installed_packages: Option<Vec<String>>,
}

impl PalmchatLiveDeviceProfile {
    fn apply_to_identity_seed(&self, state: &mut PalmchatIdentityRuntimeState) {
        if let Some(android_id) = normalize_plain_candidate(self.android_id.clone()) {
            state.android_id = android_id;
        }
        if let Some(sdid) = normalize_device_id_candidate(self.sdid.clone()) {
            state.sdid = sdid;
        }
        if let Some(device_label) = normalize_plain_candidate(self.device_label.clone()) {
            state.device_label = device_label;
        }
    }

    fn update_identity_state_from_effective_body(
        &self,
        state: &mut PalmchatIdentityRuntimeState,
        value: &Value,
        opts: &HashMap<String, String>,
    ) -> Vec<String> {
        let mut events = Vec::new();
        let mut next_android_id = self.android_id.clone();
        let mut next_imei = None::<String>;
        let mut next_mac = None::<String>;
        let mut next_sdid = None::<String>;
        let mut next_local_smid = None::<String>;
        let mut next_device_label = opts.get("--seed-device-label").cloned();

        if let Value::Object(map) = value {
            next_android_id = extract_non_empty_string(map, "androidId").or(next_android_id);
            next_sdid =
                extract_non_empty_string(map, "sdid").or_else(|| opts.get("--seed-sdid").cloned());
            next_local_smid = extract_non_empty_string(map, "local_smid")
                .or_else(|| opts.get("--seed-local-smid").cloned());
            next_imei = match map.get("imei") {
                Some(Value::Null) => Some(String::new()),
                Some(Value::String(raw)) => Some(raw.trim().to_string()),
                _ => opts.get("--seed-imei").cloned(),
            };
            next_mac = match map.get("mac") {
                Some(Value::Null) => Some(String::new()),
                Some(Value::String(raw)) => Some(raw.trim().to_string()),
                _ => opts.get("--seed-mac").cloned(),
            };

            if next_device_label.is_none() {
                if let Some(Value::Object(dfp_obj)) = parse_json_string_or_object(map.get("dfp")) {
                    next_device_label = extract_non_empty_string(&dfp_obj, "duDeviceLabel");
                }
            }
        }

        if let Some(android_id) = normalize_plain_candidate(next_android_id) {
            if state.android_id != android_id {
                state.android_id = android_id.clone();
                events.push(format!("identity.android_id={android_id}"));
            }
        }
        if let Some(imei) = next_imei {
            if state.imei != imei {
                state.imei = imei.clone();
                events.push(format!("identity.imei_len={}", imei.len()));
            }
        }
        if let Some(mac) = next_mac {
            if state.mac != mac {
                state.mac = mac.clone();
                events.push(format!("identity.mac_len={}", mac.len()));
            }
        }
        if let Some(sdid) = normalize_plain_candidate(next_sdid) {
            if state.sdid != sdid {
                state.sdid = sdid.clone();
                events.push(format!("identity.sdid={sdid}"));
            }
        }
        if let Some(local_smid) = normalize_plain_candidate(next_local_smid) {
            if state.local_smid != local_smid {
                state.local_smid = local_smid.clone();
                events.push(format!("identity.local_smid={local_smid}"));
            }
        }
        if let Some(device_label) = normalize_device_label_candidate(next_device_label) {
            if state.device_label != device_label {
                state.device_label = device_label.clone();
                events.push(format!("identity.device_label={device_label}"));
            }
        }
        if state.priv_info_initialized {
            state.priv_info_initialized = false;
            events.push("identity.priv_info_initialized=false".to_string());
        }

        events
    }
}

#[derive(Clone, Debug, Deserialize, Serialize)]
struct CaptchaUiDebugSubmission {
    verify_status: bool,
    rid: String,
    mode_type: String,
    diff_time: String,
}

#[derive(Clone, Debug)]
struct CaptchaUiDebugLaunch {
    submission: CaptchaUiDebugSubmission,
    extra_events: Vec<Value>,
    ui_mode: String,
    ui_source: String,
}

impl PalmchatConfig {
    fn load(path: impl AsRef<Path>) -> Result<Self> {
        let path = path.as_ref();
        let raw = fs::read_to_string(path)
            .with_context(|| format!("failed to read config: {}", path.display()))?;
        let mut config: PalmchatConfig = serde_json::from_str(&raw)
            .with_context(|| format!("failed to parse config json: {}", path.display()))?;
        config.apk_path = normalize(config.apk_path);
        config.app_version_code = config
            .app_version_code
            .map(|value| value.trim().to_string())
            .filter(|value| !value.is_empty());
        config.app_version_name = config
            .app_version_name
            .map(|value| value.trim().to_string())
            .filter(|value| !value.is_empty());
        config.app_manifest_path = config.app_manifest_path.map(normalize);
        config.so_path = normalize(config.so_path);
        config.hash_key_fast = config
            .hash_key_fast
            .map(|value| value.trim().to_ascii_uppercase());
        config.identity_probe.android_id = config
            .identity_probe
            .android_id
            .map(|value| value.trim().to_string())
            .filter(|value| !value.is_empty());
        config.identity_probe.imei = config
            .identity_probe
            .imei
            .map(|value| value.trim().to_string());
        config.identity_probe.mac = config
            .identity_probe
            .mac
            .map(|value| value.trim().to_string());
        config.identity_probe.process_name = config
            .identity_probe
            .process_name
            .map(|value| value.trim().to_string())
            .filter(|value| !value.is_empty());
        config.wksec_so_path = config.wksec_so_path.map(normalize);
        config.got_seed_path = config.got_seed_path.map(normalize);
        config.runtime_page_patches = config
            .runtime_page_patches
            .into_iter()
            .map(|mut entry| {
                entry.path = normalize(entry.path);
                entry
            })
            .collect();
        config.runtime_raw_maps = config
            .runtime_raw_maps
            .into_iter()
            .map(|mut entry| {
                entry.path = normalize(entry.path);
                entry
            })
            .collect();
        config.runtime_page_patches_after_create_ckey = config
            .runtime_page_patches_after_create_ckey
            .into_iter()
            .map(|mut entry| {
                entry.path = normalize(entry.path);
                entry
            })
            .collect();
        config.system_lib_overrides = config
            .system_lib_overrides
            .into_iter()
            .map(|(name, path)| (name, normalize(path)))
            .collect();
        maybe_inject_device_core_syslibs(path, &mut config)?;
        config.trace_out_dir = normalize(config.trace_out_dir);
        config.backend = normalize_backend_name(&config.backend)?.to_string();
        Ok(config)
    }

    fn with_backend_override(mut self, backend_override: Option<&str>) -> Result<Self> {
        if let Some(value) = backend_override {
            self.backend = normalize_backend_name(value)?.to_string();
        }
        Ok(self)
    }

    fn backend_kind(&self) -> Result<BackendKind> {
        BackendKind::parse(&self.backend)
            .ok_or_else(|| anyhow!("unsupported backend: {}", self.backend))
    }
}

#[derive(Clone, Debug, Default)]
struct PalmchatAppVersionInfo {
    version_code: Option<String>,
    version_name: Option<String>,
    source: Option<String>,
}

fn maybe_inject_device_core_syslibs(path: &Path, config: &mut PalmchatConfig) -> Result<()> {
    if !config.system_lib_overrides.is_empty() {
        return Ok(());
    }

    let Some(file_name) = path.file_name().and_then(|name| name.to_str()) else {
        return Ok(());
    };
    let Some(prefix) = file_name.strip_suffix(".json") else {
        return Ok(());
    };

    let mut candidates = Vec::new();
    let mut prefixes = Vec::new();
    let mut cursor = prefix.to_string();
    loop {
        prefixes.push(cursor.clone());
        let Some((next, _tail)) = cursor.rsplit_once('.') else {
            break;
        };
        cursor = next.to_string();
    }

    for candidate_prefix in prefixes {
        for suffix in [".device_syslibs2.json", ".device_syslibs.json"] {
            candidates.push(path.with_file_name(format!("{candidate_prefix}{suffix}")));
        }
    }

    for candidate in candidates {
        if !candidate.exists() {
            continue;
        }
        let raw = fs::read_to_string(&candidate).with_context(|| {
            format!(
                "failed to read device syslibs companion config: {}",
                candidate.display()
            )
        })?;
        let companion: PalmchatConfig = serde_json::from_str(&raw).with_context(|| {
            format!(
                "failed to parse device syslibs companion config: {}",
                candidate.display()
            )
        })?;
        let mut merged = HashMap::new();
        for name in ["libc.so", "ld-android.so", "libm.so"] {
            if let Some(value) = companion.system_lib_overrides.get(name) {
                merged.insert(name.to_string(), normalize(value.clone()));
            }
        }
        if !merged.is_empty() {
            config.system_lib_overrides = merged;
            return Ok(());
        }
    }

    Ok(())
}

fn resolve_app_version_info(
    config: &PalmchatConfig,
    live_device_profile: Option<&PalmchatLiveDeviceProfile>,
    shared: Rc<RefCell<SharedState>>,
) -> PalmchatAppVersionInfo {
    if let Some(profile) = live_device_profile {
        if profile.app_version_code.is_some() || profile.app_version_name.is_some() {
            let info = PalmchatAppVersionInfo {
                version_code: profile.app_version_code.clone(),
                version_name: profile.app_version_name.clone(),
                source: Some("live_device_profile.package_info".to_string()),
            };
            shared.borrow_mut().native(&format!(
                "app version source=live_device_profile code={:?} name={:?}",
                info.version_code, info.version_name
            ));
            return info;
        }
    }

    if config.app_version_code.is_some() || config.app_version_name.is_some() {
        let info = PalmchatAppVersionInfo {
            version_code: config.app_version_code.clone(),
            version_name: config.app_version_name.clone(),
            source: Some("config.app_version_*".to_string()),
        };
        shared.borrow_mut().native(&format!(
            "app version source=config code={:?} name={:?}",
            info.version_code, info.version_name
        ));
        return info;
    }

    if let Some(manifest_path) = &config.app_manifest_path {
        match parse_manifest_version_info(manifest_path) {
            Ok(mut info) => {
                if info.version_code.is_some() || info.version_name.is_some() {
                    info.source = Some(format!("manifest:{}", manifest_path.display()));
                    shared.borrow_mut().native(&format!(
                        "app version source=manifest path={} code={:?} name={:?}",
                        manifest_path.display(),
                        info.version_code,
                        info.version_name
                    ));
                    return info;
                }
                shared.borrow_mut().native(&format!(
                    "app version source=manifest path={} code/name missing",
                    manifest_path.display()
                ));
            }
            Err(err) => {
                shared.borrow_mut().native(&format!(
                    "app version source=manifest path={} failed err={}",
                    manifest_path.display(),
                    err
                ));
            }
        }
    }

    shared
        .borrow_mut()
        .native("app version source unavailable; keeping input version fields as-is");
    PalmchatAppVersionInfo::default()
}

fn parse_manifest_version_info(path: &Path) -> Result<PalmchatAppVersionInfo> {
    let raw = fs::read_to_string(path).with_context(|| {
        format!(
            "failed to read manifest for app version: {}",
            path.display()
        )
    })?;
    let version_code = extract_xml_attr(&raw, "android:versionCode")
        .or_else(|| extract_xml_attr(&raw, "versionCode"));
    let version_name = extract_xml_attr(&raw, "android:versionName")
        .or_else(|| extract_xml_attr(&raw, "versionName"));
    Ok(PalmchatAppVersionInfo {
        version_code,
        version_name,
        source: None,
    })
}

fn extract_xml_attr(raw: &str, attr: &str) -> Option<String> {
    let double_quoted = format!("{attr}=\"");
    if let Some(start) = raw.find(&double_quoted) {
        let rest = &raw[start + double_quoted.len()..];
        if let Some(end) = rest.find('"') {
            return Some(rest[..end].to_string());
        }
    }

    let single_quoted = format!("{attr}='");
    if let Some(start) = raw.find(&single_quoted) {
        let rest = &raw[start + single_quoted.len()..];
        if let Some(end) = rest.find('\'') {
            return Some(rest[..end].to_string());
        }
    }

    None
}

struct SharedState {
    jni_log: File,
    native_log: File,
}

#[derive(Clone, Debug, Default, Serialize)]
struct PalmchatFlowStepReport {
    start_at: Option<String>,
    end_at: Option<String>,
    duration_ms: Option<i64>,
    return_debug: Option<String>,
    done_note: Option<String>,
}

#[derive(Clone, Debug, Serialize)]
struct PalmchatChunkSample {
    iteration: usize,
    fread_ret: u64,
    apk_offset: u64,
    matches_apk_prefix: bool,
    chunk_head: String,
}

#[derive(Clone, Debug, Default, Serialize)]
struct PalmchatCipherEvidenceReport {
    apk_path: Option<String>,
    apk_mode: Option<String>,
    apk_size: Option<u64>,
    hash_key: Option<String>,
    fread_target: Option<String>,
    fread_size: Option<u64>,
    fread_nmemb: Option<u64>,
    chunk_iterations_observed: usize,
    chunk_samples: Vec<PalmchatChunkSample>,
}

#[derive(Clone, Debug, Serialize)]
struct PalmchatFlowReport {
    status: String,
    native_log: String,
    config_path: Option<String>,
    trace_out_dir: Option<String>,
    flow: Option<String>,
    flow_result: Option<Value>,
    steps: BTreeMap<String, PalmchatFlowStepReport>,
    cipher_evidence: PalmchatCipherEvidenceReport,
    plt_targets: BTreeMap<String, String>,
}

#[derive(Clone, Debug, Deserialize)]
struct PalmchatGotSeedEntry {
    slot_offset: String,
    module: String,
    #[serde(default)]
    symbol: Option<String>,
    #[serde(default)]
    target_offset: Option<String>,
}

#[derive(Clone, Debug, Deserialize)]
struct PalmchatPagePatchEntry {
    offset: String,
    path: PathBuf,
    #[serde(default)]
    pointer_rebases: Vec<PalmchatPointerRebaseEntry>,
    #[serde(default)]
    scratch_pointer_slots: Vec<PalmchatScratchPointerSlotEntry>,
}

#[derive(Clone, Debug, Deserialize)]
struct PalmchatRawMemoryMapEntry {
    address: String,
    path: PathBuf,
    #[serde(default)]
    pointer_rebases: Vec<PalmchatPointerRebaseEntry>,
}

#[derive(Clone, Debug, Deserialize)]
struct PalmchatPointerRebaseEntry {
    module: String,
    source_start: String,
    source_end: String,
}

#[derive(Clone, Debug, Deserialize)]
struct PalmchatScratchPointerSlotEntry {
    slot_offset: String,
    alloc_size: String,
    #[serde(default)]
    seed_path: Option<PathBuf>,
    #[serde(default)]
    seed_offset: Option<String>,
    #[serde(default)]
    pointer_rebases: Vec<PalmchatPointerRebaseEntry>,
}

impl SharedState {
    fn new(trace_dir: &Path) -> Result<Self> {
        fs::create_dir_all(trace_dir)
            .with_context(|| format!("failed to create trace dir: {}", trace_dir.display()))?;
        let jni_log = File::create(trace_dir.join("palmchat_jni.log"))
            .with_context(|| format!("failed to create jni log under {}", trace_dir.display()))?;
        let native_log =
            File::create(trace_dir.join("palmchat_native.log")).with_context(|| {
                format!("failed to create native log under {}", trace_dir.display())
            })?;
        Ok(Self {
            jni_log,
            native_log,
        })
    }

    fn jni(&mut self, line: &str) {
        let _ = writeln!(self.jni_log, "[{}] {}", iso_now(), line);
        let _ = self.jni_log.flush();
    }

    fn native(&mut self, line: &str) {
        let _ = writeln!(self.native_log, "[{}] {}", iso_now(), line);
        let _ = self.native_log.flush();
    }
}

pub struct PalmchatLab {
    config: PalmchatConfig,
    app_version_info: PalmchatAppVersionInfo,
    live_device_profile: Option<PalmchatLiveDeviceProfile>,
    emulator: AndroidEmulator<'static, ()>,
    encrypt_utils_class: Rc<DvmClass>,
    messaging_service_class: Rc<DvmClass>,
    shared: Rc<RefCell<SharedState>>,
    identity_seed: PalmchatIdentityRuntimeState,
    identity_state: Rc<RefCell<PalmchatIdentityRuntimeState>>,
    app_context_secret_pair: Rc<RefCell<Option<PalmchatSecretPair>>>,
    asset_manager_native_ptr: u64,
    recovered_auth_state: Option<PalmchatRecoveredAuthState>,
    module_base: u64,
    module_size: u64,
}

impl PalmchatLab {
    fn load_with_backend(
        config_path: impl AsRef<Path>,
        backend_override: Option<&str>,
    ) -> Result<Self> {
        let config = PalmchatConfig::load(config_path)?.with_backend_override(backend_override)?;
        Self::load_from_config(config)
    }

    fn load_from_config(config: PalmchatConfig) -> Result<Self> {
        validate_config(&config)?;
        let shared = Rc::new(RefCell::new(SharedState::new(&config.trace_out_dir)?));
        let live_device_profile = discover_live_device_profile(shared.clone());
        let mut identity_seed = PalmchatIdentityRuntimeState::from_config(&config.identity_probe);
        if let Some(profile) = live_device_profile.as_ref() {
            profile.apply_to_identity_seed(&mut identity_seed);
        }
        let identity_state = Rc::new(RefCell::new(identity_seed.clone()));
        let app_context_secret_pair = Rc::new(RefCell::new(None));
        let app_version_info =
            resolve_app_version_info(&config, live_device_profile.as_ref(), shared.clone());
        let app_context_fs = PalmchatAppContextFs::new(&config.trace_out_dir, &config.package_name)?;
        let runtime_base_path = prepare_runtime_base_path(&config, shared.clone())?;
        std::env::set_var("BASE_PATH", &runtime_base_path);
        std::env::set_var(
            "ANDROID_APP_TARGET_SDK",
            config.target_sdk.unwrap_or(config.android_api).to_string(),
        );
        let emulator = AndroidEmulator::create_arm64_with_backend(
            PID,
            PPID,
            &config.package_name,
            (),
            config.backend_kind()?,
        )?;
        let asset_manager_native_ptr = emulator
            .falloc(0x100, false)
            .context("failed to allocate asset manager native handle scratch")?
            .addr;
        shared.borrow_mut().native(&format!(
            "seeded asset manager native ptr addr=0x{:x}",
            asset_manager_native_ptr
        ));
        install_system_properties(&emulator, &config, live_device_profile.as_ref());
        configure_file_system(&emulator, &config, &app_context_fs);

        let vm = emulator.get_dalvik_vm();
        vm.set_class_resolver(build_class_resolver());
        vm.set_jni(Box::new(PalmchatJni::new(
            shared.clone(),
            config.package_name.clone(),
            config.apk_path.clone(),
            app_context_fs.clone(),
            identity_state.clone(),
            live_device_profile.clone(),
            app_context_secret_pair.clone(),
            asset_manager_native_ptr,
        )));
        let run_init_during_load = run_init_during_load();
        shared.borrow_mut().native(&format!(
            "library load init policy run_init_during_load={}",
            run_init_during_load
        ));

        let (_, encrypt_utils_class) = vm
            .resolve_class("com/zenmen/palmchat/utils/EncryptUtils")
            .ok_or_else(|| {
            anyhow!("failed to resolve com/zenmen/palmchat/utils/EncryptUtils")
        })?;
        let (_, messaging_service_class) = vm
            .resolve_class("com/zenmen/palmchat/messaging/MessagingService")
            .ok_or_else(|| {
                anyhow!("failed to resolve com/zenmen/palmchat/messaging/MessagingService")
            })?;
        let _ = vm.resolve_class("org/json/JSONObject");
        let hashkey_fast_global_ref = resolve_fast_hashkey_global_ref(
            vm,
            shared.clone(),
            "PALMCHAT_HASHKEY_FAST",
            config.hash_key_fast.as_deref(),
        );

        if let Some(wksec_so_path) = &config.wksec_so_path {
            let wksec_module = vm
                .load_library(
                    emulator.clone(),
                    wksec_so_path.to_string_lossy().as_ref(),
                    run_init_during_load,
                )
                .with_context(|| format!("failed to load wksec so: {}", wksec_so_path.display()))?;
            let wksec_module = unsafe { &*wksec_module.get() };
            shared.borrow_mut().native(&format!(
                "preloaded wksec so={}, base=0x{:x}, size=0x{:x}",
                wksec_so_path.display(),
                wksec_module.base,
                wksec_module.size
            ));
        }

        let module = vm
            .load_library(
                emulator.clone(),
                config.so_path.to_string_lossy().as_ref(),
                run_init_during_load,
            )
            .with_context(|| format!("failed to load so: {}", config.so_path.display()))?;
        let module = unsafe { &*module.get() };
        install_unicorn_trace_hooks(
            &emulator,
            shared.clone(),
            module.base,
            module.size as u64,
            hashkey_fast_global_ref,
            &config.apk_path,
            asset_manager_native_ptr,
        )?;
        apply_got_seed_manifest(&config, &emulator, shared.clone(), module.base)?;
        apply_runtime_page_patches(&config, &emulator, shared.clone(), module.base)?;
        seed_libc_vdso_time_slots(&emulator, shared.clone())?;
        seed_libc_rng_slots(&emulator, shared.clone(), module.base)?;
        seed_palmchat_runtime_dispatch_slots(&emulator, shared.clone(), module.base)?;
        seed_palmchat_runtime_context_slot(&emulator, shared.clone(), module.base)?;
        scrub_palmchat_runtime_heap_slots(&emulator, shared.clone(), module.base)?;
        seed_palmchat_runtime_pointer_array(&emulator, shared.clone(), module.base)?;
        if let Err(err) = vm.call_jni_onload(emulator.clone(), module) {
            shared
                .borrow_mut()
                .native(&format!("JNI_OnLoad via dynsym failed: {err}"));
            let offset = find_hidden_symbol_value(&config.so_path, "JNI_OnLoad")
                .ok()
                .flatten()
                .or_else(|| known_hidden_symbol_offset("JNI_OnLoad"));
            shared
                .borrow_mut()
                .native(&format!("JNI_OnLoad hidden symbol scan result={offset:?}"));
            if let Some(offset) = offset {
                shared.borrow_mut().native(&format!(
                    "JNI_OnLoad hidden symbol fallback offset=0x{:x} absolute=0x{:x}",
                    offset,
                    module.base + offset
                ));
                if let Err(onload_err) = vm.call_jni_onload_at(
                    emulator.clone(),
                    module.name.as_str(),
                    module.base + offset,
                    Some(offset),
                ) {
                    let err_text = format!("{onload_err:#}");
                    if err_text.contains("version=") {
                        shared.borrow_mut().native(&format!(
                            "JNI_OnLoad hidden symbol fallback non-fatal version mismatch err={}",
                            err_text
                        ));
                    } else {
                        return Err(onload_err)
                            .context("failed to call JNI_OnLoad via hidden symbol fallback");
                    }
                }
            } else {
                return Err(err).context("failed to call JNI_OnLoad: no fallback offset");
            }
        }

        shared.borrow_mut().native(&format!(
            "loaded so={}, base=0x{:x}, size=0x{:x}, backend={}",
            config.so_path.display(),
            module.base,
            module.size,
            emulator.backend.name()
        ));
        Ok(Self {
            config,
            app_version_info,
            live_device_profile,
            emulator,
            encrypt_utils_class,
            messaging_service_class,
            shared,
            identity_seed,
            identity_state,
            app_context_secret_pair,
            asset_manager_native_ptr,
            recovered_auth_state: None,
            module_base: module.base,
            module_size: module.size as u64,
        })
    }

    fn call_static(
        &self,
        method_name: &str,
        signature: &str,
        args: Vec<JniValue>,
    ) -> Result<JniValue> {
        let emulator = self.emulator.clone();
        let vm = emulator.get_dalvik_vm();
        let needs_hidden_bind = vm
            .find_method(self.encrypt_utils_class.id, method_name, signature)
            .map(|method| !method.is_jni_method())
            .unwrap_or(true);
        if needs_hidden_bind
            && !self.bind_hidden_encrypt_utils_method(vm, method_name, signature)?
        {
            let available = vm.list_method_signatures(self.encrypt_utils_class.id);
            return Err(anyhow!(
                "native method not registered: {}{} on {}, available={:?}",
                method_name,
                signature,
                self.encrypt_utils_class.name,
                available
            ));
        }
        Ok(self
            .encrypt_utils_class
            .call_static_method(&emulator, vm, method_name, signature, args))
    }

    fn call_messaging_static(
        &self,
        method_name: &str,
        signature: &str,
        args: Vec<JniValue>,
    ) -> Result<JniValue> {
        let emulator = self.emulator.clone();
        let vm = emulator.get_dalvik_vm();
        let needs_hidden_bind = vm
            .find_method(self.messaging_service_class.id, method_name, signature)
            .map(|method| !method.is_jni_method())
            .unwrap_or(true);
        if needs_hidden_bind
            && !self.bind_hidden_messaging_service_method(vm, method_name, signature)?
        {
            let available = vm.list_method_signatures(self.messaging_service_class.id);
            return Err(anyhow!(
                "native method not registered: {}{} on {}, available={:?}",
                method_name,
                signature,
                self.messaging_service_class.name,
                available
            ));
        }
        Ok(self.messaging_service_class.call_static_method(
            &emulator,
            vm,
            method_name,
            signature,
            args,
        ))
    }

    fn ensure_java_method(
        &self,
        class_name: &str,
        method_name: &str,
        signature: &str,
    ) -> Result<Rc<DvmClass>> {
        let emulator = self.emulator.clone();
        let vm = emulator.get_dalvik_vm();
        let (_, class) = vm
            .resolve_class(class_name)
            .ok_or_else(|| anyhow!("failed to resolve class: {class_name}"))?;
        vm.register_native_method(class.id, method_name, signature, 0)?;
        Ok(class)
    }

    fn call_java_static(
        &self,
        class_name: &str,
        method_name: &str,
        signature: &str,
        args: Vec<JniValue>,
    ) -> Result<JniValue> {
        let emulator = self.emulator.clone();
        let class = self.ensure_java_method(class_name, method_name, signature)?;
        let vm = emulator.get_dalvik_vm();
        Ok(class.call_static_method(&emulator, vm, method_name, signature, args))
    }

    fn call_java_instance(
        &self,
        class_name: &str,
        method_name: &str,
        signature: &str,
        args: Vec<JniValue>,
    ) -> Result<JniValue> {
        let emulator = self.emulator.clone();
        let class = self.ensure_java_method(class_name, method_name, signature)?;
        let vm = emulator.get_dalvik_vm();
        let instance = class.new_simple_instance(vm);
        Ok(instance.call_method(&emulator, vm, method_name, signature, args))
    }

    fn call_java_method_on_object(
        &self,
        class_name: &str,
        object: &DvmObject,
        method_name: &str,
        signature: &str,
        args: Vec<JniValue>,
    ) -> Result<JniValue> {
        let emulator = self.emulator.clone();
        let _ = self.ensure_java_method(class_name, method_name, signature)?;
        let vm = emulator.get_dalvik_vm();
        Ok(object.call_method(&emulator, vm, method_name, signature, args))
    }

    fn try_call_java_static_string(
        &mut self,
        class_name: &str,
        method_name: &str,
        signature: &str,
        args: Vec<JniValue>,
    ) -> Option<String> {
        match self.call_java_static(class_name, method_name, signature, args) {
            Ok(value) => jni_value_to_string(value).ok(),
            Err(err) => {
                self.shared.borrow_mut().jni(&format!(
                    "probe {}->{}{} blocked err={err:#}",
                    class_name, method_name, signature
                ));
                None
            }
        }
    }

    fn try_call_java_static_bool(
        &mut self,
        class_name: &str,
        method_name: &str,
        signature: &str,
        args: Vec<JniValue>,
    ) -> Option<bool> {
        match self.call_java_static(class_name, method_name, signature, args) {
            Ok(value) => jni_value_to_bool(value).ok(),
            Err(err) => {
                self.shared.borrow_mut().jni(&format!(
                    "probe {}->{}{} blocked err={err:#}",
                    class_name, method_name, signature
                ));
                None
            }
        }
    }

    fn app_context_object(&self) -> Result<DvmObject> {
        match self.call_java_static(
            "com/zenmen/palmchat/AppContext",
            "getContext",
            "()Lcom/zenmen/palmchat/AppContext;",
            vec![],
        )? {
            JniValue::Object(object) => Ok(object),
            other => Err(anyhow!(
                "unexpected AppContext.getContext return: {}",
                describe_jni_value(&other)
            )),
        }
    }

    fn make_asset_manager_object(&self) -> Result<DvmObject> {
        let emulator = self.emulator.clone();
        let vm = emulator.get_dalvik_vm();
        let (_, class) = vm
            .resolve_class("android/content/res/AssetManager")
            .ok_or_else(|| anyhow!("failed to resolve android/content/res/AssetManager"))?;
        Ok(new_mut_data_object(
            class,
            self.asset_manager_native_ptr as i64,
        ))
    }

    fn current_app_context_secret_pair(&self) -> Option<PalmchatSecretPair> {
        self.app_context_secret_pair.borrow().clone()
    }

    fn app_context_secret_present(&self) -> bool {
        self.current_app_context_secret_pair()
            .map(|pair| !pair.key.is_empty() && !pair.iv.is_empty())
            .unwrap_or(false)
    }

    fn set_app_context_secret_pair(&self, pair: Option<PalmchatSecretPair>) {
        *self.app_context_secret_pair.borrow_mut() = pair;
    }

    fn sync_app_context_secret_pair(&self, pair: PalmchatSecretPair, scope: &str) {
        self.set_app_context_secret_pair(Some(pair.clone()));
        self.shared.borrow_mut().native(&format!(
            "{scope} app_context_secret_pair synced key_len={} iv_len={}",
            pair.key.len(),
            pair.iv.len()
        ));
    }

    fn decrypt_persisted_app_string(&self, value: &str) -> Option<String> {
        let raw = normalize_plain_candidate(Some(value.to_string()))?;
        let decoded = hex::decode(raw).ok()?;
        let output = self
            .call_static(
                "cipherWithType",
                "([BIZ)[B",
                vec![
                    JniValue::Object(DvmObject::ByteArray(decoded)),
                    7.into(),
                    true.into(),
                ],
            )
            .ok()
            .and_then(|value| jni_value_to_bytes(value).ok())?;
        normalize_plain_candidate(Some(String::from_utf8_lossy(&output).to_string()))
    }

    fn account_utils_string(&mut self, method_name: &str) -> Option<String> {
        let app_context = self.app_context_object().ok()?;
        self.try_call_java_static_string(
            "com/zenmen/palmchat/account/AccountUtils",
            method_name,
            "(Landroid/content/Context;)Ljava/lang/String;",
            vec![app_context.into()],
        )
        .and_then(|value| normalize_plain_candidate(Some(value)))
    }

    fn compose_refresh_server_key_query_did(&self) -> String {
        let state = self.identity_state.borrow();
        format!(
            "{}_{}_{}",
            state.effective_imei(),
            "",
            state.effective_android_id()
        )
    }

    fn messaging_service_secret_pair(&self) -> Option<PalmchatSecretPair> {
        let value = self
            .call_messaging_static("getSecretKeys", "()Landroid/util/Pair;", vec![])
            .ok()?;
        jni_value_to_secret_pair(value)
    }

    fn log_secret_slot_snapshot(&self, scope: &str) {
        const GET_SECRET_KEYS_SLOT_OFFSET: u64 = 0x187ae0;
        const SKEY_FLAG_SLOT_OFFSET: u64 = 0x187ae8;
        const CREATE_CKEY_STATE_SLOT_OFFSET: u64 = 0x187af0;

        let pair_slot_addr = self.module_base + GET_SECRET_KEYS_SLOT_OFFSET;
        let skey_flag_slot_addr = self.module_base + SKEY_FLAG_SLOT_OFFSET;
        let create_state_slot_addr = self.module_base + CREATE_CKEY_STATE_SLOT_OFFSET;

        let pair_slot_value = read_u64_slot(&self.emulator, pair_slot_addr);
        let skey_flag_slot_value = read_u64_slot(&self.emulator, skey_flag_slot_addr);
        let create_state_slot_value = read_u64_slot(&self.emulator, create_state_slot_addr);
        let read_head = |ptr| {
            if !pointer_range_readable(&self.emulator, ptr, 0x80) {
                return "unreadable".to_string();
            }
            self.emulator
                .backend
                .mem_read_as_vec(ptr, 0x80)
                .ok()
                .map(hex::encode)
                .unwrap_or_else(|| "unreadable".to_string())
        };
        self.shared.borrow_mut().native(&format!(
            "{scope} secret_slot_snapshot pair_slot=0x{:x} skey_flag_slot=0x{:x} create_state_slot=0x{:x} skey_head={} create_state_head={}",
            pair_slot_value,
            skey_flag_slot_value,
            create_state_slot_value,
            read_head(skey_flag_slot_value),
            read_head(create_state_slot_value)
        ));
    }

    fn secret_candidate_preview(value: &str) -> String {
        if value.len() <= 8 {
            return value.to_string();
        }
        format!("{}...{}", &value[..4], &value[value.len() - 4..])
    }

    fn is_secret_ascii_candidate_byte(byte: u8) -> bool {
        byte.is_ascii_alphanumeric() || matches!(byte, b'+' | b'/' | b'=' | b'_' | b'-')
    }

    fn scan_secret_string_candidates_in_buffer(
        &self,
        base_addr: u64,
        bytes: &[u8],
        source: &str,
        seen: &mut HashSet<String>,
        out: &mut Vec<PalmchatSecretStringCandidate>,
    ) {
        if bytes.len() < 16 {
            return;
        }
        for offset in 0..=bytes.len() - 16 {
            let window = &bytes[offset..offset + 16];
            if !window
                .iter()
                .copied()
                .all(Self::is_secret_ascii_candidate_byte)
            {
                continue;
            }
            let value = String::from_utf8_lossy(window).into_owned();
            if !seen.insert(value.clone()) {
                continue;
            }
            out.push(PalmchatSecretStringCandidate {
                value,
                source: source.to_string(),
                addr: base_addr + offset as u64,
                offset,
            });
        }
    }

    fn collect_refresh_secret_state_candidates(
        &self,
        state_ptr: u64,
        scope: &str,
    ) -> Vec<PalmchatSecretStringCandidate> {
        let mut seen = HashSet::new();
        let mut out = Vec::new();
        let Some(state_head) = self.emulator.backend.mem_read_as_vec(state_ptr, 0x100).ok() else {
            self.shared.borrow_mut().native(&format!(
                "{scope} auth_bootstrap refresh_state_scan skipped reason=state_unreadable ptr=0x{state_ptr:x}"
            ));
            return out;
        };
        self.scan_secret_string_candidates_in_buffer(
            state_ptr,
            &state_head,
            "create_state",
            &mut seen,
            &mut out,
        );
        let mut pointed_regions = Vec::new();
        for offset in (0..state_head.len().saturating_sub(8) + 1).step_by(8) {
            let ptr = u64::from_le_bytes(state_head[offset..offset + 8].try_into().unwrap());
            if ptr == 0 || ptr == state_ptr {
                continue;
            }
            if pointed_regions.iter().any(|existing| *existing == ptr) {
                continue;
            }
            pointed_regions.push(ptr);
            match self.emulator.backend.mem_read_as_vec(ptr, 0x100) {
                Ok(pointed_head) => {
                    let head_hex = hex::encode(
                        pointed_head
                            .get(..pointed_head.len().min(0x40))
                            .unwrap_or_default(),
                    );
                    self.shared.borrow_mut().native(&format!(
                        "{scope} auth_bootstrap refresh_state_scan ptr_slot=0x{offset:x} target=0x{ptr:x} head={head_hex}"
                    ));
                    self.scan_secret_string_candidates_in_buffer(
                        ptr,
                        &pointed_head,
                        &format!("create_state_ptr+0x{offset:x}"),
                        &mut seen,
                        &mut out,
                    );
                    let printable = read_c_string_lossy(&self.emulator, ptr, 0x80)
                        .filter(|value| value.len() >= 16)
                        .map(|value| value.chars().take(16).collect::<String>());
                    if let Some(value) = printable {
                        if seen.insert(value.clone()) {
                            out.push(PalmchatSecretStringCandidate {
                                value,
                                source: format!("create_state_cstr+0x{offset:x}"),
                                addr: ptr,
                                offset: 0,
                            });
                        }
                    }
                }
                Err(_) => {
                    self.shared.borrow_mut().native(&format!(
                        "{scope} auth_bootstrap refresh_state_scan ptr_slot=0x{offset:x} target=0x{ptr:x} unreadable"
                    ));
                }
            }
        }
        let candidate_summary = out
            .iter()
            .map(|candidate| {
                format!(
                    "{}@0x{:x}+0x{:x}:{}",
                    candidate.source,
                    candidate.addr,
                    candidate.offset,
                    Self::secret_candidate_preview(&candidate.value)
                )
            })
            .collect::<Vec<_>>()
            .join(", ");
        self.shared.borrow_mut().native(&format!(
            "{scope} auth_bootstrap refresh_state_scan ptr=0x{state_ptr:x} candidate_count={} candidates=[{}]",
            out.len(),
            candidate_summary
        ));
        out
    }

    fn try_recover_secret_pair_from_refresh_state(
        &mut self,
        uid: &str,
        scope: &str,
        extra_candidates: &[String],
    ) -> Result<Option<String>> {
        const CREATE_CKEY_STATE_SLOT_OFFSET: u64 = 0x187af0;
        let state_ptr = read_u64_slot(
            &self.emulator,
            self.module_base + CREATE_CKEY_STATE_SLOT_OFFSET,
        );
        if state_ptr == 0 {
            self.shared.borrow_mut().native(&format!(
                "{scope} auth_bootstrap refresh_state_oracle skipped reason=create_state_empty"
            ));
            return Ok(None);
        }
        let mut candidates = self.collect_refresh_secret_state_candidates(state_ptr, scope);
        let mut seen = candidates
            .iter()
            .map(|candidate| candidate.value.clone())
            .collect::<HashSet<_>>();
        for (index, value) in extra_candidates.iter().enumerate() {
            if value.len() < 16 || !seen.insert(value.clone()) {
                continue;
            }
            candidates.push(PalmchatSecretStringCandidate {
                value: value.clone(),
                source: format!("extra_{index}"),
                addr: 0,
                offset: 0,
            });
        }
        if candidates.is_empty() {
            self.shared.borrow_mut().native(&format!(
                "{scope} auth_bootstrap refresh_state_oracle skipped reason=no_candidates"
            ));
            return Ok(None);
        }

        let mut key_candidates = candidates.clone();
        key_candidates.sort_by_key(|candidate| {
            (
                candidate.source != "create_state",
                candidate.offset,
                candidate.addr,
            )
        });
        let mut iv_candidates = candidates;
        iv_candidates.sort_by_key(|candidate| {
            (
                candidate.source == "create_state" && candidate.offset == 0,
                candidate.source == "create_state",
                candidate.offset,
                candidate.addr,
            )
        });

        let max_key_candidates = key_candidates.len().min(4);
        let max_iv_candidates = iv_candidates.len().min(12);
        let mut attempt = 0usize;
        for key_candidate in key_candidates.into_iter().take(max_key_candidates) {
            for iv_candidate in iv_candidates.iter().take(max_iv_candidates) {
                if key_candidate.value == iv_candidate.value {
                    continue;
                }
                attempt += 1;
                self.shared.borrow_mut().native(&format!(
                    "{scope} auth_bootstrap refresh_state_oracle try idx={} key={} iv={} key_src={} iv_src={}",
                    attempt,
                    Self::secret_candidate_preview(&key_candidate.value),
                    Self::secret_candidate_preview(&iv_candidate.value),
                    key_candidate.source,
                    iv_candidate.source
                ));
                if let Err(err) = self.call_messaging_static(
                    "setSecretKeys",
                    "(Ljava/lang/String;Ljava/lang/String;)V",
                    vec![
                        key_candidate.value.clone().into(),
                        iv_candidate.value.clone().into(),
                    ],
                ) {
                    self.shared.borrow_mut().native(&format!(
                        "{scope} auth_bootstrap refresh_state_oracle setSecretKeys_failed idx={} err={err:#}",
                        attempt
                    ));
                    continue;
                }
                self.set_app_context_secret_pair(Some(PalmchatSecretPair {
                    key: key_candidate.value.as_bytes().to_vec(),
                    iv: iv_candidate.value.as_bytes().to_vec(),
                }));
                let token = self.generate_smssend_message_token(uid);
                self.shared.borrow_mut().native(&format!(
                    "{scope} auth_bootstrap refresh_state_oracle result idx={} token_present={}",
                    attempt,
                    token.is_some()
                ));
                if token.is_some() {
                    self.log_secret_slot_snapshot(&format!(
                        "{scope} auth_bootstrap refresh_state_oracle"
                    ));
                    return Ok(token);
                }
            }
        }
        Ok(None)
    }

    fn promote_refresh_secret_state_to_skey_flag_if_needed(&self, scope: &str) -> Result<bool> {
        const GET_SECRET_KEYS_SLOT_OFFSET: u64 = 0x187ae0;
        const SKEY_FLAG_SLOT_OFFSET: u64 = 0x187ae8;
        const CREATE_CKEY_STATE_SLOT_OFFSET: u64 = 0x187af0;

        let pair_slot_addr = self.module_base + GET_SECRET_KEYS_SLOT_OFFSET;
        let skey_flag_slot_addr = self.module_base + SKEY_FLAG_SLOT_OFFSET;
        let create_state_slot_addr = self.module_base + CREATE_CKEY_STATE_SLOT_OFFSET;

        let pair_slot_value = read_u64_slot(&self.emulator, pair_slot_addr);
        let skey_flag_slot_value = read_u64_slot(&self.emulator, skey_flag_slot_addr);
        let create_state_slot_value = read_u64_slot(&self.emulator, create_state_slot_addr);

        if skey_flag_slot_value != 0 {
            self.shared.borrow_mut().native(&format!(
                "{scope} auth_bootstrap skey_flag promotion skipped reason=already_populated pair_slot=0x{:x} skey_flag_slot=0x{:x} create_state_slot=0x{:x}",
                pair_slot_value,
                skey_flag_slot_value,
                create_state_slot_value
            ));
            return Ok(false);
        }
        if create_state_slot_value == 0 {
            self.shared.borrow_mut().native(&format!(
                "{scope} auth_bootstrap skey_flag promotion skipped reason=create_state_empty pair_slot=0x{:x}",
                pair_slot_value
            ));
            return Ok(false);
        }
        if !pointer_range_readable(&self.emulator, create_state_slot_value, 0x10) {
            self.shared.borrow_mut().native(&format!(
                "{scope} auth_bootstrap skey_flag promotion skipped reason=create_state_unreadable pair_slot=0x{:x} create_state_slot=0x{:x}",
                pair_slot_value,
                create_state_slot_value
            ));
            return Ok(false);
        }

        let state_head = self
            .emulator
            .backend
            .mem_read_as_vec(create_state_slot_value, 0x20)
            .ok()
            .map(hex::encode)
            .unwrap_or_else(|| "unreadable".to_string());
        self.emulator
            .backend
            .mem_write(skey_flag_slot_addr, &create_state_slot_value.to_le_bytes())
            .with_context(|| {
                format!(
                    "failed to promote create_state slot into skey_flag slot 0x{skey_flag_slot_addr:x}"
                )
            })?;
        let readback = read_u64_slot(&self.emulator, skey_flag_slot_addr);
        self.shared.borrow_mut().native(&format!(
            "{scope} auth_bootstrap skey_flag promoted pair_slot=0x{:x} create_state_slot=0x{:x} state_head={} readback=0x{:x}",
            pair_slot_value,
            create_state_slot_value,
            state_head,
            readback
        ));
        Ok(readback == create_state_slot_value)
    }

    fn make_string_array(&self, values: &[&str]) -> Result<DvmObject> {
        let emulator = self.emulator.clone();
        let vm = emulator.get_dalvik_vm();
        let (_, string_class) = vm
            .resolve_class("java/lang/String")
            .ok_or_else(|| anyhow!("failed to resolve java/lang/String"))?;
        Ok(DvmObject::ObjectArray(
            string_class,
            values
                .iter()
                .map(|value| Some(DvmObject::String((*value).to_string())))
                .collect(),
        ))
    }

    fn reset_identity_probe_state(&mut self, opts: &HashMap<String, String>) {
        let mut state = self.identity_seed.clone();
        if let Some(profile) = self.live_device_profile.as_ref() {
            profile.apply_to_identity_seed(&mut state);
        }
        if let Some(value) = opts.get("--privacy-agree") {
            state.privacy_agree = Some(parse_bool_like(value));
        }
        if let Some(value) = opts.get("--read-phone-state") {
            state.read_phone_state_granted = Some(parse_bool_like(value));
        }
        if let Some(value) = opts.get("--priv-info-init") {
            state.priv_info_initialized = parse_bool_like(value);
        }
        if let Some(value) = opts.get("--android-id") {
            state.android_id = value.clone();
        }
        if let Some(value) = opts.get("--imei") {
            state.imei = value.clone();
        }
        if let Some(value) = opts.get("--mac") {
            state.mac = value.clone();
        }
        if let Some(value) = opts.get("--seed-sdid") {
            state.sdid = value.clone();
        }
        if let Some(value) = opts.get("--seed-local-smid") {
            state.local_smid = value.clone();
        }
        if let Some(value) = opts.get("--seed-device-label") {
            state.device_label = value.clone();
        }
        if let Some(value) = opts.get("--process-name") {
            state.process_name = value.clone();
        }
        *self.identity_state.borrow_mut() = state;
    }

    fn sync_identity_state_from_effective_body(
        &mut self,
        value: &Value,
        opts: &HashMap<String, String>,
    ) {
        let mut state = self.identity_state.borrow().clone();
        let events = if let Some(profile) = self.live_device_profile.as_ref() {
            profile.update_identity_state_from_effective_body(&mut state, value, opts)
        } else {
            PalmchatLiveDeviceProfile::default()
                .update_identity_state_from_effective_body(&mut state, value, opts)
        };
        *self.identity_state.borrow_mut() = state;
        if !events.is_empty() {
            self.shared.borrow_mut().native(&format!(
                "identity_state synchronized from effective_body changes=[{}]",
                events.join(", ")
            ));
        }
    }

    fn bind_hidden_encrypt_utils_method(
        &self,
        vm: &mut DalvikVM64<()>,
        method_name: &str,
        signature: &str,
    ) -> Result<bool> {
        let Some(symbol_name) = hidden_encrypt_utils_symbol_name(method_name) else {
            return Ok(false);
        };
        let offset = match find_hidden_symbol_value(&self.config.so_path, symbol_name) {
            Ok(value) => value,
            Err(err) => {
                self.shared.borrow_mut().native(&format!(
                    "hidden symbol scan failed symbol={} path={} err={err:#}",
                    symbol_name,
                    self.config.so_path.display()
                ));
                None
            }
        }
        .or_else(|| known_hidden_symbol_offset(symbol_name));
        let Some(offset) = offset else {
            self.shared.borrow_mut().native(&format!(
                "hidden native bind skipped method={}{} symbol={} reason=offset-not-found",
                method_name, signature, symbol_name
            ));
            return Ok(false);
        };
        let fn_ptr = self.module_base + offset;
        vm.register_native_method(
            self.encrypt_utils_class.id,
            method_name.to_string(),
            signature.to_string(),
            fn_ptr,
        )?;
        let fn_head_hex = self
            .emulator
            .backend
            .mem_read_as_vec(fn_ptr, 16)
            .ok()
            .map(hex::encode)
            .unwrap_or_default();
        self.shared.borrow_mut().native(&format!(
            "hidden native bound method={}{} symbol={} offset=0x{:x} absolute=0x{:x} head16={}",
            method_name, signature, symbol_name, offset, fn_ptr, fn_head_hex
        ));
        Ok(true)
    }

    fn bind_hidden_messaging_service_method(
        &self,
        vm: &mut DalvikVM64<()>,
        method_name: &str,
        signature: &str,
    ) -> Result<bool> {
        let Some(symbol_name) = hidden_messaging_service_symbol_name(method_name) else {
            return Ok(false);
        };
        let offset = match find_hidden_symbol_value(&self.config.so_path, symbol_name) {
            Ok(value) => value,
            Err(err) => {
                self.shared.borrow_mut().native(&format!(
                    "hidden symbol scan failed symbol={} path={} err={err:#}",
                    symbol_name,
                    self.config.so_path.display()
                ));
                None
            }
        }
        .or_else(|| known_hidden_symbol_offset(symbol_name));
        let Some(offset) = offset else {
            self.shared.borrow_mut().native(&format!(
                "hidden native bind skipped method={}{} symbol={} reason=offset-not-found",
                method_name, signature, symbol_name
            ));
            return Ok(false);
        };
        let fn_ptr = self.module_base + offset;
        vm.register_native_method(
            self.messaging_service_class.id,
            method_name,
            signature,
            fn_ptr,
        )
        .with_context(|| {
            format!(
                "failed to register hidden native method: {}{} symbol={} fn_ptr=0x{:x}",
                method_name, signature, symbol_name, fn_ptr
            )
        })?;
        let fn_head_hex = self
            .emulator
            .backend
            .mem_read_as_vec(fn_ptr, 16)
            .ok()
            .map(hex::encode)
            .unwrap_or_default();
        self.shared.borrow_mut().native(&format!(
            "hidden native bound method={}{} symbol={} offset=0x{:x} absolute=0x{:x} head16={}",
            method_name, signature, symbol_name, offset, fn_ptr, fn_head_hex
        ));
        Ok(true)
    }

    fn bind_hidden_create_connection_delegate_method(
        &self,
        vm: &mut DalvikVM64<()>,
        class_id: i64,
        method_name: &str,
        signature: &str,
    ) -> Result<bool> {
        let Some(symbol_name) = hidden_create_connection_delegate_symbol_name(method_name) else {
            return Ok(false);
        };
        let offset = match find_hidden_symbol_value(&self.config.so_path, symbol_name) {
            Ok(value) => value,
            Err(err) => {
                self.shared.borrow_mut().native(&format!(
                    "hidden symbol scan failed symbol={} path={} err={err:#}",
                    symbol_name,
                    self.config.so_path.display()
                ));
                None
            }
        }
        .or_else(|| {
            self.config
                .hidden_symbol_offsets
                .get(symbol_name)
                .and_then(|value| parse_u64ish(value).ok())
        })
        .or_else(|| known_hidden_symbol_offset(symbol_name));
        let Some(offset) = offset else {
            self.shared.borrow_mut().native(&format!(
                "hidden native bind skipped method={}{} symbol={} reason=offset-not-found",
                method_name, signature, symbol_name
            ));
            return Ok(false);
        };
        let fn_ptr = self.module_base + offset;
        vm.register_native_method(class_id, method_name, signature, fn_ptr)
            .with_context(|| {
                format!(
                    "failed to register hidden native method: {}{} symbol={} fn_ptr=0x{:x}",
                    method_name, signature, symbol_name, fn_ptr
                )
            })?;
        let fn_head_hex = self
            .emulator
            .backend
            .mem_read_as_vec(fn_ptr, 16)
            .ok()
            .map(hex::encode)
            .unwrap_or_default();
        self.shared.borrow_mut().native(&format!(
            "hidden native bound method={}{} symbol={} offset=0x{:x} absolute=0x{:x} head16={}",
            method_name, signature, symbol_name, offset, fn_ptr, fn_head_hex
        ));
        Ok(true)
    }

    fn call_create_connection_delegate_refresh_server_key(
        &self,
        session_id: &str,
        refresh_key: &str,
        did: &str,
        ck_version: &str,
        double_key_1: Option<&str>,
        double_key_2: Option<&str>,
        url: &str,
        use_new_key: bool,
    ) -> Result<JniValue> {
        const CLASS_NAME: &str = "com/zenmen/palmchat/messaging/CreateConnectionDelegate";
        const METHOD_NAME: &str = "refreshServerKey";
        const SIGNATURE: &str = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/res/AssetManager;Ljava/lang/String;Z)Lorg/json/JSONObject;";
        let emulator = self.emulator.clone();
        let vm = emulator.get_dalvik_vm();
        let (_, class) = vm
            .resolve_class(CLASS_NAME)
            .ok_or_else(|| anyhow!("failed to resolve {CLASS_NAME}"))?;
        let needs_hidden_bind = vm
            .find_method(class.id, METHOD_NAME, SIGNATURE)
            .map(|method| !method.is_jni_method())
            .unwrap_or(true);
        if needs_hidden_bind
            && !self.bind_hidden_create_connection_delegate_method(
                vm,
                class.id,
                METHOD_NAME,
                SIGNATURE,
            )?
        {
            let available = vm.list_method_signatures(class.id);
            return Err(anyhow!(
                "native method not registered: {}{} on {}, available={:?}",
                METHOD_NAME,
                SIGNATURE,
                class.name,
                available
            ));
        }
        let asset_manager = self.make_asset_manager_object()?;
        let instance = class.new_simple_instance(vm);
        Ok(instance.call_method(
            &emulator,
            vm,
            METHOD_NAME,
            SIGNATURE,
            vec![
                session_id.to_string().into(),
                refresh_key.to_string().into(),
                did.to_string().into(),
                ck_version.to_string().into(),
                double_key_1
                    .map(|value| value.to_string().into())
                    .unwrap_or(JniValue::Null),
                double_key_2
                    .map(|value| value.to_string().into())
                    .unwrap_or(JniValue::Null),
                asset_manager.into(),
                url.to_string().into(),
                use_new_key.into(),
            ],
        ))
    }

    fn call_create_connection_delegate_refresh_wrapper(
        &self,
        uid: &str,
        session_id: &str,
        refresh_key: &str,
    ) -> Result<JniValue> {
        const CLASS_NAME: &str = "com/zenmen/palmchat/messaging/CreateConnectionDelegate";
        const WRAPPER_METHOD: &str = "e";
        const WRAPPER_SIGNATURE: &str =
            "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V";
        const REFRESH_METHOD: &str = "refreshServerKey";
        const REFRESH_SIGNATURE: &str = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/res/AssetManager;Ljava/lang/String;Z)Lorg/json/JSONObject;";
        let emulator = self.emulator.clone();
        let vm = emulator.get_dalvik_vm();
        let (_, class) = vm
            .resolve_class(CLASS_NAME)
            .ok_or_else(|| anyhow!("failed to resolve {CLASS_NAME}"))?;
        let needs_hidden_bind = vm
            .find_method(class.id, REFRESH_METHOD, REFRESH_SIGNATURE)
            .map(|method| !method.is_jni_method())
            .unwrap_or(true);
        if needs_hidden_bind
            && !self.bind_hidden_create_connection_delegate_method(
                vm,
                class.id,
                REFRESH_METHOD,
                REFRESH_SIGNATURE,
            )?
        {
            let available = vm.list_method_signatures(class.id);
            return Err(anyhow!(
                "native method not registered: {}{} on {}, available={:?}",
                REFRESH_METHOD,
                REFRESH_SIGNATURE,
                class.name,
                available
            ));
        }
        self.call_java_instance(
            CLASS_NAME,
            WRAPPER_METHOD,
            WRAPPER_SIGNATURE,
            vec![
                uid.to_string().into(),
                session_id.to_string().into(),
                refresh_key.to_string().into(),
            ],
        )
    }

    fn make_json_object(&self, raw: &str) -> Result<DvmObject> {
        let emulator = self.emulator.clone();
        let vm = emulator.get_dalvik_vm();
        let (_, json_class) = vm
            .resolve_class("org/json/JSONObject")
            .ok_or_else(|| anyhow!("failed to resolve org/json/JSONObject"))?;
        Ok(new_mut_data_object(
            json_class,
            JsonObjectState::from_raw(raw),
        ))
    }

    fn run_smoke(&mut self) -> Result<Value> {
        let available = self.call_static("skeyAvailable", "()Z", vec![])?;
        let version = self.call_static("getCkVersion", "()Ljava/lang/String;", vec![])?;
        Ok(json!({
            "status": "ok",
            "package": self.config.package_name,
            "requested_backend": self.config.backend,
            "active_backend": self.emulator.backend.name(),
            "module_base": format!("0x{:x}", self.module_base),
            "module_size": format!("0x{:x}", self.module_size),
            "skey_available": jni_value_to_bool(available)?,
            "ck_version": jni_value_to_string(version)?,
            "trace_out_dir": self.config.trace_out_dir,
        }))
    }

    fn run_ckdiag(&mut self, raw: Option<&str>) -> Result<Value> {
        const CKDIAG_STATE_SLOTS: &[(&str, u64)] = &[
            // Derived from runtime JNI reader stubs:
            // getCkVersion  -> adrp x8, ... ; ldr x0, [x8, #0xa08]
            // skeyAvailable -> adrp x8, ... ; ldr x8, [x8, #0xae8]
            ("ck_version_slot", 0x187a08),
            ("skey_flag_slot", 0x187ae8),
            ("create_ckey_state", 0x187af0),
            ("runtime_context_slot", 0x1897b0),
        ];

        self.shared.borrow_mut().native("ckdiag step=start");

        let slot_snapshot = |emulator: &AndroidEmulator<'static, ()>, module_base: u64| -> Value {
            let mut obj = Map::new();
            for (label, offset) in CKDIAG_STATE_SLOTS {
                let addr = module_base + offset;
                let value = read_u64_slot(emulator, addr);
                obj.insert(
                    (*label).to_string(),
                    json!({
                        "offset": format!("0x{:x}", offset),
                        "addr": format!("0x{:x}", addr),
                        "value": format!("0x{:x}", value),
                    }),
                );
            }
            Value::Object(obj)
        };

        let before_skey = self.call_static("skeyAvailable", "()Z", vec![])?;
        let before_ck = self.call_static("getCkVersion", "()Ljava/lang/String;", vec![])?;
        let before_ck_debug = describe_jni_value(&before_ck);
        let before_ck_string = jni_value_to_string(before_ck)?;
        let slots_before = slot_snapshot(&self.emulator, self.module_base);

        let set_lx_data = if let Some(raw) = raw {
            self.shared
                .borrow_mut()
                .native("ckdiag step=setLxData start");
            let json_obj = self.make_json_object(raw)?;
            let value = self.call_static(
                "setLxData",
                "(Lorg/json/JSONObject;)V",
                vec![json_obj.into()],
            )?;
            let return_debug = describe_jni_value(&value);
            self.shared.borrow_mut().native(&format!(
                "ckdiag step=setLxData done raw_len={} return_debug={}",
                raw.len(),
                return_debug
            ));
            Some(json!({
                "raw": serde_json::from_str::<Value>(raw).unwrap_or(Value::String(raw.to_string())),
                "return_debug": return_debug,
            }))
        } else {
            None
        };

        self.shared
            .borrow_mut()
            .native("ckdiag step=createCKey start");
        let create_value = self.call_static("createCKey", "()V", vec![])?;
        let create_debug = describe_jni_value(&create_value);
        self.shared
            .borrow_mut()
            .native("ckdiag step=createCKey done");

        let mut encrypted_ckey = Map::new();
        for use_new_key in [false, true] {
            self.shared.borrow_mut().native(&format!(
                "ckdiag step=getEncryptedCKey start use_new_key={use_new_key}"
            ));
            let value = self.call_static("getEncryptedCKey", "(Z)[B", vec![use_new_key.into()])?;
            let return_debug = describe_jni_value(&value);
            let decode = {
                let emulator = self.emulator.clone();
                let vm = emulator.get_dalvik_vm();
                jni_value_to_bytes_with_vm(vm, value)
            };
            let key = if use_new_key { "true" } else { "false" };
            match decode {
                Ok(bytes) => {
                    self.shared.borrow_mut().native(&format!(
                        "ckdiag step=getEncryptedCKey done use_new_key={use_new_key} bytes_len={}",
                        bytes.len()
                    ));
                    encrypted_ckey.insert(
                        key.to_string(),
                        json!({
                            "return_debug": return_debug,
                            "bytes_len": bytes.len(),
                            "output_hex": hex::encode(&bytes),
                        }),
                    );
                }
                Err(err) => {
                    self.shared.borrow_mut().native(&format!(
                        "ckdiag step=getEncryptedCKey done use_new_key={use_new_key} decode_error={err:#}"
                    ));
                    encrypted_ckey.insert(
                        key.to_string(),
                        json!({
                            "return_debug": return_debug,
                            "decode_error": err.to_string(),
                        }),
                    );
                }
            }
        }

        let after_skey = self.call_static("skeyAvailable", "()Z", vec![])?;
        let after_ck = self.call_static("getCkVersion", "()Ljava/lang/String;", vec![])?;
        let after_ck_debug = describe_jni_value(&after_ck);
        let after_ck_string = jni_value_to_string(after_ck)?;
        let before_skey_bool = jni_value_to_bool(before_skey)?;
        let after_skey_bool = jni_value_to_bool(after_skey)?;
        let slots_after = slot_snapshot(&self.emulator, self.module_base);

        self.shared.borrow_mut().native(&format!(
            "ckdiag result before_skey={} before_ck_debug={} before_ck_len={} after_skey={} after_ck_debug={} after_ck_len={} slots_before={} slots_after={}",
            before_skey_bool,
            before_ck_debug,
            before_ck_string.len(),
            after_skey_bool,
            after_ck_debug,
            after_ck_string.len(),
            slots_before,
            slots_after,
        ));

        Ok(json!({
            "status": "ok",
            "method": "ckDiag",
            "requested_backend": self.config.backend,
            "active_backend": self.emulator.backend.name(),
            "native_log": self.config.trace_out_dir.join("palmchat_native.log"),
            "jni_log": self.config.trace_out_dir.join("palmchat_jni.log"),
            "before": {
                "skey_available": before_skey_bool,
                "ck_version": before_ck_string,
                "ck_version_debug": before_ck_debug,
                "slots": slots_before,
            },
            "create_ckey": {
                "return_debug": create_debug,
            },
            "encrypted_ckey": encrypted_ckey,
            "set_lx_data": set_lx_data,
            "after": {
                "skey_available": after_skey_bool,
                "ck_version": after_ck_string,
                "ck_version_debug": after_ck_debug,
                "slots": slots_after,
            },
        }))
    }

    fn capture_app_init_upstream_observation(&mut self) -> Result<Value> {
        let app_context = self.app_context_object()?;
        let package_name = self.config.package_name.clone();
        let process_name = jni_value_to_string(self.call_java_static(
            "defpackage/k86",
            "m",
            "(Landroid/content/Context;)Ljava/lang/String;",
            vec![app_context.clone().into()],
        )?)?;
        let process_name_empty = process_name.trim().is_empty();
        let main_process_gate = app_init_main_process_gate(&package_name, &process_name);

        let before_state = self.identity_state.borrow().clone();
        let before_android_id = jni_value_to_string(self.call_java_instance(
            "com/zenmen/palmchat/privinfo/PrivInfoManager",
            "getAndroidID",
            "()Ljava/lang/String;",
            vec![],
        )?)?;
        let before_imei = jni_value_to_string(self.call_java_instance(
            "com/zenmen/palmchat/privinfo/PrivInfoManager",
            "getIMEI",
            "()Ljava/lang/String;",
            vec![],
        )?)?;
        let before_mac = jni_value_to_string(self.call_java_instance(
            "com/zenmen/palmchat/privinfo/PrivInfoManager",
            "getMac",
            "()Ljava/lang/String;",
            vec![],
        )?)?;

        let init_called = if main_process_gate {
            let _ = self.call_java_instance(
                "com/zenmen/palmchat/privinfo/PrivInfoManager",
                "init",
                "(Landroid/content/Context;)V",
                vec![app_context.clone().into()],
            )?;
            true
        } else {
            false
        };

        let after_state = self.identity_state.borrow().clone();
        let after_android_id = jni_value_to_string(self.call_java_instance(
            "com/zenmen/palmchat/privinfo/PrivInfoManager",
            "getAndroidID",
            "()Ljava/lang/String;",
            vec![],
        )?)?;
        let after_imei = jni_value_to_string(self.call_java_instance(
            "com/zenmen/palmchat/privinfo/PrivInfoManager",
            "getIMEI",
            "()Ljava/lang/String;",
            vec![],
        )?)?;
        let after_mac = jni_value_to_string(self.call_java_instance(
            "com/zenmen/palmchat/privinfo/PrivInfoManager",
            "getMac",
            "()Ljava/lang/String;",
            vec![],
        )?)?;

        self.shared.borrow_mut().native(&format!(
            "app_init_probe process_name={} package_name={} process_empty={} main_process_gate={} init_called={} before_init={} after_init={}",
            process_name,
            package_name,
            process_name_empty,
            main_process_gate,
            init_called,
            before_state.priv_info_initialized,
            after_state.priv_info_initialized,
        ));

        Ok(json!({
            "status": "ok",
            "anchor_callsite": "/Users/haojiejack/github/drizzle-dumper-rust/artifacts/palmchat_apponly_jadx_20260324_230038/sources/com/zenmen/palmchat/AppContext.java:607",
            "summary": "This observation chain reconstructs the AppContext.processOnCreate gate that decides whether PrivInfoManager.INSTANCE.init(this) executes in the main process branch.",
            "runtime_inputs": {
                "package_name": package_name,
                "process_name": process_name,
                "process_name_empty": process_name_empty,
                "main_process_gate": main_process_gate,
            },
            "priv_info": {
                "before_init": {
                    "is_init": before_state.priv_info_initialized,
                    "android_id": before_android_id,
                    "imei": before_imei,
                    "mac": before_mac,
                },
                "after_init": {
                    "is_init": after_state.priv_info_initialized,
                    "android_id": after_android_id,
                    "imei": after_imei,
                    "mac": after_mac,
                }
            },
            "step_chain": [
                {
                    "order": 1,
                    "node": "AppContext.processOnCreate()",
                    "kind": "anchor",
                    "evidence": "AppContext.java:596"
                },
                {
                    "order": 2,
                    "node": "k86.m(this)",
                    "kind": "process_name_probe",
                    "result": process_name,
                    "evidence": "AppContext.java:600"
                },
                {
                    "order": 3,
                    "node": "TextUtils.isEmpty(strM) || strM.equals(getPackageName())",
                    "kind": "main_process_gate",
                    "result": main_process_gate,
                    "inputs": {
                        "process_name": process_name,
                        "package_name": package_name
                    },
                    "evidence": "AppContext.java:602-605"
                },
                {
                    "order": 4,
                    "node": "PrivInfoManager.INSTANCE.init(this)",
                    "kind": "init_call",
                    "result": init_called,
                    "evidence": "AppContext.java:607"
                },
                {
                    "order": 5,
                    "node": "OAuthApi.onAppCreate()",
                    "kind": "downstream_static",
                    "result": main_process_gate,
                    "evidence": "AppContext.java:608"
                },
                {
                    "order": 6,
                    "node": "initFramework() -> initDeviceInfos(this) -> ts0.o().I(this) -> initVolley() ...",
                    "kind": "downstream_static",
                    "result": main_process_gate,
                    "evidence": "AppContext.java:622-635"
                }
            ]
        }))
    }

    fn run_app_init_probe(&mut self, opts: &HashMap<String, String>) -> Result<Value> {
        self.reset_identity_probe_state(opts);
        self.capture_app_init_upstream_observation()
    }

    fn run_gate_probe(&mut self, opts: &HashMap<String, String>) -> Result<Value> {
        self.reset_identity_probe_state(opts);
        let app_init_upstream_observation = self.capture_app_init_upstream_observation()?;
        let app_context = self.app_context_object()?;

        let wm4_android_id = jni_value_to_string(self.call_java_instance(
            "defpackage/wm4",
            "h",
            "()Ljava/lang/String;",
            vec![],
        )?)?;
        let wm4_imei = jni_value_to_string(self.call_java_instance(
            "defpackage/wm4",
            "k",
            "()Ljava/lang/String;",
            vec![],
        )?)?;
        let wm4_mac = jni_value_to_string(self.call_java_instance(
            "defpackage/wm4",
            "n",
            "()Ljava/lang/String;",
            vec![],
        )?)?;
        let smdu_device_id = self
            .try_call_java_static_string(
                "com/wifi/open/sec/SmDuManager",
                "getDeviceId",
                "()Ljava/lang/String;",
                vec![],
            )
            .unwrap_or_default();
        let smdu_device_label = self
            .try_call_java_static_string(
                "com/wifi/open/sec/SmDuManager",
                "getDuLabel",
                "()Ljava/lang/String;",
                vec![],
            )
            .unwrap_or_default();
        let smid_helper_o = self
            .try_call_java_static_string(
                "com/zenmen/palmchat/utils/SmidHelper",
                "o",
                "()Ljava/lang/String;",
                vec![],
            )
            .unwrap_or_default();
        let ac1_v = self
            .try_call_java_static_string("defpackage/ac1", "v", "()Ljava/lang/String;", vec![])
            .unwrap_or_default();

        let privacy_gate =
            jni_value_to_bool(self.call_java_static("defpackage/r75", "l", "()Z", vec![])?)?;
        let read_phone_permissions =
            self.make_string_array(&["android.permission.READ_PHONE_STATE"])?;
        let phone_gate = jni_value_to_bool(self.call_java_static(
            "defpackage/tg4",
            "b",
            "(Landroid/content/Context;[Ljava/lang/String;)Z",
            vec![app_context.clone().into(), read_phone_permissions.into()],
        )?)?;

        let before_priv = app_init_upstream_observation
            .get("priv_info")
            .and_then(|v| v.get("before_init"))
            .cloned()
            .unwrap_or_else(|| json!({}));
        let after_priv = app_init_upstream_observation
            .get("priv_info")
            .and_then(|v| v.get("after_init"))
            .cloned()
            .unwrap_or_else(|| json!({}));
        let runtime_state = self.identity_state.borrow().clone();
        self.shared.borrow_mut().native(&format!(
            "gate_probe privacy_agree={} read_phone_state={} before_init={} after_init={} before_android_id={} after_android_id={} after_imei_len={} after_mac_len={}",
            privacy_gate,
            phone_gate,
            before_priv.get("is_init").and_then(Value::as_bool).unwrap_or(false),
            after_priv.get("is_init").and_then(Value::as_bool).unwrap_or(false),
            before_priv.get("android_id").and_then(Value::as_str).unwrap_or(""),
            after_priv.get("android_id").and_then(Value::as_str).unwrap_or(""),
            after_priv.get("imei").and_then(Value::as_str).unwrap_or("").len(),
            after_priv.get("mac").and_then(Value::as_str).unwrap_or("").len(),
        ));

        Ok(json!({
            "status": "ok",
            "method": "gateProbe",
            "requested_backend": self.config.backend,
            "active_backend": self.emulator.backend.name(),
            "native_log": self.config.trace_out_dir.join("palmchat_native.log"),
            "jni_log": self.config.trace_out_dir.join("palmchat_jni.log"),
            "runtime_state_seed": runtime_state.clone(),
            "gates": {
                "privacy_agree_gate": {
                    "call": "r75.l()",
                    "result": privacy_gate,
                    "shared_pref_key": "sp_privacy_agree",
                },
                "phone_state_permission_gate": {
                    "call": "tg4.b(context, [android.permission.READ_PHONE_STATE])",
                    "result": phone_gate,
                    "permission": "android.permission.READ_PHONE_STATE",
                }
            },
            "priv_info": {
                "before_init": {
                    "is_init": before_priv.get("is_init").cloned().unwrap_or(Value::Bool(false)),
                    "android_id": before_priv.get("android_id").cloned().unwrap_or_else(|| json!("")),
                    "imei": before_priv.get("imei").cloned().unwrap_or_else(|| json!("")),
                    "mac": before_priv.get("mac").cloned().unwrap_or_else(|| json!("")),
                },
                "after_init": {
                    "is_init": after_priv.get("is_init").cloned().unwrap_or(Value::Bool(false)),
                    "android_id": after_priv.get("android_id").cloned().unwrap_or_else(|| json!("")),
                    "imei": after_priv.get("imei").cloned().unwrap_or_else(|| json!("")),
                    "mac": after_priv.get("mac").cloned().unwrap_or_else(|| json!("")),
                }
            },
            "wm4": {
                "android_id": wm4_android_id,
                "imei": wm4_imei,
                "mac": wm4_mac,
            },
            "smid": {
                "smdu_getDeviceId_runtime": smdu_device_id,
                "smdu_getDeviceId_seed": runtime_state.effective_sdid(),
                "smdu_getDuLabel_runtime": smdu_device_label,
                "smdu_getDuLabel_seed": runtime_state.effective_device_label(),
                "smid_helper_o_runtime": smid_helper_o,
                "smid_helper_expected_seed": if !runtime_state.effective_sdid().trim().is_empty() {
                    runtime_state.effective_sdid()
                } else {
                    runtime_state.effective_local_smid()
                },
                "ac1_v_runtime": ac1_v,
            },
            "app_init_upstream_observation": app_init_upstream_observation,
            "evidence": {
                "privacy_agree_device_pref": "/Users/haojiejack/github/drizzle-dumper-rust/boss_purecalc/risk/fengkong-slide-solver/artifacts/device_20260326_203005/extracted2/palmchat_pull/shared_prefs/wifi_social.xml:22",
                "app_init_callsite": "/Users/haojiejack/github/drizzle-dumper-rust/artifacts/palmchat_apponly_jadx_20260324_230038/sources/com/zenmen/palmchat/AppContext.java:607",
                "read_phone_state_runtime_check": "adb shell dumpsys package com.zenmen.palmchat | rg READ_PHONE_STATE",
                "smid_static_chain": "/Users/haojiejack/github/drizzle-dumper-rust/artifacts/palmchat_apponly_jadx_20260324_230038/sources/com/zenmen/palmchat/utils/SmidHelper.java:238",
            }
        }))
    }

    fn run_captcha_ui_debug(&mut self, opts: &HashMap<String, String>) -> Result<Value> {
        let stage1_raw = opts
            .get("--stage1-json")
            .or_else(|| opts.get("--arg1"))
            .cloned()
            .filter(|value| !value.trim().is_empty())
            .unwrap_or_else(|| "{}".to_string());
        let (stage1_raw_normalized, stage1_value) =
            self.normalize_flow_arg1_json(&stage1_raw, "captcha_ui_debug.stage1");
        let stage1_obj = match stage1_value.clone() {
            Value::Object(map) => map,
            _ => {
                return Err(anyhow!(
                    "--stage1-json/--arg1 must be a JSON object for captcha-ui-debug"
                ));
            }
        };
        let interactive = opts
            .get("--interactive")
            .map(|value| parse_bool_like(value))
            .unwrap_or(false);
        let flow_enabled = opts
            .get("--flow")
            .map(|value| parse_bool_like(value))
            .unwrap_or(true);
        let ui_mode = opts
            .get("--ui-mode")
            .map(|value| value.trim().to_ascii_lowercase())
            .unwrap_or_else(|| {
                if interactive {
                    "sdk".to_string()
                } else {
                    "headless".to_string()
                }
            });

        let default_verify_status = opts
            .get("--verify-status")
            .map(|value| parse_bool_like(value))
            .unwrap_or(false);
        let default_rid = opts
            .get("--rid")
            .cloned()
            .filter(|value| !value.trim().is_empty())
            .unwrap_or_else(default_manual_rid);
        let default_mode_type = opts
            .get("--mode-type")
            .cloned()
            .unwrap_or_else(|| "select".to_string());
        let default_diff_time = opts
            .get("--diff-time")
            .cloned()
            .unwrap_or_else(|| "5000".to_string());
        let sdk_html_path = opts
            .get("--sdk-html")
            .map(PathBuf::from)
            .unwrap_or_else(default_smcaptcha_html_path);
        let sdk_backfill_wait_ms = opts
            .get("--sdk-backfill-wait-ms")
            .and_then(|value| value.parse::<u64>().ok())
            .unwrap_or_else(|| default_diff_time.parse::<u64>().unwrap_or(5000));

        let launch = if interactive {
            match ui_mode.as_str() {
                "tty" => {
                    render_captcha_ui_debug_banner(&stage1_obj);
                    let verify_status =
                        prompt_bool_with_default("captcha pass? [y/N]", default_verify_status)?;
                    let submission = if verify_status {
                        let rid = prompt_text_with_default("rid", &default_rid)?;
                        let mode_type = prompt_text_with_default("modeType", &default_mode_type)?;
                        let diff_time =
                            prompt_text_with_default("diffTime(ms)", &default_diff_time)?;
                        CaptchaUiDebugSubmission {
                            verify_status,
                            rid,
                            mode_type,
                            diff_time,
                        }
                    } else {
                        CaptchaUiDebugSubmission {
                            verify_status,
                            rid: String::new(),
                            mode_type: String::new(),
                            diff_time: String::new(),
                        }
                    };
                    CaptchaUiDebugLaunch {
                        submission,
                        extra_events: Vec::new(),
                        ui_mode: "tty".to_string(),
                        ui_source: "tty_manual".to_string(),
                    }
                }
                "form" => launch_captcha_ui_form_browser(
                    &stage1_value,
                    default_verify_status,
                    &default_rid,
                    &default_mode_type,
                    &default_diff_time,
                    flow_enabled,
                )?,
                "sdk" | "browser" => launch_captcha_ui_sdk_browser(
                    &stage1_value,
                    default_verify_status,
                    &default_rid,
                    &default_mode_type,
                    &default_diff_time,
                    sdk_backfill_wait_ms,
                    flow_enabled,
                    &sdk_html_path,
                )?,
                "headless" => CaptchaUiDebugLaunch {
                    submission: CaptchaUiDebugSubmission {
                        verify_status: default_verify_status,
                        rid: default_rid.clone(),
                        mode_type: default_mode_type.clone(),
                        diff_time: default_diff_time.clone(),
                    },
                    extra_events: Vec::new(),
                    ui_mode: "headless".to_string(),
                    ui_source: "headless_defaults".to_string(),
                },
                other => {
                    return Err(anyhow!(
                        "unsupported --ui-mode value: {other} (expected sdk|form|tty|headless)"
                    ));
                }
            }
        } else {
            CaptchaUiDebugLaunch {
                submission: CaptchaUiDebugSubmission {
                    verify_status: default_verify_status,
                    rid: default_rid,
                    mode_type: default_mode_type,
                    diff_time: default_diff_time,
                },
                extra_events: Vec::new(),
                ui_mode: "headless".to_string(),
                ui_source: "cli_defaults".to_string(),
            }
        };

        self.execute_captcha_ui_debug_session(
            stage1_raw_normalized,
            stage1_obj,
            interactive,
            flow_enabled,
            launch,
            opts,
        )
    }

    fn execute_captcha_ui_debug_session(
        &mut self,
        stage1_raw_normalized: String,
        stage1_obj: Map<String, Value>,
        interactive: bool,
        flow_enabled: bool,
        launch: CaptchaUiDebugLaunch,
        opts: &HashMap<String, String>,
    ) -> Result<Value> {
        let CaptchaUiDebugLaunch {
            mut submission,
            mut extra_events,
            ui_mode,
            ui_source,
        } = launch;
        let mut stage2_obj = stage1_obj.clone();
        let mut ui_events = Vec::new();
        ui_events.push(json!({
            "ts": iso_now(),
            "phase": "ui_session_begin",
            "interactive": interactive,
            "flow_enabled": flow_enabled,
            "ui_mode": ui_mode,
            "ui_source": ui_source,
        }));
        ui_events.push(json!({
            "ts": iso_now(),
            "phase": "ui_render_first_send",
            "payload": Value::Object(stage1_obj.clone()),
            "key_fields": extract_known_fields_from_value(&Value::Object(stage1_obj.clone()), V7_CAPTCHA_BRIDGE_KEYS),
        }));
        ui_events.push(json!({
            "ts": iso_now(),
            "phase": "ui_receive_1900_branch",
            "result_code": 1900,
            "message": "captcha_required",
        }));
        ui_events.append(&mut extra_events);

        let mut manual_input = Map::new();
        manual_input.insert("interactive".to_string(), Value::Bool(interactive));
        manual_input.insert("ui_source".to_string(), Value::String(ui_source.clone()));
        manual_input.insert(
            "verifyStatus".to_string(),
            Value::Bool(submission.verify_status),
        );
        if submission.verify_status {
            if submission.rid.trim().is_empty() {
                submission.rid = default_manual_rid();
            }
            if submission.mode_type.trim().is_empty() {
                submission.mode_type = "select".to_string();
            }
            if submission.diff_time.trim().is_empty() {
                submission.diff_time = "5000".to_string();
            }
            stage2_obj.insert("verifyStatus".to_string(), Value::Bool(true));
            stage2_obj.insert("rid".to_string(), Value::String(submission.rid.clone()));
            stage2_obj.insert(
                "modeType".to_string(),
                Value::String(submission.mode_type.clone()),
            );
            stage2_obj.insert(
                "diffTime".to_string(),
                Value::String(submission.diff_time.clone()),
            );
            manual_input.insert("rid".to_string(), Value::String(submission.rid.clone()));
            manual_input.insert(
                "modeType".to_string(),
                Value::String(submission.mode_type.clone()),
            );
            manual_input.insert(
                "diffTime".to_string(),
                Value::String(submission.diff_time.clone()),
            );
            let pass_phase = if ui_source == "sdk_bridge" {
                "ui_captcha_pass_sdk"
            } else {
                "ui_captcha_pass_manual"
            };
            ui_events.push(json!({
                "ts": iso_now(),
                "phase": pass_phase,
                "rid": submission.rid,
                "modeType": submission.mode_type,
                "diffTime": submission.diff_time,
            }));
        } else {
            stage2_obj.insert("verifyStatus".to_string(), Value::Bool(false));
            stage2_obj.remove("rid");
            stage2_obj.remove("modeType");
            stage2_obj.remove("diffTime");
            stage2_obj.remove("captcha");
            ui_events.push(json!({
                "ts": iso_now(),
                "phase": "ui_captcha_not_passed",
                "verifyStatus": false,
            }));
        }

        let stage2_value = Value::Object(stage2_obj.clone());
        let stage2_raw = stage2_value.to_string();
        ui_events.push(json!({
            "ts": iso_now(),
            "phase": "ui_stage2_ready",
            "payload": stage2_value.clone(),
            "bridge_fields": extract_known_fields_from_value(&stage2_value, V7_CAPTCHA_BRIDGE_KEYS),
        }));

        let v7_captcha_bridge_surface = build_v7_captcha_bridge_surface(
            Some(&Value::Object(stage1_obj.clone())),
            &stage2_value,
        );
        let v7_captcha_upstream_production = build_v7_captcha_upstream_production(
            Some(&Value::Object(stage1_obj.clone())),
            &stage2_value,
        );
        let v7_retry_payload_views =
            build_v7_retry_payload_views(Some(&Value::Object(stage1_obj.clone())), &stage2_value);
        let v7_captcha_business_surface = build_v7_captcha_business_surface(
            Some(&Value::Object(stage1_obj.clone())),
            &stage2_value,
        );

        let flow_result = if flow_enabled {
            let mut effective_flow_opts = opts.clone();
            let secret_keys_seeded =
                self.apply_secret_keys_from_opts(&effective_flow_opts, "captcha_ui_debug.flow")?;
            let auth_bootstrap =
                self.ensure_stage1_auth_bootstrap(&effective_flow_opts, "captcha_ui_debug.flow")?;
            let smssend_url_auth = self.derive_smssend_url_auth(&effective_flow_opts);
            if let Some(injected) = prepare_smssend_test_url_opts(
                &stage1_obj,
                &stage2_obj,
                &mut effective_flow_opts,
                Some(&smssend_url_auth),
                self.live_device_profile.as_ref(),
            ) {
                ui_events.push(json!({
                    "ts": iso_now(),
                    "phase": "control_flow_smssend_url_injected",
                    "injected": injected,
                }));
            }
            if let Some(secret_keys_seeded) = secret_keys_seeded.as_ref() {
                ui_events.push(json!({
                    "ts": iso_now(),
                    "phase": "control_flow_secret_keys_seeded",
                    "secret_keys_seeded": secret_keys_seeded,
                }));
            }
            ui_events.push(json!({
                "ts": iso_now(),
                "phase": "control_flow_auth_bootstrap",
                "auth_bootstrap": auth_bootstrap,
            }));
            self.shared
                .borrow_mut()
                .native("captcha_ui_debug step=flow start");
            let mut output = self.run_flow_for_captcha_ui(
                &stage2_raw,
                &stage1_raw_normalized,
                &effective_flow_opts,
                &ui_source,
            )?;
            self.shared
                .borrow_mut()
                .native("captcha_ui_debug step=flow done");
            if let Some(secret_keys_seeded) = secret_keys_seeded {
                if let Some(output_obj) = output.as_object_mut() {
                    output_obj.insert("secret_keys_seeded".to_string(), secret_keys_seeded);
                }
            }
            ui_events.push(json!({
                "ts": iso_now(),
                "phase": "data_flow_observation",
                "flow": output.get("flow").cloned(),
                "cipher_return_debug": output.get("cipher_return_debug").cloned(),
                "encrypted_ckey_len": output.get("encrypted_ckey_hex").and_then(Value::as_str).map(|v| v.len() / 2),
                "cipher_len": output.get("cipher_hex").and_then(Value::as_str).map(|v| v.len() / 2),
            }));
            if let Some(feedback) = output.get("data_to_control_feedback") {
                ui_events.push(json!({
                    "ts": iso_now(),
                    "phase": "control_flow_feedback",
                    "feedback": feedback.clone(),
                }));
            }
            if let Some(smssend_result) = output.get("smssend_test") {
                ui_events.push(json!({
                    "ts": iso_now(),
                    "phase": "control_flow_smssend_test",
                    "result": smssend_result.clone(),
                }));
            }
            Some(output)
        } else {
            None
        };
        let v7_captcha_ui_surface = build_v7_captcha_ui_surface(
            &Value::Object(stage1_obj.clone()),
            &stage2_value,
            interactive,
            &manual_input,
            &ui_events,
        );

        let jsonl_path = opts
            .get("--jsonl-out")
            .map(PathBuf::from)
            .unwrap_or_else(|| {
                self.config
                    .trace_out_dir
                    .join("palmchat_captcha_ui_debug.jsonl")
            });
        write_jsonl_file(&jsonl_path, &ui_events)?;

        let output = json!({
            "status": "ok",
            "command": "captcha-ui-debug",
            "requested_backend": self.config.backend,
            "active_backend": self.emulator.backend.name(),
            "interactive": interactive,
            "ui_mode": ui_mode,
            "ui_source": ui_source,
            "flow_enabled": flow_enabled,
            "stage1_json": Value::Object(stage1_obj),
            "stage2_json": stage2_value,
            "manual_input": Value::Object(manual_input),
            "v7_captcha_ui_surface": v7_captcha_ui_surface,
            "v7_captcha_bridge_surface": v7_captcha_bridge_surface,
            "v7_captcha_upstream_production": v7_captcha_upstream_production,
            "v7_retry_payload_views": v7_retry_payload_views,
            "v7_captcha_business_surface": v7_captcha_business_surface,
            "flow_result": flow_result,
            "trace_jsonl": jsonl_path,
            "native_log": self.config.trace_out_dir.join("palmchat_native.log"),
            "jni_log": self.config.trace_out_dir.join("palmchat_jni.log"),
        });
        self.shared
            .borrow_mut()
            .native(&format!("captcha_ui_debug result={}", output));
        Ok(output)
    }

    fn build_flow_opts_for_captcha_ui(
        &self,
        stage2_raw: &str,
        stage1_raw_normalized: &str,
        opts: &HashMap<String, String>,
    ) -> HashMap<String, String> {
        let mut flow_opts = HashMap::new();
        flow_opts.insert("--arg1".to_string(), stage2_raw.to_string());
        flow_opts.insert(
            "--bridge-stage1-json".to_string(),
            stage1_raw_normalized.to_string(),
        );
        if let Some(mode) = opts.get("--arg2") {
            flow_opts.insert("--arg2".to_string(), mode.clone());
        }
        if let Some(use_new_key) = opts.get("--arg3") {
            flow_opts.insert("--arg3".to_string(), use_new_key.clone());
        }
        for key in [
            "--no-empty-params",
            "--seed-device-id",
            "--seed-local-smid",
            "--seed-dhid",
            "--seed-sdid",
            "--seed-imei",
            "--seed-mac",
            "--seed-oneid",
            "--seed-oaid",
            "--seed-android-id",
            "--seed-channel-id",
            "--seed-appid",
            "--seed-ip-info",
            "--seed-device-label",
            "--secret-key",
            "--secret-iv",
        ] {
            if let Some(value) = opts.get(key) {
                flow_opts.insert(key.to_string(), value.clone());
            }
        }
        if let Some(smssend_test) = opts.get("--smssend-test") {
            flow_opts.insert("--smssend-test".to_string(), smssend_test.clone());
        }
        if let Some(two_step) = opts.get("--smssend-two-step") {
            flow_opts.insert("--smssend-two-step".to_string(), two_step.clone());
        }
        if let Some(smssend_url) = opts.get("--smssend-url") {
            flow_opts.insert("--smssend-url".to_string(), smssend_url.clone());
        }
        if let Some(smssend_timeout) = opts.get("--smssend-timeout-ms") {
            flow_opts.insert("--smssend-timeout-ms".to_string(), smssend_timeout.clone());
        }
        if let Some(smssend_user_agent) = opts.get("--smssend-user-agent") {
            flow_opts.insert(
                "--smssend-user-agent".to_string(),
                smssend_user_agent.clone(),
            );
        }
        for key in ["--transport-runtime", "--okhttp-bridge-url", "--http1-only"] {
            if let Some(value) = opts.get(key) {
                flow_opts.insert(key.to_string(), value.clone());
            }
        }
        flow_opts
    }

    fn run_flow_subprocess_for_captcha_ui(
        &mut self,
        stage2_raw: &str,
        stage1_raw_normalized: &str,
        opts: &HashMap<String, String>,
    ) -> Result<Value> {
        let exe = std::env::current_exe().context("failed to resolve current executable path")?;
        let mut cmd = Command::new(exe);
        cmd.arg("palmchat").arg("flow");
        if let Some(config_path) = opts.get("--config") {
            cmd.arg("--config").arg(config_path);
        }
        if let Some(backend) = opts.get("--backend") {
            cmd.arg("--backend").arg(backend);
        } else {
            cmd.arg("--backend").arg(self.emulator.backend.name());
        }
        cmd.arg("--arg1").arg(stage2_raw);
        cmd.arg("--bridge-stage1-json").arg(stage1_raw_normalized);
        if let Some(mode) = opts.get("--arg2") {
            cmd.arg("--arg2").arg(mode);
        }
        if let Some(use_new_key) = opts.get("--arg3") {
            cmd.arg("--arg3").arg(use_new_key);
        }
        for key in [
            "--no-empty-params",
            "--seed-device-id",
            "--seed-local-smid",
            "--seed-dhid",
            "--seed-sdid",
            "--seed-imei",
            "--seed-mac",
            "--seed-oneid",
            "--seed-oaid",
            "--seed-android-id",
            "--seed-channel-id",
            "--seed-appid",
            "--seed-ip-info",
            "--seed-device-label",
            "--secret-key",
            "--secret-iv",
        ] {
            if let Some(value) = opts.get(key) {
                cmd.arg(key).arg(value);
            }
        }
        if let Some(flag) = opts.get("--smssend-test") {
            cmd.arg("--smssend-test").arg(flag);
        }
        if let Some(two_step) = opts.get("--smssend-two-step") {
            cmd.arg("--smssend-two-step").arg(two_step);
        }
        if let Some(url) = opts.get("--smssend-url") {
            cmd.arg("--smssend-url").arg(url);
        }
        if let Some(timeout) = opts.get("--smssend-timeout-ms") {
            cmd.arg("--smssend-timeout-ms").arg(timeout);
        }
        if let Some(ua) = opts.get("--smssend-user-agent") {
            cmd.arg("--smssend-user-agent").arg(ua);
        }
        for key in ["--transport-runtime", "--okhttp-bridge-url", "--http1-only"] {
            if let Some(value) = opts.get(key) {
                cmd.arg(key).arg(value);
            }
        }
        let output = cmd
            .output()
            .context("failed to spawn subprocess flow observation")?;
        if !output.status.success() {
            let stderr = String::from_utf8_lossy(&output.stderr);
            return Err(anyhow!(
                "subprocess flow observation failed: status={} stderr={}",
                output.status,
                stderr.trim()
            ));
        }
        let stdout = String::from_utf8(output.stdout)
            .context("subprocess flow observation stdout is not valid utf-8")?;
        serde_json::from_str::<Value>(&stdout)
            .context("failed to parse subprocess flow observation json output")
    }

    fn run_flow_for_captcha_ui(
        &mut self,
        stage2_raw: &str,
        stage1_raw_normalized: &str,
        opts: &HashMap<String, String>,
        ui_source: &str,
    ) -> Result<Value> {
        let flow_opts =
            self.build_flow_opts_for_captcha_ui(stage2_raw, stage1_raw_normalized, opts);
        if ui_source.starts_with("sdk") {
            self.run_flow_subprocess_for_captcha_ui(stage2_raw, stage1_raw_normalized, opts)
        } else {
            self.run_flow(&flow_opts)
        }
    }

    fn flow_encrypt_payload(
        &mut self,
        payload: &Value,
        cipher_mode: i32,
        use_new_key: bool,
        trace_tag: &str,
    ) -> Result<(String, String, String)> {
        let raw = payload.to_string();
        let json_obj = self.make_json_object(&raw)?;
        self.shared
            .borrow_mut()
            .native(&format!("{trace_tag} step=setLxData start"));
        let _ = self.call_static(
            "setLxData",
            "(Lorg/json/JSONObject;)V",
            vec![json_obj.clone().into()],
        )?;
        self.shared
            .borrow_mut()
            .native(&format!("{trace_tag} step=setLxData done"));
        self.shared
            .borrow_mut()
            .native(&format!("{trace_tag} step=createCKey start"));
        let _ = self.call_static("createCKey", "()V", vec![])?;
        self.shared
            .borrow_mut()
            .native(&format!("{trace_tag} step=createCKey done"));
        apply_runtime_page_patch_entries(
            &self.config.runtime_page_patches_after_create_ckey,
            &self.emulator,
            self.shared.clone(),
            self.module_base,
            "post-createCKey runtime page patch",
        )?;
        let ck_version = self
            .call_static("getCkVersion", "()Ljava/lang/String;", vec![])
            .ok()
            .and_then(|value| jni_value_to_string(value).ok())
            .map(override_palmchat_ck_version)
            .unwrap_or_else(|| override_palmchat_ck_version(String::new()));
        self.shared
            .borrow_mut()
            .native(&format!("{trace_tag} step=getEncryptedCKey start"));
        let encrypted_ckey =
            self.call_static("getEncryptedCKey", "(Z)[B", vec![use_new_key.into()])?;
        let encrypted_ckey_bytes = {
            let emulator = self.emulator.clone();
            let vm = emulator.get_dalvik_vm();
            jni_value_to_bytes_with_vm(vm, encrypted_ckey)?
        };
        self.shared.borrow_mut().native(&format!(
            "{trace_tag} step=getEncryptedCKey done bytes_len={}",
            encrypted_ckey_bytes.len()
        ));
        self.shared
            .borrow_mut()
            .native(&format!("{trace_tag} step=cipherWithHashKey start"));
        let cipher_value = self.call_static(
            "cipherWithHashKey",
            "(Lorg/json/JSONObject;IZ)[B",
            vec![json_obj.into(), cipher_mode.into(), use_new_key.into()],
        )?;
        let cipher_bytes = {
            let emulator = self.emulator.clone();
            let vm = emulator.get_dalvik_vm();
            jni_value_to_bytes_with_vm(vm, cipher_value)?
        };
        self.shared.borrow_mut().native(&format!(
            "{trace_tag} step=cipherWithHashKey done bytes_len={}",
            cipher_bytes.len()
        ));
        Ok((
            ck_version,
            hex::encode(encrypted_ckey_bytes).to_ascii_uppercase(),
            hex::encode(cipher_bytes).to_ascii_uppercase(),
        ))
    }

    fn flow_encrypt_payload_subprocess(
        &mut self,
        payload: &Value,
        cipher_mode: i32,
        use_new_key: bool,
        trace_tag: &str,
        opts: &HashMap<String, String>,
    ) -> Result<(String, String, String)> {
        let secret_pair = self
            .messaging_service_secret_pair()
            .ok_or_else(|| anyhow!("messaging_service_secret_pair unavailable"))?;
        let secret_key = String::from_utf8(secret_pair.key)
            .context("messaging_service secret_key is not valid utf-8")?;
        let secret_iv = String::from_utf8(secret_pair.iv)
            .context("messaging_service secret_iv is not valid utf-8")?;
        let exe = std::env::current_exe().context("failed to resolve current executable path")?;
        let trace_slug = trace_tag
            .chars()
            .map(|ch| {
                if ch.is_ascii_alphanumeric() {
                    ch
                } else {
                    '_'
                }
            })
            .collect::<String>();
        let json_out_path = self.config.trace_out_dir.join(format!(
            "{}_{}.json",
            trace_slug,
            current_timestamp_millis()
        ));
        let mut cmd = Command::new(exe);
        cmd.arg("palmchat").arg("invoke");
        cmd.arg("--config")
            .arg(opts.get("--config").cloned().unwrap_or_else(default_config_path));
        if let Some(backend) = opts.get("--backend") {
            cmd.arg("--backend").arg(backend);
        } else {
            cmd.arg("--backend").arg(self.emulator.backend.name());
        }
        cmd.arg("--method").arg("flowEncrypt");
        cmd.arg("--arg1").arg(payload.to_string());
        cmd.arg("--arg2").arg(cipher_mode.to_string());
        cmd.arg("--arg3")
            .arg(if use_new_key { "true" } else { "false" });
        cmd.arg("--secret-key").arg(secret_key);
        cmd.arg("--secret-iv").arg(secret_iv);
        cmd.arg("--json-out").arg(&json_out_path);
        let output = cmd
            .output()
            .context("failed to spawn subprocess flowEncrypt observation")?;
        if !output.status.success() {
            let stderr = String::from_utf8_lossy(&output.stderr);
            let stdout = String::from_utf8_lossy(&output.stdout);
            return Err(anyhow!(
                "subprocess flowEncrypt failed: status={} stderr={} stdout={}",
                output.status,
                stderr.trim(),
                stdout.trim()
            ));
        }
        let output_value = read_json_file(&json_out_path)
            .with_context(|| format!("failed to read subprocess output {:?}", json_out_path))?;
        let ck_version = output_value
            .get("ck_version")
            .and_then(Value::as_str)
            .map(str::to_string)
            .ok_or_else(|| anyhow!("subprocess flowEncrypt missing ck_version"))?;
        let encrypted_ckey_hex = output_value
            .get("encrypted_ckey_hex")
            .and_then(Value::as_str)
            .map(str::to_string)
            .ok_or_else(|| anyhow!("subprocess flowEncrypt missing encrypted_ckey_hex"))?;
        let cipher_hex = output_value
            .get("cipher_hex")
            .and_then(Value::as_str)
            .map(str::to_string)
            .ok_or_else(|| anyhow!("subprocess flowEncrypt missing cipher_hex"))?;
        Ok((ck_version, encrypted_ckey_hex, cipher_hex))
    }

    fn run_smssend_test_internal(
        &mut self,
        control_feedback: &Value,
        cipher_hex: &str,
        use_new_key: bool,
        opts: &HashMap<String, String>,
        ignore_verify_status_gate: bool,
    ) -> Value {
        let Some(feedback_obj) = control_feedback.as_object() else {
            return json!({
                "status": "blocked",
                "reason": "invalid_control_feedback_format",
            });
        };
        let mut blocked_reasons = feedback_obj
            .get("blocked_reasons")
            .and_then(Value::as_array)
            .cloned()
            .unwrap_or_default()
            .into_iter()
            .filter_map(|v| v.as_str().map(str::to_string))
            .collect::<Vec<_>>();
        if ignore_verify_status_gate {
            blocked_reasons.retain(|reason| reason != "verifyStatus_false");
        }
        if !blocked_reasons.is_empty() {
            return json!({
                "status": "blocked",
                "reason": "control_feedback_not_ready",
                "blocked_reasons": blocked_reasons,
                "control_feedback": control_feedback,
            });
        }
        let url = feedback_obj
            .get("smssend_url")
            .and_then(Value::as_str)
            .unwrap_or_default();
        if url.trim().is_empty() {
            return json!({
                "status": "blocked",
                "reason": "missing_smssend_url",
                "control_feedback": control_feedback,
            });
        }
        let body_bytes = match hex::decode(cipher_hex) {
            Ok(bytes) => bytes,
            Err(err) => {
                return json!({
                    "status": "blocked",
                    "reason": "invalid_cipher_hex",
                    "error": err.to_string(),
                });
            }
        };
        let timeout_ms = opts
            .get("--smssend-timeout-ms")
            .and_then(|value| value.parse::<u64>().ok())
            .unwrap_or(20_000);
        let user_agent = opts.get("--smssend-user-agent").cloned();
        let body_value = feedback_obj.get("body");

        let mut headers = HeaderMap::new();
        let header_map = feedback_obj
            .get("headers")
            .and_then(Value::as_object)
            .cloned()
            .unwrap_or_default();
        for (name, value) in &header_map {
            let Some(value_text) = value.as_str() else {
                continue;
            };
            let Ok(header_name) = HeaderName::from_bytes(name.as_bytes()) else {
                continue;
            };
            let Ok(header_value) = HeaderValue::from_str(value_text) else {
                continue;
            };
            headers.insert(header_name, header_value);
        }
        for (header_name, header_value) in
            self.build_smssend_transport_headers(body_value, user_agent.as_deref())
        {
            if !headers.contains_key(&header_name) {
                headers.insert(header_name, header_value);
            }
        }
        let request_headers = header_map_to_json(&headers);

        let transport_response =
            match self.execute_smssend_request(url, &headers, &body_bytes, timeout_ms, opts) {
                Ok(response) => response,
                Err(err) => {
                    return json!({
                        "status": "blocked",
                        "reason": "smssend_transport_failed",
                        "error": format!("{err:#}"),
                        "request_headers": request_headers,
                        "control_feedback": control_feedback,
                        "ignore_verify_status_gate": ignore_verify_status_gate,
                    });
                }
            };
        let encrypted_header =
            header_value_case_insensitive(&transport_response.headers, "content-encrypted-zx")
                .unwrap_or_default();
        let decoded_bytes = if encrypted_header == "1" {
            match self.call_static(
                "cipherWithType",
                "([BIZ)[B",
                vec![
                    JniValue::Object(DvmObject::ByteArray(transport_response.body_bytes.clone())),
                    3.into(),
                    use_new_key.into(),
                ],
            ) {
                Ok(value) => jni_value_to_bytes(value)
                    .unwrap_or_else(|_| transport_response.body_bytes.clone()),
                Err(_) => transport_response.body_bytes.clone(),
            }
        } else {
            transport_response.body_bytes.clone()
        };
        let decoded_utf8 = String::from_utf8_lossy(&decoded_bytes).to_string();
        let decoded_json = serde_json::from_slice::<Value>(&decoded_bytes).ok();
        let result_code = decoded_json
            .as_ref()
            .and_then(|value| value.get("resultCode"))
            .and_then(Value::as_i64);
        json!({
            "status": "ok",
            "http_status": transport_response.status,
            "result_code": result_code,
            "request_headers": request_headers,
            "response_headers": string_map_to_json(&transport_response.headers),
            "response_body_hex": hex::encode(&transport_response.body_bytes).to_ascii_uppercase(),
            "response_decoded_hex": hex::encode(&decoded_bytes).to_ascii_uppercase(),
            "response_decoded_utf8": decoded_utf8,
            "response_decoded_json": decoded_json,
            "transport": transport_response.transport,
            "control_feedback": control_feedback,
            "ignore_verify_status_gate": ignore_verify_status_gate,
        })
    }

    fn build_smssend_transport_headers(
        &self,
        body_value: Option<&Value>,
        requested_user_agent: Option<&str>,
    ) -> Vec<(HeaderName, HeaderValue)> {
        let mut out = Vec::new();
        if let Some(user_agent_zx) = build_palmchat_user_agent_zx(
            self.live_device_profile.as_ref(),
            &self.app_version_info,
            body_value,
        ) {
            if let Ok(value) = HeaderValue::from_str(&user_agent_zx) {
                out.push((HeaderName::from_static("user-agent-zx"), value));
            }
        }
        if let Some(user_agent_zx_version) =
            build_palmchat_user_agent_zx_version(self.app_version_info.version_name.as_deref())
        {
            if let Ok(value) = HeaderValue::from_str(&user_agent_zx_version) {
                out.push((HeaderName::from_static("user-agent-zx-version"), value));
            }
        }
        let user_agent = requested_user_agent
            .map(str::to_string)
            .or_else(|| build_android_dalvik_user_agent(self.live_device_profile.as_ref()));
        if let Some(user_agent_value) = user_agent {
            if let Ok(value) = HeaderValue::from_str(&user_agent_value) {
                out.push((reqwest::header::USER_AGENT, value));
            }
        }
        out
    }

    fn execute_smssend_request(
        &self,
        url: &str,
        headers: &HeaderMap,
        body: &[u8],
        timeout_ms: u64,
        opts: &HashMap<String, String>,
    ) -> Result<PalmchatHttpTransportResponse> {
        let runtime =
            PalmchatTransportRuntime::parse(opts.get("--transport-runtime").map(String::as_str))?;
        let configured_bridge_url = opts
            .get("--okhttp-bridge-url")
            .cloned()
            .or_else(|| std::env::var("RNIDBG_OKHTTP_BRIDGE_URL").ok())
            .filter(|value| !value.trim().is_empty());
        match runtime {
            PalmchatTransportRuntime::Direct => {
                self.execute_smssend_request_direct(url, headers, body, timeout_ms, opts)
            }
            PalmchatTransportRuntime::OkHttpBridge => {
                if let Some(base_url) = configured_bridge_url {
                    self.execute_smssend_request_remote_okhttp_bridge(
                        &normalize_palmchat_bridge_url(&base_url)?,
                        url,
                        headers,
                        body,
                        timeout_ms,
                    )
                } else {
                    self.execute_smssend_request_apk_okhttp(url, headers, body, timeout_ms)
                }
            }
            PalmchatTransportRuntime::Auto => {
                if let Some(base_url) = configured_bridge_url {
                    self.execute_smssend_request_remote_okhttp_bridge(
                        &normalize_palmchat_bridge_url(&base_url)?,
                        url,
                        headers,
                        body,
                        timeout_ms,
                    )
                } else {
                    self.execute_smssend_request_direct(url, headers, body, timeout_ms, opts)
                }
            }
        }
    }

    fn execute_plain_get_request(
        &self,
        url: &str,
        timeout_ms: u64,
        opts: &HashMap<String, String>,
    ) -> Result<PalmchatHttpTransportResponse> {
        let runtime =
            PalmchatTransportRuntime::parse(opts.get("--transport-runtime").map(String::as_str))?;
        let configured_bridge_url = opts
            .get("--okhttp-bridge-url")
            .cloned()
            .or_else(|| std::env::var("RNIDBG_OKHTTP_BRIDGE_URL").ok())
            .filter(|value| !value.trim().is_empty());
        match runtime {
            PalmchatTransportRuntime::Direct => {
                self.execute_plain_get_request_direct(url, timeout_ms, opts)
            }
            PalmchatTransportRuntime::OkHttpBridge => {
                if let Some(base_url) = configured_bridge_url {
                    self.execute_plain_get_request_remote_okhttp_bridge(
                        &normalize_palmchat_bridge_url(&base_url)?,
                        url,
                        timeout_ms,
                    )
                } else {
                    self.execute_plain_get_request_apk_okhttp(url, timeout_ms)
                }
            }
            PalmchatTransportRuntime::Auto => {
                if let Some(base_url) = configured_bridge_url {
                    self.execute_plain_get_request_remote_okhttp_bridge(
                        &normalize_palmchat_bridge_url(&base_url)?,
                        url,
                        timeout_ms,
                    )
                } else {
                    self.execute_plain_get_request_direct(url, timeout_ms, opts)
                }
            }
        }
    }

    fn execute_smssend_request_direct(
        &self,
        url: &str,
        headers: &HeaderMap,
        body: &[u8],
        timeout_ms: u64,
        opts: &HashMap<String, String>,
    ) -> Result<PalmchatHttpTransportResponse> {
        let mut builder = Client::builder().timeout(Duration::from_millis(timeout_ms));
        if opts
            .get("--http1-only")
            .map(|value| parse_bool_like(value))
            .unwrap_or(false)
        {
            builder = builder.http1_only();
        }
        let client = builder
            .build()
            .context("failed to build palmchat direct http client")?;
        let response = client
            .post(url)
            .headers(headers.clone())
            .body(body.to_vec())
            .send()
            .with_context(|| format!("failed to post palmchat smssend request: {url}"))?;
        let status = response.status().as_u16();
        let final_url = response.url().to_string();
        let http_version = format!("{:?}", response.version());
        let response_headers = response.headers().clone();
        let body_bytes = response
            .bytes()
            .context("failed to read palmchat direct response bytes")?
            .to_vec();
        Ok(PalmchatHttpTransportResponse {
            status,
            headers: header_map_to_string_map(&response_headers),
            body_bytes,
            transport: json!({
                "transport_runtime": "direct",
                "flow": "reqwest_direct",
                "http_version": http_version,
                "final_url": final_url,
                "request_body_size": body.len(),
                "request_body_sha256": sha256_hex_bytes(body),
                "request_content_type": headers
                    .get(reqwest::header::CONTENT_TYPE)
                    .and_then(|value| value.to_str().ok()),
            }),
        })
    }

    fn execute_plain_get_request_direct(
        &self,
        url: &str,
        timeout_ms: u64,
        opts: &HashMap<String, String>,
    ) -> Result<PalmchatHttpTransportResponse> {
        let mut builder = Client::builder().timeout(Duration::from_millis(timeout_ms));
        if opts
            .get("--http1-only")
            .map(|value| parse_bool_like(value))
            .unwrap_or(false)
        {
            builder = builder.http1_only();
        }
        let client = builder
            .build()
            .context("failed to build palmchat direct http client")?;
        let response = client
            .get(url)
            .send()
            .with_context(|| format!("failed to get palmchat requestInfo request: {url}"))?;
        let status = response.status().as_u16();
        let final_url = response.url().to_string();
        let http_version = format!("{:?}", response.version());
        let response_headers = response.headers().clone();
        let body_bytes = response
            .bytes()
            .context("failed to read palmchat direct response bytes")?
            .to_vec();
        Ok(PalmchatHttpTransportResponse {
            status,
            headers: header_map_to_string_map(&response_headers),
            body_bytes,
            transport: json!({
                "transport_runtime": "direct",
                "flow": "reqwest_direct_get",
                "http_version": http_version,
                "final_url": final_url,
            }),
        })
    }

    fn refresh_ip_info_preflight(
        &mut self,
        json_value: &mut Value,
        opts: &HashMap<String, String>,
        scope: &str,
    ) -> Option<Value> {
        let device_id = opts
            .get("--device-id")
            .cloned()
            .and_then(|value| normalize_device_id_candidate(Some(value)))
            .or_else(|| {
                self.live_device_profile.as_ref().and_then(|profile| {
                    normalize_device_id_candidate(profile.tray_device_id.clone())
                        .or_else(|| normalize_device_id_candidate(profile.sdid.clone()))
                })
            })?;
        let request_id = generate_xn3_like_id();
        let url = format!(
            "https://openapi-ipv6.lianxinapp.com/outerchannel/requestInfo?requestId={request_id}&deviceId={device_id}"
        );
        let mut builder = Client::builder().timeout(Duration::from_secs(20));
        if opts
            .get("--http1-only")
            .map(|value| parse_bool_like(value))
            .unwrap_or(false)
        {
            builder = builder.http1_only();
        }
        let response = match builder
            .build()
            .context("failed to build ipInfo preflight client")
            .and_then(|client| {
                client
                    .get(&url)
                    .send()
                    .with_context(|| format!("failed to fetch requestInfo preflight: {url}"))
            }) {
            Ok(response) => response,
            Err(err) => {
                self.shared.borrow_mut().native(&format!(
                    "{scope} ip_info_preflight failed stage=request err={err:#}"
                ));
                return Some(json!({
                    "status": "error",
                    "stage": "request",
                    "request_url": url,
                    "deviceId": device_id,
                    "requestId": request_id,
                    "error": err.to_string(),
                }));
            }
        };
        let status = response.status().as_u16();
        let final_url = response.url().to_string();
        let http_version = format!("{:?}", response.version());
        let response_text = match response.text() {
            Ok(text) => text,
            Err(err) => {
                self.shared.borrow_mut().native(&format!(
                    "{scope} ip_info_preflight failed stage=read status={} err={err:#}",
                    status
                ));
                return Some(json!({
                    "status": "error",
                    "stage": "read",
                    "request_url": url,
                    "final_url": final_url,
                    "deviceId": device_id,
                    "requestId": request_id,
                    "http_status": status,
                    "http_version": http_version,
                    "error": err.to_string(),
                }));
            }
        };
        let parsed = match serde_json::from_str::<Value>(&response_text) {
            Ok(Value::Object(obj)) => Value::Object(obj),
            Ok(other) => {
                self.shared.borrow_mut().native(&format!(
                    "{scope} ip_info_preflight failed stage=parse status={} type={}",
                    status, other
                ));
                return Some(json!({
                    "status": "error",
                    "stage": "parse",
                    "request_url": url,
                    "final_url": final_url,
                    "deviceId": device_id,
                    "requestId": request_id,
                    "http_status": status,
                    "http_version": http_version,
                    "response_text": truncate_text(&response_text, 1200),
                }));
            }
            Err(err) => {
                self.shared.borrow_mut().native(&format!(
                    "{scope} ip_info_preflight failed stage=parse status={} err={err:#}",
                    status
                ));
                return Some(json!({
                    "status": "error",
                    "stage": "parse",
                    "request_url": url,
                    "final_url": final_url,
                    "deviceId": device_id,
                    "requestId": request_id,
                    "http_status": status,
                    "http_version": http_version,
                    "response_text": truncate_text(&response_text, 1200),
                    "error": err.to_string(),
                }));
            }
        };
        let ip_info_compact = parsed.to_string();
        let preserve_runtime_probe_ip_info = self
            .live_device_profile
            .as_ref()
            .and_then(|profile| normalize_plain_candidate(profile.ip_info.clone()))
            .is_some()
            && read_runtime_probe_raw()
                .as_ref()
                .and_then(|(path, raw)| parse_runtime_probe_overrides(raw, path))
                .and_then(|overrides| overrides.ip_info)
                .is_some();
        if let Some(profile) = self.live_device_profile.as_mut() {
            if !preserve_runtime_probe_ip_info {
                profile.ip_info = Some(ip_info_compact.clone());
            }
        }
        if let Value::Object(map) = json_value {
            map.insert("ipInfo".to_string(), Value::String(ip_info_compact.clone()));
        }
        self.shared.borrow_mut().native(&format!(
            "{scope} ip_info_preflight done status={} bytes={} final_url={}",
            status,
            ip_info_compact.len(),
            final_url
        ));
        Some(json!({
            "status": "ok",
            "request_url": url,
            "final_url": final_url,
            "deviceId": device_id,
            "requestId": request_id,
            "http_status": status,
            "http_version": http_version,
            "ip_info": parsed,
            "ip_info_len": ip_info_compact.len(),
        }))
    }

    fn execute_smssend_request_remote_okhttp_bridge(
        &self,
        base_url: &str,
        url: &str,
        headers: &HeaderMap,
        body: &[u8],
        timeout_ms: u64,
    ) -> Result<PalmchatHttpTransportResponse> {
        let health = palmchat_okhttp_bridge_health(base_url)?
            .ok_or_else(|| anyhow!("okhttp bridge is not reachable at {base_url}"))?;
        let request_url = format!("{}/request", base_url.trim_end_matches('/'));
        let client = Client::builder()
            .timeout(Duration::from_millis(timeout_ms))
            .build()
            .context("failed to build palmchat okhttp-bridge client")?;
        let payload = client
            .post(&request_url)
            .json(&json!({
                "method": "POST",
                "url": url,
                "headers": header_map_to_string_map(headers),
                "body": Value::Null,
                "body_b64": BASE64_STANDARD.encode(body),
            }))
            .send()
            .with_context(|| format!("failed to call palmchat okhttp bridge: {request_url}"))?
            .json::<Value>()
            .with_context(|| {
                format!("failed to parse palmchat okhttp bridge response: {request_url}")
            })?;
        if let Some(error) = payload.get("error").and_then(Value::as_str) {
            return Err(anyhow!("okhttp bridge returned error: {error}"));
        }
        let status = payload.get("status").and_then(Value::as_u64).unwrap_or(0) as u16;
        let body_bytes = payload_body_bytes_from_transport_json(&payload).unwrap_or_default();
        Ok(PalmchatHttpTransportResponse {
            status,
            headers: json_value_to_string_map(payload.get("headers")),
            body_bytes,
            transport: json!({
                "transport_runtime": "okhttp_bridge",
                "bridge_mode": "remote",
                "bridge_url": base_url,
                "bridge_engine": health.get("engine").cloned().unwrap_or(Value::Null),
                "bridge_status": status,
                "response_body_size": payload.get("body_size").cloned().unwrap_or(Value::Null),
                "response_body_utf8": payload.get("body_utf8").cloned().unwrap_or(Value::Null),
                "request_body_size": body.len(),
                "request_body_sha256": sha256_hex_bytes(body),
                "request_content_type": headers
                    .get(reqwest::header::CONTENT_TYPE)
                    .and_then(|value| value.to_str().ok()),
            }),
        })
    }

    fn execute_plain_get_request_remote_okhttp_bridge(
        &self,
        base_url: &str,
        url: &str,
        timeout_ms: u64,
    ) -> Result<PalmchatHttpTransportResponse> {
        let health = palmchat_okhttp_bridge_health(base_url)?
            .ok_or_else(|| anyhow!("okhttp bridge is not reachable at {base_url}"))?;
        let request_url = format!("{}/request", base_url.trim_end_matches('/'));
        let client = Client::builder()
            .timeout(Duration::from_millis(timeout_ms))
            .build()
            .context("failed to build palmchat okhttp-bridge client")?;
        let payload = client
            .post(&request_url)
            .json(&json!({
                "method": "GET",
                "url": url,
                "headers": {},
            }))
            .send()
            .with_context(|| format!("failed to call palmchat okhttp bridge: {request_url}"))?
            .json::<Value>()
            .with_context(|| {
                format!("failed to parse palmchat okhttp bridge response: {request_url}")
            })?;
        if let Some(error) = payload.get("error").and_then(Value::as_str) {
            return Err(anyhow!("okhttp bridge returned error: {error}"));
        }
        let status = payload.get("status").and_then(Value::as_u64).unwrap_or(0) as u16;
        let body_bytes = payload_body_bytes_from_transport_json(&payload).unwrap_or_default();
        Ok(PalmchatHttpTransportResponse {
            status,
            headers: json_value_to_string_map(payload.get("headers")),
            body_bytes,
            transport: json!({
                "transport_runtime": "okhttp_bridge",
                "bridge_mode": "remote",
                "bridge_url": base_url,
                "bridge_engine": health.get("engine").cloned().unwrap_or(Value::Null),
                "bridge_status": status,
                "response_body_size": payload.get("body_size").cloned().unwrap_or(Value::Null),
                "response_body_utf8": payload.get("body_utf8").cloned().unwrap_or(Value::Null),
            }),
        })
    }

    fn execute_smssend_request_apk_okhttp(
        &self,
        url: &str,
        headers: &HeaderMap,
        body: &[u8],
        timeout_ms: u64,
    ) -> Result<PalmchatHttpTransportResponse> {
        let script_path = palmchat_repo_root().join("scripts/run-generic-apk-okhttp.sh");
        if !script_path.is_file() {
            return Err(anyhow!(
                "apk okhttp runner script not found: {}",
                script_path.display()
            ));
        }
        if !self.config.apk_path.is_file() {
            return Err(anyhow!(
                "palmchat apk not found for okhttp transport: {}",
                self.config.apk_path.display()
            ));
        }
        let mut command = Command::new(&script_path);
        let content_type = headers
            .get(reqwest::header::CONTENT_TYPE)
            .and_then(|value| value.to_str().ok())
            .filter(|value| !value.trim().is_empty())
            .unwrap_or("application/octet-stream; charset=utf-8");
        command
            .arg("--apk")
            .arg(&self.config.apk_path)
            .arg("--method")
            .arg("POST")
            .arg("--url")
            .arg(url)
            .arg("--content-type")
            .arg(content_type)
            .arg("--body-base64")
            .arg(BASE64_STANDARD.encode(body));
        for (key, value) in header_map_to_string_map(headers) {
            command.arg("--header").arg(format!("{key}: {value}"));
        }
        let output = run_command_with_timeout(
            &mut command,
            Duration::from_millis(timeout_ms.saturating_add(60_000)),
        )
        .with_context(|| {
            format!(
                "failed to execute palmchat apk okhttp runner: {}",
                script_path.display()
            )
        })?;
        if !output.status.success() {
            let stderr = String::from_utf8_lossy(&output.stderr).to_string();
            let stdout = String::from_utf8_lossy(&output.stdout).to_string();
            return Err(anyhow!(
                "palmchat apk okhttp runner failed: status={:?}, stderr={}, stdout={}",
                output.status.code(),
                truncate_text(&stderr, 1200),
                truncate_text(&stdout, 1200),
            ));
        }
        let payload: Value = serde_json::from_slice(&output.stdout)
            .context("failed to parse palmchat apk okhttp runner output")?;
        if let Some(error) = payload.get("error").and_then(Value::as_str) {
            return Err(anyhow!("palmchat apk okhttp returned error: {error}"));
        }
        let status = payload.get("status").and_then(Value::as_u64).unwrap_or(0) as u16;
        let body_bytes = payload_body_bytes_from_transport_json(&payload).unwrap_or_default();
        Ok(PalmchatHttpTransportResponse {
            status,
            headers: json_value_to_string_map(payload.get("headers")),
            body_bytes,
            transport: json!({
                "transport_runtime": "okhttp_bridge",
                "bridge_mode": "apk_cli",
                "bridge_flow": "palmchat_apk_okhttp",
                "apk_path": self.config.apk_path.display().to_string(),
                "script_path": script_path.display().to_string(),
                "bridge_engine": payload.get("engine").cloned().unwrap_or_else(|| Value::String("generic_apk_okhttp".to_string())),
                "bridge_status": status,
                "bridge_protocol": payload.get("protocol").cloned().unwrap_or(Value::Null),
                "bridge_message": payload.get("message").cloned().unwrap_or(Value::Null),
                "response_body_size": payload.get("body_size").cloned().unwrap_or(Value::Null),
                "response_body_utf8": payload.get("body_utf8").cloned().unwrap_or(Value::Null),
                "request_body_size": body.len(),
                "request_body_sha256": sha256_hex_bytes(body),
                "request_content_type": headers
                    .get(reqwest::header::CONTENT_TYPE)
                    .and_then(|value| value.to_str().ok()),
            }),
        })
    }

    fn execute_plain_get_request_apk_okhttp(
        &self,
        url: &str,
        timeout_ms: u64,
    ) -> Result<PalmchatHttpTransportResponse> {
        let script_path = palmchat_repo_root().join("scripts/run-generic-apk-okhttp.sh");
        if !script_path.is_file() {
            return Err(anyhow!(
                "apk okhttp runner script not found: {}",
                script_path.display()
            ));
        }
        if !self.config.apk_path.is_file() {
            return Err(anyhow!(
                "palmchat apk not found for okhttp transport: {}",
                self.config.apk_path.display()
            ));
        }
        let mut command = Command::new(&script_path);
        command
            .arg("--apk")
            .arg(&self.config.apk_path)
            .arg("--method")
            .arg("GET")
            .arg("--url")
            .arg(url);
        let output = run_command_with_timeout(
            &mut command,
            Duration::from_millis(timeout_ms.saturating_add(60_000)),
        )
        .with_context(|| {
            format!(
                "failed to execute palmchat apk okhttp runner: {}",
                script_path.display()
            )
        })?;
        if !output.status.success() {
            let stderr = String::from_utf8_lossy(&output.stderr).to_string();
            let stdout = String::from_utf8_lossy(&output.stdout).to_string();
            return Err(anyhow!(
                "palmchat apk okhttp runner failed: status={:?}, stderr={}, stdout={}",
                output.status.code(),
                truncate_text(&stderr, 1200),
                truncate_text(&stdout, 1200),
            ));
        }
        let payload: Value = serde_json::from_slice(&output.stdout)
            .context("failed to parse palmchat apk okhttp runner output")?;
        if let Some(error) = payload.get("error").and_then(Value::as_str) {
            return Err(anyhow!("palmchat apk okhttp returned error: {error}"));
        }
        let status = payload.get("status").and_then(Value::as_u64).unwrap_or(0) as u16;
        let body_bytes = payload_body_bytes_from_transport_json(&payload).unwrap_or_default();
        Ok(PalmchatHttpTransportResponse {
            status,
            headers: json_value_to_string_map(payload.get("headers")),
            body_bytes,
            transport: json!({
                "transport_runtime": "okhttp_bridge",
                "bridge_mode": "apk_cli",
                "bridge_flow": "palmchat_apk_okhttp_get",
                "apk_path": self.config.apk_path.display().to_string(),
                "script_path": script_path.display().to_string(),
                "bridge_engine": payload.get("engine").cloned().unwrap_or_else(|| Value::String("generic_apk_okhttp".to_string())),
                "bridge_status": status,
                "bridge_protocol": payload.get("protocol").cloned().unwrap_or(Value::Null),
                "bridge_message": payload.get("message").cloned().unwrap_or(Value::Null),
                "response_body_size": payload.get("body_size").cloned().unwrap_or(Value::Null),
                "response_body_utf8": payload.get("body_utf8").cloned().unwrap_or(Value::Null),
            }),
        })
    }

    fn apply_secret_keys_from_opts(
        &mut self,
        opts: &HashMap<String, String>,
        scope: &str,
    ) -> Result<Option<Value>> {
        let secret_key = normalize_plain_candidate(opts.get("--secret-key").cloned());
        let secret_iv = normalize_plain_candidate(opts.get("--secret-iv").cloned());
        if secret_key.is_some() ^ secret_iv.is_some() {
            return Err(anyhow!(
                "--secret-key and --secret-iv must be provided together for {scope}"
            ));
        }
        let (Some(secret_key), Some(secret_iv)) = (secret_key, secret_iv) else {
            return Ok(None);
        };
        self.shared.borrow_mut().native(&format!(
            "{scope} step=setSecretKeys start key_len={} iv_len={}",
            secret_key.len(),
            secret_iv.len()
        ));
        self.call_messaging_static(
            "setSecretKeys",
            "(Ljava/lang/String;Ljava/lang/String;)V",
            vec![secret_key.clone().into(), secret_iv.clone().into()],
        )?;
        self.set_app_context_secret_pair(Some(PalmchatSecretPair {
            key: secret_key.as_bytes().to_vec(),
            iv: secret_iv.as_bytes().to_vec(),
        }));
        let skey_available = self
            .call_static("skeyAvailable", "()Z", vec![])
            .ok()
            .and_then(|value| jni_value_to_bool(value).ok());
        self.shared.borrow_mut().native(&format!(
            "{scope} step=setSecretKeys done skeyAvailable={}",
            skey_available.unwrap_or(false)
        ));
        self.log_secret_slot_snapshot(&format!("{scope} setSecretKeys"));
        Ok(Some(json!({
            "applied": true,
            "secret_key_len": secret_key.len(),
            "secret_iv_len": secret_iv.len(),
            "skey_available": skey_available,
        })))
    }

    fn generate_smssend_message_token(&self, uid: &str) -> Option<String> {
        let uid = normalize_plain_candidate(Some(uid.to_string()))?;
        match self
            .call_static("skeyAvailable", "()Z", vec![])
            .ok()
            .and_then(|value| jni_value_to_bool(value).ok())
        {
            Some(true) => {}
            Some(false) => {
                self.shared.borrow_mut().native(&format!(
                    "smssend message token skipped uid={uid} reason=skeyAvailable_false"
                ));
                return None;
            }
            None => {
                self.shared.borrow_mut().native(&format!(
                    "smssend message token proceeding uid={uid} reason=skeyAvailable_unknown"
                ));
            }
        }
        let raw = format!("{uid}_{}", current_timestamp_millis());
        self.shared.borrow_mut().native(&format!(
            "smssend message token start uid={uid} raw_len={}",
            raw.len()
        ));
        let cipher_result = self.call_static(
            "cipherWithType",
            "([BIZ)[B",
            vec![
                JniValue::Object(DvmObject::ByteArray(raw.into_bytes())),
                4.into(),
                true.into(),
            ],
        );
        let cipher_value = match cipher_result {
            Ok(value) => {
                self.shared.borrow_mut().native(&format!(
                    "smssend message token cipherWithType return_debug={}",
                    describe_jni_value(&value)
                ));
                value
            }
            Err(err) => {
                self.shared.borrow_mut().native(&format!(
                    "smssend message token cipherWithType_error uid={uid} err={err:#}"
                ));
                return None;
            }
        };
        let encrypted = match jni_value_to_bytes(cipher_value) {
            Ok(bytes) => {
                self.shared.borrow_mut().native(&format!(
                    "smssend message token cipherWithType bytes_len={}",
                    bytes.len()
                ));
                bytes
            }
            Err(err) => {
                self.shared.borrow_mut().native(&format!(
                    "smssend message token cipherWithType decode_error uid={uid} err={err:#}"
                ));
                return None;
            }
        };
        Some(BASE64_STANDARD.encode(encrypted))
    }

    fn ensure_stage1_auth_bootstrap(
        &mut self,
        opts: &HashMap<String, String>,
        scope: &str,
    ) -> Result<PalmchatRecoveredAuthState> {
        let skey_available_before = self
            .call_static("skeyAvailable", "()Z", vec![])
            .ok()
            .and_then(|value| jni_value_to_bool(value).ok())
            .unwrap_or(false);
        let app_context_secret_present_before = self.app_context_secret_present();

        let live_uid = self
            .live_device_profile
            .as_ref()
            .and_then(|profile| normalize_plain_candidate(profile.account_uid.clone()));
        self.shared.borrow_mut().native(&format!(
            "{scope} auth_bootstrap seed uid_present={} sid_enc_present={} rk_enc_present={}",
            live_uid.is_some(),
            self.live_device_profile
                .as_ref()
                .and_then(|profile| profile.account_session_id_enc.as_ref())
                .map(|value| !value.trim().is_empty())
                .unwrap_or(false),
            self.live_device_profile
                .as_ref()
                .and_then(|profile| profile.account_refresh_key_enc.as_ref())
                .map(|value| !value.trim().is_empty())
                .unwrap_or(false)
        ));
        let live_session_id = self
            .live_device_profile
            .as_ref()
            .and_then(|profile| profile.account_session_id_enc.as_deref())
            .and_then(|value| self.decrypt_persisted_app_string(value));
        self.shared.borrow_mut().native(&format!(
            "{scope} auth_bootstrap decrypted sid_present={}",
            live_session_id.is_some()
        ));
        let live_refresh_key = self
            .live_device_profile
            .as_ref()
            .and_then(|profile| profile.account_refresh_key_enc.as_deref())
            .and_then(|value| self.decrypt_persisted_app_string(value));
        self.shared.borrow_mut().native(&format!(
            "{scope} auth_bootstrap decrypted rk_present={} rk_len={}",
            live_refresh_key.is_some(),
            live_refresh_key.as_deref().unwrap_or_default().len()
        ));

        let cli_uid = normalize_plain_candidate(opts.get("--uid").cloned());
        let cli_session_id = normalize_plain_candidate(opts.get("--session-id").cloned());
        let initial_candidates = PalmchatRecoveredAuthCandidates {
            cli_uid: cli_uid.clone(),
            cli_session_id: cli_session_id.clone(),
            live_uid,
            live_session_id,
            live_refresh_key,
            java_uid: None,
            java_session_id: None,
            java_refresh_key: None,
        };
        let (uid, session_id, refresh_key, resolved_source) =
            resolve_palmchat_recovered_auth_candidates(&initial_candidates);

        let mut state = PalmchatRecoveredAuthState {
            uid: uid.clone(),
            session_id: session_id.clone(),
            refresh_key: refresh_key.clone(),
            source: resolved_source,
            token_after_bootstrap: None,
            skey_available_before,
            skey_available_after: skey_available_before,
            uid_present: uid.is_some(),
            session_id_present: session_id.is_some(),
            refresh_key_present: refresh_key.is_some(),
            refresh_server_key_invoked: false,
            messaging_service_secret_present: false,
            app_context_secret_present_before,
            app_context_secret_present_after: app_context_secret_present_before,
            token_present_after: false,
            failure_reason: None,
        };

        if skey_available_before {
            state.source = "noop_existing_secret".to_string();
            if let Some(pair) = self.messaging_service_secret_pair() {
                state.messaging_service_secret_present = true;
                if !app_context_secret_present_before {
                    self.sync_app_context_secret_pair(pair, scope);
                }
            }
            state.app_context_secret_present_after = self.app_context_secret_present();
            state.token_after_bootstrap = state
                .uid
                .as_deref()
                .and_then(|value| self.generate_smssend_message_token(value));
            state.token_present_after = state.token_after_bootstrap.is_some();
            if !state.uid_present {
                state.failure_reason = Some("auth_bootstrap_missing_uid".to_string());
            }
            self.shared.borrow_mut().native(&format!(
                "{scope} auth_bootstrap noop_existing_secret uid_present={} session_present={} token_present={}",
                state.uid_present,
                state.session_id_present,
                state.token_present_after
            ));
            self.recovered_auth_state = Some(state.clone());
            return Ok(state);
        }

        self.shared
            .borrow_mut()
            .native(&format!("{scope} auth_bootstrap step=st3.e(false)"));
        let _ = self.call_java_static("defpackage/st3", "e", "(Z)V", vec![false.into()]);

        let java_uid = self.account_utils_string("p");
        let java_session_id = self.account_utils_string("o");
        let java_refresh_key = self.account_utils_string("m");
        self.shared.borrow_mut().native(&format!(
            "{scope} auth_bootstrap java_fallback uid_present={} session_present={} refresh_present={}",
            java_uid.is_some(),
            java_session_id.is_some(),
            java_refresh_key.is_some()
        ));
        let resolved_candidates = PalmchatRecoveredAuthCandidates {
            cli_uid,
            cli_session_id,
            live_uid: initial_candidates.live_uid.clone(),
            live_session_id: initial_candidates.live_session_id.clone(),
            live_refresh_key: initial_candidates.live_refresh_key.clone(),
            java_uid,
            java_session_id,
            java_refresh_key,
        };
        let (uid, session_id, refresh_key, resolved_source) =
            resolve_palmchat_recovered_auth_candidates(&resolved_candidates);
        state.uid = uid.clone();
        state.session_id = session_id.clone();
        state.refresh_key = refresh_key.clone();
        state.source = resolved_source;
        state.uid_present = state.uid.is_some();
        state.session_id_present = state.session_id.is_some();
        state.refresh_key_present = state.refresh_key.is_some();

        if !state.uid_present {
            state.failure_reason = Some("auth_bootstrap_missing_uid".to_string());
            self.recovered_auth_state = Some(state.clone());
            return Ok(state);
        }
        if !state.refresh_key_present {
            state.failure_reason = Some("auth_bootstrap_missing_refresh_key".to_string());
            self.recovered_auth_state = Some(state.clone());
            return Ok(state);
        }

        let native_did = self
            .try_call_java_static_string("defpackage/ac1", "v", "()Ljava/lang/String;", vec![])
            .and_then(|value| normalize_plain_candidate(Some(value)))
            .or_else(|| {
                normalize_device_id_candidate(
                    self.live_device_profile
                        .as_ref()
                        .and_then(|profile| profile.sdid.clone()),
                )
            })
            .unwrap_or_default();
        let query_did = self.compose_refresh_server_key_query_did();
        let use_new_key = self
            .try_call_java_static_bool("defpackage/nl0", "k", "()Z", vec![])
            .unwrap_or(true);
        let double_key_enabled = self
            .try_call_java_static_bool("defpackage/g9", "d", "()Z", vec![])
            .unwrap_or(false);
        let double_key_1 = if double_key_enabled {
            self.try_call_java_static_string(
                "defpackage/g9",
                "c",
                "(Z)Ljava/lang/String;",
                vec![true.into()],
            )
        } else {
            None
        };
        let double_key_2 = if double_key_enabled {
            self.try_call_java_static_string(
                "defpackage/g9",
                "c",
                "(Z)Ljava/lang/String;",
                vec![false.into()],
            )
        } else {
            None
        };
        let ck_version = self
            .call_static("getCkVersion", "()Ljava/lang/String;", vec![])
            .ok()
            .and_then(|value| jni_value_to_string(value).ok())
            .unwrap_or_default();
        let refresh_url = build_refresh_server_key_url(
            state.uid.as_deref().unwrap_or_default(),
            state.session_id.as_deref(),
            self.live_device_profile
                .as_ref()
                .and_then(|profile| normalize_plain_candidate(profile.account_exid.clone()))
                .as_deref(),
            opts.get("--device-id")
                .cloned()
                .and_then(|value| normalize_device_id_candidate(Some(value)))
                .or_else(|| {
                    self.live_device_profile.as_ref().and_then(|profile| {
                        normalize_device_id_candidate(profile.tray_device_id.clone())
                            .or_else(|| normalize_device_id_candidate(profile.sdid.clone()))
                    })
                })
                .as_deref()
                .unwrap_or_default(),
            &query_did,
        );
        self.shared.borrow_mut().native(&format!(
            "{scope} auth_bootstrap refresh_server_key url={refresh_url} uid={} session_present={} refresh_len={} query_did={} native_did={} ck_version={} use_new_key={} double_key_enabled={} k1_present={} k2_present={}",
            state.uid.as_deref().unwrap_or_default(),
            state.session_id_present,
            state.refresh_key.as_deref().unwrap_or_default().len(),
            query_did,
            native_did,
            ck_version,
            use_new_key,
            double_key_enabled,
            double_key_1.is_some(),
            double_key_2.is_some()
        ));
        state.refresh_server_key_invoked = true;
        self.shared.borrow_mut().native(&format!(
            "{scope} auth_bootstrap step=CreateConnectionDelegate.e enter"
        ));
        let wrapper_result = self.call_create_connection_delegate_refresh_wrapper(
            state.uid.as_deref().unwrap_or_default(),
            state.session_id.as_deref().unwrap_or_default(),
            state.refresh_key.as_deref().unwrap_or_default(),
        );
        match &wrapper_result {
            Ok(value) => self.shared.borrow_mut().native(&format!(
                "{scope} auth_bootstrap step=CreateConnectionDelegate.e exit return_debug={}",
                describe_jni_value(value)
            )),
            Err(err) => self.shared.borrow_mut().native(&format!(
                "{scope} auth_bootstrap step=CreateConnectionDelegate.e exit err={err:#}"
            )),
        }
        if let Some(pair) = self.messaging_service_secret_pair() {
            state.messaging_service_secret_present = true;
            if !app_context_secret_present_before {
                self.sync_app_context_secret_pair(pair, scope);
            }
        }
        state.app_context_secret_present_after = self.app_context_secret_present();
        state.skey_available_after = self
            .call_static("skeyAvailable", "()Z", vec![])
            .ok()
            .and_then(|value| jni_value_to_bool(value).ok())
            .unwrap_or(false);
        state.token_after_bootstrap = state
            .uid
            .as_deref()
            .and_then(|value| self.generate_smssend_message_token(value));
        state.token_present_after = state.token_after_bootstrap.is_some();
        if state.skey_available_after
            && (state.token_present_after || state.messaging_service_secret_present)
        {
            self.shared.borrow_mut().native(&format!(
                "{scope} auth_bootstrap wrapper path ready skey_after={} token_present={} app_ctx_after={} messaging_pair={}",
                state.skey_available_after,
                state.token_present_after,
                state.app_context_secret_present_after,
                state.messaging_service_secret_present
            ));
            self.recovered_auth_state = Some(state.clone());
            return Ok(state);
        }
        self.shared.borrow_mut().native(&format!(
            "{scope} auth_bootstrap step=refreshServerKey.call enter"
        ));
        let refresh_result = self.call_create_connection_delegate_refresh_server_key(
            state.session_id.as_deref().unwrap_or_default(),
            state.refresh_key.as_deref().unwrap_or_default(),
            &native_did,
            &ck_version,
            double_key_1.as_deref(),
            double_key_2.as_deref(),
            &refresh_url,
            use_new_key,
        );
        self.shared.borrow_mut().native(&format!(
            "{scope} auth_bootstrap step=refreshServerKey.call exit"
        ));
        let refresh_value = match refresh_result {
            Ok(value) => value,
            Err(err) => {
                state.failure_reason = Some("auth_bootstrap_refresh_server_key_failed".to_string());
                self.shared.borrow_mut().native(&format!(
                    "{scope} auth_bootstrap refresh_server_key_failed err={err:#}"
                ));
                self.recovered_auth_state = Some(state.clone());
                return Ok(state);
            }
        };
        self.shared.borrow_mut().native(&format!(
            "{scope} auth_bootstrap refresh_server_key return_debug={}",
            describe_jni_value(&refresh_value)
        ));
        let emulator = self.emulator.clone();
        let vm = emulator.get_dalvik_vm();
        if let Some(refresh_json) = jni_value_to_json_value_with_vm(vm, &refresh_value) {
            self.shared.borrow_mut().native(&format!(
                "{scope} auth_bootstrap refresh_server_key json={}",
                refresh_json
            ));
            if let Some((skey, iv)) = extract_secret_pair_from_refresh_result(&refresh_json) {
                self.shared.borrow_mut().native(&format!(
                    "{scope} auth_bootstrap refresh_server_key extracted_secret_pair key_len={} iv_len={}",
                    skey.len(),
                    iv.len()
                ));
                if let Err(err) = self.call_messaging_static(
                    "setSecretKeys",
                    "(Ljava/lang/String;Ljava/lang/String;)V",
                    vec![skey.clone().into(), iv.clone().into()],
                ) {
                    self.shared.borrow_mut().native(&format!(
                        "{scope} auth_bootstrap refresh_server_key setSecretKeys_failed err={err:#}"
                    ));
                } else {
                    self.set_app_context_secret_pair(Some(PalmchatSecretPair {
                        key: skey.into_bytes(),
                        iv: iv.into_bytes(),
                    }));
                }
            }
        }

        let _ = self.promote_refresh_secret_state_to_skey_flag_if_needed(scope);
        self.log_secret_slot_snapshot(&format!("{scope} auth_bootstrap"));

        if let Some(pair) = self.messaging_service_secret_pair() {
            state.messaging_service_secret_present = true;
            if !app_context_secret_present_before {
                self.sync_app_context_secret_pair(pair, scope);
            }
        }
        state.app_context_secret_present_after = self.app_context_secret_present();
        state.skey_available_after = self
            .call_static("skeyAvailable", "()Z", vec![])
            .ok()
            .and_then(|value| jni_value_to_bool(value).ok())
            .unwrap_or(false);
        state.token_after_bootstrap = state
            .uid
            .as_deref()
            .and_then(|value| self.generate_smssend_message_token(value));
        if state.token_after_bootstrap.is_none() {
            if let Some(uid) = state.uid.as_deref() {
                let extra_candidates = state
                    .refresh_key
                    .iter()
                    .cloned()
                    .chain(state.session_id.iter().cloned())
                    .collect::<Vec<_>>();
                if let Some(token) =
                    self.try_recover_secret_pair_from_refresh_state(uid, scope, &extra_candidates)?
                {
                    state.token_after_bootstrap = Some(token);
                    state.messaging_service_secret_present =
                        self.messaging_service_secret_pair().is_some();
                    state.app_context_secret_present_after = self.app_context_secret_present();
                    state.skey_available_after = self
                        .call_static("skeyAvailable", "()Z", vec![])
                        .ok()
                        .and_then(|value| jni_value_to_bool(value).ok())
                        .unwrap_or(false);
                }
            }
        }
        state.token_present_after = state.token_after_bootstrap.is_some();
        if !state.skey_available_after {
            state.failure_reason = Some("auth_bootstrap_secret_not_ready".to_string());
        }
        self.shared.borrow_mut().native(&format!(
            "{scope} auth_bootstrap result source={} uid_present={} session_present={} refresh_present={} skey_before={} skey_after={} token_present={} app_ctx_before={} app_ctx_after={} messaging_pair={}",
            state.source,
            state.uid_present,
            state.session_id_present,
            state.refresh_key_present,
            state.skey_available_before,
            state.skey_available_after,
            state.token_present_after,
            state.app_context_secret_present_before,
            state.app_context_secret_present_after,
            state.messaging_service_secret_present
        ));
        self.recovered_auth_state = Some(state.clone());
        Ok(state)
    }

    fn derive_smssend_url_auth(&self, opts: &HashMap<String, String>) -> PalmchatSmssendUrlAuth {
        let overrides = build_smssend_url_auth_overrides_from_opts(opts);
        let recovered_token = self
            .recovered_auth_state
            .as_ref()
            .and_then(|state| normalize_plain_candidate(state.token_after_bootstrap.clone()));
        let uid = overrides
            .uid
            .clone()
            .or_else(|| {
                self.recovered_auth_state
                    .as_ref()
                    .and_then(|state| normalize_plain_candidate(state.uid.clone()))
            })
            .or_else(|| {
                self.live_device_profile
                    .as_ref()
                    .and_then(|profile| normalize_plain_candidate(profile.account_uid.clone()))
            });
        let generated_token = if overrides.token.is_none() && recovered_token.is_none() {
            uid.as_deref().and_then(|value| {
                let token = self.generate_smssend_message_token(value);
                if token.is_none() {
                    self.shared.borrow_mut().native(&format!(
                        "smssend url auth token generation failed uid={value}"
                    ));
                }
                token
            })
        } else {
            None
        };
        merge_smssend_url_auth_sources(
            &overrides,
            self.recovered_auth_state.as_ref(),
            self.live_device_profile.as_ref(),
            generated_token,
        )
    }

    fn run_smssend_test(
        &mut self,
        control_feedback: &Value,
        cipher_hex: &str,
        use_new_key: bool,
        opts: &HashMap<String, String>,
    ) -> Value {
        self.run_smssend_test_internal(control_feedback, cipher_hex, use_new_key, opts, false)
    }

    fn run_smssend_two_step(
        &mut self,
        stage1_value: &Value,
        stage2_value: &Value,
        stage2_control_feedback: &Value,
        stage2_cipher_hex: &str,
        cipher_mode: i32,
        use_new_key: bool,
        opts: &HashMap<String, String>,
    ) -> Value {
        let stage1_encrypt = if std::env::var_os("PALMCHAT_FLOW_ENCRYPT_FORCE_INLINE").is_none() {
            match self.flow_encrypt_payload_subprocess(
                stage1_value,
                cipher_mode,
                use_new_key,
                "flow.two_step.stage1",
                opts,
            ) {
                Ok(value) => {
                    self.shared
                        .borrow_mut()
                        .native("flow.two_step.stage1 encrypt runner=subprocess");
                    Ok(value)
                }
                Err(err) => {
                    self.shared.borrow_mut().native(&format!(
                        "flow.two_step.stage1 encrypt runner=subprocess failed reason={err:#}"
                    ));
                    Err(err)
                }
            }
        } else {
            self.flow_encrypt_payload(stage1_value, cipher_mode, use_new_key, "flow.two_step.stage1")
        };
        let (stage1_ck_version, stage1_encrypted_ckey_hex, stage1_cipher_hex) = match stage1_encrypt
        {
            Ok(tuple) => tuple,
            Err(err) => {
                return json!({
                    "status": "blocked",
                    "reason": "stage1_encrypt_failed",
                    "error": err.to_string(),
                });
            }
        };
        let stage1_url_auth = self.derive_smssend_url_auth(opts);
        let stage1_smssend_url = build_two_step_stage1_smssend_url(
            stage2_control_feedback,
            opts,
            Some(&stage1_url_auth),
        );
        let stage1_feedback = build_data_to_control_feedback_with_url(
            stage1_value,
            &stage1_encrypted_ckey_hex,
            &stage1_cipher_hex,
            &stage1_ck_version,
            stage1_smssend_url.clone(),
        );
        let stage1_result = self.run_smssend_test_internal(
            &stage1_feedback,
            &stage1_cipher_hex,
            use_new_key,
            opts,
            true,
        );
        let stage1_result_code = stage1_result.get("result_code").and_then(Value::as_i64);
        let stage2_gate_pass = matches!(stage1_result_code, Some(1900 | 1901 | 202));
        let stage2_result = if stage2_gate_pass {
            self.run_smssend_test_internal(
                stage2_control_feedback,
                stage2_cipher_hex,
                use_new_key,
                opts,
                false,
            )
        } else {
            json!({
                "status": "blocked",
                "reason": "stage1_result_not_captcha_gate",
                "stage1_result_code": stage1_result_code,
                "stage2_expected": [1900, 1901, 202],
                "stage2_payload": stage2_value,
            })
        };
        json!({
            "status": "ok",
            "stage1_payload": stage1_value,
            "stage1_smssend_url": stage1_smssend_url,
            "stage1_encrypt": {
                "ck_version": stage1_ck_version,
                "encrypted_ckey_bytes": stage1_encrypted_ckey_hex.len() / 2,
                "cipher_bytes": stage1_cipher_hex.len() / 2,
                "cipher_sha256": hex::decode(&stage1_cipher_hex)
                    .ok()
                    .map(|bytes| sha256_hex_bytes(&bytes)),
            },
            "stage1_feedback": stage1_feedback,
            "stage1_result": stage1_result,
            "stage2_feedback": stage2_control_feedback,
            "stage2_result": stage2_result,
            "stage2_gate_pass": stage2_gate_pass,
            "gate_expected_result_codes": [1900, 1901, 202],
        })
    }

    fn build_runtime_mh_request_body_map(&self) -> Map<String, Value> {
        let profile = self.live_device_profile.as_ref();
        let (android_id, imei_value, mac_value, sdid_value, did_value, device_label) = {
            let state = self.identity_state.borrow();
            let imei = normalize_ac1_imei_candidate(Some(state.effective_imei()))
                .or_else(|| Some("Unknown".to_string()));
            let android_id = state.effective_android_id();
            let mac = state.effective_mac();
            let imei_segment = imei.clone().unwrap_or_else(|| "Unknown".to_string());
            let did = (!android_id.trim().is_empty())
                .then(|| format!("{imei_segment}_{}_{android_id}", mac.trim()));
            let sdid = if !state.effective_sdid().trim().is_empty() {
                state.effective_sdid()
            } else {
                state.effective_local_smid()
            };
            let device_label = normalize_device_label_candidate(Some(
                state.effective_device_label(),
            ))
            .or_else(|| {
                profile
                    .and_then(|value| normalize_device_label_candidate(value.device_label.clone()))
            });
            (android_id, imei, mac, sdid, did, device_label)
        };
        let channel_id = profile
            .and_then(|value| normalize_plain_candidate(value.channel_id.clone()))
            .unwrap_or_default();
        let version_code = profile
            .and_then(|value| normalize_plain_candidate(value.app_version_code.clone()))
            .unwrap_or_else(|| "unknown".to_string());
        let oaid = profile
            .and_then(|value| normalize_plain_candidate(value.oaid.clone()))
            .unwrap_or_default();
        let ip_info = profile
            .and_then(|value| normalize_plain_candidate(value.ip_info.clone()))
            .unwrap_or_default();

        let mut map = Map::new();
        map.insert("channelId".to_string(), Value::String(channel_id.clone()));
        if let Some(did) = did_value {
            map.insert("did".to_string(), Value::String(did));
        }
        map.insert("platform".to_string(), Value::String("android".to_string()));
        map.insert("versionCode".to_string(), Value::String(version_code));
        map.insert(
            "imei".to_string(),
            Value::String(imei_value.clone().unwrap_or_else(|| "Unknown".to_string())),
        );
        map.insert("mac".to_string(), Value::String(mac_value.clone()));
        map.insert("dhid".to_string(), Value::String(String::new()));
        map.insert("autoLogin".to_string(), Value::String("0".to_string()));
        map.insert("sdid".to_string(), Value::String(sdid_value));
        map.insert("oaid".to_string(), Value::String(oaid));
        map.insert("oneId".to_string(), Value::String(String::new()));

        let mut app_list_map = Map::new();
        let mut app_list_events = Vec::new();
        ensure_app_list_payload(
            &mut app_list_map,
            imei_value.as_deref(),
            Some(channel_id.as_str()),
            &self.config.package_name,
            profile
                .map(|value| value.installed_packages.as_slice())
                .filter(|packages| !packages.is_empty()),
            true,
            &mut app_list_events,
        );
        if let Some(value) = app_list_map.get("appList").and_then(Value::as_str) {
            map.insert("appList".to_string(), Value::String(value.to_string()));
        }

        let mut dfp_map = Map::new();
        dfp_map.insert(
            "imei".to_string(),
            imei_value.clone().map(Value::String).unwrap_or(Value::Null),
        );
        dfp_map.insert("mac".to_string(), Value::String(mac_value));
        let mut dfp_events = Vec::new();
        ensure_dfp_payload(
            &mut dfp_map,
            Some(android_id.as_str()),
            profile.and_then(|value| value.app_version_name.as_deref()),
            Some(&self.config.package_name),
            device_label.as_deref(),
            profile,
            &mut dfp_events,
        );
        if let Some(value) = dfp_map.get("dfp").and_then(Value::as_str) {
            map.insert("dfp".to_string(), Value::String(value.to_string()));
        }

        map.insert("appId".to_string(), Value::String("ZX0001".to_string()));
        map.insert("ipInfo".to_string(), Value::String(ip_info));
        map.insert("androidId".to_string(), Value::String(android_id));
        map
    }

    fn try_build_two_step_stage1_payload_via_producer(
        &mut self,
        stage2_value: &Value,
        stage2_control_feedback: &Value,
        stage1_override: Option<&Value>,
        opts: &HashMap<String, String>,
    ) -> Result<Value> {
        let stage1_url_auth = self.derive_smssend_url_auth(opts);
        let request_url = build_two_step_stage1_smssend_url(
            stage2_control_feedback,
            opts,
            Some(&stage1_url_auth),
        );
        let base_value = match self.try_capture_mh_base_request_body_via_producer(&request_url, opts)
        {
            Ok(value) => {
                self.shared.borrow_mut().native(&format!(
                    "producer stage1 base source=mh.a/sw4.d request_url={} keys={}",
                    request_url,
                    value.as_object().map(|obj| obj.len()).unwrap_or_default()
                ));
                value
            }
            Err(err) => {
                self.shared.borrow_mut().native(&format!(
                    "producer stage1 base fallback source=mh.mirror reason={err:#}"
                ));
                Value::Object(self.build_runtime_mh_request_body_map())
            }
        };
        let mut stage1_value = build_two_step_stage1_from_mh_base(&base_value, stage2_value);
        if let Some(ip_info) = self
            .live_device_profile
            .as_ref()
            .and_then(|profile| normalize_plain_candidate(profile.ip_info.clone()))
        {
            if let Value::Object(map) = &mut stage1_value {
                map.insert("ipInfo".to_string(), Value::String(ip_info));
            }
        }
        let producer_stage1_app_list = self.live_device_profile.as_ref().and_then(|profile| {
            let stage1_package_names = vec![self.config.package_name.clone()];
            let imei = {
                let state = self.identity_state.borrow();
                normalize_ac1_imei_candidate(Some(state.effective_imei()))
            };
            let channel_id = normalize_plain_candidate(profile.channel_id.clone())?;
            let mut map = Map::new();
            let mut events = Vec::new();
            ensure_app_list_payload(
                &mut map,
                imei.as_deref(),
                Some(channel_id.as_str()),
                &self.config.package_name,
                Some(stage1_package_names.as_slice()),
                true,
                &mut events,
            );
            map.get("appList")
                .and_then(Value::as_str)
                .map(|value| value.to_string())
        });
        if let Some(app_list) = producer_stage1_app_list {
            if let Value::Object(map) = &mut stage1_value {
                map.insert("appList".to_string(), Value::String(app_list));
            }
            self.shared
                .borrow_mut()
                .native("producer stage1 appList source=minimal_package_only");
        }
        apply_explicit_stage1_override(&mut stage1_value, stage1_override);
        self.shared.borrow_mut().native(&format!(
            "producer stage1 payload source=mh.base+stage2 request_url={} keys={}",
            request_url,
            stage1_value
                .as_object()
                .map(|obj| obj.len())
                .unwrap_or_default()
        ));
        Ok(stage1_value)
    }

    fn try_capture_mh_base_request_body_via_producer(
        &mut self,
        request_url: &str,
        opts: &HashMap<String, String>,
    ) -> Result<Value> {
        if std::env::var_os("PALMCHAT_MH_BASE_SKIP_SUBPROCESS").is_none() {
            match self.capture_mh_base_request_body_subprocess(request_url, opts) {
                Ok(value) => {
                    self.shared
                        .borrow_mut()
                        .native("producer stage1 capture runner=subprocess");
                    return Ok(value);
                }
                Err(err) => {
                    self.shared.borrow_mut().native(&format!(
                        "producer stage1 capture runner=subprocess failed reason={err:#}"
                    ));
                }
            }
        }

        if std::env::var_os("PALMCHAT_MH_BASE_FORCE_SECONDARY_RUNNER").is_none() {
            match self.capture_mh_base_request_body_inline(request_url) {
                Ok(value) => {
                    self.shared
                        .borrow_mut()
                        .native("producer stage1 capture runner=main");
                    return Ok(value);
                }
                Err(err) => {
                    self.shared.borrow_mut().native(&format!(
                        "producer stage1 capture runner=main failed reason={err:#}"
                    ));
                }
            }
        }

        let mut producer_config = self.config.clone();
        producer_config.trace_out_dir = self
            .config
            .trace_out_dir
            .join(format!("mh_base_runner_{}", current_timestamp_millis()));
        let previous_base_path = std::env::var_os("BASE_PATH");
        let previous_target_sdk = std::env::var_os("ANDROID_APP_TARGET_SDK");
        let result = (|| {
            let mut producer_lab = Self::load_from_config(producer_config)?;
            producer_lab.capture_mh_base_request_body_inline(request_url)
        })();
        if let Some(value) = previous_base_path {
            std::env::set_var("BASE_PATH", value);
        } else {
            std::env::remove_var("BASE_PATH");
        }
        if let Some(value) = previous_target_sdk {
            std::env::set_var("ANDROID_APP_TARGET_SDK", value);
        } else {
            std::env::remove_var("ANDROID_APP_TARGET_SDK");
        }
        result
    }

    fn capture_mh_base_request_body_subprocess(
        &mut self,
        request_url: &str,
        opts: &HashMap<String, String>,
    ) -> Result<Value> {
        let exe = std::env::current_exe().context("failed to resolve current executable path")?;
        let json_out_path = self.config.trace_out_dir.join(format!(
            "mh_base_subprocess_{}.json",
            current_timestamp_millis()
        ));
        let mut cmd = Command::new(exe);
        cmd.arg("palmchat").arg("invoke");
        cmd.arg("--config")
            .arg(opts.get("--config").cloned().unwrap_or_else(default_config_path));
        if let Some(backend) = opts.get("--backend") {
            cmd.arg("--backend").arg(backend);
        } else {
            cmd.arg("--backend").arg(self.emulator.backend.name());
        }
        cmd.arg("--method").arg("mhBaseArgs");
        cmd.arg("--arg1").arg(request_url);
        cmd.arg("--json-out").arg(&json_out_path);
        for key in [
            "--privacy-agree",
            "--read-phone-state",
            "--priv-info-init",
            "--android-id",
            "--imei",
            "--mac",
            "--process-name",
            "--seed-device-id",
            "--seed-local-smid",
            "--seed-dhid",
            "--seed-sdid",
            "--seed-imei",
            "--seed-mac",
            "--seed-oneid",
            "--seed-oaid",
            "--seed-android-id",
            "--seed-channel-id",
            "--seed-appid",
            "--seed-ip-info",
            "--seed-device-label",
            "--secret-key",
            "--secret-iv",
        ] {
            if let Some(value) = opts.get(key) {
                cmd.arg(key).arg(value);
            }
        }
        let output = cmd
            .output()
            .context("failed to spawn subprocess mhBaseArgs observation")?;
        if !output.status.success() {
            let stderr = String::from_utf8_lossy(&output.stderr);
            let stdout = String::from_utf8_lossy(&output.stdout);
            return Err(anyhow!(
                "subprocess mhBaseArgs failed: status={} stderr={} stdout={}",
                output.status,
                stderr.trim(),
                stdout.trim()
            ));
        }
        let output_value = read_json_file(&json_out_path)
            .with_context(|| format!("failed to read subprocess output {:?}", json_out_path))?;
        let body_json = output_value
            .get("body_json")
            .cloned()
            .ok_or_else(|| anyhow!("subprocess mhBaseArgs missing body_json"))?;
        match body_json {
            Value::Object(_) => Ok(body_json),
            other => Err(anyhow!(
                "unexpected subprocess mhBaseArgs body_json type: {other}"
            )),
        }
    }

    fn capture_mh_base_request_body_inline(&mut self, request_url: &str) -> Result<Value> {
        let app_context = self.app_context_object()?;
        let _ = self.call_java_instance(
            "com/zenmen/palmchat/privinfo/PrivInfoManager",
            "init",
            "(Landroid/content/Context;)V",
            vec![app_context.clone().into()],
        )?;
        let _ = self.call_java_static(
            "defpackage/ac1",
            "B",
            "(Landroid/content/Context;)V",
            vec![app_context.clone().into()],
        )?;
        let _ = self.call_java_instance(
            "defpackage/ts0",
            "I",
            "(Landroid/content/Context;)V",
            vec![app_context.into()],
        )?;
        let sw4_value = self.call_java_static(
            "defpackage/mh",
            "a",
            "(Ljava/lang/String;)Ldefpackage/sw4;",
            vec![request_url.to_string().into()],
        )?;
        let JniValue::Object(sw4_object) = sw4_value else {
            return Err(anyhow!(
                "unexpected mh.a return type: {}",
                describe_jni_value(&sw4_value)
            ));
        };
        let sw4_body_value = self.call_java_method_on_object(
            "defpackage/sw4",
            &sw4_object,
            "d",
            "()Lorg/json/JSONObject;",
            vec![],
        )?;
        let emulator = self.emulator.clone();
        let vm = emulator.get_dalvik_vm();
        let sw4_body_json = jni_value_to_json_value_with_vm(vm, &sw4_body_value);
        match sw4_body_json {
            Some(Value::Object(body)) => Ok(Value::Object(body)),
            Some(Value::Null) | None => Err(anyhow!("mh.a(...).d() returned null")),
            Some(other) => Err(anyhow!("unexpected mh.a(...).d() json type: {other}")),
        }
    }

    fn run_invoke(&mut self, opts: &HashMap<String, String>) -> Result<Value> {
        self.reset_identity_probe_state(opts);
        let method = required_option(opts, "--method")?;
        let arg1 = opts.get("--arg1").cloned().unwrap_or_default();
        let arg2 = opts.get("--arg2").cloned().unwrap_or_default();
        let arg3 = opts.get("--arg3").cloned().unwrap_or_default();

        let output = match method.as_str() {
            "skeyAvailable" => {
                let value = self.call_static("skeyAvailable", "()Z", vec![])?;
                json!({
                    "method": method,
                    "output_bool": jni_value_to_bool(value)?,
                })
            }
            "wksecA" => {
                let value = self.call_java_static("com/wifi/open/sec/WKSec", "a", "()I", vec![])?;
                json!({
                    "method": method,
                    "output_int": jni_value_to_int(value)?,
                })
            }
            "wksecC" => {
                let value = self.call_java_static("com/wifi/open/sec/WKSec", "c", "()Z", vec![])?;
                json!({
                    "method": method,
                    "output_bool": jni_value_to_bool(value)?,
                })
            }
            "ac1AppList" => {
                let _ = self.capture_app_init_upstream_observation();
                let app_context = self.app_context_object()?;
                let _ = self.call_java_static(
                    "defpackage/ac1",
                    "B",
                    "(Landroid/content/Context;)V",
                    vec![app_context.into()],
                )?;
                let value =
                    self.call_java_static("defpackage/ac1", "s", "()Ljava/lang/String;", vec![])?;
                json!({
                    "method": method,
                    "output": jni_value_to_string(value)?,
                })
            }
            "fm1Dfp" => {
                let _ = self.capture_app_init_upstream_observation();
                let app_context = self.app_context_object()?;
                let _ = self.call_java_static(
                    "defpackage/ac1",
                    "B",
                    "(Landroid/content/Context;)V",
                    vec![app_context.into()],
                )?;
                let value = self.call_java_static(
                    "defpackage/fm1",
                    "k",
                    "()Lorg/json/JSONObject;",
                    vec![],
                )?;
                let JniValue::Object(object) = value else {
                    return Err(anyhow!(
                        "unexpected fm1.k return type: {}",
                        describe_jni_value(&value)
                    ));
                };
                let rendered = self.call_java_method_on_object(
                    "org/json/JSONObject",
                    &object,
                    "toString",
                    "()Ljava/lang/String;",
                    vec![],
                )?;
                json!({
                    "method": method,
                    "output": jni_value_to_string(rendered)?,
                })
            }
            "createCKey" => {
                let _ = self.call_static("createCKey", "()V", vec![])?;
                json!({
                    "method": method,
                    "output": "ok",
                })
            }
            "setSecretKeys" => {
                self.call_messaging_static(
                    "setSecretKeys",
                    "(Ljava/lang/String;Ljava/lang/String;)V",
                    vec![arg1.clone().into(), arg2.clone().into()],
                )?;
                json!({
                    "method": method,
                    "arg1_key": arg1,
                    "arg2_iv": arg2,
                    "output": "ok",
                })
            }
            "getCkVersion" => {
                let value = self.call_static("getCkVersion", "()Ljava/lang/String;", vec![])?;
                json!({
                    "method": method,
                    "output": jni_value_to_string(value)?,
                })
            }
            "ckDiag" => {
                let raw = arg1.trim();
                self.run_ckdiag((!raw.is_empty()).then_some(raw))?
            }
            "appInitProbe" => self.run_app_init_probe(opts)?,
            "gateProbe" => self.run_gate_probe(opts)?,
            "producerInitProbe" => {
                let app_context = self.app_context_object()?;
                let _ = self.call_java_instance(
                    "com/zenmen/palmchat/privinfo/PrivInfoManager",
                    "init",
                    "(Landroid/content/Context;)V",
                    vec![app_context.clone().into()],
                )?;
                let oauth_result = self.call_java_static(
                    "com/lantern/auth/openapi/OAuthApi",
                    "onAppCreate",
                    "()V",
                    vec![],
                );
                let _ = self.call_java_instance(
                    "com/zenmen/palmchat/AppContext",
                    "initFramework",
                    "()V",
                    vec![],
                )?;
                let _ = self.call_java_instance(
                    "com/zenmen/palmchat/AppContext",
                    "initDeviceInfos",
                    "(Landroid/content/Context;)V",
                    vec![app_context.clone().into()],
                )?;
                let app_list =
                    self.call_java_static("defpackage/ac1", "s", "()Ljava/lang/String;", vec![])?;
                let fm1_value = self.call_java_static(
                    "defpackage/fm1",
                    "k",
                    "()Lorg/json/JSONObject;",
                    vec![],
                )?;
                let fm1_output = match fm1_value {
                    JniValue::Object(object) => {
                        let rendered = self.call_java_method_on_object(
                            "org/json/JSONObject",
                            &object,
                            "toString",
                            "()Ljava/lang/String;",
                            vec![],
                        )?;
                        Some(jni_value_to_string(rendered)?)
                    }
                    JniValue::Null => None,
                    other => {
                        return Err(anyhow!(
                            "unexpected fm1.k return type after init: {}",
                            describe_jni_value(&other)
                        ));
                    }
                };
                json!({
                    "method": method,
                    "oauth_on_app_create": oauth_result.is_ok(),
                    "ac1_app_list": jni_value_to_string(app_list)?,
                    "fm1_dfp": fm1_output,
                })
            }
            "mhBaseArgs" => {
                let request_url = if arg1.trim().is_empty() {
                    format!(
                        "https://short.lianxinapp.com/one/ax/auth.login.by.sendsms?requestId={}&deviceId={}",
                        generate_xn3_like_id(),
                        self.live_device_profile
                            .as_ref()
                            .and_then(|profile| normalize_device_id_candidate(profile.tray_device_id.clone()))
                            .unwrap_or_else(generate_xn3_like_id)
                    )
                } else {
                    arg1.clone()
                };
                let sw4_body_json = self.capture_mh_base_request_body_inline(&request_url)?;
                json!({
                    "method": method,
                    "request_url": request_url,
                    "body_json": sw4_body_json.clone(),
                    "body_string": sw4_body_json.to_string(),
                    "app_list": self
                        .call_java_static("defpackage/ac1", "s", "()Ljava/lang/String;", vec![])
                        .ok()
                    .and_then(|value| jni_value_to_string(value).ok()),
                })
            }
            "flowEncrypt" => {
                let raw = if arg1.trim().is_empty() {
                    "{}".to_string()
                } else {
                    arg1.clone()
                };
                let cipher_mode = arg2.parse::<i32>().unwrap_or(2);
                let use_new_key = parse_bool_like(&arg3);
                self.apply_secret_keys_from_opts(opts, "invoke.flowEncrypt")?;
                let payload = serde_json::from_str::<Value>(&raw)
                    .unwrap_or_else(|_| Value::String(raw.clone()));
                let (ck_version, encrypted_ckey_hex, cipher_hex) = self.flow_encrypt_payload(
                    &payload,
                    cipher_mode,
                    use_new_key,
                    "invoke.flowEncrypt",
                )?;
                json!({
                    "method": method,
                    "arg1_json": payload,
                    "arg2_mode": cipher_mode,
                    "arg3_bool": use_new_key,
                    "ck_version": ck_version,
                    "encrypted_ckey_hex": encrypted_ckey_hex,
                    "cipher_hex": cipher_hex,
                })
            }
            "getEncryptedCKey" => {
                let use_new_key = parse_bool_like(&arg1);
                let value =
                    self.call_static("getEncryptedCKey", "(Z)[B", vec![use_new_key.into()])?;
                let bytes = {
                    let emulator = self.emulator.clone();
                    let vm = emulator.get_dalvik_vm();
                    jni_value_to_bytes_with_vm(vm, value)?
                };
                json!({
                    "method": method,
                    "arg1_bool": use_new_key,
                    "output_hex": hex::encode(&bytes),
                    "output_utf8": String::from_utf8_lossy(&bytes),
                })
            }
            "setLxData" => {
                let raw = if arg1.trim().is_empty() {
                    "{}".to_string()
                } else {
                    arg1
                };
                let json_obj = self.make_json_object(&raw)?;
                let _ = self.call_static(
                    "setLxData",
                    "(Lorg/json/JSONObject;)V",
                    vec![json_obj.into()],
                )?;
                json!({
                    "method": method,
                    "arg1_json": serde_json::from_str::<Value>(&raw).unwrap_or(Value::String(raw)),
                    "output": "ok",
                })
            }
            "cipherWithHashKey" => {
                let raw = if arg1.trim().is_empty() {
                    "{}".to_string()
                } else {
                    arg1
                };
                let cipher_mode = arg2.parse::<i32>().unwrap_or(2);
                let use_new_key = parse_bool_like(&arg3);
                let json_obj = self.make_json_object(&raw)?;
                let value = self.call_static(
                    "cipherWithHashKey",
                    "(Lorg/json/JSONObject;IZ)[B",
                    vec![json_obj.into(), cipher_mode.into(), use_new_key.into()],
                )?;
                let return_debug = describe_jni_value(&value);
                match jni_value_to_bytes(value) {
                    Ok(bytes) => json!({
                        "method": method,
                        "arg1_json": serde_json::from_str::<Value>(&raw).unwrap_or(Value::String(raw)),
                        "arg2_mode": cipher_mode,
                        "arg3_bool": use_new_key,
                        "return_debug": return_debug,
                        "output_hex": hex::encode(&bytes),
                        "output_utf8": String::from_utf8_lossy(&bytes),
                    }),
                    Err(err) => json!({
                        "method": method,
                        "arg1_json": serde_json::from_str::<Value>(&raw).unwrap_or(Value::String(raw)),
                        "arg2_mode": cipher_mode,
                        "arg3_bool": use_new_key,
                        "return_debug": return_debug,
                        "output_hex": "",
                        "output_utf8": "",
                        "output_null": true,
                        "error": err.to_string(),
                    }),
                }
            }
            "cipherWithType" => {
                let input_bytes = parse_arg_bytes(&arg1)?;
                let cipher_mode = arg2.parse::<i32>().unwrap_or(4);
                let use_new_key = parse_bool_like(&arg3);
                if let (Some(secret_key), Some(secret_iv)) =
                    (opts.get("--secret-key"), opts.get("--secret-iv"))
                {
                    self.call_messaging_static(
                        "setSecretKeys",
                        "(Ljava/lang/String;Ljava/lang/String;)V",
                        vec![secret_key.clone().into(), secret_iv.clone().into()],
                    )?;
                }
                let value = self.call_static(
                    "cipherWithType",
                    "([BIZ)[B",
                    vec![
                        JniValue::Object(DvmObject::ByteArray(input_bytes.clone())),
                        cipher_mode.into(),
                        use_new_key.into(),
                    ],
                )?;
                let return_debug = describe_jni_value(&value);
                match jni_value_to_bytes(value) {
                    Ok(bytes) => json!({
                        "method": method,
                        "arg1_len": input_bytes.len(),
                        "arg1_hex": hex::encode(&input_bytes),
                        "arg1_utf8": String::from_utf8_lossy(&input_bytes),
                        "arg2_mode": cipher_mode,
                        "arg3_bool": use_new_key,
                        "return_debug": return_debug,
                        "output_hex": hex::encode(&bytes),
                        "output_utf8": String::from_utf8_lossy(&bytes),
                    }),
                    Err(err) => json!({
                        "method": method,
                        "arg1_len": input_bytes.len(),
                        "arg1_hex": hex::encode(&input_bytes),
                        "arg1_utf8": String::from_utf8_lossy(&input_bytes),
                        "arg2_mode": cipher_mode,
                        "arg3_bool": use_new_key,
                        "return_debug": return_debug,
                        "output_hex": "",
                        "output_utf8": "",
                        "output_null": true,
                        "error": err.to_string(),
                    }),
                }
            }
            _ => {
                return Err(anyhow!(
                    "unsupported method: {method}; supported=skeyAvailable|wksecA|wksecC|ac1AppList|fm1Dfp|producerInitProbe|mhBaseArgs|flowEncrypt|createCKey|setSecretKeys|getCkVersion|ckDiag|appInitProbe|gateProbe|getEncryptedCKey|setLxData|cipherWithHashKey|cipherWithType"
                ));
            }
        };

        self.shared
            .borrow_mut()
            .native(&format!("invoke result={}", output));
        Ok(output)
    }

    fn normalize_flow_arg1_json(&self, raw: &str, phase: &str) -> (String, Value) {
        let mut value =
            serde_json::from_str::<Value>(raw).unwrap_or(Value::String(raw.to_string()));
        let mut changed_fields = Vec::new();
        let preserve_existing_new_sms_version_code = phase.contains("bridge_stage1");

        if let Value::Object(map) = &mut value {
            apply_app_version_normalization(
                map,
                &self.app_version_info,
                preserve_existing_new_sms_version_code,
                &mut changed_fields,
            );
        } else if self.app_version_info.version_code.is_some()
            || self.app_version_info.version_name.is_some()
        {
            self.shared.borrow_mut().native(&format!(
                "{phase} app version normalize skipped reason=non_object_json source={}",
                self.app_version_info.source.as_deref().unwrap_or("unknown")
            ));
        }

        if !changed_fields.is_empty() {
            self.shared.borrow_mut().native(&format!(
                "{phase} app version normalized source={} changes=[{}]",
                self.app_version_info.source.as_deref().unwrap_or("unknown"),
                changed_fields.join(", ")
            ));
        }

        let normalized_raw = match &value {
            Value::Object(_) => value.to_string(),
            _ => raw.to_string(),
        };
        (normalized_raw, value)
    }

    fn run_flow(&mut self, opts: &HashMap<String, String>) -> Result<Value> {
        let raw = opts
            .get("--arg1")
            .cloned()
            .filter(|value| !value.trim().is_empty())
            .unwrap_or_else(|| "{}".to_string());
        let cipher_mode = opts
            .get("--arg2")
            .and_then(|value| value.parse::<i32>().ok())
            .unwrap_or(2);
        let use_new_key = opts
            .get("--arg3")
            .map(|value| parse_bool_like(value))
            .unwrap_or(false);

        let (mut normalized_raw, mut json_value) = self.normalize_flow_arg1_json(&raw, "flow");
        let ip_info_preflight = self.refresh_ip_info_preflight(&mut json_value, opts, "flow");
        if ip_info_preflight
            .as_ref()
            .and_then(|value| value.get("status"))
            .and_then(Value::as_str)
            == Some("ok")
        {
            normalized_raw = json_value.to_string();
        }
        let no_empty_params = opts
            .get("--no-empty-params")
            .map(|value| parse_bool_like(value))
            .unwrap_or(false);
        let mut empty_param_cleanup = Vec::<String>::new();
        if no_empty_params {
            let identity_imei_seed =
                normalize_device_id_candidate(Some(self.identity_state.borrow().effective_imei()));
            let identity_android_seed = normalize_plain_candidate(Some(
                self.identity_state.borrow().effective_android_id(),
            ));
            let identity_sdid_seed =
                normalize_device_id_candidate(Some(self.identity_state.borrow().effective_sdid()));
            let live_profile_oaid_seed = self
                .live_device_profile
                .as_ref()
                .and_then(|profile| normalize_plain_candidate(profile.oaid.clone()));
            let live_profile_channel_seed = self
                .live_device_profile
                .as_ref()
                .and_then(|profile| normalize_plain_candidate(profile.channel_id.clone()));
            if let Value::Object(map) = &mut json_value {
                let new_sms_profile = is_new_sms_v7_profile(map);
                let did_segments = map
                    .get("did")
                    .and_then(Value::as_str)
                    .unwrap_or_default()
                    .split('_')
                    .map(str::to_string)
                    .collect::<Vec<_>>();
                let did_imei = did_segments
                    .get(0)
                    .map(|v| v.trim().to_string())
                    .and_then(|v| normalize_device_id_candidate(Some(v)));
                let did_mac = did_segments
                    .get(1)
                    .map(|v| v.trim().to_string())
                    .and_then(|v| normalize_plain_candidate(Some(v)));
                let did_android_id = did_segments
                    .get(2)
                    .map(|v| v.trim().to_string())
                    .and_then(|v| normalize_plain_candidate(Some(v)));
                let app_list_value = parse_json_string_or_object(map.get("appList"));
                let app_list_obj = app_list_value.as_ref().and_then(Value::as_object);
                let app_list_imei = app_list_obj
                    .and_then(|obj| extract_non_empty_string(obj, "imei"))
                    .and_then(|v| normalize_device_id_candidate(Some(v)));
                let persistent_device_seed = opts
                    .get("--seed-device-id")
                    .cloned()
                    .or_else(|| extract_non_empty_string(map, "device_id"))
                    .or_else(|| extract_non_empty_string(map, "sdid"))
                    .or_else(|| extract_non_empty_string(map, "local_smid"))
                    .and_then(|v| normalize_device_id_candidate(Some(v)));
                let runtime_device_seed = opts
                    .get("--seed-dhid")
                    .cloned()
                    .or_else(|| opts.get("--device-id").cloned())
                    .or_else(|| extract_non_empty_string(map, "dhid"))
                    .or_else(|| extract_non_empty_string(map, "oneId"))
                    .and_then(|v| normalize_plain_candidate(Some(v)));
                let fallback_persistent_device_seed =
                    persistent_device_seed.clone().or_else(|| {
                        extract_non_empty_string(map, "oaid")
                            .and_then(|v| normalize_device_id_candidate(Some(v)))
                    });
                let local_smid_seed = opts
                    .get("--seed-local-smid")
                    .cloned()
                    .or_else(|| extract_non_empty_string(map, "local_smid"))
                    .or_else(|| {
                        if new_sms_profile {
                            None
                        } else {
                            fallback_persistent_device_seed
                                .clone()
                                .map(|v| format!("YX{v}"))
                        }
                    })
                    .and_then(|v| normalize_plain_candidate(Some(v)));
                let dhid_seed = opts
                    .get("--seed-dhid")
                    .cloned()
                    .or_else(|| extract_non_empty_string(map, "dhid"))
                    .or_else(|| {
                        if new_sms_profile {
                            None
                        } else {
                            runtime_device_seed.clone()
                        }
                    })
                    .and_then(|v| normalize_plain_candidate(Some(v)));
                let channel_id_seed = extract_non_empty_string(map, "channelId")
                    .or_else(|| opts.get("--seed-channel-id").cloned())
                    .or_else(|| {
                        app_list_obj.and_then(|obj| extract_non_empty_string(obj, "channelId"))
                    })
                    .or(live_profile_channel_seed.clone())
                    .and_then(|v| normalize_plain_candidate(Some(v)));
                let live_profile_ip_info_seed = self
                    .live_device_profile
                    .as_ref()
                    .and_then(|profile| normalize_plain_candidate(profile.ip_info.clone()));
                let android_id_seed = extract_non_empty_string(map, "androidId")
                    .or_else(|| opts.get("--seed-android-id").cloned())
                    .or(did_android_id)
                    .or(identity_android_seed)
                    .and_then(|v| normalize_plain_candidate(Some(v)));
                let imei_seed = opts
                    .get("--seed-imei")
                    .cloned()
                    .or_else(|| extract_non_empty_string(map, "imei"))
                    .or(app_list_imei)
                    .or(did_imei)
                    .or(identity_imei_seed)
                    .or_else(|| {
                        if new_sms_profile {
                            None
                        } else {
                            fallback_persistent_device_seed
                                .as_deref()
                                .map(derive_synthetic_imei)
                        }
                    })
                    .and_then(|v| normalize_device_id_candidate(Some(v)));
                let mac_seed = opts
                    .get("--seed-mac")
                    .cloned()
                    .or_else(|| extract_non_empty_string(map, "mac"))
                    .or(did_mac)
                    .or_else(|| {
                        if new_sms_profile {
                            None
                        } else {
                            Some("02:00:00:00:00:00".to_string())
                        }
                    })
                    .and_then(|v| normalize_plain_candidate(Some(v)));
                let one_id_seed = opts
                    .get("--seed-oneid")
                    .cloned()
                    .or_else(|| extract_non_empty_string(map, "oneId"))
                    .or_else(|| {
                        if new_sms_profile {
                            None
                        } else {
                            runtime_device_seed.clone()
                        }
                    })
                    .and_then(|v| normalize_plain_candidate(Some(v)));
                let sdid_seed = extract_non_empty_string(map, "sdid")
                    .or_else(|| opts.get("--seed-sdid").cloned())
                    .or(identity_sdid_seed.clone())
                    .or(persistent_device_seed.clone())
                    .and_then(|v| normalize_plain_candidate(Some(v)));
                let oaid_seed = extract_non_empty_string(map, "oaid")
                    .or_else(|| opts.get("--seed-oaid").cloned())
                    .or(live_profile_oaid_seed.clone())
                    .or_else(|| {
                        fallback_persistent_device_seed
                            .as_deref()
                            .map(derive_hex_token_from_seed)
                    })
                    .and_then(|v| normalize_plain_candidate(Some(v)));
                let app_id_seed = extract_non_empty_string(map, "appId")
                    .or_else(|| opts.get("--seed-appid").cloned())
                    .or_else(|| Some("ZX0001".to_string()))
                    .and_then(|v| normalize_plain_candidate(Some(v)));
                let platform_seed = extract_non_empty_string(map, "platform")
                    .or_else(|| Some("android".to_string()))
                    .and_then(|v| normalize_plain_candidate(Some(v)));
                let country_code_seed = extract_non_empty_string(map, "countryCode")
                    .or_else(|| Some("86".to_string()))
                    .and_then(|v| normalize_plain_candidate(Some(v)));
                let auto_login_seed = extract_non_empty_string(map, "autoLogin")
                    .or_else(|| Some("0".to_string()))
                    .and_then(|v| normalize_plain_candidate(Some(v)));
                let dfp_seed = extract_non_empty_string(map, "dfp")
                    .or_else(|| Some("{}".to_string()))
                    .and_then(|v| normalize_plain_candidate(Some(v)));
                let ip_info_seed = extract_non_empty_string(map, "ipInfo")
                    .or_else(|| opts.get("--seed-ip-info").cloned())
                    .or(live_profile_ip_info_seed.clone())
                    .or_else(|| Some("{}".to_string()))
                    .and_then(|v| normalize_plain_candidate(Some(v)));
                force_override_with_seed(
                    map,
                    "device_id",
                    if new_sms_profile {
                        None
                    } else {
                        opts.get("--seed-device-id").cloned()
                    },
                    &mut empty_param_cleanup,
                );
                force_override_with_seed(
                    map,
                    "local_smid",
                    if new_sms_profile {
                        None
                    } else {
                        opts.get("--seed-local-smid").cloned()
                    },
                    &mut empty_param_cleanup,
                );
                force_override_with_seed(
                    map,
                    "dhid",
                    opts.get("--seed-dhid").cloned(),
                    &mut empty_param_cleanup,
                );
                force_override_with_seed(
                    map,
                    "sdid",
                    opts.get("--seed-sdid").cloned(),
                    &mut empty_param_cleanup,
                );
                force_override_with_seed(
                    map,
                    "imei",
                    opts.get("--seed-imei").cloned(),
                    &mut empty_param_cleanup,
                );
                force_override_with_seed(
                    map,
                    "mac",
                    opts.get("--seed-mac").cloned(),
                    &mut empty_param_cleanup,
                );
                force_override_with_seed(
                    map,
                    "oneId",
                    opts.get("--seed-oneid").cloned(),
                    &mut empty_param_cleanup,
                );
                force_override_with_seed(
                    map,
                    "oaid",
                    opts.get("--seed-oaid").cloned(),
                    &mut empty_param_cleanup,
                );
                force_override_with_seed(
                    map,
                    "androidId",
                    opts.get("--seed-android-id").cloned(),
                    &mut empty_param_cleanup,
                );
                force_override_with_seed(
                    map,
                    "channelId",
                    opts.get("--seed-channel-id").cloned(),
                    &mut empty_param_cleanup,
                );
                force_override_with_seed(
                    map,
                    "appId",
                    opts.get("--seed-appid").cloned(),
                    &mut empty_param_cleanup,
                );
                force_override_with_seed(
                    map,
                    "ipInfo",
                    opts.get("--seed-ip-info").cloned(),
                    &mut empty_param_cleanup,
                );
                if !new_sms_profile {
                    fill_or_override_if_null_like(
                        map,
                        "device_id",
                        fallback_persistent_device_seed.clone(),
                        &mut empty_param_cleanup,
                    );
                    fill_or_override_if_null_like(
                        map,
                        "local_smid",
                        local_smid_seed,
                        &mut empty_param_cleanup,
                    );
                    fill_or_override_if_null_like(
                        map,
                        "dhid",
                        dhid_seed.clone(),
                        &mut empty_param_cleanup,
                    );
                    fill_or_override_if_null_like(
                        map,
                        "imei",
                        imei_seed.clone(),
                        &mut empty_param_cleanup,
                    );
                    fill_or_override_if_null_like(
                        map,
                        "mac",
                        mac_seed.clone(),
                        &mut empty_param_cleanup,
                    );
                    fill_or_override_if_null_like(
                        map,
                        "oneId",
                        one_id_seed.clone(),
                        &mut empty_param_cleanup,
                    );
                }
                fill_or_override_if_null_like(map, "sdid", sdid_seed, &mut empty_param_cleanup);
                fill_or_override_if_null_like(map, "oaid", oaid_seed, &mut empty_param_cleanup);
                fill_or_override_if_null_like(map, "appId", app_id_seed, &mut empty_param_cleanup);
                fill_or_override_if_null_like(
                    map,
                    "platform",
                    platform_seed,
                    &mut empty_param_cleanup,
                );
                fill_or_override_if_null_like(
                    map,
                    "countryCode",
                    country_code_seed,
                    &mut empty_param_cleanup,
                );
                fill_or_override_if_null_like(
                    map,
                    "autoLogin",
                    auto_login_seed,
                    &mut empty_param_cleanup,
                );
                fill_or_override_if_null_like(
                    map,
                    "channelId",
                    channel_id_seed,
                    &mut empty_param_cleanup,
                );
                fill_or_override_if_null_like(
                    map,
                    "androidId",
                    android_id_seed,
                    &mut empty_param_cleanup,
                );
                fill_or_override_if_null_like(map, "dfp", dfp_seed, &mut empty_param_cleanup);
                fill_or_override_if_null_like(
                    map,
                    "ipInfo",
                    ip_info_seed,
                    &mut empty_param_cleanup,
                );
                if new_sms_profile {
                    fill_or_override_null_like_value(
                        map,
                        "imei",
                        imei_seed.clone().map(Value::String).unwrap_or(Value::Null),
                        &mut empty_param_cleanup,
                    );
                    fill_or_override_null_like_value(
                        map,
                        "mac",
                        Value::String(mac_seed.clone().unwrap_or_default()),
                        &mut empty_param_cleanup,
                    );
                    fill_or_override_null_like_value(
                        map,
                        "dhid",
                        Value::String(dhid_seed.clone().unwrap_or_default()),
                        &mut empty_param_cleanup,
                    );
                    fill_or_override_null_like_value(
                        map,
                        "oneId",
                        Value::String(one_id_seed.clone().unwrap_or_default()),
                        &mut empty_param_cleanup,
                    );
                }
                if map_value_missing_or_null_like(map, "paramNum") {
                    map.insert("paramNum".to_string(), json!(4));
                    empty_param_cleanup.push("paramNum=4".to_string());
                }
                let final_imei = extract_non_empty_string(map, "imei")
                    .and_then(|v| normalize_device_id_candidate(Some(v)));
                if let Some(recomputed_did) = recompute_nullable_did(map) {
                    let current_did = map
                        .get("did")
                        .and_then(Value::as_str)
                        .map(str::to_string)
                        .unwrap_or_default();
                    if current_did != recomputed_did {
                        map.insert("did".to_string(), Value::String(recomputed_did.clone()));
                        empty_param_cleanup.push(format!("did={recomputed_did}"));
                    }
                }
                let app_list_channel_id = map
                    .get("channelId")
                    .and_then(Value::as_str)
                    .map(|v| v.to_string());
                ensure_app_list_payload(
                    map,
                    final_imei.as_deref(),
                    app_list_channel_id.as_deref(),
                    &self.config.package_name,
                    self.live_device_profile
                        .as_ref()
                        .map(|profile| profile.installed_packages.as_slice())
                        .filter(|packages| !packages.is_empty()),
                    new_sms_profile || opts.contains_key("--seed-channel-id"),
                    &mut empty_param_cleanup,
                );
                let dfp_android_id = map
                    .get("androidId")
                    .and_then(Value::as_str)
                    .map(|value| value.to_string());
                ensure_dfp_payload(
                    map,
                    dfp_android_id.as_deref(),
                    self.app_version_info.version_name.as_deref(),
                    Some(&self.config.package_name),
                    opts.get("--seed-device-label")
                        .map(String::as_str)
                        .or_else(|| {
                            self.live_device_profile
                                .as_ref()
                                .and_then(|profile| profile.device_label.as_deref())
                        }),
                    self.live_device_profile.as_ref(),
                    &mut empty_param_cleanup,
                );
                if new_sms_profile {
                    prune_new_sms_auto_noise_fields(map, &mut empty_param_cleanup);
                }
                let required_keys = v7_required_non_empty_keys(map);
                let unresolved = collect_null_like_keys(map, &required_keys);
                if !unresolved.is_empty() {
                    self.shared.borrow_mut().native(&format!(
                        "flow no-empty-params unresolved=[{}]",
                        unresolved.join(", ")
                    ));
                    return Err(anyhow!(
                        "no-empty-params unresolved required fields: {}",
                        unresolved.join(", ")
                    ));
                }
                if !empty_param_cleanup.is_empty() {
                    normalized_raw = json_value.to_string();
                    self.shared.borrow_mut().native(&format!(
                        "flow no-empty-params filled=[{}]",
                        empty_param_cleanup.join(", ")
                    ));
                }
            }
        }
        let bridge_stage1_value = opts
            .get("--bridge-stage1-json")
            .map(|value| self.normalize_flow_arg1_json(value, "flow.bridge_stage1").1);
        let v7_captcha_bridge_surface =
            build_v7_captcha_bridge_surface(bridge_stage1_value.as_ref(), &json_value);
        let v7_base_field_production = build_v7_base_field_production(&json_value);
        let v7_identity_dependency_graph = build_v7_identity_dependency_graph(&json_value);
        let v7_identity_gate_diagnostics = build_v7_identity_gate_diagnostics();
        self.sync_identity_state_from_effective_body(&json_value, opts);
        let app_init_upstream_observation = self.capture_app_init_upstream_observation()?;
        let v7_captcha_upstream_production =
            build_v7_captcha_upstream_production(bridge_stage1_value.as_ref(), &json_value);
        let v7_retry_payload_views =
            build_v7_retry_payload_views(bridge_stage1_value.as_ref(), &json_value);
        let v7_captcha_business_surface =
            build_v7_captcha_business_surface(bridge_stage1_value.as_ref(), &json_value);
        let palmchat_project_planes = build_palmchat_project_planes(
            &json_value,
            &app_init_upstream_observation,
            &v7_captcha_business_surface,
        );
        let mut effective_opts = opts.clone();
        let secret_keys_seeded = self.apply_secret_keys_from_opts(&effective_opts, "flow")?;
        let auth_bootstrap = self.ensure_stage1_auth_bootstrap(&effective_opts, "flow")?;
        let smssend_url_injected = if let Value::Object(stage2_obj) = &json_value {
            let empty = Map::new();
            let stage1_obj = bridge_stage1_value
                .as_ref()
                .and_then(Value::as_object)
                .unwrap_or(&empty);
            let smssend_url_auth = self.derive_smssend_url_auth(&effective_opts);
            prepare_smssend_test_url_opts(
                stage1_obj,
                stage2_obj,
                &mut effective_opts,
                Some(&smssend_url_auth),
                self.live_device_profile.as_ref(),
            )
        } else {
            None
        };
        if let Some(injected) = smssend_url_injected.as_ref() {
            self.shared.borrow_mut().native(&format!(
                "flow smssend url injected strategy={}",
                injected
                    .get("strategy")
                    .and_then(Value::as_str)
                    .unwrap_or("unknown")
            ));
        }
        let json_obj = self.make_json_object(&normalized_raw)?;
        self.shared.borrow_mut().native("flow step=setLxData start");
        let _ = self.call_static(
            "setLxData",
            "(Lorg/json/JSONObject;)V",
            vec![json_obj.clone().into()],
        )?;
        self.shared.borrow_mut().native("flow step=setLxData done");
        self.shared
            .borrow_mut()
            .native("flow step=createCKey start");
        let _ = self.call_static("createCKey", "()V", vec![])?;
        self.shared.borrow_mut().native("flow step=createCKey done");
        let ck_version = self
            .call_static("getCkVersion", "()Ljava/lang/String;", vec![])
            .ok()
            .and_then(|value| jni_value_to_string(value).ok())
            .unwrap_or_default();
        apply_runtime_page_patch_entries(
            &self.config.runtime_page_patches_after_create_ckey,
            &self.emulator,
            self.shared.clone(),
            self.module_base,
            "post-createCKey runtime page patch",
        )?;
        self.shared
            .borrow_mut()
            .native("flow step=getEncryptedCKey start");
        let encrypted_ckey =
            self.call_static("getEncryptedCKey", "(Z)[B", vec![use_new_key.into()])?;
        let encrypted_ckey_bytes = {
            let emulator = self.emulator.clone();
            let vm = emulator.get_dalvik_vm();
            jni_value_to_bytes_with_vm(vm, encrypted_ckey)?
        };
        self.shared.borrow_mut().native(&format!(
            "flow step=getEncryptedCKey done bytes_len={}",
            encrypted_ckey_bytes.len()
        ));
        self.shared
            .borrow_mut()
            .native("flow step=cipherWithHashKey start");
        let cipher_value = self.call_static(
            "cipherWithHashKey",
            "(Lorg/json/JSONObject;IZ)[B",
            vec![json_obj.into(), cipher_mode.into(), use_new_key.into()],
        )?;
        let cipher_return_debug = describe_jni_value(&cipher_value);
        self.shared.borrow_mut().native(&format!(
            "flow step=cipherWithHashKey return={}",
            cipher_return_debug
        ));
        let cipher_bytes = {
            let emulator = self.emulator.clone();
            let vm = emulator.get_dalvik_vm();
            jni_value_to_bytes_with_vm(vm, cipher_value).ok()
        };
        let encrypted_ckey_hex = hex::encode(&encrypted_ckey_bytes).to_ascii_uppercase();
        let cipher_hex = cipher_bytes
            .as_ref()
            .map(hex::encode)
            .unwrap_or_default()
            .to_ascii_uppercase();
        if let Some(bytes) = cipher_bytes.as_ref() {
            self.shared.borrow_mut().native(&format!(
                "flow step=cipherWithHashKey done bytes_len={}",
                bytes.len()
            ));
        } else {
            self.shared
                .borrow_mut()
                .native("flow step=cipherWithHashKey done bytes_len=null");
        }

        let data_to_control_feedback = build_data_to_control_feedback(
            &json_value,
            &encrypted_ckey_hex,
            &cipher_hex,
            &ck_version,
            &effective_opts,
        );
        let auth_bootstrap_block_reason = auth_bootstrap
            .failure_reason
            .as_ref()
            .map(ToString::to_string);
        let smssend_enabled = effective_opts
            .get("--smssend-test")
            .map(|value| parse_bool_like(value))
            .unwrap_or(false);
        let stage2_verify_status = json_value
            .get("verifyStatus")
            .map(|value| match value {
                Value::Bool(v) => *v,
                Value::String(v) => parse_bool_like(v),
                Value::Number(v) => v.as_i64().unwrap_or_default() != 0,
                _ => false,
            })
            .unwrap_or(false);
        let smssend_two_step_enabled = effective_opts
            .get("--smssend-two-step")
            .map(|value| parse_bool_like(value))
            .unwrap_or(stage2_verify_status);
        let smssend_two_step =
            if smssend_enabled && smssend_two_step_enabled && auth_bootstrap_block_reason.is_none()
            {
                let stage1_two_step = match self.try_build_two_step_stage1_payload_via_producer(
                    &json_value,
                    &data_to_control_feedback,
                    bridge_stage1_value.as_ref(),
                    &effective_opts,
                ) {
                    Ok(value) => value,
                    Err(err) => {
                        self.shared
                            .borrow_mut()
                            .native(&format!("producer stage1 payload fallback reason={err:#}"));
                        build_two_step_stage1_payload(&json_value, &self.config.package_name)
                    }
                };
                Some(self.run_smssend_two_step(
                    &stage1_two_step,
                    &json_value,
                    &data_to_control_feedback,
                    &cipher_hex,
                    cipher_mode,
                    use_new_key,
                    &effective_opts,
                ))
            } else {
                None
            };
        let smssend_test = if smssend_enabled {
            if let Some(reason) = auth_bootstrap_block_reason.as_ref() {
                Some(json!({
                    "status": "blocked",
                    "reason": reason,
                    "auth_bootstrap": auth_bootstrap,
                }))
            } else if let Some(two_step) = smssend_two_step.as_ref() {
                two_step.get("stage2_result").cloned().or_else(|| {
                    Some(json!({
                        "status": "blocked",
                        "reason": "missing_stage2_result",
                        "smssend_two_step": two_step,
                    }))
                })
            } else {
                Some(self.run_smssend_test(
                    &data_to_control_feedback,
                    &cipher_hex,
                    use_new_key,
                    &effective_opts,
                ))
            }
        } else {
            None
        };
        let v7_payload_debug_surface = build_v7_payload_debug_surface(
            bridge_stage1_value.as_ref(),
            &json_value,
            &cipher_hex,
            smssend_two_step.as_ref(),
        );

        let mut output = json!({
            "flow": "setLxData->createCKey->getEncryptedCKey->cipherWithHashKey",
            "arg1_json": json_value,
            "bridge_stage1_json": bridge_stage1_value,
            "v7_captcha_bridge_surface": v7_captcha_bridge_surface,
            "v7_base_field_production": v7_base_field_production,
            "v7_identity_dependency_graph": v7_identity_dependency_graph,
            "v7_identity_gate_diagnostics": v7_identity_gate_diagnostics,
            "app_init_upstream_observation": app_init_upstream_observation,
            "v7_captcha_upstream_production": v7_captcha_upstream_production,
            "v7_retry_payload_views": v7_retry_payload_views,
            "v7_payload_debug_surface": v7_payload_debug_surface,
            "v7_captcha_business_surface": v7_captcha_business_surface,
            "palmchat_project_planes": palmchat_project_planes,
            "ip_info_preflight": ip_info_preflight,
            "auth_bootstrap": auth_bootstrap,
            "secret_keys_seeded": secret_keys_seeded,
            "app_version_from_original": {
                "versionCode": self.app_version_info.version_code,
                "versionName": self.app_version_info.version_name,
                "source": self.app_version_info.source,
            },
            "live_device_profile": self.live_device_profile,
            "arg2_mode": cipher_mode,
            "arg3_bool": use_new_key,
            "no_empty_params": no_empty_params,
            "setLxData": "ok",
            "createCKey": "ok",
            "ck_version": ck_version,
            "encrypted_ckey_hex": encrypted_ckey_hex,
            "encrypted_ckey_utf8": String::from_utf8_lossy(&encrypted_ckey_bytes),
            "cipher_return_debug": cipher_return_debug,
            "cipher_hex": cipher_hex,
            "cipher_utf8": cipher_bytes
                .as_ref()
                .map(|bytes| String::from_utf8_lossy(bytes).to_string())
                .unwrap_or_default(),
            "cipher_null": cipher_bytes.is_none(),
        });
        if let Value::Object(map) = &mut output {
            if let Some(injected) = smssend_url_injected {
                map.insert("smssend_url_injected".to_string(), injected);
            }
            if !empty_param_cleanup.is_empty() {
                map.insert(
                    "no_empty_params_filled".to_string(),
                    Value::Array(
                        empty_param_cleanup
                            .iter()
                            .map(|v| Value::String(v.clone()))
                            .collect(),
                    ),
                );
            }
            map.insert(
                "data_to_control_feedback".to_string(),
                data_to_control_feedback,
            );
            if let Some(two_step) = smssend_two_step {
                map.insert("smssend_two_step".to_string(), two_step);
            }
            if let Some(smssend) = smssend_test {
                map.insert("smssend_test".to_string(), smssend);
            }
        }
        self.shared
            .borrow_mut()
            .native(&format!("flow result={}", output));
        Ok(output)
    }

    fn run_decrypt_trace(&mut self, opts: &HashMap<String, String>) -> Result<Value> {
        let skip_flow = opts
            .get("--skip-flow")
            .map(|value| parse_bool_like(value))
            .unwrap_or(false);
        let flow_raw = opts
            .get("--flow-json")
            .cloned()
            .or_else(|| opts.get("--arg1").cloned())
            .filter(|value| !value.trim().is_empty())
            .unwrap_or_else(|| "{}".to_string());
        let (flow_raw_normalized, flow_seed_value) =
            self.normalize_flow_arg1_json(&flow_raw, "decrypt_trace.flow");
        let bridge_stage1_value = opts.get("--bridge-stage1-json").map(|value| {
            self.normalize_flow_arg1_json(value, "decrypt_trace.bridge_stage1")
                .1
        });
        let v7_input_fields =
            extract_known_fields_from_value(&flow_seed_value, V7_FINGERPRINT_KEYS);
        let v7_input_missing = missing_known_keys(&v7_input_fields, V7_FINGERPRINT_KEYS);
        let v7_captcha_bridge_surface =
            build_v7_captcha_bridge_surface(bridge_stage1_value.as_ref(), &flow_seed_value);
        let v7_base_field_production = build_v7_base_field_production(&flow_seed_value);
        let v7_identity_dependency_graph = build_v7_identity_dependency_graph(&flow_seed_value);
        let v7_identity_gate_diagnostics = build_v7_identity_gate_diagnostics();
        self.sync_identity_state_from_effective_body(&flow_seed_value, opts);
        let app_init_upstream_observation = self.capture_app_init_upstream_observation()?;
        let v7_captcha_upstream_production =
            build_v7_captcha_upstream_production(bridge_stage1_value.as_ref(), &flow_seed_value);
        let v7_retry_payload_views =
            build_v7_retry_payload_views(bridge_stage1_value.as_ref(), &flow_seed_value);
        let v7_captcha_business_surface =
            build_v7_captcha_business_surface(bridge_stage1_value.as_ref(), &flow_seed_value);
        let palmchat_project_planes = build_palmchat_project_planes(
            &flow_seed_value,
            &app_init_upstream_observation,
            &v7_captcha_business_surface,
        );
        let flow_cipher_mode = opts
            .get("--flow-mode")
            .or_else(|| opts.get("--arg2"))
            .and_then(|value| value.parse::<i32>().ok())
            .unwrap_or(2);
        let flow_use_new_key = opts
            .get("--flow-use-new-key")
            .or_else(|| opts.get("--arg3"))
            .map(|value| parse_bool_like(value))
            .unwrap_or(false);

        let type_input = opts
            .get("--type-input")
            .cloned()
            .unwrap_or_else(|| "{\"birthday\":\"2000-01-01\",\"sex\":0}".to_string());
        let type_encrypt_mode = opts
            .get("--type-encrypt-mode")
            .and_then(|value| value.parse::<i32>().ok())
            .unwrap_or(4);
        let type_decrypt_mode = opts
            .get("--type-decrypt-mode")
            .and_then(|value| value.parse::<i32>().ok())
            .unwrap_or(5);
        let type_encrypt_use_new_key = opts
            .get("--type-encrypt-use-new-key")
            .map(|value| parse_bool_like(value))
            .unwrap_or(true);
        let type_decrypt_use_new_key = opts
            .get("--type-decrypt-use-new-key")
            .map(|value| parse_bool_like(value))
            .unwrap_or(false);

        let secret_key = opts.get("--secret-key").cloned();
        let secret_iv = opts.get("--secret-iv").cloned();
        if secret_key.is_some() ^ secret_iv.is_some() {
            return Err(anyhow!(
                "--secret-key and --secret-iv must be provided together for decrypt-trace"
            ));
        }
        let type_input_bytes = parse_arg_bytes(&type_input)?;

        let mut events = Vec::<Value>::new();
        events.push(json!({
            "ts": iso_now(),
            "phase": "begin",
            "backend_requested": self.config.backend,
            "backend_active": self.emulator.backend.name(),
            "trace_out_dir": self.config.trace_out_dir,
            "skip_flow": skip_flow,
            "flow_cipher_mode": flow_cipher_mode,
            "flow_use_new_key": flow_use_new_key,
            "type_encrypt_mode": type_encrypt_mode,
            "type_encrypt_use_new_key": type_encrypt_use_new_key,
            "type_decrypt_mode": type_decrypt_mode,
            "type_decrypt_use_new_key": type_decrypt_use_new_key,
            "type_input_len": type_input_bytes.len(),
            "type_input_hex": hex::encode(&type_input_bytes),
            "v7_fingerprint_keys": V7_FINGERPRINT_KEYS,
            "v7_input_fields": v7_input_fields.clone(),
            "v7_input_missing": v7_input_missing.clone(),
        }));
        events.push(json!({
            "ts": iso_now(),
            "phase": "v7_fp_produce_input",
            "v7_fields": v7_input_fields.clone(),
            "v7_missing": v7_input_missing.clone(),
        }));
        events.push(json!({
            "ts": iso_now(),
            "phase": "v7_captcha_bridge_surface",
            "surface": v7_captcha_bridge_surface.clone(),
        }));
        events.push(json!({
            "ts": iso_now(),
            "phase": "v7_base_field_production",
            "surface": v7_base_field_production.clone(),
        }));
        events.push(json!({
            "ts": iso_now(),
            "phase": "v7_identity_dependency_graph",
            "surface": v7_identity_dependency_graph.clone(),
        }));
        events.push(json!({
            "ts": iso_now(),
            "phase": "v7_identity_gate_diagnostics",
            "surface": v7_identity_gate_diagnostics.clone(),
        }));
        events.push(json!({
            "ts": iso_now(),
            "phase": "app_init_upstream_observation",
            "surface": app_init_upstream_observation.clone(),
        }));
        events.push(json!({
            "ts": iso_now(),
            "phase": "v7_captcha_upstream_production",
            "surface": v7_captcha_upstream_production.clone(),
        }));
        events.push(json!({
            "ts": iso_now(),
            "phase": "v7_retry_payload_views",
            "surface": v7_retry_payload_views.clone(),
        }));
        events.push(json!({
            "ts": iso_now(),
            "phase": "v7_captcha_business_surface",
            "surface": v7_captcha_business_surface.clone(),
        }));
        events.push(json!({
            "ts": iso_now(),
            "phase": "palmchat_project_planes",
            "surface": palmchat_project_planes.clone(),
        }));

        let mut v7_consume_fields = Map::new();
        let mut v7_consume_missing: Vec<String> = V7_FINGERPRINT_KEYS
            .iter()
            .map(|key| (*key).to_string())
            .collect();
        let mut v7_stable_fields = Vec::new();
        let mut v7_changed_fields = Map::new();
        let mut v7_consume_artifacts = json!({});

        if let (Some(secret_key), Some(secret_iv)) = (secret_key.as_ref(), secret_iv.as_ref()) {
            self.shared
                .borrow_mut()
                .native("decrypt_trace step=setSecretKeys start");
            self.call_messaging_static(
                "setSecretKeys",
                "(Ljava/lang/String;Ljava/lang/String;)V",
                vec![secret_key.clone().into(), secret_iv.clone().into()],
            )?;
            self.shared
                .borrow_mut()
                .native("decrypt_trace step=setSecretKeys done");
            events.push(json!({
                "ts": iso_now(),
                "phase": "setSecretKeys",
                "secret_key_len": secret_key.len(),
                "secret_iv_len": secret_iv.len(),
            }));
        }

        let flow_result = if skip_flow {
            None
        } else {
            self.shared
                .borrow_mut()
                .native("decrypt_trace step=flow start");
            let mut flow_opts = HashMap::new();
            flow_opts.insert("--arg1".to_string(), flow_raw_normalized.clone());
            flow_opts.insert("--arg2".to_string(), flow_cipher_mode.to_string());
            flow_opts.insert("--arg3".to_string(), flow_use_new_key.to_string());
            let output = self.run_flow(&flow_opts)?;
            self.shared
                .borrow_mut()
                .native("decrypt_trace step=flow done");
            events.push(json!({
                "ts": iso_now(),
                "phase": "flow",
                "result": output.clone(),
            }));
            if let Some(arg1_json) = output.get("arg1_json") {
                v7_consume_fields = extract_known_fields_from_value(arg1_json, V7_FINGERPRINT_KEYS);
                v7_consume_missing = missing_known_keys(&v7_consume_fields, V7_FINGERPRINT_KEYS);
                let (stable_fields, changed_fields) =
                    compare_field_alignment(&v7_input_fields, &v7_consume_fields);
                v7_stable_fields = stable_fields;
                v7_changed_fields = changed_fields;
            }
            let encrypted_ckey_len = output
                .get("encrypted_ckey_hex")
                .and_then(Value::as_str)
                .map(|hex| hex.len() / 2);
            let cipher_len = output
                .get("cipher_hex")
                .and_then(Value::as_str)
                .map(|hex| hex.len() / 2);
            v7_consume_artifacts = json!({
                "flow": output.get("flow").cloned(),
                "encrypted_ckey_bytes_len": encrypted_ckey_len,
                "cipher_bytes_len": cipher_len,
                "cipher_return_debug": output.get("cipher_return_debug").cloned(),
            });
            events.push(json!({
                "ts": iso_now(),
                "phase": "v7_fp_consume_flow",
                "v7_fields": v7_consume_fields.clone(),
                "v7_missing": v7_consume_missing.clone(),
                "v7_stable_fields": v7_stable_fields.clone(),
                "v7_changed_fields": v7_changed_fields.clone(),
                "consume_artifacts": v7_consume_artifacts.clone(),
            }));
            Some(output)
        };

        self.shared
            .borrow_mut()
            .native("decrypt_trace step=cipherWithType_encrypt start");
        let encrypt_value = self.call_static(
            "cipherWithType",
            "([BIZ)[B",
            vec![
                JniValue::Object(DvmObject::ByteArray(type_input_bytes.clone())),
                type_encrypt_mode.into(),
                type_encrypt_use_new_key.into(),
            ],
        )?;
        let encrypt_return_debug = describe_jni_value(&encrypt_value);
        let encrypted_bytes = jni_value_to_bytes(encrypt_value)?;
        self.shared.borrow_mut().native(&format!(
            "decrypt_trace step=cipherWithType_encrypt done bytes_len={}",
            encrypted_bytes.len()
        ));
        events.push(json!({
            "ts": iso_now(),
            "phase": "cipherWithType_encrypt",
            "input_len": type_input_bytes.len(),
            "input_hex": hex::encode(&type_input_bytes),
            "mode": type_encrypt_mode,
            "use_new_key": type_encrypt_use_new_key,
            "return_debug": encrypt_return_debug,
            "output_len": encrypted_bytes.len(),
            "output_hex": hex::encode(&encrypted_bytes),
        }));

        self.shared
            .borrow_mut()
            .native("decrypt_trace step=cipherWithType_decrypt start");
        let decrypt_value = self.call_static(
            "cipherWithType",
            "([BIZ)[B",
            vec![
                JniValue::Object(DvmObject::ByteArray(encrypted_bytes.clone())),
                type_decrypt_mode.into(),
                type_decrypt_use_new_key.into(),
            ],
        )?;
        let decrypt_return_debug = describe_jni_value(&decrypt_value);
        let decrypted_bytes = jni_value_to_bytes(decrypt_value)?;
        self.shared.borrow_mut().native(&format!(
            "decrypt_trace step=cipherWithType_decrypt done bytes_len={}",
            decrypted_bytes.len()
        ));
        let decrypted_utf8 = std::str::from_utf8(&decrypted_bytes)
            .ok()
            .map(ToString::to_string);
        events.push(json!({
            "ts": iso_now(),
            "phase": "cipherWithType_decrypt",
            "input_len": encrypted_bytes.len(),
            "input_hex": hex::encode(&encrypted_bytes),
            "mode": type_decrypt_mode,
            "use_new_key": type_decrypt_use_new_key,
            "return_debug": decrypt_return_debug,
            "output_len": decrypted_bytes.len(),
            "output_hex": hex::encode(&decrypted_bytes),
            "output_utf8": decrypted_utf8,
        }));

        let native_log_path = self.config.trace_out_dir.join("palmchat_native.log");
        let jni_log_path = self.config.trace_out_dir.join("palmchat_jni.log");
        let report = parse_palmchat_flow_report(
            &native_log_path,
            None,
            Some(self.config.trace_out_dir.as_path()),
        )?;
        events.push(json!({
            "ts": iso_now(),
            "phase": "flow_report",
            "status": report.status.clone(),
            "steps": report.steps.clone(),
            "cipher_evidence": report.cipher_evidence.clone(),
        }));
        let mut step_duration_ms = Map::new();
        for (name, step) in &report.steps {
            if let Some(duration_ms) = step.duration_ms {
                step_duration_ms.insert(name.clone(), json!(duration_ms));
            }
        }
        let v7_surface = json!({
            "keys": V7_FINGERPRINT_KEYS,
            "produce_input_fields": v7_input_fields,
            "produce_input_missing": v7_input_missing,
            "consume_flow_fields": v7_consume_fields,
            "consume_flow_missing": v7_consume_missing,
            "stable_fields": v7_stable_fields,
            "changed_fields": v7_changed_fields,
            "consume_artifacts": v7_consume_artifacts,
            "native_step_duration_ms": step_duration_ms,
            "captcha_bridge_surface": v7_captcha_bridge_surface.clone(),
            "base_field_production": v7_base_field_production.clone(),
            "identity_dependency_graph": v7_identity_dependency_graph.clone(),
            "identity_gate_diagnostics": v7_identity_gate_diagnostics.clone(),
            "captcha_upstream_production": v7_captcha_upstream_production.clone(),
            "retry_payload_views": v7_retry_payload_views.clone(),
        });
        events.push(json!({
            "ts": iso_now(),
            "phase": "v7_fp_surface_summary",
            "surface": v7_surface.clone(),
        }));

        let jsonl_path = opts
            .get("--jsonl-out")
            .map(PathBuf::from)
            .unwrap_or_else(|| {
                self.config
                    .trace_out_dir
                    .join("palmchat_decrypt_trace.jsonl")
            });
        write_jsonl_file(&jsonl_path, &events)?;

        if let Some(path) = opts.get("--report-json").map(PathBuf::from) {
            write_json_file(&path, &serde_json::to_value(&report)?)?;
        }
        if let Some(path) = opts.get("--report-md").map(PathBuf::from) {
            write_text_file(&path, &render_palmchat_flow_report_markdown(&report))?;
        }

        Ok(json!({
            "status": "ok",
            "command": "decrypt-trace",
            "requested_backend": self.config.backend,
            "active_backend": self.emulator.backend.name(),
            "trace_jsonl": jsonl_path,
            "native_log": native_log_path,
            "jni_log": jni_log_path,
            "flow_result": flow_result,
            "cipher_with_type": {
                "encrypt_mode": type_encrypt_mode,
                "encrypt_use_new_key": type_encrypt_use_new_key,
                "decrypt_mode": type_decrypt_mode,
                "decrypt_use_new_key": type_decrypt_use_new_key,
                "encrypt_output_hex": hex::encode(&encrypted_bytes),
                "decrypt_output_hex": hex::encode(&decrypted_bytes),
                "decrypt_output_utf8": decrypted_utf8,
            },
            "v7_fingerprint_surface": v7_surface,
            "v7_captcha_bridge_surface": v7_captcha_bridge_surface,
            "v7_base_field_production": v7_base_field_production,
            "v7_identity_dependency_graph": v7_identity_dependency_graph,
            "v7_identity_gate_diagnostics": v7_identity_gate_diagnostics,
            "app_init_upstream_observation": app_init_upstream_observation,
            "v7_captcha_upstream_production": v7_captcha_upstream_production,
            "v7_retry_payload_views": v7_retry_payload_views,
            "v7_captcha_business_surface": v7_captcha_business_surface,
            "palmchat_project_planes": palmchat_project_planes,
            "report_status": report.status,
            "event_count": events.len(),
        }))
    }
}

impl Drop for PalmchatLab {
    fn drop(&mut self) {
        self.emulator.destroy();
    }
}

struct PalmchatJni {
    shared: Rc<RefCell<SharedState>>,
    package_name: String,
    apk_path: String,
    app_context_fs: PalmchatAppContextFs,
    identity_state: Rc<RefCell<PalmchatIdentityRuntimeState>>,
    live_device_profile: Option<PalmchatLiveDeviceProfile>,
    app_context_secret_pair: Rc<RefCell<Option<PalmchatSecretPair>>>,
    asset_manager_native_ptr: u64,
}

impl PalmchatJni {
    fn new(
        shared: Rc<RefCell<SharedState>>,
        package_name: String,
        apk_path: PathBuf,
        app_context_fs: PalmchatAppContextFs,
        identity_state: Rc<RefCell<PalmchatIdentityRuntimeState>>,
        live_device_profile: Option<PalmchatLiveDeviceProfile>,
        app_context_secret_pair: Rc<RefCell<Option<PalmchatSecretPair>>>,
        asset_manager_native_ptr: u64,
    ) -> Self {
        Self {
            shared,
            package_name,
            apk_path: apk_path.to_string_lossy().to_string(),
            app_context_fs,
            identity_state,
            live_device_profile,
            app_context_secret_pair,
            asset_manager_native_ptr,
        }
    }

    fn default_return(acc: MethodAcc) -> JniValue {
        if acc.contains(MethodAcc::VOID) {
            JniValue::Void
        } else if acc.contains(MethodAcc::BOOLEAN) {
            false.into()
        } else if acc.contains(MethodAcc::BYTE) {
            (0_i8).into()
        } else if acc.contains(MethodAcc::CHAR) {
            (0_u16).into()
        } else if acc.contains(MethodAcc::SHORT) {
            (0_i16).into()
        } else if acc.contains(MethodAcc::INT) {
            0.into()
        } else if acc.contains(MethodAcc::LONG) {
            0_i64.into()
        } else if acc.contains(MethodAcc::FLOAT) {
            0_f32.into()
        } else if acc.contains(MethodAcc::DOUBLE) {
            0_f64.into()
        } else {
            JniValue::Null
        }
    }

    fn live_wifi_ssid(&self) -> String {
        self.live_device_profile
            .as_ref()
            .and_then(|profile| profile.wifi_ssid.clone())
            .unwrap_or_default()
    }

    fn live_wm4_network_type(&self) -> String {
        normalize_wm4_network_type(
            self.live_device_profile
                .as_ref()
                .and_then(|profile| profile.network_type.as_deref()),
        )
    }

    fn live_wm4_real_network_type(&self) -> String {
        let profile = self.live_device_profile.as_ref();
        normalize_wm4_real_network_type(
            profile.and_then(|value| value.network_type.as_deref()),
            profile.and_then(|value| value.mobile_data_enabled),
        )
    }

    fn effective_app_list_string(&self) -> Option<String> {
        let profile = self.live_device_profile.as_ref()?;
        let imei = {
            let state = self.identity_state.borrow();
            normalize_ac1_imei_candidate(Some(state.effective_imei()))
        };
        let channel_id = normalize_plain_candidate(profile.channel_id.clone())?;
        let mut map = Map::new();
        let mut events = Vec::new();
        ensure_app_list_payload(
            &mut map,
            imei.as_deref(),
            Some(channel_id.as_str()),
            &self.package_name,
            Some(profile.installed_packages.as_slice()),
            true,
            &mut events,
        );
        map.get("appList")
            .and_then(Value::as_str)
            .map(|value| value.to_string())
    }

    fn effective_dfp_json(&self) -> Option<String> {
        let profile = self.live_device_profile.as_ref()?;
        let (android_id, imei, mac, device_label) = {
            let state = self.identity_state.borrow();
            let device_label =
                normalize_device_label_candidate(Some(state.effective_device_label()))
                    .or_else(|| normalize_device_label_candidate(profile.device_label.clone()));
            (
                state.effective_android_id(),
                state.effective_imei(),
                state.effective_mac(),
                device_label,
            )
        };
        let mut map = Map::new();
        map.insert(
            "imei".to_string(),
            if imei.trim().is_empty() {
                Value::Null
            } else {
                Value::String(imei)
            },
        );
        map.insert("mac".to_string(), Value::String(mac));
        let mut events = Vec::new();
        ensure_dfp_payload(
            &mut map,
            Some(android_id.as_str()),
            profile.app_version_name.as_deref(),
            Some(&self.package_name),
            device_label.as_deref(),
            Some(profile),
            &mut events,
        );
        map.get("dfp")
            .and_then(Value::as_str)
            .map(|value| value.to_string())
    }

    fn effective_app_id(&self) -> String {
        "ZX0001".to_string()
    }

    fn effective_ip_info(&self) -> String {
        self.live_device_profile
            .as_ref()
            .and_then(|profile| normalize_plain_candidate(profile.ip_info.clone()))
            .unwrap_or_default()
    }

    fn effective_oaid(&self) -> String {
        self.live_device_profile
            .as_ref()
            .and_then(|profile| normalize_plain_candidate(profile.oaid.clone()))
            .unwrap_or_default()
    }

    fn effective_channel_id(&self) -> String {
        self.live_device_profile
            .as_ref()
            .and_then(|profile| normalize_plain_candidate(profile.channel_id.clone()))
            .unwrap_or_default()
    }

    fn effective_version_code(&self) -> String {
        self.live_device_profile
            .as_ref()
            .and_then(|profile| normalize_plain_candidate(profile.app_version_code.clone()))
            .unwrap_or_else(|| "unknown".to_string())
    }

    fn effective_nullable_did(&self) -> Option<String> {
        let (android_id, imei, mac) = {
            let state = self.identity_state.borrow();
            (
                normalize_plain_candidate(Some(state.effective_android_id())),
                normalize_device_id_candidate(Some(state.effective_imei())),
                state.effective_mac().trim().to_string(),
            )
        };
        let android_id = android_id?;
        let imei_segment = imei.unwrap_or_else(|| "null".to_string());
        Some(format!("{imei_segment}_{mac}_{android_id}"))
    }

    fn build_mh_request_body_map(&self) -> Map<String, Value> {
        let (android_id, imei_value, mac_value, sdid_value) = {
            let state = self.identity_state.borrow();
            let imei = normalize_device_id_candidate(Some(state.effective_imei()));
            let sdid = if !state.effective_sdid().trim().is_empty() {
                state.effective_sdid()
            } else {
                state.effective_local_smid()
            };
            (
                state.effective_android_id(),
                imei,
                state.effective_mac(),
                sdid,
            )
        };

        let mut map = Map::new();
        map.insert(
            "channelId".to_string(),
            Value::String(self.effective_channel_id()),
        );
        if let Some(did) = self.effective_nullable_did() {
            map.insert("did".to_string(), Value::String(did));
        }
        map.insert("platform".to_string(), Value::String("android".to_string()));
        map.insert(
            "versionCode".to_string(),
            Value::String(self.effective_version_code()),
        );
        map.insert(
            "imei".to_string(),
            imei_value.map(Value::String).unwrap_or(Value::Null),
        );
        map.insert("mac".to_string(), Value::String(mac_value));
        map.insert("dhid".to_string(), Value::String(String::new()));
        map.insert("autoLogin".to_string(), Value::String("0".to_string()));
        map.insert("sdid".to_string(), Value::String(sdid_value));
        map.insert("oaid".to_string(), Value::String(self.effective_oaid()));
        map.insert("oneId".to_string(), Value::String(String::new()));
        if let Some(dfp) = self.effective_dfp_json() {
            map.insert("dfp".to_string(), Value::String(dfp));
        }
        if let Some(app_list) = self.effective_app_list_string() {
            map.insert("appList".to_string(), Value::String(app_list));
        }
        map.insert("appId".to_string(), Value::String(self.effective_app_id()));
        map.insert(
            "ipInfo".to_string(),
            Value::String(self.effective_ip_info()),
        );
        map.insert("androidId".to_string(), Value::String(android_id));
        map
    }

    fn current_app_context_secret_pair(&self) -> Option<PalmchatSecretPair> {
        self.app_context_secret_pair.borrow().clone()
    }

    fn set_app_context_secret_pair(&self, pair: Option<PalmchatSecretPair>) {
        *self.app_context_secret_pair.borrow_mut() = pair;
    }

    fn asset_manager_object(&self, vm: &mut DalvikVM64<()>) -> DvmObject {
        let class = vm
            .resolve_class("android/content/res/AssetManager")
            .map(|(_, class)| class)
            .expect("failed to resolve android/content/res/AssetManager");
        new_mut_data_object(class, self.asset_manager_native_ptr as i64)
    }

    fn secret_pair_object(&self, vm: &mut DalvikVM64<()>, pair: &PalmchatSecretPair) -> DvmObject {
        let class = vm
            .resolve_class("android/util/Pair")
            .map(|(_, class)| class)
            .expect("failed to resolve android/util/Pair");
        new_mut_data_object(
            class,
            PalmchatPairState {
                first: Some(DvmObject::ByteArray(pair.key.clone())),
                second: Some(DvmObject::ByteArray(pair.iv.clone())),
            },
        )
    }

    fn app_context_state(&self) -> PalmchatAppContextState {
        PalmchatAppContextState {
            package_name: self.package_name.clone(),
            apk_path: self.apk_path.clone(),
            fs: self.app_context_fs.clone(),
        }
    }

    fn file_object(&self, vm: &mut DalvikVM64<()>, requested_path: &str) -> DvmObject {
        let class = vm
            .resolve_class("java/io/File")
            .map(|(_, class)| class)
            .expect("failed to resolve java/io/File");
        new_mut_data_object(class, self.app_context_fs.file_state_for_path(requested_path))
    }
}

impl Jni<()> for PalmchatJni {
    fn resolve_method(
        &mut self,
        _vm: &mut DalvikVM64<()>,
        class: &Rc<DvmClass>,
        name: &str,
        signature: &str,
        is_static: bool,
    ) -> bool {
        self.shared.borrow_mut().jni(&format!(
            "resolve_method class={} name={} sig={} static={}",
            class.name, name, signature, is_static
        ));
        true
    }

    fn resolve_filed(
        &mut self,
        _vm: &mut DalvikVM64<()>,
        class: &Rc<DvmClass>,
        name: &str,
        signature: &str,
        is_static: bool,
    ) -> bool {
        self.shared.borrow_mut().jni(&format!(
            "resolve_field class={} name={} sig={} static={}",
            class.name, name, signature, is_static
        ));
        true
    }

    fn call_method_v(
        &mut self,
        vm: &mut DalvikVM64<()>,
        acc: MethodAcc,
        class: &Rc<DvmClass>,
        method: &DvmMethod,
        instance: Option<&mut DvmObject>,
        args: &mut VaList<()>,
    ) -> JniValue {
        let signature = format!("{}->{}{}", class.name, method.name, method.signature);
        self.shared.borrow_mut().jni(&format!("call {}", signature));

        if acc.contains(MethodAcc::CONSTRUCTOR) {
            match signature.as_str() {
                "java/lang/String-><init>([B)V" => {
                    let bytes = args.get::<Vec<u8>>(vm);
                    return String::from_utf8_lossy(&bytes).to_string().into();
                }
                "java/lang/String-><init>([BLjava/lang/String;)V" => {
                    let bytes = args.get::<Vec<u8>>(vm);
                    let _charset = args.get::<String>(vm);
                    return String::from_utf8_lossy(&bytes).to_string().into();
                }
                "org/json/JSONObject-><init>()V" => {
                    return new_mut_data_object(class.clone(), JsonObjectState::empty()).into();
                }
                "org/json/JSONObject-><init>(Ljava/lang/String;)V" => {
                    let raw = args.get::<String>(vm);
                    return new_mut_data_object(class.clone(), JsonObjectState::from_raw(&raw))
                        .into();
                }
                "android/util/Pair-><init>(Ljava/lang/Object;Ljava/lang/Object;)V" => {
                    let first = args.get::<DvmObject>(vm);
                    let second = args.get::<DvmObject>(vm);
                    return new_mut_data_object(
                        class.clone(),
                        PalmchatPairState {
                            first: Some(first),
                            second: Some(second),
                        },
                    )
                    .into();
                }
                "java/io/File-><init>(Ljava/lang/String;)V" => {
                    let path = args.get::<String>(vm);
                    return self.file_object(vm, &path).into();
                }
                "java/io/File-><init>(Ljava/lang/String;Ljava/lang/String;)V" => {
                    let parent = args.get::<String>(vm);
                    let child = args.get::<String>(vm);
                    let joined = PathBuf::from(parent)
                        .join(child)
                        .to_string_lossy()
                        .to_string();
                    return self.file_object(vm, &joined).into();
                }
                "java/io/File-><init>(Ljava/io/File;Ljava/lang/String;)V" => {
                    let parent = args.get::<DvmObject>(vm);
                    let child = args.get::<String>(vm);
                    let parent_path = data_ref::<PalmchatFileState>(&parent)
                        .map(|state| state.guest_path.clone())
                        .unwrap_or_else(|| string_from_object(&parent));
                    let joined = PathBuf::from(parent_path)
                        .join(child)
                        .to_string_lossy()
                        .to_string();
                    return self.file_object(vm, &joined).into();
                }
                _ => return DvmObject::new_simple(class.clone()).into(),
            }
        }

        match signature.as_str() {
            "com/zenmen/palmchat/AppContext->getContext()Lcom/zenmen/palmchat/AppContext;" => {
                return new_mut_data_object(class.clone(), self.app_context_state()).into();
            }
            "defpackage/r75->l()Z" => {
                let result = self.identity_state.borrow().effective_privacy_agree();
                self.shared
                    .borrow_mut()
                    .jni(&format!("probe r75.l -> {}", result));
                return result.into();
            }
            "defpackage/st3->e(Z)V" => {
                let value = args.get::<i32>(vm) != 0;
                self.shared
                    .borrow_mut()
                    .jni(&format!("probe st3.e -> {}", value));
                return JniValue::Void;
            }
            "defpackage/g9->d()Z" => {
                self.shared.borrow_mut().jni("probe g9.d -> false");
                return false.into();
            }
            "defpackage/g9->c(Z)Ljava/lang/String;" => {
                let is_k1 = args.get::<i32>(vm) != 0;
                self.shared
                    .borrow_mut()
                    .jni(&format!("probe g9.c({}) -> empty", is_k1));
                return String::new().into();
            }
            "defpackage/nl0->k()Z" => {
                return true.into();
            }
            "defpackage/tg4->b(Landroid/content/Context;[Ljava/lang/String;)Z" => {
                let _context = args.get::<DvmObject>(vm);
                let permissions = args.get::<DvmObject>(vm);
                let requested = string_array_from_object(&permissions);
                let state = self.identity_state.borrow();
                let result = requested
                    .iter()
                    .all(|permission| permission_granted(&state, permission));
                self.shared.borrow_mut().jni(&format!(
                    "probe tg4.b permissions={:?} -> {}",
                    requested, result
                ));
                return result.into();
            }
            "defpackage/k86->m(Landroid/content/Context;)Ljava/lang/String;" => {
                let _context = args.get::<DvmObject>(vm);
                let result = self
                    .identity_state
                    .borrow()
                    .effective_process_name(&self.package_name);
                self.shared
                    .borrow_mut()
                    .jni(&format!("probe k86.m -> {}", result));
                return result.into();
            }
            "com/zenmen/palmchat/privinfo/PrivInfoManager->init(Landroid/content/Context;)V" => {
                let _context = args.get::<DvmObject>(vm);
                self.identity_state.borrow_mut().priv_info_initialized = true;
                self.shared
                    .borrow_mut()
                    .jni("probe PrivInfoManager.init -> isInit=true");
                return JniValue::Void;
            }
            "defpackage/ac1->B(Landroid/content/Context;)V" => {
                let _context = args.get::<DvmObject>(vm);
                self.shared.borrow_mut().jni("probe ac1.B -> noop");
                return JniValue::Void;
            }
            "defpackage/ts0->I(Landroid/content/Context;)V" => {
                let _context = args.get::<DvmObject>(vm);
                self.shared.borrow_mut().jni("probe ts0.I -> noop");
                return JniValue::Void;
            }
            "com/zenmen/palmchat/privinfo/PrivInfoManager->getAndroidID()Ljava/lang/String;" => {
                let state = self.identity_state.borrow();
                let result = if state.priv_info_initialized {
                    state.effective_android_id()
                } else {
                    "none".to_string()
                };
                return result.into();
            }
            "com/zenmen/palmchat/privinfo/PrivInfoManager->getIMEI()Ljava/lang/String;" => {
                let state = self.identity_state.borrow();
                let result = if state.priv_info_initialized {
                    state.effective_imei()
                } else {
                    String::new()
                };
                return result.into();
            }
            "com/zenmen/palmchat/privinfo/PrivInfoManager->getMac()Ljava/lang/String;" => {
                let state = self.identity_state.borrow();
                let result = if state.priv_info_initialized {
                    state.effective_mac()
                } else {
                    String::new()
                };
                return result.into();
            }
            "com/zenmen/palmchat/privinfo/PrivInfoManager->getSsid()Ljava/lang/String;" => {
                let state = self.identity_state.borrow();
                let result = if state.priv_info_initialized {
                    self.live_wifi_ssid()
                } else {
                    String::new()
                };
                return result.into();
            }
            "com/zenmen/palmchat/privinfo/PrivInfoManager->getNetworkType()Ljava/lang/String;" => {
                let state = self.identity_state.borrow();
                let result = if state.priv_info_initialized {
                    self.live_wm4_network_type()
                } else {
                    String::new()
                };
                return result.into();
            }
            "com/zenmen/palmchat/privinfo/PrivInfoManager->getRealNetworkType()Ljava/lang/String;" => {
                let state = self.identity_state.borrow();
                let result = if state.priv_info_initialized {
                    self.live_wm4_real_network_type()
                } else {
                    String::new()
                };
                return result.into();
            }
            "defpackage/wm4->h()Ljava/lang/String;" => {
                let result = self.identity_state.borrow().effective_android_id();
                return result.into();
            }
            "defpackage/wm4->k()Ljava/lang/String;" => {
                let result = self.identity_state.borrow().effective_imei();
                return result.into();
            }
            "defpackage/wm4->n()Ljava/lang/String;" => {
                let result = self.identity_state.borrow().effective_mac();
                return result.into();
            }
            "defpackage/wm4->q()Ljava/lang/String;" => {
                let result = self.live_wm4_network_type();
                return result.into();
            }
            "defpackage/wm4->s()Ljava/lang/String;" => {
                let result = self.live_wm4_real_network_type();
                return result.into();
            }
            "defpackage/wm4->w()Ljava/lang/String;" => {
                let result = self.live_wifi_ssid();
                return result.into();
            }
            "com/wifi/open/sec/SmDuManager->getDeviceId()Ljava/lang/String;" => {
                let result = self.identity_state.borrow().effective_sdid();
                self.shared
                    .borrow_mut()
                    .jni(&format!("probe SmDuManager.getDeviceId -> {}", result));
                return result.into();
            }
            "com/wifi/open/sec/SmDuManager->getDuLabel()Ljava/lang/String;" => {
                let result = self.identity_state.borrow().effective_device_label();
                self.shared
                    .borrow_mut()
                    .jni(&format!("probe SmDuManager.getDuLabel -> {}", result));
                return result.into();
            }
            "com/zenmen/palmchat/utils/SmidHelper->o()Ljava/lang/String;" => {
                let state = self.identity_state.borrow();
                let result = if !state.effective_sdid().trim().is_empty() {
                    state.effective_sdid()
                } else {
                    state.effective_local_smid()
                };
                self.shared
                    .borrow_mut()
                    .jni(&format!("probe SmidHelper.o -> {}", result));
                return result.into();
            }
            "defpackage/ac1->v()Ljava/lang/String;" => {
                let state = self.identity_state.borrow();
                let result = if !state.effective_sdid().trim().is_empty() {
                    state.effective_sdid()
                } else {
                    state.effective_local_smid()
                };
                self.shared
                    .borrow_mut()
                    .jni(&format!("probe ac1.v -> {}", result));
                return result.into();
            }
            "defpackage/mh->a(Ljava/lang/String;)Ldefpackage/sw4;" => {
                let request_url = args.get::<String>(vm);
                let sw4_class = vm
                    .resolve_class("defpackage/sw4")
                    .map(|(_, class)| class)
                    .expect("failed to resolve defpackage/sw4");
                let state = PalmchatSw4State {
                    url: request_url.clone(),
                    body_map: self.build_mh_request_body_map(),
                    encrypted_body_type: 1,
                    encrypted_request: true,
                };
                self.shared.borrow_mut().jni(&format!(
                    "probe mh.a -> sw4(url_len={} keys={})",
                    request_url.len(),
                    state.body_map.len()
                ));
                let object = new_mut_data_object(sw4_class, state);
                let ref_id = vm.add_global_ref(object);
                return DvmObject::ObjectRef(ref_id).into();
            }
            "defpackage/ac1->s()Ljava/lang/String;" => {
                let result = self.effective_app_list_string().unwrap_or_default();
                self.shared
                    .borrow_mut()
                    .jni(&format!("probe ac1.s -> {}", result));
                return result.into();
            }
            "defpackage/ac1->y()Ljava/lang/String;" => {
                return String::new().into();
            }
            "defpackage/fm1->k()Lorg/json/JSONObject;" => {
                if let Some(raw) = self.effective_dfp_json() {
                    let json_class = vm
                        .resolve_class("org/json/JSONObject")
                        .map(|(_, class)| class)
                        .expect("failed to resolve org/json/JSONObject");
                    self.shared.borrow_mut().jni(&format!(
                        "probe fm1.k -> json(len={})",
                        raw.len()
                    ));
                    return new_mut_data_object(json_class, JsonObjectState::from_raw(&raw)).into();
                }
                self.shared.borrow_mut().jni("probe fm1.k -> null");
                return JniValue::Null;
            }
            "defpackage/cl6->f()I" => {
                self.shared.borrow_mut().jni("probe cl6.f -> 4");
                return 4.into();
            }
            "defpackage/eb4->b()Ljava/lang/String;" => {
                let result = self.effective_app_id();
                self.shared
                    .borrow_mut()
                    .jni(&format!("probe eb4.b -> {}", result));
                return result.into();
            }
            "defpackage/vu2->c()Ldefpackage/vu2;" => {
                return DvmObject::new_simple(class.clone()).into();
            }
            "defpackage/vu2->d()Ljava/lang/String;" => {
                let result = self.effective_ip_info();
                self.shared
                    .borrow_mut()
                    .jni(&format!("probe vu2.d -> len={}", result.len()));
                return result.into();
            }
            "com/zenmen/palmchat/utils/MdidSdkConfigHelper->getInstance()Lcom/zenmen/palmchat/utils/MdidSdkConfigHelper;" => {
                return DvmObject::new_simple(class.clone()).into();
            }
            "com/zenmen/palmchat/utils/MdidSdkConfigHelper->getOAID()Ljava/lang/String;" => {
                let result = self.effective_oaid();
                self.shared.borrow_mut().jni(&format!(
                    "probe MdidSdkConfigHelper.getOAID -> len={}",
                    result.len()
                ));
                return result.into();
            }
            "com/zenmen/palmchat/account/AccountUtils->p(Landroid/content/Context;)Ljava/lang/String;" => {
                let _context = args.get::<DvmObject>(vm);
                let result = self
                    .live_device_profile
                    .as_ref()
                    .and_then(|profile| normalize_plain_candidate(profile.account_uid.clone()))
                    .unwrap_or_default();
                self.shared
                    .borrow_mut()
                    .jni(&format!("probe AccountUtils.p -> {}", result));
                return result.into();
            }
            "com/zenmen/palmchat/account/AccountUtils->o(Landroid/content/Context;)Ljava/lang/String;" => {
                let _context = args.get::<DvmObject>(vm);
                self.shared
                    .borrow_mut()
                    .jni("probe AccountUtils.o -> empty");
                return String::new().into();
            }
            "com/zenmen/palmchat/account/AccountUtils->m(Landroid/content/Context;)Ljava/lang/String;" => {
                let _context = args.get::<DvmObject>(vm);
                self.shared
                    .borrow_mut()
                    .jni("probe AccountUtils.m -> empty");
                return String::new().into();
            }
            "java/lang/String->getBytes()[B" => {
                let value = instance
                    .as_ref()
                    .map(|object| string_from_object(object))
                    .unwrap_or_default();
                return value.into_bytes().into();
            }
            "java/lang/String->getBytes(Ljava/lang/String;)[B" => {
                let value = instance
                    .as_ref()
                    .map(|object| string_from_object(object))
                    .unwrap_or_default();
                let _charset = args.get::<String>(vm);
                return value.into_bytes().into();
            }
            "java/lang/String->length()I" => {
                let value = instance
                    .as_ref()
                    .map(|object| string_from_object(object))
                    .unwrap_or_default();
                return (value.chars().count() as i32).into();
            }
            "java/lang/String->equals(Ljava/lang/Object;)Z" => {
                let left = instance
                    .as_ref()
                    .map(|object| string_from_object(object))
                    .unwrap_or_default();
                let right = string_from_id(vm, args.get::<i64>(vm));
                return (left == right).into();
            }
            "java/lang/String->toString()Ljava/lang/String;" => {
                let value = instance
                    .as_ref()
                    .map(|object| string_from_object(object))
                    .unwrap_or_default();
                return value.into();
            }
            "com/zenmen/palmchat/AppContext->getSecretKey()Landroid/util/Pair;"
            | "com/zenmen/palmchat/AppContext->getSecretKey(Z)Landroid/util/Pair;" => {
                if let Some(pair) = self.current_app_context_secret_pair() {
                    return self.secret_pair_object(vm, &pair).into();
                }
                return JniValue::Null;
            }
            "com/zenmen/palmchat/AppContext->setSecretKey(Ljava/lang/String;Ljava/lang/String;)V" => {
                let secret_key = args.get::<String>(vm);
                let secret_iv = args.get::<String>(vm);
                self.set_app_context_secret_pair(Some(PalmchatSecretPair {
                    key: secret_key.into_bytes(),
                    iv: secret_iv.into_bytes(),
                }));
                return JniValue::Void;
            }
            "com/zenmen/palmchat/AppContext->setContextSecretKey(Landroid/util/Pair;)V" => {
                let pair = args.get::<DvmObject>(vm);
                self.set_app_context_secret_pair(secret_pair_from_dvm_object(&pair));
                return JniValue::Void;
            }
            "com/zenmen/palmchat/AppContext->getPackageName()Ljava/lang/String;"
            | "android/app/Application->getPackageName()Ljava/lang/String;"
            | "android/content/Context->getPackageName()Ljava/lang/String;" => {
                return self.package_name.clone().into();
            }
            "com/zenmen/palmchat/AppContext->getPackageResourcePath()Ljava/lang/String;"
            | "android/app/Application->getPackageResourcePath()Ljava/lang/String;"
            | "android/content/Context->getPackageResourcePath()Ljava/lang/String;"
            | "com/zenmen/palmchat/AppContext->getPackageCodePath()Ljava/lang/String;"
            | "android/app/Application->getPackageCodePath()Ljava/lang/String;"
            | "android/content/Context->getPackageCodePath()Ljava/lang/String;" => {
                return self.apk_path.clone().into();
            }
            "com/zenmen/palmchat/AppContext->getFilesDir()Ljava/io/File;"
            | "android/app/Application->getFilesDir()Ljava/io/File;"
            | "android/content/Context->getFilesDir()Ljava/io/File;" => {
                return self.file_object(vm, &self.app_context_fs.files_dir).into();
            }
            "com/zenmen/palmchat/AppContext->getCacheDir()Ljava/io/File;"
            | "android/app/Application->getCacheDir()Ljava/io/File;"
            | "android/content/Context->getCacheDir()Ljava/io/File;" => {
                return self.file_object(vm, &self.app_context_fs.cache_dir).into();
            }
            "com/zenmen/palmchat/AppContext->getDataDir()Ljava/io/File;"
            | "android/app/Application->getDataDir()Ljava/io/File;"
            | "android/content/Context->getDataDir()Ljava/io/File;" => {
                return self.file_object(vm, &self.app_context_fs.legacy_data_dir).into();
            }
            "com/zenmen/palmchat/AppContext->getDir(Ljava/lang/String;I)Ljava/io/File;"
            | "android/app/Application->getDir(Ljava/lang/String;I)Ljava/io/File;"
            | "android/content/Context->getDir(Ljava/lang/String;I)Ljava/io/File;" => {
                let name = args.get::<String>(vm);
                let _mode = args.get::<i32>(vm);
                let guest_path = self.app_context_fs.guest_dir_for_name(name.trim());
                if let Err(err) = self.app_context_fs.ensure_host_dir_for_guest(&guest_path) {
                    self.shared.borrow_mut().native(&format!(
                        "app_context getDir create_failed guest_path={} err={:#}",
                        guest_path, err
                    ));
                }
                return self.file_object(vm, &guest_path).into();
            }
            "com/zenmen/palmchat/AppContext->getAssets()Landroid/content/res/AssetManager;"
            | "android/app/Application->getAssets()Landroid/content/res/AssetManager;"
            | "android/content/Context->getAssets()Landroid/content/res/AssetManager;" => {
                return self.asset_manager_object(vm).into();
            }
            "java/io/File->getAbsolutePath()Ljava/lang/String;"
            | "java/io/File->getPath()Ljava/lang/String;"
            | "java/io/File->toString()Ljava/lang/String;" => {
                let Some(instance) = instance else {
                    return String::new().into();
                };
                let value = data_ref::<PalmchatFileState>(instance)
                    .map(|state| state.guest_path.clone())
                    .unwrap_or_default();
                return value.into();
            }
            "java/io/File->exists()Z" => {
                let Some(instance) = instance else {
                    return false.into();
                };
                let exists = data_ref::<PalmchatFileState>(instance)
                    .map(|state| state.host_path.exists())
                    .unwrap_or(false);
                return exists.into();
            }
            "java/io/File->isDirectory()Z" => {
                let Some(instance) = instance else {
                    return false.into();
                };
                let is_dir = data_ref::<PalmchatFileState>(instance)
                    .map(|state| state.host_path.is_dir())
                    .unwrap_or(false);
                return is_dir.into();
            }
            "java/io/File->mkdirs()Z" => {
                let Some(instance) = instance else {
                    return false.into();
                };
                let created = data_ref::<PalmchatFileState>(instance)
                    .map(|state| {
                        fs::create_dir_all(&state.host_path).is_ok() && state.host_path.is_dir()
                    })
                    .unwrap_or(false);
                return created.into();
            }
            "java/io/File->getParent()Ljava/lang/String;" => {
                let Some(instance) = instance else {
                    return String::new().into();
                };
                let value = data_ref::<PalmchatFileState>(instance)
                    .and_then(|state| {
                        Path::new(&state.guest_path)
                            .parent()
                            .map(|path| path.to_string_lossy().to_string())
                    })
                    .unwrap_or_default();
                return value.into();
            }
            "java/io/File->getParentFile()Ljava/io/File;" => {
                let Some(instance) = instance else {
                    return JniValue::Null;
                };
                let Some(parent) = data_ref::<PalmchatFileState>(instance)
                    .and_then(|state| {
                        Path::new(&state.guest_path)
                            .parent()
                            .map(|path| path.to_string_lossy().to_string())
                    })
                else {
                    return JniValue::Null;
                };
                return self.file_object(vm, &parent).into();
            }
            "android/text/TextUtils->isEmpty(Ljava/lang/CharSequence;)Z" => {
                let text = string_from_id(vm, args.get::<i64>(vm));
                return text.trim().is_empty().into();
            }
            "android/util/Log->d(Ljava/lang/String;Ljava/lang/String;)I"
            | "android/util/Log->e(Ljava/lang/String;Ljava/lang/String;)I"
            | "android/util/Log->i(Ljava/lang/String;Ljava/lang/String;)I"
            | "android/util/Log->w(Ljava/lang/String;Ljava/lang/String;)I" => {
                let tag = args.get::<String>(vm);
                let msg = args.get::<String>(vm);
                self.shared
                    .borrow_mut()
                    .native(&format!("android_log tag={} msg={}", tag, msg));
                return 0.into();
            }
            "defpackage/sw4->d()Lorg/json/JSONObject;" => {
                let Some(instance) = instance else {
                    return JniValue::Null;
                };
                let Some(state) = data_ref::<PalmchatSw4State>(instance) else {
                    return JniValue::Null;
                };
                let json_class = vm
                    .resolve_class("org/json/JSONObject")
                    .map(|(_, class)| class)
                    .expect("failed to resolve org/json/JSONObject");
                self.shared.borrow_mut().jni(&format!(
                    "probe sw4.d -> url_len={} keys={} enc_type={} enc={}",
                    state.url.len(),
                    state.body_map.len(),
                    state.encrypted_body_type,
                    state.encrypted_request
                ));
                let object = new_mut_data_object(
                    json_class,
                    JsonObjectState {
                        map: state.body_map.clone(),
                    },
                );
                let ref_id = vm.add_global_ref(object);
                return DvmObject::ObjectRef(ref_id).into();
            }
            "org/json/JSONObject->toString()Ljava/lang/String;" => {
                let Some(instance) = instance else {
                    return "{}".to_string().into();
                };
                let value = data_ref::<JsonObjectState>(instance)
                    .map(|state| state.to_json_string())
                    .unwrap_or_else(|| "{}".to_string());
                return value.into();
            }
            "org/json/JSONObject->optString(Ljava/lang/String;)Ljava/lang/String;" => {
                let key = args.get::<String>(vm);
                let Some(instance) = instance else {
                    return String::new().into();
                };
                let value = data_ref::<JsonObjectState>(instance)
                    .map(|state| state.opt_string(&key))
                    .unwrap_or_default();
                return value.into();
            }
            "org/json/JSONObject->optInt(Ljava/lang/String;)I" => {
                let key = args.get::<String>(vm);
                let Some(instance) = instance else {
                    return 0.into();
                };
                let value = data_ref::<JsonObjectState>(instance)
                    .map(|state| state.opt_int(&key))
                    .unwrap_or(0);
                return value.into();
            }
            "org/json/JSONObject->optBoolean(Ljava/lang/String;)Z" => {
                let key = args.get::<String>(vm);
                let Some(instance) = instance else {
                    return false.into();
                };
                let value = data_ref::<JsonObjectState>(instance)
                    .map(|state| state.opt_bool(&key))
                    .unwrap_or(false);
                return value.into();
            }
            "org/json/JSONObject->has(Ljava/lang/String;)Z" => {
                let key = args.get::<String>(vm);
                let Some(instance) = instance else {
                    return false.into();
                };
                let value = data_ref::<JsonObjectState>(instance)
                    .map(|state| state.has_key(&key))
                    .unwrap_or(false);
                return value.into();
            }
            "org/json/JSONObject->getString(Ljava/lang/String;)Ljava/lang/String;" => {
                let key = args.get::<String>(vm);
                let Some(instance) = instance else {
                    return String::new().into();
                };
                let value = data_ref::<JsonObjectState>(instance)
                    .map(|state| state.opt_string(&key))
                    .unwrap_or_default();
                return value.into();
            }
            "org/json/JSONObject->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;" => {
                let key = args.get::<String>(vm);
                let value_id = args.get::<i64>(vm);
                let value = object_from_id_mut(vm, value_id)
                    .map(|object| object_to_json_value(&*object))
                    .unwrap_or(Value::Null);
                if key == "hashKey" {
                    let value_text = value
                        .as_str()
                        .map(ToString::to_string)
                        .unwrap_or_else(|| value.to_string());
                    self.shared
                        .borrow_mut()
                        .native(&format!("json_put hashKey value={}", value_text));
                }
                let Some(instance) = instance else {
                    return JniValue::Null;
                };
                if let Some(state) = data_mut::<JsonObjectState>(instance) {
                    state.put_value(&key, value);
                    return instance.clone().into();
                }
                return JniValue::Null;
            }
            _ => {}
        }
        Self::default_return(acc)
    }

    fn get_field_value(
        &mut self,
        _vm: &mut DalvikVM64<()>,
        class: &Rc<DvmClass>,
        field: &emulator::android::dvm::member::DvmField,
        _instance: Option<&mut DvmObject>,
    ) -> JniValue {
        self.shared.borrow_mut().jni(&format!(
            "get_field class={} field={} sig={}",
            class.name, field.name, field.signature
        ));
        if class.name == "android/content/res/AssetManager"
            && field.name == "mObject"
            && field.signature == "J"
        {
            return (self.asset_manager_native_ptr as i64).into();
        }
        if class.name == "com/zenmen/palmchat/messaging/CreateConnectionDelegate"
            && field.name == "c"
            && field.signature == "Landroid/content/res/AssetManager;"
        {
            return self.asset_manager_object(_vm).into();
        }
        if class.name == "com/zenmen/palmchat/messaging/CreateConnectionDelegate"
            && field.name == "f14672a"
            && field.signature == "Landroid/content/Context;"
        {
            let class = _vm
                .resolve_class("com/zenmen/palmchat/AppContext")
                .map(|(_, class)| class)
                .expect("failed to resolve com/zenmen/palmchat/AppContext");
            return new_mut_data_object(class, self.app_context_state()).into();
        }
        JniValue::Null
    }

    fn set_field_value(
        &mut self,
        _vm: &mut DalvikVM64<()>,
        class: &Rc<DvmClass>,
        field: &emulator::android::dvm::member::DvmField,
        _instance: Option<&mut DvmObject>,
        value: JniValue,
    ) {
        self.shared.borrow_mut().jni(&format!(
            "set_field class={} field={} sig={} value={}",
            class.name,
            field.name,
            field.signature,
            value.to_string()
        ));
    }
}

#[derive(Default)]
struct JsonObjectState {
    map: Map<String, Value>,
}

struct PalmchatAppContextState {
    package_name: String,
    apk_path: String,
    fs: PalmchatAppContextFs,
}

#[derive(Clone, Debug)]
struct PalmchatFileState {
    guest_path: String,
    host_path: PathBuf,
}

impl JsonObjectState {
    fn empty() -> Self {
        Self { map: Map::new() }
    }

    fn from_raw(raw: &str) -> Self {
        let parsed = serde_json::from_str::<Value>(raw).ok();
        match parsed {
            Some(Value::Object(map)) => Self { map },
            _ => Self::empty(),
        }
    }

    fn to_json_string(&self) -> String {
        Value::Object(self.map.clone()).to_string()
    }

    fn has_key(&self, key: &str) -> bool {
        self.map.contains_key(key)
    }

    fn put_value(&mut self, key: &str, value: Value) {
        self.map.insert(key.to_string(), value);
    }

    fn opt_string(&self, key: &str) -> String {
        match self.map.get(key) {
            Some(Value::String(value)) => value.clone(),
            Some(Value::Number(value)) => value.to_string(),
            Some(Value::Bool(value)) => value.to_string(),
            Some(Value::Null) | None => String::new(),
            Some(other) => other.to_string(),
        }
    }

    fn opt_int(&self, key: &str) -> i32 {
        match self.map.get(key) {
            Some(Value::Number(value)) => value.as_i64().unwrap_or(0) as i32,
            Some(Value::String(value)) => value.parse::<i32>().unwrap_or(0),
            Some(Value::Bool(true)) => 1,
            Some(Value::Bool(false)) => 0,
            _ => 0,
        }
    }

    fn opt_bool(&self, key: &str) -> bool {
        match self.map.get(key) {
            Some(Value::Bool(value)) => *value,
            Some(Value::Number(value)) => value.as_i64().unwrap_or(0) != 0,
            Some(Value::String(value)) => parse_bool_like(value),
            _ => false,
        }
    }
}

pub fn run(args: Vec<String>) -> Result<()> {
    if args.is_empty() {
        print_usage();
        return Ok(());
    }

    let mut args = args;
    let command = args.remove(0);
    let opts = parse_options(&args);
    if matches!(command.as_str(), "help" | "--help" | "-h") {
        print_usage();
        return Ok(());
    }
    match command.as_str() {
        "report" => {
            let report = build_palmchat_flow_report_from_opts(&opts)?;
            if let Some(path) = opts.get("--json-out").map(PathBuf::from) {
                write_json_file(&path, &serde_json::to_value(&report)?)?;
            }
            if let Some(path) = opts.get("--md-out").map(PathBuf::from) {
                write_text_file(&path, &render_palmchat_flow_report_markdown(&report))?;
            }
            println!("{}", serde_json::to_string_pretty(&report)?);
            Ok(())
        }
        "smoke" | "invoke" | "flow" | "decrypt-trace" | "captcha-ui-debug" => {
            let config_path = PathBuf::from(
                opts.get("--config")
                    .cloned()
                    .unwrap_or_else(default_config_path),
            );
            let mut lab = PalmchatLab::load_with_backend(
                &config_path,
                opts.get("--backend").map(String::as_str),
            )?;
            let output = match command.as_str() {
                "smoke" => lab.run_smoke()?,
                "invoke" => lab.run_invoke(&opts)?,
                "flow" => lab.run_flow(&opts)?,
                "decrypt-trace" => lab.run_decrypt_trace(&opts)?,
                "captcha-ui-debug" => lab.run_captcha_ui_debug(&opts)?,
                _ => unreachable!(),
            };
            if let Some(path) = opts.get("--json-out").map(PathBuf::from) {
                write_json_file(&path, &output)?;
            }
            if command != "decrypt-trace"
                && (opts.contains_key("--report-json") || opts.contains_key("--report-md"))
                && !(command == "captcha-ui-debug"
                    && !opts
                        .get("--flow")
                        .map(|value| parse_bool_like(value))
                        .unwrap_or(true))
            {
                let report = parse_palmchat_flow_report(
                    &lab.config.trace_out_dir.join("palmchat_native.log"),
                    Some(&config_path),
                    Some(lab.config.trace_out_dir.as_path()),
                )?;
                if let Some(path) = opts.get("--report-json").map(PathBuf::from) {
                    write_json_file(&path, &serde_json::to_value(&report)?)?;
                }
                if let Some(path) = opts.get("--report-md").map(PathBuf::from) {
                    write_text_file(&path, &render_palmchat_flow_report_markdown(&report))?;
                }
            }
            println!("{}", serde_json::to_string_pretty(&output)?);
            Ok(())
        }
        _ => Err(anyhow!("unknown palmchat command: {command}")),
    }
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

fn print_usage() {
    eprintln!("palmchat commands:");
    eprintln!("  smoke  [--config <path>] [--backend <auto|dynarmic|unicorn>] [--json-out <path>]");
    eprintln!("  invoke [--config <path>] [--backend <auto|dynarmic|unicorn>] --method <name> [--arg1 <v>] [--arg2 <v>] [--arg3 <v>] [--secret-key <k>] [--secret-iv <iv>] [--json-out <path>]");
    eprintln!("         appInitProbe/gateProbe overrides: [--privacy-agree <bool>] [--read-phone-state <bool>] [--priv-info-init <bool>] [--android-id <str>] [--imei <str>] [--mac <str>] [--seed-sdid <str>] [--seed-local-smid <str>] [--seed-device-label <str>] [--process-name <str>]");
    eprintln!("  flow   [--config <path>] [--backend <auto|dynarmic|unicorn>] [--arg1 <json>] [--bridge-stage1-json <json>] [--arg2 <cipher_mode>] [--arg3 <use_new_key_bool>] [--no-empty-params <bool>] [--seed-device-id <id>] [--seed-local-smid <id>] [--seed-dhid <id>] [--seed-sdid <id>] [--seed-imei <id>] [--seed-mac <id>] [--seed-oneid <id>] [--seed-oaid <id>] [--seed-android-id <id>] [--seed-channel-id <id>] [--seed-appid <id>] [--seed-ip-info <json>] [--seed-device-label <str>] [--secret-key <k>] [--secret-iv <iv>] [--smssend-test <bool>] [--smssend-two-step <bool>] [--smssend-url <url>] [--smssend-base-url <url>] [--request-id <id>] [--device-id <id>] [--uid <id>] [--token <str>] [--session-id <id>] [--callback-id <id>] [--pid <id>] [--sys-uid <id>] [--smssend-timeout-ms <ms>] [--smssend-user-agent <ua>] [--transport-runtime <auto|direct|okhttp-bridge>] [--okhttp-bridge-url <url>] [--http1-only <bool>] [--json-out <path>] [--report-json <path>] [--report-md <path>]");
    eprintln!("  captcha-ui-debug [--config <path>] [--backend <auto|dynarmic|unicorn>] [--stage1-json <json>|--arg1 <json>] [--interactive <bool>] [--ui-mode <sdk|form|tty|headless>] [--sdk-html <path>] [--sdk-backfill-wait-ms <ms>] [--verify-status <bool>] [--rid <str>] [--mode-type <str>] [--diff-time <ms>] [--flow <bool>] [--arg2 <cipher_mode>] [--arg3 <use_new_key_bool>] [--no-empty-params <bool>] [--seed-device-id <id>] [--seed-local-smid <id>] [--seed-dhid <id>] [--seed-sdid <id>] [--seed-imei <id>] [--seed-mac <id>] [--seed-oneid <id>] [--seed-oaid <id>] [--seed-android-id <id>] [--seed-channel-id <id>] [--seed-appid <id>] [--seed-ip-info <json>] [--seed-device-label <str>] [--secret-key <k>] [--secret-iv <iv>] [--smssend-test <bool>] [--smssend-two-step <bool>] [--smssend-url <url>] [--smssend-base-url <url>] [--request-id <id>] [--device-id <id>] [--uid <id>] [--token <str>] [--session-id <id>] [--callback-id <id>] [--pid <id>] [--sys-uid <id>] [--smssend-timeout-ms <ms>] [--smssend-user-agent <ua>] [--transport-runtime <auto|direct|okhttp-bridge>] [--okhttp-bridge-url <url>] [--http1-only <bool>] [--json-out <path>] [--jsonl-out <path>] [--report-json <path>] [--report-md <path>]");
    eprintln!("  decrypt-trace [--config <path>] [--backend <auto|dynarmic|unicorn>] [--flow-json <json>] [--flow-mode <cipher_mode>] [--flow-use-new-key <bool>] [--skip-flow]");
    eprintln!("                [--bridge-stage1-json <json>] [--type-input <bytes_or_hex>] [--type-encrypt-mode <int>] [--type-encrypt-use-new-key <bool>] [--type-decrypt-mode <int>] [--type-decrypt-use-new-key <bool>]");
    eprintln!("                [--secret-key <k> --secret-iv <iv>] [--jsonl-out <path>] [--report-json <path>] [--report-md <path>]");
    eprintln!(
        "  report [--config <path>] [--native-log <path>] [--json-out <path>] [--md-out <path>]"
    );
    eprintln!("    methods: skeyAvailable, wksecA, wksecC, ac1AppList, fm1Dfp, mhBaseArgs, flowEncrypt, createCKey, setSecretKeys, getCkVersion, ckDiag, appInitProbe, gateProbe, getEncryptedCKey, setLxData, cipherWithHashKey, cipherWithType");
}

fn default_config_path() -> String {
    if let Ok(path) = std::env::var("RNIDBG_PALMCHAT_CONFIG") {
        return path;
    }
    "config/palmchat-config.local.json".to_string()
}

fn validate_config(config: &PalmchatConfig) -> Result<()> {
    for path in [&config.apk_path, &config.so_path] {
        if !path.exists() {
            return Err(anyhow!("required path not found: {}", path.display()));
        }
    }
    if let Some(path) = &config.got_seed_path {
        if !path.exists() {
            return Err(anyhow!("got_seed_path not found: {}", path.display()));
        }
    }
    if let Some(path) = &config.wksec_so_path {
        if !path.exists() {
            return Err(anyhow!("wksec_so_path not found: {}", path.display()));
        }
    }
    if let Some(path) = &config.app_manifest_path {
        if !path.exists() {
            return Err(anyhow!("app_manifest_path not found: {}", path.display()));
        }
    }
    for entry in &config.runtime_page_patches {
        validate_page_patch_entry(entry)?;
    }
    for entry in &config.runtime_raw_maps {
        validate_raw_memory_map_entry(entry)?;
    }
    for entry in &config.runtime_page_patches_after_create_ckey {
        validate_page_patch_entry(entry)?;
    }
    for (name, path) in &config.system_lib_overrides {
        if !path.exists() {
            return Err(anyhow!(
                "system_lib_overrides[{name}] not found: {}",
                path.display()
            ));
        }
    }
    Ok(())
}

fn build_palmchat_flow_report_from_opts(
    opts: &HashMap<String, String>,
) -> Result<PalmchatFlowReport> {
    let config_path = opts.get("--config").map(PathBuf::from);
    let config = match config_path.as_ref() {
        Some(path) => Some(PalmchatConfig::load(path)?),
        None => None,
    };
    let native_log = if let Some(path) = opts.get("--native-log").map(PathBuf::from) {
        path
    } else if let Some(cfg) = config.as_ref() {
        cfg.trace_out_dir.join("palmchat_native.log")
    } else {
        return Err(anyhow!(
            "report requires --native-log or --config so the native log can be located"
        ));
    };
    let mut report = parse_palmchat_flow_report(
        &native_log,
        config_path.as_deref(),
        config.as_ref().map(|cfg| cfg.trace_out_dir.as_path()),
    )?;
    if report.cipher_evidence.apk_path.is_none() {
        if let Some(cfg) = config.as_ref() {
            report.cipher_evidence.apk_path = Some(cfg.apk_path.display().to_string());
        }
    }
    if report.cipher_evidence.apk_size.is_none() {
        if let Some(apk_path) = report.cipher_evidence.apk_path.as_ref() {
            if let Ok(meta) = fs::metadata(apk_path) {
                report.cipher_evidence.apk_size = Some(meta.len());
            }
        }
    }
    Ok(report)
}

fn parse_palmchat_flow_report(
    native_log: &Path,
    config_path: Option<&Path>,
    trace_out_dir: Option<&Path>,
) -> Result<PalmchatFlowReport> {
    let raw = fs::read_to_string(native_log)
        .with_context(|| format!("failed to read native log: {}", native_log.display()))?;
    let mut report = PalmchatFlowReport {
        status: "blocked".to_string(),
        native_log: native_log.display().to_string(),
        config_path: config_path.map(|path| path.display().to_string()),
        trace_out_dir: trace_out_dir.map(|path| path.display().to_string()),
        flow: None,
        flow_result: None,
        steps: BTreeMap::new(),
        cipher_evidence: PalmchatCipherEvidenceReport::default(),
        plt_targets: BTreeMap::new(),
    };

    for line in raw.lines() {
        let Some((timestamp, message)) = split_log_line(line) else {
            continue;
        };
        parse_step_message(&mut report, timestamp, message)?;
        parse_dynamic_evidence_message(&mut report, message)?;
    }

    if let Some(result) = &report.flow_result {
        report.flow = result
            .get("flow")
            .and_then(Value::as_str)
            .map(ToString::to_string);
        let cipher_ok = result
            .get("cipher_null")
            .and_then(Value::as_bool)
            .map(|value| !value)
            .unwrap_or(false);
        let ckey_ok = result
            .get("encrypted_ckey_hex")
            .and_then(Value::as_str)
            .map(|value| !value.is_empty())
            .unwrap_or(false);
        if cipher_ok && ckey_ok {
            report.status = "ok".to_string();
        }
    }

    if let Some(apk_path) = report.cipher_evidence.apk_path.as_ref() {
        if let Ok(meta) = fs::metadata(apk_path) {
            report.cipher_evidence.apk_size = Some(meta.len());
        }
    }

    Ok(report)
}

fn split_log_line(line: &str) -> Option<(&str, &str)> {
    if !line.starts_with('[') {
        return None;
    }
    let end = line.find("] ")?;
    Some((&line[1..end], &line[end + 2..]))
}

fn parse_step_message(
    report: &mut PalmchatFlowReport,
    timestamp: &str,
    message: &str,
) -> Result<()> {
    if let Some(raw) = message.strip_prefix("flow result=") {
        report.flow_result =
            Some(serde_json::from_str(raw).with_context(|| {
                format!("failed to parse flow result json from native log: {raw}")
            })?);
        return Ok(());
    }

    let Some(rest) = message.strip_prefix("flow step=") else {
        return Ok(());
    };
    let Some((step_name, event)) = rest.split_once(' ') else {
        return Ok(());
    };
    let step = report.steps.entry(step_name.to_string()).or_default();
    if event == "start" {
        step.start_at = Some(timestamp.to_string());
    } else if let Some(value) = event.strip_prefix("return=") {
        step.return_debug = Some(value.to_string());
    } else if event == "done" || event.starts_with("done ") {
        step.end_at = Some(timestamp.to_string());
        if let Some(note) = event.strip_prefix("done ").map(str::trim) {
            if !note.is_empty() {
                step.done_note = Some(note.to_string());
            }
        }
        if let (Some(start_at), Some(end_at)) = (step.start_at.as_deref(), step.end_at.as_deref()) {
            let start = chrono::DateTime::parse_from_rfc3339(start_at)
                .with_context(|| format!("invalid start timestamp in native log: {start_at}"))?;
            let end = chrono::DateTime::parse_from_rfc3339(end_at)
                .with_context(|| format!("invalid end timestamp in native log: {end_at}"))?;
            step.duration_ms = Some((end - start).num_milliseconds());
        }
    }
    Ok(())
}

fn parse_dynamic_evidence_message(report: &mut PalmchatFlowReport, message: &str) -> Result<()> {
    for name in [
        "plt_4dbc0",
        "plt_4efe0",
        "plt_4fef0",
        "plt_52a80",
        "plt_52010",
    ] {
        if message.contains(name) {
            if let Some(target) = extract_field_hex(message, "target=0x") {
                report
                    .plt_targets
                    .entry(name.to_string())
                    .or_insert_with(|| format!("0x{target:x}"));
            }
        }
    }

    if message.contains("plt_4dbc0") {
        if report.cipher_evidence.apk_path.is_none() {
            report.cipher_evidence.apk_path = extract_quoted_field(message, "path=");
        }
        if report.cipher_evidence.apk_mode.is_none() {
            report.cipher_evidence.apk_mode = extract_quoted_field(message, "mode=");
        }
    }

    if message.contains("plt_4efe0") {
        if report.cipher_evidence.fread_target.is_none() {
            report.cipher_evidence.fread_target =
                extract_field_hex(message, "target=0x").map(|value| format!("0x{value:x}"));
        }
        if report.cipher_evidence.fread_size.is_none() {
            report.cipher_evidence.fread_size = extract_field_hex(message, "fread_size=0x");
        }
        if report.cipher_evidence.fread_nmemb.is_none() {
            report.cipher_evidence.fread_nmemb = extract_field_hex(message, "fread_nmemb=0x");
        }
    }

    if let Some(raw) = message.strip_prefix("json_put hashKey value=") {
        if report.cipher_evidence.hash_key.is_none() {
            let value = raw.trim().trim_matches('"').to_string();
            if !value.is_empty() {
                report.cipher_evidence.hash_key = Some(value);
            }
        }
    }

    if let Some(rest) = message.strip_prefix("unicorn cipher_after_fread ") {
        report.cipher_evidence.chunk_iterations_observed += 1;
        if report.cipher_evidence.chunk_samples.len() < 4 {
            let iteration = extract_field_decimal(rest, "iter=").unwrap_or_default() as usize;
            let fread_ret = extract_field_hex(rest, "fread_ret=0x").unwrap_or_default();
            let chunk_head = extract_field_token(rest, "chunk_head=").unwrap_or_default();
            let apk_offset = (report.cipher_evidence.chunk_samples.len() as u64) * 0x200;
            let matches_apk_prefix = match report.cipher_evidence.apk_path.as_ref() {
                Some(apk_path) => {
                    chunk_head_matches_apk_prefix(Path::new(apk_path), apk_offset, &chunk_head)
                        .unwrap_or(false)
                }
                None => false,
            };
            report
                .cipher_evidence
                .chunk_samples
                .push(PalmchatChunkSample {
                    iteration,
                    fread_ret,
                    apk_offset,
                    matches_apk_prefix,
                    chunk_head,
                });
        }
    }

    Ok(())
}

fn extract_field_token(message: &str, prefix: &str) -> Option<String> {
    let start = message.find(prefix)? + prefix.len();
    let tail = &message[start..];
    let end = tail.find(' ').unwrap_or(tail.len());
    Some(tail[..end].to_string())
}

fn extract_field_decimal(message: &str, prefix: &str) -> Option<u64> {
    extract_field_token(message, prefix)?.parse::<u64>().ok()
}

fn extract_field_hex(message: &str, prefix: &str) -> Option<u64> {
    u64::from_str_radix(&extract_field_token(message, prefix)?, 16).ok()
}

fn extract_quoted_field(message: &str, prefix: &str) -> Option<String> {
    let start = message.find(prefix)? + prefix.len();
    let tail = &message[start..];
    if !tail.starts_with('"') {
        return None;
    }
    let tail = &tail[1..];
    let end = tail.find('"')?;
    Some(tail[..end].to_string())
}

fn chunk_head_matches_apk_prefix(
    apk_path: &Path,
    apk_offset: u64,
    chunk_head_hex: &str,
) -> Result<bool> {
    let decoded = hex::decode(chunk_head_hex)
        .with_context(|| format!("invalid chunk head hex: {chunk_head_hex}"))?;
    if decoded.is_empty() {
        return Ok(false);
    }
    let compare_len = decoded.len().min(64);
    let apk_bytes = fs::read(apk_path).with_context(|| {
        format!(
            "failed to read apk for chunk comparison: {}",
            apk_path.display()
        )
    })?;
    let start = apk_offset as usize;
    let end = start.saturating_add(compare_len);
    if end > apk_bytes.len() {
        return Ok(false);
    }
    Ok(apk_bytes[start..end] == decoded[..compare_len])
}

fn render_palmchat_flow_report_markdown(report: &PalmchatFlowReport) -> String {
    let mut lines = Vec::new();
    lines.push("# Palmchat rnidbg Flow Report".to_string());
    lines.push(String::new());
    lines.push(format!("- status: `{}`", report.status));
    lines.push(format!("- native_log: `{}`", report.native_log));
    if let Some(config_path) = &report.config_path {
        lines.push(format!("- config_path: `{config_path}`"));
    }
    if let Some(trace_out_dir) = &report.trace_out_dir {
        lines.push(format!("- trace_out_dir: `{trace_out_dir}`"));
    }
    if let Some(flow) = &report.flow {
        lines.push(format!("- flow: `{flow}`"));
    }

    lines.push(String::new());
    lines.push("## Steps".to_string());
    for (name, step) in &report.steps {
        let mut detail = format!("- `{name}`");
        if let Some(duration_ms) = step.duration_ms {
            detail.push_str(&format!(" duration_ms={duration_ms}"));
        }
        if let Some(done_note) = &step.done_note {
            detail.push_str(&format!(" done_note=`{done_note}`"));
        }
        if let Some(return_debug) = &step.return_debug {
            detail.push_str(&format!(" return=`{return_debug}`"));
        }
        lines.push(detail);
    }

    lines.push(String::new());
    lines.push("## Cipher Evidence".to_string());
    if let Some(apk_path) = &report.cipher_evidence.apk_path {
        lines.push(format!("- apk_path: `{apk_path}`"));
    }
    if let Some(apk_mode) = &report.cipher_evidence.apk_mode {
        lines.push(format!("- apk_mode: `{apk_mode}`"));
    }
    if let Some(apk_size) = report.cipher_evidence.apk_size {
        lines.push(format!("- apk_size: `{apk_size}`"));
    }
    if let Some(hash_key) = &report.cipher_evidence.hash_key {
        lines.push(format!("- hash_key: `{hash_key}`"));
    }
    if let Some(fread_target) = &report.cipher_evidence.fread_target {
        lines.push(format!("- fread_target: `{fread_target}`"));
    }
    if let Some(fread_size) = report.cipher_evidence.fread_size {
        lines.push(format!("- fread_size: `{fread_size}`"));
    }
    if let Some(fread_nmemb) = report.cipher_evidence.fread_nmemb {
        lines.push(format!("- fread_nmemb: `{fread_nmemb}`"));
    }
    lines.push(format!(
        "- chunk_iterations_observed: `{}`",
        report.cipher_evidence.chunk_iterations_observed
    ));
    for sample in &report.cipher_evidence.chunk_samples {
        lines.push(format!(
            "- chunk_sample iter={} apk_offset=0x{:x} fread_ret=0x{:x} matches_apk_prefix={} chunk_head=`{}`",
            sample.iteration,
            sample.apk_offset,
            sample.fread_ret,
            sample.matches_apk_prefix,
            sample.chunk_head
        ));
    }

    if !report.plt_targets.is_empty() {
        lines.push(String::new());
        lines.push("## PLT Targets".to_string());
        for (name, target) in &report.plt_targets {
            lines.push(format!("- `{name}` -> `{target}`"));
        }
    }

    if let Some(flow_result) = &report.flow_result {
        if let Some(bridge_surface) = flow_result.get("v7_captcha_bridge_surface") {
            lines.push(String::new());
            lines.push("## V7 Captcha Bridge".to_string());
            if let Some(branch_type) = bridge_surface.get("branch_type").and_then(Value::as_str) {
                lines.push(format!("- branch_type: `{branch_type}`"));
            }
            if let Some(key_point) = bridge_surface
                .get("key_point")
                .and_then(|value| value.get("name"))
                .and_then(Value::as_str)
            {
                lines.push(format!("- key_point: `{key_point}`"));
            }
            if let Some(diff) = bridge_surface.get("retry_patch_diff") {
                lines.push("- retry_patch_diff:".to_string());
                lines.push("```json".to_string());
                lines.push(serde_json::to_string_pretty(diff).unwrap_or_else(|_| "{}".to_string()));
                lines.push("```".to_string());
            }
        }
        if let Some(upstream) = flow_result.get("v7_captcha_upstream_production") {
            lines.push(String::new());
            lines.push("## V7 Captcha Upstream".to_string());
            if let Some(summary) = upstream.get("summary").and_then(Value::as_str) {
                lines.push(format!("- summary: `{summary}`"));
            }
            if let Some(chain) = upstream.get("production_chain").and_then(Value::as_array) {
                for item in chain {
                    let order = item
                        .get("order")
                        .and_then(Value::as_u64)
                        .unwrap_or_default();
                    let node = item
                        .get("node")
                        .and_then(Value::as_str)
                        .unwrap_or("unknown");
                    let kind = item
                        .get("kind")
                        .and_then(Value::as_str)
                        .unwrap_or("unknown");
                    let role = item.get("role").and_then(Value::as_str).unwrap_or("");
                    lines.push(format!("- `{order}` `{node}` [{kind}] {role}"));
                }
            }
        }
        if let Some(base_field) = flow_result.get("v7_base_field_production") {
            lines.push(String::new());
            lines.push("## V7 Base Field Production".to_string());
            if let Some(summary) = base_field.get("summary").and_then(Value::as_str) {
                lines.push(format!("- summary: `{summary}`"));
            }
            if let Some(field_sources) = base_field.get("field_sources") {
                lines.push("- field_sources:".to_string());
                lines.push("```json".to_string());
                lines.push(
                    serde_json::to_string_pretty(field_sources)
                        .unwrap_or_else(|_| "{}".to_string()),
                );
                lines.push("```".to_string());
            }
        }
        if let Some(app_init) = flow_result.get("app_init_upstream_observation") {
            lines.push(String::new());
            lines.push("## App Init Upstream".to_string());
            if let Some(summary) = app_init.get("summary").and_then(Value::as_str) {
                lines.push(format!("- summary: `{summary}`"));
            }
            if let Some(runtime_inputs) = app_init.get("runtime_inputs") {
                lines.push("- runtime_inputs:".to_string());
                lines.push("```json".to_string());
                lines.push(
                    serde_json::to_string_pretty(runtime_inputs)
                        .unwrap_or_else(|_| "{}".to_string()),
                );
                lines.push("```".to_string());
            }
            if let Some(chain) = app_init.get("step_chain").and_then(Value::as_array) {
                for item in chain {
                    let order = item
                        .get("order")
                        .and_then(Value::as_u64)
                        .unwrap_or_default();
                    let node = item
                        .get("node")
                        .and_then(Value::as_str)
                        .unwrap_or("unknown");
                    let kind = item
                        .get("kind")
                        .and_then(Value::as_str)
                        .unwrap_or("unknown");
                    let result = item
                        .get("result")
                        .map(|v| v.to_string())
                        .unwrap_or_else(|| "null".to_string());
                    lines.push(format!("- `{order}` `{node}` [{kind}] result=`{result}`"));
                }
            }
        }
        if let Some(graph) = flow_result.get("v7_identity_dependency_graph") {
            lines.push(String::new());
            lines.push("## V7 Identity Dependency Graph".to_string());
            if let Some(summary) = graph.get("summary").and_then(Value::as_str) {
                lines.push(format!("- summary: `{summary}`"));
            }
            if let Some(observed) = graph.get("observed_values") {
                lines.push("- observed_values:".to_string());
                lines.push("```json".to_string());
                lines.push(
                    serde_json::to_string_pretty(observed).unwrap_or_else(|_| "{}".to_string()),
                );
                lines.push("```".to_string());
            }
            if let Some(mermaid) = graph.get("mermaid").and_then(Value::as_str) {
                lines.push("- graph:".to_string());
                lines.push("```mermaid".to_string());
                lines.push(mermaid.to_string());
                lines.push("```".to_string());
            }
        }
        if let Some(gates) = flow_result.get("v7_identity_gate_diagnostics") {
            lines.push(String::new());
            lines.push("## V7 Identity Gate Diagnostics".to_string());
            if let Some(summary) = gates.get("summary").and_then(Value::as_str) {
                lines.push(format!("- summary: `{summary}`"));
            }
            lines.push("```json".to_string());
            lines.push(serde_json::to_string_pretty(gates).unwrap_or_else(|_| "{}".to_string()));
            lines.push("```".to_string());
        }
        if let Some(business) = flow_result.get("v7_captcha_business_surface") {
            lines.push(String::new());
            lines.push("## V7 Captcha Business Surface".to_string());
            if let Some(summary) = business.get("summary").and_then(Value::as_str) {
                lines.push(format!("- summary: `{summary}`"));
            }
            if let Some(branch) = business.get("observed_branch").and_then(Value::as_str) {
                lines.push(format!("- observed_branch: `{branch}`"));
            }
            if let Some(state) = business.get("business_state").and_then(Value::as_str) {
                lines.push(format!("- business_state: `{state}`"));
            }
            if let Some(flags) = business.get("business_flags") {
                lines.push("- business_flags:".to_string());
                lines.push("```json".to_string());
                lines
                    .push(serde_json::to_string_pretty(flags).unwrap_or_else(|_| "{}".to_string()));
                lines.push("```".to_string());
            }
            if let Some(states) = business.get("business_states").and_then(Value::as_array) {
                for item in states {
                    let order = item
                        .get("order")
                        .and_then(Value::as_u64)
                        .unwrap_or_default();
                    let state = item
                        .get("state")
                        .and_then(Value::as_str)
                        .unwrap_or("unknown");
                    let meaning = item.get("meaning").and_then(Value::as_str).unwrap_or("");
                    lines.push(format!("- `{order}` `{state}` {meaning}"));
                }
            }
            if let Some(mermaid) = business.get("graph_mermaid").and_then(Value::as_str) {
                lines.push("```mermaid".to_string());
                lines.push(mermaid.to_string());
                lines.push("```".to_string());
            }
        }
        if let Some(retry_views) = flow_result.get("v7_retry_payload_views") {
            lines.push(String::new());
            lines.push("## V7 Retry Payload Views".to_string());
            for key in [
                "stage1_candidate_body",
                "retry_patch_only",
                "stage1_plus_patch_preview",
                "stage2_effective_body",
            ] {
                if let Some(value) = retry_views.get(key) {
                    lines.push(format!("- {key}:"));
                    lines.push("```json".to_string());
                    lines.push(
                        serde_json::to_string_pretty(value).unwrap_or_else(|_| "{}".to_string()),
                    );
                    lines.push("```".to_string());
                }
            }
        }
        if let Some(auth_bootstrap) = flow_result.get("auth_bootstrap") {
            lines.push(String::new());
            lines.push("## Auth Bootstrap".to_string());
            lines.push("```json".to_string());
            lines.push(
                serde_json::to_string_pretty(auth_bootstrap).unwrap_or_else(|_| "{}".to_string()),
            );
            lines.push("```".to_string());
        }
        if let Some(payload_debug) = flow_result.get("v7_payload_debug_surface") {
            lines.push(String::new());
            lines.push("## V7 Payload Debug".to_string());
            if let Some(summary) = payload_debug.get("summary").and_then(Value::as_str) {
                lines.push(format!("- summary: `{summary}`"));
            }
            for (label, node) in [
                ("stage1_candidate", payload_debug.get("stage1_candidate")),
                ("stage2_effective", payload_debug.get("stage2_effective")),
            ] {
                let Some(node) = node else {
                    continue;
                };
                let plaintext_utf8_len = node
                    .get("plaintext_utf8_len")
                    .and_then(Value::as_u64)
                    .unwrap_or_default();
                let cipher_bytes = node.get("cipher_bytes").and_then(Value::as_u64);
                let plaintext_sha256 = node
                    .get("plaintext_sha256")
                    .and_then(Value::as_str)
                    .unwrap_or_default();
                lines.push(format!(
                    "- `{label}` plaintext_utf8_len=`{plaintext_utf8_len}` cipher_bytes=`{}` plaintext_sha256=`{plaintext_sha256}`",
                    cipher_bytes
                        .map(|value| value.to_string())
                        .unwrap_or_else(|| "null".to_string())
                ));
                for key in [
                    "null_like_keys",
                    "required_null_like_keys",
                    "top_level_keys",
                ] {
                    if let Some(value) = node.get(key) {
                        lines.push(format!("- {label}.{key}:"));
                        lines.push("```json".to_string());
                        lines.push(
                            serde_json::to_string_pretty(value)
                                .unwrap_or_else(|_| "{}".to_string()),
                        );
                        lines.push("```".to_string());
                    }
                }
                if let Some(namespaces) = node.get("namespace_views") {
                    lines.push(format!("- {label}.namespace_views:"));
                    lines.push("```json".to_string());
                    lines.push(
                        serde_json::to_string_pretty(namespaces)
                            .unwrap_or_else(|_| "{}".to_string()),
                    );
                    lines.push("```".to_string());
                }
            }
            for key in [
                "retry_patch_only",
                "stage1_to_stage2_top_level_delta",
                "known_field_diff",
            ] {
                if let Some(value) = payload_debug.get(key) {
                    lines.push(format!("- {key}:"));
                    lines.push("```json".to_string());
                    lines.push(
                        serde_json::to_string_pretty(value).unwrap_or_else(|_| "{}".to_string()),
                    );
                    lines.push("```".to_string());
                }
            }
        }
        if let Some(project_planes) = flow_result.get("palmchat_project_planes") {
            lines.push(String::new());
            lines.push("## Project Planes".to_string());
            if let Some(summary) = project_planes.get("summary").and_then(Value::as_str) {
                lines.push(format!("- summary: `{summary}`"));
            }
            if let Some(project_state) = project_planes.get("project_state") {
                lines.push("- project_state:".to_string());
                lines.push("```json".to_string());
                lines.push(
                    serde_json::to_string_pretty(project_state)
                        .unwrap_or_else(|_| "{}".to_string()),
                );
                lines.push("```".to_string());
            }
            if let Some(data_plane_mermaid) = project_planes
                .get("data_plane")
                .and_then(|v| v.get("mermaid"))
                .and_then(Value::as_str)
            {
                lines.push("### Data Plane".to_string());
                lines.push("```mermaid".to_string());
                lines.push(data_plane_mermaid.to_string());
                lines.push("```".to_string());
            }
            if let Some(control_plane_mermaid) = project_planes
                .get("control_plane")
                .and_then(|v| v.get("mermaid"))
                .and_then(Value::as_str)
            {
                lines.push("### Control Plane".to_string());
                lines.push("```mermaid".to_string());
                lines.push(control_plane_mermaid.to_string());
                lines.push("```".to_string());
            }
        }
        lines.push(String::new());
        lines.push("## Flow Result".to_string());
        lines.push("```json".to_string());
        lines.push(serde_json::to_string_pretty(flow_result).unwrap_or_else(|_| "{}".to_string()));
        lines.push("```".to_string());
    }

    lines.join("\n")
}

fn write_json_file(path: &Path, value: &Value) -> Result<()> {
    if let Some(parent) = path.parent() {
        fs::create_dir_all(parent)
            .with_context(|| format!("failed to create output dir: {}", parent.display()))?;
    }
    fs::write(path, serde_json::to_vec_pretty(value)?)
        .with_context(|| format!("failed to write json output: {}", path.display()))
}

fn read_json_file(path: &Path) -> Result<Value> {
    let bytes =
        fs::read(path).with_context(|| format!("failed to read json output: {}", path.display()))?;
    serde_json::from_slice(&bytes)
        .with_context(|| format!("failed to parse json output: {}", path.display()))
}

fn write_jsonl_file(path: &Path, rows: &[Value]) -> Result<()> {
    if let Some(parent) = path.parent() {
        fs::create_dir_all(parent)
            .with_context(|| format!("failed to create output dir: {}", parent.display()))?;
    }
    let mut text = String::new();
    for row in rows {
        text.push_str(&serde_json::to_string(row)?);
        text.push('\n');
    }
    fs::write(path, text)
        .with_context(|| format!("failed to write jsonl output: {}", path.display()))
}

fn write_text_file(path: &Path, text: &str) -> Result<()> {
    if let Some(parent) = path.parent() {
        fs::create_dir_all(parent)
            .with_context(|| format!("failed to create output dir: {}", parent.display()))?;
    }
    fs::write(path, text)
        .with_context(|| format!("failed to write text output: {}", path.display()))
}

fn validate_raw_memory_map_entry(entry: &PalmchatRawMemoryMapEntry) -> Result<()> {
    if !entry.path.exists() {
        return Err(anyhow!(
            "runtime_raw_maps path not found: {}",
            entry.path.display()
        ));
    }
    parse_u64ish(&entry.address).with_context(|| {
        format!(
            "invalid runtime_raw_maps address={} path={}",
            entry.address,
            entry.path.display()
        )
    })?;
    for rebase in &entry.pointer_rebases {
        let source_start = parse_u64ish(&rebase.source_start).with_context(|| {
            format!(
                "invalid runtime_raw_maps source_start={} path={}",
                rebase.source_start,
                entry.path.display()
            )
        })?;
        let source_end = parse_u64ish(&rebase.source_end).with_context(|| {
            format!(
                "invalid runtime_raw_maps source_end={} path={}",
                rebase.source_end,
                entry.path.display()
            )
        })?;
        if source_start > source_end {
            return Err(anyhow!(
                "runtime_raw_maps source range inverted start=0x{:x} end=0x{:x} path={}",
                source_start,
                source_end,
                entry.path.display()
            ));
        }
        if rebase.module.trim().is_empty() {
            return Err(anyhow!(
                "runtime_raw_maps pointer_rebases module empty path={}",
                entry.path.display()
            ));
        }
    }
    Ok(())
}

fn validate_page_patch_entry(entry: &PalmchatPagePatchEntry) -> Result<()> {
    {
        if !entry.path.exists() {
            return Err(anyhow!(
                "runtime_page_patches path not found: {}",
                entry.path.display()
            ));
        }
        parse_u64ish(&entry.offset).with_context(|| {
            format!(
                "invalid runtime_page_patches offset={} path={}",
                entry.offset,
                entry.path.display()
            )
        })?;
        for rebase in &entry.pointer_rebases {
            let source_start = parse_u64ish(&rebase.source_start).with_context(|| {
                format!(
                    "invalid runtime_page_patches source_start={} path={}",
                    rebase.source_start,
                    entry.path.display()
                )
            })?;
            let source_end = parse_u64ish(&rebase.source_end).with_context(|| {
                format!(
                    "invalid runtime_page_patches source_end={} path={}",
                    rebase.source_end,
                    entry.path.display()
                )
            })?;
            if source_start > source_end {
                return Err(anyhow!(
                    "runtime_page_patches source range inverted start=0x{:x} end=0x{:x} path={}",
                    source_start,
                    source_end,
                    entry.path.display()
                ));
            }
            if rebase.module.trim().is_empty() {
                return Err(anyhow!(
                    "runtime_page_patches pointer_rebases module empty path={}",
                    entry.path.display()
                ));
            }
        }
        for scratch in &entry.scratch_pointer_slots {
            parse_u64ish(&scratch.slot_offset).with_context(|| {
                format!(
                    "invalid runtime_page_patches scratch slot_offset={} path={}",
                    scratch.slot_offset,
                    entry.path.display()
                )
            })?;
            let alloc_size = parse_u64ish(&scratch.alloc_size).with_context(|| {
                format!(
                    "invalid runtime_page_patches scratch alloc_size={} path={}",
                    scratch.alloc_size,
                    entry.path.display()
                )
            })?;
            if alloc_size == 0 {
                return Err(anyhow!(
                    "runtime_page_patches scratch alloc_size must be > 0 path={}",
                    entry.path.display()
                ));
            }
            if let Some(seed_path) = &scratch.seed_path {
                if !seed_path.exists() {
                    return Err(anyhow!(
                        "runtime_page_patches scratch seed_path not found: {}",
                        seed_path.display()
                    ));
                }
                let seed_offset = scratch
                    .seed_offset
                    .as_deref()
                    .map(parse_u64ish)
                    .transpose()
                    .with_context(|| {
                        format!(
                            "invalid runtime_page_patches scratch seed_offset={:?} path={}",
                            scratch.seed_offset,
                            entry.path.display()
                        )
                    })?
                    .unwrap_or(0) as usize;
                let seed_len = fs::metadata(seed_path)
                    .with_context(|| format!("failed to stat {}", seed_path.display()))?
                    .len() as usize;
                if seed_offset + alloc_size as usize > seed_len {
                    return Err(anyhow!(
                        "runtime_page_patches scratch seed out of range seed={} seed_offset=0x{:x} alloc_size=0x{:x} seed_len=0x{:x} path={}",
                        seed_path.display(),
                        seed_offset,
                        alloc_size,
                        seed_len,
                        entry.path.display()
                    ));
                }
            }
            for rebase in &scratch.pointer_rebases {
                let source_start = parse_u64ish(&rebase.source_start).with_context(|| {
                    format!(
                        "invalid runtime_page_patches scratch source_start={} path={}",
                        rebase.source_start,
                        entry.path.display()
                    )
                })?;
                let source_end = parse_u64ish(&rebase.source_end).with_context(|| {
                    format!(
                        "invalid runtime_page_patches scratch source_end={} path={}",
                        rebase.source_end,
                        entry.path.display()
                    )
                })?;
                if source_start > source_end {
                    return Err(anyhow!(
                        "runtime_page_patches scratch source range inverted start=0x{:x} end=0x{:x} path={}",
                        source_start,
                        source_end,
                        entry.path.display()
                    ));
                }
                if rebase.module.trim().is_empty() {
                    return Err(anyhow!(
                        "runtime_page_patches scratch pointer_rebases module empty path={}",
                        entry.path.display()
                    ));
                }
            }
        }
    }
    Ok(())
}

fn resolve_patch_target_base(
    module_name: &str,
    emulator: &AndroidEmulator<'static, ()>,
    module_base: u64,
    scratch_base: Option<u64>,
    context: &str,
) -> Result<u64> {
    if module_name == "self" {
        return Ok(module_base);
    }
    if module_name == "scratch" {
        return scratch_base.ok_or_else(|| {
            anyhow!("scratch rebase target requested without scratch base: {context}")
        });
    }
    emulator
        .find_loaded_module_base(module_name)
        .ok_or_else(|| {
            anyhow!("runtime patch rebase module not loaded module={module_name} context={context}")
        })
}

fn apply_pointer_rebases_to_bytes(
    bytes: &mut [u8],
    rebases: &[PalmchatPointerRebaseEntry],
    emulator: &AndroidEmulator<'static, ()>,
    module_base: u64,
    scratch_base: Option<u64>,
    context: &str,
) -> Result<Vec<String>> {
    let mut summaries = Vec::new();
    for rebase in rebases {
        let source_start = parse_u64ish(&rebase.source_start).with_context(|| {
            format!(
                "invalid source_start={} context={context}",
                rebase.source_start
            )
        })?;
        let source_end = parse_u64ish(&rebase.source_end).with_context(|| {
            format!("invalid source_end={} context={context}", rebase.source_end)
        })?;
        let target_base = resolve_patch_target_base(
            rebase.module.as_str(),
            emulator,
            module_base,
            scratch_base,
            context,
        )?;
        let mut applied = 0usize;
        for chunk in bytes.chunks_exact_mut(8) {
            let raw = u64::from_le_bytes(chunk.try_into().unwrap());
            if raw < source_start || raw > source_end {
                continue;
            }
            let rebased = target_base + (raw - source_start);
            chunk.copy_from_slice(&rebased.to_le_bytes());
            applied += 1;
        }
        summaries.push(format!(
            "{}:0x{:x}-0x{:x}->0x{:x} count={}",
            rebase.module, source_start, source_end, target_base, applied
        ));
    }
    Ok(summaries)
}

fn build_class_resolver() -> ClassResolver {
    ClassResolver::new(vec![
        "com/zenmen/palmchat/utils/EncryptUtils",
        "com/zenmen/palmchat/messaging/MessagingService",
        "com/zenmen/palmchat/messaging/CreateConnectionDelegate",
        "com/zenmen/palmchat/AppContext",
        "com/zenmen/palmchat/account/AccountUtils",
        "com/zenmen/palmchat/privinfo/PrivInfoManager",
        "com/zenmen/palmchat/c",
        "com/zenmen/palmchat/utils/SmidHelper",
        "com/zenmen/palmchat/utils/log/LogUtil",
        "com/zenmen/palmchat/kotlin/common/SPUtil",
        "com/wifi/open/sec/SmDuManager",
        "com/wifi/open/sec/StringCallback",
        "cn/shuzilm/core/Main",
        "cn/shuzilm/core/Listener",
        "defpackage/ac1",
        "defpackage/mh",
        "defpackage/o92",
        "defpackage/u63",
        "defpackage/sw4",
        "defpackage/nz",
        "defpackage/cl6",
        "defpackage/eb4",
        "defpackage/vu2",
        "defpackage/ts0",
        "defpackage/fm1",
        "defpackage/r75",
        "defpackage/tg4",
        "defpackage/k86",
        "defpackage/wm4",
        "defpackage/st3",
        "defpackage/nl0",
        "defpackage/g9",
        "org/json/JSONObject",
        "android/app/Application",
        "android/content/Context",
        "android/content/res/AssetManager",
        "android/content/SharedPreferences",
        "android/os/Build",
        "android/os/Looper",
        "android/os/Handler",
        "android/net/Uri",
        "android/telephony/TelephonyManager",
        "android/text/TextUtils",
        "android/util/Log",
        "android/util/Pair",
        "java/io/File",
        "java/lang/Object",
        "java/lang/String",
        "java/lang/String[]",
    ])
}

fn run_adb_su_capture(
    shared: Rc<RefCell<SharedState>>,
    label: &str,
    script: &str,
) -> Result<String> {
    let output = Command::new("adb")
        .args(["shell", "su", "-c", script])
        .output()
        .with_context(|| format!("failed to spawn adb for {label}"))?;
    if !output.status.success() {
        let stderr = String::from_utf8_lossy(&output.stderr).trim().to_string();
        return Err(anyhow!(
            "adb {label} failed status={} stderr={}",
            output.status,
            stderr
        ));
    }
    let stdout = String::from_utf8_lossy(&output.stdout).to_string();
    shared.borrow_mut().native(&format!(
        "live_device_profile adb_capture label={} bytes={}",
        label,
        stdout.len()
    ));
    Ok(stdout)
}

fn discover_live_device_profile(
    shared: Rc<RefCell<SharedState>>,
) -> Option<PalmchatLiveDeviceProfile> {
    let devices_output = Command::new("adb").args(["devices", "-l"]).output().ok()?;
    if !devices_output.status.success() {
        shared
            .borrow_mut()
            .native("live_device_profile skipped reason=adb_devices_failed");
        return None;
    }
    let devices_stdout = String::from_utf8_lossy(&devices_output.stdout);
    if !devices_stdout.lines().any(|line| {
        let mut parts = line.split_whitespace();
        let serial = parts.next().unwrap_or_default();
        let state = parts.next().unwrap_or_default();
        !serial.is_empty() && serial != "List" && state == "device"
    }) {
        shared
            .borrow_mut()
            .native("live_device_profile skipped reason=no_attached_device");
        return None;
    }

    let core_script = concat!(
        "printf 'android_id='; settings get secure android_id; echo; ",
        "printf 'build_fingerprint='; getprop ro.build.fingerprint; echo; ",
        "printf 'build_display='; getprop ro.build.display.id; echo; ",
        "printf 'build_incremental='; getprop ro.build.version.incremental; echo; ",
        "printf 'build_time_utc='; getprop ro.build.date.utc; echo; ",
        "printf 'build_tags='; getprop ro.build.tags; echo; ",
        "printf 'build_bootloader='; getprop ro.bootloader; echo; ",
        "printf 'build_version_codename='; getprop ro.build.version.codename; echo; ",
        "printf 'build_host='; getprop ro.build.host; echo; ",
        "printf 'build_id='; getprop ro.build.id; echo; ",
        "printf 'product_model='; getprop ro.product.model; echo; ",
        "printf 'product_brand='; getprop ro.product.brand; echo; ",
        "printf 'product_manufacturer='; getprop ro.product.manufacturer; echo; ",
        "printf 'product_device='; getprop ro.product.device; echo; ",
        "printf 'product_name='; getprop ro.product.name; echo; ",
        "printf 'product_board='; getprop ro.product.board; echo; ",
        "printf 'product_abi_list='; getprop ro.product.cpu.abilist; echo; ",
        "printf 'build_release='; getprop ro.build.version.release; echo; ",
        "printf 'system_locale='; (getprop persist.sys.locale || getprop ro.product.locale || settings get system system_locales) 2>/dev/null | sed '/^$/d' | head -n 1; echo; ",
        "printf 'build_security_patch='; getprop ro.build.version.security_patch; echo; ",
        "printf 'hardware='; getprop ro.boot.hardware; echo; ",
        "printf 'usb_state='; getprop persist.sys.usb.config; echo; ",
        "printf 'mobile_data_enabled='; settings get global mobile_data; echo; ",
        "printf 'http_proxy='; settings get global http_proxy; echo; ",
        "printf 'baseband_version='; getprop gsm.version.baseband; echo; ",
        "printf 'enabled_accessibility_services='; settings get secure enabled_accessibility_services; echo; ",
        "printf 'cpu_cores='; getconf _NPROCESSORS_ONLN 2>/dev/null || nproc 2>/dev/null; echo; ",
        "printf 'cpu_features='; grep -m 1 '^Features' /proc/cpuinfo 2>/dev/null | sed 's/^[^:]*://'; echo; ",
        "printf 'cpu_processor='; grep -m 1 '^Processor' /proc/cpuinfo 2>/dev/null | sed 's/^[^:]*://'; echo; ",
        "printf 'cpuinfo_hardware='; grep -m 1 '^Hardware' /proc/cpuinfo 2>/dev/null | sed 's/^[^:]*://'; echo; ",
        "printf 'cpu_max_freq='; cat /sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq 2>/dev/null; echo; ",
        "printf 'cpu_min_freq='; cat /sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq 2>/dev/null; echo; ",
        "printf 'uptime_seconds='; awk '{print $1}' /proc/uptime 2>/dev/null; echo; ",
        "printf 'kernel_version='; cat /proc/version 2>/dev/null; echo; ",
        "ip -4 addr show wlan0 | sed -n 's/.* inet \\([0-9.]*\\)\\/.*/ipv4=\\1/p'"
    );
    let ui_script = concat!(
        "wm size | sed -n 's/Physical size: \\([0-9]*x[0-9]*\\).*/resolution=\\1/p'; ",
        "wm density | sed -n 's/Physical density: \\([0-9][0-9]*\\).*/screen_density_dpi=\\1/p'; ",
        "printf 'screen_brightness='; settings get system screen_brightness; echo; ",
        "dumpsys display | grep -m 1 mScreenState= | sed -n 's/.*mScreenState=\\([A-Z]*\\).*/screen_state=\\1/p' || true"
    );
    let network_script = concat!(
        "dumpsys connectivity | grep -m 1 'NetworkAgentInfo{.*ni{WIFI CONNECTED\\|NetworkAgentInfo{.*ni{MOBILE\\[' || true; ",
        "dumpsys wifi | grep -m 1 'mWifiInfo SSID:' || true"
    );
    let ua_script = concat!(
        "cat /data/data/com.zenmen.palmchat/shared_prefs/beizisdk_config.xml 2>/dev/null ",
        "| grep -m 1 '<string name=\"userAgent\">' || true"
    );
    let package_info_script = concat!(
        "dumpsys package com.zenmen.palmchat | ",
        "sed -n 's/.*versionCode=\\([0-9][0-9]*\\).*/app_version_code=\\1/p; ",
        "s/.*versionName=\\([^[:space:]]*\\).*/app_version_name=\\1/p' | head -n 2"
    );
    let sensors_script = "dumpsys sensorservice | sed -n '1,220p'";
    let input_methods_script = "ime list -s 2>/dev/null || true";
    let input_methods_detail_script = "dumpsys input_method 2>/dev/null || true";
    let secinfo_dirs_script = r#"
for d in /data/system /vendor/firmware /vendor/lib /system/bin /system/framework; do
  printf 'dir_begin=%s\n' "$d"
  for name in $(ls -1U "$d" 2>/dev/null); do
    p="$d/$name"
    [ -e "$p" ] || continue
    stat -c '%n|%s|%Y' "$p" 2>/dev/null || true
  done
  printf 'dir_end=%s\n' "$d"
done
"#;
    let secinfo_net_script = concat!(
        "printf 'ip_addr_begin=1\\n'; ip -o addr 2>/dev/null || true; printf 'ip_addr_end=1\\n'; ",
        "printf 'su_paths='; ls /system/bin/su /system/xbin/su /sbin/su /data/local/su /su/bin/su 2>/dev/null | tr '\\n' ','; echo; ",
        "ps 2>/dev/null || true"
    );

    let core_raw = match run_adb_su_capture(shared.clone(), "core", core_script) {
        Ok(value) => value,
        Err(err) => {
            shared.borrow_mut().native(&format!(
                "live_device_profile skipped reason=core_capture_failed err={err:#}"
            ));
            return None;
        }
    };
    let ui_raw = run_adb_su_capture(shared.clone(), "ui", ui_script).unwrap_or_default();
    let network_raw =
        run_adb_su_capture(shared.clone(), "network", network_script).unwrap_or_default();
    let ua_raw = run_adb_su_capture(shared.clone(), "ua", ua_script).unwrap_or_default();
    let package_info_raw =
        run_adb_su_capture(shared.clone(), "package_info", package_info_script).unwrap_or_default();
    let seed_dna_raw = run_adb_su_capture(
        shared.clone(),
        "seed_dna",
        "cat /data/data/com.zenmen.palmchat/shared_prefs/com.zenmen.palmchat_dna.xml 2>/dev/null || true",
    )
    .unwrap_or_default();
    let seed_oaid_raw = run_adb_su_capture(
        shared.clone(),
        "seed_oaid",
        "cat /data/data/com.zenmen.palmchat/shared_prefs/umeng_sp_oaid.xml 2>/dev/null || true",
    )
    .unwrap_or_default();
    let seed_channel_raw = run_adb_su_capture(
        shared.clone(),
        "seed_channel",
        "cat /data/data/com.zenmen.palmchat/shared_prefs/umeng_common_config.xml 2>/dev/null || true",
    )
    .unwrap_or_default();
    let seed_wifi_social_raw = run_adb_su_capture(
        shared.clone(),
        "seed_wifi_social",
        "cat /data/data/com.zenmen.palmchat/shared_prefs/wifi_social.xml 2>/dev/null || true",
    )
    .unwrap_or_default();
    let seed_tray_transfer_raw = run_adb_su_capture(
        shared.clone(),
        "seed_tray_transfer",
        "toybox strings /data/data/com.zenmen.palmchat/files/mmkv/sp_tray_transfer 2>/dev/null || true",
    )
    .unwrap_or_default();
    let seed_ip_info_raw = run_adb_su_capture(
        shared.clone(),
        "seed_ip_info",
        "strings /data/data/com.zenmen.palmchat/files/mmkv/sp_palmchat_APP_COMMON 2>/dev/null || true",
    )
    .unwrap_or_default();
    let installed_packages_raw = run_adb_su_capture(
        shared.clone(),
        "installed_packages",
        "pm list packages | sed 's/^package://g' | sed '/^$/d' || true",
    )
    .unwrap_or_default();
    let data_dir_packages_raw = run_adb_su_capture(
        shared.clone(),
        "data_dir_packages",
        "ls -1 /data/data 2>/dev/null || true",
    )
    .unwrap_or_default();
    let seed_raw = format!("{seed_dna_raw}\n{seed_oaid_raw}\n{seed_channel_raw}");
    let last_login_info = parse_wifi_social_last_login_info(&seed_wifi_social_raw);
    let (account_session_id_enc, account_refresh_key_enc) =
        parse_wifi_social_additional_auth(&seed_wifi_social_raw);
    let sensors_raw =
        run_adb_su_capture(shared.clone(), "sensors", sensors_script).unwrap_or_default();
    let input_methods_raw =
        run_adb_su_capture(shared.clone(), "input_methods", input_methods_script)
            .unwrap_or_default();
    let input_methods_detail_raw = run_adb_su_capture(
        shared.clone(),
        "input_methods_detail",
        input_methods_detail_script,
    )
    .unwrap_or_default();
    let secinfo_dirs_raw =
        run_adb_su_capture(shared.clone(), "secinfo_dirs", secinfo_dirs_script).unwrap_or_default();
    let secinfo_net_raw =
        run_adb_su_capture(shared.clone(), "secinfo_net", secinfo_net_script).unwrap_or_default();

    let mut kv = HashMap::<String, String>::new();
    for raw in core_raw
        .lines()
        .chain(ui_raw.lines())
        .chain(package_info_raw.lines())
    {
        let line = raw.trim();
        if line.is_empty() {
            continue;
        }
        if let Some((key, value)) = line.split_once('=') {
            kv.insert(key.trim().to_string(), value.trim().to_string());
        }
    }

    let abi_list = kv
        .get("product_abi_list")
        .map(|value| {
            value
                .split(',')
                .map(|item| item.trim().to_string())
                .filter(|item| !item.is_empty())
                .collect::<Vec<_>>()
        })
        .unwrap_or_default();
    let sensor_name_list = parse_sensor_name_list(&sensors_raw);
    let wifi_ssid = parse_wifi_ssid(&network_raw);
    let network_type = parse_active_network_type(&network_raw, wifi_ssid.as_deref());
    let network_state = derive_network_state(network_type.as_deref(), wifi_ssid.as_deref());
    let webview_user_agent = parse_xml_string_value(&ua_raw, "userAgent");
    let enabled_accessibility_packages = parse_accessibility_service_packages(
        kv.get("enabled_accessibility_services").map(String::as_str),
    );
    let input_method_ids = parse_non_empty_line_list(&input_methods_raw);
    let input_method_labels = parse_input_method_labels(&input_methods_detail_raw);
    let data_dir_packages = parse_non_empty_line_list(&data_dir_packages_raw);
    let secinfo_json = build_secinfo_json(
        kv.get("build_tags").map(String::as_str),
        &secinfo_net_raw,
        &secinfo_dirs_raw,
        "com.zenmen.palmchat",
        &data_dir_packages,
    );
    let runtime_probe = read_runtime_probe_raw();
    let runtime_probe_overrides = runtime_probe
        .as_ref()
        .and_then(|(path, raw)| parse_runtime_probe_overrides(raw, path));
    let mut installed_packages = parse_package_name_list(&installed_packages_raw);
    if let Some(overrides) = runtime_probe_overrides.as_ref() {
        if let Some(runtime_probe_packages) = overrides.installed_packages.as_ref() {
            shared.borrow_mut().native(&format!(
                "live_device_profile installed_packages source=runtime_probe path={} count={}",
                overrides.source_path,
                runtime_probe_packages.len()
            ));
            installed_packages = runtime_probe_packages.clone();
        }
    }

    let mut profile = PalmchatLiveDeviceProfile {
        source: "adb+su".to_string(),
        android_id: normalize_plain_candidate(kv.get("android_id").cloned()),
        sdid: normalize_device_id_candidate(parse_xml_string_value(&seed_raw, "device_id")),
        device_label: normalize_plain_candidate(parse_xml_string_value(&seed_raw, "device_label")),
        tray_device_id: normalize_device_id_candidate(parse_mmkv_strings_value(
            &seed_tray_transfer_raw,
            "tray_preference_device_id",
        )),
        account_uid: normalize_plain_candidate(
            parse_mmkv_strings_value(&seed_tray_transfer_raw, "current_uid")
                .or_else(|| extract_json_value_as_string(last_login_info.as_ref(), "uid")),
        ),
        account_exid: normalize_plain_candidate(
            parse_mmkv_strings_value(&seed_tray_transfer_raw, "current_exid")
                .or_else(|| extract_json_value_as_string(last_login_info.as_ref(), "exid")),
        ),
        account_phone: normalize_plain_candidate(extract_json_value_as_string(
            last_login_info.as_ref(),
            "phone",
        )),
        account_session_id_enc: normalize_plain_candidate(account_session_id_enc),
        account_refresh_key_enc: normalize_plain_candidate(account_refresh_key_enc),
        oaid: normalize_plain_candidate(parse_xml_string_value(&seed_raw, "key_umeng_sp_oaid")),
        channel_id: normalize_plain_candidate(parse_xml_string_value(&seed_raw, "channel")),
        ip_info: parse_mmkv_key_ip_info(&seed_ip_info_raw),
        installed_packages,
        data_dir_packages,
        app_version_code: normalize_plain_candidate(kv.get("app_version_code").cloned()),
        app_version_name: normalize_plain_candidate(kv.get("app_version_name").cloned()),
        build_fingerprint: normalize_plain_candidate(kv.get("build_fingerprint").cloned()),
        build_display: normalize_plain_candidate(kv.get("build_display").cloned()),
        build_incremental: normalize_plain_candidate(kv.get("build_incremental").cloned()),
        build_time_millis: parse_unix_seconds_to_millis(
            kv.get("build_time_utc").map(String::as_str),
        ),
        build_tags: normalize_plain_candidate(kv.get("build_tags").cloned()),
        build_bootloader: normalize_non_empty_candidate(kv.get("build_bootloader").cloned()),
        build_version_codename: normalize_plain_candidate(
            kv.get("build_version_codename").cloned(),
        ),
        build_host: normalize_plain_candidate(kv.get("build_host").cloned()),
        build_id: normalize_plain_candidate(kv.get("build_id").cloned()),
        product_model: normalize_plain_candidate(kv.get("product_model").cloned()),
        product_brand: normalize_plain_candidate(kv.get("product_brand").cloned()),
        product_manufacturer: normalize_plain_candidate(kv.get("product_manufacturer").cloned()),
        product_device: normalize_plain_candidate(kv.get("product_device").cloned()),
        product_name: normalize_plain_candidate(kv.get("product_name").cloned()),
        product_board: normalize_plain_candidate(kv.get("product_board").cloned()),
        product_abi_list: abi_list,
        build_release: normalize_plain_candidate(kv.get("build_release").cloned()),
        locale_tag: normalize_locale_tag(kv.get("system_locale").map(String::as_str)),
        display_density: derive_display_density_string(
            kv.get("screen_density_dpi").map(String::as_str),
        ),
        build_security_patch: normalize_plain_candidate(kv.get("build_security_patch").cloned()),
        hardware: normalize_plain_candidate(kv.get("hardware").cloned()),
        usb_state: normalize_plain_candidate(kv.get("usb_state").cloned()),
        wlan_ipv4: normalize_plain_candidate(kv.get("ipv4").cloned()),
        wifi_ssid,
        network_type,
        network_state,
        mobile_data_enabled: parse_optional_bool_flag(
            kv.get("mobile_data_enabled").map(String::as_str),
        ),
        webview_user_agent,
        baseband_version: normalize_plain_candidate(kv.get("baseband_version").cloned()),
        cpu_cores: kv
            .get("cpu_cores")
            .and_then(|value| value.trim().parse::<i64>().ok()),
        cpu_features: normalize_plain_candidate(kv.get("cpu_features").cloned()),
        cpu_processor: normalize_plain_candidate(kv.get("cpu_processor").cloned()),
        cpuinfo_hardware: normalize_plain_candidate(kv.get("cpuinfo_hardware").cloned()),
        cpu_max_freq: normalize_plain_candidate(kv.get("cpu_max_freq").cloned()),
        cpu_min_freq: normalize_plain_candidate(kv.get("cpu_min_freq").cloned()),
        kernel_version: parse_proc_version_release(kv.get("kernel_version").map(String::as_str)),
        http_proxy_host: parse_http_proxy_host(kv.get("http_proxy").map(String::as_str)),
        http_proxy_port: parse_http_proxy_port(kv.get("http_proxy").map(String::as_str)),
        boot_time_millis: parse_boot_time_millis(kv.get("uptime_seconds").map(String::as_str)),
        resolution: normalize_plain_candidate(kv.get("resolution").cloned()),
        screen_brightness: kv
            .get("screen_brightness")
            .and_then(|value| value.trim().parse::<i64>().ok()),
        screen_on: kv
            .get("screen_state")
            .map(|value| value.eq_ignore_ascii_case("ON")),
        sensor_name_list,
        enabled_accessibility_packages,
        input_method_ids,
        input_method_labels,
        secinfo_json,
    };
    if let Some(overrides) = runtime_probe_overrides.as_ref() {
        apply_runtime_probe_overrides(&mut profile, overrides);
        shared.borrow_mut().native(&format!(
            "live_device_profile runtime_probe_override path={} android_id={} ip_info_len={} net_type={} net_state={} wifi_ssid={} resolution={} screen_brightness={} screen_on={} device_label={} kernel_len={} basic_version_len={} packages={} sinfo_len={}",
            overrides.source_path,
            profile.android_id.as_deref().unwrap_or(""),
            profile.ip_info.as_deref().unwrap_or("").len(),
            profile.network_type.as_deref().unwrap_or(""),
            profile.network_state.as_deref().unwrap_or(""),
            profile.wifi_ssid.as_deref().unwrap_or(""),
            profile.resolution.as_deref().unwrap_or(""),
            profile
                .screen_brightness
                .map(|value| value.to_string())
                .unwrap_or_default(),
            profile
                .screen_on
                .map(|value| value.to_string())
                .unwrap_or_default(),
            profile.device_label.as_deref().unwrap_or(""),
            profile.kernel_version.as_deref().unwrap_or("").len(),
            profile.baseband_version.as_deref().unwrap_or("").len(),
            profile.installed_packages.len(),
            profile.secinfo_json.as_deref().unwrap_or("").len()
        ));
    }
    shared.borrow_mut().native(&format!(
        "live_device_profile loaded source={} android_id={} sdid={} tray_device_id={} uid={} exid_len={} phone={} sid_enc_len={} rk_enc_len={} channel={} oaid_len={} ip_info_len={} packages={} app_version_code={} app_version_name={} model={} brand={} device={} release={} locale={} density={} ipv4={} ssid={} net_type={} real_net_type={} mobile_data={} ua_len={} sensors={} bootloader={} codename={} cpu_max={} cpu_min={} proxy_host={} proxy_port={} kernel_len={} boot_time={} ime_labels={} sinfo_len={}",
        profile.source,
        profile.android_id.as_deref().unwrap_or(""),
        profile.sdid.as_deref().unwrap_or(""),
        profile.tray_device_id.as_deref().unwrap_or(""),
        profile.account_uid.as_deref().unwrap_or(""),
        profile.account_exid.as_deref().unwrap_or("").len(),
        profile.account_phone.as_deref().unwrap_or(""),
        profile.account_session_id_enc.as_deref().unwrap_or("").len(),
        profile.account_refresh_key_enc.as_deref().unwrap_or("").len(),
        profile.channel_id.as_deref().unwrap_or(""),
        profile.oaid.as_deref().unwrap_or("").len(),
        profile.ip_info.as_deref().unwrap_or("").len(),
        profile.installed_packages.len(),
        profile.app_version_code.as_deref().unwrap_or(""),
        profile.app_version_name.as_deref().unwrap_or(""),
        profile.product_model.as_deref().unwrap_or(""),
        profile.product_brand.as_deref().unwrap_or(""),
        profile.product_device.as_deref().unwrap_or(""),
        profile.build_release.as_deref().unwrap_or(""),
        profile.locale_tag.as_deref().unwrap_or(""),
        profile.display_density.as_deref().unwrap_or(""),
        profile.wlan_ipv4.as_deref().unwrap_or(""),
        profile.wifi_ssid.as_deref().unwrap_or(""),
        profile.network_type.as_deref().unwrap_or(""),
        normalize_wm4_real_network_type(
            profile.network_type.as_deref(),
            profile.mobile_data_enabled
        ),
        profile.mobile_data_enabled.map(|value| value.to_string()).unwrap_or_default(),
        profile.webview_user_agent.as_deref().unwrap_or("").len(),
        profile.sensor_name_list.len(),
        profile.build_bootloader.as_deref().unwrap_or(""),
        profile.build_version_codename.as_deref().unwrap_or(""),
        profile.cpu_max_freq.as_deref().unwrap_or(""),
        profile.cpu_min_freq.as_deref().unwrap_or(""),
        profile.http_proxy_host.as_deref().unwrap_or(""),
        profile
            .http_proxy_port
            .map(|value| value.to_string())
            .unwrap_or_default(),
        profile.kernel_version.as_deref().unwrap_or("").len(),
        profile
            .boot_time_millis
            .map(|value| value.to_string())
            .unwrap_or_default(),
        profile.input_method_labels.len(),
        profile.secinfo_json.as_deref().unwrap_or("").len()
    ));
    Some(profile)
}

fn parse_xml_string_value(raw: &str, name: &str) -> Option<String> {
    let marker = format!("<string name=\"{name}\">");
    for raw_line in raw.lines() {
        let line = raw_line.trim();
        let Some(start) = line.find(&marker) else {
            continue;
        };
        let value_start = start + marker.len();
        let rest = &line[value_start..];
        let Some(end) = rest.find("</string>") else {
            continue;
        };
        let value = rest[..end].trim();
        if !value.is_empty() {
            return Some(value.to_string());
        }
    }
    None
}

fn decode_basic_xml_entities(raw: &str) -> String {
    raw.replace("&quot;", "\"")
        .replace("&apos;", "'")
        .replace("&lt;", "<")
        .replace("&gt;", ">")
        .replace("&amp;", "&")
}

fn parse_wifi_social_last_login_info(raw: &str) -> Option<Value> {
    let encoded = parse_xml_string_value(raw, "last_login_user_info")?;
    let decoded = decode_basic_xml_entities(&encoded);
    serde_json::from_str::<Value>(&decoded).ok()
}

fn parse_wifi_social_additional_auth(raw: &str) -> (Option<String>, Option<String>) {
    (
        parse_xml_string_value(raw, "sp_sid_additional"),
        parse_xml_string_value(raw, "sp_rk_additional"),
    )
}

fn extract_json_value_as_string(value: Option<&Value>, key: &str) -> Option<String> {
    let obj = value?.as_object()?;
    let field = obj.get(key)?;
    match field {
        Value::String(raw) => normalize_plain_candidate(Some(raw.to_string())),
        Value::Number(raw) => normalize_plain_candidate(Some(raw.to_string())),
        Value::Bool(raw) => normalize_plain_candidate(Some(raw.to_string())),
        _ => None,
    }
}

fn trim_mmkv_strings_prefix(raw: &str) -> &str {
    let trimmed = raw.trim_start();
    let digit_len = trimmed.chars().take_while(|ch| ch.is_ascii_digit()).count();
    if digit_len == 0 {
        return trimmed;
    }
    let remainder = &trimmed[digit_len..];
    if remainder
        .chars()
        .next()
        .map(|ch| ch.is_whitespace())
        .unwrap_or(false)
    {
        remainder.trim_start()
    } else {
        trimmed
    }
}

fn parse_mmkv_strings_value(raw: &str, key: &str) -> Option<String> {
    let lines = raw.lines().collect::<Vec<_>>();
    for (idx, raw_line) in lines.iter().enumerate() {
        let line = trim_mmkv_strings_prefix(raw_line);
        if let Some(remainder) = line.strip_prefix(key) {
            let inline = remainder
                .trim()
                .trim_start_matches(|ch: char| {
                    ch == ':' || ch == '=' || ch == '!' || ch.is_whitespace()
                })
                .trim();
            if let Some(value) = normalize_plain_candidate(Some(inline.to_string())) {
                return Some(value);
            }
            if let Some(next_line) = lines.get(idx + 1) {
                let next_value = trim_mmkv_strings_prefix(next_line);
                if let Some(value) = normalize_plain_candidate(Some(next_value.to_string())) {
                    return Some(value);
                }
            }
        }
    }
    None
}

fn parse_http_proxy_host(raw: Option<&str>) -> Option<String> {
    let value = normalize_plain_candidate(raw.map(|value| value.to_string()))?;
    if value.eq_ignore_ascii_case("null") || value.eq_ignore_ascii_case(":0") {
        return None;
    }
    let trimmed = value
        .strip_prefix("http://")
        .or_else(|| value.strip_prefix("https://"))
        .unwrap_or(value.as_str());
    let host = trimmed.split(':').next().unwrap_or(trimmed).trim();
    if host.is_empty() || host.eq_ignore_ascii_case("null") {
        None
    } else {
        Some(host.to_string())
    }
}

fn parse_http_proxy_port(raw: Option<&str>) -> Option<i64> {
    let value = normalize_plain_candidate(raw.map(|value| value.to_string()))?;
    let trimmed = value
        .strip_prefix("http://")
        .or_else(|| value.strip_prefix("https://"))
        .unwrap_or(value.as_str());
    let (_, port) = trimmed.rsplit_once(':')?;
    port.trim().parse::<i64>().ok()
}

fn parse_boot_time_millis(raw: Option<&str>) -> Option<i64> {
    let uptime_seconds = raw?.trim().parse::<f64>().ok()?;
    let now_millis = current_timestamp_millis() as f64;
    Some((now_millis - (uptime_seconds * 1000.0)).round() as i64)
}

fn parse_unix_seconds_to_millis(raw: Option<&str>) -> Option<i64> {
    let seconds = raw?.trim().parse::<i64>().ok()?;
    Some(seconds.saturating_mul(1000))
}

fn parse_proc_version_release(raw: Option<&str>) -> Option<String> {
    let value = normalize_plain_candidate(raw.map(|value| value.to_string()))?;
    let release = value
        .split("version ")
        .nth(1)
        .and_then(|rest| rest.split_whitespace().next())
        .map(str::trim)
        .filter(|item| !item.is_empty());
    release.map(|item| item.to_string()).or_else(|| Some(value))
}

fn parse_accessibility_service_packages(raw: Option<&str>) -> Vec<String> {
    let Some(value) = normalize_plain_candidate(raw.map(|value| value.to_string())) else {
        return Vec::new();
    };
    let mut out = Vec::new();
    for item in value.split(':') {
        let package = item
            .split_once('/')
            .map(|(package, _)| package)
            .unwrap_or(item)
            .trim();
        if package.is_empty() || out.iter().any(|existing| existing == package) {
            continue;
        }
        out.push(package.to_string());
    }
    out
}

fn parse_non_empty_line_list(raw: &str) -> Vec<String> {
    raw.lines()
        .filter_map(|line| normalize_plain_candidate(Some(line.trim().to_string())))
        .collect()
}

fn normalize_non_empty_candidate(candidate: Option<String>) -> Option<String> {
    let value = candidate?.trim().to_string();
    if value.is_empty() {
        None
    } else {
        Some(value)
    }
}

#[derive(Clone, Debug)]
struct PalmchatDirStatEntry {
    name: String,
    size: u64,
    mtime_seconds: i64,
}

fn parse_input_method_labels(raw: &str) -> Vec<String> {
    let mut out = Vec::new();
    for raw_line in raw.lines() {
        let line = raw_line.trim();
        let Some((_, tail)) = line.split_once("mImeName=") else {
            continue;
        };
        let label = tail.split(" mSubtypeName=").next().unwrap_or(tail).trim();
        if label.is_empty() || out.iter().any(|existing| existing == label) {
            continue;
        }
        out.push(label.to_string());
    }
    out
}

fn parse_secinfo_dir_stats(raw: &str) -> HashMap<String, Vec<PalmchatDirStatEntry>> {
    let mut by_dir = HashMap::<String, Vec<PalmchatDirStatEntry>>::new();
    let mut current_dir: Option<String> = None;
    for raw_line in raw.lines() {
        let line = raw_line.trim();
        if line.is_empty() {
            continue;
        }
        if let Some((_, dir)) = line.split_once("dir_begin=") {
            current_dir = normalize_plain_candidate(Some(dir.to_string()));
            continue;
        }
        if line.starts_with("dir_end=") {
            current_dir = None;
            continue;
        }
        let Some(dir) = current_dir.clone() else {
            continue;
        };
        let mut parts = line.split('|');
        let Some(path) = parts.next() else {
            continue;
        };
        let Some(size) = parts.next().and_then(|value| value.parse::<u64>().ok()) else {
            continue;
        };
        let Some(mtime_seconds) = parts.next().and_then(|value| value.parse::<i64>().ok()) else {
            continue;
        };
        let name = Path::new(path)
            .file_name()
            .and_then(|value| value.to_str())
            .map(|value| value.to_string())
            .unwrap_or_else(|| path.to_string());
        by_dir.entry(dir).or_default().push(PalmchatDirStatEntry {
            name,
            size,
            mtime_seconds,
        });
    }
    by_dir
}

fn compute_secinfo_dir_digest(
    entries: Option<&[PalmchatDirStatEntry]>,
    include_mtime: bool,
) -> String {
    let Some(entries) = entries else {
        return "-999".to_string();
    };
    let mut joined = String::new();
    for entry in entries {
        joined.push_str(&entry.name);
        joined.push_str(&entry.size.to_string());
        if include_mtime {
            joined.push_str(&(entry.mtime_seconds.saturating_mul(1000)).to_string());
        }
    }
    format!("{:x}", md5::compute(joined.as_bytes()))
}

fn parse_secinfo_ps_output(raw: &str, package_name: &str) -> (Option<String>, Vec<String>) {
    parse_secinfo_ps_output_with_data_dirs(raw, package_name, &[])
}

fn parse_secinfo_ps_output_with_data_dirs(
    raw: &str,
    package_name: &str,
    data_dir_packages: &[String],
) -> (Option<String>, Vec<String>) {
    let mut process_user = None::<String>;
    let mut process_names = Vec::<String>::new();
    let data_dir_packages = data_dir_packages
        .iter()
        .map(|item| item.as_str())
        .collect::<HashSet<_>>();
    for raw_line in raw.lines() {
        let line = raw_line.trim();
        if line.is_empty() || line.starts_with("USER") || line.starts_with("ip_addr_") {
            continue;
        }
        let parts = line.split_whitespace().collect::<Vec<_>>();
        if parts.len() < 2 {
            continue;
        }
        let user = parts.first().copied().unwrap_or_default();
        let name = parts.last().copied().unwrap_or_default();
        if name == package_name && process_user.is_none() {
            process_user = normalize_plain_candidate(Some(user.to_string()));
        }
    }
    let Some(user) = process_user.clone() else {
        return (None, process_names);
    };
    for raw_line in raw.lines() {
        let line = raw_line.trim();
        if line.is_empty() || line.starts_with("USER") || line.starts_with("ip_addr_") {
            continue;
        }
        let parts = line.split_whitespace().collect::<Vec<_>>();
        if parts.len() < 2 || parts.first().copied().unwrap_or_default() != user {
            continue;
        }
        let name = parts.last().copied().unwrap_or_default();
        if name.is_empty() || process_names.iter().any(|existing| existing == name) {
            continue;
        }
        let allow_name = if data_dir_packages.is_empty() {
            name == package_name
        } else {
            data_dir_packages.contains(name)
        };
        if !allow_name {
            continue;
        }
        process_names.push(name.to_string());
    }
    (process_user, process_names)
}

fn compute_secinfo_network_evidence(raw: &str) -> String {
    for raw_line in raw.lines() {
        let line = raw_line.trim();
        let mut parts = line.split_whitespace();
        let _idx = parts.next();
        let Some(name) = parts.next() else {
            continue;
        };
        let name = name.trim_end_matches(':');
        let Some(family) = parts.next() else {
            continue;
        };
        if (family == "inet" || family == "inet6")
            && (name.contains("tun") || name.contains("tap") || name.contains("ppp"))
        {
            return format!("1,{name}");
        }
    }
    "0,".to_string()
}

fn build_secinfo_json(
    build_tags: Option<&str>,
    secinfo_net_raw: &str,
    secinfo_dirs_raw: &str,
    package_name: &str,
    data_dir_packages: &[String],
) -> Option<String> {
    let dir_stats = parse_secinfo_dir_stats(secinfo_dirs_raw);
    let (process_user, data_directories) =
        parse_secinfo_ps_output_with_data_dirs(secinfo_net_raw, package_name, data_dir_packages);
    let mut obj = Map::<String, Value>::new();
    obj.insert("plt".to_string(), Value::Bool(true));
    obj.insert("xp".to_string(), Value::Bool(false));
    if !data_directories.is_empty() {
        obj.insert("vs".to_string(), Value::String(data_directories.join(",")));
    }
    obj.insert("v".to_string(), Value::Bool(data_directories.len() > 1));
    obj.insert(
        "pc".to_string(),
        Value::Number((data_directories.len() as i64).into()),
    );
    let root_flag = normalize_plain_candidate(build_tags.map(|value| value.to_string()))
        .map(|value| value.contains("test-keys"))
        .unwrap_or(false)
        || secinfo_net_raw
            .lines()
            .find_map(|line| line.trim().strip_prefix("su_paths="))
            .map(|value| !value.trim().trim_matches(',').is_empty())
            .unwrap_or(false);
    obj.insert("r".to_string(), Value::Bool(root_flag));
    obj.insert("hk".to_string(), Value::Number(0.into()));
    obj.insert(
        "ds".to_string(),
        Value::String(compute_secinfo_dir_digest(
            dir_stats.get("/data/system").map(Vec::as_slice),
            true,
        )),
    );
    obj.insert(
        "ds2".to_string(),
        Value::String(compute_secinfo_dir_digest(
            dir_stats.get("/data/system").map(Vec::as_slice),
            false,
        )),
    );
    obj.insert(
        "vf".to_string(),
        Value::String(compute_secinfo_dir_digest(
            dir_stats.get("/vendor/firmware").map(Vec::as_slice),
            true,
        )),
    );
    obj.insert(
        "vl".to_string(),
        Value::String(compute_secinfo_dir_digest(
            dir_stats.get("/vendor/lib").map(Vec::as_slice),
            true,
        )),
    );
    obj.insert(
        "sb".to_string(),
        Value::String(compute_secinfo_dir_digest(
            dir_stats.get("/system/bin").map(Vec::as_slice),
            true,
        )),
    );
    obj.insert(
        "sf".to_string(),
        Value::String(compute_secinfo_dir_digest(
            dir_stats.get("/system/framework").map(Vec::as_slice),
            true,
        )),
    );
    obj.insert(
        "ne".to_string(),
        Value::String(compute_secinfo_network_evidence(secinfo_net_raw)),
    );
    if process_user.is_none() && dir_stats.is_empty() {
        return None;
    }
    Some(Value::Object(obj).to_string())
}

fn sanitize_wifi_ssid(raw: &str) -> Option<String> {
    let trimmed = raw.trim().trim_matches('"').trim();
    if trimmed.is_empty()
        || trimmed.starts_with("0x")
        || trimmed.starts_with("0X")
        || trimmed.eq_ignore_ascii_case("<unknown ssid>")
        || trimmed.eq_ignore_ascii_case("unknown ssid")
    {
        None
    } else {
        Some(trimmed.to_string())
    }
}

fn parse_wifi_ssid(raw: &str) -> Option<String> {
    for raw_line in raw.lines() {
        let line = raw_line.trim();
        if let Some((_, tail)) = line.split_once("SSID: ") {
            if let Some(stripped) = tail.strip_prefix('"') {
                if let Some(end) = stripped.find('"') {
                    let candidate = &stripped[..end];
                    if let Some(normalized) = sanitize_wifi_ssid(candidate) {
                        return Some(normalized);
                    }
                }
            }
            let candidate = tail.split(',').next().unwrap_or(tail);
            if let Some(normalized) = sanitize_wifi_ssid(candidate) {
                return Some(normalized);
            }
        }
        if let Some((_, tail)) = line.split_once("SSID=\"") {
            if let Some(end) = tail.find('"') {
                let candidate = &tail[..end];
                if let Some(normalized) = sanitize_wifi_ssid(candidate) {
                    return Some(normalized);
                }
            }
        }
    }
    None
}

fn parse_active_network_type(raw: &str, wifi_ssid: Option<&str>) -> Option<String> {
    if wifi_ssid.is_some() || raw.contains("ni{WIFI CONNECTED") {
        return Some("WIFI".to_string());
    }
    for raw_line in raw.lines() {
        let line = raw_line.trim();
        if let Some((_, tail)) = line.split_once("ni{MOBILE[") {
            if let Some(end) = tail.find(']') {
                let candidate = tail[..end].trim();
                if !candidate.is_empty() {
                    return Some(candidate.to_string());
                }
            }
            return Some("MOBILE".to_string());
        }
        if line.contains("ni{MOBILE CONNECTED") {
            return Some("MOBILE".to_string());
        }
    }
    None
}

fn derive_network_state(network_type: Option<&str>, wifi_ssid: Option<&str>) -> Option<String> {
    match network_type {
        Some("WIFI") => Some(format!("WIFI_{}", wifi_ssid.unwrap_or_default())),
        Some(other) if !other.trim().is_empty() => Some(other.to_string()),
        _ => None,
    }
}

fn parse_sensor_name_list(raw: &str) -> Vec<String> {
    let mut inside_list = false;
    let mut sensors = Vec::new();
    for raw_line in raw.lines() {
        let line = raw_line.trim();
        if line == "Sensor List:" {
            inside_list = true;
            continue;
        }
        if !inside_list {
            continue;
        }
        if line.starts_with("Fusion States:") || line.starts_with("Recent Sensor events:") {
            break;
        }
        if !line.starts_with("0x") {
            continue;
        }
        let Some((_, after_id)) = line.split_once(')') else {
            continue;
        };
        let mut parts = after_id.split('|').map(str::trim);
        let name = parts.next().unwrap_or_default();
        let vendor = parts.next().unwrap_or_default();
        if name.is_empty() {
            continue;
        }
        let label = if vendor.is_empty() {
            name.to_string()
        } else {
            format!("{name}_{}", vendor.replace(',', " "))
        };
        sensors.push(label);
    }
    normalize_sensor_name_list_for_fm1(sensors)
}

fn normalize_sensor_name_list_for_fm1(sensors: Vec<String>) -> Vec<String> {
    let Some(cut_idx) = sensors
        .iter()
        .position(|item| item == "step_detect_wakeup_mtk")
    else {
        return sensors;
    };
    let tail = &sensors[cut_idx + 1..];
    if tail.is_empty() {
        return sensors;
    }
    let tail_is_virtual_only = tail.iter().all(|item| {
        item.contains("_AOSP")
            || item == "OPLUS Fusion Light Sensor_OPLUS"
            || item == "OPLUS Side Panel Fusion Light Sensor_OPLUS"
    });
    if tail_is_virtual_only {
        sensors[..=cut_idx].to_vec()
    } else {
        sensors
    }
}

fn parse_mmkv_key_ip_info(raw: &str) -> Option<String> {
    let mut exact_following = None::<String>;
    let mut inline_candidate = None::<String>;
    let lines = raw.lines().map(str::trim).collect::<Vec<_>>();
    for (idx, line) in lines.iter().enumerate() {
        if line.is_empty() || !line.contains("key_ip_info") {
            continue;
        }
        if *line == "key_ip_info" {
            if let Some(next) = lines.get(idx + 1) {
                if next.starts_with('{') && next.ends_with('}') {
                    exact_following = Some((*next).to_string());
                }
            }
        }
        if let Some(pos) = line.find('{') {
            let candidate = &line[pos..];
            if candidate.starts_with('{') && candidate.ends_with('}') {
                inline_candidate = Some(candidate.to_string());
            }
        }
    }
    exact_following
        .or(inline_candidate)
        .and_then(|value| normalize_plain_candidate(Some(value)))
}

fn parse_package_name_list(raw: &str) -> Vec<String> {
    let mut seen = HashSet::<String>::new();
    let mut packages = Vec::<String>::new();
    for raw_line in raw.lines() {
        let line = raw_line.trim();
        if line.is_empty() {
            continue;
        }
        let candidate = line.strip_prefix("package:").unwrap_or(line).trim();
        if candidate.is_empty() {
            continue;
        }
        if seen.insert(candidate.to_string()) {
            packages.push(candidate.to_string());
        }
    }
    packages
}

fn runtime_probe_candidate_paths() -> [&'static str; 3] {
    [
        "/tmp/palmchat_probe_java.out.realdevice",
        "/tmp/palmchat_probe_java.out",
        "/tmp/palmchat_probe_run.out",
    ]
}

fn runtime_probe_overrides_enabled_from_env_value(value: Option<&str>) -> bool {
    value
        .map(str::trim)
        .filter(|value| !value.is_empty())
        .map(parse_bool_like)
        .unwrap_or(false)
}

fn runtime_probe_overrides_enabled() -> bool {
    runtime_probe_overrides_enabled_from_env_value(
        std::env::var("PALMCHAT_USE_RUNTIME_PROBE_OVERRIDES")
            .ok()
            .as_deref(),
    )
}

fn read_runtime_probe_raw() -> Option<(String, String)> {
    if !runtime_probe_overrides_enabled() {
        return None;
    }
    for path in runtime_probe_candidate_paths() {
        let Ok(raw) = fs::read_to_string(path) else {
            continue;
        };
        if raw.contains("BODY_JSON=")
            || raw.contains("BODY_dfp=")
            || raw.contains("BODY_appList=")
            || raw.contains("APP_LIST_JSON=")
        {
            return Some((path.to_string(), raw));
        }
    }
    None
}

fn parse_runtime_probe_json_line(raw: &str, prefixes: &[&str]) -> Option<Value> {
    for line in raw.lines() {
        let trimmed = line.trim();
        for prefix in prefixes {
            let Some(candidate) = trimmed.strip_prefix(prefix) else {
                continue;
            };
            if let Ok(value) = serde_json::from_str::<Value>(candidate) {
                return Some(value);
            }
        }
    }
    None
}

fn parse_runtime_probe_string_line(raw: &str, prefixes: &[&str]) -> Option<String> {
    for line in raw.lines() {
        let trimmed = line.trim();
        for prefix in prefixes {
            let Some(candidate) = trimmed.strip_prefix(prefix) else {
                continue;
            };
            return Some(candidate.trim().to_string());
        }
    }
    None
}

fn extract_runtime_probe_package_names(value: &Value) -> Option<Vec<String>> {
    let obj = value.as_object()?;
    let items = obj.get("package").and_then(Value::as_array)?;
    let mut seen = HashSet::<String>::new();
    let mut packages = Vec::<String>::new();
    for item in items {
        let Some(name) = item
            .as_object()
            .and_then(|entry| entry.get("packageName"))
            .and_then(Value::as_str)
            .map(str::trim)
            .filter(|value| !value.is_empty())
        else {
            continue;
        };
        if seen.insert(name.to_string()) {
            packages.push(name.to_string());
        }
    }
    if packages.is_empty() {
        None
    } else {
        Some(packages)
    }
}

fn parse_runtime_probe_app_list_packages(raw: &str) -> Option<Vec<String>> {
    parse_runtime_probe_json_line(raw, &["BODY_appList=", "APP_LIST_JSON="])
        .and_then(|value| extract_runtime_probe_package_names(&value))
        .or_else(|| {
            parse_runtime_probe_json_line(raw, &["BODY_JSON="]).and_then(|value| {
                parse_json_string_or_object(value.get("appList"))
                    .and_then(|inner| extract_runtime_probe_package_names(&inner))
            })
        })
}

fn parse_runtime_probe_overrides(
    raw: &str,
    source_path: &str,
) -> Option<PalmchatRuntimeProbeOverrides> {
    let body_json = parse_runtime_probe_json_line(raw, &["BODY_JSON="]);
    let body_dfp = parse_runtime_probe_json_line(raw, &["BODY_dfp="]).or_else(|| {
        body_json
            .as_ref()
            .and_then(|value| parse_json_string_or_object(value.get("dfp")))
    });
    let ip_info_value = parse_runtime_probe_json_line(raw, &["BODY_ipInfo="]).or_else(|| {
        body_json
            .as_ref()
            .and_then(|value| parse_json_string_or_object(value.get("ipInfo")))
    });
    let body_android_id = parse_runtime_probe_string_line(raw, &["BODY_androidId=", "AC1_p="])
        .or_else(|| {
            body_json
                .as_ref()
                .and_then(|value| value.get("androidId"))
                .and_then(Value::as_str)
                .map(|value| value.to_string())
        });
    let dfp_obj = body_dfp.as_ref().and_then(Value::as_object);
    let installed_packages = parse_runtime_probe_app_list_packages(raw);
    let sensor_name_list = dfp_obj
        .and_then(|obj| obj.get("sensor_name_list"))
        .and_then(Value::as_str)
        .map(|value| {
            value
                .split(',')
                .map(|item| item.trim().to_string())
                .filter(|item| !item.is_empty())
                .collect::<Vec<_>>()
        });
    let screen_brightness = dfp_obj.and_then(|obj| {
        obj.get("screen_brightness").and_then(|value| match value {
            Value::Number(v) => v.as_i64(),
            Value::String(v) => v.trim().parse::<i64>().ok(),
            _ => None,
        })
    });
    let screen_on = dfp_obj
        .and_then(|obj| obj.get("screen_on"))
        .map(|value| match value {
            Value::Bool(v) => *v,
            Value::String(v) => parse_bool_like(v),
            Value::Number(v) => v.as_i64().unwrap_or_default() != 0,
            _ => false,
        });
    let boot_time_millis = dfp_obj.and_then(|obj| {
        obj.get("last_boot_time").and_then(|value| match value {
            Value::Number(v) => v.as_i64(),
            Value::String(v) => v.trim().parse::<i64>().ok(),
            _ => None,
        })
    });
    let ip_info = ip_info_value
        .as_ref()
        .and_then(|value| {
            if value.is_null() {
                None
            } else {
                Some(value.to_string())
            }
        })
        .or_else(|| {
            body_json
                .as_ref()
                .and_then(|value| value.get("ipInfo"))
                .and_then(Value::as_str)
                .map(|value| value.to_string())
        });
    let secinfo_json = dfp_obj
        .and_then(|obj| obj.get("sinfo"))
        .and_then(Value::as_str)
        .map(|value| value.to_string());
    let overrides = PalmchatRuntimeProbeOverrides {
        source_path: source_path.to_string(),
        android_id: body_android_id,
        ip_info,
        secinfo_json,
        network_type: dfp_obj
            .and_then(|obj| obj.get("net_type"))
            .and_then(Value::as_str)
            .map(|value| value.to_string()),
        network_state: dfp_obj
            .and_then(|obj| obj.get("netState"))
            .and_then(Value::as_str)
            .map(|value| value.to_string()),
        wifi_ssid: dfp_obj
            .and_then(|obj| obj.get("wifiSSID"))
            .and_then(Value::as_str)
            .map(|value| value.to_string()),
        wlan_ipv4: dfp_obj
            .and_then(|obj| obj.get("wifi_ip").or_else(|| obj.get("ip")))
            .and_then(Value::as_str)
            .map(|value| value.to_string()),
        resolution: dfp_obj
            .and_then(|obj| obj.get("resolution"))
            .and_then(Value::as_str)
            .map(|value| value.to_string()),
        screen_brightness,
        screen_on,
        sensor_name_list,
        device_label: dfp_obj
            .and_then(|obj| obj.get("duDeviceLabel"))
            .and_then(Value::as_str)
            .map(|value| value.to_string()),
        baseband_version: dfp_obj
            .and_then(|obj| obj.get("basicVersion"))
            .and_then(Value::as_str)
            .map(|value| value.to_string()),
        kernel_version: dfp_obj
            .and_then(|obj| obj.get("kernelVersion"))
            .and_then(Value::as_str)
            .map(|value| value.to_string()),
        boot_time_millis,
        installed_packages,
    };
    if overrides.android_id.is_none()
        && overrides.ip_info.is_none()
        && overrides.secinfo_json.is_none()
        && overrides.installed_packages.is_none()
    {
        None
    } else {
        Some(overrides)
    }
}

fn apply_runtime_probe_overrides(
    profile: &mut PalmchatLiveDeviceProfile,
    overrides: &PalmchatRuntimeProbeOverrides,
) {
    if let Some(value) = overrides.android_id.clone() {
        profile.android_id = Some(value);
    }
    if let Some(value) = overrides.ip_info.clone() {
        profile.ip_info = Some(value);
    }
    if let Some(value) = overrides.secinfo_json.clone() {
        profile.secinfo_json = Some(value);
    }
    if let Some(value) = overrides.network_type.clone() {
        profile.network_type = Some(value);
    }
    if let Some(value) = overrides.network_state.clone() {
        profile.network_state = Some(value);
    }
    if let Some(value) = overrides.wifi_ssid.clone() {
        profile.wifi_ssid = Some(value);
    }
    if let Some(value) = overrides.wlan_ipv4.clone() {
        profile.wlan_ipv4 = Some(value);
    }
    if let Some(value) = overrides.resolution.clone() {
        profile.resolution = Some(value);
    }
    if let Some(value) = overrides.screen_brightness {
        profile.screen_brightness = Some(value);
    }
    if let Some(value) = overrides.screen_on {
        profile.screen_on = Some(value);
    }
    if let Some(value) = overrides.sensor_name_list.clone() {
        profile.sensor_name_list = value;
    }
    if let Some(value) = overrides.device_label.clone() {
        profile.device_label = Some(value);
    }
    if let Some(value) = overrides.baseband_version.clone() {
        profile.baseband_version = Some(value);
    }
    if let Some(value) = overrides.kernel_version.clone() {
        profile.kernel_version = Some(value);
    }
    if let Some(value) = overrides.boot_time_millis {
        profile.boot_time_millis = Some(value);
    }
    if let Some(value) = overrides.installed_packages.clone() {
        profile.installed_packages = value;
    }
}

fn install_system_properties(
    emulator: &AndroidEmulator<'static, ()>,
    config: &PalmchatConfig,
    live_profile: Option<&PalmchatLiveDeviceProfile>,
) {
    let api = config.android_api.to_string();
    let brand = live_profile
        .and_then(|profile| profile.product_brand.clone())
        .unwrap_or_else(|| "realme".to_string());
    let manufacturer = live_profile
        .and_then(|profile| profile.product_manufacturer.clone())
        .unwrap_or_else(|| brand.clone());
    let model = live_profile
        .and_then(|profile| profile.product_model.clone())
        .unwrap_or_else(|| "RMX3560".to_string());
    let device = live_profile
        .and_then(|profile| profile.product_device.clone())
        .unwrap_or_else(|| model.clone());
    let product_name = live_profile
        .and_then(|profile| profile.product_name.clone())
        .unwrap_or_else(|| model.clone());
    let hardware = live_profile
        .and_then(|profile| profile.hardware.clone())
        .unwrap_or_else(|| "mt6895".to_string());
    let build_id = live_profile
        .and_then(|profile| profile.build_id.clone())
        .unwrap_or_default();
    let build_release = live_profile
        .and_then(|profile| profile.build_release.clone())
        .unwrap_or_default();
    let build_fingerprint = live_profile
        .and_then(|profile| profile.build_fingerprint.clone())
        .unwrap_or_default();
    let build_display = live_profile
        .and_then(|profile| profile.build_display.clone())
        .unwrap_or_default();
    let build_host = live_profile
        .and_then(|profile| profile.build_host.clone())
        .unwrap_or_default();
    let build_security_patch = live_profile
        .and_then(|profile| profile.build_security_patch.clone())
        .unwrap_or_default();
    let service: SystemPropertyService = Rc::new(Box::new(move |name| match name {
        "ro.build.version.sdk" => Some(api.clone()),
        "ro.product.brand" => Some(brand.clone()),
        "ro.product.manufacturer" => Some(manufacturer.clone()),
        "ro.product.model" => Some(model.clone()),
        "ro.product.device" => Some(device.clone()),
        "ro.product.name" => Some(product_name.clone()),
        "ro.hardware" | "ro.boot.hardware" => Some(hardware.clone()),
        "ro.build.id" if !build_id.is_empty() => Some(build_id.clone()),
        "ro.build.version.release" if !build_release.is_empty() => Some(build_release.clone()),
        "ro.build.fingerprint" if !build_fingerprint.is_empty() => Some(build_fingerprint.clone()),
        "ro.build.display.id" if !build_display.is_empty() => Some(build_display.clone()),
        "ro.build.host" if !build_host.is_empty() => Some(build_host.clone()),
        "ro.build.version.security_patch" if !build_security_patch.is_empty() => {
            Some(build_security_patch.clone())
        }
        "persist.sys.timezone" => Some("Asia/Shanghai".to_string()),
        _ => None,
    }));
    emulator.set_system_property_service(service);
}

fn build_direction_from_host_dir(host_path: &Path, guest_path: &str) -> Direction {
    let mut entries = VecDeque::new();
    if let Ok(dir) = fs::read_dir(host_path) {
        for entry in dir.flatten() {
            let name = entry.file_name().to_string_lossy().to_string();
            if name.is_empty() {
                continue;
            }
            let is_file = entry.file_type().map(|kind| kind.is_file()).unwrap_or(false);
            entries.push_back(DirectionEntry::new(is_file, &name));
        }
    }
    Direction::new(entries, guest_path)
}

fn open_host_file_for_oflags(host_path: &Path, flags: emulator::linux::structs::OFlag) -> Result<File> {
    let mut options = OpenOptions::new();
    let accmode = flags.bits() & emulator::linux::structs::OFlag::O_ACCMODE.bits();
    match accmode {
        value if value == emulator::linux::structs::OFlag::O_WRONLY.bits() => {
            options.write(true);
        }
        value if value == emulator::linux::structs::OFlag::O_RDWR.bits() => {
            options.read(true).write(true);
        }
        _ => {
            options.read(true);
        }
    }
    if flags.contains(emulator::linux::structs::OFlag::O_CREAT) {
        options.create(true);
    }
    if flags.contains(emulator::linux::structs::OFlag::O_EXCL) {
        options.create_new(true);
    }
    if flags.contains(emulator::linux::structs::OFlag::O_TRUNC) {
        options.truncate(true);
    }
    if flags.contains(emulator::linux::structs::OFlag::O_APPEND) {
        options.append(true);
    }
    options.open(host_path).with_context(|| {
        format!(
            "failed to open app-context host file {} for flags {:?}",
            host_path.display(),
            flags
        )
    })
}

fn resolve_app_context_file_io(
    app_context_fs: &PalmchatAppContextFs,
    path: &str,
    flags: emulator::linux::structs::OFlag,
) -> Option<FileIO<()>> {
    let host_path = app_context_fs.host_path_for_guest(path)?;
    if host_path.is_dir() {
        return Some(FileIO::Direction(build_direction_from_host_dir(
            &host_path, path,
        )));
    }
    if host_path.exists() {
        return match open_host_file_for_oflags(&host_path, flags) {
            Ok(file) => Some(FileIO::File(LinuxFileIO::new_with_file(
                file,
                path,
                flags.bits(),
                12345,
                StMode::APP_FILE,
            ))),
            Err(_) => Some(FileIO::Error(Errno::ENOENT.as_i32())),
        };
    }
    if flags.contains(emulator::linux::structs::OFlag::O_CREAT) {
        if let Some(parent) = host_path.parent() {
            let _ = fs::create_dir_all(parent);
        }
        return match open_host_file_for_oflags(&host_path, flags) {
            Ok(file) => Some(FileIO::File(LinuxFileIO::new_with_file(
                file,
                path,
                flags.bits(),
                12345,
                StMode::APP_FILE,
            ))),
            Err(_) => Some(FileIO::Error(Errno::ENOENT.as_i32())),
        };
    }
    None
}

fn configure_file_system(
    emulator: &AndroidEmulator<'static, ()>,
    config: &PalmchatConfig,
    app_context_fs: &PalmchatAppContextFs,
) {
    let package_name = config.package_name.clone();
    let apk_path = config.apk_path.clone();
    let so_path = config.so_path.clone();
    let wksec = config.wksec_so_path.clone();
    let app_context_fs = app_context_fs.clone();
    let so_name = so_path
        .file_name()
        .map(|name| name.to_string_lossy().to_string())
        .unwrap_or_else(|| "libzhangxin.2.so".to_string());
    let pid = PID;

    emulator
        .get_file_system()
        .set_file_resolver(Box::new(move |_fs, path, flags, _mode| {
            if path == "/proc/self/cmdline" || path == format!("/proc/{pid}/cmdline") {
                return Some(FileIO::Bytes(ByteArrayFileIO::new(
                    format!("{package_name}\0").into_bytes(),
                    path.to_string(),
                    0,
                    flags.bits(),
                    StMode::APP_FILE,
                )));
            }

            if path.ends_with("/base.apk") || normalize(PathBuf::from(path)) == apk_path {
                return Some(FileIO::File(LinuxFileIO::new(
                    apk_path.to_string_lossy().as_ref(),
                    path,
                    flags.bits(),
                    12345,
                    StMode::APP_FILE,
                )));
            }

            if path.ends_with(&format!("/{}", so_name)) || normalize(PathBuf::from(path)) == so_path
            {
                return Some(FileIO::File(LinuxFileIO::new(
                    so_path.to_string_lossy().as_ref(),
                    path,
                    flags.bits(),
                    12345,
                    StMode::APP_FILE,
                )));
            }

            if let Some(wksec_so_path) = &wksec {
                if path.ends_with("/libwksec-lib.so")
                    || normalize(PathBuf::from(path)) == *wksec_so_path
                {
                    return Some(FileIO::File(LinuxFileIO::new(
                        wksec_so_path.to_string_lossy().as_ref(),
                        path,
                        flags.bits(),
                        12345,
                        StMode::APP_FILE,
                    )));
                }
            }

            if let Some(file) = resolve_app_context_file_io(&app_context_fs, path, flags) {
                return Some(file);
            }

            None
        }));
}

fn normalize(path: PathBuf) -> PathBuf {
    if path.is_absolute() {
        path
    } else {
        std::env::current_dir()
            .unwrap_or_else(|_| PathBuf::from("."))
            .join(path)
    }
}

fn parse_arg_bytes(raw: &str) -> Result<Vec<u8>> {
    let value = raw.trim();
    if value.is_empty() {
        return Ok(Vec::new());
    }
    let hex_candidate = value
        .strip_prefix("hex:")
        .or_else(|| value.strip_prefix("HEX:"))
        .unwrap_or(value);
    if hex_candidate.len() % 2 == 0
        && !hex_candidate.is_empty()
        && hex_candidate
            .as_bytes()
            .iter()
            .all(|byte| byte.is_ascii_hexdigit())
    {
        return hex::decode(hex_candidate)
            .with_context(|| format!("failed to decode hex bytes: {value}"));
    }
    Ok(value.as_bytes().to_vec())
}

fn resolve_fast_hashkey_global_ref(
    vm: &mut DalvikVM64<()>,
    shared: Rc<RefCell<SharedState>>,
    env_name: &str,
    config_value: Option<&str>,
) -> Option<i64> {
    let (raw, source) = if let Ok(env_value) = std::env::var(env_name) {
        (env_value, format!("env={env_name}"))
    } else if let Some(config_value) = config_value {
        (config_value.to_string(), "config.hash_key_fast".to_string())
    } else {
        return None;
    };
    let value = raw.trim().to_ascii_uppercase();
    if !is_hashkey_hex32(&value) {
        shared.borrow_mut().native(&format!(
            "fast hashkey ignored source={} reason=invalid-format value={}",
            source, raw
        ));
        return None;
    }
    let ref_id = vm.add_global_ref(DvmObject::String(value.clone()));
    shared.borrow_mut().native(&format!(
        "fast hashkey enabled source={} ref=0x{:x} value={}",
        source, ref_id as u64, value
    ));
    Some(ref_id)
}

fn is_hashkey_hex32(value: &str) -> bool {
    if value.len() != 32 {
        return false;
    }
    value
        .as_bytes()
        .iter()
        .all(|byte| matches!(byte, b'0'..=b'9' | b'A'..=b'F'))
}

fn run_init_during_load() -> bool {
    std::env::var("PALMCHAT_LOAD_INIT")
        .ok()
        .map(|value| {
            let lowered = value.trim().to_ascii_lowercase();
            matches!(lowered.as_str(), "1" | "true" | "yes" | "on")
        })
        .unwrap_or(false)
}

fn sdk23_base_path() -> PathBuf {
    PathBuf::from(env!("CARGO_MANIFEST_DIR"))
        .join("android")
        .join("sdk23")
}

fn prepare_runtime_base_path(
    config: &PalmchatConfig,
    shared: Rc<RefCell<SharedState>>,
) -> Result<PathBuf> {
    let sdk_base = sdk23_base_path();
    if config.system_lib_overrides.is_empty() {
        shared.borrow_mut().native(&format!(
            "runtime base path mode=default base={}",
            sdk_base.display()
        ));
        return Ok(sdk_base);
    }

    let runtime_tag = SystemTime::now()
        .duration_since(UNIX_EPOCH)
        .unwrap_or_default()
        .as_nanos();
    let runtime_base = config.trace_out_dir.join(format!(
        "runtime_base_{}_{}",
        std::process::id(),
        runtime_tag
    ));

    let source_lib_dir = sdk_base.join("system").join("lib64");
    let target_lib_dir = runtime_base.join("system").join("lib64");
    fs::create_dir_all(&target_lib_dir).with_context(|| {
        format!(
            "failed to create runtime lib directory: {}",
            target_lib_dir.display()
        )
    })?;

    for entry in fs::read_dir(&source_lib_dir).with_context(|| {
        format!(
            "failed to list sdk23 system libs under {}",
            source_lib_dir.display()
        )
    })? {
        let entry = entry?;
        let source = entry.path();
        if !source.is_file() {
            continue;
        }
        let target = target_lib_dir.join(entry.file_name());
        replace_symlink(&source, &target)?;
    }

    let mut override_lines = Vec::new();
    let mut overrides = config
        .system_lib_overrides
        .iter()
        .collect::<Vec<(&String, &PathBuf)>>();
    overrides.sort_by(|a, b| a.0.cmp(b.0));
    for (name, override_path) in overrides {
        let target = target_lib_dir.join(name);
        replace_symlink(override_path, &target)?;
        override_lines.push(format!("{name}={}", override_path.display()));
    }

    shared.borrow_mut().native(&format!(
        "runtime base path mode=overlay base={} overrides=[{}]",
        runtime_base.display(),
        override_lines.join(",")
    ));
    Ok(runtime_base)
}

fn replace_symlink(source: &Path, target: &Path) -> Result<()> {
    if let Some(parent) = target.parent() {
        fs::create_dir_all(parent).with_context(|| {
            format!(
                "failed to create target parent directory: {}",
                parent.display()
            )
        })?;
    }
    if target.exists() || target.symlink_metadata().is_ok() {
        fs::remove_file(target)
            .or_else(|_| fs::remove_dir_all(target))
            .with_context(|| format!("failed to remove existing target: {}", target.display()))?;
    }
    symlink(source, target).with_context(|| {
        format!(
            "failed to create symlink {} -> {}",
            target.display(),
            source.display()
        )
    })?;
    Ok(())
}

fn apply_got_seed_manifest(
    config: &PalmchatConfig,
    emulator: &AndroidEmulator<'static, ()>,
    shared: Rc<RefCell<SharedState>>,
    module_base: u64,
) -> Result<()> {
    let Some(path) = &config.got_seed_path else {
        return Ok(());
    };

    let raw = fs::read_to_string(path)
        .with_context(|| format!("failed to read got seed manifest: {}", path.display()))?;
    let entries: Vec<PalmchatGotSeedEntry> = serde_json::from_str(&raw)
        .with_context(|| format!("failed to parse got seed manifest json: {}", path.display()))?;

    let mut applied = 0usize;
    let mut skipped = 0usize;
    for entry in entries {
        let slot_offset = parse_u64ish(&entry.slot_offset)
            .with_context(|| format!("invalid slot_offset in got seed entry: {:?}", entry))?;
        let slot_addr = module_base + slot_offset;
        let target_addr = if entry.module == "self" {
            let target_offset = entry
                .target_offset
                .as_deref()
                .ok_or_else(|| anyhow!("self seed entry missing target_offset"))?;
            module_base
                + parse_u64ish(target_offset).with_context(|| {
                    format!("invalid target_offset in got seed entry: {:?}", entry)
                })?
        } else {
            let symbol = entry
                .symbol
                .as_deref()
                .ok_or_else(|| anyhow!("external seed entry missing symbol"))?;
            let Some(address) = emulator.resolve_loaded_symbol(Some(entry.module.as_str()), symbol)
            else {
                skipped += 1;
                shared.borrow_mut().native(&format!(
                    "GOT seed unresolved module={} symbol={} slot_offset=0x{:x}",
                    entry.module, symbol, slot_offset
                ));
                continue;
            };
            address
        };

        emulator
            .backend
            .mem_write(slot_addr, &target_addr.to_le_bytes())
            .with_context(|| {
                format!(
                    "failed to write got seed slot=0x{:x} target=0x{:x}",
                    slot_addr, target_addr
                )
            })?;
        applied += 1;
    }

    shared.borrow_mut().native(&format!(
        "GOT seed manifest applied path={} applied={} skipped={}",
        path.display(),
        applied,
        skipped
    ));
    for slot_offset in [0x1826d8_u64, 0x182d40_u64, 0x183f08_u64] {
        let slot_addr = module_base + slot_offset;
        let slot_value = emulator
            .backend
            .mem_read_as_vec(slot_addr, 8)
            .ok()
            .and_then(|bytes| {
                bytes
                    .get(0..8)
                    .map(|slice| u64::from_le_bytes(slice.try_into().unwrap()))
            })
            .unwrap_or(0);
        shared.borrow_mut().native(&format!(
            "GOT seed slot slot_offset=0x{:x} slot_addr=0x{:x} value=0x{:x}",
            slot_offset, slot_addr, slot_value
        ));
    }
    Ok(())
}

fn apply_runtime_page_patch_entries(
    entries: &[PalmchatPagePatchEntry],
    emulator: &AndroidEmulator<'static, ()>,
    shared: Rc<RefCell<SharedState>>,
    module_base: u64,
    label: &str,
) -> Result<()> {
    if entries.is_empty() {
        return Ok(());
    }

    for entry in entries {
        let offset = parse_u64ish(&entry.offset).with_context(|| {
            format!(
                "invalid runtime page patch offset={} path={}",
                entry.offset,
                entry.path.display()
            )
        })?;
        let mut bytes = fs::read(&entry.path).with_context(|| {
            format!(
                "failed to read runtime page patch: {}",
                entry.path.display()
            )
        })?;
        let mut rebase_summaries = apply_pointer_rebases_to_bytes(
            &mut bytes,
            &entry.pointer_rebases,
            emulator,
            module_base,
            None,
            &format!("runtime page patch path={}", entry.path.display()),
        )?;
        let addr = module_base + offset;
        emulator
            .backend
            .mem_write(addr, bytes.as_slice())
            .with_context(|| {
                format!(
                    "failed to apply runtime page patch addr=0x{:x} path={}",
                    addr,
                    entry.path.display()
                )
            })?;
        for scratch in &entry.scratch_pointer_slots {
            let slot_offset = parse_u64ish(&scratch.slot_offset).with_context(|| {
                format!(
                    "invalid runtime page patch scratch slot_offset={} path={}",
                    scratch.slot_offset,
                    entry.path.display()
                )
            })?;
            let alloc_size = parse_u64ish(&scratch.alloc_size).with_context(|| {
                format!(
                    "invalid runtime page patch scratch alloc_size={} path={}",
                    scratch.alloc_size,
                    entry.path.display()
                )
            })? as usize;
            let slot_addr = addr + slot_offset;
            let old_value = emulator
                .backend
                .mem_read_as_vec(slot_addr, 8)
                .ok()
                .and_then(|bytes| {
                    bytes
                        .get(0..8)
                        .map(|slice| u64::from_le_bytes(slice.try_into().unwrap()))
                })
                .unwrap_or(0);
            let scratch_ptr = emulator.falloc(alloc_size, false).with_context(|| {
                format!(
                    "failed to allocate runtime page patch scratch size=0x{:x} path={}",
                    alloc_size,
                    entry.path.display()
                )
            })?;
            let mut scratch_bytes = vec![0u8; alloc_size];
            let mut seed_summary = String::new();
            if let Some(seed_path) = &scratch.seed_path {
                let seed_offset = scratch
                    .seed_offset
                    .as_deref()
                    .map(parse_u64ish)
                    .transpose()
                    .with_context(|| {
                        format!(
                            "invalid runtime page patch scratch seed_offset={:?} path={}",
                            scratch.seed_offset,
                            entry.path.display()
                        )
                    })?
                    .unwrap_or(0) as usize;
                let seed_bytes = fs::read(seed_path).with_context(|| {
                    format!(
                        "failed to read runtime page patch scratch seed: {}",
                        seed_path.display()
                    )
                })?;
                let seed_slice = seed_bytes
                    .get(seed_offset..seed_offset + alloc_size)
                    .ok_or_else(|| {
                        anyhow!(
                            "runtime page patch scratch seed slice out of range seed={} seed_offset=0x{:x} alloc_size=0x{:x}",
                            seed_path.display(),
                            seed_offset,
                            alloc_size
                        )
                    })?;
                scratch_bytes.copy_from_slice(seed_slice);
                let scratch_rebase_summaries = apply_pointer_rebases_to_bytes(
                    &mut scratch_bytes,
                    &scratch.pointer_rebases,
                    emulator,
                    module_base,
                    Some(scratch_ptr.addr),
                    &format!(
                        "runtime scratch seed path={} slot=0x{:x}",
                        seed_path.display(),
                        slot_offset
                    ),
                )?;
                seed_summary = format!(
                    " seed={} seed_offset=0x{:x} seed_rebases=[{}]",
                    seed_path.display(),
                    seed_offset,
                    scratch_rebase_summaries.join(",")
                );
            }
            emulator
                .backend
                .mem_write(scratch_ptr.addr, scratch_bytes.as_slice())
                .with_context(|| {
                    format!(
                        "failed to seed runtime page patch scratch addr=0x{:x} path={}",
                        scratch_ptr.addr,
                        entry.path.display()
                    )
                })?;
            emulator
                .backend
                .mem_write(slot_addr, &scratch_ptr.addr.to_le_bytes())
                .with_context(|| {
                    format!(
                        "failed to write runtime page patch scratch slot addr=0x{:x} path={}",
                        slot_addr,
                        entry.path.display()
                    )
                })?;
            rebase_summaries.push(format!(
                "scratch_slot:0x{:x}->0x{:x} old=0x{:x} size=0x{:x}{}",
                slot_offset, scratch_ptr.addr, old_value, alloc_size, seed_summary
            ));
        }
        shared.borrow_mut().native(&format!(
            "{} applied offset=0x{:x} addr=0x{:x} size=0x{:x} path={} rebases=[{}]",
            label,
            offset,
            addr,
            bytes.len(),
            entry.path.display(),
            rebase_summaries.join(",")
        ));
    }

    Ok(())
}

fn audit_runtime_self_gap_targets(
    entries: &[PalmchatPagePatchEntry],
    emulator: &AndroidEmulator<'static, ()>,
    shared: Rc<RefCell<SharedState>>,
    module_base: u64,
    module_end: u64,
) -> Result<()> {
    if entries.is_empty() {
        return Ok(());
    }

    let mut covered = Vec::new();
    for entry in entries {
        let offset = parse_u64ish(&entry.offset).with_context(|| {
            format!(
                "invalid runtime page patch offset={} path={}",
                entry.offset,
                entry.path.display()
            )
        })?;
        let len = fs::metadata(&entry.path)
            .with_context(|| {
                format!(
                    "failed to stat runtime page patch: {}",
                    entry.path.display()
                )
            })?
            .len();
        covered.push((module_base + offset, module_base + offset + len));
    }
    covered.sort_unstable_by_key(|(start, _)| *start);

    let mut total = 0usize;
    let mut unique_targets = HashSet::new();
    let mut samples = Vec::new();
    for (start, end) in &covered {
        let len = (*end - *start) as usize;
        let bytes = emulator
            .backend
            .mem_read_as_vec(*start, len)
            .with_context(|| {
                format!("failed to read patched runtime region 0x{start:x}-0x{end:x}")
            })?;
        for off in (0..len.saturating_sub(8)).step_by(8) {
            let value = u64::from_le_bytes(bytes[off..off + 8].try_into().unwrap());
            if value < module_base || value >= module_end || addr_in_ranges(value, &covered) {
                continue;
            }
            total += 1;
            unique_targets.insert(value);
            if samples.len() < 8 {
                samples.push(format!(
                    "slot=0x{:x}->target=0x{:x}",
                    *start + off as u64,
                    value
                ));
            }
        }
    }

    if total != 0 {
        shared.borrow_mut().native(&format!(
            "runtime self uncovered targets count={} unique={} samples=[{}]",
            total,
            unique_targets.len(),
            samples.join(",")
        ));
    }

    Ok(())
}

fn addr_in_ranges(addr: u64, ranges: &[(u64, u64)]) -> bool {
    ranges
        .iter()
        .any(|(start, end)| *start <= addr && addr < *end)
}

fn apply_runtime_page_patches(
    config: &PalmchatConfig,
    emulator: &AndroidEmulator<'static, ()>,
    shared: Rc<RefCell<SharedState>>,
    module_base: u64,
) -> Result<()> {
    apply_runtime_raw_maps(config, emulator, shared.clone(), module_base)?;
    apply_runtime_page_patch_entries(
        &config.runtime_page_patches,
        emulator,
        shared.clone(),
        module_base,
        "runtime page patch",
    )?;
    audit_runtime_self_gap_targets(
        &config.runtime_page_patches,
        emulator,
        shared,
        module_base,
        module_base + 0x190000,
    )
}

fn apply_runtime_raw_maps(
    config: &PalmchatConfig,
    emulator: &AndroidEmulator<'static, ()>,
    shared: Rc<RefCell<SharedState>>,
    module_base: u64,
) -> Result<()> {
    for entry in &config.runtime_raw_maps {
        let address = parse_u64ish(&entry.address).with_context(|| {
            format!(
                "invalid runtime raw map address={} path={}",
                entry.address,
                entry.path.display()
            )
        })?;
        let mut bytes = fs::read(&entry.path)
            .with_context(|| format!("failed to read runtime raw map: {}", entry.path.display()))?;
        let rebase_summaries = apply_pointer_rebases_to_bytes(
            &mut bytes,
            &entry.pointer_rebases,
            emulator,
            module_base,
            None,
            &format!("runtime raw map path={}", entry.path.display()),
        )?;
        let aligned = ((bytes.len().max(1) - 1) / PAGE_ALIGN + 1) * PAGE_ALIGN;
        let already_mapped = {
            let memory = emulator.memory();
            memory.is_range_mapped(address, aligned)
        };
        if !already_mapped {
            let _ = emulator.memory().mem_map(
                address,
                aligned,
                (Permission::READ | Permission::WRITE).bits(),
                format!("raw:{}", entry.path.display()),
                PAGE_ALIGN as u64,
            );
        } else {
            shared.borrow_mut().native(&format!(
                "runtime raw map reuse existing mapping addr=0x{:x} size=0x{:x} path={}",
                address,
                bytes.len(),
                entry.path.display()
            ));
        }
        emulator
            .backend
            .mem_write(address, bytes.as_slice())
            .with_context(|| {
                format!(
                    "failed to seed runtime raw map addr=0x{:x} path={}",
                    address,
                    entry.path.display()
                )
            })?;
        shared.borrow_mut().native(&format!(
            "runtime raw map applied addr=0x{:x} size=0x{:x} path={} rebases=[{}]",
            address,
            bytes.len(),
            entry.path.display(),
            rebase_summaries.join(",")
        ));
    }
    Ok(())
}

fn sign_extend_i64(value: i64, bits: u32) -> i64 {
    let shift = 64_u32.saturating_sub(bits);
    (value << shift) >> shift
}

fn decode_plt_slot_from_stub_bytes(pc: u64, bytes: &[u8]) -> Option<u64> {
    if bytes.len() < 12 {
        return None;
    }
    let adrp = u32::from_le_bytes(bytes.get(0..4)?.try_into().ok()?);
    let ldr = u32::from_le_bytes(bytes.get(4..8)?.try_into().ok()?);
    let add = u32::from_le_bytes(bytes.get(8..12)?.try_into().ok()?);

    if adrp & 0x9f00_0000 != 0x9000_0000 {
        return None;
    }
    let adrp_rd = (adrp & 0x1f) as u8;
    let immlo = ((adrp >> 29) & 0x3) as i64;
    let immhi = ((adrp >> 5) & 0x7ffff) as i64;
    let adrp_imm = sign_extend_i64((immhi << 2) | immlo, 21) << 12;
    let adrp_page = ((pc & !0xfff) as i64).checked_add(adrp_imm)? as u64;

    if ldr & 0xffc0_0000 != 0xf940_0000 {
        return None;
    }
    let ldr_rt = (ldr & 0x1f) as u8;
    let ldr_rn = ((ldr >> 5) & 0x1f) as u8;
    let ldr_imm = (((ldr >> 10) & 0xfff) as u64) << 3;

    if add & 0xff00_0000 != 0x9100_0000 {
        return None;
    }
    let add_rd = (add & 0x1f) as u8;
    let add_rn = ((add >> 5) & 0x1f) as u8;
    let add_shift = (add >> 22) & 0x3;
    if add_shift > 1 {
        return None;
    }
    let add_imm = (((add >> 10) & 0xfff) as u64) << if add_shift == 1 { 12 } else { 0 };

    if adrp_rd != 16 || ldr_rn != 16 || ldr_rt != 17 || add_rn != 16 || add_rd != 16 {
        return None;
    }
    if add_imm != ldr_imm {
        return None;
    }
    adrp_page.checked_add(add_imm)
}

fn arm64_gp_register(index: u8) -> Option<UnicornRegisterARM64> {
    match index {
        0 => Some(UnicornRegisterARM64::X0),
        1 => Some(UnicornRegisterARM64::X1),
        2 => Some(UnicornRegisterARM64::X2),
        3 => Some(UnicornRegisterARM64::X3),
        4 => Some(UnicornRegisterARM64::X4),
        5 => Some(UnicornRegisterARM64::X5),
        6 => Some(UnicornRegisterARM64::X6),
        7 => Some(UnicornRegisterARM64::X7),
        8 => Some(UnicornRegisterARM64::X8),
        9 => Some(UnicornRegisterARM64::X9),
        10 => Some(UnicornRegisterARM64::X10),
        11 => Some(UnicornRegisterARM64::X11),
        12 => Some(UnicornRegisterARM64::X12),
        13 => Some(UnicornRegisterARM64::X13),
        14 => Some(UnicornRegisterARM64::X14),
        15 => Some(UnicornRegisterARM64::X15),
        16 => Some(UnicornRegisterARM64::X16),
        17 => Some(UnicornRegisterARM64::X17),
        18 => Some(UnicornRegisterARM64::X18),
        19 => Some(UnicornRegisterARM64::X19),
        20 => Some(UnicornRegisterARM64::X20),
        21 => Some(UnicornRegisterARM64::X21),
        22 => Some(UnicornRegisterARM64::X22),
        23 => Some(UnicornRegisterARM64::X23),
        24 => Some(UnicornRegisterARM64::X24),
        25 => Some(UnicornRegisterARM64::X25),
        26 => Some(UnicornRegisterARM64::X26),
        27 => Some(UnicornRegisterARM64::X27),
        28 => Some(UnicornRegisterARM64::X28),
        29 => Some(UnicornRegisterARM64::FP),
        30 => Some(UnicornRegisterARM64::LR),
        _ => None,
    }
}

fn read_arm64_gp_register(
    backend: &Unicorn<'_, ()>,
    index: u8,
) -> Option<(UnicornRegisterARM64, u64)> {
    let reg = arm64_gp_register(index)?;
    let value = backend.reg_read(reg).ok()?;
    Some((reg, value))
}

fn decode_arm64_branch_summary(pc: u64, insn: u32, backend: &Unicorn<'_, ()>) -> Option<String> {
    if insn & 0xfc00_0000 == 0x9400_0000 {
        let imm26 = (insn & 0x03ff_ffff) as i64;
        let offset = sign_extend_i64(imm26 << 2, 28);
        let target = (pc as i64).checked_add(offset)? as u64;
        return Some(format!("BL target=0x{target:x}"));
    }
    if insn & 0xfc00_0000 == 0x1400_0000 {
        let imm26 = (insn & 0x03ff_ffff) as i64;
        let offset = sign_extend_i64(imm26 << 2, 28);
        let target = (pc as i64).checked_add(offset)? as u64;
        return Some(format!("B target=0x{target:x}"));
    }
    if insn & 0xffff_fc1f == 0xd63f_0000 {
        let reg_index = ((insn >> 5) & 0x1f) as u8;
        if let Some((_reg, value)) = read_arm64_gp_register(backend, reg_index) {
            return Some(format!("BLR x{}=0x{:x}", reg_index, value));
        }
        return Some(format!("BLR x{}", reg_index));
    }
    if insn & 0xffff_fc1f == 0xd61f_0000 {
        let reg_index = ((insn >> 5) & 0x1f) as u8;
        if let Some((_reg, value)) = read_arm64_gp_register(backend, reg_index) {
            return Some(format!("BR x{}=0x{:x}", reg_index, value));
        }
        return Some(format!("BR x{}", reg_index));
    }
    if insn == 0xd65f_03c0 {
        let lr = backend.reg_read(UnicornRegisterARM64::LR).unwrap_or(0);
        return Some(format!("RET lr=0x{lr:x}"));
    }
    None
}

#[cfg(feature = "unicorn")]
fn install_palmchat_asset_shim_hooks(
    emulator: &AndroidEmulator<'static, ()>,
    shared: Rc<RefCell<SharedState>>,
    apk_path: &Path,
    asset_manager_native_ptr: u64,
) -> Result<()> {
    const PALMCHAT_ASSET_SHIM_ARENA_SIZE: usize = 0x0080_0000;

    let Backend::Unicorn(unicorn) = &emulator.backend;
    let asset_arena = emulator
        .falloc(PALMCHAT_ASSET_SHIM_ARENA_SIZE, false)
        .context("failed to allocate palmchat asset shim arena")?;
    let asset_state = Rc::new(RefCell::new(PalmchatAssetShimState {
        manager_ptr: asset_manager_native_ptr,
        apk_path: apk_path.to_path_buf(),
        arena_base: asset_arena.addr,
        arena_cursor: asset_arena.addr,
        arena_end: asset_arena.addr + PALMCHAT_ASSET_SHIM_ARENA_SIZE as u64,
        open_handles: HashMap::new(),
    }));
    shared.borrow_mut().native(&format!(
        "installed palmchat asset shim manager_ptr=0x{:x} arena=[0x{:x},0x{:x}) apk={}",
        asset_manager_native_ptr,
        asset_arena.addr,
        asset_arena.addr + PALMCHAT_ASSET_SHIM_ARENA_SIZE as u64,
        apk_path.display()
    ));

    let resolve_symbol = |symbol: &str| {
        emulator
            .resolve_loaded_symbol(Some("libandroid.so"), symbol)
            .or_else(|| emulator.resolve_loaded_symbol(Some("libandroid_runtime.so"), symbol))
            .or_else(|| emulator.resolve_loaded_symbol(None, symbol))
    };

    if let Some(target) = resolve_symbol("_ZN7android30AssetManagerForNdkAssetManagerEP13AAssetManager")
    {
        let bridge_shared = shared.clone();
        unicorn
            .add_code_hook(target, target + 4, move |backend, _address, _size| {
                let lr = backend.reg_read(UnicornRegisterARM64::LR).unwrap_or(0);
                let x0 = backend.reg_read(UnicornRegisterARM64::X0).unwrap_or(0);
                let _ = backend.reg_write(
                    UnicornRegisterARM64::X0,
                    if x0 == 0 { asset_manager_native_ptr } else { x0 },
                );
                let _ = backend.reg_write(UnicornRegisterARM64::PC, lr);
                bridge_shared.borrow_mut().native(&format!(
                    "asset_shim AssetManagerForNdkAssetManager manager_in=0x{:x} manager_out=0x{:x}",
                    x0,
                    if x0 == 0 { asset_manager_native_ptr } else { x0 }
                ));
            })
            .map_err(|err| anyhow!("failed to install AssetManagerForNdkAssetManager shim: {err:?}"))?;
    }

    if let Some(target) = resolve_symbol("AAssetManager_open") {
        let open_state = asset_state.clone();
        let open_shared = shared.clone();
        unicorn
            .add_code_hook(target, target + 4, move |backend, _address, _size| {
                let lr = backend.reg_read(UnicornRegisterARM64::LR).unwrap_or(0);
                let manager_ptr = backend.reg_read(UnicornRegisterARM64::X0).unwrap_or(0);
                let name_ptr = backend.reg_read(UnicornRegisterARM64::X1).unwrap_or(0);
                let mode = backend.reg_read(UnicornRegisterARM64::X2).unwrap_or(0);
                let requested_name = read_backend_c_string_lossy(backend, name_ptr, 0x200)
                    .unwrap_or_else(|| "<unreadable>".to_string());
                let (handle_ptr, resolved_name, byte_len) = {
                    let mut state = open_state.borrow_mut();
                    let apk_path = state.apk_path.clone();
                    match resolve_palmchat_asset_bytes(&apk_path, &requested_name) {
                        Ok((resolved_name, bytes)) => {
                            let Some(data_ptr) = state.alloc(bytes.len().max(1), 0x10) else {
                                open_shared.borrow_mut().native(&format!(
                                    "asset_shim open requested={} resolved={} mode={} err=arena_exhausted",
                                    requested_name, resolved_name, mode
                                ));
                                let _ = backend.reg_write(UnicornRegisterARM64::X0, 0);
                                let _ = backend.reg_write(UnicornRegisterARM64::PC, lr);
                                return;
                            };
                            let Some(handle_ptr) = state.alloc(0x40, 0x10) else {
                                open_shared.borrow_mut().native(&format!(
                                    "asset_shim open requested={} resolved={} mode={} err=handle_arena_exhausted",
                                    requested_name, resolved_name, mode
                                ));
                                let _ = backend.reg_write(UnicornRegisterARM64::X0, 0);
                                let _ = backend.reg_write(UnicornRegisterARM64::PC, lr);
                                return;
                            };
                            let _ = backend.mem_write(data_ptr, &bytes);
                            let _ = backend.mem_write(handle_ptr, &data_ptr.to_le_bytes());
                            let _ =
                                backend.mem_write(handle_ptr + 8, &(bytes.len() as u64).to_le_bytes());
                            state.open_handles.insert(
                                handle_ptr,
                                PalmchatAAssetHandle {
                                    name: resolved_name.clone(),
                                    handle_ptr,
                                    data_ptr,
                                    len: bytes.len(),
                                    cursor: 0,
                                    bytes,
                                },
                            );
                            (handle_ptr, resolved_name, state.handle(handle_ptr).map(|h| h.len).unwrap_or(0))
                        }
                        Err(err) => {
                            open_shared.borrow_mut().native(&format!(
                                "asset_shim open requested={} mode={} err={:#}",
                                requested_name, mode, err
                            ));
                            let _ = backend.reg_write(UnicornRegisterARM64::X0, 0);
                            let _ = backend.reg_write(UnicornRegisterARM64::PC, lr);
                            return;
                        }
                    }
                };
                open_shared.borrow_mut().native(&format!(
                    "asset_shim open requested={} resolved={} mode={} manager=0x{:x} handle=0x{:x} len={}",
                    requested_name, resolved_name, mode, manager_ptr, handle_ptr, byte_len
                ));
                let _ = backend.reg_write(UnicornRegisterARM64::X0, handle_ptr);
                let _ = backend.reg_write(UnicornRegisterARM64::PC, lr);
            })
            .map_err(|err| anyhow!("failed to install AAssetManager_open shim: {err:?}"))?;
    }

    if let Some(target) = resolve_symbol("AAsset_getBuffer") {
        let buffer_state = asset_state.clone();
        let buffer_shared = shared.clone();
        unicorn
            .add_code_hook(target, target + 4, move |backend, _address, _size| {
                let lr = backend.reg_read(UnicornRegisterARM64::LR).unwrap_or(0);
                let asset_ptr = backend.reg_read(UnicornRegisterARM64::X0).unwrap_or(0);
                let data_ptr = buffer_state
                    .borrow()
                    .handle(asset_ptr)
                    .map(|handle| handle.data_ptr)
                    .unwrap_or(0);
                if data_ptr == 0 {
                    buffer_shared.borrow_mut().native(&format!(
                        "asset_shim getBuffer asset=0x{:x} err=missing_handle",
                        asset_ptr
                    ));
                }
                let _ = backend.reg_write(UnicornRegisterARM64::X0, data_ptr);
                let _ = backend.reg_write(UnicornRegisterARM64::PC, lr);
            })
            .map_err(|err| anyhow!("failed to install AAsset_getBuffer shim: {err:?}"))?;
    }

    for symbol in ["AAsset_getLength64", "AAsset_getLength"] {
        if let Some(target) = resolve_symbol(symbol) {
            let length_state = asset_state.clone();
            let symbol_name = symbol.to_string();
            let length_shared = shared.clone();
            unicorn
                .add_code_hook(target, target + 4, move |backend, _address, _size| {
                    let lr = backend.reg_read(UnicornRegisterARM64::LR).unwrap_or(0);
                    let asset_ptr = backend.reg_read(UnicornRegisterARM64::X0).unwrap_or(0);
                    let len = length_state
                        .borrow()
                        .handle(asset_ptr)
                        .map(|handle| handle.len as u64)
                        .unwrap_or(0);
                    let _ = backend.reg_write(UnicornRegisterARM64::X0, len);
                    let _ = backend.reg_write(UnicornRegisterARM64::PC, lr);
                    if len == 0 {
                        length_shared.borrow_mut().native(&format!(
                            "asset_shim {} asset=0x{:x} err=missing_handle",
                            symbol_name, asset_ptr
                        ));
                    }
                })
                .map_err(|err| anyhow!("failed to install {} shim: {err:?}", symbol))?;
        }
    }

    for symbol in ["AAsset_getRemainingLength64", "AAsset_getRemainingLength"] {
        if let Some(target) = resolve_symbol(symbol) {
            let remaining_state = asset_state.clone();
            unicorn
                .add_code_hook(target, target + 4, move |backend, _address, _size| {
                    let lr = backend.reg_read(UnicornRegisterARM64::LR).unwrap_or(0);
                    let asset_ptr = backend.reg_read(UnicornRegisterARM64::X0).unwrap_or(0);
                    let remaining = remaining_state
                        .borrow()
                        .handle(asset_ptr)
                        .map(|handle| handle.len.saturating_sub(handle.cursor) as u64)
                        .unwrap_or(0);
                    let _ = backend.reg_write(UnicornRegisterARM64::X0, remaining);
                    let _ = backend.reg_write(UnicornRegisterARM64::PC, lr);
                })
                .map_err(|err| anyhow!("failed to install {} shim: {err:?}", symbol))?;
        }
    }

    if let Some(target) = resolve_symbol("AAsset_read") {
        let read_state = asset_state.clone();
        let read_shared = shared.clone();
        unicorn
            .add_code_hook(target, target + 4, move |backend, _address, _size| {
                let lr = backend.reg_read(UnicornRegisterARM64::LR).unwrap_or(0);
                let asset_ptr = backend.reg_read(UnicornRegisterARM64::X0).unwrap_or(0);
                let buf_ptr = backend.reg_read(UnicornRegisterARM64::X1).unwrap_or(0);
                let count = backend.reg_read(UnicornRegisterARM64::X2).unwrap_or(0) as usize;
                let copied = {
                    let mut state = read_state.borrow_mut();
                    let Some(handle) = state.handle_mut(asset_ptr) else {
                        read_shared.borrow_mut().native(&format!(
                            "asset_shim read asset=0x{:x} err=missing_handle",
                            asset_ptr
                        ));
                        let _ = backend.reg_write(UnicornRegisterARM64::X0, u64::MAX);
                        let _ = backend.reg_write(UnicornRegisterARM64::PC, lr);
                        return;
                    };
                    let remaining = handle.len.saturating_sub(handle.cursor);
                    let to_copy = remaining.min(count);
                    if to_copy > 0 && buf_ptr != 0 {
                        let _ = backend.mem_write(
                            buf_ptr,
                            &handle.bytes[handle.cursor..handle.cursor + to_copy],
                        );
                    }
                    handle.cursor += to_copy;
                    to_copy
                };
                let _ = backend.reg_write(UnicornRegisterARM64::X0, copied as u64);
                let _ = backend.reg_write(UnicornRegisterARM64::PC, lr);
            })
            .map_err(|err| anyhow!("failed to install AAsset_read shim: {err:?}"))?;
    }

    if let Some(target) = resolve_symbol("AAsset_close") {
        let close_state = asset_state.clone();
        let close_shared = shared.clone();
        unicorn
            .add_code_hook(target, target + 4, move |backend, _address, _size| {
                let lr = backend.reg_read(UnicornRegisterARM64::LR).unwrap_or(0);
                let asset_ptr = backend.reg_read(UnicornRegisterARM64::X0).unwrap_or(0);
                let removed = close_state.borrow_mut().open_handles.remove(&asset_ptr);
                if let Some(handle) = removed {
                    close_shared.borrow_mut().native(&format!(
                        "asset_shim close asset=0x{:x} resolved={} len={} cursor={}",
                        asset_ptr, handle.name, handle.len, handle.cursor
                    ));
                }
                let _ = backend.reg_write(UnicornRegisterARM64::PC, lr);
            })
            .map_err(|err| anyhow!("failed to install AAsset_close shim: {err:?}"))?;
    }

    Ok(())
}

fn install_unicorn_trace_hooks(
    emulator: &AndroidEmulator<'static, ()>,
    shared: Rc<RefCell<SharedState>>,
    module_base: u64,
    module_size: u64,
    hashkey_fast_global_ref: Option<i64>,
    apk_path: &Path,
    asset_manager_native_ptr: u64,
) -> Result<()> {
    const LIBC_DISPATCH_ONE_OFFSET: u64 = 0x000507b0;
    const LIBC_DISPATCH_TWO_OFFSET: u64 = 0x00050b50;
    const LIBC_RANDOM_OFFSET: u64 = 0x000dbdb0;
    const LIBC_SRANDOM_OFFSET: u64 = 0x000db5c0;
    const LIBC_JE_TSD_PATH_START: u64 = 0x0009912c;
    const LIBC_JE_TSD_PATH_END: u64 = 0x000991a8;
    const JEMALLOC_TSD_STATE_SLOT_OFFSET: u64 = 0x000d8df8;
    const JEMALLOC_TSD_KEYPTR_SLOT_OFFSET: u64 = 0x000d8f98;
    const GET_CK_VERSION_OFFSET: u64 = 0x0a1c30;
    const CK_VERSION_SLOT_SEED_WRITER_OFFSET: u64 = 0x0a18b0;
    const SKEY_AVAILABLE_OFFSET: u64 = 0x0a361c;
    const CREATE_CKEY_OFFSET: u64 = 0x0a3630;
    const CK_VERSION_SLOT_OFFSET: u64 = 0x187a08;
    const SKEY_FLAG_SLOT_OFFSET: u64 = 0x187ae8;
    const CREATE_CKEY_STATE_SLOT_OFFSET: u64 = 0x187af0;
    const RUNTIME_CONTEXT_SLOT_OFFSET: u64 = 0x1897b0;
    const HASHKEY_HELPER_OFFSET: u64 = 0x0a57b0;

    #[cfg(feature = "unicorn")]
    {
        let Backend::Unicorn(unicorn) = &emulator.backend;
        let Some(libc_base) = emulator.find_loaded_module_base("libc.so") else {
            shared
                .borrow_mut()
                .native("unicorn trace hooks skipped reason=libc-not-loaded");
            return Ok(());
        };
        install_palmchat_asset_shim_hooks(
            emulator,
            shared.clone(),
            apk_path,
            asset_manager_native_ptr,
        )?;
        let verbose_cipher_hooks = std::env::var_os("PALMCHAT_TRACE_CIPHER_VERBOSE").is_some();
        let verbose_plt_hooks = std::env::var_os("PALMCHAT_TRACE_PLT_VERBOSE").is_some();
        let verbose_libc_hooks = std::env::var_os("PALMCHAT_TRACE_LIBC_VERBOSE").is_some();
        let verbose_dispatch_hooks = std::env::var_os("PALMCHAT_TRACE_DISPATCH_VERBOSE").is_some();
        let verbose_refresh_hooks = std::env::var_os("PALMCHAT_TRACE_REFRESH_VERBOSE").is_some();

        if let Some(hashkey_ref) = hashkey_fast_global_ref {
            let hashkey_fast_used = Rc::new(RefCell::new(false));
            let hashkey_fast_shared = shared.clone();
            unicorn
                .add_code_hook(
                    module_base + HASHKEY_HELPER_OFFSET,
                    module_base + HASHKEY_HELPER_OFFSET + 4,
                    move |backend, address, _size| {
                        let lr = backend.reg_read(UnicornRegisterARM64::LR).unwrap_or(0);
                        let _ = backend.reg_write(UnicornRegisterARM64::X0, hashkey_ref as u64);
                        let _ = backend.reg_write(UnicornRegisterARM64::PC, lr);
                        let mut used = hashkey_fast_used.borrow_mut();
                        if !*used {
                            *used = true;
                            hashkey_fast_shared.borrow_mut().native(&format!(
                                "unicorn fast hashkey helper used addr=0x{:x} lr=0x{:x} hashkey_ref=0x{:x}",
                                address,
                                lr,
                                hashkey_ref as u64
                            ));
                        }
                    },
                )
                .map_err(|err| anyhow!("failed to install fast hashkey helper hook: {err:?}"))?;
        }

        if verbose_refresh_hooks {
            const LIBANDROID_ASSET_MANAGER_FOR_NDK_SYMBOL: &str =
                "_ZN7android30AssetManagerForNdkAssetManagerEP13AAssetManager";
            const LIBCXX_MUTEX_LOCK_SYMBOL: &str = "_ZNSt3__15mutex4lockEv";
            const LIBC_PTHREAD_MUTEX_LOCK_SYMBOL: &str = "pthread_mutex_lock";
            let refresh_trace_entry = module_base + 0x0a40b0;
            let refresh_trace_active = Rc::new(RefCell::new(false));
            let refresh_trace_active_for_module = refresh_trace_active.clone();
            let refresh_trace_count = Rc::new(RefCell::new(0usize));
            let refresh_trace_shared = shared.clone();
            let mut refresh_external_targets = Vec::<(u64, String)>::new();
            for (slot_offset, label) in [
                (0x182b48_u64, "refresh_slot_182b48"),
                (0x182860_u64, "refresh_slot_182860"),
            ] {
                let slot_addr = module_base + slot_offset;
                let slot_value = unicorn
                    .mem_read_as_vec(slot_addr, 8)
                    .ok()
                    .and_then(|bytes| {
                        bytes
                            .get(0..8)
                            .map(|slice| u64::from_le_bytes(slice.try_into().unwrap()))
                    })
                    .unwrap_or(0);
                shared.borrow_mut().native(&format!(
                    "refresh trace seed slot label={} slot_addr=0x{:x} target=0x{:x}",
                    label, slot_addr, slot_value
                ));
                if slot_value != 0 {
                    refresh_external_targets.push((slot_value, label.to_string()));
                }
            }
            for module_name in [
                "libandroid.so",
                "libandroid_runtime.so",
                "libandroidfw.so",
                "libc++.so",
            ] {
                let base = emulator.find_loaded_module_base(module_name);
                let size = emulator.find_loaded_module_size(module_name);
                shared.borrow_mut().native(&format!(
                    "refresh trace module name={} base={} size={}",
                    module_name,
                    base.map(|value| format!("0x{value:x}"))
                        .unwrap_or_else(|| "none".to_string()),
                    size.map(|value| format!("0x{value:x}"))
                        .unwrap_or_else(|| "none".to_string())
                ));
            }
            let describe_symbol_target = |address: u64| -> String {
                for module_name in [
                    "libandroid.so",
                    "libandroid_runtime.so",
                    "libandroidfw.so",
                    "libc++.so",
                    "libc.so",
                    "libdl.so",
                    "libm.so",
                ] {
                    let Some(base) = emulator.find_loaded_module_base(module_name) else {
                        continue;
                    };
                    let Some(size) = emulator.find_loaded_module_size(module_name) else {
                        continue;
                    };
                    let end = base.saturating_add(size as u64);
                    if base <= address && address < end {
                        return format!(
                            "{}+0x{:x} base=0x{:x} size=0x{:x}",
                            module_name,
                            address.saturating_sub(base),
                            base,
                            size
                        );
                    }
                }
                "unmapped".to_string()
            };
            let asset_manager_for_ndk_target =
                emulator.resolve_loaded_symbol(None, LIBANDROID_ASSET_MANAGER_FOR_NDK_SYMBOL);
            let mutex_lock_target = emulator.resolve_loaded_symbol(None, LIBCXX_MUTEX_LOCK_SYMBOL);
            let pthread_mutex_lock_target =
                emulator.resolve_loaded_symbol(Some("libc.so"), LIBC_PTHREAD_MUTEX_LOCK_SYMBOL);
            for (label, target) in [
                ("asset_manager_for_ndk", asset_manager_for_ndk_target),
                ("mutex_lock", mutex_lock_target),
                ("pthread_mutex_lock", pthread_mutex_lock_target),
            ] {
                shared.borrow_mut().native(&format!(
                    "refresh trace resolved symbol label={} addr={} target={}",
                    label,
                    target
                        .map(|value| format!("0x{value:x}"))
                        .unwrap_or_else(|| "none".to_string()),
                    target
                        .map(|value| describe_symbol_target(value))
                        .unwrap_or_else(|| "unresolved".to_string())
                ));
            }
            unicorn
                .add_code_hook(
                    module_base,
                    module_base + module_size,
                    move |backend, address, size| {
                        let mut active = refresh_trace_active_for_module.borrow_mut();
                        if !*active {
                            if address != refresh_trace_entry {
                                return;
                            }
                            *active = true;
                            refresh_trace_shared.borrow_mut().native(&format!(
                                "unicorn refresh_server_key trace activated entry=0x{:x} module=[0x{:x},0x{:x})",
                                refresh_trace_entry,
                                module_base,
                                module_base + module_size
                            ));
                        }
                        drop(active);
                        let mut count = refresh_trace_count.borrow_mut();
                        if *count >= 1024 {
                            return;
                        }
                        *count += 1;
                        let lr = backend.reg_read(UnicornRegisterARM64::LR).unwrap_or(0);
                        let sp = backend.reg_read(UnicornRegisterARM64::SP).unwrap_or(0);
                        let x0 = backend.reg_read(UnicornRegisterARM64::X0).unwrap_or(0);
                        let x1 = backend.reg_read(UnicornRegisterARM64::X1).unwrap_or(0);
                        let x2 = backend.reg_read(UnicornRegisterARM64::X2).unwrap_or(0);
                        let x3 = backend.reg_read(UnicornRegisterARM64::X3).unwrap_or(0);
                        let x19 = backend.reg_read(UnicornRegisterARM64::X19).unwrap_or(0);
                        let x20 = backend.reg_read(UnicornRegisterARM64::X20).unwrap_or(0);
                        let insn_bytes = backend
                            .mem_read_as_vec(address, size as usize)
                            .ok()
                            .unwrap_or_default();
                        let insn = insn_bytes
                            .get(0..4)
                            .map(|bytes| u32::from_le_bytes(bytes.try_into().unwrap()))
                            .unwrap_or(0);
                        let insn_hex = if insn_bytes.is_empty() {
                            "unreadable".to_string()
                        } else {
                            hex::encode(&insn_bytes)
                        };
                        let branch = decode_arm64_branch_summary(address, insn, backend);
                        refresh_trace_shared.borrow_mut().native(&format!(
                            "unicorn code refresh_server_key addr=0x{:x} size={} insn={} lr=0x{:x} sp=0x{:x} x0=0x{:x} x1=0x{:x} x2=0x{:x} x3=0x{:x} x19=0x{:x} x20=0x{:x}{}",
                            address,
                            size,
                            insn_hex,
                            lr,
                            sp,
                            x0,
                            x1,
                            x2,
                            x3,
                            x19,
                            x20,
                            branch
                                .map(|value| format!(" branch={value}"))
                                .unwrap_or_default()
                        ));
                    },
                )
                .map_err(|err| anyhow!("failed to install refresh_server_key unicorn code hook: {err:?}"))?;

            let refresh_bridge_trace_active = refresh_trace_active.clone();
            let refresh_bridge_trace_count = Rc::new(RefCell::new(0usize));
            let refresh_bridge_trace_shared = shared.clone();
            unicorn
                .add_code_hook(
                    module_base + 0x1a7000,
                    module_base + 0x1a9000,
                    move |backend, address, size| {
                        if !*refresh_bridge_trace_active.borrow() {
                            return;
                        }
                        let mut count = refresh_bridge_trace_count.borrow_mut();
                        if *count >= 256 {
                            return;
                        }
                        *count += 1;
                        let lr = backend.reg_read(UnicornRegisterARM64::LR).unwrap_or(0);
                        let sp = backend.reg_read(UnicornRegisterARM64::SP).unwrap_or(0);
                        let x0 = backend.reg_read(UnicornRegisterARM64::X0).unwrap_or(0);
                        let x1 = backend.reg_read(UnicornRegisterARM64::X1).unwrap_or(0);
                        let x2 = backend.reg_read(UnicornRegisterARM64::X2).unwrap_or(0);
                        let x3 = backend.reg_read(UnicornRegisterARM64::X3).unwrap_or(0);
                        let x16 = backend.reg_read(UnicornRegisterARM64::X16).unwrap_or(0);
                        let x17 = backend.reg_read(UnicornRegisterARM64::X17).unwrap_or(0);
                        let insn_bytes = backend
                            .mem_read_as_vec(address, size as usize)
                            .ok()
                            .unwrap_or_default();
                        let insn = insn_bytes
                            .get(0..4)
                            .map(|bytes| u32::from_le_bytes(bytes.try_into().unwrap()))
                            .unwrap_or(0);
                        let insn_hex = if insn_bytes.is_empty() {
                            "unreadable".to_string()
                        } else {
                            hex::encode(&insn_bytes)
                        };
                        let branch = decode_arm64_branch_summary(address, insn, backend);
                        refresh_bridge_trace_shared.borrow_mut().native(&format!(
                            "unicorn code refresh_external_bridge addr=0x{:x} size={} insn={} lr=0x{:x} sp=0x{:x} x0=0x{:x} x1=0x{:x} x2=0x{:x} x3=0x{:x} x16=0x{:x} x17=0x{:x}{}",
                            address,
                            size,
                            insn_hex,
                            lr,
                            sp,
                            x0,
                            x1,
                            x2,
                            x3,
                            x16,
                            x17,
                            branch
                                .map(|value| format!(" branch={value}"))
                                .unwrap_or_default()
                        ));
                    },
                )
                .map_err(|err| anyhow!("failed to install refresh external bridge hook: {err:?}"))?;

            if let Some(libandroid_base) = emulator.find_loaded_module_base("libandroid.so") {
                let refresh_libandroid_plt_active = refresh_trace_active.clone();
                let refresh_libandroid_plt_count = Rc::new(RefCell::new(0usize));
                let refresh_libandroid_plt_shared = shared.clone();
                unicorn
                    .add_code_hook(
                        libandroid_base + 0x289d0,
                        libandroid_base + 0x28c70,
                        move |backend, address, size| {
                            if !*refresh_libandroid_plt_active.borrow() {
                                return;
                            }
                            let mut count = refresh_libandroid_plt_count.borrow_mut();
                            if *count >= 128 {
                                return;
                            }
                            *count += 1;
                            let lr = backend.reg_read(UnicornRegisterARM64::LR).unwrap_or(0);
                            let sp = backend.reg_read(UnicornRegisterARM64::SP).unwrap_or(0);
                            let x0 = backend.reg_read(UnicornRegisterARM64::X0).unwrap_or(0);
                            let x1 = backend.reg_read(UnicornRegisterARM64::X1).unwrap_or(0);
                            let x2 = backend.reg_read(UnicornRegisterARM64::X2).unwrap_or(0);
                            let x3 = backend.reg_read(UnicornRegisterARM64::X3).unwrap_or(0);
                            let x16 = backend.reg_read(UnicornRegisterARM64::X16).unwrap_or(0);
                            let x17 = backend.reg_read(UnicornRegisterARM64::X17).unwrap_or(0);
                            let insn_bytes = backend
                                .mem_read_as_vec(address, size as usize)
                                .ok()
                                .unwrap_or_default();
                            let insn = insn_bytes
                                .get(0..4)
                                .map(|bytes| u32::from_le_bytes(bytes.try_into().unwrap()))
                                .unwrap_or(0);
                            let insn_hex = if insn_bytes.is_empty() {
                                "unreadable".to_string()
                            } else {
                                hex::encode(&insn_bytes)
                            };
                            let branch = decode_arm64_branch_summary(address, insn, backend);
                            refresh_libandroid_plt_shared.borrow_mut().native(&format!(
                                "unicorn code refresh_libandroid_plt addr=0x{:x} size={} insn={} lr=0x{:x} sp=0x{:x} x0=0x{:x} x1=0x{:x} x2=0x{:x} x3=0x{:x} x16=0x{:x} x17=0x{:x}{}",
                                address,
                                size,
                                insn_hex,
                                lr,
                                sp,
                                x0,
                                x1,
                                x2,
                                x3,
                                x16,
                                x17,
                                branch
                                    .map(|value| format!(" branch={value}"))
                                    .unwrap_or_default()
                            ));
                        },
                    )
                    .map_err(|err| anyhow!("failed to install libandroid plt refresh hook: {err:?}"))?;
            }

            for (target, label, limit, span) in [
                (
                    asset_manager_for_ndk_target,
                    "refresh_asset_manager_for_ndk",
                    64usize,
                    0x80_u64,
                ),
                (mutex_lock_target, "refresh_mutex_lock", 96usize, 0x100_u64),
                (
                    pthread_mutex_lock_target,
                    "refresh_pthread_mutex_lock",
                    128usize,
                    0x120_u64,
                ),
            ] {
                let Some(target) = target else {
                    continue;
                };
                let refresh_symbol_trace_active = refresh_trace_active.clone();
                let refresh_symbol_trace_count = Rc::new(RefCell::new(0usize));
                let refresh_symbol_trace_shared = shared.clone();
                let hook_label = label.to_string();
                unicorn
                    .add_code_hook(
                        target.saturating_sub(0x20),
                        target + span,
                        move |backend, address, size| {
                            if !*refresh_symbol_trace_active.borrow() {
                                return;
                            }
                            let mut count = refresh_symbol_trace_count.borrow_mut();
                            if *count >= limit {
                                return;
                            }
                            *count += 1;
                            let lr = backend.reg_read(UnicornRegisterARM64::LR).unwrap_or(0);
                            let sp = backend.reg_read(UnicornRegisterARM64::SP).unwrap_or(0);
                            let x0 = backend.reg_read(UnicornRegisterARM64::X0).unwrap_or(0);
                            let x1 = backend.reg_read(UnicornRegisterARM64::X1).unwrap_or(0);
                            let x2 = backend.reg_read(UnicornRegisterARM64::X2).unwrap_or(0);
                            let x3 = backend.reg_read(UnicornRegisterARM64::X3).unwrap_or(0);
                            let x16 = backend.reg_read(UnicornRegisterARM64::X16).unwrap_or(0);
                            let x17 = backend.reg_read(UnicornRegisterARM64::X17).unwrap_or(0);
                            let insn_bytes = backend
                                .mem_read_as_vec(address, size as usize)
                                .ok()
                                .unwrap_or_default();
                            let insn = insn_bytes
                                .get(0..4)
                                .map(|bytes| u32::from_le_bytes(bytes.try_into().unwrap()))
                                .unwrap_or(0);
                            let insn_hex = if insn_bytes.is_empty() {
                                "unreadable".to_string()
                            } else {
                                hex::encode(&insn_bytes)
                            };
                            let branch = decode_arm64_branch_summary(address, insn, backend);
                            refresh_symbol_trace_shared.borrow_mut().native(&format!(
                                "unicorn code {} addr=0x{:x} size={} insn={} lr=0x{:x} sp=0x{:x} x0=0x{:x} x1=0x{:x} x2=0x{:x} x3=0x{:x} x16=0x{:x} x17=0x{:x}{}",
                                hook_label,
                                address,
                                size,
                                insn_hex,
                                lr,
                                sp,
                                x0,
                                x1,
                                x2,
                                x3,
                                x16,
                                x17,
                                branch
                                    .map(|value| format!(" branch={value}"))
                                    .unwrap_or_default()
                            ));
                        },
                    )
                    .map_err(|err| anyhow!("failed to install {label} trace hook: {err:?}"))?;
            }

            for (target, label) in refresh_external_targets {
                let refresh_ext_trace_count = Rc::new(RefCell::new(0usize));
                let refresh_ext_trace_shared = shared.clone();
                let hook_label = label.clone();
                unicorn
                    .add_code_hook(
                        target.saturating_sub(0x20),
                        target + 0x100,
                        move |backend, address, size| {
                            let mut count = refresh_ext_trace_count.borrow_mut();
                            if *count >= 128 {
                                return;
                            }
                            *count += 1;
                            let lr = backend.reg_read(UnicornRegisterARM64::LR).unwrap_or(0);
                            let sp = backend.reg_read(UnicornRegisterARM64::SP).unwrap_or(0);
                            let x0 = backend.reg_read(UnicornRegisterARM64::X0).unwrap_or(0);
                            let x1 = backend.reg_read(UnicornRegisterARM64::X1).unwrap_or(0);
                            let x2 = backend.reg_read(UnicornRegisterARM64::X2).unwrap_or(0);
                            let x3 = backend.reg_read(UnicornRegisterARM64::X3).unwrap_or(0);
                            let x16 = backend.reg_read(UnicornRegisterARM64::X16).unwrap_or(0);
                            let x17 = backend.reg_read(UnicornRegisterARM64::X17).unwrap_or(0);
                            let insn_bytes = backend
                                .mem_read_as_vec(address, size as usize)
                                .ok()
                                .unwrap_or_default();
                            let insn = insn_bytes
                                .get(0..4)
                                .map(|bytes| u32::from_le_bytes(bytes.try_into().unwrap()))
                                .unwrap_or(0);
                            let insn_hex = if insn_bytes.is_empty() {
                                "unreadable".to_string()
                            } else {
                                hex::encode(&insn_bytes)
                            };
                            let branch = decode_arm64_branch_summary(address, insn, backend);
                            refresh_ext_trace_shared.borrow_mut().native(&format!(
                                "unicorn code {} addr=0x{:x} size={} insn={} lr=0x{:x} sp=0x{:x} x0=0x{:x} x1=0x{:x} x2=0x{:x} x3=0x{:x} x16=0x{:x} x17=0x{:x}{}",
                                hook_label,
                                address,
                                size,
                                insn_hex,
                                lr,
                                sp,
                                x0,
                                x1,
                                x2,
                                x3,
                                x16,
                                x17,
                                branch
                                    .map(|value| format!(" branch={value}"))
                                    .unwrap_or_default()
                            ));
                        },
                    )
                    .map_err(|err| anyhow!("failed to install {label} unicorn code hook: {err:?}"))?;
            }
        }

        if verbose_dispatch_hooks {
            let palmchat_trace_count = Rc::new(RefCell::new(0usize));
            let palmchat_trace_shared = shared.clone();
            unicorn
                    .add_code_hook(
                        module_base + 0x0a6180,
                        module_base + 0x0a6260,
                        move |backend, address, size| {
                            let mut count = palmchat_trace_count.borrow_mut();
                            if *count >= 96 {
                                return;
                            }
                            *count += 1;
                            let lr = backend.reg_read(UnicornRegisterARM64::LR).unwrap_or(0);
                            let sp = backend.reg_read(UnicornRegisterARM64::SP).unwrap_or(0);
                            let x0 = backend.reg_read(UnicornRegisterARM64::X0).unwrap_or(0);
                            let x19 = backend.reg_read(UnicornRegisterARM64::X19).unwrap_or(0);
                            let x20 = backend.reg_read(UnicornRegisterARM64::X20).unwrap_or(0);
                            palmchat_trace_shared.borrow_mut().native(&format!(
                                "unicorn code palmchat addr=0x{:x} size={} lr=0x{:x} sp=0x{:x} x0=0x{:x} x19=0x{:x} x20=0x{:x}",
                                address, size, lr, sp, x0, x19, x20
                            ));
                        },
                    )
                    .map_err(|err| anyhow!("failed to install palmchat unicorn code hook: {err:?}"))?;
        }

        let create_ckey_trace_count = Rc::new(RefCell::new(0usize));
        let create_ckey_trace_shared = shared.clone();
        unicorn
                .add_code_hook(
                    module_base + 0x0a3600,
                    module_base + 0x0a3900,
                    move |backend, address, size| {
                        let mut count = create_ckey_trace_count.borrow_mut();
                        if *count >= 192 {
                            return;
                        }
                        *count += 1;
                        let lr = backend.reg_read(UnicornRegisterARM64::LR).unwrap_or(0);
                        let sp = backend.reg_read(UnicornRegisterARM64::SP).unwrap_or(0);
                        let x0 = backend.reg_read(UnicornRegisterARM64::X0).unwrap_or(0);
                        let x1 = backend.reg_read(UnicornRegisterARM64::X1).unwrap_or(0);
                        let x2 = backend.reg_read(UnicornRegisterARM64::X2).unwrap_or(0);
                        let x16 = backend.reg_read(UnicornRegisterARM64::X16).unwrap_or(0);
                        let x17 = backend.reg_read(UnicornRegisterARM64::X17).unwrap_or(0);
                        create_ckey_trace_shared.borrow_mut().native(&format!(
                            "unicorn code encryptutils_head addr=0x{:x} size={} lr=0x{:x} sp=0x{:x} x0=0x{:x} x1=0x{:x} x2=0x{:x} x16=0x{:x} x17=0x{:x}",
                            address, size, lr, sp, x0, x1, x2, x16, x17
                        ));
                    },
                )
                .map_err(|err| anyhow!("failed to install encryptutils_head unicorn code hook: {err:?}"))?;

        let skey_reader_trace_count = Rc::new(RefCell::new(0usize));
        let skey_reader_trace_shared = shared.clone();
        unicorn
                .add_code_hook(
                    module_base + SKEY_AVAILABLE_OFFSET,
                    // Stop one instruction before the next known JNI entrypoint so we stay
                    // inside skeyAvailable's reader stub and do not spill into createCKey.
                    module_base + CREATE_CKEY_OFFSET - 4,
                    move |backend, address, size| {
                        let mut count = skey_reader_trace_count.borrow_mut();
                        if *count >= 32 {
                            return;
                        }
                        *count += 1;
                        let lr = backend.reg_read(UnicornRegisterARM64::LR).unwrap_or(0);
                        let sp = backend.reg_read(UnicornRegisterARM64::SP).unwrap_or(0);
                        let x0 = backend.reg_read(UnicornRegisterARM64::X0).unwrap_or(0);
                        let x1 = backend.reg_read(UnicornRegisterARM64::X1).unwrap_or(0);
                        let x2 = backend.reg_read(UnicornRegisterARM64::X2).unwrap_or(0);
                        let x3 = backend.reg_read(UnicornRegisterARM64::X3).unwrap_or(0);
                        let x8 = backend.reg_read(UnicornRegisterARM64::X8).unwrap_or(0);
                        let x19 = backend.reg_read(UnicornRegisterARM64::X19).unwrap_or(0);
                        let x20 = backend.reg_read(UnicornRegisterARM64::X20).unwrap_or(0);
                        let insn = backend
                            .mem_read_as_vec(address, size as usize)
                            .ok()
                            .map(hex::encode)
                            .unwrap_or_else(|| "unreadable".to_string());
                        let state_slot_addr = module_base + CREATE_CKEY_STATE_SLOT_OFFSET;
                        let state_ptr = backend
                            .mem_read_as_vec(state_slot_addr, 8)
                            .ok()
                            .and_then(|bytes| {
                                bytes
                                    .get(0..8)
                                    .map(|slice| u64::from_le_bytes(slice.try_into().unwrap()))
                            })
                            .unwrap_or(0);
                        let state_head = if state_ptr == 0 {
                            "null".to_string()
                        } else {
                            backend
                                .mem_read_as_vec(state_ptr, 0x20)
                                .ok()
                                .map(hex::encode)
                                .unwrap_or_else(|| "unreadable".to_string())
                        };
                        let runtime_slot_addr = module_base + RUNTIME_CONTEXT_SLOT_OFFSET;
                        let runtime_ptr = backend
                            .mem_read_as_vec(runtime_slot_addr, 8)
                            .ok()
                            .and_then(|bytes| {
                                bytes
                                    .get(0..8)
                                    .map(|slice| u64::from_le_bytes(slice.try_into().unwrap()))
                            })
                            .unwrap_or(0);
                        let runtime_head = if runtime_ptr == 0 {
                            "null".to_string()
                        } else {
                            backend
                                .mem_read_as_vec(runtime_ptr, 0x20)
                                .ok()
                                .map(hex::encode)
                                .unwrap_or_else(|| "unreadable".to_string())
                        };
                        let x8_head = if x8 == 0 {
                            "null".to_string()
                        } else {
                            backend
                                .mem_read_as_vec(x8, 0x20)
                                .ok()
                                .map(hex::encode)
                                .unwrap_or_else(|| "unreadable".to_string())
                        };
                        skey_reader_trace_shared.borrow_mut().native(&format!(
                            "unicorn code skey_available_reader addr=0x{:x} size={} insn={} lr=0x{:x} sp=0x{:x} x0=0x{:x} x1=0x{:x} x2=0x{:x} x3=0x{:x} x8=0x{:x} x8_head={} x19=0x{:x} x20=0x{:x} state_slot=0x{:x}->0x{:x} state_head={} runtime_slot=0x{:x}->0x{:x} runtime_head={}",
                            address,
                            size,
                            insn,
                            lr,
                            sp,
                            x0,
                            x1,
                            x2,
                            x3,
                            x8,
                            x8_head,
                            x19,
                            x20,
                            state_slot_addr,
                            state_ptr,
                            state_head,
                            runtime_slot_addr,
                            runtime_ptr,
                            runtime_head,
                        ));
                    },
                )
                .map_err(|err| anyhow!("failed to install skeyAvailable reader unicorn hook: {err:?}"))?;

        let ck_version_reader_trace_count = Rc::new(RefCell::new(0usize));
        let ck_version_reader_trace_shared = shared.clone();
        unicorn
                .add_code_hook(
                    module_base + GET_CK_VERSION_OFFSET,
                    // Runtime head bytes show getCkVersion starts with adrp/ldr/ret and a
                    // fresh adrp immediately after that. Keep the probe on the first three
                    // instructions so we observe the real reader without crossing into the
                    // next stub.
                    module_base + GET_CK_VERSION_OFFSET + 0x08,
                    move |backend, address, size| {
                        let mut count = ck_version_reader_trace_count.borrow_mut();
                        if *count >= 24 {
                            return;
                        }
                        *count += 1;
                        let lr = backend.reg_read(UnicornRegisterARM64::LR).unwrap_or(0);
                        let sp = backend.reg_read(UnicornRegisterARM64::SP).unwrap_or(0);
                        let x0 = backend.reg_read(UnicornRegisterARM64::X0).unwrap_or(0);
                        let x1 = backend.reg_read(UnicornRegisterARM64::X1).unwrap_or(0);
                        let x2 = backend.reg_read(UnicornRegisterARM64::X2).unwrap_or(0);
                        let x3 = backend.reg_read(UnicornRegisterARM64::X3).unwrap_or(0);
                        let x8 = backend.reg_read(UnicornRegisterARM64::X8).unwrap_or(0);
                        let x19 = backend.reg_read(UnicornRegisterARM64::X19).unwrap_or(0);
                        let x20 = backend.reg_read(UnicornRegisterARM64::X20).unwrap_or(0);
                        let insn = backend
                            .mem_read_as_vec(address, size as usize)
                            .ok()
                            .map(hex::encode)
                            .unwrap_or_else(|| "unreadable".to_string());
                        let state_slot_addr = module_base + CREATE_CKEY_STATE_SLOT_OFFSET;
                        let state_ptr = backend
                            .mem_read_as_vec(state_slot_addr, 8)
                            .ok()
                            .and_then(|bytes| {
                                bytes
                                    .get(0..8)
                                    .map(|slice| u64::from_le_bytes(slice.try_into().unwrap()))
                            })
                            .unwrap_or(0);
                        let state_head = if state_ptr == 0 {
                            "null".to_string()
                        } else {
                            backend
                                .mem_read_as_vec(state_ptr, 0x20)
                                .ok()
                                .map(hex::encode)
                                .unwrap_or_else(|| "unreadable".to_string())
                        };
                        let runtime_slot_addr = module_base + RUNTIME_CONTEXT_SLOT_OFFSET;
                        let runtime_ptr = backend
                            .mem_read_as_vec(runtime_slot_addr, 8)
                            .ok()
                            .and_then(|bytes| {
                                bytes
                                    .get(0..8)
                                    .map(|slice| u64::from_le_bytes(slice.try_into().unwrap()))
                            })
                            .unwrap_or(0);
                        let runtime_head = if runtime_ptr == 0 {
                            "null".to_string()
                        } else {
                            backend
                                .mem_read_as_vec(runtime_ptr, 0x20)
                                .ok()
                                .map(hex::encode)
                                .unwrap_or_else(|| "unreadable".to_string())
                        };
                        let x8_head = if x8 == 0 {
                            "null".to_string()
                        } else {
                            backend
                                .mem_read_as_vec(x8, 0x20)
                                .ok()
                                .map(hex::encode)
                                .unwrap_or_else(|| "unreadable".to_string())
                        };
                        ck_version_reader_trace_shared.borrow_mut().native(&format!(
                            "unicorn code ck_version_reader addr=0x{:x} size={} insn={} lr=0x{:x} sp=0x{:x} x0=0x{:x} x1=0x{:x} x2=0x{:x} x3=0x{:x} x8=0x{:x} x8_head={} x19=0x{:x} x20=0x{:x} state_slot=0x{:x}->0x{:x} state_head={} runtime_slot=0x{:x}->0x{:x} runtime_head={}",
                            address,
                            size,
                            insn,
                            lr,
                            sp,
                            x0,
                            x1,
                            x2,
                            x3,
                            x8,
                            x8_head,
                            x19,
                            x20,
                            state_slot_addr,
                            state_ptr,
                            state_head,
                            runtime_slot_addr,
                            runtime_ptr,
                            runtime_head,
                        ));
                    },
                )
                .map_err(|err| anyhow!("failed to install getCkVersion reader unicorn hook: {err:?}"))?;

        for (label, slot_offset) in [
            ("ck_version_slot_write", CK_VERSION_SLOT_OFFSET),
            ("skey_flag_slot_write", SKEY_FLAG_SLOT_OFFSET),
        ] {
            let slot_addr = module_base + slot_offset;
            let slot_write_count = Rc::new(RefCell::new(0usize));
            let slot_write_shared = shared.clone();
            unicorn
                .add_mem_hook(
                    HookType::MEM_WRITE,
                    slot_addr,
                    slot_addr + 0x7,
                    move |backend, _mem_type, addr, size, value| {
                        let mut count = slot_write_count.borrow_mut();
                        if *count >= 32 {
                            return true;
                        }
                        *count += 1;
                        let pc = backend.reg_read(UnicornRegisterARM64::PC).unwrap_or(0);
                        let lr = backend.reg_read(UnicornRegisterARM64::LR).unwrap_or(0);
                        let sp = backend.reg_read(UnicornRegisterARM64::SP).unwrap_or(0);
                        let x0 = backend.reg_read(UnicornRegisterARM64::X0).unwrap_or(0);
                        let x1 = backend.reg_read(UnicornRegisterARM64::X1).unwrap_or(0);
                        let x2 = backend.reg_read(UnicornRegisterARM64::X2).unwrap_or(0);
                        let x3 = backend.reg_read(UnicornRegisterARM64::X3).unwrap_or(0);
                        let x8 = backend.reg_read(UnicornRegisterARM64::X8).unwrap_or(0);
                        let post8 = backend
                            .mem_read_as_vec(slot_addr, 8)
                            .ok()
                            .map(hex::encode)
                            .unwrap_or_else(|| "unreadable".to_string());
                        slot_write_shared.borrow_mut().native(&format!(
                            "unicorn mem {} slot=0x{:x} write_addr=0x{:x} size={} value=0x{:x} pc=0x{:x} lr=0x{:x} sp=0x{:x} x0=0x{:x} x1=0x{:x} x2=0x{:x} x3=0x{:x} x8=0x{:x} slot_prewrite_head={}",
                            label,
                            slot_addr,
                            addr,
                            size,
                            value as u64,
                            pc,
                            lr,
                            sp,
                            x0,
                            x1,
                            x2,
                            x3,
                            x8,
                            post8,
                        ));
                        true
                    },
                )
                .map_err(|err| anyhow!("failed to install {label} unicorn mem hook: {err:?}"))?;
        }

        let ck_version_seed_trace_count = Rc::new(RefCell::new(0usize));
        let ck_version_seed_trace_shared = shared.clone();
        unicorn
            .add_code_hook(
                module_base + CK_VERSION_SLOT_SEED_WRITER_OFFSET,
                module_base + CK_VERSION_SLOT_SEED_WRITER_OFFSET + 0x3c,
                move |backend, address, size| {
                    let mut count = ck_version_seed_trace_count.borrow_mut();
                    if *count >= 64 {
                        return;
                    }
                    *count += 1;
                    let lr = backend.reg_read(UnicornRegisterARM64::LR).unwrap_or(0);
                    let sp = backend.reg_read(UnicornRegisterARM64::SP).unwrap_or(0);
                    let x0 = backend.reg_read(UnicornRegisterARM64::X0).unwrap_or(0);
                    let x1 = backend.reg_read(UnicornRegisterARM64::X1).unwrap_or(0);
                    let x2 = backend.reg_read(UnicornRegisterARM64::X2).unwrap_or(0);
                    let x3 = backend.reg_read(UnicornRegisterARM64::X3).unwrap_or(0);
                    let x8 = backend.reg_read(UnicornRegisterARM64::X8).unwrap_or(0);
                    let x19 = backend.reg_read(UnicornRegisterARM64::X19).unwrap_or(0);
                    let x20 = backend.reg_read(UnicornRegisterARM64::X20).unwrap_or(0);
                    let insn = backend
                        .mem_read_as_vec(address, size as usize)
                        .ok()
                        .map(hex::encode)
                        .unwrap_or_else(|| "unreadable".to_string());
                    let slot_addr = module_base + CK_VERSION_SLOT_OFFSET;
                    let slot_head = backend
                        .mem_read_as_vec(slot_addr, 8)
                        .ok()
                        .map(hex::encode)
                        .unwrap_or_else(|| "unreadable".to_string());
                    ck_version_seed_trace_shared.borrow_mut().native(&format!(
                        "unicorn code ck_version_slot_seed_writer addr=0x{:x} size={} insn={} lr=0x{:x} sp=0x{:x} x0=0x{:x} x1=0x{:x} x2=0x{:x} x3=0x{:x} x8=0x{:x} x19=0x{:x} x20=0x{:x} ck_version_slot=0x{:x} slot_head={}",
                        address,
                        size,
                        insn,
                        lr,
                        sp,
                        x0,
                        x1,
                        x2,
                        x3,
                        x8,
                        x19,
                        x20,
                        slot_addr,
                        slot_head,
                    ));
                },
            )
            .map_err(|err| anyhow!("failed to install ck_version slot seed writer unicorn hook: {err:?}"))?;

        if verbose_cipher_hooks {
            let cipher_trace_count = Rc::new(RefCell::new(0usize));
            let cipher_trace_histogram = Rc::new(RefCell::new(HashMap::<u64, usize>::new()));
            let cipher_trace_shared = shared.clone();
            unicorn
                .add_code_hook(
                    module_base + 0x0a5df4,
                    module_base + 0x0a7000,
                    move |backend, address, size| {
                        let histogram = cipher_trace_histogram.clone();
                        let mut count = cipher_trace_count.borrow_mut();
                        *count += 1;
                        let lr = backend.reg_read(UnicornRegisterARM64::LR).unwrap_or(0);
                        let sp = backend.reg_read(UnicornRegisterARM64::SP).unwrap_or(0);
                        let x0 = backend.reg_read(UnicornRegisterARM64::X0).unwrap_or(0);
                        let x1 = backend.reg_read(UnicornRegisterARM64::X1).unwrap_or(0);
                        let x2 = backend.reg_read(UnicornRegisterARM64::X2).unwrap_or(0);
                        let x3 = backend.reg_read(UnicornRegisterARM64::X3).unwrap_or(0);
                        let x19 = backend.reg_read(UnicornRegisterARM64::X19).unwrap_or(0);
                        let x20 = backend.reg_read(UnicornRegisterARM64::X20).unwrap_or(0);
                        if *count <= 256 {
                            cipher_trace_shared.borrow_mut().native(&format!(
                                "unicorn code encryptutils_body addr=0x{:x} size={} lr=0x{:x} sp=0x{:x} x0=0x{:x} x1=0x{:x} x2=0x{:x} x3=0x{:x} x19=0x{:x} x20=0x{:x}",
                                address, size, lr, sp, x0, x1, x2, x3, x19, x20
                            ));
                        }
                        let mut histogram = histogram.borrow_mut();
                        let slot = histogram.entry(address).or_insert(0);
                        *slot += 1;
                        let total_hits = *count;
                        if total_hits % 4096 == 0 {
                            let mut top = histogram
                                .iter()
                                .map(|(pc, hits)| (*pc, *hits))
                                .collect::<Vec<(u64, usize)>>();
                            top.sort_unstable_by(|a, b| b.1.cmp(&a.1).then_with(|| a.0.cmp(&b.0)));
                            let top_summary = top
                                .into_iter()
                                .take(6)
                                .map(|(pc, hits)| format!("0x{pc:x}:{hits}"))
                                .collect::<Vec<String>>()
                                .join(",");
                            cipher_trace_shared.borrow_mut().native(&format!(
                                "unicorn encryptutils_body hotspot total_hits={} current=0x{:x} top=[{}]",
                                total_hits, address, top_summary
                            ));
                        }
                    },
                )
                .map_err(|err| anyhow!("failed to install encryptutils_body unicorn code hook: {err:?}"))?;

            let cipher_helper_trace_count = Rc::new(RefCell::new(0usize));
            let cipher_helper_trace_histogram = Rc::new(RefCell::new(HashMap::<u64, usize>::new()));
            let cipher_source_trace_count = Rc::new(RefCell::new(0usize));
            let cipher_helper_trace_shared = shared.clone();
            unicorn
                .add_code_hook(
                    module_base + 0x0a57b0,
                    module_base + 0x0a59a8,
                    move |backend, address, size| {
                        let histogram = cipher_helper_trace_histogram.clone();
                        let source_trace_count = cipher_source_trace_count.clone();
                        let mut count = cipher_helper_trace_count.borrow_mut();
                        *count += 1;
                        let lr = backend.reg_read(UnicornRegisterARM64::LR).unwrap_or(0);
                        let sp = backend.reg_read(UnicornRegisterARM64::SP).unwrap_or(0);
                        let x0 = backend.reg_read(UnicornRegisterARM64::X0).unwrap_or(0);
                        let x1 = backend.reg_read(UnicornRegisterARM64::X1).unwrap_or(0);
                        let x2 = backend.reg_read(UnicornRegisterARM64::X2).unwrap_or(0);
                        let x3 = backend.reg_read(UnicornRegisterARM64::X3).unwrap_or(0);
                        let x19 = backend.reg_read(UnicornRegisterARM64::X19).unwrap_or(0);
                        let x20 = backend.reg_read(UnicornRegisterARM64::X20).unwrap_or(0);
                        let x21 = backend.reg_read(UnicornRegisterARM64::X21).unwrap_or(0);
                        let x22 = backend.reg_read(UnicornRegisterARM64::X22).unwrap_or(0);
                        let x23 = backend.reg_read(UnicornRegisterARM64::X23).unwrap_or(0);
                        if *count <= 384 {
                            cipher_helper_trace_shared.borrow_mut().native(&format!(
                                "unicorn code cipher_helper addr=0x{:x} size={} lr=0x{:x} sp=0x{:x} x0=0x{:x} x1=0x{:x} x2=0x{:x} x3=0x{:x} x19=0x{:x} x20=0x{:x} x21=0x{:x} x22=0x{:x} x23=0x{:x}",
                                address, size, lr, sp, x0, x1, x2, x3, x19, x20, x21, x22, x23
                            ));
                        }
                        if (address == module_base + 0x0a5814 || address == module_base + 0x0a5818)
                            && x22 != 0
                        {
                            let mut source_count = source_trace_count.borrow_mut();
                            if *source_count < 8 {
                                *source_count += 1;
                                let file_head_bytes =
                                    backend.mem_read_as_vec(x22, 0x40).unwrap_or_default();
                                let file_head = if file_head_bytes.is_empty() {
                                    "unreadable".to_string()
                                } else {
                                    hex::encode(&file_head_bytes)
                                };
                                let primary_ptr = file_head_bytes
                                    .get(0..8)
                                    .map(|slice| u64::from_le_bytes(slice.try_into().unwrap()))
                                    .unwrap_or(0);
                                let backup_ptr = file_head_bytes
                                    .get(24..32)
                                    .map(|slice| u64::from_le_bytes(slice.try_into().unwrap()))
                                    .unwrap_or(0);
                                let primary_head = if primary_ptr != 0 {
                                    backend
                                        .mem_read_as_vec(primary_ptr, 0x20)
                                        .ok()
                                        .map(hex::encode)
                                        .unwrap_or_else(|| "unreadable".to_string())
                                } else {
                                    "null".to_string()
                                };
                                let backup_head = if backup_ptr != 0 {
                                    backend
                                        .mem_read_as_vec(backup_ptr, 0x20)
                                        .ok()
                                        .map(hex::encode)
                                        .unwrap_or_else(|| "unreadable".to_string())
                                } else {
                                    "null".to_string()
                                };
                                cipher_helper_trace_shared.borrow_mut().native(&format!(
                                    "unicorn cipher_source addr=0x{:x} iter={} file_ptr=0x{:x} file_head={} primary_ptr=0x{:x} primary_head={} backup_ptr=0x{:x} backup_head={}",
                                    address,
                                    *source_count,
                                    x22,
                                    file_head,
                                    primary_ptr,
                                    primary_head,
                                    backup_ptr,
                                    backup_head
                                ));
                            }
                        }
                        if address == module_base + 0x0a5848 && x22 != 0 {
                            let mut source_count = source_trace_count.borrow_mut();
                            if *source_count < 16 {
                                *source_count += 1;
                                let file_head_bytes =
                                    backend.mem_read_as_vec(x22, 0x80).unwrap_or_default();
                                let file_head = if file_head_bytes.is_empty() {
                                    "unreadable".to_string()
                                } else {
                                    hex::encode(&file_head_bytes)
                                };
                                let primary_ptr = file_head_bytes
                                    .get(0..8)
                                    .map(|slice| u64::from_le_bytes(slice.try_into().unwrap()))
                                    .unwrap_or(0);
                                let backup_ptr = file_head_bytes
                                    .get(24..32)
                                    .map(|slice| u64::from_le_bytes(slice.try_into().unwrap()))
                                    .unwrap_or(0);
                                let primary_head = if primary_ptr != 0 {
                                    backend
                                        .mem_read_as_vec(primary_ptr, 0x40)
                                        .ok()
                                        .map(hex::encode)
                                        .unwrap_or_else(|| "unreadable".to_string())
                                } else {
                                    "null".to_string()
                                };
                                let backup_head = if backup_ptr != 0 {
                                    backend
                                        .mem_read_as_vec(backup_ptr, 0x40)
                                        .ok()
                                        .map(hex::encode)
                                        .unwrap_or_else(|| "unreadable".to_string())
                                } else {
                                    "null".to_string()
                                };
                                let chunk_addr = sp.saturating_add(0x138);
                                let chunk_head = backend
                                    .mem_read_as_vec(chunk_addr, 0x40)
                                    .ok()
                                    .map(hex::encode)
                                    .unwrap_or_else(|| "unreadable".to_string());
                                cipher_helper_trace_shared.borrow_mut().native(&format!(
                                    "unicorn cipher_after_fread addr=0x{:x} iter={} file_ptr=0x{:x} fread_ret=0x{:x} chunk_addr=0x{:x} chunk_head={} file_head={} primary_ptr=0x{:x} primary_head={} backup_ptr=0x{:x} backup_head={}",
                                    address,
                                    *source_count,
                                    x22,
                                    x0,
                                    chunk_addr,
                                    chunk_head,
                                    file_head,
                                    primary_ptr,
                                    primary_head,
                                    backup_ptr,
                                    backup_head
                                ));
                            }
                        }
                        let mut histogram = histogram.borrow_mut();
                        let slot = histogram.entry(address).or_insert(0);
                        *slot += 1;
                        let total_hits = *count;
                        if total_hits % 2048 == 0 {
                            let mut top = histogram
                                .iter()
                                .map(|(pc, hits)| (*pc, *hits))
                                .collect::<Vec<(u64, usize)>>();
                            top.sort_unstable_by(|a, b| b.1.cmp(&a.1).then_with(|| a.0.cmp(&b.0)));
                            let top_summary = top
                                .into_iter()
                                .take(8)
                                .map(|(pc, hits)| format!("0x{pc:x}:{hits}"))
                                .collect::<Vec<String>>()
                                .join(",");
                            cipher_helper_trace_shared.borrow_mut().native(&format!(
                                "unicorn cipher_helper hotspot total_hits={} current=0x{:x} top=[{}]",
                                total_hits, address, top_summary
                            ));
                        }
                    },
                )
                .map_err(|err| anyhow!("failed to install cipher helper unicorn code hook: {err:?}"))?;

            let cipher_loop_trace_count = Rc::new(RefCell::new(0usize));
            let cipher_loop_trace_shared = shared.clone();
            unicorn
                .add_code_hook(
                    module_base + 0x0a585c,
                    module_base + 0x0a5864,
                    move |backend, address, size| {
                        let mut count = cipher_loop_trace_count.borrow_mut();
                        *count += 1;
                        let log_now = *count <= 32 || (*count % 1024 == 0);
                        if !log_now {
                            return;
                        }
                        let sp = backend.reg_read(UnicornRegisterARM64::SP).unwrap_or(0);
                        let lr = backend.reg_read(UnicornRegisterARM64::LR).unwrap_or(0);
                        let x22 = backend.reg_read(UnicornRegisterARM64::X22).unwrap_or(0);
                        let x23 = backend.reg_read(UnicornRegisterARM64::X23).unwrap_or(0);
                        let source_head = if x22 != 0 {
                            backend
                                .mem_read_as_vec(x22, 0x20)
                                .ok()
                                .map(hex::encode)
                                .unwrap_or_else(|| "unreadable".to_string())
                        } else {
                            "null".to_string()
                        };
                        let chunk_addr = sp.saturating_add(0x138);
                        let chunk_head = if chunk_addr != 0 {
                            backend
                                .mem_read_as_vec(chunk_addr, 0x20)
                                .ok()
                                .map(hex::encode)
                                .unwrap_or_else(|| "unreadable".to_string())
                        } else {
                            "null".to_string()
                        };
                        cipher_loop_trace_shared.borrow_mut().native(&format!(
                            "unicorn cipher_loop addr=0x{:x} size={} iter={} lr=0x{:x} sp=0x{:x} x22=0x{:x} x23=0x{:x} source_head={} chunk_head={}",
                            address,
                            size,
                            *count,
                            lr,
                            sp,
                            x22,
                            x23,
                            source_head,
                            chunk_head
                        ));
                    },
                )
                .map_err(|err| anyhow!("failed to install cipher loop hook: {err:?}"))?;
        }

        if verbose_plt_hooks {
            for (stub_offset, slot_offset, label) in [
                (0x04dbc0_u64, 0x1826c0_u64, "plt_4dbc0"),
                (0x04dbf0_u64, 0x1826d8_u64, "plt_4dbf0"),
                (0x04efe0_u64, 0x182748_u64, "plt_4efe0"),
                (0x04fef0_u64, 0x183858_u64, "plt_4fef0"),
                (0x04fc20_u64, 0x1836f0_u64, "plt_4fc20"),
                (0x04fc30_u64, 0x1835a0_u64, "plt_4fc30"),
                (0x04fc80_u64, 0x183720_u64, "plt_4fc80"),
                (0x050060_u64, 0x183910_u64, "plt_50060"),
                (0x0528a0_u64, 0x184d30_u64, "plt_528a0"),
                (0x051970_u64, 0x183238_u64, "plt_51970"),
                (0x052010_u64, 0x1848e8_u64, "plt_52010"),
                (0x052240_u64, 0x184b20_u64, "plt_52240"),
                (0x052660_u64, 0x185c10_u64, "plt_52660"),
                (0x052a80_u64, 0x184e20_u64, "plt_52a80"),
                (0x050ae0_u64, 0x183e50_u64, "plt_50ae0"),
            ] {
                let plt_trace_count = Rc::new(RefCell::new(0usize));
                let plt_trace_shared = shared.clone();
                unicorn
                        .add_code_hook(
                            module_base + stub_offset,
                            module_base + stub_offset + 4,
                            move |backend, address, size| {
                                let mut count = plt_trace_count.borrow_mut();
                                if *count >= 96 {
                                    return;
                                }
                                *count += 1;
                                let lr = backend.reg_read(UnicornRegisterARM64::LR).unwrap_or(0);
                                let sp = backend.reg_read(UnicornRegisterARM64::SP).unwrap_or(0);
                                let x0 = backend.reg_read(UnicornRegisterARM64::X0).unwrap_or(0);
                                let x1 = backend.reg_read(UnicornRegisterARM64::X1).unwrap_or(0);
                                let x2 = backend.reg_read(UnicornRegisterARM64::X2).unwrap_or(0);
                                let x3 = backend.reg_read(UnicornRegisterARM64::X3).unwrap_or(0);
                                let decoded_slot_addr = backend
                                    .mem_read_as_vec(module_base + stub_offset, 12)
                                    .ok()
                                    .and_then(|bytes| {
                                        decode_plt_slot_from_stub_bytes(module_base + stub_offset, &bytes)
                                    });
                                let slot_addr = decoded_slot_addr.unwrap_or(module_base + slot_offset);
                                let slot_value = backend
                                    .mem_read_as_vec(slot_addr, 8)
                                    .ok()
                                    .and_then(|bytes| {
                                        bytes.get(0..8).map(|slice| {
                                            u64::from_le_bytes(slice.try_into().unwrap())
                                        })
                                    })
                                    .unwrap_or(0);
                                let mut extra = String::new();
                                if label == "plt_4dbc0" {
                                    let path = backend
                                        .mem_read_as_vec(x0, 0x200)
                                        .ok()
                                        .map(|bytes| {
                                            let nul = bytes
                                                .iter()
                                                .position(|byte| *byte == 0)
                                                .unwrap_or(bytes.len());
                                            String::from_utf8_lossy(&bytes[..nul]).into_owned()
                                        })
                                        .unwrap_or_else(|| "<unreadable>".to_string());
                                    let mode = backend
                                        .mem_read_as_vec(x1, 0x40)
                                        .ok()
                                        .map(|bytes| {
                                            let nul = bytes
                                                .iter()
                                                .position(|byte| *byte == 0)
                                                .unwrap_or(bytes.len());
                                            String::from_utf8_lossy(&bytes[..nul]).into_owned()
                                        })
                                        .unwrap_or_else(|| "<unreadable>".to_string());
                                    extra = format!(" path={:?} mode={:?}", path, mode);
                                } else if label == "plt_4efe0" {
                                    let stream_head = backend
                                        .mem_read_as_vec(x3, 0x20)
                                        .ok()
                                        .map(hex::encode)
                                        .unwrap_or_else(|| "unreadable".to_string());
                                    extra = format!(
                                        " fread_size=0x{:x} fread_nmemb=0x{:x} stream=0x{:x} stream_head={}",
                                        x1, x2, x3, stream_head
                                    );
                                }
                                plt_trace_shared.borrow_mut().native(&format!(
                                    "unicorn code {} addr=0x{:x} size={} lr=0x{:x} sp=0x{:x} x0=0x{:x} x1=0x{:x} x2=0x{:x} x3=0x{:x} slot=0x{:x} target=0x{:x}{}",
                                    label,
                                    address,
                                    size,
                                    lr,
                                    sp,
                                    x0,
                                    x1,
                                    x2,
                                    x3,
                                    slot_addr,
                                    slot_value,
                                    extra,
                                ));
                            },
                        )
                        .map_err(|err| anyhow!("failed to install {label} unicorn hook: {err:?}"))?;
            }
        }

        if verbose_dispatch_hooks {
            let palmchat_dispatch_trace_count = Rc::new(RefCell::new(0usize));
            let palmchat_dispatch_trace_shared = shared.clone();
            unicorn
                    .add_code_hook(
                        module_base + 0x0b1938,
                        module_base + 0x0b1988,
                        move |backend, address, size| {
                            let mut count = palmchat_dispatch_trace_count.borrow_mut();
                            if *count >= 64 {
                                return;
                            }
                            *count += 1;
                            let lr = backend.reg_read(UnicornRegisterARM64::LR).unwrap_or(0);
                            let sp = backend.reg_read(UnicornRegisterARM64::SP).unwrap_or(0);
                            let x0 = backend.reg_read(UnicornRegisterARM64::X0).unwrap_or(0);
                            let x1 = backend.reg_read(UnicornRegisterARM64::X1).unwrap_or(0);
                            let x19 = backend.reg_read(UnicornRegisterARM64::X19).unwrap_or(0);
                            palmchat_dispatch_trace_shared.borrow_mut().native(&format!(
                                "unicorn code palmchat_dispatch addr=0x{:x} size={} lr=0x{:x} sp=0x{:x} x0=0x{:x} x1=0x{:x} x19=0x{:x}",
                                address, size, lr, sp, x0, x1, x19
                            ));
                        },
                    )
                    .map_err(|err| anyhow!("failed to install palmchat dispatch hook: {err:?}"))?;
        }

        if verbose_libc_hooks {
            let libc_trace_count = Rc::new(RefCell::new(0usize));
            let libc_trace_shared = shared.clone();
            unicorn
                    .add_code_hook(
                        libc_base + LIBC_SRANDOM_OFFSET,
                        libc_base + LIBC_RANDOM_OFFSET + 0x80,
                        move |backend, address, size| {
                            let mut count = libc_trace_count.borrow_mut();
                            if *count >= 128 {
                                return;
                            }
                            *count += 1;
                            let lr = backend.reg_read(UnicornRegisterARM64::LR).unwrap_or(0);
                            let sp = backend.reg_read(UnicornRegisterARM64::SP).unwrap_or(0);
                            let x0 = backend.reg_read(UnicornRegisterARM64::X0).unwrap_or(0);
                            let x1 = backend.reg_read(UnicornRegisterARM64::X1).unwrap_or(0);
                            libc_trace_shared.borrow_mut().native(&format!(
                                "unicorn code libc_rng addr=0x{:x} size={} lr=0x{:x} sp=0x{:x} x0=0x{:x} x1=0x{:x}",
                                address, size, lr, sp, x0, x1
                            ));
                        },
                    )
                    .map_err(|err| anyhow!("failed to install libc rng unicorn code hook: {err:?}"))?;

            let libc_dispatch_trace_count = Rc::new(RefCell::new(0usize));
            let libc_dispatch_trace_shared = shared.clone();
            unicorn
                    .add_code_hook(
                        libc_base + LIBC_DISPATCH_ONE_OFFSET,
                        libc_base + LIBC_DISPATCH_TWO_OFFSET + 0x60,
                        move |backend, address, size| {
                            let mut count = libc_dispatch_trace_count.borrow_mut();
                            if *count >= 96 {
                                return;
                            }
                            *count += 1;
                            let lr = backend.reg_read(UnicornRegisterARM64::LR).unwrap_or(0);
                            let sp = backend.reg_read(UnicornRegisterARM64::SP).unwrap_or(0);
                            let x0 = backend.reg_read(UnicornRegisterARM64::X0).unwrap_or(0);
                            let x1 = backend.reg_read(UnicornRegisterARM64::X1).unwrap_or(0);
                            let x19 = backend.reg_read(UnicornRegisterARM64::X19).unwrap_or(0);
                            libc_dispatch_trace_shared.borrow_mut().native(&format!(
                                "unicorn code libc_dispatch addr=0x{:x} size={} lr=0x{:x} sp=0x{:x} x0=0x{:x} x1=0x{:x} x19=0x{:x}",
                                address, size, lr, sp, x0, x1, x19
                            ));
                        },
                    )
                    .map_err(|err| anyhow!("failed to install libc dispatch hook: {err:?}"))?;

            let libc_fdsan_trace_count = Rc::new(RefCell::new(0usize));
            let libc_fdsan_trace_shared = shared.clone();
            unicorn
                    .add_code_hook(
                        libc_base + 0x0a2480,
                        libc_base + 0x0a2500,
                        move |backend, address, size| {
                            let mut count = libc_fdsan_trace_count.borrow_mut();
                            if *count >= 128 {
                                return;
                            }
                            *count += 1;
                            let lr = backend.reg_read(UnicornRegisterARM64::LR).unwrap_or(0);
                            let sp = backend.reg_read(UnicornRegisterARM64::SP).unwrap_or(0);
                            let x0 = backend.reg_read(UnicornRegisterARM64::X0).unwrap_or(0);
                            let x1 = backend.reg_read(UnicornRegisterARM64::X1).unwrap_or(0);
                            let x2 = backend.reg_read(UnicornRegisterARM64::X2).unwrap_or(0);
                            let x3 = backend.reg_read(UnicornRegisterARM64::X3).unwrap_or(0);
                            let x19 = backend.reg_read(UnicornRegisterARM64::X19).unwrap_or(0);
                            let x20 = backend.reg_read(UnicornRegisterARM64::X20).unwrap_or(0);
                            let x21 = backend.reg_read(UnicornRegisterARM64::X21).unwrap_or(0);
                            libc_fdsan_trace_shared.borrow_mut().native(&format!(
                                "unicorn code libc_fdsan addr=0x{:x} size={} lr=0x{:x} sp=0x{:x} x0=0x{:x} x1=0x{:x} x2=0x{:x} x3=0x{:x} x19=0x{:x} x20=0x{:x} x21=0x{:x}",
                                address, size, lr, sp, x0, x1, x2, x3, x19, x20, x21
                            ));
                        },
                    )
                    .map_err(|err| anyhow!("failed to install libc fdsan hook: {err:?}"))?;

            let libc_fdtable_trace_count = Rc::new(RefCell::new(0usize));
            let libc_fdtable_trace_shared = shared.clone();
            unicorn
                    .add_code_hook(
                        libc_base + 0x0a2900,
                        libc_base + 0x0a29a0,
                        move |backend, address, size| {
                            let mut count = libc_fdtable_trace_count.borrow_mut();
                            if *count >= 96 {
                                return;
                            }
                            *count += 1;
                            let lr = backend.reg_read(UnicornRegisterARM64::LR).unwrap_or(0);
                            let sp = backend.reg_read(UnicornRegisterARM64::SP).unwrap_or(0);
                            let x0 = backend.reg_read(UnicornRegisterARM64::X0).unwrap_or(0);
                            let x1 = backend.reg_read(UnicornRegisterARM64::X1).unwrap_or(0);
                            let x19 = backend.reg_read(UnicornRegisterARM64::X19).unwrap_or(0);
                            let x20 = backend.reg_read(UnicornRegisterARM64::X20).unwrap_or(0);
                            let x21 = backend.reg_read(UnicornRegisterARM64::X21).unwrap_or(0);
                            let x22 = backend.reg_read(UnicornRegisterARM64::X22).unwrap_or(0);
                            libc_fdtable_trace_shared.borrow_mut().native(&format!(
                                "unicorn code libc_fdtable addr=0x{:x} size={} lr=0x{:x} sp=0x{:x} x0=0x{:x} x1=0x{:x} x19=0x{:x} x20=0x{:x} x21=0x{:x} x22=0x{:x}",
                                address, size, lr, sp, x0, x1, x19, x20, x21, x22
                            ));
                        },
                    )
                    .map_err(|err| anyhow!("failed to install libc fdtable hook: {err:?}"))?;

            let libc_cas_trace_count = Rc::new(RefCell::new(0usize));
            let libc_cas_trace_shared = shared.clone();
            unicorn
                    .add_code_hook(
                        libc_base + 0x115560,
                        libc_base + 0x115594,
                        move |backend, address, size| {
                            let mut count = libc_cas_trace_count.borrow_mut();
                            if *count >= 96 {
                                return;
                            }
                            *count += 1;
                            let lr = backend.reg_read(UnicornRegisterARM64::LR).unwrap_or(0);
                            let sp = backend.reg_read(UnicornRegisterARM64::SP).unwrap_or(0);
                            let x0 = backend.reg_read(UnicornRegisterARM64::X0).unwrap_or(0);
                            let x1 = backend.reg_read(UnicornRegisterARM64::X1).unwrap_or(0);
                            let x2 = backend.reg_read(UnicornRegisterARM64::X2).unwrap_or(0);
                            libc_cas_trace_shared.borrow_mut().native(&format!(
                                "unicorn code libc_cas8 addr=0x{:x} size={} lr=0x{:x} sp=0x{:x} x0=0x{:x} x1=0x{:x} x2=0x{:x}",
                                address, size, lr, sp, x0, x1, x2
                            ));
                        },
                    )
                    .map_err(|err| anyhow!("failed to install libc cas8 hook: {err:?}"))?;

            let libc_tsd_guard_count = Rc::new(RefCell::new(0usize));
            let libc_tsd_guard_shared = shared.clone();
            unicorn
                    .add_code_hook(
                        libc_base + LIBC_JE_TSD_PATH_START,
                        libc_base + LIBC_JE_TSD_PATH_END,
                        move |backend, address, _size| {
                            let mut count = libc_tsd_guard_count.borrow_mut();
                            if *count >= 128 {
                                return;
                            }
                            let mut slot_buf = [0u8; 8];
                            let tsd_state_slot_addr = libc_base + JEMALLOC_TSD_STATE_SLOT_OFFSET;
                            let key_ptr_slot_addr = libc_base + JEMALLOC_TSD_KEYPTR_SLOT_OFFSET;
                            let state_slot_ok = backend.mem_read(tsd_state_slot_addr, &mut slot_buf).is_ok();
                            let state_ptr = if state_slot_ok {
                                u64::from_le_bytes(slot_buf)
                            } else {
                                0
                            };
                            let key_slot_ok = backend.mem_read(key_ptr_slot_addr, &mut slot_buf).is_ok();
                            let key_ptr = if key_slot_ok {
                                u64::from_le_bytes(slot_buf)
                            } else {
                                0
                            };

                            let mut patched = false;
                            let x22 = backend.reg_read(UnicornRegisterARM64::X22).unwrap_or(0);
                            if x22 == 0 {
                                let fallback = if state_ptr != 0 {
                                    state_ptr
                                } else {
                                    tsd_state_slot_addr
                                };
                                let _ = backend.reg_write(UnicornRegisterARM64::X22, fallback);
                                patched = true;
                            }
                            let x23 = backend.reg_read(UnicornRegisterARM64::X23).unwrap_or(0);
                            if x23 == 0 {
                                let fallback = if key_ptr != 0 {
                                    key_ptr
                                } else {
                                    key_ptr_slot_addr
                                };
                                let _ = backend.reg_write(UnicornRegisterARM64::X23, fallback);
                                patched = true;
                            }

                            if patched || address == libc_base + 0x99134 || address == libc_base + 0x99150 {
                                *count += 1;
                                let new_x22 = backend.reg_read(UnicornRegisterARM64::X22).unwrap_or(0);
                                let new_x23 = backend.reg_read(UnicornRegisterARM64::X23).unwrap_or(0);
                                let lr = backend.reg_read(UnicornRegisterARM64::LR).unwrap_or(0);
                                libc_tsd_guard_shared.borrow_mut().native(&format!(
                                    "unicorn libc_tsd_guard addr=0x{:x} lr=0x{:x} x22=0x{:x} x23=0x{:x} state_slot=0x{:x}->0x{:x} key_slot=0x{:x}->0x{:x} patched={}",
                                    address,
                                    lr,
                                    new_x22,
                                    new_x23,
                                    tsd_state_slot_addr,
                                    state_ptr,
                                    key_ptr_slot_addr,
                                    key_ptr,
                                    patched
                                ));
                            }
                        },
                    )
                    .map_err(|err| anyhow!("failed to install libc tsd guard hook: {err:?}"))?;
        }

        shared.borrow_mut().native(&format!(
                "installed unicorn code hooks palmchat=[0x{:x},0x{:x}) palmchat_dispatch=[0x{:x},0x{:x}) libc_rng=[0x{:x},0x{:x}) libc_dispatch=[0x{:x},0x{:x}) toggles cipher={} plt={} libc={} dispatch={} refresh={} fast_hashkey={}",
                module_base + 0x0a6180,
                module_base + 0x0a6260,
                module_base + 0x0b1938,
                module_base + 0x0b1988,
                libc_base + LIBC_SRANDOM_OFFSET,
                libc_base + LIBC_RANDOM_OFFSET + 0x80,
                libc_base + LIBC_DISPATCH_ONE_OFFSET,
                libc_base + LIBC_DISPATCH_TWO_OFFSET + 0x60,
                verbose_cipher_hooks,
                verbose_plt_hooks,
                verbose_libc_hooks,
                verbose_dispatch_hooks,
                verbose_refresh_hooks,
                hashkey_fast_global_ref.is_some()
            ));
    }

    Ok(())
}

fn seed_libc_vdso_time_slots(
    emulator: &AndroidEmulator<'static, ()>,
    shared: Rc<RefCell<SharedState>>,
) -> Result<()> {
    const GETTIMEOFDAY_GUARD_OFFSET: u64 = 0x00de808;
    const CLOCK_GETTIME_GUARD_OFFSET: u64 = 0x00de810;
    const GETTIMEOFDAY_SLOT_OFFSET: u64 = 0x00de818;
    const CLOCK_GETTIME_SLOT_OFFSET: u64 = 0x00de820;

    let Some(libc_base) = emulator.find_loaded_module_base("libc.so") else {
        shared
            .borrow_mut()
            .native("libc vdso seed skipped reason=libc-not-loaded");
        return Ok(());
    };
    let gettimeofday_addr = emulator.register_svc(SimpleArm64Svc::new(
        "palmchat_vdso_gettimeofday",
        palmchat_vdso_gettimeofday::<()>,
    ));
    let clock_gettime_addr = emulator.register_svc(SimpleArm64Svc::new(
        "palmchat_vdso_clock_gettime",
        palmchat_vdso_clock_gettime::<()>,
    ));

    for (addr, value) in [
        (libc_base + GETTIMEOFDAY_GUARD_OFFSET, 1_u64),
        (libc_base + CLOCK_GETTIME_GUARD_OFFSET, 1_u64),
        (libc_base + GETTIMEOFDAY_SLOT_OFFSET, gettimeofday_addr),
        (libc_base + CLOCK_GETTIME_SLOT_OFFSET, clock_gettime_addr),
    ] {
        emulator
            .backend
            .mem_write(addr, &value.to_le_bytes())
            .with_context(|| format!("failed to seed libc slot addr=0x{addr:x}"))?;
    }

    shared.borrow_mut().native(&format!(
        "seeded libc vdso slots libc_base=0x{:x} svc_gettimeofday=0x{:x} svc_clock_gettime=0x{:x}",
        libc_base, gettimeofday_addr, clock_gettime_addr
    ));
    Ok(())
}

fn seed_libc_rng_slots(
    emulator: &AndroidEmulator<'static, ()>,
    shared: Rc<RefCell<SharedState>>,
    module_base: u64,
) -> Result<()> {
    const MALLOC_SLOT_OFFSET: u64 = 0x1826d8;
    const RANDOM_SLOT_OFFSET: u64 = 0x182d40;
    const SRANDOM_SLOT_OFFSET: u64 = 0x183f08;
    const RANDOM_OFFSET: u64 = 0x000dbdb0;
    const SRANDOM_OFFSET: u64 = 0x000db5c0;

    let Some(libc_base) = emulator.find_loaded_module_base("libc.so") else {
        shared
            .borrow_mut()
            .native("libc rng seed skipped reason=libc-not-loaded");
        return Ok(());
    };

    for (slot_offset, target_offset) in [
        (RANDOM_SLOT_OFFSET, RANDOM_OFFSET),
        (SRANDOM_SLOT_OFFSET, SRANDOM_OFFSET),
    ] {
        let slot_addr = module_base + slot_offset;
        let target_addr = libc_base + target_offset;
        emulator
            .backend
            .mem_write(slot_addr, &target_addr.to_le_bytes())
            .with_context(|| format!("failed to seed libc rng slot addr=0x{slot_addr:x}"))?;
        let readback = emulator
            .backend
            .mem_read_as_vec(slot_addr, 8)
            .ok()
            .and_then(|bytes| {
                bytes
                    .get(0..8)
                    .map(|slice| u64::from_le_bytes(slice.try_into().unwrap()))
            })
            .unwrap_or(0);
        shared.borrow_mut().native(&format!(
            "seeded libc rng slot slot_offset=0x{:x} slot_addr=0x{:x} target=0x{:x} readback=0x{:x}",
            slot_offset, slot_addr, target_addr, readback
        ));
    }

    let malloc_target_addr = emulator
        .resolve_loaded_symbol(Some("libc.so"), "malloc")
        .unwrap_or_else(|| {
            emulator.register_svc(SimpleArm64Svc::new(
                "palmchat_malloc_stub",
                palmchat_malloc_stub::<()>,
            ))
        });
    let slot_addr = module_base + MALLOC_SLOT_OFFSET;
    emulator
        .backend
        .mem_write(slot_addr, &malloc_target_addr.to_le_bytes())
        .with_context(|| format!("failed to seed libc malloc slot addr=0x{slot_addr:x}"))?;
    let readback = emulator
        .backend
        .mem_read_as_vec(slot_addr, 8)
        .ok()
        .and_then(|bytes| {
            bytes
                .get(0..8)
                .map(|slice| u64::from_le_bytes(slice.try_into().unwrap()))
        })
        .unwrap_or(0);
    shared.borrow_mut().native(&format!(
        "seeded libc malloc slot slot_offset=0x{:x} slot_addr=0x{:x} target=0x{:x} readback=0x{:x}",
        MALLOC_SLOT_OFFSET, slot_addr, malloc_target_addr, readback
    ));

    shared.borrow_mut().native(&format!(
        "seeded libc rng slots module_base=0x{:x} random=0x{:x} srandom=0x{:x}",
        module_base,
        libc_base + RANDOM_OFFSET,
        libc_base + SRANDOM_OFFSET
    ));

    seed_libc_jemalloc_tsd_slots(emulator, shared.clone())?;
    patch_libc_zero_size_alloc_guard(emulator, shared.clone())?;
    Ok(())
}

fn patch_libc_zero_size_alloc_guard(
    emulator: &AndroidEmulator<'static, ()>,
    shared: Rc<RefCell<SharedState>>,
) -> Result<()> {
    // Evidence anchor: crash path at libc+0x79fc8 uses:
    //   sub x0, x1, #1
    // with x1==0, producing x0=-1 and an out-of-range class-table read.
    // Replace only that one instruction with:
    //   orr x0, x1, #0x1
    // so zero-size becomes 1 and non-zero remains near-original.
    const ARENA_SMALL_SUB_OFFSET: u64 = 0x00079fcc;
    const INSN_ORR_X0_X1_IMM1: u32 = 0xb2400020;

    let Some(libc_base) = emulator.find_loaded_module_base("libc.so") else {
        shared
            .borrow_mut()
            .native("libc zero-size alloc guard skipped reason=libc-not-loaded");
        return Ok(());
    };

    let patch_addr = libc_base + ARENA_SMALL_SUB_OFFSET;
    let old_insn = read_u32_slot(emulator, patch_addr);
    if old_insn != INSN_ORR_X0_X1_IMM1 {
        emulator
            .backend
            .mem_write(patch_addr, &INSN_ORR_X0_X1_IMM1.to_le_bytes())
            .with_context(|| {
                format!("failed to patch libc zero-size guard addr=0x{patch_addr:x}")
            })?;
    }
    let new_insn = read_u32_slot(emulator, patch_addr);
    shared.borrow_mut().native(&format!(
        "patched libc zero-size alloc guard addr=0x{:x} old=0x{:08x} new=0x{:08x}",
        patch_addr, old_insn, new_insn
    ));
    Ok(())
}

fn seed_libc_jemalloc_tsd_slots(
    emulator: &AndroidEmulator<'static, ()>,
    shared: Rc<RefCell<SharedState>>,
) -> Result<()> {
    // Evidence anchor: libc je_tcache_get_hard dereferences globals at
    // (libc_base + 0xd8df8) and (libc_base + 0xd8f98). In rnidbg these can be
    // zero, which later drives x23 to null and crashes on ldr w0, [x23].
    const JEMALLOC_TSD_STATE_SLOT_OFFSET: u64 = 0x000d8df8;
    const JEMALLOC_TSD_KEYPTR_SLOT_OFFSET: u64 = 0x000d8f98;
    const JEMALLOC_TSD_STATE_SIZE: usize = 0x80;
    const JEMALLOC_KEY_STORAGE_SIZE: usize = 0x8;
    const PTHREAD_MUTEX_INIT_FN: &str = "pthread_mutex_init";

    let Some(libc_base) = emulator.find_loaded_module_base("libc.so") else {
        shared
            .borrow_mut()
            .native("jemalloc tsd seed skipped reason=libc-not-loaded");
        return Ok(());
    };

    let tsd_state_slot = libc_base + JEMALLOC_TSD_STATE_SLOT_OFFSET;
    let key_ptr_slot = libc_base + JEMALLOC_TSD_KEYPTR_SLOT_OFFSET;

    let existing_state_ptr = read_u64_slot(emulator, tsd_state_slot);
    let existing_state_valid =
        existing_state_ptr != 0 && pointer_range_readable(emulator, existing_state_ptr, 0x28);
    if existing_state_ptr != 0 && !existing_state_valid {
        shared.borrow_mut().native(&format!(
            "jemalloc tsd state slot invalid slot=0x{:x} value=0x{:x} action=overwrite",
            tsd_state_slot, existing_state_ptr
        ));
    }
    let tsd_state_ptr = if existing_state_valid {
        existing_state_ptr
    } else {
        let scratch = emulator
            .falloc(JEMALLOC_TSD_STATE_SIZE, false)
            .context("failed to allocate jemalloc tsd state scratch")?;
        // Head pointer and inline mutex memory must start zeroed for lazy init.
        emulator
            .backend
            .mem_write(scratch.addr, &vec![0u8; JEMALLOC_TSD_STATE_SIZE])
            .with_context(|| {
                format!(
                    "failed to clear jemalloc tsd state scratch addr=0x{:x}",
                    scratch.addr
                )
            })?;
        emulator
            .backend
            .mem_write(tsd_state_slot, &scratch.addr.to_le_bytes())
            .with_context(|| {
                format!("failed to seed jemalloc tsd state slot addr=0x{tsd_state_slot:x}")
            })?;
        scratch.addr
    };

    let existing_key_ptr = read_u64_slot(emulator, key_ptr_slot);
    let existing_key_valid =
        existing_key_ptr != 0 && pointer_range_readable(emulator, existing_key_ptr, 0x4);
    if existing_key_ptr != 0 && !existing_key_valid {
        shared.borrow_mut().native(&format!(
            "jemalloc key slot invalid slot=0x{:x} value=0x{:x} action=overwrite",
            key_ptr_slot, existing_key_ptr
        ));
    }
    let key_storage_ptr = if existing_key_valid {
        existing_key_ptr
    } else {
        let key_storage = emulator
            .falloc(JEMALLOC_KEY_STORAGE_SIZE, false)
            .context("failed to allocate jemalloc key storage scratch")?;
        emulator
            .backend
            .mem_write(key_storage.addr, &[0u8; JEMALLOC_KEY_STORAGE_SIZE])
            .with_context(|| {
                format!(
                    "failed to clear jemalloc key storage scratch addr=0x{:x}",
                    key_storage.addr
                )
            })?;
        emulator
            .backend
            .mem_write(key_ptr_slot, &key_storage.addr.to_le_bytes())
            .with_context(|| format!("failed to seed jemalloc key slot addr=0x{key_ptr_slot:x}"))?;
        key_storage.addr
    };

    // Best-effort initialize mutex embedded at state+8.
    if let Some(mutex_init_addr) =
        emulator.resolve_loaded_symbol(Some("libc.so"), PTHREAD_MUTEX_INIT_FN)
    {
        let mutex_addr = tsd_state_ptr + 0x8;
        let ret = emulator.e_func(
            mutex_init_addr,
            vec![UnicornArg::Ptr(mutex_addr), UnicornArg::Ptr(0)],
        );
        shared.borrow_mut().native(&format!(
            "jemalloc tsd pthread_mutex_init mutex=0x{:x} ret={:?}",
            mutex_addr, ret
        ));
    } else {
        shared
            .borrow_mut()
            .native("jemalloc tsd pthread_mutex_init skipped reason=symbol-missing");
    }

    let key_before = read_u32_slot(emulator, key_storage_ptr);
    // Preserve snapshot state only; do not create pthread key in this pre-init
    // phase because it mutates allocator globals before JNI_OnLoad.
    let key_after = read_u32_slot(emulator, key_storage_ptr);

    let state_slot_readback = read_u64_slot(emulator, tsd_state_slot);
    let key_slot_readback = read_u64_slot(emulator, key_ptr_slot);
    shared.borrow_mut().native(&format!(
        "seeded jemalloc tsd slots libc_base=0x{:x} state_slot=0x{:x}->0x{:x} readback=0x{:x} key_slot=0x{:x}->0x{:x} readback=0x{:x} key_before={} key_after={}",
        libc_base,
        tsd_state_slot,
        tsd_state_ptr,
        state_slot_readback,
        key_ptr_slot,
        key_storage_ptr,
        key_slot_readback,
        key_before,
        key_after
    ));

    Ok(())
}

fn pointer_range_readable(emulator: &AndroidEmulator<'static, ()>, addr: u64, len: usize) -> bool {
    if addr == 0 {
        return false;
    }
    emulator.backend.mem_read_as_vec(addr, len).is_ok()
}

fn read_u64_slot(emulator: &AndroidEmulator<'static, ()>, addr: u64) -> u64 {
    emulator
        .backend
        .mem_read_as_vec(addr, 8)
        .ok()
        .and_then(|bytes| {
            bytes
                .get(0..8)
                .map(|slice| u64::from_le_bytes(slice.try_into().unwrap()))
        })
        .unwrap_or(0)
}

fn read_u32_slot(emulator: &AndroidEmulator<'static, ()>, addr: u64) -> u32 {
    emulator
        .backend
        .mem_read_as_vec(addr, 4)
        .ok()
        .and_then(|bytes| {
            bytes
                .get(0..4)
                .map(|slice| u32::from_le_bytes(slice.try_into().unwrap()))
        })
        .unwrap_or(0)
}

fn read_c_string_lossy(
    emulator: &AndroidEmulator<'static, ()>,
    addr: u64,
    max_len: usize,
) -> Option<String> {
    if addr == 0 || max_len == 0 {
        return None;
    }
    let bytes = emulator.backend.mem_read_as_vec(addr, max_len).ok()?;
    let nul = bytes
        .iter()
        .position(|byte| *byte == 0)
        .unwrap_or(bytes.len());
    Some(String::from_utf8_lossy(&bytes[..nul]).into_owned())
}

#[cfg(feature = "unicorn")]
fn read_backend_c_string_lossy(backend: &Unicorn<'_, ()>, addr: u64, max_len: usize) -> Option<String> {
    if addr == 0 || max_len == 0 {
        return None;
    }
    let bytes = backend.mem_read_as_vec(addr, max_len).ok()?;
    let nul = bytes
        .iter()
        .position(|byte| *byte == 0)
        .unwrap_or(bytes.len());
    Some(String::from_utf8_lossy(&bytes[..nul]).into_owned())
}

fn align_up_u64(value: u64, align: u64) -> u64 {
    if align <= 1 {
        return value;
    }
    let mask = align - 1;
    value.saturating_add(mask) & !mask
}

fn palmchat_asset_name_candidates(name: &str) -> Vec<String> {
    let trimmed = name.trim().trim_start_matches('/');
    let mut candidates = Vec::new();
    for candidate in [
        trimmed.to_string(),
        format!("assets/{trimmed}"),
        format!("assets/{}", trimmed.trim_start_matches("assets/")),
    ] {
        if candidate.is_empty() || candidates.iter().any(|existing| existing == &candidate) {
            continue;
        }
        candidates.push(candidate);
    }
    candidates
}

fn read_apk_asset_bytes(apk_path: &Path, asset_name: &str) -> Result<Vec<u8>> {
    let apk = File::open(apk_path)
        .with_context(|| format!("failed to open apk for asset read: {}", apk_path.display()))?;
    let mut archive =
        ZipArchive::new(apk).with_context(|| format!("failed to open zip: {}", apk_path.display()))?;
    let mut file = archive.by_name(asset_name).with_context(|| {
        format!(
            "failed to locate asset '{}' inside {}",
            asset_name,
            apk_path.display()
        )
    })?;
    let mut bytes = Vec::new();
    file.read_to_end(&mut bytes)
        .with_context(|| format!("failed to read asset '{}'", asset_name))?;
    Ok(bytes)
}

fn resolve_palmchat_asset_bytes(apk_path: &Path, requested_name: &str) -> Result<(String, Vec<u8>)> {
    let mut last_err = None;
    for candidate in palmchat_asset_name_candidates(requested_name) {
        match read_apk_asset_bytes(apk_path, &candidate) {
            Ok(bytes) => return Ok((candidate, bytes)),
            Err(err) => last_err = Some(err),
        }
    }
    Err(last_err.unwrap_or_else(|| anyhow!("asset '{}' not found", requested_name)))
}

fn read_hex_lossy(
    emulator: &AndroidEmulator<'static, ()>,
    addr: u64,
    len: usize,
) -> Option<String> {
    if addr == 0 || len == 0 {
        return None;
    }
    emulator
        .backend
        .mem_read_as_vec(addr, len)
        .ok()
        .map(hex::encode)
}

fn scrub_palmchat_runtime_heap_slots(
    emulator: &AndroidEmulator<'static, ()>,
    shared: Rc<RefCell<SharedState>>,
    module_base: u64,
) -> Result<()> {
    // Runtime dumps taken from an already-running process can retain heap state
    // pointers that are invalid in a cold rnidbg boot. Scrub only the slots we
    // have direct code evidence for before createCKey starts.
    const HEAP_STATE_SLOTS: &[(u64, usize, &str)] = &[(0x187af0, 0x18, "create_ckey_state")];

    for (slot_offset, probe_len, label) in HEAP_STATE_SLOTS {
        let slot_addr = module_base + slot_offset;
        let existing = read_u64_slot(emulator, slot_addr);
        if existing == 0 {
            continue;
        }
        if pointer_range_readable(emulator, existing, *probe_len) {
            continue;
        }
        emulator
            .backend
            .mem_write(slot_addr, &0u64.to_le_bytes())
            .with_context(|| format!("failed to scrub palmchat heap slot 0x{slot_addr:x}"))?;
        shared.borrow_mut().native(&format!(
            "scrubbed palmchat heap slot label={} slot_addr=0x{:x} stale_value=0x{:x} action=zero",
            label, slot_addr, existing
        ));
    }
    Ok(())
}

fn seed_palmchat_runtime_dispatch_slots(
    emulator: &AndroidEmulator<'static, ()>,
    shared: Rc<RefCell<SharedState>>,
    module_base: u64,
) -> Result<()> {
    const LIBC_DISPATCH_ONE_OFFSET: u64 = 0x000507b0;
    const LIBC_DISPATCH_TWO_OFFSET: u64 = 0x00050b50;
    const MODULE_SLOT_OFFSETS: &[(u64, u64)] = &[
        (0x186830, 0x0b1938),
        (0x186838, 0x0b1954),
        (0x186840, 0x0b1970),
    ];
    const LIBC_SLOT_OFFSETS: &[(u64, u64)] = &[
        (0x186848, LIBC_DISPATCH_ONE_OFFSET),
        (0x186850, LIBC_DISPATCH_TWO_OFFSET),
        (0x186858, LIBC_DISPATCH_ONE_OFFSET),
    ];
    for (slot_offset, target_offset) in MODULE_SLOT_OFFSETS {
        let slot_addr = module_base + slot_offset;
        let target_addr = module_base + target_offset;
        emulator
            .backend
            .mem_write(slot_addr, &target_addr.to_le_bytes())
            .with_context(|| format!("failed to seed palmchat dispatch slot 0x{slot_addr:x}"))?;
    }
    let Some(libc_base) = emulator.find_loaded_module_base("libc.so") else {
        shared
            .borrow_mut()
            .native("palmchat dispatch libc seed skipped reason=libc-not-loaded");
        return Ok(());
    };
    if let Some(libc_size) = emulator.find_loaded_module_size("libc.so") {
        let required = LIBC_DISPATCH_TWO_OFFSET + 0x60;
        if libc_size as u64 <= required {
            shared.borrow_mut().native(&format!(
                "loaded libc too small for palmchat dispatch evidence size=0x{:x} required_gt=0x{:x} override_required=true",
                libc_size,
                required
            ));
        }
    }
    for (slot_offset, target_offset) in LIBC_SLOT_OFFSETS {
        let slot_addr = module_base + slot_offset;
        let target_addr = libc_base + target_offset;
        emulator
            .backend
            .mem_write(slot_addr, &target_addr.to_le_bytes())
            .with_context(|| {
                format!("failed to seed palmchat libc dispatch slot 0x{slot_addr:x}")
            })?;
    }
    shared.borrow_mut().native(&format!(
        "seeded palmchat dispatch slots module_base=0x{:x} libc_base=0x{:x} slots=[0x186830->0x{:x},0x186838->0x{:x},0x186840->0x{:x},0x186848->0x{:x},0x186850->0x{:x},0x186858->0x{:x}]",
        module_base,
        libc_base,
        module_base + 0x0b1938,
        module_base + 0x0b1954,
        module_base + 0x0b1970,
        libc_base + LIBC_DISPATCH_ONE_OFFSET,
        libc_base + LIBC_DISPATCH_TWO_OFFSET,
        libc_base + LIBC_DISPATCH_ONE_OFFSET
    ));
    Ok(())
}

fn seed_palmchat_runtime_context_slot(
    emulator: &AndroidEmulator<'static, ()>,
    shared: Rc<RefCell<SharedState>>,
    module_base: u64,
) -> Result<()> {
    const CONTEXT_SLOT_OFFSET: u64 = 0x1897b0;
    const CONTEXT_TABLE_OFFSET: u64 = 0x186878;
    const CONTEXT_TABLE_ENTRIES: &[(u64, u64)] = &[
        (0x00, 0x0b30d4),
        (0x08, 0x0b32fc),
        (0x10, 0x0b3384),
        (0x18, 0x0b3c5c),
        (0x20, 0x0b3a78),
        (0x28, 0x0b38dc),
        (0x30, 0x1868b0),
        (0x50, 0x0ba674),
        (0x58, 0x0ba1ac),
    ];

    let table_addr = module_base + CONTEXT_TABLE_OFFSET;
    for (entry_offset, target_offset) in CONTEXT_TABLE_ENTRIES {
        let entry_addr = table_addr + entry_offset;
        let existing = emulator
            .backend
            .mem_read_as_vec(entry_addr, 8)
            .ok()
            .and_then(|bytes| {
                bytes
                    .get(0..8)
                    .map(|slice| u64::from_le_bytes(slice.try_into().unwrap()))
            })
            .unwrap_or(0);
        if existing != 0 {
            continue;
        }
        let target_addr = module_base + target_offset;
        emulator
            .backend
            .mem_write(entry_addr, &target_addr.to_le_bytes())
            .with_context(|| {
                format!("failed to seed palmchat runtime context table entry 0x{entry_addr:x}")
            })?;
        shared.borrow_mut().native(&format!(
            "seeded palmchat runtime context table entry entry_offset=0x{:x} entry_addr=0x{:x} target=0x{:x}",
            entry_offset,
            entry_addr,
            target_addr
        ));
    }

    let slot_addr = module_base + CONTEXT_SLOT_OFFSET;
    let existing = emulator
        .backend
        .mem_read_as_vec(slot_addr, 8)
        .ok()
        .and_then(|bytes| {
            bytes
                .get(0..8)
                .map(|slice| u64::from_le_bytes(slice.try_into().unwrap()))
        })
        .unwrap_or(0);
    if existing != 0 {
        shared.borrow_mut().native(&format!(
            "palmchat runtime context slot already populated slot_addr=0x{:x} value=0x{:x}",
            slot_addr, existing
        ));
        return Ok(());
    }

    // Runtime dump can show this slot zero early in process lifetime, but in
    // rnidbg that leaves downstream indirect calls unresolved during createCKey.
    // Use the recovered context table base as minimal fallback.
    emulator
        .backend
        .mem_write(slot_addr, &table_addr.to_le_bytes())
        .with_context(|| format!("failed to seed palmchat runtime context slot 0x{slot_addr:x}"))?;
    let readback = emulator
        .backend
        .mem_read_as_vec(slot_addr, 8)
        .ok()
        .and_then(|bytes| {
            bytes
                .get(0..8)
                .map(|slice| u64::from_le_bytes(slice.try_into().unwrap()))
        })
        .unwrap_or(0);
    shared.borrow_mut().native(&format!(
        "seeded palmchat runtime context slot slot_offset=0x{:x} slot_addr=0x{:x} target=0x{:x} readback=0x{:x}",
        CONTEXT_SLOT_OFFSET,
        slot_addr,
        table_addr,
        readback
    ));
    Ok(())
}

fn seed_palmchat_runtime_pointer_array(
    emulator: &AndroidEmulator<'static, ()>,
    shared: Rc<RefCell<SharedState>>,
    module_base: u64,
) -> Result<()> {
    const PTR_ARRAY_OFFSET: u64 = 0x185c20;
    const PTR_ARRAY_TARGETS: &[(u64, u64)] = &[
        (0x08, 0x125de0),
        (0x10, 0x17cbc0),
        (0x18, 0x171318),
        (0x20, 0x0bbb54),
        (0x28, 0x125e28),
        (0x30, 0x171610),
        (0x38, 0x1716a8),
    ];
    const EXTERNAL_SENTINEL: u64 = 0xaaa8_c7bc_bec1_3511;

    let array_addr = module_base + PTR_ARRAY_OFFSET;
    let external_slot = array_addr;
    let existing_external = emulator
        .backend
        .mem_read_as_vec(external_slot, 8)
        .ok()
        .and_then(|bytes| {
            bytes
                .get(0..8)
                .map(|slice| u64::from_le_bytes(slice.try_into().unwrap()))
        })
        .unwrap_or(0);
    let existing_external_valid =
        existing_external != 0 && pointer_range_readable(emulator, existing_external, 0x10);
    if existing_external != 0 && !existing_external_valid {
        shared.borrow_mut().native(&format!(
            "palmchat runtime pointer array external slot invalid slot_addr=0x{:x} stale_value=0x{:x} action=replace",
            external_slot, existing_external
        ));
    }
    let external_ptr = if existing_external_valid {
        existing_external
    } else {
        let scratch = emulator
            .falloc(0x100, false)
            .context("failed to allocate palmchat runtime external state scratch")?;
        scratch.write_u64(EXTERNAL_SENTINEL)?;
        emulator
            .backend
            .mem_write(external_slot, &scratch.addr.to_le_bytes())
            .with_context(|| format!("failed to seed palmchat runtime pointer array external slot 0x{external_slot:x}"))?;
        shared.borrow_mut().native(&format!(
            "seeded palmchat runtime pointer array external slot slot_addr=0x{:x} scratch=0x{:x} sentinel=0x{:x}",
            external_slot,
            scratch.addr,
            EXTERNAL_SENTINEL
        ));
        scratch.addr
    };

    for (entry_offset, target_offset) in PTR_ARRAY_TARGETS {
        let entry_addr = array_addr + entry_offset;
        let existing = emulator
            .backend
            .mem_read_as_vec(entry_addr, 8)
            .ok()
            .and_then(|bytes| {
                bytes
                    .get(0..8)
                    .map(|slice| u64::from_le_bytes(slice.try_into().unwrap()))
            })
            .unwrap_or(0);
        if existing != 0 {
            continue;
        }
        let target_addr = module_base + target_offset;
        emulator
            .backend
            .mem_write(entry_addr, &target_addr.to_le_bytes())
            .with_context(|| {
                format!("failed to seed palmchat runtime pointer array entry 0x{entry_addr:x}")
            })?;
        shared.borrow_mut().native(&format!(
            "seeded palmchat runtime pointer array entry entry_offset=0x{:x} entry_addr=0x{:x} target=0x{:x}",
            entry_offset,
            entry_addr,
            target_addr
        ));
    }

    let readback = emulator
        .backend
        .mem_read_as_vec(external_slot, 8)
        .ok()
        .and_then(|bytes| {
            bytes
                .get(0..8)
                .map(|slice| u64::from_le_bytes(slice.try_into().unwrap()))
        })
        .unwrap_or(0);
    shared.borrow_mut().native(&format!(
        "seeded palmchat runtime pointer array array_addr=0x{:x} external_ptr=0x{:x} readback=0x{:x}",
        array_addr,
        external_ptr,
        readback
    ));
    Ok(())
}

#[repr(C)]
struct PalmchatTimeval {
    tv_sec: i64,
    tv_usec: i64,
}

#[repr(C)]
struct PalmchatTimespec {
    tv_sec: i64,
    tv_nsec: i64,
}

fn palmchat_vdso_gettimeofday<T: Clone>(_: &str, emulator: &AndroidEmulator<T>) -> SvcCallResult {
    let tv_pointer = emulator.backend.reg_read(RegisterARM64::X0).unwrap_or(0);
    let tz_pointer = emulator.backend.reg_read(RegisterARM64::X1).unwrap_or(0);
    if let Ok(duration_since_epoch) = SystemTime::now().duration_since(UNIX_EPOCH) {
        if tv_pointer != 0 {
            let mut buffer = [0u8; size_of::<PalmchatTimeval>()];
            let tv = unsafe { &mut *(buffer.as_mut_ptr() as *mut PalmchatTimeval) };
            tv.tv_sec = duration_since_epoch.as_secs() as i64;
            tv.tv_usec = duration_since_epoch.subsec_micros() as i64;
            let _ = emulator.backend.mem_write(tv_pointer, &buffer);
        }
        if tz_pointer != 0 {
            let _ = emulator.backend.mem_write(tz_pointer, &[0u8; 8]);
        }
        RET(0)
    } else {
        RET(-1)
    }
}

fn palmchat_vdso_clock_gettime<T: Clone>(_: &str, emulator: &AndroidEmulator<T>) -> SvcCallResult {
    let tp_pointer = emulator.backend.reg_read(RegisterARM64::X1).unwrap_or(0);
    if tp_pointer == 0 {
        return RET(-1);
    }
    if let Ok(duration_since_epoch) = SystemTime::now().duration_since(UNIX_EPOCH) {
        let mut buffer = [0u8; size_of::<PalmchatTimespec>()];
        let tv = unsafe { &mut *(buffer.as_mut_ptr() as *mut PalmchatTimespec) };
        tv.tv_sec = duration_since_epoch.as_secs() as i64;
        tv.tv_nsec = duration_since_epoch.subsec_nanos() as i64;
        let _ = emulator.backend.mem_write(tp_pointer, &buffer);
        RET(0)
    } else {
        RET(-1)
    }
}

fn palmchat_malloc_stub<T: Clone>(_: &str, emulator: &AndroidEmulator<T>) -> SvcCallResult {
    let request_size = emulator.backend.reg_read(RegisterARM64::X0).unwrap_or(0) as usize;
    let alloc_size = request_size.max(1);
    match emulator.falloc(alloc_size, false) {
        Ok(ptr) => RET(ptr.addr as i64),
        Err(_) => RET(0),
    }
}

fn parse_u64ish(raw: &str) -> Result<u64> {
    let value = raw.trim();
    if let Some(stripped) = value
        .strip_prefix("0x")
        .or_else(|| value.strip_prefix("0X"))
    {
        return u64::from_str_radix(stripped, 16)
            .with_context(|| format!("failed to parse hex integer: {value}"));
    }
    value
        .parse::<u64>()
        .with_context(|| format!("failed to parse integer: {value}"))
}

fn known_hidden_symbol_offset(symbol_name: &str) -> Option<u64> {
    match symbol_name {
        "JNI_OnLoad" => Some(0x0a1828),
        "Java_com_zenmen_palmchat_utils_EncryptUtils_skeyAvailable" => Some(0x0a361c),
        "Java_com_zenmen_palmchat_utils_EncryptUtils_createCKey" => Some(0x0a3630),
        "Java_com_zenmen_palmchat_utils_EncryptUtils_getCkVersion" => Some(0x0a1c30),
        "Java_com_zenmen_palmchat_utils_EncryptUtils_getEncryptedCKey" => Some(0x0a3634),
        "Java_com_zenmen_palmchat_utils_EncryptUtils_setLxData" => Some(0x0a6054),
        "Java_com_zenmen_palmchat_utils_EncryptUtils_cipherWithHashKey" => Some(0x0a5df4),
        "Java_com_zenmen_palmchat_utils_EncryptUtils_cipherWithType" => Some(0x0a3810),
        "Java_com_zenmen_palmchat_messaging_MessagingService_setSecretKeys" => Some(0x0a3ecc),
        "Java_com_zenmen_palmchat_messaging_MessagingService_getSecretKeys" => Some(0x0a40a4),
        "Java_com_zenmen_palmchat_messaging_CreateConnectionDelegate_refreshServerKey" => {
            Some(0x0a40b0)
        }
        _ => None,
    }
}

fn hidden_encrypt_utils_symbol_name(method_name: &str) -> Option<&'static str> {
    match method_name {
        "skeyAvailable" => Some("Java_com_zenmen_palmchat_utils_EncryptUtils_skeyAvailable"),
        "createCKey" => Some("Java_com_zenmen_palmchat_utils_EncryptUtils_createCKey"),
        "getCkVersion" => Some("Java_com_zenmen_palmchat_utils_EncryptUtils_getCkVersion"),
        "getEncryptedCKey" => Some("Java_com_zenmen_palmchat_utils_EncryptUtils_getEncryptedCKey"),
        "setLxData" => Some("Java_com_zenmen_palmchat_utils_EncryptUtils_setLxData"),
        "cipherWithHashKey" => {
            Some("Java_com_zenmen_palmchat_utils_EncryptUtils_cipherWithHashKey")
        }
        "cipherWithType" => Some("Java_com_zenmen_palmchat_utils_EncryptUtils_cipherWithType"),
        _ => None,
    }
}

fn hidden_messaging_service_symbol_name(method_name: &str) -> Option<&'static str> {
    match method_name {
        "setSecretKeys" => {
            Some("Java_com_zenmen_palmchat_messaging_MessagingService_setSecretKeys")
        }
        "getSecretKeys" => {
            Some("Java_com_zenmen_palmchat_messaging_MessagingService_getSecretKeys")
        }
        _ => None,
    }
}

fn hidden_create_connection_delegate_symbol_name(method_name: &str) -> Option<&'static str> {
    match method_name {
        "refreshServerKey" => {
            Some("Java_com_zenmen_palmchat_messaging_CreateConnectionDelegate_refreshServerKey")
        }
        _ => None,
    }
}

fn find_hidden_symbol_value(path: &Path, symbol_name: &str) -> Result<Option<u64>> {
    let bytes = fs::read(path)
        .with_context(|| format!("failed to read hidden-symbol candidate: {}", path.display()))?;
    let strtab = find_alloc_strtab(&bytes)?;
    let Some((sym_offset, sym_count)) = infer_hidden_symtab_region(&bytes, strtab.0, strtab.1)
    else {
        return Ok(None);
    };

    for index in 0..sym_count {
        let offset = sym_offset + index * 24;
        let st_name = read_u32(&bytes, offset)?;
        if st_name == 0 || st_name as usize >= strtab.1 {
            continue;
        }
        let name_start = strtab.0 + st_name as usize;
        let name_end = bytes[name_start..]
            .iter()
            .position(|byte| *byte == 0)
            .map(|pos| name_start + pos)
            .ok_or_else(|| anyhow!("unterminated hidden symbol string"))?;
        if &bytes[name_start..name_end] == symbol_name.as_bytes() {
            return Ok(Some(read_u64(&bytes, offset + 8)?));
        }
    }

    if let Some(value) = scan_hidden_symbol_value_globally(&bytes, strtab, symbol_name)? {
        return Ok(Some(value));
    }

    Ok(None)
}

fn scan_hidden_symbol_value_globally(
    bytes: &[u8],
    strtab: (usize, usize),
    symbol_name: &str,
) -> Result<Option<u64>> {
    let name_offsets = find_strtab_name_offsets(bytes, strtab, symbol_name)?;
    if name_offsets.is_empty() {
        return Ok(None);
    }
    let executable_ranges = find_executable_load_ranges(bytes).unwrap_or_default();

    for st_name in name_offsets {
        let needle = st_name.to_le_bytes();
        for offset in 0..=bytes.len().saturating_sub(24) {
            if bytes[offset..offset + 4] != needle {
                continue;
            }
            if !looks_like_hidden_sym_entry_global(
                bytes,
                offset,
                strtab,
                st_name,
                symbol_name,
                &executable_ranges,
            ) {
                continue;
            }
            return Ok(Some(read_u64(bytes, offset + 8)?));
        }
    }

    Ok(None)
}

fn find_strtab_name_offsets(
    bytes: &[u8],
    strtab: (usize, usize),
    symbol_name: &str,
) -> Result<Vec<u32>> {
    let (strtab_offset, strtab_size) = strtab;
    let strtab_bytes = bytes
        .get(strtab_offset..strtab_offset + strtab_size)
        .ok_or_else(|| anyhow!("alloc STRTAB slice out of range"))?;
    let needle = symbol_name.as_bytes();
    if needle.is_empty() || needle.len() > strtab_bytes.len() {
        return Ok(Vec::new());
    }

    let mut offsets = Vec::new();
    for index in 0..=strtab_bytes.len() - needle.len() {
        if &strtab_bytes[index..index + needle.len()] != needle {
            continue;
        }
        let prev_ok = index == 0 || strtab_bytes[index - 1] == 0;
        let next_index = index + needle.len();
        let next_ok = next_index == strtab_bytes.len() || strtab_bytes[next_index] == 0;
        if prev_ok && next_ok {
            offsets.push(index as u32);
        }
    }
    Ok(offsets)
}

fn find_executable_load_ranges(bytes: &[u8]) -> Result<Vec<(u64, u64)>> {
    let program_header_offset = read_u64(bytes, 32)? as usize;
    let program_header_size = read_u16(bytes, 54)? as usize;
    let program_header_count = read_u16(bytes, 56)? as usize;
    let mut ranges = Vec::new();

    for index in 0..program_header_count {
        let offset = program_header_offset + index * program_header_size;
        let typ = read_u32(bytes, offset)?;
        let flags = read_u32(bytes, offset + 4)?;
        if typ != 1 || (flags & 0x1) == 0 {
            continue;
        }
        let vaddr = read_u64(bytes, offset + 16)?;
        let memsz = read_u64(bytes, offset + 40)?;
        if memsz == 0 {
            continue;
        }
        ranges.push((vaddr, vaddr + memsz));
    }

    Ok(ranges)
}

fn looks_like_hidden_sym_entry_global(
    bytes: &[u8],
    offset: usize,
    strtab: (usize, usize),
    expected_st_name: u32,
    symbol_name: &str,
    executable_ranges: &[(u64, u64)],
) -> bool {
    let Ok(st_name) = read_u32(bytes, offset) else {
        return false;
    };
    if st_name != expected_st_name {
        return false;
    }
    let st_info = *bytes.get(offset + 4).unwrap_or(&0xff);
    let st_other = *bytes.get(offset + 5).unwrap_or(&0xff);
    let Ok(st_shndx) = read_u16(bytes, offset + 6) else {
        return false;
    };
    let Ok(st_value) = read_u64(bytes, offset + 8) else {
        return false;
    };
    let Ok(st_size) = read_u64(bytes, offset + 16) else {
        return false;
    };

    if st_other != 0 || st_shndx == 0 || st_shndx >= 0x1000 || st_value == 0 || st_size == 0 {
        return false;
    }
    if (st_info & 0x0f) != 0x02 || (st_info >> 4) == 0 {
        return false;
    }

    let (strtab_offset, strtab_size) = strtab;
    if st_name as usize >= strtab_size {
        return false;
    }
    let name_start = strtab_offset + st_name as usize;
    let Some(name_end_rel) = bytes
        .get(name_start..)
        .and_then(|slice| slice.iter().position(|byte| *byte == 0))
    else {
        return false;
    };
    let name_end = name_start + name_end_rel;
    if bytes.get(name_start..name_end) != Some(symbol_name.as_bytes()) {
        return false;
    }

    executable_ranges.is_empty()
        || executable_ranges
            .iter()
            .any(|(start, end)| st_value >= *start && st_value < *end)
}

fn find_alloc_strtab(bytes: &[u8]) -> Result<(usize, usize)> {
    let section_header_offset = read_u64(bytes, 40)? as usize;
    let section_header_size = read_u16(bytes, 58)? as usize;
    let section_count = read_u16(bytes, 60)? as usize;

    for index in 0..section_count {
        let offset = section_header_offset + index * section_header_size;
        let typ = read_u32(bytes, offset + 4)?;
        let flags = read_u64(bytes, offset + 8)?;
        if typ == 3 && (flags & 0x2) != 0 {
            let section_offset = read_u64(bytes, offset + 24)? as usize;
            let section_size = read_u64(bytes, offset + 32)? as usize;
            return Ok((section_offset, section_size));
        }
    }

    Err(anyhow!("failed to locate alloc STRTAB"))
}

fn infer_hidden_symtab_region(
    bytes: &[u8],
    strtab_offset: usize,
    strtab_size: usize,
) -> Option<(usize, usize)> {
    const ELF64_SYM_ENTRY_SIZE: usize = 24;
    if strtab_offset < ELF64_SYM_ENTRY_SIZE {
        return None;
    }

    let mut sym_offset = strtab_offset - ELF64_SYM_ENTRY_SIZE;
    if !looks_like_hidden_sym_entry(bytes, sym_offset, strtab_size) {
        return None;
    }

    while sym_offset >= ELF64_SYM_ENTRY_SIZE
        && looks_like_hidden_sym_entry(bytes, sym_offset - ELF64_SYM_ENTRY_SIZE, strtab_size)
    {
        sym_offset -= ELF64_SYM_ENTRY_SIZE;
    }

    Some((
        sym_offset,
        (strtab_offset - sym_offset) / ELF64_SYM_ENTRY_SIZE,
    ))
}

fn looks_like_hidden_sym_entry(bytes: &[u8], offset: usize, strtab_size: usize) -> bool {
    let Ok(st_name) = read_u32(bytes, offset) else {
        return false;
    };
    let st_info = *bytes.get(offset + 4).unwrap_or(&0xff);
    let st_other = *bytes.get(offset + 5).unwrap_or(&0xff);
    let Ok(st_shndx) = read_u16(bytes, offset + 6) else {
        return false;
    };
    let Ok(st_value) = read_u64(bytes, offset + 8) else {
        return false;
    };
    let Ok(st_size) = read_u64(bytes, offset + 16) else {
        return false;
    };

    if st_name == 0
        && st_info == 0
        && st_other == 0
        && st_shndx == 0
        && st_value == 0
        && st_size == 0
    {
        return true;
    }

    (st_name as usize) < strtab_size
        && st_other == 0
        && st_shndx < 0x1000
        && st_value < 0x0400_0000
        && st_size < 0x0010_0000
}

fn read_u16(bytes: &[u8], offset: usize) -> Result<u16> {
    let slice = bytes
        .get(offset..offset + 2)
        .ok_or_else(|| anyhow!("u16 read out of range at offset 0x{offset:x}"))?;
    Ok(u16::from_le_bytes(slice.try_into().unwrap()))
}

fn read_u32(bytes: &[u8], offset: usize) -> Result<u32> {
    let slice = bytes
        .get(offset..offset + 4)
        .ok_or_else(|| anyhow!("u32 read out of range at offset 0x{offset:x}"))?;
    Ok(u32::from_le_bytes(slice.try_into().unwrap()))
}

fn read_u64(bytes: &[u8], offset: usize) -> Result<u64> {
    let slice = bytes
        .get(offset..offset + 8)
        .ok_or_else(|| anyhow!("u64 read out of range at offset 0x{offset:x}"))?;
    Ok(u64::from_le_bytes(slice.try_into().unwrap()))
}

fn normalize_backend_name(value: &str) -> Result<&'static str> {
    BackendKind::parse(value)
        .map(BackendKind::as_str)
        .ok_or_else(|| anyhow!("unsupported backend: {value}"))
}

fn required_option(opts: &HashMap<String, String>, key: &str) -> Result<String> {
    opts.get(key)
        .cloned()
        .filter(|value| !value.trim().is_empty())
        .ok_or_else(|| anyhow!("missing required option: {key}"))
}

fn render_captcha_ui_debug_banner(stage1_obj: &Map<String, Value>) {
    eprintln!("[captcha-ui-debug] manual UI session");
    eprintln!("[captcha-ui-debug] first-send key fields:");
    for key in [
        "mobile",
        "countryCode",
        "verifyStatus",
        "rid",
        "modeType",
        "diffTime",
    ] {
        let text = stage1_obj
            .get(key)
            .map(value_to_compact_text)
            .unwrap_or_else(|| "<missing>".to_string());
        eprintln!("  - {key}: {text}");
    }
}

fn prompt_text_with_default(label: &str, default: &str) -> Result<String> {
    eprint!("{label} [{default}]: ");
    io::stderr().flush()?;
    let mut line = String::new();
    io::stdin()
        .read_line(&mut line)
        .with_context(|| format!("failed to read input for {label}"))?;
    let trimmed = line.trim();
    if trimmed.is_empty() {
        Ok(default.to_string())
    } else {
        Ok(trimmed.to_string())
    }
}

fn prompt_bool_with_default(label: &str, default: bool) -> Result<bool> {
    let default_hint = if default { "Y/n" } else { "y/N" };
    eprint!("{label} ({default_hint}): ");
    io::stderr().flush()?;
    let mut line = String::new();
    io::stdin()
        .read_line(&mut line)
        .with_context(|| format!("failed to read bool input for {label}"))?;
    let trimmed = line.trim();
    if trimmed.is_empty() {
        Ok(default)
    } else {
        Ok(parse_bool_like(trimmed))
    }
}

fn default_manual_rid() -> String {
    format!("manual{}", Utc::now().format("%Y%m%d%H%M%S"))
}

fn default_smcaptcha_html_path() -> PathBuf {
    PathBuf::from("/Users/haojiejack/github/drizzle-dumper-rust/artifacts/palmchat_apponly_jadx_20260324_230038/resources/assets/smcaptcha.html")
}

fn launch_captcha_ui_form_browser(
    stage1_value: &Value,
    default_verify_status: bool,
    default_rid: &str,
    default_mode_type: &str,
    default_diff_time: &str,
    flow_enabled: bool,
) -> Result<CaptchaUiDebugLaunch> {
    let listener =
        TcpListener::bind("127.0.0.1:0").context("failed to bind local browser ui listener")?;
    let addr = listener
        .local_addr()
        .context("failed to resolve browser ui listener address")?;
    let url = format!("http://{}", addr);
    let html = build_captcha_ui_form_html(
        stage1_value,
        default_verify_status,
        default_rid,
        default_mode_type,
        default_diff_time,
        flow_enabled,
    )?;
    eprintln!("[captcha-ui-debug] form browser ui: {url}");
    if let Err(err) = open_url_in_browser(&url) {
        eprintln!("[captcha-ui-debug] browser open failed: {err:#}");
        eprintln!("[captcha-ui-debug] open this URL manually: {url}");
    }

    loop {
        let (mut stream, _) = listener
            .accept()
            .context("failed to accept browser ui request")?;
        let Some((method, path, body)) = read_http_request(&mut stream)? else {
            continue;
        };
        let canonical_path = canonical_http_path(&path);
        match (method.as_str(), canonical_path.as_str()) {
            ("GET", "/") => {
                write_http_response(
                    &mut stream,
                    "200 OK",
                    "text/html; charset=utf-8",
                    html.as_bytes(),
                )?;
            }
            ("OPTIONS", "/submit") => {
                write_http_response(&mut stream, "204 No Content", "text/plain", b"")?;
            }
            ("GET", "/favicon.ico") => {
                write_http_response(&mut stream, "204 No Content", "text/plain", b"")?;
            }
            ("POST", "/submit") => {
                let payload = if body.is_empty() {
                    json!({})
                } else {
                    serde_json::from_slice::<Value>(&body)
                        .context("failed to parse browser ui submission json")?
                };
                let verify_status = payload
                    .get("verifyStatus")
                    .map(|value| match value {
                        Value::Bool(v) => *v,
                        Value::String(v) => parse_bool_like(v),
                        _ => false,
                    })
                    .unwrap_or(default_verify_status);
                let rid = payload
                    .get("rid")
                    .and_then(Value::as_str)
                    .unwrap_or(default_rid)
                    .to_string();
                let mode_type = payload
                    .get("modeType")
                    .and_then(Value::as_str)
                    .unwrap_or(default_mode_type)
                    .to_string();
                let diff_time = payload
                    .get("diffTime")
                    .and_then(Value::as_str)
                    .unwrap_or(default_diff_time)
                    .to_string();
                let submission = CaptchaUiDebugSubmission {
                    verify_status,
                    rid,
                    mode_type,
                    diff_time,
                };
                let response = json!({
                    "status": "ok",
                    "message": "captcha ui submission received; returning to data flow observation",
                    "submission": submission.clone(),
                });
                write_http_response(
                    &mut stream,
                    "200 OK",
                    "application/json; charset=utf-8",
                    serde_json::to_string_pretty(&response)?.as_bytes(),
                )?;
                return Ok(CaptchaUiDebugLaunch {
                    submission,
                    extra_events: vec![json!({
                        "ts": iso_now(),
                        "phase": "ui_form_submit",
                        "source": "form_browser",
                        "flow_enabled": flow_enabled,
                    })],
                    ui_mode: "form".to_string(),
                    ui_source: "form_manual".to_string(),
                });
            }
            _ => {
                write_http_response(
                    &mut stream,
                    "404 Not Found",
                    "text/plain; charset=utf-8",
                    b"not found",
                )?;
            }
        }
    }
}

fn launch_captcha_ui_sdk_browser(
    stage1_value: &Value,
    default_verify_status: bool,
    default_rid: &str,
    default_mode_type: &str,
    default_diff_time: &str,
    sdk_backfill_wait_ms: u64,
    flow_enabled: bool,
    sdk_html_path: &Path,
) -> Result<CaptchaUiDebugLaunch> {
    let original_html = load_original_smcaptcha_html(sdk_html_path)?;
    let listener =
        TcpListener::bind("127.0.0.1:0").context("failed to bind local sdk captcha ui listener")?;
    let addr = listener
        .local_addr()
        .context("failed to resolve sdk captcha ui listener address")?;
    let html = build_captcha_ui_sdk_html(
        &original_html,
        stage1_value,
        default_mode_type,
        flow_enabled,
        &format!("http://{}", addr),
    )?;
    let url = format!("http://{}", addr);
    eprintln!("[captcha-ui-debug] sdk browser ui: {url}");
    if let Err(err) = open_url_in_browser(&url) {
        eprintln!("[captcha-ui-debug] browser open failed: {err:#}");
        eprintln!("[captcha-ui-debug] open this URL manually: {url}");
    }

    let mut ready_ts_millis: Option<u128> = None;
    let mut pending_submission: Option<CaptchaUiDebugSubmission> = None;
    let mut pending_parsed_payload: Option<Value> = None;
    let mut bridge_seq: u64 = 0;
    let mut extra_events = vec![json!({
        "ts": iso_now(),
        "phase": "ui_sdk_asset_loaded",
        "sdk_html_path": sdk_html_path.display().to_string(),
        "modeType": default_mode_type,
        "flow_enabled": flow_enabled,
    })];

    loop {
        let (mut stream, _) = listener
            .accept()
            .context("failed to accept sdk captcha browser request")?;
        let Some((method, path, body)) = read_http_request(&mut stream)? else {
            continue;
        };
        let canonical_path = canonical_http_path(&path);
        match (method.as_str(), canonical_path.as_str()) {
            ("GET", "/") => {
                write_http_response(
                    &mut stream,
                    "200 OK",
                    "text/html; charset=utf-8",
                    html.as_bytes(),
                )?;
            }
            ("OPTIONS", "/bridge") | ("OPTIONS", "/submit") => {
                write_http_response(&mut stream, "204 No Content", "text/plain", b"")?;
            }
            ("GET", "/favicon.ico") => {
                write_http_response(&mut stream, "204 No Content", "text/plain", b"")?;
            }
            ("POST", "/bridge") => {
                let payload = if body.is_empty() {
                    json!({})
                } else {
                    serde_json::from_slice::<Value>(&body)
                        .context("failed to parse sdk bridge payload json")?
                };
                let event = payload
                    .get("event")
                    .and_then(Value::as_str)
                    .unwrap_or("unknown");
                let payload_value = payload.get("payload").cloned().unwrap_or(Value::Null);
                bridge_seq = bridge_seq.saturating_add(1);
                extra_events.push(json!({
                    "ts": iso_now(),
                    "phase": "ui_sdk_bridge_event",
                    "seq": bridge_seq,
                    "event": event,
                    "payload": payload_value,
                }));
                match event {
                    "onReady" => {
                        ready_ts_millis = Some(current_timestamp_millis());
                        if let Some(submission) = pending_submission.take() {
                            extra_events.push(json!({
                                "ts": iso_now(),
                                "phase": "ui_sdk_sync_release",
                                "reason": "onReady_arrived_after_onData",
                                "submission": submission,
                            }));
                            if submission.verify_status {
                                let parsed_payload =
                                    pending_parsed_payload.take().unwrap_or_else(|| json!({}));
                                extra_events.push(json!({
                                    "ts": iso_now(),
                                    "phase": "ui_sdk_bridge_data_parsed",
                                    "parsed_payload": parsed_payload,
                                    "submission": submission,
                                }));
                                let response = json!({
                                    "status": "ok",
                                    "event": "onReady",
                                    "release": true,
                                });
                                write_http_response(
                                    &mut stream,
                                    "200 OK",
                                    "application/json; charset=utf-8",
                                    serde_json::to_string_pretty(&response)?.as_bytes(),
                                )?;
                                return Ok(CaptchaUiDebugLaunch {
                                    submission,
                                    extra_events,
                                    ui_mode: "sdk".to_string(),
                                    ui_source: "sdk_bridge".to_string(),
                                });
                            }
                            pending_parsed_payload = None;
                        }
                        write_http_response(
                            &mut stream,
                            "200 OK",
                            "application/json; charset=utf-8",
                            br#"{"status":"ok","event":"onReady"}"#,
                        )?;
                    }
                    "onError" => {
                        write_http_response(
                            &mut stream,
                            "200 OK",
                            "application/json; charset=utf-8",
                            br#"{"status":"ok","event":"onError"}"#,
                        )?;
                    }
                    "onData" => {
                        let raw = payload
                            .get("payload")
                            .and_then(Value::as_object)
                            .and_then(|obj| obj.get("raw"))
                            .and_then(Value::as_str)
                            .unwrap_or_default();
                        let parsed_payload = parse_captcha_bridge_payload(raw);
                        let verify_status = parsed_payload
                            .get("pass")
                            .and_then(Value::as_bool)
                            .unwrap_or(default_verify_status);
                        let rid = parsed_payload
                            .get("rid")
                            .and_then(Value::as_str)
                            .filter(|value| !value.trim().is_empty())
                            .unwrap_or(default_rid)
                            .to_string();
                        let mut elapsed_after_ready = ready_ts_millis
                            .map(|start| current_timestamp_millis().saturating_sub(start));
                        if let Some(elapsed) = elapsed_after_ready.as_mut() {
                            let min_wait = sdk_backfill_wait_ms as u128;
                            if *elapsed < min_wait {
                                let wait_ms = (min_wait - *elapsed) as u64;
                                std::thread::sleep(Duration::from_millis(wait_ms));
                                *elapsed = ready_ts_millis
                                    .map(|start| current_timestamp_millis().saturating_sub(start))
                                    .unwrap_or(*elapsed);
                                extra_events.push(json!({
                                    "ts": iso_now(),
                                    "phase": "ui_sdk_backfill_wait",
                                    "wait_ms": wait_ms,
                                    "elapsed_after_wait": *elapsed,
                                }));
                            }
                        }
                        let payload_diff_time = parsed_payload
                            .get("diffTime")
                            .and_then(Value::as_str)
                            .filter(|value| !value.trim().is_empty())
                            .map(str::to_string);
                        let diff_time = match (payload_diff_time, elapsed_after_ready) {
                            (Some(raw), Some(elapsed)) => match raw.trim().parse::<u128>() {
                                Ok(parsed_ms) if parsed_ms < elapsed => elapsed.to_string(),
                                _ => raw,
                            },
                            (Some(raw), None) => raw,
                            (None, Some(elapsed)) => elapsed.to_string(),
                            (None, None) => default_diff_time.to_string(),
                        };
                        let submission = CaptchaUiDebugSubmission {
                            verify_status,
                            rid,
                            mode_type: default_mode_type.to_string(),
                            diff_time,
                        };
                        if ready_ts_millis.is_none() {
                            pending_submission = Some(submission.clone());
                            pending_parsed_payload = Some(parsed_payload.clone());
                            extra_events.push(json!({
                                "ts": iso_now(),
                                "phase": "ui_sdk_sync_hold",
                                "reason": "await_onReady",
                                "submission": submission,
                            }));
                            let response = json!({
                                "status": "hold",
                                "event": "onData",
                                "reason": "await_onReady",
                            });
                            write_http_response(
                                &mut stream,
                                "200 OK",
                                "application/json; charset=utf-8",
                                serde_json::to_string_pretty(&response)?.as_bytes(),
                            )?;
                            continue;
                        }
                        extra_events.push(json!({
                            "ts": iso_now(),
                            "phase": "ui_sdk_bridge_data_parsed",
                            "parsed_payload": parsed_payload,
                            "submission": submission,
                        }));
                        let response = json!({
                            "status": "ok",
                            "event": "onData",
                            "verifyStatus": verify_status,
                        });
                        write_http_response(
                            &mut stream,
                            "200 OK",
                            "application/json; charset=utf-8",
                            serde_json::to_string_pretty(&response)?.as_bytes(),
                        )?;
                        if verify_status {
                            return Ok(CaptchaUiDebugLaunch {
                                submission,
                                extra_events,
                                ui_mode: "sdk".to_string(),
                                ui_source: "sdk_bridge".to_string(),
                            });
                        }
                    }
                    _ => {
                        write_http_response(
                            &mut stream,
                            "200 OK",
                            "application/json; charset=utf-8",
                            br#"{"status":"ok","event":"ignored"}"#,
                        )?;
                    }
                }
            }
            ("POST", "/submit") => {
                let payload = if body.is_empty() {
                    json!({})
                } else {
                    serde_json::from_slice::<Value>(&body)
                        .context("failed to parse sdk manual submission json")?
                };
                let verify_status = payload
                    .get("verifyStatus")
                    .map(|value| match value {
                        Value::Bool(v) => *v,
                        Value::String(v) => parse_bool_like(v),
                        _ => false,
                    })
                    .unwrap_or(default_verify_status);
                let rid = payload
                    .get("rid")
                    .and_then(Value::as_str)
                    .unwrap_or(default_rid)
                    .to_string();
                let mode_type = payload
                    .get("modeType")
                    .and_then(Value::as_str)
                    .unwrap_or(default_mode_type)
                    .to_string();
                let diff_time = payload
                    .get("diffTime")
                    .and_then(Value::as_str)
                    .unwrap_or(default_diff_time)
                    .to_string();
                let submission = CaptchaUiDebugSubmission {
                    verify_status,
                    rid,
                    mode_type,
                    diff_time,
                };
                extra_events.push(json!({
                    "ts": iso_now(),
                    "phase": "ui_sdk_manual_submit",
                    "submission": submission,
                }));
                write_http_response(
                    &mut stream,
                    "200 OK",
                    "application/json; charset=utf-8",
                    br#"{"status":"ok","event":"manual_submit"}"#,
                )?;
                return Ok(CaptchaUiDebugLaunch {
                    submission,
                    extra_events,
                    ui_mode: "sdk".to_string(),
                    ui_source: "sdk_manual_submit".to_string(),
                });
            }
            _ => {
                write_http_response(
                    &mut stream,
                    "404 Not Found",
                    "text/plain; charset=utf-8",
                    b"not found",
                )?;
            }
        }
    }
}

fn build_captcha_ui_form_html(
    stage1_value: &Value,
    default_verify_status: bool,
    default_rid: &str,
    default_mode_type: &str,
    default_diff_time: &str,
    flow_enabled: bool,
) -> Result<String> {
    let stage1_pretty = serde_json::to_string_pretty(stage1_value)?;
    let stage1_json_literal = stage1_value.to_string().replace("</script>", "<\\/script>");
    let html = format!(
        r#"<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Palmchat Captcha UI Debug</title>
  <style>
    :root {{
      --bg: #0f1115;
      --panel: #171a21;
      --panel-2: #1e232d;
      --text: #eef2f7;
      --muted: #8e9aab;
      --accent: #6ee7b7;
      --accent-2: #60a5fa;
      --warn: #f59e0b;
      --border: #2a3240;
    }}
    body {{
      margin: 0;
      font-family: Menlo, Monaco, monospace;
      background: radial-gradient(circle at top, #1a2230 0%, var(--bg) 55%);
      color: var(--text);
    }}
    .wrap {{
      max-width: 1100px;
      margin: 32px auto;
      padding: 0 20px 40px;
    }}
    .hero {{
      padding: 20px 24px;
      border: 1px solid var(--border);
      background: linear-gradient(135deg, rgba(96,165,250,0.18), rgba(110,231,183,0.08));
      border-radius: 18px;
      margin-bottom: 20px;
    }}
    .grid {{
      display: grid;
      grid-template-columns: 1.1fr 0.9fr;
      gap: 20px;
    }}
    .panel {{
      background: var(--panel);
      border: 1px solid var(--border);
      border-radius: 18px;
      padding: 18px;
      box-shadow: 0 12px 48px rgba(0,0,0,0.24);
    }}
    h1, h2 {{
      margin: 0 0 12px;
      font-weight: 700;
    }}
    .muted {{
      color: var(--muted);
    }}
    textarea, input {{
      width: 100%;
      box-sizing: border-box;
      border-radius: 12px;
      border: 1px solid var(--border);
      background: var(--panel-2);
      color: var(--text);
      padding: 12px;
      font: inherit;
    }}
    textarea {{
      min-height: 360px;
      resize: vertical;
    }}
    .row {{
      display: grid;
      grid-template-columns: repeat(2, 1fr);
      gap: 12px;
      margin-bottom: 12px;
    }}
    .toggle {{
      display: flex;
      align-items: center;
      gap: 10px;
      margin: 12px 0 18px;
      color: var(--text);
    }}
    button {{
      border: 0;
      border-radius: 999px;
      background: linear-gradient(90deg, var(--accent), var(--accent-2));
      color: #0b1220;
      font: inherit;
      font-weight: 700;
      padding: 12px 18px;
      cursor: pointer;
    }}
    pre {{
      margin: 0;
      white-space: pre-wrap;
      word-break: break-word;
      background: #0b0e13;
      border: 1px solid var(--border);
      border-radius: 12px;
      padding: 14px;
      min-height: 160px;
    }}
    .badge {{
      display: inline-block;
      padding: 4px 10px;
      border-radius: 999px;
      background: rgba(245,158,11,0.14);
      color: var(--warn);
      border: 1px solid rgba(245,158,11,0.25);
      margin-top: 10px;
    }}
  </style>
</head>
<body>
  <div class="wrap">
    <div class="hero">
      <h1>Palmchat Captcha UI Debug</h1>
      <div class="muted">This page represents the 1900 captcha branch at the UI layer. Submit the retry tuple, then the CLI returns to the native data flow observation.</div>
      <div class="badge">flow enabled: {flow_enabled}</div>
    </div>
    <div class="grid">
      <div class="panel">
        <h2>Stage1 Body</h2>
        <div class="muted">First sendsms body before captcha retry patch.</div>
        <textarea readonly>{stage1_pretty}</textarea>
      </div>
      <div class="panel">
        <h2>Manual Retry Tuple</h2>
        <div class="muted">Fill the fields that correspond to CaptchaResult -> nz.a retry patch.</div>
        <label class="toggle">
          <input id="verifyStatus" type="checkbox" {verify_checked}>
          <span>verifyStatus = true</span>
        </label>
        <div class="row">
          <div>
            <div class="muted">rid</div>
            <input id="rid" value="{rid}">
          </div>
          <div>
            <div class="muted">modeType</div>
            <input id="modeType" value="{mode_type}">
          </div>
        </div>
        <div style="margin-bottom: 12px;">
          <div class="muted">diffTime(ms)</div>
          <input id="diffTime" value="{diff_time}">
        </div>
        <button id="submit">Submit Retry Patch</button>
        <div style="height: 16px;"></div>
        <h2>Submit Result</h2>
        <pre id="result">Waiting for submission...</pre>
      </div>
    </div>
  </div>
  <script id="stage1-json" type="application/json">{stage1_json_literal}</script>
  <script>
    const submitBtn = document.getElementById('submit');
    const resultBox = document.getElementById('result');
    submitBtn.addEventListener('click', async () => {{
      const payload = {{
        verifyStatus: document.getElementById('verifyStatus').checked,
        rid: document.getElementById('rid').value,
        modeType: document.getElementById('modeType').value,
        diffTime: document.getElementById('diffTime').value
      }};
      resultBox.textContent = 'Submitting...';
      try {{
        const res = await fetch('/submit', {{
          method: 'POST',
          headers: {{ 'Content-Type': 'application/json' }},
          body: JSON.stringify(payload)
        }});
        resultBox.textContent = await res.text();
      }} catch (err) {{
        resultBox.textContent = String(err);
      }}
    }});
  </script>
</body>
</html>
"#,
        flow_enabled = flow_enabled,
        stage1_pretty = html_escape(&stage1_pretty),
        verify_checked = if default_verify_status { "checked" } else { "" },
        rid = html_escape(default_rid),
        mode_type = html_escape(default_mode_type),
        diff_time = html_escape(default_diff_time),
        stage1_json_literal = stage1_json_literal,
    );
    Ok(html)
}

fn load_original_smcaptcha_html(path: &Path) -> Result<String> {
    fs::read_to_string(path)
        .with_context(|| format!("failed to read smcaptcha html asset: {}", path.display()))
}

fn build_captcha_ui_sdk_html(
    original_html: &str,
    stage1_value: &Value,
    mode_type: &str,
    flow_enabled: bool,
    bridge_base_url: &str,
) -> Result<String> {
    let stage1_pretty = serde_json::to_string_pretty(stage1_value)?;
    let stage1_json_literal = stage1_value.to_string().replace("</script>", "<\\/script>");
    let mode_type_literal = serde_json::to_string(mode_type)?;
    let bridge_endpoint_literal = serde_json::to_string(&format!("{bridge_base_url}/bridge"))?;
    let patched_mode_html = original_html
        .replace("xxxxxxxxxxxxxxxxxxxx", mode_type)
        .replace(
            "http://apps.bdimg.com/libs/jquery/1.9.0/jquery.js",
            "https://apps.bdimg.com/libs/jquery/1.9.0/jquery.min.js",
        );
    let injected = format!(
        r#"
<div id="codex-debug-panel" style="position:fixed;right:10px;bottom:10px;z-index:99999;width:360px;background:rgba(16,20,27,0.92);color:#e6edf3;border:1px solid #2f3a4d;border-radius:12px;padding:10px;font:12px/1.4 Menlo,Monaco,monospace;">
  <div style="font-weight:700;margin-bottom:6px;">Palmchat SDK Captcha Debug Surface</div>
  <div style="margin-bottom:6px;opacity:.9;">modeType=<span id="codex-mode-type"></span> flow=<span id="codex-flow-enabled"></span></div>
  <div style="max-height:140px;overflow:auto;background:#0b1118;border:1px solid #253041;border-radius:8px;padding:6px;white-space:pre-wrap;">{stage1_pretty}</div>
  <div id="codex-bridge-status" style="margin-top:6px;color:#8b949e;">bridge: waiting...</div>
</div>
<script id="codex-stage1-json" type="application/json">{stage1_json_literal}</script>
<script>
(function() {{
  const MODE_TYPE = {mode_type_literal};
  const FLOW_ENABLED = {flow_enabled};
  const BRIDGE_ENDPOINT = {bridge_endpoint_literal};
  const statusEl = document.getElementById('codex-bridge-status');
  document.getElementById('codex-mode-type').textContent = MODE_TYPE;
  document.getElementById('codex-flow-enabled').textContent = String(FLOW_ENABLED);
  if (typeof window.$ !== 'function') {{
    window.$ = function(input) {{
      function wrap(nodes) {{
        const list = Array.isArray(nodes) ? nodes : [];
        const api = {{
          length: list.length,
          find: function(selector) {{
            const found = [];
            list.forEach(function(node) {{
              if (node && node.querySelectorAll) {{
                found.push.apply(found, Array.from(node.querySelectorAll(selector)));
              }}
            }});
            return wrap(found);
          }}
        }};
        list.forEach(function(node, index) {{
          api[index] = node;
        }});
        return api;
      }}
      if (typeof input === 'function') {{
        if (document.readyState === 'loading') {{
          document.addEventListener('DOMContentLoaded', input, {{ once: true }});
        }} else {{
          input();
        }}
        return wrap([]);
      }}
      if (typeof input === 'string') {{
        return wrap(Array.from(document.querySelectorAll(input)));
      }}
      if (input && input.nodeType === 1) {{
        return wrap([input]);
      }}
      return wrap([]);
    }};
  }}
  function updateStatus(text) {{
    if (statusEl) statusEl.textContent = text;
  }}
  async function postBridge(event, payload) {{
    try {{
      await fetch(BRIDGE_ENDPOINT, {{
        method: 'POST',
        headers: {{ 'Content-Type': 'application/json' }},
        body: JSON.stringify({{ event: event, payload: payload, ts: Date.now() }})
      }});
      updateStatus('bridge: ' + event);
    }} catch (err) {{
      updateStatus('bridge error: ' + String(err));
    }}
  }}
  window.jsBridge = {{
    onReady: function() {{
      postBridge('onReady', {{ ready: true }});
    }},
    onData: function(data) {{
      postBridge('onData', {{ raw: data }});
    }},
    onError: function(err) {{
      postBridge('onError', {{ raw: err }});
    }}
  }};
  window.addEventListener('error', function(evt) {{
    postBridge('page_error', {{
      message: evt && evt.message ? String(evt.message) : '',
      source: evt && evt.filename ? String(evt.filename) : '',
      lineno: evt && evt.lineno ? Number(evt.lineno) : 0,
      colno: evt && evt.colno ? Number(evt.colno) : 0
    }});
  }}, true);
  window.addEventListener('unhandledrejection', function(evt) {{
    const reason = evt && typeof evt.reason !== 'undefined' ? String(evt.reason) : '';
    postBridge('promise_reject', {{ reason: reason }});
  }});
  setTimeout(function() {{
    postBridge('sdk_runtime_probe', {{
      hasInitSMCaptcha: typeof window.initSMCaptcha === 'function',
      hasDollar: typeof window.$ === 'function'
    }});
  }}, 1200);
  postBridge('sdk_page_loaded', {{ modeType: MODE_TYPE }});
}})();
</script>
"#,
        stage1_pretty = html_escape(&stage1_pretty),
        stage1_json_literal = stage1_json_literal,
        mode_type_literal = mode_type_literal,
        flow_enabled = if flow_enabled { "true" } else { "false" },
        bridge_endpoint_literal = bridge_endpoint_literal,
    );
    if patched_mode_html.contains("</body>") {
        Ok(patched_mode_html.replacen("</body>", &(injected + "\n</body>"), 1))
    } else {
        Ok(format!("{patched_mode_html}\n{injected}"))
    }
}

fn parse_captcha_bridge_payload(raw: &str) -> Value {
    let trimmed = raw.trim();
    if trimmed.is_empty() {
        return json!({});
    }
    if let Ok(value) = serde_json::from_str::<Value>(trimmed) {
        return value;
    }
    if let Some(value) = parse_json_like_with_boa(trimmed) {
        return value;
    }
    json!({ "raw": trimmed })
}

fn parse_json_like_with_boa(raw: &str) -> Option<Value> {
    let mut context = BoaContext::default();
    let raw_literal = serde_json::to_string(raw).ok()?;
    let script = format!(
        "(() => {{
            const __raw = {raw_literal};
            try {{
              return JSON.stringify(JSON.parse(__raw));
            }} catch (e) {{
              try {{
                return JSON.stringify((0, eval)('(' + __raw + ')'));
              }} catch (e2) {{
                return '';
              }}
            }}
        }})()"
    );
    let value = context.eval(Source::from_bytes(&script)).ok()?;
    let normalized = value.to_string(&mut context).ok()?.to_std_string_escaped();
    if normalized.trim().is_empty() {
        return None;
    }
    serde_json::from_str::<Value>(&normalized).ok()
}

fn current_timestamp_millis() -> u128 {
    SystemTime::now()
        .duration_since(UNIX_EPOCH)
        .unwrap_or_default()
        .as_millis()
}

fn override_palmchat_ck_version(default_value: String) -> String {
    std::env::var("PALMCHAT_FORCE_CK_VERSION")
        .ok()
        .map(|value| value.trim().to_string())
        .filter(|value| !value.is_empty())
        .unwrap_or(default_value)
}

fn open_url_in_browser(url: &str) -> Result<()> {
    #[cfg(target_os = "macos")]
    let mut cmd = {
        let mut cmd = Command::new("open");
        cmd.arg(url);
        cmd
    };
    #[cfg(target_os = "linux")]
    let mut cmd = {
        let mut cmd = Command::new("xdg-open");
        cmd.arg(url);
        cmd
    };
    #[cfg(target_os = "windows")]
    let mut cmd = {
        let mut cmd = Command::new("cmd");
        cmd.args(["/C", "start", "", url]);
        cmd
    };
    #[cfg(not(any(target_os = "macos", target_os = "linux", target_os = "windows")))]
    {
        return Err(anyhow!("unsupported desktop platform for browser open"));
    }
    #[cfg(any(target_os = "macos", target_os = "linux", target_os = "windows"))]
    {
        cmd.spawn()
            .with_context(|| format!("failed to spawn browser opener for {url}"))?;
        Ok(())
    }
}

fn read_http_request(stream: &mut TcpStream) -> Result<Option<(String, String, Vec<u8>)>> {
    let mut buffer = Vec::new();
    let mut header_end = None;
    let mut content_length = 0usize;
    loop {
        let mut chunk = [0u8; 4096];
        let read = stream
            .read(&mut chunk)
            .context("failed to read browser ui request")?;
        if read == 0 {
            break;
        }
        buffer.extend_from_slice(&chunk[..read]);
        if header_end.is_none() {
            header_end = find_header_end(&buffer);
            if let Some(end) = header_end {
                let headers_text = String::from_utf8_lossy(&buffer[..end]);
                content_length = parse_content_length(&headers_text);
                if buffer.len() >= end + content_length {
                    break;
                }
            }
        } else if let Some(end) = header_end {
            if buffer.len() >= end + content_length {
                break;
            }
        }
    }
    let Some(header_end) = header_end else {
        return Ok(None);
    };
    let header_text = String::from_utf8_lossy(&buffer[..header_end]);
    let mut lines = header_text.lines();
    let Some(request_line) = lines.next() else {
        return Ok(None);
    };
    let mut parts = request_line.split_whitespace();
    let method = parts.next().unwrap_or_default().to_string();
    let path = parts.next().unwrap_or("/").to_string();
    let body = buffer
        .get(header_end..header_end + content_length)
        .unwrap_or(&[])
        .to_vec();
    Ok(Some((method, path, body)))
}

fn canonical_http_path(path: &str) -> String {
    let mut normalized = path.trim().to_string();
    if let Ok(url) = Url::parse(&normalized) {
        normalized = url.path().to_string();
        if let Some(query) = url.query() {
            normalized.push('?');
            normalized.push_str(query);
        }
    }
    let no_fragment = normalized.split('#').next().unwrap_or_default();
    let no_query = no_fragment.split('?').next().unwrap_or("/");
    let mut trimmed = no_query.trim_end_matches('/').to_string();
    if trimmed.is_empty() {
        trimmed = "/".to_string();
    }
    trimmed
}

fn find_header_end(buffer: &[u8]) -> Option<usize> {
    buffer
        .windows(4)
        .position(|window| window == b"\r\n\r\n")
        .map(|idx| idx + 4)
}

fn parse_content_length(headers: &str) -> usize {
    headers
        .lines()
        .find_map(|line| {
            let (name, value) = line.split_once(':')?;
            if name.trim().eq_ignore_ascii_case("Content-Length") {
                value.trim().parse::<usize>().ok()
            } else {
                None
            }
        })
        .unwrap_or(0)
}

fn write_http_response(
    stream: &mut TcpStream,
    status: &str,
    content_type: &str,
    body: &[u8],
) -> Result<()> {
    write_http_response_with_headers(stream, status, content_type, body, &[])
}

fn write_http_response_with_headers(
    stream: &mut TcpStream,
    status: &str,
    content_type: &str,
    body: &[u8],
    extra_headers: &[(&str, &str)],
) -> Result<()> {
    let mut header_block = format!(
        "HTTP/1.1 {status}\r\nContent-Type: {content_type}\r\nContent-Length: {}\r\nConnection: close\r\nCache-Control: no-store\r\nAccess-Control-Allow-Origin: *\r\nAccess-Control-Allow-Methods: GET,POST,OPTIONS\r\nAccess-Control-Allow-Headers: Content-Type,Accept\r\nAccess-Control-Max-Age: 86400\r\n",
        body.len()
    );
    for (name, value) in extra_headers {
        header_block.push_str(name);
        header_block.push_str(": ");
        header_block.push_str(value);
        header_block.push_str("\r\n");
    }
    header_block.push_str("\r\n");
    write!(stream, "{header_block}").context("failed to write browser ui response header")?;
    stream
        .write_all(body)
        .context("failed to write browser ui response body")?;
    stream
        .flush()
        .context("failed to flush browser ui response")
}

fn html_escape(text: &str) -> String {
    text.replace('&', "&amp;")
        .replace('<', "&lt;")
        .replace('>', "&gt;")
        .replace('"', "&quot;")
}

fn value_to_compact_text(value: &Value) -> String {
    match value {
        Value::Null => "null".to_string(),
        Value::Bool(v) => v.to_string(),
        Value::Number(v) => v.to_string(),
        Value::String(v) => v.clone(),
        Value::Array(_) | Value::Object(_) => value.to_string(),
    }
}

fn parse_bool_like(text: &str) -> bool {
    let normalized = text.trim().to_ascii_lowercase();
    match normalized.as_str() {
        "" | "0" | "false" | "f" | "no" | "n" | "off" => false,
        "1" | "true" | "t" | "yes" | "y" | "on" => true,
        _ => true,
    }
}

fn parse_optional_bool_flag(value: Option<&str>) -> Option<bool> {
    value
        .map(str::trim)
        .filter(|value| !value.is_empty())
        .filter(|value| !value.eq_ignore_ascii_case("null"))
        .filter(|value| !value.eq_ignore_ascii_case("unknown"))
        .map(parse_bool_like)
}

fn normalize_locale_tag(raw: Option<&str>) -> Option<String> {
    let value = normalize_plain_candidate(raw.map(|value| value.to_string()))?;
    let first = value
        .split(',')
        .find_map(|item| {
            let trimmed = item.trim();
            if trimmed.is_empty() {
                None
            } else {
                Some(trimmed)
            }
        })
        .unwrap_or(value.as_str());
    Some(first.replace('-', "_"))
}

fn derive_display_density_string(raw_dpi: Option<&str>) -> Option<String> {
    let dpi = raw_dpi?.trim().parse::<f64>().ok()?;
    if dpi <= 0.0 {
        return None;
    }
    let density = dpi / 160.0;
    let rounded = density.round();
    if (density - rounded).abs() < 0.0001 {
        return Some(format!("{}", rounded as i64));
    }
    let mut text = format!("{density:.2}");
    while text.contains('.') && text.ends_with('0') {
        text.pop();
    }
    if text.ends_with('.') {
        text.pop();
    }
    Some(text)
}

fn header_map_to_json(headers: &HeaderMap) -> Value {
    let mut out = Map::new();
    for (name, value) in headers.iter() {
        out.insert(
            name.to_string(),
            Value::String(value.to_str().unwrap_or_default().to_string()),
        );
    }
    Value::Object(out)
}

fn header_map_to_string_map(headers: &HeaderMap) -> HashMap<String, String> {
    let mut out = HashMap::new();
    for (name, value) in headers.iter() {
        out.insert(
            name.to_string(),
            value.to_str().unwrap_or_default().to_string(),
        );
    }
    out
}

fn string_map_to_json(headers: &HashMap<String, String>) -> Value {
    let mut out = Map::new();
    for (name, value) in headers {
        out.insert(name.clone(), Value::String(value.clone()));
    }
    Value::Object(out)
}

fn json_value_to_string_map(value: Option<&Value>) -> HashMap<String, String> {
    value
        .and_then(Value::as_object)
        .map(|headers| {
            headers
                .iter()
                .filter_map(|(name, value)| {
                    value.as_str().map(|text| (name.clone(), text.to_string()))
                })
                .collect::<HashMap<_, _>>()
        })
        .unwrap_or_default()
}

fn header_value_case_insensitive(headers: &HashMap<String, String>, key: &str) -> Option<String> {
    headers
        .iter()
        .find(|(name, _)| name.eq_ignore_ascii_case(key))
        .map(|(_, value)| value.clone())
}

fn payload_body_bytes_from_transport_json(payload: &Value) -> Option<Vec<u8>> {
    payload
        .get("body_base64")
        .and_then(Value::as_str)
        .filter(|value| !value.trim().is_empty())
        .and_then(|value| BASE64_STANDARD.decode(value).ok())
        .or_else(|| {
            payload
                .get("body")
                .and_then(Value::as_str)
                .map(|value| value.as_bytes().to_vec())
        })
}

fn normalize_palmchat_bridge_url(url: &str) -> Result<String> {
    let trimmed = url.trim();
    if trimmed.is_empty() {
        return Err(anyhow!("empty bridge url"));
    }
    let parsed = Url::parse(trimmed).with_context(|| format!("invalid bridge url: {trimmed}"))?;
    match parsed.scheme() {
        "http" | "https" => Ok(trimmed.trim_end_matches('/').to_string()),
        other => Err(anyhow!("unsupported bridge url scheme: {other}")),
    }
}

fn palmchat_okhttp_bridge_health(base_url: &str) -> Result<Option<Value>> {
    let url = format!("{}/health", base_url.trim_end_matches('/'));
    let client = Client::builder()
        .timeout(Duration::from_secs(3))
        .build()
        .context("failed to build palmchat bridge health client")?;
    match client.get(&url).send() {
        Ok(response) if response.status().is_success() => {
            let payload: Value = response.json().with_context(|| {
                format!("failed to parse palmchat bridge health payload: {url}")
            })?;
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

fn palmchat_repo_root() -> PathBuf {
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
                truncate_text(&stderr, 1200),
                truncate_text(&stdout, 1200),
            ));
        }
        std::thread::sleep(Duration::from_millis(100));
    }
}

fn truncate_text(value: &str, max_len: usize) -> String {
    if value.len() <= max_len {
        return value.to_string();
    }
    let mut out = String::new();
    for ch in value.chars() {
        if out.len() + ch.len_utf8() > max_len {
            break;
        }
        out.push(ch);
    }
    out
}

fn build_palmchat_user_agent_zx_version(version_name: Option<&str>) -> Option<String> {
    let version_name = normalize_plain_candidate(version_name.map(|value| value.to_string()))?;
    Some(format!("Android/{version_name}"))
}

fn build_android_dalvik_user_agent(profile: Option<&PalmchatLiveDeviceProfile>) -> Option<String> {
    let profile = profile?;
    let release = normalize_plain_candidate(profile.build_release.clone())?;
    let model = normalize_plain_candidate(profile.product_model.clone())?;
    let build_id = normalize_plain_candidate(profile.build_id.clone())?;
    Some(format!(
        "Dalvik/2.1.0 (Linux; U; Android {release}; {model} Build/{build_id})"
    ))
}

fn sanitize_palmchat_ua_segment(value: String) -> String {
    value.replace('/', "_")
}

fn build_palmchat_user_agent_zx(
    profile: Option<&PalmchatLiveDeviceProfile>,
    app_version_info: &PalmchatAppVersionInfo,
    body_value: Option<&Value>,
) -> Option<String> {
    let profile = profile?;
    let brand =
        sanitize_palmchat_ua_segment(normalize_plain_candidate(profile.product_brand.clone())?);
    let model =
        sanitize_palmchat_ua_segment(normalize_plain_candidate(profile.product_model.clone())?);
    let release =
        sanitize_palmchat_ua_segment(normalize_plain_candidate(profile.build_release.clone())?);
    let version_code = normalize_plain_candidate(app_version_info.version_code.clone())?;
    let version_name = normalize_plain_candidate(app_version_info.version_name.clone())?;
    let locale = normalize_plain_candidate(profile.locale_tag.clone())?;
    let density = normalize_plain_candidate(profile.display_density.clone())?;
    let manufacturer = sanitize_palmchat_ua_segment(normalize_plain_candidate(
        profile.product_manufacturer.clone(),
    )?);
    let body_channel = body_value
        .and_then(Value::as_object)
        .and_then(|body| extract_non_empty_string(body, "channelId"));
    let channel_id =
        body_channel.or_else(|| normalize_plain_candidate(profile.channel_id.clone()))?;
    Some(format!(
        "{brand}/{model}/Android/{release}/{version_code}/{version_name}/{locale}/{density}x/{channel_id}/{manufacturer}"
    ))
}

fn build_smssend_url_auth_overrides_from_opts(
    opts: &HashMap<String, String>,
) -> PalmchatSmssendUrlAuth {
    PalmchatSmssendUrlAuth {
        uid: normalize_plain_candidate(opts.get("--uid").cloned()),
        token: normalize_plain_candidate(opts.get("--token").cloned()),
        session_id: normalize_plain_candidate(opts.get("--session-id").cloned()),
        callback_id: normalize_plain_candidate(opts.get("--callback-id").cloned()),
        p_id: normalize_plain_candidate(opts.get("--pid").cloned()),
        sys_uid: normalize_plain_candidate(opts.get("--sys-uid").cloned()),
    }
}

fn resolve_palmchat_recovered_auth_candidates(
    candidates: &PalmchatRecoveredAuthCandidates,
) -> (Option<String>, Option<String>, Option<String>, String) {
    let uid = candidates
        .cli_uid
        .clone()
        .or_else(|| candidates.live_uid.clone())
        .or_else(|| candidates.java_uid.clone());
    let session_id = candidates
        .cli_session_id
        .clone()
        .or_else(|| candidates.live_session_id.clone())
        .or_else(|| candidates.java_session_id.clone());
    let refresh_key = candidates
        .live_refresh_key
        .clone()
        .or_else(|| candidates.java_refresh_key.clone());
    let source = if candidates.cli_uid.is_some() || candidates.cli_session_id.is_some() {
        "cli_overrides"
    } else if candidates.live_uid.is_some()
        || candidates.live_session_id.is_some()
        || candidates.live_refresh_key.is_some()
    {
        "live_device_profile"
    } else {
        "java_account_utils"
    };
    (uid, session_id, refresh_key, source.to_string())
}

fn build_refresh_server_key_url(
    uid: &str,
    session_id: Option<&str>,
    exid: Option<&str>,
    device_id: &str,
    did: &str,
) -> String {
    let mut url = Url::parse("https://short.lianxinapp.com/one/ax/token.ak.v12")
        .expect("static refreshServerKey url should parse");
    {
        let mut query = url.query_pairs_mut();
        if !did.trim().is_empty() {
            query.append_pair("did", did);
        }
        if !uid.trim().is_empty() {
            query.append_pair("uid", uid);
        }
        if let Some(session_id) = session_id.filter(|value| !value.trim().is_empty()) {
            query.append_pair("sessionId", session_id);
        }
        query.append_pair("requestId", &generate_xn3_like_id());
        if let Some(exid) = exid.filter(|value| !value.trim().is_empty()) {
            query.append_pair("exid", exid);
        }
        if !device_id.trim().is_empty() {
            query.append_pair("deviceId", device_id);
        }
    }
    url.to_string()
}

fn merge_smssend_url_auth_sources(
    overrides: &PalmchatSmssendUrlAuth,
    recovered_auth: Option<&PalmchatRecoveredAuthState>,
    live_device_profile: Option<&PalmchatLiveDeviceProfile>,
    generated_token: Option<String>,
) -> PalmchatSmssendUrlAuth {
    PalmchatSmssendUrlAuth {
        uid: overrides
            .uid
            .clone()
            .or_else(|| {
                recovered_auth.and_then(|state| normalize_plain_candidate(state.uid.clone()))
            })
            .or_else(|| {
                live_device_profile
                    .and_then(|profile| normalize_plain_candidate(profile.account_uid.clone()))
            }),
        token: overrides
            .token
            .clone()
            .or_else(|| {
                recovered_auth.and_then(|state| {
                    normalize_plain_candidate(state.token_after_bootstrap.clone())
                })
            })
            .or(generated_token),
        session_id: overrides.session_id.clone().or_else(|| {
            recovered_auth.and_then(|state| normalize_plain_candidate(state.session_id.clone()))
        }),
        callback_id: overrides.callback_id.clone(),
        p_id: overrides.p_id.clone(),
        sys_uid: overrides.sys_uid.clone(),
    }
}

fn prepare_smssend_test_url_opts(
    stage1_obj: &Map<String, Value>,
    stage2_obj: &Map<String, Value>,
    opts: &mut HashMap<String, String>,
    auth: Option<&PalmchatSmssendUrlAuth>,
    live_device_profile: Option<&PalmchatLiveDeviceProfile>,
) -> Option<Value> {
    if !opts
        .get("--smssend-test")
        .map(|value| parse_bool_like(value))
        .unwrap_or(false)
    {
        return None;
    }
    if opts
        .get("--smssend-url")
        .map(|value| !value.trim().is_empty())
        .unwrap_or(false)
    {
        return None;
    }
    let request_id = opts
        .get("--request-id")
        .cloned()
        .filter(|value| !value.trim().is_empty())
        .unwrap_or_else(generate_xn3_like_id);
    let device_id = opts
        .get("--device-id")
        .cloned()
        .and_then(|value| normalize_device_id_candidate(Some(value.to_string())))
        .or_else(|| extract_non_empty_string(stage2_obj, "deviceId"))
        .or_else(|| extract_non_empty_string(stage2_obj, "dhid"))
        .or_else(|| extract_non_empty_string(stage1_obj, "deviceId"))
        .or_else(|| extract_non_empty_string(stage1_obj, "dhid"))
        .or_else(|| {
            live_device_profile.and_then(|profile| {
                normalize_device_id_candidate(profile.tray_device_id.clone())
                    .or_else(|| normalize_device_id_candidate(profile.sdid.clone()))
            })
        })
        .and_then(|value| normalize_device_id_candidate(Some(value)))
        .unwrap_or_else(generate_xn3_like_id);
    let base_url = opts
        .get("--smssend-base-url")
        .cloned()
        .filter(|value| !value.trim().is_empty())
        .unwrap_or_else(|| "https://short.lianxinapp.com/one/ax/auth.login.by.sendsms".to_string());
    let auth_query_included = smssend_url_supports_auth_query(&base_url);
    let smssend_url = compose_smssend_url(&base_url, &request_id, &device_id, auth);
    opts.insert("--smssend-url".to_string(), smssend_url.clone());
    Some(json!({
        "strategy": "auto_injected_from_ui_session",
        "base_url": base_url,
        "requestId": request_id,
        "deviceId": device_id,
        "auth_query_included": auth_query_included,
        "uid": auth.and_then(|value| value.uid.clone()),
        "sessionId": auth.and_then(|value| value.session_id.clone()),
        "callbackId": auth.and_then(|value| value.callback_id.clone()),
        "pId": auth.and_then(|value| value.p_id.clone()),
        "sysUid": auth.and_then(|value| value.sys_uid.clone()),
        "token_present": auth.and_then(|value| value.token.as_ref()).is_some(),
        "smssend_url": smssend_url,
    }))
}

fn compose_smssend_url(
    base_url: &str,
    request_id: &str,
    device_id: &str,
    auth: Option<&PalmchatSmssendUrlAuth>,
) -> String {
    let include_auth_query = smssend_url_supports_auth_query(base_url);
    if let Ok(mut url) = Url::parse(base_url) {
        {
            let mut query = url.query_pairs_mut();
            if include_auth_query {
                if let Some(auth) = auth {
                    if let Some(uid) = auth.uid.as_deref() {
                        query.append_pair("uid", uid);
                    }
                    if let Some(token) = auth.token.as_deref() {
                        query.append_pair("token", token);
                    }
                    if let Some(session_id) = auth.session_id.as_deref() {
                        query.append_pair("sessionId", session_id);
                    }
                }
            }
            query.append_pair("requestId", request_id);
            query.append_pair("deviceId", device_id);
            if include_auth_query {
                if let Some(auth) = auth {
                    if let Some(callback_id) = auth.callback_id.as_deref() {
                        query.append_pair("callbackId", callback_id);
                    }
                    if let Some(p_id) = auth.p_id.as_deref() {
                        query.append_pair("pId", p_id);
                    }
                    if let Some(sys_uid) = auth.sys_uid.as_deref() {
                        query.append_pair("sysUid", sys_uid);
                    }
                }
            }
        }
        return url.to_string();
    }
    let mut out = base_url.to_string();
    let mut append_pair = |name: &str, value: &str| {
        let separator = if out.contains('?') { "&" } else { "?" };
        out.push_str(separator);
        out.push_str(name);
        out.push('=');
        out.push_str(value);
    };
    if include_auth_query {
        if let Some(auth) = auth {
            if let Some(uid) = auth.uid.as_deref() {
                append_pair("uid", uid);
            }
            if let Some(token) = auth.token.as_deref() {
                append_pair("token", token);
            }
            if let Some(session_id) = auth.session_id.as_deref() {
                append_pair("sessionId", session_id);
            }
        }
    }
    append_pair("requestId", request_id);
    append_pair("deviceId", device_id);
    if include_auth_query {
        if let Some(auth) = auth {
            if let Some(callback_id) = auth.callback_id.as_deref() {
                append_pair("callbackId", callback_id);
            }
            if let Some(p_id) = auth.p_id.as_deref() {
                append_pair("pId", p_id);
            }
            if let Some(sys_uid) = auth.sys_uid.as_deref() {
                append_pair("sysUid", sys_uid);
            }
        }
    }
    out
}

fn smssend_url_supports_auth_query(base_url: &str) -> bool {
    let trimmed = base_url.trim();
    if trimmed.is_empty() {
        return false;
    }
    match Url::parse(trimmed) {
        Ok(parsed) => {
            let path = parsed.path();
            !path.ends_with("/auth.login.by.sendsms")
        }
        Err(_) => !trimmed.contains("auth.login.by.sendsms"),
    }
}

fn extract_non_empty_string(obj: &Map<String, Value>, key: &str) -> Option<String> {
    obj.get(key)
        .and_then(Value::as_str)
        .map(|value| value.trim().to_string())
        .filter(|value| !value.is_empty())
}

fn is_new_sms_v7_profile(map: &Map<String, Value>) -> bool {
    map.contains_key("mobile")
        && map.contains_key("countryCode")
        && [
            "verifyStatus",
            "paramNum",
            "modeType",
            "rid",
            "diffTime",
            "appId",
            "channelId",
        ]
        .iter()
        .any(|key| map.contains_key(*key))
}

fn normalize_wm4_network_type(network_type: Option<&str>) -> String {
    match network_type {
        Some("WIFI") => "w".to_string(),
        Some(value) if !value.trim().is_empty() => "g".to_string(),
        _ => String::new(),
    }
}

fn normalize_wm4_real_network_type(
    network_type: Option<&str>,
    mobile_data_enabled: Option<bool>,
) -> String {
    let network = normalize_wm4_network_type(network_type);
    if network == "w" && mobile_data_enabled == Some(true) {
        "wg".to_string()
    } else {
        network
    }
}

fn apply_app_version_normalization(
    map: &mut Map<String, Value>,
    app_version_info: &PalmchatAppVersionInfo,
    preserve_existing_new_sms_version_code: bool,
    changed_fields: &mut Vec<String>,
) {
    let new_sms_profile = is_new_sms_v7_profile(map);
    if let Some(version_code) = app_version_info.version_code.as_ref() {
        let normalized = if new_sms_profile {
            Value::String(version_code.clone())
        } else {
            version_code
                .parse::<i64>()
                .ok()
                .map(|parsed| Value::Number(parsed.into()))
                .unwrap_or_else(|| Value::String(version_code.clone()))
        };
        let previous = map.get("versionCode").cloned().unwrap_or(Value::Null);
        let should_preserve_existing = new_sms_profile
            && preserve_existing_new_sms_version_code
            && !matches!(previous, Value::Null);
        if !should_preserve_existing && previous != normalized {
            map.insert("versionCode".to_string(), normalized.clone());
            changed_fields.push(format!("versionCode:{}=>{}", previous, normalized));
        }
    }

    if new_sms_profile {
        if let Some(previous) = map.remove("versionName") {
            changed_fields.push(format!("versionName:{}=>{}", previous, Value::Null));
        }
    } else if let Some(version_name) = app_version_info.version_name.as_ref() {
        let normalized = Value::String(version_name.clone());
        let previous = map.get("versionName").cloned().unwrap_or(Value::Null);
        if previous != normalized {
            map.insert("versionName".to_string(), normalized.clone());
            changed_fields.push(format!("versionName:{}=>{}", previous, normalized));
        }
    }
}

fn v7_required_non_empty_keys(map: &Map<String, Value>) -> Vec<&'static str> {
    let mut keys = V7_STAGE_BASE_REQUIRED_KEYS.to_vec();
    let verify_status = match map.get("verifyStatus") {
        Some(Value::Bool(v)) => Some(*v),
        Some(Value::Number(v)) => Some(v.as_i64().unwrap_or_default() != 0),
        Some(Value::String(v)) => Some(parse_bool_like(v)),
        _ => None,
    };
    if verify_status == Some(true) {
        keys.extend_from_slice(V7_STAGE2_REQUIRED_KEYS);
    }
    keys
}

fn normalize_plain_candidate(candidate: Option<String>) -> Option<String> {
    let value = candidate?.trim().to_string();
    if value.is_empty() {
        return None;
    }
    let lowered = value.to_ascii_lowercase();
    if lowered == "null"
        || lowered == "unknown"
        || lowered == "none"
        || lowered.starts_with("null__")
        || lowered.starts_with("null_")
    {
        return None;
    }
    Some(value)
}

fn normalize_device_label_candidate(candidate: Option<String>) -> Option<String> {
    normalize_plain_candidate(candidate)
}

fn normalize_ac1_imei_candidate(candidate: Option<String>) -> Option<String> {
    let value = candidate?.trim().to_string();
    if value.is_empty() {
        return None;
    }
    let lowered = value.to_ascii_lowercase();
    if lowered == "null" || lowered.starts_with("null__") || lowered.starts_with("null_") {
        return None;
    }
    if lowered == "unknown" {
        return Some("Unknown".to_string());
    }
    Some(value)
}

fn recompute_nullable_did(map: &Map<String, Value>) -> Option<String> {
    let current_segments = map
        .get("did")
        .and_then(Value::as_str)
        .unwrap_or_default()
        .split('_')
        .map(str::to_string)
        .collect::<Vec<_>>();

    let imei_segment = match map.get("imei") {
        Some(Value::Null) => Some("null".to_string()),
        Some(Value::String(value)) => Some(value.trim().to_string()),
        _ => current_segments.first().cloned(),
    };
    let mac_segment = match map.get("mac") {
        Some(Value::Null) => Some(String::new()),
        Some(Value::String(value)) => Some(value.trim().to_string()),
        _ => current_segments.get(1).cloned(),
    };
    let android_segment = map
        .get("androidId")
        .and_then(Value::as_str)
        .map(|value| value.trim().to_string())
        .filter(|value| !value.is_empty())
        .or_else(|| current_segments.get(2).cloned());

    match (imei_segment, mac_segment, android_segment) {
        (Some(imei), Some(mac), Some(android_id)) => Some(format!("{imei}_{mac}_{android_id}")),
        _ => None,
    }
}

fn value_is_null_like(value: &Value) -> bool {
    match value {
        Value::Null => true,
        Value::String(v) => normalize_plain_candidate(Some(v.clone())).is_none(),
        Value::Array(items) => items.is_empty(),
        _ => false,
    }
}

fn map_value_missing(map: &Map<String, Value>, key: &str) -> bool {
    match map.get(key) {
        None | Some(Value::Null) => true,
        Some(Value::String(v)) => v.trim().is_empty(),
        _ => false,
    }
}

fn map_value_missing_or_null_like(map: &Map<String, Value>, key: &str) -> bool {
    match map.get(key) {
        None => true,
        Some(value) => value_is_null_like(value),
    }
}

fn fill_if_missing(
    map: &mut Map<String, Value>,
    key: &str,
    candidate: Option<String>,
    events: &mut Vec<String>,
) {
    if !map_value_missing(map, key) {
        return;
    }
    if let Some(v) = candidate {
        map.insert(key.to_string(), Value::String(v.clone()));
        events.push(format!("{key}={v}"));
    }
}

fn fill_or_override_if_null_like(
    map: &mut Map<String, Value>,
    key: &str,
    candidate: Option<String>,
    events: &mut Vec<String>,
) {
    if !map_value_missing_or_null_like(map, key) {
        return;
    }
    if let Some(v) = normalize_plain_candidate(candidate) {
        map.insert(key.to_string(), Value::String(v.clone()));
        events.push(format!("{key}={v}"));
    }
}

fn fill_or_override_null_like_value(
    map: &mut Map<String, Value>,
    key: &str,
    value: Value,
    events: &mut Vec<String>,
) {
    if !map_value_missing_or_null_like(map, key) {
        return;
    }
    if map.get(key) != Some(&value) {
        let event_value = match &value {
            Value::Null => "null".to_string(),
            Value::String(text) => text.clone(),
            _ => value.to_string(),
        };
        map.insert(key.to_string(), value);
        events.push(format!("{key}={event_value}"));
    }
}

fn force_override_with_seed(
    map: &mut Map<String, Value>,
    key: &str,
    candidate: Option<String>,
    events: &mut Vec<String>,
) {
    if let Some(v) = normalize_plain_candidate(candidate) {
        let next = Value::String(v.clone());
        if map.get(key) != Some(&next) {
            map.insert(key.to_string(), next);
            events.push(format!("{key}={v}"));
        }
    }
}

fn prune_new_sms_auto_noise_fields(map: &mut Map<String, Value>, events: &mut Vec<String>) {
    for key in ["device_id", "local_smid"] {
        if map.remove(key).is_some() {
            events.push(format!("drop.{key}=absent-in-proven-new-sms-body"));
        }
    }
}

fn collect_null_like_keys(map: &Map<String, Value>, keys: &[&str]) -> Vec<String> {
    keys.iter()
        .filter_map(|key| {
            if map_value_missing_or_null_like(map, key) {
                Some((*key).to_string())
            } else {
                None
            }
        })
        .collect()
}

fn collect_null_like_object_keys(map: &Map<String, Value>) -> Vec<String> {
    let mut keys = map
        .iter()
        .filter_map(|(key, value)| {
            if value_is_null_like(value) {
                Some(key.clone())
            } else {
                None
            }
        })
        .collect::<Vec<_>>();
    keys.sort_unstable();
    keys
}

fn sha256_hex_bytes(bytes: &[u8]) -> String {
    let mut hasher = Sha256::new();
    hasher.update(bytes);
    hex::encode(hasher.finalize())
}

fn build_payload_namespace_views(map: &Map<String, Value>) -> Map<String, Value> {
    let mut out = Map::new();
    for key in ["appList", "dfp", "ipInfo"] {
        if let Some(decoded) = parse_json_string_or_object(map.get(key)) {
            out.insert(key.to_string(), decoded);
        }
    }
    out
}

fn build_top_level_object_delta(before: &Map<String, Value>, after: &Map<String, Value>) -> Value {
    let before_keys = before.keys().cloned().collect::<HashSet<_>>();
    let after_keys = after.keys().cloned().collect::<HashSet<_>>();

    let mut added = after_keys
        .difference(&before_keys)
        .cloned()
        .collect::<Vec<_>>();
    added.sort_unstable();

    let mut removed = before_keys
        .difference(&after_keys)
        .cloned()
        .collect::<Vec<_>>();
    removed.sort_unstable();

    let mut shared_keys = before_keys
        .intersection(&after_keys)
        .cloned()
        .collect::<Vec<_>>();
    shared_keys.sort_unstable();
    let shared_key_refs = shared_keys.iter().map(String::as_str).collect::<Vec<_>>();
    let changed = build_field_diff(before, after, &shared_key_refs);

    json!({
        "added": added,
        "removed": removed,
        "changed": changed,
    })
}

fn build_payload_snapshot(
    value: &Value,
    cipher_bytes: Option<usize>,
    cipher_sha256: Option<String>,
) -> Value {
    let compact_json = value.to_string();
    let plaintext_utf8_len = compact_json.len();
    let plaintext_sha256 = sha256_hex_bytes(compact_json.as_bytes());
    let mut top_level_keys = Vec::<String>::new();
    let mut null_like_keys = Vec::<String>::new();
    let mut required_null_like_keys = Vec::<String>::new();
    let mut namespace_views = Map::new();

    if let Value::Object(map) = value {
        top_level_keys = map.keys().cloned().collect::<Vec<_>>();
        top_level_keys.sort_unstable();
        null_like_keys = collect_null_like_object_keys(map);
        let required_keys = v7_required_non_empty_keys(map);
        required_null_like_keys = collect_null_like_keys(map, &required_keys);
        namespace_views = build_payload_namespace_views(map);
    }

    json!({
        "payload": value,
        "compact_json": compact_json,
        "plaintext_utf8_len": plaintext_utf8_len,
        "plaintext_sha256": plaintext_sha256,
        "cipher_bytes": cipher_bytes,
        "cipher_sha256": cipher_sha256,
        "top_level_keys": top_level_keys,
        "null_like_keys": null_like_keys,
        "required_null_like_keys": required_null_like_keys,
        "namespace_views": Value::Object(namespace_views),
    })
}

fn extract_optional_cipher_bytes(value: Option<&Value>, path: &[&str]) -> Option<usize> {
    let mut current = value?;
    for key in path {
        current = current.get(*key)?;
    }
    current.as_u64().map(|value| value as usize)
}

fn extract_optional_cipher_sha256(value: Option<&Value>, path: &[&str]) -> Option<String> {
    let mut current = value?;
    for key in path {
        current = current.get(*key)?;
    }
    current.as_str().map(|value| value.to_string())
}

fn derive_synthetic_imei(seed: &str) -> String {
    let normalized = seed.trim();
    let mut hasher_a = crc32fast::Hasher::new();
    hasher_a.update(normalized.as_bytes());
    let first = hasher_a.finalize();
    let mut hasher_b = crc32fast::Hasher::new();
    hasher_b.update(b"IMEI_SEED");
    hasher_b.update(normalized.as_bytes());
    let second = hasher_b.finalize();
    let mut base_digits = format!("{first:010}{second:010}");
    base_digits.retain(|ch| ch.is_ascii_digit());
    while base_digits.len() < 14 {
        base_digits.push('0');
    }
    let imei_14 = &base_digits[..14];
    let check_digit = imei_luhn_check_digit(imei_14);
    format!("{imei_14}{check_digit}")
}

fn imei_luhn_check_digit(imei_14: &str) -> u8 {
    let mut sum = 0u32;
    for (idx, ch) in imei_14.chars().enumerate() {
        let mut d = ch.to_digit(10).unwrap_or(0);
        if idx % 2 == 1 {
            d *= 2;
            if d > 9 {
                d -= 9;
            }
        }
        sum += d;
    }
    ((10 - (sum % 10)) % 10) as u8
}

fn derive_hex_token_from_seed(seed: &str) -> String {
    let normalized = seed.trim();
    let mut out = String::new();
    for salt in [b'A', b'B', b'C', b'D', b'E', b'F', b'G', b'H'] {
        let mut hasher = crc32fast::Hasher::new();
        hasher.update(&[salt]);
        hasher.update(normalized.as_bytes());
        out.push_str(&format!("{:08X}", hasher.finalize()));
    }
    out
}

fn ensure_app_list_payload(
    map: &mut Map<String, Value>,
    imei: Option<&str>,
    channel_id: Option<&str>,
    package_name: &str,
    package_names: Option<&[String]>,
    force_refresh_channel_id: bool,
    events: &mut Vec<String>,
) {
    let mut app_list_obj = match parse_json_string_or_object(map.get("appList")) {
        Some(Value::Object(obj)) => obj,
        _ => Map::new(),
    };
    if let Some(imei_value) = normalize_ac1_imei_candidate(imei.map(|v| v.to_string())) {
        let should_set = app_list_obj
            .get("imei")
            .map(value_is_null_like)
            .unwrap_or(true);
        if should_set {
            app_list_obj.insert("imei".to_string(), Value::String(imei_value.clone()));
            events.push(format!("appList.imei={imei_value}"));
        }
    }
    if let Some(channel_value) = normalize_plain_candidate(channel_id.map(|v| v.to_string())) {
        let generated_channel_value = generate_app_list_channel_id(&channel_value);
        let should_set = force_refresh_channel_id
            || app_list_obj
                .get("channelId")
                .map(value_is_null_like)
                .unwrap_or(true);
        if should_set {
            app_list_obj.insert(
                "channelId".to_string(),
                Value::String(generated_channel_value.clone()),
            );
            events.push(format!("appList.channelId={generated_channel_value}"));
        }
    }
    let desired_package_names = select_app_list_package_names(package_name, package_names);
    let current_package_names = extract_app_list_package_names(&app_list_obj);
    if current_package_names != desired_package_names {
        app_list_obj.insert(
            "package".to_string(),
            Value::Array(
                desired_package_names
                    .iter()
                    .map(|package| json!({ "packageName": package }))
                    .collect(),
            ),
        );
        events.push(format!(
            "appList.package_count={}",
            desired_package_names.len()
        ));
    }
    map.insert(
        "appList".to_string(),
        Value::String(Value::Object(app_list_obj).to_string()),
    );
}

fn select_app_list_package_names(
    package_name: &str,
    package_names: Option<&[String]>,
) -> Vec<String> {
    let mut out = Vec::<String>::new();

    if let Some(items) = package_names {
        for item in items {
            push_app_list_package_candidate(&mut out, item, usize::MAX);
        }
    }

    if !out.iter().any(|item| item == package_name) {
        push_app_list_package_candidate(&mut out, package_name, usize::MAX);
    }
    if out.is_empty() {
        push_app_list_package_candidate(&mut out, package_name, usize::MAX);
    }
    out
}

fn push_app_list_package_candidate(out: &mut Vec<String>, candidate: &str, cap: usize) {
    let Some(normalized) = normalize_plain_candidate(Some(candidate.to_string())) else {
        return;
    };
    if out.len() >= cap || out.iter().any(|existing| existing == &normalized) {
        return;
    }
    out.push(normalized);
}

fn extract_app_list_package_names(app_list_obj: &Map<String, Value>) -> Vec<String> {
    app_list_obj
        .get("package")
        .and_then(Value::as_array)
        .map(|items| {
            items
                .iter()
                .filter_map(|item| match item {
                    Value::Object(obj) => extract_non_empty_string(obj, "packageName"),
                    Value::String(raw) => normalize_plain_candidate(Some(raw.to_string())),
                    _ => None,
                })
                .collect::<Vec<_>>()
        })
        .unwrap_or_default()
}

fn generate_xn3_like_id() -> String {
    let mut rng = rand::rng();
    let mut prefix = String::with_capacity(4);
    for _ in 0..4 {
        if rng.random_bool(0.5) {
            let base = if rng.random_bool(0.5) { b'A' } else { b'a' };
            prefix.push((base + rng.random_range(0..26)) as char);
        } else {
            prefix.push(char::from(b'0' + rng.random_range(0..10)));
        }
    }
    format!("{prefix}{}", current_timestamp_millis())
}

fn generate_app_list_channel_id(channel_id: &str) -> String {
    format!("{channel_id}_{}", generate_xn3_like_id())
}

fn ensure_dfp_payload(
    map: &mut Map<String, Value>,
    android_id: Option<&str>,
    app_version: Option<&str>,
    package_name: Option<&str>,
    device_label: Option<&str>,
    live_profile: Option<&PalmchatLiveDeviceProfile>,
    events: &mut Vec<String>,
) {
    let mut dfp_obj = match parse_json_string_or_object(map.get("dfp")) {
        Some(Value::Object(obj)) => obj,
        _ => Map::new(),
    };
    if let Some(android_id_value) = normalize_plain_candidate(android_id.map(str::to_string)) {
        let next = Value::String(android_id_value.clone());
        if dfp_obj.get("androidid") != Some(&next) {
            dfp_obj.insert("androidid".to_string(), next);
            events.push(format!("dfp.androidid={android_id_value}"));
        }
    }
    if let Some(app_version_value) = normalize_plain_candidate(app_version.map(str::to_string)) {
        let next = Value::String(app_version_value.clone());
        if dfp_obj.get("app_version") != Some(&next) {
            dfp_obj.insert("app_version".to_string(), next);
            events.push(format!("dfp.app_version={app_version_value}"));
        }
    }
    if let Some(package_value) = normalize_plain_candidate(package_name.map(str::to_string)) {
        let next = Value::String(package_value.clone());
        if dfp_obj.get("app_package") != Some(&next) {
            dfp_obj.insert("app_package".to_string(), next);
            events.push(format!("dfp.app_package={package_value}"));
        }
    }
    if let Some(device_label_value) =
        normalize_device_label_candidate(device_label.map(str::to_string))
    {
        let next = Value::String(device_label_value.clone());
        if dfp_obj.get("duDeviceLabel") != Some(&next) {
            dfp_obj.insert("duDeviceLabel".to_string(), next);
            events.push(format!("dfp.duDeviceLabel={device_label_value}"));
        }
    }
    if let Some(profile) = live_profile {
        apply_live_profile_to_dfp(&mut dfp_obj, profile, events);
        apply_fm1_compatible_dfp_defaults(&mut dfp_obj, map, profile, events);
    }
    map.insert(
        "dfp".to_string(),
        Value::String(Value::Object(dfp_obj).to_string()),
    );
}

fn apply_live_profile_to_dfp(
    dfp_obj: &mut Map<String, Value>,
    profile: &PalmchatLiveDeviceProfile,
    events: &mut Vec<String>,
) {
    upsert_dfp_string(dfp_obj, "sinfo", profile.secinfo_json.clone(), events);
    upsert_dfp_string(
        dfp_obj,
        "android.os.Build.BOARD",
        profile.product_board.clone(),
        events,
    );
    upsert_dfp_string(
        dfp_obj,
        "android.os.Build.BRAND",
        profile.product_brand.clone(),
        events,
    );
    upsert_dfp_string(
        dfp_obj,
        "android.os.Build.DEVICE",
        profile.product_device.clone(),
        events,
    );
    upsert_dfp_string(
        dfp_obj,
        "android.os.Build.HARDWARE",
        profile.hardware.clone(),
        events,
    );
    upsert_dfp_string(
        dfp_obj,
        "android.os.Build.MODEL",
        profile.product_model.clone(),
        events,
    );
    upsert_dfp_string(
        dfp_obj,
        "android.os.Build.PRODUCT",
        profile.product_name.clone(),
        events,
    );
    upsert_dfp_string(
        dfp_obj,
        "android.os.Build.VERSION.RELEASE",
        profile.build_release.clone(),
        events,
    );
    if !profile.product_abi_list.is_empty() {
        upsert_dfp_string(
            dfp_obj,
            "build_cpu_abis",
            Some(json!(profile.product_abi_list).to_string()),
            events,
        );
    }
    upsert_dfp_string(
        dfp_obj,
        "build_display",
        profile.build_display.clone(),
        events,
    );
    upsert_dfp_string(
        dfp_obj,
        "build_fingerprint",
        profile.build_fingerprint.clone(),
        events,
    );
    upsert_dfp_string(dfp_obj, "build_host", profile.build_host.clone(), events);
    upsert_dfp_string(dfp_obj, "build_id", profile.build_id.clone(), events);
    upsert_dfp_string(
        dfp_obj,
        "build_manufacturer",
        profile.product_manufacturer.clone(),
        events,
    );
    upsert_dfp_string(
        dfp_obj,
        "build_version_security_patch",
        profile.build_security_patch.clone(),
        events,
    );
    upsert_dfp_string(dfp_obj, "cpu_hardware", profile.hardware.clone(), events);
    upsert_dfp_string(dfp_obj, "net_type", profile.network_type.clone(), events);
    upsert_dfp_string(dfp_obj, "netState", profile.network_state.clone(), events);
    upsert_dfp_string(dfp_obj, "ip", profile.wlan_ipv4.clone(), events);
    upsert_dfp_string_allow_empty(dfp_obj, "wifiSSID", profile.wifi_ssid.clone(), events);
    upsert_dfp_string(dfp_obj, "wifi_ip", profile.wlan_ipv4.clone(), events);
    upsert_dfp_string(
        dfp_obj,
        "http.agent",
        profile.webview_user_agent.clone(),
        events,
    );
    upsert_dfp_string(
        dfp_obj,
        "resolution",
        profile
            .resolution
            .clone()
            .map(|value| value.replace('x', "*")),
        events,
    );
    upsert_dfp_number(
        dfp_obj,
        "screen_brightness",
        profile.screen_brightness,
        events,
    );
    upsert_dfp_bool(dfp_obj, "screen_on", profile.screen_on, events);
    upsert_dfp_string(dfp_obj, "usb_state", profile.usb_state.clone(), events);
    if !profile.sensor_name_list.is_empty() {
        upsert_dfp_string(
            dfp_obj,
            "sensor_name_list",
            Some(profile.sensor_name_list.join(",")),
            events,
        );
    }
}

fn apply_fm1_compatible_dfp_defaults(
    dfp_obj: &mut Map<String, Value>,
    body_obj: &Map<String, Value>,
    profile: &PalmchatLiveDeviceProfile,
    events: &mut Vec<String>,
) {
    set_dfp_string(dfp_obj, "app_name", "palmchat", events);
    if let Some(value) = profile
        .build_bootloader
        .clone()
        .map(|value| value.trim().to_string())
        .filter(|value| !value.is_empty())
    {
        set_dfp_string(dfp_obj, "build_bootloader", value, events);
    }
    if let Some(value) = profile
        .build_version_codename
        .clone()
        .map(|value| value.trim().to_string())
        .filter(|value| !value.is_empty())
    {
        set_dfp_string(dfp_obj, "build_version_codename", value, events);
    }
    if let Some(value) = profile
        .cpu_max_freq
        .clone()
        .map(|value| value.trim().to_string())
        .filter(|value| !value.is_empty())
    {
        set_dfp_string(dfp_obj, "cpu_max_freq", value, events);
    }
    if let Some(value) = profile
        .cpu_min_freq
        .clone()
        .map(|value| value.trim().to_string())
        .filter(|value| !value.is_empty())
    {
        set_dfp_string(dfp_obj, "cpu_min_freq", value, events);
    }
    if let Some(value) = profile
        .kernel_version
        .clone()
        .map(|value| value.trim().to_string())
    {
        set_dfp_string_allow_empty(dfp_obj, "kernelVersion", value, events);
    }
    if let Some(value) = profile.boot_time_millis {
        set_dfp_number(dfp_obj, "last_boot_time", value, events);
    }
    if let Some(value) = profile.build_time_millis {
        set_dfp_number(dfp_obj, "build_time", value, events);
    }
    if let Some(value) = profile.cpu_cores {
        set_dfp_number(dfp_obj, "cpu_cores", value, events);
    }
    set_dfp_string(
        dfp_obj,
        "cpu_features",
        profile
            .cpu_features
            .clone()
            .unwrap_or_else(|| "unknown".to_string()),
        events,
    );
    set_dfp_string(
        dfp_obj,
        "cpu_processor",
        profile
            .cpu_processor
            .clone()
            .unwrap_or_else(|| "unknown".to_string()),
        events,
    );
    set_dfp_string(
        dfp_obj,
        "cpu_hardware",
        profile
            .cpuinfo_hardware
            .clone()
            .unwrap_or_else(|| "unknown".to_string()),
        events,
    );

    set_dfp_number(dfp_obj, "gles", 3, events);
    set_dfp_number(dfp_obj, "simulator", 0, events);
    set_dfp_number(
        dfp_obj,
        "proxy_port",
        profile.http_proxy_port.unwrap_or(0),
        events,
    );
    set_dfp_string(
        dfp_obj,
        "proxy_ip",
        profile
            .http_proxy_host
            .clone()
            .unwrap_or_else(|| "none".to_string()),
        events,
    );

    let imei = body_obj
        .get("imei")
        .and_then(Value::as_str)
        .map(|value| value.to_string())
        .unwrap_or_default();
    let imsi = body_obj
        .get("imsi")
        .and_then(Value::as_str)
        .map(|value| value.to_string())
        .unwrap_or_default();
    let mac = body_obj
        .get("mac")
        .and_then(Value::as_str)
        .map(|value| value.to_string())
        .unwrap_or_default();
    let effective_imei = normalize_ac1_imei_candidate(Some(imei));
    let effective_imsi = normalize_ac1_imei_candidate(Some(imsi));
    if let Some(effective_imei) = effective_imei {
        set_dfp_string(dfp_obj, "deviceId", effective_imei.clone(), events);
        set_dfp_string(dfp_obj, "imei", effective_imei, events);
    }
    if let Some(effective_imsi) = effective_imsi {
        set_dfp_string(dfp_obj, "imsi", effective_imsi, events);
    }
    set_dfp_string(dfp_obj, "phoneNumber", String::new(), events);
    set_dfp_string(dfp_obj, "bt_mac", "none", events);
    set_dfp_string(dfp_obj, "bt_name", "none", events);
    set_dfp_value(
        dfp_obj,
        "accessibility_list",
        Value::Array(
            profile
                .enabled_accessibility_packages
                .iter()
                .map(|package| json!({ "package": package }))
                .collect(),
        ),
        events,
    );
    let input_methods_json = Value::Array(if profile.input_method_labels.is_empty() {
        profile
            .input_method_ids
            .iter()
            .map(|item| Value::String(item.clone()))
            .collect()
    } else {
        profile
            .input_method_labels
            .iter()
            .map(|item| Value::String(item.clone()))
            .collect()
    })
    .to_string();
    set_dfp_string(dfp_obj, "in", input_methods_json, events);
    set_dfp_string(dfp_obj, "isUserAMonkey", "false", events);
    set_dfp_string(dfp_obj, "hasTracerPid", "false", events);
    set_dfp_string(dfp_obj, "isDebuggerConnected", "false", events);
    set_dfp_string(dfp_obj, "org.appanalysis", "false", events);
    set_dfp_string(dfp_obj, "dalvik.system.Taint", "false", events);
    set_dfp_string(dfp_obj, "FileDescriptor_name", "false", events);
    set_dfp_string(dfp_obj, "Cipher_key", "false", events);
    set_dfp_string(dfp_obj, "socket_pipe", "null", events);
    set_dfp_string(dfp_obj, "hasQemuDrivers", "false", events);
    set_dfp_string(dfp_obj, "hasEmulatorAdb", "false", events);
    set_dfp_string(dfp_obj, "QEmuFiles", "null", events);
    set_dfp_string(dfp_obj, "GenyFiles", "null", events);
    set_dfp_string(dfp_obj, "checkQemuBreakpoint", "false", events);
    set_dfp_string(dfp_obj, "macAddr", mac, events);
    if let Some(value) = profile
        .baseband_version
        .clone()
        .map(|value| value.trim().to_string())
    {
        set_dfp_string_allow_empty(dfp_obj, "basicVersion", value, events);
    }
    if let Some(value) = derive_fm1_inner_version(
        profile.build_display.as_deref(),
        profile.build_incremental.as_deref(),
    ) {
        set_dfp_string(dfp_obj, "innerVersion", value, events);
    }
}

fn upsert_dfp_string(
    dfp_obj: &mut Map<String, Value>,
    key: &str,
    value: Option<String>,
    events: &mut Vec<String>,
) {
    if let Some(normalized) = normalize_plain_candidate(value) {
        let next = Value::String(normalized.clone());
        if dfp_obj.get(key) != Some(&next) {
            dfp_obj.insert(key.to_string(), next);
            events.push(format!("dfp.{key}={normalized}"));
        }
    }
}

fn upsert_dfp_string_allow_empty(
    dfp_obj: &mut Map<String, Value>,
    key: &str,
    value: Option<String>,
    events: &mut Vec<String>,
) {
    let Some(raw) = value else {
        return;
    };
    let normalized = raw.trim().to_string();
    let next = Value::String(normalized.clone());
    if dfp_obj.get(key) != Some(&next) {
        dfp_obj.insert(key.to_string(), next);
        events.push(format!("dfp.{key}={normalized}"));
    }
}

fn set_dfp_string(
    dfp_obj: &mut Map<String, Value>,
    key: &str,
    value: impl Into<String>,
    events: &mut Vec<String>,
) {
    let value = value.into();
    let next = Value::String(value.clone());
    if dfp_obj.get(key) != Some(&next) {
        dfp_obj.insert(key.to_string(), next);
        events.push(format!("dfp.{key}={value}"));
    }
}

fn set_dfp_string_allow_empty(
    dfp_obj: &mut Map<String, Value>,
    key: &str,
    value: impl Into<String>,
    events: &mut Vec<String>,
) {
    let value = value.into();
    let next = Value::String(value.clone());
    if dfp_obj.get(key) != Some(&next) {
        dfp_obj.insert(key.to_string(), next);
        events.push(format!("dfp.{key}={value}"));
    }
}

fn set_dfp_value(
    dfp_obj: &mut Map<String, Value>,
    key: &str,
    value: Value,
    events: &mut Vec<String>,
) {
    if dfp_obj.get(key) != Some(&value) {
        let event_value = match &value {
            Value::String(text) => text.clone(),
            _ => value.to_string(),
        };
        dfp_obj.insert(key.to_string(), value);
        events.push(format!("dfp.{key}={event_value}"));
    }
}

fn drop_dfp_key(
    dfp_obj: &mut Map<String, Value>,
    key: &str,
    reason: &str,
    events: &mut Vec<String>,
) {
    if dfp_obj.remove(key).is_some() {
        events.push(format!("drop.dfp.{key}={reason}"));
    }
}

fn derive_fm1_inner_version(display: Option<&str>, incremental: Option<&str>) -> Option<String> {
    let display = normalize_plain_candidate(display.map(|value| value.to_string()));
    let incremental = normalize_plain_candidate(incremental.map(|value| value.to_string()));
    match (display, incremental) {
        (Some(display), Some(incremental)) if display.contains(&incremental) => Some(display),
        (_, Some(incremental)) => Some(incremental),
        (Some(display), None) => Some(display),
        (None, None) => None,
    }
}

fn set_dfp_number(
    dfp_obj: &mut Map<String, Value>,
    key: &str,
    value: i64,
    events: &mut Vec<String>,
) {
    let next = Value::Number(value.into());
    if dfp_obj.get(key) != Some(&next) {
        dfp_obj.insert(key.to_string(), next);
        events.push(format!("dfp.{key}={value}"));
    }
}

fn upsert_dfp_number(
    dfp_obj: &mut Map<String, Value>,
    key: &str,
    value: Option<i64>,
    events: &mut Vec<String>,
) {
    if let Some(number) = value {
        let next = Value::Number(number.into());
        if dfp_obj.get(key) != Some(&next) {
            dfp_obj.insert(key.to_string(), next);
            events.push(format!("dfp.{key}={number}"));
        }
    }
}

fn upsert_dfp_bool(
    dfp_obj: &mut Map<String, Value>,
    key: &str,
    value: Option<bool>,
    events: &mut Vec<String>,
) {
    if let Some(flag) = value {
        let next = Value::Bool(flag);
        if dfp_obj.get(key) != Some(&next) {
            dfp_obj.insert(key.to_string(), next);
            events.push(format!("dfp.{key}={flag}"));
        }
    }
}

fn normalize_device_id_candidate(candidate: Option<String>) -> Option<String> {
    normalize_plain_candidate(candidate)
}

fn generate_trace_identifier(prefix_len: usize) -> String {
    const BASE62: &[u8] = b"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    let millis = current_timestamp_millis();
    let nanos = SystemTime::now()
        .duration_since(UNIX_EPOCH)
        .unwrap_or_default()
        .subsec_nanos() as u128;
    let mut seed = millis ^ (nanos << 17) ^ (std::process::id() as u128);
    let mut prefix = String::with_capacity(prefix_len);
    for idx in 0..prefix_len {
        let pos = (seed % 62) as usize;
        prefix.push(BASE62[pos] as char);
        seed = seed / 62 + ((idx as u128 + 1) * 7919);
    }
    format!("{prefix}{millis}")
}

fn extract_query_param(url: &str, key: &str) -> Option<String> {
    Url::parse(url).ok().and_then(|parsed| {
        parsed
            .query_pairs()
            .find(|(name, _)| name == key)
            .map(|(_, value)| value.to_string())
    })
}

fn smssend_base_url_from_request_url(smssend_url: &str) -> Option<String> {
    let mut parsed = Url::parse(smssend_url).ok()?;
    parsed.set_query(None);
    parsed.set_fragment(None);
    Some(parsed.to_string())
}

fn build_two_step_stage1_smssend_url(
    stage2_control_feedback: &Value,
    opts: &HashMap<String, String>,
    auth: Option<&PalmchatSmssendUrlAuth>,
) -> String {
    let stage2_smssend_url = stage2_control_feedback
        .get("smssend_url")
        .and_then(Value::as_str)
        .unwrap_or_default();
    let base_url = opts
        .get("--smssend-base-url")
        .cloned()
        .filter(|value| !value.trim().is_empty())
        .or_else(|| smssend_base_url_from_request_url(stage2_smssend_url))
        .unwrap_or_else(|| "https://short.lianxinapp.com/one/ax/auth.login.by.sendsms".to_string());
    let device_id = opts
        .get("--device-id")
        .cloned()
        .filter(|value| !value.trim().is_empty())
        .or_else(|| {
            stage2_control_feedback
                .get("deviceId")
                .and_then(Value::as_str)
                .map(|value| value.to_string())
        })
        .unwrap_or_else(generate_xn3_like_id);
    let existing_auth = PalmchatSmssendUrlAuth {
        uid: extract_query_param(stage2_smssend_url, "uid"),
        token: None,
        session_id: extract_query_param(stage2_smssend_url, "sessionId"),
        callback_id: extract_query_param(stage2_smssend_url, "callbackId"),
        p_id: extract_query_param(stage2_smssend_url, "pId"),
        sys_uid: extract_query_param(stage2_smssend_url, "sysUid"),
    };
    let merged_auth = PalmchatSmssendUrlAuth {
        uid: auth
            .and_then(|value| value.uid.clone())
            .or(existing_auth.uid.clone()),
        token: auth.and_then(|value| value.token.clone()),
        session_id: auth
            .and_then(|value| value.session_id.clone())
            .or(existing_auth.session_id.clone()),
        callback_id: auth
            .and_then(|value| value.callback_id.clone())
            .or(existing_auth.callback_id.clone()),
        p_id: auth
            .and_then(|value| value.p_id.clone())
            .or(existing_auth.p_id.clone()),
        sys_uid: auth
            .and_then(|value| value.sys_uid.clone())
            .or(existing_auth.sys_uid.clone()),
    };
    compose_smssend_url(
        &base_url,
        &generate_xn3_like_id(),
        &device_id,
        Some(&merged_auth),
    )
}

fn build_data_to_control_feedback(
    arg1_json: &Value,
    encrypted_ckey_hex: &str,
    cipher_hex: &str,
    ck_version: &str,
    opts: &HashMap<String, String>,
) -> Value {
    build_data_to_control_feedback_with_url(
        arg1_json,
        encrypted_ckey_hex,
        cipher_hex,
        ck_version,
        opts.get("--smssend-url")
            .cloned()
            .unwrap_or_else(String::new),
    )
}

fn build_data_to_control_feedback_with_url(
    arg1_json: &Value,
    encrypted_ckey_hex: &str,
    cipher_hex: &str,
    ck_version: &str,
    smssend_url: String,
) -> Value {
    let verify_status = arg1_json
        .get("verifyStatus")
        .and_then(Value::as_bool)
        .unwrap_or(false);
    let request_id = extract_query_param(&smssend_url, "requestId");
    let device_id = extract_query_param(&smssend_url, "deviceId");
    let uid = extract_query_param(&smssend_url, "uid");
    let token_present = extract_query_param(&smssend_url, "token").is_some();
    let session_id = extract_query_param(&smssend_url, "sessionId");
    let callback_id = extract_query_param(&smssend_url, "callbackId");
    let p_id = extract_query_param(&smssend_url, "pId");
    let sys_uid = extract_query_param(&smssend_url, "sysUid");
    let mut blocked_reasons = Vec::<String>::new();
    if !verify_status {
        blocked_reasons.push("verifyStatus_false".to_string());
    }
    if encrypted_ckey_hex.trim().is_empty() {
        blocked_reasons.push("empty_encrypted_ckey_hex".to_string());
    }
    if cipher_hex.trim().is_empty() {
        blocked_reasons.push("empty_cipher_hex".to_string());
    }
    if smssend_url.trim().is_empty() {
        blocked_reasons.push("missing_smssend_url".to_string());
    }
    let ready = blocked_reasons.is_empty();
    json!({
        "summary": "data plane feedback promoted into control action gate for smssend",
        "ready_for_smssend": ready,
        "blocked_reasons": blocked_reasons,
        "verifyStatus": verify_status,
        "smssend_url": smssend_url,
        "requestId": request_id,
        "deviceId": device_id,
        "uid": uid,
        "token_present": token_present,
        "sessionId": session_id,
        "callbackId": callback_id,
        "pId": p_id,
        "sysUid": sys_uid,
        "body": arg1_json,
        "headers": {
            "content-encrypted-zx": "1",
            "content-ckey": encrypted_ckey_hex,
            "content-ckey-version": ck_version,
            "content-type": "application/octet-stream; charset=utf-8"
        },
        "body_lengths": {
            "encrypted_ckey_bytes": encrypted_ckey_hex.len() / 2,
            "cipher_bytes": cipher_hex.len() / 2
        },
        "next_control_action": if ready { "smssend_dispatch" } else { "blocked" },
    })
}

fn extract_known_fields_from_value(value: &Value, keys: &[&str]) -> Map<String, Value> {
    let mut out = Map::new();
    let Value::Object(obj) = value else {
        return out;
    };
    for key in keys {
        if let Some(v) = obj.get(*key) {
            out.insert((*key).to_string(), v.clone());
        }
    }
    out
}

fn missing_known_keys(fields: &Map<String, Value>, keys: &[&str]) -> Vec<String> {
    let mut missing = Vec::new();
    for key in keys {
        if !fields.contains_key(*key) {
            missing.push((*key).to_string());
        }
    }
    missing
}

fn compare_field_alignment(
    produce_fields: &Map<String, Value>,
    consume_fields: &Map<String, Value>,
) -> (Vec<String>, Map<String, Value>) {
    let mut stable = Vec::new();
    let mut changed = Map::new();
    for (key, produce_value) in produce_fields {
        let Some(consume_value) = consume_fields.get(key) else {
            continue;
        };
        if produce_value == consume_value {
            stable.push(key.clone());
        } else {
            changed.insert(
                key.clone(),
                json!({
                    "produce": produce_value,
                    "consume": consume_value,
                }),
            );
        }
    }
    stable.sort_unstable();
    (stable, changed)
}

fn derive_v7_first_stage_candidate(stage2_value: &Value) -> Value {
    let Value::Object(stage2_obj) = stage2_value else {
        return json!({});
    };
    let mut out = stage2_obj.clone();
    out.remove("rid");
    out.remove("modeType");
    out.remove("diffTime");
    out.remove("captcha");
    if stage2_obj.contains_key("verifyStatus")
        || stage2_obj.contains_key("rid")
        || stage2_obj.contains_key("modeType")
        || stage2_obj.contains_key("diffTime")
    {
        out.insert("verifyStatus".to_string(), Value::Bool(false));
    }
    Value::Object(out)
}

fn build_two_step_stage1_payload(stage2_value: &Value, package_name: &str) -> Value {
    let Value::Object(stage2_obj) = stage2_value else {
        return json!({});
    };
    let preserve_existing_first_stage = match stage2_obj.get("verifyStatus") {
        Some(Value::Bool(v)) => !*v,
        Some(Value::Number(v)) => v.as_i64().unwrap_or_default() == 0,
        Some(Value::String(v)) => !parse_bool_like(v),
        _ => false,
    } && ["rid", "modeType", "diffTime"]
        .iter()
        .all(|key| !stage2_obj.contains_key(*key));
    let mut stage1_obj = if preserve_existing_first_stage {
        stage2_obj.clone()
    } else {
        match derive_v7_first_stage_candidate(stage2_value) {
            Value::Object(obj) => obj,
            _ => return json!({}),
        }
    };
    stage1_obj.remove("captcha");
    let app_list_channel_id = stage1_obj
        .get("channelId")
        .and_then(Value::as_str)
        .map(|value| value.to_string());
    let stage1_package_names = parse_json_string_or_object(stage1_obj.get("appList"))
        .and_then(|value| value.as_object().map(extract_app_list_package_names))
        .filter(|packages| !packages.is_empty())
        .unwrap_or_else(|| vec![package_name.to_string()]);
    let mut events = Vec::new();
    ensure_app_list_payload(
        &mut stage1_obj,
        None,
        app_list_channel_id.as_deref(),
        package_name,
        Some(stage1_package_names.as_slice()),
        !preserve_existing_first_stage,
        &mut events,
    );
    Value::Object(stage1_obj)
}

fn build_two_step_stage1_from_mh_base(base_value: &Value, stage2_value: &Value) -> Value {
    let Value::Object(base_obj) = base_value else {
        return json!({});
    };
    let Value::Object(stage2_obj) = stage2_value else {
        return Value::Object(base_obj.clone());
    };
    let mut stage1_obj = base_obj.clone();
    if let Some(value) = stage2_obj.get("mobile") {
        stage1_obj.insert("mobile".to_string(), value.clone());
    }
    if let Some(value) = stage2_obj.get("countryCode") {
        stage1_obj.insert("countryCode".to_string(), value.clone());
    }
    stage1_obj.remove("rid");
    stage1_obj.remove("modeType");
    stage1_obj.remove("diffTime");
    stage1_obj.remove("captcha");
    stage1_obj.insert("verifyStatus".to_string(), Value::Bool(false));
    stage1_obj
        .entry("paramNum".to_string())
        .or_insert_with(|| Value::Number(4.into()));
    Value::Object(stage1_obj)
}

fn apply_explicit_stage1_override(stage1_value: &mut Value, stage1_override: Option<&Value>) {
    let Some(Value::Object(override_obj)) = stage1_override else {
        return;
    };
    let Some(stage1_obj) = stage1_value.as_object_mut() else {
        return;
    };
    for (key, value) in override_obj {
        stage1_obj.insert(key.clone(), value.clone());
    }
}

fn build_field_diff(
    before_fields: &Map<String, Value>,
    after_fields: &Map<String, Value>,
    keys: &[&str],
) -> Map<String, Value> {
    let mut out = Map::new();
    for key in keys {
        let before = before_fields.get(*key);
        let after = after_fields.get(*key);
        if before == after {
            continue;
        }
        out.insert(
            (*key).to_string(),
            json!({
                "before": before.cloned().unwrap_or(Value::Null),
                "after": after.cloned().unwrap_or(Value::Null),
            }),
        );
    }
    out
}

fn value_to_bool(value: Option<&Value>) -> bool {
    match value {
        Some(Value::Bool(v)) => *v,
        Some(Value::Number(v)) => v.as_i64().unwrap_or_default() != 0,
        Some(Value::String(v)) => parse_bool_like(v),
        _ => false,
    }
}

fn value_present(value: Option<&Value>) -> bool {
    match value {
        Some(Value::Null) | None => false,
        Some(Value::String(v)) => !v.trim().is_empty(),
        Some(Value::Array(v)) => !v.is_empty(),
        Some(Value::Object(v)) => !v.is_empty(),
        Some(_) => true,
    }
}

fn build_v7_captcha_bridge_surface(explicit_stage1: Option<&Value>, stage2_value: &Value) -> Value {
    let stage1_value = explicit_stage1
        .cloned()
        .unwrap_or_else(|| derive_v7_first_stage_candidate(stage2_value));
    let stage1_fields = extract_known_fields_from_value(&stage1_value, V7_FINGERPRINT_KEYS);
    let stage2_fields = extract_known_fields_from_value(stage2_value, V7_FINGERPRINT_KEYS);
    let stage1_missing = missing_known_keys(&stage1_fields, V7_FINGERPRINT_KEYS);
    let stage2_missing = missing_known_keys(&stage2_fields, V7_FINGERPRINT_KEYS);
    let retry_patch_fields = extract_known_fields_from_value(stage2_value, V7_CAPTCHA_BRIDGE_KEYS);
    let retry_patch_missing = missing_known_keys(&retry_patch_fields, V7_CAPTCHA_BRIDGE_KEYS);
    let retry_patch_diff = build_field_diff(&stage1_fields, &stage2_fields, V7_CAPTCHA_BRIDGE_KEYS);

    let stage2_verify_status = value_to_bool(stage2_fields.get("verifyStatus"));
    let has_retry_tuple = value_present(stage2_fields.get("rid"))
        && value_present(stage2_fields.get("modeType"))
        && value_present(stage2_fields.get("diffTime"));
    let has_any_retry_patch = V7_CAPTCHA_BRIDGE_KEYS
        .iter()
        .any(|key| value_present(stage2_fields.get(*key)));

    let branch_type = if stage2_verify_status && has_retry_tuple {
        "captcha_retry_ready"
    } else if !stage2_verify_status && !has_any_retry_patch {
        "first_stage_only"
    } else if has_any_retry_patch {
        "captcha_retry_partial"
    } else {
        "direct_or_unknown"
    };

    json!({
        "source": if explicit_stage1.is_some() { "explicit_stage1_plus_stage2" } else { "derived_stage1_candidate_plus_stage2" },
        "branch_type": branch_type,
        "key_point": {
            "name": "captcha_retry_patch",
            "summary": "Between 1900 and 202, retry is unlocked by patching verifyStatus/rid/modeType/diffTime into the second sendsms payload.",
            "static_chain_anchor": {
                "gate_callback": "u63.onPostExecute/d",
                "captcha_apply": "nz.a",
                "retry_builder": "o92.getRequestArgs"
            }
        },
        "stage1_candidate_fields": stage1_fields,
        "stage1_candidate_missing": stage1_missing,
        "retry_patch_fields": retry_patch_fields,
        "retry_patch_missing": retry_patch_missing,
        "retry_patch_diff": retry_patch_diff,
        "stage2_fields": stage2_fields,
        "stage2_missing": stage2_missing,
    })
}

fn build_v7_captcha_upstream_production(
    explicit_stage1: Option<&Value>,
    stage2_value: &Value,
) -> Value {
    let bridge_surface = build_v7_captcha_bridge_surface(explicit_stage1, stage2_value);
    let retry_patch_diff = bridge_surface
        .get("retry_patch_diff")
        .cloned()
        .unwrap_or_else(|| json!({}));
    let retry_patch_fields = bridge_surface
        .get("retry_patch_fields")
        .cloned()
        .unwrap_or_else(|| json!({}));
    let branch_type = bridge_surface
        .get("branch_type")
        .and_then(Value::as_str)
        .unwrap_or("unknown");

    json!({
        "branch_type": branch_type,
        "summary": "Between first sendsms=1900 and second sendsms=202, the critical upstream production step is CaptchaResult construction plus nz.a retry patching, not another HTTP API.",
        "production_chain": [
            {
                "order": 1,
                "node": "u63.onPostExecute/d",
                "kind": "gate_callback",
                "role": "Delivers first sendsms resultCode=1900 to the login callback branch."
            },
            {
                "order": 2,
                "node": "com.zenmen.palmchat.utils.captcha.a.o(String)",
                "kind": "captcha_result_builder",
                "role": "Builds CaptchaResult when captcha pass is confirmed.",
                "evidence": {
                    "constructor": "new CaptchaResult(captchaBean.rid, this.k.a(), ir5.e(this.l))",
                    "field_origins": {
                        "rid": "captchaBean.rid",
                        "modeType": "mz.a() / this.k.a()",
                        "diffTime": "ir5.e(this.l)"
                    }
                }
            },
            {
                "order": 3,
                "node": "nz.a(HashMap<String,Object>, CaptchaResult)",
                "kind": "retry_patch",
                "role": "Patches retry sendsms body with verifyStatus/rid/modeType/diffTime.",
                "evidence": {
                    "rule": "captchaResult == null => verifyStatus=false; else verifyStatus=true and put rid/modeType/diffTime"
                }
            },
            {
                "order": 4,
                "node": "na3.a(SMSInfo, CaptchaResult, cb)",
                "kind": "retry_dispatch",
                "role": "Dispatches second sendsms with SMSInfo + CaptchaResult."
            },
            {
                "order": 5,
                "node": "o92.getRequestArgs()",
                "kind": "request_builder",
                "role": "Builds sw4 body, adds mobile/countryCode/paramNum, and invokes nz.a(...) for captcha patch."
            },
            {
                "order": 6,
                "node": "u63.a(sw4, ...)",
                "kind": "request_consumer",
                "role": "Serializes patched sw4 JSON, calls EncryptUtils.setLxData, then builds EncryptedJsonRequest for second sendsms."
            }
        ],
        "field_sources": {
            "verifyStatus": {
                "producer": "nz.a(HashMap<String,Object>, CaptchaResult)",
                "rule": "null captcha => false, non-null captcha => true",
                "observed_patch": retry_patch_diff.get("verifyStatus").cloned().unwrap_or(Value::Null)
            },
            "rid": {
                "producer": "CaptchaResult.rid",
                "upstream_origin": "captchaBean.rid",
                "patcher": "nz.a(HashMap<String,Object>, CaptchaResult)",
                "observed_patch": retry_patch_diff.get("rid").cloned().unwrap_or(Value::Null)
            },
            "modeType": {
                "producer": "CaptchaResult.modeType",
                "upstream_origin": "mz.a() / this.k.a()",
                "patcher": "nz.a(HashMap<String,Object>, CaptchaResult)",
                "observed_patch": retry_patch_diff.get("modeType").cloned().unwrap_or(Value::Null)
            },
            "diffTime": {
                "producer": "CaptchaResult.diffTime",
                "upstream_origin": "ir5.e(this.l)",
                "patcher": "nz.a(HashMap<String,Object>, CaptchaResult)",
                "observed_patch": retry_patch_diff.get("diffTime").cloned().unwrap_or(Value::Null)
            }
        },
        "retry_patch_fields": retry_patch_fields,
        "bridge_surface": bridge_surface
    })
}

fn build_v7_retry_payload_views(explicit_stage1: Option<&Value>, stage2_value: &Value) -> Value {
    let stage1_value = explicit_stage1
        .cloned()
        .unwrap_or_else(|| derive_v7_first_stage_candidate(stage2_value));

    let stage1_obj = match &stage1_value {
        Value::Object(map) => map.clone(),
        _ => Map::new(),
    };
    let stage2_obj = match stage2_value {
        Value::Object(map) => map.clone(),
        _ => Map::new(),
    };

    let mut retry_patch_only = Map::new();
    for key in V7_CAPTCHA_BRIDGE_KEYS {
        if let Some(value) = stage2_obj.get(*key) {
            retry_patch_only.insert((*key).to_string(), value.clone());
        }
    }

    let mut patched_preview = stage1_obj.clone();
    for (key, value) in &retry_patch_only {
        patched_preview.insert(key.clone(), value.clone());
    }

    let stage1_fields =
        extract_known_fields_from_value(&Value::Object(stage1_obj.clone()), V7_FINGERPRINT_KEYS);
    let stage2_fields =
        extract_known_fields_from_value(&Value::Object(stage2_obj.clone()), V7_FINGERPRINT_KEYS);
    let patch_diff = build_field_diff(&stage1_fields, &stage2_fields, V7_CAPTCHA_BRIDGE_KEYS);

    json!({
        "stage1_candidate_body": Value::Object(stage1_obj),
        "retry_patch_only": Value::Object(retry_patch_only),
        "stage1_plus_patch_preview": Value::Object(patched_preview),
        "stage2_effective_body": Value::Object(stage2_obj),
        "patch_diff": patch_diff,
    })
}

fn build_v7_payload_debug_surface(
    explicit_stage1: Option<&Value>,
    stage2_value: &Value,
    stage2_cipher_hex: &str,
    smssend_two_step: Option<&Value>,
) -> Value {
    let retry_views = build_v7_retry_payload_views(explicit_stage1, stage2_value);
    let stage1_value = smssend_two_step
        .and_then(|value| value.get("stage1_payload"))
        .cloned()
        .or_else(|| retry_views.get("stage1_candidate_body").cloned())
        .unwrap_or_else(|| json!({}));
    let stage2_effective = retry_views
        .get("stage2_effective_body")
        .cloned()
        .unwrap_or_else(|| json!({}));
    let stage1_field_diff = match (&stage1_value, &stage2_effective) {
        (Value::Object(stage1_obj), Value::Object(stage2_obj)) => {
            build_top_level_object_delta(stage1_obj, stage2_obj)
        }
        _ => json!({}),
    };

    let stage2_cipher_bytes = if stage2_cipher_hex.trim().is_empty() {
        None
    } else {
        Some(stage2_cipher_hex.len() / 2)
    };
    let stage2_cipher_sha256 = hex::decode(stage2_cipher_hex)
        .ok()
        .map(|bytes| sha256_hex_bytes(&bytes));
    let stage1_cipher_bytes =
        extract_optional_cipher_bytes(smssend_two_step, &["stage1_encrypt", "cipher_bytes"]);
    let stage1_cipher_sha256 =
        extract_optional_cipher_sha256(smssend_two_step, &["stage1_encrypt", "cipher_sha256"]);

    json!({
        "summary": "rnidbg-boss internal payload debug surface for new SMS. It exposes the derived first-stage plaintext body, the effective second-stage plaintext body, null-like keys, namespace decoding, and any available cipher byte metrics without relying on external capture scripts.",
        "stage1_candidate": build_payload_snapshot(&stage1_value, stage1_cipher_bytes, stage1_cipher_sha256),
        "stage2_effective": build_payload_snapshot(&stage2_effective, stage2_cipher_bytes, stage2_cipher_sha256),
        "retry_patch_only": retry_views.get("retry_patch_only").cloned().unwrap_or_else(|| json!({})),
        "stage1_plus_patch_preview": retry_views
            .get("stage1_plus_patch_preview")
            .cloned()
            .unwrap_or_else(|| json!({})),
        "stage1_to_stage2_top_level_delta": stage1_field_diff,
        "known_field_diff": retry_views.get("patch_diff").cloned().unwrap_or_else(|| json!({})),
    })
}

fn build_v7_captcha_business_surface(
    explicit_stage1: Option<&Value>,
    stage2_value: &Value,
) -> Value {
    let bridge_surface = build_v7_captcha_bridge_surface(explicit_stage1, stage2_value);
    let retry_views = build_v7_retry_payload_views(explicit_stage1, stage2_value);
    let branch_type = bridge_surface
        .get("branch_type")
        .and_then(Value::as_str)
        .unwrap_or("unknown");
    let stage1_candidate = retry_views
        .get("stage1_candidate_body")
        .cloned()
        .unwrap_or_else(|| json!({}));
    let retry_patch_only = retry_views
        .get("retry_patch_only")
        .cloned()
        .unwrap_or_else(|| json!({}));
    let stage2_effective = retry_views
        .get("stage2_effective_body")
        .cloned()
        .unwrap_or_else(|| json!({}));
    let verify_status = stage2_effective
        .get("verifyStatus")
        .and_then(Value::as_bool)
        .unwrap_or(false);
    let has_retry_tuple = value_present(stage2_effective.get("rid"))
        && value_present(stage2_effective.get("modeType"))
        && value_present(stage2_effective.get("diffTime"));
    let business_state = match branch_type {
        "captcha_retry_ready" => "captcha_passed_retry_ready",
        "captcha_retry_partial" => "captcha_partial_retry_blocked",
        "first_stage_only" => "first_send_only_waiting_for_captcha",
        _ => "unknown_or_direct_branch",
    };

    let mermaid = [
        "flowchart TD",
        "  user_input[SmsFragment.K0 / user mobile input] --> sms_info[cl6.e -> SMSInfo]",
        "  sms_info --> first_send[o92.getRequestArgs -> mh.a -> u63.a first sendsms]",
        "  first_send --> first_state[first stage business body]",
        "  first_state --> gate1900[resultCode 1900 / captcha required branch]",
        "  gate1900 --> captcha_ui[captcha UI / select or slide challenge]",
        "  captcha_ui --> captcha_result[CaptchaResult(rid, modeType, diffTime)]",
        "  captcha_result --> retry_patch[nz.a retry patch verifyStatus/rid/modeType/diffTime]",
        "  retry_patch --> retry_body[stage1 + retry patch preview]",
        "  retry_body --> second_send[o92.getRequestArgs -> u63.a second sendsms]",
        "  second_send --> ready202[202-ready business request body]",
    ]
    .join("\n");

    json!({
        "summary": "This surface turns the captcha branch into a business-state view: first sendsms, 1900 captcha gate, CaptchaResult production, retry patching, and second sendsms body ready for 202.",
        "observed_branch": branch_type,
        "business_state": business_state,
        "business_flags": {
            "verifyStatus": verify_status,
            "has_retry_tuple": has_retry_tuple,
            "captcha_present": value_present(stage2_effective.get("captcha")),
        },
        "business_states": [
            {
                "order": 1,
                "state": "first_send_business_body",
                "meaning": "Initial sendsms body before captcha tuple exists.",
                "payload": stage1_candidate
            },
            {
                "order": 2,
                "state": "captcha_required_gate",
                "meaning": "Server-side 1900 branch routes into captcha handling.",
                "evidence": {
                    "gate_callback": "u63.onPostExecute/d",
                    "bridge_branch": branch_type
                }
            },
            {
                "order": 3,
                "state": "captcha_business_result",
                "meaning": "CaptchaResult materializes rid/modeType/diffTime for retry.",
                "payload": retry_patch_only
            },
            {
                "order": 4,
                "state": "retry_send_business_body",
                "meaning": "Second sendsms body after nz.a retry patch.",
                "payload": stage2_effective
            }
        ],
        "control_keys": {
            "stage1_candidate": extract_known_fields_from_value(&stage1_candidate, V7_FINGERPRINT_KEYS),
            "retry_patch_only": retry_patch_only,
            "stage2_effective": extract_known_fields_from_value(&stage2_effective, V7_FINGERPRINT_KEYS),
        },
        "graph_mermaid": mermaid,
        "bridge_surface": bridge_surface,
        "retry_payload_views": retry_views,
    })
}

fn build_v7_captcha_ui_surface(
    stage1_value: &Value,
    stage2_value: &Value,
    interactive: bool,
    manual_input: &Map<String, Value>,
    ui_events: &[Value],
) -> Value {
    let bridge_surface = build_v7_captcha_bridge_surface(Some(stage1_value), stage2_value);
    let business_surface = build_v7_captcha_business_surface(Some(stage1_value), stage2_value);
    let retry_views = build_v7_retry_payload_views(Some(stage1_value), stage2_value);
    let observed_branch = bridge_surface
        .get("branch_type")
        .and_then(Value::as_str)
        .unwrap_or("unknown");
    let business_state = business_surface
        .get("business_state")
        .and_then(Value::as_str)
        .unwrap_or("unknown_or_direct_branch");
    let ui_mermaid = [
        "flowchart TD",
        "  click_send[SmsFragment Next Button Click] --> first_send[o92.getRequestArgs first sendsms]",
        "  first_send --> rc1900[resultCode=1900]",
        "  rc1900 --> popup[Captcha Dialog WebView]",
        "  popup --> manual_input[Manual Debug Inputs rid/modeType/diffTime/verifyStatus]",
        "  manual_input --> patch[nz.a retry patch]",
        "  patch --> second_send[o92.getRequestArgs second sendsms]",
        "  second_send --> flow_obs[EncryptUtils data flow observation]",
    ]
    .join("\n");
    json!({
        "summary": "UI-layer captcha debug surface for manually driving 1900->retry patch and returning into flow observation.",
        "interactive": interactive,
        "observed_branch": observed_branch,
        "business_state": business_state,
        "manual_input": Value::Object(manual_input.clone()),
        "ui_events": ui_events,
        "stage1_bridge_fields": extract_known_fields_from_value(stage1_value, V7_CAPTCHA_BRIDGE_KEYS),
        "stage2_bridge_fields": extract_known_fields_from_value(stage2_value, V7_CAPTCHA_BRIDGE_KEYS),
        "graph_mermaid": ui_mermaid,
        "anchors": {
            "ui_entry": "/Users/haojiejack/github/drizzle-dumper-rust/artifacts/palmchat_apponly_jadx_20260324_230038/sources/com/zenmen/palmchat/loginnew/fragment/SmsFragment.java:343",
            "captcha_result_builder": "/Users/haojiejack/github/drizzle-dumper-rust/artifacts/palmchat_apponly_jadx_20260324_230038/sources/com/zenmen/palmchat/utils/captcha/a.java:223",
            "retry_patcher": "/Users/haojiejack/github/drizzle-dumper-rust/artifacts/palmchat_apponly_jadx_20260324_230038/sources/defpackage/nz.java:11"
        },
        "bridge_surface": bridge_surface,
        "business_surface": business_surface,
        "retry_payload_views": retry_views,
    })
}

fn build_palmchat_project_planes(
    stage2_value: &Value,
    app_init_observation: &Value,
    captcha_business_surface: &Value,
) -> Value {
    let observed_branch = captcha_business_surface
        .get("observed_branch")
        .and_then(Value::as_str)
        .unwrap_or("unknown");
    let main_process_gate = app_init_observation
        .get("runtime_inputs")
        .and_then(|v| v.get("main_process_gate"))
        .and_then(Value::as_bool)
        .unwrap_or(false);
    let app_init_called = app_init_observation
        .get("step_chain")
        .and_then(Value::as_array)
        .and_then(|steps| {
            steps.iter().find(|step| {
                step.get("node").and_then(Value::as_str)
                    == Some("PrivInfoManager.INSTANCE.init(this)")
            })
        })
        .and_then(|step| step.get("result"))
        .and_then(Value::as_bool)
        .unwrap_or(false);
    let observed_android_id = stage2_value
        .get("androidId")
        .cloned()
        .unwrap_or(Value::Null);

    let data_plane_mermaid = [
        "flowchart LR",
        "  ui[Login UI / SmsFragment.K0] --> smsinfo[SMSInfo(cl6.e)]",
        "  smsinfo --> reqbuilder[o92.getRequestArgs + mh.a -> sw4]",
        "  reqbuilder --> retrypatch[nz.a retry patch]",
        "  retrypatch --> encrypt[EncryptUtils.setLxData/createCKey/getEncryptedCKey/cipherWithHashKey]",
        "  encrypt --> request[EncryptedJsonRequest]",
        "  request --> wire[Pre-TLS request / network]",
    ]
    .join("\n");

    let control_plane_mermaid = [
        "flowchart TD",
        "  appctx[AppContext.processOnCreate] --> procgate[k86.m + main-process gate]",
        "  procgate --> privinit[PrivInfoManager.init(this)]",
        "  privacy[r75.l privacy gate] --> ac1A[ac1.A(Context)]",
        "  phoneperm[tg4.b READ_PHONE_STATE] --> ac1k[ac1.k(Context)]",
        "  firstresp[u63.onPostExecute 1900] --> captcha[captcha result builder]",
        "  captcha --> patch[nz.a retry patch]",
        "  patch --> secondsend[second sendsms dispatch]",
    ]
    .join("\n");

    json!({
        "summary": "This project-state surface separates the request production path (data plane) from the gate/branch/orchestration path (control plane) for the Palmchat rnidbg project.",
        "project_state": {
            "app_init_plane": {
                "main_process_gate": main_process_gate,
                "priv_info_init_called": app_init_called,
                "status": if app_init_called { "observed_main_process_init" } else { "blocked_or_non_main_process" }
            },
            "identity_plane": {
                "androidId": observed_android_id,
                "status": "observed",
            },
            "captcha_business_plane": {
                "observed_branch": observed_branch,
                "status": "observed",
            },
            "crypto_plane": {
                "status": "proven_in_rnidbg_blackbox",
                "steps": "setLxData->createCKey->getEncryptedCKey->cipherWithHashKey"
            }
        },
        "data_plane": {
            "focus": "Business payload production and encryption before request emission.",
            "components": [
                "SmsFragment.K0 / cl6.e / SMSInfo",
                "o92.getRequestArgs / mh.a / sw4",
                "nz.a retry patch",
                "EncryptUtils native chain",
                "EncryptedJsonRequest / request body"
            ],
            "mermaid": data_plane_mermaid
        },
        "control_plane": {
            "focus": "Initialization, permissions, process gates, and captcha branching.",
            "components": [
                "AppContext.processOnCreate / k86.m main-process gate",
                "PrivInfoManager.init(this)",
                "r75.l privacy gate",
                "tg4.b READ_PHONE_STATE permission gate",
                "u63.onPostExecute 1900 branch",
                "CaptchaResult builder / nz.a retry patch"
            ],
            "mermaid": control_plane_mermaid
        },
        "evidence": {
            "app_init_callsite": app_init_observation
                .get("anchor_callsite")
                .cloned()
                .unwrap_or(Value::Null),
            "captcha_branch": observed_branch,
            "crypto_chain": "setLxData->createCKey->getEncryptedCKey->cipherWithHashKey"
        }
    })
}

fn parse_json_string_or_object(value: Option<&Value>) -> Option<Value> {
    match value {
        Some(Value::Object(map)) => Some(Value::Object(map.clone())),
        Some(Value::String(raw)) => serde_json::from_str::<Value>(raw).ok(),
        _ => None,
    }
}

fn extract_app_list_channel_id(stage2_value: &Value) -> Value {
    parse_json_string_or_object(stage2_value.get("appList"))
        .and_then(|value| value.get("channelId").cloned())
        .unwrap_or(Value::Null)
}

fn build_v7_base_field_production(stage2_value: &Value) -> Value {
    let observed_android_id = stage2_value
        .get("androidId")
        .cloned()
        .unwrap_or(Value::Null);
    let observed_body_channel_id = stage2_value
        .get("channelId")
        .cloned()
        .unwrap_or(Value::Null);
    let observed_app_list_channel_id = extract_app_list_channel_id(stage2_value);

    json!({
        "summary": "androidId and body.channelId are base-field producers that are established before captcha retry patching. body.channelId comes from ac1.m asset initialization, while androidId comes from PrivInfoManager -> wm4.h() -> Settings.Secure android_id.",
        "field_sources": {
            "androidId": {
                "consumer": "mh.a -> sw4.f20862a.put(\"androidId\", ac1.p)",
                "producer": "ac1.e(Context)",
                "upstream_origin": "PrivInfoManager.INSTANCE.getAndroidID() -> wm4.h() -> Settings.Secure.getString(contentResolver, \"android_id\")",
                "cache_slots": ["ac1.p", "wm4.n"],
                "fallback": "If Settings.Secure android_id is empty, wm4.h() falls back to MediaInfo.RENDERER_TYPE_UNKNOWN.",
                "observed_value": observed_android_id,
            },
            "channelId": {
                "consumer": "mh.a -> sw4.f20862a.put(\"channelId\", ac1.m)",
                "producer": "ac1.c(Context)",
                "upstream_origin": "Read first line of asset file \"channel\" into ac1.m, then ac1.p(Context) returns it.",
                "cache_slots": ["ac1.m"],
                "observed_body_value": observed_body_channel_id,
                "note": "This is the body channelId. It is not the same as appList.channelId."
            },
            "appList.channelId": {
                "consumer": "ac1.s() -> JSONObject.put(\"channelId\", ac1.m + \"_\" + xn3.a())",
                "producer": "ac1.s()",
                "upstream_origin": "appList reuses ac1.m but appends a request-scoped suffix from xn3.a().",
                "suffix_formula": "xn3.a() = random4 + ir5.b()",
                "observed_value": observed_app_list_channel_id,
            }
        },
        "production_chain": [
            {
                "order": 1,
                "node": "ac1.B(Context)",
                "kind": "bootstrap",
                "role": "Initializes base identity fields before request builders consume them."
            },
            {
                "order": 2,
                "node": "ac1.p(Context) -> ac1.c(Context)",
                "kind": "channel_asset_init",
                "role": "Initializes ac1.m by reading the asset file named channel."
            },
            {
                "order": 3,
                "node": "ac1.e(Context)",
                "kind": "android_id_capture",
                "role": "Stores androidId into ac1.p and also updates did = imei + '_' + mac + '_' + androidId."
            },
            {
                "order": 4,
                "node": "PrivInfoManager.getAndroidID() -> wm4.h()",
                "kind": "android_id_provider",
                "role": "Reads Settings.Secure android_id once and memoizes it in wm4.n."
            },
            {
                "order": 5,
                "node": "mh.a(String)",
                "kind": "request_builder_consumer",
                "role": "Consumes ac1.m/ac1.p into body.channelId/body.androidId."
            },
            {
                "order": 6,
                "node": "ac1.s()",
                "kind": "app_list_variant",
                "role": "Builds appList JSON and emits appList.channelId = ac1.m + '_' + xn3.a()."
            }
        ]
    })
}

fn build_v7_identity_dependency_graph(stage2_value: &Value) -> Value {
    let observed_android_id = stage2_value
        .get("androidId")
        .cloned()
        .unwrap_or(Value::Null);
    let observed_body_channel_id = stage2_value
        .get("channelId")
        .cloned()
        .unwrap_or(Value::Null);
    let observed_app_list_channel_id = extract_app_list_channel_id(stage2_value);
    let observed_did = stage2_value.get("did").cloned().unwrap_or(Value::Null);
    let observed_imei = stage2_value.get("imei").cloned().unwrap_or(Value::Null);
    let observed_mac = stage2_value.get("mac").cloned().unwrap_or(Value::Null);

    let nodes = json!([
        {
            "id": "settings_android_id",
            "label": "Settings.Secure android_id",
            "kind": "system_source"
        },
        {
            "id": "r75_l",
            "label": "r75.l()",
            "kind": "gate"
        },
        {
            "id": "ac1_a",
            "label": "ac1.A(Context)",
            "kind": "gate_dispatch"
        },
        {
            "id": "telephony_device_id",
            "label": "TelephonyManager.getDeviceId()",
            "kind": "system_source"
        },
        {
            "id": "wm4_k",
            "label": "wm4.k()",
            "kind": "provider"
        },
        {
            "id": "privinfo_imei",
            "label": "PrivInfoManager.getIMEI()",
            "kind": "provider"
        },
        {
            "id": "ac1_k_context",
            "label": "ac1.k(Context)",
            "kind": "assembler"
        },
        {
            "id": "ac1_i",
            "label": "ac1.i (imei cache)",
            "kind": "cache_slot"
        },
        {
            "id": "wm4_h",
            "label": "wm4.h()",
            "kind": "provider"
        },
        {
            "id": "privinfo_android_id",
            "label": "PrivInfoManager.getAndroidID()",
            "kind": "provider"
        },
        {
            "id": "ac1_e",
            "label": "ac1.e(Context)",
            "kind": "assembler"
        },
        {
            "id": "ac1_p",
            "label": "ac1.p (androidId cache)",
            "kind": "cache_slot"
        },
        {
            "id": "body_android_id",
            "label": "body.androidId",
            "kind": "request_field"
        },
        {
            "id": "assets_channel",
            "label": "assets/channel",
            "kind": "asset_source"
        },
        {
            "id": "ac1_c",
            "label": "ac1.c(Context)",
            "kind": "loader"
        },
        {
            "id": "ac1_m",
            "label": "ac1.m (channelId cache)",
            "kind": "cache_slot"
        },
        {
            "id": "body_channel_id",
            "label": "body.channelId",
            "kind": "request_field"
        },
        {
            "id": "xn3_a",
            "label": "xn3.a()",
            "kind": "suffix_builder"
        },
        {
            "id": "app_list_channel_id",
            "label": "appList.channelId",
            "kind": "request_field_variant"
        },
        {
            "id": "imei_mac",
            "label": "imei + '_' + mac",
            "kind": "base_inputs"
        },
        {
            "id": "ac1_g",
            "label": "ac1.g()",
            "kind": "assembler"
        },
        {
            "id": "ac1_r_stub",
            "label": "ac1.r() -> empty string",
            "kind": "stubbed_source"
        },
        {
            "id": "ac1_k_mac",
            "label": "ac1.k (mac cache)",
            "kind": "cache_slot"
        },
        {
            "id": "did_field",
            "label": "did",
            "kind": "request_field"
        },
        {
            "id": "mh_a",
            "label": "mh.a(String)",
            "kind": "request_builder"
        }
    ]);

    let edges = json!([
        {
            "from": "r75_l",
            "to": "ac1_a",
            "label": "gate true"
        },
        {
            "from": "ac1_a",
            "to": "ac1_k_context",
            "label": "invoke"
        },
        {
            "from": "telephony_device_id",
            "to": "wm4_k",
            "label": "getDeviceId"
        },
        {
            "from": "wm4_k",
            "to": "privinfo_imei",
            "label": "return imei"
        },
        {
            "from": "privinfo_imei",
            "to": "ac1_k_context",
            "label": "imei input"
        },
        {
            "from": "ac1_k_context",
            "to": "ac1_i",
            "label": "ac1.i = imei"
        },
        {
            "from": "settings_android_id",
            "to": "wm4_h",
            "label": "Settings.Secure.getString(contentResolver, \"android_id\")"
        },
        {
            "from": "wm4_h",
            "to": "privinfo_android_id",
            "label": "return androidId"
        },
        {
            "from": "privinfo_android_id",
            "to": "ac1_e",
            "label": "androidId input"
        },
        {
            "from": "ac1_e",
            "to": "ac1_p",
            "label": "ac1.p = androidId"
        },
        {
            "from": "ac1_p",
            "to": "body_android_id",
            "label": "mh.a put(\"androidId\", ac1.p)"
        },
        {
            "from": "assets_channel",
            "to": "ac1_c",
            "label": "read first line"
        },
        {
            "from": "ac1_c",
            "to": "ac1_m",
            "label": "ac1.m = asset line"
        },
        {
            "from": "ac1_m",
            "to": "body_channel_id",
            "label": "mh.a put(\"channelId\", ac1.m)"
        },
        {
            "from": "ac1_m",
            "to": "app_list_channel_id",
            "label": "prefix"
        },
        {
            "from": "xn3_a",
            "to": "app_list_channel_id",
            "label": "dynamic suffix"
        },
        {
            "from": "ac1_i",
            "to": "imei_mac",
            "label": "imei segment"
        },
        {
            "from": "ac1_a",
            "to": "ac1_g",
            "label": "invoke"
        },
        {
            "from": "ac1_g",
            "to": "ac1_r_stub",
            "label": "k = r()"
        },
        {
            "from": "ac1_r_stub",
            "to": "ac1_k_mac",
            "label": "mac becomes empty string"
        },
        {
            "from": "ac1_k_mac",
            "to": "imei_mac",
            "label": "mac segment"
        },
        {
            "from": "ac1_p",
            "to": "did_field",
            "label": "right segment androidId"
        },
        {
            "from": "imei_mac",
            "to": "did_field",
            "label": "left segment"
        },
        {
            "from": "body_android_id",
            "to": "mh_a",
            "label": "serialized into sw4"
        },
        {
            "from": "body_channel_id",
            "to": "mh_a",
            "label": "serialized into sw4"
        },
        {
            "from": "did_field",
            "to": "mh_a",
            "label": "serialized into sw4"
        },
        {
            "from": "app_list_channel_id",
            "to": "mh_a",
            "label": "serialized via ac1.s()"
        }
    ]);

    let mermaid = [
        "flowchart TD",
        "  r75_l[r75.l gate] -->|true| ac1_a[ac1.A(Context)]",
        "  telephony_device_id[TelephonyManager.getDeviceId] -->|getDeviceId| wm4_k[wm4.k()]",
        "  wm4_k --> privinfo_imei[PrivInfoManager.getIMEI()]",
        "  privinfo_imei --> ac1_k_context[ac1.k(Context)]",
        "  ac1_k_context --> ac1_i[ac1.i imei cache]",
        "  settings_android_id[Settings.Secure android_id] -->|getString| wm4_h[wm4.h()]",
        "  wm4_h --> privinfo_android_id[PrivInfoManager.getAndroidID()]",
        "  privinfo_android_id --> ac1_e[ac1.e(Context)]",
        "  ac1_e --> ac1_p[ac1.p androidId cache]",
        "  ac1_p --> body_android_id[body.androidId]",
        "  assets_channel[assets/channel] --> ac1_c[ac1.c(Context)]",
        "  ac1_c --> ac1_m[ac1.m channelId cache]",
        "  ac1_m --> body_channel_id[body.channelId]",
        "  ac1_m --> app_list_channel_id[appList.channelId]",
        "  xn3_a[xn3.a random4 + ir5.b] --> app_list_channel_id",
        "  ac1_a --> ac1_g[ac1.g()]",
        "  ac1_g --> ac1_r_stub[ac1.r() returns empty string]",
        "  ac1_r_stub --> ac1_k_mac[ac1.k mac cache]",
        "  ac1_i --> imei_mac[imei + '_' + mac]",
        "  ac1_k_mac --> imei_mac",
        "  ac1_p --> did_field",
        "  imei_mac --> did_field[did]",
        "  body_android_id --> mh_a[mh.a(String)]",
        "  body_channel_id --> mh_a",
        "  did_field --> mh_a",
        "  app_list_channel_id --> mh_a",
    ]
    .join("\n");

    json!({
        "summary": "This graph merges the base identity producers that feed body.androidId, body.channelId, appList.channelId, and did before encryption. The key distinction is body.channelId = ac1.m, while appList.channelId = ac1.m + '_' + xn3.a(). For did, imei comes from TelephonyManager.getDeviceId via PrivInfoManager.getIMEI, but mac is currently cut to an empty string by ac1.r() in this build.",
        "observed_values": {
            "androidId": observed_android_id,
            "body.channelId": observed_body_channel_id,
            "appList.channelId": observed_app_list_channel_id,
            "imei": observed_imei,
            "mac": observed_mac,
            "did": observed_did,
        },
        "nodes": nodes,
        "edges": edges,
        "mermaid": mermaid,
        "evidence": {
            "body_channel_id_consumer": "mh.a -> put(\"channelId\", ac1.m)",
            "body_android_id_consumer": "mh.a -> put(\"androidId\", ac1.p)",
            "did_consumer": "mh.a -> put(\"did\", ac1.o)",
            "did_formula": "ac1.e(Context): o = i + '_' + k + '_' + p",
            "app_list_channel_id_formula": "ac1.s(): channelId = m + '_' + xn3.a()",
            "android_id_provider": "wm4.h(): Settings.Secure.getString(contentResolver, \"android_id\")",
            "imei_provider": "wm4.k(): TelephonyManager.getDeviceId() -> PrivInfoManager.getIMEI() -> ac1.k(Context)",
            "mac_current_build_source": "ac1.g() -> k = r(); ac1.r() currently returns empty string"
        }
    })
}

fn build_v7_identity_gate_diagnostics() -> Value {
    json!({
        "summary": "Three static gates determine whether imei/androidId-related identity collection runs: privacy-agree gate r75.l(), PHONE_STATE permission gate tg4.b(...READ_PHONE_STATE), and PrivInfoManager initialization gate. These are code-proven gates; actual runtime truth values still require a live probe in the target process.",
        "gates": {
            "privacy_agree_gate": {
                "gate_fn": "r75.l()",
                "effect": "ac1.A(Context) only executes k(context), g(), e(context) when r75.l() returns true.",
                "evidence": {
                    "callsite": "ac1.A(Context): if (r75.l()) { k(context); g(); e(context); }",
                    "storage": "SharedPreferences key sp_privacy_agree",
                    "cache": "r75.b AtomicInteger",
                    "rule": "r75.l() returns b.get() == 1"
                },
                "runtime_status": "blocked_without_live_probe"
            },
            "phone_state_permission_gate": {
                "gate_fn": "tg4.b(context, BaseActivityPermissionDispatcher.PermissionType.PHONE_STATE.permissionList)",
                "effect": "ac1.k(Context) only attempts PrivInfoManager.getIMEI()/getIMSI when READ_PHONE_STATE permission passes.",
                "evidence": {
                    "permission_type": "PHONE_STATE(2, new String[]{android.permission.READ_PHONE_STATE})",
                    "checker": "tg4.b -> PermissionChecker.checkSelfPermission(context, permission) == 0",
                    "sdk_filter": "tg4.c(permission): permission considered only when Build.VERSION.SDK_INT meets threshold"
                },
                "runtime_status": "blocked_without_live_probe"
            },
            "priv_info_init_gate": {
                "gate_fn": "PrivInfoManager.init(Context)",
                "effect": "getAndroidID/getIMEI/getMac short-circuit until isInit=true and mImpl=new wm4(applicationContext).",
                "evidence": {
                    "init": "PrivInfoManager.init(Context): if !isInit { mContext=appContext; mImpl=new wm4(appContext); isInit=true; }",
                    "android_id_guard": "getAndroidID(): !isInit ? \"none\" : mImpl.h()",
                    "imei_guard": "getIMEI(): !isInit ? \"\" : mImpl.k()",
                    "mac_guard": "getMac(): !isInit ? \"\" : mImpl.n()"
                },
                "runtime_status": "blocked_without_live_probe"
            }
        },
        "current_build_note": {
            "did_mac_path": "Even if PrivInfoManager.getMac() exists, current did assembly does not consume it directly here.",
            "did_mac_source": "ac1.g() -> k = r(); ac1.r() currently returns empty string",
            "impact": "In this build, did can degrade to imei + '_' + '' + '_' + androidId, or null/empty on the imei side as observed."
        }
    })
}

fn jni_value_to_string(value: JniValue) -> Result<String> {
    match value {
        JniValue::Object(DvmObject::String(value)) => Ok(value),
        JniValue::Object(DvmObject::ByteArray(bytes)) => {
            Ok(String::from_utf8_lossy(&bytes).to_string())
        }
        JniValue::Null | JniValue::Void => Ok(String::new()),
        other => Err(anyhow!(
            "unexpected JNI return type for string: {}",
            other.to_string()
        )),
    }
}

fn jni_value_to_bytes(value: JniValue) -> Result<Vec<u8>> {
    match value {
        JniValue::Object(DvmObject::ByteArray(bytes)) => Ok(bytes),
        JniValue::Object(DvmObject::String(value)) => Ok(value.into_bytes()),
        JniValue::Null | JniValue::Void => Ok(Vec::new()),
        other => Err(anyhow!(
            "unexpected JNI return type for bytes: {}",
            other.to_string()
        )),
    }
}

fn bytes_from_dvm_object(object: &DvmObject) -> Option<Vec<u8>> {
    match object {
        DvmObject::ByteArray(bytes) => Some(bytes.clone()),
        DvmObject::String(value) => Some(value.clone().into_bytes()),
        _ => None,
    }
}

fn bytes_from_object_id(vm: &mut DalvikVM64<()>, object_id: i64) -> Option<Vec<u8>> {
    object_from_id_mut(vm, object_id).and_then(|object| bytes_from_dvm_object(&*object))
}

fn secret_pair_from_dvm_object(object: &DvmObject) -> Option<PalmchatSecretPair> {
    let pair = data_ref::<PalmchatPairState>(object)?;
    let key = pair.first.as_ref().and_then(bytes_from_dvm_object)?;
    let iv = pair.second.as_ref().and_then(bytes_from_dvm_object)?;
    if key.is_empty() || iv.is_empty() {
        return None;
    }
    Some(PalmchatSecretPair { key, iv })
}

fn jni_value_to_secret_pair(value: JniValue) -> Option<PalmchatSecretPair> {
    match value {
        JniValue::Object(object) => secret_pair_from_dvm_object(&object),
        JniValue::Null | JniValue::Void => None,
        _ => None,
    }
}

fn value_from_json_object(object: &DvmObject) -> Option<Value> {
    data_ref::<JsonObjectState>(object).map(|state| Value::Object(state.map.clone()))
}

fn value_from_json_object_with_vm(vm: &mut DalvikVM64<()>, object: &DvmObject) -> Option<Value> {
    match object {
        DvmObject::ObjectRef(object_id) => {
            object_from_id_mut(vm, *object_id).and_then(|value| value_from_json_object(&*value))
        }
        other => value_from_json_object(other),
    }
}

fn jni_value_to_json_value(value: &JniValue) -> Option<Value> {
    match value {
        JniValue::Object(object) => value_from_json_object(object),
        _ => None,
    }
}

fn jni_value_to_json_value_with_vm(vm: &mut DalvikVM64<()>, value: &JniValue) -> Option<Value> {
    match value {
        JniValue::Object(object) => value_from_json_object_with_vm(vm, object),
        _ => None,
    }
}

fn extract_secret_pair_from_refresh_result(value: &Value) -> Option<(String, String)> {
    let mut candidates = vec![value];
    if let Some(data) = value.get("data") {
        candidates.push(data);
    }
    for candidate in candidates {
        let skey = candidate
            .get("skey")
            .and_then(|value| normalize_plain_candidate(Some(value_to_string_lossy(value))));
        let iv = candidate
            .get("iv")
            .and_then(|value| normalize_plain_candidate(Some(value_to_string_lossy(value))));
        if let (Some(skey), Some(iv)) = (skey, iv) {
            return Some((skey, iv));
        }
    }
    None
}

fn value_to_string_lossy(value: &Value) -> String {
    match value {
        Value::String(value) => value.clone(),
        other => other.to_string(),
    }
}

fn bytes_from_maybe_truncated_ref(vm: &mut DalvikVM64<()>, raw_id: i64) -> Option<Vec<u8>> {
    if let Some(bytes) = bytes_from_object_id(vm, raw_id) {
        return Some(bytes);
    }
    let seq = (raw_id as u64 & 0xFFFF_FFFF) as i64;
    let local_candidate = (jni::JNI_FLAG_OBJECT << 32) | seq;
    if let Some(bytes) = bytes_from_object_id(vm, local_candidate) {
        return Some(bytes);
    }
    let global_candidate = (jni::JNI_FLAG_REF << 32) | seq;
    bytes_from_object_id(vm, global_candidate)
}

fn jni_value_to_bytes_with_vm(vm: &mut DalvikVM64<()>, value: JniValue) -> Result<Vec<u8>> {
    match value {
        JniValue::Object(object) => match object {
            DvmObject::ObjectRef(object_id) => object_from_id_mut(vm, object_id)
                .and_then(|object| bytes_from_dvm_object(&*object))
                .ok_or_else(|| {
                    anyhow!("unable to decode object ref bytes from id=0x{object_id:x}")
                }),
            other => bytes_from_dvm_object(&other)
                .ok_or_else(|| anyhow!("unexpected JNI object return type for bytes")),
        },
        JniValue::Int(object_id) => bytes_from_maybe_truncated_ref(vm, object_id as i64)
            .ok_or_else(|| anyhow!("unable to decode int object bytes from id={object_id}")),
        JniValue::Long(object_id) => bytes_from_maybe_truncated_ref(vm, object_id)
            .ok_or_else(|| anyhow!("unable to decode long object bytes from id=0x{object_id:x}")),
        JniValue::Null | JniValue::Void => Ok(Vec::new()),
        other => Err(anyhow!(
            "unexpected JNI return type for bytes with vm: {}",
            other.to_string()
        )),
    }
}

fn jni_value_to_bool(value: JniValue) -> Result<bool> {
    match value {
        JniValue::Boolean(v) => Ok(v),
        JniValue::Int(v) => Ok(v != 0),
        JniValue::Long(v) => Ok(v != 0),
        JniValue::Null | JniValue::Void => Ok(false),
        other => Err(anyhow!(
            "unexpected JNI return type for bool: {}",
            other.to_string()
        )),
    }
}

fn jni_value_to_int(value: JniValue) -> Result<i32> {
    match value {
        JniValue::Int(v) => Ok(v),
        JniValue::Boolean(v) => Ok(if v { 1 } else { 0 }),
        JniValue::Long(v) => {
            i32::try_from(v).map_err(|_| anyhow!("jni long out of range for int conversion: {v}"))
        }
        other => Err(anyhow!(
            "unexpected JNI return type for int: {}",
            other.to_string()
        )),
    }
}

fn describe_jni_value(value: &JniValue) -> String {
    match value {
        JniValue::Void => "void".to_string(),
        JniValue::Null => "null".to_string(),
        JniValue::Boolean(v) => format!("boolean:{v}"),
        JniValue::Byte(v) => format!("byte:{v}"),
        JniValue::Char(v) => format!("char:{v}"),
        JniValue::Short(v) => format!("short:{v}"),
        JniValue::Int(v) => format!("int:{v}"),
        JniValue::Long(v) => format!("long:0x{:x}", *v as u64),
        JniValue::Float(v) => format!("float:{v}"),
        JniValue::Double(v) => format!("double:{v}"),
        JniValue::Object(DvmObject::ByteArray(bytes)) => {
            format!("object:byte_array(len={})", bytes.len())
        }
        JniValue::Object(DvmObject::String(value)) => format!("object:string(len={})", value.len()),
        JniValue::Object(DvmObject::ObjectRef(id)) => format!("object:ref(0x{:x})", *id as u64),
        JniValue::Object(_) => "object:other".to_string(),
    }
}

fn new_mut_data_object(class: Rc<DvmClass>, value: impl Any) -> DvmObject {
    DvmObject::DataMutInstance(class, Rc::new(UnsafeCell::new(Box::new(value))))
}

fn data_ref<'a, T: 'static>(object: &'a DvmObject) -> Option<&'a T> {
    match object {
        DvmObject::DataMutInstance(_, data) => unsafe { (&*data.get()).downcast_ref::<T>() },
        DvmObject::DataInstance(_, data) => data.downcast_ref::<T>(),
        _ => None,
    }
}

fn data_mut<'a, T: 'static>(object: &'a mut DvmObject) -> Option<&'a mut T> {
    match object {
        DvmObject::DataMutInstance(_, data) => unsafe { (&mut *data.get()).downcast_mut::<T>() },
        _ => None,
    }
}

fn object_from_id_mut<'a>(vm: &'a mut DalvikVM64<()>, object_id: i64) -> Option<&'a mut DvmObject> {
    match jni::get_flag_id(object_id) {
        jni::JNI_FLAG_OBJECT => vm.get_local_ref_mut(object_id),
        jni::JNI_FLAG_REF => vm.get_global_ref_mut(object_id),
        _ => None,
    }
}

fn string_from_object(object: &DvmObject) -> String {
    match object {
        DvmObject::String(value) => value.clone(),
        DvmObject::ByteArray(bytes) => String::from_utf8_lossy(bytes).to_string(),
        _ => String::new(),
    }
}

fn string_array_from_object(object: &DvmObject) -> Vec<String> {
    match object {
        DvmObject::ObjectArray(_, values) => values
            .iter()
            .filter_map(|value| value.as_ref().map(string_from_object))
            .collect(),
        DvmObject::String(value) => vec![value.clone()],
        _ => Vec::new(),
    }
}

fn string_from_id(vm: &mut DalvikVM64<()>, object_id: i64) -> String {
    match object_from_id_mut(vm, object_id) {
        Some(object) => string_from_object(object),
        None => String::new(),
    }
}

fn permission_granted(state: &PalmchatIdentityRuntimeState, permission: &str) -> bool {
    match permission {
        "android.permission.READ_PHONE_STATE" => state.effective_read_phone_state(),
        _ => true,
    }
}

fn app_init_main_process_gate(package_name: &str, process_name: &str) -> bool {
    process_name.trim().is_empty() || process_name == package_name
}

fn object_to_json_value(object: &DvmObject) -> Value {
    match object {
        DvmObject::String(value) => Value::String(value.clone()),
        DvmObject::ByteArray(bytes) => Value::String(String::from_utf8_lossy(bytes).to_string()),
        _ => Value::Null,
    }
}

fn iso_now() -> String {
    Utc::now().to_rfc3339_opts(SecondsFormat::Nanos, true)
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn split_log_line_parses_timestamp_and_message() {
        let line = "[2026-03-29T07:51:47.433861000Z] flow result={\"ok\":true}";
        let (timestamp, message) = split_log_line(line).expect("line should parse");
        assert_eq!(timestamp, "2026-03-29T07:51:47.433861000Z");
        assert_eq!(message, "flow result={\"ok\":true}");
    }

    #[test]
    fn parse_step_message_tracks_duration_and_return_debug() {
        let mut report = PalmchatFlowReport {
            status: "blocked".to_string(),
            native_log: "/tmp/palmchat_native.log".to_string(),
            config_path: None,
            trace_out_dir: None,
            flow: None,
            flow_result: None,
            steps: BTreeMap::new(),
            cipher_evidence: PalmchatCipherEvidenceReport::default(),
            plt_targets: BTreeMap::new(),
        };
        parse_step_message(
            &mut report,
            "2026-03-29T07:50:33.204956000Z",
            "flow step=cipherWithHashKey start",
        )
        .expect("start parse");
        parse_step_message(
            &mut report,
            "2026-03-29T07:51:47.433725000Z",
            "flow step=cipherWithHashKey return=object:byte_array(len=48)",
        )
        .expect("return parse");
        parse_step_message(
            &mut report,
            "2026-03-29T07:51:47.433736000Z",
            "flow step=cipherWithHashKey done bytes_len=48",
        )
        .expect("done parse");

        let step = report
            .steps
            .get("cipherWithHashKey")
            .expect("step should exist");
        assert_eq!(
            step.return_debug.as_deref(),
            Some("object:byte_array(len=48)")
        );
        assert_eq!(step.done_note.as_deref(), Some("bytes_len=48"));
        assert!(step.duration_ms.unwrap_or_default() > 0);
    }

    #[test]
    fn v7_extract_known_fields_only_keeps_target_keys() {
        let raw = json!({
            "mobile": "18888888888",
            "appId": "ZX0001",
            "verifyStatus": true,
            "unknown": "drop-me"
        });
        let extracted = extract_known_fields_from_value(&raw, V7_FINGERPRINT_KEYS);
        assert_eq!(extracted.get("mobile"), Some(&json!("18888888888")));
        assert_eq!(extracted.get("appId"), Some(&json!("ZX0001")));
        assert_eq!(extracted.get("verifyStatus"), Some(&json!(true)));
        assert!(!extracted.contains_key("unknown"));
    }

    #[test]
    fn v7_compare_field_alignment_tracks_stable_and_changed() {
        let produce = json!({
            "mobile": "18888888888",
            "appId": "ZX0001",
            "verifyStatus": true
        });
        let consume = json!({
            "mobile": "18888888888",
            "appId": "ZX0002",
            "verifyStatus": true
        });
        let produce_fields = extract_known_fields_from_value(&produce, V7_FINGERPRINT_KEYS);
        let consume_fields = extract_known_fields_from_value(&consume, V7_FINGERPRINT_KEYS);
        let (stable, changed) = compare_field_alignment(&produce_fields, &consume_fields);
        assert_eq!(
            stable,
            vec!["mobile".to_string(), "verifyStatus".to_string()]
        );
        assert_eq!(
            changed.get("appId"),
            Some(&json!({
                "produce": "ZX0001",
                "consume": "ZX0002"
            }))
        );
    }

    #[test]
    fn derive_v7_first_stage_candidate_strips_retry_tuple() {
        let stage2 = json!({
            "mobile": "15390455973",
            "countryCode": "86",
            "verifyStatus": true,
            "rid": "RID123",
            "modeType": "select",
            "diffTime": "6551",
            "appId": "ZX0001"
        });
        let stage1 = derive_v7_first_stage_candidate(&stage2);
        assert_eq!(stage1.get("mobile"), Some(&json!("15390455973")));
        assert_eq!(stage1.get("countryCode"), Some(&json!("86")));
        assert_eq!(stage1.get("verifyStatus"), Some(&json!(false)));
        assert!(stage1.get("rid").is_none());
        assert!(stage1.get("modeType").is_none());
        assert!(stage1.get("diffTime").is_none());
    }

    #[test]
    fn build_v7_captcha_bridge_surface_tracks_retry_patch() {
        let stage2 = json!({
            "mobile": "15390455973",
            "countryCode": "86",
            "verifyStatus": true,
            "rid": "RID123",
            "modeType": "select",
            "diffTime": "6551",
            "appId": "ZX0001"
        });
        let surface = build_v7_captcha_bridge_surface(None, &stage2);
        assert_eq!(
            surface.get("branch_type").and_then(Value::as_str),
            Some("captcha_retry_ready")
        );
        let retry_patch = surface
            .get("retry_patch_diff")
            .and_then(Value::as_object)
            .expect("retry_patch_diff should be object");
        assert_eq!(
            retry_patch.get("verifyStatus"),
            Some(&json!({
                "before": false,
                "after": true
            }))
        );
        assert_eq!(
            retry_patch.get("rid"),
            Some(&json!({
                "before": Value::Null,
                "after": "RID123"
            }))
        );
        assert_eq!(
            retry_patch.get("modeType"),
            Some(&json!({
                "before": Value::Null,
                "after": "select"
            }))
        );
        assert_eq!(
            retry_patch.get("diffTime"),
            Some(&json!({
                "before": Value::Null,
                "after": "6551"
            }))
        );
    }

    #[test]
    fn build_v7_captcha_upstream_production_contains_expected_producers() {
        let stage2 = json!({
            "mobile": "15390455973",
            "countryCode": "86",
            "verifyStatus": true,
            "rid": "RID123",
            "modeType": "select",
            "diffTime": "6551",
            "appId": "ZX0001"
        });
        let upstream = build_v7_captcha_upstream_production(None, &stage2);
        assert_eq!(
            upstream.get("branch_type").and_then(Value::as_str),
            Some("captcha_retry_ready")
        );
        let field_sources = upstream
            .get("field_sources")
            .and_then(Value::as_object)
            .expect("field_sources should exist");
        assert_eq!(
            field_sources
                .get("verifyStatus")
                .and_then(|v| v.get("producer"))
                .and_then(Value::as_str),
            Some("nz.a(HashMap<String,Object>, CaptchaResult)")
        );
        assert_eq!(
            field_sources
                .get("rid")
                .and_then(|v| v.get("upstream_origin"))
                .and_then(Value::as_str),
            Some("captchaBean.rid")
        );
    }

    #[test]
    fn build_v7_base_field_production_contains_android_and_channel_sources() {
        let stage2 = json!({
            "androidId": "abc123android",
            "channelId": "ZX0001",
            "appList": "{\"channelId\":\"ZX0001_abcd1711111111111\",\"package\":[\"com.zenmen.palmchat\"]}"
        });
        let base_field = build_v7_base_field_production(&stage2);
        let field_sources = base_field
            .get("field_sources")
            .and_then(Value::as_object)
            .expect("field_sources should exist");
        assert_eq!(
            field_sources
                .get("androidId")
                .and_then(|v| v.get("producer"))
                .and_then(Value::as_str),
            Some("ac1.e(Context)")
        );
        assert_eq!(
            field_sources
                .get("channelId")
                .and_then(|v| v.get("producer"))
                .and_then(Value::as_str),
            Some("ac1.c(Context)")
        );
        assert_eq!(
            field_sources
                .get("appList.channelId")
                .and_then(|v| v.get("observed_value"))
                .and_then(Value::as_str),
            Some("ZX0001_abcd1711111111111")
        );
    }

    #[test]
    fn build_v7_identity_dependency_graph_contains_mermaid_and_observed_values() {
        let stage2 = json!({
            "androidId": "abc123android",
            "channelId": "ZX0001",
            "imei": Value::Null,
            "mac": "",
            "did": "imei_mac_abc123android",
            "appList": "{\"channelId\":\"ZX0001_abcd1711111111111\",\"package\":[{\"packageName\":\"com.zenmen.palmchat\"}]}"
        });
        let graph = build_v7_identity_dependency_graph(&stage2);
        assert_eq!(
            graph
                .get("observed_values")
                .and_then(|v| v.get("androidId"))
                .and_then(Value::as_str),
            Some("abc123android")
        );
        assert_eq!(
            graph
                .get("observed_values")
                .and_then(|v| v.get("appList.channelId"))
                .and_then(Value::as_str),
            Some("ZX0001_abcd1711111111111")
        );
        assert_eq!(
            graph
                .get("observed_values")
                .and_then(|v| v.get("mac"))
                .and_then(Value::as_str),
            Some("")
        );
        assert!(graph
            .get("mermaid")
            .and_then(Value::as_str)
            .map(|v| {
                v.contains("appList.channelId")
                    && v.contains("Settings.Secure android_id")
                    && v.contains("ac1.r() returns empty string")
            })
            .unwrap_or(false));
    }

    #[test]
    fn build_v7_identity_gate_diagnostics_contains_three_gates() {
        let diag = build_v7_identity_gate_diagnostics();
        let gates = diag
            .get("gates")
            .and_then(Value::as_object)
            .expect("gates should exist");
        assert!(gates.contains_key("privacy_agree_gate"));
        assert!(gates.contains_key("phone_state_permission_gate"));
        assert!(gates.contains_key("priv_info_init_gate"));
        assert_eq!(
            gates
                .get("phone_state_permission_gate")
                .and_then(|v| v.get("evidence"))
                .and_then(|v| v.get("permission_type"))
                .and_then(Value::as_str),
            Some("PHONE_STATE(2, new String[]{android.permission.READ_PHONE_STATE})")
        );
    }

    #[test]
    fn identity_runtime_state_applies_permission_gate() {
        let state = PalmchatIdentityRuntimeState {
            privacy_agree: Some(true),
            read_phone_state_granted: Some(false),
            priv_info_initialized: true,
            android_id: "abc123".to_string(),
            imei: "imei-value".to_string(),
            mac: "mac-value".to_string(),
            sdid: "sdid-value".to_string(),
            local_smid: "local-smid-value".to_string(),
            device_label: "device-label".to_string(),
            process_name: "com.zenmen.palmchat".to_string(),
        };
        assert_eq!(state.effective_android_id(), "abc123");
        assert_eq!(state.effective_imei(), "");
        assert_eq!(state.effective_mac(), "mac-value");
    }

    #[test]
    fn string_array_from_object_extracts_values() {
        let (_, string_class) = build_class_resolver()
            .find_class_by_name("java/lang/String")
            .expect("string class");
        let object = DvmObject::ObjectArray(
            string_class,
            vec![
                Some(DvmObject::String(
                    "android.permission.READ_PHONE_STATE".to_string(),
                )),
                Some(DvmObject::String(
                    "android.permission.ACCESS_WIFI_STATE".to_string(),
                )),
            ],
        );
        assert_eq!(
            string_array_from_object(&object),
            vec![
                "android.permission.READ_PHONE_STATE".to_string(),
                "android.permission.ACCESS_WIFI_STATE".to_string()
            ]
        );
    }

    #[test]
    fn app_init_main_process_gate_accepts_empty_or_package_name() {
        assert!(app_init_main_process_gate("com.zenmen.palmchat", ""));
        assert!(app_init_main_process_gate(
            "com.zenmen.palmchat",
            "com.zenmen.palmchat"
        ));
        assert!(!app_init_main_process_gate(
            "com.zenmen.palmchat",
            "com.zenmen.palmchat:push"
        ));
    }

    #[test]
    fn build_v7_captcha_business_surface_marks_retry_ready_branch() {
        let stage2 = json!({
            "mobile": "15390455973",
            "countryCode": "86",
            "verifyStatus": true,
            "rid": "RID123",
            "modeType": "select",
            "diffTime": "6551"
        });
        let business = build_v7_captcha_business_surface(None, &stage2);
        assert_eq!(
            business.get("observed_branch").and_then(Value::as_str),
            Some("captcha_retry_ready")
        );
        assert_eq!(
            business.get("business_state").and_then(Value::as_str),
            Some("captcha_passed_retry_ready")
        );
        assert!(business
            .get("graph_mermaid")
            .and_then(Value::as_str)
            .map(|v| v.contains("CaptchaResult") && v.contains("1900"))
            .unwrap_or(false));
    }

    #[test]
    fn build_palmchat_project_planes_contains_data_and_control_mermaid() {
        let stage2 = json!({
            "androidId": "17dadd8ec4b84ba0",
            "verifyStatus": true,
            "rid": "RID123",
            "modeType": "select",
            "diffTime": "6551"
        });
        let app_init = json!({
            "runtime_inputs": {
                "main_process_gate": true
            },
            "step_chain": [
                {
                    "node": "PrivInfoManager.INSTANCE.init(this)",
                    "result": true
                }
            ]
        });
        let business = build_v7_captcha_business_surface(None, &stage2);
        let planes = build_palmchat_project_planes(&stage2, &app_init, &business);
        assert_eq!(
            planes
                .get("project_state")
                .and_then(|v| v.get("app_init_plane"))
                .and_then(|v| v.get("status"))
                .and_then(Value::as_str),
            Some("observed_main_process_init")
        );
        assert!(planes
            .get("data_plane")
            .and_then(|v| v.get("mermaid"))
            .and_then(Value::as_str)
            .map(|v| v.contains("EncryptUtils") && v.contains("EncryptedJsonRequest"))
            .unwrap_or(false));
        assert!(planes
            .get("control_plane")
            .and_then(|v| v.get("mermaid"))
            .and_then(Value::as_str)
            .map(|v| v.contains("PrivInfoManager.init") && v.contains("u63.onPostExecute 1900"))
            .unwrap_or(false));
    }

    #[test]
    fn build_v7_captcha_ui_surface_contains_manual_input_and_graph() {
        let stage1 = json!({
            "mobile": "15390455973",
            "countryCode": "86",
            "verifyStatus": false
        });
        let stage2 = json!({
            "mobile": "15390455973",
            "countryCode": "86",
            "verifyStatus": true,
            "rid": "RID123",
            "modeType": "select",
            "diffTime": "6551"
        });
        let mut manual_input = Map::new();
        manual_input.insert("interactive".to_string(), Value::Bool(false));
        manual_input.insert("verifyStatus".to_string(), Value::Bool(true));
        manual_input.insert("rid".to_string(), Value::String("RID123".to_string()));
        let ui_events = vec![json!({
            "phase": "ui_receive_1900_branch",
            "result_code": 1900
        })];
        let ui_surface =
            build_v7_captcha_ui_surface(&stage1, &stage2, false, &manual_input, &ui_events);
        assert_eq!(
            ui_surface.get("observed_branch").and_then(Value::as_str),
            Some("captcha_retry_ready")
        );
        assert_eq!(
            ui_surface.get("business_state").and_then(Value::as_str),
            Some("captcha_passed_retry_ready")
        );
        assert!(ui_surface
            .get("graph_mermaid")
            .and_then(Value::as_str)
            .map(|v| v.contains("Captcha Dialog WebView") && v.contains("flow_obs"))
            .unwrap_or(false));
        assert_eq!(
            ui_surface
                .get("manual_input")
                .and_then(|v| v.get("rid"))
                .and_then(Value::as_str),
            Some("RID123")
        );
    }

    #[test]
    fn default_manual_rid_uses_manual_prefix() {
        let rid = default_manual_rid();
        assert!(rid.starts_with("manual"));
        assert!(rid.len() > "manual".len());
    }

    #[test]
    fn parse_json_like_with_boa_normalizes_object_literal() {
        let parsed = parse_json_like_with_boa("{rid:'RID123',pass:true}")
            .expect("boa should normalize js object literal");
        assert_eq!(parsed.get("rid").and_then(Value::as_str), Some("RID123"));
        assert_eq!(parsed.get("pass").and_then(Value::as_bool), Some(true));
    }

    #[test]
    fn build_captcha_ui_sdk_html_injects_bridge_and_mode() {
        let src = r#"<html><body><span id='shumei_form_captcha_wrapper'>加载中...</span></body><script>initSMCaptcha({mode:'xxxxxxxxxxxxxxxxxxxx'},smCaptchaCallback);</script></html>"#;
        let stage1 = json!({ "mobile": "15390455973" });
        let html =
            build_captcha_ui_sdk_html(src, &stage1, "select", true, "http://127.0.0.1:18080")
                .expect("sdk html build should succeed");
        assert!(html.contains("mode:'select'"));
        assert!(html.contains("window.jsBridge"));
        assert!(html.contains("http://127.0.0.1:18080/bridge"));
    }

    #[test]
    fn build_data_to_control_feedback_marks_ready_when_inputs_complete() {
        let mut opts = HashMap::new();
        opts.insert(
            "--smssend-url".to_string(),
            "https://short.lianxinapp.com/one/ax/auth.login.by.sendsms".to_string(),
        );
        let arg1 = json!({"verifyStatus": true});
        let feedback = build_data_to_control_feedback(&arg1, "AABB", "CCDD", "v1", &opts);
        assert_eq!(
            feedback.get("ready_for_smssend").and_then(Value::as_bool),
            Some(true)
        );
        assert_eq!(
            feedback.get("next_control_action").and_then(Value::as_str),
            Some("smssend_dispatch")
        );
    }

    #[test]
    fn build_data_to_control_feedback_blocks_without_url() {
        let opts = HashMap::new();
        let arg1 = json!({"verifyStatus": true});
        let feedback = build_data_to_control_feedback(&arg1, "AABB", "CCDD", "v1", &opts);
        assert_eq!(
            feedback.get("ready_for_smssend").and_then(Value::as_bool),
            Some(false)
        );
        assert!(feedback
            .get("blocked_reasons")
            .and_then(Value::as_array)
            .map(|items| items
                .iter()
                .any(|v| v.as_str() == Some("missing_smssend_url")))
            .unwrap_or(false));
    }

    #[test]
    fn prepare_smssend_test_url_opts_auto_injects_when_missing() {
        let stage1 = Map::new();
        let mut stage2 = Map::new();
        stage2.insert("verifyStatus".to_string(), Value::Bool(true));
        stage2.insert(
            "did".to_string(),
            Value::String("null__17dadd8ec4b84ba0".to_string()),
        );
        let mut opts = HashMap::new();
        opts.insert("--smssend-test".to_string(), "true".to_string());
        let injected = prepare_smssend_test_url_opts(&stage1, &stage2, &mut opts, None, None)
            .expect("should inject smssend url");
        assert!(injected
            .get("smssend_url")
            .and_then(Value::as_str)
            .map(|v| v.contains("requestId=") && v.contains("deviceId="))
            .unwrap_or(false));
        assert!(opts
            .get("--smssend-url")
            .map(|v| v.contains("requestId=") && v.contains("deviceId="))
            .unwrap_or(false));
        assert!(opts
            .get("--smssend-url")
            .map(|v| !v.contains("null__"))
            .unwrap_or(false));
    }

    #[test]
    fn prepare_smssend_test_url_opts_uses_live_uid_and_session_overrides() {
        let stage1 = Map::new();
        let mut stage2 = Map::new();
        stage2.insert("verifyStatus".to_string(), Value::Bool(true));
        let mut opts = HashMap::new();
        opts.insert("--smssend-test".to_string(), "true".to_string());
        opts.insert(
            "--smssend-base-url".to_string(),
            "https://short.lianxinapp.com/one/ax/auth.login.by.wifi".to_string(),
        );
        let auth = PalmchatSmssendUrlAuth {
            uid: Some("7956322787122176".to_string()),
            token: Some("TOKEN123".to_string()),
            session_id: Some("SID123".to_string()),
            callback_id: Some("CB123".to_string()),
            p_id: Some("9".to_string()),
            sys_uid: Some("12".to_string()),
        };
        let profile = PalmchatLiveDeviceProfile {
            source: "test".to_string(),
            tray_device_id: Some("3El51774707713791".to_string()),
            ..Default::default()
        };
        let injected =
            prepare_smssend_test_url_opts(&stage1, &stage2, &mut opts, Some(&auth), Some(&profile))
                .expect("should inject smssend url");
        let smssend_url = injected
            .get("smssend_url")
            .and_then(Value::as_str)
            .expect("smssend_url");
        assert!(smssend_url.contains("uid=7956322787122176"));
        assert!(smssend_url.contains("token=TOKEN123"));
        assert!(smssend_url.contains("sessionId=SID123"));
        assert!(smssend_url.contains("deviceId=3El51774707713791"));
        assert!(smssend_url.contains("callbackId=CB123"));
        assert!(smssend_url.contains("pId=9"));
        assert!(smssend_url.contains("sysUid=12"));
    }

    #[test]
    fn prepare_smssend_test_url_opts_excludes_auth_query_for_new_send_sms() {
        let stage1 = Map::new();
        let mut stage2 = Map::new();
        stage2.insert("verifyStatus".to_string(), Value::Bool(true));
        let mut opts = HashMap::new();
        opts.insert("--smssend-test".to_string(), "true".to_string());
        let auth = PalmchatSmssendUrlAuth {
            uid: Some("7956322787122176".to_string()),
            token: Some("TOKEN123".to_string()),
            session_id: Some("SID123".to_string()),
            callback_id: Some("CB123".to_string()),
            p_id: Some("9".to_string()),
            sys_uid: Some("12".to_string()),
        };
        let injected =
            prepare_smssend_test_url_opts(&stage1, &stage2, &mut opts, Some(&auth), None)
                .expect("should inject smssend url");
        let smssend_url = injected
            .get("smssend_url")
            .and_then(Value::as_str)
            .expect("smssend_url");
        assert!(smssend_url.contains("requestId="));
        assert!(smssend_url.contains("deviceId="));
        assert!(!smssend_url.contains("uid=7956322787122176"));
        assert!(!smssend_url.contains("token=TOKEN123"));
        assert!(!smssend_url.contains("sessionId=SID123"));
        assert!(!smssend_url.contains("callbackId=CB123"));
        assert!(!smssend_url.contains("pId=9"));
        assert!(!smssend_url.contains("sysUid=12"));
        assert_eq!(
            injected.get("auth_query_included").and_then(Value::as_bool),
            Some(false)
        );
    }

    #[test]
    fn compose_smssend_url_includes_auth_query_for_wifi_endpoint() {
        let auth = PalmchatSmssendUrlAuth {
            uid: Some("7956322787122176".to_string()),
            token: Some("TOKEN123".to_string()),
            session_id: Some("SID123".to_string()),
            callback_id: Some("CB123".to_string()),
            p_id: Some("9".to_string()),
            sys_uid: Some("12".to_string()),
        };
        let smssend_url = compose_smssend_url(
            "https://short.lianxinapp.com/one/ax/auth.login.by.wifi",
            "RIDX",
            "DEVX",
            Some(&auth),
        );
        assert!(smssend_url.contains("uid=7956322787122176"));
        assert!(smssend_url.contains("token=TOKEN123"));
        assert!(smssend_url.contains("sessionId=SID123"));
        assert!(smssend_url.contains("requestId=RIDX"));
        assert!(smssend_url.contains("deviceId=DEVX"));
        assert!(smssend_url.contains("callbackId=CB123"));
        assert!(smssend_url.contains("pId=9"));
        assert!(smssend_url.contains("sysUid=12"));
    }

    #[test]
    fn compose_smssend_url_excludes_auth_query_for_sms_endpoint() {
        let auth = PalmchatSmssendUrlAuth {
            uid: Some("7956322787122176".to_string()),
            token: Some("TOKEN123".to_string()),
            session_id: Some("SID123".to_string()),
            callback_id: Some("CB123".to_string()),
            p_id: Some("9".to_string()),
            sys_uid: Some("12".to_string()),
        };
        let smssend_url = compose_smssend_url(
            "https://short.lianxinapp.com/one/ax/auth.login.by.sendsms",
            "RIDX",
            "DEVX",
            Some(&auth),
        );
        assert!(smssend_url.contains("requestId=RIDX"));
        assert!(smssend_url.contains("deviceId=DEVX"));
        assert!(!smssend_url.contains("uid=7956322787122176"));
        assert!(!smssend_url.contains("token=TOKEN123"));
        assert!(!smssend_url.contains("sessionId=SID123"));
        assert!(!smssend_url.contains("callbackId=CB123"));
        assert!(!smssend_url.contains("pId=9"));
        assert!(!smssend_url.contains("sysUid=12"));
    }

    #[test]
    fn merge_smssend_url_auth_sources_uses_recovered_session_when_cli_missing() {
        let overrides = PalmchatSmssendUrlAuth {
            uid: None,
            token: None,
            session_id: None,
            callback_id: Some("CB1".to_string()),
            p_id: None,
            sys_uid: None,
        };
        let recovered = PalmchatRecoveredAuthState {
            uid: Some("7956322787122176".to_string()),
            session_id: Some("SID_FROM_RECOVERED".to_string()),
            ..Default::default()
        };
        let merged = merge_smssend_url_auth_sources(
            &overrides,
            Some(&recovered),
            None,
            Some("TOKEN_FROM_RECOVERED".to_string()),
        );
        assert_eq!(merged.uid.as_deref(), Some("7956322787122176"));
        assert_eq!(merged.session_id.as_deref(), Some("SID_FROM_RECOVERED"));
        assert_eq!(merged.token.as_deref(), Some("TOKEN_FROM_RECOVERED"));
        assert_eq!(merged.callback_id.as_deref(), Some("CB1"));
    }

    #[test]
    fn merge_smssend_url_auth_sources_prefers_bootstrap_token_over_regenerated_token() {
        let overrides = PalmchatSmssendUrlAuth {
            uid: None,
            token: None,
            session_id: None,
            callback_id: None,
            p_id: None,
            sys_uid: None,
        };
        let recovered = PalmchatRecoveredAuthState {
            uid: Some("7956322787122176".to_string()),
            token_after_bootstrap: Some("TOKEN_FROM_BOOTSTRAP".to_string()),
            ..Default::default()
        };
        let merged = merge_smssend_url_auth_sources(
            &overrides,
            Some(&recovered),
            None,
            Some("TOKEN_REGENERATED".to_string()),
        );
        assert_eq!(merged.token.as_deref(), Some("TOKEN_FROM_BOOTSTRAP"));
    }

    #[test]
    fn secret_pair_from_pair_state_extracts_key_and_iv() {
        let pair_object = new_mut_data_object(
            Rc::new(DvmClass {
                id: 1,
                name: "android/util/Pair".to_string(),
                super_class: None,
                interfaces: None,
            }),
            PalmchatPairState {
                first: Some(DvmObject::ByteArray(b"secret_key".to_vec())),
                second: Some(DvmObject::ByteArray(b"secret_iv".to_vec())),
            },
        );
        let pair = secret_pair_from_dvm_object(&pair_object).expect("pair bytes");
        assert_eq!(pair.key, b"secret_key".to_vec());
        assert_eq!(pair.iv, b"secret_iv".to_vec());
    }

    #[test]
    fn build_data_to_control_feedback_extracts_request_and_device_id() {
        let mut opts = HashMap::new();
        opts.insert(
            "--smssend-url".to_string(),
            "https://short.lianxinapp.com/one/ax/auth.login.by.sendsms?uid=7956322787122176&token=TOKEN123&sessionId=SID123&requestId=RIDX&deviceId=DEVX&callbackId=CB123&pId=9&sysUid=12".to_string(),
        );
        let arg1 = json!({"verifyStatus": true});
        let feedback = build_data_to_control_feedback(&arg1, "AABB", "CCDD", "v1", &opts);
        assert_eq!(
            feedback.get("requestId").and_then(Value::as_str),
            Some("RIDX")
        );
        assert_eq!(
            feedback.get("deviceId").and_then(Value::as_str),
            Some("DEVX")
        );
        assert_eq!(
            feedback.get("uid").and_then(Value::as_str),
            Some("7956322787122176")
        );
        assert_eq!(
            feedback.get("sessionId").and_then(Value::as_str),
            Some("SID123")
        );
        assert_eq!(
            feedback.get("callbackId").and_then(Value::as_str),
            Some("CB123")
        );
        assert_eq!(feedback.get("pId").and_then(Value::as_str), Some("9"));
        assert_eq!(feedback.get("sysUid").and_then(Value::as_str), Some("12"));
        assert_eq!(
            feedback.get("token_present").and_then(Value::as_bool),
            Some(true)
        );
    }

    #[test]
    fn normalize_device_id_candidate_rejects_null_like_values() {
        assert_eq!(
            normalize_device_id_candidate(Some("null__abc".to_string())),
            None
        );
        assert_eq!(
            normalize_device_id_candidate(Some("null".to_string())),
            None
        );
        assert_eq!(
            normalize_device_id_candidate(Some("unknown".to_string())),
            None
        );
        assert_eq!(
            normalize_device_id_candidate(Some("0EwK1762184873163".to_string())),
            Some("0EwK1762184873163".to_string())
        );
    }

    #[test]
    fn normalize_device_label_candidate_preserves_zero_literal() {
        assert_eq!(
            normalize_device_label_candidate(Some("0".to_string())),
            Some("0".to_string())
        );
        assert_eq!(
            normalize_device_label_candidate(Some("LABELX".to_string())).as_deref(),
            Some("LABELX")
        );
    }

    #[test]
    fn normalize_ac1_imei_candidate_preserves_unknown_literal() {
        assert_eq!(
            normalize_ac1_imei_candidate(Some("unknown".to_string())).as_deref(),
            Some("Unknown")
        );
        assert_eq!(
            normalize_ac1_imei_candidate(Some("864209876543210".to_string())).as_deref(),
            Some("864209876543210")
        );
        assert_eq!(
            normalize_ac1_imei_candidate(Some("null__abc".to_string())),
            None
        );
    }

    #[test]
    fn derive_synthetic_imei_is_15_digits_and_luhn_valid() {
        let imei = derive_synthetic_imei("0EwK1762184873163");
        assert_eq!(imei.len(), 15);
        assert!(imei.chars().all(|ch| ch.is_ascii_digit()));
        let digits: Vec<u32> = imei.chars().filter_map(|ch| ch.to_digit(10)).collect();
        let mut sum = 0u32;
        for (idx, mut d) in digits.iter().copied().enumerate() {
            if idx % 2 == 1 {
                d *= 2;
                if d > 9 {
                    d -= 9;
                }
            }
            sum += d;
        }
        assert_eq!(sum % 10, 0);
    }

    #[test]
    fn ensure_app_list_payload_backfills_imei_and_package() {
        let mut map = Map::new();
        map.insert("appList".to_string(), Value::String("{}".to_string()));
        let mut events = Vec::new();
        ensure_app_list_payload(
            &mut map,
            Some("864209876543210"),
            Some("OPPO_A56925F58B07B8B6"),
            "com.zenmen.palmchat",
            None,
            false,
            &mut events,
        );
        let app_list = parse_json_string_or_object(map.get("appList")).expect("appList object");
        let app_list_obj = app_list.as_object().expect("appList map");
        assert_eq!(
            app_list_obj.get("imei").and_then(Value::as_str),
            Some("864209876543210")
        );
        let channel_id = app_list_obj
            .get("channelId")
            .and_then(Value::as_str)
            .expect("appList.channelId");
        assert!(channel_id.starts_with("OPPO_A56925F58B07B8B6_"));
        assert!(app_list_obj
            .get("package")
            .and_then(Value::as_array)
            .map(|items| !items.is_empty())
            .unwrap_or(false));
        assert!(events
            .iter()
            .any(|event| event.starts_with("appList.imei=")));
    }

    #[test]
    fn ensure_app_list_payload_refreshes_dynamic_suffix_when_forced() {
        let mut map = Map::new();
        map.insert(
            "appList".to_string(),
            Value::String(
                json!({
                    "channelId": "OPPO_A56925F58B07B8B6_OLD",
                    "package": [{"packageName": "com.zenmen.palmchat"}]
                })
                .to_string(),
            ),
        );
        let mut events = Vec::new();
        ensure_app_list_payload(
            &mut map,
            None,
            Some("OPPO_A56925F58B07B8B6"),
            "com.zenmen.palmchat",
            None,
            true,
            &mut events,
        );
        let app_list = parse_json_string_or_object(map.get("appList")).expect("appList object");
        let app_list_obj = app_list.as_object().expect("appList map");
        let channel_id = app_list_obj
            .get("channelId")
            .and_then(Value::as_str)
            .expect("appList.channelId");
        assert!(channel_id.starts_with("OPPO_A56925F58B07B8B6_"));
        assert_ne!(channel_id, "OPPO_A56925F58B07B8B6_OLD");
        assert!(events
            .iter()
            .any(|event| event.starts_with("appList.channelId=")));
    }

    #[test]
    fn ensure_app_list_payload_preserves_full_live_package_set() {
        let mut map = Map::new();
        map.insert(
            "appList".to_string(),
            Value::String(
                json!({
                    "channelId": "OPPO_A56925F58B07B8B6_OLD",
                    "package": [{"packageName": "com.zenmen.palmchat"}]
                })
                .to_string(),
            ),
        );
        let live_packages = vec![
            "com.zenmen.palmchat".to_string(),
            "com.android.settings".to_string(),
            "com.android.systemui".to_string(),
        ];
        let mut events = Vec::new();
        ensure_app_list_payload(
            &mut map,
            None,
            Some("OPPO_A56925F58B07B8B6"),
            "com.zenmen.palmchat",
            Some(live_packages.as_slice()),
            false,
            &mut events,
        );
        let app_list = parse_json_string_or_object(map.get("appList")).expect("appList object");
        let app_list_obj = app_list.as_object().expect("appList map");
        assert_eq!(
            extract_app_list_package_names(app_list_obj),
            vec![
                "com.zenmen.palmchat".to_string(),
                "com.android.settings".to_string(),
                "com.android.systemui".to_string()
            ]
        );
        assert!(events
            .iter()
            .any(|event| event == "appList.package_count=3"));
    }

    #[test]
    fn select_app_list_package_names_preserves_live_order_and_app_membership() {
        let live_packages = vec![
            "com.oppo.instant.local.service".to_string(),
            "com.android.systemui".to_string(),
            "android".to_string(),
            "com.android.settings".to_string(),
        ];
        assert_eq!(
            select_app_list_package_names("com.zenmen.palmchat", Some(live_packages.as_slice())),
            vec![
                "com.oppo.instant.local.service".to_string(),
                "com.android.systemui".to_string(),
                "android".to_string(),
                "com.android.settings".to_string(),
                "com.zenmen.palmchat".to_string()
            ]
        );
    }

    #[test]
    fn parse_mmkv_key_ip_info_prefers_exact_key_followed_by_json() {
        let raw = concat!(
            "key_ip_infoqp{\"ipv4\":\"183.212.9.155\"}\n",
            "key_ip_info\n",
            "{\"Final_Client_IP_Address\":\"2409:8a20:8174:a120:1748:aa80:8724:a087\",\"ipv6\":\"2409:8a20:8174:a120:1748:aa80:8724:a087\"}\n"
        );
        assert_eq!(
            parse_mmkv_key_ip_info(raw),
            Some("{\"Final_Client_IP_Address\":\"2409:8a20:8174:a120:1748:aa80:8724:a087\",\"ipv6\":\"2409:8a20:8174:a120:1748:aa80:8724:a087\"}".to_string())
        );
    }

    #[test]
    fn parse_mmkv_strings_value_supports_adjacent_and_inline_formats() {
        let raw = concat!(
            "      9 tray_preference_device_id\n",
            "     36 3El51774707713791\n",
            "    262 current_exid! 7oAKm777xs2nGEvCRbNoJ5-1-1-rCRTu\n"
        );
        assert_eq!(
            parse_mmkv_strings_value(raw, "tray_preference_device_id"),
            Some("3El51774707713791".to_string())
        );
        assert_eq!(
            parse_mmkv_strings_value(raw, "current_exid"),
            Some("7oAKm777xs2nGEvCRbNoJ5-1-1-rCRTu".to_string())
        );
    }

    #[test]
    fn parse_runtime_probe_app_list_packages_preserves_probe_order() {
        let raw = concat!(
            "LOG=before\n",
            "APP_LIST_JSON={\"imei\":\"Unknown\",\"package\":[{\"packageName\":\"b\"},{\"packageName\":\"a\"},{\"packageName\":\"b\"}]}\n"
        );
        assert_eq!(
            parse_runtime_probe_app_list_packages(raw),
            Some(vec!["b".to_string(), "a".to_string()])
        );
    }

    #[test]
    fn parse_runtime_probe_app_list_packages_supports_body_app_list() {
        let raw = concat!(
            "BODY_appList={\"package\":[{\"packageName\":\"x\"},{\"packageName\":\"android\"},{\"packageName\":\"x\"}]}\n"
        );
        assert_eq!(
            parse_runtime_probe_app_list_packages(raw),
            Some(vec!["x".to_string(), "android".to_string()])
        );
    }

    #[test]
    fn runtime_probe_overrides_disabled_by_default() {
        assert!(!runtime_probe_overrides_enabled_from_env_value(None));
        assert!(!runtime_probe_overrides_enabled_from_env_value(Some("")));
        assert!(!runtime_probe_overrides_enabled_from_env_value(Some("0")));
        assert!(!runtime_probe_overrides_enabled_from_env_value(Some("false")));
    }

    #[test]
    fn runtime_probe_overrides_enabled_for_truthy_values() {
        assert!(runtime_probe_overrides_enabled_from_env_value(Some("1")));
        assert!(runtime_probe_overrides_enabled_from_env_value(Some("true")));
        assert!(runtime_probe_overrides_enabled_from_env_value(Some("yes")));
        assert!(runtime_probe_overrides_enabled_from_env_value(Some("on")));
    }

    #[test]
    fn parse_runtime_probe_overrides_prefers_body_json_semantics() {
        let raw = concat!(
            "BODY_androidId=474ae9e4161da390\n",
            "BODY_ipInfo={\"Final_Client_IP_Address\":\"183.212.9.155\",\"ipv4\":\"183.212.9.155\",\"X-Forwarded-For\":\"183.212.9.155, 172.19.36.0\"}\n",
            "BODY_dfp={\"sinfo\":\"{\\\"plt\\\":false}\",\"netState\":\"WIFI_\",\"net_type\":\"WIFI\",\"wifiSSID\":\"\",\"wifi_ip\":\"192.168.1.12\",\"resolution\":\"1080*2184\",\"screen_brightness\":0,\"screen_on\":false,\"sensor_name_list\":\"a,b\",\"duDeviceLabel\":\"0\",\"basicVersion\":\"\",\"kernelVersion\":\"\",\"last_boot_time\":1774808142482}\n",
            "BODY_appList={\"package\":[{\"packageName\":\"com.zenmen.palmchat\"},{\"packageName\":\"android\"}]}\n"
        );
        let overrides =
            parse_runtime_probe_overrides(raw, "/tmp/palmchat_probe_java.out.realdevice")
                .expect("runtime probe overrides");
        assert_eq!(overrides.android_id.as_deref(), Some("474ae9e4161da390"));
        assert_eq!(overrides.network_state.as_deref(), Some("WIFI_"));
        assert_eq!(overrides.network_type.as_deref(), Some("WIFI"));
        assert_eq!(overrides.wifi_ssid.as_deref(), Some(""));
        assert_eq!(overrides.resolution.as_deref(), Some("1080*2184"));
        assert_eq!(overrides.screen_brightness, Some(0));
        assert_eq!(overrides.screen_on, Some(false));
        assert_eq!(overrides.device_label.as_deref(), Some("0"));
        assert_eq!(overrides.baseband_version.as_deref(), Some(""));
        assert_eq!(overrides.kernel_version.as_deref(), Some(""));
        assert_eq!(overrides.boot_time_millis, Some(1_774_808_142_482));
        assert_eq!(
            overrides.sensor_name_list,
            Some(vec!["a".to_string(), "b".to_string()])
        );
        assert_eq!(
            overrides.installed_packages,
            Some(vec![
                "com.zenmen.palmchat".to_string(),
                "android".to_string()
            ])
        );
    }

    #[test]
    fn parse_mmkv_strings_value_supports_plain_strings_output_without_offsets() {
        let raw = concat!(
            "tray_preference_device_id\n",
            "3El51774707713791\n",
            "current_uid\n",
            "7956322787122176\n",
            "current_exid! 7oAKm777xs2nGEvCRbNoJ5-1-1-rCRTu\n",
            "current_uid\n",
            "current_exid\n"
        );
        assert_eq!(
            parse_mmkv_strings_value(raw, "tray_preference_device_id"),
            Some("3El51774707713791".to_string())
        );
        assert_eq!(
            parse_mmkv_strings_value(raw, "current_uid"),
            Some("7956322787122176".to_string())
        );
        assert_eq!(
            parse_mmkv_strings_value(raw, "current_exid"),
            Some("7oAKm777xs2nGEvCRbNoJ5-1-1-rCRTu".to_string())
        );
    }

    #[test]
    fn parse_wifi_social_last_login_info_extracts_uid_exid_and_phone() {
        let raw = r#"<?xml version='1.0' encoding='utf-8' standalone='yes' ?>
<map>
    <string name="last_login_user_info">{&quot;exid&quot;:&quot;7oAKm777xs2nGEvCRbNoJ5-1-1-rCRTu&quot;,&quot;phone&quot;:&quot;15380455973&quot;,&quot;uid&quot;:7956322787122176}</string>
</map>"#;
        let parsed = parse_wifi_social_last_login_info(raw).expect("last_login_user_info");
        assert_eq!(
            extract_json_value_as_string(Some(&parsed), "uid"),
            Some("7956322787122176".to_string())
        );
        assert_eq!(
            extract_json_value_as_string(Some(&parsed), "exid"),
            Some("7oAKm777xs2nGEvCRbNoJ5-1-1-rCRTu".to_string())
        );
        assert_eq!(
            extract_json_value_as_string(Some(&parsed), "phone"),
            Some("15380455973".to_string())
        );
    }

    #[test]
    fn parse_wifi_social_additional_auth_extracts_sid_and_refresh_key_ciphertexts() {
        let raw = r#"<?xml version='1.0' encoding='utf-8' standalone='yes' ?>
<map>
    <string name="sp_sid_additional">7369645f636970686572</string>
    <string name="sp_rk_additional">726566726573685f636970686572</string>
</map>"#;
        let (sid, refresh_key) = parse_wifi_social_additional_auth(raw);
        assert_eq!(sid.as_deref(), Some("7369645f636970686572"));
        assert_eq!(refresh_key.as_deref(), Some("726566726573685f636970686572"));
    }

    #[test]
    fn resolve_palmchat_recovered_auth_candidates_honors_source_precedence() {
        let candidates = PalmchatRecoveredAuthCandidates {
            cli_uid: Some("cli_uid".to_string()),
            cli_session_id: Some("cli_sid".to_string()),
            live_uid: Some("live_uid".to_string()),
            live_session_id: Some("live_sid".to_string()),
            live_refresh_key: Some("live_rk".to_string()),
            java_uid: Some("java_uid".to_string()),
            java_session_id: Some("java_sid".to_string()),
            java_refresh_key: Some("java_rk".to_string()),
        };
        let (uid, session_id, refresh_key, source) =
            resolve_palmchat_recovered_auth_candidates(&candidates);
        assert_eq!(uid.as_deref(), Some("cli_uid"));
        assert_eq!(session_id.as_deref(), Some("cli_sid"));
        assert_eq!(refresh_key.as_deref(), Some("live_rk"));
        assert_eq!(source, "cli_overrides");

        let live_only = PalmchatRecoveredAuthCandidates {
            live_uid: Some("live_uid".to_string()),
            live_session_id: Some("live_sid".to_string()),
            live_refresh_key: Some("live_rk".to_string()),
            java_uid: Some("java_uid".to_string()),
            java_session_id: Some("java_sid".to_string()),
            java_refresh_key: Some("java_rk".to_string()),
            ..Default::default()
        };
        let (uid, session_id, refresh_key, source) =
            resolve_palmchat_recovered_auth_candidates(&live_only);
        assert_eq!(uid.as_deref(), Some("live_uid"));
        assert_eq!(session_id.as_deref(), Some("live_sid"));
        assert_eq!(refresh_key.as_deref(), Some("live_rk"));
        assert_eq!(source, "live_device_profile");
    }

    #[test]
    fn build_two_step_stage1_payload_refreshes_app_list_channel_id() {
        let stage2 = json!({
            "mobile": "17696723664",
            "countryCode": "86",
            "verifyStatus": true,
            "rid": "RIDX",
            "modeType": "select",
            "diffTime": "9540",
            "channelId": "OPPO_A56925F58B07B8B6",
            "appList": "{\"channelId\":\"OPPO_A56925F58B07B8B6_OLD\",\"package\":[{\"packageName\":\"com.zenmen.palmchat\"},{\"packageName\":\"com.android.settings\"}]}"
        });
        let stage1 = build_two_step_stage1_payload(&stage2, "com.zenmen.palmchat");
        let stage1_obj = stage1.as_object().expect("stage1 object");
        assert_eq!(
            stage1_obj.get("verifyStatus").and_then(Value::as_bool),
            Some(false)
        );
        assert!(stage1_obj.get("rid").is_none());
        let app_list = parse_json_string_or_object(stage1_obj.get("appList")).expect("appList");
        let app_list_obj = app_list.as_object().expect("appList object");
        let channel_id = app_list_obj
            .get("channelId")
            .and_then(Value::as_str)
            .expect("appList.channelId");
        assert!(channel_id.starts_with("OPPO_A56925F58B07B8B6_"));
        assert_ne!(channel_id, "OPPO_A56925F58B07B8B6_OLD");
        assert_eq!(
            extract_app_list_package_names(app_list_obj),
            vec![
                "com.zenmen.palmchat".to_string(),
                "com.android.settings".to_string()
            ]
        );
    }

    #[test]
    fn build_two_step_stage1_payload_preserves_clean_first_stage_body() {
        let stage1 = json!({
            "mobile": "17696723664",
            "countryCode": "86",
            "verifyStatus": false,
            "channelId": "OPPO_A56925F58B07B8B6",
            "appList": "{\"channelId\":\"OPPO_A56925F58B07B8B6_FIXED\",\"package\":[{\"packageName\":\"com.zenmen.palmchat\"},{\"packageName\":\"android\"}]}"
        });
        let rebuilt = build_two_step_stage1_payload(&stage1, "com.zenmen.palmchat");
        let rebuilt_obj = rebuilt.as_object().expect("rebuilt stage1 object");
        assert_eq!(
            rebuilt_obj.get("verifyStatus").and_then(Value::as_bool),
            Some(false)
        );
        assert!(rebuilt_obj.get("rid").is_none());
        assert!(rebuilt_obj.get("modeType").is_none());
        assert!(rebuilt_obj.get("diffTime").is_none());
        let app_list = parse_json_string_or_object(rebuilt_obj.get("appList")).expect("appList");
        let app_list_obj = app_list.as_object().expect("appList object");
        assert_eq!(
            app_list_obj.get("channelId").and_then(Value::as_str),
            Some("OPPO_A56925F58B07B8B6_FIXED")
        );
        assert_eq!(
            extract_app_list_package_names(app_list_obj),
            vec!["com.zenmen.palmchat".to_string(), "android".to_string()]
        );
    }

    #[test]
    fn build_two_step_stage1_payload_strips_retry_noise_from_false_stage1() {
        let stage1_with_noise = json!({
            "mobile": "17696723664",
            "countryCode": "86",
            "verifyStatus": false,
            "rid": "",
            "modeType": "select",
            "diffTime": "0",
            "channelId": "OPPO_A56925F58B07B8B6",
            "appList": "{\"channelId\":\"OPPO_A56925F58B07B8B6_FIXED\",\"package\":[{\"packageName\":\"com.zenmen.palmchat\"},{\"packageName\":\"android\"}]}"
        });
        let rebuilt = build_two_step_stage1_payload(&stage1_with_noise, "com.zenmen.palmchat");
        let rebuilt_obj = rebuilt.as_object().expect("rebuilt stage1 object");
        assert_eq!(
            rebuilt_obj.get("verifyStatus").and_then(Value::as_bool),
            Some(false)
        );
        assert!(rebuilt_obj.get("rid").is_none());
        assert!(rebuilt_obj.get("modeType").is_none());
        assert!(rebuilt_obj.get("diffTime").is_none());
        let app_list = parse_json_string_or_object(rebuilt_obj.get("appList")).expect("appList");
        let app_list_obj = app_list.as_object().expect("appList object");
        let channel_id = app_list_obj
            .get("channelId")
            .and_then(Value::as_str)
            .expect("appList.channelId");
        assert!(channel_id.starts_with("OPPO_A56925F58B07B8B6_"));
        assert_ne!(channel_id, "OPPO_A56925F58B07B8B6_FIXED");
    }

    #[test]
    fn build_two_step_stage1_from_mh_base_applies_o92_sms_patch() {
        let base = json!({
            "channelId": "OPPO_A56925F58B07B8B6",
            "did": "null__5ac9abc225faadfe",
            "platform": "android",
            "versionCode": "260309",
            "imei": Value::Null,
            "mac": "",
            "dhid": "",
            "autoLogin": "0",
            "sdid": "DUz_seed",
            "oaid": "oaid_seed",
            "oneId": "",
            "dfp": "{}",
            "appList": "{\"channelId\":\"OPPO_A56925F58B07B8B6_FIXED\",\"package\":[{\"packageName\":\"com.zenmen.palmchat\"},{\"packageName\":\"android\"}]}",
            "appId": "ZX0001",
            "ipInfo": "{}",
            "androidId": "5ac9abc225faadfe"
        });
        let stage2 = json!({
            "mobile": "17696723664",
            "countryCode": "86",
            "verifyStatus": true,
            "rid": "RID123",
            "modeType": "slide",
            "diffTime": 3123
        });
        let rebuilt = build_two_step_stage1_from_mh_base(&base, &stage2);
        let rebuilt_obj = rebuilt.as_object().expect("rebuilt object");
        assert_eq!(
            rebuilt_obj.get("mobile").and_then(Value::as_str),
            Some("17696723664")
        );
        assert_eq!(
            rebuilt_obj.get("countryCode").and_then(Value::as_str),
            Some("86")
        );
        assert_eq!(
            rebuilt_obj.get("verifyStatus").and_then(Value::as_bool),
            Some(false)
        );
        assert_eq!(rebuilt_obj.get("paramNum").and_then(Value::as_i64), Some(4));
        assert!(rebuilt_obj.get("rid").is_none());
        assert!(rebuilt_obj.get("modeType").is_none());
        assert!(rebuilt_obj.get("diffTime").is_none());
        assert_eq!(rebuilt_obj.get("imei"), Some(&Value::Null));
    }

    #[test]
    fn build_two_step_stage1_from_mh_base_preserves_producer_namespaces() {
        let base = json!({
            "mobile": "old_mobile",
            "countryCode": "1",
            "verifyStatus": true,
            "channelId": "OPPO_A56925F58B07B8B6",
            "dfp": "{\"screen_on\":false,\"wifiSSID\":\"producer_ssid\"}",
            "appList": "{\"channelId\":\"OPPO_A56925F58B07B8B6_PRODUCER\",\"package\":[{\"packageName\":\"com.zenmen.palmchat\"},{\"packageName\":\"com.android.settings\"}]}",
            "ipInfo": "{\"ipv4\":\"8.8.8.8\",\"Final_Client_IP_Address\":\"8.8.8.8\"}"
        });
        let stage2 = json!({
            "mobile": "17696723664",
            "countryCode": "86",
            "verifyStatus": true,
            "rid": "RID123",
            "modeType": "slide",
            "diffTime": 3123
        });
        let rebuilt = build_two_step_stage1_from_mh_base(&base, &stage2);
        let rebuilt_obj = rebuilt.as_object().expect("rebuilt object");
        assert_eq!(
            rebuilt_obj.get("mobile").and_then(Value::as_str),
            Some("17696723664")
        );
        assert_eq!(
            rebuilt_obj.get("countryCode").and_then(Value::as_str),
            Some("86")
        );
        assert_eq!(
            rebuilt_obj.get("appList").and_then(Value::as_str),
            base.get("appList").and_then(Value::as_str)
        );
        assert_eq!(
            rebuilt_obj.get("ipInfo").and_then(Value::as_str),
            base.get("ipInfo").and_then(Value::as_str)
        );
        assert_eq!(
            rebuilt_obj.get("dfp").and_then(Value::as_str),
            base.get("dfp").and_then(Value::as_str)
        );
        assert_eq!(
            rebuilt_obj.get("verifyStatus").and_then(Value::as_bool),
            Some(false)
        );
        assert!(rebuilt_obj.get("rid").is_none());
        assert!(rebuilt_obj.get("modeType").is_none());
        assert!(rebuilt_obj.get("diffTime").is_none());
    }

    #[test]
    fn apply_explicit_stage1_override_replaces_selected_fields() {
        let mut stage1 = json!({
            "mobile": "17696723664",
            "verifyStatus": false,
            "dfp": "{\"screen_on\":false}",
            "ipInfo": "{\"ipv4\":\"1.1.1.1\"}"
        });
        let override_value = json!({
            "verifyStatus": false,
            "dfp": "{\"screen_on\":true}",
            "ipInfo": "{\"ipv4\":\"2.2.2.2\"}"
        });
        apply_explicit_stage1_override(&mut stage1, Some(&override_value));
        let stage1_obj = stage1.as_object().expect("stage1 object");
        assert_eq!(
            stage1_obj.get("verifyStatus").and_then(Value::as_bool),
            Some(false)
        );
        assert_eq!(
            stage1_obj.get("dfp").and_then(Value::as_str),
            Some("{\"screen_on\":true}")
        );
        assert_eq!(
            stage1_obj.get("ipInfo").and_then(Value::as_str),
            Some("{\"ipv4\":\"2.2.2.2\"}")
        );
    }

    #[test]
    fn apply_app_version_normalization_keeps_new_sms_version_code_as_string() {
        let mut map = Map::new();
        map.insert("mobile".to_string(), json!("17696723664"));
        map.insert("countryCode".to_string(), json!("86"));
        map.insert("appId".to_string(), json!("ZX0001"));
        map.insert("channelId".to_string(), json!("OPPO_A56925F58B07B8B6"));
        map.insert("paramNum".to_string(), json!(4));
        map.insert("versionCode".to_string(), json!(251103));
        map.insert("versionName".to_string(), json!("7.10.901.2"));
        let info = PalmchatAppVersionInfo {
            version_code: Some("260304".to_string()),
            version_name: Some("8.2.1.1".to_string()),
            source: Some("test".to_string()),
        };
        let mut events = Vec::new();
        apply_app_version_normalization(&mut map, &info, false, &mut events);
        assert_eq!(
            map.get("versionCode").and_then(Value::as_str),
            Some("260304")
        );
        assert!(!map.contains_key("versionName"));
        assert!(events.iter().any(|event| event.contains("versionCode:")));
        assert!(events.iter().any(|event| event.contains("versionName:")));
    }

    #[test]
    fn apply_app_version_normalization_treats_sparse_stage1_seed_as_new_sms() {
        let mut map = Map::new();
        map.insert("mobile".to_string(), json!("17696723664"));
        map.insert("countryCode".to_string(), json!("86"));
        map.insert("verifyStatus".to_string(), json!(false));
        map.insert("rid".to_string(), json!(""));
        map.insert("modeType".to_string(), json!("select"));
        map.insert("diffTime".to_string(), json!("0"));
        map.insert("versionCode".to_string(), json!(251103));
        map.insert("versionName".to_string(), json!("7.10.901.2"));
        let info = PalmchatAppVersionInfo {
            version_code: Some("260304".to_string()),
            version_name: Some("8.2.1.1".to_string()),
            source: Some("test".to_string()),
        };
        let mut events = Vec::new();
        apply_app_version_normalization(&mut map, &info, false, &mut events);
        assert_eq!(
            map.get("versionCode").and_then(Value::as_str),
            Some("260304")
        );
        assert!(!map.contains_key("versionName"));
        assert!(events.iter().any(|event| event.contains("versionCode:")));
        assert!(events.iter().any(|event| event.contains("versionName:")));
    }

    #[test]
    fn apply_app_version_normalization_keeps_non_sms_version_name() {
        let mut map = Map::new();
        map.insert("foo".to_string(), json!("bar"));
        let info = PalmchatAppVersionInfo {
            version_code: Some("260304".to_string()),
            version_name: Some("8.2.1.1".to_string()),
            source: Some("test".to_string()),
        };
        let mut events = Vec::new();
        apply_app_version_normalization(&mut map, &info, false, &mut events);
        assert_eq!(map.get("versionCode").and_then(Value::as_i64), Some(260304));
        assert_eq!(
            map.get("versionName").and_then(Value::as_str),
            Some("8.2.1.1")
        );
    }

    #[test]
    fn apply_app_version_normalization_preserves_explicit_bridge_stage1_version_code() {
        let mut map = Map::new();
        map.insert("mobile".to_string(), json!("17696723664"));
        map.insert("countryCode".to_string(), json!("86"));
        map.insert("appId".to_string(), json!("ZX0001"));
        map.insert("channelId".to_string(), json!("OPPO_A56925F58B07B8B6"));
        map.insert("paramNum".to_string(), json!(4));
        map.insert("versionCode".to_string(), json!("251103"));
        map.insert("versionName".to_string(), json!("7.10.901.2"));
        let info = PalmchatAppVersionInfo {
            version_code: Some("260309".to_string()),
            version_name: Some("8.2.1.3".to_string()),
            source: Some("test".to_string()),
        };
        let mut events = Vec::new();
        apply_app_version_normalization(&mut map, &info, true, &mut events);
        assert_eq!(
            map.get("versionCode").and_then(Value::as_str),
            Some("251103")
        );
        assert!(!map.contains_key("versionName"));
        assert!(!events.iter().any(|event| event.contains("versionCode:")));
        assert!(events.iter().any(|event| event.contains("versionName:")));
    }

    #[test]
    fn recompute_nullable_did_uses_current_android_id_with_null_imei() {
        let mut map = Map::new();
        map.insert("imei".to_string(), Value::Null);
        map.insert("mac".to_string(), Value::String(String::new()));
        map.insert(
            "androidId".to_string(),
            Value::String("5ac9abc225faadfe".to_string()),
        );
        map.insert(
            "did".to_string(),
            Value::String("null__17dadd8ec4b84ba0".to_string()),
        );
        assert_eq!(
            recompute_nullable_did(&map).as_deref(),
            Some("null__5ac9abc225faadfe")
        );
    }

    #[test]
    fn live_device_profile_updates_identity_state_and_clears_preinit_flag() {
        let profile = PalmchatLiveDeviceProfile {
            source: "test".to_string(),
            android_id: Some("5ac9abc225faadfe".to_string()),
            sdid: Some("DUz_seed".to_string()),
            device_label: Some("LABEL_SEED".to_string()),
            ..Default::default()
        };
        let mut state = PalmchatIdentityRuntimeState {
            privacy_agree: Some(true),
            read_phone_state_granted: Some(false),
            priv_info_initialized: true,
            android_id: "17dadd8ec4b84ba0".to_string(),
            imei: "old-imei".to_string(),
            mac: "old-mac".to_string(),
            sdid: String::new(),
            local_smid: String::new(),
            device_label: String::new(),
            process_name: "com.zenmen.palmchat".to_string(),
        };
        profile.apply_to_identity_seed(&mut state);
        assert_eq!(state.sdid, "DUz_seed");
        assert_eq!(state.device_label, "LABEL_SEED");
        let payload = json!({
            "androidId": "5ac9abc225faadfe",
            "imei": Value::Null,
            "mac": "",
            "sdid": "DUz_test",
            "dfp": "{\"duDeviceLabel\":\"LABELX\"}"
        });
        let events = profile.update_identity_state_from_effective_body(
            &mut state,
            &payload,
            &HashMap::new(),
        );
        assert_eq!(state.android_id, "5ac9abc225faadfe");
        assert_eq!(state.imei, "");
        assert_eq!(state.mac, "");
        assert_eq!(state.sdid, "DUz_test");
        assert_eq!(state.device_label, "LABELX");
        assert!(!state.priv_info_initialized);
        assert!(events
            .iter()
            .any(|event| event == "identity.priv_info_initialized=false"));
    }

    #[test]
    fn normalize_wm4_real_network_type_uses_wg_for_wifi_with_mobile_data() {
        assert_eq!(normalize_wm4_network_type(Some("WIFI")), "w".to_string());
        assert_eq!(
            normalize_wm4_real_network_type(Some("WIFI"), Some(true)),
            "wg".to_string()
        );
        assert_eq!(
            normalize_wm4_real_network_type(Some("WIFI"), Some(false)),
            "w".to_string()
        );
        assert_eq!(
            normalize_wm4_real_network_type(Some("LTE"), Some(true)),
            "g".to_string()
        );
    }

    #[test]
    fn parse_optional_bool_flag_handles_empty_numeric_and_text_values() {
        assert_eq!(parse_optional_bool_flag(None), None);
        assert_eq!(parse_optional_bool_flag(Some("")), None);
        assert_eq!(parse_optional_bool_flag(Some("null")), None);
        assert_eq!(parse_optional_bool_flag(Some("1")), Some(true));
        assert_eq!(parse_optional_bool_flag(Some("0")), Some(false));
        assert_eq!(parse_optional_bool_flag(Some("enabled")), Some(true));
    }

    #[test]
    fn normalize_locale_tag_prefers_first_non_empty_and_uses_underscore() {
        assert_eq!(
            normalize_locale_tag(Some("zh-CN,en-US")),
            Some("zh_CN".to_string())
        );
        assert_eq!(
            normalize_locale_tag(Some("zh_CN")),
            Some("zh_CN".to_string())
        );
    }

    #[test]
    fn derive_display_density_string_formats_integer_and_fractional_scales() {
        assert_eq!(
            derive_display_density_string(Some("480")),
            Some("3".to_string())
        );
        assert_eq!(
            derive_display_density_string(Some("440")),
            Some("2.75".to_string())
        );
    }

    #[test]
    fn normalize_sensor_name_list_for_fm1_trims_virtual_tail_after_step_wakeup() {
        let sensors = vec![
            "bmi2xy acc_bosch".to_string(),
            "step_detect_wakeup_mtk".to_string(),
            "OPLUS Fusion Light Sensor_OPLUS".to_string(),
            "OPLUS Side Panel Fusion Light Sensor_OPLUS".to_string(),
            "Gravity Sensor_AOSP".to_string(),
            "Rotation Vector Sensor_AOSP".to_string(),
        ];
        assert_eq!(
            normalize_sensor_name_list_for_fm1(sensors),
            vec![
                "bmi2xy acc_bosch".to_string(),
                "step_detect_wakeup_mtk".to_string(),
            ]
        );
    }

    #[test]
    fn build_palmchat_user_agent_headers_follow_static_formula() {
        let profile = PalmchatLiveDeviceProfile {
            source: "test".to_string(),
            channel_id: Some("OPPO_A56925F58B07B8B6".to_string()),
            product_brand: Some("realme".to_string()),
            product_model: Some("RMX3560".to_string()),
            product_manufacturer: Some("realme".to_string()),
            build_release: Some("14".to_string()),
            build_id: Some("UKQ1.230924.001".to_string()),
            locale_tag: Some("zh_CN".to_string()),
            display_density: Some("3".to_string()),
            ..Default::default()
        };
        let app_version_info = PalmchatAppVersionInfo {
            version_code: Some("260309".to_string()),
            version_name: Some("8.2.1.3".to_string()),
            source: Some("test".to_string()),
        };
        let body = json!({
            "channelId": "OPPO_A56925F58B07B8B6"
        });
        assert_eq!(
            build_palmchat_user_agent_zx(Some(&profile), &app_version_info, Some(&body)),
            Some(
                "realme/RMX3560/Android/14/260309/8.2.1.3/zh_CN/3x/OPPO_A56925F58B07B8B6/realme"
                    .to_string()
            )
        );
        assert_eq!(
            build_palmchat_user_agent_zx_version(Some("8.2.1.3")),
            Some("Android/8.2.1.3".to_string())
        );
        assert_eq!(
            build_android_dalvik_user_agent(Some(&profile)),
            Some("Dalvik/2.1.0 (Linux; U; Android 14; RMX3560 Build/UKQ1.230924.001)".to_string())
        );
    }

    #[test]
    fn apply_live_profile_to_dfp_rewrites_stale_device_fields() {
        let mut dfp_obj = Map::new();
        dfp_obj.insert(
            "android.os.Build.BRAND".to_string(),
            Value::String("OPPO".to_string()),
        );
        dfp_obj.insert(
            "android.os.Build.MODEL".to_string(),
            Value::String("PGJM10".to_string()),
        );
        dfp_obj.insert(
            "build_fingerprint".to_string(),
            Value::String("old/fingerprint".to_string()),
        );
        let profile = PalmchatLiveDeviceProfile {
            source: "test".to_string(),
            secinfo_json: Some("{\"pc\":1}".to_string()),
            product_brand: Some("realme".to_string()),
            product_model: Some("RMX3560".to_string()),
            product_device: Some("RE5489".to_string()),
            product_name: Some("RMX3560".to_string()),
            product_board: Some("k6895v1_64".to_string()),
            hardware: Some("mt6895".to_string()),
            build_release: Some("14".to_string()),
            build_fingerprint: Some(
                "realme/RMX3560/RE5489:14/UKQ1.230924.001/S.1d187e8-1deb8-1168de:user/release-keys"
                    .to_string(),
            ),
            build_display: Some("RMX3560_14.0.0.932(CN01)".to_string()),
            build_host: Some("dg02-pool07-kvm194".to_string()),
            build_id: Some("UKQ1.230924.001".to_string()),
            build_security_patch: Some("2025-03-01".to_string()),
            product_manufacturer: Some("realme".to_string()),
            product_abi_list: vec![
                "arm64-v8a".to_string(),
                "armeabi-v7a".to_string(),
                "armeabi".to_string(),
            ],
            wlan_ipv4: Some("192.168.1.12".to_string()),
            wifi_ssid: Some("CMCC-4C37_5G".to_string()),
            network_type: Some("WIFI".to_string()),
            network_state: Some("WIFI_CMCC-4C37_5G".to_string()),
            webview_user_agent: Some("Mozilla/5.0 (Linux; Android 14; RMX3560 Build/UKQ1.230924.001; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/117.0.0.0 Mobile Safari/537.36".to_string()),
            resolution: Some("1080x2412".to_string()),
            screen_brightness: Some(12),
            screen_on: Some(false),
            usb_state: Some("adb".to_string()),
            sensor_name_list: vec!["bmi2xy acc_bosch".to_string()],
            ..Default::default()
        };
        let mut events = Vec::new();
        apply_live_profile_to_dfp(&mut dfp_obj, &profile, &mut events);
        assert_eq!(
            dfp_obj
                .get("android.os.Build.BRAND")
                .and_then(Value::as_str),
            Some("realme")
        );
        assert_eq!(
            dfp_obj
                .get("android.os.Build.MODEL")
                .and_then(Value::as_str),
            Some("RMX3560")
        );
        assert_eq!(
            dfp_obj.get("build_fingerprint").and_then(Value::as_str),
            Some(
                "realme/RMX3560/RE5489:14/UKQ1.230924.001/S.1d187e8-1deb8-1168de:user/release-keys"
            )
        );
        assert_eq!(
            dfp_obj.get("sinfo").and_then(Value::as_str),
            Some("{\"pc\":1}")
        );
        assert_eq!(
            dfp_obj.get("screen_on").and_then(Value::as_bool),
            Some(false)
        );
        assert_eq!(
            dfp_obj.get("net_type").and_then(Value::as_str),
            Some("WIFI")
        );
        assert_eq!(
            dfp_obj.get("netState").and_then(Value::as_str),
            Some("WIFI_CMCC-4C37_5G")
        );
        assert_eq!(
            dfp_obj.get("wifiSSID").and_then(Value::as_str),
            Some("CMCC-4C37_5G")
        );
        assert_eq!(
            dfp_obj.get("wifi_ip").and_then(Value::as_str),
            Some("192.168.1.12")
        );
        assert_eq!(
            dfp_obj.get("http.agent").and_then(Value::as_str),
            Some("Mozilla/5.0 (Linux; Android 14; RMX3560 Build/UKQ1.230924.001; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/117.0.0.0 Mobile Safari/537.36")
        );
        assert!(events
            .iter()
            .any(|event| event.starts_with("dfp.android.os.Build.BRAND=")));
    }

    #[test]
    fn apply_fm1_compatible_dfp_defaults_populates_missing_keys() {
        let mut dfp_obj = Map::new();
        let body_obj = json!({
            "imei": Value::Null,
            "mac": ""
        })
        .as_object()
        .cloned()
        .expect("body object");
        let profile = PalmchatLiveDeviceProfile {
            source: "test".to_string(),
            build_bootloader: Some("unknown".to_string()),
            build_version_codename: Some("REL".to_string()),
            build_time_millis: Some(1_742_542_413_000),
            cpu_cores: Some(8),
            cpu_features: Some("fp asimd evtstrm aes pmull sha1 sha2 crc32 atomics".to_string()),
            cpu_processor: None,
            cpuinfo_hardware: None,
            cpu_max_freq: Some("2850000".to_string()),
            cpu_min_freq: Some("500000".to_string()),
            kernel_version: Some("6.1.25-android14".to_string()),
            build_display: Some("RMX3560_14.0.0.932(CN01)".to_string()),
            build_incremental: Some("S.1d187e8-1deb8-1168de".to_string()),
            baseband_version: Some("M_V3_P10,M_V3_P10".to_string()),
            http_proxy_port: Some(0),
            boot_time_millis: Some(1_700_000_000_000),
            enabled_accessibility_packages: vec!["com.example.service".to_string()],
            input_method_ids: vec!["com.sohu.inputmethod.sogouoem/.SogouIME".to_string()],
            input_method_labels: vec!["搜狗输入法定制版".to_string()],
            ..Default::default()
        };
        let mut events = Vec::new();
        apply_fm1_compatible_dfp_defaults(&mut dfp_obj, &body_obj, &profile, &mut events);
        assert_eq!(
            dfp_obj.get("app_name").and_then(Value::as_str),
            Some("palmchat")
        );
        assert_eq!(dfp_obj.get("gles").and_then(Value::as_i64), Some(3));
        assert_eq!(
            dfp_obj.get("build_bootloader").and_then(Value::as_str),
            Some("unknown")
        );
        assert_eq!(
            dfp_obj
                .get("build_version_codename")
                .and_then(Value::as_str),
            Some("REL")
        );
        assert_eq!(
            dfp_obj.get("proxy_ip").and_then(Value::as_str),
            Some("none")
        );
        assert_eq!(
            dfp_obj.get("hasQemuDrivers").and_then(Value::as_str),
            Some("false")
        );
        assert_eq!(
            dfp_obj.get("QEmuFiles").and_then(Value::as_str),
            Some("null")
        );
        assert!(!dfp_obj.contains_key("deviceId"));
        assert!(!dfp_obj.contains_key("imei"));
        assert!(!dfp_obj.contains_key("imsi"));
        assert_eq!(
            dfp_obj.get("basicVersion").and_then(Value::as_str),
            Some("M_V3_P10,M_V3_P10")
        );
        assert_eq!(
            dfp_obj.get("innerVersion").and_then(Value::as_str),
            Some("S.1d187e8-1deb8-1168de")
        );
        assert_eq!(
            dfp_obj.get("kernelVersion").and_then(Value::as_str),
            Some("6.1.25-android14")
        );
        assert_eq!(
            dfp_obj.get("build_time").and_then(Value::as_i64),
            Some(1_742_542_413_000)
        );
        assert_eq!(dfp_obj.get("cpu_cores").and_then(Value::as_i64), Some(8));
        assert_eq!(
            dfp_obj.get("cpu_features").and_then(Value::as_str),
            Some("fp asimd evtstrm aes pmull sha1 sha2 crc32 atomics")
        );
        assert_eq!(
            dfp_obj.get("cpu_processor").and_then(Value::as_str),
            Some("unknown")
        );
        assert_eq!(
            dfp_obj.get("cpu_hardware").and_then(Value::as_str),
            Some("unknown")
        );
        assert_eq!(
            dfp_obj.get("in").and_then(Value::as_str),
            Some("[\"搜狗输入法定制版\"]")
        );
        assert_eq!(
            dfp_obj.get("hasTracerPid").and_then(Value::as_str),
            Some("false")
        );
        assert_eq!(
            dfp_obj.get("isDebuggerConnected").and_then(Value::as_str),
            Some("false")
        );
        assert_eq!(
            dfp_obj
                .get("accessibility_list")
                .and_then(Value::as_array)
                .and_then(|items| items.first())
                .and_then(Value::as_object)
                .and_then(|item| item.get("package"))
                .and_then(Value::as_str),
            Some("com.example.service")
        );
        assert!(events.iter().any(|event| event == "dfp.app_name=palmchat"));
    }

    #[test]
    fn parse_proc_version_release_extracts_kernel_release() {
        assert_eq!(
            parse_proc_version_release(Some("Linux version 5.10.209-android12-9-o-g2a9a714f7ee6 (builder@host) #1 SMP PREEMPT Thu Mar 13 04:17:13 UTC 2025")),
            Some("5.10.209-android12-9-o-g2a9a714f7ee6".to_string())
        );
    }

    #[test]
    fn derive_fm1_inner_version_prefers_incremental_when_display_lacks_it() {
        assert_eq!(
            derive_fm1_inner_version(
                Some("RMX3560_14.0.0.932(CN01)"),
                Some("S.1d187e8-1deb8-1168de")
            ),
            Some("S.1d187e8-1deb8-1168de".to_string())
        );
    }

    #[test]
    fn parse_unix_seconds_to_millis_scales_seconds() {
        assert_eq!(
            parse_unix_seconds_to_millis(Some("1742542413")),
            Some(1_742_542_413_000)
        );
    }

    #[test]
    fn parse_input_method_labels_prefers_ime_name_from_dumpsys() {
        let raw = r#"
          rank=0 item=ImeSubtypeListItem{mImeName=搜狗输入法定制版 mSubtypeName=null mSubtypeId=1 mIsSystemLocale=true}
          rank=1 item=ImeSubtypeListItem{mImeName=ToDesk输入法 mSubtypeName=null mSubtypeId=2 mIsSystemLocale=false}
        "#;
        assert_eq!(
            parse_input_method_labels(raw),
            vec!["搜狗输入法定制版".to_string(), "ToDesk输入法".to_string()]
        );
    }

    #[test]
    fn build_secinfo_json_computes_digests_and_network_flag() {
        let secinfo_net_raw = r#"
su_paths=/system/bin/su,
u0_a333 21991 1115 0 0 0 0 S com.zenmen.palmchat
u0_a333 21992 1115 0 0 0 0 S com.zenmen.palmchat:persistent
38: wlan0    inet 192.168.1.12/24 brd 192.168.1.255 scope global wlan0
        "#;
        let secinfo_dirs_raw = r#"
dir_begin=/data/system
/data/system/a|12|10
dir_end=/data/system
dir_begin=/vendor/firmware
/vendor/firmware/fw.bin|34|20
dir_end=/vendor/firmware
dir_begin=/vendor/lib
/vendor/lib/libx.so|56|30
dir_end=/vendor/lib
dir_begin=/system/bin
/system/bin/sh|78|40
dir_end=/system/bin
dir_begin=/system/framework
/system/framework/framework.jar|90|50
dir_end=/system/framework
        "#;
        let value = build_secinfo_json(
            Some("release-keys"),
            secinfo_net_raw,
            secinfo_dirs_raw,
            "com.zenmen.palmchat",
            &["com.zenmen.palmchat".to_string()],
        )
        .expect("sinfo");
        let parsed = serde_json::from_str::<Value>(&value).expect("json");
        assert_eq!(parsed.get("plt").and_then(Value::as_bool), Some(true));
        assert_eq!(parsed.get("pc").and_then(Value::as_i64), Some(1));
        assert_eq!(parsed.get("v").and_then(Value::as_bool), Some(false));
        assert_eq!(parsed.get("r").and_then(Value::as_bool), Some(true));
        assert_eq!(parsed.get("ne").and_then(Value::as_str), Some("0,"));
        assert!(parsed.get("ds").and_then(Value::as_str).is_some());
        assert!(parsed.get("sf").and_then(Value::as_str).is_some());
    }

    #[test]
    fn normalize_non_empty_candidate_preserves_unknown_literal() {
        assert_eq!(
            normalize_non_empty_candidate(Some("unknown".to_string())).as_deref(),
            Some("unknown")
        );
    }

    #[test]
    fn parse_secinfo_ps_output_filters_to_existing_data_directories() {
        let raw = r#"
USER      PID   PPID  VSZ  RSS WCHAN            ADDR S NAME
u0_a333 21991 1115 0 0 0 0 S com.zenmen.palmchat
u0_a333 22223 1115 0 0 0 0 S com.zenmen.palmchat.daemon
u0_a333 22231 1115 0 0 0 0 S com.zenmen.palmchat:assist
u0_a333 22916 1115 0 0 0 0 S daemon
        "#;
        let (user, dirs) = parse_secinfo_ps_output_with_data_dirs(
            raw,
            "com.zenmen.palmchat",
            &["com.zenmen.palmchat".to_string()],
        );
        assert_eq!(user.as_deref(), Some("u0_a333"));
        assert_eq!(dirs, vec!["com.zenmen.palmchat".to_string()]);
    }

    #[test]
    fn ensure_dfp_payload_keeps_live_device_label_and_unknown_bootloader() {
        let mut map = Map::new();
        let profile = PalmchatLiveDeviceProfile {
            source: "test".to_string(),
            build_bootloader: Some("unknown".to_string()),
            build_version_codename: Some("REL".to_string()),
            device_label: Some("LABEL_SEED".to_string()),
            ..Default::default()
        };
        let mut events = Vec::new();
        ensure_dfp_payload(
            &mut map,
            Some("5ac9abc225faadfe"),
            Some("8.2.1.3"),
            Some("com.zenmen.palmchat"),
            profile.device_label.as_deref(),
            Some(&profile),
            &mut events,
        );
        let dfp = match parse_json_string_or_object(map.get("dfp")) {
            Some(Value::Object(obj)) => obj,
            other => panic!("unexpected dfp payload: {other:?}"),
        };
        assert_eq!(
            dfp.get("duDeviceLabel").and_then(Value::as_str),
            Some("LABEL_SEED")
        );
        assert_eq!(
            dfp.get("build_bootloader").and_then(Value::as_str),
            Some("unknown")
        );
    }

    #[test]
    fn prune_new_sms_auto_noise_fields_drops_device_id_and_local_smid() {
        let mut map = Map::new();
        map.insert(
            "mobile".to_string(),
            Value::String("17696723664".to_string()),
        );
        map.insert("countryCode".to_string(), Value::String("86".to_string()));
        map.insert("appId".to_string(), Value::String("ZX0001".to_string()));
        map.insert(
            "channelId".to_string(),
            Value::String("OPPO_A56925F58B07B8B6".to_string()),
        );
        map.insert("verifyStatus".to_string(), Value::Bool(false));
        map.insert("paramNum".to_string(), Value::from(4));
        map.insert(
            "device_id".to_string(),
            Value::String("DUK7YauhItfeckmN".to_string()),
        );
        map.insert(
            "local_smid".to_string(),
            Value::String("YXDUK7YauhItfeckmN".to_string()),
        );
        let mut events = Vec::new();
        assert!(is_new_sms_v7_profile(&map));
        prune_new_sms_auto_noise_fields(&mut map, &mut events);
        assert!(!map.contains_key("device_id"));
        assert!(!map.contains_key("local_smid"));
        assert!(events
            .iter()
            .any(|event| event == "drop.device_id=absent-in-proven-new-sms-body"));
        assert!(events
            .iter()
            .any(|event| event == "drop.local_smid=absent-in-proven-new-sms-body"));
    }

    #[test]
    fn prune_new_sms_auto_noise_fields_drops_seeded_noise_fields() {
        let mut map = Map::new();
        map.insert(
            "device_id".to_string(),
            Value::String("seeded-device-id".to_string()),
        );
        map.insert(
            "local_smid".to_string(),
            Value::String("seeded-local-smid".to_string()),
        );

        let mut events = Vec::new();
        prune_new_sms_auto_noise_fields(&mut map, &mut events);

        assert!(!map.contains_key("device_id"));
        assert!(!map.contains_key("local_smid"));
        assert_eq!(events.len(), 2);
    }

    #[test]
    fn v7_required_non_empty_keys_only_require_captcha_patch_on_stage2() {
        let mut stage1 = Map::new();
        stage1.insert("verifyStatus".to_string(), Value::Bool(false));
        let stage1_keys = v7_required_non_empty_keys(&stage1);
        assert!(!stage1_keys.contains(&"modeType"));
        assert!(!stage1_keys.contains(&"rid"));
        assert!(!stage1_keys.contains(&"diffTime"));

        let mut stage2 = Map::new();
        stage2.insert("verifyStatus".to_string(), Value::Bool(true));
        let stage2_keys = v7_required_non_empty_keys(&stage2);
        assert!(stage2_keys.contains(&"modeType"));
        assert!(stage2_keys.contains(&"rid"));
        assert!(stage2_keys.contains(&"diffTime"));
    }

    #[test]
    fn v7_required_non_empty_keys_ignore_empty_retry_tuple_on_first_stage() {
        let mut stage1 = Map::new();
        stage1.insert("verifyStatus".to_string(), Value::Bool(false));
        stage1.insert("rid".to_string(), Value::String(String::new()));
        stage1.insert("modeType".to_string(), Value::String("select".to_string()));
        stage1.insert("diffTime".to_string(), Value::String("0".to_string()));
        let stage1_keys = v7_required_non_empty_keys(&stage1);
        assert!(!stage1_keys.contains(&"rid"));
        assert!(!stage1_keys.contains(&"modeType"));
        assert!(!stage1_keys.contains(&"diffTime"));
    }

    #[test]
    fn collect_null_like_keys_marks_missing_and_unknown_values() {
        let mut map = Map::new();
        map.insert("imei".to_string(), Value::Null);
        map.insert("oneId".to_string(), Value::String("unknown".to_string()));
        map.insert(
            "mobile".to_string(),
            Value::String("17696723664".to_string()),
        );
        let missing = collect_null_like_keys(&map, &["imei", "oneId", "mobile", "did"]);
        assert_eq!(
            missing,
            vec!["imei".to_string(), "oneId".to_string(), "did".to_string()]
        );
    }

    #[test]
    fn build_v7_payload_debug_surface_exposes_stage_metrics() {
        let stage2 = json!({
            "mobile": "17696723664",
            "countryCode": "86",
            "paramNum": 4,
            "verifyStatus": true,
            "rid": "RID_STAGE2",
            "modeType": "select",
            "diffTime": "5000",
            "platform": "android",
            "versionCode": "260304",
            "autoLogin": "0",
            "dfp": "{\"duDeviceLabel\":\"LABELX\"}",
            "appList": "{\"channelId\":\"OPPO_A56925F58B07B8B6_dyn\",\"package\":[{\"packageName\":\"com.zenmen.palmchat\"}]}",
            "ipInfo": "{}",
            "sdid": "SDID_STAGE2",
            "oaid": "OAID_STAGE2",
            "androidId": "5ac9abc225faadfe",
            "appId": "ZX0001",
            "channelId": "OPPO_A56925F58B07B8B6",
            "did": "null__5ac9abc225faadfe"
        });
        let smssend_two_step = json!({
            "stage1_encrypt": {
                "cipher_bytes": 4112,
                "cipher_sha256": "stage1cipher"
            }
        });

        let surface =
            build_v7_payload_debug_surface(None, &stage2, "AABBCC", Some(&smssend_two_step));

        assert_eq!(
            surface
                .get("stage1_candidate")
                .and_then(|value| value.get("cipher_bytes"))
                .and_then(Value::as_u64),
            Some(4112)
        );
        assert_eq!(
            surface
                .get("stage2_effective")
                .and_then(|value| value.get("cipher_bytes"))
                .and_then(Value::as_u64),
            Some(3)
        );
        assert_eq!(
            surface
                .get("stage2_effective")
                .and_then(|value| value.get("namespace_views"))
                .and_then(|value| value.get("appList"))
                .and_then(|value| value.get("channelId"))
                .and_then(Value::as_str),
            Some("OPPO_A56925F58B07B8B6_dyn")
        );
        assert!(surface
            .get("stage1_to_stage2_top_level_delta")
            .and_then(|value| value.get("added"))
            .and_then(Value::as_array)
            .map(|items| items.iter().any(|item| item.as_str() == Some("rid")))
            .unwrap_or(false));
        assert!(surface
            .get("stage1_to_stage2_top_level_delta")
            .and_then(|value| value.get("changed"))
            .and_then(|value| value.get("verifyStatus"))
            .is_some());
    }

    #[test]
    fn palmchat_transport_runtime_accepts_okhttp_bridge_aliases() {
        for value in ["okhttp-bridge", "okhttp_bridge", "okhttp"] {
            assert_eq!(
                PalmchatTransportRuntime::parse(Some(value)).unwrap(),
                PalmchatTransportRuntime::OkHttpBridge
            );
        }
        assert_eq!(
            PalmchatTransportRuntime::parse(Some("direct")).unwrap(),
            PalmchatTransportRuntime::Direct
        );
    }

    #[test]
    fn payload_body_bytes_from_transport_json_prefers_base64_body() {
        let payload = json!({
            "body": "ignored",
            "body_base64": BASE64_STANDARD.encode(b"{\"resultCode\":1900}")
        });
        assert_eq!(
            payload_body_bytes_from_transport_json(&payload),
            Some(b"{\"resultCode\":1900}".to_vec())
        );
    }
}
