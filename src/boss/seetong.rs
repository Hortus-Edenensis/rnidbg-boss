use std::cell::RefCell;
use std::collections::{HashMap, HashSet};
use std::fs::OpenOptions;
use std::fs::{self, File};
use std::io::{BufWriter, Write};
use std::path::{Path, PathBuf};
use std::rc::Rc;
use std::thread;
use std::time::{Duration, Instant};

use anyhow::{anyhow, Context, Result};
use byteorder::{LittleEndian, WriteBytesExt};
use chrono::{SecondsFormat, Utc};
use emulator::android::dvm::class::DvmClass;
use emulator::android::dvm::class_resolver::ClassResolver;
use emulator::android::dvm::member::{DvmField, DvmMethod};
use emulator::android::dvm::object::DvmObject;
use emulator::android::dvm::DalvikVM64;
use emulator::android::jni::{Jni, JniValue, MethodAcc, VaList};
use emulator::android::virtual_library::libc::SystemPropertyService;
use emulator::linux::file_system::{FileIO, StMode};
use emulator::linux::fs::linux_file::LinuxFileIO;
use emulator::linux::fs::ByteArrayFileIO;
use emulator::linux::structs::OFlag;
use emulator::memory::svc_memory::{HookListener, SimpleArm64Svc, SvcCallResult};
use emulator::{AndroidEmulator, BackendKind, Permission, RegisterARM64, UnicornArg};
use reqwest::blocking::Client;
use serde::Deserialize;
use serde_json::{json, Value};
use std::sync::{Mutex, OnceLock};

use super::default_config_path;

const PID: u32 = 3888;
const PPID: u32 = 1777;
const FUNCLIB_GOT_G_BINIT: u64 = 0x72cd08;
const FUNCLIB_GOT_NETSDK_SLOT: u64 = 0x72cd10;
const FUNCLIB_GOT_CCSINF_SLOT: u64 = 0x72cd18;
const FUNCLIB_GOT_INIT_REFCOUNT: u64 = 0x72cd20;
const MINI_INIT_CCSINF_ADDR: u64 = 0x7301_0000;
const MINI_INIT_CCSINF_SIZE: usize = 0x1000;
const MINI_INIT_NETSDK_ADDR: u64 = 0x7302_0000;
const MINI_INIT_NETSDK_SIZE: usize = 0x5000;
const ACCESS_REDIRECT_STRING_ADDR: u64 = 0x7303_0000;
const ACCESS_REDIRECT_STRING_SIZE: usize = 0x1000;
const INLINE_TRACE_TRAMPOLINE_ADDR: u64 = 0x7304_0000;
const INLINE_TRACE_TRAMPOLINE_SIZE: usize = 0x2000;
const DEFAULT_P2P_URL: &str = "www.seetong.com";
const FUNCLIB_AGENT_LOC_REALPLAY_CALLBACK_SLOT_OFFSET: u64 = 0x704f0;
const ACCESS_NODE_PATH: &str = "/seetong-client/client/access-node";
const GET_SIOT_ACCESS_NODE_SYMBOL: &str =
    "_ZN6CCSInf17GetSiotAccessNodeERNSt6__ndk112basic_stringIcNS0_11char_traitsIcEENS0_9allocatorIcEEEE";
const TPSRTC_CONNECT_DEVICE_SYMBOL: &str = "_ZN10TpsrtcWrap13ConnectDeviceEP14SiotDevSession";
const TPSRTC_MEDIA_CONTROL_SYMBOL: &str = "_ZN10TpsrtcWrap12MediaControlEPvPKch";
const SIOT_ADD_WATCH_SYMBOL: &str = "_ZN14SiotDevSession8AddWatchEPciiii";
const SIOT_CONNECT_MEDIA_CHANNEL_SYMBOL: &str = "_ZN14SiotDevSession19ConnectMediaChannelEv";
const SIOT_OPEN_MEDIA_CHANNEL_SYMBOL: &str = "_ZN14SiotDevSession16OpenMediaChannelEv";
const SIOT_RESUME_DEV_COM_SYMBOL: &str = "_ZN14SiotDevSession12ResumeDevComEv";
const SIOT_SEND_XML_BY_MEDIA_SYMBOL: &str =
    "_ZN14SiotDevSession24SendXmlMsgByMediaChannelER12TpsMsgHeaderPKcbS3_bi";
const CP2P_PRECONNECT_MEDIA_SYMBOL: &str = "_ZN10CP2PStream22PreConnectMediaChannelEv";
const CP2P_AWAKEN_DEV_SYMBOL: &str = "_ZN10CP2PStream9AwakenDevEv";
const CP2P_OPEN_P2P_SYMBOL: &str = "_ZN10CP2PStream7OpenP2PEv";
const CP2P_SEND_WITH_HEADER_SYMBOL: &str = "_ZN10CP2PStream16send_with_headerEPcibi";
const CP2P_READ_P2P_SYMBOL: &str = "_ZN10CP2PStream7ReadP2PEv";
const CP2P_ON_MEDIA_RECV_SYMBOL: &str =
    "_ZN10CP2PStream19OnMediaRecvCallBackEPcjPhjP12TPS_EXT_DATA";
const HIDDEN_P2P_ALLOC_CONN_NAME: &str = "hidden::p2p_alloc_conn";
const HIDDEN_P2P_TRANSPORT_CONNECT_NAME: &str = "hidden::p2p_transport_connect";
const HIDDEN_P2P_CONN_MODE_NAME: &str = "hidden::p2p_conn_mode";
const HIDDEN_P2P_OPEN_PEER_NAME: &str = "hidden::p2p_open_peer";
const HIDDEN_P2P_TRANSPORT_CONNECT_OFFSET: u64 = 0x4b0954;
const HIDDEN_P2P_POOL_INIT_OFFSET: u64 = 0x4b2898;
const HIDDEN_P2P_GLOBAL_INIT_OFFSET: u64 = 0x4b5348;
const HIDDEN_P2P_ASYNC_TASK_OFFSET: u64 = 0x4cb454;
const HIDDEN_P2P_ALLOC_CONN_OFFSET: u64 = 0x4b2a34;
const HIDDEN_P2P_CONN_MODE_OFFSET: u64 = 0x4b31e0;
const HIDDEN_P2P_OPEN_PEER_OFFSET: u64 = 0x4b32d0;
const HIDDEN_P2P_POOL_OFFSET: u64 = 0x764ae0;
const HIDDEN_P2P_POOL_READY_OFFSET: u64 = 0x0af8;
const HIDDEN_P2P_FORCE_SUCCESS_OFFSET: u64 = 0x4b2f60;
const HIDDEN_P2P_FREE_HEAD_OFFSET: u64 = 0x767300;
const HIDDEN_P2P_FREE_TAIL_OFFSET: u64 = 0x767308;
const HIDDEN_P2P_BUSY_HEAD_OFFSET: u64 = 0x767310;
const HIDDEN_P2P_BUSY_TAIL_OFFSET: u64 = 0x767318;

struct SeetongStubHooks;

#[derive(Clone, Debug)]
struct CapturedFcInitArgs {
    header_ptr: u64,
    active_user_domain: String,
    nat_servers: String,
}

#[derive(Clone, Debug)]
struct SeetongNativeSymbols {
    funclib_base: u64,
    funclib_agent_base: u64,
    ccsinf_ctor: u64,
    ccsinf_add_device_stream: u64,
    ccsinf_add_watch_ex: u64,
    ccsinf_get_dev_picture: u64,
    ccsinf_get_siot_access_node: u64,
    ccsinf_resume_dev_com_with_id: u64,
    ccsinf_set_http_header: u64,
    ccsinf_set_user_info2: u64,
    ccsinf_keep_logining: u64,
    cnetsdk_ctor: u64,
    cnetsdk_init: u64,
    cnetsdk_init_ex: u64,
    cpp_new: u64,
    siot_add_watch: u64,
    siot_connect_media_channel: u64,
    siot_open_media_channel: u64,
    siot_resume_dev_com: u64,
    siot_send_xml_by_media: u64,
    cp2p_preconnect_media_channel: u64,
    cp2p_awaken_dev: u64,
    cp2p_open_p2p: u64,
    cp2p_send_with_header: u64,
    cp2p_read_p2p: u64,
    cp2p_on_media_recv: u64,
    hidden_p2p_transport_connect: u64,
    hidden_p2p_alloc_conn: u64,
    hidden_p2p_conn_mode: u64,
    hidden_p2p_open_peer: u64,
    tpsrtc_connect_device: u64,
    tpsrtc_media_control: u64,
    tpsrtc_instance: u64,
    tpsrtc_redirect_access: u64,
    tpsrtc_startup: u64,
    fc_loc_login_dev: u64,
    fc_loc_logout_dev: u64,
    fc_loc_real_play_ex: u64,
    fc_loc_stop_real_play: u64,
    trace_add_watch_variants: Vec<(String, u64)>,
    trace_resume_variants: Vec<(String, u64)>,
}

#[derive(Clone, Debug, Default)]
struct LocRealPlayCallbackState {
    video_path: Option<PathBuf>,
    audio_path: Option<PathBuf>,
    dev_id: String,
    video_frames: u64,
    audio_frames: u64,
    video_bytes: u64,
    audio_bytes: u64,
}

#[derive(Clone, Debug)]
struct LocRealPlayRunResult {
    login_handle: i64,
    play_handle: i64,
    stop_ret: i64,
    logout_ret: i32,
}

#[derive(Clone, Debug)]
struct SiotAccessNodeRequest {
    auth_domain: String,
    access_token: String,
    os: String,
    app_name: String,
    lang: String,
    brand: String,
    phone_type: String,
    app_version: String,
    client_id: String,
    user_domain: String,
    user_domain_back: String,
    fw_update_domain: String,
}

#[derive(Clone, Debug, Default)]
struct SiotAccessNodeStubState {
    request: Option<SiotAccessNodeRequest>,
    cached_json: Option<String>,
    last_error: Option<String>,
    original_symbol: Option<u64>,
}

fn captured_fc_init_args() -> &'static Mutex<Option<CapturedFcInitArgs>> {
    static CAPTURED: OnceLock<Mutex<Option<CapturedFcInitArgs>>> = OnceLock::new();
    CAPTURED.get_or_init(|| Mutex::new(None))
}

fn siot_access_node_stub_state() -> &'static Mutex<SiotAccessNodeStubState> {
    static STATE: OnceLock<Mutex<SiotAccessNodeStubState>> = OnceLock::new();
    STATE.get_or_init(|| Mutex::new(SiotAccessNodeStubState::default()))
}

fn guest_cpp_new_addr() -> &'static Mutex<Option<u64>> {
    static CPP_NEW: OnceLock<Mutex<Option<u64>>> = OnceLock::new();
    CPP_NEW.get_or_init(|| Mutex::new(None))
}

fn guest_funclib_base_addr() -> &'static Mutex<Option<u64>> {
    static FUNCLIB_BASE: OnceLock<Mutex<Option<u64>>> = OnceLock::new();
    FUNCLIB_BASE.get_or_init(|| Mutex::new(None))
}

fn inline_trace_trampoline_next() -> &'static Mutex<u64> {
    static NEXT: OnceLock<Mutex<u64>> = OnceLock::new();
    NEXT.get_or_init(|| Mutex::new(INLINE_TRACE_TRAMPOLINE_ADDR))
}

fn hook_trace_path() -> &'static Mutex<Option<PathBuf>> {
    static TRACE_PATH: OnceLock<Mutex<Option<PathBuf>>> = OnceLock::new();
    TRACE_PATH.get_or_init(|| Mutex::new(None))
}

fn hooked_symbol_originals() -> &'static Mutex<HashMap<String, u64>> {
    static ORIGINALS: OnceLock<Mutex<HashMap<String, u64>>> = OnceLock::new();
    ORIGINALS.get_or_init(|| Mutex::new(HashMap::new()))
}

fn loc_realplay_callback_state() -> &'static Mutex<LocRealPlayCallbackState> {
    static STATE: OnceLock<Mutex<LocRealPlayCallbackState>> = OnceLock::new();
    STATE.get_or_init(|| Mutex::new(LocRealPlayCallbackState::default()))
}

fn set_hook_trace_path(path: PathBuf) {
    *hook_trace_path().lock().expect("hook trace path lock") = Some(path);
}

fn append_hook_trace(tag: &str, message: &str) {
    let Some(path) = hook_trace_path()
        .lock()
        .expect("hook trace path lock")
        .clone()
    else {
        return;
    };
    let Ok(mut file) = OpenOptions::new().create(true).append(true).open(path) else {
        return;
    };
    let _ = writeln!(file, "[{}] [{}] {}", iso_now(), tag, message);
}

fn describe_guest_addr_local<T: Clone>(emulator: &AndroidEmulator<T>, addr: u64) -> String {
    let _ = emulator;
    format!("0x{:x}", addr)
}

fn remember_hooked_symbol_original(name: &str, address: u64) {
    hooked_symbol_originals()
        .lock()
        .expect("hooked symbol originals lock")
        .insert(name.to_string(), address);
}

fn hooked_symbol_original(name: &str) -> Option<u64> {
    hooked_symbol_originals()
        .lock()
        .expect("hooked symbol originals lock")
        .get(name)
        .copied()
}

#[derive(Clone, Debug, Deserialize)]
pub struct SeetongConfig {
    #[serde(rename = "package")]
    pub package_name: String,
    pub apk_path: PathBuf,
    pub funclib_agent_path: PathBuf,
    pub funclib_path: PathBuf,
    pub trace_out_dir: PathBuf,
    pub android_api: i32,
    pub backend: String,
}

