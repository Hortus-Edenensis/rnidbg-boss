package com.opos.exoplayer.core.extractor.ts;

import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.drm.DrmInitData;
import com.opos.exoplayer.core.extractor.ts.s;
import com.opos.exoplayer.core.util.w;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class r implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private w f8244a;
    private com.opos.exoplayer.core.extractor.n b;
    private boolean c;

    @Override // com.opos.exoplayer.core.extractor.ts.p
    public void a(com.opos.exoplayer.core.util.p pVar) {
        if (!this.c) {
            if (this.f8244a.c() == -9223372036854775807L) {
                return;
            }
            this.b.a(Format.a((String) null, "application/x-scte35", this.f8244a.c()));
            this.c = true;
        }
        int iB = pVar.b();
        this.b.a(pVar, iB);
        this.b.a(this.f8244a.b(), 1, iB, 0, null);
    }

    @Override // com.opos.exoplayer.core.extractor.ts.p
    public void a(w wVar, com.opos.exoplayer.core.extractor.g gVar, s.d dVar) {
        this.f8244a = wVar;
        dVar.a();
        com.opos.exoplayer.core.extractor.n nVarA = gVar.a(dVar.b(), 4);
        this.b = nVarA;
        nVarA.a(Format.a(dVar.c(), "application/x-scte35", (String) null, -1, (DrmInitData) null));
    }
}
