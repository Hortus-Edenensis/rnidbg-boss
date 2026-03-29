package com.bytedance.sdk.openadsdk.core.bq.u;

import com.bytedance.sdk.openadsdk.core.kj.yd;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class dw extends com.bytedance.sdk.component.u.pn<JSONObject, JSONObject> {
    private final String nr;
    private final WeakReference<com.bytedance.sdk.openadsdk.core.ja> u;

    public dw(com.bytedance.sdk.openadsdk.core.ja jaVar, String str) {
        this.u = new WeakReference<>(jaVar);
        this.nr = str;
    }

    public static void u(com.bytedance.sdk.component.u.o oVar, com.bytedance.sdk.openadsdk.core.ja jaVar) {
        oVar.u("interactiveStart", (com.bytedance.sdk.component.u.pn<?, ?>) new dw(jaVar, "interactiveStart"));
        oVar.u("interactiveFinish", (com.bytedance.sdk.component.u.pn<?, ?>) new dw(jaVar, "interactiveFinish"));
        oVar.u("interactiveEnd", (com.bytedance.sdk.component.u.pn<?, ?>) new dw(jaVar, "interactiveEnd"));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:7:0x002b  */
    @Override // com.bytedance.sdk.component.u.pn
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONObject u(JSONObject jSONObject, com.bytedance.sdk.component.u.iz izVar) throws Exception {
        com.bytedance.sdk.openadsdk.core.ja jaVar;
        com.bytedance.sdk.openadsdk.core.kj.bc bcVarN;
        int i;
        boolean z;
        JSONObject jSONObject2 = new JSONObject();
        if (this.u.get() == null) {
            return jSONObject2;
        }
        jaVar = this.u.get();
        bcVarN = jaVar.n();
        String str = this.nr;
        str.hashCode();
        i = 0;
        z = true;
        switch (str) {
            case "interactiveStart":
                jaVar.o();
                return jSONObject2;
            case "interactiveEnd":
                jaVar.sx();
                return jSONObject2;
            case "interactiveFinish":
                try {
                    if (jSONObject.optInt("finish", 1) != 1) {
                        z = false;
                    }
                    int iU = u(bcVarN, jSONObject.optInt("reduce_duration", -1));
                    if (z) {
                        jaVar.b(iU);
                    } else {
                        i = -1;
                    }
                    jSONObject2.put("code", i);
                    jSONObject2.put("reduce_duration", iU);
                    break;
                } catch (JSONException unused) {
                }
                return jSONObject2;
            default:
                return jSONObject2;
        }
    }

    public static int u(com.bytedance.sdk.openadsdk.core.kj.bc bcVar, int i) {
        int iSs = bcVar != null ? bcVar.ss() : 0;
        if (i >= 0 && iSs >= 0) {
            i = Math.min(i, iSs);
        } else if (i < 0) {
            i = iSs >= 0 ? iSs : 0;
        }
        if (yd.pn(bcVar)) {
            return 0;
        }
        return i;
    }
}
