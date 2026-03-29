package com.bytedance.sdk.openadsdk.c.u.nr.u;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.my.fx.nr.jk;
import defpackage.ll7;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private final Function<SparseArray<Object>, Object> u;

    public u(Function<SparseArray<Object>, Object> function) {
        this.u = function == null ? ll7.d : function;
    }

    public void b(jk jkVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, jkVar);
        sparseArray.put(-99999987, 161105);
        sparseArray.put(-99999985, Void.class);
        this.u.apply(sparseArray);
    }

    public void fx(jk jkVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, jkVar);
        sparseArray.put(-99999987, 161103);
        sparseArray.put(-99999985, Void.class);
        this.u.apply(sparseArray);
    }

    public void nr(jk jkVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, jkVar);
        sparseArray.put(-99999987, 161104);
        sparseArray.put(-99999985, Void.class);
        this.u.apply(sparseArray);
    }

    public void pn(jk jkVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, jkVar);
        sparseArray.put(-99999987, 161107);
        sparseArray.put(-99999985, Void.class);
        this.u.apply(sparseArray);
    }

    public void u(jk jkVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, jkVar);
        sparseArray.put(-99999987, 161101);
        sparseArray.put(-99999985, Void.class);
        this.u.apply(sparseArray);
    }

    public void u(int i, int i2) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(0, Integer.valueOf(i));
        sparseArray.put(1, Integer.valueOf(i2));
        sparseArray.put(-99999987, 161102);
        sparseArray.put(-99999985, Void.class);
        this.u.apply(sparseArray);
    }

    public void u(long j, long j2) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(0, Long.valueOf(j));
        sparseArray.put(1, Long.valueOf(j2));
        sparseArray.put(-99999987, 161106);
        sparseArray.put(-99999985, Void.class);
        this.u.apply(sparseArray);
    }
}
