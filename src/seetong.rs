use std::cell::{RefCell, UnsafeCell};
use std::collections::HashMap;
use std::fs::{self, File};
use std::io::{BufWriter, Write};
use std::path::{Path, PathBuf};
use std::rc::Rc;
use std::time::{Duration, Instant, SystemTime, UNIX_EPOCH};

use anyhow::{anyhow, Context, Result};
use emulator::android::dvm::class::DvmClass;
use emulator::android::dvm::class_resolver::ClassResolver;
use emulator::android::dvm::member::DvmField;
use emulator::android::dvm::object::DvmObject;
use emulator::android::dvm::DalvikVM64;
use emulator::android::jni::{self, Jni, JniValue, MethodAcc, VaList};
use emulator::android::virtual_library::libc::SystemPropertyService;
use emulator::linux::file_system::{FileIO, StMode};
use emulator::linux::fs::linux_file::LinuxFileIO;
use emulator::linux::fs::ByteArrayFileIO;
use emulator::memory::svc_memory::{HookListener, SimpleArm64Svc, SvcCallResult};
use emulator::{AndroidEmulator, BackendKind};
use serde::{Deserialize, Serialize};
use serde_json::{json, Value};

const PID: u32 = 2777;
const PPID: u32 = 2444;
const DEFAULT_CAPTURE_SECONDS: f64 = 20.0;
const DEFAULT_TRACE_DIR: &str = "/private/tmp/seetong_rnidbg_trace";

#[derive(Clone, Debug, Deserialize)]
pub struct SeetongConfig {
    #[serde(rename = "package")]
    pub package_name: String,
    pub apk_path: PathBuf,
    #[serde(default, alias = "funclib_agent_path")]
    pub funclib_agent_so_path: PathBuf,
    pub trace_out_dir: PathBuf,
    pub android_api: i32,
    pub backend: String,
}

impl SeetongConfig {
    pub fn load(path: impl AsRef<Path>) -> Result<Self> {
        let path = path.as_ref();
        let raw = fs::read_to_string(path)
            .with_context(|| format!("failed to read config: {}", path.display()))?;
        let mut config: SeetongConfig = serde_json::from_str(&raw)
            .with_context(|| format!("failed to parse config json: {}", path.display()))?;
        config.apk_path = normalize(config.apk_path);
        config.funclib_agent_so_path = normalize(config.funclib_agent_so_path);
        config.trace_out_dir = normalize(config.trace_out_dir);
        config.backend = normalize_backend_name(&config.backend)?.to_string();
        Ok(config)
    }

    pub fn backend_kind(&self) -> Result<BackendKind> {
        BackendKind::parse(&self.backend)
            .ok_or_else(|| anyhow!("unsupported backend: {}", self.backend))
    }
}

#[derive(Clone, Debug, Deserialize, Serialize)]
pub struct SeetongSeed {
    pub client_id: String,
    #[serde(default = "default_header_os")]
    pub header_os: String,
    #[serde(default = "default_header_lang")]
    pub header_lang: String,
    #[serde(default = "default_phone_brand")]
    pub phone_brand: String,
    #[serde(default = "default_phone_type")]
    pub phone_type: String,
    #[serde(default = "default_app_name")]
    pub app_name: String,
    #[serde(default = "default_app_version")]
    pub app_version: String,
    pub access_token: String,
    pub refresh_token: String,
    pub biz_domain: String,
    #[serde(default)]
    pub biz_domain_backup: String,
    #[serde(default)]
    pub active_biz_domain_info: String,
    #[serde(default)]
    pub active_user_domain_info: String,
    #[serde(default)]
    pub user_domain: String,
    #[serde(default)]
    pub user_domain_backup: String,
    #[serde(default)]
    pub fw_update_domain: String,
    #[serde(default)]
    pub nat_servers: String,
    pub expires_time: i64,
    pub user_id: String,
    pub user_info_json: String,
    pub device_list_json: String,
    pub dev_id: String,
    pub dev_sn: String,
    #[serde(default)]
    pub sig_client_id: String,
    #[serde(default)]
    pub sig_client_token: String,
    #[serde(default = "default_stream_no")]
    pub stream_no: i32,
    #[serde(default)]
    pub frame_type: i32,
    #[serde(default)]
    pub com_type: i32,
    #[serde(default = "default_add_watch_arg4")]
    pub add_watch_arg4: i32,
    #[serde(default)]
    pub set_prior_preconnect: bool,
}

fn default_stream_no() -> i32 {
    0
}

fn default_add_watch_arg4() -> i32 {
    1
}

fn default_header_os() -> String {
    "and".to_string()
}

fn default_header_lang() -> String {
    "zh_CN".to_string()
}

fn default_phone_brand() -> String {
    "realme".to_string()
}

fn default_phone_type() -> String {
    "RMX3560".to_string()
}

