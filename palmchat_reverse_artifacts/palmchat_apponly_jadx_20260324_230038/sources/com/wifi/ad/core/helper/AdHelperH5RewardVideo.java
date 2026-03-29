package com.wifi.ad.core.helper;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.wifi.ad.core.TogetherAd;
import com.wifi.ad.core.config.AdParams;
import com.wifi.ad.core.config.AdProviderLoader;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.listener.FeedBannerLoadListener;
import com.wifi.ad.core.listener.InnerRewardShowListener;
import com.wifi.ad.core.listener.RewardShowListener;
import com.wifi.ad.core.p001const.WifiNestConst;
import com.wifi.ad.core.provider.BaseAdProvider;
import com.wifi.ad.core.reporter.EventReporter;
import com.wifi.ad.core.strategy.LoadScene;
import com.wifi.ad.core.strategy.SdkStrategy;
import com.wifi.ad.core.utils.WifiLog;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J&\u0010\u0007\u001a\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u000b2\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\rJ \u0010\u000e\u001a\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012¨\u0006\u0013"}, d2 = {"Lcom/wifi/ad/core/helper/AdHelperH5RewardVideo;", "Lcom/wifi/ad/core/helper/BaseHelper;", "()V", "destroyAd", "", "requestId", "", "getRewardAd", "activity", "Landroid/app/Activity;", "adParams", "Lcom/wifi/ad/core/config/AdParams;", "sdkListener", "Lcom/wifi/ad/core/listener/FeedBannerLoadListener;", "showRewardVideoAd", "nestAdData", "Lcom/wifi/ad/core/data/NestAdData;", "showListener", "Lcom/wifi/ad/core/listener/RewardShowListener;", "core_release"}, k = 1, mv = {1, 1, 16})
public final class AdHelperH5RewardVideo extends BaseHelper {
    public static final AdHelperH5RewardVideo INSTANCE = new AdHelperH5RewardVideo();

    private AdHelperH5RewardVideo() {
    }

