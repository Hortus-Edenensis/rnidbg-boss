package com.bytedance.adsdk.ugeno.fx;

import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class my {
    private my b;
    private JSONObject fx;
    private int nr;
    private my pn;
    private com.bytedance.adsdk.ugeno.nr.fx u;

    public my b() {
        return this.b;
    }

    public JSONObject fx() {
        return this.fx;
    }

    public int nr() {
        return this.nr;
    }

    public String toString() {
        return "UGenEvent{mWidget=" + this.u + ", mEventType=" + this.nr + ", mEvent=" + this.fx + '}';
    }

    public com.bytedance.adsdk.ugeno.nr.fx u() {
        return this.u;
    }

    public void nr(my myVar) {
        this.pn = myVar;
    }

    public void u(com.bytedance.adsdk.ugeno.nr.fx fxVar) {
        this.u = fxVar;
    }

    public void u(int i) {
        this.nr = i;
    }

    public void u(JSONObject jSONObject) {
        this.fx = jSONObject;
    }

    public void u(my myVar) {
        this.b = myVar;
    }
}
