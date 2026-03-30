//! Login captcha trace for the Boss SMS-login preflight chain.
//!
//! Flow (after this rewrite):
//!   1. POST `/api/zppassport/user/judge`
//!   2. POST `/api/zppassport/man/machine`
//!   3. GT3 API exchange: `get.php` → image solve → `ajax.php` → real validate
//!   4. POST `/api/zpsecureflow/captcha/validate` with real captcha_info
//!
//! Safe boundary:
//!   - Never call `/api/zppassport/phone/smsCode`
//!   - Never call `/api/zppassport/user/codeLogin`
//!
//! The previous `sdk_callback_mock` path has been removed.  When the machine
//! response indicates GT3 (`captchaType == 0 || 1`), we now run the real GT3
//! API exchange (get.php → image solve → ajax.php) to obtain genuine
//! `geetest_validate` / `geetest_seccode` values, then automatically submit
//! them to `/zpsecureflow/captcha/validate`.
//!
//! Use `--skip-validate` to stop after the GT3 exchange without submitting to
//! the Boss validate endpoint (useful for debugging the exchange itself).
//!
//! Use `--skip-gt3-exchange` when you need a fresh `startCaptcha` ticket for
//! external WebView/app3 reproduction. This intentionally stops before the
//! first GT3 `get.php`, so the returned challenge is not consumed by this tool.
//!
//! Contract evidence:
//!   - `boss_purecalc/login.py`
//!   - `docs/gt3-geetest-static-analysis.md`
//!   - `docs/gt3-web-vs-apk-comparison.md`

use std::borrow::Cow;
use std::collections::{BTreeMap, HashMap};
use std::path::{Path, PathBuf};

use anyhow::{anyhow, Context, Result};
use base64::engine::general_purpose::STANDARD;
use base64::Engine;
use reqwest::Url;
use rnidbg_boss_gt3::{
    boss_apk_gt3_call_chain, run_gt3_exchange_with_proof_selection_blocking, Gt3ExchangeRequest,
    Gt3ExchangeResult, Gt3ProductionProofTruth, Gt3ProofSelection, Gt3ProofSource,
};
use serde_json::{json, Value};
use url::form_urlencoded;

use super::fingerprint::{generate_device_fingerprint, FingerprintOptions};
use super::job_detail::{
    build_common_params, build_traceid, canonicalize_params, execute_post, normalize_host, now_ms,
    parse_bool_flag, redact_headers, response_code, truncate_for_sig, BossSigner, HttpTransport,
    RnIdbgSoInvoker, TransportRuntime,
};
use super::qr_login::{build_stage_inbound_headers, load_session, DeviceConfig};
use super::yzwg::LabConfig;

const DEFAULT_HOST: &str = "https://api5.zhipin.com";
const DEFAULT_HOST_BARE: &str = "api5.zhipin.com";
const JUDGE_PATH: &str = "/api/zppassport/user/judge";
const MACHINE_PATH: &str = "/api/zppassport/man/machine";
const CAPTCHA_VALIDATE_PATH: &str = "/api/zpsecureflow/captcha/validate";
const APP_ID: &str = "1003";
const USER_AGENT: &str = concat!(
    "Mozilla/5.0 (Linux; U; Android 14; zh-CN; RMX3560 Build/UQ1A.231205.015) ",
    "AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/100.0.4896.58 ",
    "UCBrowser/16.7.6.1010 Mobile Safari/537.36 UCBS/3.16.7.6_240924172629 ",
    "ChannelId(15) NeuroNet/1"
);
const SP_TRUNCATE_THRESHOLD: usize = 5000;
const DEFAULT_MACHINE_TYPE: &str = "3";
const PHONE_XOR_KEY: [u8; 11] = [
    0x8D, 0x50, 0x2F, 0x76, 0x48, 0xBE, 0x46, 0x5F, 0xB0, 0x8B, 0x70,
];

struct SignedPostRequest {
    url: String,
    traceid: String,
    headers: HashMap<String, String>,
    body: String,
}

#[derive(Clone, Debug)]
struct ResolvedSecretKey {
    value: Option<String>,
    source: String,
}

// ── public entry-point ─────────────────────────────────────────────────────────

