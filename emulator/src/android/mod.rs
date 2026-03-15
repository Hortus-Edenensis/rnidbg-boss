use log::error;
use syscall_handler::register_syscall_handler;
use crate::emulator::{AndroidEmulator, syscall_handler};

pub mod dvm;
pub mod virtual_library;
pub mod jni;
mod structs;

impl<T: Clone> AndroidEmulator<'_, T> {
    /// Provide [pid], [ppid], [proc_name] to construct an android arm64 emulator.
    /// This process will perform initialization operations and
    /// allocate some memory required by the stack/Svc
    ///
    /// # Example
    /// ```
    /// use core::emulator::AndroidEmulator;
    ///
    /// let emu = AndroidEmulator::create_arm64(32267, 29427, "com.tencent.mobileqq:MSF", ());
    /// ```
    ///
    /// # Arguments
    /// * `pid` - Process ID
    /// * `ppid` - Parent Process ID
    /// * `proc_name` - Process Name
    /// * `data` - Generic data(useless)
    pub fn create_arm64(
        pid: u32,
        ppid: u32,
        proc_name: &str,
        data: T
    ) -> AndroidEmulator<'static, T> {
        let mut context: AndroidEmulator<'static, T> = AndroidEmulator::new(pid, ppid, proc_name.to_string(), data)
            .map_err(|e| error!("failed to init emu: {}", e))
            .unwrap();

        context.set_errno(0)
            .expect("failed to set errno");

        register_syscall_handler(&context);

        context.setup_traps()
            .map_err(|e| error!("failed to setup traps: {}", e))
            .unwrap();

        context
    }
}

#[cfg(test)]
mod tests {
    use std::rc::Rc;
    use super::AndroidEmulator;
    use crate::android::virtual_library::libc::SystemPropertyService;

    #[cfg(any(feature = "unicorn_backend", feature = "dynarmic_backend"))]
    #[test]
    fn create_arm64_registers_libc_hook_and_stores_property_service() {
        let emulator = AndroidEmulator::create_arm64(1000, 999, "test.process", ());
        let count = emulator.memory().hook_listener_count();
        assert_eq!(count, 2);

        let service: SystemPropertyService = Rc::new(Box::new(|name| {
            (name == "ro.test.key").then(|| "value".to_string())
        }));
        emulator.set_system_property_service(service);

        assert_eq!(
            emulator.inner_mut().libc.lookup_system_property("ro.test.key"),
            Some("value".to_string())
        );
    }
}
