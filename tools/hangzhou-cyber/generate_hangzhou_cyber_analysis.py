#!/usr/bin/env python3
from __future__ import annotations

import argparse
import csv
import importlib.util
import json
import subprocess
import sys
from collections import Counter, defaultdict
from dataclasses import dataclass
from datetime import datetime
from pathlib import Path


REPO_ROOT = Path(__file__).resolve().parents[2]
YIWU_HELPERS = REPO_ROOT / "tools" / "yiwu-crossborder" / "generate_assets.py"

spec = importlib.util.spec_from_file_location("yiwu_assets", YIWU_HELPERS)
if spec is None or spec.loader is None:
    raise RuntimeError(f"failed to load helper module: {YIWU_HELPERS}")
helpers = importlib.util.module_from_spec(spec)
sys.modules[spec.name] = helpers
spec.loader.exec_module(helpers)


TMP_ROOT = Path("/tmp/hangzhou-cyber")
SEARCH_DIR = TMP_ROOT / "search"
DETAIL_DIR = TMP_ROOT / "detail"
META_DIR = TMP_ROOT / "meta"

REPORT_PATH = REPO_ROOT / "docs" / "hangzhou-cyber-granular-jd-report.md"
FULL_JSON_PATH = TMP_ROOT / "hangzhou-cyber-full-jd.json"
FULL_CSV_PATH = TMP_ROOT / "hangzhou-cyber-full-jd.csv"
SUMMARY_PATH = META_DIR / "summary.json"

CONTAINER = "rnidbg-lab"
CONTAINER_CLI = "/workspace/rnidbg/scripts/run-boss-yzwg.sh"
SESSION_PATH = "/workspace/lab-assets/.boss_purecalc/session.json"
CITY_CODE = "101210100"
CITY_NAME = "杭州"
PAGE_SIZE = "15"
PAGES = (1, 2, 3)

SEARCH_KEYWORDS = [
    "网络安全工程师",
    "安全研究员",
    "安全工程师",
    "渗透测试",
    "反爬虫工程师",
    "爬虫工程师",
    "安卓逆向",
    "Android逆向",
    "Win逆向",
    "Windows逆向",
    "软件逆向",
]

ROLE_LABELS = {
    "crawler_data": "爬虫/数据采集",
    "anti_crawl": "反爬/对抗/JS逆向",
    "android_reverse": "Android逆向/移动安全",
    "win_reverse": "Windows逆向/二进制逆向",
    "security_general": "网络安全/安全研究",
}

ROLE_KEYWORDS = {
    "crawler_data": [
        "爬虫",
        "数据采集",
        "rpa",
        "selenium",
        "playwright",
        "scrapy",
    ],
    "anti_crawl": [
        "反爬",
        "风控对抗",
        "风控",
        "js逆向",
        "协议分析",
        "补环境",
        "ast",
        "验证码",
        "黑灰产",
        "外挂",
    ],
    "android_reverse": [
        "安卓逆向",
        "android逆向",
        "android 逆向",
        "frida",
        "xposed",
        "jadx",
        "smali",
        "hook",
        "apk",
    ],
    "win_reverse": [
        "win逆向",
        "windows逆向",
        "软件逆向",
        "二进制逆向",
        "ida",
        "x64dbg",
        "ollydbg",
        "pe",
        "汇编",
        "脱壳",
        "shellcode",
    ],
    "security_general": [
        "网络安全",
        "安全研究员",
        "安全工程师",
        "渗透测试",
        "漏洞",
        "攻防",
        "红队",
        "蓝队",
        "应急响应",
        "web安全",
        "内网渗透",
    ],
}

TECH_KEYWORDS = [
    "python",
    "java",
    "go",
    "c++",
    "c#",
    "rust",
    "javascript",
    "js",
    "php",
    "sql",
    "linux",
]

TOOL_KEYWORDS = [
    "frida",
    "xposed",
    "jadx",
    "ida",
    "x64dbg",
    "ollydbg",
    "burp",
    "wireshark",
    "mitmproxy",
    "fiddler",
    "charles",
    "selenium",
    "playwright",
    "scrapy",
    "rpa",
    "docker",
    "kafka",
]

