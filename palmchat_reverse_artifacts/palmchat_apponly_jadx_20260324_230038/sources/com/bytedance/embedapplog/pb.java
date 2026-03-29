package com.bytedance.embedapplog;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class pb extends wq {
    public pb(xg xgVar) {
        super(xgVar);
    }

    @Override // com.bytedance.embedapplog.wq
    public String b() {
        return "c";
    }

    @Override // com.bytedance.embedapplog.wq
    public boolean fx() throws JSONException {
        JSONObject jSONObjectU = this.u.pn().u();
        if (this.u.pn().l() == 0 || jSONObjectU == null || this.u.b().n() + 21600000 > System.currentTimeMillis()) {
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("magic_tag", "ss_app_log");
        jSONObject.put("header", jSONObjectU);
        jSONObject.put("_gen_time", System.currentTimeMillis());
        JSONObject jSONObjectNr = rv.nr(rv.u(ge.u(this.u.nr(), this.u.pn().u(), this.u.n().fx(), true, u.b()), rv.fx), jSONObject);
        u.l().u(!gb.u(jSONObjectNr, this.u.b().x()), jSONObjectNr);
        if (jSONObjectNr == null) {
            return false;
        }
        this.u.b().u(jSONObjectNr);
        return true;
    }

    @Override // com.bytedance.embedapplog.wq
    public long[] nr() {
        return jp.fx;
    }

    @Override // com.bytedance.embedapplog.wq
    public long u() {
        return this.u.b().n() + 21600000;
    }
}
