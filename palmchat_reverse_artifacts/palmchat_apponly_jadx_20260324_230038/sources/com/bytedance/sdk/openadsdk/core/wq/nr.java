package com.bytedance.sdk.openadsdk.core.wq;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    private int b;
    private JSONObject fx;
    private Map<String, String> nr;
    private JSONObject pn;
    private byte[] u;

    public JSONObject b() {
        return this.fx;
    }

    public byte[] fx() {
        return this.u;
    }

    public int nr() {
        return this.b;
    }

    public Map<String, String> pn() {
        return this.nr;
    }

    public JSONObject u() {
        return this.pn;
    }

    public void nr(JSONObject jSONObject) {
        this.fx = jSONObject;
    }

    public void u(JSONObject jSONObject) {
        this.pn = jSONObject;
    }

    public void u(int i) {
        this.b = i;
    }

    public void u(byte[] bArr) {
        this.u = bArr;
    }

    public void u(Map<String, String> map) {
        this.nr = map;
    }
}
