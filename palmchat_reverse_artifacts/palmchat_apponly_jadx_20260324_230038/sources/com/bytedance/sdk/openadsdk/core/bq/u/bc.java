package com.bytedance.sdk.openadsdk.core.bq.u;

import com.bytedance.sdk.openadsdk.core.widget.x;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class bc extends com.bytedance.sdk.component.u.pn<JSONObject, JSONObject> {
    private x.u u;

    public bc(x.u uVar) {
        this.u = uVar;
    }

    public JSONObject fx() {
        return new JSONObject();
    }

    public static void u(com.bytedance.sdk.component.u.o oVar, x.u uVar) {
        oVar.u("UgenDownloadDialogInteraction", (com.bytedance.sdk.component.u.pn<?, ?>) new bc(uVar));
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
        int iOptInt = jSONObject.optInt("InteractionType");
        if (iOptInt == 1) {
            this.u.fx(null);
            return;
        }
        if (iOptInt == 2) {
            this.u.u(null);
            return;
        }
        if (iOptInt == 3) {
            this.u.u();
        } else if (iOptInt == 4) {
            this.u.nr(null);
        } else {
            if (iOptInt != 5) {
                return;
            }
            this.u.b(null);
        }
    }
}
