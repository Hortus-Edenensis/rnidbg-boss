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
public abstract class t extends n {
    private PluginValueSet u;

    private PluginValueSet u() {
        ll7 ll7VarB = ll7.b();
        ll7VarB.g(130001, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.my.fx.nr.t.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(t.this.nr());
            }
        }));
        ll7VarB.g(130002, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<Map<String, Object>>() { // from class: com.bytedance.sdk.openadsdk.my.fx.nr.t.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public Map<String, Object> get() {
                return t.this.b();
            }
        }));
        ll7VarB.g(130003, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.my.fx.nr.t.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(t.this.pn());
            }
        }));
        ll7VarB.g(130004, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<Long>() { // from class: com.bytedance.sdk.openadsdk.my.fx.nr.t.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public Long get() {
                return Long.valueOf(t.this.iz());
            }
        }));
        return ll7VarB.a();
    }

    public abstract Map<String, Object> b();

    public abstract long iz();

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

    public abstract int pn();

    public abstract void u(Activity activity);

    public abstract void u(Activity activity, Object obj, String str);

    public abstract void u(com.bytedance.sdk.openadsdk.my.fx.u.fx fxVar);

    public abstract void u(com.bytedance.sdk.openadsdk.q.u.nr.u.u uVar);

    public abstract com.bytedance.sdk.openadsdk.mediation.manager.u.nr.u.fx x();

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.n, java.util.function.Function
    /* JADX INFO: renamed from: u */
    public Object apply(SparseArray<Object> sparseArray) {
        com.bytedance.sdk.openadsdk.q.u.nr.u.u uVar;
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetA = ll7.j(sparseArray).a();
        int iIntValue = pluginValueSetA.intValue(-99999987);
        if (iIntValue == -99999986) {
            return n().sparseArray();
        }
        if (iIntValue != 130106) {
            switch (iIntValue) {
                case 130101:
                    Function function = (Function) pluginValueSetA.objectValue(0, Function.class);
                    if (pluginValueSetA.intValue(1) == 1) {
                        uVar = new com.bytedance.sdk.openadsdk.mediation.nr.nr.u.u(function);
                    } else {
                        uVar = new com.bytedance.sdk.openadsdk.q.u.nr.u.u(function);
                    }
                    u(uVar);
                    return null;
                case 130102:
                    u(new com.bytedance.sdk.openadsdk.my.fx.u.fx((Function) pluginValueSetA.objectValue(0, Function.class)));
                    return null;
                case 130103:
                    u((Activity) pluginValueSetA.objectValue(0, Activity.class));
                    return null;
                case 130104:
                    u((Activity) pluginValueSetA.objectValue(0, Activity.class), pluginValueSetA.objectValue(1, Object.class), (String) pluginValueSetA.objectValue(2, String.class));
                    return null;
                default:
                    return super.apply(sparseArray);
            }
        }
        return x();
    }
}
