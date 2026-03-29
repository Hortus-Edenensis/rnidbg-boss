package com.wifi.ad.core.helper;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.huawei.openalliance.ad.constant.bq;
import com.wifi.ad.core.TogetherAd;
import com.wifi.ad.core.config.AdParams;
import com.wifi.ad.core.config.AdProviderLoader;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.listener.FeedBannerLoadListener;
import com.wifi.ad.core.listener.InterstitialShowListener;
import com.wifi.ad.core.listener.PopShowListener;
import com.wifi.ad.core.p001const.WifiNestConst;
import com.wifi.ad.core.provider.BaseAdProvider;
import com.wifi.ad.core.reporter.EventReporter;
import com.wifi.ad.core.strategy.LoadScene;
import com.wifi.ad.core.strategy.SdkStrategy;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J&\u0010\u0007\u001a\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u000b2\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\rJ \u0010\u000e\u001a\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012¨\u0006\u0013"}, d2 = {"Lcom/wifi/ad/core/helper/AdHelperH5InterstitialAd;", "Lcom/wifi/ad/core/helper/BaseHelper;", "()V", "destroyAd", "", "requestId", "", "getInterstitialAd", "activity", "Landroid/app/Activity;", "adParams", "Lcom/wifi/ad/core/config/AdParams;", bq.f.s, "Lcom/wifi/ad/core/listener/FeedBannerLoadListener;", "showInterstitialAd", "nestAdData", "Lcom/wifi/ad/core/data/NestAdData;", "showListener", "Lcom/wifi/ad/core/listener/InterstitialShowListener;", "core_release"}, k = 1, mv = {1, 1, 16})
public final class AdHelperH5InterstitialAd extends BaseHelper {
    public static final AdHelperH5InterstitialAd INSTANCE = new AdHelperH5InterstitialAd();

    private AdHelperH5InterstitialAd() {
    }

