package com.opos.exoplayer.core.extractor.a;

import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.drm.DrmInitData;
import com.opos.exoplayer.core.extractor.a.b;
import com.opos.exoplayer.core.extractor.n;
import com.opos.exoplayer.core.m;
import com.opos.exoplayer.core.util.p;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class e extends b {
    private final p b;
    private final p c;
    private int d;
    private boolean e;
    private int f;

    public e(n nVar) {
        super(nVar);
        this.b = new p(com.opos.exoplayer.core.util.n.f8396a);
        this.c = new p(4);
    }

    @Override // com.opos.exoplayer.core.extractor.a.b
    public boolean a(p pVar) throws b.a {
        int iG = pVar.g();
        int i = (iG >> 4) & 15;
        int i2 = iG & 15;
        if (i2 == 7) {
            this.f = i;
            return i != 5;
        }
        throw new b.a("Video format not supported: " + i2);
    }

    @Override // com.opos.exoplayer.core.extractor.a.b
    public void b(p pVar, long j) throws m {
        int iG = pVar.g();
        long jL = j + (((long) pVar.l()) * 1000);
        if (iG == 0 && !this.e) {
            p pVar2 = new p(new byte[pVar.b()]);
            pVar.a(pVar2.f8400a, 0, pVar.b());
            com.opos.exoplayer.core.video.a aVarA = com.opos.exoplayer.core.video.a.a(pVar2);
            this.d = aVarA.b;
            this.f8157a.a(Format.a((String) null, "video/avc", (String) null, -1, -1, aVarA.c, aVarA.d, -1.0f, aVarA.f8414a, -1, aVarA.e, (DrmInitData) null));
            this.e = true;
            return;
        }
        if (iG == 1 && this.e) {
            byte[] bArr = this.c.f8400a;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i = 4 - this.d;
            int i2 = 0;
            while (pVar.b() > 0) {
                pVar.a(this.c.f8400a, i, this.d);
                this.c.c(0);
                int iU = this.c.u();
                this.b.c(0);
                this.f8157a.a(this.b, 4);
                this.f8157a.a(pVar, iU);
                i2 = i2 + 4 + iU;
            }
            this.f8157a.a(jL, this.f == 1 ? 1 : 0, i2, 0, null);
        }
    }
}
