# BossYzwg Container Lab Usage

## What It Provides

The BossYzwg container lab packages the `rnidbg` runtime, target-specific JNI shims, replay tooling, and an HTTP bridge behind a repeatable Docker workflow.

## Prerequisites

- Docker with Compose support
- A reverse-engineering asset workspace mounted through `RNIDBG_ASSETS_ROOT`

By default the compose stack expects:

- this repository at the current working directory
- the asset workspace at `../drizzle-dumper-rust`

If your asset workspace lives elsewhere:

```bash
export RNIDBG_ASSETS_ROOT=/absolute/path/to/drizzle-dumper-rust
```

## Start The Lab

```bash
docker compose up -d rnidbg-lab
```

## Common Workflows

### Smoke / Single Invoke

```bash
./bin/yzwg-invoke.sh --method nativeSignature --arg1 '/api/health-check' --arg2 ''
```

### Native Trace

```bash
./bin/run-trace.sh --method-filter nativeSignature
```

The trace command now also writes a structured summary artifact:

- `trace_summary.json`

That summary aggregates:

- active backend and module metadata
- registered native methods
- observed native methods from the current run
- grouped JNI and native event counts
- a tail view of the most recent JNI/native events

### Real Login Captcha Trace (App-Side Evidence)

Use the real preflight trace command when you need app-side contract evidence up to captcha validate:

```bash
./scripts/run-boss-yzwg.sh captcha-trace --phone 13800138000 --skip-validate true --out /tmp/captcha-trace.json
```

Remove `--skip-validate true` to submit the generated `captcha_info` to:

- `POST /api/zpsecureflow/captcha/validate`

If you already have a real `captcha_info` from an external GT3 session, you can
submit it through the same backend path:

```bash
./scripts/run-boss-yzwg.sh captcha-trace --phone 13800138000 --skip-gt3-exchange true --captcha-info-json '{"type":1,"challenge":"...","validate":"...","secCode":"...|jordan"}' --out /tmp/captcha-trace-submit.json
```

If you need to backfill a manually captured GT3 callback into the existing Boss
mainline without re-running `judge/machine`, use the dedicated submit-only path:

```bash
./scripts/run-boss-yzwg.sh captcha-validate-submit --trace-json /tmp/captcha-trace.json --captcha-info-json '{"type":1,"challenge":"...","validate":"...","secCode":"...|jordan"}' --out /tmp/captcha-validate-submit.json
```

This mode reuses `host` and `device` from the provided trace and only sends:

- `POST /api/zpsecureflow/captcha/validate`

This command is intentionally bounded and never calls:

- `POST /api/zppassport/phone/smsCode`
- `POST /api/zppassport/user/codeLogin`

Key output fields in `/tmp/captcha-trace.json`:

- `machine_response.zpData.startCaptcha`
- `gt3_exchange.validate`
- `gt3_exchange.sec_code`
- `captcha_info`
- `validate_request` / `validate_response` / `validate_status`
- `machine_verify_activity_replay`

Important branch note:

- If Geetest `get.php` returns a non-slider bootstrap payload (no `bg/slice`), `gt3_exchange.status` will be `needs_interactive` (with full register/raw evidence). This still indicates a successful real probe of the GT3 chain.
- If you want to hand the ticket to Web/App3 manually, add `--skip-gt3-exchange true`. That preserves a fresh `startCaptcha` challenge instead of consuming it via the repo's own `get.php` probe.

### App3 Frontend Protocol Trace (Boa JS Engine)

Use this when you need to reconstruct Geetest `app3-index` query + JS callback contracts for fullpage/click branches:

```bash
./scripts/run-boss-yzwg.sh gt3-app3-protocol --trace-json /tmp/captcha-trace-44-click.json --simulate-success true --out /tmp/gt3-app3-protocol.json
```

What this command does:

- calls `gettype.php` from trace-derived `gt/challenge/api_server`
- builds the same `app3-index.html` query contract that SDK WebView expects
- executes inline app3 script in `boa_engine` with mocked `JSInterface`
- captures `gtReady` / `gtCallBack(code,result,message)` callback payload shape
- downloads the resolved external JS URL (for example `fullpage.*.js`)

Key output fields in `/tmp/gt3-app3-protocol.json`:

- `bootstrap.type` / `bootstrap.js_path` / `bootstrap.static_servers`
- `app3_url`
- `boa.report.args` / `boa.report.config`
- `boa.report.callbacks`
- `external_js.url`

### GT3 Web Runner (Container)

If you want a browser-first manual execution flow, run the dedicated container service:

```bash
docker compose up -d rnidbg-gt3-web
```

or use the helper:

```bash
./bin/start-gt3-web.sh
```

Open:

- `http://127.0.0.1:28880/`

