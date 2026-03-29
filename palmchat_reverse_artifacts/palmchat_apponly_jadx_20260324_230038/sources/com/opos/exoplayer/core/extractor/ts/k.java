package com.opos.exoplayer.core.extractor.ts;

import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.drm.DrmInitData;
import com.opos.exoplayer.core.extractor.ts.s;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class k implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.opos.exoplayer.core.util.p f8237a = new com.opos.exoplayer.core.util.p(10);
    private com.opos.exoplayer.core.extractor.n b;
    private boolean c;
    private long d;
    private int e;
    private int f;

    @Override // com.opos.exoplayer.core.extractor.ts.g
    public void a() {
        this.c = false;
    }

    @Override // com.opos.exoplayer.core.extractor.ts.g
    public void b() {
        int i;
        if (this.c && (i = this.e) != 0 && this.f == i) {
            this.b.a(this.d, 1, i, 0, null);
            this.c = false;
        }
    }

    @Override // com.opos.exoplayer.core.extractor.ts.g
    public void a(long j, boolean z) {
        if (z) {
            this.c = true;
            this.d = j;
            this.e = 0;
            this.f = 0;
        }
    }

    @Override // com.opos.exoplayer.core.extractor.ts.g
    public void a(com.opos.exoplayer.core.extractor.g gVar, s.d dVar) {
        dVar.a();
        com.opos.exoplayer.core.extractor.n nVarA = gVar.a(dVar.b(), 4);
        this.b = nVarA;
        nVarA.a(Format.a(dVar.c(), "application/id3", (String) null, -1, (DrmInitData) null));
    }

    @Override // com.opos.exoplayer.core.extractor.ts.g
    public void a(com.opos.exoplayer.core.util.p pVar) {
        if (this.c) {
            int iB = pVar.b();
            int i = this.f;
            if (i < 10) {
                int iMin = Math.min(iB, 10 - i);
                System.arraycopy(pVar.f8400a, pVar.d(), this.f8237a.f8400a, this.f, iMin);
                if (this.f + iMin == 10) {
                    this.f8237a.c(0);
                    if (73 != this.f8237a.g() || 68 != this.f8237a.g() || 51 != this.f8237a.g()) {
                        com.opos.cmn.an.f.a.c("Id3Reader", "Discarding invalid ID3 tag");
                        this.c = false;
                        return;
                    } else {
                        this.f8237a.d(3);
                        this.e = this.f8237a.t() + 10;
                    }
                }
            }
            int iMin2 = Math.min(iB, this.e - this.f);
            this.b.a(pVar, iMin2);
            this.f += iMin2;
        }
    }
}
