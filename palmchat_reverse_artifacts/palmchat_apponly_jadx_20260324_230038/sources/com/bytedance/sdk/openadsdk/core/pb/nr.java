package com.bytedance.sdk.openadsdk.core.pb;

import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class nr {
    private JSONObject b;
    private String nr;
    private boolean u;
    private long fx = 0;
    private boolean pn = b.nr;

    public static nr u(JSONObject jSONObject) {
        nr nrVar = new nr();
        if (jSONObject != null) {
            nrVar.u(jSONObject.optString("ec_mall_back_url"));
            nrVar.u = jSONObject.optBoolean("sub_process", false);
            nrVar.fx = jSONObject.optLong("init_delay", b.u);
            nrVar.b = jSONObject.optJSONObject("live_tob_init_extra");
            nrVar.u(jSONObject.optString("ec_mall_back_url"));
            nrVar.pn = jSONObject.optBoolean("init_after_click", b.nr);
        }
        return nrVar;
    }

    public String b() {
        return this.nr;
    }

    public JSONObject fx() {
        return this.b;
    }

    public long nr() {
        return this.fx;
    }

    public boolean pn() {
        return this.pn;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ec_mall_back_url", this.nr);
            jSONObject.put("sub_process", this.u);
            jSONObject.put("init_delay", this.fx);
            jSONObject.put("live_tob_init_extra", this.b);
            jSONObject.put("init_after_click", this.pn);
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    public boolean u() {
        return this.u;
    }

    public void u(String str) {
        this.nr = str;
    }
}
