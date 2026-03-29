package com.bytedance.sdk.openadsdk.core.bq.u;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class y extends com.bytedance.sdk.component.u.pn<JSONObject, JSONObject> {
    private com.bytedance.sdk.openadsdk.core.ja u;

    public y(com.bytedance.sdk.openadsdk.core.ja jaVar) {
        this.u = jaVar;
    }

    public JSONObject fx() {
        JSONObject jSONObject = new JSONObject();
        com.bytedance.sdk.openadsdk.core.ja jaVar = this.u;
        if (jaVar != null) {
            return jaVar.l();
        }
        try {
            jSONObject.put("code", -1);
            jSONObject.put("codeMsg", "JsObject is null");
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static void u(com.bytedance.sdk.component.u.o oVar, com.bytedance.sdk.openadsdk.core.ja jaVar) {
        oVar.u("ShowUgenDownloadDialog", (com.bytedance.sdk.component.u.pn<?, ?>) new y(jaVar));
    }

    @Override // com.bytedance.sdk.component.u.pn
    public JSONObject u(JSONObject jSONObject, com.bytedance.sdk.component.u.iz izVar) throws Exception {
        return fx();
    }
}
