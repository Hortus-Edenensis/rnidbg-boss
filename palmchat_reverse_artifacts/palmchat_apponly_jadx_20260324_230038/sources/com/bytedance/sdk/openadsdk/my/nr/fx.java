package com.bytedance.sdk.openadsdk.my.nr;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import defpackage.wc7;
import j$.util.function.Function$CC;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx implements Function<SparseArray<Object>, Object> {
    private final Bridge u;

    public fx(Bridge bridge) {
        this.u = bridge;
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
        Object objCall;
        if (sparseArray == null || this.u == null) {
            return wc7.e.apply(sparseArray);
        }
        int iIntValue = ((Integer) sparseArray.get(-99999987)).intValue();
        Class cls = (Class) sparseArray.get(-99999985);
        if (iIntValue == -99999977) {
            Bridge bridge = this.u;
            return (!(bridge instanceof nr) || (objCall = bridge.call(-99999977, wc7.c, Object.class)) == null) ? this.u : objCall;
        }
        if (iIntValue != -99999986) {
            return com.bytedance.sdk.openadsdk.my.nr.fx.u.u(this.u.call(iIntValue, com.bytedance.sdk.openadsdk.my.nr.fx.u.nr(sparseArray), cls));
        }
        ValueSet valueSetValues = this.u.values();
        if (valueSetValues == null) {
            return null;
        }
        return new u(valueSetValues);
    }
}
