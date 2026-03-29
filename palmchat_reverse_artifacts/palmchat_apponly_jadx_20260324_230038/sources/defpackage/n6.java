package defpackage;

import android.text.TextUtils;
import com.wifi.ad.core.compliance.AdNativeStyleManagerSDK;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import com.zenmen.palmchat.utils.log.LogUtil;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class n6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f19444a = false;
    public static int b = AdNativeStyleManagerSDK.STYLE_VALUE1;
    public static int c = AdNativeStyleManagerSDK.STYLE_VALUE2;
    public static JSONArray d;

    public static boolean a() {
        if (f19444a) {
            return true;
        }
        return !"A".equals(jo6.c("LX-45604", WkAdxAdConfigMg.DSP_NAME_BAIDU));
    }

    public static int b(int i) {
        if (f19444a) {
            return c;
        }
        if (d != null) {
            LogUtil.d("", "NativeType getNativeStyleView scene " + i);
            for (int i2 = 0; i2 < d.length(); i2++) {
                JSONObject jSONObjectOptJSONObject = d.optJSONObject(i2);
                if (jSONObjectOptJSONObject.optInt("adScenes") == i) {
                    int iOptInt = jSONObjectOptJSONObject.optInt("nativeStyle");
                    LogUtil.d("", "NativeType getNativeStyleView scene find " + i + " style " + iOptInt);
                    return iOptInt;
                }
            }
        }
        return b;
    }

    public static boolean c(String str, int i) {
        if (f19444a) {
            return true;
        }
        if (!TextUtils.isEmpty(str) && d != null) {
            LogUtil.d("", "NativeType isShowComplianceInfo scene " + str + " downType " + i);
            boolean z = false;
            for (int i2 = 0; i2 < d.length(); i2++) {
                JSONObject jSONObjectOptJSONObject = d.optJSONObject(i2);
                if (str.equals(jSONObjectOptJSONObject.optInt("adScenes") + "")) {
                    int iOptInt = jSONObjectOptJSONObject.optInt("complianceInfo");
                    LogUtil.d("", "NativeType isShowComplianceInfo scene " + str + " downType " + i + " comInfo " + iOptInt);
                    if (iOptInt == 0) {
                        return false;
                    }
                    if (iOptInt == 1) {
                        return i == 1;
                    }
                    if (iOptInt == 2) {
                        return i == 2;
                    }
                    if (iOptInt == 3) {
                        return true;
                    }
                    z = true;
                }
            }
            if (!z && "VIVO_D624EC4ADC709B48".equals(ac1.m)) {
                return true;
            }
        }
        return false;
    }

    public static void d(JSONArray jSONArray) {
        d = jSONArray;
        LogUtil.d("", "NativeType setStyleInfoArray styleInfoArray " + d);
    }
}
