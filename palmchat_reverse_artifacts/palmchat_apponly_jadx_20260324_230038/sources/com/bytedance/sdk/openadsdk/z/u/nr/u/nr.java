package com.bytedance.sdk.openadsdk.z.u.nr.u;

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

    public void u(int i, com.bytedance.sdk.openadsdk.o.u.u.u.u.u uVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(0, Integer.valueOf(i));
        sparseArray.put(1, uVar);
        sparseArray.put(-99999987, 122101);
        sparseArray.put(-99999985, Void.class);
        this.u.apply(sparseArray);
    }
}
