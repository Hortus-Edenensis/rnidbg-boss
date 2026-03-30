# Chat Send Experimental

## Boundary

把以下命令视为实验性发送链路，只有用户明确要求时才进入：

- `chat-payload`
- `proactive-send`
- `send-text`

没有明确授权时，不要主动触发发送。

## Commands

| Command | Use It For | Notes |
| --- | --- | --- |
| `chat-payload <friendId> <text>` | 构造或检查聊天 payload | 支持 `--payload-builder-mode serializer|patched|manual` |
| `proactive-send <friendId>` | 走 HTTP 侧主动发起路径 | 需要 `--security-id` 等上下文 |
| `send-text <friendId> <text>` | 真实发送文本 | 默认 `--send-runtime mqtt` |

## MQTT / APK Preconditions

- `send-text` 的默认 `--send-runtime` 是 `mqtt`
- `BossApkMqttDispatch` 依赖：
  - `scripts/run-boss-apk-mqtt.sh`
  - `scripts/run-boss-apk-chat-payload.sh`
  - config 里可用的 Boss APK 路径
- 如果用户没有明确要求真实发送，优先把 `--send-runtime` 留在 `dump` 或只做 `chat-payload`

## Payload Builder Modes

- `serializer`：默认路径，优先使用
- `patched`：需要修补序列化契约时再用
- `manual`：只有在显式调试协议细节时才用

## Safe Practice

1. 先用 `friends` 和 `chat-bootstrap` 拿全上下文
2. 先用 `chat-payload` 检查 payload
3. 只有用户明确确认“要发”，再进入 `send-text`
4. 能用 `dump` 或 `mock` 就不要直接用 `mqtt`
