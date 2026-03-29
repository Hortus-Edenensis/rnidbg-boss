package com.bytedance.sdk.openadsdk.core.kj;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class ay {
    private int b;
    private int fx;
    private boolean nr;
    private boolean u;

    public ay(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("window_landing");
        if (jSONObjectOptJSONObject == null) {
            return;
        }
        this.u = jSONObjectOptJSONObject.optBoolean("can_jump_to_landing", false);
        this.nr = jSONObjectOptJSONObject.optBoolean("can_click_to_landing", false);
        this.fx = jSONObjectOptJSONObject.optInt("auto_to_landing_type", 0);
        this.b = jSONObjectOptJSONObject.optInt("auto_to_landing_time", 0);
    }

    public static int b(bc bcVar) {
        ay ayVarC = yd.c(bcVar);
        if (ayVarC == null) {
            return 0;
        }
        return ayVarC.b;
    }

    public static int fx(bc bcVar) {
        ay ayVarC = yd.c(bcVar);
        if (ayVarC == null) {
            return 0;
        }
        return ayVarC.fx;
    }

    public static boolean nr(bc bcVar) {
        ay ayVarC = yd.c(bcVar);
        if (ayVarC == null) {
            return false;
        }
        return ayVarC.nr;
    }

    public static String pn(bc bcVar) {
        return bcVar == null ? "" : bcVar.jf();
    }

    public void u(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("can_jump_to_landing", this.u);
            jSONObject2.put("can_click_to_landing", this.nr);
            jSONObject2.put("auto_to_landing_type", this.fx);
            jSONObject2.put("auto_to_landing_time", this.b);
            jSONObject.put("window_landing", jSONObject2);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.k.u("parse json:" + e.getMessage());
        }
    }

    public static boolean u(bc bcVar) {
        ay ayVarC = yd.c(bcVar);
        if (ayVarC == null || !ayVarC.u || tk.u(bcVar) == 1) {
            return false;
        }
        if (tk.u(bcVar) == 2 && tk.nr(bcVar) == 3) {
            return false;
        }
        if (tk.u(bcVar) == 2 && tk.nr(bcVar) == 7) {
            return false;
        }
        return (bcVar.ol() == 5 || bcVar.ol() == 15) && !TextUtils.isEmpty(pn(bcVar));
    }
}
