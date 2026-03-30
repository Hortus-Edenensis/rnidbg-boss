#include <array>
#include <cstdlib>
#include <cstdint>
#include <cstdio>
#include <exception>

#pragma clang diagnostic push
#pragma ide diagnostic ignored "ConstantConditionsOC"
#if defined(_WIN32) || defined(_WIN64)
#include "mman.h"
#include <errno.h>
#else
#include <sys/mman.h>
#include <sys/errno.h>
#endif

#include "dynarmic/interface/A64/a64.h"
#include "dynarmic/interface/A64/config.h"
#include "dynarmic/interface/exclusive_monitor.h"
#include "dynarmic.h"

#pragma clang diagnostic push
#pragma clang diagnostic ignored "-Wunused-parameter"
static inline u64 normalize_vaddr(u64 vaddr) {
    const u64 top = vaddr >> 56;
    switch (top) {
        case 0x20:
        case 0x40:
        case 0x60:
        case 0x80:
        case 0xA0:
        case 0xC0:
        case 0xE0:
            return vaddr & 0x00FFFFFFFFFFFFFFULL;
        default:
            return vaddr;
    }
}

static char *get_memory_page(khash_t(memory) *memory, u64 vaddr, size_t num_page_table_entries, void **page_table) {
    vaddr = normalize_vaddr(vaddr);
    u64 idx = vaddr >> DYN_PAGE_BITS;
    if(page_table && idx < num_page_table_entries) {
        if(page_table[idx]) {
            return (char *)page_table[idx];
        }
    }
    u64 base = vaddr & ~DYN_PAGE_MASK;
    khiter_t k = kh_get(memory, memory, base);
    if(k == kh_end(memory)) {
        return nullptr;
    }
    t_memory_page page = kh_value(memory, k);
    return (char *)page->addr;
}

static inline void *get_memory(khash_t(memory) *memory, u64 vaddr, size_t num_page_table_entries, void **page_table) {
    vaddr = normalize_vaddr(vaddr);
    char *page = get_memory_page(memory, vaddr, num_page_table_entries, page_table);
    return page ? &page[vaddr & DYN_PAGE_MASK] : nullptr;
}

class DynarmicCallbacks64 final : public Dynarmic::A64::UserCallbacks {
public:
    explicit DynarmicCallbacks64(khash_t(memory) *memory)
            : memory{memory} {}

    struct RecentCodeFetch {
        u64 pc = 0;
        u32 code = 0;
    };

    void DumpCpuState(const char* op, u64 vaddr) const {
        if (!cpu) {
            fprintf(stderr, "%s: vaddr=%p cpu=null\n", op, (void*)vaddr);
            return;
        }
        auto regs = cpu->GetRegisters();
        fprintf(
            stderr,
            "%s: vaddr=%p pc=%p sp=%p fp=%p lr=%p\n",
            op,
            (void*)vaddr,
            (void*)cpu->GetPC(),
            (void*)cpu->GetSP(),
            (void*)regs[29],
            (void*)regs[30]
        );
        fprintf(
            stderr,
            "  x0=%p x1=%p x2=%p x3=%p x4=%p x5=%p x6=%p x7=%p\n",
            (void*)regs[0], (void*)regs[1], (void*)regs[2], (void*)regs[3],
            (void*)regs[4], (void*)regs[5], (void*)regs[6], (void*)regs[7]
        );
        fprintf(
            stderr,
            "  x8=%p x9=%p x10=%p x11=%p x12=%p x13=%p x14=%p x15=%p\n",
            (void*)regs[8], (void*)regs[9], (void*)regs[10], (void*)regs[11],
            (void*)regs[12], (void*)regs[13], (void*)regs[14], (void*)regs[15]
        );
        fprintf(
            stderr,
            "  x16=%p x17=%p x18=%p x19=%p x20=%p x21=%p x22=%p x23=%p\n",
            (void*)regs[16], (void*)regs[17], (void*)regs[18], (void*)regs[19],
            (void*)regs[20], (void*)regs[21], (void*)regs[22], (void*)regs[23]
        );
        fprintf(
            stderr,
            "  x24=%p x25=%p x26=%p x27=%p x28=%p\n",
            (void*)regs[24], (void*)regs[25], (void*)regs[26], (void*)regs[27], (void*)regs[28]
        );
    }

    void RecordCodeFetch(u64 pc, u32 code) {
        recent_code_fetches[recent_code_fetch_cursor % recent_code_fetches.size()] = {pc, code};
        recent_code_fetch_cursor++;
    }

    void DumpRecentCodeFetches() const {
        const size_t total = recent_code_fetch_cursor < recent_code_fetches.size()
                             ? recent_code_fetch_cursor
                             : recent_code_fetches.size();
        fprintf(stderr, "RecentCodeFetches(total=%zu):\n", total);
        for (size_t i = 0; i < total; i++) {
            const size_t idx =
                (recent_code_fetch_cursor + recent_code_fetches.size() - total + i) %
                recent_code_fetches.size();
            const auto& fetch = recent_code_fetches[idx];
            fprintf(stderr, "  [%02zu] pc=%p instr=0x%08X\n", i, (void*)fetch.pc, fetch.code);
        }
    }

