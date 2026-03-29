package com.opos.exoplayer.core;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f8365a;
    public static final u b;
    public static final u c;
    public static final u d;
    public static final u e;
    public final long f;
    public final long g;

    static {
        u uVar = new u(0L, 0L);
        f8365a = uVar;
        b = new u(Long.MAX_VALUE, Long.MAX_VALUE);
        c = new u(Long.MAX_VALUE, 0L);
        d = new u(0L, Long.MAX_VALUE);
        e = uVar;
    }

    public u(long j, long j2) {
        com.opos.exoplayer.core.util.a.a(j >= 0);
        com.opos.exoplayer.core.util.a.a(j2 >= 0);
        this.f = j;
        this.g = j2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || u.class != obj.getClass()) {
            return false;
        }
        u uVar = (u) obj;
        return this.f == uVar.f && this.g == uVar.g;
    }

    public int hashCode() {
        return (((int) this.f) * 31) + ((int) this.g);
    }
}
