package defpackage;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class w45 {
    public static final w45 c;
    public static final w45 d;
    public static final w45 e;
    public static final w45 f;
    public static final w45 g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f21618a;
    public final long b;

    static {
        w45 w45Var = new w45(0L, 0L);
        c = w45Var;
        d = new w45(Long.MAX_VALUE, Long.MAX_VALUE);
        e = new w45(Long.MAX_VALUE, 0L);
        f = new w45(0L, Long.MAX_VALUE);
        g = w45Var;
    }

    public w45(long j, long j2) {
        vh.a(j >= 0);
        vh.a(j2 >= 0);
        this.f21618a = j;
        this.b = j2;
    }

    public long a(long j, long j2, long j3) {
        long j4 = this.f21618a;
        if (j4 == 0 && this.b == 0) {
            return j;
        }
        long jD1 = g86.d1(j, j4, Long.MIN_VALUE);
        long jB = g86.b(j, this.b, Long.MAX_VALUE);
        boolean z = jD1 <= j2 && j2 <= jB;
        boolean z2 = jD1 <= j3 && j3 <= jB;
        return (z && z2) ? Math.abs(j2 - j) <= Math.abs(j3 - j) ? j2 : j3 : z ? j2 : z2 ? j3 : jD1;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || w45.class != obj.getClass()) {
            return false;
        }
        w45 w45Var = (w45) obj;
        return this.f21618a == w45Var.f21618a && this.b == w45Var.b;
    }

    public int hashCode() {
        return (((int) this.f21618a) * 31) + ((int) this.b);
    }
}
