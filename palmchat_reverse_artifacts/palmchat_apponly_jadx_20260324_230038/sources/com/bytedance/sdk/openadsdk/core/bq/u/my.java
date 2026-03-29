package com.bytedance.sdk.openadsdk.core.bq.u;

import androidx.annotation.NonNull;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class my extends com.bytedance.sdk.component.u.pn<JSONObject, JSONObject> {
    private com.bytedance.sdk.openadsdk.core.kj.bc u;

    public my(com.bytedance.sdk.openadsdk.core.kj.bc bcVar) {
        this.u = bcVar;
    }

    public static void u(com.bytedance.sdk.component.u.o oVar, com.bytedance.sdk.openadsdk.core.kj.bc bcVar) {
        oVar.u("getLiveSaasAuthStatus", (com.bytedance.sdk.component.u.pn<?, ?>) new my(bcVar));
    }

    @Override // com.bytedance.sdk.component.u.pn
    public JSONObject u(@NonNull JSONObject jSONObject, @NonNull com.bytedance.sdk.component.u.iz izVar) throws Exception {
        com.bytedance.sdk.openadsdk.core.kj.jp jpVarU;
        com.bytedance.sdk.openadsdk.core.kj.bc bcVar;
        JSONObject jSONObject2 = new JSONObject();
        com.bytedance.sdk.openadsdk.core.kj.my myVar = null;
        if (jSONObject != null) {
            try {
                jpVarU = com.bytedance.sdk.openadsdk.core.kj.jp.u(jSONObject.optJSONObject("live_info"));
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("deep_link");
                if (jSONObjectOptJSONObject != null) {
                    myVar = new com.bytedance.sdk.openadsdk.core.kj.my(jSONObjectOptJSONObject);
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.k.nr("glsas", "method:" + th.getMessage());
            }
        } else {
            jpVarU = null;
        }
        if (myVar == null && (bcVar = this.u) != null) {
            myVar = bcVar.kv();
        }
        if (jpVarU == null) {
            jpVarU = this.u.vg();
        }
        boolean z = true;
        jSONObject2.put("has_live_silent_auth", jpVarU != null && jpVarU.fx());
        jSONObject2.put("has_install_douyin", com.bytedance.sdk.openadsdk.core.live.pn.u.u(myVar));
        jSONObject2.put("has_live_authed", com.bytedance.sdk.openadsdk.core.live.nr.u().pn() == 2);
        boolean z2 = jpVarU != null && jpVarU.b();
        if (z2) {
            if (com.bytedance.sdk.openadsdk.core.live.nr.u().fx() != 2) {
                z = false;
            }
            z2 = z;
        }
        jSONObject2.put("has_playable_auth_switch", z2);
        JSONObject jSONObject3 = new JSONObject();
        if (jpVarU != null) {
            jSONObject3.put("aweme_agreements", jpVarU.pn());
            jSONObject3.put("aweme_privacy", jpVarU.iz());
        }
        jSONObject2.put("aweme_auth_protocol", jSONObject3);
        return jSONObject2;
    }
}
