package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.config.AdParams;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.entity.AdSize;
import com.wifi.ad.core.helper.AdHelperFeed;
import com.wifi.ad.core.helper.AdHelperH5Ad;
import com.wifi.ad.core.listener.DislikeListener;
import com.wifi.ad.core.listener.FeedLoadListener;
import com.wifi.ad.core.spstrategy.SPCacheManager;
import com.wifi.ad.core.utils.WifiLog;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.sync.dynamic.DynamicItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class zv3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f22521a = null;
    public static String b = null;
    public static String c = null;
    public static NestAdData d = null;
    public static NestAdData e = null;
    public static NestAdData f = null;
    public static aw3 g = null;
    public static e h = null;
    public static d i = null;
    public static boolean j = false;
    public static boolean k = false;
    public static boolean l = false;
    public static boolean m = false;
    public static boolean n = false;
    public static boolean o = false;
    public static long p;
    public static long q;
    public static long r;

    /* JADX INFO: compiled from: SearchBox */
    public static class d implements NestAdData.AdInteractionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public NestAdData.AdInteractionListener f22525a = null;

        public void a() {
            if (b6.d()) {
                this.f22525a = null;
            }
        }

        public void b(NestAdData.AdInteractionListener adInteractionListener) {
            this.f22525a = adInteractionListener;
        }

        @Override // com.wifi.ad.core.data.NestAdData.AdInteractionListener
        public void onAdClicked(NestAdData nestAdData) {
            NestAdData.AdInteractionListener adInteractionListener = this.f22525a;
            if (adInteractionListener != null) {
                adInteractionListener.onAdClicked(nestAdData);
            }
        }

        @Override // com.wifi.ad.core.data.NestAdData.AdInteractionListener
        public void onAdExposed(NestAdData nestAdData) {
            NestAdData.AdInteractionListener adInteractionListener = this.f22525a;
            if (adInteractionListener != null) {
                adInteractionListener.onAdExposed(nestAdData);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class e implements DislikeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public DislikeListener f22526a = null;

        public void a() {
            if (b6.d()) {
                this.f22526a = null;
            }
        }

        public void b(DislikeListener dislikeListener) {
            this.f22526a = dislikeListener;
        }

        @Override // com.wifi.ad.core.listener.DislikeListener
        public void onDislikeClicked(NestAdData nestAdData, String str) {
            DislikeListener dislikeListener = this.f22526a;
            if (dislikeListener != null) {
                dislikeListener.onDislikeClicked(nestAdData, str);
            }
        }
    }

    public static void A(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            b = new JSONObject(str).optString(o());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static boolean f(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("nest_chat_ad_sp_request", 0);
            int i2 = sharedPreferences.getInt("nest_ad_request_times", 0);
            long j2 = sharedPreferences.getLong("nest_ad_request_time_stamp", 0L);
            int iH = h();
            return iH <= 0 || (((System.currentTimeMillis() - j2) > ((((long) i()) * 60) * 1000) ? 1 : ((System.currentTimeMillis() - j2) == ((((long) i()) * 60) * 1000) ? 0 : -1)) <= 0 ? i2 + 1 : 1) <= iH;
        } catch (Exception e2) {
            e2.printStackTrace();
            return true;
        }
    }

    public static void g() {
        if (!b6.d()) {
            if (b6.u) {
                LogUtil.d("ClearAd", "clearCacheAd NestPublicAdManager clearAllAd");
                d = null;
                e = null;
                f = null;
                SPCacheManager sPCacheManager = SPCacheManager.INSTANCE;
                sPCacheManager.clearCacheAd(62);
                sPCacheManager.clearCacheAd(67);
                sPCacheManager.clearCacheAd(63);
                return;
            }
            return;
        }
        if (b6.u || b6.e("NestPublicAdManager")) {
            LogUtil.d("ClearAd", "clearCacheAd NestPublicAdManager clearAllAd");
            if (d != null) {
                SPCacheManager.INSTANCE.destroyOneAd(d);
            }
            d = null;
            if (e != null) {
                SPCacheManager.INSTANCE.destroyOneAd(e);
            }
            e = null;
            if (f != null) {
                SPCacheManager.INSTANCE.destroyOneAd(f);
            }
            f = null;
            SPCacheManager sPCacheManager2 = SPCacheManager.INSTANCE;
            sPCacheManager2.clearCacheAd(62);
            sPCacheManager2.clearCacheAd(67);
            sPCacheManager2.clearCacheAd(63);
            e eVar = h;
            if (eVar != null) {
                eVar.a();
            }
            d dVar = i;
            if (dVar != null) {
                dVar.a();
            }
        }
    }

    public static int h() {
        aw3 aw3Var = g;
        if (aw3Var == null) {
            return 0;
        }
        return aw3Var.c();
    }

    public static int i() {
        aw3 aw3Var = g;
        if (aw3Var == null) {
            return 120;
        }
        return aw3Var.d();
    }

    public static List<String> j() {
        aw3 aw3Var = g;
        if (aw3Var == null) {
            return null;
        }
        return aw3Var.e();
    }

    public static List<String> k() {
        aw3 aw3Var = g;
        if (aw3Var == null) {
            return null;
        }
        return aw3Var.f();
    }

    public static void l() {
        boolean z;
        boolean z2;
        boolean z3;
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.PUBLIC_ADTYPE_CONFIG);
        boolean z4 = true;
        if (dynamicConfig == null || dynamicConfig.getExtra() == null) {
            z = false;
        } else {
            try {
                g = new aw3(new JSONObject(dynamicConfig.getExtra()));
                z = true;
            } catch (JSONException e2) {
                e2.printStackTrace();
                z = false;
            }
        }
        DynamicItem dynamicConfig2 = rl0.h().d().getDynamicConfig(DynamicConfig.Type.PUBLIC_NATIVE_ADSTRATEGY_CONFIG);
        if (dynamicConfig2 == null || dynamicConfig2.getExtra() == null || !dynamicConfig2.isEnable()) {
            z2 = false;
        } else {
            try {
                f22521a = new JSONObject(dynamicConfig2.getExtra()).optString(o());
                z2 = true;
            } catch (JSONException e3) {
                e3.printStackTrace();
                z2 = false;
            }
        }
        DynamicItem dynamicConfig3 = rl0.h().d().getDynamicConfig(DynamicConfig.Type.PUBLIC_NATIVE_ADSTRATEGY_CONFIG_2);
        if (dynamicConfig3 == null || dynamicConfig3.getExtra() == null || !dynamicConfig3.isEnable()) {
            z3 = false;
        } else {
            try {
                b = new JSONObject(dynamicConfig3.getExtra()).optString(o());
                z3 = true;
            } catch (JSONException e4) {
                e4.printStackTrace();
                z3 = false;
            }
        }
        DynamicItem dynamicConfig4 = rl0.h().d().getDynamicConfig(DynamicConfig.Type.PUBLIC_TEMPLATE_ADSTRATEGY_CONFIG);
        if (dynamicConfig4 == null || dynamicConfig4.getExtra() == null || !dynamicConfig4.isEnable()) {
            z4 = false;
        } else {
            try {
                c = new JSONObject(dynamicConfig4.getExtra()).optString(o());
            } catch (JSONException e5) {
                e5.printStackTrace();
                z4 = false;
            }
        }
        if (z && z2 && z4 && z3) {
            h6.b("LX-40038", o());
        }
    }

    public static int m() {
        aw3 aw3Var = g;
        if (aw3Var == null) {
            return 0;
        }
        return aw3Var.b();
    }

    public static int n(int i2) {
        if (i2 != 1) {
            return i2 != 2 ? 62 : 67;
        }
        return 63;
    }

    public static String o() {
        return jo6.c("LX-40038", WkAdxAdConfigMg.DSP_NAME_CSJ);
    }

    public static List<String> p() {
        aw3 aw3Var = g;
        if (aw3Var == null) {
            return null;
        }
        return aw3Var.g();
    }

    public static boolean q() {
        return System.currentTimeMillis() - p >= 1800000;
    }

    public static boolean r() {
        return System.currentTimeMillis() - q >= 1800000;
    }

    public static boolean s() {
        return !"A".equalsIgnoreCase(o());
    }

    public static boolean t() {
        return System.currentTimeMillis() - r >= 1800000;
    }

    public static void u(Activity activity) {
        if (m() == 1) {
            if (q()) {
                v(activity, 0, null);
            }
            if (r()) {
                v(activity, 2, null);
            }
            if (t()) {
                v(activity, 1, null);
            }
        }
    }

    public static void v(Activity activity, int i2, j6 j6Var) {
        WifiLog.d("requestAd start");
        if (!s()) {
            h6.e("LX-40038", o(), 1, n(i2));
            return;
        }
        if (activity == null) {
            h6.e("LX-40038", o(), 3, n(i2));
            return;
        }
        if (!l6.f(62)) {
            h6.e("LX-40038", o(), 4, n(i2));
            return;
        }
        if (i2 == 0) {
            if (j) {
                h6.e("LX-40038", o(), 5, 62);
                return;
            }
            if (d != null && !q()) {
                h6.e("LX-40038", o(), 7, 62);
                return;
            }
            if (!f(activity)) {
                h6.e("LX-40038", o(), 6, 62);
                return;
            }
            j = true;
            w(activity);
            String adRequestId = AdHelperH5Ad.INSTANCE.getAdRequestId();
            HashMap map = new HashMap();
            map.put("requestId", adRequestId);
            map.put("taiChiKey", "LX-40038");
            map.put("exp_group", o());
            AdHelperFeed adHelperFeedCreateAdFeed = WifiNestAd.INSTANCE.createAdFeed();
            h6.g(adRequestId, "LX-40038", o(), 62);
            adHelperFeedCreateAdFeed.getNativeFeedAd(activity, new AdParams.Builder().setExt(map).setScene(62).setAdUnitId("casllcqch5lb7q8042hg").setFullStrategyJson(f22521a).setAdSize(new AdSize(336.0f, -2.0f)).build(), new a(b6.d() ? new WeakReference(j6Var) : null, j6Var, adRequestId));
            return;
        }
        if (i2 == 2) {
            if (l) {
                h6.e("LX-40038", o(), 5, 67);
                return;
            }
            if (e != null && !r()) {
                h6.e("LX-40038", o(), 7, 67);
                return;
            }
            if (!f(activity)) {
                h6.e("LX-40038", o(), 6, 67);
                return;
            }
            l = true;
            w(activity);
            String adRequestId2 = AdHelperH5Ad.INSTANCE.getAdRequestId();
            HashMap map2 = new HashMap();
            map2.put("requestId", adRequestId2);
            map2.put("taiChiKey", "LX-40038");
            map2.put("exp_group", o());
            AdHelperFeed adHelperFeedCreateAdFeed2 = WifiNestAd.INSTANCE.createAdFeed();
            h6.g(adRequestId2, "LX-40038", o(), 67);
            adHelperFeedCreateAdFeed2.getNativeFeedAd(activity, new AdParams.Builder().setExt(map2).setScene(67).setAdUnitId("cbbs632ch5lb7q8042j0").setFullStrategyJson(b).setAdSize(new AdSize(336.0f, -2.0f)).build(), new b(b6.d() ? new WeakReference(j6Var) : null, j6Var, adRequestId2));
            return;
        }
        if (i2 == 1) {
            if (n) {
                h6.e("LX-40038", o(), 5, 63);
                return;
            }
            if (f != null && !t()) {
                h6.e("LX-40038", o(), 7, 63);
                return;
            }
            if (!f(activity)) {
                h6.e("LX-40038", o(), 6, 63);
                return;
            }
            n = true;
            w(activity);
            String adRequestId3 = AdHelperH5Ad.INSTANCE.getAdRequestId();
            HashMap map3 = new HashMap();
            map3.put("requestId", adRequestId3);
            map3.put("taiChiKey", "LX-40038");
            map3.put("exp_group", o());
            AdHelperFeed adHelperFeedCreateAdFeed3 = WifiNestAd.INSTANCE.createAdFeed();
            h6.g(adRequestId3, "LX-40038", o(), 63);
            AdParams adParamsBuild = new AdParams.Builder().setExt(map3).setScene(63).setAdUnitId("caslljach5lb7q8042i0").setFullStrategyJson(c).setAdSize(new AdSize(328.0f, -2.0f)).build();
            h = new e();
            i = new d();
            adHelperFeedCreateAdFeed3.getFeedAd(activity, adParamsBuild, new c(b6.d() ? new WeakReference(j6Var) : null, j6Var, adRequestId3), h, i);
        }
    }

    public static void w(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("nest_chat_ad_sp_request", 0);
            int i2 = System.currentTimeMillis() - sharedPreferences.getLong("nest_ad_request_time_stamp", 0L) <= (((long) i()) * 60) * 1000 ? 1 + sharedPreferences.getInt("nest_ad_request_times", 0) : 1;
            sharedPreferences.edit().putLong("nest_ad_request_time_stamp", System.currentTimeMillis()).apply();
            sharedPreferences.edit().putInt("nest_ad_request_times", i2).apply();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void x(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            c = new JSONObject(str).optString(o());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void y(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            g = new aw3(new JSONObject(str));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void z(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            f22521a = new JSONObject(str).optString(o());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements FeedLoadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WeakReference f22522a;
        public final /* synthetic */ j6 b;
        public final /* synthetic */ String c;

        public a(WeakReference weakReference, j6 j6Var, String str) {
            this.f22522a = weakReference;
            this.b = j6Var;
            this.c = str;
        }

        @Override // com.wifi.ad.core.listener.FeedLoadListener, com.wifi.ad.core.listener.BaseListener
        public void onAdFailed(String str, String str2) {
            zv3.j = false;
            h6.d(str, str2, 62);
        }

        @Override // com.wifi.ad.core.listener.FeedLoadListener, com.wifi.ad.core.listener.BaseListener
        public void onAdLoaded(String str, List<NestAdData> list) {
            NestAdData nestAdData;
            zv3.j = false;
            if (list == null || list.size() <= 0 || (nestAdData = list.get(0)) == null) {
                return;
            }
            zv3.p = System.currentTimeMillis();
            zv3.d = nestAdData;
            if (b6.d()) {
                WeakReference weakReference = this.f22522a;
                if (weakReference != null && weakReference.get() != null) {
                    ((j6) this.f22522a.get()).a(true);
                }
            } else {
                j6 j6Var = this.b;
                if (j6Var != null) {
                    j6Var.a(true);
                }
            }
            h6.c(this.c, "LX-40038", zv3.o(), 62, nestAdData);
        }

        @Override // com.wifi.ad.core.listener.FeedLoadListener, com.wifi.ad.core.listener.BaseListener
        public void onStart() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements FeedLoadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WeakReference f22523a;
        public final /* synthetic */ j6 b;
        public final /* synthetic */ String c;

        public b(WeakReference weakReference, j6 j6Var, String str) {
            this.f22523a = weakReference;
            this.b = j6Var;
            this.c = str;
        }

        @Override // com.wifi.ad.core.listener.FeedLoadListener, com.wifi.ad.core.listener.BaseListener
        public void onAdFailed(String str, String str2) {
            zv3.l = false;
            h6.d(str, str2, 67);
        }

        @Override // com.wifi.ad.core.listener.FeedLoadListener, com.wifi.ad.core.listener.BaseListener
        public void onAdLoaded(String str, List<NestAdData> list) {
            NestAdData nestAdData;
            zv3.l = false;
            if (list == null || list.size() <= 0 || (nestAdData = list.get(0)) == null) {
                return;
            }
            zv3.q = System.currentTimeMillis();
            zv3.e = nestAdData;
            if (b6.d()) {
                WeakReference weakReference = this.f22523a;
                if (weakReference != null && weakReference.get() != null) {
                    ((j6) this.f22523a.get()).a(true);
                }
            } else {
                j6 j6Var = this.b;
                if (j6Var != null) {
                    j6Var.a(true);
                }
            }
            h6.c(this.c, "LX-40038", zv3.o(), 67, nestAdData);
        }

        @Override // com.wifi.ad.core.listener.FeedLoadListener, com.wifi.ad.core.listener.BaseListener
        public void onStart() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements FeedLoadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WeakReference f22524a;
        public final /* synthetic */ j6 b;
        public final /* synthetic */ String c;

        public c(WeakReference weakReference, j6 j6Var, String str) {
            this.f22524a = weakReference;
            this.b = j6Var;
            this.c = str;
        }

        @Override // com.wifi.ad.core.listener.FeedLoadListener, com.wifi.ad.core.listener.BaseListener
        public void onAdFailed(String str, String str2) {
            zv3.n = false;
            h6.d(str, str2, 63);
        }

        @Override // com.wifi.ad.core.listener.FeedLoadListener, com.wifi.ad.core.listener.BaseListener
        public void onAdLoaded(String str, List<NestAdData> list) {
            NestAdData nestAdData;
            zv3.n = false;
            if (list == null || list.size() <= 0 || (nestAdData = list.get(0)) == null) {
                return;
            }
            zv3.r = System.currentTimeMillis();
            zv3.f = nestAdData;
            if (b6.d()) {
                WeakReference weakReference = this.f22524a;
                if (weakReference != null && weakReference.get() != null) {
                    ((j6) this.f22524a.get()).a(false);
                }
            } else {
                j6 j6Var = this.b;
                if (j6Var != null) {
                    j6Var.a(false);
                }
            }
            h6.c(this.c, "LX-40038", zv3.o(), 63, nestAdData);
        }

        @Override // com.wifi.ad.core.listener.FeedLoadListener, com.wifi.ad.core.listener.BaseListener
        public void onStart() {
        }
    }
}
