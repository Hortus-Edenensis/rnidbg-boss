#!/usr/bin/env python3
import argparse
import base64
import glob
import gzip
import http.cookiejar
import json
import os
import subprocess
import tempfile
import time
import urllib.parse
import urllib.request
from http import HTTPStatus
from http.server import BaseHTTPRequestHandler, ThreadingHTTPServer


INDEX_HTML = """<!doctype html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>GT3 Native Debug Console</title>
  <style>
    :root {
      --bg: #0d1117;
      --bg-2: #121923;
      --panel: rgba(20, 27, 37, 0.92);
      --panel-2: rgba(15, 21, 29, 0.92);
      --text: #edf3fb;
      --muted: #9aa9bd;
      --accent: #29b09d;
      --accent-2: #0f7d71;
      --danger: #ff6c7a;
      --border: #2b3848;
      --shadow: 0 18px 60px rgba(0, 0, 0, 0.28);
    }
    * { box-sizing: border-box; }
    body {
      margin: 0;
      min-height: 100vh;
      color: var(--text);
      background:
        radial-gradient(circle at 20% 0%, rgba(38, 147, 137, 0.18), transparent 32%),
        radial-gradient(circle at 100% 20%, rgba(32, 72, 121, 0.24), transparent 34%),
        linear-gradient(180deg, var(--bg-2), var(--bg));
      font-family: ui-monospace, SFMono-Regular, Menlo, Monaco, Consolas, monospace;
      padding: 18px;
    }
    .wrap {
      max-width: 1460px;
      margin: 0 auto;
      display: grid;
      gap: 16px;
    }
    .hero {
      padding: 18px;
      border: 1px solid var(--border);
      border-radius: 18px;
      background: linear-gradient(180deg, rgba(18, 25, 35, 0.96), rgba(11, 16, 23, 0.96));
      box-shadow: var(--shadow);
    }
    .hero h1 { margin: 0; font-size: 22px; }
    .hero p { margin: 8px 0 0; color: var(--muted); line-height: 1.5; }
    .layout {
      display: grid;
      gap: 16px;
    }
    .card {
      background: linear-gradient(180deg, var(--panel), var(--panel-2));
      border: 1px solid var(--border);
      border-radius: 16px;
      box-shadow: var(--shadow);
      padding: 14px;
    }
    .card h2 {
      margin: 0 0 10px;
      font-size: 14px;
      color: #d9e4f0;
      letter-spacing: 0.02em;
      text-transform: uppercase;
    }
    .grid {
      display: grid;
      grid-template-columns: repeat(2, minmax(0, 1fr));
      gap: 12px;
      align-items: start;
    }
    @media (max-width: 980px) {
      .grid { grid-template-columns: 1fr; }
    }
    .actions {
      display: flex;
      gap: 8px;
      flex-wrap: wrap;
      margin-top: 10px;
    }
    button {
      border: 1px solid var(--border);
      border-radius: 10px;
      background: #111823;
      color: var(--text);
      padding: 10px 12px;
      font: inherit;
      cursor: pointer;
      transition: transform 120ms ease, border-color 120ms ease;
    }
    button:hover { transform: translateY(-1px); }
    button.primary {
      background: linear-gradient(180deg, var(--accent), var(--accent-2));
      color: #04110f;
      border-color: rgba(78, 209, 193, 0.4);
      font-weight: 700;
    }
    .status {
      min-height: 20px;
      margin-top: 10px;
      white-space: pre-wrap;
      color: var(--muted);
    }
    .status.error { color: var(--danger); }
    .status.ok { color: #84dfbe; }
    .mono {
      display: block;
      margin-top: 8px;
      padding: 10px;
      border: 1px solid var(--border);
      border-radius: 10px;
      background: rgba(8, 12, 17, 0.98);
      color: #dce8f6;
      white-space: pre-wrap;
      word-break: break-all;
      line-height: 1.5;
      min-height: 72px;
      max-height: 420px;
      overflow: auto;
    }
    .mono.tall { min-height: 240px; }
    .hint {
      color: var(--muted);
      font-size: 12px;
      line-height: 1.5;
    }
    textarea.mono-input {
      width: 100%;
      min-height: 180px;
      resize: vertical;
      font: inherit;
    }
  </style>
</head>
<body>
  <div class="wrap">
    <div class="hero">
      <h1>GT3 Native Debug Console</h1>
      <p>根页只展示 backend native 结果。Boss `judge -> machine -> gt3 -> validate` 全部在服务端执行；浏览器只消费 session，并可选打开独立 `/play` 调试页查看 app3 / JSInterface 现象。</p>
    </div>

    <div class="layout">
      <div class="card">
        <h2>Session Controls</h2>
        <div class="actions">
          <button class="primary" id="startFlowBtn">Start Manual Solve</button>
          <button id="refreshBtn">Refresh Native Session</button>
          <button id="openDebugBtn">Open Debug Player</button>
          <button id="copyUrlBtn">Copy App3 URL</button>
          <button id="copyCaptchaInfoBtn">Copy Native captcha_info</button>
          <button id="copyValidateBtn">Copy Native Validate Template</button>
          <button id="submitValidateBtn">Backfill Captured Validate</button>
        </div>
        <div id="status" class="status"></div>
        <div class="hint">推荐只用 `Start Manual Solve`。它会刷新当前 native session、打开调试页，并在捕获到 `gtCallBack(code=1)` 后自动回填 Boss validate。</div>
      </div>

      <div class="grid">
        <div class="card">
          <h2>Backend Native Status</h2>
          <code id="nativeStatusBox" class="mono"></code>
        </div>

        <div class="card">
          <h2>Native captcha_info</h2>
          <code id="captchaInfoBox" class="mono"></code>
        </div>

        <div class="card">
          <h2>Native Validate Template</h2>
          <code id="validateTemplateBox" class="mono tall"></code>
        </div>

        <div class="card">
          <h2>GT3 Exchange</h2>
          <code id="gt3ExchangeBox" class="mono tall"></code>
        </div>

        <div class="card">
          <h2>Native Trace Summary</h2>
          <code id="traceSummaryBox" class="mono tall"></code>
        </div>

        <div class="card">
          <h2>Debug App3 Contract</h2>
          <code id="debugBox" class="mono tall"></code>
        </div>

        <div class="card">
          <h2>Optional Web Debug Capture</h2>
          <code id="captureBox" class="mono tall"></code>
          <div class="hint">只有你显式打开 Debug Player 时，这里才会收到 `JSInterface.gtCallBack`、`gt3Error` 等前端调试事件。</div>
        </div>

        <div class="card">
          <h2>Manual captcha_info Override</h2>
          <textarea id="manualCaptchaInfoInput" class="mono mono-input" placeholder='{"type":1,"challenge":"...","validate":"...","secCode":"...|jordan"}'></textarea>
          <div class="hint">提交时优先使用这里的 JSON。为空时才回退到调试页捕获结果或当前 native captcha_info。</div>
        </div>

        <div class="card">
          <h2>Validate Submit Result</h2>
          <code id="validateSubmitBox" class="mono tall"></code>
        </div>

        <div class="card">
          <h2>Audit Analysis</h2>
          <code id="auditBox" class="mono tall"></code>
        </div>
      </div>
    </div>
  </div>

<script>
const statusEle = document.getElementById('status');
const nativeStatusBox = document.getElementById('nativeStatusBox');
const captchaInfoBox = document.getElementById('captchaInfoBox');
const validateTemplateBox = document.getElementById('validateTemplateBox');
const gt3ExchangeBox = document.getElementById('gt3ExchangeBox');
const traceSummaryBox = document.getElementById('traceSummaryBox');
const debugBox = document.getElementById('debugBox');
const captureBox = document.getElementById('captureBox');
const validateSubmitBox = document.getElementById('validateSubmitBox');
const auditBox = document.getElementById('auditBox');
const manualCaptchaInfoInput = document.getElementById('manualCaptchaInfoInput');

let latestSession = null;
let currentDebugCaptchaInfo = null;
let autoBackfillInFlight = false;
let lastAutoBackfillKey = '';
let captureAuditSerial = Promise.resolve();

function expectedCaptchaTypeFromSession() {
  const debugSession = (latestSession && latestSession.debug_session) || {};
  const debugTicket = debugSession.ticket || {};
  const backend = (latestSession && latestSession.backend_validation) || {};
  const debugType = Number(debugTicket.captcha_type);
  if (Number.isInteger(debugType)) return debugType;
  const backendType = Number(backend.captcha_type);
  if (Number.isInteger(backendType)) return backendType;
  return 1;
}

function normalizeCaptchaInfo(candidate) {
  if (!candidate || typeof candidate !== 'object' || Array.isArray(candidate)) return candidate;
  return Object.assign({}, candidate, { type: expectedCaptchaTypeFromSession() });
}

function setStatus(text, mode) {
  statusEle.className = 'status ' + (mode || '');
  statusEle.textContent = text || '';
}

function pretty(value) {
  if (value === null || value === undefined || value === '') return '';
  if (typeof value === 'object' && !Array.isArray(value) && Object.keys(value).length === 0) return '';
  return typeof value === 'string' ? value : JSON.stringify(value, null, 2);
}

async function requestJson(url, options) {
  const resp = await fetch(url, options);
  const data = await resp.json();
  if (!resp.ok || !data.ok) {
    throw new Error((data && data.error) || ('HTTP ' + resp.status));
  }
  return data;
}

function parseManualCaptchaInfo() {
  const raw = (manualCaptchaInfoInput.value || '').trim();
  if (!raw) return null;
  const parsed = JSON.parse(raw);
  if (!parsed || typeof parsed !== 'object' || Array.isArray(parsed)) {
    throw new Error('manual captcha_info must be a JSON object');
  }
  return parsed;
}

async function syncCaptureAudit(packet) {
  try {
    const audit = await requestJson('/api/capture_event', {
      method: 'POST',
      headers: { 'content-type': 'application/json' },
      body: JSON.stringify({
        session_id: latestSession && latestSession.session_id,
        native_trace_path: latestSession && latestSession.native_trace_path,
        debug_trace_path: latestSession && latestSession.debug_trace_path,
        packet: packet
      })
    });
    auditBox.textContent = pretty(audit.audit || audit);
    return audit;
  } catch (err) {
    auditBox.textContent = pretty({ error: String(err.message || err) });
    return null;
  }
}

function renderSession(data) {
  latestSession = data;
  const backend = data.backend_validation || {};
  const debugSession = data.debug_session || {};

  nativeStatusBox.textContent = pretty({
    session_id: data.session_id,
    created_at: data.created_at_iso,
    backend_runtime: backend.backend_runtime,
    phone_masked: data.phone_masked,
    region_code: data.region_code,
    native_trace_status: backend.status,
    provider: backend.provider,
    captcha_type: backend.captcha_type,
    captcha_name: backend.captcha_name,
    gt3_exchange_status: backend.gt3_exchange_status,
    validate_status: backend.validate_status,
    validate_submitted: backend.validate_submitted,
    judge_code: backend.judge_code,
    machine_code: backend.machine_code
  });
  captchaInfoBox.textContent = pretty(data.captcha_info);
  validateTemplateBox.textContent = pretty(data.validate_template);
  gt3ExchangeBox.textContent = pretty(data.gt3_exchange);
  traceSummaryBox.textContent = pretty({
    native_trace_path: data.native_trace_path,
    debug_trace_path: debugSession.trace_path || '',
    start_captcha: backend.start_captcha,
    real_observation: backend.real_observation,
    validate_request: data.validate_request,
    validate_response: data.validate_response
  });
  debugBox.textContent = pretty({
    debug_trace_status: debugSession.trace_status,
    trace_path: debugSession.trace_path,
    app3_url: debugSession.app3_url,
    player_url: debugSession.player_url,
    bootstrap: debugSession.bootstrap,
    gettype_data: debugSession.gettype_data,
    boa_summary: debugSession.boa_summary,
    native_prewarm: debugSession.native_prewarm,
    java_probe: data.java_probe,
    control: data.control
  });
  manualCaptchaInfoInput.placeholder = JSON.stringify({
    type: expectedCaptchaTypeFromSession(),
    challenge: '...',
    validate: '...',
    secCode: '...|jordan'
  });
  auditBox.textContent = pretty(data.audit || '');
}

async function refreshSession() {
  try {
    setStatus('backend native session producing...', '');
    captureBox.textContent = '';
    validateSubmitBox.textContent = '';
    auditBox.textContent = '';
    currentDebugCaptchaInfo = null;
    const data = await requestJson('/api/session/refresh', {
      method: 'POST',
      headers: { 'content-type': 'application/json' },
      body: JSON.stringify({})
    });
    renderSession(data);
    setStatus('backend native session ready', 'ok');
  } catch (err) {
    setStatus(String(err.message || err), 'error');
  }
}

function currentTracePath(preferDebug) {
  const session = latestSession || {};
  if (preferDebug) {
    return session.debug_trace_path || session.native_trace_path || '';
  }
  return session.native_trace_path || session.debug_trace_path || '';
}

async function submitValidateBackfill(candidate, modeLabel) {
  candidate = normalizeCaptchaInfo(candidate);
  if (!candidate) {
    setStatus('还没有可提交的 captcha_info', 'error');
    return;
  }
  const tracePath = currentTracePath(modeLabel === 'auto' || !!currentDebugCaptchaInfo || !!(manualCaptchaInfoInput.value || '').trim());
  if (!tracePath) {
    setStatus('缺少可用 trace path，无法回填到当前 Boss 主线', 'error');
    return;
  }
  const requestBody = { captcha_info: candidate, trace_path: tracePath };
  requestBody.session_id = (latestSession && latestSession.session_id) || '';
  requestBody.native_trace_path = (latestSession && latestSession.native_trace_path) || '';
  requestBody.debug_trace_path = (latestSession && latestSession.debug_trace_path) || '';
  validateSubmitBox.textContent = pretty({
    mode: modeLabel,
    trace_path: tracePath,
    captcha_info: candidate
  });
  setStatus(modeLabel === 'auto' ? 'auto backfilling validate...' : 'backend backfilling validate...', '');
  const result = await requestJson('/api/validate_submit', {
    method: 'POST',
    headers: { 'content-type': 'application/json' },
    body: JSON.stringify(requestBody)
  });
  validateSubmitBox.textContent = pretty(result);
  auditBox.textContent = pretty(result.audit || '');
  setStatus(
    modeLabel === 'auto' ? 'auto validate backfill finished' : 'backend validate backfill finished',
    result.validate_status === 'accepted' ? 'ok' : ''
  );
}

async function loadSession() {
  try {
    const data = await requestJson('/api/session');
    renderSession(data);
    setStatus('latest backend native session loaded', 'ok');
  } catch (_err) {
    await refreshSession();
  }
}

async function copyPayload(value, emptyText, okText) {
  if (!value || (typeof value === 'object' && Object.keys(value).length === 0)) {
    setStatus(emptyText, 'error');
    return;
  }
  await navigator.clipboard.writeText(typeof value === 'string' ? value : JSON.stringify(value, null, 2));
  setStatus(okText, 'ok');
}

document.getElementById('refreshBtn').onclick = async () => {
  await refreshSession();
};

document.getElementById('startFlowBtn').onclick = async () => {
  try {
    await refreshSession();
    const debugSession = (latestSession && latestSession.debug_session) || {};
    if (!debugSession.player_url) {
      setStatus('还没有 debug player', 'error');
      return;
    }
    setStatus('debug player opening; backfill will run after success callback', 'ok');
    window.open(debugSession.player_url, '_blank');
  } catch (err) {
    setStatus(String(err.message || err), 'error');
  }
};

document.getElementById('openDebugBtn').onclick = () => {
  const debugSession = (latestSession && latestSession.debug_session) || {};
  if (!debugSession.player_url) {
    setStatus('还没有 debug player', 'error');
    return;
  }
  window.open(debugSession.player_url, '_blank');
};

document.getElementById('copyUrlBtn').onclick = async () => {
  const debugSession = (latestSession && latestSession.debug_session) || {};
  await copyPayload(debugSession.app3_url || '', '没有可复制的 app3 url', 'debug app3 url copied');
};

document.getElementById('copyCaptchaInfoBtn').onclick = async () => {
  await copyPayload(latestSession && latestSession.captcha_info, '当前 native 侧还没有 captcha_info', 'native captcha_info copied');
};

document.getElementById('copyValidateBtn').onclick = async () => {
  await copyPayload(latestSession && latestSession.validate_template, '当前 native 侧还没有 validate template', 'native validate template copied');
};

document.getElementById('submitValidateBtn').onclick = async () => {
  let candidate = null;
  try {
    candidate = parseManualCaptchaInfo() || currentDebugCaptchaInfo || (latestSession && latestSession.captcha_info);
  } catch (err) {
    setStatus(String(err.message || err), 'error');
    return;
  }
  if (!candidate) {
    setStatus('还没有可提交的 captcha_info', 'error');
    return;
  }
  try {
    await submitValidateBackfill(candidate, 'manual');
  } catch (err) {
    validateSubmitBox.textContent = pretty({ error: String(err.message || err) });
    setStatus(String(err.message || err), 'error');
  }
};

window.addEventListener('message', (event) => {
  if (!event.data || event.data.kind !== 'gt3-capture') return;
  captureAuditSerial = captureAuditSerial
    .catch(() => {})
    .then(async () => {
      captureBox.textContent = pretty(event.data.payload || {});
      currentDebugCaptchaInfo = event.data.captcha_info || null;
      const captureAudit = await syncCaptureAudit(event.data);
      const persistedPacket = (captureAudit && captureAudit.packet) || event.data;
      captureBox.textContent = pretty((persistedPacket && persistedPacket.payload) || event.data.payload || {});
      currentDebugCaptchaInfo = (persistedPacket && persistedPacket.captcha_info) || event.data.captcha_info || null;
      if (currentDebugCaptchaInfo && !(manualCaptchaInfoInput.value || '').trim()) {
        manualCaptchaInfoInput.value = JSON.stringify(currentDebugCaptchaInfo, null, 2);
      }
      const hasSuccessToken =
        currentDebugCaptchaInfo &&
        currentDebugCaptchaInfo.challenge &&
        currentDebugCaptchaInfo.validate &&
        currentDebugCaptchaInfo.secCode;
      if (!hasSuccessToken) {
        setStatus('debug player capture updated', 'ok');
        return;
      }
      if (!captureAudit || !(captureAudit.packet && captureAudit.packet.captcha_info)) {
        setStatus('capture audit not persisted; auto backfill skipped', 'error');
        return;
      }

      const captureKey = JSON.stringify(currentDebugCaptchaInfo);
      if (autoBackfillInFlight || captureKey === lastAutoBackfillKey) {
        setStatus('debug player success captured', 'ok');
        return;
      }

      autoBackfillInFlight = true;
      lastAutoBackfillKey = captureKey;
      try {
        await submitValidateBackfill(currentDebugCaptchaInfo, 'auto');
      } catch (err) {
        validateSubmitBox.textContent = pretty({ error: String(err.message || err) });
        setStatus(String(err.message || err), 'error');
        lastAutoBackfillKey = '';
      } finally {
        autoBackfillInFlight = false;
      }
    });
});

window.addEventListener('load', loadSession);
</script>
</body>
</html>
"""


