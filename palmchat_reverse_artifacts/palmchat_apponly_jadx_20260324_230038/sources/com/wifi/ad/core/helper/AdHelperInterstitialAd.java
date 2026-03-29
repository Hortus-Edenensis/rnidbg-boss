package com.wifi.ad.core.helper;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.huawei.openalliance.ad.constant.bq;
import com.wifi.ad.core.TogetherAd;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.compliance.AdNativeStyleManagerSDK;
import com.wifi.ad.core.config.AdParams;
import com.wifi.ad.core.config.AdProviderLoader;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.listener.BaseListener;
import com.wifi.ad.core.listener.FeedLoadListener;
import com.wifi.ad.core.listener.PopShowListener;
import com.wifi.ad.core.p001const.WifiNestConst;
import com.wifi.ad.core.provider.BaseAdProvider;
import com.wifi.ad.core.reporter.EventReporter;
import com.wifi.ad.core.spstrategy.SPCacheManager;
import com.wifi.ad.core.strategy.AbsStrategy;
import com.wifi.ad.core.strategy.LoadScene;
import com.wifi.ad.core.strategy.StrategyManager;
import com.wifi.ad.core.utils.SpMaterialFilterUtil;
import com.wifi.ad.core.utils.WifiLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ&\u0010\t\u001a\u00020\u00042\b\b\u0001\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\r2\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ&\u0010\u0010\u001a\u00020\u00042\b\b\u0001\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\r2\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0011\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0012\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006J&\u0010\u0013\u001a\u00020\u00042\b\b\u0001\u0010\n\u001a\u00020\u000b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u00152\u0006\u0010\u0016\u001a\u00020\u0017J&\u0010\u0018\u001a\u00020\u00042\b\b\u0001\u0010\n\u001a\u00020\u000b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0019\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u001a\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006¨\u0006\u001b"}, d2 = {"Lcom/wifi/ad/core/helper/AdHelperInterstitialAd;", "Lcom/wifi/ad/core/helper/BaseHelper;", "()V", "destroyAd", "", "nestAdData", "Lcom/wifi/ad/core/data/NestAdData;", "requestId", "", "getInterstitialAd", "activity", "Landroid/app/Activity;", "adParams", "Lcom/wifi/ad/core/config/AdParams;", bq.f.s, "Lcom/wifi/ad/core/listener/BaseListener;", "getNativeInterstitialAd", "pauseAd", "resumeAd", "showInterstitialAd", "adList", "", "showListener", "Lcom/wifi/ad/core/listener/PopShowListener;", "showNativeInterstitialAd", "startAd", "stopAd", "core_release"}, k = 1, mv = {1, 1, 16})
public final class AdHelperInterstitialAd extends BaseHelper {
    public static final AdHelperInterstitialAd INSTANCE = new AdHelperInterstitialAd();

    private AdHelperInterstitialAd() {
    }

    public static /* synthetic */ void getInterstitialAd$default(AdHelperInterstitialAd adHelperInterstitialAd, Activity activity, AdParams adParams, BaseListener baseListener, int i, Object obj) {
        if ((i & 4) != 0) {
            baseListener = null;
        }
        adHelperInterstitialAd.getInterstitialAd(activity, adParams, baseListener);
    }

    public static /* synthetic */ void getNativeInterstitialAd$default(AdHelperInterstitialAd adHelperInterstitialAd, Activity activity, AdParams adParams, BaseListener baseListener, int i, Object obj) {
        if ((i & 4) != 0) {
            baseListener = null;
        }
        adHelperInterstitialAd.getNativeInterstitialAd(activity, adParams, baseListener);
    }

    public final void destroyAd(String requestId) {
        Iterator<T> it = TogetherAd.INSTANCE.getMProviders().entrySet().iterator();
        while (it.hasNext()) {
            BaseAdProvider baseAdProviderLoadAdProvider = AdProviderLoader.INSTANCE.loadAdProvider((String) ((Map.Entry) it.next()).getKey());
            if (baseAdProviderLoadAdProvider != null) {
                baseAdProviderLoadAdProvider.destroyAd(requestId);
            }
        }
    }

