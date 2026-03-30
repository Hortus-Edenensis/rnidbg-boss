#!/usr/bin/env python3
from __future__ import annotations

import argparse
import json
import shutil
import subprocess
import threading
import time
from http import HTTPStatus
from http.server import BaseHTTPRequestHandler, ThreadingHTTPServer
from pathlib import Path
from typing import Any
from urllib.parse import urlparse


REPO_ROOT = Path(__file__).resolve().parents[2]
CLI_PATH = REPO_ROOT / "scripts" / "seetong_blackbox_cli.py"
DEFAULT_TRACE_ROOT = REPO_ROOT / "target" / "seetong-web"


INDEX_HTML = """<!doctype html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>Seetong Blackbox Live</title>
  <style>
    :root {
      --bg: #081018;
      --panel: rgba(11, 21, 30, 0.92);
      --panel-2: rgba(16, 29, 40, 0.92);
      --text: #eef5fb;
      --muted: #9db0c2;
      --accent: #3dd2b2;
      --accent-2: #1f9f89;
      --danger: #ff6e7c;
      --border: #2a3b49;
      --shadow: 0 20px 60px rgba(0, 0, 0, 0.28);
    }
    * { box-sizing: border-box; }
    body {
      margin: 0;
      min-height: 100vh;
      color: var(--text);
      background:
        radial-gradient(circle at 0% 0%, rgba(33, 127, 116, 0.22), transparent 28%),
        radial-gradient(circle at 100% 20%, rgba(31, 70, 119, 0.22), transparent 26%),
        linear-gradient(180deg, #0d1720, var(--bg));
      font-family: ui-monospace, SFMono-Regular, Menlo, Monaco, Consolas, monospace;
      padding: 18px;
    }
    .wrap { max-width: 1280px; margin: 0 auto; display: grid; gap: 16px; }
    .hero, .card {
      border: 1px solid var(--border);
      border-radius: 18px;
      background: linear-gradient(180deg, var(--panel-2), var(--panel));
      box-shadow: var(--shadow);
    }
    .hero { padding: 18px; }
    .hero h1 { margin: 0; font-size: 22px; }
    .hero p { margin: 8px 0 0; color: var(--muted); line-height: 1.5; }
    .layout { display: grid; gap: 16px; grid-template-columns: 1.3fr 1fr; }
    @media (max-width: 1080px) { .layout { grid-template-columns: 1fr; } }
    .card { padding: 14px; }
    .card h2 { margin: 0 0 10px; font-size: 14px; text-transform: uppercase; color: #d6e4f1; }
    .controls { display: flex; gap: 10px; flex-wrap: wrap; align-items: center; }
    button {
      border: 1px solid var(--border);
      border-radius: 10px;
      background: #111a23;
      color: var(--text);
      font: inherit;
      padding: 10px 12px;
      cursor: pointer;
    }
    button.primary {
      background: linear-gradient(180deg, var(--accent), var(--accent-2));
      color: #02100d;
      font-weight: 700;
    }
    input, select {
      border: 1px solid var(--border);
      border-radius: 10px;
      background: #0d1620;
      color: var(--text);
      font: inherit;
      padding: 10px 12px;
      min-width: 180px;
    }
    .status {
      min-height: 22px;
      margin-top: 10px;
      color: var(--muted);
      white-space: pre-wrap;
    }
    .status.ok { color: #89deb5; }
    .status.error { color: var(--danger); }
    .player-wrap {
      position: relative;
      background: #000;
      border-radius: 14px;
      overflow: hidden;
      aspect-ratio: 16 / 9;
      border: 1px solid var(--border);
    }
    video {
      width: 100%;
      height: 100%;
      background: #000;
      display: block;
    }
    .mono {
      border: 1px solid var(--border);
      border-radius: 12px;
      background: rgba(6, 10, 15, 0.96);
      padding: 10px;
      white-space: pre-wrap;
      word-break: break-word;
      min-height: 120px;
      max-height: 420px;
      overflow: auto;
      color: #dce8f6;
      line-height: 1.5;
    }
    .meta { display: grid; gap: 10px; }
    .hint { color: var(--muted); font-size: 12px; line-height: 1.5; margin-top: 8px; }
    a { color: #80d7ff; }
  </style>
</head>
<body>
  <div class="wrap">
    <div class="hero">
      <h1>Seetong Blackbox Live</h1>
      <p>本地网页实时播放 rnidbg 导出的黑盒视频。点击启动后，服务端会跑导出接口，再把结果转成浏览器可播的 HLS live。</p>
    </div>

    <div class="card">
      <h2>Controls</h2>
      <div class="controls">
        <button id="startBtn" class="primary">Start Live</button>
        <button id="stopBtn">Stop</button>
        <select id="backendSel">
          <option value="unicorn">unicorn</option>
          <option value="dynarmic">dynarmic</option>
        </select>
        <select id="modeSel">
          <option value="blackbox">blackbox</option>
          <option value="real-loc">real-loc</option>
          <option value="real-p2p">real-p2p</option>
        </select>
        <input id="traceInput" value="seetong-live-web" />
      </div>
      <div id="status" class="status"></div>
      <div class="hint">trace 目录会创建在服务端 `target/seetong-web/<traceName>`。默认黑盒样本会自动生成并注入。</div>
    </div>

    <div class="layout">
      <div class="card">
        <h2>Live Player</h2>
        <div class="player-wrap">
          <video id="video" controls autoplay muted playsinline></video>
        </div>
        <div class="hint">
          如果浏览器不支持原生 HLS，会自动尝试加载 hls.js。
          当前播放源：<a id="playlistLink" href="/live/index.m3u8" target="_blank">/live/index.m3u8</a>
        </div>
      </div>

      <div class="meta">
        <div class="card">
          <h2>Runtime</h2>
          <code id="runtimeBox" class="mono"></code>
        </div>
        <div class="card">
          <h2>Artifacts</h2>
          <code id="artifactsBox" class="mono"></code>
        </div>
      </div>
    </div>
  </div>

<script>
const statusBox = document.getElementById('status');
const runtimeBox = document.getElementById('runtimeBox');
const artifactsBox = document.getElementById('artifactsBox');
const video = document.getElementById('video');
const startBtn = document.getElementById('startBtn');
const stopBtn = document.getElementById('stopBtn');
const backendSel = document.getElementById('backendSel');
const modeSel = document.getElementById('modeSel');
const traceInput = document.getElementById('traceInput');
const playlistLink = document.getElementById('playlistLink');

let hls = null;
let attachedUrl = '';

function setStatus(text, kind) {
  statusBox.textContent = text || '';
  statusBox.className = 'status' + (kind ? ' ' + kind : '');
}

function pretty(obj) {
  return JSON.stringify(obj || {}, null, 2);
}

function destroyPlayer() {
  if (hls) {
    hls.destroy();
    hls = null;
  }
  attachedUrl = '';
  video.removeAttribute('src');
  video.load();
}

function attachPlayer(url) {
  if (attachedUrl === url) return;
  destroyPlayer();
  attachedUrl = url;
  playlistLink.href = url;
  if (video.canPlayType('application/vnd.apple.mpegurl')) {
    video.src = url;
    video.play().catch(() => {});
    return;
  }
  const bootstrap = () => {
    if (!window.Hls || !window.Hls.isSupported()) {
      setStatus('浏览器不支持 HLS 播放', 'error');
      return;
    }
    hls = new window.Hls({
      liveSyncDurationCount: 2,
      maxLiveSyncPlaybackRate: 1.5,
    });
    hls.loadSource(url);
    hls.attachMedia(video);
    hls.on(window.Hls.Events.MANIFEST_PARSED, () => video.play().catch(() => {}));
    hls.on(window.Hls.Events.ERROR, (_, data) => {
      if (data && data.fatal) {
        setStatus('HLS 播放失败: ' + data.type, 'error');
      }
    });
  };
  if (window.Hls) {
    bootstrap();
    return;
  }
  const script = document.createElement('script');
  script.src = 'https://cdn.jsdelivr.net/npm/hls.js@1.5.17/dist/hls.min.js';
  script.onload = bootstrap;
  script.onerror = () => setStatus('加载 hls.js 失败', 'error');
  document.head.appendChild(script);
}

async function api(path, init) {
  const res = await fetch(path, {
    headers: { 'Content-Type': 'application/json' },
    ...init,
  });
  const text = await res.text();
  let data = {};
  try { data = text ? JSON.parse(text) : {}; } catch (_) { data = { raw: text }; }
  if (!res.ok) throw new Error((data && data.error) || text || ('HTTP ' + res.status));
  return data;
}

async function refreshStatus() {
  try {
    const data = await api('/api/status');
    runtimeBox.textContent = pretty({
        state: data.state,
        running: data.running,
        hlsReady: data.hlsReady,
        sessionId: data.sessionId,
        error: data.error,
        mode: data.mode,
      });
    artifactsBox.textContent = pretty(data.result || {});
    if (data.state === 'ready' && data.hlsReady) {
      setStatus('live 已就绪', 'ok');
      attachPlayer('/live/index.m3u8?session=' + encodeURIComponent(data.sessionId || ''));
    } else if (data.state === 'running') {
      setStatus('正在启动导出和转流...', '');
    } else if (data.state === 'error') {
      setStatus(data.error || '启动失败', 'error');
    } else if (data.state === 'idle') {
      setStatus('空闲', '');
    }
  } catch (err) {
    setStatus(String(err), 'error');
  }
}

async function startLive() {
  setStatus('启动中...', '');
  destroyPlayer();
  try {
    await api('/api/start', {
      method: 'POST',
        body: JSON.stringify({
          backend: backendSel.value,
          mode: modeSel.value,
          traceName: traceInput.value.trim() || 'seetong-live-web',
        }),
    });
    refreshStatus();
  } catch (err) {
    setStatus(String(err), 'error');
  }
}

async function stopLive() {
  try {
    await api('/api/stop', { method: 'POST', body: '{}' });
    destroyPlayer();
    refreshStatus();
  } catch (err) {
    setStatus(String(err), 'error');
  }
}

startBtn.addEventListener('click', startLive);
stopBtn.addEventListener('click', stopLive);
refreshStatus();
setInterval(refreshStatus, 1500);
</script>
</body>
</html>
"""


