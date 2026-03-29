package com.bytedance.sdk.openadsdk.core.bc;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import defpackage.ll7;
import j$.util.function.Function$CC;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class b implements Function<SparseArray<Object>, Object> {
    @Override // java.util.function.Function
    public /* synthetic */ Function andThen(Function function) {
        return Function$CC.$default$andThen(this, function);
    }

    public abstract <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls);

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }

    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        PluginValueSet pluginValueSetA = ll7.j(sparseArray).a();
        return applyFunction(pluginValueSetA.intValue(-99999987, 0), pluginValueSetA, (Class) pluginValueSetA.objectValue(-99999985, Class.class));
    }
}
