package com.bytedance.sdk.component.adexpress.dynamic.b;

import com.bytedance.sdk.component.adexpress.nr.mv;
import com.huawei.hms.ads.ClickAreaSource;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class x implements n {
    private com.bytedance.sdk.component.adexpress.dynamic.pn.nr u;

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(mv mvVar) {
        try {
            JSONObject jSONObjectPn = mvVar.pn();
            JSONObject jSONObject = new JSONObject(jSONObjectPn.optString("template_Plugin"));
            JSONObject jSONObjectOptJSONObject = jSONObjectPn.optJSONObject(ClickAreaSource.CREATIVE);
            com.bytedance.sdk.component.adexpress.dynamic.fx.n nVarU = new iz(jSONObject, jSONObjectOptJSONObject, jSONObjectPn.optJSONObject("AdSize"), new JSONObject(jSONObjectPn.optString("diff_template_Plugin"))).u(mvVar.b(), mvVar.mv(), jSONObjectOptJSONObject.optDouble("score_exact_i18n"), jSONObjectOptJSONObject.optString("comment_num_i18n"), mvVar);
            try {
                JSONObject jSONObject2 = new JSONObject(jSONObjectOptJSONObject.optString("dynamic_creative"));
                nVarU.u(jSONObject2.optString("color"));
                nVarU.u(jSONObject2.optJSONArray("material_center"));
            } catch (Throwable unused) {
            }
            this.u.u(nVarU);
        } catch (Exception unused2) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.b.n
    public void u(com.bytedance.sdk.component.adexpress.dynamic.pn.nr nrVar) {
        this.u = nrVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.b.n
    public void u(final mv mvVar) {
        if (mvVar.k() == 1) {
            nr(mvVar);
        } else {
            com.bytedance.sdk.component.adexpress.b.pn.u(new com.bytedance.sdk.component.jk.a("dynamicparse") { // from class: com.bytedance.sdk.component.adexpress.dynamic.b.x.1
                @Override // java.lang.Runnable
                public void run() {
                    x.this.nr(mvVar);
                }
            }, 5);
        }
    }
}
