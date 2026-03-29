use std::any::Any;
use std::cell::{RefCell, UnsafeCell};
use std::collections::{BTreeMap, HashMap, HashSet, VecDeque};
use std::fs::{self, File};
use std::io::Write;
use std::os::unix::fs::symlink;
use std::path::{Path, PathBuf};
use std::rc::Rc;

use anyhow::{anyhow, Context, Result};
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
#[cfg(feature = "unicorn")]
use unicorn_engine::unicorn_const::HookType;

const PID: u32 = 2667;
const PPID: u32 = 2427;

#[derive(Clone, Debug, Deserialize)]
struct PalmchatConfig {
    #[serde(rename = "package")]
    package_name: String,
    apk_path: PathBuf,
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
    trace_out_dir: PathBuf,
    android_api: i32,
    backend: String,
}

impl PalmchatConfig {
    fn load(path: impl AsRef<Path>) -> Result<Self> {
        let path = path.as_ref();
        let raw = fs::read_to_string(path)
            .with_context(|| format!("failed to read config: {}", path.display()))?;
        let mut config: PalmchatConfig = serde_json::from_str(&raw)
            .with_context(|| format!("failed to parse config json: {}", path.display()))?;
        config.apk_path = normalize(config.apk_path);
        config.so_path = normalize(config.so_path);
        config.hash_key_fast = config
            .hash_key_fast
            .map(|value| value.trim().to_ascii_uppercase());
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
    emulator: AndroidEmulator<'static, ()>,
    encrypt_utils_class: Rc<DvmClass>,
    messaging_service_class: Rc<DvmClass>,
    shared: Rc<RefCell<SharedState>>,
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
            emulator,
            encrypt_utils_class,
            messaging_service_class,
            shared,
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
        vm.register_native_method(self.messaging_service_class.id, method_name, signature, fn_ptr)
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
            self.shared.borrow_mut().native("ckdiag step=setLxData start");
            let json_obj = self.make_json_object(raw)?;
            let value =
                self.call_static("setLxData", "(Lorg/json/JSONObject;)V", vec![json_obj.into()])?;
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

        self.shared.borrow_mut().native("ckdiag step=createCKey start");
        let create_value = self.call_static("createCKey", "()V", vec![])?;
        let create_debug = describe_jni_value(&create_value);
        self.shared.borrow_mut().native("ckdiag step=createCKey done");

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
                    "unsupported method: {method}; supported=skeyAvailable|createCKey|setSecretKeys|getCkVersion|ckDiag|getEncryptedCKey|setLxData|cipherWithHashKey|cipherWithType"
                ));
            }
        };

        self.shared
            .borrow_mut()
            .native(&format!("invoke result={}", output));
        Ok(output)
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

        let json_value = serde_json::from_str::<Value>(&raw).unwrap_or(Value::String(raw.clone()));
        let json_obj = self.make_json_object(&raw)?;
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

        let output = json!({
            "flow": "setLxData->createCKey->getEncryptedCKey->cipherWithHashKey",
            "arg1_json": json_value,
            "arg2_mode": cipher_mode,
            "arg3_bool": use_new_key,
            "setLxData": "ok",
            "createCKey": "ok",
            "encrypted_ckey_hex": hex::encode(&encrypted_ckey_bytes),
            "encrypted_ckey_utf8": String::from_utf8_lossy(&encrypted_ckey_bytes),
            "cipher_return_debug": cipher_return_debug,
            "cipher_hex": cipher_bytes.as_ref().map(hex::encode).unwrap_or_default(),
            "cipher_utf8": cipher_bytes
                .as_ref()
                .map(|bytes| String::from_utf8_lossy(bytes).to_string())
                .unwrap_or_default(),
            "cipher_null": cipher_bytes.is_none(),
        });
        self.shared
            .borrow_mut()
            .native(&format!("flow result={}", output));
        Ok(output)
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
}

impl PalmchatJni {
    fn new(shared: Rc<RefCell<SharedState>>, package_name: String, apk_path: PathBuf) -> Self {
        Self {
            shared,
            package_name,
            apk_path: apk_path.to_string_lossy().to_string(),
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
        "smoke" | "invoke" | "flow" => {
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
                _ => unreachable!(),
            };
            if opts.contains_key("--report-json") || opts.contains_key("--report-md") {
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
    eprintln!("  flow   [--config <path>] [--backend <auto|dynarmic|unicorn>] [--arg1 <json>] [--arg2 <cipher_mode>] [--arg3 <use_new_key_bool>] [--report-json <path>] [--report-md <path>]");
    eprintln!(
        "  report [--config <path>] [--native-log <path>] [--json-out <path>] [--md-out <path>]"
    );
    eprintln!("    methods: skeyAvailable, createCKey, setSecretKeys, getCkVersion, ckDiag, getEncryptedCKey, setLxData, cipherWithHashKey, cipherWithType");
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
        source,
        ref_id as u64,
        value
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
        let verbose_dispatch_hooks =
            std::env::var_os("PALMCHAT_TRACE_DISPATCH_VERBOSE").is_some();

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

fn parse_bool_like(text: &str) -> bool {
    let normalized = text.trim().to_ascii_lowercase();
    match normalized.as_str() {
        "" | "0" | "false" | "f" | "no" | "n" | "off" => false,
        "1" | "true" | "t" | "yes" | "y" | "on" => true,
        _ => true,
    }
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

fn string_from_id(vm: &mut DalvikVM64<()>, object_id: i64) -> String {
    match object_from_id_mut(vm, object_id) {
        Some(object) => string_from_object(object),
        None => String::new(),
    }
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
}