    bool ShouldAbortOnLowRead() const {
        const char* value = std::getenv("DYNARMIC_ABORT_ON_LOW_READ");
        return value && value[0] != '\0' && value[0] != '0';
    }

    bool TryGetWatchRange(u64& start, u64& end) const {
        const char* start_env = std::getenv("DYNARMIC_WATCH_START");
        const char* end_env = std::getenv("DYNARMIC_WATCH_END");
        if (!start_env || !end_env) {
            return false;
        }
        char* start_tail = nullptr;
        char* end_tail = nullptr;
        start = std::strtoull(start_env, &start_tail, 0);
        end = std::strtoull(end_env, &end_tail, 0);
        return start_tail && end_tail && *start_tail == '\0' && *end_tail == '\0' && start <= end;
    }

    bool IsWatchedRange(u64 vaddr, size_t size) const {
        u64 start = 0;
        u64 end = 0;
        if (!TryGetWatchRange(start, end)) {
            return false;
        }
        const u64 last = vaddr + size - 1;
        return !(last < start || vaddr > end);
    }

    void DumpWatchedAccess(const char* op, u64 vaddr, size_t size, u64 value_low, u64 value_high = 0) {
        fprintf(
            stderr,
            "%s: addr=%p size=0x%zx value_low=0x%llx value_high=0x%llx\n",
            op,
            (void*)vaddr,
            size,
            static_cast<unsigned long long>(value_low),
            static_cast<unsigned long long>(value_high)
        );
        DumpCpuState(op, vaddr);
        DumpRecentCodeFetches();
    }

    bool ShouldLogLowRead() {
        low_read_count++;
        return low_read_count <= 4 || ShouldAbortOnLowRead();
    }

    void HandleLowRead(const char* op, u64 vaddr) {
        if (!ShouldLogLowRead()) {
            return;
        }
        fprintf(stderr, "%s: low vaddr=%p\n", op, (void*)vaddr);
        DumpCpuState(op, vaddr);
        DumpRecentCodeFetches();
        if (ShouldAbortOnLowRead()) {
            abort();
        }
    }

    static u64 CanonicalizeVaddr(u64 vaddr) {
        // Dynarmic fastmem miss addresses may encode metadata in the top byte
        // (e.g. 0x20/0x40/... prefixes). Android user-space pointers can also
        // carry TBI tags; for emulator page lookup we always use canonical
        // low-56-bit virtual addresses.
        const u64 top = (vaddr >> 56) & 0xff;
        switch (top) {
            case 0x20:
            case 0x40:
            case 0x60:
            case 0x80:
            case 0xA0:
            case 0xC0:
            case 0xE0:
                return vaddr & 0x00FFFFFFFFFFFFFFULL;
            default:
                break;
        }
        return vaddr;
    }

    bool IsReadOnlyMemory(u64 vaddr) override {
//        u64 idx;
//        return mem_map && (idx = vaddr >> DYN_PAGE_BITS) < num_page_table_entries && mem_map[idx] & PAGE_EXISTS_BIT && (mem_map[idx] & UC_PROT_WRITE) == 0;
        return false;
    }

    std::optional<std::uint32_t> MemoryReadCode(u64 vaddr) override {
        u32 code = MemoryRead32(vaddr);
        RecordCodeFetch(vaddr, code);
//        printf("MemoryReadCode[%s->%s:%d]: vaddr=0x%llx, code=0x%08x\n", __FILE__, __func__, __LINE__, vaddr, code);
        return code;
    }

