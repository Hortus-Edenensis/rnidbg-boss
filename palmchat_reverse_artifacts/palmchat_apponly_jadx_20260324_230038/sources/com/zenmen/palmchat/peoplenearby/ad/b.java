package com.zenmen.palmchat.peoplenearby.ad;

import android.os.Bundle;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.eg4;
import defpackage.v4;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TTRewardVideoAd f14983a;
    public String b = h();
    public String c;
    public eg4 d;
    public boolean e;

    public b(eg4 eg4Var, String str) {
        this.d = eg4Var;
        this.c = str;
    }

    public static String h() {
        return v4.e(com.zenmen.palmchat.c.b()) + System.currentTimeMillis();
    }

    public String d() {
        return this.b;
    }

    public eg4 e() {
        return this.d;
    }

    public TTRewardVideoAd f() {
        return this.f14983a;
    }

    public boolean g() {
        return this.e;
    }

    public void i(eg4 eg4Var) {
        this.d = eg4Var;
    }

    public void j(TTRewardVideoAd tTRewardVideoAd) {
        this.f14983a = tTRewardVideoAd;
        if (tTRewardVideoAd == null) {
            return;
        }
        tTRewardVideoAd.setRewardAdInteractionListener(new a(tTRewardVideoAd));
        this.f14983a.setDownloadListener(new C1095b(tTRewardVideoAd));
    }

    public void k(boolean z) {
        this.e = z;
    }

    /* JADX INFO: renamed from: com.zenmen.palmchat.peoplenearby.ad.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C1095b implements TTAppDownloadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f14985a = false;
        public final /* synthetic */ TTRewardVideoAd b;

        public C1095b(TTRewardVideoAd tTRewardVideoAd) {
            this.b = tTRewardVideoAd;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadActive(long j, long j2, String str, String str2) {
            if (this.f14985a) {
                return;
            }
            this.f14985a = true;
            c.a().e(b.this.c).f("lx_client_sdkad_downloadS").i(this.b.getInteractionType()).m(this.b.getRewardVideoAdType()).b(b.this.b).c(str2).j();
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadFinished(long j, String str, String str2) {
            c.a().e(b.this.c).f("lx_client_sdkad_downloadF").i(this.b.getInteractionType()).m(this.b.getRewardVideoAdType()).b(b.this.b).c(str2).j();
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onInstalled(String str, String str2) {
            c.a().e(b.this.c).f("lx_client_sdkad_downloadO").i(this.b.getInteractionType()).m(this.b.getRewardVideoAdType()).b(b.this.b).c(str2).j();
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onIdle() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadFailed(long j, long j2, String str, String str2) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadPaused(long j, long j2, String str, String str2) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements TTRewardVideoAd.RewardAdInteractionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TTRewardVideoAd f14984a;

        public a(TTRewardVideoAd tTRewardVideoAd) {
            this.f14984a = tTRewardVideoAd;
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onAdClose() {
            LogUtil.d("logad", "Callback --> rewardVideoAd close");
            if (b.this.d != null) {
                b.this.d.l0();
            }
            c.a().e(b.this.c).f("lx_client_sdkad_radclose").i(this.f14984a.getInteractionType()).m(this.f14984a.getRewardVideoAdType()).b(b.this.b).j();
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onAdShow() {
            LogUtil.d("logad", "Callback --> rewardVideoAd show");
            c.a().e(b.this.c).f("lx_client_sdkad_show").i(this.f14984a.getInteractionType()).m(this.f14984a.getRewardVideoAdType()).b(b.this.b).j();
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onAdVideoBarClick() {
            LogUtil.d("logad", "Callback --> rewardVideoAd bar click");
            c.a().e(b.this.c).f("lx_client_sdkad_click").i(this.f14984a.getInteractionType()).m(this.f14984a.getRewardVideoAdType()).b(b.this.b).j();
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onRewardVerify(boolean z, int i, String str, int i2, String str2) {
            LogUtil.d("logad", "Callback --> onRewardVerify: " + z);
            if (b.this.d != null) {
                b.this.d.W(PeopleNearbyAdLoadMore.i());
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onSkippedVideo() {
            LogUtil.e("logad", "Callback --> rewardVideoAd has onSkippedVideo");
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onVideoComplete() {
            LogUtil.d("logad", "Callback --> rewardVideoAd complete");
            c.a().e(b.this.c).f("lx_client_sdkad_videoE").i(this.f14984a.getInteractionType()).m(this.f14984a.getRewardVideoAdType()).b(b.this.b).j();
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onVideoError() {
            LogUtil.e("logad", "Callback --> rewardVideoAd error");
            c.a().e(b.this.c).f("lx_client_sdkad_videoload").i(this.f14984a.getInteractionType()).m(this.f14984a.getRewardVideoAdType()).b(b.this.b).j();
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onRewardArrived(boolean z, int i, Bundle bundle) {
        }
    }
}
