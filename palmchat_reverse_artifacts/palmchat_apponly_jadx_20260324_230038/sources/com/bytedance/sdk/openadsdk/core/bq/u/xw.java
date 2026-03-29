package com.bytedance.sdk.openadsdk.core.bq.u;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.component.widget.SSWebView;
import com.cdo.oaps.ad.OapsKey;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class xw extends com.bytedance.sdk.component.u.pn<JSONObject, JSONObject> {
    private com.bytedance.sdk.openadsdk.core.ja fx;
    private String nr;
    private SSWebView u;

    public xw(SSWebView sSWebView, String str, com.bytedance.sdk.openadsdk.core.ja jaVar) {
        this.u = sSWebView;
        this.nr = str;
        this.fx = jaVar;
    }

    public static void u(com.bytedance.sdk.component.u.o oVar, SSWebView sSWebView, com.bytedance.sdk.openadsdk.core.ja jaVar) {
        oVar.u("closeWebview", (com.bytedance.sdk.component.u.pn<?, ?>) new xw(sSWebView, "closeWebview", jaVar));
        oVar.u("makeVisible", (com.bytedance.sdk.component.u.pn<?, ?>) new xw(sSWebView, "makeVisible", jaVar));
        oVar.u("getCurrentVisibleState", (com.bytedance.sdk.component.u.pn<?, ?>) new xw(sSWebView, "getCurrentVisibleState", jaVar));
        oVar.u("changeSize", (com.bytedance.sdk.component.u.pn<?, ?>) new xw(sSWebView, "changeSize", jaVar));
        oVar.u("changeFrame", (com.bytedance.sdk.component.u.pn<?, ?>) new xw(sSWebView, "changeFrame", jaVar));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.bytedance.sdk.component.u.pn
    @Nullable
    public JSONObject u(@NonNull JSONObject jSONObject, @NonNull com.bytedance.sdk.component.u.iz izVar) throws Exception {
        JSONObject jSONObject2;
        int iOptInt;
        int iOptInt2;
        int iOptInt3;
        jSONObject2 = new JSONObject();
        String str = this.nr;
        str.hashCode();
        switch (str) {
            case "changeSize":
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("size");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() == 2) {
                    int iOptInt4 = jSONArrayOptJSONArray.optInt(0);
                    int iOptInt5 = jSONArrayOptJSONArray.optInt(1);
                    com.bytedance.sdk.openadsdk.core.ja jaVar = this.fx;
                    if (jaVar != null) {
                        jaVar.u(iOptInt4, iOptInt5);
                    }
                }
                return jSONObject2;
            case "changeFrame":
                JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray(OapsKey.KEY_POINT);
                JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("size");
                int iOptInt6 = Integer.MAX_VALUE;
                if (jSONArrayOptJSONArray2 == null || jSONArrayOptJSONArray2.length() != 2) {
                    iOptInt = Integer.MAX_VALUE;
                    iOptInt2 = Integer.MAX_VALUE;
                } else {
                    iOptInt2 = jSONArrayOptJSONArray2.optInt(0);
                    iOptInt = jSONArrayOptJSONArray2.optInt(1);
                }
                if (jSONArrayOptJSONArray3 == null || jSONArrayOptJSONArray3.length() != 2) {
                    iOptInt3 = Integer.MAX_VALUE;
                } else {
                    iOptInt6 = jSONArrayOptJSONArray3.optInt(0);
                    iOptInt3 = jSONArrayOptJSONArray3.optInt(1);
                }
                com.bytedance.sdk.openadsdk.core.ja jaVar2 = this.fx;
                if (jaVar2 != null) {
                    jaVar2.u(iOptInt2, iOptInt, iOptInt6, iOptInt3);
                }
                return jSONObject2;
            case "getCurrentVisibleState":
                jSONObject2.put("visibleState", !com.bytedance.sdk.openadsdk.core.wq.nr(this.u, 50, 5) ? 1 : 0);
                return jSONObject2;
            case "closeWebview":
                com.bytedance.sdk.openadsdk.gi.x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.bq.u.xw.1
                    @Override // java.lang.Runnable
                    public void run() {
                        xw.this.u.setVisibility(8);
                    }
                });
                com.bytedance.sdk.openadsdk.core.ugeno.component.interact.n nVarFx = this.fx.fx();
                if (nVarFx != null) {
                    nVarFx.nr();
                    jSONObject2.put("success", true);
                } else {
                    jSONObject2.put("success", false);
                }
                return jSONObject2;
            case "makeVisible":
                if (this.u != null) {
                    jSONObject2.put("success", true);
                    com.bytedance.sdk.openadsdk.gi.x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.bq.u.xw.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (xw.this.u != null) {
                                xw.this.u.setVisibility(0);
                            }
                            com.bytedance.sdk.openadsdk.core.ugeno.component.interact.n nVarFx2 = xw.this.fx.fx();
                            if (nVarFx2 != null) {
                                nVarFx2.H_();
                            }
                        }
                    });
                } else {
                    jSONObject2.put("success", false);
                }
                return jSONObject2;
            default:
                return jSONObject2;
        }
    }
}
