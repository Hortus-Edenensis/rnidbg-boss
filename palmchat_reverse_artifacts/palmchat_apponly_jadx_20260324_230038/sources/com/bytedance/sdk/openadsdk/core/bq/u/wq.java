package com.bytedance.sdk.openadsdk.core.bq.u;

import com.bytedance.sdk.component.u.b;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class wq extends com.bytedance.sdk.component.u.b<JSONObject, JSONObject> {
    private WeakReference<com.bytedance.sdk.openadsdk.core.ja> u;

    public wq(com.bytedance.sdk.openadsdk.core.ja jaVar) {
        this.u = new WeakReference<>(jaVar);
    }

    public static void u(com.bytedance.sdk.component.u.o oVar, final com.bytedance.sdk.openadsdk.core.ja jaVar) {
        oVar.u("commonConvert", new b.nr() { // from class: com.bytedance.sdk.openadsdk.core.bq.u.wq.1
            @Override // com.bytedance.sdk.component.u.b.nr
            public com.bytedance.sdk.component.u.b u() {
                return new wq(jaVar);
            }
        });
    }

    @Override // com.bytedance.sdk.component.u.b
    public void u(JSONObject jSONObject, com.bytedance.sdk.component.u.iz izVar) throws Exception {
        com.bytedance.sdk.openadsdk.core.ugeno.jk.u uVarBf;
        JSONObject jSONObjectNr;
        com.bytedance.sdk.openadsdk.core.qq.s sVarU;
        int i;
        com.bytedance.sdk.openadsdk.core.n.o().tk();
        JSONObject jSONObject2 = new JSONObject();
        com.bytedance.sdk.openadsdk.core.kj.bc bcVarU = null;
        try {
            WeakReference<com.bytedance.sdk.openadsdk.core.ja> weakReference = this.u;
            if (weakReference == null) {
                com.bytedance.sdk.openadsdk.core.qq.s.u().u("commonConvert", "js", 1, jSONObject2);
            } else {
                com.bytedance.sdk.openadsdk.core.ja jaVar = weakReference.get();
                if (jaVar == null) {
                    fx();
                    sVarU = com.bytedance.sdk.openadsdk.core.qq.s.u();
                    i = 2;
                } else if (jSONObject == null) {
                    sVarU = com.bytedance.sdk.openadsdk.core.qq.s.u();
                    i = 3;
                } else {
                    bcVarU = com.bytedance.sdk.openadsdk.core.u.u(jSONObject);
                    int iOptInt = jSONObject.optInt("j_live_saas_param_interaction_type", -1);
                    if (bcVarU == null) {
                        sVarU = com.bytedance.sdk.openadsdk.core.qq.s.u();
                        i = 4;
                    } else {
                        bcVarU.u(true);
                        jSONObject2.putOpt("live_interaction_type", Integer.valueOf(bcVarU.gq()));
                        jSONObject2.putOpt("ext", bcVarU.ap());
                        if (bcVarU.bb() == null && (uVarBf = bcVarU.bf()) != null && (jSONObjectNr = uVarBf.nr()) != null) {
                            bcVarU.u(com.bytedance.sdk.openadsdk.core.kj.mv.u(jSONObjectNr));
                        }
                        jaVar.u(bcVarU, iOptInt);
                        try {
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("code", 200);
                            u(jSONObject3);
                            return;
                        } catch (Exception e) {
                            e.getMessage();
                            return;
                        }
                    }
                }
                sVarU.u("commonConvert", "js", i, jSONObject2);
            }
            com.bytedance.sdk.openadsdk.core.live.nr.u().b(bcVarU);
        } finally {
            com.bytedance.sdk.openadsdk.core.qq.s.u().u("commonConvert", "js", 0, jSONObject2);
            com.bytedance.sdk.openadsdk.core.live.nr.u().b(null);
        }
    }

    @Override // com.bytedance.sdk.component.u.b
    public void b() {
    }
}
