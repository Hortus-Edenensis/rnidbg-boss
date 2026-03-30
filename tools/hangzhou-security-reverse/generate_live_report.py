#!/usr/bin/env python3
from __future__ import annotations

import argparse
import csv
import hashlib
import json
import re
import shlex
import subprocess
from collections import Counter, defaultdict
from dataclasses import dataclass, field
from datetime import datetime
from pathlib import Path


REPO_ROOT = Path(__file__).resolve().parents[2]
TMP_ROOT = Path("/tmp/hangzhou-security-reverse")
SEARCH_DIR = TMP_ROOT / "search"
DETAIL_DIR = TMP_ROOT / "detail"
META_DIR = TMP_ROOT / "meta"

REPORT_PATH = REPO_ROOT / "docs" / "hangzhou-security-crawler-reverse-live-report.md"
FULL_JSON_PATH = TMP_ROOT / "hangzhou-security-crawler-reverse-full.json"
FULL_CSV_PATH = TMP_ROOT / "hangzhou-security-crawler-reverse-full.csv"
SUMMARY_PATH = META_DIR / "summary.json"

CONTAINER = "rnidbg-lab"
CONTAINER_REPO = "/workspace/rnidbg"
CONTAINER_CLI = "./scripts/run-boss-yzwg.sh"
SESSION_PATH = "/workspace/lab-assets/.boss_purecalc/session.json"
CITY_CODE = "101210100"
PAGE_SIZE = "20"
MAX_PAGES_DEFAULT = 50
EMPTY_PAGE_BREAK_STREAK = 1
NO_NEW_PAGE_BREAK_STREAK = 2

SEARCH_KEYWORDS = [
    "网络安全工程师",
    "客户端安全工程师",
    "安全研究员",
    "爬虫工程师",
    "反爬虫工程师",
    "Android逆向",
    "安卓逆向",
    "Windows逆向",
    "逆向工程师",
]

CLUSTER_LABELS = {
    "network_security": "网络安全/攻防",
    "crawler_antibot": "爬虫/反爬/数据采集",
    "android_reverse": "安卓/iOS逆向",
    "windows_reverse": "Windows逆向/客户端安全",
    "research_misc": "综合逆向/安全研究",
}

SIGNAL_KEYWORDS = [
    "爬虫",
    "反爬",
    "数据采集",
    "RPA",
    "Android",
    "安卓",
    "iOS",
    "Windows",
    "Win",
    "逆向",
    "客户端安全",
    "网络安全",
    "渗透测试",
    "漏洞",
    "攻防",
    "病毒分析",
    "风控",
    "防作弊",
    "Frida",
    "Xposed",
    "IDA",
    "C++",
    "Python",
    "Golang",
]


@dataclass
class JobLead:
    source: str
    keyword: str
    page: int
    job_name: str
    company: str
    city: str
    area: str
    salary: str
    experience: str
    degree: str
    security_id: str
    labels: list[str]
    active_time: str
    raw: dict = field(default_factory=dict)
    source_hits: list[str] = field(default_factory=list)

    def dedupe_key(self) -> tuple[str, str, str]:
        return (
            normalize_text(self.company),
            normalize_text(self.job_name),
            normalize_text(self.area),
        )


@dataclass
class JobDetailRecord:
    lead: JobLead
    job_name: str
    company: str
    salary_desc: str
    experience_name: str
    degree_name: str
    area_district: str
    business_district: str
    location_desc: str
    position_category: str
    cluster: str
    job_desc: str
    required_skills: list[str]
    matched_signals: list[str]
    raw: dict = field(default_factory=dict)

    def district_key(self) -> str:
        return self.area_district or "未标注区县"


@dataclass
class SearchPaginationMeta:
    keyword: str
    pages_fetched: int
    total_count_hint: int | None
    stop_reason: str


def parse_args() -> argparse.Namespace:
    parser = argparse.ArgumentParser()
    parser.add_argument("--refresh", action="store_true")
    parser.add_argument("--max-pages", type=int, default=MAX_PAGES_DEFAULT)
    return parser.parse_args()


def ensure_dirs() -> None:
    for path in [SEARCH_DIR, DETAIL_DIR, META_DIR, REPORT_PATH.parent]:
        path.mkdir(parents=True, exist_ok=True)


