package com.bytedance.sdk.openadsdk.qq.u.u.u;

import android.util.SparseArray;
import android.view.View;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.my.u.u.k;
import com.bytedance.sdk.openadsdk.my.u.u.l;
import defpackage.wc7;
import j$.util.function.Function$CC;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u implements Function<SparseArray<Object>, Object> {
    private final TTNativeAd.AdInteractionListener nr;
    private final ValueSet u = wc7.c;

    public u(TTNativeAd.AdInteractionListener adInteractionListener) {
        this.nr = adInteractionListener;
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
            case 141101:
                this.nr.onAdClicked((View) valueSetA.objectValue(0, View.class), new l(k.u(valueSetA.objectValue(1, Object.class))));
                return null;
            case 141102:
                this.nr.onAdCreativeClick((View) valueSetA.objectValue(0, View.class), new l(k.u(valueSetA.objectValue(1, Object.class))));
                return null;
            case 141103:
                this.nr.onAdShow(new l(k.u(valueSetA.objectValue(0, Object.class))));
                return null;
            default:
                return null;
        }
    }
}
