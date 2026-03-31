use crate::backend::RegisterARM64;
use crate::emulator::memory::MemoryBlockTrait;
use crate::emulator::{AndroidEmulator, VMPointer, POST_CALLBACK_SYSCALL_NUMBER};
use crate::keystone;
use crate::linux::errno::Errno;
use crate::linux::structs::DlInfo;
use crate::linux::PAGE_ALIGN;
use crate::memory::library_file::{ElfLibraryFile, LibraryFile};
use crate::memory::svc_memory::SvcCallResult::{FUCK, RET, VOID};
use crate::memory::svc_memory::{assemble_svc, Arm64Svc, HookListener, SvcCallResult, SvcMemory};
use anyhow::{anyhow, Error};
use bytes::{Buf, BufMut, BytesMut};
use log::{debug, error, info, warn};
use std::cell::RefCell;
use std::collections::HashMap;
use std::mem;
use std::rc::Rc;

struct DlIteratePhdr;
struct DlClose<'a, T: Clone>(pub VMPointer<'a, T>);
struct DlError<'a, T: Clone>(pub VMPointer<'a, T>);
struct DlOpen<'a, T: Clone>(pub VMPointer<'a, T>);
struct AndroidDlOpenExt<'a, T: Clone>(pub VMPointer<'a, T>);
struct AndroidSetApplicationTargetSdkVersion(Rc<RefCell<i32>>);
struct AndroidGetApplicationTargetSdkVersion(Rc<RefCell<i32>>);
struct DlAddr;
struct DlSym;
struct DlUnwindFindExidx;
struct CfiSlowPath;
struct CfiSlowPathDiag;
struct LoaderSharedGlobals(Rc<RefCell<Option<u64>>>);
struct LoaderRetZero(&'static str);
struct LoaderVoid(&'static str);

pub struct ArmLD64<'a, T: Clone> {
    error: VMPointer<'a, T>,
    target_sdk: Rc<RefCell<i32>>,
    shared_globals: Rc<RefCell<Option<u64>>>,
}

impl<T: Clone> ArmLD64<'_, T> {
    pub fn new<'a>(svc_memory: &mut SvcMemory<'a, T>) -> anyhow::Result<ArmLD64<'a, T>> {
        let pointer = svc_memory.allocate(0x80, "Dlfcn.error");
        let target_sdk = std::env::var("ANDROID_APP_TARGET_SDK")
            .ok()
            .and_then(|value| value.parse::<i32>().ok())
            .unwrap_or(23);
        Ok(ArmLD64 {
            error: pointer,
            target_sdk: Rc::new(RefCell::new(target_sdk)),
            shared_globals: Rc::new(RefCell::new(None)),
        })
    }
}

