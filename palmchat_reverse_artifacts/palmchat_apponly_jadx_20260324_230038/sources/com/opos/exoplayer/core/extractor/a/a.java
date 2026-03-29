package com.opos.exoplayer.core.extractor.a;

import com.opos.exoplayer.core.extractor.f;
import com.opos.exoplayer.core.extractor.g;
import com.opos.exoplayer.core.extractor.h;
import com.opos.exoplayer.core.extractor.k;
import com.opos.exoplayer.core.extractor.l;
import com.opos.exoplayer.core.util.p;
import com.opos.exoplayer.core.util.y;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a implements com.opos.exoplayer.core.extractor.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f8156a = new C0687a();
    private static final int b = y.f("FLV");
    private g h;
    private int k;
    private int l;
    private int m;
    private long n;
    private boolean o;
    private c p;
    private e q;
    private final p c = new p(4);
    private final p d = new p(9);
    private final p e = new p(11);
    private final p f = new p();
    private final d g = new d();
    private int i = 1;
    private long j = -9223372036854775807L;

    /* JADX INFO: renamed from: com.opos.exoplayer.core.extractor.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0687a implements h {
        @Override // com.opos.exoplayer.core.extractor.h
        public com.opos.exoplayer.core.extractor.e[] a() {
            return new com.opos.exoplayer.core.extractor.e[]{new a()};
        }
    }

    private boolean b(f fVar) {
        if (!fVar.a(this.d.f8400a, 0, 9, true)) {
            return false;
        }
        this.d.c(0);
        this.d.d(4);
        int iG = this.d.g();
        boolean z = (iG & 4) != 0;
        boolean z2 = (iG & 1) != 0;
        if (z && this.p == null) {
            this.p = new c(this.h.a(8, 1));
        }
        if (z2 && this.q == null) {
            this.q = new e(this.h.a(9, 2));
        }
        this.h.a();
        this.k = (this.d.o() - 9) + 4;
        this.i = 2;
        return true;
    }

    private boolean d(f fVar) {
        if (!fVar.a(this.e.f8400a, 0, 11, true)) {
            return false;
        }
        this.e.c(0);
        this.l = this.e.g();
        this.m = this.e.k();
        this.n = this.e.k();
        this.n = (((long) (this.e.g() << 24)) | this.n) * 1000;
        this.e.d(3);
        this.i = 4;
        return true;
    }

    private boolean e(f fVar) {
        b bVar;
        int i = this.l;
        boolean z = true;
        if (i == 8 && this.p != null) {
            a();
            bVar = this.p;
        } else {
            if (i != 9 || this.q == null) {
                if (i != 18 || this.o) {
                    fVar.b(this.m);
                    z = false;
                } else {
                    this.g.a(f(fVar), this.n);
                    long jA = this.g.a();
                    if (jA != -9223372036854775807L) {
                        this.h.a(new l.b(jA));
                        this.o = true;
                    }
                }
                this.k = 4;
                this.i = 2;
                return z;
            }
            a();
            bVar = this.q;
        }
        bVar.a(f(fVar), this.j + this.n);
        this.k = 4;
        this.i = 2;
        return z;
    }

    private p f(f fVar) {
        if (this.m > this.f.e()) {
            p pVar = this.f;
            pVar.a(new byte[Math.max(pVar.e() * 2, this.m)], 0);
        } else {
            this.f.c(0);
        }
        this.f.b(this.m);
        fVar.b(this.f.f8400a, 0, this.m);
        return this.f;
    }

    @Override // com.opos.exoplayer.core.extractor.e
    public int a(f fVar, k kVar) {
        while (true) {
            int i = this.i;
            if (i != 1) {
                if (i == 2) {
                    c(fVar);
                } else if (i != 3) {
                    if (i != 4) {
                        throw new IllegalStateException();
                    }
                    if (e(fVar)) {
                        return 0;
                    }
                } else if (!d(fVar)) {
                    return -1;
                }
            } else if (!b(fVar)) {
                return -1;
            }
        }
    }

    @Override // com.opos.exoplayer.core.extractor.e
    public void c() {
    }

    private void a() {
        if (!this.o) {
            this.h.a(new l.b(-9223372036854775807L));
            this.o = true;
        }
        if (this.j == -9223372036854775807L) {
            this.j = this.g.a() == -9223372036854775807L ? -this.n : 0L;
        }
    }

    private void c(f fVar) {
        fVar.b(this.k);
        this.k = 0;
        this.i = 3;
    }

    @Override // com.opos.exoplayer.core.extractor.e
    public void a(long j, long j2) {
        this.i = 1;
        this.j = -9223372036854775807L;
        this.k = 0;
    }

    @Override // com.opos.exoplayer.core.extractor.e
    public void a(g gVar) {
        this.h = gVar;
    }

    @Override // com.opos.exoplayer.core.extractor.e
    public boolean a(f fVar) {
        fVar.c(this.c.f8400a, 0, 3);
        this.c.c(0);
        if (this.c.k() != b) {
            return false;
        }
        fVar.c(this.c.f8400a, 0, 2);
        this.c.c(0);
        if ((this.c.h() & 250) != 0) {
            return false;
        }
        fVar.c(this.c.f8400a, 0, 4);
        this.c.c(0);
        int iO = this.c.o();
        fVar.a();
        fVar.c(iO);
        fVar.c(this.c.f8400a, 0, 4);
        this.c.c(0);
        return this.c.o() == 0;
    }
}
