# 浙江 Android 逆向 / 爬虫岗位细颗粒度报告

- 生成时间：2026-03-16
- 生成方式：`rnidbg` 当前 session + 单路 `api-and` 请求 + 历史 shortlist `job-detail` 实拉
- 当前 session：
  - 使用路径：`/Users/haojiejack/.codex/worktrees/5401/rnidbg/.boss_purecalc/session.json`
  - 已刷新并同步到 `rnidbg`
  - 当前设备画像：
    - `brand=OPPO`
    - `model=OPPO||PGEM10`
    - `network=5G`
    - `operator=CHN-UNICOM`

## 这次怎么跑的

这轮我没有再走之前那种“双轨 fallback”。

- 默认无效链已切断：
  - contact / interaction / chat 只走 `direct_host_unsigned_app_id`
  - search 默认只走 `https://api-and.zhipin.com`
  - private-info 默认只走 `https://api-and.zhipin.com`
- 实测确认：
  - `interaction` 现在 `attempt_count = 1`
  - 路由只剩 `direct_host_unsigned_app_id`
  - 已不再先打一枪 `api5.zhipin.com` 再吃 `code=6`

对应校验结果：

- [rnidbg_interaction_single_route.json](/tmp/rnidbg_interaction_single_route.json)

## 先说结论

浙江这条线要分成两层看：

- `search` 对精确词命中很差，直接搜 `Android逆向 / 爬虫工程师 / 反爬` 现在基本都是空结果。
- 但 `job-detail` 链是通的，而且能稳定把历史 shortlist 对应岗位的当前 JD 拉回来。

所以这次最可靠的打法不是“用 `search` 找一切”，而是：

1. 用历史浙江逆向/爬虫样本锁定热点城市和代表岗位
2. 用当前 `rnidbg` 的单路 `job-detail` 去验证这些岗位是不是还活着

## 当前 `rnidbg search` 的真实情况

我用新 session 和单路 `api-and` 精确搜了这几条：

- 杭州 `Android逆向`
- 杭州 `爬虫工程师`
- 杭州 `反爬`
- 金华 `Android逆向`
- 宁波 `爬虫工程师`

结果全部是：

- `status = ok`
- `job_count = 0`

记录在：

- [rnidbg_reverse_crawler_focus_scan.json](/tmp/rnidbg_reverse_crawler_focus_scan.json)

这说明当前搜索链的问题不是 session 失效，而是：

- 精确关键词在当前搜索口径下命中太差
- 不能把 `search=0` 误判成“浙江没有这类岗位”

## 历史盘面仍然有价值

原项目里已经有一份非常强的浙江三城逆向/爬虫报告：

- [zhejiang_hz_jh_nb_deep_report.md](/Users/haojiejack/github/drizzle-dumper-rust/boss_purecalc/analysis/2026-03-12-zhejiang-crawler-reverse-live/report_final/zhejiang_hz_jh_nb_deep_report.md)

核心盘面：

- 杭州：`522` 条
  - crawler：`326`
  - reverse：`147`
  - mixed：`49`
- 金华：`112` 条
  - crawler：`100`
  - reverse：`11`
- 宁波：`61` 条
  - crawler：`57`
  - reverse：`4`

一句话解读：

- 杭州是唯一同时具备“逆向岗位规模 + 高薪上限”的主战场。
- 金华和宁波更适合补 crawler 面试量。

## 当前 `rnidbg job-detail` 验证结果

我从历史样本里抽了 6 条最有代表性的浙江岗位，用当前 `rnidbg` 顺序实拉 `job-detail`。结果都成功。

汇总在：

- [rnidbg_reverse_crawler_jobdetail_focus.json](/tmp/rnidbg_reverse_crawler_jobdetail_focus.json)

### 1. 杭州，高级逆向工程师，深圳市忠帅贸易

- 薪资：`95-120K·15薪`
- 地点：`杭州·余杭区·仓前`
- 学历：`本科`
- 经验：`经验不限`
- 状态：当前仍可拉回详情

JD 关键信号：

- 二进制逆向
- 漏洞挖掘和利用
- Windows 逆向
- Shellcode
- 代码混淆还原

这条明显是高薪极少数样本，偏项目制、高门槛，不是大众投递池。

### 2. 温州，安卓逆向网络安全工程师，瑞安市优棉贸易

- 薪资：`15-20K`
- 地点：`温州·瑞安市·安阳`
- 学历：`学历不限`
- 经验：`1-3年`
- 状态：当前仍可拉回详情

JD 关键信号：

- Android 逆向
- 抓包
- 反编译
- Xposed
- Frida

这是当前验证里最像“真正 Android 逆向岗”的浙江样本，温州这条线值得继续看。

