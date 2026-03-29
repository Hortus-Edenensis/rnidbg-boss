package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.ss.android.ttvecamera.BuildConfig;
import com.umeng.analytics.pro.f;
import com.wifi.ad.core.config.AdParams;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.wifi.ad.core.config.EventParams;
import com.wifi.ad.core.config.WifiConstConfig;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.helper.AdHelperInterstitialAd;
import com.wifi.ad.core.interactive.WkInteractiveManager;
import com.wifi.ad.core.listener.BaseListener;
import com.wifi.ad.core.listener.PopShowListener;
import com.wifi.ad.core.spstrategy.SPCacheManager;
import com.wifi.ad.core.utils.WifiLog;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.ad.GenericVipEntranceDialog;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.sync.dynamic.DynamicItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class uv3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f21298a;
    public static NestAdData b;
    public static vv3 c;
    public static long d;
    public static HashMap<String, Long> e = new HashMap<>();
    public static HashMap<String, Integer> f = new HashMap<>();
    public static final String g = "ad_pop_box_time_key" + AccountUtils.p(AppContext.getContext());
    public static final String h = "ad_pop_box_value_key" + AccountUtils.p(AppContext.getContext());
    public static boolean i = true;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements BaseListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f21299a;
        public final /* synthetic */ boolean b;

        public a(int i, boolean z) {
            this.f21299a = i;
            this.b = z;
        }

        @Override // com.wifi.ad.core.listener.BaseListener
        public void onAdFailed(String str, String str2) {
            ma3.a("global interstitial ad request onAdFailed errorCode = " + str + " :: msg = " + str2, new Object[0]);
        }

        @Override // com.wifi.ad.core.listener.BaseListener
        public void onAdLoaded(String str, List<NestAdData> list) {
            ma3.a("global interstitial ad request onAdLoaded", new Object[0]);
            if (list == null || list.size() <= 0) {
                return;
            }
            uv3.b = list.get(0);
            h6.c(list.get(0).getRequestId(), "LX-31425", uv3.r(), this.f21299a, list.get(0));
            uv3.b.setNativeAd(this.b);
            uv3.d = System.currentTimeMillis();
        }

        @Override // com.wifi.ad.core.listener.BaseListener
        public void onStart() {
            ma3.a("global interstitial ad request onStart", new Object[0]);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements BaseListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f21300a;
        public final /* synthetic */ WeakReference b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ ut2 e;
        public final /* synthetic */ Activity f;

        public b(boolean z, WeakReference weakReference, String str, String str2, ut2 ut2Var, Activity activity) {
            this.f21300a = z;
            this.b = weakReference;
            this.c = str;
            this.d = str2;
            this.e = ut2Var;
            this.f = activity;
        }

        @Override // com.wifi.ad.core.listener.BaseListener
        public void onAdFailed(String str, String str2) {
            ma3.a("global interstitial ad request onAdFailed errorCode = " + str + " :: msg = " + str2, new Object[0]);
        }

        @Override // com.wifi.ad.core.listener.BaseListener
        public void onAdLoaded(String str, List<NestAdData> list) {
            ma3.a("global interstitial ad request onAdLoaded", new Object[0]);
            if (list == null || list.size() <= 0) {
                return;
            }
            uv3.b = list.get(0);
            uv3.b.setNativeAd(this.f21300a);
            uv3.d = System.currentTimeMillis();
            if (!b6.d()) {
                uv3.F(this.f, this.c, this.d, this.e);
                return;
            }
            WeakReference weakReference = this.b;
            if (weakReference != null) {
                uv3.F((Activity) weakReference.get(), this.c, this.d, this.e);
            }
        }

        @Override // com.wifi.ad.core.listener.BaseListener
        public void onStart() {
            ma3.a("global interstitial ad request onStart", new Object[0]);
        }
    }

    public static void A(Activity activity, String str, String str2) {
        if (tt2.c(str)) {
            tt2.e(activity, str, str2);
        } else {
            B(activity, str, str2, null);
        }
    }

    public static void B(Activity activity, String str, String str2, ut2 ut2Var) {
        boolean zW = w();
        if (!l6.f(zW ? 86 : 28)) {
            ma3.a("[PopAd-PageEnter] ad config has not opened.", new Object[0]);
        } else if (b == null || v()) {
            z(activity, str, str2, ut2Var, zW);
        } else {
            F(activity, str, str2, ut2Var);
        }
    }

    public static void C(Activity activity, String str) {
        if (tt2.c(str)) {
            tt2.g(activity, str);
        } else {
            y(activity, str);
        }
    }

    public static void D() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        AppContext.getContext().getSharedPreferences("ad_pop_box_check_spname", 0).edit().putLong(g, jCurrentTimeMillis).apply();
        LogUtil.d("", "mPopAdCheckbox popAdManager saveCurTime success curTime:" + jCurrentTimeMillis);
    }

    public static void E(boolean z, int i2) {
        SharedPreferences sharedPreferences = AppContext.getContext().getSharedPreferences("ad_pop_box_check_spname", 0);
        LogUtil.d("", "mPopAdCheckbox setPopBoxValue res:" + z + " value " + (z ? 1 : 0));
        sharedPreferences.edit().putInt(h, z ? 1 : 0).apply();
        i = z;
        if (!z && i2 == 2) {
            D();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DeviceInfoUtil.UID_TAG, AccountUtils.p(AppContext.getContext()));
            jSONObject.put("deviceId", ac1.h);
            String str = WkInteractiveManager.TimingTypeOff;
            if (z) {
                str = BuildConfig.USE_CLOUD_CONFIG;
            }
            jSONObject.put("switch", str);
            jSONObject.put("reason", i2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        LogUtil.d("", "mPopAdCheckbox event pop_ad_switch jsonObject " + jSONObject);
        zn6.d("pop_ad_switch", null, jSONObject.toString());
    }

    public static void F(Activity activity, String str, String str2, ut2 ut2Var) {
        String requestId;
        String str3;
        String str4;
        String str5;
        Activity activity2;
        WeakReference weakReference;
        String str6;
        long jLongValue;
        List<String> listF;
        String str7 = str2;
        vv3 vv3Var = c;
        if (vv3Var != null && ((listF = vv3Var.f()) == null || listF.isEmpty() || !listF.contains(str7))) {
            pu3.d(14, "LX-31425", r(), 1);
            return;
        }
        String strB = pu3.b();
        NestAdData nestAdData = b;
        if (nestAdData != null) {
            i = nestAdData.getIsNativeAd() ? 86 : 28;
            requestId = b.getRequestId();
            b.setInventoryId(strB);
        } else {
            requestId = "";
        }
        if (activity == null || activity.isFinishing()) {
            pu3.d(1, "LX-31425", r(), 1);
            pu3.a(strB, 401, i, requestId);
            return;
        }
        if ("A".equalsIgnoreCase(r())) {
            pu3.d(2, "LX-31425", r(), 1);
            pu3.a(strB, 101, i, requestId);
            return;
        }
        if (!i) {
            LogUtil.d("", "mPopAdCheckbox showNestPopAd mPopBoxValue:false");
            pu3.a(strB, 302, i, requestId);
            return;
        }
        if (b == null || v()) {
            pu3.d(13, "LX-31425", r(), 1);
            pu3.a(strB, 401, i, requestId);
            return;
        }
        if (wt2.b(str2) && !l()) {
            ma3.a("", "global interstitial, showNestPopAd, smallVideo not allow.");
            pu3.a(strB, 401, i, requestId);
            return;
        }
        vv3 vv3Var2 = c;
        if (vv3Var2 == null) {
            pu3.d(10, "LX-31425", r(), 1);
            pu3.a(strB, 401, i, requestId);
            return;
        }
        if (i42.e(activity, vv3Var2, str7, "LX-31425", r())) {
            if ("wseem".equals(str7) && (fg6.j(AppContext.getContext()) || fg6.d(AppContext.getContext()))) {
                pu3.d(21, "LX-31425", r(), 1);
                pu3.a(strB, 301, i, requestId);
                return;
            }
            int iIntValue = f.containsKey("allPop") ? f.get("allPop").intValue() : 0;
            LogUtil.d("", "SEEMEPOP showNestPopAd allPopTimeSeconds " + iIntValue);
            if (iIntValue > 0) {
                if (e.containsKey("allPop")) {
                    str6 = "LX-31425";
                    jLongValue = e.get("allPop").longValue();
                } else {
                    str6 = "LX-31425";
                    jLongValue = 0;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                long j = jCurrentTimeMillis - jLongValue;
                StringBuilder sb = new StringBuilder();
                sb.append("SEEMEPOP showNestPopAd allPopLastRequestTime ");
                sb.append(jLongValue);
                sb.append(" curTime ");
                sb.append(jCurrentTimeMillis);
                str4 = " duration ";
                sb.append(str4);
                sb.append(j);
                LogUtil.d("", sb.toString());
                if (j < iIntValue * 1000) {
                    LogUtil.d("", "SEEMEPOP showNestPopAd FREQ_INTERVAL_TIME allpop not allow ");
                    pu3.e(22, str6, r(), 1, "allPop");
                    pu3.a(strB, 201, i, requestId);
                    return;
                }
                str3 = str6;
            } else {
                str3 = "LX-31425";
                str4 = " duration ";
            }
            String strS = s(str2);
            if (TextUtils.isEmpty(strS)) {
                str5 = "allPop";
            } else {
                int iIntValue2 = f.containsKey(strS) ? f.get(strS).intValue() : -1;
                LogUtil.d("", "SEEMEPOP showNestPopAd pagePopTimeSeconds " + iIntValue2 + " realkey " + strS + " pageName " + str7);
                if (iIntValue2 > 0) {
                    long jLongValue2 = e.containsKey(strS) ? e.get(strS).longValue() : 0L;
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    long j2 = jCurrentTimeMillis2 - jLongValue2;
                    StringBuilder sb2 = new StringBuilder();
                    str5 = "allPop";
                    sb2.append("SEEMEPOP showNestPopAd pagePopLastRequestTime ");
                    sb2.append(jLongValue2);
                    sb2.append(" curTime ");
                    sb2.append(jCurrentTimeMillis2);
                    sb2.append(str4);
                    sb2.append(j2);
                    LogUtil.d("", sb2.toString());
                    if (j2 < iIntValue2 * 1000) {
                        LogUtil.d("", "SEEMEPOP saveShowFrequencyInfo pagePopLastRequestTime FREQ_INTERVAL_TIME not allow");
                        pu3.e(22, str3, r(), 1, str2);
                        pu3.a(strB, 201, i, requestId);
                        return;
                    }
                    str7 = str2;
                    strB = strB;
                } else {
                    str5 = "allPop";
                }
                e.put(strS, Long.valueOf(System.currentTimeMillis()));
            }
            e.put(str5, Long.valueOf(System.currentTimeMillis()));
            ArrayList arrayList = new ArrayList();
            AdParams adParams = b.getAdParams();
            if (adParams != null && adParams.getExt() != null) {
                Map<String, String> ext = adParams.getExt();
                ext.put("tab_name", str);
                ext.put(f.v, str7);
            }
            arrayList.add(b);
            if (b6.d()) {
                activity2 = activity;
                weakReference = new WeakReference(activity2);
            } else {
                activity2 = activity;
                weakReference = null;
            }
            bw3.a(b.getRequestId(), str3, r(), i, b);
            pu3.a(strB, 0, i, requestId);
            c cVar = new c(weakReference, ut2Var, activity, str2, strB);
            if (b.getIsNativeAd()) {
                AdHelperInterstitialAd.INSTANCE.showNativeInterstitialAd(activity2, arrayList, cVar);
            } else {
                AdHelperInterstitialAd.INSTANCE.showInterstitialAd(activity2, arrayList, cVar);
            }
        }
    }

    public static void G(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            f21298a = new JSONObject(str).optString(r());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void H(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            c = new vv3(new JSONObject(str));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void h(Activity activity, String str, NestAdData nestAdData, ut2 ut2Var) {
        if (a92.a() && !activity.isFinishing()) {
            new GenericVipEntranceDialog(activity, 35).show();
        }
        if (ut2Var != null) {
            ut2Var.onAdClose(str, nestAdData);
        }
    }

    public static void i(String str, NestAdData nestAdData, ut2 ut2Var) {
        if (ut2Var != null) {
            ut2Var.onAdExpose(str, nestAdData);
        }
    }

    public static boolean j(Activity activity, String str, int i2) {
        if (activity == null) {
            pu3.c(1, "LX-31425", r());
            return false;
        }
        if (!tu3.f21071a.get()) {
            pu3.c(19, "LX-31425", r());
            return false;
        }
        if ("A".equalsIgnoreCase(r())) {
            pu3.c(2, "LX-31425", r());
            return false;
        }
        if (b != null && !v()) {
            pu3.c(8, "LX-31425", r());
            return false;
        }
        vv3 vv3Var = c;
        if (vv3Var == null) {
            pu3.c(10, "LX-31425", r());
            return false;
        }
        List<String> listE = vv3Var.e();
        if (i2 == 2 && (WkAdxAdConfigMg.DSP_NAME_BAIDU.equalsIgnoreCase(t()) || WkAdxAdConfigMg.DSP_NAME_CSJ.equalsIgnoreCase(t()))) {
            LogUtil.d("", "lx_frequency_contrl58421 popAd Switch58421 is B or C && fromType == 2 允许请求广告");
        } else if (listE == null || listE.isEmpty() || !listE.contains(str)) {
            pu3.c(12, "LX-31425", r());
            return false;
        }
        return i42.b(activity, c, str, "LX-31425", r());
    }

    public static void k() {
        if (!b6.d()) {
            if (b6.h) {
                LogUtil.d("ClearAd", "clearCacheAd NestPopAdManager clearAllAd");
                b = null;
                SPCacheManager sPCacheManager = SPCacheManager.INSTANCE;
                String str = WifiConstConfig.LX_APPID;
                sPCacheManager.clearCacheAd(28);
                return;
            }
            return;
        }
        if (b6.h || b6.f1653a) {
            LogUtil.d("ClearAd", "clearCacheAd NestPopAdManager clearAllAd");
            if (b != null) {
                SPCacheManager.INSTANCE.destroyOneAd(b);
                b = null;
            }
            SPCacheManager sPCacheManager2 = SPCacheManager.INSTANCE;
            String str2 = WifiConstConfig.LX_APPID;
            sPCacheManager2.clearCacheAd(28);
        }
    }

    public static boolean l() {
        return false;
    }

    public static void m(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("requestId", str);
            jSONObject.put("taichi", "LX-31425");
            jSONObject.put("exp_group", r());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        zn6.d("lx_client_nestad_req", null, jSONObject.toString());
    }

    public static void n() {
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.ADPOPNEST);
        if (dynamicConfig != null && dynamicConfig.getExtra() != null) {
            try {
                f21298a = new JSONObject(dynamicConfig.getExtra()).optString(r());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        DynamicItem dynamicConfig2 = rl0.h().d().getDynamicConfig(DynamicConfig.Type.ADPOPTYPE);
        if (dynamicConfig2 == null || dynamicConfig2.getExtra() == null) {
            return;
        }
        try {
            c = new vv3(new JSONObject(dynamicConfig2.getExtra()));
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    public static AdParams o(boolean z, int i2, String str) {
        String str2;
        int i3;
        HashMap map = new HashMap();
        String strValueOf = String.valueOf(System.currentTimeMillis());
        map.put("requestId", strValueOf);
        map.put("taiChiKey", "LX-31425");
        map.put("exp_group", r());
        map.put(EventParams.KEY_INVENTORYID, str);
        if (z) {
            str2 = "cihpb9r8meabjpbpvjgg";
            i3 = 86;
        } else {
            str2 = WifiConstConfig.ADUNITID_GLOBAL_POP_VIDEO;
            i3 = 28;
        }
        if (TextUtils.isEmpty(f21298a)) {
            f21298a = "{ \"totalTimeout\":\"3500\", \"mode\":\"1\", \"strategy\":[ { \"level\":1, \"ratios\":[ 5000 ],\"ecpm\":30, \"adStrategy\":[ { \"di\":\"5593000434\", \"src\":\"K1\" } ] },{ \"level\":1, \"ratios\":[ 5000 ],\"ecpm\":20, \"adStrategy\":[ { \"di\":\"5593000434\", \"src\":\"K2\" } ] } ] }";
        }
        AdParams adParamsBuild = new AdParams.Builder().setExt(map).setPopRequestTime(i2).setFullStrategyJson(f21298a).setScene(i3).setAdUnitId(str2).build();
        m(strValueOf);
        return adParamsBuild;
    }

    public static boolean p() {
        int i2 = AppContext.getContext().getSharedPreferences("ad_pop_box_check_spname", 0).getInt(h, -1);
        return i2 == -1 || i2 == 1 || i2 != 0;
    }

    public static String q() {
        return "LX-31425";
    }

    public static String r() {
        return jo6.c("LX-31425", ExifInterface.LONGITUDE_EAST);
    }

    public static String s(String str) {
        HashMap<String, Integer> map;
        if (TextUtils.isEmpty(str) || (map = f) == null) {
            return null;
        }
        if (map.containsKey(str)) {
            return str;
        }
        try {
            Iterator<Map.Entry<String, Integer>> it = f.entrySet().iterator();
            while (it.hasNext()) {
                String key = it.next().getKey();
                LogUtil.d("", "SEEMEPOP getFrequencyIntervalByMap key " + key + " pageTab " + str);
                if (!TextUtils.isEmpty(key) && key.contains(str)) {
                    return key;
                }
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String t() {
        return t66.h().e("LX-58421", "A");
    }

    public static void u() {
        i = p();
        SharedPreferences sharedPreferences = AppContext.getContext().getSharedPreferences("ad_pop_box_check_spname", 0);
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str = g;
        long j = sharedPreferences.getLong(str, jCurrentTimeMillis);
        long j2 = jCurrentTimeMillis - j;
        LogUtil.d("", "mPopAdCheckbox popAdManager duration " + j2 + " curTime " + jCurrentTimeMillis + " lastTime " + j + " allowTime 2592000000 mPopBoxValue " + i);
        if (j2 > 2592000000L) {
            LogUtil.d("", "mPopAdCheckbox popAdManager duration allow check ");
            E(true, 3);
            sharedPreferences.edit().remove(str).apply();
        }
    }

    public static boolean v() {
        return System.currentTimeMillis() - d >= 1800000;
    }

    public static boolean w() {
        int iP = v5.p("LX-31425");
        if (iP == 1) {
            return false;
        }
        if (iP == 2) {
            return true;
        }
        return "UVWXYZ".contains(r().toUpperCase());
    }

    public static void x(Activity activity, String str) {
        if ("A".equalsIgnoreCase(r()) || activity == null) {
            return;
        }
        boolean zW = w();
        d dVar = new d(zW);
        LogUtil.d("", "lx_frequency_contrl58421 popAd onlyRequestPopAd success ");
        if (zW) {
            AdHelperInterstitialAd.INSTANCE.getNativeInterstitialAd(activity, o(zW, 2, str), dVar);
        } else {
            AdHelperInterstitialAd.INSTANCE.getInterstitialAd(activity, o(zW, 2, str), dVar);
        }
    }

    public static void y(Activity activity, String str) {
        boolean zW = w();
        int i2 = zW ? 86 : 28;
        LogUtil.d("", "mPopAdCheckbox popAdManager requestAd mPopBoxValue " + i);
        if (i) {
            if (!l6.f(i2)) {
                ma3.a("[PopAd-TabEnter] ad config has not opened.", new Object[0]);
                return;
            }
            if (j(activity, str, 1)) {
                a aVar = new a(i2, zW);
                LogUtil.d("", "lx_frequency_contrl58421 popAd requestAd success tabPageName " + str);
                if (zW) {
                    AdHelperInterstitialAd.INSTANCE.getNativeInterstitialAd(activity, o(zW, 1, ""), aVar);
                } else {
                    AdHelperInterstitialAd.INSTANCE.getInterstitialAd(activity, o(zW, 1, ""), aVar);
                }
            }
        }
    }

    public static void z(Activity activity, String str, String str2, ut2 ut2Var, boolean z) {
        if (j(activity, str2, 2)) {
            b bVar = new b(z, b6.d() ? new WeakReference(activity) : null, str, str2, ut2Var, activity);
            LogUtil.d("", "lx_frequency_contrl58421 popAd requestAndShowPopAd success pageName " + str2);
            if (z) {
                AdHelperInterstitialAd.INSTANCE.getNativeInterstitialAd(activity, o(z, 2, ""), bVar);
            } else {
                AdHelperInterstitialAd.INSTANCE.getInterstitialAd(activity, o(z, 2, ""), bVar);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements BaseListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f21302a;

        public d(boolean z) {
            this.f21302a = z;
        }

        @Override // com.wifi.ad.core.listener.BaseListener
        public void onAdLoaded(String str, List<NestAdData> list) {
            if (list == null || list.size() <= 0) {
                return;
            }
            uv3.b = list.get(0);
            uv3.b.setNativeAd(this.f21302a);
            uv3.d = System.currentTimeMillis();
        }

        @Override // com.wifi.ad.core.listener.BaseListener
        public void onStart() {
        }

        @Override // com.wifi.ad.core.listener.BaseListener
        public void onAdFailed(String str, String str2) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements PopShowListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WeakReference f21301a;
        public final /* synthetic */ ut2 b;
        public final /* synthetic */ Activity c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;

        public c(WeakReference weakReference, ut2 ut2Var, Activity activity, String str, String str2) {
            this.f21301a = weakReference;
            this.b = ut2Var;
            this.c = activity;
            this.d = str;
            this.e = str2;
        }

        @Override // com.wifi.ad.core.listener.PopShowListener
        public void onAdClicked(String str, NestAdData nestAdData) {
            h6.a(nestAdData.getRequestId(), "LX-31425", uv3.r(), nestAdData.getAdScene(), nestAdData);
        }

        @Override // com.wifi.ad.core.listener.PopShowListener
        public void onAdClose(String str, NestAdData nestAdData) {
            if (!b6.d()) {
                uv3.h(this.c, str, nestAdData, this.b);
                return;
            }
            WeakReference weakReference = this.f21301a;
            if (weakReference != null) {
                uv3.h((Activity) weakReference.get(), str, nestAdData, this.b);
            }
        }

        @Override // com.wifi.ad.core.listener.PopShowListener
        public void onAdExpose(String str, NestAdData nestAdData) {
            uv3.b = null;
            WifiLog.d("NestPopAdManager onAdExpose popCurAd = null");
            uv3.i(str, nestAdData, this.b);
            if (b6.d()) {
                WeakReference weakReference = this.f21301a;
                if (weakReference != null) {
                    i42.d((Context) weakReference.get(), uv3.c, this.d);
                    if ("A".equalsIgnoreCase(uv3.t())) {
                        LogUtil.d("", "lx_frequency_contrl58421 popAd onAdExpose Switch58421 is A 允许请求 ");
                        uv3.x((Activity) this.f21301a.get(), this.e);
                    } else {
                        LogUtil.d("", "lx_frequency_contrl58421 popAd onAdExpose Switch58421 is A 不允许请求 ");
                    }
                }
            } else {
                i42.d(this.c, uv3.c, this.d);
                if ("A".equalsIgnoreCase(uv3.t())) {
                    LogUtil.d("", "lx_frequency_contrl58421 popAd onAdExpose Switch58421 is A 允许请求 ");
                    uv3.x(this.c, this.e);
                } else {
                    LogUtil.d("", "lx_frequency_contrl58421 popAd onAdExpose Switch58421 is A 不允许请求 ");
                }
            }
            h6.h(nestAdData.getRequestId(), "LX-31425", uv3.r(), nestAdData.getAdScene(), nestAdData);
        }

        @Override // com.wifi.ad.core.listener.PopShowListener
        public void onAdSkipClick(String str, NestAdData nestAdData) {
        }

        @Override // com.wifi.ad.core.listener.PopShowListener
        public void onDownloadComplete(String str, NestAdData nestAdData) {
        }

        @Override // com.wifi.ad.core.listener.PopShowListener
        public void onDownloadFailed(String str, NestAdData nestAdData) {
        }

        @Override // com.wifi.ad.core.listener.PopShowListener
        public void onDownloadInstalled(String str, NestAdData nestAdData) {
        }

        @Override // com.wifi.ad.core.listener.PopShowListener
        public void onDownloadStart(String str, NestAdData nestAdData) {
        }

        @Override // com.wifi.ad.core.listener.PopShowListener
        public void onVideoComplete(String str, NestAdData nestAdData) {
        }

        @Override // com.wifi.ad.core.listener.PopShowListener
        public void onVideoError(String str, NestAdData nestAdData) {
        }

        @Override // com.wifi.ad.core.listener.PopShowListener
        public void onVideoPause(String str, NestAdData nestAdData) {
        }

        @Override // com.wifi.ad.core.listener.PopShowListener
        public void onVideoStart(String str, NestAdData nestAdData) {
        }
    }
}
