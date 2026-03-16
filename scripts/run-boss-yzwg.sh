#!/usr/bin/env bash
set -euo pipefail

export PATH="/usr/local/cargo/bin:${PATH}"

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
REPO_ROOT="$(cd "${SCRIPT_DIR}/.." && pwd)"
CONTAINER_REPO_ROOT="${RNIDBG_CONTAINER_REPO_ROOT:-${REPO_ROOT}}"
DEFAULT_CONFIG="${RNIDBG_LAB_CONFIG:-${CONTAINER_REPO_ROOT}/config/lab-config.container.json}"
CONFIG="${DEFAULT_CONFIG}"
BACKEND_OVERRIDE=""

args=("$@")
for ((i = 0; i < ${#args[@]}; i++)); do
  if [[ "${args[$i]}" == "--config" ]] && (( i + 1 < ${#args[@]} )); then
    CONFIG="${args[$((i + 1))]}"
  fi
  if [[ "${args[$i]}" == "--backend" ]] && (( i + 1 < ${#args[@]} )); then
    BACKEND_OVERRIDE="${args[$((i + 1))]}"
  fi
done

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

RNIDBG_BIN="$("${SCRIPT_DIR}/ensure-rnidbg-bin.sh" "${BACKEND}")"

exec "${RNIDBG_BIN}" boss-yzwg "$@"
