package com.bytedance.sdk.openadsdk.core.multipro.nr;

import com.huawei.openalliance.ad.constant.bq;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    public boolean b;
    public boolean fx;
    public long iz;
    public boolean n;
    public boolean nr;
    public long pn;
    public boolean u;
    public long x;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.multipro.nr.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0273u {
        boolean m_();

        u r_();
    }

    public u b(boolean z) {
        this.nr = z;
        return this;
    }

    public u fx(boolean z) {
        this.u = z;
        return this;
    }

    public u nr(boolean z) {
        this.b = z;
        return this;
    }

    public u pn(boolean z) {
        this.fx = z;
        return this;
    }

    public void u(boolean z) {
        this.n = z;
    }

    public u fx(long j) {
        this.x = j;
        return this;
    }

    public u nr(long j) {
        this.iz = j;
        return this;
    }

    public u u(long j) {
        this.pn = j;
        return this;
    }

    public JSONObject u() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isCompleted", this.u);
            jSONObject.put("isFromVideoDetailPage", this.nr);
            jSONObject.put("isFromDetailPage", this.fx);
            jSONObject.put("duration", this.pn);
            jSONObject.put("totalPlayDuration", this.iz);
            jSONObject.put("currentPlayPosition", this.x);
            jSONObject.put("isAutoPlay", this.b);
            jSONObject.put(bq.f.l, this.n);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static u u(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        u uVar = new u();
        uVar.fx(jSONObject.optBoolean("isCompleted"));
        uVar.b(jSONObject.optBoolean("isFromVideoDetailPage"));
        uVar.pn(jSONObject.optBoolean("isFromDetailPage"));
        uVar.u(jSONObject.optLong("duration"));
        uVar.nr(jSONObject.optLong("totalPlayDuration"));
        uVar.fx(jSONObject.optLong("currentPlayPosition"));
        uVar.nr(jSONObject.optBoolean("isAutoPlay"));
        uVar.u(jSONObject.optBoolean(bq.f.l));
        return uVar;
    }
}