SIGNAL_KEYWORDS = [
    "协议分析",
    "js逆向",
    "补环境",
    "frida",
    "xposed",
    "jadx",
    "ida",
    "burp",
    "爬虫",
    "数据采集",
    "反爬",
    "风控对抗",
    "渗透测试",
    "漏洞",
    "shellcode",
    "脱壳",
    "汇编",
    "安卓",
    "android",
    "windows",
    "win",
]

HISTORY_REPORT = Path(
    "/Users/haojiejack/github/drizzle-dumper-rust/boss_purecalc/analysis/"
    "2026-03-12-zhejiang-crawler-reverse-live/report_final/zhejiang_hz_jh_nb_deep_report.md"
)


@dataclass
class CyberDetailRecord:
    lead: helpers.JobLead
    job_name: str
    company: str
    salary_desc: str
    experience_name: str
    degree_name: str
    area_district: str
    business_district: str
    location_desc: str
    position_category: str
    job_desc: str
    required_skills: list[str]
    role: str
    tech_keywords: list[str]
    tool_keywords: list[str]
    raw: dict

    def district_key(self) -> str:
        return self.area_district or "未标注区县"


def parse_args() -> argparse.Namespace:
    parser = argparse.ArgumentParser()
    parser.add_argument("--refresh", action="store_true")
    parser.add_argument("--max-detail", type=int, default=120)
    parser.add_argument("--per-keyword", type=int, default=10)
    return parser.parse_args()


def ensure_dirs() -> None:
    for path in [SEARCH_DIR, DETAIL_DIR, META_DIR, REPORT_PATH.parent]:
        path.mkdir(parents=True, exist_ok=True)


def run_project_cli(args: list[str]) -> dict:
    cmd = [
        "docker",
        "exec",
        CONTAINER,
        CONTAINER_CLI,
        *args,
        "--session-path",
        SESSION_PATH,
        "--invoke-runtime",
        "auto",
        "--transport-runtime",
        "direct",
    ]
    result = subprocess.run(
        cmd,
        cwd=REPO_ROOT,
        capture_output=True,
        text=True,
        timeout=240,
        check=False,
    )
    if result.returncode != 0:
        raise RuntimeError(
            f"command failed: {' '.join(cmd)}\nstderr:\n{result.stderr}\nstdout:\n{result.stdout}"
        )
    return json.loads(result.stdout)


def load_or_collect_json(path: Path, args: list[str], refresh: bool) -> dict:
    if path.exists() and not refresh:
        return json.loads(path.read_text(encoding="utf-8"))
    payload = run_project_cli(args)
    path.write_text(json.dumps(payload, ensure_ascii=False, indent=2), encoding="utf-8")
    return payload


def dedupe_key(lead: helpers.JobLead) -> tuple[str, str, str]:
    return (
        helpers.normalize_text(lead.company),
        helpers.normalize_text(lead.job_name),
        helpers.normalize_text(lead.area),
    )


def is_cyber_relevant_text(text: str) -> bool:
    lowered = text.lower()
    include = any(
        token in lowered
        for group in ROLE_KEYWORDS.values()
        for token in group
    )
    if not include:
        return False
    exclude = [
        "网络安全销售",
        "信息安全产品",
        "安全员",
        "消防安全",
        "工地安全",
        "施工安全",
        "食品安全",
        "视频投流",
        "媒体推广",
        "直播运营",
        "电商运营",
        "新媒体",
        "主播",
        "地图采集",
        "信息采集专员",
        "拍照上传",
        "扫街",
        "门头",
        "海外支付自动化",
    ]
    return not any(token in lowered for token in exclude)


def filter_relevant_leads(leads: list[helpers.JobLead]) -> list[helpers.JobLead]:
    out = {}
    for lead in leads:
        if helpers.coerce_text(lead.city) != CITY_NAME:
            continue
        combined = "|".join(
            [
                lead.job_name,
                lead.company,
                lead.city,
                lead.area,
                "|".join(lead.labels),
            ]
        )
        if not is_cyber_relevant_text(combined):
            continue
        key = dedupe_key(lead)
        if key not in out:
            out[key] = lead
        else:
            out[key].source_hits.extend(lead.source_hits)
            out[key].source_hits = sorted(set(out[key].source_hits))
    return list(out.values())


