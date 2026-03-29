package com.bytedance.sdk.openadsdk.z.u.nr.u;

import android.os.Bundle;
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

    public void b() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 121104);
        sparseArray.put(-99999985, Void.class);
        this.u.apply(sparseArray);
    }

    public void fx() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 121103);
        sparseArray.put(-99999985, Void.class);
        this.u.apply(sparseArray);
    }

    public void iz() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 121108);
        sparseArray.put(-99999985, Void.class);
        this.u.apply(sparseArray);
    }

    public void nr() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 121102);
        sparseArray.put(-99999985, Void.class);
        this.u.apply(sparseArray);
    }

    public void pn() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 121105);
        sparseArray.put(-99999985, Void.class);
        this.u.apply(sparseArray);
    }

    public void u() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 121101);
        sparseArray.put(-99999985, Void.class);
        this.u.apply(sparseArray);
    }

    public void u(boolean z, int i, String str, int i2, String str2) {
        SparseArray<Object> sparseArray = new SparseArray<>(7);
        sparseArray.put(0, Boolean.valueOf(z));
        sparseArray.put(1, Integer.valueOf(i));
        sparseArray.put(2, str);
        sparseArray.put(3, Integer.valueOf(i2));
        sparseArray.put(4, str2);
        sparseArray.put(-99999987, 121106);
        sparseArray.put(-99999985, Void.class);
        this.u.apply(sparseArray);
    }

    public void u(boolean z, int i, Bundle bundle) {
        SparseArray<Object> sparseArray = new SparseArray<>(5);
        sparseArray.put(0, Boolean.valueOf(z));
        sparseArray.put(1, Integer.valueOf(i));
        sparseArray.put(2, bundle);
        sparseArray.put(-99999987, 121107);
        sparseArray.put(-99999985, Void.class);
        this.u.apply(sparseArray);
    }
}
