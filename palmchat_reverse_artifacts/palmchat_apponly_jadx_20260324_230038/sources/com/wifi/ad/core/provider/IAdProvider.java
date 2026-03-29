package com.wifi.ad.core.provider;

import android.app.Activity;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.huawei.openalliance.ad.constant.bq;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.helper.ActivityPacker;
import com.wifi.ad.core.listener.BannerListener;
import com.wifi.ad.core.listener.InnerRewardShowListener;
import com.wifi.ad.core.listener.InterListener;
import com.wifi.ad.core.listener.NativeListener;
import com.wifi.ad.core.listener.PopShowListener;
import com.wifi.ad.core.listener.SplashShowListener;
import com.wifi.ad.core.strategy.IStrategyListener;
import com.wifi.ad.core.strategy.LoadScene;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\u0012\u0010\n\u001a\u00020\u00032\b\b\u0001\u0010\u000b\u001a\u00020\u0001H\u0016J\u0012\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u000b\u001a\u00020\u0005H\u0016J\u0012\u0010\u000e\u001a\u00020\r2\b\b\u0001\u0010\u000b\u001a\u00020\u0005H\u0016J\u0012\u0010\u000f\u001a\u00020\r2\b\b\u0001\u0010\u000b\u001a\u00020\u0005H\u0016J\u0012\u0010\u0010\u001a\u00020\r2\b\b\u0001\u0010\u000b\u001a\u00020\u0005H\u0016J0\u0010\u0011\u001a\u00020\u00032\b\b\u0001\u0010\u0012\u001a\u00020\u00132\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0014\u001a\u00020\u00152\b\b\u0001\u0010\u0016\u001a\u00020\u0017H\u0016J&\u0010\u0018\u001a\u00020\u00032\b\b\u0001\u0010\u0012\u001a\u00020\u00132\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0014\u001a\u00020\u0015H\u0016J&\u0010\u0019\u001a\u00020\u00032\b\b\u0001\u0010\u0012\u001a\u00020\u00132\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0014\u001a\u00020\u0015H\u0016J8\u0010\u001a\u001a\u00020\u00032\b\b\u0001\u0010\u001b\u001a\u00020\u001c2\b\b\u0001\u0010\u001d\u001a\u00020\u00072\b\b\u0001\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 2\b\b\u0001\u0010!\u001a\u00020\"H\u0016J&\u0010#\u001a\u00020\u00032\b\b\u0001\u0010\u0012\u001a\u00020\u00132\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0014\u001a\u00020\u0015H\u0016J&\u0010$\u001a\u00020\u00032\b\b\u0001\u0010\u0012\u001a\u00020\u00132\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0014\u001a\u00020\u0015H\u0016J&\u0010%\u001a\u00020\u00032\b\b\u0001\u0010\u0012\u001a\u00020\u00132\b\b\u0001\u0010&\u001a\u00020\u00052\b\b\u0001\u0010!\u001a\u00020\u0015H\u0016J&\u0010'\u001a\u00020\u00032\b\b\u0001\u0010\u0012\u001a\u00020\u00132\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0014\u001a\u00020\u0015H\u0016J\u0012\u0010(\u001a\u00020\r2\b\b\u0001\u0010\u000b\u001a\u00020\u0005H\u0016J\u0012\u0010)\u001a\u00020\r2\b\b\u0001\u0010\u000b\u001a\u00020\u0001H\u0016J\u0012\u0010*\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010+\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010,\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u0016J0\u0010-\u001a\u00020\u00032\b\b\u0001\u0010\u001b\u001a\u00020\u001c2\b\b\u0001\u0010\u001d\u001a\u00020\u00072\b\b\u0001\u0010\u001e\u001a\u00020\u00072\b\b\u0001\u0010!\u001a\u00020.H\u0016J&\u0010/\u001a\u00020\u00032\b\b\u0001\u0010\u0012\u001a\u00020\u00132\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0014\u001a\u00020\u0015H\u0016J\u0012\u00100\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u00101\u001a\u00020\u00032\b\b\u0001\u0010\u000b\u001a\u00020\u0001H\u0016J\u0012\u00102\u001a\u00020\r2\b\b\u0001\u0010\u000b\u001a\u00020\u0005H\u0016J:\u00103\u001a\u00020\u00032\b\b\u0001\u0010\u001b\u001a\u00020\u001c2\b\b\u0001\u0010\u001d\u001a\u00020\u00072\b\b\u0001\u0010\u001e\u001a\u00020\u00072\b\b\u0001\u00104\u001a\u0002052\b\b\u0001\u0010!\u001a\u000206H\u0016J\u0012\u00107\u001a\u00020\u00032\b\b\u0001\u0010\u001b\u001a\u00020\u001cH\u0016J\"\u00108\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0004\u001a\u00020\u00052\b\u00109\u001a\u0004\u0018\u00010:H\u0016J&\u0010;\u001a\u00020\u00032\b\b\u0001\u0010\u001b\u001a\u00020\u001c2\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\u00109\u001a\u0004\u0018\u00010<H\u0016J0\u0010=\u001a\u00020\u00032\b\b\u0001\u0010\u001b\u001a\u00020\u001c2\b\b\u0001\u0010&\u001a\u00020\u00052\b\b\u0001\u00104\u001a\u0002052\b\b\u0001\u0010>\u001a\u00020?H\u0016J\u0012\u0010@\u001a\u00020\r2\b\b\u0001\u0010\u000b\u001a\u00020\u0005H\u0016J\u0012\u0010A\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010B\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006C"}, d2 = {"Lcom/wifi/ad/core/provider/IAdProvider;", "", "destroyAd", "", "nestAdData", "Lcom/wifi/ad/core/data/NestAdData;", "requestId", "", "destroyBannerAd", "destroyInterAd", "destroyNativeAd", "adObject", "drawAdIsBelongTheProvider", "", "drawNativeAdIsBelongTheProvider", "feedAdIsBelongTheProvider", "feedNativeAdIsBelongTheProvider", "getCorrectAd", "packer", "Lcom/wifi/ad/core/helper/ActivityPacker;", "listenerStrategy", "Lcom/wifi/ad/core/strategy/IStrategyListener;", "scene", "Lcom/wifi/ad/core/strategy/LoadScene;", "getDrawVideoAd", "getInterstitialAd", "getNativeAdList", "activity", "Landroid/app/Activity;", "adProviderType", "alias", "maxCount", "", bq.f.s, "Lcom/wifi/ad/core/listener/NativeListener;", "getNativeDrawVideoAd", "getNativeFeedAd", "getSplashAd", "adData", "getTemplateFeedAd", "interstitialAdIsBelongTheProvider", "nativeAdIsBelongTheProvider", "onNestAdLoad", "onNestAdUnLoad", "pauseAd", "requestInterAd", "Lcom/wifi/ad/core/listener/InterListener;", "requestRewardAd", "resumeAd", "resumeNativeAd", "rewardAdIsBelongTheProvider", "showBannerAd", "container", "Landroid/view/ViewGroup;", "Lcom/wifi/ad/core/listener/BannerListener;", "showInterAd", "showInterstitialAd", "showListener", "Lcom/wifi/ad/core/listener/PopShowListener;", "showRewardAd", "Lcom/wifi/ad/core/listener/InnerRewardShowListener;", "showSplashAd", "splashShowListener", "Lcom/wifi/ad/core/listener/SplashShowListener;", "splashAdIsBelongTheProvider", "startAd", "stopAd", "core_release"}, k = 1, mv = {1, 1, 16})
public interface IAdProvider {

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    public static final class DefaultImpls {
        public static void destroyAd(IAdProvider iAdProvider, @NonNull NestAdData nestAdData) {
        }

        public static boolean drawAdIsBelongTheProvider(IAdProvider iAdProvider, @NonNull NestAdData nestAdData) {
            return false;
        }

        public static boolean drawNativeAdIsBelongTheProvider(IAdProvider iAdProvider, @NonNull NestAdData nestAdData) {
            return false;
        }

        public static boolean feedAdIsBelongTheProvider(IAdProvider iAdProvider, @NonNull NestAdData nestAdData) {
            return false;
        }

        public static boolean feedNativeAdIsBelongTheProvider(IAdProvider iAdProvider, @NonNull NestAdData nestAdData) {
            return false;
        }

        public static boolean interstitialAdIsBelongTheProvider(IAdProvider iAdProvider, @NonNull NestAdData nestAdData) {
            return false;
        }

        public static boolean nativeAdIsBelongTheProvider(IAdProvider iAdProvider, @NonNull Object obj) {
            return false;
        }

        public static boolean rewardAdIsBelongTheProvider(IAdProvider iAdProvider, @NonNull NestAdData nestAdData) {
            return false;
        }

        public static boolean splashAdIsBelongTheProvider(IAdProvider iAdProvider, @NonNull NestAdData nestAdData) {
            return false;
        }

        public static void destroyAd(IAdProvider iAdProvider, String str) {
        }

        public static void destroyBannerAd(IAdProvider iAdProvider) {
        }

        public static void destroyInterAd(IAdProvider iAdProvider) {
        }

        public static void destroyNativeAd(IAdProvider iAdProvider, @NonNull Object obj) {
        }

        public static void onNestAdLoad(IAdProvider iAdProvider, @NonNull NestAdData nestAdData) {
        }

        public static void onNestAdUnLoad(IAdProvider iAdProvider, @NonNull NestAdData nestAdData) {
        }

        public static void pauseAd(IAdProvider iAdProvider, @NonNull NestAdData nestAdData) {
        }

        public static void resumeAd(IAdProvider iAdProvider, @NonNull NestAdData nestAdData) {
        }

        public static void resumeNativeAd(IAdProvider iAdProvider, @NonNull Object obj) {
        }

        public static void showInterAd(IAdProvider iAdProvider, @NonNull Activity activity) {
        }

        public static void startAd(IAdProvider iAdProvider, @NonNull NestAdData nestAdData) {
        }

        public static void stopAd(IAdProvider iAdProvider, @NonNull NestAdData nestAdData) {
        }

        public static void getDrawVideoAd(IAdProvider iAdProvider, @NonNull ActivityPacker activityPacker, @NonNull NestAdData nestAdData, @NonNull IStrategyListener iStrategyListener) {
        }

        public static void getInterstitialAd(IAdProvider iAdProvider, @NonNull ActivityPacker activityPacker, @NonNull NestAdData nestAdData, @NonNull IStrategyListener iStrategyListener) {
        }

        public static void getNativeDrawVideoAd(IAdProvider iAdProvider, @NonNull ActivityPacker activityPacker, @NonNull NestAdData nestAdData, @NonNull IStrategyListener iStrategyListener) {
        }

        public static void getNativeFeedAd(IAdProvider iAdProvider, @NonNull ActivityPacker activityPacker, @NonNull NestAdData nestAdData, @NonNull IStrategyListener iStrategyListener) {
        }

        public static void getSplashAd(IAdProvider iAdProvider, @NonNull ActivityPacker activityPacker, @NonNull NestAdData nestAdData, @NonNull IStrategyListener iStrategyListener) {
        }

        public static void getTemplateFeedAd(IAdProvider iAdProvider, @NonNull ActivityPacker activityPacker, @NonNull NestAdData nestAdData, @NonNull IStrategyListener iStrategyListener) {
        }

        public static void requestRewardAd(IAdProvider iAdProvider, @NonNull ActivityPacker activityPacker, @NonNull NestAdData nestAdData, @NonNull IStrategyListener iStrategyListener) {
        }

        public static void showInterstitialAd(IAdProvider iAdProvider, Activity activity, NestAdData nestAdData, PopShowListener popShowListener) {
        }

        public static void showRewardAd(IAdProvider iAdProvider, @NonNull Activity activity, @NonNull NestAdData nestAdData, InnerRewardShowListener innerRewardShowListener) {
        }

        public static void getCorrectAd(IAdProvider iAdProvider, @NonNull ActivityPacker activityPacker, @NonNull NestAdData nestAdData, @NonNull IStrategyListener iStrategyListener, @NonNull LoadScene loadScene) {
        }

        public static void requestInterAd(IAdProvider iAdProvider, @NonNull Activity activity, @NonNull String str, @NonNull String str2, @NonNull InterListener interListener) {
        }

        public static void showSplashAd(IAdProvider iAdProvider, @NonNull Activity activity, @NonNull NestAdData nestAdData, @NonNull ViewGroup viewGroup, @NonNull SplashShowListener splashShowListener) {
        }

        public static void getNativeAdList(IAdProvider iAdProvider, @NonNull Activity activity, @NonNull String str, @NonNull String str2, int i, @NonNull NativeListener nativeListener) {
        }

        public static void showBannerAd(IAdProvider iAdProvider, @NonNull Activity activity, @NonNull String str, @NonNull String str2, @NonNull ViewGroup viewGroup, @NonNull BannerListener bannerListener) {
        }
    }

