package com.opos.mobad.ad.e;

import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public interface o extends a<p> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f8526a = new o() { // from class: com.opos.mobad.ad.e.o.1
        @Override // com.opos.mobad.ad.e.o
        public void onAdClick(p pVar) {
            StringBuilder sb = new StringBuilder();
            sb.append("onAdClick iNativeTempletAdView=");
            Object obj = pVar;
            if (pVar == null) {
                obj = com.igexin.push.core.b.m;
            }
            sb.append(obj);
            com.opos.cmn.an.f.a.b("INativeTempletAdListener", sb.toString());
        }

        @Override // com.opos.mobad.ad.e.o
        public void onAdClose(p pVar) {
            StringBuilder sb = new StringBuilder();
            sb.append("onAdClose iNativeTempletAdView=");
            Object obj = pVar;
            if (pVar == null) {
                obj = com.igexin.push.core.b.m;
            }
            sb.append(obj);
            com.opos.cmn.an.f.a.b("INativeTempletAdListener", sb.toString());
        }

        @Override // com.opos.mobad.ad.e.a
        public void onAdFailed(int i, String str) {
            com.opos.cmn.an.f.a.b("INativeTempletAdListener", "onAdFailed ret=" + i + ",msg=" + str);
        }

        @Override // com.opos.mobad.ad.e.o
        public void onAdShow(p pVar) {
            StringBuilder sb = new StringBuilder();
            sb.append("onAdShow iNativeTempletAdView=");
            Object obj = pVar;
            if (pVar == null) {
                obj = com.igexin.push.core.b.m;
            }
            sb.append(obj);
            com.opos.cmn.an.f.a.b("INativeTempletAdListener", sb.toString());
        }

        @Override // com.opos.mobad.ad.e.a
        public void onAdSuccess(List<p> list) {
            com.opos.cmn.an.f.a.b("INativeTempletAdListener", "onAdReady iNativeTempletAdViewList=", list);
        }

        @Override // com.opos.mobad.ad.e.o
        public void onRenderFailed(q qVar, p pVar) {
            StringBuilder sb = new StringBuilder();
            sb.append("onRenderFailed nativeAdError=");
            sb.append(qVar != null ? qVar.toString() : com.igexin.push.core.b.m);
            sb.append("iNativeTempletAdView=");
            Object obj = pVar;
            if (pVar == null) {
                obj = com.igexin.push.core.b.m;
            }
            sb.append(obj);
            com.opos.cmn.an.f.a.b("INativeTempletAdListener", sb.toString());
        }

        @Override // com.opos.mobad.ad.e.o
        public void onRenderSuccess(p pVar) {
            StringBuilder sb = new StringBuilder();
            sb.append("onRenderSuccess iNativeTempletAdView=");
            Object obj = pVar;
            if (pVar == null) {
                obj = com.igexin.push.core.b.m;
            }
            sb.append(obj);
            com.opos.cmn.an.f.a.b("INativeTempletAdListener", sb.toString());
        }
    };

    void onAdClick(p pVar);

    void onAdClose(p pVar);

    void onAdShow(p pVar);

    void onRenderFailed(q qVar, p pVar);

    void onRenderSuccess(p pVar);
}
