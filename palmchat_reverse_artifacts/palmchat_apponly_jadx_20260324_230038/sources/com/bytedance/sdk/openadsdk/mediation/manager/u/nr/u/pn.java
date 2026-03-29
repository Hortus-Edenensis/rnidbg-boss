package com.bytedance.sdk.openadsdk.mediation.manager.u.nr.u;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import defpackage.ll7;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class pn extends nr {
    private SparseArray<Object> u;

    private SparseArray<Object> u() {
        return com.bytedance.sdk.openadsdk.my.b.u(super.values()).nr();
    }

    public abstract void destroy();

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.u.nr.u.nr
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
    @Override // com.bytedance.sdk.openadsdk.mediation.manager.u.nr.u.nr, java.util.function.Function
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
        if (iIntValue != 270007) {
            return super.apply(sparseArray);
        }
        destroy();
        return null;
    }
}
