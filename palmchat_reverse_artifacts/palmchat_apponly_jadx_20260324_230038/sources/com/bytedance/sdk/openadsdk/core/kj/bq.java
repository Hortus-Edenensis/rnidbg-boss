package com.bytedance.sdk.openadsdk.core.kj;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class bq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5306a;
    private int b;
    private int bg;
    private String bq;
    private String dw;
    private int fx;
    private int iz;
    private int jk;
    private int k;
    private int l;
    private int mv;
    private int my;
    private int n;
    private int nr;
    private int o;
    private int pn;
    private int s;
    private int sx;
    private int t;
    private int u;
    private int x;

    public bq(JSONObject jSONObject) {
        this.u = 0;
        this.nr = 1;
        this.fx = 1;
        this.b = 1;
        this.pn = 1;
        this.iz = 1;
        this.x = 0;
        this.n = 0;
        this.f5306a = 0;
        this.jk = 300;
        this.t = -1;
        this.l = 1;
        this.mv = 1;
        this.s = 31457280;
        this.k = 0;
        this.my = 0;
        this.o = 0;
        this.sx = 0;
        this.bg = 0;
        if (jSONObject == null) {
            return;
        }
        this.iz = jSONObject.optInt("auto_open", 1);
        this.x = jSONObject.optInt("download_mode", 0);
        this.n = jSONObject.optInt("auto_control", 0);
        this.f5306a = jSONObject.optInt("auto_control_choose", 0);
        this.jk = jSONObject.optInt("auto_control_time", 300);
        this.t = jSONObject.optInt("download_type", -1);
        this.l = jSONObject.optInt("if_suspend_download", 1);
        this.u = jSONObject.optInt("if_send_click", 0);
        this.nr = jSONObject.optInt("dl_popup", 1);
        this.fx = jSONObject.optInt("market_popup", 1);
        this.b = jSONObject.optInt("if_pop_lp", 1);
        this.pn = jSONObject.optInt("pop_up_style_id", 1);
        this.mv = jSONObject.optInt("dl_network", 1);
        this.s = jSONObject.optInt("dl_size", 31457280);
        this.k = jSONObject.optInt("if_toast_market", 0);
        this.my = jSONObject.optInt("enable_download_opt", 0);
        if (com.bytedance.sdk.openadsdk.core.multipro.nr.fx()) {
            this.o = 0;
        } else {
            this.o = jSONObject.optInt("dl_suspend_popup", 0);
        }
        this.sx = jSONObject.optInt("is_use_obm_convert", 0);
        this.bg = jSONObject.optInt("enable_notification", 0);
        this.bq = jSONObject.optString("ugen_url");
        String strOptString = jSONObject.optString("ugen_md5");
        this.dw = strOptString;
        com.bytedance.sdk.openadsdk.core.ugeno.jk.u(this.bq, strOptString, (com.bytedance.sdk.openadsdk.core.ugeno.fx) null);
    }

    public static int a(bc bcVar) {
        bq bqVarC = c(bcVar);
        if (bqVarC == null) {
            return 300;
        }
        return bqVarC.jk;
    }

    public static int b(bc bcVar) {
        bq bqVarC = c(bcVar);
        if (bqVarC == null) {
            return 1;
        }
        return bqVarC.iz;
    }

    public static int bg(bc bcVar) {
        bq bqVarC = c(bcVar);
        if (bqVarC == null) {
            return 0;
        }
        return bqVarC.o;
    }

    public static String bq(bc bcVar) {
        bq bqVarC = c(bcVar);
        return bqVarC == null ? "" : bqVarC.bq;
    }

    private static bq c(bc bcVar) {
        if (bcVar == null) {
            return null;
        }
        return bcVar.wj();
    }

    public static String dw(bc bcVar) {
        bq bqVarC = c(bcVar);
        return bqVarC == null ? "" : bqVarC.dw;
    }

    public static String fx(bc bcVar) {
        bq bqVarC = c(bcVar);
        if (bqVarC == null) {
            return "close_obm";
        }
        int iB = bqVarC.b();
        String strKd = bcVar.kd();
        if (iB == 1 && strKd != null) {
            return "open";
        }
        return "close_" + iB + "_" + strKd;
    }

    public static int iz(bc bcVar) {
        bq bqVarC = c(bcVar);
        if (bqVarC == null) {
            return -1;
        }
        return bqVarC.t;
    }

    public static boolean jk(bc bcVar) {
        bq bqVarC = c(bcVar);
        return bqVarC != null && bqVarC.l == 1;
    }

    public static int k(bc bcVar) {
        bq bqVarC = c(bcVar);
        if (bqVarC == null) {
            return 1;
        }
        return bqVarC.mv;
    }

    public static int l(bc bcVar) {
        bq bqVarC = c(bcVar);
        if (bqVarC == null) {
            return 1;
        }
        return bqVarC.nr;
    }

    public static int mv(bc bcVar) {
        bq bqVarC = c(bcVar);
        if (bqVarC == null) {
            return 1;
        }
        return bqVarC.fx;
    }

    public static int my(bc bcVar) {
        bq bqVarC = c(bcVar);
        if (bqVarC == null) {
            return 31457280;
        }
        return bqVarC.s * 1048576;
    }

    public static boolean n(bc bcVar) {
        bq bqVarC = c(bcVar);
        return bqVarC != null && bqVarC.f5306a == 1;
    }

    public static int nr(bc bcVar) {
        bq bqVarC = c(bcVar);
        if (bqVarC == null) {
            return 0;
        }
        return bqVarC.b();
    }

    public static boolean o(bc bcVar) {
        bq bqVarC = c(bcVar);
        return bqVarC != null && bqVarC.k == 1;
    }

    public static int pn(bc bcVar) {
        bq bqVarC = c(bcVar);
        if (bqVarC == null) {
            return 0;
        }
        return bqVarC.x;
    }

    public static int s(bc bcVar) {
        bq bqVarC = c(bcVar);
        if (bqVarC == null) {
            return 1;
        }
        return bqVarC.b;
    }

    public static int sx(bc bcVar) {
        bq bqVarC = c(bcVar);
        if (bqVarC == null) {
            return 1;
        }
        return bqVarC.pn;
    }

    public static int t(bc bcVar) {
        bq bqVarC = c(bcVar);
        if (bqVarC == null) {
            return 0;
        }
        return bqVarC.u;
    }

    public static boolean u(bc bcVar) {
        bq bqVarC = c(bcVar);
        return bqVarC != null && bqVarC.my == 1;
    }

    public static boolean x(bc bcVar) {
        bq bqVarC = c(bcVar);
        return bqVarC != null && bqVarC.n == 1;
    }

    public int b() {
        return this.sx;
    }

    public int nr() {
        return this.x;
    }

    public int pn() {
        return this.o;
    }

    public int u() {
        return this.nr;
    }

    public void u(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("auto_open", this.iz);
            jSONObject2.put("download_mode", this.x);
            jSONObject2.put("download_type", this.t);
            jSONObject2.put("auto_control", this.n);
            jSONObject2.put("auto_control_choose", this.f5306a);
            jSONObject2.put("auto_control_time", this.jk);
            jSONObject2.put("if_suspend_download", this.l);
            jSONObject2.put("if_send_click", this.u);
            jSONObject2.put("dl_popup", this.nr);
            jSONObject2.put("market_popup", this.fx);
            jSONObject2.put("if_pop_lp", this.b);
            jSONObject2.put("pop_up_style_id", this.pn);
            jSONObject2.put("dl_network", this.mv);
            jSONObject2.put("dl_size", this.s);
            jSONObject2.put("if_toast_market", this.k);
            jSONObject2.put("enable_download_opt", this.my);
            jSONObject2.put("dl_suspend_popup", this.o);
            jSONObject2.put("is_use_obm_convert", this.sx);
            jSONObject2.put("ugen_url", this.bq);
            jSONObject2.put("ugen_md5", this.dw);
            jSONObject2.put("enable_notification", this.bg);
            jSONObject.put("download_conf", jSONObject2);
        } catch (JSONException unused) {
        }
    }

    public boolean fx() {
        return this.l == 1;
    }
}
