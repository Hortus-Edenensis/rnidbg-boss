package com.bytedance.sdk.openadsdk.core.kj;

import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class gi {
    private int fx;
    private long nr;
    private int u;

    public static gi u(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        gi giVar = new gi();
        giVar.u = jSONObject.optInt("refresh_control", 0);
        giVar.nr = jSONObject.optLong("refresh_imp_max_time", 0L);
        giVar.fx = jSONObject.optInt("refresh_num", 0);
        return giVar;
    }

    public int fx() {
        return this.fx;
    }

    public void nr(JSONObject jSONObject) {
        try {
            jSONObject.put("refresh_control", this.u);
            jSONObject.put("refresh_imp_max_time", this.nr);
            jSONObject.put("refresh_num", this.fx);
        } catch (JSONException unused) {
        }
    }

    public static boolean fx(bc bcVar) {
        return com.bytedance.sdk.openadsdk.core.dw.nr().k(String.valueOf(com.bytedance.sdk.openadsdk.core.y.jp.t(bcVar))) && u(bcVar) && !com.bytedance.sdk.openadsdk.core.my.b.u(String.valueOf(com.bytedance.sdk.openadsdk.core.y.jp.t(bcVar)));
    }

    public long nr() {
        return this.nr;
    }

    public static int nr(bc bcVar) {
        gi giVarTw;
        if (bcVar == null || (giVarTw = bcVar.tw()) == null) {
            return 0;
        }
        return giVarTw.fx();
    }

    public static boolean u(bc bcVar) {
        gi giVarTw;
        return (bcVar == null || (giVarTw = bcVar.tw()) == null || giVarTw.u() != 1) ? false : true;
    }

    public int u() {
        return this.u;
    }

    public static boolean u(List<bc> list) {
        Iterator<bc> it = list.iterator();
        boolean z = false;
        boolean z2 = false;
        while (it.hasNext()) {
            if (it.next().ba() == 100.0f) {
                z = true;
            } else {
                z2 = true;
            }
        }
        return (z && z2) ? false : true;
    }
}
