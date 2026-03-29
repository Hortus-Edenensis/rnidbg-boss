package com.bytedance.sdk.openadsdk.mediation.ad.u.u.nr;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback;
import defpackage.wc7;
import j$.util.function.Function$CC;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr implements Function<SparseArray<Object>, Object> {
    private final IMediationDislikeCallback u;

    public nr(IMediationDislikeCallback iMediationDislikeCallback) {
        this.u = iMediationDislikeCallback;
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
            case 268013:
                this.u.onSelected(valueSetA.intValue(0), valueSetA.stringValue(1));
                return null;
            case 268014:
                this.u.onCancel();
                return null;
            case 268015:
                this.u.onShow();
                return null;
            default:
                return null;
        }
    }
}
