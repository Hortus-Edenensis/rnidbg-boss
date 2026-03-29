package com.bytedance.sdk.openadsdk.my.fx.nr;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import defpackage.ll7;
import j$.util.function.Function$CC;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class fx implements Function<SparseArray<Object>, Object> {
    private SparseArray<Object> u;

    private SparseArray<Object> t() {
        com.bytedance.sdk.openadsdk.my.b bVarU = com.bytedance.sdk.openadsdk.my.b.u();
        bVarU.u(250001, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.my.fx.nr.fx.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public String get() {
                return fx.this.u();
            }
        }));
        bVarU.u(250002, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.my.fx.nr.fx.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public String get() {
                return fx.this.nr();
            }
        }));
        bVarU.u(250003, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.my.fx.nr.fx.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public String get() {
                return fx.this.fx();
            }
        }));
        bVarU.u(250004, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.my.fx.nr.fx.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public String get() {
                return fx.this.b();
            }
        }));
        bVarU.u(250006, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<Map<String, String>>() { // from class: com.bytedance.sdk.openadsdk.my.fx.nr.fx.5
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public Map<String, String> get() {
                return fx.this.pn();
            }
        }));
        bVarU.u(250005, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.my.fx.nr.fx.6
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public String get() {
                return fx.this.iz();
            }
        }));
        bVarU.u(250007, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.my.fx.nr.fx.7
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public String get() {
                return fx.this.x();
            }
        }));
        bVarU.u(250008, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.my.fx.nr.fx.8
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public String get() {
                return fx.this.n();
            }
        }));
        bVarU.u(250009, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.my.fx.nr.fx.9
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public String get() {
                return fx.this.a();
            }
        }));
        return bVarU.nr();
    }

    public abstract String a();

    @Override // java.util.function.Function
    public /* synthetic */ Function andThen(Function function) {
        return Function$CC.$default$andThen(this, function);
    }

    public abstract String b();

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }

    public abstract String fx();

    public abstract String iz();

    public SparseArray<Object> jk() {
        SparseArray<Object> sparseArray = this.u;
        if (sparseArray != null) {
            return sparseArray;
        }
        SparseArray<Object> sparseArrayT = t();
        this.u = sparseArrayT;
        return sparseArrayT;
    }

    public abstract String n();

    public abstract String nr();

    public abstract Map<String, String> pn();

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
        return jk();
    }

    public abstract String u();

    public abstract String x();
}