pub fn run_captcha_trace(opts: &HashMap<String, String>) -> Result<Value> {
    let phone = extract_phone(opts)?;
    let region_code = normalize_region_code(
        opts.get("--region-code")
            .or_else(|| opts.get("--region"))
            .map(String::as_str),
    );
    let machine_type = opts
        .get("--machine-type")
        .or_else(|| opts.get("--type"))
        .cloned()
        .unwrap_or_else(|| DEFAULT_MACHINE_TYPE.to_string());
    let skip_validate = parse_bool_flag(opts, "--skip-validate");
    let skip_gt3_exchange = parse_bool_flag(opts, "--skip-gt3-exchange");
    let sec_code_normalization_mode = parse_sec_code_normalization_mode(opts)?;
    let gt3_proof_source = parse_gt3_proof_source(opts)?;
    let production_proof_truth = load_gt3_production_truth(opts)?;
    let external_captcha_info = opts
        .get("--captcha-info-json")
        .map(|raw| serde_json::from_str::<Value>(raw).context("invalid --captcha-info-json"))
        .transpose()?;

    let config_path = PathBuf::from(
        opts.get("--config")
            .cloned()
            .unwrap_or_else(super::default_config_path),
    );
    let lab_config = LabConfig::load(&config_path)?
        .with_backend_override(opts.get("--backend").map(String::as_str))?;

    let device = build_trace_device(opts);
    let signer = RnIdbgSoInvoker::new(config_path.clone(), &lab_config, opts)?;
    let transport_runtime =
        TransportRuntime::parse(opts.get("--transport-runtime").map(String::as_str))?;
    let http1_only = parse_bool_flag(opts, "--http1-only");
    let transport = HttpTransport::discover(transport_runtime, &lab_config, opts, http1_only)?;
    let secret_key = resolve_secret_key(opts)?;
    let host = normalize_host(
        opts.get("--host")
            .map(String::as_str)
            .unwrap_or(DEFAULT_HOST),
    );

    let encoded_phone = encode_phone(&phone);

    // ── step 1: POST /api/zppassport/user/judge ───────────────────────────────
    let judge_req = build_login_signed_post(
        &host,
        JUDGE_PATH,
        BTreeMap::from([
            ("phone".to_string(), encoded_phone.clone()),
            ("regionCode".to_string(), region_code.clone()),
        ]),
        &device,
        &*signer,
    )?;
    let judge_response = execute_post(
        &transport,
        &judge_req.url,
        &judge_req.headers,
        judge_req.body.as_bytes(),
        Some(&*signer),
        "",
    )?;

    // ── step 2: POST /api/zppassport/man/machine ──────────────────────────────
    let machine_req = build_login_signed_post(
        &host,
        MACHINE_PATH,
        BTreeMap::from([
            ("phone".to_string(), encoded_phone.clone()),
            ("type".to_string(), machine_type.clone()),
        ]),
        &device,
        &*signer,
    )?;
    let machine_response = execute_post(
        &transport,
        &machine_req.url,
        &machine_req.headers,
        machine_req.body.as_bytes(),
        Some(&*signer),
        "",
    )?;

    let judge_ok = response_code(Some(&judge_response)) == Some(0);
    let machine_ok = response_code(Some(&machine_response)) == Some(0);

    let machine_data = machine_response.get("zpData").unwrap_or(&machine_response);
    let captcha_type = machine_data
        .get("captchaType")
        .and_then(Value::as_i64)
        .map(|value| value as i32)
        .unwrap_or(0);
    let provider = provider_name(captcha_type);
    let captcha_name = machine_data
        .get("captchaName")
        .and_then(Value::as_str)
        .unwrap_or("")
        .to_string();
    let rand_key = machine_data
        .get("randKey")
        .and_then(Value::as_str)
        .unwrap_or("")
        .to_string();
    let start_captcha_raw = machine_data
        .get("startCaptcha")
        .and_then(Value::as_str)
        .unwrap_or("{}")
        .to_string();
    let start_captcha = serde_json::from_str::<Value>(&start_captcha_raw)
        .unwrap_or_else(|_| Value::String(start_captcha_raw.clone()));
    let wy_captcha_id = machine_data
        .get("wyCaptchaId")
        .cloned()
        .unwrap_or(Value::Null);
    let wy_captcha_type = machine_data
        .get("wyCaptchaType")
        .cloned()
        .unwrap_or(Value::Null);

    // ── step 3: GT3 API exchange (real, replaces the old mock) ────────────────
    //
    // When the machine response indicates GT3 (`captchaType 0 or 1`) and the
    // server returned a valid `startCaptcha` with `gt` + `challenge`, we run
    // the full Geetest-side exchange:
    //
    //   get.php → download bg/slice → image solve → trajectory → ajax.php
    //
    // This produces a genuine `geetest_validate` / `geetest_seccode` that can
    // be submitted to the Boss `/zpsecureflow/captcha/validate` endpoint.

    let gt3_exchange_result: Option<Gt3ExchangeResult> = if skip_gt3_exchange {
        None
    } else if matches!(captcha_type, 0 | 1) {
        let gt = start_captcha
            .get("gt")
            .and_then(Value::as_str)
            .unwrap_or("")
            .to_string();
        let challenge = start_captcha
            .get("challenge")
            .and_then(Value::as_str)
            .unwrap_or("")
            .to_string();

        if gt.is_empty() || challenge.is_empty() {
            log::warn!(
                "startCaptcha missing gt or challenge, cannot run GT3 exchange \
                 (gt={gt:?}, challenge={challenge:?})"
            );
            None
        } else {
            let exchange_req = Gt3ExchangeRequest {
                gt,
                challenge,
                trajectory_seed: opts
                    .get("--seed")
                    .map(|value| value.parse::<u64>())
                    .transpose()
                    .context("invalid --seed")?,
                edge_low_threshold: opts
                    .get("--edge-low")
                    .map(|value| value.parse::<f32>())
                    .transpose()
                    .context("invalid --edge-low")?,
                edge_high_threshold: opts
                    .get("--edge-high")
                    .map(|value| value.parse::<f32>())
                    .transpose()
                    .context("invalid --edge-high")?,
                api_server: opts.get("--gt3-api-server").cloned(),
                static_server: opts.get("--gt3-static-server").cloned(),
                user_agent: opts.get("--gt3-user-agent").cloned(),
            };
            let proof_selection = Gt3ProofSelection {
                proof_source: gt3_proof_source,
                production_proof_truth: production_proof_truth.clone(),
            };
            match run_gt3_exchange_with_proof_selection_blocking(exchange_req, proof_selection) {
                Ok(result) => Some(result),
                Err(err) => {
                    log::error!("GT3 exchange failed: {err:#}");
                    // We don't bail here — return partial output with the error
                    // recorded so the caller can inspect judge/machine results.
                    None
                }
            }
        }
    } else {
        None
    };

    // Build captcha_info from the exchange result (mirrors DEX `p50.d$a.onDialogResult`).
    // Only materialize captcha_info when exchange produced a real validate token.
    let (mut captcha_info, gt3_exchange_value, captcha_info_source) =
        if let Some(info) = external_captcha_info.clone() {
            (
                info,
                json!({
                    "status": "external_override",
                    "reason": "captcha_info supplied via --captcha-info-json"
                }),
                "external_override",
            )
        } else if let Some(exchange) = &gt3_exchange_result {
            let has_real_validate = exchange.status == "ok" && exchange.validate.is_some();
            let info = if has_real_validate {
                json!({
                    "type": captcha_type,
                    "challenge": exchange.challenge,
                    "validate": exchange.validate.as_deref().unwrap_or(""),
                    "secCode": exchange.sec_code.as_deref().unwrap_or(""),
                })
            } else {
                Value::Null
            };
            let exchange_val = json!({
                "status": exchange.status,
                "proof_source": exchange.proof_source,
                "proof_contract": exchange.proof_contract,
                "ajax_request_shape": exchange.ajax_request_shape,
                "w_characteristics": exchange.w_characteristics,
                "validate": exchange.validate,
                "sec_code": exchange.sec_code,
                "challenge": exchange.challenge,
                "register": {
                    "s": exchange.register.s,
                    "c": exchange.register.c,
                    "captcha_type": exchange.register.captcha_type,
                    "slice_url": exchange.register.slice_url,
                    "bg_url": exchange.register.bg_url,
                    "static_server": exchange.register.static_server,
                    "api_server": exchange.register.api_server,
                },
                "image_solve": exchange.image_solve.as_ref().map(|solve| json!({
                    "offset_x": solve.offset_x,
                    "confidence": solve.confidence,
                    "image_width": solve.image_width,
                    "image_height": solve.image_height,
                    "slider_width": solve.slider_width,
                    "slider_height": solve.slider_height,
                })),
                "trajectory_summary": exchange.trajectory_summary.as_ref().map(|ts| json!({
                    "seed": ts.seed,
                    "point_count": ts.point_count,
                    "target_x": ts.target_x,
                    "overshoot_x": ts.overshoot_x,
                    "total_duration_ms": ts.total_duration_ms,
                    "final_x": ts.final_x,
                })),
                "w_param_length": exchange.w_param.len(),
                "ajax_raw": exchange.ajax_raw,
                "error": exchange.error,
                "gt3_proof_truth": build_gt3_proof_truth_output(
                    exchange,
                    start_captcha.get("gt").and_then(Value::as_str).unwrap_or(""),
                    start_captcha.get("challenge").and_then(Value::as_str),
                ),
                "gt3_proof_truth_response": build_gt3_proof_truth_response_output(exchange),
            });
            (info, exchange_val, "gt3_exchange")
        } else {
            let reason = if skip_gt3_exchange {
                "GT3 exchange skipped by flag; startCaptcha preserved for external interactive flow"
                    .to_string()
            } else if !matches!(captcha_type, 0 | 1) {
                format!("captchaType={captcha_type} is not GT3; exchange skipped")
            } else if matches!(gt3_proof_source, Gt3ProofSource::ProductionTruth)
                && production_proof_truth.is_none()
            {
                "GT3 exchange requires production_proof_truth in production-truth mode".to_string()
            } else {
                "GT3 exchange did not run (missing gt/challenge or exchange error)".to_string()
            };
            (
                Value::Null,
                json!({
                    "status": "skipped",
                    "proof_source": match gt3_proof_source {
                        Gt3ProofSource::ProductionTruth => "production-truth",
                        Gt3ProofSource::Legacy => "legacy",
                    },
                    "reason": reason
                }),
                "none",
            )
        };
    let sec_code_normalization =
        apply_sec_code_normalization(&mut captcha_info, &sec_code_normalization_mode)?;

    // ── step 4: POST /zpsecureflow/captcha/validate ───────────────────────────
    //
    // Automatically submit the real captcha_info to the Boss validate endpoint
    // unless `--skip-validate` is set or the GT3 exchange did not produce a
    // valid validate token.
    let exchange_ok = gt3_exchange_result
        .as_ref()
        .map(|r| r.status == "ok" && r.validate.is_some() && r.sec_code.is_some())
        .unwrap_or(false);
    let external_captcha_ready =
        captcha_info_source == "external_override" && captcha_info != Value::Null;
    let validate_ready = (exchange_ok || external_captcha_ready) && captcha_info != Value::Null;
    let exchange_needs_interactive = gt3_exchange_result
        .as_ref()
        .map(|r| matches!(r.status, "needs_interactive" | "needs_click"))
        .unwrap_or(false);

    let (validate_req_value, validate_response_value, validate_status) =
        if !skip_validate && validate_ready {
            let validate_req = build_validate_signed_post(
                &host,
                CAPTCHA_VALIDATE_PATH,
                BTreeMap::from([(
                    "captcha_info".to_string(),
                    serialize_captcha_info_for_apk(&captcha_info)?,
                )]),
                secret_key.value.as_deref().unwrap_or_default(),
                &device,
                &*signer,
                None,
            )?;
            let validate_response = execute_post(
                &transport,
                &validate_req.url,
                &validate_req.headers,
                validate_req.body.as_bytes(),
                Some(&*signer),
                "",
            )?;
            (
                json!({
                    "url": validate_req.url,
                    "traceid": validate_req.traceid,
                    "headers": redact_headers(&validate_req.headers),
                    "body_form": validate_req.body,
                }),
                validate_response.clone(),
                classify_validate_status(Some(&validate_response)),
            )
        } else if skip_validate {
            (Value::Null, Value::Null, json!("skipped_by_flag"))
        } else {
            (Value::Null, Value::Null, json!("no_valid_exchange"))
        };

    // ── build output ──────────────────────────────────────────────────────────

    let real_observation = json!({
        "judge_code": response_code(Some(&judge_response)),
        "judge_message": judge_response.get("message").cloned().unwrap_or(Value::Null),
        "machine_code": response_code(Some(&machine_response)),
        "machine_message": machine_response.get("message").cloned().unwrap_or(Value::Null),
        "provider": provider,
        "captcha_type": captcha_type,
        "gt3_exchange_status": gt3_exchange_value
            .get("status")
            .and_then(Value::as_str)
            .unwrap_or("skipped"),
        "validate_submitted": validate_ready && !skip_validate,
    });

    let machine_verify_activity_replay = build_machine_verify_activity_replay(
        captcha_type,
        &captcha_info,
        validate_ready && !skip_validate,
    )?;

    let device_value = json!({
        "brand": device.brand,
        "model": device.model,
        "network": device.network,
        "operator": device.operator,
        "uniqid": device.uniqid,
        "did": device.did,
        "oaid": device.oaid,
        "oaid_honor": device.oaid_honor,
        "curidentity": device.curidentity,
        "tinker_id": device.tinker_id,
    });

    let judge_request_value = json!({
        "url": judge_req.url,
        "traceid": judge_req.traceid,
        "headers": redact_headers(&judge_req.headers),
        "body_form": judge_req.body,
    });

    let machine_request_value = json!({
        "url": machine_req.url,
        "traceid": machine_req.traceid,
        "headers": redact_headers(&machine_req.headers),
        "body_form": machine_req.body,
    });

    let contract_alignment = json!({
        "login_preflight": "zppassport/user/judge -> zppassport/man/machine",
        "gt3_exchange": "startCaptcha -> get.php -> image solve -> ajax.php -> real validate/secCode",
        "validate_submit": "captcha_info(real) -> /zpsecureflow/captcha/validate",
        "signed_fields": ["phone", "regionCode|type", "app_id", "client_info", "curidentity", "req_time", "uniqid", "v"],
        "signed_with_secret_key": secret_key.value.as_deref().unwrap_or_default().len() > 0,
        "notes": [
            "This command intentionally stops before smsCode/codeLogin.",
            "Phone encoding follows Signer.f(phone): XOR + standard base64.",
            "GT3 exchange runs the full Geetest API flow (get.php + image solve + ajax.php) to obtain real validate/secCode.",
            "The validate step is automatically submitted unless --skip-validate is set.",
            "Use --skip-validate to inspect the GT3 exchange result without submitting to Boss.",
        ]
    });

    let trace_challenges = json!({
        "start_captcha": start_captcha.get("challenge").and_then(Value::as_str).unwrap_or(""),
        "gt3_exchange": gt3_exchange_value.get("challenge").and_then(Value::as_str).unwrap_or(""),
        "captcha_info": captcha_info.get("challenge").and_then(Value::as_str).unwrap_or(""),
    });
    let challenge_relations = json!({
        "captcha_info_vs_start_captcha": challenge_relation(
            captcha_info.get("challenge").and_then(Value::as_str),
            start_captcha.get("challenge").and_then(Value::as_str),
        ),
        "captcha_info_vs_gt3_exchange": challenge_relation(
            captcha_info.get("challenge").and_then(Value::as_str),
            gt3_exchange_value.get("challenge").and_then(Value::as_str),
        ),
    });

    let captcha_info_source_chain = json!([
        {
            "step": "source",
            "source": captcha_info_source,
            "has_captcha_info": captcha_info != Value::Null,
        },
        {
            "step": "sec_code_normalization",
            "detail": sec_code_normalization,
        },
        {
            "step": "serialization",
            "serializer": "p50.d$a.onDialogResult order: type->challenge->validate->secCode",
        },
    ]);
    let signing_observation = json!({
        "secret_key_source": secret_key.source,
        "secret_key_present": secret_key.value.is_some(),
        "secret_key_len": secret_key.value.as_ref().map(|value| value.len()).unwrap_or(0),
        "signing_mode": if secret_key.value.as_deref().unwrap_or_default().is_empty() {
            "empty_secret_key"
        } else {
            "secret_key"
        },
        "request_builder_mode": "base_api_unsigned_app_id",
    });

    let overall_ok = judge_ok && machine_ok;
    let status = if overall_ok
        && validate_ready
        && validate_status != json!("skipped_by_flag")
        && validate_status != json!("no_valid_exchange")
    {
        let validate_accepted = match &validate_status {
            Value::String(s) => s == "accepted",
            _ => false,
        };
        if validate_accepted {
            "ok"
        } else {
            "partial"
        }
    } else if overall_ok && validate_ready && skip_validate {
        "ok_exchange_only"
    } else if overall_ok && exchange_needs_interactive && skip_validate {
        "ok_probe_only"
    } else if overall_ok {
        "partial"
    } else {
        "error"
    };

    let mut output = json!({
        "status": status,
        "mode": "real",
        "safe_mode": true,
        "forbidden_endpoints": [
            "/api/zppassport/phone/smsCode",
            "/api/zppassport/user/codeLogin"
        ],
        "phone_masked": mask_phone(&phone),
        "region_code": region_code,
        "encoded_phone": encoded_phone,
        "host": host,
        "transport_runtime": transport.label(),
        "original_okhttp_available": transport.original_okhttp_available(),
        "transport": transport.describe(),
        "native_invoker": signer.describe(),
        "device": device_value,

        // step 1 — judge
        "judge_request": judge_request_value,
        "judge_response": judge_response,

        // step 2 — machine
        "machine_request": machine_request_value,
        "machine_response": machine_response,

        // machine response parsed fields
        "provider": provider,
        "captcha_type": captcha_type,
        "captcha_name": captcha_name,
        "rand_key": rand_key,
        "start_captcha_raw": start_captcha_raw,
        "start_captcha": start_captcha,
        "wy_captcha_id": wy_captcha_id,
        "wy_captcha_type": wy_captcha_type,

        // step 3 — GT3 exchange (real)
        "gt3_exchange": gt3_exchange_value,
        "gt3_proof_truth": gt3_exchange_value
            .get("gt3_proof_truth")
            .cloned()
            .unwrap_or(Value::Null),
        "gt3_proof_truth_response": gt3_exchange_value
            .get("gt3_proof_truth_response")
            .cloned()
            .unwrap_or(Value::Null),

        // step 4 — validate
        "captcha_info": captcha_info,
        "captcha_info_source": captcha_info_source,
        "machine_verify_activity_replay": machine_verify_activity_replay,
        "skip_validate": skip_validate,
        "skip_gt3_exchange": skip_gt3_exchange,
        "validate_request_builder": "base_api_unsigned_app_id",
        "validate_request": validate_req_value,
        "validate_response": validate_response_value,
        "validate_status": validate_status,

        // observation
        "real_observation": real_observation,
        "gt3_call_chain": boss_apk_gt3_call_chain(),
        "contract_alignment": contract_alignment,
    });
    if let Some(output_obj) = output.as_object_mut() {
        output_obj.insert(
            "captcha_info_source_chain".to_string(),
            captcha_info_source_chain,
        );
        output_obj.insert("sec_code_normalization".to_string(), sec_code_normalization);
        output_obj.insert(
            "challenge_observation".to_string(),
            json!({
                "candidates": trace_challenges,
                "relations": challenge_relations,
            }),
        );
        output_obj.insert("signing_observation".to_string(), signing_observation);
    }

    if let Some(path) = opts.get("--out") {
        write_json(Path::new(path), &output)?;
    }

    Ok(output)
}

