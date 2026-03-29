package com.bytedance.sdk.openadsdk.core.bq.u;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class a extends com.bytedance.sdk.component.u.pn<JSONObject, JSONObject> {
    private String fx;
    private com.bytedance.sdk.openadsdk.core.ja nr;
    private com.bytedance.sdk.openadsdk.core.kj.bc u;

    public a(com.bytedance.sdk.openadsdk.core.kj.bc bcVar, com.bytedance.sdk.openadsdk.core.ja jaVar, String str) {
        this.u = bcVar;
        this.nr = jaVar;
        this.fx = str;
    }

    public static void u(com.bytedance.sdk.component.u.o oVar, com.bytedance.sdk.openadsdk.core.kj.bc bcVar, com.bytedance.sdk.openadsdk.core.ja jaVar) {
        oVar.u("getEstimatedInteractionAreaInfo", (com.bytedance.sdk.component.u.pn<?, ?>) new a(bcVar, jaVar, "getEstimatedInteractionAreaInfo"));
        oVar.u("interactionAreaInfo", (com.bytedance.sdk.component.u.pn<?, ?>) new a(bcVar, jaVar, "interactionAreaInfo"));
    }

    @Override // com.bytedance.sdk.component.u.pn
    @Nullable
    public JSONObject u(@NonNull JSONObject jSONObject, @NonNull com.bytedance.sdk.component.u.iz izVar) throws Exception {
        com.bytedance.sdk.openadsdk.core.kj.k kVarU;
        com.bytedance.sdk.openadsdk.core.kj.k kVarU2;
        JSONObject jSONObject2;
        com.bytedance.sdk.openadsdk.core.ugeno.component.interact.n nVarFx = this.nr.fx();
        String str = this.fx;
        str.hashCode();
        if (str.equals("interactionAreaInfo")) {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("areas");
            if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0 || (jSONObject2 = jSONArrayOptJSONArray.getJSONObject(0)) == null) {
                kVarU = null;
                kVarU2 = null;
            } else {
                kVarU = com.bytedance.sdk.openadsdk.core.kj.k.u(jSONObject2);
                if (nVarFx != null) {
                    nVarFx.setEasyPlayInteractionAreaInfo(kVarU);
                    kVarU2 = com.bytedance.sdk.openadsdk.core.kj.k.u(nVarFx.getEstimatedInteractionAreaInfo());
                } else {
                    kVarU2 = null;
                }
            }
            if (kVarU2 == null) {
                if (nVarFx != null) {
                    nVarFx.u(com.bytedance.sdk.openadsdk.core.kj.k.nr(null, kVarU), 1.0d);
                    this.nr.nr("canMakeVisiable", (JSONObject) null);
                }
            } else if (kVarU == null) {
                nVarFx.u(null, -1.0d);
                nVarFx.fx();
                this.nr.nr("expressWebviewRecycle", (JSONObject) null);
            } else {
                double dU = com.bytedance.sdk.openadsdk.core.kj.k.u(kVarU2, kVarU);
                double d = kVarU.fx * kVarU.b;
                double d2 = kVarU2.fx * kVarU2.b;
                if (d2 == 0.0d) {
                    nVarFx.u(com.bytedance.sdk.openadsdk.core.kj.k.nr(kVarU2, kVarU), 1.0d);
                    this.nr.nr("canMakeVisiable", (JSONObject) null);
                    return null;
                }
                if (d == 0.0d) {
                    nVarFx.u(null, -1.0d);
                    nVarFx.fx();
                    this.nr.nr("expressWebviewRecycle", (JSONObject) null);
                    return null;
                }
                if (!(dU / d >= 0.8d)) {
                    nVarFx.u(null, -1.0d);
                    nVarFx.fx();
                    this.nr.nr("expressWebviewRecycle", (JSONObject) null);
                    return null;
                }
                nVarFx.u(com.bytedance.sdk.openadsdk.core.kj.k.nr(kVarU2, kVarU), (dU - d2) / d2);
                this.nr.nr("canMakeVisiable", (JSONObject) null);
                return null;
            }
        } else if (str.equals("getEstimatedInteractionAreaInfo") && nVarFx != null) {
            return nVarFx.getEstimatedInteractionAreaInfo();
        }
        return null;
    }
}
