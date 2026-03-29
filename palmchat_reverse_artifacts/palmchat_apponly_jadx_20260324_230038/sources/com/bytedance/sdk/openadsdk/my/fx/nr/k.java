package com.bytedance.sdk.openadsdk.my.fx.nr;

import android.app.Activity;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import defpackage.ll7;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class k extends n {
    private PluginValueSet u;

    private PluginValueSet u() {
        ll7 ll7VarB = ll7.b();
        ll7VarB.g(120001, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.my.fx.nr.k.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(k.this.nr());
            }
        }));
        ll7VarB.g(120002, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<Map<String, Object>>() { // from class: com.bytedance.sdk.openadsdk.my.fx.nr.k.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public Map<String, Object> get() {
                return k.this.x();
            }
        }));
        ll7VarB.g(120003, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.my.fx.nr.k.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(k.this.fx());
            }
        }));
        ll7VarB.g(120004, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<Long>() { // from class: com.bytedance.sdk.openadsdk.my.fx.nr.k.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public Long get() {
                return Long.valueOf(k.this.b());
            }
        }));
        return ll7VarB.a();
    }

    public abstract long b();

    public abstract int fx();

    public PluginValueSet n() {
        PluginValueSet pluginValueSet = this.u;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet pluginValueSetU = u();
        this.u = pluginValueSetU;
        return pluginValueSetU;
    }

    public abstract int nr();

    public abstract void nr(com.bytedance.sdk.openadsdk.z.u.nr.u.u uVar);

    public abstract com.bytedance.sdk.openadsdk.mediation.manager.u.nr.u.pn pn();

    public abstract void u(Activity activity);

    public abstract void u(Activity activity, Object obj, String str);

    public abstract void u(com.bytedance.sdk.openadsdk.my.fx.u.fx fxVar);

    public abstract void u(com.bytedance.sdk.openadsdk.z.u.nr.u.nr nrVar);

    public abstract void u(com.bytedance.sdk.openadsdk.z.u.nr.u.u uVar);

    public abstract Map<String, Object> x();

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.n, java.util.function.Function
    /* JADX INFO: renamed from: u */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetA = ll7.j(sparseArray).a();
        int iIntValue = pluginValueSetA.intValue(-99999987);
        pluginValueSetA.objectValue(-99999985, Class.class);
        if (iIntValue == -99999986) {
            return n().sparseArray();
        }
        if (iIntValue != 121109) {
            switch (iIntValue) {
                case 120101:
                    u(new com.bytedance.sdk.openadsdk.z.u.nr.u.u((Function) pluginValueSetA.objectValue(0, Function.class)));
                    return null;
                case 120102:
                    nr(new com.bytedance.sdk.openadsdk.z.u.nr.u.u((Function) pluginValueSetA.objectValue(0, Function.class)));
                    return null;
                case 120103:
                    u(new com.bytedance.sdk.openadsdk.z.u.nr.u.nr((Function) pluginValueSetA.objectValue(0, Function.class)));
                    return null;
                case 120104:
                    u(new com.bytedance.sdk.openadsdk.my.fx.u.fx((Function) pluginValueSetA.objectValue(0, Function.class)));
                    return null;
                case 120105:
                    u((Activity) pluginValueSetA.objectValue(0, Activity.class));
                    return null;
                case 120106:
                    u((Activity) pluginValueSetA.objectValue(0, Activity.class), pluginValueSetA.objectValue(1, Object.class), (String) pluginValueSetA.objectValue(2, String.class));
                    return null;
                default:
                    return super.apply(sparseArray);
            }
        }
        return pn();
    }
}
