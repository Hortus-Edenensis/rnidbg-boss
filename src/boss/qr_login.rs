use std::collections::HashMap;
use std::fs;
use std::io::Read;
use std::path::{Path, PathBuf};
use std::sync::atomic::{AtomicBool, AtomicU64, Ordering};
use std::sync::{Arc, Mutex};
use std::thread::{self, JoinHandle};
use std::time::Duration;

use anyhow::{anyhow, bail, Context, Result};
use reqwest::blocking::Client;
use reqwest::Url;
use serde::{Deserialize, Serialize};
use serde_json::{json, Value};
use sha2::{Digest, Sha256};
use tiny_http::{Header, ListenAddr, Method, Request, Response, Server, StatusCode};

const DEFAULT_HOST: &str = "127.0.0.1";
const DEFAULT_PORT: u16 = 8766;
const DEFAULT_USER_AGENT: &str = "rnidbg/local-qr-login-dualtrack";
const DEFAULT_EDIT_TYPE: &str = "4";
const DEFAULT_ACTION_ID: &str = "local_web_login";
const DEFAULT_EXTRA_INFO: &str = "local_mock";

static LAST_REQUEST_MS: AtomicU64 = AtomicU64::new(0);

#[derive(Clone, Debug, Deserialize, Serialize)]
#[serde(default)]
pub struct SessionConfig {
    pub uid: String,
    pub identity: String,
    #[serde(rename = "t", alias = "token")]
    pub token: String,
    #[serde(rename = "t2", alias = "token2")]
    pub token2: String,
    pub wt: String,
    #[serde(rename = "zpAt", alias = "zp_at")]
    pub zp_at: String,
    pub secret_key: String,
    pub phone: String,
    pub region_code: String,
    pub register: bool,
    pub login_time: f64,
    pub expire_hint: String,
    pub fp_uniqid: String,
    pub fp_did: String,
    pub fp_oaid: String,
    pub fp_oaid_honor: String,
    pub fp_brand: String,
    pub fp_model: String,
    pub fp_network: String,
    pub fp_operator: String,
    pub fp_tinker_id: String,
}

impl SessionConfig {
    pub fn is_valid(&self) -> bool {
        !self.token2.trim().is_empty()
    }

    pub fn has_fingerprint(&self) -> bool {
        !self.fp_uniqid.trim().is_empty() && !self.fp_did.trim().is_empty()
    }
}

impl Default for SessionConfig {
    fn default() -> Self {
        Self {
            uid: String::new(),
            identity: String::new(),
            token: String::new(),
            token2: String::new(),
            wt: String::new(),
            zp_at: String::new(),
            secret_key: String::new(),
            phone: String::new(),
            region_code: "86".to_string(),
            register: false,
            login_time: 0.0,
            expire_hint: String::new(),
            fp_uniqid: String::new(),
            fp_did: String::new(),
            fp_oaid: String::new(),
            fp_oaid_honor: String::new(),
            fp_brand: String::new(),
            fp_model: String::new(),
            fp_network: String::new(),
            fp_operator: String::new(),
            fp_tinker_id: String::new(),
        }
    }
}

#[derive(Clone, Debug, Default, Deserialize, Serialize)]
pub struct DeviceConfig {
    pub uniqid: String,
    pub did: String,
    pub oaid: String,
    pub oaid_honor: String,
    pub brand: String,
    pub model: String,
    pub network: String,
    pub operator: String,
    pub tinker_id: String,
    pub curidentity: i32,
    pub secret_key: String,
}

impl DeviceConfig {
    pub fn from_session(session: &SessionConfig) -> Self {
        let seed = sha12(&format!(
            "{}:{}:{}",
            session.uid, session.token2, session.phone
        ));
        let mut device = if session.has_fingerprint() {
            Self {
                uniqid: session.fp_uniqid.clone(),
                did: session.fp_did.clone(),
                oaid: session.fp_oaid.clone(),
                oaid_honor: session.fp_oaid_honor.clone(),
                brand: session.fp_brand.clone(),
                model: session.fp_model.clone(),
                network: session.fp_network.clone(),
                operator: session.fp_operator.clone(),
                tinker_id: session.fp_tinker_id.clone(),
                curidentity: session.identity.trim().parse::<i32>().unwrap_or(0),
                secret_key: session.secret_key.clone(),
            }
        } else {
            Self::default()
        };

        if device.uniqid.is_empty() {
            device.uniqid = format!("mock-uniqid-{seed}");
        }
        if device.did.is_empty() {
            device.did = format!("mock-did-{seed}");
        }
        if device.brand.is_empty() {
            device.brand = "mock".to_string();
        }
        if device.model.is_empty() {
            device.model = "mock||local-browser".to_string();
        }
        if device.network.is_empty() {
            device.network = "wifi".to_string();
        }
        if device.operator.is_empty() {
            device.operator = "mock-op".to_string();
        }
        if device.tinker_id.is_empty() {
            device.tinker_id = format!("mock-tinker-{}", &seed[..8]);
        }
        device.curidentity = session.identity.trim().parse::<i32>().unwrap_or(0);
        device.secret_key = session.secret_key.clone();
        device
    }
}

#[derive(Clone, Debug, Serialize)]
pub struct FlowEvent {
    pub track: String,
    pub event: String,
    pub payload: HashMap<String, Value>,
    pub ts_ms: u64,
}

