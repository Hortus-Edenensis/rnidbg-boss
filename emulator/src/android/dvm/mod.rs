#![allow(non_snake_case)]

pub mod class;
pub mod class_resolver;
mod jni_env_ext;
pub mod member;
pub mod object;

use crate::android::dvm::class::DvmClass;
use crate::android::dvm::class_resolver::ClassResolver;
use crate::android::dvm::jni_env_ext::initialize_env;
use crate::android::dvm::member::{DvmField, DvmMember, DvmMethod};
use crate::android::dvm::object::DvmObject;
use crate::android::jni;
use crate::android::jni::{
    Jni, JniValue, MethodAcc, VaList, JNI_FLAG_CLASS, JNI_FLAG_OBJECT, JNI_FLAG_REF,
};
use crate::android::structs::JNINativeMethod;
use crate::backend::RegisterARM64;
use crate::elf::abi::PT_LOAD;
use crate::elf::parser::ElfFile;
use crate::emulator::{AndroidEmulator, RcUnsafeCell};
use crate::linux::LinuxModule;
use crate::memory::library_file::{ElfLibraryFile, LibraryFile};
use crate::memory::svc_memory::{SimpleArm64Svc, SvcCallResult};
use crate::pointer::VMPointer;
use crate::tool::UnicornArg;
use ansi_term::Color;
use anyhow::anyhow;
use bytes::{Buf, Bytes, BytesMut};
use log::{error, info, warn};
use sparse_list::SparseList;
use std::cmp::{max, min};
use std::collections::HashMap;
use std::hash::{DefaultHasher, Hash, Hasher};
use std::io::{Read, Seek};
use std::marker::PhantomData;
use std::path::{Path, PathBuf};
use std::rc::Rc;
use std::sync::Arc;
use std::{fs, mem};

pub(crate) const JNI_OK: i64 = 0;
pub(crate) const JNI_FALSE: i64 = 0;
pub(crate) const JNI_TRUE: i64 = 1;
pub(crate) const JNI_ERR: i64 = -1;
pub(crate) const JNI_NULL: i64 = 0;
pub(crate) const JNI_VERSION_1_1: i64 = 0x00010001;
pub(crate) const JNI_VERSION_1_2: i64 = 0x00010002;
pub(crate) const JNI_VERSION_1_4: i64 = 0x00010004;
pub(crate) const JNI_VERSION_1_6: i64 = 0x00010006;
pub(crate) const JNI_VERSION_1_8: i64 = 0x00010008;

#[macro_export]
macro_rules! dalvik {
    ($emulator:expr) => {
        $emulator.inner_mut().dalvik.as_mut().unwrap()
    };
}

pub struct DalvikVM64<'a, T: Clone> {
    pub java_vm: u64,
    pub java_env: u64,
    throwable: Option<DvmObject>,
    pub(crate) class_resolver: Option<ClassResolver>,
    members: HashMap<i64, Vec<DvmMember>>,
    pub(crate) jni: Option<Box<dyn Jni<T>>>,
    global_ref_pool: SparseList<DvmObject>,
    pub(crate) local_ref_pool: SparseList<DvmObject>,
    pd: PhantomData<&'a T>,
}

fn NoImplementedHandler<T: Clone>(name: &str, emulator: &AndroidEmulator<T>) -> SvcCallResult {
    SvcCallResult::FUCK(anyhow!("Svc({}) No Implemented!", name))
}

fn GetEnv<T: Clone>(name: &str, emulator: &AndroidEmulator<T>) -> SvcCallResult {
    let vm = emulator.backend.reg_read(RegisterARM64::X0).unwrap();
    let env_pointer = emulator.backend.reg_read(RegisterARM64::X1).unwrap();
    let version = emulator.backend.reg_read(RegisterARM64::X2).unwrap();

    unsafe {
        let dvm = dalvik!(emulator) as *mut DalvikVM64<T>;
        let env = (*dvm).java_env as i64;
        //let task = emulator.inner_mut().ctx_task;
        if version as i64 != JNI_VERSION_1_1
            && version as i64 != JNI_VERSION_1_2
            && version as i64 != JNI_VERSION_1_4
            && version as i64 != JNI_VERSION_1_6
            && version as i64 != JNI_VERSION_1_8
        {
            panic!("Unsupported JNI version: 0x{:x}", version);
        }

        if option_env!("PRINT_JNI_CALLS").unwrap_or("") == "1" {
            println!(
                "{} {}(vm = 0x{:X}, env = 0x{:X}, version = 0x{:x}) => 0x{:X}",
                Color::Yellow.paint("JNI:"),
                Color::Blue.paint("GetEnv"),
                vm,
                env_pointer,
                version,
                env
            );
        }

        emulator
            .backend
            .mem_write(env_pointer, &env.to_le_bytes())
            .unwrap();
    }

    SvcCallResult::RET(JNI_OK)
}

