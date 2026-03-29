package com.bytedance.sdk.openadsdk.core.component;

import com.bytedance.sdk.openadsdk.core.kj.bc;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr implements com.bytedance.sdk.openadsdk.core.q.u {
    public int b;
    public String fx;
    public boolean iz;
    private String n;
    public int nr;
    public bc pn;
    public String u;
    public List<com.bytedance.sdk.openadsdk.core.d.u> x = new CopyOnWriteArrayList();

    public nr(String str) {
        this.n = str;
    }

    public String u() {
        return this.n;
    }
}
