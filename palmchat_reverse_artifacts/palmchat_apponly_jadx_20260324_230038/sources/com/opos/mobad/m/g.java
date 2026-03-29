package com.opos.mobad.m;

import com.opos.mobad.ad.e.q;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public abstract class g extends f<com.opos.mobad.ad.e.p> implements com.opos.mobad.ad.e.n {
    private com.opos.mobad.ad.e.o b;

    public g(com.opos.mobad.ad.e.o oVar) {
        super(oVar);
        this.b = oVar;
    }

    public void a(com.opos.mobad.ad.e.p pVar) {
        com.opos.mobad.ad.e.o oVar;
        if (5 == c() || (oVar = this.b) == null) {
            return;
        }
        oVar.onAdClick(pVar);
    }

    public void b(com.opos.mobad.ad.e.p pVar) {
        com.opos.mobad.ad.e.o oVar;
        if (5 == c() || (oVar = this.b) == null) {
            return;
        }
        oVar.onAdShow(pVar);
    }

    public void c(com.opos.mobad.ad.e.p pVar) {
        com.opos.mobad.ad.e.o oVar;
        if (5 == c() || (oVar = this.b) == null) {
            return;
        }
        oVar.onAdClose(pVar);
    }

    public void d(com.opos.mobad.ad.e.p pVar) {
        com.opos.mobad.ad.e.o oVar;
        if (5 == c() || (oVar = this.b) == null) {
            return;
        }
        oVar.onRenderSuccess(pVar);
    }

    public void a(q qVar, com.opos.mobad.ad.e.p pVar) {
        com.opos.mobad.ad.e.o oVar;
        if (5 == c() || (oVar = this.b) == null) {
            return;
        }
        oVar.onRenderFailed(qVar, pVar);
    }
}
