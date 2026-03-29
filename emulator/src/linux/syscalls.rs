use crate::backend::RegisterARM64;
use crate::backend::RegisterARM64::*;
use crate::backend::{Backend, Permission};
use crate::emulator::signal::{SignalOps, UnixSigSet};
use crate::emulator::thread::{
    AbstractTask, MarshmallowThread, RunnableTask, Task, TaskStatus, ThreadDispatcher, Waiter,
    WaiterTrait,
};
use crate::emulator::{AndroidEmulator, AndroidEmulatorInner, HEAP_BASE};
use crate::linux::errno::Errno;
use crate::linux::file_system::{FileIO, FileIOTrait, SeekResult, StMode};
use crate::linux::fs::cpuinfo::Cpuinfo;
use crate::linux::fs::direction::Direction;
use crate::linux::fs::linux_file::LinuxFileIO;
use crate::linux::fs::maps::Maps;
use crate::linux::fs::meminfo::Meminfo;
use crate::linux::fs::random_boot_id::RandomBootId;
use crate::linux::fs::urandom::URandom;
use crate::linux::fs::ByteArrayFileIO;
use crate::linux::pipe::Pipe;
use crate::linux::sock::inet_socket::InetSocket;
use crate::linux::sock::local_socket::LocalSocket;
use crate::linux::structs::prctl::PrctlOp;
use crate::linux::structs::socket::{Pf, SockType};
use crate::linux::structs::{prctl, CloneFlag, OFlag, Timespec, Timeval, Timezone};
use crate::linux::thread::{FutexIndefinitelyWaiter, FutexNanoSleepWaiter};
use crate::linux::PAGE_ALIGN;
use crate::pointer::VMPointer;
use crate::UnicornArg;
use bitflags::Flags;
use bytes::BytesMut;
use log::{error, info, warn};
use std::ascii::AsciiExt;
use std::cell::OnceCell;
use std::ffi::c_long;
use std::fmt::{format, Write as IGNORE};
use std::io::Write;
use std::mem;
use std::net::SocketAddr;
use std::os::fd::RawFd;
use std::path::Path;
use std::sync::atomic::{AtomicU32, Ordering};
use std::sync::OnceLock;
use std::time::{Instant, SystemTime, UNIX_EPOCH};

fn runtime_env_truthy(name: &str) -> bool {
    match std::env::var(name) {
        Ok(value) => matches!(
            value.trim().to_ascii_lowercase().as_str(),
            "1" | "true" | "yes" | "on"
        ),
        Err(_) => false,
    }
}

fn runtime_env_u32(name: &str) -> Option<u32> {
    std::env::var(name).ok()?.trim().parse::<u32>().ok()
}

fn runtime_env_csv_contains(name: &str, needle: &str) -> bool {
    std::env::var(name)
        .ok()
        .map(|value| {
            value
                .split([',', ';', ' '])
                .map(str::trim)
                .filter(|entry| !entry.is_empty())
                .any(|entry| entry == "*" || entry.eq_ignore_ascii_case(needle))
        })
        .unwrap_or(false)
}

const WRITEV_IOV_MAX: usize = 1024;
const MAX_WRITEV_IOV_LEN: usize = 16 * 1024 * 1024;
const MAX_WRITEV_TOTAL_LEN: usize = 32 * 1024 * 1024;

fn should_fake_funclib_worker(kind: &str) -> bool {
    if runtime_env_csv_contains("RNIDBG_FAKE_FUNCLIB_WORKER_KINDS", kind) {
        return true;
    }
    runtime_env_truthy("RNIDBG_FAKE_FUNCLIB_ASYNC_WORKER")
}

fn describe_guest_addr<T: Clone>(emulator: &AndroidEmulator<T>, addr: u64) -> String {
    if addr == 0 {
        return "0x0".to_string();
    }
    emulator
        .inner_mut()
        .memory
        .find_module_by_address(addr)
        .map(|module_cell| {
            let module = unsafe { &*module_cell.get() };
            format!("0x{:x} ({}@0x{:X})", addr, module.name, addr - module.base)
        })
        .unwrap_or_else(|| format!("0x{:x}", addr))
}

fn blackbox_p2p_async_callback<T: Clone>(
    emulator: &AndroidEmulator<T>,
    callback: u64,
    actual_arg: u64,
) -> Option<&'static str> {
    const HIDDEN_P2P_INLINE_CALLBACK_OFFSET: u64 = 0x4b0dfc;
    const HIDDEN_P2P_TASK_EMBED_OFFSET: u64 = 0xa0;
    const P2P_STATE_READY_OFFSET: u64 = 540;
    const P2P_STATE_RESULT_OFFSET: u64 = 548;
    const P2P_STATE_ERROR_OFFSET: u64 = 568;
    const P2P_BUF_A_PTR_OFFSET: u64 = 872;
    const P2P_BUF_A_COUNT_OFFSET: u64 = 880;
    const P2P_BUF_A_HEAD_OFFSET: u64 = 888;
    const P2P_BUF_A_TAIL_OFFSET: u64 = 896;
    const P2P_BUF_B_PTR_OFFSET: u64 = 920;
    const P2P_BUF_B_COUNT_OFFSET: u64 = 928;
    const P2P_BUF_A_ALLOC_SIZE: usize = 0xb808;
    const P2P_BUF_B_ALLOC_SIZE: usize = 0x1008;
    const P2P_BUF_COUNT: u64 = 256;

    let funclib_base = emulator
        .inner_mut()
        .memory
        .find_module_by_address(callback)
        .and_then(|module_cell| {
            let module = unsafe { &*module_cell.get() };
            (module.name == "libFunclib.so").then_some(module.base)
        })?;
    if callback != funclib_base + HIDDEN_P2P_INLINE_CALLBACK_OFFSET
        || actual_arg < HIDDEN_P2P_TASK_EMBED_OFFSET
    {
        return None;
    }

    let session_ptr = actual_arg - HIDDEN_P2P_TASK_EMBED_OFFSET;
    let backend = &emulator.backend;

    let _ = backend.mem_write(session_ptr + P2P_STATE_READY_OFFSET, &1u32.to_le_bytes());
    let _ = backend.mem_write(session_ptr + P2P_STATE_RESULT_OFFSET, &0u32.to_le_bytes());
    let _ = backend.mem_write(session_ptr + P2P_STATE_ERROR_OFFSET, &0u32.to_le_bytes());

    if backend
        .mem_read_u64(session_ptr + P2P_BUF_A_PTR_OFFSET)
        .unwrap_or(0)
        == 0
    {
        if let Ok(buf_a) = emulator.falloc(P2P_BUF_A_ALLOC_SIZE, false) {
            let buf_a_base = buf_a.addr;
            let buf_a_ptr = buf_a_base + 8;
            let _ = backend.mem_write(buf_a_base, &P2P_BUF_COUNT.to_le_bytes());
            let _ = backend.mem_write(session_ptr + P2P_BUF_A_PTR_OFFSET, &buf_a_ptr.to_le_bytes());
            let _ = backend.mem_write(
                session_ptr + P2P_BUF_A_COUNT_OFFSET,
                &(P2P_BUF_COUNT as u32).to_le_bytes(),
            );
            let _ = backend.mem_write(
                session_ptr + P2P_BUF_A_HEAD_OFFSET,
                &buf_a_ptr.to_le_bytes(),
            );
            let _ = backend.mem_write(
                session_ptr + P2P_BUF_A_TAIL_OFFSET,
                &buf_a_ptr.to_le_bytes(),
            );
            let _ = backend.mem_write(
                buf_a_ptr + 16,
                &(session_ptr + P2P_BUF_A_HEAD_OFFSET).to_le_bytes(),
            );
        }
    }

    if backend
        .mem_read_u64(session_ptr + P2P_BUF_B_PTR_OFFSET)
        .unwrap_or(0)
        == 0
    {
        if let Ok(buf_b) = emulator.falloc(P2P_BUF_B_ALLOC_SIZE, false) {
            let buf_b_base = buf_b.addr;
            let buf_b_ptr = buf_b_base + 8;
            let _ = backend.mem_write(buf_b_base, &P2P_BUF_COUNT.to_le_bytes());
            let _ = backend.mem_write(session_ptr + P2P_BUF_B_PTR_OFFSET, &buf_b_ptr.to_le_bytes());
            let _ = backend.mem_write(
                session_ptr + P2P_BUF_B_COUNT_OFFSET,
                &(P2P_BUF_COUNT as u32).to_le_bytes(),
            );
        }
    }

    Some("blackbox-hidden-p2p")
}

#[derive(Clone, Copy)]
struct EpollRegistration {
    fd: i32,
    events: u32,
    data: u64,
}

struct EpollInstance {
    path: String,
    entries: Vec<EpollRegistration>,
}

impl EpollInstance {
    fn new() -> Self {
        Self {
            path: "anon_inode:[eventpoll]".to_string(),
            entries: Vec::new(),
        }
    }
}

impl<T: Clone> FileIOTrait<T> for EpollInstance {
    fn close(&mut self) {}

    fn read(&mut self, _buf: VMPointer<T>, _count: usize) -> usize {
        0
    }

    fn pread(&mut self, _buf: VMPointer<T>, _count: usize, _offset: usize) -> usize {
        0
    }

    fn write(&mut self, buf: &[u8]) -> i32 {
        buf.len() as i32
    }

    fn lseek(&mut self, _offset: i64, _whence: i32) -> SeekResult {
        SeekResult::UnknownError
    }

    fn path(&self) -> &str {
        &self.path
    }

    fn oflags(&self) -> OFlag {
        OFlag::O_RDWR
    }

    fn st_mode(&self) -> StMode {
        StMode::S_IRUSR | StMode::S_IWUSR
    }

    fn uid(&self) -> i32 {
        0
    }

    fn len(&self) -> usize {
        0
    }

    fn to_vec(&mut self) -> Vec<u8> {
        Vec::new()
    }

    fn epoll_ctl(&mut self, op: i32, fd: i32, events: u32, data: u64) -> i32 {
        match op {
            1 => {
                if let Some(entry) = self.entries.iter_mut().find(|entry| entry.fd == fd) {
                    *entry = EpollRegistration { fd, events, data };
                } else {
                    self.entries.push(EpollRegistration { fd, events, data });
                }
                0
            }
            2 => {
                self.entries.retain(|entry| entry.fd != fd);
                0
            }
            3 => {
                if let Some(entry) = self.entries.iter_mut().find(|entry| entry.fd == fd) {
                    *entry = EpollRegistration { fd, events, data };
                    0
                } else {
                    -1
                }
            }
            _ => -1,
        }
    }

    fn epoll_entries(&self) -> Vec<(i32, u32, u64)> {
        self.entries
            .iter()
            .map(|entry| (entry.fd, entry.events, entry.data))
            .collect()
    }
}

fn write_socket_addr<T: Clone>(
    backend: &Backend<T>,
    addr: u64,
    addr_len_ptr: u64,
    socket_addr: SocketAddr,
) {
    let encoded = match socket_addr {
        SocketAddr::V4(v4) => {
            let mut buf = vec![0u8; 16];
            buf[0..2].copy_from_slice(&(Pf::INET as u16).to_le_bytes());
            buf[2..4].copy_from_slice(&v4.port().to_be_bytes());
            buf[4..8].copy_from_slice(&v4.ip().octets());
            buf
        }
        SocketAddr::V6(v6) => {
            let mut buf = vec![0u8; 28];
            buf[0..2].copy_from_slice(&(Pf::INET6 as u16).to_le_bytes());
            buf[2..4].copy_from_slice(&v6.port().to_be_bytes());
            buf[4..8].copy_from_slice(&v6.flowinfo().to_be_bytes());
            buf[8..24].copy_from_slice(&v6.ip().octets());
            buf[24..28].copy_from_slice(&v6.scope_id().to_le_bytes());
            buf
        }
    };

    let encoded_len = encoded.len() as u32;
    let write_len = if addr_len_ptr != 0 {
        backend
            .mem_read_v2::<u32>(addr_len_ptr)
            .unwrap_or(encoded_len)
    } else {
        encoded_len
    }
    .min(encoded_len) as usize;

    if addr != 0 && write_len > 0 {
        backend.mem_write(addr, &encoded[..write_len]).unwrap();
    }
    if addr_len_ptr != 0 {
        backend
            .mem_write(addr_len_ptr, &encoded_len.to_le_bytes())
            .unwrap();
    }
}

fn describe_sockaddr<T: Clone>(backend: &Backend<T>, addr: u64, addr_len: usize) -> String {
    if addr == 0 || addr_len < 8 {
        return format!("addr=0x{addr:x},len={addr_len}");
    }
    let Ok(data) = backend.mem_read_as_vec(addr, addr_len) else {
        return format!("addr=0x{addr:x},len={addr_len},unreadable");
    };
    if data.len() < 8 {
        return format!("addr=0x{addr:x},len={addr_len},short");
    }
    let family = u16::from_le_bytes([data[0], data[1]]);
    if family == Pf::INET as u16 {
        let port = u16::from_be_bytes([data[2], data[3]]);
        return format!("{}.{}.{}.{}:{}", data[4], data[5], data[6], data[7], port);
    }
    if family == Pf::LOCAL as u16 {
        let path_bytes = &data[2..];
        if let Some(first_nonzero) = path_bytes.iter().position(|byte| *byte != 0) {
            let trimmed = &path_bytes[first_nonzero..];
            let end = trimmed
                .iter()
                .position(|byte| *byte == 0)
                .unwrap_or(trimmed.len());
            return format!("local:{}", String::from_utf8_lossy(&trimmed[..end]));
        }
        return "local:<abstract-empty>".to_string();
    }
    if family == Pf::INET6 as u16 && data.len() >= 28 {
        let port = u16::from_be_bytes([data[2], data[3]]);
        let ip = std::net::Ipv6Addr::from([
            data[8], data[9], data[10], data[11], data[12], data[13], data[14], data[15], data[16],
            data[17], data[18], data[19], data[20], data[21], data[22], data[23],
        ]);
        return format!("[{ip}]:{port}");
    }
    format!("family={},addr=0x{addr:x},len={addr_len}", family)
}

fn hex_preview(data: &[u8], limit: usize) -> String {
    let mut preview = String::new();
    for byte in data.iter().take(limit) {
        let _ = write!(&mut preview, "{byte:02x}");
    }
    if data.len() > limit {
        preview.push_str("...");
    }
    preview
}

const EPOLLIN: u32 = 0x001;
const EPOLLOUT: u32 = 0x004;
const EPOLLERR: u32 = 0x008;
const EPOLLHUP: u32 = 0x010;

fn file_host_raw_fd<T: Clone>(file: &mut FileIO<T>) -> Option<RawFd> {
    match file {
        FileIO::Dynamic(dynamic) => dynamic.host_raw_fd(),
        _ => None,
    }
}

fn file_has_pending_read<T: Clone>(file: &mut FileIO<T>) -> bool {
    match file {
        FileIO::Dynamic(dynamic) => dynamic.has_pending_read(),
        FileIO::LocalSocket(socket) => socket.has_pending_read(),
        _ => false,
    }
}

fn file_is_immediately_writable<T: Clone>(file: &mut FileIO<T>) -> bool {
    matches!(file, FileIO::LocalSocket(_))
}

