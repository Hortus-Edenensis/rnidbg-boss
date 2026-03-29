package com.bytedance.sdk.openadsdk.my.fx.nr;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import defpackage.ll7;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class jk extends mv {
    private SparseArray<Object> u;

    private SparseArray<Object> b() {
        com.bytedance.sdk.openadsdk.my.b bVarU = com.bytedance.sdk.openadsdk.my.b.u(super.u_());
        bVarU.u(160001, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<Double>() { // from class: com.bytedance.sdk.openadsdk.my.fx.nr.jk.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public Double get() {
                return Double.valueOf(jk.this.k_());
            }
        }));
        bVarU.u(160002, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<com.bytedance.sdk.openadsdk.c.u.nr.nr.u>() { // from class: com.bytedance.sdk.openadsdk.my.fx.nr.jk.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public com.bytedance.sdk.openadsdk.c.u.nr.nr.u get() {
                return jk.this.s();
            }
        }));
        bVarU.u(160003, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.my.fx.nr.jk.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(jk.this.l());
            }
        }));
        bVarU.u(160004, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.my.fx.nr.jk.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(jk.this.mv());
            }
        }));
        return bVarU.nr();
    }

    public abstract double k_();

    public abstract int l();

    public abstract int mv();

    public abstract com.bytedance.sdk.openadsdk.c.u.nr.nr.u s();

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.mv, com.bytedance.sdk.openadsdk.my.fx.nr.n, java.util.function.Function
    /* JADX INFO: renamed from: u */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetA = ll7.j(sparseArray).a();
        int iIntValue = pluginValueSetA.intValue(-99999987);
        pluginValueSetA.objectValue(-99999985, Class.class);
        switch (iIntValue) {
            case -99999986:
                return u_();
            case 140111:
                Function function = (Function) pluginValueSetA.objectValue(0, Function.class);
                u(pluginValueSetA.intValue(1) == 1 ? new com.bytedance.sdk.openadsdk.mediation.ad.u.nr.u.nr(function) : new com.bytedance.sdk.openadsdk.qq.u.nr.u.fx(function));
                return null;
            case 160101:
                u(new com.bytedance.sdk.openadsdk.c.u.nr.u.u((Function) pluginValueSetA.objectValue(0, Function.class)));
                return null;
            case 160102:
                u(new com.bytedance.sdk.openadsdk.c.u.nr.u.nr((Function) pluginValueSetA.objectValue(0, Function.class)));
                return null;
            default:
                return super.apply(sparseArray);
        }
    }

    public abstract void u(com.bytedance.sdk.openadsdk.c.u.nr.u.nr nrVar);

    public abstract void u(com.bytedance.sdk.openadsdk.c.u.nr.u.u uVar);

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.mv
    public SparseArray<Object> u_() {
        SparseArray<Object> sparseArray = this.u;
        if (sparseArray != null) {
            return sparseArray;
        }
        SparseArray<Object> sparseArrayB = b();
        this.u = sparseArrayB;
        return sparseArrayB;
    }
}
