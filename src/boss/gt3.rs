use std::collections::HashMap;
use std::path::PathBuf;

use anyhow::{anyhow, Context, Result};
use base64::engine::general_purpose::STANDARD as BASE64_STANDARD;
use base64::Engine;
use boa_engine::{Context as BoaContext, Source};
use chrono::Utc;
use reqwest::blocking::Client;
use reqwest::Url;
use rnidbg_boss_gt3::{
    boss_apk_gt3_call_chain, boss_apk_gt3_call_chain_markdown,
    run_gt3_exchange_with_manual_trajectory_and_proof_selection_blocking,
    Gt3ManualTrajectoryRequest, Gt3ProductionProofTruth, Gt3ProofSelection, Gt3ProofSource,
    TrajectoryPoint,
};
use serde_json::{json, Value};

pub fn run_gt3_call_chain(opts: &HashMap<String, String>) -> Result<Value> {
    let format = opts
        .get("--format")
        .map(|value| value.trim().to_ascii_lowercase())
        .unwrap_or_else(|| "json".to_string());
    let report = boss_apk_gt3_call_chain();
    let markdown = boss_apk_gt3_call_chain_markdown();
    let output = json!({
        "ok": true,
        "format": format,
        "call_chain": report,
        "markdown": markdown,
        "contract_alignment": {
            "apk_flow": "MachineVerifyActivity -> c4 -> p50.d -> GT3GeetestUtils -> onDialogResult -> captcha/validate",
            "web_flow_boundary": "Web image matching is analysis-only and does not replace APK-owned provider execution",
            "native_boundary": "libyzwg.so signs requests but is not the GT3 engine",
        }
    });
    write_optional_output(opts, "gt3_call_chain.json", &output)?;
    Ok(output)
}

pub fn run_gt3_app3_protocol(opts: &HashMap<String, String>) -> Result<Value> {
    let client = Client::builder()
        .danger_accept_invalid_certs(false)
        .build()
        .context("failed to build reqwest client")?;
    let debug = opts
        .get("--debug")
        .map(|value| parse_bool(value))
        .unwrap_or(false);
    let simulate_success = opts
        .get("--simulate-success")
        .map(|value| parse_bool(value))
        .unwrap_or(true);

    let (app3_url, bootstrap, gettype_data, app3_url_raw) = if let Some(url) = opts.get("--url") {
        (
            Url::parse(url).with_context(|| format!("invalid --url: {url}"))?,
            json!({
                "source": "url",
                "url": url,
                "app3_url_raw": url,
            }),
            None,
            url.to_string(),
        )
    } else {
        build_app3_url_from_trace(opts, &client)?
    };

    let html = client
        .get(app3_url.clone())
        .send()
        .with_context(|| format!("failed to fetch app3-index: {app3_url}"))?
        .text()
        .with_context(|| format!("failed to read app3-index body: {app3_url}"))?;
    let script = extract_inline_script(&html)?;

    let boa_report = run_app3_script_in_boa(&script, &app3_url_raw, simulate_success)?;
    let script_loads = boa_report
        .get("script_loads")
        .and_then(Value::as_array)
        .cloned()
        .unwrap_or_default();
    let first_script_url = script_loads
        .iter()
        .filter_map(Value::as_str)
        .find(|value| !value.is_empty())
        .map(ToOwned::to_owned);

    let external_js = fetch_external_js(&client, &boa_report, first_script_url.as_deref())?;

    let output = json!({
        "ok": true,
        "mode": "app3-index-js-protocol",
        "app3_url": app3_url.as_str(),
        "bootstrap": bootstrap,
        "gettype_data": gettype_data,
        "app3_html": {
            "bytes": html.len(),
            "js_markers": collect_markers(&script),
        },
        "boa": {
            "simulate_success": simulate_success,
            "debug": debug,
            "report": boa_report,
        },
        "external_js": external_js,
        "protocol_summary": {
            "query_contract": "app3-index expects gt/challenge/type/api_server/static_servers and one dynamic js path param named by type (fullpage|click|slide).",
            "callback_contract": "JSInterface.gtCallBack(code, result_json, message) where result_json includes geetest_challenge/geetest_validate/geetest_seccode on success.",
            "switch_contract": "onChangeCaptcha emits JSInterface.gtNotify({aspect_radio}) and reloads type-specific js via static_servers.",
        },
    });
    write_optional_output(opts, "gt3_app3_protocol.json", &output)?;
    Ok(output)
}