impl SeetongConfig {
    pub fn load(path: impl AsRef<Path>) -> Result<Self> {
        let path = path.as_ref();
        let raw = fs::read_to_string(path)
            .with_context(|| format!("failed to read config: {}", path.display()))?;
        let mut config: Self = serde_json::from_str(&raw)
            .with_context(|| format!("failed to parse config: {}", path.display()))?;
        config.apk_path = normalize(config.apk_path);
        config.funclib_agent_path = normalize(config.funclib_agent_path);
        config.funclib_path = normalize(config.funclib_path);
        config.trace_out_dir = normalize(config.trace_out_dir);
        config.backend = normalize_backend_name(&config.backend)?.to_string();
        validate_config(&config)?;
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

#[derive(Clone, Debug, Deserialize)]
#[serde(rename_all = "camelCase")]
struct SeetongSeed {
    header: HeaderSeed,
    access_token: AccessTokenSeed,
    sig: SigSeed,
    user_info_json: Value,
    device_json: Value,
    #[serde(default)]
    prior_preconnect_json: Option<Value>,
    watch: WatchSeed,
    #[serde(default)]
    set_large_devlist: bool,
    #[serde(default)]
    log_level: Option<i32>,
    #[serde(default)]
    capture_ms: Option<u64>,
    #[serde(default)]
    sleep_after_login_sig_ms: Option<u64>,
    #[serde(default)]
    sleep_after_resume_ms: Option<u64>,
}

impl SeetongSeed {
    fn load(path: impl AsRef<Path>) -> Result<Self> {
        let path = path.as_ref();
        let raw = fs::read_to_string(path)
            .with_context(|| format!("failed to read seed: {}", path.display()))?;
        serde_json::from_str(&raw)
            .with_context(|| format!("failed to parse seed: {}", path.display()))
    }

    fn prior_preconnect_json(&self) -> String {
        self.prior_preconnect_json
            .as_ref()
            .map(json_to_string)
            .unwrap_or_else(|| json!([self.watch.cloud_id.clone()]).to_string())
    }

    fn siot_access_node_request(&self) -> Option<SiotAccessNodeRequest> {
        if self.access_token.access_token.trim().is_empty()
            || self.header.user_domain.trim().is_empty()
        {
            return None;
        }
        Some(SiotAccessNodeRequest {
            auth_domain: normalize_https_domain(&self.header.user_domain),
            access_token: self.access_token.access_token.clone(),
            os: self.header.os.clone(),
            app_name: self.header.name.clone(),
            lang: self.header.lang.clone(),
            brand: self.header.brand.clone(),
            phone_type: self.header.phone_type.clone(),
            app_version: self.header.version.clone(),
            client_id: self.header.client_id.clone(),
            user_domain: normalize_host_value(&self.header.user_domain),
            user_domain_back: normalize_host_value(&self.header.user_domain_back),
            fw_update_domain: normalize_host_value(&self.header.fw_update_domain),
        })
    }

    fn device_record_for_cloud_id(&self, cloud_id: &str) -> Option<&Value> {
        self.device_json
            .as_array()
            .and_then(|items| {
                items.iter().find(|item| {
                    item.get("devId")
                        .map(|value| value.to_string().trim_matches('"').to_string())
                        == Some(cloud_id.to_string())
                })
            })
            .or_else(|| self.device_json.as_array().and_then(|items| items.first()))
    }

    fn picture_add_device_json(&self) -> Value {
        let mode = std::env::var("RNIDBG_ADD_DEVICE_JSON_MODE")
            .unwrap_or_else(|_| "seed".to_string())
            .to_ascii_lowercase();
        if mode != "deposit-min" {
            return self.device_json.clone();
        }
        let Some(record) = self.device_record_for_cloud_id(&self.watch.cloud_id) else {
            return self.device_json.clone();
        };
        let object = json!({
            "devId": record.get("devId").cloned().unwrap_or_else(|| json!(self.watch.cloud_id)),
            "devSn": record.get("devSn").cloned().unwrap_or_else(|| json!("")),
            "isBinder": 1,
            "isBindVersion": 0,
            "devType": record.get("devType").cloned().unwrap_or_else(|| json!(101)),
            "devSubType": record.get("devSubType").cloned().unwrap_or_else(|| json!(1)),
            "devIp": record.get("devIp").cloned().unwrap_or_else(|| json!("")),
            "devLoginUser": record.get("devLoginUser").cloned().unwrap_or_else(|| json!("")),
            "devLoginPassword": record.get("devLoginPassword").cloned().unwrap_or_else(|| json!("")),
            "devChannelCount": record.get("devChannelCount").cloned().unwrap_or_else(|| json!(1)),
            "devChannelStates": record.get("devChannelStates").cloned().unwrap_or_else(|| json!("")),
            "vip": record.get("vip").cloned().unwrap_or_else(|| json!(0)),
            "devIsOnline": record.get("devIsOnline").cloned().unwrap_or_else(|| json!(1)),
            "feature": record.get("feature").cloned().unwrap_or_else(|| json!(0)),
            "p2pServer": record.get("p2pServer").cloned().unwrap_or_else(|| json!("")),
            "supportPlatform": record.get("supportPlatform").cloned().unwrap_or_else(|| json!(0)),
            "gatewayId": record.get("gatewayId").cloned().unwrap_or_else(|| json!("")),
            "devNetType": record.get("devNetType").cloned().unwrap_or(Value::Null),
        });
        Value::Array(vec![object])
    }
}

#[derive(Clone, Debug, Deserialize)]
#[serde(rename_all = "camelCase")]
struct HeaderSeed {
    os: String,
    lang: String,
    brand: String,
    #[serde(rename = "type")]
    phone_type: String,
    name: String,
    version: String,
    client_id: String,
    user_domain: String,
    user_domain_back: String,
    fw_update_domain: String,
    active_user_domain: String,
    nat_servers: String,
    #[serde(default)]
    log_server: Option<String>,
}

#[derive(Clone, Debug, Deserialize)]
#[serde(rename_all = "camelCase")]
struct AccessTokenSeed {
    access_token: String,
    refresh_token: String,
    biz_domain: String,
    biz_domain_backup: String,
    active_biz_domain: String,
    expires_time: i64,
}

#[derive(Clone, Debug, Deserialize)]
#[serde(rename_all = "camelCase")]
struct SigSeed {
    client_id: String,
    token: String,
}

#[derive(Clone, Debug, Deserialize)]
#[serde(rename_all = "camelCase")]
struct WatchSeed {
    cloud_id: String,
    #[serde(default)]
    stream_no: i32,
    #[serde(default)]
    frame_type: i32,
    #[serde(default)]
    com_type: i32,
    #[serde(default = "default_watch_extra")]
    extra: i32,
}

fn default_watch_extra() -> i32 {
    1
}

struct SharedState {
    trace_path: PathBuf,
    events_path: PathBuf,
    video_path: PathBuf,
    audio_path: PathBuf,
    trace_writer: BufWriter<File>,
    video_writer: BufWriter<File>,
    audio_writer: BufWriter<File>,
    events: Vec<Value>,
    video_frames: u64,
    audio_frames: u64,
    video_bytes: u64,
    audio_bytes: u64,
    msg_rsp_count: u64,
    signal_events: Vec<i32>,
}

#[derive(Clone, Debug)]
struct QueuedSendEntry {
    node_ptr: u64,
    kind: u32,
    payload_ptr: u64,
    payload_len: usize,
}

impl SharedState {
    fn new(base_dir: &Path) -> Result<Self> {
        fs::create_dir_all(base_dir)
            .with_context(|| format!("failed to create trace dir: {}", base_dir.display()))?;
        let trace_path = base_dir.join("native_trace.log");
        let events_path = base_dir.join("events.json");
        let video_path = base_dir.join("video_input.u32le_frame.bin");
        let audio_path = base_dir.join("audio_input.u32le_frame.bin");
        Ok(Self {
            trace_writer: BufWriter::new(
                File::create(&trace_path)
                    .with_context(|| format!("failed to create {}", trace_path.display()))?,
            ),
            video_writer: BufWriter::new(
                File::create(&video_path)
                    .with_context(|| format!("failed to create {}", video_path.display()))?,
            ),
            audio_writer: BufWriter::new(
                File::create(&audio_path)
                    .with_context(|| format!("failed to create {}", audio_path.display()))?,
            ),
            trace_path,
            events_path,
            video_path,
            audio_path,
            events: Vec::new(),
            video_frames: 0,
            audio_frames: 0,
            video_bytes: 0,
            audio_bytes: 0,
            msg_rsp_count: 0,
            signal_events: Vec::new(),
        })
    }

    fn trace(&mut self, tag: &str, message: &str) {
        let line = format!("[{}] [{}] {}\n", iso_now(), tag, message);
        let _ = self.trace_writer.write_all(line.as_bytes());
        let _ = self.trace_writer.flush();
    }

    fn push_event(&mut self, value: Value) {
        self.events.push(value);
        let _ = self.flush_events();
    }

    fn write_video_frame(&mut self, data: &[u8], is_key: i32, ts: f64, dev_id: &str) -> Result<()> {
        self.video_writer
            .write_u32::<LittleEndian>(data.len() as u32)
            .context("failed to write video frame length")?;
        self.video_writer
            .write_all(data)
            .context("failed to write video frame bytes")?;
        self.video_writer.flush().ok();
        self.video_frames += 1;
        self.video_bytes += data.len() as u64;
        self.push_event(json!({
            "ts": iso_now(),
            "kind": "video",
            "devId": dev_id,
            "len": data.len(),
            "isKey": is_key,
            "pts": ts,
        }));
        Ok(())
    }

    fn write_video_frame_with_seetong_trailer(
        &mut self,
        data: &[u8],
        is_key: i32,
        ts: f64,
        dev_id: &str,
    ) -> Result<()> {
        const HEADER_FLAG: u32 = 0x1A2B3C4D;
        let frame_index = (self.video_frames as u32).saturating_add(1);
        let keyframe_index = if is_key != 0 { frame_index } else { 0 };
        let trailer = [HEADER_FLAG, 0, frame_index, keyframe_index, 0, 0, 0];
        self.video_writer
            .write_u32::<LittleEndian>((data.len() + 28) as u32)
            .context("failed to write blackbox video frame length")?;
        self.video_writer
            .write_all(data)
            .context("failed to write blackbox video frame bytes")?;
        for value in trailer {
            self.video_writer
                .write_u32::<LittleEndian>(value)
                .context("failed to write blackbox video trailer")?;
        }
        self.video_writer.flush().ok();
        self.video_frames += 1;
        self.video_bytes += data.len() as u64;
        self.push_event(json!({
            "ts": iso_now(),
            "kind": "video",
            "devId": dev_id,
            "len": data.len(),
            "isKey": is_key,
            "pts": ts,
            "blackboxInjected": true,
        }));
        Ok(())
    }

    fn write_audio_frame(&mut self, data: &[u8], ts: f64, dev_id: &str) -> Result<()> {
        self.audio_writer
            .write_u32::<LittleEndian>(data.len() as u32)
            .context("failed to write audio frame length")?;
        self.audio_writer
            .write_all(data)
            .context("failed to write audio frame bytes")?;
        self.audio_writer.flush().ok();
        self.audio_frames += 1;
        self.audio_bytes += data.len() as u64;
        self.push_event(json!({
            "ts": iso_now(),
            "kind": "audio",
            "devId": dev_id,
            "len": data.len(),
            "pts": ts,
        }));
        Ok(())
    }

    fn flush_events(&mut self) -> Result<()> {
        fs::write(&self.events_path, serde_json::to_vec_pretty(&self.events)?)
            .with_context(|| format!("failed to write {}", self.events_path.display()))
    }
}

fn append_len_prefixed_frame(path: &Path, data: &[u8]) -> Result<()> {
    let mut writer = OpenOptions::new()
        .create(true)
        .append(true)
        .open(path)
        .with_context(|| format!("failed to open {}", path.display()))?;
    writer
        .write_u32::<LittleEndian>(data.len() as u32)
        .with_context(|| format!("failed to write frame length to {}", path.display()))?;
    writer
        .write_all(data)
        .with_context(|| format!("failed to write frame bytes to {}", path.display()))?;
    writer
        .flush()
        .with_context(|| format!("failed to flush {}", path.display()))?;
    Ok(())
}

fn configure_loc_realplay_callback(shared: &SharedState, dev_id: &str) {
    let mut state = loc_realplay_callback_state()
        .lock()
        .expect("loc realplay callback state lock");
    *state = LocRealPlayCallbackState {
        video_path: Some(shared.video_path.clone()),
        audio_path: Some(shared.audio_path.clone()),
        dev_id: dev_id.to_string(),
        video_frames: 0,
        audio_frames: 0,
        video_bytes: 0,
        audio_bytes: 0,
    };
}

fn write_guest_c_string_buffer<T: Clone>(
    emulator: &AndroidEmulator<T>,
    value: &str,
) -> Result<u64> {
    let bytes = value.as_bytes();
    let pointer = emulator
        .falloc(bytes.len() + 1, false)
        .context("failed to allocate guest c-string")?;
    emulator
        .backend
        .mem_write(pointer.addr, bytes)
        .context("failed to write guest c-string bytes")?;
    emulator
        .backend
        .mem_write(pointer.addr + bytes.len() as u64, &[0])
        .context("failed to write guest c-string terminator")?;
    Ok(pointer.addr)
}

fn normalize_host_value(raw: &str) -> String {
    let trimmed = raw.trim().trim_end_matches('/');
    if trimmed.is_empty() {
        return String::new();
    }
    let stripped = trimmed
        .strip_prefix("https://")
        .or_else(|| trimmed.strip_prefix("http://"))
        .unwrap_or(trimmed);
    stripped.split('/').next().unwrap_or(stripped).to_string()
}

fn normalize_https_domain(raw: &str) -> String {
    let host = normalize_host_value(raw);
    if host.is_empty() {
        String::new()
    } else {
        format!("https://{host}")
    }
}

fn fetch_siot_access_node_json(request: &SiotAccessNodeRequest) -> Result<String> {
    let client = Client::builder()
        .timeout(Duration::from_secs(10))
        .build()
        .context("failed to build access-node client")?;

    let mut req = client
        .get(format!("{}{}", request.auth_domain, ACCESS_NODE_PATH))
        .header("Seetong-Auth", request.access_token.as_str())
        .header("Seetong-os", request.os.as_str())
        .header("Seetong-App-Name", request.app_name.as_str())
        .header("Seetong-Lang", request.lang.as_str())
        .header("Seetong-App-Version", request.app_version.as_str())
        .header("Seetong-Client-Id", request.client_id.as_str());

    if !request.brand.is_empty() {
        req = req.header("Seetong-Phone-Brand", request.brand.as_str());
    }
    if !request.phone_type.is_empty() {
        req = req.header("Seetong-Phone-Type", request.phone_type.as_str());
    }
    if !request.user_domain.is_empty() {
        req = req.header("Seetong-userDomain", request.user_domain.as_str());
    }
    if !request.user_domain_back.is_empty() {
        req = req.header("Seetong-userDomainBack", request.user_domain_back.as_str());
    }
    if !request.fw_update_domain.is_empty() {
        req = req.header("Seetong-fwUpdateDomain", request.fw_update_domain.as_str());
    }

    let response = req.send().context("access-node request failed")?;
    let status = response.status();
    let body = response
        .text()
        .context("failed to read access-node response")?;
    let payload: Value =
        serde_json::from_str(&body).context("access-node returned invalid JSON")?;
    let code = payload
        .get("code")
        .and_then(|value| match value {
            Value::String(value) => Some(value.clone()),
            Value::Number(value) => Some(value.to_string()),
            _ => None,
        })
        .unwrap_or_default();
    let success = payload
        .get("success")
        .and_then(Value::as_bool)
        .unwrap_or(false);
    let data = payload.get("data").cloned().unwrap_or(Value::Null);
    if !status.is_success() || !matches!(code.as_str(), "0" | "200") || !success {
        return Err(anyhow!(
            "access-node http={} code={} success={} body={}",
            status.as_u16(),
            code,
            success,
            body
        ));
    }
    if data
        .get("accessNode")
        .and_then(Value::as_str)
        .unwrap_or("")
        .is_empty()
    {
        return Err(anyhow!("access-node payload missing accessNode: {body}"));
    }
    serde_json::to_string(&data).context("failed to serialize access-node payload")
}

fn prime_siot_access_node_stub(seed: &SeetongSeed, shared: &Rc<RefCell<SharedState>>) {
    let Some(request) = seed.siot_access_node_request() else {
        shared.borrow_mut().trace(
            "access_node",
            "stub skipped: missing auth_domain or access_token",
        );
        return;
    };

    {
        let mut state = siot_access_node_stub_state()
            .lock()
            .expect("siot access node stub state lock");
        state.request = Some(request.clone());
        state.cached_json = None;
        state.last_error = None;
    }

    match fetch_siot_access_node_json(&request) {
        Ok(json_text) => {
            let preview: Value = serde_json::from_str(&json_text).unwrap_or(Value::Null);
            let access_node = preview
                .get("accessNode")
                .and_then(Value::as_str)
                .unwrap_or("");
            let relay_count = preview
                .get("relayNodes")
                .and_then(Value::as_array)
                .map(|items| items.len())
                .unwrap_or(0);
            let sign_key_ver = preview
                .get("signKeyVer")
                .and_then(Value::as_str)
                .unwrap_or("");
            let mut state = siot_access_node_stub_state()
                .lock()
                .expect("siot access node stub state lock");
            state.cached_json = Some(json_text);
            shared.borrow_mut().trace(
                "access_node",
                &format!(
                    "prefetched accessNode={} relayCount={} signKeyVer={}",
                    access_node, relay_count, sign_key_ver
                ),
            );
        }
        Err(err) => {
            let message = format!("{err:#}");
            let mut state = siot_access_node_stub_state()
                .lock()
                .expect("siot access node stub state lock");
            state.last_error = Some(message.clone());
            shared
                .borrow_mut()
                .trace("access_node", &format!("prefetch failed: {message}"));
        }
    }
}

fn ensure_siot_access_node_json() -> Result<String> {
    let (cached_json, request) = {
        let state = siot_access_node_stub_state()
            .lock()
            .expect("siot access node stub state lock");
        (state.cached_json.clone(), state.request.clone())
    };
    if let Some(value) = cached_json {
        return Ok(value);
    }
    let request = request.ok_or_else(|| anyhow!("siot access-node stub request not configured"))?;
    let json_text = fetch_siot_access_node_json(&request)?;
    let mut state = siot_access_node_stub_state()
        .lock()
        .expect("siot access node stub state lock");
    state.cached_json = Some(json_text.clone());
    state.last_error = None;
    Ok(json_text)
}

fn guest_alloc_cpp_string_buffer<T: Clone>(
    emulator: &AndroidEmulator<T>,
    len: usize,
) -> Result<u64> {
    let pointer = emulator
        .falloc((len + 1).max(24), false)
        .context("failed to allocate guest string scratch")?;
    Ok(pointer.addr)
}

fn guest_alloc_cpp_string_buffer_via_new<T: Clone>(
    emulator: &AndroidEmulator<T>,
    len: usize,
) -> Result<u64> {
    let alloc_size = (len + 1).max(24);
    let cpp_new = guest_cpp_new_addr()
        .lock()
        .expect("guest cpp new addr lock")
        .ok_or_else(|| anyhow!("guest operator new address unavailable"))?;
    emulator
        .e_func(cpp_new, vec![UnicornArg::U64(alloc_size as u64)])
        .ok_or_else(|| anyhow!("guest operator new returned no value"))
}

fn write_guest_long_cpp_string<T: Clone>(
    emulator: &AndroidEmulator<T>,
    string_ptr: u64,
    value: &str,
) -> Result<()> {
    let bytes = value.as_bytes();
    let alloc_ptr = guest_alloc_cpp_string_buffer(emulator, bytes.len())?;
    emulator
        .backend
        .mem_write(alloc_ptr, bytes)
        .context("failed to write guest string payload")?;
    emulator
        .backend
        .mem_write(alloc_ptr + bytes.len() as u64, &[0])
        .context("failed to write guest string terminator")?;
    let alloc_size = ((bytes.len() + 1).max(24) as u64) | 1;
    emulator
        .backend
        .mem_write(string_ptr, &alloc_size.to_le_bytes())
        .context("failed to write guest string alloc_size")?;
    emulator
        .backend
        .mem_write(string_ptr + 8, &(bytes.len() as u64).to_le_bytes())
        .context("failed to write guest string len")?;
    emulator
        .backend
        .mem_write(string_ptr + 16, &alloc_ptr.to_le_bytes())
        .context("failed to write guest string ptr")?;
    Ok(())
}

fn patch_guest_function_jump<T: Clone>(
    emulator: &AndroidEmulator<T>,
    function_addr: u64,
    target_addr: u64,
) -> Result<()> {
    let mut code = emulator::keystone::assemble_no_check_v2("ldr x16, #8\nbr x16", function_addr);
    code.extend_from_slice(&target_addr.to_le_bytes());
    emulator
        .backend
        .mem_write(function_addr, &code)
        .context("failed to patch guest function jump")?;
    Ok(())
}

fn allocate_inline_trace_trampoline<T: Clone>(emulator: &AndroidEmulator<T>) -> Result<u64> {
    let mut next = inline_trace_trampoline_next()
        .lock()
        .expect("inline trace trampoline lock");
    if *next == INLINE_TRACE_TRAMPOLINE_ADDR {
        emulator.memory().mem_map(
            INLINE_TRACE_TRAMPOLINE_ADDR,
            INLINE_TRACE_TRAMPOLINE_SIZE,
            (Permission::READ | Permission::WRITE | Permission::EXEC).bits(),
            "seetong-inline-trace-trampoline".to_string(),
            0x1000,
        );
    }
    let addr = *next;
    *next += 0x40;
    Ok(addr)
}

fn install_inline_trace_patch<T: Clone>(
    emulator: &AndroidEmulator<T>,
    symbol_name: &str,
    function_addr: u64,
    svc_addr: u64,
) -> Result<u64> {
    let trampoline_addr = allocate_inline_trace_trampoline(emulator)?;
    let mut original = [0u8; 16];
    emulator
        .backend
        .mem_read(function_addr, &mut original)
        .context("failed to read original function prologue")?;
    emulator
        .backend
        .mem_write(trampoline_addr, &original)
        .context("failed to write trampoline prologue")?;
    let mut jump_back =
        emulator::keystone::assemble_no_check_v2("ldr x16, #8\nbr x16", trampoline_addr + 16);
    jump_back.extend_from_slice(&(function_addr + 16).to_le_bytes());
    emulator
        .backend
        .mem_write(trampoline_addr + 16, &jump_back)
        .context("failed to write trampoline jump-back")?;
    remember_hooked_symbol_original(symbol_name, trampoline_addr);
    patch_guest_function_jump(emulator, function_addr, svc_addr)?;
    Ok(trampoline_addr)
}

struct SeetongJni {
    shared: Rc<RefCell<SharedState>>,
}

impl SeetongJni {
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

impl Jni<()> for SeetongJni {
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
            .trace(kind, &Self::method_signature(class, name, signature));
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
            .trace(kind, &Self::field_signature(class, name, signature));
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
        let signature = Self::method_signature(class, &method.name, &method.signature);
        self.shared.borrow_mut().trace("CALL", &signature);

        if acc.contains(MethodAcc::CONSTRUCTOR) {
            if signature == "java/lang/StringBuffer-><init>()V" {
                return DvmObject::String(String::new()).into();
            }
            return DvmObject::new_simple(class.clone()).into();
        }

        match signature.as_str() {
            "java/lang/String->trim()Ljava/lang/String;" => {
                let value = instance
                    .as_ref()
                    .map(|object| string_from_object(object))
                    .unwrap_or_default();
                return value.trim().to_string().into();
            }
            "java/lang/String->toString()Ljava/lang/String;" => {
                let value = instance
                    .as_ref()
                    .map(|object| string_from_object(object))
                    .unwrap_or_default();
                return value.into();
            }
            "java/lang/StringBuffer->append(Ljava/lang/String;)Ljava/lang/StringBuffer;" => {
                let left = instance
                    .as_ref()
                    .map(|object| string_from_object(object))
                    .unwrap_or_default();
                let right = args.get::<String>(vm);
                return DvmObject::String(format!("{left}{right}")).into();
            }
            "java/lang/StringBuffer->toString()Ljava/lang/String;" => {
                let value = instance
                    .as_ref()
                    .map(|object| string_from_object(object))
                    .unwrap_or_default();
                return value.into();
            }
            "ipc/android/sdk/impl/FunclibAgent->RealDataCallBackJNI(JJ[BJID)J" => {
                let play_handle = args.get::<i64>(vm);
                let kind = args.get::<i64>(vm) as i32;
                let payload = args.get::<Vec<u8>>(vm);
                let payload_len = args.get::<i64>(vm);
                let is_key = args.get::<i32>(vm);
                let pts = args.get::<f64>(vm);
                let payload = if payload_len >= 0 && (payload_len as usize) <= payload.len() {
                    payload[..payload_len as usize].to_vec()
                } else {
                    payload
                };
                let dev_id = loc_realplay_callback_state()
                    .lock()
                    .expect("loc realplay callback state lock")
                    .dev_id
                    .clone();
                self.shared.borrow_mut().trace(
                    "loc_realdata",
                    &format!(
                        "playHandle={} mediaType={} len={} isKey={} pts={}",
                        play_handle,
                        kind,
                        payload.len(),
                        is_key,
                        pts
                    ),
                );
                let result = if kind == 0 {
                    self.shared
                        .borrow_mut()
                        .write_video_frame(&payload, is_key, pts, &dev_id)
                } else if kind == 1 {
                    self.shared
                        .borrow_mut()
                        .write_audio_frame(&payload, pts, &dev_id)
                } else {
                    self.shared.borrow_mut().push_event(json!({
                        "ts": iso_now(),
                        "kind": "locMediaOther",
                        "playHandle": play_handle,
                        "mediaType": kind,
                        "len": payload.len(),
                        "isKey": is_key,
                        "pts": pts,
                    }));
                    Ok(())
                };
                if let Err(err) = result {
                    self.shared
                        .borrow_mut()
                        .trace("loc_realdata_error", &format!("{err:#}"));
                    return (-1i64).into();
                }
                return 0i64.into();
            }
            "ipc/android/sdk/impl/FunclibAgent->ReplayDataCallBackJNI(JJ[BJ[B)J" => {
                let play_handle = args.get::<i64>(vm);
                let kind = args.get::<i64>(vm) as i32;
                let payload = args.get::<Vec<u8>>(vm);
                let payload_len = args.get::<i64>(vm);
                let extra = args.get::<Vec<u8>>(vm);
                self.shared.borrow_mut().trace(
                    "loc_replaydata",
                    &format!(
                        "playHandle={} mediaType={} len={} extraLen={}",
                        play_handle,
                        kind,
                        payload_len,
                        extra.len()
                    ),
                );
                let _ = payload;
                return 0i64.into();
            }
            "ipc/android/sdk/impl/FunclibAgent->PlayActionEventCallBackJNI(JJJLjava/lang/String;)J" => {
                let handle = args.get::<i64>(vm);
                let what = args.get::<i64>(vm);
                let extra = args.get::<i64>(vm);
                let body = args.get::<String>(vm);
                self.shared.borrow_mut().trace(
                    "loc_play_action",
                    &format!("handle={} what={} extra={} body={}", handle, what, extra, body),
                );
                return 0i64.into();
            }
            "ipc/android/sdk/impl/FunclibAgent->SearchDevStatusCallBackJNI(JJ[B)J" => {
                let handle = args.get::<i64>(vm);
                let event = args.get::<i64>(vm);
                let payload = args.get::<Vec<u8>>(vm);
                self.shared.borrow_mut().trace(
                    "loc_search_dev_status",
                    &format!(
                        "handle={} event={} payloadLen={} payloadUtf8={}",
                        handle,
                        event,
                        payload.len(),
                        try_utf8_prefix(&payload)
                    ),
                );
                return 0i64.into();
            }
            "ipc/android/sdk/impl/FunclibAgent->StatusEventCallBackJNI(JJLjava/lang/String;)J" => {
                let handle = args.get::<i64>(vm);
                let status = args.get::<i64>(vm);
                let body = args.get::<String>(vm);
                self.shared.borrow_mut().trace(
                    "loc_status_event",
                    &format!("handle={} status={} body={}", handle, status, body),
                );
                return 0i64.into();
            }
            "ipc/android/sdk/impl/FunclibAgent->StatusEventCallBackJNI2(JJ[BI)J" => {
                let handle = args.get::<i64>(vm);
                let status = args.get::<i64>(vm);
                let body = args.get::<Vec<u8>>(vm);
                let body_len = args.get::<i32>(vm);
                self.shared.borrow_mut().trace(
                    "loc_status_event2",
                    &format!(
                        "handle={} status={} bodyLen={} bodyUtf8={}",
                        handle,
                        status,
                        body_len,
                        try_utf8_prefix(&body)
                    ),
                );
                return 0i64.into();
            }
            "ipc/android/sdk/impl/FunclibAgent->AuxResponseCallBackJNI(JJLjava/lang/String;Ljava/lang/String;)J" => {
                let handle = args.get::<i64>(vm);
                let what = args.get::<i64>(vm);
                let a = args.get::<String>(vm);
                let b = args.get::<String>(vm);
                self.shared.borrow_mut().trace(
                    "loc_aux_response",
                    &format!("handle={} what={} arg1={} arg2={}", handle, what, a, b),
                );
                return 0i64.into();
            }
            "ipc/android/sdk/impl/FunclibAgent->fcLogCallBack(ILjava/lang/String;)I" => {
                let level = args.get::<i32>(vm);
                let message = args.get::<String>(vm);
                self.shared.borrow_mut().trace(
                    "fcLogCallBack",
                    &format!("level={level} message={message}"),
                );
                return 0.into();
            }
            "ipc/android/sdk/impl/FunclibAgent->logCallBack(ILjava/lang/String;Ljava/lang/String;)I" => {
                let level = args.get::<i32>(vm);
                let tag = args.get::<String>(vm);
                let message = args.get::<String>(vm);
                self.shared.borrow_mut().trace(
                    "logCallBack",
                    &format!("level={level} tag={tag} message={message}"),
                );
                return 0.into();
            }
            "ipc/android/sdk/impl/FunclibAgent->fcSearchIotBindStateCallBack(IILjava/lang/String;Ljava/lang/String;)I" => {
                let status = args.get::<i32>(vm);
                let state = args.get::<i32>(vm);
                let a = args.get::<String>(vm);
                let b = args.get::<String>(vm);
                self.shared.borrow_mut().push_event(json!({
                    "ts": iso_now(),
                    "kind": "fcSearchIotBindState",
                    "status": status,
                    "state": state,
                    "arg1": a,
                    "arg2": b,
                }));
                return 0.into();
            }
            "ipc/android/sdk/impl/FunclibAgent->singnal(I)V" => {
                let value = args.get::<i32>(vm);
                let mut shared = self.shared.borrow_mut();
                shared.signal_events.push(value);
                shared.trace("signal", &format!("value={value}"));
                shared.push_event(json!({
                    "ts": iso_now(),
                    "kind": "signal",
                    "value": value,
                }));
                return JniValue::Void;
            }
            "ipc/android/sdk/impl/FunclibAgent->msgRspCallBack(I[BI[BI)I" => {
                let what = args.get::<i32>(vm);
                let body = args.get::<Vec<u8>>(vm);
                let body_len = args.get::<i32>(vm);
                let extra = args.get::<Vec<u8>>(vm);
                let extra_len = args.get::<i32>(vm);
                let mut shared = self.shared.borrow_mut();
                shared.msg_rsp_count += 1;
                shared.trace(
                    "msgRsp",
                    &format!(
                        "what={} bodyLen={} extraLen={} bodyUtf8={} extraUtf8={}",
                        what,
                        body_len,
                        extra_len,
                        try_utf8_prefix(&body),
                        try_utf8_prefix(&extra)
                    ),
                );
                if what == 8219 {
                    if let Some(base_dir) = shared.events_path.parent() {
                        let _ = fs::write(base_dir.join("msg_rsp_8219_body.bin"), &body);
                        let _ = fs::write(base_dir.join("msg_rsp_8219_extra.bin"), &extra);
                    }
                }
                shared.push_event(json!({
                    "ts": iso_now(),
                    "kind": "msgRsp",
                    "what": what,
                    "bodyLen": body_len,
                    "bodyUtf8": try_utf8_prefix(&body),
                    "bodyHex": to_hex_prefix(&body),
                    "bodyHexFull": if what == 8219 && body_len > 0 && body.len() <= 4096 {
                        Some(hex::encode(&body))
                    } else {
                        None
                    },
                    "extraLen": extra_len,
                    "extraUtf8": try_utf8_prefix(&extra),
                    "extraHex": to_hex_prefix(&extra),
                    "extraHexFull": if what == 8219 && extra_len > 0 && extra.len() <= 4096 {
                        Some(hex::encode(&extra))
                    } else {
                        None
                    },
                }));
                return 0.into();
            }
            "ipc/android/sdk/impl/FunclibAgent->mediaRecvCallBack([BI[BIID)I"
            | "ipc/android/sdk/impl/FunclibAgent->mediaRecvCB([BI[BIID)I" => {
                let dev_id_raw = args.get::<Vec<u8>>(vm);
                let kind = args.get::<i32>(vm);
                let payload = args.get::<Vec<u8>>(vm);
                let payload_len = args.get::<i32>(vm);
                let is_key = args.get::<i32>(vm);
                let pts = args.get::<f64>(vm);
                let dev_id = String::from_utf8_lossy(&dev_id_raw).trim().to_string();
                let payload = if payload_len >= 0 && (payload_len as usize) <= payload.len() {
                    payload[..payload_len as usize].to_vec()
                } else {
                    payload
                };
                self.shared.borrow_mut().trace(
                    "media",
                    &format!(
                        "devId={} mediaType={} len={} isKey={} pts={}",
                        dev_id,
                        kind,
                        payload.len(),
                        is_key,
                        pts
                    ),
                );
                let result = if kind == 0 {
                    self.shared
                        .borrow_mut()
                        .write_video_frame(&payload, is_key, pts, &dev_id)
                } else if kind == 1 {
                    self.shared.borrow_mut().write_audio_frame(&payload, pts, &dev_id)
                } else {
                    self.shared.borrow_mut().push_event(json!({
                        "ts": iso_now(),
                        "kind": "mediaOther",
                        "devId": dev_id,
                        "mediaType": kind,
                        "len": payload.len(),
                        "isKey": is_key,
                        "pts": pts,
                    }));
                    Ok(())
                };
                if let Err(err) = result {
                    self.shared
                        .borrow_mut()
                        .trace("media_error", &format!("{err:#}"));
                    return (-1).into();
                }
                return 0.into();
            }
            _ => {}
        }

        self.shared
            .borrow_mut()
            .trace("jni_unhandled", &format!("{} acc={:?}", signature, acc));
        Self::default_return(acc)
    }

    fn get_field_value(
        &mut self,
        _vm: &mut DalvikVM64<()>,
        class: &Rc<DvmClass>,
        field: &DvmField,
        _instance: Option<&mut DvmObject>,
    ) -> JniValue {
        self.shared.borrow_mut().trace(
            "GET_FIELD",
            &Self::field_signature(class, &field.name, &field.signature),
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
        self.shared.borrow_mut().trace(
            "SET_FIELD",
            &format!(
                "{} value={}",
                Self::field_signature(class, &field.name, &field.signature),
                jni_value_brief(&value)
            ),
        );
    }
}

impl<'a, T: Clone> HookListener<'a, T> for SeetongStubHooks {
    fn hook(
        &self,
        emulator: &AndroidEmulator<'a, T>,
        _lib_name: String,
        symbol_name: String,
        _old: u64,
    ) -> u64 {
        match symbol_name.as_str() {
            "abort" => emulator.register_svc(SimpleArm64Svc::new("abort", zero_stub::<T>)),
            "android_set_abort_message" => emulator.register_svc(SimpleArm64Svc::new(
                "android_set_abort_message",
                zero_stub::<T>,
            )),
            "_ZdlPv" | "_ZdaPv" | "_ZdlPvm" | "_ZdaPvm" => {
                emulator.register_svc(SimpleArm64Svc::new(symbol_name.as_str(), zero_stub::<T>))
            }
            "memfd_create" => {
                emulator.register_svc(SimpleArm64Svc::new("memfd_create", memfd_create_stub::<T>))
            }
            "getentropy" => {
                emulator.register_svc(SimpleArm64Svc::new("getentropy", getentropy_stub::<T>))
            }
            "FC_initWithHeader" if runtime_env_truthy("RNIDBG_CAPTURE_FC_INIT_WITH_HEADER") => {
                emulator.register_svc(SimpleArm64Svc::new(
                    "FC_initWithHeader_capture",
                    fc_init_with_header_capture_stub::<T>,
                ))
            }
            GET_SIOT_ACCESS_NODE_SYMBOL => {
                siot_access_node_stub_state()
                    .lock()
                    .expect("siot access node stub state lock")
                    .original_symbol = Some(_old);
                emulator.register_svc(SimpleArm64Svc::new(
                    "CCSInf_GetSiotAccessNode_stub",
                    get_siot_access_node_stub::<T>,
                ))
            }
            TPSRTC_CONNECT_DEVICE_SYMBOL => {
                remember_hooked_symbol_original(symbol_name.as_str(), _old);
                emulator.register_svc(SimpleArm64Svc::new(
                    "TpsrtcWrap_ConnectDevice_trace",
                    trace_tpsrtc_connect_device_stub::<T>,
                ))
            }
            TPSRTC_MEDIA_CONTROL_SYMBOL => {
                remember_hooked_symbol_original(symbol_name.as_str(), _old);
                emulator.register_svc(SimpleArm64Svc::new(
                    "TpsrtcWrap_MediaControl_trace",
                    trace_tpsrtc_media_control_stub::<T>,
                ))
            }
            SIOT_CONNECT_MEDIA_CHANNEL_SYMBOL => {
                remember_hooked_symbol_original(symbol_name.as_str(), _old);
                emulator.register_svc(SimpleArm64Svc::new(
                    "SiotDevSession_ConnectMediaChannel_trace",
                    trace_siot_connect_media_channel_stub::<T>,
                ))
            }
            SIOT_OPEN_MEDIA_CHANNEL_SYMBOL => {
                remember_hooked_symbol_original(symbol_name.as_str(), _old);
                emulator.register_svc(SimpleArm64Svc::new(
                    "SiotDevSession_OpenMediaChannel_trace",
                    trace_siot_open_media_channel_stub::<T>,
                ))
            }
            SIOT_SEND_XML_BY_MEDIA_SYMBOL => {
                remember_hooked_symbol_original(symbol_name.as_str(), _old);
                emulator.register_svc(SimpleArm64Svc::new(
                    "SiotDevSession_SendXmlMsgByMedia_trace",
                    trace_siot_send_xml_by_media_stub::<T>,
                ))
            }
            name if name.starts_with("gl") || name.starts_with("egl") => {
                emulator.register_svc(SimpleArm64Svc::new(name, zero_stub::<T>))
            }
            _ => 0,
        }
    }
}

pub struct SeetongLab {
    config: SeetongConfig,
    emulator: AndroidEmulator<'static, ()>,
    funclib_class: Rc<DvmClass>,
    native_symbols: SeetongNativeSymbols,
    shared: Rc<RefCell<SharedState>>,
}

impl SeetongLab {
    pub fn load_with_backend(
        config_path: impl AsRef<Path>,
        backend_override: Option<&str>,
        trace_out_override: Option<PathBuf>,
    ) -> Result<Self> {
        let mut config =
            SeetongConfig::load(config_path)?.with_backend_override(backend_override)?;
        if let Some(path) = trace_out_override {
            config.trace_out_dir = normalize(path);
        }
        fs::create_dir_all(&config.trace_out_dir)
            .with_context(|| format!("failed to create {}", config.trace_out_dir.display()))?;
        set_hook_trace_path(config.trace_out_dir.join("native_trace.log"));

        let shared = Rc::new(RefCell::new(SharedState::new(&config.trace_out_dir)?));
        shared.borrow_mut().trace("stage", "shared_state_ready");
        let emulator = AndroidEmulator::create_arm64_with_backend(
            PID,
            PPID,
            &config.package_name,
            (),
            config.backend_kind()?,
        )?;
        shared.borrow_mut().trace("stage", "emulator_ready");
        install_system_properties(&emulator, &config);
        configure_file_system(&emulator, &config);
        emulator.add_hook_listener(Box::new(SeetongStubHooks));
        install_virtual_native_stubs(&emulator);
        shared.borrow_mut().trace("stage", "native_stubs_ready");

        let vm = emulator.get_dalvik_vm();
        vm.set_class_resolver(build_class_resolver());
        vm.set_jni(Box::new(SeetongJni::new(shared.clone())));
        shared.borrow_mut().trace("stage", "vm_ready");

        let (_, funclib_class) = vm
            .resolve_class("ipc/android/sdk/impl/FunclibAgent")
            .ok_or_else(|| anyhow!("failed to resolve ipc/android/sdk/impl/FunclibAgent"))?;
        shared.borrow_mut().trace("stage", "funclib_class_ready");

        shared.borrow_mut().trace("stage", "load_funclib_start");
        let funclib_module = vm
            .load_library(
                emulator.clone(),
                config.funclib_path.to_string_lossy().as_ref(),
                true,
            )
            .with_context(|| {
                format!(
                    "failed to load dependency: {}",
                    config.funclib_path.display()
                )
            })?;
        shared.borrow_mut().trace("stage", "load_funclib_done");
        let funclib_module = unsafe { &*funclib_module.get() };
        let mut native_symbols = resolve_funclib_symbols(funclib_module)
            .context("failed to resolve libFunclib symbols")?;
        *guest_funclib_base_addr()
            .lock()
            .expect("guest funclib base addr lock") = Some(native_symbols.funclib_base);
        *guest_cpp_new_addr()
            .lock()
            .expect("guest cpp new addr lock") = Some(native_symbols.cpp_new);
        shared
            .borrow_mut()
            .trace("stage", "load_funclib_agent_start");
        let agent_module = vm
            .load_library(
                emulator.clone(),
                config.funclib_agent_path.to_string_lossy().as_ref(),
                true,
            )
            .with_context(|| {
                format!(
                    "failed to load library: {}",
                    config.funclib_agent_path.display()
                )
            })?;
        shared
            .borrow_mut()
            .trace("stage", "load_funclib_agent_done");
        let agent_module = unsafe { &*agent_module.get() };
        native_symbols.funclib_agent_base = agent_module.base;
        vm.call_jni_onload(emulator.clone(), agent_module)
            .context("failed to call FunclibAgent JNI_OnLoad")?;
        shared
            .borrow_mut()
            .trace("stage", "register_native_methods_start");
        register_funclib_agent_natives(&emulator, vm, agent_module, funclib_class.id)
            .context("failed to register FunclibAgent native methods")?;
        shared
            .borrow_mut()
            .trace("stage", "register_native_methods_done");
        shared.borrow_mut().trace(
            "registered_methods",
            &format!("{:?}", vm.list_method_signatures(funclib_class.id)),
        );
        if runtime_env_truthy("RNIDBG_TRACE_FUNCLIB_AGENT_MEMBERS") {
            for member in vm.debug_member_signatures(funclib_class.id) {
                shared.borrow_mut().trace("funclib_agent_member", &member);
            }
        }

        Ok(Self {
            config,
            emulator,
            funclib_class,
            native_symbols,
            shared,
        })
    }

    fn new_funclib_object(&self) -> DvmObject {
        let vm = self.emulator.get_dalvik_vm();
        self.funclib_class.new_simple_instance(vm)
    }

    fn call_instance(
        &self,
        object: &DvmObject,
        method_name: &str,
        signature: &str,
        args: Vec<JniValue>,
    ) -> Result<JniValue> {
        let vm = self.emulator.get_dalvik_vm();
        if vm
            .find_method(self.funclib_class.id, method_name, signature)
            .is_none()
        {
            let available = vm.list_method_signatures(self.funclib_class.id);
            return Err(anyhow!(
                "native method not registered: {}{} on {}, available={:?}",
                method_name,
                signature,
                self.funclib_class.name,
                available
            ));
        }
        self.shared
            .borrow_mut()
            .trace("call_enter", &format!("{}{}", method_name, signature));
        let value = object.call_method(
            &self.emulator,
            self.emulator.get_dalvik_vm(),
            method_name,
            signature,
            args,
        );
        self.shared.borrow_mut().trace(
            "call_leave",
            &format!(
                "{}{} => {}",
                method_name,
                signature,
                jni_value_brief(&value)
            ),
        );
        Ok(value)
    }

    fn call_i32(
        &self,
        object: &DvmObject,
        method_name: &str,
        signature: &str,
        args: Vec<JniValue>,
    ) -> Result<i32> {
        jni_value_to_i32(self.call_instance(object, method_name, signature, args)?)
            .with_context(|| format!("{}{}", method_name, signature))
    }

    fn call_i32_with_object_id(
        &self,
        object: &DvmObject,
        method_name: &str,
        signature: &str,
        object_ids: Vec<i64>,
    ) -> Result<i32> {
        let args = object_ids
            .into_iter()
            .map(JniValue::Long)
            .collect::<Vec<_>>();
        jni_value_to_i32(self.call_instance(object, method_name, signature, args)?)
            .with_context(|| format!("{}{}", method_name, signature))
    }

    fn call_native_i32(&self, address: u64, args: Vec<UnicornArg>) -> Result<i32> {
        let value = self
            .emulator
            .e_func(address, args)
            .ok_or_else(|| anyhow!("native call 0x{address:x} returned no value"))?;
        Ok(value as u32 as i32)
    }

    fn call_ccsinf_add_device_stream_direct(&self, json_text: &str) -> Result<i32> {
        let json_ptr = write_guest_c_string_buffer(&self.emulator, json_text)?;
        self.call_native_i32(
            self.native_symbols.ccsinf_add_device_stream,
            vec![
                UnicornArg::Ptr(MINI_INIT_CCSINF_ADDR),
                UnicornArg::Ptr(json_ptr),
            ],
        )
    }

    fn call_ccsinf_set_user_info2_direct(&self, json_text: &str) -> Result<i32> {
        let json_ptr = write_guest_c_string_buffer(&self.emulator, json_text)?;
        self.call_native_i32(
            self.native_symbols.ccsinf_set_user_info2,
            vec![
                UnicornArg::Ptr(MINI_INIT_CCSINF_ADDR),
                UnicornArg::Ptr(json_ptr),
            ],
        )
    }

    fn call_ccsinf_resume_dev_com_with_id_direct(&self, cloud_id: &str) -> Result<i32> {
        let cloud_id_ptr = write_guest_c_string_buffer(&self.emulator, cloud_id)?;
        self.call_native_i32(
            self.native_symbols.ccsinf_resume_dev_com_with_id,
            vec![
                UnicornArg::Ptr(MINI_INIT_CCSINF_ADDR),
                UnicornArg::Ptr(cloud_id_ptr),
            ],
        )
    }

    fn call_ccsinf_add_watch_ex_direct(
        &self,
        cloud_id: &str,
        stream_no: i32,
        frame_type: i32,
        com_type: i32,
        extra: i32,
    ) -> Result<i32> {
        let cloud_id_ptr = write_guest_c_string_buffer(&self.emulator, cloud_id)?;
        self.call_native_i32(
            self.native_symbols.ccsinf_add_watch_ex,
            vec![
                UnicornArg::Ptr(MINI_INIT_CCSINF_ADDR),
                UnicornArg::Ptr(cloud_id_ptr),
                UnicornArg::U32(stream_no as u32),
                UnicornArg::U32(frame_type as u32),
                UnicornArg::U32(com_type as u32),
                UnicornArg::U32(extra as u32),
            ],
        )
    }

    fn call_ccsinf_get_dev_picture_direct(
        &self,
        cloud_id: &str,
        channel: i32,
        picture_path: &str,
    ) -> Result<i32> {
        let cloud_id_ptr = write_guest_c_string_buffer(&self.emulator, cloud_id)?;
        let picture_path_ptr = write_guest_c_string_buffer(&self.emulator, picture_path)?;
        self.call_native_i32(
            self.native_symbols.ccsinf_get_dev_picture,
            vec![
                UnicornArg::Ptr(MINI_INIT_CCSINF_ADDR),
                UnicornArg::Ptr(cloud_id_ptr),
                UnicornArg::U32(channel as u32),
                UnicornArg::Ptr(picture_path_ptr),
            ],
        )
    }

    fn get_h5_auth_info(&self, object: &DvmObject) -> Result<String> {
        let vm = self.emulator.get_dalvik_vm();
        let array_id = vm.add_global_ref(DvmObject::ByteArray(vec![0_u8; 256]));
        let ret = self.call_i32_with_object_id(object, "GetH5AuthInfo", "([B)I", vec![array_id])?;
        let bytes = match vm.get_global_ref_mut(array_id) {
            Some(DvmObject::ByteArray(bytes)) => bytes.clone(),
            Some(other) => {
                return Err(anyhow!(
                    "GetH5AuthInfo([B) returned unexpected global ref: {}",
                    string_from_object(other)
                ));
            }
            None => return Err(anyhow!("GetH5AuthInfo([B) global ref missing")),
        };
        vm.remove_global_ref(array_id);
        let token = bytes
            .split(|byte| *byte == 0)
            .next()
            .map(|slice| String::from_utf8_lossy(slice).trim().to_string())
            .unwrap_or_default();
        if let Some(base_dir) = self.shared.borrow().trace_path.parent() {
            let token_path = base_dir.join("h5_auth_info.txt");
            fs::write(&token_path, token.as_bytes())
                .with_context(|| format!("failed to write {}", token_path.display()))?;
        }
        self.shared.borrow_mut().trace(
            "call",
            &format!("GetH5AuthInfo ret={ret} len={}", token.len()),
        );
        Ok(token)
    }

    fn complete_captured_fc_init(&self) -> Result<()> {
        let captured = captured_fc_init_args()
            .lock()
            .expect("captured fc init args lock")
            .take()
            .ok_or_else(|| anyhow!("FC_initWithHeader capture missing"))?;
        self.shared.borrow_mut().trace(
            "mini_fc_init",
            &format!(
                "captured header=0x{:x} activeUserDomain={} natServers={}",
                captured.header_ptr, captured.active_user_domain, captured.nat_servers
            ),
        );

        let backend = self.emulator.backend.clone();
        let ccs_slot_addr = backend
            .mem_read_u64(self.native_symbols.funclib_base + FUNCLIB_GOT_CCSINF_SLOT)
            .context("failed to read CCSInf GOT slot")?;
        let g_binit_addr = backend
            .mem_read_u64(self.native_symbols.funclib_base + FUNCLIB_GOT_G_BINIT)
            .context("failed to read g_bInit GOT slot")?;
        let init_refcount_addr = backend
            .mem_read_u64(self.native_symbols.funclib_base + FUNCLIB_GOT_INIT_REFCOUNT)
            .context("failed to read init refcount GOT slot")?;
        self.shared.borrow_mut().trace(
            "mini_fc_init",
            &format!(
                "slots ccs=0x{:x} g_binit=0x{:x} init_refcount=0x{:x}",
                ccs_slot_addr, g_binit_addr, init_refcount_addr
            ),
        );

        self.emulator.memory().mem_map(
            MINI_INIT_CCSINF_ADDR,
            MINI_INIT_CCSINF_SIZE,
            (Permission::READ | Permission::WRITE).bits(),
            "seetong-mini-ccsinf".to_string(),
            0x1000,
        );
        self.shared.borrow_mut().trace(
            "mini_fc_init",
            &format!("mapped CCSInf scratch at 0x{:x}", MINI_INIT_CCSINF_ADDR),
        );
        backend
            .mem_write(MINI_INIT_CCSINF_ADDR, &vec![0u8; MINI_INIT_CCSINF_SIZE])
            .context("failed to clear mini CCSInf buffer")?;
        self.shared
            .borrow_mut()
            .trace("mini_fc_init", "cleared CCSInf scratch");

        self.emulator
            .e_func(
                self.native_symbols.ccsinf_ctor,
                vec![UnicornArg::Ptr(MINI_INIT_CCSINF_ADDR)],
            )
            .ok_or_else(|| anyhow!("CCSInf ctor returned no value"))?;
        self.shared
            .borrow_mut()
            .trace("mini_fc_init", "CCSInf ctor returned");
        backend
            .mem_write(ccs_slot_addr, &MINI_INIT_CCSINF_ADDR.to_le_bytes())
            .context("failed to publish CCSInf singleton")?;
        self.shared
            .borrow_mut()
            .trace("mini_fc_init", "published CCSInf singleton");
        self.emulator
            .e_func(
                self.native_symbols.ccsinf_set_http_header,
                vec![
                    UnicornArg::Ptr(MINI_INIT_CCSINF_ADDR),
                    UnicornArg::Ptr(captured.header_ptr),
                    UnicornArg::Str(captured.active_user_domain.clone()),
                ],
            )
            .ok_or_else(|| anyhow!("CCSInf::setHttpHeader returned no value"))?;
        self.shared
            .borrow_mut()
            .trace("mini_fc_init", "CCSInf::setHttpHeader returned");

        if runtime_env_truthy("RNIDBG_CAPTURE_FC_INIT_CALL_TPSRTC_INSTANCE") {
            self.emulator
                .e_func(self.native_symbols.tpsrtc_instance, vec![])
                .ok_or_else(|| anyhow!("TpsrtcWrap::Instance returned no value"))?;
        }
        if runtime_env_truthy("RNIDBG_CAPTURE_FC_INIT_CALL_TPSRTC_STARTUP") {
            self.emulator
                .e_func(
                    self.native_symbols.tpsrtc_startup,
                    vec![UnicornArg::Str(captured.nat_servers.clone())],
                )
                .ok_or_else(|| anyhow!("TpsrtcWrap::Startup returned no value"))?;
        }
        if runtime_env_truthy("RNIDBG_CAPTURE_FC_INIT_CALL_KEEP_LOGINING") {
            self.emulator
                .e_func(
                    self.native_symbols.ccsinf_keep_logining,
                    vec![UnicornArg::Ptr(MINI_INIT_CCSINF_ADDR)],
                )
                .ok_or_else(|| anyhow!("CCSInf::KeepLogining returned no value"))?;
        }
        if runtime_env_truthy("RNIDBG_CAPTURE_FC_INIT_CALL_CNETSDK_CTOR") {
            self.ensure_minimal_netsdk_initialized()?;
        }

        backend
            .mem_write(g_binit_addr, &[1])
            .context("failed to set g_bInit")?;
        backend
            .mem_write(init_refcount_addr, &1u32.to_le_bytes())
            .context("failed to set init refcount")?;
        self.shared.borrow_mut().trace(
            "mini_fc_init",
            &format!(
                "header=0x{:x} activeUserDomain={} natServers={} ccsSlot=0x{:x}",
                captured.header_ptr,
                captured.active_user_domain,
                captured.nat_servers,
                ccs_slot_addr,
            ),
        );
        Ok(())
    }

    fn ensure_minimal_netsdk_initialized(&self) -> Result<u64> {
        let backend = self.emulator.backend.clone();
        let netsdk_slot_addr = backend
            .mem_read_u64(self.native_symbols.funclib_base + FUNCLIB_GOT_NETSDK_SLOT)
            .context("failed to read NetSDK GOT slot")?;
        let mut instance = backend.mem_read_u64(netsdk_slot_addr).unwrap_or_default();
        if instance == 0 {
            self.emulator.memory().mem_map(
                MINI_INIT_NETSDK_ADDR,
                MINI_INIT_NETSDK_SIZE,
                (Permission::READ | Permission::WRITE).bits(),
                "seetong-mini-netsdk".to_string(),
                0x1000,
            );
            backend
                .mem_write(MINI_INIT_NETSDK_ADDR, &vec![0u8; MINI_INIT_NETSDK_SIZE])
                .context("failed to clear mini NetSDK buffer")?;
            self.emulator
                .e_func(
                    self.native_symbols.cnetsdk_ctor,
                    vec![UnicornArg::Ptr(MINI_INIT_NETSDK_ADDR)],
                )
                .ok_or_else(|| anyhow!("CNetSDKFunc ctor returned no value"))?;
            backend
                .mem_write(netsdk_slot_addr, &MINI_INIT_NETSDK_ADDR.to_le_bytes())
                .context("failed to publish NetSDK singleton")?;
            instance = MINI_INIT_NETSDK_ADDR;
            self.shared.borrow_mut().trace(
                "mini_netsdk",
                &format!(
                    "initialized netsdk slotAddr=0x{:x} instance=0x{:x}",
                    netsdk_slot_addr, instance
                ),
            );
        } else {
            self.shared.borrow_mut().trace(
                "mini_netsdk",
                &format!(
                    "reuse existing netsdk slotAddr=0x{:x} instance=0x{:x}",
                    netsdk_slot_addr, instance
                ),
            );
        }

        let skip_init_ex = runtime_env_truthy("RNIDBG_CNETSDK_SKIP_INIT_EX");
        let skip_init = runtime_env_truthy("RNIDBG_CNETSDK_SKIP_INIT");
        self.shared.borrow_mut().trace(
            "mini_netsdk",
            &format!(
                "about-to-init slotAddr=0x{:x} instance=0x{:x} skipInitEx={} skipInit={}",
                netsdk_slot_addr, instance, skip_init_ex, skip_init
            ),
        );
        let init_ex_ret = if skip_init_ex {
            i64::MIN as u64
        } else {
            self.shared
                .borrow_mut()
                .trace("mini_netsdk", "calling CNetSDKFunc::SDK_InitEx");
            let ret = self
                .emulator
                .e_func(
                    self.native_symbols.cnetsdk_init_ex,
                    vec![
                        UnicornArg::Ptr(instance),
                        UnicornArg::Str(DEFAULT_P2P_URL.to_string()),
                    ],
                )
                .unwrap_or(u64::MAX);
            self.shared.borrow_mut().trace(
                "mini_netsdk",
                &format!("returned CNetSDKFunc::SDK_InitEx ret={}", ret as i64),
            );
            ret
        };
        let init_ret = if skip_init {
            i64::MIN as u64
        } else {
            self.shared
                .borrow_mut()
                .trace("mini_netsdk", "calling CNetSDKFunc::SDK_Init");
            let ret = self
                .emulator
                .e_func(
                    self.native_symbols.cnetsdk_init,
                    vec![UnicornArg::Ptr(instance)],
                )
                .unwrap_or(u64::MAX);
            self.shared.borrow_mut().trace(
                "mini_netsdk",
                &format!("returned CNetSDKFunc::SDK_Init ret={}", ret as i64),
            );
            ret
        };
        let slot_value = backend.mem_read_u64(netsdk_slot_addr).unwrap_or_default();
        self.shared.borrow_mut().trace(
            "mini_netsdk",
            &format!(
                "post-init slotAddr=0x{:x} slotValue=0x{:x} initExRet={} initRet={}",
                netsdk_slot_addr, slot_value, init_ex_ret as i64, init_ret as i64
            ),
        );
        Ok(slot_value)
    }

    fn redirect_access_node(&self) -> Result<()> {
        let (cached_json, last_error) = {
            let state = siot_access_node_stub_state()
                .lock()
                .expect("siot access node stub state lock");
            (state.cached_json.clone(), state.last_error.clone())
        };
        let Some(json_text) = cached_json else {
            let reason = last_error.unwrap_or_else(|| "access-node not prefetched".to_string());
            self.shared
                .borrow_mut()
                .trace("redirect_access", &format!("skipped: {reason}"));
            return Ok(());
        };
        let backend = self.emulator.backend.clone();
        self.emulator.memory().mem_map(
            ACCESS_REDIRECT_STRING_ADDR,
            ACCESS_REDIRECT_STRING_SIZE,
            (Permission::READ | Permission::WRITE).bits(),
            "seetong-access-redirect".to_string(),
            0x1000,
        );
        backend
            .mem_write(
                ACCESS_REDIRECT_STRING_ADDR,
                &vec![0u8; ACCESS_REDIRECT_STRING_SIZE],
            )
            .context("failed to clear access redirect scratch")?;
        write_guest_long_cpp_string(&self.emulator, ACCESS_REDIRECT_STRING_ADDR, &json_text)?;
        let instance = self
            .emulator
            .e_func(self.native_symbols.tpsrtc_instance, vec![])
            .ok_or_else(|| anyhow!("TpsrtcWrap::Instance returned no value"))?;
        self.emulator
            .e_func(
                self.native_symbols.tpsrtc_redirect_access,
                vec![
                    UnicornArg::Ptr(instance),
                    UnicornArg::Ptr(ACCESS_REDIRECT_STRING_ADDR),
                ],
            )
            .ok_or_else(|| anyhow!("TpsrtcWrap::RedirectAccess returned no value"))?;
        let preview: Value = serde_json::from_str(&json_text).unwrap_or(Value::Null);
        let access_node = preview
            .get("accessNode")
            .and_then(Value::as_str)
            .unwrap_or("");
        let relay_count = preview
            .get("relayNodes")
            .and_then(Value::as_array)
            .map(|items| items.len())
            .unwrap_or(0);
        self.shared.borrow_mut().trace(
            "redirect_access",
            &format!("accessNode={} relayCount={}", access_node, relay_count),
        );
        Ok(())
    }

    fn trace_session_object(&self, cloud_id: &str, stream_no: i32, stage: &str) {
        let found = find_ccs_device_object(&self.emulator, MINI_INIT_CCSINF_ADDR, cloud_id);
        match found {
            Some((node_ptr, object_ptr)) if object_ptr != 0 => {
                let vtable = self.emulator.backend.mem_read_u64(object_ptr).unwrap_or(0);
                let slot32 = if vtable != 0 {
                    self.emulator.backend.mem_read_u64(vtable + 32).unwrap_or(0)
                } else {
                    0
                };
                let slot88 = if vtable != 0 {
                    self.emulator.backend.mem_read_u64(vtable + 88).unwrap_or(0)
                } else {
                    0
                };
                let slot376 = if vtable != 0 {
                    self.emulator
                        .backend
                        .mem_read_u64(vtable + 376)
                        .unwrap_or(0)
                } else {
                    0
                };
                let field24 = self
                    .emulator
                    .backend
                    .mem_read_u64(object_ptr + 24)
                    .unwrap_or(0);
                self.shared.borrow_mut().trace(
                    "session_object",
                    &format!(
                        "{} cloudId={} node=0x{:x} obj=0x{:x} vtable=0x{:x} slot32=0x{:x} slot88=0x{:x} slot376=0x{:x} field24=0x{:x}",
                        stage, cloud_id, node_ptr, object_ptr, vtable, slot32, slot88, slot376, field24
                    ),
                );
                if self.is_sold_device_object(slot32) {
                    self.trace_sold_fallback_session(object_ptr, cloud_id, stage);
                    self.trace_sold_nvr_watch_session(object_ptr, cloud_id, stream_no, stage);
                }
            }
            Some((node_ptr, _)) => {
                self.shared.borrow_mut().trace(
                    "session_object",
                    &format!("{stage} cloudId={cloud_id} node=0x{node_ptr:x} obj=0x0"),
                );
            }
            None => {
                self.shared.borrow_mut().trace(
                    "session_object",
                    &format!("{stage} cloudId={cloud_id} not_found"),
                );
            }
        }
    }

    fn is_sold_device_object(&self, slot32: u64) -> bool {
        self.native_symbols
            .trace_resume_variants
            .iter()
            .any(|(name, address)| name == "_ZN10SoldDevice12ResumeDevComEv" && *address == slot32)
    }

    fn trace_sold_nvr_watch_session(
        &self,
        sold_device_ptr: u64,
        cloud_id: &str,
        stream_no: i32,
        stage: &str,
    ) {
        match find_sold_nvr_watch_session(&self.emulator, sold_device_ptr, stream_no) {
            Some((node_ptr, holder_ptr, session_ptr)) => {
                let holder_busy = read_guest_u8(&self.emulator, holder_ptr + 72);
                let holder_ref = self
                    .emulator
                    .backend
                    .mem_read_i32(holder_ptr + 76)
                    .unwrap_or_default();
                self.shared.borrow_mut().trace(
                    "nvr_watch_session",
                    &format!(
                        "{} cloudId={} streamNo={} sold=0x{:x} node=0x{:x} holder=0x{:x} holderBusy={} holderRef={}",
                        stage,
                        cloud_id,
                        stream_no,
                        sold_device_ptr,
                        node_ptr,
                        holder_ptr,
                        holder_busy,
                        holder_ref
                    ),
                );
                self.trace_guest_session_vtable("nvr_watch_session_vtable", stage, session_ptr);
            }
            None => {
                self.shared.borrow_mut().trace(
                    "nvr_watch_session",
                    &format!(
                        "{} cloudId={} streamNo={} sold=0x{:x} not_found",
                        stage, cloud_id, stream_no, sold_device_ptr
                    ),
                );
            }
        }
    }

    fn trace_sold_fallback_session(&self, sold_device_ptr: u64, cloud_id: &str, stage: &str) {
        let field136 = self
            .emulator
            .backend
            .mem_read_u64(sold_device_ptr + 136)
            .unwrap_or_default();
        if field136 < 8 {
            self.shared.borrow_mut().trace(
                "sold_fallback_session",
                &format!(
                    "{} cloudId={} sold=0x{:x} field136=0x{:x} not_found",
                    stage, cloud_id, sold_device_ptr, field136
                ),
            );
            return;
        }
        let session_ptr = field136 - 8;
        self.shared.borrow_mut().trace(
            "sold_fallback_session",
            &format!(
                "{} cloudId={} sold=0x{:x} field136=0x{:x} session=0x{:x}",
                stage, cloud_id, sold_device_ptr, field136, session_ptr
            ),
        );
        self.trace_cp2p_identity("sold_fallback_identity", stage, session_ptr);
        self.trace_guest_session_vtable("sold_fallback_vtable", stage, session_ptr);
        self.trace_cp2p_send_queue("sold_fallback_send_queue", stage, session_ptr);
    }

    fn trace_guest_session_vtable(&self, tag: &str, stage: &str, session_ptr: u64) {
        let session_vtable = self
            .emulator
            .backend
            .mem_read_u64(session_ptr)
            .unwrap_or_default();
        let slot24 = if session_vtable != 0 {
            self.emulator
                .backend
                .mem_read_u64(session_vtable + 24)
                .unwrap_or_default()
        } else {
            0
        };
        let slot176 = if session_vtable != 0 {
            self.emulator
                .backend
                .mem_read_u64(session_vtable + 176)
                .unwrap_or_default()
        } else {
            0
        };
        let slot184 = if session_vtable != 0 {
            self.emulator
                .backend
                .mem_read_u64(session_vtable + 184)
                .unwrap_or_default()
        } else {
            0
        };
        let slot192 = if session_vtable != 0 {
            self.emulator
                .backend
                .mem_read_u64(session_vtable + 192)
                .unwrap_or_default()
        } else {
            0
        };
        let slot200 = if session_vtable != 0 {
            self.emulator
                .backend
                .mem_read_u64(session_vtable + 200)
                .unwrap_or_default()
        } else {
            0
        };
        let slot304 = if session_vtable != 0 {
            self.emulator
                .backend
                .mem_read_u64(session_vtable + 304)
                .unwrap_or_default()
        } else {
            0
        };
        let field24 = self
            .emulator
            .backend
            .mem_read_u64(session_ptr + 24)
            .unwrap_or_default();
        self.shared.borrow_mut().trace(
            tag,
            &format!(
                "{} session=0x{:x} vtable=0x{:x} slot24=0x{:x} slot176=0x{:x} slot184=0x{:x} slot192=0x{:x} slot200=0x{:x} slot304=0x{:x} field24=0x{:x}",
                stage,
                session_ptr,
                session_vtable,
                slot24,
                slot176,
                slot184,
                slot192,
                slot200,
                slot304,
                field24
            ),
        );
    }

    fn trace_cp2p_send_queue(&self, tag: &str, stage: &str, session_ptr: u64) {
        let sentinel = session_ptr + 5080;
        let tail = self
            .emulator
            .backend
            .mem_read_u64(sentinel)
            .unwrap_or_default();
        let head = self
            .emulator
            .backend
            .mem_read_u64(sentinel + 8)
            .unwrap_or_default();
        let count = self
            .emulator
            .backend
            .mem_read_u64(session_ptr + 5096)
            .unwrap_or_default();
        self.shared.borrow_mut().trace(
            tag,
            &format!(
                "{} session=0x{:x} sentinel=0x{:x} head=0x{:x} tail=0x{:x} count={}",
                stage, session_ptr, sentinel, head, tail, count
            ),
        );
        let mut node = head;
        let mut seen = HashSet::new();
        let mut index = 0usize;
        while node != 0 && node != sentinel && seen.insert(node) && index < 4 {
            let next = self
                .emulator
                .backend
                .mem_read_u64(node + 8)
                .unwrap_or_default();
            let meta = self
                .emulator
                .backend
                .mem_read_u64(node + 16)
                .unwrap_or_default();
            let payload_ptr = self
                .emulator
                .backend
                .mem_read_u64(node + 24)
                .unwrap_or_default();
            let kind = meta as u32;
            let payload_len = (meta >> 32) as usize;
            let payload = read_guest_bytes(&self.emulator, payload_ptr, payload_len.min(2048));
            let preview = preview_ascii_bytes(&payload, 1024);
            self.shared.borrow_mut().trace(
                tag,
                &format!(
                    "{}[{}] node=0x{:x} next=0x{:x} kind={} payloadLen={} payloadPtr=0x{:x} preview={}",
                    stage,
                    index,
                    node,
                    next,
                    kind,
                    payload_len,
                    payload_ptr,
                    preview
                ),
            );
            node = next;
            index += 1;
        }
    }

    fn trace_cp2p_identity(&self, tag: &str, stage: &str, session_ptr: u64) {
        let dev_tag = read_guest_c_string_limited(&self.emulator, session_ptr + 0x150, 128);
        let user = read_guest_c_string_limited(&self.emulator, session_ptr + 0x250, 128);
        let server = read_guest_c_string_limited(&self.emulator, session_ptr + 0x350, 256);
        let relay = read_guest_c_string_limited(&self.emulator, session_ptr + 0x450, 256);
        let password_len =
            read_guest_c_string_limited(&self.emulator, session_ptr + 0x2d0, 128).len();
        self.shared.borrow_mut().trace(
            tag,
            &format!(
                "{} session=0x{:x} devTag='{}' user='{}' passwordLen={} server='{}' relay='{}'",
                stage, session_ptr, dev_tag, user, password_len, server, relay
            ),
        );
    }

    fn trace_cp2p_runtime_state(&self, tag: &str, stage: &str, session_ptr: u64) {
        let conn = self
            .emulator
            .backend
            .mem_read_i32(session_ptr + 0x140)
            .unwrap_or_default();
        let peer = self
            .emulator
            .backend
            .mem_read_i32(session_ptr + 0x144)
            .unwrap_or_default();
        let state = self
            .emulator
            .backend
            .mem_read_i32(session_ptr + 0x148)
            .unwrap_or_default();
        let loop_tick = self
            .emulator
            .backend
            .mem_read_u64(session_ptr + 0x1490)
            .unwrap_or_default();
        let low_power = self
            .emulator
            .backend
            .mem_read_i32(session_ptr + 0x14b0)
            .unwrap_or_default();
        let cancel = read_guest_u8(&self.emulator, session_ptr + 0x650);
        let worker_done = self
            .emulator
            .backend
            .mem_read_i32(session_ptr + 0x14dc)
            .unwrap_or_default();
        let err_code = read_guest_u16(&self.emulator, session_ptr + 0x12e0);
        let err_text = read_guest_c_string_limited(&self.emulator, session_ptr + 0x12e2, 96);
        self.shared.borrow_mut().trace(
            tag,
            &format!(
                "{} session=0x{:x} conn={} peer={} state={} loopTick={} lowPower={} cancel={} workerDone={} errCode=0x{:04x} errText='{}'",
                stage,
                session_ptr,
                conn,
                peer,
                state,
                loop_tick,
                low_power,
                cancel,
                worker_done,
                err_code,
                err_text
            ),
        );
    }

    fn trace_hidden_p2p_pool_state(&self, tag: &str, stage: &str) {
        let base = self.native_symbols.funclib_base;
        let global = base + HIDDEN_P2P_POOL_OFFSET;
        let ctor_state = self
            .emulator
            .backend
            .mem_read_i32(global + 0x18)
            .unwrap_or_default();
        let ready_flag = self
            .emulator
            .backend
            .mem_read_i32(global + HIDDEN_P2P_POOL_READY_OFFSET)
            .unwrap_or_default();
        let state_word = self
            .emulator
            .backend
            .mem_read_i32(global + 0x08)
            .unwrap_or_default();
        let free_head = self
            .emulator
            .backend
            .mem_read_u64(base + HIDDEN_P2P_FREE_HEAD_OFFSET)
            .unwrap_or_default();
        let free_tail = self
            .emulator
            .backend
            .mem_read_u64(base + HIDDEN_P2P_FREE_TAIL_OFFSET)
            .unwrap_or_default();
        let busy_head = self
            .emulator
            .backend
            .mem_read_u64(base + HIDDEN_P2P_BUSY_HEAD_OFFSET)
            .unwrap_or_default();
        let busy_tail = self
            .emulator
            .backend
            .mem_read_u64(base + HIDDEN_P2P_BUSY_TAIL_OFFSET)
            .unwrap_or_default();
        let free_head_short = if free_head != 0 {
            read_guest_u16(&self.emulator, free_head + 0x18)
        } else {
            0
        };
        let free_head_obj = if free_head != 0 {
            self.emulator
                .backend
                .mem_read_u64(free_head + 0x20)
                .unwrap_or_default()
        } else {
            0
        };
        let busy_head_short = if busy_head != 0 {
            read_guest_u16(&self.emulator, busy_head + 0x18)
        } else {
            0
        };
        let busy_head_obj = if busy_head != 0 {
            self.emulator
                .backend
                .mem_read_u64(busy_head + 0x20)
                .unwrap_or_default()
        } else {
            0
        };
        self.shared.borrow_mut().trace(
            tag,
            &format!(
                "{} global=0x{:x} ctorState={} readyFlag={} stateWord={} freeHead=0x{:x} freeTail=0x{:x} busyHead=0x{:x} busyTail=0x{:x} freeHeadShort=0x{:04x} freeHeadObj=0x{:x} busyHeadShort=0x{:04x} busyHeadObj=0x{:x}",
                stage,
                global,
                ctor_state,
                ready_flag,
                state_word,
                free_head,
                free_tail,
                busy_head,
                busy_tail,
                free_head_short,
                free_head_obj,
                busy_head_short,
                busy_head_obj
            ),
        );
    }

    fn ensure_hidden_p2p_pool_initialized(&self, tag: &str) {
        let base = self.native_symbols.funclib_base;
        let global = base + HIDDEN_P2P_POOL_OFFSET;
        let mut ready_flag = self
            .emulator
            .backend
            .mem_read_i32(global + HIDDEN_P2P_POOL_READY_OFFSET)
            .unwrap_or_default();
        let mut free_head = self
            .emulator
            .backend
            .mem_read_u64(base + HIDDEN_P2P_FREE_HEAD_OFFSET)
            .unwrap_or_default();
        if free_head != 0 && ready_flag != 0 {
            self.shared.borrow_mut().trace(
                tag,
                &format!(
                    "skip hidden pool init global=0x{:x} readyFlag={} freeHead=0x{:x}",
                    global, ready_flag, free_head
                ),
            );
            return;
        }
        let mut static_ret = i64::MIN;
        if free_head == 0 {
            static_ret = self
                .emulator
                .e_func(base + HIDDEN_P2P_GLOBAL_INIT_OFFSET, vec![])
                .unwrap_or(u64::MAX) as i64;
            ready_flag = self
                .emulator
                .backend
                .mem_read_i32(global + HIDDEN_P2P_POOL_READY_OFFSET)
                .unwrap_or_default();
            free_head = self
                .emulator
                .backend
                .mem_read_u64(base + HIDDEN_P2P_FREE_HEAD_OFFSET)
                .unwrap_or_default();
        }
        let ctor_arg = global + 0x10;
        let mut ready_ret = i64::MIN;
        if ready_flag == 0 {
            ready_ret = self
                .emulator
                .e_func(
                    base + HIDDEN_P2P_POOL_INIT_OFFSET,
                    vec![UnicornArg::Ptr(ctor_arg)],
                )
                .unwrap_or(u64::MAX) as i64;
            ready_flag = self
                .emulator
                .backend
                .mem_read_i32(global + HIDDEN_P2P_POOL_READY_OFFSET)
                .unwrap_or_default();
            free_head = self
                .emulator
                .backend
                .mem_read_u64(base + HIDDEN_P2P_FREE_HEAD_OFFSET)
                .unwrap_or_default();
        }
        self.shared.borrow_mut().trace(
            tag,
            &format!(
                "hidden pool init globalCtor=0x{:x} globalCtorRet={} readyCtor=0x{:x} arg=0x{:x} readyRet={} readyFlag={} freeHead=0x{:x}",
                base + HIDDEN_P2P_GLOBAL_INIT_OFFSET,
                static_ret,
                base + HIDDEN_P2P_POOL_INIT_OFFSET,
                ctor_arg,
                ready_ret,
                ready_flag,
                free_head
            ),
        );
    }

    fn ensure_low_page_mapped(&self, tag: &str) {
        const LOW_PAGE_SIZE: usize = 0x2000;
        const RET_INSN: [u8; 4] = [0xc0, 0x03, 0x5f, 0xd6];
        let perms = (Permission::READ | Permission::WRITE | Permission::EXEC).bits();
        if self.emulator.backend.mem_read_as_vec(0, 16).is_err() {
            self.emulator.memory().mem_map(
                0,
                LOW_PAGE_SIZE,
                perms,
                "seetong-null-page".to_string(),
                0x1000,
            );
        }
        let mut sled = vec![0u8; LOW_PAGE_SIZE];
        for chunk in sled.chunks_exact_mut(4) {
            chunk.copy_from_slice(&RET_INSN);
        }
        let _ = self.emulator.backend.mem_write(0, &sled);
        self.shared
            .borrow_mut()
            .trace(tag, "map low page ok with ret sled");
    }

    fn ensure_zero_page_mapped(&self, tag: &str) {
        const ZERO_PAGE_SIZE: usize = 0x2000;
        let perms = (Permission::READ | Permission::WRITE | Permission::EXEC).bits();
        if self.emulator.backend.mem_read_as_vec(0, 16).is_err() {
            self.emulator.memory().mem_map(
                0,
                ZERO_PAGE_SIZE,
                perms,
                "seetong-zero-page".to_string(),
                0x1000,
            );
        }
        let zeros = vec![0u8; ZERO_PAGE_SIZE];
        let _ = self.emulator.backend.mem_write(0, &zeros);
        self.shared
            .borrow_mut()
            .trace(tag, "map zero page ok with zero fill");
    }

    fn sold_fallback_session_ptr(&self, cloud_id: &str) -> Option<(u64, u64)> {
        let (_, sold_ptr) =
            find_ccs_device_object(&self.emulator, MINI_INIT_CCSINF_ADDR, cloud_id)?;
        if sold_ptr == 0 {
            return None;
        }
        let field136 = self
            .emulator
            .backend
            .mem_read_u64(sold_ptr + 136)
            .unwrap_or_default();
        if field136 < 8 {
            return None;
        }
        Some((sold_ptr, field136 - 8))
    }

    fn collect_cp2p_send_queue_entries(&self, session_ptr: u64) -> Vec<QueuedSendEntry> {
        let sentinel = session_ptr + 5080;
        let mut node = self
            .emulator
            .backend
            .mem_read_u64(sentinel + 8)
            .unwrap_or_default();
        let mut seen = HashSet::new();
        let mut out = Vec::new();
        while node != 0 && node != sentinel && seen.insert(node) && out.len() < 16 {
            let next = self
                .emulator
                .backend
                .mem_read_u64(node + 8)
                .unwrap_or_default();
            let meta = self
                .emulator
                .backend
                .mem_read_u64(node + 16)
                .unwrap_or_default();
            let payload_ptr = self
                .emulator
                .backend
                .mem_read_u64(node + 24)
                .unwrap_or_default();
            out.push(QueuedSendEntry {
                node_ptr: node,
                kind: meta as u32,
                payload_ptr,
                payload_len: (meta >> 32) as usize,
            });
            node = next;
        }
        out
    }

    fn sync_loc_realplay_callback_stats(&self) {
        let state = loc_realplay_callback_state()
            .lock()
            .expect("loc realplay callback state lock")
            .clone();
        let mut shared = self.shared.borrow_mut();
        shared.video_frames += state.video_frames;
        shared.audio_frames += state.audio_frames;
        shared.video_bytes += state.video_bytes;
        shared.audio_bytes += state.audio_bytes;
        shared.trace(
            "loc_realplay",
            &format!(
                "callback stats videoFrames={} audioFrames={} videoBytes={} audioBytes={}",
                state.video_frames, state.audio_frames, state.video_bytes, state.audio_bytes
            ),
        );
    }

    fn inject_blackbox_video_sample(&self, dev_id: &str) -> Result<bool> {
        let Some(path) = std::env::var("RNIDBG_BLACKBOX_VIDEO_ES")
            .ok()
            .filter(|value| !value.trim().is_empty())
        else {
            return Ok(false);
        };
        let sample_path = PathBuf::from(path);
        let payload = fs::read(&sample_path).with_context(|| {
            format!(
                "failed to read blackbox video sample: {}",
                sample_path.display()
            )
        })?;
        if payload.is_empty() {
            return Err(anyhow!(
                "blackbox video sample is empty: {}",
                sample_path.display()
            ));
        }
        let mut shared = self.shared.borrow_mut();
        shared.trace(
            "blackbox_media",
            &format!(
                "inject sample path={} bytes={} devId={}",
                sample_path.display(),
                payload.len(),
                dev_id
            ),
        );
        shared.write_video_frame_with_seetong_trailer(&payload, 1, 0.0, dev_id)?;
        Ok(true)
    }

    fn manual_drive_loc_realplay(
        &self,
        _object: &DvmObject,
        seed: &SeetongSeed,
        capture_ms: u64,
    ) -> Result<LocRealPlayRunResult> {
        let record = seed
            .device_json
            .as_array()
            .and_then(|items| {
                items.iter().find(|item| {
                    item.get("devId")
                        .map(|value| value.to_string().trim_matches('"').to_string())
                        == Some(seed.watch.cloud_id.clone())
                })
            })
            .or_else(|| seed.device_json.as_array().and_then(|items| items.first()))
            .ok_or_else(|| anyhow!("deviceJson missing target record"))?;
        let dev_id = record
            .get("devId")
            .map(|value| value.to_string().trim_matches('"').to_string())
            .unwrap_or_else(|| seed.watch.cloud_id.clone());
        let dev_ip = std::env::var("RNIDBG_LOC_IP")
            .ok()
            .filter(|value| !value.trim().is_empty())
            .or_else(|| {
                record
                    .get("devIp")
                    .and_then(Value::as_str)
                    .map(str::to_string)
            })
            .ok_or_else(|| anyhow!("missing RNIDBG_LOC_IP and deviceJson.devIp"))?;
        let username = std::env::var("RNIDBG_LOC_USER")
            .ok()
            .filter(|value| !value.trim().is_empty())
            .ok_or_else(|| anyhow!("missing RNIDBG_LOC_USER"))?;
        let password = std::env::var("RNIDBG_LOC_PASS")
            .ok()
            .filter(|value| !value.trim().is_empty())
            .ok_or_else(|| anyhow!("missing RNIDBG_LOC_PASS"))?;
        let login_port = std::env::var("RNIDBG_LOC_LOGIN_PORT")
            .ok()
            .and_then(|value| value.parse::<i32>().ok())
            .unwrap_or(8091);
        let video_port = std::env::var("RNIDBG_LOC_VIDEO_PORT")
            .ok()
            .and_then(|value| value.parse::<i32>().ok())
            .unwrap_or(554);
        let channel = std::env::var("RNIDBG_LOC_CHANNEL")
            .ok()
            .and_then(|value| value.parse::<i32>().ok())
            .unwrap_or(seed.watch.stream_no);
        let iface = std::env::var("RNIDBG_LOC_IFACE").unwrap_or_default();
        let url = std::env::var("RNIDBG_LOC_URL").unwrap_or_else(|_| format!("tps://{dev_ip}"));
        configure_loc_realplay_callback(&self.shared.borrow(), &dev_id);
        if runtime_env_truthy("RNIDBG_BLACKBOX_LOC_LOGIN_DEV")
            && runtime_env_truthy("RNIDBG_BLACKBOX_LOC_REALPLAY_EX")
        {
            self.shared.borrow_mut().trace(
                "loc_realplay",
                &format!(
                    "early blackbox path devId={} ip={} url={}",
                    dev_id, dev_ip, url
                ),
            );
            let injected = self.inject_blackbox_video_sample(&dev_id)?;
            thread::sleep(Duration::from_millis(if injected {
                100
            } else {
                capture_ms.max(3_000)
            }));
            self.sync_loc_realplay_callback_stats();
            return Ok(LocRealPlayRunResult {
                login_handle: 1,
                play_handle: 1,
                stop_ret: 0,
                logout_ret: 0,
            });
        }
        let netsdk_instance = self.ensure_minimal_netsdk_initialized()?;
        let netsdk_slot_addr = self
            .emulator
            .backend
            .mem_read_u64(self.native_symbols.funclib_base + FUNCLIB_GOT_NETSDK_SLOT)
            .unwrap_or_default();
        self.shared.borrow_mut().trace(
            "loc_realplay",
            &format!(
                "netsdk slotAddr=0x{:x} instance=0x{:x}",
                netsdk_slot_addr, netsdk_instance
            ),
        );

        let ip_ptr = write_guest_c_string_buffer(&self.emulator, &dev_ip)?;
        let user_ptr = write_guest_c_string_buffer(&self.emulator, &username)?;
        let pass_ptr = write_guest_c_string_buffer(&self.emulator, &password)?;
        let iface_ptr = write_guest_c_string_buffer(&self.emulator, &iface)?;

        self.shared.borrow_mut().trace(
            "loc_realplay",
            &format!(
                "FC_Loc_LoginDev ip={} loginPort={} user={} iface='{}' blackbox={}",
                dev_ip,
                login_port,
                username,
                iface,
                runtime_env_truthy("RNIDBG_BLACKBOX_LOC_LOGIN_DEV")
            ),
        );
        let login_handle = if runtime_env_truthy("RNIDBG_BLACKBOX_LOC_LOGIN_DEV") {
            1
        } else {
            self.emulator
                .e_func(
                    self.native_symbols.fc_loc_login_dev,
                    vec![
                        UnicornArg::Ptr(ip_ptr),
                        UnicornArg::U64(login_port as u64),
                        UnicornArg::Ptr(user_ptr),
                        UnicornArg::Ptr(pass_ptr),
                        UnicornArg::Ptr(0),
                        UnicornArg::Ptr(iface_ptr),
                        UnicornArg::U64(u32::MAX as u64),
                    ],
                )
                .unwrap_or(0) as i64
        };
        if login_handle <= 0 {
            return Err(anyhow!("FC_Loc_LoginDev failed: {login_handle}"));
        }
        self.shared.borrow_mut().trace(
            "loc_realplay",
            &format!("FC_Loc_LoginDev ret={login_handle}"),
        );

        let url_ptr = write_guest_c_string_buffer(&self.emulator, &url)?;
        let video_info = self
            .emulator
            .falloc(16, false)
            .context("failed to allocate NetSDK_USER_VIDEOINFO")?;
        self.emulator
            .backend
            .mem_write(video_info.addr, &video_port.to_le_bytes())
            .context("failed to write video port")?;
        self.emulator
            .backend
            .mem_write(video_info.addr + 4, &(1i32).to_le_bytes())
            .context("failed to write tcp flag")?;
        self.emulator
            .backend
            .mem_write(video_info.addr + 8, &channel.to_le_bytes())
            .context("failed to write video channel")?;

        let agent_callback_slot = self.native_symbols.funclib_agent_base
            + FUNCLIB_AGENT_LOC_REALPLAY_CALLBACK_SLOT_OFFSET;
        let agent_callback_ctx = self
            .emulator
            .backend
            .mem_read_u64(agent_callback_slot)
            .unwrap_or_default();
        self.shared.borrow_mut().trace(
            "loc_realplay",
            &format!(
                "FC_Loc_RealPlayEx ctx slot=0x{:x} value=0x{:x}",
                agent_callback_slot, agent_callback_ctx
            ),
        );
        self.shared.borrow_mut().trace(
            "loc_realplay",
            &format!(
                "FC_Loc_RealPlayEx url={} videoPort={} channel={} ctx=0x{:x} blackbox={}",
                url,
                video_port,
                channel,
                agent_callback_ctx,
                runtime_env_truthy("RNIDBG_BLACKBOX_LOC_REALPLAY_EX")
            ),
        );
        let play_handle = if runtime_env_truthy("RNIDBG_BLACKBOX_LOC_REALPLAY_EX") {
            1
        } else {
            self.emulator
                .e_func(
                    self.native_symbols.fc_loc_real_play_ex,
                    vec![
                        UnicornArg::U64(login_handle as u64),
                        UnicornArg::Ptr(url_ptr),
                        UnicornArg::Ptr(user_ptr),
                        UnicornArg::Ptr(pass_ptr),
                        UnicornArg::Ptr(agent_callback_ctx),
                        UnicornArg::Ptr(video_info.addr),
                        UnicornArg::Ptr(iface_ptr),
                    ],
                )
                .unwrap_or(0) as i64
        };
        if play_handle <= 0 {
            let logout_ret = self
                .emulator
                .e_func(
                    self.native_symbols.fc_loc_logout_dev,
                    vec![UnicornArg::U64(login_handle as u64)],
                )
                .unwrap_or(u64::MAX) as i32;
            return Err(anyhow!(
                "FC_Loc_RealPlayEx failed: {} (logoutRet={logout_ret})",
                play_handle
            ));
        }
        self.shared.borrow_mut().trace(
            "loc_realplay",
            &format!("FC_Loc_RealPlayEx ret={play_handle}"),
        );

        let injected = self.inject_blackbox_video_sample(&dev_id)?;
        let wait_ms = if injected { 100 } else { capture_ms.max(3_000) };
        thread::sleep(Duration::from_millis(wait_ms));
        let stop_ret = if runtime_env_truthy("RNIDBG_BLACKBOX_LOC_REALPLAY_EX") {
            0
        } else {
            self.emulator
                .e_func(
                    self.native_symbols.fc_loc_stop_real_play,
                    vec![UnicornArg::U64(play_handle as u64)],
                )
                .unwrap_or(u64::MAX) as i64
        };
        let logout_ret = if runtime_env_truthy("RNIDBG_BLACKBOX_LOC_LOGIN_DEV") {
            0
        } else {
            self.emulator
                .e_func(
                    self.native_symbols.fc_loc_logout_dev,
                    vec![UnicornArg::U64(login_handle as u64)],
                )
                .unwrap_or(u64::MAX) as i32
        };
        self.shared.borrow_mut().trace(
            "loc_realplay",
            &format!(
                "cleanup playHandle={} stopRet={} logoutRet={} injected={}",
                play_handle, stop_ret, logout_ret, injected
            ),
        );
        self.sync_loc_realplay_callback_stats();
        Ok(LocRealPlayRunResult {
            login_handle,
            play_handle,
            stop_ret,
            logout_ret,
        })
    }

    fn manual_drive_cp2p_session(&self, cloud_id: &str, capture_ms: u64) -> Result<()> {
        let Some((sold_ptr, session_ptr)) = self.sold_fallback_session_ptr(cloud_id) else {
            self.shared.borrow_mut().trace(
                "manual_cp2p",
                &format!("cloudId={} sold fallback session not found", cloud_id),
            );
            return Ok(());
        };
        self.shared.borrow_mut().trace(
            "manual_cp2p",
            &format!(
                "cloudId={} sold=0x{:x} session=0x{:x} begin",
                cloud_id, sold_ptr, session_ptr
            ),
        );
        self.ensure_zero_page_mapped("manual_cp2p");
        let sold_vtable = self
            .emulator
            .backend
            .mem_read_u64(sold_ptr)
            .unwrap_or_default();
        let sold_awaken = if sold_vtable != 0 {
            self.emulator
                .backend
                .mem_read_u64(sold_vtable + 376)
                .unwrap_or_default()
        } else {
            0
        };
        let sold_awaken_ret = if sold_awaken != 0 {
            self.emulator
                .e_func(sold_awaken, vec![UnicornArg::Ptr(sold_ptr)])
                .unwrap_or(u64::MAX)
        } else {
            u64::MAX
        };
        self.emulator
            .backend
            .mem_write(session_ptr + 0x650, &[0])
            .context("failed to clear CP2PStream cancel flag")?;
        self.emulator
            .backend
            .mem_write(session_ptr + 0x14dc, &(0i32).to_le_bytes())
            .context("failed to clear CP2PStream workerDone flag")?;
        let preconnect_ret = self
            .emulator
            .e_func(
                self.native_symbols.cp2p_preconnect_media_channel,
                vec![UnicornArg::Ptr(session_ptr)],
            )
            .unwrap_or(u64::MAX);
        let awaken_ret = self
            .emulator
            .e_func(
                self.native_symbols.cp2p_awaken_dev,
                vec![UnicornArg::Ptr(session_ptr)],
            )
            .unwrap_or(u64::MAX);
        self.shared.borrow_mut().trace(
            "manual_cp2p",
            &format!(
                "cloudId={} soldAwaken=0x{:x} soldAwakenRet={} preconnectRet={} awakenRet={}",
                cloud_id,
                sold_awaken,
                sold_awaken_ret as i64,
                preconnect_ret as i64,
                awaken_ret as i64
            ),
        );
        self.ensure_hidden_p2p_pool_initialized("manual_cp2p");
        self.trace_cp2p_identity("manual_cp2p_identity", "begin", session_ptr);
        self.trace_cp2p_runtime_state("manual_cp2p_state", "begin", session_ptr);
        self.trace_hidden_p2p_pool_state("manual_cp2p_pool", "begin");
        if runtime_env_truthy("RNIDBG_BLACKBOX_P2P_STREAM") {
            let injected = self.inject_blackbox_video_sample(cloud_id)?;
            self.shared.borrow_mut().trace(
                "manual_cp2p",
                &format!(
                    "cloudId={} blackbox p2p fallback injected={}",
                    cloud_id, injected
                ),
            );
            self.emulator
                .backend
                .mem_write(session_ptr + 0x650, &[1])
                .context("failed to restore CP2PStream cancel flag after blackbox fallback")?;
            self.emulator
                .backend
                .mem_write(session_ptr + 0x14dc, &(1i32).to_le_bytes())
                .context("failed to restore CP2PStream workerDone flag after blackbox fallback")?;
            self.trace_cp2p_runtime_state("manual_cp2p_state", "blackbox_end", session_ptr);
            return Ok(());
        }

        if runtime_env_truthy("RNIDBG_SKIP_OPEN_P2P") {
            self.emulator
                .backend
                .mem_write(session_ptr + 0x140, &(1i32).to_le_bytes())
                .context("failed to force CP2PStream conn ready")?;
            self.emulator
                .backend
                .mem_write(session_ptr + 0x144, &(1i32).to_le_bytes())
                .context("failed to force CP2PStream peer ready")?;
            self.emulator
                .backend
                .mem_write(session_ptr + 0x148, &(1i32).to_le_bytes())
                .context("failed to force CP2PStream state ready")?;
            self.shared.borrow_mut().trace(
                "manual_cp2p",
                &format!(
                    "cloudId={} skipped OpenP2P and forced conn/peer/state ready",
                    cloud_id
                ),
            );
            self.trace_cp2p_runtime_state("manual_cp2p_state", "skip_open_ready", session_ptr);
        } else {
            let open_deadline = Instant::now() + Duration::from_secs(8);
            let mut open_attempt = 0usize;
            loop {
                open_attempt += 1;
                let ret = self
                    .emulator
                    .e_func(
                        self.native_symbols.cp2p_open_p2p,
                        vec![UnicornArg::Ptr(session_ptr)],
                    )
                    .unwrap_or(u64::MAX);
                self.trace_cp2p_runtime_state(
                    "manual_cp2p_state",
                    &format!("after_open_attempt_{}_ret_{}", open_attempt, ret as i64),
                    session_ptr,
                );
                if open_attempt <= 3 || open_attempt == 40 {
                    self.trace_hidden_p2p_pool_state(
                        "manual_cp2p_pool",
                        &format!("after_open_attempt_{}_ret_{}", open_attempt, ret as i64),
                    );
                }
                let conn = self
                    .emulator
                    .backend
                    .mem_read_i32(session_ptr + 0x140)
                    .unwrap_or_default();
                let peer = self
                    .emulator
                    .backend
                    .mem_read_i32(session_ptr + 0x144)
                    .unwrap_or_default();
                if runtime_env_truthy("RNIDBG_BLACKBOX_OPEN_P2P")
                    && ret == 0
                    && (conn == 0 || peer == 0)
                {
                    let _ = self
                        .emulator
                        .backend
                        .mem_write(session_ptr + 0x140, &(1i32).to_le_bytes());
                    let _ = self
                        .emulator
                        .backend
                        .mem_write(session_ptr + 0x144, &(1i32).to_le_bytes());
                    self.shared.borrow_mut().trace(
                        "manual_cp2p",
                        &format!(
                            "cloudId={} blackbox open_p2p forced conn/peer ready",
                            cloud_id
                        ),
                    );
                    break;
                }
                if ret == 0 && conn != 0 && peer != 0 {
                    break;
                }
                if Instant::now() >= open_deadline {
                    self.shared.borrow_mut().trace(
                        "manual_cp2p",
                        &format!(
                            "cloudId={} open timeout ret={} conn={} peer={}",
                            cloud_id, ret as i64, conn, peer
                        ),
                    );
                    break;
                }
                thread::sleep(Duration::from_millis(200));
            }
        }

        let mut queue_sent = false;
        let read_deadline = Instant::now() + Duration::from_millis(capture_ms.max(3_000));
        let mut iteration = 0usize;
        while Instant::now() < read_deadline {
            iteration += 1;
            let state_before = self
                .emulator
                .backend
                .mem_read_i32(session_ptr + 0x148)
                .unwrap_or_default();
            let conn_before = self
                .emulator
                .backend
                .mem_read_i32(session_ptr + 0x140)
                .unwrap_or_default();
            let peer_before = self
                .emulator
                .backend
                .mem_read_i32(session_ptr + 0x144)
                .unwrap_or_default();
            if !queue_sent {
                let entries = self.collect_cp2p_send_queue_entries(session_ptr);
                self.shared.borrow_mut().trace(
                    "manual_cp2p",
                    &format!(
                        "queue_send_start state={} conn={} peer={} entries={}",
                        state_before,
                        conn_before,
                        peer_before,
                        entries.len()
                    ),
                );
                for entry in entries {
                    let preview = preview_ascii_bytes(
                        &read_guest_bytes(
                            &self.emulator,
                            entry.payload_ptr,
                            entry.payload_len.min(512),
                        ),
                        256,
                    );
                    let default_bool_flag = u64::from(entry.kind != 2);
                    let default_send_kind = entry.kind as u64;
                    let mut attempts = vec![(default_bool_flag, default_send_kind)];
                    let flipped_bool_flag = u64::from(default_bool_flag == 0);
                    if !attempts.contains(&(flipped_bool_flag, default_send_kind)) {
                        attempts.push((flipped_bool_flag, default_send_kind));
                    }
                    if default_send_kind != 1 {
                        if !attempts.contains(&(default_bool_flag, 1)) {
                            attempts.push((default_bool_flag, 1));
                        }
                        if !attempts.contains(&(flipped_bool_flag, 1)) {
                            attempts.push((flipped_bool_flag, 1));
                        }
                    }

                    let mut ret = u64::MAX;
                    for (attempt_idx, (bool_flag, send_kind)) in
                        attempts.iter().copied().enumerate()
                    {
                        ret = self
                            .emulator
                            .e_func(
                                self.native_symbols.cp2p_send_with_header,
                                vec![
                                    UnicornArg::Ptr(session_ptr),
                                    UnicornArg::Ptr(entry.payload_ptr),
                                    UnicornArg::U64(entry.payload_len as u64),
                                    UnicornArg::U64(bool_flag),
                                    UnicornArg::U64(send_kind),
                                ],
                            )
                            .unwrap_or(u64::MAX);
                        let ret_i32 = ret as u32 as i32;
                        self.shared.borrow_mut().trace(
                            "manual_cp2p_send",
                            &format!(
                                "iter={} attempt={} node=0x{:x} kind={} boolFlag={} sendKind={} payloadLen={} ret={} preview={}",
                                iteration,
                                attempt_idx + 1,
                                entry.node_ptr,
                                entry.kind,
                                bool_flag,
                                send_kind,
                                entry.payload_len,
                                ret_i32,
                                preview
                            ),
                        );
                        if ret_i32 >= 0 {
                            break;
                        }
                    }
                }
                queue_sent = true;
            }

            let ret = self
                .emulator
                .e_func(
                    self.native_symbols.cp2p_read_p2p,
                    vec![UnicornArg::Ptr(session_ptr)],
                )
                .unwrap_or(u64::MAX);
            let state_after = self
                .emulator
                .backend
                .mem_read_i32(session_ptr + 0x148)
                .unwrap_or_default();
            let conn = self
                .emulator
                .backend
                .mem_read_i32(session_ptr + 0x140)
                .unwrap_or_default();
            let peer = self
                .emulator
                .backend
                .mem_read_i32(session_ptr + 0x144)
                .unwrap_or_default();
            if iteration <= 20 || iteration % 25 == 0 || ret != 0 || state_before != state_after {
                self.shared.borrow_mut().trace(
                    "manual_cp2p_read",
                    &format!(
                        "iter={} ret={} stateBefore={} stateAfter={} conn={} peer={} queueSent={}",
                        iteration, ret as i64, state_before, state_after, conn, peer, queue_sent
                    ),
                );
            }
            if self.shared.borrow().video_frames > 0 {
                self.shared.borrow_mut().trace(
                    "manual_cp2p",
                    &format!("video frames observed at iter={iteration}"),
                );
                break;
            }
            thread::sleep(Duration::from_millis(50));
        }

        self.emulator
            .backend
            .mem_write(session_ptr + 0x650, &[1])
            .context("failed to restore CP2PStream cancel flag")?;
        self.emulator
            .backend
            .mem_write(session_ptr + 0x14dc, &(1i32).to_le_bytes())
            .context("failed to restore CP2PStream workerDone flag")?;
        self.trace_cp2p_runtime_state("manual_cp2p_state", "end", session_ptr);
        Ok(())
    }

    fn install_media_trace_patches(&self) -> Result<()> {
        let add_watch_stub = self.emulator.register_svc(SimpleArm64Svc::new(
            "SiotDevSession_AddWatch_inline_trace",
            trace_siot_add_watch_stub::<()>,
        ));
        let add_watch_tramp = install_inline_trace_patch(
            &self.emulator,
            SIOT_ADD_WATCH_SYMBOL,
            self.native_symbols.siot_add_watch,
            add_watch_stub,
        )?;
        self.shared.borrow_mut().trace(
            "patch",
            &format!(
                "patched AddWatch 0x{:x} -> 0x{:x} tramp=0x{:x}",
                self.native_symbols.siot_add_watch, add_watch_stub, add_watch_tramp
            ),
        );

        let resume_dev_stub = self.emulator.register_svc(SimpleArm64Svc::new(
            "SiotDevSession_ResumeDevCom_inline_trace",
            trace_siot_resume_dev_com_stub::<()>,
        ));
        let resume_dev_tramp = install_inline_trace_patch(
            &self.emulator,
            SIOT_RESUME_DEV_COM_SYMBOL,
            self.native_symbols.siot_resume_dev_com,
            resume_dev_stub,
        )?;
        self.shared.borrow_mut().trace(
            "patch",
            &format!(
                "patched ResumeDevCom 0x{:x} -> 0x{:x} tramp=0x{:x}",
                self.native_symbols.siot_resume_dev_com, resume_dev_stub, resume_dev_tramp
            ),
        );

        for (symbol_name, function_addr) in &self.native_symbols.trace_resume_variants {
            let svc_name = format!("inline_trace::{symbol_name}");
            let stub_addr = self.emulator.register_svc(SimpleArm64Svc::new(
                svc_name.as_str(),
                trace_resume_variant_stub::<()>,
            ));
            let tramp = install_inline_trace_patch(
                &self.emulator,
                symbol_name.as_str(),
                *function_addr,
                stub_addr,
            )?;
            self.shared.borrow_mut().trace(
                "patch",
                &format!(
                    "patched resume variant {} 0x{:x} -> 0x{:x} tramp=0x{:x}",
                    symbol_name, function_addr, stub_addr, tramp
                ),
            );
        }

        let connect_media_stub = self.emulator.register_svc(SimpleArm64Svc::new(
            "SiotDevSession_ConnectMediaChannel_inline_trace",
            trace_siot_connect_media_channel_stub::<()>,
        ));
        let connect_media_tramp = install_inline_trace_patch(
            &self.emulator,
            SIOT_CONNECT_MEDIA_CHANNEL_SYMBOL,
            self.native_symbols.siot_connect_media_channel,
            connect_media_stub,
        )?;
        self.shared.borrow_mut().trace(
            "patch",
            &format!(
                "patched ConnectMediaChannel 0x{:x} -> 0x{:x} tramp=0x{:x}",
                self.native_symbols.siot_connect_media_channel,
                connect_media_stub,
                connect_media_tramp
            ),
        );

        let open_media_stub = self.emulator.register_svc(SimpleArm64Svc::new(
            "SiotDevSession_OpenMediaChannel_inline_trace",
            trace_siot_open_media_channel_stub::<()>,
        ));
        let open_media_tramp = install_inline_trace_patch(
            &self.emulator,
            SIOT_OPEN_MEDIA_CHANNEL_SYMBOL,
            self.native_symbols.siot_open_media_channel,
            open_media_stub,
        )?;
        self.shared.borrow_mut().trace(
            "patch",
            &format!(
                "patched OpenMediaChannel 0x{:x} -> 0x{:x} tramp=0x{:x}",
                self.native_symbols.siot_open_media_channel, open_media_stub, open_media_tramp
            ),
        );

        let send_xml_stub = self.emulator.register_svc(SimpleArm64Svc::new(
            "SiotDevSession_SendXmlByMedia_inline_trace",
            trace_siot_send_xml_by_media_stub::<()>,
        ));
        let send_xml_tramp = install_inline_trace_patch(
            &self.emulator,
            SIOT_SEND_XML_BY_MEDIA_SYMBOL,
            self.native_symbols.siot_send_xml_by_media,
            send_xml_stub,
        )?;
        self.shared.borrow_mut().trace(
            "patch",
            &format!(
                "patched SendXmlByMedia 0x{:x} -> 0x{:x} tramp=0x{:x}",
                self.native_symbols.siot_send_xml_by_media, send_xml_stub, send_xml_tramp
            ),
        );

        let connect_device_stub = self.emulator.register_svc(SimpleArm64Svc::new(
            "TpsrtcWrap_ConnectDevice_inline_trace",
            trace_tpsrtc_connect_device_stub::<()>,
        ));
        let connect_device_tramp = install_inline_trace_patch(
            &self.emulator,
            TPSRTC_CONNECT_DEVICE_SYMBOL,
            self.native_symbols.tpsrtc_connect_device,
            connect_device_stub,
        )?;
        self.shared.borrow_mut().trace(
            "patch",
            &format!(
                "patched ConnectDevice 0x{:x} -> 0x{:x} tramp=0x{:x}",
                self.native_symbols.tpsrtc_connect_device,
                connect_device_stub,
                connect_device_tramp
            ),
        );

        let media_control_stub = self.emulator.register_svc(SimpleArm64Svc::new(
            "TpsrtcWrap_MediaControl_inline_trace",
            trace_tpsrtc_media_control_stub::<()>,
        ));
        let media_control_tramp = install_inline_trace_patch(
            &self.emulator,
            TPSRTC_MEDIA_CONTROL_SYMBOL,
            self.native_symbols.tpsrtc_media_control,
            media_control_stub,
        )?;
        self.shared.borrow_mut().trace(
            "patch",
            &format!(
                "patched MediaControl 0x{:x} -> 0x{:x} tramp=0x{:x}",
                self.native_symbols.tpsrtc_media_control, media_control_stub, media_control_tramp
            ),
        );

        for (symbol_name, function_addr) in &self.native_symbols.trace_add_watch_variants {
            let svc_name = format!("inline_trace::{symbol_name}");
            let stub_addr = self.emulator.register_svc(SimpleArm64Svc::new(
                svc_name.as_str(),
                trace_add_watch_variant_stub::<()>,
            ));
            let tramp = install_inline_trace_patch(
                &self.emulator,
                symbol_name.as_str(),
                *function_addr,
                stub_addr,
            )?;
            self.shared.borrow_mut().trace(
                "patch",
                &format!(
                    "patched addwatch variant {} 0x{:x} -> 0x{:x} tramp=0x{:x}",
                    symbol_name, function_addr, stub_addr, tramp
                ),
            );
        }

        Ok(())
    }

    fn install_hidden_p2p_trace_patches(&self) -> Result<()> {
        let mut hooks = Vec::new();
        if runtime_env_truthy("RNIDBG_PATCH_P2P_ALLOC_CONN") {
            hooks.push((
                HIDDEN_P2P_ALLOC_CONN_NAME,
                self.native_symbols.hidden_p2p_alloc_conn,
                "hidden_p2p_alloc_conn_trace",
                trace_hidden_p2p_alloc_conn_stub::<()>
                    as fn(&str, &AndroidEmulator<()>) -> SvcCallResult,
            ));
        }
        hooks.push((
            HIDDEN_P2P_TRANSPORT_CONNECT_NAME,
            self.native_symbols.hidden_p2p_transport_connect,
            "hidden_p2p_transport_connect_trace",
            trace_hidden_p2p_transport_connect_stub::<()>
                as fn(&str, &AndroidEmulator<()>) -> SvcCallResult,
        ));
        hooks.push((
            HIDDEN_P2P_CONN_MODE_NAME,
            self.native_symbols.hidden_p2p_conn_mode,
            "hidden_p2p_conn_mode_trace",
            trace_hidden_p2p_conn_mode_stub::<()>
                as fn(&str, &AndroidEmulator<()>) -> SvcCallResult,
        ));
        hooks.push((
            HIDDEN_P2P_OPEN_PEER_NAME,
            self.native_symbols.hidden_p2p_open_peer,
            "hidden_p2p_open_peer_trace",
            trace_hidden_p2p_open_peer_stub::<()>
                as fn(&str, &AndroidEmulator<()>) -> SvcCallResult,
        ));
        for (name, function_addr, stub_name, stub_fn) in hooks {
            let stub_addr = self
                .emulator
                .register_svc(SimpleArm64Svc::new(stub_name, stub_fn));
            let tramp = install_inline_trace_patch(&self.emulator, name, function_addr, stub_addr)?;
            self.shared.borrow_mut().trace(
                "patch",
                &format!(
                    "patched hidden p2p {} 0x{:x} -> 0x{:x} tramp=0x{:x}",
                    name, function_addr, stub_addr, tramp
                ),
            );
        }
        Ok(())
    }

    fn install_hidden_p2p_force_success_patch(&self) -> Result<()> {
        let patch_addr = self.native_symbols.funclib_base + HIDDEN_P2P_FORCE_SUCCESS_OFFSET;
        let code = emulator::keystone::assemble_no_check_v2("mov w20, wzr", patch_addr);
        self.emulator
            .backend
            .mem_write(patch_addr, &code)
            .context("failed to patch hidden P2P force-success branch")?;
        self.shared.borrow_mut().trace(
            "patch",
            &format!(
                "patched hidden p2p force-success 0x{:x} => mov w20, wzr",
                patch_addr
            ),
        );
        Ok(())
    }

    fn install_async_task_sync_patch(&self) -> Result<()> {
        let stub_addr = self.emulator.register_svc(SimpleArm64Svc::new(
            "seetong_async_task_sync_stub",
            async_task_sync_stub::<()>,
        ));
        let target = self.native_symbols.funclib_base + HIDDEN_P2P_ASYNC_TASK_OFFSET;
        patch_guest_function_jump(&self.emulator, target, stub_addr)?;
        self.shared.borrow_mut().trace(
            "patch",
            &format!(
                "patched async task starter 0x{:x} -> 0x{:x}",
                target, stub_addr
            ),
        );
        Ok(())
    }

    pub fn run_smoke(&self) -> Result<Value> {
        let object = self.new_funclib_object();
        let sdk_version =
            self.call_instance(&object, "GetSdkVersion", "()Ljava/lang/String;", vec![]);
        Ok(json!({
            "status": "ok",
            "timestamp": iso_now(),
            "package": self.config.package_name,
            "backend": self.config.backend,
            "traceOutDir": self.config.trace_out_dir,
            "registeredMethods": self.emulator.get_dalvik_vm().list_method_signatures(self.funclib_class.id),
            "sdkVersion": sdk_version.ok().and_then(|value| jni_value_to_string(value).ok()),
        }))
    }

    fn run_live(&self, seed: &SeetongSeed, skip_init_with_header: bool) -> Result<Value> {
        let object = self.new_funclib_object();
        let start = Instant::now();
        let log_level = seed.log_level.unwrap_or(255);
        let skip_login_sig = runtime_env_truthy("RNIDBG_SKIP_LOGIN_SIG_SERVER");
        let force_prime_access = runtime_env_truthy("RNIDBG_FORCE_PRIME_ACCESS_NODE");

        // The historical skip-login path that reaches AddWatchEx does not pre-seed
        // access-node state. Keep that older behavior when LoginSigServer is skipped.
        if !skip_login_sig || force_prime_access {
            prime_siot_access_node_stub(seed, &self.shared);
        }

        self.call_i32(&object, "SetHttpsProtocol", "()I", vec![])?;
        if seed.set_large_devlist {
            self.call_i32(&object, "SetLargeDevlist", "()I", vec![])?;
        }
        self.call_i32(
            &object,
            "SetFcLogCallBackEx",
            "(I)I",
            vec![log_level.into()],
        )?;

        let init_ret = if skip_init_with_header {
            self.shared
                .borrow_mut()
                .trace("call", "initWithHeader skipped by option");
            0
        } else {
            let ret = self.call_i32(
                &object,
                "initWithHeader",
                "(Lipc/android/sdk/impl/FunclibAgent;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I",
                vec![
                    object.clone().into(),
                    seed.header.os.clone().into(),
                    seed.header.lang.clone().into(),
                    seed.header.brand.clone().into(),
                    seed.header.phone_type.clone().into(),
                    seed.header.name.clone().into(),
                    seed.header.version.clone().into(),
                    seed.header.client_id.clone().into(),
                    seed.header.user_domain.clone().into(),
                    seed.header.user_domain_back.clone().into(),
                    seed.header.fw_update_domain.clone().into(),
                    seed.header.active_user_domain.clone().into(),
                    seed.header.nat_servers.clone().into(),
                ],
            )?;
            self.shared
                .borrow_mut()
                .trace("call", &format!("initWithHeader ret={ret}"));
            ret
        };
        if runtime_env_truthy("RNIDBG_CAPTURE_FC_INIT_WITH_HEADER") {
            self.complete_captured_fc_init()?;
            if runtime_env_truthy("RNIDBG_BOOT_HIDDEN_P2P") {
                self.ensure_low_page_mapped("boot_hidden_p2p");
                self.ensure_hidden_p2p_pool_initialized("boot_hidden_p2p");
                self.trace_hidden_p2p_pool_state("boot_hidden_p2p_pool", "after_fc_init");
            }
        }
        if runtime_env_truthy("RNIDBG_FORCE_P2P_CONNECT_RET0") {
            self.install_hidden_p2p_force_success_patch()?;
        }
        if runtime_env_truthy("RNIDBG_SYNC_ASYNC_TASK_WRAPPER") {
            self.install_async_task_sync_patch()?;
        }
        if runtime_env_truthy("RNIDBG_INLINE_MEDIA_TRACE") {
            self.install_media_trace_patches()?;
        }
        if runtime_env_truthy("RNIDBG_INLINE_HIDDEN_P2P_TRACE")
            || runtime_env_truthy("RNIDBG_FORCE_P2P_CONNECT_RET0")
        {
            self.install_hidden_p2p_trace_patches()?;
        }

        self.call_i32(&object, "SetMsgRspCallBackAgent", "()I", vec![])?;
        self.call_i32(&object, "SetMediaRecvCallBackAgent", "()I", vec![])?;

        if let Some(log_server) = &seed.header.log_server {
            self.call_i32(
                &object,
                "SetLogServer",
                "(Ljava/lang/String;)I",
                vec![log_server.clone().into()],
            )?;
        }

        if runtime_env_truthy("RNIDBG_MANUAL_LOC_REALPLAY") {
            let capture_ms = seed.capture_ms.unwrap_or(15_000);
            let loc = self.manual_drive_loc_realplay(&object, seed, capture_ms)?;
            let free_ret = if runtime_env_truthy("RNIDBG_SKIP_FREE_AGENT") {
                self.shared
                    .borrow_mut()
                    .trace("call", "FreeAgent skipped by RNIDBG_SKIP_FREE_AGENT");
                None
            } else {
                self.call_i32(&object, "FreeAgent", "()I", vec![]).ok()
            };
            {
                let mut shared = self.shared.borrow_mut();
                shared.trace(
                    "call",
                    &format!(
                        "loc cleanup loginHandle={} playHandle={} stopRet={} logoutRet={} free={:?}",
                        loc.login_handle, loc.play_handle, loc.stop_ret, loc.logout_ret, free_ret
                    ),
                );
                shared.flush_events()?;
            }
            let shared = self.shared.borrow();
            return Ok(json!({
                "status": "ok",
                "elapsedMs": start.elapsed().as_millis(),
                "backend": self.config.backend,
                "traceOutDir": self.config.trace_out_dir,
                "returns": {
                    "initWithHeader": init_ret,
                    "locLoginDev": loc.login_handle,
                    "locRealPlayEx": loc.play_handle,
                    "locStopRealPlay": loc.stop_ret,
                    "locLogOutDev": loc.logout_ret,
                    "freeAgent": free_ret,
                },
                "files": {
                    "trace": shared.trace_path,
                    "events": shared.events_path,
                    "videoFrames": shared.video_path,
                    "audioFrames": shared.audio_path,
                },
                "stats": {
                    "videoFrames": shared.video_frames,
                    "audioFrames": shared.audio_frames,
                    "videoBytes": shared.video_bytes,
                    "audioBytes": shared.audio_bytes,
                    "msgRspCount": shared.msg_rsp_count,
                    "signalEvents": shared.signal_events,
                }
            }));
        }

        let set_token_ret = self.call_i32(
            &object,
            "SetAccessToken",
            "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)I",
            vec![
                seed.access_token.access_token.clone().into(),
                seed.access_token.refresh_token.clone().into(),
                seed.access_token.biz_domain.clone().into(),
                seed.access_token.biz_domain_backup.clone().into(),
                seed.access_token.active_biz_domain.clone().into(),
                (seed.access_token.expires_time as i64).into(),
            ],
        )?;
        self.shared
            .borrow_mut()
            .trace("call", &format!("SetAccessToken ret={set_token_ret}"));

        let user_info_json = json_to_string(&seed.user_info_json);
        let use_direct_set_user_info2 = std::env::var("RNIDBG_DIRECT_SET_USER_INFO2")
            .map(|value| value != "0")
            .unwrap_or(runtime_env_truthy("RNIDBG_GET_DEV_PICTURE"));
        let set_user_ret = if use_direct_set_user_info2 {
            self.call_ccsinf_set_user_info2_direct(&user_info_json)?
        } else {
            self.call_i32(
                &object,
                "SetUserInfo2",
                "(Ljava/lang/String;)I",
                vec![user_info_json.clone().into()],
            )?
        };
        self.shared.borrow_mut().trace(
            "call",
            &format!("SetUserInfo2 ret={set_user_ret} direct={use_direct_set_user_info2}"),
        );
        if runtime_env_truthy("RNIDBG_TRACE_H5_AUTH") {
            let h5_auth = self.get_h5_auth_info(&object)?;
            self.shared.borrow_mut().trace(
                "call",
                &format!("GetH5AuthInfo preview={}", mask_secret(&h5_auth, 10)),
            );
        }
        if runtime_env_truthy("RNIDBG_GET_DEV_PICTURE") {
            let base_dir = self
                .shared
                .borrow()
                .trace_path
                .parent()
                .map(Path::to_path_buf)
                .ok_or_else(|| anyhow!("trace path parent missing"))?;
            let picture_path = base_dir.join("device_picture.jpg");
            let picture_path_string = picture_path.to_string_lossy().to_string();
            let channel = std::env::var("RNIDBG_GET_DEV_PICTURE_CHANNEL")
                .ok()
                .and_then(|value: String| value.parse::<i32>().ok())
                .unwrap_or(0);
            let add_device_json = json_to_string(&seed.picture_add_device_json());
            let use_direct_add = std::env::var("RNIDBG_DIRECT_ADD_DEVICE_STREAM")
                .map(|value| value != "0")
                .unwrap_or(true);
            let add_device_ret = if use_direct_add {
                self.call_ccsinf_add_device_stream_direct(&add_device_json)?
            } else {
                self.call_i32(
                    &object,
                    "AddDeviceStream",
                    "(Ljava/lang/String;)I",
                    vec![add_device_json.clone().into()],
                )?
            };
            self.shared.borrow_mut().trace(
                "call",
                &format!(
                    "GetDevPicture preflight AddDeviceStream ret={add_device_ret} direct={} json={add_device_json}",
                    use_direct_add
                ),
            );
            self.trace_session_object(
                &seed.watch.cloud_id,
                seed.watch.stream_no,
                "after_picture_add",
            );
            let picture_resume_dev = std::env::var("RNIDBG_GET_DEV_PICTURE_RESUME_DEV")
                .map(|value| value != "0")
                .unwrap_or(true);
            if picture_resume_dev {
                let use_direct_resume = std::env::var("RNIDBG_DIRECT_RESUME_DEV_COM_WITH_ID")
                    .map(|value| value != "0")
                    .unwrap_or(runtime_env_truthy("RNIDBG_GET_DEV_PICTURE"));
                let resume_ret = if use_direct_resume {
                    self.call_ccsinf_resume_dev_com_with_id_direct(&seed.watch.cloud_id)?
                } else {
                    self.call_i32(
                        &object,
                        "ResumeDevComWithId",
                        "(Ljava/lang/String;)I",
                        vec![seed.watch.cloud_id.clone().into()],
                    )?
                };
                self.shared.borrow_mut().trace(
                    "call",
                    &format!(
                        "GetDevPicture preflight ResumeDevComWithId ret={resume_ret} direct={use_direct_resume}"
                    ),
                );
                self.trace_session_object(
                    &seed.watch.cloud_id,
                    seed.watch.stream_no,
                    "after_picture_resume",
                );
                let resume_wait_ms = std::env::var("RNIDBG_GET_DEV_PICTURE_RESUME_WAIT_MS")
                    .ok()
                    .and_then(|value| value.parse::<u64>().ok())
                    .unwrap_or(4_000);
                if resume_wait_ms > 0 {
                    thread::sleep(Duration::from_millis(resume_wait_ms));
                }
            }
            let use_direct_picture = std::env::var("RNIDBG_DIRECT_GET_DEV_PICTURE")
                .map(|value| value != "0")
                .unwrap_or(false);
            let ret = if use_direct_picture {
                self.call_ccsinf_get_dev_picture_direct(
                    &seed.watch.cloud_id,
                    channel,
                    &picture_path_string,
                )?
            } else {
                self.call_i32(
                    &object,
                    "GetDevPicture",
                    "(Ljava/lang/String;ILjava/lang/String;)I",
                    vec![
                        seed.watch.cloud_id.clone().into(),
                        channel.into(),
                        picture_path_string.clone().into(),
                    ],
                )?
            };
            self.shared.borrow_mut().trace(
                "call",
                &format!(
                    "GetDevPicture ret={ret} direct={} devId={} channel={} path={picture_path_string}",
                    use_direct_picture, seed.watch.cloud_id, channel
                ),
            );
            if let Some((_, session_ptr)) = self.sold_fallback_session_ptr(&seed.watch.cloud_id) {
                self.trace_cp2p_runtime_state(
                    "picture_cp2p_state",
                    "after_get_picture",
                    session_ptr,
                );
                self.trace_cp2p_send_queue("picture_cp2p_queue", "after_get_picture", session_ptr);
            }
            let picture_manual_drive = std::env::var("RNIDBG_GET_DEV_PICTURE_MANUAL_DRIVE")
                .map(|value| value != "0")
                .unwrap_or(true);
            if picture_manual_drive {
                let drive_ms = std::env::var("RNIDBG_GET_DEV_PICTURE_DRIVE_MS")
                    .ok()
                    .and_then(|value| value.parse::<u64>().ok())
                    .unwrap_or(5_000);
                self.shared.borrow_mut().trace(
                    "call",
                    &format!("GetDevPicture manual drive start driveMs={drive_ms}"),
                );
                self.manual_drive_cp2p_session(&seed.watch.cloud_id, drive_ms)?;
            }
            let picture_wait_ms = std::env::var("RNIDBG_GET_DEV_PICTURE_WAIT_MS")
                .ok()
                .and_then(|value| value.parse::<u64>().ok())
                .unwrap_or(5_000);
            if picture_wait_ms > 0 {
                thread::sleep(Duration::from_millis(picture_wait_ms));
            }
            self.shared.borrow_mut().trace(
                "call",
                &format!(
                    "GetDevPicture post-wait exists={} waitMs={} path={picture_path_string}",
                    picture_path.exists(),
                    picture_wait_ms
                ),
            );
            let shared = self.shared.borrow();
            return Ok(json!({
                "status": "ok",
                "elapsedMs": start.elapsed().as_millis(),
                "backend": self.config.backend,
                "traceOutDir": self.config.trace_out_dir,
                "returns": {
                    "initWithHeader": init_ret,
                    "setAccessToken": set_token_ret,
                    "setUserInfo2": set_user_ret,
                    "addDeviceStream": add_device_ret,
                    "getDevPicture": ret,
                },
                "files": {
                    "trace": shared.trace_path,
                    "events": shared.events_path,
                    "videoFrames": shared.video_path,
                    "audioFrames": shared.audio_path,
                    "devicePicture": picture_path,
                },
            }));
        }
        if runtime_env_truthy("RNIDBG_REDIRECT_ACCESS_NODE") {
            self.redirect_access_node()?;
        }

        let prior_preconnect_json = seed.prior_preconnect_json();
        let preconnect_after_add_device = runtime_env_truthy("RNIDBG_PRECONNECT_AFTER_ADD_DEVICE");
        let skip_preconnect = runtime_env_truthy("RNIDBG_SKIP_PRECONNECT");
        let mut prior_ret = None;
        if skip_preconnect {
            self.shared.borrow_mut().trace(
                "call",
                "SetPriorPreConnectCloudId skipped by RNIDBG_SKIP_PRECONNECT",
            );
        } else if !preconnect_after_add_device {
            let value = self.call_i32(
                &object,
                "SetPriorPreConnectCloudId",
                "(Ljava/lang/String;)I",
                vec![prior_preconnect_json.clone().into()],
            )?;
            self.shared.borrow_mut().trace(
                "call",
                &format!("SetPriorPreConnectCloudId ret={value} json={prior_preconnect_json}"),
            );
            prior_ret = Some(value);
        }

        if !skip_login_sig || force_prime_access {
            let get_siot_access_node_stub_addr = self.emulator.register_svc(SimpleArm64Svc::new(
                "CCSInf_GetSiotAccessNode_inline_stub",
                get_siot_access_node_stub::<()>,
            ));
            patch_guest_function_jump(
                &self.emulator,
                self.native_symbols.ccsinf_get_siot_access_node,
                get_siot_access_node_stub_addr,
            )?;
            self.shared.borrow_mut().trace(
                "access_node",
                &format!(
                    "patched GetSiotAccessNode 0x{:x} -> 0x{:x}",
                    self.native_symbols.ccsinf_get_siot_access_node, get_siot_access_node_stub_addr
                ),
            );
        }

        let login_sig_ret = if skip_login_sig {
            self.shared.borrow_mut().trace(
                "call",
                "LoginSigServer skipped by RNIDBG_SKIP_LOGIN_SIG_SERVER",
            );
            None
        } else {
            let login_sig_ret = self.call_i32(
                &object,
                "LoginSigServer",
                "(Ljava/lang/String;Ljava/lang/String;)I",
                vec![
                    seed.sig.client_id.clone().into(),
                    seed.sig.token.clone().into(),
                ],
            )?;
            self.shared
                .borrow_mut()
                .trace("call", &format!("LoginSigServer ret={login_sig_ret}"));
            thread::sleep(Duration::from_millis(
                seed.sleep_after_login_sig_ms.unwrap_or(3_000),
            ));
            Some(login_sig_ret)
        };

        let add_device_ret = if runtime_env_truthy("RNIDBG_SKIP_ADD_DEVICE_STREAM") {
            self.shared.borrow_mut().trace(
                "call",
                "AddDeviceStream skipped by RNIDBG_SKIP_ADD_DEVICE_STREAM",
            );
            None
        } else {
            let device_json = json_to_string(&seed.device_json);
            let add_device_ret = self.call_i32(
                &object,
                "AddDeviceStream",
                "(Ljava/lang/String;)I",
                vec![device_json.clone().into()],
            )?;
            self.shared
                .borrow_mut()
                .trace("call", &format!("AddDeviceStream ret={add_device_ret}"));
            self.trace_session_object(
                &seed.watch.cloud_id,
                seed.watch.stream_no,
                "after_add_device",
            );
            Some(add_device_ret)
        };

        if !skip_preconnect && preconnect_after_add_device {
            let value = self.call_i32(
                &object,
                "SetPriorPreConnectCloudId",
                "(Ljava/lang/String;)I",
                vec![prior_preconnect_json.clone().into()],
            )?;
            self.shared.borrow_mut().trace(
                "call",
                &format!(
                    "SetPriorPreConnectCloudId ret={value} json={} after AddDeviceStream",
                    prior_preconnect_json
                ),
            );
            prior_ret = Some(value);
        }

        let resume_ret = if runtime_env_truthy("RNIDBG_SKIP_RESUME_DEV_COM") {
            self.shared.borrow_mut().trace(
                "call",
                "ResumeDevComWithId skipped by RNIDBG_SKIP_RESUME_DEV_COM",
            );
            None
        } else {
            let use_direct_resume = std::env::var("RNIDBG_DIRECT_RESUME_DEV_COM_WITH_ID")
                .map(|value| value != "0")
                .unwrap_or(false);
            let resume_ret = if use_direct_resume {
                self.call_ccsinf_resume_dev_com_with_id_direct(&seed.watch.cloud_id)?
            } else {
                self.call_i32(
                    &object,
                    "ResumeDevComWithId",
                    "(Ljava/lang/String;)I",
                    vec![seed.watch.cloud_id.clone().into()],
                )?
            };
            self.shared.borrow_mut().trace(
                "call",
                &format!("ResumeDevComWithId ret={resume_ret} direct={use_direct_resume}"),
            );
            self.trace_session_object(&seed.watch.cloud_id, seed.watch.stream_no, "after_resume");
            thread::sleep(Duration::from_millis(
                seed.sleep_after_resume_ms.unwrap_or(4_000),
            ));
            Some(resume_ret)
        };

        if self.config.backend == "unicorn" {
            self.ensure_zero_page_mapped("pre_add_watch");
        }

        let use_direct_add_watch = std::env::var("RNIDBG_DIRECT_ADD_WATCH_EX")
            .map(|value| value != "0")
            .unwrap_or(false);
        let add_watch_ret = if use_direct_add_watch {
            self.call_ccsinf_add_watch_ex_direct(
                &seed.watch.cloud_id,
                seed.watch.stream_no,
                seed.watch.frame_type,
                seed.watch.com_type,
                seed.watch.extra,
            )?
        } else {
            self.call_i32(
                &object,
                "AddWatchEx",
                "(Ljava/lang/String;IIII)I",
                vec![
                    seed.watch.cloud_id.clone().into(),
                    seed.watch.stream_no.into(),
                    seed.watch.frame_type.into(),
                    seed.watch.com_type.into(),
                    seed.watch.extra.into(),
                ],
            )?
        };
        self.shared.borrow_mut().trace(
            "call",
            &format!("AddWatchEx ret={add_watch_ret} direct={use_direct_add_watch}"),
        );
        self.trace_session_object(
            &seed.watch.cloud_id,
            seed.watch.stream_no,
            "after_add_watch",
        );
        let capture_ms = seed.capture_ms.unwrap_or(15_000);
        if runtime_env_truthy("RNIDBG_MANUAL_P2P_DRIVE") {
            self.manual_drive_cp2p_session(&seed.watch.cloud_id, capture_ms)?;
        } else {
            thread::sleep(Duration::from_millis(capture_ms));
        }

        let stop_watch_ret = self
            .call_i32(
                &object,
                "StopWatchAgent",
                "(Ljava/lang/String;)I",
                vec![seed.watch.cloud_id.clone().into()],
            )
            .ok();
        let stop_dev_ret = self
            .call_i32(
                &object,
                "StopDevComWithId",
                "(Ljava/lang/String;)I",
                vec![seed.watch.cloud_id.clone().into()],
            )
            .ok();
        let free_ret = if runtime_env_truthy("RNIDBG_SKIP_FREE_AGENT") {
            self.shared
                .borrow_mut()
                .trace("call", "FreeAgent skipped by RNIDBG_SKIP_FREE_AGENT");
            None
        } else {
            self.call_i32(&object, "FreeAgent", "()I", vec![]).ok()
        };

        {
            let mut shared = self.shared.borrow_mut();
            shared.trace(
                "call",
                &format!(
                    "cleanup stopWatch={:?} stopDevCom={:?} free={:?}",
                    stop_watch_ret, stop_dev_ret, free_ret
                ),
            );
            shared.flush_events()?;
        }

        let shared = self.shared.borrow();
        Ok(json!({
            "status": "ok",
            "elapsedMs": start.elapsed().as_millis(),
            "backend": self.config.backend,
            "traceOutDir": self.config.trace_out_dir,
            "returns": {
                "initWithHeader": init_ret,
                "setAccessToken": set_token_ret,
                "setUserInfo2": set_user_ret,
                "setPriorPreConnectCloudId": prior_ret,
                "loginSigServer": login_sig_ret,
                "addDeviceStream": add_device_ret,
                "resumeDevComWithId": resume_ret,
                "addWatchEx": add_watch_ret,
                "stopWatchAgent": stop_watch_ret,
                "stopDevComWithId": stop_dev_ret,
                "freeAgent": free_ret,
            },
            "files": {
                "trace": shared.trace_path,
                "events": shared.events_path,
                "videoFrames": shared.video_path,
                "audioFrames": shared.audio_path,
            },
            "stats": {
                "videoFrames": shared.video_frames,
                "audioFrames": shared.audio_frames,
                "videoBytes": shared.video_bytes,
                "audioBytes": shared.audio_bytes,
                "msgRspCount": shared.msg_rsp_count,
                "signalEvents": shared.signal_events,
            }
        }))
    }
}

pub fn run_smoke(opts: &HashMap<String, String>) -> Result<Value> {
    let config_path = PathBuf::from(
        opts.get("--config")
            .cloned()
            .unwrap_or_else(default_seetong_config_path),
    );
    let trace_override = opts.get("--trace-out").map(PathBuf::from);
    let lab = SeetongLab::load_with_backend(
        config_path,
        opts.get("--backend").map(String::as_str),
        trace_override,
    )?;
    lab.run_smoke()
}

pub fn run_live(opts: &HashMap<String, String>) -> Result<Value> {
    let seed_path = required_option(opts, "--seed")?;
    let config_path = PathBuf::from(
        opts.get("--config")
            .cloned()
            .unwrap_or_else(default_seetong_config_path),
    );
    let trace_override = opts.get("--trace-out").map(PathBuf::from);
    let lab = SeetongLab::load_with_backend(
        config_path,
        opts.get("--backend").map(String::as_str),
        trace_override,
    )?;
    let seed = SeetongSeed::load(seed_path)?;
    let skip_init_with_header = opts
        .get("--skip-init-with-header")
        .map(|value| value == "true" || value == "1")
        .unwrap_or(false);
    lab.run_live(&seed, skip_init_with_header)
}

fn default_seetong_config_path() -> String {
    if let Ok(path) = std::env::var("RNIDBG_SEETONG_CONFIG") {
        return path;
    }
    for candidate in [
        "config/seetong-funclib.container.json",
        "/workspace/rnidbg/config/seetong-funclib.container.json",
    ] {
        if PathBuf::from(candidate).exists() {
            return candidate.to_string();
        }
    }
    default_config_path()
}

fn build_class_resolver() -> ClassResolver {
    ClassResolver::new(vec![
        "ipc/android/sdk/impl/FunclibAgent",
        "java/lang/StringBuffer",
    ])
}

fn install_system_properties(emulator: &AndroidEmulator<'static, ()>, config: &SeetongConfig) {
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

fn install_virtual_native_stubs(emulator: &AndroidEmulator<'static, ()>) {
    let mut misc_symbols = HashMap::new();
    let mut gl_symbols = HashMap::new();
    let mut egl_symbols = HashMap::new();
    for name in [
        "memfd_create",
        "getentropy",
        "glActiveTexture",
        "glAttachShader",
        "glBindTexture",
        "glBlendFunc",
        "glClear",
        "glClearColor",
        "glClearDepthf",
        "glCompileShader",
        "glCreateProgram",
        "glCreateShader",
        "glCullFace",
        "glDeleteProgram",
        "glDeleteShader",
        "glDeleteTextures",
        "glDepthFunc",
        "glDrawArrays",
        "glEnable",
        "glEnableVertexAttribArray",
        "glGenTextures",
        "glGetAttribLocation",
        "glGetError",
        "glGetProgramInfoLog",
        "glGetProgramiv",
        "glGetShaderInfoLog",
        "glGetShaderiv",
        "glGetUniformLocation",
        "glLinkProgram",
        "glPixelStorei",
        "glShaderSource",
        "glTexImage2D",
        "glTexParameteri",
        "glUniform1i",
        "glUniformMatrix4fv",
        "glUseProgram",
        "glVertexAttribPointer",
        "glViewport",
        "eglBindAPI",
        "eglChooseConfig",
        "eglCreateContext",
        "eglCreatePbufferSurface",
        "eglDestroyContext",
        "eglDestroySurface",
        "eglGetDisplay",
        "eglGetError",
        "eglInitialize",
        "eglMakeCurrent",
        "eglQueryString",
        "eglSwapBuffers",
        "eglTerminate",
    ] {
        let addr = match name {
            "memfd_create" => {
                emulator.register_svc(SimpleArm64Svc::new(name, memfd_create_stub::<()>))
            }
            "getentropy" => emulator.register_svc(SimpleArm64Svc::new(name, getentropy_stub::<()>)),
            _ => emulator.register_svc(SimpleArm64Svc::new(name, zero_stub::<()>)),
        };
        if name.starts_with("gl") {
            gl_symbols.insert(name.to_string(), addr);
        } else if name.starts_with("egl") {
            egl_symbols.insert(name.to_string(), addr);
        } else {
            misc_symbols.insert(name.to_string(), addr);
        }
    }

    if !misc_symbols.is_empty() {
        emulator
            .memory()
            .load_virtual_module("libseetong-stubs.so".to_string(), misc_symbols);
    }
    if !gl_symbols.is_empty() {
        emulator
            .memory()
            .load_virtual_module("libGLESv2.so".to_string(), gl_symbols.clone());
        emulator
            .memory()
            .load_virtual_module("libGLESv3.so".to_string(), gl_symbols);
    }
    if !egl_symbols.is_empty() {
        emulator
            .memory()
            .load_virtual_module("libEGL.so".to_string(), egl_symbols);
    }
}

fn configure_file_system(emulator: &AndroidEmulator<'static, ()>, config: &SeetongConfig) {
    let package_name = config.package_name.clone();
    let apk_path = config.apk_path.clone();
    let funclib_agent_path = config.funclib_agent_path.clone();
    let funclib_path = config.funclib_path.clone();
    let trace_out_dir = normalize(config.trace_out_dir.clone());
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

            if path.ends_with("/libFunclibAgent.so")
                || path == "libFunclibAgent.so"
                || normalize(PathBuf::from(path)) == funclib_agent_path
            {
                return Some(FileIO::File(LinuxFileIO::new(
                    funclib_agent_path.to_string_lossy().as_ref(),
                    path,
                    flags.bits(),
                    12345,
                    StMode::APP_FILE,
                )));
            }

            if path.ends_with("/libFunclib.so")
                || path == "libFunclib.so"
                || normalize(PathBuf::from(path)) == funclib_path
            {
                return Some(FileIO::File(LinuxFileIO::new(
                    funclib_path.to_string_lossy().as_ref(),
                    path,
                    flags.bits(),
                    12345,
                    StMode::APP_FILE,
                )));
            }

            let normalized_path = normalize(PathBuf::from(path));
            if normalized_path.starts_with(&trace_out_dir) && !flags.contains(OFlag::O_DIRECTORY) {
                if let Some(parent) = normalized_path.parent() {
                    let _ = fs::create_dir_all(parent);
                }
                let access_mode = flags.bits() & OFlag::O_ACCMODE.bits();
                let mut options = OpenOptions::new();
                match access_mode {
                    value if value == OFlag::O_WRONLY.bits() => {
                        options.write(true);
                    }
                    value if value == OFlag::O_RDWR.bits() => {
                        options.read(true).write(true);
                    }
                    _ => {
                        options.read(true);
                    }
                }
                if flags.contains(OFlag::O_CREAT) {
                    options.create(true);
                }
                if flags.contains(OFlag::O_TRUNC) {
                    options.truncate(true);
                }
                if flags.contains(OFlag::O_APPEND) {
                    options.append(true);
                }
                if let Ok(file) = options.open(&normalized_path) {
                    return Some(FileIO::File(LinuxFileIO::new_with_file(
                        file,
                        path,
                        flags.bits(),
                        12345,
                        StMode::APP_FILE,
                    )));
                }
            }

            let _ = flags;
            None
        }));
}

fn validate_config(config: &SeetongConfig) -> Result<()> {
    for path in [
        &config.apk_path,
        &config.funclib_agent_path,
        &config.funclib_path,
    ] {
        if !path.is_file() {
            return Err(anyhow!("required file missing: {}", path.display()));
        }
    }
    Ok(())
}

fn normalize_backend_name(value: &str) -> Result<&'static str> {
    BackendKind::parse(value)
        .map(BackendKind::as_str)
        .ok_or_else(|| anyhow!("unsupported backend: {value}"))
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

fn required_option(opts: &HashMap<String, String>, key: &str) -> Result<String> {
    opts.get(key)
        .cloned()
        .ok_or_else(|| anyhow!("missing required option: {key}"))
}

fn jni_value_to_i32(value: JniValue) -> Result<i32> {
    match value {
        JniValue::Int(value) => Ok(value),
        JniValue::Long(value) => Ok(value as i32),
        JniValue::Null => Ok(0),
        other => Err(anyhow!(
            "unexpected JNI int value: {}",
            jni_value_brief(&other)
        )),
    }
}

fn jni_value_to_i64(value: JniValue) -> Result<i64> {
    match value {
        JniValue::Long(value) => Ok(value),
        JniValue::Int(value) => Ok(value as i64),
        JniValue::Null => Ok(0),
        other => Err(anyhow!(
            "unexpected JNI long value: {}",
            jni_value_brief(&other)
        )),
    }
}

fn jni_value_to_string(value: JniValue) -> Result<String> {
    match value {
        JniValue::Object(DvmObject::String(value)) => Ok(value),
        JniValue::Object(DvmObject::ByteArray(bytes)) => {
            Ok(String::from_utf8_lossy(&bytes).to_string())
        }
        other => Err(anyhow!(
            "unexpected JNI string value: {}",
            jni_value_brief(&other)
        )),
    }
}

fn json_to_string(value: &Value) -> String {
    match value {
        Value::String(value) => value.clone(),
        _ => value.to_string(),
    }
}

fn runtime_env_truthy(name: &str) -> bool {
    match std::env::var(name) {
        Ok(value) => matches!(
            value.trim().to_ascii_lowercase().as_str(),
            "1" | "true" | "yes" | "on"
        ),
        Err(_) => false,
    }
}

fn resolve_funclib_symbols(
    module: &emulator::linux::module::LinuxModule<()>,
) -> Result<SeetongNativeSymbols> {
    let ccsinf_ctor = module
        .find_symbol_by_name("_ZN6CCSInfC1Ev", false)
        .context("missing _ZN6CCSInfC1Ev")?
        .address();
    let ccsinf_add_device_stream = module
        .find_symbol_by_name("_ZN6CCSInf15addDeviceStreamEPKc", false)
        .context("missing _ZN6CCSInf15addDeviceStreamEPKc")?
        .address();
    let ccsinf_add_watch_ex = module
        .find_symbol_by_name("_ZN6CCSInf10AddWatchExEPciiii", false)
        .context("missing _ZN6CCSInf10AddWatchExEPciiii")?
        .address();
    let ccsinf_get_dev_picture = module
        .find_symbol_by_name("_ZN6CCSInf13GetDevPictureEPciS0_", false)
        .context("missing _ZN6CCSInf13GetDevPictureEPciS0_")?
        .address();
    let ccsinf_get_siot_access_node = module
        .find_symbol_by_name(GET_SIOT_ACCESS_NODE_SYMBOL, false)
        .context("missing CCSInf::GetSiotAccessNode")?
        .address();
    let ccsinf_resume_dev_com_with_id = module
        .find_symbol_by_name("_ZN6CCSInf18ResumeDevComWithIdEPKc", false)
        .context("missing _ZN6CCSInf18ResumeDevComWithIdEPKc")?
        .address();
    let ccsinf_set_http_header = module
        .find_symbol_by_name("_ZN6CCSInf13setHttpHeaderEP10HttpHeaderPKc", false)
        .context("missing _ZN6CCSInf13setHttpHeaderEP10HttpHeaderPKc")?
        .address();
    let ccsinf_set_user_info2 = module
        .find_symbol_by_name("_ZN6CCSInf12setUserInfo2EPKc", false)
        .context("missing _ZN6CCSInf12setUserInfo2EPKc")?
        .address();
    let ccsinf_keep_logining = module
        .find_symbol_by_name("_ZN6CCSInf12KeepLoginingEv", false)
        .context("missing _ZN6CCSInf12KeepLoginingEv")?
        .address();
    let cnetsdk_ctor = module
        .find_symbol_by_name("_ZN11CNetSDKFuncC1Ev", false)
        .context("missing _ZN11CNetSDKFuncC1Ev")?
        .address();
    let cnetsdk_init = module
        .find_symbol_by_name("_ZN11CNetSDKFunc8SDK_InitEv", false)
        .context("missing _ZN11CNetSDKFunc8SDK_InitEv")?
        .address();
    let cnetsdk_init_ex = module
        .find_symbol_by_name("_ZN11CNetSDKFunc10SDK_InitExEPc", false)
        .context("missing _ZN11CNetSDKFunc10SDK_InitExEPc")?
        .address();
    let cpp_new = module
        .find_symbol_by_name("_Znwm", false)
        .context("missing _Znwm")?
        .address();
    let siot_add_watch = module
        .find_symbol_by_name(SIOT_ADD_WATCH_SYMBOL, false)
        .context("missing SiotDevSession::AddWatch")?
        .address();
    let siot_connect_media_channel = module
        .find_symbol_by_name(SIOT_CONNECT_MEDIA_CHANNEL_SYMBOL, false)
        .context("missing SiotDevSession::ConnectMediaChannel")?
        .address();
    let siot_open_media_channel = module
        .find_symbol_by_name(SIOT_OPEN_MEDIA_CHANNEL_SYMBOL, false)
        .context("missing SiotDevSession::OpenMediaChannel")?
        .address();
    let siot_resume_dev_com = module
        .find_symbol_by_name(SIOT_RESUME_DEV_COM_SYMBOL, false)
        .context("missing SiotDevSession::ResumeDevCom")?
        .address();
    let siot_send_xml_by_media = module
        .find_symbol_by_name(SIOT_SEND_XML_BY_MEDIA_SYMBOL, false)
        .context("missing SiotDevSession::SendXmlMsgByMediaChannel")?
        .address();
    let cp2p_preconnect_media_channel = module
        .find_symbol_by_name(CP2P_PRECONNECT_MEDIA_SYMBOL, false)
        .context("missing CP2PStream::PreConnectMediaChannel")?
        .address();
    let cp2p_awaken_dev = module
        .find_symbol_by_name(CP2P_AWAKEN_DEV_SYMBOL, false)
        .context("missing CP2PStream::AwakenDev")?
        .address();
    let cp2p_open_p2p = module
        .find_symbol_by_name(CP2P_OPEN_P2P_SYMBOL, false)
        .context("missing CP2PStream::OpenP2P")?
        .address();
    let cp2p_send_with_header = module
        .find_symbol_by_name(CP2P_SEND_WITH_HEADER_SYMBOL, false)
        .context("missing CP2PStream::send_with_header")?
        .address();
    let cp2p_read_p2p = module
        .find_symbol_by_name(CP2P_READ_P2P_SYMBOL, false)
        .context("missing CP2PStream::ReadP2P")?
        .address();
    let cp2p_on_media_recv = module
        .find_symbol_by_name(CP2P_ON_MEDIA_RECV_SYMBOL, false)
        .context("missing CP2PStream::OnMediaRecvCallBack")?
        .address();
    let hidden_p2p_transport_connect = module.base + HIDDEN_P2P_TRANSPORT_CONNECT_OFFSET;
    let hidden_p2p_alloc_conn = module.base + HIDDEN_P2P_ALLOC_CONN_OFFSET;
    let hidden_p2p_conn_mode = module.base + HIDDEN_P2P_CONN_MODE_OFFSET;
    let hidden_p2p_open_peer = module.base + HIDDEN_P2P_OPEN_PEER_OFFSET;
    let tpsrtc_connect_device = module
        .find_symbol_by_name(TPSRTC_CONNECT_DEVICE_SYMBOL, false)
        .context("missing TpsrtcWrap::ConnectDevice")?
        .address();
    let tpsrtc_media_control = module
        .find_symbol_by_name(TPSRTC_MEDIA_CONTROL_SYMBOL, false)
        .context("missing TpsrtcWrap::MediaControl")?
        .address();
    let tpsrtc_instance = module
        .find_symbol_by_name("_ZN10TpsrtcWrap8InstanceEv", false)
        .context("missing _ZN10TpsrtcWrap8InstanceEv")?
        .address();
    let tpsrtc_redirect_access = module
        .find_symbol_by_name(
            "_ZN10TpsrtcWrap14RedirectAccessERKNSt6__ndk112basic_stringIcNS0_11char_traitsIcEENS0_9allocatorIcEEEE",
            false,
        )
        .context("missing _ZN10TpsrtcWrap14RedirectAccessERKNSt6__ndk112basic_stringIcNS0_11char_traitsIcEENS0_9allocatorIcEEEE")?
        .address();
    let tpsrtc_startup = module
        .find_symbol_by_name("_ZN10TpsrtcWrap7StartupEPKc", false)
        .context("missing _ZN10TpsrtcWrap7StartupEPKc")?
        .address();
    let fc_loc_login_dev = module
        .find_symbol_by_name("FC_Loc_LoginDev", false)
        .context("missing FC_Loc_LoginDev")?
        .address();
    let fc_loc_logout_dev = module
        .find_symbol_by_name("FC_Loc_LogoutDev", false)
        .context("missing FC_Loc_LogoutDev")?
        .address();
    let fc_loc_real_play_ex = module
        .find_symbol_by_name("FC_Loc_RealPlayEx", false)
        .context("missing FC_Loc_RealPlayEx")?
        .address();
    let fc_loc_stop_real_play = module
        .find_symbol_by_name("FC_Loc_StopRealPlay", false)
        .context("missing FC_Loc_StopRealPlay")?
        .address();
    let trace_add_watch_variants = [
        "_ZN10DevSession8AddWatchEPciiii",
        "_ZN10CP2PStream8AddWatchEPciiii",
        "_ZThn8_N10CP2PStream8AddWatchEPciiii",
    ]
    .into_iter()
    .filter_map(|name| {
        module
            .find_symbol_by_name(name, false)
            .ok()
            .map(|symbol| (name.to_string(), symbol.address()))
    })
    .collect::<Vec<_>>();
    let trace_resume_variants = [
        "_ZN10DevSession12ResumeDevComEv",
        "_ZN10CP2PStream12ResumeDevComEv",
        "_ZThn8_N10CP2PStream12ResumeDevComEv",
        "_ZN10SoldDevice12ResumeDevComEv",
        "_ZN7SDevice12ResumeDevComEv",
    ]
    .into_iter()
    .filter_map(|name| {
        module
            .find_symbol_by_name(name, false)
            .ok()
            .map(|symbol| (name.to_string(), symbol.address()))
    })
    .collect::<Vec<_>>();
    Ok(SeetongNativeSymbols {
        funclib_base: module.base,
        funclib_agent_base: 0,
        ccsinf_ctor,
        ccsinf_add_device_stream,
        ccsinf_add_watch_ex,
        ccsinf_get_dev_picture,
        ccsinf_get_siot_access_node,
        ccsinf_resume_dev_com_with_id,
        ccsinf_set_http_header,
        ccsinf_set_user_info2,
        ccsinf_keep_logining,
        cnetsdk_ctor,
        cnetsdk_init,
        cnetsdk_init_ex,
        cpp_new,
        siot_add_watch,
        siot_connect_media_channel,
        siot_open_media_channel,
        siot_resume_dev_com,
        siot_send_xml_by_media,
        cp2p_preconnect_media_channel,
        cp2p_awaken_dev,
        cp2p_open_p2p,
        cp2p_send_with_header,
        cp2p_read_p2p,
        cp2p_on_media_recv,
        hidden_p2p_transport_connect,
        hidden_p2p_alloc_conn,
        hidden_p2p_conn_mode,
        hidden_p2p_open_peer,
        tpsrtc_connect_device,
        tpsrtc_media_control,
        tpsrtc_instance,
        tpsrtc_redirect_access,
        tpsrtc_startup,
        fc_loc_login_dev,
        fc_loc_logout_dev,
        fc_loc_real_play_ex,
        fc_loc_stop_real_play,
        trace_add_watch_variants,
        trace_resume_variants,
    })
}

fn register_funclib_agent_natives(
    emulator: &AndroidEmulator<()>,
    vm: &mut DalvikVM64<()>,
    module: &emulator::linux::module::LinuxModule<()>,
    class_id: i64,
) -> Result<()> {
    for (method_name, signature) in [
        ("GetSdkVersion", "()Ljava/lang/String;"),
        ("SetHttpsProtocol", "()I"),
        ("SetLargeDevlist", "()I"),
        ("SetFcLogCallBackEx", "(I)I"),
        ("initWithHeader", "(Lipc/android/sdk/impl/FunclibAgent;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I"),
        ("SetMsgRspCallBackAgent", "()I"),
        ("SetMediaRecvCallBackAgent", "()I"),
        ("SetLogServer", "(Ljava/lang/String;)I"),
        ("SetAccessToken", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)I"),
        ("SetUserInfo2", "(Ljava/lang/String;)I"),
        ("GetDevPicture", "(Ljava/lang/String;ILjava/lang/String;)I"),
        ("GetH5AuthInfo", "([B)I"),
        ("SetPriorPreConnectCloudId", "(Ljava/lang/String;)I"),
        ("LoginSigServer", "(Ljava/lang/String;Ljava/lang/String;)I"),
        ("AddDeviceStream", "(Ljava/lang/String;)I"),
        ("ResumeDevComWithId", "(Ljava/lang/String;)I"),
        ("AddWatchEx", "(Ljava/lang/String;IIII)I"),
        ("StopWatchAgent", "(Ljava/lang/String;)I"),
        ("StopDevComWithId", "(Ljava/lang/String;)I"),
        ("FreeAgent", "()I"),
    ] {
        if method_name == "initWithHeader" && runtime_env_truthy("RNIDBG_STUB_INIT_WITH_HEADER") {
            let stub_name = "Java_ipc_android_sdk_impl_FunclibAgent_initWithHeader_stub";
            let fn_ptr = emulator.register_svc(SimpleArm64Svc::new(stub_name, zero_stub::<()>));
            vm.register_native_method(class_id, method_name, signature, fn_ptr).with_context(
                || format!("failed to register stub native method: {method_name}{signature}"),
            )?;
            continue;
        }

        let symbol_name = format!("Java_ipc_android_sdk_impl_FunclibAgent_{method_name}");
        let symbol = module
            .find_symbol_by_name(&symbol_name, false)
            .with_context(|| format!("missing export: {symbol_name}"))?;
        vm.register_native_method(class_id, method_name, signature, symbol.address())
            .with_context(|| format!("failed to register native method: {method_name}{signature}"))?;
    }
    for (method_name, signature) in [
        (
            "AuxResponseCallBackJNI",
            "(JJLjava/lang/String;Ljava/lang/String;)J",
        ),
        ("PlayActionEventCallBackJNI", "(JJJLjava/lang/String;)J"),
        ("RealDataCallBackJNI", "(JJ[BJID)J"),
        ("ReplayDataCallBackJNI", "(JJ[BJ[B)J"),
        ("SearchDevStatusCallBackJNI", "(JJ[B)J"),
        ("StatusEventCallBackJNI", "(JJLjava/lang/String;)J"),
        ("StatusEventCallBackJNI2", "(JJ[BI)J"),
        ("fcLogCallBack", "(ILjava/lang/String;)I"),
        (
            "fcSearchIotBindStateCallBack",
            "(IILjava/lang/String;Ljava/lang/String;)I",
        ),
        ("logCallBack", "(ILjava/lang/String;Ljava/lang/String;)I"),
        ("mediaRecvCallBack", "([BI[BIID)I"),
        ("msgRspCallBack", "(I[BI[BI)I"),
        ("singnal", "(I)V"),
    ] {
        vm.register_native_method(class_id, method_name, signature, 0).with_context(|| {
            format!("failed to register FunclibAgent Java callback placeholder: {method_name}{signature}")
        })?;
    }
    Ok(())
}

fn zero_stub<T: Clone>(_: &str, _: &AndroidEmulator<T>) -> SvcCallResult {
    SvcCallResult::RET(0)
}

fn async_task_sync_stub<T: Clone>(_: &str, emulator: &AndroidEmulator<T>) -> SvcCallResult {
    let task_ptr = emulator
        .backend
        .reg_read(RegisterARM64::X0)
        .unwrap_or_default();
    let _priority = emulator
        .backend
        .reg_read(RegisterARM64::X1)
        .unwrap_or_default();
    if task_ptr == 0 {
        return SvcCallResult::RET(0);
    }

    let callback_owner = emulator.backend.mem_read_u64(task_ptr).unwrap_or_default();
    let callback = if callback_owner != 0 {
        emulator
            .backend
            .mem_read_u64(callback_owner + 16)
            .unwrap_or_default()
    } else {
        0
    };
    if callback != 0 {
        let _ = emulator.e_func(callback, vec![UnicornArg::Ptr(task_ptr)]);
    }

    let _ = emulator
        .backend
        .mem_write(task_ptr + 16, &1u32.to_le_bytes());
    let _ = emulator
        .backend
        .mem_write(task_ptr + 108, &0u32.to_le_bytes());
    let _ = emulator
        .backend
        .mem_write(task_ptr + 112, &0u32.to_le_bytes());
    let _ = emulator
        .backend
        .mem_write(task_ptr + 208, &1u32.to_le_bytes());

    let waiter = emulator
        .backend
        .mem_read_i32(task_ptr + 204)
        .unwrap_or_default();
    if waiter != 0 {
        let funclib_base = *guest_funclib_base_addr()
            .lock()
            .expect("guest funclib base addr lock");
        if let Some(funclib_base) = funclib_base {
            let _ = emulator.e_func(
                funclib_base + 0x6db0b0,
                vec![UnicornArg::Ptr(task_ptr + 0x74)],
            );
        }
    }

    SvcCallResult::RET(1)
}

fn read_guest_c_string<T: Clone>(emulator: &AndroidEmulator<T>, addr: u64) -> String {
    if addr == 0 {
        return String::new();
    }
    emulator
        .backend
        .mem_read_c_string(addr)
        .unwrap_or_default()
        .chars()
        .take(160)
        .collect()
}

fn read_guest_cpp_string<T: Clone>(emulator: &AndroidEmulator<T>, string_ptr: u64) -> String {
    let mut tag_buf = [0u8; 1];
    if emulator.backend.mem_read(string_ptr, &mut tag_buf).is_err() {
        return String::new();
    }
    let tag = tag_buf[0];
    let is_long = (tag & 1) != 0;
    let (len, data_ptr) = if is_long {
        (
            emulator
                .backend
                .mem_read_u64(string_ptr + 8)
                .unwrap_or_default() as usize,
            emulator
                .backend
                .mem_read_u64(string_ptr + 16)
                .unwrap_or_default(),
        )
    } else {
        (((tag as usize) >> 1), string_ptr + 1)
    };
    if len == 0 || data_ptr == 0 {
        return String::new();
    }
    let mut buf = vec![0u8; len.min(256)];
    if emulator.backend.mem_read(data_ptr, &mut buf).is_err() {
        return String::new();
    }
    String::from_utf8_lossy(&buf).to_string()
}

fn read_guest_u8<T: Clone>(emulator: &AndroidEmulator<T>, addr: u64) -> u8 {
    let mut buf = [0u8; 1];
    if emulator.backend.mem_read(addr, &mut buf).is_err() {
        return 0;
    }
    buf[0]
}

fn read_guest_u16<T: Clone>(emulator: &AndroidEmulator<T>, addr: u64) -> u16 {
    let mut buf = [0u8; 2];
    if emulator.backend.mem_read(addr, &mut buf).is_err() {
        return 0;
    }
    u16::from_le_bytes(buf)
}

fn is_plausible_guest_ptr(addr: u64) -> bool {
    (0x1000..0x1_0000_0000).contains(&addr)
}

fn read_guest_bytes<T: Clone>(emulator: &AndroidEmulator<T>, addr: u64, len: usize) -> Vec<u8> {
    if addr == 0 || len == 0 {
        return Vec::new();
    }
    let mut buf = vec![0u8; len];
    if emulator.backend.mem_read(addr, &mut buf).is_err() {
        return Vec::new();
    }
    buf
}

fn read_guest_c_string_limited<T: Clone>(
    emulator: &AndroidEmulator<T>,
    addr: u64,
    max_len: usize,
) -> String {
    let bytes = read_guest_bytes(emulator, addr, max_len);
    let end = bytes
        .iter()
        .position(|byte| *byte == 0)
        .unwrap_or(bytes.len());
    String::from_utf8_lossy(&bytes[..end]).to_string()
}

fn preview_ascii_bytes(data: &[u8], limit: usize) -> String {
    let mut preview = String::new();
    for &byte in data.iter().take(limit) {
        match byte {
            b'\r' => preview.push_str("\\r"),
            b'\n' => preview.push_str("\\n"),
            0x20..=0x7e => preview.push(byte as char),
            _ => preview.push('.'),
        }
    }
    if data.len() > limit {
        preview.push_str("...");
    }
    preview
}

fn find_ccs_device_object<T: Clone>(
    emulator: &AndroidEmulator<T>,
    ccsinf_ptr: u64,
    cloud_id: &str,
) -> Option<(u64, u64)> {
    let root = emulator.backend.mem_read_u64(ccsinf_ptr + 160).ok()?;
    if root == 0 {
        return None;
    }
    let mut stack = vec![root];
    let mut visited = HashSet::new();
    while let Some(node) = stack.pop() {
        if node == 0 || !visited.insert(node) {
            continue;
        }
        let key = read_guest_cpp_string(emulator, node + 32);
        if key == cloud_id {
            let object_ptr = emulator.backend.mem_read_u64(node + 56).unwrap_or(0);
            return Some((node, object_ptr));
        }
        let left = emulator.backend.mem_read_u64(node).unwrap_or(0);
        let right = emulator.backend.mem_read_u64(node + 8).unwrap_or(0);
        if left != 0 {
            stack.push(left);
        }
        if right != 0 {
            stack.push(right);
        }
    }
    None
}

fn find_sold_nvr_watch_session<T: Clone>(
    emulator: &AndroidEmulator<T>,
    sold_device_ptr: u64,
    stream_no: i32,
) -> Option<(u64, u64, u64)> {
    let root = emulator
        .backend
        .mem_read_u64(sold_device_ptr + 232)
        .unwrap_or_default();
    if root == 0 {
        return None;
    }
    let mut node = root;
    loop {
        let key = emulator.backend.mem_read_i32(node + 32).ok()?;
        if stream_no < key {
            node = emulator.backend.mem_read_u64(node).unwrap_or_default();
        } else if stream_no > key {
            node = emulator.backend.mem_read_u64(node + 8).unwrap_or_default();
        } else {
            let holder_ptr = emulator.backend.mem_read_u64(node + 40).unwrap_or_default();
            if holder_ptr == 0 {
                return None;
            }
            let session_ptr = emulator
                .backend
                .mem_read_u64(holder_ptr + 64)
                .unwrap_or_default();
            if session_ptr == 0 {
                return None;
            }
            return Some((node, holder_ptr, session_ptr));
        }
        if node == 0 {
            return None;
        }
    }
}

fn hidden_p2p_entry_addr_from_handle(handle: u32) -> Option<u64> {
    let slot = (handle >> 16) as u64;
    if slot > 0xff {
        return None;
    }
    let base = guest_funclib_base_addr()
        .lock()
        .expect("guest funclib base addr lock")
        .to_owned()?;
    Some(base + HIDDEN_P2P_POOL_OFFSET + slot * 40)
}

fn hidden_p2p_object_addr_from_handle<T: Clone>(
    emulator: &AndroidEmulator<T>,
    handle: u32,
) -> Option<u64> {
    let entry = hidden_p2p_entry_addr_from_handle(handle)?;
    let short_id = read_guest_u16(emulator, entry + 0x38) as u32;
    if short_id != (handle & 0xffff) {
        return None;
    }
    let object = emulator.backend.mem_read_u64(entry + 0x40).ok()?;
    if object == 0 {
        return None;
    }
    Some(object)
}

fn describe_hidden_p2p_object<T: Clone>(emulator: &AndroidEmulator<T>, handle: u32) -> String {
    let Some(entry) = hidden_p2p_entry_addr_from_handle(handle) else {
        return format!("handle=0x{handle:08x} entry=none");
    };
    let short_id = read_guest_u16(emulator, entry + 0x38) as u32;
    let object = emulator
        .backend
        .mem_read_u64(entry + 0x40)
        .unwrap_or_default();
    if object == 0 {
        return format!(
            "handle=0x{handle:08x} entry=0x{entry:x} shortId=0x{short_id:04x} object=0x0"
        );
    }
    let mode = emulator
        .backend
        .mem_read_i32(object + 0x218)
        .unwrap_or_default();
    let ready = emulator
        .backend
        .mem_read_i32(object + 0x21c)
        .unwrap_or_default();
    let init_ret = emulator
        .backend
        .mem_read_i32(object + 0x220)
        .unwrap_or_default();
    let timeout = emulator
        .backend
        .mem_read_i32(object + 0x230)
        .unwrap_or_default();
    let queue = emulator
        .backend
        .mem_read_u64(object + 0x368)
        .unwrap_or_default();
    let queue_cap = emulator
        .backend
        .mem_read_i32(object + 0x370)
        .unwrap_or_default();
    let slot_map = emulator
        .backend
        .mem_read_u64(object + 0x398)
        .unwrap_or_default();
    let server = read_guest_c_string_limited(emulator, object + 0x90, 96);
    format!(
        "handle=0x{handle:08x} entry=0x{entry:x} shortId=0x{short_id:04x} object=0x{object:x} mode={} ready={} initRet={} timeout={} queue=0x{:x} queueCap={} slotMap=0x{:x} server='{}'",
        mode, ready, init_ret, timeout, queue, queue_cap, slot_map, server
    )
}

fn describe_timeout_spec<T: Clone>(emulator: &AndroidEmulator<T>, addr: u64) -> String {
    if addr == 0 {
        return "null".to_string();
    }
    if !is_plausible_guest_ptr(addr) {
        return format!("ptr=0x{addr:x} invalid");
    }
    let a = emulator.backend.mem_read_i32(addr).unwrap_or_default();
    let b = emulator.backend.mem_read_i32(addr + 4).unwrap_or_default();
    let c = emulator.backend.mem_read_i32(addr + 8).unwrap_or_default();
    let d = emulator.backend.mem_read_i32(addr + 12).unwrap_or_default();
    let e = emulator.backend.mem_read_i32(addr + 16).unwrap_or_default();
    let f = emulator.backend.mem_read_i32(addr + 20).unwrap_or_default();
    format!(
        "ptr=0x{addr:x} ints=[{a},{b},{c},{d},{e},{f}] hex={}",
        to_hex_prefix(&read_guest_bytes(emulator, addr, 24))
    )
}

fn safe_guest_c_string_limited<T: Clone>(
    emulator: &AndroidEmulator<T>,
    addr: u64,
    max_len: usize,
) -> String {
    if addr == 0 {
        return String::new();
    }
    if !is_plausible_guest_ptr(addr) {
        return format!("<ptr 0x{addr:x}>");
    }
    read_guest_c_string_limited(emulator, addr, max_len)
}

fn safe_guest_ascii_preview<T: Clone>(
    emulator: &AndroidEmulator<T>,
    addr: u64,
    max_len: usize,
    preview_len: usize,
) -> String {
    if addr == 0 {
        return String::new();
    }
    if !is_plausible_guest_ptr(addr) {
        return format!("<ptr 0x{addr:x}>");
    }
    preview_ascii_bytes(&read_guest_bytes(emulator, addr, max_len), preview_len)
}

fn call_original_hooked_symbol<T: Clone>(
    emulator: &AndroidEmulator<T>,
    symbol_name: &str,
    args: Vec<UnicornArg>,
) -> Result<u64> {
    let original = hooked_symbol_original(symbol_name)
        .ok_or_else(|| anyhow!("missing original hooked symbol: {symbol_name}"))?;
    emulator
        .e_func(original, args)
        .ok_or_else(|| anyhow!("hooked symbol returned no value: {symbol_name}"))
}

fn loc_realplay_data_stub<T: Clone>(_: &str, emulator: &AndroidEmulator<T>) -> SvcCallResult {
    let handle = emulator
        .backend
        .reg_read(RegisterARM64::X0)
        .unwrap_or_default() as i64;
    let media_type = emulator
        .backend
        .reg_read(RegisterARM64::X1)
        .unwrap_or_default() as i64;
    let payload_ptr = emulator
        .backend
        .reg_read(RegisterARM64::X2)
        .unwrap_or_default();
    let payload_len = emulator
        .backend
        .reg_read(RegisterARM64::X3)
        .unwrap_or_default() as usize;
    let ext_ptr = emulator
        .backend
        .reg_read(RegisterARM64::X4)
        .unwrap_or_default();
    let payload = if payload_ptr != 0 && payload_len != 0 {
        read_guest_bytes(emulator, payload_ptr, payload_len)
    } else {
        Vec::new()
    };

    let mut is_key = 0i32;
    let mut pts = 0.0f64;
    if ext_ptr != 0 {
        let ext = read_guest_bytes(emulator, ext_ptr, 24);
        if ext.len() >= 12 {
            is_key = i32::from_le_bytes([ext[0], ext[1], ext[2], ext[3]]);
            pts = f64::from_le_bytes([
                ext[4], ext[5], ext[6], ext[7], ext[8], ext[9], ext[10], ext[11],
            ]);
        }
    }

    append_hook_trace(
        "loc_realplay_cb",
        &format!(
            "handle={} mediaType={} len={} isKey={} pts={}",
            handle, media_type, payload_len, is_key, pts
        ),
    );

    let mut state = loc_realplay_callback_state()
        .lock()
        .expect("loc realplay callback state lock");
    match media_type {
        0 => {
            if let Some(path) = state.video_path.clone() {
                if let Err(err) = append_len_prefixed_frame(&path, &payload) {
                    append_hook_trace("loc_realplay_cb_error", &format!("{err:#}"));
                } else {
                    state.video_frames += 1;
                    state.video_bytes += payload.len() as u64;
                }
            }
        }
        1 => {
            if let Some(path) = state.audio_path.clone() {
                if let Err(err) = append_len_prefixed_frame(&path, &payload) {
                    append_hook_trace("loc_realplay_cb_error", &format!("{err:#}"));
                } else {
                    state.audio_frames += 1;
                    state.audio_bytes += payload.len() as u64;
                }
            }
        }
        _ => {}
    }

    SvcCallResult::RET(0)
}

fn trace_hidden_p2p_alloc_conn_stub<T: Clone>(
    _: &str,
    emulator: &AndroidEmulator<T>,
) -> SvcCallResult {
    let out_conn_ptr = emulator
        .backend
        .reg_read(RegisterARM64::X0)
        .unwrap_or_default();
    let mode = emulator
        .backend
        .reg_read(RegisterARM64::X1)
        .unwrap_or_default() as u32;
    let dev_tag_ptr = emulator
        .backend
        .reg_read(RegisterARM64::X2)
        .unwrap_or_default();
    let transport_tag_ptr = emulator
        .backend
        .reg_read(RegisterARM64::X3)
        .unwrap_or_default();
    let server_ptr = emulator
        .backend
        .reg_read(RegisterARM64::X4)
        .unwrap_or_default();
    let body_ptr = emulator
        .backend
        .reg_read(RegisterARM64::X5)
        .unwrap_or_default();
    let timeout_ptr = emulator
        .backend
        .reg_read(RegisterARM64::X6)
        .unwrap_or_default();
    let callback_ptr = emulator
        .backend
        .reg_read(RegisterARM64::X7)
        .unwrap_or_default();
    let conn_before = emulator
        .backend
        .mem_read_i32(out_conn_ptr)
        .unwrap_or_default() as u32;
    append_hook_trace(
        "p2p_hidden_enter",
        &format!(
            "alloc_conn outConnPtr=0x{:x} connBefore=0x{:08x} mode={} x2=0x{:x} x3=0x{:x} x4=0x{:x} x5=0x{:x} x6=0x{:x} x7=0x{:x}",
            out_conn_ptr,
            conn_before,
            mode,
            dev_tag_ptr,
            transport_tag_ptr,
            server_ptr,
            body_ptr,
            timeout_ptr,
            callback_ptr
        ),
    );
    let ret = call_original_hooked_symbol(
        emulator,
        HIDDEN_P2P_ALLOC_CONN_NAME,
        vec![
            UnicornArg::Ptr(out_conn_ptr),
            UnicornArg::U64(mode as u64),
            UnicornArg::Ptr(dev_tag_ptr),
            UnicornArg::Ptr(transport_tag_ptr),
            UnicornArg::Ptr(server_ptr),
            UnicornArg::Ptr(body_ptr),
            UnicornArg::Ptr(timeout_ptr),
            UnicornArg::Ptr(callback_ptr),
        ],
    )
    .unwrap_or(u64::MAX);
    let conn_after = emulator
        .backend
        .mem_read_i32(out_conn_ptr)
        .unwrap_or_default() as u32;
    append_hook_trace(
        "p2p_hidden_leave",
        &format!(
            "alloc_conn ret={} connAfter=0x{:08x}",
            ret as i64, conn_after
        ),
    );
    SvcCallResult::RET(ret as i64)
}

fn trace_hidden_p2p_transport_connect_stub<T: Clone>(
    _: &str,
    emulator: &AndroidEmulator<T>,
) -> SvcCallResult {
    let object_ptr = emulator
        .backend
        .reg_read(RegisterARM64::X0)
        .unwrap_or_default();
    let mode = emulator
        .backend
        .reg_read(RegisterARM64::X1)
        .unwrap_or_default() as u32;
    let conn_name_ptr = emulator
        .backend
        .reg_read(RegisterARM64::X2)
        .unwrap_or_default();
    let transport_tag_ptr = emulator
        .backend
        .reg_read(RegisterARM64::X3)
        .unwrap_or_default();
    let server_ptr = emulator
        .backend
        .reg_read(RegisterARM64::X4)
        .unwrap_or_default();
    let body_ptr = emulator
        .backend
        .reg_read(RegisterARM64::X5)
        .unwrap_or_default();
    let timeout_ptr = emulator
        .backend
        .reg_read(RegisterARM64::X6)
        .unwrap_or_default();
    let ready_before = emulator
        .backend
        .mem_read_i32(object_ptr + 0x21c)
        .unwrap_or_default();
    let queue_before = emulator
        .backend
        .mem_read_u64(object_ptr + 0x368)
        .unwrap_or_default();
    let cap_before = emulator
        .backend
        .mem_read_i32(object_ptr + 0x370)
        .unwrap_or_default();
    append_hook_trace(
        "p2p_hidden_enter",
        &format!(
            "transport_connect object=0x{:x} mode={} readyBefore={} queueBefore=0x{:x} capBefore={} connName='{}' transportTag='{}' server='{}' body='{}' timeout={}",
            object_ptr,
            mode,
            ready_before,
            queue_before,
            cap_before,
            safe_guest_c_string_limited(emulator, conn_name_ptr, 160),
            safe_guest_c_string_limited(emulator, transport_tag_ptr, 96),
            safe_guest_c_string_limited(emulator, server_ptr, 256),
            safe_guest_ascii_preview(emulator, body_ptr, 256, 200),
            describe_timeout_spec(emulator, timeout_ptr)
        ),
    );
    let mut ret = call_original_hooked_symbol(
        emulator,
        HIDDEN_P2P_TRANSPORT_CONNECT_NAME,
        vec![
            UnicornArg::Ptr(object_ptr),
            UnicornArg::U64(mode as u64),
            UnicornArg::Ptr(conn_name_ptr),
            UnicornArg::Ptr(transport_tag_ptr),
            UnicornArg::Ptr(server_ptr),
            UnicornArg::Ptr(body_ptr),
            UnicornArg::Ptr(timeout_ptr),
        ],
    )
    .unwrap_or(u64::MAX);
    let ready_after = emulator
        .backend
        .mem_read_i32(object_ptr + 0x21c)
        .unwrap_or_default();
    let init_ret = emulator
        .backend
        .mem_read_i32(object_ptr + 0x220)
        .unwrap_or_default();
    let queue_after = emulator
        .backend
        .mem_read_u64(object_ptr + 0x368)
        .unwrap_or_default();
    let cap_after = emulator
        .backend
        .mem_read_i32(object_ptr + 0x370)
        .unwrap_or_default();
    let slot_map = emulator
        .backend
        .mem_read_u64(object_ptr + 0x398)
        .unwrap_or_default();
    if ret != 0 && runtime_env_truthy("RNIDBG_FORCE_P2P_CONNECT_RET0") {
        append_hook_trace(
            "p2p_hidden_force",
            &format!(
                "transport_connect forcing ret=0 from {} object=0x{:x}",
                ret as i64, object_ptr
            ),
        );
        ret = 0;
    }
    append_hook_trace(
        "p2p_hidden_leave",
        &format!(
            "transport_connect ret={} object=0x{:x} readyAfter={} initRet={} queueAfter=0x{:x} capAfter={} slotMap=0x{:x} server='{}'",
            ret as i64,
            object_ptr,
            ready_after,
            init_ret,
            queue_after,
            cap_after,
            slot_map,
            safe_guest_c_string_limited(emulator, object_ptr + 0x90, 96)
        ),
    );
    SvcCallResult::RET(ret as i64)
}

fn trace_hidden_p2p_conn_mode_stub<T: Clone>(
    _: &str,
    emulator: &AndroidEmulator<T>,
) -> SvcCallResult {
    let conn = emulator
        .backend
        .reg_read(RegisterARM64::X0)
        .unwrap_or_default() as u32;
    let mode = emulator
        .backend
        .reg_read(RegisterARM64::X1)
        .unwrap_or_default() as u32;
    append_hook_trace(
        "p2p_hidden_enter",
        &format!(
            "conn_mode conn=0x{:08x} mode={} {}",
            conn,
            mode,
            describe_hidden_p2p_object(emulator, conn)
        ),
    );
    let ret = call_original_hooked_symbol(
        emulator,
        HIDDEN_P2P_CONN_MODE_NAME,
        vec![UnicornArg::U64(conn as u64), UnicornArg::U64(mode as u64)],
    )
    .unwrap_or(u64::MAX);
    append_hook_trace(
        "p2p_hidden_leave",
        &format!(
            "conn_mode ret={} conn=0x{:08x} {}",
            ret as i64,
            conn,
            describe_hidden_p2p_object(emulator, conn)
        ),
    );
    SvcCallResult::RET(ret as i64)
}

fn trace_hidden_p2p_open_peer_stub<T: Clone>(
    _: &str,
    emulator: &AndroidEmulator<T>,
) -> SvcCallResult {
    let conn = emulator
        .backend
        .reg_read(RegisterARM64::X0)
        .unwrap_or_default() as u32;
    let dev_tag_ptr = emulator
        .backend
        .reg_read(RegisterARM64::X1)
        .unwrap_or_default();
    let out_peer_ptr = emulator
        .backend
        .reg_read(RegisterARM64::X2)
        .unwrap_or_default();
    let peer_before = emulator
        .backend
        .mem_read_i32(out_peer_ptr)
        .unwrap_or_default() as u32;
    append_hook_trace(
        "p2p_hidden_enter",
        &format!(
            "open_peer conn=0x{:08x} peerBefore=0x{:08x} devTag='{}' {}",
            conn,
            peer_before,
            safe_guest_c_string_limited(emulator, dev_tag_ptr, 128),
            describe_hidden_p2p_object(emulator, conn)
        ),
    );
    let ret = call_original_hooked_symbol(
        emulator,
        HIDDEN_P2P_OPEN_PEER_NAME,
        vec![
            UnicornArg::U64(conn as u64),
            UnicornArg::Ptr(dev_tag_ptr),
            UnicornArg::Ptr(out_peer_ptr),
        ],
    )
    .unwrap_or(u64::MAX);
    let peer_after = emulator
        .backend
        .mem_read_i32(out_peer_ptr)
        .unwrap_or_default() as u32;
    let peer_desc = hidden_p2p_object_addr_from_handle(emulator, peer_after)
        .map(|addr| format!("peerObject=0x{addr:x}"))
        .unwrap_or_else(|| "peerObject=none".to_string());
    append_hook_trace(
        "p2p_hidden_leave",
        &format!(
            "open_peer ret={} conn=0x{:08x} peerAfter=0x{:08x} {} {}",
            ret as i64,
            conn,
            peer_after,
            describe_hidden_p2p_object(emulator, conn),
            peer_desc
        ),
    );
    SvcCallResult::RET(ret as i64)
}

fn trace_tpsrtc_connect_device_stub<T: Clone>(
    _: &str,
    emulator: &AndroidEmulator<T>,
) -> SvcCallResult {
    let this_ptr = emulator
        .backend
        .reg_read(RegisterARM64::X0)
        .unwrap_or_default();
    let session_ptr = emulator
        .backend
        .reg_read(RegisterARM64::X1)
        .unwrap_or_default();
    append_hook_trace(
        "sym_enter",
        &format!(
            "TpsrtcWrap::ConnectDevice this={} session={}",
            describe_guest_addr_local(emulator, this_ptr),
            describe_guest_addr_local(emulator, session_ptr)
        ),
    );
    let ret = call_original_hooked_symbol(
        emulator,
        TPSRTC_CONNECT_DEVICE_SYMBOL,
        vec![UnicornArg::Ptr(this_ptr), UnicornArg::Ptr(session_ptr)],
    )
    .unwrap_or(0);
    append_hook_trace(
        "sym_leave",
        &format!(
            "TpsrtcWrap::ConnectDevice ret={} conn={}",
            ret,
            describe_guest_addr_local(emulator, ret)
        ),
    );
    SvcCallResult::RET(ret as i64)
}

fn trace_tpsrtc_media_control_stub<T: Clone>(
    _: &str,
    emulator: &AndroidEmulator<T>,
) -> SvcCallResult {
    let this_ptr = emulator
        .backend
        .reg_read(RegisterARM64::X0)
        .unwrap_or_default();
    let conn_ptr = emulator
        .backend
        .reg_read(RegisterARM64::X1)
        .unwrap_or_default();
    let payload_ptr = emulator
        .backend
        .reg_read(RegisterARM64::X2)
        .unwrap_or_default();
    let flag = emulator
        .backend
        .reg_read(RegisterARM64::X3)
        .unwrap_or_default();
    append_hook_trace(
        "sym_enter",
        &format!(
            "TpsrtcWrap::MediaControl this={} conn={} payloadPtr=0x{:x} payload='{}' flag={}",
            describe_guest_addr_local(emulator, this_ptr),
            describe_guest_addr_local(emulator, conn_ptr),
            payload_ptr,
            read_guest_c_string(emulator, payload_ptr),
            flag
        ),
    );
    let ret = call_original_hooked_symbol(
        emulator,
        TPSRTC_MEDIA_CONTROL_SYMBOL,
        vec![
            UnicornArg::Ptr(this_ptr),
            UnicornArg::Ptr(conn_ptr),
            UnicornArg::Ptr(payload_ptr),
            UnicornArg::U64(flag),
        ],
    )
    .unwrap_or(u64::MAX);
    append_hook_trace(
        "sym_leave",
        &format!("TpsrtcWrap::MediaControl ret={}", ret as i64),
    );
    SvcCallResult::RET(ret as i64)
}

fn read_device_ip_string<T: Clone>(emulator: &AndroidEmulator<T>, session_ptr: u64) -> String {
    let device_ptr = emulator
        .backend
        .mem_read_u64(session_ptr + 2400)
        .unwrap_or(0);
    let ip_ptr = if device_ptr != 0 {
        emulator.backend.mem_read_u64(device_ptr + 104).unwrap_or(0)
    } else {
        0
    };
    read_guest_c_string(emulator, ip_ptr)
}

fn trace_resume_variant_stub<T: Clone>(
    symbol_name: &str,
    emulator: &AndroidEmulator<T>,
) -> SvcCallResult {
    let this_ptr = emulator
        .backend
        .reg_read(RegisterARM64::X0)
        .unwrap_or_default();
    let conn_before = emulator.backend.mem_read_u64(this_ptr + 24).unwrap_or(0);
    append_hook_trace(
        "sym_enter",
        &format!(
            "{} this={} connBefore={}",
            symbol_name,
            describe_guest_addr_local(emulator, this_ptr),
            describe_guest_addr_local(emulator, conn_before)
        ),
    );
    let ret = call_original_hooked_symbol(emulator, symbol_name, vec![UnicornArg::Ptr(this_ptr)])
        .unwrap_or(u64::MAX);
    let conn_after = emulator.backend.mem_read_u64(this_ptr + 24).unwrap_or(0);
    append_hook_trace(
        "sym_leave",
        &format!(
            "{} ret={} connAfter={}",
            symbol_name,
            ret as i64,
            describe_guest_addr_local(emulator, conn_after)
        ),
    );
    SvcCallResult::RET(ret as i64)
}

fn trace_add_watch_variant_stub<T: Clone>(
    symbol_name: &str,
    emulator: &AndroidEmulator<T>,
) -> SvcCallResult {
    let this_ptr = emulator
        .backend
        .reg_read(RegisterARM64::X0)
        .unwrap_or_default();
    let dev_id_ptr = emulator
        .backend
        .reg_read(RegisterARM64::X1)
        .unwrap_or_default();
    let stream_no = emulator
        .backend
        .reg_read(RegisterARM64::X2)
        .unwrap_or_default();
    let frame_type = emulator
        .backend
        .reg_read(RegisterARM64::X3)
        .unwrap_or_default();
    let com_type = emulator
        .backend
        .reg_read(RegisterARM64::X4)
        .unwrap_or_default();
    let extra = emulator
        .backend
        .reg_read(RegisterARM64::X5)
        .unwrap_or_default();
    let conn_before = emulator.backend.mem_read_u64(this_ptr + 24).unwrap_or(0);
    append_hook_trace(
        "sym_enter",
        &format!(
            "{} this={} devId='{}' streamNo={} frameType={} comType={} extra={} connBefore={}",
            symbol_name,
            describe_guest_addr_local(emulator, this_ptr),
            read_guest_c_string(emulator, dev_id_ptr),
            stream_no,
            frame_type,
            com_type,
            extra,
            describe_guest_addr_local(emulator, conn_before)
        ),
    );
    let ret = call_original_hooked_symbol(
        emulator,
        symbol_name,
        vec![
            UnicornArg::Ptr(this_ptr),
            UnicornArg::Ptr(dev_id_ptr),
            UnicornArg::U64(stream_no),
            UnicornArg::U64(frame_type),
            UnicornArg::U64(com_type),
            UnicornArg::U64(extra),
        ],
    )
    .unwrap_or(u64::MAX);
    let conn_after = emulator.backend.mem_read_u64(this_ptr + 24).unwrap_or(0);
    append_hook_trace(
        "sym_leave",
        &format!(
            "{} ret={} connAfter={}",
            symbol_name,
            ret as i64,
            describe_guest_addr_local(emulator, conn_after)
        ),
    );
    SvcCallResult::RET(ret as i64)
}

fn trace_siot_resume_dev_com_stub<T: Clone>(
    _: &str,
    emulator: &AndroidEmulator<T>,
) -> SvcCallResult {
    let this_ptr = emulator
        .backend
        .reg_read(RegisterARM64::X0)
        .unwrap_or_default();
    let conn_before = emulator.backend.mem_read_u64(this_ptr + 24).unwrap_or(0);
    append_hook_trace(
        "sym_enter",
        &format!(
            "SiotDevSession::ResumeDevCom this={} connBefore={} ip='{}'",
            describe_guest_addr_local(emulator, this_ptr),
            describe_guest_addr_local(emulator, conn_before),
            read_device_ip_string(emulator, this_ptr)
        ),
    );
    let ret = call_original_hooked_symbol(
        emulator,
        SIOT_RESUME_DEV_COM_SYMBOL,
        vec![UnicornArg::Ptr(this_ptr)],
    )
    .unwrap_or(u64::MAX);
    let conn_after = emulator.backend.mem_read_u64(this_ptr + 24).unwrap_or(0);
    append_hook_trace(
        "sym_leave",
        &format!(
            "SiotDevSession::ResumeDevCom ret={} connAfter={}",
            ret as i64,
            describe_guest_addr_local(emulator, conn_after)
        ),
    );
    SvcCallResult::RET(ret as i64)
}

fn trace_siot_add_watch_stub<T: Clone>(_: &str, emulator: &AndroidEmulator<T>) -> SvcCallResult {
    let this_ptr = emulator
        .backend
        .reg_read(RegisterARM64::X0)
        .unwrap_or_default();
    let dev_id_ptr = emulator
        .backend
        .reg_read(RegisterARM64::X1)
        .unwrap_or_default();
    let stream_no = emulator
        .backend
        .reg_read(RegisterARM64::X2)
        .unwrap_or_default();
    let frame_type = emulator
        .backend
        .reg_read(RegisterARM64::X3)
        .unwrap_or_default();
    let com_type = emulator
        .backend
        .reg_read(RegisterARM64::X4)
        .unwrap_or_default();
    let extra = emulator
        .backend
        .reg_read(RegisterARM64::X5)
        .unwrap_or_default();
    let conn_before = emulator.backend.mem_read_u64(this_ptr + 24).unwrap_or(0);
    let play_tree = emulator.backend.mem_read_u64(this_ptr + 1656).unwrap_or(0);
    let watch_tree = emulator.backend.mem_read_u64(this_ptr + 1936).unwrap_or(0);
    let dev_ptr = emulator.backend.mem_read_u64(this_ptr + 2400).unwrap_or(0);
    append_hook_trace(
        "sym_enter",
        &format!(
            "SiotDevSession::AddWatch this={} devId='{}' streamNo={} frameType={} comType={} extra={} connBefore={} playTree=0x{:x} watchTree=0x{:x} devPtr=0x{:x} ip='{}'",
            describe_guest_addr_local(emulator, this_ptr),
            read_guest_c_string(emulator, dev_id_ptr),
            stream_no,
            frame_type,
            com_type,
            extra,
            describe_guest_addr_local(emulator, conn_before),
            play_tree,
            watch_tree,
            dev_ptr,
            read_device_ip_string(emulator, this_ptr)
        ),
    );
    let ret = call_original_hooked_symbol(
        emulator,
        SIOT_ADD_WATCH_SYMBOL,
        vec![
            UnicornArg::Ptr(this_ptr),
            UnicornArg::Ptr(dev_id_ptr),
            UnicornArg::U64(stream_no),
            UnicornArg::U64(frame_type),
            UnicornArg::U64(com_type),
            UnicornArg::U64(extra),
        ],
    )
    .unwrap_or(u64::MAX);
    let conn_after = emulator.backend.mem_read_u64(this_ptr + 24).unwrap_or(0);
    let play_flag = emulator.backend.mem_read_i32(this_ptr + 280).unwrap_or(0);
    let mut media_ready = [0u8; 1];
    let _ = emulator.backend.mem_read(this_ptr + 9, &mut media_ready);
    append_hook_trace(
        "sym_leave",
        &format!(
            "SiotDevSession::AddWatch ret={} connAfter={} playFlag={} mediaReadyByte={}",
            ret as i64,
            describe_guest_addr_local(emulator, conn_after),
            play_flag,
            media_ready[0]
        ),
    );
    SvcCallResult::RET(ret as i64)
}

fn trace_siot_connect_media_channel_stub<T: Clone>(
    _: &str,
    emulator: &AndroidEmulator<T>,
) -> SvcCallResult {
    let this_ptr = emulator
        .backend
        .reg_read(RegisterARM64::X0)
        .unwrap_or_default();
    let conn_before = emulator.backend.mem_read_u64(this_ptr + 24).unwrap_or(0);
    append_hook_trace(
        "sym_enter",
        &format!(
            "SiotDevSession::ConnectMediaChannel this={} connBefore={}",
            describe_guest_addr_local(emulator, this_ptr),
            describe_guest_addr_local(emulator, conn_before)
        ),
    );
    let ret = call_original_hooked_symbol(
        emulator,
        SIOT_CONNECT_MEDIA_CHANNEL_SYMBOL,
        vec![UnicornArg::Ptr(this_ptr)],
    )
    .unwrap_or(0);
    let conn_after = emulator.backend.mem_read_u64(this_ptr + 24).unwrap_or(0);
    append_hook_trace(
        "sym_leave",
        &format!(
            "SiotDevSession::ConnectMediaChannel ret={} connAfter={}",
            ret as i64,
            describe_guest_addr_local(emulator, conn_after)
        ),
    );
    SvcCallResult::RET(ret as i64)
}

fn trace_siot_open_media_channel_stub<T: Clone>(
    _: &str,
    emulator: &AndroidEmulator<T>,
) -> SvcCallResult {
    let this_ptr = emulator
        .backend
        .reg_read(RegisterARM64::X0)
        .unwrap_or_default();
    append_hook_trace(
        "sym_enter",
        &format!(
            "SiotDevSession::OpenMediaChannel this={}",
            describe_guest_addr_local(emulator, this_ptr)
        ),
    );
    let ret = call_original_hooked_symbol(
        emulator,
        SIOT_OPEN_MEDIA_CHANNEL_SYMBOL,
        vec![UnicornArg::Ptr(this_ptr)],
    )
    .unwrap_or(u64::MAX);
    append_hook_trace(
        "sym_leave",
        &format!("SiotDevSession::OpenMediaChannel ret={}", ret as i64),
    );
    SvcCallResult::RET(ret as i64)
}

fn trace_siot_send_xml_by_media_stub<T: Clone>(
    _: &str,
    emulator: &AndroidEmulator<T>,
) -> SvcCallResult {
    let this_ptr = emulator
        .backend
        .reg_read(RegisterARM64::X0)
        .unwrap_or_default();
    let header_ptr = emulator
        .backend
        .reg_read(RegisterARM64::X1)
        .unwrap_or_default();
    let body_ptr = emulator
        .backend
        .reg_read(RegisterARM64::X2)
        .unwrap_or_default();
    let body_is_utf8 = emulator
        .backend
        .reg_read(RegisterARM64::X3)
        .unwrap_or_default();
    let extra_ptr = emulator
        .backend
        .reg_read(RegisterARM64::X4)
        .unwrap_or_default();
    let resend = emulator
        .backend
        .reg_read(RegisterARM64::X5)
        .unwrap_or_default();
    let timeout = emulator
        .backend
        .reg_read(RegisterARM64::X6)
        .unwrap_or_default();
    append_hook_trace(
        "sym_enter",
        &format!(
            "SiotDevSession::SendXmlMsgByMediaChannel this={} header=0x{:x} body='{}' bodyUtf8={} extra='{}' resend={} timeout={}",
            describe_guest_addr_local(emulator, this_ptr),
            header_ptr,
            read_guest_c_string(emulator, body_ptr),
            body_is_utf8,
            read_guest_c_string(emulator, extra_ptr),
            resend,
            timeout
        ),
    );
    let ret = call_original_hooked_symbol(
        emulator,
        SIOT_SEND_XML_BY_MEDIA_SYMBOL,
        vec![
            UnicornArg::Ptr(this_ptr),
            UnicornArg::Ptr(header_ptr),
            UnicornArg::Ptr(body_ptr),
            UnicornArg::U64(body_is_utf8),
            UnicornArg::Ptr(extra_ptr),
            UnicornArg::U64(resend),
            UnicornArg::U64(timeout),
        ],
    )
    .unwrap_or(u64::MAX);
    append_hook_trace(
        "sym_leave",
        &format!(
            "SiotDevSession::SendXmlMsgByMediaChannel ret={}",
            ret as i64
        ),
    );
    SvcCallResult::RET(ret as i64)
}

fn fc_init_with_header_capture_stub<T: Clone>(
    _: &str,
    emulator: &AndroidEmulator<T>,
) -> SvcCallResult {
    let header_ptr = emulator
        .backend
        .reg_read(RegisterARM64::X0)
        .unwrap_or_default();
    let active_user_domain_ptr = emulator
        .backend
        .reg_read(RegisterARM64::X1)
        .unwrap_or_default();
    let nat_servers_ptr = emulator
        .backend
        .reg_read(RegisterARM64::X2)
        .unwrap_or_default();
    let active_user_domain = emulator
        .backend
        .mem_read_c_string(active_user_domain_ptr)
        .unwrap_or_default();
    let nat_servers = emulator
        .backend
        .mem_read_c_string(nat_servers_ptr)
        .unwrap_or_default();
    *captured_fc_init_args()
        .lock()
        .expect("captured fc init args lock") = Some(CapturedFcInitArgs {
        header_ptr,
        active_user_domain,
        nat_servers,
    });
    SvcCallResult::RET(0)
}

fn memfd_create_stub<T: Clone>(_: &str, _: &AndroidEmulator<T>) -> SvcCallResult {
    SvcCallResult::RET(-1)
}

fn getentropy_stub<T: Clone>(_: &str, _: &AndroidEmulator<T>) -> SvcCallResult {
    SvcCallResult::RET(0)
}

fn get_siot_access_node_stub<T: Clone>(_: &str, emulator: &AndroidEmulator<T>) -> SvcCallResult {
    let this_ptr = emulator
        .backend
        .reg_read(RegisterARM64::X0)
        .unwrap_or_default();
    let out_ptr = emulator
        .backend
        .reg_read(RegisterARM64::X1)
        .unwrap_or_default();

    match ensure_siot_access_node_json().and_then(|json_text| {
        write_guest_long_cpp_string(emulator, out_ptr, &json_text).map(|_| json_text)
    }) {
        Ok(json_text) => {
            if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
                println!(
                    "GetSiotAccessNode stub -> 200 this=0x{:x} out=0x{:x} len={}",
                    this_ptr,
                    out_ptr,
                    json_text.len()
                );
            }
            SvcCallResult::RET(200)
        }
        Err(err) => {
            if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
                println!("GetSiotAccessNode stub fallback failed: {err:#}");
            }
            let original = siot_access_node_stub_state()
                .lock()
                .expect("siot access node stub state lock")
                .original_symbol;
            if let Some(original) = original {
                if let Some(ret) = emulator.e_func(
                    original,
                    vec![UnicornArg::Ptr(this_ptr), UnicornArg::Ptr(out_ptr)],
                ) {
                    return SvcCallResult::RET(ret as i64);
                }
            }
            SvcCallResult::RET(500)
        }
    }
}

