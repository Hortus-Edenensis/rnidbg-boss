FROM rust:1.85.1-bookworm AS base

SHELL ["/bin/bash", "-o", "pipefail", "-c"]

ENV DEBIAN_FRONTEND=noninteractive

COPY scripts/install-linux-build-deps.sh /usr/local/bin/install-linux-build-deps.sh
RUN bash /usr/local/bin/install-linux-build-deps.sh && rm -rf /var/lib/apt/lists/*

WORKDIR /workspace

COPY . .

FROM base AS dynarmic-check

# Validate the emulator crate and the default project configuration, which uses
# the Dynarmic backend.
RUN cargo test --manifest-path emulator/Cargo.toml --features dynarmic_backend --lib
RUN cargo test

FROM dynarmic-check AS unicorn-check

# Verify the Unicorn backend in the same container environment.
RUN cargo test --no-default-features --features unicorn

FROM base AS final

# The release image should not rerun the validation stages. CI builds the
# `unicorn-check` target explicitly, while release publishing only exports this
# final image.

CMD ["bash"]
