package com.bytedance.sdk.openadsdk.iz.fx;

import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class my implements b {
    private boolean nr;
    private long u;

    @Override // com.bytedance.sdk.openadsdk.iz.fx.b
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("video_cache_size", this.u);
            jSONObject.put("is_auto_play", this.nr);
        } catch (Throwable unused) {
        }
    }

    public void u(long j) {
        this.u = j;
    }

    public void u(boolean z) {
        this.nr = z;
    }
}
