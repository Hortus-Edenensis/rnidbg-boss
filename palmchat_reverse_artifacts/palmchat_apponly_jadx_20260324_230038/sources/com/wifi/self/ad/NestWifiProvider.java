package com.wifi.self.ad;

import android.app.Activity;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.wifi.ad.core.SDKAlias;
import com.wifi.ad.core.custom.flow.BaseNativeView;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.helper.ActivityPacker;
import com.wifi.ad.core.listener.InnerRewardShowListener;
import com.wifi.ad.core.listener.PopShowListener;
import com.wifi.ad.core.provider.BaseAdProvider;
import com.wifi.ad.core.strategy.IStrategyListener;
import com.wifi.ad.core.strategy.LoadScene;
import com.wifi.ad.core.utils.WifiLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 22\u00020\u0001:\u00012B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bH\u0016J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bH\u0016J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bH\u0016J(\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J \u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J \u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J \u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J \u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\u000bH\u0016J\u0012\u0010 \u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ \u0010!\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0012\u0010\"\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\bH\u0016J\u0010\u0010#\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010&\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010'\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016J \u0010(\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010)\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010*\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bH\u0016J\"\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020-2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010.H\u0016J\"\u0010/\u001a\u00020\u00042\u0006\u0010,\u001a\u00020-2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u00100\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u00101\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u00063"}, d2 = {"Lcom/wifi/self/ad/NestWifiProvider;", "Lcom/wifi/ad/core/provider/BaseAdProvider;", "()V", "addShowListener", "", "showListener", "Lcom/wifi/ad/core/listener/InnerRewardShowListener;", "nestAdData", "Lcom/wifi/ad/core/data/NestAdData;", "destroyAd", "requestId", "", "drawAdIsBelongTheProvider", "", "adObject", "drawNativeAdIsBelongTheProvider", "feedAdIsBelongTheProvider", "feedNativeAdIsBelongTheProvider", "getCorrectAd", "packer", "Lcom/wifi/ad/core/helper/ActivityPacker;", "listenerStrategy", "Lcom/wifi/ad/core/strategy/IStrategyListener;", "scene", "Lcom/wifi/ad/core/strategy/LoadScene;", "getDrawVideoAd", "getInterstitialAd", "getNativeDrawVideoAd", "getNativeFeedAd", "getNativeView", "Lcom/wifi/ad/core/custom/flow/BaseNativeView;", "adProviderType", "getShowListener", "getTemplateFeedAd", "interstitialAdIsBelongTheProvider", "nativeAdIsBelongTheProvider", "", "onNestAdLoad", "onNestAdUnLoad", "pauseAd", "requestRewardAd", "resumeAd", "rewardAdIsBelongTheProvider", "showInterstitialAd", "activity", "Landroid/app/Activity;", "Lcom/wifi/ad/core/listener/PopShowListener;", "showRewardAd", "startAd", "stopAd", "Companion", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
public final class NestWifiProvider extends BaseAdProvider {
    public static final String SDK_FROM = "Wi-Fi_SDK";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static HashMap<String, InnerRewardShowListener> showListenerMap = new HashMap<>();

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R6\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007`\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/wifi/self/ad/NestWifiProvider$Companion;", "", "()V", "SDK_FROM", "", "showListenerMap", "Ljava/util/HashMap;", "Lcom/wifi/ad/core/listener/InnerRewardShowListener;", "Lkotlin/collections/HashMap;", "getShowListenerMap", "()Ljava/util/HashMap;", "setShowListenerMap", "(Ljava/util/HashMap;)V", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public final HashMap<String, InnerRewardShowListener> getShowListenerMap() {
            return NestWifiProvider.showListenerMap;
        }

        public final void setShowListenerMap(HashMap<String, InnerRewardShowListener> map) {
            NestWifiProvider.showListenerMap = map;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void addShowListener(InnerRewardShowListener showListener, NestAdData nestAdData) {
        HashMap<String, InnerRewardShowListener> map;
        if (showListener == null || TextUtils.isEmpty(nestAdData.getRequestId()) || (map = showListenerMap) == null) {
            return;
        }
        String requestId = nestAdData.getRequestId();
        if (requestId == null) {
            Intrinsics.throwNpe();
        }
        map.put(requestId, showListener);
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void destroyAd(NestAdData nestAdData) {
        super.destroyAd(nestAdData);
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public boolean drawAdIsBelongTheProvider(NestAdData adObject) {
        return false;
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public boolean drawNativeAdIsBelongTheProvider(NestAdData adObject) {
        return false;
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public boolean feedAdIsBelongTheProvider(NestAdData adObject) {
        return false;
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public boolean feedNativeAdIsBelongTheProvider(NestAdData adObject) {
        return false;
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void getCorrectAd(ActivityPacker packer, NestAdData nestAdData, IStrategyListener listenerStrategy, LoadScene scene) {
        listenerStrategy.onStart(nestAdData);
        listenerStrategy.onAdFailed(nestAdData, "AdFailed", MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL);
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void getNativeDrawVideoAd(ActivityPacker packer, NestAdData nestAdData, IStrategyListener listenerStrategy) {
        getDrawVideoAd(packer, nestAdData, listenerStrategy);
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider
    public BaseNativeView getNativeView(String adProviderType) {
        WifiLog.d("getDrawVideoAdView adProviderType = " + adProviderType);
        if (Intrinsics.areEqual(SDKAlias.WIFI.getType(), adProviderType)) {
            return new NestWifiNativeView();
        }
        return null;
    }

    public final InnerRewardShowListener getShowListener(String requestId) {
        HashMap<String, InnerRewardShowListener> map;
        if (requestId != null) {
            if (!(requestId.length() == 0) && (map = showListenerMap) != null) {
                return map.get(requestId);
            }
        }
        return null;
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public boolean interstitialAdIsBelongTheProvider(@NonNull NestAdData adObject) {
        return false;
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public boolean nativeAdIsBelongTheProvider(Object adObject) {
        return false;
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void onNestAdLoad(NestAdData nestAdData) {
        super.onNestAdLoad(nestAdData);
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void onNestAdUnLoad(NestAdData nestAdData) {
        super.onNestAdUnLoad(nestAdData);
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public boolean rewardAdIsBelongTheProvider(NestAdData adObject) {
        return false;
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void showInterstitialAd(Activity activity, NestAdData nestAdData, PopShowListener showListener) {
        if (activity.isFinishing()) {
            WifiLog.d("NestWifiProvider showInterstitialAd activity is error");
        } else if (nestAdData.getAdData() == null) {
            WifiLog.d("NestWifiProvider showInterstitialAd adData is null");
        }
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void destroyAd(String requestId) {
        HashMap<String, InnerRewardShowListener> map;
        super.destroyAd(requestId);
        if (requestId != null) {
            if (requestId.length() == 0) {
                return;
            }
            HashMap<String, InnerRewardShowListener> map2 = showListenerMap;
            if (!(map2 != null ? Boolean.valueOf(map2.containsKey(requestId)) : null).booleanValue() || (map = showListenerMap) == null) {
                return;
            }
            map.remove(requestId);
        }
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void pauseAd(NestAdData nestAdData) {
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void resumeAd(NestAdData nestAdData) {
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void startAd(NestAdData nestAdData) {
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void stopAd(NestAdData nestAdData) {
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void getDrawVideoAd(ActivityPacker packer, NestAdData nestAdData, IStrategyListener listenerStrategy) {
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void getInterstitialAd(ActivityPacker packer, NestAdData nestAdData, IStrategyListener listenerStrategy) {
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void getNativeFeedAd(ActivityPacker packer, NestAdData nestAdData, IStrategyListener listenerStrategy) {
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void getTemplateFeedAd(ActivityPacker packer, NestAdData nestAdData, IStrategyListener listenerStrategy) {
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void requestRewardAd(ActivityPacker packer, NestAdData nestAdData, IStrategyListener listenerStrategy) {
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void showRewardAd(Activity activity, NestAdData nestAdData, InnerRewardShowListener showListener) {
    }
}
