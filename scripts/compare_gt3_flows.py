#!/usr/bin/env python3
"""Print a safe side-by-side comparison of the article's Web GT3 flow and the APK GT3 flow."""

from __future__ import annotations

import argparse
import json
from dataclasses import asdict, dataclass


@dataclass(frozen=True)
class ComparisonRow:
    dimension: str
    web_article: str
    apk_flow: str
    takeaway: str


ROWS = [
    ComparisonRow(
        dimension="Entry",
        web_article="Browser opens official demo and starts GT3 web flow.",
        apk_flow="MachineVerifyActivity starts unified captcha flow and requests /zpsecureflow/captcha/gettype.",
        takeaway="APK has an extra app-backend gate before GT3 starts.",
    ),
    ComparisonRow(
        dimension="Provider selection",
        web_article="Single-provider GT3 demo.",
        apk_flow="captchaType selects provider: 1 -> GT3, 4 -> Netease.",
        takeaway="Boss wraps GT3 behind a provider factory.",
    ),
    ComparisonRow(
        dimension="Local proof generation",
        web_article="Article focuses on browser-side JS fields such as w, userresponse, passtime, aa, ep-tm, and rp.",
        apk_flow="Business code passes startCaptcha into GT3ConfigBean.setApi1Json(...); SDK handles the rest.",
        takeaway="The app business layer does not visibly hand-build the web demo's proof fields.",
    ),
    ComparisonRow(
        dimension="Image handling",
        web_article="Discusses scrambled background restoration in the web flow.",
        apk_flow="No equivalent image-restoration logic appears in app business code.",
        takeaway="Image and challenge internals are encapsulated by the GT3 SDK/WebView layer.",
    ),
    ComparisonRow(
        dimension="Result format",
        web_article="Final web flow yields validate-related data for the browser protocol.",
        apk_flow="SDK callback returns geetest_challenge/geetest_validate/geetest_seccode, then app wraps captcha_info.",
        takeaway="Both end in GT3 proof material, but payload shape differs.",
    ),
    ComparisonRow(
        dimension="Native role",
        web_article="No app-native signer is involved in the browser article.",
        apk_flow="libyzwg.so signs and encodes app requests via YZWG/com.twl.signer.a.",
        takeaway="libyzwg.so supports app transport security, not GT3 web proof generation.",
    ),
]


SUMMARY = [
    "The article analyzes the browser JS protocol of the official GT3 demo.",
    "The Boss APK integrates GT3 through a provider facade and the GT3 Android SDK.",
    "A safe local implementation is a comparison model or trace harness, not a captcha-bypass generator.",
]


def render_markdown() -> str:
    lines = [
        "# GT3 Flow Comparison",
        "",
        "## Summary",
        "",
    ]
    lines.extend(f"- {item}" for item in SUMMARY)
    lines.extend(
        [
            "",
            "## Table",
            "",
            "| Dimension | Web Article | Boss APK | Takeaway |",
            "| --- | --- | --- | --- |",
        ]
    )
    for row in ROWS:
        lines.append(
            f"| {row.dimension} | {row.web_article} | {row.apk_flow} | {row.takeaway} |"
        )
    lines.extend(
        [
            "",
            "## Safe Boundary",
            "",
            "- This tool compares flows only.",
            "- It does not generate w values, solve slider challenges, or produce bypass payloads.",
        ]
    )
    return "\n".join(lines)


def render_json() -> str:
    return json.dumps(
        {
            "summary": SUMMARY,
            "rows": [asdict(row) for row in ROWS],
            "safe_boundary": [
                "comparison only",
                "no w generation",
                "no slider solving",
                "no bypass payload generation",
            ],
        },
        ensure_ascii=False,
        indent=2,
    )


def main() -> int:
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument(
        "--format",
        choices=("markdown", "json"),
        default="markdown",
        help="Output format.",
    )
    args = parser.parse_args()
    if args.format == "json":
        print(render_json())
    else:
        print(render_markdown())
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
