package com.bytedance.sdk.openadsdk.kj.u.u.u;

import android.util.SparseArray;
import android.view.View;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import defpackage.wc7;
import j$.util.function.Function$CC;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr implements Function<SparseArray<Object>, Object> {
    private final TTNativeExpressAd.ExpressAdInteractionListener nr;
    private final ValueSet u = wc7.c;

    public nr(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        this.nr = expressAdInteractionListener;
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
        if (this.nr == null) {
            return null;
        }
        ValueSet valueSetA = wc7.k(sparseArray).a();
        switch (valueSetA.intValue(-99999987)) {
            case 151101:
                this.nr.onAdClicked((View) valueSetA.objectValue(0, View.class), valueSetA.intValue(1));
                return null;
            case 151102:
                this.nr.onAdShow((View) valueSetA.objectValue(0, View.class), valueSetA.intValue(1));
                return null;
            case 151103:
                this.nr.onRenderFail((View) valueSetA.objectValue(0, View.class), valueSetA.stringValue(1), valueSetA.intValue(2));
                return null;
            case 151104:
                this.nr.onRenderSuccess((View) valueSetA.objectValue(0, View.class), valueSetA.floatValue(1), valueSetA.floatValue(2));
                return null;
            default:
                return null;
        }
    }
}