    public final synchronized void getInterstitialAd(@NonNull Activity activity, @NonNull final AdParams adParams, @NonNull final BaseListener listener) {
        ActivityPacker activityPacker = new ActivityPacker(activity);
        adParams.setNestType(WifiNestConst.NestTypeConst.NEST_INTERSTITIAL_AD);
        adParams.setRenderStyle$core_release(2);
        StrategyManager strategyManager = StrategyManager.INSTANCE;
        Context appContext = activityPacker.getAppContext();
        Intrinsics.checkExpressionValueIsNotNull(appContext, "packer.appContext");
        AbsStrategy currentStrategy = strategyManager.getCurrentStrategy(adParams, listener, appContext);
        if (currentStrategy != null) {
            currentStrategy.setLoadListener(new BaseListener() { // from class: com.wifi.ad.core.helper.AdHelperInterstitialAd.getInterstitialAd.1
                @Override // com.wifi.ad.core.listener.BaseListener
                public void onAdFailed(String errorCode, String message) {
                    WifiLog.d("AdHelperInterstitialAd onAdFailed errorCode = " + errorCode + " message = " + message);
                    BaseListener baseListener = listener;
                    if (baseListener != null) {
                        baseListener.onAdFailed(errorCode, message);
                    }
                }

                @Override // com.wifi.ad.core.listener.BaseListener
                public void onAdLoaded(String providerType, List<NestAdData> adList) {
                    WifiLog.d("AdHelperInterstitialAd onAdLoaded " + adList);
                    BaseListener baseListener = listener;
                    if (baseListener != null) {
                        baseListener.onAdLoaded(providerType, adList);
                    }
                }

                @Override // com.wifi.ad.core.listener.BaseListener
                public void onStart() {
                    WifiLog.d("AdHelperInterstitialAd onStart");
                    BaseListener baseListener = listener;
                    if (baseListener != null) {
                        baseListener.onStart();
                    }
                    EventReporter.INSTANCE.reportReq(adParams);
                }
            });
            currentStrategy.loadAd(activityPacker, adParams, LoadScene.INTERSTITIAL);
        }
    }

    public final synchronized void getNativeInterstitialAd(@NonNull Activity activity, @NonNull AdParams adParams, @NonNull final BaseListener listener) {
        AdHelperFeed.INSTANCE.getNativeFeedAd(activity, adParams, new FeedLoadListener() { // from class: com.wifi.ad.core.helper.AdHelperInterstitialAd.getNativeInterstitialAd.1
            @Override // com.wifi.ad.core.listener.FeedLoadListener, com.wifi.ad.core.listener.BaseListener
            public void onAdFailed(String errorCode, String message) {
                BaseListener baseListener = listener;
                if (baseListener != null) {
                    baseListener.onAdFailed(errorCode, message);
                }
            }

            @Override // com.wifi.ad.core.listener.FeedLoadListener, com.wifi.ad.core.listener.BaseListener
            public void onAdLoaded(String providerType, List<NestAdData> adList) {
                BaseListener baseListener = listener;
                if (baseListener != null) {
                    baseListener.onAdLoaded(providerType, adList);
                }
            }

            @Override // com.wifi.ad.core.listener.FeedLoadListener, com.wifi.ad.core.listener.BaseListener
            public void onStart() {
                BaseListener baseListener = listener;
                if (baseListener != null) {
                    baseListener.onStart();
                }
            }
        });
    }

    public final void pauseAd(@NonNull NestAdData nestAdData) {
        Iterator<T> it = TogetherAd.INSTANCE.getMProviders().entrySet().iterator();
        while (it.hasNext()) {
            BaseAdProvider baseAdProviderLoadAdProvider = AdProviderLoader.INSTANCE.loadAdProvider((String) ((Map.Entry) it.next()).getKey());
            if (baseAdProviderLoadAdProvider != null) {
                baseAdProviderLoadAdProvider.pauseAd(nestAdData);
            }
        }
    }