pub fn run_captcha_validate_submit(opts: &HashMap<String, String>) -> Result<Value> {
    let trace_path = opts
        .get("--trace-json")
        .or_else(|| opts.get("--native-trace"))
        .ok_or_else(|| anyhow!("missing --trace-json <path>"))?;
    let mut captcha_info = opts
        .get("--captcha-info-json")
        .ok_or_else(|| anyhow!("missing --captcha-info-json <json>"))
        .and_then(|raw| {
            serde_json::from_str::<Value>(raw).context("invalid --captcha-info-json")
        })?;
    let sec_code_normalization_mode = parse_sec_code_normalization_mode(opts)?;
    let java_probe = load_optional_json_input(opts, "--java-probe-json", "--java-probe-path")?;
    if captcha_info == Value::Null {
        return Err(anyhow!("--captcha-info-json must not be null"));
    }

    let config_path = PathBuf::from(
        opts.get("--config")
            .cloned()
            .unwrap_or_else(super::default_config_path),
    );
    let lab_config = LabConfig::load(&config_path)?
        .with_backend_override(opts.get("--backend").map(String::as_str))?;
    let signer = RnIdbgSoInvoker::new(config_path.clone(), &lab_config, opts)?;
    let transport_runtime =
        TransportRuntime::parse(opts.get("--transport-runtime").map(String::as_str))?;
    let http1_only = parse_bool_flag(opts, "--http1-only");
    let transport = HttpTransport::discover(transport_runtime, &lab_config, opts, http1_only)?;
    let secret_key = resolve_secret_key(opts)?;
    let trace_text = std::fs::read_to_string(trace_path)
        .with_context(|| format!("failed to read trace json: {trace_path}"))?;
    let trace: Value = serde_json::from_str(&trace_text)
        .with_context(|| format!("failed to parse trace json: {trace_path}"))?;
    let trace_common_params = extract_trace_validate_common_params(&trace);
    let host = normalize_host(
        opts.get("--host")
            .map(String::as_str)
            .or_else(|| trace.get("host").and_then(Value::as_str))
            .unwrap_or(DEFAULT_HOST),
    );
    let device = device_from_trace(&trace)?;
    let captcha_type = trace
        .get("captcha_type")
        .and_then(Value::as_i64)
        .map(|value| value as i32)
        .unwrap_or(1);

    let captcha_info_object = captcha_info
        .as_object_mut()
        .ok_or_else(|| anyhow!("--captcha-info-json must be a JSON object"))?;
    let provided_type = captcha_info_object
        .get("type")
        .and_then(Value::as_i64)
        .map(|value| value as i32);
    let type_normalized = provided_type != Some(captcha_type);
    if type_normalized {
        captcha_info_object.insert("type".to_string(), json!(captcha_type));
    }
    let captcha_info_type_alignment = json!({
        "expected_type": captcha_type,
        "provided_type": provided_type,
        "normalized_to_expected": type_normalized,
    });
    let sec_code_normalization =
        apply_sec_code_normalization(&mut captcha_info, &sec_code_normalization_mode)?;

    let trace_path_value = PathBuf::from(trace_path);
    let trace_kind = if trace_path.contains("-debug-") {
        "debug"
    } else if trace_path.contains("-native-") {
        "native"
    } else {
        "unknown"
    };
    let paired_native_start = if trace_kind == "debug" {
        let paired_path = PathBuf::from(trace_path.replace("-debug-", "-native-"));
        load_trace_challenge_field(&paired_path, &["start_captcha", "challenge"])
    } else if trace_kind == "native" {
        load_trace_challenge_field(&trace_path_value, &["start_captcha", "challenge"])
    } else {
        None
    };
    let paired_debug_start = if trace_kind == "native" {
        let paired_path = PathBuf::from(trace_path.replace("-native-", "-debug-"));
        load_trace_challenge_field(&paired_path, &["start_captcha", "challenge"])
    } else {
        load_trace_challenge_field(&trace_path_value, &["start_captcha", "challenge"])
    };
    let paired_debug_followup = if trace_kind == "native" {
        let paired_path = PathBuf::from(trace_path.replace("-native-", "-debug-"));
        load_trace_challenge_field(&paired_path, &["gt3_exchange", "challenge"])
            .or_else(|| load_trace_challenge_field(&paired_path, &["captcha_info", "challenge"]))
    } else {
        load_trace_challenge_field(&trace_path_value, &["gt3_exchange", "challenge"]).or_else(
            || load_trace_challenge_field(&trace_path_value, &["captcha_info", "challenge"]),
        )
    };
    let probe_challenge = java_probe.as_ref().and_then(|value| {
        extract_nested_string(
            value,
            &["on_dialog_result_probe", "captcha_info", "challenge"],
        )
    });
    let submit_challenge = captcha_info
        .get("challenge")
        .and_then(Value::as_str)
        .map(|value| value.to_string());
    let challenge_observation = json!({
        "candidates": {
            "native_start": paired_native_start,
            "debug_start": paired_debug_start,
            "debug_followup": paired_debug_followup,
            "submit_captcha_info": submit_challenge,
            "java_probe": probe_challenge,
        },
        "relations": {
            "submit_vs_native_start": challenge_relation_owned(
                captcha_info.get("challenge").and_then(Value::as_str),
                paired_native_start.as_deref(),
            ),
            "submit_vs_debug_start": challenge_relation_owned(
                captcha_info.get("challenge").and_then(Value::as_str),
                paired_debug_start.as_deref(),
            ),
            "submit_vs_debug_followup": challenge_relation_owned(
                captcha_info.get("challenge").and_then(Value::as_str),
                paired_debug_followup.as_deref(),
            ),
            "submit_vs_java_probe": challenge_relation_owned(
                captcha_info.get("challenge").and_then(Value::as_str),
                probe_challenge.as_deref(),
            ),
        }
    });
    let request_builder_mode = if trace_common_params.is_some() {
        "trace_common_params_unsigned_app_id"
    } else {
        "base_api_unsigned_app_id"
    };
    let captcha_info_source_chain = json!([
        {
            "step": "input",
            "source": "--captcha-info-json",
            "has_value": captcha_info != Value::Null,
        },
        {
            "step": "type_alignment",
            "detail": captcha_info_type_alignment,
        },
        {
            "step": "sec_code_normalization",
            "detail": sec_code_normalization,
        },
        {
            "step": "serialization",
            "serializer": "p50.d$a.onDialogResult order: type->challenge->validate->secCode",
        },
    ]);
    let signing_observation = json!({
        "secret_key_source": secret_key.source,
        "secret_key_present": secret_key.value.is_some(),
        "secret_key_len": secret_key.value.as_ref().map(|value| value.len()).unwrap_or(0),
        "signing_mode": if secret_key.value.as_deref().unwrap_or_default().is_empty() {
            "empty_secret_key"
        } else {
            "secret_key"
        },
        "request_builder_mode": request_builder_mode,
    });
    let probe_observation = json!({
        "provided": java_probe.is_some(),
        "source": if opts.contains_key("--java-probe-path") {
            "--java-probe-path"
        } else if opts.contains_key("--java-probe-json") {
            "--java-probe-json"
        } else {
            "none"
        },
        "challenge": probe_challenge,
    });

    let validate_req = build_validate_signed_post(
        &host,
        CAPTCHA_VALIDATE_PATH,
        BTreeMap::from([(
            "captcha_info".to_string(),
            serialize_captcha_info_for_apk(&captcha_info)?,
        )]),
        secret_key.value.as_deref().unwrap_or_default(),
        &device,
        &*signer,
        trace_common_params.as_ref(),
    )?;
    let validate_response = execute_post(
        &transport,
        &validate_req.url,
        &validate_req.headers,
        validate_req.body.as_bytes(),
        Some(&*signer),
        "",
    )?;
    let validate_status = classify_validate_status(Some(&validate_response));
    let validate_accepted = matches!(&validate_status, Value::String(value) if value == "accepted");
    let machine_verify_activity_replay =
        build_machine_verify_activity_replay(captcha_type, &captcha_info, true)?;

    let mut output = json!({
        "ok": true,
        "status": if validate_accepted { "ok" } else { "partial" },
        "mode": "validate-submit-only",
        "safe_mode": true,
        "source_trace_path": trace_path,
        "phone_masked": trace.get("phone_masked").cloned().unwrap_or(Value::Null),
        "region_code": trace.get("region_code").cloned().unwrap_or(Value::Null),
        "host": host,
        "transport_runtime": transport.label(),
        "original_okhttp_available": transport.original_okhttp_available(),
        "transport": transport.describe(),
        "native_invoker": signer.describe(),
        "device": {
            "brand": device.brand,
            "model": device.model,
            "network": device.network,
            "operator": device.operator,
            "uniqid": device.uniqid,
            "did": device.did,
            "oaid": device.oaid,
            "oaid_honor": device.oaid_honor,
            "curidentity": device.curidentity,
            "tinker_id": device.tinker_id,
        },
        "captcha_type": captcha_type,
        "provider": provider_name(captcha_type),
        "start_captcha": trace.get("start_captcha").cloned().unwrap_or(Value::Null),
        "captcha_info": captcha_info,
        "captcha_info_type_alignment": captcha_info_type_alignment,
        "captcha_info_source": "external_override",
        "machine_verify_activity_replay": machine_verify_activity_replay,
        "validate_request_builder": request_builder_mode,
        "validate_request": {
            "url": validate_req.url,
            "traceid": validate_req.traceid,
            "headers": redact_headers(&validate_req.headers),
            "body_form": validate_req.body,
        },
        "validate_response": validate_response,
        "validate_status": validate_status,
        "contract_alignment": {
            "source": "captured_gtcallback -> MachineVerifyActivity.Re -> MachineVerifyConfirmRequest",
            "mode": "manual_captcha_info_backfill",
            "notes": [
                "This path reuses device and host values from the provided native trace.",
                "judge/machine are not re-run here; only the final Boss captcha validate request is sent.",
                "Use this after a manual GT3 success callback yields challenge/validate/secCode."
            ]
        }
    });
    if let Some(output_obj) = output.as_object_mut() {
        output_obj.insert(
            "captcha_info_source_chain".to_string(),
            captcha_info_source_chain,
        );
        output_obj.insert("sec_code_normalization".to_string(), sec_code_normalization);
        output_obj.insert("challenge_observation".to_string(), challenge_observation);
        output_obj.insert("java_probe_observation".to_string(), probe_observation);
        output_obj.insert("signing_observation".to_string(), signing_observation);
    }

    if let Some(path) = opts.get("--out") {
        write_json(Path::new(path), &output)?;
    }

    Ok(output)
}

