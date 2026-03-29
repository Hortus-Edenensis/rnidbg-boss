package com.bytedance.sdk.openadsdk.core.bq.u;

import com.bytedance.sdk.component.widget.SSWebView;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class gi extends com.bytedance.sdk.component.u.pn<JSONObject, JSONObject> {
    private WeakReference<SSWebView> u;

    public gi(SSWebView sSWebView) {
        this.u = new WeakReference<>(sSWebView);
    }

    public static void u(com.bytedance.sdk.component.u.o oVar, SSWebView sSWebView) {
        oVar.u("preventTouchEvent", (com.bytedance.sdk.component.u.pn<?, ?>) new gi(sSWebView));
    }

    @Override // com.bytedance.sdk.component.u.pn
    public JSONObject u(JSONObject jSONObject, com.bytedance.sdk.component.u.iz izVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        try {
            boolean zOptBoolean = jSONObject.optBoolean("isPrevent", false);
            SSWebView sSWebView = this.u.get();
            if (sSWebView != null) {
                sSWebView.setIsPreventTouchEvent(zOptBoolean);
                jSONObject2.put("success", true);
            } else {
                jSONObject2.put("success", false);
            }
        } catch (Throwable unused) {
            jSONObject2.put("success", false);
        }
        return jSONObject2;
    }
}
