use std::any::Any;
use std::cell::{RefCell, UnsafeCell};
use std::collections::{BTreeMap, HashMap};
use std::fs::{self, File};
use std::io::{BufWriter, Cursor, Read, Write};
use std::path::{Path, PathBuf};
use std::rc::Rc;

use anyhow::{anyhow, Context, Result};
use chrono::{SecondsFormat, Utc};
use emulator::android::dvm::class::DvmClass;
use emulator::android::dvm::class_resolver::ClassResolver;
use emulator::android::dvm::object::DvmObject;
use emulator::android::dvm::DalvikVM64;
use emulator::android::jni::{self, Jni, JniValue, MethodAcc, VaList};
use emulator::android::virtual_library::libc::SystemPropertyService;
use emulator::linux::file_system::{FileIO, StMode};
use emulator::linux::fs::linux_file::LinuxFileIO;
use emulator::linux::fs::ByteArrayFileIO;
use emulator::linux::structs::OFlag;
use emulator::{AndroidEmulator, BackendKind};
use serde::{Deserialize, Serialize};
use serde_json::{json, Value};
use url::{form_urlencoded, Url};

const PID: u32 = 2667;
const PPID: u32 = 2427;
const SIGNATURE_HEX: &str = "308201c13082012aa003020102020453b67db0300d06092a864886f70d01010505003024310d300b060355040b130468706272311330110603550403130a626f73737a686970696e3020170d3134303730343130313035365a180f32313133303631303130313035365a3024310d300b060355040b130468706272311330110603550403130a626f73737a686970696e30819f300d06092a864886f70d010101050003818d00308189028181008d38ee8f6b8d349c152b2dfbac13bc4ffbd6104a6c6eea8112d8d6e3bb15149cc8c79dc622fd6c2f654c87bf20ccfb3b15105c2e35807e004c14ca70ef94d29fbdd39c4f7382bc9e4c64f2a6f415022aa4745afb0a65714fee6e03cab70e946f7d8839b1fe00bdd6857fce138ede301616aafd855fc12abbd02010b76463c8f70203010001300d06092a864886f70d01010505000381810025a410b9fbc0e3139243cd9368fb755f5cd113454f18441373231bf75d4e20f3608e569a0dce32a26ec1e6a5105e61d87b753b903d5bb7eb4646676ab08247290c3eced459bc93a81ec0ff13c7676c3b4763b64414da2e93b433d7869f98bd70818347227c402e7af21da16825bd392e59e549fd3b35be5540e400607e6c211b";
const LBASE_PROBE_SECRET_FIELD: &str = "com/monch/lbase/LBase->probeSecretKey:Ljava/lang/String;";
const GT3_PROOF_SOURCE_DEFAULT_TAG: &str = "production-rnidbg";
const GT3_PROOF_TRUTH_FILE: &str = "gt3_proof_truth.json";
const GT3_PROOF_TRUTH_RESPONSE_FILE: &str = "gt3_proof_truth_response.json";
const GT3_PROOF_REQUIRED_FIELDS: [&str; 16] = [
    "gt",
    "bootstrap_challenge",
    "followup_challenge",
    "final_challenge",
    "client_type",
    "pt",
    "http_method",
    "request_url",
    "query_shape",
    "body_shape",
    "w",
    "w_length",
    "ua",
    "geetest_cookie_snapshot",
    "proof_source_tag",
    "ts_ms",
];
const GT3_PROOF_RESPONSE_REQUIRED_FIELDS: [&str; 4] = [
    "ajax_raw",
    "success_callback_payload",
    "validate",
    "sec_code",
];

#[derive(Clone, Debug, Deserialize)]
pub struct LabConfig {
    #[serde(rename = "package")]
    pub package_name: String,
    #[serde(rename = "apk_path")]
    pub apk_path: PathBuf,
    #[serde(rename = "so_path")]
    pub so_path: PathBuf,
    #[serde(rename = "asset_sign_encrypt_path")]
    pub asset_sign_encrypt_path: PathBuf,
    #[serde(rename = "purecalc_lookup_path")]
    pub purecalc_lookup_path: PathBuf,
    #[serde(rename = "trace_out_dir")]
    pub trace_out_dir: PathBuf,
    #[serde(rename = "android_api")]
    pub android_api: i32,
    pub backend: String,
}

impl LabConfig {
    pub fn load(path: impl AsRef<Path>) -> Result<Self> {
        let path = path.as_ref();
        let raw = fs::read_to_string(path)
            .with_context(|| format!("failed to read config: {}", path.display()))?;
        let mut config: LabConfig = serde_json::from_str(&raw)
            .with_context(|| format!("failed to parse config json: {}", path.display()))?;
        config.apk_path = normalize(config.apk_path);
        config.so_path = normalize(config.so_path);
        config.asset_sign_encrypt_path = normalize(config.asset_sign_encrypt_path);
        config.purecalc_lookup_path = normalize(config.purecalc_lookup_path);
        config.trace_out_dir = normalize(config.trace_out_dir);
        config.backend = normalize_backend_name(&config.backend)?.to_string();
        Ok(config)
    }

    pub fn with_backend_override(mut self, backend_override: Option<&str>) -> Result<Self> {
        if let Some(value) = backend_override {
            self.backend = normalize_backend_name(value)?.to_string();
        }
        Ok(self)
    }

    pub fn backend_kind(&self) -> Result<BackendKind> {
        BackendKind::parse(&self.backend)
            .ok_or_else(|| anyhow!("unsupported backend: {}", self.backend))
    }
}

pub fn normalize_backend_name(value: &str) -> Result<&'static str> {
    BackendKind::parse(value)
        .map(BackendKind::as_str)
        .ok_or_else(|| anyhow!("unsupported backend: {value}"))
}

pub fn compiled_backend_names() -> Vec<&'static str> {
    BackendKind::available_names()
}

#[derive(Default, Deserialize)]
struct LookupFile {
    #[serde(default)]
    sp_lookup: HashMap<String, ReplaySpSample>,
    #[serde(default)]
    sig_lookup: HashMap<String, ReplaySigSample>,
}

#[derive(Clone, Default, Deserialize)]
struct ReplaySpSample {
    #[serde(default)]
    plain: String,
    #[serde(default)]
    key: String,
    #[serde(default)]
    sp: String,
}

#[derive(Clone, Default, Deserialize)]
struct ReplaySigSample {
    #[serde(default)]
    data: String,
    #[serde(default)]
    key: String,
    #[serde(default)]
    sig: String,
}

#[derive(Clone, Debug, Serialize)]
struct TraceEvent {
    timestamp: String,
    tag: String,
    message: String,
}

struct Gt3ProofProbeOutput {
    status: String,
    missing_fields: Vec<String>,
    missing_response_fields: Vec<String>,
    truth_path: PathBuf,
    truth_response_path: PathBuf,
    truth: Value,
    truth_response: Value,
}

struct SharedState {
    config: LabConfig,
    jni_calls: BufWriter<File>,
    native_trace: BufWriter<File>,
    static_object_fields: HashMap<String, DvmObject>,
    jni_events: Vec<TraceEvent>,
    native_events: Vec<TraceEvent>,
}

impl SharedState {
    fn new(config: LabConfig) -> Result<Self> {
        fs::create_dir_all(&config.trace_out_dir).with_context(|| {
            format!(
                "failed to create trace dir: {}",
                config.trace_out_dir.display()
            )
        })?;
        let jni_calls = BufWriter::new(
            File::create(config.trace_out_dir.join("jni_calls.log")).with_context(|| {
                format!(
                    "failed to create jni_calls.log under {}",
                    config.trace_out_dir.display()
                )
            })?,
        );
        let native_trace = BufWriter::new(
            File::create(config.trace_out_dir.join("native_trace.log")).with_context(|| {
                format!(
                    "failed to create native_trace.log under {}",
                    config.trace_out_dir.display()
                )
            })?,
        );
        Ok(Self {
            config,
            jni_calls,
            native_trace,
            static_object_fields: HashMap::new(),
            jni_events: Vec::new(),
            native_events: Vec::new(),
        })
    }

    fn append_jni_call(&mut self, kind: &str, signature: &str) {
        let timestamp = iso_now();
        self.jni_events.push(TraceEvent {
            timestamp: timestamp.clone(),
            tag: kind.to_string(),
            message: signature.to_string(),
        });
        let _ = writeln!(self.jni_calls, "[{}] [{}] {}", timestamp, kind, signature);
        let _ = self.jni_calls.flush();
    }

    fn append_native_trace(&mut self, tag: &str, message: &str) {
        let timestamp = iso_now();
        self.native_events.push(TraceEvent {
            timestamp: timestamp.clone(),
            tag: tag.to_string(),
            message: message.to_string(),
        });
        let _ = writeln!(self.native_trace, "[{}] [{}] {}", timestamp, tag, message);
        let _ = self.native_trace.flush();
    }
}

pub struct BossYzwgLab {
    config: LabConfig,
    emulator: AndroidEmulator<'static, ()>,
    yzwg_class: Rc<DvmClass>,
    string_array_class: Rc<DvmClass>,
    module_base: u64,
    module_size: u64,
    shared: Rc<RefCell<SharedState>>,
}

impl BossYzwgLab {
    pub fn load(config_path: impl AsRef<Path>) -> Result<Self> {
        Self::load_with_backend(config_path, None)
    }

    pub fn load_probe_with_backend(
        config_path: impl AsRef<Path>,
        backend_override: Option<&str>,
    ) -> Result<Self> {
        let config = LabConfig::load(config_path)?.with_backend_override(backend_override)?;
        Self::from_config_with_mode(config, false)
    }

    pub fn load_with_backend(
        config_path: impl AsRef<Path>,
        backend_override: Option<&str>,
    ) -> Result<Self> {
        let config = LabConfig::load(config_path)?.with_backend_override(backend_override)?;
        Self::from_config_with_mode(config, true)
    }

    fn from_config(config: LabConfig) -> Result<Self> {
        Self::from_config_with_mode(config, true)
    }

