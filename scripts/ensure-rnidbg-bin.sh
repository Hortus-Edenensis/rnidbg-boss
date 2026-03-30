#!/usr/bin/env bash
set -euo pipefail

export PATH="/usr/local/cargo/bin:${PATH}"

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
REPO_ROOT="$(cd "${SCRIPT_DIR}/.." && pwd)"
CONTAINER_REPO_ROOT_ENV="${RNIDBG_CONTAINER_REPO_ROOT:-}"
CONTAINER_REPO_ROOT="${CONTAINER_REPO_ROOT_ENV:-${REPO_ROOT}}"
CONTAINER_TARGET_ROOT="${RNIDBG_CONTAINER_TARGET_ROOT:-/workspace/lab-data/cargo-targets}"

BACKEND_MODE="${1:-default}"
PROFILE="${RNIDBG_BUILD_PROFILE:-debug}"
HOST_OS="$(uname -s)"

case "${BACKEND_MODE}" in
  unicorn|unicorn2)
    TARGET_DIR="${RNIDBG_UNICORN_TARGET_DIR:-${CONTAINER_REPO_ROOT}/target/rnidbg-unicorn}"
    FEATURE_FLAG="unicorn"
    TARGET_SUFFIX="rnidbg-unicorn"
    ;;
  *)
    TARGET_DIR="${RNIDBG_DEFAULT_TARGET_DIR:-${CONTAINER_REPO_ROOT}/target/rnidbg-default}"
    FEATURE_FLAG=""
    TARGET_SUFFIX="rnidbg-default"
    ;;
esac

# In Docker we share the repository worktree with the host, so `${REPO_ROOT}/target`
# may already contain a host-built Mach-O binary. Redirect container builds into
# a dedicated Linux-only target root to avoid reusing or overwriting host artifacts.
if [[ "${HOST_OS}" == "Linux" ]] && [[ -n "${CONTAINER_REPO_ROOT_ENV}" ]] && [[ "${TARGET_DIR}" == "${CONTAINER_REPO_ROOT}/target/"* ]]; then
  TARGET_DIR="${CONTAINER_TARGET_ROOT}/${TARGET_SUFFIX}"
fi

case "${PROFILE}" in
  release)
    BUILD_PROFILE_FLAG="--release"
    BIN_PATH="${TARGET_DIR}/release/rnidbg"
    ;;
  debug)
    BUILD_PROFILE_FLAG=""
    BIN_PATH="${TARGET_DIR}/debug/rnidbg"
    ;;
  *)
    echo "unsupported RNIDBG_BUILD_PROFILE: ${PROFILE}" >&2
    exit 1
    ;;
esac

repo_has_newer_sources() {
  local bin_path="$1"
  find "${CONTAINER_REPO_ROOT}" \
    -path "${CONTAINER_REPO_ROOT}/target" -prune -o \
    -path "${CONTAINER_REPO_ROOT}/.git" -prune -o \
    -type f \
    \( -name '*.rs' -o -name 'Cargo.toml' -o -name 'Cargo.lock' -o -name 'build.rs' \) \
    -newer "${bin_path}" \
    -print -quit 2>/dev/null | grep -q .
}

needs_build=0
if [[ ! -x "${BIN_PATH}" ]]; then
  needs_build=1
elif repo_has_newer_sources "${BIN_PATH}"; then
  needs_build=1
fi

if [[ "${needs_build}" -eq 1 ]]; then
  echo "[+] building rnidbg binary (${BACKEND_MODE}, ${PROFILE}) at ${BIN_PATH}" >&2
  cargo_cmd=(cargo build --target-dir "${TARGET_DIR}")
  if [[ -n "${BUILD_PROFILE_FLAG}" ]]; then
    cargo_cmd+=("${BUILD_PROFILE_FLAG}")
  fi
  if [[ -n "${FEATURE_FLAG}" ]]; then
    cargo_cmd+=(--no-default-features --features "${FEATURE_FLAG}")
  fi
  "${cargo_cmd[@]}"
fi

printf '%s\n' "${BIN_PATH}"
