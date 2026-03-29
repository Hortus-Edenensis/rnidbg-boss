use crate::android::dvm::class::DvmClass;
use crate::android::dvm::member::DvmMember;
use crate::android::dvm::DalvikVM64;
use crate::android::jni;
use crate::android::jni::{JniValue, JNI_FLAG_OBJECT, JNI_FLAG_REF};
use crate::dalvik;
use crate::emulator::AndroidEmulator;
use std::any::Any;
use std::cell::UnsafeCell;
use std::rc::Rc;

#[derive(Clone)]
pub enum DvmObject {
    /// Simple Instance
    SimpleInstance(Rc<DvmClass>),
    /// Array Instance
    ObjectArray(Rc<DvmClass>, Vec<Option<DvmObject>>),
    ByteArray(Vec<u8>),
    /// String
    String(String),
    /// Data Instance
    DataMutInstance(Rc<DvmClass>, Rc<UnsafeCell<Box<dyn Any>>>),
    DataInstance(Rc<DvmClass>, Rc<Box<dyn Any>>),
    /// Class
    Class(Rc<DvmClass>),
    /// Ref
    ObjectRef(i64),
}

impl DvmObject {
    pub fn new_simple(class: Rc<DvmClass>) -> DvmObject {
        DvmObject::SimpleInstance(class)
    }

    pub fn get_class<T: Clone>(&self, dvm: &DalvikVM64<T>) -> Rc<DvmClass> {
        match self {
            DvmObject::SimpleInstance(class) => class.clone(),
            DvmObject::ObjectArray(class, _) => class.clone(),
            DvmObject::DataMutInstance(class, _) => class.clone(),
            DvmObject::DataInstance(class, _) => class.clone(),
            DvmObject::Class(class) => class.clone(),
            DvmObject::ObjectRef(ref_id) => {
                let obj = dvm.get_global_ref(*ref_id);
                if obj.is_some() {
                    obj.unwrap().get_class(dvm)
                } else {
                    panic!("object ref not found: {}", ref_id);
                }
            }
            DvmObject::ByteArray(_) => dvm.resolve_class_unchecked("byte[]").1,
            DvmObject::String(_) => dvm.resolve_class_unchecked("java/lang/String").1,
        }
    }

    pub fn call_method<T: Clone>(
        &self,
        emulator: &AndroidEmulator<T>,
        vm: &DalvikVM64<T>,
        method_name: &str,
        signature: &str,
        args: Vec<JniValue>,
    ) -> JniValue {
        let self_id = match self {
            DvmObject::ObjectRef(ref_id) => *ref_id,
            _ => panic!("not an object ref"),
        };
        let class = self.get_class(vm);
        let members = vm.members.get(&class.id).unwrap();
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
            let vm_mut = dalvik!(emulator);
            let instance_ptr = if jni::get_flag_id(self_id) == JNI_FLAG_REF {
                vm_mut
                    .get_global_ref_mut(self_id)
                    .map(|object| object as *mut DvmObject)
            } else if jni::get_flag_id(self_id) == JNI_FLAG_OBJECT {
                vm_mut
                    .get_local_ref_mut(self_id)
                    .map(|object| object as *mut DvmObject)
            } else {
                None
            };
            let instance = instance_ptr.map(|pointer| unsafe { &mut *pointer });
            return vm_mut.call_method_with_jni_dispatch(
                emulator,
                &class,
                &method,
                instance,
                self_id,
                false,
                args,
            );
        } else {
            unreachable!()
        }
    }
}

#[test]
fn any_unsafecell_or_rc_test() {
    let unsafe_cell: UnsafeCell<i32> = UnsafeCell::new(42);
    let boxed_any_unsafe_cell: Box<dyn Any> = Box::new(unsafe_cell);
    if boxed_any_unsafe_cell
        .downcast_ref::<UnsafeCell<i32>>()
        .is_some()
    {
        println!("It's an UnsafeCell<i32>");
    }

    let rc_data: Rc<String> = Rc::new("Hello Rust".to_string());
    let boxed_any_rc: Box<dyn Any> = Box::new(rc_data);
    if boxed_any_rc.downcast_ref::<Rc<String>>().is_some() {
        println!("It's an Rc<String>");
    }
}