pub fn run_captcha_validate_experiment(opts: &HashMap<String, String>) -> Result<Value> {
    if !opts.contains_key("--trace-json") && !opts.contains_key("--native-trace") {
        return Err(anyhow!("missing --trace-json <path>"));
    }
    if !opts.contains_key("--captcha-info-json") {
        return Err(anyhow!("missing --captcha-info-json <json>"));
    }

    let matrix_out_dir = opts.get("--matrix-out-dir").map(PathBuf::from);
    if let Some(dir) = matrix_out_dir.as_ref() {
        std::fs::create_dir_all(dir)
            .with_context(|| format!("failed to create --matrix-out-dir: {}", dir.display()))?;
    }

    let has_cli_secret_key = opts
        .get("--secret-key")
        .map(|value| !value.trim().is_empty())
        .unwrap_or(false);
    let has_session_secret_key = opts
        .get("--session-path")
        .map(|value| !value.trim().is_empty())
        .unwrap_or(false);

    let mut variants: Vec<(&str, Option<&str>, bool, bool)> = vec![
        ("baseline", Some("none"), false, false),
        ("strip_jordan", Some("strip-jordan"), false, false),
    ];
    if has_cli_secret_key {
        variants.push(("with_cli_secret_key", Some("none"), true, false));
        variants.push((
            "with_cli_secret_key_strip_jordan",
            Some("strip-jordan"),
            true,
            false,
        ));
    }
    if has_session_secret_key {
        variants.push(("with_session_secret_key", Some("none"), false, true));
        variants.push((
            "with_session_secret_key_strip_jordan",
            Some("strip-jordan"),
            false,
            true,
        ));
    }

    let mut rows = Vec::with_capacity(variants.len());
    let mut accepted = 0_u32;
    let mut rejected = 0_u32;
    let mut unknown = 0_u32;
    let mut errored = 0_u32;

    for (name, sec_code_mode, use_cli_secret_key, use_session_secret_key) in variants {
        let mut variant_opts = opts.clone();
        // Prevent clobbering a single --out file across variants.
        variant_opts.remove("--out");
        variant_opts.remove("--matrix-out-dir");

        if let Some(mode) = sec_code_mode {
            variant_opts.insert("--sec-code-normalization".to_string(), mode.to_string());
        } else {
            variant_opts.remove("--sec-code-normalization");
        }

        if !use_cli_secret_key {
            variant_opts.remove("--secret-key");
        }
        if !use_session_secret_key {
            variant_opts.remove("--session-path");
        }

        let variant_out_path = matrix_out_dir
            .as_ref()
            .map(|dir| dir.join(format!("{name}.json")));
        if let Some(path) = variant_out_path.as_ref() {
            variant_opts.insert("--out".to_string(), path.display().to_string());
        }

        let result = run_captcha_validate_submit(&variant_opts);
        let row = match result {
            Ok(output) => {
                let validate_status = output
                    .get("validate_status")
                    .cloned()
                    .unwrap_or(Value::Null);
                let verdict = classify_validate_verdict(output.get("validate_status"));
                match verdict {
                    "accepted" => accepted += 1,
                    "rejected" => rejected += 1,
                    _ => unknown += 1,
                }
                json!({
                    "name": name,
                    "ok": true,
                    "verdict": verdict,
                    "validate_status": validate_status,
                    "request_builder_mode": output.get("validate_request_builder").cloned().unwrap_or(Value::Null),
                    "signing_observation": output.get("signing_observation").cloned().unwrap_or(Value::Null),
                    "sec_code_normalization": output.get("sec_code_normalization").cloned().unwrap_or(Value::Null),
                    "challenge_observation": output.get("challenge_observation").cloned().unwrap_or(Value::Null),
                    "out_path": variant_out_path.map(|path| path.display().to_string()),
                })
            }
            Err(err) => {
                errored += 1;
                json!({
                    "name": name,
                    "ok": false,
                    "error": format!("{err:#}"),
                    "out_path": variant_out_path.map(|path| path.display().to_string()),
                })
            }
        };
        rows.push(row);
    }

    let output = json!({
        "ok": true,
        "mode": "validate-experiment",
        "safe_mode": true,
        "note": "Experimental matrix only. Default validate-submit behavior is unchanged.",
        "inputs": {
            "trace_json": opts.get("--trace-json").or_else(|| opts.get("--native-trace")),
            "has_captcha_info_json": opts.get("--captcha-info-json").map(|v| !v.trim().is_empty()).unwrap_or(false),
            "has_cli_secret_key": has_cli_secret_key,
            "has_session_path": has_session_secret_key,
            "sec_code_modes": ["none", "strip-jordan"],
        },
        "summary": {
            "total": rows.len(),
            "accepted": accepted,
            "rejected": rejected,
            "unknown": unknown,
            "errored": errored,
        },
        "variants": rows,
    });

    if let Some(path) = opts.get("--out") {
        write_json(Path::new(path), &output)?;
    }

    Ok(output)
}

