---
name: rnidbg-boss-jobs
description: 处理 Boss 职位搜索与详情读取。Use when the task mentions search, recommend, job-detail, private-info, securityId, 搜索岗位, 职位详情, 简历私有信息, or choosing stable direct versus okhttp-bridge fallback for Boss job APIs.
---

# RNIDBG Boss Jobs

## Overview

把职位侧任务拆成四类：关键词搜索、推荐岗位、按 `securityId` 拉详情、以及 `private-info` 私有信息探测。
默认优先稳定读取路径，再根据用户要求决定是否进入 `okhttp-bridge` 或 APK-backed transport。

## Preflight

1. 先确认 session、config 和 backend 都有效。
2. 优先使用 `--transport-runtime auto` 或 `direct`。
3. 只有用户明确要求原始 OkHttp、Boss APK transport，或 direct 路径失败时，才切到 `--transport-runtime okhttp-bridge`。

## Preferred Workflow

1. 搜索岗位：`rnidbg boss-yzwg search <keyword> ...`
2. 拉推荐流：`rnidbg boss-yzwg recommend ...`
3. 已知 `securityId` 时拉详情：`rnidbg boss-yzwg job-detail <securityId> ...`
4. 需要排查用户侧私有接口或对齐画像时，再运行 `rnidbg boss-yzwg private-info ...`

## Stability Rules

- 把 `job-detail` 视为稳定读取入口；它自带 token bucket 限速，不要自己再并发猛打。
- 把 `private-info` 视为带 fallback 的探测入口；只有在需要观察 direct、SO、OkHttp bridge 差异时才展开完整链路。
- 只在用户显式要求时使用 `--force-so true` 或 APK-backed transport。

## References

- 读取 `references/jobs-command-matrix.md` 以选择 search、recommend、job-detail、private-info 的入口和常用 flags。
- 读取 `references/fallbacks-and-rate-limits.md` 以确认 `job-detail` 限速和 `private-info` fallback 次序。
