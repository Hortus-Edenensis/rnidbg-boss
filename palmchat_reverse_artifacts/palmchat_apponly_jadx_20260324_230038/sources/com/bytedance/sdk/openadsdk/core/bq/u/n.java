package com.bytedance.sdk.openadsdk.core.bq.u;

import com.bytedance.sdk.component.u.b;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class n extends com.bytedance.sdk.component.u.b<JSONObject, JSONObject> {
    private WeakReference<com.bytedance.sdk.openadsdk.core.ja> u;

    public n(com.bytedance.sdk.openadsdk.core.ja jaVar) {
        this.u = new WeakReference<>(jaVar);
    }

    public static void u(com.bytedance.sdk.component.u.o oVar, final com.bytedance.sdk.openadsdk.core.ja jaVar) {
        oVar.u("newClickEvent", new b.nr() { // from class: com.bytedance.sdk.openadsdk.core.bq.u.n.1
            @Override // com.bytedance.sdk.component.u.b.nr
            public com.bytedance.sdk.component.u.b u() {
                return new n(jaVar);
            }
        });
    }

    @Override // com.bytedance.sdk.component.u.b
    public void u(JSONObject jSONObject, com.bytedance.sdk.component.u.iz izVar) throws Exception {
        com.bytedance.sdk.openadsdk.core.ja jaVar = this.u.get();
        if (jaVar == null) {
            fx();
        } else {
            jaVar.n(jSONObject);
        }
    }

    @Override // com.bytedance.sdk.component.u.b
    public void b() {
    }
}
