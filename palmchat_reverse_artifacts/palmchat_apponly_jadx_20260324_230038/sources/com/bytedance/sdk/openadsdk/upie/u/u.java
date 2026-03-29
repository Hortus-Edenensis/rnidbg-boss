package com.bytedance.sdk.openadsdk.upie.u;

import android.text.TextUtils;
import com.bytedance.adsdk.nr.my;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    public static String u(String str, JSONObject jSONObject) {
        com.bytedance.adsdk.nr.nr.u uVarU;
        if (TextUtils.isEmpty(str) || jSONObject == null) {
            return str;
        }
        try {
            if (!str.startsWith("${") || !str.endsWith("}") || (uVarU = com.bytedance.adsdk.nr.nr.u.u(str.substring(2, str.length() - 1))) == null) {
                return str;
            }
            Object objU = uVarU.u(jSONObject);
            return objU instanceof String ? (String) objU : objU instanceof com.bytedance.adsdk.nr.nr.u.u ? String.valueOf(my.u((com.bytedance.adsdk.nr.nr.u.u) objU)) : String.valueOf(objU);
        } catch (Throwable unused) {
            return str;
        }
    }
}
