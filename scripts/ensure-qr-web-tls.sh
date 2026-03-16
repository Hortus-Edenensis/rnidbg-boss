#!/usr/bin/env bash
set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
REPO_ROOT="$(cd "${SCRIPT_DIR}/.." && pwd)"
TLS_DIR="${RNIDBG_QR_WEB_TLS_DIR:-${REPO_ROOT}/.local/qr-web-tls}"
HOST_IP="${RNIDBG_QR_WEB_TLS_SERVER_NAME:-}"

detect_host_lan_ip() {
  local default_iface=""
  local iface=""
  local ip=""

  default_iface="$(route get default 2>/dev/null | awk '/interface:/{print $2; exit}')"
  for iface in "${default_iface}" en0 en1 en5 en7; do
    if [[ -z "${iface}" ]]; then
      continue
    fi
    if [[ "${iface}" == utun* || "${iface}" == bridge* || "${iface}" == lo0 ]]; then
      continue
    fi
    ip="$(ipconfig getifaddr "${iface}" 2>/dev/null || true)"
    if [[ -n "${ip}" ]]; then
      printf '%s\n' "${ip}"
      return 0
    fi
  done
  return 1
}

if [[ -z "${HOST_IP}" ]]; then
  HOST_IP="$(detect_host_lan_ip || true)"
fi

if [[ -z "${HOST_IP}" ]]; then
  echo "failed to detect host LAN IP; set RNIDBG_QR_WEB_TLS_SERVER_NAME first" >&2
  exit 1
fi

mkdir -p "${TLS_DIR}"

if command -v mkcert >/dev/null 2>&1; then
  mkcert -cert-file "${TLS_DIR}/server.crt" -key-file "${TLS_DIR}/server.key" \
    "${HOST_IP}" localhost 127.0.0.1 ::1
  cp "$(mkcert -CAROOT)/rootCA.pem" "${TLS_DIR}/ca.crt"
  echo "[+] generated qr-web TLS certs with mkcert"
else
  if [[ ! -f "${TLS_DIR}/ca.key" || ! -f "${TLS_DIR}/ca.crt" ]]; then
    openssl genrsa -out "${TLS_DIR}/ca.key" 4096 >/dev/null 2>&1
    openssl req -x509 -new -nodes \
      -key "${TLS_DIR}/ca.key" \
      -sha256 -days 3650 \
      -out "${TLS_DIR}/ca.crt" \
      -subj "/CN=rnidbg-qr-web-local-ca" >/dev/null 2>&1
  fi

  cat > "${TLS_DIR}/server.ext" <<EOF
authorityKeyIdentifier=keyid,issuer
basicConstraints=CA:FALSE
keyUsage = digitalSignature, keyEncipherment
extendedKeyUsage = serverAuth
subjectAltName = @alt_names

[alt_names]
IP.1 = ${HOST_IP}
IP.2 = 127.0.0.1
DNS.1 = localhost
EOF

  openssl genrsa -out "${TLS_DIR}/server.key" 2048 >/dev/null 2>&1
  openssl req -new -key "${TLS_DIR}/server.key" \
    -out "${TLS_DIR}/server.csr" \
    -subj "/CN=${HOST_IP}" >/dev/null 2>&1
  openssl x509 -req \
    -in "${TLS_DIR}/server.csr" \
    -CA "${TLS_DIR}/ca.crt" \
    -CAkey "${TLS_DIR}/ca.key" \
    -CAcreateserial \
    -out "${TLS_DIR}/server.crt" \
    -days 825 \
    -sha256 \
    -extfile "${TLS_DIR}/server.ext" >/dev/null 2>&1
  echo "[+] generated qr-web TLS certs with openssl"
fi

echo "[+] tls dir: ${TLS_DIR}"
echo "[+] server name: ${HOST_IP}"
echo "[+] ca cert: ${TLS_DIR}/ca.crt"
echo "[+] server cert: ${TLS_DIR}/server.crt"
