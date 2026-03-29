package com.bytedance.sdk.openadsdk.core.kj;

import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5312a;
    private int b;
    private int fx;
    private String iz;
    private int jk;
    private int l;
    private boolean mv;
    private String n;
    private String nr;
    private String pn;
    private int t;
    private int u;
    private String x;

    public m(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("live_ad")) == null) {
            return;
        }
        this.mv = true;
        u(jSONObjectOptJSONObject.optInt("live_show_time", 60));
        this.nr = jSONObjectOptJSONObject.optString("live_author_nickname");
        this.fx = jSONObjectOptJSONObject.optInt("live_author_follower_count", -1);
        this.b = jSONObjectOptJSONObject.optInt("live_watch_count", -1);
        this.pn = jSONObjectOptJSONObject.optString("live_description");
        this.iz = jSONObjectOptJSONObject.optString("live_feed_url");
        this.x = jSONObjectOptJSONObject.optString("live_cover_image_url");
        this.n = jSONObjectOptJSONObject.optString("live_avatar_url");
        this.f5312a = jSONObjectOptJSONObject.optInt("live_avatar_width");
        this.jk = jSONObjectOptJSONObject.optInt("live_avatar_height");
        this.t = jSONObjectOptJSONObject.optInt("live_cover_width");
        this.l = jSONObjectOptJSONObject.optInt("live_cover_height");
    }

    public static String a(bc bcVar) {
        m mVarS = s(bcVar);
        return mVarS == null ? "" : mVarS.n;
    }

    public static int b(bc bcVar) {
        m mVarS = s(bcVar);
        if (mVarS == null) {
            return 0;
        }
        return mVarS.fx;
    }

    public static String fx(bc bcVar) {
        m mVarS = s(bcVar);
        return mVarS == null ? "" : mVarS.nr;
    }

    public static String iz(bc bcVar) {
        m mVarS = s(bcVar);
        return mVarS == null ? "" : mVarS.pn;
    }

    public static int jk(bc bcVar) {
        m mVarS = s(bcVar);
        if (mVarS == null) {
            return 0;
        }
        return mVarS.f5312a;
    }

    public static int l(bc bcVar) {
        m mVarS = s(bcVar);
        if (mVarS == null) {
            return 0;
        }
        return mVarS.t;
    }

    public static int mv(bc bcVar) {
        m mVarS = s(bcVar);
        if (mVarS == null) {
            return 0;
        }
        return mVarS.l;
    }

    public static String n(bc bcVar) {
        m mVarS = s(bcVar);
        return mVarS == null ? "" : mVarS.x;
    }

    public static int nr(bc bcVar) {
        m mVarS = s(bcVar);
        if (mVarS == null) {
            return 0;
        }
        return mVarS.u;
    }

    public static int pn(bc bcVar) {
        m mVarS = s(bcVar);
        if (mVarS == null) {
            return 0;
        }
        return mVarS.b;
    }

    private static m s(bc bcVar) {
        if (bcVar == null) {
            return null;
        }
        return bcVar.vb();
    }

    public static int t(bc bcVar) {
        m mVarS = s(bcVar);
        if (mVarS == null) {
            return 0;
        }
        return mVarS.jk;
    }

    public static String x(bc bcVar) {
        m mVarS = s(bcVar);
        return mVarS == null ? "" : mVarS.iz;
    }

    public boolean u() {
        return this.mv;
    }

    public void u(JSONObject jSONObject) {
        if (this.mv) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("live_show_time", this.u);
                jSONObject2.put("live_author_nickname", this.nr);
                jSONObject2.put("live_author_follower_count", this.fx);
                jSONObject2.put("live_watch_count", this.b);
                jSONObject2.put("live_description", this.pn);
                jSONObject2.put("live_feed_url", this.iz);
                jSONObject2.put("live_cover_image_url", this.x);
                jSONObject2.put("live_avatar_url", this.n);
                jSONObject2.put("live_cover_width", this.t);
                jSONObject2.put("live_cover_height", this.l);
                jSONObject2.put("live_avatar_width", this.f5312a);
                jSONObject2.put("live_avatar_height", this.jk);
                jSONObject.put("live_ad", jSONObject2);
            } catch (Exception unused) {
            }
        }
    }

    public static boolean u(bc bcVar) {
        m mVarS = s(bcVar);
        if (mVarS == null) {
            return false;
        }
        return mVarS.mv;
    }

    public void u(int i) {
        if (i <= 0 || i > 300) {
            i = 60;
        }
        this.u = i;
    }
}
