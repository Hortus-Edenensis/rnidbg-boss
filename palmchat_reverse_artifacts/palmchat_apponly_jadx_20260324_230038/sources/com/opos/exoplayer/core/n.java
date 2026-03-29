package com.opos.exoplayer.core;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f8277a = new n(1.0f, 1.0f);
    public final float b;
    public final float c;
    private final int d;

    public n(float f, float f2) {
        com.opos.exoplayer.core.util.a.a(f > 0.0f);
        com.opos.exoplayer.core.util.a.a(f2 > 0.0f);
        this.b = f;
        this.c = f2;
        this.d = Math.round(f * 1000.0f);
    }

    public long a(long j) {
        return j * ((long) this.d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || n.class != obj.getClass()) {
            return false;
        }
        n nVar = (n) obj;
        return this.b == nVar.b && this.c == nVar.c;
    }

    public int hashCode() {
        return ((Float.floatToRawIntBits(this.b) + 527) * 31) + Float.floatToRawIntBits(this.c);
    }
}
