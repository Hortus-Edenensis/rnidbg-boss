package com.bytedance.sdk.openadsdk.kj.u.nr.u;

import android.util.SparseArray;
import defpackage.ll7;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u extends nr {
    private final Function<SparseArray<Object>, Object> u;

    public u(Function<SparseArray<Object>, Object> function) {
        super(function);
        this.u = function == null ? ll7.d : function;
    }
}
