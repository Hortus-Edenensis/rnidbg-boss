package com.bytedance.sdk.openadsdk.bq.u.u.u;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.my.u.u.k;
import com.bytedance.sdk.openadsdk.my.u.u.mv;
import defpackage.wc7;
import j$.util.function.Function$CC;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn implements Function<SparseArray<Object>, Object> {
    private final TTAdNative.NativeExpressAdListener u;

    public pn(TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
        this.u = nativeExpressAdListener;
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
            case 153101:
                this.u.onError(valueSetA.intValue(0), valueSetA.stringValue(1));
                return null;
            case 153102:
                List arrayList = (List) valueSetA.objectValue(0, List.class);
                if (arrayList == null) {
                    arrayList = new ArrayList(0);
                }
                ArrayList arrayList2 = new ArrayList();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(new mv(k.u(it.next())));
                }
                this.u.onNativeExpressAdLoad(arrayList2);
                return null;
            default:
                return null;
        }
    }
}
