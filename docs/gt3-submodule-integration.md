# GT3 子模块集成说明

## 目标

把 GT3 能力聚焦为 Boss APK App 端真实链路取证，主仓库负责业务入口，子模块负责调用链模型与交换实现。

## 子模块位置

- `modules/gt3-geetest`

它是一个独立 git repo，对外暴露的核心模块有：

- `call_chain.rs`
- `image_solver.rs`
- `trajectory.rs`
- `pipeline.rs`

## 当前命令入口

### 1. 查看 Boss APK GT3 调用链

```bash
cargo run --no-default-features --features unicorn -- boss-yzwg gt3-call-chain
```

输出会明确区分：

- `MachineVerifyActivity -> c4 -> p50.d -> GT3GeetestUtils`
- `onDialogResult -> captcha_info`
- `captcha/validate`
- `libyzwg.so` 只负责 signer，不负责 GT3 challenge 引擎

### 2. 真实探针（替代已移除的 Web 分支）

`gt3-pipeline|gt3-image-solve` 已从主命令入口移除。当前统一使用 App 端真实探针：

```bash
cargo run --no-default-features --features unicorn -- boss-yzwg captcha-trace \
  --phone 7593791087 \
  --region-code +44 \
  --skip-validate true
```

## 边界

当前边界：

- APK 链路说明 Boss App 怎么把 `startCaptcha` 喂给 GT3 SDK
- 已移除 Geetest Web 分支命令入口，避免偏离 App native 方案

这和 `docs/gt3-geetest-static-analysis.md`、`docs/gt3-web-vs-apk-comparison.md` 的结论一致。
