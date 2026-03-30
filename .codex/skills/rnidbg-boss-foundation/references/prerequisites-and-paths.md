# Prerequisites And Paths

## Repo And Container Roots

- 在宿主机优先从仓库根目录执行命令。
- Compose 默认把仓库挂到 `/workspace/rnidbg`。
- Compose 默认把资产仓库挂到 `/workspace/lab-assets`。
- 如需覆盖容器内仓库路径，设置 `RNIDBG_CONTAINER_REPO_ROOT`。

## Tracked Config

- 默认 tracked config 是 `config/lab-config.container.json`。
- 该配置默认指向：
  - APK：`/workspace/lab-assets/artifacts/bosszhipin-reverse-project/input/base.apk`
  - SO：`/workspace/lab-assets/artifacts/bosszhipin-reverse-project/native/lib/arm64-v8a/libyzwg.so`
  - sign_encrypt：`/workspace/lab-assets/artifacts/bosszhipin-reverse-project/assets/assets/sign_encrypt`
  - purecalc lookup：`/workspace/lab-assets/artifacts/bosszhipin-reverse-project/decrypt/purecalc_lookup.json`
  - trace output：`/workspace/lab-assets/artifacts/bosszhipin-reverse-project/rnidbg-trace`
- 只有在目标切换或资产布局变化时，才改 `--config` 或 `RNIDBG_LAB_CONFIG`。

## Assets Root

- Docker wrapper 默认使用 `../drizzle-dumper-rust` 作为 `RNIDBG_ASSETS_ROOT`。
- 如资产仓库不在这个相对路径，先导出：

```bash
export RNIDBG_ASSETS_ROOT=/absolute/path/to/drizzle-dumper-rust
```

## Session Candidates

- `load_session()` 的默认候选：
  - 当前目录 `.boss_purecalc/session.json`
  - `$HOME/.boss_purecalc/session.json`
- `scripts/run-qr-web.sh` 还会探测：
  - `/workspace/lab-assets/.boss_purecalc/session.json`
  - `/workspace/lab-assets/boss_purecalc/.boss_purecalc/session.json`
  - `/workspace/lab-assets/.boss_session/session.json`
- session 至少要有有效 `token2`；否则会被视为不可用。

## Default Ports

- HTTP bridge host：`28080`
- HTTP bridge container：`18080`
- QR web host：`28786`
- QR web container：`8786`
- QR web HTTPS host：`28443`

## First Checks

1. 确认 `docker compose` 可用。
2. 确认 `RNIDBG_ASSETS_ROOT` 指向存在的资产仓库。
3. 确认 session 文件存在且含有效 `token2`。
4. 确认 `config/lab-config.container.json` 指向的 APK/SO/asset 路径都存在。