fn default_app_name() -> String {
    "seetong".to_string()
}

fn default_app_version() -> String {
    "8.3.8.4".to_string()
}

#[derive(Default, Serialize)]
struct CaptureStats {
    cmd_rsp_count: usize,
    msg_rsp_count: usize,
    media_video_frames: usize,
    media_audio_frames: usize,
    total_video_bytes: usize,
    total_audio_bytes: usize,
    last_msg_code: Option<i32>,
    last_cmd_code: Option<i32>,
    last_dev_id: Option<String>,
    sig_client_id_from_callback: Option<String>,
    sig_client_token_from_callback: Option<String>,
    add_watch_rsp_seen: bool,
}

#[derive(Clone, Serialize)]
struct TraceEvent {
    ts_ms: u64,
    kind: String,
    detail: Value,
}

struct SharedState {
    config: SeetongConfig,
    stats: CaptureStats,
    events: BufWriter<File>,
    video_dump: BufWriter<File>,
    audio_dump: BufWriter<File>,
}

impl SharedState {
    fn new(config: SeetongConfig) -> Result<Self> {
        fs::create_dir_all(&config.trace_out_dir).with_context(|| {
            format!(
                "failed to create trace dir: {}",
                config.trace_out_dir.display()
            )
        })?;
        Ok(Self {
            events: BufWriter::new(File::create(config.trace_out_dir.join("events.jsonl"))?),
            video_dump: BufWriter::new(File::create(
                config.trace_out_dir.join("video.u32le_frame.bin"),
            )?),
            audio_dump: BufWriter::new(File::create(
                config.trace_out_dir.join("audio.u32le_frame.bin"),
            )?),
            config,
            stats: CaptureStats::default(),
        })
    }

    fn event(&mut self, kind: &str, detail: Value) {
        let row = TraceEvent {
            ts_ms: now_ms(),
            kind: kind.to_string(),
            detail,
        };
        let _ = serde_json::to_writer(&mut self.events, &row);
        let _ = writeln!(&mut self.events);
        let _ = self.events.flush();
    }

    fn write_u32le_frame(writer: &mut BufWriter<File>, frame: &[u8]) -> Result<()> {
        let len = u32::try_from(frame.len()).context("frame too large for u32 prefix")?;
        writer.write_all(&len.to_le_bytes())?;
        writer.write_all(frame)?;
        writer.flush()?;
        Ok(())
    }
}

struct SeetongLab {
    config: SeetongConfig,
    emulator: AndroidEmulator<'static, ()>,
    funclib_agent_class: Rc<DvmClass>,
    shared: Rc<RefCell<SharedState>>,
}

impl SeetongLab {
    fn load(config_path: impl AsRef<Path>) -> Result<Self> {
        let config = SeetongConfig::load(config_path)?;
        validate_config(&config)?;

        let shared = Rc::new(RefCell::new(SharedState::new(config.clone())?));
        let emulator = AndroidEmulator::create_arm64_with_backend(
            PID,
            PPID,
            &config.package_name,
            (),
            config.backend_kind()?,
        )?;
        emulator.add_hook_listener(Box::new(SeetongStubHooks));
        install_virtual_gl_stubs(&emulator);
        install_system_properties(&emulator, &config);
        configure_file_system(&emulator, &config);

        let vm = emulator.get_dalvik_vm();
        vm.set_class_resolver(build_class_resolver());
        vm.set_jni(Box::new(SeetongJni::new(shared.clone())));

        let (_, funclib_agent_class) = vm
            .resolve_class("ipc/android/sdk/impl/FunclibAgent")
            .ok_or_else(|| anyhow!("failed to resolve FunclibAgent"))?;

        let module = vm
            .load_library(
                emulator.clone(),
                config.funclib_agent_so_path.to_string_lossy().as_ref(),
                true,
            )
            .with_context(|| {
                format!(
                    "failed to load library: {}",
                    config.funclib_agent_so_path.display()
                )
            })?;
        let module = unsafe { &*module.get() };
        vm.call_jni_onload(emulator.clone(), module)
            .context("failed to call FunclibAgent JNI_OnLoad")?;

        shared.borrow_mut().event(
            "native_load",
            json!({
                "backend": config.backend,
                "package": config.package_name,
                "funclib_agent_so_path": config.funclib_agent_so_path,
            }),
        );

        Ok(Self {
            config,
            emulator,
            funclib_agent_class,
            shared,
        })
    }

