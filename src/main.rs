#![allow(dead_code, deprecated, unused_imports, unused_mut, unused_variables)]

use std::collections::HashMap;
use std::path::PathBuf;

use anyhow::{anyhow, Result};

mod boss_yzwg;
mod http_bridge;
mod jni;
mod utils;
mod vm;

fn main() {
    if std::env::var_os("RUST_LOG").is_none() {
        std::env::set_var("RUST_LOG", "info");
    }
    env_logger::init();

    if let Err(err) = run() {
        eprintln!("{err:#}");
        std::process::exit(1);
    }
}

fn run() -> Result<()> {
    let mut args = std::env::args().skip(1).collect::<Vec<_>>();
    if args.is_empty() {
        print_usage();
        return Ok(());
    }

    match args.remove(0).as_str() {
        "boss-yzwg" => run_boss_yzwg(args),
        "http-bridge" => run_http_bridge(args),
        "help" | "--help" | "-h" => {
            print_usage();
            Ok(())
        }
        command => Err(anyhow!("unknown command: {command}")),
    }
}

fn run_boss_yzwg(mut args: Vec<String>) -> Result<()> {
    if args.is_empty() {
        print_boss_usage();
        return Ok(());
    }

    let command = args.remove(0);
    let opts = parse_options(&args);
    let config_path = PathBuf::from(
        opts.get("--config")
            .cloned()
            .unwrap_or_else(default_config_path),
    );
    let mut lab = boss_yzwg::BossYzwgLab::load(&config_path)?;
    let output = match command.as_str() {
        "smoke" => lab.run_smoke()?,
        "trace" => lab.run_trace(&opts)?,
        "invoke" => lab.run_invoke(&opts)?,
        "replay" => lab.run_replay(&opts)?,
        "help" | "--help" | "-h" => {
            print_boss_usage();
            return Ok(());
        }
        _ => return Err(anyhow!("unknown boss-yzwg command: {command}")),
    };

    println!("{}", serde_json::to_string_pretty(&output)?);
    Ok(())
}

fn run_http_bridge(args: Vec<String>) -> Result<()> {
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
    http_bridge::serve(config_path, port)
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

fn default_config_path() -> String {
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

fn print_usage() {
    eprintln!("Usage:");
    eprintln!("  rnidbg boss-yzwg <smoke|trace|invoke|replay> [options]");
    eprintln!("  rnidbg http-bridge [--config <path>] [--port <port>]");
}

fn print_boss_usage() {
    eprintln!("boss-yzwg commands:");
    eprintln!("  smoke   [--config <path>]");
    eprintln!("  trace   [--config <path>] [--method-filter <method|all>] [--lookup <path>]");
    eprintln!("  invoke  [--config <path>] --method <name> --arg1 <utf8|hex:...> [--arg2 <key>] [--dump-rc4 true]");
    eprintln!("  replay  [--config <path>] [--lookup <path>] [--limit <N>] [--mode <sp|sig|both>]");
}
