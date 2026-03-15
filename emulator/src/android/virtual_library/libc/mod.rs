use crate::emulator::AndroidEmulator;
use crate::memory::svc_memory::HookListener;
use log::info;
use std::cell::RefCell;
use std::marker::PhantomData;
use std::rc::Rc;

mod memory;
mod string;
pub(super) mod system_properties;

pub type SystemPropertyService = Rc<Box<dyn Fn(&str) -> Option<String>>>;
type SharedSystemPropertyService = Rc<RefCell<Option<SystemPropertyService>>>;

#[derive(Clone)]
pub struct Libc<'a, T> {
    system_property_service: SharedSystemPropertyService,
    pd: PhantomData<&'a T>,
}

impl<T: Clone> Libc<'_, T> {
    pub fn new<'a>() -> Libc<'a, T> {
        Libc {
            system_property_service: Rc::new(RefCell::new(None)),
            pd: PhantomData,
        }
    }

    pub fn set_system_property_service(&self, service: SystemPropertyService) {
        self.system_property_service.replace(Some(service));
    }

    pub fn clear_system_property_service(&self) {
        self.system_property_service.replace(None);
    }

    pub(crate) fn system_property_service(&self) -> Option<SystemPropertyService> {
        self.system_property_service.borrow().clone()
    }

    pub(crate) fn lookup_system_property(&self, name: &str) -> Option<String> {
        self.system_property_service()
            .and_then(|service| service(name))
    }
}

impl<'a, T: Clone> HookListener<'a, T> for Libc<'a, T> {
    fn hook(
        &self,
        emu: &AndroidEmulator<'a, T>,
        lib_name: String,
        symbol_name: String,
        old: u64,
    ) -> u64 {
        if lib_name != "libc.so" {
            return 0;
        }
        if option_env!("SHOW_LIBC_TRY_LINK") == Some("1") {
            info!("[libc.so] link {}, old=0x{:X}", symbol_name, old)
        }
        let svc = &mut emu.inner_mut().svc_memory;
        let service = self.system_property_service();
        let entry = match symbol_name.as_str() {
            "__system_property_get" => svc.register_svc(Box::new(
                system_properties::SystemPropertyGet::new(service.clone()),
            )),
            "__system_property_find" => svc.register_svc(Box::new(
                system_properties::SystemPropertyFind::new(service),
            )),
            "__system_property_read" => {
                svc.register_svc(Box::new(system_properties::SystemPropertyRead::new()))
            }
            "strcmp" => svc.register_svc(Box::new(string::StrCmp)),
            "strncmp" => svc.register_svc(Box::new(string::StrNCmp)),
            "strcasecmp" => svc.register_svc(Box::new(string::StrCaseCmp)),
            "strncasecmp" => svc.register_svc(Box::new(string::StrNCasCmp)),
            _ => 0,
        };

        entry
    }
}

#[cfg(test)]
mod tests {
    use super::{Libc, SystemPropertyService};
    use std::rc::Rc;

    #[test]
    fn cloned_libc_shares_property_service_state() {
        let libc = Libc::<()>::new();
        let cloned = libc.clone();
        let service: SystemPropertyService = Rc::new(Box::new(|name| {
            (name == "ro.test.key").then(|| "value".to_string())
        }));

        libc.set_system_property_service(service);
        assert_eq!(
            cloned.lookup_system_property("ro.test.key"),
            Some("value".to_string())
        );

        libc.clear_system_property_service();
        assert_eq!(cloned.lookup_system_property("ro.test.key"), None);
    }
}
