package com.opos.exoplayer.core.c;

import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.source.o;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public abstract class b implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final o f8119a;
    protected final int b;
    protected final int[] c;
    private final Format[] d;
    private final long[] e;
    private int f;

    /* JADX INFO: renamed from: com.opos.exoplayer.core.c.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static final class C0683b implements Comparator<Format> {
        private C0683b() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Format format, Format format2) {
            return format2.b - format.b;
        }
    }

    public b(o oVar, int... iArr) {
        int i = 0;
        com.opos.exoplayer.core.util.a.b(iArr.length > 0);
        this.f8119a = (o) com.opos.exoplayer.core.util.a.a(oVar);
        int length = iArr.length;
        this.b = length;
        this.d = new Format[length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            this.d[i2] = oVar.a(iArr[i2]);
        }
        Arrays.sort(this.d, new C0683b());
        this.c = new int[this.b];
        while (true) {
            int i3 = this.b;
            if (i >= i3) {
                this.e = new long[i3];
                return;
            } else {
                this.c[i] = oVar.a(this.d[i]);
                i++;
            }
        }
    }

    @Override // com.opos.exoplayer.core.c.f
    public final Format a(int i) {
        return this.d[i];
    }

    @Override // com.opos.exoplayer.core.c.f
    public final int b(int i) {
        return this.c[i];
    }

    @Override // com.opos.exoplayer.core.c.f
    public final o d() {
        return this.f8119a;
    }

    @Override // com.opos.exoplayer.core.c.f
    public final int e() {
        return this.c.length;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f8119a == bVar.f8119a && Arrays.equals(this.c, bVar.c);
    }

    @Override // com.opos.exoplayer.core.c.f
    public final Format f() {
        return this.d[b()];
    }

    public int hashCode() {
        if (this.f == 0) {
            this.f = (System.identityHashCode(this.f8119a) * 31) + Arrays.hashCode(this.c);
        }
        return this.f;
    }

    @Override // com.opos.exoplayer.core.c.f
    public void a() {
    }

    @Override // com.opos.exoplayer.core.c.f
    public void a(float f) {
    }

    public final boolean a(int i, long j) {
        return this.e[i] > j;
    }

    @Override // com.opos.exoplayer.core.c.f
    public void c() {
    }
}
