package com.bytedance.sdk.openadsdk.core.kj;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pb {
    public JSONObject u;

    public String toString() {
        JSONObject jSONObject = this.u;
        return jSONObject == null ? "" : jSONObject.toString();
    }

    public String u() {
        JSONObject jSONObject = this.u;
        JSONObject jSONObjectOptJSONObject = jSONObject == null ? null : jSONObject.optJSONObject("performance_js");
        return jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString("url") : "";
    }

    public static pb u(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return u(new JSONObject(str));
        } catch (JSONException unused) {
            return null;
        }
    }

    public static pb u(JSONObject jSONObject) {
        pb pbVar = new pb();
        pbVar.u = jSONObject;
        return pbVar;
    }
}