pub fn run_gt3_manual_trajectory(opts: &HashMap<String, String>) -> Result<Value> {
    let proof_source = parse_proof_source(opts)?;
    let trace = load_optional_trace_json(opts)?;
    let production_truth = load_production_proof_truth(opts, trace.as_ref())?;
    if proof_source.requires_production_truth() && production_truth.is_none() {
        return Err(anyhow!(
            "missing production_proof_truth in --trace-json (default --proof-source=production-truth fails closed); use --proof-source legacy to bypass"
        ));
    }

    let mut register_payload =
        load_optional_json_value(opts, "--register-json", "--register-path")?;
    if register_payload.is_none() && proof_source.requires_production_truth() {
        register_payload = trace
            .as_ref()
            .and_then(|value| value.pointer("/gt3_exchange/register"))
            .cloned();
    }
    let start = trace
        .as_ref()
        .and_then(|value| value.get("start_captcha"))
        .and_then(Value::as_object);
    let register_from_trace = trace
        .as_ref()
        .and_then(|value| value.pointer("/gt3_exchange/register"))
        .and_then(Value::as_object);
    let register_from_payload = register_payload.as_ref().and_then(|value| {
        value
            .get("data")
            .and_then(Value::as_object)
            .or_else(|| value.as_object())
    });
    let register = register_from_payload.or(register_from_trace);

    let truth_gt = production_truth
        .as_ref()
        .and_then(|truth| truth_string(&truth.value, "gt"));
    let truth_bootstrap_challenge = production_truth
        .as_ref()
        .and_then(|truth| truth_string(&truth.value, "bootstrap_challenge"));
    let truth_final_challenge = production_truth
        .as_ref()
        .and_then(|truth| truth_string(&truth.value, "final_challenge"));
    let truth_followup_challenge = production_truth
        .as_ref()
        .and_then(|truth| truth_string(&truth.value, "followup_challenge"));
    let truth_runtime_challenge = truth_final_challenge
        .clone()
        .or(truth_followup_challenge.clone())
        .or(truth_bootstrap_challenge.clone());

    let gt = opts
        .get("--gt")
        .map(|value| value.trim().to_string())
        .filter(|value| !value.is_empty())
        .or_else(|| truth_gt.clone())
        .or_else(|| {
            start
                .and_then(|obj| object_string(obj, "gt"))
                .map(str::to_string)
        })
        .ok_or_else(|| anyhow!("missing --gt (or trace start_captcha.gt)"))?;
    let bootstrap_challenge = opts
        .get("--bootstrap-challenge")
        .map(|value| value.trim().to_string())
        .filter(|value| !value.is_empty())
        .or_else(|| truth_bootstrap_challenge.clone())
        .or_else(|| {
            start
                .and_then(|obj| object_string(obj, "challenge"))
                .map(str::to_string)
        });
    let challenge = opts
        .get("--challenge")
        .map(|value| value.trim().to_string())
        .filter(|value| !value.is_empty())
        .or_else(|| truth_runtime_challenge.clone())
        .or_else(|| {
            trace
                .as_ref()
                .and_then(|value| value.pointer("/gt3_exchange/challenge"))
                .and_then(Value::as_str)
                .map(str::to_string)
        })
        .or_else(|| {
            register_payload
                .as_ref()
                .and_then(|value| value.get("challenge"))
                .and_then(Value::as_str)
                .map(str::to_string)
        })
        .or_else(|| {
            start
                .and_then(|obj| object_string(obj, "challenge"))
                .map(str::to_string)
        })
        .ok_or_else(|| anyhow!("missing --challenge"))?;
    if proof_source.requires_production_truth() {
        let truth = production_truth.as_ref().expect("checked above");
        let expected_gt = truth_string(&truth.value, "gt")
            .ok_or_else(|| anyhow!("production_proof_truth missing required field: gt"))?;
        if gt != expected_gt {
            return Err(anyhow!(
                "requested gt does not match production_proof_truth.gt (expected={expected_gt}, got={gt})"
            ));
        }
        let expected_challenge = truth_runtime_challenge.clone().ok_or_else(|| {
            anyhow!(
                "production_proof_truth missing challenge fields; require at least one of final_challenge|followup_challenge|bootstrap_challenge"
            )
        })?;
        if challenge != expected_challenge {
            return Err(anyhow!(
                "requested challenge does not match production_proof_truth challenge (expected={expected_challenge}, got={challenge})"
            ));
        }
    }
    let offset_x = opts
        .get("--offset-x")
        .map(|value| value.trim())
        .filter(|value| !value.is_empty())
        .ok_or_else(|| anyhow!("missing --offset-x <px>"))?
        .parse::<u32>()
        .context("invalid --offset-x")?;
    let trajectory = load_trajectory_points(opts)?;
    if trajectory.is_empty() {
        return Err(anyhow!("trajectory must contain at least one point"));
    }

    let truth_api_server = production_truth
        .as_ref()
        .and_then(|truth| truth_string(&truth.value, "request_url"))
        .and_then(|url| origin_from_url(&url));
    let api_server = opts
        .get("--gt3-api-server")
        .or_else(|| opts.get("--api-server"))
        .map(|value| value.trim().to_string())
        .filter(|value| !value.is_empty())
        .or_else(|| {
            register
                .and_then(|obj| object_string(obj, "api_server"))
                .map(str::to_string)
        })
        .or(truth_api_server);
    let static_server = opts
        .get("--gt3-static-server")
        .or_else(|| opts.get("--static-server"))
        .map(|value| value.trim().to_string())
        .filter(|value| !value.is_empty())
        .or_else(|| {
            register
                .and_then(|obj| object_string(obj, "static_server"))
                .map(str::to_string)
        });
    let truth_user_agent = production_truth
        .as_ref()
        .and_then(|truth| truth_string(&truth.value, "ua"));
    let user_agent = opts
        .get("--gt3-user-agent")
        .or_else(|| opts.get("--user-agent"))
        .map(|value| value.trim().to_string())
        .filter(|value| !value.is_empty())
        .or(truth_user_agent);

    let request = Gt3ManualTrajectoryRequest {
        gt,
        challenge,
        bootstrap_challenge,
        offset_x,
        trajectory,
        register_payload,
        api_server,
        static_server,
        user_agent,
    };
    let proof_selection = Gt3ProofSelection {
        proof_source: match proof_source {
            ProofSource::ProductionTruth => Gt3ProofSource::ProductionTruth,
            ProofSource::Legacy => Gt3ProofSource::Legacy,
        },
        production_proof_truth: production_truth
            .as_ref()
            .map(|truth| serde_json::from_value::<Gt3ProductionProofTruth>(truth.value.clone()))
            .transpose()
            .context("failed to parse production_proof_truth into GT3 proof contract")?,
    };
    let result = run_gt3_exchange_with_manual_trajectory_and_proof_selection_blocking(
        request.clone(),
        proof_selection,
    )?;
    let truth_snapshot = production_truth
        .as_ref()
        .map(|truth| truth_snapshot(&truth.value))
        .unwrap_or(Value::Null);
    let runtime_w_looks_base64_json = looks_like_base64_json(&result.w_param);
    let truth_w = production_truth
        .as_ref()
        .and_then(|truth| truth_string(&truth.value, "w"));
    let truth_w_length = production_truth
        .as_ref()
        .and_then(|truth| truth.value.get("w_length"))
        .and_then(Value::as_u64)
        .or_else(|| truth_w.as_ref().map(|value| value.len() as u64));
    let ajax_request_shape = json!({
        "runtime": result.ajax_request_shape,
        "production_truth": production_truth.as_ref().map(|truth| {
            json!({
                "http_method": truth_string(&truth.value, "http_method"),
                "request_url": truth_string(&truth.value, "request_url"),
                "query_shape": truth.value.get("query_shape").cloned(),
                "body_shape": truth.value.get("body_shape").cloned(),
                "client_type": truth_string(&truth.value, "client_type"),
                "pt": truth_string(&truth.value, "pt"),
            })
        }),
    });
    let w_characteristics = json!({
        "runtime": result.w_characteristics,
        "production_truth": {
            "present": truth_w.is_some(),
            "length": truth_w_length,
            "looks_base64_json": truth_w.as_deref().map(looks_like_base64_json),
        },
        "runtime_equals_truth": truth_w.as_deref().map(|truth| truth == result.w_param).unwrap_or(false),
    });
    let output = json!({
        "ok": true,
        "mode": "gt3-manual-trajectory",
        "proof_source": proof_source.as_str(),
        "proof_contract": {
            "default_source": ProofSource::default().as_str(),
            "selected_source": proof_source.as_str(),
            "production_truth_required": proof_source.requires_production_truth(),
            "production_truth_present": production_truth.is_some(),
            "production_truth_location": production_truth.as_ref().map(|truth| truth.location.clone()),
            "production_truth_snapshot": truth_snapshot,
            "fail_closed_on_missing_truth": true,
            "effective": result.proof_contract,
        },
        "ajax_request_shape": ajax_request_shape,
        "w_characteristics": w_characteristics,
        "request": {
            "gt": request.gt,
            "challenge": request.challenge,
            "bootstrap_challenge": request.bootstrap_challenge,
            "offset_x": request.offset_x,
            "trajectory_point_count": request.trajectory.len(),
            "register_payload_present": request.register_payload.is_some(),
            "api_server": request.api_server,
            "static_server": request.static_server,
            "user_agent": request.user_agent,
        },
        "exchange": result,
    });
    write_optional_output(opts, "gt3_manual_trajectory.json", &output)?;
    Ok(output)
}