    public final void resumeAd(@NonNull NestAdData nestAdData) {
        Iterator<T> it = TogetherAd.INSTANCE.getMProviders().entrySet().iterator();
        while (it.hasNext()) {
            BaseAdProvider baseAdProviderLoadAdProvider = AdProviderLoader.INSTANCE.loadAdProvider((String) ((Map.Entry) it.next()).getKey());
            if (baseAdProviderLoadAdProvider != null) {
                baseAdProviderLoadAdProvider.resumeAd(nestAdData);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v2, types: [T, com.wifi.ad.core.data.NestAdData] */
    /* JADX WARN: Type inference failed for: r8v9, types: [T, com.wifi.ad.core.data.NestAdData] */
    public final synchronized void showInterstitialAd(@NonNull final Activity activity, List<NestAdData> adList, final PopShowListener showListener) {
        if (!adList.isEmpty()) {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            NestAdData nestAdData = adList.get(0);
            objectRef.element = nestAdData;
            if (nestAdData.getAdSPStrategy()) {
                objectRef.element = SPCacheManager.INSTANCE.changeCheckMaxAd((NestAdData) objectRef.element);
            }
            Iterator<T> it = TogetherAd.INSTANCE.getMProviders().entrySet().iterator();
            while (it.hasNext()) {
                BaseAdProvider baseAdProviderLoadAdProvider = AdProviderLoader.INSTANCE.loadAdProvider((String) ((Map.Entry) it.next()).getKey());
                if (baseAdProviderLoadAdProvider != null && baseAdProviderLoadAdProvider.interstitialAdIsBelongTheProvider((NestAdData) objectRef.element)) {
                    PopShowListener popShowListener = new PopShowListener() { // from class: com.wifi.ad.core.helper.AdHelperInterstitialAd$showInterstitialAd$$inlined$forEach$lambda$1
                        @Override // com.wifi.ad.core.listener.PopShowListener
                        public void onAdClicked(String providerType, NestAdData adData) {
                            PopShowListener popShowListener2 = showListener;
                            if (popShowListener2 != null) {
                                popShowListener2.onAdClicked(providerType, adData);
                            }
                        }

                        @Override // com.wifi.ad.core.listener.PopShowListener
                        public void onAdClose(String providerType, NestAdData adData) {
                            PopShowListener popShowListener2 = showListener;
                            if (popShowListener2 != null) {
                                popShowListener2.onAdClose(providerType, adData);
                            }
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // com.wifi.ad.core.listener.PopShowListener
                        public void onAdExpose(String providerType, NestAdData adData) {
                            if (adData.getAdSPStrategy()) {
                                SpMaterialFilterUtil.INSTANCE.saveMaterialFrequencyInfo(activity, adData);
                                if (!WifiNestAd.INSTANCE.getSwitch58414() && ((NestAdData) objectRef.element).getAdStrategyOptimizeSwitch() != 1) {
                                    SPCacheManager.INSTANCE.removeShowAd(adData);
                                }
                            }
                            PopShowListener popShowListener2 = showListener;
                            if (popShowListener2 != null) {
                                popShowListener2.onAdExpose(providerType, adData);
                            }
                        }

                        @Override // com.wifi.ad.core.listener.PopShowListener
                        public void onAdSkipClick(String providerType, NestAdData adData) {
                            PopShowListener popShowListener2 = showListener;
                            if (popShowListener2 != null) {
                                popShowListener2.onAdSkipClick(providerType, adData);
                            }
                        }

                        @Override // com.wifi.ad.core.listener.PopShowListener
                        public void onDownloadComplete(String providerType, NestAdData adData) {
                            PopShowListener popShowListener2 = showListener;
                            if (popShowListener2 != null) {
                                popShowListener2.onDownloadComplete(providerType, adData);
                            }
                        }

                        @Override // com.wifi.ad.core.listener.PopShowListener
                        public void onDownloadFailed(String providerType, NestAdData adData) {
                            PopShowListener popShowListener2 = showListener;
                            if (popShowListener2 != null) {
                                popShowListener2.onDownloadFailed(providerType, adData);
                            }
                        }

                        @Override // com.wifi.ad.core.listener.PopShowListener
                        public void onDownloadInstalled(String providerType, NestAdData adData) {
                            PopShowListener popShowListener2 = showListener;
                            if (popShowListener2 != null) {
                                popShowListener2.onDownloadInstalled(providerType, adData);
                            }
                        }

                        @Override // com.wifi.ad.core.listener.PopShowListener
                        public void onDownloadStart(String providerType, NestAdData adData) {
                            PopShowListener popShowListener2 = showListener;
                            if (popShowListener2 != null) {
                                popShowListener2.onDownloadStart(providerType, adData);
                            }
                        }

                        @Override // com.wifi.ad.core.listener.PopShowListener
                        public void onVideoComplete(String providerType, NestAdData adData) {
                            PopShowListener popShowListener2 = showListener;
                            if (popShowListener2 != null) {
                                popShowListener2.onVideoComplete(providerType, adData);
                            }
                        }

                        @Override // com.wifi.ad.core.listener.PopShowListener
                        public void onVideoError(String providerType, NestAdData adData) {
                            PopShowListener popShowListener2 = showListener;
                            if (popShowListener2 != null) {
                                popShowListener2.onVideoError(providerType, adData);
                            }
                        }

                        @Override // com.wifi.ad.core.listener.PopShowListener
                        public void onVideoPause(String providerType, NestAdData adData) {
                            PopShowListener popShowListener2 = showListener;
                            if (popShowListener2 != null) {
                                popShowListener2.onVideoPause(providerType, adData);
                            }
                        }

                        @Override // com.wifi.ad.core.listener.PopShowListener
                        public void onVideoStart(String providerType, NestAdData adData) {
                            PopShowListener popShowListener2 = showListener;
                            if (popShowListener2 != null) {
                                popShowListener2.onVideoStart(providerType, adData);
                            }
                        }
                    };
                    if (baseAdProviderLoadAdProvider != null) {
                        baseAdProviderLoadAdProvider.showInterstitialAd(activity, (NestAdData) objectRef.element, popShowListener);
                    }
                }
            }
        }
    }

    public final synchronized void showNativeInterstitialAd(@NonNull Activity activity, List<NestAdData> adList, PopShowListener showListener) {
        if (!adList.isEmpty()) {
            NestAdData nestAdDataChangeCheckMaxAd = adList.get(0);
            if (WifiNestAd.INSTANCE.getSwitch58414()) {
                nestAdDataChangeCheckMaxAd = SPCacheManager.INSTANCE.changeCheckMaxAd(nestAdDataChangeCheckMaxAd);
            }
            if (nestAdDataChangeCheckMaxAd != null) {
                WifiLog.d("AdHelperInterstitialAd showNativeInterstitialAd renderType:" + nestAdDataChangeCheckMaxAd.getRenderType());
                if (AdNativeStyleManagerSDK.getNativeStyleView(86) == AdNativeStyleManagerSDK.STYLE_VALUE2) {
                    DefPopNativeDialogStyle2 defPopNativeDialogStyle2 = new DefPopNativeDialogStyle2(activity);
                    defPopNativeDialogStyle2.setShowListener(showListener);
                    defPopNativeDialogStyle2.setDataAndShow(nestAdDataChangeCheckMaxAd);
                } else {
                    DefPopNativeDialog defPopNativeDialog = new DefPopNativeDialog(activity);
                    defPopNativeDialog.setShowListener(showListener);
                    defPopNativeDialog.setDataAndShow(nestAdDataChangeCheckMaxAd);
                }
            }
        }
    }

    public final void startAd(@NonNull NestAdData nestAdData) {
        Iterator<T> it = TogetherAd.INSTANCE.getMProviders().entrySet().iterator();
        while (it.hasNext()) {
            BaseAdProvider baseAdProviderLoadAdProvider = AdProviderLoader.INSTANCE.loadAdProvider((String) ((Map.Entry) it.next()).getKey());
            if (baseAdProviderLoadAdProvider != null) {
                baseAdProviderLoadAdProvider.startAd(nestAdData);
            }
        }
    }

    public final void stopAd(@NonNull NestAdData nestAdData) {
        Iterator<T> it = TogetherAd.INSTANCE.getMProviders().entrySet().iterator();
        while (it.hasNext()) {
            BaseAdProvider baseAdProviderLoadAdProvider = AdProviderLoader.INSTANCE.loadAdProvider((String) ((Map.Entry) it.next()).getKey());
            if (baseAdProviderLoadAdProvider != null) {
                baseAdProviderLoadAdProvider.stopAd(nestAdData);
            }
        }
    }

    public final void destroyAd(@NonNull NestAdData nestAdData) {
        Iterator<T> it = TogetherAd.INSTANCE.getMProviders().entrySet().iterator();
        while (it.hasNext()) {
            BaseAdProvider baseAdProviderLoadAdProvider = AdProviderLoader.INSTANCE.loadAdProvider((String) ((Map.Entry) it.next()).getKey());
            if (baseAdProviderLoadAdProvider != null) {
                baseAdProviderLoadAdProvider.destroyAd(nestAdData);
            }
        }
    }
}
