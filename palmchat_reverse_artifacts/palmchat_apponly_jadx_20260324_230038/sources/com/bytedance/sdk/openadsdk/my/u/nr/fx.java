package com.bytedance.sdk.openadsdk.my.u.nr;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import defpackage.wc7;
import j$.util.function.Function$CC;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx implements Function<SparseArray<Object>, Object> {
    private final TTAppDownloadListener u;

    public fx(TTAppDownloadListener tTAppDownloadListener) {
        this.u = tTAppDownloadListener;
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
            case 221101:
                this.u.onIdle();
                return null;
            case 221102:
                this.u.onDownloadActive(valueSetA.longValue(0), valueSetA.longValue(1), valueSetA.stringValue(2), valueSetA.stringValue(3));
                return null;
            case 221103:
                this.u.onDownloadPaused(valueSetA.longValue(0), valueSetA.longValue(1), valueSetA.stringValue(2), valueSetA.stringValue(3));
                return null;
            case 221104:
                this.u.onDownloadFailed(valueSetA.longValue(0), valueSetA.longValue(1), valueSetA.stringValue(2), valueSetA.stringValue(3));
                return null;
            case 221105:
                this.u.onDownloadFinished(valueSetA.longValue(0), valueSetA.stringValue(1), valueSetA.stringValue(2));
                return null;
            case 221106:
                this.u.onInstalled(valueSetA.stringValue(0), valueSetA.stringValue(1));
                return null;
            default:
                return null;
        }
    }
}
