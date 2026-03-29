use crate::emulator::{AndroidEmulator, VMPointer};
use crate::linux::errno::Errno;
use crate::linux::file_system::{FileIO, FileIOTrait, SeekResult, StMode};
use crate::linux::structs::socket::Pf;
use crate::linux::structs::OFlag;
use log::warn;
use std::ffi::{CStr, CString};
use std::ptr;
use std::slice;

pub struct LocalSocket {
    path: String,
    pending_read: Vec<u8>,
    pending_write: Vec<u8>,
}

impl LocalSocket {
    pub fn new() -> Self {
        LocalSocket {
            path: "local:unconnected".to_string(),
            pending_read: Vec::new(),
            pending_write: Vec::new(),
        }
    }

    pub fn has_pending_read(&self) -> bool {
        !self.pending_read.is_empty()
    }

    fn queue_dnsproxyd_request(&mut self, buf: &[u8]) {
        self.pending_write.extend_from_slice(buf);
        loop {
            let Some(end) = self.pending_write.iter().position(|byte| *byte == 0) else {
                break;
            };
            let frame = self.pending_write.drain(..=end).collect::<Vec<_>>();
            let request = &frame[..frame.len().saturating_sub(1)];
            let response = self
                .handle_dnsproxyd_request(request)
                .unwrap_or_else(|_| Self::dnsproxyd_error_response(400, libc::EIO));
            if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
                println!(
                    "LocalSocket::dnsproxyd queued response len={} for request={}",
                    response.len(),
                    String::from_utf8_lossy(request)
                );
            }
            self.pending_read.extend_from_slice(response.as_slice());
        }
    }

    fn handle_dnsproxyd_request(&self, request: &[u8]) -> Result<Vec<u8>, ()> {
        let request = std::str::from_utf8(request).map_err(|_| ())?;
        let mut parts = request.split_whitespace();
        let command = parts.next().ok_or(())?;
        match command {
            "getaddrinfo" => {
                let hostname = parts.next().ok_or(())?;
                let servname = parts.next().ok_or(())?;
                let ai_flags = parts.next().ok_or(())?.parse::<i32>().map_err(|_| ())?;
                let ai_family = parts.next().ok_or(())?.parse::<i32>().map_err(|_| ())?;
                let ai_socktype = parts.next().ok_or(())?.parse::<i32>().map_err(|_| ())?;
                let ai_protocol = parts.next().ok_or(())?.parse::<i32>().map_err(|_| ())?;
                let _netid = parts.next().ok_or(())?;
                if parts.next().is_some() {
                    return Err(());
                }
                Self::dnsproxyd_getaddrinfo_response(
                    hostname,
                    servname,
                    ai_flags,
                    ai_family,
                    ai_socktype,
                    ai_protocol,
                )
            }
            "getdnsnetid" => {
                let netid = parts.next().ok_or(())?.parse::<i32>().map_err(|_| ())?;
                if parts.next().is_some() {
                    return Err(());
                }
                Ok(Self::dnsproxyd_code_and_be32_response(222, netid))
            }
            "gethostbyname" => {
                let _netid = parts.next().ok_or(())?;
                let hostname = parts.next().ok_or(())?;
                let af = parts.next().ok_or(())?.parse::<i32>().map_err(|_| ())?;
                if parts.next().is_some() {
                    return Err(());
                }
                Self::dnsproxyd_gethostbyname_response(hostname, af)
            }
            other => {
                warn!("LocalSocket::dnsproxyd unsupported command: {}", other);
                Ok(Self::dnsproxyd_error_response(400, libc::ENOSYS))
            }
        }
    }

    fn dnsproxyd_code_and_be32_response(code: i32, value: i32) -> Vec<u8> {
        let mut response = Vec::with_capacity(8);
        response.extend_from_slice(format!("{code:03}\0").as_bytes());
        response.extend_from_slice(&(value as u32).to_be_bytes());
        response
    }

    fn dnsproxyd_error_response(code: i32, value: i32) -> Vec<u8> {
        Self::dnsproxyd_code_and_be32_response(code, value)
    }

    fn dnsproxyd_getaddrinfo_response(
        hostname: &str,
        servname: &str,
        ai_flags: i32,
        ai_family: i32,
        ai_socktype: i32,
        ai_protocol: i32,
    ) -> Result<Vec<u8>, ()> {
        let host_cstr = if hostname == "^" {
            None
        } else {
            Some(CString::new(hostname).map_err(|_| ())?)
        };
        let service_cstr = if servname == "^" {
            None
        } else {
            Some(CString::new(servname).map_err(|_| ())?)
        };

        let mut hints = libc::addrinfo {
            ai_flags: 0,
            ai_family: 0,
            ai_socktype: 0,
            ai_protocol: 0,
            ai_addrlen: 0,
            ai_addr: ptr::null_mut(),
            ai_canonname: ptr::null_mut(),
            ai_next: ptr::null_mut(),
        };
        let hints_ptr = if ai_flags != -1 || ai_family != -1 || ai_socktype != -1 || ai_protocol != -1 {
            hints.ai_flags = if ai_flags == -1 { 0 } else { ai_flags };
            hints.ai_family = if ai_family == -1 { 0 } else { ai_family };
            hints.ai_socktype = if ai_socktype == -1 { 0 } else { ai_socktype };
            hints.ai_protocol = if ai_protocol == -1 { 0 } else { ai_protocol };
            &hints as *const libc::addrinfo
        } else {
            ptr::null()
        };

        let mut result: *mut libc::addrinfo = ptr::null_mut();
        let rv = unsafe {
            libc::getaddrinfo(
                host_cstr.as_ref().map_or(ptr::null(), |value| value.as_ptr()),
                service_cstr.as_ref().map_or(ptr::null(), |value| value.as_ptr()),
                hints_ptr,
                &mut result,
            )
        };
        if rv != 0 {
            return Ok(Self::dnsproxyd_error_response(401, rv));
        }

        let canon_fallback = if hostname == "^" {
            None
        } else {
            Some(format!("{hostname}\0").into_bytes())
        };
        let mut response = Vec::new();
        response.extend_from_slice(b"222\0");
        let mut current = result;
        let mut emitted = 0usize;
        while !current.is_null() {
            let ai = unsafe { &*current };
            if ai.ai_family != libc::AF_INET {
                current = ai.ai_next;
                continue;
            }
            response.extend_from_slice(&1u32.to_be_bytes());
            response.extend_from_slice(&(ai.ai_flags as u32).to_be_bytes());
            response.extend_from_slice(&(ai.ai_family as u32).to_be_bytes());
            response.extend_from_slice(&(ai.ai_socktype as u32).to_be_bytes());
            response.extend_from_slice(&(ai.ai_protocol as u32).to_be_bytes());

            let addr_len = ai.ai_addrlen as usize;
            response.extend_from_slice(&(addr_len as u32).to_be_bytes());
            if addr_len > 0 && !ai.ai_addr.is_null() {
                let addr_bytes = unsafe { slice::from_raw_parts(ai.ai_addr as *const u8, addr_len) };
                response.extend_from_slice(addr_bytes);
            }

            if !ai.ai_canonname.is_null() {
                let canon = unsafe { CStr::from_ptr(ai.ai_canonname) }.to_bytes_with_nul();
                response.extend_from_slice(&(canon.len() as u32).to_be_bytes());
                response.extend_from_slice(canon);
            } else if emitted == 0 {
                if let Some(canon) = canon_fallback.as_ref() {
                    response.extend_from_slice(&(canon.len() as u32).to_be_bytes());
                    response.extend_from_slice(canon);
                } else {
                    response.extend_from_slice(&0u32.to_be_bytes());
                }
            } else {
                response.extend_from_slice(&0u32.to_be_bytes());
            }

            emitted += 1;
            if emitted >= 1 {
                break;
            }
            current = ai.ai_next;
        }
        response.extend_from_slice(&0u32.to_be_bytes());
        unsafe {
            libc::freeaddrinfo(result);
        }
        Ok(response)
    }

    fn dnsproxyd_gethostbyname_response(hostname: &str, af: i32) -> Result<Vec<u8>, ()> {
        let host_cstr = if hostname == "^" {
            None
        } else {
            Some(CString::new(hostname).map_err(|_| ())?)
        };
        let mut hints = libc::addrinfo {
            ai_flags: 0,
            ai_family: if af == -1 { 0 } else { af },
            ai_socktype: 0,
            ai_protocol: 0,
            ai_addrlen: 0,
            ai_addr: ptr::null_mut(),
            ai_canonname: ptr::null_mut(),
            ai_next: ptr::null_mut(),
        };
        let mut result: *mut libc::addrinfo = ptr::null_mut();
        let rv = unsafe {
            libc::getaddrinfo(
                host_cstr.as_ref().map_or(ptr::null(), |value| value.as_ptr()),
                ptr::null(),
                &hints as *const libc::addrinfo,
                &mut result,
            )
        };
        if rv != 0 {
            return Ok(Self::dnsproxyd_error_response(401, rv));
        }

        let mut canon_name = Vec::new();
        let mut addr_type = 0i32;
        let mut addr_len = 0usize;
        let mut addrs = Vec::<Vec<u8>>::new();
        let mut current = result;
        while !current.is_null() {
            let ai = unsafe { &*current };
            if canon_name.is_empty() && !ai.ai_canonname.is_null() {
                canon_name = unsafe { CStr::from_ptr(ai.ai_canonname) }
                    .to_bytes_with_nul()
                    .to_vec();
            }
            if !ai.ai_addr.is_null() {
                match ai.ai_family {
                    libc::AF_INET => {
                        let addr = unsafe { &*(ai.ai_addr as *const libc::sockaddr_in) };
                        addr_type = libc::AF_INET;
                        addr_len = 4;
                        addrs.push(addr.sin_addr.s_addr.to_be_bytes().to_vec());
                    }
                    libc::AF_INET6 => {
                        let addr = unsafe { &*(ai.ai_addr as *const libc::sockaddr_in6) };
                        addr_type = libc::AF_INET6;
                        addr_len = 16;
                        addrs.push(addr.sin6_addr.s6_addr.to_vec());
                    }
                    _ => {}
                }
            }
            current = ai.ai_next;
        }
        unsafe {
            libc::freeaddrinfo(result);
        }

        let mut response = Vec::new();
        response.extend_from_slice(b"222\0");
        if canon_name.is_empty() {
            response.extend_from_slice(&0u32.to_be_bytes());
        } else {
            response.extend_from_slice(&(canon_name.len() as u32).to_be_bytes());
            response.extend_from_slice(canon_name.as_slice());
        }
        response.extend_from_slice(&0u32.to_be_bytes());
        response.extend_from_slice(&(addr_type as u32).to_be_bytes());
        response.extend_from_slice(&(addr_len as u32).to_be_bytes());
        for addr in addrs {
            response.extend_from_slice(&(addr.len() as u32).to_be_bytes());
            response.extend_from_slice(addr.as_slice());
        }
        response.extend_from_slice(&0u32.to_be_bytes());
        Ok(response)
    }
}

