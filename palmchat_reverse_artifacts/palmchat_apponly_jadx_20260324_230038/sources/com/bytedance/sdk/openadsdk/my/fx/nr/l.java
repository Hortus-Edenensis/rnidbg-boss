package com.bytedance.sdk.openadsdk.my.fx.nr;

import android.util.SparseArray;
import defpackage.ll7;
import j$.util.function.Function$CC;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class l implements Function<SparseArray<Object>, Object> {
    private SparseArray<Object> u;

    private SparseArray<Object> x() {
        com.bytedance.sdk.openadsdk.my.b bVarU = com.bytedance.sdk.openadsdk.my.b.u();
        bVarU.u(230002, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.my.fx.nr.l.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(l.this.u());
            }
        }));
        bVarU.u(230001, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.my.fx.nr.l.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(l.this.nr());
            }
        }));
        bVarU.u(230003, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.my.fx.nr.l.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public String get() {
                return l.this.fx();
            }
        }));
        bVarU.u(230004, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<Double>() { // from class: com.bytedance.sdk.openadsdk.my.fx.nr.l.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public Double get() {
                return Double.valueOf(l.this.b());
            }
        }));
        bVarU.u(230005, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.my.fx.nr.l.5
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(l.this.pn());
            }
        }));
        return bVarU.nr();
    }

    @Override // java.util.function.Function
    public /* synthetic */ Function andThen(Function function) {
        return Function$CC.$default$andThen(this, function);
    }

    public abstract double b();

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }

    public abstract String fx();

    public SparseArray<Object> iz() {
        SparseArray<Object> sparseArray = this.u;
        if (sparseArray != null) {
            return sparseArray;
        }
        SparseArray<Object> sparseArrayX = x();
        this.u = sparseArrayX;
        return sparseArrayX;
    }

    public abstract int nr();

    public abstract boolean pn();

    public abstract int u();

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray != null && ll7.j(sparseArray).a().intValue(-99999987) == -99999986) {
            return iz();
        }
        return null;
    }
}
