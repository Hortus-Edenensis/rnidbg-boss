package com.bytedance.sdk.openadsdk.bq.u.u.u;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.my.u.u.k;
import com.bytedance.sdk.openadsdk.my.u.u.s;
import defpackage.wc7;
import j$.util.function.Function$CC;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz implements Function<SparseArray<Object>, Object> {
    private final TTAdNative.RewardVideoAdListener u;

    public iz(TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
        this.u = rewardVideoAdListener;
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
        ValueSet valueSetA;
        if (this.u != null && (valueSetA = wc7.k(sparseArray).a()) != null) {
            switch (valueSetA.intValue(-99999987)) {
                case 124101:
                    this.u.onError(valueSetA.intValue(0), valueSetA.stringValue(1));
                    break;
                case 124102:
                    this.u.onRewardVideoAdLoad(new s(k.u(valueSetA.objectValue(0, Object.class))));
                    break;
                case 124103:
                    this.u.onRewardVideoCached(new s(k.u(valueSetA.objectValue(0, Object.class))));
                    break;
                case 124104:
                    this.u.onRewardVideoCached();
                    break;
            }
        }
        return null;
    }
}
