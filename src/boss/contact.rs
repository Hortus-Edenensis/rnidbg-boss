use std::collections::{BTreeMap, HashMap};
use std::path::PathBuf;

use anyhow::{anyhow, Context, Result};
use reqwest::Url;
use serde_json::{json, Map, Value};

use super::job_detail::{
    build_common_params, build_traceid, canonicalize_params, execute_get, normalize_host, now_ms,
    parse_bool_flag, redact_headers, resolve_output_path, resolved_session_path, response_code,
    truncate_for_sig, BossSigner, HttpTransport, RnIdbgSoInvoker, TransportRuntime,
};
use super::qr_login::{build_stage_inbound_headers, load_session, DeviceConfig, SessionConfig};
use super::yzwg::LabConfig;

const USER_AGENT: &str = concat!(
    "Mozilla/5.0 (Linux; Android 14; RMX3560 Build/UP1A.231005.007; wv) ",
    "AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/118.0.0.0 ",
    "Mobile Safari/537.36 BossZhipin/14.010"
);
const APP_ID: &str = "1003";
const DEFAULT_API_HOST: &str = "https://api5.zhipin.com";
const DEFAULT_CONTACT_DIRECT_HOST: &str = "https://api-and.zhipin.com";
const FRIEND_ID_LIST_PATH: &str = "/api/zprelation/friend/getFriendIdListV1";
const FRIEND_BASE_INFO_PATH: &str = "/api/zprelation/friend/getBaseInfo";
const CHAT_GEEK_ENTER_PATH: &str = "/api/zpchat/session/geekEnter";
const CHAT_WINDOW_CONFIG_PATH: &str = "/api/zpchat/session/getWindowConfig";
const CHAT_PROACTIVE_SEND_PATH: &str = "/api/zpchat/message/send";
const DEFAULT_WINDOW_IDS: &str = "10005,10006,10007,10009";
const MESSAGE_PULL_PATH: &str = "/api/zpchat/message/historyMsg";
const EXCHANGE_LIST_PATH: &str = "/api/zprelation/exchange/getExchangeList";
const INTERACTION_INFO_PATH: &str = "/api/zprelation/interaction/geekGetInfo";

pub fn run_friends(opts: &HashMap<String, String>) -> Result<Value> {
    let ctx = BossContactContext::from_opts(opts)?;
    let limit = opts
        .get("--limit")
        .and_then(|value| value.parse::<usize>().ok())
        .filter(|value| *value > 0)
        .unwrap_or(50)
        .min(50);

    let id_list = ctx.signed_get_contact_direct(FRIEND_ID_LIST_PATH, BTreeMap::new())?;
    let friend_ids = extract_friend_ids(id_list.response_payload());
    let selected_ids = friend_ids.iter().take(limit).cloned().collect::<Vec<_>>();
    let base_info = if selected_ids.is_empty() {
        None
    } else {
        Some(ctx.signed_get_contact_direct(
            FRIEND_BASE_INFO_PATH,
            BTreeMap::from([("friendIds".to_string(), selected_ids.join(","))]),
        )?)
    };
    let friends = base_info
        .as_ref()
        .map(|result| extract_friend_list(result.response_payload()))
        .unwrap_or_default();
    let ok = !friends.is_empty()
        && base_info
            .as_ref()
            .and_then(|result| response_code(Some(result.response_payload())))
            == Some(0);

    let output = json!({
        "ok": ok,
        "route": "contact_direct_v1",
        "session_path": ctx.resolved_session_path,
        "transport_runtime": ctx.transport.label(),
        "original_okhttp_available": ctx.transport.original_okhttp_available(),
        "transport": ctx.transport.describe(),
        "native_invoker": ctx.signer.describe(),
        "friend_id_list": id_list.to_value(),
        "friend_base_info": base_info.as_ref().map(SignedGetResult::to_value).unwrap_or(Value::Null),
        "summary": summarize_friends(&friend_ids, &selected_ids, &friends),
    });

    ctx.write_output(
        opts.get("--out").map(String::as_str),
        "friends_result.json",
        &output,
    )?;
    Ok(output)
}

