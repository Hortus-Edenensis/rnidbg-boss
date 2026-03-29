package com.bytedance.sdk.openadsdk.core.c;

import com.bytedance.sdk.openadsdk.core.ja;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn implements com.bytedance.sdk.openadsdk.s.fx {
    ja u;

    public pn(ja jaVar) {
        this.u = jaVar;
    }

    @Override // com.bytedance.sdk.openadsdk.s.fx
    public void u(String str, JSONObject jSONObject) {
        ja jaVar = this.u;
        if (jaVar != null) {
            jaVar.nr(str, jSONObject);
        }
    }
}
