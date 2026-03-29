package com.bytedance.sdk.openadsdk.live.u;

import android.util.SparseArray;
import com.bytedance.android.live.base.api.ILiveHostActionParam;
import defpackage.wc7;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr implements ILiveHostActionParam {
    private Function<SparseArray<Object>, Object> u;

    public nr(Function<SparseArray<Object>, Object> function) {
        this.u = function;
    }

    @Override // com.bytedance.android.live.base.api.ILiveHostActionParam
    public void logEvent(boolean z, String str, String str2, Map<String, String> map) {
        if (this.u != null) {
            this.u.apply(wc7.b().j(0, z).i(1, str).i(2, str2).h(3, map).f(-99999987, 1).a().sparseArray());
        }
    }
}
