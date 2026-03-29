package com.bytedance.sdk.openadsdk.core.ugeno.component.interact.u;

import com.huawei.openalliance.ad.constant.be;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    private float b;
    private long fx;
    private int nr;
    private float pn;
    private int u;

    public nr(JSONObject jSONObject) {
        this.u = 0;
        this.nr = 0;
        this.fx = 0L;
        this.b = 0.1f;
        this.pn = 0.1f;
        if (jSONObject == null) {
            return;
        }
        this.u = jSONObject.optInt("time");
        this.nr = jSONObject.optInt("type");
        this.fx = jSONObject.optLong("duration");
        this.b = (float) jSONObject.optDouble("intensity");
        this.pn = (float) jSONObject.optDouble(be.ar);
        if (this.nr == 1 || this.fx < 100) {
            u(100L);
        }
    }

    public float b() {
        return this.pn;
    }

    public float fx() {
        return this.b;
    }

    public int getType() {
        return this.nr;
    }

    public long nr() {
        return this.fx;
    }

    public int u() {
        return this.u;
    }

    public void u(long j) {
        this.fx = j;
    }
}
