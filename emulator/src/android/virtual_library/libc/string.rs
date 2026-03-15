use anyhow::anyhow;
use log::debug;
use crate::backend::RegisterARM64;
use crate::emulator::AndroidEmulator;
use crate::memory::svc_memory::{Arm64Svc, SvcCallResult};
use crate::memory::svc_memory::SvcCallResult::{FUCK, RET};

pub(super) struct StrCmp;
pub(super) struct StrNCmp;
pub(super) struct StrCaseCmp;
pub(super) struct StrNCasCmp;

fn read_c_string_bytes<T: Clone>(
    backend: &crate::backend::Backend<T>,
    address: u64,
    limit: Option<usize>,
) -> anyhow::Result<Vec<u8>> {
    let mut bytes = Vec::new();
    let mut buf = [0u8; 1];
    let mut offset = 0usize;

    loop {
        if limit.is_some_and(|max| offset >= max) {
            break;
        }
        backend.mem_read(address + offset as u64, &mut buf)?;
        if buf[0] == 0 {
            break;
        }
        bytes.push(buf[0]);
        offset += 1;
    }

    Ok(bytes)
}

fn ascii_lower(byte: u8) -> u8 {
    if byte.is_ascii_uppercase() {
        byte.to_ascii_lowercase()
    } else {
        byte
    }
}

fn compare_c_bytes(lhs: &[u8], rhs: &[u8], limit: Option<usize>, ignore_case: bool) -> i32 {
    let max_len = limit.unwrap_or_else(|| lhs.len().max(rhs.len()) + 1);
    for idx in 0..max_len {
        let lhs_byte = lhs.get(idx).copied().unwrap_or(0);
        let rhs_byte = rhs.get(idx).copied().unwrap_or(0);
        let lhs_cmp = if ignore_case { ascii_lower(lhs_byte) } else { lhs_byte };
        let rhs_cmp = if ignore_case { ascii_lower(rhs_byte) } else { rhs_byte };

        if lhs_cmp != rhs_cmp {
            return lhs_cmp as i32 - rhs_cmp as i32;
        }
        if lhs_byte == 0 {
            return 0;
        }
    }

    0
}

impl<T: Clone> Arm64Svc<T> for StrCmp {
    fn name(&self) -> &str { "strcmp" }

    fn handle(&self, emu: &AndroidEmulator<T>) -> SvcCallResult {
        let backend = &emu.backend;
        let Ok(ps1) = backend.reg_read(RegisterARM64::X0) else {
            return FUCK(anyhow!("unable to get s1 when strcmp"))
        };
        let Ok(s1) = read_c_string_bytes(backend, ps1, None) else {
            return FUCK(anyhow!("unable to fetch s1 when strcmp"))
        };
        let Ok(ps2) = backend.reg_read(RegisterARM64::X1) else {
            return FUCK(anyhow!("unable to get s2 when strcmp"))
        };
        let Ok(s2) = read_c_string_bytes(backend, ps2, None) else {
            return FUCK(anyhow!("unable to fetch s2 when strcmp"))
        };

        if option_env!("PRINT_STRING_LOG") == Some("1") {
            debug!(
                "strcmp({}, {})",
                String::from_utf8_lossy(&s1),
                String::from_utf8_lossy(&s2)
            );
        }

        let result = compare_c_bytes(&s1, &s2, None, false);

        RET(result as i64)
    }
}

impl<T: Clone> Arm64Svc<T> for StrNCmp {
    fn name(&self) -> &str { "strncmp" }

    fn handle(&self, emu: &AndroidEmulator<T>) -> SvcCallResult {
        let backend = &emu.backend;
        let Ok(ps1) = backend.reg_read(RegisterARM64::X0) else {
            return FUCK(anyhow!("unable to get s1 when strncmp"))
        };
        let n = backend.reg_read(RegisterARM64::X2).unwrap() as usize;
        let Ok(s1) = read_c_string_bytes(backend, ps1, Some(n)) else {
            return FUCK(anyhow!("unable to fetch s1 when strncmp"))
        };
        let Ok(ps2) = backend.reg_read(RegisterARM64::X1) else {
            return FUCK(anyhow!("unable to get s2 when strncmp"))
        };
        let Ok(s2) = read_c_string_bytes(backend, ps2, Some(n)) else {
            return FUCK(anyhow!("unable to fetch s2 when strncmp"))
        };
        let result = compare_c_bytes(&s1, &s2, Some(n), false);

        if option_env!("PRINT_STRING_LOG") == Some("1") {
            debug!(
                "strncmp({}, {}, {}) => {}",
                String::from_utf8_lossy(&s1),
                String::from_utf8_lossy(&s2),
                n,
                result
            );
        }

        RET(result as i64)
    }
}

