package com.opos.exoplayer.core.extractor.ts;

import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.a.a;
import com.opos.exoplayer.core.extractor.ts.s;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class b implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.opos.exoplayer.core.util.o f8225a;
    private final com.opos.exoplayer.core.util.p b;
    private final String c;
    private String d;
    private com.opos.exoplayer.core.extractor.n e;
    private int f;
    private int g;
    private boolean h;
    private long i;
    private Format j;
    private int k;
    private long l;

    public b() {
        this(null);
    }

    private void c() {
        this.f8225a.a(0);
        a.C0677a c0677aA = com.opos.exoplayer.core.a.a.a(this.f8225a);
        Format format = this.j;
        if (format == null || c0677aA.d != format.r || c0677aA.c != format.s || c0677aA.f8086a != format.f) {
            Format formatA = Format.a(this.d, c0677aA.f8086a, null, -1, -1, c0677aA.d, c0677aA.c, null, null, 0, this.c);
            this.j = formatA;
            this.e.a(formatA);
        }
        this.k = c0677aA.e;
        this.i = (((long) c0677aA.f) * 1000000) / ((long) this.j.s);
    }

    @Override // com.opos.exoplayer.core.extractor.ts.g
    public void a() {
        this.f = 0;
        this.g = 0;
        this.h = false;
    }

    @Override // com.opos.exoplayer.core.extractor.ts.g
    public void b() {
    }

    public b(String str) {
        com.opos.exoplayer.core.util.o oVar = new com.opos.exoplayer.core.util.o(new byte[128]);
        this.f8225a = oVar;
        this.b = new com.opos.exoplayer.core.util.p(oVar.f8399a);
        this.f = 0;
        this.c = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean b(com.opos.exoplayer.core.util.p pVar) {
        while (true) {
            boolean z = false;
            if (pVar.b() <= 0) {
                return false;
            }
            if (this.h) {
                int iG = pVar.g();
                if (iG == 119) {
                    this.h = false;
                    return true;
                }
                if (iG == 11) {
                }
            } else if (pVar.g() == 11) {
                z = true;
            }
            this.h = z;
        }
    }

    @Override // com.opos.exoplayer.core.extractor.ts.g
    public void a(long j, boolean z) {
        this.l = j;
    }

    @Override // com.opos.exoplayer.core.extractor.ts.g
    public void a(com.opos.exoplayer.core.extractor.g gVar, s.d dVar) {
        dVar.a();
        this.d = dVar.c();
        this.e = gVar.a(dVar.b(), 1);
    }

    @Override // com.opos.exoplayer.core.extractor.ts.g
    public void a(com.opos.exoplayer.core.util.p pVar) {
        while (pVar.b() > 0) {
            int i = this.f;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        int iMin = Math.min(pVar.b(), this.k - this.g);
                        this.e.a(pVar, iMin);
                        int i2 = this.g + iMin;
                        this.g = i2;
                        int i3 = this.k;
                        if (i2 == i3) {
                            this.e.a(this.l, 1, i3, 0, null);
                            this.l += this.i;
                            this.f = 0;
                        }
                    }
                } else if (a(pVar, this.b.f8400a, 128)) {
                    c();
                    this.b.c(0);
                    this.e.a(this.b, 128);
                    this.f = 2;
                }
            } else if (b(pVar)) {
                this.f = 1;
                byte[] bArr = this.b.f8400a;
                bArr[0] = 11;
                bArr[1] = 119;
                this.g = 2;
            }
        }
    }

    private boolean a(com.opos.exoplayer.core.util.p pVar, byte[] bArr, int i) {
        int iMin = Math.min(pVar.b(), i - this.g);
        pVar.a(bArr, this.g, iMin);
        int i2 = this.g + iMin;
        this.g = i2;
        return i2 == i;
    }
}
