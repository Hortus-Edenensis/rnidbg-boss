package defpackage;

import androidx.annotation.Nullable;
import defpackage.as3;
import defpackage.v45;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class bp6 implements y45 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f1798a;
    public final int b;
    public final long c;
    public final long d;
    public final long e;

    @Nullable
    public final long[] f;

    public bp6(long j, int i, long j2) {
        this(j, i, j2, -1L, null);
    }

    @Nullable
    public static bp6 a(long j, long j2, as3.a aVar, gc4 gc4Var) {
        int iL;
        int i = aVar.g;
        int i2 = aVar.d;
        int iQ = gc4Var.q();
        if ((iQ & 1) != 1 || (iL = gc4Var.L()) == 0) {
            return null;
        }
        long jU0 = g86.U0(iL, ((long) i) * 1000000, i2);
        if ((iQ & 6) != 6) {
            return new bp6(j2, aVar.c, jU0);
        }
        long J = gc4Var.J();
        long[] jArr = new long[100];
        for (int i3 = 0; i3 < 100; i3++) {
            jArr[i3] = gc4Var.H();
        }
        if (j != -1) {
            long j3 = j2 + J;
            if (j != j3) {
                y53.i("XingSeeker", "XING data size mismatch: " + j + ", " + j3);
            }
        }
        return new bp6(j2, aVar.c, jU0, J, jArr);
    }

    public final long b(int i) {
        return (this.c * ((long) i)) / 100;
    }

    @Override // defpackage.y45
    public long getDataEndPosition() {
        return this.e;
    }

    @Override // defpackage.v45
    public long getDurationUs() {
        return this.c;
    }

    @Override // defpackage.v45
    public v45.a getSeekPoints(long j) {
        if (!isSeekable()) {
            return new v45.a(new x45(0L, this.f1798a + ((long) this.b)));
        }
        long jR = g86.r(j, 0L, this.c);
        double d = (jR * 100.0d) / this.c;
        double d2 = 0.0d;
        if (d > 0.0d) {
            if (d >= 100.0d) {
                d2 = 256.0d;
            } else {
                int i = (int) d;
                double d3 = ((long[]) vh.i(this.f))[i];
                d2 = d3 + ((d - ((double) i)) * ((i == 99 ? 256.0d : r3[i + 1]) - d3));
            }
        }
        return new v45.a(new x45(jR, this.f1798a + g86.r(Math.round((d2 / 256.0d) * this.d), this.b, this.d - 1)));
    }

    @Override // defpackage.y45
    public long getTimeUs(long j) {
        long j2 = j - this.f1798a;
        if (!isSeekable() || j2 <= this.b) {
            return 0L;
        }
        long[] jArr = (long[]) vh.i(this.f);
        double d = (j2 * 256.0d) / this.d;
        int i = g86.i(jArr, (long) d, true, true);
        long jB = b(i);
        long j3 = jArr[i];
        int i2 = i + 1;
        long jB2 = b(i2);
        return jB + Math.round((j3 == (i == 99 ? 256L : jArr[i2]) ? 0.0d : (d - j3) / (r0 - j3)) * (jB2 - jB));
    }

    @Override // defpackage.v45
    public boolean isSeekable() {
        return this.f != null;
    }

    public bp6(long j, int i, long j2, long j3, @Nullable long[] jArr) {
        this.f1798a = j;
        this.b = i;
        this.c = j2;
        this.f = jArr;
        this.d = j3;
        this.e = j3 != -1 ? j + j3 : -1L;
    }
}
