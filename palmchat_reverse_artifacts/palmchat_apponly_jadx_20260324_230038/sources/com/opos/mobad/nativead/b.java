package com.opos.mobad.nativead;

import com.opos.mobad.ad.e.m;
import com.opos.mobad.ad.e.q;
import com.opos.mobad.model.data.AdData;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public abstract class b extends a {
    protected com.opos.mobad.ad.e.f h;
    protected int i;
    protected volatile String j;

    public b(com.opos.mobad.b bVar, String str, int i, com.opos.mobad.cmn.func.a aVar, com.opos.mobad.ad.e.f fVar, com.opos.mobad.cmn.func.adhandler.f fVar2) {
        super(bVar, str, aVar, fVar2);
        this.i = i;
        this.h = fVar;
    }

    public void a(q qVar) {
        if (qVar != null) {
            try {
                com.opos.cmn.an.f.a.b("InterBaseNativeAd", "notifyOnAdFailed nativeAdError=" + qVar.toString());
                b().onAdFailed(qVar);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("InterBaseNativeAd", "", (Throwable) e);
            }
        }
    }

    public com.opos.mobad.ad.e.f b() {
        com.opos.mobad.ad.e.f fVar = this.h;
        return fVar != null ? fVar : com.opos.mobad.ad.e.f.f8525a;
    }

    public m c() {
        com.opos.mobad.ad.e.f fVar = this.h;
        return (fVar == null || !(fVar instanceof m)) ? m.b : (m) fVar;
    }

    public b(com.opos.mobad.b bVar, String str, com.opos.mobad.cmn.func.a aVar, com.opos.mobad.ad.e.f fVar, com.opos.mobad.cmn.func.adhandler.f fVar2) {
        super(bVar, str, aVar, fVar2);
        this.h = fVar;
    }

    public void a(AdData adData, List<com.opos.mobad.ad.e.d> list) {
        try {
            com.opos.cmn.an.f.a.b("InterBaseNativeAd", "notifyOnAdReady");
            if (adData == null || list == null) {
                return;
            }
            b().onAdSuccess(list);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("InterBaseNativeAd", "", (Throwable) e);
        }
    }
}
