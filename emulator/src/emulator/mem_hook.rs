use crate::backend::Backend;
use crate::emulator::AndroidEmulator;
use crate::pointer::VMPointer;
use log::{error, warn};
use std::process::exit;
#[cfg(feature = "unicorn_backend")]
use unicorn_engine::unicorn_const::{
    HookType, MemRegion, MemType, Permission as UnicornPermission,
};
#[cfg(feature = "unicorn_backend")]
use unicorn_engine::RegisterARM64::*;
#[cfg(feature = "unicorn_backend")]
use unicorn_engine::{RegisterARM64, Unicorn};

#[cfg(feature = "unicorn_backend")]
fn nearest_regions(regions: &[MemRegion], addr: u64) -> (Option<&MemRegion>, Option<&MemRegion>) {
    let mut prev = None;
    let mut next = None;
    for region in regions {
        if region.end < addr {
            if prev.is_none_or(|current: &MemRegion| current.end < region.end) {
                prev = Some(region);
            }
        } else if region.begin > addr {
            if next.is_none_or(|current: &MemRegion| current.begin > region.begin) {
                next = Some(region);
            }
        } else {
            return (Some(region), Some(region));
        }
    }
    (prev, next)
}

#[cfg(feature = "unicorn_backend")]
fn try_auto_map_fault_page<T: Clone>(
    hook_type: HookType,
    backend: &mut Unicorn<T>,
    addr: u64,
    size: usize,
) -> bool {
    const PAGE_SIZE: u64 = 0x1000;
    const HIGH_GUEST_ANON_BASE: u64 = 0x7000_0000_0000;

    if hook_type.contains(HookType::MEM_READ_UNMAPPED) && addr < PAGE_SIZE {
        match backend.mem_map(0, PAGE_SIZE as usize, UnicornPermission::READ | UnicornPermission::WRITE) {
            Ok(_) => {
                warn!(
                    "auto-mapped zero page for low READ_UNMAPPED addr=0x{:X} size={} LR=0x{:X}",
                    addr,
                    size,
                    backend.reg_read(RegisterARM64::LR).unwrap_or(0)
                );
                return true;
            }
            Err(err) => {
                warn!(
                    "failed to auto-map zero page addr=0x{:X} size={} err={:?}",
                    addr, size, err
                );
                return false;
            }
        }
    }

    if !hook_type.intersects(HookType::MEM_READ_UNMAPPED | HookType::MEM_WRITE_UNMAPPED)
        || addr < HIGH_GUEST_ANON_BASE
        || size > PAGE_SIZE as usize
    {
        return false;
    }

    let page = addr & !(PAGE_SIZE - 1);
    let Ok(regions) = backend.mem_regions() else {
        return false;
    };
    let (prev, next) = nearest_regions(&regions, page);
    let prev_gap = prev
        .map(|region| page.saturating_sub(region.end.saturating_add(1)));
    let next_gap = next
        .map(|region| region.begin.saturating_sub(page.saturating_add(PAGE_SIZE)));
    let adjacent = prev_gap.is_some_and(|gap| gap <= PAGE_SIZE)
        || next_gap.is_some_and(|gap| gap <= PAGE_SIZE);
    if !adjacent {
        return false;
    }

    match backend.mem_map(page, PAGE_SIZE as usize, UnicornPermission::READ | UnicornPermission::WRITE) {
        Ok(_) => {
            warn!(
                "auto-mapped anonymous fault page=0x{:X} for {:?} addr=0x{:X} size={} prev={:?} next={:?} LR=0x{:X}",
                page,
                hook_type,
                addr,
                size,
                prev.map(|r| (r.begin, r.end, r.perms.bits())),
                next.map(|r| (r.begin, r.end, r.perms.bits())),
                backend.reg_read(RegisterARM64::LR).unwrap_or(0)
            );
            true
        }
        Err(err) => {
            warn!(
                "failed to auto-map anonymous fault page=0x{:X} for {:?} addr=0x{:X} err={:?}",
                page, hook_type, addr, err
            );
            false
        }
    }
}

#[cfg(feature = "unicorn_backend")]
fn mem_hook_unmapped_unicorn<T: Clone>(
    hook_type: HookType,
    backend: &mut Unicorn<T>,
    mem_type: MemType,
    addr: u64,
    size: usize,
    value: i64,
) -> bool {
    if try_auto_map_fault_page(hook_type, backend, addr, size) {
        return true;
    }
    error!(
        "{:?}::{:?}  memory failed: address=0x{:X}, size={}, value=0x{:X}, LR=0x{:X}",
        hook_type,
        mem_type,
        addr,
        size,
        value,
        backend.reg_read(RegisterARM64::LR).unwrap()
    );
    backend.dump_context(addr, size);
    false
}

//noinspection DuplicatedCode
pub fn register_mem_err_handler<T: Clone>(backend: Backend<T>) {
    #[cfg(feature = "unicorn_backend")]
    if let Backend::Unicorn(unicorn) = backend {
        unicorn
            .add_mem_hook(
                HookType::MEM_READ_UNMAPPED,
                1,
                0,
                |backend: &mut Unicorn<'_, T>,
                 mem_type: MemType,
                 addr: u64,
                 size: usize,
                 value: i64| {
                    mem_hook_unmapped_unicorn(
                        HookType::MEM_READ_UNMAPPED,
                        backend,
                        mem_type,
                        addr,
                        size,
                        value,
                    )
                },
            )
            .expect("failed to add MEM_READ_UNMAPPED hook");
        unicorn
            .add_mem_hook(
                HookType::MEM_WRITE_UNMAPPED,
                1,
                0,
                |backend: &mut Unicorn<'_, T>,
                 mem_type: MemType,
                 addr: u64,
                 size: usize,
                 value: i64| {
                    mem_hook_unmapped_unicorn(
                        HookType::MEM_WRITE_UNMAPPED,
                        backend,
                        mem_type,
                        addr,
                        size,
                        value,
                    )
                },
            )
            .expect("failed to add MEM_WRITE_UNMAPPED hook");
        unicorn
            .add_mem_hook(
                HookType::MEM_FETCH_UNMAPPED,
                1,
                0,
                |backend: &mut Unicorn<'_, T>,
                 mem_type: MemType,
                 addr: u64,
                 size: usize,
                 value: i64| {
                    mem_hook_unmapped_unicorn(
                        HookType::MEM_FETCH_UNMAPPED,
                        backend,
                        mem_type,
                        addr,
                        size,
                        value,
                    )
                },
            )
            .expect("failed to add MEM_FETCH_UNMAPPED hook");
        unicorn.add_mem_hook(HookType::MEM_INVALID, 1, 0, |backend: &mut Unicorn<'_, T>, mem_type: MemType, addr: u64, size: usize, value: i64| {
            error!("MEM_INVALID::{:?}  memory failed: address=0x{:X}, size={}, value=0x{:X}, LR=0x{:X}", mem_type, addr, size, value, backend.reg_read(RegisterARM64::LR).unwrap());
            backend.dump_context(addr, size);
            backend.emu_stop().unwrap();
            return false;
        }).expect("failed to add MEM_INVALID hook");
        return;
    }

    #[cfg(feature = "dynarmic_backend")]
    if let Backend::Dynarmic(dynarmic) = backend {
        return;
    }

    unreachable!("Not supported backend: register_mem_err_handler")
}
