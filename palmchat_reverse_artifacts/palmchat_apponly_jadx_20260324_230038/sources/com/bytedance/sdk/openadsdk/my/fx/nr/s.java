package com.bytedance.sdk.openadsdk.my.fx.nr;

import android.app.Activity;
import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import defpackage.ll7;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class s extends n {
    private PluginValueSet u;

    private PluginValueSet x() {
        ll7 ll7VarB = ll7.b();
        ll7VarB.g(150001, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<View>() { // from class: com.bytedance.sdk.openadsdk.my.fx.nr.s.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public View get() {
                return s.this.u();
            }
        }));
        ll7VarB.g(150002, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.my.fx.nr.s.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(s.this.nr());
            }
        }));
        ll7VarB.g(150003, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<b>() { // from class: com.bytedance.sdk.openadsdk.my.fx.nr.s.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public b get() {
                return s.this.fx();
            }
        }));
        ll7VarB.g(150004, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.my.fx.nr.s.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(s.this.b());
            }
        }));
        ll7VarB.g(150005, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<Map<String, Object>>() { // from class: com.bytedance.sdk.openadsdk.my.fx.nr.s.5
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public Map<String, Object> get() {
                return s.this.n();
            }
        }));
        return ll7VarB.a();
    }

    public abstract com.bytedance.sdk.openadsdk.mediation.manager.u.nr.u.b a();

    public abstract int b();

    public abstract b fx();

    public abstract void iz();

    public abstract void jk();

    public PluginValueSet l() {
        PluginValueSet pluginValueSet = this.u;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet pluginValueSetX = x();
        this.u = pluginValueSetX;
        return pluginValueSetX;
    }

    public abstract Map<String, Object> n();

    public abstract int nr();

    public abstract void pn();

    public abstract View u();

    public abstract x u(Activity activity);

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
            return l().sparseArray();
        }
        switch (iIntValue) {
            case 150101:
                u(new com.bytedance.sdk.openadsdk.kj.u.nr.u.nr((Function) pluginValueSetA.objectValue(0, Function.class)));
                return null;
            case 150102:
                u(new com.bytedance.sdk.openadsdk.kj.u.nr.u.u((Function) pluginValueSetA.objectValue(0, Function.class)));
                return null;
            case 150103:
                u(new com.bytedance.sdk.openadsdk.my.fx.u.fx((Function) pluginValueSetA.objectValue(0, Function.class)));
                return null;
            case 150104:
                pn();
                return null;
            case 150105:
                iz();
                return null;
            case 150106:
                u((Activity) pluginValueSetA.objectValue(0, Activity.class), new com.bytedance.sdk.openadsdk.bg.u.nr.u.u((Function) pluginValueSetA.objectValue(1, Function.class)));
                return null;
            case 150107:
                Dialog dialog = (Dialog) pluginValueSetA.objectValue(0, Dialog.class);
                Integer[] numArr = (Integer[]) pluginValueSetA.arrayValue(1, Integer.class);
                if (numArr == null) {
                    numArr = new Integer[0];
                }
                u(dialog, numArr);
                return null;
            case 150108:
                return u((Activity) pluginValueSetA.objectValue(0, Activity.class));
            case 150109:
                pluginValueSetA.objectValue(0, Activity.class);
                return null;
            case 150110:
                u(pluginValueSetA.intValue(0));
                return null;
            case 150111:
                u(new com.bytedance.sdk.openadsdk.kj.u.nr.u.fx((Function) pluginValueSetA.objectValue(0, Function.class)));
                return null;
            case 150112:
                u(pluginValueSetA.booleanValue(0));
                return null;
            case 150113:
                return a();
            case 150114:
                u((String) pluginValueSetA.objectValue(0, String.class));
                return null;
            case 150115:
                u((JSONObject) pluginValueSetA.objectValue(0, JSONObject.class));
                return null;
            case 150116:
                jk();
                return null;
            default:
                return super.apply(sparseArray);
        }
    }

    public abstract void u(int i);

    public abstract void u(Activity activity, com.bytedance.sdk.openadsdk.bg.u.nr.u.u uVar);

    public abstract void u(Dialog dialog, Integer[] numArr);

    public abstract void u(com.bytedance.sdk.openadsdk.kj.u.nr.u.fx fxVar);

    public abstract void u(com.bytedance.sdk.openadsdk.kj.u.nr.u.nr nrVar);

    public abstract void u(com.bytedance.sdk.openadsdk.kj.u.nr.u.u uVar);

    public abstract void u(com.bytedance.sdk.openadsdk.my.fx.u.fx fxVar);

    public abstract void u(String str);

    public abstract void u(JSONObject jSONObject);

    public abstract void u(boolean z);
}
