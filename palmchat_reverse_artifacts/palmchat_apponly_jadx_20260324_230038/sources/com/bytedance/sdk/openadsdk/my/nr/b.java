package com.bytedance.sdk.openadsdk.my.nr;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.EventListener;
import j$.util.function.Function$CC;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b implements Function<SparseArray<Object>, Object> {
    private EventListener u;

    public b(EventListener eventListener) {
        this.u = eventListener;
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
        if (sparseArray == null || this.u == null) {
            return null;
        }
        return this.u.onEvent(((Integer) sparseArray.get(-99999987)).intValue(), com.bytedance.sdk.openadsdk.my.nr.fx.u.u((SparseArray<Object>) sparseArray.get(-99999979)));
    }
}
