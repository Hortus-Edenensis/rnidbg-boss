package com.bytedance.sdk.openadsdk.core.bq.u;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class bf extends com.bytedance.sdk.component.u.pn<JSONObject, JSONObject> {
    private WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.n.nr> nr;
    private com.bytedance.sdk.openadsdk.core.ja u;

    public bf(com.bytedance.sdk.openadsdk.core.ja jaVar, WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.n.nr> weakReference) {
        this.u = jaVar;
        this.nr = weakReference;
    }

    public static void u(com.bytedance.sdk.component.u.o oVar, com.bytedance.sdk.openadsdk.core.ja jaVar, WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.n.nr> weakReference) {
        oVar.u("resumeRewardCountDown", (com.bytedance.sdk.component.u.pn<?, ?>) new bf(jaVar, weakReference));
    }

    @Override // com.bytedance.sdk.component.u.pn
    @Nullable
    public JSONObject u(@NonNull JSONObject jSONObject, @NonNull com.bytedance.sdk.component.u.iz izVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.n.nr> weakReference = this.nr;
        if (weakReference != null && weakReference.get() != null) {
            this.nr.get().nr();
            jSONObject2.put("success", true);
        } else {
            jSONObject2.put("success", false);
        }
        return jSONObject2;
    }
}
