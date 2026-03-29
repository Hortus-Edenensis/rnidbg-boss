package com.wifi.ad.core.helper;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.wifi.ad.core.TogetherAd;
import com.wifi.ad.core.config.AdParams;
import com.wifi.ad.core.config.AdProviderLoader;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.listener.SplashLoadListener;
import com.wifi.ad.core.listener.SplashShowListener;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nJ0\u0010\u000b\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011¨\u0006\u0012"}, d2 = {"Lcom/wifi/ad/core/helper/AdHelperSplash;", "Lcom/wifi/ad/core/helper/BaseHelper;", "()V", "getSplashAd", "", "activity", "Landroid/app/Activity;", "adParams", "Lcom/wifi/ad/core/config/AdParams;", "loadListener", "Lcom/wifi/ad/core/listener/SplashLoadListener;", "showSplashAd", "adNestData", "Lcom/wifi/ad/core/data/NestAdData;", "container", "Landroid/view/ViewGroup;", "showListener", "Lcom/wifi/ad/core/listener/SplashShowListener;", "core_release"}, k = 1, mv = {1, 1, 16})
public final class AdHelperSplash extends BaseHelper {
    public static final AdHelperSplash INSTANCE = new AdHelperSplash();

    private AdHelperSplash() {
    }

    public static /* synthetic */ void getSplashAd$default(AdHelperSplash adHelperSplash, Activity activity, AdParams adParams, SplashLoadListener splashLoadListener, int i, Object obj) {
        if ((i & 4) != 0) {
            splashLoadListener = null;
        }
        adHelperSplash.getSplashAd(activity, adParams, splashLoadListener);
    }

    public static /* synthetic */ void showSplashAd$default(AdHelperSplash adHelperSplash, Activity activity, NestAdData nestAdData, ViewGroup viewGroup, SplashShowListener splashShowListener, int i, Object obj) {
        if ((i & 8) != 0) {
            splashShowListener = null;
        }
        adHelperSplash.showSplashAd(activity, nestAdData, viewGroup, splashShowListener);
    }

    public final void getSplashAd(@NonNull Activity activity, @NonNull final AdParams adParams, final SplashLoadListener loadListener) {
        ActivityPacker activityPacker = new ActivityPacker(activity);
        adParams.setNestType(WifiNestConst.NestTypeConst.NEST_SPLASH_AD);
        StrategyManager strategyManager = StrategyManager.INSTANCE;
        Context appContext = activityPacker.getAppContext();
        Intrinsics.checkExpressionValueIsNotNull(appContext, "packer.appContext");
        AbsStrategy currentStrategy = strategyManager.getCurrentStrategy(adParams, loadListener, appContext);
        if (currentStrategy != null) {
            WifiLog.d("splashAd getSplashAd strategy " + currentStrategy);
            currentStrategy.setLoadListener(new SplashLoadListener() { // from class: com.wifi.ad.core.helper.AdHelperSplash$getSplashAd$splashListener$1
                @Override // com.wifi.ad.core.listener.SplashLoadListener, com.wifi.ad.core.listener.BaseListener
                public void onAdFailed(String errorCode, String message) {
                    SplashLoadListener splashLoadListener = loadListener;
                    if (splashLoadListener != null) {
                        splashLoadListener.onAdFailed(errorCode, message);
                    }
                }

                @Override // com.wifi.ad.core.listener.SplashLoadListener, com.wifi.ad.core.listener.BaseListener
                public void onAdLoaded(@NonNull String providerType, @NonNull List<NestAdData> adList) {
                    SplashLoadListener splashLoadListener = loadListener;
                    if (splashLoadListener != null) {
                        splashLoadListener.onAdLoaded(providerType, adList);
                    }
                }

                @Override // com.wifi.ad.core.listener.SplashLoadListener, com.wifi.ad.core.listener.BaseListener
                public void onStart() {
                    EventReporter.INSTANCE.reportReq(adParams);
                    SplashLoadListener splashLoadListener = loadListener;
                    if (splashLoadListener != null) {
                        splashLoadListener.onStart();
                    }
                }
            });
            currentStrategy.loadAd(activityPacker, adParams, LoadScene.SPLASH);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void showSplashAd(@NonNull Activity activity, @NonNull NestAdData adNestData, @NonNull ViewGroup container, SplashShowListener showListener) {
        boolean z;
        if (adNestData.getAdSPStrategy()) {
            adNestData = SPCacheManager.INSTANCE.changeCheckMaxAd(adNestData);
        }
        if (adNestData != null) {
            if (showListener != null) {
                adNestData.setSplashShowListener(showListener);
            }
            Iterator<T> it = TogetherAd.INSTANCE.getMProviders().entrySet().iterator();
            while (it.hasNext()) {
                BaseAdProvider baseAdProviderLoadAdProvider = AdProviderLoader.INSTANCE.loadAdProvider((String) ((Map.Entry) it.next()).getKey());
                if (baseAdProviderLoadAdProvider != null) {
                    z = baseAdProviderLoadAdProvider.splashAdIsBelongTheProvider(adNestData);
                }
                if (z && showListener != null && baseAdProviderLoadAdProvider != null) {
                    baseAdProviderLoadAdProvider.showSplashAd(activity, adNestData, container, showListener);
                }
            }
        }
    }
}
