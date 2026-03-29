package com.bytedance.sdk.openadsdk.core.bq.u;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.component.u.b;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class ja extends com.bytedance.sdk.component.u.b<JSONObject, JSONObject> {
    private long b;
    private com.bytedance.sdk.openadsdk.core.dw.pn fx;
    private com.bytedance.sdk.openadsdk.core.kj.bc nr;
    private WeakReference<com.bytedance.sdk.openadsdk.core.ja> u;

    public ja(com.bytedance.sdk.openadsdk.core.ja jaVar, com.bytedance.sdk.openadsdk.core.kj.bc bcVar) {
        this.u = new WeakReference<>(jaVar);
        this.nr = bcVar;
    }

    public static void u(com.bytedance.sdk.component.u.o oVar, final com.bytedance.sdk.openadsdk.core.ja jaVar, final com.bytedance.sdk.openadsdk.core.kj.bc bcVar) {
        oVar.u("requestVideoDelayCallback", new b.nr() { // from class: com.bytedance.sdk.openadsdk.core.bq.u.ja.1
            @Override // com.bytedance.sdk.component.u.b.nr
            public com.bytedance.sdk.component.u.b u() {
                return new ja(jaVar, bcVar);
            }
        });
    }

    @Override // com.bytedance.sdk.component.u.b
    public void u(JSONObject jSONObject, com.bytedance.sdk.component.u.iz izVar) throws Exception {
        com.bytedance.sdk.openadsdk.core.ja jaVar = this.u.get();
        if (jaVar != null && jSONObject != null) {
            this.fx = new com.bytedance.sdk.openadsdk.core.dw.pn() { // from class: com.bytedance.sdk.openadsdk.core.bq.u.ja.2
                @Override // com.bytedance.sdk.openadsdk.core.dw.pn
                public void u() {
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.bq.u.ja.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                ja.this.u(new JSONObject());
                            } catch (Exception e) {
                                com.bytedance.sdk.component.utils.k.nr("requestVideoDelay", e.getMessage());
                            }
                        }
                    }, ja.this.b);
                }
            };
            int iOptInt = jSONObject.optInt("delay", -1);
            if (iOptInt < 0) {
                return;
            }
            this.b = iOptInt;
            if (jaVar.fx() != null && jaVar.fx().G_()) {
                this.fx.u();
                return;
            } else {
                jaVar.u(this.fx);
                return;
            }
        }
        fx();
    }

    @Override // com.bytedance.sdk.component.u.b
    public void b() {
    }
}
