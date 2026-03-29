package com.bytedance.sdk.openadsdk.iz.fx;

import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx implements b {
    private int b;
    private int fx;
    private long iz;
    private long nr;
    private long pn;
    private long u;
    private int x;

    @Override // com.bytedance.sdk.openadsdk.iz.fx.b
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("buffers_time", this.u);
            jSONObject.put("total_duration", this.nr);
            jSONObject.put("vbtt_skip_type", this.fx);
            jSONObject.put("skip_reason", this.b);
            jSONObject.put("video_cache_size", this.pn);
            jSONObject.put("current", this.iz);
            jSONObject.put("percent", this.x);
        } catch (Throwable unused) {
        }
    }

    public void b(long j) {
        this.nr = j;
    }

    public void fx(long j) {
        this.u = j;
    }

    public void nr(long j) {
        this.pn = j;
    }

    public void u(long j) {
        this.iz = j;
    }

    public void fx(int i) {
        this.b = i;
    }

    public void nr(int i) {
        this.fx = i;
    }

    public void u(int i) {
        this.x = i;
    }
}
