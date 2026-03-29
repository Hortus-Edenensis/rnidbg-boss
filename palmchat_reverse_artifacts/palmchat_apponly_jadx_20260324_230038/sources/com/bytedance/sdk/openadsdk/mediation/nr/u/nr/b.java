package com.bytedance.sdk.openadsdk.mediation.nr.u.nr;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo;
import defpackage.wc7;
import j$.util.function.Function$CC;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b implements Function<SparseArray<Object>, Object> {
    private final IMediationPreloadRequestInfo u;

    public b(IMediationPreloadRequestInfo iMediationPreloadRequestInfo) {
        this.u = iMediationPreloadRequestInfo;
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
        if (this.u == null) {
            return null;
        }
        switch (wc7.k(sparseArray).a().intValue(-99999987)) {
            case 271044:
                return Integer.class.cast(Integer.valueOf(this.u.getAdType()));
            case 271045:
                SparseArray<Object> sparseArrayU = com.bytedance.sdk.openadsdk.my.u.fx.nr.u(this.u.getAdSlot());
                return sparseArrayU != null ? sparseArrayU : new SparseArray();
            case 271046:
                return this.u.getPrimeRitList();
            default:
                return wc7.e.apply(sparseArray);
        }
    }
}
