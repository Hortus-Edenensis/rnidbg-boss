package com.bytedance.sdk.openadsdk.core.bq.u;

import com.bytedance.sdk.component.widget.SSWebView;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class h extends com.bytedance.sdk.component.u.pn<JSONObject, JSONObject> {
    private String nr;
    private SSWebView u;

    public h(SSWebView sSWebView, String str) {
        this.u = sSWebView;
        this.nr = str;
    }

    public JSONObject fx() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (com.bytedance.sdk.openadsdk.core.n.o().u(com.bytedance.sdk.openadsdk.core.dw.getContext()) && this.u != null) {
                jSONObject.put("code", 0);
                jSONObject.put("codeMsg", "success");
                this.u.K_();
                return jSONObject;
            }
            jSONObject.put("code", -1);
            jSONObject.put("codeMsg", "unavailable");
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public static void u(com.bytedance.sdk.component.u.o oVar, SSWebView sSWebView, String str) {
        oVar.u("close_wobble_observer", (com.bytedance.sdk.component.u.pn<?, ?>) new h(sSWebView, str));
    }

    @Override // com.bytedance.sdk.component.u.pn
    public JSONObject u(JSONObject jSONObject, com.bytedance.sdk.component.u.iz izVar) throws Exception {
        return fx();
    }
}
