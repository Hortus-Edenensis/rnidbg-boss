package com.bytedance.sdk.openadsdk.my.fx.nr;

import android.app.Activity;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import defpackage.ll7;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class nr extends n {
    private PluginValueSet u;

    private PluginValueSet u() {
        ll7 ll7VarB = ll7.b();
        ll7VarB.g(110001, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<View>() { // from class: com.bytedance.sdk.openadsdk.my.fx.nr.nr.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public View get() {
                return nr.this.k();
            }
        }));
        ll7VarB.g(110003, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<View>() { // from class: com.bytedance.sdk.openadsdk.my.fx.nr.nr.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public View get() {
                return nr.this.o();
            }
        }));
        ll7VarB.g(110004, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.my.fx.nr.nr.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(nr.this.sx());
            }
        }));
        ll7VarB.g(110005, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<Map<String, Object>>() { // from class: com.bytedance.sdk.openadsdk.my.fx.nr.nr.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public Map<String, Object> get() {
                return nr.this.dw();
            }
        }));
        return ll7VarB.a();
    }

    public abstract void bg();

    public abstract com.bytedance.sdk.openadsdk.mediation.manager.u.nr.u.iz bq();

    public abstract Map<String, Object> dw();

    public abstract View k();

    public PluginValueSet n() {
        PluginValueSet pluginValueSet = this.u;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet pluginValueSetU = u();
        this.u = pluginValueSetU;
        return pluginValueSetU;
    }

    public abstract View o();

    public abstract int sx();

    public abstract void u(ViewGroup viewGroup);

    public abstract void u(ViewGroup viewGroup, Activity activity);

    public abstract void u(com.bytedance.sdk.openadsdk.b.u.nr.u.nr nrVar);

    public abstract void u(com.bytedance.sdk.openadsdk.b.u.nr.u.u uVar);

    public abstract void u(com.bytedance.sdk.openadsdk.my.fx.u.fx fxVar);

    public abstract String z();

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.n, java.util.function.Function
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
                return n().sparseArray();
            case 110101:
                bg();
                return null;
            case 110102:
                u(new com.bytedance.sdk.openadsdk.my.fx.u.fx((Function) pluginValueSetA.objectValue(0, Function.class)));
                return null;
            case 110103:
                u(new com.bytedance.sdk.openadsdk.b.u.nr.u.u((Function) pluginValueSetA.objectValue(0, Function.class)));
                return null;
            case 110106:
                u(new com.bytedance.sdk.openadsdk.b.u.nr.u.nr((Function) pluginValueSetA.objectValue(0, Function.class)));
                return null;
            case 110108:
                u((ViewGroup) pluginValueSetA.objectValue(0, ViewGroup.class));
                return null;
            case 110109:
                u((ViewGroup) pluginValueSetA.objectValue(0, ViewGroup.class), (Activity) pluginValueSetA.objectValue(1, Activity.class));
                return null;
            case 110110:
                return bq();
            default:
                return super.apply(sparseArray);
        }
    }
}
