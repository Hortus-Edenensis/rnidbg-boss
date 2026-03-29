package com.zenmen.palmchat.peoplenearby.ad;

import android.app.Activity;
import android.text.TextUtils;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.helper.AdHelperReward;
import com.wifi.ad.core.listener.RewardListener;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.peoplenearby.ad.PeopleNearbyAdLoadMore;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.sync.dynamic.DynamicItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.cg4;
import defpackage.cw3;
import defpackage.eg4;
import defpackage.fg6;
import defpackage.jo6;
import defpackage.k86;
import defpackage.rl0;
import defpackage.tv3;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class a {
    public static tv3 e = null;
    public static String f = "NestPeopleNearbyAdLoadMore";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f14981a;
    public eg4 b;
    public boolean c = false;
    public RewardListener d = new C1094a();

    public a(Activity activity) {
        this.f14981a = activity;
    }

    public static int f() {
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

    public static int g() {
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

    public static int h() {
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

    public static int i() {
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

    public static int j() {
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

    public static String k() {
        String strC = jo6.c("LX-28916", "A");
        LogUtil.i(f, "getTaichiValue " + strC);
        return strC;
    }

    public static boolean m() {
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.NEARBY_TV);
        if (dynamicConfig != null) {
            return dynamicConfig.isEnable();
        }
        return true;
    }

    public static boolean n() {
        return !jo6.g("LX-28916");
    }

    public PeopleNearbyAdLoadMore.Status e() {
        if (!n() || !m() || fg6.d(AppContext.getContext())) {
            return PeopleNearbyAdLoadMore.Status.DISABLE;
        }
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.NEARBY;
        long jI = sPUtil.i(scene, k86.a("nearby_ad_nest_reward_verify_time"), 0L);
        return (cg4.b(jI, System.currentTimeMillis()) ? sPUtil.i(scene, k86.a("nearby_ad_nest_reward_verify_count"), 0L) : 0L) >= ((long) g()) ? PeopleNearbyAdLoadMore.Status.LIMITED_COUNT : System.currentTimeMillis() - jI < ((long) (h() * 60)) * 1000 ? PeopleNearbyAdLoadMore.Status.LIMITED_INTERVAL : PeopleNearbyAdLoadMore.Status.NORMAL;
    }

    public long l() {
        return SPUtil.f14322a.i(SPUtil.SCENE.NEARBY, k86.a("nearby_ad_nest_reward_verify_count"), 0L);
    }

    public void o(eg4 eg4Var, String str, boolean z) {
        this.b = eg4Var;
        Activity activity = this.f14981a;
        if (activity == null || activity.isFinishing() || !(this.f14981a instanceof Activity)) {
            LogUtil.d(f + " logad", "loadAd: activity null");
            return;
        }
        if (eg4Var == null) {
            LogUtil.d(f + " logad", "loadAd: listener null");
            return;
        }
        if (this.c) {
            LogUtil.d(f + " logad", "loadAd: isLoading");
            return;
        }
        if (e != null) {
            LogUtil.d(f + " logad", "loadAd: video!=null");
            e.d(z);
            return;
        }
        AdHelperReward adHelperRewardCreateRewardAd = WifiNestAd.INSTANCE.createRewardAd();
        if (adHelperRewardCreateRewardAd == null) {
            LogUtil.d(f + " logad", "adHelperReward null");
            return;
        }
        this.c = true;
        tv3 tv3Var = new tv3();
        e = tv3Var;
        tv3Var.d(z);
        cw3.c(this.f14981a, adHelperRewardCreateRewardAd, str, 8, "LX-28916", k(), this.d);
    }

    public void p() {
        this.f14981a = null;
        this.b = null;
        cw3.d();
    }

    public void q() {
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.NEARBY;
        long jI = cg4.b(sPUtil.i(scene, k86.a("nearby_ad_nest_reward_verify_time"), 0L), System.currentTimeMillis()) ? 1 + sPUtil.i(scene, k86.a("nearby_ad_nest_reward_verify_count"), 0L) : 1L;
        sPUtil.t(scene, k86.a("nearby_ad_nest_reward_verify_time"), Long.valueOf(System.currentTimeMillis()));
        sPUtil.t(scene, k86.a("nearby_ad_nest_reward_verify_count"), Long.valueOf(jI));
    }

    public boolean r() {
        tv3 tv3Var = e;
        if (tv3Var == null) {
            return false;
        }
        if (tv3Var.a() == null) {
            e = null;
            return false;
        }
        cw3.e(this.f14981a, e.a(), this.d);
        e = null;
        return true;
    }

    /* JADX INFO: renamed from: com.zenmen.palmchat.peoplenearby.ad.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C1094a implements RewardListener {
        public C1094a() {
        }

        @Override // com.wifi.ad.core.listener.RewardListener
        public void onAdClose(NestAdData nestAdData) {
            if (a.this.b != null) {
                a.this.b.l0();
            }
        }

        @Override // com.wifi.ad.core.listener.RewardListener
        public void onAdExpose(NestAdData nestAdData) {
            if (a.this.b != null) {
                a.this.b.m0(nestAdData != null ? nestAdData.getAdCode() : "");
            }
        }

        @Override // com.wifi.ad.core.listener.RewardListener, com.wifi.ad.core.listener.BaseListener
        public void onAdFailed(String str, String str2) {
            a.this.c = false;
            a.e = null;
            if (a.this.b != null) {
                a.this.b.k();
            }
        }

        @Override // com.wifi.ad.core.listener.RewardListener, com.wifi.ad.core.listener.BaseListener
        public void onAdLoaded(String str, List<NestAdData> list) {
            a.this.c = false;
            if (list == null || list.size() == 0) {
                LogUtil.d(a.f + " logad", "Callback --> onError: ad=null");
                return;
            }
            if (a.e == null) {
                LogUtil.d(a.f + " logad", "Callback --> onError: mNestAd=null");
                return;
            }
            if (a.this.b != null) {
                a.this.b.R();
            }
            a.e.c(list.get(0));
            if (a.e.b()) {
                a.this.r();
            }
        }

        @Override // com.wifi.ad.core.listener.RewardListener
        public void onAdRewardVerify(NestAdData nestAdData) {
            if (a.this.b != null) {
                a.this.b.W(nestAdData != null ? nestAdData.getAdCode() : "");
            }
        }

        @Override // com.wifi.ad.core.listener.RewardListener
        public void onAdClicked(NestAdData nestAdData) {
        }

        @Override // com.wifi.ad.core.listener.RewardListener
        public void onAdShow(NestAdData nestAdData) {
        }

        @Override // com.wifi.ad.core.listener.RewardListener
        public void onAdVideoCached(NestAdData nestAdData) {
        }

        @Override // com.wifi.ad.core.listener.RewardListener
        public void onAdVideoComplete(NestAdData nestAdData) {
        }

        @Override // com.wifi.ad.core.listener.RewardListener
        public void onVideoPreloadFailed(NestAdData nestAdData) {
        }

        @Override // com.wifi.ad.core.listener.RewardListener, com.wifi.ad.core.listener.BaseListener
        public void onStart() {
        }
    }
}