pub fn run_messages(opts: &HashMap<String, String>) -> Result<Value> {
    let ctx = BossContactContext::from_opts(opts)?;
    let friend_id = opts
        .get("--uid")
        .cloned()
        .or_else(|| opts.get("--friend-id").cloned())
        .or_else(|| opts.get("_0").cloned())
        .unwrap_or_default()
        .trim()
        .to_string();
    if friend_id.is_empty() {
        return Err(anyhow!(
            "messages requires --uid <friendId> or positional <friendId>"
        ));
    }

    let friend_lookup = ctx.signed_get_contact_direct(
        FRIEND_BASE_INFO_PATH,
        BTreeMap::from([("friendIds".to_string(), friend_id.clone())]),
    )?;
    let friend_ctx = extract_friend_context(friend_lookup.response_payload(), &friend_id);
    let count = opts
        .get("--count")
        .cloned()
        .unwrap_or_else(|| "20".to_string());
    let friend_source = opts
        .get("--friend-source")
        .cloned()
        .or_else(|| friend_ctx.as_ref().map(|ctx| ctx.friend_source.clone()))
        .unwrap_or_else(|| "0".to_string());
    let max_msg_id = opts
        .get("--max-msg-id")
        .cloned()
        .unwrap_or_else(|| "0".to_string());
    let mut params = BTreeMap::from([
        ("friendId".to_string(), friend_id.clone()),
        ("count".to_string(), count.clone()),
        ("friendSource".to_string(), friend_source.clone()),
        ("maxMsgId".to_string(), max_msg_id.clone()),
    ]);
    if let Some(last_msg_id) = opts
        .get("--last-msg-id")
        .or_else(|| opts.get("--lastMsgId"))
    {
        if !last_msg_id.trim().is_empty() {
            params.insert("maxMsgId".to_string(), last_msg_id.trim().to_string());
        }
    }

    let bootstrap = if parse_bool_flag(opts, "--skip-bootstrap") {
        None
    } else {
        friend_ctx
            .as_ref()
            .map(|friend_ctx| ctx.bootstrap_chat(friend_ctx, opts))
            .transpose()?
    };
    let attempts = if opts.contains_key("--host") {
        vec![ctx.signed_get_api(MESSAGE_PULL_PATH, params.clone())?]
    } else {
        ctx.probe_message_like(MESSAGE_PULL_PATH, params.clone())?
    };
    let result = select_best_attempt(&attempts)
        .cloned()
        .or_else(|| attempts.last().cloned())
        .ok_or_else(|| anyhow!("message history probe did not execute"))?;
    let messages = extract_message_list(result.response_payload());
    let output = json!({
        "ok": response_code(Some(result.response_payload())) == Some(0),
        "route": "message_history_pull",
        "session_path": ctx.resolved_session_path,
        "transport_runtime": ctx.transport.label(),
        "original_okhttp_available": ctx.transport.original_okhttp_available(),
        "transport": ctx.transport.describe(),
        "native_invoker": ctx.signer.describe(),
        "friend_lookup": friend_lookup.to_value(),
        "friend_context": friend_ctx.as_ref().map(FriendContext::to_value).unwrap_or(Value::Null),
        "bootstrap": bootstrap.as_ref().map(ChatBootstrapResult::to_value).unwrap_or(Value::Null),
        "message_history": result.to_value(),
        "attempts": attempts.iter().map(SignedGetResult::to_value).collect::<Vec<_>>(),
        "summary": summarize_messages(&friend_id, &friend_source, &max_msg_id, &messages),
    });

    ctx.write_output(
        opts.get("--out").map(String::as_str),
        "messages_result.json",
        &output,
    )?;
    Ok(output)
}

pub fn run_chat_bootstrap(opts: &HashMap<String, String>) -> Result<Value> {
    let ctx = BossContactContext::from_opts(opts)?;
    let friend_id = opts
        .get("--uid")
        .cloned()
        .or_else(|| opts.get("--friend-id").cloned())
        .or_else(|| opts.get("_0").cloned())
        .unwrap_or_default()
        .trim()
        .to_string();
    if friend_id.is_empty() {
        return Err(anyhow!(
            "chat-bootstrap requires --uid <friendId> or positional <friendId>"
        ));
    }

    let friend_lookup = ctx.signed_get_contact_direct(
        FRIEND_BASE_INFO_PATH,
        BTreeMap::from([("friendIds".to_string(), friend_id.clone())]),
    )?;
    let friend_ctx = extract_friend_context(friend_lookup.response_payload(), &friend_id)
        .ok_or_else(|| anyhow!("failed to resolve friend context for {friend_id}"))?;
    let bootstrap = ctx.bootstrap_chat(&friend_ctx, opts)?;
    let output = json!({
        "ok": bootstrap.ok(),
        "route": "chat_bootstrap",
        "session_path": ctx.resolved_session_path,
        "transport_runtime": ctx.transport.label(),
        "original_okhttp_available": ctx.transport.original_okhttp_available(),
        "transport": ctx.transport.describe(),
        "native_invoker": ctx.signer.describe(),
        "friend_lookup": friend_lookup.to_value(),
        "friend_context": friend_ctx.to_value(),
        "bootstrap": bootstrap.to_value(),
    });

    ctx.write_output(
        opts.get("--out").map(String::as_str),
        "chat_bootstrap_result.json",
        &output,
    )?;
    Ok(output)
}

pub fn run_proactive_send(opts: &HashMap<String, String>) -> Result<Value> {
    let ctx = BossContactContext::from_opts(opts)?;
    let friend_id = opts
        .get("--uid")
        .cloned()
        .or_else(|| opts.get("--friend-id").cloned())
        .or_else(|| opts.get("_0").cloned())
        .unwrap_or_default()
        .trim()
        .to_string();
    let security_id_override = opts
        .get("--security-id")
        .cloned()
        .unwrap_or_default()
        .trim()
        .to_string();
    let scene = opts
        .get("--scene")
        .cloned()
        .filter(|value| !value.trim().is_empty())
        .unwrap_or_else(|| "1".to_string());

    if friend_id.is_empty() && security_id_override.is_empty() {
        return Err(anyhow!(
            "proactive-send requires --security-id <id> or --uid <friendId>"
        ));
    }

    let friend_lookup = if security_id_override.is_empty() && !friend_id.is_empty() {
        Some(ctx.signed_get_contact_direct(
            FRIEND_BASE_INFO_PATH,
            BTreeMap::from([("friendIds".to_string(), friend_id.clone())]),
        )?)
    } else {
        None
    };
    let friend_ctx = friend_lookup
        .as_ref()
        .and_then(|result| extract_friend_context(result.response_payload(), &friend_id));
    let security_id = if !security_id_override.is_empty() {
        security_id_override
    } else {
        friend_ctx
            .as_ref()
            .map(|ctx| ctx.security_id.clone())
            .filter(|value| !value.trim().is_empty())
            .ok_or_else(|| anyhow!("failed to resolve securityId for friend {friend_id}"))?
    };
    let form = BTreeMap::from([
        ("securityId".to_string(), security_id.clone()),
        ("scene".to_string(), scene.clone()),
    ]);
    let attempts = if opts.contains_key("--host") {
        vec![ctx.signed_post_api(CHAT_PROACTIVE_SEND_PATH, form.clone())?]
    } else {
        ctx.probe_chat_form_like(CHAT_PROACTIVE_SEND_PATH, form.clone())?
    };
    let result = select_best_post_attempt(&attempts)
        .cloned()
        .or_else(|| attempts.last().cloned())
        .ok_or_else(|| anyhow!("proactive send probe did not execute"))?;
    let output = json!({
        "ok": response_code(Some(result.response_payload())) == Some(0),
        "route": "chat_proactive_send",
        "session_path": ctx.resolved_session_path,
        "transport_runtime": ctx.transport.label(),
        "original_okhttp_available": ctx.transport.original_okhttp_available(),
        "transport": ctx.transport.describe(),
        "native_invoker": ctx.signer.describe(),
        "friend_lookup": friend_lookup.as_ref().map(SignedGetResult::to_value).unwrap_or(Value::Null),
        "friend_context": friend_ctx.as_ref().map(FriendContext::to_value).unwrap_or(Value::Null),
        "proactive_send": result.to_value(),
        "attempts": attempts.iter().map(SignedPostResult::to_value).collect::<Vec<_>>(),
        "summary": {
            "friend_id": friend_id,
            "security_id": security_id,
            "scene": scene,
        },
        "evidence": {
            "apk_constant": "com.hpbr.bosszhipin.a.N5 = zpchat/message/send",
            "apk_usage": "ChatCommon.z0() -> POST N5 with securityId + scene",
            "send_stream_note": "plain text send still routes through ChatCommon -> message.handler.c -> jf0.i(MMS/protobuf), not this HTTP endpoint",
        }
    });

    ctx.write_output(
        opts.get("--out").map(String::as_str),
        "chat_proactive_send_result.json",
        &output,
    )?;
    Ok(output)
}

