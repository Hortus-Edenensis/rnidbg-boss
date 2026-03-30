#!/usr/bin/env python3
from __future__ import annotations

import argparse
import csv
import json
import os
import re
import statistics
import subprocess
import sys
from collections import Counter, defaultdict
from dataclasses import dataclass, field
from datetime import datetime
from pathlib import Path
from textwrap import fill


REPO_ROOT = Path(__file__).resolve().parents[2]
TMP_ROOT = Path("/tmp/yiwu-crossborder")
SEARCH_DIR = TMP_ROOT / "search"
DETAIL_DIR = TMP_ROOT / "detail"
META_DIR = TMP_ROOT / "meta"

REPORT_PATH = REPO_ROOT / "docs" / "yiwu-crossborder-ecommerce-jobdetail-report.md"
RESUME_DIR = REPO_ROOT / "output" / "resume"
RESUME_MD_PATH = RESUME_DIR / "yujunde-yiwu-crossborder-resume.md"
RESUME_DOCX_PATH = RESUME_DIR / "yujunde-yiwu-crossborder-resume.docx"
RESUME_PDF_PATH = RESUME_DIR / "yujunde-yiwu-crossborder-resume.pdf"

CONTAINER = "rnidbg-gt3-web"
CONTAINER_CLI = "/workspace/rnidbg/scripts/run-boss-yzwg.sh"
SESSION_PATH = "/workspace/lab-assets/.boss_purecalc/session.json"
CITY_CODE = "101210900"
PAGE_SIZE = "20"
PAGES = (1, 2, 3)
SORT_TYPE = "1"

SEARCH_KEYWORDS = [
    "跨境电商运营",
    "跨境运营助理",
    "亚马逊运营",
    "TikTok Shop运营",
    "海外社媒运营",
    "Temu运营",
    "阿里国际站运营",
    "独立站运营",
]

CLUSTER_LABELS = {
    "platform_ops": "平台运营",
    "overseas_social": "海外社媒",
    "standalone_ads": "独立站与站外投流",
    "supply_chain": "选品与供应链协同",
    "assistant_general": "跨境运营助理/综合岗",
}

PLATFORM_KEYWORDS = [
    "amazon",
    "temu",
    "tiktok",
    "tiktok shop",
    "阿里国际站",
    "国际站",
    "ebay",
    "shopify",
    "独立站",
    "linkedin",
    "facebook",
    "whatsapp",
    "lazada",
    "shopee",
]

TOOL_KEYWORDS = [
    "excel",
    "erp",
    "ps",
    "ai",
    "剪映",
    "photoshop",
    "canva",
    "meta",
    "google ads",
    "投流",
    "广告投放",
    "广告",
]

HISTORY_CSV = Path(
    "/Users/haojiejack/github/drizzle-dumper-rust/boss_purecalc/analysis/"
    "2026-02-24-zhejiang-crawler-cyber-rerun/report/granular_detail/crawler_granular_all.csv"
)


@dataclass
class JobLead:
    source: str
    keyword: str
    page: int
    sort_type: str | None
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
    job_desc: str
    required_skills: list[str]
    position_category: str
    cluster: str
    platforms: list[str]
    tools: list[str]
    trade_tags: list[str]
    english_requirement: str
    match_level: str
    match_reasons: list[str]
    raw: dict = field(default_factory=dict)

    def district_key(self) -> str:
        return self.area_district or "未标注区县"


def parse_args() -> argparse.Namespace:
    parser = argparse.ArgumentParser()
    parser.add_argument("--refresh", action="store_true")
    parser.add_argument("--skip-export", action="store_true")
    return parser.parse_args()


def ensure_dirs() -> None:
    for path in [SEARCH_DIR, DETAIL_DIR, META_DIR, REPORT_PATH.parent, RESUME_DIR]:
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


def recursive_job_extract(node, out: list[dict]) -> None:
    if isinstance(node, dict):
        keys = set(node)
        if (
            ("securityId" in keys or "encryptJobId" in keys or "encryptId" in keys)
            and ("jobName" in keys or "positionName" in keys)
            and (
                "city" in keys
                or "cityName" in keys
                or "areaDistrict" in keys
                or "brandName" in keys
                or "company" in keys
            )
        ):
            out.append(node)
        for value in node.values():
            recursive_job_extract(value, out)
    elif isinstance(node, list):
        for value in node:
            recursive_job_extract(value, out)


