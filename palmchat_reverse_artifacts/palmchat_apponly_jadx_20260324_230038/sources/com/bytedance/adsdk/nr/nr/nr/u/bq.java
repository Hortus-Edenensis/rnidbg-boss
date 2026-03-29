package com.bytedance.adsdk.nr.nr.nr.u;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class bq implements com.bytedance.adsdk.nr.nr.nr.u {
    private final String u;

    public bq(String str) {
        this.u = str;
    }

    @Override // com.bytedance.adsdk.nr.nr.nr.u
    public String nr() {
        return "'" + this.u + "'";
    }

    public String toString() {
        return nr();
    }

    @Override // com.bytedance.adsdk.nr.nr.nr.u
    public Object u(Map<String, JSONObject> map) {
        return this.u;
    }

    @Override // com.bytedance.adsdk.nr.nr.nr.u
    public com.bytedance.adsdk.nr.nr.b.pn u() {
        return com.bytedance.adsdk.nr.nr.b.iz.STRING;
    }
}
