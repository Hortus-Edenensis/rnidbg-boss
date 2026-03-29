# Palmchat rnidbg Flow Report

- status: `ok`
- native_log: `/Users/haojiejack/github/drizzle-dumper-rust/boss_purecalc/risk/fengkong-slide-solver/artifacts/runtime_so_live_20260329_050229/rnidbg_clean_env_live_20260329_050302/rnidbg_trace_clean_env_hashkey_fast_cfg/palmchat_native.log`
- config_path: `/Users/haojiejack/github/drizzle-dumper-rust/boss_purecalc/risk/fengkong-slide-solver/artifacts/runtime_so_live_20260329_050229/rnidbg_clean_env_live_20260329_050302/rnidbg_config.clean_env.device_maps_full.heapseed_runtime.hashkey_fast.json`
- trace_out_dir: `/Users/haojiejack/github/drizzle-dumper-rust/boss_purecalc/risk/fengkong-slide-solver/artifacts/runtime_so_live_20260329_050229/rnidbg_clean_env_live_20260329_050302/rnidbg_trace_clean_env_hashkey_fast_cfg`
- flow: `setLxData->createCKey->getEncryptedCKey->cipherWithHashKey`

## Steps
- `cipherWithHashKey` duration_ms=24 done_note=`bytes_len=64` return=`object:byte_array(len=64)`
- `createCKey` duration_ms=38
- `getEncryptedCKey` duration_ms=49 done_note=`bytes_len=256`
- `setLxData` duration_ms=0

## Cipher Evidence
- apk_path: `/Users/haojiejack/github/drizzle-dumper-rust/artifacts/palmchat_base_20260324_230038.apk`
- apk_size: `119407424`
- hash_key: `E22A02C07146655EC5CF3B9636AC6042`
- chunk_iterations_observed: `0`

## Flow Result
```json
{
  "arg1_json": {
    "ping": 1
  },
  "arg2_mode": 2,
  "arg3_bool": false,
  "cipher_hex": "901091a08d4a91b7ddc1bf998f4c32fbcc85e6502b90b32bf1648387406f3de4a2c63d23dc49b89faa6947eac6dbcb90b3ff498eef8cb7276051e2e8a1b95c26",
  "cipher_null": false,
  "cipher_return_debug": "object:byte_array(len=64)",
  "cipher_utf8": "�\u0010���J�������L2�̅�P+��+�d��@o=��=#�I���iG���ː��I�'`Q�衹\\&",
  "createCKey": "ok",
  "encrypted_ckey_hex": "7ff5d0b12d94546bb27f7f9e375071502e9a7d304c41e940c918688c7ca777ec3fb49277420b919aa11b643b81c430b472b6f1098d6333bd459162087f557e6f462afc18923e537f4760a7ac9051e15e9b2fb8cdcbd80e9ec7a7b0842add19eb399dba765c94861c3e9b55b9d63b65133bc2d6c8af777224d8b354334bef8d8a3761170788deb17d3dbbe2a60eba23cc9083ee8e3604f7facd0a0f648480a73c708f00d094beb267fc9249284e4dc359ee5727f32bebd7e279fc7fc0a37c9057b96a487dc94a86a3b3f5edf6419d775ce232fe80905a7cf48ebf3f9806f397da195e9fb36b47234e7e065b1d36a145976b532e51f7df973b72afffb9e4a9bf59",
  "encrypted_ckey_utf8": "�б-�Tk��7PqP.�}0LA�@�\u0018h�|�w�?��wB\u000b���\u001bd;��0�r��\t�c3�E�b\bU~oF*�\u0018�>SG`���Q�^�/����\u000e�ǧ��*�\u0019�9��v\\��\u001c>�U��;e\u0013;��ȯwr$سT3K7a\u0017\u0007�ޱ}=��\u000e�#̐��6\u0004���\n\u000fd���<p�\u0000Д��g��I(NM�Y�W'�+���y���|�W�jH}�J������A�w\\�2���Z|�?�\u0006��\u0019^��kG#N~\u0006[\u001d6�E�kS.Q�ߗ;r���䩿Y",
  "flow": "setLxData->createCKey->getEncryptedCKey->cipherWithHashKey",
  "setLxData": "ok"
}
```