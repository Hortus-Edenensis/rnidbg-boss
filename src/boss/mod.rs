use std::collections::HashMap;
use std::path::PathBuf;

use anyhow::{anyhow, Result};

pub mod captcha_mock;
pub mod contact;
pub mod fingerprint;
pub mod gt3;
pub mod http_bridge;
pub mod job_detail;
pub mod private_info;
pub mod proxy_pool;
pub mod qr_authorize;
pub mod qr_codec;
pub mod qr_login;
pub mod qr_web;
pub mod search;
pub mod yzwg;

pub use yzwg::BossYzwgLab;

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
            return Ok(());
        }
        "private-info" | "profile" => {
            let output = private_info::run_private_info(&opts)?;
            println!("{}", serde_json::to_string_pretty(&output)?);
            return Ok(());
        }
        "captcha-mock" => {
            let output = captcha_mock::run_captcha_mock(&opts)?;
            println!("{}", serde_json::to_string_pretty(&output)?);
            return Ok(());
        }
        "gt3-call-chain" | "gt3-chain" => {
            let output = gt3::run_gt3_call_chain(&opts)?;
            println!("{}", serde_json::to_string_pretty(&output)?);
            return Ok(());
        }
        "gt3-pipeline" | "gt3-image-solve" => {
            let output = gt3::run_gt3_pipeline(&opts)?;
            println!("{}", serde_json::to_string_pretty(&output)?);
            return Ok(());
        }
        "job-detail" => {
            let output = job_detail::run_job_detail(&opts)?;
            println!("{}", serde_json::to_string_pretty(&output)?);
            return Ok(());
        }
        "friends" | "contacts" => {
            let output = contact::run_friends(&opts)?;
            println!("{}", serde_json::to_string_pretty(&output)?);
            return Ok(());
        }
        "messages" | "chat" => {
            let output = contact::run_messages(&opts)?;
            println!("{}", serde_json::to_string_pretty(&output)?);
            return Ok(());
        }
        "messages-all" | "chat-all" | "all-messages" => {
            let output = contact::run_messages_all(&opts)?;
            println!("{}", serde_json::to_string_pretty(&output)?);
            return Ok(());
        }
        "chat-bootstrap" => {
            let output = contact::run_chat_bootstrap(&opts)?;
            println!("{}", serde_json::to_string_pretty(&output)?);
            return Ok(());
        }
        "chat-payload" | "chat-construct" => {
            let output = contact::run_chat_payload(&opts)?;
            println!("{}", serde_json::to_string_pretty(&output)?);
            return Ok(());
        }
        "proactive-send" | "chat-send-http" => {
            let output = contact::run_proactive_send(&opts)?;
            println!("{}", serde_json::to_string_pretty(&output)?);
            return Ok(());
        }
        "send-text" | "chat-send-native" => {
            let output = contact::run_send_text(&opts)?;
            println!("{}", serde_json::to_string_pretty(&output)?);
            return Ok(());
        }
        "exchange" => {
            let output = contact::run_exchange(&opts)?;
            println!("{}", serde_json::to_string_pretty(&output)?);
            return Ok(());
        }
        "interaction" => {
            let output = contact::run_interaction(&opts)?;
            println!("{}", serde_json::to_string_pretty(&output)?);
            return Ok(());
        }
        "hot-job-rec" | "recommend-pool" => {
            let output = contact::run_hot_job_recommend(&opts)?;
            println!("{}", serde_json::to_string_pretty(&output)?);
            return Ok(());
        }
        "fingerprint-randomize" | "device-fp-randomize" => {
            let output = fingerprint::run_fingerprint_randomize(&opts)?;
            println!("{}", serde_json::to_string_pretty(&output)?);
            return Ok(());
        }
        "search" => {
            let output = search::run_search(&opts)?;
            println!("{}", serde_json::to_string_pretty(&output)?);
            return Ok(());
        }
        "recommend" | "recommend-jobs" => {
            let output = search::run_recommend(&opts)?;
            println!("{}", serde_json::to_string_pretty(&output)?);
            return Ok(());
        }
        "qr-serve" => return qr_login::run_qr_serve(&opts),
        "qr-decode" | "qr-recognize" => {
            let output = qr_codec::run_qr_decode(&opts)?;
            println!("{}", serde_json::to_string_pretty(&output)?);
            return Ok(());
        }
        "qr-authorize" | "qr-login-real" => {
            let output = qr_authorize::run_qr_authorize(&opts)?;
            println!("{}", serde_json::to_string_pretty(&output)?);
            return Ok(());
        }
        "qr-web" | "qr-login-web" => return qr_web::run_qr_web(&opts),
        "qr-consume" => {
            let output = qr_login::run_qr_consume(&opts)?;
            println!("{}", serde_json::to_string_pretty(&output)?);
            return Ok(());
        }
        _ => {}
    }

    let config_path = PathBuf::from(
        opts.get("--config")
            .cloned()
            .unwrap_or_else(default_config_path),
    );
    let mut lab = yzwg::BossYzwgLab::load_with_backend(
        &config_path,
        opts.get("--backend").map(String::as_str),
    )?;
    let output = match command.as_str() {
        "smoke" => lab.run_smoke()?,
        "trace" => lab.run_trace(&opts)?,
        "invoke" => lab.run_invoke(&opts)?,
        "replay" => lab.run_replay(&opts)?,
        _ => return Err(anyhow!("unknown boss-yzwg command: {command}")),
    };

    println!("{}", serde_json::to_string_pretty(&output)?);
    Ok(())
}

