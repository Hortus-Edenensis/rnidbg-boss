use crate::emulator::AndroidEmulator;
use crate::linux::file_system::{FileIOTrait, SeekResult, StMode};
use crate::linux::structs::OFlag;
use crate::linux::structs::socket::SockType;
use crate::pointer::VMPointer;
use std::collections::BTreeSet;
use std::fs;
use std::io::{Read, Write};
use std::net::{
    IpAddr, Ipv4Addr, Ipv6Addr, Shutdown, SocketAddr, SocketAddrV4, SocketAddrV6, TcpStream,
    ToSocketAddrs, UdpSocket,
};
use std::os::fd::AsRawFd;
use std::time::Duration;

enum InetSocketInner {
    Stream(TcpStream),
    Dgram(UdpSocket),
}

pub struct InetSocket {
    sock_type: SockType,
    inner: Option<InetSocketInner>,
    path: String,
    pending_read: Option<Vec<u8>>,
}

impl InetSocket {
    pub fn new(sock_type: SockType) -> Self {
        let path = format!("inet:{sock_type:?}");
        Self {
            sock_type,
            inner: None,
            path,
            pending_read: None,
        }
    }

    fn read_sockaddr<T: Clone>(addr: VMPointer<T>, addr_len: usize) -> Option<SocketAddr> {
        if addr_len < 8 {
            return None;
        }
        let data = addr.read_bytes_with_len(addr_len).ok()?;
        if data.len() < 8 {
            return None;
        }
        let family = u16::from_le_bytes([data[0], data[1]]);
        if family == 2 {
            let port = u16::from_be_bytes([data[2], data[3]]);
            let ip = Ipv4Addr::new(data[4], data[5], data[6], data[7]);
            return Some(SocketAddr::V4(SocketAddrV4::new(ip, port)));
        }

        if family == 10 && data.len() >= 28 {
            let port = u16::from_be_bytes([data[2], data[3]]);
            let flowinfo = u32::from_be_bytes([data[4], data[5], data[6], data[7]]);
            let ip = Ipv6Addr::from([
                data[8], data[9], data[10], data[11], data[12], data[13], data[14], data[15],
                data[16], data[17], data[18], data[19], data[20], data[21], data[22], data[23],
            ]);
            let scope_id = u32::from_le_bytes([data[24], data[25], data[26], data[27]]);
            return Some(SocketAddr::V6(SocketAddrV6::new(
                ip, port, flowinfo, scope_id,
            )));
        }

        None
    }

    fn normalize_dns_name(name: &str) -> String {
        let trimmed = name.trim_end_matches('.');
        let stripped = trimmed
            .strip_prefix("https://")
            .or_else(|| trimmed.strip_prefix("http://"))
            .unwrap_or(trimmed);
        stripped.split('/').next().unwrap_or(stripped).to_string()
    }

    fn dns_upstream(sockaddr: SocketAddr) -> SocketAddr {
        if sockaddr.port() != 53 || !sockaddr.ip().is_unspecified() {
            return sockaddr;
        }
        if let Ok(value) = std::env::var("RNIDBG_DNS_SERVER") {
            if let Ok(addr) = value.parse::<IpAddr>() {
                return SocketAddr::new(addr, 53);
            }
        }
        if let Ok(resolv_conf) = fs::read_to_string("/etc/resolv.conf") {
            for line in resolv_conf.lines() {
                let line = line.trim();
                if !line.starts_with("nameserver ") {
                    continue;
                }
                if let Some(addr) = line.split_whitespace().nth(1) {
                    if let Ok(ip) = addr.parse::<IpAddr>() {
                        return SocketAddr::new(ip, 53);
                    }
                }
            }
        }
        sockaddr
    }

    fn parse_dns_query(buf: &[u8]) -> Option<(String, u16, usize)> {
        if buf.len() < 17 {
            return None;
        }
        let qdcount = u16::from_be_bytes([buf[4], buf[5]]);
        if qdcount == 0 {
            return None;
        }
        let mut offset = 12usize;
        let mut labels = Vec::new();
        loop {
            let len = *buf.get(offset)? as usize;
            offset += 1;
            if len == 0 {
                break;
            }
            let label = buf.get(offset..offset + len)?;
            labels.push(String::from_utf8_lossy(label).to_string());
            offset += len;
        }
        let qtype = u16::from_be_bytes([*buf.get(offset)?, *buf.get(offset + 1)?]);
        offset += 4;
        Some((labels.join("."), qtype, offset))
    }