    fn from_config_with_mode(config: LabConfig, load_native: bool) -> Result<Self> {
        validate_config(&config)?;

        let shared = Rc::new(RefCell::new(SharedState::new(config.clone())?));
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
        vm.set_jni(Box::new(BossYzwgJni::new(shared.clone())));

        let (_, context_class) = vm
            .resolve_class("android/content/Context")
            .ok_or_else(|| anyhow!("failed to resolve android/content/Context"))?;
        let (_, yzwg_class) = vm
            .resolve_class("com/twl/signer/YZWG")
            .ok_or_else(|| anyhow!("failed to resolve com/twl/signer/YZWG"))?;
        let (_, string_array_class) = vm
            .resolve_class("java/lang/String[]")
            .ok_or_else(|| anyhow!("failed to resolve java/lang/String[]"))?;

        let default_context = new_mut_data_object(
            context_class,
            ContextState {
                asset_root: config
                    .asset_sign_encrypt_path
                    .parent()
                    .ok_or_else(|| anyhow!("asset_sign_encrypt_path has no parent"))?
                    .to_path_buf(),
                sign_encrypt: config.asset_sign_encrypt_path.clone(),
            },
        );
        shared.borrow_mut().static_object_fields.insert(
            "com/twl/signer/YZWG->gContext:Landroid/content/Context;".to_string(),
            default_context.clone(),
        );

        let (module_base, module_size) = if load_native {
            let module = vm
                .load_library(
                    emulator.clone(),
                    config.so_path.to_string_lossy().as_ref(),
                    true,
                )
                .with_context(|| format!("failed to load library: {}", config.so_path.display()))?;
            let module = unsafe { &*module.get() };
            let module_base = module.base;
            let module_size = module.size as u64;

            shared.borrow_mut().append_native_trace(
                "init",
                &format!(
                    "module_base=0x{:x}, size=0x{:x}, requested_backend={}, active_backend={}",
                    module_base,
                    module_size,
                    config.backend,
                    emulator.backend.name()
                ),
            );

            vm.call_jni_onload(emulator.clone(), module)
                .context("failed to call JNI_OnLoad")?;
            let registered = vm.list_method_signatures(yzwg_class.id);
            shared.borrow_mut().append_native_trace(
                "register_natives",
                &format!("class={}, methods={:?}", yzwg_class.name, registered),
            );
            (module_base, module_size)
        } else {
            shared.borrow_mut().append_native_trace(
                "init",
                &format!(
                    "probe_only=true, requested_backend={}, active_backend={}",
                    config.backend,
                    emulator.backend.name()
                ),
            );
            (0, 0)
        };

        let lab = Self {
            config,
            emulator,
            yzwg_class,
            string_array_class,
            module_base,
            module_size,
            shared,
        };
        if load_native {
            lab.initialize_with_context(default_context);
        }
        Ok(lab)
    }

    pub fn config(&self) -> &LabConfig {
        &self.config
    }

