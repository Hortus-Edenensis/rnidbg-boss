// https://android.googlesource.com/platform/bionic/+/0d787c1fa18c6a1f29ef9840e28a68cf077be1de/libc/bionic/system_properties.c

use std::mem::size_of;
use anyhow::anyhow;
use log::debug;
use crate::backend::RegisterARM64;
use crate::android::virtual_library::libc::SystemPropertyService;
use crate::emulator::AndroidEmulator;
use crate::linux::structs::PropInfo;
use crate::pointer::VMPointer;
use crate::memory::svc_memory::{Arm64Svc, SvcCallResult};
use crate::memory::svc_memory::SvcCallResult::{FUCK, RET};

const PROP_VALUE_LEN_SHIFT: u32 = 24;

pub(super) struct SystemPropertyGet(Option<SystemPropertyService>);
pub(super) struct SystemPropertyFind(Option<SystemPropertyService>);
pub(super) struct SystemPropertyRead;

impl SystemPropertyGet {
    pub fn new(
        service: Option<SystemPropertyService>
    ) -> Self {
        SystemPropertyGet(service)
    }
}

impl SystemPropertyFind {
    pub fn new(
        service: Option<SystemPropertyService>
    ) -> Self {
        SystemPropertyFind(service)
    }
}

impl SystemPropertyRead {
    pub fn new() -> Self {
        SystemPropertyRead
    }
}

fn lookup_property(service: Option<&SystemPropertyService>, name: &str) -> Option<String> {
    if matches!(name, "ro.kernel.qemu" | "libc.debug.malloc") {
        return Some(String::new());
    }
    if name == "debug.atrace.tags.enableflags" {
        return None;
    }
    service.and_then(|resolver| resolver(name))
}

fn copy_c_string_bytes(dest: &mut [u8], src: &[u8]) -> usize {
    if dest.is_empty() {
        return 0;
    }

    let len = src.len().min(dest.len().saturating_sub(1));
    dest[..len].copy_from_slice(&src[..len]);
    dest[len] = 0;
    len
}

fn write_property_value<T: Clone>(backend: &crate::backend::Backend<T>, addr: u64, value: &[u8]) -> anyhow::Result<usize> {
    let mut buf = vec![0u8; value.len() + 1];
    let len = copy_c_string_bytes(&mut buf, value);
    backend.mem_write(addr, &buf)?;
    Ok(len)
}

fn prop_info_from_name_value(name: &str, value: &str) -> PropInfo {
    let mut prop_info = PropInfo {
        name: [0; 32],
        serial: 0,
        value: [0; 92],
    };
    let value_len = copy_c_string_bytes(&mut prop_info.value, value.as_bytes());
    copy_c_string_bytes(&mut prop_info.name, name.as_bytes());
    prop_info.serial = (value_len as u32) << PROP_VALUE_LEN_SHIFT;
    prop_info
}

fn prop_info_to_bytes(prop_info: &PropInfo) -> &[u8] {
    unsafe {
        std::slice::from_raw_parts(
            (prop_info as *const PropInfo).cast::<u8>(),
            size_of::<PropInfo>(),
        )
    }
}

fn read_prop_info<T: Clone>(emu: &AndroidEmulator<T>, prop_info_addr: u64) -> anyhow::Result<PropInfo> {
    let pointer = VMPointer::new(prop_info_addr, size_of::<PropInfo>(), emu.backend.clone());
    let mut bytes = [0u8; size_of::<PropInfo>()];
    bytes.copy_from_slice(pointer.read_bytes()?.as_slice());
    let prop_info = unsafe { std::ptr::read_unaligned(bytes.as_ptr().cast::<PropInfo>()) };
    Ok(prop_info)
}

fn c_string_len(bytes: &[u8]) -> usize {
    bytes.iter().position(|&byte| byte == 0).unwrap_or(bytes.len())
}

impl<T: Clone> Arm64Svc<T> for SystemPropertyGet {
    fn name(&self) -> &str { "SystemPropertyGet" }

    fn handle(&self, emu: &AndroidEmulator<T>) -> SvcCallResult {
        let backend = &emu.backend;
        let Ok(name_pointer) = backend.reg_read(RegisterARM64::X0) else {
            return FUCK(anyhow!("unable to get name_pointer"))
        };
        let Ok(name) = backend.mem_read_c_string(name_pointer) else {
            return FUCK(anyhow!("unable to read name from name pointer: 0x{:X}", name_pointer))
        };
        let Ok(value) = backend.reg_read(RegisterARM64::X1) else {
            return FUCK(anyhow!("unable to get value when handle SystemPropGet"))
        };

        if option_env!("PRINT_SYSTEM_PROP_LOG") == Some("1") {
            debug!("__system_property_get({}, 0x{:X})", name, value);
        }

        let property = lookup_property(self.0.as_ref(), &name);
        let property_value = property.as_deref().unwrap_or("");

        match write_property_value(backend, value, property_value.as_bytes()) {
            Ok(len) => RET(len as i64),
            Err(e) => FUCK(anyhow!("unable to write_mem when handle SystemPropGet: {}", e)),
        }
    }
}

impl<T: Clone> Arm64Svc<T> for SystemPropertyFind {
    fn name(&self) -> &str { "SystemPropertyFind" }