    void destroyAd(@NonNull NestAdData nestAdData);

    void destroyAd(String requestId);

    void destroyBannerAd();

    void destroyInterAd();

    void destroyNativeAd(@NonNull Object adObject);

    boolean drawAdIsBelongTheProvider(@NonNull NestAdData adObject);

    boolean drawNativeAdIsBelongTheProvider(@NonNull NestAdData adObject);

    boolean feedAdIsBelongTheProvider(@NonNull NestAdData adObject);

    boolean feedNativeAdIsBelongTheProvider(@NonNull NestAdData adObject);

    void getCorrectAd(@NonNull ActivityPacker packer, @NonNull NestAdData nestAdData, @NonNull IStrategyListener listenerStrategy, @NonNull LoadScene scene);

    void getDrawVideoAd(@NonNull ActivityPacker packer, @NonNull NestAdData nestAdData, @NonNull IStrategyListener listenerStrategy);

    void getInterstitialAd(@NonNull ActivityPacker packer, @NonNull NestAdData nestAdData, @NonNull IStrategyListener listenerStrategy);

    void getNativeAdList(@NonNull Activity activity, @NonNull String adProviderType, @NonNull String alias, int maxCount, @NonNull NativeListener listener);

    void getNativeDrawVideoAd(@NonNull ActivityPacker packer, @NonNull NestAdData nestAdData, @NonNull IStrategyListener listenerStrategy);