    fn capture(&mut self, seed: &SeetongSeed, capture_seconds: f64) -> Result<Value> {
        let vm = self.emulator.get_dalvik_vm();
        let funclib = self.funclib_agent_class.new_simple_instance(vm);

        let init_ret = funclib.call_method(
            &self.emulator,
            vm,
            "initWithHeader",
            "(Lipc/android/sdk/impl/FunclibAgent;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I",
            vec![
                funclib.clone().into(),
                seed.header_os.clone().into(),
                seed.header_lang.clone().into(),
                seed.phone_brand.clone().into(),
                seed.phone_type.clone().into(),
                seed.app_name.clone().into(),
                seed.app_version.clone().into(),
                seed.client_id.clone().into(),
                seed.user_domain.clone().into(),
                seed.user_domain_backup.clone().into(),
                seed.fw_update_domain.clone().into(),
                seed.active_user_domain_info.clone().into(),
                seed.nat_servers.clone().into(),
            ],
        );
        self.shared.borrow_mut().event(
            "init_with_header",
            json!({
                "ret": jni_value_to_json(&init_ret),
                "client_id": seed.client_id,
                "header_os": seed.header_os,
                "header_lang": seed.header_lang,
                "phone_brand": seed.phone_brand,
                "phone_type": seed.phone_type,
                "app_name": seed.app_name,
                "app_version": seed.app_version,
                "active_user_domain_info": seed.active_user_domain_info,
                "nat_servers": seed.nat_servers,
            }),
        );

        let set_msg_ret =
            funclib.call_method(&self.emulator, vm, "SetMsgRspCallBackAgent", "()I", vec![]);
        let set_media_ret = funclib.call_method(
            &self.emulator,
            vm,
            "SetMediaRecvCallBackAgent",
            "()I",
            vec![],
        );
        let set_log_ret = funclib.call_method(
            &self.emulator,
            vm,
            "SetFcLogCallBackEx",
            "(I)I",
            vec![1.into()],
        );
        self.shared.borrow_mut().event(
            "callbacks_install",
            json!({
                "msg_rsp_ret": jni_value_to_json(&set_msg_ret),
                "media_rsp_ret": jni_value_to_json(&set_media_ret),
                "log_ret": jni_value_to_json(&set_log_ret),
            }),
        );

        let set_access_ret = funclib.call_method(
            &self.emulator,
            vm,
            "SetAccessToken",
            "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)I",
            vec![
                seed.access_token.clone().into(),
                seed.refresh_token.clone().into(),
                seed.biz_domain.clone().into(),
                seed.biz_domain_backup.clone().into(),
                seed.active_biz_domain_info.clone().into(),
                seed.expires_time.into(),
            ],
        );
        let set_user_ret = funclib.call_method(
            &self.emulator,
            vm,
            "SetUserInfo2",
            "(Ljava/lang/String;)I",
            vec![seed.user_info_json.clone().into()],
        );
        self.shared.borrow_mut().event(
            "seed_login",
            json!({
                "set_access_token_ret": jni_value_to_json(&set_access_ret),
                "set_user_info_ret": jni_value_to_json(&set_user_ret),
                "biz_domain": seed.biz_domain,
                "expires_time": seed.expires_time,
                "user_id": seed.user_id,
            }),
        );

        std::thread::sleep(Duration::from_millis(1500));
        let (sig_client_id, sig_client_token) = {
            let shared = self.shared.borrow();
            let callback_client_id = shared
                .stats
                .sig_client_id_from_callback
                .clone()
                .unwrap_or_default();
            let callback_token = shared
                .stats
                .sig_client_token_from_callback
                .clone()
                .unwrap_or_default();
            let resolved_client_id = if !callback_client_id.is_empty() {
                callback_client_id
            } else {
                seed.sig_client_id.clone()
            };
            let resolved_token = if !callback_token.is_empty() {
                callback_token
            } else {
                seed.sig_client_token.clone()
            };
            (resolved_client_id, resolved_token)
        };
        if sig_client_id.is_empty() || sig_client_token.is_empty() {
            return Err(anyhow!(
                "missing sig login material after SetAccessToken/SetUserInfo2; client_id_present={} token_present={}",
                !sig_client_id.is_empty(),
                !sig_client_token.is_empty()
            ));
        }
        let login_sig_ret = funclib.call_method(
            &self.emulator,
            vm,
            "LoginSigServer",
            "(Ljava/lang/String;Ljava/lang/String;)I",
            vec![
                sig_client_id.clone().into(),
                sig_client_token.clone().into(),
            ],
        );
        self.shared.borrow_mut().event(
            "login_sig_server",
            json!({
                "ret": jni_value_to_json(&login_sig_ret),
                "sig_client_id": sig_client_id,
                "sig_client_token_preview": mask_token(&sig_client_token),
            }),
        );

        let add_device_ret = funclib.call_method(
            &self.emulator,
            vm,
            "AddDeviceStream",
            "(Ljava/lang/String;)I",
            vec![seed.device_list_json.clone().into()],
        );
        self.shared.borrow_mut().event(
            "add_device_stream",
            json!({
                "ret": jni_value_to_json(&add_device_ret),
                "dev_id": seed.dev_id,
                "dev_sn": seed.dev_sn,
                "device_list_json_len": seed.device_list_json.len(),
            }),
        );

        if seed.set_prior_preconnect {
            let preconnect = format!("[\"{}\"]", seed.dev_id);
            let preconnect_ret = funclib.call_method(
                &self.emulator,
                vm,
                "SetPriorPreConnectCloudId",
                "(Ljava/lang/String;)I",
                vec![preconnect.clone().into()],
            );
            self.shared.borrow_mut().event(
                "set_prior_preconnect",
                json!({
                    "ret": jni_value_to_json(&preconnect_ret),
                    "payload": preconnect,
                }),
            );
        }

        let resume_ret = funclib.call_method(
            &self.emulator,
            vm,
            "ResumeDevComWithId",
            "(Ljava/lang/String;)I",
            vec![seed.dev_id.clone().into()],
        );
        self.shared.borrow_mut().event(
            "resume_dev_com",
            json!({
                "ret": jni_value_to_json(&resume_ret),
                "dev_id": seed.dev_id,
            }),
        );

        std::thread::sleep(Duration::from_millis(1500));

        let add_watch_ret = funclib.call_method(
            &self.emulator,
            vm,
            "AddWatchEx",
            "(Ljava/lang/String;IIII)I",
            vec![
                seed.dev_id.clone().into(),
                seed.stream_no.into(),
                seed.frame_type.into(),
                seed.com_type.into(),
                seed.add_watch_arg4.into(),
            ],
        );
        self.shared.borrow_mut().event(
            "add_watch_ex",
            json!({
                "ret": jni_value_to_json(&add_watch_ret),
                "dev_id": seed.dev_id,
                "stream_no": seed.stream_no,
                "frame_type": seed.frame_type,
                "com_type": seed.com_type,
                "arg4": seed.add_watch_arg4,
            }),
        );

        let started = Instant::now();
        while started.elapsed().as_secs_f64() < capture_seconds {
            std::thread::sleep(Duration::from_millis(100));
        }

        let trace_dir = self.config.trace_out_dir.clone();
        let stats_path = trace_dir.join("capture_stats.json");
        let stats_json = serde_json::to_value(&self.shared.borrow().stats)?;
        fs::write(&stats_path, serde_json::to_vec_pretty(&stats_json)?)?;

        Ok(json!({
            "status": "ok",
            "trace_out_dir": trace_dir,
            "events_path": trace_dir.join("events.jsonl"),
            "video_dump_path": trace_dir.join("video.u32le_frame.bin"),
            "audio_dump_path": trace_dir.join("audio.u32le_frame.bin"),
            "capture_stats_path": stats_path,
            "capture_stats": stats_json,
        }))
    }
}