impl<'a, T: Clone> HookListener<'a, T> for ArmLD64<'a, T> {
    fn hook(
        &self,
        emu: &AndroidEmulator<'a, T>,
        lib_name: String,
        symbol_name: String,
        old: u64,
    ) -> u64 {
        if lib_name != "libdl.so" && lib_name != "ld-android.so" {
            return 0;
        }
        info!("[{}] link {}, old=0x{:X}", lib_name, symbol_name, old);
        let svc = &mut emu.inner_mut().svc_memory;
        match symbol_name.as_str() {
            "dl_iterate_phdr" => svc.register_svc(Box::new(DlIteratePhdr)),
            "dlerror" => svc.register_svc(Box::new(DlError(self.error.clone()))),
            "dlclose" => svc.register_svc(Box::new(DlClose(self.error.clone()))),
            "dlopen" => svc.register_svc(Box::new(DlOpen(self.error.clone()))),
            "android_dlopen_ext" => {
                svc.register_svc(Box::new(AndroidDlOpenExt(self.error.clone())))
            }
            "android_set_application_target_sdk_version" => svc.register_svc(Box::new(
                AndroidSetApplicationTargetSdkVersion(self.target_sdk.clone()),
            )),
            "android_get_application_target_sdk_version" => svc.register_svc(Box::new(
                AndroidGetApplicationTargetSdkVersion(self.target_sdk.clone()),
            )),
            "dladdr" => svc.register_svc(Box::new(DlAddr)),
            "dlsym" => svc.register_svc(Box::new(DlSym)),
            "dl_unwind_find_exidx" => svc.register_svc(Box::new(DlUnwindFindExidx)),
            "__cfi_slowpath" => svc.register_svc(Box::new(CfiSlowPath)),
            "__cfi_slowpath_diag" => svc.register_svc(Box::new(CfiSlowPathDiag)),
            "__loader_dl_iterate_phdr" => svc.register_svc(Box::new(DlIteratePhdr)),
            "__loader_dlerror" => svc.register_svc(Box::new(DlError(self.error.clone()))),
            "__loader_dlclose" => svc.register_svc(Box::new(DlClose(self.error.clone()))),
            "__loader_dlopen" => svc.register_svc(Box::new(DlOpen(self.error.clone()))),
            "__loader_android_dlopen_ext" => {
                svc.register_svc(Box::new(AndroidDlOpenExt(self.error.clone())))
            }
            "__loader_android_set_application_target_sdk_version" => svc.register_svc(Box::new(
                AndroidSetApplicationTargetSdkVersion(self.target_sdk.clone()),
            )),
            "__loader_android_get_application_target_sdk_version" => svc.register_svc(Box::new(
                AndroidGetApplicationTargetSdkVersion(self.target_sdk.clone()),
            )),
            "__loader_dladdr" => svc.register_svc(Box::new(DlAddr)),
            "__loader_dlsym" => svc.register_svc(Box::new(DlSym)),
            "__loader_shared_globals" => {
                svc.register_svc(Box::new(LoaderSharedGlobals(self.shared_globals.clone())))
            }
            "__loader_cfi_fail" => svc.register_svc(Box::new(LoaderVoid("__loader_cfi_fail"))),
            "__loader_android_dlwarning" => {
                svc.register_svc(Box::new(LoaderRetZero("__loader_android_dlwarning")))
            }
            "__loader_android_get_LD_LIBRARY_PATH" => svc.register_svc(Box::new(LoaderRetZero(
                "__loader_android_get_LD_LIBRARY_PATH",
            ))),
            "__loader_android_update_LD_LIBRARY_PATH" => svc.register_svc(Box::new(LoaderVoid(
                "__loader_android_update_LD_LIBRARY_PATH",
            ))),
            "__loader_android_create_namespace"
            | "__loader_android_get_exported_namespace"
            | "__loader_android_init_anonymous_namespace"
            | "__loader_android_link_namespaces"
            | "__loader_android_link_namespaces_all_libs"
            | "__loader_android_handle_signal"
            | "__loader_add_thread_local_dtor"
            | "__loader_remove_thread_local_dtor"
            | "__loader_dlvsym" => {
                svc.register_svc(Box::new(LoaderRetZero(Box::leak(
                    symbol_name.into_boxed_str(),
                ))))
            }
            _ => panic!("[libdl] symbol not found: {}", symbol_name),
        }
    }
}

impl<T: Clone> Arm64Svc<T> for CfiSlowPath {
    fn name(&self) -> &str {
        "__cfi_slowpath"
    }

    fn handle(&self, _emu: &AndroidEmulator<T>) -> SvcCallResult {
        VOID
    }
}

impl<T: Clone> Arm64Svc<T> for CfiSlowPathDiag {
    fn name(&self) -> &str {
        "__cfi_slowpath_diag"
    }

    fn handle(&self, _emu: &AndroidEmulator<T>) -> SvcCallResult {
        VOID
    }
}

impl<T: Clone> Arm64Svc<T> for LoaderSharedGlobals {
    fn name(&self) -> &str {
        "__loader_shared_globals"
    }

