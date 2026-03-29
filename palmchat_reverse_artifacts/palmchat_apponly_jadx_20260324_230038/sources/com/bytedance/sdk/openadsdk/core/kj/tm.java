package com.bytedance.sdk.openadsdk.core.kj;

import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class tm {
    private String b;
    private String fx;
    private int iz;
    private String n;
    private String nr;
    private JSONObject pn;
    private String u;
    private String x;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.u);
            jSONObject.put("md5", this.nr);
            jSONObject.put("url", this.fx);
            jSONObject.put("data", this.b);
            jSONObject.put(WfConstant.EXTRA_KEY_MATERIAL_TYPE, this.iz);
            jSONObject.put("custom_components", this.pn);
            jSONObject.put("express_gesture_priority", this.x);
            jSONObject.put("rule_id", this.n);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public String b() {
        return this.b;
    }

    public String fx() {
        return this.fx;
    }

    public String iz() {
        return this.x;
    }

    public String n() {
        return this.n;
    }

    public String nr() {
        return this.nr;
    }

    public JSONObject pn() {
        return this.pn;
    }

    public String u() {
        return this.u;
    }

    public int x() {
        return this.iz;
    }

    public static tm u(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        tm tmVar = new tm();
        tmVar.u = jSONObject.optString("id");
        tmVar.b = jSONObject.optString("data");
        tmVar.fx = jSONObject.optString("url");
        tmVar.nr = jSONObject.optString("md5");
        tmVar.x = jSONObject.optString("express_gesture_priority");
        tmVar.iz = jSONObject.optInt(WfConstant.EXTRA_KEY_MATERIAL_TYPE);
        tmVar.pn = jSONObject.optJSONObject("custom_components");
        tmVar.n = jSONObject.optString("rule_id");
        return tmVar;
    }
}