    pub fn active_backend(&self) -> &'static str {
        self.emulator.backend.name()
    }

    pub fn run_smoke(&mut self) -> Result<Value> {
        let signature = self.call_native_signature(b"/api/health-check", "")?;
        Ok(json!({
            "status": "ok",
            "timestamp": iso_now(),
            "package": self.config.package_name,
            "requested_backend": self.config.backend,
            "active_backend": self.active_backend(),
            "signature_non_empty": !signature.is_empty(),
            "signature_preview": truncate(&signature, 40),
            "module_base": format!("0x{:x}", self.module_base),
            "module_size": format!("0x{:x}", self.module_size),
        }))
    }

    pub fn run_trace(&mut self, opts: &HashMap<String, String>) -> Result<Value> {
        let filter = opts
            .get("--method-filter")
            .map(String::as_str)
            .unwrap_or("all");
        let lookup = self.load_lookup(opts.get("--lookup").map(PathBuf::from))?;
        let mut results = Vec::new();

        if matches_filter(filter, "nativeEncodeRequest") {
            if let Some(sample) = lookup.sp_lookup.values().next() {
                let output =
                    self.call_native_encode_request(sample.plain.as_bytes(), &sample.key)?;
                let row = json!({
                    "method": "nativeEncodeRequest",
                    "input_utf8": sample.plain,
                    "input_hex": to_hex(sample.plain.as_bytes()),
                    "key": sample.key,
                    "output": output,
                });
                self.log_invoke(&row);
                results.push(row);
            }
        }

        if matches_filter(filter, "nativeEncodeRequestBody") {
            if let Some(sample) = lookup.sp_lookup.values().next() {
                let output =
                    self.call_native_encode_request_body(sample.plain.as_bytes(), &sample.key)?;
                let row = json!({
                    "method": "nativeEncodeRequestBody",
                    "input_utf8": sample.plain,
                    "input_hex": to_hex(sample.plain.as_bytes()),
                    "key": sample.key,
                    "output_hex": to_hex(&output),
                });
                self.log_invoke(&row);
                results.push(row);
            }
        }

        if matches_filter(filter, "nativeDecodeRequestBody") {
            if let Some(sample) = lookup.sp_lookup.values().next() {
                let encoded =
                    self.call_native_encode_request_body(sample.plain.as_bytes(), &sample.key)?;
                let decoded = self.call_native_decode_request_body(&encoded, &sample.key)?;
                let row = json!({
                    "method": "nativeDecodeRequestBody",
                    "input_hex": to_hex(&encoded),
                    "key": sample.key,
                    "output_utf8": try_utf8(&decoded),
                    "output_hex": to_hex(&decoded),
                });
                self.log_invoke(&row);
                results.push(row);
            }
        }

        if matches_filter(filter, "nativeDecodeContent") {
            if let Some(sample) = lookup.sp_lookup.values().next() {
                let decoded = self.call_native_decode_content(&sample.sp, &sample.key)?;
                let row = json!({
                    "method": "nativeDecodeContent",
                    "input_utf8": sample.sp,
                    "input_hex": to_hex(sample.sp.as_bytes()),
                    "key": sample.key,
                    "output_utf8": try_utf8(&decoded),
                    "output_hex": to_hex(&decoded),
                });
                self.log_invoke(&row);
                results.push(row);
            }
        }

        if matches_filter(filter, "nativeSignature") {
            if let Some(sample) = lookup.sig_lookup.values().next() {
                let output = self.call_native_signature(sample.data.as_bytes(), &sample.key)?;
                let row = json!({
                    "method": "nativeSignature",
                    "input_utf8": sample.data,
                    "input_hex": to_hex(sample.data.as_bytes()),
                    "key": sample.key,
                    "output": output,
                });
                self.log_invoke(&row);
                results.push(row);
            }
        }

        if matches_filter(filter, "nativeCalculateCRC32") {
            if let Some(sample) = lookup.sp_lookup.values().next() {
                let output = self.call_native_calculate_crc32(sample.plain.as_bytes())?;
                let row = json!({
                    "method": "nativeCalculateCRC32",
                    "input_utf8": sample.plain,
                    "input_hex": to_hex(sample.plain.as_bytes()),
                    "output": output,
                });
                self.log_invoke(&row);
                results.push(row);
            }
        }

        let invoke_path = self.config.trace_out_dir.join("invoke_result.json");
        write_json(&invoke_path, &Value::Array(results.clone()))?;
        let summary = self.build_trace_summary(&results);
        let summary_path = self.config.trace_out_dir.join("trace_summary.json");
        write_json(&summary_path, &summary)?;

        Ok(json!({
            "status": "ok",
            "invoke_result": invoke_path,
            "trace_summary": summary_path,
            "jni_calls": self.config.trace_out_dir.join("jni_calls.log"),
            "native_trace": self.config.trace_out_dir.join("native_trace.log"),
            "count": results.len(),
        }))
    }

    pub fn run_invoke(&mut self, opts: &HashMap<String, String>) -> Result<Value> {
        if opts
            .get("--dump-rc4")
            .map(|value| value.eq_ignore_ascii_case("true"))
            .unwrap_or(false)
        {
            self.shared.borrow_mut().append_native_trace(
                "rc4_probe",
                "rnidbg build does not expose runtime breakpoints yet; dump-rc4 is accepted but currently informational only",
            );
        }

        let method = required_option(opts, "--method")?;
        let arg1 = required_option(opts, "--arg1")?;
        let arg2 = opts.get("--arg2").cloned().unwrap_or_default();
        let arg3 = opts.get("--arg3").cloned().unwrap_or_default();
        let arg4 = opts.get("--arg4").cloned().unwrap_or_default();
        let arg5 = opts.get("--arg5").cloned().unwrap_or_default();

        let output = match method.as_str() {
            "nativeEncodeRequest" => {
                let input = parse_hex_or_utf8(&arg1)?;
                json!({
                    "method": method,
                    "arg1_utf8": try_utf8(&input),
                    "arg1_hex": to_hex(&input),
                    "arg2": arg2,
                    "output": self.call_native_encode_request(&input, &arg2)?,
                })
            }
            "nativeEncodeRequestBody" => {
                let input = parse_hex_or_utf8(&arg1)?;
                let encoded = self.call_native_encode_request_body(&input, &arg2)?;
                json!({
                    "method": method,
                    "arg1_utf8": try_utf8(&input),
                    "arg1_hex": to_hex(&input),
                    "arg2": arg2,
                    "output_hex": to_hex(&encoded),
                })
            }
            "nativeDecodeRequestBody" => {
                let input = parse_hex_or_utf8(&arg1)?;
                let decoded = self.call_native_decode_request_body(&input, &arg2)?;
                json!({
                    "method": method,
                    "arg1_utf8": try_utf8(&input),
                    "arg1_hex": to_hex(&input),
                    "arg2": arg2,
                    "output_utf8": try_utf8(&decoded),
                    "output_hex": to_hex(&decoded),
                })
            }
            "nativeDecodeContent" => {
                let content = if let Some(stripped) = arg1.strip_prefix("hex:") {
                    String::from_utf8(parse_hex(&format!("hex:{stripped}"))?)
                        .context("nativeDecodeContent hex input is not utf-8")?
                } else {
                    arg1
                };
                let decoded = self.call_native_decode_content(&content, &arg2)?;
                json!({
                    "method": method,
                    "arg1_utf8": content,
                    "arg1_hex": to_hex(content.as_bytes()),
                    "arg2": arg2,
                    "output_utf8": try_utf8(&decoded),
                    "output_hex": to_hex(&decoded),
                })
            }
            "nativeDecodeContentBytes" => {
                let input = parse_hex_or_utf8(&arg1)?;
                let encoding = arg3
                    .parse::<i32>()
                    .with_context(|| format!("invalid --arg3 encoding: {arg3}"))?;
                let encryption = arg4
                    .parse::<i32>()
                    .with_context(|| format!("invalid --arg4 encryption: {arg4}"))?;
                let compress = arg5
                    .parse::<i32>()
                    .with_context(|| format!("invalid --arg5 compress: {arg5}"))?;
                let decoded = self.call_native_decode_content_bytes(
                    &input, &arg2, encoding, encryption, compress,
                )?;
                json!({
                    "method": method,
                    "arg1_hex": to_hex(&input),
                    "arg2": arg2,
                    "arg3": encoding,
                    "arg4": encryption,
                    "arg5": compress,
                    "output_utf8": try_utf8(&decoded),
                    "output_hex": to_hex(&decoded),
                })
            }
            "nativeSignature" => {
                let input = parse_hex_or_utf8(&arg1)?;
                json!({
                    "method": method,
                    "arg1_utf8": try_utf8(&input),
                    "arg1_hex": to_hex(&input),
                    "arg2": arg2,
                    "output": self.call_native_signature(&input, &arg2)?,
                })
            }
            "nativeCalculateCRC32" => {
                let input = parse_hex_or_utf8(&arg1)?;
                json!({
                    "method": method,
                    "arg1_utf8": try_utf8(&input),
                    "arg1_hex": to_hex(&input),
                    "output": self.call_native_calculate_crc32(&input)?,
                })
            }
            _ => return Err(anyhow!("unsupported method: {method}")),
        };

        Ok(output)
    }

    pub fn run_java_probe(&mut self, opts: &HashMap<String, String>) -> Result<Value> {
        let probe_mode = opts
            .get("--probe")
            .map(|value| value.to_ascii_lowercase())
            .unwrap_or_else(|| "both".to_string());

        let probe_secret_key = match probe_mode.as_str() {
            "both" | "all" | "secret-key" | "secret_key" | "lbase" => true,
            "dialog" | "on-dialog-result" | "on_dialog_result" => false,
            other => return Err(anyhow!("unsupported --probe mode: {other}")),
        };
        let probe_dialog_result = match probe_mode.as_str() {
            "both" | "all" | "dialog" | "on-dialog-result" | "on_dialog_result" => true,
            "secret-key" | "secret_key" | "lbase" => false,
            other => return Err(anyhow!("unsupported --probe mode: {other}")),
        };

        let mut output = serde_json::Map::new();
        output.insert("status".to_string(), json!("ok"));
        output.insert("mode".to_string(), json!("java_probe"));
        output.insert("probe".to_string(), json!(probe_mode));

        if probe_secret_key {
            let (secret_key, key_source) = if let Some(value) = opts.get("--secret-key") {
                (value.clone(), "cli:--secret-key")
            } else if let Ok(value) = std::env::var("BOSS_SECRET_KEY") {
                (value, "env:BOSS_SECRET_KEY")
            } else {
                (String::new(), "default-empty")
            };
            self.shared.borrow_mut().static_object_fields.insert(
                LBASE_PROBE_SECRET_FIELD.to_string(),
                DvmObject::String(secret_key.clone()),
            );
            self.shared.borrow_mut().append_native_trace(
                "java_probe",
                &format!(
                    "com/monch/lbase/LBase.getSecretKey() source={}, len={}",
                    key_source,
                    secret_key.len()
                ),
            );
            output.insert(
                "secret_key_probe".to_string(),
                json!({
                    "class": "com/monch/lbase/LBase",
                    "method": "getSecretKey()Ljava/lang/String;",
                    "source": key_source,
                    "value": secret_key,
                }),
            );
        }

        if probe_dialog_result {
            let dialog_raw = if let Some(path) = opts.get("--dialog-result-file") {
                fs::read_to_string(path)
                    .with_context(|| format!("failed to read --dialog-result-file: {path}"))?
            } else {
                opts.get("--dialog-result-json")
                    .cloned()
                    .unwrap_or_else(default_dialog_result_json)
            };
            let captcha_type = opts
                .get("--captcha-type")
                .map(|value| value.parse::<i32>())
                .transpose()
                .context("invalid --captcha-type")?
                .unwrap_or(1);

            let probe = self.synthetic_probe_dialog_result(captcha_type, &dialog_raw)?;
            output.insert("on_dialog_result_probe".to_string(), probe);
        }

        let gt3_proof_probe = self.capture_gt3_proof_truth(opts)?;
        output.insert(
            "gt3_proof_truth_probe".to_string(),
            json!({
                "status": gt3_proof_probe.status,
                "missing_fields": gt3_proof_probe.missing_fields,
                "missing_response_fields": gt3_proof_probe.missing_response_fields,
                "gt3_proof_truth_path": gt3_proof_probe.truth_path,
                "gt3_proof_truth_response_path": gt3_proof_probe.truth_response_path,
            }),
        );
        output.insert("gt3_proof_truth".to_string(), gt3_proof_probe.truth);
        output.insert(
            "gt3_proof_truth_response".to_string(),
            gt3_proof_probe.truth_response,
        );

        Ok(Value::Object(output))
    }

    pub fn run_replay(&mut self, opts: &HashMap<String, String>) -> Result<Value> {
        let mode = opts
            .get("--mode")
            .cloned()
            .unwrap_or_else(|| "both".to_string());
        let limit = opts
            .get("--limit")
            .map(|value| value.parse::<usize>())
            .transpose()
            .context("invalid --limit")?
            .unwrap_or(20);
        let lookup = self.load_lookup(opts.get("--lookup").map(PathBuf::from))?;

        let started = std::time::Instant::now();
        let mut results = Vec::new();
        let mut failures = Vec::new();

        if mode.eq_ignore_ascii_case("both") || mode.eq_ignore_ascii_case("sp") {
            for sample in lookup.sp_lookup.values().take(limit) {
                match self.call_native_encode_request(sample.plain.as_bytes(), &sample.key) {
                    Ok(actual) => {
                        let matched = actual == sample.sp;
                        results.push(json!({
                            "kind": "sp",
                            "expected": sample.sp,
                            "actual": actual,
                            "match": matched,
                        }));
                        if !matched {
                            failures.push(json!({
                                "kind": "sp",
                                "plain": sample.plain,
                                "key": sample.key,
                                "expected": sample.sp,
                                "actual": actual,
                            }));
                        }
                    }
                    Err(err) => failures.push(json!({
                        "kind": "sp",
                        "plain": sample.plain,
                        "key": sample.key,
                        "expected": sample.sp,
                        "error": format!("{err:#}"),
                    })),
                }
            }
        }

        if mode.eq_ignore_ascii_case("both") || mode.eq_ignore_ascii_case("sig") {
            for sample in lookup.sig_lookup.values().take(limit) {
                match self.call_native_signature(sample.data.as_bytes(), &sample.key) {
                    Ok(actual) => {
                        let matched = actual == sample.sig;
                        results.push(json!({
                            "kind": "sig",
                            "expected": sample.sig,
                            "actual": actual,
                            "match": matched,
                        }));
                        if !matched {
                            failures.push(json!({
                                "kind": "sig",
                                "data": sample.data,
                                "key": sample.key,
                                "expected": sample.sig,
                                "actual": actual,
                            }));
                        }
                    }
                    Err(err) => failures.push(json!({
                        "kind": "sig",
                        "data": sample.data,
                        "key": sample.key,
                        "expected": sample.sig,
                        "error": format!("{err:#}"),
                    })),
                }
            }
        }

        let success = results
            .iter()
            .filter(|entry| entry.get("match") == Some(&Value::Bool(true)))
            .count();
        let total = results.len();
        let success_rate = if total == 0 {
            0.0
        } else {
            success as f64 / total as f64
        };

        let report = json!({
            "status": "ok",
            "mode": mode,
            "limit": limit,
            "total": total,
            "success": success,
            "failure": failures.len(),
            "success_rate": success_rate,
            "duration_ms": started.elapsed().as_millis(),
            "results": results,
        });

        let report_path = self.config.trace_out_dir.join("replay_report.json");
        let failures_path = self.config.trace_out_dir.join("replay_failures.json");
        write_json(&report_path, &report)?;
        write_json(&failures_path, &Value::Array(failures))?;

        Ok(json!({
            "status": "ok",
            "report": report_path,
            "failures": failures_path,
            "success_rate": success_rate,
            "total": total,
        }))
    }

    fn synthetic_probe_dialog_result(
        &mut self,
        captcha_type: i32,
        dialog_raw: &str,
    ) -> Result<Value> {
        let emulator = self.emulator.clone();
        let vm = emulator.get_dalvik_vm();
        let (_, provider_class) = vm
            .resolve_class("p50/d")
            .ok_or_else(|| anyhow!("failed to resolve p50/d"))?;
        let (_, callback_class) = vm
            .resolve_class("p50/c")
            .ok_or_else(|| anyhow!("failed to resolve p50/c"))?;
        let (_, listener_class) = vm
            .resolve_class("p50/d$a")
            .ok_or_else(|| anyhow!("failed to resolve p50/d$a"))?;

        let callback = new_mut_data_object(
            callback_class,
            ProbeCaptchaCallbackState {
                captcha_info: String::new(),
            },
        );
        let provider = new_mut_data_object(
            provider_class,
            ProbeDialogProviderState {
                captcha_type,
                callback: callback.clone(),
            },
        );
        let mut listener = new_mut_data_object(
            listener_class,
            ProbeDialogListenerState {
                owner: provider.clone(),
            },
        );
        let captcha_info = synthetic_dialog_result_invoke(&mut listener, dialog_raw)?;
        let callback_value = data_ref::<ProbeCaptchaCallbackState>(&callback)
            .map(|state| state.captcha_info.clone())
            .unwrap_or_default();
        let callback_value = if callback_value.is_empty() {
            captcha_info.clone()
        } else {
            callback_value
        };

        self.shared.borrow_mut().append_native_trace(
            "java_probe",
            &format!(
                "p50/d$a.onDialogResult captcha_type={}, captcha_info_len={}",
                captcha_type,
                callback_value.len()
            ),
        );

        Ok(json!({
            "class": "p50/d$a",
            "method": "onDialogResult(Ljava/lang/String;)V",
            "captcha_type": captcha_type,
            "input_dialog_result": serde_json::from_str::<Value>(dialog_raw).unwrap_or(Value::String(dialog_raw.to_string())),
            "captcha_info_raw": callback_value,
            "captcha_info": serde_json::from_str::<Value>(&captcha_info).unwrap_or(Value::String(captcha_info)),
            "field_write": "p50/c->f130761b:Ljava/lang/String;",
        }))
    }

    fn capture_gt3_proof_truth(
        &mut self,
        opts: &HashMap<String, String>,
    ) -> Result<Gt3ProofProbeOutput> {
        let request_input = load_optional_json_arg(
            opts,
            &[
                "--gt3-proof-truth-json",
                "--gt3-proof-request-json",
                "--gt3-request-json",
                "--geetest-request-json",
            ],
            &[
                "--gt3-proof-truth-file",
                "--gt3-proof-request-file",
                "--gt3-request-file",
                "--geetest-request-file",
            ],
        )?;
        let response_input = load_optional_json_arg(
            opts,
            &[
                "--gt3-proof-response-json",
                "--gt3-response-json",
                "--geetest-response-json",
            ],
            &[
                "--gt3-proof-response-file",
                "--gt3-response-file",
                "--geetest-response-file",
            ],
        )?;

        let mut truth = build_gt3_proof_truth_value(opts, request_input.as_ref());
        let mut truth_response = build_gt3_proof_truth_response_value(response_input.as_ref());

        if let Some(value) = truth_response
            .get("success_callback_payload")
            .and_then(|entry| find_nested_string(entry, &["geetest_challenge", "challenge"]))
            .filter(|value| !value.is_empty())
        {
            set_if_missing_or_empty(&mut truth, "final_challenge", Value::String(value));
        }

        if let Some(value) = truth
            .get("final_challenge")
            .and_then(Value::as_str)
            .filter(|value| !value.is_empty())
        {
            set_if_missing_or_empty(
                &mut truth_response,
                "challenge",
                Value::String(value.to_string()),
            );
        }

        let missing_fields = missing_required_fields(&truth, &GT3_PROOF_REQUIRED_FIELDS);
        let missing_response_fields =
            missing_required_fields(&truth_response, &GT3_PROOF_RESPONSE_REQUIRED_FIELDS);
        let status = if missing_fields.is_empty() && missing_response_fields.is_empty() {
            "ok"
        } else {
            "partial"
        };

        let truth_path = self.config.trace_out_dir.join(GT3_PROOF_TRUTH_FILE);
        let truth_response_path = self
            .config
            .trace_out_dir
            .join(GT3_PROOF_TRUTH_RESPONSE_FILE);
        write_json(&truth_path, &truth)?;
        write_json(&truth_response_path, &truth_response)?;

        self.shared.borrow_mut().append_native_trace(
            "gt3_proof_truth",
            &format!(
                "status={}, missing_fields={:?}, missing_response_fields={:?}, truth_path={}, truth_response_path={}",
                status,
                missing_fields,
                missing_response_fields,
                truth_path.display(),
                truth_response_path.display()
            ),
        );

        Ok(Gt3ProofProbeOutput {
            status: status.to_string(),
            missing_fields,
            missing_response_fields,
            truth_path,
            truth_response_path,
            truth,
            truth_response,
        })
    }

    pub fn call_native_encode_request(&mut self, data: &[u8], key: &str) -> Result<String> {
        let result = self.call_static(
            "nativeEncodeRequest",
            "([BLjava/lang/String;)Ljava/lang/String;",
            vec![data.to_vec().into(), key.to_string().into()],
        )?;
        let output = jni_value_to_string(result)?;
        self.shared.borrow_mut().append_native_trace(
            "nativeEncodeRequest",
            &format!("arg_hex={}, key={}, out={}", to_hex(data), key, output),
        );
        Ok(output)
    }

    pub fn call_native_encode_request_body(&mut self, data: &[u8], key: &str) -> Result<Vec<u8>> {
        let result = self.call_static(
            "nativeEncodeRequestBody",
            "([BLjava/lang/String;)[B",
            vec![data.to_vec().into(), key.to_string().into()],
        )?;
        let output = jni_value_to_bytes(result)?;
        self.shared.borrow_mut().append_native_trace(
            "nativeEncodeRequestBody",
            &format!(
                "arg_hex={}, key={}, out_hex={}",
                to_hex(data),
                key,
                to_hex(&output)
            ),
        );
        Ok(output)
    }

    pub fn call_native_decode_request_body(&mut self, data: &[u8], key: &str) -> Result<Vec<u8>> {
        let result = self.call_static(
            "nativeDecodeRequestBody",
            "([BLjava/lang/String;)[B",
            vec![data.to_vec().into(), key.to_string().into()],
        )?;
        let output = jni_value_to_bytes(result)?;
        self.shared.borrow_mut().append_native_trace(
            "nativeDecodeRequestBody",
            &format!(
                "arg_hex={}, key={}, out_hex={}",
                to_hex(data),
                key,
                to_hex(&output)
            ),
        );
        Ok(output)
    }

    pub fn call_native_decode_content(&mut self, content: &str, key: &str) -> Result<Vec<u8>> {
        let result = self.call_static(
            "nativeDecodeContent",
            "(Ljava/lang/String;Ljava/lang/String;)[B",
            vec![content.to_string().into(), key.to_string().into()],
        )?;
        let output = jni_value_to_bytes(result)?;
        self.shared.borrow_mut().append_native_trace(
            "nativeDecodeContent",
            &format!("arg={}, key={}, out_hex={}", content, key, to_hex(&output)),
        );
        Ok(output)
    }

    pub fn call_native_decode_content_bytes(
        &mut self,
        content: &[u8],
        key: &str,
        encoding: i32,
        encryption: i32,
        compress: i32,
    ) -> Result<Vec<u8>> {
        let result = self.call_static(
            "nativeDecodeContent",
            "([BLjava/lang/String;III)[B",
            vec![
                content.to_vec().into(),
                key.to_string().into(),
                encoding.into(),
                encryption.into(),
                compress.into(),
            ],
        )?;
        let output = jni_value_to_bytes(result)?;
        self.shared.borrow_mut().append_native_trace(
            "nativeDecodeContentBytes",
            &format!(
                "arg_hex={}, key={}, encoding={}, encryption={}, compress={}, out_hex={}",
                to_hex(content),
                key,
                encoding,
                encryption,
                compress,
                to_hex(&output)
            ),
        );
        Ok(output)
    }

    pub fn call_native_signature(&mut self, data: &[u8], key: &str) -> Result<String> {
        let result = self.call_static(
            "nativeSignature",
            "([BLjava/lang/String;)[B",
            vec![data.to_vec().into(), key.to_string().into()],
        )?;
        let output = try_utf8(&jni_value_to_bytes(result)?);
        self.shared.borrow_mut().append_native_trace(
            "nativeSignature",
            &format!("arg_hex={}, key={}, out={}", to_hex(data), key, output),
        );
        Ok(output)
    }

    pub fn call_native_calculate_crc32(&mut self, data: &[u8]) -> Result<String> {
        let result = self.call_static(
            "nativeCalculateCRC32",
            "([B)Ljava/lang/String;",
            vec![data.to_vec().into()],
        )?;
        let output = jni_value_to_string(result)?;
        self.shared.borrow_mut().append_native_trace(
            "nativeCalculateCRC32",
            &format!("arg_hex={}, out={}", to_hex(data), output),
        );
        Ok(output)
    }

    fn call_static(
        &self,
        method_name: &str,
        signature: &str,
        args: Vec<JniValue>,
    ) -> Result<JniValue> {
        let emulator = self.emulator.clone();
        let vm = emulator.get_dalvik_vm();
        if vm
            .find_method(self.yzwg_class.id, method_name, signature)
            .is_none()
        {
            let available = vm.list_method_signatures(self.yzwg_class.id);
            return Err(anyhow!(
                "native method not registered: {}{} on {}, available={:?}",
                method_name,
                signature,
                self.yzwg_class.name,
                available
            ));
        }
        Ok(self
            .yzwg_class
            .call_static_method(&emulator, vm, method_name, signature, args))
    }

    fn initialize_with_context(&self, context: DvmObject) {
        match self.call_static(
            "initialize",
            "(Landroid/content/Context;)V",
            vec![context.into()],
        ) {
            Ok(_) => self.shared.borrow_mut().append_native_trace(
                "initialize",
                &format!(
                    "context injected with asset root: {}",
                    self.config.asset_sign_encrypt_path.display()
                ),
            ),
            Err(err) => self
                .shared
                .borrow_mut()
                .append_native_trace("initialize_error", &format!("{err:#}")),
        }
    }

    fn load_lookup(&self, override_path: Option<PathBuf>) -> Result<LookupFile> {
        let path = override_path.unwrap_or_else(|| self.config.purecalc_lookup_path.clone());
        let raw = fs::read_to_string(&path)
            .with_context(|| format!("failed to read lookup file: {}", path.display()))?;
        serde_json::from_str(&raw)
            .with_context(|| format!("failed to parse lookup json: {}", path.display()))
    }

    fn log_invoke(&self, row: &Value) {
        self.shared
            .borrow_mut()
            .append_native_trace("invoke", &row.to_string());
    }

    fn build_trace_summary(&self, results: &[Value]) -> Value {
        let emulator = self.emulator.clone();
        let vm = emulator.get_dalvik_vm();
        let registered_native_methods = vm.list_method_signatures(self.yzwg_class.id);
        let shared = self.shared.borrow();
        let jni_tail = tail_events(&shared.jni_events, 12);
        let native_tail = tail_events(&shared.native_events, 12);
        let observed_methods = results
            .iter()
            .filter_map(|entry| entry.get("method").and_then(Value::as_str))
            .map(ToOwned::to_owned)
            .collect::<Vec<_>>();

        json!({
            "status": "ok",
            "timestamp": iso_now(),
            "package": self.config.package_name,
            "requested_backend": self.config.backend,
            "active_backend": self.active_backend(),
            "module_base": format!("0x{:x}", self.module_base),
            "module_size": format!("0x{:x}", self.module_size),
            "registered_native_methods": registered_native_methods,
            "observed_methods": observed_methods,
            "invoke_results_count": results.len(),
            "jni": {
                "event_count": shared.jni_events.len(),
                "by_tag": count_events_by_tag(&shared.jni_events),
                "tail": jni_tail,
            },
            "native": {
                "event_count": shared.native_events.len(),
                "by_tag": count_events_by_tag(&shared.native_events),
                "tail": native_tail,
            },
            "artifacts": {
                "trace_dir": self.config.trace_out_dir.clone(),
                "jni_calls": self.config.trace_out_dir.join("jni_calls.log"),
                "native_trace": self.config.trace_out_dir.join("native_trace.log"),
                "invoke_result": self.config.trace_out_dir.join("invoke_result.json"),
            }
        })
    }
}

