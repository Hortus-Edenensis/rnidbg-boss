package com.wifi.gdt.ad;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.openalliance.ad.constant.bq;
import com.qq.e.ads.banner2.UnifiedBannerADListener;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeADUnifiedListener;
import com.qq.e.ads.nativ.NativeExpressAD;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.ads.nativ.NativeUnifiedAD;
import com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.rewardvideo.RewardVideoAD;
import com.qq.e.ads.rewardvideo.RewardVideoADListener;
import com.qq.e.ads.splash.SplashAD;
import com.qq.e.ads.splash.SplashADListener;
import com.qq.e.comm.pi.AdData;
import com.qq.e.comm.pi.LADI;
import com.qq.e.comm.util.AdError;
import com.wifi.ad.core.SDKAlias;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.compliance.RequestSDKConfig;
import com.wifi.ad.core.config.AdParams;
import com.wifi.ad.core.config.EventParams;
import com.wifi.ad.core.custom.flow.BaseNativeView;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.entity.AdSize;
import com.wifi.ad.core.entity.SensitiveInfo;
import com.wifi.ad.core.helper.ActivityPacker;
import com.wifi.ad.core.listener.BannerListener;
import com.wifi.ad.core.listener.InnerRewardShowListener;
import com.wifi.ad.core.listener.InterListener;
import com.wifi.ad.core.listener.NativeListener;
import com.wifi.ad.core.listener.PopShowListener;
import com.wifi.ad.core.listener.SplashShowListener;
import com.wifi.ad.core.p001const.WifiNestConst;
import com.wifi.ad.core.provider.BaseAdProvider;
import com.wifi.ad.core.reporter.EventReporter;
import com.wifi.ad.core.spstrategy.PSSDCardGdtDemo;
import com.wifi.ad.core.strategy.IStrategyListener;
import com.wifi.ad.core.strategy.LoadScene;
import com.wifi.ad.core.utils.LogExtKt;
import com.wifi.ad.core.utils.WifiLog;
import com.wifi.gdt.ad.NestGdtNativeView;
import com.wifi.gdt.ad.NestGdtProvider;
import com.wifi.gdt.ad.data.GdtExpressAdDataAdapter;
import com.wifi.gdt.ad.data.GdtNativeDataAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONArray;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 l2\u00020\u0001:\u0001lB\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J2\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0013H\u0002J7\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0010\u001a\u00020\u00162\b\u0010\u0011\u001a\u0004\u0018\u00010\u00172\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0002\u0010\u0018J6\u0010\u0019\u001a\u00020\n2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0013H\u0002JC\u0010\u001d\u001a\u0004\u0018\u00010\u00152\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00132\b\u0010 \u001a\u0004\u0018\u00010!H\u0002¢\u0006\u0002\u0010\"J6\u0010#\u001a\u00020\n2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020$0\u001b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0013H\u0002J\u0010\u0010%\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0012\u0010%\u001a\u00020\n2\b\u0010&\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010'\u001a\u00020\nH\u0016J\b\u0010(\u001a\u00020\nH\u0016J\u0010\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u0010,\u001a\u00020-2\u0006\u0010*\u001a\u00020\u000eH\u0016J\u0010\u0010.\u001a\u00020-2\u0006\u0010*\u001a\u00020\u000eH\u0016J\u0010\u0010/\u001a\u00020-2\u0006\u0010*\u001a\u00020\u000eH\u0016J\u0010\u00100\u001a\u00020-2\u0006\u0010*\u001a\u00020\u000eH\u0016J\u0018\u00101\u001a\u00020\n2\u0006\u0010\u0010\u001a\u0002022\u0006\u0010\r\u001a\u00020\u000eH\u0002J(\u00103\u001a\u00020\n2\u0006\u00104\u001a\u0002052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H\u0016J \u0010:\u001a\u00020\n2\u0006\u00104\u001a\u0002052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u00106\u001a\u000207H\u0016J \u0010;\u001a\u00020\n2\u0006\u00104\u001a\u0002052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u00106\u001a\u000207H\u0016J(\u0010<\u001a\u00020\n2\u0006\u00104\u001a\u0002052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010=\u001a\u0002092\u0006\u00106\u001a\u000207H\u0002J0\u0010>\u001a\u00020\n2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u00042\u0006\u0010B\u001a\u00020\u00042\u0006\u0010C\u001a\u00020!2\u0006\u0010D\u001a\u00020EH\u0016J \u0010F\u001a\u00020\n2\u0006\u00104\u001a\u0002052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u00106\u001a\u000207H\u0016J \u0010G\u001a\u00020\n2\u0006\u00104\u001a\u0002052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u00106\u001a\u000207H\u0016J\u0012\u0010H\u001a\u0004\u0018\u00010I2\u0006\u0010A\u001a\u00020\u0004H\u0016J\u0012\u0010J\u001a\u0004\u0018\u00010\f2\b\u0010&\u001a\u0004\u0018\u00010\u0004J \u0010K\u001a\u00020\n2\u0006\u00104\u001a\u0002052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010D\u001a\u000207H\u0016J \u0010L\u001a\u00020\n2\u0006\u00104\u001a\u0002052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u00106\u001a\u000207H\u0016J\u0010\u0010M\u001a\u00020-2\u0006\u0010*\u001a\u00020\u000eH\u0016J\u0010\u0010N\u001a\u00020-2\u0006\u0010O\u001a\u00020PH\u0002J\u0010\u0010Q\u001a\u00020-2\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u0010R\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010S\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010T\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016J:\u0010U\u001a\u00020\n2\u0010\u0010V\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010W2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0013H\u0002J(\u0010X\u001a\u00020\n2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u00042\u0006\u0010B\u001a\u00020\u00042\u0006\u0010D\u001a\u00020YH\u0016J \u0010Z\u001a\u00020\n2\u0006\u00104\u001a\u0002052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u00106\u001a\u000207H\u0016J\u0010\u0010[\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\\\u001a\u00020\n2\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u0010]\u001a\u00020-2\u0006\u0010*\u001a\u00020\u000eH\u0016J0\u0010^\u001a\u00020\n2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u00042\u0006\u0010B\u001a\u00020\u00042\u0006\u0010_\u001a\u00020`2\u0006\u0010D\u001a\u00020aH\u0016J\u0010\u0010b\u001a\u00020\n2\u0006\u0010?\u001a\u00020@H\u0016J\"\u0010c\u001a\u00020\n2\u0006\u0010?\u001a\u00020@2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010dH\u0016J\"\u0010e\u001a\u00020\n2\u0006\u0010?\u001a\u00020@2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J(\u0010f\u001a\u00020\n2\u0006\u0010?\u001a\u00020@2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010_\u001a\u00020`2\u0006\u0010g\u001a\u00020hH\u0016J\u0010\u0010i\u001a\u00020-2\u0006\u0010*\u001a\u00020\u000eH\u0016J\u0010\u0010j\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010k\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006m"}, d2 = {"Lcom/wifi/gdt/ad/NestGdtProvider;", "Lcom/wifi/ad/core/provider/BaseAdProvider;", "()V", "TAG", "", MediationConstant.RIT_TYPE_BANNER, "Lcom/qq/e/ads/banner2/UnifiedBannerView;", "interAd", "Lcom/qq/e/ads/interstitial2/UnifiedInterstitialAD;", "addShowListener", "", "showListener", "Lcom/wifi/ad/core/listener/InnerRewardShowListener;", "nestAdData", "Lcom/wifi/ad/core/data/NestAdData;", "catchGdtInterstitialAds", "ad", "adCode", "ext", "", "catchGdtRewardAdSensitiveInfo", "Lcom/wifi/ad/core/entity/SensitiveInfo;", "Lcom/qq/e/ads/rewardvideo/RewardVideoAD;", "", "(Lcom/qq/e/ads/rewardvideo/RewardVideoAD;Ljava/lang/Long;Ljava/util/Map;)Lcom/wifi/ad/core/entity/SensitiveInfo;", "catchGdtSensitiveInfo", "ads", "", "Lcom/qq/e/ads/nativ/NativeUnifiedADData;", "catchGdtSplashInfo", "fSplashAd", "Lcom/qq/e/ads/splash/SplashAD;", "adLevel", "", "(Lcom/qq/e/ads/splash/SplashAD;Ljava/lang/String;Ljava/util/Map;Ljava/lang/Integer;)Lcom/wifi/ad/core/entity/SensitiveInfo;", "catchGdtTemplateAds", "Lcom/qq/e/ads/nativ/NativeExpressADView;", "destroyAd", "requestId", "destroyBannerAd", "destroyInterAd", "destroyNativeAd", "adObject", "", "drawAdIsBelongTheProvider", "", "drawNativeAdIsBelongTheProvider", "feedAdIsBelongTheProvider", "feedNativeAdIsBelongTheProvider", "getAdEcpmLevel", "Lcom/qq/e/comm/pi/LADI;", "getCorrectAd", "packer", "Lcom/wifi/ad/core/helper/ActivityPacker;", "listenerStrategy", "Lcom/wifi/ad/core/strategy/IStrategyListener;", "scene", "Lcom/wifi/ad/core/strategy/LoadScene;", "getDrawVideoAd", "getInterstitialAd", "getNativeAd", "loadScene", "getNativeAdList", "activity", "Landroid/app/Activity;", "adProviderType", "alias", "maxCount", bq.f.s, "Lcom/wifi/ad/core/listener/NativeListener;", "getNativeDrawVideoAd", "getNativeFeedAd", "getNativeView", "Lcom/wifi/ad/core/custom/flow/BaseNativeView;", "getShowListener", "getSplashAd", "getTemplateFeedAd", "interstitialAdIsBelongTheProvider", "isViewShow", "view", "Landroid/view/View;", "nativeAdIsBelongTheProvider", "onNestAdLoad", "onNestAdUnLoad", "pauseAd", "reportSensitiveInfo", "sensitiveInfoList", "", "requestInterAd", "Lcom/wifi/ad/core/listener/InterListener;", "requestRewardAd", "resumeAd", "resumeNativeAd", "rewardAdIsBelongTheProvider", "showBannerAd", "container", "Landroid/view/ViewGroup;", "Lcom/wifi/ad/core/listener/BannerListener;", "showInterAd", "showInterstitialAd", "Lcom/wifi/ad/core/listener/PopShowListener;", "showRewardAd", "showSplashAd", "splashShowListener", "Lcom/wifi/ad/core/listener/SplashShowListener;", "splashAdIsBelongTheProvider", "startAd", "stopAd", "Companion", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
public final class NestGdtProvider extends BaseAdProvider {
    public static final String DSP_NAME = "guangdiantong_out";
    public static final String SDK_FROM = "guangdiantong";
    private static NestGdtNativeView gdtNativeView;
    private final String TAG = "GdtProvider";
    private UnifiedBannerView banner;
    private UnifiedInterstitialAD interAd;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static HashMap<String, InnerRewardShowListener> showListenerMap = new HashMap<>();

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR&\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/wifi/gdt/ad/NestGdtProvider$Companion;", "", "()V", "DSP_NAME", "", "SDK_FROM", "gdtNativeView", "Lcom/wifi/gdt/ad/NestGdtNativeView;", "getGdtNativeView", "()Lcom/wifi/gdt/ad/NestGdtNativeView;", "setGdtNativeView", "(Lcom/wifi/gdt/ad/NestGdtNativeView;)V", "showListenerMap", "Ljava/util/HashMap;", "Lcom/wifi/ad/core/listener/InnerRewardShowListener;", "getShowListenerMap", "()Ljava/util/HashMap;", "setShowListenerMap", "(Ljava/util/HashMap;)V", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public final NestGdtNativeView getGdtNativeView() {
            return NestGdtProvider.gdtNativeView;
        }

        public final HashMap<String, InnerRewardShowListener> getShowListenerMap() {
            return NestGdtProvider.showListenerMap;
        }

        public final void setGdtNativeView(NestGdtNativeView nestGdtNativeView) {
            NestGdtProvider.gdtNativeView = nestGdtNativeView;
        }

        public final void setShowListenerMap(HashMap<String, InnerRewardShowListener> map) {
            NestGdtProvider.showListenerMap = map;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[LoadScene.values().length];
            $EnumSwitchMapping$0 = iArr;
            LoadScene loadScene = LoadScene.FEED;
            iArr[loadScene.ordinal()] = 1;
            int[] iArr2 = new int[LoadScene.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[LoadScene.DRAWAD.ordinal()] = 1;
            iArr2[loadScene.ordinal()] = 2;
            iArr2[LoadScene.REWARD.ordinal()] = 3;
            iArr2[LoadScene.INTERSTITIAL.ordinal()] = 4;
            iArr2[LoadScene.SPLASH.ordinal()] = 5;
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void catchGdtInterstitialAds(UnifiedInterstitialAD ad, String adCode, Map<String, String> ext) {
        SensitiveInfo sensitiveInfoCatchGdtInterstitialAd;
        if (WifiNestAd.INSTANCE.isCatchThirdInfo() && (sensitiveInfoCatchGdtInterstitialAd = GdtSensitiveCatcher.INSTANCE.catchGdtInterstitialAd(ad)) != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(sensitiveInfoCatchGdtInterstitialAd);
            reportSensitiveInfo(arrayList, String.valueOf(adCode), ext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SensitiveInfo catchGdtRewardAdSensitiveInfo(RewardVideoAD ad, Long adCode, Map<String, String> ext) {
        if (!WifiNestAd.INSTANCE.isCatchThirdInfo()) {
            return null;
        }
        SensitiveInfo sensitiveInfoCatchGdtExpressRewardAdSensitive = GdtSensitiveCatcher.INSTANCE.catchGdtExpressRewardAdSensitive(ad);
        if (sensitiveInfoCatchGdtExpressRewardAdSensitive != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(sensitiveInfoCatchGdtExpressRewardAdSensitive);
            reportSensitiveInfo(arrayList, String.valueOf(adCode), ext);
        }
        return sensitiveInfoCatchGdtExpressRewardAdSensitive;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void catchGdtSensitiveInfo(List<NativeUnifiedADData> ads, String adCode, Map<String, String> ext) {
        if (WifiNestAd.INSTANCE.isCatchThirdInfo()) {
            reportSensitiveInfo(GdtSensitiveCatcher.INSTANCE.catchGdtNativeTemplateAds(ads), adCode, ext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SensitiveInfo catchGdtSplashInfo(SplashAD fSplashAd, String adCode, Map<String, String> ext, Integer adLevel) {
        if (!WifiNestAd.INSTANCE.isCatchThirdInfo()) {
            return null;
        }
        SensitiveInfo sensitiveInfoCatchGdtSplashAd = GdtSensitiveCatcher.INSTANCE.catchGdtSplashAd(fSplashAd);
        if (sensitiveInfoCatchGdtSplashAd != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(sensitiveInfoCatchGdtSplashAd);
            reportSensitiveInfo(arrayList, String.valueOf(adCode), ext);
        }
        return sensitiveInfoCatchGdtSplashAd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void catchGdtTemplateAds(List<NativeExpressADView> ads, String adCode, Map<String, String> ext) {
        if (WifiNestAd.INSTANCE.isCatchThirdInfo()) {
            reportSensitiveInfo(GdtSensitiveCatcher.INSTANCE.catchGdtTemplateAds(ads), String.valueOf(adCode), ext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getAdEcpmLevel(LADI ad, NestAdData nestAdData) {
        float fFloatValue;
        if ((ad != null ? Integer.valueOf(ad.getECPM()) : null).intValue() <= 0) {
            if (nestAdData != null) {
                nestAdData.setAdRealLevelName(ad != null ? ad.getECPMLevel() : null);
                return;
            }
            return;
        }
        if ((nestAdData != null ? Float.valueOf(nestAdData.getEcpmRatio()) : null).floatValue() > 0) {
            fFloatValue = (nestAdData != null ? Float.valueOf(nestAdData.getEcpmRatio()) : null).floatValue();
        } else {
            fFloatValue = 1.0f;
        }
        if (nestAdData != null) {
            nestAdData.setAdRealLevelName(String.valueOf((int) ((ad != null ? Integer.valueOf(ad.getECPM()) : null).intValue() * fFloatValue)));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("bidding ecpm gdt ecpmRatio ");
        sb.append(fFloatValue);
        sb.append(" adRealLevelName ");
        sb.append(nestAdData != null ? nestAdData.getAdRealLevelName() : null);
        sb.append(" code ");
        sb.append(nestAdData != null ? nestAdData.getAdCode() : null);
        WifiLog.d(sb.toString());
    }

    private final void getNativeAd(final ActivityPacker packer, final NestAdData nestAdData, final LoadScene loadScene, final IStrategyListener listenerStrategy) {
        String nestType;
        WifiLog.d("NestGdtProvider getNativeAd adLevelName = " + nestAdData.getAdLevelName() + " adCode = " + nestAdData.getAdCode() + " adLevel = " + nestAdData.getAdLevel() + " adType = " + nestAdData.getAdType());
        if (listenerStrategy != null) {
            listenerStrategy.onStart(nestAdData);
        }
        EventParams.Builder renderStyle = new EventParams.Builder().setDspName(DSP_NAME).setNestSid(nestAdData.getNestSid()).setMediaId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.GDT))).setSrcId(String.valueOf(nestAdData.getAdCode())).setRenderStyle(nestAdData.getRenderStyle());
        AdParams adParams = nestAdData.getAdParams();
        if (adParams == null || (nestType = adParams.getNestType()) == null) {
            nestType = "";
        }
        final EventParams.Builder builder = renderStyle.setNestType(nestType).setInventoryId(nestAdData.getInventoryId()).setSdkFrom("guangdiantong");
        EventReporter eventReporter = EventReporter.INSTANCE;
        Intrinsics.checkExpressionValueIsNotNull(builder, "builder");
        eventReporter.reportReqDi(nestAdData, builder);
        new NativeUnifiedAD(packer.getAppContext(), nestAdData.getAdCode(), new NativeADUnifiedListener() { // from class: com.wifi.gdt.ad.NestGdtProvider$getNativeAd$adManager$1
            @Override // com.qq.e.ads.nativ.NativeADUnifiedListener
            public void onADLoaded(List<NativeUnifiedADData> ads) {
                if (ads == null || ads.isEmpty()) {
                    EventReporter eventReporter2 = EventReporter.INSTANCE;
                    NestAdData nestAdData2 = nestAdData;
                    EventParams.Builder builder2 = builder;
                    Intrinsics.checkExpressionValueIsNotNull(builder2, "builder");
                    eventReporter2.reportNoRespDi(nestAdData2, builder2, "30200", "");
                    IStrategyListener iStrategyListener = listenerStrategy;
                    if (iStrategyListener != null) {
                        iStrategyListener.onAdFailed(nestAdData, "list is empty", -1);
                        return;
                    }
                    return;
                }
                if (!ads.isEmpty()) {
                    int testPriceSwitchEcpm = this.this$0.getTestPriceSwitchEcpm(ads.get(0).getECPM(), nestAdData);
                    WifiLog.d("NestGdtProvider getNativeAd onADLoaded priceSwitch price " + testPriceSwitchEcpm + " code " + nestAdData.getAdCode());
                    NestGdtProvider nestGdtProvider = this.this$0;
                    NestAdData nestAdData3 = nestAdData;
                    EventParams.Builder builder3 = builder;
                    Intrinsics.checkExpressionValueIsNotNull(builder3, "builder");
                    if (nestGdtProvider.checkAdEcpmDone(testPriceSwitchEcpm, nestAdData3, builder3, listenerStrategy)) {
                        return;
                    }
                    NestGdtProvider nestGdtProvider2 = this.this$0;
                    NestAdData nestAdData4 = nestAdData;
                    EventParams.Builder builder4 = builder;
                    Intrinsics.checkExpressionValueIsNotNull(builder4, "builder");
                    if (nestGdtProvider2.checkAdPriceSwitch(testPriceSwitchEcpm, nestAdData4, builder4, listenerStrategy)) {
                        return;
                    }
                }
                NestGdtProvider nestGdtProvider3 = this.this$0;
                String adCode = nestAdData.getAdCode();
                AdParams adParams2 = nestAdData.getAdParams();
                nestGdtProvider3.catchGdtSensitiveInfo(ads, adCode, adParams2 != null ? adParams2.getExt() : null);
                NativeUnifiedADData nativeUnifiedADData = ads.get(0);
                builder.setAdTitle(nativeUnifiedADData.getTitle()).setAdImage(nativeUnifiedADData.getImgUrl()).setAdDesc(nativeUnifiedADData.getDesc()).setAdCost(nativeUnifiedADData.getECPM());
                ArrayList arrayList = new ArrayList();
                for (NativeUnifiedADData nativeUnifiedADData2 : ads) {
                    NestAdData nestAdData5 = nestAdData;
                    nestAdData5.setDspName(NestGdtProvider.DSP_NAME);
                    nestAdData5.setAppId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.GDT)));
                    nestAdData5.setSdkFrom("guangdiantong");
                    nestAdData5.setAdData(nativeUnifiedADData2);
                    if (nativeUnifiedADData2.getAppMiitInfo() != null) {
                        NativeUnifiedADAppMiitInfo appMiitInfo = nativeUnifiedADData2.getAppMiitInfo();
                        Intrinsics.checkExpressionValueIsNotNull(appMiitInfo, "ad.appMiitInfo");
                        nestAdData5.setAdAppDeveloperName(appMiitInfo.getAuthorName());
                        nestAdData5.setAdAppName(appMiitInfo.getAppName());
                        nestAdData5.setAdAppVersion(appMiitInfo.getVersionName());
                        nestAdData5.setAdAppPermissionsUrl(appMiitInfo.getPermissionsUrl());
                        nestAdData5.setAdAppPrivacyUrl(appMiitInfo.getPrivacyAgreement());
                        nestAdData5.setAdAppFunctionDescUrl(appMiitInfo.getDescriptionUrl());
                    }
                    nestAdData5.setSensitiveInfo(GdtSensitiveCatcher.INSTANCE.catchGdtNativeTemplateAd(nativeUnifiedADData2));
                    if (NestGdtProvider.WhenMappings.$EnumSwitchMapping$0[loadScene.ordinal()] == 1) {
                        Context appContext = packer.getAppContext();
                        Intrinsics.checkExpressionValueIsNotNull(appContext, "packer.appContext");
                        nestAdData5.setDataAdapter(new GdtNativeDataAdapter(appContext, nativeUnifiedADData2));
                        nestAdData5.setNativeAdImgHeight(nativeUnifiedADData2.getPictureHeight());
                        nestAdData5.setNativeAdImgWidth(nativeUnifiedADData2.getPictureWidth());
                    }
                    this.this$0.getAdEcpmLevel(nativeUnifiedADData2, nestAdData);
                    WifiLog.d("NestGdtProvider getNativeAd ecpmLevel = " + nativeUnifiedADData2.getECPMLevel());
                    arrayList.add(nestAdData);
                }
                EventReporter eventReporter3 = EventReporter.INSTANCE;
                NestAdData nestAdData6 = nestAdData;
                EventParams.Builder builder5 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder5, "builder");
                eventReporter3.reportRespDi(nestAdData6, builder5, ads.size());
                IStrategyListener iStrategyListener2 = listenerStrategy;
                if (iStrategyListener2 != null) {
                    iStrategyListener2.onAdLoaded(arrayList);
                }
                this.this$0.onNestAdLoad(nestAdData);
            }

            @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
            public void onNoAD(AdError error) {
                String errorMsg;
                EventReporter eventReporter2 = EventReporter.INSTANCE;
                NestAdData nestAdData2 = nestAdData;
                EventParams.Builder builder2 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder2, "builder");
                eventReporter2.reportNoRespDi(nestAdData2, builder2, String.valueOf(error != null ? Integer.valueOf(error.getErrorCode()) : null), error != null ? error.getErrorMsg() : null);
                StringBuilder sb = new StringBuilder();
                sb.append("NestGdtProvider getNativeAd onError code = ");
                sb.append(error != null ? Integer.valueOf(error.getErrorCode()) : null);
                sb.append(" message = ");
                sb.append(error != null ? error.getErrorMsg() : null);
                WifiLog.d(sb.toString());
                IStrategyListener iStrategyListener = listenerStrategy;
                if (iStrategyListener != null) {
                    NestAdData nestAdData3 = nestAdData;
                    if (error == null || (errorMsg = error.getErrorMsg()) == null) {
                        errorMsg = "unknown reason";
                    }
                    iStrategyListener.onAdFailed(nestAdData3, errorMsg, error != null ? error.getErrorCode() : -1);
                }
                this.this$0.onNestAdUnLoad(nestAdData);
            }
        }).loadData(1);
    }

    private final boolean isViewShow(View view) {
        return view != null && view.getVisibility() == 0 && view.isShown() && view.getWindowVisibility() == 0;
    }

    private final void reportSensitiveInfo(List<SensitiveInfo> sensitiveInfoList, String adCode, Map<String, String> ext) {
        List<SensitiveInfo> list = sensitiveInfoList;
        if (list == null || list.isEmpty()) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        for (SensitiveInfo sensitiveInfo : sensitiveInfoList) {
            if (sensitiveInfo != null) {
                sensitiveInfo.setAdCode(String.valueOf(adCode));
            }
            jSONArray.put(sensitiveInfo != null ? sensitiveInfo.toJson() : null);
        }
        EventParams params = new EventParams.Builder().build();
        Intrinsics.checkExpressionValueIsNotNull(params, "params");
        params.setThirdSdkInfo(jSONArray.toString());
        if (TextUtils.isEmpty(params.getThirdSdkInfo())) {
            return;
        }
        WifiNestAd.INSTANCE.getReporter().onEvent(WifiNestConst.EventKey.UNIFIEDAD_SDK_THIRDSDK_CONTENT, params, ext);
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void destroyAd(NestAdData nestAdData) {
        super.destroyAd(nestAdData);
        Object adData = nestAdData.getAdData();
        if (adData instanceof NativeUnifiedADData) {
            ((NativeUnifiedADData) adData).destroy();
        }
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void destroyBannerAd() {
        UnifiedBannerView unifiedBannerView = this.banner;
        if (unifiedBannerView != null) {
            unifiedBannerView.destroy();
        }
        this.banner = null;
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void destroyInterAd() {
        UnifiedInterstitialAD unifiedInterstitialAD = this.interAd;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.close();
        }
        UnifiedInterstitialAD unifiedInterstitialAD2 = this.interAd;
        if (unifiedInterstitialAD2 != null) {
            unifiedInterstitialAD2.destroy();
        }
        this.interAd = null;
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void destroyNativeAd(Object adObject) {
        if (adObject instanceof NativeUnifiedADData) {
            ((NativeUnifiedADData) adObject).destroy();
        }
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public boolean drawAdIsBelongTheProvider(NestAdData adObject) {
        return false;
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public boolean drawNativeAdIsBelongTheProvider(NestAdData adObject) {
        return adObject.getAdData() instanceof NativeUnifiedADData;
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public boolean feedAdIsBelongTheProvider(NestAdData adObject) {
        return adObject.getAdView() instanceof NativeExpressADView;
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public boolean feedNativeAdIsBelongTheProvider(NestAdData adObject) {
        return adObject.getAdData() instanceof NativeUnifiedADData;
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void getCorrectAd(ActivityPacker packer, NestAdData nestAdData, IStrategyListener listenerStrategy, LoadScene scene) {
        if (!NestGdtManager.INSTANCE.getInitDone()) {
            listenerStrategy.onAdFailed(nestAdData, "sdk not init", -1001);
            return;
        }
        if (!RequestSDKConfig.INSTANCE.checkAllowRequest(nestAdData.getAdScene(), "gdt")) {
            listenerStrategy.onAdFailed(nestAdData, "sdk RequestSDKConfig not allow", -1002);
            return;
        }
        int i = WhenMappings.$EnumSwitchMapping$1[scene.ordinal()];
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
            requestRewardAd(packer, nestAdData, listenerStrategy);
        } else if (i == 4) {
            getInterstitialAd(packer, nestAdData, listenerStrategy);
        } else {
            if (i != 5) {
                return;
            }
            getSplashAd(packer, nestAdData, listenerStrategy);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1, types: [T, com.qq.e.ads.interstitial2.UnifiedInterstitialAD, java.lang.Object] */
    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void getInterstitialAd(ActivityPacker packer, final NestAdData nestAdData, final IStrategyListener listenerStrategy) {
        String nestType;
        super.getInterstitialAd(packer, nestAdData, listenerStrategy);
        listenerStrategy.onStart(nestAdData);
        EventParams.Builder renderStyle = new EventParams.Builder().setDspName(DSP_NAME).setNestSid(nestAdData.getNestSid()).setMediaId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.GDT))).setSrcId(String.valueOf(nestAdData.getAdCode())).setRenderStyle(nestAdData.getRenderStyle());
        AdParams adParams = nestAdData.getAdParams();
        if (adParams == null || (nestType = adParams.getNestType()) == null) {
            nestType = "";
        }
        final EventParams.Builder builder = renderStyle.setNestType(nestType).setInventoryId(nestAdData.getInventoryId()).setSdkFrom("guangdiantong");
        EventReporter eventReporter = EventReporter.INSTANCE;
        Intrinsics.checkExpressionValueIsNotNull(builder, "builder");
        eventReporter.reportReqDi(nestAdData, builder);
        final ArrayList arrayList = new ArrayList();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        UnifiedInterstitialADListener unifiedInterstitialADListener = new UnifiedInterstitialADListener() { // from class: com.wifi.gdt.ad.NestGdtProvider$getInterstitialAd$adListener$1
            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADClicked() {
                WifiLog.d("NestGdtProvider onADClicked");
                PopShowListener popshowListener = nestAdData.getPopshowListener();
                if (popshowListener != null) {
                    popshowListener.onAdClicked(SDKAlias.GDT.getType(), nestAdData);
                }
                NestGdtNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_CLICK);
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADClosed() {
                WifiLog.d("NestGdtProvider onADClosed");
                PopShowListener popshowListener = nestAdData.getPopshowListener();
                if (popshowListener != null) {
                    popshowListener.onAdClose(SDKAlias.GDT.getType(), nestAdData);
                }
                NestGdtNativeView.INSTANCE.onEvent(nestAdData, "nest_sdk_cancle_click");
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADExposure() {
                WifiLog.d("NestGdtProvider onADExposure");
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADOpened() {
                WifiLog.d("NestGdtProvider onADOpened");
                PopShowListener popshowListener = nestAdData.getPopshowListener();
                if (popshowListener != null) {
                    popshowListener.onAdExpose(SDKAlias.GDT.getType(), nestAdData);
                }
                NestGdtNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_SHOW);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADReceive() {
                T t = objectRef.element;
                if (((UnifiedInterstitialAD) t) != null) {
                    UnifiedInterstitialAD unifiedInterstitialAD = (UnifiedInterstitialAD) t;
                    if (unifiedInterstitialAD == null) {
                        Intrinsics.throwNpe();
                    }
                    int testPriceSwitchEcpm = this.this$0.getTestPriceSwitchEcpm(unifiedInterstitialAD.getECPM(), nestAdData);
                    WifiLog.d("NestGdtProvider getInterstitialAd onADLoaded priceSwitch price " + testPriceSwitchEcpm + " code " + nestAdData.getAdCode());
                    NestGdtProvider nestGdtProvider = this.this$0;
                    NestAdData nestAdData2 = nestAdData;
                    EventParams.Builder builder2 = builder;
                    Intrinsics.checkExpressionValueIsNotNull(builder2, "builder");
                    if (nestGdtProvider.checkAdEcpmDone(testPriceSwitchEcpm, nestAdData2, builder2, listenerStrategy)) {
                        return;
                    }
                    NestGdtProvider nestGdtProvider2 = this.this$0;
                    NestAdData nestAdData3 = nestAdData;
                    EventParams.Builder builder3 = builder;
                    Intrinsics.checkExpressionValueIsNotNull(builder3, "builder");
                    if (nestGdtProvider2.checkAdPriceSwitch(testPriceSwitchEcpm, nestAdData3, builder3, listenerStrategy)) {
                        return;
                    }
                }
                NestGdtProvider nestGdtProvider3 = this.this$0;
                UnifiedInterstitialAD unifiedInterstitialAD2 = (UnifiedInterstitialAD) objectRef.element;
                String adCode = nestAdData.getAdCode();
                AdParams adParams2 = nestAdData.getAdParams();
                nestGdtProvider3.catchGdtInterstitialAds(unifiedInterstitialAD2, adCode, adParams2 != null ? adParams2.getExt() : null);
                nestAdData.setDspName(NestGdtProvider.DSP_NAME);
                nestAdData.setAppId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.GDT)));
                nestAdData.setSdkFrom("guangdiantong");
                nestAdData.setAdData((UnifiedInterstitialAD) objectRef.element);
                UnifiedInterstitialAD unifiedInterstitialAD3 = (UnifiedInterstitialAD) objectRef.element;
                if (unifiedInterstitialAD3 != null) {
                    this.this$0.getAdEcpmLevel(unifiedInterstitialAD3, nestAdData);
                }
                nestAdData.setSensitiveInfo(GdtSensitiveCatcher.INSTANCE.catchGdtInterstitialAd((UnifiedInterstitialAD) objectRef.element));
                arrayList.add(nestAdData);
                EventReporter eventReporter2 = EventReporter.INSTANCE;
                NestAdData nestAdData4 = nestAdData;
                EventParams.Builder builder4 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder4, "builder");
                eventReporter2.reportRespDi(nestAdData4, builder4, 1);
                IStrategyListener iStrategyListener = listenerStrategy;
                if (iStrategyListener != null) {
                    iStrategyListener.onAdLoaded(arrayList);
                }
                this.this$0.onNestAdLoad(nestAdData);
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onNoAD(AdError adError) {
                WifiLog.d("NestGdtProvider onNoAD");
                IStrategyListener iStrategyListener = listenerStrategy;
                if (iStrategyListener != null) {
                    NestAdData nestAdData2 = nestAdData;
                    String errorMsg = adError.getErrorMsg();
                    Intrinsics.checkExpressionValueIsNotNull(errorMsg, "adError.errorMsg");
                    iStrategyListener.onAdFailed(nestAdData2, errorMsg, adError.getErrorCode());
                }
                EventReporter eventReporter2 = EventReporter.INSTANCE;
                NestAdData nestAdData3 = nestAdData;
                EventParams.Builder builder2 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder2, "builder");
                eventReporter2.reportNoRespDi(nestAdData3, builder2, String.valueOf(adError.getErrorCode()), adError.getErrorMsg());
                this.this$0.onNestAdUnLoad(nestAdData);
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onRenderFail() {
                WifiLog.d("NestGdtProvider onRenderFail");
                NestGdtNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_SHOW_FAIL);
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onRenderSuccess() {
                WifiLog.d("NestGdtProvider onRenderSuccess");
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADLeftApplication() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onVideoCached() {
            }
        };
        Activity activityIfExist = packer.getActivityIfExist();
        if (activityIfExist == null) {
            unifiedInterstitialADListener.onNoAD(new AdError(99999, "activity has been recycled"));
            return;
        }
        ?? unifiedInterstitialAD = new UnifiedInterstitialAD(activityIfExist, nestAdData.getAdCode(), unifiedInterstitialADListener);
        objectRef.element = unifiedInterstitialAD;
        nestAdData.setAdData(unifiedInterstitialAD);
        unifiedInterstitialAD.loadAD();
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void getNativeAdList(Activity activity, final String adProviderType, String alias, int maxCount, final NativeListener listener) {
        callbackFlowStartRequest(adProviderType, listener);
        NativeUnifiedAD nativeUnifiedAD = new NativeUnifiedAD(activity, NestGdtManager.INSTANCE.getIdMapGDT().get(alias), new NativeADUnifiedListener() { // from class: com.wifi.gdt.ad.NestGdtProvider$getNativeAdList$nativeADUnifiedListener$1
            @Override // com.qq.e.ads.nativ.NativeADUnifiedListener
            public void onADLoaded(List<? extends NativeUnifiedADData> adList) {
                if (adList == null || adList.isEmpty()) {
                    this.this$0.callbackFlowFailed(adProviderType, listener, "请求成功，但是返回的list为空");
                } else {
                    this.this$0.callbackFlowLoaded(adProviderType, listener, adList);
                }
            }

            @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
            public void onNoAD(AdError adError) {
                NestGdtProvider nestGdtProvider = this.this$0;
                String str = adProviderType;
                NativeListener nativeListener = listener;
                StringBuilder sb = new StringBuilder();
                sb.append("错误码: ");
                sb.append(adError != null ? Integer.valueOf(adError.getErrorCode()) : null);
                sb.append(", 错误信息：");
                sb.append(adError != null ? adError.getErrorMsg() : null);
                nestGdtProvider.callbackFlowFailed(str, nativeListener, sb.toString());
            }
        });
        nativeUnifiedAD.setMaxVideoDuration(60);
        nativeUnifiedAD.setMinVideoDuration(5);
        nativeUnifiedAD.loadData(maxCount);
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void getNativeDrawVideoAd(ActivityPacker packer, NestAdData nestAdData, IStrategyListener listenerStrategy) {
        WifiLog.d("NestGdtProvider getNativeDrawVideoAd adLevelName = " + nestAdData.getAdLevelName() + " adCode = " + nestAdData.getAdCode() + " adLevel = " + nestAdData.getAdLevel() + " adType = " + nestAdData.getAdType());
        getNativeAd(packer, nestAdData, LoadScene.DRAWAD, listenerStrategy);
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void getNativeFeedAd(ActivityPacker packer, NestAdData nestAdData, IStrategyListener listenerStrategy) {
        getNativeAd(packer, nestAdData, LoadScene.FEED, listenerStrategy);
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider
    public BaseNativeView getNativeView(String adProviderType) {
        WifiLog.d("getDrawVideoAdView adProviderType = " + adProviderType);
        if (Intrinsics.areEqual(SDKAlias.GDT.getType(), adProviderType)) {
            return new NestGdtNativeView();
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

    /* JADX WARN: Type inference failed for: r0v10, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v16, types: [T, com.qq.e.ads.splash.SplashAD] */
    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void getSplashAd(ActivityPacker packer, final NestAdData nestAdData, final IStrategyListener listener) {
        String nestType;
        WifiLog.d("splashAd gdt getSplashAd");
        EventParams.Builder nestSid = new EventParams.Builder().setDspName(DSP_NAME).setNestSid(nestAdData.getNestSid());
        Map<SDKAlias, String> appIds = WifiNestAd.INSTANCE.getAppIds();
        SDKAlias sDKAlias = SDKAlias.GDT;
        EventParams.Builder inventoryId = nestSid.setMediaId(String.valueOf(appIds.get(sDKAlias))).setSrcId(String.valueOf(nestAdData.getAdCode())).setRenderStyle(nestAdData.getRenderStyle()).setInventoryId(nestAdData.getInventoryId());
        AdParams adParams = nestAdData.getAdParams();
        if (adParams == null || (nestType = adParams.getNestType()) == null) {
            nestType = "";
        }
        final EventParams.Builder builder = inventoryId.setNestType(nestType).setSdkFrom("guangdiantong");
        EventReporter eventReporter = EventReporter.INSTANCE;
        Intrinsics.checkExpressionValueIsNotNull(builder, "builder");
        eventReporter.reportReqDi(nestAdData, builder);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = sDKAlias.getType();
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        objectRef2.element = null;
        ?? splashAD = new SplashAD(packer.getAppContext(), nestAdData.getAdCode(), new SplashADListener() { // from class: com.wifi.gdt.ad.NestGdtProvider$getSplashAd$splashAd$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADClicked() {
                NestGdtNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_CLICK);
                SplashShowListener splashShowListener = nestAdData.getSplashShowListener();
                if (splashShowListener != null) {
                    splashShowListener.onAdClicked((String) objectRef.element, nestAdData);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADDismissed() {
                WifiLog.d("splashAd gdt onAdSkip");
                SplashShowListener splashShowListener = nestAdData.getSplashShowListener();
                if (splashShowListener != null) {
                    splashShowListener.onAdSkip((String) objectRef.element, nestAdData);
                }
                NestGdtNativeView.INSTANCE.onEvent(nestAdData, "nest_sdk_cancle_click");
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADExposure() {
                WifiLog.d("splashAd gdt onADExposure");
                NestGdtNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_SHOW);
                SplashShowListener splashShowListener = nestAdData.getSplashShowListener();
                if (splashShowListener != null) {
                    splashShowListener.onAdExpose((String) objectRef.element, nestAdData);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADLoaded(long expireTimestamp) {
                T t = objectRef2.element;
                if (((SplashAD) t) != null) {
                    SplashAD splashAD2 = (SplashAD) t;
                    if (splashAD2 == null) {
                        Intrinsics.throwNpe();
                    }
                    int testPriceSwitchEcpm = this.this$0.getTestPriceSwitchEcpm(splashAD2.getECPM(), nestAdData);
                    WifiLog.d("NestGdtProvider splashAd onADLoaded priceSwitch price " + testPriceSwitchEcpm + " code " + nestAdData.getAdCode());
                    NestGdtProvider nestGdtProvider = this.this$0;
                    NestAdData nestAdData2 = nestAdData;
                    EventParams.Builder builder2 = builder;
                    Intrinsics.checkExpressionValueIsNotNull(builder2, "builder");
                    if (nestGdtProvider.checkAdEcpmDone(testPriceSwitchEcpm, nestAdData2, builder2, listener)) {
                        return;
                    }
                    NestGdtProvider nestGdtProvider2 = this.this$0;
                    NestAdData nestAdData3 = nestAdData;
                    EventParams.Builder builder3 = builder;
                    Intrinsics.checkExpressionValueIsNotNull(builder3, "builder");
                    if (nestGdtProvider2.checkAdPriceSwitch(testPriceSwitchEcpm, nestAdData3, builder3, listener)) {
                        return;
                    }
                }
                NestGdtProvider nestGdtProvider3 = this.this$0;
                SplashAD splashAD3 = (SplashAD) objectRef2.element;
                String adCode = nestAdData.getAdCode();
                AdParams adParams2 = nestAdData.getAdParams();
                SensitiveInfo sensitiveInfoCatchGdtSplashInfo = nestGdtProvider3.catchGdtSplashInfo(splashAD3, adCode, adParams2 != null ? adParams2.getExt() : null, nestAdData.getAdLevel());
                SplashAD splashAD4 = (SplashAD) objectRef2.element;
                if (splashAD4 != null) {
                    NestAdData nestAdData4 = nestAdData;
                    nestAdData4.setDspName(NestGdtProvider.DSP_NAME);
                    nestAdData4.setAppId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.GDT)));
                    nestAdData4.setSdkFrom("guangdiantong");
                    nestAdData4.setAdData(splashAD4);
                    nestAdData4.setSensitiveInfo(sensitiveInfoCatchGdtSplashInfo);
                    this.this$0.getAdEcpmLevel(splashAD4, nestAdData);
                }
                String adRealLevelName = nestAdData.getAdRealLevelName();
                if (adRealLevelName == null || adRealLevelName.length() == 0) {
                    NestAdData nestAdData5 = nestAdData;
                    nestAdData5.setAdRealLevelName(PSSDCardGdtDemo.getSdCardDemo(nestAdData5.getAdCode()));
                }
                WifiLog.d("splashAd gdt onADLoaded nestAdData.adRealLevelName " + nestAdData.getAdRealLevelName());
                ArrayList arrayList = new ArrayList();
                arrayList.add(nestAdData);
                EventReporter eventReporter2 = EventReporter.INSTANCE;
                NestAdData nestAdData6 = nestAdData;
                EventParams.Builder builder4 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder4, "builder");
                eventReporter2.reportRespDi(nestAdData6, builder4, 1);
                IStrategyListener iStrategyListener = listener;
                if (iStrategyListener != null) {
                    iStrategyListener.onAdLoaded(arrayList);
                }
                this.this$0.onNestAdLoad(nestAdData);
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADPresent() {
                WifiLog.d("splashAd gdt onADPresent");
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onNoAD(AdError adError) {
                Integer numValueOf = adError != null ? Integer.valueOf(adError.getErrorCode()) : null;
                if (numValueOf == null) {
                    Intrinsics.throwNpe();
                }
                int iIntValue = numValueOf.intValue();
                String errorMsg = adError != null ? adError.getErrorMsg() : null;
                Intrinsics.checkExpressionValueIsNotNull(errorMsg, "adError?.errorMsg");
                IStrategyListener iStrategyListener = listener;
                if (iStrategyListener != null) {
                    iStrategyListener.onAdFailed(nestAdData, errorMsg, iIntValue);
                }
                WifiLog.d("NestGdtProvider splashAd onNoAD errorCode " + iIntValue);
                if (iIntValue != 4004 && iIntValue != 4005) {
                    EventReporter eventReporter2 = EventReporter.INSTANCE;
                    NestAdData nestAdData2 = nestAdData;
                    EventParams.Builder builder2 = builder;
                    Intrinsics.checkExpressionValueIsNotNull(builder2, "builder");
                    eventReporter2.reportNoRespDi(nestAdData2, builder2, String.valueOf(iIntValue), errorMsg);
                }
                this.this$0.onNestAdUnLoad(nestAdData);
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADTick(long millisUntilFinished) {
            }
        }, 0);
        objectRef2.element = splashAD;
        splashAD.fetchAdOnly();
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void getTemplateFeedAd(final ActivityPacker packer, final NestAdData nestAdData, final IStrategyListener listenerStrategy) {
        String nestType;
        AdSize adSize;
        WifiLog.d("NestGdtProvider getTemplateFeedAd adLevelName = " + nestAdData.getAdLevelName() + " adCode = " + nestAdData.getAdCode() + " adLevel = " + nestAdData.getAdLevel() + " adType = " + nestAdData.getAdType());
        listenerStrategy.onStart(nestAdData);
        EventParams.Builder renderStyle = new EventParams.Builder().setDspName(DSP_NAME).setNestSid(nestAdData.getNestSid()).setMediaId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.GDT))).setSrcId(String.valueOf(nestAdData.getAdCode())).setRenderStyle(nestAdData.getRenderStyle());
        AdParams adParams = nestAdData.getAdParams();
        if (adParams == null || (nestType = adParams.getNestType()) == null) {
            nestType = "";
        }
        final EventParams.Builder builder = renderStyle.setNestType(nestType).setInventoryId(nestAdData.getInventoryId()).setSdkFrom("guangdiantong");
        EventReporter eventReporter = EventReporter.INSTANCE;
        Intrinsics.checkExpressionValueIsNotNull(builder, "builder");
        eventReporter.reportReqDi(nestAdData, builder);
        final String adCode = nestAdData.getAdCode();
        ADSize aDSize = new ADSize(-1, -2);
        AdParams adParams2 = nestAdData.getAdParams();
        if (adParams2 != null && (adSize = adParams2.getAdSize()) != null) {
            int gdtHeight = adSize.getGdtHeight();
            aDSize = new ADSize(adSize.getGdtWidth(), gdtHeight != 0 ? gdtHeight : -2);
        }
        NativeExpressAD.NativeExpressADListener nativeExpressADListener = new NativeExpressAD.NativeExpressADListener() { // from class: com.wifi.gdt.ad.NestGdtProvider$getTemplateFeedAd$adListener$1
            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onADClicked(NativeExpressADView p0) {
                NestGdtNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_CLICK);
                listenerStrategy.onAdClicked(nestAdData, SDKAlias.GDT.getType());
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onADClosed(NativeExpressADView p0) {
                listenerStrategy.onDislikeClicked(nestAdData, "");
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onADExposure(NativeExpressADView p0) {
                NestGdtNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_SHOW);
                listenerStrategy.onAdExpose(nestAdData, SDKAlias.GDT.getType());
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onADLoaded(List<NativeExpressADView> ads) {
                if (ads == null || ads.isEmpty()) {
                    EventReporter eventReporter2 = EventReporter.INSTANCE;
                    NestAdData nestAdData2 = nestAdData;
                    EventParams.Builder builder2 = builder;
                    Intrinsics.checkExpressionValueIsNotNull(builder2, "builder");
                    eventReporter2.reportNoRespDi(nestAdData2, builder2, "30200", "");
                    IStrategyListener iStrategyListener = listenerStrategy;
                    if (iStrategyListener != null) {
                        iStrategyListener.onAdFailed(nestAdData, "list is empty", -1);
                        return;
                    }
                    return;
                }
                if (!ads.isEmpty()) {
                    int testPriceSwitchEcpm = this.this$0.getTestPriceSwitchEcpm(ads.get(0).getECPM(), nestAdData);
                    WifiLog.d("NestGdtProvider getTemplateFeedAd onADLoaded priceSwitch price " + testPriceSwitchEcpm + " code " + nestAdData.getAdCode());
                    NestGdtProvider nestGdtProvider = this.this$0;
                    NestAdData nestAdData3 = nestAdData;
                    EventParams.Builder builder3 = builder;
                    Intrinsics.checkExpressionValueIsNotNull(builder3, "builder");
                    if (nestGdtProvider.checkAdEcpmDone(testPriceSwitchEcpm, nestAdData3, builder3, listenerStrategy)) {
                        return;
                    }
                    NestGdtProvider nestGdtProvider2 = this.this$0;
                    NestAdData nestAdData4 = nestAdData;
                    EventParams.Builder builder4 = builder;
                    Intrinsics.checkExpressionValueIsNotNull(builder4, "builder");
                    if (nestGdtProvider2.checkAdPriceSwitch(testPriceSwitchEcpm, nestAdData4, builder4, listenerStrategy)) {
                        return;
                    }
                }
                NestGdtProvider nestGdtProvider3 = this.this$0;
                String str = adCode;
                AdParams adParams3 = nestAdData.getAdParams();
                nestGdtProvider3.catchGdtTemplateAds(ads, str, adParams3 != null ? adParams3.getExt() : null);
                NativeExpressADView nativeExpressADView = ads.get(0);
                EventParams.Builder builder5 = builder;
                AdData boundData = nativeExpressADView.getBoundData();
                Intrinsics.checkExpressionValueIsNotNull(boundData, "ad.boundData");
                EventParams.Builder adTitle = builder5.setAdTitle(boundData.getTitle());
                AdData boundData2 = nativeExpressADView.getBoundData();
                Intrinsics.checkExpressionValueIsNotNull(boundData2, "ad.boundData");
                adTitle.setAdDesc(boundData2.getDesc());
                ArrayList arrayList = new ArrayList();
                for (NativeExpressADView nativeExpressADView2 : ads) {
                    NestAdData nestAdData5 = nestAdData;
                    nestAdData5.setDspName(NestGdtProvider.DSP_NAME);
                    nestAdData5.setAppId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.GDT)));
                    nestAdData5.setSdkFrom("guangdiantong");
                    nestAdData5.setAdData(nativeExpressADView2);
                    nestAdData5.setSensitiveInfo(GdtSensitiveCatcher.INSTANCE.catchGdtTemplateAdSensitive(nativeExpressADView2));
                    Context appContext = packer.getAppContext();
                    Intrinsics.checkExpressionValueIsNotNull(appContext, "packer.appContext");
                    nestAdData5.setDataAdapter(new GdtExpressAdDataAdapter(appContext, nativeExpressADView2));
                    this.this$0.getAdEcpmLevel(nativeExpressADView2, nestAdData);
                    StringBuilder sb = new StringBuilder();
                    sb.append("NestGdtProvider getTemplateFeedAd ecpmLevel = ");
                    AdData boundData3 = nativeExpressADView2.getBoundData();
                    Intrinsics.checkExpressionValueIsNotNull(boundData3, "ad.boundData");
                    sb.append(boundData3.getECPMLevel());
                    WifiLog.d(sb.toString());
                    arrayList.add(nestAdData);
                }
                EventReporter eventReporter3 = EventReporter.INSTANCE;
                NestAdData nestAdData6 = nestAdData;
                EventParams.Builder builder6 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder6, "builder");
                eventReporter3.reportRespDi(nestAdData6, builder6, ads.size());
                IStrategyListener iStrategyListener2 = listenerStrategy;
                if (iStrategyListener2 != null) {
                    iStrategyListener2.onAdLoaded(arrayList);
                }
                this.this$0.onNestAdLoadReport(nestAdData);
            }

            @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
            public void onNoAD(AdError error) {
                String errorMsg;
                EventReporter eventReporter2 = EventReporter.INSTANCE;
                NestAdData nestAdData2 = nestAdData;
                EventParams.Builder builder2 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder2, "builder");
                eventReporter2.reportNoRespDi(nestAdData2, builder2, String.valueOf(error != null ? Integer.valueOf(error.getErrorCode()) : null), error != null ? error.getErrorMsg() : null);
                StringBuilder sb = new StringBuilder();
                sb.append("NestGdtProvider getNativeAd onError code = ");
                sb.append(error != null ? Integer.valueOf(error.getErrorCode()) : null);
                sb.append(" message = ");
                sb.append(error != null ? error.getErrorMsg() : null);
                WifiLog.d(sb.toString());
                IStrategyListener iStrategyListener = listenerStrategy;
                if (iStrategyListener != null) {
                    NestAdData nestAdData3 = nestAdData;
                    if (error == null || (errorMsg = error.getErrorMsg()) == null) {
                        errorMsg = "unknown reason";
                    }
                    iStrategyListener.onAdFailed(nestAdData3, errorMsg, error != null ? error.getErrorCode() : -1);
                }
                this.this$0.onNestAdUnLoadReport(nestAdData);
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onRenderFail(NativeExpressADView p0) {
                NestGdtNativeView.Companion companion = NestGdtNativeView.INSTANCE;
                companion.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_TOSHOW_FAIL);
                companion.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_SHOW_FAIL);
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onADLeftApplication(NativeExpressADView p0) {
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onRenderSuccess(NativeExpressADView p0) {
            }
        };
        Activity activityIfExist = packer.getActivityIfExist();
        if (activityIfExist == null) {
            nativeExpressADListener.onNoAD(new AdError(99999, "activity has been recycled"));
            return;
        }
        NativeExpressAD nativeExpressAD = new NativeExpressAD(activityIfExist, aDSize, adCode, nativeExpressADListener);
        nativeExpressAD.setVideoOption(new VideoOption.Builder().setAutoPlayPolicy(1).setAutoPlayMuted(true).build());
        nativeExpressAD.loadAD(1);
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public boolean interstitialAdIsBelongTheProvider(NestAdData adObject) {
        return adObject.getAdData() instanceof UnifiedInterstitialAD;
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public boolean nativeAdIsBelongTheProvider(Object adObject) {
        return adObject instanceof NativeUnifiedADData;
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void onNestAdLoad(NestAdData nestAdData) {
        super.onNestAdLoad(nestAdData);
        onNestAdLoadReport(nestAdData);
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void onNestAdUnLoad(NestAdData nestAdData) {
        super.onNestAdUnLoad(nestAdData);
        onNestAdUnLoadReport(nestAdData);
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void pauseAd(NestAdData nestAdData) {
        Object adData = nestAdData.getAdData();
        if (adData instanceof NativeUnifiedADData) {
            ((NativeUnifiedADData) adData).pauseVideo();
        }
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void requestInterAd(Activity activity, final String adProviderType, String alias, final InterListener listener) {
        callbackInterStartRequest(adProviderType, listener);
        destroyInterAd();
        UnifiedInterstitialAD unifiedInterstitialAD = new UnifiedInterstitialAD(activity, NestGdtManager.INSTANCE.getIdMapGDT().get(alias), new UnifiedInterstitialADListener() { // from class: com.wifi.gdt.ad.NestGdtProvider.requestInterAd.1
            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADClicked() {
                NestGdtProvider.this.callbackInterClicked(adProviderType, listener);
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADClosed() {
                NestGdtProvider.this.callbackInterClosed(adProviderType, listener);
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADExposure() {
                NestGdtProvider.this.callbackInterExpose(adProviderType, listener);
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADLeftApplication() {
                LogExtKt.logi("onADLeftApplication", NestGdtProvider.this.TAG);
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADOpened() {
                LogExtKt.logi("onADOpened", NestGdtProvider.this.TAG);
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADReceive() {
                NestGdtProvider.this.callbackInterLoaded(adProviderType, listener);
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onNoAD(AdError adError) {
                NestGdtProvider nestGdtProvider = NestGdtProvider.this;
                String str = adProviderType;
                InterListener interListener = listener;
                StringBuilder sb = new StringBuilder();
                sb.append("错误码: ");
                sb.append(adError != null ? Integer.valueOf(adError.getErrorCode()) : null);
                sb.append(", 错误信息：");
                sb.append(adError != null ? adError.getErrorMsg() : null);
                nestGdtProvider.callbackInterFailed(str, interListener, sb.toString());
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onRenderFail() {
                LogExtKt.logi("onRenderFail", NestGdtProvider.this.TAG);
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onRenderSuccess() {
                LogExtKt.logi("onRenderSuccess", NestGdtProvider.this.TAG);
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onVideoCached() {
                LogExtKt.logi("onVideoCached", NestGdtProvider.this.TAG);
            }
        });
        this.interAd = unifiedInterstitialAD;
        unifiedInterstitialAD.loadAD();
    }

    /* JADX WARN: Type inference failed for: r1v24, types: [T, com.qq.e.ads.rewardvideo.RewardVideoAD] */
    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void requestRewardAd(ActivityPacker packer, final NestAdData nestAdData, final IStrategyListener listenerStrategy) {
        String nestType;
        super.requestRewardAd(packer, nestAdData, listenerStrategy);
        WifiLog.d("NestGdtProvider requestRewardAd adLevelName = " + nestAdData.getAdLevelName() + " adCode = " + nestAdData.getAdCode() + " adLevel = " + nestAdData.getAdLevel() + " adType = " + nestAdData.getAdType());
        listenerStrategy.onStart(nestAdData);
        EventParams.Builder renderStyle = new EventParams.Builder().setDspName(DSP_NAME).setNestSid(nestAdData.getNestSid()).setMediaId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.GDT))).setSrcId(String.valueOf(nestAdData.getAdCode())).setRenderStyle(nestAdData.getRenderStyle());
        AdParams adParams = nestAdData.getAdParams();
        if (adParams == null || (nestType = adParams.getNestType()) == null) {
            nestType = "";
        }
        final EventParams.Builder builder = renderStyle.setNestType(nestType).setInventoryId(nestAdData.getInventoryId()).setSdkFrom("guangdiantong");
        EventReporter eventReporter = EventReporter.INSTANCE;
        Intrinsics.checkExpressionValueIsNotNull(builder, "builder");
        eventReporter.reportReqDi(nestAdData, builder);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        ?? rewardVideoAD = new RewardVideoAD(packer.getAppContext(), nestAdData.getAdCode(), new RewardVideoADListener() { // from class: com.wifi.gdt.ad.NestGdtProvider.requestRewardAd.1
            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onADClick() {
                WifiLog.d("NestGdtProvider requestRewardAd 激励视频广告click");
                NestGdtNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_CLICK);
                IStrategyListener iStrategyListener = listenerStrategy;
                NestAdData nestAdData2 = nestAdData;
                SDKAlias sDKAlias = SDKAlias.GDT;
                iStrategyListener.onAdClicked(nestAdData2, sDKAlias.getType());
                InnerRewardShowListener rewardShowListener = nestAdData.getRewardShowListener();
                if (rewardShowListener != null) {
                    rewardShowListener.onAdClicked(sDKAlias.getType(), nestAdData);
                }
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onADClose() {
                listenerStrategy.onDislikeClicked(nestAdData, "");
                IStrategyListener iStrategyListener = listenerStrategy;
                NestAdData nestAdData2 = nestAdData;
                SDKAlias sDKAlias = SDKAlias.GDT;
                iStrategyListener.onAdClose(nestAdData2, sDKAlias.getType());
                InnerRewardShowListener rewardShowListener = nestAdData.getRewardShowListener();
                if (rewardShowListener != null) {
                    rewardShowListener.onAdClose(sDKAlias.getType(), nestAdData);
                }
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onADExpose() {
                WifiLog.d("NestGdtProvider requestRewardAd onExpose");
                IStrategyListener iStrategyListener = listenerStrategy;
                NestAdData nestAdData2 = nestAdData;
                SDKAlias sDKAlias = SDKAlias.GDT;
                iStrategyListener.onAdExpose(nestAdData2, sDKAlias.getType());
                InnerRewardShowListener rewardShowListener = nestAdData.getRewardShowListener();
                if (rewardShowListener != null) {
                    rewardShowListener.onAdExpose(sDKAlias.getType(), nestAdData);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onADLoad() {
                T t = objectRef.element;
                if (t == 0) {
                    Intrinsics.throwUninitializedPropertyAccessException("rewardVideoAD");
                }
                if (((RewardVideoAD) t) != null) {
                    T t2 = objectRef.element;
                    if (t2 == 0) {
                        Intrinsics.throwUninitializedPropertyAccessException("rewardVideoAD");
                    }
                    RewardVideoAD rewardVideoAD2 = (RewardVideoAD) t2;
                    if (rewardVideoAD2 == null) {
                        Intrinsics.throwNpe();
                    }
                    int testPriceSwitchEcpm = NestGdtProvider.this.getTestPriceSwitchEcpm(rewardVideoAD2.getECPM(), nestAdData);
                    WifiLog.d("NestGdtProvider requestRewardAd onADLoaded priceSwitch price " + testPriceSwitchEcpm + " code " + nestAdData.getAdCode());
                    NestGdtProvider nestGdtProvider = NestGdtProvider.this;
                    NestAdData nestAdData2 = nestAdData;
                    EventParams.Builder builder2 = builder;
                    Intrinsics.checkExpressionValueIsNotNull(builder2, "builder");
                    if (nestGdtProvider.checkAdEcpmDone(testPriceSwitchEcpm, nestAdData2, builder2, listenerStrategy)) {
                        return;
                    }
                    NestGdtProvider nestGdtProvider2 = NestGdtProvider.this;
                    NestAdData nestAdData3 = nestAdData;
                    EventParams.Builder builder3 = builder;
                    Intrinsics.checkExpressionValueIsNotNull(builder3, "builder");
                    if (nestGdtProvider2.checkAdPriceSwitch(testPriceSwitchEcpm, nestAdData3, builder3, listenerStrategy)) {
                        return;
                    }
                }
                NestGdtProvider nestGdtProvider3 = NestGdtProvider.this;
                T t3 = objectRef.element;
                if (t3 == 0) {
                    Intrinsics.throwUninitializedPropertyAccessException("rewardVideoAD");
                }
                RewardVideoAD rewardVideoAD3 = (RewardVideoAD) t3;
                String adCode = nestAdData.getAdCode();
                Long lValueOf = adCode != null ? Long.valueOf(Long.parseLong(adCode)) : null;
                AdParams adParams2 = nestAdData.getAdParams();
                SensitiveInfo sensitiveInfoCatchGdtRewardAdSensitiveInfo = nestGdtProvider3.catchGdtRewardAdSensitiveInfo(rewardVideoAD3, lValueOf, adParams2 != null ? adParams2.getExt() : null);
                ArrayList arrayList = new ArrayList();
                arrayList.add(nestAdData);
                NestAdData nestAdData4 = nestAdData;
                nestAdData4.setDspName(NestGdtProvider.DSP_NAME);
                nestAdData4.setAppId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.GDT)));
                nestAdData4.setSdkFrom("guangdiantong");
                Object obj = objectRef.element;
                if (obj == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("rewardVideoAD");
                }
                nestAdData4.setAdData((RewardVideoAD) obj);
                T t4 = objectRef.element;
                if (t4 == 0) {
                    Intrinsics.throwUninitializedPropertyAccessException("rewardVideoAD");
                }
                if (((RewardVideoAD) t4).getECPM() > 0) {
                    T t5 = objectRef.element;
                    if (t5 == 0) {
                        Intrinsics.throwUninitializedPropertyAccessException("rewardVideoAD");
                    }
                    nestAdData4.setAdRealLevelName(String.valueOf(((RewardVideoAD) t5).getECPM()));
                } else {
                    T t6 = objectRef.element;
                    if (t6 == 0) {
                        Intrinsics.throwUninitializedPropertyAccessException("rewardVideoAD");
                    }
                    nestAdData4.setAdRealLevelName(((RewardVideoAD) t6).getECPMLevel());
                }
                nestAdData4.setSensitiveInfo(sensitiveInfoCatchGdtRewardAdSensitiveInfo);
                EventReporter eventReporter2 = EventReporter.INSTANCE;
                NestAdData nestAdData5 = nestAdData;
                EventParams.Builder builder4 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder4, "builder");
                eventReporter2.reportRespDi(nestAdData5, builder4, 1);
                listenerStrategy.onAdLoaded(arrayList);
                NestGdtProvider.this.onNestAdLoad(nestAdData);
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onADShow() {
                WifiLog.d("NestGdtProvider requestRewardAd onShow");
                NestGdtNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_SHOW);
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onError(AdError error) {
                String errorMsg;
                EventReporter eventReporter2 = EventReporter.INSTANCE;
                NestAdData nestAdData2 = nestAdData;
                EventParams.Builder builder2 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder2, "builder");
                eventReporter2.reportNoRespDi(nestAdData2, builder2, String.valueOf(error != null ? Integer.valueOf(error.getErrorCode()) : null), error != null ? error.getErrorMsg() : null);
                StringBuilder sb = new StringBuilder();
                sb.append("NestGdtProvider requestRewardAd onError code = ");
                sb.append(error != null ? Integer.valueOf(error.getErrorCode()) : null);
                sb.append(" message = ");
                sb.append(error != null ? error.getErrorMsg() : null);
                WifiLog.d(sb.toString());
                IStrategyListener iStrategyListener = listenerStrategy;
                if (iStrategyListener != null) {
                    NestAdData nestAdData3 = nestAdData;
                    if (error == null || (errorMsg = error.getErrorMsg()) == null) {
                        errorMsg = "unknown reason";
                    }
                    iStrategyListener.onAdFailed(nestAdData3, errorMsg, error != null ? error.getErrorCode() : -1);
                }
                NestGdtProvider.this.onNestAdUnLoad(nestAdData);
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onReward(Map<String, Object> p0) {
                WifiLog.d("NestGdtProvider requestRewardAd 激励视频广告获取激励");
                IStrategyListener iStrategyListener = listenerStrategy;
                if (iStrategyListener != null) {
                    iStrategyListener.onAdRewardVerify(nestAdData, SDKAlias.GDT.getType());
                }
                InnerRewardShowListener rewardShowListener = nestAdData.getRewardShowListener();
                if (rewardShowListener != null) {
                    rewardShowListener.onAdRewardVerify(SDKAlias.GDT.getType(), nestAdData);
                }
                NestGdtNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_REWARDARRIVED);
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onVideoCached() {
                WifiLog.d("NestGdtProvider requestRewardAd onVideoCached");
                listenerStrategy.onAdVideoCached(nestAdData);
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onVideoComplete() {
                WifiLog.d("NestGdtProvider requestRewardAd 激励视频广告播放完成");
                listenerStrategy.onAdVideoComplete(nestAdData);
                InnerRewardShowListener rewardShowListener = nestAdData.getRewardShowListener();
                if (rewardShowListener != null) {
                    rewardShowListener.onVideoComplete(SDKAlias.GDT.getType(), nestAdData);
                }
                NestGdtNativeView.Companion companion = NestGdtNativeView.INSTANCE;
                companion.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_VIDEOE);
                companion.onEvent(nestAdData, WifiNestConst.EventKey.NEST_SDK_ENDPLAY_SHOW);
            }
        }, false);
        objectRef.element = rewardVideoAD;
        rewardVideoAD.loadAD();
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void resumeAd(NestAdData nestAdData) {
        Object adData = nestAdData.getAdData();
        if (adData instanceof NativeUnifiedADData) {
            NativeUnifiedADData nativeUnifiedADData = (NativeUnifiedADData) adData;
            nativeUnifiedADData.resume();
            nativeUnifiedADData.resumeVideo();
        }
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void resumeNativeAd(Object adObject) {
        if (adObject instanceof NativeUnifiedADData) {
            ((NativeUnifiedADData) adObject).resume();
        }
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public boolean rewardAdIsBelongTheProvider(NestAdData adObject) {
        return adObject.getAdData() instanceof RewardVideoAD;
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void showBannerAd(Activity activity, final String adProviderType, String alias, ViewGroup container, final BannerListener listener) {
        callbackBannerStartRequest(adProviderType, listener);
        destroyBannerAd();
        UnifiedBannerView unifiedBannerView = new UnifiedBannerView(activity, NestGdtManager.INSTANCE.getIdMapGDT().get(alias), new UnifiedBannerADListener() { // from class: com.wifi.gdt.ad.NestGdtProvider.showBannerAd.1
            @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
            public void onADClicked() {
                NestGdtProvider.this.callbackBannerClicked(adProviderType, listener);
            }

            @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
            public void onADClosed() {
                NestGdtProvider.this.callbackBannerClosed(adProviderType, listener);
            }

            @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
            public void onADExposure() {
                NestGdtProvider.this.callbackBannerExpose(adProviderType, listener);
            }

            @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
            public void onADLeftApplication() {
                LogExtKt.logi("onADLeftApplication", NestGdtProvider.this.TAG);
            }

            @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
            public void onADReceive() {
                NestGdtProvider.this.callbackBannerLoaded(adProviderType, listener);
            }

            @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
            public void onNoAD(AdError adError) {
                UnifiedBannerView unifiedBannerView2 = NestGdtProvider.this.banner;
                if (unifiedBannerView2 != null) {
                    unifiedBannerView2.destroy();
                }
                NestGdtProvider nestGdtProvider = NestGdtProvider.this;
                String str = adProviderType;
                BannerListener bannerListener = listener;
                StringBuilder sb = new StringBuilder();
                sb.append("错误码: ");
                sb.append(adError != null ? Integer.valueOf(adError.getErrorCode()) : null);
                sb.append(", 错误信息：");
                sb.append(adError != null ? adError.getErrorMsg() : null);
                nestGdtProvider.callbackBannerFailed(str, bannerListener, sb.toString());
            }
        });
        this.banner = unifiedBannerView;
        container.addView(unifiedBannerView);
        UnifiedBannerView unifiedBannerView2 = this.banner;
        if (unifiedBannerView2 != null) {
            unifiedBannerView2.loadAD();
        }
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void showInterAd(Activity activity) {
        UnifiedInterstitialAD unifiedInterstitialAD = this.interAd;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.show();
        }
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void showInterstitialAd(Activity activity, final NestAdData nestAdData, final PopShowListener showListener) {
        Object adData = nestAdData.getAdData();
        if (adData == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.qq.e.ads.interstitial2.UnifiedInterstitialAD");
        }
        UnifiedInterstitialAD unifiedInterstitialAD = (UnifiedInterstitialAD) adData;
        nestAdData.setPopshowListener(showListener);
        NestGdtNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_TOSHOW);
        unifiedInterstitialAD.setMediaListener(new UnifiedInterstitialMediaListener() { // from class: com.wifi.gdt.ad.NestGdtProvider.showInterstitialAd.1
            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoComplete() {
                PopShowListener popShowListener = showListener;
                if (popShowListener != null) {
                    popShowListener.onVideoComplete(SDKAlias.GDT.getType(), nestAdData);
                }
                NestGdtNativeView.Companion companion = NestGdtNativeView.INSTANCE;
                companion.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_VIDEOE);
                companion.onEvent(nestAdData, WifiNestConst.EventKey.NEST_SDK_ENDPLAY_SHOW);
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoError(AdError p0) {
                PopShowListener popShowListener = showListener;
                if (popShowListener != null) {
                    popShowListener.onVideoError(SDKAlias.GDT.getType(), nestAdData);
                }
                NestGdtNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_VIDEOT);
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoPause() {
                PopShowListener popShowListener = showListener;
                if (popShowListener != null) {
                    popShowListener.onVideoPause(SDKAlias.GDT.getType(), nestAdData);
                }
                NestGdtNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_VIDEOB);
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoStart() {
                PopShowListener popShowListener = showListener;
                if (popShowListener != null) {
                    popShowListener.onVideoStart(SDKAlias.GDT.getType(), nestAdData);
                }
                NestGdtNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_VIDEOS);
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoInit() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoLoading() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoPageClose() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoPageOpen() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoReady(long p0) {
            }
        });
        unifiedInterstitialAD.show(activity);
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void showRewardAd(Activity activity, NestAdData nestAdData, InnerRewardShowListener showListener) {
        Object adData = nestAdData.getAdData();
        if (adData == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.qq.e.ads.rewardvideo.RewardVideoAD");
        }
        RewardVideoAD rewardVideoAD = (RewardVideoAD) adData;
        NestGdtNativeView.Companion companion = NestGdtNativeView.INSTANCE;
        companion.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_TOSHOW);
        nestAdData.getRequestId();
        if (!rewardVideoAD.isValid()) {
            NestAdData.AdRenderListener adRenderListener = nestAdData.getAdRenderListener();
            if (adRenderListener != null) {
                adRenderListener.onRenderFail(SDKAlias.GDT.getType(), nestAdData, -1, "广告不可用");
            }
            companion.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_SHOW_FAIL);
            return;
        }
        nestAdData.setRewardShowListener(showListener);
        rewardVideoAD.showAD(activity);
        NestAdData.AdRenderListener adRenderListener2 = nestAdData.getAdRenderListener();
        if (adRenderListener2 != null) {
            adRenderListener2.onRenderSuccess(SDKAlias.GDT.getType(), nestAdData);
        }
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void showSplashAd(Activity activity, NestAdData nestAdData, ViewGroup container, SplashShowListener splashShowListener) {
        NestGdtNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_TOSHOW);
        if (activity.isFinishing()) {
            WifiLog.d("splashAd gdt showSplashAd activity is error");
            return;
        }
        boolean zIsViewShow = isViewShow(container);
        WifiLog.d("NestGdtProvider splashAd gdt shown " + zIsViewShow + " showSplashAd " + nestAdData.getAdData());
        if ((nestAdData.getAdData() instanceof SplashAD) && zIsViewShow) {
            Object adData = nestAdData.getAdData();
            if (adData == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.qq.e.ads.splash.SplashAD");
            }
            ((SplashAD) adData).showAd(container);
        }
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public boolean splashAdIsBelongTheProvider(NestAdData adObject) {
        return adObject.getAdData() instanceof SplashAD;
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void startAd(NestAdData nestAdData) {
        Object adData = nestAdData.getAdData();
        if (adData instanceof NativeUnifiedADData) {
            ((NativeUnifiedADData) adData).startVideo();
        }
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void stopAd(NestAdData nestAdData) {
        Object adData = nestAdData.getAdData();
        if (adData instanceof NativeUnifiedADData) {
            ((NativeUnifiedADData) adData).stopVideo();
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
    public void getDrawVideoAd(ActivityPacker packer, NestAdData nestAdData, IStrategyListener listenerStrategy) {
    }
}
