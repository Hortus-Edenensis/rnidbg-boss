package com.bytedance.sdk.openadsdk.qq.u.nr.u;

import android.util.SparseArray;
import android.view.View;
import com.bytedance.sdk.openadsdk.my.fx.nr.mv;
import defpackage.ll7;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private final Function<SparseArray<Object>, Object> u;

    public u(Function<SparseArray<Object>, Object> function) {
        this.u = function == null ? ll7.d : function;
    }

    public void nr(View view, mv mvVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(0, view);
        sparseArray.put(1, mvVar);
        sparseArray.put(-99999987, 141102);
        sparseArray.put(-99999985, Void.class);
        this.u.apply(sparseArray);
    }

    public void u(View view, mv mvVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(0, view);
        sparseArray.put(1, mvVar);
        sparseArray.put(-99999987, 141101);
        sparseArray.put(-99999985, Void.class);
        this.u.apply(sparseArray);
    }

    public void u(mv mvVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, mvVar);
        sparseArray.put(-99999987, 141103);
        sparseArray.put(-99999985, Void.class);
        this.u.apply(sparseArray);
    }
}
