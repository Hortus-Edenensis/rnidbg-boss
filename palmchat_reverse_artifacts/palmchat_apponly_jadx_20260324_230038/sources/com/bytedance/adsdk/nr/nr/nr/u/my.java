package com.bytedance.adsdk.nr.nr.nr.u;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class my implements com.bytedance.adsdk.nr.nr.nr.u {
    private final com.bytedance.adsdk.nr.nr.b.fx u;

    public my(com.bytedance.adsdk.nr.nr.b.fx fxVar) {
        this.u = fxVar;
    }

    @Override // com.bytedance.adsdk.nr.nr.nr.u
    public String nr() {
        return this.u.u();
    }

    public String toString() {
        return nr();
    }

    @Override // com.bytedance.adsdk.nr.nr.nr.u
    public Object u(Map<String, JSONObject> map) {
        throw new UnsupportedOperationException();
    }

    @Override // com.bytedance.adsdk.nr.nr.nr.u
    public com.bytedance.adsdk.nr.nr.b.pn u() {
        return this.u;
    }
}
