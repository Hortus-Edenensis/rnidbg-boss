package com.opos.exoplayer.core.extractor.ts;

import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.drm.DrmInitData;
import com.opos.exoplayer.core.extractor.ts.s;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<Format> f8249a;
    private final com.opos.exoplayer.core.extractor.n[] b;

    public u(List<Format> list) {
        this.f8249a = list;
        this.b = new com.opos.exoplayer.core.extractor.n[list.size()];
    }

    public void a(long j, com.opos.exoplayer.core.util.p pVar) {
        com.opos.exoplayer.core.text.a.c.a(j, pVar, this.b);
    }

    public void a(com.opos.exoplayer.core.extractor.g gVar, s.d dVar) {
        for (int i = 0; i < this.b.length; i++) {
            dVar.a();
            com.opos.exoplayer.core.extractor.n nVarA = gVar.a(dVar.b(), 3);
            Format format = this.f8249a.get(i);
            String str = format.f;
            com.opos.exoplayer.core.util.a.a("application/cea-608".equals(str) || "application/cea-708".equals(str), "Invalid closed caption mime type provided: " + str);
            String strC = format.f8083a;
            if (strC == null) {
                strC = dVar.c();
            }
            nVarA.a(Format.a(strC, str, (String) null, -1, format.x, format.y, format.z, (DrmInitData) null));
            this.b[i] = nVarA;
        }
    }
}
