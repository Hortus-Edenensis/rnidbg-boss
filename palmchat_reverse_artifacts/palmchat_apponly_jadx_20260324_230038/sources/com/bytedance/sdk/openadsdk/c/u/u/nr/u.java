package com.bytedance.sdk.openadsdk.c.u.u.nr;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.my.u.u.a;
import com.bytedance.sdk.openadsdk.my.u.u.k;
import defpackage.wc7;
import j$.util.function.Function$CC;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u implements Function<SparseArray<Object>, Object> {
    private final TTFeedAd.VideoAdListener nr;
    private ValueSet u = wc7.c;

    public u(TTFeedAd.VideoAdListener videoAdListener) {
        this.nr = videoAdListener;
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
            case 161101:
                this.nr.onVideoLoad(new a(k.u(valueSetA.objectValue(0, Object.class))));
                return null;
            case 161102:
                this.nr.onVideoError(valueSetA.intValue(0), valueSetA.intValue(1));
                return null;
            case 161103:
                this.nr.onVideoAdPaused(new a(k.u(valueSetA.objectValue(0, Object.class))));
                return null;
            case 161104:
                this.nr.onVideoAdStartPlay(new a(k.u(valueSetA.objectValue(0, Object.class))));
                return null;
            case 161105:
                this.nr.onVideoAdContinuePlay(new a(k.u(valueSetA.objectValue(0, Object.class))));
                return null;
            case 161106:
                this.nr.onProgressUpdate(valueSetA.longValue(0), valueSetA.longValue(1));
                return null;
            case 161107:
                this.nr.onVideoAdComplete(new a(k.u(valueSetA.objectValue(0, Object.class))));
                return null;
            default:
                return null;
        }
    }
}
