#!/usr/bin/env python3
from __future__ import annotations

import argparse
import csv
import importlib.util
import json
import sys
from collections import Counter, defaultdict
from pathlib import Path


SCRIPT_DIR = Path(__file__).resolve().parent
MODULE_PATH = SCRIPT_DIR / "generate_assets.py"

spec = importlib.util.spec_from_file_location("yiwu_assets", MODULE_PATH)
if spec is None or spec.loader is None:
    raise RuntimeError(f"failed to load module: {MODULE_PATH}")
ga = importlib.util.module_from_spec(spec)
sys.modules[spec.name] = ga
spec.loader.exec_module(ga)


FULL_JSON_PATH = ga.TMP_ROOT / "yiwu-full-jd.json"
FULL_CSV_PATH = ga.TMP_ROOT / "yiwu-full-jd.csv"
FULL_META_PATH = ga.META_DIR / "yiwu-full-jd-summary.json"
FULL_REPORT_PATH = ga.REPO_ROOT / "docs" / "yiwu-crossborder-full-jd-analysis.md"

SIGNAL_KEYWORDS = [
    "选品",
    "上架",
    "标题",
    "详情页",
    "数据分析",
    "供应链",
    "库存",
    "备货",
    "广告投放",
    "社媒",
    "短视频",
    "英语",
    "ERP",
    "Excel",
    "PS",
    "剪映",
    "客服",
]


def parse_args() -> argparse.Namespace:
    parser = argparse.ArgumentParser()
    parser.add_argument("--refresh", action="store_true")
    parser.add_argument("--skip-export", action="store_true")
    return parser.parse_args()


def top_pairs(counter: Counter, limit: int = 10) -> str:
    pairs = counter.most_common(limit)
    return "、".join(f"{name} {count}" for name, count in pairs) or "未统计"


def collect_payloads(refresh: bool) -> tuple[list[tuple[str, int, dict]], list[tuple[int, dict]]]:
    search_payloads: list[tuple[str, int, dict]] = []
    recommend_payloads: list[tuple[int, dict]] = []
    for keyword in ga.SEARCH_KEYWORDS:
        for page in ga.PAGES:
            cache_path = ga.SEARCH_DIR / f"search__{ga.slugify(keyword)}__p{page}.json"
            payload = ga.load_or_collect_json(
                cache_path,
                [
                    "search",
                    keyword,
                    "--city",
                    ga.CITY_CODE,
                    "--page",
                    str(page),
                    "--page-size",
                    ga.PAGE_SIZE,
                ],
                refresh,
            )
            search_payloads.append((keyword, page, payload))
    for page in ga.PAGES:
        cache_path = ga.SEARCH_DIR / f"recommend__sort{ga.SORT_TYPE}__p{page}.json"
        payload = ga.load_or_collect_json(
            cache_path,
            [
                "recommend",
                "--city",
                ga.CITY_CODE,
                "--page",
                str(page),
                "--page-size",
                ga.PAGE_SIZE,
                "--sort-type",
                ga.SORT_TYPE,
            ],
            refresh,
        )
        recommend_payloads.append((page, payload))
    return search_payloads, recommend_payloads


def build_full_records(
    refresh: bool,
) -> tuple[
    list[ga.JobLead],
    list[ga.JobLead],
    list[ga.JobLead],
    list[ga.JobLead],
    list[ga.JobLead],
    list[ga.JobDetailRecord],
]:
    search_payloads, recommend_payloads = collect_payloads(refresh)
    search_leads = [
        lead
        for keyword, page, payload in search_payloads
        for lead in ga.extract_jobs(payload, "search", keyword, page, None)
    ]
    recommend_leads = [
        lead
        for page, payload in recommend_payloads
        for lead in ga.extract_jobs(payload, "recommend", "", page, ga.SORT_TYPE)
    ]
    merged = ga.merge_leads(search_leads + recommend_leads)
    yiwu_primary, district_supplement, excluded = ga.choose_live_scope(merged)
    yiwu_primary = sorted(yiwu_primary, key=lambda lead: (lead.area, lead.job_name, lead.company))

    records: list[ga.JobDetailRecord] = []
    for lead in yiwu_primary:
        payload = ga.load_or_collect_detail(lead, refresh=refresh)
        try:
            records.append(ga.extract_detail_record(lead, payload))
        except Exception:
            continue

    records = sorted(
        records,
        key=lambda record: (
            record.business_district or "",
            record.job_name,
            record.company,
        ),
    )
    return search_leads, recommend_leads, yiwu_primary, district_supplement, excluded, records