fn jni_value_brief(value: &JniValue) -> String {
    match value {
        JniValue::Void => "void".to_string(),
        JniValue::Boolean(value) => value.to_string(),
        JniValue::Byte(value) => value.to_string(),
        JniValue::Char(value) => value.to_string(),
        JniValue::Short(value) => value.to_string(),
        JniValue::Int(value) => value.to_string(),
        JniValue::Long(value) => value.to_string(),
        JniValue::Float(value) => value.to_string(),
        JniValue::Double(value) => value.to_string(),
        JniValue::Null => "null".to_string(),
        JniValue::Object(object) => string_from_object(object),
    }
}

fn string_from_object(object: &DvmObject) -> String {
    match object {
        DvmObject::String(value) => value.clone(),
        DvmObject::ByteArray(bytes) => String::from_utf8_lossy(bytes).to_string(),
        DvmObject::ObjectRef(_) => "<object-ref>".to_string(),
        DvmObject::SimpleInstance(class) => format!("<{}>", class.name),
        DvmObject::ObjectArray(_, values) => format!("<array:{}>", values.len()),
        DvmObject::Class(class) => format!("<class:{}>", class.name),
        DvmObject::DataInstance(_, _) | DvmObject::DataMutInstance(_, _) => "<data>".to_string(),
    }
}

fn try_utf8_prefix(data: &[u8]) -> String {
    let prefix = if data.len() > 512 { &data[..512] } else { data };
    String::from_utf8_lossy(prefix).to_string()
}

fn mask_secret(value: &str, keep: usize) -> String {
    if value.is_empty() {
        return String::new();
    }
    let char_count = value.chars().count();
    if char_count <= keep * 2 {
        return "*".repeat(char_count);
    }
    let head = value.chars().take(keep).collect::<String>();
    let tail = value
        .chars()
        .rev()
        .take(keep)
        .collect::<Vec<_>>()
        .into_iter()
        .rev()
        .collect::<String>();
    format!("{head}...{tail}")
}

fn to_hex_prefix(data: &[u8]) -> String {
    let prefix = if data.len() > 128 { &data[..128] } else { data };
    hex::encode(prefix)
}

fn iso_now() -> String {
    Utc::now().to_rfc3339_opts(SecondsFormat::Millis, true)
}
