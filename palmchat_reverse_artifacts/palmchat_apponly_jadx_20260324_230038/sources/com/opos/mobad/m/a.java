package com.opos.mobad.m;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public abstract class a extends j implements com.opos.mobad.ad.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.ad.a.c f8971a;

    public a(com.opos.mobad.ad.a.c cVar) {
        super(cVar);
        this.f8971a = cVar;
    }

    @Override // com.opos.mobad.m.j, com.opos.mobad.ad.b
    public void b() {
        if (this.f8971a != null) {
            this.f8971a = null;
        }
        super.b();
    }

    public final void h() {
        com.opos.mobad.ad.a.c cVar;
        if (5 == c() || (cVar = this.f8971a) == null) {
            return;
        }
        cVar.onAdClick(0L);
    }

    public final void i() {
        com.opos.mobad.ad.a.c cVar;
        if (c() == 5 || (cVar = this.f8971a) == null) {
            return;
        }
        cVar.onAdShow("");
    }
}