#[derive(Debug, Clone, Copy, Eq, PartialEq)]
enum ProofSource {
    ProductionTruth,
    Legacy,
}

impl Default for ProofSource {
    fn default() -> Self {
        Self::ProductionTruth
    }
}

impl ProofSource {
    fn as_str(self) -> &'static str {
        match self {
            Self::ProductionTruth => "production-truth",
            Self::Legacy => "legacy",
        }
    }

    fn requires_production_truth(self) -> bool {
        matches!(self, Self::ProductionTruth)
    }
}

#[derive(Debug, Clone)]
struct ProductionProofTruth {
    location: String,
    value: Value,
}

fn parse_proof_source(opts: &HashMap<String, String>) -> Result<ProofSource> {
    let raw = opts
        .get("--proof-source")
        .map(|value| value.trim().to_ascii_lowercase())
        .unwrap_or_else(|| ProofSource::default().as_str().to_string());
    match raw.as_str() {
        "production-truth" => Ok(ProofSource::ProductionTruth),
        "legacy" => Ok(ProofSource::Legacy),
        _ => Err(anyhow!(
            "invalid --proof-source: {raw} (expected production-truth|legacy)"
        )),
    }
}

fn load_production_proof_truth(
    opts: &HashMap<String, String>,
    trace: Option<&Value>,
) -> Result<Option<ProductionProofTruth>> {
    let inline_or_path = load_optional_json_value(
        opts,
        "--production-proof-truth-json",
        "--production-proof-truth-path",
    )?
    .or_else(|| {
        load_optional_json_value(opts, "--gt3-proof-truth-json", "--gt3-proof-truth-path")
            .ok()
            .flatten()
    })
    .or_else(|| {
        load_optional_json_value(opts, "--gt3-proof-request-json", "--gt3-proof-request-file")
            .ok()
            .flatten()
    });
    if let Some(value) = inline_or_path {
        return Ok(
            normalize_truth_value(&value).map(|normalized| ProductionProofTruth {
                location: "cli".to_string(),
                value: normalized,
            }),
        );
    }
    let Some(trace) = trace else {
        return Ok(None);
    };
    let candidates = [
        ("/production_proof_truth", "trace.production_proof_truth"),
        ("/gt3_proof_truth", "trace.gt3_proof_truth"),
        (
            "/debug_session/production_proof_truth",
            "trace.debug_session.production_proof_truth",
        ),
        (
            "/debug_session/gt3_proof_truth",
            "trace.debug_session.gt3_proof_truth",
        ),
    ];
    for (path, location) in candidates {
        if let Some(value) = trace.pointer(path) {
            if let Some(normalized) = normalize_truth_value(value) {
                return Ok(Some(ProductionProofTruth {
                    location: location.to_string(),
                    value: normalized,
                }));
            }
        }
    }
    Ok(
        normalize_truth_value(trace).map(|value| ProductionProofTruth {
            location: "trace.root".to_string(),
            value,
        }),
    )
}