def records_to_rows(records: list[ga.JobDetailRecord]) -> list[dict]:
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
                "cluster_label": ga.CLUSTER_LABELS.get(record.cluster, record.cluster),
                "platforms": record.platforms,
                "tools": record.tools,
                "trade_tags": record.trade_tags,
                "english_requirement": record.english_requirement,
                "match_level": record.match_level,
                "required_skills": record.required_skills,
                "source_hits": record.lead.source_hits,
                "job_desc": record.job_desc,
            }
        )
    return rows


def write_full_rows(rows: list[dict]) -> None:
    FULL_JSON_PATH.write_text(
        json.dumps(rows, ensure_ascii=False, indent=2),
        encoding="utf-8",
    )
    fieldnames = [
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
        "platforms",
        "tools",
        "trade_tags",
        "english_requirement",
        "match_level",
        "required_skills",
        "source_hits",
        "job_desc",
    ]
    with FULL_CSV_PATH.open("w", newline="", encoding="utf-8") as handle:
        writer = csv.DictWriter(handle, fieldnames=fieldnames)
        writer.writeheader()
        for row in rows:
            writer.writerow(
                {
                    key: "|".join(value) if isinstance(value, list) else value
                    for key, value in row.items()
                }
            )


def render_full_report(
    search_leads: list[ga.JobLead],
    recommend_leads: list[ga.JobLead],
    yiwu_primary: list[ga.JobLead],
    district_supplement: list[ga.JobLead],
    excluded: list[ga.JobLead],
    records: list[ga.JobDetailRecord],
) -> tuple[str, dict]:
    experience = Counter(record.experience_name for record in records if record.experience_name)
    degree = Counter(record.degree_name for record in records if record.degree_name)
    english = Counter(record.english_requirement for record in records)
    clusters = Counter(ga.CLUSTER_LABELS.get(record.cluster, record.cluster) for record in records)
    platforms = Counter(platform for record in records for platform in record.platforms)
    tools = Counter(tool for record in records for tool in record.tools)
    business_district = Counter(record.business_district for record in records if record.business_district)
    position_categories = Counter(record.position_category for record in records if record.position_category)
    district_groups: dict[str, list[ga.JobDetailRecord]] = defaultdict(list)
    cluster_groups: dict[str, list[ga.JobDetailRecord]] = defaultdict(list)
    signals = Counter()

    for record in records:
        district_groups[record.business_district or "未标注业务片区"].append(record)
        cluster_groups[record.cluster].append(record)
        combined = f"{record.job_desc}|{'|'.join(record.required_skills)}"
        for keyword in SIGNAL_KEYWORDS:
            if keyword.lower() in combined.lower():
                signals[keyword] += 1

    lines = [
        "# 义乌跨境电商全量 JD 分析",
        "",
        f"- 口径：仅保留 `city == 金华` 且 `areaDistrict == 义乌市` 的 live `job-detail` 全量缓存。",
        f"- 城市码：`{ga.CITY_CODE}`（live 验证对应金华；`101191100` 会误落常州）",
        f"- 全量义乌 JD 数：`{len(records)}`",
        f"- `search` 原始命中：`{len(search_leads)}`；`recommend` 原始命中：`{len(recommend_leads)}`",
        f"- 去重后金华跨境相关岗位：`{len(yiwu_primary) + len(district_supplement)}`；其中义乌主样本：`{len(yiwu_primary)}`",
        f"- 被剔除的异地或非跨境样本：`{len(excluded)}`",
        "- `recommend` 已用项目接口实际调用，但当前 session 下 1-3 页为空池，因此全量样本由 `search + job-detail` 构成。",
        f"- 落盘：`{FULL_JSON_PATH}`、`{FULL_CSV_PATH}`、`{FULL_REPORT_PATH}`",
        "",
        "## 高频要求总览",
        "",
        f"- 经验门槛 Top：`{top_pairs(experience, 8)}`",
        f"- 学历门槛 Top：`{top_pairs(degree, 8)}`",
        f"- 岗位簇 Top：`{top_pairs(clusters, 8)}`",
        f"- 业务片区 Top：`{top_pairs(business_district, 12)}`",
        f"- 职类 Top：`{top_pairs(position_categories, 10)}`",
        f"- 平台词 Top：`{top_pairs(platforms, 12)}`",
        f"- 工具词 Top：`{top_pairs(tools, 10)}`",
        f"- 英语/外贸要求：`{top_pairs(english, 8)}`",
        f"- 高频动作词：`{top_pairs(signals, 12)}`",
        "",
        "## 对简历最直接的反推",
        "",
        "- 必须前置：义乌本地、1 年+ 电商运营、可量化结果。",
        "- 必须贴近 JD 用语：选品、上架、标题优化、详情页、数据复盘、库存/备货、定价协同。",
        "- 需要显式留白：跨境平台实操、英语读写、ERP/PS/剪映、广告平台后台、外贸客户沟通。",
        "- 不应冒写：Amazon/Temu/TikTok/独立站实操、英文客服、海外广告投放后台经验。",
        "",
        "## 业务片区细颗粒度拆解",
        "",
    ]

    for district, district_records in sorted(
        district_groups.items(),
        key=lambda item: (-len(item[1]), item[0]),
    ):
        district_clusters = Counter(
            ga.CLUSTER_LABELS.get(record.cluster, record.cluster)
            for record in district_records
        )
        district_platforms = Counter(
            platform for record in district_records for platform in record.platforms
        )
        district_tools = Counter(
            tool for record in district_records for tool in record.tools
        )
        lines.extend(
            [
                f"### {district}",
                "",
                f"- JD 数：`{len(district_records)}`",
                f"- 薪资区间：`{ga.salary_range_desc(district_records)}`",
                f"- 岗位簇：`{top_pairs(district_clusters, 5)}`",
                f"- 平台侧重：`{top_pairs(district_platforms, 6)}`",
                f"- 工具侧重：`{top_pairs(district_tools, 6)}`",
                "",
            ]
        )
        for record in ga.representative_records(district_records, limit=3):
            lines.append(
                f"- {record.job_name}｜{record.company}｜`{record.salary_desc or '未标注薪资'}`｜`{record.experience_name or '经验未写明'}`｜`{record.degree_name or '学历未写明'}`"
            )
            lines.append(
                f"  - 摘要：{ga.jd_brief(record)}"
            )
        lines.append("")

    lines.extend(
        [
            "## 岗位簇拆解",
            "",
        ]
    )

    for cluster_key, cluster_label in ga.CLUSTER_LABELS.items():
        cluster_records = cluster_groups.get(cluster_key, [])
        if not cluster_records:
            continue
        cluster_experience = Counter(
            record.experience_name for record in cluster_records if record.experience_name
        )
        cluster_degree = Counter(
            record.degree_name for record in cluster_records if record.degree_name
        )
        cluster_platforms = Counter(
            platform for record in cluster_records for platform in record.platforms
        )
        cluster_tools = Counter(
            tool for record in cluster_records for tool in record.tools
        )
        cluster_english = Counter(record.english_requirement for record in cluster_records)
        cluster_match = Counter(record.match_level for record in cluster_records)
        lines.extend(
            [
                f"### {cluster_label}",
                "",
                f"- 样本数：`{len(cluster_records)}`",
                f"- 薪资区间：`{ga.salary_range_desc(cluster_records)}`",
                f"- 经验门槛：`{top_pairs(cluster_experience, 5)}`",
                f"- 学历门槛：`{top_pairs(cluster_degree, 5)}`",
                f"- 平台关键词：`{top_pairs(cluster_platforms, 6)}`",
                f"- 工具关键词：`{top_pairs(cluster_tools, 6)}`",
                f"- 英语/外贸要求：`{top_pairs(cluster_english, 3)}`",
                f"- 与当前简历匹配度：`{top_pairs(cluster_match, 3)}`",
                "",
            ]
        )
        for record in ga.representative_records(cluster_records, limit=2):
            lines.append(
                f"- 代表 JD：{record.job_name}｜{record.company}｜`{record.salary_desc or '未标注薪资'}`｜{record.location_desc or record.area_district}"
            )
            lines.append(f"  - 摘要：{ga.jd_brief(record)}")
        lines.append("")

    lines.extend(
        [
            "## 全量 JD 清单",
            "",
        ]
    )
    for district, district_records in sorted(
        district_groups.items(),
        key=lambda item: (-len(item[1]), item[0]),
    ):
        lines.append(f"### {district}")
        lines.append("")
        for record in district_records:
            lines.append(
                f"- {record.job_name}｜{record.company}｜`{record.salary_desc or '未标注薪资'}`｜`{record.experience_name or '经验未写明'}`｜`{record.degree_name or '学历未写明'}`"
            )
            lines.append(
                f"  - 平台：`{'、'.join(record.platforms) or '未显式写出'}`；工具：`{'、'.join(record.tools) or '未显式写出'}`；匹配度：`{record.match_level}`"
            )
            lines.append(f"  - 摘要：{ga.jd_brief(record)}")
        lines.append("")

    summary = {
        "generated_at": ga.datetime.now().isoformat(),
        "city_code": ga.CITY_CODE,
        "full_yiwu_jd_count": len(records),
        "search_raw_count": len(search_leads),
        "recommend_raw_count": len(recommend_leads),
        "yiwu_primary_count": len(yiwu_primary),
        "district_supplement_count": len(district_supplement),
        "excluded_count": len(excluded),
        "experience": dict(experience),
        "degree": dict(degree),
        "english": dict(english),
        "clusters": dict(clusters),
        "platforms": dict(platforms),
        "tools": dict(tools),
        "signals": dict(signals),
        "business_district": dict(business_district),
        "position_categories": dict(position_categories),
        "json_path": str(FULL_JSON_PATH),
        "csv_path": str(FULL_CSV_PATH),
        "analysis_path": str(FULL_REPORT_PATH),
        "resume_md_path": str(ga.RESUME_MD_PATH),
        "resume_docx_path": str(ga.RESUME_DOCX_PATH),
        "resume_pdf_path": str(ga.RESUME_PDF_PATH),
    }
    return "\n".join(lines), summary


