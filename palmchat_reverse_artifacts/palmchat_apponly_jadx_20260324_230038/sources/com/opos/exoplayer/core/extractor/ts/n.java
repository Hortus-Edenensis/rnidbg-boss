package com.opos.exoplayer.core.extractor.ts;

import com.opos.exoplayer.core.extractor.ts.s;
import com.opos.exoplayer.core.util.w;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class n implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g f8240a;
    private final com.opos.exoplayer.core.util.o b = new com.opos.exoplayer.core.util.o(new byte[10]);
    private int c = 0;
    private int d;
    private w e;
    private boolean f;
    private boolean g;
    private boolean h;
    private int i;
    private int j;
    private boolean k;
    private long l;

    public n(g gVar) {
        this.f8240a = gVar;
    }

    private boolean b() {
        this.b.a(0);
        int iC = this.b.c(24);
        if (iC != 1) {
            com.opos.cmn.an.f.a.c("PesReader", "Unexpected start code prefix: " + iC);
            this.j = -1;
            return false;
        }
        this.b.b(8);
        int iC2 = this.b.c(16);
        this.b.b(5);
        this.k = this.b.e();
        this.b.b(2);
        this.f = this.b.e();
        this.g = this.b.e();
        this.b.b(6);
        int iC3 = this.b.c(8);
        this.i = iC3;
        if (iC2 == 0) {
            this.j = -1;
        } else {
            this.j = ((iC2 + 6) - 9) - iC3;
        }
        return true;
    }

    private void c() {
        this.b.a(0);
        this.l = -9223372036854775807L;
        if (this.f) {
            this.b.b(4);
            long jC = ((long) this.b.c(3)) << 30;
            this.b.b(1);
            long jC2 = jC | ((long) (this.b.c(15) << 15));
            this.b.b(1);
            long jC3 = jC2 | ((long) this.b.c(15));
            this.b.b(1);
            if (!this.h && this.g) {
                this.b.b(4);
                long jC4 = ((long) this.b.c(3)) << 30;
                this.b.b(1);
                long jC5 = jC4 | ((long) (this.b.c(15) << 15));
                this.b.b(1);
                long jC6 = jC5 | ((long) this.b.c(15));
                this.b.b(1);
                this.e.d(jC6);
                this.h = true;
            }
            this.l = this.e.d(jC3);
        }
    }

    @Override // com.opos.exoplayer.core.extractor.ts.s
    public final void a() {
        this.c = 0;
        this.d = 0;
        this.h = false;
        this.f8240a.a();
    }

    private void a(int i) {
        this.c = i;
        this.d = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x006b -> B:32:0x006d). Please report as a decompilation issue!!! */
    @Override // com.opos.exoplayer.core.extractor.ts.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(com.opos.exoplayer.core.util.p pVar, boolean z) {
        if (z) {
            int i = this.c;
            if (i == 2) {
                com.opos.cmn.an.f.a.c("PesReader", "Unexpected start indicator reading extended header");
            } else if (i == 3) {
                if (this.j != -1) {
                    com.opos.cmn.an.f.a.c("PesReader", "Unexpected start indicator: expected " + this.j + " more bytes");
                }
            }
            a(1);
            while (pVar.b() > 0) {
            }
        }
        while (pVar.b() > 0) {
            int i2 = this.c;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        if (a(pVar, this.b.f8399a, Math.min(10, this.i)) && a(pVar, (byte[]) null, this.i)) {
                            c();
                            this.f8240a.a(this.l, this.k);
                            a(3);
                        }
                    } else if (i2 != 3) {
                        continue;
                    } else {
                        int iB = pVar.b();
                        int i3 = this.j;
                        int i4 = i3 != -1 ? iB - i3 : 0;
                        if (i4 > 0) {
                            iB -= i4;
                            pVar.b(pVar.d() + iB);
                        }
                        this.f8240a.a(pVar);
                        int i5 = this.j;
                        if (i5 != -1) {
                            int i6 = i5 - iB;
                            this.j = i6;
                            if (i6 == 0) {
                            }
                        } else {
                            continue;
                        }
                    }
                } else if (a(pVar, this.b.f8399a, 9)) {
                    a(b() ? 2 : 0);
                }
            } else {
                pVar.d(pVar.b());
            }
        }
        this.f8240a.b();
        a(1);
        while (pVar.b() > 0) {
        }
    }

    @Override // com.opos.exoplayer.core.extractor.ts.s
    public void a(w wVar, com.opos.exoplayer.core.extractor.g gVar, s.d dVar) {
        this.e = wVar;
        this.f8240a.a(gVar, dVar);
    }

    private boolean a(com.opos.exoplayer.core.util.p pVar, byte[] bArr, int i) {
        int iMin = Math.min(pVar.b(), i - this.d);
        if (iMin <= 0) {
            return true;
        }
        if (bArr == null) {
            pVar.d(iMin);
        } else {
            pVar.a(bArr, this.d, iMin);
        }
        int i2 = this.d + iMin;
        this.d = i2;
        return i2 == i;
    }
}