impl Drop for BossYzwgLab {
    fn drop(&mut self) {
        self.emulator.destroy();
    }
}

struct BossYzwgJni {
    shared: Rc<RefCell<SharedState>>,
}

impl BossYzwgJni {
    fn new(shared: Rc<RefCell<SharedState>>) -> Self {
        Self { shared }
    }

    fn method_signature(class: &DvmClass, method: &str, signature: &str) -> String {
        format!("{}->{}{}", class.name, method, signature)
    }

    fn field_signature(class: &DvmClass, field: &str, signature: &str) -> String {
        format!("{}->{}:{}", class.name, field, signature)
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

impl Jni<()> for BossYzwgJni {
    fn resolve_method(
        &mut self,
        _vm: &mut DalvikVM64<()>,
        class: &Rc<DvmClass>,
        name: &str,
        signature: &str,
        is_static: bool,
    ) -> bool {
        let kind = if is_static {
            "RESOLVE_STATIC"
        } else {
            "RESOLVE_METHOD"
        };
        self.shared
            .borrow_mut()
            .append_jni_call(kind, &Self::method_signature(class, name, signature));
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
        let kind = if is_static {
            "RESOLVE_STATIC_FIELD"
        } else {
            "RESOLVE_FIELD"
        };
        self.shared
            .borrow_mut()
            .append_jni_call(kind, &Self::field_signature(class, name, signature));
        true
    }

    fn call_method_v(
        &mut self,
        vm: &mut DalvikVM64<()>,
        acc: MethodAcc,
        class: &Rc<DvmClass>,
        method: &emulator::android::dvm::member::DvmMethod,
        instance: Option<&mut DvmObject>,
        args: &mut VaList<()>,
    ) -> JniValue {
        let signature = Self::method_signature(class, &method.name, &method.signature);
        self.shared.borrow_mut().append_jni_call("CALL", &signature);

        if acc.contains(MethodAcc::CONSTRUCTOR) {
            match signature.as_str() {
                "java/lang/String-><init>([BLjava/lang/String;)V" => {
                    let bytes = args.get::<Vec<u8>>(vm);
                    let _charset = args.get::<String>(vm);
                    return String::from_utf8_lossy(&bytes).to_string().into();
                }
                "java/lang/String-><init>([B)V" => {
                    let bytes = args.get::<Vec<u8>>(vm);
                    return String::from_utf8_lossy(&bytes).to_string().into();
                }
                "org/json/JSONObject-><init>()V" => {
                    return new_mut_data_object(class.clone(), JsonObjectState::default()).into();
                }
                "org/json/JSONObject-><init>(Ljava/lang/String;)V" => {
                    let raw = args.get::<String>(vm);
                    return new_mut_data_object(class.clone(), JsonObjectState::from_str(&raw))
                        .into();
                }
                _ => {
                    return DvmObject::new_simple(class.clone()).into();
                }
            }
        }

        match signature.as_str() {
            "android/content/Context->getApplicationContext()Landroid/content/Context;" => {
                return instance.cloned().unwrap_or(JniValue::Null.into()).into();
            }
            "android/content/Context->getPackageName()Ljava/lang/String;" => {
                return self.shared.borrow().config.package_name.clone().into();
            }
            "android/content/Context->getPackageManager()Landroid/content/pm/PackageManager;" => {
                let (_, package_manager_class) = vm.resolve_class("android/content/pm/PackageManager")
                    .expect("android/content/pm/PackageManager missing from class resolver");
                return new_data_object(
                    package_manager_class,
                    PackageManagerState {
                        package_name: self.shared.borrow().config.package_name.clone(),
                    },
                ).into();
            }
            "android/content/Context->getAssets()Landroid/content/res/AssetManager;" => {
                let (_, asset_manager_class) = vm.resolve_class("android/content/res/AssetManager")
                    .expect("android/content/res/AssetManager missing from class resolver");
                let Some(instance) = instance else {
                    return JniValue::Null;
                };
                if let Some(ctx) = data_ref::<ContextState>(instance) {
                    return new_data_object(
                        asset_manager_class,
                        AssetManagerState {
                            asset_root: ctx.asset_root.clone(),
                            sign_encrypt: ctx.sign_encrypt.clone(),
                        },
                    ).into();
                }
            }
            "android/content/pm/PackageManager->getPackagesForUid(I)[Ljava/lang/String;" => {
                let package_name = if let Some(instance) = instance {
                    data_ref::<PackageManagerState>(instance)
                        .map(|state| state.package_name.clone())
                        .unwrap_or_else(|| self.shared.borrow().config.package_name.clone())
                } else {
                    self.shared.borrow().config.package_name.clone()
                };
                let (_, string_array_class) = vm.resolve_class("java/lang/String[]")
                    .expect("java/lang/String[] missing from class resolver");
                return DvmObject::ObjectArray(string_array_class, vec![Some(DvmObject::String(package_name))]).into();
            }
            "android/content/pm/PackageManager->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;" => {
                let requested_package = args.get::<String>(vm);
                let flags = args.get::<i32>(vm);
                let package_name = if let Some(instance) = instance {
                    data_ref::<PackageManagerState>(instance)
                        .map(|state| state.package_name.clone())
                        .unwrap_or_else(|| self.shared.borrow().config.package_name.clone())
                } else {
                    self.shared.borrow().config.package_name.clone()
                };
                if !requested_package.is_empty() && requested_package != package_name {
                    self.shared.borrow_mut().append_native_trace(
                        "jni_warn",
                        &format!(
                            "PackageManager.getPackageInfo requested unexpected package: requested={}, configured={}, flags={}",
                            requested_package, package_name, flags
                        ),
                    );
                }
                let (_, package_info_class) = vm.resolve_class("android/content/pm/PackageInfo")
                    .expect("android/content/pm/PackageInfo missing from class resolver");
                let (_, signature_class) = vm.resolve_class("android/content/pm/Signature")
                    .expect("android/content/pm/Signature missing from class resolver");
                let (_, signature_array_class) = vm.resolve_class("android/content/pm/Signature[]")
                    .expect("android/content/pm/Signature[] missing from class resolver");
                let signatures = DvmObject::ObjectArray(
                    signature_array_class,
                    vec![Some(new_data_object(signature_class, SignatureState))],
                );
                return new_data_object(package_info_class, PackageInfoState { signatures }).into();
            }
            "android/content/pm/Signature->toCharsString()Ljava/lang/String;" => {
                return SIGNATURE_HEX.to_string().into();
            }
            "android/content/res/AssetManager->open(Ljava/lang/String;)Ljava/io/InputStream;" => {
                let (_, input_stream_class) = vm.resolve_class("java/io/InputStream")
                    .expect("java/io/InputStream missing from class resolver");
                let name = args.get::<String>(vm);
                let Some(instance) = instance else {
                    return JniValue::Null;
                };
                if let Some(asset_manager) = data_ref::<AssetManagerState>(instance) {
                    let mut target = asset_manager.asset_root.join(&name);
                    if !target.is_file() && name == "sign_encrypt" {
                        target = asset_manager.sign_encrypt.clone();
                    }
                    match fs::read(&target) {
                        Ok(data) => {
                            return new_mut_data_object(
                                input_stream_class,
                                InputStreamState {
                                    name,
                                    cursor: Cursor::new(data),
                                },
                            ).into();
                        }
                        Err(err) => {
                            self.shared.borrow_mut().append_native_trace(
                                "jni_error",
                                &format!("AssetManager.open({}) failed: {}", target.display(), err),
                            );
                            return JniValue::Null;
                        }
                    }
                }
            }
            "java/lang/String->getBytes(Ljava/lang/String;)[B" => {
                let value = instance
                    .as_ref()
                    .map(|object| string_from_object(object))
                    .unwrap_or_default();
                let _charset = args.get::<String>(vm);
                return value.into_bytes().into();
            }
            "java/lang/String->getBytes()[B" => {
                let value = instance
                    .as_ref()
                    .map(|object| string_from_object(object))
                    .unwrap_or_default();
                return value.into_bytes().into();
            }
            "java/lang/String->hashCode()I" => {
                let value = instance
                    .as_ref()
                    .map(|object| string_from_object(object))
                    .unwrap_or_default();
                if value.starts_with("30820") && value.len() > 500 {
                    return 30010568.into();
                }
                return java_string_hash(&value).into();
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
            "com/monch/lbase/LBase->getSecretKey()Ljava/lang/String;" => {
                if let Some(DvmObject::String(value)) = self
                    .shared
                    .borrow()
                    .static_object_fields
                    .get(LBASE_PROBE_SECRET_FIELD)
                {
                    return value.clone().into();
                }
                return String::new().into();
            }
            "android/text/TextUtils->isEmpty(Ljava/lang/CharSequence;)Z" => {
                let text = string_from_id(vm, args.get::<i64>(vm));
                return text.is_empty().into();
            }
            "p50/d->e()I" => {
                let Some(instance) = instance else {
                    return 1.into();
                };
                if let Some(provider) = data_ref::<ProbeDialogProviderState>(instance) {
                    return provider.captcha_type.into();
                }
                return 1.into();
            }
            "p50/c->a()Ljava/lang/String;" => {
                let Some(instance) = instance else {
                    return String::new().into();
                };
                if let Some(callback) = data_ref::<ProbeCaptchaCallbackState>(instance) {
                    return callback.captcha_info.clone().into();
                }
                return String::new().into();
            }
            "org/json/JSONObject->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;" => {
                let key = args.get::<String>(vm);
                let value_id = args.get::<i64>(vm);
                let value = object_from_id_mut(vm, value_id)
                    .map(|object| object_to_json_value(object))
                    .unwrap_or(Value::Null);
                let Some(instance) = instance else {
                    return JniValue::Null;
                };
                if let Some(state) = data_mut::<JsonObjectState>(instance) {
                    state.put_value(&key, value);
                    return instance.clone().into();
                }
                return JniValue::Null;
            }
            "org/json/JSONObject->optString(Ljava/lang/String;)Ljava/lang/String;" => {
                let key = args.get::<String>(vm);
                let Some(instance) = instance else {
                    return String::new().into();
                };
                if let Some(state) = data_ref::<JsonObjectState>(instance) {
                    return state.opt_string(&key).into();
                }
                return String::new().into();
            }
            "org/json/JSONObject->toString()Ljava/lang/String;" => {
                let Some(instance) = instance else {
                    return "{}".to_string().into();
                };
                if let Some(state) = data_ref::<JsonObjectState>(instance) {
                    return state.to_json_string().into();
                }
                return "{}".to_string().into();
            }
            "p50/d$a->onDialogResult(Ljava/lang/String;)V" => {
                let raw = args.get::<String>(vm);
                let Some(instance) = instance else {
                    return JniValue::Void;
                };
                if let Err(err) = synthetic_dialog_result_invoke(instance, &raw) {
                    self.shared.borrow_mut().append_native_trace(
                        "jni_error",
                        &format!("p50/d$a.onDialogResult synthetic invoke failed: {err:#}"),
                    );
                }
                return JniValue::Void;
            }
            "java/io/InputStream->read()I" => {
                let Some(instance) = instance else {
                    return (-1).into();
                };
                if let Some(stream) = data_mut::<InputStreamState>(instance) {
                    let mut byte = [0u8; 1];
                    return match stream.cursor.read(&mut byte) {
                        Ok(0) => (-1).into(),
                        Ok(_) => (byte[0] as i32).into(),
                        Err(_) => (-1).into(),
                    };
                }
            }
            "java/io/InputStream->available()I" => {
                let Some(instance) = instance else {
                    return 0.into();
                };
                if let Some(stream) = data_mut::<InputStreamState>(instance) {
                    let pos = stream.cursor.position() as usize;
                    let len = stream.cursor.get_ref().len();
                    return ((len.saturating_sub(pos)) as i32).into();
                }
            }
            "java/io/InputStream->read([B)I" => {
                let array_id = args.get::<i64>(vm);
                let Some(instance) = instance else {
                    return (-1).into();
                };
                if let Some(stream) = data_mut::<InputStreamState>(instance) {
                    if let Some(DvmObject::ByteArray(buffer)) = object_from_id_mut(vm, array_id) {
                        let len = buffer.len();
                        return read_into(stream, buffer, 0, len).into();
                    }
                }
            }
            "java/io/InputStream->read([BII)I" => {
                let array_id = args.get::<i64>(vm);
                let off = args.get::<i32>(vm);
                let len = args.get::<i32>(vm);
                let Some(instance) = instance else {
                    return (-1).into();
                };
                if let Some(stream) = data_mut::<InputStreamState>(instance) {
                    if let Some(DvmObject::ByteArray(buffer)) = object_from_id_mut(vm, array_id) {
                        return read_into(stream, buffer, off as usize, len.max(0) as usize).into();
                    }
                }
            }
            "java/io/InputStream->close()V" => {
                return JniValue::Void;
            }
            _ => {}
        }

        self.shared
            .borrow_mut()
            .append_native_trace("jni_unhandled", &format!("{} acc={:?}", signature, acc));
        Self::default_return(acc)
    }

    fn get_field_value(
        &mut self,
        _vm: &mut DalvikVM64<()>,
        class: &Rc<DvmClass>,
        field: &emulator::android::dvm::member::DvmField,
        instance: Option<&mut DvmObject>,
    ) -> JniValue {
        let signature = Self::field_signature(class, &field.name, &field.signature);
        self.shared
            .borrow_mut()
            .append_jni_call("GET_FIELD", &signature);

        if instance.is_none() {
            if let Some(value) = self
                .shared
                .borrow()
                .static_object_fields
                .get(&signature)
                .cloned()
            {
                return value.into();
            }
        }

        match signature.as_str() {
            "android/content/pm/PackageInfo->signatures:[Landroid/content/pm/Signature;" => {
                let Some(instance) = instance else {
                    return JniValue::Null;
                };
                if let Some(package_info) = data_ref::<PackageInfoState>(instance) {
                    return package_info.signatures.clone().into();
                }
            }
            "p50/d->f130764c:Lp50/c;" => {
                let Some(instance) = instance else {
                    return JniValue::Null;
                };
                if let Some(provider) = data_ref::<ProbeDialogProviderState>(instance) {
                    return provider.callback.clone().into();
                }
            }
            "p50/c->f130761b:Ljava/lang/String;" => {
                let Some(instance) = instance else {
                    return JniValue::Null;
                };
                if let Some(callback) = data_ref::<ProbeCaptchaCallbackState>(instance) {
                    return callback.captcha_info.clone().into();
                }
            }
            "p50/d$a->a:Lp50/d;" | "p50/d$a->this$0:Lp50/d;" => {
                let Some(instance) = instance else {
                    return JniValue::Null;
                };
                if let Some(listener) = data_ref::<ProbeDialogListenerState>(instance) {
                    return listener.owner.clone().into();
                }
            }
            _ => {}
        }

        JniValue::Null
    }

    fn set_field_value(
        &mut self,
        _vm: &mut DalvikVM64<()>,
        class: &Rc<DvmClass>,
        field: &emulator::android::dvm::member::DvmField,
        instance: Option<&mut DvmObject>,
        value: JniValue,
    ) {
        let signature = Self::field_signature(class, &field.name, &field.signature);
        self.shared
            .borrow_mut()
            .append_jni_call("SET_FIELD", &signature);

        match signature.as_str() {
            "p50/d->f130764c:Lp50/c;" => {
                if let Some(instance) = instance {
                    if let Some(provider) = data_mut::<ProbeDialogProviderState>(instance) {
                        if let JniValue::Object(object) = &value {
                            provider.callback = object.clone();
                        }
                        return;
                    }
                }
            }
            "p50/c->f130761b:Ljava/lang/String;" => {
                if let Some(instance) = instance {
                    if let Some(callback) = data_mut::<ProbeCaptchaCallbackState>(instance) {
                        callback.captcha_info = match &value {
                            JniValue::Object(object) => string_from_object(object),
                            JniValue::Null => String::new(),
                            other => other.to_string(),
                        };
                        return;
                    }
                }
            }
            "p50/d$a->a:Lp50/d;" | "p50/d$a->this$0:Lp50/d;" => {
                if let Some(instance) = instance {
                    if let Some(listener) = data_mut::<ProbeDialogListenerState>(instance) {
                        if let JniValue::Object(object) = &value {
                            listener.owner = object.clone();
                        }
                        return;
                    }
                }
            }
            _ => {}
        }

        if let JniValue::Object(object) = value {
            self.shared
                .borrow_mut()
                .static_object_fields
                .insert(signature, object);
        }
    }
}

struct ContextState {
    asset_root: PathBuf,
    sign_encrypt: PathBuf,
}

struct AssetManagerState {
    asset_root: PathBuf,
    sign_encrypt: PathBuf,
}

struct InputStreamState {
    name: String,
    cursor: Cursor<Vec<u8>>,
}

struct PackageManagerState {
    package_name: String,
}

struct PackageInfoState {
    signatures: DvmObject,
}

struct SignatureState;

#[derive(Default)]
struct JsonObjectState {
    entries: Vec<(String, Value)>,
}

impl JsonObjectState {
    fn from_str(raw: &str) -> Self {
        let mut state = Self::default();
        if let Ok(value) = serde_json::from_str::<Value>(raw) {
            if let Some(obj) = value.as_object() {
                for (key, value) in obj {
                    state.put_value(key, value.clone());
                }
            }
        }
        state
    }

    fn put_value(&mut self, key: &str, value: Value) {
        if let Some((_, slot)) = self.entries.iter_mut().find(|(name, _)| name == key) {
            *slot = value;
        } else {
            self.entries.push((key.to_string(), value));
        }
    }

    fn opt_string(&self, key: &str) -> String {
        self.entries
            .iter()
            .find(|(name, _)| name == key)
            .map(|(_, value)| match value {
                Value::String(text) => text.clone(),
                Value::Null => String::new(),
                other => other.to_string(),
            })
            .unwrap_or_default()
    }

    fn to_json_string(&self) -> String {
        let mut parts = Vec::with_capacity(self.entries.len());
        for (key, value) in &self.entries {
            let key_json = serde_json::to_string(key).unwrap_or_else(|_| "\"\"".to_string());
            let value_json = serde_json::to_string(value).unwrap_or_else(|_| "null".to_string());
            parts.push(format!("{key_json}:{value_json}"));
        }
        format!("{{{}}}", parts.join(","))
    }
}

struct ProbeDialogProviderState {
    captcha_type: i32,
    callback: DvmObject,
}

struct ProbeCaptchaCallbackState {
    captcha_info: String,
}

struct ProbeDialogListenerState {
    owner: DvmObject,
}

#[derive(Serialize)]
struct CaptchaInfoPayload {
    #[serde(rename = "type")]
    r#type: i32,
    challenge: String,
    validate: String,
    #[serde(rename = "secCode")]
    sec_code: String,
}

fn validate_config(config: &LabConfig) -> Result<()> {
    for path in [
        &config.apk_path,
        &config.so_path,
        &config.asset_sign_encrypt_path,
        &config.purecalc_lookup_path,
    ] {
        if !path.exists() {
            return Err(anyhow!("required path not found: {}", path.display()));
        }
    }
    Ok(())
}

fn build_class_resolver() -> ClassResolver {
    ClassResolver::new(vec![
        "com/twl/signer/YZWG",
        "com/monch/lbase/LBase",
        "p50/d",
        "p50/d$a",
        "p50/c",
        "org/json/JSONObject",
        "android/text/TextUtils",
        "android/content/Context",
        "android/content/res/AssetManager",
        "android/content/pm/PackageManager",
        "android/content/pm/PackageInfo",
        "android/content/pm/Signature",
        "android/content/pm/Signature[]",
        "java/io/InputStream",
        "java/lang/String[]",
    ])
}

fn install_system_properties(emulator: &AndroidEmulator<'static, ()>, config: &LabConfig) {
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

fn configure_file_system(emulator: &AndroidEmulator<'static, ()>, config: &LabConfig) {
    let package_name = config.package_name.clone();
    let apk_path = config.apk_path.clone();
    let so_path = config.so_path.clone();
    let sign_encrypt = config.asset_sign_encrypt_path.clone();
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

            if path.ends_with("/libyzwg.so") || normalize(PathBuf::from(path)) == so_path {
                return Some(FileIO::File(LinuxFileIO::new(
                    so_path.to_string_lossy().as_ref(),
                    path,
                    flags.bits(),
                    12345,
                    StMode::APP_FILE,
                )));
            }

            if path.ends_with("/sign_encrypt") || normalize(PathBuf::from(path)) == sign_encrypt {
                return Some(FileIO::File(LinuxFileIO::new(
                    sign_encrypt.to_string_lossy().as_ref(),
                    path,
                    flags.bits(),
                    12345,
                    StMode::APP_FILE,
                )));
            }

            let _ = flags;
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

fn new_data_object(class: Rc<DvmClass>, value: impl Any) -> DvmObject {
    DvmObject::DataInstance(class, Rc::new(Box::new(value)))
}

fn new_mut_data_object(class: Rc<DvmClass>, value: impl Any) -> DvmObject {
    DvmObject::DataMutInstance(class, Rc::new(UnsafeCell::new(Box::new(value))))
}

fn data_ref<'a, T: 'static>(object: &'a DvmObject) -> Option<&'a T> {
    match object {
        DvmObject::DataInstance(_, data) => data.downcast_ref::<T>(),
        DvmObject::DataMutInstance(_, data) => unsafe { (&*data.get()).downcast_ref::<T>() },
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

fn read_into(
    stream: &mut InputStreamState,
    buffer: &mut [u8],
    offset: usize,
    length: usize,
) -> i32 {
    if offset >= buffer.len() {
        return -1;
    }
    let remaining = buffer.len() - offset;
    let length = length.min(remaining);
    let mut temp = vec![0u8; length];
    match stream.cursor.read(&mut temp) {
        Ok(0) => -1,
        Ok(read) => {
            buffer[offset..offset + read].copy_from_slice(&temp[..read]);
            read as i32
        }
        Err(_) => -1,
    }
}

fn default_dialog_result_json() -> String {
    r#"{"geetest_challenge":"","geetest_validate":"","geetest_seccode":""}"#.to_string()
}

fn object_to_json_value(object: &DvmObject) -> Value {
    match object {
        DvmObject::String(value) => Value::String(value.clone()),
        DvmObject::ByteArray(bytes) => Value::String(String::from_utf8_lossy(bytes).to_string()),
        _ => Value::String("[object]".to_string()),
    }
}

fn synthetic_dialog_result_invoke(listener: &mut DvmObject, dialog_raw: &str) -> Result<String> {
    let Some(listener_state) = data_mut::<ProbeDialogListenerState>(listener) else {
        return Err(anyhow!("listener state missing for p50/d$a"));
    };
    let Some(provider_state) = data_ref::<ProbeDialogProviderState>(&listener_state.owner) else {
        return Err(anyhow!("provider state missing for p50/d"));
    };
    let payload = build_captcha_info_payload(provider_state.captcha_type, dialog_raw)?;
    let captcha_info = serde_json::to_string(&payload)?;
    let mut callback = provider_state.callback.clone();
    if let Some(callback_state) = data_mut::<ProbeCaptchaCallbackState>(&mut callback) {
        callback_state.captcha_info = captcha_info.clone();
    }
    Ok(captcha_info)
}

fn build_captcha_info_payload(captcha_type: i32, dialog_raw: &str) -> Result<CaptchaInfoPayload> {
    let input = serde_json::from_str::<Value>(dialog_raw)
        .with_context(|| "failed to parse onDialogResult JSON")?;
    let challenge = input
        .get("geetest_challenge")
        .and_then(Value::as_str)
        .unwrap_or("")
        .to_string();
    let validate = input
        .get("geetest_validate")
        .and_then(Value::as_str)
        .unwrap_or("")
        .to_string();
    let sec_code = input
        .get("geetest_seccode")
        .and_then(Value::as_str)
        .unwrap_or("")
        .to_string();
    Ok(CaptchaInfoPayload {
        r#type: captcha_type,
        challenge,
        validate,
        sec_code,
    })
}

fn load_optional_json_arg(
    opts: &HashMap<String, String>,
    inline_keys: &[&str],
    file_keys: &[&str],
) -> Result<Option<Value>> {
    for key in inline_keys {
        if let Some(raw) = opts
            .get(*key)
            .map(|value| value.trim())
            .filter(|value| !value.is_empty())
        {
            return parse_json_or_string(raw)
                .with_context(|| format!("failed to parse {key}"))
                .map(Some);
        }
    }
    for key in file_keys {
        if let Some(path) = opts
            .get(*key)
            .map(|value| value.trim())
            .filter(|value| !value.is_empty())
        {
            let raw = fs::read_to_string(path)
                .with_context(|| format!("failed to read {key}: {path}"))?;
            return parse_json_or_string(raw.trim())
                .with_context(|| format!("failed to parse {key} payload: {path}"))
                .map(Some);
        }
    }
    Ok(None)
}

fn parse_json_or_string(raw: &str) -> Result<Value> {
    if raw.trim().is_empty() {
        return Ok(Value::Null);
    }
    match serde_json::from_str::<Value>(raw) {
        Ok(value) => Ok(value),
        Err(_) => Ok(Value::String(raw.to_string())),
    }
}

fn build_gt3_proof_truth_value(
    opts: &HashMap<String, String>,
    request_input: Option<&Value>,
) -> Value {
    let request_root = normalize_json_value(request_input.unwrap_or(&Value::Null));
    let request_url = first_non_empty([
        opt_text(opts, "--request-url"),
        opt_text(opts, "--gt3-request-url"),
        find_first_string(
            &request_root,
            &[
                "request_url",
                "url",
                "request.url",
                "request.request_url",
                "ajax.url",
            ],
            &[],
        ),
    ]);

    let query_pairs = request_url
        .as_deref()
        .map(parse_query_pairs_from_url)
        .unwrap_or_default();
    let body_value = find_first_value(
        &request_root,
        &[
            "body",
            "body_form",
            "request.body",
            "request.body_form",
            "post_body",
            "payload",
            "form",
        ],
        &[],
    )
    .cloned()
    .unwrap_or_else(|| {
        opt_text(opts, "--gt3-request-body-json")
            .and_then(|raw| parse_json_or_string(&raw).ok())
            .or_else(|| opt_text(opts, "--gt3-request-body").map(Value::String))
            .unwrap_or(Value::Null)
    });
    let body_pairs = parse_body_pairs(&body_value);

    let gt = first_non_empty([
        opt_text(opts, "--gt"),
        find_first_string(
            &request_root,
            &["gt", "request.gt", "query.gt", "params.gt"],
            &["gt"],
        ),
        lookup_param_ci(&query_pairs, "gt"),
        lookup_param_ci(&body_pairs, "gt"),
    ]);
    let bootstrap_challenge = first_non_empty([
        opt_text(opts, "--bootstrap-challenge"),
        find_first_string(
            &request_root,
            &[
                "bootstrap_challenge",
                "request.bootstrap_challenge",
                "start_captcha.challenge",
            ],
            &["bootstrap_challenge"],
        ),
    ]);
    let followup_challenge = first_non_empty([
        opt_text(opts, "--followup-challenge"),
        find_first_string(
            &request_root,
            &[
                "followup_challenge",
                "request.followup_challenge",
                "challenge",
                "request.challenge",
            ],
            &["followup_challenge"],
        ),
        lookup_param_ci(&query_pairs, "challenge"),
        lookup_param_ci(&body_pairs, "challenge"),
    ]);
    let final_challenge = first_non_empty([
        opt_text(opts, "--final-challenge"),
        find_first_string(
            &request_root,
            &["final_challenge", "request.final_challenge"],
            &["final_challenge"],
        ),
        lookup_param_ci(&query_pairs, "challenge"),
        lookup_param_ci(&body_pairs, "challenge"),
        followup_challenge.clone(),
    ]);
    let client_type = first_non_empty([
        opt_text(opts, "--client-type"),
        find_first_string(
            &request_root,
            &["client_type", "request.client_type", "query.client_type"],
            &["client_type"],
        ),
        lookup_param_ci(&query_pairs, "client_type"),
        lookup_param_ci(&body_pairs, "client_type"),
    ]);
    let pt = first_non_empty([
        opt_text(opts, "--pt"),
        find_first_string(
            &request_root,
            &["pt", "request.pt", "query.pt", "params.pt"],
            &["pt"],
        ),
        lookup_param_ci(&query_pairs, "pt"),
        lookup_param_ci(&body_pairs, "pt"),
    ]);
    let http_method = first_non_empty([
        opt_text(opts, "--http-method").map(|value| value.to_ascii_uppercase()),
        find_first_string(
            &request_root,
            &[
                "http_method",
                "method",
                "request.method",
                "request.http_method",
            ],
            &[],
        )
        .map(|value| value.to_ascii_uppercase()),
    ])
    .or_else(|| Some("POST".to_string()));
    let w = first_non_empty([
        opt_text(opts, "--w"),
        find_first_string(
            &request_root,
            &["w", "request.w", "body.w", "params.w"],
            &["w"],
        ),
        lookup_param_ci(&body_pairs, "w"),
        lookup_param_ci(&query_pairs, "w"),
    ]);
    let w_length = w.as_ref().map(|value| value.chars().count() as i64);
    let ua = first_non_empty([
        opt_text(opts, "--ua"),
        opt_text(opts, "--user-agent"),
        find_first_string(
            &request_root,
            &[
                "ua",
                "user_agent",
                "headers.user-agent",
                "headers.User-Agent",
                "request.headers.user-agent",
            ],
            &["ua", "user_agent"],
        ),
    ]);
    let geetest_cookie_snapshot = first_non_empty([
        opt_text(opts, "--geetest-cookie"),
        find_first_string(
            &request_root,
            &[
                "geetest_cookie_snapshot",
                "geetest_cookie",
                "headers.cookie",
                "headers.Cookie",
                "request.headers.cookie",
            ],
            &["geetest_cookie_snapshot", "geetest_cookie"],
        ),
    ]);
    let proof_source_tag = first_non_empty([
        opt_text(opts, "--proof-source-tag"),
        find_first_string(
            &request_root,
            &["proof_source_tag", "source_tag", "proof_source"],
            &["proof_source_tag", "proof_source"],
        ),
    ])
    .or_else(|| Some(GT3_PROOF_SOURCE_DEFAULT_TAG.to_string()));
    let query_shape = parse_shape_hint(opts, "--query-shape").unwrap_or_else(|| {
        extract_shape_from_value(find_first_value(
            &request_root,
            &["query_shape", "request.query_shape"],
            &[],
        ))
        .unwrap_or_else(|| shape_from_pairs(&query_pairs))
    });
    let body_shape = parse_shape_hint(opts, "--body-shape").unwrap_or_else(|| {
        extract_shape_from_value(find_first_value(&request_root, &["body_shape"], &[]))
            .unwrap_or_else(|| shape_from_pairs(&body_pairs))
    });
    let ts_ms = find_first_i64(&request_root, &["ts_ms", "timestamp_ms"], &["ts_ms"])
        .or_else(|| Some(Utc::now().timestamp_millis()));

    json!({
        "gt": optional_text_value(gt),
        "bootstrap_challenge": optional_text_value(bootstrap_challenge),
        "followup_challenge": optional_text_value(followup_challenge),
        "final_challenge": optional_text_value(final_challenge),
        "client_type": optional_text_value(client_type),
        "pt": optional_text_value(pt),
        "http_method": optional_text_value(http_method),
        "request_url": optional_text_value(request_url),
        "query_shape": shape_to_value(query_shape),
        "body_shape": shape_to_value(body_shape),
        "w": optional_text_value(w.clone()),
        "w_length": w_length.map(Value::from).unwrap_or(Value::Null),
        "ua": optional_text_value(ua),
        "geetest_cookie_snapshot": optional_text_value(geetest_cookie_snapshot),
        "proof_source_tag": optional_text_value(proof_source_tag),
        "ts_ms": ts_ms.map(Value::from).unwrap_or(Value::Null),
    })
}

fn build_gt3_proof_truth_response_value(response_input: Option<&Value>) -> Value {
    let response_root = normalize_json_value(response_input.unwrap_or(&Value::Null));

    let ajax_raw = find_first_value(
        &response_root,
        &[
            "ajax_raw",
            "response.ajax_raw",
            "ajax",
            "response.ajax",
            "raw",
            "response_body",
            "body",
        ],
        &["ajax_raw", "ajax"],
    )
    .map(normalize_json_value)
    .map(normalize_jsonp_wrapped_value)
    .unwrap_or(Value::Null);

    let mut success_callback_payload = find_first_value(
        &response_root,
        &[
            "success_callback_payload",
            "response.success_callback_payload",
            "callback_payload",
            "success_payload",
            "callback",
        ],
        &["success_callback_payload", "callback_payload"],
    )
    .map(normalize_json_value)
    .unwrap_or(Value::Null);
    if success_callback_payload == Value::Null {
        success_callback_payload = build_success_callback_payload_from_ajax(&ajax_raw);
    }

    let validate = first_non_empty([
        find_first_string(
            &response_root,
            &[
                "validate",
                "geetest_validate",
                "result.validate",
                "response.validate",
            ],
            &["validate", "geetest_validate"],
        ),
        find_nested_string(&success_callback_payload, &["geetest_validate", "validate"]),
        find_nested_string(&ajax_raw, &["geetest_validate", "validate"]),
    ]);
    let sec_code = first_non_empty([
        find_first_string(
            &response_root,
            &[
                "sec_code",
                "secCode",
                "seccode",
                "geetest_seccode",
                "response.sec_code",
            ],
            &["sec_code", "secCode", "geetest_seccode"],
        ),
        find_nested_string(
            &success_callback_payload,
            &["geetest_seccode", "sec_code", "secCode", "seccode"],
        ),
        find_nested_string(
            &ajax_raw,
            &["geetest_seccode", "sec_code", "secCode", "seccode"],
        ),
    ])
    .or_else(|| validate.clone().map(|value| format!("{value}|jordan")));

    json!({
        "ajax_raw": ajax_raw,
        "success_callback_payload": success_callback_payload,
        "validate": optional_text_value(validate),
        "sec_code": optional_text_value(sec_code),
    })
}

fn normalize_json_value(value: &Value) -> Value {
    if let Value::String(raw) = value {
        parse_json_or_string(raw).unwrap_or_else(|_| Value::String(raw.clone()))
    } else {
        value.clone()
    }
}

fn normalize_jsonp_wrapped_value(value: Value) -> Value {
    if let Value::String(raw) = value {
        let trimmed = raw.trim();
        if let Ok(parsed) = serde_json::from_str::<Value>(trimmed) {
            return parsed;
        }
        if let (Some(start), Some(end)) = (trimmed.find('('), trimmed.rfind(')')) {
            if start < end {
                let body = trimmed[start + 1..end].trim();
                if let Ok(parsed) = serde_json::from_str::<Value>(body) {
                    return parsed;
                }
            }
        }
        Value::String(raw)
    } else {
        value
    }
}

fn build_success_callback_payload_from_ajax(ajax_raw: &Value) -> Value {
    let challenge = find_nested_string(ajax_raw, &["geetest_challenge", "challenge"]);
    let validate = find_nested_string(ajax_raw, &["geetest_validate", "validate"]);
    let sec_code = first_non_empty([
        find_nested_string(
            ajax_raw,
            &["geetest_seccode", "sec_code", "secCode", "seccode"],
        ),
        validate.clone().map(|value| format!("{value}|jordan")),
    ]);
    if challenge.as_deref().unwrap_or_default().is_empty()
        && validate.as_deref().unwrap_or_default().is_empty()
        && sec_code.as_deref().unwrap_or_default().is_empty()
    {
        Value::Null
    } else {
        json!({
            "geetest_challenge": optional_text_value(challenge),
            "geetest_validate": optional_text_value(validate),
            "geetest_seccode": optional_text_value(sec_code),
        })
    }
}

fn parse_query_pairs_from_url(url: &str) -> Vec<(String, String)> {
    if let Ok(parsed) = Url::parse(url) {
        return parsed
            .query_pairs()
            .map(|(key, value)| (key.to_string(), value.to_string()))
            .collect();
    }
    if let Some((_, query)) = url.split_once('?') {
        return form_urlencoded::parse(query.as_bytes())
            .map(|(key, value)| (key.to_string(), value.to_string()))
            .collect();
    }
    Vec::new()
}

fn parse_body_pairs(value: &Value) -> Vec<(String, String)> {
    match normalize_json_value(value) {
        Value::Object(map) => map
            .into_iter()
            .map(|(key, value)| (key, json_value_to_text(&value).unwrap_or_default()))
            .collect(),
        Value::String(raw) => {
            let trimmed = raw.trim();
            if trimmed.is_empty() {
                return Vec::new();
            }
            if let Ok(parsed) = serde_json::from_str::<Value>(trimmed) {
                return parse_body_pairs(&parsed);
            }
            form_urlencoded::parse(trimmed.as_bytes())
                .map(|(key, value)| (key.to_string(), value.to_string()))
                .collect()
        }
        _ => Vec::new(),
    }
}

fn parse_shape_hint(opts: &HashMap<String, String>, key: &str) -> Option<Vec<String>> {
    let raw = opts
        .get(key)
        .map(|value| value.trim())
        .filter(|value| !value.is_empty())?;
    if let Ok(value) = serde_json::from_str::<Value>(raw) {
        return extract_shape_from_value(Some(&value));
    }
    let parts = raw
        .split(',')
        .map(|value| value.trim())
        .filter(|value| !value.is_empty())
        .map(|value| value.to_string())
        .collect::<Vec<_>>();
    if parts.is_empty() {
        None
    } else {
        Some(parts)
    }
}

fn extract_shape_from_value(value: Option<&Value>) -> Option<Vec<String>> {
    let value = value?;
    match normalize_json_value(value) {
        Value::Array(list) => {
            let shape = list
                .iter()
                .filter_map(json_value_to_text)
                .filter(|entry| !entry.is_empty())
                .collect::<Vec<_>>();
            if shape.is_empty() {
                None
            } else {
                Some(shape)
            }
        }
        Value::Object(map) => {
            let keys = map.keys().cloned().collect::<Vec<_>>();
            if keys.is_empty() {
                None
            } else {
                Some(keys)
            }
        }
        Value::String(raw) => {
            let trimmed = raw.trim();
            if trimmed.is_empty() {
                None
            } else {
                Some(vec![trimmed.to_string()])
            }
        }
        _ => None,
    }
}

fn shape_from_pairs(pairs: &[(String, String)]) -> Vec<String> {
    let mut shape: Vec<String> = Vec::new();
    for (key, _) in pairs {
        if !shape.iter().any(|entry| entry.eq_ignore_ascii_case(key)) {
            shape.push(key.clone());
        }
    }
    shape
}

fn shape_to_value(shape: Vec<String>) -> Value {
    Value::Array(shape.into_iter().map(Value::String).collect())
}

fn first_non_empty<const N: usize>(candidates: [Option<String>; N]) -> Option<String> {
    candidates
        .into_iter()
        .flatten()
        .map(|value| value.trim().to_string())
        .find(|value| !value.is_empty())
}

fn optional_text_value(value: Option<String>) -> Value {
    value
        .map(|entry| Value::String(entry))
        .unwrap_or(Value::Null)
}

fn opt_text(opts: &HashMap<String, String>, key: &str) -> Option<String> {
    opts.get(key)
        .map(|value| value.trim())
        .filter(|value| !value.is_empty())
        .map(ToOwned::to_owned)
}

fn find_first_string(root: &Value, paths: &[&str], fallback_keys: &[&str]) -> Option<String> {
    for path in paths {
        if let Some(value) = value_by_path_ci(root, path) {
            if let Some(text) = json_value_to_text(value).filter(|value| !value.is_empty()) {
                return Some(text);
            }
        }
    }
    find_nested_string(root, fallback_keys)
}

fn find_first_i64(root: &Value, paths: &[&str], fallback_keys: &[&str]) -> Option<i64> {
    for path in paths {
        if let Some(value) = value_by_path_ci(root, path) {
            if let Some(number) = json_value_to_i64(value) {
                return Some(number);
            }
        }
    }
    for key in fallback_keys {
        if let Some(value) = find_nested_value_by_key(root, key) {
            if let Some(number) = json_value_to_i64(value) {
                return Some(number);
            }
        }
    }
    None
}

fn find_first_value<'a>(
    root: &'a Value,
    paths: &[&str],
    fallback_keys: &[&str],
) -> Option<&'a Value> {
    for path in paths {
        if let Some(value) = value_by_path_ci(root, path) {
            return Some(value);
        }
    }
    for key in fallback_keys {
        if let Some(value) = find_nested_value_by_key(root, key) {
            return Some(value);
        }
    }
    None
}

fn value_by_path_ci<'a>(root: &'a Value, path: &str) -> Option<&'a Value> {
    let mut current = root;
    let normalized = path.trim_matches('/').replace('/', ".");
    for segment in normalized.split('.').filter(|entry| !entry.is_empty()) {
        let Value::Object(map) = current else {
            return None;
        };
        current = object_get_ci(map, segment)?;
    }
    Some(current)
}

fn object_get_ci<'a>(map: &'a serde_json::Map<String, Value>, key: &str) -> Option<&'a Value> {
    if let Some(value) = map.get(key) {
        return Some(value);
    }
    map.iter()
        .find(|(candidate, _)| candidate.eq_ignore_ascii_case(key))
        .map(|(_, value)| value)
}

fn json_value_to_text(value: &Value) -> Option<String> {
    match value {
        Value::String(text) => Some(text.clone()),
        Value::Number(number) => Some(number.to_string()),
        Value::Bool(flag) => Some(flag.to_string()),
        _ => None,
    }
}

fn json_value_to_i64(value: &Value) -> Option<i64> {
    match value {
        Value::Number(number) => number
            .as_i64()
            .or_else(|| number.as_u64().map(|v| v as i64)),
        Value::String(raw) => raw.trim().parse::<i64>().ok(),
        _ => None,
    }
}

fn find_nested_value_by_key<'a>(value: &'a Value, key: &str) -> Option<&'a Value> {
    match value {
        Value::Object(map) => {
            if let Some(found) = object_get_ci(map, key) {
                return Some(found);
            }
            for child in map.values() {
                if let Some(found) = find_nested_value_by_key(child, key) {
                    return Some(found);
                }
            }
            None
        }
        Value::Array(items) => {
            for item in items {
                if let Some(found) = find_nested_value_by_key(item, key) {
                    return Some(found);
                }
            }
            None
        }
        _ => None,
    }
}