def extract_jobs(payload: dict, source: str, keyword: str, page: int, sort_type: str | None) -> list[JobLead]:
    raw_hits: list[dict] = []
    recursive_job_extract(payload.get("response", {}), raw_hits)
    jobs: list[JobLead] = []
    seen = set()
    for item in raw_hits:
        security_id = coerce_text(
            item.get("securityId")
            or item.get("encryptJobId")
            or item.get("encryptId")
        )
        job_name = coerce_text(item.get("jobName") or item.get("positionName"))
        company = coerce_text(item.get("brandName") or item.get("company") or item.get("comName"))
        city = coerce_text(item.get("cityName") or item.get("city") or item.get("locationName"))
        area = coerce_text(item.get("areaDistrict"))
        if not (job_name and company and security_id):
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
                source=source,
                keyword=keyword,
                page=page,
                sort_type=sort_type,
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
                source_hits=[f"{source}:{keyword or f'sort{sort_type}'}:p{page}"],
            )
        )
    return jobs


def is_crossborder_relevant(lead: JobLead) -> bool:
    text = "|".join(
        [
            lead.job_name,
            lead.company,
            lead.city,
            lead.area,
            "|".join(lead.labels),
            lead.keyword,
        ]
    ).lower()
    needles = [
        "跨境",
        "亚马逊",
        "amazon",
        "temu",
        "tiktok",
        "shop",
        "国际站",
        "阿里国际站",
        "独立站",
        "海外",
        "社媒",
        "外贸",
        "电商",
    ]
    return any(needle in text for needle in needles)


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


def choose_live_scope(merged: list[JobLead]) -> tuple[list[JobLead], list[JobLead], list[JobLead]]:
    relevant_jinhua = [
        lead
        for lead in merged
        if lead.city == "金华" and is_crossborder_relevant(lead)
    ]
    yiwu_primary = [lead for lead in relevant_jinhua if lead.area == "义乌市"]
    district_supplement = [
        lead for lead in relevant_jinhua if lead.area and lead.area != "义乌市"
    ]
    other_excluded = [
        lead
        for lead in merged
        if lead.city != "金华" or not is_crossborder_relevant(lead)
    ]
    return yiwu_primary, district_supplement, other_excluded


def select_representative_leads(yiwu_primary: list[JobLead], district_supplement: list[JobLead]) -> list[JobLead]:
    selected: dict[tuple[str, str, str], JobLead] = {}

    def add_bucket(leads: list[JobLead], limit: int) -> None:
        count = 0
        for lead in sorted(
            leads,
            key=lambda item: (-len(item.source_hits), item.job_name, item.company),
        ):
            key = lead.dedupe_key()
            if key in selected:
                continue
            selected[key] = lead
            count += 1
            if count >= limit:
                break

    for keyword in SEARCH_KEYWORDS:
        bucket = [
            lead
            for lead in yiwu_primary
            if any(hit.startswith(f"search:{keyword}:") for hit in lead.source_hits)
        ]
        add_bucket(bucket, limit=4)

    for page in PAGES:
        bucket = [
            lead
            for lead in yiwu_primary
            if any(hit.startswith(f"recommend:sort{SORT_TYPE}:p{page}") for hit in lead.source_hits)
        ]
        add_bucket(bucket, limit=3)

    by_area: dict[str, list[JobLead]] = defaultdict(list)
    for lead in district_supplement:
        by_area[lead.area or "未标注区县"].append(lead)
    for area in sorted(by_area):
        add_bucket(by_area[area], limit=2)

    if len(selected) < 46:
        remaining = [lead for lead in yiwu_primary if lead.dedupe_key() not in selected]
        add_bucket(remaining, limit=46 - len(selected))
    return list(selected.values())


def detail_cache_path(lead: JobLead) -> Path:
    filename = f"{slugify(lead.area or 'no-area')}__{slugify(lead.company)}__{slugify(lead.job_name)}.json"
    return DETAIL_DIR / filename


def load_or_collect_detail(lead: JobLead, refresh: bool) -> dict:
    path = detail_cache_path(lead)
    args = ["job-detail", lead.security_id]
    return load_or_collect_json(path, args, refresh)


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
    skills = [coerce_text(item) for item in (job_base.get("requiredSkills") or [])]
    combined_text = "|".join(
        [
            coerce_text(job_base.get("positionName") or lead.job_name),
            job_desc,
            "|".join(skills),
            lead.job_name,
            "|".join(lead.labels),
        ]
    )
    cluster = classify_cluster(combined_text)
    platforms = sorted(set(find_keywords(combined_text, PLATFORM_KEYWORDS)))
    tools = sorted(set(find_keywords(combined_text, TOOL_KEYWORDS)))
    trade_tags = sorted(set(find_keywords(combined_text, ["外贸", "b2b", "b2c", "询盘", "选品", "备货", "工厂", "供应链"])))
    match_level, match_reasons = assess_resume_match(
        experience=coerce_text(job_base.get("experienceName") or lead.experience),
        degree=coerce_text(job_base.get("degreeName") or lead.degree),
        combined_text=combined_text,
        cluster=cluster,
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
        job_desc=job_desc,
        required_skills=skills,
        position_category=coerce_text(job_base.get("positionCategory")),
        cluster=cluster,
        platforms=platforms,
        tools=tools,
        trade_tags=trade_tags,
        english_requirement=english_requirement_label(combined_text),
        match_level=match_level,
        match_reasons=match_reasons,
        raw=payload,
    )


