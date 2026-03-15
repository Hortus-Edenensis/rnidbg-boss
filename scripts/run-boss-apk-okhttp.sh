#!/usr/bin/env bash
set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
REPO_ROOT="$(cd "$SCRIPT_DIR/.." && pwd)"

APK_PATH=""
METHOD="GET"
URL=""
CONTENT_TYPE=""
BODY_BASE64=""
OUT_DIR=""
HEADERS=()

while [[ $# -gt 0 ]]; do
  case "$1" in
    --apk)
      APK_PATH="$2"
      shift 2
      ;;
    --method)
      METHOD="$2"
      shift 2
      ;;
    --url)
      URL="$2"
      shift 2
      ;;
    --content-type)
      CONTENT_TYPE="$2"
      shift 2
      ;;
    --body-base64)
      BODY_BASE64="$2"
      shift 2
      ;;
    --out-dir)
      OUT_DIR="$2"
      shift 2
      ;;
    --header)
      HEADERS+=("$2")
      shift 2
      ;;
    *)
      echo "unsupported argument: $1" >&2
      exit 1
      ;;
  esac
done

if [[ -z "$APK_PATH" || -z "$URL" ]]; then
  echo "usage: $0 --apk <path> --url <url> [--method GET|POST] [--content-type <type>] [--body-base64 <b64>] [--header key:value]" >&2
  exit 1
fi

CLASSPATH="$("$SCRIPT_DIR/ensure-boss-apk-okhttp.sh" "$APK_PATH" "$OUT_DIR")"
CMD=(java -cp "$CLASSPATH" rnidbg.boss.okhttp.BossApkOkHttpCli --method "$METHOD" --url "$URL")

if [[ -n "$CONTENT_TYPE" ]]; then
  CMD+=(--content-type "$CONTENT_TYPE")
fi

if [[ -n "$BODY_BASE64" ]]; then
  CMD+=(--body-base64 "$BODY_BASE64")
fi

if ((${#HEADERS[@]})); then
  for header in "${HEADERS[@]}"; do
    CMD+=(--header "$header")
  done
fi

exec "${CMD[@]}"
