package com.bytedance.sdk.openadsdk.bq.u.u.u;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.my.u.u.jk;
import defpackage.wc7;
import j$.util.function.Function$CC;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx implements Function<SparseArray<Object>, Object> {
    private final TTAdNative.FullScreenVideoAdListener u;

    public fx(TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
        this.u = fullScreenVideoAdListener;
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
            case 132101:
                this.u.onError(valueSetA.intValue(0), valueSetA.stringValue(1));
                return null;
            case 132102:
                this.u.onFullScreenVideoAdLoad(new jk((Function) valueSetA.objectValue(0, Function.class)));
                return null;
            case 132103:
                this.u.onFullScreenVideoCached(new jk((Function) valueSetA.objectValue(0, Function.class)));
                return null;
            case 132104:
                this.u.onFullScreenVideoCached();
                return null;
            default:
                return null;
        }
    }
}