def classify_cluster(text: str) -> str:
    lowered = text.lower()
    if any(token in lowered for token in ["独立站", "shopify", "google ads", "meta", "广告投放", "投流", "站外"]):
        return "standalone_ads"
    if any(token in lowered for token in ["tiktok", "linkedin", "facebook", "whatsapp", "社媒", "短视频", "内容策划", "矩阵营销"]):
        return "overseas_social"
    if any(token in lowered for token in ["amazon", "亚马逊", "temu", "国际站", "阿里国际站", "lazada", "shopee", "ebay"]):
        return "platform_ops"
    if any(token in lowered for token in ["供应链", "选品", "备货", "打样", "采购", "工厂", "成分参数", "家纺", "面料", "询盘"]):
        return "supply_chain"
    return "assistant_general"


def find_keywords(text: str, candidates: list[str]) -> list[str]:
    lowered = text.lower()
    return [item for item in candidates if item.lower() in lowered]


def english_requirement_label(text: str) -> str:
    lowered = text.lower()
    if any(token in lowered for token in ["英语读写流利", "英文文案", "英文私信", "英语", "小语种"]):
        return "明确要求"
    if any(token in lowered for token in ["外贸", "海外", "b2b", "b2c"]):
        return "可能需要"
    return "未显式要求"


def assess_resume_match(experience: str, degree: str, combined_text: str, cluster: str) -> tuple[str, list[str]]:
    score = 55
    reasons = [
        "已有 1 年+ 电商运营结果证据，可支撑基础运营面试。",
        "国际经济与贸易 + 跨境电商课程背景，对跨境岗位有可迁移叙事。",
    ]
    lowered = combined_text.lower()
    if "1-3年" in experience or "经验不限" in experience or "1年以内" in experience:
        score += 10
    if "3-5年" in experience or "5-10年" in experience:
        score -= 12
        reasons.append("JD 经验门槛偏高，当前简历年限会吃亏。")
    if degree in {"大专", "本科", "学历不限", "经验不限"}:
        score += 4
    if any(token in lowered for token in ["英语读写流利", "英文文案", "小语种", "whatsapp"]):
        score -= 12
        reasons.append("英语/外贸沟通要求明确，但简历里还没有可验证证据。")
    if cluster == "assistant_general":
        score += 8
        reasons.append("综合助理岗更看执行和数据复盘，和现有经历更贴近。")
    if cluster == "platform_ops":
        score -= 4
        reasons.append("平台经验方向匹配，但缺少已验证的 Amazon/Temu/国际站平台标签。")
    if cluster == "overseas_social":
        score -= 6
        reasons.append("社媒岗对英文内容、剪辑和平台规则要求更细，简历需留待补。")
    if cluster == "standalone_ads":
        score -= 8
        reasons.append("独立站/站外投流往往要求广告平台经验，当前简历没有实锤。")
    if cluster == "supply_chain":
        score -= 2
        reasons.append("供应链协同可从库存和备货结果切入，但类目/工厂经验还没补齐。")
    if score >= 62:
        level = "中等偏高"
    elif score >= 48:
        level = "中等"
    else:
        level = "偏低"
    return level, dedupe_preserve(reasons)


def dedupe_preserve(items: list[str]) -> list[str]:
    out = []
    seen = set()
    for item in items:
        if item not in seen:
            seen.add(item)
            out.append(item)
    return out


def salary_bounds(text: str) -> tuple[float | None, float | None]:
    salary = coerce_text(text)
    match = re.search(r"(\d+(?:\.\d+)?)\s*-\s*(\d+(?:\.\d+)?)\s*K", salary, re.IGNORECASE)
    if match:
        return float(match.group(1)), float(match.group(2))
    match = re.search(r"(\d+(?:\.\d+)?)\s*K", salary, re.IGNORECASE)
    if match:
        value = float(match.group(1))
        return value, value
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


def summarize_districts(records: list[JobDetailRecord]) -> dict[str, list[JobDetailRecord]]:
    grouped: dict[str, list[JobDetailRecord]] = defaultdict(list)
    for record in records:
        grouped[record.district_key()].append(record)
    return dict(sorted(grouped.items(), key=lambda item: (-len(item[1]), item[0])))


