package com.bytedance.sdk.openadsdk.core.bq.u;

import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class bq extends com.bytedance.sdk.component.u.pn<JSONObject, JSONObject> {
    private com.bytedance.sdk.openadsdk.core.kj.bc b;
    private Context fx;
    private com.bytedance.sdk.openadsdk.core.ja nr;
    private String u;

    public bq(String str, com.bytedance.sdk.openadsdk.core.ja jaVar, Context context, com.bytedance.sdk.openadsdk.core.kj.bc bcVar) {
        this.u = str;
        this.nr = jaVar;
        this.fx = context;
        this.b = bcVar;
    }

    public static void u(com.bytedance.sdk.component.u.o oVar, com.bytedance.sdk.openadsdk.core.ja jaVar, Context context, com.bytedance.sdk.openadsdk.core.kj.bc bcVar) {
        oVar.u("supportHaptic", (com.bytedance.sdk.component.u.pn<?, ?>) new bq("supportHaptic", jaVar, context, bcVar));
        oVar.u("playHaptic", (com.bytedance.sdk.component.u.pn<?, ?>) new bq("playHaptic", jaVar, context, bcVar));
        oVar.u("stopHaptic", (com.bytedance.sdk.component.u.pn<?, ?>) new bq("stopHaptic", jaVar, context, bcVar));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.bytedance.sdk.component.u.pn
    public JSONObject u(JSONObject jSONObject, com.bytedance.sdk.component.u.iz izVar) throws Exception {
        JSONObject jSONObject2;
        jSONObject2 = new JSONObject();
        String str = this.u;
        str.hashCode();
        switch (str) {
            case "stopHaptic":
                Context context = this.fx;
                if (context != null) {
                    com.bytedance.sdk.openadsdk.core.ugeno.component.interact.u.fx.nr(context);
                }
                return jSONObject2;
            case "supportHaptic":
                Context context2 = this.fx;
                jSONObject2.put("supportHaptic", context2 != null ? com.bytedance.sdk.openadsdk.core.ugeno.component.interact.u.fx.u(context2) : false);
                return jSONObject2;
            case "playHaptic":
                com.bytedance.sdk.openadsdk.core.ugeno.component.interact.u.fx.u(jSONObject, this.fx, this.b);
                return jSONObject2;
            default:
                return jSONObject2;
        }
    }
}
