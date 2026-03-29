package com.bytedance.sdk.openadsdk.core.kj;

import android.text.TextUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class h {
    private List<com.bytedance.sdk.openadsdk.core.ugeno.component.interact.u.nr> fx = new ArrayList();
    private String nr;
    private String u;

    public h(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.u = jSONObject.optString("id");
        this.nr = jSONObject.optString("url");
        fx();
    }

    private void fx() {
        String strU = u(this.u);
        if (!TextUtils.isEmpty(strU)) {
            nr(strU);
            return;
        }
        com.bytedance.sdk.component.a.nr.fx fxVarFx = com.bytedance.sdk.openadsdk.core.gi.pn.u().nr().fx();
        if (fxVarFx == null || TextUtils.isEmpty(this.nr)) {
            return;
        }
        fxVarFx.u(this.nr);
        fxVarFx.u(new com.bytedance.sdk.component.a.u.u() { // from class: com.bytedance.sdk.openadsdk.core.kj.h.1
            @Override // com.bytedance.sdk.component.a.u.u
            public void u(com.bytedance.sdk.component.a.nr.b bVar, IOException iOException) {
            }

            @Override // com.bytedance.sdk.component.a.u.u
            public void u(com.bytedance.sdk.component.a.nr.b bVar, com.bytedance.sdk.component.a.nr nrVar) {
                if (nrVar != null) {
                    try {
                        if (!nrVar.a() || nrVar.pn() == null) {
                            return;
                        }
                        com.bytedance.sdk.component.b.nr.fx fxVarU = com.bytedance.sdk.openadsdk.core.nr.u();
                        String strPn = nrVar.pn();
                        fxVarU.put(h.this.u, strPn);
                        h.this.nr(strPn);
                    } catch (Exception unused) {
                    }
                }
            }
        });
    }

    public List<com.bytedance.sdk.openadsdk.core.ugeno.component.interact.u.nr> nr() {
        return this.fx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("pattern");
            for (int i = 0; i < jSONArray.length(); i++) {
                this.fx.add(new com.bytedance.sdk.openadsdk.core.ugeno.component.interact.u.nr(jSONArray.getJSONObject(i)));
            }
        } catch (Exception unused) {
        }
    }

    public String u() {
        return this.u;
    }

    private String u(String str) {
        com.bytedance.sdk.component.b.nr.fx fxVarU;
        if (TextUtils.isEmpty(str) || (fxVarU = com.bytedance.sdk.openadsdk.core.nr.u()) == null) {
            return null;
        }
        return fxVarU.get(str, "");
    }

    public h(String str, JSONArray jSONArray) {
        this.u = str;
        u(jSONArray);
    }

    private void u(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                this.fx.add(new com.bytedance.sdk.openadsdk.core.ugeno.component.interact.u.nr(jSONArray.getJSONObject(i)));
            } catch (Exception unused) {
                return;
            }
        }
    }
}
