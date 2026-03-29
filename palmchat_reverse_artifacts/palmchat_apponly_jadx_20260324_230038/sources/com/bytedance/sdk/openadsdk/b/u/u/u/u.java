package com.bytedance.sdk.openadsdk.b.u.u.u;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.CSJSplashAd;
import com.bytedance.sdk.openadsdk.my.u.u.k;
import defpackage.wc7;
import j$.util.function.Function$CC;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u implements Function<SparseArray<Object>, Object> {
    private final CSJSplashAd.SplashAdListener u;

    public u(CSJSplashAd.SplashAdListener splashAdListener) {
        this.u = splashAdListener;
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
        if (this.u != null && sparseArray != null) {
            ValueSet valueSetA = wc7.k(sparseArray).a();
            switch (valueSetA.intValue(-99999987)) {
                case 111101:
                    this.u.onSplashAdShow(new com.bytedance.sdk.openadsdk.my.u.u.nr(k.u(valueSetA.objectValue(0, Object.class))));
                    break;
                case 111102:
                    this.u.onSplashAdClick(new com.bytedance.sdk.openadsdk.my.u.u.nr(k.u(valueSetA.objectValue(0, Object.class))));
                    break;
                case 111103:
                    this.u.onSplashAdClose(new com.bytedance.sdk.openadsdk.my.u.u.nr(k.u(valueSetA.objectValue(0, Object.class))), valueSetA.intValue(1));
                    break;
            }
        }
        return null;
    }
}