    public static /* synthetic */ void getInterstitialAd$default(AdHelperH5InterstitialAd adHelperH5InterstitialAd, Activity activity, AdParams adParams, FeedBannerLoadListener feedBannerLoadListener, int i, Object obj) {
        if ((i & 4) != 0) {
            feedBannerLoadListener = null;
        }
        adHelperH5InterstitialAd.getInterstitialAd(activity, adParams, feedBannerLoadListener);
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

    public final synchronized void getInterstitialAd(@NonNull Activity activity, @NonNull final AdParams adParams, @NonNull final FeedBannerLoadListener listener) {
        ActivityPacker activityPacker = new ActivityPacker(activity);
        adParams.setNestType(WifiNestConst.NestTypeConst.NEST_INTERSTITIAL_AD);
        adParams.setRenderStyle$core_release(2);
        SdkStrategy sdkStrategy = new SdkStrategy();
        sdkStrategy.setFeedBannerLoadListener(new FeedBannerLoadListener() { // from class: com.wifi.ad.core.helper.AdHelperH5InterstitialAd.getInterstitialAd.1
            @Override // com.wifi.ad.core.listener.FeedBannerLoadListener
            public void onAdFailed(String errorCode, String message, String requestId) {
                FeedBannerLoadListener feedBannerLoadListener = listener;
                if (feedBannerLoadListener != null) {
                    feedBannerLoadListener.onAdFailed(errorCode, message, requestId);
                }
            }

            @Override // com.wifi.ad.core.listener.FeedBannerLoadListener
            public void onAdLoad(String providerType, String requestId) {
                FeedBannerLoadListener feedBannerLoadListener = listener;
                if (feedBannerLoadListener != null) {
                    feedBannerLoadListener.onAdLoad(providerType, requestId);
                }
            }

            @Override // com.wifi.ad.core.listener.FeedBannerLoadListener
            public void onStart(String requestId) {
                FeedBannerLoadListener feedBannerLoadListener = listener;
                if (feedBannerLoadListener != null) {
                    feedBannerLoadListener.onStart(requestId);
                }
                EventReporter.INSTANCE.reportReq(adParams);
            }
        });
        sdkStrategy.loadAd(activityPacker, adParams, LoadScene.INTERSTITIAL);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void showInterstitialAd(@NonNull Activity activity, NestAdData nestAdData, final InterstitialShowListener showListener) {
        boolean z;
        PopShowListener popShowListener = new PopShowListener() { // from class: com.wifi.ad.core.helper.AdHelperH5InterstitialAd$showInterstitialAd$popShowListener$1
            @Override // com.wifi.ad.core.listener.PopShowListener
            public void onAdClicked(String providerType, NestAdData adData) {
                InterstitialShowListener interstitialShowListener = showListener;
                if (interstitialShowListener == null) {
                    Intrinsics.throwNpe();
                }
                String adType = adData.getAdType();
                if (adType == null) {
                    Intrinsics.throwNpe();
                }
                String strCreateStringByAdData = SdkStrategy.INSTANCE.createStringByAdData(adData);
                if (strCreateStringByAdData == null) {
                    Intrinsics.throwNpe();
                }
                String requestId = adData.getRequestId();
                if (requestId == null) {
                    Intrinsics.throwNpe();
                }
                interstitialShowListener.onAdClicked(adType, strCreateStringByAdData, requestId);
            }

            @Override // com.wifi.ad.core.listener.PopShowListener
            public void onAdClose(String providerType, NestAdData adData) {
                InterstitialShowListener interstitialShowListener = showListener;
                if (interstitialShowListener == null) {
                    Intrinsics.throwNpe();
                }
                String adType = adData.getAdType();
                if (adType == null) {
                    Intrinsics.throwNpe();
                }
                String strCreateStringByAdData = SdkStrategy.INSTANCE.createStringByAdData(adData);
                if (strCreateStringByAdData == null) {
                    Intrinsics.throwNpe();
                }
                String requestId = adData.getRequestId();
                if (requestId == null) {
                    Intrinsics.throwNpe();
                }
                interstitialShowListener.onAdClose(adType, strCreateStringByAdData, requestId);
            }

            @Override // com.wifi.ad.core.listener.PopShowListener
            public void onAdExpose(String providerType, NestAdData adData) {
                InterstitialShowListener interstitialShowListener = showListener;
                if (interstitialShowListener == null) {
                    Intrinsics.throwNpe();
                }
                String adType = adData.getAdType();
                if (adType == null) {
                    Intrinsics.throwNpe();
                }
                String strCreateStringByAdData = SdkStrategy.INSTANCE.createStringByAdData(adData);
                if (strCreateStringByAdData == null) {
                    Intrinsics.throwNpe();
                }
                String requestId = adData.getRequestId();
                if (requestId == null) {
                    Intrinsics.throwNpe();
                }
                interstitialShowListener.onAdExposed(adType, strCreateStringByAdData, requestId);
            }

            @Override // com.wifi.ad.core.listener.PopShowListener
            public void onAdSkipClick(String providerType, NestAdData adData) {
                InterstitialShowListener interstitialShowListener = showListener;
                String adType = adData.getAdType();
                if (adType == null) {
                    Intrinsics.throwNpe();
                }
                String strCreateStringByAdData = SdkStrategy.INSTANCE.createStringByAdData(adData);
                if (strCreateStringByAdData == null) {
                    Intrinsics.throwNpe();
                }
                String requestId = adData.getRequestId();
                if (requestId == null) {
                    Intrinsics.throwNpe();
                }
                interstitialShowListener.onAdSkipClick(adType, strCreateStringByAdData, requestId);
            }

            @Override // com.wifi.ad.core.listener.PopShowListener
            public void onDownloadComplete(String providerType, NestAdData adData) {
                InterstitialShowListener interstitialShowListener = showListener;
                if (interstitialShowListener == null) {
                    Intrinsics.throwNpe();
                }
                String adType = adData.getAdType();
                if (adType == null) {
                    Intrinsics.throwNpe();
                }
                String strCreateStringByAdData = SdkStrategy.INSTANCE.createStringByAdData(adData);
                if (strCreateStringByAdData == null) {
                    Intrinsics.throwNpe();
                }
                String requestId = adData.getRequestId();
                if (requestId == null) {
                    Intrinsics.throwNpe();
                }
                interstitialShowListener.onDownloadComplete(adType, strCreateStringByAdData, requestId);
            }

            @Override // com.wifi.ad.core.listener.PopShowListener
            public void onDownloadFailed(String providerType, NestAdData adData) {
                InterstitialShowListener interstitialShowListener = showListener;
                if (interstitialShowListener == null) {
                    Intrinsics.throwNpe();
                }
                String adType = adData.getAdType();
                if (adType == null) {
                    Intrinsics.throwNpe();
                }
                String strCreateStringByAdData = SdkStrategy.INSTANCE.createStringByAdData(adData);
                if (strCreateStringByAdData == null) {
                    Intrinsics.throwNpe();
                }
                String requestId = adData.getRequestId();
                if (requestId == null) {
                    Intrinsics.throwNpe();
                }
                interstitialShowListener.onDownloadFailed(adType, strCreateStringByAdData, requestId);
            }

            @Override // com.wifi.ad.core.listener.PopShowListener
            public void onDownloadInstalled(String providerType, NestAdData adData) {
                InterstitialShowListener interstitialShowListener = showListener;
                if (interstitialShowListener == null) {
                    Intrinsics.throwNpe();
                }
                String adType = adData.getAdType();
                if (adType == null) {
                    Intrinsics.throwNpe();
                }
                String strCreateStringByAdData = SdkStrategy.INSTANCE.createStringByAdData(adData);
                if (strCreateStringByAdData == null) {
                    Intrinsics.throwNpe();
                }
                String requestId = adData.getRequestId();
                if (requestId == null) {
                    Intrinsics.throwNpe();
                }
                interstitialShowListener.onDownloadInstalled(adType, strCreateStringByAdData, requestId);
            }

            @Override // com.wifi.ad.core.listener.PopShowListener
            public void onDownloadStart(String providerType, NestAdData adData) {
                InterstitialShowListener interstitialShowListener = showListener;
                if (interstitialShowListener == null) {
                    Intrinsics.throwNpe();
                }
                String adType = adData.getAdType();
                if (adType == null) {
                    Intrinsics.throwNpe();
                }
                String strCreateStringByAdData = SdkStrategy.INSTANCE.createStringByAdData(adData);
                if (strCreateStringByAdData == null) {
                    Intrinsics.throwNpe();
                }
                String requestId = adData.getRequestId();
                if (requestId == null) {
                    Intrinsics.throwNpe();
                }
                interstitialShowListener.onDownloadStart(adType, strCreateStringByAdData, requestId);
            }

            @Override // com.wifi.ad.core.listener.PopShowListener
            public void onVideoComplete(String providerType, NestAdData adData) {
                InterstitialShowListener interstitialShowListener = showListener;
                if (interstitialShowListener == null) {
                    Intrinsics.throwNpe();
                }
                String adType = adData.getAdType();
                if (adType == null) {
                    Intrinsics.throwNpe();
                }
                String strCreateStringByAdData = SdkStrategy.INSTANCE.createStringByAdData(adData);
                if (strCreateStringByAdData == null) {
                    Intrinsics.throwNpe();
                }
                String requestId = adData.getRequestId();
                if (requestId == null) {
                    Intrinsics.throwNpe();
                }
                interstitialShowListener.onVideoComplete(adType, strCreateStringByAdData, requestId);
            }

            @Override // com.wifi.ad.core.listener.PopShowListener
            public void onVideoError(String providerType, NestAdData adData) {
                InterstitialShowListener interstitialShowListener = showListener;
                if (interstitialShowListener == null) {
                    Intrinsics.throwNpe();
                }
                String adType = adData.getAdType();
                if (adType == null) {
                    Intrinsics.throwNpe();
                }
                String strCreateStringByAdData = SdkStrategy.INSTANCE.createStringByAdData(adData);
                if (strCreateStringByAdData == null) {
                    Intrinsics.throwNpe();
                }
                String requestId = adData.getRequestId();
                if (requestId == null) {
                    Intrinsics.throwNpe();
                }
                interstitialShowListener.onVideoError(adType, strCreateStringByAdData, requestId);
            }

            @Override // com.wifi.ad.core.listener.PopShowListener
            public void onVideoPause(String providerType, NestAdData adData) {
                InterstitialShowListener interstitialShowListener = showListener;
                if (interstitialShowListener == null) {
                    Intrinsics.throwNpe();
                }
                String adType = adData.getAdType();
                if (adType == null) {
                    Intrinsics.throwNpe();
                }
                String strCreateStringByAdData = SdkStrategy.INSTANCE.createStringByAdData(adData);
                if (strCreateStringByAdData == null) {
                    Intrinsics.throwNpe();
                }
                String requestId = adData.getRequestId();
                if (requestId == null) {
                    Intrinsics.throwNpe();
                }
                interstitialShowListener.onVideoPause(adType, strCreateStringByAdData, requestId);
            }

            @Override // com.wifi.ad.core.listener.PopShowListener
            public void onVideoStart(String providerType, NestAdData adData) {
                InterstitialShowListener interstitialShowListener = showListener;
                if (interstitialShowListener == null) {
                    Intrinsics.throwNpe();
                }
                String adType = adData.getAdType();
                if (adType == null) {
                    Intrinsics.throwNpe();
                }
                String strCreateStringByAdData = SdkStrategy.INSTANCE.createStringByAdData(adData);
                if (strCreateStringByAdData == null) {
                    Intrinsics.throwNpe();
                }
                String requestId = adData.getRequestId();
                if (requestId == null) {
                    Intrinsics.throwNpe();
                }
                interstitialShowListener.onVideoStart(adType, strCreateStringByAdData, requestId);
            }
        };
        Iterator<T> it = TogetherAd.INSTANCE.getMProviders().entrySet().iterator();
        while (it.hasNext()) {
            BaseAdProvider baseAdProviderLoadAdProvider = AdProviderLoader.INSTANCE.loadAdProvider((String) ((Map.Entry) it.next()).getKey());
            if (baseAdProviderLoadAdProvider != null) {
                z = true;
                if (!baseAdProviderLoadAdProvider.interstitialAdIsBelongTheProvider(nestAdData)) {
                    z = false;
                }
            }
            if (z && baseAdProviderLoadAdProvider != null) {
                baseAdProviderLoadAdProvider.showInterstitialAd(activity, nestAdData, popShowListener);
            }
        }
    }
}
