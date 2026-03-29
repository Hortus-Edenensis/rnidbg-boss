package com.bytedance.embedapplog;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class jp extends wq {
    private boolean pn;
    static final long[] nr = {920000};
    static final long[] fx = {920000};
    private static final long[] b = {10000, 10000, 20000, 20000, 60000, 6000, 180000, 180000, 540000, 540000};

    public jp(xg xgVar) {
        super(xgVar);
        this.pn = true;
    }

    @Override // com.bytedance.embedapplog.wq
    public String b() {
        return com.kuaishou.weapon.p0.t.k;
    }

    @Override // com.bytedance.embedapplog.wq
    public boolean fx() throws JSONException {
        JSONObject jSONObjectU;
        JSONObject jSONObject = new JSONObject();
        yd ydVarPn = this.u.pn();
        JSONObject jSONObjectU2 = ydVarPn.u();
        if (jSONObjectU2 != null) {
            jSONObject.put("magic_tag", "ss_app_log");
            synchronized (ydVarPn) {
                jSONObjectU = gb.u(jSONObjectU2);
            }
            jSONObject.put("header", jSONObjectU);
            jSONObject.put("_gen_time", System.currentTimeMillis());
            if (!TextUtils.isEmpty(jSONObjectU.optString("device_id")) && gb.b() && this.pn) {
                this.pn = false;
                return false;
            }
            JSONObject jSONObjectU3 = this.u.pn().u();
            JSONObject jSONObjectU4 = rv.u(ge.u(this.u.nr(), jSONObjectU3, this.u.n().u(), true, u.b()), jSONObject);
            if (jSONObjectU4 != null) {
                String strOptString = jSONObjectU4.optString("device_id", "");
                boolean zU = this.u.pn().u(jSONObjectU4, strOptString, jSONObjectU4.optString("install_id", ""), jSONObjectU4.optString("ssid", ""));
                bg.nr("__kite", "start:" + gb.iz());
                try {
                    if (gb.iz()) {
                        new d(this.u.nr()).u(jSONObjectU3, strOptString);
                    }
                } catch (Throwable th) {
                    bg.u("__kite", "error:" + gb.iz(), th);
                }
                return zU;
            }
        } else {
            ti.nr((Throwable) null);
        }
        return false;
    }

    @Override // com.bytedance.embedapplog.wq
    public long[] nr() {
        int iL = this.u.pn().l();
        if (iL == 0) {
            return b;
        }
        if (iL == 1) {
            return fx;
        }
        if (iL == 2) {
            return nr;
        }
        ti.nr((Throwable) null);
        return fx;
    }

    @Override // com.bytedance.embedapplog.wq
    public long u() {
        return this.u.pn().mv() + ((long) (this.u.x().fx() ? 21600000 : 43200000));
    }
}
