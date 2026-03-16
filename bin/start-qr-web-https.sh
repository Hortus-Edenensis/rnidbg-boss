#!/usr/bin/env bash
set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
REPO_ROOT="$(cd "${SCRIPT_DIR}/.." && pwd)"
COMPOSE_FILE="${REPO_ROOT}/docker-compose.yml"
TLS_HOST_PORT="${RNIDBG_QR_WEB_TLS_HOST_PORT:-28443}"
HTTP_HOST_PORT="${RNIDBG_QR_WEB_HOST_PORT:-28786}"
TLS_DIR="${RNIDBG_QR_WEB_TLS_DIR:-${REPO_ROOT}/.local/qr-web-tls}"

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

HOST_LAN_IP="${RNIDBG_QR_WEB_TLS_SERVER_NAME:-}"
if [[ -z "${HOST_LAN_IP}" ]]; then
  HOST_LAN_IP="$(detect_host_lan_ip || true)"
fi
if [[ -z "${HOST_LAN_IP}" ]]; then
  echo "failed to detect host LAN IP; set RNIDBG_QR_WEB_TLS_SERVER_NAME first" >&2
  exit 1
fi

export RNIDBG_QR_WEB_TLS_SERVER_NAME="${HOST_LAN_IP}"
export RNIDBG_QR_WEB_PUBLIC_ORIGIN="https://${HOST_LAN_IP}:${TLS_HOST_PORT}"
export RNIDBG_QR_WEB_TLS_DIR="${TLS_DIR}"

if [[ -z "${RNIDBG_ASSETS_ROOT:-}" ]]; then
  if ASSETS_ROOT="$(detect_assets_root)"; then
    export RNIDBG_ASSETS_ROOT="${ASSETS_ROOT}"
  fi
fi

"${REPO_ROOT}/scripts/ensure-qr-web-tls.sh"

python3 - "${COMPOSE_FILE}" <<'PY'
import subprocess, sys
compose_file = sys.argv[1]
try:
    subprocess.run(
        ["docker", "compose", "-f", compose_file, "up", "-d", "rnidbg-qr-web", "rnidbg-qr-web-https"],
        check=True,
        timeout=180,
    )
except subprocess.TimeoutExpired as exc:
    raise SystemExit(f"docker compose up timed out after {exc.timeout}s")
PY

python3 - "${TLS_HOST_PORT}" <<'PY'
import json, ssl, sys, time, urllib.request
port = int(sys.argv[1])
ctx = ssl.create_default_context()
ctx.check_hostname = False
ctx.verify_mode = ssl.CERT_NONE
url = f"https://127.0.0.1:{port}/health"
last_error = None
for _ in range(60):
    try:
        with urllib.request.urlopen(url, timeout=3, context=ctx) as resp:
            body = json.loads(resp.read().decode("utf-8"))
            if str(body.get("status", "")).lower() == "ok":
                print(f"[+] rnidbg qr web https ready on :{port}")
                raise SystemExit(0)
    except Exception as exc:
        last_error = exc
        time.sleep(1)
raise SystemExit(f"qr web https failed to start on :{port}: {last_error}")
PY

echo
echo "[✓] Boss QR web HTTPS should be available at:"
echo "    https://${HOST_LAN_IP}:${TLS_HOST_PORT}/"
echo "    https://${HOST_LAN_IP}:${TLS_HOST_PORT}/health"
echo "    https://${HOST_LAN_IP}:${TLS_HOST_PORT}/api/state/latest"
if [[ -n "${RNIDBG_ASSETS_ROOT:-}" ]]; then
  echo "[i] Assets root: ${RNIDBG_ASSETS_ROOT}"
fi
echo
echo "[!] To let phone browsers use camera over HTTPS, trust this CA on the device:"
echo "    ${TLS_DIR}/ca.crt"
echo
echo "[i] Plain HTTP is still available at:"
echo "    http://${HOST_LAN_IP}:${HTTP_HOST_PORT}/"
