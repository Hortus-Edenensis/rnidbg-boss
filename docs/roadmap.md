# RNIDBG BossYzwg Container Lab Roadmap

## Goal

Turn the BossYzwg reverse-engineering workflow into a reusable container product surface that can replace one-off local `unidbg-lab` setups.

## Current State

- `docker compose` can boot a reusable `rnidbg-lab` service.
- The lab exposes CLI flows for smoke checks, trace capture, single-call invocation, replay validation, and an HTTP bridge.
- The default tracked config is container-oriented and avoids machine-specific absolute paths.
- Replay parity for the current BossYzwg samples is verified in-container.

## Next Milestones

### 1. Configuration UX

- Support multiple tracked config templates for different targets, not just BossYzwg.
- Add environment-variable interpolation inside lab config files.
- Add a config validation subcommand that reports missing assets before boot.

### 2. Target Template System

- Extract BossYzwg-specific JNI mocks into a target adapter layer.
- Define a stable trait for target modules: file mapping, system properties, JNI behaviors, and replay datasets.
- Add at least one more target to prove the lab is not single-case infrastructure.

### 3. Observability

- Emit structured trace artifacts with stable schemas for CI diffing.
- Add a summary command that compares `rnidbg` outputs against a golden dataset.
- Surface JNI misses and symbol fallbacks as machine-readable diagnostics.

### 4. Delivery

- Publish the container lab usage flow in release notes for stable tags.
- Add a dedicated CI job that boots the compose stack and runs the helper scripts end to end.
- Package example configs and sample datasets as optional release assets.

## Non-Goals

- Reproducing every `unidbg-lab` target immediately.
- Hardcoding user-local repository layouts into tracked configs.
- Requiring host-native emulator dependencies for the main usage path.
