#![allow(dead_code, deprecated, unused_imports, unused_mut, unused_variables)]

use std::collections::HashMap;

use anyhow::{anyhow, Result};

mod boss;
mod jni;
mod palmchat;
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
        "boss-yzwg" => boss::run(args),
        "palmchat" => palmchat::run(args),
        "http-bridge" => boss::serve_http_bridge(args),
        "help" | "--help" | "-h" => {
            print_usage();
            Ok(())
        }
        command => Err(anyhow!("unknown command: {command}")),
    }
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

fn print_usage() {
    eprintln!("Usage:");
    eprintln!("  rnidbg boss-yzwg <subcommand> [options]");
    eprintln!("  rnidbg palmchat <subcommand> [options]");
    eprintln!("  rnidbg http-bridge [--config <path>] [--port <port>]");
}
