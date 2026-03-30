# Helper Script Map

## Wrapper First

优先走 `bin/*` wrapper。它们会自动起容器、注入 `RNIDBG_LAB_CONFIG`、处理默认路径，并减少手写命令出错。

## Host Wrappers

| Wrapper | Underlying Flow | Use It For |
| --- | --- | --- |
| `bin/yzwg-invoke.sh` | `scripts/run-boss-yzwg.sh invoke` | 单次 JNI 调用、签名验证 |
| `bin/run-trace.sh` | `scripts/run-boss-yzwg.sh trace` | native trace |
| `bin/replay-samples.sh` | `scripts/run-boss-yzwg.sh replay --mode both` | replay 样本回放 |
| `bin/start-http-bridge.sh` | `scripts/run-http-bridge.sh` | 启动 HTTP bridge |
| `bin/verify-http-bridge.sh` | health + signer endpoint probe | 校验 bridge 是否可用 |
| `bin/start-qr-web.sh` | compose 启 `rnidbg-qr-web` | 启动 HTTP QR web |
| `bin/start-qr-web-https.sh` | compose 启 `rnidbg-qr-web` + TLS proxy | 启动 HTTPS QR web |

## Lower-Level Scripts

| Script | Underlying Flow | Use It For |
| --- | --- | --- |
| `scripts/run-boss-yzwg.sh` | 构建二进制后执行 `rnidbg boss-yzwg` | 需要 raw subcommand 和额外 flags |
| `scripts/run-http-bridge.sh` | 构建二进制后执行 `rnidbg http-bridge` | 需要自定义 bridge 端口或 config |
| `scripts/run-qr-web.sh` | 构建二进制后执行 `rnidbg boss-yzwg qr-web` | 需要自定义 bind host、state dir、session |
| `scripts/ensure-rnidbg-bin.sh` | 构建 dynarmic 或 unicorn 目标 | 排查 build/backend 问题 |
| `scripts/run-boss-apk-okhttp.sh` | Boss APK OkHttp CLI | 实验性 APK-backed OkHttp transport |
| `scripts/run-boss-apk-mqtt.sh` | Boss APK MQTT CLI | 实验性消息发送 transport |
| `scripts/run-boss-apk-chat-payload.sh` | Boss APK payload builder CLI | 实验性聊天 payload 构造 |

## Switching Rule

1. 先选 wrapper。
2. 需要额外 flags、不同 config、不同 backend、不同端口时，再切 lower-level script。
3. 只有在 lower-level script 也不够时，才直接写 raw `rnidbg ...` 命令。
