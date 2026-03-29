package com.bytedance.sdk.openadsdk.core.bq.u;

import com.bytedance.sdk.component.u.b;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class jp extends com.bytedance.sdk.component.u.b<JSONObject, JSONObject> {
    private WeakReference<com.bytedance.sdk.openadsdk.core.ja> u;

    public jp(com.bytedance.sdk.openadsdk.core.ja jaVar) {
        this.u = new WeakReference<>(jaVar);
    }

    public static void u(com.bytedance.sdk.component.u.o oVar, final com.bytedance.sdk.openadsdk.core.ja jaVar) {
        oVar.u("showAppDetailOrPrivacyDialog", new b.nr() { // from class: com.bytedance.sdk.openadsdk.core.bq.u.jp.1
            @Override // com.bytedance.sdk.component.u.b.nr
            public com.bytedance.sdk.component.u.b u() {
                return new jp(jaVar);
            }
        });
    }

    @Override // com.bytedance.sdk.component.u.b
    public void u(JSONObject jSONObject, com.bytedance.sdk.component.u.iz izVar) throws Exception {
        com.bytedance.sdk.openadsdk.core.n.o().tk();
        WeakReference<com.bytedance.sdk.openadsdk.core.ja> weakReference = this.u;
        if (weakReference == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.ja jaVar = weakReference.get();
        if (jaVar == null) {
            fx();
            return;
        }
        if (jSONObject == null) {
            return;
        }
        int iOptInt = jSONObject.optInt("show_dialog_style");
        if (iOptInt == 1) {
            jaVar.kj();
        } else if (iOptInt == 2) {
            jaVar.qq();
        }
    }

    @Override // com.bytedance.sdk.component.u.b
    public void b() {
    }
}