fn find_nested_string(value: &Value, keys: &[&str]) -> Option<String> {
    for key in keys {
        if let Some(found) = find_nested_value_by_key(value, key) {
            if let Some(text) = json_value_to_text(found).filter(|entry| !entry.is_empty()) {
                return Some(text);
            }
        }
    }
    None
}

fn lookup_param_ci(pairs: &[(String, String)], key: &str) -> Option<String> {
    pairs
        .iter()
        .find(|(candidate, _)| candidate.eq_ignore_ascii_case(key))
        .map(|(_, value)| value.trim().to_string())
        .filter(|value| !value.is_empty())
}

fn set_if_missing_or_empty(target: &mut Value, key: &str, replacement: Value) {
    let Value::Object(map) = target else {
        return;
    };
    let is_missing_or_empty = map
        .get(key)
        .map(|existing| !value_is_present(existing))
        .unwrap_or(true);
    if is_missing_or_empty {
        map.insert(key.to_string(), replacement);
    }
}

fn missing_required_fields(value: &Value, required: &[&str]) -> Vec<String> {
    let mut missing = Vec::new();
    for field in required {
        let present = value
            .as_object()
            .and_then(|map| map.get(*field))
            .map(value_is_present)
            .unwrap_or(false);
        if !present {
            missing.push((*field).to_string());
        }
    }
    missing
}