def representative_records(records: list[JobDetailRecord], limit: int = 3) -> list[JobDetailRecord]:
    def sort_key(record: JobDetailRecord):
        low, high = salary_bounds(record.salary_desc)
        return (-(high or 0), -(low or 0), record.company, record.job_name)

    return sorted(records, key=sort_key)[:limit]


def jd_brief(record: JobDetailRecord) -> str:
    clauses = re.split(r"[\n。；;]+", record.job_desc)
    cleaned = [clause.strip(" -") for clause in clauses if clause.strip()]
    return "；".join(cleaned[:2]) or "JD 未返回可读摘要。"


def load_history_rows() -> list[dict]:
    if not HISTORY_CSV.exists():
        return []
    rows = []
    with HISTORY_CSV.open(newline="", encoding="utf-8") as handle:
        reader = csv.DictReader(handle)
        for row in reader:
            text = "|".join(
                [
                    row.get("job_name", ""),
                    row.get("company", ""),
                    row.get("labels", ""),
                ]
            ).lower()
            if row.get("city_name") != "金华":
                continue
            if not any(token in text for token in ["跨境", "亚马逊", "temu", "tiktok", "国际站", "独立站", "海外", "社媒", "电商"]):
                continue
            rows.append(row)
    return rows


def top_history_samples(rows: list[dict], limit: int = 8) -> list[dict]:
    def sort_key(row: dict):
        low, high = salary_bounds(row.get("salary", ""))
        return (-(high or 0), -(low or 0), row.get("area", ""), row.get("job_name", ""))

    return sorted(rows, key=sort_key)[:limit]