    fn handle(&self, emu: &AndroidEmulator<T>) -> SvcCallResult {
        let existing = { *self.0.borrow() };
        let addr = if let Some(addr) = existing {
            addr
        } else {
            let block = match emu.falloc(PAGE_ALIGN, false) {
                Ok(block) => block,
                Err(err) => return FUCK(err),
            };
            // Minimal bionic shared globals backing:
            // - inline fd table lives at base + 0x8 with 128 x u64 slots
            // - overflow table atomic lives at base + 0x408
            // - count/adjust field observed at base + 0x410
            // Zero-initialized pages give us a clean fd owner table.
            let addr = block.addr;
            info!("allocated __loader_shared_globals at 0x{:X}", addr);
            *self.0.borrow_mut() = Some(addr);
            addr
        };
        RET(addr as i64)
    }
}

impl<T: Clone> Arm64Svc<T> for LoaderRetZero {
    fn name(&self) -> &str {
        self.0
    }

    fn handle(&self, _emu: &AndroidEmulator<T>) -> SvcCallResult {
        RET(0)
    }
}

impl<T: Clone> Arm64Svc<T> for LoaderVoid {
    fn name(&self) -> &str {
        self.0
    }

    fn handle(&self, _emu: &AndroidEmulator<T>) -> SvcCallResult {
        VOID
    }
}

impl<T: Clone> Arm64Svc<T> for DlIteratePhdr {
    fn name(&self) -> &str {
        "DlIteratePhdr"
    }

    fn on_register(&self, svc: &mut SvcMemory<T>, number: u32) -> u64 {
        let code = [
            "sub sp, sp, #0x10",
            "stp x29, x30, [sp]",
            &format!("svc #0x{:x}", number),
            "ldr x13, [sp]",    // x13 == callback 0xc
            "add sp, sp, #0x8", // pop callback
            "cmp x13, #0",      // if callback == 0
            "b.eq #0x58",       // 0x58
            "ldr x0, [sp]",     // x0 == ptr
            "add sp, sp, #0x8", // pop ptr
            "ldr x1, [sp]",     // x1 == size
            "add sp, sp, #0x8", // pop size
            "ldr x2, [sp]",     // x2 == data
            "add sp, sp, #0x8", // pop data
            "blr x13",          // callback(ptr, size, data)
            // int (*callback)(struct dl_phdr_info *info,
            //        size_t size, void *data)
            "cmp x0, #0",    // if callback return 0
            "b.eq #0xc",     // loop
            "ldr x13, [sp]", // 0x40
            "add sp, sp, #0x8",
            "cmp x13, #0",
            "b.eq #0x58", // 0x58
            "add sp, sp, #0x18",
            "b 0x40",
            "mov x8, #0", // 0x58
            &format!("mov x12, #0x{:x}", number),
            &format!("mov x16, #0x{:x}", POST_CALLBACK_SYSCALL_NUMBER),
            "svc #0",
            "ldp x29, x30, [sp]",
            "add sp, sp, #0x10",
            "ret",
        ];
        let code = code.join("\n");
        let code = keystone::assemble_no_check(&code);
        let pointer = svc.allocate(code.len(), "DlIteratePhdr");
        pointer.write_buf(code).expect("try register svc");
        info!("DlIteratePhdr: pointer={:X}", pointer.addr);
        pointer.addr
    }

    fn handle(&self, emu: &AndroidEmulator<T>) -> SvcCallResult {
        let cb = emu.backend.reg_read(RegisterARM64::X0).unwrap();
        let data = emu.backend.reg_read(RegisterARM64::X1).unwrap();

        let mut modules = emu
            .inner_mut()
            .memory
            .modules
            .iter()
            .filter(|(name, module)| unsafe { (&*module.get()).elf_file.is_some() })
            .collect::<Vec<_>>()
            .into_iter()
            .map(|(a, b)| b.clone())
            .rev()
            .collect::<Vec<_>>();

        let mut modules = modules
            .iter()
            .map(|module_cell| {
                let module = unsafe { &mut *module_cell.get() };
                let elf_file = unsafe { &*module.elf_file.as_ref().unwrap().get() };
                (
                    module.path(emu),
                    module.virtual_base,
                    elf_file.ph_offset,
                    elf_file.num_ph,
                )
            })
            .collect::<Vec<_>>();

        modules.push(("/apex/com.android.art/lib64/libart.so".to_string(), 0, 0, 0));

        let size = 64;
        let modules_len = modules.len();

        let Ok(mut ptr) = emu.falloc(size * modules_len, true) else {
            return FUCK(anyhow!("unable to alloc memory for DlIteratePhdr"));
        };
        let sp = match emu
            .backend
            .reg_read(RegisterARM64::SP)
            .map_err(|e| anyhow!("failed to read SP: {:?}", e))
        {
            Ok(sp) => sp,
            Err(e) => return FUCK(e),
        };

        if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
            debug!(
                "DlIteratePhdr cb={:X}, data={:X}, size={}, sp={:X}",
                cb, data, modules_len, sp
            );
        }

