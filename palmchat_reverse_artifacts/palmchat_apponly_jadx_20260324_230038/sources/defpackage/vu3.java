package defpackage;

import android.app.Activity;
import android.text.TextUtils;
import com.umeng.analytics.pro.f;
import com.wifi.ad.core.SDKAlias;
import com.wifi.ad.core.config.AdParams;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.helper.AdHelperInterstitialAd;
import com.wifi.ad.core.listener.BaseListener;
import com.wifi.ad.core.listener.PopShowListener;
import com.wifi.ad.core.spstrategy.SPCacheManager;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.sync.dynamic.DynamicItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class vu3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f21532a;
    public static NestAdData b;
    public static vv3 c;
    public static long d;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements BaseListener {
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
            NestAdData nestAdData = list.get(0);
            if (vu3.l(nestAdData)) {
                return;
            }
            vu3.b = nestAdData;
            vu3.d = System.currentTimeMillis();
        }

        @Override // com.wifi.ad.core.listener.BaseListener
        public void onStart() {
            ma3.a("global interstitial ad request onStart", new Object[0]);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d {
        void a();

        void onAdClosed();
    }

    public static boolean f(Activity activity, String str) {
        if (activity == null) {
            pu3.c(1, "LX-33206", j());
            return false;
        }
        if ("A".equalsIgnoreCase(j())) {
            pu3.c(2, "LX-33206", j());
            return false;
        }
        if (b != null && !k()) {
            pu3.c(8, "LX-33206", j());
            return false;
        }
        vv3 vv3Var = c;
        if (vv3Var == null) {
            pu3.c(10, "LX-33206", j());
            return false;
        }
        List<String> listB = vv3Var.b();
        if (listB != null && !listB.isEmpty() && listB.contains(str)) {
            return i42.b(activity, c, str, "LX-33206", j());
        }
        pu3.c(12, "LX-33206", j());
        return false;
    }

    public static void g(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("requestId", str);
            jSONObject.put("taichi", "LX-33206");
            jSONObject.put("exp_group", j());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        zn6.d("lx_client_nestad_req", null, jSONObject.toString());
    }

    public static void h() {
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.ADEXITPOPNEST);
        if (dynamicConfig != null && dynamicConfig.getExtra() != null) {
            try {
                f21532a = new JSONObject(dynamicConfig.getExtra()).optString(j());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        DynamicItem dynamicConfig2 = rl0.h().d().getDynamicConfig(DynamicConfig.Type.ADPOPTYPE);
        if (dynamicConfig2 == null || dynamicConfig2.getExtra() == null) {
            return;
        }
        try {
            c = new vv3(new JSONObject(dynamicConfig2.getExtra()));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static AdParams i() {
        HashMap map = new HashMap();
        String strValueOf = String.valueOf(System.currentTimeMillis());
        map.put("requestId", strValueOf);
        map.put("taiChiKey", "LX-33206");
        map.put("exp_group", j());
        AdParams adParamsBuild = new AdParams.Builder().setExt(map).setFullStrategyJson(f21532a).build();
        g(strValueOf);
        return adParamsBuild;
    }

    public static String j() {
        return jo6.c("LX-33206", "A");
    }

    public static boolean k() {
        return System.currentTimeMillis() - d >= 1800000;
    }

    public static boolean l(NestAdData nestAdData) {
        if (nestAdData == null) {
            return true;
        }
        String adType = nestAdData.getAdType();
        ma3.a("cacheCurrentAd adtype:" + adType + ", interactionType:" + nestAdData.getInteractionType(), new Object[0]);
        return SDKAlias.WIFI.getType().equals(adType);
    }

    public static void m(Activity activity) {
        if ("A".equalsIgnoreCase(j()) || activity == null) {
            return;
        }
        AdHelperInterstitialAd.INSTANCE.getNativeInterstitialAd(activity, i(), new c());
    }

    public static void n(Activity activity, String str, String str2, d dVar) {
        if (!l6.f(32)) {
            ma3.a("[ExitPopAd-RequestOrShow] ad config has not opened.", new Object[0]);
            if (dVar != null) {
                dVar.a();
                return;
            }
            return;
        }
        if (b != null && !k()) {
            p(activity, str, str2, dVar);
            return;
        }
        o(activity, str2);
        if (dVar != null) {
            dVar.a();
        }
    }

    public static void o(Activity activity, String str) {
        if (!l6.f(32)) {
            ma3.a("[ExitPopAd-Request] ad config has not opened.", new Object[0]);
        } else if (f(activity, str)) {
            AdHelperInterstitialAd.INSTANCE.getNativeInterstitialAd(activity, i(), new a());
        }
    }

    public static void p(Activity activity, String str, String str2, d dVar) {
        if (activity == null || activity.isFinishing()) {
            pu3.d(1, "LX-33206", j(), 1);
            if (dVar != null) {
                dVar.a();
                return;
            }
            return;
        }
        if ("A".equalsIgnoreCase(j())) {
            pu3.d(2, "LX-33206", j(), 1);
            if (dVar != null) {
                dVar.a();
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(f21532a)) {
            pu3.d(7, "LX-33206", j(), 1);
            if (dVar != null) {
                dVar.a();
                return;
            }
            return;
        }
        if (b == null || k()) {
            pu3.d(13, "LX-33206", j(), 1);
            if (dVar != null) {
                dVar.a();
                return;
            }
            return;
        }
        vv3 vv3Var = c;
        if (vv3Var == null) {
            pu3.d(10, "LX-33206", j(), 1);
            if (dVar != null) {
                dVar.a();
                return;
            }
            return;
        }
        List<String> listC = vv3Var.c();
        if (listC == null || listC.isEmpty() || !listC.contains(str2)) {
            pu3.d(14, "LX-33206", j(), 1);
            if (dVar != null) {
                dVar.a();
                return;
            }
            return;
        }
        if (!i42.e(activity, c, str2, "LX-33206", j())) {
            if (dVar != null) {
                dVar.a();
                return;
            }
            return;
        }
        NestAdData nestAdDataChangeCheckMaxAd = b;
        if (nestAdDataChangeCheckMaxAd.getAdSPStrategy() && (nestAdDataChangeCheckMaxAd = SPCacheManager.INSTANCE.changeCheckMaxAd(b)) != b && l(nestAdDataChangeCheckMaxAd)) {
            ma3.a("NestExitPopAdManager: the ad after changing has not been supported, use old.", new Object[0]);
            nestAdDataChangeCheckMaxAd = b;
        }
        AdParams adParams = nestAdDataChangeCheckMaxAd.getAdParams();
        if (adParams != null && adParams.getExt() != null) {
            Map<String, String> ext = adParams.getExt();
            ext.put("tab_name", str);
            ext.put(f.v, str2);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(nestAdDataChangeCheckMaxAd);
        AdHelperInterstitialAd.INSTANCE.showNativeInterstitialAd(activity, arrayList, new b(dVar, activity, str2));
    }

    public static void q(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            f21532a = new JSONObject(str).optString(j());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void r(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            c = new vv3(new JSONObject(str));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements BaseListener {
        @Override // com.wifi.ad.core.listener.BaseListener
        public void onAdLoaded(String str, List<NestAdData> list) {
            if (list == null || list.size() <= 0) {
                return;
            }
            NestAdData nestAdData = list.get(0);
            if (vu3.l(nestAdData)) {
                return;
            }
            vu3.b = nestAdData;
            vu3.d = System.currentTimeMillis();
        }

        @Override // com.wifi.ad.core.listener.BaseListener
        public void onStart() {
        }

        @Override // com.wifi.ad.core.listener.BaseListener
        public void onAdFailed(String str, String str2) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements PopShowListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f21533a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ String c;

        public b(d dVar, Activity activity, String str) {
            this.f21533a = dVar;
            this.b = activity;
            this.c = str;
        }

        @Override // com.wifi.ad.core.listener.PopShowListener
        public void onAdClose(String str, NestAdData nestAdData) {
            d dVar = this.f21533a;
            if (dVar != null) {
                dVar.onAdClosed();
            }
        }

        @Override // com.wifi.ad.core.listener.PopShowListener
        public void onAdExpose(String str, NestAdData nestAdData) {
            i42.d(this.b, vu3.c, this.c);
            vu3.m(this.b);
        }

        @Override // com.wifi.ad.core.listener.PopShowListener
        public void onAdClicked(String str, NestAdData nestAdData) {
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
