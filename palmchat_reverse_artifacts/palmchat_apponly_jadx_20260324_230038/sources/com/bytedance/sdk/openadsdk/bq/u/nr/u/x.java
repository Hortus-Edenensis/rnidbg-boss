package com.bytedance.sdk.openadsdk.bq.u.nr.u;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.my.fx.nr.k;
import defpackage.ll7;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class x {
    private final Function<SparseArray<Object>, Object> u;

    public x(Function<SparseArray<Object>, Object> function) {
        this.u = function == null ? ll7.d : function;
    }

    public void nr() {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 124104);
        sparseArray.put(-99999985, Void.class);
        this.u.apply(sparseArray);
    }

    public void u(int i, String str) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(0, Integer.valueOf(i));
        sparseArray.put(1, str);
        sparseArray.put(-99999987, 124101);
        sparseArray.put(-99999985, Void.class);
        this.u.apply(sparseArray);
    }

    public void nr(k kVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, kVar);
        sparseArray.put(-99999987, 124103);
        sparseArray.put(-99999985, Void.class);
        this.u.apply(sparseArray);
    }

    public void u(k kVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, kVar);
        sparseArray.put(-99999987, 124102);
        sparseArray.put(-99999985, Void.class);
        this.u.apply(sparseArray);
    }
}