def main() -> int:
    args = parse_args()
    ga.ensure_dirs()
    (
        search_leads,
        recommend_leads,
        yiwu_primary,
        district_supplement,
        excluded,
        records,
    ) = build_full_records(refresh=args.refresh)
    rows = records_to_rows(records)
    write_full_rows(rows)
    report_markdown, summary = render_full_report(
        search_leads,
        recommend_leads,
        yiwu_primary,
        district_supplement,
        excluded,
        records,
    )
    ga.write_text(FULL_REPORT_PATH, report_markdown)

    resume_markdown = ga.render_resume_markdown()
    ga.write_text(ga.RESUME_MD_PATH, resume_markdown)

    export_status = {"docx": "skipped", "pdf": "skipped", "pdf_verify": "skipped"}
    if not args.skip_export:
        export_status["docx"] = ga.export_resume_docx(resume_markdown)
        export_status["pdf"] = ga.export_resume_pdf(resume_markdown)
        export_status["pdf_verify"] = ga.verify_pdf_text()
    summary["export_status"] = export_status
    FULL_META_PATH.write_text(
        json.dumps(summary, ensure_ascii=False, indent=2),
        encoding="utf-8",
    )
    print(
        json.dumps(
            {
                "full_yiwu_jd_count": len(records),
                "json_path": str(FULL_JSON_PATH),
                "csv_path": str(FULL_CSV_PATH),
                "analysis_path": str(FULL_REPORT_PATH),
                "resume_md_path": str(ga.RESUME_MD_PATH),
                "resume_docx_path": str(ga.RESUME_DOCX_PATH),
                "resume_pdf_path": str(ga.RESUME_PDF_PATH),
                "export_status": export_status,
            },
            ensure_ascii=False,
            indent=2,
        )
    )
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