struct SeetongJni {
    shared: Rc<RefCell<SharedState>>,
}

struct SeetongStubHooks;

impl SeetongJni {
    fn new(shared: Rc<RefCell<SharedState>>) -> Self {
        Self { shared }
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

impl<'a, T: Clone> HookListener<'a, T> for SeetongStubHooks {
    fn hook(
        &self,
        emu: &AndroidEmulator<'a, T>,
        lib_name: String,
        symbol_name: String,
        _old: u64,
    ) -> u64 {
        if symbol_name == "memfd_create"
            || symbol_name == "getentropy"
            || symbol_name.starts_with("gl")
        {
            eprintln!("seetong hook probe lib={} symbol={}", lib_name, symbol_name);
        }
        let hook = match symbol_name.as_str() {
            "memfd_create" => {
                emu.register_svc(SimpleArm64Svc::new("memfd_create", memfd_create_stub::<T>))
            }
            "getentropy" => {
                emu.register_svc(SimpleArm64Svc::new("getentropy", getentropy_stub::<T>))
            }
            name if name.starts_with("gl") => {
                emu.register_svc(SimpleArm64Svc::new(name, zero_stub::<T>))
            }
            _ => 0,
        };
        if hook > 0 {
            eprintln!("seetong hook {} => 0x{:x}", symbol_name, hook);
        }
        hook
    }
}

impl Jni<()> for SeetongJni {
    fn resolve_method(
        &mut self,
        _vm: &mut DalvikVM64<()>,
        class: &Rc<DvmClass>,
        name: &str,
        signature: &str,
        is_static: bool,
    ) -> bool {
        self.shared.borrow_mut().event(
            "resolve_method",
            json!({
                "class": class.name,
                "name": name,
                "signature": signature,
                "is_static": is_static,
            }),
        );
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
        self.shared.borrow_mut().event(
            "resolve_field",
            json!({
                "class": class.name,
                "name": name,
                "signature": signature,
                "is_static": is_static,
            }),
        );
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
        let signature = format!("{}->{}{}", class.name, method.name, method.signature);

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
                _ => return DvmObject::new_simple(class.clone()).into(),
            }
        }

        match signature.as_str() {
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
            "android/text/TextUtils->isEmpty(Ljava/lang/CharSequence;)Z" => {
                let obj_id = args.get::<i64>(vm);
                return string_from_id(vm, obj_id).is_empty().into();
            }
            "android/util/Log->d(Ljava/lang/String;Ljava/lang/String;)I"
            | "android/util/Log->e(Ljava/lang/String;Ljava/lang/String;)I"
            | "android/util/Log->i(Ljava/lang/String;Ljava/lang/String;)I"
            | "android/util/Log->w(Ljava/lang/String;Ljava/lang/String;)I" => {
                let tag = args.get::<String>(vm);
                let msg = args.get::<String>(vm);
                self.shared.borrow_mut().event(
                    "android_log",
                    json!({
                        "signature": signature,
                        "tag": tag,
                        "msg": msg,
                    }),
                );
                return 0.into();
            }
            "ipc/android/sdk/impl/FunclibAgent->fcLogCallBack(ILjava/lang/String;)I" => {
                let level = args.get::<i32>(vm);
                let msg = args.get::<String>(vm);
                self.shared.borrow_mut().event(
                    "fc_log_callback",
                    json!({
                        "level": level,
                        "message": msg,
                    }),
                );
                return 0.into();
            }
            "ipc/android/sdk/impl/FunclibAgent->cmdRspCB(ILjava/lang/String;Ljava/lang/String;[BI)I" => {
                let msg = args.get::<i32>(vm);
                let dev_id = args.get::<String>(vm);
                let recv_obj = args.get::<String>(vm);
                let body = args.get::<Vec<u8>>(vm);
                let body_len = args.get::<i32>(vm);
                let mut shared = self.shared.borrow_mut();
                shared.stats.cmd_rsp_count += 1;
                shared.stats.last_cmd_code = Some(msg);
                shared.stats.last_dev_id = (!dev_id.is_empty()).then_some(dev_id.clone());
                shared.event(
                    "cmd_rsp_callback",
                    json!({
                        "msg": msg,
                        "dev_id": dev_id,
                        "recv_obj": recv_obj,
                        "body_len": body_len,
                        "body_preview": preview_bytes(&body),
                    }),
                );
                return 0.into();
            }
            "ipc/android/sdk/impl/FunclibAgent->msgRspCallBack(I[BI[BI)I"
            | "ipc/android/sdk/impl/FunclibAgent->msgRspCB(I[BI[BI)I" => {
                let msg = args.get::<i32>(vm);
                let head = args.get::<Vec<u8>>(vm);
                let head_len = args.get::<i32>(vm);
                let body = args.get::<Vec<u8>>(vm);
                let body_len = args.get::<i32>(vm);
                let mut shared = self.shared.borrow_mut();
                shared.stats.msg_rsp_count += 1;
                shared.stats.last_msg_code = Some(msg);
                if msg == 8196 {
                    shared.stats.add_watch_rsp_seen = true;
                }
                let body_text = trim_utf8(&body);
                if msg == 8275 && !body_text.is_empty() {
                    shared.stats.sig_client_token_from_callback = Some(body_text.clone());
                }
                if msg == 8276 && !body_text.is_empty() {
                    shared.stats.sig_client_id_from_callback = Some(body_text.clone());
                }
                shared.event(
                    "msg_rsp_callback",
                    json!({
                        "msg": msg,
                        "head_len": head_len,
                        "body_len": body_len,
                        "head_preview": preview_bytes(&head),
                        "body_preview": preview_bytes(&body),
                        "body_text": body_text,
                    }),
                );
                return 0.into();
            }
            "ipc/android/sdk/impl/FunclibAgent->mediaRecvCallBack([BI[BIID)I"
            | "ipc/android/sdk/impl/FunclibAgent->mediaRecvCB([BI[BIID)I" => {
                let dev_id_raw = args.get::<Vec<u8>>(vm);
                let media_type = args.get::<i32>(vm);
                let frame = args.get::<Vec<u8>>(vm);
                let frame_len = args.get::<i32>(vm);
                let is_key = args.get::<i32>(vm);
                let ts = args.get::<f64>(vm);
                let dev_id = trim_utf8(&dev_id_raw);
                let mut shared = self.shared.borrow_mut();
                shared.stats.last_dev_id = (!dev_id.is_empty()).then_some(dev_id.clone());
                match media_type {
                    0 => {
                        shared.stats.media_video_frames += 1;
                        shared.stats.total_video_bytes += frame.len();
                        if let Err(err) = SharedState::write_u32le_frame(&mut shared.video_dump, &frame)
                        {
                            shared.event(
                                "video_dump_error",
                                json!({
                                    "error": format!("{err:#}"),
                                }),
                            );
                        }
                    }
                    1 => {
                        shared.stats.media_audio_frames += 1;
                        shared.stats.total_audio_bytes += frame.len();
                        if let Err(err) = SharedState::write_u32le_frame(&mut shared.audio_dump, &frame)
                        {
                            shared.event(
                                "audio_dump_error",
                                json!({
                                    "error": format!("{err:#}"),
                                }),
                            );
                        }
                    }
                    _ => {}
                }
                shared.event(
                    "media_recv_callback",
                    json!({
                        "dev_id": dev_id,
                        "media_type": media_type,
                        "frame_len": frame_len,
                        "actual_len": frame.len(),
                        "is_key": is_key,
                        "timestamp": ts,
                        "frame_preview": preview_bytes(&frame),
                    }),
                );
                return 0.into();
            }
            "ipc/android/sdk/impl/FunclibAgent->logCallBack(ILjava/lang/String;Ljava/lang/String;)I" => {
                let level = args.get::<i32>(vm);
                let tag = args.get::<String>(vm);
                let msg = args.get::<String>(vm);
                self.shared.borrow_mut().event(
                    "log_callback",
                    json!({
                        "level": level,
                        "tag": tag,
                        "message": msg,
                    }),
                );
                return 0.into();
            }
            "ipc/android/sdk/impl/FunclibAgent->fcSearchIotBindStateCallBack(IILjava/lang/String;Ljava/lang/String;)I" => {
                let status = args.get::<i32>(vm);
                let sub_status = args.get::<i32>(vm);
                let dev_id = args.get::<String>(vm);
                let extra = args.get::<String>(vm);
                self.shared.borrow_mut().event(
                    "fc_search_iot_bind_state_callback",
                    json!({
                        "status": status,
                        "sub_status": sub_status,
                        "dev_id": dev_id,
                        "extra": extra,
                    }),
                );
                return 0.into();
            }
            "ipc/android/sdk/impl/FunclibAgent->SearchDevStatusCallBackJNI(JJ[B)J" => {
                let handle = args.get::<i64>(vm);
                let event = args.get::<i64>(vm);
                let payload = args.get::<Vec<u8>>(vm);
                self.shared.borrow_mut().event(
                    "search_dev_status_callback_jni",
                    json!({
                        "handle": handle,
                        "event": event,
                        "payload_preview": preview_bytes(&payload),
                    }),
                );
                return 0_i64.into();
            }
            "ipc/android/sdk/impl/FunclibAgent->StatusEventCallBackJNI(JJLjava/lang/String;)J" => {
                let handle = args.get::<i64>(vm);
                let event = args.get::<i64>(vm);
                let text = args.get::<String>(vm);
                self.shared.borrow_mut().event(
                    "status_event_callback_jni",
                    json!({
                        "handle": handle,
                        "event": event,
                        "text": text,
                    }),
                );
                return 0_i64.into();
            }
            "ipc/android/sdk/impl/FunclibAgent->StatusEventCallBackJNI2(JJ[BI)J" => {
                let handle = args.get::<i64>(vm);
                let event = args.get::<i64>(vm);
                let payload = args.get::<Vec<u8>>(vm);
                let size = args.get::<i32>(vm);
                self.shared.borrow_mut().event(
                    "status_event_callback_jni2",
                    json!({
                        "handle": handle,
                        "event": event,
                        "size": size,
                        "payload_preview": preview_bytes(&payload),
                    }),
                );
                return 0_i64.into();
            }
            "ipc/android/sdk/impl/FunclibAgent->AuxResponseCallBackJNI(JJLjava/lang/String;Ljava/lang/String;)J" => {
                let handle = args.get::<i64>(vm);
                let event = args.get::<i64>(vm);
                let left = args.get::<String>(vm);
                let right = args.get::<String>(vm);
                self.shared.borrow_mut().event(
                    "aux_response_callback_jni",
                    json!({
                        "handle": handle,
                        "event": event,
                        "left": left,
                        "right": right,
                    }),
                );
                return 0_i64.into();
            }
            _ => {
                self.shared.borrow_mut().event(
                    "jni_default",
                    json!({
                        "signature": signature,
                        "acc": format!("{acc:?}"),
                    }),
                );
            }
        }

        SeetongJni::default_return(acc)
    }

