use std::collections::{BTreeMap, BTreeSet, HashMap};
use std::path::PathBuf;
use std::process::{Command, Output, Stdio};
use std::sync::atomic::{AtomicU32, Ordering};
use std::thread::sleep;
use std::time::Duration;

use anyhow::{anyhow, Context, Result};
use base64::Engine as _;
use prost::Message as ProstMessage;
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
const MESSAGE_PULL_SYNC_PATH: &str = "/api/zpmsg/history/pull";
const EXCHANGE_LIST_PATH: &str = "/api/zprelation/exchange/getExchangeList";
const INTERACTION_INFO_PATH: &str = "/api/zprelation/interaction/geekGetInfo";
const INTERACTION_HOT_JOB_REC_PATH: &str = "/api/zprelation/interaction/geekGetHotJobRec";
const CHAT_PAYLOAD_PROTOCOL_VERSION: &str = "1.4";
const CHAT_KERNEL_PROTOCOL_VERSION: &str = "1.3";
const CHAT_MESSAGE_TYPE_TEXT: i32 = 1;
const CHAT_MESSAGE_TEMPLATE_TEXT: i32 = 1;
const MMS_FLAG_EXPECT_ACK: u8 = 2;
const CHAT_PRESENCE_ONLINE: i32 = 512;
const CHAT_PRESENCE_PULL: i32 = 256;

static NEXT_MMS_MESSAGE_ID: AtomicU32 = AtomicU32::new(1);

const DEFAULT_SEND_RUNTIME: &str = "mqtt";
const BOSS_APK_MQTT_TIMEOUT_SECONDS: u64 = 45;
const PAYLOAD_BUILDER_MODE_SERIALIZER: &str = "serializer";
const PAYLOAD_BUILDER_MODE_PATCHED: &str = "patched";
const PAYLOAD_BUILDER_MODE_MANUAL: &str = "manual";

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
    let history_probe = ctx.fetch_message_history(
        &params,
        friend_ctx
            .as_ref()
            .map(|ctx| ctx.security_id.as_str())
            .filter(|value| !value.trim().is_empty()),
        opts,
    )?;
    let output = json!({
        "ok": response_code(Some(history_probe.result.response_payload())) == Some(0),
        "route": "message_history_pull",
        "session_path": ctx.resolved_session_path,
        "transport_runtime": ctx.transport.label(),
        "original_okhttp_available": ctx.transport.original_okhttp_available(),
        "transport": ctx.transport.describe(),
        "native_invoker": ctx.signer.describe(),
        "friend_lookup": friend_lookup.to_value(),
        "friend_context": friend_ctx.as_ref().map(FriendContext::to_value).unwrap_or(Value::Null),
        "bootstrap": bootstrap.as_ref().map(ChatBootstrapResult::to_value).unwrap_or(Value::Null),
        "message_history": history_probe.result.to_value(),
        "attempts": history_probe.attempts.iter().map(SignedGetResult::to_value).collect::<Vec<_>>(),
        "decoded_messages": history_probe.decoded_messages.iter().map(DecodedHistoryMessage::to_value).collect::<Vec<_>>(),
        "decode_errors": history_probe.decode_errors,
        "summary": summarize_messages(
            &friend_id,
            &friend_source,
            &max_msg_id,
            history_probe.raw_messages.len(),
            &history_probe.decoded_messages,
        ),
    });

    ctx.write_output(
        opts.get("--out").map(String::as_str),
        "messages_result.json",
        &output,
    )?;
    Ok(output)
}

pub fn run_messages_all(opts: &HashMap<String, String>) -> Result<Value> {
    let ctx = BossContactContext::from_opts(opts)?;
    let limit = opts
        .get("--limit")
        .and_then(|value| value.parse::<usize>().ok())
        .filter(|value| *value > 0);
    let count = opts
        .get("--count")
        .cloned()
        .unwrap_or_else(|| "20".to_string());
    let max_msg_id = opts
        .get("--max-msg-id")
        .cloned()
        .or_else(|| opts.get("--last-msg-id").cloned())
        .unwrap_or_else(|| "0".to_string());
    let batch_size = opts
        .get("--base-info-batch")
        .and_then(|value| value.parse::<usize>().ok())
        .filter(|value| *value > 0)
        .unwrap_or(20)
        .min(100);
    let skip_sync = parse_bool_flag(opts, "--skip-sync");

    let id_list = ctx.signed_get_contact_direct(FRIEND_ID_LIST_PATH, BTreeMap::new())?;
    let friend_ids = extract_friend_ids(id_list.response_payload());
    let selected_ids = limit
        .map(|value| friend_ids.iter().take(value).cloned().collect::<Vec<_>>())
        .unwrap_or_else(|| friend_ids.clone());
    let (base_info_batches, friend_rows) = load_friend_rows(&ctx, &selected_ids, batch_size)?;

    let mut histories = Vec::new();
    let mut failed_contacts = Vec::new();
    let mut ok_contacts = 0_usize;
    let mut contacts_with_messages = 0_usize;
    let mut total_message_count = 0_usize;

    for row in &friend_rows {
        let friend_context = match friend_context_from_row(row) {
            Some(value) => value,
            None => {
                failed_contacts.push(json!({
                    "friend_card": row,
                    "error": "failed to parse friend context from base info row",
                }));
                continue;
            }
        };

        let friend_name = extract_friend_name_from_row(row);
        let mut params = BTreeMap::from([
            ("friendId".to_string(), friend_context.friend_id.clone()),
            ("count".to_string(), count.clone()),
            (
                "friendSource".to_string(),
                friend_context.friend_source.clone(),
            ),
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

        let recent_history = ctx.fetch_message_history(
            &params,
            Some(friend_context.security_id.as_str()).filter(|value| !value.trim().is_empty()),
            opts,
        );
        let sync_history = if skip_sync || friend_context.security_id.trim().is_empty() {
            None
        } else {
            Some(ctx.fetch_message_sync_history_with_cursor(&friend_context.security_id, 0, opts))
        };

        let recent_error = recent_history.as_ref().err().map(|error| error.to_string());
        let sync_error = sync_history
            .as_ref()
            .and_then(|result| result.as_ref().err().map(|error| error.to_string()));
        let recent_history = recent_history.ok();
        let sync_history = sync_history.and_then(Result::ok);
        let merged_messages =
            merge_decoded_histories(recent_history.as_ref(), sync_history.as_ref());
        let decode_errors = merge_decode_errors(recent_history.as_ref(), sync_history.as_ref());
        let contact_ok = recent_history
            .as_ref()
            .map(|probe| response_code(Some(probe.result.response_payload())) == Some(0))
            .unwrap_or(false)
            || sync_history
                .as_ref()
                .map(|probe| response_code(Some(probe.result.response_payload())) == Some(0))
                .unwrap_or(false);

        if contact_ok {
            ok_contacts += 1;
        }
        if !merged_messages.is_empty() {
            contacts_with_messages += 1;
        }
        total_message_count += merged_messages.len();

        if recent_error.is_some() || sync_error.is_some() {
            failed_contacts.push(json!({
                "friend_id": friend_context.friend_id,
                "friend_name": friend_name,
                "recent_error": recent_error,
                "sync_error": sync_error,
            }));
        }

        histories.push(json!({
            "ok": contact_ok,
            "friend_name": friend_name,
            "friend_card": row,
            "friend_context": friend_context.to_value(),
            "recent_history": recent_history
                .as_ref()
                .map(summarize_history_probe)
                .unwrap_or(Value::Null),
            "sync_history": sync_history
                .as_ref()
                .map(summarize_history_probe)
                .unwrap_or(Value::Null),
            "errors": {
                "recent": recent_error,
                "sync": sync_error,
                "decode": decode_errors,
            },
            "messages": merged_messages
                .iter()
                .map(DecodedHistoryMessage::to_value)
                .collect::<Vec<_>>(),
            "summary": summarize_messages(
                &friend_context.friend_id,
                &friend_context.friend_source,
                &max_msg_id,
                recent_history
                    .as_ref()
                    .map(|probe| probe.raw_messages.len())
                    .unwrap_or(0)
                    + sync_history
                        .as_ref()
                        .map(|probe| probe.raw_messages.len())
                        .unwrap_or(0),
                &merged_messages,
            ),
        }));
    }

    let output = json!({
        "ok": ok_contacts > 0,
        "route": "message_history_all_contacts",
        "session_path": ctx.resolved_session_path,
        "transport_runtime": ctx.transport.label(),
        "original_okhttp_available": ctx.transport.original_okhttp_available(),
        "transport": ctx.transport.describe(),
        "native_invoker": ctx.signer.describe(),
        "friend_id_list": id_list.to_value(),
        "friend_base_info_batches": base_info_batches
            .iter()
            .map(SignedGetResult::to_value)
            .collect::<Vec<_>>(),
        "friend_histories": histories,
        "summary": {
            "friend_id_count": friend_ids.len(),
            "selected_friend_count": selected_ids.len(),
            "resolved_friend_count": friend_rows.len(),
            "history_ok_count": ok_contacts,
            "history_failure_count": failed_contacts.len(),
            "contacts_with_messages": contacts_with_messages,
            "total_message_count": total_message_count,
            "count_per_contact": count,
            "max_msg_id": max_msg_id,
            "skip_sync": skip_sync,
        },
        "failures": failed_contacts,
    });

    ctx.write_output(
        opts.get("--out").map(String::as_str),
        "messages_all_result.json",
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

pub fn run_send_text(opts: &HashMap<String, String>) -> Result<Value> {
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
            "send-text requires --uid <friendId> or positional <friendId>"
        ));
    }
    let text = opts
        .get("--text")
        .cloned()
        .or_else(|| opts.get("_1").cloned())
        .unwrap_or_default();
    if text.trim().is_empty() {
        return Err(anyhow!(
            "send-text requires --text <message> or second positional <message>"
        ));
    }

    let initial_friend_lookup = ctx.signed_get_contact_direct(
        FRIEND_BASE_INFO_PATH,
        BTreeMap::from([("friendIds".to_string(), friend_id.clone())]),
    )?;
    let mut friend_lookup = initial_friend_lookup.clone();
    let mut friend_ctx = extract_friend_context(friend_lookup.response_payload(), &friend_id)
        .ok_or_else(|| anyhow!("failed to resolve friend context for {friend_id}"))?;
    let mut friend_name =
        extract_friend_name(friend_lookup.response_payload(), &friend_id).unwrap_or_default();
    let skip_bootstrap = parse_bool_flag(opts, "--skip-bootstrap");
    let mut bootstrap = if skip_bootstrap {
        None
    } else {
        Some(ctx.bootstrap_chat(&friend_ctx, opts)?)
    };
    let proactive_prewarm =
        maybe_trigger_first_reply_proactive_send(&ctx, &friend_ctx, bootstrap.as_ref(), opts)?;
    let mut proactive_refresh = Value::Null;
    if proactive_send_succeeded(&proactive_prewarm) {
        let refreshed_lookup = ctx.signed_get_contact_direct(
            FRIEND_BASE_INFO_PATH,
            BTreeMap::from([("friendIds".to_string(), friend_id.clone())]),
        )?;
        if let Some(refreshed_ctx) =
            extract_friend_context(refreshed_lookup.response_payload(), &friend_id)
        {
            let refreshed_name =
                extract_friend_name(refreshed_lookup.response_payload(), &friend_id)
                    .unwrap_or_default();
            let refreshed_bootstrap = if skip_bootstrap {
                None
            } else {
                Some(ctx.bootstrap_chat(&refreshed_ctx, opts)?)
            };
            proactive_refresh = json!({
                "triggered": true,
                "refreshed": true,
                "before": {
                    "friend_context": friend_ctx.to_value(),
                    "friend_name": friend_name,
                    "friend_lookup": friend_lookup.to_value(),
                    "bootstrap": bootstrap.as_ref().map(ChatBootstrapResult::to_value).unwrap_or(Value::Null),
                },
                "after": {
                    "friend_context": refreshed_ctx.to_value(),
                    "friend_name": refreshed_name,
                    "friend_lookup": refreshed_lookup.to_value(),
                    "bootstrap": refreshed_bootstrap.as_ref().map(ChatBootstrapResult::to_value).unwrap_or(Value::Null),
                }
            });
            friend_lookup = refreshed_lookup;
            friend_ctx = refreshed_ctx;
            friend_name = refreshed_name;
            bootstrap = refreshed_bootstrap;
        } else {
            proactive_refresh = json!({
                "triggered": true,
                "refreshed": false,
                "reason": "friend_context_missing_after_proactive_send",
                "after_lookup": refreshed_lookup.to_value(),
            });
        }
    }

    let sender_uid = parse_i64_field(&ctx.session.uid, "session.uid")?;
    let inferred_sender_name = if opts.contains_key("--my-name") {
        None
    } else {
        infer_sender_name_from_history(&ctx, &friend_ctx, sender_uid, opts)?
    };
    let sender_name = opts
        .get("--my-name")
        .cloned()
        .filter(|value| !value.trim().is_empty())
        .or(inferred_sender_name)
        .unwrap_or_else(|| ctx.session.phone.clone());
    let extend = opts.get("--extend").cloned().unwrap_or_default();
    let mock_server_mid = opts
        .get("--mock-server-mid")
        .and_then(|value| value.parse::<i64>().ok());
    let send_runtime = opts
        .get("--send-runtime")
        .cloned()
        .unwrap_or_else(|| DEFAULT_SEND_RUNTIME.to_string());

    let mut draft = NativeTextMessageDraft::from_context(
        &ctx.session,
        &friend_ctx,
        &friend_name,
        &sender_name,
        text.clone(),
        extend.clone(),
    )?;
    if let Some(task_id) = opts
        .get("--task-id")
        .and_then(|value| value.trim().parse::<i64>().ok())
    {
        draft.task_id = task_id;
    }
    if let Some(quote_id) = opts
        .get("--quote-id")
        .and_then(|value| value.trim().parse::<i64>().ok())
    {
        draft.quote_id = quote_id;
    }
    if let Some(biz_type) = opts
        .get("--biz-type")
        .and_then(|value| value.trim().parse::<i32>().ok())
    {
        draft.biz_type = biz_type;
    }
    if let Some(biz_id) = opts.get("--biz-id") {
        if !biz_id.trim().is_empty() {
            draft.biz_id = biz_id.trim().to_string();
        }
    }
    let encoded = draft.encode()?;
    let presence_last_message_id = latest_history_message_id(&ctx, &friend_ctx, opts)?;
    let requested_payload_builder_mode =
        normalize_payload_builder_mode(opts.get("--payload-builder-mode").map(String::as_str));
    let mut dispatch = Jf0Dispatch::run(
        &ctx,
        &draft,
        &encoded,
        &send_runtime,
        presence_last_message_id,
        mock_server_mid,
        requested_payload_builder_mode,
    )?;
    let mut business_confirmation = if dispatch.mode == "mqtt" && dispatch.ok {
        let mqtt_receipt = dispatch.receipt.get("mqtt");
        Some(confirm_sent_message_in_history(
            &ctx,
            &friend_ctx,
            &draft,
            mqtt_receipt,
            opts,
        )?)
    } else {
        None
    };
    let mut dispatch_attempts = vec![json!({
        "payload_builder_mode": requested_payload_builder_mode,
        "dispatch": dispatch.to_value(),
        "business_confirmation": business_confirmation
            .as_ref()
            .map(BusinessSendConfirmation::to_value)
            .unwrap_or(Value::Null),
    })];
    let mut retry_mode = next_payload_builder_retry_mode(&dispatch, business_confirmation.as_ref());
    while let Some(payload_builder_mode) = retry_mode {
        let retried_dispatch = Jf0Dispatch::run(
            &ctx,
            &draft,
            &encoded,
            &send_runtime,
            presence_last_message_id,
            mock_server_mid,
            payload_builder_mode,
        )?;
        let retried_confirmation = if retried_dispatch.mode == "mqtt" && retried_dispatch.ok {
            let mqtt_receipt = retried_dispatch.receipt.get("mqtt");
            Some(confirm_sent_message_in_history(
                &ctx,
                &friend_ctx,
                &draft,
                mqtt_receipt,
                opts,
            )?)
        } else {
            None
        };
        let retried_confirmed = retried_confirmation
            .as_ref()
            .map(|confirmation| confirmation.confirmed)
            .unwrap_or(retried_dispatch.ok);
        dispatch_attempts.push(json!({
            "payload_builder_mode": payload_builder_mode,
            "dispatch": retried_dispatch.to_value(),
            "business_confirmation": retried_confirmation
                .as_ref()
                .map(BusinessSendConfirmation::to_value)
                .unwrap_or(Value::Null),
        }));
        if retried_confirmed
            || business_confirmation
                .as_ref()
                .map(|confirmation| !confirmation.confirmed)
                .unwrap_or(!dispatch.ok)
        {
            dispatch = retried_dispatch;
            business_confirmation = retried_confirmation;
        }
        retry_mode = next_payload_builder_retry_mode(&dispatch, business_confirmation.as_ref());
    }
    let send_contract_note = if dispatch.mode == "mqtt" {
        "rnidbg forwards the protobuf payload through the Boss APK extracted MQTT/TLS transport aligned with mf0.b / jf0.j, polls historyMsg to confirm the business layer recorded the message, and automatically retries with progressively stricter securityId-preserving payload variants if the APK serializer is transport-successful but business-silent."
    } else {
        "rnidbg builds the protobuf payload and MMS envelope from APK field evidence, while the final jf0 transport/ack stage is locally simulated."
    };
    let ok = business_confirmation
        .as_ref()
        .map(|confirmation| confirmation.confirmed)
        .unwrap_or(dispatch.ok);

    let output = json!({
        "ok": ok,
        "transport_ok": dispatch.ok,
        "route": "jf0_native_text_send",
        "session_path": ctx.resolved_session_path,
        "transport_runtime": ctx.transport.label(),
        "original_okhttp_available": ctx.transport.original_okhttp_available(),
        "transport": ctx.transport.describe(),
        "native_invoker": ctx.signer.describe(),
        "friend_lookup": friend_lookup.to_value(),
        "friend_context": friend_ctx.to_value(),
        "friend_name": friend_name,
        "bootstrap": bootstrap.as_ref().map(ChatBootstrapResult::to_value).unwrap_or(Value::Null),
        "proactive_prewarm": proactive_prewarm,
        "proactive_refresh": proactive_refresh,
        "send_runtime": send_runtime,
        "chat_contract": {
            "entrypoint": "ChatCommon -> message.handler.c -> jf0.i(byte[], h, expectAck)",
            "apk_evidence": {
                "factory": "ChatBeanFactory.createText()",
                "proto_builder": "module.contacts.manager.i.l()/s()/t()",
                "sender": "message.server.sender.d -> jf0.i.d().i(...)",
            },
            "note": send_contract_note,
        },
        "draft": draft.to_value(),
        "encoded": encoded.to_value(),
        "dispatch_attempts": dispatch_attempts,
        "presence_alignment": {
            "last_message_id": presence_last_message_id,
            "source": "historyMsg latest mid",
        },
        "dispatch": dispatch.to_value(),
        "business_confirmation": business_confirmation.as_ref().map(BusinessSendConfirmation::to_value).unwrap_or(Value::Null),
    });

    ctx.write_output(
        opts.get("--out").map(String::as_str),
        "chat_send_text_result.json",
        &output,
    )?;
    Ok(output)
}

pub fn run_chat_payload(opts: &HashMap<String, String>) -> Result<Value> {
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
            "chat-payload requires --uid <friendId> or positional <friendId>"
        ));
    }
    let text = opts
        .get("--text")
        .cloned()
        .or_else(|| opts.get("_1").cloned())
        .unwrap_or_default();
    if text.trim().is_empty() {
        return Err(anyhow!(
            "chat-payload requires --text <message> or second positional <message>"
        ));
    }

    let friend_lookup = ctx.signed_get_contact_direct(
        FRIEND_BASE_INFO_PATH,
        BTreeMap::from([("friendIds".to_string(), friend_id.clone())]),
    )?;
    let friend_ctx = extract_friend_context(friend_lookup.response_payload(), &friend_id)
        .ok_or_else(|| anyhow!("failed to resolve friend context for {friend_id}"))?;
    let friend_name =
        extract_friend_name(friend_lookup.response_payload(), &friend_id).unwrap_or_default();
    let bootstrap = if parse_bool_flag(opts, "--skip-bootstrap") {
        None
    } else {
        Some(ctx.bootstrap_chat(&friend_ctx, opts)?)
    };

    let sender_uid = parse_i64_field(&ctx.session.uid, "session.uid")?;
    let inferred_sender_name = if opts.contains_key("--my-name") {
        None
    } else {
        infer_sender_name_from_history(&ctx, &friend_ctx, sender_uid, opts)?
    };
    let sender_name = opts
        .get("--my-name")
        .cloned()
        .filter(|value| !value.trim().is_empty())
        .or(inferred_sender_name)
        .unwrap_or_else(|| ctx.session.phone.clone());
    let extend = opts.get("--extend").cloned().unwrap_or_default();

    let mut draft = NativeTextMessageDraft::from_context(
        &ctx.session,
        &friend_ctx,
        &friend_name,
        &sender_name,
        text,
        extend,
    )?;
    if let Some(task_id) = opts
        .get("--task-id")
        .and_then(|value| value.trim().parse::<i64>().ok())
    {
        draft.task_id = task_id;
    }
    if let Some(quote_id) = opts
        .get("--quote-id")
        .and_then(|value| value.trim().parse::<i64>().ok())
    {
        draft.quote_id = quote_id;
    }
    if let Some(biz_type) = opts
        .get("--biz-type")
        .and_then(|value| value.trim().parse::<i32>().ok())
    {
        draft.biz_type = biz_type;
    }
    if let Some(biz_id) = opts.get("--biz-id") {
        if !biz_id.trim().is_empty() {
            draft.biz_id = biz_id.trim().to_string();
        }
    }

    let encoded = draft.encode()?;
    let presence_last_message_id = latest_history_message_id(&ctx, &friend_ctx, opts)?;
    let mqtt_dispatch = BossApkMqttDispatch::new(&ctx.lab_config)?;
    let requested_payload_builder_mode =
        normalize_payload_builder_mode(opts.get("--payload-builder-mode").map(String::as_str));
    let (selected_payload_base64, payload_builder) = mqtt_dispatch.build_payload(
        &ctx.session,
        &draft,
        &encoded.mms_message.payload_base64,
        requested_payload_builder_mode,
    )?;
    let (presence_payload_base64, presence_builder) =
        build_presence_payload(&ctx.session, presence_last_message_id)?;
    let selected_payload_bytes = base64::engine::general_purpose::STANDARD
        .decode(selected_payload_base64.as_bytes())
        .context("failed to decode selected boss apk payload")?;

    let output = json!({
        "ok": true,
        "route": "jf0_native_text_payload",
        "session_path": ctx.resolved_session_path,
        "transport_runtime": ctx.transport.label(),
        "original_okhttp_available": ctx.transport.original_okhttp_available(),
        "transport": ctx.transport.describe(),
        "native_invoker": ctx.signer.describe(),
        "friend_lookup": friend_lookup.to_value(),
        "friend_context": friend_ctx.to_value(),
        "friend_name": friend_name,
        "bootstrap": bootstrap.as_ref().map(ChatBootstrapResult::to_value).unwrap_or(Value::Null),
        "side_effects": {
            "network_send_performed": false,
            "proactive_prewarm_triggered": false,
            "note": "chat-payload only builds and compares the outbound protobuf/MMS contract; it never publishes to jf0/MQTT.",
        },
        "chat_contract": {
            "entrypoint": "ChatCommon -> message.handler.c -> message.server.sender.c -> jf0.i(byte[], h, expectAck)",
            "apk_evidence": {
                "proto_builder": "module.contacts.manager.i.F().a(chatBean)",
                "payload_sender": "message.server.sender.c.f()",
                "ack_gate": "message.handler.m.a(cVar)",
                "success_path": "message.server.sender.d.b.onSuccess -> xi0.a.l(cVar, true, mid)",
            },
            "business_expectation": {
                "local_save_precedes_send": true,
                "transport_ack_required": true,
                "server_mid_required_for_full_success": true,
            },
        },
        "draft": draft.to_value(),
        "encoded": encoded.to_value(),
        "selected_payload": {
            "base64": selected_payload_base64,
            "hex": hex::encode(&selected_payload_bytes),
            "size": selected_payload_bytes.len(),
            "matches_rust_encoded": selected_payload_bytes == encoded.payload,
            "requested_payload_builder_mode": requested_payload_builder_mode,
        },
        "boss_apk_payload_builder": payload_builder,
        "presence_alignment": {
            "last_message_id": presence_last_message_id,
            "source": "historyMsg latest mid",
            "payload_base64": presence_payload_base64,
            "builder": presence_builder,
        },
    });

    ctx.write_output(
        opts.get("--out").map(String::as_str),
        "chat_payload_result.json",
        &output,
    )?;
    Ok(output)
}

