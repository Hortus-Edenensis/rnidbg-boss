package com.bytedance.sdk.openadsdk.fx;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.fx.u;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr implements u.InterfaceC0308u {
    private Function<SparseArray<Object>, Object> u;

    public nr(Function<SparseArray<Object>, Object> function) {
        this.u = function;
    }

    @Override // com.bytedance.sdk.openadsdk.fx.u.InterfaceC0308u
    public void nr() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 1);
        Function<SparseArray<Object>, Object> function = this.u;
        if (function != null) {
            function.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.fx.u.InterfaceC0308u
    public void u() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 0);
        Function<SparseArray<Object>, Object> function = this.u;
        if (function != null) {
            function.apply(sparseArray);
        }
    }
}
