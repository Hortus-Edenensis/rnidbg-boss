package com.bytedance.sdk.openadsdk.my.u.fx;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdLoadType;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot;
import com.bytedance.sdk.openadsdk.my.u.u.k;
import defpackage.wc7;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        private Function<SparseArray<Object>, Object> u;

        public u(Function<SparseArray<Object>, Object> function) {
            this.u = function;
        }

        public IMediationAdSlot u() {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 8260031);
            Object objApply = this.u.apply(sparseArray);
            if (objApply instanceof IMediationAdSlot) {
                return (IMediationAdSlot) objApply;
            }
            return null;
        }
    }

    public static final SparseArray<Object> u(final AdSlot adSlot) {
        if (adSlot == null) {
            return new SparseArray<>();
        }
        wc7 wc7VarB = wc7.b();
        wc7VarB.i(260001, adSlot.getAdId());
        wc7VarB.i(260002, adSlot.getCreativeId());
        wc7VarB.i(260003, adSlot.getExt());
        wc7VarB.i(260004, adSlot.getCodeId());
        wc7VarB.j(260005, adSlot.isAutoPlay());
        wc7VarB.f(260006, adSlot.getImgAcceptedWidth());
        wc7VarB.f(260007, adSlot.getImgAcceptedHeight());
        wc7VarB.e(260008, adSlot.getExpressViewAcceptedWidth());
        wc7VarB.e(260009, adSlot.getExpressViewAcceptedHeight());
        wc7VarB.j(260010, adSlot.isSupportDeepLink());
        wc7VarB.j(260011, adSlot.isSupportRenderConrol());
        wc7VarB.f(2600012, adSlot.getAdCount());
        wc7VarB.i(260013, adSlot.getMediaExtra());
        wc7VarB.i(260014, adSlot.getUserID());
        wc7VarB.f(260015, adSlot.getOrientation());
        wc7VarB.f(260016, adSlot.getNativeAdType());
        wc7VarB.h(260017, adSlot.getExternalABVid());
        wc7VarB.f(260018, adSlot.getAdloadSeq());
        wc7VarB.i(260019, adSlot.getPrimeRit());
        wc7VarB.f(260020, adSlot.getAdType());
        wc7VarB.i(260021, adSlot.getBidAdm());
        wc7VarB.i(260022, adSlot.getUserData());
        wc7VarB.h(260023, u(adSlot.getAdLoadType()));
        wc7VarB.h(260024, new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.my.u.fx.nr.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public String get() {
                return adSlot.getRewardName();
            }
        });
        wc7VarB.h(260025, new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.my.u.fx.nr.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(adSlot.getRewardAmount());
            }
        });
        wc7VarB.h(260026, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.my.u.fx.nr.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(adSlot.isSupportIconStyle());
            }
        });
        if (adSlot.getMediationAdSlot() != null) {
            wc7VarB.h(8260028, new com.bytedance.sdk.openadsdk.mediation.ad.u.u.nr.u(adSlot.getMediationAdSlot()));
        }
        return wc7VarB.a().sparseArray();
    }

    public static AdSlot u(SparseArray<Object> sparseArray) {
        AdSlot.Builder builder = new AdSlot.Builder();
        ValueSet valueSetA = wc7.k(sparseArray).a();
        if (valueSetA != null) {
            builder.setAdId(valueSetA.stringValue(260001)).setCodeId(valueSetA.stringValue(260002)).setExt(valueSetA.stringValue(260003)).setCodeId(valueSetA.stringValue(260004)).setIsAutoPlay(valueSetA.booleanValue(260005)).setImageAcceptedSize(valueSetA.intValue(260006), valueSetA.intValue(260007)).setExpressViewAcceptedSize(valueSetA.floatValue(260008), valueSetA.floatValue(260009)).setSupportDeepLink(valueSetA.booleanValue(260010)).setAdCount(valueSetA.intValue(2600012)).setMediaExtra(valueSetA.stringValue(260013)).setUserID(valueSetA.stringValue(260014)).setExternalABVid((int[]) valueSetA.objectValue(260017, int[].class)).setAdloadSeq(valueSetA.intValue(260018)).setPrimeRit(valueSetA.stringValue(260019)).setAdType(valueSetA.intValue(260020)).withBid(valueSetA.stringValue(260021)).setUserData(valueSetA.stringValue(260022)).setAdLoadType(u(valueSetA.intValue(260023))).setMediationAdSlot(new u(k.u(valueSetA.objectValue(8260028, Object.class))).u()).setOrientation(valueSetA.intValue(260015)).setRewardName((String) valueSetA.objectValue(260024, String.class)).setRewardAmount(valueSetA.intValue(260025));
            if (valueSetA.booleanValue(260011)) {
                builder.supportRenderControl();
            }
        }
        return builder.build();
    }

    private static Integer u(TTAdLoadType tTAdLoadType) {
        if (tTAdLoadType == null) {
            return null;
        }
        if (tTAdLoadType == TTAdLoadType.UNKNOWN) {
            return -1;
        }
        if (tTAdLoadType == TTAdLoadType.LOAD) {
            return 3;
        }
        return tTAdLoadType == TTAdLoadType.PRELOAD ? 1 : null;
    }

    private static TTAdLoadType u(int i) {
        if (i == 3) {
            return TTAdLoadType.LOAD;
        }
        if (i == 1) {
            return TTAdLoadType.PRELOAD;
        }
        return TTAdLoadType.UNKNOWN;
    }
}