fn file_epoll_ctl<T: Clone>(file: &mut FileIO<T>, op: i32, fd: i32, events: u32, data: u64) -> i32 {
    match file {
        FileIO::Dynamic(dynamic) => dynamic.epoll_ctl(op, fd, events, data),
        _ => -1,
    }
}

fn file_epoll_entries<T: Clone>(file: &mut FileIO<T>) -> Vec<(i32, u32, u64)> {
    match file {
        FileIO::Dynamic(dynamic) => dynamic.epoll_entries(),
        _ => Vec::new(),
    }
}

fn epoll_to_poll_mask(events: u32) -> i16 {
    let mut mask: i16 = 0;
    if events & EPOLLIN != 0 {
        mask |= libc::POLLIN;
    }
    if events & EPOLLOUT != 0 {
        mask |= libc::POLLOUT;
    }
    if mask == 0 {
        mask = libc::POLLIN;
    }
    mask
}

fn poll_to_epoll_mask(revents: i16) -> u32 {
    let mut mask = 0u32;
    if revents & libc::POLLIN != 0 {
        mask |= EPOLLIN;
    }
    if revents & libc::POLLOUT != 0 {
        mask |= EPOLLOUT;
    }
    if revents & libc::POLLERR != 0 {
        mask |= EPOLLERR;
    }
    if revents & libc::POLLHUP != 0 {
        mask |= EPOLLHUP;
    }
    mask
}

fn write_epoll_event<T: Clone>(backend: &Backend<T>, addr: u64, events: u32, data: u64) {
    let mut buf = [0u8; 12];
    buf[0..4].copy_from_slice(&events.to_le_bytes());
    buf[4..12].copy_from_slice(&data.to_le_bytes());
    backend.mem_write(addr, &buf).unwrap();
}

fn fdset_len_bytes(nfds: i32) -> usize {
    if nfds <= 0 {
        return 0;
    }
    (((nfds as usize) + 63) / 64) * 8
}

fn read_fdset_bits<T: Clone>(backend: &Backend<T>, addr: u64, nfds: i32) -> Vec<bool> {
    let len = fdset_len_bytes(nfds);
    if addr == 0 || len == 0 {
        return vec![false; nfds.max(0) as usize];
    }
    let data = backend
        .mem_read_as_vec(addr, len)
        .unwrap_or_else(|_| vec![0u8; len]);
    let mut bits = vec![false; nfds.max(0) as usize];
    for fd in 0..(nfds.max(0) as usize) {
        let word_offset = (fd / 64) * 8;
        let word = u64::from_le_bytes(
            data[word_offset..word_offset + 8]
                .try_into()
                .unwrap_or([0u8; 8]),
        );
        bits[fd] = ((word >> (fd % 64)) & 1) != 0;
    }
    bits
}

fn write_fdset_bits<T: Clone>(backend: &Backend<T>, addr: u64, nfds: i32, bits: &[bool]) {
    let len = fdset_len_bytes(nfds);
    if addr == 0 || len == 0 {
        return;
    }
    let mut data = vec![0u8; len];
    for fd in 0..bits.len().min(nfds.max(0) as usize) {
        if !bits[fd] {
            continue;
        }
        let word_offset = (fd / 64) * 8;
        let mut word = u64::from_le_bytes(
            data[word_offset..word_offset + 8]
                .try_into()
                .unwrap_or([0u8; 8]),
        );
        word |= 1u64 << (fd % 64);
        data[word_offset..word_offset + 8].copy_from_slice(&word.to_le_bytes());
    }
    let _ = backend.mem_write(addr, data.as_slice());
}

macro_rules! throw_err {
    ($backend:ident, $emulator:ident, $errno:expr) => {
        let errno = <Errno as Into<i32>>::into($errno);
        $backend
            .reg_write_i64(RegisterARM64::X0, -(errno as i64))
            .unwrap();
        $emulator.set_errno(errno).expect("failed to set errno");
        return;
    };
}
macro_rules! ret_u64 {
    ($backend:ident, $X0:expr) => {
        $backend
            .reg_write(RegisterARM64::X0, $X0)
            .expect("failed to write x0")
    };
}

macro_rules! ret_i32 {
    ($backend:ident, $X0:expr) => {
        $backend
            .reg_write_i64(RegisterARM64::X0, ($X0 as i64))
            .expect("failed to write x0")
    };
}

macro_rules! ldr_i32 {
    ($backend:ident, $id:expr) => {
        $backend.reg_read($id).unwrap() as i32
    };
}

macro_rules! ldr_u32 {
    ($backend:ident, $id:expr) => {
        $backend.reg_read_u32($id).unwrap() as u32
    };
}

macro_rules! ldr_u64 {
    ($backend:ident, $id:expr) => {
        $backend.reg_read($id).unwrap()
    };
}

macro_rules! ldr_string {
    ($backend:ident, $id:expr) => {
        $backend.mem_read_c_string(ldr_u64!($backend, $id)).unwrap()
    };
}

pub fn syscall_brk<T: Clone>(backend: &Backend<T>, emulator: &AndroidEmulator<T>) {
    let addr = ldr_u64!(backend, X0);
    if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
        println!("syscall brk({})", addr);
    }

    if addr == 0 {
        emulator.inner_mut().brk = HEAP_BASE;
        ret_u64!(backend, HEAP_BASE);
        return;
    }

    if addr % 8 != 0 {
        throw_err!(backend, emulator, Errno::EINVAL.into());
    }

    let brk = emulator.inner_mut().brk;
    if addr > brk {
        backend
            .mem_map(
                brk,
                (addr - brk) as usize,
                (Permission::READ | Permission::WRITE).bits(),
            )
            .expect("failed to map memory: brk");
    } else if addr < brk {
        backend
            .mem_unmap(addr, (brk - addr) as usize)
            .expect("failed to unmap memory: brk");
    }
    emulator.inner_mut().brk = addr;

    ret_u64!(backend, addr);
}

pub fn syscall_prctl<T: Clone>(backend: &Backend<T>, emulator: &AndroidEmulator<T>) {
    let from = emulator.find_caller_name();
    let op = ldr_u32!(backend, X0);
    let arg2 = ldr_u64!(backend, X1);
    let arg3 = ldr_u64!(backend, X2);
    let arg4 = ldr_u64!(backend, X3);

    match PrctlOp::from_bits(op).unwrap_or(PrctlOp::UNKNOWN) {
        PrctlOp::PR_SET_NAME => {
            let _ = (arg2, arg3, arg4);
            ret_i32!(backend, 0);
        }
        PrctlOp::PR_GET_NAME => {
            if arg2 != 0 {
                let mut bytes = [0u8; 16];
                let name = b"rnidbg\0";
                bytes[..name.len()].copy_from_slice(name);
                let _ = backend.mem_write(arg2, &bytes);
            }
            let _ = (arg3, arg4);
            ret_i32!(backend, 0);
        }
        PrctlOp::BIONIC_PR_SET_VMA => {
            if from == "libc.so" {
                ret_i32!(backend, 0);
            } else {
                panic!(
                    "prctl not supported: {:?} from {}",
                    PrctlOp::BIONIC_PR_SET_VMA,
                    from
                );
            }
        }
        PrctlOp::UNKNOWN => {
            panic!("prctl not supported: 0x{:X}", op)
        }
        _ => {
            panic!("prctl not supported: {:?}", PrctlOp::from_bits(op))
        }
    };
}

pub fn syscall_ioctl<T: Clone>(backend: &Backend<T>, emulator: &AndroidEmulator<T>) {
    let fd = ldr_i32!(backend, X0);
    let request = ldr_u64!(backend, X1);
    let argp = ldr_u64!(backend, X2);

    info!(
        "stub ioctl(fd={}, request=0x{:x}, argp={})",
        fd,
        request,
        describe_guest_addr(emulator, argp)
    );
    ret_i32!(backend, 0);
}

pub fn syscall_gettimeofday<T: Clone>(backend: &Backend<T>, emulator: &AndroidEmulator<T>) {
    const TV_SIZE: usize = mem::size_of::<Timeval>();
    const TZ_SIZE: usize = mem::size_of::<Timezone>();

    let tv_pointer = emulator.backend.reg_read(X0).unwrap();
    if tv_pointer != 0 {
        let mut buffer = [0u8; TV_SIZE];
        let tv = unsafe { &mut *(buffer.as_mut_ptr() as *mut Timeval) };
        let now = chrono::Local::now();
        tv.tv_sec = now.timestamp();
        tv.tv_usec = now.timestamp_subsec_micros() as i64;
        backend.mem_write(tv_pointer, &buffer).unwrap();
    }

    let tz_pointer = emulator.backend.reg_read(X1).unwrap();
    if tz_pointer != 0 {
        let mut buffer = [0u8; TZ_SIZE];
        let tz = unsafe { &mut *(buffer.as_mut_ptr() as *mut Timezone) };
        tz.tz_dsttime = 0;
        tz.tz_minuteswest = -480;
        backend.mem_write(tz_pointer, &buffer).unwrap();
    }

    if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
        let lr = emulator.get_lr().unwrap_or(0);
        let from_module = emulator.find_caller_name();
        println!(
            "syscall gettimeofday(tv_pointer=0x{:x}, tz_pointer=0x{:x}, lr=0x{:x}, from={})",
            tv_pointer, tz_pointer, lr, from_module
        );
    }

    ret_i32!(backend, 0);
}

pub fn syscall_futex<T: Clone>(backend: &Backend<T>, emulator: &AndroidEmulator<T>) {
    let uaddr = ldr_u64!(backend, X0);
    let op = ldr_i32!(backend, X1);
    let val = ldr_u32!(backend, X2);
    let timeout = ldr_u64!(backend, X3);
    let uaddr2 = ldr_u64!(backend, X4);
    let val3 = ldr_i32!(backend, X5);

    if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
        let lr = emulator.get_lr().unwrap();
        let from_module = emulator.find_caller();
        let from_module = if let Some(from_module_cell) = from_module {
            let module = unsafe { &*from_module_cell.get() };
            module.name.clone() + format!("@0x{:X}", lr - module.base).as_str()
        } else {
            format!("@0x{:X}", lr)
        };
        let mut old = [0u8; 4];
        if backend.mem_read(uaddr, &mut old).is_err() {
            info!("syscall futex(uaddr=0x{:x}, op={}, val={}, timeout=0x{:x}, uaddr2=0x{:x}, val3={}) from {}", uaddr, op, val, timeout, uaddr2, val3, from_module);
        } else {
            let old = u32::from_le_bytes(old);
            info!("syscall futex(uaddr=0x{:x}, op={}, val={}, old={}, timeout=0x{:x}, uaddr2=0x{:x}, val3={}) from {}", uaddr, op, val, old, timeout, uaddr2, val3, from_module);
        }
    }

    let is_private = (op & 0x80) != 0;
    let cmd = op & 0x7f;
    if 0 == cmd {
        if runtime_env_truthy("RNIDBG_FAKE_CLONE_THREADS")
            && emulator.inner_mut().thread_dispatcher.task_counts() <= 1
        {
            if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
                println!("syscall futex wait fast-path => 0");
            }
            ret_i32!(backend, 0);
            return;
        }

        let mut old = [0u8; 4];
        if backend.mem_read(uaddr, &mut old).is_err() {
            throw_err!(backend, emulator, Errno::EAGAIN);
        }
        let old = u32::from_le_bytes(old);
        if old != val {
            throw_err!(backend, emulator, Errno::EAGAIN);
        }

        let mtype = val & 0xc000;
        let shared = val & 0x2000;

        let time_spec = if timeout <= 0 {
            Timespec::default()
        } else {
            let mut buffer = [0u8; size_of::<Timespec>()];
            backend
                .mem_read(timeout, &mut buffer)
                .expect("Failed to read from memory: time_spec");
            let time_spec: &Timespec = unsafe { &*(buffer.as_ptr() as *const Timespec) };
            time_spec.clone()
        };

        if timeout > 0 {
            let errno: i32 = Errno::ETIMEDOUT.into();
            ret_i32!(backend, -errno);
            return;
        }

        let running_task = emulator.inner_mut().thread_dispatcher.running_task_mut();
        if let Some(running_task_cell) = running_task {
            let waiter = if timeout == 0 {
                Waiter::FutexIndefinite(FutexIndefinitelyWaiter::new(uaddr, val, &emulator.backend))
            } else {
                Waiter::FutexNanoSleep(FutexNanoSleepWaiter::new(
                    uaddr,
                    val,
                    (time_spec.tv_sec * 1000i64 + time_spec.tv_nsec / 1000000i64) as u64,
                    emulator.backend.clone(),
                ))
            };
            if option_env!("EMU_LOG") == Some("1") {
                info!(
                    "futex: set waiter: {:?}",
                    match &waiter {
                        Waiter::FutexIndefinite(waiter) => waiter.can_dispatch().to_string() + "/",
                        Waiter::FutexNanoSleep(waiter) => waiter.can_dispatch().to_string() + "|",
                        Waiter::Unknown(_) => unreachable!(),
                    }
                );
            }
            match unsafe { &mut *running_task_cell.get() } {
                AbstractTask::Function64(task) => {
                    task.set_waiter(emulator, waiter);
                }
                AbstractTask::SignalTask(task) => {
                    // Dynarmic currently corrupts the backend handle when a signal task
                    // installs and later drops a futex waiter. Treat signal-task futex
                    // waits as already satisfied so native init can keep progressing.
                    ret_i32!(backend, 0);
                    return;
                }
                AbstractTask::MarshmallowThread(task) => {
                    task.set_waiter(emulator, waiter);
                }
                AbstractTask::KitKatThread(_) => {
                    // Older native worker paths can surface as KitKatThread here even though
                    // full waiter plumbing for that task type is not implemented. Treat the
                    // futex wait as already satisfied so the worker can keep making progress.
                    ret_i32!(backend, 0);
                    return;
                }
            }
            emulator.emu_stop(TaskStatus::S).unwrap();
            return;
        } else {
            unreachable!()
        }

        if emulator.inner_mut().thread_dispatcher.task_counts() > 1 {
            emulator
                .emu_stop(TaskStatus::X)
                .expect("failed to stop emulator");
            ret_i32!(backend, Errno::ETIMEDOUT.as_i32());
            return;
        } else {
            ret_i32!(backend, 0);
            return;
        }
    } else if 1 == cmd {
        let task_count = emulator.inner_mut().thread_dispatcher.task_counts();
        if task_count <= 1 {
            ret_i32!(backend, 0);
            return;
        } else {
            //println!("futex: task count = {}", task_count);
        }

        let mut count = 0;
        for task in emulator.inner_mut().thread_dispatcher.task_list_mut() {
            match unsafe { &mut *task.get() } {
                AbstractTask::Function64(task) => {
                    if option_env!("EMU_LOG") == Some("1") {
                        info!("futex unexpected task type: function64");
                    }
                    let waiter = task.get_waiter();
                    if waiter.is_none() {
                        continue;
                    }
                    //println!("futex unexpected task type: function64");
                    let waiter = waiter.unwrap();
                    match waiter {
                        Waiter::FutexIndefinite(waiter) => waiter.wake_up(uaddr),
                        Waiter::FutexNanoSleep(waiter) => waiter.wake_up(uaddr),
                        _ => continue,
                    };
                    count += 1;
                    if count >= val {
                        break;
                    }
                }
                AbstractTask::SignalTask(task) => {
                    if option_env!("EMU_LOG") == Some("1") {
                        info!("futex unexpected task type: signal_task");
                    }
                    let waiter = task.get_waiter();
                    if waiter.is_none() {
                        continue;
                    }
                    let waiter = waiter.unwrap();
                    match waiter {
                        Waiter::FutexIndefinite(waiter) => waiter.wake_up(uaddr),
                        Waiter::FutexNanoSleep(waiter) => waiter.wake_up(uaddr),
                        _ => continue,
                    };
                    count += 1;
                    if count >= val {
                        break;
                    }
                }
                AbstractTask::MarshmallowThread(task) => {
                    if option_env!("EMU_LOG") == Some("1") {
                        info!("futex unexpected task type: marshmallow_thread");
                    }
                    //println!("futex unexpected task type: marshmallow_thread");
                    let waiter = task.get_waiter();
                    if waiter.is_none() {
                        continue;
                    }
                    let waiter = waiter.unwrap();
                    match waiter {
                        Waiter::FutexIndefinite(waiter) => waiter.wake_up(uaddr),
                        Waiter::FutexNanoSleep(waiter) => waiter.wake_up(uaddr),
                        _ => continue,
                    };
                    count += 1;
                    if count >= val {
                        break;
                    }
                }
                AbstractTask::KitKatThread(_) => continue,
            }
        }
        if count > 0 {
            if option_env!("EMU_LOG") == Some("1") {
                info!("futex: wake up {} tasks", count);
            }
            emulator.emu_stop(TaskStatus::S).unwrap();
            ret_i32!(backend, count as i32);
            return;
        }

        if emulator.inner_mut().context_task.is_some() {
            emulator.emu_stop(TaskStatus::S).unwrap();
            ret_i32!(backend, 1);
            return;
        }

        ret_i32!(backend, 0);
        return;
    } else if 4 == cmd {
        ret_i32!(backend, 0);
        return;
    }
}

