#!/usr/bin/env python3
from __future__ import annotations

import argparse
import json
import sys
import time
import urllib.parse
import urllib.request
from pathlib import Path


def normalize_truth_from_url(url: str, cookies: str, ua: str, bootstrap: str, followup: str):
    parsed = urllib.parse.urlparse(url)
    qs = urllib.parse.parse_qs(parsed.query, keep_blank_values=True)
    flat = {key: values[-1] if values else "" for key, values in qs.items()}
    challenge = str(flat.get("challenge") or "").strip()
    return {
        "gt": str(flat.get("gt") or "").strip(),
        "bootstrap_challenge": bootstrap or challenge,
        "followup_challenge": followup or challenge,
        "final_challenge": challenge,
        "client_type": str(flat.get("client_type") or "").strip(),
        "pt": str(flat.get("pt") or "").strip(),
        "http_method": "GET",
        "request_url": url,
        "query_shape": sorted(flat.keys()),
        "body_shape": [],
        "w": str(flat.get("w") or ""),
        "w_length": len(str(flat.get("w") or "")),
        "ua": ua,
        "geetest_cookie_snapshot": cookies,
        "proof_source_tag": "production-device.frida",
        "ts_ms": int(time.time() * 1000),
    }


def normalize_truth_response(dialog_result: str):
    payload = {}
    try:
        payload = json.loads(dialog_result or "{}")
    except Exception:
        payload = {}
    validate = str(payload.get("geetest_validate") or "").strip()
    sec_code = str(payload.get("geetest_seccode") or "").strip()
    if validate and not sec_code:
        sec_code = f"{validate}|jordan"
    return {
        "ajax_raw": {},
        "success_callback_payload": {
            "geetest_challenge": str(payload.get("geetest_challenge") or "").strip(),
            "geetest_validate": validate,
            "geetest_seccode": sec_code,
        },
        "validate": validate,
        "sec_code": sec_code,
    }


def post_import(server_base: str, session_id: str, truth: dict, truth_response: dict):
    body = json.dumps({
        "session_id": session_id,
        "production_proof_truth": truth,
        "production_proof_truth_response": truth_response,
    }).encode("utf-8")
    req = urllib.request.Request(
        urllib.parse.urljoin(server_base.rstrip("/") + "/", "api/production_truth/import"),
        data=body,
        method="POST",
        headers={"content-type": "application/json"},
    )
    with urllib.request.urlopen(req, timeout=30) as resp:
        return json.loads(resp.read().decode("utf-8"))


def main() -> int:
    parser = argparse.ArgumentParser(description="Capture Boss App GT3 production truth via Frida")
    parser.add_argument("--package", default="com.hpbr.bosszhipin")
    parser.add_argument("--session-id", default="")
    parser.add_argument("--server-base", default="http://127.0.0.1:28880/")
    parser.add_argument("--out-dir", default=str(Path.cwd()))
    parser.add_argument("--timeout", type=int, default=120)
    args = parser.parse_args()

    try:
        import frida
    except ImportError:
        print("frida is required: pip install frida-tools", file=sys.stderr)
        return 2

    hook_path = Path(__file__).with_name("geetest_ajax_hook.js")
    hook_code = hook_path.read_text(encoding="utf-8")
    out_dir = Path(args.out_dir)
    out_dir.mkdir(parents=True, exist_ok=True)

    bootstrap_challenge = ""
    followup_challenge = ""
    truth = {}
    truth_response = {}

    def on_message(message, _data):
        nonlocal bootstrap_challenge, followup_challenge, truth, truth_response
        if message.get("type") != "send":
            return
        payload = message.get("payload") or {}
        msg_type = str(payload.get("type") or "").strip()
        if msg_type == "gt_webview_url":
            url = str(payload.get("url") or "").strip()
            parsed = urllib.parse.urlparse(url)
            if parsed.path.endswith("/get.php"):
                qs = urllib.parse.parse_qs(parsed.query, keep_blank_values=True)
                bootstrap_challenge = str((qs.get("challenge") or [""])[-1] or "").strip() or bootstrap_challenge
                followup_challenge = bootstrap_challenge
            elif parsed.path.endswith("/ajax.php"):
                truth = normalize_truth_from_url(
                    url,
                    str(payload.get("cookies") or "").strip(),
                    str(payload.get("ua") or "").strip(),
                    bootstrap_challenge,
                    followup_challenge,
                )
        elif msg_type == "gt_dialog_result":
            truth_response = normalize_truth_response(str(payload.get("result") or ""))

    device = frida.get_usb_device(timeout=5)
    session = device.attach(args.package)
    script = session.create_script(hook_code)
    script.on("message", on_message)
    script.load()

    started = time.time()
    while time.time() - started < args.timeout:
        if truth and truth_response:
            break
        time.sleep(0.5)

    session.detach()

    truth_path = out_dir / "gt3_proof_truth.json"
    truth_response_path = out_dir / "gt3_proof_truth_response.json"
    truth_path.write_text(json.dumps(truth, ensure_ascii=False, indent=2), encoding="utf-8")
    truth_response_path.write_text(json.dumps(truth_response, ensure_ascii=False, indent=2), encoding="utf-8")

    output = {
        "ok": bool(truth),
        "truth_path": str(truth_path),
        "truth_response_path": str(truth_response_path),
        "production_proof_truth": truth,
        "production_proof_truth_response": truth_response,
    }
    if truth and args.session_id:
        try:
            output["import_result"] = post_import(
                args.server_base,
                args.session_id,
                truth,
                truth_response,
            )
        except Exception as exc:
            output["import_error"] = str(exc)
    print(json.dumps(output, ensure_ascii=False, indent=2))
    return 0 if truth else 1


if __name__ == "__main__":
    raise SystemExit(main())
