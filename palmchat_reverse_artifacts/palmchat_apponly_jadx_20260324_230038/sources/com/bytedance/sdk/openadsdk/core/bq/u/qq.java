package com.bytedance.sdk.openadsdk.core.bq.u;

import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class qq extends com.bytedance.sdk.component.u.pn<JSONObject, JSONObject> {
    private com.bytedance.sdk.openadsdk.core.kj.bc fx;
    private com.bytedance.sdk.openadsdk.core.ja nr;
    private String u;

    public qq(String str, com.bytedance.sdk.openadsdk.core.ja jaVar, com.bytedance.sdk.openadsdk.core.kj.bc bcVar) {
        this.u = str;
        this.nr = jaVar;
        this.fx = bcVar;
    }

    public static void u(com.bytedance.sdk.component.u.o oVar, com.bytedance.sdk.openadsdk.core.ja jaVar, com.bytedance.sdk.openadsdk.core.kj.bc bcVar) {
        oVar.u("openNewAdPage", (com.bytedance.sdk.component.u.pn<?, ?>) new qq("openNewAdPage", jaVar, bcVar));
    }

    @Override // com.bytedance.sdk.component.u.pn
    public JSONObject u(JSONObject jSONObject, com.bytedance.sdk.component.u.iz izVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        String str = this.u;
        str.hashCode();
        if (str.equals("openNewAdPage")) {
            if (this.nr != null) {
                int iOptInt = jSONObject.optInt("second_page_type", 0);
                this.nr.pn(iOptInt);
                jSONObject2.put("code", 0);
                com.bytedance.sdk.openadsdk.core.component.reward.business.fx.b.u(this.fx, true, iOptInt);
            } else {
                jSONObject2.put("code", 1);
                jSONObject2.put("msg", "jsObject is null");
                com.bytedance.sdk.openadsdk.core.component.reward.business.fx.b.u(this.fx, false, 0);
            }
        }
        return jSONObject2;
    }
}
