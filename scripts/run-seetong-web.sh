#!/usr/bin/env bash
set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
REPO_ROOT="$(cd "${SCRIPT_DIR}/.." && pwd)"

HOST="${RNIDBG_SEETONG_WEB_BIND_HOST:-0.0.0.0}"
PORT="${RNIDBG_SEETONG_WEB_PORT:-8891}"
BACKEND="${RNIDBG_SEETONG_WEB_BACKEND:-unicorn}"
MODE="${RNIDBG_SEETONG_WEB_MODE:-blackbox}"

cd "${REPO_ROOT}"
exec python3 tools/seetong-web/server.py --host "${HOST}" --port "${PORT}" --backend "${BACKEND}" --mode "${MODE}"
