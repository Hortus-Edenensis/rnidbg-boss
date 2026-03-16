use std::collections::HashMap;
use std::fs;
use std::path::Path;

use anyhow::{anyhow, bail, Context, Result};
use image::imageops::{invert, resize, rotate180, rotate270, rotate90, FilterType};
use image::{DynamicImage, GrayImage};
use reqwest::Url;
use serde::Serialize;
use serde_json::{json, Value};

const RESULT_ACTIVITY_QR_SUCCESS: &str = "QrSuccessActivity";
const RESULT_ACTIVITY_NEW_DEVICE: &str = "NewDeviceAuthorizeActivity";

#[derive(Clone, Debug, Serialize, PartialEq, Eq)]
#[serde(rename_all = "snake_case")]
pub enum QrPayloadKind {
    WebLoginUrl,
    BosszpDirect,
}

#[derive(Clone, Debug, Serialize, PartialEq, Eq)]
pub struct RecognizedQrPayload {
    pub decoded_text: String,
    pub qr_id: String,
    pub payload_kind: QrPayloadKind,
    pub qr_mode_hint: String,
    pub result_activity_hint: String,
}

#[derive(Clone, Debug, Serialize, PartialEq, Eq)]
pub struct DecodedQrImage {
    pub image_path: String,
    pub image_width: u32,
    pub image_height: u32,
    pub decoder_backend: String,
    pub decoder_variant: String,
    #[serde(flatten)]
    pub recognized: RecognizedQrPayload,
    pub contract_alignment: Value,
}

pub fn run_qr_decode(opts: &HashMap<String, String>) -> Result<Value> {
    let image_path = opts
        .get("--image")
        .cloned()
        .or_else(|| opts.get("_0").cloned())
        .ok_or_else(|| anyhow!("missing required qr image path, use qr-decode <path>"))?;
    let decoded = decode_login_qr_image(Path::new(&image_path))?;
    let output = serde_json::to_value(&decoded)?;
    if let Some(out_path) = opts.get("--out") {
        fs::write(out_path, serde_json::to_vec_pretty(&output)?)
            .with_context(|| format!("failed to write qr decode output: {out_path}"))?;
    }
    Ok(output)
}

pub fn decode_login_qr_image(path: &Path) -> Result<DecodedQrImage> {
    let image = image::open(path)
        .with_context(|| format!("failed to open qr image: {}", path.display()))?;
    decode_login_qr_dynamic_image(path.display().to_string(), &image)
}

pub fn decode_login_qr_bytes(source_label: &str, bytes: &[u8]) -> Result<DecodedQrImage> {
    let image = image::load_from_memory(bytes)
        .with_context(|| format!("failed to decode qr image bytes for {source_label}"))?;
    decode_login_qr_dynamic_image(source_label.to_string(), &image)
}

pub fn manual_login_qr_payload(source_label: &str, scanned_text: &str) -> Result<DecodedQrImage> {
    let recognized = recognize_login_qr_text(scanned_text)?;
    Ok(DecodedQrImage {
        image_path: source_label.to_string(),
        image_width: 0,
        image_height: 0,
        decoder_backend: "manual".to_string(),
        decoder_variant: "manual-text".to_string(),
        recognized,
        contract_alignment: qr_contract_alignment(),
    })
}

fn decode_login_qr_dynamic_image(
    image_path: String,
    image: &DynamicImage,
) -> Result<DecodedQrImage> {
    let width = image.width();
    let height = image.height();

    for (variant, candidate) in decode_variants(&image) {
        if let Some(decoded_text) = decode_with_quircs(&candidate)? {
            let recognized = recognize_login_qr_text(&decoded_text)?;
            return Ok(DecodedQrImage {
                image_path: image_path.clone(),
                image_width: width,
                image_height: height,
                decoder_backend: "quircs".to_string(),
                decoder_variant: variant.to_string(),
                recognized,
                contract_alignment: qr_contract_alignment(),
            });
        }
    }

    bail!(
        "failed to decode QR image {} with quircs variants",
        image_path
    )
}

