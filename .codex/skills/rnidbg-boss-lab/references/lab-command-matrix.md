# Lab Command Matrix

## Wrapper-First Commands

| Goal | Preferred Command | Raw Fallback | Notes |
| --- | --- | --- | --- |
| 启动实验室容器 | `docker compose up -d rnidbg-lab` | same | wrapper 们通常会自动执行这一步 |
| 跑单次调用 | `./bin/yzwg-invoke.sh --method <name> --arg1 <value> [--arg2 <value>]` | `./scripts/run-boss-yzwg.sh invoke ...` | 不传参数时默认调用 `nativeSignature` 健康探针 |
| 抓 trace | `./bin/run-trace.sh --method-filter <method|all>` | `./scripts/run-boss-yzwg.sh trace ...` | trace 输出走 config 里的 `trace_out_dir` |
| 回放样本 | `./bin/replay-samples.sh <limit>` | `./scripts/run-boss-yzwg.sh replay --mode both --limit <n>` | wrapper 默认 `--mode both` |
| 最小可用性检查 | none | `./scripts/run-boss-yzwg.sh smoke --config <path>` | raw CLI 更直接 |
| 启动 bridge | `./bin/start-http-bridge.sh` | `./scripts/run-http-bridge.sh --config <path> --port <port>` | host 默认端口 `28080` |

## Raw CLI Shapes

```bash
rnidbg boss-yzwg smoke --config <path> [--backend <auto|dynarmic|unicorn>]
rnidbg boss-yzwg trace --config <path> [--backend <...>] [--method-filter <method|all>] [--lookup <path>]
rnidbg boss-yzwg invoke --config <path> [--backend <...>] --method <name> --arg1 <utf8|hex:...> [--arg2 <key>] [--dump-rc4 true]
rnidbg boss-yzwg replay --config <path> [--backend <...>] [--lookup <path>] [--limit <N>] [--mode <sp|sig|both>]
rnidbg http-bridge --config <path> [--port <port>]
```

## Rule Of Thumb

- 优先 wrapper，因为它会自动把 `RNIDBG_LAB_CONFIG`、`RNIDBG_CONTAINER_REPO_ROOT` 和 compose 容器对齐。
- 需要新增 flags 或非默认 backend 时，再切到 `scripts/run-boss-yzwg.sh`。
- 只有需要直接验证 `rnidbg` CLI 表面时，才直接用 raw `rnidbg ...`。