fn maybe_trigger_first_reply_proactive_send(
    ctx: &BossContactContext,
    friend_ctx: &FriendContext,
    bootstrap: Option<&ChatBootstrapResult>,
    opts: &HashMap<String, String>,
) -> Result<Value> {
    let ai_interval = bootstrap
        .and_then(|result| {
            select_best_post_attempt(&result.geek_enter_attempts)
                .or_else(|| result.geek_enter_attempts.last())
                .and_then(|attempt| {
                    attempt
                        .response_payload()
                        .get("zpData")
                        .and_then(|zp_data| zp_data.get("aiDirectChatReasonInterval"))
                        .and_then(value_as_i64)
                })
        })
        .unwrap_or(0);
    if ai_interval <= 0 {
        return Ok(json!({
            "triggered": false,
            "reason": "ai_direct_chat_interval_unavailable",
        }));
    }

    let sender_uid = parse_i64_field(&ctx.session.uid, "session.uid")?;
    let history_params = BTreeMap::from([
        ("friendId".to_string(), friend_ctx.friend_id.clone()),
        ("count".to_string(), "20".to_string()),
        ("friendSource".to_string(), friend_ctx.friend_source.clone()),
        ("maxMsgId".to_string(), "0".to_string()),
    ]);
    let history =
        ctx.fetch_message_history(&history_params, Some(friend_ctx.security_id.as_str()), opts)?;

    let mut has_outgoing_text = false;
    let mut consecutive_inbound_text = 0_i64;
    for message in history.decoded_messages.iter().rev() {
        if message.message_type != CHAT_MESSAGE_TYPE_TEXT {
            continue;
        }
        if message.from_uid == sender_uid {
            has_outgoing_text = true;
            break;
        }
        if message.from_uid == friend_ctx.friend_id.parse::<i64>().unwrap_or_default() {
            consecutive_inbound_text += 1;
        }
    }

    if has_outgoing_text {
        return Ok(json!({
            "triggered": false,
            "reason": "conversation_already_has_outgoing_text",
            "ai_direct_chat_interval": ai_interval,
            "recent_inbound_text_count": consecutive_inbound_text,
        }));
    }
    if consecutive_inbound_text < ai_interval {
        return Ok(json!({
            "triggered": false,
            "reason": "recent_inbound_text_below_threshold",
            "ai_direct_chat_interval": ai_interval,
            "recent_inbound_text_count": consecutive_inbound_text,
        }));
    }

    let form = BTreeMap::from([
        ("securityId".to_string(), friend_ctx.security_id.clone()),
        ("scene".to_string(), "1".to_string()),
    ]);
    let attempts = if opts.contains_key("--host") {
        vec![ctx.signed_post_api(CHAT_PROACTIVE_SEND_PATH, form.clone())?]
    } else {
        ctx.probe_chat_form_like(CHAT_PROACTIVE_SEND_PATH, form.clone())?
    };
    let result = select_best_post_attempt(&attempts)
        .cloned()
        .or_else(|| attempts.last().cloned())
        .ok_or_else(|| anyhow!("proactive prewarm probe did not execute"))?;

    Ok(json!({
        "triggered": true,
        "ai_direct_chat_interval": ai_interval,
        "recent_inbound_text_count": consecutive_inbound_text,
        "result": result.to_value(),
        "attempts": attempts.iter().map(SignedPostResult::to_value).collect::<Vec<_>>(),
    }))
}