DEFAULT_EXAMPLE = {
    "bootstrap": {
        "gt": "c1c659ff7a6576d290b547c7759c7465",
        "challenge": "8a32cf74d2ed6a73cc40707491b79d6c",
        "api_server": "apiv6.geetest.com",
        "type": "fullpage",
    },
    "trace_json": json.dumps(
        {
            "host": "https://api5.zhipin.com",
            "region_code": "+44",
            "encoded_phone": "umUWRX+Hd2+IvA==",
            "device": {
                "curidentity": 0,
                "uniqid": "2636be2b-adc7-4663-843c-a3be2e1cb73c",
            },
            "start_captcha": {
                "challenge": "8a32cf74d2ed6a73cc40707491b79d6c",
                "gt": "c1c659ff7a6576d290b547c7759c7465",
                "success": 1,
            },
            "gt3_exchange": {
                "register": {
                    "api_server": "https://apiv6.geetest.com",
                    "captcha_type": "fullpage",
                    "static_server": "https://static.geetest.com",
                }
            },
            "machine_verify_activity_replay": {
                "endpoint_path": "/api/zpsecureflow/captcha/validate",
                "request_class": "MachineVerifyConfirmRequest",
            },
            "judge_request": {
                "body_form": "app_id=1003&client_info=%7B%22uniqid%22%3A%222636be2b-adc7-4663-843c-a3be2e1cb73c%22%7D&curidentity=0&phone=umUWRX%2BHd2%2BIvA%3D%3D&regionCode=%2B44&req_time=1773671466657&sig=__SIG__&sp=__SP__&uniqid=2636be2b-adc7-4663-843c-a3be2e1cb73c&v=14.010"
            },
        },
        ensure_ascii=False,
        indent=2,
    ),
}


REPO_ROOT = os.environ.get(
    "RNIDBG_CONTAINER_REPO_ROOT",
    os.path.abspath(os.path.join(os.path.dirname(__file__), "..", "..")),
)
STATE_DIR = os.environ.get("RNIDBG_GT3_WEB_STATE_DIR", "/tmp/rnidbg-gt3-web")
BACKEND_PHONE = os.environ.get("RNIDBG_GT3_WEB_PHONE", "7593791087").strip()
BACKEND_REGION = os.environ.get("RNIDBG_GT3_WEB_REGION", "+44").strip()
DEFAULT_BACKEND_RUNTIME = (
    "dynarmic"
    if os.environ.get("RNIDBG_CONTAINER_REPO_ROOT") and os.uname().sysname == "Linux"
    else "unicorn"
)
BACKEND_RUNTIME = (
    os.environ.get("RNIDBG_GT3_WEB_BACKEND", DEFAULT_BACKEND_RUNTIME).strip()
    or DEFAULT_BACKEND_RUNTIME
)
CAPTCHA_TRACE_SCRIPT = os.path.join(REPO_ROOT, "scripts", "run-boss-yzwg.sh")
LATEST_SESSION_PATH = os.path.join(STATE_DIR, "latest-session.json")
AUDIT_DIR = os.path.join(STATE_DIR, "audit")
LATEST_AUDIT_PATH = os.path.join(AUDIT_DIR, "latest-audit.json")
SESSIONS_DIR = os.path.join(STATE_DIR, "sessions")
DEFAULT_NATIVE_AJAX_MODE = (
    os.environ.get("RNIDBG_GT3_WEB_NATIVE_AJAX_MODE", "native-only").strip().lower()
    or "native-only"
)
TRUSTED_PRODUCTION_TRUTH_SOURCE_PREFIXES = (
    "production-device.",
    "boss-app.",
    "gt3-production.",
    "rnidbg.production.",
)
UNTRUSTED_PRODUCTION_TRUTH_SOURCE_TAGS = {
    "gt3-web.native_ajax",
    "gt3-web.proxy-rewrite",
    "gt3-web.manual-trajectory",
}


def normalize_native_ajax_mode(value):
    mode = (value or "").strip().lower()
    if mode in {"native-only", "prefer-native", "prefer-web"}:
        return mode
    return DEFAULT_NATIVE_AJAX_MODE


def parse_json_or_jsonp(raw: str):
    text = (raw or "").strip()
    if not text:
        raise ValueError("empty body")
    try:
        return json.loads(text)
    except json.JSONDecodeError:
        pass
    if text.startswith("(") and text.endswith(")"):
        return json.loads(text[1:-1])
    open_idx = text.find("(")
    close_idx = text.rfind(")")
    if open_idx >= 0 and close_idx > open_idx:
        return json.loads(text[open_idx + 1 : close_idx])
    raise ValueError("unsupported json/jsonp body")


def normalize_domain(value: str) -> str:
    value = (value or "").strip()
    value = value.replace("https://", "").replace("http://", "")
    return value.rstrip("/")


def fetch_text(url: str, timeout=15) -> str:
    req = urllib.request.Request(url, headers={"user-agent": "Mozilla/5.0"})
    with urllib.request.urlopen(req, timeout=timeout) as resp:
        charset = resp.headers.get_content_charset() or "utf-8"
        return resp.read().decode(charset, errors="replace")


def parse_form_body(body_form: str):
    parsed = urllib.parse.parse_qs(body_form or "", keep_blank_values=True)
    result = {}
    for key, values in parsed.items():
        result[key] = values[-1] if values else ""
    return result


def normalize_truth_json_candidate(value):
    if isinstance(value, str):
        raw = value.strip()
        if not raw:
            return {}
        try:
            value = json.loads(raw)
        except Exception:
            return {}
    if not isinstance(value, dict):
        return {}
    if isinstance(value.get("gt3_proof_truth"), dict):
        return normalize_truth_json_candidate(value.get("gt3_proof_truth"))
    if isinstance(value.get("production_proof_truth"), dict):
        return normalize_truth_json_candidate(value.get("production_proof_truth"))
    if value.get("gt") and (
        value.get("request_url")
        or value.get("w")
        or value.get("final_challenge")
        or value.get("followup_challenge")
        or value.get("bootstrap_challenge")
    ):
        return value
    return {}


def production_truth_source_tag(value):
    truth = normalize_truth_json_candidate(value)
    return str(truth.get("proof_source_tag") or "").strip()


def is_trusted_production_truth(value):
    truth = normalize_truth_json_candidate(value)
    if not truth:
        return False
    source_tag = production_truth_source_tag(truth)
    if not source_tag or source_tag in UNTRUSTED_PRODUCTION_TRUTH_SOURCE_TAGS:
        return False
    return any(
        source_tag.startswith(prefix)
        for prefix in TRUSTED_PRODUCTION_TRUTH_SOURCE_PREFIXES
    )


def normalize_truth_response_candidate(value):
    if isinstance(value, str):
        raw = value.strip()
        if not raw:
            return {}
        try:
            value = json.loads(raw)
        except Exception:
            return {}
    if not isinstance(value, dict):
        return {}
    if isinstance(value.get("gt3_proof_truth_response"), dict):
        return normalize_truth_response_candidate(value.get("gt3_proof_truth_response"))
    if isinstance(value.get("production_proof_truth_response"), dict):
        return normalize_truth_response_candidate(value.get("production_proof_truth_response"))
    if (
        isinstance(value.get("ajax_raw"), dict)
        or value.get("validate")
        or value.get("sec_code")
        or isinstance(value.get("success_callback_payload"), dict)
    ):
        return value
    return {}


def extract_session_production_truth(session_payload, require_trusted=False):
    if not isinstance(session_payload, dict):
        return {}
    candidates = [
        session_payload.get("production_proof_truth"),
        session_payload.get("production_truth_candidate"),
        session_payload.get("gt3_proof_truth"),
        ((session_payload.get("debug_session") or {}).get("production_proof_truth")),
        ((session_payload.get("debug_session") or {}).get("production_truth_candidate")),
        ((session_payload.get("debug_session") or {}).get("gt3_proof_truth")),
        (((session_payload.get("last_manual_trajectory") or {}).get("exchange") or {}).get("gt3_proof_truth")),
    ]
    for candidate in candidates:
        normalized = normalize_truth_json_candidate(candidate)
        if normalized and (not require_trusted or is_trusted_production_truth(normalized)):
            return normalized
    return {}


def extract_session_production_truth_response(session_payload):
    if not isinstance(session_payload, dict):
        return {}
    candidates = [
        session_payload.get("production_proof_truth_response"),
        session_payload.get("gt3_proof_truth_response"),
        ((session_payload.get("debug_session") or {}).get("production_proof_truth_response")),
        ((session_payload.get("debug_session") or {}).get("gt3_proof_truth_response")),
        (((session_payload.get("last_manual_trajectory") or {}).get("exchange") or {}).get("gt3_proof_truth_response")),
    ]
    for candidate in candidates:
        normalized = normalize_truth_response_candidate(candidate)
        if normalized:
            return normalized
    return {}


def truth_matches_runtime_request(truth, gt: str, challenge: str):
    truth = normalize_truth_json_candidate(truth)
    if not truth:
        return False
    expected_gt = str(truth.get("gt") or "").strip()
    if expected_gt and gt and expected_gt != gt:
        return False
    challenge = str(challenge or "").strip()
    truth_challenges = {
        str(truth.get("bootstrap_challenge") or "").strip(),
        str(truth.get("followup_challenge") or "").strip(),
        str(truth.get("final_challenge") or "").strip(),
        str(truth.get("challenge") or "").strip(),
    }
    truth_challenges.discard("")
    if challenge and truth_challenges and challenge not in truth_challenges:
        return False
    return True


def build_forward_url_from_truth(truth, callback=None):
    truth = normalize_truth_json_candidate(truth)
    request_url = str(truth.get("request_url") or "").strip()
    if not request_url:
        raise ValueError("production_proof_truth missing request_url")
    parsed = urllib.parse.urlparse(request_url)
    query = urllib.parse.parse_qs(parsed.query, keep_blank_values=True)
    if callback:
        query["callback"] = [str(callback)]
    encoded = urllib.parse.urlencode(
        [(key, value) for key, values in query.items() for value in values],
        doseq=True,
    )
    return urllib.parse.urlunparse(parsed._replace(query=encoded))


def build_app3_url(payload):
    gt = payload.get("gt", "").strip()
    challenge = payload.get("challenge", "").strip()
    api_server = normalize_domain(payload.get("api_server", "apiv6.geetest.com"))
    lang = (payload.get("lang", "zh-cn") or "zh-cn").strip()
    timeout = (payload.get("timeout", "10000") or "10000").strip()
    requested_type = (payload.get("type", "") or "").strip()

    if not gt or not challenge or not api_server:
        raise ValueError("gt/challenge/api_server are required")

    gettype_url = (
        f"https://{api_server}/gettype.php?gt={urllib.parse.quote(gt)}&t={int(time.time() * 1000)}"
    )
    gettype_body = fetch_text(gettype_url)
    gettype_json = parse_json_or_jsonp(gettype_body)
    gettype_data = gettype_json.get("data") or {}
    resolved_type = requested_type or gettype_data.get("type") or "fullpage"
    js_path = (gettype_data.get(resolved_type) or "").strip()
    if not js_path:
        raise ValueError(f"gettype missing js path for type={resolved_type}")

    static_servers = [
        normalize_domain(item)
        for item in (gettype_data.get("static_servers") or [])
        if isinstance(item, str) and normalize_domain(item)
    ]
    if not static_servers:
        static_servers = ["static.geetest.com"]

    pairs = [
        f"gt={gt}",
        f"challenge={challenge}",
        f"lang={lang}",
        "title=",
        f"type={resolved_type}",
        f"api_server={api_server}",
        f"static_servers={','.join(static_servers)}",
        "width=100%",
        f"timeout={timeout}",
        "debug=false",
        f"{resolved_type}={js_path}",
    ]
    aspect_radio = gettype_data.get("aspect_radio") or {}
    if isinstance(aspect_radio, dict):
        for key, value in aspect_radio.items():
            pairs.append(f"aspect_radio_{key}={value}")

    app3_url = (
        f"https://{static_servers[0]}/static/appweb/app3-index.html?{'&'.join(pairs)}"
    )
    return {
        "ok": True,
        "app3_url": app3_url,
        "bootstrap": {
            "gt": gt,
            "challenge": challenge,
            "api_server": api_server,
            "type": resolved_type,
            "js_path": js_path,
            "static_servers": static_servers,
            "gettype_url": gettype_url,
        },
        "gettype_data": gettype_data,
    }


def build_from_trace(payload):
    raw = (payload.get("trace_json") or "").strip()
    if not raw:
        raise ValueError("trace_json is required")
    trace = json.loads(raw)
    start = trace.get("start_captcha") or {}
    register = ((trace.get("gt3_exchange") or {}).get("register") or {})
    return build_app3_url(
        {
            "gt": start.get("gt", ""),
            "challenge": start.get("challenge", ""),
            "api_server": register.get("api_server", "apiv6.geetest.com"),
            "type": register.get("captcha_type", ""),
            "lang": payload.get("lang", "zh-cn"),
            "timeout": payload.get("timeout", "10000"),
        }
    )


def build_validate_template(payload):
    captcha_info = payload.get("captcha_info") or {}
    if not captcha_info:
        raise ValueError("captcha_info is required")

    raw_trace = (payload.get("trace_json") or "").strip()
    trace = json.loads(raw_trace) if raw_trace else {}

    host = (trace.get("host") or "https://api5.zhipin.com").rstrip("/")
    replay = trace.get("machine_verify_activity_replay") or {}
    endpoint_path = replay.get("endpoint_path") or "/api/zpsecureflow/captcha/validate"
    endpoint_url = f"{host}{endpoint_path}"

    reference_form = {}
    for field in ("validate_request", "machine_request", "judge_request"):
        body_form = ((trace.get(field) or {}).get("body_form") or "").strip()
        if body_form:
            reference_form = parse_form_body(body_form)
            break

    client_info = reference_form.get("client_info")
    curidentity = reference_form.get("curidentity")
    uniqid = reference_form.get("uniqid")
    v_value = reference_form.get("v")

    if not client_info:
        device = trace.get("device") or {}
        uniqid = uniqid or device.get("uniqid")
        client_info = json.dumps(
            {
                "uniqid": uniqid or "",
            },
            ensure_ascii=False,
            separators=(",", ":"),
        )
    if curidentity is None:
        curidentity = str((trace.get("device") or {}).get("curidentity", 0))
    if uniqid is None:
        uniqid = (trace.get("device") or {}).get("uniqid", "")
    if v_value is None:
        v_value = "14.010"

    captcha_info_raw = json.dumps(captcha_info, ensure_ascii=False, separators=(",", ":"))
    business_fields = {
        "captcha_info": captcha_info_raw,
    }
    signed_fields = {
        "app_id": "1003",
        "client_info": client_info,
        "curidentity": str(curidentity),
        "req_time": "{{req_time_ms}}",
        "uniqid": uniqid,
        "v": v_value,
        "captcha_info": captcha_info_raw,
        "sp": "{{sp}}",
        "sig": "{{sig}}",
    }

    curl_parts = []
    for key in (
        "app_id",
        "client_info",
        "curidentity",
        "req_time",
        "uniqid",
        "v",
        "captcha_info",
        "sp",
        "sig",
    ):
        value = signed_fields[key]
        curl_parts.append(f"{key}={urllib.parse.quote(str(value), safe='')}")

    return {
        "ok": True,
        "request_class": replay.get("request_class") or "MachineVerifyConfirmRequest",
        "endpoint_path": endpoint_path,
        "endpoint_url": endpoint_url,
        "method": "POST",
        "business_fields": business_fields,
        "signed_form_template": signed_fields,
        "curl_template": "curl -X POST '{url}' -H 'content-type: application/x-www-form-urlencoded' --data '{body}'".format(
            url=endpoint_url,
            body="&".join(curl_parts),
        ),
        "notes": [
            "This is a contract template for Boss /captcha/validate, not a fully signed replay.",
            "sp/sig still need the same signer path used by rnidbg boss-yzwg captcha-trace.",
            "captcha_info matches the APK MachineVerifyActivity.Re(String) payload shape.",
        ],
    }


def build_optional_validate_template(trace_text: str, trace: dict):
    captcha_info = trace.get("captcha_info")
    if not isinstance(captcha_info, dict) or not captcha_info:
        return None
    try:
        return build_validate_template(
            {
                "trace_json": trace_text,
                "captcha_info": captcha_info,
            }
        )
    except Exception as exc:
        return {"ok": False, "error": str(exc)}


def build_backend_validation(trace: dict):
    real_observation = trace.get("real_observation") or {}
    gt3_exchange = trace.get("gt3_exchange") or {}
    return {
        "backend_runtime": BACKEND_RUNTIME,
        "status": trace.get("status"),
        "provider": trace.get("provider"),
        "captcha_type": trace.get("captcha_type"),
        "captcha_name": trace.get("captcha_name"),
        "gt3_exchange_status": gt3_exchange.get("status"),
        "validate_status": trace.get("validate_status"),
        "validate_submitted": real_observation.get("validate_submitted"),
        "judge_code": real_observation.get("judge_code"),
        "judge_message": real_observation.get("judge_message"),
        "machine_code": real_observation.get("machine_code"),
        "machine_message": real_observation.get("machine_message"),
        "start_captcha": trace.get("start_captcha"),
        "real_observation": real_observation,
    }


def rebuild_app3_url_from_query(parsed_query: str):
    params = urllib.parse.parse_qs(parsed_query, keep_blank_values=True)
    flat = {key: values[-1] if values else "" for key, values in params.items()}
    static_servers = flat.get("static_servers", "")
    host = "static.geetest.com"
    if static_servers:
        host = normalize_domain(static_servers.split(",")[0]) or host
    return f"https://{host}/static/appweb/app3-index.html?{parsed_query}"


def extract_trace_bootstrap(trace_text: str):
    trace = json.loads(trace_text)
    start = trace.get("start_captcha") or {}
    register = ((trace.get("gt3_exchange") or {}).get("register") or {})
    return {
        "gt": start.get("gt", ""),
        "challenge": start.get("challenge", ""),
        "api_server": normalize_domain(register.get("api_server", "apiv6.geetest.com")),
        "type": register.get("captcha_type", ""),
    }


def find_latest_trace_file():
    env_path = os.environ.get("RNIDBG_GT3_WEB_EXAMPLE_FILE", "").strip()
    if env_path and os.path.isfile(env_path):
        return env_path

    candidate_roots = [
        "/workspace/host-tmp",
        "/workspace/lab-assets/artifacts/bosszhipin-reverse-project/rnidbg-trace",
        "/workspace/rnidbg",
    ]
    patterns = [
        "captcha-trace*.json",
        "*captcha-trace*.json",
    ]

    matches = []
    for root in candidate_roots:
        if not os.path.isdir(root):
            continue
        for pattern in patterns:
            matches.extend(glob.glob(os.path.join(root, "**", pattern), recursive=True))

    valid = []
    stdout_fallback = []
    for path in matches:
        try:
            with open(path, "r", encoding="utf-8") as fh:
                text = fh.read()
            bootstrap = extract_trace_bootstrap(text)
            if bootstrap["gt"] and bootstrap["challenge"]:
                record = (os.path.getmtime(path), path, bootstrap, text)
                if ".stdout." in path:
                    stdout_fallback.append(record)
                else:
                    valid.append(record)
        except Exception:
            continue

    if not valid:
        valid = stdout_fallback
    if not valid:
        return None
    valid.sort(key=lambda item: item[0], reverse=True)
    _, path, bootstrap, text = valid[0]
    return {
        "ok": True,
        "source": path,
        "trace_json": text,
        "bootstrap": bootstrap,
    }


def load_example():
    latest = find_latest_trace_file()
    if latest:
        return latest
    return {"ok": True, "source": "built-in-example", **DEFAULT_EXAMPLE}


def mask_phone(phone: str) -> str:
    digits = "".join(ch for ch in str(phone or "") if ch.isdigit())
    if len(digits) < 7:
        return digits or ""
    return f"{digits[:3]}****{digits[-4:]}"


