package com.wifi.baidu.ad;

import android.app.Activity;
import android.view.ViewGroup;
import com.huawei.openalliance.ad.constant.bq;
import com.wifi.WkInitManager;
import com.wifi.ad.core.compliance.RequestSDKConfig;
import com.wifi.ad.core.config.EventParams;
import com.wifi.ad.core.custom.flow.BaseNativeView;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.helper.ActivityPacker;
import com.wifi.ad.core.listener.BannerListener;
import com.wifi.ad.core.listener.InnerRewardShowListener;
import com.wifi.ad.core.listener.InterListener;
import com.wifi.ad.core.listener.NativeListener;
import com.wifi.ad.core.listener.PopShowListener;
import com.wifi.ad.core.listener.SplashShowListener;
import com.wifi.ad.core.provider.BaseAdProvider;
import com.wifi.ad.core.strategy.IStrategyListener;
import com.wifi.ad.core.strategy.LoadScene;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 J2\u00020\u0001:\u0001JB\u0005¢\u0006\u0002\u0010\u0002J*\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\tH\u0016J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\tH\u0016J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\tH\u0016J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\tH\u0016J\u0018\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0002J(\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J \u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0016J \u0010 \u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0002J \u0010!\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0016J0\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J \u0010+\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0016J \u0010,\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0012\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010%\u001a\u00020\u0004H\u0016J \u0010/\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0002J \u00100\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0016J \u00101\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u00102\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\tH\u0016J\u0010\u00103\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u00104\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH\u0016J(\u00105\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u00042\u0006\u0010)\u001a\u000206H\u0016J \u00107\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u00108\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u00109\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J0\u0010:\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u00042\u0006\u0010;\u001a\u00020<2\u0006\u0010)\u001a\u00020=H\u0016J\u0010\u0010>\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020$H\u0016J\"\u0010?\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020$2\u0006\u0010\b\u001a\u00020\t2\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\"\u0010B\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020$2\u0006\u0010\b\u001a\u00020\t2\b\u0010@\u001a\u0004\u0018\u00010CH\u0016J(\u0010D\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020$2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010;\u001a\u00020<2\u0006\u0010E\u001a\u00020FH\u0016J\u0010\u0010G\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\tH\u0016J\u0010\u0010H\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010I\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Lcom/wifi/baidu/ad/NestBdProvider;", "Lcom/wifi/ad/core/provider/BaseAdProvider;", "()V", "TAG", "", "bdbinddingallow", "", "ecpmLevel", "nestAdData", "Lcom/wifi/ad/core/data/NestAdData;", "builder", "Lcom/wifi/ad/core/config/EventParams$Builder;", "listenerStrategy", "Lcom/wifi/ad/core/strategy/IStrategyListener;", "destroyAd", "", "destroyBannerAd", "destroyInterAd", "destroyNativeAd", "adObject", "", "drawAdIsBelongTheProvider", "drawNativeAdIsBelongTheProvider", "feedAdIsBelongTheProvider", "feedNativeAdIsBelongTheProvider", "getAdEcpmInt", "getCorrectAd", "packer", "Lcom/wifi/ad/core/helper/ActivityPacker;", "scene", "Lcom/wifi/ad/core/strategy/LoadScene;", "getDrawVideoAd", "getFeedAd", "getInterstitialAd", "getNativeAdList", "activity", "Landroid/app/Activity;", "adProviderType", "alias", "maxCount", "", bq.f.s, "Lcom/wifi/ad/core/listener/NativeListener;", "getNativeDrawVideoAd", "getNativeFeedAd", "getNativeView", "Lcom/wifi/ad/core/custom/flow/BaseNativeView;", "getNewTemplateAd", "getSplashAd", "getTemplateFeedAd", "interstitialAdIsBelongTheProvider", "nativeAdIsBelongTheProvider", "pauseAd", "requestInterAd", "Lcom/wifi/ad/core/listener/InterListener;", "requestRewardAd", "resumeAd", "resumeNativeAd", "showBannerAd", "container", "Landroid/view/ViewGroup;", "Lcom/wifi/ad/core/listener/BannerListener;", "showInterAd", "showInterstitialAd", "showListener", "Lcom/wifi/ad/core/listener/PopShowListener;", "showRewardAd", "Lcom/wifi/ad/core/listener/InnerRewardShowListener;", "showSplashAd", "splashShowListener", "Lcom/wifi/ad/core/listener/SplashShowListener;", "splashAdIsBelongTheProvider", "startAd", "stopAd", "Companion", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
public final class NestBdProvider extends BaseAdProvider {
    public static final String DSP_NAME = "baidu_out";
    public static final String SDK_FROM = "baidu";
    private final String TAG = "NestBdProvider";

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LoadScene.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[LoadScene.DRAWAD.ordinal()] = 1;
            iArr[LoadScene.FEED.ordinal()] = 2;
            iArr[LoadScene.SPLASH.ordinal()] = 3;
            iArr[LoadScene.INTERSTITIAL.ordinal()] = 4;
        }
    }

    private final boolean bdbinddingallow(String ecpmLevel, NestAdData nestAdData, EventParams.Builder builder, IStrategyListener listenerStrategy) {
        return false;
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
        if (!NestBdManager.INSTANCE.getInitDone()) {
            listenerStrategy.onAdFailed(nestAdData, "sdk not init", -1001);
            return;
        }
        if (!RequestSDKConfig.INSTANCE.checkAllowRequest(nestAdData.getAdScene(), WkInitManager.sdk_bd)) {
            listenerStrategy.onAdFailed(nestAdData, "sdk RequestSDKConfig not allow", -1002);
            return;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[scene.ordinal()];
        if (i == 1) {
            if (1 == nestAdData.getRenderStyle()) {
                getNativeDrawVideoAd(packer, nestAdData, listenerStrategy);
                return;
            } else {
                getDrawVideoAd(packer, nestAdData, listenerStrategy);
                return;
            }
        }
        if (i == 2) {
            if (1 != nestAdData.getRenderStyle()) {
                getTemplateFeedAd(packer, nestAdData, listenerStrategy);
                return;
            } else {
                nestAdData.setNativeAd(true);
                getNativeFeedAd(packer, nestAdData, listenerStrategy);
                return;
            }
        }
        if (i == 3) {
            getSplashAd(packer, nestAdData, listenerStrategy);
        } else {
            if (i != 4) {
                return;
            }
            getInterstitialAd(packer, nestAdData, listenerStrategy);
        }
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider
    public BaseNativeView getNativeView(String adProviderType) {
        return null;
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public boolean interstitialAdIsBelongTheProvider(NestAdData adObject) {
        return false;
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public boolean nativeAdIsBelongTheProvider(Object adObject) {
        return false;
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public boolean splashAdIsBelongTheProvider(NestAdData adObject) {
        return false;
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void destroyBannerAd() {
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void destroyInterAd() {
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void destroyAd(NestAdData nestAdData) {
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void destroyNativeAd(Object adObject) {
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void pauseAd(NestAdData nestAdData) {
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void resumeAd(NestAdData nestAdData) {
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void resumeNativeAd(Object adObject) {
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void showInterAd(Activity activity) {
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void startAd(NestAdData nestAdData) {
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void stopAd(NestAdData nestAdData) {
    }

    private final void getAdEcpmInt(String ecpmLevel, NestAdData nestAdData) {
    }

    private final void getFeedAd(ActivityPacker packer, NestAdData nestAdData, IStrategyListener listenerStrategy) {
    }

    private final void getNewTemplateAd(ActivityPacker packer, NestAdData nestAdData, IStrategyListener listenerStrategy) {
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void getDrawVideoAd(ActivityPacker packer, NestAdData nestAdData, IStrategyListener listenerStrategy) {
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void getInterstitialAd(ActivityPacker packer, NestAdData nestAdData, IStrategyListener listenerStrategy) {
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void getNativeDrawVideoAd(ActivityPacker packer, NestAdData nestAdData, IStrategyListener listenerStrategy) {
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void getNativeFeedAd(ActivityPacker packer, NestAdData nestAdData, IStrategyListener listenerStrategy) {
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void getSplashAd(ActivityPacker packer, NestAdData nestAdData, IStrategyListener listenerStrategy) {
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void getTemplateFeedAd(ActivityPacker packer, NestAdData nestAdData, IStrategyListener listenerStrategy) {
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void requestRewardAd(ActivityPacker packer, NestAdData nestAdData, IStrategyListener listenerStrategy) {
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void showInterstitialAd(Activity activity, NestAdData nestAdData, PopShowListener showListener) {
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void showRewardAd(Activity activity, NestAdData nestAdData, InnerRewardShowListener showListener) {
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void requestInterAd(Activity activity, String adProviderType, String alias, InterListener listener) {
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void showSplashAd(Activity activity, NestAdData nestAdData, ViewGroup container, SplashShowListener splashShowListener) {
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void getNativeAdList(Activity activity, String adProviderType, String alias, int maxCount, NativeListener listener) {
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void showBannerAd(Activity activity, String adProviderType, String alias, ViewGroup container, BannerListener listener) {
    }
}