class LiveState:
    def __init__(self, trace_root: Path) -> None:
        self.trace_root = trace_root
        self.lock = threading.Lock()
        self.state = "idle"
        self.mode = ""
        self.error = ""
        self.result: dict[str, Any] | None = None
        self.session_id = ""
        self.hls_dir = self.trace_root / "current-hls"
        self.ffmpeg_proc: subprocess.Popen[str] | None = None
        self.worker: threading.Thread | None = None

    def snapshot(self) -> dict[str, Any]:
        with self.lock:
            return {
                "state": self.state,
                "mode": self.mode,
                "running": self.state == "running",
                "error": self.error,
                "result": self.result,
                "sessionId": self.session_id,
                "hlsReady": (self.hls_dir / "index.m3u8").exists(),
            }

    def set_running(self, session_id: str, mode: str) -> None:
        with self.lock:
            self.state = "running"
            self.mode = mode
            self.error = ""
            self.result = None
            self.session_id = session_id

    def set_ready(self, result: dict[str, Any]) -> None:
        with self.lock:
            self.state = "ready"
            self.mode = str(result.get("mode") or self.mode)
            self.error = ""
            self.result = result

    def set_error(self, message: str) -> None:
        with self.lock:
            self.state = "error"
            self.error = message

    def set_idle(self) -> None:
        with self.lock:
            self.state = "idle"
            self.mode = ""
            self.error = ""

    def stop_ffmpeg(self) -> None:
        proc = None
        with self.lock:
            proc = self.ffmpeg_proc
            self.ffmpeg_proc = None
        if proc and proc.poll() is None:
            proc.terminate()
            try:
                proc.wait(timeout=3)
            except subprocess.TimeoutExpired:
                proc.kill()
                proc.wait(timeout=3)

    def start_hls(self, source_path: Path, trace_out: Path) -> None:
        self.stop_ffmpeg()
        if self.hls_dir.exists():
            shutil.rmtree(self.hls_dir)
        self.hls_dir.mkdir(parents=True, exist_ok=True)
        hls_log = trace_out / "hls.log"
        segment_pattern = self.hls_dir / "seg_%06d.ts"
        playlist = self.hls_dir / "index.m3u8"
        log_fp = hls_log.open("w", encoding="utf-8")
        proc = subprocess.Popen(
            [
                "ffmpeg",
                "-hide_banner",
                "-loglevel",
                "warning",
                "-stream_loop",
                "-1",
                "-re",
                "-i",
                str(source_path),
                "-an",
                "-c:v",
                "libx264",
                "-preset",
                "veryfast",
                "-tune",
                "zerolatency",
                "-pix_fmt",
                "yuv420p",
                "-g",
                "30",
                "-sc_threshold",
                "0",
                "-f",
                "hls",
                "-hls_time",
                "1",
                "-hls_list_size",
                "6",
                "-hls_flags",
                "delete_segments+append_list+omit_endlist+independent_segments",
                "-hls_segment_filename",
                str(segment_pattern),
                str(playlist),
            ],
            stdout=log_fp,
            stderr=subprocess.STDOUT,
            text=True,
        )
        with self.lock:
            self.ffmpeg_proc = proc