    fn resolve_dns_answers(name: &str, qtype: u16) -> Vec<IpAddr> {
        let normalized = Self::normalize_dns_name(name);
        let Ok(iter) = (normalized.as_str(), 0).to_socket_addrs() else {
            return Vec::new();
        };
        let mut unique = BTreeSet::new();
        for addr in iter {
            unique.insert(addr.ip());
        }
        unique
            .into_iter()
            .filter(|ip| match qtype {
                1 => ip.is_ipv4(),
                28 => ip.is_ipv6(),
                _ => false,
            })
            .collect()
    }

    fn build_dns_response(query: &[u8], question_end: usize, answers: &[IpAddr]) -> Option<Vec<u8>> {
        if question_end < 12 || question_end > query.len() {
            return None;
        }
        let mut response = Vec::with_capacity(query.len() + answers.len() * 32);
        response.extend_from_slice(&query[0..2]);
        response.extend_from_slice(&0x8180u16.to_be_bytes());
        response.extend_from_slice(&1u16.to_be_bytes());
        response.extend_from_slice(&(answers.len() as u16).to_be_bytes());
        response.extend_from_slice(&0u16.to_be_bytes());
        response.extend_from_slice(&0u16.to_be_bytes());
        response.extend_from_slice(&query[12..question_end]);
        for answer in answers {
            response.extend_from_slice(&0xc00cu16.to_be_bytes());
            match answer {
                IpAddr::V4(ip) => {
                    response.extend_from_slice(&1u16.to_be_bytes());
                    response.extend_from_slice(&1u16.to_be_bytes());
                    response.extend_from_slice(&60u32.to_be_bytes());
                    response.extend_from_slice(&4u16.to_be_bytes());
                    response.extend_from_slice(&ip.octets());
                }
                IpAddr::V6(ip) => {
                    response.extend_from_slice(&28u16.to_be_bytes());
                    response.extend_from_slice(&1u16.to_be_bytes());
                    response.extend_from_slice(&60u32.to_be_bytes());
                    response.extend_from_slice(&16u16.to_be_bytes());
                    response.extend_from_slice(&ip.octets());
                }
            }
        }
        Some(response)
    }

    fn maybe_fake_dns_response(&self, buf: &[u8]) -> Option<Vec<u8>> {
        let peer = match &self.inner {
            Some(InetSocketInner::Dgram(socket)) => socket.peer_addr().ok()?,
            _ => return None,
        };
        if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
            println!("inet fake-dns check peer={peer}");
        }
        if !(peer.port() == 53 && (peer.ip().is_unspecified() || peer.ip().is_loopback())) {
            return None;
        }
        let (name, qtype, question_end) = Self::parse_dns_query(buf)?;
        let answers = Self::resolve_dns_answers(&name, qtype);
        if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
            println!(
                "inet fake-dns hit name={} normalized={} qtype={} answers={}",
                name,
                Self::normalize_dns_name(&name),
                qtype,
                answers.len()
            );
        }
        Self::build_dns_response(buf, question_end, answers.as_slice())
    }
}

impl<T: Clone> FileIOTrait<T> for InetSocket {
    fn bind(
        &mut self,
        addr: VMPointer<T>,
        addr_len: usize,
        _emulator: &AndroidEmulator<T>,
    ) -> i32 {
        let Some(sockaddr) = Self::read_sockaddr(addr, addr_len) else {
            return -1;
        };

        if self.sock_type.contains(SockType::SOCK_DGRAM) {
            let Ok(socket) = UdpSocket::bind(sockaddr) else {
                return -1;
            };
            let _ = socket.set_read_timeout(Some(Duration::from_secs(5)));
            let _ = socket.set_write_timeout(Some(Duration::from_secs(5)));
            self.inner = Some(InetSocketInner::Dgram(socket));
            return 0;
        }

        0
    }

    fn close(&mut self) {
        if let Some(InetSocketInner::Stream(stream)) = &self.inner {
            let _ = stream.shutdown(Shutdown::Both);
        }
        self.inner = None;
        self.pending_read = None;
    }

    fn read(&mut self, buf: VMPointer<T>, count: usize) -> usize {
        if let Some(pending) = self.pending_read.take() {
            let size = pending.len().min(count);
            let _ = buf.write_bytes(pending[..size].to_vec().into());
            return size;
        }
        let mut tmp = vec![0u8; count];
        let read = match self.inner.as_mut() {
            Some(InetSocketInner::Stream(stream)) => stream.read(&mut tmp).ok(),
            Some(InetSocketInner::Dgram(socket)) => socket.recv(&mut tmp).ok(),
            None => None,
        };
        match read {
            Some(size) => {
                let _ = buf.write_bytes(tmp[..size].to_vec().into());
                size
            }
            None => 0,
        }
    }