fn normalize_truth_value(value: &Value) -> Option<Value> {
    match value {
        Value::Object(_) => {
            if looks_like_production_truth(value) {
                Some(value.clone())
            } else {
                None
            }
        }
        Value::String(raw) => serde_json::from_str::<Value>(raw).ok().and_then(|parsed| {
            if looks_like_production_truth(&parsed) {
                Some(parsed)
            } else {
                None
            }
        }),
        _ => None,
    }
}

fn looks_like_production_truth(value: &Value) -> bool {
    if !value.is_object() {
        return false;
    }
    let has_gt = truth_string(value, "gt").is_some();
    let has_challenge = truth_string(value, "final_challenge")
        .or_else(|| truth_string(value, "followup_challenge"))
        .or_else(|| truth_string(value, "bootstrap_challenge"))
        .or_else(|| truth_string(value, "challenge"))
        .is_some();
    let has_request_shape =
        value.get("request_url").is_some() || value.get("query_shape").is_some();
    has_gt && (has_challenge || has_request_shape)
}

fn truth_string(value: &Value, key: &str) -> Option<String> {
    value
        .get(key)
        .and_then(Value::as_str)
        .map(str::trim)
        .filter(|item| !item.is_empty())
        .map(str::to_string)
}

fn origin_from_url(raw: &str) -> Option<String> {
    let parsed = Url::parse(raw).ok()?;
    let host = parsed.host_str()?;
    Some(match parsed.port() {
        Some(port) => format!("{}://{}:{port}", parsed.scheme(), host),
        None => format!("{}://{host}", parsed.scheme()),
    })
}

fn truth_snapshot(value: &Value) -> Value {
    json!({
        "gt": truth_string(value, "gt"),
        "bootstrap_challenge": truth_string(value, "bootstrap_challenge"),
        "followup_challenge": truth_string(value, "followup_challenge"),
        "final_challenge": truth_string(value, "final_challenge"),
        "client_type": truth_string(value, "client_type"),
        "pt": truth_string(value, "pt"),
        "http_method": truth_string(value, "http_method"),
        "request_url": truth_string(value, "request_url"),
        "w_length": value.get("w_length").cloned(),
        "proof_source_tag": truth_string(value, "proof_source_tag"),
    })
}

fn looks_like_base64_json(raw: &str) -> bool {
    let value = raw.trim();
    if value.is_empty() {
        return false;
    }
    let Ok(decoded) = BASE64_STANDARD.decode(value) else {
        return false;
    };
    let Ok(decoded_text) = std::str::from_utf8(&decoded) else {
        return false;
    };
    serde_json::from_str::<Value>(decoded_text).is_ok()
}

