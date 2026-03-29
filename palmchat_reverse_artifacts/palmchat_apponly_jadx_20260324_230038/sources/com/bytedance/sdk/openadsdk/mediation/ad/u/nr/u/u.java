package com.bytedance.sdk.openadsdk.mediation.ad.u.nr.u;

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

    public int nr() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 271032);
        sparseArray.put(-99999985, Integer.TYPE);
        return ((Integer) this.u.apply(sparseArray)).intValue();
    }

    public int u() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 271027);
        sparseArray.put(-99999985, Integer.TYPE);
        return ((Integer) this.u.apply(sparseArray)).intValue();
    }
}
