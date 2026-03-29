package com.bytedance.sdk.openadsdk.core.y;

import android.util.Pair;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class xw extends com.bytedance.sdk.component.a.nr.pn {
    public xw(com.bytedance.sdk.component.nr.u.l lVar) {
        super(lVar);
    }

    public void fx(JSONObject jSONObject, String str) {
        if (com.bytedance.sdk.openadsdk.core.dw.nr().fn()) {
            u(jSONObject, str);
        } else {
            fx(com.bytedance.sdk.component.utils.u.u(jSONObject).toString());
        }
    }

    public void nr(JSONObject jSONObject, String str) {
        if (com.bytedance.sdk.openadsdk.core.dw.nr().iq()) {
            u(jSONObject, str);
        } else {
            fx(com.bytedance.sdk.component.utils.u.u(jSONObject).toString());
        }
    }

    public void u(JSONObject jSONObject, String str) {
        Pair<Integer, ?> pairU;
        Object obj;
        try {
            pairU = com.bytedance.sdk.openadsdk.core.fx.iz.u().u(jSONObject.toString(), str);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.k.u(th.getMessage());
            pairU = null;
        }
        if (pairU == null || (obj = pairU.first) == null) {
            fx(com.bytedance.sdk.component.utils.u.u(jSONObject).toString());
        } else {
            if (((Integer) obj).intValue() != 4) {
                u((JSONObject) pairU.second);
                return;
            }
            u("application/octet-stream", (byte[]) pairU.second);
            u(true);
            nr("x-pglcypher", String.valueOf(pairU.first));
        }
    }
}
