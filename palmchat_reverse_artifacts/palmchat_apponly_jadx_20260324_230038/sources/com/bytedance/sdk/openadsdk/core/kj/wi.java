package com.bytedance.sdk.openadsdk.core.kj;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class wi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5323a;
    private int b;
    private boolean fx;
    private int iz;
    private int jk;
    private int k;
    private String l;
    private int mv;
    private boolean my;
    private int n;
    private int nr;
    private int pn;
    private boolean s;
    private String t;
    private boolean u;
    private boolean x;

    public wi(JSONObject jSONObject) {
        this.jk = 0;
        if (jSONObject == null) {
            return;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("reward_draw");
        if (jSONObjectOptJSONObject != null) {
            this.nr = jSONObjectOptJSONObject.optInt("max_draw_play_time", 10);
            this.b = jSONObjectOptJSONObject.optInt("draw_rewarded_play_time", 30);
            this.pn = jSONObjectOptJSONObject.optInt("skip_btn_left_style", 0);
            this.iz = jSONObjectOptJSONObject.optInt("skip_btn_right_style", 0);
            this.x = jSONObjectOptJSONObject.optBoolean("auto_slide", false);
            this.n = jSONObjectOptJSONObject.optInt("show_time_type", 0);
            this.f5323a = jSONObjectOptJSONObject.optInt("tip_time", 0);
            this.jk = jSONObjectOptJSONObject.optInt("show_type", 0);
            this.fx = jSONObjectOptJSONObject.optBoolean("single_max_countdown", false);
            this.t = jSONObjectOptJSONObject.optString("top_template_url");
            this.l = jSONObjectOptJSONObject.optString("top_template_md5");
            this.mv = jSONObjectOptJSONObject.optInt("top_template_timeout");
            this.s = jSONObjectOptJSONObject.optBoolean("can_cancel");
            this.k = jSONObjectOptJSONObject.optInt("init_status_time", 0);
            this.my = jSONObjectOptJSONObject.optBoolean("is_pause_tip_by_express", false);
        } else {
            this.nr = 10;
            this.b = 30;
        }
        if (jSONObject.optJSONObject(com.umeng.analytics.pro.f.K) != null) {
            this.u = !TextUtils.isEmpty(r6.optString("group_id"));
        }
    }

    public static int a(bc bcVar) {
        wi wiVarO = o(bcVar);
        if (wiVarO == null) {
            return 25;
        }
        return wiVarO.f5323a;
    }

    public static int b(bc bcVar) {
        wi wiVarO = o(bcVar);
        if (wiVarO == null) {
            return 0;
        }
        return wiVarO.pn;
    }

    public static int fx(bc bcVar) {
        int i;
        wi wiVarO = o(bcVar);
        if (wiVarO != null && (i = wiVarO.b) > 0) {
            return i;
        }
        return 30;
    }

    public static boolean iz(bc bcVar) {
        wi wiVarO = o(bcVar);
        if (wiVarO == null) {
            return false;
        }
        return wiVarO.x;
    }

    public static boolean jk(bc bcVar) {
        wi wiVarO = o(bcVar);
        if (wiVarO == null) {
            return false;
        }
        return wiVarO.fx;
    }

    public static int k(bc bcVar) {
        wi wiVarO = o(bcVar);
        if (wiVarO == null) {
            return 0;
        }
        return wiVarO.k;
    }

    public static String l(bc bcVar) {
        wi wiVarO = o(bcVar);
        if (wiVarO == null) {
            return null;
        }
        return wiVarO.l;
    }

    public static int mv(bc bcVar) {
        wi wiVarO = o(bcVar);
        if (wiVarO == null) {
            return 0;
        }
        return wiVarO.mv;
    }

    public static boolean my(bc bcVar) {
        wi wiVarO = o(bcVar);
        if (wiVarO == null) {
            return false;
        }
        return wiVarO.my;
    }

    public static boolean n(bc bcVar) {
        wi wiVarO = o(bcVar);
        return wiVarO != null && u(bcVar) && wiVarO.jk == 1;
    }

    public static int nr(bc bcVar) {
        int i;
        wi wiVarO = o(bcVar);
        if (wiVarO != null && (i = wiVarO.nr) > 0) {
            return i;
        }
        return 10;
    }

    private static wi o(bc bcVar) {
        if (bcVar == null) {
            return null;
        }
        return bcVar.ga();
    }

    public static int pn(bc bcVar) {
        wi wiVarO = o(bcVar);
        if (wiVarO == null) {
            return 0;
        }
        return wiVarO.iz;
    }

    public static boolean s(bc bcVar) {
        wi wiVarO = o(bcVar);
        if (wiVarO == null) {
            return false;
        }
        return wiVarO.s;
    }

    public static String t(bc bcVar) {
        wi wiVarO = o(bcVar);
        if (wiVarO == null) {
            return null;
        }
        return wiVarO.t;
    }

    public static int x(bc bcVar) {
        wi wiVarO = o(bcVar);
        if (wiVarO == null) {
            return 10;
        }
        return wiVarO.n == 1 ? Math.min((int) Math.max(zx.x(bcVar), fx(bcVar)), 60) : fx(bcVar);
    }

    public void u(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("max_draw_play_time", this.nr);
            jSONObject2.put("draw_rewarded_play_time", this.b);
            jSONObject2.put("skip_btn_left_style", this.pn);
            jSONObject2.put("skip_btn_right_style", this.iz);
            jSONObject2.put("auto_slide", this.x);
            jSONObject2.put("show_time_type", this.n);
            jSONObject2.put("show_type", this.jk);
            jSONObject2.put("tip_time", this.f5323a);
            jSONObject2.put("single_max_countdown", this.fx);
            jSONObject2.put("top_template_url", this.t);
            jSONObject2.put("top_template_md5", this.l);
            jSONObject2.put("top_template_timeout", this.mv);
            jSONObject2.put("can_cancel", this.s);
            jSONObject2.put("init_status_time", this.k);
            jSONObject2.put("is_pause_tip_by_express", this.my);
            jSONObject.put("reward_draw", jSONObject2);
        } catch (JSONException unused) {
        }
    }

    public static boolean u(bc bcVar) {
        wi wiVarO = o(bcVar);
        if (wiVarO == null) {
            return false;
        }
        return wiVarO.u;
    }
}