def render_report(
    search_leads: list[JobLead],
    recommend_leads: list[JobLead],
    yiwu_primary: list[JobLead],
    district_supplement: list[JobLead],
    excluded: list[JobLead],
    detail_records: list[JobDetailRecord],
    history_rows: list[dict],
) -> str:
    now = datetime.now().strftime("%Y-%m-%d %H:%M:%S %z")
    district_groups = summarize_districts(detail_records)
    cluster_groups: dict[str, list[JobDetailRecord]] = defaultdict(list)
    for record in detail_records:
        cluster_groups[record.cluster].append(record)
    lines = [
        "# 义乌跨境电商岗位细颗粒度报告",
        "",
        f"- 生成时间：`{now}`",
        f"- 运行入口：`search + recommend + job-detail`",
        f"- 城市码：`{CITY_CODE}`（live 验证对应金华；`101191100` 会误落常州，已弃用）",
        f"- 主样本范围：`义乌市`；补充区县：`{'、'.join(sorted(set(lead.area for lead in district_supplement if lead.area))) or '无'}`",
        "",
        "## 结论先看",
        "",
        f"- `search` 原始命中：`{len(search_leads)}`，`recommend` 原始命中：`{len(recommend_leads)}`。",
        f"- 代表性 live JD 回填样本：`{len(detail_records)}`。",
        f"- 去重后金华跨境相关岗位：`{len(yiwu_primary) + len(district_supplement)}`，其中义乌主样本：`{len(yiwu_primary)}`。",
        f"- 已拉回 `job-detail` 的 live JD：`{len(detail_records)}`。",
        f"- 被剔除的异地或非跨境样本：`{len(excluded)}`。",
        "- 当前 session 下 `recommend` 1-3 页返回空池，已完成接口验证，但主样本实际由 `search + job-detail` 构成。",
        "- 当前 live 结果已足够支撑义乌主样本；历史资产只作为本地画像补充，不冒充实时 JD。",
        "",
        "## 采样方法",
        "",
        "- 使用本项目容器内 `run-boss-yzwg.sh search` 跑 8 个跨境关键词，每个关键词抓 1-3 页。",
        "- 使用本项目容器内 `run-boss-yzwg.sh recommend` 抓 1-3 页推荐流做并行验证；当前 session 返回空池，因此未成为有效样本来源。",
        "- 对代表性样本逐条调用本项目 `job-detail` 接口回填 JD、技能、区县和业务片区，保证关键词、推荐页和区县都有覆盖。",
        "- 主过滤规则：`city == 金华` 且岗位文本含跨境关键词；义乌市作为主样本，其他区县单独列为补充观察。",
        "",
        "## 区县细颗粒度拆解",
        "",
    ]
    for district, records in district_groups.items():
        areas = Counter(record.business_district for record in records if record.business_district)
        clusters = Counter(CLUSTER_LABELS[record.cluster] for record in records)
        lines.extend(
            [
                f"### {district}",
                "",
                f"- live JD 数：`{len(records)}`",
                f"- 薪资区间：`{salary_range_desc(records)}`",
                f"- 热门业务片区：`{'、'.join(name for name, _ in areas.most_common(4)) or '未标注'}`",
                f"- 岗位簇：`{'、'.join(f'{name} {count}' for name, count in clusters.most_common())}`",
                "",
            ]
        )
        for record in representative_records(records):
            lines.append(
                f"- {record.job_name}｜{record.company}｜`{record.salary_desc or '未标注薪资'}`｜{record.location_desc or district}"
            )
            lines.append(
                f"  - 核心点：{jd_brief(record)}"
            )
            lines.append(
                f"  - 平台/工具：`{'、'.join(record.platforms) or '待从 JD 补充'}` / `{'、'.join(record.tools) or '未显式写出'}`"
            )
            lines.append(
                f"  - 匹配度：`{record.match_level}`；原因：{'；'.join(record.match_reasons[:2])}"
            )
        lines.append("")

    lines.extend(
        [
            "## 岗位簇归纳",
            "",
        ]
    )
    for cluster, title in CLUSTER_LABELS.items():
        records = cluster_groups.get(cluster, [])
        if not records:
            continue
        exp = Counter(record.experience_name for record in records if record.experience_name).most_common(3)
        deg = Counter(record.degree_name for record in records if record.degree_name).most_common(3)
        platforms = Counter(platform for record in records for platform in record.platforms).most_common(5)
        tools = Counter(tool for record in records for tool in record.tools).most_common(5)
        english = Counter(record.english_requirement for record in records).most_common()
        match = Counter(record.match_level for record in records).most_common()
        lines.extend(
            [
                f"### {title}",
                "",
                f"- 样本数：`{len(records)}`",
                f"- 薪资区间：`{salary_range_desc(records)}`",
                f"- 经验门槛：`{'、'.join(f'{name} {count}' for name, count in exp) or '未统计'}`",
                f"- 学历门槛：`{'、'.join(f'{name} {count}' for name, count in deg) or '未统计'}`",
                f"- 核心平台：`{'、'.join(name for name, _ in platforms) or '未显式写出'}`",
                f"- 核心工具：`{'、'.join(name for name, _ in tools) or '未显式写出'}`",
                f"- 英语/外贸要求：`{'、'.join(f'{name} {count}' for name, count in english) or '未统计'}`",
                f"- 与简历匹配度：`{'、'.join(f'{name} {count}' for name, count in match)}`",
                "",
            ]
        )
        for record in representative_records(records, limit=2):
            lines.append(
                f"- 代表 JD：{record.job_name}｜{record.company}｜`{record.salary_desc}`｜`{record.area_district or '未标注区县'}`"
            )
            lines.append(f"  - 摘要：{jd_brief(record)}")
        lines.append("")

    lines.extend(
        [
            "## 历史本地画像补充",
            "",
            "- 以下样本来自 2026-02-24 义乌/金华历史快照，只作为本地赛道画像补充，不视为实时 JD。",
            "",
        ]
    )
    for row in top_history_samples(history_rows):
        lines.append(
            f"- {row.get('job_name')}｜{row.get('company')}｜`{row.get('salary')}`｜{row.get('area') or '未标注区县'}｜标签：`{row.get('labels') or '无'}`"
        )
    lines.extend(
        [
            "",
            "## 简历改写落点",
            "",
            "- 简历应优先覆盖：`义乌本地`、`国际贸易/跨境课程背景`、`ROI 1:4+`、`3 个月 3 个爆款`、`销量 4000+`、`清仓 70%`。",
            "- 暂不编造 Amazon/Temu/国际站/TikTok 实操，只能写成 `[待补平台]`、`[待补工具]`、`[待补英语/外贸沟通]`。",
            "- 若目标聚焦义乌平台运营岗，先投 `跨境运营助理/综合岗` 和 `平台运营`；若补齐英文内容和剪辑能力，再冲 `海外社媒` 和 `独立站投流`。",
            "",
            "## 附录：剔除规则",
            "",
            f"- 异地样本剔除数量：`{len([lead for lead in excluded if lead.city and lead.city != '金华'])}`",
            f"- 非跨境关键词剔除数量：`{len([lead for lead in excluded if lead.city == '金华'])}`",
            "- `recommend` 结果也需要额外关键词过滤，不能直接按区县全收。",
            "",
        ]
    )
    return "\n".join(lines)


