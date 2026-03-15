use std::any::Any;
use std::cell::{RefCell, UnsafeCell};
use std::collections::HashMap;
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
use serde::Deserialize;
use serde_json::{json, Value};

const PID: u32 = 2667;
const PPID: u32 = 2427;
const SIGNATURE_HEX: &str = "308201c13082012aa003020102020453b67db0300d06092a864886f70d01010505003024310d300b060355040b130468706272311330110603550403130a626f73737a686970696e3020170d3134303730343130313035365a180f32313133303631303130313035365a3024310d300b060355040b130468706272311330110603550403130a626f73737a686970696e30819f300d06092a864886f70d010101050003818d00308189028181008d38ee8f6b8d349c152b2dfbac13bc4ffbd6104a6c6eea8112d8d6e3bb15149cc8c79dc622fd6c2f654c87bf20ccfb3b15105c2e35807e004c14ca70ef94d29fbdd39c4f7382bc9e4c64f2a6f415022aa4745afb0a65714fee6e03cab70e946f7d8839b1fe00bdd6857fce138ede301616aafd855fc12abbd02010b76463c8f70203010001300d06092a864886f70d01010505000381810025a410b9fbc0e3139243cd9368fb755f5cd113454f18441373231bf75d4e20f3608e569a0dce32a26ec1e6a5105e61d87b753b903d5bb7eb4646676ab08247290c3eced459bc93a81ec0ff13c7676c3b4763b64414da2e93b433d7869f98bd70818347227c402e7af21da16825bd392e59e549fd3b35be5540e400607e6c211b";

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

struct SharedState {
    config: LabConfig,
    jni_calls: BufWriter<File>,
    native_trace: BufWriter<File>,
    static_object_fields: HashMap<String, DvmObject>,
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
        })
    }

    fn append_jni_call(&mut self, kind: &str, signature: &str) {
        let _ = writeln!(self.jni_calls, "[{}] [{}] {}", iso_now(), kind, signature);
        let _ = self.jni_calls.flush();
    }

    fn append_native_trace(&mut self, tag: &str, message: &str) {
        let _ = writeln!(self.native_trace, "[{}] [{}] {}", iso_now(), tag, message);
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

    pub fn load_with_backend(
        config_path: impl AsRef<Path>,
        backend_override: Option<&str>,
    ) -> Result<Self> {
        let config = LabConfig::load(config_path)?.with_backend_override(backend_override)?;
        Self::from_config(config)
    }

    fn from_config(config: LabConfig) -> Result<Self> {
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

        let lab = Self {
            config,
            emulator,
            yzwg_class,
            string_array_class,
            module_base,
            module_size,
            shared,
        };
        lab.initialize_with_context(default_context);
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

        Ok(json!({
            "status": "ok",
            "invoke_result": invoke_path,
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
            _ => {}
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
        let signature = Self::field_signature(class, &field.name, &field.signature);
        self.shared
            .borrow_mut()
            .append_jni_call("SET_FIELD", &signature);
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