    u8 MemoryRead8(u64 vaddr) override {
        const u64 raw_vaddr = vaddr;
        vaddr = CanonicalizeVaddr(vaddr);
        if(vaddr < 0x1000) {
            HandleLowRead("MemoryRead8(low)", vaddr);
            return 0;
        }
        u8 *dest = (u8 *) get_memory(memory, vaddr, num_page_table_entries, page_table);
        if(dest) {
            return dest[0];
        } else {
            fprintf(stderr, "MemoryRead8[%s->%s:%d]: raw=%p canon=%p\n", __FILE__, __func__, __LINE__, (void*)raw_vaddr, (void*)vaddr);
            abort();
        }
    }
    u16 MemoryRead16(u64 vaddr) override {
        const u64 raw_vaddr = vaddr;
        vaddr = CanonicalizeVaddr(vaddr);
        if(vaddr < 0x1000) {
            HandleLowRead("MemoryRead16(low)", vaddr);
            return 0;
        }
        if(vaddr & 1) {
            const u8 a{MemoryRead8(vaddr)};
            const u8 b{MemoryRead8(vaddr + sizeof(u8))};
            return (static_cast<u16>(b) << 8) | a;
        }
        u16 *dest = (u16 *) get_memory(memory, vaddr, num_page_table_entries, page_table);
        if(dest) {
            return dest[0];
        } else {
            fprintf(stderr, "MemoryRead16[%s->%s:%d]: raw=%p canon=%p\n", __FILE__, __func__, __LINE__, (void*)raw_vaddr, (void*)vaddr);
            abort();
        }
    }
    u32 MemoryRead32(u64 vaddr) override {
        const u64 raw_vaddr = vaddr;
        vaddr = CanonicalizeVaddr(vaddr);
        if(vaddr < 0x1000) {
            HandleLowRead("MemoryRead32(low)", vaddr);
            return 0;
        }
        if(vaddr & 3) {
            const u16 a{MemoryRead16(vaddr)};
            const u16 b{MemoryRead16(vaddr + sizeof(u16))};
            return (static_cast<u32>(b) << 16) | a;
        }
        u32 *dest = (u32 *) get_memory(memory, vaddr, num_page_table_entries, page_table);
        if(dest) {
            return dest[0];
        } else {
            fprintf(stderr, "MemoryRead32[%s->%s:%d]: raw=%p canon=%p, pc=%p\n", __FILE__, __func__, __LINE__, (void*)raw_vaddr, (void*)vaddr, (void*) cpu->GetPC());
            DumpCpuState("MemoryRead32(miss)", vaddr);
            abort();
        }
    }
    u64 MemoryRead64(u64 vaddr) override {
        const u64 raw_vaddr = vaddr;
        vaddr = CanonicalizeVaddr(vaddr);
        if(vaddr < 0x1000) {
            HandleLowRead("MemoryRead64(low)", vaddr);
            return 0;
        }
        if(vaddr & 7) {
            const u32 a{MemoryRead32(vaddr)};
            const u32 b{MemoryRead32(vaddr + sizeof(u32))};
            return (static_cast<u64>(b) << 32) | a;
        }
        u64 *dest = (u64 *) get_memory(memory, vaddr, num_page_table_entries, page_table);
        if(dest) {
            return dest[0];
        } else {
            fprintf(stderr, "MemoryRead64[%s->%s:%d]: raw=%p canon=%p\n", __FILE__, __func__, __LINE__, (void*)raw_vaddr, (void*)vaddr);
            abort();
        }
    }
    Dynarmic::A64::Vector MemoryRead128(u64 vaddr) override {
        return {MemoryRead64(vaddr), MemoryRead64(vaddr + 8)};
    }

    void MemoryWrite8(u64 vaddr, u8 value) override {
        const u64 raw_vaddr = vaddr;
        vaddr = CanonicalizeVaddr(vaddr);
        if (IsWatchedRange(vaddr, sizeof(value))) {
            DumpWatchedAccess("MemoryWrite8(watch)", vaddr, sizeof(value), value);
        }
        u8 *dest = (u8 *) get_memory(memory, vaddr, num_page_table_entries, page_table);
        if(dest) {
            dest[0] = value;
        } else {
            fprintf(stderr, "MemoryWrite8[%s->%s:%d]: raw=%p canon=%p\n", __FILE__, __func__, __LINE__, (void*)raw_vaddr, (void*)vaddr);
            abort();
        }
    }
    void MemoryWrite16(u64 vaddr, u16 value) override {
        const u64 raw_vaddr = vaddr;
        vaddr = CanonicalizeVaddr(vaddr);
        if (IsWatchedRange(vaddr, sizeof(value))) {
            DumpWatchedAccess("MemoryWrite16(watch)", vaddr, sizeof(value), value);
        }
        if(vaddr & 1) {
            MemoryWrite8(vaddr, static_cast<u8>(value));
            MemoryWrite8(vaddr + sizeof(u8), static_cast<u8>(value >> 8));
            return;
        }
        u16 *dest = (u16 *) get_memory(memory, vaddr, num_page_table_entries, page_table);
        if(dest) {
            dest[0] = value;
        } else {
            fprintf(stderr, "MemoryWrite16[%s->%s:%d]: raw=%p canon=%p\n", __FILE__, __func__, __LINE__, (void*)raw_vaddr, (void*)vaddr);
            abort();
        }

    }
    void MemoryWrite32(u64 vaddr, u32 value) override {
        const u64 raw_vaddr = vaddr;
        vaddr = CanonicalizeVaddr(vaddr);
        if (IsWatchedRange(vaddr, sizeof(value))) {
            DumpWatchedAccess("MemoryWrite32(watch)", vaddr, sizeof(value), value);
        }
        if(vaddr & 3) {
            MemoryWrite16(vaddr, static_cast<u16>(value));
            MemoryWrite16(vaddr + sizeof(u16), static_cast<u16>(value >> 16));
            return;
        }
        u32 *dest = (u32 *) get_memory(memory, vaddr, num_page_table_entries, page_table);
        if(dest) {
            dest[0] = value;
        } else {
            fprintf(stderr, "MemoryWrite32[%s->%s:%d]: raw=%p canon=%p\n", __FILE__, __func__, __LINE__, (void*)raw_vaddr, (void*)vaddr);
            abort();
        }
    }
    void MemoryWrite64(u64 vaddr, u64 value) override {
        const u64 raw_vaddr = vaddr;
        vaddr = CanonicalizeVaddr(vaddr);
        if (IsWatchedRange(vaddr, sizeof(value))) {
            DumpWatchedAccess("MemoryWrite64(watch)", vaddr, sizeof(value), value);
        }
        if(vaddr & 7) {
            MemoryWrite32(vaddr, static_cast<u32>(value));
            MemoryWrite32(vaddr + sizeof(u32), static_cast<u32>(value >> 32));
            return;
        }
        u64 *dest = (u64 *) get_memory(memory, vaddr, num_page_table_entries, page_table);
        if(dest) {
            dest[0] = value;
        } else {
            fprintf(stderr, "MemoryWrite64[%s->%s:%d]: raw=%p canon=%p\n", __FILE__, __func__, __LINE__, (void*)raw_vaddr, (void*)vaddr);
            abort();
        }
    }
    void MemoryWrite128(u64 vaddr, Dynarmic::A64::Vector value) override {
        if (IsWatchedRange(vaddr, 16)) {
            DumpWatchedAccess("MemoryWrite128(watch)", vaddr, 16, value[0], value[1]);
        }
        MemoryWrite64(vaddr, value[0]);
        MemoryWrite64(vaddr + 8, value[1]);
    }

