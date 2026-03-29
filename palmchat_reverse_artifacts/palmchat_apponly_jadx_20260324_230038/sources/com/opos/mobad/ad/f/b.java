package com.opos.mobad.ad.f;

import com.opos.mobad.ad.k;
import com.opos.mobad.ad.m;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public interface b extends k, m.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f8534a = new b() { // from class: com.opos.mobad.ad.f.b.1
        @Override // com.opos.mobad.ad.f.b, com.opos.mobad.ad.m.b
        public void onAdClick(long j) {
            com.opos.cmn.an.f.a.b("IRewardVideoAdListener", "onAdClick currentPosition=" + j);
        }

        @Override // com.opos.mobad.ad.b.a
        public void onAdClose() {
            com.opos.cmn.an.f.a.b("IRewardVideoAdListener", "onAdClose");
        }

        @Override // com.opos.mobad.ad.b.a
        public void onAdFailed(int i, String str) {
            com.opos.cmn.an.f.a.b("IRewardVideoAdListener", "onAdFailed code:" + i + ",msg:" + str);
        }

        @Override // com.opos.mobad.ad.b.a
        public void onAdReady() {
            com.opos.cmn.an.f.a.b("IRewardVideoAdListener", "onAdReady");
        }

        @Override // com.opos.mobad.ad.m.b
        public void onAdShow(String str) {
            com.opos.cmn.an.f.a.b("IRewardVideoAdListener", "onAdShow");
        }

        @Override // com.opos.mobad.ad.f.b
        public void onLandingPageClose() {
            com.opos.cmn.an.f.a.b("IRewardVideoAdListener", "onLandingPageClose");
        }

        @Override // com.opos.mobad.ad.f.b
        public void onLandingPageOpen() {
            com.opos.cmn.an.f.a.b("IRewardVideoAdListener", "onLandingPageOpen");
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
            com.opos.cmn.an.f.a.b("IRewardVideoAdListener", sb.toString());
        }

        @Override // com.opos.mobad.ad.f.b
        public void onVideoPlayClose(long j) {
            com.opos.cmn.an.f.a.b("IRewardVideoAdListener", "onVideoPlayClose currentPosition=" + j);
        }

        @Override // com.opos.mobad.ad.f.b
        public void onVideoPlayComplete() {
            com.opos.cmn.an.f.a.b("IRewardVideoAdListener", "onVideoPlayComplete");
        }

        @Override // com.opos.mobad.ad.f.b
        public void onVideoPlayError(String str) {
            StringBuilder sb = new StringBuilder();
            sb.append("onVideoPlayError msg=");
            if (str == null) {
                str = com.igexin.push.core.b.m;
            }
            sb.append(str);
            com.opos.cmn.an.f.a.b("IRewardVideoAdListener", sb.toString());
        }

        @Override // com.opos.mobad.ad.f.b
        public void onVideoPlayStart() {
            com.opos.cmn.an.f.a.b("IRewardVideoAdListener", "onVideoPlayStart");
        }
    };

    void onAdClick(long j);

    void onLandingPageClose();

    void onLandingPageOpen();

    void onVideoPlayClose(long j);

    void onVideoPlayComplete();

    void onVideoPlayError(String str);

    void onVideoPlayStart();
}
