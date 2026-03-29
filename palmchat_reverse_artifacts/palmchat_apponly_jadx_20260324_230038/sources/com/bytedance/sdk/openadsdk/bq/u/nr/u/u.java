package com.bytedance.sdk.openadsdk.bq.u.nr.u;

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
        sparseArray.put(-99999987, 114104);
        sparseArray.put(-99999985, Void.class);
        this.u.apply(sparseArray);
    }

    public void u(com.bytedance.sdk.openadsdk.my.fx.nr.nr nrVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, nrVar);
        sparseArray.put(-99999987, 114102);
        sparseArray.put(-99999985, Void.class);
        this.u.apply(sparseArray);
    }

    public void u(com.bytedance.sdk.openadsdk.my.fx.nr.u uVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, uVar);
        sparseArray.put(-99999987, 114103);
        sparseArray.put(-99999985, Void.class);
        this.u.apply(sparseArray);
    }

    public void u(com.bytedance.sdk.openadsdk.my.fx.nr.nr nrVar, com.bytedance.sdk.openadsdk.my.fx.nr.u uVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(0, nrVar);
        sparseArray.put(1, uVar);
        sparseArray.put(-99999987, 114105);
        sparseArray.put(-99999985, Void.class);
        this.u.apply(sparseArray);
    }
}
