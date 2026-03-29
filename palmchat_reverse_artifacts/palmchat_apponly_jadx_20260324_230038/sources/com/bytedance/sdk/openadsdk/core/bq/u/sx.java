package com.bytedance.sdk.openadsdk.core.bq.u;

import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class sx extends com.bytedance.sdk.component.u.pn<JSONObject, JSONObject> {
    private WeakReference<com.bytedance.sdk.openadsdk.core.ja> u;

    public sx(com.bytedance.sdk.openadsdk.core.ja jaVar) {
        this.u = new WeakReference<>(jaVar);
    }

    public static void u(com.bytedance.sdk.component.u.o oVar, com.bytedance.sdk.openadsdk.core.ja jaVar) {
        oVar.u("getSendRewardStatus", (com.bytedance.sdk.component.u.pn<?, ?>) new sx(jaVar));
    }

    @Override // com.bytedance.sdk.component.u.pn
    public JSONObject u(JSONObject jSONObject, com.bytedance.sdk.component.u.iz izVar) throws Exception {
        com.bytedance.sdk.openadsdk.core.ja jaVar;
        JSONObject jSONObject2 = new JSONObject();
        WeakReference<com.bytedance.sdk.openadsdk.core.ja> weakReference = this.u;
        if (weakReference != null && weakReference.get() != null && (jaVar = this.u.get()) != null) {
            jSONObject2.put("isReward", jaVar.x());
        }
        return jSONObject2;
    }
}