fn latest_history_message_id(
    ctx: &BossContactContext,
    friend_ctx: &FriendContext,
    opts: &HashMap<String, String>,
) -> Result<i64> {
    let history_params = BTreeMap::from([
        ("friendId".to_string(), friend_ctx.friend_id.clone()),
        ("count".to_string(), "20".to_string()),
        ("friendSource".to_string(), friend_ctx.friend_source.clone()),
        ("maxMsgId".to_string(), "0".to_string()),
    ]);
    let history =
        ctx.fetch_message_history(&history_params, Some(friend_ctx.security_id.as_str()), opts)?;
    Ok(history
        .decoded_messages
        .iter()
        .map(|message| message.mid)
        .max()
        .unwrap_or(0))
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

pub fn run_hot_job_recommend(opts: &HashMap<String, String>) -> Result<Value> {
    let ctx = BossContactContext::from_opts(opts)?;
    let page = opts
        .get("--page")
        .cloned()
        .unwrap_or_else(|| "1".to_string());
    let tag = opts
        .get("--tag")
        .cloned()
        .unwrap_or_else(|| "0".to_string());
    let result = ctx.signed_get_contact_direct(
        INTERACTION_HOT_JOB_REC_PATH,
        BTreeMap::from([
            ("page".to_string(), page.clone()),
            ("tag".to_string(), tag.clone()),
        ]),
    )?;
    let cards = extract_hot_job_recommend_cards(result.response_payload());
    let output = json!({
        "ok": response_code(Some(result.response_payload())) == Some(0) && !cards.is_empty(),
        "route": "interaction_hot_job_rec_single_route",
        "session_path": ctx.resolved_session_path,
        "transport_runtime": ctx.transport.label(),
        "original_okhttp_available": ctx.transport.original_okhttp_available(),
        "transport": ctx.transport.describe(),
        "native_invoker": ctx.signer.describe(),
        "page": page,
        "tag": tag,
        "recommend": result.to_value(),
        "summary": summarize_hot_job_recommend_cards(&cards),
        "cards": cards,
    });

    ctx.write_output(
        opts.get("--out").map(String::as_str),
        "hot_job_recommend_result.json",
        &output,
    )?;
    Ok(output)
}

struct BossContactContext {
    resolved_session_path: String,
    lab_config: LabConfig,
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
            lab_config,
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
        Ok(vec![self.signed_get(
            &self.direct_host,
            path,
            params,
            BTreeMap::from([("app_id".to_string(), APP_ID.to_string())]),
            "direct_host_unsigned_app_id",
        )?])
    }

    fn probe_chat_form_like(
        &self,
        path: &str,
        form_params: BTreeMap<String, String>,
    ) -> Result<Vec<SignedPostResult>> {
        Ok(vec![self.signed_post_contact_direct(path, form_params)?])
    }

    fn probe_chat_get_like(
        &self,
        path: &str,
        params: BTreeMap<String, String>,
    ) -> Result<Vec<SignedGetResult>> {
        Ok(vec![self.signed_get(
            &self.direct_host,
            path,
            params,
            BTreeMap::from([("app_id".to_string(), APP_ID.to_string())]),
            "direct_host_unsigned_app_id",
        )?])
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

    fn fetch_message_history(
        &self,
        params: &BTreeMap<String, String>,
        history_secret_id: Option<&str>,
        opts: &HashMap<String, String>,
    ) -> Result<MessageHistoryProbe> {
        let mut attempts = if opts.contains_key("--host") {
            vec![self.signed_get_api(MESSAGE_PULL_PATH, params.clone())?]
        } else {
            self.probe_message_like(MESSAGE_PULL_PATH, params.clone())?
        };
        if let Some(secret_id) = history_secret_id {
            attempts.extend(self.probe_message_sync_history(secret_id, 0, opts)?);
        }
        let result = select_best_message_attempt(&attempts)
            .cloned()
            .or_else(|| attempts.last().cloned())
            .ok_or_else(|| anyhow!("message history probe did not execute"))?;
        let raw_messages = extract_message_list(result.response_payload());
        let (decoded_messages, decode_errors) = decode_history_messages(&raw_messages);
        Ok(MessageHistoryProbe {
            result,
            attempts,
            raw_messages,
            decoded_messages,
            decode_errors,
        })
    }

    fn probe_message_sync_history(
        &self,
        secret_id: &str,
        last_id: i64,
        opts: &HashMap<String, String>,
    ) -> Result<Vec<SignedGetResult>> {
        let params = BTreeMap::from([
            ("lastId".to_string(), last_id.to_string()),
            ("secretId".to_string(), secret_id.to_string()),
        ]);
        if opts.contains_key("--host") {
            Ok(vec![self.signed_get_api(MESSAGE_PULL_SYNC_PATH, params)?])
        } else {
            self.probe_message_like(MESSAGE_PULL_SYNC_PATH, params)
        }
    }

    fn fetch_message_sync_history_with_cursor(
        &self,
        secret_id: &str,
        last_id: i64,
        opts: &HashMap<String, String>,
    ) -> Result<MessageHistoryProbe> {
        let mut attempts = Vec::new();
        let mut raw_messages = Vec::new();
        let mut cursor_secret_id = secret_id.to_string();
        let mut cursor_last_id = last_id;
        let mut page_count = 0_u8;

        loop {
            page_count = page_count.saturating_add(1);
            let page_attempts =
                self.probe_message_sync_history(&cursor_secret_id, cursor_last_id, opts)?;
            let page_result = select_best_message_attempt(&page_attempts)
                .cloned()
                .or_else(|| page_attempts.last().cloned())
                .ok_or_else(|| anyhow!("message sync history probe did not execute"))?;
            raw_messages.extend(extract_message_list(page_result.response_payload()));
            attempts.extend(page_attempts);

            let payload = page_result.response_payload();
            let has_more = payload
                .get("hasMore")
                .and_then(Value::as_bool)
                .unwrap_or(false);
            if !has_more || page_count >= 4 {
                break;
            }

            let next_last_id = payload.get("lastId").and_then(value_as_i64).unwrap_or(0);
            let next_secret_id = payload
                .get("secretId")
                .and_then(Value::as_str)
                .unwrap_or_default()
                .trim()
                .to_string();
            if next_last_id <= 0 || next_secret_id.is_empty() {
                break;
            }
            cursor_last_id = next_last_id;
            cursor_secret_id = next_secret_id;
        }

        let result = select_best_message_attempt(&attempts)
            .cloned()
            .or_else(|| attempts.last().cloned())
            .ok_or_else(|| anyhow!("message sync history probe did not execute"))?;
        let (decoded_messages, decode_errors) = decode_history_messages(&raw_messages);
        Ok(MessageHistoryProbe {
            result,
            attempts,
            raw_messages,
            decoded_messages,
            decode_errors,
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

struct MessageHistoryProbe {
    result: SignedGetResult,
    attempts: Vec<SignedGetResult>,
    raw_messages: Vec<Value>,
    decoded_messages: Vec<DecodedHistoryMessage>,
    decode_errors: Vec<Value>,
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
    fn business_state(&self) -> Value {
        let is_friend_have_send_msg_to_me = self
            .fridend_stage
            .map(|stage| (stage & 1) == 1)
            .unwrap_or(false)
            || self.friend_type == Some(3);
        let is_i_have_send_msg_to_friend = self
            .fridend_stage
            .map(|stage| (stage & 2) == 2)
            .unwrap_or(false)
            || self.friend_type == Some(1);
        let is_contact_each_other = self
            .fridend_stage
            .map(|stage| (stage & 4) == 4)
            .unwrap_or(false)
            || (is_friend_have_send_msg_to_me && is_i_have_send_msg_to_friend);
        let is_passive_conversation = !is_contact_each_other && !is_i_have_send_msg_to_friend;
        let is_initiative_conversation = !is_contact_each_other && is_i_have_send_msg_to_friend;
        json!({
            "is_friend_have_send_msg_to_me": is_friend_have_send_msg_to_me,
            "is_i_have_send_msg_to_friend": is_i_have_send_msg_to_friend,
            "is_contact_each_other": is_contact_each_other,
            "is_passive_conversation": is_passive_conversation,
            "is_initiative_conversation": is_initiative_conversation,
        })
    }

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
            "business_state": self.business_state(),
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

fn select_best_message_attempt(attempts: &[SignedGetResult]) -> Option<&SignedGetResult> {
    attempts
        .iter()
        .filter(|attempt| response_code(Some(attempt.response_payload())) == Some(0))
        .max_by_key(|attempt| extract_message_list(attempt.response_payload()).len())
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
    for key in ["messages", "data", "stringList"] {
        if let Some(array) = zp_data.get(key).and_then(Value::as_array) {
            return array.clone();
        }
    }
    Vec::new()
}

fn decode_history_messages(messages: &[Value]) -> (Vec<DecodedHistoryMessage>, Vec<Value>) {
    let mut decoded = Vec::new();
    let mut errors = Vec::new();
    for (index, entry) in messages.iter().enumerate() {
        let Some(blob) = entry.as_str() else {
            errors.push(json!({
                "index": index,
                "error": "history message entry is not a base64 string",
            }));
            continue;
        };
        match decode_history_blob(blob) {
            Ok(protocol) => {
                for message in protocol.messages {
                    decoded.push(DecodedHistoryMessage::from_proto(
                        index,
                        protocol.protocol_type,
                        &protocol.version,
                        message,
                    ));
                }
            }
            Err(error) => errors.push(json!({
                "index": index,
                "error": error.to_string(),
            })),
        }
    }
    (decoded, errors)
}

fn decode_history_blob(blob: &str) -> Result<TechwolfChatProtocolProto> {
    let data = base64::engine::general_purpose::STANDARD
        .decode(blob)
        .or_else(|_| base64::engine::general_purpose::STANDARD_NO_PAD.decode(blob))
        .or_else(|_| base64::engine::general_purpose::URL_SAFE.decode(blob))
        .or_else(|_| base64::engine::general_purpose::URL_SAFE_NO_PAD.decode(blob))
        .context("failed to decode history message base64")?;
    TechwolfChatProtocolProto::decode(data.as_slice())
        .context("failed to decode history message protobuf")
}

fn parse_embedded_json(raw: &str) -> Option<Value> {
    let trimmed = raw.trim();
    if trimmed.is_empty() {
        return None;
    }
    if let Ok(value) = serde_json::from_str::<Value>(trimmed) {
        return Some(value);
    }
    let decoded = decode_url_component(trimmed)?;
    serde_json::from_str::<Value>(decoded.as_ref()).ok()
}

fn decode_url_component(raw: &str) -> Option<String> {
    let mut output = String::with_capacity(raw.len());
    let bytes = raw.as_bytes();
    let mut index = 0;
    while index < bytes.len() {
        match bytes[index] {
            b'+' => {
                output.push(' ');
                index += 1;
            }
            b'%' if index + 2 < bytes.len() => {
                let hi = hex_value(bytes[index + 1])?;
                let lo = hex_value(bytes[index + 2])?;
                output.push((hi << 4 | lo) as char);
                index += 3;
            }
            value => {
                output.push(value as char);
                index += 1;
            }
        }
    }
    Some(output)
}

fn hex_value(byte: u8) -> Option<u8> {
    match byte {
        b'0'..=b'9' => Some(byte - b'0'),
        b'a'..=b'f' => Some(byte - b'a' + 10),
        b'A'..=b'F' => Some(byte - b'A' + 10),
        _ => None,
    }
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
    raw_message_count: usize,
    decoded_messages: &[DecodedHistoryMessage],
) -> Value {
    json!({
        "friend_id": friend_id,
        "friend_source": friend_source,
        "max_msg_id": max_msg_id,
        "raw_message_count": raw_message_count,
        "decoded_message_count": decoded_messages.len(),
        "first_message": decoded_messages.first().map(DecodedHistoryMessage::to_value).unwrap_or(Value::Null),
        "last_message": decoded_messages.last().map(DecodedHistoryMessage::to_value).unwrap_or(Value::Null),
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

fn extract_hot_job_recommend_cards(payload: &Value) -> Vec<Value> {
    payload
        .get("zpData")
        .and_then(|value| value.get("cardList"))
        .and_then(Value::as_array)
        .cloned()
        .unwrap_or_default()
}

fn summarize_hot_job_recommend_cards(cards: &[Value]) -> Value {
    let first = cards.first().cloned().unwrap_or_else(|| json!({}));
    json!({
        "job_count": cards.len(),
        "first_job": {
            "jobName": first.get("jobName").cloned().unwrap_or(Value::Null),
            "brandName": first.get("brandName").or_else(|| first.get("company")).cloned().unwrap_or(Value::Null),
            "salaryDesc": first.get("salaryDesc").cloned().unwrap_or(Value::Null),
            "securityId": first.get("securityId").cloned().unwrap_or(Value::Null),
            "encryptJobId": first.get("encryptJobId").or_else(|| first.get("encryptId")).cloned().unwrap_or(Value::Null),
        }
    })
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

fn summarize_history_probe(probe: &MessageHistoryProbe) -> Value {
    json!({
        "route": probe.result.route,
        "response_code": response_code(Some(probe.result.response_payload())),
        "attempt_count": probe.attempts.len(),
        "raw_message_count": probe.raw_messages.len(),
        "decoded_message_count": probe.decoded_messages.len(),
        "first_message": probe
            .decoded_messages
            .first()
            .map(DecodedHistoryMessage::to_value)
            .unwrap_or(Value::Null),
        "last_message": probe
            .decoded_messages
            .last()
            .map(DecodedHistoryMessage::to_value)
            .unwrap_or(Value::Null),
        "attempt_routes": probe
            .attempts
            .iter()
            .map(|attempt| {
                json!({
                    "route": attempt.route,
                    "host": attempt.host,
                    "response_code": response_code(Some(attempt.response_payload())),
                    "message_count": extract_message_list(attempt.response_payload()).len(),
                })
            })
            .collect::<Vec<_>>(),
    })
}

fn extract_friend_context(payload: &Value, target_friend_id: &str) -> Option<FriendContext> {
    let mut selected = None;
    for row in extract_friend_list(payload) {
        let Some(candidate) = friend_context_from_row(&row) else {
            continue;
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

fn friend_context_from_row(row: &Value) -> Option<FriendContext> {
    let friend_id = row.get("friendId").map(coerce_text).unwrap_or_default();
    if friend_id.is_empty() {
        return None;
    }
    Some(FriendContext {
        friend_id,
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
    })
}

fn extract_friend_name_from_row(row: &Value) -> String {
    for key in ["friendName", "name", "nickname", "title"] {
        if let Some(value) = row.get(key).map(coerce_text) {
            if !value.trim().is_empty() {
                return value;
            }
        }
    }
    String::new()
}

fn load_friend_rows(
    ctx: &BossContactContext,
    friend_ids: &[String],
    batch_size: usize,
) -> Result<(Vec<SignedGetResult>, Vec<Value>)> {
    let mut batches = Vec::new();
    let mut rows = Vec::new();
    let mut seen_friend_ids = BTreeSet::new();
    for chunk in friend_ids.chunks(batch_size.max(1)) {
        if chunk.is_empty() {
            continue;
        }
        let result = ctx.signed_get_contact_direct(
            FRIEND_BASE_INFO_PATH,
            BTreeMap::from([("friendIds".to_string(), chunk.join(","))]),
        )?;
        for row in extract_friend_list(result.response_payload()) {
            if let Some(friend_id) = row.get("friendId").map(coerce_text) {
                if seen_friend_ids.insert(friend_id) {
                    rows.push(row);
                }
            }
        }
        batches.push(result);
    }
    Ok((batches, rows))
}

fn history_message_key(message: &DecodedHistoryMessage) -> String {
    format!(
        "{}:{}:{}:{}:{}:{}:{}",
        message.mid,
        message.cmid,
        message.time_ms,
        message.from_uid,
        message.to_uid,
        message.message_type,
        message.text
    )
}

fn merge_decoded_histories(
    recent_history: Option<&MessageHistoryProbe>,
    sync_history: Option<&MessageHistoryProbe>,
) -> Vec<DecodedHistoryMessage> {
    let mut merged = Vec::new();
    let mut seen = BTreeSet::new();
    for probe in [recent_history, sync_history].into_iter().flatten() {
        for message in &probe.decoded_messages {
            let key = history_message_key(message);
            if seen.insert(key) {
                merged.push(message.clone());
            }
        }
    }
    merged.sort_by(|left, right| {
        left.time_ms
            .cmp(&right.time_ms)
            .then(left.mid.cmp(&right.mid))
            .then(left.cmid.cmp(&right.cmid))
    });
    merged
}

fn merge_decode_errors(
    recent_history: Option<&MessageHistoryProbe>,
    sync_history: Option<&MessageHistoryProbe>,
) -> Vec<Value> {
    let mut merged = Vec::new();
    if let Some(probe) = recent_history {
        merged.extend(probe.decode_errors.iter().map(|value| {
            json!({
                "source": "recent_history",
                "detail": value,
            })
        }));
    }
    if let Some(probe) = sync_history {
        merged.extend(probe.decode_errors.iter().map(|value| {
            json!({
                "source": "sync_history",
                "detail": value,
            })
        }));
    }
    merged
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

fn extract_friend_name(payload: &Value, target_friend_id: &str) -> Option<String> {
    for row in extract_friend_list(payload) {
        let friend_id = row.get("friendId").map(coerce_text).unwrap_or_default();
        if friend_id != target_friend_id {
            continue;
        }
        for key in ["friendName", "name", "nickname", "title"] {
            if let Some(value) = row.get(key).map(coerce_text) {
                if !value.trim().is_empty() {
                    return Some(value);
                }
            }
        }
    }
    None
}

fn infer_sender_name_from_history(
    ctx: &BossContactContext,
    friend_ctx: &FriendContext,
    sender_uid: i64,
    opts: &HashMap<String, String>,
) -> Result<Option<String>> {
    let params = BTreeMap::from([
        ("friendId".to_string(), friend_ctx.friend_id.clone()),
        ("count".to_string(), "20".to_string()),
        ("friendSource".to_string(), friend_ctx.friend_source.clone()),
        ("maxMsgId".to_string(), "0".to_string()),
    ]);
    let probe = ctx.fetch_message_history(&params, Some(friend_ctx.security_id.as_str()), opts)?;
    Ok(probe.decoded_messages.iter().rev().find_map(|message| {
        if message.from_uid == sender_uid && !message.from_name.trim().is_empty() {
            Some(message.from_name.clone())
        } else if message.to_uid == sender_uid && !message.to_name.trim().is_empty() {
            Some(message.to_name.clone())
        } else {
            None
        }
    }))
}

#[derive(Clone, PartialEq, prost::Message)]
struct TechwolfUserProto {
    #[prost(int64, tag = "1")]
    uid: i64,
    #[prost(string, tag = "2")]
    name: String,
    #[prost(int32, tag = "7")]
    source: i32,
}

#[derive(Clone, PartialEq, prost::Message)]
struct AtInfoProto {
    #[prost(int32, tag = "1")]
    flag: i32,
    #[prost(int64, repeated, tag = "2")]
    uids: Vec<i64>,
}

#[derive(Clone, PartialEq, prost::Message)]
struct TechwolfMessageBodyProto {
    #[prost(int32, tag = "1")]
    body_type: i32,
    #[prost(int32, tag = "2")]
    template_id: i32,
    #[prost(string, tag = "11")]
    head_title: String,
    #[prost(string, tag = "3")]
    text: String,
    #[prost(message, optional, tag = "20")]
    at_info: Option<AtInfoProto>,
    #[prost(message, optional, tag = "6")]
    action: Option<TechwolfActionProto>,
    #[prost(message, optional, tag = "9")]
    dialog: Option<TechwolfDialogProto>,
    #[prost(message, optional, tag = "15")]
    hyper_link: Option<TechwolfHyperLinkProto>,
    #[prost(string, tag = "28")]
    extend: String,
}

#[derive(Clone, PartialEq, prost::Message)]
struct TechwolfActionProto {
    #[prost(int32, tag = "1")]
    action_type: i32,
    #[prost(string, tag = "2")]
    extend: String,
}

#[derive(Clone, PartialEq, prost::Message)]
struct TechwolfDialogProto {
    #[prost(string, tag = "1")]
    text: String,
    #[prost(message, repeated, tag = "2")]
    buttons: Vec<TechwolfButtonProto>,
    #[prost(bool, tag = "3")]
    operated: bool,
    #[prost(bool, tag = "4")]
    click_more: bool,
    #[prost(int32, tag = "5")]
    dialog_type: i32,
    #[prost(string, tag = "6")]
    background_url: String,
    #[prost(int64, tag = "7")]
    timeout: i64,
    #[prost(string, tag = "8")]
    statistic_parameters: String,
    #[prost(string, tag = "9")]
    title: String,
    #[prost(string, tag = "10")]
    url: String,
    #[prost(int32, tag = "11")]
    selected_index: i32,
    #[prost(string, tag = "12")]
    extend: String,
    #[prost(string, tag = "13")]
    content: String,
}

#[derive(Clone, PartialEq, prost::Message)]
struct TechwolfButtonProto {
    #[prost(string, tag = "1")]
    text: String,
    #[prost(string, tag = "2")]
    url: String,
    #[prost(int32, tag = "3")]
    template_id: i32,
}

#[derive(Clone, PartialEq, prost::Message)]
struct TechwolfHyperLinkProto {
    #[prost(string, tag = "1")]
    text: String,
    #[prost(string, tag = "2")]
    url: String,
    #[prost(int32, tag = "3")]
    hyper_link_type: i32,
    #[prost(string, tag = "4")]
    extra_json: String,
}

#[derive(Clone, PartialEq, prost::Message)]
struct TechwolfMessageProto {
    #[prost(message, optional, tag = "1")]
    from: Option<TechwolfUserProto>,
    #[prost(message, optional, tag = "2")]
    to: Option<TechwolfUserProto>,
    #[prost(int32, tag = "3")]
    message_type: i32,
    #[prost(int64, tag = "4")]
    mid: i64,
    #[prost(int64, tag = "5")]
    time: i64,
    #[prost(message, optional, tag = "6")]
    body: Option<TechwolfMessageBodyProto>,
    #[prost(bool, tag = "7")]
    offline: bool,
    #[prost(string, tag = "9")]
    push_text: String,
    #[prost(int64, tag = "10")]
    task_id: i64,
    #[prost(int64, tag = "11")]
    cmid: i64,
    #[prost(int32, tag = "12")]
    status: i32,
    #[prost(int32, tag = "13")]
    uncount: i32,
    #[prost(string, tag = "17")]
    biz_id: String,
    #[prost(int32, tag = "18")]
    biz_type: i32,
    #[prost(string, tag = "19")]
    security_id: String,
    #[prost(int64, tag = "20")]
    quote_id: i64,
}

#[derive(Clone, PartialEq, prost::Message)]
struct TechwolfClientInfoProto {
    #[prost(string, tag = "1")]
    version: String,
    #[prost(string, tag = "2")]
    system: String,
    #[prost(string, tag = "4")]
    model: String,
    #[prost(string, tag = "5")]
    uniqid: String,
    #[prost(string, tag = "6")]
    network: String,
    #[prost(int32, tag = "7")]
    appid: i32,
    #[prost(string, tag = "8")]
    platform: String,
    #[prost(string, tag = "9")]
    channel: String,
    #[prost(double, tag = "12")]
    longitude: f64,
    #[prost(double, tag = "13")]
    latitude: f64,
}

#[derive(Clone, PartialEq, prost::Message)]
struct TechwolfPresenceProto {
    #[prost(int32, tag = "1")]
    presence_type: i32,
    #[prost(int32, tag = "2")]
    uid: i32,
    #[prost(message, optional, tag = "3")]
    client_info: Option<TechwolfClientInfoProto>,
    #[prost(int64, tag = "5")]
    last_message_id: i64,
    #[prost(int64, tag = "6")]
    last_group_message_id: i64,
    #[prost(int64, tag = "7")]
    user_id: i64,
}

#[derive(Clone, PartialEq, prost::Message)]
struct TechwolfChatProtocolProto {
    #[prost(int32, tag = "1")]
    protocol_type: i32,
    #[prost(string, tag = "2")]
    version: String,
    #[prost(message, repeated, tag = "3")]
    messages: Vec<TechwolfMessageProto>,
    #[prost(message, optional, tag = "4")]
    presence: Option<TechwolfPresenceProto>,
}

#[derive(Clone)]
struct DecodedHistoryMessage {
    envelope_index: usize,
    protocol_type: i32,
    protocol_version: String,
    message_type: i32,
    mid: i64,
    cmid: i64,
    time_ms: i64,
    status: i32,
    security_id: String,
    quote_id: i64,
    biz_id: String,
    biz_type: i32,
    body_type: i32,
    template_id: i32,
    text: String,
    head_title: String,
    extend: String,
    extend_json: Option<Value>,
    action: Option<DecodedAction>,
    dialog: Option<DecodedDialog>,
    hyper_link: Option<DecodedHyperLink>,
    from_uid: i64,
    from_name: String,
    from_source: i32,
    to_uid: i64,
    to_name: String,
    to_source: i32,
}

#[derive(Clone)]
struct DecodedAction {
    action_type: i32,
    extend: String,
    extend_json: Option<Value>,
}

impl DecodedAction {
    fn to_value(&self) -> Value {
        json!({
            "type": self.action_type,
            "extend": self.extend,
            "extend_json": self.extend_json.clone().unwrap_or(Value::Null),
        })
    }
}

#[derive(Clone)]
struct DecodedDialog {
    dialog_type: i32,
    title: String,
    text: String,
    content: String,
    url: String,
    background_url: String,
    timeout: i64,
    operated: bool,
    click_more: bool,
    selected_index: i32,
    statistic_parameters: String,
    statistic_parameters_json: Option<Value>,
    extend: String,
    extend_json: Option<Value>,
    buttons: Vec<DecodedDialogButton>,
}

impl DecodedDialog {
    fn to_value(&self) -> Value {
        json!({
            "type": self.dialog_type,
            "title": self.title,
            "text": self.text,
            "content": self.content,
            "url": self.url,
            "background_url": self.background_url,
            "timeout": self.timeout,
            "operated": self.operated,
            "click_more": self.click_more,
            "selected_index": self.selected_index,
            "statistic_parameters": self.statistic_parameters,
            "statistic_parameters_json": self.statistic_parameters_json.clone().unwrap_or(Value::Null),
            "extend": self.extend,
            "extend_json": self.extend_json.clone().unwrap_or(Value::Null),
            "buttons": self.buttons.iter().map(DecodedDialogButton::to_value).collect::<Vec<_>>(),
        })
    }
}

#[derive(Clone)]
struct DecodedDialogButton {
    text: String,
    url: String,
    template_id: i32,
}

impl DecodedDialogButton {
    fn to_value(&self) -> Value {
        json!({
            "text": self.text,
            "url": self.url,
            "template_id": self.template_id,
        })
    }
}

#[derive(Clone)]
struct DecodedHyperLink {
    text: String,
    url: String,
    hyper_link_type: i32,
    extra_json: String,
    extra_json_value: Option<Value>,
}

impl DecodedHyperLink {
    fn to_value(&self) -> Value {
        json!({
            "text": self.text,
            "url": self.url,
            "hyper_link_type": self.hyper_link_type,
            "extra_json": self.extra_json,
            "extra_json_value": self.extra_json_value.clone().unwrap_or(Value::Null),
        })
    }
}

impl DecodedHistoryMessage {
    fn from_proto(
        envelope_index: usize,
        protocol_type: i32,
        protocol_version: &str,
        message: TechwolfMessageProto,
    ) -> Self {
        let from = message.from.unwrap_or(TechwolfUserProto {
            uid: 0,
            name: String::new(),
            source: 0,
        });
        let to = message.to.unwrap_or(TechwolfUserProto {
            uid: 0,
            name: String::new(),
            source: 0,
        });
        let body = message.body.unwrap_or(TechwolfMessageBodyProto {
            body_type: 0,
            template_id: 0,
            head_title: String::new(),
            text: String::new(),
            at_info: None,
            action: None,
            dialog: None,
            hyper_link: None,
            extend: String::new(),
        });
        let extend_json = parse_embedded_json(&body.extend);
        let action = body.action.map(|action| DecodedAction {
            action_type: action.action_type,
            extend_json: parse_embedded_json(&action.extend),
            extend: action.extend,
        });
        let dialog = body.dialog.map(|dialog| DecodedDialog {
            dialog_type: dialog.dialog_type,
            title: dialog.title,
            text: dialog.text,
            content: dialog.content,
            url: dialog.url,
            background_url: dialog.background_url,
            timeout: dialog.timeout,
            operated: dialog.operated,
            click_more: dialog.click_more,
            selected_index: dialog.selected_index,
            statistic_parameters_json: parse_embedded_json(&dialog.statistic_parameters),
            statistic_parameters: dialog.statistic_parameters,
            extend_json: parse_embedded_json(&dialog.extend),
            extend: dialog.extend,
            buttons: dialog
                .buttons
                .into_iter()
                .map(|button| DecodedDialogButton {
                    text: button.text,
                    url: button.url,
                    template_id: button.template_id,
                })
                .collect(),
        });
        let hyper_link = body.hyper_link.map(|link| DecodedHyperLink {
            text: link.text,
            url: link.url,
            hyper_link_type: link.hyper_link_type,
            extra_json_value: parse_embedded_json(&link.extra_json),
            extra_json: link.extra_json,
        });
        Self {
            envelope_index,
            protocol_type,
            protocol_version: protocol_version.to_string(),
            message_type: message.message_type,
            mid: message.mid,
            cmid: message.cmid,
            time_ms: message.time,
            status: message.status,
            security_id: message.security_id,
            quote_id: message.quote_id,
            biz_id: message.biz_id,
            biz_type: message.biz_type,
            body_type: body.body_type,
            template_id: body.template_id,
            text: body.text,
            head_title: body.head_title,
            extend: body.extend,
            extend_json,
            action,
            dialog,
            hyper_link,
            from_uid: from.uid,
            from_name: from.name,
            from_source: from.source,
            to_uid: to.uid,
            to_name: to.name,
            to_source: to.source,
        }
    }

    fn matches_draft(&self, draft: &NativeTextMessageDraft) -> bool {
        if self.text != draft.text {
            return false;
        }
        if self.cmid == draft.client_temp_message_id || self.mid == draft.client_temp_message_id {
            return true;
        }
        let sender_match = self.from_uid == draft.sender_uid && self.to_uid == draft.friend_uid;
        let recent_enough = self.time_ms >= draft.timestamp_ms.saturating_sub(300_000);
        sender_match && recent_enough
    }

    fn to_value(&self) -> Value {
        json!({
            "envelope_index": self.envelope_index,
            "protocol_type": self.protocol_type,
            "protocol_version": self.protocol_version,
            "message_type": self.message_type,
            "mid": self.mid,
            "cmid": self.cmid,
            "time_ms": self.time_ms,
            "status": self.status,
            "security_id": self.security_id,
            "quote_id": self.quote_id,
            "biz_id": self.biz_id,
            "biz_type": self.biz_type,
            "body": {
                "type": self.body_type,
                "template_id": self.template_id,
                "text": self.text,
                "head_title": self.head_title,
                "extend": self.extend,
                "extend_json": self.extend_json.clone().unwrap_or(Value::Null),
                "action": self.action.as_ref().map(DecodedAction::to_value).unwrap_or(Value::Null),
                "dialog": self.dialog.as_ref().map(DecodedDialog::to_value).unwrap_or(Value::Null),
                "hyper_link": self
                    .hyper_link
                    .as_ref()
                    .map(DecodedHyperLink::to_value)
                    .unwrap_or(Value::Null),
            },
            "from": {
                "uid": self.from_uid,
                "name": self.from_name,
                "source": self.from_source,
            },
            "to": {
                "uid": self.to_uid,
                "name": self.to_name,
                "source": self.to_source,
            },
        })
    }
}

struct NativeTextMessageDraft {
    version: String,
    protocol_type: i32,
    client_temp_message_id: i64,
    timestamp_ms: i64,
    sender_uid: i64,
    sender_name: String,
    sender_source: i32,
    friend_uid: i64,
    friend_name: String,
    friend_source: i32,
    contact_security_id: String,
    text: String,
    extend: String,
    task_id: i64,
    quote_id: i64,
    biz_id: String,
    biz_type: i32,
}

fn push_varint(buf: &mut Vec<u8>, mut value: u64) {
    loop {
        if value < 0x80 {
            buf.push(value as u8);
            return;
        }
        buf.push((value as u8 & 0x7f) | 0x80);
        value >>= 7;
    }
}

fn push_key(buf: &mut Vec<u8>, field_number: u32, wire_type: u8) {
    push_varint(buf, ((field_number << 3) | u32::from(wire_type)) as u64);
}

fn push_i32_field(buf: &mut Vec<u8>, field_number: u32, value: i32) {
    push_key(buf, field_number, 0);
    push_varint(buf, value as u32 as u64);
}

fn push_i64_field(buf: &mut Vec<u8>, field_number: u32, value: i64) {
    push_key(buf, field_number, 0);
    push_varint(buf, value as u64);
}

fn push_bool_field(buf: &mut Vec<u8>, field_number: u32, value: bool) {
    push_key(buf, field_number, 0);
    push_varint(buf, u64::from(value));
}

fn push_string_field(buf: &mut Vec<u8>, field_number: u32, value: &str) {
    push_key(buf, field_number, 2);
    push_varint(buf, value.len() as u64);
    buf.extend_from_slice(value.as_bytes());
}

fn push_message_field(buf: &mut Vec<u8>, field_number: u32, nested: &[u8]) {
    push_key(buf, field_number, 2);
    push_varint(buf, nested.len() as u64);
    buf.extend_from_slice(nested);
}

fn encode_text_message_body_bytes(text: &str, extend: &str) -> Vec<u8> {
    let mut body = Vec::new();
    push_i32_field(&mut body, 1, CHAT_MESSAGE_TYPE_TEXT);
    push_i32_field(&mut body, 2, CHAT_MESSAGE_TEMPLATE_TEXT);
    push_string_field(&mut body, 3, text);
    if !extend.is_empty() {
        push_string_field(&mut body, 28, extend);
    }
    body
}

fn encode_user_bytes(uid: i64, name: &str, source: i32) -> Vec<u8> {
    let mut user = Vec::new();
    push_i64_field(&mut user, 1, uid);
    push_string_field(&mut user, 2, name);
    push_i32_field(&mut user, 7, source);
    user
}

fn encode_text_message_bytes(draft: &NativeTextMessageDraft) -> Vec<u8> {
    let mut message = Vec::new();
    let from = encode_user_bytes(draft.sender_uid, &draft.sender_name, draft.sender_source);
    let to = encode_user_bytes(draft.friend_uid, &draft.friend_name, draft.friend_source);
    let body = encode_text_message_body_bytes(&draft.text, &draft.extend);

    push_message_field(&mut message, 1, &from);
    push_message_field(&mut message, 2, &to);
    push_i32_field(&mut message, 3, 1);
    push_i64_field(&mut message, 4, draft.client_temp_message_id);
    push_i64_field(&mut message, 5, draft.timestamp_ms);
    push_message_field(&mut message, 6, &body);
    push_bool_field(&mut message, 7, false);
    push_string_field(&mut message, 9, "");
    push_i64_field(&mut message, 10, draft.task_id);
    push_i64_field(&mut message, 11, draft.client_temp_message_id);
    push_i32_field(&mut message, 12, 2);
    push_i32_field(&mut message, 13, 0);
    if !draft.biz_id.is_empty() {
        push_string_field(&mut message, 17, &draft.biz_id);
    }
    push_i32_field(&mut message, 18, draft.biz_type);
    push_i64_field(&mut message, 20, draft.quote_id);
    message
}

fn encode_text_protocol_bytes(draft: &NativeTextMessageDraft) -> Vec<u8> {
    let mut protocol = Vec::new();
    let message = encode_text_message_bytes(draft);
    push_i32_field(&mut protocol, 1, draft.protocol_type);
    push_string_field(&mut protocol, 2, &draft.version);
    push_message_field(&mut protocol, 3, &message);
    protocol
}

impl NativeTextMessageDraft {
    fn from_context(
        session: &SessionConfig,
        friend_ctx: &FriendContext,
        friend_name: &str,
        sender_name: &str,
        text: String,
        extend: String,
    ) -> Result<Self> {
        let sender_uid = parse_i64_field(&session.uid, "session.uid")?;
        let friend_uid = parse_i64_field(&friend_ctx.friend_id, "friendId")?;
        let friend_source = friend_ctx.friend_source.trim().parse::<i32>().unwrap_or(0);
        Ok(Self {
            version: CHAT_PAYLOAD_PROTOCOL_VERSION.to_string(),
            protocol_type: 1,
            client_temp_message_id: next_client_temp_message_id(),
            timestamp_ms: now_ms() as i64,
            sender_uid,
            sender_name: sender_name.to_string(),
            sender_source: 0,
            friend_uid,
            friend_name: friend_name.to_string(),
            friend_source,
            contact_security_id: friend_ctx.security_id.clone(),
            text,
            extend,
            task_id: 0,
            quote_id: 0,
            biz_id: String::new(),
            biz_type: 0,
        })
    }

    fn encode(&self) -> Result<EncodedNativeTextMessage> {
        let protocol = TechwolfChatProtocolProto {
            protocol_type: self.protocol_type,
            version: self.version.clone(),
            messages: vec![TechwolfMessageProto {
                from: Some(TechwolfUserProto {
                    uid: self.sender_uid,
                    name: self.sender_name.clone(),
                    source: self.sender_source,
                }),
                to: Some(TechwolfUserProto {
                    uid: self.friend_uid,
                    name: self.friend_name.clone(),
                    source: self.friend_source,
                }),
                message_type: 1,
                mid: self.client_temp_message_id,
                time: self.timestamp_ms,
                body: Some(TechwolfMessageBodyProto {
                    body_type: CHAT_MESSAGE_TYPE_TEXT,
                    template_id: CHAT_MESSAGE_TEMPLATE_TEXT,
                    head_title: String::new(),
                    text: self.text.clone(),
                    at_info: None,
                    action: None,
                    dialog: None,
                    hyper_link: None,
                    extend: self.extend.clone(),
                }),
                offline: false,
                push_text: String::new(),
                task_id: self.task_id,
                cmid: self.client_temp_message_id,
                status: 2,
                uncount: 0,
                biz_id: self.biz_id.clone(),
                biz_type: self.biz_type,
                security_id: self.contact_security_id.clone(),
                quote_id: self.quote_id,
            }],
            presence: None,
        };

        let payload = encode_text_protocol_bytes(self);
        let mms_message = MockMmsMessage {
            sequence_id: next_mms_sequence_id(),
            send_flag: MMS_FLAG_EXPECT_ACK,
            expect_ack: true,
            payload_len: payload.len(),
            payload_hex: hex::encode(&payload),
            payload_base64: base64::engine::general_purpose::STANDARD.encode(&payload),
        };

        Ok(EncodedNativeTextMessage {
            protocol,
            payload,
            mms_message,
        })
    }

    fn to_value(&self) -> Value {
        json!({
            "version": self.version,
            "protocol_type": self.protocol_type,
            "client_temp_message_id": self.client_temp_message_id,
            "timestamp_ms": self.timestamp_ms,
            "sender": {
                "uid": self.sender_uid,
                "name": self.sender_name,
                "source": self.sender_source,
            },
            "recipient": {
                "uid": self.friend_uid,
                "name": self.friend_name,
                "source": self.friend_source,
                "contact_security_id": self.contact_security_id,
            },
            "body": {
                "type": CHAT_MESSAGE_TYPE_TEXT,
                "template_id": CHAT_MESSAGE_TEMPLATE_TEXT,
                "text": self.text,
                "extend": self.extend,
                "task_id": self.task_id,
                "quote_id": self.quote_id,
                "biz_id": self.biz_id,
                "biz_type": self.biz_type,
            },
        })
    }
}

fn build_presence_payload(
    session: &SessionConfig,
    last_message_id: i64,
) -> Result<(String, Value)> {
    let user_id = parse_i64_field(&session.uid, "session.uid")?;
    let protocol = TechwolfChatProtocolProto {
        protocol_type: 2,
        version: CHAT_KERNEL_PROTOCOL_VERSION.to_string(),
        messages: Vec::new(),
        presence: Some(TechwolfPresenceProto {
            presence_type: CHAT_PRESENCE_ONLINE | CHAT_PRESENCE_PULL,
            uid: user_id as i32,
            client_info: Some(TechwolfClientInfoProto {
                longitude: 0.0,
                latitude: 0.0,
                ..TechwolfClientInfoProto::default()
            }),
            last_message_id,
            last_group_message_id: 0,
            user_id,
        }),
    };
    let payload = protocol.encode_to_vec();
    let payload_base64 = base64::engine::general_purpose::STANDARD.encode(&payload);
    Ok((
        payload_base64,
        json!({
            "protocol_type": 2,
            "version": CHAT_KERNEL_PROTOCOL_VERSION,
            "presence_type": CHAT_PRESENCE_ONLINE | CHAT_PRESENCE_PULL,
            "user_id": user_id,
            "last_message_id": last_message_id,
            "contract_alignment": "MessageProtocolUtils.createPresence(type, lastIds)",
            "payload_len": payload.len(),
        }),
    ))
}

struct EncodedNativeTextMessage {
    protocol: TechwolfChatProtocolProto,
    payload: Vec<u8>,
    mms_message: MockMmsMessage,
}

impl EncodedNativeTextMessage {
    fn to_value(&self) -> Value {
        json!({
            "protocol": {
                "type": self.protocol.protocol_type,
                "version": self.protocol.version,
                "message_count": self.protocol.messages.len(),
            },
            "payload_len": self.payload.len(),
            "mms_message": self.mms_message.to_value(),
        })
    }
}

struct MockMmsMessage {
    sequence_id: u16,
    send_flag: u8,
    expect_ack: bool,
    payload_len: usize,
    payload_hex: String,
    payload_base64: String,
}

impl MockMmsMessage {
    fn to_value(&self) -> Value {
        json!({
            "sequence_id": self.sequence_id,
            "send_flag": self.send_flag,
            "expect_ack": self.expect_ack,
            "payload_len": self.payload_len,
            "payload_hex": self.payload_hex,
            "payload_base64": self.payload_base64,
        })
    }
}

struct Jf0Dispatch {
    ok: bool,
    mode: String,
    accepted: bool,
    server_mid: i64,
    receipt: Value,
}

struct BusinessSendConfirmation {
    confirmed: bool,
    confirm_source: String,
    elapsed_ms: u128,
    poll_count: usize,
    matched_message: Option<DecodedHistoryMessage>,
    matched_server_mid: Option<i64>,
    push_signal: Value,
    polls: Vec<Value>,
}

impl BusinessSendConfirmation {
    fn to_value(&self) -> Value {
        json!({
            "confirmed": self.confirmed,
            "confirm_source": self.confirm_source,
            "elapsed_ms": self.elapsed_ms,
            "poll_count": self.poll_count,
            "matched_message": self.matched_message.as_ref().map(DecodedHistoryMessage::to_value).unwrap_or(Value::Null),
            "matched_server_mid": self.matched_server_mid,
            "push_signal": self.push_signal,
            "polls": self.polls,
        })
    }
}

fn selected_payload_builder(dispatch: &Jf0Dispatch) -> Option<&str> {
    dispatch
        .receipt
        .get("mqtt")
        .and_then(|mqtt| mqtt.get("payload_builder"))
        .and_then(|builder| builder.get("selected_builder"))
        .and_then(Value::as_str)
}

fn next_payload_builder_retry_mode(
    dispatch: &Jf0Dispatch,
    confirmation: Option<&BusinessSendConfirmation>,
) -> Option<&'static str> {
    if dispatch.mode != "mqtt" || !dispatch.ok {
        return None;
    }
    if confirmation.map(|value| value.confirmed).unwrap_or(false) {
        return None;
    }
    match selected_payload_builder(dispatch) {
        Some("apk_serializer") | Some("apk_chat_bean_factory") => {
            Some(PAYLOAD_BUILDER_MODE_PATCHED)
        }
        Some("apk_serializer_with_security_id") => Some(PAYLOAD_BUILDER_MODE_MANUAL),
        Some("manual_builder") => None,
        _ => Some(PAYLOAD_BUILDER_MODE_PATCHED),
    }
}

fn value_as_i64(value: &Value) -> Option<i64> {
    value
        .as_i64()
        .or_else(|| value.as_u64().map(|number| number as i64))
}

fn proactive_send_succeeded(value: &Value) -> bool {
    value
        .get("triggered")
        .and_then(Value::as_bool)
        .unwrap_or(false)
        && response_code(
            value
                .get("result")
                .and_then(|result| result.get("response")),
        ) == Some(0)
}

fn extract_mqtt_message_sync_server_mid(
    mqtt_payload: Option<&Value>,
    draft: &NativeTextMessageDraft,
) -> Option<i64> {
    let events = mqtt_payload?.get("inbound_events")?.as_array()?;
    for event in events {
        let sync_entries = event.get("message_sync")?.as_array()?;
        for entry in sync_entries {
            let client_mid = entry.get("client_mid").and_then(value_as_i64)?;
            if client_mid == draft.client_temp_message_id {
                if let Some(server_mid) = entry.get("server_mid").and_then(value_as_i64) {
                    return Some(server_mid);
                }
            }
        }
    }
    None
}

fn extract_mqtt_pull_hint(mqtt_payload: Option<&Value>) -> Option<(String, i64, Value)> {
    let events = mqtt_payload?.get("inbound_events")?.as_array()?;
    for event in events {
        let query = event
            .get("iq_query")
            .and_then(Value::as_str)
            .unwrap_or_default();
        if query != "/message/pull" {
            continue;
        }
        let results = event.get("iq_results").and_then(Value::as_array)?;
        let mut secret_id = String::new();
        let mut last_id = 0_i64;
        for entry in results {
            let key = entry.get("key").and_then(Value::as_str).unwrap_or_default();
            let value = entry
                .get("value")
                .and_then(Value::as_str)
                .unwrap_or_default()
                .trim()
                .to_string();
            match key {
                "secretId" if !value.is_empty() => secret_id = value,
                "lastId" => {
                    last_id = value.parse::<i64>().unwrap_or(0);
                }
                _ => {}
            }
        }
        if !secret_id.is_empty() && last_id > 0 {
            return Some((secret_id, last_id, event.clone()));
        }
    }
    None
}

impl Jf0Dispatch {
    fn run(
        ctx: &BossContactContext,
        draft: &NativeTextMessageDraft,
        encoded: &EncodedNativeTextMessage,
        mode: &str,
        presence_last_message_id: i64,
        requested_server_mid: Option<i64>,
        payload_builder_mode: &str,
    ) -> Result<Self> {
        let trimmed_mode = mode.trim();
        match trimmed_mode {
            "mock" | "dump" => Self::run_mock(draft, encoded, trimmed_mode, requested_server_mid),
            "mqtt" | "real" => Self::run_mqtt(
                ctx,
                draft,
                encoded,
                presence_last_message_id,
                payload_builder_mode,
            ),
            _ => Err(anyhow!(
                "unsupported --send-runtime {trimmed_mode}; supported: mock, dump, mqtt"
            )),
        }
    }

    fn run_mock(
        draft: &NativeTextMessageDraft,
        encoded: &EncodedNativeTextMessage,
        mode: &str,
        requested_server_mid: Option<i64>,
    ) -> Result<Self> {
        let server_mid = requested_server_mid
            .unwrap_or_else(|| draft.client_temp_message_id.saturating_add(1_000_000_000));
        let accepted = mode == "mock";
        Ok(Self {
            ok: true,
            mode: mode.to_string(),
            accepted,
            server_mid,
            receipt: json!({
                "transport": "jf0.i(byte[], h, expectAck)",
                "mocked": true,
                "client_temp_message_id": draft.client_temp_message_id,
                "server_mid": server_mid,
                "expect_ack": encoded.mms_message.expect_ack,
                "ack_status": if accepted { "success" } else { "skipped" },
            }),
        })
    }

    fn run_mqtt(
        ctx: &BossContactContext,
        draft: &NativeTextMessageDraft,
        encoded: &EncodedNativeTextMessage,
        presence_last_message_id: i64,
        payload_builder_mode: &str,
    ) -> Result<Self> {
        let runner = BossApkMqttDispatch::new(&ctx.lab_config)?;
        let payload = runner.dispatch(
            &ctx.session,
            draft,
            &encoded.mms_message,
            presence_last_message_id,
            payload_builder_mode,
        )?;
        let ok = payload.get("ok") == Some(&Value::Bool(true));
        let server_mid = payload
            .get("ack_mid")
            .and_then(Value::as_i64)
            .or_else(|| {
                payload
                    .get("ack_mid")
                    .and_then(Value::as_u64)
                    .map(|value| value as i64)
            })
            .unwrap_or(draft.client_temp_message_id);
        let receipt = json!({
            "transport": "jf0.i(byte[], h, expectAck)",
            "mocked": false,
            "client_temp_message_id": draft.client_temp_message_id,
            "server_mid": server_mid,
            "expect_ack": encoded.mms_message.expect_ack,
            "ack_status": if ok { "success" } else { "failed" },
            "mqtt": payload,
        });
        Ok(Self {
            ok,
            mode: "mqtt".to_string(),
            accepted: ok,
            server_mid,
            receipt,
        })
    }

    fn to_value(&self) -> Value {
        json!({
            "ok": self.ok,
            "mode": self.mode,
            "accepted": self.accepted,
            "server_mid": self.server_mid,
            "receipt": self.receipt,
        })
    }
}

struct BossApkMqttDispatch {
    apk_path: PathBuf,
    script_path: PathBuf,
    payload_script_path: PathBuf,
}

impl BossApkMqttDispatch {
    fn new(lab_config: &LabConfig) -> Result<Self> {
        let script_path =
            PathBuf::from(env!("CARGO_MANIFEST_DIR")).join("scripts/run-boss-apk-mqtt.sh");
        let payload_script_path =
            PathBuf::from(env!("CARGO_MANIFEST_DIR")).join("scripts/run-boss-apk-chat-payload.sh");
        if !script_path.is_file() {
            return Err(anyhow!(
                "boss apk mqtt runner script not found: {}",
                script_path.display()
            ));
        }
        if !payload_script_path.is_file() {
            return Err(anyhow!(
                "boss apk chat payload runner script not found: {}",
                payload_script_path.display()
            ));
        }
        if !lab_config.apk_path.is_file() {
            return Err(anyhow!(
                "boss apk for mqtt extraction not found: {}",
                lab_config.apk_path.display()
            ));
        }
        Ok(Self {
            apk_path: lab_config.apk_path.clone(),
            script_path,
            payload_script_path,
        })
    }

    fn dispatch(
        &self,
        session: &SessionConfig,
        draft: &NativeTextMessageDraft,
        mms_message: &MockMmsMessage,
        presence_last_message_id: i64,
        payload_builder_mode: &str,
    ) -> Result<Value> {
        let normalized_builder_mode = normalize_payload_builder_mode(Some(payload_builder_mode));
        let (payload_base64, payload_builder) = self.build_payload(
            session,
            draft,
            &mms_message.payload_base64,
            normalized_builder_mode,
        )?;
        let (presence_payload_base64, presence_builder) =
            build_presence_payload(session, presence_last_message_id)?;
        let role = session_role(session);
        let username = session_mqtt_username(session);
        let mut command = Command::new(&self.script_path);
        command
            .arg("--apk")
            .arg(&self.apk_path)
            .arg("--payload-base64")
            .arg(&payload_base64)
            .arg("--uid")
            .arg(session.uid.trim())
            .arg("--role")
            .arg(&role)
            .arg("--secret-key")
            .arg(session.secret_key.trim())
            .arg("--username")
            .arg(&username)
            .arg("--qos")
            .arg("1")
            .arg("--wait-after-presence-ms")
            .arg("3000")
            .arg("--wait-after-publish-ms")
            .arg("16000")
            .arg("--pre-publish-base64")
            .arg(&presence_payload_base64)
            .arg("--sequence-id")
            .arg(mms_message.sequence_id.to_string());
        let client_seed = session_mqtt_client_seed(session);
        if !client_seed.is_empty() {
            command.arg("--client-seed").arg(&client_seed);
        }

        let output = run_command_with_timeout(
            &mut command,
            Duration::from_secs(BOSS_APK_MQTT_TIMEOUT_SECONDS),
        )
        .with_context(|| {
            format!(
                "failed to execute boss apk mqtt runner: {}",
                self.script_path.display()
            )
        })?;
        if !output.status.success() {
            let stderr = String::from_utf8_lossy(&output.stderr).to_string();
            let stdout = String::from_utf8_lossy(&output.stdout).to_string();
            return Ok(json!({
                "ok": false,
                "engine": "boss_apk_mqtt",
                "error": format!(
                    "runner exited with status {:?}, stderr={}, stdout={}",
                    output.status.code(),
                    truncate_output(&stderr, 1200),
                    truncate_output(&stdout, 1200)
                ),
            }));
        }

        let mut payload: Value = serde_json::from_slice(&output.stdout)
            .context("failed to parse boss apk mqtt runner output")?;
        if let Some(object) = payload.as_object_mut() {
            object.insert(
                "requested_payload_builder_mode".to_string(),
                Value::String(normalized_builder_mode.to_string()),
            );
            object.insert("payload_builder".to_string(), payload_builder);
            object.insert("presence_builder".to_string(), presence_builder);
        }
        Ok(payload)
    }

    fn build_payload(
        &self,
        session: &SessionConfig,
        draft: &NativeTextMessageDraft,
        fallback_payload_base64: &str,
        payload_builder_mode: &str,
    ) -> Result<(String, Value)> {
        let mut command = Command::new(&self.payload_script_path);
        command
            .arg("--apk")
            .arg(&self.apk_path)
            .arg("--sender-uid")
            .arg(draft.sender_uid.to_string())
            .arg("--sender-name")
            .arg(&draft.sender_name)
            .arg("--friend-uid")
            .arg(draft.friend_uid.to_string())
            .arg("--friend-name")
            .arg(&draft.friend_name)
            .arg("--friend-source")
            .arg(draft.friend_source.to_string())
            .arg("--security-id")
            .arg(&draft.contact_security_id)
            .arg("--serializer-mode")
            .arg(normalize_payload_builder_mode(Some(payload_builder_mode)))
            .arg("--text")
            .arg(&draft.text)
            .arg("--cmid")
            .arg(draft.client_temp_message_id.to_string())
            .arg("--timestamp-ms")
            .arg(draft.timestamp_ms.to_string());
        if !draft.extend.trim().is_empty() {
            command.arg("--extend").arg(&draft.extend);
        }
        if draft.task_id > 0 {
            command.arg("--task-id").arg(draft.task_id.to_string());
        }
        if draft.quote_id > 0 {
            command.arg("--quote-id").arg(draft.quote_id.to_string());
        }
        if draft.biz_type != 0 {
            command.arg("--biz-type").arg(draft.biz_type.to_string());
        }
        if !draft.biz_id.trim().is_empty() {
            command.arg("--biz-id").arg(&draft.biz_id);
        }
        let output =
            run_command_with_timeout(&mut command, Duration::from_secs(15)).with_context(|| {
                format!(
                    "failed to execute boss apk chat payload runner: {}",
                    self.payload_script_path.display()
                )
            })?;
        if !output.status.success() {
            let stderr = String::from_utf8_lossy(&output.stderr).to_string();
            let stdout = String::from_utf8_lossy(&output.stdout).to_string();
            return Ok((
                fallback_payload_base64.to_string(),
                json!({
                    "ok": false,
                    "engine": "boss_apk_chat_payload",
                    "fallback": "rust_encoded_payload",
                    "error": format!(
                        "payload runner exited with status {:?}, stderr={}, stdout={}",
                        output.status.code(),
                        truncate_output(&stderr, 1200),
                        truncate_output(&stdout, 1200)
                    ),
                    "sender_uid": session.uid.trim(),
                    "requested_payload_builder_mode": payload_builder_mode,
                }),
            ));
        }
        let payload: Value = serde_json::from_slice(&output.stdout)
            .context("failed to parse boss apk chat payload output")?;
        let payload_base64 = payload
            .get("payload_base64")
            .and_then(Value::as_str)
            .filter(|value| !value.trim().is_empty())
            .unwrap_or(fallback_payload_base64)
            .to_string();
        let builder_value = if payload.get("ok") == Some(&Value::Bool(true)) {
            payload
        } else {
            json!({
                "ok": false,
                "engine": "boss_apk_chat_payload",
                "fallback": "rust_encoded_payload",
                "requested_payload_builder_mode": payload_builder_mode,
                "runner_output": payload,
            })
        };
        Ok((payload_base64, builder_value))
    }
}

fn normalize_payload_builder_mode(mode: Option<&str>) -> &str {
    match mode.unwrap_or_default().trim() {
        PAYLOAD_BUILDER_MODE_PATCHED => PAYLOAD_BUILDER_MODE_PATCHED,
        PAYLOAD_BUILDER_MODE_MANUAL => PAYLOAD_BUILDER_MODE_MANUAL,
        _ => PAYLOAD_BUILDER_MODE_SERIALIZER,
    }
}

fn parse_i64_field(value: &str, field: &str) -> Result<i64> {
    value
        .trim()
        .parse::<i64>()
        .with_context(|| format!("invalid numeric {field}: {value}"))
}

fn next_client_temp_message_id() -> i64 {
    now_ms() as i64
}

fn next_mms_sequence_id() -> u16 {
    let value = NEXT_MMS_MESSAGE_ID.fetch_add(1, Ordering::Relaxed);
    let bounded = ((value - 1) % (i16::MAX as u32 - 1)) + 1;
    bounded as u16
}

fn session_role(session: &SessionConfig) -> String {
    let role = session.identity.trim();
    if role.is_empty() {
        "0".to_string()
    } else {
        role.to_string()
    }
}

fn session_mqtt_client_seed(session: &SessionConfig) -> String {
    let uniqid = session.fp_uniqid.trim();
    if !uniqid.is_empty() {
        uniqid.to_string()
    } else {
        session_mqtt_username(session)
    }
}

fn session_mqtt_username(session: &SessionConfig) -> String {
    let uid = session.uid.trim();
    if uid.is_empty() {
        String::new()
    } else {
        format!(
            "{uid}-{}-{CHAT_PAYLOAD_PROTOCOL_VERSION}-14.030",
            session_role(session)
        )
    }
}

fn truncate_output(value: &str, limit: usize) -> String {
    let text = value.trim();
    if text.chars().count() <= limit {
        return text.to_string();
    }
    let mut truncated = String::new();
    for (index, ch) in text.chars().enumerate() {
        if index >= limit {
            break;
        }
        truncated.push(ch);
    }
    truncated.push_str("...");
    truncated
}

fn confirm_sent_message_in_history(
    ctx: &BossContactContext,
    friend_ctx: &FriendContext,
    draft: &NativeTextMessageDraft,
    mqtt_payload: Option<&Value>,
    opts: &HashMap<String, String>,
) -> Result<BusinessSendConfirmation> {
    let timeout_seconds = opts
        .get("--confirm-timeout-seconds")
        .and_then(|value| value.parse::<u64>().ok())
        .filter(|value| *value > 0)
        .unwrap_or(12);
    let poll_interval_ms = opts
        .get("--confirm-poll-ms")
        .and_then(|value| value.parse::<u64>().ok())
        .filter(|value| *value >= 250)
        .unwrap_or(1500);
    let started = std::time::Instant::now();
    let deadline = started + Duration::from_secs(timeout_seconds);
    let params = BTreeMap::from([
        ("friendId".to_string(), friend_ctx.friend_id.clone()),
        ("count".to_string(), "20".to_string()),
        ("friendSource".to_string(), friend_ctx.friend_source.clone()),
        ("maxMsgId".to_string(), "0".to_string()),
    ]);
    let mut polls = Vec::new();
    let matched_server_mid = extract_mqtt_message_sync_server_mid(mqtt_payload, draft);
    let pull_hint = extract_mqtt_pull_hint(mqtt_payload);
    let push_signal = json!({
        "matched_server_mid": matched_server_mid,
        "pull_hint": pull_hint
            .as_ref()
            .map(|(secret_id, last_id, event)| {
                json!({
                    "secret_id": secret_id,
                    "last_id": last_id,
                    "event": event,
                })
            })
            .unwrap_or(Value::Null),
    });

    polls.push(json!({
        "elapsed_ms": started.elapsed().as_millis(),
        "stage": "mqtt_push_signal",
        "matched_server_mid": matched_server_mid,
        "pull_hint": pull_hint
            .as_ref()
            .map(|(secret_id, last_id, _)| {
                json!({
                    "secret_id": secret_id,
                    "last_id": last_id,
                })
            })
            .unwrap_or(Value::Null),
    }));

    if let Some((secret_id, last_id, _)) = pull_hint.as_ref() {
        let probe = ctx.fetch_message_sync_history_with_cursor(secret_id, *last_id, opts)?;
        let matched = probe
            .decoded_messages
            .iter()
            .find(|message| message.matches_draft(draft))
            .cloned();
        polls.push(json!({
            "elapsed_ms": started.elapsed().as_millis(),
            "stage": "mqtt_pull_hint_history",
            "route": probe.result.route,
            "response_code": response_code(Some(probe.result.response_payload())),
            "raw_message_count": probe.raw_messages.len(),
            "decoded_message_count": probe.decoded_messages.len(),
            "matched": matched.is_some(),
            "latest_message": probe.decoded_messages.last().map(DecodedHistoryMessage::to_value).unwrap_or(Value::Null),
            "decode_errors": probe.decode_errors,
        }));
        if let Some(message) = matched {
            let elapsed_ms = started.elapsed().as_millis();
            let poll_count = polls.len();
            return Ok(BusinessSendConfirmation {
                confirmed: true,
                confirm_source: "mqtt_pull_hint_history".to_string(),
                elapsed_ms,
                poll_count,
                matched_message: Some(message),
                matched_server_mid,
                push_signal,
                polls,
            });
        }
    }

    loop {
        let probe =
            ctx.fetch_message_history(&params, Some(friend_ctx.security_id.as_str()), opts)?;
        let matched = probe
            .decoded_messages
            .iter()
            .find(|message| message.matches_draft(draft))
            .cloned();
        polls.push(json!({
            "elapsed_ms": started.elapsed().as_millis(),
            "route": probe.result.route,
            "response_code": response_code(Some(probe.result.response_payload())),
            "raw_message_count": probe.raw_messages.len(),
            "decoded_message_count": probe.decoded_messages.len(),
            "matched": matched.is_some(),
            "latest_message": probe.decoded_messages.last().map(DecodedHistoryMessage::to_value).unwrap_or(Value::Null),
            "decode_errors": probe.decode_errors,
        }));
        if let Some(message) = matched {
            let elapsed_ms = started.elapsed().as_millis();
            let poll_count = polls.len();
            return Ok(BusinessSendConfirmation {
                confirmed: true,
                confirm_source: "history_poll".to_string(),
                elapsed_ms,
                poll_count,
                matched_message: Some(message),
                matched_server_mid,
                push_signal,
                polls,
            });
        }
        if std::time::Instant::now() >= deadline {
            let elapsed_ms = started.elapsed().as_millis();
            let poll_count = polls.len();
            return Ok(BusinessSendConfirmation {
                confirmed: matched_server_mid.is_some(),
                confirm_source: if matched_server_mid.is_some() {
                    "mqtt_message_sync".to_string()
                } else {
                    "none".to_string()
                },
                elapsed_ms,
                poll_count,
                matched_message: None,
                matched_server_mid,
                push_signal,
                polls,
            });
        }
        sleep(Duration::from_millis(poll_interval_ms));
    }
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
                truncate_output(&stderr, 1200),
                truncate_output(&stdout, 1200),
            ));
        }
        std::thread::sleep(Duration::from_millis(100));
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    fn read_varint(buf: &[u8], index: &mut usize) -> u64 {
        let mut shift = 0;
        let mut value = 0_u64;
        loop {
            let byte = buf[*index];
            *index += 1;
            value |= u64::from(byte & 0x7f) << shift;
            if byte & 0x80 == 0 {
                return value;
            }
            shift += 7;
        }
    }

    fn decode_field_numbers(buf: &[u8]) -> Vec<u32> {
        let mut index = 0_usize;
        let mut fields = Vec::new();
        while index < buf.len() {
            let key = read_varint(buf, &mut index);
            let field = (key >> 3) as u32;
            let wire = (key & 0x7) as u8;
            fields.push(field);
            match wire {
                0 => {
                    let _ = read_varint(buf, &mut index);
                }
                2 => {
                    let len = read_varint(buf, &mut index) as usize;
                    index += len;
                }
                other => panic!("unsupported wire type in test parser: {other}"),
            }
        }
        fields
    }

    fn decode_nested_message_field(buf: &[u8], target_field: u32) -> Vec<u8> {
        let mut index = 0_usize;
        while index < buf.len() {
            let key = read_varint(buf, &mut index);
            let field = (key >> 3) as u32;
            let wire = (key & 0x7) as u8;
            match wire {
                0 => {
                    let _ = read_varint(buf, &mut index);
                }
                2 => {
                    let len = read_varint(buf, &mut index) as usize;
                    let value = buf[index..index + len].to_vec();
                    index += len;
                    if field == target_field {
                        return value;
                    }
                }
                other => panic!("unsupported wire type in test parser: {other}"),
            }
        }
        panic!("field {target_field} not found");
    }

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

    #[test]
    fn native_text_message_encodes_expected_proto_fields() {
        let session = SessionConfig {
            uid: "722593826".to_string(),
            phone: "15380455973".to_string(),
            ..SessionConfig::default()
        };
        let friend_ctx = FriendContext {
            friend_id: "698704560".to_string(),
            friend_source: "4".to_string(),
            job_source: "0".to_string(),
            security_id: "sec-123".to_string(),
            friend_type: None,
            fridend_stage: None,
            datetime_ms: None,
            water_level: None,
        };
        let draft = NativeTextMessageDraft::from_context(
            &session,
            &friend_ctx,
            "Boss",
            "Tester",
            "你好".to_string(),
            String::new(),
        )
        .expect("draft");
        let encoded = draft.encode().expect("encode");
        let decoded =
            TechwolfChatProtocolProto::decode(encoded.payload.as_slice()).expect("decode");
        let root_fields = decode_field_numbers(&encoded.payload);
        let message_bytes = decode_nested_message_field(&encoded.payload, 3);
        let message_fields = decode_field_numbers(&message_bytes);
        let from_fields = decode_field_numbers(&decode_nested_message_field(&message_bytes, 1));
        let to_fields = decode_field_numbers(&decode_nested_message_field(&message_bytes, 2));

        assert_eq!(decoded.protocol_type, 1);
        assert_eq!(decoded.version, "1.4");
        let message = decoded.messages.first().expect("message");
        assert_eq!(message.message_type, 1);
        assert_eq!(message.mid, draft.client_temp_message_id);
        assert_eq!(message.cmid, draft.client_temp_message_id);
        let from = message.from.as_ref().expect("from");
        let to = message.to.as_ref().expect("to");
        let body = message.body.as_ref().expect("body");
        assert_eq!(from.uid, 722593826);
        assert_eq!(from.name, "Tester");
        assert_eq!(to.uid, 698704560);
        assert_eq!(to.name, "Boss");
        assert_eq!(to.source, 4);
        assert_eq!(message.status, 2);
        assert!(message.security_id.is_empty());
        assert_eq!(body.body_type, 1);
        assert_eq!(body.template_id, 1);
        assert_eq!(body.text, "你好");
        assert_eq!(root_fields, vec![1, 2, 3]);
        assert_eq!(
            message_fields,
            vec![1, 2, 3, 4, 5, 6, 7, 9, 10, 11, 12, 13, 18, 20]
        );
        assert_eq!(from_fields, vec![1, 2, 7]);
        assert_eq!(to_fields, vec![1, 2, 7]);
    }

    #[test]
    fn native_text_message_encodes_business_overrides() {
        let session = SessionConfig {
            uid: "722593826".to_string(),
            ..SessionConfig::default()
        };
        let friend_ctx = FriendContext {
            friend_id: "698704560".to_string(),
            friend_source: "0".to_string(),
            job_source: "0".to_string(),
            security_id: "sec-123".to_string(),
            friend_type: Some(3),
            fridend_stage: None,
            datetime_ms: None,
            water_level: None,
        };
        let mut draft = NativeTextMessageDraft::from_context(
            &session,
            &friend_ctx,
            "Boss",
            "Tester",
            "你好".to_string(),
            "{\"foo\":\"bar\"}".to_string(),
        )
        .expect("draft");
        draft.task_id = 7788;
        draft.quote_id = 99;
        draft.biz_id = "biz-1".to_string();
        draft.biz_type = 105;

        let encoded = draft.encode().expect("encode");
        let decoded =
            TechwolfChatProtocolProto::decode(encoded.payload.as_slice()).expect("decode");
        let message = decoded.messages.first().expect("message");
        let body = message.body.as_ref().expect("body");
        let message_bytes = decode_nested_message_field(&encoded.payload, 3);
        let body_fields = decode_field_numbers(&decode_nested_message_field(&message_bytes, 6));

        assert_eq!(message.task_id, 7788);
        assert_eq!(message.quote_id, 99);
        assert_eq!(message.biz_id, "biz-1");
        assert_eq!(message.biz_type, 105);
        assert_eq!(body.extend, "{\"foo\":\"bar\"}");
        assert_eq!(body_fields, vec![1, 2, 3, 28]);
    }

    #[test]
    fn friend_context_to_value_includes_business_state() {
        let friend = FriendContext {
            friend_id: "698704560".to_string(),
            friend_source: "0".to_string(),
            job_source: "0".to_string(),
            security_id: "sec".to_string(),
            friend_type: Some(3),
            fridend_stage: None,
            datetime_ms: None,
            water_level: None,
        };

        let value = friend.to_value();
        assert_eq!(
            value["business_state"]["is_friend_have_send_msg_to_me"].as_bool(),
            Some(true)
        );
        assert_eq!(
            value["business_state"]["is_passive_conversation"].as_bool(),
            Some(true)
        );
    }

    #[test]
    fn decode_history_messages_surfaces_action_and_dialog_metadata() {
        let protocol = TechwolfChatProtocolProto {
            protocol_type: 1,
            version: "1.4".to_string(),
            messages: vec![TechwolfMessageProto {
                from: Some(TechwolfUserProto {
                    uid: 1,
                    name: "A".to_string(),
                    source: 0,
                }),
                to: Some(TechwolfUserProto {
                    uid: 2,
                    name: "B".to_string(),
                    source: 4,
                }),
                message_type: 4,
                mid: 99,
                time: 123456,
                body: Some(TechwolfMessageBodyProto {
                    body_type: 7,
                    template_id: 2,
                    head_title: "title".to_string(),
                    text: "body".to_string(),
                    at_info: None,
                    action: Some(TechwolfActionProto {
                        action_type: 20,
                        extend: "%7B%22msg_id%22%3A99%2C%22action%22%3A1%7D".to_string(),
                    }),
                    dialog: Some(TechwolfDialogProto {
                        text: "dialog text".to_string(),
                        buttons: vec![TechwolfButtonProto {
                            text: "确认".to_string(),
                            url: "bosszp://dialog?action=1".to_string(),
                            template_id: 1,
                        }],
                        operated: false,
                        click_more: true,
                        dialog_type: 27,
                        background_url: "https://img".to_string(),
                        timeout: 30,
                        statistic_parameters: "{\"scene\":\"chat\"}".to_string(),
                        title: "dialog title".to_string(),
                        url: "bosszp://dialog".to_string(),
                        selected_index: 0,
                        extend: "{\"foo\":\"bar\"}".to_string(),
                        content: "dialog content".to_string(),
                    }),
                    hyper_link: None,
                    extend: "{\"biz\":\"value\"}".to_string(),
                }),
                offline: false,
                push_text: String::new(),
                task_id: 0,
                cmid: 88,
                status: 0,
                uncount: 0,
                biz_id: String::new(),
                biz_type: 21050077,
                security_id: "sec".to_string(),
                quote_id: 0,
            }],
            presence: None,
        };

        let blob = base64::engine::general_purpose::STANDARD.encode(protocol.encode_to_vec());
        let (decoded, errors) = decode_history_messages(&[Value::String(blob)]);
        assert!(errors.is_empty());
        let message = decoded.first().expect("decoded message");
        assert_eq!(message.body_type, 7);
        assert_eq!(message.template_id, 2);
        assert_eq!(
            message
                .extend_json
                .as_ref()
                .and_then(|value| value.get("biz"))
                .and_then(Value::as_str),
            Some("value")
        );
        assert_eq!(
            message
                .action
                .as_ref()
                .and_then(|value| value.extend_json.as_ref())
                .and_then(|value| value.get("action"))
                .and_then(Value::as_i64),
            Some(1)
        );
        assert_eq!(
            message
                .dialog
                .as_ref()
                .and_then(|value| value.statistic_parameters_json.as_ref())
                .and_then(|value| value.get("scene"))
                .and_then(Value::as_str),
            Some("chat")
        );
        assert_eq!(
            message
                .dialog
                .as_ref()
                .and_then(|value| value.buttons.first())
                .map(|button| button.text.as_str()),
            Some("确认")
        );
    }

    #[test]
    fn mock_jf0_dispatch_returns_ack_receipt() {
        let session = SessionConfig {
            uid: "1".to_string(),
            ..SessionConfig::default()
        };
        let friend_ctx = FriendContext {
            friend_id: "2".to_string(),
            friend_source: "0".to_string(),
            job_source: "0".to_string(),
            security_id: "sec".to_string(),
            friend_type: None,
            fridend_stage: None,
            datetime_ms: None,
            water_level: None,
        };
        let draft = NativeTextMessageDraft::from_context(
            &session,
            &friend_ctx,
            "",
            "",
            "hello".to_string(),
            String::new(),
        )
        .expect("draft");
        let encoded = draft.encode().expect("encode");
        let dispatch =
            Jf0Dispatch::run_mock(&draft, &encoded, "mock", Some(999)).expect("dispatch");

        assert!(dispatch.ok);
        assert!(dispatch.accepted);
        assert_eq!(dispatch.server_mid, 999);
    }

    #[test]
    fn session_mqtt_client_seed_prefers_fingerprint_uniqid() {
        let session = SessionConfig {
            uid: "722593826".to_string(),
            identity: "0".to_string(),
            fp_uniqid: "uniq-seed".to_string(),
            ..SessionConfig::default()
        };

        assert_eq!(session_mqtt_client_seed(&session), "uniq-seed");
    }

    #[test]
    fn session_mqtt_username_uses_kernel_chat_contract() {
        let session = SessionConfig {
            uid: "722593826".to_string(),
            identity: "0".to_string(),
            ..SessionConfig::default()
        };

        assert_eq!(session_mqtt_username(&session), "722593826-0-1.4-14.030");
    }

    #[test]
    fn build_presence_payload_uses_kernel_presence_contract() {
        let session = SessionConfig {
            uid: "722593826".to_string(),
            fp_uniqid: "uniqid".to_string(),
            fp_brand: "realme".to_string(),
            fp_model: "RMX3560".to_string(),
            fp_network: "wifi".to_string(),
            ..SessionConfig::default()
        };

        let (_payload_base64, summary) =
            build_presence_payload(&session, 321_409_907_254_528).expect("presence");
        assert_eq!(
            summary.get("protocol_type").and_then(Value::as_i64),
            Some(2)
        );
        assert_eq!(summary.get("version").and_then(Value::as_str), Some("1.3"));
        assert_eq!(
            summary.get("presence_type").and_then(Value::as_i64),
            Some(768)
        );
        assert_eq!(
            summary.get("last_message_id").and_then(Value::as_i64),
            Some(321_409_907_254_528)
        );
    }

    #[test]
    fn extract_mqtt_message_sync_server_mid_matches_client_mid() {
        let mqtt_payload = json!({
            "inbound_events": [
                {
                    "message_sync": [
                        {"client_mid": 11, "server_mid": 22},
                        {"client_mid": 33, "server_mid": 44}
                    ]
                }
            ]
        });
        let draft = NativeTextMessageDraft {
            version: "1.4".to_string(),
            protocol_type: 1,
            client_temp_message_id: 33,
            timestamp_ms: 0,
            sender_uid: 1,
            sender_name: String::new(),
            sender_source: 0,
            friend_uid: 2,
            friend_name: String::new(),
            friend_source: 0,
            contact_security_id: "sec".to_string(),
            text: String::new(),
            extend: String::new(),
            task_id: 0,
            quote_id: 0,
            biz_id: String::new(),
            biz_type: 0,
        };

        assert_eq!(
            extract_mqtt_message_sync_server_mid(Some(&mqtt_payload), &draft),
            Some(44)
        );
    }

    #[test]
    fn extract_mqtt_pull_hint_reads_secret_and_last_id() {
        let mqtt_payload = json!({
            "inbound_events": [
                {
                    "iq_query": "/message/pull",
                    "iq_results": [
                        {"key": "hasMore", "value": "true"},
                        {"key": "secretId", "value": "secret-123"},
                        {"key": "lastId", "value": "456"}
                    ]
                }
            ]
        });

        let hint = extract_mqtt_pull_hint(Some(&mqtt_payload)).expect("pull hint");
        assert_eq!(hint.0, "secret-123");
        assert_eq!(hint.1, 456);
    }

    #[test]
    fn normalize_payload_builder_mode_defaults_to_serializer() {
        assert_eq!(normalize_payload_builder_mode(None), "serializer");
        assert_eq!(
            normalize_payload_builder_mode(Some(" serializer ")),
            "serializer"
        );
        assert_eq!(normalize_payload_builder_mode(Some("patched")), "patched");
        assert_eq!(normalize_payload_builder_mode(Some("manual")), "manual");
        assert_eq!(normalize_payload_builder_mode(Some("weird")), "serializer");
    }

    #[test]
    fn next_payload_builder_retry_mode_escalates_from_serializer_to_patched_to_manual() {
        let serializer_dispatch = Jf0Dispatch {
            ok: true,
            mode: "mqtt".to_string(),
            accepted: true,
            server_mid: 1,
            receipt: json!({
                "mqtt": {
                    "payload_builder": {
                        "selected_builder": "apk_serializer"
                    }
                }
            }),
        };
        let confirmed = BusinessSendConfirmation {
            confirmed: true,
            confirm_source: "history_poll".to_string(),
            elapsed_ms: 10,
            poll_count: 1,
            matched_message: None,
            matched_server_mid: Some(1),
            push_signal: Value::Null,
            polls: Vec::new(),
        };

        assert_eq!(
            next_payload_builder_retry_mode(&serializer_dispatch, None),
            Some("patched")
        );
        assert_eq!(
            next_payload_builder_retry_mode(&serializer_dispatch, Some(&confirmed)),
            None
        );

        let patched_dispatch = Jf0Dispatch {
            ok: true,
            mode: "mqtt".to_string(),
            accepted: true,
            server_mid: 1,
            receipt: json!({
                "mqtt": {
                    "payload_builder": {
                        "selected_builder": "apk_serializer_with_security_id"
                    }
                }
            }),
        };
        assert_eq!(
            next_payload_builder_retry_mode(&patched_dispatch, None),
            Some("manual")
        );

        let manual_dispatch = Jf0Dispatch {
            ok: true,
            mode: "mqtt".to_string(),
            accepted: true,
            server_mid: 1,
            receipt: json!({
                "mqtt": {
                    "payload_builder": {
                        "selected_builder": "manual_builder"
                    }
                }
            }),
        };
        assert_eq!(
            next_payload_builder_retry_mode(&manual_dispatch, None),
            None
        );
    }

    #[test]
    fn proactive_send_succeeded_requires_triggered_zero_code() {
        let success = json!({
            "triggered": true,
            "result": {
                "response": {
                    "code": 0,
                }
            }
        });
        let failed_code = json!({
            "triggered": true,
            "result": {
                "response": {
                    "code": 6,
                }
            }
        });
        let not_triggered = json!({
            "triggered": false,
            "result": {
                "response": {
                    "code": 0,
                }
            }
        });

        assert!(proactive_send_succeeded(&success));
        assert!(!proactive_send_succeeded(&failed_code));
        assert!(!proactive_send_succeeded(&not_triggered));
    }

    #[test]
    fn friend_context_from_row_preserves_chat_business_fields() {
        let row = json!({
            "friendId": 698704560u64,
            "friendSource": 4,
            "jobSource": 2,
            "securityId": "sec-123",
            "friendType": 3,
            "fridendStage": 5,
            "datetime": 123456789u64,
            "waterLevel": 7u64,
        });

        let ctx = friend_context_from_row(&row).expect("friend context");
        assert_eq!(ctx.friend_id, "698704560");
        assert_eq!(ctx.friend_source, "4");
        assert_eq!(ctx.job_source, "2");
        assert_eq!(ctx.security_id, "sec-123");
        assert_eq!(ctx.friend_type, Some(3));
        assert_eq!(ctx.fridend_stage, Some(5));
        assert_eq!(ctx.datetime_ms, Some(123456789));
        assert_eq!(ctx.water_level, Some(7));
    }

    #[test]
    fn merge_decoded_histories_deduplicates_and_orders_messages() {
        let recent = MessageHistoryProbe {
            result: SignedGetResult {
                route: "recent".to_string(),
                host: String::new(),
                path: String::new(),
                traceid: String::new(),
                url: String::new(),
                headers: HashMap::new(),
                signed_query_keys: Vec::new(),
                clear_exempt_query_keys: Vec::new(),
                response: json!({}),
            },
            attempts: Vec::new(),
            raw_messages: Vec::new(),
            decoded_messages: vec![
                DecodedHistoryMessage {
                    envelope_index: 0,
                    protocol_type: 1,
                    protocol_version: "1.4".to_string(),
                    message_type: 1,
                    mid: 2,
                    cmid: 20,
                    time_ms: 200,
                    status: 0,
                    security_id: "sec".to_string(),
                    quote_id: 0,
                    biz_id: String::new(),
                    biz_type: 0,
                    body_type: 1,
                    template_id: 1,
                    text: "later".to_string(),
                    head_title: String::new(),
                    extend: String::new(),
                    extend_json: None,
                    action: None,
                    dialog: None,
                    hyper_link: None,
                    from_uid: 1,
                    from_name: "A".to_string(),
                    from_source: 0,
                    to_uid: 2,
                    to_name: "B".to_string(),
                    to_source: 4,
                },
                DecodedHistoryMessage {
                    envelope_index: 0,
                    protocol_type: 1,
                    protocol_version: "1.4".to_string(),
                    message_type: 1,
                    mid: 3,
                    cmid: 30,
                    time_ms: 300,
                    status: 0,
                    security_id: "sec".to_string(),
                    quote_id: 0,
                    biz_id: String::new(),
                    biz_type: 0,
                    body_type: 1,
                    template_id: 1,
                    text: "latest".to_string(),
                    head_title: String::new(),
                    extend: String::new(),
                    extend_json: None,
                    action: None,
                    dialog: None,
                    hyper_link: None,
                    from_uid: 1,
                    from_name: "A".to_string(),
                    from_source: 0,
                    to_uid: 2,
                    to_name: "B".to_string(),
                    to_source: 4,
                },
            ],
            decode_errors: Vec::new(),
        };
        let sync = MessageHistoryProbe {
            result: SignedGetResult {
                route: "sync".to_string(),
                host: String::new(),
                path: String::new(),
                traceid: String::new(),
                url: String::new(),
                headers: HashMap::new(),
                signed_query_keys: Vec::new(),
                clear_exempt_query_keys: Vec::new(),
                response: json!({}),
            },
            attempts: Vec::new(),
            raw_messages: Vec::new(),
            decoded_messages: vec![
                DecodedHistoryMessage {
                    envelope_index: 0,
                    protocol_type: 1,
                    protocol_version: "1.4".to_string(),
                    message_type: 1,
                    mid: 1,
                    cmid: 10,
                    time_ms: 100,
                    status: 0,
                    security_id: "sec".to_string(),
                    quote_id: 0,
                    biz_id: String::new(),
                    biz_type: 0,
                    body_type: 1,
                    template_id: 1,
                    text: "earlier".to_string(),
                    head_title: String::new(),
                    extend: String::new(),
                    extend_json: None,
                    action: None,
                    dialog: None,
                    hyper_link: None,
                    from_uid: 2,
                    from_name: "B".to_string(),
                    from_source: 4,
                    to_uid: 1,
                    to_name: "A".to_string(),
                    to_source: 0,
                },
                DecodedHistoryMessage {
                    envelope_index: 0,
                    protocol_type: 1,
                    protocol_version: "1.4".to_string(),
                    message_type: 1,
                    mid: 2,
                    cmid: 20,
                    time_ms: 200,
                    status: 0,
                    security_id: "sec".to_string(),
                    quote_id: 0,
                    biz_id: String::new(),
                    biz_type: 0,
                    body_type: 1,
                    template_id: 1,
                    text: "later".to_string(),
                    head_title: String::new(),
                    extend: String::new(),
                    extend_json: None,
                    action: None,
                    dialog: None,
                    hyper_link: None,
                    from_uid: 1,
                    from_name: "A".to_string(),
                    from_source: 0,
                    to_uid: 2,
                    to_name: "B".to_string(),
                    to_source: 4,
                },
            ],
            decode_errors: vec![json!({"index": 0, "error": "noop"})],
        };

        let merged = merge_decoded_histories(Some(&recent), Some(&sync));
        assert_eq!(merged.len(), 3);
        assert_eq!(
            merged.iter().map(|message| message.mid).collect::<Vec<_>>(),
            vec![1, 2, 3]
        );
        let errors = merge_decode_errors(Some(&recent), Some(&sync));
        assert_eq!(errors.len(), 1);
        assert_eq!(
            errors[0].get("source").and_then(Value::as_str),
            Some("sync_history")
        );
    }
}
