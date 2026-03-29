package com.bytedance.sdk.openadsdk.my.fx.nr;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import defpackage.ll7;
import j$.util.function.Function$CC;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class b implements Function<SparseArray<Object>, Object> {
    private SparseArray<Object> u;

    private SparseArray<Object> fx() {
        com.bytedance.sdk.openadsdk.my.b bVarU = com.bytedance.sdk.openadsdk.my.b.u();
        bVarU.u(243001, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<List<iz>>() { // from class: com.bytedance.sdk.openadsdk.my.fx.nr.b.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public List<iz> get() {
                return b.this.u();
            }
        }));
        return bVarU.nr();
    }

    @Override // java.util.function.Function
    public /* synthetic */ Function andThen(Function function) {
        return Function$CC.$default$andThen(this, function);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }

    public SparseArray<Object> nr() {
        SparseArray<Object> sparseArray = this.u;
        if (sparseArray != null) {
            return sparseArray;
        }
        SparseArray<Object> sparseArrayFx = fx();
        this.u = sparseArrayFx;
        return sparseArrayFx;
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetA = ll7.j(sparseArray).a();
        int iIntValue = pluginValueSetA.intValue(-99999987);
        pluginValueSetA.objectValue(-99999985, Class.class);
        if (iIntValue != -99999986) {
            return null;
        }
        return nr();
    }

    public abstract List<iz> u();
}
