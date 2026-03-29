package com.opos.exoplayer.core.extractor.c;

import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.drm.DrmInitData;
import com.opos.exoplayer.core.extractor.e;
import com.opos.exoplayer.core.extractor.f;
import com.opos.exoplayer.core.extractor.g;
import com.opos.exoplayer.core.extractor.h;
import com.opos.exoplayer.core.extractor.k;
import com.opos.exoplayer.core.extractor.n;
import com.opos.exoplayer.core.m;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f8177a = new C0690a();
    private g b;
    private n c;
    private b d;
    private int e;
    private int f;

    /* JADX INFO: renamed from: com.opos.exoplayer.core.extractor.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0690a implements h {
        @Override // com.opos.exoplayer.core.extractor.h
        public e[] a() {
            return new e[]{new a()};
        }
    }

    @Override // com.opos.exoplayer.core.extractor.e
    public int a(f fVar, k kVar) throws m {
        if (this.d == null) {
            b bVarA = c.a(fVar);
            this.d = bVarA;
            if (bVarA == null) {
                throw new m("Unsupported or unrecognized wav header.");
            }
            this.c.a(Format.a((String) null, "audio/raw", (String) null, bVarA.e(), 32768, this.d.g(), this.d.f(), this.d.h(), (List<byte[]>) null, (DrmInitData) null, 0, (String) null));
            this.e = this.d.d();
        }
        if (!this.d.c()) {
            c.a(fVar, this.d);
            this.b.a(this.d);
        }
        int iA = this.c.a(fVar, 32768 - this.f, true);
        if (iA != -1) {
            this.f += iA;
        }
        int i = this.f / this.e;
        if (i > 0) {
            long jA = this.d.a(fVar.c() - ((long) this.f));
            int i2 = i * this.e;
            int i3 = this.f - i2;
            this.f = i3;
            this.c.a(jA, 1, i2, i3, null);
        }
        return iA == -1 ? -1 : 0;
    }

    @Override // com.opos.exoplayer.core.extractor.e
    public void a(long j, long j2) {
        this.f = 0;
    }

    @Override // com.opos.exoplayer.core.extractor.e
    public void a(g gVar) {
        this.b = gVar;
        this.c = gVar.a(0, 1);
        this.d = null;
        gVar.a();
    }

    @Override // com.opos.exoplayer.core.extractor.e
    public boolean a(f fVar) {
        return c.a(fVar) != null;
    }

    @Override // com.opos.exoplayer.core.extractor.e
    public void c() {
    }
}
