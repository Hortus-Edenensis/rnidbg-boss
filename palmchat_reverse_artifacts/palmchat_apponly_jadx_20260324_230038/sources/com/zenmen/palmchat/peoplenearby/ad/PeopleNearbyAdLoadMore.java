package com.zenmen.palmchat.peoplenearby.ad;

import android.app.Activity;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.sync.dynamic.DynamicItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.cg4;
import defpackage.eg4;
import defpackage.jo6;
import defpackage.k86;
import defpackage.rl0;
import defpackage.v4;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class PeopleNearbyAdLoadMore {
    public static b e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f14979a;
    public eg4 b;
    public boolean c = false;
    public long d = 0;

    /* JADX INFO: compiled from: SearchBox */
    public enum Status {
        NORMAL,
        DISABLE,
        LIMITED_INTERVAL,
        LIMITED_COUNT
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements TTAdNative.RewardVideoAdListener {
        public a() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onError(int i, String str) {
            LogUtil.d("logad", "Callback --> onError: " + i + ", " + str);
            PeopleNearbyAdLoadMore.this.c = false;
            if (PeopleNearbyAdLoadMore.e != null) {
                c.a().e(PeopleNearbyAdLoadMore.i()).f("lx_client_sdkad_getfail").l(System.currentTimeMillis() - PeopleNearbyAdLoadMore.this.d).b(PeopleNearbyAdLoadMore.e.d()).d(i).g(str).j();
            }
            PeopleNearbyAdLoadMore.e = null;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onRewardVideoAdLoad(TTRewardVideoAd tTRewardVideoAd) {
            PeopleNearbyAdLoadMore.this.c = false;
            if (tTRewardVideoAd == null || PeopleNearbyAdLoadMore.e == null) {
                LogUtil.d("logad", "Callback --> onError: ad=null");
                return;
            }
            LogUtil.d("logad", "Callback --> onRewardVideoAdLoad type=" + PeopleNearbyAdLoadMore.this.g(tTRewardVideoAd.getRewardVideoAdType()));
            PeopleNearbyAdLoadMore.e.j(tTRewardVideoAd);
            c.a().e(PeopleNearbyAdLoadMore.i()).f("lx_client_sdkad_get").i(tTRewardVideoAd.getInteractionType()).m(tTRewardVideoAd.getRewardVideoAdType()).l(System.currentTimeMillis() - PeopleNearbyAdLoadMore.this.d).b(PeopleNearbyAdLoadMore.e.d()).j();
            if (PeopleNearbyAdLoadMore.e.g()) {
                PeopleNearbyAdLoadMore.this.t();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onRewardVideoCached() {
            LogUtil.d("logad", "Callback --> onRewardVideoCached1");
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onRewardVideoCached(TTRewardVideoAd tTRewardVideoAd) {
            LogUtil.d("logad", "Callback --> onRewardVideoCached2");
        }
    }

    public PeopleNearbyAdLoadMore(Activity activity) {
        this.f14979a = activity;
    }

    public static int h() {
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.NEARBY_TV);
        if (dynamicConfig == null) {
            return 200;
        }
        String extra = dynamicConfig.getExtra();
        if (!TextUtils.isEmpty(extra)) {
            try {
                return Math.max(1, new JSONObject(extra).optInt("bannerP", 200));
            } catch (Exception unused) {
            }
        }
        return 200;
    }

    public static String i() {
        return jo6.h("LX-22549") ? "945715476" : "945734209";
    }

    public static int j() {
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.NEARBY_TV);
        if (dynamicConfig == null) {
            return 3;
        }
        String extra = dynamicConfig.getExtra();
        if (!TextUtils.isEmpty(extra)) {
            try {
                return Math.max(1, new JSONObject(extra).optInt("limit", 3));
            } catch (Exception unused) {
            }
        }
        return 3;
    }

    public static int k() {
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.NEARBY_TV);
        if (dynamicConfig == null) {
            return 10;
        }
        String extra = dynamicConfig.getExtra();
        if (!TextUtils.isEmpty(extra)) {
            try {
                return new JSONObject(extra).optInt("interval", 10);
            } catch (Exception unused) {
            }
        }
        return 10;
    }

    public static int l() {
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.NEARBY_TV);
        if (dynamicConfig == null) {
            return 300;
        }
        String extra = dynamicConfig.getExtra();
        if (!TextUtils.isEmpty(extra)) {
            try {
                return new JSONObject(extra).optInt("minValue", 300);
            } catch (Exception unused) {
            }
        }
        return 300;
    }

    public static int m() {
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.NEARBY_TV);
        if (dynamicConfig == null) {
            return 150;
        }
        String extra = dynamicConfig.getExtra();
        if (!TextUtils.isEmpty(extra)) {
            try {
                return new JSONObject(extra).optInt("requestTime", 150);
            } catch (Exception unused) {
            }
        }
        return 150;
    }

    public static boolean o() {
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.NEARBY_TV);
        if (dynamicConfig != null) {
            return dynamicConfig.isEnable();
        }
        return true;
    }

    public static boolean p() {
        return !jo6.g("LX-22549");
    }

    public Status f() {
        if (!p() || !o()) {
            return Status.DISABLE;
        }
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.NEARBY;
        long jI = sPUtil.i(scene, k86.a("nearby_ad_reward_verify_time"), 0L);
        return (cg4.b(jI, System.currentTimeMillis()) ? sPUtil.i(scene, k86.a("nearby_ad_reward_verify_count"), 0L) : 0L) >= ((long) j()) ? Status.LIMITED_COUNT : System.currentTimeMillis() - jI < ((long) (k() * 60)) * 1000 ? Status.LIMITED_INTERVAL : Status.NORMAL;
    }

    public final String g(int i) {
        if (i == 0) {
            return "普通激励视频，type=" + i;
        }
        if (i == 1) {
            return "Playable激励视频，type=" + i;
        }
        if (i != 2) {
            return "未知类型+type=" + i;
        }
        return "纯Playable，type=" + i;
    }

    public long n() {
        return SPUtil.f14322a.i(SPUtil.SCENE.NEARBY, k86.a("nearby_ad_reward_verify_count"), 0L);
    }

    public void q(eg4 eg4Var, boolean z) {
        this.b = eg4Var;
        Activity activity = this.f14979a;
        if (activity == null || activity.isFinishing() || !(this.f14979a instanceof Activity)) {
            LogUtil.d("logad", "loadAd: activity is error");
            return;
        }
        if (eg4Var == null) {
            return;
        }
        if (this.c) {
            LogUtil.d("logad", "loadAd: isLoading");
            return;
        }
        if (e != null) {
            LogUtil.d("logad", "loadAd: video!=null");
            e.i(eg4Var);
            e.k(z);
            return;
        }
        TTAdManager adManager = TTAdSdk.getAdManager();
        if (adManager == null) {
            LogUtil.d("logad", "loadAd: adManager=null");
            return;
        }
        LogUtil.d("logad", "loadAd: begin");
        TTAdNative tTAdNativeCreateAdNative = adManager.createAdNative(this.f14979a);
        if (tTAdNativeCreateAdNative == null) {
            return;
        }
        AdSlot adSlotBuild = new AdSlot.Builder().setCodeId(i()).setSupportDeepLink(true).setExpressViewAcceptedSize(500.0f, 500.0f).setUserID(v4.e(com.zenmen.palmchat.c.b())).setOrientation(1).build();
        this.c = true;
        this.d = System.currentTimeMillis();
        b bVar = new b(eg4Var, i());
        e = bVar;
        bVar.k(z);
        tTAdNativeCreateAdNative.loadRewardVideoAd(adSlotBuild, new a());
        c.a().e(i()).f("lx_client_sdkad_req").j();
    }

    public void r() {
        this.f14979a = null;
        b bVar = e;
        if (bVar == null || bVar.e() != this.b) {
            return;
        }
        e.i(null);
    }

    public void s() {
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.NEARBY;
        long jI = cg4.b(sPUtil.i(scene, k86.a("nearby_ad_reward_verify_time"), 0L), System.currentTimeMillis()) ? 1 + sPUtil.i(scene, k86.a("nearby_ad_reward_verify_count"), 0L) : 1L;
        sPUtil.t(scene, k86.a("nearby_ad_reward_verify_time"), Long.valueOf(System.currentTimeMillis()));
        sPUtil.t(scene, k86.a("nearby_ad_reward_verify_count"), Long.valueOf(jI));
    }

    public boolean t() {
        Activity activity = this.f14979a;
        if (activity == null || activity.isFinishing() || !(this.f14979a instanceof Activity)) {
            LogUtil.d("logad", "showAd: activity is error");
            return false;
        }
        b bVar = e;
        if (bVar == null || bVar.f() == null) {
            LogUtil.d("logad", "showAd: video=null");
            return false;
        }
        e.f().showRewardVideoAd(this.f14979a);
        e = null;
        return true;
    }
}
