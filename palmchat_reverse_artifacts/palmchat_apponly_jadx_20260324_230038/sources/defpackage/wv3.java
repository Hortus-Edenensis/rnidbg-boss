package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.config.AdParams;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.helper.AdHelperH5Ad;
import com.wifi.ad.core.listener.FeedLoadListener;
import com.wifi.ad.core.listener.RewardListener;
import com.wifi.ad.core.utils.WifiLog;
import com.zenmen.palmchat.peoplenearby.PeopleNearbyActivity;
import com.zenmen.palmchat.peoplenearby.ad.d;
import com.zenmen.palmchat.peoplenearby.ad.e;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.sync.dynamic.DynamicItem;
import defpackage.yv3;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class wv3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static yv3 f21810a;

    public static int a() {
        yv3 yv3Var = f21810a;
        if (yv3Var == null) {
            return -1;
        }
        yv3.a aVarB = yv3Var.b(8);
        StringBuilder sb = new StringBuilder();
        sb.append("getPNRequestPos request_N = ");
        sb.append(aVarB == null ? -1 : aVarB.b());
        WifiLog.d(sb.toString());
        if (aVarB == null) {
            return -1;
        }
        return aVarB.b();
    }

    public static void b() {
        try {
            DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.NEST_AD_PRELOAD);
            if (dynamicConfig == null || dynamicConfig.getExtra() == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject(dynamicConfig.getExtra());
            if (jSONObject.has(c())) {
                f21810a = new yv3(jSONObject.optJSONObject(c()));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static String c() {
        return jo6.c("LX-35297", "A");
    }

    public static boolean d(Context context, int i) {
        try {
            if (f21810a == null) {
                return false;
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences("nest_preload_ad_sp_request", 0);
            if (sharedPreferences != null) {
                long j = sharedPreferences.getLong("nest_ad_preload_last_request_time_" + i, System.currentTimeMillis());
                int i2 = sharedPreferences.getInt("nest_ad_preload_times_" + i, 0);
                if (!by5.k(j)) {
                    i2 = 0;
                }
                WifiLog.d("limitFreqAllow currentScene =" + i + " ;currentRequestTimes = " + i2);
                yv3.a aVarB = f21810a.b(i);
                if (aVarB != null) {
                    int iA = aVarB.a();
                    WifiLog.d("limitFreqAllow limitCount = " + iA);
                    if (iA > 0 && i2 < iA) {
                        WifiLog.d("limitFreqAllow allow request");
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        WifiLog.d("limitFreqAllow not allow request");
        return false;
    }

    public static void e(Activity activity) {
        if (!l6.f(40)) {
            xv3.b(1, "LX-34097", gp3.f());
            return;
        }
        if (gp3.c == -1) {
            xv3.b(2, "LX-34097", gp3.f());
            return;
        }
        if (!gp3.h()) {
            xv3.b(3, "LX-34097", gp3.f());
            return;
        }
        if (activity == null || activity.isFinishing()) {
            xv3.b(5, "LX-34097", gp3.f());
            return;
        }
        yv3 yv3Var = f21810a;
        if (yv3Var == null || yv3Var.c() == null || f21810a.c().isEmpty() || !f21810a.c().contains(40)) {
            xv3.b(6, "LX-34097", gp3.f());
            return;
        }
        if (!d(activity, 40)) {
            xv3.b(7, "LX-34097", gp3.f());
            return;
        }
        String adRequestId = AdHelperH5Ad.INSTANCE.getAdRequestId();
        HashMap map = new HashMap();
        map.put("requestId", adRequestId);
        map.put("taiChiKey", "LX-34097");
        map.put("exp_group", gp3.f());
        map.put("advanceRequest", "1");
        xv3.a(adRequestId, "LX-34097", gp3.f());
        g(activity, 40);
        WifiNestAd.INSTANCE.createAdFeed().getNativeFeedAd(activity, new AdParams.Builder().setExt(map).setScene(40).setAdUnitId("1eb7e107427689169c21").setFullStrategyJson(gp3.f17767a).build(), new a());
    }

    public static void f(Activity activity) {
        if (!l6.f(8)) {
            xv3.b(1, "LX-28916", d.h());
            return;
        }
        if (!d.j()) {
            xv3.b(8, "LX-28916", d.h());
            return;
        }
        if (!e.B()) {
            xv3.b(3, "LX-28916", d.h());
            return;
        }
        if (activity == null || activity.isFinishing() || !(activity instanceof PeopleNearbyActivity)) {
            xv3.b(5, "LX-28916", d.h());
            return;
        }
        yv3 yv3Var = f21810a;
        if (yv3Var == null || yv3Var.c() == null || f21810a.c().isEmpty() || !f21810a.c().contains(8) || a() < 0) {
            xv3.b(6, "LX-28916", d.h());
            return;
        }
        if (!d(activity, 8)) {
            xv3.b(7, "LX-28916", d.h());
            return;
        }
        String adRequestId = AdHelperH5Ad.INSTANCE.getAdRequestId();
        HashMap map = new HashMap();
        map.put("requestId", adRequestId);
        map.put("taiChiKey", "LX-28916");
        map.put("exp_group", d.h());
        map.put("advanceRequest", "1");
        xv3.a(adRequestId, "LX-28916", d.h());
        g(activity, 8);
        WifiNestAd.INSTANCE.createRewardAd().getRewardAd(activity, new AdParams.Builder().setScene(8).setExt(map).setFullStrategyJson(d.e).build(), new b((PeopleNearbyActivity) activity));
    }

    public static void g(Context context, int i) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("nest_preload_ad_sp_request", 0);
            if (sharedPreferences != null) {
                int i2 = by5.k(sharedPreferences.getLong("nest_ad_preload_last_request_time_" + i, System.currentTimeMillis())) ? 1 + sharedPreferences.getInt("nest_ad_preload_times_" + i, 0) : 1;
                sharedPreferences.edit().putLong("nest_ad_preload_last_request_time_" + i, System.currentTimeMillis()).apply();
                sharedPreferences.edit().putInt("nest_ad_preload_times_" + i, i2).apply();
                WifiLog.d("saveLimitFreqInfo currentScene =" + i + " ;currentRequestTimes = " + i2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void h(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(c())) {
                f21810a = new yv3(jSONObject.optJSONObject(c()));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements FeedLoadListener {
        @Override // com.wifi.ad.core.listener.FeedLoadListener, com.wifi.ad.core.listener.BaseListener
        public void onAdFailed(String str, String str2) {
            WifiLog.d("preloadMineBannerAd request ad onAdFailed ");
        }

        @Override // com.wifi.ad.core.listener.FeedLoadListener, com.wifi.ad.core.listener.BaseListener
        public void onAdLoaded(String str, List<NestAdData> list) {
            if (list == null || list.size() <= 0) {
                return;
            }
            list.get(0).setAdDispatchEd(Boolean.FALSE);
            WifiLog.d("preloadMineBannerAd request ad onAdLoaded ");
        }

        @Override // com.wifi.ad.core.listener.FeedLoadListener, com.wifi.ad.core.listener.BaseListener
        public void onStart() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements RewardListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PeopleNearbyActivity f21811a;

        public b(PeopleNearbyActivity peopleNearbyActivity) {
            this.f21811a = peopleNearbyActivity;
        }

        @Override // com.wifi.ad.core.listener.RewardListener
        public void onAdClose(NestAdData nestAdData) {
            PeopleNearbyActivity peopleNearbyActivity = this.f21811a;
            if (peopleNearbyActivity == null || peopleNearbyActivity.isFinishing()) {
                return;
            }
            this.f21811a.l0();
        }

        @Override // com.wifi.ad.core.listener.RewardListener, com.wifi.ad.core.listener.BaseListener
        public void onAdFailed(String str, String str2) {
            WifiLog.d("preloadMineBannerAd request ad onAdFailed ");
        }

        @Override // com.wifi.ad.core.listener.RewardListener, com.wifi.ad.core.listener.BaseListener
        public void onAdLoaded(String str, List<NestAdData> list) {
            NestAdData nestAdData;
            if (list == null || list.size() <= 0 || (nestAdData = list.get(0)) == null) {
                return;
            }
            nestAdData.setAdDispatchEd(Boolean.FALSE);
            WifiLog.d("preloadMineBannerAd request ad onAdLoaded ");
        }

        @Override // com.wifi.ad.core.listener.RewardListener
        public void onAdRewardVerify(NestAdData nestAdData) {
            PeopleNearbyActivity peopleNearbyActivity = this.f21811a;
            if (peopleNearbyActivity == null || peopleNearbyActivity.isFinishing()) {
                return;
            }
            this.f21811a.W(nestAdData.getAdCode());
        }

        @Override // com.wifi.ad.core.listener.RewardListener
        public void onAdShow(NestAdData nestAdData) {
            PeopleNearbyActivity peopleNearbyActivity = this.f21811a;
            if (peopleNearbyActivity == null || peopleNearbyActivity.isFinishing()) {
                return;
            }
            this.f21811a.m0(nestAdData.getAdCode());
        }

        @Override // com.wifi.ad.core.listener.RewardListener, com.wifi.ad.core.listener.BaseListener
        public void onStart() {
        }

        @Override // com.wifi.ad.core.listener.RewardListener
        public void onAdClicked(NestAdData nestAdData) {
        }

        @Override // com.wifi.ad.core.listener.RewardListener
        public void onAdExpose(NestAdData nestAdData) {
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
    }
}
