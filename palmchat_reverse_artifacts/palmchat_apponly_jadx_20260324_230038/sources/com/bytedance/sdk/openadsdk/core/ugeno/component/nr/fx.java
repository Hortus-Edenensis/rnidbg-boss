package com.bytedance.sdk.openadsdk.core.ugeno.component.nr;

import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx {
    private int nr;
    private JSONObject u;

    public fx() {
    }

    public int nr() {
        return this.nr;
    }

    public JSONObject u() {
        return this.u;
    }

    public fx(JSONObject jSONObject, int i) {
        this.u = jSONObject;
        this.nr = i;
    }

    public void u(JSONObject jSONObject) {
        this.u = jSONObject;
    }

    public void u(int i) {
        this.nr = i;
    }
}
