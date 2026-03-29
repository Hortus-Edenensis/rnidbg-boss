package com.wifi.feisuo.ad;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
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
import com.wifi.feisuo.ad.NestFeiSuoNativeView;
import com.wifi.feisuo.ad.NestFeiSuoProvider;
import com.zm.fissionsdk.api.FissionSdk;
import com.zm.fissionsdk.api.FissionSlot;
import com.zm.fissionsdk.api.interfaces.IFissionInterstitial;
import com.zm.fissionsdk.api.interfaces.IFissionLoadManager;
import com.zm.fissionsdk.api.interfaces.IFissionNative;
import com.zm.fissionsdk.api.interfaces.IFissionRewardVideo;
import com.zm.fissionsdk.api.interfaces.IFissionSplash;
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
/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 K2\u00020\u0001:\u0001KB\u0005¢\u0006\u0002\u0010\u0002JY\u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0002\u0010\u0011JW\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00130\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0002\u0010\u0011JY\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00160\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0002\u0010\u0011JQ\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0002\u0010\u001aJ\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J(\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J \u0010+\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020(H\u0016J(\u0010,\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0002J \u0010-\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020(H\u0016J\u0012\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u00020\fH\u0016J \u00101\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020(H\u0016J \u00102\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u00103\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u00104\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020!H\u0016J\u0010\u00105\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020!H\u0016J\u0010\u00106\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020!H\u0016J:\u00107\u001a\u00020\u001c2\u0010\u00108\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000eH\u0002J \u00109\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010:\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020!H\u0016J\u0010\u0010;\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\"\u0010<\u001a\u00020\u001c2\u0006\u0010=\u001a\u00020>2\u0006\u0010&\u001a\u00020!2\b\u0010?\u001a\u0004\u0018\u00010@H\u0016J\"\u0010A\u001a\u00020\u001c2\u0006\u0010=\u001a\u00020>2\u0006\u0010&\u001a\u00020!2\b\u0010?\u001a\u0004\u0018\u00010BH\u0016J(\u0010C\u001a\u00020\u001c2\u0006\u0010=\u001a\u00020>2\u0006\u0010&\u001a\u00020!2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020GH\u0016J\u0010\u0010H\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010I\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020!H\u0016J\u0010\u0010J\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020!H\u0016¨\u0006L"}, d2 = {"Lcom/wifi/feisuo/ad/NestFeiSuoProvider;", "Lcom/wifi/ad/core/provider/BaseAdProvider;", "()V", "catchExpressInterstitialAd", "", "Lcom/wifi/ad/core/entity/SensitiveInfo;", "context", "Landroid/content/Context;", "ads", "", "Lcom/zm/fissionsdk/api/interfaces/IFissionInterstitial;", "adCode", "", "ext", "", "adLevel", "", "(Landroid/content/Context;Ljava/util/List;Ljava/lang/String;Ljava/util/Map;Ljava/lang/Integer;)Ljava/util/List;", "catchExpressNativeAd", "Lcom/zm/fissionsdk/api/interfaces/IFissionNative;", "catchExpressSplashAd", "appContext", "Lcom/zm/fissionsdk/api/interfaces/IFissionSplash;", "catchRewardAd", "ad", "Lcom/zm/fissionsdk/api/interfaces/IFissionRewardVideo;", "(Landroid/content/Context;Lcom/zm/fissionsdk/api/interfaces/IFissionRewardVideo;Ljava/lang/String;Ljava/util/Map;Ljava/lang/Integer;)Ljava/util/List;", "destroyAd", "", "requestId", "feedAdIsBelongTheProvider", "", "adObject", "Lcom/wifi/ad/core/data/NestAdData;", "feedNativeAdIsBelongTheProvider", "getCorrectAd", "packer", "Lcom/wifi/ad/core/helper/ActivityPacker;", "nestAdData", "listenerStrategy", "Lcom/wifi/ad/core/strategy/IStrategyListener;", "scene", "Lcom/wifi/ad/core/strategy/LoadScene;", "getInterstitialAd", "getMainThreadCorrectAd", "getNativeFeedAd", "getNativeView", "Lcom/wifi/ad/core/custom/flow/BaseNativeView;", "adProviderType", "getSplashAd", "getTemplateFeedAd", "interstitialAdIsBelongTheProvider", "onNestAdLoad", "onNestAdUnLoad", "pauseAd", "reportSensitiveInfo", "sensitiveInfoList", "requestRewardAd", "resumeAd", "rewardAdIsBelongTheProvider", "showInterstitialAd", "activity", "Landroid/app/Activity;", "showListener", "Lcom/wifi/ad/core/listener/PopShowListener;", "showRewardAd", "Lcom/wifi/ad/core/listener/InnerRewardShowListener;", "showSplashAd", "container", "Landroid/view/ViewGroup;", "splashShowListener", "Lcom/wifi/ad/core/listener/SplashShowListener;", "splashAdIsBelongTheProvider", "startAd", "stopAd", "Companion", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
public final class NestFeiSuoProvider extends BaseAdProvider {
    public static final String DSP_NAME = "feisuo_out";
    public static final String SDK_FROM = "feisuo";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static HashMap<String, InnerRewardShowListener> showListenerMap = new HashMap<>();

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R6\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b`\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/wifi/feisuo/ad/NestFeiSuoProvider$Companion;", "", "()V", "DSP_NAME", "", "SDK_FROM", "showListenerMap", "Ljava/util/HashMap;", "Lcom/wifi/ad/core/listener/InnerRewardShowListener;", "Lkotlin/collections/HashMap;", "getShowListenerMap", "()Ljava/util/HashMap;", "setShowListenerMap", "(Ljava/util/HashMap;)V", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public final HashMap<String, InnerRewardShowListener> getShowListenerMap() {
            return NestFeiSuoProvider.showListenerMap;
        }

        public final void setShowListenerMap(HashMap<String, InnerRewardShowListener> map) {
            NestFeiSuoProvider.showListenerMap = map;
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
            iArr[LoadScene.REWARD.ordinal()] = 4;
        }
    }

    /* JADX INFO: renamed from: com.wifi.feisuo.ad.NestFeiSuoProvider$getTemplateFeedAd$2, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0016\u0010\b\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¨\u0006\f"}, d2 = {"com/wifi/feisuo/ad/NestFeiSuoProvider$getTemplateFeedAd$2", "Lcom/zm/fissionsdk/api/interfaces/IFissionLoadManager$NativeLoadListener;", "onError", "", "code", "", "msg", "", "onLoad", "ads", "", "Lcom/zm/fissionsdk/api/interfaces/IFissionNative;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
    public static final class AnonymousClass2 implements IFissionLoadManager.NativeLoadListener {
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

        @Override // com.zm.fissionsdk.api.interfaces.IFissionLoadManager.FissionLoadListener
        public void onError(int code, String msg) {
            EventReporter eventReporter = EventReporter.INSTANCE;
            NestAdData nestAdData = this.$nestAdData;
            EventParams.Builder builder = this.$builder;
            Intrinsics.checkExpressionValueIsNotNull(builder, "builder");
            eventReporter.reportNoRespDi(nestAdData, builder, String.valueOf(code), msg);
            WifiLog.d("NestFeisuoProvider getTemplateFeedAd onError code = " + code + " message = " + msg);
            IStrategyListener iStrategyListener = this.$listenerStrategy;
            if (iStrategyListener != null) {
                iStrategyListener.onAdFailed(this.$nestAdData, msg, code);
            }
            NestFeiSuoProvider.this.onNestAdUnLoadReport(this.$nestAdData);
        }

        /* JADX WARN: Type inference failed for: r0v11, types: [T, java.util.ArrayList] */
        @Override // com.zm.fissionsdk.api.interfaces.IFissionLoadManager.FissionLoadListener
        public void onLoad(final List<IFissionNative> ads) {
            WifiLog.d("NestFeisuoProvider getTemplateFeedAd onLoad");
            if (ads.isEmpty()) {
                EventReporter eventReporter = EventReporter.INSTANCE;
                NestAdData nestAdData = this.$nestAdData;
                EventParams.Builder builder = this.$builder;
                Intrinsics.checkExpressionValueIsNotNull(builder, "builder");
                eventReporter.reportNoRespDi(nestAdData, builder, "30200", "");
                IStrategyListener iStrategyListener = this.$listenerStrategy;
                if (iStrategyListener != null) {
                    iStrategyListener.onAdFailed(this.$nestAdData, "list is empty", -1);
                    return;
                }
                return;
            }
            if (!ads.isEmpty()) {
                int testPriceSwitchEcpm = NestFeiSuoProvider.this.getTestPriceSwitchEcpm(ads.get(0).getECpm(), this.$nestAdData);
                WifiLog.d("NestFeiSuoProvider checkAdEcpmDone getTemplateFeedAd priceSwitch price " + testPriceSwitchEcpm + " code " + this.$nestAdData.getAdCode());
                NestFeiSuoProvider nestFeiSuoProvider = NestFeiSuoProvider.this;
                NestAdData nestAdData2 = this.$nestAdData;
                EventParams.Builder builder2 = this.$builder;
                Intrinsics.checkExpressionValueIsNotNull(builder2, "builder");
                if (nestFeiSuoProvider.checkAdEcpmDone(testPriceSwitchEcpm, nestAdData2, builder2, this.$listenerStrategy)) {
                    return;
                }
                NestFeiSuoProvider nestFeiSuoProvider2 = NestFeiSuoProvider.this;
                NestAdData nestAdData3 = this.$nestAdData;
                EventParams.Builder builder3 = this.$builder;
                Intrinsics.checkExpressionValueIsNotNull(builder3, "builder");
                if (nestFeiSuoProvider2.checkAdPriceSwitch(testPriceSwitchEcpm, nestAdData3, builder3, this.$listenerStrategy)) {
                    return;
                }
                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                objectRef.element = new ArrayList();
                for (IFissionNative iFissionNative : ads) {
                    NestAdData nestAdData4 = this.$nestAdData;
                    nestAdData4.setDspName(NestFeiSuoProvider.DSP_NAME);
                    nestAdData4.setAppId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.FEISUO)));
                    nestAdData4.setSdkFrom("feisuo");
                    nestAdData4.setAdData(iFissionNative);
                    NestFeiSuoProvider.this.getAdEcpm(iFissionNative.getECpm(), this.$nestAdData);
                    ((List) objectRef.element).add(this.$nestAdData);
                    iFissionNative.setNativeExpressListener(new IFissionNative.NativeExpressInteractionListener() { // from class: com.wifi.feisuo.ad.NestFeiSuoProvider$getTemplateFeedAd$2$onLoad$$inlined$forEach$lambda$1
                        @Override // com.zm.fissionsdk.api.interfaces.IFissionInteractionListener
                        public void onClick(View p0) throws JSONException {
                            WifiLog.d("NestFeisuoProvider getTemplateFeedAd onClick");
                            NestFeiSuoNativeView.INSTANCE.onEvent(this.this$0.$nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_CLICK);
                            NestFeiSuoProvider.AnonymousClass2 anonymousClass2 = this.this$0;
                            IStrategyListener iStrategyListener2 = anonymousClass2.$listenerStrategy;
                            if (iStrategyListener2 != null) {
                                iStrategyListener2.onAdClicked(anonymousClass2.$nestAdData, SDKAlias.FEISUO.getType());
                            }
                        }

                        @Override // com.zm.fissionsdk.api.interfaces.IFissionNative.NativeExpressInteractionListener
                        public void onClose() {
                            WifiLog.d("NestFeisuoProvider getTemplateFeedAd onClose");
                            NestFeiSuoProvider.AnonymousClass2 anonymousClass2 = this.this$0;
                            IStrategyListener iStrategyListener2 = anonymousClass2.$listenerStrategy;
                            if (iStrategyListener2 != null) {
                                iStrategyListener2.onDislikeClicked(anonymousClass2.$nestAdData, "");
                            }
                        }

                        @Override // com.zm.fissionsdk.api.interfaces.IFissionNative.NativeInteractionListener
                        public void onCreativeClick(View p0) {
                            WifiLog.d("NestFeisuoProvider getTemplateFeedAd onCreativeClick");
                        }

                        @Override // com.zm.fissionsdk.api.interfaces.IFissionInteractionListener
                        public void onShow() throws JSONException {
                            WifiLog.d("NestFeisuoProvider getTemplateFeedAd onShow");
                            NestFeiSuoNativeView.INSTANCE.onEvent(this.this$0.$nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_SHOW);
                            NestFeiSuoProvider.AnonymousClass2 anonymousClass2 = this.this$0;
                            IStrategyListener iStrategyListener2 = anonymousClass2.$listenerStrategy;
                            if (iStrategyListener2 != null) {
                                iStrategyListener2.onAdExpose(anonymousClass2.$nestAdData, SDKAlias.FEISUO.getType());
                            }
                        }

                        @Override // com.zm.fissionsdk.api.interfaces.IFissionInteractionListener
                        public void onShowFailed(int i, String str) throws JSONException {
                            WifiLog.d("NestFeisuoProvider getTemplateFeedAd onShowFailed");
                            if (str == null) {
                                str = "";
                            }
                            NestFeiSuoNativeView.Companion companion = NestFeiSuoNativeView.INSTANCE;
                            companion.onEvent(this.this$0.$nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_TOSHOW_FAIL, i, str);
                            companion.onEvent(this.this$0.$nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_SHOW_FAIL, i, str);
                        }
                    });
                    NestAdData nestAdData5 = this.$nestAdData;
                    Context appContext = this.$packer.getAppContext();
                    Intrinsics.checkExpressionValueIsNotNull(appContext, "packer.appContext");
                    nestAdData5.setDataAdapter(new FeiSuoExpressAdDataAdapter(iFissionNative, appContext));
                    NestFeiSuoProvider nestFeiSuoProvider3 = NestFeiSuoProvider.this;
                    Context appContext2 = this.$packer.getAppContext();
                    Intrinsics.checkExpressionValueIsNotNull(appContext2, "packer.appContext");
                    String adCode = this.$nestAdData.getAdCode();
                    AdParams adParams = this.$nestAdData.getAdParams();
                    List listCatchExpressNativeAd = nestFeiSuoProvider3.catchExpressNativeAd(appContext2, ads, adCode, adParams != null ? adParams.getExt() : null, this.$nestAdData.getAdLevel());
                    List list = listCatchExpressNativeAd;
                    if (!(list == null || list.isEmpty())) {
                        this.$nestAdData.setSensitiveInfo((SensitiveInfo) listCatchExpressNativeAd.get(0));
                    }
                    EventReporter eventReporter2 = EventReporter.INSTANCE;
                    NestAdData nestAdData6 = this.$nestAdData;
                    EventParams.Builder builder4 = this.$builder;
                    Intrinsics.checkExpressionValueIsNotNull(builder4, "builder");
                    eventReporter2.reportRespDi(nestAdData6, builder4, Integer.valueOf(ads.size()).intValue());
                    IStrategyListener iStrategyListener2 = this.$listenerStrategy;
                    if (iStrategyListener2 != null) {
                        iStrategyListener2.onAdLoaded((List) objectRef.element);
                    }
                    NestFeiSuoProvider.this.onNestAdLoadReport(this.$nestAdData);
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.wifi.feisuo.ad.NestFeiSuoProvider$requestRewardAd$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016¨\u0006\u000e"}, d2 = {"com/wifi/feisuo/ad/NestFeiSuoProvider$requestRewardAd$1", "Lcom/zm/fissionsdk/api/interfaces/IFissionLoadManager$RewardVideoLoadListener;", "onError", "", "code", "", "msg", "", "onLoad", "ads", "", "Lcom/zm/fissionsdk/api/interfaces/IFissionRewardVideo;", "onMaterialCacheFailed", "onMaterialCached", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
    public static final class C13761 implements IFissionLoadManager.RewardVideoLoadListener {
        final /* synthetic */ EventParams.Builder $builder;
        final /* synthetic */ IStrategyListener $listenerStrategy;
        final /* synthetic */ Ref.ObjectRef $mFissionRewardVideo;
        final /* synthetic */ NestAdData $nestAdData;
        final /* synthetic */ ActivityPacker $packer;

        public C13761(NestAdData nestAdData, EventParams.Builder builder, IStrategyListener iStrategyListener, Ref.ObjectRef objectRef, ActivityPacker activityPacker) {
            this.$nestAdData = nestAdData;
            this.$builder = builder;
            this.$listenerStrategy = iStrategyListener;
            this.$mFissionRewardVideo = objectRef;
            this.$packer = activityPacker;
        }

        @Override // com.zm.fissionsdk.api.interfaces.IFissionLoadManager.FissionLoadListener
        public void onError(int code, String msg) {
            EventReporter eventReporter = EventReporter.INSTANCE;
            NestAdData nestAdData = this.$nestAdData;
            EventParams.Builder builder = this.$builder;
            Intrinsics.checkExpressionValueIsNotNull(builder, "builder");
            eventReporter.reportNoRespDi(nestAdData, builder, String.valueOf(code), msg);
            WifiLog.d("NestFeisuoProvider requestRewardAd onError code = " + code + " message = " + msg);
            IStrategyListener iStrategyListener = this.$listenerStrategy;
            if (iStrategyListener != null) {
                iStrategyListener.onAdFailed(this.$nestAdData, msg, code);
            }
            NestFeiSuoProvider.this.onNestAdUnLoadReport(this.$nestAdData);
        }

        /* JADX WARN: Type inference failed for: r8v2, types: [T, com.zm.fissionsdk.api.interfaces.IFissionRewardVideo] */
        @Override // com.zm.fissionsdk.api.interfaces.IFissionLoadManager.FissionLoadListener
        public void onLoad(List<IFissionRewardVideo> ads) {
            WifiLog.d("NestFeisuoProvider requestRewardAd onLoad");
            List<IFissionRewardVideo> list = ads;
            if (list == null || list.isEmpty()) {
                EventReporter eventReporter = EventReporter.INSTANCE;
                NestAdData nestAdData = this.$nestAdData;
                EventParams.Builder builder = this.$builder;
                Intrinsics.checkExpressionValueIsNotNull(builder, "builder");
                eventReporter.reportNoRespDi(nestAdData, builder, "30200", "");
                IStrategyListener iStrategyListener = this.$listenerStrategy;
                if (iStrategyListener != null) {
                    iStrategyListener.onAdFailed(this.$nestAdData, "list is empty", -1);
                    return;
                }
                return;
            }
            int testPriceSwitchEcpm = NestFeiSuoProvider.this.getTestPriceSwitchEcpm(ads.get(0).getECpm(), this.$nestAdData);
            WifiLog.d("NestFeiSuoProvider checkAdEcpmDone requestRewardAd priceSwitch price " + testPriceSwitchEcpm + " code " + this.$nestAdData.getAdCode());
            NestFeiSuoProvider nestFeiSuoProvider = NestFeiSuoProvider.this;
            NestAdData nestAdData2 = this.$nestAdData;
            EventParams.Builder builder2 = this.$builder;
            Intrinsics.checkExpressionValueIsNotNull(builder2, "builder");
            if (nestFeiSuoProvider.checkAdEcpmDone(testPriceSwitchEcpm, nestAdData2, builder2, this.$listenerStrategy)) {
                return;
            }
            NestFeiSuoProvider nestFeiSuoProvider2 = NestFeiSuoProvider.this;
            NestAdData nestAdData3 = this.$nestAdData;
            EventParams.Builder builder3 = this.$builder;
            Intrinsics.checkExpressionValueIsNotNull(builder3, "builder");
            if (nestFeiSuoProvider2.checkAdPriceSwitch(testPriceSwitchEcpm, nestAdData3, builder3, this.$listenerStrategy)) {
                return;
            }
            this.$mFissionRewardVideo.element = ads.get(0);
        }

        @Override // com.zm.fissionsdk.api.interfaces.IFissionLoadManager.CacheListener
        public void onMaterialCacheFailed(int code, String msg) {
            EventReporter eventReporter = EventReporter.INSTANCE;
            NestAdData nestAdData = this.$nestAdData;
            EventParams.Builder builder = this.$builder;
            Intrinsics.checkExpressionValueIsNotNull(builder, "builder");
            eventReporter.reportNoRespDi(nestAdData, builder, String.valueOf(code), msg);
            WifiLog.d("NestFeisuoProvider getTemplateFeedAd onError code = " + code + " message = " + msg);
            IStrategyListener iStrategyListener = this.$listenerStrategy;
            if (iStrategyListener != null) {
                iStrategyListener.onAdFailed(this.$nestAdData, msg, code);
            }
            NestFeiSuoProvider.this.onNestAdUnLoadReport(this.$nestAdData);
        }

        @Override // com.zm.fissionsdk.api.interfaces.IFissionLoadManager.CacheListener
        public void onMaterialCached() {
            WifiLog.d("NestFeisuoProvider requestRewardAd onMaterialCached mFissionRewardVideo " + ((IFissionRewardVideo) this.$mFissionRewardVideo.element));
            if (((IFissionRewardVideo) this.$mFissionRewardVideo.element) == null) {
                IStrategyListener iStrategyListener = this.$listenerStrategy;
                if (iStrategyListener != null) {
                    iStrategyListener.onAdFailed(this.$nestAdData, "onMaterialCached mFissionRewardVideo == null", -2);
                    return;
                }
                return;
            }
            ArrayList arrayList = new ArrayList();
            this.$nestAdData.setDspName(NestFeiSuoProvider.DSP_NAME);
            this.$nestAdData.setAppId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.FEISUO)));
            this.$nestAdData.setSdkFrom("feisuo");
            this.$nestAdData.setAdData((IFissionRewardVideo) this.$mFissionRewardVideo.element);
            NestFeiSuoProvider nestFeiSuoProvider = NestFeiSuoProvider.this;
            IFissionRewardVideo iFissionRewardVideo = (IFissionRewardVideo) this.$mFissionRewardVideo.element;
            if (iFissionRewardVideo == null) {
                Intrinsics.throwNpe();
            }
            nestFeiSuoProvider.getAdEcpm(iFissionRewardVideo.getECpm(), this.$nestAdData);
            arrayList.add(this.$nestAdData);
            IFissionRewardVideo iFissionRewardVideo2 = (IFissionRewardVideo) this.$mFissionRewardVideo.element;
            if (iFissionRewardVideo2 == null) {
                Intrinsics.throwNpe();
            }
            iFissionRewardVideo2.setRewardInteractionListener(new IFissionRewardVideo.RewardVideoInteractionListener() { // from class: com.wifi.feisuo.ad.NestFeiSuoProvider$requestRewardAd$1$onMaterialCached$1
                @Override // com.zm.fissionsdk.api.interfaces.IFissionInteractionListener
                public void onClick(View p0) throws JSONException {
                    WifiLog.d("NestFeisuoProvider requestRewardAd onClick");
                    NestFeiSuoNativeView.INSTANCE.onEvent(this.this$0.$nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_CLICK);
                    NestFeiSuoProvider.C13761 c13761 = this.this$0;
                    IStrategyListener iStrategyListener2 = c13761.$listenerStrategy;
                    if (iStrategyListener2 != null) {
                        iStrategyListener2.onAdClicked(c13761.$nestAdData, SDKAlias.FEISUO.getType());
                    }
                }

                @Override // com.zm.fissionsdk.api.interfaces.IFissionRewardVideo.RewardVideoInteractionListener
                public void onClose() {
                    WifiLog.d("NestFeisuoProvider requestRewardAd onClose");
                    NestFeiSuoProvider.C13761 c13761 = this.this$0;
                    IStrategyListener iStrategyListener2 = c13761.$listenerStrategy;
                    if (iStrategyListener2 != null) {
                        iStrategyListener2.onDislikeClicked(c13761.$nestAdData, "");
                    }
                    InnerRewardShowListener rewardShowListener = this.this$0.$nestAdData.getRewardShowListener();
                    if (rewardShowListener != null) {
                        rewardShowListener.onAdClose(SDKAlias.FEISUO.getType(), this.this$0.$nestAdData);
                    }
                }

                @Override // com.zm.fissionsdk.api.interfaces.IFissionRewardVideo.RewardVideoInteractionListener
                public void onRewardVerify(boolean p0, int p1, Bundle p2) throws JSONException {
                    WifiLog.d("NestFeisuoProvider requestRewardAd onRewardVerify p1 " + p1 + " p0 " + p0);
                    if (p1 > 0) {
                        NestFeiSuoProvider.C13761 c13761 = this.this$0;
                        IStrategyListener iStrategyListener2 = c13761.$listenerStrategy;
                        if (iStrategyListener2 != null) {
                            iStrategyListener2.onAdRewardVerify(c13761.$nestAdData, SDKAlias.FEISUO.getType());
                        }
                        InnerRewardShowListener rewardShowListener = this.this$0.$nestAdData.getRewardShowListener();
                        if (rewardShowListener != null) {
                            rewardShowListener.onAdRewardVerify(SDKAlias.FEISUO.getType(), this.this$0.$nestAdData);
                        }
                        NestFeiSuoNativeView.INSTANCE.onEvent(this.this$0.$nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_REWARDARRIVED);
                    }
                }

                @Override // com.zm.fissionsdk.api.interfaces.IFissionInteractionListener
                public void onShow() throws JSONException {
                    WifiLog.d("NestFeisuoProvider requestRewardAd onShow");
                    NestFeiSuoNativeView.INSTANCE.onEvent(this.this$0.$nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_SHOW);
                    NestFeiSuoProvider.C13761 c13761 = this.this$0;
                    IStrategyListener iStrategyListener2 = c13761.$listenerStrategy;
                    if (iStrategyListener2 != null) {
                        iStrategyListener2.onAdExpose(c13761.$nestAdData, SDKAlias.FEISUO.getType());
                    }
                    InnerRewardShowListener rewardShowListener = this.this$0.$nestAdData.getRewardShowListener();
                    if (rewardShowListener != null) {
                        rewardShowListener.onAdExpose(SDKAlias.FEISUO.getType(), this.this$0.$nestAdData);
                    }
                }

                @Override // com.zm.fissionsdk.api.interfaces.IFissionInteractionListener
                public void onShowFailed(int p0, String p1) throws JSONException {
                    WifiLog.d("NestFeisuoProvider requestRewardAd onShowFailed");
                    if (p1 == null) {
                        p1 = "";
                    }
                    NestFeiSuoNativeView.Companion companion = NestFeiSuoNativeView.INSTANCE;
                    companion.onEvent(this.this$0.$nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_TOSHOW_FAIL, p0, p1);
                    companion.onEvent(this.this$0.$nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_SHOW_FAIL, p0, p1);
                }

                @Override // com.zm.fissionsdk.api.interfaces.IFissionRewardVideo.RewardVideoInteractionListener
                public void onVideoComplete() throws JSONException {
                    InnerRewardShowListener rewardShowListener = this.this$0.$nestAdData.getRewardShowListener();
                    if (rewardShowListener != null) {
                        rewardShowListener.onVideoComplete(SDKAlias.FEISUO.getType(), this.this$0.$nestAdData);
                    }
                    NestFeiSuoNativeView.Companion companion = NestFeiSuoNativeView.INSTANCE;
                    companion.onEvent(this.this$0.$nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_VIDEOE);
                    companion.onEvent(this.this$0.$nestAdData, WifiNestConst.EventKey.NEST_SDK_ENDPLAY_SHOW);
                }

                @Override // com.zm.fissionsdk.api.interfaces.IFissionRewardVideo.RewardVideoInteractionListener
                public void onVideoError() {
                }
            });
            NestFeiSuoProvider nestFeiSuoProvider2 = NestFeiSuoProvider.this;
            Context appContext = this.$packer.getAppContext();
            Intrinsics.checkExpressionValueIsNotNull(appContext, "packer.appContext");
            IFissionRewardVideo iFissionRewardVideo3 = (IFissionRewardVideo) this.$mFissionRewardVideo.element;
            if (iFissionRewardVideo3 == null) {
                Intrinsics.throwNpe();
            }
            String adCode = this.$nestAdData.getAdCode();
            AdParams adParams = this.$nestAdData.getAdParams();
            List listCatchRewardAd = nestFeiSuoProvider2.catchRewardAd(appContext, iFissionRewardVideo3, adCode, adParams != null ? adParams.getExt() : null, this.$nestAdData.getAdLevel());
            List list = listCatchRewardAd;
            if (!(list == null || list.isEmpty())) {
                this.$nestAdData.setSensitiveInfo((SensitiveInfo) listCatchRewardAd.get(0));
            }
            EventReporter eventReporter = EventReporter.INSTANCE;
            NestAdData nestAdData = this.$nestAdData;
            EventParams.Builder builder = this.$builder;
            Intrinsics.checkExpressionValueIsNotNull(builder, "builder");
            eventReporter.reportRespDi(nestAdData, builder, 1);
            IStrategyListener iStrategyListener2 = this.$listenerStrategy;
            if (iStrategyListener2 != null) {
                iStrategyListener2.onAdLoaded(arrayList);
            }
            NestFeiSuoProvider.this.onNestAdLoadReport(this.$nestAdData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<SensitiveInfo> catchExpressInterstitialAd(Context context, List<? extends IFissionInterstitial> ads, String adCode, Map<String, String> ext, Integer adLevel) {
        if (!WifiNestAd.INSTANCE.isCatchThirdInfo()) {
            return null;
        }
        List<SensitiveInfo> listCatchExpressInterstitialAds = FeiSuoSensitiveCatcher.INSTANCE.catchExpressInterstitialAds(ads.get(0), adLevel);
        reportSensitiveInfo(listCatchExpressInterstitialAds, adCode, ext);
        return listCatchExpressInterstitialAds;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<SensitiveInfo> catchExpressNativeAd(Context context, List<? extends IFissionNative> ads, String adCode, Map<String, String> ext, Integer adLevel) {
        if (!WifiNestAd.INSTANCE.isCatchThirdInfo()) {
            return null;
        }
        List<SensitiveInfo> listCatchExpressNativeAds = FeiSuoSensitiveCatcher.INSTANCE.catchExpressNativeAds(ads.get(0), adLevel);
        reportSensitiveInfo(listCatchExpressNativeAds, adCode, ext);
        return listCatchExpressNativeAds;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<SensitiveInfo> catchExpressSplashAd(Context appContext, List<IFissionSplash> ads, String adCode, Map<String, String> ext, Integer adLevel) {
        if (!WifiNestAd.INSTANCE.isCatchThirdInfo()) {
            return null;
        }
        List<SensitiveInfo> listCatchExpressSplashAds = FeiSuoSensitiveCatcher.INSTANCE.catchExpressSplashAds(ads.get(0), adLevel);
        reportSensitiveInfo(listCatchExpressSplashAds, adCode, ext);
        return listCatchExpressSplashAds;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<SensitiveInfo> catchRewardAd(Context context, IFissionRewardVideo ad, String adCode, Map<String, String> ext, Integer adLevel) {
        if (!WifiNestAd.INSTANCE.isCatchThirdInfo()) {
            return null;
        }
        List<SensitiveInfo> listCatchRewardAd = FeiSuoSensitiveCatcher.INSTANCE.catchRewardAd(ad, adLevel);
        reportSensitiveInfo(listCatchRewardAd, adCode, ext);
        return listCatchRewardAd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getMainThreadCorrectAd(ActivityPacker packer, NestAdData nestAdData, IStrategyListener listenerStrategy, LoadScene scene) {
        WifiLog.d("WkInitManager NestFeiSuoProvider getCorrectAd " + Thread.currentThread());
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
            WifiLog.d("feisuo getCorrectAd Exception " + e);
            if (listenerStrategy != null) {
                listenerStrategy.onAdFailed(nestAdData, "beizi request error", -10011);
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
    public boolean feedAdIsBelongTheProvider(NestAdData adObject) {
        return adObject.getAdData() instanceof IFissionNative;
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public boolean feedNativeAdIsBelongTheProvider(NestAdData adObject) {
        Object adData = adObject.getAdData();
        if (adData != null) {
            return adData instanceof IFissionNative;
        }
        return false;
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void getCorrectAd(final ActivityPacker packer, final NestAdData nestAdData, final IStrategyListener listenerStrategy, final LoadScene scene) {
        if (!NestFeiSuoManager.INSTANCE.getInitDone()) {
            listenerStrategy.onAdFailed(nestAdData, "sdk not init", -1001);
            return;
        }
        if (!RequestSDKConfig.INSTANCE.checkAllowRequest(nestAdData.getAdScene(), "feisuo")) {
            listenerStrategy.onAdFailed(nestAdData, "sdk feisuo RequestSDKConfig not allow", -1002);
            return;
        }
        Thread threadCurrentThread = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(Looper.getMainLooper(), "Looper.getMainLooper()");
        if (!Intrinsics.areEqual(threadCurrentThread, r1.getThread())) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.wifi.feisuo.ad.NestFeiSuoProvider.getCorrectAd.1
                @Override // java.lang.Runnable
                public final void run() {
                    NestFeiSuoProvider.this.getMainThreadCorrectAd(packer, nestAdData, listenerStrategy, scene);
                }
            });
        } else {
            getMainThreadCorrectAd(packer, nestAdData, listenerStrategy, scene);
        }
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void getInterstitialAd(final ActivityPacker packer, final NestAdData nestAdData, final IStrategyListener listenerStrategy) {
        String nestType;
        listenerStrategy.onStart(nestAdData);
        WifiLog.d("NestFeiSuoProvider getInterstitialAd start");
        EventParams.Builder renderStyle = new EventParams.Builder().setDspName(DSP_NAME).setNestSid(nestAdData.getNestSid()).setMediaId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.FEISUO))).setSrcId(String.valueOf(nestAdData.getAdCode())).setRenderStyle(nestAdData.getRenderStyle());
        AdParams adParams = nestAdData.getAdParams();
        if (adParams == null || (nestType = adParams.getNestType()) == null) {
            nestType = "";
        }
        final EventParams.Builder builder = renderStyle.setNestType(nestType).setInventoryId(nestAdData.getInventoryId()).setSdkFrom("feisuo");
        EventReporter eventReporter = EventReporter.INSTANCE;
        Intrinsics.checkExpressionValueIsNotNull(builder, "builder");
        eventReporter.reportReqDi(nestAdData, builder);
        FissionSdk.getLoadManager().loadInterstitial(new FissionSlot.Builder().setContext(packer.getAppContext()).setSlotType(3).setSlotId(nestAdData.getAdCode()).setCount(1).build(), new IFissionLoadManager.InterstitialLoadListener() { // from class: com.wifi.feisuo.ad.NestFeiSuoProvider.getInterstitialAd.1
            @Override // com.zm.fissionsdk.api.interfaces.IFissionLoadManager.FissionLoadListener
            public void onError(int code, String p1) {
                EventReporter eventReporter2 = EventReporter.INSTANCE;
                NestAdData nestAdData2 = nestAdData;
                EventParams.Builder builder2 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder2, "builder");
                eventReporter2.reportNoRespDi(nestAdData2, builder2, String.valueOf(code), p1);
                WifiLog.d("NestFeiSuoProvider getInterstitialAd onError code = " + code + " message = " + p1);
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

            @Override // com.zm.fissionsdk.api.interfaces.IFissionLoadManager.FissionLoadListener
            public void onLoad(List<IFissionInterstitial> ads) {
                List<IFissionInterstitial> list = ads;
                if (list == null || list.isEmpty()) {
                    EventReporter eventReporter2 = EventReporter.INSTANCE;
                    NestAdData nestAdData2 = nestAdData;
                    EventParams.Builder builder2 = builder;
                    Intrinsics.checkExpressionValueIsNotNull(builder2, "builder");
                    eventReporter2.reportNoRespDi(nestAdData2, builder2, "30200", "");
                    WifiLog.d("NestFeiSuoProvider getInterstitialAd ad is null!");
                    IStrategyListener iStrategyListener = listenerStrategy;
                    if (iStrategyListener != null) {
                        iStrategyListener.onAdFailed(nestAdData, "ad is null or empty", -1);
                        return;
                    }
                    return;
                }
                int testPriceSwitchEcpm = NestFeiSuoProvider.this.getTestPriceSwitchEcpm(ads.get(0).getECpm(), nestAdData);
                WifiLog.d("NestFeiSuoProvider checkAdEcpmDone getInterstitialAd priceSwitch price " + testPriceSwitchEcpm + " code " + nestAdData.getAdCode());
                NestFeiSuoProvider nestFeiSuoProvider = NestFeiSuoProvider.this;
                NestAdData nestAdData3 = nestAdData;
                EventParams.Builder builder3 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder3, "builder");
                if (nestFeiSuoProvider.checkAdEcpmDone(testPriceSwitchEcpm, nestAdData3, builder3, listenerStrategy)) {
                    return;
                }
                NestFeiSuoProvider nestFeiSuoProvider2 = NestFeiSuoProvider.this;
                NestAdData nestAdData4 = nestAdData;
                EventParams.Builder builder4 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder4, "builder");
                if (nestFeiSuoProvider2.checkAdPriceSwitch(testPriceSwitchEcpm, nestAdData4, builder4, listenerStrategy)) {
                    return;
                }
                IFissionInterstitial iFissionInterstitial = ads.get(0);
                if (iFissionInterstitial != null) {
                    NestAdData nestAdData5 = nestAdData;
                    nestAdData5.setDspName(NestFeiSuoProvider.DSP_NAME);
                    nestAdData5.setSdkFrom("feisuo");
                    nestAdData5.setAdData(iFissionInterstitial);
                    nestAdData5.setAppId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.FEISUO)));
                }
                NestFeiSuoProvider.this.getAdEcpm(iFissionInterstitial.getECpm(), nestAdData);
                NestFeiSuoProvider nestFeiSuoProvider3 = NestFeiSuoProvider.this;
                Context appContext = packer.getAppContext();
                Intrinsics.checkExpressionValueIsNotNull(appContext, "packer.appContext");
                String adCode = nestAdData.getAdCode();
                AdParams adParams2 = nestAdData.getAdParams();
                List listCatchExpressInterstitialAd = nestFeiSuoProvider3.catchExpressInterstitialAd(appContext, ads, adCode, adParams2 != null ? adParams2.getExt() : null, nestAdData.getAdLevel());
                List list2 = listCatchExpressInterstitialAd;
                if (!(list2 == null || list2.isEmpty())) {
                    nestAdData.setSensitiveInfo((SensitiveInfo) listCatchExpressInterstitialAd.get(0));
                }
                EventReporter eventReporter3 = EventReporter.INSTANCE;
                NestAdData nestAdData6 = nestAdData;
                EventParams.Builder builder5 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder5, "builder");
                eventReporter3.reportRespDi(nestAdData6, builder5, 1);
                ArrayList arrayList = new ArrayList();
                arrayList.add(nestAdData);
                IStrategyListener iStrategyListener2 = listenerStrategy;
                if (iStrategyListener2 != null) {
                    iStrategyListener2.onAdLoaded(arrayList);
                }
                NestFeiSuoProvider.this.onNestAdLoadReport(nestAdData);
            }

            @Override // com.zm.fissionsdk.api.interfaces.IFissionLoadManager.CacheListener
            public void onMaterialCached() {
            }

            @Override // com.zm.fissionsdk.api.interfaces.IFissionLoadManager.CacheListener
            public void onMaterialCacheFailed(int p0, String p1) {
            }
        });
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void getNativeFeedAd(final ActivityPacker packer, final NestAdData nestAdData, final IStrategyListener listenerStrategy) {
        String nestType;
        listenerStrategy.onStart(nestAdData);
        EventParams.Builder renderStyle = new EventParams.Builder().setDspName(DSP_NAME).setNestSid(nestAdData.getNestSid()).setMediaId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.FEISUO))).setSrcId(String.valueOf(nestAdData.getAdCode())).setRenderStyle(nestAdData.getRenderStyle());
        AdParams adParams = nestAdData.getAdParams();
        if (adParams == null || (nestType = adParams.getNestType()) == null) {
            nestType = "";
        }
        final EventParams.Builder builder = renderStyle.setNestType(nestType).setInventoryId(nestAdData.getInventoryId()).setSdkFrom("feisuo");
        EventReporter eventReporter = EventReporter.INSTANCE;
        Intrinsics.checkExpressionValueIsNotNull(builder, "builder");
        eventReporter.reportReqDi(nestAdData, builder);
        FissionSdk.getLoadManager().loadNative(new FissionSlot.Builder().setContext(packer.getAppContext()).setSlotType(1).setSlotId(nestAdData.getAdCode()).setCount(1).build(), new IFissionLoadManager.NativeLoadListener() { // from class: com.wifi.feisuo.ad.NestFeiSuoProvider.getNativeFeedAd.1
            @Override // com.zm.fissionsdk.api.interfaces.IFissionLoadManager.FissionLoadListener
            public void onError(int code, String message) {
                EventReporter eventReporter2 = EventReporter.INSTANCE;
                NestAdData nestAdData2 = nestAdData;
                EventParams.Builder builder2 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder2, "builder");
                eventReporter2.reportNoRespDi(nestAdData2, builder2, String.valueOf(code), message);
                WifiLog.d("NestFeiSuoProvider getNativeFeedAd onError code = " + code + " message = " + message);
                IStrategyListener iStrategyListener = listenerStrategy;
                if (iStrategyListener != null) {
                    iStrategyListener.onAdFailed(nestAdData, message, code);
                }
                NestFeiSuoProvider.this.onNestAdUnLoad(nestAdData);
            }

            @Override // com.zm.fissionsdk.api.interfaces.IFissionLoadManager.FissionLoadListener
            public void onLoad(List<IFissionNative> ads) {
                List<IFissionNative> list = ads;
                boolean z = true;
                if (list == null || list.isEmpty()) {
                    EventReporter eventReporter2 = EventReporter.INSTANCE;
                    NestAdData nestAdData2 = nestAdData;
                    EventParams.Builder builder2 = builder;
                    Intrinsics.checkExpressionValueIsNotNull(builder2, "builder");
                    eventReporter2.reportNoRespDi(nestAdData2, builder2, "30200", "");
                    WifiLog.d("NestFeiSuoProvider onFeedAdLoad ad is null!");
                    IStrategyListener iStrategyListener = listenerStrategy;
                    if (iStrategyListener != null) {
                        iStrategyListener.onAdFailed(nestAdData, "ad is null or empty", -1);
                        return;
                    }
                    return;
                }
                int testPriceSwitchEcpm = NestFeiSuoProvider.this.getTestPriceSwitchEcpm(ads.get(0).getECpm(), nestAdData);
                WifiLog.d("NestFeiSuoProvider checkAdEcpmDone getFeedAd priceSwitch price " + testPriceSwitchEcpm + " code " + nestAdData.getAdCode());
                NestFeiSuoProvider nestFeiSuoProvider = NestFeiSuoProvider.this;
                NestAdData nestAdData3 = nestAdData;
                EventParams.Builder builder3 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder3, "builder");
                if (nestFeiSuoProvider.checkAdEcpmDone(testPriceSwitchEcpm, nestAdData3, builder3, listenerStrategy)) {
                    return;
                }
                NestFeiSuoProvider nestFeiSuoProvider2 = NestFeiSuoProvider.this;
                NestAdData nestAdData4 = nestAdData;
                EventParams.Builder builder4 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder4, "builder");
                if (nestFeiSuoProvider2.checkAdPriceSwitch(testPriceSwitchEcpm, nestAdData4, builder4, listenerStrategy)) {
                    return;
                }
                WifiLog.d("NestFeiSuoProvider getNativeFeedAd onFeedAdLoad adList.size = " + ads.size());
                ArrayList arrayList = new ArrayList();
                for (IFissionNative iFissionNative : ads) {
                    NestAdData nestAdData5 = nestAdData;
                    nestAdData5.setDspName(NestFeiSuoProvider.DSP_NAME);
                    nestAdData5.setAppId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.FEISUO)));
                    nestAdData5.setSdkFrom("feisuo");
                    nestAdData5.setAdData(iFissionNative);
                    nestAdData5.setAdAppName(iFissionNative.getAppName());
                    nestAdData5.setAdAppDeveloperName(iFissionNative.getDeveloperName());
                    nestAdData5.setAdAppVersion(iFissionNative.getAppVersion());
                    nestAdData5.setAdAppPermissionsUrl(iFissionNative.getPermissionUrl());
                    nestAdData5.setAdAppPrivacyUrl(iFissionNative.getPrivacyUrl());
                    nestAdData5.setAdAppFunctionDescUrl(iFissionNative.getFunctionDescUrl());
                    Context appContext = packer.getAppContext();
                    Intrinsics.checkExpressionValueIsNotNull(appContext, "packer.appContext");
                    nestAdData5.setDataAdapter(new FeiSuoFeedDataAdapter(iFissionNative, appContext));
                    nestAdData5.setNativeAdImgWidth(iFissionNative.getMaterialWidth());
                    nestAdData5.setNativeAdImgHeight(iFissionNative.getMaterialHeight());
                    NestFeiSuoProvider.this.getAdEcpm(iFissionNative.getECpm(), nestAdData);
                    arrayList.add(nestAdData);
                }
                NestFeiSuoProvider nestFeiSuoProvider3 = NestFeiSuoProvider.this;
                Context appContext2 = packer.getAppContext();
                Intrinsics.checkExpressionValueIsNotNull(appContext2, "packer.appContext");
                String adCode = nestAdData.getAdCode();
                AdParams adParams2 = nestAdData.getAdParams();
                List listCatchExpressNativeAd = nestFeiSuoProvider3.catchExpressNativeAd(appContext2, ads, adCode, adParams2 != null ? adParams2.getExt() : null, nestAdData.getAdLevel());
                List list2 = listCatchExpressNativeAd;
                if (list2 != null && !list2.isEmpty()) {
                    z = false;
                }
                if (!z) {
                    nestAdData.setSensitiveInfo((SensitiveInfo) listCatchExpressNativeAd.get(0));
                }
                EventReporter eventReporter3 = EventReporter.INSTANCE;
                NestAdData nestAdData6 = nestAdData;
                EventParams.Builder builder5 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder5, "builder");
                eventReporter3.reportRespDi(nestAdData6, builder5, Integer.valueOf(ads.size()).intValue());
                IStrategyListener iStrategyListener2 = listenerStrategy;
                if (iStrategyListener2 != null) {
                    iStrategyListener2.onAdLoaded(arrayList);
                }
                NestFeiSuoProvider.this.onNestAdLoad(nestAdData);
            }
        });
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider
    public BaseNativeView getNativeView(String adProviderType) {
        if (Intrinsics.areEqual(SDKAlias.FEISUO.getType(), adProviderType)) {
            return new NestFeiSuoNativeView();
        }
        return null;
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void getSplashAd(final ActivityPacker packer, final NestAdData nestAdData, final IStrategyListener listenerStrategy) {
        String nestType;
        listenerStrategy.onStart(nestAdData);
        WifiLog.d("NestFeiSuoProvider getSplashAd start");
        EventParams.Builder renderStyle = new EventParams.Builder().setDspName(DSP_NAME).setNestSid(nestAdData.getNestSid()).setMediaId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.FEISUO))).setSrcId(String.valueOf(nestAdData.getAdCode())).setRenderStyle(nestAdData.getRenderStyle());
        AdParams adParams = nestAdData.getAdParams();
        if (adParams == null || (nestType = adParams.getNestType()) == null) {
            nestType = "";
        }
        final EventParams.Builder builder = renderStyle.setNestType(nestType).setInventoryId(nestAdData.getInventoryId()).setSdkFrom("feisuo");
        EventReporter eventReporter = EventReporter.INSTANCE;
        Intrinsics.checkExpressionValueIsNotNull(builder, "builder");
        eventReporter.reportReqDi(nestAdData, builder);
        FissionSdk.getLoadManager().loadSplash(new FissionSlot.Builder().setContext(packer.getAppContext()).setSlotType(2).setSlotId(nestAdData.getAdCode()).setCount(1).build(), new IFissionLoadManager.SplashLoadListener() { // from class: com.wifi.feisuo.ad.NestFeiSuoProvider.getSplashAd.1
            @Override // com.zm.fissionsdk.api.interfaces.IFissionLoadManager.FissionLoadListener
            public void onError(int code, String p1) {
                EventReporter eventReporter2 = EventReporter.INSTANCE;
                NestAdData nestAdData2 = nestAdData;
                EventParams.Builder builder2 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder2, "builder");
                eventReporter2.reportNoRespDi(nestAdData2, builder2, String.valueOf(code), p1);
                WifiLog.d("NestFeiSuoProvider getSplashAd onError code = " + code + " message = " + p1);
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

            @Override // com.zm.fissionsdk.api.interfaces.IFissionLoadManager.FissionLoadListener
            public void onLoad(List<IFissionSplash> ads) {
                List<IFissionSplash> list = ads;
                if (list == null || list.isEmpty()) {
                    EventReporter eventReporter2 = EventReporter.INSTANCE;
                    NestAdData nestAdData2 = nestAdData;
                    EventParams.Builder builder2 = builder;
                    Intrinsics.checkExpressionValueIsNotNull(builder2, "builder");
                    eventReporter2.reportNoRespDi(nestAdData2, builder2, "30200", "");
                    WifiLog.d("NestFeiSuoProvider getSplashAd ad is null!");
                    IStrategyListener iStrategyListener = listenerStrategy;
                    if (iStrategyListener != null) {
                        iStrategyListener.onAdFailed(nestAdData, "ad is null or empty", -1);
                        return;
                    }
                    return;
                }
                int testPriceSwitchEcpm = NestFeiSuoProvider.this.getTestPriceSwitchEcpm(ads.get(0).getECpm(), nestAdData);
                WifiLog.d("NestFeiSuoProvider checkAdEcpmDone getSplashAd priceSwitch price " + testPriceSwitchEcpm + " code " + nestAdData.getAdCode());
                NestFeiSuoProvider nestFeiSuoProvider = NestFeiSuoProvider.this;
                NestAdData nestAdData3 = nestAdData;
                EventParams.Builder builder3 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder3, "builder");
                if (nestFeiSuoProvider.checkAdEcpmDone(testPriceSwitchEcpm, nestAdData3, builder3, listenerStrategy)) {
                    return;
                }
                NestFeiSuoProvider nestFeiSuoProvider2 = NestFeiSuoProvider.this;
                NestAdData nestAdData4 = nestAdData;
                EventParams.Builder builder4 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder4, "builder");
                if (nestFeiSuoProvider2.checkAdPriceSwitch(testPriceSwitchEcpm, nestAdData4, builder4, listenerStrategy)) {
                    return;
                }
                IFissionSplash iFissionSplash = ads.get(0);
                if (iFissionSplash != null) {
                    NestAdData nestAdData5 = nestAdData;
                    nestAdData5.setDspName(NestFeiSuoProvider.DSP_NAME);
                    nestAdData5.setSdkFrom("feisuo");
                    nestAdData5.setAdData(iFissionSplash);
                    nestAdData5.setAppId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.FEISUO)));
                }
                NestFeiSuoProvider.this.getAdEcpm(iFissionSplash.getECpm(), nestAdData);
                NestFeiSuoProvider nestFeiSuoProvider3 = NestFeiSuoProvider.this;
                Context appContext = packer.getAppContext();
                String adCode = nestAdData.getAdCode();
                AdParams adParams2 = nestAdData.getAdParams();
                List listCatchExpressSplashAd = nestFeiSuoProvider3.catchExpressSplashAd(appContext, ads, adCode, adParams2 != null ? adParams2.getExt() : null, nestAdData.getAdLevel());
                List list2 = listCatchExpressSplashAd;
                if (!(list2 == null || list2.isEmpty())) {
                    nestAdData.setSensitiveInfo((SensitiveInfo) listCatchExpressSplashAd.get(0));
                }
                EventReporter eventReporter3 = EventReporter.INSTANCE;
                NestAdData nestAdData6 = nestAdData;
                EventParams.Builder builder5 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder5, "builder");
                eventReporter3.reportRespDi(nestAdData6, builder5, 1);
                ArrayList arrayList = new ArrayList();
                arrayList.add(nestAdData);
                IStrategyListener iStrategyListener2 = listenerStrategy;
                if (iStrategyListener2 != null) {
                    iStrategyListener2.onAdLoaded(arrayList);
                }
                NestFeiSuoProvider.this.onNestAdLoadReport(nestAdData);
            }

            @Override // com.zm.fissionsdk.api.interfaces.IFissionLoadManager.CacheListener
            public void onMaterialCached() {
            }

            @Override // com.zm.fissionsdk.api.interfaces.IFissionLoadManager.CacheListener
            public void onMaterialCacheFailed(int p0, String p1) {
            }
        });
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void getTemplateFeedAd(ActivityPacker packer, NestAdData nestAdData, IStrategyListener listenerStrategy) {
        String nestType;
        AdSize adSize;
        WifiLog.d("NestFeisuoProvider getTemplateFeedAd start");
        listenerStrategy.onStart(nestAdData);
        EventParams.Builder renderStyle = new EventParams.Builder().setDspName(DSP_NAME).setNestSid(nestAdData.getNestSid()).setMediaId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.FEISUO))).setSrcId(String.valueOf(nestAdData.getAdCode())).setRenderStyle(nestAdData.getRenderStyle());
        AdParams adParams = nestAdData.getAdParams();
        if (adParams == null || (nestType = adParams.getNestType()) == null) {
            nestType = "";
        }
        EventParams.Builder builder = renderStyle.setNestType(nestType).setInventoryId(nestAdData.getInventoryId()).setSdkFrom("feisuo");
        EventReporter eventReporter = EventReporter.INSTANCE;
        Intrinsics.checkExpressionValueIsNotNull(builder, "builder");
        eventReporter.reportReqDi(nestAdData, builder);
        AdParams adParams2 = nestAdData.getAdParams();
        if (adParams2 != null && (adSize = adParams2.getAdSize()) != null) {
            adSize.getFSWidth();
            adSize.getFSHeight();
        }
        FissionSdk.getLoadManager().loadNative(new FissionSlot.Builder().setContext(packer.getAppContext()).setSlotType(1).setSlotId(nestAdData.getAdCode()).setExpressType(1).setCount(1).build(), new AnonymousClass2(nestAdData, builder, listenerStrategy, packer));
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public boolean interstitialAdIsBelongTheProvider(NestAdData adObject) {
        Object adData = adObject.getAdData();
        if (adData != null) {
            return adData instanceof IFissionInterstitial;
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
    public void requestRewardAd(ActivityPacker packer, NestAdData nestAdData, IStrategyListener listenerStrategy) {
        String nestType;
        WifiLog.d("NestFeisuoProvider requestRewardAd start");
        listenerStrategy.onStart(nestAdData);
        EventParams.Builder renderStyle = new EventParams.Builder().setDspName(DSP_NAME).setNestSid(nestAdData.getNestSid()).setMediaId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.FEISUO))).setSrcId(String.valueOf(nestAdData.getAdCode())).setRenderStyle(nestAdData.getRenderStyle());
        AdParams adParams = nestAdData.getAdParams();
        if (adParams == null || (nestType = adParams.getNestType()) == null) {
            nestType = "";
        }
        EventParams.Builder builder = renderStyle.setNestType(nestType).setInventoryId(nestAdData.getInventoryId()).setSdkFrom("feisuo");
        EventReporter eventReporter = EventReporter.INSTANCE;
        Intrinsics.checkExpressionValueIsNotNull(builder, "builder");
        eventReporter.reportReqDi(nestAdData, builder);
        FissionSlot.Builder count = new FissionSlot.Builder().setContext(packer.getAppContext()).setSlotType(5).setSlotId(nestAdData.getAdCode()).setCount(1);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        FissionSdk.getLoadManager().loadRewardVideo(count.build(), new C13761(nestAdData, builder, listenerStrategy, objectRef, packer));
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public boolean rewardAdIsBelongTheProvider(NestAdData adObject) {
        return adObject.getAdData() instanceof IFissionRewardVideo;
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void showInterstitialAd(Activity activity, final NestAdData nestAdData, PopShowListener showListener) throws JSONException {
        Object adData = nestAdData.getAdData();
        if (adData == null || !(adData instanceof IFissionInterstitial)) {
            return;
        }
        nestAdData.setPopshowListener(showListener);
        IFissionInterstitial iFissionInterstitial = (IFissionInterstitial) adData;
        NestFeiSuoNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_TOSHOW);
        iFissionInterstitial.setInterstitialInteractionListener(new IFissionInterstitial.InterstitialInteractionListener() { // from class: com.wifi.feisuo.ad.NestFeiSuoProvider.showInterstitialAd.1
            @Override // com.zm.fissionsdk.api.interfaces.IFissionInteractionListener
            public void onClick(View p0) throws JSONException {
                WifiLog.d("NestFeiSuoProvider getInterstitialAd onAdClick");
                PopShowListener popshowListener = nestAdData.getPopshowListener();
                if (popshowListener != null) {
                    popshowListener.onAdClicked(SDKAlias.FEISUO.getType(), nestAdData);
                }
                NestFeiSuoNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_CLICK);
            }

            @Override // com.zm.fissionsdk.api.interfaces.IFissionInterstitial.InterstitialInteractionListener
            public void onClose() throws JSONException {
                WifiLog.d("NestFeiSuoProvider getInterstitialAd onAdClose");
                PopShowListener popshowListener = nestAdData.getPopshowListener();
                if (popshowListener != null) {
                    popshowListener.onAdClose(SDKAlias.FEISUO.getType(), nestAdData);
                }
                NestFeiSuoNativeView.INSTANCE.onEvent(nestAdData, "nest_sdk_cancle_click");
            }

            @Override // com.zm.fissionsdk.api.interfaces.IFissionInteractionListener
            public void onShow() throws JSONException {
                WifiLog.d("NestFeiSuoProvider getInterstitialAd onAdShow");
                PopShowListener popshowListener = nestAdData.getPopshowListener();
                if (popshowListener != null) {
                    popshowListener.onAdExpose(SDKAlias.FEISUO.getType(), nestAdData);
                }
                NestFeiSuoNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_SHOW);
            }

            @Override // com.zm.fissionsdk.api.interfaces.IFissionInteractionListener
            public void onShowFailed(int p0, String p1) throws JSONException {
                if (p1 == null) {
                    p1 = "";
                }
                NestFeiSuoNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_SHOW_FAIL, p0, p1);
            }
        });
        iFissionInterstitial.showInterstitial(activity);
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void showRewardAd(Activity activity, NestAdData nestAdData, InnerRewardShowListener showListener) throws JSONException {
        Object adData = nestAdData.getAdData();
        if (adData == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.zm.fissionsdk.api.interfaces.IFissionRewardVideo");
        }
        IFissionRewardVideo iFissionRewardVideo = (IFissionRewardVideo) adData;
        nestAdData.setRewardShowListener(showListener);
        NestFeiSuoNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_TOSHOW);
        if (nestAdData.getFsRewardMap() != null) {
            iFissionRewardVideo.addExtraInfo(nestAdData.getFsRewardMap());
        }
        iFissionRewardVideo.showReward(activity);
        WifiLog.d("NestFeisuoProvider showRewardAd success");
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void showSplashAd(Activity activity, final NestAdData nestAdData, ViewGroup container, SplashShowListener splashShowListener) throws JSONException {
        Object adData = nestAdData.getAdData();
        if (adData == null || !(adData instanceof IFissionSplash)) {
            return;
        }
        nestAdData.setSplashShowListener(splashShowListener);
        IFissionSplash iFissionSplash = (IFissionSplash) adData;
        NestFeiSuoNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_TOSHOW);
        iFissionSplash.setSplashInteractionListener(new IFissionSplash.SplashInteractionListener() { // from class: com.wifi.feisuo.ad.NestFeiSuoProvider.showSplashAd.1
            @Override // com.zm.fissionsdk.api.interfaces.IFissionInteractionListener
            public void onClick(View p0) throws JSONException {
                WifiLog.d("NestFeiSuoProvider showSplashAd onAdClick");
                SplashShowListener splashShowListener2 = nestAdData.getSplashShowListener();
                if (splashShowListener2 != null) {
                    splashShowListener2.onAdClicked(SDKAlias.FEISUO.getType(), nestAdData);
                }
                NestFeiSuoNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_CLICK);
            }

            @Override // com.zm.fissionsdk.api.interfaces.IFissionSplash.SplashInteractionListener
            public void onClose() throws JSONException {
                WifiLog.d("NestFeiSuoProvider showSplashAd onAdClose");
                if (nestAdData.getCsjSplashSkipEd().get()) {
                    return;
                }
                NestFeiSuoNativeView.INSTANCE.onEvent(nestAdData, "nest_sdk_cancle_click");
                SplashShowListener splashShowListener2 = nestAdData.getSplashShowListener();
                if (splashShowListener2 != null) {
                    splashShowListener2.onAdSkip(SDKAlias.FEISUO.getType(), nestAdData);
                }
            }

            @Override // com.zm.fissionsdk.api.interfaces.IFissionInteractionListener
            public void onShow() throws JSONException {
                WifiLog.d("NestFeiSuoProvider showSplashAd onAdShow");
                SplashShowListener splashShowListener2 = nestAdData.getSplashShowListener();
                if (splashShowListener2 != null) {
                    splashShowListener2.onAdExpose(SDKAlias.FEISUO.getType(), nestAdData);
                }
                NestFeiSuoNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_SHOW);
            }

            @Override // com.zm.fissionsdk.api.interfaces.IFissionInteractionListener
            public void onShowFailed(int p0, String p1) throws JSONException {
                if (p1 == null) {
                    p1 = "";
                }
                NestFeiSuoNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_SHOW_FAIL, p0, p1);
            }

            @Override // com.zm.fissionsdk.api.interfaces.IFissionSplash.SplashInteractionListener
            public void onSkip() throws JSONException {
                WifiLog.d("NestFeiSuoProvider showSplashAd onSkip");
                nestAdData.getCsjSplashSkipEd().set(true);
                NestFeiSuoNativeView.INSTANCE.onEvent(nestAdData, "nest_sdk_cancle_click");
                SplashShowListener splashShowListener2 = nestAdData.getSplashShowListener();
                if (splashShowListener2 != null) {
                    splashShowListener2.onAdSkip(SDKAlias.FEISUO.getType(), nestAdData);
                }
            }

            @Override // com.zm.fissionsdk.api.interfaces.IFissionSplash.SplashInteractionListener
            public void onPresent() {
            }
        });
        iFissionSplash.showSplash(container);
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public boolean splashAdIsBelongTheProvider(NestAdData adObject) {
        Object adData = adObject.getAdData();
        if (adData != null) {
            return adData instanceof IFissionSplash;
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
