# HTTP Bridge

## Start And Verify

启动：

```bash
./bin/start-http-bridge.sh
```

验证：

```bash
./bin/verify-http-bridge.sh
```

自定义 base URL：

```bash
./bin/verify-http-bridge.sh http://127.0.0.1:28080
```

## Default Base URL

- Host base URL：`http://127.0.0.1:28080`
- Host health：`http://127.0.0.1:28080/health`

## Exposed Endpoints

- `GET /health`
- `POST /api/encode`
- `POST /api/encodeRequestBody`
- `POST /api/sign`
- `POST /api/decode`

`bin/verify-http-bridge.sh` 会实际探测 `/health`、`/api/encode` 和 `/api/sign`。

## Raw Start

```bash
./scripts/run-http-bridge.sh --config config/lab-config.container.json --port 18080
```

## How Other Flows Use It

- `--invoke-runtime bridge` 通过 `--bridge-url` 指向这个服务
- 默认 `--bridge-url` 是 `http://127.0.0.1:28080`
- 如果 bridge 不可达，而本地 signer 可用，`--invoke-runtime auto` 会倾向回退到 local

## Troubleshooting

- 端口冲突时先改 `RNIDBG_HTTP_PORT`
- bridge 起不来时先确认 `docker compose up -d rnidbg-lab`
- 若需要 raw container 端口，记住容器里默认监听 `18080`
