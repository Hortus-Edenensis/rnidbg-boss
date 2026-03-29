package com.opos.exoplayer.core.extractor.ts;

import android.util.Pair;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.drm.DrmInitData;
import com.opos.exoplayer.core.extractor.ts.s;
import java.util.Arrays;
import java.util.Collections;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class d implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f8227a = {73, 68, 51};
    private final boolean b;
    private final com.opos.exoplayer.core.util.o c;
    private final com.opos.exoplayer.core.util.p d;
    private final String e;
    private String f;
    private com.opos.exoplayer.core.extractor.n g;
    private com.opos.exoplayer.core.extractor.n h;
    private int i;
    private int j;
    private int k;
    private boolean l;
    private boolean m;
    private long n;
    private int o;
    private long p;
    private com.opos.exoplayer.core.extractor.n q;
    private long r;

    public d(boolean z) {
        this(z, null);
    }

    private void c() {
        this.i = 0;
        this.j = 0;
        this.k = 256;
    }

    private void d() {
        this.i = 1;
        this.j = f8227a.length;
        this.o = 0;
        this.d.c(0);
    }

    private void e() {
        this.i = 2;
        this.j = 0;
    }

    private void f() {
        this.h.a(this.d, 10);
        this.d.c(6);
        a(this.h, 0L, 10, this.d.t() + 10);
    }

    private void g() {
        this.c.a(0);
        if (this.m) {
            this.c.b(10);
        } else {
            int iC = this.c.c(2) + 1;
            if (iC != 2) {
                com.opos.cmn.an.f.a.c("AdtsReader", "Detected audio object type: " + iC + ", but assuming AAC LC.");
                iC = 2;
            }
            int iC2 = this.c.c(4);
            this.c.b(1);
            byte[] bArrA = com.opos.exoplayer.core.util.f.a(iC, iC2, this.c.c(3));
            Pair<Integer, Integer> pairA = com.opos.exoplayer.core.util.f.a(bArrA);
            Format formatA = Format.a(this.f, "audio/mp4a-latm", null, -1, -1, ((Integer) pairA.second).intValue(), ((Integer) pairA.first).intValue(), Collections.singletonList(bArrA), null, 0, this.e);
            this.n = 1024000000 / ((long) formatA.s);
            this.g.a(formatA);
            this.m = true;
        }
        this.c.b(4);
        int iC3 = (this.c.c(13) - 2) - 5;
        if (this.l) {
            iC3 -= 2;
        }
        a(this.g, this.n, 0, iC3);
    }

    @Override // com.opos.exoplayer.core.extractor.ts.g
    public void a() {
        c();
    }

    @Override // com.opos.exoplayer.core.extractor.ts.g
    public void b() {
    }

    public d(boolean z, String str) {
        this.c = new com.opos.exoplayer.core.util.o(new byte[7]);
        this.d = new com.opos.exoplayer.core.util.p(Arrays.copyOf(f8227a, 10));
        c();
        this.b = z;
        this.e = str;
    }

    private void b(com.opos.exoplayer.core.util.p pVar) {
        int i;
        byte[] bArr = pVar.f8400a;
        int iD = pVar.d();
        int iC = pVar.c();
        while (iD < iC) {
            int i2 = iD + 1;
            int i3 = bArr[iD] & UByte.MAX_VALUE;
            int i4 = this.k;
            if (i4 != 512 || i3 < 240 || i3 == 255) {
                int i5 = i3 | i4;
                if (i5 != 329) {
                    if (i5 == 511) {
                        this.k = 512;
                    } else if (i5 == 836) {
                        i = 1024;
                    } else if (i5 == 1075) {
                        d();
                    } else if (i4 != 256) {
                        this.k = 256;
                        iD = i2 - 1;
                    }
                    iD = i2;
                } else {
                    i = 768;
                }
                this.k = i;
                iD = i2;
            } else {
                this.l = (i3 & 1) == 0;
                e();
            }
            pVar.c(i2);
            return;
        }
        pVar.c(iD);
    }

    private void c(com.opos.exoplayer.core.util.p pVar) {
        int iMin = Math.min(pVar.b(), this.o - this.j);
        this.q.a(pVar, iMin);
        int i = this.j + iMin;
        this.j = i;
        int i2 = this.o;
        if (i == i2) {
            this.q.a(this.p, 1, i2, 0, null);
            this.p += this.r;
            c();
        }
    }

    @Override // com.opos.exoplayer.core.extractor.ts.g
    public void a(long j, boolean z) {
        this.p = j;
    }

    @Override // com.opos.exoplayer.core.extractor.ts.g
    public void a(com.opos.exoplayer.core.extractor.g gVar, s.d dVar) {
        dVar.a();
        this.f = dVar.c();
        this.g = gVar.a(dVar.b(), 1);
        if (!this.b) {
            this.h = new com.opos.exoplayer.core.extractor.d();
            return;
        }
        dVar.a();
        com.opos.exoplayer.core.extractor.n nVarA = gVar.a(dVar.b(), 4);
        this.h = nVarA;
        nVarA.a(Format.a(dVar.c(), "application/id3", (String) null, -1, (DrmInitData) null));
    }

    private void a(com.opos.exoplayer.core.extractor.n nVar, long j, int i, int i2) {
        this.i = 3;
        this.j = i;
        this.q = nVar;
        this.r = j;
        this.o = i2;
    }

    @Override // com.opos.exoplayer.core.extractor.ts.g
    public void a(com.opos.exoplayer.core.util.p pVar) {
        while (pVar.b() > 0) {
            int i = this.i;
            if (i == 0) {
                b(pVar);
            } else if (i != 1) {
                if (i == 2) {
                    if (a(pVar, this.c.f8399a, this.l ? 7 : 5)) {
                        g();
                    }
                } else if (i == 3) {
                    c(pVar);
                }
            } else if (a(pVar, this.d.f8400a, 10)) {
                f();
            }
        }
    }

    private boolean a(com.opos.exoplayer.core.util.p pVar, byte[] bArr, int i) {
        int iMin = Math.min(pVar.b(), i - this.j);
        pVar.a(bArr, this.j, iMin);
        int i2 = this.j + iMin;
        this.j = i2;
        return i2 == i;
    }
}