def select_live_leads(
    leads: list[helpers.JobLead],
    max_total: int,
    per_keyword: int,
) -> list[helpers.JobLead]:
    selected: dict[tuple[str, str, str], helpers.JobLead] = {}

    def add_bucket(bucket: list[helpers.JobLead], limit: int) -> None:
        count = 0
        for lead in sorted(
            bucket,
            key=lambda item: (
                -len(item.source_hits),
                item.area or "",
                item.job_name,
                item.company,
            ),
        ):
            key = dedupe_key(lead)
            if key in selected:
                continue
            selected[key] = lead
            count += 1
            if count >= limit or len(selected) >= max_total:
                break

    for keyword in SEARCH_KEYWORDS:
        bucket = [
            lead
            for lead in leads
            if any(hit.startswith(f"search:{keyword}:") for hit in lead.source_hits)
        ]
        add_bucket(bucket, per_keyword)

    if len(selected) < max_total:
        remaining = [lead for lead in leads if dedupe_key(lead) not in selected]
        add_bucket(remaining, max_total - len(selected))

    return list(selected.values())


def detail_cache_path(lead: helpers.JobLead) -> Path:
    filename = (
        f"{helpers.slugify(lead.area or 'no-area')}__"
        f"{helpers.slugify(lead.company)}__"
        f"{helpers.slugify(lead.job_name)}.json"
    )
    return DETAIL_DIR / filename


def load_or_collect_detail(lead: helpers.JobLead, refresh: bool) -> dict:
    cache_path = detail_cache_path(lead)
    return load_or_collect_json(
        cache_path,
        ["job-detail", lead.security_id],
        refresh,
    )


def classify_role(text: str) -> str:
    lowered = text.lower()
    if any(token in lowered for token in ROLE_KEYWORDS["android_reverse"]):
        return "android_reverse"
    if any(token in lowered for token in ROLE_KEYWORDS["win_reverse"]):
        return "win_reverse"
    if any(token in lowered for token in ROLE_KEYWORDS["anti_crawl"]):
        return "anti_crawl"
    if any(token in lowered for token in ROLE_KEYWORDS["crawler_data"]):
        return "crawler_data"
    return "security_general"


def extract_detail_record(lead: helpers.JobLead, payload: dict) -> CyberDetailRecord:
    node = (
        payload.get("response", {})
        .get("zpData", {})
        .get("/api/zpgeek/jobapp/geek/job/querydetail", {})
        .get("zpData", {})
    )
    if not node:
        node = (
            payload.get("raw_response", {})
            .get("zpData", {})
            .get("/api/zpgeek/jobapp/geek/job/querydetail", {})
            .get("zpData", {})
        )
    job_base = node.get("jobBaseInfo", {}) if isinstance(node, dict) else {}
    brand = node.get("brandComInfo", {}) if isinstance(node, dict) else {}
    job_desc = helpers.coerce_text(job_base.get("jobDesc"))
    skills = [helpers.coerce_text(item) for item in (job_base.get("requiredSkills") or []) if helpers.coerce_text(item)]
    combined = "|".join(
        [
            helpers.coerce_text(job_base.get("positionName") or lead.job_name),
            job_desc,
            "|".join(skills),
            "|".join(lead.labels),
        ]
    )
    role = classify_role(combined)
    return CyberDetailRecord(
        lead=lead,
        job_name=helpers.coerce_text(job_base.get("positionName") or lead.job_name),
        company=helpers.coerce_text(brand.get("brandName") or brand.get("comName") or lead.company),
        salary_desc=helpers.coerce_text(job_base.get("salaryDesc") or lead.salary),
        experience_name=helpers.coerce_text(job_base.get("experienceName") or lead.experience),
        degree_name=helpers.coerce_text(job_base.get("degreeName") or lead.degree),
        area_district=helpers.coerce_text(job_base.get("areaDistrict") or lead.area),
        business_district=helpers.coerce_text(job_base.get("businessDistrict")),
        location_desc=helpers.coerce_text(job_base.get("locationDesc")),
        position_category=helpers.coerce_text(job_base.get("positionCategory")),
        job_desc=job_desc,
        required_skills=skills,
        role=role,
        tech_keywords=sorted(set(helpers.find_keywords(combined, TECH_KEYWORDS))),
        tool_keywords=sorted(set(helpers.find_keywords(combined, TOOL_KEYWORDS))),
        raw=payload,
    )