pub fn syscall_clock_gettime<T: Clone>(backend: &Backend<T>, emulator: &AndroidEmulator<T>) {
    static START: OnceLock<Instant> = OnceLock::new();

    let clk_id = ldr_i32!(backend, X0);
    let tp_pointer = ldr_u64!(backend, X1);

    if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
        let lr = emulator.get_lr().unwrap_or(0);
        let from_module = emulator.find_caller_name();
        println!(
            "syscall clock_gettime(clk_id={}, tp_pointer=0x{:x}, lr=0x{:x}, from={})",
            clk_id, tp_pointer, lr, from_module
        );
    }

    match clk_id {
        0 => {
            // CLOCK_REALTIME
            if let Ok(duration_since_epoch) = SystemTime::now().duration_since(UNIX_EPOCH) {
                let mut buffer = [0u8; size_of::<Timespec>()];
                let tv = unsafe { &mut *(buffer.as_mut_ptr() as *mut Timespec) };
                tv.tv_sec = duration_since_epoch.as_secs() as i64;
                tv.tv_nsec = duration_since_epoch.subsec_nanos() as i64;
                backend
                    .mem_write(tp_pointer, &buffer)
                    .expect("failed to write timespec");
                ret_i32!(backend, 0);
            } else {
                panic!("SystemTime before UNIX EPOCH!");
            }
        }
        1 => {
            // CLOCK_MONOTONIC
            let start = START.get_or_init(|| Instant::now()).clone();
            let mut buffer = [0u8; size_of::<Timespec>()];
            let duration = Instant::now().duration_since(start);
            let tv = unsafe { &mut *(buffer.as_mut_ptr() as *mut Timespec) };
            tv.tv_sec = duration.as_secs() as i64;
            tv.tv_nsec = duration.subsec_nanos() as i64;
            backend
                .mem_write(tp_pointer, &buffer)
                .expect("failed to write timespec");
            ret_i32!(backend, 0);
        }
        3 => {
            // CLOCK_THREAD_CPUTIME_ID
            let start = START.get_or_init(|| Instant::now()).clone();
            let mut buffer = [0u8; size_of::<Timespec>()];
            let duration = Instant::now().duration_since(start);
            let tv = unsafe { &mut *(buffer.as_mut_ptr() as *mut Timespec) };
            tv.tv_sec = 0;
            tv.tv_nsec = duration.subsec_nanos() as i64;
            backend
                .mem_write(tp_pointer, &buffer)
                .expect("failed to write timespec");
            ret_i32!(backend, 0);
        }
        _ => {
            warn!("clock_gettime fallback clk_id={}", clk_id);
            let start = START.get_or_init(|| Instant::now()).clone();
            let mut buffer = [0u8; size_of::<Timespec>()];
            let duration = Instant::now().duration_since(start);
            let tv = unsafe { &mut *(buffer.as_mut_ptr() as *mut Timespec) };
            tv.tv_sec = duration.as_secs() as i64;
            tv.tv_nsec = duration.subsec_nanos() as i64;
            backend
                .mem_write(tp_pointer, &buffer)
                .expect("failed to write fallback timespec");
            ret_i32!(backend, 0);
        }
    }
}

pub fn syscall_openat<T: Clone>(backend: &Backend<T>, emulator: &AndroidEmulator<T>) {
    let dir_fd = ldr_i32!(backend, X0);
    let flags = OFlag::from_bits_truncate(ldr_u32!(backend, X2));
    let mode = ldr_i32!(backend, X3);
    let path_pointer = ldr_u64!(backend, X1);
    if path_pointer == 0 {
        if option_env!("PRINT_SYSCALL_LOG") == Some("1") || runtime_env_truthy("RNIDBG_TRACE_FS")
        {
            error!("openat: null path pointer");
        }
        throw_err!(backend, emulator, Errno::EFAULT);
    }
    let Ok(path) = backend.mem_read_c_string(path_pointer) else {
        if option_env!("PRINT_SYSCALL_LOG") == Some("1") || runtime_env_truthy("RNIDBG_TRACE_FS")
        {
            error!("openat: failed to read path");
        }
        throw_err!(backend, emulator, Errno::EFAULT);
    };

    if path == "/data/misc/zoneinfo/current/tzdata" {
        throw_err!(backend, emulator, Errno::ENOMEM);
    }

    if path == "/dev/pmsg0" {
        throw_err!(backend, emulator, Errno::EPERM);
    }

    if !path.starts_with("/") {
        if dir_fd != -100 {
            if option_env!("EMU_LOG") == Some("1") {
                error!("openat: dir_fd != AT_FDCWD");
            }

            panic!("dir_fd != AT_FDCWD");
        }
    }

    let from_module = emulator.find_caller_name();
    if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
        info!(
            "syscall try openat(path={}, flags={:?}, mode={}) from {}",
            path, flags, mode, from_module
        );
    }
    let (fd, errno) = open(emulator, &path, flags, mode, &from_module);

    if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
        info!(
            "syscall openat(path={}, flags={:?}, mode={}) -> {} from {}",
            path, flags, mode, fd, from_module
        );
    }

    ret_i32!(backend, fd);
    emulator.set_errno(errno).expect("failed to set errno");
    return;
}

pub fn syscall_mmap<T: Clone>(backend: &Backend<T>, emulator: &AndroidEmulator<T>) {
    let start = ldr_u64!(backend, X0);
    let length = ldr_i32!(backend, X1) as usize;
    let prot = ldr_i32!(backend, X2);
    let flags = ldr_i32!(backend, X3);
    let fd = ldr_i32!(backend, X4);
    let offset = ldr_i32!(backend, X5) << 12;

    match emulator.mmap2(start, length, prot as u32, flags as u32, fd, offset as i64) {
        Ok((errno, addr)) => {
            if errno != Errno::OK {
                throw_err!(backend, emulator, errno);
            }
            ret_u64!(backend, addr);
            return;
        }
        Err(err) => {
            error!("mmap failed: {:?}", err);
            throw_err!(backend, emulator, Errno::EAGAIN);
        }
    }
}

pub fn syscall_mprotect<T: Clone>(backend: &Backend<T>, emulator: &AndroidEmulator<T>) {
    let addr = ldr_u64!(backend, X0);
    let len = ldr_i32!(backend, X1) as usize;
    let prot = ldr_u32!(backend, X2);

    if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
        println!(
            "syscall mprotect(addr=0x{:x}, len={}, prot={:?})",
            addr, len, prot
        );
    }

    let aligned_address = (addr / PAGE_ALIGN as u64) * PAGE_ALIGN as u64;
    let offset = addr - aligned_address;
    let size = len + offset as usize;
    let aligned_length = ((size - 1) / PAGE_ALIGN + 1) * PAGE_ALIGN;

    /*    let mut mem_map_item = None;
    for (begin, map) in emulator.inner_mut().memory.memory_map.iter() {
        if *begin <= aligned_address && aligned_address < (map.base + map.size as u64) {
            mem_map_item = Some(map.clone());
            break;
        }
    }

    if let Some(mem_map_item) = mem_map_item {
        if mem_map_item.from_file {
            let block_prot = Permission::from_bits_truncate(mem_map_item.prot);
            if !block_prot.contains(Permission::WRITE) && prot.contains(Permission::WRITE) {
                throw_err!(backend, emulator, Errno::EACCES);
            }
            if !block_prot.contains(Permission::READ) && prot.contains(Permission::READ) {
                throw_err!(backend, emulator, Errno::EACCES);
            }
        }
    }*/

    if aligned_address % PAGE_ALIGN as u64 != 0 {
        throw_err!(backend, emulator, Errno::EINVAL);
    }

    if let Err(e) = backend.mem_protect(aligned_address, aligned_length, prot) {
        warn!("mprotect failed: {:?}", e);
        throw_err!(backend, emulator, Errno::EINVAL);
    }

    ret_i32!(backend, 0);
}

pub fn syscall_madvise<T: Clone>(backend: &Backend<T>, emulator: &AndroidEmulator<T>) {
    let addr = ldr_u64!(backend, X0);
    let len = ldr_i32!(backend, X1) as usize;
    let advice = ldr_i32!(backend, X2);
    if advice == 4 {
        if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
            println!(
                "syscall madvice(addr=0x{:x}, len={}, advice={}) => success",
                addr, len, advice
            );
        }

        ret_i32!(backend, 0);
    }

    if addr <= 0 {
        if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
            println!(
                "syscall madvice(addr=0x{:x}, len={}, advice={}) => addr is nullptr",
                addr, len, advice
            );
        }
        throw_err!(backend, emulator, Errno::EINVAL);
    }

    if addr % PAGE_ALIGN as u64 != 0 {
        if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
            println!(
                "syscall madvice(addr=0x{:x}, len={}, advice={}) => addr not aligned",
                addr, len, advice
            );
        }
        throw_err!(backend, emulator, Errno::EINVAL);
    }
    if len % PAGE_ALIGN != 0 {
        if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
            println!(
                "syscall madvice(addr=0x{:x}, len={}, advice={}) => len is not aligned",
                addr, len, advice
            );
        }
        throw_err!(backend, emulator, Errno::EINVAL);
    }

    if let Some(_) = emulator.inner_mut().memory.memory_map.get(&addr) {
        if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
            println!(
                "syscall madvice(addr=0x{:x}, len={}, advice={}) => success",
                addr, len, advice
            );
        }
        ret_i32!(backend, 0);
    } else {
        if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
            println!(
                "syscall madvice(addr=0x{:x}, len={}, advice={}) => locked memory",
                addr, len, advice
            );
        }
        throw_err!(backend, emulator, Errno::EINVAL);
    }
}

pub fn syscall_fstat<T: Clone>(backend: &Backend<T>, emulator: &AndroidEmulator<T>) {
    let fd = ldr_i32!(backend, X0);
    let stat_pointer = ldr_u64!(backend, X1);
    let file_system = &mut emulator.inner_mut().file_system;

    if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
        println!(
            "syscall fstat(fd={}, stat_pointer=0x{:x})",
            fd, stat_pointer
        );
    }

    if let Some(file) = file_system.get_file_mut(fd) {
        match file {
            FileIO::Bytes(file) => {
                file.fstat(VMPointer::new(stat_pointer, 0, backend.clone()));
            }
            FileIO::File(file) => {
                file.fstat(VMPointer::new(stat_pointer, 0, backend.clone()));
            }
            FileIO::Dynamic(file) => {
                file.fstat(VMPointer::new(stat_pointer, 0, backend.clone()));
            }
            FileIO::Error(_) => panic!("fstat error, fd: {}, reason: file not found", fd),
            FileIO::Direction(dir) => {
                dir.fstat(VMPointer::new(stat_pointer, 0, backend.clone()));
            }
            FileIO::LocalSocket(socket) => {
                <LocalSocket as FileIOTrait<T>>::fstat(
                    socket,
                    VMPointer::new(stat_pointer, 0, backend.clone()),
                );
            }
        }
    } else {
        throw_err!(backend, emulator, Errno::EBADF);
    }
}

pub fn syscall_munmap<T: Clone>(backend: &Backend<T>, emulator: &AndroidEmulator<T>) {
    let start = ldr_u64!(backend, X0);
    let length = ldr_i32!(backend, X1) as usize;

    if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
        println!("syscall munmap(start=0x{:x}, length={})", start, length);
    }

    if let Err(e) = emulator.munmap(start, length as u64) {
        warn!("munmap failed: {:?}", e);
        throw_err!(backend, emulator, Errno::EINVAL);
    }

    ret_u64!(backend, 0);
}

pub fn syscall_close<T: Clone>(backend: &Backend<T>, emulator: &AndroidEmulator<T>) {
    let fd = ldr_i32!(backend, X0);

    if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
        println!("syscall close(fd={})", fd);
    }

    let file_system = &mut emulator.inner_mut().file_system;
    if let Some(file) = file_system.remove_file(fd) {
        /*        let running_task = emulator.inner_mut().thread_dispatcher
            .running_task_mut();
        let is_main_task = if let Some(running_task_cell) = running_task {
            match unsafe { &mut *running_task_cell.get() } {
                AbstractTask::Function64(_) => true,
                AbstractTask::SignalTask(_) => false,
                AbstractTask::MarshmallowThread(_) => false,
                _ => panic!("close unexpected task type: running_task"),
            }
        } else {
            false
        };*/

        match file {
            FileIO::Bytes(_) => {}
            FileIO::File(mut file) => {
                file.close();
            }
            FileIO::Error(_) => panic!("close error, fd: {}, reason: file not found", fd),
            FileIO::Dynamic(mut file) => {
                file.close();
            }
            FileIO::Direction(_) => {}
            FileIO::LocalSocket(mut socket) => {
                <LocalSocket as FileIOTrait<T>>::close(&mut socket);
            }
        }
    } else {
        throw_err!(backend, emulator, Errno::EBADF);
    }
    ret_i32!(backend, 0);
}

