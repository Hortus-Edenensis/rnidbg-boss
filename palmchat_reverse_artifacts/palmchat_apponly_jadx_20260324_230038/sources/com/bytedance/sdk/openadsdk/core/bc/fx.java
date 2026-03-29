package com.bytedance.sdk.openadsdk.core.bc;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.d;
import defpackage.ll7;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx {
    private nr nr;
    private final Function<SparseArray<Object>, Object> u;

    public fx(Function<SparseArray<Object>, Object> function) {
        this.u = function;
    }

    public void u(int i, SparseArray<Object> sparseArray) {
        if ((ll7.j(sparseArray).a().booleanValue(-999903) && i == 8001 && this.nr != null) || this.u == null) {
            return;
        }
        this.u.apply(com.bytedance.sdk.openadsdk.my.fx.b.u(d.fx) ? com.bytedance.sdk.openadsdk.my.b.u(sparseArray).u(i).u(Void.class).nr() : com.bytedance.sdk.openadsdk.my.b.u().u(i).u(Void.class).u(-99999979, sparseArray).nr());
    }
}
