package com.bytedance.sdk.openadsdk.core.kj;

import android.text.TextUtils;
import com.wifi.ad.core.p001const.WifiNestConst;
import java.util.Calendar;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nb {
    private String b;
    private int fx;
    private boolean iz;
    private int nr;
    private String pn;
    private boolean u;
    private int x;

    public nb(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("splash_card")) == null) {
            return;
        }
        this.iz = true;
        this.u = jSONObjectOptJSONObject.optBoolean("click_on_close", false);
        this.nr = jSONObjectOptJSONObject.optInt("card_stay_count_down", 5);
        this.fx = jSONObjectOptJSONObject.optInt("card_click_area", 2);
        this.pn = jSONObjectOptJSONObject.optString("card_text", "详情页或第三方应用");
        int iOptInt = jSONObjectOptJSONObject.optInt("splash_card_style_id", 0);
        this.x = iOptInt;
        if (iOptInt == 1) {
            this.b = jSONObjectOptJSONObject.optString("card_top_text", "摇一摇或点击了解更多");
        } else {
            this.b = jSONObjectOptJSONObject.optString("card_top_text", "点击跳转");
        }
    }

    public static boolean a(bc bcVar) {
        if (bcVar == null || bcVar.dd() == null || !bcVar.dd().pn() || bcVar.zu() == null || bcVar.zu().isEmpty() || !bcVar.zu().get(0).pn() || TextUtils.isEmpty(bcVar.wf())) {
            return false;
        }
        if (TextUtils.isEmpty(bcVar.j())) {
            return (bcVar.pu() == null || TextUtils.isEmpty(bcVar.pu().fx())) ? false : true;
        }
        return true;
    }

    public static String b(bc bcVar) {
        nb nbVarJk = jk(bcVar);
        return nbVarJk == null ? "点击跳转" : pn(bcVar) == 1 ? TextUtils.isEmpty(nbVarJk.b) ? "摇一摇或点击了解更多" : nbVarJk.b : TextUtils.isEmpty(nbVarJk.b) ? "点击跳转" : nbVarJk.b;
    }

    public static String fx(bc bcVar) {
        nb nbVarJk = jk(bcVar);
        return (nbVarJk == null || TextUtils.isEmpty(nbVarJk.pn)) ? "详情页或第三方应用" : nbVarJk.pn;
    }

    public static int iz(bc bcVar) {
        int i;
        nb nbVarJk = jk(bcVar);
        if (nbVarJk != null && (i = nbVarJk.nr) > 0 && i <= 5) {
            return i;
        }
        return 5;
    }

    private static nb jk(bc bcVar) {
        if (bcVar == null) {
            return null;
        }
        return bcVar.gc();
    }

    public static boolean n(bc bcVar) {
        nb nbVarJk = jk(bcVar);
        if (nbVarJk == null) {
            return true;
        }
        return nbVarJk.u;
    }

    public static void nr(bc bcVar) {
        nb nbVarJk = jk(bcVar);
        if (nbVarJk == null || bcVar.jc() || bcVar.sv() == 2 || !nbVarJk.iz || nr() >= com.bytedance.sdk.openadsdk.core.dw.nr().bv()) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.s.b.fx(bcVar, WifiNestConst.NestTypeConst.NEST_SPLASH_AD, "if_splash_card");
        if (a(bcVar)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.s.b.fx(bcVar, WifiNestConst.NestTypeConst.NEST_SPLASH_AD, "card_show_fail");
    }

    public static int pn(bc bcVar) {
        nb nbVarJk = jk(bcVar);
        if (nbVarJk == null) {
            return 0;
        }
        return nbVarJk.x;
    }

    public static boolean x(bc bcVar) {
        nb nbVarJk = jk(bcVar);
        return nbVarJk == null || nbVarJk.fx == 1;
    }

    public void u(JSONObject jSONObject) {
        try {
            if (this.iz) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("click_on_close", this.u);
                jSONObject2.put("card_stay_count_down", this.nr);
                jSONObject2.put("card_click_area", this.fx);
                jSONObject2.put("card_text", this.pn);
                jSONObject2.put("card_top_text", this.b);
                jSONObject2.put("splash_card_style_id", this.x);
                jSONObject.put("splash_card", jSONObject2);
            }
        } catch (JSONException unused) {
        }
    }

    public static int nr() {
        int i = Calendar.getInstance().get(7);
        com.bytedance.sdk.component.b.nr.fx fxVarU = com.bytedance.sdk.openadsdk.core.y.bf.u(null);
        int i2 = fxVarU.get("splash_card_show_day", -1);
        int i3 = fxVarU.get("splash_card_show_count", 0);
        if (i2 == i) {
            return i3;
        }
        return 0;
    }

    public static boolean u(bc bcVar) {
        nb nbVarJk = jk(bcVar);
        if (nbVarJk != null && !bcVar.jc() && bcVar.sv() != 2 && nbVarJk.iz && nr() < com.bytedance.sdk.openadsdk.core.dw.nr().bv() && a(bcVar)) {
            return nbVarJk.iz;
        }
        return false;
    }

    public static void u() {
        int i = Calendar.getInstance().get(7);
        com.bytedance.sdk.component.b.nr.fx fxVarU = com.bytedance.sdk.openadsdk.core.y.bf.u(null);
        int i2 = fxVarU.get("splash_card_show_day", -1) == i ? fxVarU.get("splash_card_show_count", 0) : 0;
        fxVarU.put("splash_card_show_day", i);
        fxVarU.put("splash_card_show_count", i2 + 1);
    }
}