        let sp = VMPointer::new(sp, 0, emu.backend.clone());
        let mut sp = sp.share(-8);
        sp.write_u64(0).unwrap(); // NULL-terminated

        for (name, vaddr, phdr, phnum) in modules {
            info!(
                "DlIteratePhdr: name={}, vaddr={:X}, phdr={:X}, phnum={}",
                name, vaddr, phdr, phnum
            );

            let dlpi_name = match emu.falloc(name.len() + 1, true) {
                Ok(p) => p,
                Err(e) => return FUCK(e),
            };
            dlpi_name.write_c_string(name.as_str()).unwrap();
            ptr.write_u64_with_offset(0, vaddr).unwrap();
            ptr.write_u64_with_offset(8, dlpi_name.addr).unwrap();
            ptr.write_u64_with_offset(16, phdr as u64).unwrap();
            ptr.write_u16_with_offset(24, phnum as u16).unwrap();

            sp = sp.share(-8);
            sp.write_u64(data).unwrap();

            sp = sp.share(-8);
            sp.write_u64(size as u64).unwrap();

            sp = sp.share(-8);
            sp.write_u64(ptr.addr).unwrap();

            sp = sp.share(-8);
            sp.write_u64(cb).unwrap();

            ptr = ptr.share(size as i64);
        }

        emu.backend
            .reg_write(RegisterARM64::SP, sp.addr)
            .map_err(|e| anyhow!("failed to write SP: {:?}", e))
            .unwrap();

        VOID
    }

    fn on_post_callback(&self, emu: &AndroidEmulator<T>) -> u64 {
        0
    }
}

impl<T: Clone> Arm64Svc<T> for DlError<'_, T> {
    fn name(&self) -> &str {
        "DlError"
    }

    fn handle(&self, emu: &AndroidEmulator<T>) -> SvcCallResult {
        panic!("dlerror not supported");
    }
}

impl<T: Clone> Arm64Svc<T> for DlClose<'_, T> {
    fn name(&self) -> &str {
        "DlClose"
    }

    fn handle(&self, emu: &AndroidEmulator<T>) -> SvcCallResult {
        panic!("dlclose not supported")
    }
}

