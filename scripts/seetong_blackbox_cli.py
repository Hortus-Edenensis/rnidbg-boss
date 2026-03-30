#!/usr/bin/env python3
from __future__ import annotations

import argparse
import base64
import hashlib
import json
import os
import shlex
import shutil
import subprocess
import sys
from pathlib import Path
from typing import Any


REPO_ROOT = Path(__file__).resolve().parent.parent
DEFAULT_CONFIG = REPO_ROOT / "config" / "seetong-funclib.host.json"
DEFAULT_SEED = REPO_ROOT / "target-hostbuild" / "seetong-real-seed.json"
DEFAULT_SAMPLE = REPO_ROOT / "target" / "seetong-blackbox-sample" / "sample.h265"
DEFAULT_TRACE_OUT = REPO_ROOT / "target" / "seetong-trace-oneclick"
DEFAULT_SAMPLE_CODEC = "hevc"
DEFAULT_RUN_TIMEOUT = 40

SIBLING_SEETONG_ROOT = REPO_ROOT.parent / "seetong"
SEETONG_EXTRACT_SCRIPT = SIBLING_SEETONG_ROOT / "scripts" / "seetong_stream_extract.py"
ENSURE_RNIDBG_BIN = REPO_ROOT / "scripts" / "ensure-rnidbg-bin.sh"

DEVICE_CRYPT_DOMAIN = "app.seetong.com"
DEVICE_CRYPT_SEED = "6666688888"


def md5_hex(value: str) -> str:
    return hashlib.md5(value.encode("utf-8")).hexdigest()


def build_device_xor_stream() -> bytes:
    part1 = md5_hex(DEVICE_CRYPT_SEED)
    part2 = md5_hex(DEVICE_CRYPT_DOMAIN + DEVICE_CRYPT_SEED)
    part3 = md5_hex(DEVICE_CRYPT_SEED + DEVICE_CRYPT_DOMAIN)
    prefix = part1 + part2 + part3
    return (prefix + md5_hex(prefix)).encode("ascii")


DEVICE_XOR_STREAM = build_device_xor_stream()


def decode_device_credential(encoded_value: str) -> str:
    if not encoded_value:
        return ""
    raw = base64.b64decode(encoded_value)
    decoded = bytes(raw[idx] ^ DEVICE_XOR_STREAM[idx % len(DEVICE_XOR_STREAM)] for idx in range(len(raw)))
    return decoded.decode("utf-8", errors="replace")


def run(
    cmd: list[str],
    *,
    env: dict[str, str] | None = None,
    capture_output: bool = False,
    check: bool = True,
) -> subprocess.CompletedProcess[str]:
    print(f"+ {shlex.join(cmd)}", file=sys.stderr)
    kwargs: dict[str, Any] = {
        "env": env,
        "text": True,
        "check": check,
    }
    if capture_output:
        kwargs["capture_output"] = True
    else:
        kwargs["stdout"] = sys.stderr
        kwargs["stderr"] = sys.stderr
    return subprocess.run(cmd, **kwargs)


def ensure_file(path: Path, label: str) -> Path:
    if not path.exists():
        raise FileNotFoundError(f"{label} not found: {path}")
    return path


def ensure_rnidbg_bin(backend: str) -> Path:
    ensure_file(ENSURE_RNIDBG_BIN, "ensure-rnidbg-bin.sh")
    proc = run([str(ENSURE_RNIDBG_BIN), backend], capture_output=True)
    return ensure_file(Path(proc.stdout.strip()), "rnidbg binary")


def ffprobe_json(path: Path) -> dict[str, Any]:
    proc = run(
        [
            "ffprobe",
            "-v",
            "error",
            "-show_entries",
            "stream=codec_name,width,height,r_frame_rate,duration",
            "-of",
            "json",
            str(path),
        ],
        capture_output=True,
    )
    return json.loads(proc.stdout or "{}")


def first_stream_info(path: Path) -> dict[str, Any]:
    info = ffprobe_json(path)
    streams = info.get("streams") or []
    return streams[0] if streams else {}


def load_seed(seed_path: Path) -> tuple[dict[str, Any], dict[str, Any]]:
    seed = json.loads(seed_path.read_text())
    cloud_id = str(seed.get("watch", {}).get("cloud_id", "")).strip()
    records = seed.get("deviceJson") or []
    if not isinstance(records, list) or not records:
        raise RuntimeError(f"deviceJson missing in seed: {seed_path}")
    record = next(
        (
            item
            for item in records
            if str(item.get("devId", "")).strip() == cloud_id and str(item.get("devId", "")).strip()
        ),
        records[0],
    )
    if not isinstance(record, dict):
        raise RuntimeError("deviceJson record is not an object")
    return seed, record