def ensure_state_dir():
    os.makedirs(STATE_DIR, exist_ok=True)
    os.makedirs(AUDIT_DIR, exist_ok=True)
    os.makedirs(SESSIONS_DIR, exist_ok=True)


def relationship_status(lhs: str, rhs: str) -> str:
    lhs = (lhs or "").strip()
    rhs = (rhs or "").strip()
    if not lhs or not rhs:
        return "missing"
    if lhs == rhs:
        return "exact"
    if lhs.startswith(rhs) or rhs.startswith(lhs):
        return "prefix"
    return "different"


def audit_findings(analysis: dict):
    findings = []
    relation = analysis.get("relations") or {}
    trace_paths = analysis.get("trace_paths") or {}
    submit = analysis.get("submit") or {}
    capture = analysis.get("capture") or {}
    intercept = analysis.get("intercept") or {}
    expected_type = analysis.get("expected_captcha_type")
    if (
        relation.get("capture_vs_native_start") == "different"
        and relation.get("capture_vs_debug_start") in ("exact", "prefix")
        and trace_paths.get("submit_trace_kind") == "native"
    ):
        findings.append(
            "Captured callback challenge aligns with debug trace, but validate backfill reused native trace."
        )
    if (
        relation.get("capture_vs_debug_followup") in ("exact", "prefix")
        and relation.get("capture_vs_native_start") == "different"
    ):
        findings.append(
            "Captured callback challenge looks like the debug follow-up challenge variant, not the native trace startCaptcha challenge."
        )
    validate_status = submit.get("validate_status")
    if isinstance(validate_status, dict) and validate_status.get("state") == "rejected":
        findings.append("Boss validate request reached the server, but the submitted captcha_info was rejected.")
    if submit.get("verdict") == "no-response":
        findings.append("Boss validate response was not observed; this looks like a transport/control-plane interruption.")
    if expected_type is not None and capture.get("captcha_info_present") and capture.get("type") != expected_type:
        findings.append(
            f"Captured callback captcha_info.type ({capture.get('type')}) differs from trace captcha_type ({expected_type})."
        )
    if expected_type is not None and submit.get("submitted") and submit.get("type") != expected_type:
        findings.append(
            f"Submitted captcha_info.type ({submit.get('type')}) differs from trace captcha_type ({expected_type})."
        )
    if capture.get("captcha_info_present") and not intercept.get("native_w_injected"):
        findings.append("Front-end success callback was observed, but no native-w interception event was recorded.")
    if intercept.get("native_w_injected") and not capture.get("captcha_info_present"):
        findings.append("Native-w interception was recorded, but Geetest failed before returning a success callback.")
    if not intercept.get("truth_present"):
        findings.append("Production GT3 proof truth was not captured for this solve, so the result is not submission-qualified.")
    elif intercept.get("truth_matches_runtime_request") is False:
        findings.append("Captured production GT3 proof truth does not match the runtime ajax request challenge/gt.")
    if capture.get("captcha_info_present") and submit.get("submitted") is False:
        findings.append("Front-end success callback was observed, but no validate backfill was sent afterward.")
    return findings


def normalize_captcha_info(candidate):
    if not isinstance(candidate, dict):
        return {}
    normalized = {
        "type": coerce_captcha_type(candidate.get("type"), default=-1),
        "challenge": str(candidate.get("challenge") or ""),
        "validate": str(candidate.get("validate") or ""),
        "secCode": str(candidate.get("secCode") or ""),
    }
    if not any(normalized.get(key) for key in ("challenge", "validate", "secCode")):
        return {}
    return normalized


def derive_captcha_info_from_payload(packet, session=None):
    if isinstance(packet.get("captcha_info"), dict):
        info = packet["captcha_info"]
        if any(info.get(key) for key in ("challenge", "validate", "secCode")):
            return info
    payload = packet.get("payload") or {}
    events = payload.get("events") or []
    for event in reversed(events):
        if not isinstance(event, dict):
            continue
        if event.get("fn") != "gtCallBack":
            continue
        payload_data = event.get("payload")
        if not isinstance(payload_data, dict):
            continue
        result = payload_data.get("result") or {}
        if not isinstance(result, dict):
            continue
        challenge = result.get("geetest_challenge") or result.get("challenge")
        validate = result.get("geetest_validate") or result.get("validate")
        sec_code = result.get("geetest_seccode") or result.get("secCode")
        if not (challenge and validate and sec_code):
            continue
        expected_type = coerce_captcha_type(
            (
                (session or {}).get("debug_session") or {}
            ).get("ticket", {}).get("captcha_type"),
            default=1,
        )
        return {
            "type": expected_type,
            "challenge": str(challenge),
            "validate": str(validate),
            "secCode": str(sec_code),
        }
    return None


def derive_app3_query_params(app3_url: str) -> dict:
    if not app3_url:
        return {}
    try:
        parsed = urllib.parse.urlparse(app3_url)
        return {key: value[-1] for key, value in urllib.parse.parse_qs(parsed.query).items()}
    except Exception:
        return {}


def classify_submit_verdict(submit_result):
    if not isinstance(submit_result, dict) or not submit_result:
        return "no-response"
    validate_status = submit_result.get("validate_status")
    if isinstance(validate_status, str):
        lowered = validate_status.strip().lower()
        if lowered in ("accepted", "ok", "success", "passed"):
            return "accepted"
        if lowered in ("rejected", "reject", "failed", "failure"):
            return "rejected"
    if isinstance(validate_status, dict):
        state = str(validate_status.get("state") or "").strip().lower()
        if state == "accepted":
            return "accepted"
        if state == "rejected":
            return "rejected"
        code = validate_status.get("code")
        if code == 0:
            return "accepted"
        if isinstance(code, int) and code != 0:
            return "rejected"
    validate_response = submit_result.get("validate_response")
    if isinstance(validate_response, dict):
        code = validate_response.get("code")
        if code == 0:
            return "accepted"
        if isinstance(code, int):
            return "rejected"
    return "no-response"


def extract_java_probe_captcha_info(session_payload=None, capture_packet=None, submit_result=None):
    session_payload = session_payload or {}
    capture_packet = capture_packet or {}
    submit_result = submit_result or {}
    session_probe = session_payload.get("java_probe") if isinstance(session_payload, dict) else {}
    candidates = [
        (session_probe or {}).get("captcha_info"),
        ((session_probe or {}).get("summary") or {}).get("captcha_info"),
        capture_packet.get("java_probe_captcha_info"),
        (capture_packet.get("java_probe") or {}).get("captcha_info"),
        (capture_packet.get("payload") or {}).get("java_probe_captcha_info"),
        ((capture_packet.get("payload") or {}).get("java_probe") or {}).get("captcha_info"),
        submit_result.get("java_probe_captcha_info"),
        (submit_result.get("java_probe") or {}).get("captcha_info"),
    ]
    for candidate in candidates:
        if isinstance(candidate, str):
            try:
                candidate = json.loads(candidate)
            except Exception:
                continue
        info = normalize_captcha_info(candidate)
        if info.get("challenge") or info.get("validate") or info.get("secCode"):
            return info
    return {}


def infer_layer_status(observed: bool, healthy: bool):
    if not observed:
        return "missing"
    if healthy:
        return "ok"
    return "degraded"


def build_audit_analysis(session_payload=None, capture_packet=None, submit_result=None, submit_trace_path=None):
    session_payload = session_payload or {}
    debug_session = session_payload.get("debug_session") or {}
    backend_validation = session_payload.get("backend_validation") or {}
    debug_ticket = debug_session.get("ticket") or {}
    expected_captcha_type = coerce_captcha_type(
        debug_ticket.get("captcha_type"),
        default=coerce_captcha_type(backend_validation.get("captcha_type"), default=1),
    )
    native_trace_path = (session_payload.get("native_trace_path") or "").strip()
    debug_trace_path = (session_payload.get("debug_trace_path") or "").strip()
    native_start = (backend_validation.get("start_captcha") or {})
    debug_start = debug_ticket.get("start_captcha") or {}
    native_prewarm = debug_session.get("native_prewarm") or session_payload.get("native_prewarm") or {}
    followup = native_prewarm.get("followup_get_raw") or {}
    packet = capture_packet or {}
    packet_payload = packet.get("payload") or {}
    packet_events = packet_payload.get("events") or []
    captured_info = normalize_captcha_info(packet.get("captcha_info") or {})
    submitted_info = normalize_captcha_info((submit_result or {}).get("captcha_info") or {})
    java_probe_info = extract_java_probe_captcha_info(
        session_payload=session_payload, capture_packet=packet, submit_result=submit_result
    )
    intercept_events = [
        evt for evt in packet_events if isinstance(evt, dict) and evt.get("fn") == "gtNativeAjaxW"
    ]
    last_intercept_payload = {}
    if intercept_events and isinstance(intercept_events[-1].get("payload"), dict):
        last_intercept_payload = intercept_events[-1].get("payload") or {}
    ajax_debug = packet.get("ajax_debug") if isinstance(packet.get("ajax_debug"), dict) else {}
    intercept_debug = packet.get("intercept_debug") if isinstance(packet.get("intercept_debug"), dict) else {}
    production_truth = extract_session_production_truth(session_payload, require_trusted=True)
    production_truth_response = (
        extract_session_production_truth_response(session_payload) if production_truth else {}
    )
    submit_trace_path = (submit_trace_path or (submit_result or {}).get("trace_path") or "").strip()
    verdict = classify_submit_verdict(submit_result)

    if submit_trace_path == native_trace_path and native_trace_path:
        submit_trace_kind = "native"
    elif submit_trace_path == debug_trace_path and debug_trace_path:
        submit_trace_kind = "debug"
    elif submit_trace_path:
        submit_trace_kind = "other"
    else:
        submit_trace_kind = "missing"

    analysis = {
        "session_id": session_payload.get("session_id"),
        "expected_captcha_type": expected_captcha_type,
        "capture": {
            "captcha_info_present": bool(captured_info),
            "type": coerce_captcha_type(captured_info.get("type"), default=-1),
            "challenge": captured_info.get("challenge", ""),
            "validate": captured_info.get("validate", ""),
            "secCode": captured_info.get("secCode", ""),
            "event_count": len(packet_events),
        },
        "submit": {
            "submitted": bool(submit_result),
            "trace_path": submit_trace_path,
            "trace_kind": submit_trace_kind,
            "type": coerce_captcha_type(submitted_info.get("type"), default=-1),
            "challenge": submitted_info.get("challenge", ""),
            "validate_status": (submit_result or {}).get("validate_status"),
            "result_path": (submit_result or {}).get("result_path"),
            "verdict": verdict,
        },
        "java_probe": {
            "present": bool(java_probe_info),
            "type": java_probe_info.get("type", -1),
            "challenge": java_probe_info.get("challenge", ""),
        },
        "intercept": {
            "native_w_injected": bool(intercept_events) or bool(ajax_debug.get("native_w_present")),
            "events_seen": len(intercept_events),
            "sources_seen": intercept_debug.get("sources_seen") or [
                (evt.get("payload") or {}).get("source", "") for evt in intercept_events if isinstance(evt, dict)
            ],
            "last_source": ajax_debug.get("source")
            or intercept_debug.get("last_source")
            or last_intercept_payload.get("source", ""),
            "w_len": ajax_debug.get("w_len")
            or intercept_debug.get("w_len")
            or last_intercept_payload.get("w_len", 0),
            "point_count": ajax_debug.get("point_count")
            or intercept_debug.get("point_count")
            or last_intercept_payload.get("point_count", 0),
            "replaced_url_present": bool(ajax_debug.get("replaced_url") or intercept_debug.get("replaced_url_present")),
            "ajax_mode": ajax_debug.get("ajax_mode") or "",
            "proxy_selected_mode": ajax_debug.get("proxy_selected_mode") or "",
            "proxy_status": ajax_debug.get("proxy_status") or "",
            "proxy_error_code": ajax_debug.get("proxy_error_code") or "",
            "proxy_attempts": ajax_debug.get("proxy_attempts") or [],
            "truth_present": bool(production_truth),
            "truth_source": ajax_debug.get("truth_source")
            or ((session_payload.get("last_proxy_ajax") or {}).get("truth_source"))
            or ((session_payload.get("production_truth_probe") or {}).get("source", "")),
            "truth_client_type": str(production_truth.get("client_type") or ""),
            "truth_pt": str(production_truth.get("pt") or ""),
            "truth_w_length": production_truth.get("w_length") or len(str(production_truth.get("w") or "")),
            "truth_matches_runtime_request": bool(ajax_debug.get("truth_matches_runtime_request")),
            "truth_response_present": bool(production_truth_response),
        },
        "challenges": {
            "native_start": native_start.get("challenge", ""),
            "debug_start": debug_start.get("challenge", ""),
            "debug_followup": followup.get("challenge", ""),
            "capture": captured_info.get("challenge", ""),
            "submit": submitted_info.get("challenge", ""),
            "java_probe": java_probe_info.get("challenge", ""),
        },
        "trace_paths": {
            "native_trace_path": native_trace_path,
            "debug_trace_path": debug_trace_path,
            "submit_trace_path": submit_trace_path,
            "submit_trace_kind": submit_trace_kind,
        },
        "relations": {
            "capture_vs_native_start": relationship_status(
                captured_info.get("challenge", ""), native_start.get("challenge", "")
            ),
            "capture_vs_debug_start": relationship_status(
                captured_info.get("challenge", ""), debug_start.get("challenge", "")
            ),
            "capture_vs_debug_followup": relationship_status(
                captured_info.get("challenge", ""), followup.get("challenge", "")
            ),
            "submit_vs_native_start": relationship_status(
                submitted_info.get("challenge", ""), native_start.get("challenge", "")
            ),
            "submit_vs_debug_start": relationship_status(
                submitted_info.get("challenge", ""), debug_start.get("challenge", "")
            ),
            "submit_vs_debug_followup": relationship_status(
                submitted_info.get("challenge", ""), followup.get("challenge", "")
            ),
            "submit_vs_capture": relationship_status(
                submitted_info.get("challenge", ""), captured_info.get("challenge", "")
            ),
            "submit_vs_java_probe": relationship_status(
                submitted_info.get("challenge", ""), java_probe_info.get("challenge", "")
            ),
            "capture_vs_java_probe": relationship_status(
                captured_info.get("challenge", ""), java_probe_info.get("challenge", "")
            ),
        },
    }
    observation_observed = analysis["capture"]["captcha_info_present"] or analysis["submit"]["submitted"]
    observation_healthy = analysis["capture"]["captcha_info_present"] and analysis["submit"]["submitted"]
    control_observed = bool(session_payload.get("session_id")) and bool(submit_trace_path)
    control_healthy = bool(session_payload.get("session_id")) and submit_trace_kind in ("debug", "native")
    data_observed = analysis["submit"]["submitted"]
    data_healthy = verdict == "accepted"
    analysis["layers"] = {
        "observation": {
            "status": infer_layer_status(observation_observed, observation_healthy),
            "capture_seen": analysis["capture"]["captcha_info_present"],
            "submit_seen": analysis["submit"]["submitted"],
        },
        "control": {
            "status": infer_layer_status(control_observed, control_healthy),
            "session_id": session_payload.get("session_id"),
            "submit_trace_kind": submit_trace_kind,
            "submit_trace_path": submit_trace_path,
            "trace_binding_ok": submit_trace_kind in ("debug", "native"),
        },
        "data": {
            "status": infer_layer_status(data_observed, data_healthy),
            "latest_submit_verdict": verdict,
            "submit_vs_capture": analysis["relations"]["submit_vs_capture"],
            "submit_vs_java_probe": analysis["relations"]["submit_vs_java_probe"],
        },
    }
    analysis["findings"] = audit_findings(analysis)
    return analysis


def write_audit_event(kind: str, payload: dict):
    ensure_state_dir()
    now_ms = int(time.time() * 1000)
    path = os.path.join(AUDIT_DIR, f"{kind}-{now_ms}.json")
    atomic_write_json(path, payload)
    return path


def load_latest_audit():
    if not os.path.isfile(LATEST_AUDIT_PATH):
        return load_latest_audit_event_file()
    try:
        with open(LATEST_AUDIT_PATH, "r", encoding="utf-8") as fh:
            return json.load(fh)
    except Exception:
        return load_latest_audit_event_file()


def save_latest_audit(payload: dict):
    ensure_state_dir()
    atomic_write_json(LATEST_AUDIT_PATH, payload)
    return payload


def ensure_session_defaults(session_payload: dict):
    if not isinstance(session_payload, dict):
        return session_payload
    session_id = str(session_payload.get("session_id") or "").strip()
    control = session_payload.get("control") if isinstance(session_payload.get("control"), dict) else {}
    control_defaults = {
        "capture_event_path": None,
        "submit_event_path": None,
        "latest_audit_path": None,
        "last_capture_ts_ms": None,
        "last_java_probe_ts_ms": None,
        "last_java_probe_path": None,
        "last_java_probe_ok": False,
        "last_submit_ts_ms": None,
        "last_submit_trace_path": None,
        "last_submit_trace_kind": None,
        "last_submit_verdict": "no-response",
        "last_submit_result_path": None,
        "last_submit_validate_status": None,
    }
    for key, default in control_defaults.items():
        control.setdefault(key, default)
    session_payload["control"] = control
    if not isinstance(session_payload.get("java_probe"), dict):
        session_payload["java_probe"] = {
            "ok": False,
            "source": "none",
            "session_id": session_id,
            "ts_ms": None,
            "path": None,
            "captcha_info": {},
        }
    if not isinstance(session_payload.get("production_proof_truth"), dict):
        session_payload["production_proof_truth"] = {}
    if not isinstance(session_payload.get("production_proof_truth_response"), dict):
        session_payload["production_proof_truth_response"] = {}
    if not isinstance(session_payload.get("production_truth_candidate"), dict):
        session_payload["production_truth_candidate"] = {}
    if not isinstance(session_payload.get("production_truth_candidate_response"), dict):
        session_payload["production_truth_candidate_response"] = {}
    if not isinstance(session_payload.get("last_proxy_ajax"), dict):
        session_payload["last_proxy_ajax"] = {}
    return session_payload


def load_latest_session():
    if not os.path.isfile(LATEST_SESSION_PATH):
        return None
    try:
        with open(LATEST_SESSION_PATH, "r", encoding="utf-8") as fh:
            return ensure_session_defaults(json.load(fh))
    except Exception:
        return None


def session_file_path(session_id: str):
    return os.path.join(SESSIONS_DIR, f"session-{session_id}.json")


def load_session_by_id(session_id: str):
    if not session_id:
        return None
    path = session_file_path(session_id)
    if not os.path.isfile(path):
        return None
    try:
        with open(path, "r", encoding="utf-8") as fh:
            return ensure_session_defaults(json.load(fh))
    except Exception:
        return None


def save_session(session_payload: dict, force_latest=False):
    ensure_state_dir()
    session_payload = ensure_session_defaults(session_payload)
    session_id = str(session_payload.get("session_id") or "").strip()
    if not session_id:
        raise ValueError("session payload missing session_id")
    atomic_write_json(session_file_path(session_id), session_payload)
    latest = load_latest_session() or {}
    if force_latest or latest.get("session_id") == session_id:
        atomic_write_json(LATEST_SESSION_PATH, session_payload)
    return session_payload


def resolve_session(payload_session_id=None):
    requested_id = str(payload_session_id or "").strip()
    if requested_id:
        session = load_session_by_id(requested_id)
        if not session:
            latest = load_latest_session() or {}
            if str(latest.get("session_id") or "") == requested_id:
                session = latest
        if not session:
            raise ValueError(f"unknown session_id: {requested_id}")
        return session
    session = load_latest_session()
    if session:
        return session
    return prepare_backend_session(force=False)


