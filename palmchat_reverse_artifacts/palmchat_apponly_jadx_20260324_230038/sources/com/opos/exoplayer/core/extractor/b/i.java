package com.opos.exoplayer.core.extractor.b;

import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.extractor.l;
import com.opos.exoplayer.core.extractor.n;
import com.opos.exoplayer.core.util.p;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e f8171a = new e();
    private n b;
    private com.opos.exoplayer.core.extractor.g c;
    private g d;
    private long e;
    private long f;
    private long g;
    private int h;
    private int i;
    private b j;
    private long k;
    private boolean l;
    private boolean m;

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Format f8172a;
        g b;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c implements g {
        private c() {
        }

        @Override // com.opos.exoplayer.core.extractor.b.g
        public long a(long j) {
            return 0L;
        }

        @Override // com.opos.exoplayer.core.extractor.b.g
        public l c() {
            return new l.b(-9223372036854775807L);
        }

        @Override // com.opos.exoplayer.core.extractor.b.g
        public long a(com.opos.exoplayer.core.extractor.f fVar) {
            return -1L;
        }
    }

    private int a(com.opos.exoplayer.core.extractor.f fVar) {
        boolean zA = true;
        while (zA) {
            if (!this.f8171a.a(fVar)) {
                this.h = 3;
                return -1;
            }
            this.k = fVar.c() - this.f;
            zA = a(this.f8171a.c(), this.f, this.j);
            if (zA) {
                this.f = fVar.c();
            }
        }
        Format format = this.j.f8172a;
        this.i = format.s;
        if (!this.m) {
            this.b.a(format);
            this.m = true;
        }
        g gVar = this.j.b;
        if (gVar != null) {
            this.d = gVar;
        } else if (fVar.d() == -1) {
            this.d = new c();
        } else {
            f fVarB = this.f8171a.b();
            this.d = new com.opos.exoplayer.core.extractor.b.c(this.f, fVar.d(), this, fVarB.e + fVarB.f, fVarB.c);
        }
        this.j = null;
        this.h = 2;
        this.f8171a.d();
        return 0;
    }

    private int b(com.opos.exoplayer.core.extractor.f fVar, com.opos.exoplayer.core.extractor.k kVar) {
        long jA = this.d.a(fVar);
        if (jA >= 0) {
            kVar.f8182a = jA;
            return 1;
        }
        if (jA < -1) {
            c(-(jA + 2));
        }
        if (!this.l) {
            this.c.a(this.d.c());
            this.l = true;
        }
        if (this.k <= 0 && !this.f8171a.a(fVar)) {
            this.h = 3;
            return -1;
        }
        this.k = 0L;
        p pVarC = this.f8171a.c();
        long jB = b(pVarC);
        if (jB >= 0) {
            long j = this.g;
            if (j + jB >= this.e) {
                long jA2 = a(j);
                this.b.a(pVarC, pVarC.c());
                this.b.a(jA2, 1, pVarC.c(), 0, null);
                this.e = -1L;
            }
        }
        this.g += jB;
        return 0;
    }

    public abstract boolean a(p pVar, long j, b bVar);

    public abstract long b(p pVar);

    public void c(long j) {
        this.g = j;
    }

    public final int a(com.opos.exoplayer.core.extractor.f fVar, com.opos.exoplayer.core.extractor.k kVar) {
        int i = this.h;
        if (i == 0) {
            return a(fVar);
        }
        if (i != 1) {
            if (i == 2) {
                return b(fVar, kVar);
            }
            throw new IllegalStateException();
        }
        fVar.b((int) this.f);
        this.h = 2;
        return 0;
    }

    public long b(long j) {
        return (((long) this.i) * j) / 1000000;
    }

    public long a(long j) {
        return (j * 1000000) / ((long) this.i);
    }

    public final void a(long j, long j2) {
        this.f8171a.a();
        if (j == 0) {
            a(!this.l);
        } else if (this.h != 0) {
            this.e = this.d.a(j2);
            this.h = 2;
        }
    }

    public void a(com.opos.exoplayer.core.extractor.g gVar, n nVar) {
        this.c = gVar;
        this.b = nVar;
        a(true);
    }

    public void a(boolean z) {
        int i;
        if (z) {
            this.j = new b();
            this.f = 0L;
            i = 0;
        } else {
            i = 1;
        }
        this.h = i;
        this.e = -1L;
        this.g = 0L;
    }
}