def render_resume_markdown() -> str:
    lines = [
        "# 余军德｜义乌跨境电商运营简历",
        "",
        "- 地点：浙江义乌",
        "- 电话：15200373650",
        "- 邮箱：1626155399@qq.com",
        "- 求职方向：跨境电商运营 / 平台运营 / 跨境运营助理",
        "",
        "## 求职摘要",
        "",
        "- 1 年+ 电商运营经验，常驻义乌，教育背景为常州信息职业技术学院 `国际经济与贸易` 专业。",
        "- 原简历可直接验证的电商动作包括：`选品上架`、`标题优化`、`类目匹配`、`详情页策划`、`店铺装修`、`活动配置`、`优惠满减`、`搜索/推荐/直通车`、`大促/秒杀/直播联动`、`短视频图文种草`、`社群达人合作`、`周/月报表复盘`。",
        "- 已验证结果包括：`店铺评分 4.7+`、`转化提升 20%`、`推广 ROI 1:4+`、`3 个爆款`、`销量 4000+`、`库存清仓 70%`。",
        "- 本版只写义乌全量 JD 高频要求中可被原简历证实的部分；`跨境平台`、`类目`、`英语/外贸沟通`、`Excel/PS/ERP/剪映` 等细节继续保留为 `[待补]`。",
        "",
        "## 与义乌 JD 的直接匹配点",
        "",
        "- 能承接义乌高频 JD 中最常出现的执行动作：`选品`、`上架`、`标题优化`、`详情页策划`、`活动配置`、`优惠设置`。",
        "- 能承接义乌高频 JD 中最常出现的数据动作：围绕 `访客量`、`点击率`、`转化率`、`客单价`、`UV 价值` 做分析、报表复盘和问题定位。",
        "- 能承接义乌高频 JD 中常见的经营协同动作：跟踪商品数据，参与定价营销策略，配合库存与清仓节奏推进执行。",
        "- 暂不冒写 `Temu`、`TikTok`、`Amazon`、`国际站`、`独立站`、英文客服或广告后台实操经验。",
        "",
        "## 能力矩阵",
        "",
        "| 模块 | 已验证事实 | 对应义乌 JD 高频词 |",
        "| --- | --- | --- |",
        "| 店铺执行 | 选品上架、标题优化、类目匹配、详情页策划、店铺装修、活动配置、优惠满减设置 | 选品、上架、标题、详情页、活动策划 |",
        "| 流量运营 | 搜索、推荐、直通车；大促、频道活动、平台秒杀、直播联动；短视频图文种草、社群达人合作 | 流量获取、活动运营、基础推广 |",
        "| 数据复盘 | 关注访客量、点击率、转化率、客单价、UV 价值；能对流量下滑、转化低、投产差做具体报告分析 | 数据分析、报表复盘、转化优化 |",
        "| 结果证明 | 店铺评分 `4.7+`、转化提升 `20%`、推广 ROI `1:4+`、`3` 个爆款、销量 `4000+`、清仓 `70%` | 结果导向、经营效率、库存协同 |",
        "| 待补项 | `[待补平台]`、`[待补类目]`、`[待补工具]`、`[待补英语/外贸]` | Temu/TikTok/Amazon/国际站、Excel/PS/ERP、英语读写 |",
        "",
        "## 工作经历",
        "",
        "### 鄞州火炬创新节能环保科技有限公司｜电商运营｜2024/06 - 2025/12",
        "",
        "- 优化产品详情、案例展示和店铺资质背书，增加客户信任，稳定店铺评分 `4.7+`。",
        "- 优化关键词和落地页，提升排名和店铺流量，带动询盘增加并有效提升转化 `20%`；同时显著降低获客成本，使推广 ROI 稳定在 `1:4+`。",
        "- 借助分析工具对商品进行优化调整，提升点击和转化，成功打造 `3` 个爆款，累计销量 `4000+`。",
        "- 跟踪商品数据并参与定价营销策略，配合经营节奏推进清仓，使库存清仓达到 `70%`。",
        "",
        "## 教育经历",
        "",
        "### 常州信息职业技术学院｜国际经济与贸易｜2021/09 - 2024/06",
        "",
        "- 原简历列出的主修课程包括：`国际贸易实务`、`跨境电商实务`、`市场营销`、`外贸函电` 等。",
        "- 多次负责 `200` 人规模社团数据登记整理，并协同优化登记流程、简化步骤，后续效率提升一半以上，数据准确率达 `99%`。",
        "- 上述课程与校内经历可迁移到义乌 JD 高频要求中的数据整理、流程执行和跨境电商基础认知。",
        "",
        "## 待补信息清单",
        "",
        "- `[待补平台]`：实际接触过的平台是否包含 `Temu`、`TikTok Shop`、`Amazon`、`阿里国际站`、`Shopee`、`独立站`。",
        "- `[待补类目]`：真实经营类目，如饰品、家居百货、服装、杯壶、节庆用品等。",
        "- `[待补经营数据]`：月 GMV、客单价、广告花费、退货率、复购率、库存周转周期。",
        "- `[待补工具]`：`Excel` 函数、`PS/AI`、`ERP`、`剪映`、数据看板、广告后台。",
        "- `[待补跨境能力]`：英语读写、英文客服、外贸询盘、备货/打样/物流协同经验。",
        "",
    ]
    return "\n".join(lines)