impl<T: Clone> Arm64Svc<T> for DlOpen<'_, T> {
    fn name(&self) -> &str {
        "DlOpen"
    }

    fn on_register(&self, svc: &mut SvcMemory<T>, number: u32) -> u64 {
        let mut buf = BytesMut::new();
        buf.put_u32_le(0xd10043ff); // "sub sp, sp, #0x10"
        buf.put_u32_le(0xa9007bfd); // "stp x29, x30, [sp]"
        buf.put_u32_le(assemble_svc(number)); // "svc #0x" + Integer.toHexString(svcNumber)
        buf.put_u32_le(0xf94003ed); // "ldr x13, [sp]"
        buf.put_u32_le(0x910023ff); // "add sp, sp, #0x8", manipulated stack in dlopen
        buf.put_u32_le(0xf10001bf); // "cmp x13, #0"
        buf.put_u32_le(0x54000060); // "b.eq #0x24"
        buf.put_u32_le(0x10ffff9e); // "adr lr, #-0xf", jump to ldr x13, [sp]
        buf.put_u32_le(0xd61f01a0); // "br x13", call init array // "b.eq #0x24" to here
        buf.put_u32_le(0xf94003e0); // "ldr x0, [sp]", with return address
        buf.put_u32_le(0x910023ff); // "add sp, sp, #0x8"
        buf.put_u32_le(0xa9407bfd); // "ldp x29, x30, [sp]"
        buf.put_u32_le(0x910043ff); // "add sp, sp, #0x10"
        buf.put_u32_le(0xd65f03c0); // "ret"
        let pointer = svc.allocate(buf.len(), "dlopen");
        pointer
            .write_bytes(buf.freeze())
            .expect("try register svc failed");
        pointer.addr
    }

    fn handle(&self, emu: &AndroidEmulator<T>) -> SvcCallResult {
        let file_name_ptr = VMPointer::new(
            emu.backend.reg_read(RegisterARM64::X0).unwrap(),
            0,
            emu.backend.clone(),
        );

        let flags = emu.backend.reg_read(RegisterARM64::X1).unwrap();
        let file_name = file_name_ptr.read_string().unwrap();
        let trace_dlsym = std::env::var_os("RNIDBG_TRACE_DLSYM").is_some();

        let pointer = VMPointer::new(
            emu.backend.reg_read(RegisterARM64::SP).unwrap(),
            0,
            emu.backend.clone(),
        );
        let pointer = pointer.share_with_size(-8, 0); // ret

        if !file_name.is_ascii() {
            if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
                debug!(
                    "syscall dlopen(file_name=hex::decode({}), flags=0x{:X}) => 0",
                    hex::encode(file_name.as_bytes()),
                    flags
                );
            }

            pointer.write_u64(0).unwrap(); // dlopen函数调用返回值
            let pointer = pointer.share_with_size(-8, 0);
            pointer.write_u64(0).unwrap();
            emu.set_errno(Errno::ENOENT.as_i32()).unwrap();
            emu.backend
                .reg_write(RegisterARM64::SP, pointer.addr)
                .unwrap();

            return RET(0);
        } else {
            if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
                debug!(
                    "syscall dlopen(file_name={}, flags=0x{:X})",
                    file_name, flags
                );
            }
            if trace_dlsym {
                warn!("dlopen request file_name={} flags=0x{:X}", file_name, flags);
            }
        }

        if file_name == "libnetd_client.so" {
            pointer.write_u64(0).unwrap();
            let pointer = pointer.share_with_size(-8, 0);
            pointer.write_u64(0).unwrap();
            emu.backend
                .reg_write(RegisterARM64::SP, pointer.addr)
                .unwrap();
            return RET(0);
        }

        if let Some(module_base) = try_dlopen_module(emu, &file_name) {
            info!("dlopen resolved {} => 0x{:X}", file_name, module_base);
            if trace_dlsym {
                warn!("dlopen resolved file_name={} => 0x{:X}", file_name, module_base);
            }
            pointer.write_u64(module_base).unwrap();
            let pointer = pointer.share_with_size(-8, 0);
            pointer.write_u64(0).unwrap();
            emu.backend
                .reg_write(RegisterARM64::SP, pointer.addr)
                .unwrap();
            return RET(module_base as i64);
        }

        warn!("dlopen unresolved file_name={} flags=0x{:X}", file_name, flags);
        pointer.write_u64(0).unwrap();
        let pointer = pointer.share_with_size(-8, 0);
        pointer.write_u64(0).unwrap();
        emu.set_errno(Errno::ENOENT.as_i32()).unwrap();
        emu.backend
            .reg_write(RegisterARM64::SP, pointer.addr)
            .unwrap();
        RET(0)
    }
}

impl<T: Clone> Arm64Svc<T> for AndroidDlOpenExt<'_, T> {
    fn name(&self) -> &str {
        "AndroidDlOpenExt"
    }

    fn on_register(&self, svc: &mut SvcMemory<T>, number: u32) -> u64 {
        DlOpen(self.0.clone()).on_register(svc, number)
    }

    fn handle(&self, emu: &AndroidEmulator<T>) -> SvcCallResult {
        let file_name_ptr = VMPointer::new(
            emu.backend.reg_read(RegisterARM64::X0).unwrap(),
            0,
            emu.backend.clone(),
        );
        let flags = emu.backend.reg_read(RegisterARM64::X1).unwrap();
        let extinfo = emu.backend.reg_read(RegisterARM64::X2).unwrap();
        let file_name = file_name_ptr.read_string().unwrap_or_default();
        let trace_dlsym = std::env::var_os("RNIDBG_TRACE_DLSYM").is_some();
        info!(
            "android_dlopen_ext file_name={} flags=0x{:X} extinfo=0x{:X}",
            file_name, flags, extinfo
        );
        if trace_dlsym {
            warn!(
                "android_dlopen_ext request file_name={} flags=0x{:X} extinfo=0x{:X}",
                file_name, flags, extinfo
            );
        }
        DlOpen(self.0.clone()).handle(emu)
    }
}

