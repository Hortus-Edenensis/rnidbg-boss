#!/usr/bin/env bash
set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

APK_PATH=""
OUT_DIR=""
ARGS=()

while [[ $# -gt 0 ]]; do
  case "$1" in
    --apk)
      APK_PATH="$2"
      shift 2
      ;;
    --out-dir)
      OUT_DIR="$2"
      shift 2
      ;;
    *)
      ARGS+=("$1")
      shift
      ;;
  esac
done

if [[ -z "$APK_PATH" ]]; then
  echo "usage: $0 --apk <path> --sender-uid <uid> --friend-uid <uid> --friend-source <n> --security-id <id> --text <message> --cmid <id> --timestamp-ms <ms> [--sender-name <name>] [--friend-name <name>] [--extend <json>] [--task-id <id>] [--quote-id <id>] [--biz-id <id>] [--biz-type <n>] [--serializer-mode <serializer|patched|manual>] [--out-dir <path>]" >&2
  exit 1
fi

CLASSPATH="$("$SCRIPT_DIR/ensure-boss-apk-okhttp.sh" "$APK_PATH" "$OUT_DIR")"
exec java -cp "$CLASSPATH" rnidbg.boss.okhttp.BossApkChatPayloadCli "${ARGS[@]}"
