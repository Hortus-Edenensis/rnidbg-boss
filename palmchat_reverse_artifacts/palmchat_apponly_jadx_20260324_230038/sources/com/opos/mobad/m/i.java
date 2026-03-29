package com.opos.mobad.m;

import android.view.View;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public abstract class i extends j implements com.opos.mobad.ad.g.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.ad.g.c f8981a;

    public i(com.opos.mobad.ad.g.c cVar) {
        super(cVar);
        this.f8981a = cVar;
    }

    public void e(String str) {
        com.opos.mobad.ad.g.c cVar;
        if (5 == c() || (cVar = this.f8981a) == null) {
            return;
        }
        cVar.onAdShow(str);
    }

    public View j() {
        return null;
    }

    public boolean k() {
        return false;
    }

    public final void m() {
        com.opos.mobad.ad.g.c cVar;
        if (5 == c() || (cVar = this.f8981a) == null) {
            return;
        }
        cVar.onAdClick(0L);
    }

    @Override // com.opos.mobad.m.j
    public void n() {
        com.opos.mobad.ad.g.c cVar;
        if (5 == c() || (cVar = this.f8981a) == null) {
            return;
        }
        cVar.onAdClose();
    }

    public void h() {
    }

    public void i() {
    }
}