impl<T: Clone> Arm64Svc<T> for StrCaseCmp {
    fn name(&self) -> &str { "strcasecmp" }

    fn handle(&self, emu: &AndroidEmulator<T>) -> SvcCallResult {
        let backend = &emu.backend;
        let Ok(ps1) = backend.reg_read(RegisterARM64::X0) else {
            return FUCK(anyhow!("unable to get s1 when strcasecmp"))
        };
        let Ok(s1) = read_c_string_bytes(backend, ps1, None) else {
            return FUCK(anyhow!("unable to fetch s1 when strcasecmp"))
        };
        let Ok(ps2) = backend.reg_read(RegisterARM64::X1) else {
            return FUCK(anyhow!("unable to get s2 when strcasecmp"))
        };
        let Ok(s2) = read_c_string_bytes(backend, ps2, None) else {
            return FUCK(anyhow!("unable to fetch s2 when strcasecmp"))
        };
        if option_env!("PRINT_STRING_LOG") == Some("1") {
            debug!(
                "strcasecmp({}, {})",
                String::from_utf8_lossy(&s1),
                String::from_utf8_lossy(&s2)
            );
        }

        let result = compare_c_bytes(&s1, &s2, None, true);

        RET(result as i64)
    }
}

impl<T: Clone> Arm64Svc<T> for StrNCasCmp {
    fn name(&self) -> &str { "strncasecmp" }

    fn handle(&self, emu: &AndroidEmulator<T>) -> SvcCallResult {
        let backend = &emu.backend;
        let Ok(ps1) = backend.reg_read(RegisterARM64::X0) else {
            return FUCK(anyhow!("unable to get s1 when strncasecmp"))
        };
        let n = backend.reg_read(RegisterARM64::X2).unwrap() as usize;
        let Ok(s1) = read_c_string_bytes(backend, ps1, Some(n)) else {
            return FUCK(anyhow!("unable to fetch s1 when strncasecmp"))
        };
        let Ok(ps2) = backend.reg_read(RegisterARM64::X1) else {
            return FUCK(anyhow!("unable to get s2 when strncasecmp"))
        };
        let Ok(s2) = read_c_string_bytes(backend, ps2, Some(n)) else {
            return FUCK(anyhow!("unable to fetch s2 when strncasecmp"))
        };

        if option_env!("PRINT_STRING_LOG") == Some("1") {
            debug!(
                "strncasecmp({}, {}, {})",
                String::from_utf8_lossy(&s1),
                String::from_utf8_lossy(&s2),
                n
            );
        }

        let result = compare_c_bytes(&s1, &s2, Some(n), true);

        RET(result as i64)
    }
}

#[cfg(test)]
mod tests {
    use super::compare_c_bytes;

    #[test]
    fn strcmp_uses_unsigned_byte_ordering() {
        assert_eq!(compare_c_bytes(b"abc", b"abc", None, false), 0);
        assert!(compare_c_bytes(b"\xff", b"\x01", None, false) > 0);
        assert!(compare_c_bytes(b"abd", b"abc", None, false) > 0);
    }

    #[test]
    fn strncmp_stops_at_requested_length() {
        assert_eq!(compare_c_bytes(b"abcdef", b"abcxyz", Some(3), false), 0);
        assert!(compare_c_bytes(b"abcdef", b"abcxyz", Some(4), false) < 0);
    }

    #[test]
    fn strcasecmp_only_normalizes_ascii_letters() {
        assert_eq!(compare_c_bytes(b"AbC", b"aBc", None, true), 0);
        assert!(compare_c_bytes(b"\xc0", b"\xe0", None, true) < 0);
    }
}
