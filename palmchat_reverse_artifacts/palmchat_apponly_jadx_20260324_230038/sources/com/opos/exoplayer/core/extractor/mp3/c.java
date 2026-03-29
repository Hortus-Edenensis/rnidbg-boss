package com.opos.exoplayer.core.extractor.mp3;

import com.opos.exoplayer.core.extractor.j;
import com.opos.exoplayer.core.extractor.l;
import com.opos.exoplayer.core.extractor.m;
import com.opos.exoplayer.core.extractor.mp3.Mp3Extractor;
import com.opos.exoplayer.core.util.p;
import com.opos.exoplayer.core.util.y;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class c implements Mp3Extractor.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f8197a;
    private final int b;
    private final long c;
    private final long d;
    private final long[] e;

    private c(long j, int i, long j2) {
        this(j, i, j2, -1L, null);
    }

    private long a(int i) {
        return (this.c * ((long) i)) / 100;
    }

    @Override // com.opos.exoplayer.core.extractor.l
    public long b() {
        return this.c;
    }

    private c(long j, int i, long j2, long j3, long[] jArr) {
        this.f8197a = j;
        this.b = i;
        this.c = j2;
        this.d = j3;
        this.e = jArr;
    }

    @Override // com.opos.exoplayer.core.extractor.mp3.Mp3Extractor.b
    public long a(long j) {
        long j2 = j - this.f8197a;
        if (!a() || j2 <= this.b) {
            return 0L;
        }
        double d = (j2 * 256.0d) / this.d;
        int iA = y.a(this.e, (long) d, true, true);
        long jA = a(iA);
        long j3 = this.e[iA];
        int i = iA + 1;
        long jA2 = a(i);
        return jA + Math.round((j3 == (iA == 99 ? 256L : this.e[i]) ? 0.0d : (d - j3) / (r8 - j3)) * (jA2 - jA));
    }

    @Override // com.opos.exoplayer.core.extractor.l
    public l.a b(long j) {
        if (!a()) {
            return new l.a(new m(0L, this.f8197a + ((long) this.b)));
        }
        long jA = y.a(j, 0L, this.c);
        double d = (jA * 100.0d) / this.c;
        double d2 = 0.0d;
        if (d > 0.0d) {
            if (d >= 100.0d) {
                d2 = 256.0d;
            } else {
                int i = (int) d;
                double d3 = this.e[i];
                d2 = d3 + ((d - ((double) i)) * ((i == 99 ? 256.0d : r3[i + 1]) - d3));
            }
        }
        return new l.a(new m(jA, this.f8197a + y.a(Math.round((d2 / 256.0d) * this.d), this.b, this.d - 1)));
    }

    public static c a(long j, long j2, j jVar, p pVar) {
        int iU;
        int i = jVar.g;
        int i2 = jVar.d;
        int iO = pVar.o();
        if ((iO & 1) != 1 || (iU = pVar.u()) == 0) {
            return null;
        }
        long jD = y.d(iU, ((long) i) * 1000000, i2);
        if ((iO & 6) != 6) {
            return new c(j2, jVar.c, jD);
        }
        long jU = pVar.u();
        long[] jArr = new long[100];
        for (int i3 = 0; i3 < 100; i3++) {
            jArr[i3] = pVar.g();
        }
        if (j != -1) {
            long j3 = j2 + jU;
            if (j != j3) {
                com.opos.cmn.an.f.a.c("XingSeeker", "XING data size mismatch: " + j + ", " + j3);
            }
        }
        return new c(j2, jVar.c, jD, jU, jArr);
    }

    @Override // com.opos.exoplayer.core.extractor.l
    public boolean a() {
        return this.e != null;
    }
}