#[derive(Clone, Debug, Serialize)]
pub struct ProducerFlow {
    pub producer_id: String,
    pub edit_type: String,
    pub action_id: String,
    pub extra_info: String,
    pub first_qr_id: String,
    pub second_qr_id: String,
    pub first_scan_text: String,
    pub second_scan_text: String,
    pub state: String,
    pub bound_session_preview: String,
    pub first_scan_received_at_ms: u64,
    pub second_scan_received_at_ms: u64,
    pub login_received_at_ms: u64,
    pub login_type: i32,
    pub failure_reason: String,
    pub login_granted: bool,
    pub created_at_ms: u64,
    pub events: Vec<FlowEvent>,
}

impl ProducerFlow {
    fn new(edit_type: &str, action_id: &str, extra_info: &str) -> Self {
        let producer_id = format!("{:08x}", rand::random::<u32>());
        let first_qr_id = format!("mockqr-{producer_id}-first");
        let second_qr_id = format!("bosszp-{producer_id}-second");
        let first_scan_text = format!(
            "https://mock.local/scan?qrcode={}",
            urlencoding_like(&first_qr_id)
        );
        let second_scan_text = second_qr_id.clone();
        let mut flow = Self {
            producer_id,
            edit_type: edit_type.to_string(),
            action_id: action_id.to_string(),
            extra_info: extra_info.to_string(),
            first_qr_id,
            second_qr_id,
            first_scan_text,
            second_scan_text,
            state: "producer_ready".to_string(),
            bound_session_preview: String::new(),
            first_scan_received_at_ms: 0,
            second_scan_received_at_ms: 0,
            login_received_at_ms: 0,
            login_type: 0,
            failure_reason: String::new(),
            login_granted: false,
            created_at_ms: now_ms(),
            events: Vec::new(),
        };
        flow.add_event(
            "producer",
            "flow_created",
            json!({ "producer_id": flow.producer_id }),
        );
        flow
    }

    fn add_event(&mut self, track: &str, event: &str, payload: Value) {
        let payload_map = payload
            .as_object()
            .cloned()
            .unwrap_or_default()
            .into_iter()
            .collect::<HashMap<_, _>>();
        self.events.push(FlowEvent {
            track: track.to_string(),
            event: event.to_string(),
            payload: payload_map,
            ts_ms: now_ms(),
        });
    }

    fn to_value(&self, origin: &str) -> Value {
        let mut value = serde_json::to_value(self).unwrap_or_else(|_| json!({}));
        if let Some(object) = value.as_object_mut() {
            object.insert(
                "producer_url".to_string(),
                Value::String(format!("{origin}/producer/{}", self.producer_id)),
            );
        }
        value
    }
}

#[derive(Debug)]
pub struct FlowError {
    pub code: u16,
    pub message: String,
}

impl FlowError {
    fn new(code: u16, message: impl Into<String>) -> Self {
        Self {
            code,
            message: message.into(),
        }
    }
}

impl std::fmt::Display for FlowError {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        write!(f, "{}", self.message)
    }
}

impl std::error::Error for FlowError {}

#[derive(Default)]
pub struct LocalQrFlowStore {
    flows: HashMap<String, ProducerFlow>,
}

impl LocalQrFlowStore {
    pub fn create_flow(
        &mut self,
        edit_type: &str,
        action_id: &str,
        extra_info: &str,
    ) -> ProducerFlow {
        let flow = ProducerFlow::new(edit_type, action_id, extra_info);
        self.flows.insert(flow.producer_id.clone(), flow.clone());
        flow
    }

    pub fn get_flow(&self, producer_id: &str) -> Result<ProducerFlow, FlowError> {
        self.flows
            .get(producer_id)
            .cloned()
            .ok_or_else(|| FlowError::new(404, format!("producer not found: {producer_id}")))
    }

    fn find_by_first_qr_mut(&mut self, qr_id: &str) -> Result<&mut ProducerFlow, FlowError> {
        self.flows
            .values_mut()
            .find(|flow| flow.first_qr_id == qr_id)
            .ok_or_else(|| FlowError::new(404, format!("first qr not found: {qr_id}")))
    }

    fn find_by_second_qr_mut(&mut self, qr_id: &str) -> Result<&mut ProducerFlow, FlowError> {
        self.flows
            .values_mut()
            .find(|flow| flow.second_qr_id == qr_id)
            .ok_or_else(|| FlowError::new(404, format!("second qr not found: {qr_id}")))
    }

    pub fn web_scan_edit(
        &mut self,
        qr_id: &str,
        edit_type: &str,
        action_id: &str,
        extra_info: &str,
        session_preview: &str,
    ) -> Result<Value, FlowError> {
        let flow = self.find_by_first_qr_mut(qr_id)?;
        if !flow.bound_session_preview.is_empty() && flow.bound_session_preview != session_preview {
            return Err(FlowError::new(
                409,
                "first scan already bound to a different session",
            ));
        }
        flow.bound_session_preview = session_preview.to_string();
        flow.state = "first_scan_bound".to_string();
        flow.first_scan_received_at_ms = now_ms();
        flow.add_event(
            "consumer",
            "web_scan_edit",
            json!({
                "qr_id": qr_id,
                "edit_type": edit_type,
                "action_id": action_id,
                "extra_info": extra_info,
                "session_preview": session_preview,
            }),
        );
        Ok(json!({
            "producer_id": flow.producer_id,
            "state": flow.state,
            "first_qr_id": flow.first_qr_id,
            "session_preview": flow.bound_session_preview,
        }))
    }

