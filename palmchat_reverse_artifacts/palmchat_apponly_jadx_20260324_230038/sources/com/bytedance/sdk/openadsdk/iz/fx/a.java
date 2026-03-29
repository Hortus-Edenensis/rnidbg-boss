package com.bytedance.sdk.openadsdk.iz.fx;

import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class a implements b {
    private int b;
    private int fx;
    private long nr;
    private long u;

    @Override // com.bytedance.sdk.openadsdk.iz.fx.b
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("video_start_duration", this.u);
            jSONObject.put("video_cache_size", this.nr);
            jSONObject.put("is_auto_play", this.fx);
            jSONObject.put("is_supplement_replay", this.b);
        } catch (Throwable unused) {
        }
    }

    public void nr(long j) {
        this.nr = j;
    }

    public void u(long j) {
        this.u = j;
    }

    public void nr(int i) {
        this.fx = i;
    }

    public void u(int i) {
        this.b = i;
    }
}
