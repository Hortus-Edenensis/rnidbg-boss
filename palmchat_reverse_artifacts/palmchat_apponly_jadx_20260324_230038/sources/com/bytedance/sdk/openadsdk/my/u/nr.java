package com.bytedance.sdk.openadsdk.my.u;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.my.u.u.k;
import defpackage.wc7;
import j$.util.function.Function$CC;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr implements Function<SparseArray<Object>, Object> {
    private final TTAdNative.CSJSplashAdListener u;

    public nr(TTAdNative.CSJSplashAdListener cSJSplashAdListener) {
        this.u = cSJSplashAdListener;
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
            case 114102:
                this.u.onSplashLoadSuccess(new com.bytedance.sdk.openadsdk.my.u.u.nr(k.u(valueSetA.objectValue(0, Object.class))));
                return null;
            case 114103:
                this.u.onSplashLoadFail(new com.bytedance.sdk.openadsdk.my.u.u.u(k.u(valueSetA.objectValue(0, Object.class))));
                return null;
            case 114104:
                this.u.onSplashRenderSuccess(new com.bytedance.sdk.openadsdk.my.u.u.nr((Function) valueSetA.objectValue(0, Function.class)));
                return null;
            case 114105:
                this.u.onSplashRenderFail(new com.bytedance.sdk.openadsdk.my.u.u.nr(k.u(valueSetA.objectValue(0, Object.class))), new com.bytedance.sdk.openadsdk.my.u.u.u(k.u(valueSetA.objectValue(1, Object.class))));
                return null;
            default:
                return null;
        }
    }
}
