package com.bytedance.sdk.openadsdk.core.kj;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class sx {
    private static JSONObject b;
    private static int fx;
    private static int nr;
    private static int u;

    private static void nr(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        u = jSONObject.optInt("use_dex_load_gdt");
        nr = jSONObject.optInt("use_dex_load_ks");
        fx = jSONObject.optInt("use_dex_load_xiaomi");
        b = jSONObject;
    }

    public static void u(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("app_common_config")) == null) {
            return;
        }
        nr(jSONObjectOptJSONObject.optJSONObject("dex_strategy"));
    }

    public static void u(com.bytedance.sdk.component.b.nr.fx fxVar) {
        JSONObject jSONObject;
        if (fxVar == null || (jSONObject = b) == null) {
            return;
        }
        fxVar.put("dex_strategy", jSONObject.toString());
    }

    public static void nr(com.bytedance.sdk.component.b.nr.fx fxVar) {
        if (fxVar != null) {
            try {
                nr(new JSONObject(fxVar.get("dex_strategy", "")));
            } catch (JSONException unused) {
            }
        }
    }
}
