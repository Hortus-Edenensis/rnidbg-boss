---
name: rnidbg-boss-lab
description: 处理 BossYzwg 实验室、trace、invoke、replay、HTTP bridge 的运行与调试。Use when the task mentions docker compose, bin/yzwg-invoke.sh, bin/run-trace.sh, bin/replay-samples.sh, bin/start-http-bridge.sh, bin/verify-http-bridge.sh, rnidbg boss-yzwg smoke|trace|invoke|replay, or rnidbg http-bridge.
---

# RNIDBG Boss Lab

## Overview

运行和调试 BossYzwg 容器实验室时，先走仓库自带 wrapper，再在需要细粒度 flags 时退回 raw CLI。
把这类任务视为“实验室底座和调试面”，不要把具体业务 API 读取混进来。

## Preflight

1. 先确认 `docker compose` 可用。
2. 先确认 `config/lab-config.container.json` 和 `RNIDBG_ASSETS_ROOT` 指向有效 assets。
3. 先优先用 `bin/*` wrapper；只有 wrapper 不覆盖所需 flags 时，才改用 `scripts/run-boss-yzwg.sh` 或 `rnidbg` raw CLI。

## Preferred Workflow

1. 启动实验室：`docker compose up -d rnidbg-lab`
2. 跑单次 JNI 调用：`./bin/yzwg-invoke.sh ...`
3. 抓 native trace：`./bin/run-trace.sh ...`
4. 校验 replay：`./bin/replay-samples.sh <limit>`
5. 起 HTTP bridge：`./bin/start-http-bridge.sh`
6. 验证 HTTP bridge：`./bin/verify-http-bridge.sh`

## Raw Fallback

- 需要精细控制 `invoke`、`trace`、`replay` 参数时，使用 `./scripts/run-boss-yzwg.sh <subcommand> ...`
- 需要直接控制 bridge 端口或 config 时，使用 `./scripts/run-http-bridge.sh --config <path> --port <port>`
- 需要只做最小可用性检查时，使用 `rnidbg boss-yzwg smoke --config <path>`

## References

- 读取 `references/lab-command-matrix.md` 以选择 wrapper 或 raw CLI。
- 读取 `references/http-bridge.md` 以确认 bridge 的默认端口、健康检查和 signer endpoints。