pub fn serve_http_bridge(args: Vec<String>) -> Result<()> {
    let opts = parse_options(&args);
    let config_path = PathBuf::from(
        opts.get("--config")
            .cloned()
            .unwrap_or_else(default_config_path),
    );
    let port = opts
        .get("--port")
        .map(|value| value.parse::<u16>())
        .transpose()?
        .unwrap_or(18080);
    http_bridge::serve(config_path, port, opts.get("--backend").map(String::as_str))
}

pub fn print_usage() {
    eprintln!("boss-yzwg commands:");
    eprintln!("  smoke   [--config <path>] [--backend <auto|dynarmic|unicorn>]");
    eprintln!("  trace   [--config <path>] [--backend <auto|dynarmic|unicorn>] [--method-filter <method|all>] [--lookup <path>]");
    eprintln!(
        "  invoke  [--config <path>] [--backend <auto|dynarmic|unicorn>] --method <name> --arg1 <utf8|hex:...> [--arg2 <key>] [--dump-rc4 true]"
    );
    eprintln!("  replay  [--config <path>] [--backend <auto|dynarmic|unicorn>] [--lookup <path>] [--limit <N>] [--mode <sp|sig|both>]");
    eprintln!(
        "  captcha-mock --session-path <path> [--dialog-result-json <json>|--dialog-result-file <path>] [--host <host>] [--config <path>] [--backend <auto|dynarmic|unicorn>] [--invoke-runtime <auto|local|bridge>] [--bridge-url <url>] [--transport-runtime <auto|direct|okhttp-bridge>] [--okhttp-bridge-url <url>] [--http1-only true] [--out <path>]"
    );
    eprintln!(
        "           real flow: GET /zpsecureflow/captcha/gettype (signed via libyzwg.so) then POST /zpsecureflow/captcha/validate with user-supplied GT3 dialog result"
    );
    eprintln!("  gt3-call-chain|gt3-chain [--format <json|markdown>] [--out <path>]");
    eprintln!(
        "  gt3-pipeline|gt3-image-solve [--background-url <url>|--background-image <path>] [--slider-url <url>|--slider-image <path>] [--user-agent <ua>] [--referer <url>] [--edge-low <f32>] [--edge-high <f32>] [--seed <u64>] [--out <path>]"
    );
    eprintln!(
        "  private-info|profile [--session-path <path>] [--host <host>] [--city-code <code>] [--user-id <id>] [--sub-location <id>] [--config <path>] [--backend <auto|dynarmic|unicorn>] [--invoke-runtime <auto|local|bridge>] [--bridge-url <url>] [--transport-runtime <auto|direct|okhttp-bridge>] [--okhttp-bridge-url <url>] [--http1-only true] [--out <path>] [--force-so true]"
    );
    eprintln!(
        "  job-detail <securityId> [--host <host>] [--lid <id>] [--need-related-job true] [--page <n>] [--request-source <n>] [--source-type <n>] [--way-type <n>] [--keyword <text>] [--query <text>] [--session-path <path>] [--config <path>] [--backend <auto|dynarmic|unicorn>] [--invoke-runtime <auto|local|bridge>] [--bridge-url <url>] [--transport-runtime <auto|direct|okhttp-bridge>] [--okhttp-bridge-url <url>] [--http1-only true] [--out <path>]"
    );
    eprintln!("           built-in token bucket: 120 reqs/min (job-detail only)");
    eprintln!(
        "  friends|contacts [--limit <n>] [--host <contact-host>] [--session-path <path>] [--config <path>] [--backend <auto|dynarmic|unicorn>] [--invoke-runtime <auto|local|bridge>] [--bridge-url <url>] [--transport-runtime <auto|direct|okhttp-bridge>] [--okhttp-bridge-url <url>] [--http1-only true] [--out <path>]"
    );
    eprintln!(
        "  messages|chat <friendId> [--uid <friendId>] [--count <n>] [--friend-source <n>] [--max-msg-id <id>] [--last-msg-id <id>] [--host <api-host>] [--session-path <path>] [--config <path>] [--backend <auto|dynarmic|unicorn>] [--invoke-runtime <auto|local|bridge>] [--bridge-url <url>] [--transport-runtime <auto|direct|okhttp-bridge>] [--okhttp-bridge-url <url>] [--http1-only true] [--out <path>]"
    );
    eprintln!(
        "  messages-all|chat-all [--limit <n>] [--count <n>] [--max-msg-id <id>] [--last-msg-id <id>] [--base-info-batch <n>] [--skip-sync true] [--host <api-host>] [--session-path <path>] [--config <path>] [--backend <auto|dynarmic|unicorn>] [--invoke-runtime <auto|local|bridge>] [--bridge-url <url>] [--transport-runtime <auto|direct|okhttp-bridge>] [--okhttp-bridge-url <url>] [--http1-only true] [--out <path>]"
    );
    eprintln!(
        "  chat-bootstrap <friendId> [--uid <friendId>] [--source-security-id <id>] [--k810 <0|1>] [--window-ids <csv>] [--host <api-host>] [--session-path <path>] [--config <path>] [--backend <auto|dynarmic|unicorn>] [--invoke-runtime <auto|local|bridge>] [--bridge-url <url>] [--transport-runtime <auto|direct|okhttp-bridge>] [--okhttp-bridge-url <url>] [--http1-only true] [--out <path>]"
    );
    eprintln!(
        "  chat-payload|chat-construct <friendId> <text> [--uid <friendId>] [--text <message>] [--my-name <name>] [--extend <json>] [--task-id <id>] [--quote-id <id>] [--biz-id <id>] [--biz-type <n>] [--payload-builder-mode <serializer|patched|manual>] [--skip-bootstrap true] [--session-path <path>] [--config <path>] [--backend <auto|dynarmic|unicorn>] [--invoke-runtime <auto|local|bridge>] [--bridge-url <url>] [--transport-runtime <auto|direct|okhttp-bridge>] [--okhttp-bridge-url <url>] [--http1-only true] [--out <path>]"
    );
    eprintln!(
        "  proactive-send|chat-send-http <friendId> [--uid <friendId>] [--security-id <id>] [--scene <n>] [--host <api-host>] [--session-path <path>] [--config <path>] [--backend <auto|dynarmic|unicorn>] [--invoke-runtime <auto|local|bridge>] [--bridge-url <url>] [--transport-runtime <auto|direct|okhttp-bridge>] [--okhttp-bridge-url <url>] [--http1-only true] [--out <path>]"
    );
    eprintln!(
        "  send-text|chat-send-native <friendId> <text> [--uid <friendId>] [--text <message>] [--my-name <name>] [--extend <json>] [--task-id <id>] [--quote-id <id>] [--biz-id <id>] [--biz-type <n>] [--send-runtime <mqtt|mock|dump>] [--payload-builder-mode <serializer|patched|manual>] [--mock-server-mid <id>] [--skip-bootstrap true] [--session-path <path>] [--config <path>] [--backend <auto|dynarmic|unicorn>] [--invoke-runtime <auto|local|bridge>] [--bridge-url <url>] [--transport-runtime <auto|direct|okhttp-bridge>] [--okhttp-bridge-url <url>] [--http1-only true] [--out <path>]"
    );
    eprintln!(
        "  exchange [--page <n>] [--host <contact-host>] [--session-path <path>] [--config <path>] [--backend <auto|dynarmic|unicorn>] [--invoke-runtime <auto|local|bridge>] [--bridge-url <url>] [--transport-runtime <auto|direct|okhttp-bridge>] [--okhttp-bridge-url <url>] [--http1-only true] [--out <path>]"
    );
    eprintln!(
        "  interaction [--host <api-host>] [--session-path <path>] [--config <path>] [--backend <auto|dynarmic|unicorn>] [--invoke-runtime <auto|local|bridge>] [--bridge-url <url>] [--transport-runtime <auto|direct|okhttp-bridge>] [--okhttp-bridge-url <url>] [--http1-only true] [--out <path>]"
    );
    eprintln!(
        "  hot-job-rec|recommend-pool [--page <n>] [--tag <n>] [--host <api-host>] [--session-path <path>] [--config <path>] [--backend <auto|dynarmic|unicorn>] [--invoke-runtime <auto|local|bridge>] [--bridge-url <url>] [--transport-runtime <auto|direct|okhttp-bridge>] [--okhttp-bridge-url <url>] [--http1-only true] [--out <path>]"
    );
    eprintln!(
        "  fingerprint-randomize|device-fp-randomize [--session-path <path>] [--brand <name>] [--model-name <name>] [--network <wifi|2G|3G|4G|5G>] [--operator-name <CMCC|CHN-CT|CHN-UNICOM|CHN-CR>] [--huawei true]"
    );
    eprintln!(
        "  search <keyword> [--city <code>] [--page <n>] [--page-size <n>] [--host <host>] [--session-path <path>] [--config <path>] [--backend <auto|dynarmic|unicorn>] [--invoke-runtime <auto|local|bridge>] [--bridge-url <url>] [--transport-runtime <auto|direct|okhttp-bridge>] [--okhttp-bridge-url <url>] [--http1-only true] [--out <path>]"
    );
    eprintln!(
        "  recommend|recommend-jobs [--city <code>] [--page <n>] [--page-size <n>] [--sort-type <n>] [--host <host>] [--session-path <path>] [--config <path>] [--backend <auto|dynarmic|unicorn>] [--invoke-runtime <auto|local|bridge>] [--bridge-url <url>] [--transport-runtime <auto|direct|okhttp-bridge>] [--okhttp-bridge-url <url>] [--http1-only true] [--out <path>]"
    );
    eprintln!(
        "  qr-serve    [--host <addr>] [--port <port>] [--qr-mode <web|change-device>] [--edit-type <type>] [--action-id <id>] [--extra-info <text>]"
    );
    eprintln!("  qr-decode|qr-recognize <image-path> [--out <path>]");
    eprintln!(
        "  qr-authorize|qr-login-real <image-path> [--second-image <path>|--second-qr <qrId>] [--host <host>] [--session-path <path>] [--config <path>] [--backend <auto|dynarmic|unicorn>] [--invoke-runtime <auto|local|bridge>] [--bridge-url <url>] [--transport-runtime <auto|direct|okhttp-bridge>] [--okhttp-bridge-url <url>] [--http1-only true] [--edit-type <type>] [--action-id <id>] [--extra-info <text>] [--login-type <1|2>] [--sleep-before-login-ms <n>] [--loc-per true] [--latitude <v>] [--longitude <v>] [--ssid <name>] [--bssid <mac>] [--out <path>]"
    );
    eprintln!(
        "  qr-web|qr-login-web [--bind-host <addr>] [--port <port>] [--public-origin <url>] [--state-dir <path>] [--api-host <host>] [--session-path <path>] [--config <path>] [--backend <auto|dynarmic|unicorn>] [--invoke-runtime <auto|local|bridge>] [--bridge-url <url>] [--transport-runtime <auto|direct|okhttp-bridge>] [--okhttp-bridge-url <url>] [--http1-only true] [--edit-type <type>] [--action-id <id>] [--extra-info <text>] [--login-type <1|2>] [--sleep-before-login-ms <n>] [--loc-per true] [--latitude <v>] [--longitude <v>] [--ssid <name>] [--bssid <mac>]"
    );
    eprintln!(
        "  qr-consume  --producer-id <id> [--base-url <url>] [--login-type <1|2>] [--session-path <path>]"
    );
    eprintln!("  shared proxy flags: [--socks5-proxy <host:port:user:pass>] [--socks5-proxy-pool-file <path>]");
}

pub fn default_config_path() -> String {
    if let Ok(path) = std::env::var("RNIDBG_LAB_CONFIG") {
        return path;
    }

    for candidate in [
        "config/lab-config.json",
        "config/lab-config.container.json",
        "/workspace/rnidbg/config/lab-config.container.json",
    ] {
        if PathBuf::from(candidate).exists() {
            return candidate.to_string();
        }
    }

    "config/lab-config.container.json".to_string()
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
