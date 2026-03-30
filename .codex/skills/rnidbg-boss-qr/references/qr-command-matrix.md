# QR Command Matrix

## Preferred Commands

| Goal | Preferred Command | Notes |
| --- | --- | --- |
| 识别单张二维码 | `rnidbg boss-yzwg qr-decode <image-path>` | 输出识别出的 `qr_id` 和 payload 形态 |
| 真实授权登录 | `rnidbg boss-yzwg qr-authorize <image-path> [--second-image <path>|--second-qr <qrId>]` | 可追加 `--login-type`、`--sleep-before-login-ms`、位置和 Wi-Fi 参数 |
| 起 HTTP QR web | `./bin/start-qr-web.sh` | 适合常驻服务和局域网入口 |
| 起 HTTPS QR web | `./bin/start-qr-web-https.sh` | 适合手机浏览器摄像头扫码 |
| 起本地 mock producer | `rnidbg boss-yzwg qr-serve ...` | 适合本地流程复现 |
| 消费 producer 流程 | `rnidbg boss-yzwg qr-consume --producer-id <id> [--base-url <url>]` | 配合 `qr-serve` 使用 |

## Raw QR Web

需要细调时再直接运行：

```bash
rnidbg boss-yzwg qr-web \
  --bind-host <addr> \
  --port <port> \
  --public-origin <url> \
  --state-dir <path> \
  --session-path <path>
```

## Common QR Authorize Add-Ons

- 第二阶段二维码：`--second-image <path>` 或 `--second-qr <qrId>`
- 登录类型：`--login-type <1|2>`
- 延迟登录：`--sleep-before-login-ms <n>`
- 位置：`--loc-per true --latitude <v> --longitude <v>`
- Wi-Fi：`--ssid <name> --bssid <mac>`

## Verification Rule

1. decode 任务先核对 `qr_id`
2. web 任务先核对 `/health`
3. authorize 任务先保留 first/second QR 输入和输出 JSON