    bool MemoryWriteExclusive8(u64 vaddr, std::uint8_t value, std::uint8_t expected) override {
        MemoryWrite8(vaddr, value);
        return true;
    }
    bool MemoryWriteExclusive16(u64 vaddr, std::uint16_t value, std::uint16_t expected) override {
        MemoryWrite16(vaddr, value);
        return true;
    }
    bool MemoryWriteExclusive32(u64 vaddr, std::uint32_t value, std::uint32_t expected) override {
        MemoryWrite32(vaddr, value);
        return true;
    }
    bool MemoryWriteExclusive64(u64 vaddr, std::uint64_t value, std::uint64_t expected) override {
        MemoryWrite64(vaddr, value);
        return true;
    }
    bool MemoryWriteExclusive128(u64 vaddr, Dynarmic::A64::Vector value, Dynarmic::A64::Vector expected) override {
        MemoryWrite128(vaddr, value);
        return true;
    }

    void InterpreterFallback(u64 pc, std::size_t num_instructions) override {
        cpu->HaltExecution();
        std::optional<std::uint32_t> code = MemoryReadCode(pc);
        if(code) {
            fprintf(stderr, "Unicorn fallback @ 0x%lx for %lu instructions (instr = 0x%08X)", pc, num_instructions, *code);
        }
        abort();
    }

    void ExceptionRaised(u64 pc, Dynarmic::A64::Exception exception) override {
        bool isBrk = false;
        switch (exception) {
            case Dynarmic::A64::Exception::Yield:
                return;
            case Dynarmic::A64::Exception::Breakpoint: // brk
                isBrk = true;
            case Dynarmic::A64::Exception::WaitForInterrupt:
            case Dynarmic::A64::Exception::WaitForEvent:
            case Dynarmic::A64::Exception::SendEvent:
            case Dynarmic::A64::Exception::SendEventLocal:
            default:
                break;
        }
        cpu->SetPC(pc);
        if(!isBrk) {
            std::optional<std::uint32_t> code = MemoryReadCode(pc);
            if(code) {
                printf("ExceptionRaised[%s->%s:%d]: pc=0x%lx, exception=%d, code=0x%08X\n", __FILE__, __func__, __LINE__, pc, static_cast<std::uint32_t>(exception), *code);
            }
        }

        if(!isBrk) {
            abort();
        }
    }

    void CallSVC(u32 swi) override {
#ifdef DYNARMIC_DEBUG
        printf("CallSVC[%s->%s:%d]: swi=%d\n", __FILE__, __func__, __LINE__, swi);
#endif
        if (svc_callback) {
            svc_callback(swi, svc_user_data);
            return;
        }
        cpu->HaltExecution();
        fprintf(stderr, "CallSVC[%s->%s:%d]: swi=%d\n", __FILE__, __func__, __LINE__, swi);
    }

    void AddTicks(u64 ticks) override {
    }

    u64 GetTicksRemaining() override {
        return 0x10000000000ULL;
    }

    u64 GetCNTPCT() override {
        return 0x10000000000ULL;
    }

    u64 tpidrro_el0 = 0;
    u64 tpidr_el0 = 0;
    khash_t(memory) *memory = nullptr;
    size_t num_page_table_entries = 0;
    void **page_table = nullptr;
    Dynarmic::A64::Jit *cpu = nullptr;

    cb_call_svc svc_callback = nullptr;
    void* svc_user_data = nullptr;
    mutable std::array<RecentCodeFetch, 32> recent_code_fetches{};
    mutable size_t recent_code_fetch_cursor = 0;
    mutable size_t low_read_count = 0;

