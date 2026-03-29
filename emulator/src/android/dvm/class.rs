use crate::android::dvm::member::DvmMember;
use crate::android::dvm::object::DvmObject;
use crate::android::dvm::DalvikVM64;
use crate::android::jni::JniValue;
use crate::emulator::AndroidEmulator;
use std::rc::Rc;

#[derive(Clone)]
pub struct DvmClass {
    pub id: i64,
    pub name: String,
    pub super_class: Option<Rc<DvmClass>>,
    pub interfaces: Option<Vec<Rc<DvmClass>>>,
}

impl DvmClass {
    pub(super) fn new(
        id: i64,
        name: &str,
        super_class: Option<Rc<DvmClass>>,
        interfaces: Option<Vec<Rc<DvmClass>>>,
    ) -> DvmClass {
        DvmClass {
            id,
            name: format_class_name(name),
            super_class,
            interfaces,
        }
    }

    pub(super) fn new_class(id: i64, name: &str) -> DvmClass {
        DvmClass {
            id,
            name: format_class_name(name),
            super_class: None,
            interfaces: None,
        }
    }

    pub fn new_simple_instance<T: Clone>(self: &Rc<DvmClass>, vm: &mut DalvikVM64<T>) -> DvmObject {
        let object = DvmObject::new_simple(self.clone());
        let object_id = vm.add_global_ref(object);
        DvmObject::ObjectRef(object_id)
    }

    pub fn call_static_method<T: Clone>(
        &self,
        emulator: &AndroidEmulator<T>,
        vm: &mut DalvikVM64<T>,
        method_name: &str,
        signature: &str,
        args: Vec<JniValue>,
    ) -> JniValue {
        let members = vm.members.get(&self.id).unwrap();
        let method = members
            .iter()
            .find(|m| match m {
                DvmMember::Field(_) => false,
                DvmMember::Method(method) => {
                    method.name == method_name && method.signature == signature
                }
            })
            .expect("member not found");
        if let DvmMember::Method(method) = method {
            let method = method.clone();
            vm.call_method_with_jni_dispatch(
                emulator,
                &Rc::new(self.clone()),
                &method,
                None,
                self.id,
                true,
                args,
            )
        } else {
            unreachable!()
        }
    }
}

pub fn format_class_name(name: &str) -> String {
    let mut name = name.to_string();
    if name.starts_with("L") {
        name = name[1..].to_string();
    }
    if name.ends_with(";") {
        name = name[..name.len() - 1].to_string();
    }
    name.replace(".", "/")
}
