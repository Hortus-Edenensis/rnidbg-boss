package com.bytedance.sdk.openadsdk.b.u.nr.u;

import android.util.SparseArray;
import defpackage.ll7;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    private final Function<SparseArray<Object>, Object> u;

    public nr(Function<SparseArray<Object>, Object> function) {
        this.u = function == null ? ll7.d : function;
    }

    public void nr() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 112103);
        sparseArray.put(-99999985, Void.class);
        this.u.apply(sparseArray);
    }

    public void u(com.bytedance.sdk.openadsdk.my.fx.nr.nr nrVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, nrVar);
        sparseArray.put(-99999987, 121201);
        sparseArray.put(-99999985, Void.class);
        this.u.apply(sparseArray);
    }

    public void u() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 112102);
        sparseArray.put(-99999985, Void.class);
        this.u.apply(sparseArray);
    }
}
