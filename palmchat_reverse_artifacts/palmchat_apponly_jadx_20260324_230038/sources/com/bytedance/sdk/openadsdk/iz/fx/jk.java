package com.bytedance.sdk.openadsdk.iz.fx;

import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class jk extends u {
    private long nr;
    private String u;

    public jk(String str, long j) {
        this.u = str;
        this.nr = j;
    }

    @Override // com.bytedance.sdk.openadsdk.iz.fx.b
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("preload_url", this.u);
            jSONObject.put("preload_size", this.nr);
            u(jSONObject);
        } catch (Throwable unused) {
        }
    }
}
