package com.bytedance.sdk.openadsdk.c.u.nr.nr;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import defpackage.ll7;
import j$.util.function.Function$CC;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class u implements Function<SparseArray<Object>, Object> {
    private PluginValueSet u;

    private PluginValueSet iz() {
        return ll7.b().a();
    }

    @Override // java.util.function.Function
    public /* synthetic */ Function andThen(Function function) {
        return Function$CC.$default$andThen(this, function);
    }

    public abstract void b();

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }

    public abstract void fx();

    public abstract void fx(long j);

    public abstract void nr();

    public abstract void nr(long j);

    public PluginValueSet pn() {
        PluginValueSet pluginValueSet = this.u;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet pluginValueSetIz = iz();
        this.u = pluginValueSetIz;
        return pluginValueSetIz;
    }

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
            return pn().sparseArray();
        }
        switch (iIntValue) {
            case 162101:
                return u();
            case 162102:
                nr();
                return null;
            case 162103:
                u(pluginValueSetA.longValue(0));
                return null;
            case 162104:
                nr(pluginValueSetA.longValue(0));
                return null;
            case 162105:
                fx();
                return null;
            case 162106:
                fx(pluginValueSetA.longValue(0));
                return null;
            case 162107:
                b();
                return null;
            case 162108:
                u(pluginValueSetA.intValue(0), pluginValueSetA.intValue(1));
                return null;
            case 162109:
                u(pluginValueSetA.longValue(0), pluginValueSetA.intValue(1), pluginValueSetA.intValue(2));
                return null;
            default:
                return null;
        }
    }

    public abstract String u();

    public abstract void u(int i, int i2);

    public abstract void u(long j);

    public abstract void u(long j, int i, int i2);
}
