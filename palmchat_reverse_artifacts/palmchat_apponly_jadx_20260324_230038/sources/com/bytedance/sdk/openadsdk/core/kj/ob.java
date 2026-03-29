package com.bytedance.sdk.openadsdk.core.kj;

import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class ob {
    private String b;
    private String fx;
    private int nr;
    private boolean pn;
    private JSONObject u;

    public ob(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.u = jSONObject;
            this.nr = jSONObject.optInt("dialog_type");
            this.fx = jSONObject.optString("template_url");
            this.b = jSONObject.optString("template_md5");
        }
        com.bytedance.sdk.openadsdk.core.ugeno.x.u uVar = new com.bytedance.sdk.openadsdk.core.ugeno.x.u();
        uVar.nr(pn());
        uVar.fx(b());
    }

    public String b() {
        return this.fx;
    }

    public int fx() {
        return this.nr;
    }

    public boolean iz() {
        return this.pn;
    }

    public JSONObject nr() {
        return this.u;
    }

    public String pn() {
        return this.b;
    }

    public JSONObject u() {
        return this.u;
    }

    public void u(boolean z) {
        this.pn = z;
    }
}
