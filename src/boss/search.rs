use std::collections::{BTreeMap, HashMap};

use anyhow::{anyhow, Context, Result};
use reqwest::Url;
use serde_json::{json, Value};

use super::job_detail::{
    build_common_params, build_traceid, canonicalize_params, execute_post, normalize_host, now_ms,
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
const SEARCH_STAGE1_PATH: &str = "/api/batch/batchRunV2";
const SEARCH_STAGE2_PATH: &str = "/api/batch/requests";
const SEARCH_CARDLIST_PATH: &str = "/api/zpgeek/app/geek/search/cardlist";
const SEARCH_LISTAD_PATH: &str = "/api/zpgeek/app/search/listad/query";
const DEFAULT_SEARCH_HOST: &str = "https://api-and.zhipin.com";
const ALT_SEARCH_HOST: &str = "https://api5.zhipin.com";
const API_SEARCH_HOST: &str = "https://api.zhipin.com";
const DEFAULT_CITY_CODE: &str = "101010100";

const SEARCH_BATCH_PROFILE_BOOTSTRAP: &[&str] = &[
    "zpCommon.config.getInnerLinkRuleList",
    "zpCommon.common.config",
    "zpchat.config.getInnerLinkRuleList",
    "zpCommon.h5.domain.mapping",
];

const SEARCH_BATCH_PROFILE_STATE: &[&str] = &[
    "zpgeek.app.bluecollar.topic.banner.v2",
    "zpuser.user.getBottomBtns",
    "zpuser.dynamicBar.get",
    "zpgeek.cvapp.f1.tab.config",
    "zpgeek.app.geek.common.config",
    "zpgeek.cvapp.geek.baseinfo.query",
    "zpp.app.user.unBzbOrderList",
    "zpitemGeek.geek.vip.info",
    "zpuser.user.check",
    "zpgeek.app.interaction.query",
    "zpitemGeek.geek.getItemMallF4",
    "zpapptips.app.tip.f4.query",
    "zpgeek.app.geek.expectposition.suggest.reddot.query",
    "certification.security.get",
    "zpgeek.app.student.feature.query",
    "zpgeek.app.studentparttime.topic.banner.v2",
    "zpgeek.cvapp.identity.switch.entrance",
    "zpchat.wechat.get.WxNotify.commonSetting",
];

const SEARCH_BATCH_PROFILE_F1: &[&str] = &[
    "certification.violate.rule.prompt.dialog",
    "zpdac.safeTip",
    "zppassport.user.checkPhoneStatus",
    "zpitem.pop.geek.f1window",
    "zpitem.searchChatCard.guideViewMsg",
    "zpinterview.geek.interview.question.get2&bossId=&encryptInterviewId=&geekClick=0&inquireResult=0",
    "zpgeek.cvapp.useractive.query",
    "zpgeek.app.agreement.update.tip",
    "pushengine.nps.investigate",
];

const SEARCH_PROFILES: &[(&str, &[&str])] = &[
    ("bootstrap", SEARCH_BATCH_PROFILE_BOOTSTRAP),
    ("state", SEARCH_BATCH_PROFILE_STATE),
    ("f1", SEARCH_BATCH_PROFILE_F1),
];

pub fn run_search(opts: &HashMap<String, String>) -> Result<Value> {
    let search_opts = SearchOptions::from_opts(opts)?;
    let session_path = opts.get("--session-path").map(String::as_str);
    let resolved_session_path = resolved_session_path(session_path);
    let output_path =
        resolve_output_path(opts.get("--out").map(String::as_str), "search_result.json");
    let config_path = std::path::PathBuf::from(
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
    let hosts = build_host_candidates(opts.get("--host").map(String::as_str));

    let mut attempts = Vec::new();
    let mut best_stage1_success: Option<Value> = None;
    let mut last_response = json!({
        "code": -1,
        "message": "search did not execute",
    });

    for host in hosts {
        let mut expect_ctx: Option<ExpectContext> = None;
        for (profile_name, methods) in SEARCH_PROFILES {
            let materialized_methods = materialize_profile_methods(profile_name, methods);
            let stage1 = PreparedStage1Request::sign(
                &search_opts,
                &host,
                profile_name,
                &materialized_methods,
                &device,
                &session,
                &*signer,
                now_ms(),
                &build_traceid(),
            )?;
            let stage1_raw = execute_post(
                &transport,
                &stage1.url,
                &stage1.headers,
                &stage1.body_bytes,
                Some(&*signer),
                session.secret_key.as_str(),
            )?;
            let mut stage1_response = normalize_search_payload(&stage1_raw);
            if response_code(Some(&stage1_response)) == Some(0) {
                expect_ctx =
                    extract_expect_context(&stage1_response, &search_opts).or(expect_ctx.clone());
            }

            let stage1_jobs = find_job_list(&stage1_response);
            let mut stage2_record = Value::Null;
            let mut final_response = stage1_response.clone();
            let mut final_stage = "stage1";

            if stage1_jobs.as_ref().map(Vec::is_empty).unwrap_or(true)
                && response_code(Some(&stage1_response)) == Some(0)
            {
                let stage2 = PreparedStage2Request::sign(
                    &search_opts,
                    expect_ctx.as_ref(),
                    &host,
                    &device,
                    &session,
                    &*signer,
                    now_ms(),
                    &build_traceid(),
                )?;
                let stage2_raw = execute_post(
                    &transport,
                    &stage2.url,
                    &stage2.headers,
                    &stage2.body_bytes,
                    Some(&*signer),
                    session.secret_key.as_str(),
                )?;
                let decoded_stage2 = decode_stage2_non_raw_payload(
                    stage2_raw,
                    &*signer,
                    session.secret_key.as_str(),
                )?;
                let stage2_response = normalize_search_payload(&decoded_stage2);
                stage2_record = json!({
                    "request_contract": stage2.contract,
                    "request": {
                        "url": stage2.url,
                        "traceid": stage2.traceid,
                        "request_headers": redact_headers(&stage2.headers),
                        "body_json": stage2.body_json,
                        "body_len": stage2.body_bytes.len(),
                    },
                    "response": stage2_response,
                });
                if has_jobs(&stage2_response) {
                    final_response = stage2_response;
                    final_stage = "stage2";
                } else if response_code(Some(&stage1_response)) == Some(0) {
                    if let Some(object) = stage1_response.as_object_mut() {
                        object.insert(
                            "debug".to_string(),
                            json!({
                                "batch_stage": "stage1",
                                "stage2_attempted": true,
                                "stage2_code": stage2_record.get("response").and_then(|value| value.get("code")).cloned().unwrap_or(Value::Null),
                                "stage2_message": stage2_record.get("response").and_then(|value| value.get("message")).cloned().unwrap_or(Value::Null),
                            }),
                        );
                    }
                }
            }

            if final_stage == "stage1" && response_code(Some(&stage1_response)) == Some(0) {
                best_stage1_success = Some(stage1_response.clone());
            }

            attempts.push(json!({
                "host": host,
                "profile": profile_name,
                "final_stage": final_stage,
                "expect_context": expect_ctx.as_ref().map(ExpectContext::to_value).unwrap_or(Value::Null),
                "stage1": {
                    "request_contract": stage1.contract,
                    "request": {
                        "url": stage1.url,
                        "traceid": stage1.traceid,
                        "request_headers": redact_headers(&stage1.headers),
                        "body_form": stage1.body_form,
                    },
                    "response": stage1_raw,
                    "normalized_response": stage1_response,
                },
                "stage2": stage2_record,
            }));

            last_response = final_response.clone();
            if has_jobs(&final_response) {
                let output = finalize_search_output(
                    &search_opts,
                    &resolved_session_path,
                    &transport,
                    &*signer,
                    final_response,
                    attempts,
                )?;
                std::fs::write(&output_path, serde_json::to_vec_pretty(&output)?).with_context(
                    || format!("failed to write search result: {}", output_path.display()),
                )?;
                return Ok(output);
            }
        }
    }

    let fallback = best_stage1_success.unwrap_or(last_response);
    let output = finalize_search_output(
        &search_opts,
        &resolved_session_path,
        &transport,
        &*signer,
        fallback,
        attempts,
    )?;
    std::fs::write(&output_path, serde_json::to_vec_pretty(&output)?)
        .with_context(|| format!("failed to write search result: {}", output_path.display()))?;
    Ok(output)
}

fn finalize_search_output(
    search_opts: &SearchOptions,
    resolved_session_path: &str,
    transport: &HttpTransport,
    signer: &dyn BossSigner,
    response: Value,
    attempts: Vec<Value>,
) -> Result<Value> {
    let jobs = find_job_list(&response).unwrap_or_default();
    Ok(json!({
        "ok": !jobs.is_empty() && response_code(Some(&response)) == Some(0),
        "route": "batch_search_complex",
        "session_path": resolved_session_path,
        "keyword": search_opts.keyword,
        "city_code": search_opts.city_code,
        "page": search_opts.page,
        "page_size": search_opts.page_size,
        "native_invoker": signer.describe(),
        "transport_runtime": transport.label(),
        "original_okhttp_available": transport.original_okhttp_available(),
        "transport": transport.describe(),
        "response": response,
        "summary": summarize_jobs(&jobs),
        "attempts": attempts,
    }))
}

#[derive(Clone, Debug)]
struct SearchOptions {
    keyword: String,
    city_code: String,
    page: String,
    page_size: String,
}

impl SearchOptions {
    fn from_opts(opts: &HashMap<String, String>) -> Result<Self> {
        let keyword = opts
            .get("--keyword")
            .cloned()
            .or_else(|| opts.get("_0").cloned())
            .unwrap_or_default()
            .trim()
            .to_string();
        if keyword.is_empty() {
            return Err(anyhow!(
                "search requires --keyword <text> or positional <keyword>"
            ));
        }

        let city_code = opts
            .get("--city")
            .cloned()
            .or_else(|| opts.get("--city-code").cloned())
            .unwrap_or_else(|| DEFAULT_CITY_CODE.to_string());
        let page = opts
            .get("--page")
            .cloned()
            .unwrap_or_else(|| "1".to_string());
        let page_size = opts
            .get("--page-size")
            .cloned()
            .unwrap_or_else(|| "20".to_string());
        Ok(Self {
            keyword,
            city_code,
            page,
            page_size,
        })
    }
}

#[derive(Clone, Debug)]
struct ExpectContext {
    encrypt_expect_id: String,
    expect_id: String,
    city_code: String,
}

impl ExpectContext {
    fn to_value(&self) -> Value {
        json!({
            "encrypt_expect_id": self.encrypt_expect_id,
            "expect_id": self.expect_id,
            "city_code": self.city_code,
        })
    }
}

struct PreparedStage1Request {
    url: String,
    traceid: String,
    headers: HashMap<String, String>,
    body_form: String,
    body_bytes: Vec<u8>,
    contract: Value,
}

impl PreparedStage1Request {
    fn sign(
        search_opts: &SearchOptions,
        host: &str,
        profile_name: &str,
        methods: &[String],
        device: &DeviceConfig,
        session: &SessionConfig,
        signer: &dyn BossSigner,
        req_time_ms: u64,
        traceid: &str,
    ) -> Result<Self> {
        let mut signing_params = build_common_params(device, req_time_ms);
        let batch_method_feed = build_search_batch_method_feed(methods);
        signing_params.insert("app_id".to_string(), APP_ID.to_string());
        signing_params.insert("batch_method_feed".to_string(), batch_method_feed.clone());

        let canonical = canonicalize_params(&signing_params);
        let sp = signer
            .encode_request(canonical.as_bytes(), "")
            .context("failed to build stage1 sp")?;
        let sig_input = format!(
            "{}{}",
            SEARCH_STAGE1_PATH,
            truncate_for_sig(&canonical, 5000)
        );
        let sig = signer
            .signature(sig_input.as_bytes(), "")
            .context("failed to build stage1 sig")?;
        let mut final_params = signing_params.clone();
        final_params.insert("sp".to_string(), sp);
        final_params.insert("sig".to_string(), sig);
        let body_form = encode_form_body(&final_params);
        let url = format!("{}{}", host.trim_end_matches('/'), SEARCH_STAGE1_PATH);

        let zp_tag = signer
            .encode_request(traceid.as_bytes(), "")
            .context("failed to build stage1 zp-tag")?;
        let headers = request_headers(
            host,
            device,
            session,
            traceid,
            &zp_tag,
            "application/x-www-form-urlencoded",
        )?;

        Ok(Self {
            url,
            traceid: traceid.to_string(),
            headers,
            body_bytes: body_form.as_bytes().to_vec(),
            body_form,
            contract: json!({
                "type": "batchRunV2_search_stage1",
                "endpoint": SEARCH_STAGE1_PATH,
                "host": host,
                "profile": profile_name,
                "method_count": methods.len(),
                "app_id": APP_ID,
                "keyword": search_opts.keyword,
                "city_code": search_opts.city_code,
                "page": search_opts.page,
                "page_size": search_opts.page_size,
            }),
        })
    }
}

struct PreparedStage2Request {
    url: String,
    traceid: String,
    headers: HashMap<String, String>,
    body_json: String,
    body_bytes: Vec<u8>,
    contract: Value,
}

impl PreparedStage2Request {
    fn sign(
        search_opts: &SearchOptions,
        expect_ctx: Option<&ExpectContext>,
        host: &str,
        device: &DeviceConfig,
        session: &SessionConfig,
        signer: &dyn BossSigner,
        req_time_ms: u64,
        traceid: &str,
    ) -> Result<Self> {
        let common_params = build_common_params(device, req_time_ms);
        let canonical = canonicalize_params(&common_params);
        let body_json = build_stage2_body_json(search_opts, expect_ctx);
        let body_bytes = signer
            .encode_request_body(body_json.as_bytes(), "")
            .context("failed to encode stage2 body")?;
        let crc = crc32fast::hash(&body_bytes);
        let sp = signer
            .encode_request(canonical.as_bytes(), "")
            .context("failed to build stage2 sp")?;
        let sig_input = format!(
            "{}{}{}",
            SEARCH_STAGE2_PATH,
            truncate_for_sig(&canonical, 5000),
            crc
        );
        let sig = signer
            .signature(sig_input.as_bytes(), "")
            .context("failed to build stage2 sig")?;

        let mut query = common_params.clone();
        query.insert("sp".to_string(), sp);
        query.insert("sig".to_string(), sig);
        query.insert("app_id".to_string(), APP_ID.to_string());
        let url = build_query_url(host, SEARCH_STAGE2_PATH, &query)?;

        let zp_tag = signer
            .encode_request(traceid.as_bytes(), "")
            .context("failed to build stage2 zp-tag")?;
        let headers = request_headers(
            host,
            device,
            session,
            traceid,
            &zp_tag,
            "application/octet-stream",
        )?;

        Ok(Self {
            url,
            traceid: traceid.to_string(),
            headers,
            body_json,
            body_bytes,
            contract: json!({
                "type": "batch_requests_search_stage2",
                "endpoint": SEARCH_STAGE2_PATH,
                "host": host,
                "query_keys": ["app_id", "client_info", "curidentity", "req_time", "sp", "sig", "uniqid", "v"],
                "sub_requests": [
                    { "path": SEARCH_CARDLIST_PATH },
                    { "path": SEARCH_LISTAD_PATH }
                ],
                "expect_context": expect_ctx.map(ExpectContext::to_value).unwrap_or(Value::Null),
            }),
        })
    }
}

fn build_stage2_body_json(
    search_opts: &SearchOptions,
    expect_ctx: Option<&ExpectContext>,
) -> String {
    let city_code = expect_ctx
        .map(|ctx| ctx.city_code.as_str())
        .filter(|value| !value.trim().is_empty())
        .unwrap_or(search_opts.city_code.as_str());
    let filter_params = json!({
        "cityCode": city_code,
        "chattedJob": 0,
        "switchCity": 0,
    });
    let encrypt_expect_id = expect_ctx
        .map(|ctx| ctx.encrypt_expect_id.as_str())
        .unwrap_or_default();
    let expect_id = expect_ctx
        .map(|ctx| ctx.expect_id.as_str())
        .unwrap_or_default();
    let sub_reqs = json!({
        "subReqs": [
            {
                "method": "GET",
                "path": SEARCH_CARDLIST_PATH,
                "query": encode_stage2_query(&[
                    ("bizCode".to_string(), "boss_serv13_1324_170".to_string()),
                    ("encryptExpectId".to_string(), encrypt_expect_id.to_string()),
                    ("expectId".to_string(), expect_id.to_string()),
                    ("filterParams".to_string(), serde_json::to_string(&filter_params).unwrap_or_else(|_| "{}".to_string())),
                    ("isFromJd".to_string(), "0".to_string()),
                    ("isSupplySearch".to_string(), "false".to_string()),
                    ("maskComType".to_string(), "0".to_string()),
                    ("noCorrect".to_string(), "0".to_string()),
                    ("page".to_string(), search_opts.page.clone()),
                    ("prefix".to_string(), "l".to_string()),
                    ("query".to_string(), search_opts.keyword.clone()),
                    ("queryId".to_string(), String::new()),
                    ("searchType".to_string(), "3".to_string()),
                    ("sort".to_string(), "-1".to_string()),
                    ("source".to_string(), "1".to_string()),
                ]),
            },
            {
                "method": "GET",
                "path": SEARCH_LISTAD_PATH,
                "query": encode_stage2_query(&[
                    ("encryptExpectId".to_string(), encrypt_expect_id.to_string()),
                    ("filterParams".to_string(), serde_json::to_string(&filter_params).unwrap_or_else(|_| "{}".to_string())),
                    ("page".to_string(), search_opts.page.clone()),
                    ("query".to_string(), search_opts.keyword.clone()),
                    ("sort".to_string(), "-1".to_string()),
                ]),
            }
        ]
    });
    escape_batch_body_json(
        &serde_json::to_string(&sub_reqs).unwrap_or_else(|_| "{\"subReqs\":[]}".to_string()),
    )
}

fn build_search_batch_method_feed(methods: &[String]) -> String {
    let quoted = methods
        .iter()
        .map(|method| {
            serde_json::to_string(&format!("method={method}"))
                .unwrap_or_else(|_| "\"\"".to_string())
        })
        .collect::<Vec<_>>();
    format!("[{}]", quoted.join(", "))
}

fn materialize_profile_methods(profile_name: &str, methods: &[&str]) -> Vec<String> {
    if profile_name != "state" {
        return methods.iter().map(|value| (*value).to_string()).collect();
    }
    methods
        .iter()
        .map(|method| {
            if *method == "zpgeek.cvapp.geek.baseinfo.query" {
                "zpgeek.cvapp.geek.baseinfo.query&subLocation=0&userId=0".to_string()
            } else {
                (*method).to_string()
            }
        })
        .collect()
}

fn build_host_candidates(preferred_host: Option<&str>) -> Vec<String> {
    if let Some(host) = preferred_host {
        return vec![normalize_host(host)];
    }
    vec![
        DEFAULT_SEARCH_HOST.to_string(),
        ALT_SEARCH_HOST.to_string(),
        API_SEARCH_HOST.to_string(),
    ]
}

fn request_headers(
    host: &str,
    device: &DeviceConfig,
    session: &SessionConfig,
    traceid: &str,
    zp_tag: &str,
    content_type: &str,
) -> Result<HashMap<String, String>> {
    let mut extra = HashMap::new();
    extra.insert("traceid".to_string(), traceid.to_string());
    extra.insert("zp-tag".to_string(), zp_tag.to_string());
    let mut headers = build_stage_inbound_headers(
        USER_AGENT,
        &host_header(host)?,
        device,
        Some(session),
        Some(extra),
    );
    headers.insert("Content-Type".to_string(), content_type.to_string());
    Ok(headers)
}

fn host_header(host: &str) -> Result<String> {
    let parsed = Url::parse(host).with_context(|| format!("invalid host url: {host}"))?;
    Ok(match parsed.port() {
        Some(port) => format!(
            "{}:{}",
            parsed.host_str().unwrap_or("api-and.zhipin.com"),
            port
        ),
        None => parsed
            .host_str()
            .unwrap_or("api-and.zhipin.com")
            .to_string(),
    })
}

fn build_query_url(host: &str, path: &str, params: &BTreeMap<String, String>) -> Result<String> {
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
    }
    Ok(url.to_string())
}

fn encode_form_body(params: &BTreeMap<String, String>) -> String {
    params
        .iter()
        .map(|(key, value)| format!("{}={}", query_component(key), query_component(value)))
        .collect::<Vec<_>>()
        .join("&")
}

fn encode_stage2_query(pairs: &[(String, String)]) -> String {
    pairs
        .iter()
        .map(|(key, value)| format!("{}={}", query_component(key), query_component(value)))
        .collect::<Vec<_>>()
        .join("&")
}

fn query_component(value: &str) -> String {
    let mut out = String::new();
    for byte in value.as_bytes() {
        match byte {
            b'0'..=b'9' | b'a'..=b'z' | b'A'..=b'Z' | b'-' | b'.' | b'_' => out.push(*byte as char),
            b' ' => out.push('+'),
            _ => out.push_str(&format!("%{byte:02X}")),
        }
    }
    out
}

fn escape_batch_body_json(body_json: &str) -> String {
    body_json
        .replace('=', "\\u003d")
        .replace('&', "\\u0026")
        .replace('\'', "\\u0027")
        .replace('<', "\\u003c")
        .replace('>', "\\u003e")
}

fn decode_stage2_non_raw_payload(
    payload: Value,
    signer: &dyn BossSigner,
    session_secret_key: &str,
) -> Result<Value> {
    let Some(object) = payload.as_object() else {
        return Ok(payload);
    };
    if object.get("code").and_then(Value::as_i64) != Some(-1) {
        return Ok(payload);
    }
    for key in ["nonRaw", "non_raw", "raw", "data"] {
        let Some(Value::String(cipher)) = object.get(key) else {
            continue;
        };
        for decode_key in ["", session_secret_key] {
            if let Ok(decoded) = signer.decode_content(cipher, decode_key) {
                if let Ok(text) = std::str::from_utf8(&decoded) {
                    if let Ok(value) = serde_json::from_str::<Value>(text.trim()) {
                        return Ok(value);
                    }
                }
            }
        }
    }
    Ok(payload)
}

fn normalize_search_payload(payload: &Value) -> Value {
    if response_code(Some(payload)) != Some(0) {
        return payload.clone();
    }
    let Some((jobs, meta)) = extract_search_cardlist_jobs(payload) else {
        return payload.clone();
    };
    let mut out = payload.clone();
    if let Some(zp_data) = out.get_mut("zpData").and_then(Value::as_object_mut) {
        zp_data.insert("jobList".to_string(), json!(jobs.clone()));
        zp_data.insert("data".to_string(), json!(jobs));
        for (key, value) in meta {
            zp_data.entry(key).or_insert(value);
        }
    }
    out
}

fn extract_expect_context(payload: &Value, search_opts: &SearchOptions) -> Option<ExpectContext> {
    let zp_data = payload.get("zpData")?.as_object()?;
    let baseinfo = zp_data
        .iter()
        .find(|(key, _)| key.starts_with("zpgeek.cvapp.geek.baseinfo.query"))
        .and_then(|(_, value)| value.as_object())?;
    let geek_detail = baseinfo
        .get("zpData")
        .and_then(Value::as_object)
        .and_then(|zp_data| zp_data.get("geekDetail"))
        .and_then(Value::as_object)?;
    let expect_list = geek_detail.get("expectPositionList")?.as_array()?;
    let keyword = search_opts.keyword.to_ascii_lowercase();
    let selected = expect_list
        .iter()
        .find_map(|item| {
            let object = item.as_object()?;
            if keyword.is_empty() {
                return Some(object);
            }
            let pos_name = object
                .get("positionName")
                .and_then(Value::as_str)
                .unwrap_or_default()
                .to_ascii_lowercase();
            let pos_cat = object
                .get("positionCategory")
                .and_then(Value::as_str)
                .unwrap_or_default()
                .to_ascii_lowercase();
            if pos_name.contains(&keyword) || pos_cat.contains(&keyword) {
                Some(object)
            } else {
                None
            }
        })
        .or_else(|| expect_list.iter().find_map(Value::as_object))?;

    let encrypt_expect_id = selected
        .get("encryptExpectId")
        .and_then(Value::as_str)
        .unwrap_or_default()
        .trim()
        .to_string();
    let expect_id = match selected.get("expectId") {
        Some(Value::String(value)) => value.trim().to_string(),
        Some(Value::Number(value)) => value.to_string(),
        _ => String::new(),
    };
    let city_code = match selected.get("location") {
        Some(Value::String(value)) => value.trim().to_string(),
        Some(Value::Number(value)) => value.to_string(),
        _ => search_opts.city_code.clone(),
    };

    if encrypt_expect_id.is_empty() || expect_id.is_empty() {
        return None;
    }

    Some(ExpectContext {
        encrypt_expect_id,
        expect_id,
        city_code,
    })
}

fn extract_search_cardlist_jobs(payload: &Value) -> Option<(Vec<Value>, BTreeMap<String, Value>)> {
    let zp_data = payload.get("zpData")?.as_object()?;
    let node = zp_data
        .get(SEARCH_CARDLIST_PATH)
        .or_else(|| zp_data.get("zpgeek.app.geek.search.cardlist"))?;
    let source = node
        .get("zpData")
        .and_then(Value::as_object)
        .cloned()
        .or_else(|| node.as_object().cloned())?;
    let card_list = source.get("cardList")?.as_array()?;

    let mut jobs = Vec::new();
    let mut meta = BTreeMap::new();
    for card in card_list {
        let Some(card) = card.as_object() else {
            continue;
        };
        if let Some(total_count) = card.get("totalCount") {
            meta.entry("totalCount".to_string())
                .or_insert_with(|| total_count.clone());
        }
        if let Some(has_more) = card.get("hasMore") {
            meta.entry("hasMore".to_string())
                .or_insert_with(|| has_more.clone());
        }
        let Some(position_cards) = card.get("positionSearchCardList").and_then(Value::as_array)
        else {
            continue;
        };
        for position_card in position_cards {
            if let Some(normalized) = normalize_cardlist_job(position_card) {
                jobs.push(normalized);
            }
        }
    }
    if jobs.is_empty() {
        None
    } else {
        Some((jobs, meta))
    }
}

fn normalize_cardlist_job(value: &Value) -> Option<Value> {
    let object = value.as_object()?;
    let job_name = coerce_text(object.get("positionName").or_else(|| object.get("jobName")));
    let company_name = coerce_text(object.get("company").or_else(|| object.get("brandName")));
    let security_id = coerce_text(object.get("securityId"));
    let encrypt_job_id = coerce_text(
        object
            .get("encryptId")
            .or_else(|| object.get("encryptJobId"))
            .or_else(|| object.get("jobId")),
    );
    if job_name.is_empty() && company_name.is_empty() && security_id.is_empty() {
        return None;
    }
    let labels = normalize_cardlist_labels(object.get("jobLabels"));
    Some(json!({
        "jobName": job_name,
        "brandName": company_name,
        "salaryDesc": coerce_text(object.get("salaryDesc")),
        "cityName": coerce_text(object.get("city")),
        "areaDistrict": coerce_text(object.get("areaDistrict")),
        "jobExperience": coerce_text(object.get("experienceName")),
        "jobDegree": coerce_text(object.get("degreeName")),
        "jobLabels": labels,
        "skills": labels,
        "securityId": security_id,
        "encryptJobId": encrypt_job_id,
        "activeTimeDesc": coerce_text(object.get("activeTimeDesc").or_else(|| object.get("distance"))),
        "bossInfo": {
            "name": coerce_text(object.get("name")),
            "title": coerce_text(object.get("title")),
        }
    }))
}

fn normalize_cardlist_labels(value: Option<&Value>) -> Vec<String> {
    let Some(Value::Array(items)) = value else {
        return Vec::new();
    };
    let mut labels = Vec::new();
    for item in items {
        let text = match item {
            Value::String(text) => text.to_string(),
            Value::Object(object) => ["name", "labelName", "text", "content", "title"]
                .iter()
                .find_map(|key| object.get(*key).and_then(Value::as_str))
                .unwrap_or_default()
                .to_string(),
            other => other.to_string(),
        };
        if !text.is_empty() {
            labels.push(text);
        }
    }
    labels
}

fn coerce_text(value: Option<&Value>) -> String {
    match value {
        Some(Value::String(text)) => {
            let trimmed = text.trim();
            if trimmed.starts_with('{') {
                if let Ok(parsed) = serde_json::from_str::<Value>(trimmed) {
                    if let Some(name) = parsed.get("name").and_then(Value::as_str) {
                        return name.to_string();
                    }
                }
            }
            text.to_string()
        }
        Some(Value::Object(object)) => {
            if let Some(name) = object.get("name").and_then(Value::as_str) {
                return name.to_string();
            }
            if let Some(text) = object.get("text").and_then(Value::as_str) {
                return text.to_string();
            }
            Value::Object(object.clone()).to_string()
        }
        Some(Value::Number(number)) => number.to_string(),
        Some(other) => other.to_string(),
        None => String::new(),
    }
}

fn find_job_list(payload: &Value) -> Option<Vec<Value>> {
    find_job_list_recursive(payload, 0)
}

fn find_job_list_recursive(value: &Value, depth: usize) -> Option<Vec<Value>> {
    if depth > 6 {
        return None;
    }
    if let Some(items) = as_job_list(value) {
        return Some(items);
    }
    match value {
        Value::Object(object) => {
            for key in ["jobList", "jobs", "list", "data", "zpData"] {
                if let Some(nested) = object.get(key) {
                    if let Some(hit) = find_job_list_recursive(nested, depth + 1) {
                        return Some(hit);
                    }
                }
            }
            for nested in object.values() {
                if let Some(hit) = find_job_list_recursive(nested, depth + 1) {
                    return Some(hit);
                }
            }
            None
        }
        Value::Array(items) => {
            for nested in items {
                if let Some(hit) = find_job_list_recursive(nested, depth + 1) {
                    return Some(hit);
                }
            }
            None
        }
        _ => None,
    }
}

fn as_job_list(value: &Value) -> Option<Vec<Value>> {
    let Value::Array(items) = value else {
        return None;
    };
    if items.is_empty() {
        return None;
    }
    let all_objects = items.iter().all(|item| item.is_object());
    if !all_objects {
        return None;
    }
    let has_job_shape = items.iter().any(|item| {
        let Some(object) = item.as_object() else {
            return false;
        };
        object.contains_key("encryptJobId")
            || object.contains_key("jobName")
            || object.contains_key("brandName")
    });
    if has_job_shape {
        Some(items.clone())
    } else {
        None
    }
}

fn has_jobs(payload: &Value) -> bool {
    find_job_list(payload)
        .map(|jobs| !jobs.is_empty())
        .unwrap_or(false)
}

fn summarize_jobs(jobs: &[Value]) -> Value {
    let first = jobs.first().cloned().unwrap_or_else(|| json!({}));
    json!({
        "job_count": jobs.len(),
        "first_job": {
            "jobName": first.get("jobName").cloned().unwrap_or(Value::Null),
            "brandName": first.get("brandName").cloned().unwrap_or(Value::Null),
            "salaryDesc": first.get("salaryDesc").cloned().unwrap_or(Value::Null),
            "securityId": first.get("securityId").cloned().unwrap_or(Value::Null),
            "encryptJobId": first.get("encryptJobId").cloned().unwrap_or(Value::Null),
        }
    })
}

#[cfg(test)]
mod tests {
    use super::*;

    struct FakeSigner {
        encoded_body: Vec<u8>,
        signatures: std::cell::RefCell<Vec<String>>,
    }

    impl FakeSigner {
        fn new(encoded_body: &[u8]) -> Self {
            Self {
                encoded_body: encoded_body.to_vec(),
                signatures: std::cell::RefCell::new(Vec::new()),
            }
        }
    }

    impl BossSigner for FakeSigner {
        fn encode_request(&self, data: &[u8], _key: &str) -> Result<String> {
            let text = String::from_utf8_lossy(data);
            if text.starts_with("A-") {
                Ok("ZP_TAG".to_string())
            } else {
                Ok("SP".to_string())
            }
        }

        fn encode_request_body(&self, _data: &[u8], _key: &str) -> Result<Vec<u8>> {
            Ok(self.encoded_body.clone())
        }

        fn signature(&self, data: &[u8], _key: &str) -> Result<String> {
            self.signatures
                .borrow_mut()
                .push(String::from_utf8_lossy(data).to_string());
            Ok("SIG".to_string())
        }

        fn decode_content(&self, _content: &str, _key: &str) -> Result<Vec<u8>> {
            Ok(Vec::new())
        }

        fn describe(&self) -> Value {
            json!({})
        }
    }

    fn sample_session() -> SessionConfig {
        SessionConfig {
            uid: "1".to_string(),
            identity: "0".to_string(),
            token2: "tok2".to_string(),
            zp_at: "zp".to_string(),
            secret_key: "secret".to_string(),
            fp_uniqid: "uniq".to_string(),
            fp_did: "did".to_string(),
            fp_oaid: "oaid".to_string(),
            fp_oaid_honor: "honor".to_string(),
            fp_brand: "realme".to_string(),
            fp_model: "realme||RMX3560".to_string(),
            fp_network: "wifi".to_string(),
            fp_operator: "operator".to_string(),
            fp_tinker_id: "tinker".to_string(),
            ..SessionConfig::default()
        }
    }

    #[test]
    fn search_batch_method_feed_keeps_runtime_method_list_shape() {
        let feed = build_search_batch_method_feed(&materialize_profile_methods(
            "state",
            SEARCH_BATCH_PROFILE_STATE,
        ));
        assert!(feed.contains("\"method=zpgeek.app.interaction.query\""));
        assert!(feed.contains("\"method=zpgeek.cvapp.geek.baseinfo.query&subLocation=0&userId=0\""));
        assert!(!feed.contains("query=python"));
    }

    #[test]
    fn stage2_body_keeps_business_params_inside_subreqs() {
        let body = build_stage2_body_json(
            &SearchOptions {
                keyword: "python".to_string(),
                city_code: "101010100".to_string(),
                page: "2".to_string(),
                page_size: "20".to_string(),
            },
            Some(&ExpectContext {
                encrypt_expect_id: "enc123".to_string(),
                expect_id: "exp456".to_string(),
                city_code: "101010100".to_string(),
            }),
        );
        let body_obj: Value = serde_json::from_str(&body).unwrap();
        let cardlist_qs = body_obj["subReqs"][0]["query"].as_str().unwrap();
        let listad_qs = body_obj["subReqs"][1]["query"].as_str().unwrap();
        assert!(
            cardlist_qs.contains("encryptExpectId\\u003denc123")
                || cardlist_qs.contains("encryptExpectId=enc123")
        );
        assert!(
            listad_qs.contains("encryptExpectId\\u003denc123")
                || listad_qs.contains("encryptExpectId=enc123")
        );
        assert!(body.contains("\\u003d"));
        assert!(body.contains("\\u0026"));
    }

    #[test]
    fn stage2_signature_uses_crc32_of_encoded_body() {
        let session = sample_session();
        let device = DeviceConfig::from_session(&session);
        let signer = FakeSigner::new(b"encoded-body");
        let request = PreparedStage2Request::sign(
            &SearchOptions {
                keyword: "python".to_string(),
                city_code: "101010100".to_string(),
                page: "1".to_string(),
                page_size: "20".to_string(),
            },
            None,
            DEFAULT_SEARCH_HOST,
            &device,
            &session,
            &signer,
            123,
            "A-fixed",
        )
        .unwrap();
        let query = Url::parse(&request.url)
            .unwrap()
            .query_pairs()
            .into_owned()
            .collect::<HashMap<String, String>>();
        assert_eq!(query.get("app_id").map(String::as_str), Some(APP_ID));
        assert!(!query.contains_key("encryptExpectId"));

        let crc = crc32fast::hash(b"encoded-body");
        let sig_input = signer.signatures.borrow().first().cloned().unwrap();
        assert!(sig_input.starts_with(SEARCH_STAGE2_PATH));
        assert!(sig_input.ends_with(&crc.to_string()));
    }

    #[test]
    fn normalize_search_payload_extracts_cardlist_jobs() {
        let payload = json!({
            "code": 0,
            "zpData": {
                SEARCH_CARDLIST_PATH: {
                    "code": 0,
                    "zpData": {
                        "cardList": [
                            {
                                "hasMore": true,
                                "totalCount": 1,
                                "positionSearchCardList": [
                                    {
                                        "positionName": "Python",
                                        "brandName": "Acme",
                                        "securityId": "sec1",
                                        "encryptJobId": "enc1"
                                    }
                                ]
                            }
                        ]
                    }
                }
            }
        });
        let normalized = normalize_search_payload(&payload);
        let jobs = find_job_list(&normalized).unwrap();
        assert_eq!(jobs.len(), 1);
        assert_eq!(
            jobs[0].get("jobName").and_then(Value::as_str),
            Some("Python")
        );
    }

    #[test]
    fn coerce_text_unwraps_json_string_name() {
        assert_eq!(
            coerce_text(Some(&Value::String(
                "{\"name\":\"Python工程师\"}".to_string()
            ))),
            "Python工程师"
        );
        assert_eq!(
            coerce_text(Some(&json!({"name":"Python测试"}))),
            "Python测试"
        );
    }
}