pub fn recognize_login_qr_text(scanned_text: &str) -> Result<RecognizedQrPayload> {
    let raw = scanned_text.trim();
    if raw.is_empty() {
        bail!("scan text is empty");
    }

    if raw.starts_with("http://") || raw.starts_with("https://") {
        let parsed = Url::parse(raw)?;
        for (key, value) in parsed.query_pairs() {
            if key == "qrcode" && !value.trim().is_empty() {
                let qr_id = value.to_string();
                return Ok(RecognizedQrPayload {
                    decoded_text: raw.to_string(),
                    qr_id,
                    payload_kind: QrPayloadKind::WebLoginUrl,
                    qr_mode_hint: "web".to_string(),
                    result_activity_hint: RESULT_ACTIVITY_QR_SUCCESS.to_string(),
                });
            }
        }
    } else if raw.starts_with("bosszp-") {
        return Ok(RecognizedQrPayload {
            decoded_text: raw.to_string(),
            qr_id: raw.to_string(),
            payload_kind: QrPayloadKind::BosszpDirect,
            qr_mode_hint: if raw.ends_with("changeDevice") {
                "change-device".to_string()
            } else {
                "web".to_string()
            },
            result_activity_hint: if raw.ends_with("changeDevice") {
                RESULT_ACTIVITY_NEW_DEVICE.to_string()
            } else {
                RESULT_ACTIVITY_QR_SUCCESS.to_string()
            },
        });
    }

    bail!(
        "scan text is not a supported login QR payload: {}",
        truncate(raw, 80)
    )
}

fn decode_variants(image: &DynamicImage) -> Vec<(&'static str, GrayImage)> {
    let base = image.to_luma8();
    let thresholded = threshold_image(&base, 180);
    let scaled2 = resize(
        &base,
        base.width() * 2,
        base.height() * 2,
        FilterType::Nearest,
    );
    let scaled4 = resize(
        &base,
        base.width() * 4,
        base.height() * 4,
        FilterType::Nearest,
    );
    let thresholded_scaled2 = threshold_image(&scaled2, 180);
    let thresholded_scaled4 = threshold_image(&scaled4, 180);

    let mut variants = Vec::with_capacity(20);
    variants.push(("luma", base.clone()));
    variants.push(("luma_rot90", rotate90(&base)));
    variants.push(("luma_rot180", rotate180(&base)));
    variants.push(("luma_rot270", rotate270(&base)));
    variants.push(("luma_threshold", thresholded.clone()));
    variants.push(("luma_threshold_rot90", rotate90(&thresholded)));
    variants.push(("luma_threshold_rot180", rotate180(&thresholded)));
    variants.push(("luma_threshold_rot270", rotate270(&thresholded)));
    variants.push(("luma_scaled2", scaled2.clone()));
    variants.push(("luma_scaled4", scaled4.clone()));
    variants.push(("luma_threshold_scaled2", thresholded_scaled2.clone()));
    variants.push(("luma_threshold_scaled4", thresholded_scaled4.clone()));

    let mut inverted = base.clone();
    invert(&mut inverted);
    variants.push(("luma_inverted", inverted.clone()));
    variants.push(("luma_inverted_rot90", rotate90(&inverted)));
    variants.push(("luma_inverted_rot180", rotate180(&inverted)));
    variants.push(("luma_inverted_rot270", rotate270(&inverted)));
    let mut inverted_thresholded = thresholded.clone();
    invert(&mut inverted_thresholded);
    variants.push(("luma_threshold_inverted", inverted_thresholded.clone()));
    variants.push((
        "luma_threshold_inverted_rot90",
        rotate90(&inverted_thresholded),
    ));
    variants.push((
        "luma_threshold_inverted_rot180",
        rotate180(&inverted_thresholded),
    ));
    variants.push((
        "luma_threshold_inverted_rot270",
        rotate270(&inverted_thresholded),
    ));
    variants
}

fn threshold_image(image: &GrayImage, threshold: u8) -> GrayImage {
    let mut out = image.clone();
    for pixel in out.pixels_mut() {
        pixel[0] = if pixel[0] >= threshold { 255 } else { 0 };
    }
    out
}

fn decode_with_quircs(image: &GrayImage) -> Result<Option<String>> {
    let width = usize::try_from(image.width()).context("qr image width overflow")?;
    let height = usize::try_from(image.height()).context("qr image height overflow")?;
    let mut decoder = quircs::Quirc::default();
    let codes = decoder.identify(width, height, image.as_raw());
    for code in codes {
        let code = code.map_err(|err| anyhow!("failed to identify qr code: {err}"))?;
        let decoded = code
            .decode()
            .map_err(|err| anyhow!("failed to decode qr payload: {err}"))?;
        let text =
            String::from_utf8(decoded.payload).context("decoded qr payload is not valid utf-8")?;
        if !text.trim().is_empty() {
            return Ok(Some(text));
        }
    }
    Ok(None)
}

