package com.bytedance.sdk.openadsdk.core.kj;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private List<bc> b = new ArrayList();
    private String fx;
    private long iz;
    private int nr;
    private JSONObject pn;
    private String u;

    public JSONObject fx() {
        return this.pn;
    }

    public void nr(String str) {
        this.fx = str;
    }

    public void u(String str) {
        this.u = str;
    }

    public List<bc> nr() {
        return this.b;
    }

    public int u() {
        return this.nr;
    }

    public void u(int i) {
        this.nr = i;
    }

    public void u(bc bcVar) {
        this.b.add(bcVar);
    }

    public void u(List<bc> list) {
        this.b = list;
    }

    public void u(JSONObject jSONObject) {
        this.pn = jSONObject;
    }

    public void u(long j) {
        this.iz = j;
    }
}
