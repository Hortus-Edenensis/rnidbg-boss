# GT3 子模块集成说明

## 目标

把 GT3 相关的两类能力从主仓库里拆出来：

1. Boss APK 真实调用链还原
2. Web 风格的图片解码 / 边缘检测 / 偏移估计 / 轨迹生成

这样主仓库负责业务入口，独立子模块负责算法与调用链模型。

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

### 2. 跑图片管线

```bash
cargo run --no-default-features --features unicorn -- boss-yzwg gt3-pipeline \
  --background-image /tmp/bg.png \
  --slider-image /tmp/slider.png
```

或者：

```bash
cargo run --no-default-features --features unicorn -- boss-yzwg gt3-pipeline \
  --background-url https://example.com/bg.png \
  --slider-url https://example.com/slider.png \
  --referer https://www.geetest.com/demo/slide-float.html
```

## 边界

这个子模块刻意把“调用链还原”和“本地图像分析”分开：

- APK 链路说明 Boss App 怎么把 `startCaptcha` 喂给 GT3 SDK
- 图片管线只做本地分析，不冒充 APK 内部 GT3 SDK 逻辑

这和 `docs/gt3-geetest-static-analysis.md`、`docs/gt3-web-vs-apk-comparison.md` 的结论一致。