fn build_app3_url_from_trace(
    opts: &HashMap<String, String>,
    client: &Client,
) -> Result<(Url, Value, Option<Value>, String)> {
    let trace_path = opts
        .get("--trace-json")
        .cloned()
        .or_else(|| {
            let fallback = "/tmp/captcha-trace-44-click.json";
            if std::path::Path::new(fallback).is_file() {
                Some(fallback.to_string())
            } else {
                None
            }
        })
        .ok_or_else(|| anyhow!("missing --trace-json (or --url)"))?;

    let trace_raw = std::fs::read(&trace_path)
        .with_context(|| format!("failed to read trace json: {trace_path}"))?;
    let trace: Value = serde_json::from_slice(&trace_raw)
        .with_context(|| format!("failed to parse trace json: {trace_path}"))?;

    let start = trace
        .get("start_captcha")
        .and_then(Value::as_object)
        .ok_or_else(|| anyhow!("trace missing start_captcha object"))?;
    let gt = object_string(start, "gt")
        .ok_or_else(|| anyhow!("trace start_captcha missing gt"))?
        .to_string();
    let challenge = object_string(start, "challenge")
        .ok_or_else(|| anyhow!("trace start_captcha missing challenge"))?
        .to_string();

    let register = trace
        .pointer("/gt3_exchange/register")
        .and_then(Value::as_object);
    let api_server = register
        .and_then(|obj| object_string(obj, "api_server"))
        .or_else(|| opts.get("--gt3-api-server").map(String::as_str))
        .unwrap_or("https://apiv6.geetest.com");
    let api_host = normalize_domain(api_server);
    let trace_type = register
        .and_then(|obj| object_string(obj, "captcha_type"))
        .unwrap_or("fullpage");
    let type_name = opts
        .get("--type")
        .map(|value| value.trim().to_string())
        .unwrap_or_else(|| trace_type.to_string());
    let lang = opts
        .get("--lang")
        .map(|value| value.trim().to_string())
        .unwrap_or_else(|| "zh-cn".to_string());
    let timeout = opts
        .get("--timeout")
        .map(|value| value.trim().to_string())
        .unwrap_or_else(|| "10000".to_string());

    let gettype_url = Url::parse_with_params(
        &format!("https://{api_host}/gettype.php"),
        [
            ("gt", gt.as_str()),
            ("t", &Utc::now().timestamp_millis().to_string()),
        ],
    )
    .context("failed to build gettype url")?;
    let gettype_raw = client
        .get(gettype_url.clone())
        .send()
        .with_context(|| format!("failed GET {}", gettype_url))?
        .text()
        .with_context(|| format!("failed read gettype body: {}", gettype_url))?;
    let gettype_response = parse_json_or_jsonp(&gettype_raw)
        .with_context(|| format!("failed parse gettype json: {}", gettype_url))?;
    let gettype_data = gettype_response
        .get("data")
        .cloned()
        .ok_or_else(|| anyhow!("gettype response missing data field"))?;
    let gettype_obj = gettype_data
        .as_object()
        .ok_or_else(|| anyhow!("gettype data is not an object"))?;
    let js_path = gettype_obj
        .get(&type_name)
        .and_then(Value::as_str)
        .ok_or_else(|| {
            anyhow!(
                "gettype data missing js path for type={type_name}; available keys: {:?}",
                gettype_obj.keys().collect::<Vec<_>>()
            )
        })?
        .to_string();

    let mut static_servers = gettype_obj
        .get("static_servers")
        .and_then(Value::as_array)
        .map(|items| {
            items
                .iter()
                .filter_map(Value::as_str)
                .map(normalize_domain)
                .map(ToOwned::to_owned)
                .collect::<Vec<_>>()
        })
        .unwrap_or_default();

    if static_servers.is_empty() {
        if let Some(static_server) = register.and_then(|obj| object_string(obj, "static_server")) {
            static_servers.push(normalize_domain(static_server).to_string());
        }
    }
    if static_servers.is_empty() {
        static_servers.push("static.geetest.com".to_string());
    }

    let mut query_pairs = vec![
        format!("gt={gt}"),
        format!("challenge={challenge}"),
        format!("lang={lang}"),
        "title=".to_string(),
        format!("type={type_name}"),
        format!("api_server={api_host}"),
        format!("static_servers={}", static_servers.join(",")),
        "width=100%".to_string(),
        format!("timeout={timeout}"),
        format!(
            "debug={}",
            if opts.get("--debug").map(|v| parse_bool(v)).unwrap_or(false) {
                "true"
            } else {
                "false"
            }
        ),
        format!("{type_name}={js_path}"),
    ];
    if let Some(aspect_radio) = gettype_obj.get("aspect_radio").and_then(Value::as_object) {
        for (kind, ratio) in aspect_radio {
            if let Some(ratio_value) = ratio.as_i64() {
                query_pairs.push(format!("aspect_radio_{kind}={ratio_value}"));
            }
        }
    }

    let app3_url_raw = format!(
        "https://{}/static/appweb/app3-index.html?{}",
        static_servers[0],
        query_pairs.join("&")
    );
    let app3_url = Url::parse(&app3_url_raw).context("failed to build app3-index url")?;

    Ok((
        app3_url,
        json!({
            "source": "trace-json",
            "trace_json": trace_path,
            "gettype_url": gettype_url.as_str(),
            "gt": gt,
            "challenge": challenge,
            "type": type_name,
            "api_server": api_host,
            "static_servers": static_servers,
            "js_path": js_path,
            "app3_url_raw": app3_url_raw,
        }),
        Some(gettype_data),
        app3_url_raw,
    ))
}

