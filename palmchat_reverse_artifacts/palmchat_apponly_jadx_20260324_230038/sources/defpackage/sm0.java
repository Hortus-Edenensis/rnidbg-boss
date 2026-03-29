package defpackage;

import defpackage.v45;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public class sm0 implements v45 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f20778a;
    public final long b;
    public final int c;
    public final long d;
    public final int e;
    public final long f;
    public final boolean g;

    public sm0(long j, long j2, int i, int i2, boolean z) {
        this.f20778a = j;
        this.b = j2;
        this.c = i2 == -1 ? 1 : i2;
        this.e = i;
        this.g = z;
        if (j == -1) {
            this.d = -1L;
            this.f = -9223372036854775807L;
        } else {
            this.d = j - j2;
            this.f = c(j, j2, i);
        }
    }

    public static long c(long j, long j2, int i) {
        return ((Math.max(0L, j - j2) * 8) * 1000000) / ((long) i);
    }

    public final long a(long j) {
        long j2 = (j * ((long) this.e)) / 8000000;
        int i = this.c;
        long jMin = (j2 / ((long) i)) * ((long) i);
        long j3 = this.d;
        if (j3 != -1) {
            jMin = Math.min(jMin, j3 - ((long) i));
        }
        return this.b + Math.max(jMin, 0L);
    }

    public long b(long j) {
        return c(j, this.b, this.e);
    }

    @Override // defpackage.v45
    public long getDurationUs() {
        return this.f;
    }

    @Override // defpackage.v45
    public v45.a getSeekPoints(long j) {
        if (this.d == -1 && !this.g) {
            return new v45.a(new x45(0L, this.b));
        }
        long jA = a(j);
        long jB = b(jA);
        x45 x45Var = new x45(jB, jA);
        if (this.d != -1 && jB < j) {
            int i = this.c;
            if (((long) i) + jA < this.f20778a) {
                long j2 = jA + ((long) i);
                return new v45.a(x45Var, new x45(b(j2), j2));
            }
        }
        return new v45.a(x45Var);
    }

    @Override // defpackage.v45
    public boolean isSeekable() {
        return this.d != -1 || this.g;
    }
}