def load_latest_audit_event_file():
    paths = sorted(
        glob.glob(os.path.join(AUDIT_DIR, "*.json")),
        key=os.path.getmtime,
        reverse=True,
    )
    for path in paths:
        if os.path.abspath(path) == os.path.abspath(LATEST_AUDIT_PATH):
            continue
        try:
            with open(path, "r", encoding="utf-8") as fh:
                return json.load(fh)
        except Exception:
            continue
    return None


def score_capture_packet(packet, submitted_info):
    info = normalize_captcha_info((packet or {}).get("captcha_info") or {})
    if not info:
        return -1
    score = 1
    submitted = normalize_captcha_info(submitted_info or {})
    if submitted:
        if info.get("challenge") and info.get("challenge") == submitted.get("challenge"):
            score += 10
        if info.get("validate") and info.get("validate") == submitted.get("validate"):
            score += 5
        if info.get("secCode") and info.get("secCode") == submitted.get("secCode"):
            score += 5
    return score


def select_capture_packet_for_submit(session_id, submitted_info, session_packet=None, latest_audit=None):
    best_packet = session_packet if isinstance(session_packet, dict) else None
    best_score = score_capture_packet(best_packet, submitted_info)

    if isinstance(latest_audit, dict) and str(latest_audit.get("session_id") or "") == str(session_id or ""):
        latest_packet = latest_audit.get("packet")
        latest_score = score_capture_packet(latest_packet, submitted_info)
        if latest_score > best_score:
            best_packet = latest_packet
            best_score = latest_score

    capture_paths = sorted(
        glob.glob(os.path.join(AUDIT_DIR, "capture-*.json")),
        key=os.path.getmtime,
        reverse=True,
    )
    for path in capture_paths[:20]:
        try:
            with open(path, "r", encoding="utf-8") as fh:
                event = json.load(fh)
        except Exception:
            continue
        if str(event.get("session_id") or "") != str(session_id or ""):
            continue
        packet = event.get("packet")
        packet_score = score_capture_packet(packet, submitted_info)
        if packet_score > best_score:
            best_packet = packet
            best_score = packet_score
            if packet_score >= 21:
                break
    return best_packet


def atomic_write_json(path: str, payload: dict):
    parent = os.path.dirname(path) or "."
    os.makedirs(parent, exist_ok=True)
    fd, tmp_path = tempfile.mkstemp(prefix=".tmp-audit-", suffix=".json", dir=parent)
    try:
        with os.fdopen(fd, "w", encoding="utf-8") as fh:
            json.dump(payload, fh, ensure_ascii=False, indent=2)
            fh.flush()
            os.fsync(fh.fileno())
        os.replace(tmp_path, path)
    finally:
        if os.path.exists(tmp_path):
            os.unlink(tmp_path)


def record_capture_event(payload: dict):
    session = resolve_session(payload.get("session_id"))
    packet = payload.get("packet") or {}
    discovered_info = derive_captcha_info_from_payload(packet, session)
    if discovered_info:
        packet["captcha_info"] = discovered_info
    proxy_debug = session.get("last_proxy_ajax") if isinstance(session.get("last_proxy_ajax"), dict) else {}
    if proxy_debug:
        ajax_debug = packet.get("ajax_debug") if isinstance(packet.get("ajax_debug"), dict) else {}
        ajax_debug.update(
            {
                "ajax_mode": proxy_debug.get("ajax_mode"),
                "proxy_attempts": proxy_debug.get("proxy_attempts") or [],
                "proxy_selected_mode": proxy_debug.get("proxy_selected_mode"),
                "proxy_status": proxy_debug.get("proxy_status"),
                "proxy_error_code": proxy_debug.get("proxy_error_code"),
                "truth_present": bool(proxy_debug.get("truth_present")),
                "truth_source": proxy_debug.get("truth_source"),
                "truth_client_type": proxy_debug.get("truth_client_type"),
                "truth_pt": proxy_debug.get("truth_pt"),
                "truth_w_length": proxy_debug.get("truth_w_length"),
                "truth_matches_runtime_request": proxy_debug.get("truth_matches_runtime_request"),
            }
        )
        packet["ajax_debug"] = ajax_debug
    session_id = str(session.get("session_id") or "")
    provided_native = (payload.get("native_trace_path") or "").strip()
    provided_debug = (payload.get("debug_trace_path") or "").strip()
    native_trace_path = (session.get("native_trace_path") or "").strip()
    debug_trace_path = (session.get("debug_trace_path") or "").strip()
    if provided_native and native_trace_path and provided_native != native_trace_path:
        raise ValueError("native_trace_path mismatch for current session")
    if provided_debug and debug_trace_path and provided_debug != debug_trace_path:
        raise ValueError("debug_trace_path mismatch for current session")
    captured_info = normalize_captcha_info(packet.get("captcha_info") or {})
    java_probe = session.get("java_probe") if isinstance(session.get("java_probe"), dict) else None
    if captured_info.get("challenge"):
        java_probe = build_session_java_probe(
            session,
            captured_info,
            source="capture_event",
        )
        packet["java_probe"] = {
            "ok": bool(java_probe.get("ok")),
            "source": java_probe.get("source"),
            "path": java_probe.get("path"),
            "captcha_info": java_probe.get("captcha_info") or {},
        }
        if java_probe.get("captcha_info"):
            packet["java_probe_captcha_info"] = java_probe.get("captcha_info") or {}
        session["java_probe"] = java_probe
    analysis = build_audit_analysis(session_payload=session, capture_packet=packet)
    now_ms = int(time.time() * 1000)
    event = {
        "ok": True,
        "kind": "capture",
        "ts_ms": now_ms,
        "session_id": session_id,
        "native_trace_path": native_trace_path,
        "debug_trace_path": debug_trace_path,
        "packet": packet,
        "audit": analysis,
    }
    event["event_path"] = write_audit_event("capture", event)
    save_latest_audit(event)
    control = session.get("control") if isinstance(session.get("control"), dict) else {}
    control.update(
        {
            "capture_event_path": event["event_path"],
            "latest_audit_path": event["event_path"],
            "last_capture_ts_ms": now_ms,
            "last_java_probe_ts_ms": (java_probe or {}).get("ts_ms"),
            "last_java_probe_path": (java_probe or {}).get("path"),
            "last_java_probe_ok": bool((java_probe or {}).get("ok")),
        }
    )
    session["control"] = control
    session["audit"] = analysis
    session["latest_audit"] = {
        "kind": "capture",
        "ts_ms": now_ms,
        "event_path": event["event_path"],
        "audit": analysis,
    }
    session["latest_audit_event_path"] = event["event_path"]
    session["last_capture_packet"] = packet
    save_session(session, force_latest=False)
    return event


def run_backend_command(args, timeout=300):
    env = os.environ.copy()
    env["RNIDBG_CONTAINER_REPO_ROOT"] = REPO_ROOT
    proc = subprocess.run(
        args,
        cwd=REPO_ROOT,
        env=env,
        capture_output=True,
        text=True,
        timeout=timeout,
    )
    if proc.returncode != 0:
        stderr = (proc.stderr or "").strip()
        stdout = (proc.stdout or "").strip()
        detail = stderr or stdout or f"exit={proc.returncode}"
        raise RuntimeError(detail)
    return proc


def compact_json(value):
    return json.dumps(value, ensure_ascii=False, separators=(",", ":"))


def parse_backend_json_output(stdout_text: str):
    text = (stdout_text or "").strip()
    if not text:
        raise ValueError("backend command returned empty stdout")
    try:
        return json.loads(text)
    except Exception:
        pass
    lines = [line.strip() for line in text.splitlines() if line.strip()]
    for candidate in reversed(lines):
        try:
            return json.loads(candidate)
        except Exception:
            continue
    raise ValueError("failed to parse backend stdout as json")


def captcha_info_to_dialog_result(captcha_info: dict):
    info = normalize_captcha_info(captcha_info)
    return {
        "geetest_challenge": info.get("challenge", ""),
        "geetest_validate": info.get("validate", ""),
        "geetest_seccode": info.get("secCode", ""),
    }


def build_session_java_probe(session_payload: dict, captcha_info: dict, source: str):
    session_id = str((session_payload or {}).get("session_id") or "").strip()
    if not session_id:
        raise ValueError("session payload missing session_id for java_probe")
    info = normalize_captcha_info(captcha_info)
    now_ms = int(time.time() * 1000)
    probe_path = os.path.join(STATE_DIR, f"java-probe-{session_id}-{now_ms}.json")
    summary = {
        "ok": False,
        "source": source,
        "session_id": session_id,
        "ts_ms": now_ms,
        "path": probe_path,
        "captcha_info": {},
    }
    if not info.get("challenge"):
        summary["reason"] = "missing_challenge"
        atomic_write_json(probe_path, summary)
        return summary

    expected_type = coerce_captcha_type(
        info.get("type"),
        default=coerce_captcha_type(
            ((session_payload.get("debug_session") or {}).get("ticket") or {}).get("captcha_type"),
            default=1,
        ),
    )
    dialog_result = captcha_info_to_dialog_result(info)
    summary["captcha_type"] = expected_type
    summary["dialog_result"] = dialog_result
    try:
        proc = run_backend_command(
            [
                CAPTCHA_TRACE_SCRIPT,
                "java-probe",
                "--backend",
                BACKEND_RUNTIME,
                "--probe",
                "dialog",
                "--captcha-type",
                str(expected_type),
                "--dialog-result-json",
                compact_json(dialog_result),
            ],
            timeout=240,
        )
        probe_output = parse_backend_json_output(proc.stdout)
        dialog_probe = (probe_output.get("on_dialog_result_probe") or {}) if isinstance(probe_output, dict) else {}
        probe_info = normalize_captcha_info(dialog_probe.get("captcha_info") or {})
        summary["ok"] = bool(probe_info.get("challenge"))
        summary["captcha_info"] = probe_info
        summary["probe_mode"] = "dialog"
    except Exception as exc:
        summary["error"] = str(exc)

    atomic_write_json(probe_path, summary)
    return summary


def capture_session_production_truth(
    session_payload: dict,
    request_payload: dict,
    response_payload: dict,
    source: str,
):
    session_id = str((session_payload or {}).get("session_id") or "").strip()
    if not session_id:
        raise ValueError("session payload missing session_id for production truth capture")
    now_ms = int(time.time() * 1000)
    probe_path = os.path.join(STATE_DIR, f"gt3-proof-probe-{session_id}-{now_ms}.json")
    summary = {
        "ok": False,
        "source": source,
        "session_id": session_id,
        "ts_ms": now_ms,
        "path": probe_path,
        "gt3_proof_truth": {},
        "gt3_proof_truth_response": {},
    }
    try:
        proc = run_backend_command(
            [
                CAPTCHA_TRACE_SCRIPT,
                "java-probe",
                "--backend",
                BACKEND_RUNTIME,
                "--probe",
                "secret-key",
                "--gt3-proof-truth-json",
                compact_json(request_payload or {}),
                "--gt3-proof-response-json",
                compact_json(response_payload or {}),
            ],
            timeout=240,
        )
        probe_output = parse_backend_json_output(proc.stdout)
        truth = normalize_truth_json_candidate(
            (probe_output.get("gt3_proof_truth") if isinstance(probe_output, dict) else {})
        )
        truth_response = normalize_truth_response_candidate(
            (probe_output.get("gt3_proof_truth_response") if isinstance(probe_output, dict) else {})
        )
        probe_meta = (
            probe_output.get("gt3_proof_truth_probe") if isinstance(probe_output, dict) else {}
        ) or {}
        summary.update(
            {
                "ok": probe_meta.get("status") == "ok",
                "probe_status": probe_meta.get("status") or "partial",
                "missing_fields": probe_meta.get("missing_fields") or [],
                "missing_response_fields": probe_meta.get("missing_response_fields") or [],
                "gt3_proof_truth_path": probe_meta.get("gt3_proof_truth_path"),
                "gt3_proof_truth_response_path": probe_meta.get("gt3_proof_truth_response_path"),
                "gt3_proof_truth": truth,
                "gt3_proof_truth_response": truth_response,
            }
        )
        session_payload["production_proof_truth"] = truth
        session_payload["production_proof_truth_response"] = truth_response
        debug_session = (
            session_payload.get("debug_session")
            if isinstance(session_payload.get("debug_session"), dict)
            else {}
        )
        debug_session["production_proof_truth"] = truth
        debug_session["production_proof_truth_response"] = truth_response
        session_payload["debug_session"] = debug_session
    except Exception as exc:
        summary["error"] = str(exc)
    atomic_write_json(probe_path, summary)
    return summary


def import_session_production_truth(payload: dict):
    session_id = str((payload or {}).get("session_id") or "").strip()
    if not session_id:
        raise ValueError("session_id is required")
    session = resolve_session(session_id)
    truth = normalize_truth_json_candidate(
        payload.get("production_proof_truth")
        or payload.get("gt3_proof_truth")
        or payload.get("truth")
    )
    truth_response = normalize_truth_response_candidate(
        payload.get("production_proof_truth_response")
        or payload.get("gt3_proof_truth_response")
        or payload.get("truth_response")
    )
    if not truth:
        raise ValueError("production_proof_truth is required")
    source_tag = production_truth_source_tag(truth)
    if not is_trusted_production_truth(truth):
        raise ValueError(
            f"production_proof_truth source `{source_tag or '<empty>'}` is not trusted"
        )
    now_ms = int(time.time() * 1000)
    artifact_path = os.path.join(
        STATE_DIR, f"gt3-production-truth-import-{session_id}-{now_ms}.json"
    )
    artifact = {
        "ok": True,
        "session_id": session_id,
        "ts_ms": now_ms,
        "source": source_tag,
        "production_proof_truth": truth,
        "production_proof_truth_response": truth_response,
    }
    atomic_write_json(artifact_path, artifact)
    session["production_proof_truth"] = truth
    session["production_proof_truth_response"] = truth_response
    debug_session = (
        session.get("debug_session")
        if isinstance(session.get("debug_session"), dict)
        else {}
    )
    debug_session["production_proof_truth"] = truth
    debug_session["production_proof_truth_response"] = truth_response
    session["debug_session"] = debug_session
    session["production_truth_import"] = {
        "ts_ms": now_ms,
        "path": artifact_path,
        "source": source_tag,
    }
    save_session(session, force_latest=True)
    return {
        "ok": True,
        "session_id": session_id,
        "source": source_tag,
        "path": artifact_path,
        "truth_present": True,
        "truth_response_present": bool(truth_response),
    }


def openssl_aes_cbc_encrypt(payload_bytes: bytes, key_bytes: bytes, iv_bytes: bytes) -> bytes:
    proc = subprocess.run(
        [
            "openssl",
            "enc",
            "-aes-128-cbc",
            "-K",
            key_bytes.hex(),
            "-iv",
            iv_bytes.hex(),
        ],
        input=payload_bytes,
        capture_output=True,
        check=True,
    )
    return proc.stdout


def geetest_android_encrypt(payload_obj, key_bytes=None):
    key = key_bytes or os.urandom(16)
    iv = os.urandom(16)
    payload_bytes = compact_json(payload_obj).encode("utf-8")
    ciphertext = openssl_aes_cbc_encrypt(payload_bytes, key, iv)
    encoded = base64.b64encode(iv + key + ciphertext).decode("ascii")
    return encoded, key


def build_android_mi(trace: dict, now_ms: int):
    device = trace.get("device") or {}
    brand = (device.get("brand") or "realme").strip() or "realme"
    network = (device.get("network") or "wifi").strip() or "wifi"
    uniqid = (device.get("uniqid") or "debug-uuid").strip() or "debug-uuid"
    return {
        "build": "4040100",
        "release": "4.4.2.1",
        "br": "1",
        "bs": network,
        "cell": network,
        "coun": "CN",
        "dh": "915",
        "dm": brand,
        "dns": "",
        "dw": "412",
        "lang": "zh",
        "ostype": "android",
        "osver": "14",
        "py": "0",
        "ts": str(now_ms),
        "vendor": "com.hpbr.bosszhipin",
        "app": "Boss直聘",
        "gt3": "4.4.2.1",
        "uuid": uniqid,
        "jbd": "0",
        "sim": "0",
        "deb": "0",
        "tam": "0",
    }


def build_android_gid(trace: dict, now_ms: int):
    device = trace.get("device") or {}
    fp = (device.get("uniqid") or "debug-fp").strip() or "debug-fp"
    return {
        "d": "$unknown",
        "e": "$unknown",
        "fp": fp,
        "ts": str(now_ms),
        "ver": "1.0.0",
        "client_type": "android",
    }


def build_cookie_opener():
    jar = http.cookiejar.CookieJar()
    opener = urllib.request.build_opener(urllib.request.HTTPCookieProcessor(jar))
    return opener, jar


def serialize_cookie_jar(jar: http.cookiejar.CookieJar):
    cookies = []
    for cookie in jar:
        cookies.append(
            {
                "name": cookie.name,
                "value": cookie.value,
                "domain": cookie.domain,
                "path": cookie.path,
                "secure": bool(cookie.secure),
                "expires": cookie.expires,
                "rest": dict(getattr(cookie, "_rest", {}) or {}),
            }
        )
    return cookies


def build_cookie_opener_from_serialized(cookies):
    jar = http.cookiejar.CookieJar()
    for item in cookies or []:
        if not isinstance(item, dict):
            continue
        domain = str(item.get("domain") or "")
        path = str(item.get("path") or "/") or "/"
        secure = bool(item.get("secure"))
        expires = item.get("expires")
        rest = item.get("rest") or {}
        cookie = http.cookiejar.Cookie(
            version=0,
            name=str(item.get("name") or ""),
            value=str(item.get("value") or ""),
            port=None,
            port_specified=False,
            domain=domain,
            domain_specified=bool(domain),
            domain_initial_dot=domain.startswith("."),
            path=path,
            path_specified=True,
            secure=secure,
            expires=expires,
            discard=expires is None,
            comment=None,
            comment_url=None,
            rest=rest,
            rfc2109=False,
        )
        jar.set_cookie(cookie)
    opener = urllib.request.build_opener(urllib.request.HTTPCookieProcessor(jar))
    return opener, jar


def fetch_text_with_opener(opener, url: str, headers=None, data=None, timeout=15) -> str:
    req = urllib.request.Request(url, data=data, headers=headers or {})
    with opener.open(req, timeout=timeout) as resp:
        charset = resp.headers.get_content_charset() or "utf-8"
        return resp.read().decode(charset, errors="replace")


def geetest_remote_response_status(body_text: str):
    try:
        payload = parse_json_or_jsonp(body_text)
    except Exception:
        return ""
    if not isinstance(payload, dict):
        return ""
    data = payload.get("data")
    if isinstance(data, dict) and data.get("result"):
        return str(data.get("result") or "").strip()
    if payload.get("result"):
        return str(payload.get("result") or "").strip()
    if payload.get("status"):
        return str(payload.get("status") or "").strip()
    return ""


def geetest_remote_response_error_code(body_text: str):
    try:
        payload = parse_json_or_jsonp(body_text)
    except Exception:
        return ""
    if not isinstance(payload, dict):
        return ""
    return str(payload.get("error_code") or payload.get("code") or "").strip()