fn run_app3_script_in_boa(script: &str, app3_url: &str, simulate_success: bool) -> Result<Value> {
    let protocol = if app3_url.starts_with("https://") {
        "https:"
    } else {
        "http:"
    };
    let href_literal = serde_json::to_string(app3_url)?;
    let protocol_literal = serde_json::to_string(protocol)?;
    let prelude = format!(
        r#"
var __scriptLoads = [];
var __callbacks = [];
var __logs = [];
var __nodes = {{}};
var window = globalThis;
window.window = window;
window.startTime = 0;
var location = {{ href: {href}, protocol: {protocol} }};
window.location = location;
var headNode = {{
  appendChild: function(node) {{
    __scriptLoads.push(String(node.src || ""));
    if (typeof node.onload === 'function') {{
      node.readyState = 'complete';
      node.onload();
    }} else if (typeof node.onreadystatechange === 'function') {{
      node.readyState = 'complete';
      node.onreadystatechange();
    }}
  }},
  removeChild: function(_node) {{}}
}};
function __makeNode(id) {{
  return {{
    id: id || '',
    className: '',
    style: {{}},
    children: [],
    appendChild: function(v) {{ this.children.push(v); }},
    insertBefore: function(v, _before) {{ this.children.unshift(v); }},
    setAttribute: function(k, v) {{ this[k] = v; }}
  }};
}}
var document = {{
  createElement: function(tag) {{
    if (tag === 'script') {{
      return {{ tagName: 'SCRIPT', src: '', onload: null, onreadystatechange: null, onerror: null, readyState: '' }};
    }}
    return __makeNode(tag);
  }},
  createTextNode: function(text) {{ return {{ textContent: String(text) }}; }},
  getElementById: function(id) {{
    if (!__nodes[id]) __nodes[id] = __makeNode(id);
    return __nodes[id];
  }},
  getElementsByTagName: function(tag) {{
    if (tag === 'head') return [headNode];
    return [__makeNode(tag)];
  }}
}};
window.document = document;
window.JSInterface = {{
  gtCallBack: function(code, result, message) {{
    __callbacks.push({{ fn: 'gtCallBack', code: String(code), result: String(result), message: String(message) }});
  }},
  gtReady: function() {{
    __callbacks.push({{ fn: 'gtReady' }});
  }},
  gtClose: function() {{
    __callbacks.push({{ fn: 'gtClose' }});
  }},
  gtNotify: function(payload) {{
    __callbacks.push({{ fn: 'gtNotify', payload: String(payload) }});
  }},
  gtError: function() {{
    __callbacks.push({{ fn: 'gtError' }});
  }},
  gt3Error: function(payload) {{
    __callbacks.push({{ fn: 'gt3Error', payload: payload === undefined ? null : String(payload) }});
  }}
}};
window.webkit = {{
  messageHandlers: {{
    wkWebview: {{ postMessage: function(msg) {{ __callbacks.push({{ fn: 'wkWebview', payload: String(msg) }}); }} }},
    gtError: {{ postMessage: function(msg) {{ __callbacks.push({{ fn: 'wkGtError', payload: String(msg) }}); }} }},
    gt3Error: {{ postMessage: function(msg) {{ __callbacks.push({{ fn: 'wkGt3Error', payload: String(msg) }}); }} }},
    gtReady: {{ postMessage: function(msg) {{ __callbacks.push({{ fn: 'wkGtReady', payload: String(msg) }}); }} }},
    gtClose: {{ postMessage: function(msg) {{ __callbacks.push({{ fn: 'wkGtClose', payload: String(msg) }}); }} }},
    gtNotify: {{ postMessage: function(msg) {{ __callbacks.push({{ fn: 'wkGtNotify', payload: String(msg) }}); }} }}
  }}
}};
function Geetest(cfg) {{
  this.cfg = cfg;
  this._events = {{}};
  window.__captchaObj = this;
}}
Geetest.prototype.appendTo = function(_node) {{ return this; }};
Geetest.prototype.getValidate = function() {{
  return {{
    geetest_challenge: 'mock_geetest_challenge',
    geetest_validate: 'mock_geetest_validate',
    geetest_seccode: 'mock_geetest_seccode'
  }};
}};
Geetest.prototype.onSuccess = function(cb) {{ this._events.success = cb; return this; }};
Geetest.prototype.onFail = function(cb) {{ this._events.fail = cb; return this; }};
Geetest.prototype.onReady = function(cb) {{ this._events.ready = cb; return this; }};
Geetest.prototype.onClose = function(cb) {{ this._events.close = cb; return this; }};
Geetest.prototype.onError = function(cb) {{ this._events.error = cb; return this; }};
Geetest.prototype.onChangeCaptcha = function(cb) {{ this._events.change = cb; return this; }};
window.Geetest = Geetest;
"#,
        href = href_literal,
        protocol = protocol_literal
    );

    let mut ctx = BoaContext::default();
    ctx.eval(Source::from_bytes(&prelude))
        .map_err(|err| anyhow!("boa prelude evaluation failed: {err}"))?;
    ctx.eval(Source::from_bytes(script))
        .map_err(|err| anyhow!("boa app3 script evaluation failed: {err}"))?;

    if simulate_success {
        ctx.eval(Source::from_bytes(
            r#"
if (window.__captchaObj && window.__captchaObj._events && typeof window.__captchaObj._events.ready === "function") {
  window.__captchaObj._events.ready();
}
if (window.__captchaObj && window.__captchaObj._events && typeof window.__captchaObj._events.success === "function") {
  window.__captchaObj._events.success();
}
"#,
        ))
        .map_err(|err| anyhow!("boa simulate success callback failed: {err}"))?;
    }

    let result = ctx
        .eval(Source::from_bytes(
            r#"
JSON.stringify({
  args: (typeof args === "undefined") ? null : args,
  config: (typeof config === "undefined") ? null : config,
  js: (typeof js === "undefined") ? null : js,
  static_servers: (typeof static_servers === "undefined") ? null : static_servers,
  script_loads: __scriptLoads,
  callbacks: __callbacks
})
"#,
        ))
        .map_err(|err| anyhow!("boa report serialization failed: {err}"))?;
    let text = result
        .to_string(&mut ctx)
        .map_err(|err| anyhow!("boa report to_string failed: {err}"))?
        .to_std_string_escaped();
    let value: Value = serde_json::from_str(&text).context("failed to parse boa json report")?;
    Ok(value)
}