def coerce_text(value) -> str:
    if value is None:
        return ""
    if isinstance(value, str):
        return value.strip()
    if isinstance(value, (int, float)):
        return str(value)
    if isinstance(value, dict):
        for key in ("name", "text", "content", "title", "value"):
            if key in value:
                text = coerce_text(value[key])
                if text:
                    return text
        return ""
    if isinstance(value, list):
        return " / ".join(filter(None, (coerce_text(item) for item in value)))
    return str(value).strip()


def normalize_text(text: str) -> str:
    return re.sub(r"\s+", "", coerce_text(text).lower())


def slugify(text: str) -> str:
    return re.sub(r'[\\/:*?"<>|]+', "-", text).strip()


def run_container_cli(subcommand_args: list[str], out_path: Path, refresh: bool) -> dict:
    if out_path.exists() and not refresh:
        return json.loads(out_path.read_text(encoding="utf-8"))

    container_out = f"/tmp/hz_jobscan_{hashlib.sha1(str(out_path).encode('utf-8')).hexdigest()}.json"
    all_args = subcommand_args + ["--out", container_out]
    quoted = " ".join(shlex.quote(arg) for arg in all_args)
    run_cmd = [
        "docker",
        "exec",
        CONTAINER,
        "bash",
        "-lc",
        f"cd {shlex.quote(CONTAINER_REPO)} && {CONTAINER_CLI} {quoted} >/dev/null",
    ]
    result = subprocess.run(run_cmd, cwd=REPO_ROOT, capture_output=True, text=True, check=False, timeout=240)
    if result.returncode != 0:
        raise RuntimeError(f"command failed: {' '.join(run_cmd)}\nstderr:\n{result.stderr}\nstdout:\n{result.stdout}")

    cat_cmd = ["docker", "exec", CONTAINER, "cat", container_out]
    result = subprocess.run(cat_cmd, cwd=REPO_ROOT, capture_output=True, text=True, check=False, timeout=60)
    if result.returncode != 0:
        raise RuntimeError(f"failed to read container output: {' '.join(cat_cmd)}\nstderr:\n{result.stderr}")
    payload = json.loads(result.stdout)
    out_path.write_text(json.dumps(payload, ensure_ascii=False, indent=2), encoding="utf-8")
    return payload


def recursive_job_extract(node, out: list[dict]) -> None:
    if isinstance(node, dict):
        keys = set(node)
        if (
            ("securityId" in keys or "encryptJobId" in keys or "encryptId" in keys)
            and ("jobName" in keys or "positionName" in keys)
            and ("city" in keys or "cityName" in keys or "areaDistrict" in keys or "brandName" in keys or "company" in keys)
        ):
            out.append(node)
        for value in node.values():
            recursive_job_extract(value, out)
    elif isinstance(node, list):
        for value in node:
            recursive_job_extract(value, out)


def extract_jobs(payload: dict, keyword: str, page: int) -> list[JobLead]:
    raw_hits: list[dict] = []
    recursive_job_extract(payload.get("response", {}), raw_hits)
    jobs: list[JobLead] = []
    seen = set()
    for item in raw_hits:
        security_id = coerce_text(item.get("securityId") or item.get("encryptJobId") or item.get("encryptId"))
        job_name = coerce_text(item.get("jobName") or item.get("positionName"))
        company = coerce_text(item.get("brandName") or item.get("company") or item.get("comName"))
        city = coerce_text(item.get("cityName") or item.get("city") or item.get("locationName"))
        area = coerce_text(item.get("areaDistrict"))
        if not (security_id and job_name and company):
            continue
        marker = (security_id, job_name, company, city, area)
        if marker in seen:
            continue
        seen.add(marker)
        labels = []
        for value in item.get("jobLabels", []) or item.get("skills", []) or []:
            text = coerce_text(value)
            if text:
                labels.append(text)
        jobs.append(
            JobLead(
                source="search",
                keyword=keyword,
                page=page,
                job_name=job_name,
                company=company,
                city=city,
                area=area,
                salary=coerce_text(item.get("salaryDesc")),
                experience=coerce_text(item.get("jobExperience") or item.get("experienceName")),
                degree=coerce_text(item.get("jobDegree") or item.get("degreeName")),
                security_id=security_id,
                labels=labels,
                active_time=coerce_text(item.get("activeTimeDesc")),
                raw=item,
                source_hits=[f"search:{keyword}:p{page}"],
            )
        )
    return jobs


