package com.wifi.ad.core.helper;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.huawei.openalliance.ad.constant.bq;
import com.wifi.ad.core.TogetherAd;
import com.wifi.ad.core.config.AdParams;
import com.wifi.ad.core.config.AdProviderLoader;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.listener.RewardListener;
import com.wifi.ad.core.p001const.WifiNestConst;
import com.wifi.ad.core.provider.BaseAdProvider;
import com.wifi.ad.core.reporter.EventReporter;
import com.wifi.ad.core.spstrategy.SPCacheManager;
import com.wifi.ad.core.strategy.AbsStrategy;
import com.wifi.ad.core.strategy.LoadScene;
import com.wifi.ad.core.strategy.StrategyManager;
import com.wifi.ad.core.utils.WifiLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\nJ\u0016\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r¨\u0006\u000e"}, d2 = {"Lcom/wifi/ad/core/helper/AdHelperReward;", "Lcom/wifi/ad/core/helper/BaseHelper;", "()V", "getRewardAd", "", "activity", "Landroid/app/Activity;", "adParams", "Lcom/wifi/ad/core/config/AdParams;", bq.f.s, "Lcom/wifi/ad/core/listener/RewardListener;", "showRewardAd", "nestAdData", "Lcom/wifi/ad/core/data/NestAdData;", "core_release"}, k = 1, mv = {1, 1, 16})
public final class AdHelperReward extends BaseHelper {
    public static final AdHelperReward INSTANCE = new AdHelperReward();

    private AdHelperReward() {
    }