def prewarm_native_geetest(trace_path: str):
    with open(trace_path, "r", encoding="utf-8") as fh:
        trace_text = fh.read()
    trace = json.loads(trace_text)
    start = trace.get("start_captcha") or {}
    gt = (start.get("gt") or "").strip()
    challenge = (start.get("challenge") or "").strip()
    if not gt or not challenge:
        raise ValueError("trace missing start_captcha gt/challenge")

    api_server = normalize_domain(
        (((trace.get("gt3_exchange") or {}).get("register") or {}).get("api_server"))
        or "apiv6.geetest.com"
    )
    lang = "zh-cn"
    opener, _jar = build_cookie_opener()
    ua = (
        "Mozilla/5.0 (Linux; Android 14; RMX3560 Build/UQ1A.231205.015; wv) "
        "AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/118.0.0.0 "
        "Mobile Safari/537.36 BossZhipin/14.010"
    )
    common_headers = {
        "user-agent": ua,
        "accept": "application/json, text/javascript, */*; q=0.01",
    }

    gettype_url = f"https://{api_server}/gettype.php?gt={urllib.parse.quote(gt)}&callback=geetest_123"
    gettype_text = fetch_text_with_opener(opener, gettype_url, headers=common_headers, timeout=30)
    gettype_raw = parse_json_or_jsonp(gettype_text)
    gettype_data = gettype_raw.get("data") or {}

    w_get, key_bytes = geetest_android_encrypt({"lang": lang})
    get_url = (
        f"https://{api_server}/get.php?gt={urllib.parse.quote(gt)}"
        f"&challenge={urllib.parse.quote(challenge)}"
        f"&client_type=android&lang={urllib.parse.quote(lang)}"
        f"&client_type=android&pt=20&w={urllib.parse.quote(w_get, safe='')}"
    )
    get_text = fetch_text_with_opener(opener, get_url, headers=common_headers, timeout=30)
    get_raw = parse_json_or_jsonp(get_text)

    now_ms = int(time.time() * 1000)
    mi_string = compact_json(build_android_mi(trace, now_ms))
    gid_string = compact_json(build_android_gid(trace, now_ms))
    w_ajax, _ = geetest_android_encrypt(
        {"mi": mi_string, "light": "", "gid": gid_string},
        key_bytes=key_bytes,
    )
    ajax_payload = {
        "gt": gt,
        "challenge": challenge,
        "client_type": "android",
        "pt": "20",
        "w": w_ajax,
    }
    ajax_headers = {
        "user-agent": ua,
        "accept": "application/json, text/javascript, */*; q=0.01",
        "content-type": "application/x-www-form-urlencoded",
        "accept-encoding": "gzip",
        "content-encoding": "gzip",
        "host": api_server,
    }
    ajax_url = (
        f"https://{api_server}/ajax.php?gt={urllib.parse.quote(gt)}"
        f"&challenge={urllib.parse.quote(challenge)}"
        f"&client_type=android&lang={urllib.parse.quote(lang)}"
    )
    ajax_body = gzip.compress(compact_json(ajax_payload).encode("utf-8"))
    ajax_text = fetch_text_with_opener(
        opener,
        ajax_url,
        headers=ajax_headers,
        data=ajax_body,
        timeout=30,
    )
    ajax_raw = parse_json_or_jsonp(ajax_text)
    final_type = (
        (((ajax_raw.get("data") or {}).get("result")) or "").strip()
        or (gettype_data.get("type") or "").strip()
        or "fullpage"
    )
    followup_get_raw = None
    followup_wrapper = None
    if final_type == "slide":
        followup_url = (
            f"https://{api_server}/get.php?gt={urllib.parse.quote(gt)}"
            f"&challenge={urllib.parse.quote(challenge)}"
            f"&lang={urllib.parse.quote(lang)}"
            f"&pt=0&client_type=native&w="
        )
        followup_wrapper = fetch_text_with_opener(
            opener,
            followup_url,
            headers=common_headers,
            timeout=30,
        )
        followup_get_raw = extract_geetest_payload_from_wrapper(followup_wrapper)

    return {
        "ok": True,
        "gt": gt,
        "challenge": challenge,
        "api_server": api_server,
        "lang": lang,
        "user_agent": ua,
        "cookies": serialize_cookie_jar(_jar),
        "final_type": final_type,
        "js_path": gettype_data.get(final_type),
        "gettype_data": gettype_data,
        "android_contract": {
            "get_url": get_url,
            "ajax_url": ajax_url,
            "ajax_payload": ajax_payload,
            "mi": json.loads(mi_string),
            "gid": json.loads(gid_string),
        },
        "get_raw": get_raw,
        "ajax_raw": ajax_raw,
        "followup_get_raw": followup_get_raw,
        "followup_wrapper": followup_wrapper,
    }


def forward_native_ajax_via_backend(session: dict, forward_url: str):
    debug_session = session.get("debug_session") or {}
    native = debug_session.get("native_prewarm") or session.get("native_prewarm") or {}
    cookies = native.get("cookies") or []
    opener, _jar = build_cookie_opener_from_serialized(cookies)
    user_agent = (
        (native.get("user_agent") or "").strip()
        or (
            ((native.get("android_contract") or {}).get("user_agent") if isinstance(native.get("android_contract"), dict) else "")
            or ""
        ).strip()
        or "Mozilla/5.0 (Linux; Android 14; RMX3560 Build/UQ1A.231205.015; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/118.0.0.0 Mobile Safari/537.36 BossZhipin/14.010"
    )
    headers = {
        "user-agent": user_agent,
        "accept": "application/json, text/javascript, */*; q=0.01",
        "referer": "https://static.geetest.com/",
    }
    body_text = fetch_text_with_opener(opener, forward_url, headers=headers, timeout=30)
    return {
        "body_text": body_text,
        "status": geetest_remote_response_status(body_text),
        "error_code": geetest_remote_response_error_code(body_text),
        "user_agent": user_agent,
        "cookie_count": len(cookies),
    }


def extract_geetest_payload_from_wrapper(text: str):
    raw = (text or "").strip()
    marker = "new Geetest("
    start = raw.find(marker)
    if start < 0:
        raise ValueError("followup get wrapper missing new Geetest payload")
    brace_start = raw.find("{", start)
    if brace_start < 0:
        raise ValueError("followup get wrapper missing object start")
    depth = 0
    in_string = False
    escaped = False
    for idx in range(brace_start, len(raw)):
        ch = raw[idx]
        if in_string:
            if escaped:
                escaped = False
            elif ch == "\\":
                escaped = True
            elif ch == '"':
                in_string = False
            continue
        if ch == '"':
            in_string = True
            continue
        if ch == "{":
            depth += 1
        elif ch == "}":
            depth -= 1
            if depth == 0:
                return json.loads(raw[brace_start : idx + 1])
    raise ValueError("followup get wrapper object not terminated")


def build_session_payload(native_trace_path: str, debug_trace_path: str, protocol_path: str, native_prewarm=None):
    with open(native_trace_path, "r", encoding="utf-8") as fh:
        native_trace_text = fh.read()
    with open(debug_trace_path, "r", encoding="utf-8") as fh:
        debug_trace_text = fh.read()
    with open(protocol_path, "r", encoding="utf-8") as fh:
        protocol = json.load(fh)
    native_trace = json.loads(native_trace_text)
    debug_trace = json.loads(debug_trace_text)

    app3_url = protocol.get("app3_url", "")
    gettype_for_query = (
        (native_prewarm or {}).get("gettype_data")
        or protocol.get("gettype_data")
        or {}
    )
    app3_url = augment_app3_url(app3_url, gettype_for_query)
    app3_url = rewrite_app3_url_for_debug(app3_url, native_prewarm)
    app3_url = rewrite_app3_url_with_followup(app3_url, native_prewarm)
    session_id = str(int(time.time() * 1000))
    native_ajax_mode = normalize_native_ajax_mode(DEFAULT_NATIVE_AJAX_MODE)
    query = app3_url.split("?", 1)[1] if "?" in app3_url else ""
    if query:
        player_url = (
            f"/play?{query}&sid={urllib.parse.quote(session_id)}"
            f"&native_ajax_mode={urllib.parse.quote(native_ajax_mode)}"
        )
    else:
        player_url = (
            f"/play?sid={urllib.parse.quote(session_id)}"
            f"&native_ajax_mode={urllib.parse.quote(native_ajax_mode)}"
        )
    latest_audit = load_latest_audit()
    session_audit = (
        latest_audit
        if isinstance(latest_audit, dict) and str(latest_audit.get("session_id") or "") == session_id
        else None
    )
    boa = protocol.get("boa") or {}
    boa_report = boa.get("report") or {}
    validate_template = build_optional_validate_template(native_trace_text, native_trace)
    backend_validation = build_backend_validation(native_trace)
    production_truth_candidate = (
        extract_session_production_truth(native_trace)
        or extract_session_production_truth(debug_trace)
        or {}
    )
    production_truth_candidate_response = (
        extract_session_production_truth_response(native_trace)
        or extract_session_production_truth_response(debug_trace)
        or {}
    )
    production_proof_truth = (
        extract_session_production_truth(native_trace, require_trusted=True)
        or extract_session_production_truth(debug_trace, require_trusted=True)
        or {}
    )
    production_proof_truth_response = (
        production_truth_candidate_response if production_proof_truth else {}
    )
    debug_session = {
        "trace_path": debug_trace_path,
        "trace_status": debug_trace.get("status"),
        "trace_json": debug_trace_text,
        "ticket": {
            "provider": debug_trace.get("provider"),
            "captcha_type": debug_trace.get("captcha_type"),
            "start_captcha": debug_trace.get("start_captcha"),
            "skip_gt3_exchange": debug_trace.get("skip_gt3_exchange"),
            "validate_status": debug_trace.get("validate_status"),
        },
        "app3_url": app3_url,
        "player_url": player_url,
        "bootstrap": protocol.get("bootstrap") or {},
        "gettype_data": protocol.get("gettype_data"),
        "protocol_summary": protocol.get("protocol_summary"),
        "native_ajax_mode": native_ajax_mode,
        "native_prewarm": native_prewarm,
        "production_proof_truth": production_proof_truth,
        "production_proof_truth_response": production_proof_truth_response,
        "production_truth_candidate": production_truth_candidate,
        "production_truth_candidate_response": production_truth_candidate_response,
        "boa_summary": {
            "simulate_success": boa.get("simulate_success"),
            "debug": boa.get("debug"),
            "args": boa_report.get("args"),
            "config": boa_report.get("config"),
            "js": boa_report.get("js"),
            "static_servers": boa_report.get("static_servers"),
            "script_loads": boa_report.get("script_loads"),
            "callbacks": boa_report.get("callbacks"),
        },
    }

    payload = {
        "ok": True,
        "mode": "backend-native",
        "source": "backend-produced",
        "session_id": session_id,
        "created_at_ms": int(session_id),
        "created_at_iso": time.strftime("%Y-%m-%dT%H:%M:%S%z", time.localtime(int(session_id) / 1000)),
        "phone_masked": native_trace.get("phone_masked") or mask_phone(BACKEND_PHONE),
        "region_code": native_trace.get("region_code") or BACKEND_REGION,
        "native_trace_path": native_trace_path,
        "native_trace_json": native_trace_text,
        "debug_trace_path": debug_trace_path,
        "debug_trace_json": debug_trace_text,
        "protocol_path": protocol_path,
        "backend_validation": backend_validation,
        "captcha_info": native_trace.get("captcha_info"),
        "validate_template": validate_template,
        "validate_request": native_trace.get("validate_request"),
        "validate_response": native_trace.get("validate_response"),
        "gt3_exchange": native_trace.get("gt3_exchange"),
        "app3_url": app3_url,
        "player_url": player_url,
        "bootstrap": debug_session["bootstrap"],
        "gettype_data": debug_session["gettype_data"],
        "protocol_summary": debug_session["protocol_summary"],
        "native_ajax_mode": native_ajax_mode,
        "native_prewarm": native_prewarm,
        "production_proof_truth": production_proof_truth,
        "production_proof_truth_response": production_proof_truth_response,
        "production_truth_candidate": production_truth_candidate,
        "production_truth_candidate_response": production_truth_candidate_response,
        "boa": boa,
        "boa_summary": debug_session["boa_summary"],
        "debug_session": debug_session,
        "java_probe": {
            "ok": False,
            "source": "none",
            "session_id": session_id,
            "ts_ms": None,
            "path": None,
            "captcha_info": {},
        },
        "audit": session_audit,
        "latest_audit_event_path": (session_audit or {}).get("event_path"),
        "last_proxy_ajax": {},
        "control": {
            "capture_event_path": None,
            "submit_event_path": None,
            "latest_audit_path": (session_audit or {}).get("event_path"),
            "last_capture_ts_ms": None,
            "last_java_probe_ts_ms": None,
            "last_java_probe_path": None,
            "last_java_probe_ok": False,
            "last_submit_ts_ms": None,
            "last_submit_trace_path": None,
            "last_submit_trace_kind": None,
            "last_submit_verdict": "no-response",
            "last_submit_result_path": None,
            "last_submit_validate_status": None,
        },
    }
    return payload


def coerce_captcha_type(value, default=1):
    if isinstance(value, bool):
        return default
    if isinstance(value, int):
        return value
    if isinstance(value, str):
        text = value.strip()
        if text:
            try:
                return int(text)
            except ValueError:
                return default
    return default


def augment_app3_url(app3_url: str, gettype_data):
    if not app3_url or not isinstance(gettype_data, dict):
        return app3_url
    parsed = urllib.parse.urlparse(app3_url)
    pairs = urllib.parse.parse_qsl(parsed.query, keep_blank_values=True)
    existing = {key for key, _ in pairs}
    aspect = gettype_data.get("aspect_radio") or {}
    if isinstance(aspect, dict):
        for key, value in aspect.items():
            extra_key = f"aspect_radio_{key}"
            if extra_key not in existing:
                pairs.append((extra_key, str(value)))
                existing.add(extra_key)
            js_path = gettype_data.get(key)
            if key not in existing and isinstance(js_path, str) and js_path.strip():
                pairs.append((key, js_path.strip()))
                existing.add(key)
    rebuilt = urllib.parse.urlencode(pairs, doseq=True, safe=",/")
    return urllib.parse.urlunparse(parsed._replace(query=rebuilt))


def rewrite_app3_url_for_debug(app3_url: str, native_prewarm):
    if not app3_url or not isinstance(native_prewarm, dict):
        return app3_url
    final_type = (native_prewarm.get("final_type") or "").strip()
    js_path = (native_prewarm.get("js_path") or "").strip()
    if final_type != "slide" or not js_path:
        return app3_url
    parsed = urllib.parse.urlparse(app3_url)
    pairs = urllib.parse.parse_qsl(parsed.query, keep_blank_values=True)
    rewritten = []
    skip_keys = {"type", "fullpage", "click", "voice", "beeline", "slide"}
    for key, value in pairs:
        if key in skip_keys and key != "slide":
            continue
        if key == "type":
            continue
        if key == "slide":
            continue
        rewritten.append((key, value))
    rewritten.append(("type", "slide"))
    rewritten.append(("slide", js_path))
    query = urllib.parse.urlencode(rewritten, doseq=True, safe=",/")
    return urllib.parse.urlunparse(parsed._replace(query=query))


def rewrite_app3_url_with_followup(app3_url: str, native_prewarm):
    if not app3_url or not isinstance(native_prewarm, dict):
        return app3_url
    followup = native_prewarm.get("followup_get_raw") or {}
    if not isinstance(followup, dict):
        return app3_url
    followup_challenge = (followup.get("challenge") or "").strip()
    if not followup_challenge:
        return app3_url
    parsed = urllib.parse.urlparse(app3_url)
    pairs = urllib.parse.parse_qsl(parsed.query, keep_blank_values=True)
    rewritten = []
    replaced_challenge = False
    for key, value in pairs:
        if key == "challenge":
            rewritten.append((key, followup_challenge))
            replaced_challenge = True
            continue
        rewritten.append((key, value))
    if not replaced_challenge:
        rewritten.append(("challenge", followup_challenge))
    query = urllib.parse.urlencode(rewritten, doseq=True, safe=",/")
    return urllib.parse.urlunparse(parsed._replace(query=query))


def prepare_backend_session(force=True):
    ensure_state_dir()
    if not force:
        cached = load_latest_session()
        if (
            isinstance(cached, dict)
            and
            cached.get("mode") == "backend-native"
            and isinstance(cached.get("backend_validation"), dict)
            and isinstance(cached.get("debug_session"), dict)
        ):
            try:
                if not os.path.isfile(session_file_path(str(cached.get("session_id") or ""))):
                    save_session(cached, force_latest=True)
            except Exception:
                pass
            return cached

    now_ms = int(time.time() * 1000)
    native_trace_path = os.path.join(STATE_DIR, f"captcha-trace-native-{now_ms}.json")
    debug_trace_path = os.path.join(STATE_DIR, f"captcha-trace-debug-{now_ms}.json")
    protocol_path = os.path.join(STATE_DIR, f"gt3-app3-protocol-{now_ms}.json")

    run_backend_command(
        [
            CAPTCHA_TRACE_SCRIPT,
            "captcha-trace",
            "--backend",
            BACKEND_RUNTIME,
            "--phone",
            BACKEND_PHONE,
            "--region-code",
            BACKEND_REGION,
            "--out",
            native_trace_path,
        ],
        timeout=600,
    )

    run_backend_command(
        [
            CAPTCHA_TRACE_SCRIPT,
            "captcha-trace",
            "--backend",
            BACKEND_RUNTIME,
            "--phone",
            BACKEND_PHONE,
            "--region-code",
            BACKEND_REGION,
            "--skip-gt3-exchange",
            "true",
            "--skip-validate",
            "true",
            "--out",
            debug_trace_path,
        ],
        timeout=600,
    )

    native_prewarm = prewarm_native_geetest(debug_trace_path)
    protocol_args = [
        CAPTCHA_TRACE_SCRIPT,
        "gt3-app3-protocol",
        "--backend",
        BACKEND_RUNTIME,
        "--trace-json",
        debug_trace_path,
        "--simulate-success",
        "false",
        "--out",
        protocol_path,
    ]
    run_backend_command(protocol_args, timeout=300)

    payload = build_session_payload(
        native_trace_path,
        debug_trace_path,
        protocol_path,
        native_prewarm=native_prewarm,
    )
    save_session(payload, force_latest=True)
    return payload