def resolve_device_auth(seed_path: Path) -> dict[str, str]:
    _, record = load_seed(seed_path)
    dev_id = str(record.get("devId") or "").strip()
    dev_ip = str(record.get("devIp") or "").strip()
    user = decode_device_credential(str(record.get("devLoginUser") or ""))
    password = decode_device_credential(str(record.get("devLoginPassword") or ""))
    if not dev_id or not dev_ip or not user or not password:
        raise RuntimeError(
            f"failed to resolve device auth from seed: devId={dev_id!r} devIp={dev_ip!r} user={bool(user)} pass={bool(password)}"
        )
    return {
        "devId": dev_id,
        "devIp": dev_ip,
        "user": user,
        "password": password,
    }


def make_sample_video(
    *,
    output: Path,
    codec: str,
    duration: float,
    size: str,
    fps: int,
) -> dict[str, Any]:
    output.parent.mkdir(parents=True, exist_ok=True)
    codec_norm = codec.lower()
    if codec_norm in {"h265", "hevc"}:
        output_format = "hevc"
        encoder = "libx265"
        codec_name = "hevc"
        extra = ["-x265-params", f"keyint={fps}:min-keyint={fps}:repeat-headers=1"]
    elif codec_norm in {"h264", "avc"}:
        output_format = "h264"
        encoder = "libx264"
        codec_name = "h264"
        extra = ["-g", str(fps), "-x264-params", f"keyint={fps}:min-keyint={fps}:repeat-headers=1"]
    else:
        raise ValueError(f"unsupported codec: {codec}")
    run(
        [
            "ffmpeg",
            "-y",
            "-f",
            "lavfi",
            "-i",
            f"testsrc2=size={size}:rate={fps}",
            "-t",
            str(duration),
            "-an",
            "-c:v",
            encoder,
            "-preset",
            "ultrafast",
            *extra,
            "-f",
            output_format,
            str(output),
        ]
    )
    info = first_stream_info(output)
    return {
        "status": "ok",
        "codecRequested": codec_name,
        "output": str(output),
        "ffprobe": info,
    }


def extract_stream(raw_path: Path, trace_out: Path) -> dict[str, Any]:
    ensure_file(SEETONG_EXTRACT_SCRIPT, "seetong_stream_extract.py")
    es_path = trace_out / "video_input.es"
    run(
        [
            sys.executable,
            str(SEETONG_EXTRACT_SCRIPT),
            str(raw_path),
            "--framing",
            "u32le-frame",
            "--codec",
            "auto",
            "-o",
            str(es_path),
            "--overwrite",
        ]
    )
    stream = first_stream_info(es_path)
    codec_name = str(stream.get("codec_name") or "")
    if codec_name == "hevc":
        final_path = trace_out / "video_input.h265"
    elif codec_name == "h264":
        final_path = trace_out / "video_input.h264"
    else:
        final_path = es_path
    if final_path != es_path:
        shutil.copyfile(es_path, final_path)
    first_jpg = trace_out / "video_input_first.jpg"
    run(
        [
            "ffmpeg",
            "-y",
            "-v",
            "error",
            "-i",
            str(final_path),
            "-frames:v",
            "1",
            str(first_jpg),
        ]
    )
    return {
        "raw": str(raw_path),
        "elementaryStream": str(es_path),
        "final": str(final_path),
        "firstFrame": str(first_jpg),
        "ffprobe": stream,
    }


def command_make_sample(args: argparse.Namespace) -> int:
    result = make_sample_video(
        output=args.output.resolve(),
        codec=args.codec,
        duration=args.duration,
        size=args.size,
        fps=args.fps,
    )
    print(json.dumps(result, ensure_ascii=False, indent=2))
    return 0