def jd_brief(record: CyberDetailRecord) -> str:
    clauses = helpers.re.split(r"[\n。；;]+", record.job_desc)
    cleaned = [clause.strip(" -") for clause in clauses if clause.strip()]
    return "；".join(cleaned[:2]) or "JD 未返回可读摘要。"


def salary_range_desc(records: list[CyberDetailRecord]) -> str:
    lows = []
    highs = []
    for record in records:
        low, high = helpers.salary_bounds(record.salary_desc)
        if low is not None:
            lows.append(low)
            highs.append(high if high is not None else low)
    if not lows:
        common = Counter(record.salary_desc for record in records if record.salary_desc).most_common(3)
        return " / ".join(value for value, _ in common) or "未统计"
    return f"{min(lows):g}-{max(highs):g}K"


def representative_records(records: list[CyberDetailRecord], limit: int = 3) -> list[CyberDetailRecord]:
    def sort_key(record: CyberDetailRecord):
        low, high = helpers.salary_bounds(record.salary_desc)
        return (-(high or 0), -(low or 0), record.company, record.job_name)

    return sorted(records, key=sort_key)[:limit]


def top_pairs(counter: Counter, limit: int = 10) -> str:
    return "、".join(f"{name} {count}" for name, count in counter.most_common(limit)) or "未统计"


def load_history_note() -> str | None:
    if not HISTORY_REPORT.exists():
        return None
    for line in HISTORY_REPORT.read_text(encoding="utf-8").splitlines():
        if "杭州" in line and any(token in line for token in ["crawler", "reverse", "爬虫", "逆向"]):
            return line.strip()
    return None


