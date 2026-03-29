package com.bytedance.sdk.openadsdk.mediation.ad.u.u.nr;

import android.util.SparseArray;
import android.view.View;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener;
import defpackage.wc7;
import j$.util.function.Function$CC;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz implements Function<SparseArray<Object>, Object> {
    private final MediationExpressRenderListener u;

    public iz(MediationExpressRenderListener mediationExpressRenderListener) {
        this.u = mediationExpressRenderListener;
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
            case 142101:
                this.u.onRenderSuccess((View) valueSetA.objectValue(0, View.class), valueSetA.floatValue(1), valueSetA.floatValue(2), valueSetA.booleanValue(3));
                return null;
            case 142102:
                this.u.onRenderFail((View) valueSetA.objectValue(0, View.class), valueSetA.stringValue(1), valueSetA.intValue(2));
                return null;
            case 142103:
                this.u.onAdClick();
                return null;
            case 142104:
                this.u.onAdShow();
                return null;
            default:
                return null;
        }
    }
}
