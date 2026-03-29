package com.bytedance.sdk.component.n.nr.iz;

import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
class b {
    private int b;
    private boolean fx;
    private int iz;
    private String nr;
    private JSONObject pn;
    private String u;

    public b(String str, String str2, boolean z, int i, JSONObject jSONObject, int i2) {
        this.u = str;
        this.nr = str2;
        this.fx = z;
        this.b = i;
        this.pn = jSONObject;
        this.iz = i2;
    }

    public boolean b() {
        return this.fx;
    }

    public String fx() {
        return this.nr;
    }

    public String nr() {
        return this.u;
    }

    public int pn() {
        return this.b;
    }

    public JSONObject u() {
        if (this.pn == null) {
            this.pn = new JSONObject();
        }
        return this.pn;
    }

    public void u(int i) {
        this.b = i;
    }
}