    void getNativeFeedAd(@NonNull ActivityPacker packer, @NonNull NestAdData nestAdData, @NonNull IStrategyListener listenerStrategy);

    void getSplashAd(@NonNull ActivityPacker packer, @NonNull NestAdData adData, @NonNull IStrategyListener listener);

    void getTemplateFeedAd(@NonNull ActivityPacker packer, @NonNull NestAdData nestAdData, @NonNull IStrategyListener listenerStrategy);

    boolean interstitialAdIsBelongTheProvider(@NonNull NestAdData adObject);

    boolean nativeAdIsBelongTheProvider(@NonNull Object adObject);

    void onNestAdLoad(@NonNull NestAdData nestAdData);

    void onNestAdUnLoad(@NonNull NestAdData nestAdData);

    void pauseAd(@NonNull NestAdData nestAdData);

    void requestInterAd(@NonNull Activity activity, @NonNull String adProviderType, @NonNull String alias, @NonNull InterListener listener);

    void requestRewardAd(@NonNull ActivityPacker packer, @NonNull NestAdData nestAdData, @NonNull IStrategyListener listenerStrategy);

    void resumeAd(@NonNull NestAdData nestAdData);

    void resumeNativeAd(@NonNull Object adObject);

    boolean rewardAdIsBelongTheProvider(@NonNull NestAdData adObject);

    void showBannerAd(@NonNull Activity activity, @NonNull String adProviderType, @NonNull String alias, @NonNull ViewGroup container, @NonNull BannerListener listener);

    void showInterAd(@NonNull Activity activity);

    void showInterstitialAd(Activity activity, NestAdData nestAdData, PopShowListener showListener);

    void showRewardAd(@NonNull Activity activity, @NonNull NestAdData nestAdData, InnerRewardShowListener showListener);

    void showSplashAd(@NonNull Activity activity, @NonNull NestAdData adData, @NonNull ViewGroup container, @NonNull SplashShowListener splashShowListener);

    boolean splashAdIsBelongTheProvider(@NonNull NestAdData adObject);

    void startAd(@NonNull NestAdData nestAdData);

    void stopAd(@NonNull NestAdData nestAdData);
}