impl<T: Clone> Arm64Svc<T> for AndroidSetApplicationTargetSdkVersion {
    fn name(&self) -> &str {
        "AndroidSetApplicationTargetSdkVersion"
    }

    fn handle(&self, emu: &AndroidEmulator<T>) -> SvcCallResult {
        let target_sdk = emu.backend.reg_read(RegisterARM64::X0).unwrap_or(0) as i32;
        *self.0.borrow_mut() = target_sdk;
        info!(
            "android_set_application_target_sdk_version target_sdk={}",
            target_sdk
        );
        RET(0)
    }
}

impl<T: Clone> Arm64Svc<T> for AndroidGetApplicationTargetSdkVersion {
    fn name(&self) -> &str {
        "AndroidGetApplicationTargetSdkVersion"
    }

    fn handle(&self, _emu: &AndroidEmulator<T>) -> SvcCallResult {
        let target_sdk = *self.0.borrow();
        info!(
            "android_get_application_target_sdk_version target_sdk={}",
            target_sdk
        );
        RET(target_sdk as i64)
    }
}

impl<T: Clone> Arm64Svc<T> for DlAddr {
    fn name(&self) -> &str {
        "DlAddr"
    }

    fn handle(&self, emu: &AndroidEmulator<T>) -> SvcCallResult {
        let addr = emu.backend.reg_read(RegisterARM64::X0).unwrap();
        let info_ptr = emu.backend.reg_read(RegisterARM64::X1).unwrap();

        let module = emu.inner_mut().memory.find_module_by_address(addr);
        if let Some(module) = module {
            let module = unsafe { &*module.get() };

            const INFO_SIZE: usize = size_of::<DlInfo>();
            let symbol = module.find_symbol_by_closest_addr(addr);
            return if let Ok(symbol) = symbol {
                let path = &module.path(emu);
                //let path = path.split('/').last().unwrap();
                let path_ptr = emu
                    .falloc(path.len() + 1 + symbol.name.len() + 1, true)
                    .unwrap();
                path_ptr.write_c_string(path).unwrap();
                let sname_ptr = path_ptr.share((path.len() + 1) as i64);
                sname_ptr.write_c_string(symbol.name.as_str()).unwrap();

                let mut buffer = [0u8; INFO_SIZE];
                let info = unsafe { &mut *(buffer.as_mut_ptr() as *mut DlInfo) };
                info.dli_fname = path_ptr.addr;
                info.dli_fbase = module.virtual_base;
                info.dli_sname = sname_ptr.addr;
                info.dli_saddr = symbol.address();

                emu.backend.mem_write(info_ptr, &buffer).unwrap();

                if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
                    debug!(
                        "syscall dladdr(addr=0x{:X}, info_ptr=0x{:X}) => Module(name={}, function)",
                        addr, info_ptr, module.name
                    );
                }

                RET(1)
            } else {
                let entry_point = module.entry_point;
                let path = module.path(emu);
                let path_ptr = emu.malloc(path.len() + 1 + 6, false).unwrap().pointer;
                path_ptr.write_c_string(path.as_str()).unwrap();
                let sname_ptr = path_ptr.share((path.len() + 1) as i64);
                sname_ptr.write_c_string("start").unwrap();

                let mut buffer = [0u8; INFO_SIZE];
                let info = unsafe { &mut *(buffer.as_mut_ptr() as *mut DlInfo) };
                info.dli_fname = path_ptr.addr;
                info.dli_fbase = module.virtual_base;
                info.dli_sname = sname_ptr.addr;
                info.dli_saddr = entry_point;
                emu.backend.mem_write(info_ptr, buffer.as_slice()).unwrap();

                if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
                    debug!("syscall dladdr(addr=0x{:X}, info_ptr=0x{:X}, path={}) => Module(name={}, unk)", addr, info_ptr, path, module.name);
                }

                RET(1)
            };
        } else {
            if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
                debug!(
                    "syscall dladdr(addr=0x{:X}, info_ptr=0x{:X}) => NotFound",
                    addr, info_ptr
                );
            }
        }
        RET(0)
    }
}

