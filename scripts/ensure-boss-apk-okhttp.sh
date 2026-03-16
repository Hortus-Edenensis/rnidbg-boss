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

JAVA_SRC_DIR="$REPO_ROOT/java/boss_apk_okhttp/src"
CLASSES_DIR="$OUT_DIR/classes"
DEX2JAR_VERSION="2.4"
DEX2JAR_ZIP="dex-tools-v${DEX2JAR_VERSION}.zip"
DEX2JAR_URL="https://github.com/pxb1988/dex2jar/releases/download/v${DEX2JAR_VERSION}/${DEX2JAR_ZIP}"
DEX2JAR_HOME="$OUT_DIR/dex-tools-v${DEX2JAR_VERSION}"
DEX2JAR_BIN=""
PAHO_VERSION="1.2.5"
PAHO_JAR="org.eclipse.paho.client.mqttv3-${PAHO_VERSION}.jar"
PAHO_URL="https://repo1.maven.org/maven2/org/eclipse/paho/org.eclipse.paho.client.mqttv3/${PAHO_VERSION}/${PAHO_JAR}"
PAHO_PATH="$OUT_DIR/$PAHO_JAR"
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

if [[ ! -f "$PAHO_PATH" ]]; then
  curl -L "$PAHO_URL" -o "$PAHO_PATH"
fi

JAVA_SOURCES=()
while IFS= read -r java_src; do
  JAVA_SOURCES+=("$java_src")
done < <(find "$JAVA_SRC_DIR" -type f -name '*.java' | sort)

if [[ ${#JAVA_SOURCES[@]} -eq 0 ]]; then
  echo "no Java sources found under $JAVA_SRC_DIR" >&2
  exit 1
fi

NEEDS_COMPILE=0
if [[ ! -f "$STAMP_PATH" || "$JAR_PATH" -nt "$STAMP_PATH" ]]; then
  NEEDS_COMPILE=1
else
  for java_src in "${JAVA_SOURCES[@]}"; do
    if [[ "$java_src" -nt "$STAMP_PATH" ]]; then
      NEEDS_COMPILE=1
      break
    fi
  done
fi

if (( NEEDS_COMPILE )); then
  rm -rf "$CLASSES_DIR"
  mkdir -p "$CLASSES_DIR"
  javac -encoding UTF-8 -cp "$JAR_PATH:$PAHO_PATH" -d "$CLASSES_DIR" "${JAVA_SOURCES[@]}"
  touch "$STAMP_PATH"
fi

printf '%s:%s:%s\n' "$CLASSES_DIR" "$JAR_PATH" "$PAHO_PATH"