impl<'a, T: Clone> DalvikVM64<'a, T> {
    /// https://android.googlesource.com/platform/libnativehelper/+/refs/tags/android-10.0.0_r47/include_jni/jni.h#150
    fn init<'b>(emulator: &'b AndroidEmulator<'a, T>) {
        let svc_memory = &mut emulator.inner_mut().svc_memory;
        let java_vm = svc_memory.allocate(8, "_JavaVM");
        let java_env = initialize_env(svc_memory);

        // DestroyJavaVM
        let _destroy_java_vm =
            svc_memory.register_svc(SimpleArm64Svc::new("_DestroyJavaVM", NoImplementedHandler));
        // AttachCurrentThread
        let _attach_current_thread = svc_memory.register_svc(SimpleArm64Svc::new(
            "_AttachCurrentThread",
            NoImplementedHandler,
        ));
        // DetachCurrentThread
        let _detach_current_thread = svc_memory.register_svc(SimpleArm64Svc::new(
            "_DetachCurrentThread",
            NoImplementedHandler,
        ));
        // GetEnv
        let _get_env = svc_memory.register_svc(SimpleArm64Svc::new("_GetEnv", GetEnv));
        // AttachCurrentThreadAsDaemon
        let _attach_current_thread_as_daemon = svc_memory.register_svc(SimpleArm64Svc::new(
            "_AttachCurrentThreadAsDaemon",
            NoImplementedHandler,
        ));

        let _jniinvoke_interface = svc_memory.allocate(8 * 8, "_JNIInvokeInterface");
        _jniinvoke_interface
            .write_u64_with_offset(8 * 0, 0)
            .expect("write_u64_with_offset failed: reserved0");
        _jniinvoke_interface
            .write_u64_with_offset(8 * 1, 0)
            .expect("write_u64_with_offset failed: reserved1");
        _jniinvoke_interface
            .write_u64_with_offset(8 * 2, 0)
            .expect("write_u64_with_offset failed: reserved2");
        _jniinvoke_interface
            .write_u64_with_offset(8 * 3, _destroy_java_vm)
            .expect("write_u64_with_offset failed: DestroyJavaVM");
        _jniinvoke_interface
            .write_u64_with_offset(8 * 4, _attach_current_thread)
            .expect("write_u64_with_offset failed: AttachCurrentThread");
        _jniinvoke_interface
            .write_u64_with_offset(8 * 5, _detach_current_thread)
            .expect("write_u64_with_offset failed: DetachCurrentThread");
        _jniinvoke_interface
            .write_u64_with_offset(8 * 6, _get_env)
            .expect("write_u64_with_offset failed: GetEnv");
        _jniinvoke_interface
            .write_u64_with_offset(8 * 7, _attach_current_thread_as_daemon)
            .expect("write_u64_with_offset failed: AttachCurrentThreadAsDaemon");

        java_vm
            .write_u64_with_offset(0, _jniinvoke_interface.addr)
            .expect("write_u64_with_offset failed: _jniinvoke_interface");