def submit_validate_with_backend(captcha_info, trace_path: str, session_id=None):
    ensure_state_dir()
    if not isinstance(captcha_info, dict) or not captcha_info:
        raise ValueError("captcha_info is required")
    session = resolve_session(session_id)
    bound_session_id = str(session.get("session_id") or "")
    native_trace_path = (session.get("native_trace_path") or "").strip()
    debug_trace_path = (session.get("debug_trace_path") or "").strip()
    trace_path = (trace_path or "").strip()
    if not trace_path:
        trace_path = native_trace_path or debug_trace_path
    if trace_path not in {native_trace_path, debug_trace_path}:
        raise ValueError("trace_path must be the native/debug trace of the bound session")
    if not trace_path or not os.path.isfile(trace_path):
        raise ValueError("trace_path is required and must point to an existing trace file")
    if trace_path == native_trace_path and native_trace_path:
        submit_trace_kind = "native"
    elif trace_path == debug_trace_path and debug_trace_path:
        submit_trace_kind = "debug"
    elif trace_path:
        submit_trace_kind = "other"
    else:
        submit_trace_kind = "missing"
    result_path = os.path.join(STATE_DIR, f"captcha-validate-submit-{int(time.time() * 1000)}.json")
    normalized_submit_info = normalize_captcha_info(captcha_info or {})
    java_probe = session.get("java_probe") if isinstance(session.get("java_probe"), dict) else None
    if normalized_submit_info.get("challenge"):
        java_probe = build_session_java_probe(
            session,
            normalized_submit_info,
            source="validate_submit",
        )
        session["java_probe"] = java_probe
    run_backend_command(
        [
            CAPTCHA_TRACE_SCRIPT,
            "captcha-validate-submit",
            "--backend",
            BACKEND_RUNTIME,
            "--trace-json",
            trace_path,
            "--captcha-info-json",
            compact_json(captcha_info),
            "--out",
            result_path,
        ],
        timeout=600,
    )
    with open(result_path, "r", encoding="utf-8") as fh:
        result = json.load(fh)
    latest_audit = load_latest_audit() or {}
    packet = select_capture_packet_for_submit(
        bound_session_id,
        result.get("captcha_info") or normalized_submit_info,
        session_packet=session.get("last_capture_packet"),
        latest_audit=latest_audit if isinstance(latest_audit, dict) else None,
    )
    submit_summary = {
        "ok": True,
        "result_path": result_path,
        "trace_path": trace_path,
        "trace_kind": submit_trace_kind,
        "session_id": bound_session_id,
        "status": result.get("status"),
        "captcha_info": result.get("captcha_info"),
        "validate_status": result.get("validate_status"),
        "captcha_info_source": result.get("captcha_info_source"),
        "validate_request": result.get("validate_request"),
        "validate_response": result.get("validate_response"),
        "real_observation": result.get("real_observation"),
        "java_probe": {
            "ok": bool((java_probe or {}).get("ok")),
            "source": (java_probe or {}).get("source"),
            "path": (java_probe or {}).get("path"),
            "captcha_info": (java_probe or {}).get("captcha_info") or {},
        },
        "java_probe_captcha_info": (java_probe or {}).get("captcha_info") or {},
    }
    submit_summary["verdict"] = classify_submit_verdict(submit_summary)
    audit = build_audit_analysis(
        session_payload=session,
        capture_packet=packet,
        submit_result=submit_summary,
        submit_trace_path=trace_path,
    )
    audit_event = {
        "ok": True,
        "kind": "submit",
        "ts_ms": int(time.time() * 1000),
        "session_id": bound_session_id,
        "packet": packet,
        "submit": submit_summary,
        "audit": audit,
    }
    audit_event["event_path"] = write_audit_event("submit", audit_event)
    save_latest_audit(audit_event)
    control = session.get("control") if isinstance(session.get("control"), dict) else {}
    control.update(
        {
            "submit_event_path": audit_event["event_path"],
            "latest_audit_path": audit_event["event_path"],
            "last_submit_ts_ms": audit_event["ts_ms"],
            "last_submit_trace_path": trace_path,
            "last_submit_trace_kind": submit_trace_kind,
            "last_submit_verdict": submit_summary.get("verdict"),
            "last_submit_result_path": result_path,
            "last_submit_validate_status": submit_summary.get("validate_status"),
            "last_java_probe_ts_ms": (java_probe or {}).get("ts_ms"),
            "last_java_probe_path": (java_probe or {}).get("path"),
            "last_java_probe_ok": bool((java_probe or {}).get("ok")),
        }
    )
    session["control"] = control
    session["audit"] = audit
    session["latest_audit"] = {
        "kind": "submit",
        "ts_ms": audit_event["ts_ms"],
        "event_path": audit_event["event_path"],
        "audit": audit,
    }
    session["latest_audit_event_path"] = audit_event["event_path"]
    session["last_validate_submit"] = {
        "result_path": result_path,
        "trace_path": trace_path,
        "trace_kind": submit_trace_kind,
        "validate_status": submit_summary.get("validate_status"),
        "verdict": submit_summary.get("verdict"),
        "ts_ms": audit_event["ts_ms"],
        "session_id": bound_session_id,
        "audit_event_path": audit_event["event_path"],
    }
    save_session(session, force_latest=False)
    submit_summary["audit"] = audit
    submit_summary["audit_event_path"] = audit_event["event_path"]
    return submit_summary


def submit_manual_gt3_trajectory(payload: dict):
    ensure_state_dir()
    if not isinstance(payload, dict):
        raise ValueError("payload must be an object")
    session = resolve_session(payload.get("session_id"))
    session_id = str(session.get("session_id") or "")

    trajectory = payload.get("trajectory")
    if not isinstance(trajectory, list) or not trajectory:
        raise ValueError("trajectory must be a non-empty array")
    offset_x = payload.get("offset_x")
    if offset_x is None:
        raise ValueError("offset_x is required")
    try:
        offset_x = int(float(offset_x))
    except Exception as exc:
        raise ValueError("offset_x must be numeric") from exc

    app3_url = payload.get("app3_url") or ((session.get("debug_session") or {}).get("app3_url") or "")
    query = derive_app3_query_params(app3_url)
    native_prewarm = ((session.get("debug_session") or {}).get("native_prewarm") or session.get("native_prewarm") or {})
    register_payload = None
    bootstrap_challenge = ""
    if isinstance(native_prewarm, dict):
        bootstrap_challenge = str(native_prewarm.get("challenge") or "").strip()
        candidate = native_prewarm.get("followup_get_raw") or native_prewarm.get("get_raw")
        if isinstance(candidate, dict):
            register_payload = candidate
    gt = (payload.get("gt") or query.get("gt") or "").strip()
    challenge = (
        payload.get("challenge")
        or (register_payload or {}).get("challenge")
        or query.get("challenge")
        or ""
    ).strip()
    if not gt or not challenge:
        raise ValueError("gt/challenge are required")

    api_server = (payload.get("api_server") or query.get("api_server") or "").strip()
    static_server = ""
    if isinstance(payload.get("static_server"), str):
        static_server = payload.get("static_server") or ""
    if not static_server and isinstance(query.get("static_servers"), str):
        for candidate in (query.get("static_servers") or "").split(","):
            candidate = candidate.strip().rstrip("/")
            if candidate:
                static_server = candidate
                break
    user_agent = (payload.get("user_agent") or "").strip()
    expected_type = coerce_captcha_type(
        payload.get("captcha_type"),
        default=coerce_captcha_type(
            (((session.get("debug_session") or {}).get("ticket") or {}).get("captcha_type")),
            default=1,
        ),
    )
    trace_path = (payload.get("trace_path") or "").strip()
    if not trace_path:
        trace_path = (session.get("debug_trace_path") or session.get("native_trace_path") or "").strip()
    if not trace_path:
        raise ValueError("trace_path is required")

    trajectory_path = os.path.join(
        STATE_DIR,
        f"gt3-trajectory-{session_id}-{int(time.time()*1000)}.json",
    )
    manual_out_path = os.path.join(
        STATE_DIR,
        f"gt3-manual-trajectory-{session_id}-{int(time.time()*1000)}.json",
    )
    proof_truth_path = os.path.join(
        STATE_DIR,
        f"gt3-proof-truth-{session_id}-{int(time.time()*1000)}.json",
    )
    register_path = os.path.join(
        STATE_DIR,
        f"gt3-register-{session_id}-{int(time.time()*1000)}.json",
    )
    atomic_write_json(trajectory_path, trajectory)
    if register_payload:
        atomic_write_json(register_path, register_payload)
    production_truth = extract_session_production_truth(session, require_trusted=True)
    production_truth_candidate = extract_session_production_truth(session)
    if not production_truth:
        result = {
            "ok": False,
            "session_id": session_id,
            "gt": gt,
            "challenge": challenge,
            "bootstrap_challenge": bootstrap_challenge,
            "offset_x": offset_x,
            "trajectory_path": trajectory_path,
            "register_path": register_path if register_payload else None,
            "manual_output_path": manual_out_path,
            "proof_source": "production-truth",
            "production_proof_truth_path": None,
            "production_truth_candidate_source": production_truth_source_tag(
                production_truth_candidate
            ),
            "error": (
                "missing trusted production_proof_truth; import Boss App production truth "
                "before native-only solve"
            ),
            "trace_path": trace_path,
        }
        session["last_manual_trajectory"] = result
        save_session(session, force_latest=True)
        return result
    atomic_write_json(proof_truth_path, production_truth)

    cmd = [
        CAPTCHA_TRACE_SCRIPT,
        "gt3-manual-trajectory",
        "--proof-source",
        "production-truth",
        "--gt",
        gt,
        "--challenge",
        challenge,
        "--offset-x",
        str(offset_x),
        "--trajectory-path",
        trajectory_path,
        "--out",
        manual_out_path,
    ]
    if bootstrap_challenge:
        cmd += ["--bootstrap-challenge", bootstrap_challenge]
    if register_payload:
        cmd += ["--register-path", register_path]
    cmd += ["--production-proof-truth-path", proof_truth_path]
    if api_server:
        cmd += ["--gt3-api-server", api_server]
    if static_server:
        cmd += ["--gt3-static-server", static_server]
    if user_agent:
        cmd += ["--gt3-user-agent", user_agent]

    proc = run_backend_command(cmd, timeout=600)
    manual_output = parse_backend_json_output(proc.stdout)

    exchange = {}
    if isinstance(manual_output, dict):
        exchange = manual_output.get("exchange") or {}
    validate = exchange.get("validate") if isinstance(exchange, dict) else None
    sec_code = exchange.get("sec_code") if isinstance(exchange, dict) else None

    result = {
        "ok": True,
        "session_id": session_id,
        "gt": gt,
        "challenge": challenge,
        "bootstrap_challenge": bootstrap_challenge,
        "offset_x": offset_x,
        "trajectory_path": trajectory_path,
        "register_path": register_path if register_payload else None,
        "manual_output_path": manual_out_path,
        "proof_source": "production-truth",
        "production_proof_truth_path": proof_truth_path,
        "exchange": exchange,
        "auto_submit": bool(payload.get("auto_submit")),
        "trace_path": trace_path,
    }

    if validate and sec_code:
        captcha_info = {
            "type": expected_type,
            "challenge": challenge,
            "validate": validate,
            "secCode": sec_code,
        }
        result["captcha_info"] = captcha_info
        if payload.get("auto_submit"):
            try:
                result["validate_submit"] = submit_validate_with_backend(
                    captcha_info,
                    trace_path,
                    session_id=session_id,
                )
            except Exception as exc:
                result["validate_submit_error"] = str(exc)
    session["last_manual_trajectory"] = result
    save_session(session, force_latest=True)
    return result


def align_app3_contract(html: str) -> str:
    return html.replace("https: location.protocol === 'https:'", "https: true")


