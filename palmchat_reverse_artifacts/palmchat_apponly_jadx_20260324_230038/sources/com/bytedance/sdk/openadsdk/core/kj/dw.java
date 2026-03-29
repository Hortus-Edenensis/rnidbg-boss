package com.bytedance.sdk.openadsdk.core.kj;

import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class dw {
    int u = 1;
    int nr = 1;

    public JSONObject fx() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ah", this.u);
            jSONObject.put("am", this.nr);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.k.u(e.toString());
        }
        return jSONObject;
    }

    public void nr(int i) {
        this.nr = i;
    }

    public void u(int i) {
        this.u = i;
    }

    public boolean nr() {
        return this.nr == 1;
    }

    public boolean u() {
        return this.u == 1;
    }
}