def json_response(handler: BaseHTTPRequestHandler, status: int, payload: dict[str, Any]) -> None:
    body = json.dumps(payload, ensure_ascii=False, indent=2).encode("utf-8")
    handler.send_response(status)
    handler.send_header("Content-Type", "application/json; charset=utf-8")
    handler.send_header("Content-Length", str(len(body)))
    handler.send_header("Cache-Control", "no-store")
    handler.end_headers()
    handler.wfile.write(body)


class SeetongHandler(BaseHTTPRequestHandler):
    server_version = "SeetongWeb/0.1"

    @property
    def app(self) -> "SeetongHTTPServer":
        return self.server  # type: ignore[return-value]

    def do_GET(self) -> None:
        parsed = urlparse(self.path)
        path = parsed.path
        if path == "/":
            body = INDEX_HTML.encode("utf-8")
            self.send_response(HTTPStatus.OK)
            self.send_header("Content-Type", "text/html; charset=utf-8")
            self.send_header("Content-Length", str(len(body)))
            self.end_headers()
            self.wfile.write(body)
            return
        if path == "/api/status":
            json_response(self, HTTPStatus.OK, self.app.live_state.snapshot())
            return
        if path.startswith("/live/"):
            self.serve_hls(path[len("/live/"):])
            return
        self.send_error(HTTPStatus.NOT_FOUND)

    def do_POST(self) -> None:
        parsed = urlparse(self.path)
        length = int(self.headers.get("Content-Length", "0") or "0")
        raw = self.rfile.read(length) if length else b"{}"
        try:
            payload = json.loads(raw.decode("utf-8") or "{}")
        except json.JSONDecodeError:
            payload = {}
        if parsed.path == "/api/start":
            self.handle_start(payload)
            return
        if parsed.path == "/api/stop":
            self.handle_stop()
            return
        self.send_error(HTTPStatus.NOT_FOUND)

    def log_message(self, format: str, *args: Any) -> None:
        return

    def serve_hls(self, rel_path: str) -> None:
        if ".." in rel_path:
            self.send_error(HTTPStatus.BAD_REQUEST)
            return
        target = (self.app.live_state.hls_dir / rel_path).resolve()
        base = self.app.live_state.hls_dir.resolve()
        if not str(target).startswith(str(base)) or not target.exists() or not target.is_file():
            self.send_error(HTTPStatus.NOT_FOUND)
            return
        if target.suffix == ".m3u8":
            mime = "application/vnd.apple.mpegurl"
        elif target.suffix == ".ts":
            mime = "video/mp2t"
        else:
            mime = "application/octet-stream"
        body = target.read_bytes()
        self.send_response(HTTPStatus.OK)
        self.send_header("Content-Type", mime)
        self.send_header("Content-Length", str(len(body)))
        self.send_header("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0")
        self.end_headers()
        self.wfile.write(body)

    def handle_start(self, payload: dict[str, Any]) -> None:
        backend = str(payload.get("backend") or self.app.default_backend).strip() or self.app.default_backend
        mode = str(payload.get("mode") or self.app.default_mode).strip() or self.app.default_mode
        trace_name = str(payload.get("traceName") or "seetong-live-web").strip() or "seetong-live-web"
        if self.app.live_state.worker and self.app.live_state.worker.is_alive():
            json_response(self, HTTPStatus.CONFLICT, {"error": "a session is already starting"})
            return
        session_id = str(int(time.time()))
        trace_out = self.app.trace_root / trace_name
        self.app.live_state.stop_ffmpeg()
        if self.app.live_state.hls_dir.exists():
            shutil.rmtree(self.app.live_state.hls_dir)
        self.app.live_state.set_running(session_id, mode)

        def worker() -> None:
            try:
                trace_out.mkdir(parents=True, exist_ok=True)
                proc = subprocess.run(
                    [
                        str(self.app.python_bin),
                        str(CLI_PATH),
                        "run",
                        "--backend",
                        backend,
                        "--mode",
                        mode,
                        "--trace-out",
                        str(trace_out),
                    ],
                    text=True,
                    capture_output=True,
                    check=True,
                )
                result = json.loads(proc.stdout or "{}")
                if result.get("status") != "ok":
                    self.app.live_state.set_error(json.dumps(result, ensure_ascii=False, indent=2))
                    return
                final_path = Path(result["artifacts"]["final"])
                self.app.live_state.start_hls(final_path, trace_out)
                deadline = time.time() + 8
                while time.time() < deadline:
                    if (self.app.live_state.hls_dir / "index.m3u8").exists():
                        break
                    time.sleep(0.2)
                self.app.live_state.set_ready(result)
            except subprocess.CalledProcessError as exc:
                message = exc.stderr or exc.stdout or f"command failed with code {exc.returncode}"
                self.app.live_state.set_error(message.strip())
            except Exception as exc:  # noqa: BLE001
                self.app.live_state.set_error(str(exc))

        thread = threading.Thread(target=worker, name="seetong-web-start", daemon=True)
        self.app.live_state.worker = thread
        thread.start()
        json_response(
            self,
            HTTPStatus.OK,
            {
                "status": "starting",
                "backend": backend,
                "mode": mode,
                "traceOut": str(trace_out),
                "sessionId": session_id,
            },
        )

    def handle_stop(self) -> None:
        self.app.live_state.stop_ffmpeg()
        self.app.live_state.set_idle()
        json_response(self, HTTPStatus.OK, {"status": "stopped"})