Recommended manual flow:

1. Open the root page
2. Click `Start Manual Solve`
3. Complete GT3 in the debug player

After `gtCallBack(code=1)`, the root page will auto-backfill the captured
`captcha_info` through backend `captcha-validate-submit`.

What this web runner provides:

- root page is now a backend-native console, not a live challenge executor
- frontend only consumes a backend-produced session; no manual `trace_json` or `gt/challenge/api_server/type` inputs remain on the page
- backend runs an authoritative native `captcha-trace` first, so the page shows the real Boss-side `gt3_exchange_status`, `validate_status`, and `captcha_info`
- backend also creates a separate fresh debug ticket, resolves `gettype.php`, and builds the final `app3-index` URL for optional inspection
- the backend runs the Boa-based `gt3-app3-protocol` flow and exposes its summary in the page, but `/play` is now an explicit debug-only route
- root page no longer auto-loads `/play` and no longer consumes the live Geetest challenge
- when backend native prewarm resolves `result=slide`, the debug player is rewritten to start from the prewarmed slide contract instead of the failing fullpage bootstrap
- `/play` still injects an Android WebView-like runtime contract:
  native `client_type=get.php` bootstrap rewrite, mobile navigator fields, `window.webkit.messageHandlers`, and HTTPS-aligned Geetest resource loading
- `/play` page still injects `JSInterface` bridge before app3 script and can post debug capture events back to the root page if you explicitly open it
- if native trace produced a real `captcha_info`, the root page also shows the derived Boss `/api/zpsecureflow/captcha/validate` request template
- root page now exposes `Backfill Captured Validate`, which reuses the current native trace context and calls backend `captcha-validate-submit`
- root page also has `Manual captcha_info Override`; if you already captured `geetest_challenge/geetest_validate/geetest_seccode` elsewhere, paste the JSON there and submit directly
- root page now also exposes `Start Manual Solve`, which refreshes the native session, opens the debug player, and auto-backfills after a successful callback

Important ticket note:

- A standard `captcha-trace` run already consumes `startCaptcha` by calling GT3 `get.php`.
- The container web runner now defaults to `--backend dynarmic`, because the Dockerized `unicorn` path is not stable for this service.
- For a standalone fresh ticket outside the container page, prefer:

```bash
./scripts/run-boss-yzwg.sh captcha-trace --backend dynarmic --phone 13800138000 --skip-gt3-exchange true --skip-validate true --out /tmp/captcha-trace-web.json
```

### Replay Validation

```bash
./bin/replay-samples.sh 3
```

### Interactive Shell

```bash
./bin/rnidbg-shell.sh
```

## HTTP Bridge

Start the bridge:

```bash
./bin/start-http-bridge.sh
```

Verify it:

```bash
./bin/verify-http-bridge.sh
```

Default host endpoints:

- `GET /health`
- `POST /api/encode`
- `POST /api/encodeRequestBody`
- `POST /api/sign`
- `POST /api/decode`

Default base URL:

- `http://127.0.0.1:28080`

## QR Web Authorization

Start the dedicated QR web container:

```bash
./bin/start-qr-web.sh
```

Default host endpoints:

- `http://127.0.0.1:28786/`
- `http://127.0.0.1:28786/health`
- `http://127.0.0.1:28786/api/state/latest`

The service runs `boss-yzwg qr-web` inside its own long-lived container and persists:

- uploaded QR images
- the latest decode result
- the latest authorize result

Those artifacts live in the named Docker volume mounted at:

- `/workspace/lab-data/qr-web`

## Config

The tracked default config is:

- `config/lab-config.container.json`

Override it with a container-visible path:

```bash
export RNIDBG_LAB_CONFIG=/workspace/rnidbg/config/your-target.json
```

## Output Artifacts

Replay and trace artifacts are written under the mounted asset workspace, for example:

- `/workspace/lab-assets/artifacts/bosszhipin-reverse-project/rnidbg-trace`
- QR web persisted state is written under `/workspace/lab-data/qr-web`

## Troubleshooting

- If the bridge port conflicts, set `RNIDBG_HTTP_PORT` before starting the bridge.
- If the QR web port conflicts, set `RNIDBG_QR_WEB_HOST_PORT` before running `./bin/start-qr-web.sh`.
- If the QR web service should use a specific mounted session file, set `RNIDBG_QR_WEB_SESSION_PATH`.
- If you want the page to show the externally reachable LAN URL instead of the container-local origin, set `RNIDBG_QR_WEB_PUBLIC_ORIGIN`.
- If assets are missing, verify `RNIDBG_ASSETS_ROOT` and the mounted file layout.
- If you need a different container repo path, override `RNIDBG_CONTAINER_REPO_ROOT`.
