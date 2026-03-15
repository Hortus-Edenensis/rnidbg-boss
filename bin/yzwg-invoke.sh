#!/usr/bin/env bash
set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
COMPOSE_FILE="${SCRIPT_DIR}/../docker-compose.yml"
CONTAINER_REPO_ROOT="${RNIDBG_CONTAINER_REPO_ROOT:-/workspace/rnidbg}"
CONFIG="${RNIDBG_LAB_CONFIG:-${CONTAINER_REPO_ROOT}/config/lab-config.container.json}"

quote_args() {
  local quoted=()
  for arg in "$@"; do
    quoted+=("$(printf '%q' "$arg")")
  done
  printf '%s' "${quoted[*]}"
}

EXTRA_ARGS=("$@")

if [[ ${#EXTRA_ARGS[@]} -eq 0 ]]; then
  EXTRA_ARGS=(--method nativeSignature --arg1 '/api/health-check' --arg2 '')
fi

docker compose -f "${COMPOSE_FILE}" up -d rnidbg-lab

docker compose -f "${COMPOSE_FILE}" exec -T \
  -e RNIDBG_LAB_CONFIG="${CONFIG}" \
  -e RNIDBG_CONTAINER_REPO_ROOT="${CONTAINER_REPO_ROOT}" \
  rnidbg-lab \
  bash -lc "cd $(printf '%q' "${CONTAINER_REPO_ROOT}") && ./scripts/run-boss-yzwg.sh invoke --config $(printf '%q' "${CONFIG}") $(quote_args "${EXTRA_ARGS[@]}")"
