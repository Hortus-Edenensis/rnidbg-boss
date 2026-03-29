package com.bytedance.sdk.openadsdk.b.u.nr.u;

import android.util.SparseArray;
import defpackage.ll7;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private final Function<SparseArray<Object>, Object> u;

    public u(Function<SparseArray<Object>, Object> function) {
        this.u = function == null ? ll7.d : function;
    }

    public void nr(com.bytedance.sdk.openadsdk.my.fx.nr.nr nrVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, nrVar);
        sparseArray.put(-99999987, 111102);
        sparseArray.put(-99999985, Void.class);
        this.u.apply(sparseArray);
    }

    public void u(com.bytedance.sdk.openadsdk.my.fx.nr.nr nrVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, nrVar);
        sparseArray.put(-99999987, 111101);
        sparseArray.put(-99999985, Void.class);
        this.u.apply(sparseArray);
    }

    public void u(com.bytedance.sdk.openadsdk.my.fx.nr.nr nrVar, int i) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(0, nrVar);
        sparseArray.put(1, Integer.valueOf(i));
        sparseArray.put(-99999987, 111103);
        sparseArray.put(-99999985, Void.class);
        this.u.apply(sparseArray);
    }
}