def command_run(args: argparse.Namespace) -> int:
    seed_path = ensure_file(args.seed.resolve(), "seed")
    config_path = ensure_file(args.config.resolve(), "config")
    device = resolve_device_auth(seed_path)

    sample_path = args.sample.resolve()
    if args.mode in {"blackbox", "real-p2p"}:
        if not sample_path.exists():
            make_sample_video(
                output=sample_path,
                codec=args.sample_codec,
                duration=args.sample_duration,
                size=args.sample_size,
                fps=args.sample_fps,
            )
        ensure_file(sample_path, "sample video")

    rnidbg_bin = ensure_rnidbg_bin(args.backend)
    trace_out = args.trace_out.resolve()
    trace_out.mkdir(parents=True, exist_ok=True)

    env = os.environ.copy()
    env.update(
        {
            "RNIDBG_CAPTURE_FC_INIT_WITH_HEADER": "1",
            "RNIDBG_SKIP_FREE_AGENT": "1",
            "RNIDBG_LOC_IP": device["devIp"],
            "RNIDBG_LOC_USER": device["user"],
            "RNIDBG_LOC_PASS": device["password"],
        }
    )
    if args.mode == "blackbox":
        env.update(
            {
                "RNIDBG_MANUAL_LOC_REALPLAY": "1",
                "RNIDBG_BLACKBOX_LOC_LOGIN_DEV": "1",
                "RNIDBG_BLACKBOX_LOC_REALPLAY_EX": "1",
                "RNIDBG_BLACKBOX_VIDEO_ES": str(sample_path),
            }
        )
    elif args.mode == "real-loc":
        env.update(
            {
                "RNIDBG_MANUAL_LOC_REALPLAY": "1",
            }
        )
    elif args.mode == "real-p2p":
        env.update(
            {
                "RNIDBG_SKIP_LOGIN_SIG_SERVER": "1",
                "RNIDBG_FORCE_PRIME_ACCESS_NODE": "1",
                "RNIDBG_MANUAL_P2P_DRIVE": "1",
                "RNIDBG_SKIP_TASK_DESTROY": "1",
                "RNIDBG_FAKE_FUNCLIB_WORKER_KINDS": "single-buffer-data-thread,p2p-thread-proc",
                "RNIDBG_PSELECT_MAX_MS": "100",
                "RNIDBG_BLACKBOX_P2P_STREAM": "1",
                "RNIDBG_BLACKBOX_VIDEO_ES": str(sample_path),
            }
        )
    else:
        raise ValueError(f"unsupported mode: {args.mode}")

    cmd = [
        str(rnidbg_bin),
        "boss-yzwg",
        "seetong-live",
        "--backend",
        args.backend,
        "--config",
        str(config_path),
        "--seed",
        str(seed_path),
        "--trace-out",
        str(trace_out),
    ]
    try:
        proc = subprocess.run(
            cmd,
            env=env,
            text=True,
            capture_output=True,
            check=True,
            timeout=args.timeout,
        )
    except subprocess.TimeoutExpired as exc:
        trace_log = trace_out / "native_trace.log"
        payload = {
            "status": "error",
            "mode": args.mode,
            "backend": args.backend,
            "error": f"rnidbg timed out after {args.timeout}s",
            "command": cmd,
            "traceOut": str(trace_out),
            "trace": str(trace_log) if trace_log.exists() else None,
        }
        print(json.dumps(payload, ensure_ascii=False, indent=2))
        return 2
    except subprocess.CalledProcessError as exc:
        trace_log = trace_out / "native_trace.log"
        payload = {
            "status": "error",
            "mode": args.mode,
            "backend": args.backend,
            "error": f"rnidbg exited with code {exc.returncode}",
            "command": cmd,
            "traceOut": str(trace_out),
            "trace": str(trace_log) if trace_log.exists() else None,
            "stdout": exc.stdout,
            "stderr": exc.stderr,
        }
        print(json.dumps(payload, ensure_ascii=False, indent=2))
        return 4
    rnidbg_result = json.loads(proc.stdout or "{}")

    raw_video = ensure_file(trace_out / "video_input.u32le_frame.bin", "raw video output")
    if raw_video.stat().st_size <= 0:
        trace_log = trace_out / "native_trace.log"
        payload = {
            "status": "error",
            "mode": args.mode,
            "backend": args.backend,
            "error": f"raw video output is empty: {raw_video}",
            "traceOut": str(trace_out),
            "trace": str(trace_log) if trace_log.exists() else None,
            "rnidbg": rnidbg_result,
        }
        print(json.dumps(payload, ensure_ascii=False, indent=2))
        return 3

    extracted = extract_stream(raw_video, trace_out)
    final_path = Path(extracted["final"])
    if args.play:
        codec_name = str(extracted["ffprobe"].get("codec_name") or "")
        play_format = "hevc" if codec_name == "hevc" else "h264" if codec_name == "h264" else ""
        cmd = ["ffplay"]
        if play_format:
            cmd += ["-f", play_format]
        cmd.append(str(final_path))
        run(cmd, check=False)

    result = {
        "status": "ok",
        "mode": args.mode,
        "backend": args.backend,
        "device": {
            "devId": device["devId"],
            "devIp": device["devIp"],
            "user": device["user"],
        },
        "sample": str(sample_path) if args.mode == "blackbox" else None,
        "traceOut": str(trace_out),
        "rnidbg": rnidbg_result,
        "artifacts": extracted,
    }
    print(json.dumps(result, ensure_ascii=False, indent=2))
    return 0


