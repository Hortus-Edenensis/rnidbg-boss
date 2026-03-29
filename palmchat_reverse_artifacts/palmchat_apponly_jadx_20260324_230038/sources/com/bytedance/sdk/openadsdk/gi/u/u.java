package com.bytedance.sdk.openadsdk.gi.u;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.my.b;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private static Function<SparseArray<Object>, Object> u;

    public static void u(Function<SparseArray<Object>, Object> function) {
        u = function;
    }

    public static void u(boolean z) {
        if (u != null) {
            b bVarU = b.u();
            bVarU.u(10000).u(Void.class);
            bVarU.u(20000, Boolean.valueOf(z));
            u.apply(bVarU.nr());
        }
    }
}