    ~DynarmicCallbacks64() override = default;
};

typedef struct dynarmic {
    khash_t(memory) *memory;
    size_t num_page_table_entries;
    void **page_table;
    DynarmicCallbacks64 *cb64;
    Dynarmic::A64::Jit *jit64;
    Dynarmic::ExclusiveMonitor *monitor;
} *t_dynarmic;

FQL int dynarmic_version() {
    return 20240814;
}

FQL const char* dynarmic_colorful_egg() {
    return "🥚";
}

FQL khash_t(memory) *dynarmic_init_memory() {
    khash_t(memory) *memory = kh_init(memory);
    if(memory == nullptr) {
        fprintf(stderr, "kh_init memory failed\n");
        abort();
    }
    int ret = kh_resize(memory, memory, 0x1000);
    if(ret == -1) {
        fprintf(stderr, "kh_resize memory failed\n");
        abort();
    }
    return memory;
}

FQL Dynarmic::ExclusiveMonitor *dynarmic_init_monitor(u32 processor_count) {
    return new Dynarmic::ExclusiveMonitor(processor_count);
}

FQL void** dynarmic_init_page_table() {
    size_t size = (1ULL << (PAGE_TABLE_ADDRESS_SPACE_BITS - DYN_PAGE_BITS)) * sizeof(void *);
    void **page_table = (void **) mmap(nullptr, size, PROT_READ | PROT_WRITE, MAP_ANONYMOUS | MAP_PRIVATE, -1, 0);
    if (page_table == MAP_FAILED) {
        fprintf(stderr, "dynarmic_init_page_table mmap failed[%s->%s:%d] size=0x%zx, errno=%d, msg=%s\n", __FILE__,
                __func__, __LINE__, size, errno, strerror(errno));
        return nullptr;
    }
    return page_table;
}

FQL dynarmic* dynarmic_new(
    u32 process_id,
    khash_t(memory) *memory,
    Dynarmic::ExclusiveMonitor *monitor,
    void **page_table,
    uint64_t jit_size,
    bool unsafe_optimizations
) {
    auto backend = (t_dynarmic) malloc(sizeof(dynarmic));
    if(!memory) {
        fprintf(stderr, "dynarmic_new failed[%s->%s:%d]: memory is null\n", __FILE__, __func__, __LINE__);
        return nullptr;
    }
    backend->memory = memory;
    backend->monitor = monitor;
    auto *callbacks = new DynarmicCallbacks64(backend->memory);

    Dynarmic::A64::UserConfig config;
    config.callbacks = callbacks;
    config.tpidrro_el0 = &callbacks->tpidrro_el0;
    config.tpidr_el0 = &callbacks->tpidr_el0;
    config.processor_id = process_id;
    config.global_monitor = backend->monitor;
    config.wall_clock_cntpct = true;
    config.code_cache_size = jit_size;
//    config.page_table_pointer_mask_bits = DYN_PAGE_BITS;


    if(unsafe_optimizations) {
        config.unsafe_optimizations = true;
        config.optimizations |= Dynarmic::OptimizationFlag::Unsafe_IgnoreGlobalMonitor;
//    config.optimizations |= Dynarmic::OptimizationFlag::Unsafe_UnfuseFMA;
        config.optimizations |= Dynarmic::OptimizationFlag::Unsafe_ReducedErrorFP;
    }

    backend->num_page_table_entries = 1ULL << (PAGE_TABLE_ADDRESS_SPACE_BITS - DYN_PAGE_BITS);
    backend->page_table = page_table;
    if (page_table == MAP_FAILED) {
        size_t size = backend->num_page_table_entries * sizeof(void *);
        fprintf(stderr, "nativeInitialize mmap failed[%s->%s:%d] size=0x%zx, errno=%d, msg=%s\n", __FILE__,
                __func__, __LINE__, size, errno, strerror(errno));
        backend->page_table = nullptr;
    } else {
        callbacks->num_page_table_entries = backend->num_page_table_entries;
        callbacks->page_table = backend->page_table;

        config.dczid_el0 = 4;
        config.ctr_el0 = 0x8444c004;
        config.cntfrq_el0 = 19'200'000;

        // Unpredictable instructions
        config.define_unpredictable_behaviour = true;

        // Memory
        config.page_table = backend->page_table;
        config.page_table_address_space_bits = PAGE_TABLE_ADDRESS_SPACE_BITS;
        config.silently_mirror_page_table = false;
        config.absolute_offset_page_table = false;
        config.detect_misaligned_access_via_page_table = 16 | 32 | 64 | 128;
        config.only_detect_misalignment_via_page_table_on_page_boundary = true;

        config.fastmem_pointer = std::nullopt;
        config.fastmem_address_space_bits = PAGE_TABLE_ADDRESS_SPACE_BITS;
        config.silently_mirror_fastmem = false;

        config.fastmem_exclusive_access = config.fastmem_pointer.has_value();
        config.recompile_on_exclusive_fastmem_failure = true;
    }
    config.enable_cycle_counting = !config.wall_clock_cntpct;

    backend->cb64 = callbacks;
    backend->jit64 = new Dynarmic::A64::Jit(config);
    callbacks->cpu = backend->jit64;
    return backend;
}

