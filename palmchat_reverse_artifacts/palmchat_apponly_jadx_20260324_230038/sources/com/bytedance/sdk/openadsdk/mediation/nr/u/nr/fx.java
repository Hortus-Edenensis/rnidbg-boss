package com.bytedance.sdk.openadsdk.mediation.nr.u.nr;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.IMediationNativeAdTokenCallback;
import com.bytedance.sdk.openadsdk.my.u.u.k;
import defpackage.wc7;
import j$.util.function.Function$CC;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx implements Function<SparseArray<Object>, Object> {
    private final IMediationNativeAdTokenCallback u;

    public fx(IMediationNativeAdTokenCallback iMediationNativeAdTokenCallback) {
        this.u = iMediationNativeAdTokenCallback;
    }

    @Override // java.util.function.Function
    public /* synthetic */ Function andThen(Function function) {
        return Function$CC.$default$andThen(this, function);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.u == null) {
            return null;
        }
        ValueSet valueSetA = wc7.k(sparseArray).a();
        switch (valueSetA.intValue(-99999987)) {
            case 270026:
                this.u.onAdTokenLoaded(valueSetA.stringValue(0), new com.bytedance.sdk.openadsdk.mediation.nr.u.u.fx(k.u(valueSetA.objectValue(1, Object.class))));
                return null;
            case 270027:
                this.u.onAdTokenLoadedFail(valueSetA.intValue(0), valueSetA.stringValue(1));
                return null;
            default:
                return null;
        }
    }
}
