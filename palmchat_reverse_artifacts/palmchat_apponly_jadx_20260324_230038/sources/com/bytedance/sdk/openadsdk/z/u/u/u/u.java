package com.bytedance.sdk.openadsdk.z.u.u.u;

import android.os.Bundle;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import defpackage.wc7;
import j$.util.function.Function$CC;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u implements Function<SparseArray<Object>, Object> {
    private final TTRewardVideoAd.RewardAdInteractionListener u;

    public u(TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        this.u = rewardAdInteractionListener;
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
            case 121101:
                this.u.onAdShow();
                return null;
            case 121102:
                this.u.onAdVideoBarClick();
                return null;
            case 121103:
                this.u.onAdClose();
                return null;
            case 121104:
                this.u.onVideoComplete();
                return null;
            case 121105:
                this.u.onVideoError();
                return null;
            case 121106:
                this.u.onRewardVerify(valueSetA.booleanValue(0), valueSetA.intValue(1), valueSetA.stringValue(2), valueSetA.intValue(3), valueSetA.stringValue(4));
                return null;
            case 121107:
                this.u.onRewardArrived(valueSetA.booleanValue(0), valueSetA.intValue(1), (Bundle) valueSetA.objectValue(2, Bundle.class));
                return null;
            case 121108:
                this.u.onSkippedVideo();
                return null;
            default:
                return null;
        }
    }
}
