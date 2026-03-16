#!/usr/bin/env bash
set -euo pipefail

export PATH="/usr/local/cargo/bin:${PATH}"

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
REPO_ROOT="$(cd "${SCRIPT_DIR}/.." && pwd)"
CONTAINER_REPO_ROOT="${RNIDBG_CONTAINER_REPO_ROOT:-${REPO_ROOT}}"
DEFAULT_CONFIG="${RNIDBG_LAB_CONFIG:-${CONTAINER_REPO_ROOT}/config/lab-config.container.json}"
DEFAULT_BIND_HOST="${RNIDBG_QR_WEB_BIND_HOST:-0.0.0.0}"
DEFAULT_PORT="${RNIDBG_QR_WEB_PORT:-8786}"
if [[ -n "${RNIDBG_QR_WEB_STATE_DIR:-}" ]]; then
  DEFAULT_STATE_DIR="${RNIDBG_QR_WEB_STATE_DIR}"
elif [[ "${CONTAINER_REPO_ROOT}" == /workspace/* ]]; then
  DEFAULT_STATE_DIR="/workspace/lab-data/qr-web"
else
  DEFAULT_STATE_DIR="${CONTAINER_REPO_ROOT}/.local/qr-web-state"
fi
DEFAULT_SESSION_PATH="${RNIDBG_QR_WEB_SESSION_PATH:-}"
BACKEND_OVERRIDE=""
CONFIG="${DEFAULT_CONFIG}"

args=("$@")
has_config=0
has_bind_host=0
has_port=0
has_state_dir=0
has_session_path=0

for ((i = 0; i < ${#args[@]}; i++)); do
  if [[ "${args[$i]}" == "--config" ]] && (( i + 1 < ${#args[@]} )); then
    CONFIG="${args[$((i + 1))]}"
    has_config=1
  fi
  if [[ "${args[$i]}" == "--backend" ]] && (( i + 1 < ${#args[@]} )); then
    BACKEND_OVERRIDE="${args[$((i + 1))]}"
  fi
  if [[ "${args[$i]}" == "--bind-host" ]] && (( i + 1 < ${#args[@]} )); then
    has_bind_host=1
  fi
  if [[ "${args[$i]}" == "--port" ]] && (( i + 1 < ${#args[@]} )); then
    has_port=1
  fi
  if [[ "${args[$i]}" == "--state-dir" ]] && (( i + 1 < ${#args[@]} )); then
    has_state_dir=1
  fi
  if [[ "${args[$i]}" == "--session-path" ]] && (( i + 1 < ${#args[@]} )); then
    has_session_path=1
  fi
done

if [[ "${has_config}" -eq 0 ]]; then
  args+=(--config "${CONFIG}")
fi
if [[ "${has_bind_host}" -eq 0 ]]; then
  args+=(--bind-host "${DEFAULT_BIND_HOST}")
fi
if [[ "${has_port}" -eq 0 ]]; then
  args+=(--port "${DEFAULT_PORT}")
fi
if [[ "${has_state_dir}" -eq 0 ]]; then
  args+=(--state-dir "${DEFAULT_STATE_DIR}")
fi
BACKEND="${BACKEND_OVERRIDE}"
if [[ -z "${BACKEND}" ]]; then
  BACKEND="$(python3 - "$CONFIG" <<'PY'
import json, sys
from pathlib import Path
path = Path(sys.argv[1])
if not path.is_file():
    raise SystemExit(f"config not found: {path}")
with path.open("r", encoding="utf-8") as fh:
    data = json.load(fh)
print(str(data.get("backend", "dynarmic")).strip().lower())
PY
)"
fi

mkdir -p "${DEFAULT_STATE_DIR}"

RNIDBG_BIN="$("${SCRIPT_DIR}/ensure-rnidbg-bin.sh" "${BACKEND}")"

run_rnidbg_once() {
  "${RNIDBG_BIN}" "$@"
}

probe_session_path() {
  local candidate="$1"
  local stdout_file=""
  local stderr_file=""
  stdout_file="$(mktemp)"
  stderr_file="$(mktemp)"
  if run_rnidbg_once boss-yzwg interaction \
      --session-path "${candidate}" \
      --config "${CONFIG}" \
      --backend "${BACKEND}" \
      --invoke-runtime local \
      --transport-runtime direct \
      >"${stdout_file}" 2>"${stderr_file}"; then
    if python3 - "${stdout_file}" <<'PY'
import json, sys
with open(sys.argv[1], "r", encoding="utf-8") as fh:
    data = json.load(fh)
raise SystemExit(0 if data.get("ok") is True else 1)
PY
    then
      rm -f "${stdout_file}" "${stderr_file}"
      return 0
    fi
  fi
  rm -f "${stdout_file}" "${stderr_file}"
  return 1
}

discard_session_path() {
  local candidate="$1"
  if [[ -f "${candidate}" && "${candidate}" == /workspace/lab-assets/* ]]; then
    rm -f "${candidate}"
    echo "[!] removed unusable session: ${candidate}"
  fi
}

if [[ -z "${DEFAULT_SESSION_PATH}" ]]; then
  for candidate in \
    /workspace/lab-assets/.boss_purecalc/session.json \
    /workspace/lab-assets/boss_purecalc/.boss_purecalc/session.json \
    /workspace/lab-assets/.boss_session/session.json
  do
    if [[ -f "${candidate}" ]]; then
      if probe_session_path "${candidate}"; then
        DEFAULT_SESSION_PATH="${candidate}"
        break
      fi
      discard_session_path "${candidate}"
    fi
  done
fi

if [[ "${has_session_path}" -eq 0 && -n "${DEFAULT_SESSION_PATH}" && -f "${DEFAULT_SESSION_PATH}" ]]; then
  args+=(--session-path "${DEFAULT_SESSION_PATH}")
fi

if [[ -n "${DEFAULT_SESSION_PATH}" ]]; then
  echo "[+] qr-web selected session: ${DEFAULT_SESSION_PATH}"
fi

exec "${RNIDBG_BIN}" boss-yzwg qr-web "${args[@]}"
