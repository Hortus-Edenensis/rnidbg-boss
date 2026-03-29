package com.bytedance.sdk.openadsdk.my.u.nr;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import defpackage.wc7;
import j$.util.function.Function$CC;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr implements Function<SparseArray<Object>, Object> {
    private final TTAdInteractionListener u;

    public nr(TTAdInteractionListener tTAdInteractionListener) {
        this.u = tTAdInteractionListener;
    }

    @Override // java.util.function.Function
    public /* synthetic */ Function andThen(Function function) {
        return Function$CC.$default$andThen(this, function);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.u == null) {
            return null;
        }
        ValueSet valueSetA = wc7.k(sparseArray).a();
        if (valueSetA.intValue(-99999987) == 100101) {
            this.u.onAdEvent(valueSetA.intValue(0), (Map) valueSetA.objectValue(1, Map.class));
        }
        return null;
    }
}