// ── device builder ─────────────────────────────────────────────────────────────

fn build_trace_device(opts: &HashMap<String, String>) -> DeviceConfig {
    let options = FingerprintOptions {
        brand: opts
            .get("--brand")
            .cloned()
            .filter(|value| !value.trim().is_empty())
            .unwrap_or_else(|| FingerprintOptions::default().brand),
        model_name: opts
            .get("--model-name")
            .or_else(|| opts.get("--model"))
            .cloned()
            .filter(|value| !value.trim().is_empty())
            .unwrap_or_else(|| FingerprintOptions::default().model_name),
        network_type: opts
            .get("--network")
            .cloned()
            .filter(|value| !value.trim().is_empty())
            .unwrap_or_else(|| FingerprintOptions::default().network_type),
        operator_name: opts
            .get("--operator-name")
            .or_else(|| opts.get("--operator"))
            .cloned()
            .filter(|value| !value.trim().is_empty())
            .unwrap_or_else(|| FingerprintOptions::default().operator_name),
        is_huawei: parse_bool_flag(opts, "--huawei"),
    };
    generate_device_fingerprint(None, &options, 0)
}

fn device_from_trace(trace: &Value) -> Result<DeviceConfig> {
    let device = trace
        .get("device")
        .and_then(Value::as_object)
        .ok_or_else(|| anyhow!("trace missing device object"))?;

    let string_field = |key: &str| -> String {
        device
            .get(key)
            .and_then(Value::as_str)
            .unwrap_or("")
            .to_string()
    };

    let config = DeviceConfig {
        uniqid: string_field("uniqid"),
        did: string_field("did"),
        oaid: string_field("oaid"),
        oaid_honor: string_field("oaid_honor"),
        brand: string_field("brand"),
        model: string_field("model"),
        network: string_field("network"),
        operator: string_field("operator"),
        tinker_id: string_field("tinker_id"),
        curidentity: device
            .get("curidentity")
            .and_then(Value::as_i64)
            .map(|value| value as i32)
            .unwrap_or_default(),
        secret_key: String::new(),
    };

    if config.uniqid.trim().is_empty()
        || config.did.trim().is_empty()
        || config.model.trim().is_empty()
        || config.network.trim().is_empty()
        || config.operator.trim().is_empty()
    {
        return Err(anyhow!(
            "trace device object is incomplete; expected uniqid/did/model/network/operator"
        ));
    }

    Ok(config)
}

