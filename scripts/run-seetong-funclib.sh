#!/usr/bin/env bash
set -euo pipefail

export PATH="/usr/local/cargo/bin:${PATH}"

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
REPO_ROOT="$(cd "${SCRIPT_DIR}/.." && pwd)"
CONFIG="${1:-${REPO_ROOT}/config/seetong-funclib.host.json}"

shift || true

cargo run --manifest-path "${REPO_ROOT}/Cargo.toml" -- seetong capture --config "${CONFIG}" "$@"
