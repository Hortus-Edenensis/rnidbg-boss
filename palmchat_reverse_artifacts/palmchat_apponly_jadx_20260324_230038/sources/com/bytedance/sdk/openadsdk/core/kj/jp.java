package com.bytedance.sdk.openadsdk.core.kj;

import com.cdo.oaps.ad.OapsKey;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class jp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private nr f5311a;
    private String b;
    private boolean fx;
    private String iz;
    private u jk;
    private int n;
    private boolean nr;
    private String pn;
    private String u;
    private JSONArray x;

    public static jp u(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        jp jpVar = new jp();
        jpVar.u = jSONObject.optString("promotion_id");
        jpVar.nr = jSONObject.optBoolean("is_silent_auth", false);
        jpVar.fx = jSONObject.optBoolean("enable_playable_auth", false);
        jpVar.b = jSONObject.optString("aweme_agreements");
        jpVar.pn = jSONObject.optString("aweme_privacy");
        jpVar.iz = jSONObject.optString("live_csj_libra_param");
        jpVar.x = jSONObject.optJSONArray("tasks");
        jpVar.n = jSONObject.optInt("live_playable");
        jpVar.jk = u.u(jSONObject.optJSONObject("product"));
        jpVar.f5311a = nr.u(jSONObject.optJSONObject("coupon"));
        return jpVar;
    }

    public boolean a() {
        return this.n == 2 && this.fx;
    }

    public boolean b() {
        return this.fx;
    }

    public boolean fx() {
        return this.nr;
    }

    public String iz() {
        return this.pn;
    }

    public nr jk() {
        return this.f5311a;
    }

    public JSONArray n() {
        return this.x;
    }

    public String nr() {
        return this.u;
    }

    public String pn() {
        return this.b;
    }

    public u t() {
        return this.jk;
    }

    public String x() {
        return this.iz;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class nr {
        int nr;
        int u;

        public static nr u(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            nr nrVar = new nr();
            nrVar.u = jSONObject.optInt("amount");
            nrVar.nr = jSONObject.optInt("threshold");
            return nrVar;
        }

        public JSONObject fx() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("amount", this.u);
                jSONObject.put("threshold", this.nr);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }

        public int nr() {
            return this.nr;
        }

        public int u() {
            return this.u;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        double b;
        double fx;
        String nr;
        String u;

        public static u u(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            u uVar = new u();
            uVar.u = jSONObject.optString("title");
            uVar.nr = jSONObject.optString("image");
            uVar.b = jSONObject.optDouble(OapsKey.KEY_PRICE);
            uVar.fx = jSONObject.optDouble("origin_price");
            return uVar;
        }

        public double b() {
            return this.b;
        }

        public double fx() {
            return this.fx;
        }

        public String nr() {
            return this.nr;
        }

        public JSONObject pn() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("title", this.u);
                jSONObject.put("image", this.nr);
                jSONObject.put(OapsKey.KEY_PRICE, this.b);
                jSONObject.put("origin_price", this.fx);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }

        public String u() {
            return this.u;
        }
    }

    public JSONObject u() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("promotion_id", this.u);
            jSONObject.put("is_silent_auth", this.nr);
            jSONObject.put("enable_playable_auth", this.fx);
            jSONObject.put("aweme_agreements", this.b);
            jSONObject.put("aweme_privacy", this.pn);
            jSONObject.put("live_csj_libra_param", this.iz);
            jSONObject.put("tasks", this.x);
            jSONObject.put("live_playable", this.n);
            u uVar = this.jk;
            if (uVar != null) {
                jSONObject.put("product", uVar.pn());
            }
            nr nrVar = this.f5311a;
            if (nrVar != null) {
                jSONObject.put("coupon", nrVar.fx());
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