def write_text(path: Path, content: str) -> None:
    path.parent.mkdir(parents=True, exist_ok=True)
    path.write_text(content, encoding="utf-8")


def export_resume_docx(markdown_text: str) -> str:
    try:
        from docx import Document
        from docx.shared import Pt
    except Exception as exc:  # pragma: no cover
        return f"skip docx export: {exc}"
    document = Document()
    style = document.styles["Normal"]
    style.font.name = "PingFang SC"
    style.font.size = Pt(10.5)
    for raw_line in markdown_text.splitlines():
        line = raw_line.rstrip()
        if not line:
            document.add_paragraph("")
            continue
        if line.startswith("# "):
            document.add_heading(line[2:], level=1)
        elif line.startswith("## "):
            document.add_heading(line[3:], level=2)
        elif line.startswith("### "):
            document.add_heading(line[4:], level=3)
        elif line.startswith("- "):
            document.add_paragraph(line[2:], style="List Bullet")
        elif line.startswith("|"):
            # Keep markdown table rows as plain paragraphs for simplicity.
            document.add_paragraph(line)
        else:
            document.add_paragraph(line)
    document.save(RESUME_DOCX_PATH)
    return "ok"


def export_resume_pdf(markdown_text: str) -> str:
    try:
        from reportlab.lib import colors
        from reportlab.lib.enums import TA_LEFT
        from reportlab.lib.pagesizes import A4
        from reportlab.lib.styles import ParagraphStyle, getSampleStyleSheet
        from reportlab.lib.units import mm
        from reportlab.pdfbase.cidfonts import UnicodeCIDFont
        from reportlab.pdfbase.pdfmetrics import registerFont
        from reportlab.platypus import Paragraph, SimpleDocTemplate, Spacer, Table, TableStyle
    except Exception as exc:  # pragma: no cover
        return f"skip pdf export: {exc}"

    registerFont(UnicodeCIDFont("STSong-Light"))
    styles = getSampleStyleSheet()
    normal = ParagraphStyle(
        "ResumeNormal",
        parent=styles["Normal"],
        fontName="STSong-Light",
        fontSize=10,
        leading=14,
        alignment=TA_LEFT,
    )
    heading1 = ParagraphStyle("H1", parent=styles["Heading1"], fontName="STSong-Light", fontSize=16, leading=22)
    heading2 = ParagraphStyle("H2", parent=styles["Heading2"], fontName="STSong-Light", fontSize=13, leading=18)
    heading3 = ParagraphStyle("H3", parent=styles["Heading3"], fontName="STSong-Light", fontSize=11.5, leading=16)
    story = []
    in_table = False
    table_rows: list[list[str]] = []

    def flush_table():
        nonlocal in_table, table_rows
        if not table_rows:
            return
        table = Table(table_rows, colWidths=[32 * mm, 138 * mm])
        table.setStyle(
            TableStyle(
                [
                    ("FONTNAME", (0, 0), (-1, -1), "STSong-Light"),
                    ("FONTSIZE", (0, 0), (-1, -1), 9),
                    ("GRID", (0, 0), (-1, -1), 0.3, colors.grey),
                    ("BACKGROUND", (0, 0), (-1, 0), colors.HexColor("#F3F4F6")),
                    ("VALIGN", (0, 0), (-1, -1), "TOP"),
                    ("LEFTPADDING", (0, 0), (-1, -1), 6),
                    ("RIGHTPADDING", (0, 0), (-1, -1), 6),
                ]
            )
        )
        story.append(table)
        story.append(Spacer(1, 6))
        in_table = False
        table_rows = []

    for raw_line in markdown_text.splitlines():
        line = raw_line.rstrip()
        if line.startswith("|"):
            cells = [cell.strip() for cell in line.strip("|").split("|")]
            if set(cells) == {"---"} or cells == ["---", "---"]:
                continue
            in_table = True
            table_rows.append(cells)
            continue
        if in_table:
            flush_table()
        if not line:
            story.append(Spacer(1, 6))
            continue
        if line.startswith("# "):
            story.append(Paragraph(line[2:], heading1))
        elif line.startswith("## "):
            story.append(Paragraph(line[3:], heading2))
        elif line.startswith("### "):
            story.append(Paragraph(line[4:], heading3))
        elif line.startswith("- "):
            story.append(Paragraph(f"• {line[2:]}", normal))
        else:
            story.append(Paragraph(line, normal))
    if in_table:
        flush_table()
    doc = SimpleDocTemplate(
        str(RESUME_PDF_PATH),
        pagesize=A4,
        leftMargin=16 * mm,
        rightMargin=16 * mm,
        topMargin=14 * mm,
        bottomMargin=14 * mm,
    )
    doc.build(story)
    return "ok"


