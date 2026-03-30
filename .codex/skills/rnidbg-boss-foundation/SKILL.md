---
name: rnidbg-boss-foundation
description: 处理 rnidbg Boss/BOSS 共用前置条件、session、配置、transport 与设备指纹选择。Use when you need to choose or verify session.json, config/lab-config.container.json, RNIDBG_ASSETS_ROOT, backend, invoke-runtime, transport-runtime, http1-only, socks5 proxy, fingerprint-randomize, or the default bridge and QR web ports before running Boss workflows.
---

# RNIDBG Boss Foundation

## Overview

为当前仓库里的 Boss workflow 提供共用 preflight 和 runtime 决策。
先把 repo、config、assets、session、backend、invoke/transport 选对，再进入 lab、QR、jobs、chat 具体流程。

## Preflight

1. 在仓库根目录工作，优先复用现成 wrapper：`bin/*` 和 `scripts/run-*.sh`。
2. 优先使用 `config/lab-config.container.json`。只有明确要换 target 或 backend 时才改 `--config` 或 `--backend`。
3. 先确认 assets 挂载路径可用。走 Docker wrapper 时优先设置 `RNIDBG_ASSETS_ROOT`，不要把用户本机绝对路径写回仓库配置。
4. 先确认 session 可用。默认候选是当前目录 `.boss_purecalc/session.json` 和 `$HOME/.boss_purecalc/session.json`；`qr-web` helper 还会探测 `/workspace/lab-assets/...`。
5. 先决定 signer 和 transport：
   - `--invoke-runtime auto|local|bridge`
   - `--transport-runtime auto|direct|okhttp-bridge`
   - `--http1-only true`
   - `--socks5-proxy` 或 `--socks5-proxy-pool-file`
6. 只有在用户明确要换设备指纹或排查风控时，才运行 `fingerprint-randomize`。

## Common Decisions

- 需要本地 JNI/签名能力时，优先 `--invoke-runtime auto`。只有本地不可用或用户明确要走 bridge 时再切到 `bridge`。
- 需要稳定网络读取时，优先 `--transport-runtime auto` 或 `direct`。`okhttp-bridge` 只在用户明确要求原始 OkHttp 或 Boss APK 路径时使用。
- 需要容器内服务时，记住默认端口：
  - HTTP bridge host `28080` -> container `18080`
  - QR web host `28786` -> container `8786`
  - QR web HTTPS host `28443`

## Fast Actions

- 更新指纹：`rnidbg boss-yzwg fingerprint-randomize --session-path <session.json>`
- 起 HTTP bridge：`./bin/start-http-bridge.sh`
- 起 QR web：`./bin/start-qr-web.sh`

## References

- 读取 `references/prerequisites-and-paths.md` 以确认 repo、config、assets、session 和默认端口。
- 读取 `references/runtime-selection.md` 以选择 backend、invoke-runtime、transport-runtime、代理和 `http1-only`。
- 读取 `references/helper-script-map.md` 以在 wrapper 和 raw CLI 之间切换。
