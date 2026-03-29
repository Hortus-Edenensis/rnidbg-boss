package com.opos.mobad.ad.e;

import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public interface m extends f, com.opos.mobad.ad.i, com.opos.mobad.ad.k {
    public static final m b = new m() { // from class: com.opos.mobad.ad.e.m.1
        @Override // com.opos.mobad.ad.e.f
        public void onAdError(q qVar, d dVar) {
            com.opos.cmn.an.f.a.b("INativeRewardAdListener", "onAdError nativeAdError=", qVar, "iNativeAdData=", dVar);
        }

        @Override // com.opos.mobad.ad.e.f
        public void onAdFailed(q qVar) {
            com.opos.cmn.an.f.a.b("INativeRewardAdListener", "onAdFailed=", qVar);
        }

        @Override // com.opos.mobad.ad.e.f
        public void onAdSuccess(List<d> list) {
            com.opos.cmn.an.f.a.b("INativeRewardAdListener", "onAdReady =", list);
        }

        @Override // com.opos.mobad.ad.i
        public void onInstallCompleted(String str) {
            com.opos.cmn.an.f.a.b("INativeRewardAdListener", "onInstallCompleted pkgName=" + str);
        }

        @Override // com.opos.mobad.ad.k
        public void onReward(Object... objArr) {
            StringBuilder sb = new StringBuilder();
            sb.append("onReward objects=");
            Object obj = objArr;
            if (objArr == null) {
                obj = com.igexin.push.core.b.m;
            }
            sb.append(obj);
            com.opos.cmn.an.f.a.b("INativeRewardAdListener", sb.toString());
        }

        @Override // com.opos.mobad.ad.e.m
        public void onRewardFail(Object... objArr) {
            StringBuilder sb = new StringBuilder();
            sb.append("onRewardFail objects=");
            Object obj = objArr;
            if (objArr == null) {
                obj = com.igexin.push.core.b.m;
            }
            sb.append(obj);
            com.opos.cmn.an.f.a.b("INativeRewardAdListener", sb.toString());
        }
    };

    void onRewardFail(Object... objArr);
}