    fn get_field_value(
        &mut self,
        _vm: &mut DalvikVM64<()>,
        class: &Rc<DvmClass>,
        field: &DvmField,
        _instance: Option<&mut DvmObject>,
    ) -> JniValue {
        self.shared.borrow_mut().event(
            "get_field_value",
            json!({
                "class": class.name,
                "field": field.name,
                "signature": field.signature,
            }),
        );
        JniValue::Null
    }

    fn set_field_value(
        &mut self,
        _vm: &mut DalvikVM64<()>,
        class: &Rc<DvmClass>,
        field: &DvmField,
        _instance: Option<&mut DvmObject>,
        value: JniValue,
    ) {
        self.shared.borrow_mut().event(
            "set_field_value",
            json!({
                "class": class.name,
                "field": field.name,
                "signature": field.signature,
                "value": jni_value_to_json(&value),
            }),
        );
    }
}

pub fn run(mut args: Vec<String>) -> Result<()> {
    if args.is_empty() {
        print_usage();
        return Ok(());
    }

    let command = args.remove(0);
    let opts = parse_options(&args);

    match command.as_str() {
        "help" | "--help" | "-h" => {
            print_usage();
            Ok(())
        }
        "capture" => {
            let config_path = PathBuf::from(required_option(&opts, "--config")?);
            let seed_path = PathBuf::from(required_option(&opts, "--seed")?);
            let capture_seconds = opts
                .get("--capture-seconds")
                .map(|value| value.parse::<f64>())
                .transpose()
                .context("invalid --capture-seconds")?
                .unwrap_or(DEFAULT_CAPTURE_SECONDS);
            let mut lab = SeetongLab::load(config_path)?;
            let seed = load_seed(seed_path)?;
            let output = lab.capture(&seed, capture_seconds)?;
            println!("{}", serde_json::to_string_pretty(&output)?);
            Ok(())
        }
        other => Err(anyhow!("unknown seetong command: {other}")),
    }
}

