package com.bytedance.sdk.openadsdk.mediation.ad.u.u.nr;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder;
import defpackage.wc7;
import j$.util.function.Function$CC;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn implements Function<SparseArray<Object>, Object> {
    private final IMediationViewBinder u;

    public pn(IMediationViewBinder iMediationViewBinder) {
        this.u = iMediationViewBinder;
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
        switch (wc7.k(sparseArray).a().intValue(-99999987)) {
            case 271021:
                return Integer.class.cast(Integer.valueOf(this.u.getLayoutId()));
            case 271022:
                return Integer.class.cast(Integer.valueOf(this.u.getTitleId()));
            case 271023:
                return Integer.class.cast(Integer.valueOf(this.u.getDecriptionTextId()));
            case 271024:
                return Integer.class.cast(Integer.valueOf(this.u.getCallToActionId()));
            case 271025:
                return Integer.class.cast(Integer.valueOf(this.u.getIconImageId()));
            case 271026:
                return Integer.class.cast(Integer.valueOf(this.u.getMainImageId()));
            case 271027:
                return Integer.class.cast(Integer.valueOf(this.u.getMediaViewId()));
            case 271028:
                return Integer.class.cast(Integer.valueOf(this.u.getSourceId()));
            case 271029:
                return Integer.class.cast(Integer.valueOf(this.u.getGroupImage1Id()));
            case 271030:
                return Integer.class.cast(Integer.valueOf(this.u.getGroupImage2Id()));
            case 271031:
                return Integer.class.cast(Integer.valueOf(this.u.getGroupImage3Id()));
            case 271032:
                return Integer.class.cast(Integer.valueOf(this.u.getLogoLayoutId()));
            case 271033:
                return Integer.class.cast(Integer.valueOf(this.u.getShakeViewContainerId()));
            case 271034:
                return this.u.getExtras();
            default:
                return wc7.e.apply(sparseArray);
        }
    }
}
