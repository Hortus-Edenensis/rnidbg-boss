package com.opos.mobad.m;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public abstract class d extends k implements com.opos.mobad.ad.d.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.ad.d.d f8972a;

    public d(com.opos.mobad.ad.d.d dVar) {
        super(dVar);
        this.f8972a = dVar;
    }

    @Override // com.opos.mobad.m.j, com.opos.mobad.ad.b
    public void b() {
        this.f8972a = null;
        super.b();
    }

    public final void g() {
        com.opos.mobad.ad.d.d dVar;
        if (c() == 5 || (dVar = this.f8972a) == null) {
            return;
        }
        dVar.onVideoPlayComplete();
    }
}
