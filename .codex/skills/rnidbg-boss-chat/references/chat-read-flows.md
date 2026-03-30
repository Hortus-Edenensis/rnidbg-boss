# Chat Read Flows

## Stable Commands

| Goal | Preferred Command | Notes |
| --- | --- | --- |
| 列联系人 | `rnidbg boss-yzwg friends [--limit <n>]` | 先拿 `friendId`、基础信息 |
| 拉单聊消息 | `rnidbg boss-yzwg messages <friendId> [--count <n>]` | 可加 `--last-msg-id` 或 `--max-msg-id` |
| 扫全量消息 | `rnidbg boss-yzwg messages-all [--limit <n>] [--count <n>]` | 适合批量巡检 |
| 拉聊天 bootstrap | `rnidbg boss-yzwg chat-bootstrap <friendId> ...` | 适合补齐 `securityId`、window config |
| 拉交换列表 | `rnidbg boss-yzwg exchange [--page <n>]` | 联系人侧辅助信息 |
| 拉互动信息 | `rnidbg boss-yzwg interaction` | 联系人侧辅助信息 |
| 拉热职位推荐 | `rnidbg boss-yzwg hot-job-rec [--page <n>] [--tag <n>]` | 联系人侧辅助信息 |

## Recommended Sequence

1. 先用 `friends` 确认 `friendId`
2. 需要单聊上下文时，先用 `chat-bootstrap`
3. 再用 `messages <friendId>`
4. 需要批量巡检时，再用 `messages-all`

## Host Flags

- `friends` / `exchange` 更偏 `--contact-host`
- `messages` / `chat-bootstrap` / `interaction` / `hot-job-rec` 更偏 `--api-host`
- 多数情况下直接用共享的 `--host` 即可

## Shared Safe Defaults

```bash
--invoke-runtime auto --transport-runtime auto
```

如果只做稳定读取，优先：

```bash
--invoke-runtime auto --transport-runtime direct
```
