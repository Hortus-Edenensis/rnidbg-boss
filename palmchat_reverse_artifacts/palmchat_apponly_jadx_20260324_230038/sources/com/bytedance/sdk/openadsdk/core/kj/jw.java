package com.bytedance.sdk.openadsdk.core.kj;

import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class jw {
    private String b;
    private String fx;
    private int iz;
    private String n;
    private int nr;
    private int pn;
    private String u;
    private String x;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("wc_skip_type", nr());
            jSONObject.put("wc_miniapp_link", u());
            jSONObject.put("adv_id", fx());
            jSONObject.put("site_id", b());
            jSONObject.put("wc_open_method", iz());
            jSONObject.put("wc_miniapp_sdk", x());
            jSONObject.put("wc_appid", n());
        } catch (Throwable th) {
            th.getMessage();
        }
        return jSONObject;
    }

    public String b() {
        return this.b;
    }

    public String fx() {
        return this.fx;
    }

    public int iz() {
        return this.iz;
    }

    public String n() {
        return this.n;
    }

    public int nr() {
        return this.nr;
    }

    public int pn() {
        return this.pn;
    }

    public String toString() {
        return a().toString();
    }

    public String u() {
        return this.u;
    }

    public String x() {
        return this.x;
    }

    public void b(String str) {
        this.x = str;
    }

    public void fx(String str) {
        this.b = str;
    }

    public void nr(String str) {
        this.fx = str;
    }

    public void pn(String str) {
        this.n = str;
    }

    public void u(String str) {
        this.u = str;
    }

    public void fx(int i) {
        this.iz = i;
    }

    public void nr(int i) {
        this.pn = i;
    }

    public void u(int i) {
        this.nr = i;
    }

    public static jw u(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        jw jwVar = new jw();
        try {
            jwVar.u(jSONObject.optInt("wc_skip_type"));
            jwVar.u(jSONObject.optString("wc_miniapp_link"));
            jwVar.nr(jSONObject.optString("adv_id"));
            jwVar.fx(jSONObject.optString("site_id"));
            jwVar.fx(jSONObject.optInt("wc_open_method"));
            jwVar.b(jSONObject.optString("wc_miniapp_sdk"));
            jwVar.pn(jSONObject.optString("wc_appid"));
        } catch (Throwable th) {
            th.getMessage();
        }
        return jwVar;
    }
}
