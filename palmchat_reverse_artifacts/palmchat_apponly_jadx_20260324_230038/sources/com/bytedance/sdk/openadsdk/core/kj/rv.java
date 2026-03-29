package com.bytedance.sdk.openadsdk.core.kj;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class rv {
    private String b;
    private String fx;
    private String iz;
    private String nr;
    private String pn;
    private String u;

    public rv(String str, String str2, String str3, String str4) {
        this.u = str3;
        this.nr = str2;
        this.b = str;
        this.fx = str4;
    }

    public JSONObject fx() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tk", this.u).put("vd", this.b).put("cr", this.fx).put(NotificationCompat.CATEGORY_ERROR, this.nr);
            if (!TextUtils.isEmpty(this.fx) && this.fx.equals("2")) {
                if (!TextUtils.isEmpty(this.pn)) {
                    jSONObject.put("i6", this.pn);
                }
                if (!TextUtils.isEmpty(this.iz)) {
                    jSONObject.put("prov", this.iz);
                }
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public String nr() {
        return this.u;
    }

    public String toString() {
        JSONObject jSONObjectFx = fx();
        return jSONObjectFx.length() > 0 ? jSONObjectFx.toString() : "";
    }

    public void u(String str, String str2, String str3, String str4) {
        this.u = str3;
        this.nr = str2;
        this.b = str;
        this.fx = str4;
    }

    public void nr(String str) {
        this.iz = str;
    }

    public String u() {
        return this.nr;
    }

    public void u(String str) {
        this.pn = str;
    }
}