FQL u64 dynarmic_get_cache_size(dynarmic* dynarmic) {
    return dynarmic->jit64->GetCacheSize();
}

FQL void dynarmic_destroy(dynarmic *dynarmic) {
    if (!dynarmic) {
        fprintf(stderr, "dynarmic_destroy failed[%s->%s:%d]: dynarmic is null\n", __FILE__, __func__, __LINE__);
        return;
    }
    khash_t(memory) *memory = dynarmic->memory;
    for (auto k = kh_begin(memory); k < kh_end(memory); k++) {
        if(kh_exist(memory, k)) {
            t_memory_page page = kh_value(memory, k);
            int ret = munmap(page->addr, DYN_PAGE_SIZE);
            if(ret != 0) {
                fprintf(stderr, "munmap failed[%s->%s:%d]: addr=%p, ret=%d\n", __FILE__, __func__, __LINE__, page->addr, ret);
            }
            free(page);
        }
    }
    kh_destroy(memory, memory);
    Dynarmic::A64::Jit *jit64 = dynarmic->jit64;
    delete jit64;
    delete dynarmic->cb64;
    if(dynarmic->page_table) {
        int ret = munmap(dynarmic->page_table, dynarmic->num_page_table_entries * sizeof(void*));
        if(ret != 0) {
            fprintf(stderr, "munmap failed[%s->%s:%d]: ret=%d\n", __FILE__, __func__, __LINE__, ret);
        }
    }
    delete dynarmic->monitor;
    free(dynarmic);
}

FQL void dynarmic_set_svc_callback(dynarmic *dynarmic, cb_call_svc cb, void* user_data) {
    if (!dynarmic) {
        fprintf(stderr, "dynarmic_set_svc_callback failed[%s->%s:%d]: dynarmic is null\n", __FILE__, __func__, __LINE__);
        return;
    }
    if(user_data == nullptr) {
        dynarmic->cb64->svc_callback = nullptr;
        dynarmic->cb64->svc_user_data = nullptr;
        return;
    }
    dynarmic->cb64->svc_callback = cb;
    dynarmic->cb64->svc_user_data = user_data;
    dynarmic->cb64->svc_callback(114514, user_data);
}

FQL int dynarmic_munmap(dynarmic* dynarmic, u64 address, u64 size) {
    if (!dynarmic) {
        fprintf(stderr, "dynarmic_munmap failed[%s->%s:%d]: dynarmic is null\n", __FILE__, __func__, __LINE__);
        return -1;
    }
    if(address & DYN_PAGE_MASK) {
        return 1;
    }
    if(size == 0 || (size & DYN_PAGE_MASK)) {
        return 2;
    }
    khash_t(memory) *memory = dynarmic->memory;
    for(u64 vaddr = address; vaddr < address + size; vaddr += DYN_PAGE_SIZE) {
        u64 idx = vaddr >> DYN_PAGE_BITS;
        khiter_t k = kh_get(memory, memory, vaddr);
        if(k == kh_end(memory)) {
            fprintf(stderr, "mem_unmap failed[%s->%s:%d]: vaddr=%p\n", __FILE__, __func__, __LINE__, (void*)vaddr);
            return 3;
        }
        if(dynarmic->page_table && idx < dynarmic->num_page_table_entries) {
            dynarmic->page_table[idx] = nullptr;
        }
        t_memory_page page = kh_value(memory, k);
        int ret = munmap(page->addr, DYN_PAGE_SIZE);
        if(ret != 0) {
            fprintf(stderr, "munmap failed[%s->%s:%d]: addr=%p, ret=%d\n", __FILE__, __func__, __LINE__, page->addr, ret);
        }
        free(page);
        kh_del(memory, memory, k);
    }
    return 0;
}

