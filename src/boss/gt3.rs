use std::collections::HashMap;
use std::path::PathBuf;

use anyhow::{anyhow, Context, Result};
use rnidbg_boss_gt3::{
    boss_apk_gt3_call_chain, boss_apk_gt3_call_chain_markdown, run_pipeline_blocking,
    Gt3ImageSource, Gt3PipelineFetchConfig, Gt3PipelineRequest,
};
use serde_json::{json, Value};

pub fn run_gt3_call_chain(opts: &HashMap<String, String>) -> Result<Value> {
    let format = opts
        .get("--format")
        .map(|value| value.trim().to_ascii_lowercase())
        .unwrap_or_else(|| "json".to_string());
    let report = boss_apk_gt3_call_chain();
    let markdown = boss_apk_gt3_call_chain_markdown();
    let output = json!({
        "ok": true,
        "format": format,
        "call_chain": report,
        "markdown": markdown,
        "contract_alignment": {
            "apk_flow": "MachineVerifyActivity -> c4 -> p50.d -> GT3GeetestUtils -> onDialogResult -> captcha/validate",
            "web_flow_boundary": "Web image matching is analysis-only and does not replace APK-owned provider execution",
            "native_boundary": "libyzwg.so signs requests but is not the GT3 engine",
        }
    });
    write_optional_output(opts, "gt3_call_chain.json", &output)?;
    Ok(output)
}

pub fn run_gt3_pipeline(opts: &HashMap<String, String>) -> Result<Value> {
    let background =
        resolve_image_source(opts, "--background-url", "--background-image", "background")?;
    let slider = resolve_image_source(opts, "--slider-url", "--slider-image", "slider")?;
    let fetch = Gt3PipelineFetchConfig {
        user_agent: opts.get("--user-agent").cloned(),
        referer: opts.get("--referer").cloned(),
    };
    let request = Gt3PipelineRequest {
        background,
        slider,
        fetch,
        edge_low_threshold: opts
            .get("--edge-low")
            .map(|value| value.parse::<f32>())
            .transpose()
            .context("invalid --edge-low")?,
        edge_high_threshold: opts
            .get("--edge-high")
            .map(|value| value.parse::<f32>())
            .transpose()
            .context("invalid --edge-high")?,
        trajectory_seed: opts
            .get("--seed")
            .map(|value| value.parse::<u64>())
            .transpose()
            .context("invalid --seed")?,
    };
    let report = run_pipeline_blocking(request)?;
    let output = serde_json::to_value(report)?;
    write_optional_output(opts, "gt3_pipeline.json", &output)?;
    Ok(output)
}

fn resolve_image_source(
    opts: &HashMap<String, String>,
    url_key: &str,
    path_key: &str,
    label: &str,
) -> Result<Gt3ImageSource> {
    if let Some(url) = opts.get(url_key).filter(|value| !value.trim().is_empty()) {
        return Ok(Gt3ImageSource::Url(url.clone()));
    }
    if let Some(path) = opts.get(path_key).filter(|value| !value.trim().is_empty()) {
        return Ok(Gt3ImageSource::Path(PathBuf::from(path)));
    }
    Err(anyhow!(
        "missing {label} source, use {url_key} <url> or {path_key} <path>"
    ))
}

fn write_optional_output(
    opts: &HashMap<String, String>,
    default_name: &str,
    value: &Value,
) -> Result<()> {
    let path = opts
        .get("--out")
        .map(PathBuf::from)
        .unwrap_or_else(|| PathBuf::from(default_name));
    if !opts.contains_key("--out") {
        return Ok(());
    }
    if let Some(parent) = path.parent() {
        std::fs::create_dir_all(parent)
            .with_context(|| format!("failed to create output parent dir: {}", parent.display()))?;
    }
    std::fs::write(&path, serde_json::to_vec_pretty(value)?)
        .with_context(|| format!("failed to write output: {}", path.display()))?;
    Ok(())
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn resolve_image_source_prefers_url() {
        let opts = HashMap::from([
            (
                "--background-url".to_string(),
                "https://example.com/bg.png".to_string(),
            ),
            ("--background-image".to_string(), "/tmp/bg.png".to_string()),
        ]);
        let source = resolve_image_source(
            &opts,
            "--background-url",
            "--background-image",
            "background",
        )
        .expect("resolve source");
        match source {
            Gt3ImageSource::Url(url) => assert_eq!(url, "https://example.com/bg.png"),
            other => panic!("expected URL source, got {other:?}"),
        }
    }

    #[test]
    fn resolve_image_source_accepts_path() {
        let opts = HashMap::from([("--slider-image".to_string(), "/tmp/slider.png".to_string())]);
        let source = resolve_image_source(&opts, "--slider-url", "--slider-image", "slider")
            .expect("resolve source");
        match source {
            Gt3ImageSource::Path(path) => assert_eq!(path, PathBuf::from("/tmp/slider.png")),
            other => panic!("expected path source, got {other:?}"),
        }
    }
}
