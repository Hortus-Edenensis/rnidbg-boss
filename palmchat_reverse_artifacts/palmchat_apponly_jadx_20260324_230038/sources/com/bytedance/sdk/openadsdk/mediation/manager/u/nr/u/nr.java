package com.bytedance.sdk.openadsdk.mediation.manager.u.nr.u;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import defpackage.ll7;
import j$.util.function.Function$CC;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class nr implements Function<SparseArray<Object>, Object> {
    private SparseArray<Object> u;

    private SparseArray<Object> u() {
        return com.bytedance.sdk.openadsdk.my.b.u().nr();
    }

    @Override // java.util.function.Function
    public /* synthetic */ Function andThen(Function function) {
        return Function$CC.$default$andThen(this, function);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }

    public abstract List<Object> getAdLoadInfo();

    public abstract u getBestEcpm();

    public abstract List<u> getCacheList();

    public abstract List<u> getMultiBiddingEcpm();

    public abstract u getShowEcpm();

    public abstract boolean isReady();

    public SparseArray<Object> values() {
        SparseArray<Object> sparseArray = this.u;
        if (sparseArray != null) {
            return sparseArray;
        }
        SparseArray<Object> sparseArrayU = u();
        this.u = sparseArrayU;
        return sparseArrayU;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetA = ll7.j(sparseArray).a();
        int iIntValue = pluginValueSetA.intValue(-99999987);
        pluginValueSetA.objectValue(-99999985, Class.class);
        if (iIntValue == -99999986) {
            return values();
        }
        switch (iIntValue) {
        }
        return null;
    }
}