pub fn syscall_read<T: Clone>(backend: &Backend<T>, emulator: &AndroidEmulator<T>) {
    let fd = ldr_i32!(backend, X0);
    let buf = ldr_u64!(backend, X1);
    let count = ldr_i32!(backend, X2) as usize;
    let from_module = emulator.find_caller_name();

    let file_system = &mut emulator.inner_mut().file_system;
    if let Some(file) = file_system.get_file_mut(fd) {
        let mode = match file {
            FileIO::Bytes(bytes) => bytes.st_mode(),
            FileIO::File(file) => file.st_mode(),
            FileIO::Error(_) => {
                throw_err!(backend, emulator, Errno::EBADF);
            }
            FileIO::Dynamic(file) => file.st_mode(),
            FileIO::Direction(dir) => <Direction as FileIOTrait<T>>::st_mode(dir),
            FileIO::LocalSocket(_) => StMode::S_IRUSR | StMode::S_IWUSR,
        };

        if !(mode.contains(StMode::S_IRUSR)
            || mode.contains(StMode::S_IROTH)
            || mode.contains(StMode::S_IRGRP))
            && from_module != "libc.so"
        {
            throw_err!(backend, emulator, Errno::EACCES);
        }

        let read = match file {
            FileIO::Bytes(file) => file.read(VMPointer::new(buf, 0, backend.clone()), count),
            FileIO::File(file) => file.read(VMPointer::new(buf, 0, backend.clone()), count),
            FileIO::Error(_) => unreachable!(),
            FileIO::Dynamic(file) => file.read(VMPointer::new(buf, 0, backend.clone()), count),
            FileIO::Direction(_) => unreachable!(),
            FileIO::LocalSocket(socket) => {
                socket.read(VMPointer::new(buf, 0, backend.clone()), count)
            }
        };

        if option_env!("PRINT_SYSCALL_LOG") == Some("1")
            || runtime_env_truthy("RNIDBG_TRACE_NET_IO")
        {
            println!(
                "syscall read(fd={}, buf=0x{:x}, count={}) => {} from {}",
                fd, buf, count, read, from_module
            );
        }

        ret_u64!(backend, read as u64);
    } else {
        if option_env!("PRINT_SYSCALL_LOG") == Some("1")
            || runtime_env_truthy("RNIDBG_TRACE_NET_IO")
        {
            println!(
                "syscall read(fd={}, buf=0x{:x}, count={}) => EBADF from {}",
                fd, buf, count, from_module
            );
        }

        throw_err!(backend, emulator, Errno::EBADF);
    }
}

pub fn syscall_geteuid<T: Clone>(backend: &Backend<T>, emulator: &AndroidEmulator<T>) {
    if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
        println!("syscall geteuid()");
    }

    ret_i32!(backend, 10261)
}

pub fn syscall_renameat<T: Clone>(backend: &Backend<T>, emulator: &AndroidEmulator<T>) {
    let old_dir_fd = ldr_i32!(backend, X0);
    let old_path_ptr = ldr_u64!(backend, X1);
    let new_dir_fd = ldr_i32!(backend, X2);
    let new_path_ptr = ldr_u64!(backend, X3);

    let old_path = backend.mem_read_c_string(old_path_ptr).unwrap();
    let new_path = backend.mem_read_c_string(new_path_ptr).unwrap();

    if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
        if old_path.is_ascii() && new_path.is_ascii() {
            println!(
                "syscall renameat(old_dir_fd={}, old_path={}, new_dir_fd={}, new_path={})",
                old_dir_fd, old_path, new_dir_fd, new_path
            );
        } else {
            println!("syscall renameat(old_dir_fd={}, old_path=hex::decode({}), new_dir={}, new_path=hex::deecode({}))", old_dir_fd, hex::encode(old_path.as_bytes()), new_dir_fd, hex::encode(new_path.as_bytes()));
        }
    }

    if !new_path.is_empty() && new_path.as_bytes()[0] != b'/' {
        throw_err!(backend, emulator, Errno::EROFS);
    }

    unreachable!("renameat not supported");
}

pub fn syscall_fstatat<T: Clone>(backend: &Backend<T>, emulator: &AndroidEmulator<T>) {
    let fd = ldr_i32!(backend, X0);
    let path = ldr_string!(backend, X1);
    let stat_pointer = ldr_u64!(backend, X2);
    let flag = ldr_u32!(backend, X3);

    if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
        if path.is_ascii() {
            println!(
                "syscall fstatat(fd={}, path={}, stat_pointer=0x{:x}, flag={})",
                fd, path, stat_pointer, flag
            );
        } else {
            println!(
                "syscall fstatat(fd={}, path=hex::decode({}), stat_pointer=0x{:x}, flag={})",
                fd,
                hex::encode(path.as_bytes()),
                stat_pointer,
                flag
            );
        }
    }

    if path.is_empty() || path.as_bytes()[0] != b'/' {
        throw_err!(backend, emulator, Errno::ENOENT);
    }

    if fd != -100 {
        throw_err!(backend, emulator, Errno::EBADF);
    }

    let file_system = &mut emulator.inner_mut().file_system;
    if let Some(ref resolver) = file_system.file_resolver {
        if let Some(file) = resolver(
            file_system,
            path.as_str(),
            OFlag::from_bits_truncate(flag),
            0,
        ) {
            match file {
                FileIO::Bytes(file) => file.fstat(VMPointer::new(stat_pointer, 0, backend.clone())),
                FileIO::Error(errno) => {
                    ret_i32!(backend, fd);
                    emulator.set_errno(errno).expect("failed to set errno");
                    return;
                }
                FileIO::File(file) => file.fstat(VMPointer::new(stat_pointer, 0, backend.clone())),
                FileIO::Dynamic(file) => {
                    file.fstat(VMPointer::new(stat_pointer, 0, backend.clone()))
                }
                FileIO::Direction(dir) => {
                    dir.fstat(VMPointer::new(stat_pointer, 0, backend.clone()));
                }
                FileIO::LocalSocket(_) => unreachable!(),
            }
        } else {
            throw_err!(backend, emulator, Errno::ENOENT);
        }
    } else {
        panic!("file_resolver not found");
    }
}

pub fn syscall_getppid<T: Clone>(backend: &Backend<T>, emulator: &AndroidEmulator<T>) {
    if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
        println!("syscall getppid()");
    }

    ret_i32!(backend, emulator.inner_mut().ppid as i32);
}

pub fn syscall_getpid<T: Clone>(backend: &Backend<T>, emulator: &AndroidEmulator<T>) {
    if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
        println!("syscall getpid()");
    }

    ret_i32!(backend, emulator.inner_mut().pid as i32);
}

pub fn syscall_gettid<T: Clone>(backend: &Backend<T>, emulator: &AndroidEmulator<T>) {
    if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
        println!("syscall gettid()");
    }

    ret_i32!(backend, emulator.get_current_pid() as i32);
}

pub fn syscall_getuid<T: Clone>(backend: &Backend<T>, emulator: &AndroidEmulator<T>) {
    if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
        println!("syscall getuid()");
    }
    ret_i32!(backend, 10261);
}

pub fn syscall_clone<'a, T: Clone>(backend: &Backend<'a, T>, emulator: &AndroidEmulator<'a, T>) {
    // // pid_t __bionic_clone(int flags, void* child_stack, pid_t* parent_tid, void* tls, pid_t* child_tid, int (*fn)(void*), void* arg);
    let child_stack = ldr_u64!(backend, X1);
    let parent_tid = ldr_u32!(backend, X2);

    if child_stack == 0 && parent_tid == 0 {
        if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
            println!("syscall clone(child_stack=0, parent_tid=0)");
        }
        syscall_fork(backend, emulator);
        return;
    }

    let fnc = emulator.backend.reg_read(X5).unwrap() as i64;
    let arg = emulator.backend.reg_read(X6).unwrap() as i64;
    if child_stack != 0
        && backend.mem_read_i64(child_stack).unwrap() == fnc
        && backend.mem_read_i64(child_stack + 8).unwrap() == arg
    {
        if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
            println!("syscall clone(child_stack=0x{:x}, parent_tid=0x{:x}, fn=0x{:x}, arg=0x{:x}) => bionic_clone", child_stack, parent_tid, fnc, arg);
        }
        syscall_bionic_clone(backend, emulator);
        return;
    } else {
        panic!("pthread_clone")
    }
}

pub fn syscall_sigaltstack<T: Clone>(backend: &Backend<T>, emulator: &AndroidEmulator<T>) {
    let ss = ldr_u64!(backend, X0);
    let old_ss = ldr_u64!(backend, X1);

    if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
        println!("syscall sigaltstack(ss=0x{:x}, old_ss=0x{:x})", ss, old_ss);
    }

    if old_ss != 0 {
        panic!("sigaltstack not supported: old_ss");
    }

    ret_i32!(backend, 0);
}

pub fn syscall_rt_sigaction<T: Clone>(backend: &Backend<T>, emulator: &AndroidEmulator<T>) {
    let signum = ldr_i32!(backend, X0);
    let act = ldr_u64!(backend, X1);
    let oldact = ldr_u64!(backend, X2);
    let sigsetsize = ldr_u64!(backend, X3);

    if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
        let from = emulator.find_caller_name();
        println!(
            "syscall rt_sigaction(signum={}, act=0x{:x}, oldact=0x{:x}, sigsetsize={}) from {}",
            signum, act, oldact, sigsetsize, from
        );
    }

    ret_i32!(backend, 0);
}

pub fn syscall_lseek<T: Clone>(backend: &Backend<T>, emulator: &AndroidEmulator<T>) {
    let fd = ldr_i32!(backend, X0);
    let offset = ldr_u64!(backend, X1) as i64;
    let whence = ldr_i32!(backend, X2);

    let file_system = &mut emulator.inner_mut().file_system;
    if let Some(file) = file_system.get_file_mut(fd) {
        let result = match file {
            FileIO::Bytes(file) => file.lseek(offset, whence),
            FileIO::File(file) => file.lseek(offset, whence),
            FileIO::Error(_) => unreachable!(),
            FileIO::Dynamic(file) => file.lseek(offset, whence),
            FileIO::Direction(_) => unreachable!(),
            FileIO::LocalSocket(_) => panic!("lseek not supported: local socket"),
        };
        if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
            println!(
                "syscall lseek(fd={}, offset={}, whence={}) => {:?}",
                fd, offset, whence, result
            );
        }
        match result {
            SeekResult::Ok(offset) => {
                ret_u64!(backend, offset as u64);
            }
            SeekResult::WhenceError => {
                throw_err!(backend, emulator, Errno::EINVAL);
            }
            SeekResult::OffsetError => {
                throw_err!(backend, emulator, Errno::ENXIO);
            }
            SeekResult::UnknownError => {
                throw_err!(backend, emulator, Errno::ESPIPE);
            }
        }
    } else {
        if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
            println!(
                "syscall lseek(fd={}, offset={}, whence={}) => EBADF",
                fd, offset, whence
            );
        }
        throw_err!(backend, emulator, Errno::EBADF);
    }
}

pub fn syscall_mkdirat<T: Clone>(backend: &Backend<T>, emulator: &AndroidEmulator<T>) {
    let dir_fd = ldr_i32!(backend, X0);
    let path = ldr_string!(backend, X1);
    let mode = ldr_u32!(backend, X2);

    if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
        println!(
            "syscall mkdirat(dir_fd={}, path={}, mode={:X})",
            dir_fd, path, mode
        );
    }

    if path.is_empty() || path.as_bytes()[0] != b'/' {
        throw_err!(backend, emulator, Errno::ENOENT);
    }

    if dir_fd != -100 {
        throw_err!(backend, emulator, Errno::EBADF);
    }

    if path == "/sdcard/Android/" || path == "/sdcard/Android" {
        throw_err!(backend, emulator, Errno::EEXIST);
    }

    unreachable!()
}

pub fn syscall_set_tid_address<'a, T: Clone>(
    backend: &Backend<'a, T>,
    emulator: &AndroidEmulator<'a, T>,
) {
    let tidptr = ldr_u64!(backend, X0);

    if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
        let from = emulator.find_caller_name();
        println!(
            "syscall set_tid_address(tidptr=0x{:x}) from {}",
            tidptr, from
        );
    }

    let task = emulator.inner_mut().context_task.as_ref().unwrap();
    match unsafe { &mut *task.get() } {
        AbstractTask::MarshmallowThread(task) => {
            task.set_tid_ptr(VMPointer::new(tidptr, 0, backend.clone()));
        }
        AbstractTask::Function64(_) | AbstractTask::SignalTask(_) => {
            if runtime_env_truthy("RNIDBG_TRACE_THREADS") {
                eprintln!(
                    "syscall set_tid_address bypass tidptr=0x{:x} current_pid={} task_kind=main-or-signal",
                    tidptr,
                    emulator.get_current_pid()
                );
            }
        }
        AbstractTask::KitKatThread(_) => panic!("set_tid_address not supported: task type"),
    }

    ret_i32!(backend, emulator.get_current_pid() as i32);
}

pub fn syscall_rt_sigprocmask<T: Clone>(backend: &Backend<T>, emulator: &AndroidEmulator<T>) {
    let how = ldr_i32!(backend, X0);
    let set = ldr_u64!(backend, X1);
    let oldset = ldr_u64!(backend, X2);

    if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
        let from = emulator.find_caller_name();
        println!(
            "syscall rt_sigprocmask(how={}, set=0x{:x}, oldset=0x{:x}) from {}",
            how, set, oldset, from
        );
    }

    let task = emulator.inner_mut().context_task.as_ref().unwrap();
    match unsafe { &mut *task.get() } {
        AbstractTask::MarshmallowThread(task) => {
            let ops = task.signal_ops_mut();
            if oldset != 0 {
                backend.mem_write(oldset, &0u64.to_le_bytes()).unwrap();
            }

            if set == 0 {
                ret_i32!(backend, 0);
                return;
            }

            let mask = backend.mem_read_u64(set).unwrap();
            match how {
                0 => {
                    let set = UnixSigSet::new(mask);
                    let pending_set = UnixSigSet::new(0);
                    ops.set_sig_mask_set(Box::new(set));
                    ops.set_sig_pending_set(Box::new(pending_set));
                    ret_i32!(backend, 0);
                    return;
                }
                1 => {
                    let set = UnixSigSet::new(0);
                    let pending_set = UnixSigSet::new(0);
                    ops.set_sig_mask_set(Box::new(set));
                    ops.set_sig_pending_set(Box::new(pending_set));
                    ret_i32!(backend, 0);
                    return;
                }
                2 => {
                    let set = UnixSigSet::new(mask);
                    let pending_set = UnixSigSet::new(0);
                    ops.set_sig_mask_set(Box::new(set));
                    ops.set_sig_pending_set(Box::new(pending_set));
                    ret_i32!(backend, 0);
                    return;
                }
                _ => panic!("rt_sigprocmask not supported: {}", how),
            }
        }
        AbstractTask::Function64(task) => {
            let ops = task.signal_ops_mut();
            if oldset != 0 {
                backend.mem_write(oldset, &0u64.to_le_bytes()).unwrap();
            }

            if set == 0 {
                ret_i32!(backend, 0);
                return;
            }

            let mask = backend.mem_read_u64(set).unwrap();
            match how {
                0 => {
                    let set = UnixSigSet::new(mask);
                    let pending_set = UnixSigSet::new(0);
                    ops.set_sig_mask_set(Box::new(set));
                    ops.set_sig_pending_set(Box::new(pending_set));
                    ret_i32!(backend, 0);
                    return;
                }
                1 => {
                    let set = UnixSigSet::new(0);
                    let pending_set = UnixSigSet::new(0);
                    ops.set_sig_mask_set(Box::new(set));
                    ops.set_sig_pending_set(Box::new(pending_set));
                    ret_i32!(backend, 0);
                    return;
                }
                2 => {
                    let set = UnixSigSet::new(mask);
                    let pending_set = UnixSigSet::new(0);
                    ops.set_sig_mask_set(Box::new(set));
                    ops.set_sig_pending_set(Box::new(pending_set));
                    ret_i32!(backend, 0);
                    return;
                }
                _ => panic!("rt_sigprocmask not supported: {}", how),
            }
        }
        AbstractTask::SignalTask(_) => {
            if oldset != 0 {
                backend.mem_write(oldset, &0u64.to_le_bytes()).unwrap();
            }
            if runtime_env_truthy("RNIDBG_TRACE_THREADS") {
                eprintln!(
                    "syscall rt_sigprocmask bypass how={} set=0x{:x} oldset=0x{:x} task_kind=signal",
                    how, set, oldset
                );
            }
            ret_i32!(backend, 0);
            return;
        }
        AbstractTask::KitKatThread(_) => panic!("set_tid_address not supported: task type"),
    }

    throw_err!(backend, emulator, Errno::EINVAL);
}

