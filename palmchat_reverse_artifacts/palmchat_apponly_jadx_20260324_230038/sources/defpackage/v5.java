package defpackage;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.pro.f;
import com.wifi.ad.core.compliance.RequestSDKConfig;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.wifi.ad.core.interactive.WkInteractiveManager;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class v5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static JSONArray f21358a = null;
    public static JSONArray b = null;
    public static boolean c = false;
    public static boolean d = false;
    public static boolean e = false;
    public static long f = 0;
    public static long g = 300000;
    public static final String h = nl0.A;
    public static String i = "{\"switchList\":[{\"switch\":\"off\",\"channel\":\"HWEX2_B6C90A2E7847865C\",\"version\":\"all\",\"versionName\":\"all\",\"adScenes\":\"all\"},{\"switch\":\"off\",\"channel\":\"VIVO_D624EC4ADC709B48\",\"version\":\"all\",\"versionName\":\"all\",\"adScenes\":\"49\"}],\"adtypeList\":[{\"channel\":\"HWEX2_B6C90A2E7847865C\",\"version\":\"all\",\"versionName\":\"all\",\"adScenes\":\"all\",\"adtype\":\"2\"}],\"enableSDKList\":[{\"channel\":\"HWEX2_B6C90A2E7847865C\",\"version\":\"all\",\"versionName\":\"all\",\"adScenes\":\"all\",\"enableSDK\":\"huawei\"}],\"nativeStyleComInfo\":[{\"channel\":\"VIVO_D624EC4ADC709B48\",\"version\":\"all\",\"versionName\":\"all\",\"styleInfo\":[{\"adScenes\":56,\"nativeStyle\":1,\"complianceInfo\":1},{\"adScenes\":57,\"nativeStyle\":1,\"complianceInfo\":1},{\"adScenes\":42,\"nativeStyle\":1,\"complianceInfo\":1},{\"adScenes\":78,\"nativeStyle\":1,\"complianceInfo\":1},{\"adScenes\":83,\"nativeStyle\":1,\"complianceInfo\":1},{\"adScenes\":67,\"nativeStyle\":1,\"complianceInfo\":1},{\"adScenes\":62,\"nativeStyle\":1,\"complianceInfo\":1},{\"adScenes\":6,\"nativeStyle\":1,\"complianceInfo\":1},{\"adScenes\":82,\"nativeStyle\":1,\"complianceInfo\":1},{\"adScenes\":16,\"nativeStyle\":1,\"complianceInfo\":1},{\"adScenes\":40,\"nativeStyle\":1,\"complianceInfo\":1},{\"adScenes\":86,\"nativeStyle\":1,\"complianceInfo\":1},{\"adScenes\":59,\"nativeStyle\":1,\"complianceInfo\":1},{\"adScenes\":46,\"nativeStyle\":1,\"complianceInfo\":1}]},{\"channel\":\"all\",\"version\":\"all\",\"versionName\":\"all\",\"styleInfo\":[{\"adScenes\":56,\"nativeStyle\":1,\"complianceInfo\":0},{\"adScenes\":57,\"nativeStyle\":1,\"complianceInfo\":0},{\"adScenes\":42,\"nativeStyle\":1,\"complianceInfo\":0},{\"adScenes\":78,\"nativeStyle\":1,\"complianceInfo\":0},{\"adScenes\":83,\"nativeStyle\":1,\"complianceInfo\":0},{\"adScenes\":67,\"nativeStyle\":1,\"complianceInfo\":0},{\"adScenes\":62,\"nativeStyle\":1,\"complianceInfo\":0},{\"adScenes\":6,\"nativeStyle\":1,\"complianceInfo\":0},{\"adScenes\":82,\"nativeStyle\":1,\"complianceInfo\":0},{\"adScenes\":16,\"nativeStyle\":1,\"complianceInfo\":0},{\"adScenes\":40,\"nativeStyle\":1,\"complianceInfo\":0},{\"adScenes\":86,\"nativeStyle\":1,\"complianceInfo\":0},{\"adScenes\":59,\"nativeStyle\":1,\"complianceInfo\":0},{\"adScenes\":46,\"nativeStyle\":1,\"complianceInfo\":0}]}]}";
    public static SharedPreferences j = null;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends yw4 {
        @Override // defpackage.yw4
        public void onFail(Exception exc) {
            v5.d = false;
            v5.i(2, exc.toString(), "");
            LogUtil.d("", "DDT getAllAdConfig Exception error " + exc);
            v5.h();
        }

        @Override // defpackage.yw4
        public void onSuccess(JSONObject jSONObject, yy2 yy2Var) {
            LogUtil.d("", "DDT getAllAdConfig oriData " + jSONObject);
            v5.d = false;
            if (jSONObject == null) {
                onFail(new Exception("data is null"));
                return;
            }
            if (yy2Var == null) {
                onFail(new Exception("response is null"));
                return;
            }
            if (yy2Var.b != 0) {
                onFail(new Exception("resultCode is error"));
                return;
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            if (jSONObjectOptJSONObject == null) {
                onFail(new Exception("data is null"));
                return;
            }
            v5.f = System.currentTimeMillis();
            v5.i(1, "", jSONObjectOptJSONObject.toString());
            LogUtil.d("", "DDT2 getAllAdConfig onSuccess ");
            v5.m().edit().putString("ad_config_result", jSONObjectOptJSONObject.toString()).apply();
            v5.u(jSONObjectOptJSONObject);
        }
    }

    public static boolean g(String str, String str2, String str3) {
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

    public static void h() {
        try {
            i = m().getString("ad_config_result", i);
            LogUtil.d("", "DDT2 initConfig dftConfig dftAllConfig " + i);
            u(new JSONObject(i));
        } catch (Exception unused) {
        }
    }

    public static void i(int i2, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DeviceInfoUtil.UID_TAG, v4.e(c.b()));
            jSONObject.put("deviceId", ac1.h);
            jSONObject.put("resultcode", i2);
            jSONObject.put("msg", str);
            jSONObject.put("result", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        zn6.d("nest_sdk_ad_YKresult", null, jSONObject.toString());
    }

    public static String j(long j2, String str) {
        return new SimpleDateFormat(str).format(new Date(j2));
    }

    public static int k() {
        try {
            SPUtil sPUtil = SPUtil.f14322a;
            SPUtil.SCENE scene = SPUtil.SCENE.AD;
            long jI = sPUtil.i(scene, "key_ad_request_date_cache_time", 0L);
            long jCurrentTimeMillis = System.currentTimeMillis();
            LogUtil.d("", "getAdRequestTimes date " + jI);
            if (jI != 0) {
                if (!j(jCurrentTimeMillis, "yyyy-MM-dd").equals(j(jI, "yyyy-MM-dd"))) {
                    LogUtil.d("", "getAdRequestTimes !curDate.equals(lastDate) ");
                    return 0;
                }
                int iF = sPUtil.f(scene, "key_ad_request_cache_time", 0);
                LogUtil.d("", "getAdRequestTimes today ");
                return iF;
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    public static void l() {
        LogUtil.d("", "DDT getAllAdConfig start request requestIng " + d);
        if (System.currentTimeMillis() - f <= g || d) {
            return;
        }
        d = true;
        LogUtil.d("", "DDT getAllAdConfig start request time allow APP_CHANGE_BACKGROUD_POST_LIST " + h);
        try {
            long jK = k();
            LogUtil.d("", "getAllAdConfig adRequestTimes " + jK);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(DeviceInfoUtil.UID_TAG, v4.e(c.b()));
            String strB = qu3.b();
            if (!TextUtils.isEmpty(strB)) {
                try {
                    jSONObject.put("lon", Double.parseDouble(strB));
                } catch (Exception unused) {
                }
            }
            String strA = qu3.a();
            if (!TextUtils.isEmpty(strA)) {
                try {
                    jSONObject.put(f.C, Double.parseDouble(strA));
                } catch (Exception unused2) {
                }
            }
            jSONObject.put("adAggRequestCount", jK);
            jSONObject.put("vpnStatus", zh6.c().e());
            LocationEx locationExI = q05.i();
            if (locationExI != null && !TextUtils.isEmpty(locationExI.getCityCode())) {
                jSONObject.put("cityCode", locationExI.getCityCode());
            }
            zw4.j(h, 1, jSONObject, new a(), true, true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static SharedPreferences m() {
        if (j == null) {
            synchronized (v5.class) {
                if (j == null) {
                    j = c.b().getSharedPreferences("ad_config_all_open_type", 4);
                }
            }
        }
        return j;
    }

    public static void n() {
        LogUtil.d("", "AAAA DDT2 initConfig start");
        h();
        l();
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x009d, code lost:
    
        r6 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean o(int i2) {
        boolean z;
        boolean z2;
        l();
        if (c || e) {
            return false;
        }
        int iC = m6.c(i2);
        LogUtil.d("", "DDT isAdConfigOpen mAdScenes scene " + i2 + " res " + iC);
        if (iC != -1) {
            if (iC == 0) {
                return false;
            }
            if (iC == 1) {
                return true;
            }
        }
        if (b != null) {
            for (int i3 = 0; i3 < b.length(); i3++) {
                JSONObject jSONObjectOptJSONObject = b.optJSONObject(i3);
                LogUtil.d("", "DDT2 isAdConfigOpen all return false adConfigObject " + jSONObjectOptJSONObject);
                String[] strArrSplit = jSONObjectOptJSONObject.optString("adScenes", "").split(",");
                if (strArrSplit != null) {
                    int i4 = 0;
                    while (true) {
                        if (i4 >= strArrSplit.length) {
                            z = false;
                            break;
                        }
                        if (strArrSplit[i4].equals("all")) {
                            z = true;
                            break;
                        }
                        if (strArrSplit[i4].equals(i2 + "")) {
                            z = false;
                            z2 = true;
                            break;
                        }
                        i4++;
                    }
                    LogUtil.d("", "DDT2 isAdConfigOpen all isAllScene + " + z + " isOnlyScene:" + z2 + " scene " + i2);
                    if (z) {
                        LogUtil.d("", "DDT2 isAdConfigOpen all return false scene " + i2);
                        return false;
                    }
                    if (z2) {
                        LogUtil.d("", "DDT2 isAdConfigOpen mAdScenes.contains return false scene " + i2);
                        return false;
                    }
                }
            }
        }
        if (l6.c()) {
            boolean zJ = l6.j(i2);
            LogUtil.d("", "DDT isAdConfigOpen mAdScenes scene " + i2 + " vipRes " + zJ);
            if (!zJ) {
                return false;
            }
        }
        return true;
    }

    public static int p(String str) {
        int iD = m6.d(str);
        LogUtil.d("", "DDT isNativeAd sceneTai " + str + " isConfigNative " + iD);
        if (iD != -1) {
            return iD;
        }
        if (f21358a != null) {
            for (int i2 = 0; i2 < f21358a.length(); i2++) {
                JSONObject jSONObjectOptJSONObject = f21358a.optJSONObject(i2);
                String strOptString = jSONObjectOptJSONObject.optString("adScenes");
                LogUtil.d("", "DDT isNativeAd sceneTai " + str + " adScene " + strOptString);
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

    public static void q(JSONArray jSONArray) {
        if (jSONArray != null) {
            b = null;
            b = new JSONArray();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
                if (g(jSONObjectOptJSONObject.optString("version"), jSONObjectOptJSONObject.optString("channel"), jSONObjectOptJSONObject.optString("versionName")) && WkInteractiveManager.TimingTypeOff.equals(jSONObjectOptJSONObject.optString("switch"))) {
                    b.put(jSONObjectOptJSONObject);
                }
            }
            LogUtil.d("", "DDT2 parAdManagerList adAdConfigOpen " + b + " switchList " + jSONArray);
        }
    }

    public static void r(JSONArray jSONArray) {
        if (jSONArray != null) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
                if (g(jSONObjectOptJSONObject.optString("version"), jSONObjectOptJSONObject.optString("channel"), jSONObjectOptJSONObject.optString("versionName"))) {
                    JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("styleInfo");
                    LogUtil.d("", "NativeType parAdNativeType success styleInfoArray " + jSONArrayOptJSONArray);
                    if (jSONArrayOptJSONArray != null) {
                        n6.d(jSONArrayOptJSONArray);
                        return;
                    }
                }
            }
        }
    }

    public static void s(JSONArray jSONArray) {
        if (jSONArray != null) {
            JSONArray jSONArray2 = new JSONArray();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
                if (g(jSONObjectOptJSONObject.optString("version"), jSONObjectOptJSONObject.optString("channel"), jSONObjectOptJSONObject.optString("versionName"))) {
                    jSONArray2.put(jSONObjectOptJSONObject);
                }
            }
            RequestSDKConfig.INSTANCE.setAdSDKSceneArray(jSONArray2);
            LogUtil.d("", "DDT parAdSDKList adSDKScene " + jSONArray2 + " enableSDKList " + jSONArray);
        }
    }

    public static void t(JSONArray jSONArray) {
        if (jSONArray != null) {
            f21358a = null;
            f21358a = new JSONArray();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
                if (g(jSONObjectOptJSONObject.optString("version"), jSONObjectOptJSONObject.optString("channel"), jSONObjectOptJSONObject.optString("versionName"))) {
                    f21358a.put(jSONObjectOptJSONObject);
                }
            }
            LogUtil.d("", "DDT parAdTypeList adTypeListScene " + f21358a + " adtypeList " + jSONArray);
        }
    }

    public static void u(JSONObject jSONObject) {
        t(jSONObject.optJSONArray("adtypeList"));
        s(jSONObject.optJSONArray("enableSDKList"));
        q(jSONObject.optJSONArray("switchList"));
        r(jSONObject.optJSONArray("nativeStyleComInfo"));
        c = jSONObject.optBoolean("IPList", false);
        e = jSONObject.optBoolean("locationList", false);
    }
}
