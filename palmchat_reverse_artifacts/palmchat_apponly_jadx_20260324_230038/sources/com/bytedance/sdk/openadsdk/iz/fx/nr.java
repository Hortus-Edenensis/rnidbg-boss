package com.bytedance.sdk.openadsdk.iz.fx;

import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.iz.fx.b;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr<T extends b> {
    private T b;
    private JSONObject fx;
    private String nr;
    private boolean pn = false;
    private bc u;

    public nr(bc bcVar, String str, JSONObject jSONObject, T t) {
        this.u = bcVar;
        this.nr = str;
        this.fx = jSONObject;
        this.b = t;
    }

    public T b() {
        return this.b;
    }

    public JSONObject fx() {
        if (this.fx == null) {
            this.fx = new JSONObject();
        }
        return this.fx;
    }

    public String nr() {
        return this.nr;
    }

    public boolean pn() {
        return this.pn;
    }

    public bc u() {
        return this.u;
    }

    public void u(boolean z) {
        this.pn = z;
    }
}
