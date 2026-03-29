package com.opos.exoplayer.core;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class f implements com.opos.exoplayer.core.util.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.opos.exoplayer.core.util.u f8250a;
    private final a b;

    @Nullable
    private q c;

    @Nullable
    private com.opos.exoplayer.core.util.l d;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(n nVar);
    }

    public f(a aVar, com.opos.exoplayer.core.util.e eVar) {
        this.b = aVar;
        this.f8250a = new com.opos.exoplayer.core.util.u(eVar);
    }

    private void f() {
        this.f8250a.a(this.d.d());
        n nVarE = this.d.e();
        if (nVarE.equals(this.f8250a.e())) {
            return;
        }
        this.f8250a.a(nVarE);
        this.b.a(nVarE);
    }

    private boolean g() {
        q qVar = this.c;
        return (qVar == null || qVar.u() || (!this.c.t() && this.c.g())) ? false : true;
    }

    @Override // com.opos.exoplayer.core.util.l
    public n a(n nVar) {
        com.opos.exoplayer.core.util.l lVar = this.d;
        if (lVar != null) {
            nVar = lVar.a(nVar);
        }
        this.f8250a.a(nVar);
        this.b.a(nVar);
        return nVar;
    }

    public void b() {
        this.f8250a.b();
    }

    public long c() {
        if (!g()) {
            return this.f8250a.d();
        }
        f();
        return this.d.d();
    }

    @Override // com.opos.exoplayer.core.util.l
    public long d() {
        return g() ? this.d.d() : this.f8250a.d();
    }

    @Override // com.opos.exoplayer.core.util.l
    public n e() {
        com.opos.exoplayer.core.util.l lVar = this.d;
        return lVar != null ? lVar.e() : this.f8250a.e();
    }

    public void a() {
        this.f8250a.a();
    }

    public void b(q qVar) {
        if (qVar == this.c) {
            this.d = null;
            this.c = null;
        }
    }

    public void a(long j) {
        this.f8250a.a(j);
    }

    public void a(q qVar) throws ExoPlaybackException {
        com.opos.exoplayer.core.util.l lVar;
        com.opos.exoplayer.core.util.l lVarC = qVar.c();
        if (lVarC == null || lVarC == (lVar = this.d)) {
            return;
        }
        if (lVar != null) {
            throw ExoPlaybackException.a(new IllegalStateException("Multiple renderer media clocks enabled."));
        }
        this.d = lVarC;
        this.c = qVar;
        lVarC.a(this.f8250a.e());
        f();
    }
}
