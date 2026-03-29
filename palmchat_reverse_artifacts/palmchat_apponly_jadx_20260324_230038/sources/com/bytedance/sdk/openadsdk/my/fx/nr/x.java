package com.bytedance.sdk.openadsdk.my.fx.nr;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import defpackage.ll7;
import j$.util.function.Function$CC;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class x implements Function<SparseArray<Object>, Object> {
    @Override // java.util.function.Function
    public /* synthetic */ Function andThen(Function function) {
        return Function$CC.$default$andThen(this, function);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }

    public abstract boolean fx();

    public abstract void nr();

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
            case 240101:
                u();
                return null;
            case 240102:
                u(new com.bytedance.sdk.openadsdk.bg.u.nr.u.u((Function) pluginValueSetA.objectValue(0, Function.class)));
                return null;
            case 240103:
                u((String) pluginValueSetA.objectValue(0, String.class));
                return null;
            case 240104:
                nr();
                return null;
            case 240105:
                return Boolean.class.cast(Boolean.valueOf(fx()));
            default:
                return null;
        }
    }

    public abstract void u();

    public abstract void u(com.bytedance.sdk.openadsdk.bg.u.nr.u.u uVar);

    public abstract void u(String str);
}
