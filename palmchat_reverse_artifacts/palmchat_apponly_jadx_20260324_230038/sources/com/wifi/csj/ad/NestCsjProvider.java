package com.wifi.csj.ad;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CSJAdError;
import com.bytedance.sdk.openadsdk.CSJSplashAd;
import com.bytedance.sdk.openadsdk.ComplianceInfo;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.cdo.oaps.ad.OapsKey;
import com.huawei.openalliance.ad.constant.bq;
import com.lantern.auth.app.FunDC;
import com.ss.android.ttvecamera.TECameraUtils;
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
import com.wifi.ad.core.spstrategy.SPStrategyManager;
import com.wifi.ad.core.strategy.AbsStrategy;
import com.wifi.ad.core.strategy.IStrategyListener;
import com.wifi.ad.core.strategy.LoadScene;
import com.wifi.ad.core.utils.ScreenUtil;
import com.wifi.ad.core.utils.UIUtils;
import com.wifi.ad.core.utils.WifiLog;
import com.wifi.csj.ad.NestCsjNativeView;
import com.wifi.csj.ad.NestCsjProvider;
import com.wifi.csj.ad.data.CsjExpressAdDataAdapter;
import com.wifi.csj.ad.data.CsjFeedDataAdapter;
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
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 }2\u00020\u0001:\u0001}B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J?\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002¢\u0006\u0002\u0010\u001eJE\u0010\u001f\u001a\u00020\u00112\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000f0!2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002¢\u0006\u0002\u0010\"JE\u0010#\u001a\u00020\u00112\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000f0!2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002¢\u0006\u0002\u0010\"JA\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020'2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002¢\u0006\u0002\u0010(JO\u0010)\u001a\u00020\u00112\u0006\u0010*\u001a\u00020+2\u000e\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020-0,2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002¢\u0006\u0002\u0010.JE\u0010/\u001a\u00020\u00112\f\u0010 \u001a\b\u0012\u0004\u0012\u0002000,2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002¢\u0006\u0002\u0010\"J2\u00101\u001a\u00020\u00112\b\u00102\u001a\u0004\u0018\u00010%2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001bH\u0002J\u0010\u00103\u001a\u0002042\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J6\u00105\u001a\u00020\u00062\u0014\u00106\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u000208\u0018\u0001072\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0002J\u0012\u0010=\u001a\u00020\u00112\b\u0010>\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010?\u001a\u00020\u0011H\u0016J\b\u0010@\u001a\u00020\u0011H\u0016J\u0010\u0010A\u001a\u00020\u00112\u0006\u0010B\u001a\u000208H\u0016J\u0010\u0010C\u001a\u00020\u00062\u0006\u0010B\u001a\u00020\u0015H\u0016J\u0010\u0010D\u001a\u00020\u00062\u0006\u0010B\u001a\u00020\u0015H\u0016J\u0010\u0010E\u001a\u00020\u00062\u0006\u0010B\u001a\u00020\u0015H\u0016J\u0010\u0010F\u001a\u00020\u00062\u0006\u0010B\u001a\u00020\u0015H\u0016J(\u0010G\u001a\u00020\u00112\u0006\u0010H\u001a\u00020I2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010;\u001a\u00020<2\u0006\u0010J\u001a\u00020KH\u0016J \u0010L\u001a\u00020\u00112\u0006\u0010H\u001a\u00020I2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010;\u001a\u00020<H\u0016J&\u0010M\u001a\u00020\u00112\b\b\u0001\u0010H\u001a\u00020I2\b\b\u0001\u0010\u0014\u001a\u00020\u00152\b\b\u0001\u0010;\u001a\u00020<H\u0016J0\u0010N\u001a\u00020\u00112\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020\u00042\u0006\u0010R\u001a\u00020\u00042\u0006\u0010S\u001a\u00020\u001d2\u0006\u0010T\u001a\u00020UH\u0016J \u0010V\u001a\u00020\u00112\u0006\u0010H\u001a\u00020I2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010;\u001a\u00020<H\u0016J \u0010W\u001a\u00020\u00112\u0006\u0010H\u001a\u00020I2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010;\u001a\u00020<H\u0016J\u0012\u0010X\u001a\u0004\u0018\u00010Y2\u0006\u0010Q\u001a\u00020\u0004H\u0016J\u0012\u0010Z\u001a\u0004\u0018\u00010\u00132\b\u0010>\u001a\u0004\u0018\u00010\u0004J \u0010[\u001a\u00020\u00112\u0006\u0010H\u001a\u00020I2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010T\u001a\u00020<H\u0016J \u0010\\\u001a\u00020\u00112\u0006\u0010H\u001a\u00020I2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010;\u001a\u00020<H\u0016J\u001e\u0010]\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020^2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010;\u001a\u00020<J\u0010\u0010_\u001a\u00020\u00062\u0006\u0010B\u001a\u00020\u0015H\u0016J\u0010\u0010`\u001a\u00020\u00062\u0006\u0010B\u001a\u000208H\u0016J\u0010\u0010a\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010b\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J&\u0010c\u001a\u00020\u00112\u0014\u0010d\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u000208\u0018\u0001072\u0006\u0010\u0017\u001a\u00020\u0015H\u0002J\u0010\u0010e\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J:\u0010f\u001a\u00020\u00112\u0010\u0010g\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010%\u0018\u00010!2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001bH\u0002J(\u0010h\u001a\u00020\u00112\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020\u00042\u0006\u0010R\u001a\u00020\u00042\u0006\u0010T\u001a\u00020iH\u0016J \u0010j\u001a\u00020\u00112\u0006\u0010H\u001a\u00020I2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010;\u001a\u00020<H\u0016J\u0010\u0010k\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010l\u001a\u00020\u00112\u0006\u0010B\u001a\u000208H\u0016J\u0010\u0010m\u001a\u00020\u00062\u0006\u0010B\u001a\u00020\u0015H\u0016J0\u0010n\u001a\u00020\u00112\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020\u00042\u0006\u0010R\u001a\u00020\u00042\u0006\u0010o\u001a\u00020p2\u0006\u0010T\u001a\u00020qH\u0016J\u0010\u0010r\u001a\u00020\u00112\u0006\u0010O\u001a\u00020PH\u0016J\"\u0010s\u001a\u00020\u00112\u0006\u0010O\u001a\u00020P2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0012\u001a\u0004\u0018\u00010tH\u0016J\"\u0010u\u001a\u00020\u00112\u0006\u0010O\u001a\u00020P2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J(\u0010v\u001a\u00020\u00112\u0006\u0010O\u001a\u00020P2\u0006\u0010w\u001a\u00020\u00152\u0006\u0010o\u001a\u00020p2\u0006\u0010x\u001a\u00020yH\u0016J\u0010\u0010z\u001a\u00020\u00062\u0006\u0010B\u001a\u00020\u0015H\u0016J\u0010\u0010{\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010|\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006~"}, d2 = {"Lcom/wifi/csj/ad/NestCsjProvider;", "Lcom/wifi/ad/core/provider/BaseAdProvider;", "()V", "TAG", "", "mHasPopShowDownloadActive", "", "getMHasPopShowDownloadActive", "()Z", "setMHasPopShowDownloadActive", "(Z)V", "mHasShowDownloadActive", "getMHasShowDownloadActive", "setMHasShowDownloadActive", "mTTAd", "Lcom/bytedance/sdk/openadsdk/TTNativeExpressAd;", "addShowListener", "", "showListener", "Lcom/wifi/ad/core/listener/InnerRewardShowListener;", "nestAdData", "Lcom/wifi/ad/core/data/NestAdData;", "catchCSJInterstitialInfo", "ad", "Lcom/bytedance/sdk/openadsdk/TTFullScreenVideoAd;", "adCode", "ext", "", "adLevel", "", "(Lcom/bytedance/sdk/openadsdk/TTFullScreenVideoAd;Ljava/lang/String;Ljava/util/Map;Ljava/lang/Integer;)V", "catchCSJSensitiveExpressDraw", "ads", "", "(Ljava/util/List;Ljava/lang/String;Ljava/util/Map;Ljava/lang/Integer;)V", "catchCSJSensitiveInfo", "catchCSJSplashInfo", "Lcom/wifi/ad/core/entity/SensitiveInfo;", "splashAd", "Lcom/bytedance/sdk/openadsdk/CSJSplashAd;", "(Lcom/bytedance/sdk/openadsdk/CSJSplashAd;Ljava/lang/String;Ljava/util/Map;Ljava/lang/Integer;)Lcom/wifi/ad/core/entity/SensitiveInfo;", "catchCsjExpressNativeAd", "context", "Landroid/content/Context;", "", "Lcom/bytedance/sdk/openadsdk/TTFeedAd;", "(Landroid/content/Context;Ljava/util/List;Ljava/lang/String;Ljava/util/Map;Ljava/lang/Integer;)V", "catchCsjNativeDrawAd", "Lcom/bytedance/sdk/openadsdk/TTDrawFeedAd;", "catchCsjRewardAd", "sensitiveInfo", "createAdSlot", "Lcom/bytedance/sdk/openadsdk/AdSlot$Builder;", "csjBiddingAllow", "infoAd", "", "", "builder", "Lcom/wifi/ad/core/config/EventParams$Builder;", "listenerStrategy", "Lcom/wifi/ad/core/strategy/IStrategyListener;", "destroyAd", "requestId", "destroyBannerAd", "destroyInterAd", "destroyNativeAd", "adObject", "drawAdIsBelongTheProvider", "drawNativeAdIsBelongTheProvider", "feedAdIsBelongTheProvider", "feedNativeAdIsBelongTheProvider", "getCorrectAd", "packer", "Lcom/wifi/ad/core/helper/ActivityPacker;", "scene", "Lcom/wifi/ad/core/strategy/LoadScene;", "getDrawVideoAd", "getInterstitialAd", "getNativeAdList", "activity", "Landroid/app/Activity;", "adProviderType", "alias", "maxCount", bq.f.s, "Lcom/wifi/ad/core/listener/NativeListener;", "getNativeDrawVideoAd", "getNativeFeedAd", "getNativeView", "Lcom/wifi/ad/core/custom/flow/BaseNativeView;", "getShowListener", "getSplashAd", "getTemplateFeedAd", "initRewardListener", "Lcom/bytedance/sdk/openadsdk/TTRewardVideoAd;", "interstitialAdIsBelongTheProvider", "nativeAdIsBelongTheProvider", "onNestAdLoad", "onNestAdUnLoad", "parseExtraInfo", "info", "pauseAd", "reportSensitiveInfo", "sensitiveInfoList", "requestInterAd", "Lcom/wifi/ad/core/listener/InterListener;", "requestRewardAd", "resumeAd", "resumeNativeAd", "rewardAdIsBelongTheProvider", "showBannerAd", "container", "Landroid/view/ViewGroup;", "Lcom/wifi/ad/core/listener/BannerListener;", "showInterAd", "showInterstitialAd", "Lcom/wifi/ad/core/listener/PopShowListener;", "showRewardAd", "showSplashAd", "adData", "splashShowListener", "Lcom/wifi/ad/core/listener/SplashShowListener;", "splashAdIsBelongTheProvider", "startAd", "stopAd", "Companion", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
public final class NestCsjProvider extends BaseAdProvider {
    public static final String DSP_NAME = "Pangolin_out";
    public static final String SDK_FROM = "Pangolin";
    private final String TAG = "CsjProvider";
    private boolean mHasPopShowDownloadActive;
    private boolean mHasShowDownloadActive;
    private TTNativeExpressAd mTTAd;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static HashMap<String, InnerRewardShowListener> showListenerMap = new HashMap<>();
    private static final HashMap<String, Integer> LOAD_COUNTER = new HashMap<>();

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R&\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/wifi/csj/ad/NestCsjProvider$Companion;", "", "()V", "DSP_NAME", "", "LOAD_COUNTER", "Ljava/util/HashMap;", "", "SDK_FROM", "showListenerMap", "Lcom/wifi/ad/core/listener/InnerRewardShowListener;", "getShowListenerMap", "()Ljava/util/HashMap;", "setShowListenerMap", "(Ljava/util/HashMap;)V", "createDislikeCallback", "Lcom/bytedance/sdk/openadsdk/TTAdDislike$DislikeInteractionCallback;", "listenerStrategy", "Lcom/wifi/ad/core/strategy/IStrategyListener;", "nestAdData", "Lcom/wifi/ad/core/data/NestAdData;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public final TTAdDislike.DislikeInteractionCallback createDislikeCallback(final IStrategyListener listenerStrategy, final NestAdData nestAdData) {
            return new TTAdDislike.DislikeInteractionCallback() { // from class: com.wifi.csj.ad.NestCsjProvider$Companion$createDislikeCallback$1
                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public void onSelected(int p0, String reason, boolean p2) {
                    listenerStrategy.onDislikeClicked(nestAdData, reason);
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public void onCancel() {
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public void onShow() {
                }
            };
        }

        public final HashMap<String, InnerRewardShowListener> getShowListenerMap() {
            return NestCsjProvider.showListenerMap;
        }

        public final void setShowListenerMap(HashMap<String, InnerRewardShowListener> map) {
            NestCsjProvider.showListenerMap = map;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LoadScene.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[LoadScene.DRAWAD.ordinal()] = 1;
            iArr[LoadScene.FEED.ordinal()] = 2;
            iArr[LoadScene.REWARD.ordinal()] = 3;
            iArr[LoadScene.INTERSTITIAL.ordinal()] = 4;
            iArr[LoadScene.SPLASH.ordinal()] = 5;
        }
    }

    /* JADX INFO: renamed from: com.wifi.csj.ad.NestCsjProvider$getTemplateFeedAd$2, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0016¨\u0006\f"}, d2 = {"com/wifi/csj/ad/NestCsjProvider$getTemplateFeedAd$2", "Lcom/bytedance/sdk/openadsdk/TTAdNative$NativeExpressAdListener;", "onError", "", "code", "", "message", "", "onNativeExpressAdLoad", "ads", "", "Lcom/bytedance/sdk/openadsdk/TTNativeExpressAd;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
    public static final class AnonymousClass2 implements TTAdNative.NativeExpressAdListener {
        final /* synthetic */ EventParams.Builder $builder;
        final /* synthetic */ IStrategyListener $listenerStrategy;
        final /* synthetic */ NestAdData $nestAdData;
        final /* synthetic */ ActivityPacker $packer;

        public AnonymousClass2(NestAdData nestAdData, EventParams.Builder builder, IStrategyListener iStrategyListener, ActivityPacker activityPacker) {
            this.$nestAdData = nestAdData;
            this.$builder = builder;
            this.$listenerStrategy = iStrategyListener;
            this.$packer = activityPacker;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public void onError(int code, String message) {
            EventReporter eventReporter = EventReporter.INSTANCE;
            NestAdData nestAdData = this.$nestAdData;
            EventParams.Builder builder = this.$builder;
            Intrinsics.checkExpressionValueIsNotNull(builder, "builder");
            eventReporter.reportNoRespDi(nestAdData, builder, String.valueOf(code), message);
            WifiLog.d("NestCsjProvider getTemplateFeedAd onError code = " + code + " message = " + message);
            IStrategyListener iStrategyListener = this.$listenerStrategy;
            if (iStrategyListener != null) {
                iStrategyListener.onAdFailed(this.$nestAdData, message, code);
            }
            NestCsjProvider.this.onNestAdUnLoadReport(this.$nestAdData);
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [T, java.util.ArrayList] */
        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public void onNativeExpressAdLoad(List<TTNativeExpressAd> ads) {
            if (ads == null || ads.isEmpty()) {
                EventReporter eventReporter = EventReporter.INSTANCE;
                NestAdData nestAdData = this.$nestAdData;
                EventParams.Builder builder = this.$builder;
                Intrinsics.checkExpressionValueIsNotNull(builder, "builder");
                eventReporter.reportNoRespDi(nestAdData, builder, "30200", "");
                WifiLog.d("NestCsjProvider onNativeExpressAdLoad ad is null!");
                IStrategyListener iStrategyListener = this.$listenerStrategy;
                if (iStrategyListener != null) {
                    iStrategyListener.onAdFailed(this.$nestAdData, "ad is null or empty", -1);
                    return;
                }
                return;
            }
            if (!ads.isEmpty()) {
                NestCsjProvider nestCsjProvider = NestCsjProvider.this;
                int i = 0;
                Map<String, Object> mediaExtraInfo = ads.get(0).getMediaExtraInfo();
                NestAdData nestAdData2 = this.$nestAdData;
                EventParams.Builder builder2 = this.$builder;
                Intrinsics.checkExpressionValueIsNotNull(builder2, "builder");
                if (nestCsjProvider.csjBiddingAllow(mediaExtraInfo, nestAdData2, builder2, this.$listenerStrategy)) {
                    return;
                }
                try {
                    Map<String, Object> mediaExtraInfo2 = ads.get(0).getMediaExtraInfo();
                    if (mediaExtraInfo2 != null) {
                        i = Integer.parseInt(String.valueOf(mediaExtraInfo2.get(OapsKey.KEY_PRICE)));
                        NestCsjProvider nestCsjProvider2 = NestCsjProvider.this;
                        NestAdData nestAdData3 = this.$nestAdData;
                        EventParams.Builder builder3 = this.$builder;
                        Intrinsics.checkExpressionValueIsNotNull(builder3, "builder");
                        if (nestCsjProvider2.checkAdEcpmDone(i, nestAdData3, builder3, this.$listenerStrategy)) {
                            return;
                        }
                    }
                } catch (Exception unused) {
                }
                int testPriceSwitchEcpm = NestCsjProvider.this.getTestPriceSwitchEcpm(i, this.$nestAdData);
                WifiLog.d("NestCsjProvider getTemplateFeedAd onADLoaded priceSwitch price " + testPriceSwitchEcpm + " code " + this.$nestAdData.getAdCode());
                NestCsjProvider nestCsjProvider3 = NestCsjProvider.this;
                NestAdData nestAdData4 = this.$nestAdData;
                EventParams.Builder builder4 = this.$builder;
                Intrinsics.checkExpressionValueIsNotNull(builder4, "builder");
                if (nestCsjProvider3.checkAdPriceSwitch(testPriceSwitchEcpm, nestAdData4, builder4, this.$listenerStrategy)) {
                    return;
                }
            }
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = new ArrayList();
            for (TTNativeExpressAd tTNativeExpressAd : ads) {
                Activity activityIfExist = this.$packer.getActivityIfExist();
                if (activityIfExist == null) {
                    onError(99999, "activity has been recycled");
                    return;
                }
                tTNativeExpressAd.setDislikeCallback(activityIfExist, NestCsjProvider.INSTANCE.createDislikeCallback(this.$listenerStrategy, this.$nestAdData));
                NestAdData nestAdData5 = this.$nestAdData;
                nestAdData5.setDspName(NestCsjProvider.DSP_NAME);
                nestAdData5.setAppId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.CSJ)));
                nestAdData5.setSdkFrom(NestCsjProvider.SDK_FROM);
                nestAdData5.setAdData(tTNativeExpressAd);
                nestAdData5.setSensitiveInfo(CsjSensitiveCatcher.INSTANCE.catchCsjExpressTemplateAd(tTNativeExpressAd, this.$nestAdData.getAdLevel()));
                nestAdData5.setDataAdapter(new CsjExpressAdDataAdapter(tTNativeExpressAd));
                NestCsjProvider.this.parseExtraInfo(tTNativeExpressAd.getMediaExtraInfo(), nestAdData5);
                ((List) objectRef.element).add(this.$nestAdData);
                tTNativeExpressAd.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.wifi.csj.ad.NestCsjProvider$getTemplateFeedAd$2$onNativeExpressAdLoad$$inlined$forEach$lambda$1
                    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                    public void onAdClicked(View view, int type) {
                        WifiLog.d("NestCsjNativeView onAdClicked type " + type);
                        NestCsjNativeView.INSTANCE.onEvent(this.this$0.$nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_CLICK);
                        NestCsjProvider.AnonymousClass2 anonymousClass2 = this.this$0;
                        IStrategyListener iStrategyListener2 = anonymousClass2.$listenerStrategy;
                        if (iStrategyListener2 != null) {
                            iStrategyListener2.onAdClicked(anonymousClass2.$nestAdData, SDKAlias.CSJ.getType());
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                    public void onAdShow(View view, int type) {
                        WifiLog.d("NestCsjNativeView onAdShow type " + type);
                        NestCsjNativeView.INSTANCE.onEvent(this.this$0.$nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_SHOW);
                        NestCsjProvider.AnonymousClass2 anonymousClass2 = this.this$0;
                        IStrategyListener iStrategyListener2 = anonymousClass2.$listenerStrategy;
                        if (iStrategyListener2 != null) {
                            iStrategyListener2.onAdExpose(anonymousClass2.$nestAdData, SDKAlias.CSJ.getType());
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                    public void onRenderFail(View view, String str, int i2) {
                        WifiLog.d("NestCsjNativeView onRenderFail msg = " + str);
                        NestCsjNativeView.Companion companion = NestCsjNativeView.INSTANCE;
                        companion.onEvent(this.this$0.$nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_TOSHOW_FAIL, Integer.valueOf(i2), str);
                        companion.onEvent(this.this$0.$nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_SHOW_FAIL, Integer.valueOf(i2), str);
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                    public void onRenderSuccess(View view, float f, float f2) {
                        WifiLog.d("NestCsjNativeView onRenderSuccess width = " + f + " height=" + f2);
                    }
                });
                tTNativeExpressAd.render();
            }
            NestCsjProvider nestCsjProvider4 = NestCsjProvider.this;
            String adCode = this.$nestAdData.getAdCode();
            AdParams adParams = this.$nestAdData.getAdParams();
            nestCsjProvider4.catchCSJSensitiveInfo(ads, adCode, adParams != null ? adParams.getExt() : null, this.$nestAdData.getAdLevel());
            EventReporter eventReporter2 = EventReporter.INSTANCE;
            NestAdData nestAdData6 = this.$nestAdData;
            EventParams.Builder builder5 = this.$builder;
            Intrinsics.checkExpressionValueIsNotNull(builder5, "builder");
            eventReporter2.reportRespDi(nestAdData6, builder5, ads.size());
            IStrategyListener iStrategyListener2 = this.$listenerStrategy;
            if (iStrategyListener2 != null) {
                iStrategyListener2.onAdLoaded((List) objectRef.element);
            }
            NestCsjProvider.this.onNestAdLoadReport(this.$nestAdData);
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
    public final void catchCSJInterstitialInfo(TTFullScreenVideoAd ad, String adCode, Map<String, String> ext, Integer adLevel) {
        if (WifiNestAd.INSTANCE.isCatchThirdInfo()) {
            ArrayList arrayList = new ArrayList();
            SensitiveInfo sensitiveInfoCatchCsjInterstitialAd = CsjSensitiveCatcher.INSTANCE.catchCsjInterstitialAd(ad, adLevel);
            if (sensitiveInfoCatchCsjInterstitialAd != null) {
                arrayList.add(sensitiveInfoCatchCsjInterstitialAd);
            }
            reportSensitiveInfo(arrayList, adCode, ext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void catchCSJSensitiveExpressDraw(List<? extends TTNativeExpressAd> ads, String adCode, Map<String, String> ext, Integer adLevel) {
        if (WifiNestAd.INSTANCE.isCatchThirdInfo()) {
            reportSensitiveInfo(CsjSensitiveCatcher.INSTANCE.catchCsjExpressDrawAds(ads, adLevel), adCode, ext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void catchCSJSensitiveInfo(List<? extends TTNativeExpressAd> ads, String adCode, Map<String, String> ext, Integer adLevel) {
        if (WifiNestAd.INSTANCE.isCatchThirdInfo()) {
            reportSensitiveInfo(CsjSensitiveCatcher.INSTANCE.catchCsjExpressTemplateAds(ads, adLevel), adCode, ext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SensitiveInfo catchCSJSplashInfo(CSJSplashAd splashAd, String adCode, Map<String, String> ext, Integer adLevel) {
        if (!WifiNestAd.INSTANCE.isCatchThirdInfo()) {
            return null;
        }
        SensitiveInfo sensitiveInfoCatchCsjSplashAd = CsjSensitiveCatcher.INSTANCE.catchCsjSplashAd(splashAd, adLevel);
        ArrayList arrayList = new ArrayList();
        if (sensitiveInfoCatchCsjSplashAd != null) {
            arrayList.add(sensitiveInfoCatchCsjSplashAd);
        }
        reportSensitiveInfo(arrayList, adCode, ext);
        return sensitiveInfoCatchCsjSplashAd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void catchCsjExpressNativeAd(Context context, List<? extends TTFeedAd> ads, String adCode, Map<String, String> ext, Integer adLevel) {
        if (WifiNestAd.INSTANCE.isCatchThirdInfo()) {
            reportSensitiveInfo(CsjSensitiveCatcher.INSTANCE.catchCsjExpressNativeAds(ads, adLevel), adCode, ext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void catchCsjNativeDrawAd(List<TTDrawFeedAd> ads, String adCode, Map<String, String> ext, Integer adLevel) {
        if (WifiNestAd.INSTANCE.isCatchThirdInfo()) {
            reportSensitiveInfo(CsjSensitiveCatcher.INSTANCE.catchCsjNativeDrawAds(ads, adLevel), adCode, ext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void catchCsjRewardAd(SensitiveInfo sensitiveInfo, String adCode, Map<String, String> ext) {
        if (WifiNestAd.INSTANCE.isCatchThirdInfo()) {
            ArrayList arrayList = new ArrayList();
            if (sensitiveInfo != null) {
                arrayList.add(sensitiveInfo);
            }
            reportSensitiveInfo(arrayList, adCode, ext);
        }
    }

    private final AdSlot.Builder createAdSlot(NestAdData nestAdData) {
        AdSlot.Builder builder = new AdSlot.Builder();
        AdParams adParams = nestAdData.getAdParams();
        int scene = adParams != null ? adParams.getScene() : -1;
        WifiLog.d("NestCsjProvider createAdSlot: scene " + scene);
        if (scene > 0) {
            try {
                int primeRitSwitch = nestAdData.getPrimeRitSwitch();
                WifiLog.d("NestCsjProvider createAdSlot: primeRitSwitch " + primeRitSwitch);
                if (primeRitSwitch == 1 && nestAdData.getStrategyListener() != null && (nestAdData.getStrategyListener() instanceof SPStrategyManager)) {
                    AbsStrategy strategyListener = nestAdData.getStrategyListener();
                    if (strategyListener == null) {
                        throw new TypeCastException("null cannot be cast to non-null type com.wifi.ad.core.spstrategy.SPStrategyManager");
                    }
                    SPStrategyManager sPStrategyManager = (SPStrategyManager) strategyListener;
                    int adLoadSeq = sPStrategyManager.getAdLoadSeq();
                    if (adLoadSeq != 0) {
                        builder.setAdloadSeq(adLoadSeq);
                        WifiLog.d("NestCsjProvider createAdSlot: AdLoadSeq " + adLoadSeq);
                    }
                    String curCjsMaxEcpm = sPStrategyManager.getCurCjsMaxEcpm();
                    if (!TextUtils.isEmpty(curCjsMaxEcpm)) {
                        builder.setPrimeRit(curCjsMaxEcpm);
                    }
                    WifiLog.d("NestCsjProvider createAdSlot: PrimeRit " + curCjsMaxEcpm);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return builder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean csjBiddingAllow(Map<String, ? extends Object> infoAd, NestAdData nestAdData, EventParams.Builder builder, IStrategyListener listenerStrategy) {
        if (nestAdData == null || nestAdData.getAdCostType() != NestAdData.AdCostType.INSTANCE.getADCOSTTYPE_BIDING()) {
            return false;
        }
        if (infoAd == null) {
            EventReporter.INSTANCE.reportNoRespDi(nestAdData, builder, "40201", "");
            if (listenerStrategy != null) {
                listenerStrategy.onAdFailed(nestAdData, "ecpm biding not allow", -3);
            }
            return true;
        }
        if (!infoAd.containsKey(OapsKey.KEY_PRICE)) {
            EventReporter.INSTANCE.reportNoRespDi(nestAdData, builder, "40202", "");
            if (listenerStrategy != null) {
                listenerStrategy.onAdFailed(nestAdData, "ecpm biding not allow", -4);
            }
            return true;
        }
        try {
            WifiLog.d("csjBiddingAllow checkAdEcpmDone allow price " + Integer.parseInt(String.valueOf(infoAd.get(OapsKey.KEY_PRICE))));
            return false;
        } catch (Exception unused) {
            EventReporter.INSTANCE.reportNoRespDi(nestAdData, builder, "40203", "");
            if (listenerStrategy != null) {
                listenerStrategy.onAdFailed(nestAdData, "ecpm biding not allow", -5);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void parseExtraInfo(Map<String, ? extends Object> info, NestAdData ad) {
        if (info == null) {
            return;
        }
        Object obj = info.get(OapsKey.KEY_PRICE);
        if (obj != null) {
            try {
                getAdEcpm(Integer.parseInt(obj.toString()), ad);
            } catch (Exception e) {
                WifiLog.e("NestCsjProvider parseExtraInfo get price failed.", e);
                return;
            }
        }
        Object obj2 = info.get("ecom_info");
        WifiLog.d("NestCsjProvider parseExtraInfo ecomInfo. " + obj2);
        if (obj2 instanceof JSONObject) {
            Object objOpt = ((JSONObject) obj2).opt("if_ecbudget");
            WifiLog.d("NestCsjProvider parseExtraInfo ifEcbudget. " + objOpt);
            if (Intrinsics.areEqual(objOpt, (Object) 1)) {
                String discountInfo = ((JSONObject) obj2).optString(EventParams.KEY_DISCOUNT_INFO);
                WifiLog.d("NestCsjProvider parseExtraInfo discountInfo. " + discountInfo);
                if (TextUtils.isEmpty(discountInfo)) {
                    return;
                }
                Intrinsics.checkExpressionValueIsNotNull(discountInfo, "discountInfo");
                ad.setDiscountInfo(discountInfo);
            }
        }
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
        if (jSONArray.length() == 0) {
            return;
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
    public void destroyBannerAd() {
        TTNativeExpressAd tTNativeExpressAd = this.mTTAd;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.destroy();
        }
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void destroyNativeAd(Object adObject) {
        boolean z = adObject instanceof TTFeedAd;
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public boolean drawAdIsBelongTheProvider(NestAdData adObject) {
        WifiLog.d("NestCsjProvider drawAdIsBelongTheProvider adObject = " + adObject);
        return adObject.getAdData() instanceof TTNativeExpressAd;
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public boolean drawNativeAdIsBelongTheProvider(NestAdData adObject) {
        WifiLog.d("NestCsjProvider drawNativeAdIsBelongTheProvider adObject = " + adObject);
        return adObject.getAdData() instanceof TTDrawFeedAd;
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public boolean feedAdIsBelongTheProvider(NestAdData adObject) {
        return adObject.getAdData() instanceof TTNativeExpressAd;
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public boolean feedNativeAdIsBelongTheProvider(NestAdData adObject) {
        return adObject.getAdData() instanceof TTFeedAd;
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void getCorrectAd(ActivityPacker packer, NestAdData nestAdData, IStrategyListener listenerStrategy, LoadScene scene) {
        if (!NestCsjManager.INSTANCE.getInitDone()) {
            listenerStrategy.onAdFailed(nestAdData, "sdk not init", -1001);
            return;
        }
        if (!RequestSDKConfig.INSTANCE.checkAllowRequest(nestAdData.getAdScene(), "csj")) {
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
            if (1 == nestAdData.getRenderStyle()) {
                nestAdData.setNativeAd(true);
                getNativeFeedAd(packer, nestAdData, listenerStrategy);
                return;
            } else {
                if (2 == nestAdData.getRenderStyle()) {
                    getTemplateFeedAd(packer, nestAdData, listenerStrategy);
                    return;
                }
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

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void getDrawVideoAd(ActivityPacker packer, final NestAdData nestAdData, final IStrategyListener listenerStrategy) {
        String nestType;
        listenerStrategy.onStart(nestAdData);
        EventParams.Builder renderStyle = new EventParams.Builder().setDspName(DSP_NAME).setNestSid(nestAdData.getNestSid()).setMediaId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.CSJ))).setSrcId(String.valueOf(nestAdData.getAdCode())).setRenderStyle(nestAdData.getRenderStyle());
        AdParams adParams = nestAdData.getAdParams();
        if (adParams == null || (nestType = adParams.getNestType()) == null) {
            nestType = "";
        }
        final EventParams.Builder builder = renderStyle.setNestType(nestType).setSdkFrom(SDK_FROM).setInventoryId(nestAdData.getInventoryId());
        EventReporter eventReporter = EventReporter.INSTANCE;
        Intrinsics.checkExpressionValueIsNotNull(builder, "builder");
        eventReporter.reportReqDi(nestAdData, builder);
        TTAdNative.NativeExpressAdListener nativeExpressAdListener = new TTAdNative.NativeExpressAdListener() { // from class: com.wifi.csj.ad.NestCsjProvider$getDrawVideoAd$adListener$1
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onError(int code, String message) {
                EventReporter eventReporter2 = EventReporter.INSTANCE;
                NestAdData nestAdData2 = nestAdData;
                EventParams.Builder builder2 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder2, "builder");
                eventReporter2.reportNoRespDi(nestAdData2, builder2, String.valueOf(code), message);
                WifiLog.d("NestCsjProvider getDrawVideoAd onError code = " + code + " message = " + message);
                IStrategyListener iStrategyListener = listenerStrategy;
                if (iStrategyListener != null) {
                    iStrategyListener.onAdFailed(nestAdData, message, code);
                }
                this.this$0.onNestAdUnLoad(nestAdData);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onNativeExpressAdLoad(List<? extends TTNativeExpressAd> ads) {
                if (ads.isEmpty()) {
                    EventReporter eventReporter2 = EventReporter.INSTANCE;
                    NestAdData nestAdData2 = nestAdData;
                    EventParams.Builder builder2 = builder;
                    Intrinsics.checkExpressionValueIsNotNull(builder2, "builder");
                    eventReporter2.reportNoRespDi(nestAdData2, builder2, "30200", "");
                    WifiLog.d("NestCsjProvider onNativeExpressAdLoad ad is null!");
                    IStrategyListener iStrategyListener = listenerStrategy;
                    if (iStrategyListener != null) {
                        iStrategyListener.onAdFailed(nestAdData, "ad is null or empty", -1);
                        return;
                    }
                    return;
                }
                WifiLog.d("NestCsjProvider getDrawVideoAd onDrawAdLoad adList.size = " + ads.size());
                NestCsjProvider nestCsjProvider = this.this$0;
                String adCode = nestAdData.getAdCode();
                AdParams adParams2 = nestAdData.getAdParams();
                nestCsjProvider.catchCSJSensitiveExpressDraw(ads, adCode, adParams2 != null ? adParams2.getExt() : null, nestAdData.getAdLevel());
                ArrayList arrayList = new ArrayList();
                for (TTNativeExpressAd tTNativeExpressAd : ads) {
                    NestAdData nestAdData3 = nestAdData;
                    nestAdData3.setDspName(NestCsjProvider.DSP_NAME);
                    nestAdData3.setAppId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.CSJ)));
                    nestAdData3.setSdkFrom(NestCsjProvider.SDK_FROM);
                    nestAdData3.setAdData(tTNativeExpressAd);
                    nestAdData3.setSensitiveInfo(CsjSensitiveCatcher.INSTANCE.catchCsjExpressDrawAd(tTNativeExpressAd, nestAdData.getAdLevel()));
                    this.this$0.parseExtraInfo(tTNativeExpressAd.getMediaExtraInfo(), nestAdData3);
                    arrayList.add(nestAdData);
                }
                EventReporter eventReporter3 = EventReporter.INSTANCE;
                NestAdData nestAdData4 = nestAdData;
                EventParams.Builder builder3 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder3, "builder");
                eventReporter3.reportRespDi(nestAdData4, builder3, ads.size());
                IStrategyListener iStrategyListener2 = listenerStrategy;
                if (iStrategyListener2 != null) {
                    iStrategyListener2.onAdLoaded(arrayList);
                }
                this.this$0.onNestAdLoad(nestAdData);
            }
        };
        float screenWidthDp = UIUtils.getScreenWidthDp(packer.getAppContext());
        Activity activityIfExist = packer.getActivityIfExist();
        if (activityIfExist == null) {
            nativeExpressAdListener.onError(99999, "activity has been recycled");
            return;
        }
        float height = UIUtils.getHeight(activityIfExist);
        WifiLog.d("NestCsjProvider getDrawVideoAd adLevelName = " + nestAdData.getAdLevelName() + " adCode = " + nestAdData.getAdCode() + " adLevel = " + nestAdData.getAdLevel() + " adType = " + nestAdData.getAdType() + " expressViewWidth = " + screenWidthDp + " expressViewHeight=" + height);
        TTAdSdk.getAdManager().createAdNative(packer.getAppContext()).loadExpressDrawFeedAd(createAdSlot(nestAdData).setCodeId(nestAdData.getAdCode()).setSupportDeepLink(true).setExpressViewAcceptedSize(screenWidthDp, height).setAdCount(1).build(), nativeExpressAdListener);
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void getInterstitialAd(@NonNull ActivityPacker packer, @NonNull final NestAdData nestAdData, @NonNull final IStrategyListener listenerStrategy) {
        String nestType;
        listenerStrategy.onStart(nestAdData);
        EventParams.Builder renderStyle = new EventParams.Builder().setDspName(DSP_NAME).setNestSid(nestAdData.getNestSid()).setMediaId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.CSJ))).setSrcId(String.valueOf(nestAdData.getAdCode())).setRenderStyle(nestAdData.getRenderStyle());
        AdParams adParams = nestAdData.getAdParams();
        if (adParams == null || (nestType = adParams.getNestType()) == null) {
            nestType = "";
        }
        final EventParams.Builder builder = renderStyle.setNestType(nestType).setInventoryId(nestAdData.getInventoryId()).setSdkFrom(SDK_FROM);
        EventReporter eventReporter = EventReporter.INSTANCE;
        Intrinsics.checkExpressionValueIsNotNull(builder, "builder");
        eventReporter.reportReqDi(nestAdData, builder);
        TTAdSdk.getAdManager().createAdNative(packer.getAppContext()).loadFullScreenVideoAd(createAdSlot(nestAdData).setCodeId(nestAdData.getAdCode()).setExpressViewAcceptedSize(500.0f, 500.0f).setSupportDeepLink(true).setOrientation(1).build(), new TTAdNative.FullScreenVideoAdListener() { // from class: com.wifi.csj.ad.NestCsjProvider.getInterstitialAd.1
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
            public void onError(int code, String msg) {
                EventReporter eventReporter2 = EventReporter.INSTANCE;
                NestAdData nestAdData2 = nestAdData;
                EventParams.Builder builder2 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder2, "builder");
                eventReporter2.reportNoRespDi(nestAdData2, builder2, String.valueOf(code), msg);
                WifiLog.d("NestCsjProvider getInterstitialAd onError code = " + code + " message = " + msg);
                IStrategyListener iStrategyListener = listenerStrategy;
                if (iStrategyListener != null) {
                    iStrategyListener.onAdFailed(nestAdData, msg, code);
                }
                NestCsjProvider.this.onNestAdUnLoad(nestAdData);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
            public void onFullScreenVideoAdLoad(TTFullScreenVideoAd ad) {
                NestCsjProvider nestCsjProvider = NestCsjProvider.this;
                Map<String, Object> mediaExtraInfo = ad.getMediaExtraInfo();
                NestAdData nestAdData2 = nestAdData;
                EventParams.Builder builder2 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder2, "builder");
                if (nestCsjProvider.csjBiddingAllow(mediaExtraInfo, nestAdData2, builder2, listenerStrategy)) {
                    return;
                }
                int i = 0;
                try {
                    Map<String, Object> mediaExtraInfo2 = ad.getMediaExtraInfo();
                    if (mediaExtraInfo2 != null) {
                        i = Integer.parseInt(String.valueOf(mediaExtraInfo2.get(OapsKey.KEY_PRICE)));
                        NestCsjProvider nestCsjProvider2 = NestCsjProvider.this;
                        NestAdData nestAdData3 = nestAdData;
                        EventParams.Builder builder3 = builder;
                        Intrinsics.checkExpressionValueIsNotNull(builder3, "builder");
                        if (nestCsjProvider2.checkAdEcpmDone(i, nestAdData3, builder3, listenerStrategy)) {
                            return;
                        }
                    }
                } catch (Exception unused) {
                }
                int testPriceSwitchEcpm = NestCsjProvider.this.getTestPriceSwitchEcpm(i, nestAdData);
                WifiLog.d("NestCsjProvider getInterstitialAd onADLoaded priceSwitch price " + testPriceSwitchEcpm + " code " + nestAdData.getAdCode());
                NestCsjProvider nestCsjProvider3 = NestCsjProvider.this;
                NestAdData nestAdData4 = nestAdData;
                EventParams.Builder builder4 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder4, "builder");
                if (nestCsjProvider3.checkAdPriceSwitch(testPriceSwitchEcpm, nestAdData4, builder4, listenerStrategy)) {
                    return;
                }
                NestCsjProvider nestCsjProvider4 = NestCsjProvider.this;
                String adCode = nestAdData.getAdCode();
                AdParams adParams2 = nestAdData.getAdParams();
                nestCsjProvider4.catchCSJInterstitialInfo(ad, adCode, adParams2 != null ? adParams2.getExt() : null, nestAdData.getAdLevel());
                ArrayList arrayList = new ArrayList();
                nestAdData.setDspName(NestCsjProvider.DSP_NAME);
                nestAdData.setAppId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.CSJ)));
                nestAdData.setSdkFrom(NestCsjProvider.SDK_FROM);
                nestAdData.setAdData(ad);
                NestAdData nestAdData5 = nestAdData;
                nestAdData5.setSensitiveInfo(CsjSensitiveCatcher.INSTANCE.catchCsjInterstitialAd(ad, nestAdData5.getAdLevel()));
                NestCsjProvider.this.parseExtraInfo(ad.getMediaExtraInfo(), nestAdData);
                arrayList.add(nestAdData);
                EventReporter eventReporter2 = EventReporter.INSTANCE;
                NestAdData nestAdData6 = nestAdData;
                EventParams.Builder builder5 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder5, "builder");
                eventReporter2.reportRespDi(nestAdData6, builder5, 1);
                IStrategyListener iStrategyListener = listenerStrategy;
                if (iStrategyListener != null) {
                    iStrategyListener.onAdLoaded(arrayList);
                }
                NestCsjProvider.this.onNestAdLoad(nestAdData);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
            public void onFullScreenVideoCached() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
            public void onFullScreenVideoCached(TTFullScreenVideoAd p0) {
                nestAdData.setVideoCached(true);
            }
        });
    }

    public final boolean getMHasPopShowDownloadActive() {
        return this.mHasPopShowDownloadActive;
    }

    public final boolean getMHasShowDownloadActive() {
        return this.mHasShowDownloadActive;
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void getNativeAdList(Activity activity, final String adProviderType, String alias, int maxCount, final NativeListener listener) {
        callbackFlowStartRequest(adProviderType, listener);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = activity.getWindowManager();
        Intrinsics.checkExpressionValueIsNotNull(windowManager, "activity.windowManager");
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        AdSlot.Builder supportDeepLink = new AdSlot.Builder().setCodeId(NestCsjManager.INSTANCE.getIdMapCsj().get(alias)).setSupportDeepLink(true);
        int i = displayMetrics.widthPixels;
        TTAdSdk.getAdManager().createAdNative(activity).loadFeedAd(supportDeepLink.setImageAcceptedSize(i, (i * 9) / 16).setAdCount(maxCount).build(), new TTAdNative.FeedAdListener() { // from class: com.wifi.csj.ad.NestCsjProvider.getNativeAdList.1
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
            public void onError(int errorCode, String errorMsg) {
                NestCsjProvider.this.callbackFlowFailed(adProviderType, listener, "错误码: " + errorCode + "}, 错误信息：" + errorMsg);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
            public void onFeedAdLoad(List<TTFeedAd> adList) {
                List<TTFeedAd> list = adList;
                if (list == null || list.isEmpty()) {
                    NestCsjProvider.this.callbackFlowFailed(adProviderType, listener, "请求成功，但是返回的list为空");
                } else {
                    NestCsjProvider.this.callbackFlowLoaded(adProviderType, listener, adList);
                }
            }
        });
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void getNativeDrawVideoAd(ActivityPacker packer, final NestAdData nestAdData, final IStrategyListener listenerStrategy) {
        String nestType;
        super.getNativeDrawVideoAd(packer, nestAdData, listenerStrategy);
        WifiLog.d("NestCsjProvider getNativeDrawVideoAd adLevelName = " + nestAdData.getAdLevelName() + " adCode = " + nestAdData.getAdCode() + " adLevel = " + nestAdData.getAdLevel() + " adType = " + nestAdData.getAdType() + ' ');
        listenerStrategy.onStart(nestAdData);
        EventParams.Builder renderStyle = new EventParams.Builder().setDspName(DSP_NAME).setNestSid(nestAdData.getNestSid()).setMediaId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.CSJ))).setSrcId(String.valueOf(nestAdData.getAdCode())).setRenderStyle(nestAdData.getRenderStyle());
        AdParams adParams = nestAdData.getAdParams();
        if (adParams == null || (nestType = adParams.getNestType()) == null) {
            nestType = "";
        }
        final EventParams.Builder builder = renderStyle.setNestType(nestType).setInventoryId(nestAdData.getInventoryId()).setSdkFrom(SDK_FROM);
        EventReporter eventReporter = EventReporter.INSTANCE;
        Intrinsics.checkExpressionValueIsNotNull(builder, "builder");
        eventReporter.reportReqDi(nestAdData, builder);
        TTAdSdk.getAdManager().createAdNative(packer.getAppContext()).loadDrawFeedAd(createAdSlot(nestAdData).setCodeId(String.valueOf(nestAdData.getAdCode())).setSupportDeepLink(true).setImageAcceptedSize(FunDC.ID_AUTH_1080, TECameraUtils.CAPTURE_NORMAL).setAdCount(1).build(), new TTAdNative.DrawFeedAdListener() { // from class: com.wifi.csj.ad.NestCsjProvider.getNativeDrawVideoAd.1
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.DrawFeedAdListener
            public void onDrawFeedAdLoad(List<TTDrawFeedAd> ads) {
                int i;
                Map<String, Object> mediaExtraInfo;
                if (ads == null || ads.isEmpty()) {
                    EventReporter eventReporter2 = EventReporter.INSTANCE;
                    NestAdData nestAdData2 = nestAdData;
                    EventParams.Builder builder2 = builder;
                    Intrinsics.checkExpressionValueIsNotNull(builder2, "builder");
                    eventReporter2.reportNoRespDi(nestAdData2, builder2, "30200", "");
                    WifiLog.d("NestCsjProvider onDrawFeedAdLoad ad is null!");
                    IStrategyListener iStrategyListener = listenerStrategy;
                    if (iStrategyListener != null) {
                        iStrategyListener.onAdFailed(nestAdData, "ad is null or empty", -1);
                        return;
                    }
                    return;
                }
                boolean z = true;
                if (!ads.isEmpty()) {
                    NestCsjProvider nestCsjProvider = NestCsjProvider.this;
                    Map<String, Object> mediaExtraInfo2 = ads.get(0).getMediaExtraInfo();
                    NestAdData nestAdData3 = nestAdData;
                    EventParams.Builder builder3 = builder;
                    Intrinsics.checkExpressionValueIsNotNull(builder3, "builder");
                    if (nestCsjProvider.csjBiddingAllow(mediaExtraInfo2, nestAdData3, builder3, listenerStrategy)) {
                        return;
                    }
                    try {
                        mediaExtraInfo = ads.get(0).getMediaExtraInfo();
                    } catch (Exception unused) {
                    }
                    if (mediaExtraInfo != null) {
                        i = Integer.parseInt(String.valueOf(mediaExtraInfo.get(OapsKey.KEY_PRICE)));
                        try {
                            NestCsjProvider nestCsjProvider2 = NestCsjProvider.this;
                            NestAdData nestAdData4 = nestAdData;
                            EventParams.Builder builder4 = builder;
                            Intrinsics.checkExpressionValueIsNotNull(builder4, "builder");
                            if (nestCsjProvider2.checkAdEcpmDone(i, nestAdData4, builder4, listenerStrategy)) {
                                return;
                            }
                        } catch (Exception unused2) {
                        }
                    } else {
                        i = 0;
                    }
                    int testPriceSwitchEcpm = NestCsjProvider.this.getTestPriceSwitchEcpm(i, nestAdData);
                    WifiLog.d("NestCsjProvider getNativeDrawVideoAd onADLoaded priceSwitch price " + testPriceSwitchEcpm + " code " + nestAdData.getAdCode());
                    NestCsjProvider nestCsjProvider3 = NestCsjProvider.this;
                    NestAdData nestAdData5 = nestAdData;
                    EventParams.Builder builder5 = builder;
                    Intrinsics.checkExpressionValueIsNotNull(builder5, "builder");
                    if (nestCsjProvider3.checkAdPriceSwitch(testPriceSwitchEcpm, nestAdData5, builder5, listenerStrategy)) {
                        return;
                    }
                }
                NestCsjProvider nestCsjProvider4 = NestCsjProvider.this;
                String adCode = nestAdData.getAdCode();
                AdParams adParams2 = nestAdData.getAdParams();
                String imageUrl = null;
                nestCsjProvider4.catchCsjNativeDrawAd(ads, adCode, adParams2 != null ? adParams2.getExt() : null, nestAdData.getAdLevel());
                TTDrawFeedAd tTDrawFeedAd = ads.get(0);
                EventParams.Builder adTitle = builder.setAdTitle(tTDrawFeedAd.getTitle());
                List<TTImage> imageList = tTDrawFeedAd.getImageList();
                if (imageList != null && !imageList.isEmpty()) {
                    z = false;
                }
                if (!z) {
                    List<TTImage> imageList2 = tTDrawFeedAd.getImageList();
                    if (imageList2 == null) {
                        Intrinsics.throwNpe();
                    }
                    TTImage tTImage = imageList2.get(0);
                    if (tTImage != null) {
                        imageUrl = tTImage.getImageUrl();
                    }
                }
                adTitle.setAdImage(imageUrl).setAdDesc(tTDrawFeedAd.getDescription());
                ArrayList arrayList = new ArrayList();
                for (TTDrawFeedAd tTDrawFeedAd2 : ads) {
                    NestAdData nestAdData6 = nestAdData;
                    nestAdData6.setDspName(NestCsjProvider.DSP_NAME);
                    nestAdData6.setAppId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.CSJ)));
                    nestAdData6.setSdkFrom(NestCsjProvider.SDK_FROM);
                    nestAdData6.setAdData(tTDrawFeedAd2);
                    try {
                        if (tTDrawFeedAd2.getComplianceInfo() != null) {
                            ComplianceInfo complianceInfo = tTDrawFeedAd2.getComplianceInfo();
                            Intrinsics.checkExpressionValueIsNotNull(complianceInfo, "ad.complianceInfo");
                            nestAdData6.setAdAppName(complianceInfo.getAppName());
                            ComplianceInfo complianceInfo2 = tTDrawFeedAd2.getComplianceInfo();
                            Intrinsics.checkExpressionValueIsNotNull(complianceInfo2, "ad.complianceInfo");
                            nestAdData6.setAdAppDeveloperName(complianceInfo2.getDeveloperName());
                            ComplianceInfo complianceInfo3 = tTDrawFeedAd2.getComplianceInfo();
                            Intrinsics.checkExpressionValueIsNotNull(complianceInfo3, "ad.complianceInfo");
                            nestAdData6.setAdAppVersion(complianceInfo3.getAppVersion());
                            ComplianceInfo complianceInfo4 = tTDrawFeedAd2.getComplianceInfo();
                            Intrinsics.checkExpressionValueIsNotNull(complianceInfo4, "ad.complianceInfo");
                            nestAdData6.setAdAppPermissionsUrl(complianceInfo4.getPermissionUrl());
                            ComplianceInfo complianceInfo5 = tTDrawFeedAd2.getComplianceInfo();
                            Intrinsics.checkExpressionValueIsNotNull(complianceInfo5, "ad.complianceInfo");
                            nestAdData6.setAdAppPrivacyUrl(complianceInfo5.getPrivacyUrl());
                            ComplianceInfo complianceInfo6 = tTDrawFeedAd2.getComplianceInfo();
                            Intrinsics.checkExpressionValueIsNotNull(complianceInfo6, "ad.complianceInfo");
                            nestAdData6.setAdAppFunctionDescUrl(complianceInfo6.getFunctionDescUrl());
                        }
                    } catch (Throwable unused3) {
                    }
                    nestAdData6.setSensitiveInfo(CsjSensitiveCatcher.INSTANCE.catchCsjNativeDrawAd(tTDrawFeedAd2, nestAdData.getAdLevel()));
                    NestCsjProvider.this.parseExtraInfo(tTDrawFeedAd2.getMediaExtraInfo(), nestAdData6);
                    arrayList.add(nestAdData);
                }
                EventReporter eventReporter3 = EventReporter.INSTANCE;
                NestAdData nestAdData7 = nestAdData;
                EventParams.Builder builder6 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder6, "builder");
                eventReporter3.reportRespDi(nestAdData7, builder6, ads.size());
                IStrategyListener iStrategyListener2 = listenerStrategy;
                if (iStrategyListener2 != null) {
                    iStrategyListener2.onAdLoaded(arrayList);
                }
                NestCsjProvider.this.onNestAdLoad(nestAdData);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.DrawFeedAdListener
            public void onError(int code, String message) {
                EventReporter eventReporter2 = EventReporter.INSTANCE;
                NestAdData nestAdData2 = nestAdData;
                EventParams.Builder builder2 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder2, "builder");
                eventReporter2.reportNoRespDi(nestAdData2, builder2, String.valueOf(code), message);
                WifiLog.d("NestCsjProvider getDrawVideoAd onError code = " + code + " message = " + message);
                IStrategyListener iStrategyListener = listenerStrategy;
                if (iStrategyListener != null) {
                    NestAdData nestAdData3 = nestAdData;
                    if (message == null) {
                        message = "";
                    }
                    iStrategyListener.onAdFailed(nestAdData3, message, code);
                }
                NestCsjProvider.this.onNestAdUnLoad(nestAdData);
            }
        });
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void getNativeFeedAd(final ActivityPacker packer, final NestAdData nestAdData, final IStrategyListener listenerStrategy) {
        String nestType;
        WifiLog.d("NestCsjProvider getNativeFeedAd adLevelName = " + nestAdData.getAdLevelName() + " adCode = " + nestAdData.getAdCode() + " adLevel = " + nestAdData.getAdLevel() + " adType = " + nestAdData.getAdType() + ' ');
        listenerStrategy.onStart(nestAdData);
        EventParams.Builder renderStyle = new EventParams.Builder().setDspName(DSP_NAME).setNestSid(nestAdData.getNestSid()).setMediaId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.CSJ))).setSrcId(String.valueOf(nestAdData.getAdCode())).setRenderStyle(nestAdData.getRenderStyle());
        AdParams adParams = nestAdData.getAdParams();
        if (adParams == null || (nestType = adParams.getNestType()) == null) {
            nestType = "";
        }
        final EventParams.Builder builder = renderStyle.setNestType(nestType).setInventoryId(nestAdData.getInventoryId()).setSdkFrom(SDK_FROM);
        EventReporter eventReporter = EventReporter.INSTANCE;
        Intrinsics.checkExpressionValueIsNotNull(builder, "builder");
        eventReporter.reportReqDi(nestAdData, builder);
        TTAdSdk.getAdManager().createAdNative(packer.getAppContext()).loadFeedAd(createAdSlot(nestAdData).setCodeId(nestAdData.getAdCode()).setSupportDeepLink(true).setImageAcceptedSize(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME).setAdCount(1).build(), new TTAdNative.FeedAdListener() { // from class: com.wifi.csj.ad.NestCsjProvider.getNativeFeedAd.1
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
            public void onError(int code, String message) {
                EventReporter eventReporter2 = EventReporter.INSTANCE;
                NestAdData nestAdData2 = nestAdData;
                EventParams.Builder builder2 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder2, "builder");
                eventReporter2.reportNoRespDi(nestAdData2, builder2, String.valueOf(code), message);
                WifiLog.d("NestCsjProvider getNativeFeedAd onError code = " + code + " message = " + message);
                IStrategyListener iStrategyListener = listenerStrategy;
                if (iStrategyListener != null) {
                    iStrategyListener.onAdFailed(nestAdData, message, code);
                }
                NestCsjProvider.this.onNestAdUnLoad(nestAdData);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
            public void onFeedAdLoad(List<TTFeedAd> ads) {
                List<TTImage> imageList;
                TTImage tTImage;
                int i;
                Map<String, Object> mediaExtraInfo;
                if (ads == null || ads.isEmpty()) {
                    EventReporter eventReporter2 = EventReporter.INSTANCE;
                    NestAdData nestAdData2 = nestAdData;
                    EventParams.Builder builder2 = builder;
                    Intrinsics.checkExpressionValueIsNotNull(builder2, "builder");
                    eventReporter2.reportNoRespDi(nestAdData2, builder2, "30200", "");
                    WifiLog.d("NestCsjProvider onFeedAdLoad ad is null!");
                    IStrategyListener iStrategyListener = listenerStrategy;
                    if (iStrategyListener != null) {
                        iStrategyListener.onAdFailed(nestAdData, "ad is null or empty", -1);
                        return;
                    }
                    return;
                }
                if (!ads.isEmpty()) {
                    NestCsjProvider nestCsjProvider = NestCsjProvider.this;
                    Map<String, Object> mediaExtraInfo2 = ads.get(0).getMediaExtraInfo();
                    NestAdData nestAdData3 = nestAdData;
                    EventParams.Builder builder3 = builder;
                    Intrinsics.checkExpressionValueIsNotNull(builder3, "builder");
                    if (nestCsjProvider.csjBiddingAllow(mediaExtraInfo2, nestAdData3, builder3, listenerStrategy)) {
                        return;
                    }
                    try {
                        mediaExtraInfo = ads.get(0).getMediaExtraInfo();
                    } catch (Exception unused) {
                    }
                    if (mediaExtraInfo != null) {
                        i = Integer.parseInt(String.valueOf(mediaExtraInfo.get(OapsKey.KEY_PRICE)));
                        try {
                            NestCsjProvider nestCsjProvider2 = NestCsjProvider.this;
                            NestAdData nestAdData4 = nestAdData;
                            EventParams.Builder builder4 = builder;
                            Intrinsics.checkExpressionValueIsNotNull(builder4, "builder");
                            if (nestCsjProvider2.checkAdEcpmDone(i, nestAdData4, builder4, listenerStrategy)) {
                                return;
                            }
                        } catch (Exception unused2) {
                        }
                    } else {
                        i = 0;
                    }
                    int testPriceSwitchEcpm = NestCsjProvider.this.getTestPriceSwitchEcpm(i, nestAdData);
                    WifiLog.d("NestCsjProvider getNativeFeedAd onADLoaded priceSwitch price " + testPriceSwitchEcpm + " code " + nestAdData.getAdCode());
                    NestCsjProvider nestCsjProvider3 = NestCsjProvider.this;
                    NestAdData nestAdData5 = nestAdData;
                    EventParams.Builder builder5 = builder;
                    Intrinsics.checkExpressionValueIsNotNull(builder5, "builder");
                    if (nestCsjProvider3.checkAdPriceSwitch(testPriceSwitchEcpm, nestAdData5, builder5, listenerStrategy)) {
                        return;
                    }
                }
                NestCsjProvider nestCsjProvider4 = NestCsjProvider.this;
                Context appContext = packer.getAppContext();
                Intrinsics.checkExpressionValueIsNotNull(appContext, "packer.appContext");
                String adCode = nestAdData.getAdCode();
                AdParams adParams2 = nestAdData.getAdParams();
                nestCsjProvider4.catchCsjExpressNativeAd(appContext, ads, adCode, adParams2 != null ? adParams2.getExt() : null, nestAdData.getAdLevel());
                ArrayList arrayList = new ArrayList();
                for (TTFeedAd tTFeedAd : ads) {
                    NestAdData nestAdData6 = nestAdData;
                    nestAdData6.setDspName(NestCsjProvider.DSP_NAME);
                    nestAdData6.setAppId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.CSJ)));
                    nestAdData6.setSdkFrom(NestCsjProvider.SDK_FROM);
                    nestAdData6.setAdData(tTFeedAd);
                    try {
                        if (tTFeedAd.getComplianceInfo() != null) {
                            ComplianceInfo complianceInfo = tTFeedAd.getComplianceInfo();
                            Intrinsics.checkExpressionValueIsNotNull(complianceInfo, "ad.complianceInfo");
                            nestAdData6.setAdAppName(complianceInfo.getAppName());
                            ComplianceInfo complianceInfo2 = tTFeedAd.getComplianceInfo();
                            Intrinsics.checkExpressionValueIsNotNull(complianceInfo2, "ad.complianceInfo");
                            nestAdData6.setAdAppDeveloperName(complianceInfo2.getDeveloperName());
                            ComplianceInfo complianceInfo3 = tTFeedAd.getComplianceInfo();
                            Intrinsics.checkExpressionValueIsNotNull(complianceInfo3, "ad.complianceInfo");
                            nestAdData6.setAdAppVersion(complianceInfo3.getAppVersion());
                            ComplianceInfo complianceInfo4 = tTFeedAd.getComplianceInfo();
                            Intrinsics.checkExpressionValueIsNotNull(complianceInfo4, "ad.complianceInfo");
                            nestAdData6.setAdAppPermissionsUrl(complianceInfo4.getPermissionUrl());
                            ComplianceInfo complianceInfo5 = tTFeedAd.getComplianceInfo();
                            Intrinsics.checkExpressionValueIsNotNull(complianceInfo5, "ad.complianceInfo");
                            nestAdData6.setAdAppPrivacyUrl(complianceInfo5.getPrivacyUrl());
                            ComplianceInfo complianceInfo6 = tTFeedAd.getComplianceInfo();
                            Intrinsics.checkExpressionValueIsNotNull(complianceInfo6, "ad.complianceInfo");
                            nestAdData6.setAdAppFunctionDescUrl(complianceInfo6.getFunctionDescUrl());
                        }
                    } catch (Throwable unused3) {
                    }
                    nestAdData6.setSensitiveInfo(CsjSensitiveCatcher.INSTANCE.catchCsjExpressNativeAd(tTFeedAd, nestAdData.getAdLevel()));
                    nestAdData6.setDataAdapter(new CsjFeedDataAdapter(tTFeedAd));
                    NestCsjProvider.this.parseExtraInfo(tTFeedAd.getMediaExtraInfo(), nestAdData6);
                    try {
                        int imageMode = tTFeedAd.getImageMode();
                        if (imageMode == 5 || imageMode == 15) {
                            TTImage videoCoverImage = tTFeedAd.getVideoCoverImage();
                            if (videoCoverImage != null) {
                                nestAdData6.setNativeAdImgWidth(videoCoverImage.getWidth());
                                nestAdData6.setNativeAdImgHeight(videoCoverImage.getHeight());
                            }
                        } else {
                            List<TTImage> imageList2 = tTFeedAd.getImageList();
                            if (!(imageList2 == null || imageList2.isEmpty()) && (imageList = tTFeedAd.getImageList()) != null && (tTImage = imageList.get(0)) != null) {
                                nestAdData6.setNativeAdImgWidth(tTImage.getWidth());
                                nestAdData6.setNativeAdImgHeight(tTImage.getHeight());
                            }
                        }
                    } catch (Exception unused4) {
                    }
                    arrayList.add(nestAdData);
                }
                EventReporter eventReporter3 = EventReporter.INSTANCE;
                NestAdData nestAdData7 = nestAdData;
                EventParams.Builder builder6 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder6, "builder");
                eventReporter3.reportRespDi(nestAdData7, builder6, ads.size());
                IStrategyListener iStrategyListener2 = listenerStrategy;
                if (iStrategyListener2 != null) {
                    iStrategyListener2.onAdLoaded(arrayList);
                }
                NestCsjProvider.this.onNestAdLoad(nestAdData);
            }
        });
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider
    public BaseNativeView getNativeView(String adProviderType) {
        WifiLog.d("getDrawVideoAdView adProviderType = " + adProviderType);
        if (Intrinsics.areEqual(SDKAlias.CSJ.getType(), adProviderType)) {
            return new NestCsjNativeView();
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
    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void getSplashAd(ActivityPacker packer, NestAdData nestAdData, IStrategyListener listener) {
        String nestType;
        int i;
        int i2;
        WifiLog.d("splashAd csj getSplashAd");
        EventParams.Builder nestSid = new EventParams.Builder().setDspName(DSP_NAME).setNestSid(nestAdData.getNestSid());
        WifiNestAd wifiNestAd = WifiNestAd.INSTANCE;
        Map<SDKAlias, String> appIds = wifiNestAd.getAppIds();
        SDKAlias sDKAlias = SDKAlias.CSJ;
        EventParams.Builder inventoryId = nestSid.setMediaId(String.valueOf(appIds.get(sDKAlias))).setSrcId(String.valueOf(nestAdData.getAdCode())).setRenderStyle(nestAdData.getRenderStyle()).setInventoryId(nestAdData.getInventoryId());
        AdParams adParams = nestAdData.getAdParams();
        if (adParams == null || (nestType = adParams.getNestType()) == null) {
            nestType = "";
        }
        EventParams.Builder builder = inventoryId.setNestType(nestType).setSdkFrom(SDK_FROM);
        EventReporter eventReporter = EventReporter.INSTANCE;
        Intrinsics.checkExpressionValueIsNotNull(builder, "builder");
        eventReporter.reportReqDi(nestAdData, builder);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = sDKAlias.getType();
        if (wifiNestAd.getWmPoint() == null) {
            Object systemService = packer.getAppContext().getSystemService("window");
            if (systemService == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.view.WindowManager");
            }
            wifiNestAd.setWmPoint(new Point());
            ((WindowManager) systemService).getDefaultDisplay().getRealSize(wifiNestAd.getWmPoint());
            WifiLog.d("splashAd SystemService csj create wmPoint");
        }
        if (wifiNestAd.getWmPoint() != null) {
            Point wmPoint = wifiNestAd.getWmPoint();
            if (wmPoint == null) {
                Intrinsics.throwNpe();
            }
            i = wmPoint.y;
            Point wmPoint2 = wifiNestAd.getWmPoint();
            if (wmPoint2 == null) {
                Intrinsics.throwNpe();
            }
            i2 = wmPoint2.x;
            WifiLog.d("splashAd SystemService csj allHeight " + i + " px " + i2);
        } else {
            i = TECameraUtils.CAPTURE_NORMAL;
            i2 = FunDC.ID_AUTH_1080;
        }
        ScreenUtil screenUtil = ScreenUtil.INSTANCE;
        Context appContext = packer.getAppContext();
        Intrinsics.checkExpressionValueIsNotNull(appContext, "packer.appContext");
        int iDp2px = screenUtil.dp2px(appContext, 145.0f);
        WifiLog.d("splashAdcsj allHeight " + i + " imgHeight " + iDp2px + " adHeight " + (i - iDp2px));
        AdSlot.Builder expressViewAcceptedSize = createAdSlot(nestAdData).setCodeId(nestAdData.getAdCode()).setSupportDeepLink(true).setExpressViewAcceptedSize(360.0f, 655.0f);
        Context appContext2 = packer.getAppContext();
        Intrinsics.checkExpressionValueIsNotNull(appContext2, "packer.appContext");
        TTAdSdk.getAdManager().createAdNative(packer.getAppContext()).loadSplashAd(expressViewAcceptedSize.setImageAcceptedSize(i2, screenUtil.dp2px(appContext2, 655.0f)).build(), new C13661(nestAdData, builder, listener, objectRef), 2500);
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void getTemplateFeedAd(ActivityPacker packer, NestAdData nestAdData, IStrategyListener listenerStrategy) {
        String nestType;
        float csjWidth;
        float csjHeight;
        AdSize adSize;
        WifiLog.d("NestCsjProvider getTemplateFeedAd adLevelName = " + nestAdData.getAdLevelName() + " adCode = " + nestAdData.getAdCode() + " adLevel = " + nestAdData.getAdLevel() + " adType = " + nestAdData.getAdType() + ' ');
        listenerStrategy.onStart(nestAdData);
        EventParams.Builder renderStyle = new EventParams.Builder().setDspName(DSP_NAME).setNestSid(nestAdData.getNestSid()).setMediaId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.CSJ))).setSrcId(String.valueOf(nestAdData.getAdCode())).setRenderStyle(nestAdData.getRenderStyle());
        AdParams adParams = nestAdData.getAdParams();
        if (adParams == null || (nestType = adParams.getNestType()) == null) {
            nestType = "";
        }
        EventParams.Builder builder = renderStyle.setNestType(nestType).setInventoryId(nestAdData.getInventoryId()).setSdkFrom(SDK_FROM);
        EventReporter eventReporter = EventReporter.INSTANCE;
        Intrinsics.checkExpressionValueIsNotNull(builder, "builder");
        eventReporter.reportReqDi(nestAdData, builder);
        AdParams adParams2 = nestAdData.getAdParams();
        if (adParams2 == null || (adSize = adParams2.getAdSize()) == null) {
            csjWidth = 640.0f;
            csjHeight = 0.0f;
        } else {
            csjWidth = adSize.getCsjWidth();
            csjHeight = adSize.getCsjHeight();
        }
        TTAdSdk.getAdManager().createAdNative(packer.getAppContext()).loadNativeExpressAd(createAdSlot(nestAdData).setCodeId(nestAdData.getAdCode()).setSupportDeepLink(true).setImageAcceptedSize(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME).setAdCount(1).setExpressViewAcceptedSize(csjWidth, csjHeight).build(), new AnonymousClass2(nestAdData, builder, listenerStrategy, packer));
    }

    public final void initRewardListener(TTRewardVideoAd ad, final NestAdData nestAdData, final IStrategyListener listenerStrategy) {
        ad.setRewardAdInteractionListener(new TTRewardVideoAd.RewardAdInteractionListener() { // from class: com.wifi.csj.ad.NestCsjProvider.initRewardListener.1
            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public void onAdClose() {
                WifiLog.d("NestCsjProvider requestRewardAd onAdClose");
                IStrategyListener iStrategyListener = listenerStrategy;
                if (iStrategyListener != null) {
                    iStrategyListener.onAdClose(nestAdData, SDKAlias.CSJ.getType());
                }
                InnerRewardShowListener rewardShowListener = nestAdData.getRewardShowListener();
                if (rewardShowListener != null) {
                    rewardShowListener.onAdClose(SDKAlias.CSJ.getType(), nestAdData);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public void onAdShow() {
                WifiLog.d("NestCsjProvider requestRewardAd onAdShow");
                IStrategyListener iStrategyListener = listenerStrategy;
                if (iStrategyListener != null) {
                    iStrategyListener.onAdExpose(nestAdData, SDKAlias.CSJ.getType());
                }
                InnerRewardShowListener rewardShowListener = nestAdData.getRewardShowListener();
                if (rewardShowListener != null) {
                    rewardShowListener.onAdExpose(SDKAlias.CSJ.getType(), nestAdData);
                }
                NestCsjNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_SHOW);
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public void onAdVideoBarClick() {
                WifiLog.d("NestCsjProvider requestRewardAd onAdVideoBarClick");
                IStrategyListener iStrategyListener = listenerStrategy;
                if (iStrategyListener != null) {
                    iStrategyListener.onAdClicked(nestAdData, SDKAlias.CSJ.getType());
                }
                InnerRewardShowListener rewardShowListener = nestAdData.getRewardShowListener();
                if (rewardShowListener != null) {
                    rewardShowListener.onAdClicked(SDKAlias.CSJ.getType(), nestAdData);
                }
                NestCsjNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_CLICK);
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public void onRewardArrived(boolean p0, int p1, Bundle p2) {
                WifiLog.d("NestCsjProvider onRewardArrived p0 " + p0 + " p1 " + p1 + " p2 " + p2);
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public void onRewardVerify(boolean rewardVerify, int rewardAmount, String rewardName, int p3, String p4) {
                WifiLog.d("NestCsjProvider requestRewardAd onRewardVerify");
                IStrategyListener iStrategyListener = listenerStrategy;
                if (iStrategyListener != null) {
                    iStrategyListener.onAdRewardVerify(nestAdData, SDKAlias.CSJ.getType());
                }
                InnerRewardShowListener rewardShowListener = nestAdData.getRewardShowListener();
                if (rewardShowListener != null) {
                    rewardShowListener.onAdRewardVerify(SDKAlias.CSJ.getType(), nestAdData);
                }
                NestCsjNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_REWARDARRIVED);
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public void onSkippedVideo() {
                WifiLog.d("NestCsjProvider requestRewardAd onSkippedVideo");
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public void onVideoComplete() {
                WifiLog.d("NestCsjProvider requestRewardAd onVideoComplete");
                IStrategyListener iStrategyListener = listenerStrategy;
                if (iStrategyListener != null) {
                    iStrategyListener.onAdVideoComplete(nestAdData);
                }
                InnerRewardShowListener rewardShowListener = nestAdData.getRewardShowListener();
                if (rewardShowListener != null) {
                    rewardShowListener.onVideoComplete(SDKAlias.CSJ.getType(), nestAdData);
                }
                NestCsjNativeView.Companion companion = NestCsjNativeView.INSTANCE;
                companion.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_VIDEOE);
                companion.onEvent(nestAdData, WifiNestConst.EventKey.NEST_SDK_ENDPLAY_SHOW);
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public void onVideoError() {
                WifiLog.d("NestCsjProvider requestRewardAd onVideoError");
                NestCsjNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_VIDEOT);
            }
        });
        ad.setDownloadListener(new TTAppDownloadListener() { // from class: com.wifi.csj.ad.NestCsjProvider.initRewardListener.2
            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadActive(long totalBytes, long currBytes, String fileName, String appName) {
                WifiLog.d("NestCsjProvider requestRewardAd onDownloadActive");
                if (NestCsjProvider.this.getMHasShowDownloadActive()) {
                    return;
                }
                NestCsjProvider.this.setMHasShowDownloadActive(true);
                nestAdData.setDownloadStatus(1);
                WifiLog.d("NestCsjNativeView setDownloadListener onDownloadStart mHasShowDownloadActiveNative = " + NestCsjProvider.this.getMHasShowDownloadActive());
                NestCsjNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_DOWNLOADING);
                InnerRewardShowListener rewardShowListener = nestAdData.getRewardShowListener();
                if (rewardShowListener != null) {
                    rewardShowListener.onDownloadStart(SDKAlias.CSJ.getType(), nestAdData);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFailed(long totalBytes, long currBytes, String fileName, String appName) {
                WifiLog.d("NestCsjProvider requestRewardAd onDownloadFailed");
                nestAdData.setDownloadStatus(6);
                NestCsjNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_NODOWNLOAD);
                InnerRewardShowListener rewardShowListener = nestAdData.getRewardShowListener();
                if (rewardShowListener != null) {
                    rewardShowListener.onDownloadStart(SDKAlias.CSJ.getType(), nestAdData);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFinished(long totalBytes, String fileName, String appName) {
                WifiLog.d("NestCsjProvider requestRewardAd onDownloadFinished");
                nestAdData.setDownloadStatus(4);
                NestCsjNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_DOWNLOADED);
                InnerRewardShowListener rewardShowListener = nestAdData.getRewardShowListener();
                if (rewardShowListener != null) {
                    rewardShowListener.onDownloadComplete(SDKAlias.CSJ.getType(), nestAdData);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadPaused(long totalBytes, long currBytes, String fileName, String appName) {
                WifiLog.d("NestCsjProvider requestRewardAd onDownloadPaused");
                nestAdData.setDownloadStatus(2);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onIdle() {
                WifiLog.d("NestCsjProvider requestRewardAd onIdle");
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onInstalled(String fileName, String appName) {
                WifiLog.d("NestCsjProvider requestRewardAd onInstalled");
                nestAdData.setDownloadStatus(5);
                NestCsjNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_INSTALLED);
                InnerRewardShowListener rewardShowListener = nestAdData.getRewardShowListener();
                if (rewardShowListener != null) {
                    rewardShowListener.onDownloadInstalled(SDKAlias.CSJ.getType(), nestAdData);
                }
            }
        });
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public boolean interstitialAdIsBelongTheProvider(NestAdData adObject) {
        return adObject.getAdData() instanceof TTFullScreenVideoAd;
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public boolean nativeAdIsBelongTheProvider(Object adObject) {
        return adObject instanceof TTFeedAd;
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
    public void requestInterAd(Activity activity, String adProviderType, String alias, InterListener listener) {
        callbackInterStartRequest(adProviderType, listener);
        destroyInterAd();
        new AdSlot.Builder().setCodeId(NestCsjManager.INSTANCE.getIdMapCsj().get(alias)).setSupportDeepLink(true).setImageAcceptedSize(600, 600).build();
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void requestRewardAd(ActivityPacker packer, final NestAdData nestAdData, final IStrategyListener listenerStrategy) {
        String nestType;
        WifiLog.d("NestCsjProvider requestRewardAd adLevelName = " + nestAdData.getAdLevelName() + " adCode = " + nestAdData.getAdCode() + " adLevel = " + nestAdData.getAdLevel() + " adType = " + nestAdData.getAdType() + ' ');
        listenerStrategy.onStart(nestAdData);
        EventParams.Builder renderStyle = new EventParams.Builder().setDspName(DSP_NAME).setNestSid(nestAdData.getNestSid()).setMediaId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.CSJ))).setSrcId(String.valueOf(nestAdData.getAdCode())).setRenderStyle(nestAdData.getRenderStyle());
        AdParams adParams = nestAdData.getAdParams();
        if (adParams == null || (nestType = adParams.getNestType()) == null) {
            nestType = "";
        }
        final EventParams.Builder builder = renderStyle.setNestType(nestType).setInventoryId(nestAdData.getInventoryId()).setSdkFrom(SDK_FROM);
        EventReporter eventReporter = EventReporter.INSTANCE;
        Intrinsics.checkExpressionValueIsNotNull(builder, "builder");
        eventReporter.reportReqDi(nestAdData, builder);
        TTAdSdk.getAdManager().createAdNative(packer.getAppContext()).loadRewardVideoAd(createAdSlot(nestAdData).setCodeId(String.valueOf(nestAdData.getAdCode())).setSupportDeepLink(true).setUserID("").setOrientation(1).build(), new TTAdNative.RewardVideoAdListener() { // from class: com.wifi.csj.ad.NestCsjProvider.requestRewardAd.1
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
            public void onError(int code, String message) {
                EventReporter eventReporter2 = EventReporter.INSTANCE;
                NestAdData nestAdData2 = nestAdData;
                EventParams.Builder builder2 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder2, "builder");
                eventReporter2.reportNoRespDi(nestAdData2, builder2, String.valueOf(code), message);
                WifiLog.d("NestCsjProvider requestRewardAd onError code = " + code + " message = " + message);
                IStrategyListener iStrategyListener = listenerStrategy;
                if (iStrategyListener != null) {
                    iStrategyListener.onAdFailed(nestAdData, message, code);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
            public void onRewardVideoAdLoad(TTRewardVideoAd ad) {
                NestCsjProvider nestCsjProvider = NestCsjProvider.this;
                Map<String, Object> mediaExtraInfo = ad.getMediaExtraInfo();
                NestAdData nestAdData2 = nestAdData;
                EventParams.Builder builder2 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder2, "builder");
                if (nestCsjProvider.csjBiddingAllow(mediaExtraInfo, nestAdData2, builder2, listenerStrategy)) {
                    return;
                }
                int i = 0;
                try {
                    Map<String, Object> mediaExtraInfo2 = ad.getMediaExtraInfo();
                    if (mediaExtraInfo2 != null) {
                        i = Integer.parseInt(String.valueOf(mediaExtraInfo2.get(OapsKey.KEY_PRICE)));
                        NestCsjProvider nestCsjProvider2 = NestCsjProvider.this;
                        NestAdData nestAdData3 = nestAdData;
                        EventParams.Builder builder3 = builder;
                        Intrinsics.checkExpressionValueIsNotNull(builder3, "builder");
                        if (nestCsjProvider2.checkAdEcpmDone(i, nestAdData3, builder3, listenerStrategy)) {
                            return;
                        }
                    }
                } catch (Exception unused) {
                }
                int testPriceSwitchEcpm = NestCsjProvider.this.getTestPriceSwitchEcpm(i, nestAdData);
                WifiLog.d("NestCsjProvider requestRewardAd onADLoaded priceSwitch price " + testPriceSwitchEcpm + " code " + nestAdData.getAdCode());
                NestCsjProvider nestCsjProvider3 = NestCsjProvider.this;
                NestAdData nestAdData4 = nestAdData;
                EventParams.Builder builder4 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder4, "builder");
                if (nestCsjProvider3.checkAdPriceSwitch(testPriceSwitchEcpm, nestAdData4, builder4, listenerStrategy)) {
                    return;
                }
                SensitiveInfo sensitiveInfoCatchCsjRewardAd = CsjSensitiveCatcher.INSTANCE.catchCsjRewardAd(ad);
                NestCsjProvider nestCsjProvider4 = NestCsjProvider.this;
                String adCode = nestAdData.getAdCode();
                AdParams adParams2 = nestAdData.getAdParams();
                nestCsjProvider4.catchCsjRewardAd(sensitiveInfoCatchCsjRewardAd, adCode, adParams2 != null ? adParams2.getExt() : null);
                NestCsjProvider.this.initRewardListener(ad, nestAdData, listenerStrategy);
                ArrayList arrayList = new ArrayList();
                NestAdData nestAdData5 = nestAdData;
                nestAdData5.setDspName(NestCsjProvider.DSP_NAME);
                nestAdData5.setAppId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.CSJ)));
                nestAdData5.setSdkFrom(NestCsjProvider.SDK_FROM);
                nestAdData5.setAdData(ad);
                nestAdData5.setSensitiveInfo(sensitiveInfoCatchCsjRewardAd);
                NestCsjProvider.this.parseExtraInfo(ad.getMediaExtraInfo(), nestAdData5);
                arrayList.add(nestAdData);
                EventReporter eventReporter2 = EventReporter.INSTANCE;
                NestAdData nestAdData6 = nestAdData;
                EventParams.Builder builder5 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder5, "builder");
                eventReporter2.reportRespDi(nestAdData6, builder5, 1);
                IStrategyListener iStrategyListener = listenerStrategy;
                if (iStrategyListener != null) {
                    iStrategyListener.onAdLoaded(arrayList);
                }
                NestCsjProvider.this.onNestAdLoad(nestAdData);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
            public void onRewardVideoCached() {
                WifiLog.d("NestCsjProvider requestRewardAd onVideoCached 1");
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
            public void onRewardVideoCached(TTRewardVideoAd p0) {
                WifiLog.d("NestCsjProvider requestRewardAd onVideoCached 2");
                listenerStrategy.onAdVideoCached(nestAdData);
            }
        });
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void resumeNativeAd(Object adObject) {
        boolean z = adObject instanceof TTFeedAd;
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public boolean rewardAdIsBelongTheProvider(NestAdData adObject) {
        return adObject.getAdData() instanceof TTRewardVideoAd;
    }

    public final void setMHasPopShowDownloadActive(boolean z) {
        this.mHasPopShowDownloadActive = z;
    }

    public final void setMHasShowDownloadActive(boolean z) {
        this.mHasShowDownloadActive = z;
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void showBannerAd(Activity activity, String adProviderType, String alias, ViewGroup container, BannerListener listener) {
        callbackBannerStartRequest(adProviderType, listener);
        destroyBannerAd();
        new AdSlot.Builder().setCodeId(NestCsjManager.INSTANCE.getIdMapCsj().get(alias)).setSupportDeepLink(true).setImageAcceptedSize(600, 257).build();
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void showInterstitialAd(Activity activity, final NestAdData nestAdData, final PopShowListener showListener) {
        Object adData = nestAdData.getAdData();
        if (adData == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.bytedance.sdk.openadsdk.TTFullScreenVideoAd");
        }
        TTFullScreenVideoAd tTFullScreenVideoAd = (TTFullScreenVideoAd) adData;
        NestCsjNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_TOSHOW);
        tTFullScreenVideoAd.setFullScreenVideoAdInteractionListener(new TTFullScreenVideoAd.FullScreenVideoAdInteractionListener() { // from class: com.wifi.csj.ad.NestCsjProvider.showInterstitialAd.1
            @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
            public void onAdClose() {
                WifiLog.d("NestCsjProvider onAdClose");
                PopShowListener popShowListener = showListener;
                if (popShowListener != null) {
                    popShowListener.onAdClose(SDKAlias.CSJ.getType(), nestAdData);
                }
                NestCsjNativeView.INSTANCE.onEvent(nestAdData, "nest_sdk_cancle_click");
            }

            @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
            public void onAdShow() {
                WifiLog.d("NestCsjProvider onAdShow");
                PopShowListener popShowListener = showListener;
                if (popShowListener != null) {
                    popShowListener.onAdExpose(SDKAlias.CSJ.getType(), nestAdData);
                }
                NestCsjNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_SHOW);
            }

            @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
            public void onAdVideoBarClick() {
                WifiLog.d("NestCsjProvider onAdVideoBarClick");
                PopShowListener popShowListener = showListener;
                if (popShowListener != null) {
                    popShowListener.onAdClicked(SDKAlias.CSJ.getType(), nestAdData);
                }
                NestCsjNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_CLICK);
            }

            @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
            public void onSkippedVideo() {
                WifiLog.d("NestCsjProvider onSkippedVideo");
                PopShowListener popShowListener = showListener;
                if (popShowListener != null) {
                    popShowListener.onAdSkipClick(SDKAlias.CSJ.getType(), nestAdData);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
            public void onVideoComplete() {
                WifiLog.d("NestCsjProvider onVideoComplete");
                PopShowListener popShowListener = showListener;
                if (popShowListener != null) {
                    popShowListener.onVideoComplete(SDKAlias.CSJ.getType(), nestAdData);
                }
                NestCsjNativeView.Companion companion = NestCsjNativeView.INSTANCE;
                companion.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_VIDEOE);
                companion.onEvent(nestAdData, WifiNestConst.EventKey.NEST_SDK_ENDPLAY_SHOW);
            }
        });
        tTFullScreenVideoAd.setDownloadListener(new TTAppDownloadListener() { // from class: com.wifi.csj.ad.NestCsjProvider.showInterstitialAd.2
            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadActive(long p0, long p1, String p2, String p3) {
                if (NestCsjProvider.this.getMHasPopShowDownloadActive()) {
                    return;
                }
                NestCsjProvider.this.setMHasPopShowDownloadActive(true);
                nestAdData.setDownloadStatus(1);
                WifiLog.d("NestCsjNativeView setDownloadListener onDownloadStart mHasPopShowDownloadActive = " + NestCsjProvider.this.getMHasPopShowDownloadActive());
                NestCsjNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_DOWNLOADING);
                PopShowListener popShowListener = showListener;
                if (popShowListener != null) {
                    popShowListener.onDownloadStart(SDKAlias.CSJ.getType(), nestAdData);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFailed(long p0, long p1, String p2, String p3) {
                nestAdData.setDownloadStatus(6);
                NestCsjNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_NODOWNLOAD);
                PopShowListener popShowListener = showListener;
                if (popShowListener != null) {
                    popShowListener.onDownloadFailed(SDKAlias.CSJ.getType(), nestAdData);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFinished(long p0, String p1, String p2) {
                nestAdData.setDownloadStatus(4);
                NestCsjNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_DOWNLOADED);
                PopShowListener popShowListener = showListener;
                if (popShowListener != null) {
                    popShowListener.onDownloadComplete(SDKAlias.CSJ.getType(), nestAdData);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadPaused(long p0, long p1, String p2, String p3) {
                nestAdData.setDownloadStatus(2);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onInstalled(String p0, String p1) {
                nestAdData.setDownloadStatus(5);
                NestCsjNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_INSTALLED);
                PopShowListener popShowListener = showListener;
                if (popShowListener != null) {
                    popShowListener.onDownloadInstalled(SDKAlias.CSJ.getType(), nestAdData);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onIdle() {
            }
        });
        tTFullScreenVideoAd.showFullScreenVideoAd(activity);
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void showRewardAd(Activity activity, NestAdData nestAdData, InnerRewardShowListener showListener) {
        Object adData = nestAdData.getAdData();
        if (adData == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.bytedance.sdk.openadsdk.TTRewardVideoAd");
        }
        nestAdData.setRewardShowListener(showListener);
        NestCsjNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_TOSHOW);
        ((TTRewardVideoAd) adData).showRewardVideoAd(activity);
        NestAdData.AdRenderListener adRenderListener = nestAdData.getAdRenderListener();
        if (adRenderListener != null) {
            adRenderListener.onRenderSuccess(SDKAlias.CSJ.getType(), nestAdData);
        }
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void showSplashAd(Activity activity, final NestAdData adData, final ViewGroup container, SplashShowListener splashShowListener) {
        NestCsjNativeView.INSTANCE.onEvent(adData, WifiNestConst.EventKey.UNIFIEDAD_SDK_TOSHOW);
        if (activity.isFinishing()) {
            WifiLog.d("splashAd cjs showSplashAd activity is error");
        } else {
            WifiLog.d("splashAd csj showSplashAd");
            activity.runOnUiThread(new Runnable() { // from class: com.wifi.csj.ad.NestCsjProvider.showSplashAd.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        if (adData.getSplashView() != null) {
                            View splashView = adData.getSplashView();
                            if (splashView == null) {
                                Intrinsics.throwNpe();
                            }
                            if (splashView.getParent() instanceof ViewGroup) {
                                ViewParent parent = splashView.getParent();
                                if (parent == null) {
                                    throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
                                }
                                ((ViewGroup) parent).removeView(splashView);
                            }
                        }
                        container.addView(adData.getSplashView());
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public boolean splashAdIsBelongTheProvider(NestAdData adObject) {
        return adObject.getAdData() instanceof CSJSplashAd;
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void destroyInterAd() {
    }

    /* JADX INFO: renamed from: com.wifi.csj.ad.NestCsjProvider$getSplashAd$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\f"}, d2 = {"com/wifi/csj/ad/NestCsjProvider$getSplashAd$1", "Lcom/bytedance/sdk/openadsdk/TTAdNative$CSJSplashAdListener;", "onSplashLoadFail", "", com.kuaishou.weapon.p0.bq.g, "Lcom/bytedance/sdk/openadsdk/CSJAdError;", "onSplashLoadSuccess", "splashAd", "Lcom/bytedance/sdk/openadsdk/CSJSplashAd;", "onSplashRenderFail", "p1", "onSplashRenderSuccess", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
    public static final class C13661 implements TTAdNative.CSJSplashAdListener {
        final /* synthetic */ Ref.ObjectRef $adProviderType;
        final /* synthetic */ EventParams.Builder $builder;
        final /* synthetic */ IStrategyListener $listener;
        final /* synthetic */ NestAdData $nestAdData;

        public C13661(NestAdData nestAdData, EventParams.Builder builder, IStrategyListener iStrategyListener, Ref.ObjectRef objectRef) {
            this.$nestAdData = nestAdData;
            this.$builder = builder;
            this.$listener = iStrategyListener;
            this.$adProviderType = objectRef;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
        public void onSplashLoadFail(CSJAdError p0) {
            int code;
            String msg;
            if (p0 != null) {
                msg = p0.getMsg();
                Intrinsics.checkExpressionValueIsNotNull(msg, "p0.msg");
                code = p0.getCode();
            } else {
                code = 0;
                msg = "";
            }
            EventReporter eventReporter = EventReporter.INSTANCE;
            NestAdData nestAdData = this.$nestAdData;
            EventParams.Builder builder = this.$builder;
            Intrinsics.checkExpressionValueIsNotNull(builder, "builder");
            eventReporter.reportNoRespDi(nestAdData, builder, String.valueOf(code), msg);
            IStrategyListener iStrategyListener = this.$listener;
            if (iStrategyListener != null) {
                iStrategyListener.onAdFailed(this.$nestAdData, msg + "", code);
            }
            NestCsjProvider.this.onNestAdUnLoad(this.$nestAdData);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
        public void onSplashLoadSuccess(CSJSplashAd splashAd) {
            if (splashAd == null) {
                EventReporter eventReporter = EventReporter.INSTANCE;
                NestAdData nestAdData = this.$nestAdData;
                EventParams.Builder builder = this.$builder;
                Intrinsics.checkExpressionValueIsNotNull(builder, "builder");
                eventReporter.reportNoRespDi(nestAdData, builder, "请求成功，但是返回的广告为null", "");
                IStrategyListener iStrategyListener = this.$listener;
                if (iStrategyListener != null) {
                    iStrategyListener.onAdFailed(this.$nestAdData, "请求成功，但是返回的广告为null", 10001);
                }
                NestCsjProvider.this.onNestAdUnLoad(this.$nestAdData);
                return;
            }
            NestCsjProvider nestCsjProvider = NestCsjProvider.this;
            Map<String, Object> mediaExtraInfo = splashAd.getMediaExtraInfo();
            NestAdData nestAdData2 = this.$nestAdData;
            EventParams.Builder builder2 = this.$builder;
            Intrinsics.checkExpressionValueIsNotNull(builder2, "builder");
            if (nestCsjProvider.csjBiddingAllow(mediaExtraInfo, nestAdData2, builder2, this.$listener)) {
                return;
            }
            int i = 0;
            try {
                Map<String, Object> mediaExtraInfo2 = splashAd.getMediaExtraInfo();
                if (mediaExtraInfo2 != null) {
                    i = Integer.parseInt(String.valueOf(mediaExtraInfo2.get(OapsKey.KEY_PRICE)));
                    NestCsjProvider nestCsjProvider2 = NestCsjProvider.this;
                    NestAdData nestAdData3 = this.$nestAdData;
                    EventParams.Builder builder3 = this.$builder;
                    Intrinsics.checkExpressionValueIsNotNull(builder3, "builder");
                    if (nestCsjProvider2.checkAdEcpmDone(i, nestAdData3, builder3, this.$listener)) {
                        return;
                    }
                }
            } catch (Exception unused) {
            }
            int testPriceSwitchEcpm = NestCsjProvider.this.getTestPriceSwitchEcpm(i, this.$nestAdData);
            WifiLog.d("NestCsjProvider onSplashAdLoad onADLoaded priceSwitch price " + testPriceSwitchEcpm + " code " + this.$nestAdData.getAdCode());
            NestCsjProvider nestCsjProvider3 = NestCsjProvider.this;
            NestAdData nestAdData4 = this.$nestAdData;
            EventParams.Builder builder4 = this.$builder;
            Intrinsics.checkExpressionValueIsNotNull(builder4, "builder");
            if (nestCsjProvider3.checkAdPriceSwitch(testPriceSwitchEcpm, nestAdData4, builder4, this.$listener)) {
                return;
            }
            NestCsjProvider nestCsjProvider4 = NestCsjProvider.this;
            String adCode = this.$nestAdData.getAdCode();
            AdParams adParams = this.$nestAdData.getAdParams();
            SensitiveInfo sensitiveInfoCatchCSJSplashInfo = nestCsjProvider4.catchCSJSplashInfo(splashAd, adCode, adParams != null ? adParams.getExt() : null, this.$nestAdData.getAdLevel());
            ArrayList arrayList = new ArrayList();
            NestAdData nestAdData5 = this.$nestAdData;
            nestAdData5.setDspName(NestCsjProvider.DSP_NAME);
            nestAdData5.setAppId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.CSJ)));
            nestAdData5.setSdkFrom(NestCsjProvider.SDK_FROM);
            nestAdData5.setAdData(splashAd);
            nestAdData5.setSplashView(splashAd.getSplashView());
            nestAdData5.setSensitiveInfo(sensitiveInfoCatchCSJSplashInfo);
            NestCsjProvider.this.parseExtraInfo(splashAd.getMediaExtraInfo(), nestAdData5);
            arrayList.add(this.$nestAdData);
            EventReporter eventReporter2 = EventReporter.INSTANCE;
            NestAdData nestAdData6 = this.$nestAdData;
            EventParams.Builder builder5 = this.$builder;
            Intrinsics.checkExpressionValueIsNotNull(builder5, "builder");
            eventReporter2.reportRespDi(nestAdData6, builder5, 1);
            IStrategyListener iStrategyListener2 = this.$listener;
            if (iStrategyListener2 != null) {
                iStrategyListener2.onAdLoaded(arrayList);
            }
            NestCsjProvider.this.onNestAdLoad(this.$nestAdData);
            splashAd.setSplashAdListener(new CSJSplashAd.SplashAdListener() { // from class: com.wifi.csj.ad.NestCsjProvider$getSplashAd$1$onSplashLoadSuccess$2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
                public void onSplashAdClick(CSJSplashAd p0) {
                    NestCsjNativeView.INSTANCE.onEvent(this.this$0.$nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_CLICK);
                    SplashShowListener splashShowListener = this.this$0.$nestAdData.getSplashShowListener();
                    if (splashShowListener != null) {
                        NestCsjProvider.C13661 c13661 = this.this$0;
                        splashShowListener.onAdClicked((String) c13661.$adProviderType.element, c13661.$nestAdData);
                    }
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
                public void onSplashAdClose(CSJSplashAd p0, int p1) {
                    WifiLog.d("splashAd csj onAdSkip");
                    this.this$0.$nestAdData.getCsjSplashSkipEd().set(true);
                    NestCsjNativeView.INSTANCE.onEvent(this.this$0.$nestAdData, "nest_sdk_cancle_click");
                    SplashShowListener splashShowListener = this.this$0.$nestAdData.getSplashShowListener();
                    if (splashShowListener != null) {
                        NestCsjProvider.C13661 c13661 = this.this$0;
                        splashShowListener.onAdSkip((String) c13661.$adProviderType.element, c13661.$nestAdData);
                    }
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
                public void onSplashAdShow(CSJSplashAd p0) {
                    NestCsjNativeView.INSTANCE.onEvent(this.this$0.$nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_SHOW);
                    SplashShowListener splashShowListener = this.this$0.$nestAdData.getSplashShowListener();
                    if (splashShowListener != null) {
                        NestCsjProvider.C13661 c13661 = this.this$0;
                        splashShowListener.onAdExpose((String) c13661.$adProviderType.element, c13661.$nestAdData);
                    }
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
        public void onSplashRenderFail(CSJSplashAd p0, CSJAdError p1) {
            NestCsjNativeView.INSTANCE.onEvent(this.$nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_SHOW_FAIL, p1 != null ? Integer.valueOf(p1.getCode()) : null, p1 != null ? p1.getMsg() : null);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
        public void onSplashRenderSuccess(CSJSplashAd p0) {
        }
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void pauseAd(NestAdData nestAdData) {
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void resumeAd(NestAdData nestAdData) {
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
}