pub fn run_exchange(opts: &HashMap<String, String>) -> Result<Value> {
    let ctx = BossContactContext::from_opts(opts)?;
    let page = opts
        .get("--page")
        .cloned()
        .unwrap_or_else(|| "1".to_string());
    let result = ctx.signed_get_contact_direct(
        EXCHANGE_LIST_PATH,
        BTreeMap::from([
            ("page".to_string(), page.clone()),
            ("type".to_string(), "1".to_string()),
        ]),
    )?;
    let items = extract_exchange_items(result.response_payload());
    let output = json!({
        "ok": response_code(Some(result.response_payload())) == Some(0),
        "route": "contact_exchange",
        "session_path": ctx.resolved_session_path,
        "transport_runtime": ctx.transport.label(),
        "original_okhttp_available": ctx.transport.original_okhttp_available(),
        "transport": ctx.transport.describe(),
        "native_invoker": ctx.signer.describe(),
        "exchange": result.to_value(),
        "summary": summarize_exchange(&page, &items),
    });

    ctx.write_output(
        opts.get("--out").map(String::as_str),
        "exchange_result.json",
        &output,
    )?;
    Ok(output)
}

pub fn run_interaction(opts: &HashMap<String, String>) -> Result<Value> {
    let ctx = BossContactContext::from_opts(opts)?;
    let attempts = if opts.contains_key("--host") {
        vec![ctx.signed_get_api(INTERACTION_INFO_PATH, BTreeMap::new())?]
    } else {
        ctx.probe_message_like(INTERACTION_INFO_PATH, BTreeMap::new())?
    };
    let result = select_best_attempt(&attempts)
        .cloned()
        .or_else(|| attempts.last().cloned())
        .ok_or_else(|| anyhow!("interaction probe did not execute"))?;
    let output = json!({
        "ok": response_code(Some(result.response_payload())) == Some(0),
        "route": "interaction_info",
        "session_path": ctx.resolved_session_path,
        "transport_runtime": ctx.transport.label(),
        "original_okhttp_available": ctx.transport.original_okhttp_available(),
        "transport": ctx.transport.describe(),
        "native_invoker": ctx.signer.describe(),
        "interaction": result.to_value(),
        "attempts": attempts.iter().map(SignedGetResult::to_value).collect::<Vec<_>>(),
        "summary": summarize_interaction(result.response_payload()),
    });

    ctx.write_output(
        opts.get("--out").map(String::as_str),
        "interaction_result.json",
        &output,
    )?;
    Ok(output)
}

struct BossContactContext {
    resolved_session_path: String,
    session: SessionConfig,
    device: DeviceConfig,
    signer: Box<dyn BossSigner>,
    transport: HttpTransport,
    direct_host: String,
    api_host: String,
}

impl BossContactContext {
    fn from_opts(opts: &HashMap<String, String>) -> Result<Self> {
        let session_path = opts.get("--session-path").map(String::as_str);
        let resolved_session_path = resolved_session_path(session_path);
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
        let transport_runtime =
            TransportRuntime::parse(opts.get("--transport-runtime").map(String::as_str))?;
        let http1_only = parse_bool_flag(opts, "--http1-only");
        let transport = HttpTransport::discover(transport_runtime, &lab_config, opts, http1_only)?;
        let direct_host = normalize_host(
            opts.get("--contact-host")
                .map(String::as_str)
                .or_else(|| opts.get("--host").map(String::as_str))
                .unwrap_or(DEFAULT_CONTACT_DIRECT_HOST),
        );
        let api_host = normalize_host(
            opts.get("--api-host")
                .map(String::as_str)
                .or_else(|| opts.get("--host").map(String::as_str))
                .unwrap_or(DEFAULT_API_HOST),
        );
        Ok(Self {
            resolved_session_path,
            session,
            device,
            signer,
            transport,
            direct_host,
            api_host,
        })
    }

    fn signed_get_contact_direct(
        &self,
        path: &str,
        params: BTreeMap<String, String>,
    ) -> Result<SignedGetResult> {
        self.signed_get(
            &self.direct_host,
            path,
            params,
            BTreeMap::from([("app_id".to_string(), APP_ID.to_string())]),
            "contact_direct",
        )
    }