pub fn run_smoke(opts: &HashMap<String, String>) -> Result<Value> {
    let config_path = PathBuf::from(required_option(opts, "--config")?);
    let config = SeetongConfig::load(config_path)?;
    validate_config(&config)?;
    Ok(json!({
        "status": "ok",
        "package": config.package_name,
        "apk_path": config.apk_path,
        "funclib_agent_so_path": config.funclib_agent_so_path,
        "trace_out_dir": config.trace_out_dir,
        "backend": config.backend,
    }))
}

pub fn run_live(opts: &HashMap<String, String>) -> Result<Value> {
    let config_path = PathBuf::from(required_option(opts, "--config")?);
    let seed_path = PathBuf::from(required_option(opts, "--seed")?);
    let capture_seconds = opts
        .get("--capture-seconds")
        .map(|value| value.parse::<f64>())
        .transpose()
        .context("invalid --capture-seconds")?
        .unwrap_or(DEFAULT_CAPTURE_SECONDS);
    let mut lab = SeetongLab::load(config_path)?;
    let seed = load_seed(seed_path)?;
    lab.capture(&seed, capture_seconds)
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

fn required_option(opts: &HashMap<String, String>, key: &str) -> Result<String> {
    opts.get(key)
        .cloned()
        .ok_or_else(|| anyhow!("missing required option: {key}"))
}

fn print_usage() {
    eprintln!("seetong commands:");
    eprintln!("  capture --config <path> --seed <path> [--capture-seconds <seconds>]");
}

fn load_seed(path: impl AsRef<Path>) -> Result<SeetongSeed> {
    let path = path.as_ref();
    let raw = fs::read_to_string(path)
        .with_context(|| format!("failed to read seed json: {}", path.display()))?;
    serde_json::from_str(&raw)
        .with_context(|| format!("failed to parse seed json: {}", path.display()))
}

fn validate_config(config: &SeetongConfig) -> Result<()> {
    for path in [&config.apk_path, &config.funclib_agent_so_path] {
        if !path.exists() {
            return Err(anyhow!("required path not found: {}", path.display()));
        }
    }
    Ok(())
}

fn build_class_resolver() -> ClassResolver {
    ClassResolver::new(vec![
        "ipc/android/sdk/impl/FunclibAgent",
        "ipc/android/sdk/impl/Funclib",
        "ipc/android/sdk/impl/PlayCtrlAgent",
        "ipc/android/sdk/impl/WebRtcAgent",
        "java/lang/Object",
        "java/lang/String",
        "android/text/TextUtils",
        "android/util/Log",
    ])
}

fn install_system_properties(emulator: &AndroidEmulator<'static, ()>, config: &SeetongConfig) {
    let api = config.android_api.to_string();
    let service: SystemPropertyService = Rc::new(Box::new(move |name| match name {
        "ro.build.version.sdk" => Some(api.clone()),
        "ro.product.brand" | "ro.product.manufacturer" => Some("Seetong".to_string()),
        "ro.product.model" | "ro.product.device" => Some("RNIDBG".to_string()),
        "ro.hardware" | "ro.boot.hardware" => Some("qcom".to_string()),
        "persist.sys.timezone" => Some("Asia/Shanghai".to_string()),
        _ => None,
    }));
    emulator.set_system_property_service(service);
}

fn install_virtual_gl_stubs(emu: &AndroidEmulator<'static, ()>) {
    let mut symbols = HashMap::new();
    for name in [
        "glClearColor",
        "glGetError",
        "glClearDepthf",
        "glEnable",
        "glDepthFunc",
        "glCullFace",
        "glBlendFunc",
        "glDeleteTextures",
        "glDeleteShader",
        "glDeleteProgram",
        "glViewport",
        "glGetAttribLocation",
        "glGetUniformLocation",
        "glGenTextures",
        "glBindTexture",
        "glTexParameteri",
        "glCreateProgram",
        "glAttachShader",
        "glLinkProgram",
        "glGetProgramiv",
        "glGetProgramInfoLog",
        "glCreateShader",
        "glShaderSource",
        "glCompileShader",
        "glGetShaderiv",
        "glGetShaderInfoLog",
        "glClear",
        "glUseProgram",
        "glPixelStorei",
        "glActiveTexture",
        "glUniform1i",
        "glTexImage2D",
        "glUniformMatrix4fv",
        "glEnableVertexAttribArray",
        "glDrawArrays",
        "glVertexAttribPointer",
    ] {
        let addr = emu.register_svc(SimpleArm64Svc::new(name, zero_stub::<()>));
        symbols.insert(name.to_string(), addr);
    }
    emu.memory()
        .load_virtual_module("libGLESv2.so".to_string(), symbols.clone());
    emu.memory()
        .load_virtual_module("libGLESv3.so".to_string(), symbols);
}

fn configure_file_system(emulator: &AndroidEmulator<'static, ()>, config: &SeetongConfig) {
    let package_name = config.package_name.clone();
    let apk_path = config.apk_path.clone();
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

fn normalize_backend_name(value: &str) -> Result<&'static str> {
    BackendKind::parse(value)
        .map(BackendKind::as_str)
        .ok_or_else(|| anyhow!("unsupported backend: {value}"))
}

fn string_from_object(object: &DvmObject) -> String {
    match object {
        DvmObject::String(value) => value.clone(),
        DvmObject::ByteArray(bytes) => String::from_utf8_lossy(bytes).to_string(),
        DvmObject::ObjectRef(_) => String::new(),
        _ => String::new(),
    }
}

fn object_from_id_mut<'a>(vm: &'a mut DalvikVM64<()>, object_id: i64) -> Option<&'a mut DvmObject> {
    match jni::get_flag_id(object_id) {
        jni::JNI_FLAG_OBJECT => vm.get_local_ref_mut(object_id),
        jni::JNI_FLAG_REF => vm.get_global_ref_mut(object_id),
        _ => None,
    }
}

