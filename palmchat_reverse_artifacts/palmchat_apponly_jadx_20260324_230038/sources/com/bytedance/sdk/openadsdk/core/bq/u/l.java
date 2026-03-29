package com.bytedance.sdk.openadsdk.core.bq.u;

import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class l extends com.bytedance.sdk.component.u.pn<JSONObject, JSONObject> {
    private WeakReference<com.bytedance.sdk.openadsdk.core.ja> u;

    public l(com.bytedance.sdk.openadsdk.core.ja jaVar) {
        this.u = new WeakReference<>(jaVar);
    }

    public JSONObject fx() {
        com.bytedance.sdk.openadsdk.core.ja jaVar;
        JSONObject jSONObject = new JSONObject();
        try {
            WeakReference<com.bytedance.sdk.openadsdk.core.ja> weakReference = this.u;
            return (weakReference == null || (jaVar = weakReference.get()) == null) ? jSONObject : jaVar.z();
        } catch (Throwable unused) {
            return jSONObject;
        }
    }

    public static void u(com.bytedance.sdk.component.u.o oVar, com.bytedance.sdk.openadsdk.core.ja jaVar) {
        oVar.u("getAppManage", (com.bytedance.sdk.component.u.pn<?, ?>) new l(jaVar));
    }

    @Override // com.bytedance.sdk.component.u.pn
    public JSONObject u(JSONObject jSONObject, com.bytedance.sdk.component.u.iz izVar) throws Exception {
        return fx();
    }
}