// ── phone helpers ──────────────────────────────────────────────────────────────

fn extract_phone(opts: &HashMap<String, String>) -> Result<String> {
    let phone = opts
        .get("--phone")
        .or_else(|| opts.get("_0"))
        .map(|value| value.trim().to_string())
        .filter(|value| !value.is_empty())
        .ok_or_else(|| anyhow!("missing phone, use captcha-trace --phone <number>"))?;
    if !phone.chars().all(|ch| ch.is_ascii_digit()) {
        return Err(anyhow!("phone must contain ASCII digits only"));
    }
    Ok(phone)
}

fn normalize_region_code(value: Option<&str>) -> String {
    let region = value.unwrap_or("+86").trim();
    if region.is_empty() {
        "+86".to_string()
    } else if region.starts_with('+') {
        region.to_string()
    } else {
        format!("+{region}")
    }
}

fn encode_phone(phone: &str) -> String {
    let mut xored = Vec::with_capacity(phone.len());
    for (index, byte) in phone.as_bytes().iter().enumerate() {
        xored.push(byte ^ PHONE_XOR_KEY[index]);
    }
    STANDARD.encode(xored)
}

// ── signing + request helpers ──────────────────────────────────────────────────

fn build_login_signed_post(
    host: &str,
    path: &str,
    mut form_params: BTreeMap<String, String>,
    device: &DeviceConfig,
    signer: &dyn BossSigner,
) -> Result<SignedPostRequest> {
    let traceid = build_traceid();
    let req_time_ms = now_ms();

    let common_params = build_common_params(device, req_time_ms);
    let mut signing_params = common_params;
    signing_params.append(&mut form_params);
    signing_params.insert("app_id".to_string(), APP_ID.to_string());

    let canonical = canonicalize_params(&signing_params);
    let sp = signer
        .encode_request(canonical.as_bytes(), "")
        .with_context(|| format!("failed to build sp for {path}"))?;
    let sig_input = format!(
        "{}{}",
        path,
        truncate_for_sig(&canonical, SP_TRUNCATE_THRESHOLD)
    );
    let sig = signer
        .signature(sig_input.as_bytes(), "")
        .with_context(|| format!("failed to build sig for {path}"))?;
    let zp_tag = signer
        .encode_request(traceid.as_bytes(), "")
        .with_context(|| format!("failed to build zp-tag for {path}"))?;

    let mut final_form = signing_params;
    final_form.insert("sp".to_string(), sp);
    final_form.insert("sig".to_string(), sig);

    let url = format!(
        "{}/{}",
        host.trim_end_matches('/'),
        path.trim_start_matches('/')
    );

    let mut extra_headers = HashMap::new();
    extra_headers.insert("traceid".to_string(), traceid.clone());
    extra_headers.insert("zp-tag".to_string(), zp_tag);
    let mut headers = build_stage_inbound_headers(
        USER_AGENT,
        &host_header(host)?,
        device,
        None,
        Some(extra_headers),
    );
    headers.insert(
        "Content-Type".to_string(),
        "application/x-www-form-urlencoded".to_string(),
    );

    Ok(SignedPostRequest {
        url,
        traceid,
        headers,
        body: encode_form_body(&final_form),
    })
}

fn build_validate_signed_post(
    host: &str,
    path: &str,
    mut form_params: BTreeMap<String, String>,
    secret_key: &str,
    device: &DeviceConfig,
    signer: &dyn BossSigner,
    common_params_override: Option<&BTreeMap<String, String>>,
) -> Result<SignedPostRequest> {
    let traceid = build_traceid();
    let req_time_ms = common_params_override
        .and_then(|params| params.get("req_time"))
        .and_then(|value| value.parse::<u64>().ok())
        .unwrap_or_else(now_ms);

    let common_params = common_params_override
        .cloned()
        .unwrap_or_else(|| build_common_params(device, req_time_ms));
    let mut signing_params = common_params;
    signing_params.append(&mut form_params);

    let canonical = canonicalize_params(&signing_params);
    let sp = signer
        .encode_request(canonical.as_bytes(), secret_key)
        .with_context(|| format!("failed to build sp for {path}"))?;
    let sig_input = format!(
        "{}{}",
        path,
        truncate_for_sig(&canonical, SP_TRUNCATE_THRESHOLD)
    );
    let sig = signer
        .signature(sig_input.as_bytes(), secret_key)
        .with_context(|| format!("failed to build sig for {path}"))?;
    let zp_tag = signer
        .encode_request(traceid.as_bytes(), "")
        .with_context(|| format!("failed to build zp-tag for {path}"))?;

    let url = format!(
        "{}/{}",
        host.trim_end_matches('/'),
        path.trim_start_matches('/')
    );

    let mut extra_headers = HashMap::new();
    extra_headers.insert("traceid".to_string(), traceid.clone());
    extra_headers.insert("zp-tag".to_string(), zp_tag);
    let mut headers = build_stage_inbound_headers(
        USER_AGENT,
        &host_header(host)?,
        device,
        None,
        Some(extra_headers),
    );
    headers.insert(
        "Content-Type".to_string(),
        "application/x-www-form-urlencoded".to_string(),
    );

    Ok(SignedPostRequest {
        url,
        traceid,
        headers,
        body: encode_form_body_with_suffix(
            &signing_params,
            &[
                ("sp", sp),
                ("sig", sig),
                // BaseApiRequest-style POSTs keep app_id outside the signed canonical.
                ("app_id", APP_ID.to_string()),
            ],
        ),
    })
}

fn host_header(host: &str) -> Result<String> {
    let parsed = Url::parse(host).with_context(|| format!("invalid host url: {host}"))?;
    Ok(match parsed.port() {
        Some(port) => format!(
            "{}:{}",
            parsed.host_str().unwrap_or(DEFAULT_HOST_BARE),
            port
        ),
        None => parsed.host_str().unwrap_or(DEFAULT_HOST_BARE).to_string(),
    })
}

fn encode_form_body(params: &BTreeMap<String, String>) -> String {
    params
        .iter()
        .map(|(key, value)| format!("{key}={}", form_encode_value(value)))
        .collect::<Vec<_>>()
        .join("&")
}

