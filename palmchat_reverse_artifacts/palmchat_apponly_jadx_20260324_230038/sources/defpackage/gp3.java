package defpackage;

import android.app.Activity;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.huawei.hms.ads.ContentClassification;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import com.wifi.ad.core.utils.WifiLog;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.sync.dynamic.DynamicItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class gp3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f17767a = null;
    public static boolean b = false;
    public static int c = -1;
    public static int d = 1000;
    public static int e = 3;
    public static int f = 1;
    public static WeakReference<ViewGroup> g = null;
    public static int h = 0;
    public static boolean i = false;

    public static void a(ViewGroup viewGroup, int i2) {
        g = new WeakReference<>(viewGroup);
        h = i2;
    }

    public static void b(boolean z) {
        i = z;
    }

    public static void c(JSONObject jSONObject) {
        WifiLog.d("MMMM 2222 createTabBannerConfigModel ");
        if (jSONObject != null) {
            try {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("Mine_adType");
                WifiLog.d("MMMM createTabBannerConfigModel allObject " + jSONObjectOptJSONObject);
                if (jSONObjectOptJSONObject != null) {
                    b = jSONObjectOptJSONObject.optBoolean("noReqEnable", false);
                    String strOptString = jSONObjectOptJSONObject.optString("taichikey");
                    WifiLog.d("MMMM createTabBannerConfigModel taichikey " + strOptString);
                    if (strOptString != null) {
                        String str = strOptString + "_" + jo6.c(strOptString, "A");
                        WifiLog.d("MMMM createTabBannerConfigModel configKey " + str);
                        JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(str);
                        WifiLog.d("MMMM createTabBannerConfigModel keyObject " + jSONObjectOptJSONObject2);
                        if (jSONObjectOptJSONObject2 != null) {
                            c = jSONObjectOptJSONObject2.optInt("requestTime", -1);
                            WifiLog.d("MMMM createTabBannerConfigModel sRequestTime " + c);
                            d = jSONObjectOptJSONObject2.optInt("adRequestLimit", 1000);
                            WifiLog.d("MMMM createTabBannerConfigModel sAdRequestLimit " + d);
                            e = jSONObjectOptJSONObject2.optInt("adPosition", 3);
                            WifiLog.d("MMMM createTabBannerConfigModel sAdPosition " + e);
                            f = jSONObjectOptJSONObject2.optInt("adType", 1);
                            WifiLog.d("MMMM createTabBannerConfigModel sAdType " + f);
                        }
                    }
                }
            } catch (Exception e2) {
                WifiLog.d("MMMM createTabBannerConfigModel e " + e2.toString());
            }
        }
    }

    public static void d() {
        boolean z;
        WifiLog.d("MMMM 1111 getAdJsonAndConfig ");
        if (h()) {
            DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.ADMINEBANNERNEST);
            boolean z2 = true;
            if (dynamicConfig == null || dynamicConfig.getExtra() == null) {
                z = false;
            } else {
                try {
                    f17767a = new JSONObject(dynamicConfig.getExtra()).optString(f());
                    z = true;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    z = false;
                }
            }
            DynamicItem dynamicConfig2 = rl0.h().d().getDynamicConfig(DynamicConfig.Type.ADMINEBANNERTYPE);
            if (dynamicConfig2 == null || dynamicConfig2.getExtra() == null) {
                z2 = false;
            } else {
                try {
                    c(new JSONObject(dynamicConfig2.getExtra()));
                } catch (JSONException e3) {
                    e3.printStackTrace();
                    z2 = false;
                }
            }
            if (z && z2) {
                gn1.b("LX-34097", f());
            }
        }
    }

    public static int e() {
        return e;
    }

    public static String f() {
        String strC = jo6.c("LX-34097", ContentClassification.AD_CONTENT_CLASSIFICATION_J);
        WifiLog.d("MMMM getBannerTaiValue result " + strC);
        return strC;
    }

    public static String g() {
        return t66.h().e("LX-58597", "A");
    }

    public static boolean h() {
        return !"A".equalsIgnoreCase(f());
    }

    public static boolean i() {
        int iP = v5.p("LX-34097");
        if (iP == 1) {
            return false;
        }
        if (iP == 2) {
            return true;
        }
        return "BCDEFGH".contains(f().toUpperCase());
    }

    public static void j(Activity activity, int i2, String str) {
        int i3;
        WifiLog.d("AAAA MMMM 3333 requestPreTabBanner context " + activity + " sRequestTime " + c + " mStrategyJson " + f17767a);
        if (!WkAdxAdConfigMg.DSP_NAME_BAIDU.equalsIgnoreCase(g())) {
            LogUtil.d("", "lx_client_nestad_noreqmineAd requestPreTabBanner Switch58597 is A tabName " + str + " requestSource " + i2);
            if (i2 == 1) {
                if (c != -1) {
                    return;
                }
            } else if (i2 == 2) {
                int i4 = c;
                if (i4 != -1 && i4 != 0 && i4 != 1) {
                    return;
                }
            } else if (i2 == 3 && (i3 = c) != -1 && i3 != 0) {
                return;
            }
        } else if (!"tab_mine".equals(str)) {
            LogUtil.d("", "lx_client_nestad_noreqmineAd requestPreTabBanner Switch58597 is B && not tabName mine tabName " + str);
            return;
        }
        if (!tu3.f21071a.get()) {
            gn1.f("LX-34097", f(), str, 9);
            return;
        }
        if (!h()) {
            gn1.f("LX-34097", f(), str, 2);
        } else if (activity == null) {
            gn1.f("LX-34097", f(), str, 4);
        } else {
            jp3.j(f17767a, activity, str, i2);
        }
    }

    public static void k(String str, Activity activity) {
        WifiLog.d("MMMM 5555 showLastTabBannerAd name " + str);
        if (activity == null || activity.isFinishing()) {
            gn1.g("LX-34097", f(), str, 3);
            return;
        }
        WeakReference<ViewGroup> weakReference = g;
        ViewGroup viewGroup = weakReference != null ? weakReference.get() : null;
        if (viewGroup == null) {
            gn1.g("LX-34097", f(), str, 2);
        } else {
            jp3.k(str, viewGroup, activity, f, h);
        }
    }

    public static void l(String str) {
        WifiLog.d("MMMM  updateTabBannerNestAdConfig ");
        if (!h() || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            f17767a = new JSONObject(str).optString(f());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void m(String str) {
        WifiLog.d("MMMM  updateTabBannerTypeConfig ");
        if (!h() || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            c(new JSONObject(str));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
