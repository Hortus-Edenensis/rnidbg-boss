package com.bytedance.sdk.openadsdk.core.bq.u;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class rh extends com.bytedance.sdk.component.u.pn<JSONObject, JSONObject> {
    private com.bytedance.sdk.openadsdk.core.ugeno.nr u;

    public rh(com.bytedance.sdk.openadsdk.core.ugeno.nr nrVar) {
        this.u = nrVar;
    }

    public JSONObject fx() {
        return new JSONObject();
    }

    public static void u(com.bytedance.sdk.component.u.o oVar, com.bytedance.sdk.openadsdk.core.ugeno.nr nrVar) {
        oVar.u("RendUgenDownloadDialogState", (com.bytedance.sdk.component.u.pn<?, ?>) new rh(nrVar));
    }

    @Override // com.bytedance.sdk.component.u.pn
    public JSONObject u(JSONObject jSONObject, com.bytedance.sdk.component.u.iz izVar) throws Exception {
        u(jSONObject);
        return fx();
    }

    private void u(JSONObject jSONObject) {
        if (jSONObject == null || this.u == null) {
            return;
        }
        int iOptInt = jSONObject.optInt("code");
        if (iOptInt == 200) {
            this.u.u();
        } else {
            this.u.u(iOptInt, jSONObject.optString(MediationConstant.KEY_ERROR_MSG));
        }
    }
}
