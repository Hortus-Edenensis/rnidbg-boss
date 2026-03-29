package com.bytedance.sdk.openadsdk.a.u;

import com.bytedance.sdk.component.u.b;
import com.bytedance.sdk.component.u.o;
import com.bytedance.sdk.openadsdk.core.ja;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn extends com.bytedance.sdk.component.u.b<JSONObject, JSONObject> {
    private WeakReference<ja> u;

    public pn(ja jaVar) {
        this.u = new WeakReference<>(jaVar);
    }

    public static void u(o oVar, final ja jaVar) {
        oVar.u("openPrivacy", new b.nr() { // from class: com.bytedance.sdk.openadsdk.a.u.pn.1
            @Override // com.bytedance.sdk.component.u.b.nr
            public com.bytedance.sdk.component.u.b u() {
                return new pn(jaVar);
            }
        });
    }

    @Override // com.bytedance.sdk.component.u.b
    public void u(JSONObject jSONObject, com.bytedance.sdk.component.u.iz izVar) throws Exception {
        ja jaVar;
        bc bcVarN;
        WeakReference<ja> weakReference = this.u;
        if (weakReference == null || (jaVar = weakReference.get()) == null || (bcVarN = jaVar.n()) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.y.iz.u(izVar.getContext(), bcVarN);
        jaVar.pb();
    }

    @Override // com.bytedance.sdk.component.u.b
    public void b() {
    }
}
