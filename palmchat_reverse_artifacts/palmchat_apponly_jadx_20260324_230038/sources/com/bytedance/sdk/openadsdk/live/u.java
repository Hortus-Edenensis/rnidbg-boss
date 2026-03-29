package com.bytedance.sdk.openadsdk.live;

import android.util.SparseArray;
import com.bytedance.android.live.base.api.callback.Callback;
import defpackage.wc7;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u implements Callback<Object> {
    private final Function<SparseArray<Object>, Object> u;

    public u(Function<SparseArray<Object>, Object> function) {
        this.u = function;
    }

    @Override // com.bytedance.android.live.base.api.callback.Callback
    public void invoke(Object obj) {
        if (this.u != null) {
            this.u.apply(wc7.b().h(0, obj).f(-99999987, 1).a().sparseArray());
        }
    }
}
