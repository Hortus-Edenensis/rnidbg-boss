package com.bytedance.sdk.openadsdk.dw.u.u.u;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import defpackage.wc7;
import j$.util.function.Function$CC;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u implements Function<SparseArray<Object>, Object> {
    private final TTDrawFeedAd.DrawVideoListener u;

    public u(TTDrawFeedAd.DrawVideoListener drawVideoListener) {
        this.u = drawVideoListener;
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
        switch (wc7.k(sparseArray).a().intValue(-99999987)) {
            case 171101:
                this.u.onClick();
                return null;
            case 171102:
                this.u.onClickRetry();
                return null;
            default:
                return null;
        }
    }
}
