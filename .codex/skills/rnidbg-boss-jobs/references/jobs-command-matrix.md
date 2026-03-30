# Jobs Command Matrix

## Preferred Commands

| Goal | Preferred Command | Notes |
| --- | --- | --- |
| 搜索关键词岗位 | `rnidbg boss-yzwg search <keyword> [--city <code>] [--page <n>] [--page-size <n>]` | 稳定读入口 |
| 拉推荐岗位 | `rnidbg boss-yzwg recommend [--city <code>] [--page <n>] [--page-size <n>] [--sort-type <n>]` | 稳定读入口 |
| 按 `securityId` 拉职位详情 | `rnidbg boss-yzwg job-detail <securityId> ...` | 默认最值得优先信任的 detail 入口 |
| 拉私有画像信息 | `rnidbg boss-yzwg private-info ...` | 带 fallback 的探测入口 |

## Shared Flags

这些命令普遍支持：

- `--session-path <path>`
- `--config <path>`
- `--backend <auto|dynarmic|unicorn>`
- `--invoke-runtime <auto|local|bridge>`
- `--transport-runtime <auto|direct|okhttp-bridge>`
- `--okhttp-bridge-url <url>`
- `--http1-only true`
- `--out <path>`

## Entry Selection

1. 用户还没有 `securityId` 时，先用 `search` 或 `recommend`
2. 用户已经给出 `securityId` 时，优先 `job-detail`
3. 用户要验证用户侧画像或排查请求契约差异时，再用 `private-info`

## Suggested Safe Defaults

```bash
--invoke-runtime auto --transport-runtime auto
```

如果要更稳定地读接口，改成：

```bash
--invoke-runtime auto --transport-runtime direct
```
