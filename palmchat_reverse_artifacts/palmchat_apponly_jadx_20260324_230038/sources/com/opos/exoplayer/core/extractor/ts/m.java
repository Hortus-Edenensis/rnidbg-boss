package com.opos.exoplayer.core.extractor.ts;

import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.extractor.ts.s;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class m implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.opos.exoplayer.core.util.p f8239a;
    private final com.opos.exoplayer.core.extractor.j b;
    private final String c;
    private String d;
    private com.opos.exoplayer.core.extractor.n e;
    private int f;
    private int g;
    private boolean h;
    private boolean i;
    private long j;
    private int k;
    private long l;

    public m() {
        this(null);
    }

    private void c(com.opos.exoplayer.core.util.p pVar) {
        int iMin = Math.min(pVar.b(), 4 - this.g);
        pVar.a(this.f8239a.f8400a, this.g, iMin);
        int i = this.g + iMin;
        this.g = i;
        if (i < 4) {
            return;
        }
        this.f8239a.c(0);
        if (!com.opos.exoplayer.core.extractor.j.a(this.f8239a.o(), this.b)) {
            this.g = 0;
            this.f = 1;
            return;
        }
        com.opos.exoplayer.core.extractor.j jVar = this.b;
        this.k = jVar.c;
        if (!this.h) {
            long j = ((long) jVar.g) * 1000000;
            int i2 = jVar.d;
            this.j = j / ((long) i2);
            this.e.a(Format.a(this.d, jVar.b, null, -1, 4096, jVar.e, i2, null, null, 0, this.c));
            this.h = true;
        }
        this.f8239a.c(0);
        this.e.a(this.f8239a, 4);
        this.f = 2;
    }

    private void d(com.opos.exoplayer.core.util.p pVar) {
        int iMin = Math.min(pVar.b(), this.k - this.g);
        this.e.a(pVar, iMin);
        int i = this.g + iMin;
        this.g = i;
        int i2 = this.k;
        if (i < i2) {
            return;
        }
        this.e.a(this.l, 1, i2, 0, null);
        this.l += this.j;
        this.g = 0;
        this.f = 0;
    }

    @Override // com.opos.exoplayer.core.extractor.ts.g
    public void a() {
        this.f = 0;
        this.g = 0;
        this.i = false;
    }

    @Override // com.opos.exoplayer.core.extractor.ts.g
    public void b() {
    }

    public m(String str) {
        this.f = 0;
        com.opos.exoplayer.core.util.p pVar = new com.opos.exoplayer.core.util.p(4);
        this.f8239a = pVar;
        pVar.f8400a[0] = -1;
        this.b = new com.opos.exoplayer.core.extractor.j();
        this.c = str;
    }

    private void b(com.opos.exoplayer.core.util.p pVar) {
        byte[] bArr = pVar.f8400a;
        int iC = pVar.c();
        for (int iD = pVar.d(); iD < iC; iD++) {
            byte b = bArr[iD];
            boolean z = (b & UByte.MAX_VALUE) == 255;
            boolean z2 = this.i && (b & 224) == 224;
            this.i = z;
            if (z2) {
                pVar.c(iD + 1);
                this.i = false;
                this.f8239a.f8400a[1] = bArr[iD];
                this.g = 2;
                this.f = 1;
                return;
            }
        }
        pVar.c(iC);
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
            if (i == 0) {
                b(pVar);
            } else if (i == 1) {
                c(pVar);
            } else if (i == 2) {
                d(pVar);
            }
        }
    }
}
