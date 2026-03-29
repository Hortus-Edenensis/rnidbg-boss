package com.bytedance.sdk.openadsdk.kj.u.u.u;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import defpackage.wc7;
import j$.util.function.Function$CC;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx implements Function<SparseArray<Object>, Object> {
    private final TTNativeExpressAd.ExpressVideoAdListener nr;
    private final ValueSet u = wc7.c;

    public fx(TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener) {
        this.nr = expressVideoAdListener;
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
            case 152101:
                this.nr.onVideoLoad();
                return null;
            case 152102:
                this.nr.onVideoError(valueSetA.intValue(0), valueSetA.intValue(1));
                return null;
            case 152103:
                this.nr.onVideoAdStartPlay();
                return null;
            case 152104:
                this.nr.onVideoAdPaused();
                return null;
            case 152105:
                this.nr.onVideoAdContinuePlay();
                return null;
            case 152106:
                this.nr.onProgressUpdate(valueSetA.longValue(0), valueSetA.longValue(1));
                return null;
            case 152107:
                this.nr.onVideoAdComplete();
                return null;
            case 152108:
                this.nr.onClickRetry();
                return null;
            default:
                return null;
        }
    }
}
