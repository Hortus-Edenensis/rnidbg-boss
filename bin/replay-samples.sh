#!/usr/bin/env bash
set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
COMPOSE_FILE="${SCRIPT_DIR}/../docker-compose.yml"
CONTAINER_REPO_ROOT="${RNIDBG_CONTAINER_REPO_ROOT:-/workspace/rnidbg}"
CONFIG="${RNIDBG_LAB_CONFIG:-${CONTAINER_REPO_ROOT}/config/lab-config.container.json}"
LIMIT="${1:-20}"

docker compose -f "${COMPOSE_FILE}" up -d rnidbg-lab

docker compose -f "${COMPOSE_FILE}" exec -T \
  -e RNIDBG_LAB_CONFIG="${CONFIG}" \
  -e RNIDBG_CONTAINER_REPO_ROOT="${CONTAINER_REPO_ROOT}" \
  rnidbg-lab \
  bash -lc "cd $(printf '%q' "${CONTAINER_REPO_ROOT}") && ./scripts/run-boss-yzwg.sh replay --config $(printf '%q' "${CONFIG}") --mode both --limit $(printf '%q' "${LIMIT}")"
