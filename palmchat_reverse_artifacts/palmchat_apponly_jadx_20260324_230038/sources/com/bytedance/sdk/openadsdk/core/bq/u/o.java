package com.bytedance.sdk.openadsdk.core.bq.u;

import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class o extends com.bytedance.sdk.component.u.pn<JSONObject, JSONObject> {
    private WeakReference<com.bytedance.sdk.openadsdk.core.ja> u;

    public o(com.bytedance.sdk.openadsdk.core.ja jaVar) {
        this.u = new WeakReference<>(jaVar);
    }

    public static void u(com.bytedance.sdk.component.u.o oVar, com.bytedance.sdk.openadsdk.core.ja jaVar) {
        oVar.u("getPlayTimeCurrent", (com.bytedance.sdk.component.u.pn<?, ?>) new o(jaVar));
    }

    @Override // com.bytedance.sdk.component.u.pn
    public JSONObject u(JSONObject jSONObject, com.bytedance.sdk.component.u.iz izVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        WeakReference<com.bytedance.sdk.openadsdk.core.ja> weakReference = this.u;
        if (weakReference != null && weakReference.get() != null) {
            com.bytedance.sdk.openadsdk.core.ja jaVar = this.u.get();
            jSONObject2.put("currentTime", jaVar != null ? jaVar.bf() : 0);
        }
        return jSONObject2;
    }
}
