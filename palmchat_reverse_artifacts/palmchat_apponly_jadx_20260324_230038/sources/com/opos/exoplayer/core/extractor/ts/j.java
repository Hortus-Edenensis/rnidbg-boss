package com.opos.exoplayer.core.extractor.ts;

import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.drm.DrmInitData;
import com.opos.exoplayer.core.extractor.ts.s;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class j implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final u f8235a;
    private String b;
    private com.opos.exoplayer.core.extractor.n c;
    private a d;
    private boolean e;
    private long l;
    private long m;
    private final boolean[] f = new boolean[3];
    private final t g = new t(32, 128);
    private final t h = new t(33, 128);
    private final t i = new t(34, 128);
    private final t j = new t(39, 128);
    private final t k = new t(40, 128);
    private final com.opos.exoplayer.core.util.p n = new com.opos.exoplayer.core.util.p();

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.opos.exoplayer.core.extractor.n f8236a;
        private long b;
        private boolean c;
        private int d;
        private long e;
        private boolean f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;
        private long k;
        private long l;
        private boolean m;

        public a(com.opos.exoplayer.core.extractor.n nVar) {
            this.f8236a = nVar;
        }

        public void a() {
            this.f = false;
            this.g = false;
            this.h = false;
            this.i = false;
            this.j = false;
        }

        private void a(int i) {
            boolean z = this.m;
            this.f8236a.a(this.l, z ? 1 : 0, (int) (this.b - this.k), i, null);
        }

        public void a(long j, int i) {
            if (this.j && this.g) {
                this.m = this.c;
                this.j = false;
            } else if (this.h || this.g) {
                if (this.i) {
                    a(i + ((int) (j - this.b)));
                }
                this.k = this.b;
                this.l = this.e;
                this.i = true;
                this.m = this.c;
            }
        }

        public void a(long j, int i, int i2, long j2) {
            this.g = false;
            this.h = false;
            this.e = j2;
            this.d = 0;
            this.b = j;
            if (i2 >= 32) {
                if (!this.j && this.i) {
                    a(i);
                    this.i = false;
                }
                if (i2 <= 34) {
                    this.h = !this.j;
                    this.j = true;
                }
            }
            boolean z = i2 >= 16 && i2 <= 21;
            this.c = z;
            this.f = z || i2 <= 9;
        }

        public void a(byte[] bArr, int i, int i2) {
            if (this.f) {
                int i3 = this.d;
                int i4 = (i + 2) - i3;
                if (i4 >= i2) {
                    this.d = i3 + (i2 - i);
                } else {
                    this.g = (bArr[i4] & ByteCompanionObject.MIN_VALUE) != 0;
                    this.f = false;
                }
            }
        }
    }

    public j(u uVar) {
        this.f8235a = uVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x0164  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Format a(String str, t tVar, t tVar2, t tVar3) {
        float f;
        int i = tVar.b;
        byte[] bArr = new byte[tVar2.b + i + tVar3.b];
        System.arraycopy(tVar.f8248a, 0, bArr, 0, i);
        System.arraycopy(tVar2.f8248a, 0, bArr, tVar.b, tVar2.b);
        System.arraycopy(tVar3.f8248a, 0, bArr, tVar.b + tVar2.b, tVar3.b);
        com.opos.exoplayer.core.util.q qVar = new com.opos.exoplayer.core.util.q(tVar2.f8248a, 0, tVar2.b);
        qVar.a(44);
        int iC = qVar.c(3);
        qVar.a();
        qVar.a(88);
        qVar.a(8);
        int i2 = 0;
        for (int i3 = 0; i3 < iC; i3++) {
            if (qVar.b()) {
                i2 += 89;
            }
            if (qVar.b()) {
                i2 += 8;
            }
        }
        qVar.a(i2);
        if (iC > 0) {
            qVar.a((8 - iC) * 2);
        }
        qVar.d();
        int iD = qVar.d();
        if (iD == 3) {
            qVar.a();
        }
        int iD2 = qVar.d();
        int iD3 = qVar.d();
        if (qVar.b()) {
            int iD4 = qVar.d();
            int iD5 = qVar.d();
            int iD6 = qVar.d();
            int iD7 = qVar.d();
            iD2 -= ((iD == 1 || iD == 2) ? 2 : 1) * (iD4 + iD5);
            iD3 -= (iD == 1 ? 2 : 1) * (iD6 + iD7);
        }
        int i4 = iD2;
        int i5 = iD3;
        qVar.d();
        qVar.d();
        int iD8 = qVar.d();
        int i6 = qVar.b() ? 0 : iC;
        while (true) {
            qVar.d();
            qVar.d();
            qVar.d();
            if (i6 > iC) {
                break;
            }
            i6++;
        }
        qVar.d();
        qVar.d();
        qVar.d();
        if (qVar.b() && qVar.b()) {
            a(qVar);
        }
        qVar.a(2);
        if (qVar.b()) {
            qVar.a(8);
            qVar.d();
            qVar.d();
            qVar.a();
        }
        b(qVar);
        if (qVar.b()) {
            for (int i7 = 0; i7 < qVar.d(); i7++) {
                qVar.a(iD8 + 4 + 1);
            }
        }
        qVar.a(2);
        if (qVar.b() && qVar.b()) {
            int iC2 = qVar.c(8);
            if (iC2 == 255) {
                int iC3 = qVar.c(16);
                int iC4 = qVar.c(16);
                if (iC3 != 0 && iC4 != 0) {
                    f = iC3 / iC4;
                }
            } else {
                float[] fArr = com.opos.exoplayer.core.util.n.b;
                if (iC2 < fArr.length) {
                    f = fArr[iC2];
                } else {
                    com.opos.cmn.an.f.a.c("H265Reader", "Unexpected aspect_ratio_idc value: " + iC2);
                    f = 1.0f;
                }
            }
        } else {
            f = 1.0f;
        }
        return Format.a(str, "video/hevc", (String) null, -1, -1, i4, i5, -1.0f, (List<byte[]>) Collections.singletonList(bArr), -1, f, (DrmInitData) null);
    }

    @Override // com.opos.exoplayer.core.extractor.ts.g
    public void b() {
    }

    private void b(long j, int i, int i2, long j2) {
        if (this.e) {
            this.d.a(j, i);
        } else {
            this.g.b(i2);
            this.h.b(i2);
            this.i.b(i2);
            if (this.g.b() && this.h.b() && this.i.b()) {
                this.c.a(a(this.b, this.g, this.h, this.i));
                this.e = true;
            }
        }
        if (this.j.b(i2)) {
            t tVar = this.j;
            this.n.a(this.j.f8248a, com.opos.exoplayer.core.util.n.a(tVar.f8248a, tVar.b));
            this.n.d(5);
            this.f8235a.a(j2, this.n);
        }
        if (this.k.b(i2)) {
            t tVar2 = this.k;
            this.n.a(this.k.f8248a, com.opos.exoplayer.core.util.n.a(tVar2.f8248a, tVar2.b));
            this.n.d(5);
            this.f8235a.a(j2, this.n);
        }
    }

    @Override // com.opos.exoplayer.core.extractor.ts.g
    public void a() {
        com.opos.exoplayer.core.util.n.a(this.f);
        this.g.a();
        this.h.a();
        this.i.a();
        this.j.a();
        this.k.a();
        this.d.a();
        this.l = 0L;
    }

    private void a(long j, int i, int i2, long j2) {
        if (this.e) {
            this.d.a(j, i, i2, j2);
        } else {
            this.g.a(i2);
            this.h.a(i2);
            this.i.a(i2);
        }
        this.j.a(i2);
        this.k.a(i2);
    }

    private static void b(com.opos.exoplayer.core.util.q qVar) {
        int iD = qVar.d();
        boolean zB = false;
        int i = 0;
        for (int i2 = 0; i2 < iD; i2++) {
            if (i2 != 0) {
                zB = qVar.b();
            }
            if (zB) {
                qVar.a();
                qVar.d();
                for (int i3 = 0; i3 <= i; i3++) {
                    if (qVar.b()) {
                        qVar.a();
                    }
                }
            } else {
                int iD2 = qVar.d();
                int iD3 = qVar.d();
                int i4 = iD2 + iD3;
                for (int i5 = 0; i5 < iD2; i5++) {
                    qVar.d();
                    qVar.a();
                }
                for (int i6 = 0; i6 < iD3; i6++) {
                    qVar.d();
                    qVar.a();
                }
                i = i4;
            }
        }
    }

    @Override // com.opos.exoplayer.core.extractor.ts.g
    public void a(long j, boolean z) {
        this.m = j;
    }

    @Override // com.opos.exoplayer.core.extractor.ts.g
    public void a(com.opos.exoplayer.core.extractor.g gVar, s.d dVar) {
        dVar.a();
        this.b = dVar.c();
        com.opos.exoplayer.core.extractor.n nVarA = gVar.a(dVar.b(), 2);
        this.c = nVarA;
        this.d = new a(nVarA);
        this.f8235a.a(gVar, dVar);
    }

    @Override // com.opos.exoplayer.core.extractor.ts.g
    public void a(com.opos.exoplayer.core.util.p pVar) {
        while (pVar.b() > 0) {
            int iD = pVar.d();
            int iC = pVar.c();
            byte[] bArr = pVar.f8400a;
            this.l += (long) pVar.b();
            this.c.a(pVar, pVar.b());
            while (iD < iC) {
                int iA = com.opos.exoplayer.core.util.n.a(bArr, iD, iC, this.f);
                if (iA == iC) {
                    a(bArr, iD, iC);
                    return;
                }
                int iC2 = com.opos.exoplayer.core.util.n.c(bArr, iA);
                int i = iA - iD;
                if (i > 0) {
                    a(bArr, iD, iA);
                }
                int i2 = iC - iA;
                long j = this.l - ((long) i2);
                b(j, i2, i < 0 ? -i : 0, this.m);
                a(j, i2, iC2, this.m);
                iD = iA + 3;
            }
        }
    }

    private static void a(com.opos.exoplayer.core.util.q qVar) {
        for (int i = 0; i < 4; i++) {
            int i2 = 0;
            while (i2 < 6) {
                int i3 = 1;
                if (qVar.b()) {
                    int iMin = Math.min(64, 1 << ((i << 1) + 4));
                    if (i > 1) {
                        qVar.e();
                    }
                    for (int i4 = 0; i4 < iMin; i4++) {
                        qVar.e();
                    }
                } else {
                    qVar.d();
                }
                if (i == 3) {
                    i3 = 3;
                }
                i2 += i3;
            }
        }
    }

    private void a(byte[] bArr, int i, int i2) {
        if (this.e) {
            this.d.a(bArr, i, i2);
        } else {
            this.g.a(bArr, i, i2);
            this.h.a(bArr, i, i2);
            this.i.a(bArr, i, i2);
        }
        this.j.a(bArr, i, i2);
        this.k.a(bArr, i, i2);
    }
}
