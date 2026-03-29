package com.wifi.lxad.ad;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.wifi.ad.core.SDKAlias;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.compliance.RequestSDKConfig;
import com.wifi.ad.core.config.AdParams;
import com.wifi.ad.core.config.EventParams;
import com.wifi.ad.core.custom.flow.BaseNativeView;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.entity.SensitiveInfo;
import com.wifi.ad.core.helper.ActivityPacker;
import com.wifi.ad.core.listener.PopShowListener;
import com.wifi.ad.core.listener.SplashShowListener;
import com.wifi.ad.core.p001const.WifiNestConst;
import com.wifi.ad.core.provider.BaseAdProvider;
import com.wifi.ad.core.reporter.EventReporter;
import com.wifi.ad.core.strategy.IStrategyListener;
import com.wifi.ad.core.strategy.LoadScene;
import com.wifi.ad.core.utils.WifiLog;
import com.wifi.adsdk.LxAdManager;
import com.wifi.adsdk.listener.LxAdNativeFeedListener;
import com.wifi.adsdk.listener.LxAdPopListener;
import com.wifi.adsdk.listener.LxAdSplashListener;
import com.wifi.adsdk.listener.LxAdTempFeedListener;
import com.wifi.adsdk.listener.LxPopShowListener;
import com.wifi.adsdk.listener.LxSplashShowListener;
import com.wifi.adsdk.listener.LxTempFeedShowListener;
import com.wifi.adsdk.nativefeed.LxNativeFeedAd;
import com.wifi.adsdk.params.LxAdReqParams;
import com.wifi.adsdk.pop.LxPopAd;
import com.wifi.adsdk.splash.LxSplashAd;
import com.wifi.adsdk.tempfeed.LxTempFeedAd;
import com.wifi.lxad.ad.NestLxAdNativeView;
import com.wifi.lxad.ad.NestLxAdProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 52\u00020\u0001:\u00015B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J(\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J \u0010\u0014\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J(\u0010\u0015\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J \u0010\u0016\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u0006H\u0016J \u0010\u001a\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J \u0010\u001b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u001c\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\nH\u0016J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\nH\u0016J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\nH\u0016J2\u0010 \u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010\u00062\u0014\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010%H\u0002J\u0010\u0010&\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\nH\u0016J\u0010\u0010'\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\"\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020*2\u0006\u0010\u000f\u001a\u00020\n2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J(\u0010-\u001a\u00020\u00042\u0006\u0010)\u001a\u00020*2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0016J\u0010\u00102\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u00103\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\nH\u0016J\u0010\u00104\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\nH\u0016¨\u00066"}, d2 = {"Lcom/wifi/lxad/ad/NestLxAdProvider;", "Lcom/wifi/ad/core/provider/BaseAdProvider;", "()V", "destroyAd", "", "requestId", "", "feedAdIsBelongTheProvider", "", "adObject", "Lcom/wifi/ad/core/data/NestAdData;", "feedNativeAdIsBelongTheProvider", "getCorrectAd", "packer", "Lcom/wifi/ad/core/helper/ActivityPacker;", "nestAdData", "listenerStrategy", "Lcom/wifi/ad/core/strategy/IStrategyListener;", "scene", "Lcom/wifi/ad/core/strategy/LoadScene;", "getInterstitialAd", "getMainThreadCorrectAd", "getNativeFeedAd", "getNativeView", "Lcom/wifi/ad/core/custom/flow/BaseNativeView;", "adProviderType", "getSplashAd", "getTemplateFeedAd", "interstitialAdIsBelongTheProvider", "onNestAdLoad", "onNestAdUnLoad", "pauseAd", "reportSensitiveInfo", "sensitiveInfo", "Lcom/wifi/ad/core/entity/SensitiveInfo;", "adCode", "ext", "", "resumeAd", "rewardAdIsBelongTheProvider", "showInterstitialAd", "activity", "Landroid/app/Activity;", "showListener", "Lcom/wifi/ad/core/listener/PopShowListener;", "showSplashAd", "container", "Landroid/view/ViewGroup;", "splashShowListener", "Lcom/wifi/ad/core/listener/SplashShowListener;", "splashAdIsBelongTheProvider", "startAd", "stopAd", "Companion", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
public final class NestLxAdProvider extends BaseAdProvider {
    public static final String DSP_NAME = "lxad_out";
    public static final String SDK_FROM = "lxad";

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LoadScene.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[LoadScene.FEED.ordinal()] = 1;
            iArr[LoadScene.INTERSTITIAL.ordinal()] = 2;
            iArr[LoadScene.SPLASH.ordinal()] = 3;
            iArr[LoadScene.REWARD.ordinal()] = 4;
        }
    }

    /* JADX INFO: renamed from: com.wifi.lxad.ad.NestLxAdProvider$getTemplateFeedAd$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\"\u0010\b\u001a\u00020\u00032\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000e"}, d2 = {"com/wifi/lxad/ad/NestLxAdProvider$getTemplateFeedAd$1", "Lcom/wifi/adsdk/listener/LxAdTempFeedListener;", "onFailed", "", "code", "", "message", "", "onSuccess", "feedAds", "", "Lcom/wifi/adsdk/tempfeed/LxTempFeedAd;", "reqParams", "Lcom/wifi/adsdk/params/LxAdReqParams;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
    public static final class C13981 implements LxAdTempFeedListener {
        final /* synthetic */ EventParams.Builder $builder;
        final /* synthetic */ IStrategyListener $listenerStrategy;
        final /* synthetic */ NestAdData $nestAdData;
        final /* synthetic */ ActivityPacker $packer;

        public C13981(NestAdData nestAdData, EventParams.Builder builder, IStrategyListener iStrategyListener, ActivityPacker activityPacker) {
            this.$nestAdData = nestAdData;
            this.$builder = builder;
            this.$listenerStrategy = iStrategyListener;
            this.$packer = activityPacker;
        }

        @Override // com.wifi.adsdk.listener.LxAdBaseListener
        public void onFailed(int code, String message) {
            EventReporter eventReporter = EventReporter.INSTANCE;
            NestAdData nestAdData = this.$nestAdData;
            EventParams.Builder builder = this.$builder;
            Intrinsics.checkExpressionValueIsNotNull(builder, "builder");
            eventReporter.reportNoRespDi(nestAdData, builder, String.valueOf(code), message);
            WifiLog.d("NestLxAdProvider getTemplateFeedAd onError code = " + code + " message = " + message);
            if (TextUtils.isEmpty(message)) {
                message = "no msg";
            }
            IStrategyListener iStrategyListener = this.$listenerStrategy;
            if (iStrategyListener != null) {
                NestAdData nestAdData2 = this.$nestAdData;
                if (message == null) {
                    Intrinsics.throwNpe();
                }
                iStrategyListener.onAdFailed(nestAdData2, message, code);
            }
        }

        /* JADX WARN: Type inference failed for: r0v7, types: [T, java.util.ArrayList] */
        @Override // com.wifi.adsdk.listener.LxAdTempFeedListener
        public void onSuccess(final List<LxTempFeedAd> feedAds, LxAdReqParams reqParams) {
            List<LxTempFeedAd> list = feedAds;
            if (list == null || list.isEmpty()) {
                EventReporter eventReporter = EventReporter.INSTANCE;
                NestAdData nestAdData = this.$nestAdData;
                EventParams.Builder builder = this.$builder;
                Intrinsics.checkExpressionValueIsNotNull(builder, "builder");
                eventReporter.reportNoRespDi(nestAdData, builder, "30200", "");
                WifiLog.d("NestLxAdProvider getTemplateFeedAd ad is null!");
                IStrategyListener iStrategyListener = this.$listenerStrategy;
                if (iStrategyListener != null) {
                    iStrategyListener.onAdFailed(this.$nestAdData, "ad is null or empty", -1);
                    return;
                }
                return;
            }
            int testPriceSwitchEcpm = NestLxAdProvider.this.getTestPriceSwitchEcpm(feedAds.get(0).getEcpm(), this.$nestAdData);
            WifiLog.d("NestLxAdProvider checkAdEcpmDone getTemplateFeedAd priceSwitch price " + testPriceSwitchEcpm + " code " + this.$nestAdData.getAdCode());
            NestLxAdProvider nestLxAdProvider = NestLxAdProvider.this;
            NestAdData nestAdData2 = this.$nestAdData;
            EventParams.Builder builder2 = this.$builder;
            Intrinsics.checkExpressionValueIsNotNull(builder2, "builder");
            if (nestLxAdProvider.checkAdEcpmDone(testPriceSwitchEcpm, nestAdData2, builder2, this.$listenerStrategy)) {
                return;
            }
            NestLxAdProvider nestLxAdProvider2 = NestLxAdProvider.this;
            NestAdData nestAdData3 = this.$nestAdData;
            EventParams.Builder builder3 = this.$builder;
            Intrinsics.checkExpressionValueIsNotNull(builder3, "builder");
            if (nestLxAdProvider2.checkAdPriceSwitch(testPriceSwitchEcpm, nestAdData3, builder3, this.$listenerStrategy)) {
                return;
            }
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = new ArrayList();
            for (LxTempFeedAd lxTempFeedAd : feedAds) {
                NestAdData nestAdData4 = this.$nestAdData;
                nestAdData4.setDspName(NestLxAdProvider.DSP_NAME);
                nestAdData4.setAppId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.LXAD)));
                nestAdData4.setSdkFrom("lxad");
                nestAdData4.setAdData(lxTempFeedAd);
                NestLxAdProvider.this.getAdEcpm(lxTempFeedAd.getEcpm(), this.$nestAdData);
                ((List) objectRef.element).add(this.$nestAdData);
                NestAdData nestAdData5 = this.$nestAdData;
                Context appContext = this.$packer.getAppContext();
                Intrinsics.checkExpressionValueIsNotNull(appContext, "packer.appContext");
                nestAdData5.setDataAdapter(new LxAdExpressAdDataAdapter(lxTempFeedAd, appContext));
                NestAdData nestAdData6 = this.$nestAdData;
                nestAdData6.setSensitiveInfo(LxAdSensitiveCatcher.INSTANCE.createInfoByAd(lxTempFeedAd, nestAdData6.getAdLevel()));
                NestLxAdProvider nestLxAdProvider3 = NestLxAdProvider.this;
                SensitiveInfo sensitiveInfo = this.$nestAdData.getSensitiveInfo();
                String adCode = this.$nestAdData.getAdCode();
                AdParams adParams = this.$nestAdData.getAdParams();
                nestLxAdProvider3.reportSensitiveInfo(sensitiveInfo, adCode, adParams != null ? adParams.getExt() : null);
                EventReporter eventReporter2 = EventReporter.INSTANCE;
                NestAdData nestAdData7 = this.$nestAdData;
                EventParams.Builder builder4 = this.$builder;
                Intrinsics.checkExpressionValueIsNotNull(builder4, "builder");
                eventReporter2.reportRespDi(nestAdData7, builder4, Integer.valueOf(feedAds.size()).intValue());
                IStrategyListener iStrategyListener2 = this.$listenerStrategy;
                if (iStrategyListener2 != null) {
                    iStrategyListener2.onAdLoaded((List) objectRef.element);
                }
                NestLxAdProvider.this.onNestAdLoadReport(this.$nestAdData);
                lxTempFeedAd.setShowListener(new LxTempFeedShowListener() { // from class: com.wifi.lxad.ad.NestLxAdProvider$getTemplateFeedAd$1$onSuccess$$inlined$forEach$lambda$1
                    @Override // com.wifi.adsdk.listener.LxTempFeedShowListener
                    public void adClose() {
                        WifiLog.d("NestLxAdProvider getTemplateFeedAd onClose");
                        NestLxAdProvider.C13981 c13981 = this.this$0;
                        IStrategyListener iStrategyListener3 = c13981.$listenerStrategy;
                        if (iStrategyListener3 != null) {
                            iStrategyListener3.onDislikeClicked(c13981.$nestAdData, "");
                        }
                    }

                    @Override // com.wifi.adsdk.listener.LxBaseShowListener
                    public void onAdClick(View view) throws JSONException {
                        WifiLog.d("NestLxAdProvider getTemplateFeedAd onAdClick");
                        NestLxAdProvider.C13981 c13981 = this.this$0;
                        IStrategyListener iStrategyListener3 = c13981.$listenerStrategy;
                        if (iStrategyListener3 != null) {
                            iStrategyListener3.onAdClicked(c13981.$nestAdData, SDKAlias.LXAD.getType());
                        }
                        NestLxAdNativeView.INSTANCE.onEvent(this.this$0.$nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_CLICK);
                    }

                    @Override // com.wifi.adsdk.listener.LxBaseShowListener
                    public void onAdShow() throws JSONException {
                        WifiLog.d("NestLxAdProvider showTemplateFeedAd onAdShow");
                        NestLxAdProvider.C13981 c13981 = this.this$0;
                        IStrategyListener iStrategyListener3 = c13981.$listenerStrategy;
                        if (iStrategyListener3 != null) {
                            iStrategyListener3.onAdExpose(c13981.$nestAdData, SDKAlias.LXAD.getType());
                        }
                        NestLxAdNativeView.INSTANCE.onEvent(this.this$0.$nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_SHOW);
                    }

                    @Override // com.wifi.adsdk.listener.LxBaseShowListener
                    public void onRenderFail(int i, String str) throws JSONException {
                        WifiLog.d("NestLxAdProvider getTemplateFeedAd onShowFailed");
                        if (str == null) {
                            str = "";
                        }
                        NestLxAdNativeView.Companion companion = NestLxAdNativeView.INSTANCE;
                        companion.onEvent(this.this$0.$nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_TOSHOW_FAIL, i, str);
                        companion.onEvent(this.this$0.$nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_SHOW_FAIL, i, str);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getMainThreadCorrectAd(ActivityPacker packer, NestAdData nestAdData, IStrategyListener listenerStrategy, LoadScene scene) {
        WifiLog.d("WkInitManager NestlxadProvider getCorrectAd " + Thread.currentThread());
        try {
            int i = WhenMappings.$EnumSwitchMapping$0[scene.ordinal()];
            if (i != 1) {
                if (i == 2) {
                    getInterstitialAd(packer, nestAdData, listenerStrategy);
                } else if (i == 3) {
                    getSplashAd(packer, nestAdData, listenerStrategy);
                } else if (i == 4) {
                    requestRewardAd(packer, nestAdData, listenerStrategy);
                }
            } else if (1 == nestAdData.getRenderStyle()) {
                nestAdData.setNativeAd(true);
                getNativeFeedAd(packer, nestAdData, listenerStrategy);
            } else {
                getTemplateFeedAd(packer, nestAdData, listenerStrategy);
            }
        } catch (Exception e) {
            WifiLog.d("lxad getCorrectAd Exception " + e);
            if (listenerStrategy != null) {
                listenerStrategy.onAdFailed(nestAdData, "beizi request error", -10011);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportSensitiveInfo(SensitiveInfo sensitiveInfo, String adCode, Map<String, String> ext) {
        if (sensitiveInfo != null) {
            ArrayList<SensitiveInfo> arrayList = new ArrayList();
            arrayList.add(sensitiveInfo);
            JSONArray jSONArray = new JSONArray();
            for (SensitiveInfo sensitiveInfo2 : arrayList) {
                if (sensitiveInfo2 != null) {
                    sensitiveInfo2.setAdCode(String.valueOf(adCode));
                }
                jSONArray.put(sensitiveInfo2 != null ? sensitiveInfo2.toJson() : null);
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
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void destroyAd(String requestId) {
        super.destroyAd(requestId);
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public boolean feedAdIsBelongTheProvider(NestAdData adObject) {
        Object adData = adObject.getAdData();
        if (adData != null) {
            return adData instanceof LxTempFeedAd;
        }
        return false;
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public boolean feedNativeAdIsBelongTheProvider(NestAdData adObject) {
        Object adData = adObject.getAdData();
        if (adData != null) {
            return adData instanceof LxNativeFeedAd;
        }
        return false;
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void getCorrectAd(final ActivityPacker packer, final NestAdData nestAdData, final IStrategyListener listenerStrategy, final LoadScene scene) {
        if (!NestLxAdManager.INSTANCE.getInitDone()) {
            listenerStrategy.onAdFailed(nestAdData, "sdk not init", -1001);
            return;
        }
        if (!RequestSDKConfig.INSTANCE.checkAllowRequest(nestAdData.getAdScene(), "lxad")) {
            listenerStrategy.onAdFailed(nestAdData, "sdk lxad RequestSDKConfig not allow", -1002);
            return;
        }
        Thread threadCurrentThread = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(Looper.getMainLooper(), "Looper.getMainLooper()");
        if (!Intrinsics.areEqual(threadCurrentThread, r1.getThread())) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.wifi.lxad.ad.NestLxAdProvider.getCorrectAd.1
                @Override // java.lang.Runnable
                public final void run() {
                    NestLxAdProvider.this.getMainThreadCorrectAd(packer, nestAdData, listenerStrategy, scene);
                }
            });
        } else {
            getMainThreadCorrectAd(packer, nestAdData, listenerStrategy, scene);
        }
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void getInterstitialAd(ActivityPacker packer, final NestAdData nestAdData, final IStrategyListener listenerStrategy) {
        String nestType;
        listenerStrategy.onStart(nestAdData);
        WifiLog.d("NestlxadProvider getInterstitialAd start");
        EventParams.Builder renderStyle = new EventParams.Builder().setDspName(DSP_NAME).setNestSid(nestAdData.getNestSid()).setMediaId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.LXAD))).setSrcId(String.valueOf(nestAdData.getAdCode())).setRenderStyle(nestAdData.getRenderStyle());
        AdParams adParams = nestAdData.getAdParams();
        if (adParams == null || (nestType = adParams.getNestType()) == null) {
            nestType = "";
        }
        final EventParams.Builder builder = renderStyle.setNestType(nestType).setSdkFrom("lxad");
        EventReporter eventReporter = EventReporter.INSTANCE;
        Intrinsics.checkExpressionValueIsNotNull(builder, "builder");
        eventReporter.reportReqDi(nestAdData, builder);
        LxAdManager.getAdManager().createAdNative().loadPopAd(new LxAdReqParams.Builder().setLxSrcId(nestAdData.getAdCode()).setNextSrcId(nestAdData.getAdUnitId()).setScene(String.valueOf(nestAdData.getAdScene())).setRequestId(nestAdData.getRequestId()).setLimit(1).build(), new LxAdPopListener() { // from class: com.wifi.lxad.ad.NestLxAdProvider.getInterstitialAd.1
            @Override // com.wifi.adsdk.listener.LxAdBaseListener
            public void onFailed(int code, String message) {
                EventReporter eventReporter2 = EventReporter.INSTANCE;
                NestAdData nestAdData2 = nestAdData;
                EventParams.Builder builder2 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder2, "builder");
                eventReporter2.reportNoRespDi(nestAdData2, builder2, String.valueOf(code), message);
                WifiLog.d("NestLxAdProvider getInterstitialAd onError code = " + code + " message = " + message);
                if (TextUtils.isEmpty(message)) {
                    message = "no msg";
                }
                IStrategyListener iStrategyListener = listenerStrategy;
                if (iStrategyListener != null) {
                    NestAdData nestAdData3 = nestAdData;
                    if (message == null) {
                        Intrinsics.throwNpe();
                    }
                    iStrategyListener.onAdFailed(nestAdData3, message, code);
                }
            }

            @Override // com.wifi.adsdk.listener.LxAdPopListener
            public void onSuccess(List<LxPopAd> adList, LxAdReqParams reqParams) {
                List<LxPopAd> list = adList;
                if (list == null || list.isEmpty()) {
                    EventReporter eventReporter2 = EventReporter.INSTANCE;
                    NestAdData nestAdData2 = nestAdData;
                    EventParams.Builder builder2 = builder;
                    Intrinsics.checkExpressionValueIsNotNull(builder2, "builder");
                    eventReporter2.reportNoRespDi(nestAdData2, builder2, "30200", "");
                    WifiLog.d("NestLxAdProvider getInterstitialAd ad is null!");
                    IStrategyListener iStrategyListener = listenerStrategy;
                    if (iStrategyListener != null) {
                        iStrategyListener.onAdFailed(nestAdData, "ad is null or empty", -1);
                        return;
                    }
                    return;
                }
                int testPriceSwitchEcpm = NestLxAdProvider.this.getTestPriceSwitchEcpm(adList.get(0).getEcpm(), nestAdData);
                WifiLog.d("NestLxAdProvider checkAdEcpmDone getInterstitialAd priceSwitch price " + testPriceSwitchEcpm + " code " + nestAdData.getAdCode());
                NestLxAdProvider nestLxAdProvider = NestLxAdProvider.this;
                NestAdData nestAdData3 = nestAdData;
                EventParams.Builder builder3 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder3, "builder");
                if (nestLxAdProvider.checkAdEcpmDone(testPriceSwitchEcpm, nestAdData3, builder3, listenerStrategy)) {
                    return;
                }
                NestLxAdProvider nestLxAdProvider2 = NestLxAdProvider.this;
                NestAdData nestAdData4 = nestAdData;
                EventParams.Builder builder4 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder4, "builder");
                if (nestLxAdProvider2.checkAdPriceSwitch(testPriceSwitchEcpm, nestAdData4, builder4, listenerStrategy)) {
                    return;
                }
                LxPopAd lxPopAd = adList.get(0);
                if (lxPopAd != null) {
                    NestAdData nestAdData5 = nestAdData;
                    nestAdData5.setDspName(NestLxAdProvider.DSP_NAME);
                    nestAdData5.setSdkFrom("lxad");
                    nestAdData5.setAdData(lxPopAd);
                    nestAdData5.setAppId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.LXAD)));
                }
                NestLxAdProvider.this.getAdEcpm(lxPopAd.getEcpm(), nestAdData);
                NestAdData nestAdData6 = nestAdData;
                nestAdData6.setSensitiveInfo(LxAdSensitiveCatcher.INSTANCE.createInfoByAd(lxPopAd, nestAdData6.getAdLevel()));
                NestLxAdProvider nestLxAdProvider3 = NestLxAdProvider.this;
                SensitiveInfo sensitiveInfo = nestAdData.getSensitiveInfo();
                String adCode = nestAdData.getAdCode();
                AdParams adParams2 = nestAdData.getAdParams();
                nestLxAdProvider3.reportSensitiveInfo(sensitiveInfo, adCode, adParams2 != null ? adParams2.getExt() : null);
                EventReporter eventReporter3 = EventReporter.INSTANCE;
                NestAdData nestAdData7 = nestAdData;
                EventParams.Builder builder5 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder5, "builder");
                eventReporter3.reportRespDi(nestAdData7, builder5, 1);
                ArrayList arrayList = new ArrayList();
                arrayList.add(nestAdData);
                IStrategyListener iStrategyListener2 = listenerStrategy;
                if (iStrategyListener2 != null) {
                    iStrategyListener2.onAdLoaded(arrayList);
                }
                NestLxAdProvider.this.onNestAdLoadReport(nestAdData);
            }
        });
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void getNativeFeedAd(final ActivityPacker packer, final NestAdData nestAdData, final IStrategyListener listenerStrategy) {
        String nestType;
        listenerStrategy.onStart(nestAdData);
        WifiLog.d("NestlxadProvider getNativeFeedAd start");
        EventParams.Builder renderStyle = new EventParams.Builder().setDspName(DSP_NAME).setNestSid(nestAdData.getNestSid()).setMediaId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.LXAD))).setSrcId(String.valueOf(nestAdData.getAdCode())).setRenderStyle(nestAdData.getRenderStyle());
        AdParams adParams = nestAdData.getAdParams();
        if (adParams == null || (nestType = adParams.getNestType()) == null) {
            nestType = "";
        }
        final EventParams.Builder builder = renderStyle.setNestType(nestType).setSdkFrom("lxad");
        EventReporter eventReporter = EventReporter.INSTANCE;
        Intrinsics.checkExpressionValueIsNotNull(builder, "builder");
        eventReporter.reportReqDi(nestAdData, builder);
        LxAdManager.getAdManager().createAdNative().loadNativeFeedAd(new LxAdReqParams.Builder().setLxSrcId(nestAdData.getAdCode()).setNextSrcId(nestAdData.getAdUnitId()).setScene(String.valueOf(nestAdData.getAdScene())).setRequestId(nestAdData.getRequestId()).setInteractiveType(nestAdData.getInteractiveType()).setLimit(1).build(), new LxAdNativeFeedListener() { // from class: com.wifi.lxad.ad.NestLxAdProvider.getNativeFeedAd.1
            @Override // com.wifi.adsdk.listener.LxAdBaseListener
            public void onFailed(int code, String message) {
                EventReporter eventReporter2 = EventReporter.INSTANCE;
                NestAdData nestAdData2 = nestAdData;
                EventParams.Builder builder2 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder2, "builder");
                eventReporter2.reportNoRespDi(nestAdData2, builder2, String.valueOf(code), message);
                WifiLog.d("NestLxAdProvider getNativeFeedAd onError code = " + code + " message = " + message);
                if (TextUtils.isEmpty(message)) {
                    message = "no msg";
                }
                IStrategyListener iStrategyListener = listenerStrategy;
                if (iStrategyListener != null) {
                    NestAdData nestAdData3 = nestAdData;
                    if (message == null) {
                        Intrinsics.throwNpe();
                    }
                    iStrategyListener.onAdFailed(nestAdData3, message, code);
                }
            }

            @Override // com.wifi.adsdk.listener.LxAdNativeFeedListener
            public void onSuccess(List<LxNativeFeedAd> ads, LxAdReqParams reqParams) {
                List<LxNativeFeedAd> list = ads;
                if (list == null || list.isEmpty()) {
                    EventReporter eventReporter2 = EventReporter.INSTANCE;
                    NestAdData nestAdData2 = nestAdData;
                    EventParams.Builder builder2 = builder;
                    Intrinsics.checkExpressionValueIsNotNull(builder2, "builder");
                    eventReporter2.reportNoRespDi(nestAdData2, builder2, "30200", "");
                    WifiLog.d("NestLxAdProvider onFeedAdLoad ad is null!");
                    IStrategyListener iStrategyListener = listenerStrategy;
                    if (iStrategyListener != null) {
                        iStrategyListener.onAdFailed(nestAdData, "ad is null or empty", -1);
                        return;
                    }
                    return;
                }
                int testPriceSwitchEcpm = NestLxAdProvider.this.getTestPriceSwitchEcpm(ads.get(0).getEcpm(), nestAdData);
                WifiLog.d("NestLxAdProvider checkAdEcpmDone getFeedAd priceSwitch price " + testPriceSwitchEcpm + " code " + nestAdData.getAdCode());
                NestLxAdProvider nestLxAdProvider = NestLxAdProvider.this;
                NestAdData nestAdData3 = nestAdData;
                EventParams.Builder builder3 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder3, "builder");
                if (nestLxAdProvider.checkAdEcpmDone(testPriceSwitchEcpm, nestAdData3, builder3, listenerStrategy)) {
                    return;
                }
                NestLxAdProvider nestLxAdProvider2 = NestLxAdProvider.this;
                NestAdData nestAdData4 = nestAdData;
                EventParams.Builder builder4 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder4, "builder");
                if (nestLxAdProvider2.checkAdPriceSwitch(testPriceSwitchEcpm, nestAdData4, builder4, listenerStrategy)) {
                    return;
                }
                WifiLog.d("NestLxAdProvider getNativeFeedAd onFeedAdLoad adList.size = " + ads.size());
                ArrayList arrayList = new ArrayList();
                for (LxNativeFeedAd lxNativeFeedAd : ads) {
                    NestAdData nestAdData5 = nestAdData;
                    nestAdData5.setDspName(NestLxAdProvider.DSP_NAME);
                    nestAdData5.setAppId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.LXAD)));
                    nestAdData5.setSdkFrom("lxad");
                    nestAdData5.setAdData(lxNativeFeedAd);
                    nestAdData5.setAdAppName(lxNativeFeedAd.getAppName());
                    nestAdData5.setAdAppDeveloperName(lxNativeFeedAd.getAppDeveloper());
                    nestAdData5.setAdAppVersion(lxNativeFeedAd.getAppVersion());
                    nestAdData5.setAdAppPermissionsUrl(lxNativeFeedAd.getAppPermission());
                    nestAdData5.setAdAppPrivacyUrl(lxNativeFeedAd.getAppPrivacy());
                    nestAdData5.setAdAppFunctionDescUrl(lxNativeFeedAd.getAppFunction());
                    Context appContext = packer.getAppContext();
                    Intrinsics.checkExpressionValueIsNotNull(appContext, "packer.appContext");
                    nestAdData5.setDataAdapter(new LxAdNativeFeedDataAdapter(lxNativeFeedAd, appContext));
                    nestAdData5.setNativeAdImgWidth(lxNativeFeedAd.getMaterialWidth());
                    nestAdData5.setNativeAdImgHeight(lxNativeFeedAd.getMaterialHeight());
                    NestLxAdProvider.this.getAdEcpm(lxNativeFeedAd.getEcpm(), nestAdData);
                    arrayList.add(nestAdData);
                }
                nestAdData.setSensitiveInfo(LxAdSensitiveCatcher.INSTANCE.createInfoByAd(ads.get(0), nestAdData.getAdLevel()));
                NestLxAdProvider nestLxAdProvider3 = NestLxAdProvider.this;
                SensitiveInfo sensitiveInfo = nestAdData.getSensitiveInfo();
                String adCode = nestAdData.getAdCode();
                AdParams adParams2 = nestAdData.getAdParams();
                nestLxAdProvider3.reportSensitiveInfo(sensitiveInfo, adCode, adParams2 != null ? adParams2.getExt() : null);
                EventReporter eventReporter3 = EventReporter.INSTANCE;
                NestAdData nestAdData6 = nestAdData;
                EventParams.Builder builder5 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder5, "builder");
                eventReporter3.reportRespDi(nestAdData6, builder5, Integer.valueOf(ads.size()).intValue());
                IStrategyListener iStrategyListener2 = listenerStrategy;
                if (iStrategyListener2 != null) {
                    iStrategyListener2.onAdLoaded(arrayList);
                }
                NestLxAdProvider.this.onNestAdLoad(nestAdData);
            }
        });
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider
    public BaseNativeView getNativeView(String adProviderType) {
        if (Intrinsics.areEqual(SDKAlias.LXAD.getType(), adProviderType)) {
            return new NestLxAdNativeView();
        }
        return null;
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void getSplashAd(ActivityPacker packer, final NestAdData nestAdData, final IStrategyListener listenerStrategy) {
        String nestType;
        listenerStrategy.onStart(nestAdData);
        WifiLog.d("NestlxadProvider getSplashAd start");
        EventParams.Builder renderStyle = new EventParams.Builder().setDspName(DSP_NAME).setNestSid(nestAdData.getNestSid()).setMediaId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.LXAD))).setSrcId(String.valueOf(nestAdData.getAdCode())).setRenderStyle(nestAdData.getRenderStyle());
        AdParams adParams = nestAdData.getAdParams();
        if (adParams == null || (nestType = adParams.getNestType()) == null) {
            nestType = "";
        }
        final EventParams.Builder builder = renderStyle.setNestType(nestType).setSdkFrom("lxad");
        EventReporter eventReporter = EventReporter.INSTANCE;
        Intrinsics.checkExpressionValueIsNotNull(builder, "builder");
        eventReporter.reportReqDi(nestAdData, builder);
        LxAdManager.getAdManager().createAdNative().loadSplashAd(new LxAdReqParams.Builder().setLxSrcId(nestAdData.getAdCode()).setNextSrcId(nestAdData.getAdUnitId()).setScene(String.valueOf(nestAdData.getAdScene())).setRequestId(nestAdData.getRequestId()).setLimit(1).build(), new LxAdSplashListener() { // from class: com.wifi.lxad.ad.NestLxAdProvider.getSplashAd.1
            @Override // com.wifi.adsdk.listener.LxAdBaseListener
            public void onFailed(int code, String message) {
                EventReporter eventReporter2 = EventReporter.INSTANCE;
                NestAdData nestAdData2 = nestAdData;
                EventParams.Builder builder2 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder2, "builder");
                eventReporter2.reportNoRespDi(nestAdData2, builder2, String.valueOf(code), message);
                WifiLog.d("NestLxAdProvider getSplashAd onError code = " + code + " message = " + message);
                if (TextUtils.isEmpty(message)) {
                    message = "no msg";
                }
                IStrategyListener iStrategyListener = listenerStrategy;
                if (iStrategyListener != null) {
                    NestAdData nestAdData3 = nestAdData;
                    if (message == null) {
                        Intrinsics.throwNpe();
                    }
                    iStrategyListener.onAdFailed(nestAdData3, message, code);
                }
            }

            @Override // com.wifi.adsdk.listener.LxAdSplashListener
            public void onSuccess(List<LxSplashAd> adList, LxAdReqParams reqParams) {
                List<LxSplashAd> list = adList;
                if (list == null || list.isEmpty()) {
                    EventReporter eventReporter2 = EventReporter.INSTANCE;
                    NestAdData nestAdData2 = nestAdData;
                    EventParams.Builder builder2 = builder;
                    Intrinsics.checkExpressionValueIsNotNull(builder2, "builder");
                    eventReporter2.reportNoRespDi(nestAdData2, builder2, "30200", "");
                    WifiLog.d("NestLxAdProvider getSplashAd ad is null!");
                    IStrategyListener iStrategyListener = listenerStrategy;
                    if (iStrategyListener != null) {
                        iStrategyListener.onAdFailed(nestAdData, "ad is null or empty", -1);
                        return;
                    }
                    return;
                }
                int testPriceSwitchEcpm = NestLxAdProvider.this.getTestPriceSwitchEcpm(adList.get(0).getEcpm(), nestAdData);
                WifiLog.d("NestLxAdProvider checkAdEcpmDone getSplashAd priceSwitch price " + testPriceSwitchEcpm + " code " + nestAdData.getAdCode());
                NestLxAdProvider nestLxAdProvider = NestLxAdProvider.this;
                NestAdData nestAdData3 = nestAdData;
                EventParams.Builder builder3 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder3, "builder");
                if (nestLxAdProvider.checkAdEcpmDone(testPriceSwitchEcpm, nestAdData3, builder3, listenerStrategy)) {
                    return;
                }
                NestLxAdProvider nestLxAdProvider2 = NestLxAdProvider.this;
                NestAdData nestAdData4 = nestAdData;
                EventParams.Builder builder4 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder4, "builder");
                if (nestLxAdProvider2.checkAdPriceSwitch(testPriceSwitchEcpm, nestAdData4, builder4, listenerStrategy)) {
                    return;
                }
                LxSplashAd lxSplashAd = adList.get(0);
                if (lxSplashAd != null) {
                    NestAdData nestAdData5 = nestAdData;
                    nestAdData5.setDspName(NestLxAdProvider.DSP_NAME);
                    nestAdData5.setSdkFrom("lxad");
                    nestAdData5.setAdData(lxSplashAd);
                    nestAdData5.setAppId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.LXAD)));
                }
                NestLxAdProvider.this.getAdEcpm(lxSplashAd.getEcpm(), nestAdData);
                NestAdData nestAdData6 = nestAdData;
                nestAdData6.setSensitiveInfo(LxAdSensitiveCatcher.INSTANCE.createInfoByAd(lxSplashAd, nestAdData6.getAdLevel()));
                NestLxAdProvider nestLxAdProvider3 = NestLxAdProvider.this;
                SensitiveInfo sensitiveInfo = nestAdData.getSensitiveInfo();
                String adCode = nestAdData.getAdCode();
                AdParams adParams2 = nestAdData.getAdParams();
                nestLxAdProvider3.reportSensitiveInfo(sensitiveInfo, adCode, adParams2 != null ? adParams2.getExt() : null);
                EventReporter eventReporter3 = EventReporter.INSTANCE;
                NestAdData nestAdData7 = nestAdData;
                EventParams.Builder builder5 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder5, "builder");
                eventReporter3.reportRespDi(nestAdData7, builder5, 1);
                ArrayList arrayList = new ArrayList();
                arrayList.add(nestAdData);
                IStrategyListener iStrategyListener2 = listenerStrategy;
                if (iStrategyListener2 != null) {
                    iStrategyListener2.onAdLoaded(arrayList);
                }
                NestLxAdProvider.this.onNestAdLoadReport(nestAdData);
            }
        });
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void getTemplateFeedAd(ActivityPacker packer, NestAdData nestAdData, IStrategyListener listenerStrategy) {
        String nestType;
        listenerStrategy.onStart(nestAdData);
        WifiLog.d("NestlxadProvider getTemplateFeedAd start");
        EventParams.Builder renderStyle = new EventParams.Builder().setDspName(DSP_NAME).setNestSid(nestAdData.getNestSid()).setMediaId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.LXAD))).setSrcId(String.valueOf(nestAdData.getAdCode())).setRenderStyle(nestAdData.getRenderStyle());
        AdParams adParams = nestAdData.getAdParams();
        if (adParams == null || (nestType = adParams.getNestType()) == null) {
            nestType = "";
        }
        EventParams.Builder builder = renderStyle.setNestType(nestType).setSdkFrom("lxad");
        EventReporter eventReporter = EventReporter.INSTANCE;
        Intrinsics.checkExpressionValueIsNotNull(builder, "builder");
        eventReporter.reportReqDi(nestAdData, builder);
        LxAdManager.getAdManager().createAdNative().loadTempFeedAd(new LxAdReqParams.Builder().setLxSrcId(nestAdData.getAdCode()).setNextSrcId(nestAdData.getAdUnitId()).setScene(String.valueOf(nestAdData.getAdScene())).setRequestId(nestAdData.getRequestId()).setLimit(1).build(), new C13981(nestAdData, builder, listenerStrategy, packer));
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public boolean interstitialAdIsBelongTheProvider(NestAdData adObject) {
        Object adData = adObject.getAdData();
        if (adData != null) {
            return adData instanceof LxPopAd;
        }
        return false;
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
    public boolean rewardAdIsBelongTheProvider(NestAdData adObject) {
        return false;
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void showInterstitialAd(Activity activity, final NestAdData nestAdData, final PopShowListener showListener) throws JSONException {
        Object adData = nestAdData.getAdData();
        if (adData == null || !(adData instanceof LxPopAd)) {
            return;
        }
        LxPopAd lxPopAd = (LxPopAd) adData;
        NestLxAdNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_TOSHOW);
        lxPopAd.setShowListener(new LxPopShowListener() { // from class: com.wifi.lxad.ad.NestLxAdProvider.showInterstitialAd.1
            @Override // com.wifi.adsdk.listener.LxBaseShowListener
            public void onAdClick(View view) throws JSONException {
                WifiLog.d("NestLxAdProvider showInterstitialAd onAdClick");
                PopShowListener popShowListener = showListener;
                if (popShowListener != null) {
                    popShowListener.onAdClicked(SDKAlias.LXAD.getType(), nestAdData);
                }
                NestLxAdNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_CLICK);
            }

            @Override // com.wifi.adsdk.listener.LxBaseShowListener
            public void onAdShow() throws JSONException {
                WifiLog.d("NestLxAdProvider showInterstitialAd onAdShow");
                PopShowListener popShowListener = showListener;
                if (popShowListener != null) {
                    popShowListener.onAdExpose(SDKAlias.LXAD.getType(), nestAdData);
                }
                NestLxAdNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_SHOW);
            }

            @Override // com.wifi.adsdk.listener.LxBaseShowListener
            public void onRenderFail(int code, String message) {
            }
        });
        lxPopAd.setShowAct(activity);
        lxPopAd.showPopAd(activity);
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void showSplashAd(Activity activity, final NestAdData nestAdData, ViewGroup container, SplashShowListener splashShowListener) throws JSONException {
        Object adData = nestAdData.getAdData();
        if (adData == null || !(adData instanceof LxSplashAd)) {
            return;
        }
        nestAdData.setSplashShowListener(splashShowListener);
        LxSplashAd lxSplashAd = (LxSplashAd) adData;
        NestLxAdNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_TOSHOW);
        lxSplashAd.setShowListener(new LxSplashShowListener() { // from class: com.wifi.lxad.ad.NestLxAdProvider.showSplashAd.1
            @Override // com.wifi.adsdk.listener.LxBaseShowListener
            public void onAdClick(View view) throws JSONException {
                WifiLog.d("NestLxAdProvider showSplashAd onAdClick");
                SplashShowListener splashShowListener2 = nestAdData.getSplashShowListener();
                if (splashShowListener2 != null) {
                    splashShowListener2.onAdClicked(SDKAlias.LXAD.getType(), nestAdData);
                }
                NestLxAdNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_CLICK);
            }

            @Override // com.wifi.adsdk.listener.LxBaseShowListener
            public void onAdShow() throws JSONException {
                WifiLog.d("NestLxAdProvider showSplashAd onAdShow");
                SplashShowListener splashShowListener2 = nestAdData.getSplashShowListener();
                if (splashShowListener2 != null) {
                    splashShowListener2.onAdExpose(SDKAlias.LXAD.getType(), nestAdData);
                }
                NestLxAdNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_SHOW);
            }

            @Override // com.wifi.adsdk.listener.LxSplashShowListener
            public void onAdSkip() throws JSONException {
                WifiLog.d("NestLxAdProvider showSplashAd onSkip");
                nestAdData.getCsjSplashSkipEd().set(true);
                NestLxAdNativeView.INSTANCE.onEvent(nestAdData, "nest_sdk_cancle_click");
                SplashShowListener splashShowListener2 = nestAdData.getSplashShowListener();
                if (splashShowListener2 != null) {
                    splashShowListener2.onAdSkip(SDKAlias.LXAD.getType(), nestAdData);
                }
            }

            @Override // com.wifi.adsdk.listener.LxSplashShowListener
            public void onTimeDone() throws JSONException {
                WifiLog.d("NestLxAdProvider showSplashAd onTimeDone");
                if (nestAdData.getCsjSplashSkipEd().get()) {
                    return;
                }
                NestLxAdNativeView.INSTANCE.onEvent(nestAdData, "nest_sdk_cancle_click");
                SplashShowListener splashShowListener2 = nestAdData.getSplashShowListener();
                if (splashShowListener2 != null) {
                    splashShowListener2.onAdSkip(SDKAlias.LXAD.getType(), nestAdData);
                }
            }

            @Override // com.wifi.adsdk.listener.LxBaseShowListener
            public void onRenderFail(int code, String message) {
            }
        });
        lxSplashAd.setShowAct(activity);
        lxSplashAd.showSplash(container);
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public boolean splashAdIsBelongTheProvider(NestAdData adObject) {
        Object adData = adObject.getAdData();
        if (adData != null) {
            return adData instanceof LxSplashAd;
        }
        return false;
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void pauseAd(NestAdData nestAdData) {
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void resumeAd(NestAdData nestAdData) {
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void startAd(NestAdData nestAdData) {
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void stopAd(NestAdData nestAdData) {
    }
}
