package com.opos.exoplayer.core.source;

import com.opos.exoplayer.core.w;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class n extends w {
    private static final Object b = new Object();
    private final long c;
    private final long d;
    private final long e;
    private final long f;
    private final long g;
    private final long h;
    private final boolean i;
    private final boolean j;

    public n(long j, long j2, long j3, long j4, long j5, long j6, boolean z, boolean z2) {
        this.c = j;
        this.d = j2;
        this.e = j3;
        this.f = j4;
        this.g = j5;
        this.h = j6;
        this.i = z;
        this.j = z2;
    }

    @Override // com.opos.exoplayer.core.w
    public int a(Object obj) {
        return b.equals(obj) ? 0 : -1;
    }

    @Override // com.opos.exoplayer.core.w
    public int b() {
        return 1;
    }

    @Override // com.opos.exoplayer.core.w
    public int c() {
        return 1;
    }

    public n(long j, long j2, long j3, long j4, boolean z, boolean z2) {
        this(-9223372036854775807L, -9223372036854775807L, j, j2, j3, j4, z, z2);
    }

    @Override // com.opos.exoplayer.core.w
    public w.a a(int i, w.a aVar, boolean z) {
        com.opos.exoplayer.core.util.a.a(i, 0, 1);
        Object obj = z ? b : null;
        return aVar.a(obj, obj, 0, this.e, -this.g);
    }

    public n(long j, boolean z, boolean z2) {
        this(j, j, 0L, 0L, z, z2);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0030 A[PHI: r1
      0x0030: PHI (r1v4 long) = (r1v3 long), (r1v3 long), (r1v7 long) binds: [B:7:0x0014, B:9:0x001a, B:14:0x002c] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.opos.exoplayer.core.w
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public w.b a(int i, w.b bVar, boolean z, long j) {
        long j2;
        com.opos.exoplayer.core.util.a.a(i, 0, 1);
        Object obj = z ? b : null;
        long j3 = this.h;
        boolean z2 = this.j;
        if (!z2 || j == 0) {
            j2 = j3;
        } else {
            long j4 = this.f;
            if (j4 != -9223372036854775807L) {
                j3 += j;
                if (j3 > j4) {
                }
            }
            j2 = -9223372036854775807L;
        }
        return bVar.a(obj, this.c, this.d, this.i, z2, j2, this.f, 0, 0, this.g);
    }
}
