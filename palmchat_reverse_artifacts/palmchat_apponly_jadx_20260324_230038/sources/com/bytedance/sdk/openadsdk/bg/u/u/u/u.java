package com.bytedance.sdk.openadsdk.bg.u.u.u;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import defpackage.wc7;
import j$.util.function.Function$CC;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u implements Function<SparseArray<Object>, Object> {
    private final TTAdDislike.DislikeInteractionCallback u;

    public u(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        this.u = dislikeInteractionCallback;
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
            case 244101:
                this.u.onShow();
                return null;
            case 244102:
                this.u.onSelected(valueSetA.intValue(0), valueSetA.stringValue(1), valueSetA.booleanValue(2));
                return null;
            case 244103:
                this.u.onCancel();
                return null;
            default:
                return null;
        }
    }
}