FQL int dynarmic_mmap(dynarmic* dynarmic, u64 address, u64 size, int perms) {
    if (!dynarmic) {
        fprintf(stderr, "dynarmic_mmap failed[%s->%s:%d]: dynarmic is null\n", __FILE__, __func__, __LINE__);
        return -1;
    }
    if(address & DYN_PAGE_MASK) {
        return 1;
    }
    if(size == 0 || (size & DYN_PAGE_MASK)) {
        return 2;
    }
    khash_t(memory) *memory = dynarmic->memory;
    int ret;
    for(u64 vaddr = address; vaddr < address + size; vaddr += DYN_PAGE_SIZE) {
        u64 idx = vaddr >> DYN_PAGE_BITS;
        if(kh_get(memory, memory, vaddr) != kh_end(memory)) {
            fprintf(stderr, "mem_map failed[%s->%s:%d]: vaddr=0x%p\n", __FILE__, __func__, __LINE__, (void*)vaddr);
            return 4;
        }

        void *addr = mmap(NULL, DYN_PAGE_SIZE, PROT_READ | PROT_WRITE, MAP_PRIVATE | MAP_ANONYMOUS, -1, 0);
        if(addr == MAP_FAILED) {
            fprintf(stderr, "mmap failed[%s->%s:%d]: addr=%p\n", __FILE__, __func__, __LINE__, (void*)addr);
            return 5;
        }
        if(dynarmic->page_table && idx < dynarmic->num_page_table_entries) {
            dynarmic->page_table[idx] = addr;
        } else {
            // 0xffffff80001f0000ULL: 0x10000
        }
        khiter_t k = kh_put(memory, memory, vaddr, &ret);
        auto page = (t_memory_page) malloc(sizeof(struct memory_page));
        if(page == nullptr) {
            fprintf(stderr, "malloc page failed: size=%llu\n", sizeof(struct memory_page));
            abort();
        }
        page->addr = addr;
        page->perms = perms;
        kh_value(memory, k) = page;
    }
    return 0;
}

FQL int dynarmic_mem_protect(dynarmic* dynarmic, u64 address, u64 size, int perms) {
    if (!dynarmic) {
        fprintf(stderr, "dynarmic_mem_protect failed[%s->%s:%d]: dynarmic is null\n", __FILE__, __func__, __LINE__);
        return -1;
    }
    if(address & DYN_PAGE_MASK) {
        return 1;
    }
    if(size == 0 || (size & DYN_PAGE_MASK)) {
        return 2;
    }
    khash_t(memory) *memory = dynarmic->memory;
    for(u64 vaddr = address; vaddr < address + size; vaddr += DYN_PAGE_SIZE) {
        khiter_t k = kh_get(memory, memory, vaddr);
        if(k == kh_end(memory)) {
            fprintf(stderr, "mem_protect failed[%s->%s:%d]: vaddr=%p\n", __FILE__, __func__, __LINE__, (void*)vaddr);
            return 3;
        }
        t_memory_page page = kh_value(memory, k);
        page->perms = perms;
    }
    return 0;
}

FQL int dynarmic_mem_write(dynarmic* dynarmic, u64 address, char* data, usize size) {
    if (!dynarmic) {
        fprintf(stderr, "dynarmic_mem_write failed[%s->%s:%d]: dynarmic is null\n", __FILE__, __func__, __LINE__);
        return -1;
    }
    khash_t(memory) *memory = dynarmic->memory;
    char *src = (char *)data;
    u64 vaddr_end = address + size;
    for(u64 vaddr = address & ~DYN_PAGE_MASK; vaddr < vaddr_end; vaddr += DYN_PAGE_SIZE) {
        u64 start = vaddr < address ? address - vaddr : 0;
        u64 end = vaddr + DYN_PAGE_SIZE <= vaddr_end ? DYN_PAGE_SIZE : (vaddr_end - vaddr);
        u64 len = end - start;
        char *addr = get_memory_page(memory, vaddr, dynarmic->num_page_table_entries, dynarmic->page_table);
        if(addr == nullptr) {
            fprintf(stderr, "mem_write failed[%s->%s:%d]: vaddr=%p\n", __FILE__, __func__, __LINE__, (void*)vaddr);
            return 1;
        }
        char *dest = &addr[start];
        memcpy(dest, src, len);
        src += len;
    }
    return 0;
}

FQL int dynarmic_mem_read(dynarmic* dynarmic, u64 address, char* bytes, usize size) {
    if (!dynarmic) {
        fprintf(stderr, "dynarmic_mem_read failed[%s->%s:%d]: dynarmic is null\n", __FILE__, __func__, __LINE__);
        return -1;
    }
    khash_t(memory) *memory = dynarmic->memory;
    u64 dest = 0;
    u64 vaddr_end = address + size;
    for(u64 vaddr = address & ~DYN_PAGE_MASK; vaddr < vaddr_end; vaddr += DYN_PAGE_SIZE) {
        u64 start = vaddr < address ? address - vaddr : 0;
        u64 end = vaddr + DYN_PAGE_SIZE <= vaddr_end ? DYN_PAGE_SIZE : (vaddr_end - vaddr);
        u64 len = end - start;
        char *addr = get_memory_page(memory, vaddr, dynarmic->num_page_table_entries, dynarmic->page_table);
        if(addr == nullptr) {
            fprintf(stderr, "mem_read failed[%s->%s:%d]: vaddr=%p\n", __FILE__, __func__, __LINE__, (void*)vaddr);
            return 1;
        }
        char *src = &addr[start];
        memcpy(&bytes[dest], src, len);
        dest += len;
    }
    return 0;
}

FQL u64 reg_read_pc(dynarmic* dynarmic) {
    return dynarmic->jit64->GetPC();
}

