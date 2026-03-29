package com.wifi.ad.core.helper;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.huawei.openalliance.ad.constant.bq;
import com.wifi.ad.core.config.AdParams;
import com.wifi.ad.core.listener.FeedBannerLoadListener;
import com.wifi.ad.core.p001const.WifiNestConst;
import com.wifi.ad.core.reporter.EventReporter;
import com.wifi.ad.core.strategy.LoadScene;
import com.wifi.ad.core.strategy.SdkStrategy;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J&\u0010\u0007\u001a\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u000b2\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\r¨\u0006\u000e"}, d2 = {"Lcom/wifi/ad/core/helper/AdHelperFeedBanner;", "Lcom/wifi/ad/core/helper/BaseHelper;", "()V", "destroyAd", "", "requestId", "", "getFeedBannerAd", "activity", "Landroid/app/Activity;", "adParams", "Lcom/wifi/ad/core/config/AdParams;", bq.f.s, "Lcom/wifi/ad/core/listener/FeedBannerLoadListener;", "core_release"}, k = 1, mv = {1, 1, 16})
public final class AdHelperFeedBanner extends BaseHelper {
    public static final AdHelperFeedBanner INSTANCE = new AdHelperFeedBanner();

    private AdHelperFeedBanner() {
    }

    public static /* synthetic */ void getFeedBannerAd$default(AdHelperFeedBanner adHelperFeedBanner, Activity activity, AdParams adParams, FeedBannerLoadListener feedBannerLoadListener, int i, Object obj) {
        if ((i & 4) != 0) {
            feedBannerLoadListener = null;
        }
        adHelperFeedBanner.getFeedBannerAd(activity, adParams, feedBannerLoadListener);
    }

    public final synchronized void getFeedBannerAd(@NonNull Activity activity, @NonNull final AdParams adParams, @NonNull final FeedBannerLoadListener listener) {
        ActivityPacker activityPacker = new ActivityPacker(activity);
        adParams.setNestType(WifiNestConst.NestTypeConst.NEST_FEED_NATIVE_AD);
        adParams.setRenderStyle$core_release(1);
        SdkStrategy sdkStrategy = new SdkStrategy();
        sdkStrategy.setFeedBannerLoadListener(new FeedBannerLoadListener() { // from class: com.wifi.ad.core.helper.AdHelperFeedBanner.getFeedBannerAd.1
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
        sdkStrategy.loadAd(activityPacker, adParams, LoadScene.FEED);
    }

    public final void destroyAd(String requestId) {
    }
}
