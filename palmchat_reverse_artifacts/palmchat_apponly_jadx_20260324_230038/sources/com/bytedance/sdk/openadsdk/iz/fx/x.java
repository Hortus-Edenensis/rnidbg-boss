package com.bytedance.sdk.openadsdk.iz.fx;

import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class x implements b {
    private int fx = 0;
    private long nr;
    private long u;

    @Override // com.bytedance.sdk.openadsdk.iz.fx.b
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("total_duration", this.u);
            jSONObject.put("buffers_time", this.nr);
            jSONObject.put("video_backup", this.fx);
        } catch (Throwable unused) {
        }
    }

    public void nr(long j) {
        this.nr = j;
    }

    public void u(long j) {
        this.u = j;
    }

    public void u(int i) {
        this.fx = i;
    }
}
