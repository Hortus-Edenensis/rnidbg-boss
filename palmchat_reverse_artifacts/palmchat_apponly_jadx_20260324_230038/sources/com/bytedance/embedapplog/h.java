package com.bytedance.embedapplog;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class h {
    private String b;
    private String fx;
    private int iz;
    private long nr;
    private final JSONObject pn = new JSONObject();
    private String u;

    public void fx(String str) {
        this.b = str;
    }

    public void nr(String str) {
        this.fx = str;
    }

    public String toString() {
        return "FingerInfo{name='" + this.u + "', duration=" + this.nr + ", data='" + this.fx + "', error='" + this.b + "'}";
    }

    public void u(String str) {
        this.u = str;
    }

    public void fx() {
        try {
            this.pn.putOpt("duration", Long.valueOf(this.nr));
            if ("d_i0".equals(this.u) || "d_a0".equals(this.u)) {
                this.pn.putOpt("data", new JSONObject(this.fx));
            } else {
                this.pn.putOpt("data", this.fx);
            }
            this.pn.putOpt(MediationConstant.KEY_ERROR_MSG, this.b);
        } catch (JSONException e) {
            bg.u("__kite json error " + e.getMessage());
        }
    }

    public JSONObject nr() {
        return this.pn;
    }

    public String u() {
        return this.u;
    }

    public void u(long j) {
        this.nr = j;
    }

    public void u(int i) {
        this.iz = i;
    }
}
