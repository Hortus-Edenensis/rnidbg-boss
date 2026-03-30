#!/usr/bin/env bash
set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
CLI="${SCRIPT_DIR}/seetong_blackbox_cli.py"

if [[ ! -f "${CLI}" ]]; then
  echo "missing CLI script: ${CLI}" >&2
  exit 1
fi

if [[ $# -eq 0 ]]; then
  exec python3 "${CLI}" run
fi

case "${1}" in
  run|make-sample|-h|--help)
    exec python3 "${CLI}" "$@"
    ;;
  *)
    exec python3 "${CLI}" run "$@"
    ;;
esac