    pub fn web_second_scan(
        &mut self,
        qr_id: &str,
        session_preview: &str,
    ) -> Result<Value, FlowError> {
        let flow = self.find_by_second_qr_mut(qr_id)?;
        if flow.state != "first_scan_bound" {
            return Err(FlowError::new(
                409,
                format!("second scan requires first_scan_bound, got={}", flow.state),
            ));
        }
        if flow.bound_session_preview != session_preview {
            return Err(FlowError::new(
                409,
                "second scan session does not match first scan session",
            ));
        }
        flow.state = "awaiting_login_confirm".to_string();
        flow.second_scan_received_at_ms = now_ms();
        flow.add_event(
            "consumer",
            "web_second_scan",
            json!({
                "qr_id": qr_id,
                "session_preview": session_preview,
            }),
        );
        Ok(json!({
            "producer_id": flow.producer_id,
            "state": flow.state,
            "second_qr_id": flow.second_qr_id,
            "session_preview": flow.bound_session_preview,
        }))
    }

    pub fn qrcode_login(
        &mut self,
        qr_id: &str,
        second_qr_id: &str,
        login_type: i32,
        session_preview: &str,
    ) -> Result<Value, FlowError> {
        let flow = self.find_by_first_qr_mut(qr_id)?;
        if flow.second_qr_id != second_qr_id {
            return Err(FlowError::new(
                409,
                "secondQrId does not match producer state",
            ));
        }
        if flow.state != "awaiting_login_confirm" {
            return Err(FlowError::new(
                409,
                format!("login requires awaiting_login_confirm, got={}", flow.state),
            ));
        }
        if flow.bound_session_preview != session_preview {
            return Err(FlowError::new(
                409,
                "login session does not match scan session",
            ));
        }
        flow.login_received_at_ms = now_ms();
        flow.login_type = login_type;
        if login_type == 1 {
            flow.state = "logged_in".to_string();
            flow.login_granted = true;
        } else {
            flow.state = "secondary_action".to_string();
            flow.login_granted = false;
        }
        flow.add_event(
            "consumer",
            "qrcode_login",
            json!({
                "qr_id": qr_id,
                "second_qr_id": second_qr_id,
                "login_type": login_type,
                "session_preview": session_preview,
            }),
        );
        Ok(json!({
            "producer_id": flow.producer_id,
            "state": flow.state,
            "login_granted": flow.login_granted,
            "login_type": flow.login_type,
        }))
    }
}

pub struct LocalQrMockServer {
    host: String,
    port: u16,
    state: Arc<Mutex<LocalQrFlowStore>>,
    shutdown: Arc<AtomicBool>,
    server: Option<Arc<Server>>,
    thread: Option<JoinHandle<()>>,
}

impl LocalQrMockServer {
    pub fn new(host: &str, port: u16) -> Self {
        Self {
            host: host.to_string(),
            port,
            state: Arc::new(Mutex::new(LocalQrFlowStore::default())),
            shutdown: Arc::new(AtomicBool::new(false)),
            server: None,
            thread: None,
        }
    }

    pub fn start(&mut self) -> Result<&mut Self> {
        if self.server.is_some() {
            return Ok(self);
        }
        let server = Arc::new(
            Server::http((self.host.as_str(), self.port))
                .map_err(|err| anyhow!("failed to bind qr mock server: {err}"))?,
        );
        let server_for_thread = server.clone();
        let state = self.state.clone();
        let shutdown = self.shutdown.clone();
        let origin = base_url_from_addr(server.server_addr())?;
        self.port = listen_port(server.server_addr())?;

        let thread = thread::spawn(move || loop {
            if shutdown.load(Ordering::Relaxed) {
                break;
            }
            match server_for_thread.recv_timeout(Duration::from_millis(200)) {
                Ok(Some(request)) => handle_request(request, state.clone(), &origin),
                Ok(None) => continue,
                Err(_) => break,
            }
        });

        self.server = Some(server);
        self.thread = Some(thread);
        Ok(self)
    }

    pub fn stop(&mut self) {
        self.shutdown.store(true, Ordering::Relaxed);
        if let Some(server) = &self.server {
            server.unblock();
        }
        if let Some(thread) = self.thread.take() {
            let _ = thread.join();
        }
        self.server = None;
    }

    pub fn base_url(&self) -> Result<String> {
        let server = self
            .server
            .as_ref()
            .ok_or_else(|| anyhow!("server is not started"))?;
        base_url_from_addr(server.server_addr())
    }

    pub fn create_flow(
        &self,
        edit_type: &str,
        action_id: &str,
        extra_info: &str,
    ) -> Result<ProducerFlow> {
        let mut state = self
            .state
            .lock()
            .map_err(|_| anyhow!("state lock poisoned"))?;
        Ok(state.create_flow(edit_type, action_id, extra_info))
    }
}

impl Drop for LocalQrMockServer {
    fn drop(&mut self) {
        self.stop();
    }
}

pub struct LocalQrSessionConsumer {
    base_url: String,
    host: String,
    session: SessionConfig,
    device: DeviceConfig,
    user_agent: String,
    client: Client,
}

impl LocalQrSessionConsumer {
    pub fn new(base_url: &str, session: SessionConfig) -> Result<Self> {
        if !session.is_valid() {
            bail!("session is not valid: missing token2");
        }
        let base_url = base_url.trim_end_matches('/').to_string();
        let parsed = Url::parse(&base_url)?;
        let host = parsed
            .host_str()
            .map(|host| match parsed.port() {
                Some(port) => format!("{host}:{port}"),
                None => host.to_string(),
            })
            .unwrap_or_else(|| format!("{DEFAULT_HOST}:{DEFAULT_PORT}"));
        Ok(Self {
            base_url,
            host,
            session: session.clone(),
            device: DeviceConfig::from_session(&session),
            user_agent: DEFAULT_USER_AGENT.to_string(),
            client: Client::builder().timeout(Duration::from_secs(10)).build()?,
        })
    }

