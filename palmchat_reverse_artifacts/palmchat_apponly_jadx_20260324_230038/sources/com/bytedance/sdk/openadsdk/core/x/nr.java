package com.bytedance.sdk.openadsdk.core.x;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    private boolean b;
    private int fx;
    private int nr;
    private int u;

    public boolean b() {
        return this.b;
    }

    public int fx() {
        return this.fx;
    }

    public int nr() {
        return this.nr;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("expire_days", nr());
            jSONObject.put("log_level", u());
            jSONObject.put("max_size", fx());
            jSONObject.put("is_open", b());
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public int u() {
        return this.u;
    }

    public void fx(int i) {
        this.fx = i;
    }

    public void nr(int i) {
        this.nr = i;
    }

    public void u(int i) {
        this.u = i;
    }

    public static nr u(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return u(new JSONObject(str));
        } catch (JSONException unused) {
            return null;
        }
    }

    public static nr u(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        nr nrVar = new nr();
        nrVar.nr(jSONObject.optInt("expire_days"));
        nrVar.u(jSONObject.optInt("log_level"));
        nrVar.fx(jSONObject.optInt("max_size"));
        nrVar.u(jSONObject.optBoolean("is_open"));
        return nrVar;
    }

    public void u(boolean z) {
        this.b = z;
    }
}