    public final synchronized void getRewardAd(@NonNull Activity activity, @NonNull final AdParams adParams, @NonNull final RewardListener listener) {
        ActivityPacker activityPacker = new ActivityPacker(activity);
        WifiLog.d("getRewardAd");
        adParams.setNestType(WifiNestConst.NestTypeConst.NEST_REWARD_AD);
        adParams.setRenderStyle$core_release(2);
        StrategyManager strategyManager = StrategyManager.INSTANCE;
        Context appContext = activityPacker.getAppContext();
        Intrinsics.checkExpressionValueIsNotNull(appContext, "packer.appContext");
        AbsStrategy currentStrategy = strategyManager.getCurrentStrategy(adParams, listener, appContext);
        if (currentStrategy != null) {
            RewardListener rewardListener = new RewardListener() { // from class: com.wifi.ad.core.helper.AdHelperReward$getRewardAd$rewardListener$1
                @Override // com.wifi.ad.core.listener.RewardListener
                public void onAdClicked(NestAdData adData) {
                    RewardListener.DefaultImpls.onAdClicked(this, adData);
                    WifiLog.d("AdHelperReward RewardAd onAdClicked");
                    RewardListener rewardListener2 = listener;
                    if (rewardListener2 != null) {
                        rewardListener2.onAdClicked(adData);
                    }
                }

                @Override // com.wifi.ad.core.listener.RewardListener
                public void onAdClose(NestAdData adData) {
                    RewardListener.DefaultImpls.onAdClose(this, adData);
                    WifiLog.d("AdHelperReward RewardAd onAdClose");
                    RewardListener rewardListener2 = listener;
                    if (rewardListener2 != null) {
                        rewardListener2.onAdClose(adData);
                    }
                }

                @Override // com.wifi.ad.core.listener.RewardListener
                public void onAdExpose(NestAdData adData) {
                    RewardListener.DefaultImpls.onAdExpose(this, adData);
                    WifiLog.d("AdHelperReward RewardAd onAdExpose");
                    RewardListener rewardListener2 = listener;
                    if (rewardListener2 != null) {
                        rewardListener2.onAdExpose(adData);
                    }
                }

                @Override // com.wifi.ad.core.listener.RewardListener, com.wifi.ad.core.listener.BaseListener
                public void onAdFailed(String errorCode, String message) {
                    WifiLog.d("AdHelperReward RewardAd onAdFailed errorCode = " + errorCode + " message = " + message);
                    RewardListener rewardListener2 = listener;
                    if (rewardListener2 != null) {
                        rewardListener2.onAdFailed(errorCode, message);
                    }
                }

                @Override // com.wifi.ad.core.listener.RewardListener, com.wifi.ad.core.listener.BaseListener
                public void onAdLoaded(String providerType, List<NestAdData> adList) {
                    WifiLog.d("AdHelperReward RewardAd onAdLoaded " + adList);
                    RewardListener rewardListener2 = listener;
                    if (rewardListener2 != null) {
                        rewardListener2.onAdLoaded(providerType, adList);
                    }
                }

                @Override // com.wifi.ad.core.listener.RewardListener
                public void onAdRewardVerify(NestAdData adData) {
                    WifiLog.d("AdHelperReward RewardAd onAdRewardVerify");
                    RewardListener rewardListener2 = listener;
                    if (rewardListener2 != null) {
                        rewardListener2.onAdRewardVerify(adData);
                    }
                }

                @Override // com.wifi.ad.core.listener.RewardListener
                public void onAdShow(NestAdData adData) {
                    RewardListener.DefaultImpls.onAdShow(this, adData);
                    WifiLog.d("AdHelperReward RewardAd onAdShow");
                    RewardListener rewardListener2 = listener;
                    if (rewardListener2 != null) {
                        rewardListener2.onAdShow(adData);
                    }
                }

                @Override // com.wifi.ad.core.listener.RewardListener
                public void onAdVideoCached(NestAdData adData) {
                    RewardListener.DefaultImpls.onAdVideoCached(this, adData);
                    WifiLog.d("AdHelperReward RewardAd onAdVideoCached");
                    RewardListener rewardListener2 = listener;
                    if (rewardListener2 != null) {
                        rewardListener2.onAdVideoCached(adData);
                    }
                }

                @Override // com.wifi.ad.core.listener.RewardListener
                public void onAdVideoComplete(NestAdData adData) {
                    RewardListener.DefaultImpls.onAdVideoComplete(this, adData);
                    WifiLog.d("AdHelperReward RewardAd onAdVideoComplete");
                    RewardListener rewardListener2 = listener;
                    if (rewardListener2 != null) {
                        rewardListener2.onAdVideoComplete(adData);
                    }
                }

                @Override // com.wifi.ad.core.listener.RewardListener, com.wifi.ad.core.listener.BaseListener
                public void onStart() {
                    WifiLog.d("AdHelperReward RewardAd onStart");
                    RewardListener rewardListener2 = listener;
                    if (rewardListener2 != null) {
                        rewardListener2.onStart();
                    }
                    EventReporter.INSTANCE.reportReq(adParams);
                }

                @Override // com.wifi.ad.core.listener.RewardListener
                public void onVideoPreloadFailed(@NonNull NestAdData nestAdData) {
                    RewardListener.DefaultImpls.onVideoPreloadFailed(this, nestAdData);
                }
            };
            currentStrategy.setLoadListener(rewardListener);
            currentStrategy.setAdRewardListener(rewardListener);
            currentStrategy.loadAd(activityPacker, adParams, LoadScene.REWARD);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void showRewardAd(Activity activity, NestAdData nestAdData) {
        boolean z;
        if (nestAdData.getAdSPStrategy()) {
            nestAdData = SPCacheManager.INSTANCE.changeCheckMaxAd(nestAdData);
        }
        Iterator<T> it = TogetherAd.INSTANCE.getMProviders().entrySet().iterator();
        while (it.hasNext()) {
            BaseAdProvider baseAdProviderLoadAdProvider = AdProviderLoader.INSTANCE.loadAdProvider((String) ((Map.Entry) it.next()).getKey());
            if (baseAdProviderLoadAdProvider != null) {
                z = baseAdProviderLoadAdProvider.rewardAdIsBelongTheProvider(nestAdData);
            }
            if (z && baseAdProviderLoadAdProvider != null) {
                baseAdProviderLoadAdProvider.showRewardAd(activity, nestAdData, null);
            }
        }
    }
}