pub fn syscall_exit<T: Clone>(backend: &Backend<T>, emulator: &AndroidEmulator<T>) {
    let status = ldr_i32!(backend, X0);

    let task = emulator.inner_mut().context_task.as_ref().unwrap();
    match unsafe { &mut *task.get() } {
        AbstractTask::MarshmallowThread(task) => {
            if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
                println!("syscall exit(status={}) by ThreadTask", status);
            }
            task.set_exit_status(status)
        }
        AbstractTask::Function64(_) | AbstractTask::SignalTask(_) => {
            if runtime_env_truthy("RNIDBG_TRACE_THREADS") {
                eprintln!(
                    "syscall exit(status={}) bypass task_kind=main-or-signal current_pid={}",
                    status,
                    emulator.get_current_pid()
                );
            }
        }
        AbstractTask::KitKatThread(_) => panic!("set_tid_address not supported: task type"),
    }

    emulator.emu_stop(TaskStatus::X).unwrap();
}

pub fn syscall_bionic_clone<'a, T: Clone>(
    backend: &Backend<'a, T>,
    emulator: &AndroidEmulator<'a, T>,
) {
    static CLONE_CALL_COUNT: OnceLock<AtomicU32> = OnceLock::new();
    let flag = ldr_u32!(backend, X0);
    let child_stack = ldr_u64!(backend, X1);
    let parent_tid = ldr_u64!(backend, X2);
    let tls = ldr_u64!(backend, X3);
    let child_tid = ldr_u64!(backend, X4);
    let fn_ptr = ldr_u64!(backend, X5);
    let arg = ldr_u64!(backend, X6);

    let flag = CloneFlag::from_bits(flag).unwrap();

    if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
        println!("syscall bionic_clone(flag={:?}, child_stack=0x{:x}, parent_tid=0x{:x}, tls=0x{:x}, child_tid=0x{:x}, fn=0x{:x}, arg=0x{:x})", flag, child_stack, parent_tid, tls, child_tid, fn_ptr, arg);
    }

    if !flag.contains(CloneFlag::CLONE_VM) {
        // 不支持使用clone创建新进程
        panic!("bionic_clone not supported: CLONE_VM, unable to copy address space");
    }

    if !flag.contains(CloneFlag::CLONE_FS) {
        panic!("bionic_clone not supported: CLONE_FS, unable to share file system");
    }

    if !flag.contains(CloneFlag::CLONE_FILES) {
        panic!("bionic_clone not supported: CLONE_FILES, unable to share file descriptors");
    }

    if !flag.contains(CloneFlag::CLONE_SIGHAND) {
        panic!("bionic_clone not supported: CLONE_SIGHAND, unable to share signal handlers");
    } else {
        if !flag.contains(CloneFlag::CLONE_VM) {
            throw_err!(backend, emulator, Errno::EINVAL);
        }
    }

    if !flag.contains(CloneFlag::CLONE_THREAD) {
        panic!("bionic_clone not supported: CLONE_THREAD, unable to share thread group");
    } else {
        if !flag.contains(CloneFlag::CLONE_SIGHAND) {
            throw_err!(backend, emulator, Errno::EINVAL);
        }
    }

    let thread_id = emulator
        .inner_mut()
        .task_id_factory
        .fetch_add(1, Ordering::SeqCst);
    let clone_call_count = CLONE_CALL_COUNT
        .get_or_init(|| AtomicU32::new(0))
        .fetch_add(1, Ordering::SeqCst)
        + 1;
    let lr = emulator.get_lr().unwrap_or(0);
    let caller = emulator
        .find_caller()
        .map(|module_cell| {
            let module = unsafe { &*module_cell.get() };
            format!("{}@0x{:X}", module.name, lr.saturating_sub(module.base))
        })
        .unwrap_or_else(|| format!("@0x{:X}", lr));
    let actual_start = backend.mem_read_u64(arg + 0x60).unwrap_or(0);
    let actual_arg = backend.mem_read_u64(arg + 0x68).unwrap_or(0);

    if runtime_env_truthy("RNIDBG_TRACE_THREADS") {
        let arg_slots = if clone_call_count
            <= runtime_env_u32("RNIDBG_TRACE_THREAD_ARG_SLOTS_LIMIT").unwrap_or(8)
        {
            let mut parts = Vec::new();
            for offset in [0x40_u64, 0x48, 0x50, 0x58, 0x60, 0x68] {
                let value = backend.mem_read_u64(arg + offset).unwrap_or(0);
                parts.push(format!(
                    "arg+0x{:x}={}",
                    offset,
                    describe_guest_addr(emulator, value)
                ));
            }
            format!(" {}", parts.join(" "))
        } else {
            String::new()
        };
        warn!(
            "bionic_clone create tid={} fn={} arg=0x{:x} child_stack=0x{:x} tls=0x{:x} child_tid=0x{:x} parent_tid=0x{:x} lr=0x{:x} caller={}{}",
            thread_id,
            describe_guest_addr(emulator, fn_ptr),
            arg,
            child_stack,
            tls,
            child_tid,
            parent_tid,
            lr,
            caller,
            arg_slots
        );
    }

    if flag.contains(CloneFlag::CLONE_PARENT_SETTID) {
        if parent_tid == 0 {
            throw_err!(backend, emulator, Errno::EINVAL);
        }
        backend
            .mem_write(parent_tid, &thread_id.to_le_bytes())
            .unwrap();
    }

    let fake_funclib_worker = emulator
        .inner_mut()
        .memory
        .find_module_by_address(actual_start)
        .and_then(|module_cell| {
            let module = unsafe { &*module_cell.get() };
            if module.name != "libFunclib.so" {
                return None;
            }
            let kind = match actual_start - module.base {
                0x3b54d8 => Some("single-buffer-data-thread"),
                0x3f4720 => Some("p2p-thread-proc"),
                0x4cb3c4 => Some("async-task-wrapper"),
                _ => None,
            }?;
            Some((kind, module.base))
        })
        .filter(|(kind, _)| should_fake_funclib_worker(kind));
    if let Some((kind, funclib_base)) = fake_funclib_worker {
        if actual_arg != 0 {
            match kind {
                "single-buffer-data-thread" => {
                    let _ = backend.mem_write(actual_arg + 0x20, &[1u8]);
                    let _ = backend.mem_write(actual_arg + 0x21, &[0u8]);
                }
                "p2p-thread-proc" => {
                    let _ = backend.mem_write(actual_arg + 312, &0u64.to_le_bytes());
                    let _ = backend.mem_write(actual_arg + 1616, &[1u8]);
                    let _ = backend.mem_write(actual_arg + 5340, &1u32.to_le_bytes());
                }
                "async-task-wrapper" => {
                    let thread_callback = backend.mem_read_u64(arg + 0x48).unwrap_or(0);
                    let thread_callback_valid = emulator
                        .inner_mut()
                        .memory
                        .find_module_by_address(thread_callback)
                        .and_then(|module_cell| {
                            let module = unsafe { &*module_cell.get() };
                            (module.name == "libFunclib.so").then_some(thread_callback)
                        });
                    let callback_owner = backend.mem_read_u64(actual_arg).unwrap_or(0);
                    let callback = if let Some(thread_callback) = thread_callback_valid {
                        thread_callback
                    } else if callback_owner != 0 {
                        backend.mem_read_u64(callback_owner + 16).unwrap_or(0)
                    } else {
                        0
                    };
                    let blackbox_kind = blackbox_p2p_async_callback(emulator, callback, actual_arg);
                    let callback_ret = if blackbox_kind.is_some()
                        || runtime_env_truthy("RNIDBG_FAKE_ASYNC_TASK_WRAPPER_NO_CALLBACK")
                    {
                        None
                    } else if callback != 0 {
                        emulator.e_func(callback, vec![UnicornArg::Ptr(actual_arg)])
                    } else {
                        None
                    };
                    let running_before = backend.mem_read_i32(actual_arg + 16).unwrap_or(0);
                    let waiter_before = backend.mem_read_i32(actual_arg + 204).unwrap_or(0);
                    let done_before = backend.mem_read_i32(actual_arg + 208).unwrap_or(0);
                    if let Some(kind) = blackbox_kind {
                        if runtime_env_truthy("RNIDBG_TRACE_THREADS") {
                            warn!(
                                "async-wrapper blackbox tid={} arg=0x{:x} cb={} kind={} running_before={} waiter_before={} done_before={}",
                                thread_id,
                                actual_arg,
                                describe_guest_addr(emulator, callback),
                                kind,
                                running_before,
                                waiter_before,
                                done_before
                            );
                        }
                    } else {
                        let _ = callback_ret;
                    }
                    let _ = backend.mem_write(actual_arg + 208, &1u32.to_le_bytes());
                    let waiter = backend.mem_read_i32(actual_arg + 204).unwrap_or(0);
                    if waiter != 0 {
                        let _ = emulator.e_func(
                            funclib_base + 0x6db0b0,
                            vec![UnicornArg::Ptr(actual_arg + 0x74)],
                        );
                    }
                    if runtime_env_truthy("RNIDBG_TRACE_THREADS") {
                        warn!(
                            "async-wrapper tid={} arg=0x{:x} owner=0x{:x} cb={} cb_ret={:?} running_before={} waiter_before={} done_before={} waiter_after={} done_after={}",
                            thread_id,
                            actual_arg,
                            callback_owner,
                            describe_guest_addr(emulator, callback),
                            callback_ret,
                            running_before,
                            waiter_before,
                            done_before,
                            waiter,
                            backend.mem_read_i32(actual_arg + 208).unwrap_or(0)
                        );
                    }
                }
                _ => {}
            }
        }
        if child_tid != 0 {
            backend
                .mem_write(child_tid, &thread_id.to_le_bytes())
                .unwrap();
        }
        if runtime_env_truthy("RNIDBG_TRACE_THREADS") {
            warn!(
                "faking funclib worker clone tid={} kind={} actual_start={} actual_arg=0x{:x}",
                thread_id,
                kind,
                describe_guest_addr(emulator, actual_start),
                actual_arg
            );
        }
        ret_i32!(backend, thread_id as i32);
        return;
    }

    if runtime_env_truthy("RNIDBG_FAKE_CLONE_THREADS") {
        if child_tid != 0 {
            backend
                .mem_write(child_tid, &thread_id.to_le_bytes())
                .unwrap();
        }
        ret_i32!(backend, thread_id as i32);
        return;
    }

    if let Some(real_limit) = runtime_env_u32("RNIDBG_CLONE_REAL_LIMIT") {
        if clone_call_count > real_limit {
            if runtime_env_truthy("RNIDBG_TRACE_THREADS") {
                warn!(
                    "rejecting clone tid={} after clone_call_count={} real_limit={} lr=0x{:x} caller={}",
                    thread_id,
                    clone_call_count,
                    real_limit,
                    lr,
                    caller
                );
            }
            throw_err!(backend, emulator, Errno::EAGAIN);
        }
    }

    //println!("bbbbbbbbbbbb");
    let thread = AbstractTask::MarshmallowThread(MarshmallowThread::new(
        emulator.clone(),
        thread_id,
        VMPointer::new(fn_ptr, 0, backend.clone()),
        VMPointer::new(arg, 0, backend.clone()),
        Some(VMPointer::new(child_tid, 0, backend.clone())),
    ));
    //println!("ddddddddddd");
    emulator.inner_mut().thread_dispatcher.add_thread(thread);
    //println!("cccccc");

    if child_tid != 0 {
        backend
            .mem_write(child_tid, &thread_id.to_le_bytes())
            .unwrap();
    }
    ret_i32!(backend, thread_id as i32);
}

#[inline]
pub fn syscall_fork<T: Clone>(backend: &Backend<T>, emulator: &AndroidEmulator<T>) {
    panic!()
}

pub fn syscall_faccessat<T: Clone>(backend: &Backend<T>, emulator: &AndroidEmulator<T>) {
    let dir_fd = ldr_i32!(backend, X0);
    let path = ldr_string!(backend, X1);
    let mode = ldr_i32!(backend, X2);
    let flag = ldr_i32!(backend, X3);

    if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
        println!(
            "syscall faccessat(dir_fd={}, path={}, mode={}, flag={})",
            dir_fd, path, mode, flag
        );
    }

    if !path.is_ascii() {
        panic!("faccessat not supported: path is not ascii");
    }

    if dir_fd == -100 {
        if path == "/proc/rk_dmabuf" {
            throw_err!(backend, emulator, Errno::EINVAL);
        }
        if path == "/proc/device-tree/rockchip-suspend" {
            throw_err!(backend, emulator, Errno::EINVAL);
        }
        if path == "/proc/device-tree/rockchip-system-monitor" {
            throw_err!(backend, emulator, Errno::EINVAL);
        }
        if path == "/proc/mpp_service/rkvenc-core0" {
            throw_err!(backend, emulator, Errno::EINVAL);
        }
        if path.starts_with("/vendor") {
            throw_err!(backend, emulator, Errno::EINVAL);
        }
        if path == "/sys/bus/platform/drivers/hisi-lpc" {
            throw_err!(backend, emulator, Errno::EINVAL);
        }
        if path == "/hmdocker" {
            throw_err!(backend, emulator, Errno::EINVAL);
        }

        if path == "/data/local/su"
            || path == "/data/local/bin/su"
            || path == "/data/local/xbin/su"
            || path == "/sbin/su"
            || path == "/su/bin/su"
            || path == "/system/bin/su"
            || path == "/system/bin/.ext/su"
            || path == "/system/bin/failsafe/su"
            || path == "/system/sd/xbin/su"
            || path == "/system/usr/we-need-root/su"
            || path == "/system/xbin/su"
            || path == "/cache/su"
            || path == "/data/su"
            || path == "/dev/su"
        {
            throw_err!(backend, emulator, Errno::EINVAL);
        }

        if path == "/data/data/com.tencent.mobileqq" {
            ret_i32!(backend, 0);
            return;
        }
    }

    panic!()
}

