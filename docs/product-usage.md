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

## Troubleshooting

- If the bridge port conflicts, set `RNIDBG_HTTP_PORT` before starting the bridge.
- If assets are missing, verify `RNIDBG_ASSETS_ROOT` and the mounted file layout.
- If you need a different container repo path, override `RNIDBG_CONTAINER_REPO_ROOT`.