def verify_pdf_text() -> str:
    try:
        from pypdf import PdfReader
    except Exception as exc:  # pragma: no cover
        return f"skip pdf verify: {exc}"
    if not RESUME_PDF_PATH.exists():
        return "skip pdf verify: missing file"
    reader = PdfReader(str(RESUME_PDF_PATH))
    text = "\n".join(page.extract_text() or "" for page in reader.pages).strip()
    return "ok" if text else "warning: pdf text extraction empty"


def write_metadata(detail_records: list[JobDetailRecord], yiwu_primary: list[JobLead], district_supplement: list[JobLead], excluded: list[JobLead]) -> None:
    payload = {
        "generated_at": datetime.now().isoformat(),
        "city_code": CITY_CODE,
        "yiwu_primary_count": len(yiwu_primary),
        "district_supplement_count": len(district_supplement),
        "detail_count": len(detail_records),
        "district_counts": Counter(record.district_key() for record in detail_records),
        "cluster_counts": Counter(record.cluster for record in detail_records),
        "excluded_count": len(excluded),
        "report_path": str(REPORT_PATH),
        "resume_md_path": str(RESUME_MD_PATH),
        "resume_docx_path": str(RESUME_DOCX_PATH),
        "resume_pdf_path": str(RESUME_PDF_PATH),
    }
    (META_DIR / "summary.json").write_text(
        json.dumps(payload, ensure_ascii=False, indent=2),
        encoding="utf-8",
    )


def main() -> int:
    args = parse_args()
    ensure_dirs()

    search_payloads = []
    recommend_payloads = []

    for keyword in SEARCH_KEYWORDS:
        for page in PAGES:
            cache_path = SEARCH_DIR / f"search__{slugify(keyword)}__p{page}.json"
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

    for page in PAGES:
        cache_path = SEARCH_DIR / f"recommend__sort{SORT_TYPE}__p{page}.json"
        payload = load_or_collect_json(
            cache_path,
            [
                "recommend",
                "--city",
                CITY_CODE,
                "--page",
                str(page),
                "--page-size",
                PAGE_SIZE,
                "--sort-type",
                SORT_TYPE,
            ],
            args.refresh,
        )
        recommend_payloads.append((page, payload))

    search_leads = [
        lead
        for keyword, page, payload in search_payloads
        for lead in extract_jobs(payload, "search", keyword, page, None)
    ]
    recommend_leads = [
        lead
        for page, payload in recommend_payloads
        for lead in extract_jobs(payload, "recommend", "", page, SORT_TYPE)
    ]

    merged = merge_leads(search_leads + recommend_leads)
    yiwu_primary, district_supplement, excluded = choose_live_scope(merged)
    selected = select_representative_leads(yiwu_primary, district_supplement)

    detail_records: list[JobDetailRecord] = []
    for lead in selected:
        payload = load_or_collect_detail(lead, args.refresh)
        detail_records.append(extract_detail_record(lead, payload))

    history_rows = load_history_rows()
    report_text = render_report(
        search_leads=search_leads,
        recommend_leads=recommend_leads,
        yiwu_primary=yiwu_primary,
        district_supplement=district_supplement,
        excluded=excluded,
        detail_records=detail_records,
        history_rows=history_rows,
    )
    resume_markdown = render_resume_markdown()

    write_text(REPORT_PATH, report_text)
    write_text(RESUME_MD_PATH, resume_markdown)

    export_status = {"docx": "skipped", "pdf": "skipped", "pdf_verify": "skipped"}
    if not args.skip_export:
        export_status["docx"] = export_resume_docx(resume_markdown)
        export_status["pdf"] = export_resume_pdf(resume_markdown)
        export_status["pdf_verify"] = verify_pdf_text()

    write_metadata(detail_records, yiwu_primary, district_supplement, excluded)

    print(json.dumps(
        {
            "search_raw": len(search_leads),
            "recommend_raw": len(recommend_leads),
            "yiwu_primary": len(yiwu_primary),
            "district_supplement": len(district_supplement),
            "detail_records": len(detail_records),
            "report_path": str(REPORT_PATH),
            "resume_md_path": str(RESUME_MD_PATH),
            "resume_docx_path": str(RESUME_DOCX_PATH),
            "resume_pdf_path": str(RESUME_PDF_PATH),
            "export_status": export_status,
        },
        ensure_ascii=False,
        indent=2,
    ))
    return 0


if __name__ == "__main__":
    sys.exit(main())