fn fetch_external_js(
    client: &Client,
    boa_report: &Value,
    first_script_url: Option<&str>,
) -> Result<Value> {
    let mut candidates = Vec::<String>::new();
    if let Some(url) = first_script_url {
        candidates.push(url.to_string());
    }

    let js_path = boa_report
        .get("js")
        .and_then(Value::as_str)
        .unwrap_or_default();
    let static_servers = boa_report
        .get("static_servers")
        .and_then(Value::as_array)
        .map(|items| {
            items
                .iter()
                .filter_map(Value::as_str)
                .map(normalize_domain)
                .map(ToOwned::to_owned)
                .collect::<Vec<_>>()
        })
        .unwrap_or_default();

    if !js_path.is_empty() {
        if js_path.starts_with("http://") || js_path.starts_with("https://") {
            candidates.push(js_path.to_string());
        } else {
            let normalized_path = normalize_path(js_path);
            for server in static_servers {
                candidates.push(format!(
                    "https://{}{}",
                    normalize_domain(&server),
                    normalized_path
                ));
            }
        }
    }

    candidates.dedup();
    for candidate in &candidates {
        if let Ok(resp) = client.get(candidate).send() {
            if resp.status().is_success() {
                let body = resp
                    .text()
                    .with_context(|| format!("failed to read external js body: {candidate}"))?;
                return Ok(json!({
                    "ok": true,
                    "url": candidate,
                    "bytes": body.len(),
                    "markers": collect_markers(&body),
                }));
            }
        }
    }

    Ok(json!({
        "ok": false,
        "error": "failed to fetch external js from any candidate url",
        "candidates_from_report": candidates,
    }))
}

fn extract_inline_script(html: &str) -> Result<String> {
    let open = "<script>";
    let close = "</script>";
    let start = html
        .find(open)
        .ok_or_else(|| anyhow!("app3 html missing <script>"))?
        + open.len();
    let end_rel = html[start..]
        .find(close)
        .ok_or_else(|| anyhow!("app3 html missing </script>"))?;
    Ok(html[start..start + end_rel].to_string())
}

fn collect_markers(text: &str) -> Value {
    let markers = [
        "Geetest(",
        "gtCallBack(",
        "gtReady(",
        "gtNotify(",
        "onChangeCaptcha",
        "geetest_challenge",
        "geetest_validate",
        "geetest_seccode",
        "api_server",
        "static_servers",
        "fullpage",
        "click",
        "slide",
        "get.php",
        "gettype.php",
        "ajax.php",
    ];
    let mut found = serde_json::Map::new();
    for marker in markers {
        found.insert(marker.to_string(), Value::Bool(text.contains(marker)));
    }
    Value::Object(found)
}

fn normalize_domain(input: &str) -> &str {
    input
        .trim()
        .trim_start_matches("https://")
        .trim_start_matches("http://")
        .trim_end_matches('/')
}

fn load_optional_trace_json(opts: &HashMap<String, String>) -> Result<Option<Value>> {
    let Some(path) = opts
        .get("--trace-json")
        .filter(|value| !value.trim().is_empty())
    else {
        return Ok(None);
    };
    let raw = std::fs::read(path).with_context(|| format!("failed to read trace json: {path}"))?;
    let value = serde_json::from_slice(&raw)
        .with_context(|| format!("failed to parse trace json: {path}"))?;
    Ok(Some(value))
}

