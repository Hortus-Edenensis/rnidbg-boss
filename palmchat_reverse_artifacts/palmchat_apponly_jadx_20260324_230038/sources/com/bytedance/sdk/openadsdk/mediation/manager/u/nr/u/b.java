package com.bytedance.sdk.openadsdk.mediation.manager.u.nr.u;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import defpackage.ll7;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class b extends nr {
    private SparseArray<Object> u;

    private SparseArray<Object> u() {
        com.bytedance.sdk.openadsdk.my.b bVarU = com.bytedance.sdk.openadsdk.my.b.u(super.values());
        bVarU.u(270008, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.u.nr.u.b.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(b.this.hasDislike());
            }
        }));
        bVarU.u(270011, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.u.nr.u.b.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(b.this.isExpress());
            }
        }));
        return bVarU.nr();
    }

    public abstract boolean hasDislike();

    public abstract boolean isExpress();

    public abstract void onPause();

    public abstract void onResume();

    public abstract void setShakeViewListener(com.bytedance.sdk.openadsdk.mediation.ad.u.nr.u.fx fxVar);

    public abstract void setUseCustomVideo(boolean z);

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.sdk.openadsdk.mediation.manager.u.nr.u.nr, java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetA = ll7.j(sparseArray).a();
        int iIntValue = pluginValueSetA.intValue(-99999987);
        pluginValueSetA.objectValue(-99999985, Class.class);
        switch (iIntValue) {
            case -99999986:
                SparseArray<Object> sparseArray2 = this.u;
                if (sparseArray2 != null) {
                    return sparseArray2;
                }
                SparseArray<Object> sparseArrayU = u();
                this.u = sparseArrayU;
                return sparseArrayU;
            case 270009:
                setUseCustomVideo(pluginValueSetA.booleanValue(0));
                return null;
            case 270010:
                setShakeViewListener(new com.bytedance.sdk.openadsdk.mediation.ad.u.nr.u.fx((Function) pluginValueSetA.objectValue(0, Function.class)));
                return null;
            case 271048:
                onResume();
                return null;
            case 271049:
                onPause();
                return null;
            default:
                return super.apply(sparseArray);
        }
    }
}
