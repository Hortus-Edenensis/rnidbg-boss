use crate::elf::hash_tab::HashTable;
use crate::elf::memorized_object::MemoizedObject;
use crate::elf::parser::{ElfFile, ElfParser};
use crate::elf::section::ElfSection;
use crate::elf::str_tab::ElfStringTable;
use crate::elf::symbol::ElfSymbol;
use anyhow::anyhow;

#[derive(Clone)]
pub enum SymbolLocator {
    Section(ElfSection),
    SymbolStructure(ElfSymbolStructure),
}

#[derive(Clone)]
pub struct ElfSymbolStructure {
    parser: ElfParser,
    offset: usize,
    entry_size: u32,
    symbol_count: usize,
    string_table: MemoizedObject<ElfStringTable>,
    hash_table: MemoizedObject<Option<HashTable>>,
}

impl ElfSymbolStructure {
    pub fn new(
        parser: ElfParser,
        offset: usize,
        entry_size: u32,
        symbol_count: usize,
        string_table: MemoizedObject<ElfStringTable>,
        hash_table: Option<HashTable>,
    ) -> Self {
        Self {
            parser,
            offset,
            entry_size,
            symbol_count,
            string_table,
            hash_table: MemoizedObject::new_with_value(hash_table),
        }
    }

    pub fn get_elf_symbol(&self, index: i32) -> anyhow::Result<ElfSymbol> {
        let mut symbol = ElfSymbol::new(
            self.parser.clone(),
            self.offset + index as usize * self.entry_size as usize,
            -1,
        );
        symbol.set_string_table(self.string_table.get_value()?);
        Ok(symbol)
    }

    pub(crate) fn get_elf_symbol_by_addr(&self, so_addr: u64) -> anyhow::Result<ElfSymbol> {
        let hash_tab = self.hash_table.get_value()?;
        if let Some(hash_tab) = hash_tab {
            return match hash_tab {
                HashTable::Gnu(gnu) => gnu.get_symbol_by_addr(self, so_addr),
                HashTable::SysV(sys) => sys.get_symbol_by_addr(self, so_addr),
            };
        }
        for index in 0..self.symbol_count {
            let symbol = self.get_elf_symbol(index as i32)?;
            if symbol.matches(so_addr) {
                return Ok(symbol);
            }
        }
        Err(anyhow!("Failed to get symbol by addr: {}", so_addr))
    }

    pub fn get_elf_symbol_by_name(
        &self,
        name: &str,
        elf_file: &ElfFile,
    ) -> anyhow::Result<ElfSymbol> {
        let hash_tab = self.hash_table.get_value()?;
        if let Some(hash_tab) = hash_tab {
            return match hash_tab {
                HashTable::Gnu(gnu) => gnu.get_symbol(self, name, elf_file),
                HashTable::SysV(sys) => sys.get_symbol(self, name, elf_file),
            };
        }
        for index in 0..self.symbol_count {
            let symbol = self.get_elf_symbol(index as i32)?;
            if let Ok(symbol_name) = symbol.name(elf_file) {
                if symbol_name == name {
                    return Ok(symbol);
                }
            }
        }
        Err(anyhow!("Failed to get symbol by name: {}", name))
    }
}
