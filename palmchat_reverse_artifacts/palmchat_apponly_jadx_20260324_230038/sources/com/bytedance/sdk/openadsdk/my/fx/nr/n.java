package com.bytedance.sdk.openadsdk.my.fx.nr;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import defpackage.ll7;
import j$.util.function.Function$CC;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class n implements Function<SparseArray<Object>, Object> {
    @Override // java.util.function.Function
    public /* synthetic */ Function andThen(Function function) {
        return Function$CC.$default$andThen(this, function);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }

    public abstract void nr(Double d);

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetA = ll7.j(sparseArray).a();
        int iIntValue = pluginValueSetA.intValue(-99999987);
        pluginValueSetA.objectValue(-99999985, Class.class);
        if (iIntValue == -99999986) {
            return new SparseArray();
        }
        switch (iIntValue) {
            case 210101:
                u(Double.valueOf(pluginValueSetA.doubleValue(0)));
                return null;
            case 210102:
                u(Double.valueOf(pluginValueSetA.doubleValue(0)), (String) pluginValueSetA.objectValue(1, String.class), (String) pluginValueSetA.objectValue(2, String.class));
                return null;
            case 210103:
                nr(Double.valueOf(pluginValueSetA.doubleValue(0)));
                return null;
            case 210104:
                u(new com.bytedance.sdk.openadsdk.my.fx.u.nr((Function) pluginValueSetA.objectValue(0, Function.class)));
                return null;
            default:
                return null;
        }
    }

    public abstract void u(com.bytedance.sdk.openadsdk.my.fx.u.nr nrVar);

    public abstract void u(Double d);

    public abstract void u(Double d, String str, String str2);
}
