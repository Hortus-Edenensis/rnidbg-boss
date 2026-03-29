package com.opos.exoplayer.core.extractor.b;

import com.opos.exoplayer.core.extractor.n;
import com.opos.exoplayer.core.m;
import com.opos.exoplayer.core.util.p;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class a implements com.opos.exoplayer.core.extractor.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.opos.exoplayer.core.extractor.h f8159a = new C0688a();
    private com.opos.exoplayer.core.extractor.g b;
    private i c;
    private boolean d;

    /* JADX INFO: renamed from: com.opos.exoplayer.core.extractor.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0688a implements com.opos.exoplayer.core.extractor.h {
        @Override // com.opos.exoplayer.core.extractor.h
        public com.opos.exoplayer.core.extractor.e[] a() {
            return new com.opos.exoplayer.core.extractor.e[]{new a()};
        }
    }

    private boolean b(com.opos.exoplayer.core.extractor.f fVar) {
        i hVar;
        f fVar2 = new f();
        if (fVar2.a(fVar, true) && (fVar2.b & 2) == 2) {
            int iMin = Math.min(fVar2.f, 8);
            p pVar = new p(iMin);
            fVar.c(pVar.f8400a, 0, iMin);
            if (d.a(a(pVar))) {
                hVar = new d();
            } else if (k.a(a(pVar))) {
                hVar = new k();
            } else if (h.a(a(pVar))) {
                hVar = new h();
            }
            this.c = hVar;
            return true;
        }
        return false;
    }

    @Override // com.opos.exoplayer.core.extractor.e
    public int a(com.opos.exoplayer.core.extractor.f fVar, com.opos.exoplayer.core.extractor.k kVar) throws m {
        if (this.c == null) {
            if (!b(fVar)) {
                throw new m("Failed to determine bitstream type");
            }
            fVar.a();
        }
        if (!this.d) {
            n nVarA = this.b.a(0, 1);
            this.b.a();
            this.c.a(this.b, nVarA);
            this.d = true;
        }
        return this.c.a(fVar, kVar);
    }

    private static p a(p pVar) {
        pVar.c(0);
        return pVar;
    }

    @Override // com.opos.exoplayer.core.extractor.e
    public void a(long j, long j2) {
        i iVar = this.c;
        if (iVar != null) {
            iVar.a(j, j2);
        }
    }

    @Override // com.opos.exoplayer.core.extractor.e
    public void a(com.opos.exoplayer.core.extractor.g gVar) {
        this.b = gVar;
    }

    @Override // com.opos.exoplayer.core.extractor.e
    public boolean a(com.opos.exoplayer.core.extractor.f fVar) {
        try {
            return b(fVar);
        } catch (m unused) {
            return false;
        }
    }

    @Override // com.opos.exoplayer.core.extractor.e
    public void c() {
    }
}