    fn signed_get_api(
        &self,
        path: &str,
        params: BTreeMap<String, String>,
    ) -> Result<SignedGetResult> {
        self.signed_get(&self.api_host, path, params, BTreeMap::new(), "legacy_api")
    }

    fn signed_post_api(
        &self,
        path: &str,
        form_params: BTreeMap<String, String>,
    ) -> Result<SignedPostResult> {
        self.signed_post(
            &self.api_host,
            path,
            form_params,
            BTreeMap::new(),
            "legacy_api_form_post",
        )
    }

    fn signed_post_contact_direct(
        &self,
        path: &str,
        form_params: BTreeMap<String, String>,
    ) -> Result<SignedPostResult> {
        self.signed_post(
            &self.direct_host,
            path,
            form_params,
            BTreeMap::from([("app_id".to_string(), APP_ID.to_string())]),
            "contact_direct_form_post",
        )
    }

    fn probe_message_like(
        &self,
        path: &str,
        params: BTreeMap<String, String>,
    ) -> Result<Vec<SignedGetResult>> {
        let mut attempts = Vec::new();
        attempts.push(self.signed_get(
            &self.api_host,
            path,
            params.clone(),
            BTreeMap::new(),
            "legacy_api",
        )?);
        attempts.push(self.signed_get(
            &self.direct_host,
            path,
            params.clone(),
            BTreeMap::new(),
            "direct_host_legacy",
        )?);
        attempts.push(self.signed_get(
            &self.direct_host,
            path,
            params,
            BTreeMap::from([("app_id".to_string(), APP_ID.to_string())]),
            "direct_host_unsigned_app_id",
        )?);
        Ok(attempts)
    }

    fn probe_chat_form_like(
        &self,
        path: &str,
        form_params: BTreeMap<String, String>,
    ) -> Result<Vec<SignedPostResult>> {
        let mut attempts = Vec::new();
        attempts.push(self.signed_post_api(path, form_params.clone())?);
        attempts.push(self.signed_post(
            &self.direct_host,
            path,
            form_params.clone(),
            BTreeMap::new(),
            "direct_host_legacy_form_post",
        )?);
        attempts.push(self.signed_post_contact_direct(path, form_params)?);
        Ok(attempts)
    }

    fn probe_chat_get_like(
        &self,
        path: &str,
        params: BTreeMap<String, String>,
    ) -> Result<Vec<SignedGetResult>> {
        let mut attempts = Vec::new();
        attempts.push(self.signed_get_api(path, params.clone())?);
        attempts.push(self.signed_get(
            &self.direct_host,
            path,
            params.clone(),
            BTreeMap::new(),
            "direct_host_legacy",
        )?);
        attempts.push(self.signed_get(
            &self.direct_host,
            path,
            params,
            BTreeMap::from([("app_id".to_string(), APP_ID.to_string())]),
            "direct_host_unsigned_app_id",
        )?);
        Ok(attempts)
    }

    fn signed_get(
        &self,
        host: &str,
        path: &str,
        mut params: BTreeMap<String, String>,
        unsigned_params: BTreeMap<String, String>,
        route: &str,
    ) -> Result<SignedGetResult> {
        let traceid = build_traceid();
        let req_time_ms = now_ms();
        let common_params = build_common_params(&self.device, req_time_ms);
        let mut signing_params = common_params.clone();
        signing_params.append(&mut params);
        let canonical = canonicalize_params(&signing_params);
        let secret_key = self.session.secret_key.as_str();
        let sp = self
            .signer
            .encode_request(canonical.as_bytes(), secret_key)
            .with_context(|| format!("failed to build sp for {path}"))?;
        let sig_input = format!("{}{}", path, truncate_for_sig(&canonical, 5000));
        let sig = self
            .signer
            .signature(sig_input.as_bytes(), secret_key)
            .with_context(|| format!("failed to build sig for {path}"))?;
        let zp_tag = self
            .signer
            .encode_request(traceid.as_bytes(), "")
            .with_context(|| format!("failed to build zp-tag for {path}"))?;

        let mut final_query = signing_params.clone();
        final_query.insert("sp".to_string(), sp);
        final_query.insert("sig".to_string(), sig);
        let url = build_query_url(host, path, &final_query, &unsigned_params)?;
        let headers = request_headers(
            host,
            &self.device,
            &self.session,
            &traceid,
            &zp_tag,
            "application/json",
        )?;
        let response = execute_get(
            &self.transport,
            &url,
            &headers,
            Some(&*self.signer),
            self.session.secret_key.as_str(),
        )?;

        Ok(SignedGetResult {
            route: route.to_string(),
            host: host.to_string(),
            path: path.to_string(),
            traceid,
            url,
            headers,
            signed_query_keys: final_query.keys().cloned().collect(),
            clear_exempt_query_keys: unsigned_params.keys().cloned().collect(),
            response,
        })
    }