FQL int reg_write_pc(dynarmic* dynarmic, u64 value) {
    dynarmic->jit64->SetPC(value);
    return 0;
}

FQL int reg_write_sp(dynarmic* dynarmic, u64 value) {
    dynarmic->jit64->SetSP(value);
    return 0;
}

FQL u64 reg_read_sp(dynarmic* dynarmic) {
    return dynarmic->jit64->GetSP();
}

FQL u64 reg_read_nzcv(dynarmic* dynarmic) {
    return dynarmic->jit64->GetPstate();
}

FQL int reg_write_nzcv(dynarmic* dynarmic, u64 value) {
    dynarmic->jit64->SetPstate(value);
    return 0;
}

FQL int reg_write_tpidr_el0(dynarmic* dynarmic, u64 value) {
    if (!dynarmic) {
        return -1;
    }
    if(!dynarmic->cb64) {
        return -2;
    }
    dynarmic->cb64->tpidr_el0 = value;
    return 0;
}

FQL u64 reg_read_tpidr_el0(dynarmic* dynarmic) {
    if (!dynarmic) {
        return -1;
    }
    if(!dynarmic->cb64) {
        return -2;
    }
    return dynarmic->cb64->tpidr_el0;
}

FQL int reg_write_vector(dynarmic* dynarmic, u64 index, u64* array) {
    if (!dynarmic) {
        return -1;
    }
    if(!dynarmic->cb64) {
        return -2;
    }
    if(!array) {
        return -4;
    }
    auto* jit = dynarmic->jit64;
    jit->SetVector(index, {array[0], array[1]});
    return 0;
}

FQL int reg_read_vector(dynarmic* dynarmic, u64 index, u64* array) {
    if (!dynarmic) {
        return -1;
    }
    if(!dynarmic->cb64) {
        return -2;
    }
    if(!array) {
        return -4;
    }
    auto* jit = dynarmic->jit64;
    auto vector = jit->GetVector(index);
    array[0] = vector[0];
    array[1] = vector[1];
    return 0;
}

FQL int reg_write(dynarmic* dynarmic, u64 index, u64 value) {
    if (!dynarmic) {
        return -1;
    }
    if(!dynarmic->cb64) {
        return -2;
    }
    dynarmic->jit64->SetRegister(index, value);
    return 0;
}

FQL u64 reg_read(dynarmic* dynarmic, u64 index) {
    if (!dynarmic) {
        return -1;
    }
    if(!dynarmic->cb64) {
        return -2;
    }
    return dynarmic->jit64->GetRegister(index);
}

FQL int dynarmic_emu_start(dynarmic* dynarmic, u64 pc) {
    if (!dynarmic) {
        return -1;
    }
    if(!dynarmic->cb64) {
        return -2;
    }
    Dynarmic::A64::Jit *cpu = dynarmic->jit64;
    cpu->SetPC(pc);
    cpu->Run();
    return 0;
}

FQL int dynarmic_emu_stop(dynarmic* dynarmic) {
    if (!dynarmic) {
        return -1;
    }
    if(!dynarmic->cb64) {
        return -2;
    }
    dynarmic->jit64->HaltExecution();
    return 0;
}

FQL t_context64 dynarmic_context_alloc() {
    return (t_context64) malloc(sizeof(context64));
}

FQL void dynarmic_context_free(t_context64 context) {
    free(context);
}

FQL int dynarmic_context_restore(dynarmic* dynarmic, t_context64 context) {
    if (!context) {
        return -1;
    }
    Dynarmic::A64::Jit *jit = dynarmic->jit64;
    auto ctx = (t_context64) context;
    jit->SetSP(ctx->sp);
    jit->SetPC(ctx->pc);
    jit->SetRegisters(ctx->registers);
    jit->SetVectors(ctx->vectors);
    jit->SetFpcr(ctx->fpcr);
    jit->SetFpsr(ctx->fpsr);
    jit->SetPstate(ctx->pstate);

    DynarmicCallbacks64 *cb = dynarmic->cb64;
    cb->tpidr_el0 = ctx->tpidr_el0;
    cb->tpidrro_el0 = ctx->tpidrro_el0;
    return 0;
}

FQL int dynarmic_context_save(dynarmic* dynarmic, t_context64 context) {
    if (!context) {
        return -1;
    }
    Dynarmic::A64::Jit *jit = dynarmic->jit64;
    auto ctx = (t_context64) context;
    ctx->sp = jit->GetSP();
    ctx->pc = jit->GetPC();
    ctx->registers = jit->GetRegisters();
    ctx->vectors = jit->GetVectors();
    ctx->fpcr = jit->GetFpcr();
    ctx->fpsr = jit->GetFpsr();
    ctx->pstate = jit->GetPstate();

    DynarmicCallbacks64 *cb = dynarmic->cb64;
    ctx->tpidr_el0 = cb->tpidr_el0;
    ctx->tpidrro_el0 = cb->tpidrro_el0;
    return 0;
}

#pragma clang diagnostic pop
#pragma clang diagnostic pop
