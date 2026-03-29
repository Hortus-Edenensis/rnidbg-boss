package com.wifi.beizi.ad;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.beizi.fusion.AdListener;
import com.beizi.fusion.InterstitialAd;
import com.beizi.fusion.InterstitialAdListener;
import com.beizi.fusion.NativeAd;
import com.beizi.fusion.NativeAdListener;
import com.beizi.fusion.SplashAd;
import com.huawei.openalliance.ad.constant.bq;
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
import com.wifi.ad.core.listener.InnerRewardShowListener;
import com.wifi.ad.core.listener.PopShowListener;
import com.wifi.ad.core.listener.SplashShowListener;
import com.wifi.ad.core.p001const.WifiNestConst;
import com.wifi.ad.core.provider.BaseAdProvider;
import com.wifi.ad.core.reporter.EventReporter;
import com.wifi.ad.core.strategy.IStrategyListener;
import com.wifi.ad.core.strategy.LoadScene;
import com.wifi.ad.core.utils.ScreenUtil;
import com.wifi.ad.core.utils.WifiLog;
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
import org.json.JSONException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 82\u00020\u0001:\u00018B\u0005¢\u0006\u0002\u0010\u0002JK\u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0002\u0010\u000eJ\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J(\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J \u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J(\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0012\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020\tH\u0016J \u0010#\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u001bH\u0016J \u0010%\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010&\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010'\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0015H\u0016J\u0010\u0010(\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0015H\u0016J\u0010\u0010)\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0015H\u0016J\u0010\u0010*\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0015H\u0016J\"\u0010+\u001a\u00020\u00102\u0006\u0010,\u001a\u00020-2\u0006\u0010\u0019\u001a\u00020\u00152\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J(\u00100\u001a\u00020\u00102\u0006\u0010,\u001a\u00020-2\u0006\u0010\u0019\u001a\u00020\u00152\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0016J\u0010\u00105\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u00106\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0015H\u0016J\u0010\u00107\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0015H\u0016¨\u00069"}, d2 = {"Lcom/wifi/beizi/ad/NestBeiziProvider;", "Lcom/wifi/ad/core/provider/BaseAdProvider;", "()V", "catchBeiziSensitiveInfo", "", "Lcom/wifi/ad/core/entity/SensitiveInfo;", "ad", "", "codeId", "", "ext", "", "adLevel", "", "(Ljava/lang/Object;Ljava/lang/String;Ljava/util/Map;Ljava/lang/Integer;)Ljava/util/List;", "destroyAd", "", "requestId", "feedAdIsBelongTheProvider", "", "adObject", "Lcom/wifi/ad/core/data/NestAdData;", "getCorrectAd", "packer", "Lcom/wifi/ad/core/helper/ActivityPacker;", "nestAdData", "listenerStrategy", "Lcom/wifi/ad/core/strategy/IStrategyListener;", "scene", "Lcom/wifi/ad/core/strategy/LoadScene;", "getInterstitialAd", "getMainThreadCorrectAd", "getNativeView", "Lcom/wifi/ad/core/custom/flow/BaseNativeView;", "adProviderType", "getSplashAd", bq.f.s, "getTemplateFeedAd", "interstitialAdIsBelongTheProvider", "onNestAdLoad", "onNestAdUnLoad", "pauseAd", "resumeAd", "showInterstitialAd", "activity", "Landroid/app/Activity;", "showListener", "Lcom/wifi/ad/core/listener/PopShowListener;", "showSplashAd", "container", "Landroid/view/ViewGroup;", "splashShowListener", "Lcom/wifi/ad/core/listener/SplashShowListener;", "splashAdIsBelongTheProvider", "startAd", "stopAd", "Companion", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
public final class NestBeiziProvider extends BaseAdProvider {
    public static final String DSP_NAME = "beizi_out";
    public static final String SDK_FROM = "beizi";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static HashMap<String, InnerRewardShowListener> showListenerMap = new HashMap<>();

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R6\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b`\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/wifi/beizi/ad/NestBeiziProvider$Companion;", "", "()V", "DSP_NAME", "", "SDK_FROM", "showListenerMap", "Ljava/util/HashMap;", "Lcom/wifi/ad/core/listener/InnerRewardShowListener;", "Lkotlin/collections/HashMap;", "getShowListenerMap", "()Ljava/util/HashMap;", "setShowListenerMap", "(Ljava/util/HashMap;)V", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public final HashMap<String, InnerRewardShowListener> getShowListenerMap() {
            return NestBeiziProvider.showListenerMap;
        }

        public final void setShowListenerMap(HashMap<String, InnerRewardShowListener> map) {
            NestBeiziProvider.showListenerMap = map;
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
    public final List<SensitiveInfo> catchBeiziSensitiveInfo(Object ad, String codeId, Map<String, String> ext, Integer adLevel) {
        if (!WifiNestAd.INSTANCE.isCatchThirdInfo()) {
            return null;
        }
        List<SensitiveInfo> listCatchSplashAds = ad instanceof SplashAd ? BeiziSensitiveCatcher.INSTANCE.catchSplashAds((SplashAd) ad, adLevel) : ad instanceof InterstitialAd ? BeiziSensitiveCatcher.INSTANCE.catchInterstitialAds((InterstitialAd) ad, adLevel) : ad instanceof NativeAd ? BeiziSensitiveCatcher.INSTANCE.catchTempNativeAds((NativeAd) ad, adLevel) : null;
        List<SensitiveInfo> list = listCatchSplashAds;
        if (!(list == null || list.isEmpty())) {
            JSONArray jSONArray = new JSONArray();
            for (SensitiveInfo sensitiveInfo : listCatchSplashAds) {
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
        return listCatchSplashAds;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getMainThreadCorrectAd(ActivityPacker packer, NestAdData nestAdData, IStrategyListener listenerStrategy, LoadScene scene) {
        try {
            int i = WhenMappings.$EnumSwitchMapping$0[scene.ordinal()];
            if (i != 1) {
                if (i == 2) {
                    getInterstitialAd(packer, nestAdData, listenerStrategy);
                } else if (i == 3) {
                    getSplashAd(packer, nestAdData, listenerStrategy);
                }
            } else if (1 == nestAdData.getRenderStyle()) {
                nestAdData.setNativeAd(true);
                getNativeFeedAd(packer, nestAdData, listenerStrategy);
            } else {
                getTemplateFeedAd(packer, nestAdData, listenerStrategy);
            }
        } catch (Exception e) {
            WifiLog.d("beizi getCorrectAd Exception " + e);
            if (listenerStrategy != null) {
                listenerStrategy.onAdFailed(nestAdData, "beizi request error", -10011);
            }
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
    public boolean feedAdIsBelongTheProvider(NestAdData adObject) {
        Object adData = adObject.getAdData();
        if (adData != null) {
            return adData instanceof NativeAd;
        }
        return false;
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void getCorrectAd(final ActivityPacker packer, final NestAdData nestAdData, final IStrategyListener listenerStrategy, final LoadScene scene) {
        if (!NestBeiziManager.INSTANCE.getInitDone()) {
            listenerStrategy.onAdFailed(nestAdData, "sdk not init", -1001);
            return;
        }
        if (!RequestSDKConfig.INSTANCE.checkAllowRequest(nestAdData.getAdScene(), "beizi")) {
            listenerStrategy.onAdFailed(nestAdData, "sdk beizi RequestSDKConfig not allow", -1002);
            return;
        }
        Thread threadCurrentThread = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(Looper.getMainLooper(), "Looper.getMainLooper()");
        if (!Intrinsics.areEqual(threadCurrentThread, r1.getThread())) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.wifi.beizi.ad.NestBeiziProvider.getCorrectAd.1
                @Override // java.lang.Runnable
                public final void run() {
                    NestBeiziProvider.this.getMainThreadCorrectAd(packer, nestAdData, listenerStrategy, scene);
                }
            });
        } else {
            getMainThreadCorrectAd(packer, nestAdData, listenerStrategy, scene);
        }
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v13, types: [T, com.beizi.fusion.InterstitialAd] */
    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void getInterstitialAd(ActivityPacker packer, final NestAdData nestAdData, final IStrategyListener listenerStrategy) {
        String nestType;
        listenerStrategy.onStart(nestAdData);
        WifiLog.d("InterstitialAd beizi getInterstitialAd");
        EventParams.Builder nestSid = new EventParams.Builder().setDspName(DSP_NAME).setNestSid(nestAdData.getNestSid());
        Map<SDKAlias, String> appIds = WifiNestAd.INSTANCE.getAppIds();
        SDKAlias sDKAlias = SDKAlias.BEIZI;
        EventParams.Builder inventoryId = nestSid.setMediaId(String.valueOf(appIds.get(sDKAlias))).setSrcId(String.valueOf(nestAdData.getAdCode())).setRenderStyle(nestAdData.getRenderStyle()).setInventoryId(nestAdData.getInventoryId());
        AdParams adParams = nestAdData.getAdParams();
        if (adParams == null || (nestType = adParams.getNestType()) == null) {
            nestType = "";
        }
        final EventParams.Builder builder = inventoryId.setNestType(nestType).setSdkFrom("beizi");
        EventReporter eventReporter = EventReporter.INSTANCE;
        Intrinsics.checkExpressionValueIsNotNull(builder, "builder");
        eventReporter.reportReqDi(nestAdData, builder);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = sDKAlias.getType();
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        objectRef2.element = null;
        InterstitialAdListener interstitialAdListener = new InterstitialAdListener() { // from class: com.wifi.beizi.ad.NestBeiziProvider$getInterstitialAd$adListener$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.beizi.fusion.InterstitialAdListener
            public void onAdClick() throws JSONException {
                WifiLog.d("beizi getInterstitialAd onAdClick");
                PopShowListener popshowListener = nestAdData.getPopshowListener();
                if (popshowListener != null) {
                    popshowListener.onAdClicked((String) objectRef.element, nestAdData);
                }
                NestBeiziNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_CLICK);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.beizi.fusion.InterstitialAdListener
            public void onAdClosed() throws JSONException {
                WifiLog.d("beizi getInterstitialAd onAdClose");
                PopShowListener popshowListener = nestAdData.getPopshowListener();
                if (popshowListener != null) {
                    popshowListener.onAdClose((String) objectRef.element, nestAdData);
                }
                NestBeiziNativeView.INSTANCE.onEvent(nestAdData, "nest_sdk_cancle_click");
            }

            @Override // com.beizi.fusion.InterstitialAdListener
            public void onAdFailed(int p0) {
                WifiLog.d("beizi getInterstitialAd onNoAd onError code = " + p0);
                EventReporter eventReporter2 = EventReporter.INSTANCE;
                NestAdData nestAdData2 = nestAdData;
                EventParams.Builder builder2 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder2, "builder");
                eventReporter2.reportNoRespDi(nestAdData2, builder2, String.valueOf(p0), String.valueOf(p0));
                IStrategyListener iStrategyListener = listenerStrategy;
                if (iStrategyListener != null) {
                    iStrategyListener.onAdFailed(nestAdData, String.valueOf(p0), p0);
                }
                this.this$0.onNestAdUnLoadReport(nestAdData);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.beizi.fusion.InterstitialAdListener
            public void onAdLoaded() {
                T t = objectRef2.element;
                if (((InterstitialAd) t) != null) {
                    InterstitialAd interstitialAd = (InterstitialAd) t;
                    if (interstitialAd == null) {
                        Intrinsics.throwNpe();
                    }
                    int testPriceSwitchEcpm = this.this$0.getTestPriceSwitchEcpm(interstitialAd.getECPM(), nestAdData);
                    WifiLog.d("NestBeiziProvider getInterstitialAd onADLoaded priceSwitch price " + testPriceSwitchEcpm + " code " + nestAdData.getAdCode());
                    NestBeiziProvider nestBeiziProvider = this.this$0;
                    NestAdData nestAdData2 = nestAdData;
                    EventParams.Builder builder2 = builder;
                    Intrinsics.checkExpressionValueIsNotNull(builder2, "builder");
                    if (nestBeiziProvider.checkAdEcpmDone(testPriceSwitchEcpm, nestAdData2, builder2, listenerStrategy)) {
                        return;
                    }
                    NestBeiziProvider nestBeiziProvider2 = this.this$0;
                    NestAdData nestAdData3 = nestAdData;
                    EventParams.Builder builder3 = builder;
                    Intrinsics.checkExpressionValueIsNotNull(builder3, "builder");
                    if (nestBeiziProvider2.checkAdPriceSwitch(testPriceSwitchEcpm, nestAdData3, builder3, listenerStrategy)) {
                        return;
                    }
                }
                NestBeiziProvider nestBeiziProvider3 = this.this$0;
                InterstitialAd interstitialAd2 = (InterstitialAd) objectRef2.element;
                String adCode = nestAdData.getAdCode();
                AdParams adParams2 = nestAdData.getAdParams();
                List listCatchBeiziSensitiveInfo = nestBeiziProvider3.catchBeiziSensitiveInfo(interstitialAd2, adCode, adParams2 != null ? adParams2.getExt() : null, nestAdData.getAdLevel());
                InterstitialAd interstitialAd3 = (InterstitialAd) objectRef2.element;
                if (interstitialAd3 != null) {
                    NestAdData nestAdData4 = nestAdData;
                    nestAdData4.setDspName(NestBeiziProvider.DSP_NAME);
                    nestAdData4.setSdkFrom("beizi");
                    nestAdData4.setAdData(interstitialAd3);
                    nestAdData4.setAppId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.BEIZI)));
                    List list = listCatchBeiziSensitiveInfo;
                    if (!(list == null || list.isEmpty())) {
                        nestAdData4.setSensitiveInfo((SensitiveInfo) listCatchBeiziSensitiveInfo.get(0));
                    }
                    this.this$0.getAdEcpm(interstitialAd3.getECPM(), nestAdData);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(nestAdData);
                EventReporter eventReporter2 = EventReporter.INSTANCE;
                NestAdData nestAdData5 = nestAdData;
                EventParams.Builder builder4 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder4, "builder");
                eventReporter2.reportRespDi(nestAdData5, builder4, 1);
                IStrategyListener iStrategyListener = listenerStrategy;
                if (iStrategyListener != null) {
                    iStrategyListener.onAdLoaded(arrayList);
                }
                this.this$0.onNestAdLoad(nestAdData);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.beizi.fusion.InterstitialAdListener
            public void onAdShown() throws JSONException {
                WifiLog.d("beizi getInterstitialAd onAdShown");
                PopShowListener popshowListener = nestAdData.getPopshowListener();
                if (popshowListener != null) {
                    popshowListener.onAdExpose((String) objectRef.element, nestAdData);
                }
                NestBeiziNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_SHOW);
            }
        };
        Activity activityIfExist = packer.getActivityIfExist();
        if (activityIfExist == null) {
            Intrinsics.throwNpe();
        }
        ?? interstitialAd = new InterstitialAd(activityIfExist, String.valueOf(nestAdData.getAdCode()), interstitialAdListener, 5000L);
        objectRef2.element = interstitialAd;
        interstitialAd.setAdVersion(1);
        interstitialAd.loadAd();
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider
    public BaseNativeView getNativeView(String adProviderType) {
        if (Intrinsics.areEqual(SDKAlias.BEIZI.getType(), adProviderType)) {
            return new NestBeiziNativeView();
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v2, types: [T, com.beizi.fusion.SplashAd] */
    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void getSplashAd(ActivityPacker packer, final NestAdData nestAdData, final IStrategyListener listener) {
        String nestType;
        int i;
        WifiLog.d("splashAd beizi getSplashAd");
        EventParams.Builder nestSid = new EventParams.Builder().setDspName(DSP_NAME).setNestSid(nestAdData.getNestSid());
        WifiNestAd wifiNestAd = WifiNestAd.INSTANCE;
        Map<SDKAlias, String> appIds = wifiNestAd.getAppIds();
        SDKAlias sDKAlias = SDKAlias.BEIZI;
        EventParams.Builder inventoryId = nestSid.setMediaId(String.valueOf(appIds.get(sDKAlias))).setSrcId(String.valueOf(nestAdData.getAdCode())).setRenderStyle(nestAdData.getRenderStyle()).setInventoryId(nestAdData.getInventoryId());
        AdParams adParams = nestAdData.getAdParams();
        if (adParams == null || (nestType = adParams.getNestType()) == null) {
            nestType = "";
        }
        final EventParams.Builder builder = inventoryId.setNestType(nestType).setSdkFrom("beizi");
        EventReporter eventReporter = EventReporter.INSTANCE;
        Intrinsics.checkExpressionValueIsNotNull(builder, "builder");
        eventReporter.reportReqDi(nestAdData, builder);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = sDKAlias.getType();
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        objectRef2.element = null;
        ?? splashAd = new SplashAd(packer.getActivityIfExist(), null, String.valueOf(nestAdData.getAdCode()), new AdListener() { // from class: com.wifi.beizi.ad.NestBeiziProvider$getSplashAd$adListener$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.beizi.fusion.AdListener
            public void onAdClicked() throws JSONException {
                SplashShowListener splashShowListener = nestAdData.getSplashShowListener();
                if (splashShowListener != null) {
                    splashShowListener.onAdClicked((String) objectRef.element, nestAdData);
                }
                NestBeiziNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_CLICK);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.beizi.fusion.AdListener
            public void onAdClosed() throws JSONException {
                NestBeiziNativeView.INSTANCE.onEvent(nestAdData, "nest_sdk_cancle_click");
                SplashShowListener splashShowListener = nestAdData.getSplashShowListener();
                if (splashShowListener != null) {
                    splashShowListener.onAdSkip((String) objectRef.element, nestAdData);
                }
            }

            @Override // com.beizi.fusion.AdListener
            public void onAdFailedToLoad(int errorCode) {
                EventReporter eventReporter2 = EventReporter.INSTANCE;
                NestAdData nestAdData2 = nestAdData;
                EventParams.Builder builder2 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder2, "builder");
                eventReporter2.reportNoRespDi(nestAdData2, builder2, String.valueOf(errorCode), String.valueOf(errorCode));
                IStrategyListener iStrategyListener = listener;
                if (iStrategyListener != null) {
                    iStrategyListener.onAdFailed(nestAdData, String.valueOf(errorCode), errorCode);
                }
                this.this$0.onNestAdUnLoad(nestAdData);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.beizi.fusion.AdListener
            public void onAdLoaded() {
                T t = objectRef2.element;
                if (((SplashAd) t) != null) {
                    SplashAd splashAd2 = (SplashAd) t;
                    if (splashAd2 == null) {
                        Intrinsics.throwNpe();
                    }
                    int testPriceSwitchEcpm = this.this$0.getTestPriceSwitchEcpm(splashAd2.getECPM(), nestAdData);
                    WifiLog.d("NestBeiziProvider splashAd onADLoaded priceSwitch price " + testPriceSwitchEcpm + " code " + nestAdData.getAdCode());
                    NestBeiziProvider nestBeiziProvider = this.this$0;
                    NestAdData nestAdData2 = nestAdData;
                    EventParams.Builder builder2 = builder;
                    Intrinsics.checkExpressionValueIsNotNull(builder2, "builder");
                    if (nestBeiziProvider.checkAdEcpmDone(testPriceSwitchEcpm, nestAdData2, builder2, listener)) {
                        return;
                    }
                    NestBeiziProvider nestBeiziProvider2 = this.this$0;
                    NestAdData nestAdData3 = nestAdData;
                    EventParams.Builder builder3 = builder;
                    Intrinsics.checkExpressionValueIsNotNull(builder3, "builder");
                    if (nestBeiziProvider2.checkAdPriceSwitch(testPriceSwitchEcpm, nestAdData3, builder3, listener)) {
                        return;
                    }
                }
                NestBeiziProvider nestBeiziProvider3 = this.this$0;
                SplashAd splashAd3 = (SplashAd) objectRef2.element;
                String adCode = nestAdData.getAdCode();
                AdParams adParams2 = nestAdData.getAdParams();
                List listCatchBeiziSensitiveInfo = nestBeiziProvider3.catchBeiziSensitiveInfo(splashAd3, adCode, adParams2 != null ? adParams2.getExt() : null, nestAdData.getAdLevel());
                ArrayList arrayList = new ArrayList();
                SplashAd splashAd4 = (SplashAd) objectRef2.element;
                if (splashAd4 != null) {
                    NestAdData nestAdData4 = nestAdData;
                    nestAdData4.setDspName(NestBeiziProvider.DSP_NAME);
                    nestAdData4.setAppId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.BEIZI)));
                    nestAdData4.setSdkFrom("beizi");
                    nestAdData4.setAdData(splashAd4);
                    List list = listCatchBeiziSensitiveInfo;
                    if (!(list == null || list.isEmpty())) {
                        nestAdData4.setSensitiveInfo(listCatchBeiziSensitiveInfo != null ? (SensitiveInfo) listCatchBeiziSensitiveInfo.get(0) : null);
                    }
                    this.this$0.getAdEcpm(splashAd4.getECPM(), nestAdData);
                }
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

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.beizi.fusion.AdListener
            public void onAdShown() throws JSONException {
                NestBeiziNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_SHOW);
                SplashShowListener splashShowListener = nestAdData.getSplashShowListener();
                if (splashShowListener != null) {
                    splashShowListener.onAdExpose((String) objectRef.element, nestAdData);
                }
            }

            @Override // com.beizi.fusion.AdListener
            public void onAdTick(long p0) {
            }
        }, 5000L);
        if (wifiNestAd.getWmPoint() == null) {
            Object systemService = packer.getAppContext().getSystemService("window");
            if (systemService == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.view.WindowManager");
            }
            wifiNestAd.setWmPoint(new Point());
            ((WindowManager) systemService).getDefaultDisplay().getRealSize(wifiNestAd.getWmPoint());
            WifiLog.d("splashAd SystemService beizi create wmPoint");
        }
        if (wifiNestAd.getWmPoint() != null) {
            Point wmPoint = wifiNestAd.getWmPoint();
            if (wmPoint == null) {
                Intrinsics.throwNpe();
            }
            i = wmPoint.y;
            WifiLog.d("splashAd SystemService beizi allHeight " + i);
        } else {
            i = TECameraUtils.CAPTURE_NORMAL;
        }
        ScreenUtil screenUtil = ScreenUtil.INSTANCE;
        Context appContext = packer.getAppContext();
        Intrinsics.checkExpressionValueIsNotNull(appContext, "packer.appContext");
        int iDp2px = (i - screenUtil.dp2px(appContext, 145.0f)) / 3;
        objectRef2.element = splashAd;
        WifiLog.d("beizi getSplashAd adHeight " + iDp2px);
        splashAd.loadAd(360, iDp2px);
    }

    /* JADX WARN: Type inference failed for: r0v13, types: [T, com.beizi.fusion.NativeAd] */
    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void getTemplateFeedAd(ActivityPacker packer, final NestAdData nestAdData, final IStrategyListener listenerStrategy) {
        String nestType;
        float bZHeight;
        float f;
        AdSize adSize;
        listenerStrategy.onStart(nestAdData);
        EventParams.Builder inventoryId = new EventParams.Builder().setDspName(DSP_NAME).setNestSid(nestAdData.getNestSid()).setMediaId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.BEIZI))).setSrcId(String.valueOf(nestAdData.getAdCode())).setRenderStyle(nestAdData.getRenderStyle()).setInventoryId(nestAdData.getInventoryId());
        AdParams adParams = nestAdData.getAdParams();
        if (adParams == null || (nestType = adParams.getNestType()) == null) {
            nestType = "";
        }
        final EventParams.Builder builder = inventoryId.setNestType(nestType).setSdkFrom("beizi");
        AdParams adParams2 = nestAdData.getAdParams();
        if (adParams2 == null || (adSize = adParams2.getAdSize()) == null) {
            bZHeight = 0.0f;
            f = 640.0f;
        } else {
            float bZWidth = adSize.getBZWidth();
            bZHeight = adSize.getBZHeight();
            f = bZWidth;
        }
        EventReporter eventReporter = EventReporter.INSTANCE;
        Intrinsics.checkExpressionValueIsNotNull(builder, "builder");
        eventReporter.reportReqDi(nestAdData, builder);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        NativeAdListener nativeAdListener = new NativeAdListener() { // from class: com.wifi.beizi.ad.NestBeiziProvider$getTemplateFeedAd$adListener$1
            @Override // com.beizi.fusion.NativeAdListener
            public void onAdClick() throws JSONException {
                WifiLog.d("beizi getTemplateFeedAd onAdClick");
                NestBeiziNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_CLICK);
                IStrategyListener iStrategyListener = listenerStrategy;
                if (iStrategyListener != null) {
                    iStrategyListener.onAdClicked(nestAdData, SDKAlias.BEIZI.getType());
                }
            }

            @Override // com.beizi.fusion.NativeAdListener
            public void onAdClosed() {
                WifiLog.d("beizi getTemplateFeedAd onAdClosed");
            }

            @Override // com.beizi.fusion.NativeAdListener
            public void onAdFailed(int p0) {
                WifiLog.d("beizi getTemplateFeedAd onError code = " + p0);
                EventReporter eventReporter2 = EventReporter.INSTANCE;
                NestAdData nestAdData2 = nestAdData;
                EventParams.Builder builder2 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder2, "builder");
                eventReporter2.reportNoRespDi(nestAdData2, builder2, String.valueOf(p0), String.valueOf(p0));
                IStrategyListener iStrategyListener = listenerStrategy;
                if (iStrategyListener != null) {
                    iStrategyListener.onAdFailed(nestAdData, String.valueOf(p0), p0);
                }
                this.this$0.onNestAdUnLoadReport(nestAdData);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.beizi.fusion.NativeAdListener
            public void onAdLoaded(View p0) {
                T t = objectRef.element;
                if (((NativeAd) t) != null) {
                    NativeAd nativeAd = (NativeAd) t;
                    if (nativeAd == null) {
                        Intrinsics.throwNpe();
                    }
                    int testPriceSwitchEcpm = this.this$0.getTestPriceSwitchEcpm(nativeAd.getECPM(), nestAdData);
                    WifiLog.d("NestBeiziProvider getTemplateFeedAd onADLoaded priceSwitch price " + testPriceSwitchEcpm + " code " + nestAdData.getAdCode());
                    NestBeiziProvider nestBeiziProvider = this.this$0;
                    NestAdData nestAdData2 = nestAdData;
                    EventParams.Builder builder2 = builder;
                    Intrinsics.checkExpressionValueIsNotNull(builder2, "builder");
                    if (nestBeiziProvider.checkAdEcpmDone(testPriceSwitchEcpm, nestAdData2, builder2, listenerStrategy)) {
                        return;
                    }
                    NestBeiziProvider nestBeiziProvider2 = this.this$0;
                    NestAdData nestAdData3 = nestAdData;
                    EventParams.Builder builder3 = builder;
                    Intrinsics.checkExpressionValueIsNotNull(builder3, "builder");
                    if (nestBeiziProvider2.checkAdPriceSwitch(testPriceSwitchEcpm, nestAdData3, builder3, listenerStrategy)) {
                        return;
                    }
                }
                NestBeiziProvider nestBeiziProvider3 = this.this$0;
                NativeAd nativeAd2 = (NativeAd) objectRef.element;
                String adCode = nestAdData.getAdCode();
                AdParams adParams3 = nestAdData.getAdParams();
                List listCatchBeiziSensitiveInfo = nestBeiziProvider3.catchBeiziSensitiveInfo(nativeAd2, adCode, adParams3 != null ? adParams3.getExt() : null, nestAdData.getAdLevel());
                NativeAd nativeAd3 = (NativeAd) objectRef.element;
                if (nativeAd3 != null) {
                    NestAdData nestAdData4 = nestAdData;
                    nestAdData4.setDspName(NestBeiziProvider.DSP_NAME);
                    nestAdData4.setSdkFrom("beizi");
                    nestAdData4.setAdData(nativeAd3);
                    nestAdData4.setAdView(p0);
                    nestAdData4.setAppId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.BEIZI)));
                    List list = listCatchBeiziSensitiveInfo;
                    if (!(list == null || list.isEmpty())) {
                        nestAdData4.setSensitiveInfo((SensitiveInfo) listCatchBeiziSensitiveInfo.get(0));
                    }
                    this.this$0.getAdEcpm(nativeAd3.getECPM(), nestAdData);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(nestAdData);
                EventReporter eventReporter2 = EventReporter.INSTANCE;
                NestAdData nestAdData5 = nestAdData;
                EventParams.Builder builder4 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder4, "builder");
                eventReporter2.reportRespDi(nestAdData5, builder4, 1);
                IStrategyListener iStrategyListener = listenerStrategy;
                if (iStrategyListener != null) {
                    iStrategyListener.onAdLoaded(arrayList);
                }
                this.this$0.onNestAdLoadReport(nestAdData);
            }

            @Override // com.beizi.fusion.NativeAdListener
            public void onAdShown() throws JSONException {
                WifiLog.d("beizi getTemplateFeedAd onAdShown");
                NestBeiziNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_SHOW);
                IStrategyListener iStrategyListener = listenerStrategy;
                if (iStrategyListener != null) {
                    iStrategyListener.onAdExpose(nestAdData, SDKAlias.BEIZI.getType());
                }
            }

            @Override // com.beizi.fusion.NativeAdListener
            public void onAdClosed(View p0) {
                WifiLog.d("beizi getTemplateFeedAd onAdClosed View " + p0);
                IStrategyListener iStrategyListener = listenerStrategy;
                if (iStrategyListener != null) {
                    iStrategyListener.onDislikeClicked(nestAdData, "");
                }
            }
        };
        Activity activityIfExist = packer.getActivityIfExist();
        if (activityIfExist == null) {
            Intrinsics.throwNpe();
        }
        ?? nativeAd = new NativeAd(activityIfExist, String.valueOf(nestAdData.getAdCode()), nativeAdListener, 5000L, 1);
        objectRef.element = nativeAd;
        nativeAd.loadAd(f, bZHeight);
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
        super.showInterstitialAd(activity, nestAdData, showListener);
        NestBeiziNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_TOSHOW);
        if (activity.isFinishing()) {
            WifiLog.d("beizi showInterstitialAd activity is error");
            return;
        }
        nestAdData.setPopshowListener(showListener);
        WifiLog.d("beizi showInterstitialAd " + nestAdData.getAdData());
        if (nestAdData.getAdData() instanceof InterstitialAd) {
            Object adData = nestAdData.getAdData();
            if (adData == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.beizi.fusion.InterstitialAd");
            }
            ((InterstitialAd) adData).showAd(activity);
        }
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void showSplashAd(Activity activity, NestAdData nestAdData, ViewGroup container, SplashShowListener splashShowListener) throws JSONException {
        NestBeiziNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_TOSHOW);
        if (activity.isFinishing()) {
            WifiLog.d("splashAd beizi showSplashAd activity is error");
            return;
        }
        if (nestAdData.getAdData() instanceof SplashAd) {
            Object adData = nestAdData.getAdData();
            if (adData == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.beizi.fusion.SplashAd");
            }
            ((SplashAd) adData).show(container);
        }
        WifiLog.d("splashAd beizi showSplashAd " + nestAdData.getAdData());
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public boolean splashAdIsBelongTheProvider(NestAdData adObject) {
        Object adData = adObject.getAdData();
        if (adData != null) {
            return adData instanceof SplashAd;
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
