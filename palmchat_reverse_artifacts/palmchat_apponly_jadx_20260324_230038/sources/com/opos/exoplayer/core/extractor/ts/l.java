package com.opos.exoplayer.core.extractor.ts;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.extractor.ts.s;
import java.util.Collections;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class l implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8238a;
    private final com.opos.exoplayer.core.util.p b;
    private final com.opos.exoplayer.core.util.o c;
    private com.opos.exoplayer.core.extractor.n d;
    private Format e;
    private String f;
    private int g;
    private int h;
    private int i;
    private int j;
    private long k;
    private boolean l;
    private int m;
    private int n;
    private int o;
    private boolean p;
    private long q;
    private int r;
    private long s;
    private int t;

    public l(@Nullable String str) {
        this.f8238a = str;
        com.opos.exoplayer.core.util.p pVar = new com.opos.exoplayer.core.util.p(1024);
        this.b = pVar;
        this.c = new com.opos.exoplayer.core.util.o(pVar.f8400a);
    }

    private void c(com.opos.exoplayer.core.util.o oVar) {
        int i;
        int iC = oVar.c(3);
        this.o = iC;
        if (iC == 0) {
            i = 8;
        } else {
            if (iC != 1) {
                if (iC == 3 || iC == 4 || iC == 5) {
                    oVar.b(6);
                    return;
                } else {
                    if (iC == 6 || iC == 7) {
                        oVar.b(1);
                        return;
                    }
                    return;
                }
            }
            i = 9;
        }
        oVar.b(i);
    }

    private int d(com.opos.exoplayer.core.util.o oVar) throws com.opos.exoplayer.core.m {
        int iA = oVar.a();
        Pair<Integer, Integer> pairA = com.opos.exoplayer.core.util.f.a(oVar, true);
        this.r = ((Integer) pairA.first).intValue();
        this.t = ((Integer) pairA.second).intValue();
        return iA - oVar.a();
    }

    private int e(com.opos.exoplayer.core.util.o oVar) throws com.opos.exoplayer.core.m {
        int iC;
        if (this.o != 0) {
            throw new com.opos.exoplayer.core.m();
        }
        int i = 0;
        do {
            iC = oVar.c(8);
            i += iC;
        } while (iC == 255);
        return i;
    }

    private static long f(com.opos.exoplayer.core.util.o oVar) {
        return oVar.c((oVar.c(2) + 1) * 8);
    }

    @Override // com.opos.exoplayer.core.extractor.ts.g
    public void a() {
        this.g = 0;
        this.l = false;
    }

    @Override // com.opos.exoplayer.core.extractor.ts.g
    public void b() {
    }

    private void a(int i) {
        this.b.a(i);
        this.c.a(this.b.f8400a);
    }

    private void b(com.opos.exoplayer.core.util.o oVar) throws com.opos.exoplayer.core.m {
        boolean zE;
        int iC = oVar.c(1);
        int iC2 = iC == 1 ? oVar.c(1) : 0;
        this.m = iC2;
        if (iC2 != 0) {
            throw new com.opos.exoplayer.core.m();
        }
        if (iC == 1) {
            f(oVar);
        }
        if (!oVar.e()) {
            throw new com.opos.exoplayer.core.m();
        }
        this.n = oVar.c(6);
        int iC3 = oVar.c(4);
        int iC4 = oVar.c(3);
        if (iC3 != 0 || iC4 != 0) {
            throw new com.opos.exoplayer.core.m();
        }
        if (iC == 0) {
            int iB = oVar.b();
            int iD = d(oVar);
            oVar.a(iB);
            byte[] bArr = new byte[(iD + 7) / 8];
            oVar.a(bArr, 0, iD);
            Format formatA = Format.a(this.f, "audio/mp4a-latm", null, -1, -1, this.t, this.r, Collections.singletonList(bArr), null, 0, this.f8238a);
            if (!formatA.equals(this.e)) {
                this.e = formatA;
                this.s = 1024000000 / ((long) formatA.s);
                this.d.a(formatA);
            }
        } else {
            oVar.b(((int) f(oVar)) - d(oVar));
        }
        c(oVar);
        boolean zE2 = oVar.e();
        this.p = zE2;
        this.q = 0L;
        if (zE2) {
            if (iC == 1) {
                this.q = f(oVar);
            } else {
                do {
                    zE = oVar.e();
                    this.q = (this.q << 8) + ((long) oVar.c(8));
                } while (zE);
            }
        }
        if (oVar.e()) {
            oVar.b(8);
        }
    }

    @Override // com.opos.exoplayer.core.extractor.ts.g
    public void a(long j, boolean z) {
        this.k = j;
    }

    @Override // com.opos.exoplayer.core.extractor.ts.g
    public void a(com.opos.exoplayer.core.extractor.g gVar, s.d dVar) {
        dVar.a();
        this.d = gVar.a(dVar.b(), 1);
        this.f = dVar.c();
    }

    private void a(com.opos.exoplayer.core.util.o oVar) throws com.opos.exoplayer.core.m {
        if (!oVar.e()) {
            this.l = true;
            b(oVar);
        } else if (!this.l) {
            return;
        }
        if (this.m != 0) {
            throw new com.opos.exoplayer.core.m();
        }
        if (this.n != 0) {
            throw new com.opos.exoplayer.core.m();
        }
        a(oVar, e(oVar));
        if (this.p) {
            oVar.b((int) this.q);
        }
    }

    private void a(com.opos.exoplayer.core.util.o oVar, int i) {
        int iB = oVar.b();
        if ((iB & 7) == 0) {
            this.b.c(iB >> 3);
        } else {
            oVar.a(this.b.f8400a, 0, i * 8);
            this.b.c(0);
        }
        this.d.a(this.b, i);
        this.d.a(this.k, 1, i, 0, null);
        this.k += this.s;
    }

    @Override // com.opos.exoplayer.core.extractor.ts.g
    public void a(com.opos.exoplayer.core.util.p pVar) throws com.opos.exoplayer.core.m {
        while (pVar.b() > 0) {
            int i = this.g;
            if (i != 0) {
                if (i == 1) {
                    int iG = pVar.g();
                    if ((iG & 224) == 224) {
                        this.j = iG;
                        this.g = 2;
                    } else if (iG != 86) {
                        this.g = 0;
                    }
                } else if (i == 2) {
                    int iG2 = ((this.j & (-225)) << 8) | pVar.g();
                    this.i = iG2;
                    if (iG2 > this.b.f8400a.length) {
                        a(iG2);
                    }
                    this.h = 0;
                    this.g = 3;
                } else if (i == 3) {
                    int iMin = Math.min(pVar.b(), this.i - this.h);
                    pVar.a(this.c.f8399a, this.h, iMin);
                    int i2 = this.h + iMin;
                    this.h = i2;
                    if (i2 == this.i) {
                        this.c.a(0);
                        a(this.c);
                        this.g = 0;
                    }
                }
            } else if (pVar.g() == 86) {
                this.g = 1;
            }
        }
    }
}
