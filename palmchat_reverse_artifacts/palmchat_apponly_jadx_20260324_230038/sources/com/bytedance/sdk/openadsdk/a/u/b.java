package com.bytedance.sdk.openadsdk.a.u;

import com.bytedance.sdk.component.u.b;
import com.bytedance.sdk.component.u.o;
import com.bytedance.sdk.openadsdk.core.ja;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.n;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b extends com.bytedance.sdk.component.u.b<JSONObject, JSONObject> {
    private WeakReference<ja> u;

    public b(ja jaVar) {
        this.u = new WeakReference<>(jaVar);
    }

    public static void u(o oVar, final ja jaVar) {
        oVar.u("adInfoDialog", new b.nr() { // from class: com.bytedance.sdk.openadsdk.a.u.b.1
            @Override // com.bytedance.sdk.component.u.b.nr
            public com.bytedance.sdk.component.u.b u() {
                return new b(jaVar);
            }
        });
    }

    @Override // com.bytedance.sdk.component.u.b
    public void u(JSONObject jSONObject, com.bytedance.sdk.component.u.iz izVar) throws Exception {
        bc bcVarN;
        n.o().tk();
        ja jaVar = this.u.get();
        if (jaVar == null || (bcVarN = jaVar.n()) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.y.iz.u(izVar.getContext(), bcVarN.yf());
    }

    @Override // com.bytedance.sdk.component.u.b
    public void b() {
    }
}
