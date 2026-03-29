package com.bytedance.sdk.openadsdk.core.kj;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class su {
    private int b;
    private String fx;
    private boolean iz;
    private int nr;
    private int pn;
    private int u;

    public su(JSONObject jSONObject) {
        this.iz = false;
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("reward_live");
        if (jSONObjectOptJSONObject != null) {
            this.iz = true;
            nr(jSONObjectOptJSONObject.optInt("reward_live_type", 1));
            fx(jSONObjectOptJSONObject.optInt("reward_live_style", 1));
            u(jSONObjectOptJSONObject.optString("reward_live_text"));
            u(jSONObjectOptJSONObject.optInt("reward_start_time", 5));
            b(jSONObjectOptJSONObject.optInt("reward_close_time", 10));
        }
    }

    private static su a(bc bcVar) {
        if (bcVar == null) {
            return null;
        }
        return bcVar.qj();
    }

    public static boolean b(bc bcVar) {
        int i;
        su suVarA = a(bcVar);
        return suVarA != null && suVarA.iz && com.bytedance.sdk.openadsdk.core.live.nr.u().u(bcVar) && ((i = suVarA.u) == 3 || i == 4);
    }

    public static boolean fx(bc bcVar) {
        su suVarA = a(bcVar);
        return suVarA == null || !suVarA.iz || suVarA.u == 1;
    }

    public static String iz(bc bcVar) {
        su suVarA = a(bcVar);
        return suVarA == null ? "去抖音观看直播\n可提前5s获得奖励哦" : suVarA.fx;
    }

    public static int n(bc bcVar) {
        su suVarA = a(bcVar);
        if (suVarA == null) {
            return 10;
        }
        return Math.max(suVarA.pn, 3);
    }

    public static int nr(bc bcVar) {
        su suVarA = a(bcVar);
        if (suVarA == null) {
            return 1;
        }
        return suVarA.u;
    }

    public static int pn(bc bcVar) {
        su suVarA = a(bcVar);
        if (suVarA == null) {
            return 1;
        }
        return suVarA.nr;
    }

    public static int x(bc bcVar) {
        su suVarA = a(bcVar);
        if (suVarA == null) {
            return 5;
        }
        return Math.max(suVarA.b, 0);
    }

    public void u(JSONObject jSONObject) {
        if (this.iz) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("reward_live_type", this.u);
                jSONObject2.put("reward_live_style", this.nr);
                jSONObject2.put("reward_live_text", this.fx);
                jSONObject2.put("reward_start_time", this.b);
                jSONObject2.put("reward_close_time", this.pn);
                jSONObject.put("reward_live", jSONObject2);
            } catch (JSONException unused) {
            }
        }
    }

    private void nr(int i) {
        if (i != 2 && i != 3 && i != 4 && i != 1) {
            i = 1;
        }
        this.u = i;
    }

    private void b(int i) {
        if (i <= 3) {
            i = 3;
        }
        this.pn = i;
    }

    private void fx(int i) {
        if (i != 1 && i != 2 && i != 3) {
            i = 1;
        }
        this.nr = i;
    }

    public static boolean u(bc bcVar) {
        su suVarA = a(bcVar);
        if (suVarA == null) {
            return false;
        }
        return suVarA.iz;
    }

    private void u(String str) {
        if (TextUtils.isEmpty(str)) {
            str = this.nr == 3 ? "5s后将为你自动打开抖音\n在抖音观看直播\n可提前5s获得奖励哦" : "去抖音观看直播\n可提前5s获得奖励哦";
        }
        this.fx = str;
    }

    public void u(int i) {
        this.b = i;
    }
}