        let dvm = DalvikVM64 {
            java_vm: java_vm.addr,
            java_env,
            throwable: None,
            class_resolver: None,
            members: HashMap::new(),
            jni: None,
            global_ref_pool: SparseList::new(),
            local_ref_pool: SparseList::new(),
            pd: PhantomData,
        };
        emulator.inner_mut().dalvik = Option::from(dvm);
    }

    pub fn debug_member_signatures(&self, class_id: i64) -> Vec<String> {
        self.members
            .get(&class_id)
            .map(|members| {
                members
                    .iter()
                    .map(|member| match member {
                        DvmMember::Field(field) => {
                            format!("FIELD {}:{}", field.name, field.signature)
                        }
                        DvmMember::Method(method) => {
                            format!("METHOD {}{} jni={}", method.name, method.signature, method.is_jni_method())
                        }
                    })
                    .collect()
            })
            .unwrap_or_default()
    }

    pub fn load_library(
        &self,
        emulator: AndroidEmulator<'a, T>,
        elf_file_path: &str,
        force_init: bool,
    ) -> anyhow::Result<RcUnsafeCell<LinuxModule<'a, T>>> {
        let path = PathBuf::from(elf_file_path);
        let file_data = fs::read(path).map_err(|e| anyhow!("unable to read elf file: {}", e))?;
        let memory = &mut emulator.inner_mut().memory;
        let library = memory.load_internal(
            LibraryFile::Elf(ElfLibraryFile::new(file_data, elf_file_path.to_string())),
            force_init,
            &emulator,
        );

        if std::env::var("RELEASE_CACHED_LIBRARIES").map_or(true, |v| v == "1") {
            memory.release_cached_library();
        }

        library
    }

    pub fn call_jni_onload(
        &mut self,
        emulator: AndroidEmulator<'a, T>,
        module: &LinuxModule<T>,
    ) -> anyhow::Result<()> {
        let jni_onload = module.find_symbol_by_name("JNI_OnLoad", false)?;
        self.call_jni_onload_at(
            emulator,
            module.name.as_str(),
            jni_onload.address(),
            Some(jni_onload.value()),
        )
    }

    pub fn call_jni_onload_at(
        &mut self,
        emulator: AndroidEmulator<'a, T>,
        module_name: &str,
        absolute_addr: u64,
        relative_offset: Option<u64>,
    ) -> anyhow::Result<()> {
        if option_env!("PRINT_JNI_CALLS").unwrap_or("") == "1" {
            println!(
                "Call Jni_OnLoad for {}, address=0x{:X}, offset=0x{:X}",
                module_name,
                absolute_addr,
                relative_offset.unwrap_or(0)
            );
        }
        info!(
            "call_jni_onload start module={} address=0x{:X} offset={:?}",
            module_name, absolute_addr, relative_offset
        );
        let ret = emulator.e_func(
            absolute_addr,
            vec![UnicornArg::U64(self.java_vm), UnicornArg::Ptr(0)],
        );
        info!("call_jni_onload raw_ret module={} ret={:?}", module_name, ret);
        // release all local ref value
        self.local_ref_pool.clear();
        emulator.inner_mut().memory.release_tmp_memory();
        if ret.is_none() {
            error!("Call [{}]JNI_OnLoad failed", module_name);
            return Err(anyhow!("Call JNI_OnLoad failed"));
        }
        let version = ret.unwrap();
        if version != 0x00010001
            && version != 0x00010002
            && version != 0x00010004
            && version != 0x00010006
            && version != 0x00010008
        {
            return Err(anyhow!("Call JNI_OnLoad failed: version={:x}", version));
        }
        Ok(())
    }

    /// Dispatch a method call to either JNI native implementation (`fn_ptr != 0`)
    /// or to the Java-side JNI handler (`Jni::call_method_v`) for synthetic calls.
    pub fn call_method_with_jni_dispatch(
        &mut self,
        emulator: &AndroidEmulator<T>,
        class: &Rc<DvmClass>,
        method: &DvmMethod,
        instance: Option<&mut DvmObject>,
        receiver: i64,
        is_static: bool,
        args: Vec<JniValue>,
    ) -> JniValue {
        if method.is_jni_method() {
            return self.call_native_method(emulator, method, receiver, args);
        }
        self.call_non_native_method(emulator, class, method, instance, is_static, args)
    }

    fn call_native_method(
        &mut self,
        emulator: &AndroidEmulator<T>,
        method: &DvmMethod,
        receiver: i64,
        args: Vec<JniValue>,
    ) -> JniValue {
        let mut native_args = vec![UnicornArg::Ptr(self.java_env), UnicornArg::I64(receiver)];
        for arg in args {
            match arg {
                JniValue::Void => unreachable!(),
                JniValue::Boolean(z) => native_args.push(UnicornArg::I32(if z { 1 } else { 0 })),
                JniValue::Byte(b) => native_args.push(UnicornArg::I32(b as i32)),
                JniValue::Char(c) => native_args.push(UnicornArg::I32(c as i32)),
                JniValue::Short(s) => native_args.push(UnicornArg::I32(s as i32)),
                JniValue::Int(i) => native_args.push(UnicornArg::I32(i)),
                JniValue::Long(l) => native_args.push(UnicornArg::I64(l)),
                JniValue::Float(f) => native_args.push(UnicornArg::F32(f)),
                JniValue::Double(d) => native_args.push(UnicornArg::F64(d)),
                JniValue::Object(obj) => {
                    let obj_id = self.add_local_ref(obj);
                    native_args.push(UnicornArg::I64(obj_id));
                }
                JniValue::Null => native_args.push(UnicornArg::I64(0)),
            }
        }

        let ret = emulator.e_func(method.fn_ptr, native_args);
        let ret_value = self.native_return_to_jni_value(ret);
        self.local_ref_pool.clear();
        ret_value
    }

    fn call_non_native_method(
        &mut self,
        emulator: &AndroidEmulator<T>,
        class: &Rc<DvmClass>,
        method: &DvmMethod,
        instance: Option<&mut DvmObject>,
        is_static: bool,
        args: Vec<JniValue>,
    ) -> JniValue {
        let va_list_addr = self.build_synthetic_va_list(emulator, args);
        let mut va_list = VaList::new(emulator, va_list_addr);
        let method_acc = infer_method_acc(method, is_static);
        // We need a raw pointer to avoid aliasing `&mut self` and `&mut self.jni`.
        let jni_ptr: *mut dyn Jni<T> = self.jni.as_deref_mut().expect("JNI not register");
        let ret = unsafe {
            (*jni_ptr).call_method_v(self, method_acc, class, method, instance, &mut va_list)
        };
        self.local_ref_pool.clear();
        ret
    }

    fn build_synthetic_va_list(
        &mut self,
        emulator: &AndroidEmulator<T>,
        args: Vec<JniValue>,
    ) -> u64 {
        let mut gp_values = Vec::new();
        let mut vr_values = Vec::new();

        for arg in args {
            match arg {
                JniValue::Void => unreachable!(),
                JniValue::Boolean(z) => gp_values.push(if z { 1 } else { 0 }),
                JniValue::Byte(b) => gp_values.push(b as i64 as u64),
                JniValue::Char(c) => gp_values.push(c as u64),
                JniValue::Short(s) => gp_values.push(s as i64 as u64),
                JniValue::Int(i) => gp_values.push(i as i64 as u64),
                JniValue::Long(l) => gp_values.push(l as u64),
                JniValue::Float(f) => {
                    let mut slot = [0_u8; 16];
                    slot[..4].copy_from_slice(&f.to_le_bytes());
                    vr_values.push(slot);
                }
                JniValue::Double(d) => {
                    let mut slot = [0_u8; 16];
                    slot[..8].copy_from_slice(&d.to_le_bytes());
                    vr_values.push(slot);
                }
                JniValue::Object(obj) => gp_values.push(self.add_local_ref(obj) as u64),
                JniValue::Null => gp_values.push(0),
            }
        }

        let gp_slots = max(1, gp_values.len());
        let gp_save = emulator
            .falloc(gp_slots * 8, true)
            .expect("failed to allocate synthetic gp_save");
        for (index, value) in gp_values.iter().enumerate() {
            gp_save
                .write_u64_with_offset((index * 8) as u64, *value)
                .expect("failed to write synthetic gp arg");
        }

        let (vr_top, vr_offs) = if vr_values.is_empty() {
            (0_u64, 0_i32)
        } else {
            let vr_slots = vr_values.len();
            let vr_save = emulator
                .falloc(vr_slots * 16, true)
                .expect("failed to allocate synthetic vr_save");
            for (index, value) in vr_values.iter().enumerate() {
                vr_save
                    .write_bytes_with_offset((index * 16) as u64, Bytes::copy_from_slice(value))
                    .expect("failed to write synthetic vr arg");
            }
            (vr_save.addr + (vr_slots * 16) as u64, -((vr_values.len() as i32) * 16))
        };

        let va_list = emulator
            .falloc(0x20, true)
            .expect("failed to allocate synthetic va_list");
        va_list
            .write_u64_with_offset(0, 0)
            .expect("failed to write synthetic va_list.stack");
        va_list
            .write_u64_with_offset(8, gp_save.addr + (gp_slots * 8) as u64)
            .expect("failed to write synthetic va_list.gr_top");
        va_list
            .write_u64_with_offset(16, vr_top)
            .expect("failed to write synthetic va_list.vr_top");
        va_list
            .write_i32_with_offset(24, -((gp_values.len() as i32) * 8))
            .expect("failed to write synthetic va_list.gr_offs");
        va_list
            .write_i32_with_offset(28, vr_offs)
            .expect("failed to write synthetic va_list.vr_offs");
        va_list.addr
    }

    fn native_return_to_jni_value(&mut self, ret: Option<u64>) -> JniValue {
        if let Some(obj_id) = ret {
            let value = i64::from_le_bytes(obj_id.to_le_bytes());
            let flag = jni::get_flag_id(value);
            if flag == JNI_FLAG_REF {
                if let Some(obj) = self.get_global_ref(value).cloned() {
                    return JniValue::Object(obj);
                }
            } else if flag == JNI_FLAG_OBJECT {
                if let Some(obj) = self.get_local_ref(value).cloned() {
                    return JniValue::Object(obj);
                }
            }
            return JniValue::Long(value);
        }
        JniValue::Null
    }

    /// Local -> Object
    pub fn add_local_ref(&mut self, object: DvmObject) -> i64 {
        let ref_seq = self.local_ref_pool.insert(object) as i64;
        let ref_object_id = jni::generate_object_id(ref_seq);
        ref_object_id
    }

    /// GetLocalRef by object_id
    pub fn get_local_ref(&self, object_id: i64) -> Option<&DvmObject> {
        if jni::get_flag_id(object_id) != JNI_FLAG_OBJECT {
            panic!("Invalid object_id: 0x{:X}", object_id);
        }
        let ref_seq = jni::get_object_seq(object_id);
        let object = self.local_ref_pool.get(ref_seq as usize)?;
        Some(object)
    }

    pub fn remove_local_ref(&mut self, object_id: i64) {
        let flag = jni::get_flag_id(object_id);
        if flag == JNI_FLAG_CLASS {
            return;
        }
        if flag != JNI_FLAG_OBJECT {
            panic!("Invalid object_id: 0x{:X}", object_id);
        }
        let ref_seq = jni::get_object_seq(object_id);
        self.local_ref_pool.remove(ref_seq as usize);
    }

    pub fn get_local_ref_mut(&mut self, object_id: i64) -> Option<&mut DvmObject> {
        if jni::get_flag_id(object_id) != JNI_FLAG_OBJECT {
            panic!("Invalid object_id: 0x{:X}", object_id);
        }
        let ref_seq = jni::get_object_seq(object_id);
        let object = self.local_ref_pool.get_mut(ref_seq as usize)?;
        Some(object)
    }

    /// Global -> Ref
    pub fn add_global_ref(&mut self, object: DvmObject) -> i64 {
        let ref_seq = self.global_ref_pool.insert(object) as i64;
        let ref_object_id = jni::generate_ref_id(ref_seq);
        ref_object_id
    }

    pub fn remove_global_ref(&mut self, ref_id: i64) {
        if jni::get_flag_id(ref_id) != JNI_FLAG_REF {
            panic!("Invalid ref_id: 0x{:X}", ref_id);
        }
        let ref_seq = jni::get_object_seq(ref_id);
        self.global_ref_pool.remove(ref_seq as usize);
    }

    /// GetGlobalRef by ref_id
    pub fn get_global_ref(&self, ref_id: i64) -> Option<&DvmObject> {
        if jni::get_flag_id(ref_id) != JNI_FLAG_REF {
            panic!("Invalid ref_id: 0x{:X}", ref_id);
        }
        let ref_seq = jni::get_object_seq(ref_id);
        let object = self.global_ref_pool.get(ref_seq as usize)?;
        Some(object)
    }

    pub fn get_global_ref_mut(&mut self, ref_id: i64) -> Option<&mut DvmObject> {
        if jni::get_flag_id(ref_id) != JNI_FLAG_REF {
            panic!("Invalid ref_id: 0x{:X}", ref_id);
        }
        let ref_seq = jni::get_object_seq(ref_id);
        let object = self.global_ref_pool.get_mut(ref_seq as usize)?;
        Some(object)
    }

    pub fn throw(&mut self, throwable: DvmObject) {
        self.throwable = Option::from(throwable);
    }

    pub fn set_class_resolver(&mut self, rs: ClassResolver) {
        self.class_resolver = Option::from(rs);
    }

    /// Provide a crap instance that Jni needs? It's really long-winded! ! ! ! ! ! ! ! ! ! ! ! ! ! ! !
    pub fn set_jni(&mut self, jni: Box<dyn Jni<T>>) {
        self.jni = Some(jni)
    }

    pub fn get_jni(&mut self) -> &mut Box<dyn Jni<T>> {
        self.jni.as_mut().unwrap()
    }

    pub fn find_class_by_name(&self, name: &str) -> Option<(i64, Rc<DvmClass>)> {
        let resolver = self.class_resolver.as_ref()?;
        resolver.find_class_by_name(name)
    }

    pub fn find_class_by_id(&self, id: &i64) -> Option<(i64, Rc<DvmClass>)> {
        let resolver = self.class_resolver.as_ref()?;
        resolver.find_class_by_id(id)
    }

    pub fn find_method_by_id(&self, class: i64, id: i64) -> Option<&DvmMethod> {
        if jni::get_flag_id(class) != JNI_FLAG_CLASS {
            panic!("Invalid class_id: 0x{:X}", class);
        }
        let members = self.members.get(&class);
        if members.is_none() {
            return None;
        }
        let flag = jni::get_flag_id(id);
        if flag != JNI_FLAG_CLASS {
            return None;
        }
        let member_seq = jni::get_member_id(id) as usize;
        let member = members.unwrap().get(member_seq - 1)?;
        match member {
            DvmMember::Field(_) => None,
            DvmMember::Method(method) => Some(method),
        }
    }

    pub fn find_method(&self, class: i64, name: &str, signature: &str) -> Option<&DvmMethod> {
        if jni::get_flag_id(class) != JNI_FLAG_CLASS {
            panic!("Invalid class_id: 0x{:X}", class);
        }
        let members = self.members.get(&class)?;
        members.iter().find_map(|member| match member {
            DvmMember::Method(method)
                if method.class == class
                    && method.name == name
                    && method.signature == signature =>
            {
                Some(method)
            }
            _ => None,
        })
    }

    pub fn list_method_signatures(&self, class: i64) -> Vec<String> {
        if jni::get_flag_id(class) != JNI_FLAG_CLASS {
            panic!("Invalid class_id: 0x{:X}", class);
        }
        let Some(members) = self.members.get(&class) else {
            return Vec::new();
        };
        members
            .iter()
            .filter_map(|member| match member {
                DvmMember::Method(method) => Some(format!("{}{}", method.name, method.signature)),
                _ => None,
            })
            .collect()
    }

    pub fn register_native_method(
        &mut self,
        class: i64,
        name: impl Into<String>,
        signature: impl Into<String>,
        fn_ptr: u64,
    ) -> anyhow::Result<i64> {
        if jni::get_flag_id(class) != JNI_FLAG_CLASS {
            return Err(anyhow!("Invalid class_id: 0x{:X}", class));
        }

        let name = name.into();
        let signature = signature.into();
        let members = self.members.entry(class).or_insert_with(Vec::new);

        for member in members.iter_mut() {
            if let DvmMember::Method(method) = member {
                if method.class == class && method.name == name && method.signature == signature {
                    method.fn_ptr = fn_ptr;
                    return Ok(method.id);
                }
            }
        }

        let method_id = class + members.len() as i64 + 1;
        members.push(DvmMember::Method(DvmMethod::new(
            method_id,
            class,
            name,
            signature,
            fn_ptr,
        )));
        Ok(method_id)
    }

    pub fn find_field_by_id(&self, class: i64, id: i64) -> Option<&DvmField> {
        if jni::get_flag_id(class) != JNI_FLAG_CLASS {
            panic!("Invalid class_id: 0x{:X}", class);
        }
        let members = self.members.get(&class);
        if members.is_none() {
            return None;
        }
        let flag = jni::get_flag_id(id);
        if flag != JNI_FLAG_CLASS {
            return None;
        }
        let member_seq = jni::get_member_id(id) as usize;
        let member = members.unwrap().get(member_seq - 1)?;
        match member {
            DvmMember::Field(field) => Some(field),
            DvmMember::Method(_) => None,
        }
    }

    pub fn resolve_class(&self, name: &str) -> Option<(i64, Rc<DvmClass>)> {
        if let Some(ref class_resolver) = self.class_resolver {
            class_resolver.find_class_by_name(name)
        } else {
            Some((-1, Rc::new(DvmClass::new_class(-1, name))))
        }
    }

    /// Try to construct a `DvmClass`.
    /// This method is not subject to security checks and may cause errors. Please use it with caution.
    pub fn resolve_class_unchecked(&self, name: &str) -> (i64, Rc<DvmClass>) {
        if let Some(ref class_resolver) = self.class_resolver {
            class_resolver.find_class_by_name(name).unwrap()
        } else {
            (-1, Rc::new(DvmClass::new_class(-1, name)))
        }
    }

    /// Try to construct a DvmClass with parent class information and inherited interfaces, although it is useless!
    pub fn resolve_class_with_si(
        &self,
        name: &str,
        super_class: Option<Rc<DvmClass>>,
        interfaces: Option<Vec<Rc<DvmClass>>>,
    ) -> Option<(i64, Rc<DvmClass>)> {
        if let Some(ref class_resolver) = self.class_resolver {
            class_resolver.find_class_by_name(name)
        } else {
            Some((
                -1,
                Rc::new(DvmClass::new(-1, name, super_class, interfaces)),
            ))
        }
    }

    pub fn resolve_class_with_si_unchecked(
        &self,
        name: &str,
        super_class: Option<Rc<DvmClass>>,
        interfaces: Option<Vec<Rc<DvmClass>>>,
    ) -> (i64, Rc<DvmClass>) {
        if let Some(ref class_resolver) = self.class_resolver {
            class_resolver.find_class_by_name(name).unwrap()
        } else {
            (
                -1,
                Rc::new(DvmClass::new(-1, name, super_class, interfaces)),
            )
        }
    }

    pub fn destroy(&mut self) {
        self.global_ref_pool.clear();
        self.local_ref_pool.clear();
        if let Some(ref mut jni) = self.jni {
            jni.destroy();
        }
    }
}

