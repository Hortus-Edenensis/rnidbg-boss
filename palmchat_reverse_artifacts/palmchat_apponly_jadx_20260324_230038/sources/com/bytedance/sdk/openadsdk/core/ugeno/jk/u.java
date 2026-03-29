package com.bytedance.sdk.openadsdk.core.ugeno.jk;

import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private JSONObject b;
    private JSONObject fx;
    private JSONObject nr;
    private JSONObject pn;
    private JSONArray u;

    public JSONObject b() {
        return this.b;
    }

    public JSONObject fx() {
        return this.fx;
    }

    public JSONObject nr() {
        return this.nr;
    }

    public JSONObject pn() {
        return this.pn;
    }

    public JSONArray u() {
        return this.u;
    }

    public void b(JSONObject jSONObject) {
        this.pn = jSONObject;
    }

    public void fx(JSONObject jSONObject) {
        this.b = jSONObject;
    }

    public void nr(JSONObject jSONObject) {
        this.fx = jSONObject;
    }

    public void u(JSONArray jSONArray) {
        this.u = jSONArray;
    }

    public void u(JSONObject jSONObject) {
        this.nr = jSONObject;
    }
}
