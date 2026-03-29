package com.bytedance.sdk.openadsdk.iz.fx;

import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class u implements b {
    private com.bykv.vk.openvk.component.video.api.fx.iz u;

    public void u(com.bykv.vk.openvk.component.video.api.fx.iz izVar) {
        this.u = izVar;
    }

    public com.bykv.vk.openvk.component.video.api.fx.iz u() {
        return this.u;
    }

    public void u(JSONObject jSONObject) {
        try {
            com.bykv.vk.openvk.component.video.api.fx.iz izVar = this.u;
            if (izVar == null || jSONObject == null) {
                return;
            }
            JSONObject jSONObjectU = izVar.u();
            jSONObject.put("pitaya_cache_size", this.u.nr());
            jSONObject.put("pitaya_code", this.u.fx());
            jSONObject.put("pitaya_msg", this.u.b());
            jSONObject.put("ext_plugin_code", jSONObjectU.optInt("ext_plugin_code"));
            jSONObject.put("package", jSONObjectU.optJSONObject("package"));
        } catch (Exception unused) {
        }
    }
}