def extract_total_count(payload: dict) -> int | None:
    totals: list[int] = []

    def walk(node) -> None:
        if isinstance(node, dict):
            for key, value in node.items():
                if key == "totalCount" and isinstance(value, int):
                    totals.append(value)
                walk(value)
        elif isinstance(node, list):
            for value in node:
                walk(value)

    walk(payload.get("response", {}))
    if not totals:
        return None
    return max(totals)


def merge_leads(leads: list[JobLead]) -> list[JobLead]:
    merged: dict[tuple[str, str, str], JobLead] = {}
    for lead in leads:
        key = lead.dedupe_key()
        if key not in merged:
            merged[key] = lead
            continue
        current = merged[key]
        current.source_hits.extend(lead.source_hits)
        if not current.security_id and lead.security_id:
            current.security_id = lead.security_id
        if not current.salary and lead.salary:
            current.salary = lead.salary
        if len(lead.labels) > len(current.labels):
            current.labels = lead.labels
    for lead in merged.values():
        lead.source_hits = sorted(set(lead.source_hits))
    return list(merged.values())


def search_cache_path(keyword: str, page: int) -> Path:
    return SEARCH_DIR / f"search__{slugify(keyword)}__p{page}.json"


def collect_search_pages(
    keyword: str,
    refresh: bool,
    max_pages: int,
) -> tuple[list[JobLead], SearchPaginationMeta]:
    page = 1
    total_hint = None
    collected: list[JobLead] = []
    seen_markers: set[tuple[str, str, str, str, str]] = set()
    empty_streak = 0
    no_new_streak = 0
    stop_reason = "max_pages"

    while page <= max_pages:
        payload = run_container_cli(
            [
                "search",
                keyword,
                "--city",
                CITY_CODE,
                "--page",
                str(page),
                "--page-size",
                PAGE_SIZE,
                "--session-path",
                SESSION_PATH,
                "--invoke-runtime",
                "auto",
                "--transport-runtime",
                "direct",
            ],
            search_cache_path(keyword, page),
            refresh,
        )
        jobs = extract_jobs(payload, keyword, page)
        collected.extend(jobs)

        hint = extract_total_count(payload)
        if hint:
            total_hint = max(total_hint or 0, hint)

        if not jobs:
            empty_streak += 1
        else:
            empty_streak = 0

        new_on_page = 0
        for lead in jobs:
            marker = (
                lead.security_id,
                normalize_text(lead.job_name),
                normalize_text(lead.company),
                normalize_text(lead.city),
                normalize_text(lead.area),
            )
            if marker not in seen_markers:
                seen_markers.add(marker)
                new_on_page += 1

        if jobs and new_on_page == 0:
            no_new_streak += 1
        elif jobs:
            no_new_streak = 0

        if total_hint:
            hinted_pages = max(1, (total_hint + int(PAGE_SIZE) - 1) // int(PAGE_SIZE))
            if page >= hinted_pages:
                stop_reason = "total_count_reached"
                break
        if empty_streak >= EMPTY_PAGE_BREAK_STREAK:
            stop_reason = "empty_page"
            break
        if no_new_streak >= NO_NEW_PAGE_BREAK_STREAK:
            stop_reason = "duplicate_pages"
            break
        page += 1

    return collected, SearchPaginationMeta(
        keyword=keyword,
        pages_fetched=page,
        total_count_hint=total_hint,
        stop_reason=stop_reason,
    )


def is_target_relevant(lead: JobLead) -> bool:
    text = "|".join(
        [
            lead.keyword,
            lead.job_name,
            lead.company,
            lead.city,
            lead.area,
            "|".join(lead.labels),
        ]
    ).lower()
    needles = [
        "网络安全",
        "安全",
        "爬虫",
        "反爬",
        "数据采集",
        "逆向",
        "android",
        "安卓",
        "ios",
        "windows",
        "win",
        "客户端安全",
        "渗透",
        "漏洞",
        "攻防",
        "病毒分析",
    ]
    return any(needle in text for needle in needles)


def detail_cache_path(lead: JobLead) -> Path:
    return DETAIL_DIR / f"{slugify(lead.area or 'no-area')}__{slugify(lead.company)}__{slugify(lead.job_name)}.json"


def load_or_collect_detail(lead: JobLead, refresh: bool) -> dict:
    return run_container_cli(
        [
            "job-detail",
            lead.security_id,
            "--session-path",
            SESSION_PATH,
            "--invoke-runtime",
            "auto",
            "--transport-runtime",
            "direct",
        ],
        detail_cache_path(lead),
        refresh,
    )


def classify_cluster(text: str) -> str:
    lowered = text.lower()
    if any(token in lowered for token in ["爬虫", "反爬", "数据采集", "rpa", "验证码", "anti-bot", "反作弊风控"]):
        return "crawler_antibot"
    if any(token in lowered for token in ["windows", "win32", "pc客户端", "驱动", "外挂", "防作弊", "客户端安全"]) and "android" not in lowered and "安卓" not in lowered:
        return "windows_reverse"
    if any(token in lowered for token in ["android", "安卓", "ios", "frida", "xposed", "smali", "jadx", "移动应用安全"]):
        return "android_reverse"
    if any(token in lowered for token in ["渗透", "漏洞", "安全", "攻防", "web安全", "云安全", "安全研发", "安全研究", "病毒分析"]):
        return "network_security"
    return "research_misc"


def find_signals(text: str) -> list[str]:
    lowered = text.lower()
    hits = []
    for keyword in SIGNAL_KEYWORDS:
        if keyword.lower() in lowered:
            hits.append(keyword)
    return sorted(set(hits))


def extract_detail_record(lead: JobLead, payload: dict) -> JobDetailRecord:
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
    job_desc = coerce_text(job_base.get("jobDesc"))
    skills = [coerce_text(item) for item in (job_base.get("requiredSkills") or []) if coerce_text(item)]
    combined = "|".join(
        [
            coerce_text(job_base.get("positionName") or lead.job_name),
            lead.job_name,
            "|".join(lead.labels),
            "|".join(skills),
            job_desc,
        ]
    )
    return JobDetailRecord(
        lead=lead,
        job_name=coerce_text(job_base.get("positionName") or lead.job_name),
        company=coerce_text(brand.get("brandName") or brand.get("comName") or lead.company),
        salary_desc=coerce_text(job_base.get("salaryDesc") or lead.salary),
        experience_name=coerce_text(job_base.get("experienceName") or lead.experience),
        degree_name=coerce_text(job_base.get("degreeName") or lead.degree),
        area_district=coerce_text(job_base.get("areaDistrict") or lead.area),
        business_district=coerce_text(job_base.get("businessDistrict")),
        location_desc=coerce_text(job_base.get("locationDesc")),
        position_category=coerce_text(job_base.get("positionCategory")),
        cluster=classify_cluster(combined),
        job_desc=job_desc,
        required_skills=skills,
        matched_signals=find_signals(combined),
        raw=payload,
    )


def is_detail_relevant(record: JobDetailRecord) -> bool:
    title_text = "|".join([record.job_name, record.position_category]).lower()
    combined = "|".join(
        [
            record.job_name,
            record.position_category,
            record.job_desc,
            "|".join(record.required_skills),
            "|".join(record.matched_signals),
        ]
    ).lower()
    title_keep_tokens = [
        "安全",
        "爬虫",
        "反爬",
        "逆向",
        "渗透",
        "漏洞",
        "数据采集",
        "客户端",
        "web安全",
        "云安全",
        "移动安全",
        "黑灰产",
        "风控",
    ]

    hard_drop_titles = [
        "产品经理",
        "数据分析师",
        "实施工程师",
        "桌面运维",
        "web前端",
        "coze开发",
        "海外支付自动化工程师",
    ]
    if any(token in title_text for token in hard_drop_titles):
        return False

    generic_dev_titles = [
        "全栈",
        "android开发工程师",
        "客户端开发工程师",
        "安卓高级开发工程师",
        "测试开发工程师",
        "java架构师",
        "java",
        "开发工程师",
    ]
    if any(token in title_text for token in generic_dev_titles):
        if not any(token in title_text for token in title_keep_tokens):
            return False
    if any(token in title_text for token in title_keep_tokens):
        return True
    if any(token in combined for token in ["爬虫", "反爬", "逆向", "客户端安全", "移动安全", "网络安全", "渗透测试", "漏洞", "数据采集"]):
        if not any(token in title_text for token in ["全栈", "java", "开发工程师", "android开发工程师", "客户端开发工程师"]):
            return True
    return False


def salary_bounds(text: str) -> tuple[float | None, float | None]:
    salary = coerce_text(text)
    m = re.search(r"(\d+(?:\.\d+)?)\s*-\s*(\d+(?:\.\d+)?)\s*K", salary, re.IGNORECASE)
    if m:
        return float(m.group(1)), float(m.group(2))
    m = re.search(r"(\d+(?:\.\d+)?)\s*K", salary, re.IGNORECASE)
    if m:
        value = float(m.group(1))
        return value, value
    m = re.search(r"(\d+(?:\.\d+)?)\s*-\s*(\d+(?:\.\d+)?)\s*元/月", salary)
    if m:
        return float(m.group(1)) / 1000.0, float(m.group(2)) / 1000.0
    return None, None


def salary_range_desc(records: list[JobDetailRecord]) -> str:
    lows = []
    highs = []
    for record in records:
        low, high = salary_bounds(record.salary_desc)
        if low is not None:
            lows.append(low)
            highs.append(high if high is not None else low)
    if not lows:
        common = Counter(record.salary_desc for record in records if record.salary_desc).most_common(3)
        return " / ".join(value for value, _ in common) or "未统计"
    return f"{min(lows):g}-{max(highs):g}K"


def representative_records(records: list[JobDetailRecord], limit: int = 3) -> list[JobDetailRecord]:
    def sort_key(record: JobDetailRecord):
        low, high = salary_bounds(record.salary_desc)
        return (-(high or 0), -(low or 0), record.company, record.job_name)

    return sorted(records, key=sort_key)[:limit]


def jd_brief(record: JobDetailRecord) -> str:
    clauses = re.split(r"[\n。；;]+", record.job_desc)
    cleaned = [clause.strip(" -") for clause in clauses if clause.strip()]
    return "；".join(cleaned[:2]) or "JD 未返回可读摘要。"


def write_full_exports(records: list[JobDetailRecord]) -> None:
    rows = []
    for record in records:
        rows.append(
            {
                "security_id": record.lead.security_id,
                "job_name": record.job_name,
                "company": record.company,
                "salary_desc": record.salary_desc,
                "experience_name": record.experience_name,
                "degree_name": record.degree_name,
                "area_district": record.area_district,
                "business_district": record.business_district,
                "location_desc": record.location_desc,
                "position_category": record.position_category,
                "cluster": record.cluster,
                "cluster_label": CLUSTER_LABELS.get(record.cluster, record.cluster),
                "matched_signals": record.matched_signals,
                "required_skills": record.required_skills,
                "job_desc": record.job_desc,
                "source_hits": record.lead.source_hits,
            }
        )
    FULL_JSON_PATH.write_text(json.dumps(rows, ensure_ascii=False, indent=2), encoding="utf-8")
    with FULL_CSV_PATH.open("w", newline="", encoding="utf-8") as handle:
        writer = csv.DictWriter(handle, fieldnames=list(rows[0].keys()) if rows else [
            "security_id",
            "job_name",
            "company",
            "salary_desc",
            "experience_name",
            "degree_name",
            "area_district",
            "business_district",
            "location_desc",
            "position_category",
            "cluster",
            "cluster_label",
            "matched_signals",
            "required_skills",
            "job_desc",
            "source_hits",
        ])
        writer.writeheader()
        for row in rows:
            writer.writerow({key: "|".join(value) if isinstance(value, list) else value for key, value in row.items()})


def render_report(
    search_leads: list[JobLead],
    detail_records: list[JobDetailRecord],
    raw_detail_count: int,
    pagination_meta: list[SearchPaginationMeta],
    max_pages: int,
) -> tuple[str, dict]:
    district_groups: dict[str, list[JobDetailRecord]] = defaultdict(list)
    cluster_groups: dict[str, list[JobDetailRecord]] = defaultdict(list)
    keyword_hits: Counter = Counter()
    district_counter = Counter()
    cluster_counter = Counter()
    signal_counter = Counter()
    exp_counter = Counter()
    degree_counter = Counter()
    position_counter = Counter()

    for lead in search_leads:
        keyword_hits[lead.keyword] += 1
    for record in detail_records:
        district_groups[record.district_key()].append(record)
        cluster_groups[record.cluster].append(record)
        district_counter[record.district_key()] += 1
        cluster_counter[CLUSTER_LABELS.get(record.cluster, record.cluster)] += 1
        exp_counter[record.experience_name] += 1
        degree_counter[record.degree_name] += 1
        if record.position_category:
            position_counter[record.position_category] += 1
        for signal in record.matched_signals:
            signal_counter[signal] += 1

    lines = [
        "# 杭州网络安全 / 爬虫 / 安卓与 Windows 逆向 live JD 报告",
        "",
        f"- 生成时间：`{datetime.now().strftime('%Y-%m-%d %H:%M:%S %z')}`",
        f"- 城市码：`{CITY_CODE}`（杭州）",
        "- 运行入口：`search + job-detail`",
        f"- 关键词：`{'、'.join(SEARCH_KEYWORDS)}`",
        f"- 翻页策略：`每个关键词持续翻页，直到 totalCount 覆盖 / 空页 / 连续重复页收敛；单关键词最大 {max_pages} 页。`",
        f"- 去重后 live 搜索命中：`{len(search_leads)}`",
        f"- 已回填原始 job-detail 缓存：`{raw_detail_count}`",
        f"- JD 级二次筛选后有效岗位：`{len(detail_records)}`",
        f"- 落盘：`{FULL_JSON_PATH}`、`{FULL_CSV_PATH}`、`{REPORT_PATH}`",
        "",
        "## 结论先看",
        "",
        f"- 高频区县：`{'、'.join(f'{name} {count}' for name, count in district_counter.most_common(8))}`",
        f"- 高频岗位簇：`{'、'.join(f'{name} {count}' for name, count in cluster_counter.most_common())}`",
        f"- 高频经验门槛：`{'、'.join(f'{name} {count}' for name, count in exp_counter.most_common(6))}`",
        f"- 高频学历门槛：`{'、'.join(f'{name} {count}' for name, count in degree_counter.most_common(6))}`",
        f"- 高频职位类目：`{'、'.join(f'{name} {count}' for name, count in position_counter.most_common(8)) or '未显式写出'}`",
        f"- 高频 JD 信号：`{'、'.join(f'{name} {count}' for name, count in signal_counter.most_common(12))}`",
        "",
        "## 翻页覆盖",
        "",
    ]
    for meta in pagination_meta:
        lines.append(
            f"- `{meta.keyword}`：抓取 `{meta.pages_fetched}` 页，`totalCount` 提示 `{meta.total_count_hint if meta.total_count_hint is not None else '未知'}`，停止原因 `{meta.stop_reason}`"
        )

    lines.extend([
        "",
        "## 关键词命中表现",
        "",
    ])
    for keyword, count in keyword_hits.most_common():
        lines.append(f"- `{keyword}`：`{count}` 条去重后命中")

    lines.extend(["", "## 区县细颗粒度拆解", ""])
    for district, records in sorted(district_groups.items(), key=lambda item: (-len(item[1]), item[0])):
        area_clusters = Counter(CLUSTER_LABELS.get(record.cluster, record.cluster) for record in records)
        area_signals = Counter(signal for record in records for signal in record.matched_signals)
        lines.extend(
            [
                f"### {district}",
                "",
                f"- live JD 数：`{len(records)}`",
                f"- 薪资区间：`{salary_range_desc(records)}`",
                f"- 岗位簇：`{'、'.join(f'{name} {count}' for name, count in area_clusters.most_common())}`",
                f"- 高频信号：`{'、'.join(f'{name} {count}' for name, count in area_signals.most_common(8)) or '未统计'}`",
                "",
            ]
        )
        for record in representative_records(records):
            lines.append(
                f"- {record.job_name}｜{record.company}｜`{record.salary_desc or '未标注薪资'}`｜`{record.experience_name or '经验未写明'}`｜`{record.degree_name or '学历未写明'}`"
            )
            lines.append(f"  - JD 摘要：{jd_brief(record)}")
            lines.append(f"  - 信号：`{'、'.join(record.matched_signals) or '未显式写出'}`")
        lines.append("")

    lines.extend(["## 岗位簇拆解", ""])
    for cluster, label in CLUSTER_LABELS.items():
        records = cluster_groups.get(cluster, [])
        if not records:
            continue
        cluster_exp = Counter(record.experience_name for record in records if record.experience_name)
        cluster_degree = Counter(record.degree_name for record in records if record.degree_name)
        cluster_signals = Counter(signal for record in records for signal in record.matched_signals)
        lines.extend(
            [
                f"### {label}",
                "",
                f"- 样本数：`{len(records)}`",
                f"- 薪资区间：`{salary_range_desc(records)}`",
                f"- 经验门槛：`{'、'.join(f'{name} {count}' for name, count in cluster_exp.most_common(5)) or '未统计'}`",
                f"- 学历门槛：`{'、'.join(f'{name} {count}' for name, count in cluster_degree.most_common(5)) or '未统计'}`",
                f"- 高频信号：`{'、'.join(f'{name} {count}' for name, count in cluster_signals.most_common(10)) or '未统计'}`",
                "",
            ]
        )
        for record in representative_records(records, limit=2):
            lines.append(f"- 代表 JD：{record.job_name}｜{record.company}｜`{record.salary_desc}`｜{record.location_desc or record.area_district}")
            lines.append(f"  - 摘要：{jd_brief(record)}")
        lines.append("")

    lines.extend(["## 全量 JD 清单", ""])
    for record in detail_records:
        lines.append(
            f"- {record.job_name}｜{record.company}｜`{record.salary_desc or '未标注薪资'}`｜`{record.area_district or '未标注区县'}`｜`{CLUSTER_LABELS.get(record.cluster, record.cluster)}`"
        )
        lines.append(
            f"  - 信号：`{'、'.join(record.matched_signals) or '未显式写出'}`｜经验：`{record.experience_name or '未写明'}`｜学历：`{record.degree_name or '未写明'}`"
        )
        lines.append(f"  - 摘要：{jd_brief(record)}")
        lines.append("")

    summary = {
        "generated_at": datetime.now().isoformat(),
        "city_code": CITY_CODE,
        "max_pages_requested": max_pages,
        "pagination": [
            {
                "keyword": meta.keyword,
                "pages_fetched": meta.pages_fetched,
                "total_count_hint": meta.total_count_hint,
                "stop_reason": meta.stop_reason,
            }
            for meta in pagination_meta
        ],
        "keyword_hits": dict(keyword_hits),
        "search_lead_count": len(search_leads),
        "raw_detail_count": raw_detail_count,
        "detail_count": len(detail_records),
        "filtered_detail_count": len(detail_records),
        "district_counts": dict(district_counter),
        "cluster_counts": dict(cluster_counter),
        "experience_counts": dict(exp_counter),
        "degree_counts": dict(degree_counter),
        "position_category_counts": dict(position_counter),
        "signal_counts": dict(signal_counter),
        "report_path": str(REPORT_PATH),
        "json_path": str(FULL_JSON_PATH),
        "csv_path": str(FULL_CSV_PATH),
    }
    return "\n".join(lines), summary


def main() -> int:
    args = parse_args()
    ensure_dirs()

    search_leads: list[JobLead] = []
    pagination_meta: list[SearchPaginationMeta] = []
    for keyword in SEARCH_KEYWORDS:
        jobs, meta = collect_search_pages(keyword, args.refresh, args.max_pages)
        search_leads.extend(jobs)
        pagination_meta.append(meta)

    merged = merge_leads(search_leads)
    relevant = [
        lead
        for lead in merged
        if lead.city == "杭州" and is_target_relevant(lead)
    ]
    relevant = sorted(relevant, key=lambda lead: (lead.area, lead.job_name, lead.company))

    detail_records: list[JobDetailRecord] = []
    for lead in relevant:
        try:
            payload = load_or_collect_detail(lead, refresh=args.refresh)
            detail_records.append(extract_detail_record(lead, payload))
        except Exception:
            continue

    filtered_records = [record for record in detail_records if is_detail_relevant(record)]
    filtered_records = sorted(filtered_records, key=lambda record: (record.area_district, record.business_district, record.job_name, record.company))
    write_full_exports(filtered_records)
    report_markdown, summary = render_report(relevant, filtered_records, len(detail_records), pagination_meta, args.max_pages)
    REPORT_PATH.write_text(report_markdown, encoding="utf-8")
    SUMMARY_PATH.write_text(json.dumps(summary, ensure_ascii=False, indent=2), encoding="utf-8")
    print(json.dumps(summary, ensure_ascii=False, indent=2))
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
