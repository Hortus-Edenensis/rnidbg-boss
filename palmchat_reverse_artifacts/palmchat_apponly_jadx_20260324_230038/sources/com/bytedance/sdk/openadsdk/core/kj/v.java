package com.bytedance.sdk.openadsdk.core.kj;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class v {
    private int b;
    private long fx;
    private int nr;
    private int pn;
    private int u;

    public static v u(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        v vVar = new v();
        vVar.u = jSONObject.optInt("auth_type");
        vVar.nr = jSONObject.optInt("auth_time");
        vVar.fx = jSONObject.optLong("auth_out_time");
        vVar.b = jSONObject.optInt("video_open_deeplink");
        vVar.pn = jSONObject.optInt("reject_in");
        return vVar;
    }

    public int b() {
        return this.b;
    }

    public int fx() {
        return this.nr;
    }

    public int iz() {
        return this.pn;
    }

    public int nr() {
        return this.u;
    }

    public long pn() {
        return this.fx;
    }

    public JSONObject u() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("auth_type", this.u);
            jSONObject.put("auth_time", this.nr);
            jSONObject.put("auth_out_time", this.fx);
            jSONObject.put("video_open_deeplink", this.b);
            jSONObject.put("reject_in", this.pn);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
