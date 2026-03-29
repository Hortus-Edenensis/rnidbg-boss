package com.bytedance.sdk.openadsdk.my.fx.nr;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import defpackage.ll7;
import j$.util.function.Function$CC;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class u implements Function<SparseArray<Object>, Object> {
    private PluginValueSet u;

    private PluginValueSet b() {
        ll7 ll7VarB = ll7.b();
        ll7VarB.g(263001, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<Object>() { // from class: com.bytedance.sdk.openadsdk.my.fx.nr.u.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(u.this.u());
            }
        }));
        ll7VarB.g(263002, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.my.fx.nr.u.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public String get() {
                return u.this.nr();
            }
        }));
        return ll7VarB.a();
    }

    @Override // java.util.function.Function
    public /* synthetic */ Function andThen(Function function) {
        return Function$CC.$default$andThen(this, function);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }

    public PluginValueSet fx() {
        PluginValueSet pluginValueSet = this.u;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet pluginValueSetB = b();
        this.u = pluginValueSetB;
        return pluginValueSetB;
    }

    public abstract String nr();

    public abstract int u();

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetA = ll7.j(sparseArray).a();
        int iIntValue = pluginValueSetA.intValue(-99999987);
        pluginValueSetA.objectValue(-99999985, Class.class);
        if (iIntValue != -99999986) {
            return null;
        }
        return fx().sparseArray();
    }
}