fn encode_form_body_with_suffix(
    params: &BTreeMap<String, String>,
    suffix: &[(&str, String)],
) -> String {
    let mut parts = params
        .iter()
        .map(|(key, value)| format!("{key}={}", form_encode_value(value)))
        .collect::<Vec<_>>();
    parts.extend(
        suffix
            .iter()
            .map(|(key, value)| format!("{key}={}", form_encode_value(value))),
    );
    parts.join("&")
}

fn form_encode_value(value: &str) -> String {
    let mut out = String::with_capacity(value.len());
    for byte in value.as_bytes() {
        match byte {
            b'0'..=b'9' | b'a'..=b'z' | b'A'..=b'Z' | b'-' | b'_' | b'.' | b'~' => {
                out.push(*byte as char)
            }
            b' ' => out.push('+'),
            _ => out.push_str(&format!("%{byte:02X}")),
        }
    }
    out
}

fn serialize_captcha_info_for_apk(captcha_info: &Value) -> Result<String> {
    let obj = captcha_info
        .as_object()
        .ok_or_else(|| anyhow!("captcha_info must be a JSON object"))?;

    // Mirror `p50.d$a.onDialogResult(String)`: type -> challenge -> validate -> secCode.
    let type_json = serde_json::to_string(&obj.get("type").cloned().unwrap_or_else(|| json!(1)))?;
    let challenge_json = serde_json::to_string(
        &obj.get("challenge")
            .cloned()
            .unwrap_or_else(|| Value::String(String::new())),
    )?;
    let validate_json = serde_json::to_string(
        &obj.get("validate")
            .cloned()
            .unwrap_or_else(|| Value::String(String::new())),
    )?;
    let sec_code_json = serde_json::to_string(
        &obj.get("secCode")
            .cloned()
            .unwrap_or_else(|| Value::String(String::new())),
    )?;

    Ok(format!(
        "{{\"type\":{type_json},\"challenge\":{challenge_json},\"validate\":{validate_json},\"secCode\":{sec_code_json}}}"
    ))
}

// ── provider helpers ───────────────────────────────────────────────────────────

fn provider_name(captcha_type: i32) -> &'static str {
    match captcha_type {
        0 | 1 => "gt3",
        4 => "yidun-slider",
        _ => "unknown",
    }
}

fn parse_form_body_map(body: &str) -> BTreeMap<String, String> {
    form_urlencoded::parse(body.as_bytes())
        .map(|(key, value): (Cow<'_, str>, Cow<'_, str>)| (key.into_owned(), value.into_owned()))
        .collect()
}

/// Extract `client_info`, `curidentity`, `req_time`, `uniqid`, `v` from a trace request body.
fn extract_trace_validate_common_params(trace: &Value) -> Option<BTreeMap<String, String>> {
    for field in ["validate_request", "machine_request"] {
        if let Some(body) = trace
            .get(field)
            .and_then(|value| value.get("body_form"))
            .and_then(Value::as_str)
        {
            let parsed = parse_form_body_map(body);
            let mut common = BTreeMap::new();
            for key in ["client_info", "curidentity", "req_time", "uniqid", "v"] {
                if let Some(value) = parsed
                    .get(key)
                    .map(|value| value.trim())
                    .filter(|value| !value.is_empty())
                {
                    common.insert(key.to_string(), value.to_string());
                }
            }
            if common.len() == 5 {
                return Some(common);
            }
        }
    }
    None
}

// ── machine verify activity replay ─────────────────────────────────────────────

fn build_machine_verify_activity_replay(
    captcha_type: i32,
    captcha_info: &Value,
    validate_submitted: bool,
) -> Result<Value> {
    Ok(json!({
        "method": "MachineVerifyActivity.Re",
        "request_class": "MachineVerifyConfirmRequest",
        "network_send_performed": validate_submitted,
        "endpoint_path": CAPTCHA_VALIDATE_PATH,
        "captcha_type": captcha_type,
        "request_fields": {
            "captcha_info": if *captcha_info == Value::Null {
                Value::Null
            } else {
                Value::String(serialize_captcha_info_for_apk(captcha_info)?)
            },
        },
        "notes": [
            "Re(String) only stringifies captcha_info and hands it to MachineVerifyConfirmRequest.",
            "When validate_submitted is true, the captcha_info was POSTed to Boss validate endpoint with real GT3 exchange tokens.",
        ]
    }))
}

// ── misc helpers ───────────────────────────────────────────────────────────────

fn mask_phone(phone: &str) -> String {
    if phone.len() < 7 {
        return phone.to_string();
    }
    format!("{}****{}", &phone[..3], &phone[phone.len() - 4..])
}

fn resolve_secret_key(opts: &HashMap<String, String>) -> Result<ResolvedSecretKey> {
    if let Some(value) = opts.get("--secret-key") {
        let secret = value.trim();
        if !secret.is_empty() {
            return Ok(ResolvedSecretKey {
                value: Some(secret.to_string()),
                source: "--secret-key".to_string(),
            });
        }
    }
    match opts.get("--session-path").map(String::as_str) {
        Some(path) => Ok(ResolvedSecretKey {
            value: Some(load_session(Some(path))?.secret_key),
            source: "--session-path".to_string(),
        }),
        None => Ok(ResolvedSecretKey {
            value: None,
            source: "none".to_string(),
        }),
    }
}

fn parse_sec_code_normalization_mode(opts: &HashMap<String, String>) -> Result<String> {
    let mode = opts
        .get("--sec-code-normalization")
        .map(|value| value.trim().to_ascii_lowercase())
        .unwrap_or_else(|| "none".to_string());
    match mode.as_str() {
        "none" | "strip-pipe-suffix" | "strip-jordan" => Ok(mode),
        _ => Err(anyhow!(
            "invalid --sec-code-normalization, expected one of: none|strip-pipe-suffix|strip-jordan"
        )),
    }
}

fn apply_sec_code_normalization(captcha_info: &mut Value, mode: &str) -> Result<Value> {
    let Some(obj) = captcha_info.as_object_mut() else {
        return Ok(json!({
            "mode": mode,
            "applied": false,
            "reason": "captcha_info_not_object",
        }));
    };
    let before = obj
        .get("secCode")
        .and_then(Value::as_str)
        .map(|value| value.to_string());
    let mut after = before.clone();
    let mut applied = false;
    let reason = match (mode, before.as_deref()) {
        ("none", _) => "disabled",
        (_, None) => "missing_sec_code",
        ("strip-jordan", Some(value)) => {
            if let Some(stripped) = value.strip_suffix("|jordan") {
                after = Some(stripped.to_string());
                applied = true;
                "strip_jordan_suffix"
            } else {
                "suffix_not_found"
            }
        }
        ("strip-pipe-suffix", Some(value)) => {
            if let Some((prefix, _)) = value.split_once('|') {
                after = Some(prefix.to_string());
                applied = true;
                "strip_pipe_suffix"
            } else {
                "pipe_not_found"
            }
        }
        _ => "unhandled_mode",
    };
    if applied {
        obj.insert(
            "secCode".to_string(),
            Value::String(after.clone().unwrap_or_default()),
        );
    }
    Ok(json!({
        "mode": mode,
        "before": before,
        "after": after,
        "applied": applied,
        "reason": reason,
    }))
}

fn challenge_relation(left: Option<&str>, right: Option<&str>) -> &'static str {
    match (left, right) {
        (Some(lhs), Some(rhs)) if !lhs.is_empty() && !rhs.is_empty() => {
            if lhs == rhs {
                "exact"
            } else if lhs.starts_with(rhs) || rhs.starts_with(lhs) {
                "prefix"
            } else {
                "different"
            }
        }
        _ => "unavailable",
    }
}

fn challenge_relation_owned(left: Option<&str>, right: Option<&str>) -> &'static str {
    challenge_relation(left, right)
}