    pub fn fetch_flow(&self, producer_id: &str) -> Result<Value> {
        let payload = self.request_json(Method::Get, &format!("/api/flows/{producer_id}"), None)?;
        Ok(payload.get("flow").cloned().unwrap_or_else(|| json!({})))
    }

    pub fn consume_scan_texts(
        &self,
        first_scan_text: &str,
        second_scan_text: &str,
        edit_type: &str,
        action_id: &str,
        extra_info: &str,
        login_type: i32,
    ) -> Result<Value> {
        let first_qr_id = extract_qr_id(first_scan_text)?;
        let second_qr_id = extract_qr_id(second_scan_text)?;
        let first = self.request_json(
            Method::Post,
            "/mock_passport/qrcode/webScanEdit",
            Some(json!({
                "qrId": first_qr_id,
                "editType": edit_type,
                "action_id": action_id,
                "extraInfo": extra_info,
            })),
        )?;
        let second = self.request_json(
            Method::Post,
            "/mock_passport/qrcode/webSecondScan",
            Some(json!({ "qrId": second_qr_id })),
        )?;
        let login = self.request_json(
            Method::Post,
            "/mock_passport/qrcode/login",
            Some(json!({
                "loginType": login_type,
                "qrId": first_qr_id,
                "secondQrId": second_qr_id,
            })),
        )?;
        Ok(json!({
            "first_scan": first,
            "second_scan": second,
            "login": login,
            "session_preview": session_preview(&self.session),
        }))
    }

    pub fn consume_producer(&self, producer_id: &str, login_type: i32) -> Result<Value> {
        let flow = self.fetch_flow(producer_id)?;
        self.consume_scan_texts(
            flow.get("first_scan_text")
                .and_then(Value::as_str)
                .unwrap_or_default(),
            flow.get("second_scan_text")
                .and_then(Value::as_str)
                .unwrap_or_default(),
            flow.get("edit_type")
                .and_then(Value::as_str)
                .unwrap_or_default(),
            flow.get("action_id")
                .and_then(Value::as_str)
                .unwrap_or_default(),
            flow.get("extra_info")
                .and_then(Value::as_str)
                .unwrap_or_default(),
            login_type,
        )
    }

    fn request_json(&self, method: Method, path: &str, payload: Option<Value>) -> Result<Value> {
        let url = format!("{}/{}", self.base_url, path.trim_start_matches('/'));
        let mut request = self
            .client
            .request(reqwest_method(method), &url)
            .headers(headers_to_reqwest(self.headers()));
        if let Some(payload) = payload {
            request = request.json(&payload);
        }
        let response = request.send()?;
        let status = response.status();
        let value: Value = response.json()?;
        if !status.is_success() {
            let code = value
                .get("code")
                .and_then(Value::as_u64)
                .unwrap_or(status.as_u16() as u64);
            let message = value
                .get("message")
                .and_then(Value::as_str)
                .unwrap_or("request failed");
            bail!("mock request failed {}: {}", code, message);
        }
        Ok(value)
    }

    fn headers(&self) -> HashMap<String, String> {
        build_stage_inbound_headers(
            &self.user_agent,
            &self.host,
            &self.device,
            Some(&self.session),
            Some(HashMap::from([
                ("TraceId".to_string(), format!("local-trace-{}", now_ms())),
                (
                    "ZP-Tag".to_string(),
                    format!("local-zp-tag-{}", sha12(&self.session.token2)),
                ),
                (
                    "X-Mock-Session-Uid".to_string(),
                    if self.session.uid.is_empty() {
                        "anon".to_string()
                    } else {
                        self.session.uid.clone()
                    },
                ),
            ])),
        )
    }
}

pub fn run_qr_serve(opts: &HashMap<String, String>) -> Result<()> {
    let host = opts
        .get("--host")
        .map(String::as_str)
        .unwrap_or(DEFAULT_HOST);
    let port = opts
        .get("--port")
        .map(|value| value.parse::<u16>())
        .transpose()?
        .unwrap_or(DEFAULT_PORT);
    let edit_type = opts
        .get("--edit-type")
        .map(String::as_str)
        .unwrap_or(DEFAULT_EDIT_TYPE);
    let action_id = opts
        .get("--action-id")
        .map(String::as_str)
        .unwrap_or(DEFAULT_ACTION_ID);
    let extra_info = opts
        .get("--extra-info")
        .map(String::as_str)
        .unwrap_or(DEFAULT_EXTRA_INFO);

    let mut server = LocalQrMockServer::new(host, port);
    server.start()?;
    let flow = server.create_flow(edit_type, action_id, extra_info)?;
    let base_url = server.base_url()?;
    println!(
        "{}",
        serde_json::to_string_pretty(&json!({
            "base_url": base_url,
            "producer_id": flow.producer_id,
            "producer_url": format!("{}/producer/{}", base_url, flow.producer_id),
            "first_scan_text": flow.first_scan_text,
            "second_scan_text": flow.second_scan_text,
            "edit_type": flow.edit_type,
            "action_id": flow.action_id,
            "extra_info": flow.extra_info,
        }))?
    );
    loop {
        thread::sleep(Duration::from_secs(3600));
    }
}

