use std::any::Any;
use std::cell::{RefCell, UnsafeCell};
use std::collections::{BTreeMap, HashMap, HashSet, VecDeque};
use std::fs::{self, File};
use std::io::{self, Read, Write};
use std::net::{TcpListener, TcpStream};
use std::os::unix::fs::symlink;
use std::path::{Path, PathBuf};
use std::process::Command;
use std::rc::Rc;
use std::time::Duration;

use anyhow::{anyhow, Context, Result};
use boa_engine::{Context as BoaContext, Source};
use chrono::{SecondsFormat, Utc};
use emulator::android::dvm::class::DvmClass;
use emulator::android::dvm::class_resolver::ClassResolver;
use emulator::android::dvm::member::DvmMethod;
use emulator::android::dvm::object::DvmObject;
use emulator::android::dvm::DalvikVM64;
use emulator::android::jni::{self, Jni, JniValue, MethodAcc, VaList};
use emulator::android::virtual_library::libc::SystemPropertyService;
use emulator::linux::file_system::{FileIO, StMode};
use emulator::linux::fs::linux_file::LinuxFileIO;
use emulator::linux::fs::ByteArrayFileIO;
use emulator::linux::PAGE_ALIGN;
use emulator::memory::svc_memory::SvcCallResult::RET;
use emulator::memory::svc_memory::{SimpleArm64Svc, SvcCallResult};
#[cfg(feature = "unicorn")]
use emulator::UnicornRegisterARM64;
use emulator::{AndroidEmulator, Backend, BackendKind, Permission, RegisterARM64, UnicornArg};
use serde::{Deserialize, Serialize};
use serde_json::{json, Map, Value};
use std::mem::size_of;
use std::time::SystemTime;
use std::time::UNIX_EPOCH;
use reqwest::blocking::Client;
use reqwest::header::{HeaderMap, HeaderName, HeaderValue};
#[cfg(feature = "unicorn")]
use unicorn_engine::unicorn_const::HookType;

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
    "dfp",
    "appList",
    "ipInfo",
    "sdid",
    "oaid",
    "androidId",
    "appId",
    "local_smid",
    "channelId",
    "did",
    "oneId",
    "device_id",
];
const V7_CAPTCHA_BRIDGE_KEYS: &[&str] = &["verifyStatus", "rid", "modeType", "diffTime", "captcha"];

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

    fn effective_process_name(&self, package_name: &str) -> String {
        if self.process_name.trim().is_empty() {
            package_name.to_string()
        } else {
            self.process_name.clone()
        }
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
    shared: Rc<RefCell<SharedState>>,
) -> PalmchatAppVersionInfo {
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
    emulator: AndroidEmulator<'static, ()>,
    encrypt_utils_class: Rc<DvmClass>,
    messaging_service_class: Rc<DvmClass>,
    shared: Rc<RefCell<SharedState>>,
    identity_seed: PalmchatIdentityRuntimeState,
    identity_state: Rc<RefCell<PalmchatIdentityRuntimeState>>,
    module_base: u64,
    module_size: u64,
}

