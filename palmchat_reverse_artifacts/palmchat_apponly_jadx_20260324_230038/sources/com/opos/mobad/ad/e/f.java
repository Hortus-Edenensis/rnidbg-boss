package com.opos.mobad.ad.e;

import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public interface f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f8525a = new f() { // from class: com.opos.mobad.ad.e.f.1
        @Override // com.opos.mobad.ad.e.f
        public void onAdError(q qVar, d dVar) {
            com.opos.cmn.an.f.a.b("INativeAdListener", "onAdError nativeAdError=", qVar, "iNativeAdData=", dVar);
        }

        @Override // com.opos.mobad.ad.e.f
        public void onAdFailed(q qVar) {
            com.opos.cmn.an.f.a.b("INativeAdListener", "onAdFailed=", qVar);
        }

        @Override // com.opos.mobad.ad.e.f
        public void onAdSuccess(List<d> list) {
            com.opos.cmn.an.f.a.b("INativeAdListener", "onAdReady =", list);
        }
    };

    void onAdError(q qVar, d dVar);

    void onAdFailed(q qVar);

    void onAdSuccess(List<d> list);
}
