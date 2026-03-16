# GT3 Web 文章链路 vs Boss APK GT3 链路对比

## Summary

这份对比基于两类证据：

- Chrome DevTools MCP 对文章 [JS逆向---极验三代系列详解-最全流程（三）分析JS， w值参数生成最终值](https://blog.csdn.net/m0_52336378/article/details/135157506) 的页面抽取结果
- 本地 APK/JADX 静态证据，详见 `docs/gt3-geetest-static-analysis.md`

先说结论：

1. 文章分析的是浏览器版 GT3 官方 demo `https://www.geetest.com/demo/slide-float.html` 的前端 JS 协议流。
2. Boss APK 里的 GT3 是 App 侧 SDK 接入流，App 自己不在业务层手写 `w`，而是把服务端给的 `startCaptcha` 交给 `GT3GeetestUtils`。
3. 两边都属于 GT3，但协议分工不同，不能把文章里的 `w` 生成思路直接搬进 Boss APK 当作“本地实现”。
4. 本地可以实现的是“流程对比器”和“trace/hook 对照模板”，而不是验证码绕过逻辑。

## Chrome DevTools 抓到的文章侧信息

通过 Chrome DevTools MCP 直接读取文章正文，可以确认它的目标和阶段划分：

- 目标页面：`https://www.geetest.com/demo/slide-float.html`
- 文章显式关注的可疑参数：`gt`、`challenge`、`w`、`callback`
- 文章给出的主要接口序列：
  - `register-slide`
  - `gettype.php`
  - `get.php`
  - `ajax.php`
  - `refresh.php`
  - 再次 `ajax.php`
- 文章把 `w` 相关本地字段拆成：
  - `userresponse`
  - `passtime`
  - `imgload`
  - `aa`
  - `ep-tm`
  - `mocq`
  - `rp`

也就是说，文章关注的是“浏览器端 JS 如何在页面环境里拼出 GT3 Web 协议所需的本地证明字段”。

## APK 侧实际链路

Boss APK 的 GT3 主链已经在本地静态证据里确认：

- `MachineVerifyActivity.onCreate()` 启动统一验证码门面
- `c4.f()` 先请求 `GET /zpsecureflow/captcha/gettype`
- `c4.e()` 根据 `GetCaptchaTypeResponse.captchaType` 选择 provider
- `p50.b.a(int)` 中 `1 -> new d()`，也就是 GT3 provider
- `p50.d.show()` 初始化 `GT3GeetestUtils`
- `p50.d$a.onButtonClick()` 把 `startCaptcha` 作为 `GT3ConfigBean.setApi1Json(...)` 的输入
- `p50.d$a.onDialogResult()` 从 SDK 回调里取出
  - `geetest_challenge`
  - `geetest_validate`
  - `geetest_seccode`
- 然后组装成 `captcha_info`
- `MachineVerifyActivity.Re()` 再请求 `POST /zpsecureflow/captcha/validate`

关键差异是：App 业务层看到的是 `startCaptcha` 和最终回调结果，中间 GT3 challenge 流程被 SDK 吸收掉了。

## 一张对比表

| 对比维度 | 文章里的 Web GT3 | Boss APK GT3 | 结论 |
| --- | --- | --- | --- |
| 运行环境 | 浏览器页面 + 前端 JS | Android App + GT3 SDK | 运行时完全不同 |
| 初始入口 | 官方 demo 页面自行拉起 GT3 Web 流程 | 业务页先调用 `/zpsecureflow/captcha/gettype` | APK 多了一层业务服务端门面 |
| provider 选择 | 默认就是 GT3 demo | `captchaType` 统一分流，`1 -> GT3`、`4 -> 网易` | APK 是多 provider 门面 |
| 本地计算重点 | `w`、轨迹、时序、页面环境字段 | 业务层只负责把 `startCaptcha` 喂给 SDK | `w` 不是 APK 业务层直算 |
| 图片处理 | 文章讨论乱序背景图还原 | 业务层没有看到这层逻辑 | 这部分被 GT3 SDK/WebView 内部封装 |
| 成功输出 | Web 协议中的 `validate` 等结果 | `captcha_info = {type, challenge, validate, secCode}` | 输出格式不同，但都围绕 GT3 回调结果 |
| App native 角色 | 文章关注浏览器 JS，不涉及 App signer | `libyzwg.so` 负责 App 请求签名/编解码 | `libyzwg.so` 不是 GT3 `w` 引擎 |

## 为什么不能直接照文章“本地实现”

### 1. 文章实现目标是 Web JS 协议，不是 APK SDK 接入

文章的主目标是解释 GT3 Web demo 里 `w` 的生成和页面本地参数拼接。  
Boss APK 的业务层则只需要：

1. 向自己的业务服务端拿 `startCaptcha`
2. 把 `startCaptcha` 交给 `GT3GeetestUtils`
3. 收 SDK 回调
4. 把结果提交给 `/zpsecureflow/captcha/validate`

所以两边真正“可本地实现”的对象不一样。

### 2. APK 里没有业务层手写 `w` 的直接证据

从现有 dex 和 `libyzwg.so` 证据看：

- GT3 SDK 直接打包在 APK 里
- GT3 视图资源也在 APK 内
- `libyzwg.so` 暴露的是通用 `encode/sign/decode`
- 没有看到 `geetest/gt3/captcha` 相关的 native 导出或直观字符串

因此更合理的判断是：

- Web demo 的 `w` 逻辑属于浏览器 JS 协议栈
- Boss APK 的 GT3 业务接入把这部分细节交给 SDK 处理

### 3. 直接复刻 `w` 生成会越过这次分析的安全边界

这会从“链路对比和取证”滑向“验证码绕过实现”。  
本地适合做的是对比、建模、trace，不适合做 token 伪造或滑块求解。

## 本地可实现的安全对比

这次在仓库里补了一个本地脚本：

```bash
python3 scripts/compare_gt3_flows.py --format markdown
```

它做的事情是：

- 固定文章侧 Web GT3 的阶段模型
- 固定 APK 侧 GT3 的阶段模型
- 输出并排对比表
- 明确哪些阶段属于浏览器 JS，哪些阶段属于 App 业务门面，哪些阶段由 GT3 SDK 托管

它不会做下面这些事：

- 生成 `w`
- 还原滑块图片
- 构造可用的验证码绕过 payload

## 建议的后续验证点

如果下一步要继续做“真实链路对比”，建议优先做动态观察，而不是实现文章里的 `w`：

- App 主链：
  - `com.hpbr.bosszhipin.utils.c4.e(...)`
  - `p50.b.a(int)`
  - `p50.d.show()`
  - `p50.d$a.onButtonClick()`
  - `p50.d$a.onDialogResult(String)`
  - `MachineVerifyActivity.Re(String)`
- signer 链：
  - `com.twl.signer.a.d/e/i`
  - `com.twl.signer.YZWG.nativeEncodeRequest`
  - `com.twl.signer.YZWG.nativeEncodeRequestBody`
  - `com.twl.signer.YZWG.nativeSignature`

这样能直接回答更关键的问题：

- `startCaptcha` 到底长什么样
- GT3 SDK 返回的 challenge/validate/seccode 在 App 里如何落地
- 验证码相关接口是否只是复用通用 signer
