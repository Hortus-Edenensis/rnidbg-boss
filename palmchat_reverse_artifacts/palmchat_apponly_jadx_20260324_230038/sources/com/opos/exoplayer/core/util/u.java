package com.opos.exoplayer.core.util;

import com.opos.exoplayer.core.C;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class u implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e f8405a;
    private boolean b;
    private long c;
    private long d;
    private com.opos.exoplayer.core.n e = com.opos.exoplayer.core.n.f8277a;

    public u(e eVar) {
        this.f8405a = eVar;
    }

    @Override // com.opos.exoplayer.core.util.l
    public com.opos.exoplayer.core.n a(com.opos.exoplayer.core.n nVar) {
        if (this.b) {
            a(d());
        }
        this.e = nVar;
        return nVar;
    }

    public void b() {
        if (this.b) {
            a(d());
            this.b = false;
        }
    }

    @Override // com.opos.exoplayer.core.util.l
    public long d() {
        long j = this.c;
        if (!this.b) {
            return j;
        }
        long jA = this.f8405a.a() - this.d;
        com.opos.exoplayer.core.n nVar = this.e;
        return j + (nVar.b == 1.0f ? C.b(jA) : nVar.a(jA));
    }

    @Override // com.opos.exoplayer.core.util.l
    public com.opos.exoplayer.core.n e() {
        return this.e;
    }

    public void a() {
        if (this.b) {
            return;
        }
        this.d = this.f8405a.a();
        this.b = true;
    }

    public void a(long j) {
        this.c = j;
        if (this.b) {
            this.d = this.f8405a.a();
        }
    }
}
