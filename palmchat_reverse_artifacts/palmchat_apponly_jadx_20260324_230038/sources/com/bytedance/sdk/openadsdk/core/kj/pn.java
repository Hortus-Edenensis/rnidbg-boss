package com.bytedance.sdk.openadsdk.core.kj;

import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn {
    private int b;
    private String fx;
    private int iz;
    private String nr;
    private int pn;
    private String u;
    private String x;

    public String b() {
        return this.fx;
    }

    public String fx() {
        return this.nr;
    }

    public int iz() {
        return this.pn;
    }

    public JSONObject n() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_name", fx());
            jSONObject.put("app_size", x());
            jSONObject.put("comment_num", iz());
            jSONObject.put(WfConstant.EXTRA_KEY_DOWNLOAD_URL, nr());
            jSONObject.put("package_name", b());
            jSONObject.put("score", pn());
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.k.u(e.toString());
        }
        return jSONObject;
    }

    public String nr() {
        return this.u;
    }

    public int pn() {
        return this.b;
    }

    public String u() {
        return this.x;
    }

    public int x() {
        return this.iz;
    }

    public void b(String str) {
        this.fx = str;
    }

    public void fx(String str) {
        this.nr = str;
    }

    public void nr(String str) {
        this.u = str;
    }

    public void u(String str) {
        this.x = str;
    }

    public void fx(int i) {
        this.iz = i;
    }

    public void nr(int i) {
        this.pn = i;
    }

    public void u(int i) {
        this.b = i;
    }
}