    fn handle(&self, emu: &AndroidEmulator<T>) -> SvcCallResult {
        let backend = &emu.backend;
        let Ok(name_pointer) = backend.reg_read(RegisterARM64::X0) else {
            return FUCK(anyhow!("unable to get name_pointer"))
        };
        let Ok(name) = backend.mem_read_c_string(name_pointer) else {
            return FUCK(anyhow!("unable to read name from name pointer: 0x{:X}", name_pointer))
        };

        if option_env!("PRINT_SYSTEM_PROP_LOG") == Some("1") {
            debug!("__system_property_find({})", name);
        }

        match lookup_property(self.0.as_ref(), &name) {
            Some(env) => {
                let prop_info = prop_info_from_name_value(&name, &env);
                let Ok(pointer) = emu.falloc(size_of::<PropInfo>(), true) else {
                  return FUCK(anyhow!("unable to alloc memory for prop_info"))
                };
                if let Err(e) = pointer.write_data(prop_info_to_bytes(&prop_info)) {
                    return FUCK(anyhow!("unable to write prop_info: {}", e))
                }
                RET(pointer.addr as i64)
            }
            None =>  RET(0)
        }
    }
}

impl<T: Clone> Arm64Svc<T> for SystemPropertyRead {
    fn name(&self) -> &str { "SystemPropertyRead" }

    fn handle(&self, emu: &AndroidEmulator<T>) -> SvcCallResult {
        let backend = &emu.backend;
        let Ok(prop_info_addr) = backend.reg_read(RegisterARM64::X0) else {
            return FUCK(anyhow!("unable to get prop_info when handle SystemPropertyRead"))
        };
        let Ok(name_addr) = backend.reg_read(RegisterARM64::X1) else {
            return FUCK(anyhow!("unable to get name pointer when handle SystemPropertyRead"))
        };
        let Ok(value_addr) = backend.reg_read(RegisterARM64::X2) else {
            return FUCK(anyhow!("unable to get value pointer when handle SystemPropertyRead"))
        };

        if prop_info_addr == 0 {
            if name_addr != 0 {
                if let Err(e) = backend.mem_write(name_addr, b"\0") {
                    return FUCK(anyhow!("unable to clear property name: {}", e))
                }
            }
            if value_addr != 0 {
                if let Err(e) = backend.mem_write(value_addr, b"\0") {
                    return FUCK(anyhow!("unable to clear property value: {}", e))
                }
            }
            return RET(0);
        }

        let Ok(prop_info) = read_prop_info(emu, prop_info_addr) else {
            return FUCK(anyhow!("unable to read prop_info: 0x{:X}", prop_info_addr))
        };

        let name_len = c_string_len(&prop_info.name);
        let value_len = c_string_len(&prop_info.value);

        if name_addr != 0 {
            let mut name_buf = vec![0u8; name_len + 1];
            copy_c_string_bytes(&mut name_buf, &prop_info.name[..name_len]);
            if let Err(e) = backend.mem_write(name_addr, &name_buf) {
                return FUCK(anyhow!("unable to write property name: {}", e))
            }
        }
        if value_addr != 0 {
            let mut value_buf = vec![0u8; value_len + 1];
            copy_c_string_bytes(&mut value_buf, &prop_info.value[..value_len]);
            if let Err(e) = backend.mem_write(value_addr, &value_buf) {
                return FUCK(anyhow!("unable to write property value: {}", e))
            }
        }

        RET(value_len as i64)
    }
}

#[cfg(test)]
mod tests {
    use super::{c_string_len, copy_c_string_bytes, lookup_property, prop_info_from_name_value, PROP_VALUE_LEN_SHIFT};
    use std::rc::Rc;
    use crate::android::virtual_library::libc::SystemPropertyService;

    #[test]
    fn copy_c_string_bytes_appends_nul_and_returns_length() {
        let mut buf = [0xff; 6];
        let len = copy_c_string_bytes(&mut buf, b"test");

        assert_eq!(len, 4);
        assert_eq!(&buf, b"test\0\xff");
    }

    #[test]
    fn prop_info_from_name_value_truncates_and_tracks_value_length() {
        let long_name = "n".repeat(64);
        let long_value = "v".repeat(128);
        let prop_info = prop_info_from_name_value(&long_name, &long_value);
        let name_len = c_string_len(&prop_info.name);
        let value_len = c_string_len(&prop_info.value);

        assert_eq!(name_len, prop_info.name.len() - 1);
        assert_eq!(value_len, prop_info.value.len() - 1);
        assert!(prop_info.name.iter().any(|&byte| byte == 0));
        assert!(prop_info.value.iter().any(|&byte| byte == 0));
        assert_eq!(prop_info.serial >> PROP_VALUE_LEN_SHIFT, (prop_info.value.len() - 1) as u32);
    }

    #[test]
    fn lookup_property_treats_missing_service_as_missing_property() {
        assert_eq!(lookup_property(None, "ro.test.key"), None);
        assert_eq!(lookup_property(None, "ro.kernel.qemu"), Some(String::new()));
        assert_eq!(lookup_property(None, "debug.atrace.tags.enableflags"), None);

        let service: SystemPropertyService = Rc::new(Box::new(|name| {
            (name == "ro.test.key").then(|| "value".to_string())
        }));
        assert_eq!(lookup_property(Some(&service), "ro.test.key"), Some("value".to_string()));
    }
}