pub fn syscall_getdents64<T: Clone>(backend: &Backend<T>, emulator: &AndroidEmulator<T>) {
    let fd = ldr_i32!(backend, X0);
    let dirp = ldr_u64!(backend, X1);
    let size = ldr_i32!(backend, X2) as usize;

    if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
        println!(
            "syscall getdents64(fd={}, dirp=0x{:x}, size={})",
            fd, dirp, size
        );
    }

    let file_system = &mut emulator.inner_mut().file_system;
    if let Some(file) = file_system.get_file_mut(fd) {
        let ret = match file {
            FileIO::Bytes(_) => unreachable!(),
            FileIO::File(_) => unreachable!(),
            FileIO::Error(_) => unreachable!(),
            FileIO::Dynamic(_) => unreachable!(),
            FileIO::Direction(dir) => {
                dir.getdents64(VMPointer::new(dirp, 0, backend.clone()), size)
            }
            FileIO::LocalSocket(_) => unreachable!(),
        };

        ret_u64!(backend, ret as u64);
    } else {
        throw_err!(backend, emulator, Errno::EBADF);
    }
}

pub fn syscall_write<T: Clone>(backend: &Backend<T>, emulator: &AndroidEmulator<T>) {
    let fd = ldr_i32!(backend, X0);
    let buf = ldr_u64!(backend, X1);
    let count = ldr_i32!(backend, X2) as usize;

    let from_module = emulator.find_caller_name();
    let file_system = &mut emulator.inner_mut().file_system;
    if let Some(file) = file_system.get_file_mut(fd) {
        let mode = match file {
            FileIO::Bytes(bytes) => bytes.st_mode(),
            FileIO::File(file) => file.st_mode(),
            FileIO::Error(_) => {
                throw_err!(backend, emulator, Errno::EBADF);
            }
            FileIO::Dynamic(file) => file.st_mode(),
            FileIO::Direction(_) => unreachable!(),
            FileIO::LocalSocket(_) => StMode::S_IRUSR | StMode::S_IWUSR,
        };

        if !(mode.contains(StMode::S_IWUSR)
            || mode.contains(StMode::S_IWOTH)
            || mode.contains(StMode::S_IWGRP))
            && from_module != "libc.so"
        {
            if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
                println!(
                    "syscall write(fd={}, buf=0x{:x}, count={}) => EACCES from {}",
                    fd, buf, count, from_module
                );
            }
            throw_err!(backend, emulator, Errno::EACCES);
        }

        let data = match backend.mem_read_as_vec(buf, count) {
            Ok(data) => data,
            Err(err) => {
                eprintln!(
                    "syscall write mem_read failed fd={} buf=0x{:x} count={} from {} err={:?}",
                    fd, buf, count, from_module, err
                );
                throw_err!(backend, emulator, Errno::EFAULT);
            }
        };

        let written = match file {
            FileIO::Bytes(file) => file.write(data.as_slice()),
            FileIO::File(file) => file.write(data.as_slice()),
            FileIO::Error(_) => unreachable!(),
            FileIO::Dynamic(file) => file.write(data.as_slice()),
            FileIO::Direction(_) => unreachable!(),
            FileIO::LocalSocket(socket) => {
                <LocalSocket as FileIOTrait<T>>::write(socket, data.as_slice())
            }
        };

        if written == -1 {
            throw_err!(backend, emulator, Errno::EACCES);
        }

        if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
            println!(
                "syscall write(fd={}, buf=0x{:x}, count={}) => {} from {}",
                fd, buf, count, written, from_module
            );
        }

        ret_u64!(backend, written as u64);
    } else {
        if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
            println!(
                "syscall write(fd={}, buf=0x{:x}, count={}) => EBADF from {}",
                fd, buf, count, from_module
            );
        }

        throw_err!(backend, emulator, Errno::EBADF);
    }
}

pub fn syscall_writev<T: Clone>(backend: &Backend<T>, emulator: &AndroidEmulator<T>) {
    let fd = ldr_i32!(backend, X0);
    let iov = ldr_u64!(backend, X1);
    let iovcnt = ldr_i32!(backend, X2).max(0) as usize;
    let from_module = emulator.find_caller_name();

    if iovcnt > WRITEV_IOV_MAX {
        warn!(
            "syscall writev rejected oversized iovcnt={} fd={} from {}",
            iovcnt, fd, from_module
        );
        throw_err!(backend, emulator, Errno::EINVAL);
    }

    let file_system = &mut emulator.inner_mut().file_system;
    if let Some(file) = file_system.get_file_mut(fd) {
        let mode = match file {
            FileIO::Bytes(bytes) => bytes.st_mode(),
            FileIO::File(file) => file.st_mode(),
            FileIO::Error(_) => {
                throw_err!(backend, emulator, Errno::EBADF);
            }
            FileIO::Dynamic(file) => file.st_mode(),
            FileIO::Direction(_) => unreachable!(),
            FileIO::LocalSocket(_) => StMode::S_IRUSR | StMode::S_IWUSR,
        };

        if !(mode.contains(StMode::S_IWUSR)
            || mode.contains(StMode::S_IWOTH)
            || mode.contains(StMode::S_IWGRP))
            && from_module != "libc.so"
        {
            throw_err!(backend, emulator, Errno::EACCES);
        }

        let mut total_written = 0usize;
        for index in 0..iovcnt {
            let base = iov + (index as u64 * 16);
            let buf_ptr = backend.mem_read_v2::<u64>(base).unwrap_or(0);
            let buf_len = backend.mem_read_v2::<u64>(base + 8).unwrap_or(0) as usize;
            if buf_ptr == 0 || buf_len == 0 {
                continue;
            }
            if buf_len > MAX_WRITEV_IOV_LEN {
                warn!(
                    "syscall writev rejected oversized iov_len={} fd={} index={} buf=0x{:X} from {}",
                    buf_len, fd, index, buf_ptr, from_module
                );
                throw_err!(backend, emulator, Errno::EINVAL);
            }
            let Some(next_total) = total_written.checked_add(buf_len) else {
                warn!(
                    "syscall writev total overflow fd={} index={} total={} add={} from {}",
                    fd, index, total_written, buf_len, from_module
                );
                throw_err!(backend, emulator, Errno::EINVAL);
            };
            if next_total > MAX_WRITEV_TOTAL_LEN {
                warn!(
                    "syscall writev rejected oversized total={} fd={} index={} from {}",
                    next_total, fd, index, from_module
                );
                throw_err!(backend, emulator, Errno::EINVAL);
            }
            let data = match backend.mem_read_as_vec(buf_ptr, buf_len) {
                Ok(data) => data,
                Err(err) => {
                    warn!(
                        "syscall writev mem_read failed fd={} index={} buf=0x{:X} len={} err={:?} from {}",
                        fd, index, buf_ptr, buf_len, err, from_module
                    );
                    throw_err!(backend, emulator, Errno::EFAULT);
                }
            };
            let written = match file {
                FileIO::Bytes(file) => file.write(data.as_slice()),
                FileIO::File(file) => file.write(data.as_slice()),
                FileIO::Error(_) => unreachable!(),
                FileIO::Dynamic(file) => file.write(data.as_slice()),
                FileIO::Direction(_) => unreachable!(),
                FileIO::LocalSocket(socket) => {
                    <LocalSocket as FileIOTrait<T>>::write(socket, data.as_slice())
                }
            };
            if written < 0 {
                throw_err!(backend, emulator, Errno::EACCES);
            }
            total_written += written as usize;
            if written as usize != buf_len {
                break;
            }
        }

        if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
            println!(
                "syscall writev(fd={}, iov=0x{:x}, iovcnt={}) => {} from {}",
                fd, iov, iovcnt, total_written, from_module
            );
        }

        ret_u64!(backend, total_written as u64);
    } else {
        throw_err!(backend, emulator, Errno::EBADF);
    }
}

pub fn syscall_socket<T: Clone>(backend: &Backend<T>, emulator: &AndroidEmulator<T>) {
    let domain = Pf::from_u32(ldr_u32!(backend, X0));
    let typ = SockType::from_bits_truncate(ldr_u32!(backend, X1));
    let protocol = ldr_i32!(backend, X2);

    if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
        println!(
            "syscall socket(domain={:?}, type={:?}, protocol={})",
            domain, typ, protocol
        );
    }

    let file_system = &mut emulator.inner_mut().file_system;
    if domain == Pf::LOCAL {
        let fd = file_system.insert_file(FileIO::LocalSocket(LocalSocket::new()));
        ret_i32!(backend, fd);
        return;
    }

    if domain == Pf::INET || domain == Pf::INET6 {
        let fd = file_system.insert_file(FileIO::Dynamic(Box::new(InetSocket::new(typ))));
        ret_i32!(backend, fd);
        return;
    }

    warn!(
        "socket not supported: domain={:?}, type={:?}, protocol={}",
        domain, typ, protocol
    );
    throw_err!(backend, emulator, Errno::EINVAL);
}

pub fn syscall_connect<T: Clone>(backend: &Backend<T>, emulator: &AndroidEmulator<T>) {
    let sock_fd = ldr_i32!(backend, X0);
    let addr = ldr_u64!(backend, X1);
    let addr_len = ldr_i32!(backend, X2) as usize;
    let from = emulator.find_caller_name();

    if option_env!("PRINT_SYSCALL_LOG") == Some("1") || runtime_env_truthy("RNIDBG_TRACE_NET_IO") {
        println!(
            "syscall connect(sock_fd={}, addr=0x{:x}, addr_len={}, target={}) from {}",
            sock_fd,
            addr,
            addr_len,
            describe_sockaddr(backend, addr, addr_len),
            from
        );
    }

    let file_system = &mut emulator.inner_mut().file_system;
    if let Some(file) = file_system.get_file_mut(sock_fd) {
        match file {
            FileIO::LocalSocket(socket) => {
                let ret =
                    socket.connect(VMPointer::new(addr, 0, backend.clone()), addr_len, emulator);
                ret_i32!(backend, ret);
                return;
            }
            FileIO::Dynamic(file) => {
                let ret =
                    file.connect(VMPointer::new(addr, 0, backend.clone()), addr_len, emulator);
                ret_i32!(backend, ret);
                return;
            }
            _ => {
                throw_err!(backend, emulator, Errno::ENOTSOCK);
            }
        }
    } else {
        throw_err!(backend, emulator, Errno::EBADF);
    }

    unreachable!()
}

pub fn syscall_bind<T: Clone>(backend: &Backend<T>, emulator: &AndroidEmulator<T>) {
    let sock_fd = ldr_i32!(backend, X0);
    let addr = ldr_u64!(backend, X1);
    let addr_len = ldr_i32!(backend, X2) as usize;

    if option_env!("PRINT_SYSCALL_LOG") == Some("1") || runtime_env_truthy("RNIDBG_TRACE_NET_IO") {
        println!(
            "syscall bind(sock_fd={}, addr=0x{:x}, addr_len={}, target={})",
            sock_fd,
            addr,
            addr_len,
            describe_sockaddr(backend, addr, addr_len)
        );
    }

    let file_system = &mut emulator.inner_mut().file_system;
    if let Some(file) = file_system.get_file_mut(sock_fd) {
        match file {
            FileIO::LocalSocket(socket) => {
                let ret = socket.bind(VMPointer::new(addr, 0, backend.clone()), addr_len, emulator);
                ret_i32!(backend, ret);
                return;
            }
            FileIO::Dynamic(file) => {
                let ret = file.bind(VMPointer::new(addr, 0, backend.clone()), addr_len, emulator);
                ret_i32!(backend, ret);
                return;
            }
            _ => {
                throw_err!(backend, emulator, Errno::ENOTSOCK);
            }
        }
    } else {
        throw_err!(backend, emulator, Errno::EBADF);
    }

    unreachable!()
}

pub fn syscall_sendto<T: Clone>(backend: &Backend<T>, emulator: &AndroidEmulator<T>) {
    let sock_fd = ldr_i32!(backend, X0);
    let buf = ldr_u64!(backend, X1);
    let count = ldr_i32!(backend, X2) as usize;
    let flags = ldr_i32!(backend, X3);
    let addr = ldr_u64!(backend, X4);
    let addr_len = ldr_i32!(backend, X5) as usize;
    let data = backend.mem_read_as_vec(buf, count).unwrap();

    if option_env!("PRINT_SYSCALL_LOG") == Some("1") || runtime_env_truthy("RNIDBG_TRACE_NET_IO") {
        println!(
            "syscall sendto(sock_fd={}, buf=0x{:x}, count={}, flags=0x{:x}, addr=0x{:x}, addr_len={}, target={}, hex={})",
            sock_fd,
            buf,
            count,
            flags,
            addr,
            addr_len,
            describe_sockaddr(backend, addr, addr_len),
            hex_preview(data.as_slice(), 48)
        );
    }
    let file_system = &mut emulator.inner_mut().file_system;
    if let Some(file) = file_system.get_file_mut(sock_fd) {
        let written = match file {
            FileIO::Dynamic(file) => {
                if addr != 0 {
                    let ret =
                        file.connect(VMPointer::new(addr, 0, backend.clone()), addr_len, emulator);
                    if ret != 0 {
                        throw_err!(backend, emulator, Errno::EACCES);
                    }
                }
                file.write(data.as_slice())
            }
            FileIO::LocalSocket(socket) => {
                <LocalSocket as FileIOTrait<T>>::write(socket, data.as_slice())
            }
            _ => {
                throw_err!(backend, emulator, Errno::ENOTSOCK);
            }
        };

        if option_env!("PRINT_SYSCALL_LOG") == Some("1")
            || runtime_env_truthy("RNIDBG_TRACE_NET_IO")
        {
            println!("syscall sendto => {}", written);
        }

        if written == -1 {
            throw_err!(backend, emulator, Errno::EACCES);
        }
        ret_i32!(backend, written);
    } else {
        throw_err!(backend, emulator, Errno::EBADF);
    }
}

pub fn syscall_recvfrom<T: Clone>(backend: &Backend<T>, emulator: &AndroidEmulator<T>) {
    let sock_fd = ldr_i32!(backend, X0);
    let buf = ldr_u64!(backend, X1);
    let count = ldr_i32!(backend, X2) as usize;
    let flags = ldr_i32!(backend, X3);
    let addr = ldr_u64!(backend, X4);
    let addr_len_ptr = ldr_u64!(backend, X5);

    if option_env!("PRINT_SYSCALL_LOG") == Some("1") || runtime_env_truthy("RNIDBG_TRACE_NET_IO") {
        println!(
            "syscall recvfrom(sock_fd={}, buf=0x{:x}, count={}, flags=0x{:x}, addr=0x{:x}, addr_len_ptr=0x{:x})",
            sock_fd, buf, count, flags, addr, addr_len_ptr
        );
    }

    let file_system = &mut emulator.inner_mut().file_system;
    if let Some(file) = file_system.get_file_mut(sock_fd) {
        let mut peer_addr = None;
        let read = match file {
            FileIO::Dynamic(file) => {
                peer_addr = file.peer_addr();
                file.read(VMPointer::new(buf, 0, backend.clone()), count)
            }
            FileIO::LocalSocket(socket) => {
                peer_addr = <LocalSocket as FileIOTrait<T>>::peer_addr(socket);
                <LocalSocket as FileIOTrait<T>>::read(
                    socket,
                    VMPointer::new(buf, 0, backend.clone()),
                    count,
                )
            }
            _ => {
                throw_err!(backend, emulator, Errno::ENOTSOCK);
            }
        };

        if addr != 0 && addr_len_ptr != 0 {
            let socket_addr = peer_addr.unwrap_or(SocketAddr::from(([0, 0, 0, 0], 0)));
            write_socket_addr(backend, addr, addr_len_ptr, socket_addr);
        }

        if runtime_env_truthy("RNIDBG_BLACKBOX_OPEN_P2P") && read > 0 {
            let sniff_len = read.min(128);
            let sniff = backend.mem_read_as_vec(buf, sniff_len).unwrap_or_default();
            let relay_marker = sniff.starts_with(&[0x00, 0x49]) || sniff.starts_with(&[0x00, 0x87]);
            if relay_marker {
                info!(
                    "blackbox open_p2p stop on recvfrom fd={} len={} hex={}",
                    sock_fd,
                    read,
                    hex_preview(sniff.as_slice(), 64)
                );
                backend.reg_write_i64(RegisterARM64::X0, 0).unwrap();
                emulator.emu_stop(TaskStatus::X).unwrap();
                return;
            }
        }

        if option_env!("PRINT_SYSCALL_LOG") == Some("1")
            || runtime_env_truthy("RNIDBG_TRACE_NET_IO")
        {
            let preview_len = read.min(48);
            let preview = if preview_len > 0 {
                backend
                    .mem_read_as_vec(buf, preview_len)
                    .map(|bytes| hex_preview(bytes.as_slice(), 48))
                    .unwrap_or_else(|_| "<unreadable>".to_string())
            } else {
                String::new()
            };
            println!("syscall recvfrom => {} hex={}", read, preview);
        }

        ret_i32!(backend, read as i32);
    } else {
        throw_err!(backend, emulator, Errno::EBADF);
    }
}