fn qr_contract_alignment() -> Value {
    json!({
        "native_decoder_evidence": {
            "so": "libscanner.so",
            "jni": "com.hpbr.zp.scanner.zbar.ImageScanner",
            "native_symbols": [
                "_zbar_find_qr",
                "_zbar_qr_decode",
                "qr_code_data_list_extract_text"
            ],
            "java_fallback": "com.google.zxing.MultiFormatReader"
        },
        "business_helper_evidence": {
            "activity": "com.hpbr.bosszhipin.zxing.activity.ScanZxingActivity",
            "helper": "com.hpbr.bosszhipin.zxing.activity.a.k(...)",
            "accepted_shapes": [
                "https?://...?...qrcode=<qrId>",
                "bosszp-<qrId>"
            ]
        },
        "passport_contract": {
            "first_scan": "/api/zppassport/qrcode/webScanEdit",
            "second_scan": "/api/zppassport/qrcode/webSecondScan",
            "login_confirm": "/api/zppassport/qrcode/login"
        }
    })
}

fn truncate(value: &str, max_len: usize) -> String {
    if value.len() <= max_len {
        value.to_string()
    } else {
        value[..max_len].to_string()
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use image::{ImageBuffer, Luma};
    use qrcodegen::{QrCode, QrCodeEcc};

    #[test]
    fn recognize_login_qr_url_payload() {
        let recognized =
            recognize_login_qr_text("https://example.test/scan?qrcode=bosszp-123456").unwrap();
        assert_eq!(recognized.qr_id, "bosszp-123456");
        assert_eq!(recognized.payload_kind, QrPayloadKind::WebLoginUrl);
        assert_eq!(recognized.qr_mode_hint, "web");
    }

    #[test]
    fn recognize_change_device_payload() {
        let recognized = recognize_login_qr_text("bosszp-abcd-changeDevice").unwrap();
        assert_eq!(recognized.payload_kind, QrPayloadKind::BosszpDirect);
        assert_eq!(recognized.qr_mode_hint, "change-device");
        assert_eq!(recognized.result_activity_hint, RESULT_ACTIVITY_NEW_DEVICE);
    }

    #[test]
    fn decode_generated_qr_png_and_align_contract() {
        let payload = "bosszp-36a66919-0c95-4ffd-ad06-0fb23df8de12";
        let image = generate_qr_image(payload);
        let path = temp_png_path("decode_generated_qr_png_and_align_contract");
        image.save(&path).unwrap();

        let decoded = decode_login_qr_image(&path).unwrap();
        let _ = fs::remove_file(&path);

        assert_eq!(decoded.recognized.qr_id, payload);
        assert_eq!(decoded.recognized.payload_kind, QrPayloadKind::BosszpDirect);
        assert_eq!(decoded.decoder_backend, "quircs");
        assert_eq!(
            decoded.contract_alignment["passport_contract"]["login_confirm"],
            "/api/zppassport/qrcode/login"
        );
    }

    #[test]
    fn decode_rotated_qr_png() {
        let payload = "https://mock.local/scan?qrcode=mockqr-abcd-first";
        let image = DynamicImage::ImageLuma8(rotate90(&generate_qr_image(payload).to_luma8()));
        let path = temp_png_path("decode_rotated_qr_png");
        image.save(&path).unwrap();

        let decoded = decode_login_qr_image(&path).unwrap();
        let _ = fs::remove_file(&path);

        assert_eq!(decoded.recognized.qr_id, "mockqr-abcd-first");
        assert_eq!(decoded.recognized.payload_kind, QrPayloadKind::WebLoginUrl);
    }

    fn generate_qr_image(payload: &str) -> DynamicImage {
        let qr = QrCode::encode_text(payload, QrCodeEcc::Medium).unwrap();
        let border = 4;
        let scale = 8;
        let size = qr.size();
        let image_size = ((size + border * 2) * scale) as u32;
        let mut image = ImageBuffer::from_pixel(image_size, image_size, Luma([255u8]));
        for y in 0..size {
            for x in 0..size {
                if qr.get_module(x, y) {
                    let base_x = ((x + border) * scale) as u32;
                    let base_y = ((y + border) * scale) as u32;
                    for dy in 0..scale {
                        for dx in 0..scale {
                            image.put_pixel(base_x + dx as u32, base_y + dy as u32, Luma([0u8]));
                        }
                    }
                }
            }
        }
        DynamicImage::ImageLuma8(image)
    }

    fn temp_png_path(name: &str) -> std::path::PathBuf {
        std::env::temp_dir().join(format!("rnidbg-{}-{}.png", name, rand::random::<u64>()))
    }
}
