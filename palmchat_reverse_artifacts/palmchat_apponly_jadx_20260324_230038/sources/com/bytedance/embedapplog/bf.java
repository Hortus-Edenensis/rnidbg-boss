package com.bytedance.embedapplog;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class bf extends wq {
    private long nr;

    public bf(xg xgVar) {
        super(xgVar);
    }

    @Override // com.bytedance.embedapplog.wq
    public String b() {
        return "ab";
    }

    @Override // com.bytedance.embedapplog.wq
    public boolean fx() throws JSONException {
        JSONObject jSONObjectU = this.u.pn().u();
        if (this.u.pn().l() == 0 || jSONObjectU == null) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("header", this.u.pn().u());
        jSONObject.put("magic_tag", "ss_app_log");
        jSONObject.put("_gen_time", jCurrentTimeMillis);
        JSONObject jSONObjectFx = rv.fx(rv.u(ge.u(this.u.nr(), this.u.pn().u(), this.u.n().b(), true, u.b()), rv.fx), jSONObject);
        if (jSONObjectFx == null) {
            return false;
        }
        u.l().nr(!gb.u(u.iz(), jSONObjectFx), jSONObjectFx);
        if (ti.nr) {
            ti.u("getAbConfig ".concat(String.valueOf(jSONObjectFx)), null);
        }
        this.u.pn().u(jSONObjectFx);
        this.nr = jCurrentTimeMillis;
        return true;
    }

    @Override // com.bytedance.embedapplog.wq
    public long[] nr() {
        return jp.fx;
    }

    @Override // com.bytedance.embedapplog.wq
    public long u() {
        long jBg = this.u.b().bg();
        if (jBg < 600000) {
            jBg = 600000;
        }
        return this.nr + jBg;
    }
}