    fn pread(&mut self, buf: VMPointer<T>, count: usize, _offset: usize) -> usize {
        self.read(buf, count)
    }

    fn write(&mut self, buf: &[u8]) -> i32 {
        if matches!(
            std::env::var("RNIDBG_FAKE_DNS")
                .ok()
                .as_deref()
                .map(|value| value.trim().to_ascii_lowercase()),
            Some(value) if matches!(value.as_str(), "1" | "true" | "yes" | "on")
        ) {
            if let Some(response) = self.maybe_fake_dns_response(buf) {
                if option_env!("PRINT_SYSCALL_LOG") == Some("1") {
                    println!("inet fake-dns queued response len={}", response.len());
                }
                self.pending_read = Some(response);
                return buf.len() as i32;
            }
        }
        let written = match self.inner.as_mut() {
            Some(InetSocketInner::Stream(stream)) => stream.write(buf).ok(),
            Some(InetSocketInner::Dgram(socket)) => socket.send(buf).ok(),
            None => None,
        };
        written.map(|size| size as i32).unwrap_or(-1)
    }

    fn lseek(&mut self, _offset: i64, _whence: i32) -> SeekResult {
        SeekResult::UnknownError
    }

    fn path(&self) -> &str {
        &self.path
    }

    fn local_addr(&self) -> Option<SocketAddr> {
        match &self.inner {
            Some(InetSocketInner::Stream(stream)) => stream.local_addr().ok(),
            Some(InetSocketInner::Dgram(socket)) => socket.local_addr().ok(),
            None => None,
        }
    }

    fn peer_addr(&self) -> Option<SocketAddr> {
        match &self.inner {
            Some(InetSocketInner::Stream(stream)) => stream.peer_addr().ok(),
            Some(InetSocketInner::Dgram(socket)) => socket.peer_addr().ok(),
            None => None,
        }
    }

    fn host_raw_fd(&self) -> Option<i32> {
        match &self.inner {
            Some(InetSocketInner::Stream(stream)) => Some(stream.as_raw_fd()),
            Some(InetSocketInner::Dgram(socket)) => Some(socket.as_raw_fd()),
            None => None,
        }
    }

    fn has_pending_read(&self) -> bool {
        self.pending_read.is_some()
    }

    fn connect(
        &mut self,
        addr: VMPointer<T>,
        addr_len: usize,
        _emulator: &AndroidEmulator<T>,
    ) -> i32 {
        let Some(mut sockaddr) = Self::read_sockaddr(addr, addr_len) else {
            return -1;
        };

        if self.sock_type.contains(SockType::SOCK_DGRAM) {
            let original_sockaddr = sockaddr;
            sockaddr = Self::dns_upstream(sockaddr);
            if option_env!("PRINT_SYSCALL_LOG") == Some("1") && sockaddr != original_sockaddr {
                println!("inet dns-upstream remap {} -> {}", original_sockaddr, sockaddr);
            }
            match self.inner.as_mut() {
                Some(InetSocketInner::Dgram(socket)) => {
                    if socket.connect(sockaddr).is_err() {
                        return -1;
                    }
                }
                Some(InetSocketInner::Stream(_)) => return -1,
                None => {
                    let bind_addr = match sockaddr {
                        SocketAddr::V4(_) => {
                            SocketAddr::V4(SocketAddrV4::new(Ipv4Addr::UNSPECIFIED, 0))
                        }
                        SocketAddr::V6(_) => {
                            SocketAddr::V6(SocketAddrV6::new(Ipv6Addr::UNSPECIFIED, 0, 0, 0))
                        }
                    };
                    let Ok(socket) = UdpSocket::bind(bind_addr) else {
                        return -1;
                    };
                    let _ = socket.set_read_timeout(Some(Duration::from_secs(5)));
                    let _ = socket.set_write_timeout(Some(Duration::from_secs(5)));
                    if socket.connect(sockaddr).is_err() {
                        return -1;
                    }
                    self.inner = Some(InetSocketInner::Dgram(socket));
                }
            }
            return 0;
        }

        let Ok(stream) = TcpStream::connect(sockaddr) else {
            return -1;
        };
        let _ = stream.set_read_timeout(Some(Duration::from_secs(5)));
        let _ = stream.set_write_timeout(Some(Duration::from_secs(5)));
        self.inner = Some(InetSocketInner::Stream(stream));
        0
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
        0
    }

    fn to_vec(&mut self) -> Vec<u8> {
        Vec::new()
    }
}
