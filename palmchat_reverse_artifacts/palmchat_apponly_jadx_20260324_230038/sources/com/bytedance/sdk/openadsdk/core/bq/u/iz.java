package com.bytedance.sdk.openadsdk.core.bq.u;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz extends com.bytedance.sdk.component.u.pn<JSONObject, JSONObject> {
    private WeakReference<com.bytedance.sdk.openadsdk.core.ja> u;

    public iz(com.bytedance.sdk.openadsdk.core.ja jaVar) {
        this.u = new WeakReference<>(jaVar);
    }

    public static void u(com.bytedance.sdk.component.u.o oVar, com.bytedance.sdk.openadsdk.core.ja jaVar) {
        oVar.u("changePlaySpeedRatio", (com.bytedance.sdk.component.u.pn<?, ?>) new iz(jaVar));
    }

    @Override // com.bytedance.sdk.component.u.pn
    @Nullable
    public JSONObject u(@NonNull JSONObject jSONObject, @NonNull com.bytedance.sdk.component.u.iz izVar) throws Exception {
        WeakReference<com.bytedance.sdk.openadsdk.core.ja> weakReference = this.u;
        if (weakReference != null && weakReference.get() != null) {
            float fOptDouble = (float) jSONObject.optDouble("ratio");
            if (fOptDouble > 0.0f && fOptDouble <= 3.0f) {
                this.u.get().u(fOptDouble);
            }
            return new JSONObject();
        }
        return new JSONObject();
    }
}
