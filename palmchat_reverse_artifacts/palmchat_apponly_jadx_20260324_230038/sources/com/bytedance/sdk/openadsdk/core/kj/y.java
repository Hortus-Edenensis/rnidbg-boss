package com.bytedance.sdk.openadsdk.core.kj;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class y {
    private String b;
    private String fx;
    private int nr;
    private int u;

    public static y u(String str) {
        try {
            return u(new JSONObject(str));
        } catch (JSONException unused) {
            return new y();
        }
    }

    public String b() {
        return this.b;
    }

    public String fx() {
        return this.fx;
    }

    public int nr() {
        return this.nr;
    }

    public boolean pn() {
        return this.u == 1;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ad_live_status", u());
            jSONObject.put("app_id", nr());
            jSONObject.put("partner", fx());
            jSONObject.put("secure_key", b());
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public void fx(String str) {
        this.b = str;
    }

    public void nr(int i) {
        this.nr = i;
    }

    public static y u(JSONObject jSONObject) {
        y yVar = new y();
        yVar.u(jSONObject.optInt("ad_live_status"));
        yVar.nr(jSONObject.optInt("app_id"));
        yVar.nr(jSONObject.optString("partner"));
        yVar.fx(jSONObject.optString("secure_key"));
        return yVar;
    }

    public void nr(String str) {
        this.fx = str;
    }

    public int u() {
        return this.u;
    }

    public void u(int i) {
        this.u = i;
    }
}
