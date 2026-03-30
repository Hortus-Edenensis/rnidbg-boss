# Fallbacks And Rate Limits

## Job Detail Rate Limit

- `job-detail` 自带 token bucket
- 容量：`120`
- 每分钟补充：`120`
- 作用域：`job_detail_only`

把它视为内建节流器。用户要跑批量详情时，不要再额外提升并发。

## Private-Info Fallback Order

`private-info` 的读取顺序可以概括为：

1. direct + session-only
2. okhttp-bridge + session-only
3. direct + rnidbg-so
4. okhttp-bridge + rnidbg-so

其中：

- `--force-so true` 会跳过 session-only，直接走 SO 参与签名/解密的路径
- `--transport-runtime direct` 会禁用 okhttp-bridge
- `--transport-runtime okhttp-bridge` 且未提供 `--okhttp-bridge-url` 时，会转到 Boss APK-backed OkHttp runner

## Search / Recommend / Job-Detail Transport Choice

- `auto`：默认 direct；若提供 `--okhttp-bridge-url`，走 remote original bridge
- `direct`：最稳定，适合日常读取
- `okhttp-bridge`：
  - 有 URL：remote original bridge
  - 无 URL：Boss APK-backed runner

把“无 URL 的 `okhttp-bridge`”视为显式实验路径。

## Practical Guidance

1. 先用 `direct`
2. direct 失败且用户需要原始 OkHttp 行为时，再切 `okhttp-bridge`
3. 只有要对齐签名或解密细节时，才启用 `--force-so true`
