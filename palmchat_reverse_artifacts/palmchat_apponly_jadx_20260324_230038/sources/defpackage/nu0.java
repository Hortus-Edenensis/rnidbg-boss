package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class nu0 {
    private static final /* synthetic */ nu0[] $VALUES;
    public static final nu0 DATA_MASK_000;
    public static final nu0 DATA_MASK_001;
    public static final nu0 DATA_MASK_010;
    public static final nu0 DATA_MASK_011;
    public static final nu0 DATA_MASK_100;
    public static final nu0 DATA_MASK_101;
    public static final nu0 DATA_MASK_110;
    public static final nu0 DATA_MASK_111;

    /* JADX INFO: compiled from: SearchBox */
    public enum a extends nu0 {
        public a(String str, int i) {
            super(str, i, null);
        }

        @Override // defpackage.nu0
        public boolean isMasked(int i, int i2) {
            return ((i + i2) & 1) == 0;
        }
    }

    static {
        a aVar = new a("DATA_MASK_000", 0);
        DATA_MASK_000 = aVar;
        nu0 nu0Var = new nu0("DATA_MASK_001", 1) { // from class: nu0.b
            {
                a aVar2 = null;
            }

            @Override // defpackage.nu0
            public boolean isMasked(int i, int i2) {
                return (i & 1) == 0;
            }
        };
        DATA_MASK_001 = nu0Var;
        nu0 nu0Var2 = new nu0("DATA_MASK_010", 2) { // from class: nu0.c
            {
                a aVar2 = null;
            }

            @Override // defpackage.nu0
            public boolean isMasked(int i, int i2) {
                return i2 % 3 == 0;
            }
        };
        DATA_MASK_010 = nu0Var2;
        nu0 nu0Var3 = new nu0("DATA_MASK_011", 3) { // from class: nu0.d
            {
                a aVar2 = null;
            }

            @Override // defpackage.nu0
            public boolean isMasked(int i, int i2) {
                return (i + i2) % 3 == 0;
            }
        };
        DATA_MASK_011 = nu0Var3;
        nu0 nu0Var4 = new nu0("DATA_MASK_100", 4) { // from class: nu0.e
            {
                a aVar2 = null;
            }

            @Override // defpackage.nu0
            public boolean isMasked(int i, int i2) {
                return (((i / 2) + (i2 / 3)) & 1) == 0;
            }
        };
        DATA_MASK_100 = nu0Var4;
        nu0 nu0Var5 = new nu0("DATA_MASK_101", 5) { // from class: nu0.f
            {
                a aVar2 = null;
            }

            @Override // defpackage.nu0
            public boolean isMasked(int i, int i2) {
                int i3 = i * i2;
                return (i3 & 1) + (i3 % 3) == 0;
            }
        };
        DATA_MASK_101 = nu0Var5;
        nu0 nu0Var6 = new nu0("DATA_MASK_110", 6) { // from class: nu0.g
            {
                a aVar2 = null;
            }

            @Override // defpackage.nu0
            public boolean isMasked(int i, int i2) {
                int i3 = i * i2;
                return (((i3 & 1) + (i3 % 3)) & 1) == 0;
            }
        };
        DATA_MASK_110 = nu0Var6;
        nu0 nu0Var7 = new nu0("DATA_MASK_111", 7) { // from class: nu0.h
            {
                a aVar2 = null;
            }

            @Override // defpackage.nu0
            public boolean isMasked(int i, int i2) {
                return ((((i + i2) & 1) + ((i * i2) % 3)) & 1) == 0;
            }
        };
        DATA_MASK_111 = nu0Var7;
        $VALUES = new nu0[]{aVar, nu0Var, nu0Var2, nu0Var3, nu0Var4, nu0Var5, nu0Var6, nu0Var7};
    }

    private nu0(String str, int i) {
    }

    public static nu0 valueOf(String str) {
        return (nu0) Enum.valueOf(nu0.class, str);
    }

    public static nu0[] values() {
        return (nu0[]) $VALUES.clone();
    }

    public abstract boolean isMasked(int i, int i2);

    public final void unmaskBitMatrix(ht htVar, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            for (int i3 = 0; i3 < i; i3++) {
                if (isMasked(i2, i3)) {
                    htVar.d(i3, i2);
                }
            }
        }
    }

    public /* synthetic */ nu0(String str, int i, a aVar) {
        this(str, i);
    }
}