    fn signed_post(
        &self,
        host: &str,
        path: &str,
        mut form_params: BTreeMap<String, String>,
        unsigned_form_params: BTreeMap<String, String>,
        route: &str,
    ) -> Result<SignedPostResult> {
        let traceid = build_traceid();
        let req_time_ms = now_ms();
        let common_params = build_common_params(&self.device, req_time_ms);
        let mut signing_params = common_params.clone();
        signing_params.append(&mut form_params);
        let canonical = canonicalize_params(&signing_params);
        let secret_key = self.session.secret_key.as_str();
        let sp = self
            .signer
            .encode_request(canonical.as_bytes(), secret_key)
            .with_context(|| format!("failed to build sp for {path}"))?;
        let sig_input = format!("{}{}", path, truncate_for_sig(&canonical, 5000));
        let sig = self
            .signer
            .signature(sig_input.as_bytes(), secret_key)
            .with_context(|| format!("failed to build sig for {path}"))?;
        let zp_tag = self
            .signer
            .encode_request(traceid.as_bytes(), "")
            .with_context(|| format!("failed to build zp-tag for {path}"))?;

        let mut final_form = signing_params.clone();
        final_form.insert("sp".to_string(), sp);
        final_form.insert("sig".to_string(), sig);
        for (key, value) in &unsigned_form_params {
            final_form.insert(key.clone(), value.clone());
        }
        let url = format!(
            "{}/{}",
            host.trim_end_matches('/'),
            path.trim_start_matches('/')
        );
        let headers = request_headers(
            host,
            &self.device,
            &self.session,
            &traceid,
            &zp_tag,
            "application/x-www-form-urlencoded",
        )?;
        let body_form = encode_form_body(&final_form);
        let response = super::job_detail::execute_post(
            &self.transport,
            &url,
            &headers,
            body_form.as_bytes(),
            Some(&*self.signer),
            self.session.secret_key.as_str(),
        )?;

        Ok(SignedPostResult {
            route: route.to_string(),
            host: host.to_string(),
            path: path.to_string(),
            traceid,
            url,
            headers,
            body_form,
            signed_form_keys: signing_params.keys().cloned().collect(),
            clear_exempt_form_keys: unsigned_form_params.keys().cloned().collect(),
            response,
        })
    }

    fn bootstrap_chat(
        &self,
        friend_ctx: &FriendContext,
        opts: &HashMap<String, String>,
    ) -> Result<ChatBootstrapResult> {
        let source_security_id = opts
            .get("--source-security-id")
            .cloned()
            .unwrap_or_default();
        let k810 = opts
            .get("--k810")
            .cloned()
            .unwrap_or_else(|| infer_geek_enter_k810(friend_ctx));
        let geek_enter_form = BTreeMap::from([
            ("jobSource".to_string(), friend_ctx.job_source.clone()),
            ("k810".to_string(), k810.clone()),
            ("securityId".to_string(), friend_ctx.security_id.clone()),
            ("sourceSecurityId".to_string(), source_security_id.clone()),
        ]);
        let geek_enter_attempts = if opts.contains_key("--host") {
            vec![self.signed_post_api(CHAT_GEEK_ENTER_PATH, geek_enter_form.clone())?]
        } else {
            self.probe_chat_form_like(CHAT_GEEK_ENTER_PATH, geek_enter_form.clone())?
        };
        let window_ids = opts
            .get("--window-ids")
            .cloned()
            .unwrap_or_else(|| DEFAULT_WINDOW_IDS.to_string());
        let window_config_attempts = if opts.contains_key("--host") {
            vec![self.signed_get_api(
                CHAT_WINDOW_CONFIG_PATH,
                BTreeMap::from([("windowIds".to_string(), window_ids.clone())]),
            )?]
        } else {
            self.probe_chat_get_like(
                CHAT_WINDOW_CONFIG_PATH,
                BTreeMap::from([("windowIds".to_string(), window_ids.clone())]),
            )?
        };

        Ok(ChatBootstrapResult {
            source_security_id,
            k810,
            window_ids,
            geek_enter_form,
            geek_enter_attempts,
            window_config_attempts,
        })
    }

    fn write_output(&self, path: Option<&str>, default_name: &str, payload: &Value) -> Result<()> {
        let output_path = resolve_output_path(path, default_name);
        if let Some(parent) = output_path.parent() {
            std::fs::create_dir_all(parent)
                .with_context(|| format!("failed to create output dir: {}", parent.display()))?;
        }
        std::fs::write(&output_path, serde_json::to_vec_pretty(payload)?)
            .with_context(|| format!("failed to write output: {}", output_path.display()))?;
        Ok(())
    }
}

struct SignedGetResult {
    route: String,
    host: String,
    path: String,
    traceid: String,
    url: String,
    headers: HashMap<String, String>,
    signed_query_keys: Vec<String>,
    clear_exempt_query_keys: Vec<String>,
    response: Value,
}

impl Clone for SignedGetResult {
    fn clone(&self) -> Self {
        Self {
            route: self.route.clone(),
            host: self.host.clone(),
            path: self.path.clone(),
            traceid: self.traceid.clone(),
            url: self.url.clone(),
            headers: self.headers.clone(),
            signed_query_keys: self.signed_query_keys.clone(),
            clear_exempt_query_keys: self.clear_exempt_query_keys.clone(),
            response: self.response.clone(),
        }
    }
}

impl SignedGetResult {
    fn response_payload(&self) -> &Value {
        &self.response
    }

    fn to_value(&self) -> Value {
        json!({
            "request_contract": {
                "type": "signed_get",
                "route": self.route,
                "host": self.host,
                "path": self.path,
                "signed_query_keys": self.signed_query_keys,
                "clear_exempt_query_keys": self.clear_exempt_query_keys,
            },
            "request": {
                "url": self.url,
                "traceid": self.traceid,
                "request_headers": redact_headers(&self.headers),
            },
            "response": self.response,
        })
    }
}

struct SignedPostResult {
    route: String,
    host: String,
    path: String,
    traceid: String,
    url: String,
    headers: HashMap<String, String>,
    body_form: String,
    signed_form_keys: Vec<String>,
    clear_exempt_form_keys: Vec<String>,
    response: Value,
}

impl Clone for SignedPostResult {
    fn clone(&self) -> Self {
        Self {
            route: self.route.clone(),
            host: self.host.clone(),
            path: self.path.clone(),
            traceid: self.traceid.clone(),
            url: self.url.clone(),
            headers: self.headers.clone(),
            body_form: self.body_form.clone(),
            signed_form_keys: self.signed_form_keys.clone(),
            clear_exempt_form_keys: self.clear_exempt_form_keys.clone(),
            response: self.response.clone(),
        }
    }
}

