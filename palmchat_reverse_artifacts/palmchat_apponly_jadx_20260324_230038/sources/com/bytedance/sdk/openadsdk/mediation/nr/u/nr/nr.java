package com.bytedance.sdk.openadsdk.mediation.nr.u.nr;

import android.os.Bundle;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.IMediationInterstitialFullAdListener;
import defpackage.wc7;
import j$.util.function.Function$CC;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr implements Function<SparseArray<Object>, Object> {
    private final IMediationInterstitialFullAdListener u;

    public nr(IMediationInterstitialFullAdListener iMediationInterstitialFullAdListener) {
        this.u = iMediationInterstitialFullAdListener;
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
            case 131101:
                this.u.onAdShow();
                return null;
            case 131102:
                this.u.onAdVideoBarClick();
                return null;
            case 131103:
                this.u.onAdClose();
                return null;
            case 131104:
                this.u.onVideoComplete();
                return null;
            case 131105:
                this.u.onSkippedVideo();
                return null;
            case 131106:
                this.u.onInterstitialFullShowFail(valueSetA.intValue(0), valueSetA.stringValue(1));
                return null;
            case 131107:
                this.u.onVideoError();
                return null;
            case 131108:
                this.u.onAdOpened();
                return null;
            case 131109:
                this.u.onAdLeftApplication();
                return null;
            case 131110:
                this.u.onRewardVerify((Bundle) valueSetA.objectValue(0, Bundle.class));
                return null;
            default:
                return null;
        }
    }
}
