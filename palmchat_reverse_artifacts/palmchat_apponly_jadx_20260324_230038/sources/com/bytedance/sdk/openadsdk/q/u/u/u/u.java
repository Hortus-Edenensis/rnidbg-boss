package com.bytedance.sdk.openadsdk.q.u.u.u;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import defpackage.wc7;
import j$.util.function.Function$CC;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u implements Function<SparseArray<Object>, Object> {
    private final TTFullScreenVideoAd.FullScreenVideoAdInteractionListener nr;
    private ValueSet u = wc7.c;

    public u(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        this.nr = fullScreenVideoAdInteractionListener;
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
        switch (wc7.k(sparseArray).a().intValue(-99999987)) {
            case 131101:
                this.nr.onAdShow();
                return null;
            case 131102:
                this.nr.onAdVideoBarClick();
                return null;
            case 131103:
                this.nr.onAdClose();
                return null;
            case 131104:
                this.nr.onVideoComplete();
                return null;
            case 131105:
                this.nr.onSkippedVideo();
                return null;
            default:
                return null;
        }
    }
}