def main() -> int:
    args = parse_args()
    ensure_dirs()

    search_payloads = []
    search_leads = []
    for keyword in SEARCH_KEYWORDS:
        for page in PAGES:
            cache_path = SEARCH_DIR / f"search__{helpers.slugify(keyword)}__p{page}.json"
            payload = load_or_collect_json(
                cache_path,
                [
                    "search",
                    keyword,
                    "--city",
                    CITY_CODE,
                    "--page",
                    str(page),
                    "--page-size",
                    PAGE_SIZE,
                ],
                args.refresh,
            )
            search_payloads.append((keyword, page, payload))
            search_leads.extend(helpers.extract_jobs(payload, "search", keyword, page, None))

    relevant_leads = filter_relevant_leads(search_leads)
    sampled_leads = select_live_leads(
        relevant_leads,
        max_total=max(1, args.max_detail),
        per_keyword=max(1, args.per_keyword),
    )
    detail_records = []
    skipped_details = []
    for lead in sorted(sampled_leads, key=lambda item: (item.area, item.job_name, item.company)):
        try:
            payload = load_or_collect_detail(lead, args.refresh)
        except Exception as exc:
            skipped_details.append(
                {
                    "keyword": lead.keyword,
                    "job_name": lead.job_name,
                    "company": lead.company,
                    "security_id": lead.security_id,
                    "error": str(exc),
                }
            )
            continue
        try:
            record = extract_detail_record(lead, payload)
        except Exception:
            continue
        combined = "|".join(
            [
                record.job_name,
                record.company,
                record.job_desc,
                "|".join(record.required_skills),
                record.position_category,
            ]
        )
        if not is_cyber_relevant_text(combined):
            continue
        detail_records.append(record)

    detail_records = sorted(
        detail_records,
        key=lambda item: (
            item.area_district or "",
            item.business_district or "",
            item.job_name,
            item.company,
        ),
    )

    rows = []
    for record in detail_records:
        rows.append(
            {
                "security_id": record.lead.security_id,
                "keyword": record.lead.keyword,
                "job_name": record.job_name,
                "company": record.company,
                "salary_desc": record.salary_desc,
                "experience_name": record.experience_name,
                "degree_name": record.degree_name,
                "area_district": record.area_district,
                "business_district": record.business_district,
                "location_desc": record.location_desc,
                "position_category": record.position_category,
                "role": record.role,
                "role_label": ROLE_LABELS[record.role],
                "tech_keywords": record.tech_keywords,
                "tool_keywords": record.tool_keywords,
                "required_skills": record.required_skills,
                "job_desc": record.job_desc,
            }
        )

    FULL_JSON_PATH.write_text(json.dumps(rows, ensure_ascii=False, indent=2), encoding="utf-8")
    with FULL_CSV_PATH.open("w", newline="", encoding="utf-8") as handle:
        writer = csv.DictWriter(
            handle,
            fieldnames=[
                "security_id",
                "keyword",
                "job_name",
                "company",
                "salary_desc",
                "experience_name",
                "degree_name",
                "area_district",
                "business_district",
                "location_desc",
                "position_category",
                "role",
                "role_label",
                "tech_keywords",
                "tool_keywords",
                "required_skills",
                "job_desc",
            ],
        )
        writer.writeheader()
        for row in rows:
            writer.writerow(
                {
                    key: "|".join(value) if isinstance(value, list) else value
                    for key, value in row.items()
                }
            )

    area_groups: dict[str, list[CyberDetailRecord]] = defaultdict(list)
    role_groups: dict[str, list[CyberDetailRecord]] = defaultdict(list)
    business_counter = Counter()
    exp_counter = Counter()
    degree_counter = Counter()
    tech_counter = Counter()
    tool_counter = Counter()
    signal_counter = Counter()

    for record in detail_records:
        area_groups[record.district_key()].append(record)
        role_groups[record.role].append(record)
        if record.business_district:
            business_counter[record.business_district] += 1
        if record.experience_name:
            exp_counter[record.experience_name] += 1
        if record.degree_name:
            degree_counter[record.degree_name] += 1
        for item in record.tech_keywords:
            tech_counter[item] += 1
        for item in record.tool_keywords:
            tool_counter[item] += 1
        combined = "|".join([record.job_name, record.job_desc, "|".join(record.required_skills)]).lower()
        for signal in SIGNAL_KEYWORDS:
            if signal.lower() in combined:
                signal_counter[signal] += 1

    history_note = load_history_note()
    lines = [
        "# 杭州网络安全 / 爬虫 / 安卓-Win逆向岗位细颗粒度 JD 报告",
        "",
        f"- 生成时间：`{datetime.now().strftime('%Y-%m-%d %H:%M:%S %z')}`",
        f"- live 口径：`search + job-detail`，城市码 `101210100`，城市 `杭州`。",
        f"- 关键词：`{'、'.join(SEARCH_KEYWORDS)}`",
        f"- search 原始样本：`{len(search_leads)}`，去重后相关岗位：`{len(relevant_leads)}`，本轮采样上限：`{len(sampled_leads)}`，JD 回填成功：`{len(detail_records)}`，跳过：`{len(skipped_details)}`。",
        f"- 落盘：`{FULL_JSON_PATH}`、`{FULL_CSV_PATH}`、`{REPORT_PATH}`",
        "",
        "## 先看结论",
        "",
        f"- 经验门槛 Top：`{top_pairs(exp_counter, 8)}`",
        f"- 学历门槛 Top：`{top_pairs(degree_counter, 8)}`",
        f"- 岗位方向 Top：`{top_pairs(Counter(ROLE_LABELS[item.role] for item in detail_records), 8)}`",
        f"- 热门区县 Top：`{top_pairs(Counter(record.district_key() for record in detail_records), 8)}`",
        f"- 热门商圈 Top：`{top_pairs(business_counter, 12)}`",
        f"- 技术关键词 Top：`{top_pairs(tech_counter, 12)}`",
        f"- 工具关键词 Top：`{top_pairs(tool_counter, 12)}`",
        f"- 高频动作词：`{top_pairs(signal_counter, 12)}`",
    ]
    if history_note:
        lines.extend(["", f"- 历史补充：`{history_note}`"])
    lines.extend(["", "## 区县细颗粒度拆解", ""])

    for area, records in sorted(area_groups.items(), key=lambda item: (-len(item[1]), item[0])):
        lines.extend(
            [
                f"### {area}",
                "",
                f"- JD 数：`{len(records)}`",
                f"- 薪资区间：`{salary_range_desc(records)}`",
                f"- 岗位方向：`{top_pairs(Counter(ROLE_LABELS[item.role] for item in records), 5)}`",
                f"- 商圈：`{top_pairs(Counter(item.business_district for item in records if item.business_district), 6)}`",
                "",
            ]
        )
        for record in representative_records(records, limit=3):
            lines.append(
                f"- {record.job_name}｜{record.company}｜`{record.salary_desc or '未标注薪资'}`｜`{record.experience_name or '经验未写明'}`｜`{record.degree_name or '学历未写明'}`"
            )
            lines.append(
                f"  - 方向：`{ROLE_LABELS[record.role]}`；技术：`{'、'.join(record.tech_keywords) or '未显式写出'}`；工具：`{'、'.join(record.tool_keywords) or '未显式写出'}`"
            )
            lines.append(f"  - 摘要：{jd_brief(record)}")
        lines.append("")

    lines.extend(["## 岗位方向拆解", ""])
    for role, label in ROLE_LABELS.items():
        records = role_groups.get(role, [])
        if not records:
            continue
        lines.extend(
            [
                f"### {label}",
                "",
                f"- 样本数：`{len(records)}`",
                f"- 薪资区间：`{salary_range_desc(records)}`",
                f"- 经验门槛：`{top_pairs(Counter(item.experience_name for item in records if item.experience_name), 5)}`",
                f"- 学历门槛：`{top_pairs(Counter(item.degree_name for item in records if item.degree_name), 5)}`",
                f"- 技术关键词：`{top_pairs(Counter(word for item in records for word in item.tech_keywords), 8)}`",
                f"- 工具关键词：`{top_pairs(Counter(word for item in records for word in item.tool_keywords), 8)}`",
                "",
            ]
        )
        for record in representative_records(records, limit=2):
            lines.append(
                f"- 代表 JD：{record.job_name}｜{record.company}｜`{record.salary_desc or '未标注薪资'}`｜{record.location_desc or record.area_district}"
            )
            lines.append(f"  - 摘要：{jd_brief(record)}")
        lines.append("")

    lines.extend(["## 全量 JD 清单", ""])
    for record in detail_records:
        lines.append(
            f"- {record.job_name}｜{record.company}｜`{record.salary_desc or '未标注薪资'}`｜`{record.area_district or '未标注区县'}`｜`{ROLE_LABELS[record.role]}`"
        )
        lines.append(
            f"  - 技术：`{'、'.join(record.tech_keywords) or '未显式写出'}`；工具：`{'、'.join(record.tool_keywords) or '未显式写出'}`；标签：`{'、'.join(record.required_skills) or '未显式写出'}`"
        )
        lines.append(f"  - 摘要：{jd_brief(record)}")
    REPORT_PATH.write_text("\n".join(lines), encoding="utf-8")

    SUMMARY_PATH.write_text(
        json.dumps(
            {
                "generated_at": datetime.now().isoformat(),
                "city_code": CITY_CODE,
                "city_name": CITY_NAME,
                "search_keywords": SEARCH_KEYWORDS,
                "search_raw_count": len(search_leads),
                "relevant_lead_count": len(relevant_leads),
                "sampled_lead_count": len(sampled_leads),
                "detail_count": len(detail_records),
                "skipped_detail_count": len(skipped_details),
                "skipped_details": skipped_details,
                "role_counts": Counter(ROLE_LABELS[item.role] for item in detail_records),
                "district_counts": Counter(item.district_key() for item in detail_records),
                "business_district_counts": business_counter,
                "experience_counts": exp_counter,
                "degree_counts": degree_counter,
                "tech_counts": tech_counter,
                "tool_counts": tool_counter,
                "json_path": str(FULL_JSON_PATH),
                "csv_path": str(FULL_CSV_PATH),
                "report_path": str(REPORT_PATH),
            },
            ensure_ascii=False,
            indent=2,
            default=lambda value: dict(value),
        ),
        encoding="utf-8",
    )
    print(
        json.dumps(
            {
                "search_raw_count": len(search_leads),
                "relevant_lead_count": len(relevant_leads),
                "detail_count": len(detail_records),
                "report_path": str(REPORT_PATH),
            },
            ensure_ascii=False,
            indent=2,
        )
    )
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
