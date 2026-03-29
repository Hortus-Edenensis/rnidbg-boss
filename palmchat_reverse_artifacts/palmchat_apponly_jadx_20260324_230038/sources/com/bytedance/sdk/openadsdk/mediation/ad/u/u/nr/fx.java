package com.bytedance.sdk.openadsdk.mediation.ad.u.u.nr;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeToBannerListener;
import com.bytedance.sdk.openadsdk.my.u.u.k;
import defpackage.wc7;
import j$.util.function.Function$CC;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx implements Function<SparseArray<Object>, Object> {
    private final IMediationNativeToBannerListener u;

    public fx(IMediationNativeToBannerListener iMediationNativeToBannerListener) {
        this.u = iMediationNativeToBannerListener;
    }

    @Override // java.util.function.Function
    public /* synthetic */ Function andThen(Function function) {
        return Function$CC.$default$andThen(this, function);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.u == null) {
            return null;
        }
        ValueSet valueSetA = wc7.k(sparseArray).a();
        if (valueSetA.intValue(-99999987) != 266013) {
            return null;
        }
        return this.u.getMediationBannerViewFromNativeAd(new com.bytedance.sdk.openadsdk.mediation.ad.u.u.u.u(k.u(valueSetA.objectValue(0, Object.class))));
    }
}
