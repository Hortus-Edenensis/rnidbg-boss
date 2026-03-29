package com.bytedance.sdk.openadsdk.a.u;

import com.bytedance.sdk.component.u.o;
import com.bytedance.sdk.openadsdk.core.ja;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx extends com.bytedance.sdk.component.u.pn<JSONObject, JSONObject> {
    private WeakReference<ja> u;

    public fx(ja jaVar) {
        this.u = new WeakReference<>(jaVar);
    }

    public static void u(o oVar, ja jaVar) {
        oVar.u("rewardPlayAgain", (com.bytedance.sdk.component.u.pn<?, ?>) new fx(jaVar));
    }

    @Override // com.bytedance.sdk.component.u.pn
    public JSONObject u(JSONObject jSONObject, com.bytedance.sdk.component.u.iz izVar) throws Exception {
        ja jaVar;
        JSONObject jSONObject2 = new JSONObject();
        WeakReference<ja> weakReference = this.u;
        if (weakReference == null || weakReference.get() == null || (jaVar = this.u.get()) == null) {
            return jSONObject2;
        }
        jaVar.bg();
        return jSONObject2;
    }
}
