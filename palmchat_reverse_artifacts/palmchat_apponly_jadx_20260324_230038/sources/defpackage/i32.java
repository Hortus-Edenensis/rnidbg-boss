package defpackage;

import java.util.UUID;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class i32 implements hr0 {
    public static final boolean d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UUID f18096a;
    public final byte[] b;
    public final boolean c;

    /* JADX WARN: Removed duplicated region for block: B:9:0x001e  */
    static {
        boolean z;
        if ("Amazon".equals(g86.c)) {
            String str = g86.d;
            z = "AFTM".equals(str) || "AFTB".equals(str);
        }
        d = z;
    }

    public i32(UUID uuid, byte[] bArr, boolean z) {
        this.f18096a = uuid;
        this.b = bArr;
        this.c = z;
    }
}