impl SignedPostResult {
    fn response_payload(&self) -> &Value {
        &self.response
    }

    fn to_value(&self) -> Value {
        json!({
            "request_contract": {
                "type": "signed_form_post",
                "route": self.route,
                "host": self.host,
                "path": self.path,
                "signed_form_keys": self.signed_form_keys,
                "clear_exempt_form_keys": self.clear_exempt_form_keys,
            },
            "request": {
                "url": self.url,
                "traceid": self.traceid,
                "request_headers": redact_headers(&self.headers),
                "body_form": self.body_form,
            },
            "response": self.response,
        })
    }
}

#[derive(Clone, Debug, PartialEq, Eq)]
struct FriendContext {
    friend_id: String,
    friend_source: String,
    job_source: String,
    security_id: String,
    friend_type: Option<i64>,
    fridend_stage: Option<i64>,
    datetime_ms: Option<u64>,
    water_level: Option<u64>,
}

impl FriendContext {
    fn to_value(&self) -> Value {
        json!({
            "friend_id": self.friend_id,
            "friend_source": self.friend_source,
            "job_source": self.job_source,
            "security_id": self.security_id,
            "friend_type": self.friend_type,
            "fridend_stage": self.fridend_stage,
            "datetime_ms": self.datetime_ms,
            "water_level": self.water_level,
        })
    }
}

struct ChatBootstrapResult {
    source_security_id: String,
    k810: String,
    window_ids: String,
    geek_enter_form: BTreeMap<String, String>,
    geek_enter_attempts: Vec<SignedPostResult>,
    window_config_attempts: Vec<SignedGetResult>,
}

impl ChatBootstrapResult {
    fn ok(&self) -> bool {
        select_best_post_attempt(&self.geek_enter_attempts).is_some()
            && select_best_attempt(&self.window_config_attempts).is_some()
    }

    fn to_value(&self) -> Value {
        let geek_enter = select_best_post_attempt(&self.geek_enter_attempts)
            .cloned()
            .or_else(|| self.geek_enter_attempts.last().cloned());
        let window_config = select_best_attempt(&self.window_config_attempts)
            .cloned()
            .or_else(|| self.window_config_attempts.last().cloned());
        json!({
            "ok": self.ok(),
            "contract": {
                "steps": ["geekEnter", "getWindowConfig"],
                "window_ids_source": "he/b.java:f()/g()/l()",
            },
            "inputs": {
                "source_security_id": self.source_security_id,
                "k810": self.k810,
                "window_ids": self.window_ids,
                "geek_enter_form": self.geek_enter_form,
            },
            "geek_enter": geek_enter.map(|attempt| attempt.to_value()).unwrap_or(Value::Null),
            "geek_enter_attempts": self.geek_enter_attempts.iter().map(SignedPostResult::to_value).collect::<Vec<_>>(),
            "window_config": window_config
                .as_ref()
                .map(SignedGetResult::to_value)
                .unwrap_or(Value::Null),
            "window_config_attempts": self.window_config_attempts.iter().map(SignedGetResult::to_value).collect::<Vec<_>>(),
            "window_summary": window_config
                .as_ref()
                .map(|attempt| summarize_window_config(attempt.response_payload()))
                .unwrap_or_else(|| json!({})),
        })
    }
}

fn select_best_attempt(attempts: &[SignedGetResult]) -> Option<&SignedGetResult> {
    attempts
        .iter()
        .find(|attempt| response_code(Some(attempt.response_payload())) == Some(0))
}

fn select_best_post_attempt(attempts: &[SignedPostResult]) -> Option<&SignedPostResult> {
    attempts
        .iter()
        .find(|attempt| response_code(Some(attempt.response_payload())) == Some(0))
}

fn request_headers(
    host: &str,
    device: &DeviceConfig,
    session: &SessionConfig,
    traceid: &str,
    zp_tag: &str,
    content_type: &str,
) -> Result<HashMap<String, String>> {
    let mut extra_headers = HashMap::new();
    extra_headers.insert("traceid".to_string(), traceid.to_string());
    extra_headers.insert("zp-tag".to_string(), zp_tag.to_string());
    let mut headers = build_stage_inbound_headers(
        USER_AGENT,
        &host_header(host)?,
        device,
        Some(session),
        Some(extra_headers),
    );
    headers.insert("Content-Type".to_string(), content_type.to_string());
    Ok(headers)
}

fn build_query_url(
    host: &str,
    path: &str,
    params: &BTreeMap<String, String>,
    unsigned_params: &BTreeMap<String, String>,
) -> Result<String> {
    let base = format!(
        "{}/{}",
        host.trim_end_matches('/'),
        path.trim_start_matches('/')
    );
    let mut url = Url::parse(&base).with_context(|| format!("invalid host url: {host}"))?;
    {
        let mut pairs = url.query_pairs_mut();
        for (key, value) in params {
            pairs.append_pair(key, value);
        }
        for (key, value) in unsigned_params {
            pairs.append_pair(key, value);
        }
    }
    Ok(url.to_string())
}

fn host_header(host: &str) -> Result<String> {
    let parsed = Url::parse(host).with_context(|| format!("invalid host url: {host}"))?;
    Ok(match parsed.port() {
        Some(port) => format!(
            "{}:{}",
            parsed.host_str().unwrap_or("api5.zhipin.com"),
            port
        ),
        None => parsed.host_str().unwrap_or("api5.zhipin.com").to_string(),
    })
}

