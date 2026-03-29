package com.bytedance.sdk.openadsdk.iz.fx;

import com.baidu.mapapi.SDKInitializer;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class t extends u {
    private int b;
    private long fx;
    private String iz;
    private long nr;
    private String pn;
    private String u;

    @Override // com.bytedance.sdk.openadsdk.iz.fx.b
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("preload_url", this.u);
            jSONObject.put("preload_size", this.nr);
            jSONObject.put("load_time", this.fx);
            jSONObject.put(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, this.b);
            jSONObject.put("error_message", this.pn);
            jSONObject.put("error_message_server", this.iz);
            u(jSONObject);
        } catch (Throwable unused) {
        }
    }

    public void fx(String str) {
        this.iz = str;
    }

    public void nr(long j) {
        this.fx = j;
    }

    public void u(String str) {
        this.u = str;
    }

    public void nr(String str) {
        this.pn = str;
    }

    public void u(long j) {
        this.nr = j;
    }

    public void u(int i) {
        this.b = i;
    }
}
