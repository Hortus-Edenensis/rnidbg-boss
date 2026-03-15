#!/usr/bin/env bash
set -euo pipefail

if [[ $# -lt 1 ]]; then
  echo "usage: $0 <apk-path> [out-dir]" >&2
  exit 1
fi

APK_PATH="$1"
OUT_DIR="${2:-}"
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
REPO_ROOT="$(cd "$SCRIPT_DIR/.." && pwd)"

if [[ -z "$OUT_DIR" ]]; then
  OUT_DIR="$REPO_ROOT/target/boss-apk-okhttp"
fi

JAVA_SRC="$REPO_ROOT/java/boss_apk_okhttp/src/rnidbg/boss/okhttp/BossApkOkHttpCli.java"
CLASSES_DIR="$OUT_DIR/classes"
DEX2JAR_VERSION="2.4"
DEX2JAR_ZIP="dex-tools-v${DEX2JAR_VERSION}.zip"
DEX2JAR_URL="https://github.com/pxb1988/dex2jar/releases/download/v${DEX2JAR_VERSION}/${DEX2JAR_ZIP}"
DEX2JAR_HOME="$OUT_DIR/dex-tools-v${DEX2JAR_VERSION}"
DEX2JAR_BIN=""
JAR_PATH="$OUT_DIR/boss-apk-okhttp.jar"
STAMP_PATH="$CLASSES_DIR/.compiled.stamp"

mkdir -p "$OUT_DIR"

if command -v d2j-dex2jar >/dev/null 2>&1; then
  DEX2JAR_BIN="$(command -v d2j-dex2jar)"
elif [[ -x "$DEX2JAR_HOME/d2j-dex2jar.sh" ]]; then
  DEX2JAR_BIN="$DEX2JAR_HOME/d2j-dex2jar.sh"
else
  ARCHIVE_PATH="$OUT_DIR/$DEX2JAR_ZIP"
  curl -L "$DEX2JAR_URL" -o "$ARCHIVE_PATH"
  rm -rf "$DEX2JAR_HOME"
  unzip -q "$ARCHIVE_PATH" -d "$OUT_DIR"
  chmod +x "$DEX2JAR_HOME"/*.sh
  DEX2JAR_BIN="$DEX2JAR_HOME/d2j-dex2jar.sh"
fi

if [[ ! -f "$JAR_PATH" || "$APK_PATH" -nt "$JAR_PATH" ]]; then
  "$DEX2JAR_BIN" -f "$APK_PATH" -o "$JAR_PATH"
fi

if [[ ! -f "$STAMP_PATH" || "$JAVA_SRC" -nt "$STAMP_PATH" || "$JAR_PATH" -nt "$STAMP_PATH" ]]; then
  rm -rf "$CLASSES_DIR"
  mkdir -p "$CLASSES_DIR"
  javac -encoding UTF-8 -cp "$JAR_PATH" -d "$CLASSES_DIR" "$JAVA_SRC"
  touch "$STAMP_PATH"
fi

printf '%s:%s\n' "$JAR_PATH" "$CLASSES_DIR"
