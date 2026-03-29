package com.bytedance.sdk.openadsdk.core.kj;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class wq {
    private int nr;
    private boolean u;

    public wq(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("landing_page_conf");
        if (jSONObjectOptJSONObject != null) {
            this.u = jSONObjectOptJSONObject.optInt("swipe_back_type", 0) == 1;
            this.nr = jSONObjectOptJSONObject.optInt("filter_track", 0);
        }
    }

    private static wq fx(bc bcVar) {
        if (bcVar == null) {
            return null;
        }
        return bcVar.al();
    }

    public static boolean nr(bc bcVar) {
        wq wqVarFx = fx(bcVar);
        return wqVarFx != null && wqVarFx.nr == 1;
    }

    public void u(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("swipe_back_type", this.u ? 1 : 0);
            jSONObject2.put("filter_track", this.nr);
        } catch (JSONException unused) {
        }
        try {
            jSONObject.put("landing_page_conf", jSONObject2);
        } catch (JSONException unused2) {
        }
    }

    public static boolean u(bc bcVar) {
        wq wqVarFx = fx(bcVar);
        if (wqVarFx == null) {
            return false;
        }
        return wqVarFx.u;
    }
}
