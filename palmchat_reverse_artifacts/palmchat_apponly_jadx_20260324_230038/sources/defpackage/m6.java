package defpackage;

import android.text.TextUtils;
import com.wifi.ad.core.compliance.RequestSDKConfig;
import com.wifi.ad.core.interactive.WkInteractiveManager;
import com.zenmen.palmchat.utils.log.LogUtil;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class m6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static JSONArray f19142a;
    public static JSONArray b;

    public static boolean a(String str, String str2, String str3) {
        try {
            if (!ac1.f.equals(str) && !"all".equals(str)) {
                return false;
            }
            if (!ac1.g.equals(str3) && !"all".equals(str3)) {
                return false;
            }
            if (ac1.m.equals(str2)) {
                return true;
            }
            return "all".equals(str2);
        } catch (Exception unused) {
            return false;
        }
    }

    public static void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            g(jSONObject.optJSONArray("adtypeList"));
            f(jSONObject.optJSONArray("enableSDKList"));
            e(jSONObject.optJSONArray("switchList"));
        } catch (Exception unused) {
        }
    }

    public static int c(int i) {
        boolean z;
        boolean z2;
        JSONArray jSONArray = b;
        if (jSONArray == null) {
            return -1;
        }
        if (jSONArray != null) {
            for (int i2 = 0; i2 < b.length(); i2++) {
                JSONObject jSONObjectOptJSONObject = b.optJSONObject(i2);
                LogUtil.d("", "DDT2 AdNativeConfigManager isAdConfigOpen all return false adConfigObject " + jSONObjectOptJSONObject);
                String[] strArrSplit = jSONObjectOptJSONObject.optString("adScenes", "").split(",");
                if (strArrSplit != null) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= strArrSplit.length) {
                            z = false;
                            break;
                        }
                        if (strArrSplit[i3].equals("all")) {
                            z = true;
                            break;
                        }
                        if (strArrSplit[i3].equals(i + "")) {
                            z = false;
                            z2 = true;
                            break;
                        }
                        i3++;
                    }
                    z2 = false;
                    LogUtil.d("", "DDT2 AdNativeConfigManager isAdConfigOpen all isAllScene + " + z + " isOnlyScene:" + z2 + " scene " + i);
                    if (z) {
                        LogUtil.d("", "DDT2 AdNativeConfigManager isAdConfigOpen all return false scene " + i);
                        return 0;
                    }
                    if (z2) {
                        LogUtil.d("", "DDT2 AdNativeConfigManager isAdConfigOpen mAdScenes.contains return false scene " + i);
                        return 0;
                    }
                }
            }
        }
        if (l6.c()) {
            boolean zJ = l6.j(i);
            LogUtil.d("", "DDT isAdConfigOpen mAdScenes scene " + i + " vipRes " + zJ);
            if (!zJ) {
                return 0;
            }
        }
        return 1;
    }

    public static int d(String str) {
        LogUtil.d("", "DDT AdNativeConfigManager isNativeAd sceneTai " + str + " adTypeListScene " + f19142a);
        JSONArray jSONArray = f19142a;
        if (jSONArray == null) {
            return -1;
        }
        if (jSONArray != null) {
            for (int i = 0; i < f19142a.length(); i++) {
                JSONObject jSONObjectOptJSONObject = f19142a.optJSONObject(i);
                String strOptString = jSONObjectOptJSONObject.optString("adScenes");
                LogUtil.d("", "DDT AdNativeConfigManager isNativeAd sceneTai " + str + " adScene " + strOptString);
                if (!TextUtils.isEmpty(strOptString) && ("all".equals(strOptString) || strOptString.contains(str))) {
                    String strOptString2 = jSONObjectOptJSONObject.optString("adtype", "");
                    if ("2".equals(strOptString2)) {
                        return 2;
                    }
                    if ("1".equals(strOptString2)) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

    public static void e(JSONArray jSONArray) {
        b = null;
        if (jSONArray != null) {
            b = new JSONArray();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (a(jSONObjectOptJSONObject.optString("version"), jSONObjectOptJSONObject.optString("channel"), jSONObjectOptJSONObject.optString("versionName")) && WkInteractiveManager.TimingTypeOff.equals(jSONObjectOptJSONObject.optString("switch"))) {
                    b.put(jSONObjectOptJSONObject);
                }
            }
            LogUtil.d("", "DDT2 AdNativeConfigManager parAdManagerList adAdConfigOpen " + b + " switchList " + jSONArray);
        }
    }

    public static void f(JSONArray jSONArray) {
        if (jSONArray == null) {
            RequestSDKConfig.INSTANCE.setAdSDKNativeSceneArray(null);
            return;
        }
        JSONArray jSONArray2 = new JSONArray();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (a(jSONObjectOptJSONObject.optString("version"), jSONObjectOptJSONObject.optString("channel"), jSONObjectOptJSONObject.optString("versionName"))) {
                jSONArray2.put(jSONObjectOptJSONObject);
            }
        }
        RequestSDKConfig.INSTANCE.setAdSDKNativeSceneArray(jSONArray2);
        LogUtil.d("", "DDT AdNativeConfigManager parAdSDKList adSDKScene " + jSONArray2 + " enableSDKList " + jSONArray);
    }

    public static void g(JSONArray jSONArray) {
        f19142a = null;
        if (jSONArray != null) {
            f19142a = new JSONArray();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (a(jSONObjectOptJSONObject.optString("version"), jSONObjectOptJSONObject.optString("channel"), jSONObjectOptJSONObject.optString("versionName"))) {
                    f19142a.put(jSONObjectOptJSONObject);
                }
            }
            LogUtil.d("", "DDT AdNativeConfigManager parAdTypeList adTypeListScene " + f19142a + " adtypeList " + jSONArray);
        }
    }
}
