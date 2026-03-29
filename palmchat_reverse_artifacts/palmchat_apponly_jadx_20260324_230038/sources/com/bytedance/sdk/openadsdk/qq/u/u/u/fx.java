package com.bytedance.sdk.openadsdk.qq.u.u.u;

import android.util.SparseArray;
import android.view.View;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import defpackage.wc7;
import j$.util.function.Function$CC;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx implements Function<SparseArray<Object>, Object> {
    private final TTNativeAd.ExpressRenderListener u;

    public fx(TTNativeAd.ExpressRenderListener expressRenderListener) {
        this.u = expressRenderListener;
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
        ValueSet valueSetA = wc7.k(sparseArray).a();
        if (valueSetA.intValue(-99999987) == 142101) {
            this.u.onRenderSuccess((View) valueSetA.objectValue(0, View.class), valueSetA.floatValue(1), valueSetA.floatValue(2), valueSetA.booleanValue(3));
        }
        return null;
    }
}
