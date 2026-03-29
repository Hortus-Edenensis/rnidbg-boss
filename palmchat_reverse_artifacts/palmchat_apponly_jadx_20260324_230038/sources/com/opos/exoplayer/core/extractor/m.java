package com.opos.exoplayer.core.extractor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f8185a = new m(0, 0);
    public final long b;
    public final long c;

    public m(long j, long j2) {
        this.b = j;
        this.c = j2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || m.class != obj.getClass()) {
            return false;
        }
        m mVar = (m) obj;
        return this.b == mVar.b && this.c == mVar.c;
    }

    public int hashCode() {
        return (((int) this.b) * 31) + ((int) this.c);
    }

    public String toString() {
        return "[timeUs=" + this.b + ", position=" + this.c + "]";
    }
}
