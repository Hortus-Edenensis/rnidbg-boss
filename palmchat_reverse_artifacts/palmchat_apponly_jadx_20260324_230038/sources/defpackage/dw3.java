package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.config.AdParams;
import com.wifi.ad.core.config.EventParams;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.listener.SplashLoadListener;
import com.wifi.ad.core.listener.SplashShowListener;
import com.wifi.ad.core.spstrategy.SPCacheManager;
import com.wifi.ad.core.utils.WifiLog;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.modulemanager.lifecircle.AppLifeCircleManager;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.sync.dynamic.DynamicItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class dw3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f17169a;
    public static String b;
    public static ew3 c;
    public static Handler d = new Handler(Looper.getMainLooper());
    public static boolean e = false;
    public static NestAdData f = null;
    public static NestAdData g = null;

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f17171a;
        public final /* synthetic */ Activity b;

        public b(AtomicBoolean atomicBoolean, Activity activity) {
            this.f17171a = atomicBoolean;
            this.b = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f17171a.get()) {
                return;
            }
            this.f17171a.set(true);
            WifiLog.d("NestSplashAd 超时还未获取广告，直接关闭开屏页面");
            LogUtil.d("", "SplashAdIn start postDelayed timeOutDone");
            dw3.j(this.b);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements SplashShowListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WeakReference f17172a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public c(WeakReference weakReference, String str, String str2) {
            this.f17172a = weakReference;
            this.b = str;
            this.c = str2;
        }

        @Override // com.wifi.ad.core.listener.SplashShowListener
        public void onAdClicked(String str, NestAdData nestAdData) {
            WifiLog.d("NestSplashAd onAdClicked");
            Activity activity = (Activity) this.f17172a.get();
            if (activity == null) {
                return;
            }
            dw3.E(activity);
            dw3.j(activity);
            h6.a(nestAdData.getRequestId(), "LX-31249", dw3.y(), 27, nestAdData);
        }

        @Override // com.wifi.ad.core.listener.SplashShowListener
        public void onAdExpose(String str, NestAdData nestAdData) {
            WifiLog.d("NestSplashAd onAdExpose");
            Activity activity = (Activity) this.f17172a.get();
            if (activity == null) {
                LogUtil.d("", "SplashAdIn start show onAdExpose curActivity == null not allow");
                return;
            }
            pu3.f(this.b, this.c, 1, -1, 1, -1, 3000);
            dw3.e = true;
            dw3.G(activity);
            dw3.f = nestAdData;
            LogUtil.d("", "SplashAdIn start show onAdExpose success");
            h6.h(nestAdData.getRequestId(), "LX-31249", dw3.y(), 27, nestAdData);
            dw3.g = null;
            WifiLog.d("NestSplashAd onAdExpose curAdData = null");
        }

        @Override // com.wifi.ad.core.listener.SplashShowListener
        public void onAdFailedAll(NestAdData nestAdData) {
            WifiLog.d("NestSplashAd onAdFailedAll");
            LogUtil.d("", "SplashAdIn start show onAdFailedAll");
            pu3.f(this.b, this.c, 1, -1, 1, 210, 0);
            Activity activity = (Activity) this.f17172a.get();
            if (activity == null) {
                return;
            }
            dw3.j(activity);
        }

        @Override // com.wifi.ad.core.listener.SplashShowListener
        public void onAdSkip(String str, NestAdData nestAdData) {
            WifiLog.d("NestSplashAd onAdSkip");
            Activity activity = (Activity) this.f17172a.get();
            if (activity == null) {
                return;
            }
            dw3.j(activity);
            uu3.c(dw3.g, "LX-31249", dw3.y());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f17173a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Activity c;

        public d(String str, String str2, Activity activity) {
            this.f17173a = str;
            this.b = str2;
            this.c = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (dw3.e) {
                return;
            }
            WifiLog.d("NestSplashAd 超时还未成功展示广告，直接关闭开屏页面");
            LogUtil.d("", "SplashAdIn start show delaySkipDoneShowFail");
            pu3.f(this.f17173a, this.b, 1, -1, 1, 210, 0);
            dw3.j(this.c);
        }
    }

    public static void A() {
        z();
        p();
    }

    public static boolean B(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getSharedPreferences("nest_splash_ad_sp_request", 0)) == null) {
            return true;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = sharedPreferences.getLong("nest_splash_ad_click_time", 0L);
        int iU = u();
        return iU <= 0 || jCurrentTimeMillis - j > ((long) iU) * 1000;
    }

    public static boolean C(String str, String str2) {
        List listAsList;
        try {
            String[] strArrSplit = str.split(",");
            if (strArrSplit == null || (listAsList = Arrays.asList(strArrSplit)) == null) {
                return false;
            }
            for (int i = 0; i < listAsList.size(); i++) {
                String str3 = (String) listAsList.get(i);
                if (!TextUtils.isEmpty(str3) && str2.equalsIgnoreCase(str3)) {
                    return true;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return false;
    }

    public static void D(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("requestId", str);
            jSONObject.put("taichi", "LX-31249");
            jSONObject.put("exp_group", y());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        zn6.d("lx_client_nestad_req", null, jSONObject.toString());
    }

    public static void E(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getSharedPreferences("nest_splash_ad_sp_request", 0)) == null) {
            return;
        }
        sharedPreferences.edit().putLong("nest_splash_ad_click_time", System.currentTimeMillis()).apply();
    }

    public static boolean F(Activity activity, ViewGroup viewGroup, List<NestAdData> list, String str, String str2) {
        if (activity == null || activity.isFinishing()) {
            WifiLog.d("NestSplashAd activity is error");
            pu3.f(str, str2, 1, -1, 1, 100, 0);
            LogUtil.d("", "SplashAdIn start show activity == null not allow");
            return false;
        }
        if (list == null || list.size() <= 0) {
            WifiLog.d("NestSplashAd list is null");
            LogUtil.d("", "SplashAdIn start show list == null not allow");
            pu3.f(str, str2, 1, -1, 1, 211, 0);
            return false;
        }
        g = list.get(0);
        e = false;
        WeakReference weakReference = new WeakReference(activity);
        bw3.a(g.getRequestId(), "LX-31249", y(), 27, g);
        WifiNestAd.INSTANCE.createSplashAd().showSplashAd(activity, g, viewGroup, new c(weakReference, str, str2));
        n(activity, str, str2);
        uu3.j(g, "LX-31249", y());
        return true;
    }

    public static void G(Context context) {
        if (context == null) {
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("nest_splash_ad_sp_request", 0);
        ew3 ew3Var = c;
        if (ew3Var == null || sharedPreferences == null) {
            return;
        }
        int iE = ew3Var.e();
        int i = sharedPreferences.getInt("nest_splash_ad_showed_times", 0);
        int iCurrentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int i2 = iCurrentTimeMillis - sharedPreferences.getInt("nest_splash_ad_last_show_time", iCurrentTimeMillis) <= iE ? i + 1 : 1;
        if (i2 == 1) {
            sharedPreferences.edit().putInt("nest_splash_ad_last_show_time", iCurrentTimeMillis).apply();
        }
        sharedPreferences.edit().putInt("nest_splash_ad_showed_times", i2).apply();
    }

    public static boolean H(int i, Context context) {
        ew3 ew3Var;
        if (i != 1) {
            return i == 2 && (ew3Var = c) != null && ew3Var.i() == 1;
        }
        ew3 ew3Var2 = c;
        return ew3Var2 != null && ew3Var2.g() == 1;
    }

    public static boolean I(Context context) {
        if (context == null) {
            return true;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("nest_splash_ad_sp_request", 0);
        ew3 ew3Var = c;
        if (ew3Var == null || sharedPreferences == null) {
            return true;
        }
        int iE = ew3Var.e();
        int iC = c.c();
        if (iE <= 0 || iC <= 0) {
            return true;
        }
        int iCurrentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        return iCurrentTimeMillis - sharedPreferences.getInt("nest_splash_ad_last_show_time", iCurrentTimeMillis) > iE || sharedPreferences.getInt("nest_splash_ad_showed_times", 0) < iC;
    }

    public static void J(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strY = y();
            if (jSONObject.has(strY)) {
                f17169a = jSONObject.optString(strY);
            }
            WifiLog.d("NestSplashAd updateAdJsonValue strategyJson " + f17169a);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void K(String str) {
        b = str;
        WifiLog.d("NestSplashAd updateConfig configJson " + b);
        L();
    }

    public static void L() {
        JSONArray jSONArrayOptJSONArray;
        if (TextUtils.isEmpty(b)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(b);
            WifiLog.d("NestSplashAd updateConfigData object " + jSONObject.toString());
            if (jSONObject.has("taichikey") && (jSONArrayOptJSONArray = jSONObject.optJSONArray("taichikey")) != null && jSONArrayOptJSONArray.length() > 0) {
                String str = (String) jSONArrayOptJSONArray.get(0);
                String strS = s(str);
                String str2 = str + "_" + strS;
                if (jSONObject.has(str2)) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(str2);
                    String strOptString = jSONObject2.has("no_request_brand") ? jSONObject2.optString("no_request_brand") : "";
                    int iOptInt = jSONObject2.has("open_splash_ad") ? jSONObject2.optInt("open_splash_ad") : 0;
                    int iOptInt2 = jSONObject2.has("switch_splash_ad") ? jSONObject2.optInt("switch_splash_ad") : 0;
                    int iOptInt3 = jSONObject2.has("request_timeout") ? jSONObject2.optInt("request_timeout") : 0;
                    int iOptInt4 = jSONObject2.has("frequency_time_seconds") ? jSONObject2.optInt("frequency_time_seconds") : 0;
                    int iOptInt5 = jSONObject2.has("frequency_pv") ? jSONObject2.optInt("frequency_pv") : 0;
                    int iOptInt6 = jSONObject2.has("interval_splash_ad_seconds") ? jSONObject2.optInt("interval_splash_ad_seconds") : 0;
                    int iOptInt7 = jSONObject2.has("show_timeout") ? jSONObject2.optInt("show_timeout") : 0;
                    int iOptInt8 = jSONObject2.has("switch_frequency_time") ? jSONObject2.optInt("switch_frequency_time") : 0;
                    ew3 ew3Var = new ew3();
                    c = ew3Var;
                    ew3Var.s(str);
                    c.t(strS);
                    c.m(strOptString);
                    c.p(iOptInt);
                    c.r(iOptInt2);
                    c.j(iOptInt3);
                    c.n(iOptInt4);
                    c.l(iOptInt5);
                    c.o(iOptInt6);
                    c.k(iOptInt7);
                    c.q(iOptInt8);
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void j(Activity activity) {
        if (activity != null) {
            activity.finish();
        }
    }

    public static int k(int i, Activity activity) {
        ew3 ew3Var;
        WifiLog.d("NestSplashAd, 判断开屏广告是否允许展示, splashType = " + i);
        if (activity == null) {
            WifiLog.d("NestSplashAd activity == null");
            pu3.c(1, "LX-31249", y());
            return 100;
        }
        if (!tu3.f21071a.get()) {
            pu3.c(19, "LX-31249", y());
            return 300;
        }
        if (!l6.f(27)) {
            WifiLog.d("NestSplashAd isAdConfigOpen not allow");
            return 103;
        }
        if ("A".equals(y())) {
            WifiLog.d("NestSplashAd LX-31249 not allow");
            pu3.c(2, "LX-31249", y());
            return 101;
        }
        Context applicationContext = activity.getApplicationContext();
        if (!o(applicationContext)) {
            WifiLog.d("NestSplashAd deviceTypeAllow not allow ");
            pu3.c(3, "LX-31249", y());
            return 105;
        }
        if (!I(applicationContext)) {
            WifiLog.d("NestSplashAd timeRequestAllow not allow ");
            pu3.c(4, "LX-31249", y());
            return 201;
        }
        if (!B(applicationContext)) {
            WifiLog.d("NestSplashAd isAllowAgainShowAd not allow ");
            pu3.c(5, "LX-31249", y());
            return 204;
        }
        if (!H(i, applicationContext)) {
            WifiLog.d("NestSplashAd splashTypeAllow not allow splashType " + i);
            pu3.c(6, "LX-31249", y());
            return 205;
        }
        if (i != 2 || (ew3Var = c) == null || ew3Var.h() <= 0) {
            return -1;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long backgroundTime = AppLifeCircleManager.getInstance().getBackgroundTime();
        WifiLog.d("NestSplashAd FREQ_SWITHC_TIME curTime " + jCurrentTimeMillis + " lastTime " + backgroundTime + " switchFrequencyTime " + c.h());
        if (jCurrentTimeMillis - backgroundTime >= r8 * 1000) {
            return -1;
        }
        WifiLog.d("NestSplashAd FREQ_SWITHC_TIME not allow splashType " + i);
        pu3.c(20, "LX-31249", y());
        return 202;
    }

    public static void l(Context context) {
        Handler handler = d;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        if (!b6.d()) {
            if (b6.p) {
                LogUtil.d("ClearAd", "clearCacheAd NestSplashAdManager clear");
                SPCacheManager.INSTANCE.clearCacheAd(27);
            }
            if (f != null) {
                f = null;
                return;
            }
            return;
        }
        if (b6.p || b6.e("NestSplashAdManager")) {
            LogUtil.d("ClearAd", "clearCacheAd NestSplashAdManager clear");
            SPCacheManager.INSTANCE.clearCacheAd(27);
        }
        if (f != null) {
            SPCacheManager.INSTANCE.destroyOneAd(f);
            f = null;
        }
    }

    public static void m(Activity activity, AtomicBoolean atomicBoolean) {
        if (d == null) {
            return;
        }
        d.postDelayed(new b(atomicBoolean, activity), v());
    }

    public static void n(Activity activity, String str, String str2) {
        if (d == null) {
            return;
        }
        d.postDelayed(new d(str, str2, activity), w());
    }

    public static boolean o(Context context) {
        ew3 ew3Var = c;
        if (ew3Var == null) {
            return true;
        }
        String strD = ew3Var.d();
        if (TextUtils.isEmpty(strD)) {
            return true;
        }
        String str = Build.MANUFACTURER;
        WifiLog.d("NestSplashAd deviceTypeAllow curDeviceModel:" + str + ", configModel:" + strD);
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        return strD.contains(",") ? !C(strD, str) : !str.equalsIgnoreCase(strD);
    }

    public static void p() {
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.NEST_SPLASH_JSON_CONFIG);
        if (dynamicConfig == null || !dynamicConfig.isEnable() || dynamicConfig.getExtra() == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(dynamicConfig.getExtra());
            String strY = y();
            if (jSONObject.has(strY)) {
                f17169a = jSONObject.optString(strY);
            }
            WifiLog.d("NestSplashAd getAdJsonValue strategyJson " + f17169a);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static AdParams q(HashMap<String, String> map) {
        View viewInflate = View.inflate(AppContext.getContext(), R.layout.splash_bottpm_logo_layout, null);
        LogUtil.d("", "splash getAdParams splashLogoLayout " + viewInflate);
        if (f17169a == null) {
            f17169a = "";
        }
        return new AdParams.Builder().setExt(map).setFullStrategyJson(f17169a).setSplashBottomArea(viewInflate).setAdUnitId("27").build();
    }

    public static void r(int i, Activity activity, ViewGroup viewGroup, String str, String str2) {
        if (activity == null || viewGroup == null) {
            return;
        }
        WifiLog.d("NestSplashAd getAndShowSplashAd");
        if ("A".equals(y())) {
            WifiLog.d("NestSplashAd showSplashAd LX-31249 not allow");
            j(activity);
            pu3.f(str, str2, 0, 100, 0, 0, 0);
            LogUtil.d("", "SplashAdIn start triggerAd getTaichiValue not allow ");
            return;
        }
        String strValueOf = String.valueOf(ir5.b());
        AdParams adParamsQ = q(t(strValueOf, str));
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        m(activity, atomicBoolean);
        D(strValueOf);
        x(activity, viewGroup, adParamsQ, atomicBoolean, str, str2);
    }

    public static String s(String str) {
        return jo6.c(str, "A");
    }

    public static HashMap<String, String> t(String str, String str2) {
        HashMap<String, String> map = new HashMap<>();
        map.put("requestId", str);
        map.put("taiChiKey", "LX-31249");
        map.put(EventParams.KEY_INVENTORYID, str2);
        map.put("exp_group", y());
        return map;
    }

    public static int u() {
        ew3 ew3Var = c;
        if (ew3Var == null) {
            return 0;
        }
        return ew3Var.f();
    }

    public static int v() {
        ew3 ew3Var = c;
        if (ew3Var == null) {
            return 0;
        }
        int iA = ew3Var.a();
        if (iA <= 0) {
            return 3500;
        }
        return iA;
    }

    public static int w() {
        ew3 ew3Var = c;
        if (ew3Var == null) {
            return 0;
        }
        int iB = ew3Var.b();
        if (iB <= 0) {
            return 5000;
        }
        return iB;
    }

    public static void x(Activity activity, ViewGroup viewGroup, AdParams adParams, AtomicBoolean atomicBoolean, String str, String str2) {
        WeakReference weakReference = new WeakReference(activity);
        WeakReference weakReference2 = new WeakReference(viewGroup);
        pu3.f(str, str2, 1, -1, 0, 0, 2000);
        LogUtil.d("", "SplashAdIn start requestSplashAd ");
        WifiNestAd.INSTANCE.createSplashAd().getSplashAd(activity, adParams, new a(str, str2, weakReference, weakReference2, atomicBoolean));
    }

    public static String y() {
        return jo6.c("LX-31249", WkAdxAdConfigMg.DSP_NAME_CSJ);
    }

    public static void z() {
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.AD_NEST_SPLASH_CONFIG);
        if (dynamicConfig == null || !dynamicConfig.isEnable() || TextUtils.isEmpty(dynamicConfig.getExtra())) {
            WifiLog.d("NestSplashAd initAdConfig, item is null ");
        } else {
            b = dynamicConfig.getExtra();
            L();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements SplashLoadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f17170a;
        public final /* synthetic */ String b;
        public final /* synthetic */ WeakReference c;
        public final /* synthetic */ WeakReference d;
        public final /* synthetic */ AtomicBoolean e;

        public a(String str, String str2, WeakReference weakReference, WeakReference weakReference2, AtomicBoolean atomicBoolean) {
            this.f17170a = str;
            this.b = str2;
            this.c = weakReference;
            this.d = weakReference2;
            this.e = atomicBoolean;
        }

        @Override // com.wifi.ad.core.listener.SplashLoadListener, com.wifi.ad.core.listener.BaseListener
        public void onAdFailed(String str, String str2) {
            WifiLog.d("NestSplashAd onAdFailed s " + str + " s1 " + str2);
            LogUtil.d("", "SplashAdIn start onAdFailed ");
            pu3.f(this.f17170a, this.b, 1, 111, 0, 0, 0);
            Activity activity = (Activity) this.c.get();
            if (activity == null) {
                return;
            }
            dw3.j(activity);
        }

        @Override // com.wifi.ad.core.listener.SplashLoadListener, com.wifi.ad.core.listener.BaseListener
        public void onAdLoaded(String str, List<NestAdData> list) {
            WifiLog.d("NestSplashAd onAdLoaded s " + str);
            LogUtil.d("", "SplashAdIn start onAdLoaded ");
            pu3.f(this.f17170a, this.b, 1, 110, 0, 0, 0);
            Activity activity = (Activity) this.c.get();
            ViewGroup viewGroup = (ViewGroup) this.d.get();
            if (activity == null || viewGroup == null) {
                return;
            }
            h6.c(list.get(0).getRequestId(), "LX-31249", dw3.y(), 27, list.get(0));
            if (this.e.get()) {
                return;
            }
            this.e.set(true);
            WifiLog.d("NestSplashAd 未超时，可以展示广告");
            if (dw3.F(activity, viewGroup, list, this.f17170a, this.b)) {
                return;
            }
            dw3.j(activity);
        }

        @Override // com.wifi.ad.core.listener.SplashLoadListener, com.wifi.ad.core.listener.BaseListener
        public void onStart() {
        }
    }
}