fn load_optional_json_input(
    opts: &HashMap<String, String>,
    inline_key: &str,
    path_key: &str,
) -> Result<Option<Value>> {
    if let Some(path) = opts.get(path_key) {
        let raw = std::fs::read_to_string(path)
            .with_context(|| format!("failed to read {path_key}: {path}"))?;
        return Ok(Some(
            serde_json::from_str::<Value>(&raw)
                .with_context(|| format!("invalid json in {path_key}: {path}"))?,
        ));
    }
    if let Some(raw) = opts.get(inline_key) {
        return Ok(Some(
            serde_json::from_str::<Value>(raw)
                .with_context(|| format!("invalid {inline_key} json"))?,
        ));
    }
    Ok(None)
}

fn parse_gt3_proof_source(opts: &HashMap<String, String>) -> Result<Gt3ProofSource> {
    let raw = opts
        .get("--proof-source")
        .map(|value| value.trim().to_ascii_lowercase())
        .unwrap_or_else(|| "production-truth".to_string());
    match raw.as_str() {
        "production-truth" => Ok(Gt3ProofSource::ProductionTruth),
        "legacy" => Ok(Gt3ProofSource::Legacy),
        _ => Err(anyhow!(
            "invalid --proof-source: {raw} (expected production-truth|legacy)"
        )),
    }
}

fn load_gt3_production_truth(
    opts: &HashMap<String, String>,
) -> Result<Option<Gt3ProductionProofTruth>> {
    let value = load_optional_json_input(
        opts,
        "--production-proof-truth-json",
        "--production-proof-truth-path",
    )?
    .or(load_optional_json_input(
        opts,
        "--gt3-proof-truth-json",
        "--gt3-proof-truth-path",
    )?);
    let Some(value) = value else {
        return Ok(None);
    };
    Ok(Some(
        serde_json::from_value::<Gt3ProductionProofTruth>(value)
            .context("invalid production proof truth json")?,
    ))
}

fn build_gt3_proof_truth_output(
    exchange: &Gt3ExchangeResult,
    gt: &str,
    bootstrap_challenge: Option<&str>,
) -> Value {
    json!({
        "gt": gt,
        "bootstrap_challenge": bootstrap_challenge.unwrap_or(""),
        "followup_challenge": exchange.challenge,
        "final_challenge": exchange.challenge,
        "client_type": exchange.proof_contract.client_type,
        "pt": exchange.proof_contract.pt,
        "http_method": exchange.proof_contract.http_method,
        "request_url": exchange.proof_contract.request_url,
        "query_shape": exchange.ajax_request_shape.query_shape,
        "body_shape": exchange.ajax_request_shape.body_shape,
        "w": exchange.w_param,
        "w_length": exchange.w_param.len(),
        "ua": "",
        "geetest_cookie_snapshot": Value::Array(Vec::new()),
        "proof_source_tag": exchange.proof_contract.proof_source_tag,
        "ts_ms": now_ms(),
    })
}

fn build_gt3_proof_truth_response_output(exchange: &Gt3ExchangeResult) -> Value {
    json!({
        "ajax_raw": exchange.ajax_raw,
        "success_callback_payload": {
            "geetest_challenge": exchange.challenge,
            "geetest_validate": exchange.validate.clone().unwrap_or_default(),
            "geetest_seccode": exchange.sec_code.clone().unwrap_or_default(),
        },
        "validate": exchange.validate,
        "sec_code": exchange.sec_code,
        "challenge": exchange.challenge,
    })
}

fn extract_nested_string(value: &Value, path: &[&str]) -> Option<String> {
    let mut cursor = value;
    for key in path {
        cursor = cursor.get(*key)?;
    }
    cursor.as_str().map(|text| text.to_string())
}

fn load_trace_challenge_field(path: &Path, path_keys: &[&str]) -> Option<String> {
    let raw = std::fs::read_to_string(path).ok()?;
    let value = serde_json::from_str::<Value>(&raw).ok()?;
    extract_nested_string(&value, path_keys)
}

fn classify_validate_status(value: Option<&Value>) -> Value {
    match response_code(value) {
        Some(0) => json!("accepted"),
        Some(code) => json!({
            "state": "rejected",
            "code": code,
        }),
        None => json!("unknown"),
    }
}

fn classify_validate_verdict(value: Option<&Value>) -> &'static str {
    match value {
        Some(Value::String(text)) if text == "accepted" => "accepted",
        Some(Value::Object(map))
            if map.get("state").and_then(Value::as_str) == Some("rejected") =>
        {
            "rejected"
        }
        Some(Value::Object(map)) if map.get("code").and_then(Value::as_i64) == Some(0) => {
            "accepted"
        }
        Some(Value::Object(map)) if map.get("code").and_then(Value::as_i64).is_some() => "rejected",
        _ => "unknown",
    }
}

fn write_json(path: &Path, value: &Value) -> Result<()> {
    if let Some(parent) = path.parent() {
        std::fs::create_dir_all(parent)
            .with_context(|| format!("failed to create output parent dir: {}", parent.display()))?;
    }
    std::fs::write(path, serde_json::to_vec_pretty(value)?)
        .with_context(|| format!("failed to write output: {}", path.display()))
}

// ── tests ──────────────────────────────────────────────────────────────────────

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn encode_phone_matches_known_runtime_pair() {
        assert_eq!(encode_phone("13800138000"), "vGMXRniPdWeAu0A=");
    }

    #[test]
    fn provider_name_aligns_machine_gate() {
        assert_eq!(provider_name(0), "gt3");
        assert_eq!(provider_name(1), "gt3");
        assert_eq!(provider_name(4), "yidun-slider");
    }

    #[test]
    fn normalize_region_code_adds_plus_prefix() {
        assert_eq!(normalize_region_code(Some("86")), "+86");
        assert_eq!(normalize_region_code(Some("+1")), "+1");
        assert_eq!(normalize_region_code(None), "+86");
    }

    #[test]
    fn mask_phone_hides_middle() {
        assert_eq!(mask_phone("13800138000"), "138****8000");
        assert_eq!(mask_phone("15298686749"), "152****6749");
    }

    #[test]
    fn mask_phone_short_passthrough() {
        assert_eq!(mask_phone("12345"), "12345");
    }

    #[test]
    fn serialize_captcha_info_for_apk_matches_dialog_result_order() {
        let captcha_info = json!({
            "validate": "validate-token",
            "type": 1,
            "secCode": "validate-token|jordan",
            "challenge": "challenge-token",
        });

        let raw =
            serialize_captcha_info_for_apk(&captcha_info).expect("captcha_info should serialize");

        assert_eq!(
            raw,
            "{\"type\":1,\"challenge\":\"challenge-token\",\"validate\":\"validate-token\",\"secCode\":\"validate-token|jordan\"}"
        );
    }

    #[test]
    fn encode_form_body_with_suffix_keeps_unsigned_params_last() {
        let params = BTreeMap::from([
            ("captcha_info".to_string(), "x".to_string()),
            ("client_info".to_string(), "y".to_string()),
        ]);

        let body = encode_form_body_with_suffix(
            &params,
            &[
                ("sp", "signed-sp".to_string()),
                ("sig", "signed-sig".to_string()),
                ("app_id", "1003".to_string()),
            ],
        );

        assert_eq!(
            body,
            "captcha_info=x&client_info=y&sp=signed-sp&sig=signed-sig&app_id=1003"
        );
    }

    #[test]
    fn apply_sec_code_normalization_strip_jordan_is_observable() {
        let mut captcha_info = json!({
            "type": 1,
            "challenge": "challenge-token",
            "validate": "validate-token",
            "secCode": "validate-token|jordan"
        });
        let observation = apply_sec_code_normalization(&mut captcha_info, "strip-jordan")
            .expect("normalization should not fail");
        assert_eq!(captcha_info["secCode"], "validate-token");
        assert_eq!(observation["applied"], true);
        assert_eq!(observation["reason"], "strip_jordan_suffix");
    }

    #[test]
    fn challenge_relation_prefix_detected() {
        assert_eq!(
            challenge_relation(
                Some("9aa0983b564ae0e92060ff41c59c7e18bo"),
                Some("9aa0983b564ae0e92060ff41c59c7e18")
            ),
            "prefix"
        );
        assert_eq!(challenge_relation(Some("a"), Some("b")), "different");
    }
}
