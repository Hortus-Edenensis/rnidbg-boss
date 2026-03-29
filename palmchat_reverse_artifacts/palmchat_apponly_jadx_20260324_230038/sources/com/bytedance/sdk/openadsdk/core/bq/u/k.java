package com.bytedance.sdk.openadsdk.core.bq.u;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.bg.u;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class k extends com.bytedance.sdk.component.u.pn<JSONObject, JSONObject> {
    public static void u(com.bytedance.sdk.component.u.o oVar) {
        oVar.u("getDownloadStatus", (com.bytedance.sdk.component.u.pn<?, ?>) new k());
    }

    @Override // com.bytedance.sdk.component.u.pn
    public JSONObject u(JSONObject jSONObject, com.bytedance.sdk.component.u.iz izVar) throws Exception {
        return u(jSONObject);
    }

    public static JSONObject u(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            u(jSONObject2, 1, "params is null", 1, 1);
            return jSONObject2;
        }
        try {
            String strOptString = jSONObject.optString("ad_down_load_id");
            if (TextUtils.isEmpty(strOptString)) {
                u(jSONObject2, 1, "ad_down_load_id is null", 1, 1);
                return jSONObject2;
            }
            return u.C0239u.u(strOptString);
        } catch (Throwable unused) {
            return jSONObject2;
        }
    }

    private static void u(JSONObject jSONObject, int i, String str, int i2, int i3) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("code", i);
            jSONObject.put("codeMsg", str);
            jSONObject.put("downloadStatus", i2);
            jSONObject.put("downloadProcessRate", i3);
        } catch (Exception unused) {
        }
    }
}
