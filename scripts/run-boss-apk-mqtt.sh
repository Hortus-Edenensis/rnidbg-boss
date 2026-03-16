#!/usr/bin/env bash
set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

APK_PATH=""
PAYLOAD_BASE64=""
USER_ID=""
ROLE=""
SECRET_KEY=""
CLIENT_SEED=""
USERNAME=""
APP_VERSION=""
BROKER_URL=""
TOPIC=""
QOS=""
SEQUENCE_ID=""
KEEP_ALIVE=""
CONNECTION_TIMEOUT=""
SUBSCRIBE=""
CLEAN_SESSION=""
WAIT_AFTER_PUBLISH_MS=""
WAIT_AFTER_PRESENCE_MS=""
OUT_DIR=""
PRE_PUBLISH_BASE64=()

while [[ $# -gt 0 ]]; do
  case "$1" in
    --apk)
      APK_PATH="$2"
      shift 2
      ;;
    --payload-base64)
      PAYLOAD_BASE64="$2"
      shift 2
      ;;
    --uid)
      USER_ID="$2"
      shift 2
      ;;
    --role)
      ROLE="$2"
      shift 2
      ;;
    --secret-key)
      SECRET_KEY="$2"
      shift 2
      ;;
    --client-seed)
      CLIENT_SEED="$2"
      shift 2
      ;;
    --username)
      USERNAME="$2"
      shift 2
      ;;
    --app-version)
      APP_VERSION="$2"
      shift 2
      ;;
    --broker-url)
      BROKER_URL="$2"
      shift 2
      ;;
    --topic)
      TOPIC="$2"
      shift 2
      ;;
    --qos)
      QOS="$2"
      shift 2
      ;;
    --sequence-id)
      SEQUENCE_ID="$2"
      shift 2
      ;;
    --keep-alive)
      KEEP_ALIVE="$2"
      shift 2
      ;;
    --connection-timeout)
      CONNECTION_TIMEOUT="$2"
      shift 2
      ;;
    --subscribe)
      SUBSCRIBE="$2"
      shift 2
      ;;
    --clean-session)
      CLEAN_SESSION="$2"
      shift 2
      ;;
    --wait-after-publish-ms)
      WAIT_AFTER_PUBLISH_MS="$2"
      shift 2
      ;;
    --wait-after-presence-ms)
      WAIT_AFTER_PRESENCE_MS="$2"
      shift 2
      ;;
    --out-dir)
      OUT_DIR="$2"
      shift 2
      ;;
    --pre-publish-base64)
      PRE_PUBLISH_BASE64+=("$2")
      shift 2
      ;;
    *)
      echo "unsupported argument: $1" >&2
      exit 1
      ;;
  esac
done

if [[ -z "$APK_PATH" || -z "$PAYLOAD_BASE64" || -z "$USER_ID" || -z "$ROLE" || -z "$SECRET_KEY" ]]; then
  echo "usage: $0 --apk <path> --payload-base64 <b64> --uid <uid> --role <role> --secret-key <secret> [--client-seed <seed>] [--app-version <version>] [--broker-url <url>] [--topic <topic>] [--qos <0|1|2>] [--sequence-id <id>] [--keep-alive <sec>] [--connection-timeout <sec>] [--subscribe true|false] [--clean-session true|false] [--wait-after-publish-ms <ms>] [--wait-after-presence-ms <ms>]" >&2
  exit 1
fi

CLASSPATH="$("$SCRIPT_DIR/ensure-boss-apk-okhttp.sh" "$APK_PATH" "$OUT_DIR")"
CMD=(
  java
  -cp
  "$CLASSPATH"
  rnidbg.boss.okhttp.BossApkMqttCli
  --apk
  "$APK_PATH"
  --payload-base64
  "$PAYLOAD_BASE64"
  --uid
  "$USER_ID"
  --role
  "$ROLE"
  --secret-key
  "$SECRET_KEY"
)

if [[ -n "$CLIENT_SEED" ]]; then
  CMD+=(--client-seed "$CLIENT_SEED")
fi

if [[ -n "$USERNAME" ]]; then
  CMD+=(--username "$USERNAME")
fi

if [[ -n "$APP_VERSION" ]]; then
  CMD+=(--app-version "$APP_VERSION")
fi

if [[ -n "$BROKER_URL" ]]; then
  CMD+=(--broker-url "$BROKER_URL")
fi

if [[ -n "$TOPIC" ]]; then
  CMD+=(--topic "$TOPIC")
fi

if [[ -n "$QOS" ]]; then
  CMD+=(--qos "$QOS")
fi

if [[ -n "$SEQUENCE_ID" ]]; then
  CMD+=(--sequence-id "$SEQUENCE_ID")
fi

if [[ -n "$KEEP_ALIVE" ]]; then
  CMD+=(--keep-alive "$KEEP_ALIVE")
fi

if [[ -n "$CONNECTION_TIMEOUT" ]]; then
  CMD+=(--connection-timeout "$CONNECTION_TIMEOUT")
fi

if [[ -n "$SUBSCRIBE" ]]; then
  CMD+=(--subscribe "$SUBSCRIBE")
fi

if [[ -n "$CLEAN_SESSION" ]]; then
  CMD+=(--clean-session "$CLEAN_SESSION")
fi

if [[ -n "$WAIT_AFTER_PUBLISH_MS" ]]; then
  CMD+=(--wait-after-publish-ms "$WAIT_AFTER_PUBLISH_MS")
fi

if [[ -n "$WAIT_AFTER_PRESENCE_MS" ]]; then
  CMD+=(--wait-after-presence-ms "$WAIT_AFTER_PRESENCE_MS")
fi

for pre_payload in "${PRE_PUBLISH_BASE64[@]}"; do
  CMD+=(--pre-publish-base64 "$pre_payload")
done

exec "${CMD[@]}"
