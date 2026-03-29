package com.bytedance.sdk.openadsdk.iz.fx;

import com.baidu.mapapi.SDKInitializer;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class k implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f5417a;
    private int b;
    private int fx;
    private JSONArray iz;
    private int jk;
    private long n;
    private long nr;
    private String pn;
    private boolean t;
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
            jSONObject.put(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, this.fx);
            jSONObject.put("extra_error_code", this.b);
            jSONObject.put("error_message", this.pn);
            jSONObject.put("event_list", this.iz);
            jSONObject.put("vbtt_skip_type", this.x);
            jSONObject.put("video_cache_size", this.n);
            jSONObject.put("current", this.f5417a);
            jSONObject.put("percent", this.jk);
            jSONObject.put("has_endcard_skip", this.t);
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
        this.n = j;
    }

    public void u(boolean z) {
        this.t = z;
    }

    public void b(int i) {
        this.b = i;
    }

    public void fx(int i) {
        this.fx = i;
    }

    public void nr(int i) {
        this.x = i;
    }

    public void u(long j) {
        this.f5417a = j;
    }

    public void u(int i) {
        this.jk = i;
    }

    public void u(JSONArray jSONArray) {
        this.iz = jSONArray;
    }

    public void u(String str) {
        this.pn = str;
    }
}