fn infer_method_acc(method: &DvmMethod, is_static: bool) -> MethodAcc {
    let mut acc = MethodAcc::empty();
    if is_static {
        acc |= MethodAcc::STATIC;
    }
    if method.name == "<init>" {
        acc |= MethodAcc::CONSTRUCTOR;
    }
    let return_ty = method
        .signature
        .split(')')
        .nth(1)
        .unwrap_or_else(|| panic!("invalid method signature: {}", method.signature));
    let first = return_ty
        .as_bytes()
        .first()
        .copied()
        .unwrap_or_else(|| panic!("invalid return type in signature: {}", method.signature));
    let return_acc = match first {
        b'V' => MethodAcc::VOID,
        b'Z' => MethodAcc::BOOLEAN,
        b'B' => MethodAcc::BYTE,
        b'C' => MethodAcc::CHAR,
        b'S' => MethodAcc::SHORT,
        b'I' => MethodAcc::INT,
        b'J' => MethodAcc::LONG,
        b'F' => MethodAcc::FLOAT,
        b'D' => MethodAcc::DOUBLE,
        b'L' | b'[' => MethodAcc::OBJECT,
        _ => panic!("unsupported return type in signature: {}", method.signature),
    };
    acc | return_acc
}

impl<'a, T: Clone> AndroidEmulator<'a, T> {
    /// Create the environment information required by the Android runtime.
    /// This VM serves the subsequent JniCall and JavaCall
    pub fn get_dalvik_vm(&self) -> &mut DalvikVM64<'a, T> {
        if let Some(vm) = self.inner_mut().dalvik.as_mut() {
            return vm;
        }
        DalvikVM64::init(self);
        self.inner_mut().dalvik.as_mut().unwrap()
    }
}