pub fn run_qr_consume(opts: &HashMap<String, String>) -> Result<Value> {
    let base_url = opts
        .get("--base-url")
        .map(String::as_str)
        .unwrap_or("http://127.0.0.1:8766");
    let producer_id = opts
        .get("--producer-id")
        .cloned()
        .ok_or_else(|| anyhow!("missing required option: --producer-id"))?;
    let login_type = opts
        .get("--login-type")
        .map(|value| value.parse::<i32>())
        .transpose()?
        .unwrap_or(1);
    let session_path = opts.get("--session-path").map(String::as_str);
    let session = load_session(session_path)?;
    let consumer = LocalQrSessionConsumer::new(base_url, session)?;
    consumer.consume_producer(&producer_id, login_type)
}

pub fn extract_qr_id(scanned_text: &str) -> Result<String> {
    let raw = scanned_text.trim();
    if raw.is_empty() {
        bail!("scan text is empty");
    }
    if raw.starts_with("http://") || raw.starts_with("https://") {
        let parsed = Url::parse(raw)?;
        for (key, value) in parsed.query_pairs() {
            if key == "qrcode" && !value.trim().is_empty() {
                return Ok(value.to_string());
            }
        }
    } else if raw.starts_with("bosszp-") {
        return Ok(raw.to_string());
    }
    bail!(
        "scan text is not a supported login QR payload: {}",
        truncate(raw, 80)
    )
}

fn handle_request(mut request: Request, state: Arc<Mutex<LocalQrFlowStore>>, origin: &str) {
    let method = request.method().clone();
    let path = request
        .url()
        .split('?')
        .next()
        .unwrap_or("/")
        .trim_end_matches('/');
    let path = if path.is_empty() { "/" } else { path };

    let response = match (method, path) {
        (Method::Get, "/healthz") => {
            json_response(StatusCode(200), json!({ "code": 0, "message": "ok" }))
        }
        (Method::Get, path) if path.starts_with("/api/flows/") => {
            let producer_id = path.rsplit('/').next().unwrap_or_default();
            match with_state(&state, |store| store.get_flow(producer_id)) {
                Ok(flow) => json_response(
                    StatusCode(200),
                    json!({ "code": 0, "message": "ok", "flow": flow.to_value(origin) }),
                ),
                Err(err) => json_response(
                    StatusCode(err.code),
                    json!({ "code": err.code, "message": err.message }),
                ),
            }
        }
        (Method::Get, path) if path.starts_with("/producer/") => {
            let producer_id = path.rsplit('/').next().unwrap_or_default();
            match with_state(&state, |store| store.get_flow(producer_id)) {
                Ok(flow) => html_response(producer_page_html(origin, &flow)),
                Err(err) => {
                    html_response(format!("<h1>{}</h1><pre>{}</pre>", err.code, err.message))
                }
            }
        }
        (Method::Post, "/api/flows") => match read_json_body(&mut request).and_then(|payload| {
            Ok(with_state(&state, |store| {
                Ok(store.create_flow(
                    payload
                        .get("editType")
                        .and_then(Value::as_str)
                        .unwrap_or(DEFAULT_EDIT_TYPE),
                    payload
                        .get("actionId")
                        .and_then(Value::as_str)
                        .unwrap_or(DEFAULT_ACTION_ID),
                    payload
                        .get("extraInfo")
                        .and_then(Value::as_str)
                        .unwrap_or(DEFAULT_EXTRA_INFO),
                ))
            })
            .map_err(anyhow::Error::from)?)
        }) {
            Ok(flow) => json_response(
                StatusCode(200),
                json!({ "code": 0, "message": "ok", "flow": flow.to_value(origin) }),
            ),
            Err(err) => error_to_response(err),
        },
        (Method::Post, "/mock_passport/qrcode/webScanEdit") => match read_json_body(&mut request)
            .and_then(|payload| {
                let session_preview = session_preview_from_headers(request.headers())?;
                Ok(with_state(&state, |store| {
                    store.web_scan_edit(
                        payload
                            .get("qrId")
                            .and_then(Value::as_str)
                            .unwrap_or_default(),
                        payload
                            .get("editType")
                            .and_then(Value::as_str)
                            .unwrap_or_default(),
                        payload
                            .get("action_id")
                            .and_then(Value::as_str)
                            .unwrap_or_default(),
                        payload
                            .get("extraInfo")
                            .and_then(Value::as_str)
                            .unwrap_or_default(),
                        &session_preview,
                    )
                })
                .map_err(anyhow::Error::from)?)
            }) {
            Ok(out) => json_response(
                StatusCode(200),
                json!({ "code": 0, "message": "Success", "zpData": out }),
            ),
            Err(err) => error_to_response(err),
        },
        (Method::Post, "/mock_passport/qrcode/webSecondScan") => match read_json_body(&mut request)
            .and_then(|payload| {
                let session_preview = session_preview_from_headers(request.headers())?;
                Ok(with_state(&state, |store| {
                    store.web_second_scan(
                        payload
                            .get("qrId")
                            .and_then(Value::as_str)
                            .unwrap_or_default(),
                        &session_preview,
                    )
                })
                .map_err(anyhow::Error::from)?)
            }) {
            Ok(out) => json_response(
                StatusCode(200),
                json!({ "code": 0, "message": "Success", "zpData": out }),
            ),
            Err(err) => error_to_response(err),
        },
        (Method::Post, "/mock_passport/qrcode/login") => match read_json_body(&mut request)
            .and_then(|payload| {
                let session_preview = session_preview_from_headers(request.headers())?;
                Ok(with_state(&state, |store| {
                    store.qrcode_login(
                        payload
                            .get("qrId")
                            .and_then(Value::as_str)
                            .unwrap_or_default(),
                        payload
                            .get("secondQrId")
                            .and_then(Value::as_str)
                            .unwrap_or_default(),
                        payload
                            .get("loginType")
                            .and_then(Value::as_i64)
                            .unwrap_or(1) as i32,
                        &session_preview,
                    )
                })
                .map_err(anyhow::Error::from)?)
            }) {
            Ok(out) => json_response(
                StatusCode(200),
                json!({ "code": 0, "message": "Success", "toast": "local login granted", "zpData": out }),
            ),
            Err(err) => error_to_response(err),
        },
        _ => json_response(
            StatusCode(404),
            json!({ "code": 404, "message": format!("not found: {path}") }),
        ),
    };

    let _ = request.respond(response);
}

