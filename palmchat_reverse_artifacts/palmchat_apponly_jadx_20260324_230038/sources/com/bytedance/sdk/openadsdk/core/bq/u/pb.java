package com.bytedance.sdk.openadsdk.core.bq.u;

import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pb extends com.bytedance.sdk.component.u.pn<JSONObject, JSONObject> {
    private com.bytedance.sdk.openadsdk.core.kj.bc u;

    public pb(com.bytedance.sdk.openadsdk.core.kj.bc bcVar) {
        this.u = bcVar;
    }

    public static void u(com.bytedance.sdk.component.u.o oVar, com.bytedance.sdk.openadsdk.core.kj.bc bcVar) {
        oVar.u("sendEventCode", (com.bytedance.sdk.component.u.pn<?, ?>) new pb(bcVar));
    }

    @Override // com.bytedance.sdk.component.u.pn
    @Nullable
    public JSONObject u(JSONObject jSONObject, com.bytedance.sdk.component.u.iz izVar) throws Exception {
        com.bytedance.sdk.openadsdk.my.fx.u.nr nrVar;
        JSONObject jSONObject2 = new JSONObject();
        com.bytedance.sdk.openadsdk.core.kj.bc bcVar = this.u;
        if (bcVar != null && (nrVar = (com.bytedance.sdk.openadsdk.my.fx.u.nr) com.bytedance.sdk.openadsdk.core.c.u(bcVar.dv(), com.bytedance.sdk.openadsdk.my.fx.u.nr.class)) != null) {
            HashMap map = new HashMap();
            int iOptInt = jSONObject.optInt("event_code", -1);
            if (iOptInt >= 200) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("info");
                if (jSONObjectOptJSONObject != null) {
                    Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        map.put(next, jSONObjectOptJSONObject.opt(next));
                    }
                }
                nrVar.u(iOptInt, map);
            }
        }
        return jSONObject2;
    }
}