impl PalmchatLab {
    fn load_with_backend(
        config_path: impl AsRef<Path>,
        backend_override: Option<&str>,
    ) -> Result<Self> {
        let config = PalmchatConfig::load(config_path)?.with_backend_override(backend_override)?;
        validate_config(&config)?;
        let shared = Rc::new(RefCell::new(SharedState::new(&config.trace_out_dir)?));
        let identity_seed = PalmchatIdentityRuntimeState::from_config(&config.identity_probe);
        let identity_state = Rc::new(RefCell::new(identity_seed.clone()));
        let app_version_info = resolve_app_version_info(&config, shared.clone());
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
        install_system_properties(&emulator, &config);
        configure_file_system(&emulator, &config);

        let vm = emulator.get_dalvik_vm();
        vm.set_class_resolver(build_class_resolver());
        vm.set_jni(Box::new(PalmchatJni::new(
            shared.clone(),
            config.package_name.clone(),
            config.apk_path.clone(),
            identity_state.clone(),
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
            hashkey_fast_global_ref,
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
                    if err_text.contains("version=1") {
                        shared.borrow_mut().native(&format!(
                            "JNI_OnLoad hidden symbol fallback non-fatal err={}",
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
            emulator,
            encrypt_utils_class,
            messaging_service_class,
            shared,
            identity_seed,
            identity_state,
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
        if let Some(value) = opts.get("--process-name") {
            state.process_name = value.clone();
        }
        *self.identity_state.borrow_mut() = state;
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
            "runtime_state_seed": self.identity_seed.clone(),
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
            "app_init_upstream_observation": app_init_upstream_observation,
            "evidence": {
                "privacy_agree_device_pref": "/Users/haojiejack/github/drizzle-dumper-rust/boss_purecalc/risk/fengkong-slide-solver/artifacts/device_20260326_203005/extracted2/palmchat_pull/shared_prefs/wifi_social.xml:22",
                "app_init_callsite": "/Users/haojiejack/github/drizzle-dumper-rust/artifacts/palmchat_apponly_jadx_20260324_230038/sources/com/zenmen/palmchat/AppContext.java:607",
                "read_phone_state_runtime_check": "adb shell dumpsys package com.zenmen.palmchat | rg READ_PHONE_STATE",
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
            self.shared
                .borrow_mut()
                .native("captcha_ui_debug step=flow start");
            let output = self.run_flow_for_captcha_ui(
                &stage2_raw,
                &stage1_raw_normalized,
                opts,
                &ui_source,
            )?;
            self.shared
                .borrow_mut()
                .native("captcha_ui_debug step=flow done");
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
        if let Some(flag) = opts.get("--smssend-test") {
            cmd.arg("--smssend-test").arg(flag);
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

    fn run_smssend_test(
        &mut self,
        control_feedback: &Value,
        cipher_hex: &str,
        use_new_key: bool,
        opts: &HashMap<String, String>,
    ) -> Value {
        let Some(feedback_obj) = control_feedback.as_object() else {
            return json!({
                "status": "blocked",
                "reason": "invalid_control_feedback_format",
            });
        };
        let ready = feedback_obj
            .get("ready_for_smssend")
            .and_then(Value::as_bool)
            .unwrap_or(false);
        if !ready {
            return json!({
                "status": "blocked",
                "reason": "control_feedback_not_ready",
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
        if let Some(ua) = user_agent.as_ref() {
            if let Ok(header_value) = HeaderValue::from_str(ua) {
                headers.insert(reqwest::header::USER_AGENT, header_value);
            }
        }

        let client = match Client::builder()
            .timeout(Duration::from_millis(timeout_ms))
            .build()
        {
            Ok(client) => client,
            Err(err) => {
                return json!({
                    "status": "blocked",
                    "reason": "build_http_client_failed",
                    "error": err.to_string(),
                });
            }
        };

        match client.post(url).headers(headers.clone()).body(body_bytes).send() {
            Ok(response) => {
                let status = response.status().as_u16();
                let response_headers = response.headers().clone();
                let response_bytes = match response.bytes() {
                    Ok(bytes) => bytes.to_vec(),
                    Err(err) => {
                        return json!({
                            "status": "blocked",
                            "reason": "read_response_failed",
                            "http_status": status,
                            "error": err.to_string(),
                        });
                    }
                };
                let encrypted_header = response_headers
                    .get("content-encrypted-zx")
                    .and_then(|value| value.to_str().ok())
                    .unwrap_or_default()
                    .to_string();
                let decoded_bytes = if encrypted_header == "1" {
                    match self.call_static(
                        "cipherWithType",
                        "([BIZ)[B",
                        vec![
                            JniValue::Object(DvmObject::ByteArray(response_bytes.clone())),
                            3.into(),
                            use_new_key.into(),
                        ],
                    ) {
                        Ok(value) => jni_value_to_bytes(value).unwrap_or(response_bytes.clone()),
                        Err(_) => response_bytes.clone(),
                    }
                } else {
                    response_bytes.clone()
                };
                let decoded_utf8 = String::from_utf8_lossy(&decoded_bytes).to_string();
                let decoded_json = serde_json::from_slice::<Value>(&decoded_bytes).ok();
                let result_code = decoded_json
                    .as_ref()
                    .and_then(|value| value.get("resultCode"))
                    .and_then(Value::as_i64);
                let mut response_header_map = Map::new();
                for (name, value) in response_headers.iter() {
                    response_header_map.insert(
                        name.to_string(),
                        Value::String(value.to_str().unwrap_or_default().to_string()),
                    );
                }
                json!({
                    "status": "ok",
                    "http_status": status,
                    "result_code": result_code,
                    "response_headers": response_header_map,
                    "response_body_hex": hex::encode(&response_bytes).to_ascii_uppercase(),
                    "response_decoded_hex": hex::encode(&decoded_bytes).to_ascii_uppercase(),
                    "response_decoded_utf8": decoded_utf8,
                    "response_decoded_json": decoded_json,
                    "control_feedback": control_feedback,
                })
            }
            Err(err) => json!({
                "status": "blocked",
                "reason": "smssend_http_failed",
                "error": err.to_string(),
                "control_feedback": control_feedback,
            }),
        }
    }

    fn run_invoke(&mut self, opts: &HashMap<String, String>) -> Result<Value> {
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
            "getEncryptedCKey" => {
                let use_new_key = parse_bool_like(&arg1);
                let value =
                    self.call_static("getEncryptedCKey", "(Z)[B", vec![use_new_key.into()])?;
                let bytes = jni_value_to_bytes(value)?;
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
                    "unsupported method: {method}; supported=skeyAvailable|createCKey|setSecretKeys|getCkVersion|ckDiag|appInitProbe|gateProbe|getEncryptedCKey|setLxData|cipherWithHashKey|cipherWithType"
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

        if let Value::Object(map) = &mut value {
            if let Some(version_code) = self.app_version_info.version_code.as_ref() {
                let normalized = version_code
                    .parse::<i64>()
                    .ok()
                    .map(|parsed| Value::Number(parsed.into()))
                    .unwrap_or_else(|| Value::String(version_code.clone()));
                let previous = map.get("versionCode").cloned().unwrap_or(Value::Null);
                if previous != normalized {
                    map.insert("versionCode".to_string(), normalized.clone());
                    changed_fields.push(format!("versionCode:{}=>{}", previous, normalized));
                }
            }

            if let Some(version_name) = self.app_version_info.version_name.as_ref() {
                let normalized = Value::String(version_name.clone());
                let previous = map.get("versionName").cloned().unwrap_or(Value::Null);
                if previous != normalized {
                    map.insert("versionName".to_string(), normalized.clone());
                    changed_fields.push(format!("versionName:{}=>{}", previous, normalized));
                }
            }
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

        let (normalized_raw, json_value) = self.normalize_flow_arg1_json(&raw, "flow");
        let bridge_stage1_value = opts
            .get("--bridge-stage1-json")
            .map(|value| self.normalize_flow_arg1_json(value, "flow.bridge_stage1").1);
        let v7_captcha_bridge_surface =
            build_v7_captcha_bridge_surface(bridge_stage1_value.as_ref(), &json_value);
        let v7_base_field_production = build_v7_base_field_production(&json_value);
        let v7_identity_dependency_graph = build_v7_identity_dependency_graph(&json_value);
        let v7_identity_gate_diagnostics = build_v7_identity_gate_diagnostics();
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
        let encrypted_ckey_bytes = jni_value_to_bytes(encrypted_ckey)?;
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
        let cipher_bytes = jni_value_to_bytes(cipher_value).ok();
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
            opts,
        );
        let smssend_test = if opts
            .get("--smssend-test")
            .map(|value| parse_bool_like(value))
            .unwrap_or(false)
        {
            Some(self.run_smssend_test(
                &data_to_control_feedback,
                &cipher_hex,
                use_new_key,
                opts,
            ))
        } else {
            None
        };

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
            "v7_captcha_business_surface": v7_captcha_business_surface,
            "palmchat_project_planes": palmchat_project_planes,
            "app_version_from_original": {
                "versionCode": self.app_version_info.version_code,
                "versionName": self.app_version_info.version_name,
                "source": self.app_version_info.source,
            },
            "arg2_mode": cipher_mode,
            "arg3_bool": use_new_key,
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
            map.insert(
                "data_to_control_feedback".to_string(),
                data_to_control_feedback,
            );
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
    identity_state: Rc<RefCell<PalmchatIdentityRuntimeState>>,
}

impl PalmchatJni {
    fn new(
        shared: Rc<RefCell<SharedState>>,
        package_name: String,
        apk_path: PathBuf,
        identity_state: Rc<RefCell<PalmchatIdentityRuntimeState>>,
    ) -> Self {
        Self {
            shared,
            package_name,
            apk_path: apk_path.to_string_lossy().to_string(),
            identity_state,
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
                _ => return DvmObject::new_simple(class.clone()).into(),
            }
        }

        match signature.as_str() {
            "com/zenmen/palmchat/AppContext->getContext()Lcom/zenmen/palmchat/AppContext;" => {
                return new_mut_data_object(
                    class.clone(),
                    PalmchatAppContextState {
                        package_name: self.package_name.clone(),
                        apk_path: self.apk_path.clone(),
                    },
                )
                .into();
            }
            "defpackage/r75->l()Z" => {
                let result = self.identity_state.borrow().effective_privacy_agree();
                self.shared
                    .borrow_mut()
                    .jni(&format!("probe r75.l -> {}", result));
                return result.into();
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
    eprintln!("  smoke  [--config <path>] [--backend <auto|dynarmic|unicorn>]");
    eprintln!("  invoke [--config <path>] [--backend <auto|dynarmic|unicorn>] --method <name> [--arg1 <v>] [--arg2 <v>] [--arg3 <v>] [--secret-key <k>] [--secret-iv <iv>]");
    eprintln!("         appInitProbe/gateProbe overrides: [--privacy-agree <bool>] [--read-phone-state <bool>] [--priv-info-init <bool>] [--android-id <str>] [--imei <str>] [--mac <str>] [--process-name <str>]");
    eprintln!("  flow   [--config <path>] [--backend <auto|dynarmic|unicorn>] [--arg1 <json>] [--bridge-stage1-json <json>] [--arg2 <cipher_mode>] [--arg3 <use_new_key_bool>] [--smssend-test <bool>] [--smssend-url <url>] [--smssend-timeout-ms <ms>] [--smssend-user-agent <ua>] [--report-json <path>] [--report-md <path>]");
    eprintln!("  captcha-ui-debug [--config <path>] [--backend <auto|dynarmic|unicorn>] [--stage1-json <json>|--arg1 <json>] [--interactive <bool>] [--ui-mode <sdk|form|tty|headless>] [--sdk-html <path>] [--verify-status <bool>] [--rid <str>] [--mode-type <str>] [--diff-time <ms>] [--flow <bool>] [--arg2 <cipher_mode>] [--arg3 <use_new_key_bool>] [--smssend-test <bool>] [--smssend-url <url>] [--smssend-timeout-ms <ms>] [--smssend-user-agent <ua>] [--jsonl-out <path>] [--report-json <path>] [--report-md <path>]");
    eprintln!("  decrypt-trace [--config <path>] [--backend <auto|dynarmic|unicorn>] [--flow-json <json>] [--flow-mode <cipher_mode>] [--flow-use-new-key <bool>] [--skip-flow]");
    eprintln!("                [--bridge-stage1-json <json>] [--type-input <bytes_or_hex>] [--type-encrypt-mode <int>] [--type-encrypt-use-new-key <bool>] [--type-decrypt-mode <int>] [--type-decrypt-use-new-key <bool>]");
    eprintln!("                [--secret-key <k> --secret-iv <iv>] [--jsonl-out <path>] [--report-json <path>] [--report-md <path>]");
    eprintln!(
        "  report [--config <path>] [--native-log <path>] [--json-out <path>] [--md-out <path>]"
    );
    eprintln!("    methods: skeyAvailable, createCKey, setSecretKeys, getCkVersion, ckDiag, appInitProbe, gateProbe, getEncryptedCKey, setLxData, cipherWithHashKey, cipherWithType");
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
        "com/zenmen/palmchat/AppContext",
        "com/zenmen/palmchat/privinfo/PrivInfoManager",
        "defpackage/r75",
        "defpackage/tg4",
        "defpackage/k86",
        "defpackage/wm4",
        "org/json/JSONObject",
        "android/app/Application",
        "android/content/Context",
        "android/text/TextUtils",
        "android/util/Log",
        "java/lang/Object",
        "java/lang/String",
        "java/lang/String[]",
    ])
}

fn install_system_properties(emulator: &AndroidEmulator<'static, ()>, config: &PalmchatConfig) {
    let api = config.android_api.to_string();
    let service: SystemPropertyService = Rc::new(Box::new(move |name| match name {
        "ro.build.version.sdk" => Some(api.clone()),
        "ro.product.brand" | "ro.product.manufacturer" => Some("realme".to_string()),
        "ro.product.model" | "ro.product.device" => Some("RMX3560".to_string()),
        "ro.hardware" | "ro.boot.hardware" => Some("qcom".to_string()),
        "persist.sys.timezone" => Some("Asia/Shanghai".to_string()),
        _ => None,
    }));
    emulator.set_system_property_service(service);
}

fn configure_file_system(emulator: &AndroidEmulator<'static, ()>, config: &PalmchatConfig) {
    let package_name = config.package_name.clone();
    let apk_path = config.apk_path.clone();
    let so_path = config.so_path.clone();
    let wksec = config.wksec_so_path.clone();
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

fn install_unicorn_trace_hooks(
    emulator: &AndroidEmulator<'static, ()>,
    shared: Rc<RefCell<SharedState>>,
    module_base: u64,
    hashkey_fast_global_ref: Option<i64>,
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
        let verbose_cipher_hooks = std::env::var_os("PALMCHAT_TRACE_CIPHER_VERBOSE").is_some();
        let verbose_plt_hooks = std::env::var_os("PALMCHAT_TRACE_PLT_VERBOSE").is_some();
        let verbose_libc_hooks = std::env::var_os("PALMCHAT_TRACE_LIBC_VERBOSE").is_some();
        let verbose_dispatch_hooks = std::env::var_os("PALMCHAT_TRACE_DISPATCH_VERBOSE").is_some();

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
                "installed unicorn code hooks palmchat=[0x{:x},0x{:x}) palmchat_dispatch=[0x{:x},0x{:x}) libc_rng=[0x{:x},0x{:x}) libc_dispatch=[0x{:x},0x{:x}) toggles cipher={} plt={} libc={} dispatch={} fast_hashkey={}",
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

    Ok(None)
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
        match (method.as_str(), path.as_str()) {
            ("GET", "/") => {
                write_http_response(
                    &mut stream,
                    "200 OK",
                    "text/html; charset=utf-8",
                    html.as_bytes(),
                )?;
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
    flow_enabled: bool,
    sdk_html_path: &Path,
) -> Result<CaptchaUiDebugLaunch> {
    let original_html = load_original_smcaptcha_html(sdk_html_path)?;
    let html = build_captcha_ui_sdk_html(
        &original_html,
        stage1_value,
        default_mode_type,
        flow_enabled,
    )?;
    let listener =
        TcpListener::bind("127.0.0.1:0").context("failed to bind local sdk captcha ui listener")?;
    let addr = listener
        .local_addr()
        .context("failed to resolve sdk captcha ui listener address")?;
    let url = format!("http://{}", addr);
    eprintln!("[captcha-ui-debug] sdk browser ui: {url}");
    if let Err(err) = open_url_in_browser(&url) {
        eprintln!("[captcha-ui-debug] browser open failed: {err:#}");
        eprintln!("[captcha-ui-debug] open this URL manually: {url}");
    }

    let mut ready_ts_millis: Option<u128> = None;
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
        match (method.as_str(), path.as_str()) {
            ("GET", "/") => {
                write_http_response(
                    &mut stream,
                    "200 OK",
                    "text/html; charset=utf-8",
                    html.as_bytes(),
                )?;
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
                extra_events.push(json!({
                    "ts": iso_now(),
                    "phase": "ui_sdk_bridge_event",
                    "event": event,
                    "payload": payload_value,
                }));
                match event {
                    "onReady" => {
                        ready_ts_millis = Some(current_timestamp_millis());
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
                        let diff_time = if let Some(v) = parsed_payload
                            .get("diffTime")
                            .and_then(Value::as_str)
                            .filter(|value| !value.trim().is_empty())
                        {
                            v.to_string()
                        } else if let Some(start) = ready_ts_millis {
                            current_timestamp_millis().saturating_sub(start).to_string()
                        } else {
                            default_diff_time.to_string()
                        };
                        let submission = CaptchaUiDebugSubmission {
                            verify_status,
                            rid,
                            mode_type: default_mode_type.to_string(),
                            diff_time,
                        };
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
) -> Result<String> {
    let stage1_pretty = serde_json::to_string_pretty(stage1_value)?;
    let stage1_json_literal = stage1_value.to_string().replace("</script>", "<\\/script>");
    let mode_type_literal = serde_json::to_string(mode_type)?;
    let patched_mode_html = original_html.replace("xxxxxxxxxxxxxxxxxxxx", mode_type);
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
  const statusEl = document.getElementById('codex-bridge-status');
  document.getElementById('codex-mode-type').textContent = MODE_TYPE;
  document.getElementById('codex-flow-enabled').textContent = String(FLOW_ENABLED);
  function updateStatus(text) {{
    if (statusEl) statusEl.textContent = text;
  }}
  async function postBridge(event, payload) {{
    try {{
      await fetch('/bridge', {{
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
  postBridge('sdk_page_loaded', {{ modeType: MODE_TYPE }});
}})();
</script>
"#,
        stage1_pretty = html_escape(&stage1_pretty),
        stage1_json_literal = stage1_json_literal,
        mode_type_literal = mode_type_literal,
        flow_enabled = if flow_enabled { "true" } else { "false" },
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
    write!(
        stream,
        "HTTP/1.1 {status}\r\nContent-Type: {content_type}\r\nContent-Length: {}\r\nConnection: close\r\n\r\n",
        body.len()
    )
    .context("failed to write browser ui response header")?;
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

fn build_data_to_control_feedback(
    arg1_json: &Value,
    encrypted_ckey_hex: &str,
    cipher_hex: &str,
    ck_version: &str,
    opts: &HashMap<String, String>,
) -> Value {
    let verify_status = arg1_json
        .get("verifyStatus")
        .and_then(Value::as_bool)
        .unwrap_or(false);
    let smssend_url = opts
        .get("--smssend-url")
        .cloned()
        .unwrap_or_else(String::new);
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
        let html = build_captcha_ui_sdk_html(src, &stage1, "select", true)
            .expect("sdk html build should succeed");
        assert!(html.contains("mode:'select'"));
        assert!(html.contains("window.jsBridge"));
        assert!(html.contains("/bridge"));
    }
}
