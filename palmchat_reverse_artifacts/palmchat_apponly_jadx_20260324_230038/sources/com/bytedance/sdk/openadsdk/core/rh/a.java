package com.bytedance.sdk.openadsdk.core.rh;

import android.util.SparseArray;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class a {
    private SparseArray<Object> fx;
    private com.bytedance.sdk.openadsdk.my.u nr;
    private int u;

    public a(SparseArray<Object> sparseArray, int i) {
        this.u = i;
        this.fx = sparseArray != null ? sparseArray : new SparseArray<>();
        this.nr = new com.bytedance.sdk.openadsdk.my.u(sparseArray);
    }

    public SparseArray<Object> b() {
        return this.fx;
    }

    public com.bytedance.sdk.openadsdk.my.u fx() {
        return this.nr;
    }

    public int getType() {
        return this.u;
    }

    public void setResult(SparseArray<Object> sparseArray) {
        this.nr = new com.bytedance.sdk.openadsdk.my.u(sparseArray);
    }
}
