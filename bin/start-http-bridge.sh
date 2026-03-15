#!/usr/bin/env bash
set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
COMPOSE_FILE="${SCRIPT_DIR}/../docker-compose.yml"
CONTAINER_REPO_ROOT="${RNIDBG_CONTAINER_REPO_ROOT:-/workspace/rnidbg}"
CONFIG="${RNIDBG_LAB_CONFIG:-${CONTAINER_REPO_ROOT}/config/lab-config.container.json}"
HOST_PORT="${RNIDBG_HTTP_PORT:-28080}"
CONTAINER_PORT="${RNIDBG_BRIDGE_PORT:-18080}"

docker compose -f "${COMPOSE_FILE}" up -d rnidbg-lab

docker compose -f "${COMPOSE_FILE}" exec -T rnidbg-lab bash -lc '
  if [[ -f /tmp/rnidbg-http-bridge.pid ]]; then
    kill "$(cat /tmp/rnidbg-http-bridge.pid)" >/dev/null 2>&1 || true
    rm -f /tmp/rnidbg-http-bridge.pid
  fi
'

docker compose -f "${COMPOSE_FILE}" exec -d \
  -e RNIDBG_LAB_CONFIG="${CONFIG}" \
  -e RNIDBG_CONTAINER_REPO_ROOT="${CONTAINER_REPO_ROOT}" \
  rnidbg-lab \
  bash -lc "cd $(printf '%q' "${CONTAINER_REPO_ROOT}") && ./scripts/run-http-bridge.sh --config $(printf '%q' "${CONFIG}") --port $(printf '%q' "${CONTAINER_PORT}") >/tmp/rnidbg-http-bridge.log 2>&1 & echo \$! >/tmp/rnidbg-http-bridge.pid"

python3 - "${HOST_PORT}" <<'PY'
import json, sys, time, urllib.request
port = int(sys.argv[1])
url = f"http://127.0.0.1:{port}/health"
last_error = None
for _ in range(30):
    try:
        with urllib.request.urlopen(url, timeout=2) as resp:
            body = json.loads(resp.read().decode("utf-8"))
            if str(body.get("status", "")).lower() == "ok":
                print(f"[+] rnidbg http bridge ready on :{port}")
                raise SystemExit(0)
    except Exception as exc:
        last_error = exc
        time.sleep(1)
raise SystemExit(f"bridge failed to start on :{port}: {last_error}")
PY

echo
echo "[✓] HTTP bridge should be available at:"
echo "    http://127.0.0.1:${HOST_PORT}/health"
echo "    http://127.0.0.1:${HOST_PORT}/api/encode"
echo "    http://127.0.0.1:${HOST_PORT}/api/encodeRequestBody"
echo "    http://127.0.0.1:${HOST_PORT}/api/sign"
echo "    http://127.0.0.1:${HOST_PORT}/api/decode"