fn with_state<T>(
    state: &Arc<Mutex<LocalQrFlowStore>>,
    f: impl FnOnce(&mut LocalQrFlowStore) -> std::result::Result<T, FlowError>,
) -> std::result::Result<T, FlowError> {
    let mut store = state
        .lock()
        .map_err(|_| FlowError::new(500, "state lock poisoned"))?;
    f(&mut store)
}

fn producer_page_html(origin: &str, flow: &ProducerFlow) -> String {
    let flow_json =
        serde_json::to_string_pretty(&flow.to_value(origin)).unwrap_or_else(|_| "{}".to_string());
    format!(
        "<!doctype html><html lang=\"zh-CN\"><head><meta charset=\"utf-8\" /><title>Local QR Producer</title>\
         <style>body{{font-family:system-ui,sans-serif;margin:32px;background:#f7f9fc;color:#18202b}}pre{{background:#fff;padding:12px;border:1px solid #d9e1ec;border-radius:12px;overflow:auto}}.card{{background:#fff;border:1px solid #d9e1ec;border-radius:16px;padding:20px;box-shadow:0 12px 30px rgba(17,34,68,.08)}}</style></head>\
         <body><div class=\"card\"><h1>Local QR Producer</h1><p>当前页面会定时刷新 flow 状态。</p><pre id=\"flow\">{flow_json}</pre></div>\
         <script>async function refresh(){{const r=await fetch('/api/flows/{producer_id}');const j=await r.json();document.getElementById('flow').textContent=JSON.stringify(j.flow,null,2);}}setInterval(refresh,1000);</script></body></html>",
        producer_id = flow.producer_id
    )
}

fn session_preview_from_headers(headers: &[Header]) -> Result<String> {
    let cookie = header_value(headers, "Cookie").unwrap_or_default();
    let cookies = parse_cookie_header(&cookie);
    let token2 = header_value(headers, "t2")
        .filter(|value| !value.trim().is_empty())
        .or_else(|| cookies.get("wt2").cloned())
        .unwrap_or_default();
    if token2.trim().is_empty() {
        bail!("missing t2/wt2 session token");
    }
    let mock_uid = header_value(headers, "X-Mock-Session-Uid").unwrap_or_default();
    let uid = if mock_uid.trim().is_empty() {
        "anon"
    } else {
        mock_uid.trim()
    };
    Ok(format!("{uid}:{}", sha12(&token2)))
}

fn parse_cookie_header(raw: &str) -> HashMap<String, String> {
    raw.split(';')
        .filter_map(|chunk| {
            let text = chunk.trim();
            if text.is_empty() {
                return None;
            }
            let (key, value) = text.split_once('=')?;
            let key = key.trim();
            let value = value.trim();
            if key.is_empty() || value.is_empty() {
                return None;
            }
            Some((key.to_string(), value.to_string()))
        })
        .collect()
}

fn header_value(headers: &[Header], name: &'static str) -> Option<String> {
    headers
        .iter()
        .find(|header| header.field.equiv(name))
        .map(|header| header.value.as_str().to_string())
}

pub(crate) fn build_stage_inbound_headers(
    user_agent: &str,
    host: &str,
    device: &DeviceConfig,
    session: Option<&SessionConfig>,
    extra_headers: Option<HashMap<String, String>>,
) -> HashMap<String, String> {
    let now = next_request_ms().to_string();
    let mut headers = HashMap::from([
        ("User-Agent".to_string(), user_agent.to_string()),
        ("Accept".to_string(), "application/json".to_string()),
        ("Accept-Language".to_string(), "zh-CN,zh;q=0.9".to_string()),
        ("Accept-Encoding".to_string(), "gzip, deflate".to_string()),
        ("Connection".to_string(), "keep-alive".to_string()),
        ("Host".to_string(), host.to_string()),
        ("x-client-ver".to_string(), "14.010".to_string()),
        ("x-client-type".to_string(), "android".to_string()),
        ("x-os".to_string(), "Android".to_string()),
        ("zp-os-ver".to_string(), "34".to_string()),
        ("x-model".to_string(), model_name(device)),
        ("x-brand".to_string(), device.brand.clone()),
        ("x-channel".to_string(), "15".to_string()),
        ("x-device-id".to_string(), device.did.clone()),
        ("x-uniqid".to_string(), device.uniqid.clone()),
        ("x-tinker-id".to_string(), device.tinker_id.clone()),
        (
            "x-request-id".to_string(),
            format!("{}_{}", device.uniqid, now),
        ),
        ("b-cat-b".to_string(), "1".to_string()),
    ]);

    if let Some(session) = session {
        let mut cookies = Vec::new();
        if !session.token.is_empty() {
            cookies.push(format!("t={}", session.token));
        }
        if !session.token2.is_empty() {
            cookies.push(format!("wt2={}", session.token2));
            headers.insert("t2".to_string(), session.token2.clone());
        }
        if !session.wt.is_empty() {
            cookies.push(format!("wt={}", session.wt));
        }
        if !session.zp_at.is_empty() {
            cookies.push(format!("zp_at={}", session.zp_at));
            headers.insert("zp-at".to_string(), session.zp_at.clone());
        }
        if !cookies.is_empty() {
            headers.insert("Cookie".to_string(), cookies.join("; "));
        }
    }

    if let Some(extra_headers) = extra_headers {
        for (key, value) in extra_headers {
            if !key.trim().is_empty() && !value.trim().is_empty() {
                headers.insert(key, value);
            }
        }
    }

    headers
}

