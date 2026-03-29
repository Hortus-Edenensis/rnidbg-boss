package com.bytedance.sdk.openadsdk.my.fx.nr;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import defpackage.ll7;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class a extends jk {
    private SparseArray<Object> u;

    private SparseArray<Object> b() {
        return super.u_();
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.jk, com.bytedance.sdk.openadsdk.my.fx.nr.mv, com.bytedance.sdk.openadsdk.my.fx.nr.n, java.util.function.Function
    /* JADX INFO: renamed from: u */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetA = ll7.j(sparseArray).a();
        int iIntValue = pluginValueSetA.intValue(-99999987);
        pluginValueSetA.objectValue(-99999985, Class.class);
        if (iIntValue == -99999986) {
            return u_();
        }
        if (iIntValue != 140111) {
            switch (iIntValue) {
                case 170101:
                    u(pluginValueSetA.booleanValue(0));
                    break;
                case 170102:
                    u((Bitmap) pluginValueSetA.objectValue(0, Bitmap.class), pluginValueSetA.intValue(1));
                    break;
                case 170103:
                    u(new com.bytedance.sdk.openadsdk.dw.u.nr.u.u((Function) pluginValueSetA.objectValue(0, Function.class)));
                    break;
                default:
                    return super.apply(sparseArray);
            }
        } else {
            Function function = (Function) pluginValueSetA.objectValue(0, Function.class);
            u(pluginValueSetA.intValue(1) == 1 ? new com.bytedance.sdk.openadsdk.mediation.ad.u.nr.u.nr(function) : new com.bytedance.sdk.openadsdk.qq.u.nr.u.fx(function));
        }
        return null;
    }

    public abstract void u(Bitmap bitmap, int i);

    public abstract void u(com.bytedance.sdk.openadsdk.dw.u.nr.u.u uVar);

    public abstract void u(boolean z);

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.jk, com.bytedance.sdk.openadsdk.my.fx.nr.mv
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
