# BossYzwg Container Lab C4 Model

## C1: Context

The BossYzwg container lab sits between a reverse-engineering operator and a mounted asset workspace. It offers a repeatable entrypoint for reproducing target-native behaviors without requiring a hand-built local `unidbg-lab`.

Actors and systems:

- Reverse-engineering operator: runs compose and helper scripts
- `rnidbg-lab`: the reusable containerized execution surface
- Asset workspace: APKs, native libraries, lookup datasets, and trace outputs
- GitHub Actions and releases: distribute validated binaries and images

## C2: Container

### `rnidbg-lab` container

- Base image: Rust toolchain container with build dependencies
- Mounted repo: `/workspace/rnidbg`
- Mounted assets: `/workspace/lab-assets`
- Entrypoints:
  - `rnidbg boss-yzwg ...`
  - `rnidbg http-bridge ...`
  - helper scripts under `bin/` and `scripts/`

### Host helper layer

- `docker compose`
- thin shell wrappers that start the container, pass config paths, and verify results

## C3: Component

### CLI dispatcher

- File: `src/main.rs`
- Routes user intent into `boss-yzwg` and `http-bridge` workflows.

### BossYzwg lab runtime

- File: `src/boss_yzwg.rs`
- Loads config, mounts system properties, configures the virtual file system, loads the target library, and drives JNI-backed calls.

### HTTP bridge

- File: `src/http_bridge.rs`
- Exposes signer-oriented HTTP endpoints for external tools.

### Android/JNI extension layer

- Files under `emulator/src/android/...`
- Supplies the JNI bridge behavior needed by the target runtime, including method dispatch and object-array handling.

### Container helper scripts

- Files under `bin/` and `scripts/`
- Provide a stable operator-facing interface for trace, replay, invoke, shell, and bridge flows.

## C4: Code

Important code paths:

- `src/main.rs`: command routing and config discovery
- `src/boss_yzwg.rs`: target adapter and replay logic
- `src/http_bridge.rs`: product HTTP surface
- `emulator/src/android/dvm/jni_env_ext.rs`: synthesized JNI call shims
- `emulator/src/android/dvm/mod.rs`: VM helper queries used by the target adapter
- `docker-compose.yml`: reusable container topology
- `config/lab-config.container.json`: tracked generic config template

## Key Design Decisions

- Track a generic container config instead of user-local configs.
- Mount assets into a stable in-container path so helper scripts stay portable.
- Keep target logic in Rust instead of relying on ad hoc shell orchestration.
- Verify parity through replay samples so the product surface can be regression tested.