fn string_from_id(vm: &mut DalvikVM64<()>, object_id: i64) -> String {
    match object_from_id_mut(vm, object_id) {
        Some(object) => string_from_object(object),
        None => String::new(),
    }
}

fn trim_utf8(bytes: &[u8]) -> String {
    String::from_utf8_lossy(bytes)
        .trim_matches(char::from(0))
        .trim()
        .to_string()
}

fn preview_bytes(bytes: &[u8]) -> Value {
    let preview_len = bytes.len().min(32);
    json!({
        "len": bytes.len(),
        "hex": bytes[..preview_len]
            .iter()
            .map(|byte| format!("{byte:02x}"))
            .collect::<String>(),
    })
}

fn jni_value_to_json(value: &JniValue) -> Value {
    match value {
        JniValue::Void => Value::String("void".to_string()),
        JniValue::Boolean(v) => Value::Bool(*v),
        JniValue::Byte(v) => json!(*v),
        JniValue::Char(v) => json!(*v),
        JniValue::Short(v) => json!(*v),
        JniValue::Int(v) => json!(*v),
        JniValue::Long(v) => json!(*v),
        JniValue::Float(v) => json!(*v),
        JniValue::Double(v) => json!(*v),
        JniValue::Object(_) => Value::String("object".to_string()),
        JniValue::Null => Value::Null,
    }
}

fn now_ms() -> u64 {
    SystemTime::now()
        .duration_since(UNIX_EPOCH)
        .unwrap_or_else(|_| Duration::from_millis(0))
        .as_millis() as u64
}

fn mask_token(token: &str) -> String {
    if token.is_empty() {
        return String::new();
    }
    if token.len() <= 14 {
        return format!(
            "{}...{}",
            &token[..token.len().min(4)],
            &token[token.len().saturating_sub(4)..]
        );
    }
    format!(
        "{}...{}",
        &token[..8],
        &token[token.len().saturating_sub(6)..]
    )
}

fn zero_stub<T: Clone>(_: &str, _: &AndroidEmulator<T>) -> SvcCallResult {
    SvcCallResult::RET(0)
}

fn memfd_create_stub<T: Clone>(_: &str, _: &AndroidEmulator<T>) -> SvcCallResult {
    SvcCallResult::RET(-1)
}

fn getentropy_stub<T: Clone>(_: &str, emu: &AndroidEmulator<T>) -> SvcCallResult {
    let _ = emu;
    SvcCallResult::RET(0)
}
