#!/usr/bin/env bash
set -euo pipefail

BASE_URL="${1:-http://127.0.0.1:${RNIDBG_HTTP_PORT:-28080}}"

python3 - "${BASE_URL}" <<'PY'
import json
import sys
import urllib.request

base = sys.argv[1].rstrip("/")

def request(path, payload=None):
    data = None if payload is None else json.dumps(payload).encode("utf-8")
    req = urllib.request.Request(
        base + path,
        data=data,
        headers={"Content-Type": "application/json"},
        method="GET" if payload is None else "POST",
    )
    with urllib.request.urlopen(req, timeout=10) as resp:
        return json.loads(resp.read().decode("utf-8"))

health = request("/health")
if str(health.get("status", "")).lower() != "ok":
    raise SystemExit("/health returned non-ok status")
print("[+] /health ok")

encode = request("/api/encode", {"plain": "a=1&b=2", "key": ""})
if not str(encode.get("sp", "") or ""):
    raise SystemExit("/api/encode returned empty sp")
print("[+] /api/encode ok")

sign = request("/api/sign", {"data": "/api/health-checka=1&b=2", "key": ""})
if not str(sign.get("sig", "") or ""):
    raise SystemExit("/api/sign returned empty sig")
print("[+] /api/sign ok")

print("[✓] rnidbg HttpBridge signer endpoints verified")
PY