fn model_name(device: &DeviceConfig) -> String {
    device
        .model
        .split("||")
        .last()
        .unwrap_or(device.model.as_str())
        .to_string()
}

fn reqwest_method(method: Method) -> reqwest::Method {
    match method {
        Method::Get => reqwest::Method::GET,
        Method::Post => reqwest::Method::POST,
        Method::Put => reqwest::Method::PUT,
        Method::Delete => reqwest::Method::DELETE,
        _ => reqwest::Method::GET,
    }
}

fn headers_to_reqwest(headers: HashMap<String, String>) -> reqwest::header::HeaderMap {
    let mut out = reqwest::header::HeaderMap::new();
    for (key, value) in headers {
        if let (Ok(name), Ok(value)) = (
            reqwest::header::HeaderName::from_bytes(key.as_bytes()),
            reqwest::header::HeaderValue::from_str(&value),
        ) {
            out.insert(name, value);
        }
    }
    out
}

pub(crate) fn load_session(session_path: Option<&str>) -> Result<SessionConfig> {
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
                return Ok(session);
            }
        }
    }
    bail!("没有找到可用 session.json，或当前 session 缺少 token2。");
}

fn default_session_candidates() -> Vec<PathBuf> {
    let mut out = vec![std::env::current_dir()
        .unwrap_or_else(|_| PathBuf::from("."))
        .join(".boss_purecalc/session.json")];
    if let Some(home) = std::env::var_os("HOME") {
        out.push(PathBuf::from(home).join(".boss_purecalc/session.json"));
    }
    out
}

fn now_ms() -> u64 {
    std::time::SystemTime::now()
        .duration_since(std::time::UNIX_EPOCH)
        .unwrap_or_default()
        .as_millis() as u64
}

fn next_request_ms() -> u64 {
    let raw = now_ms();
    let prev = LAST_REQUEST_MS.load(Ordering::Relaxed);
    let next = if raw <= prev { prev + 1 } else { raw };
    LAST_REQUEST_MS.store(next, Ordering::Relaxed);
    next
}

fn sha12(text: &str) -> String {
    let mut hasher = Sha256::new();
    hasher.update(text.as_bytes());
    hex::encode(hasher.finalize())[..12].to_string()
}

fn session_preview(session: &SessionConfig) -> String {
    if session.token2.trim().is_empty() {
        "missing-token2".to_string()
    } else {
        let uid = if session.uid.trim().is_empty() {
            "anon"
        } else {
            session.uid.trim()
        };
        format!("{uid}:{}", sha12(&session.token2))
    }
}

fn read_json_body(request: &mut Request) -> Result<Value> {
    let mut body = String::new();
    request
        .as_reader()
        .read_to_string(&mut body)
        .context("failed to read request body")?;
    if body.trim().is_empty() {
        Ok(json!({}))
    } else {
        Ok(serde_json::from_str(&body).context("failed to parse request json")?)
    }
}

fn json_response(status: StatusCode, body: Value) -> Response<std::io::Cursor<Vec<u8>>> {
    let data = serde_json::to_vec(&body)
        .unwrap_or_else(|_| b"{\"error\":\"serialization failed\"}".to_vec());
    let mut response = Response::from_data(data).with_status_code(status);
    response
        .add_header(Header::from_bytes("Content-Type", "application/json; charset=utf-8").unwrap());
    response.add_header(Header::from_bytes("Access-Control-Allow-Origin", "*").unwrap());
    response
}

fn html_response(html: String) -> Response<std::io::Cursor<Vec<u8>>> {
    let data = html.into_bytes();
    let mut response = Response::from_data(data).with_status_code(StatusCode(200));
    response.add_header(Header::from_bytes("Content-Type", "text/html; charset=utf-8").unwrap());
    response
}

fn error_to_response(err: anyhow::Error) -> Response<std::io::Cursor<Vec<u8>>> {
    if let Some(flow_error) = err.downcast_ref::<FlowError>() {
        json_response(
            StatusCode(flow_error.code),
            json!({ "code": flow_error.code, "message": flow_error.message }),
        )
    } else {
        json_response(
            StatusCode(500),
            json!({ "code": 500, "message": format!("{err:#}") }),
        )
    }
}

fn base_url_from_addr(addr: ListenAddr) -> Result<String> {
    match addr {
        ListenAddr::IP(addr) => Ok(format!("http://{}", addr)),
        #[cfg(unix)]
        ListenAddr::Unix(_) => bail!("unix socket is not supported for qr mock server"),
    }
}

fn listen_port(addr: ListenAddr) -> Result<u16> {
    match addr {
        ListenAddr::IP(addr) => Ok(addr.port()),
        #[cfg(unix)]
        ListenAddr::Unix(_) => bail!("unix socket is not supported for qr mock server"),
    }
}

