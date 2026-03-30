# Runtime Selection

## Backend

- `--backend dynarmic`：默认稳定选择；`config/lab-config.container.json` 里也默认是 `dynarmic`
- `--backend unicorn`：需要用 Unicorn 路径时显式指定
- wrapper 不传 `--backend` 时，会先读 config，再由 `scripts/ensure-rnidbg-bin.sh` 按 backend 构建对应二进制

## Invoke Runtime

- `--invoke-runtime local`：直接在本地 `rnidbg` 进程里做 signer/so 调用
- `--invoke-runtime bridge`：通过 HTTP bridge 调用 signer
- `--invoke-runtime auto`：优先 local；本地不可用时再尝试 bridge
- `--bridge-url` 默认是 `http://127.0.0.1:28080`

## Transport Runtime

- `--transport-runtime direct`：直接用 `reqwest` 发请求；稳定读取优先选它
- `--transport-runtime auto`：对 `job-detail`、`search`、`recommend`、`contact` 这类路径，默认仍优先 direct；只有显式配置 `--okhttp-bridge-url` 或 `RNIDBG_OKHTTP_BRIDGE_URL` 时才走 remote bridge
- `--transport-runtime okhttp-bridge`：
  - 如果提供 `--okhttp-bridge-url`，连接 remote original OkHttp bridge
  - 如果不提供 URL，`job-detail`、`private-info`、`contact` 会退到 Boss APK-backed OkHttp runner

把“无 URL 的 `okhttp-bridge`”视为实验性路径，只在用户明确要求原始 OkHttp 或 Boss APK transport 时使用。

## HTTP And Proxy Flags

- `--http1-only true`：只对 direct `reqwest` client 生效；只在网络兼容性问题出现时开启
- `--socks5-proxy <host:port:user:pass>`：显式指定单个代理
- `--socks5-proxy-pool-file <path>`：从代理池文件里选代理

## Fingerprint

- `rnidbg boss-yzwg fingerprint-randomize` 会直接改 session 里的设备指纹字段
- 默认参数：
  - brand：`realme`
  - model：`RMX3560`
  - network：`wifi`
  - operator：`CHN-CT`
- 只有在用户明确要求换设备画像、模拟风控差异或排查设备契约时才运行

## Safe Defaults

1. 读取类任务优先 `--invoke-runtime auto --transport-runtime auto`
2. 需要稳定排障时切 `--transport-runtime direct`
3. 需要 remote signer 时先起 `./bin/start-http-bridge.sh`
4. 需要原始 OkHttp 或 Boss APK transport 时，再显式切 `--transport-runtime okhttp-bridge`
