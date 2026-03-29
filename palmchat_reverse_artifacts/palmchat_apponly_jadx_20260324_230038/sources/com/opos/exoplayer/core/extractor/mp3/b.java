package com.opos.exoplayer.core.extractor.mp3;

import com.opos.exoplayer.core.extractor.j;
import com.opos.exoplayer.core.extractor.l;
import com.opos.exoplayer.core.extractor.m;
import com.opos.exoplayer.core.extractor.mp3.Mp3Extractor;
import com.opos.exoplayer.core.util.p;
import com.opos.exoplayer.core.util.y;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class b implements Mp3Extractor.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long[] f8196a;
    private final long[] b;
    private final long c;

    private b(long[] jArr, long[] jArr2, long j) {
        this.f8196a = jArr;
        this.b = jArr2;
        this.c = j;
    }

    @Override // com.opos.exoplayer.core.extractor.mp3.Mp3Extractor.b
    public long a(long j) {
        return this.f8196a[y.a(this.b, j, true, true)];
    }

    @Override // com.opos.exoplayer.core.extractor.l
    public long b() {
        return this.c;
    }

    public static b a(long j, long j2, j jVar, p pVar) {
        int iG;
        pVar.d(10);
        int iO = pVar.o();
        if (iO <= 0) {
            return null;
        }
        int i = jVar.d;
        long jD = y.d(iO, ((long) (i >= 32000 ? 1152 : 576)) * 1000000, i);
        int iH = pVar.h();
        int iH2 = pVar.h();
        int iH3 = pVar.h();
        pVar.d(2);
        long j3 = j2 + ((long) jVar.c);
        long[] jArr = new long[iH];
        long[] jArr2 = new long[iH];
        long j4 = j2;
        int i2 = 0;
        while (i2 < iH) {
            long j5 = j3;
            long j6 = jD;
            jArr[i2] = (((long) i2) * jD) / ((long) iH);
            jArr2[i2] = Math.max(j4, j5);
            if (iH3 == 1) {
                iG = pVar.g();
            } else if (iH3 == 2) {
                iG = pVar.h();
            } else if (iH3 == 3) {
                iG = pVar.k();
            } else {
                if (iH3 != 4) {
                    return null;
                }
                iG = pVar.u();
            }
            j4 += (long) (iG * iH2);
            i2++;
            j3 = j5;
            jD = j6;
        }
        long j7 = jD;
        if (j != -1 && j != j4) {
            com.opos.cmn.an.f.a.c("VbriSeeker", "VBRI data size mismatch: " + j + ", " + j4);
        }
        return new b(jArr, jArr2, j7);
    }

    @Override // com.opos.exoplayer.core.extractor.l
    public l.a b(long j) {
        int iA = y.a(this.f8196a, j, true, true);
        m mVar = new m(this.f8196a[iA], this.b[iA]);
        if (mVar.b < j) {
            long[] jArr = this.f8196a;
            if (iA != jArr.length - 1) {
                int i = iA + 1;
                return new l.a(mVar, new m(jArr[i], this.b[i]));
            }
        }
        return new l.a(mVar);
    }

    @Override // com.opos.exoplayer.core.extractor.l
    public boolean a() {
        return true;
    }
}