def inject_bridge(
    html: str,
    app3_url: str,
    expected_captcha_type: int = 1,
    native_ajax_mode: str = None,
) -> str:
    expected_captcha_type = coerce_captcha_type(expected_captcha_type, default=1)
    native_ajax_mode = normalize_native_ajax_mode(native_ajax_mode)
    inject = f"""
<script>
(function() {{
  var webviewUA = "Mozilla/5.0 (Linux; Android 14; RMX3560 Build/UQ1A.231205.015; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/118.0.0.0 Mobile Safari/537.36 BossZhipin/14.010";
  var slideDebugMode = /[?&]type=slide(?:&|$)/.test({json.dumps(app3_url)});
  var expectedCaptchaType = {expected_captcha_type};
  var nativeAjaxMode = {json.dumps(native_ajax_mode)};
  var sessionId = '';
  function defineGetter(target, key, value) {{
    try {{
      Object.defineProperty(target, key, {{
        configurable: true,
        get: function() {{ return value; }}
      }});
    }} catch (_e) {{}}
  }}
  defineGetter(navigator, 'userAgent', webviewUA);
  defineGetter(navigator, 'platform', 'Linux armv8l');
  defineGetter(navigator, 'vendor', 'Google Inc.');
  defineGetter(navigator, 'language', 'zh-CN');
  defineGetter(navigator, 'languages', ['zh-CN', 'zh']);
  defineGetter(navigator, 'maxTouchPoints', 5);
  defineGetter(navigator, 'webdriver', false);
  defineGetter(document, 'referrer', 'https://static.geetest.com/');
  defineGetter(document, 'visibilityState', 'visible');
  defineGetter(document, 'hidden', false);
  defineGetter(window, 'devicePixelRatio', 3);
  defineGetter(window.screen, 'width', 412);
  defineGetter(window.screen, 'height', 915);
  defineGetter(window.screen, 'availWidth', 412);
  defineGetter(window.screen, 'availHeight', 915);
  window.chrome = window.chrome || {{ runtime: {{}} }};
  window.orientation = window.orientation || 0;
  window.ontouchstart = window.ontouchstart || function() {{}};
  function bridgeForward(name, payload) {{
    try {{
      if (typeof JSInterface !== 'undefined' && JSInterface && typeof JSInterface[name] === 'function') {{
        JSInterface[name](payload);
      }}
    }} catch (_e) {{}}
  }}
  window.webkit = window.webkit || {{}};
  window.webkit.messageHandlers = window.webkit.messageHandlers || {{
    gtError: {{ postMessage: function(message) {{ bridgeForward('gtError', message); }} }},
    gt3Error: {{ postMessage: function(message) {{ bridgeForward('gt3Error', message); }} }},
    gtReady: {{ postMessage: function(message) {{ bridgeForward('gtReady', message); }} }},
    gtClose: {{ postMessage: function(message) {{ bridgeForward('gtClose', message); }} }},
    gtNotify: {{ postMessage: function(message) {{ bridgeForward('gtNotify', message); }} }},
    wkWebview: {{ postMessage: function(message) {{
      try {{
        var parsed = typeof message === 'string' ? JSON.parse(message) : (message || {{}});
        if (typeof JSInterface !== 'undefined' && JSInterface && typeof JSInterface.gtCallBack === 'function') {{
          JSInterface.gtCallBack(parsed.code || '', parsed.result || '', parsed.message || '');
        }}
      }} catch (_e) {{}}
    }} }}
  }};
  function rewriteGeetestUrl(raw) {{
    try {{
      if (!raw) return raw;
      var urlValue = String(raw);
      if (urlValue.indexOf('//') === 0) {{
        urlValue = 'https:' + urlValue;
      }}
      var parsed = new URL(urlValue, window.location.href);
      if (!/(^|\\.)geetest\\.com$|(^|\\.)geevisit\\.com$/i.test(parsed.hostname)) {{
        return raw;
      }}
      parsed.protocol = 'https:';
      if (/\\/get\\.php$/i.test(parsed.pathname)) {{
        if (slideDebugMode) {{
          var localGet = new URL('/api/geetest/native_get', window.location.origin);
          ['gt', 'challenge', 'lang', 'callback'].forEach(function(key) {{
            if (parsed.searchParams.has(key)) localGet.searchParams.set(key, parsed.searchParams.get(key));
          }});
          localGet.searchParams.set('api_server', parsed.hostname);
          return localGet.toString();
        }}
        parsed.searchParams.set('client_type', 'native');
        parsed.searchParams.set('pt', '0');
        parsed.searchParams.set('w', '');
        return parsed.toString();
      }}
      if (/\\/ajax\\.php$/i.test(parsed.pathname)) {{
        if (slideDebugMode) {{
          var originalRemoteUrl = parsed.toString();
          var proxyRemoteUrl = originalRemoteUrl;
          if (parsed.searchParams.has('w')) {{
            var replacement = null;
            if (typeof window.__GT3ResolveNativeAjaxReplacement === 'function') {{
              replacement = window.__GT3ResolveNativeAjaxReplacement(parsed.toString(), 'url-rewrite');
            }}
            if (replacement && replacement.replacedUrl) {{
              proxyRemoteUrl = replacement.replacedUrl;
            }}
          }}
          var localAjax = new URL('/api/geetest/native_ajax', window.location.origin);
          localAjax.searchParams.set('api_server', parsed.hostname);
          localAjax.searchParams.set('sid', String(sessionId || ''));
          localAjax.searchParams.set('ajax_mode', String(nativeAjaxMode || ''));
          localAjax.searchParams.set('forward_url', originalRemoteUrl);
          if (proxyRemoteUrl && proxyRemoteUrl !== originalRemoteUrl) {{
            localAjax.searchParams.set('native_forward_url', proxyRemoteUrl);
          }}
          if (parsed.searchParams.has('callback')) {{
            localAjax.searchParams.set('callback', parsed.searchParams.get('callback'));
          }}
          return localAjax.toString();
        }}
        var localAjax = new URL('/api/geetest/native_ajax', window.location.origin);
        ['gt', 'challenge', 'lang', 'callback'].forEach(function(key) {{
          if (parsed.searchParams.has(key)) localAjax.searchParams.set(key, parsed.searchParams.get(key));
        }});
        localAjax.searchParams.set('api_server', parsed.hostname);
        return localAjax.toString();
      }}
      return parsed.toString();
    }} catch (_e) {{
      return raw;
    }}
  }}
  try {{
    var scriptSrcDesc = Object.getOwnPropertyDescriptor(HTMLScriptElement.prototype, 'src');
    if (scriptSrcDesc && scriptSrcDesc.set) {{
      Object.defineProperty(HTMLScriptElement.prototype, 'src', {{
        configurable: true,
        enumerable: scriptSrcDesc.enumerable,
        get: function() {{ return scriptSrcDesc.get.call(this); }},
        set: function(value) {{ return scriptSrcDesc.set.call(this, rewriteGeetestUrl(value)); }}
      }});
    }}
  }} catch (_e) {{}}
  try {{
    var originalScriptSetAttribute = HTMLScriptElement.prototype.setAttribute;
    HTMLScriptElement.prototype.setAttribute = function(name, value) {{
      if (String(name).toLowerCase() === 'src') {{
        value = rewriteGeetestUrl(value);
      }}
      return originalScriptSetAttribute.call(this, name, value);
    }};
  }} catch (_e) {{}}
  function rewriteElementUrlAttr(element, name, value) {{
    try {{
      var attr = String(name || '').toLowerCase();
      var tag = String((element && element.tagName) || '').toUpperCase();
      if (tag === 'SCRIPT' && attr === 'src') {{
        return rewriteGeetestUrl(value);
      }}
    }} catch (_e) {{}}
    return value;
  }}
  try {{
    if (!window.__GT3_ELEMENT_ATTR_INTERCEPTED) {{
      window.__GT3_ELEMENT_ATTR_INTERCEPTED = true;
      var originalElementSetAttribute = Element.prototype.setAttribute;
      Element.prototype.setAttribute = function(name, value) {{
        return originalElementSetAttribute.call(this, name, rewriteElementUrlAttr(this, name, value));
      }};
      var originalElementSetAttributeNS = Element.prototype.setAttributeNS;
      Element.prototype.setAttributeNS = function(namespace, name, value) {{
        return originalElementSetAttributeNS.call(this, namespace, name, rewriteElementUrlAttr(this, name, value));
      }};
    }}
  }} catch (_e) {{}}
  function rewriteInsertedNode(node) {{
    try {{
      if (node && String(node.tagName || '').toUpperCase() === 'SCRIPT' && node.src) {{
        node.src = rewriteGeetestUrl(node.src);
      }}
    }} catch (_e) {{}}
    return node;
  }}
  try {{
    if (!window.__GT3_NODE_INSERT_INTERCEPTED) {{
      window.__GT3_NODE_INSERT_INTERCEPTED = true;
      var originalAppendChild = Node.prototype.appendChild;
      Node.prototype.appendChild = function(node) {{
        return originalAppendChild.call(this, rewriteInsertedNode(node));
      }};
      var originalInsertBefore = Node.prototype.insertBefore;
      Node.prototype.insertBefore = function(node, child) {{
        return originalInsertBefore.call(this, rewriteInsertedNode(node), child);
      }};
      var originalReplaceChild = Node.prototype.replaceChild;
      Node.prototype.replaceChild = function(node, child) {{
        return originalReplaceChild.call(this, rewriteInsertedNode(node), child);
      }};
    }}
  }} catch (_e) {{}}
  var panel = document.createElement('div');
  panel.style.cssText = 'position:fixed;right:8px;top:8px;z-index:2147483647;background:#10151d;color:#e9eef6;border:1px solid #2a3443;border-radius:10px;padding:10px;max-width:430px;font:12px/1.4 monospace;box-shadow:0 12px 42px rgba(0,0,0,0.35)';
  panel.innerHTML = '<div style="font-weight:700;margin-bottom:6px">GT3 Capture</div><div id="gt3-mini" style="color:#9db0c6;margin-bottom:6px">waiting...</div><textarea id="gt3-out" style="width:410px;max-width:100%;height:220px;background:#0b1118;color:#d6e4f5;border:1px solid #2a3443;border-radius:6px;padding:6px"></textarea><div style="margin-top:6px;display:flex;gap:6px;flex-wrap:wrap"><button id="gt3-copy" style="padding:4px 8px;background:#1f8b82;color:#031210;border:0;border-radius:4px;cursor:pointer">Copy Capture</button><button id="gt3-copy-ci" style="padding:4px 8px;background:#2b3550;color:#e4eef9;border:0;border-radius:4px;cursor:pointer">Copy captcha_info</button></div>';
  function mount() {{
    if (!document.body) return setTimeout(mount, 50);
    document.body.appendChild(panel);
    var out = document.getElementById('gt3-out');
    var mini = document.getElementById('gt3-mini');
    try {{
      sessionId = new URL(window.location.href).searchParams.get('sid') || '';
    }} catch (_e) {{}}
    var app3Params = null;
    try {{
      app3Params = new URL({json.dumps(app3_url)}).searchParams;
    }} catch (_e) {{}}
    function latestCaptchaInfo() {{
      var events = (window.__GT3_CAPTURE && window.__GT3_CAPTURE.events) || [];
      for (var i = events.length - 1; i >= 0; i--) {{
        var evt = events[i];
        if (evt && evt.fn === 'gtCallBack' && evt.payload && evt.payload.code === '1') {{
          var result = evt.payload.result || {{}};
          return {{
            // APK chain uses provider-selected captchaType (`d.this.e()`), not a fixed constant.
            type: expectedCaptchaType,
            challenge: result.geetest_challenge || '',
            validate: result.geetest_validate || '',
            secCode: result.geetest_seccode || ''
          }};
        }}
      }}
      return null;
    }}
    function updatePanel() {{
      out.value = JSON.stringify({{
        capture: window.__GT3_CAPTURE || null,
        trajectory: window.__GT3_TRAJECTORY || null,
        trajectory_debug: window.__GT3_TRAJECTORY_DEBUG || null,
        trajectory_result: window.__GT3_TRAJECTORY_RESULT || null,
        last_ajax: window.__GT3_LAST_AJAX || null
      }}, null, 2);
    }}
    function staticServerValue() {{
      if (app3Params && app3Params.get('static_servers')) {{
        return String(app3Params.get('static_servers')).split(',')[0] || '';
      }}
      return '';
    }}
    function buildTrajectoryPayload(track, autoSubmit) {{
      return {{
        session_id: sessionId,
        gt: app3Params && app3Params.get('gt'),
        challenge: app3Params && app3Params.get('challenge'),
        api_server: app3Params && app3Params.get('api_server'),
        static_server: staticServerValue(),
        captcha_type: expectedCaptchaType,
        offset_x: track && typeof track.offset_x === 'number' ? track.offset_x : 0,
        trajectory: (track && track.points) || [],
        auto_submit: !!autoSubmit
      }};
    }}
    function trajectoryCacheKey(track) {{
      if (!track || !track.points || !track.points.length) return '';
      var last = track.points[track.points.length - 1] || {{}};
      return JSON.stringify({{
        challenge: app3Params && app3Params.get('challenge'),
        offset_x: track.offset_x || 0,
        count: track.points.length,
        last_x: last.x || 0,
        last_y: last.y || 0,
        last_t: last.t_ms || 0
      }});
    }}
    function storeTrajectoryResult(result, source, fromCache) {{
      window.__GT3_TRAJECTORY_RESULT = result || null;
      if (window.__GT3_TRAJECTORY_RESULT && typeof window.__GT3_TRAJECTORY_RESULT === 'object') {{
        window.__GT3_TRAJECTORY_RESULT.source = source || '';
        window.__GT3_TRAJECTORY_RESULT.from_cache = !!fromCache;
      }}
      updatePanel();
    }}
    function postTrajectory(track, opts) {{
      try {{
        if (!track || !track.points || !track.points.length) return Promise.resolve(null);
        opts = opts || {{}};
        var payload = buildTrajectoryPayload(track, !!opts.auto_submit);
        return fetch('/api/gt3-trajectory', {{
          method: 'POST',
          headers: {{ 'content-type': 'application/json' }},
          body: JSON.stringify(payload)
        }}).then(function(resp) {{
          return resp.json();
        }}).then(function(result) {{
          var cacheKey = trajectoryCacheKey(track);
          window.__GT3_NATIVE_W_CACHE = window.__GT3_NATIVE_W_CACHE || {{}};
          if (cacheKey) window.__GT3_NATIVE_W_CACHE[cacheKey] = result;
          storeTrajectoryResult(result, opts.source || 'async', false);
          mini.textContent = opts.auto_submit ? 'trajectory submitted' : 'trajectory primed';
          return result;
        }}).catch(function(err) {{
          var errorResult = {{ ok: false, error: String(err && err.message || err) }};
          storeTrajectoryResult(errorResult, opts.source || 'async', false);
          mini.textContent = 'trajectory error';
          return errorResult;
        }});
      }} catch (err) {{
        var errorResult = {{ ok: false, error: String(err && err.message || err) }};
        storeTrajectoryResult(errorResult, (opts && opts.source) || 'async', false);
        mini.textContent = 'trajectory error';
        return Promise.resolve(errorResult);
      }}
    }}
    function postTrajectorySync(track, opts) {{
      try {{
        if (!track || !track.points || !track.points.length) return null;
        opts = opts || {{}};
        var cacheKey = trajectoryCacheKey(track);
        window.__GT3_NATIVE_W_CACHE = window.__GT3_NATIVE_W_CACHE || {{}};
        if (cacheKey && window.__GT3_NATIVE_W_CACHE[cacheKey]) {{
          var cached = window.__GT3_NATIVE_W_CACHE[cacheKey];
          storeTrajectoryResult(cached, opts.source || 'sync-cache', true);
          return cached;
        }}
        var xhr = new XMLHttpRequest();
        xhr.open('POST', '/api/gt3-trajectory', false);
        xhr.setRequestHeader('content-type', 'application/json');
        xhr.send(JSON.stringify(buildTrajectoryPayload(track, !!opts.auto_submit)));
        var text = xhr.responseText || '';
        var result = text ? JSON.parse(text) : {{}};
        if (cacheKey) window.__GT3_NATIVE_W_CACHE[cacheKey] = result;
        storeTrajectoryResult(result, opts.source || 'sync', false);
        return result;
      }} catch (err) {{
        var errorResult = {{ ok: false, error: String(err && err.message || err) }};
        storeTrajectoryResult(errorResult, (opts && opts.source) || 'sync', false);
        return errorResult;
      }}
    }}
    function isGeetestAjaxUrl(raw) {{
      try {{
        if (!raw) return false;
        var parsed = new URL(String(raw), window.location.href);
        return /(^|\\.)geetest\\.com$|(^|\\.)geevisit\\.com$/i.test(parsed.hostname) && /\\/ajax\\.php$/i.test(parsed.pathname);
      }} catch (_e) {{
        return false;
      }}
    }}
    function bodyToSearchParams(body) {{
      try {{
        if (body == null) return new URLSearchParams();
        if (typeof body === 'string') return new URLSearchParams(body);
        if (typeof URLSearchParams !== 'undefined' && body instanceof URLSearchParams) {{
          return new URLSearchParams(body.toString());
        }}
        if (typeof FormData !== 'undefined' && body instanceof FormData) {{
          var params = new URLSearchParams();
          body.forEach(function(value, key) {{ params.append(key, value); }});
          return params;
        }}
      }} catch (_e) {{}}
      return null;
    }}
    function replaceBodyW(body, wParam) {{
      var params = bodyToSearchParams(body);
      if (!params) return body;
      params.set('w', wParam);
      if (typeof body === 'string' || body == null) return params.toString();
      if (typeof URLSearchParams !== 'undefined' && body instanceof URLSearchParams) return params;
      if (typeof FormData !== 'undefined' && body instanceof FormData) {{
        body.set('w', wParam);
        return body;
      }}
      return params.toString();
    }}
    function applyNativeAjaxContractToParams(params) {{
      if (!params) return params;
      params.set('client_type', 'android');
      params.set('pt', '20');
      params.delete('$BCm');
      return params;
    }}
    function applyNativeAjaxContractToBody(body, wParam) {{
      var params = bodyToSearchParams(body);
      if (!params) return body;
      applyNativeAjaxContractToParams(params);
      params.set('w', wParam);
      if (typeof body === 'string' || body == null) return params.toString();
      if (typeof URLSearchParams !== 'undefined' && body instanceof URLSearchParams) return params;
      if (typeof FormData !== 'undefined' && body instanceof FormData) {{
        body.set('client_type', 'android');
        body.set('pt', '20');
        body.set('w', wParam);
        return body;
      }}
      return params.toString();
    }}
    function resolveNativeAjaxReplacement(rawUrl, source) {{
      try {{
        if (!slideDebugMode || !isGeetestAjaxUrl(rawUrl)) return null;
        var parsed = new URL(String(rawUrl), window.location.href);
        var originalW = parsed.searchParams.get('w') || '';
        var track = window.__GT3_TRAJECTORY || null;
        if (!track || !track.points || !track.points.length) {{
          mini.textContent = 'ajax without trajectory';
          window.__GT3_LAST_AJAX = {{
            ts: Date.now(),
            url: String(rawUrl || ''),
            source: source || '',
            has_track: false,
            native_w_present: false,
            original_client_type: parsed.searchParams.get('client_type') || '',
            original_w_prefix: originalW.slice(0, 24),
            original_w_looks_base64_json: /^eyJ/.test(originalW)
          }};
          updatePanel();
          return null;
        }}
        var result = postTrajectorySync(track, {{ auto_submit: false, source: source || 'ajax-sync' }}) || {{}};
        var exchange = result && result.exchange || {{}};
        var wParam = exchange && exchange.w_param || '';
        var replacementChanged = false;
        window.__GT3_LAST_AJAX = {{
          ts: Date.now(),
          url: String(rawUrl || ''),
          source: source || '',
          has_track: true,
          point_count: track.points.length,
          offset_x: track.offset_x || 0,
          native_w_present: !!wParam,
          w_len: String(wParam || '').length,
          replaced_url: parsed.toString(),
          original_client_type: parsed.searchParams.get('client_type') || '',
          original_w_prefix: originalW.slice(0, 24),
          original_w_looks_base64_json: /^eyJ/.test(originalW),
          backend_w_prefix: String(wParam || '').slice(0, 24),
          backend_w_looks_base64_json: /^eyJ/.test(String(wParam || '')),
          replacement_changed: false
        }};
        if (!wParam) {{
          mini.textContent = 'native w missing';
          updatePanel();
          return {{ rawUrl: String(rawUrl || ''), replacedUrl: parsed.toString(), result: result, wParam: '' }};
        }}
        applyNativeAjaxContractToParams(parsed.searchParams);
        parsed.searchParams.set('w', wParam);
        replacementChanged = parsed.toString() !== String(rawUrl || '');
        emit('gtNativeAjaxW', {{
          source: source || '',
          from_cache: !!(result && result.from_cache),
          offset_x: track.offset_x || 0,
          point_count: track.points.length,
          native_w_present: true,
          w_len: wParam.length,
          replacement_changed: replacementChanged,
          original_client_type: window.__GT3_LAST_AJAX.original_client_type || '',
          backend_w_looks_base64_json: /^eyJ/.test(String(wParam || ''))
        }});
        mini.textContent = 'native w injected';
        window.__GT3_LAST_AJAX.replaced_url = parsed.toString();
        window.__GT3_LAST_AJAX.replacement_changed = replacementChanged;
        window.__GT3_LAST_AJAX.replaced_client_type = parsed.searchParams.get('client_type') || '';
        updatePanel();
        return {{
          rawUrl: String(rawUrl || ''),
          replacedUrl: parsed.toString(),
          result: result,
          wParam: wParam
        }};
      }} catch (err) {{
        window.__GT3_LAST_AJAX = {{
          ts: Date.now(),
          url: String(rawUrl || ''),
          source: source || '',
          has_track: !!(window.__GT3_TRAJECTORY && window.__GT3_TRAJECTORY.points && window.__GT3_TRAJECTORY.points.length),
          native_w_present: false,
          error: String(err && err.message || err)
        }};
        mini.textContent = 'native w error';
        updatePanel();
        return null;
      }}
    }}
    window.__GT3ResolveNativeAjaxReplacement = resolveNativeAjaxReplacement;
    function ensureNativeWForAjax(rawUrl, body) {{
      if (!slideDebugMode || !isGeetestAjaxUrl(rawUrl)) return body;
      try {{
        var parsed = new URL(String(rawUrl), window.location.href);
        if ((body == null || body === '') && parsed.searchParams.has('w')) {{
          return body;
        }}
      }} catch (_e) {{}}
      var replacement = resolveNativeAjaxReplacement(rawUrl, 'xhr-body');
      if (!replacement || !replacement.wParam) {{
        return body;
      }}
      return applyNativeAjaxContractToBody(body, replacement.wParam);
    }}
    try {{
      if (!window.__GT3_XHR_INTERCEPTED) {{
        window.__GT3_XHR_INTERCEPTED = true;
        var originalXhrOpen = XMLHttpRequest.prototype.open;
        XMLHttpRequest.prototype.open = function(method, url) {{
          arguments[1] = rewriteGeetestUrl(url);
          this.__gt3Method = method;
          this.__gt3Url = arguments[1];
          return originalXhrOpen.apply(this, arguments);
        }};
        var originalXhrSend = XMLHttpRequest.prototype.send;
        XMLHttpRequest.prototype.send = function(body) {{
          try {{
            body = ensureNativeWForAjax(this.__gt3Url, body);
          }} catch (_e) {{}}
          return originalXhrSend.call(this, body);
        }};
      }}
    }} catch (_e) {{}}
    try {{
      if (window.fetch && !window.__GT3_FETCH_INTERCEPTED) {{
        window.__GT3_FETCH_INTERCEPTED = true;
        var originalFetch = window.fetch.bind(window);
        window.fetch = function(resource, init) {{
          var requestUrl = '';
          if (typeof Request !== 'undefined' && resource instanceof Request && (!init || !Object.prototype.hasOwnProperty.call(init, 'body'))) {{
            requestUrl = resource.url;
            var rewrittenUrl = rewriteGeetestUrl(resource.url);
            var method = String(resource.method || 'GET').toUpperCase();
            if (method !== 'GET' && method !== 'HEAD') {{
              return resource.clone().text().then(function(textBody) {{
                var rewrittenBody = ensureNativeWForAjax(requestUrl, textBody);
                return originalFetch(new Request(rewrittenUrl, {{
                  method: resource.method,
                  headers: resource.headers,
                  body: rewrittenBody,
                  mode: resource.mode,
                  credentials: resource.credentials,
                  cache: resource.cache,
                  redirect: resource.redirect,
                  referrer: resource.referrer,
                  referrerPolicy: resource.referrerPolicy,
                  integrity: resource.integrity,
                  keepalive: resource.keepalive,
                  signal: resource.signal
                }}));
              }});
            }}
            resource = new Request(rewrittenUrl, resource);
          }}
          if (typeof resource === 'string') {{
            requestUrl = resource;
            resource = rewriteGeetestUrl(resource);
          }} else if (resource && resource.url) {{
            requestUrl = resource.url;
            resource = new Request(rewriteGeetestUrl(resource.url), resource);
          }}
          if (init && Object.prototype.hasOwnProperty.call(init, 'body')) {{
            init.body = ensureNativeWForAjax(requestUrl || resource, init.body);
          }}
          return originalFetch(resource, init);
        }};
      }}
    }} catch (_e) {{}}
    document.getElementById('gt3-copy').onclick = function() {{
      if (navigator.clipboard) navigator.clipboard.writeText(out.value || '');
    }};
    document.getElementById('gt3-copy-ci').onclick = function() {{
      var info = latestCaptchaInfo();
      if (info && navigator.clipboard) navigator.clipboard.writeText(JSON.stringify(info, null, 2));
    }};
    function emit(name, payload) {{
      var event = {{ ts: Date.now(), fn: name, payload: payload }};
      window.__GT3_CAPTURE = window.__GT3_CAPTURE || {{ app3_url: {json.dumps(app3_url)}, events: [] }};
      window.__GT3_CAPTURE.events.push(event);
      mini.textContent = (name === 'gtCallBack' && payload && payload.code === '1') ? 'success' : name;
      updatePanel();
      try {{
        var packet = {{
          kind: 'gt3-capture',
          payload: window.__GT3_CAPTURE,
          captcha_info: latestCaptchaInfo(),
          trajectory_debug: window.__GT3_TRAJECTORY_DEBUG || null,
          ajax_debug: window.__GT3_LAST_AJAX || null,
          intercept_debug: {{
            sources_seen: ((window.__GT3_CAPTURE || {{}}).events || []).filter(function(evt) {{ return evt && evt.fn === 'gtNativeAjaxW'; }}).map(function(evt) {{ return ((evt.payload || {{}}).source) || ''; }}),
            last_source: (((window.__GT3_LAST_AJAX || {{}}).source) || ''),
            native_w_present: !!((window.__GT3_LAST_AJAX || {{}}).native_w_present),
            w_len: ((window.__GT3_LAST_AJAX || {{}}).w_len) || 0,
            point_count: ((window.__GT3_LAST_AJAX || {{}}).point_count) || 0,
            replaced_url_present: !!((window.__GT3_LAST_AJAX || {{}}).replaced_url)
          }}
        }};
        if (window.parent && window.parent !== window) window.parent.postMessage(packet, '*');
        if (window.opener) window.opener.postMessage(packet, '*');
      }} catch (_e) {{}}
    }}
    function isGeetestTarget(el) {{
      if (!el) return false;
      var cur = el;
      while (cur) {{
        if (cur.id && /geetest|gt_/i.test(cur.id)) return true;
        if (cur.className && typeof cur.className === 'string' && /geetest|gt_/i.test(cur.className)) return true;
        cur = cur.parentElement;
      }}
      return false;
    }}
    function appendTrajectoryPoint(state, clientX, clientY, now, force) {{
      if (!state) return;
      var dx = clientX - state.startX;
      var dy = clientY - state.startY;
      var t = now - state.startT;
      if (dx < 0) dx = 0;
      state.offset_x = dx;
      if (!force && (t - state.lastTs) < 8) {{
        state.droppedMoves = (state.droppedMoves || 0) + 1;
        return;
      }}
      var point = {{ x: Math.round(dx), y: Math.round(dy), t_ms: Math.round(t) }};
      var last = (state.points && state.points.length) ? state.points[state.points.length - 1] : null;
      state.lastTs = t;
      state.moveEventsSeen = (state.moveEventsSeen || 0) + 1;
      if (last && last.x === point.x && last.y === point.y && last.t_ms === point.t_ms) {{
        return;
      }}
      state.points.push(point);
    }}
    var dragState = null;
    document.addEventListener('pointerdown', function(ev) {{
      if (!isGeetestTarget(ev.target)) return;
      dragState = {{
        startX: ev.clientX,
        startY: ev.clientY,
        startT: Date.now(),
        points: [{{ x: 0, y: 0, t_ms: 0 }}],
        lastTs: 0,
        offset_x: 0,
        moveEventsSeen: 0,
        droppedMoves: 0
      }};
    }}, true);
    document.addEventListener('pointermove', function(ev) {{
      if (!dragState) return;
      appendTrajectoryPoint(dragState, ev.clientX, ev.clientY, Date.now(), false);
    }}, true);
    document.addEventListener('pointerup', function(ev) {{
      if (!dragState) return;
      appendTrajectoryPoint(dragState, ev.clientX, ev.clientY, Date.now(), true);
      var track = {{
        offset_x: Math.round(dragState.offset_x || 0),
        points: dragState.points || []
      }};
      var trajectoryDebug = {{
        move_events_seen: dragState.moveEventsSeen || 0,
        move_events_dropped_lt_8ms: dragState.droppedMoves || 0,
        points_count: track.points.length,
        final_offset_x: track.offset_x
      }};
      window.__GT3_TRAJECTORY = track;
      window.__GT3_TRAJECTORY_DEBUG = trajectoryDebug;
      dragState = null;
      mini.textContent = 'trajectory captured';
      updatePanel();
      if (track.points.length >= 2) {{
        postTrajectory(track, {{ auto_submit: false, source: 'pointerup-prefetch' }});
      }} else {{
        window.__GT3_TRAJECTORY_RESULT = {{ ok: false, skipped: true, reason: 'trajectory_too_short', source: 'pointerup-prefetch' }};
        updatePanel();
      }}
    }}, true);
    window.JSInterface = {{
      gtReady: function() {{ emit('gtReady', {{}}); }},
      gtClose: function() {{ emit('gtClose', {{}}); }},
      gtNotify: function(raw) {{
        var parsed = raw;
        try {{ parsed = JSON.parse(raw); }} catch (_e) {{}}
        emit('gtNotify', parsed);
      }},
      gtError: function() {{ emit('gtError', {{}}); }},
      gt3Error: function(raw) {{
        var parsed = raw;
        try {{ parsed = JSON.parse(raw); }} catch (_e) {{}}
        emit('gt3Error', parsed);
      }},
      gtCallBack: function(code, result, message) {{
        var parsed = result;
        try {{ parsed = JSON.parse(result); }} catch (_e) {{}}
        emit('gtCallBack', {{ code: String(code), message: String(message || ''), result: parsed }});
      }}
    }};
  }}
  mount();
}})();
</script>
"""
    index = html.find("<script>")
    if index >= 0:
        return html[:index] + inject + html[index:]
    end = html.rfind("</body>")
    if end >= 0:
        return html[:end] + inject + html[end:]
    return html + inject


