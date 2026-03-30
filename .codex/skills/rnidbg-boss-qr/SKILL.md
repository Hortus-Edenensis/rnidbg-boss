---
name: rnidbg-boss-qr
description: 处理 Boss 二维码识别、双阶段授权和常驻 QR Web 服务。Use when the task mentions qr-decode, qr-authorize, qr-web, qr-serve, qr-consume, bin/start-qr-web.sh, bin/start-qr-web-https.sh, Boss QR login, 二维码登录, or LAN and HTTPS QR web access.
---

# RNIDBG Boss QR

## Overview

把 Boss QR 相关任务分成四类：单张二维码识别、真实登录授权、常驻 QR Web 服务、以及本地 mock producer/consumer 调试。
优先使用仓库 wrapper 启动长生命周期服务；只在需要自定义端口、state-dir 或 session 时退回 raw CLI。

## Preflight

1. 先确认 session 可用，再跑 `qr-authorize` 或 `qr-web`。
2. 先确认图片输入路径有效，再跑 `qr-decode` 或 `qr-authorize`。
3. 起常驻服务时，优先使用 `./bin/start-qr-web.sh` 或 `./bin/start-qr-web-https.sh`。

## Workflow Decision Tree

- 只需要识别二维码文本：运行 `rnidbg boss-yzwg qr-decode <image-path>`
- 需要执行真实扫码授权：运行 `rnidbg boss-yzwg qr-authorize <image-path> [--second-image <path>|--second-qr <qrId>]`
- 需要持续暴露一个扫码入口给手机：运行 `./bin/start-qr-web.sh`，如需手机摄像头 HTTPS 再运行 `./bin/start-qr-web-https.sh`
- 需要本地 mock 流程或复现 producer/consumer：使用 `qr-serve` 和 `qr-consume`

## Verification

- 起 QR Web 后，总是检查 `/health` 和 `/api/state/latest`
- 起 HTTPS 后，总是确认设备已经信任 helper 生成的 CA
- 做真实授权时，如用户提供位置或 Wi-Fi 线索，再附加 `--latitude`、`--longitude`、`--ssid`、`--bssid`

## References

- 读取 `references/qr-command-matrix.md` 以选择 decode、authorize、web、serve、consume 入口。
- 读取 `references/qr-web-state-and-ports.md` 以确认 state-dir、默认端口、LAN origin 和 HTTPS 证书行为。
