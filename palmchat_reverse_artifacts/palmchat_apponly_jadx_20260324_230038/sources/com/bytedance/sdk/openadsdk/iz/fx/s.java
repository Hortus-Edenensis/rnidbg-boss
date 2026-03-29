package com.bytedance.sdk.openadsdk.iz.fx;

import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class s implements b {
    public long fx;
    public int nr;
    public long u;

    @Override // com.bytedance.sdk.openadsdk.iz.fx.b
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("buffers_time", this.u);
            jSONObject.put("buffers_count", this.nr);
            jSONObject.put("total_duration", this.fx);
        } catch (Throwable unused) {
        }
    }

    public void nr(long j) {
        this.fx = j;
    }

    public void u(long j) {
        this.u = j;
    }

    public void u(int i) {
        this.nr = i;
    }
}
