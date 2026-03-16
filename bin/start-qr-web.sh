#!/usr/bin/env bash
set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
COMPOSE_FILE="${SCRIPT_DIR}/../docker-compose.yml"
HOST_PORT="${RNIDBG_QR_WEB_HOST_PORT:-28786}"

detect_host_lan_ip() {
  local default_iface=""
  local iface=""
  local ip=""

  default_iface="$(route get default 2>/dev/null | awk '/interface:/{print $2; exit}')"

  for iface in "${default_iface}" en0 en1 en5 en7; do
    if [[ -z "${iface}" ]]; then
      continue
    fi
    if [[ "${iface}" == utun* || "${iface}" == bridge* || "${iface}" == lo0 ]]; then
      continue
    fi
    ip="$(ipconfig getifaddr "${iface}" 2>/dev/null || true)"
    if [[ -n "${ip}" ]]; then
      printf '%s\n' "${ip}"
      return 0
    fi
  done

  return 1
}

detect_assets_root() {
  local candidate=""
  for candidate in \
    "${SCRIPT_DIR}/../../drizzle-dumper-rust" \
    "/Users/haojiejack/github/drizzle-dumper-rust" \
    "${HOME}/github/drizzle-dumper-rust"
  do
    if [[ -d "${candidate}" && ( -f "${candidate}/.boss_purecalc/session.json" || -f "${candidate}/boss_purecalc/.boss_purecalc/session.json" ) ]]; then
      printf '%s\n' "${candidate}"
      return 0
    fi
  done
  return 1
}

if [[ -z "${RNIDBG_QR_WEB_PUBLIC_ORIGIN:-}" ]]; then
  if HOST_LAN_IP="$(detect_host_lan_ip)"; then
    export RNIDBG_QR_WEB_PUBLIC_ORIGIN="http://${HOST_LAN_IP}:${HOST_PORT}"
  fi
fi

if [[ -z "${RNIDBG_ASSETS_ROOT:-}" ]]; then
  if ASSETS_ROOT="$(detect_assets_root)"; then
    export RNIDBG_ASSETS_ROOT="${ASSETS_ROOT}"
  fi
fi

python3 - "${COMPOSE_FILE}" <<'PY'
import subprocess, sys
compose_file = sys.argv[1]
try:
    subprocess.run(
        ["docker", "compose", "-f", compose_file, "up", "-d", "rnidbg-qr-web"],
        check=True,
        timeout=120,
    )
except subprocess.TimeoutExpired as exc:
    raise SystemExit(f"docker compose up timed out after {exc.timeout}s")
PY

python3 - "${HOST_PORT}" <<'PY'
import json, sys, time, urllib.request
port = int(sys.argv[1])
url = f"http://127.0.0.1:{port}/health"
last_error = None
for _ in range(60):
    try:
        with urllib.request.urlopen(url, timeout=3) as resp:
            body = json.loads(resp.read().decode("utf-8"))
            if str(body.get("status", "")).lower() == "ok":
                print(f"[+] rnidbg qr web ready on :{port}")
                raise SystemExit(0)
    except Exception as exc:
        last_error = exc
        time.sleep(1)
raise SystemExit(f"qr web failed to start on :{port}: {last_error}")
PY

echo
echo "[✓] Boss QR web should be available at:"
echo "    http://127.0.0.1:${HOST_PORT}/"
if [[ -n "${RNIDBG_QR_WEB_PUBLIC_ORIGIN:-}" ]]; then
  echo "    ${RNIDBG_QR_WEB_PUBLIC_ORIGIN}/"
fi
if [[ -n "${RNIDBG_ASSETS_ROOT:-}" ]]; then
  echo "[i] Assets root: ${RNIDBG_ASSETS_ROOT}"
fi
echo "    http://127.0.0.1:${HOST_PORT}/health"
echo "    http://127.0.0.1:${HOST_PORT}/api/state/latest"
