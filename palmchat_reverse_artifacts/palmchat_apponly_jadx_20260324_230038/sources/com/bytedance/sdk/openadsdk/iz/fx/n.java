package com.bytedance.sdk.openadsdk.iz.fx;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class n implements b {
    private Map<String, Object> b;
    private int fx;
    private long nr;
    private long u;

    @Override // com.bytedance.sdk.openadsdk.iz.fx.b
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        Map<String, Object> map = this.b;
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                try {
                    jSONObject.put(entry.getKey(), entry.getValue());
                } catch (Throwable unused) {
                }
            }
        }
        try {
            jSONObject.put("buffers_time", this.u);
            jSONObject.put("total_duration", this.nr);
            jSONObject.put("vbtt_skip_type", this.fx);
        } catch (Throwable unused2) {
        }
    }

    public void nr(long j) {
        this.nr = j;
    }

    public void u(int i) {
        this.fx = i;
    }

    public void u(long j) {
        this.u = j;
    }

    public void u(Map<String, Object> map) {
        this.b = map;
    }
}