pub fn syscall_getsockname<T: Clone>(backend: &Backend<T>, emulator: &AndroidEmulator<T>) {
    let sock_fd = ldr_i32!(backend, X0);
    let addr = ldr_u64!(backend, X1);
    let addr_len_ptr = ldr_u64!(backend, X2);

    if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
        println!(
            "syscall getsockname(sock_fd={}, addr=0x{:x}, addr_len_ptr=0x{:x})",
            sock_fd, addr, addr_len_ptr
        );
    }

    let file_system = &mut emulator.inner_mut().file_system;
    if let Some(file) = file_system.get_file_mut(sock_fd) {
        let local_addr = match file {
            FileIO::Dynamic(file) => file.local_addr(),
            FileIO::LocalSocket(socket) => <LocalSocket as FileIOTrait<T>>::local_addr(socket),
            _ => {
                throw_err!(backend, emulator, Errno::ENOTSOCK);
            }
        };
        let socket_addr = local_addr.unwrap_or(SocketAddr::from(([0, 0, 0, 0], 0)));
        write_socket_addr(backend, addr, addr_len_ptr, socket_addr);
        ret_i32!(backend, 0);
    } else {
        throw_err!(backend, emulator, Errno::EBADF);
    }
}

pub fn syscall_getpeername<T: Clone>(backend: &Backend<T>, emulator: &AndroidEmulator<T>) {
    let sock_fd = ldr_i32!(backend, X0);
    let addr = ldr_u64!(backend, X1);
    let addr_len_ptr = ldr_u64!(backend, X2);

    if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
        println!(
            "syscall getpeername(sock_fd={}, addr=0x{:x}, addr_len_ptr=0x{:x})",
            sock_fd, addr, addr_len_ptr
        );
    }

    let file_system = &mut emulator.inner_mut().file_system;
    if let Some(file) = file_system.get_file_mut(sock_fd) {
        let peer_addr = match file {
            FileIO::Dynamic(file) => file.peer_addr(),
            FileIO::LocalSocket(socket) => <LocalSocket as FileIOTrait<T>>::peer_addr(socket),
            _ => {
                throw_err!(backend, emulator, Errno::ENOTSOCK);
            }
        };
        let socket_addr = peer_addr.unwrap_or(SocketAddr::from(([0, 0, 0, 0], 0)));
        write_socket_addr(backend, addr, addr_len_ptr, socket_addr);
        ret_i32!(backend, 0);
    } else {
        throw_err!(backend, emulator, Errno::EBADF);
    }
}

pub fn syscall_setsockopt<T: Clone>(backend: &Backend<T>, emulator: &AndroidEmulator<T>) {
    let sock_fd = ldr_i32!(backend, X0);
    let level = ldr_i32!(backend, X1);
    let optname = ldr_i32!(backend, X2);
    let optval = ldr_u64!(backend, X3);
    let optlen = ldr_i32!(backend, X4);

    if option_env!("PRINT_SYSCALL_LOG") == Some("1") || runtime_env_truthy("RNIDBG_TRACE_NET_IO") {
        println!(
            "syscall setsockopt(sock_fd={}, level={}, optname={}, optval=0x{:x}, optlen={})",
            sock_fd, level, optname, optval, optlen
        );
    }

    let file_system = &mut emulator.inner_mut().file_system;
    if file_system.get_file_mut(sock_fd).is_none() {
        throw_err!(backend, emulator, Errno::EBADF);
    }
    ret_i32!(backend, 0);
}

pub fn syscall_getsockopt<T: Clone>(backend: &Backend<T>, emulator: &AndroidEmulator<T>) {
    let sock_fd = ldr_i32!(backend, X0);
    let level = ldr_i32!(backend, X1);
    let optname = ldr_i32!(backend, X2);
    let optval = ldr_u64!(backend, X3);
    let optlen_ptr = ldr_u64!(backend, X4);

    if option_env!("PRINT_SYSCALL_LOG") == Some("1") || runtime_env_truthy("RNIDBG_TRACE_NET_IO") {
        println!(
            "syscall getsockopt(sock_fd={}, level={}, optname={}, optval=0x{:x}, optlen_ptr=0x{:x})",
            sock_fd, level, optname, optval, optlen_ptr
        );
    }

    let file_system = &mut emulator.inner_mut().file_system;
    if file_system.get_file_mut(sock_fd).is_none() {
        throw_err!(backend, emulator, Errno::EBADF);
    }

    let requested_len = if optlen_ptr != 0 {
        backend.mem_read_v2::<u32>(optlen_ptr).unwrap_or(4)
    } else {
        4
    };
    let write_len = requested_len.min(4);
    if optval != 0 && write_len > 0 {
        let zeros = vec![0u8; write_len as usize];
        let _ = backend.mem_write(optval, zeros.as_slice());
    }
    if optlen_ptr != 0 {
        let _ = backend.mem_write(optlen_ptr, &write_len.to_le_bytes());
    }
    ret_i32!(backend, 0);
}

pub fn syscall_pipe2<T: Clone>(backend: &Backend<T>, emulator: &AndroidEmulator<T>) {
    let pipefd = ldr_u64!(backend, X0);
    let flags = ldr_i32!(backend, X1);

    if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
        println!("syscall pipe2(pipefd=0x{:x}, flags={})", pipefd, flags);
    }

    throw_err!(backend, emulator, Errno::ENFILE);
    /*
    let file_system = &mut emulator.inner_mut().file_system;
    let read_pipe = Pipe::new();
    let write_pipe = read_pipe.clone();*/
}

pub fn syscall_nr3264_fcntl<T: Clone>(backend: &Backend<T>, emulator: &AndroidEmulator<T>) {
    let fd = ldr_i32!(backend, X0);
    let cmd = ldr_i32!(backend, X1);
    let arg = ldr_u64!(backend, X2);

    if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
        info!("syscall fcntl(fd={}, cmd={}, arg=0x{:x})", fd, cmd, arg);
    }

    let file_system = &mut emulator.inner_mut().file_system;
    let oflags = file_system.get_file_mut(fd).map(|file| match file {
        FileIO::Bytes(file) => <_ as FileIOTrait<T>>::oflags(file),
        FileIO::File(file) => <_ as FileIOTrait<T>>::oflags(file),
        FileIO::Error(_) => OFlag::empty(),
        FileIO::Dynamic(file) => file.oflags(),
        FileIO::Direction(file) => <_ as FileIOTrait<T>>::oflags(file),
        FileIO::LocalSocket(socket) => <LocalSocket as FileIOTrait<T>>::oflags(socket),
    });

    match cmd {
        1 | 2 | 4 => ret_i32!(backend, 0), // F_GETFD/F_SETFD/F_SETFL
        3 => ret_i32!(backend, oflags.unwrap_or_else(OFlag::empty).bits() as i32), // F_GETFL
        _ => ret_i32!(backend, 0),
    }
}

pub fn syscall_epoll_create1<T: Clone>(backend: &Backend<T>, emulator: &AndroidEmulator<T>) {
    let flags = ldr_i32!(backend, X0);

    if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
        println!("syscall epoll_create1(flags=0x{:x})", flags);
    }

    let file_system = &mut emulator.inner_mut().file_system;
    let fd = file_system.insert_file(FileIO::Dynamic(Box::new(EpollInstance::new())));
    ret_i32!(backend, fd);
}

pub fn syscall_epoll_create<T: Clone>(backend: &Backend<T>, emulator: &AndroidEmulator<T>) {
    let _size = ldr_i32!(backend, X0);
    syscall_epoll_create1(backend, emulator);
}

pub fn syscall_epoll_ctl<T: Clone>(backend: &Backend<T>, emulator: &AndroidEmulator<T>) {
    let epfd = ldr_i32!(backend, X0);
    let op = ldr_i32!(backend, X1);
    let fd = ldr_i32!(backend, X2);
    let event = ldr_u64!(backend, X3);

    if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
        println!(
            "syscall epoll_ctl(epfd={}, op={}, fd={}, event=0x{:x})",
            epfd, op, fd, event
        );
    }

    let file_system = &mut emulator.inner_mut().file_system;
    if file_system.get_file_mut(epfd).is_none() || file_system.get_file_mut(fd).is_none() {
        throw_err!(backend, emulator, Errno::EBADF);
    }
    let mut events = 0u32;
    let mut data = fd as u64;
    if event != 0 {
        events = backend.mem_read_v2::<u32>(event).unwrap_or(0);
        data = backend.mem_read_v2::<u64>(event + 4).unwrap_or(fd as u64);
    }
    let Some(epoll_file) = file_system.get_file_mut(epfd) else {
        throw_err!(backend, emulator, Errno::EBADF);
    };
    let result = file_epoll_ctl(epoll_file, op, fd, events, data);
    if result < 0 {
        throw_err!(backend, emulator, Errno::EINVAL);
    }
    ret_i32!(backend, 0);
}

pub fn syscall_epoll_pwait<T: Clone>(backend: &Backend<T>, emulator: &AndroidEmulator<T>) {
    let epfd = ldr_i32!(backend, X0);
    let events = ldr_u64!(backend, X1);
    let maxevents = ldr_i32!(backend, X2);
    let timeout = ldr_i32!(backend, X3);
    let sigmask = ldr_u64!(backend, X4);
    let sigsetsize = ldr_i32!(backend, X5);

    if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
        println!(
            "syscall epoll_pwait(epfd={}, events=0x{:x}, maxevents={}, timeout={}, sigmask=0x{:x}, sigsetsize={})",
            epfd, events, maxevents, timeout, sigmask, sigsetsize
        );
    }

    let file_system = &mut emulator.inner_mut().file_system;
    if file_system.get_file_mut(epfd).is_none() {
        throw_err!(backend, emulator, Errno::EBADF);
    }
    let entries = {
        let Some(epoll_file) = file_system.get_file_mut(epfd) else {
            throw_err!(backend, emulator, Errno::EBADF);
        };
        file_epoll_entries(epoll_file)
    };
    let mut pollfds = Vec::new();
    let mut poll_meta = Vec::new();
    let mut immediate_events = Vec::new();
    for (fd, wanted_events, data) in entries.into_iter() {
        let Some(target_file) = file_system.get_file_mut(fd) else {
            continue;
        };
        if (wanted_events & EPOLLIN) != 0 && file_has_pending_read(target_file) {
            immediate_events.push((EPOLLIN, data));
            continue;
        }
        if (wanted_events & EPOLLOUT) != 0 && file_is_immediately_writable(target_file) {
            immediate_events.push((EPOLLOUT, data));
            continue;
        }
        let Some(raw_fd) = file_host_raw_fd(target_file) else {
            continue;
        };
        pollfds.push(libc::pollfd {
            fd: raw_fd,
            events: epoll_to_poll_mask(wanted_events),
            revents: 0,
        });
        poll_meta.push((wanted_events, data));
    }

    let maxevents = if maxevents <= 0 {
        0usize
    } else {
        maxevents as usize
    };
    if !immediate_events.is_empty() {
        let mut written = 0usize;
        for (ready_events, data) in immediate_events.into_iter() {
            if written >= maxevents {
                break;
            }
            write_epoll_event(backend, events + (written as u64 * 12), ready_events, data);
            written += 1;
        }
        ret_i32!(backend, written as i32);
    }

    if pollfds.is_empty() {
        if timeout > 0 {
            std::thread::sleep(std::time::Duration::from_millis(timeout as u64));
        }
        ret_i32!(backend, 0);
    }

    let ready = unsafe { libc::poll(pollfds.as_mut_ptr(), pollfds.len() as libc::nfds_t, timeout) };
    if ready < 0 {
        throw_err!(backend, emulator, Errno::EAGAIN);
    }
    if ready == 0 {
        ret_i32!(backend, 0);
    }

    let mut written = 0usize;
    for (index, pollfd) in pollfds.iter().enumerate() {
        if pollfd.revents == 0 || written >= maxevents {
            continue;
        }
        let (wanted_events, data) = poll_meta[index];
        let ready_events =
            poll_to_epoll_mask(pollfd.revents) & (wanted_events | EPOLLERR | EPOLLHUP);
        if ready_events == 0 {
            continue;
        }
        write_epoll_event(backend, events + (written as u64 * 12), ready_events, data);
        written += 1;
    }

    ret_i32!(backend, written as i32);
}

pub fn syscall_epoll_wait<T: Clone>(backend: &Backend<T>, emulator: &AndroidEmulator<T>) {
    syscall_epoll_pwait(backend, emulator);
}

