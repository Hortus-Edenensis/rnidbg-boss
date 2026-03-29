package com.wifi.oppo.ad;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.heytap.msp.mobad.api.ad.HotSplashAd;
import com.heytap.msp.mobad.api.ad.InterstitialAd;
import com.heytap.msp.mobad.api.ad.NativeAdvanceAd;
import com.heytap.msp.mobad.api.ad.NativeTempletAd;
import com.heytap.msp.mobad.api.listener.IHotSplashListener;
import com.heytap.msp.mobad.api.listener.IInterstitialAdListener;
import com.heytap.msp.mobad.api.listener.INativeAdvanceLoadListener;
import com.heytap.msp.mobad.api.listener.INativeTempletAdListener;
import com.heytap.msp.mobad.api.params.INativeAdvanceComplianceInfo;
import com.heytap.msp.mobad.api.params.INativeAdvanceData;
import com.heytap.msp.mobad.api.params.INativeTempletAdView;
import com.heytap.msp.mobad.api.params.NativeAdError;
import com.heytap.msp.mobad.api.params.NativeAdSize;
import com.heytap.msp.mobad.api.params.SplashAdParams;
import com.huawei.openalliance.ad.constant.bq;
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
import com.wifi.ad.core.listener.InnerRewardShowListener;
import com.wifi.ad.core.listener.PopShowListener;
import com.wifi.ad.core.listener.SplashShowListener;
import com.wifi.ad.core.p001const.WifiNestConst;
import com.wifi.ad.core.provider.BaseAdProvider;
import com.wifi.ad.core.reporter.EventReporter;
import com.wifi.ad.core.strategy.IStrategyListener;
import com.wifi.ad.core.strategy.LoadScene;
import com.wifi.ad.core.utils.WifiLog;
import com.wifi.oppo.ad.NestOppoNativeView;
import com.wifi.oppo.ad.data.OppoFeedDataAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 92\u00020\u0001:\u00019B\u0005¢\u0006\u0002\u0010\u0002JK\u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0002\u0010\u000eJ\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J(\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J \u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J \u0010 \u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0012\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020\tH\u0016J \u0010$\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u001cH\u0016J \u0010&\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010'\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010(\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0015H\u0016J\u0010\u0010)\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0015H\u0016J\u0010\u0010*\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0015H\u0016J\u0010\u0010+\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0015H\u0016J\"\u0010,\u001a\u00020\u00102\u0006\u0010-\u001a\u00020.2\u0006\u0010\u001a\u001a\u00020\u00152\b\u0010/\u001a\u0004\u0018\u000100H\u0016J(\u00101\u001a\u00020\u00102\u0006\u0010-\u001a\u00020.2\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0016J\u0010\u00106\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u00107\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0015H\u0016J\u0010\u00108\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0015H\u0016¨\u0006:"}, d2 = {"Lcom/wifi/oppo/ad/NestOppoProvider;", "Lcom/wifi/ad/core/provider/BaseAdProvider;", "()V", "catchOppoSensitiveInfo", "", "Lcom/wifi/ad/core/entity/SensitiveInfo;", "ad", "", "codeId", "", "ext", "", "adLevel", "", "(Ljava/lang/Object;Ljava/lang/String;Ljava/util/Map;Ljava/lang/Integer;)Ljava/util/List;", "destroyAd", "", "requestId", "feedAdIsBelongTheProvider", "", "adObject", "Lcom/wifi/ad/core/data/NestAdData;", "feedNativeAdIsBelongTheProvider", "getCorrectAd", "packer", "Lcom/wifi/ad/core/helper/ActivityPacker;", "nestAdData", "listenerStrategy", "Lcom/wifi/ad/core/strategy/IStrategyListener;", "scene", "Lcom/wifi/ad/core/strategy/LoadScene;", "getInterstitialAd", "getNativeFeedAd", "getNativeView", "Lcom/wifi/ad/core/custom/flow/BaseNativeView;", "adProviderType", "getSplashAd", bq.f.s, "getTemplateFeedAd", "interstitialAdIsBelongTheProvider", "onNestAdLoad", "onNestAdUnLoad", "pauseAd", "resumeAd", "showInterstitialAd", "activity", "Landroid/app/Activity;", "showListener", "Lcom/wifi/ad/core/listener/PopShowListener;", "showSplashAd", "container", "Landroid/view/ViewGroup;", "splashShowListener", "Lcom/wifi/ad/core/listener/SplashShowListener;", "splashAdIsBelongTheProvider", "startAd", "stopAd", "Companion", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
public final class NestOppoProvider extends BaseAdProvider {
    public static final String DSP_NAME = "oppo_out";
    public static final String SDK_FROM = "oppo";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static HashMap<String, InnerRewardShowListener> showListenerMap = new HashMap<>();

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R6\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b`\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/wifi/oppo/ad/NestOppoProvider$Companion;", "", "()V", "DSP_NAME", "", "SDK_FROM", "showListenerMap", "Ljava/util/HashMap;", "Lcom/wifi/ad/core/listener/InnerRewardShowListener;", "Lkotlin/collections/HashMap;", "getShowListenerMap", "()Ljava/util/HashMap;", "setShowListenerMap", "(Ljava/util/HashMap;)V", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public final HashMap<String, InnerRewardShowListener> getShowListenerMap() {
            return NestOppoProvider.showListenerMap;
        }

        public final void setShowListenerMap(HashMap<String, InnerRewardShowListener> map) {
            NestOppoProvider.showListenerMap = map;
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
            iArr[LoadScene.FEED.ordinal()] = 1;
            iArr[LoadScene.INTERSTITIAL.ordinal()] = 2;
            iArr[LoadScene.SPLASH.ordinal()] = 3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<SensitiveInfo> catchOppoSensitiveInfo(Object ad, String codeId, Map<String, String> ext, Integer adLevel) {
        List<SensitiveInfo> listCatchTemplateAds;
        if (!WifiNestAd.INSTANCE.isCatchThirdInfo()) {
            return null;
        }
        if (ad instanceof InterstitialAd) {
            listCatchTemplateAds = OppoSensitiveCatcher.INSTANCE.catchInterstitialAds((InterstitialAd) ad, adLevel);
        } else if (TypeIntrinsics.isMutableList(ad)) {
            if (((List) ad).size() <= 0) {
                listCatchTemplateAds = null;
            } else if (((List) ad).get(0) instanceof INativeAdvanceData) {
                OppoSensitiveCatcher oppoSensitiveCatcher = OppoSensitiveCatcher.INSTANCE;
                if (ad == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableList<com.heytap.msp.mobad.api.params.INativeAdvanceData>");
                }
                listCatchTemplateAds = oppoSensitiveCatcher.catchNativeAds(TypeIntrinsics.asMutableList(ad), adLevel);
            } else if (((List) ad).get(0) instanceof INativeTempletAdView) {
                OppoSensitiveCatcher oppoSensitiveCatcher2 = OppoSensitiveCatcher.INSTANCE;
                if (ad == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableList<com.heytap.msp.mobad.api.params.INativeTempletAdView>");
                }
                listCatchTemplateAds = oppoSensitiveCatcher2.catchTemplateAds(TypeIntrinsics.asMutableList(ad), adLevel);
            }
        } else if (ad instanceof HotSplashAd) {
            listCatchTemplateAds = OppoSensitiveCatcher.INSTANCE.catchSplashAds((HotSplashAd) ad, adLevel);
        }
        List<SensitiveInfo> list = listCatchTemplateAds;
        if (!(list == null || list.isEmpty())) {
            JSONArray jSONArray = new JSONArray();
            for (SensitiveInfo sensitiveInfo : listCatchTemplateAds) {
                if (sensitiveInfo != null) {
                    sensitiveInfo.setAdCode(String.valueOf(codeId));
                }
                jSONArray.put(sensitiveInfo != null ? sensitiveInfo.toJson() : null);
            }
            EventParams params = new EventParams.Builder().build();
            Intrinsics.checkExpressionValueIsNotNull(params, "params");
            params.setThirdSdkInfo(jSONArray.toString());
            if (!TextUtils.isEmpty(params.getThirdSdkInfo())) {
                WifiNestAd.INSTANCE.getReporter().onEvent(WifiNestConst.EventKey.UNIFIEDAD_SDK_THIRDSDK_CONTENT, params, ext);
            }
        }
        return listCatchTemplateAds;
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
    public boolean feedAdIsBelongTheProvider(NestAdData adObject) {
        return adObject.getAdData() instanceof INativeTempletAdView;
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public boolean feedNativeAdIsBelongTheProvider(NestAdData adObject) {
        if (adObject.getAdData() instanceof INativeAdvanceData) {
            return true;
        }
        return super.feedNativeAdIsBelongTheProvider(adObject);
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void getCorrectAd(ActivityPacker packer, NestAdData nestAdData, IStrategyListener listenerStrategy, LoadScene scene) {
        if (!NestOppoManager.INSTANCE.getInitDone()) {
            listenerStrategy.onAdFailed(nestAdData, "sdk not init", -1001);
            return;
        }
        if (!RequestSDKConfig.INSTANCE.checkAllowRequest(nestAdData.getAdScene(), "oppo")) {
            listenerStrategy.onAdFailed(nestAdData, "sdk oppo RequestSDKConfig not allow", -1002);
            return;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[scene.ordinal()];
        if (i == 1) {
            if (1 != nestAdData.getRenderStyle()) {
                getTemplateFeedAd(packer, nestAdData, listenerStrategy);
                return;
            } else {
                nestAdData.setNativeAd(true);
                getNativeFeedAd(packer, nestAdData, listenerStrategy);
                return;
            }
        }
        if (i == 2) {
            getInterstitialAd(packer, nestAdData, listenerStrategy);
        } else {
            if (i != 3) {
                return;
            }
            getSplashAd(packer, nestAdData, listenerStrategy);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v16, types: [T, com.heytap.msp.mobad.api.ad.InterstitialAd] */
    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void getInterstitialAd(ActivityPacker packer, final NestAdData nestAdData, final IStrategyListener listenerStrategy) {
        String nestType;
        WifiLog.d("NestOppoProvider 开始请求InterstitialAd ");
        listenerStrategy.onStart(nestAdData);
        if (nestAdData.getPopRequestTime() == 1) {
            WifiLog.d("NestOppoProvider getInterstitialAd onError nestAdData.popRequestTime == 1 ");
            listenerStrategy.onAdFailed(nestAdData, "popRequestTime == 1", -10001);
            return;
        }
        EventParams.Builder renderStyle = new EventParams.Builder().setDspName(DSP_NAME).setNestSid(nestAdData.getNestSid()).setMediaId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.OPPO))).setSrcId(String.valueOf(nestAdData.getAdCode())).setRenderStyle(nestAdData.getRenderStyle());
        AdParams adParams = nestAdData.getAdParams();
        if (adParams == null || (nestType = adParams.getNestType()) == null) {
            nestType = "";
        }
        final EventParams.Builder builder = renderStyle.setNestType(nestType).setInventoryId(nestAdData.getInventoryId()).setSdkFrom("oppo");
        EventReporter eventReporter = EventReporter.INSTANCE;
        Intrinsics.checkExpressionValueIsNotNull(builder, "builder");
        eventReporter.reportReqDi(nestAdData, builder);
        final String adCode = nestAdData.getAdCode();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? interstitialAd = new InterstitialAd(packer.getActivityIfExist(), adCode);
        objectRef.element = interstitialAd;
        interstitialAd.setAdListener(new IInterstitialAdListener() { // from class: com.wifi.oppo.ad.NestOppoProvider.getInterstitialAd.1
            @Override // com.heytap.msp.mobad.api.listener.IBaseAdListener
            public void onAdClick() throws JSONException {
                WifiLog.d("NestOppoProvider getInterstitialAd onAdClick");
                PopShowListener popshowListener = nestAdData.getPopshowListener();
                if (popshowListener != null) {
                    popshowListener.onAdClicked(SDKAlias.OPPO.getType(), nestAdData);
                }
                NestOppoNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_CLICK);
            }

            @Override // com.heytap.msp.mobad.api.listener.IInterstitialAdListener
            public void onAdClose() throws JSONException {
                WifiLog.d("NestOppoProvider getInterstitialAd onAdClose");
                PopShowListener popshowListener = nestAdData.getPopshowListener();
                if (popshowListener != null) {
                    popshowListener.onAdClose(SDKAlias.GDT.getType(), nestAdData);
                }
                NestOppoNativeView.INSTANCE.onEvent(nestAdData, "nest_sdk_cancle_click");
            }

            @Override // com.heytap.msp.mobad.api.listener.IBaseAdListener
            public void onAdFailed(int code, String p1) {
                EventReporter eventReporter2 = EventReporter.INSTANCE;
                NestAdData nestAdData2 = nestAdData;
                EventParams.Builder builder2 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder2, "builder");
                eventReporter2.reportNoRespDi(nestAdData2, builder2, String.valueOf(code), p1);
                WifiLog.d("NestOppoProvider getInterstitialAd onError code = " + code + " message = " + p1);
                if (TextUtils.isEmpty(p1)) {
                    p1 = "no msg";
                }
                IStrategyListener iStrategyListener = listenerStrategy;
                if (iStrategyListener != null) {
                    NestAdData nestAdData3 = nestAdData;
                    if (p1 == null) {
                        Intrinsics.throwNpe();
                    }
                    iStrategyListener.onAdFailed(nestAdData3, p1, code);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.heytap.msp.mobad.api.listener.IInterstitialAdListener
            public void onAdReady() {
                T t = objectRef.element;
                if (((InterstitialAd) t) != null) {
                    int testPriceSwitchEcpm = NestOppoProvider.this.getTestPriceSwitchEcpm(((InterstitialAd) t).getECPM(), nestAdData);
                    WifiLog.d("NestOppoProvider getInterstitialAd onADLoaded priceSwitch price " + testPriceSwitchEcpm + " code " + nestAdData.getAdCode());
                    NestOppoProvider nestOppoProvider = NestOppoProvider.this;
                    NestAdData nestAdData2 = nestAdData;
                    EventParams.Builder builder2 = builder;
                    Intrinsics.checkExpressionValueIsNotNull(builder2, "builder");
                    if (nestOppoProvider.checkAdEcpmDone(testPriceSwitchEcpm, nestAdData2, builder2, listenerStrategy)) {
                        return;
                    }
                    NestOppoProvider nestOppoProvider2 = NestOppoProvider.this;
                    NestAdData nestAdData3 = nestAdData;
                    EventParams.Builder builder3 = builder;
                    Intrinsics.checkExpressionValueIsNotNull(builder3, "builder");
                    if (nestOppoProvider2.checkAdPriceSwitch(testPriceSwitchEcpm, nestAdData3, builder3, listenerStrategy)) {
                        return;
                    }
                }
                NestOppoProvider nestOppoProvider3 = NestOppoProvider.this;
                InterstitialAd interstitialAd2 = (InterstitialAd) objectRef.element;
                String str = adCode;
                AdParams adParams2 = nestAdData.getAdParams();
                List listCatchOppoSensitiveInfo = nestOppoProvider3.catchOppoSensitiveInfo(interstitialAd2, str, adParams2 != null ? adParams2.getExt() : null, nestAdData.getAdLevel());
                nestAdData.setDspName(NestOppoProvider.DSP_NAME);
                nestAdData.setAppId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.KS)));
                nestAdData.setSdkFrom("oppo");
                nestAdData.setAdData((InterstitialAd) objectRef.element);
                if (listCatchOppoSensitiveInfo != null && (!listCatchOppoSensitiveInfo.isEmpty())) {
                    nestAdData.setSensitiveInfo((SensitiveInfo) listCatchOppoSensitiveInfo.get(0));
                }
                NestOppoProvider.this.getAdEcpm(((InterstitialAd) objectRef.element).getECPM(), nestAdData);
                EventReporter eventReporter2 = EventReporter.INSTANCE;
                NestAdData nestAdData4 = nestAdData;
                EventParams.Builder builder4 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder4, "builder");
                eventReporter2.reportRespDi(nestAdData4, builder4, 1);
                ArrayList arrayList = new ArrayList();
                arrayList.add(nestAdData);
                IStrategyListener iStrategyListener = listenerStrategy;
                if (iStrategyListener != null) {
                    iStrategyListener.onAdLoaded(arrayList);
                }
                NestOppoProvider.this.onNestAdLoadReport(nestAdData);
            }

            @Override // com.heytap.msp.mobad.api.listener.IBaseAdListener
            public void onAdShow() throws JSONException {
                WifiLog.d("NestOppoProvider getInterstitialAd onAdShow");
                PopShowListener popshowListener = nestAdData.getPopshowListener();
                if (popshowListener != null) {
                    popshowListener.onAdExpose(SDKAlias.OPPO.getType(), nestAdData);
                }
                NestOppoNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_SHOW);
            }

            @Override // com.heytap.msp.mobad.api.listener.IBaseAdListener
            public void onAdFailed(String p0) {
                EventReporter eventReporter2 = EventReporter.INSTANCE;
                NestAdData nestAdData2 = nestAdData;
                EventParams.Builder builder2 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder2, "builder");
                eventReporter2.reportNoRespDi(nestAdData2, builder2, "", p0);
                WifiLog.d("NestOppoProvider getInterstitialAd onAdFailed code null message = " + p0);
                if (TextUtils.isEmpty(p0)) {
                    p0 = "no msg";
                }
                IStrategyListener iStrategyListener = listenerStrategy;
                if (iStrategyListener != null) {
                    NestAdData nestAdData3 = nestAdData;
                    if (p0 == null) {
                        Intrinsics.throwNpe();
                    }
                    iStrategyListener.onAdFailed(nestAdData3, p0, 0);
                }
            }
        });
        ((InterstitialAd) objectRef.element).loadAd();
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void getNativeFeedAd(final ActivityPacker packer, final NestAdData nestAdData, final IStrategyListener listenerStrategy) {
        String nestType;
        WifiLog.d("NestOppoProvider getNativeFeedAd adLevelName = " + nestAdData.getAdLevelName() + " adCode = " + nestAdData.getAdCode() + " adLevel = " + nestAdData.getAdLevel() + " adType = " + nestAdData.getAdType());
        listenerStrategy.onStart(nestAdData);
        EventParams.Builder inventoryId = new EventParams.Builder().setDspName(DSP_NAME).setNestSid(nestAdData.getNestSid()).setMediaId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.OPPO))).setSrcId(String.valueOf(nestAdData.getAdCode())).setRenderStyle(nestAdData.getRenderStyle()).setInventoryId(nestAdData.getInventoryId());
        AdParams adParams = nestAdData.getAdParams();
        if (adParams == null || (nestType = adParams.getNestType()) == null) {
            nestType = "";
        }
        final EventParams.Builder builder = inventoryId.setNestType(nestType).setSdkFrom("oppo");
        EventReporter eventReporter = EventReporter.INSTANCE;
        Intrinsics.checkExpressionValueIsNotNull(builder, "builder");
        eventReporter.reportReqDi(nestAdData, builder);
        new NativeAdvanceAd(packer.getAppContext(), nestAdData.getAdCode(), new INativeAdvanceLoadListener() { // from class: com.wifi.oppo.ad.NestOppoProvider$getNativeFeedAd$nativeAd$1
            @Override // com.heytap.msp.mobad.api.listener.INativeAdvanceLoadListener
            public void onAdFailed(int code, String msg) {
                EventReporter eventReporter2 = EventReporter.INSTANCE;
                NestAdData nestAdData2 = nestAdData;
                EventParams.Builder builder2 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder2, "builder");
                eventReporter2.reportNoRespDi(nestAdData2, builder2, String.valueOf(code), msg);
                WifiLog.d("NestOppoProvider getNativeAd onError code = " + code + " message = " + msg);
                IStrategyListener iStrategyListener = listenerStrategy;
                if (iStrategyListener != null) {
                    iStrategyListener.onAdFailed(nestAdData, msg, code);
                }
            }

            @Override // com.heytap.msp.mobad.api.listener.INativeAdvanceLoadListener
            public void onAdSuccess(List<INativeAdvanceData> ads) {
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
                    WifiLog.d("NestOppoProvider getNativeAd onADLoaded priceSwitch price " + testPriceSwitchEcpm + " code " + nestAdData.getAdCode());
                    NestOppoProvider nestOppoProvider = this.this$0;
                    NestAdData nestAdData3 = nestAdData;
                    EventParams.Builder builder3 = builder;
                    Intrinsics.checkExpressionValueIsNotNull(builder3, "builder");
                    if (nestOppoProvider.checkAdEcpmDone(testPriceSwitchEcpm, nestAdData3, builder3, listenerStrategy)) {
                        return;
                    }
                    NestOppoProvider nestOppoProvider2 = this.this$0;
                    NestAdData nestAdData4 = nestAdData;
                    EventParams.Builder builder4 = builder;
                    Intrinsics.checkExpressionValueIsNotNull(builder4, "builder");
                    if (nestOppoProvider2.checkAdPriceSwitch(testPriceSwitchEcpm, nestAdData4, builder4, listenerStrategy)) {
                        return;
                    }
                }
                NestOppoProvider nestOppoProvider3 = this.this$0;
                String adCode = nestAdData.getAdCode();
                AdParams adParams2 = nestAdData.getAdParams();
                List listCatchOppoSensitiveInfo = nestOppoProvider3.catchOppoSensitiveInfo(ads, adCode, adParams2 != null ? adParams2.getExt() : null, nestAdData.getAdLevel());
                INativeAdvanceData iNativeAdvanceData = ads.get(0);
                builder.setAdTitle(iNativeAdvanceData.getTitle()).setAdDesc(iNativeAdvanceData.getDesc());
                ArrayList arrayList = new ArrayList();
                for (INativeAdvanceData iNativeAdvanceData2 : ads) {
                    NestAdData nestAdData5 = nestAdData;
                    nestAdData5.setDspName(NestOppoProvider.DSP_NAME);
                    nestAdData5.setAppId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.OPPO)));
                    nestAdData5.setSdkFrom("oppo");
                    nestAdData5.setAdData(iNativeAdvanceData2);
                    if (iNativeAdvanceData2.getComplianceInfo() != null) {
                        INativeAdvanceComplianceInfo complianceInfo = iNativeAdvanceData2.getComplianceInfo();
                        Intrinsics.checkExpressionValueIsNotNull(complianceInfo, "ad.complianceInfo");
                        nestAdData5.setAdAppDeveloperName(complianceInfo.getDeveloperName());
                        nestAdData5.setAdAppName(iNativeAdvanceData2.getTitle());
                        nestAdData5.setAdAppVersion(complianceInfo.getAppVersion());
                        nestAdData5.setAdAppFunctionDescUrl(complianceInfo.getDeveloperName());
                    }
                    if (listCatchOppoSensitiveInfo != null && (!listCatchOppoSensitiveInfo.isEmpty())) {
                        nestAdData5.setSensitiveInfo((SensitiveInfo) listCatchOppoSensitiveInfo.get(0));
                    }
                    int creativeType = iNativeAdvanceData2.getCreativeType();
                    if (creativeType == 3) {
                        nestAdData5.setNativeAdImgWidth(512);
                        nestAdData5.setNativeAdImgHeight(512);
                    } else if (creativeType == 6) {
                        nestAdData5.setNativeAdImgWidth(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK);
                        nestAdData5.setNativeAdImgHeight(MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
                    } else if (creativeType == 7 || creativeType == 8) {
                        nestAdData5.setNativeAdImgWidth(MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
                        nestAdData5.setNativeAdImgHeight(210);
                    } else if (creativeType == 13) {
                        nestAdData5.setNativeAdImgWidth(16);
                        nestAdData5.setNativeAdImgHeight(9);
                    } else if (creativeType == 15 || creativeType == 16) {
                        nestAdData5.setNativeAdImgWidth(9);
                        nestAdData5.setNativeAdImgHeight(16);
                    }
                    WifiLog.d("oppo native type " + creativeType + " nativeAdImgWidth " + nestAdData5.getNativeAdImgWidth() + " nativeAdImgHeight " + nestAdData5.getNativeAdImgHeight() + " code " + nestAdData.getAdCode());
                    Context appContext = packer.getAppContext();
                    Intrinsics.checkExpressionValueIsNotNull(appContext, "packer.appContext");
                    nestAdData5.setDataAdapter(new OppoFeedDataAdapter(iNativeAdvanceData2, appContext));
                    this.this$0.getAdEcpm(iNativeAdvanceData2.getECPM(), nestAdData);
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
            }
        }).loadAd();
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider
    public BaseNativeView getNativeView(String adProviderType) {
        return new NestOppoNativeView();
    }

    /* JADX WARN: Type inference failed for: r8v0, types: [T, com.heytap.msp.mobad.api.ad.HotSplashAd] */
    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void getSplashAd(ActivityPacker packer, final NestAdData nestAdData, final IStrategyListener listener) {
        String nestType;
        WifiLog.d("splashAd oppo getSplashAd");
        EventParams.Builder renderStyle = new EventParams.Builder().setDspName(DSP_NAME).setNestSid(nestAdData.getNestSid()).setMediaId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.OPPO))).setSrcId(String.valueOf(nestAdData.getAdCode())).setRenderStyle(nestAdData.getRenderStyle());
        AdParams adParams = nestAdData.getAdParams();
        if (adParams == null || (nestType = adParams.getNestType()) == null) {
            nestType = "";
        }
        final EventParams.Builder builder = renderStyle.setNestType(nestType).setInventoryId(nestAdData.getInventoryId()).setSdkFrom("oppo");
        EventReporter eventReporter = EventReporter.INSTANCE;
        Intrinsics.checkExpressionValueIsNotNull(builder, "builder");
        eventReporter.reportReqDi(nestAdData, builder);
        SplashAdParams splashAdParamsBuild = new SplashAdParams.Builder().setFetchTimeout(nestAdData.getTimeOut()).setShowPreLoadPage(false).setBottomArea(nestAdData.getSplashBottomArea()).build();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        if (nestAdData.getSplashBottomArea() != null) {
            View splashBottomArea = nestAdData.getSplashBottomArea();
            if (splashBottomArea == null) {
                Intrinsics.throwNpe();
            }
            if (splashBottomArea.getParent() instanceof ViewGroup) {
                View splashBottomArea2 = nestAdData.getSplashBottomArea();
                if (splashBottomArea2 == null) {
                    Intrinsics.throwNpe();
                }
                ViewParent parent = splashBottomArea2.getParent();
                if (parent == null) {
                    throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
                }
                ViewGroup viewGroup = (ViewGroup) parent;
                View splashBottomArea3 = nestAdData.getSplashBottomArea();
                if (splashBottomArea3 == null) {
                    Intrinsics.throwNpe();
                }
                viewGroup.removeView(splashBottomArea3);
            }
        }
        objectRef.element = new HotSplashAd(packer.getActivityIfExist(), nestAdData.getAdCode(), new IHotSplashListener() { // from class: com.wifi.oppo.ad.NestOppoProvider$getSplashAd$splashAd$1
            @Override // com.heytap.msp.mobad.api.listener.IHotSplashListener
            public void onAdClick() throws JSONException {
                WifiLog.d("splashAd oppo onAdClick");
                NestOppoNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_CLICK);
                SplashShowListener splashShowListener = nestAdData.getSplashShowListener();
                if (splashShowListener != null) {
                    splashShowListener.onAdClicked(SDKAlias.OPPO.getType(), nestAdData);
                }
            }

            @Override // com.heytap.msp.mobad.api.listener.IHotSplashListener
            public void onAdDismissed() throws JSONException {
                WifiLog.d("splashAd oppo onAdSkip");
                SplashShowListener splashShowListener = nestAdData.getSplashShowListener();
                if (splashShowListener != null) {
                    splashShowListener.onAdSkip(SDKAlias.OPPO.getType(), nestAdData);
                }
                NestOppoNativeView.INSTANCE.onEvent(nestAdData, "nest_sdk_cancle_click");
            }

            @Override // com.heytap.msp.mobad.api.listener.IHotSplashListener
            public void onAdFailed(int p0, String p1) {
                WifiLog.d("splashAd oppo onAdFailed p0 " + p0 + " p1 " + p1);
                if (p1 == null) {
                    p1 = "";
                }
                IStrategyListener iStrategyListener = listener;
                if (iStrategyListener != null) {
                    iStrategyListener.onAdFailed(nestAdData, p1, 0);
                }
                EventReporter eventReporter2 = EventReporter.INSTANCE;
                NestAdData nestAdData2 = nestAdData;
                EventParams.Builder builder2 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder2, "builder");
                eventReporter2.reportNoRespDi(nestAdData2, builder2, String.valueOf(p0), p1);
                this.this$0.onNestAdUnLoad(nestAdData);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.heytap.msp.mobad.api.listener.IHotSplashListener
            public void onAdReady() {
                T t = objectRef.element;
                if (((HotSplashAd) t) == null) {
                    return;
                }
                if (((HotSplashAd) t) != null) {
                    HotSplashAd hotSplashAd = (HotSplashAd) t;
                    if (hotSplashAd == null) {
                        Intrinsics.throwNpe();
                    }
                    int testPriceSwitchEcpm = this.this$0.getTestPriceSwitchEcpm(hotSplashAd.getECPM(), nestAdData);
                    WifiLog.d("NestOppoProvider splashAd onADLoaded priceSwitch price " + testPriceSwitchEcpm + " code " + nestAdData.getAdCode());
                    NestOppoProvider nestOppoProvider = this.this$0;
                    NestAdData nestAdData2 = nestAdData;
                    EventParams.Builder builder2 = builder;
                    Intrinsics.checkExpressionValueIsNotNull(builder2, "builder");
                    if (nestOppoProvider.checkAdEcpmDone(testPriceSwitchEcpm, nestAdData2, builder2, listener)) {
                        return;
                    }
                    NestOppoProvider nestOppoProvider2 = this.this$0;
                    NestAdData nestAdData3 = nestAdData;
                    EventParams.Builder builder3 = builder;
                    Intrinsics.checkExpressionValueIsNotNull(builder3, "builder");
                    if (nestOppoProvider2.checkAdPriceSwitch(testPriceSwitchEcpm, nestAdData3, builder3, listener)) {
                        return;
                    }
                }
                NestOppoProvider nestOppoProvider3 = this.this$0;
                HotSplashAd hotSplashAd2 = (HotSplashAd) objectRef.element;
                if (hotSplashAd2 == null) {
                    Intrinsics.throwNpe();
                }
                String adCode = nestAdData.getAdCode();
                AdParams adParams2 = nestAdData.getAdParams();
                List listCatchOppoSensitiveInfo = nestOppoProvider3.catchOppoSensitiveInfo(hotSplashAd2, adCode, adParams2 != null ? adParams2.getExt() : null, nestAdData.getAdLevel());
                HotSplashAd hotSplashAd3 = (HotSplashAd) objectRef.element;
                if (hotSplashAd3 != null) {
                    NestAdData nestAdData4 = nestAdData;
                    nestAdData4.setDspName(NestOppoProvider.DSP_NAME);
                    nestAdData4.setAppId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.GDT)));
                    nestAdData4.setSdkFrom("oppo");
                    nestAdData4.setAdData(hotSplashAd3);
                    if (listCatchOppoSensitiveInfo != null && (!listCatchOppoSensitiveInfo.isEmpty())) {
                        nestAdData4.setSensitiveInfo((SensitiveInfo) listCatchOppoSensitiveInfo.get(0));
                    }
                    this.this$0.getAdEcpm(hotSplashAd3.getECPM(), nestAdData);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(nestAdData);
                EventReporter eventReporter2 = EventReporter.INSTANCE;
                NestAdData nestAdData5 = nestAdData;
                EventParams.Builder builder4 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder4, "builder");
                eventReporter2.reportRespDi(nestAdData5, builder4, 1);
                IStrategyListener iStrategyListener = listener;
                if (iStrategyListener != null) {
                    iStrategyListener.onAdLoaded(arrayList);
                }
                this.this$0.onNestAdLoad(nestAdData);
            }

            @Override // com.heytap.msp.mobad.api.listener.IHotSplashListener
            public void onAdShow(String p0) throws JSONException {
                WifiLog.d("splashAd oppo onADExposure");
                NestOppoNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_SHOW);
                SplashShowListener splashShowListener = nestAdData.getSplashShowListener();
                if (splashShowListener != null) {
                    splashShowListener.onAdExpose(SDKAlias.OPPO.getType(), nestAdData);
                }
            }
        }, splashAdParamsBuild);
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void getTemplateFeedAd(ActivityPacker packer, final NestAdData nestAdData, final IStrategyListener listenerStrategy) {
        String nestType;
        float oppoWidth;
        float oppoHeight;
        AdSize adSize;
        listenerStrategy.onStart(nestAdData);
        EventParams.Builder renderStyle = new EventParams.Builder().setDspName(DSP_NAME).setNestSid(nestAdData.getNestSid()).setMediaId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.OPPO))).setSrcId(String.valueOf(nestAdData.getAdCode())).setRenderStyle(nestAdData.getRenderStyle());
        AdParams adParams = nestAdData.getAdParams();
        if (adParams == null || (nestType = adParams.getNestType()) == null) {
            nestType = "";
        }
        final EventParams.Builder builder = renderStyle.setNestType(nestType).setInventoryId(nestAdData.getInventoryId()).setSdkFrom("oppo");
        EventReporter eventReporter = EventReporter.INSTANCE;
        Intrinsics.checkExpressionValueIsNotNull(builder, "builder");
        eventReporter.reportReqDi(nestAdData, builder);
        AdParams adParams2 = nestAdData.getAdParams();
        if (adParams2 == null || (adSize = adParams2.getAdSize()) == null) {
            oppoWidth = 640.0f;
            oppoHeight = 0.0f;
        } else {
            oppoWidth = adSize.getOppoWidth();
            oppoHeight = adSize.getOppoHeight();
        }
        final String adCode = nestAdData.getAdCode();
        WifiLog.d("oppoView getTemplateFeedAd codeId " + adCode);
        new NativeTempletAd(packer.getAppContext(), adCode, new NativeAdSize.Builder().setWidthInDp((int) oppoWidth).setHeightInDp((int) oppoHeight).build(), new INativeTempletAdListener() { // from class: com.wifi.oppo.ad.NestOppoProvider$getTemplateFeedAd$templateAd$1
            @Override // com.heytap.msp.mobad.api.listener.INativeTempletAdListener
            public void onAdClick(INativeTempletAdView p0) throws JSONException {
                WifiLog.d("NestOppoProvider getTemplateFeedAd codeId " + adCode);
                NestOppoNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_CLICK);
                IStrategyListener iStrategyListener = listenerStrategy;
                if (iStrategyListener != null) {
                    iStrategyListener.onAdClicked(nestAdData, SDKAlias.OPPO.getType());
                }
            }

            @Override // com.heytap.msp.mobad.api.listener.INativeTempletAdListener
            public void onAdClose(INativeTempletAdView p0) {
                WifiLog.d("NestOppoProvider getTemplateFeedAd codeId " + adCode);
                IStrategyListener iStrategyListener = listenerStrategy;
                if (iStrategyListener != null) {
                    iStrategyListener.onDislikeClicked(nestAdData, "");
                }
            }

            @Override // com.heytap.msp.mobad.api.listener.INativeTempletAdListener
            public void onAdFailed(NativeAdError p0) {
                String str;
                EventReporter eventReporter2 = EventReporter.INSTANCE;
                NestAdData nestAdData2 = nestAdData;
                EventParams.Builder builder2 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder2, "builder");
                eventReporter2.reportNoRespDi(nestAdData2, builder2, String.valueOf(p0 != null ? Integer.valueOf(p0.code) : null), p0 != null ? p0.msg : null);
                StringBuilder sb = new StringBuilder();
                sb.append("NestOppoProvider getTempletAd onError code = ");
                sb.append(p0 != null ? Integer.valueOf(p0.code) : null);
                sb.append(" message = ");
                sb.append(p0 != null ? p0.msg : null);
                WifiLog.d(sb.toString());
                IStrategyListener iStrategyListener = listenerStrategy;
                if (iStrategyListener != null) {
                    NestAdData nestAdData3 = nestAdData;
                    if (p0 == null || (str = p0.msg) == null) {
                        str = "unknown reason";
                    }
                    iStrategyListener.onAdFailed(nestAdData3, str, p0 != null ? p0.code : -1);
                }
                this.this$0.onNestAdUnLoadReport(nestAdData);
            }

            @Override // com.heytap.msp.mobad.api.listener.INativeTempletAdListener
            public void onAdShow(INativeTempletAdView p0) throws JSONException {
                WifiLog.d("NestOppoProvider getTemplateFeedAd onAdShow " + adCode);
                NestOppoNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_SHOW);
                IStrategyListener iStrategyListener = listenerStrategy;
                if (iStrategyListener != null) {
                    iStrategyListener.onAdExpose(nestAdData, SDKAlias.OPPO.getType());
                }
            }

            @Override // com.heytap.msp.mobad.api.listener.INativeTempletAdListener
            public void onAdSuccess(List<INativeTempletAdView> ads) {
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
                    WifiLog.d("NestOppoProvider getTemplateFeedAd onADLoaded priceSwitch price " + testPriceSwitchEcpm + " code " + nestAdData.getAdCode());
                    NestOppoProvider nestOppoProvider = this.this$0;
                    NestAdData nestAdData3 = nestAdData;
                    EventParams.Builder builder3 = builder;
                    Intrinsics.checkExpressionValueIsNotNull(builder3, "builder");
                    if (nestOppoProvider.checkAdEcpmDone(testPriceSwitchEcpm, nestAdData3, builder3, listenerStrategy)) {
                        return;
                    }
                    NestOppoProvider nestOppoProvider2 = this.this$0;
                    NestAdData nestAdData4 = nestAdData;
                    EventParams.Builder builder4 = builder;
                    Intrinsics.checkExpressionValueIsNotNull(builder4, "builder");
                    if (nestOppoProvider2.checkAdPriceSwitch(testPriceSwitchEcpm, nestAdData4, builder4, listenerStrategy)) {
                        return;
                    }
                }
                NestOppoProvider nestOppoProvider3 = this.this$0;
                String str = adCode;
                AdParams adParams3 = nestAdData.getAdParams();
                List listCatchOppoSensitiveInfo = nestOppoProvider3.catchOppoSensitiveInfo(ads, str, adParams3 != null ? adParams3.getExt() : null, nestAdData.getAdLevel());
                ArrayList arrayList = new ArrayList();
                for (INativeTempletAdView iNativeTempletAdView : ads) {
                    NestAdData nestAdData5 = nestAdData;
                    nestAdData5.setDspName(NestOppoProvider.DSP_NAME);
                    nestAdData5.setAppId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.GDT)));
                    nestAdData5.setSdkFrom("oppo");
                    nestAdData5.setAdData(iNativeTempletAdView);
                    if (listCatchOppoSensitiveInfo != null && (!listCatchOppoSensitiveInfo.isEmpty())) {
                        nestAdData5.setSensitiveInfo((SensitiveInfo) listCatchOppoSensitiveInfo.get(0));
                    }
                    nestAdData5.setAdView(iNativeTempletAdView.getAdView());
                    this.this$0.getAdEcpm(iNativeTempletAdView.getECPM(), nestAdData);
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
                this.this$0.onNestAdLoadReport(nestAdData);
            }

            @Override // com.heytap.msp.mobad.api.listener.INativeTempletAdListener
            public void onRenderFailed(NativeAdError p0, INativeTempletAdView p1) throws JSONException {
                int i;
                String str;
                NestOppoNativeView.Companion companion = NestOppoNativeView.INSTANCE;
                companion.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_TOSHOW_FAIL);
                if (p0 != null) {
                    i = p0.code;
                    str = p0.msg;
                    Intrinsics.checkExpressionValueIsNotNull(str, "p0.msg");
                } else {
                    i = 0;
                    str = "";
                }
                companion.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_SHOW_FAIL, i, str);
            }

            @Override // com.heytap.msp.mobad.api.listener.INativeTempletAdListener
            public void onRenderSuccess(INativeTempletAdView p0) {
            }
        }).loadAd();
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public boolean interstitialAdIsBelongTheProvider(NestAdData adObject) {
        return adObject.getAdData() instanceof InterstitialAd;
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
    public void showInterstitialAd(Activity activity, NestAdData nestAdData, PopShowListener showListener) throws JSONException {
        Object adData = nestAdData.getAdData();
        if (adData == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.heytap.msp.mobad.api.ad.InterstitialAd");
        }
        nestAdData.setPopshowListener(showListener);
        NestOppoNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_TOSHOW);
        ((InterstitialAd) adData).showAd();
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void showSplashAd(Activity activity, NestAdData nestAdData, ViewGroup container, SplashShowListener splashShowListener) throws JSONException {
        NestOppoNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_TOSHOW);
        if (activity.isFinishing()) {
            WifiLog.d("splashAd oppo showSplashAd activity is error");
            return;
        }
        WifiLog.d("splashAd oppo showSplashAd " + nestAdData.getAdData());
        if (nestAdData.getAdData() instanceof HotSplashAd) {
            Object adData = nestAdData.getAdData();
            if (adData == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.heytap.msp.mobad.api.ad.HotSplashAd");
            }
            ((HotSplashAd) adData).showAd(activity);
        }
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public boolean splashAdIsBelongTheProvider(NestAdData adObject) {
        Object adData = adObject.getAdData();
        if (adData != null) {
            return adData instanceof HotSplashAd;
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
