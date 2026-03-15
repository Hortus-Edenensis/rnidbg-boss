#!/usr/bin/env bash
set -euo pipefail

if command -v sudo >/dev/null 2>&1; then
  SUDO=(sudo)
else
  SUDO=()
fi

"${SUDO[@]}" apt-get update
"${SUDO[@]}" apt-get install -y --no-install-recommends \
  build-essential \
  clang \
  cmake \
  curl \
  git \
  libboost-all-dev \
  libfmt-dev \
  libzydis-dev \
  ninja-build \
  pkg-config \
  python3
