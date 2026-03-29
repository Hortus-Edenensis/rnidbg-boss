package com.bytedance.sdk.openadsdk.iz.fx;

import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz implements b {
    private long nr;
    private long u;

    @Override // com.bytedance.sdk.openadsdk.iz.fx.b
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("buffers_time", this.u);
            jSONObject.put("total_duration", this.nr);
        } catch (Throwable unused) {
        }
    }

    public void nr(long j) {
        this.nr = j;
    }

    public void u(long j) {
        this.u = j;
    }
}
