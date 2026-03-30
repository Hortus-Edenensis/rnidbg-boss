# QR Web State And Ports

## Default Ports

- HTTP host port：`28786`
- HTTP container port：`8786`
- HTTPS host port：`28443`

## Default Endpoints

- `/`
- `/health`
- `/api/state/latest`

## State Directory

- 容器路径默认是 `/workspace/lab-data/qr-web`
- `scripts/run-qr-web.sh` 在非 `/workspace/*` 环境下，会退到 `<repo>/.local/qr-web-state`
- 需要覆盖时用 `RNIDBG_QR_WEB_STATE_DIR` 或 raw `--state-dir`

## Session Selection

- `scripts/run-qr-web.sh` 会优先探测 assets 挂载下的多个 session 候选
- 如果探测到 session 但 `interaction` 健康探针失败，helper 可能直接丢弃该 session 文件
- 需要强制指定时设置 `RNIDBG_QR_WEB_SESSION_PATH`

## Public Origin And LAN

- `bin/start-qr-web.sh` 会尽量探测宿主机 LAN IP，并设置 `RNIDBG_QR_WEB_PUBLIC_ORIGIN`
- 需要强制展示外网或代理地址时，显式设置 `RNIDBG_QR_WEB_PUBLIC_ORIGIN`

## HTTPS Helper

- `bin/start-qr-web-https.sh` 会：
  - 探测 LAN IP 并把它写入 `RNIDBG_QR_WEB_TLS_SERVER_NAME`
  - 运行 `scripts/ensure-qr-web-tls.sh`
  - 启动 `rnidbg-qr-web` 和 `rnidbg-qr-web-https`
- 默认 TLS 目录：`.local/qr-web-tls`
- 手机浏览器使用摄像头前，需要信任生成的 `ca.crt`

## Useful Environment Variables

- `RNIDBG_QR_WEB_HOST_PORT`
- `RNIDBG_QR_WEB_PORT`
- `RNIDBG_QR_WEB_BIND_HOST`
- `RNIDBG_QR_WEB_PUBLIC_ORIGIN`
- `RNIDBG_QR_WEB_STATE_DIR`
- `RNIDBG_QR_WEB_SESSION_PATH`
- `RNIDBG_QR_WEB_TLS_HOST_PORT`
- `RNIDBG_QR_WEB_TLS_SERVER_NAME`
- `RNIDBG_QR_WEB_TLS_DIR`
