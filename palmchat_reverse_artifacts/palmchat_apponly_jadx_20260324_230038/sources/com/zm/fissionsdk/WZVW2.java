package com.zm.fissionsdk;

import android.text.TextUtils;
import com.zm.adxsdk.protocol.api.WfSlot;
import com.zm.fissionsdk.api.FissionSlot;
import com.zm.fissionsdk.api.interfaces.IFissionLoadManager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class WZVW2 implements IFissionLoadManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final WZVW2 f16739a = new WZVW2();

    public static WZVW2 a() {
        return f16739a;
    }

    @Override // com.zm.fissionsdk.api.interfaces.IFissionLoadManager
    public void loadDraw(FissionSlot fissionSlot, IFissionLoadManager.DrawLoadListener drawLoadListener) {
        VZV2Z.e().loadNative(a(fissionSlot), drawLoadListener instanceof IFissionLoadManager.AsyncDrawLoadListener ? new ZV2Zz(drawLoadListener) : new ZV2VV(drawLoadListener));
    }

    @Override // com.zm.fissionsdk.api.interfaces.IFissionLoadManager
    public void loadInterstitial(FissionSlot fissionSlot, IFissionLoadManager.InterstitialLoadListener interstitialLoadListener) {
        VZV2Z.e().loadInterstitial(a(fissionSlot), interstitialLoadListener instanceof IFissionLoadManager.AsyncInterstitialLoadListener ? new Z2WzW(interstitialLoadListener) : new Zzz2z(interstitialLoadListener));
    }

    @Override // com.zm.fissionsdk.api.interfaces.IFissionLoadManager
    public void loadNative(FissionSlot fissionSlot, IFissionLoadManager.NativeLoadListener nativeLoadListener) {
        VZV2Z.e().loadNative(a(fissionSlot), nativeLoadListener instanceof IFissionLoadManager.AsyncNativeLoadListener ? new Z2ZWz(nativeLoadListener) : new WVZZV(nativeLoadListener));
    }

    @Override // com.zm.fissionsdk.api.interfaces.IFissionLoadManager
    public void loadRewardVideo(FissionSlot fissionSlot, IFissionLoadManager.RewardVideoLoadListener rewardVideoLoadListener) {
        VZV2Z.e().loadReward(a(fissionSlot), rewardVideoLoadListener instanceof IFissionLoadManager.AsyncRewardVideoLoadListener ? new ZV2zV(rewardVideoLoadListener) : new VW22Z(rewardVideoLoadListener));
    }

    @Override // com.zm.fissionsdk.api.interfaces.IFissionLoadManager
    public void loadSplash(FissionSlot fissionSlot, IFissionLoadManager.SplashLoadListener splashLoadListener) {
        VZV2Z.e().loadSplash(a(fissionSlot), splashLoadListener instanceof IFissionLoadManager.AsyncSplashLoadListener ? new VZWVV(splashLoadListener) : new VzVWV(splashLoadListener));
    }

    public final WfSlot a(FissionSlot fissionSlot) {
        WfSlot.Builder builder = new WfSlot.Builder();
        if (fissionSlot != null) {
            String slotId = fissionSlot.getSlotId();
            int slotType = fissionSlot.getSlotType();
            int count = fissionSlot.getCount();
            String requestId = fissionSlot.getRequestId();
            if (TextUtils.isEmpty(requestId)) {
                requestId = WzWVz.a(slotId);
            }
            int expressType = fissionSlot.getExpressType();
            builder.setRequestId(requestId);
            builder.setContext(fissionSlot.getContext());
            builder.setSlotType(slotType);
            builder.setExpressType(expressType);
            builder.setSlotId(slotId);
            builder.addAllRequestParams(fissionSlot.getAllRequestParams());
            builder.addRequestParam(WfSlot.SUPPORT_TWINS_ECPM, Boolean.TRUE);
            builder.addRequestParam(WfSlot.EXPRESS_REQUEST, Boolean.valueOf(expressType > 0));
            if (slotType != 1 && count > 1) {
                count = 1;
            }
            builder.setCount(count);
            builder.setClickAreaType(fissionSlot.getClickAreaType());
        }
        return builder.build();
    }
}
