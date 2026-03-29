package com.opos.exoplayer.core.extractor.ts;

import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.drm.DrmInitData;
import com.opos.exoplayer.core.extractor.ts.s;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class f implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<s.a> f8229a;
    private final com.opos.exoplayer.core.extractor.n[] b;
    private boolean c;
    private int d;
    private int e;
    private long f;

    public f(List<s.a> list) {
        this.f8229a = list;
        this.b = new com.opos.exoplayer.core.extractor.n[list.size()];
    }

    @Override // com.opos.exoplayer.core.extractor.ts.g
    public void a() {
        this.c = false;
    }

    @Override // com.opos.exoplayer.core.extractor.ts.g
    public void b() {
        if (this.c) {
            for (com.opos.exoplayer.core.extractor.n nVar : this.b) {
                nVar.a(this.f, 1, this.e, 0, null);
            }
            this.c = false;
        }
    }

    @Override // com.opos.exoplayer.core.extractor.ts.g
    public void a(long j, boolean z) {
        if (z) {
            this.c = true;
            this.f = j;
            this.e = 0;
            this.d = 2;
        }
    }

    @Override // com.opos.exoplayer.core.extractor.ts.g
    public void a(com.opos.exoplayer.core.extractor.g gVar, s.d dVar) {
        for (int i = 0; i < this.b.length; i++) {
            s.a aVar = this.f8229a.get(i);
            dVar.a();
            com.opos.exoplayer.core.extractor.n nVarA = gVar.a(dVar.b(), 3);
            nVarA.a(Format.a(dVar.c(), "application/dvbsubs", (String) null, -1, 0, (List<byte[]>) Collections.singletonList(aVar.c), aVar.f8245a, (DrmInitData) null));
            this.b[i] = nVarA;
        }
    }

    @Override // com.opos.exoplayer.core.extractor.ts.g
    public void a(com.opos.exoplayer.core.util.p pVar) {
        if (this.c) {
            if (this.d != 2 || a(pVar, 32)) {
                if (this.d != 1 || a(pVar, 0)) {
                    int iD = pVar.d();
                    int iB = pVar.b();
                    for (com.opos.exoplayer.core.extractor.n nVar : this.b) {
                        pVar.c(iD);
                        nVar.a(pVar, iB);
                    }
                    this.e += iB;
                }
            }
        }
    }

    private boolean a(com.opos.exoplayer.core.util.p pVar, int i) {
        if (pVar.b() == 0) {
            return false;
        }
        if (pVar.g() != i) {
            this.c = false;
        }
        this.d--;
        return this.c;
    }
}
