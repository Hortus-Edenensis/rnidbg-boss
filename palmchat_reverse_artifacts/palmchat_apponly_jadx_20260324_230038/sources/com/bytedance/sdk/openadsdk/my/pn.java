package com.bytedance.sdk.openadsdk.my;

import android.util.SparseArray;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn {
    private final SparseArray<Object> u = new SparseArray<>();

    private pn() {
    }

    public static pn u() {
        return new pn();
    }

    public SparseArray<Object> nr() {
        return this.u;
    }

    public pn u(int i) {
        this.u.put(-999900, Integer.valueOf(i));
        return this;
    }

    public pn u(String str) {
        this.u.put(-999901, str);
        return this;
    }

    public pn u(boolean z) {
        this.u.put(-999903, Boolean.valueOf(z));
        return this;
    }

    public pn u(SparseArray<Object> sparseArray) {
        this.u.put(-999902, sparseArray);
        return this;
    }
}
