package com.opos.mobad.f.a.a;

import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class r<P> implements com.opos.mobad.ad.e.a<P> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f8822a;
    private final p b;

    public r(int i, p pVar) {
        this.f8822a = i;
        this.b = pVar;
    }

    @Override // com.opos.mobad.ad.e.a
    public void onAdFailed(int i, String str) {
        com.opos.cmn.an.f.a.a("delegator", "delegator onAdFailed adChannel:" + this.f8822a + ", code:" + i + ", msg:" + str);
        p pVar = this.b;
        int i2 = this.f8822a;
        pVar.a(m.a(i2, i2, i, str));
    }

    @Override // com.opos.mobad.ad.e.a
    public void onAdSuccess(List<P> list) {
        HashMap map;
        p pVar = this.b;
        if (pVar instanceof s) {
            map = ((s) pVar).f8823a;
        } else {
            if (!(pVar instanceof t)) {
                com.opos.cmn.an.f.a.a("delegator", "delegator instance error");
                com.opos.cmn.an.f.a.a("delegator", "delegator onAdReady:" + this.f8822a);
                this.b.d(this.f8822a);
            }
            map = ((t) pVar).f8824a;
        }
        map.put(Integer.valueOf(this.f8822a), list);
        com.opos.cmn.an.f.a.a("delegator", "delegator onAdReady:" + this.f8822a);
        this.b.d(this.f8822a);
    }
}