def build_parser() -> argparse.ArgumentParser:
    parser = argparse.ArgumentParser(
        description="One-click Seetong rnidbg blackbox video interface.",
    )
    subparsers = parser.add_subparsers(dest="command", required=True)

    sample_parser = subparsers.add_parser("make-sample", help="Generate a local sample elementary stream.")
    sample_parser.add_argument(
        "--output",
        type=Path,
        default=DEFAULT_SAMPLE,
        help=f"Output sample path. Default: {DEFAULT_SAMPLE}",
    )
    sample_parser.add_argument(
        "--codec",
        default=DEFAULT_SAMPLE_CODEC,
        choices=["hevc", "h265", "h264", "avc"],
        help="Sample codec. Default: hevc",
    )
    sample_parser.add_argument("--duration", type=float, default=2.0, help="Sample duration in seconds.")
    sample_parser.add_argument("--size", default="640x360", help="Sample resolution. Default: 640x360")
    sample_parser.add_argument("--fps", type=int, default=15, help="Sample FPS. Default: 15")
    sample_parser.set_defaults(func=command_make_sample)

    run_parser = subparsers.add_parser("run", help="Run one-click rnidbg export and extract a playable file.")
    run_parser.add_argument("--backend", default="unicorn", choices=["unicorn", "dynarmic"])
    run_parser.add_argument(
        "--mode",
        default="blackbox",
        choices=["blackbox", "real-loc", "real-p2p"],
        help="Stream source mode. blackbox is current working path; real-loc and real-p2p call native real paths.",
    )
    run_parser.add_argument("--seed", type=Path, default=DEFAULT_SEED, help=f"Seed JSON path. Default: {DEFAULT_SEED}")
    run_parser.add_argument(
        "--config",
        type=Path,
        default=DEFAULT_CONFIG,
        help=f"rnidbg config path. Default: {DEFAULT_CONFIG}",
    )
    run_parser.add_argument(
        "--sample",
        type=Path,
        default=DEFAULT_SAMPLE,
        help=f"Sample video path injected into rnidbg. Default: {DEFAULT_SAMPLE}",
    )
    run_parser.add_argument(
        "--sample-codec",
        default=DEFAULT_SAMPLE_CODEC,
        choices=["hevc", "h265", "h264", "avc"],
        help="Codec to auto-generate when --sample is missing. Default: hevc",
    )
    run_parser.add_argument("--sample-duration", type=float, default=2.0, help="Auto-generated sample duration.")
    run_parser.add_argument("--sample-size", default="640x360", help="Auto-generated sample resolution.")
    run_parser.add_argument("--sample-fps", type=int, default=15, help="Auto-generated sample FPS.")
    run_parser.add_argument(
        "--trace-out",
        type=Path,
        default=DEFAULT_TRACE_OUT,
        help=f"Trace output directory. Default: {DEFAULT_TRACE_OUT}",
    )
    run_parser.add_argument(
        "--timeout",
        type=int,
        default=DEFAULT_RUN_TIMEOUT,
        help=f"rnidbg run timeout in seconds. Default: {DEFAULT_RUN_TIMEOUT}",
    )
    run_parser.add_argument("--play", action="store_true", help="Open the final file with ffplay.")
    run_parser.set_defaults(func=command_run)

    return parser


def main() -> int:
    parser = build_parser()
    args = parser.parse_args()
    try:
        return args.func(args)
    except subprocess.CalledProcessError as exc:
        if exc.stdout:
            sys.stdout.write(exc.stdout)
        if exc.stderr:
            sys.stderr.write(exc.stderr)
        print(f"command failed with code {exc.returncode}", file=sys.stderr)
        return exc.returncode or 1
    except Exception as exc:  # noqa: BLE001
        print(f"error: {exc}", file=sys.stderr)
        return 1


if __name__ == "__main__":
    raise SystemExit(main())
