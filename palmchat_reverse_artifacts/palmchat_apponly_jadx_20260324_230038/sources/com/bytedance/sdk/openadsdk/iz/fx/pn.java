package com.bytedance.sdk.openadsdk.iz.fx;

import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn implements b {
    public int b = 0;
    public int fx;
    public long nr;
    private int pn;
    public long u;

    @Override // com.bytedance.sdk.openadsdk.iz.fx.b
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("total_duration", this.u);
            jSONObject.put("buffers_time", this.nr);
            jSONObject.put("break_reason", this.fx);
            jSONObject.put("video_backup", this.b);
            jSONObject.put("vbtt_skip_type", this.pn);
        } catch (Throwable unused) {
        }
    }

    public void fx(int i) {
        this.b = i;
    }

    public void nr(long j) {
        this.nr = j;
    }

    public void u(int i) {
        this.pn = i;
    }

    public void nr(int i) {
        this.fx = i;
    }

    public void u(long j) {
        this.u = j;
    }
}
