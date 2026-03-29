package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.config.AdParams;
import com.wifi.ad.core.config.EventParams;
import com.wifi.ad.core.config.NestSdkVersion;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.helper.AdHelperFeed;
import com.wifi.ad.core.listener.FeedLoadListener;
import com.wifi.adsdk.utils.LxAdConst;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class vq3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f21509a = "MomentsNestSdkManager";
    public static HashMap<ou3, Long> b = new HashMap<>();
    public static int c = 2;
    public static AtomicBoolean d = new AtomicBoolean(false);
    public static Set<Integer> e = Collections.synchronizedSet(new HashSet());
    public static int f = 60;
    public static Boolean g = null;
    public static boolean h = false;
    public static int i = 1;
    public static String j = "";
    public static String k = "";

    public static void e(Activity activity) {
        HashMap<ou3, Long> map = b;
        if (map != null && map.size() != 0) {
            LogUtil.d(f21509a, "cleanExpiredMomentsAds before size = " + b.size());
            Iterator<Map.Entry<ou3, Long>> it = b.entrySet().iterator();
            while (it.hasNext()) {
                if (l(it.next().getKey())) {
                    it.remove();
                }
            }
            LogUtil.d(f21509a, "cleanExpiredMomentsAds after size = " + b.size());
        }
        o(activity);
    }

    public static void f() {
        HashMap<ou3, Long> map = b;
        if (map == null || map.size() == 0) {
            return;
        }
        b.clear();
    }

    public static int g() {
        return f;
    }

    public static ou3 h(Long l) {
        ou3 next;
        HashMap<ou3, Long> map = b;
        if (map == null || map.size() == 0) {
            return null;
        }
        Iterator<ou3> it = b.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            Long l2 = b.get(next);
            if (l != null && l.longValue() == l2.longValue()) {
                break;
            }
        }
        if (next == null) {
            for (ou3 ou3Var : b.keySet()) {
                if (b.get(ou3Var).longValue() == 0) {
                    ou3Var.c = ir5.b();
                    b.put(ou3Var, l);
                    NestAdData nestAdData = ou3Var.f19878a;
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("requestId", j(nestAdData));
                        jSONObject.put(EventParams.KEY_PARAM_NETTYPE, hx3.h());
                        jSONObject.put(LxAdConst.EventKeyParams.KEY_PARAM_ADMODE, nestAdData.getAdMode());
                        jSONObject.put(EventParams.KEY_PARAM_SDKVER, NestSdkVersion.INSTANCE.getVersion(c.b()));
                        jSONObject.put(EventParams.KEY_CT_SDK_FROM, nestAdData.getSdkFrom());
                        jSONObject.put("appid", nestAdData.getAppId());
                        jSONObject.put("srcid", nestAdData.getAdCode());
                        jSONObject.put(EventParams.KEY_PARAM_NEST_SID, nestAdData.getNestSid());
                        jSONObject.put("scene", i);
                        jSONObject.put("taichi", "LX-24412");
                        jSONObject.put("exp_group", i());
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    zn6.d("lx_client_nestad_huancun_get", null, jSONObject.toString());
                    return ou3Var;
                }
            }
        }
        return next;
    }

    public static String i() {
        return jo6.c("LX-24412", WkAdxAdConfigMg.DSP_NAME_BAIDU);
    }

    public static String j(NestAdData nestAdData) {
        if (nestAdData == null || nestAdData.getAdParams() == null || nestAdData.getAdParams().getExt() == null) {
            return null;
        }
        return nestAdData.getAdParams().getExt().get("requestId");
    }

    public static int k() {
        HashMap<ou3, Long> map = b;
        int i2 = 0;
        if (map != null && map.size() != 0) {
            Iterator<ou3> it = b.keySet().iterator();
            while (it.hasNext()) {
                if (it.next().c == 0) {
                    i2++;
                }
            }
        }
        LogUtil.d(f21509a, "cleanExpiredMomentsAds getUnShowedMomentsAdSize size = " + i2);
        return i2;
    }

    public static boolean l(ou3 ou3Var) {
        if (ou3Var == null) {
            return true;
        }
        return ou3Var.c != 0 && ir5.b() - ou3Var.c > ((long) (g() * 1000));
    }

    public static boolean m() {
        if (g == null) {
            g = Boolean.valueOf(SPUtil.f14322a.a(SPUtil.SCENE.AD, k86.a("key_nest_moments_enable"), false));
        }
        LogUtil.d(f21509a, "isMomentsEnable = " + g);
        return g.booleanValue();
    }

    public static void n(Context context, int i2) {
        if (context != null && h && (context instanceof Activity) && m()) {
            if (i2 < 0 || !e.contains(Integer.valueOf(i2))) {
                if (i2 >= 0) {
                    e.add(Integer.valueOf(i2));
                }
                String strValueOf = String.valueOf(ir5.b());
                HashMap map = new HashMap();
                map.put("requestId", strValueOf);
                map.put("taiChiKey", "LX-24412");
                map.put("exp_group", i());
                AdHelperFeed adHelperFeedCreateAdFeed = WifiNestAd.INSTANCE.createAdFeed();
                LogUtil.d(f21509a, "adParams strategyJson = " + j);
                adHelperFeedCreateAdFeed.getNativeFeedAd((Activity) context, new AdParams.Builder().setExt(map).setFullStrategyJson(j).build(), new a(i2, strValueOf));
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("requestId", strValueOf);
                    jSONObject.put("taichi", "LX-24412");
                    jSONObject.put("exp_group", i());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                zn6.d("lx_client_nestad_req", null, jSONObject.toString());
            }
        }
    }

    public static void o(Context context) {
        if (context == null || d.get() || c <= k()) {
            return;
        }
        int iK = c - k();
        LogUtil.d(f21509a, "preloadMomentsAD count = " + iK);
        for (int i2 = 0; i2 < iK; i2++) {
            n(context, -1);
        }
    }

    public static void p(Long l, ou3 ou3Var) {
        if (ou3Var == null) {
            return;
        }
        if (b == null) {
            b = new HashMap<>();
        }
        b.put(ou3Var, l);
        LogUtil.d(f21509a, "saveMomentsAdToCache size = " + b.size());
        NestAdData nestAdData = ou3Var.f19878a;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("requestId", j(nestAdData));
            jSONObject.put(EventParams.KEY_PARAM_NETTYPE, hx3.h());
            jSONObject.put(LxAdConst.EventKeyParams.KEY_PARAM_ADMODE, nestAdData.getAdMode());
            jSONObject.put(EventParams.KEY_PARAM_SDKVER, NestSdkVersion.INSTANCE.getVersion(c.b()));
            jSONObject.put(EventParams.KEY_CT_SDK_FROM, nestAdData.getSdkFrom());
            jSONObject.put("appid", nestAdData.getAppId());
            jSONObject.put("srcid", nestAdData.getAdCode());
            jSONObject.put(EventParams.KEY_PARAM_NEST_SID, nestAdData.getNestSid());
            jSONObject.put("scene", i);
            jSONObject.put("taichi", "LX-24412");
            jSONObject.put("exp_group", i());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        zn6.d("lx_client_nestad_huancun", null, jSONObject.toString());
    }

    public static void q() {
        h = true;
    }

    public static void r(String str) {
        LogUtil.d(f21509a, "updateConfig extra = " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        k = str;
        try {
            j = new JSONObject(str).getString(i());
            LogUtil.d(f21509a, "strategyJson = " + j);
        } catch (Exception unused) {
        }
    }

    public static void s() {
        LogUtil.d(f21509a, "updateEnableWithTaichi strategyJson = " + j + ", configExtra =" + k);
        if (!TextUtils.isEmpty(k)) {
            try {
                JSONObject jSONObject = new JSONObject(k);
                if (!WkAdxAdConfigMg.DSP_NAME_BAIDU.equals(i()) || "A".equalsIgnoreCase(jo6.c("LX-26836", "A"))) {
                    j = jSONObject.getString(i());
                } else if (WkAdxAdConfigMg.DSP_NAME_BAIDU.equalsIgnoreCase(jo6.c("LX-26836", "A"))) {
                    j = jSONObject.getString("LX-26836-B");
                } else if (WkAdxAdConfigMg.DSP_NAME_CSJ.equalsIgnoreCase(jo6.c("LX-26836", "A"))) {
                    j = jSONObject.getString("LX-26836-C");
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("taichi", "LX-24412");
                    jSONObject2.put("exp_group", i());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                zn6.d("lx_client_nestad_getConfig", null, jSONObject2.toString());
            } catch (Exception unused) {
            }
        }
        boolean z = !"A".equals(i());
        LogUtil.i(f21509a, "updateEnableWithTaichi  isMomentsEnable " + z + ", strategyJson = " + j + ", getPMTaichiValue = " + i());
        SPUtil.f14322a.t(SPUtil.SCENE.AD, k86.a("key_nest_moments_enable"), Boolean.valueOf(z));
        g = Boolean.valueOf(z);
    }

    public static void t(String str) {
        LogUtil.d(f21509a, "updateExpiredConfig extra = " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            f = new JSONObject(str).getInt("expiredTime");
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements FeedLoadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f21510a;
        public final /* synthetic */ String b;

        public a(int i, String str) {
            this.f21510a = i;
            this.b = str;
        }

        @Override // com.wifi.ad.core.listener.FeedLoadListener, com.wifi.ad.core.listener.BaseListener
        public void onAdFailed(String str, String str2) {
            LogUtil.d(vq3.f21509a, "onAdFailed code = " + str + ", errorMsg = " + str2);
            vq3.d.set(false);
            if (this.f21510a >= 0) {
                vq3.e.remove(Integer.valueOf(this.f21510a));
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("code", str);
                jSONObject.put("msg", str2);
                jSONObject.put(EventParams.KEY_PARAM_NETTYPE, hx3.h());
                jSONObject.put(EventParams.KEY_PARAM_SDKVER, NestSdkVersion.INSTANCE.getVersion(c.b()));
                jSONObject.put("scene", vq3.i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            zn6.d("lx_client_nestad_get_fail", null, jSONObject.toString());
        }

        @Override // com.wifi.ad.core.listener.FeedLoadListener, com.wifi.ad.core.listener.BaseListener
        public void onAdLoaded(String str, List<NestAdData> list) {
            vq3.d.set(false);
            if (this.f21510a >= 0) {
                vq3.e.remove(Integer.valueOf(this.f21510a));
            }
            if (list != null && list.size() != 0) {
                LogUtil.d(vq3.f21509a, "onAdLoaded size = " + list.size());
            }
            NestAdData nestAdData = list.get(0);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("requestId", this.b);
                jSONObject.put(EventParams.KEY_PARAM_NETTYPE, hx3.h());
                jSONObject.put(LxAdConst.EventKeyParams.KEY_PARAM_ADMODE, nestAdData.getAdMode());
                jSONObject.put(EventParams.KEY_PARAM_SDKVER, NestSdkVersion.INSTANCE.getVersion(c.b()));
                jSONObject.put(EventParams.KEY_CT_SDK_FROM, nestAdData.getSdkFrom());
                jSONObject.put("appid", nestAdData.getAppId());
                jSONObject.put("srcid", nestAdData.getAdCode());
                jSONObject.put(EventParams.KEY_PARAM_NEST_SID, nestAdData.getNestSid());
                jSONObject.put("scene", vq3.i);
                jSONObject.put("taichi", "LX-24412");
                jSONObject.put("exp_group", vq3.i());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            zn6.d("lx_client_nestad_get", null, jSONObject.toString());
            int i = 0;
            for (int i2 = 0; i2 < list.size(); i2++) {
                NestAdData nestAdData2 = list.get(i2);
                if (nestAdData2 != null) {
                    if (nestAdData2.getAdMode().intValue() == 4 || nestAdData2.getAdMode().intValue() == 1) {
                        ou3 ou3Var = new ou3();
                        ou3Var.b = ir5.b() + ((long) i2);
                        ou3Var.f19878a = nestAdData2;
                        vq3.p(new Long(0L), ou3Var);
                        i++;
                    } else {
                        LogUtil.d(vq3.f21509a, "onFeedAdLoad, AdMode is illeagle!! type = " + nestAdData2.getAdMode());
                    }
                }
            }
            if (i > 0) {
                Intent intent = new Intent();
                intent.setAction(k86.i("ACTION_NOTIFY_RECIEVE_MOMENTS_AD"));
                LocalBroadcastManager.getInstance(c.b()).sendBroadcast(intent);
            }
        }

        @Override // com.wifi.ad.core.listener.FeedLoadListener, com.wifi.ad.core.listener.BaseListener
        public void onStart() {
        }
    }
}
