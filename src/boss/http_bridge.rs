use std::io::Read;
use std::path::PathBuf;

use anyhow::{anyhow, Context, Result};
use base64::engine::general_purpose::STANDARD;
use base64::Engine;
use serde_json::{json, Value};
use tiny_http::{Header, Method, Response, Server, StatusCode};

use super::BossYzwgLab;

pub fn serve(config_path: PathBuf, port: u16, backend_override: Option<&str>) -> Result<()> {
    let mut lab = BossYzwgLab::load_with_backend(&config_path, backend_override)?;
    let server = Server::http(("0.0.0.0", port))
        .map_err(|err| anyhow!("failed to bind http bridge on :{port}: {err}"))?;
    let active_backend = lab.active_backend().to_string();

    println!("[rnidbg-http-bridge] config={}", config_path.display());
    println!(
        "[rnidbg-http-bridge] requested_backend={} active_backend={}",
        lab.config().backend,
        active_backend
    );
    println!("[rnidbg-http-bridge] listening on http://0.0.0.0:{port}");
    println!("[rnidbg-http-bridge] endpoints:");
    println!("  GET  /health");
    println!("  POST /api/encode");
    println!("  POST /api/encodeRequestBody");
    println!("  POST /api/sign");
    println!("  POST /api/decode");

    for mut request in server.incoming_requests() {
        let response = match (request.method(), request.url()) {
            (&Method::Get, "/health") => json_response(
                StatusCode(200),
                json!({
                    "status": "ok",
                    "timestamp": chrono::Utc::now().timestamp_millis(),
                    "backend": active_backend,
                    "requested_backend": lab.config().backend,
                    "config_path": config_path.display().to_string(),
                }),
            ),
            (&Method::Post, "/api/encode") => match read_json(&mut request).and_then(|body| {
                let plain = string_field(&body, "plain");
                let key = string_field(&body, "key");
                Ok(json!({ "sp": lab.call_native_encode_request(plain.as_bytes(), &key)? }))
            }) {
                Ok(body) => json_response(StatusCode(200), body),
                Err(err) => error_response(err),
            },
            (&Method::Post, "/api/encodeRequestBody") => {
                match read_json(&mut request).and_then(|body| {
                    let plain = string_field(&body, "plain");
                    let key = string_field(&body, "key");
                    let encoded = lab.call_native_encode_request_body(plain.as_bytes(), &key)?;
                    Ok(json!({ "body": STANDARD.encode(encoded) }))
                }) {
                    Ok(body) => json_response(StatusCode(200), body),
                    Err(err) => error_response(err),
                }
            }
            (&Method::Post, "/api/sign") => match read_json(&mut request).and_then(|body| {
                let data = string_field(&body, "data");
                let key = string_field(&body, "key");
                Ok(json!({ "sig": lab.call_native_signature(data.as_bytes(), &key)? }))
            }) {
                Ok(body) => json_response(StatusCode(200), body),
                Err(err) => error_response(err),
            },
            (&Method::Post, "/api/decode") => match read_json(&mut request).and_then(|body| {
                let cipher = string_field(&body, "cipher");
                let key = string_field(&body, "key");
                let decoded = lab.call_native_decode_content(&cipher, &key)?;
                Ok(json!({ "plain": String::from_utf8_lossy(&decoded).to_string() }))
            }) {
                Ok(body) => json_response(StatusCode(200), body),
                Err(err) => error_response(err),
            },
            _ => json_response(StatusCode(404), json!({ "error": "not found" })),
        };

        if let Err(err) = request.respond(response) {
            eprintln!("failed to write http response: {err}");
        }
    }

    Ok(())
}

fn read_json(request: &mut tiny_http::Request) -> Result<Value> {
    let mut body = String::new();
    request
        .as_reader()
        .read_to_string(&mut body)
        .context("failed to read request body")?;
    if body.trim().is_empty() {
        return Ok(json!({}));
    }
    serde_json::from_str(&body).context("failed to parse request json")
}

fn string_field(body: &Value, key: &str) -> String {
    body.get(key)
        .and_then(Value::as_str)
        .unwrap_or_default()
        .to_string()
}

fn json_response(status: StatusCode, body: Value) -> Response<std::io::Cursor<Vec<u8>>> {
    let data = serde_json::to_vec(&body)
        .unwrap_or_else(|_| b"{\"error\":\"serialization failed\"}".to_vec());
    let mut response = Response::from_data(data).with_status_code(status);
    let content_type = Header::from_bytes("Content-Type", "application/json").unwrap();
    let cors = Header::from_bytes("Access-Control-Allow-Origin", "*").unwrap();
    response.add_header(content_type);
    response.add_header(cors);
    response
}

fn error_response(err: anyhow::Error) -> Response<std::io::Cursor<Vec<u8>>> {
    json_response(StatusCode(500), json!({ "error": format!("{err:#}") }))
}