pub fn syscall_pselect6<T: Clone>(backend: &Backend<T>, emulator: &AndroidEmulator<T>) {
    let nfds = ldr_i32!(backend, X0);
    let readfds = ldr_u64!(backend, X1);
    let writefds = ldr_u64!(backend, X2);
    let exceptfds = ldr_u64!(backend, X3);
    let timeout_ptr = ldr_u64!(backend, X4);
    let sigmask = ldr_u64!(backend, X5);

    if option_env!("PRINT_SYSCALL_LOG") == Some("1") || runtime_env_truthy("RNIDBG_TRACE_NET_IO") {
        println!(
            "syscall pselect6(nfds={}, readfds=0x{:x}, writefds=0x{:x}, exceptfds=0x{:x}, timeout=0x{:x}, sigmask=0x{:x})",
            nfds, readfds, writefds, exceptfds, timeout_ptr, sigmask
        );
    }

    let read_bits = read_fdset_bits(backend, readfds, nfds);
    let write_bits = read_fdset_bits(backend, writefds, nfds);
    let except_bits = read_fdset_bits(backend, exceptfds, nfds);

    let timeout_ms = if timeout_ptr != 0 {
        let timeout = backend
            .mem_read_v2::<Timespec>(timeout_ptr)
            .unwrap_or_default();
        let millis = timeout.tv_sec.saturating_mul(1000) + timeout.tv_nsec / 1_000_000;
        millis.clamp(-1, i32::MAX as i64) as i32
    } else {
        -1
    };
    let timeout_ms = runtime_env_u32("RNIDBG_PSELECT_MAX_MS")
        .map(|cap| {
            let cap = cap.min(i32::MAX as u32) as i32;
            if timeout_ms < 0 || timeout_ms > cap {
                cap
            } else {
                timeout_ms
            }
        })
        .unwrap_or(timeout_ms);

    let mut pollfds = Vec::new();
    let mut poll_meta = Vec::new();
    let mut pending_read = vec![false; nfds.max(0) as usize];
    let mut pending_write = vec![false; nfds.max(0) as usize];
    {
        let file_system = &mut emulator.inner_mut().file_system;
        for guest_fd in 0..(nfds.max(0) as usize) {
            let want_read = read_bits.get(guest_fd).copied().unwrap_or(false);
            let want_write = write_bits.get(guest_fd).copied().unwrap_or(false);
            let want_except = except_bits.get(guest_fd).copied().unwrap_or(false);
            if !want_read && !want_write && !want_except {
                continue;
            }
            let Some(file) = file_system.get_file_mut(guest_fd as i32) else {
                continue;
            };
            if want_read && file_has_pending_read(file) {
                pending_read[guest_fd] = true;
            }
            if want_write && file_is_immediately_writable(file) {
                pending_write[guest_fd] = true;
            }
            if pending_read[guest_fd] || pending_write[guest_fd] {
                continue;
            }
            let Some(raw_fd) = file_host_raw_fd(file) else {
                continue;
            };
            let mut events: i16 = 0;
            if want_read {
                events |= libc::POLLIN;
            }
            if want_write {
                events |= libc::POLLOUT;
            }
            if want_except {
                events |= libc::POLLPRI;
            }
            pollfds.push(libc::pollfd {
                fd: raw_fd,
                events,
                revents: 0,
            });
            poll_meta.push((guest_fd, want_read, want_write, want_except));
        }
    }

    let pending_count = pending_read
        .iter()
        .zip(pending_write.iter())
        .filter(|(read, write)| **read || **write)
        .count();
    if pending_count > 0 {
        if option_env!("PRINT_SYSCALL_LOG") == Some("1")
            || runtime_env_truthy("RNIDBG_TRACE_NET_IO")
        {
            println!("syscall pselect6 => {} (pending)", pending_count);
        }
        write_fdset_bits(backend, readfds, nfds, &pending_read);
        write_fdset_bits(backend, writefds, nfds, &pending_write);
        write_fdset_bits(backend, exceptfds, nfds, &vec![false; nfds.max(0) as usize]);
        ret_i32!(backend, pending_count as i32);
    }

    if pollfds.is_empty() {
        write_fdset_bits(backend, readfds, nfds, &pending_read);
        write_fdset_bits(backend, writefds, nfds, &pending_write);
        write_fdset_bits(backend, exceptfds, nfds, &vec![false; nfds.max(0) as usize]);
        if timeout_ms > 0 {
            std::thread::sleep(std::time::Duration::from_millis(timeout_ms as u64));
        }
        if option_env!("PRINT_SYSCALL_LOG") == Some("1")
            || runtime_env_truthy("RNIDBG_TRACE_NET_IO")
        {
            println!("syscall pselect6 => 0 (no pollfds)");
        }
        ret_i32!(backend, 0);
    }

    let ready = unsafe {
        libc::poll(
            pollfds.as_mut_ptr(),
            pollfds.len() as libc::nfds_t,
            timeout_ms,
        )
    };
    if ready < 0 {
        throw_err!(backend, emulator, Errno::EAGAIN);
    }

    let mut ready_read = pending_read;
    let mut ready_write = pending_write;
    let mut ready_except = vec![false; nfds.max(0) as usize];
    let mut ready_any = ready_read
        .iter()
        .zip(ready_write.iter())
        .map(|(read, write)| *read || *write)
        .collect::<Vec<_>>();

    for (index, pollfd) in pollfds.iter().enumerate() {
        let (guest_fd, want_read, want_write, want_except) = poll_meta[index];
        let revents = pollfd.revents;
        if revents == 0 {
            continue;
        }
        if want_read && (revents & (libc::POLLIN | libc::POLLHUP | libc::POLLERR)) != 0 {
            ready_read[guest_fd] = true;
            ready_any[guest_fd] = true;
        }
        if want_write && (revents & (libc::POLLOUT | libc::POLLERR)) != 0 {
            ready_write[guest_fd] = true;
            ready_any[guest_fd] = true;
        }
        if want_except && (revents & (libc::POLLPRI | libc::POLLERR)) != 0 {
            ready_except[guest_fd] = true;
            ready_any[guest_fd] = true;
        }
    }

    write_fdset_bits(backend, readfds, nfds, &ready_read);
    write_fdset_bits(backend, writefds, nfds, &ready_write);
    write_fdset_bits(backend, exceptfds, nfds, &ready_except);
    let ready_count = ready_any.into_iter().filter(|value| *value).count() as i32;
    if option_env!("PRINT_SYSCALL_LOG") == Some("1") || runtime_env_truthy("RNIDBG_TRACE_NET_IO") {
        println!("syscall pselect6 => {}", ready_count);
    }

    ret_i32!(backend, ready_count);
}

pub fn syscall_tgkill<T: Clone>(backend: &Backend<T>, _emulator: &AndroidEmulator<T>) {
    let tgid = ldr_i32!(backend, X0);
    let tid = ldr_i32!(backend, X1);
    let sig = ldr_i32!(backend, X2);
    if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
        println!(
            "syscall tgkill(tgid={}, tid={}, sig={}) => 0",
            tgid, tid, sig
        );
    }
    ret_i32!(backend, 0);
}

pub fn syscall_rt_sigqueueinfo<T: Clone>(backend: &Backend<T>, _emulator: &AndroidEmulator<T>) {
    let tgid = ldr_i32!(backend, X0);
    let tid = ldr_i32!(backend, X1);
    let sig = ldr_i32!(backend, X2);
    let uinfo = ldr_u64!(backend, X3);
    if option_env!("PRINT_SYSCALL_LOG") == Some("1") || runtime_env_truthy("RNIDBG_TRACE_THREADS")
    {
        eprintln!(
            "syscall rt_sigqueueinfo(tgid={}, tid={}, sig={}, uinfo=0x{:x}) => 0",
            tgid, tid, sig, uinfo
        );
    }
    ret_i32!(backend, 0);
}

pub fn syscall_uname<T: Clone>(backend: &Backend<T>, _emulator: &AndroidEmulator<T>) {
    let buf = ldr_u64!(backend, X0);

    if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
        println!("syscall uname(buf=0x{:x})", buf);
    }

    let fields = [
        "Linux",
        "localhost",
        "4.9.186-android",
        "#1 SMP PREEMPT Android",
        "aarch64",
        "localdomain",
    ];
    let mut utsname = vec![0u8; 65 * fields.len()];
    for (index, field) in fields.iter().enumerate() {
        let offset = index * 65;
        let bytes = field.as_bytes();
        let len = bytes.len().min(64);
        utsname[offset..offset + len].copy_from_slice(&bytes[..len]);
    }
    backend.mem_write(buf, utsname.as_slice()).unwrap();
    ret_i32!(backend, 0);
}

pub fn syscall_sched_setparam<T: Clone>(backend: &Backend<T>, _emulator: &AndroidEmulator<T>) {
    ret_i32!(backend, 0);
}

pub fn syscall_sched_setscheduler<T: Clone>(backend: &Backend<T>, _emulator: &AndroidEmulator<T>) {
    ret_i32!(backend, 0);
}

pub fn syscall_sched_getscheduler<T: Clone>(backend: &Backend<T>, _emulator: &AndroidEmulator<T>) {
    ret_i32!(backend, 0);
}

pub fn syscall_sched_getparam<T: Clone>(backend: &Backend<T>, _emulator: &AndroidEmulator<T>) {
    let param = ldr_u64!(backend, X1);
    if param != 0 {
        let _ = backend.mem_write(param, &0i32.to_le_bytes());
    }
    ret_i32!(backend, 0);
}

pub fn syscall_sched_setaffinity<T: Clone>(backend: &Backend<T>, _emulator: &AndroidEmulator<T>) {
    ret_i32!(backend, 0);
}

pub fn syscall_sched_getaffinity<T: Clone>(backend: &Backend<T>, _emulator: &AndroidEmulator<T>) {
    let cpusetsize = ldr_u64!(backend, X1) as usize;
    let mask = ldr_u64!(backend, X2);
    if mask != 0 && cpusetsize > 0 {
        let mut buf = vec![0u8; cpusetsize];
        buf[0] = 1;
        let _ = backend.mem_write(mask, &buf);
    }
    ret_i32!(backend, cpusetsize as i32);
}

pub fn syscall_sched_yield<T: Clone>(backend: &Backend<T>, _emulator: &AndroidEmulator<T>) {
    ret_i32!(backend, 0);
}

pub fn syscall_sched_get_priority_max<T: Clone>(
    backend: &Backend<T>,
    _emulator: &AndroidEmulator<T>,
) {
    ret_i32!(backend, 0);
}

pub fn syscall_sched_get_priority_min<T: Clone>(
    backend: &Backend<T>,
    _emulator: &AndroidEmulator<T>,
) {
    ret_i32!(backend, 0);
}

pub fn syscall_sched_rr_get_interval<T: Clone>(
    backend: &Backend<T>,
    _emulator: &AndroidEmulator<T>,
) {
    let tp = ldr_u64!(backend, X1);
    if tp != 0 {
        let zeros = [0u8; std::mem::size_of::<Timespec>()];
        let _ = backend.mem_write(tp, &zeros);
    }
    ret_i32!(backend, 0);
}

pub fn syscall_sched_setattr<T: Clone>(backend: &Backend<T>, _emulator: &AndroidEmulator<T>) {
    ret_i32!(backend, 0);
}

pub fn syscall_sched_getattr<T: Clone>(backend: &Backend<T>, _emulator: &AndroidEmulator<T>) {
    let size = ldr_u32!(backend, X2) as usize;
    let attr = ldr_u64!(backend, X1);
    if attr != 0 && size > 0 {
        let zeros = vec![0u8; size];
        let _ = backend.mem_write(attr, &zeros);
    }
    ret_i32!(backend, 0);
}

pub fn syscall_nanosleep<T: Clone>(backend: &Backend<T>, _emulator: &AndroidEmulator<T>) {
    let req = ldr_u64!(backend, X0);
    let rem = ldr_u64!(backend, X1);
    if req != 0 {
        let mut buf = [0u8; std::mem::size_of::<Timespec>()];
        if backend.mem_read(req, &mut buf).is_ok() {
            let spec: &Timespec = unsafe { &*(buf.as_ptr() as *const Timespec) };
            let millis = (spec.tv_sec.max(0) as u64)
                .saturating_mul(1000)
                .saturating_add((spec.tv_nsec.max(0) as u64) / 1_000_000);
            if millis > 0 {
                std::thread::sleep(std::time::Duration::from_millis(millis.min(50)));
            }
        }
    }
    if rem != 0 {
        let zeros = [0u8; std::mem::size_of::<Timespec>()];
        let _ = backend.mem_write(rem, &zeros);
    }
    ret_i32!(backend, 0);
}

pub fn syscall_clock_nanosleep<T: Clone>(backend: &Backend<T>, _emulator: &AndroidEmulator<T>) {
    let req = ldr_u64!(backend, X2);
    let rem = ldr_u64!(backend, X3);
    if req != 0 {
        let mut buf = [0u8; std::mem::size_of::<Timespec>()];
        if backend.mem_read(req, &mut buf).is_ok() {
            let spec: &Timespec = unsafe { &*(buf.as_ptr() as *const Timespec) };
            let millis = (spec.tv_sec.max(0) as u64)
                .saturating_mul(1000)
                .saturating_add((spec.tv_nsec.max(0) as u64) / 1_000_000);
            if millis > 0 {
                std::thread::sleep(std::time::Duration::from_millis(millis.min(50)));
            }
        }
    }
    if rem != 0 {
        let zeros = [0u8; std::mem::size_of::<Timespec>()];
        let _ = backend.mem_write(rem, &zeros);
    }
    ret_i32!(backend, 0);
}

#[inline]
fn open<T: Clone>(
    emulator: &AndroidEmulator<T>,
    path: &str,
    flags: OFlag,
    mode: i32,
    from_module: &str,
) -> (i32, i32) {
    if path == "/dev/__properties__" {
        let errno: i32 = Errno::ENOENT.into();
        return (-errno, errno);
    }

    let file_system = &mut emulator.inner_mut().file_system;
    if path == "/dev/urandom" {
        let fd = file_system.insert_file(FileIO::Dynamic(Box::new(URandom::new(
            path,
            flags.bits(),
            0,
            StMode::SYSTEM_FILE,
        ))));
        return (fd, 0);
    } else if path == "/proc/meminfo" {
        let fd =
            file_system.insert_file(FileIO::Dynamic(Box::new(Meminfo::new(path, flags.bits()))));
        return (fd, 0);
    } else if path == "/proc/cpuinfo" {
        let fd =
            file_system.insert_file(FileIO::Dynamic(Box::new(Cpuinfo::new(path, flags.bits()))));
        return (fd, 0);
    } else if path == "/proc/sys/kernel/random/boot_id" {
        let fd = file_system.insert_file(FileIO::Dynamic(Box::new(RandomBootId::new(
            path,
            flags.bits(),
        ))));
        return (fd, 0);
    }

    if path == "/proc/stat" {
        return if from_module == "libc.so" {
            let mut buf = BytesMut::new();
            buf.write_str("cpu 9160 11352 15848 9160 11352 1584 80 0 0 0\n")
                .unwrap();
            for i in 0..8 {
                buf.write_str(format!("cpu{} 1145 1419 1981 1145 1419 198 10 0 0 0\n", i).as_str())
                    .unwrap();
            }
            let bytes_file = ByteArrayFileIO::new(
                buf.freeze().to_vec(),
                path.to_string(),
                0,
                flags.bits(),
                StMode::SYSTEM_FILE,
            );
            let fd = file_system.insert_file(FileIO::Bytes(bytes_file));
            (fd, 0)
        } else {
            let errno: i32 = Errno::EPERM.into();
            (-errno, errno)
        };
    }

    if let Some(ref resolver) = file_system.file_resolver {
        if let Some(file) = resolver(file_system, path, flags, mode) {
            return match file {
                FileIO::Bytes(file) => {
                    let fd = file_system.insert_file(FileIO::Bytes(file));
                    (fd, 0)
                }
                FileIO::Error(errno) => (-errno, errno),
                FileIO::File(file) => {
                    let fd = file_system.insert_file(FileIO::File(file));
                    (fd, 0)
                }
                FileIO::Dynamic(file) => {
                    let fd = file_system.insert_file(FileIO::Dynamic(file));
                    (fd, 0)
                }
                FileIO::Direction(dir) => {
                    let fd = file_system.insert_file(FileIO::Direction(dir));
                    (fd, 0)
                }
                FileIO::LocalSocket(_) => unreachable!(),
            };
        }
    }

    if path == "/proc/self/maps" {
        let fd = file_system.insert_file(FileIO::Dynamic(Box::new(Maps::new(path, flags.bits()))));
        return (fd, 0);
    }

    let errno: i32 = Errno::ENOENT.into();
    (-errno, errno)
}
