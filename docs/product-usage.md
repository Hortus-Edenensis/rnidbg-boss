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
