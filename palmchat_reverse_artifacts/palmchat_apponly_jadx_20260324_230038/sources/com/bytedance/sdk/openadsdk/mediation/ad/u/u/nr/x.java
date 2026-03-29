package com.bytedance.sdk.openadsdk.mediation.ad.u.u.nr;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationShakeViewListener;
import defpackage.wc7;
import j$.util.function.Function$CC;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class x implements Function<SparseArray<Object>, Object> {
    private final MediationShakeViewListener u;

    public x(MediationShakeViewListener mediationShakeViewListener) {
        this.u = mediationShakeViewListener;
    }

    @Override // java.util.function.Function
    public /* synthetic */ Function andThen(Function function) {
        return Function$CC.$default$andThen(this, function);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.u != null && wc7.k(sparseArray).a().intValue(-99999987) == 270012) {
            this.u.onDismissed();
        }
        return null;
    }
}
