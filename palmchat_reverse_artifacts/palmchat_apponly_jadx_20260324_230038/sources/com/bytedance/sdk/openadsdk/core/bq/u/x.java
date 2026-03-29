package com.bytedance.sdk.openadsdk.core.bq.u;

import com.bytedance.sdk.component.u.b;
import java.lang.ref.WeakReference;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class x extends com.bytedance.sdk.component.u.b<JSONObject, JSONObject> {
    private com.bytedance.sdk.openadsdk.core.dw.fx fx;
    private com.bytedance.sdk.openadsdk.core.kj.bc nr;
    private WeakReference<com.bytedance.sdk.openadsdk.core.ja> u;

    public x(com.bytedance.sdk.openadsdk.core.ja jaVar, com.bytedance.sdk.openadsdk.core.kj.bc bcVar) {
        this.u = new WeakReference<>(jaVar);
        this.nr = bcVar;
    }

    public static void u(com.bytedance.sdk.component.u.o oVar, final com.bytedance.sdk.openadsdk.core.ja jaVar, final com.bytedance.sdk.openadsdk.core.kj.bc bcVar) {
        oVar.u("getNetworkData", new b.nr() { // from class: com.bytedance.sdk.openadsdk.core.bq.u.x.1
            @Override // com.bytedance.sdk.component.u.b.nr
            public com.bytedance.sdk.component.u.b u() {
                return new x(jaVar, bcVar);
            }
        });
    }

    @Override // com.bytedance.sdk.component.u.b
    public void u(JSONObject jSONObject, com.bytedance.sdk.component.u.iz izVar) throws Exception {
        com.bytedance.sdk.openadsdk.core.ja jaVar = this.u.get();
        if (jaVar == null) {
            fx();
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        this.fx = new com.bytedance.sdk.openadsdk.core.dw.fx() { // from class: com.bytedance.sdk.openadsdk.core.bq.u.x.2
            @Override // com.bytedance.sdk.openadsdk.core.dw.fx
            public void u(boolean z, List<com.bytedance.sdk.openadsdk.core.kj.bc> list, boolean z2) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    if (z) {
                        jSONObject2.put("creatives", com.bytedance.sdk.openadsdk.core.ja.u(list));
                        jSONObject2.put("is_cache", z2);
                        if (z2) {
                            jSONObject2.put("prefetch_opt_time", jCurrentTimeMillis - com.bytedance.sdk.openadsdk.core.playable.nr.u().fx(x.this.nr));
                        }
                        x.this.u(jSONObject2);
                    } else {
                        x.this.u(jSONObject2);
                    }
                    com.bytedance.sdk.openadsdk.core.n.o().tk();
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.k.u("DoGetAdsFromNetwork", "onAdLoaded error", th);
                }
            }
        };
        if ((jSONObject != null && jSONObject.optBoolean("is_first_request", false)) && com.bytedance.sdk.openadsdk.core.playable.nr.u().u(this.nr, this.fx)) {
            return;
        }
        jaVar.u(jSONObject, this.fx);
    }

    @Override // com.bytedance.sdk.component.u.b
    public void b() {
    }
}
