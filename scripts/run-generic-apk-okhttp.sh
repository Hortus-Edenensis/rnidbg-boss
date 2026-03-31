#!/usr/bin/env bash
set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

APK_PATH=""
METHOD="GET"
URL=""
CONTENT_TYPE=""
BODY_BASE64=""
OUT_DIR=""
HEADERS=()
SOCKS5_HOST=""
SOCKS5_PORT=""
SOCKS5_USERNAME=""
SOCKS5_PASSWORD=""

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
    --socks5-host)
      SOCKS5_HOST="$2"
      shift 2
      ;;
    --socks5-port)
      SOCKS5_PORT="$2"
      shift 2
      ;;
    --socks5-username)
      SOCKS5_USERNAME="$2"
      shift 2
      ;;
    --socks5-password)
      SOCKS5_PASSWORD="$2"
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

CLASSPATH="$("$SCRIPT_DIR/ensure-generic-apk-okhttp.sh" "$APK_PATH" "$OUT_DIR")"
CMD=(java -cp "$CLASSPATH" rnidbg.generic.okhttp.GenericApkOkHttpCli --method "$METHOD" --url "$URL")

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

if [[ -n "$SOCKS5_HOST" ]]; then
  CMD+=(--socks5-host "$SOCKS5_HOST")
fi
if [[ -n "$SOCKS5_PORT" ]]; then
  CMD+=(--socks5-port "$SOCKS5_PORT")
fi
if [[ -n "$SOCKS5_USERNAME" ]]; then
  CMD+=(--socks5-username "$SOCKS5_USERNAME")
fi
if [[ -n "$SOCKS5_PASSWORD" ]]; then
  CMD+=(--socks5-password "$SOCKS5_PASSWORD")
fi

exec "${CMD[@]}"
