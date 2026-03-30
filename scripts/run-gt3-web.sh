#!/usr/bin/env bash
set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
REPO_ROOT="$(cd "${SCRIPT_DIR}/.." && pwd)"

HOST="${RNIDBG_GT3_WEB_BIND_HOST:-0.0.0.0}"
PORT="${RNIDBG_GT3_WEB_PORT:-8880}"

cd "${REPO_ROOT}"
exec python3 tools/gt3-web/server.py --host "${HOST}" --port "${PORT}"