fn extract_friend_ids(payload: &Value) -> Vec<String> {
    let mut friend_ids = Vec::new();
    if let Some(zp_data) = payload.get("zpData") {
        if let Some(list) = zp_data.get("friendIdList") {
            friend_ids.extend(split_multi_values(list));
        }
        if let Some(rows) = zp_data.get("zpFriendIdList").and_then(Value::as_array) {
            for row in rows {
                if let Some(friend_id) = row.get("friendId") {
                    friend_ids.extend(split_multi_values(friend_id));
                } else {
                    friend_ids.extend(split_multi_values(row));
                }
            }
        }
    }
    uniq(friend_ids)
}

fn extract_friend_list(payload: &Value) -> Vec<Value> {
    let Some(zp_data) = payload.get("zpData") else {
        return Vec::new();
    };
    if let Some(array) = zp_data.as_array() {
        return array.clone();
    }
    for key in ["friendList", "baseInfoList", "data", "list", "cardList"] {
        if let Some(array) = zp_data.get(key).and_then(Value::as_array) {
            return array.clone();
        }
    }
    Vec::new()
}

fn extract_message_list(payload: &Value) -> Vec<Value> {
    let Some(zp_data) = payload.get("zpData") else {
        return Vec::new();
    };
    if let Some(array) = zp_data.get("messages").and_then(Value::as_array) {
        return array.clone();
    }
    if let Some(array) = zp_data.get("data").and_then(Value::as_array) {
        return array.clone();
    }
    Vec::new()
}

fn extract_exchange_items(payload: &Value) -> Vec<Value> {
    let Some(zp_data) = payload.get("zpData") else {
        return Vec::new();
    };
    for key in ["exchangeList", "list", "data", "cardList"] {
        if let Some(array) = zp_data.get(key).and_then(Value::as_array) {
            return array.clone();
        }
    }
    Vec::new()
}

fn summarize_friends(friend_ids: &[String], selected_ids: &[String], friends: &[Value]) -> Value {
    json!({
        "friend_id_count": friend_ids.len(),
        "requested_friend_count": selected_ids.len(),
        "friend_count": friends.len(),
        "first_friend": friends.first().cloned().unwrap_or(Value::Null),
    })
}

fn summarize_messages(
    friend_id: &str,
    friend_source: &str,
    max_msg_id: &str,
    messages: &[Value],
) -> Value {
    json!({
        "friend_id": friend_id,
        "friend_source": friend_source,
        "max_msg_id": max_msg_id,
        "message_count": messages.len(),
        "first_message": messages.first().cloned().unwrap_or(Value::Null),
        "last_message": messages.last().cloned().unwrap_or(Value::Null),
    })
}

fn summarize_exchange(page: &str, items: &[Value]) -> Value {
    json!({
        "page": page,
        "exchange_count": items.len(),
        "first_exchange": items.first().cloned().unwrap_or(Value::Null),
    })
}

fn summarize_interaction(payload: &Value) -> Value {
    let Some(zp_data) = payload.get("zpData").and_then(Value::as_object) else {
        return json!({});
    };
    let mut summary = Map::new();
    for key in [
        "count",
        "totalCount",
        "friendCount",
        "jobSeekerCount",
        "bossCount",
    ] {
        if let Some(value) = zp_data.get(key) {
            summary.insert(key.to_string(), value.clone());
        }
    }
    if summary.is_empty() {
        summary.insert(
            "keys".to_string(),
            Value::Array(
                zp_data
                    .keys()
                    .take(12)
                    .cloned()
                    .map(Value::String)
                    .collect(),
            ),
        );
    }
    Value::Object(summary)
}

fn summarize_window_config(payload: &Value) -> Value {
    let Some(zp_data) = payload.get("zpData").and_then(Value::as_object) else {
        return json!({});
    };
    let window_info = zp_data.get("windowInfo").and_then(Value::as_object);
    json!({
        "keys": zp_data.keys().take(12).cloned().collect::<Vec<_>>(),
        "window_info_keys": window_info
            .map(|value| value.keys().take(12).cloned().collect::<Vec<_>>())
            .unwrap_or_default(),
        "app_window_count": zp_data
            .get("appWindowList")
            .and_then(Value::as_array)
            .map(|items| items.len())
            .unwrap_or(0),
    })
}

fn extract_friend_context(payload: &Value, target_friend_id: &str) -> Option<FriendContext> {
    let mut selected = None;
    for row in extract_friend_list(payload) {
        let friend_id = row.get("friendId").map(coerce_text).unwrap_or_default();
        if friend_id.is_empty() {
            continue;
        }
        let candidate = FriendContext {
            friend_id: friend_id.clone(),
            friend_source: row
                .get("friendSource")
                .map(coerce_text)
                .filter(|value| !value.trim().is_empty())
                .unwrap_or_else(|| "0".to_string()),
            job_source: row
                .get("jobSource")
                .map(coerce_text)
                .filter(|value| !value.trim().is_empty())
                .unwrap_or_else(|| "0".to_string()),
            security_id: row.get("securityId").map(coerce_text).unwrap_or_default(),
            friend_type: row.get("friendType").and_then(Value::as_i64),
            fridend_stage: row.get("fridendStage").and_then(Value::as_i64),
            datetime_ms: row.get("datetime").and_then(Value::as_u64),
            water_level: row.get("waterLevel").and_then(Value::as_u64),
        };
        if candidate.friend_id == target_friend_id {
            return Some(candidate);
        }
        if selected.is_none() {
            selected = Some(candidate);
        }
    }
    selected
}

fn infer_geek_enter_k810(friend_ctx: &FriendContext) -> String {
    if let Some(stage) = friend_ctx.fridend_stage {
        if (stage & 4) == 4 {
            return "0".to_string();
        }
    }
    if let Some(friend_type) = friend_ctx.friend_type {
        if friend_type == 4 {
            return "0".to_string();
        }
    }
    if let Some(last_chat_ms) = friend_ctx.datetime_ms {
        let age_ms = now_ms().saturating_sub(last_chat_ms);
        if age_ms <= 86_400_000 {
            return "0".to_string();
        }
    }
    "1".to_string()
}

