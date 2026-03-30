---
name: rnidbg-boss-chat
description: 处理 Boss 联系人和消息侧工作流。Use when the task mentions friends, messages, messages-all, chat-bootstrap, exchange, interaction, hot-job-rec, 联系人, 消息拉取, 聊天初始化, or explicitly asks for experimental chat-payload, proactive-send, or send-text flows.
---

# RNIDBG Boss Chat

## Overview

默认先覆盖稳定读流程：联系人列表、单聊消息、全量消息、聊天 bootstrap、交换列表、互动信息和热职位推荐。
把发送链路视为实验性能力，只有用户明确要求时才进入 `chat-payload`、`proactive-send` 或 `send-text`。

## Preflight

1. 先确认 session、config、transport 和 friendId 输入有效。
2. 需要读取联系人时，先跑 `friends`。
3. 需要读取单聊消息时，优先按 `friends` -> `chat-bootstrap` -> `messages` 的顺序组织流程。
4. 非明确请求时，不要主动走 MQTT 或 Boss APK 发送链路。

## Stable Read Flows

- 联系人列表：`rnidbg boss-yzwg friends ...`
- 单聊消息：`rnidbg boss-yzwg messages <friendId> ...`
- 批量消息：`rnidbg boss-yzwg messages-all ...`
- 聊天初始化：`rnidbg boss-yzwg chat-bootstrap <friendId> ...`
- 交换列表：`rnidbg boss-yzwg exchange ...`
- 互动信息：`rnidbg boss-yzwg interaction ...`
- 热职位推荐：`rnidbg boss-yzwg hot-job-rec ...`

## Experimental Send Flows

- `chat-payload`：只在需要构造 payload 或验证 serializer/patch/manual builder 时使用
- `proactive-send`：只在需要 HTTP 侧主动发起行为时使用
- `send-text`：只在用户明确要求真实发送链路时使用；默认 `--send-runtime mqtt`

把这些发送链路视为显式授权能力。没有用户确认时，不要主动发送消息。

## References

- 读取 `references/chat-read-flows.md` 以选择稳定读流程和常用参数。
- 读取 `references/chat-send-experimental.md` 以确认发送链路的 MQTT/APK 前置条件和风险边界。
