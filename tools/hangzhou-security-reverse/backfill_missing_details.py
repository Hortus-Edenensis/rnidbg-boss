#!/usr/bin/env python3
from __future__ import annotations

import argparse
import importlib.util
import json
import sys
from pathlib import Path


REPO_ROOT = Path(__file__).resolve().parents[2]
LIVE_REPORT_SCRIPT = REPO_ROOT / "tools" / "hangzhou-security-reverse" / "generate_live_report.py"

spec = importlib.util.spec_from_file_location("hz_live_report", LIVE_REPORT_SCRIPT)
if spec is None or spec.loader is None:
    raise RuntimeError(f"failed to load helper script: {LIVE_REPORT_SCRIPT}")
mod = importlib.util.module_from_spec(spec)
sys.modules[spec.name] = mod
spec.loader.exec_module(mod)


def parse_args() -> argparse.Namespace:
    parser = argparse.ArgumentParser()
    parser.add_argument("--shard", type=int, required=True)
    parser.add_argument("--refresh", action="store_true")
    return parser.parse_args()


def main() -> int:
    args = parse_args()
    shard_path = Path(f"/tmp/hangzhou-security-reverse/meta/missing_leads_shard{args.shard}.json")
    if not shard_path.exists():
        raise SystemExit(f"missing shard file: {shard_path}")

    rows = json.loads(shard_path.read_text(encoding="utf-8"))
    completed = 0
    skipped = 0
    errors = []

    for row in rows:
        lead = mod.JobLead(
            source="search",
            keyword=row.get("keyword", ""),
            page=0,
            job_name=row.get("job_name", ""),
            company=row.get("company", ""),
            city=row.get("city", ""),
            area=row.get("area", ""),
            salary=row.get("salary", ""),
            experience=row.get("experience", ""),
            degree=row.get("degree", ""),
            security_id=row.get("security_id", ""),
            labels=row.get("labels", []) or [],
            active_time=row.get("active_time", ""),
            raw={},
            source_hits=row.get("source_hits", []) or [],
        )
        cache_path = mod.detail_cache_path(lead)
        if cache_path.exists() and not args.refresh:
            skipped += 1
            continue
        try:
            mod.load_or_collect_detail(lead, refresh=args.refresh)
            completed += 1
        except Exception as exc:
            errors.append(
                {
                    "security_id": lead.security_id,
                    "job_name": lead.job_name,
                    "company": lead.company,
                    "error": str(exc),
                }
            )

    out = {
        "shard": args.shard,
        "input_count": len(rows),
        "completed": completed,
        "skipped": skipped,
        "error_count": len(errors),
        "errors": errors[:50],
    }
    print(json.dumps(out, ensure_ascii=False, indent=2))
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