impl<T: Clone> FileIOTrait<T> for LocalSocket {
    fn connect(
        &mut self,
        addr: VMPointer<T>,
        addr_len: usize,
        emulator: &AndroidEmulator<T>,
    ) -> i32 {
        let sa_family = emulator.backend.mem_read_v2::<u16>(addr.addr).unwrap();
        if sa_family != (Pf::LOCAL as u32) as u16 {
            emulator.set_errno(Errno::EINVAL.as_i32()).unwrap();
            return Errno::EINVAL.as_i32();
        }

        let path = emulator.backend.mem_read_c_string(addr.addr + 2).unwrap();
        self.path = path.clone();
        self.pending_read.clear();
        self.pending_write.clear();
        if path == "/dev/socket/logdw" || path == "/dev/socket/dnsproxyd" {
            if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
                println!("LocalSocket::connect allowed: path={}", path);
            }
            return 0;
        }
        warn!("LocalSocket::connect denied: path={}", path);
        Errno::EACCES.as_i32()
    }

    fn close(&mut self) {
        self.pending_read.clear();
        self.pending_write.clear();
    }

    fn read(&mut self, buf: VMPointer<T>, count: usize) -> usize {
        if !self.pending_read.is_empty() {
            let size = self.pending_read.len().min(count);
            let bytes = self.pending_read.drain(..size).collect::<Vec<_>>();
            let _ = buf.write_bytes(bytes.into());
            return size;
        }
        0
    }

    fn pread(&mut self, buf: VMPointer<T>, count: usize, offset: usize) -> usize {
        self.read(buf, count)
    }

    fn write(&mut self, buf: &[u8]) -> i32 {
        if self.path == "/dev/socket/dnsproxyd" {
            if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
                println!(
                    "LocalSocket::write path={} len={} text={:?}",
                    self.path,
                    buf.len(),
                    String::from_utf8_lossy(buf)
                );
            }
            self.queue_dnsproxyd_request(buf);
            return buf.len() as i32;
        }
        if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
            let hex = buf
                .iter()
                .take(64)
                .map(|byte| format!("{byte:02x}"))
                .collect::<String>();
            println!(
                "LocalSocket::write path={} len={} hex={}",
                self.path,
                buf.len(),
                hex
            );
        }
        buf.len() as i32
    }

    fn lseek(&mut self, offset: i64, whence: i32) -> SeekResult {
        SeekResult::Ok(0)
    }

    fn path(&self) -> &str {
        &self.path
    }

    fn oflags(&self) -> OFlag {
        OFlag::O_RDWR
    }

    fn st_mode(&self) -> StMode {
        StMode::S_IFSOCK | StMode::S_IRUSR | StMode::S_IWUSR
    }

    fn uid(&self) -> i32 {
        0
    }

    fn len(&self) -> usize {
        self.pending_read.len()
    }

    fn to_vec(&mut self) -> Vec<u8> {
        self.pending_read.clone()
    }

    fn has_pending_read(&self) -> bool {
        !self.pending_read.is_empty()
    }
}
