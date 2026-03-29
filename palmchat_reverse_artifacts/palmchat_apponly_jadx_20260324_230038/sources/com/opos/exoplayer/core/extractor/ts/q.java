package com.opos.exoplayer.core.extractor.ts;

import com.opos.exoplayer.core.extractor.ts.s;
import com.opos.exoplayer.core.util.w;
import com.opos.exoplayer.core.util.y;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class q implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p f8243a;
    private final com.opos.exoplayer.core.util.p b = new com.opos.exoplayer.core.util.p(32);
    private int c;
    private int d;
    private boolean e;
    private boolean f;

    public q(p pVar) {
        this.f8243a = pVar;
    }

    @Override // com.opos.exoplayer.core.extractor.ts.s
    public void a() {
        this.f = true;
    }

    @Override // com.opos.exoplayer.core.extractor.ts.s
    public void a(com.opos.exoplayer.core.util.p pVar, boolean z) {
        int iD = z ? pVar.d() + pVar.g() : -1;
        if (this.f) {
            if (!z) {
                return;
            }
            this.f = false;
            pVar.c(iD);
            this.d = 0;
        }
        while (pVar.b() > 0) {
            int i = this.d;
            if (i < 3) {
                if (i == 0) {
                    int iG = pVar.g();
                    pVar.c(pVar.d() - 1);
                    if (iG == 255) {
                        this.f = true;
                        return;
                    }
                }
                int iMin = Math.min(pVar.b(), 3 - this.d);
                pVar.a(this.b.f8400a, this.d, iMin);
                int i2 = this.d + iMin;
                this.d = i2;
                if (i2 == 3) {
                    this.b.a(3);
                    this.b.d(1);
                    int iG2 = this.b.g();
                    int iG3 = this.b.g();
                    this.e = (iG2 & 128) != 0;
                    this.c = (((iG2 & 15) << 8) | iG3) + 3;
                    int iE = this.b.e();
                    int i3 = this.c;
                    if (iE < i3) {
                        com.opos.exoplayer.core.util.p pVar2 = this.b;
                        byte[] bArr = pVar2.f8400a;
                        pVar2.a(Math.min(4098, Math.max(i3, bArr.length * 2)));
                        System.arraycopy(bArr, 0, this.b.f8400a, 0, 3);
                    }
                }
            } else {
                int iMin2 = Math.min(pVar.b(), this.c - this.d);
                pVar.a(this.b.f8400a, this.d, iMin2);
                int i4 = this.d + iMin2;
                this.d = i4;
                int i5 = this.c;
                if (i4 != i5) {
                    continue;
                } else {
                    if (!this.e) {
                        this.b.a(i5);
                    } else {
                        if (y.a(this.b.f8400a, 0, i5, -1) != 0) {
                            this.f = true;
                            return;
                        }
                        this.b.a(this.c - 4);
                    }
                    this.f8243a.a(this.b);
                    this.d = 0;
                }
            }
        }
    }

    @Override // com.opos.exoplayer.core.extractor.ts.s
    public void a(w wVar, com.opos.exoplayer.core.extractor.g gVar, s.d dVar) {
        this.f8243a.a(wVar, gVar, dVar);
        this.f = true;
    }
}
