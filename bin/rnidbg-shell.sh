#!/usr/bin/env bash
set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
COMPOSE_FILE="${SCRIPT_DIR}/../docker-compose.yml"
CONTAINER_REPO_ROOT="${RNIDBG_CONTAINER_REPO_ROOT:-/workspace/rnidbg}"

docker compose -f "${COMPOSE_FILE}" up -d rnidbg-lab
exec docker compose -f "${COMPOSE_FILE}" exec \
  -e RNIDBG_CONTAINER_REPO_ROOT="${CONTAINER_REPO_ROOT}" \
  rnidbg-lab \
  bash -lc "cd $(printf '%q' "${CONTAINER_REPO_ROOT}") && exec bash"