fn truncate(value: &str, max_len: usize) -> String {
    if value.len() <= max_len {
        value.to_string()
    } else {
        value[..max_len].to_string()
    }
}

fn urlencoding_like(value: &str) -> String {
    value
        .bytes()
        .flat_map(|byte| match byte {
            b'-' | b'_' | b'.' | b'~' | b'0'..=b'9' | b'a'..=b'z' | b'A'..=b'Z' => {
                vec![byte as char]
            }
            _ => format!("%{:02X}", byte).chars().collect(),
        })
        .collect()
}

#[cfg(test)]
mod tests {
    use super::*;

    fn build_session(uid: &str, token2: &str) -> SessionConfig {
        SessionConfig {
            uid: uid.to_string(),
            token: "tok-user".to_string(),
            token2: token2.to_string(),
            wt: "wt-user".to_string(),
            zp_at: "zp-at-user".to_string(),
            secret_key: "deadbeefdeadbeefdeadbeefdeadbeef".to_string(),
            phone: "13800138000".to_string(),
            ..SessionConfig::default()
        }
    }

    #[test]
    fn extract_qr_id_supports_both_login_payload_shapes() {
        assert_eq!(
            extract_qr_id("https://mock.local/scan?qrcode=mockqr-abcd-first").unwrap(),
            "mockqr-abcd-first"
        );
        assert_eq!(
            extract_qr_id("bosszp-abcd-second").unwrap(),
            "bosszp-abcd-second"
        );
    }

    #[test]
    fn extract_qr_id_rejects_unsupported_payload() {
        assert!(extract_qr_id("not-a-login-qr").is_err());
    }

    #[test]
    fn store_rejects_second_scan_from_different_session() {
        let mut store = LocalQrFlowStore::default();
        let flow = store.create_flow(DEFAULT_EDIT_TYPE, DEFAULT_ACTION_ID, DEFAULT_EXTRA_INFO);
        store
            .web_scan_edit(
                &flow.first_qr_id,
                &flow.edit_type,
                &flow.action_id,
                &flow.extra_info,
                "user-a:111111111111",
            )
            .unwrap();
        assert!(store
            .web_second_scan(&flow.second_qr_id, "user-b:222222222222")
            .is_err());
    }

    #[test]
    fn local_dualtrack_login_type_1_marks_logged_in() {
        let mut server = LocalQrMockServer::new(DEFAULT_HOST, 0);
        server.start().unwrap();
        let flow = server
            .create_flow(DEFAULT_EDIT_TYPE, DEFAULT_ACTION_ID, DEFAULT_EXTRA_INFO)
            .unwrap();
        let consumer = LocalQrSessionConsumer::new(
            &server.base_url().unwrap(),
            build_session("user-1", "tok2-user-1"),
        )
        .unwrap();

        let result = consumer.consume_producer(&flow.producer_id, 1).unwrap();
        let final_flow = consumer.fetch_flow(&flow.producer_id).unwrap();

        assert_eq!(result["login"]["zpData"]["state"], "logged_in");
        assert_eq!(result["login"]["zpData"]["login_granted"], true);
        assert_eq!(final_flow["state"], "logged_in");
        assert_eq!(final_flow["login_granted"], true);
        assert_eq!(
            final_flow["bound_session_preview"],
            result["session_preview"]
        );
        assert_eq!(
            final_flow["events"]
                .as_array()
                .unwrap()
                .iter()
                .filter_map(|event| event.get("track").and_then(Value::as_str))
                .collect::<Vec<_>>(),
            vec!["producer", "consumer", "consumer", "consumer"]
        );
    }

    #[test]
    fn local_dualtrack_login_type_2_stays_secondary_action() {
        let mut server = LocalQrMockServer::new(DEFAULT_HOST, 0);
        server.start().unwrap();
        let flow = server
            .create_flow("7", "manual_review", "secondary")
            .unwrap();
        let consumer = LocalQrSessionConsumer::new(
            &server.base_url().unwrap(),
            build_session("user-2", "tok2-user-2"),
        )
        .unwrap();

        let result = consumer.consume_producer(&flow.producer_id, 2).unwrap();
        let final_flow = consumer.fetch_flow(&flow.producer_id).unwrap();

        assert_eq!(result["login"]["zpData"]["state"], "secondary_action");
        assert_eq!(result["login"]["zpData"]["login_granted"], false);
        assert_eq!(final_flow["state"], "secondary_action");
        assert_eq!(final_flow["login_granted"], false);
        assert_eq!(final_flow["login_type"], 2);
        assert_eq!(final_flow["action_id"], "manual_review");
    }

    #[test]
    fn load_session_accepts_sparse_python_style_payload() {
        let session_path =
            std::env::temp_dir().join(format!("rnidbg-qr-session-{}.json", rand::random::<u64>()));
        fs::write(
            &session_path,
            r#"{
  "uid": "user-cli",
  "t": "tok-user-cli",
  "t2": "tok2-user-cli",
  "wt": "wt-user-cli",
  "zpAt": "zp-at-user-cli",
  "secret_key": "deadbeefdeadbeefdeadbeefdeadbeef",
  "phone": "13800138000"
}"#,
        )
        .unwrap();

        let session = load_session(Some(session_path.to_str().unwrap())).unwrap();
        let _ = fs::remove_file(&session_path);

        assert_eq!(session.uid, "user-cli");
        assert_eq!(session.identity, "");
        assert_eq!(session.token, "tok-user-cli");
        assert_eq!(session.token2, "tok2-user-cli");
        assert_eq!(session.region_code, "86");
        assert!(session.is_valid());
    }
}