fn coerce_text(value: &Value) -> String {
    match value {
        Value::String(text) => text.to_string(),
        Value::Number(number) => number.to_string(),
        other => other.to_string(),
    }
}

fn encode_form_body(params: &BTreeMap<String, String>) -> String {
    params
        .iter()
        .map(|(key, value)| format!("{}={}", query_component(key), query_component(value)))
        .collect::<Vec<_>>()
        .join("&")
}

fn query_component(value: &str) -> String {
    let mut out = String::new();
    for byte in value.as_bytes() {
        match byte {
            b'0'..=b'9' | b'a'..=b'z' | b'A'..=b'Z' | b'-' | b'_' | b'.' | b'*' => {
                out.push(*byte as char)
            }
            b' ' => out.push('+'),
            _ => out.push_str(&format!("%{byte:02X}")),
        }
    }
    out
}

fn split_multi_values(value: &Value) -> Vec<String> {
    match value {
        Value::Array(items) => items.iter().flat_map(split_multi_values).collect(),
        Value::Null => Vec::new(),
        Value::String(text) => split_text_values(text),
        Value::Number(number) => vec![number.to_string()],
        other => split_text_values(&other.to_string()),
    }
}

fn split_text_values(text: &str) -> Vec<String> {
    let trimmed = text.trim();
    if trimmed.is_empty() {
        return Vec::new();
    }
    if trimmed.contains(',') {
        return trimmed
            .split(',')
            .filter_map(|part| {
                let value = part.trim();
                if value.is_empty() {
                    None
                } else {
                    Some(value.to_string())
                }
            })
            .collect();
    }
    vec![trimmed.to_string()]
}

fn uniq(values: Vec<String>) -> Vec<String> {
    let mut seen = std::collections::BTreeSet::new();
    let mut out = Vec::new();
    for value in values {
        if seen.insert(value.clone()) {
            out.push(value);
        }
    }
    out
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn extract_friend_ids_reads_v1_payload_shape() {
        let payload = json!({
            "code": 0,
            "zpData": {
                "friendIdList": ["899"],
                "zpFriendIdList": [
                    { "friendId": 900 },
                    { "friendId": "901" }
                ]
            }
        });

        assert_eq!(extract_friend_ids(&payload), vec!["899", "900", "901"]);
    }

    #[test]
    fn build_query_url_keeps_app_id_unsigned() {
        let params = BTreeMap::from([
            ("client_info".to_string(), "a".to_string()),
            ("sp".to_string(), "zwp_stub~".to_string()),
            ("sig".to_string(), "V3.stub".to_string()),
        ]);
        let unsigned = BTreeMap::from([("app_id".to_string(), "1003".to_string())]);
        let url = build_query_url(
            DEFAULT_CONTACT_DIRECT_HOST,
            FRIEND_BASE_INFO_PATH,
            &params,
            &unsigned,
        )
        .expect("url");
        let parsed = Url::parse(&url).expect("parsed url");
        let query = parsed
            .query_pairs()
            .into_owned()
            .collect::<BTreeMap<String, String>>();
        assert_eq!(query.get("app_id").map(String::as_str), Some("1003"));
        assert!(query.contains_key("sp"));
        assert!(query.contains_key("sig"));
    }

    #[test]
    fn extract_message_list_prefers_messages_then_data() {
        let payload = json!({
            "zpData": {
                "messages": [{ "mid": "1" }]
            }
        });
        assert_eq!(extract_message_list(&payload).len(), 1);

        let payload = json!({
            "zpData": {
                "data": [{ "mid": "2" }]
            }
        });
        assert_eq!(extract_message_list(&payload).len(), 1);
    }

    #[test]
    fn extract_friend_context_prefers_target_friend() {
        let payload = json!({
            "zpData": {
                "baseInfoList": [
                    {"friendId": 1, "friendSource": 0, "jobSource": 0, "securityId": "a"},
                    {"friendId": 2, "friendSource": 1, "jobSource": 4, "securityId": "b", "friendType": 4}
                ]
            }
        });

        let ctx = extract_friend_context(&payload, "2").expect("friend context");
        assert_eq!(ctx.friend_id, "2");
        assert_eq!(ctx.friend_source, "1");
        assert_eq!(ctx.job_source, "4");
        assert_eq!(ctx.security_id, "b");
    }

    #[test]
    fn infer_geek_enter_k810_uses_recent_chat_window() {
        let recent = FriendContext {
            friend_id: "1".to_string(),
            friend_source: "0".to_string(),
            job_source: "0".to_string(),
            security_id: "sec".to_string(),
            friend_type: Some(3),
            fridend_stage: None,
            datetime_ms: Some(now_ms().saturating_sub(60_000)),
            water_level: None,
        };
        let stale = FriendContext {
            datetime_ms: Some(now_ms().saturating_sub(172_800_000)),
            ..recent.clone()
        };

        assert_eq!(infer_geek_enter_k810(&recent), "0");
        assert_eq!(infer_geek_enter_k810(&stale), "1");
    }

    #[test]
    fn encode_form_body_keeps_unsigned_app_id() {
        let form = BTreeMap::from([
            ("client_info".to_string(), "a".to_string()),
            ("sp".to_string(), "zwp_stub~".to_string()),
            ("sig".to_string(), "V3.stub".to_string()),
            ("app_id".to_string(), "1003".to_string()),
        ]);
        let encoded = encode_form_body(&form);
        assert!(encoded.contains("app_id=1003"));
        assert!(encoded.contains("sp=zwp_stub%7E"));
    }
}
