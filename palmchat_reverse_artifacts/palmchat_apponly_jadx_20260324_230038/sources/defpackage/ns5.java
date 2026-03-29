package defpackage;

import android.app.Activity;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.igexin.push.core.b;
import com.wifi.ad.core.utils.WifiLog;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.sync.dynamic.DynamicItem;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ns5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f19591a;
    public static HashMap<String, ms5> b = new HashMap<>();
    public static int c = -1;
    public static int d = 1000;

    public static void a(JSONObject jSONObject) {
        WifiLog.d("TTTT 2222 createTabBannerConfigModel ");
        if (jSONObject != null) {
            try {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("BannerAD");
                WifiLog.d("TTTT createTabBannerConfigModel allObject " + jSONObjectOptJSONObject);
                if (jSONObjectOptJSONObject != null) {
                    String strOptString = jSONObjectOptJSONObject.optString("taichikey");
                    WifiLog.d("TTTT createTabBannerConfigModel taichikey " + strOptString);
                    if (strOptString != null) {
                        String str = strOptString + "_" + jo6.c(strOptString, "A");
                        WifiLog.d("TTTT createTabBannerConfigModel configKey " + str);
                        JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(str);
                        WifiLog.d("TTTT createTabBannerConfigModel keyObject " + jSONObjectOptJSONObject2);
                        if (jSONObjectOptJSONObject2 != null) {
                            c = jSONObjectOptJSONObject2.optInt("requestTime");
                            WifiLog.d("TTTT createTabBannerConfigModel mRequestTime " + c);
                            d = jSONObjectOptJSONObject2.optInt("adRequestLimit", 1000);
                            WifiLog.d("TTTT createTabBannerConfigModel mAdRequestLimit " + d);
                            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject2.optJSONArray(b.Y);
                            if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
                                return;
                            }
                            b.clear();
                            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                                ms5 ms5Var = new ms5();
                                JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray.optJSONObject(i);
                                String strOptString2 = jSONObjectOptJSONObject3.optString("showPage");
                                WifiLog.d("TTTT createTabBannerConfigModel pageNames " + strOptString2);
                                if (!TextUtils.isEmpty(strOptString2)) {
                                    ms5Var.d(strOptString2);
                                    ms5Var.c(c);
                                    ms5Var.b(jSONObjectOptJSONObject3.optInt("adPosition"));
                                    b.put(strOptString2, ms5Var);
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
                WifiLog.d("TTTT createTabBannerConfigModel e " + e.toString());
            }
        }
    }

    public static void b() {
        boolean z;
        WifiLog.d("TTTT 1111 getAdJsonAndConfig ");
        if (f()) {
            DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.ADTABBANNERNEST);
            boolean z2 = true;
            if (dynamicConfig == null || dynamicConfig.getExtra() == null) {
                z = false;
            } else {
                try {
                    f19591a = new JSONObject(dynamicConfig.getExtra()).optString(d());
                    z = true;
                } catch (JSONException e) {
                    e.printStackTrace();
                    z = false;
                }
            }
            DynamicItem dynamicConfig2 = rl0.h().d().getDynamicConfig(DynamicConfig.Type.ADTABBANNERTYPE);
            if (dynamicConfig2 == null || dynamicConfig2.getExtra() == null) {
                z2 = false;
            } else {
                try {
                    a(new JSONObject(dynamicConfig2.getExtra()));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    z2 = false;
                }
            }
            if (z && z2) {
                gn1.b("LX-33784", d());
            }
        }
    }

    public static Integer c(String str) {
        ms5 ms5Var;
        if (TextUtils.isEmpty(str) || !b.containsKey(str) || (ms5Var = b.get(str)) == null) {
            return null;
        }
        return Integer.valueOf(ms5Var.a());
    }

    public static String d() {
        WifiLog.d("TTTT getBannerTaiValue result A");
        return "A";
    }

    public static boolean e(String str, boolean z) {
        if (TextUtils.isEmpty(str) || !b.containsKey(str)) {
            if (z) {
                gn1.g("LX-33784", d(), str, 1);
            }
            return false;
        }
        if (ao6.g()) {
            return true;
        }
        if (z) {
            gn1.g("LX-33784", d(), str, 4);
        }
        return false;
    }

    public static boolean f() {
        return !"A".equalsIgnoreCase(d());
    }

    public static void g(Activity activity, boolean z, String str) {
        h(activity, z, str, false);
    }

    public static void h(Activity activity, boolean z, String str, boolean z2) {
        WifiLog.d("TTTT 3333 requestPreTabBanner context " + activity + " mRequestTime " + c + " mStrategyJson " + f19591a);
        if ((!z || c == -1) && f()) {
            if (activity == null) {
                gn1.f("LX-33784", d(), str, 4);
            } else {
                ao6.i(f19591a, activity, str, z2);
            }
        }
    }

    public static void i(String str, ViewGroup viewGroup, Activity activity, int i) {
        WifiLog.d("TTTT 5555 showLastTabBannerAd name " + str);
        if (e(str, true)) {
            if (viewGroup == null) {
                gn1.g("LX-33784", d(), str, 2);
            } else if (activity == null) {
                gn1.g("LX-33784", d(), str, 3);
            } else {
                ao6.j(str, viewGroup, activity, i);
            }
        }
    }

    public static void j(String str) {
        WifiLog.d("TTTT  updateTabBannerNestAdConfig ");
        if (!f() || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            f19591a = new JSONObject(str).optString(d());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void k(String str) {
        WifiLog.d("TTTT  updateTabBannerTypeConfig ");
        if (!f() || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            a(new JSONObject(str));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
