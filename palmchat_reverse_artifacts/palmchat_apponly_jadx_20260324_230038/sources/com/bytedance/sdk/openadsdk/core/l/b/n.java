package com.bytedance.sdk.openadsdk.core.l.b;

import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class n {
    private JSONObject b;
    private JSONObject fx;
    private String nr;
    private String u;

    public static n u() {
        return new n();
    }

    public JSONObject b() {
        return this.fx;
    }

    public String fx() {
        return this.nr;
    }

    public n nr(String str) {
        this.nr = str;
        return this;
    }

    public JSONObject pn() {
        return this.b;
    }

    public n nr(JSONObject jSONObject) {
        this.fx = jSONObject;
        return this;
    }

    public n u(JSONObject jSONObject) {
        this.b = jSONObject;
        return this;
    }

    public String nr() {
        return this.u;
    }

    public n u(String str) {
        this.u = str;
        return this;
    }
}