    public static /* synthetic */ void getRewardAd$default(AdHelperH5RewardVideo adHelperH5RewardVideo, Activity activity, AdParams adParams, FeedBannerLoadListener feedBannerLoadListener, int i, Object obj) {
        if ((i & 4) != 0) {
            feedBannerLoadListener = null;
        }
        adHelperH5RewardVideo.getRewardAd(activity, adParams, feedBannerLoadListener);
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

    public final synchronized void getRewardAd(@NonNull Activity activity, @NonNull final AdParams adParams, @NonNull final FeedBannerLoadListener sdkListener) {
        ActivityPacker activityPacker = new ActivityPacker(activity);
        adParams.setNestType(WifiNestConst.NestTypeConst.NEST_REWARD_AD);
        adParams.setRenderStyle$core_release(2);
        SdkStrategy sdkStrategy = new SdkStrategy();
        sdkStrategy.setFeedBannerLoadListener(new FeedBannerLoadListener() { // from class: com.wifi.ad.core.helper.AdHelperH5RewardVideo.getRewardAd.1
            @Override // com.wifi.ad.core.listener.FeedBannerLoadListener
            public void onAdFailed(String errorCode, String message, String requestId) {
                WifiLog.d("AdHelperH5RewardVideo RewardAd onAdFailed");
                FeedBannerLoadListener feedBannerLoadListener = sdkListener;
                if (feedBannerLoadListener != null) {
                    feedBannerLoadListener.onAdFailed(errorCode, message, requestId);
                }
            }

            @Override // com.wifi.ad.core.listener.FeedBannerLoadListener
            public void onAdLoad(String providerType, String requestId) {
                WifiLog.d("AdHelperH5RewardVideo RewardAd onAdLoaded");
                FeedBannerLoadListener feedBannerLoadListener = sdkListener;
                if (feedBannerLoadListener != null) {
                    feedBannerLoadListener.onAdLoad(providerType, requestId);
                }
            }

            @Override // com.wifi.ad.core.listener.FeedBannerLoadListener
            public void onStart(String requestId) {
                WifiLog.d("AdHelperH5RewardVideo RewardAd onStart");
                FeedBannerLoadListener feedBannerLoadListener = sdkListener;
                if (feedBannerLoadListener != null) {
                    feedBannerLoadListener.onStart(requestId);
                }
                EventReporter.INSTANCE.reportReq(adParams);
            }
        });
        sdkStrategy.loadAd(activityPacker, adParams, LoadScene.REWARD);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void showRewardVideoAd(@NonNull Activity activity, NestAdData nestAdData, final RewardShowListener showListener) {
        boolean z;
        InnerRewardShowListener innerRewardShowListener = new InnerRewardShowListener() { // from class: com.wifi.ad.core.helper.AdHelperH5RewardVideo$showRewardVideoAd$innerRewardShowListener$1
            @Override // com.wifi.ad.core.listener.InnerRewardShowListener
            public void onAdClicked(String providerType, NestAdData adData) {
                RewardShowListener rewardShowListener = showListener;
                if (rewardShowListener == null) {
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
                rewardShowListener.onAdClicked(adType, strCreateStringByAdData, requestId);
            }

            @Override // com.wifi.ad.core.listener.InnerRewardShowListener
            public void onAdClose(String providerType, NestAdData adData) {
                RewardShowListener rewardShowListener = showListener;
                if (rewardShowListener == null) {
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
                rewardShowListener.onAdClose(adType, strCreateStringByAdData, requestId);
            }

            @Override // com.wifi.ad.core.listener.InnerRewardShowListener
            public void onAdExpose(String providerType, NestAdData adData) {
                RewardShowListener rewardShowListener = showListener;
                if (rewardShowListener == null) {
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
                rewardShowListener.onAdExposed(adType, strCreateStringByAdData, requestId);
            }

            @Override // com.wifi.ad.core.listener.InnerRewardShowListener
            public void onAdRewardVerify(String providerType, NestAdData adData) {
                RewardShowListener rewardShowListener = showListener;
                if (rewardShowListener == null) {
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
                rewardShowListener.onAdRewardVerify(adType, strCreateStringByAdData, requestId);
            }

            @Override // com.wifi.ad.core.listener.InnerRewardShowListener
            public void onDownloadComplete(String providerType, NestAdData adData) {
                RewardShowListener rewardShowListener = showListener;
                if (rewardShowListener == null) {
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
                rewardShowListener.onDownloadComplete(adType, strCreateStringByAdData, requestId);
            }

            @Override // com.wifi.ad.core.listener.InnerRewardShowListener
            public void onDownloadFailed(String providerType, NestAdData adData) {
                RewardShowListener rewardShowListener = showListener;
                if (rewardShowListener == null) {
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
                rewardShowListener.onDownloadFailed(adType, strCreateStringByAdData, requestId);
            }

            @Override // com.wifi.ad.core.listener.InnerRewardShowListener
            public void onDownloadInstalled(String providerType, NestAdData adData) {
                RewardShowListener rewardShowListener = showListener;
                if (rewardShowListener == null) {
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
                rewardShowListener.onDownloadInstalled(adType, strCreateStringByAdData, requestId);
            }

            @Override // com.wifi.ad.core.listener.InnerRewardShowListener
            public void onDownloadStart(String providerType, NestAdData adData) {
                RewardShowListener rewardShowListener = showListener;
                if (rewardShowListener == null) {
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
                rewardShowListener.onDownloadStart(adType, strCreateStringByAdData, requestId);
            }

            @Override // com.wifi.ad.core.listener.InnerRewardShowListener
            public void onVideoComplete(String providerType, NestAdData adData) {
                RewardShowListener rewardShowListener = showListener;
                if (rewardShowListener == null) {
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
                rewardShowListener.onVideoComplete(adType, strCreateStringByAdData, requestId);
            }

            @Override // com.wifi.ad.core.listener.InnerRewardShowListener
            public void onVideoError(String providerType, NestAdData adData) {
                RewardShowListener rewardShowListener = showListener;
                if (rewardShowListener == null) {
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
                rewardShowListener.onVideoError(adType, strCreateStringByAdData, requestId);
            }

            @Override // com.wifi.ad.core.listener.InnerRewardShowListener
            public void onVideoPause(String providerType, NestAdData adData) {
                RewardShowListener rewardShowListener = showListener;
                if (rewardShowListener == null) {
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
                rewardShowListener.onVideoPause(adType, strCreateStringByAdData, requestId);
            }

            @Override // com.wifi.ad.core.listener.InnerRewardShowListener
            public void onVideoStart(String providerType, NestAdData adData) {
                RewardShowListener rewardShowListener = showListener;
                if (rewardShowListener == null) {
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
                rewardShowListener.onVideoStart(adType, strCreateStringByAdData, requestId);
            }
        };
        Iterator<T> it = TogetherAd.INSTANCE.getMProviders().entrySet().iterator();
        while (it.hasNext()) {
            BaseAdProvider baseAdProviderLoadAdProvider = AdProviderLoader.INSTANCE.loadAdProvider((String) ((Map.Entry) it.next()).getKey());
            if (baseAdProviderLoadAdProvider != null) {
                z = true;
                if (!baseAdProviderLoadAdProvider.rewardAdIsBelongTheProvider(nestAdData)) {
                    z = false;
                }
            }
            if (z && baseAdProviderLoadAdProvider != null) {
                baseAdProviderLoadAdProvider.showRewardAd(activity, nestAdData, innerRewardShowListener);
            }
        }
    }
}