impl<T: Clone> Arm64Svc<T> for DlSym {
    fn name(&self) -> &str {
        "DlSym"
    }

    fn handle(&self, emu: &AndroidEmulator<T>) -> SvcCallResult {
        let handle = emu.backend.reg_read(RegisterARM64::X0).unwrap();
        let symbol_ptr = VMPointer::new(
            emu.backend.reg_read(RegisterARM64::X1).unwrap(),
            0,
            emu.backend.clone(),
        );
        let symbol_name = symbol_ptr.read_string().unwrap_or_default();
        let trace_dlsym = std::env::var_os("RNIDBG_TRACE_DLSYM").is_some();
        if symbol_name.is_empty() {
            warn!("dlsym requested empty symbol name handle=0x{:X}", handle);
            return RET(0);
        }
        if trace_dlsym {
            warn!(
                "dlsym request handle=0x{:X} symbol={}",
                handle, symbol_name
            );
        }

        if let Some(address) = try_dlsym(emu, handle, &symbol_name) {
            info!(
                "dlsym resolved handle=0x{:X} symbol={} => 0x{:X}",
                handle, symbol_name, address
            );
            if trace_dlsym {
                warn!(
                    "dlsym resolved handle=0x{:X} symbol={} => 0x{:X}",
                    handle, symbol_name, address
                );
            }
            return RET(address as i64);
        }

        warn!(
            "dlsym unresolved handle=0x{:X} symbol={}",
            handle, symbol_name
        );
        RET(0)
    }
}

impl<T: Clone> Arm64Svc<T> for DlUnwindFindExidx {
    fn name(&self) -> &str {
        "DlUnwindFindExidx"
    }

    fn handle(&self, emu: &AndroidEmulator<T>) -> SvcCallResult {
        panic!("DlUnwindFindExidx not supported")
    }
}

fn try_dlopen_module<T: Clone>(emu: &AndroidEmulator<T>, file_name: &str) -> Option<u64> {
    let base_name = file_name.rsplit('/').next().unwrap_or(file_name);
    if let Some(module) = emu.inner_mut().memory.modules.get(base_name) {
        return Some(unsafe { &*module.get() }.base);
    }

    if let Ok(library_file) = resolve_dlopen_library(file_name) {
        if let Ok(module) = emu
            .inner_mut()
            .memory
            .load_internal(library_file, true, emu)
        {
            return Some(unsafe { &*module.get() }.base);
        }
    }

    None
}

fn resolve_dlopen_library(file_name: &str) -> anyhow::Result<LibraryFile> {
    if file_name.starts_with('/') {
        let buffer = std::fs::read(file_name)?;
        return Ok(LibraryFile::Elf(ElfLibraryFile::new(
            buffer,
            file_name.to_string(),
        )));
    }
    Err(anyhow!("dlopen relative library resolution not available"))
}

fn try_dlsym<T: Clone>(emu: &AndroidEmulator<T>, handle: u64, symbol_name: &str) -> Option<u64> {
    if handle != 0 {
        if let Some(module_cell) = emu.inner_mut().memory.find_module_by_address(handle) {
            let module = unsafe { &*module_cell.get() };
            if let Ok(symbol) = module.find_symbol_by_name(symbol_name, true) {
                return Some(symbol.address());
            }
        }
    }

    for (_, module_cell) in &emu.inner_mut().memory.modules {
        let module = unsafe { &*module_cell.get() };
        if let Ok(symbol) = module.find_symbol_by_name(symbol_name, true) {
            return Some(symbol.address());
        }
    }

    None
}
