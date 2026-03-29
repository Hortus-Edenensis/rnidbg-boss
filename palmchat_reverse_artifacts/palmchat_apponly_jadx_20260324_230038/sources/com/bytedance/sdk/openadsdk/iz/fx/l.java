package com.bytedance.sdk.openadsdk.iz.fx;

import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class l extends u {
    private long nr;
    private String u;

    public l(String str, long j) {
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
            com.bykv.vk.openvk.component.video.api.fx.iz izVarU = u();
            if (izVarU != null) {
                jSONObject.put("run_task_mills", izVarU.u().optLong("run_task_mills"));
            }
            u(jSONObject);
        } catch (Throwable unused) {
        }
    }
}
