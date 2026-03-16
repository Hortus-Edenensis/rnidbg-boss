# RNIDBG

An ARM64 emulator written in Rust, based on the secondary development of unidbg.。[Join us now!](https://discord.gg/MKR2wz863h)

## Build Me

- Make sure your Rust version is 1.85+, otherwise upgrade!
- If Linux, make sure that `libfmt`/`boost` is available in your environment (**dynarmic backend**).

## Release Automation

- Pull requests and pushes to `main` run GitHub Actions validation for both the default `dynarmic` backend and the `unicorn` backend, plus a full Docker image build.
- The Docker CI job builds the `unicorn-check` target for containerized test coverage and then builds the `final` target to verify the publishable image layout.
- Pushing a `v*` tag publishes a multi-architecture GHCR image and uploads release archives for the supported operating system and architecture matrix.
- Recommended tag format is `vYY.MM.DD` for stable releases, with `-alpha.N` or `-beta.N` suffixes for prereleases, for example `v26.03.14-beta.1`.
- Prerelease tags publish versioned artifacts and packages without moving the `latest` image tag.
- Release assets are uploaded directly to GitHub Releases instead of using Actions artifacts, so publishing is not blocked by artifact storage quota limits.
- Release Docker publishing exports only the `final` target, so it does not rerun the full Rust test suite inside the multi-architecture image build.
- Release archives are produced on native runners:
  - Linux `x86_64` and `aarch64` use the default `dynarmic` backend.
  - macOS `x86_64` and `aarch64`, plus Windows `x86_64`, use the `unicorn` backend for broader portability.
  - Windows `aarch64` release archives are temporarily disabled until Unicorn's upstream Windows ARM64 build stops depending on an x64-only MASM wrapper.

## Container Lab

- The repository includes a reusable BossYzwg container lab that runs through `docker compose`.
- By default the compose stack mounts this repository at `/workspace/rnidbg` and a reverse-engineering asset workspace at `/workspace/lab-assets`.
- If your asset workspace is not the sibling path `../drizzle-dumper-rust`, set `RNIDBG_ASSETS_ROOT=/absolute/path/to/assets-repo` before running the helper scripts.
- The tracked generic config is `config/lab-config.container.json` and is the default for the container helpers.

Common commands:

```bash
docker compose up -d rnidbg-lab
./bin/yzwg-invoke.sh --method nativeSignature --arg1 '/api/health-check' --arg2 ''
./bin/run-trace.sh --method-filter nativeSignature
./bin/replay-samples.sh 3
./bin/start-http-bridge.sh
./bin/verify-http-bridge.sh
```

- The host HTTP bridge binds to `http://127.0.0.1:28080` by default.
- The QR web authorization service can run as a dedicated persistent container:

```bash
./bin/start-qr-web.sh
```

- Default host endpoints for the QR web service:
  - `http://127.0.0.1:28786/`
  - `http://127.0.0.1:28786/health`
  - `http://127.0.0.1:28786/api/state/latest`
- Its persisted uploads and latest decode/authorize snapshots are written into the named Docker volume mounted at `/workspace/lab-data/qr-web` inside the container.
- To use a custom config inside the container, set `RNIDBG_LAB_CONFIG` to the container-visible config path before invoking the helper scripts.
- Supporting docs:
  - `docs/product-usage.md`
  - `docs/c4-model.md`
  - `docs/roadmap.md`

## DEVELOPER DEBUGGING COMPILE TIME VARIABLES

| 变量名                     | 说明                             | 默认值 |
|-------------------------|--------------------------------|-----|
| PRINT_SYSCALL_LOG       | print syscall log              | 0   |
| SHOW_INIT_FUNC_CALL     | print `init_function` calls    | 0   |
| SHOW_MODULES_INSERT_LOG | print module loading log       | 0   |
| PRINT_SVC_REGISTER      | print service registration log | 0   |
| PRINT_JNI_CALLS         | print jni call log             | 0   |
| DYNARMIC_DEBUG          | print dynarmic logs            | 0   |
| EMU_LOG                 | print emulator logs            | 0   |
| PRINT_MMAP_LOG          | print virtual mmap logs        | 0   |

## RUN TIME VARIABLE IN COMPUTING

| VARIABLE NAME     | CLARIFICATION        | DEFAULT VALUE |
|-------------------|----------------------|---------------|
| DYNARMIC_JIT_SIZE | Code Cache Size (MB) | 64            |

## TODO

- [ ] Add support for debugging
- [ ] Add support for more syscall
- [ ] Beautiful JNI implementation (unsafe block)
- [ ] Implement most system libraries as virtual modules

## Thanks

- [Rust](https://www.rust-lang.org/)
- [unidbg](https://github.com/zhkl0228/unidbg)
- [dynarmic](https://github.com/lioncash/dynarmic)
- [Dobby](https://github.com/jmpews/Dobby)