fn load_optional_json_value(
    opts: &HashMap<String, String>,
    inline_key: &str,
    path_key: &str,
) -> Result<Option<Value>> {
    if let Some(raw) = opts
        .get(inline_key)
        .map(|value| value.trim())
        .filter(|value| !value.is_empty())
    {
        let value = serde_json::from_str(raw)
            .with_context(|| format!("failed to parse json from {inline_key}"))?;
        return Ok(Some(value));
    }
    if let Some(path) = opts
        .get(path_key)
        .map(|value| value.trim())
        .filter(|value| !value.is_empty())
    {
        let raw = std::fs::read_to_string(path)
            .with_context(|| format!("failed to read json from {path_key}: {path}"))?;
        let value = serde_json::from_str(&raw)
            .with_context(|| format!("failed to parse json from {path_key}: {path}"))?;
        return Ok(Some(value));
    }
    Ok(None)
}

fn load_trajectory_points(opts: &HashMap<String, String>) -> Result<Vec<TrajectoryPoint>> {
    let raw = if let Some(value) = opts
        .get("--trajectory-json")
        .map(|value| value.trim())
        .filter(|value| !value.is_empty())
    {
        value.to_string()
    } else if let Some(path) = opts
        .get("--trajectory-path")
        .map(|value| value.trim())
        .filter(|value| !value.is_empty())
    {
        std::fs::read_to_string(path)
            .with_context(|| format!("failed to read trajectory json: {path}"))?
    } else {
        return Err(anyhow!(
            "missing --trajectory-json <json> or --trajectory-path <path>"
        ));
    };

    let value: Value = serde_json::from_str(&raw).context("invalid trajectory json")?;
    let points = value
        .as_array()
        .ok_or_else(|| anyhow!("trajectory json must be an array"))?;
    let mut trajectory = Vec::with_capacity(points.len());
    for (index, point) in points.iter().enumerate() {
        let obj = point
            .as_object()
            .ok_or_else(|| anyhow!("trajectory point #{index} must be an object"))?;
        let x = obj
            .get("x")
            .and_then(Value::as_i64)
            .ok_or_else(|| anyhow!("trajectory point #{index} missing integer x"))?;
        let y = obj
            .get("y")
            .and_then(Value::as_i64)
            .ok_or_else(|| anyhow!("trajectory point #{index} missing integer y"))?;
        let t_ms = obj
            .get("t_ms")
            .and_then(Value::as_u64)
            .ok_or_else(|| anyhow!("trajectory point #{index} missing integer t_ms"))?;
        trajectory.push(TrajectoryPoint {
            x: x as i32,
            y: y as i32,
            t_ms: t_ms as u32,
        });
    }
    Ok(trajectory)
}

fn normalize_path(path: &str) -> String {
    let mut normalized = path.replace("//", "/");
    if !normalized.starts_with('/') {
        normalized.insert(0, '/');
    }
    normalized
}

fn object_string<'a>(obj: &'a serde_json::Map<String, Value>, key: &str) -> Option<&'a str> {
    obj.get(key).and_then(Value::as_str)
}

fn parse_bool(raw: &str) -> bool {
    matches!(
        raw.trim().to_ascii_lowercase().as_str(),
        "1" | "true" | "yes" | "y" | "on"
    )
}

fn parse_json_or_jsonp(raw: &str) -> Result<Value> {
    let trimmed = raw.trim();
    if trimmed.is_empty() {
        return Err(anyhow!("empty response body"));
    }
    if let Ok(value) = serde_json::from_str::<Value>(trimmed) {
        return Ok(value);
    }

    if trimmed.starts_with('(') && trimmed.ends_with(')') {
        let inner = &trimmed[1..trimmed.len() - 1];
        if let Ok(value) = serde_json::from_str::<Value>(inner) {
            return Ok(value);
        }
    }

    if let (Some(open), Some(close)) = (trimmed.find('('), trimmed.rfind(')')) {
        if close > open {
            let inner = &trimmed[open + 1..close];
            if let Ok(value) = serde_json::from_str::<Value>(inner) {
                return Ok(value);
            }
        }
    }

    Err(anyhow!("unsupported json/jsonp payload: {}", trimmed))
}

fn write_optional_output(
    opts: &HashMap<String, String>,
    default_name: &str,
    value: &Value,
) -> Result<()> {
    let path = opts
        .get("--out")
        .map(PathBuf::from)
        .unwrap_or_else(|| PathBuf::from(default_name));
    if !opts.contains_key("--out") {
        return Ok(());
    }
    if let Some(parent) = path.parent() {
        std::fs::create_dir_all(parent)
            .with_context(|| format!("failed to create output parent dir: {}", parent.display()))?;
    }
    std::fs::write(&path, serde_json::to_vec_pretty(value)?)
        .with_context(|| format!("failed to write output: {}", path.display()))?;
    Ok(())
}