class Handler(BaseHTTPRequestHandler):
    def _json(self, payload, status=HTTPStatus.OK):
        body = json.dumps(payload, ensure_ascii=False).encode("utf-8")
        self.send_response(status)
        self.send_header("content-type", "application/json; charset=utf-8")
        self.send_header("content-length", str(len(body)))
        self.end_headers()
        self.wfile.write(body)

    def _html(self, html, status=HTTPStatus.OK):
        body = html.encode("utf-8")
        self.send_response(status)
        self.send_header("content-type", "text/html; charset=utf-8")
        self.send_header("content-length", str(len(body)))
        self.end_headers()
        self.wfile.write(body)

    def _javascript(self, script, status=HTTPStatus.OK):
        body = script.encode("utf-8")
        self.send_response(status)
        self.send_header("content-type", "application/javascript; charset=utf-8")
        self.send_header("content-length", str(len(body)))
        self.end_headers()
        self.wfile.write(body)

    def _read_json(self):
        length = int(self.headers.get("content-length", "0"))
        raw = self.rfile.read(length).decode("utf-8", errors="replace")
        return json.loads(raw or "{}")

    def do_GET(self):
        parsed = urllib.parse.urlparse(self.path)
        if parsed.path == "/health":
            return self._json({"status": "ok"})
        if parsed.path == "/":
            return self._html(INDEX_HTML)
        if parsed.path in ("/api/geetest/native_get", "/api/geetest/native_ajax"):
            try:
                qs = urllib.parse.parse_qs(parsed.query)
                callback = (qs.get("callback") or ["geetest_callback"])[-1]
                session = resolve_session((qs.get("sid") or [None])[-1])
                debug_session = session.get("debug_session") or {}
                native = debug_session.get("native_prewarm") or session.get("native_prewarm") or {}
                gt = (qs.get("gt") or [""])[-1]
                challenge = (qs.get("challenge") or [""])[-1]
                followup = native.get("followup_get_raw") or {}
                allowed_challenges = {
                    str(native.get("challenge") or "").strip(),
                    str((followup.get("challenge") if isinstance(followup, dict) else "") or "").strip(),
                }
                allowed_challenges.discard("")
                if gt and gt != native.get("gt"):
                    raise ValueError("native geetest proxy gt mismatch")
                if challenge and challenge not in allowed_challenges:
                    raise ValueError("native geetest proxy challenge mismatch")
                if parsed.path.endswith("native_ajax"):
                    ajax_mode = normalize_native_ajax_mode((qs.get("ajax_mode") or [None])[-1])
                    native_forward_url = (qs.get("native_forward_url") or [""])[-1].strip()
                    forward_url = (qs.get("forward_url") or [""])[-1].strip()
                    runtime_candidate = native_forward_url or forward_url
                    trusted_truth = extract_session_production_truth(
                        session, require_trusted=True
                    )
                    truth_source = production_truth_source_tag(trusted_truth)
                    truth_matches = truth_matches_runtime_request(
                        trusted_truth,
                        gt or str((trusted_truth or {}).get("gt") or ""),
                        challenge
                        or str((trusted_truth or {}).get("final_challenge") or ""),
                    ) if trusted_truth else False
                    selected_mode = "production-truth"
                    if not trusted_truth:
                        payload = {
                            "status": "error",
                            "user_error": "缺少生产端验证码真值",
                            "error_code": "missing_production_truth",
                            "msg": "native-only mode requires imported production GT3 proof truth",
                            "attempts": [
                                {
                                    "mode": "production-truth",
                                    "error": "missing trusted production_proof_truth",
                                    "url": runtime_candidate,
                                }
                            ],
                        }
                        capture = session.get("last_capture_packet") or {}
                        ajax_debug = capture.get("ajax_debug") or {}
                        ajax_debug["ajax_mode"] = ajax_mode
                        ajax_debug["proxy_attempts"] = payload["attempts"]
                        ajax_debug["proxy_selected_mode"] = "blocked"
                        ajax_debug["proxy_status"] = "error"
                        ajax_debug["proxy_error_code"] = payload["error_code"]
                        ajax_debug["truth_present"] = False
                        ajax_debug["truth_source"] = ""
                        ajax_debug["truth_matches_runtime_request"] = False
                        capture["ajax_debug"] = ajax_debug
                        session["last_capture_packet"] = capture
                        session["last_proxy_ajax"] = {
                            "ts_ms": int(time.time() * 1000),
                            "ajax_mode": ajax_mode,
                            "proxy_attempts": payload["attempts"],
                            "proxy_selected_mode": "blocked",
                            "proxy_status": "error",
                            "proxy_error_code": payload["error_code"],
                            "truth_present": False,
                            "truth_source": "",
                            "truth_client_type": "",
                            "truth_pt": "",
                            "truth_w_length": 0,
                            "truth_matches_runtime_request": False,
                        }
                        save_session(session, force_latest=False)
                        return self._javascript(
                            f"{callback}({json.dumps(payload, ensure_ascii=False)})",
                            status=HTTPStatus.BAD_REQUEST,
                        )
                    if not truth_matches:
                        payload = {
                            "status": "error",
                            "user_error": "验证码会话不匹配",
                            "error_code": "production_truth_mismatch",
                            "msg": "trusted production GT3 proof truth does not match current gt/challenge",
                            "attempts": [
                                {
                                    "mode": "production-truth",
                                    "error": "trusted production_proof_truth mismatch",
                                    "url": runtime_candidate,
                                }
                            ],
                        }
                        capture = session.get("last_capture_packet") or {}
                        ajax_debug = capture.get("ajax_debug") or {}
                        ajax_debug["ajax_mode"] = ajax_mode
                        ajax_debug["proxy_attempts"] = payload["attempts"]
                        ajax_debug["proxy_selected_mode"] = "blocked"
                        ajax_debug["proxy_status"] = "error"
                        ajax_debug["proxy_error_code"] = payload["error_code"]
                        ajax_debug["truth_present"] = True
                        ajax_debug["truth_source"] = truth_source
                        ajax_debug["truth_client_type"] = str((trusted_truth or {}).get("client_type") or "")
                        ajax_debug["truth_pt"] = str((trusted_truth or {}).get("pt") or "")
                        ajax_debug["truth_w_length"] = (trusted_truth or {}).get("w_length") or len(
                            str((trusted_truth or {}).get("w") or "")
                        )
                        ajax_debug["truth_matches_runtime_request"] = False
                        capture["ajax_debug"] = ajax_debug
                        session["last_capture_packet"] = capture
                        session["last_proxy_ajax"] = {
                            "ts_ms": int(time.time() * 1000),
                            "ajax_mode": ajax_mode,
                            "proxy_attempts": payload["attempts"],
                            "proxy_selected_mode": "blocked",
                            "proxy_status": "error",
                            "proxy_error_code": payload["error_code"],
                            "truth_present": True,
                            "truth_source": truth_source,
                            "truth_client_type": str((trusted_truth or {}).get("client_type") or ""),
                            "truth_pt": str((trusted_truth or {}).get("pt") or ""),
                            "truth_w_length": (trusted_truth or {}).get("w_length") or len(
                                str((trusted_truth or {}).get("w") or "")
                            ),
                            "truth_matches_runtime_request": False,
                        }
                        save_session(session, force_latest=False)
                        return self._javascript(
                            f"{callback}({json.dumps(payload, ensure_ascii=False)})",
                            status=HTTPStatus.BAD_REQUEST,
                        )
                    candidate = build_forward_url_from_truth(trusted_truth, callback)
                    try:
                        forwarded = forward_native_ajax_via_backend(session, candidate)
                        body_text = forwarded.get("body_text") or ""
                        body_status = forwarded.get("status")
                        body_error = forwarded.get("error_code")
                        attempt_debug = [
                            {
                                "mode": selected_mode,
                                "status": body_status,
                                "error_code": body_error,
                                "cookie_count": forwarded.get("cookie_count"),
                                "url": candidate,
                            }
                        ]
                        session["last_proxy_ajax"] = {
                            "ts_ms": int(time.time() * 1000),
                            "ajax_mode": ajax_mode,
                            "proxy_attempts": attempt_debug,
                            "proxy_selected_mode": selected_mode,
                            "proxy_status": body_status,
                            "proxy_error_code": body_error,
                            "truth_present": True,
                            "truth_source": truth_source,
                            "truth_client_type": str((trusted_truth or {}).get("client_type") or ""),
                            "truth_pt": str((trusted_truth or {}).get("pt") or ""),
                            "truth_w_length": (trusted_truth or {}).get("w_length") or len(
                                str((trusted_truth or {}).get("w") or "")
                            ),
                            "truth_matches_runtime_request": True,
                        }
                        capture = session.get("last_capture_packet") or {}
                        ajax_debug = capture.get("ajax_debug") or {}
                        ajax_debug["ajax_mode"] = ajax_mode
                        ajax_debug["proxy_attempts"] = attempt_debug
                        ajax_debug["proxy_selected_mode"] = selected_mode
                        ajax_debug["proxy_status"] = body_status
                        ajax_debug["proxy_error_code"] = body_error
                        ajax_debug["truth_present"] = True
                        ajax_debug["truth_source"] = truth_source
                        ajax_debug["truth_client_type"] = str((trusted_truth or {}).get("client_type") or "")
                        ajax_debug["truth_pt"] = str((trusted_truth or {}).get("pt") or "")
                        ajax_debug["truth_w_length"] = (trusted_truth or {}).get("w_length") or len(
                            str((trusted_truth or {}).get("w") or "")
                        )
                        ajax_debug["truth_matches_runtime_request"] = True
                        capture["ajax_debug"] = ajax_debug
                        session["last_capture_packet"] = capture
                        save_session(session, force_latest=False)
                        return self._javascript(body_text)
                    except Exception as attempt_exc:
                        payload = {
                            "status": "error",
                            "user_error": "网络不给力",
                            "error_code": "proxy_forward_failed",
                            "msg": str(attempt_exc),
                            "attempts": [{"mode": selected_mode, "error": str(attempt_exc), "url": candidate}],
                        }
                        capture = session.get("last_capture_packet") or {}
                        ajax_debug = capture.get("ajax_debug") or {}
                        ajax_debug["ajax_mode"] = ajax_mode
                        ajax_debug["proxy_attempts"] = payload["attempts"]
                        ajax_debug["proxy_selected_mode"] = selected_mode
                        ajax_debug["proxy_status"] = "error"
                        ajax_debug["proxy_error_code"] = "proxy_forward_failed"
                        ajax_debug["truth_present"] = True
                        ajax_debug["truth_source"] = truth_source
                        ajax_debug["truth_client_type"] = str((trusted_truth or {}).get("client_type") or "")
                        ajax_debug["truth_pt"] = str((trusted_truth or {}).get("pt") or "")
                        ajax_debug["truth_w_length"] = (trusted_truth or {}).get("w_length") or len(
                            str((trusted_truth or {}).get("w") or "")
                        )
                        ajax_debug["truth_matches_runtime_request"] = True
                        capture["ajax_debug"] = ajax_debug
                        session["last_capture_packet"] = capture
                        session["last_proxy_ajax"] = {
                            "ts_ms": int(time.time() * 1000),
                            "ajax_mode": ajax_mode,
                            "proxy_attempts": payload["attempts"],
                            "proxy_selected_mode": selected_mode,
                            "proxy_status": "error",
                            "proxy_error_code": "proxy_forward_failed",
                            "truth_present": True,
                            "truth_source": truth_source,
                            "truth_client_type": str((trusted_truth or {}).get("client_type") or ""),
                            "truth_pt": str((trusted_truth or {}).get("pt") or ""),
                            "truth_w_length": (trusted_truth or {}).get("w_length") or len(
                                str((trusted_truth or {}).get("w") or "")
                            ),
                            "truth_matches_runtime_request": True,
                        }
                        save_session(session, force_latest=False)
                        return self._javascript(
                            f"{callback}({json.dumps(payload, ensure_ascii=False)})",
                            status=HTTPStatus.BAD_GATEWAY,
                        )
                payload = native.get("followup_get_raw") or native.get("get_raw")
                if not payload:
                    raise ValueError("native geetest payload unavailable")
                return self._javascript(f"{callback}({json.dumps(payload, ensure_ascii=False)})")
            except Exception as exc:
                return self._javascript(
                    f"{(urllib.parse.parse_qs(parsed.query).get('callback') or ['geetest_callback'])[-1]}("
                    + json.dumps(
                        {"status": "error", "user_error": "网络不给力", "error_code": "proxy_error", "msg": str(exc)},
                        ensure_ascii=False,
                    )
                    + ")",
                    status=HTTPStatus.BAD_REQUEST,
                )
        if parsed.path == "/api/session":
            try:
                return self._json(prepare_backend_session(force=False))
            except Exception as exc:
                return self._json({"ok": False, "error": str(exc)}, status=HTTPStatus.BAD_REQUEST)
        if parsed.path == "/api/audit/latest":
            audit = load_latest_audit()
            if audit:
                return self._json({"ok": True, "audit": audit})
            return self._json({"ok": True, "audit": None})
        if parsed.path == "/api/example":
            return self._json(load_example())
        if parsed.path == "/play":
            qs = urllib.parse.parse_qs(parsed.query)
            app3_url = (qs.get("app3_url") or [""])[0]
            expected_captcha_type = coerce_captcha_type(
                (qs.get("captcha_type") or [None])[-1], default=1
            )
            native_ajax_mode = normalize_native_ajax_mode((qs.get("native_ajax_mode") or [None])[-1])
            if not app3_url and parsed.query:
                app3_url = rebuild_app3_url_from_query(parsed.query)
            if expected_captcha_type == 1:
                try:
                    session = prepare_backend_session(force=False)
                    expected_captcha_type = coerce_captcha_type(
                        (((session.get("debug_session") or {}).get("ticket") or {}).get("captcha_type")),
                        default=expected_captcha_type,
                    )
                    native_ajax_mode = normalize_native_ajax_mode(
                        ((session.get("debug_session") or {}).get("native_ajax_mode")) or native_ajax_mode
                    )
                except Exception:
                    pass
            if not app3_url:
                return self._html("<h3>missing app3_url</h3>", status=HTTPStatus.BAD_REQUEST)
            try:
                if not normalize_domain(urllib.parse.urlparse(app3_url).netloc):
                    raise ValueError("invalid app3_url")
                html = align_app3_contract(fetch_text(app3_url))
                return self._html(
                    inject_bridge(
                        html,
                        app3_url,
                        expected_captcha_type=expected_captcha_type,
                        native_ajax_mode=native_ajax_mode,
                    )
                )
            except Exception as exc:
                return self._html(
                    f"<h3>failed to load app3</h3><pre>{exc}</pre>",
                    status=HTTPStatus.BAD_GATEWAY,
                )
        self.send_error(HTTPStatus.NOT_FOUND)

    def do_POST(self):
        parsed = urllib.parse.urlparse(self.path)
        try:
            payload = self._read_json()
            if parsed.path == "/api/session/refresh":
                return self._json(prepare_backend_session(force=True))
            if parsed.path == "/api/capture_event":
                return self._json(record_capture_event(payload))
            if parsed.path == "/api/gt3-trajectory":
                return self._json(submit_manual_gt3_trajectory(payload))
            if parsed.path == "/api/build_app3":
                return self._json(build_app3_url(payload))
            if parsed.path == "/api/build_from_trace":
                return self._json(build_from_trace(payload))
            if parsed.path == "/api/validate_template":
                return self._json(build_validate_template(payload))
            if parsed.path == "/api/production_truth/import":
                return self._json(import_session_production_truth(payload))
            if parsed.path == "/api/validate_submit":
                request_session_id = (payload.get("session_id") or "").strip()
                trace_path = (payload.get("trace_path") or "").strip()
                if not trace_path:
                    bound_session = resolve_session(request_session_id)
                    trace_path = (
                        (bound_session.get("native_trace_path") or "").strip()
                        or (bound_session.get("debug_trace_path") or "").strip()
                    )
                return self._json(
                    submit_validate_with_backend(
                        payload.get("captcha_info") or {},
                        trace_path,
                        session_id=request_session_id,
                    )
                )
        except Exception as exc:
            return self._json({"ok": False, "error": str(exc)}, status=HTTPStatus.BAD_REQUEST)
        self.send_error(HTTPStatus.NOT_FOUND)


def main():
    parser = argparse.ArgumentParser(description="GT3 app3 web runner")
    parser.add_argument("--host", default="0.0.0.0")
    parser.add_argument("--port", type=int, default=8880)
    args = parser.parse_args()
    server = ThreadingHTTPServer((args.host, args.port), Handler)
    print(f"[gt3-web] serving on http://{args.host}:{args.port}")
    server.serve_forever()


if __name__ == "__main__":
    main()