class SeetongHTTPServer(ThreadingHTTPServer):
    def __init__(
        self,
        server_address: tuple[str, int],
        trace_root: Path,
        default_backend: str,
        default_mode: str,
        python_bin: Path,
    ) -> None:
        super().__init__(server_address, SeetongHandler)
        self.trace_root = trace_root
        self.default_backend = default_backend
        self.default_mode = default_mode
        self.python_bin = python_bin
        self.live_state = LiveState(trace_root)


def parse_args() -> argparse.Namespace:
    parser = argparse.ArgumentParser(description="Serve Seetong blackbox live video on a local webpage.")
    parser.add_argument("--host", default="0.0.0.0")
    parser.add_argument("--port", type=int, default=8891)
    parser.add_argument("--backend", default="unicorn", choices=["unicorn", "dynarmic"])
    parser.add_argument("--mode", default="blackbox", choices=["blackbox", "real-loc", "real-p2p"])
    parser.add_argument("--trace-root", type=Path, default=DEFAULT_TRACE_ROOT)
    return parser.parse_args()


def main() -> int:
    args = parse_args()
    args.trace_root.mkdir(parents=True, exist_ok=True)
    if not CLI_PATH.exists():
        raise SystemExit(f"missing CLI: {CLI_PATH}")
    server = SeetongHTTPServer(
        (args.host, args.port),
        trace_root=args.trace_root,
        default_backend=args.backend,
        default_mode=args.mode,
        python_bin=Path(shutil.which("python3") or "python3"),
    )
    print(f"Seetong web listening on http://{args.host}:{args.port}", flush=True)
    try:
        server.serve_forever()
    except KeyboardInterrupt:
        pass
    finally:
        server.live_state.stop_ffmpeg()
        server.server_close()
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
