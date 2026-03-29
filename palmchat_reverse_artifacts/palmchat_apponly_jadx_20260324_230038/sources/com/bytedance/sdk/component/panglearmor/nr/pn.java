package com.bytedance.sdk.component.panglearmor.nr;

import com.heytap.mcssdk.constant.a;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn {
    private static pn u;
    private boolean nr = false;
    private long fx = 180000;
    private long b = a.g;
    private long pn = 3;
    private long iz = 30;
    private long x = 15;

    private pn() {
    }

    public static pn u() {
        if (u == null) {
            synchronized (pn.class) {
                if (u == null) {
                    u = new pn();
                }
            }
        }
        return u;
    }

    public long b() {
        return this.fx;
    }

    public long fx() {
        return this.b;
    }

    public long iz() {
        return this.iz;
    }

    public boolean nr() {
        return this.nr;
    }

    public long pn() {
        return this.pn;
    }

    public long x() {
        return this.x;
    }

    public synchronized void u(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (!jSONObject.toString().isEmpty()) {
                this.nr = jSONObject.optBoolean("sensorenable", false);
                this.fx = jSONObject.optLong("interval", 180000L);
                this.b = jSONObject.optLong("expireduation", a.g);
                this.pn = jSONObject.optLong("showinterval", 3L);
                this.iz = jSONObject.optLong("azimuth_unit", 30L);
                this.x = jSONObject.optLong("angle_unit", 15L);
            }
        }
    }
}
