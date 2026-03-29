package com.bytedance.sdk.openadsdk.core.bq.u;

import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class mv extends com.bytedance.sdk.component.u.pn<JSONObject, JSONObject> {
    private JSONObject u;

    public mv(JSONObject jSONObject) {
        this.u = jSONObject;
    }

    public static void u(com.bytedance.sdk.component.u.o oVar, JSONObject jSONObject) {
        oVar.u("getData", (com.bytedance.sdk.component.u.pn<?, ?>) new mv(jSONObject));
    }

    @Override // com.bytedance.sdk.component.u.pn
    public JSONObject u(JSONObject jSONObject, com.bytedance.sdk.component.u.iz izVar) throws Exception {
        return com.bytedance.sdk.openadsdk.core.nativeexpress.nr.nr.u(this.u, jSONObject);
    }
}