### 3. 杭州，网络爬虫技术专家-垂类大模型--杭州，阿里云

- 薪资：`45-75K·15薪`
- 地点：`杭州·西湖区`
- 学历：`硕士`
- 经验：`3-5年`
- 状态：当前仍可拉回详情

JD 关键信号：

- 全网高价值数据源发现
- 多模态采集
- 分布式架构
- Java / Python / Go
- 代理、浏览器引擎、移动端技术

这是杭州 crawler 赛道里的高薪专家岗，更偏平台级采集基础设施。

### 4. 杭州，反爬虫工程师，阿里巴巴集团

- 薪资：`25-50K·13薪`
- 地点：`杭州·余杭区·仓前`
- 学历：`本科`
- 经验：`1-3年`
- 状态：当前仍可拉回详情

JD 关键信号：

- 数据泄漏风险感知
- 流量日志分析
- Python / SQL
- 爬虫攻防
- Web 攻防
- 代码审计

这条不是单纯“写爬虫”，而是明显偏平台安全/反爬/风险治理。

### 5. 杭州，爬虫工程师，快手(杭州)

- 薪资：`25-40K·16薪`
- 地点：`杭州·余杭区·仓前`
- 学历：`学历不限`
- 经验：`经验不限`
- 状态：当前仍可拉回详情

JD 关键信号：

- JS 逆向
- Web 常用反爬技术
- App 逆向
- 抓包 / hook
- Android NDK
- x86 / ARM 汇编
- IDA / GDB

这条很关键，因为它本质上是 `crawler + app逆向 + 反爬` 的混合岗，和你的目标能力重合度很高。

### 6. 宁波，python爬虫工程师，宁波真和物流科技

- 薪资：`25-35K`
- 地点：`宁波·鄞州区·福明`
- 学历：`大专`
- 经验：`3-5年`
- 状态：当前仍可拉回详情

JD 关键信号：

- DrissionPage / Scrapy / Selenium
- 代理池
- 请求头伪装
- 验证码破解
- APP 逆向
- Android 通信协议抓包
- Linux / Docker

这条很像“工程化爬虫主力岗”，而且把 `APP逆向` 明确写进了岗位要求。

## 现在最值得盯的岗位类型

### A 类：杭州高薪逆向 / 反爬 / 混合岗

代表：

- 高级逆向工程师
- 反爬虫工程师
- 爬虫工程师（快手这类混合岗）

特点：

- 薪资上限最高
- 对 `Android / Frida / Hook / 抓包 / 协议 / JS逆向 / Web攻防` 要求明显
- 真正有技术门槛

### B 类：杭州高阶 crawler 专家岗

代表：

- 阿里云网络爬虫技术专家

特点：

- 更偏平台能力、分布式采集、数据系统
- 不是简单业务爬虫
- 更适合有架构和大规模采集背景的人

### C 类：温州 / 宁波 的中高性价比岗位

代表：

- 温州安卓逆向网络安全工程师
- 宁波 python爬虫工程师

特点：

- 薪资没杭州顶级样本高
- 但岗位要求写得更直接
- 对 `Frida / Xposed / 抓包 / Scrapy / Selenium / 代理池 / 验证码` 这类词更直白

## 你现在可以怎么用这份结果

如果目标是“Android逆向”：

- 优先盯：
  - 杭州
  - 温州
- 重点词：
  - `Android`
  - `Frida`
  - `Xposed`
  - `Hook`
  - `抓包`
  - `逆向`

如果目标是“爬虫 / 反爬 / 数据采集”：

- 优先盯：
  - 杭州
  - 宁波
  - 金华
- 重点词：
  - `Python`
  - `Scrapy`
  - `Selenium`
  - `DrissionPage`
  - `代理池`
  - `验证码`
  - `反爬`
  - `协议`

如果目标是“能最快转成投递 shortlist”：

- 第一组：
  - 杭州快手爬虫工程师
  - 杭州阿里反爬虫工程师
  - 宁波真和物流 python爬虫工程师
- 第二组：
  - 温州安卓逆向网络安全工程师
  - 杭州高级逆向工程师

## 最后判断

用当前 `rnidbg` 来看，浙江 `Android逆向 / 爬虫` 这条线的真实问题不是 `job-detail` 拉不回来，而是 `search` 对精确词命中差。  
真正稳的路径已经很清楚：

- 用历史样本锁定 shortlist
- 用当前 `rnidbg` 单路 `job-detail` 去验证实时有效性

这条路已经跑通，而且当前最值得继续深挖的是：

- 杭州 `逆向/反爬/混合岗`
- 宁波 `工程化爬虫岗`
- 温州 `安卓逆向岗`
