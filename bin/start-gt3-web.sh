#!/usr/bin/env bash
set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
COMPOSE_FILE="${SCRIPT_DIR}/../docker-compose.yml"
HOST_PORT="${RNIDBG_GT3_WEB_HOST_PORT:-28880}"

python3 - "${COMPOSE_FILE}" <<'PY'
import subprocess, sys
compose_file = sys.argv[1]
subprocess.run(
    ["docker", "compose", "-f", compose_file, "up", "-d", "rnidbg-gt3-web"],
    check=True,
)
PY

python3 - "${HOST_PORT}" <<'PY'
import json, sys, time, urllib.request
port = int(sys.argv[1])
url = f"http://127.0.0.1:{port}/health"
last_error = None
for _ in range(40):
    try:
        with urllib.request.urlopen(url, timeout=3) as resp:
            body = json.loads(resp.read().decode("utf-8"))
            if str(body.get("status", "")).lower() == "ok":
                print(f"[+] rnidbg gt3 web ready on :{port}")
                raise SystemExit(0)
    except Exception as exc:
        last_error = exc
        time.sleep(1)
raise SystemExit(f"gt3 web failed to start on :{port}: {last_error}")
PY

echo
echo "[✓] GT3 web runner:"
echo "    http://127.0.0.1:${HOST_PORT}/"
echo "    http://127.0.0.1:${HOST_PORT}/health"
