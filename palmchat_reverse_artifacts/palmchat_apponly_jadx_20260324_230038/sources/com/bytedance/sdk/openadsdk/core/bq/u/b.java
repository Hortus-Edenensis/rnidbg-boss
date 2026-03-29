package com.bytedance.sdk.openadsdk.core.bq.u;

import androidx.annotation.Nullable;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b extends com.bytedance.sdk.component.u.pn<JSONObject, JSONObject> {
    private com.bytedance.sdk.openadsdk.core.ja u;

    public b(com.bytedance.sdk.openadsdk.core.ja jaVar) {
        this.u = jaVar;
    }

    public static void u(com.bytedance.sdk.component.u.o oVar, com.bytedance.sdk.openadsdk.core.ja jaVar) {
        oVar.u("businessStatusNotify", (com.bytedance.sdk.component.u.pn<?, ?>) new b(jaVar));
    }

    @Override // com.bytedance.sdk.component.u.pn
    @Nullable
    public JSONObject u(JSONObject jSONObject, com.bytedance.sdk.component.u.iz izVar) throws Exception {
        com.bytedance.sdk.openadsdk.core.ja jaVar;
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject != null && (jaVar = this.u) != null) {
            jaVar.xg();
        }
        return jSONObject2;
    }
}
