package com.bytedance.sdk.openadsdk.iz.fx;

import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class mv extends u {
    private long b;
    private long fx;
    private long nr;
    private String u;

    @Override // com.bytedance.sdk.openadsdk.iz.fx.b
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("preload_url", this.u);
            jSONObject.put("preload_size", this.nr);
            jSONObject.put("load_time", this.fx);
            jSONObject.put("local_cache", this.b);
            u(jSONObject);
        } catch (Throwable unused) {
        }
    }

    public void fx(long j) {
        this.b = j;
    }

    public void nr(long j) {
        this.fx = j;
    }

    public void u(String str) {
        this.u = str;
    }

    public void u(long j) {
        this.nr = j;
    }
}
