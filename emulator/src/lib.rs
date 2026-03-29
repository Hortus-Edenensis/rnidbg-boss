#![allow(
    dead_code,
    deprecated,
    hidden_glob_reexports,
    irrefutable_let_patterns,
    non_camel_case_types,
    private_interfaces,
    semicolon_in_expressions_from_macros,
    unreachable_code,
    unreachable_patterns,
    unused_assignments,
    unused_comparisons,
    unused_imports,
    unused_mut,
    unused_unsafe,
    unused_variables
)]

pub mod android;
mod backend;
pub(crate) mod elf;
pub mod emulator;
pub mod keystone;
pub mod linux;
pub mod memory;
pub mod pointer;
pub(crate) mod tool;

pub use backend::{Backend, BackendKind, Permission, RegisterARM64};
#[cfg(feature = "unicorn_backend")]
pub use unicorn_engine::RegisterARM64 as UnicornRegisterARM64;
pub use emulator::AndroidEmulator;
pub use tool::UnicornArg;