fn value_is_present(value: &Value) -> bool {
    match value {
        Value::Null => false,
        Value::String(text) => !text.trim().is_empty(),
        Value::Array(items) => !items.is_empty(),
        Value::Object(map) => !map.is_empty(),
        Value::Number(_) => true,
        Value::Bool(_) => true,
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

fn write_json(path: &Path, value: &Value) -> Result<()> {
    let pretty = serde_json::to_string_pretty(value)?;
    fs::write(path, pretty).with_context(|| format!("failed to write {}", path.display()))
}

fn parse_hex_or_utf8(input: &str) -> Result<Vec<u8>> {
    if input.starts_with("hex:") {
        parse_hex(input)
    } else {
        Ok(input.as_bytes().to_vec())
    }
}

fn parse_hex(input: &str) -> Result<Vec<u8>> {
    let mut hex = input
        .trim_start_matches("hex:")
        .replace(|c: char| !c.is_ascii_hexdigit(), "");
    if hex.len() % 2 == 1 {
        hex.insert(0, '0');
    }
    hex::decode(&hex).with_context(|| format!("invalid hex input: {input}"))
}

fn required_option(opts: &HashMap<String, String>, key: &str) -> Result<String> {
    opts.get(key)
        .cloned()
        .filter(|value| !value.trim().is_empty())
        .ok_or_else(|| anyhow!("missing required option: {key}"))
}

fn matches_filter(filter: &str, method: &str) -> bool {
    filter.eq_ignore_ascii_case("all") || filter.eq_ignore_ascii_case(method)
}

fn count_events_by_tag(events: &[TraceEvent]) -> BTreeMap<String, usize> {
    let mut counts = BTreeMap::new();
    for event in events {
        *counts.entry(event.tag.clone()).or_insert(0) += 1;
    }
    counts
}

fn tail_events(events: &[TraceEvent], limit: usize) -> Vec<TraceEvent> {
    let keep = events.len().saturating_sub(limit);
    events.iter().skip(keep).cloned().collect()
}

fn java_string_hash(value: &str) -> i32 {
    let mut hash = 0_i32;
    for ch in value.encode_utf16() {
        hash = hash.wrapping_mul(31).wrapping_add(ch as i32);
    }
    hash
}

fn try_utf8(data: &[u8]) -> String {
    String::from_utf8_lossy(data).to_string()
}

fn to_hex(data: &[u8]) -> String {
    hex::encode(data)
}

fn truncate(value: &str, max_len: usize) -> String {
    if value.len() <= max_len {
        value.to_string()
    } else {
        value[..max_len].to_string()
    }
}

fn iso_now() -> String {
    Utc::now().to_rfc3339_opts(SecondsFormat::Nanos, true)
}
