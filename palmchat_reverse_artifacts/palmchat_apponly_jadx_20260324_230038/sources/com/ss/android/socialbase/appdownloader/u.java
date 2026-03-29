package com.ss.android.socialbase.appdownloader;

import android.text.TextUtils;
import com.baidu.mapapi.SDKInitializer;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class u {
    public String b;
    public String fx;
    public int nr = -1;
    public String pn;
    public String u;

    public JSONObject nr() {
        JSONObject jSONObject = new JSONObject();
        u(jSONObject);
        return jSONObject;
    }

    public String u() {
        return nr().toString();
    }

    public void u(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("ah_plan_type", this.u);
            jSONObject.put(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, String.valueOf(this.nr));
            jSONObject.put("error_msg", this.fx);
            jSONObject.put("real_device_plan", this.b);
            jSONObject.put("device_plans", this.pn);
        } catch (Throwable unused) {
        }
    }

    public static u u(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        u uVar = new u();
        try {
            JSONObject jSONObject = new JSONObject(str);
            uVar.pn = jSONObject.optString("device_plans", null);
            uVar.b = jSONObject.optString("real_device_plan", null);
            uVar.fx = jSONObject.optString("error_msg", null);
            uVar.u = jSONObject.optString("ah_plan_type", null);
            String strOptString = jSONObject.optString(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE);
            if (TextUtils.isEmpty(strOptString)) {
                uVar.nr = -1;
            } else {
                uVar.nr = Integer.parseInt(strOptString);
            }
        } catch (Throwable unused) {
        }
        return uVar;
    }
}
