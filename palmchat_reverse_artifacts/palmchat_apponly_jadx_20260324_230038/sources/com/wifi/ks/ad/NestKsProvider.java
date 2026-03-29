package com.wifi.ks.ad;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import com.huawei.openalliance.ad.constant.bq;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.model.NativeAdExtraData;
import com.kwad.sdk.api.model.SplashAdExtraData;
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
import com.wifi.ks.ad.NestKsNativeView;
import com.wifi.ks.ad.NestKsProvider;
import com.wifi.ks.ad.data.KsFeedDataAdapter;
import com.wifi.ks.ad.data.KsNativeDataAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 O2\u00020\u0001:\u0001OB\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002JE\u0010\t\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0002\u0010\u0014J*\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u0011H\u0002J\u0012\u0010\u001c\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\bH\u0016J\u0010\u0010!\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\bH\u0016J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\bH\u0016J\u0010\u0010#\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\bH\u0016J(\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020&2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J \u0010+\u001a\u00020\u00042\u0006\u0010%\u001a\u00020&2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010'\u001a\u00020(H\u0016J&\u0010,\u001a\u00020\u00042\b\b\u0001\u0010%\u001a\u00020&2\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010'\u001a\u00020(H\u0016J(\u0010-\u001a\u00020\u00042\u0006\u0010%\u001a\u00020&2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010.\u001a\u00020*2\u0006\u0010'\u001a\u00020(H\u0002J \u0010/\u001a\u00020\u00042\u0006\u0010%\u001a\u00020&2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010'\u001a\u00020(H\u0016J \u00100\u001a\u00020\u00042\u0006\u0010%\u001a\u00020&2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010'\u001a\u00020(H\u0016J\u0012\u00101\u001a\u0004\u0018\u0001022\u0006\u0010\u001b\u001a\u00020\u0011H\u0016J\u0012\u00103\u001a\u0004\u0018\u00010\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u0011J \u00104\u001a\u00020\u00042\u0006\u0010%\u001a\u00020&2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u00105\u001a\u00020(H\u0016J \u00106\u001a\u00020\u00042\u0006\u0010%\u001a\u00020&2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010'\u001a\u00020(H\u0016J\u001e\u00107\u001a\u00020\u00042\u0006\u00108\u001a\u0002092\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010'\u001a\u00020(J\u0010\u0010:\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\bH\u0016J\u0010\u0010;\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010<\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010=\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016J \u0010>\u001a\u00020\u00042\u0006\u0010%\u001a\u00020&2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010?\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010@\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\bH\u0016J\"\u0010A\u001a\u00020\u00042\u0006\u0010B\u001a\u00020C2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010DH\u0016J\"\u0010E\u001a\u00020\u00042\u0006\u0010B\u001a\u00020C2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J(\u0010F\u001a\u00020\u00042\u0006\u0010B\u001a\u00020C2\u0006\u0010G\u001a\u00020\b2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020KH\u0016J\u0010\u0010L\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\bH\u0016J\u0010\u0010M\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010N\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006P"}, d2 = {"Lcom/wifi/ks/ad/NestKsProvider;", "Lcom/wifi/ad/core/provider/BaseAdProvider;", "()V", "addShowListener", "", "showListener", "Lcom/wifi/ad/core/listener/InnerRewardShowListener;", "nestAdData", "Lcom/wifi/ad/core/data/NestAdData;", "catchKSSensitiveInfo", "ads", "", "", "adCode", "", "ext", "", "", "adLevel", "", "(Ljava/util/List;Ljava/lang/Long;Ljava/util/Map;Ljava/lang/Integer;)V", "createKsSplashView", "Landroid/view/View;", "splashAd", "Lcom/kwad/sdk/api/KsSplashScreenAd;", "context", "Landroid/content/Context;", "adProviderType", "destroyAd", "requestId", "drawAdIsBelongTheProvider", "", "adObject", "drawNativeAdIsBelongTheProvider", "feedAdIsBelongTheProvider", "feedNativeAdIsBelongTheProvider", "getCorrectAd", "packer", "Lcom/wifi/ad/core/helper/ActivityPacker;", "listenerStrategy", "Lcom/wifi/ad/core/strategy/IStrategyListener;", "scene", "Lcom/wifi/ad/core/strategy/LoadScene;", "getDrawVideoAd", "getInterstitialAd", "getNativeAd", "loadScene", "getNativeDrawVideoAd", "getNativeFeedAd", "getNativeView", "Lcom/wifi/ad/core/custom/flow/BaseNativeView;", "getShowListener", "getSplashAd", bq.f.s, "getTemplateFeedAd", "initRewardListener", "ad", "Lcom/kwad/sdk/api/KsRewardVideoAd;", "interstitialAdIsBelongTheProvider", "onNestAdLoad", "onNestAdUnLoad", "pauseAd", "requestRewardAd", "resumeAd", "rewardAdIsBelongTheProvider", "showInterstitialAd", "activity", "Landroid/app/Activity;", "Lcom/wifi/ad/core/listener/PopShowListener;", "showRewardAd", "showSplashAd", "adData", "container", "Landroid/view/ViewGroup;", "splashShowListener", "Lcom/wifi/ad/core/listener/SplashShowListener;", "splashAdIsBelongTheProvider", "startAd", "stopAd", "Companion", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
public final class NestKsProvider extends BaseAdProvider {
    public static final String DSP_NAME = "kuaishou_out";
    public static final String SDK_FROM = "kuaishou";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static HashMap<String, InnerRewardShowListener> showListenerMap = new HashMap<>();

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R&\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/wifi/ks/ad/NestKsProvider$Companion;", "", "()V", "DSP_NAME", "", "SDK_FROM", "showListenerMap", "Ljava/util/HashMap;", "Lcom/wifi/ad/core/listener/InnerRewardShowListener;", "getShowListenerMap", "()Ljava/util/HashMap;", "setShowListenerMap", "(Ljava/util/HashMap;)V", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public final HashMap<String, InnerRewardShowListener> getShowListenerMap() {
            return NestKsProvider.showListenerMap;
        }

        public final void setShowListenerMap(HashMap<String, InnerRewardShowListener> map) {
            NestKsProvider.showListenerMap = map;
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
            iArr2[LoadScene.SPLASH.ordinal()] = 3;
            iArr2[LoadScene.REWARD.ordinal()] = 4;
            iArr2[LoadScene.INTERSTITIAL.ordinal()] = 5;
        }
    }

    /* JADX INFO: renamed from: com.wifi.ks.ad.NestKsProvider$getTemplateFeedAd$2, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0016¨\u0006\f"}, d2 = {"com/wifi/ks/ad/NestKsProvider$getTemplateFeedAd$2", "Lcom/kwad/sdk/api/KsLoadManager$FeedAdListener;", "onError", "", "code", "", "msg", "", "onFeedAdLoad", "ads", "", "Lcom/kwad/sdk/api/KsFeedAd;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
    public static final class AnonymousClass2 implements KsLoadManager.FeedAdListener {
        final /* synthetic */ EventParams.Builder $builder;
        final /* synthetic */ Long $codeId;
        final /* synthetic */ IStrategyListener $listenerStrategy;
        final /* synthetic */ NestAdData $nestAdData;
        final /* synthetic */ ActivityPacker $packer;

        public AnonymousClass2(NestAdData nestAdData, EventParams.Builder builder, IStrategyListener iStrategyListener, Long l, ActivityPacker activityPacker) {
            this.$nestAdData = nestAdData;
            this.$builder = builder;
            this.$listenerStrategy = iStrategyListener;
            this.$codeId = l;
            this.$packer = activityPacker;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
        public void onError(int code, String msg) {
            EventReporter eventReporter = EventReporter.INSTANCE;
            NestAdData nestAdData = this.$nestAdData;
            EventParams.Builder builder = this.$builder;
            Intrinsics.checkExpressionValueIsNotNull(builder, "builder");
            eventReporter.reportNoRespDi(nestAdData, builder, String.valueOf(code), msg);
            WifiLog.d("NestKsProvider getTemplateFeedAd onError code = " + code + " message = " + msg);
            IStrategyListener iStrategyListener = this.$listenerStrategy;
            if (iStrategyListener != null) {
                iStrategyListener.onAdFailed(this.$nestAdData, msg, code);
            }
            NestKsProvider.this.onNestAdUnLoadReport(this.$nestAdData);
        }

        /* JADX WARN: Type inference failed for: r2v3, types: [T, java.util.ArrayList] */
        @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
        public void onFeedAdLoad(List<KsFeedAd> ads) {
            if (ads == null || ads.isEmpty()) {
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
                int testPriceSwitchEcpm = NestKsProvider.this.getTestPriceSwitchEcpm(ads.get(0).getECPM(), this.$nestAdData);
                WifiLog.d("NestKsProvider getTemplateFeedAd onADLoaded priceSwitch price " + testPriceSwitchEcpm + " code " + this.$nestAdData.getAdCode());
                NestKsProvider nestKsProvider = NestKsProvider.this;
                NestAdData nestAdData2 = this.$nestAdData;
                EventParams.Builder builder2 = this.$builder;
                Intrinsics.checkExpressionValueIsNotNull(builder2, "builder");
                if (nestKsProvider.checkAdEcpmDone(testPriceSwitchEcpm, nestAdData2, builder2, this.$listenerStrategy)) {
                    return;
                }
                NestKsProvider nestKsProvider2 = NestKsProvider.this;
                NestAdData nestAdData3 = this.$nestAdData;
                EventParams.Builder builder3 = this.$builder;
                Intrinsics.checkExpressionValueIsNotNull(builder3, "builder");
                if (nestKsProvider2.checkAdPriceSwitch(testPriceSwitchEcpm, nestAdData3, builder3, this.$listenerStrategy)) {
                    return;
                }
            }
            NestKsProvider nestKsProvider3 = NestKsProvider.this;
            Long l = this.$codeId;
            AdParams adParams = this.$nestAdData.getAdParams();
            nestKsProvider3.catchKSSensitiveInfo(ads, l, adParams != null ? adParams.getExt() : null, this.$nestAdData.getAdLevel());
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = new ArrayList();
            for (KsFeedAd ksFeedAd : ads) {
                NestAdData nestAdData4 = this.$nestAdData;
                nestAdData4.setDspName(NestKsProvider.DSP_NAME);
                nestAdData4.setAppId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.KS)));
                nestAdData4.setSdkFrom(NestKsProvider.SDK_FROM);
                nestAdData4.setAdData(ksFeedAd);
                nestAdData4.setSensitiveInfo(KsSensitiveCatcher.INSTANCE.catchKsFeedTemplateAd(ksFeedAd, this.$nestAdData.getAdLevel()));
                Context appContext = this.$packer.getAppContext();
                Intrinsics.checkExpressionValueIsNotNull(appContext, "packer.appContext");
                nestAdData4.setDataAdapter(new KsFeedDataAdapter(ksFeedAd, appContext));
                NestKsProvider.this.getAdEcpm(ksFeedAd.getECPM(), this.$nestAdData);
                ((List) objectRef.element).add(this.$nestAdData);
                ksFeedAd.setAdInteractionListener(new KsFeedAd.AdInteractionListener() { // from class: com.wifi.ks.ad.NestKsProvider$getTemplateFeedAd$2$onFeedAdLoad$$inlined$forEach$lambda$1
                    @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
                    public void onAdClicked() throws JSONException {
                        WifiLog.d("NestKsNativeView showTemplateFeedAd onAdClicked ");
                        NestKsNativeView.INSTANCE.onEvent(this.this$0.$nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_CLICK);
                        NestKsProvider.AnonymousClass2 anonymousClass2 = this.this$0;
                        IStrategyListener iStrategyListener2 = anonymousClass2.$listenerStrategy;
                        if (iStrategyListener2 != null) {
                            iStrategyListener2.onAdClicked(anonymousClass2.$nestAdData, SDKAlias.KS.getType());
                        }
                    }

                    @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
                    public void onAdShow() throws JSONException {
                        WifiLog.d("NestKsNativeView showTemplateFeedAd onAdShow ");
                        NestKsNativeView.INSTANCE.onEvent(this.this$0.$nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_SHOW);
                        NestKsProvider.AnonymousClass2 anonymousClass2 = this.this$0;
                        IStrategyListener iStrategyListener2 = anonymousClass2.$listenerStrategy;
                        if (iStrategyListener2 != null) {
                            iStrategyListener2.onAdExpose(anonymousClass2.$nestAdData, SDKAlias.KS.getType());
                        }
                    }

                    @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
                    public void onDislikeClicked() {
                        WifiLog.d("NestKsNativeView showTemplateFeedAd onDislikeClicked ");
                        NestKsProvider.AnonymousClass2 anonymousClass2 = this.this$0;
                        IStrategyListener iStrategyListener2 = anonymousClass2.$listenerStrategy;
                        if (iStrategyListener2 != null) {
                            iStrategyListener2.onDislikeClicked(anonymousClass2.$nestAdData, "");
                        }
                    }

                    @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
                    public void onDownloadTipsDialogDismiss() {
                    }

                    @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
                    public void onDownloadTipsDialogShow() {
                    }
                });
            }
            EventReporter eventReporter2 = EventReporter.INSTANCE;
            NestAdData nestAdData5 = this.$nestAdData;
            EventParams.Builder builder4 = this.$builder;
            Intrinsics.checkExpressionValueIsNotNull(builder4, "builder");
            eventReporter2.reportRespDi(nestAdData5, builder4, ads.size());
            IStrategyListener iStrategyListener2 = this.$listenerStrategy;
            if (iStrategyListener2 != null) {
                iStrategyListener2.onAdLoaded((List) objectRef.element);
            }
            NestKsProvider.this.onNestAdLoadReport(this.$nestAdData);
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
    public final void catchKSSensitiveInfo(List<? extends Object> ads, Long adCode, Map<String, String> ext, Integer adLevel) {
        if (WifiNestAd.INSTANCE.isCatchThirdInfo()) {
            List<SensitiveInfo> listCatchKsDrawVideoAds = KsSensitiveCatcher.INSTANCE.catchKsDrawVideoAds(ads, adLevel);
            List<SensitiveInfo> list = listCatchKsDrawVideoAds;
            if (list == null || list.isEmpty()) {
                return;
            }
            JSONArray jSONArray = new JSONArray();
            for (SensitiveInfo sensitiveInfo : listCatchKsDrawVideoAds) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View createKsSplashView(KsSplashScreenAd splashAd, Context context, final NestAdData nestAdData, final String adProviderType) {
        if (splashAd == null || context == null || nestAdData == null) {
            return null;
        }
        View view = splashAd.getView(context, new KsSplashScreenAd.SplashScreenAdInteractionListener() { // from class: com.wifi.ks.ad.NestKsProvider$createKsSplashView$view$1
            @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
            public void onAdClicked() throws JSONException {
                WifiLog.d("kssplashAd createKsSplashView onAdClicked");
                NestKsNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_CLICK);
                SplashShowListener splashShowListener = nestAdData.getSplashShowListener();
                if (splashShowListener != null) {
                    splashShowListener.onAdClicked(adProviderType, nestAdData);
                }
            }

            @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
            public void onAdShowEnd() throws JSONException {
                WifiLog.d("kssplashAd createKsSplashView onAdShowEnd");
                if (nestAdData.getCsjSplashSkipEd().get()) {
                    return;
                }
                NestKsNativeView.INSTANCE.onEvent(nestAdData, "nest_sdk_cancle_click");
                SplashShowListener splashShowListener = nestAdData.getSplashShowListener();
                if (splashShowListener != null) {
                    splashShowListener.onAdSkip(adProviderType, nestAdData);
                }
            }

            @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
            public void onAdShowStart() throws JSONException {
                WifiLog.d("kssplashAd createKsSplashView onAdShowStart");
                NestKsNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_SHOW);
                SplashShowListener splashShowListener = nestAdData.getSplashShowListener();
                if (splashShowListener != null) {
                    splashShowListener.onAdExpose(adProviderType, nestAdData);
                }
            }

            @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
            public void onSkippedAd() throws JSONException {
                WifiLog.d("kssplashAd createKsSplashView onSkippedAd");
                nestAdData.getCsjSplashSkipEd().set(true);
                NestKsNativeView.INSTANCE.onEvent(nestAdData, "nest_sdk_cancle_click");
                SplashShowListener splashShowListener = nestAdData.getSplashShowListener();
                if (splashShowListener != null) {
                    splashShowListener.onAdSkip(adProviderType, nestAdData);
                }
            }

            @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
            public void onDownloadTipsDialogCancel() {
            }

            @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
            public void onDownloadTipsDialogDismiss() {
            }

            @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
            public void onDownloadTipsDialogShow() {
            }

            @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
            public void onAdShowError(int p0, String p1) {
            }
        });
        WifiLog.d("kssplashAd createKsSplashView view " + view);
        return view;
    }

    private final void getNativeAd(final ActivityPacker packer, final NestAdData nestAdData, final LoadScene loadScene, final IStrategyListener listenerStrategy) {
        String nestType;
        WifiLog.d("NestKsProvider getNativeAd adLevelName = " + nestAdData.getAdLevelName() + " adCode = " + nestAdData.getAdCode() + " adLevel = " + nestAdData.getAdLevel() + " adType = " + nestAdData.getAdType());
        if (listenerStrategy != null) {
            listenerStrategy.onStart(nestAdData);
        }
        EventParams.Builder renderStyle = new EventParams.Builder().setDspName(DSP_NAME).setNestSid(nestAdData.getNestSid()).setMediaId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.KS))).setSrcId(String.valueOf(nestAdData.getAdCode())).setRenderStyle(nestAdData.getRenderStyle());
        AdParams adParams = nestAdData.getAdParams();
        if (adParams == null || (nestType = adParams.getNestType()) == null) {
            nestType = "";
        }
        final EventParams.Builder builder = renderStyle.setNestType(nestType).setInventoryId(nestAdData.getInventoryId()).setSdkFrom(SDK_FROM);
        EventReporter eventReporter = EventReporter.INSTANCE;
        Intrinsics.checkExpressionValueIsNotNull(builder, "builder");
        eventReporter.reportReqDi(nestAdData, builder);
        String adCode = nestAdData.getAdCode();
        final Long lValueOf = adCode != null ? Long.valueOf(Long.parseLong(adCode)) : null;
        NativeAdExtraData nativeAdExtraData = new NativeAdExtraData();
        nativeAdExtraData.setShowLiveStatus(1);
        nativeAdExtraData.setShowLiveStyle(1);
        KsScene ksSceneBuild = lValueOf != null ? new KsScene.Builder(lValueOf.longValue()).adNum(1).setNativeAdExtraData(nativeAdExtraData).build() : null;
        KsLoadManager loadManager = KsAdSDK.getLoadManager();
        if (ksSceneBuild != null && loadManager != null) {
            loadManager.loadNativeAd(ksSceneBuild, new KsLoadManager.NativeAdListener() { // from class: com.wifi.ks.ad.NestKsProvider.getNativeAd.1
                @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
                public void onError(int code, String msg) {
                    EventReporter eventReporter2 = EventReporter.INSTANCE;
                    NestAdData nestAdData2 = nestAdData;
                    EventParams.Builder builder2 = builder;
                    Intrinsics.checkExpressionValueIsNotNull(builder2, "builder");
                    eventReporter2.reportNoRespDi(nestAdData2, builder2, String.valueOf(code), msg);
                    WifiLog.d("NestKsProvider getNativeAd onError code = " + code + " message = " + msg);
                    IStrategyListener iStrategyListener = listenerStrategy;
                    if (iStrategyListener != null) {
                        iStrategyListener.onAdFailed(nestAdData, msg, code);
                    }
                    NestKsProvider.this.onNestAdUnLoad(nestAdData);
                }

                /* JADX WARN: Removed duplicated region for block: B:27:0x00b2  */
                @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onNativeAdLoad(List<KsNativeAd> ads) {
                    String imageUrl;
                    KsNativeDataAdapter ksNativeDataAdapter;
                    List<KsImage> imageList;
                    KsImage ksImage;
                    List<KsImage> imageList2;
                    KsImage ksImage2;
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
                        int testPriceSwitchEcpm = NestKsProvider.this.getTestPriceSwitchEcpm(ads.get(0).getECPM(), nestAdData);
                        WifiLog.d("NestKsProvider getNativeAd onADLoaded priceSwitch price " + testPriceSwitchEcpm + " code " + nestAdData.getAdCode());
                        NestKsProvider nestKsProvider = NestKsProvider.this;
                        NestAdData nestAdData3 = nestAdData;
                        EventParams.Builder builder3 = builder;
                        Intrinsics.checkExpressionValueIsNotNull(builder3, "builder");
                        if (nestKsProvider.checkAdEcpmDone(testPriceSwitchEcpm, nestAdData3, builder3, listenerStrategy)) {
                            return;
                        }
                        NestKsProvider nestKsProvider2 = NestKsProvider.this;
                        NestAdData nestAdData4 = nestAdData;
                        EventParams.Builder builder4 = builder;
                        Intrinsics.checkExpressionValueIsNotNull(builder4, "builder");
                        if (nestKsProvider2.checkAdPriceSwitch(testPriceSwitchEcpm, nestAdData4, builder4, listenerStrategy)) {
                            return;
                        }
                    }
                    NestKsProvider nestKsProvider3 = NestKsProvider.this;
                    Long l = lValueOf;
                    AdParams adParams2 = nestAdData.getAdParams();
                    nestKsProvider3.catchKSSensitiveInfo(ads, l, adParams2 != null ? adParams2.getExt() : null, nestAdData.getAdLevel());
                    KsNativeAd ksNativeAd = ads.get(0);
                    EventParams.Builder adTitle = builder.setAdTitle(ksNativeAd.getAppName());
                    List<KsImage> imageList3 = ksNativeAd.getImageList();
                    if (!(imageList3 == null || imageList3.isEmpty())) {
                        List<KsImage> imageList4 = ksNativeAd.getImageList();
                        if (imageList4 == null) {
                            Intrinsics.throwNpe();
                        }
                        KsImage ksImage3 = imageList4.get(0);
                        imageUrl = ksImage3 != null ? ksImage3.getImageUrl() : null;
                    }
                    adTitle.setAdImage(imageUrl).setAdDesc(ksNativeAd.getAdDescription());
                    WifiLog.d("NestKsProvider getNativeAd MaterialType  = " + ksNativeAd.getMaterialType());
                    ArrayList arrayList = new ArrayList();
                    for (KsNativeAd ksNativeAd2 : ads) {
                        NestAdData nestAdData5 = nestAdData;
                        nestAdData5.setDspName(NestKsProvider.DSP_NAME);
                        nestAdData5.setAppId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.KS)));
                        nestAdData5.setSdkFrom(NestKsProvider.SDK_FROM);
                        nestAdData5.setAdData(ksNativeAd2);
                        nestAdData5.setAdAppName(ksNativeAd2.getAppName());
                        nestAdData5.setAdAppDeveloperName(ksNativeAd2.getCorporationName());
                        nestAdData5.setAdAppVersion(ksNativeAd2.getAppVersion());
                        nestAdData5.setAdAppPermissionsUrl(ksNativeAd2.getPermissionInfoUrl());
                        nestAdData5.setAdAppPrivacyUrl(ksNativeAd2.getAppPrivacyUrl());
                        nestAdData5.setAdAppFunctionDescUrl(ksNativeAd2.getIntroductionInfoUrl());
                        nestAdData5.setSensitiveInfo(KsSensitiveCatcher.INSTANCE.catchKsNativeTemplateAd(ksNativeAd2, nestAdData.getAdLevel()));
                        if (WhenMappings.$EnumSwitchMapping$0[loadScene.ordinal()] != 1) {
                            ksNativeDataAdapter = null;
                        } else {
                            Context appContext = packer.getAppContext();
                            Intrinsics.checkExpressionValueIsNotNull(appContext, "packer.appContext");
                            ksNativeDataAdapter = new KsNativeDataAdapter(ksNativeAd2, appContext);
                        }
                        nestAdData5.setDataAdapter(ksNativeDataAdapter);
                        try {
                            int materialType = ksNativeAd2.getMaterialType();
                            if (materialType == 1) {
                                KsImage it = ksNativeAd2.getVideoCoverImage();
                                if (it != null) {
                                    Intrinsics.checkExpressionValueIsNotNull(it, "it");
                                    nestAdData5.setNativeAdImgHeight(it.getHeight());
                                    nestAdData5.setNativeAdImgWidth(it.getWidth());
                                }
                            } else if (materialType != 8) {
                                List<KsImage> imageList5 = ksNativeAd2.getImageList();
                                if (!(imageList5 == null || imageList5.isEmpty()) && (imageList2 = ksNativeAd2.getImageList()) != null && (ksImage2 = imageList2.get(0)) != null) {
                                    nestAdData5.setNativeAdImgHeight(ksImage2.getHeight());
                                    nestAdData5.setNativeAdImgWidth(ksImage2.getWidth());
                                }
                            } else {
                                KsImage it2 = ksNativeAd2.getVideoCoverImage();
                                if (it2 != null) {
                                    Intrinsics.checkExpressionValueIsNotNull(it2, "it");
                                    nestAdData5.setNativeAdImgHeight(it2.getHeight());
                                    nestAdData5.setNativeAdImgWidth(it2.getWidth());
                                }
                            }
                            WifiLog.d("ksORIGIN_LIVE nativeAdImgHeight " + nestAdData5.getNativeAdImgHeight() + "  nativeAdImgWidth " + nestAdData5.getNativeAdImgWidth());
                            if (nestAdData5.getNativeAdImgHeight() == 0 && nestAdData5.getNativeAdImgWidth() == 0) {
                                List<KsImage> imageList6 = ksNativeAd2.getImageList();
                                if (!(imageList6 == null || imageList6.isEmpty()) && (imageList = ksNativeAd2.getImageList()) != null && (ksImage = imageList.get(0)) != null) {
                                    nestAdData5.setNativeAdImgHeight(ksImage.getHeight());
                                    nestAdData5.setNativeAdImgWidth(ksImage.getWidth());
                                }
                                WifiLog.d("ksORIGIN_LIVE imageList nativeAdImgHeight " + nestAdData5.getNativeAdImgHeight() + "  nativeAdImgWidth " + nestAdData5.getNativeAdImgWidth());
                            }
                            if (nestAdData5.getNativeAdImgHeight() == 0 && nestAdData5.getNativeAdImgWidth() == 0) {
                                nestAdData5.setNativeAdImgHeight(ksNativeAd2.getVideoHeight());
                                nestAdData5.setNativeAdImgWidth(ksNativeAd2.getVideoWidth());
                                WifiLog.d("ksORIGIN_LIVE video nativeAdImgHeight " + nestAdData5.getNativeAdImgHeight() + "  nativeAdImgWidth " + nestAdData5.getNativeAdImgWidth());
                            }
                        } catch (Exception unused) {
                        }
                        NestKsProvider.this.getAdEcpm(ksNativeAd2.getECPM(), nestAdData);
                        if (ksNativeAd2.getMaterialType() == 8) {
                            nestAdData.setZhiboAd(Boolean.TRUE);
                        }
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
                    NestKsProvider.this.onNestAdLoad(nestAdData);
                }
            });
        } else if (listenerStrategy != null) {
            listenerStrategy.onAdFailed(nestAdData, "ksLoadManager or scene is null", 30200);
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
    public boolean drawAdIsBelongTheProvider(NestAdData adObject) {
        return adObject.getAdData() instanceof KsDrawAd;
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public boolean drawNativeAdIsBelongTheProvider(NestAdData adObject) {
        return adObject.getAdData() instanceof KsNativeAd;
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public boolean feedAdIsBelongTheProvider(NestAdData adObject) {
        return adObject.getAdData() instanceof KsFeedAd;
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public boolean feedNativeAdIsBelongTheProvider(NestAdData adObject) {
        return adObject.getAdData() instanceof KsNativeAd;
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void getCorrectAd(ActivityPacker packer, NestAdData nestAdData, IStrategyListener listenerStrategy, LoadScene scene) {
        if (!NestKsManager.INSTANCE.getInitDone()) {
            listenerStrategy.onAdFailed(nestAdData, "sdk not init", -1001);
            return;
        }
        if (!RequestSDKConfig.INSTANCE.checkAllowRequest(nestAdData.getAdScene(), "ks")) {
            listenerStrategy.onAdFailed(nestAdData, "sdk RequestSDKConfig not allow", -1002);
            return;
        }
        if (nestAdData.getAdCode() != null) {
            try {
                String adCode = nestAdData.getAdCode();
                if (adCode == null) {
                    Intrinsics.throwNpe();
                }
                Long.parseLong(adCode);
            } catch (Exception e) {
                WifiLog.d("getCorrectAd KS nestAdData.adCode " + nestAdData.getAdCode() + " Exception:" + e);
                String adCode2 = nestAdData.getAdCode();
                if (adCode2 == null) {
                    Intrinsics.throwNpe();
                }
                nestAdData.setAdCode(StringsKt__StringsJVMKt.replace$default(adCode2, " ", "", false, 4, (Object) null));
                WifiLog.d("getCorrectAd KS nestAdData.adCode end " + nestAdData.getAdCode());
            }
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
            getSplashAd(packer, nestAdData, listenerStrategy);
        } else if (i == 4) {
            requestRewardAd(packer, nestAdData, listenerStrategy);
        } else {
            if (i != 5) {
                return;
            }
            getInterstitialAd(packer, nestAdData, listenerStrategy);
        }
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void getDrawVideoAd(ActivityPacker packer, final NestAdData nestAdData, final IStrategyListener listenerStrategy) {
        String nestType;
        WifiLog.d("NestKsProvider getDrawVideoAd adLevelName = " + nestAdData.getAdLevelName() + " adCode = " + nestAdData.getAdCode() + " adLevel = " + nestAdData.getAdLevel() + " adType = " + nestAdData.getAdType());
        listenerStrategy.onStart(nestAdData);
        EventParams.Builder renderStyle = new EventParams.Builder().setDspName(DSP_NAME).setNestSid(nestAdData.getNestSid()).setMediaId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.KS))).setSrcId(String.valueOf(nestAdData.getAdCode())).setRenderStyle(nestAdData.getRenderStyle());
        AdParams adParams = nestAdData.getAdParams();
        if (adParams == null || (nestType = adParams.getNestType()) == null) {
            nestType = "";
        }
        final EventParams.Builder builder = renderStyle.setNestType(nestType).setInventoryId(nestAdData.getInventoryId()).setSdkFrom(SDK_FROM);
        EventReporter eventReporter = EventReporter.INSTANCE;
        Intrinsics.checkExpressionValueIsNotNull(builder, "builder");
        eventReporter.reportReqDi(nestAdData, builder);
        String adCode = nestAdData.getAdCode();
        final Long lValueOf = adCode != null ? Long.valueOf(Long.parseLong(adCode)) : null;
        KsScene ksSceneBuild = lValueOf != null ? new KsScene.Builder(lValueOf.longValue()).adNum(1).build() : null;
        KsLoadManager loadManager = KsAdSDK.getLoadManager();
        if (ksSceneBuild == null || loadManager == null) {
            listenerStrategy.onAdFailed(nestAdData, "ksLoadManager or scene is null", 30200);
        } else {
            loadManager.loadDrawAd(ksSceneBuild, new KsLoadManager.DrawAdListener() { // from class: com.wifi.ks.ad.NestKsProvider.getDrawVideoAd.1
                @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
                public void onDrawAdLoad(List<? extends KsDrawAd> ads) {
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
                    WifiLog.d("NestKsProvider getDrawVideoAd onDrawAdLoad adList.size = " + ads.size());
                    NestKsProvider nestKsProvider = NestKsProvider.this;
                    Long l = lValueOf;
                    AdParams adParams2 = nestAdData.getAdParams();
                    nestKsProvider.catchKSSensitiveInfo(ads, l, adParams2 != null ? adParams2.getExt() : null, nestAdData.getAdLevel());
                    ArrayList arrayList = new ArrayList();
                    for (KsDrawAd ksDrawAd : ads) {
                        NestAdData nestAdData3 = nestAdData;
                        nestAdData3.setDspName(NestKsProvider.DSP_NAME);
                        nestAdData3.setAppId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.KS)));
                        nestAdData3.setSdkFrom(NestKsProvider.SDK_FROM);
                        nestAdData3.setAdData(ksDrawAd);
                        nestAdData3.setSensitiveInfo(KsSensitiveCatcher.INSTANCE.catchKsExpressTemplateAd(ksDrawAd, nestAdData.getAdLevel()));
                        if (ksDrawAd.getECPM() > 0) {
                            nestAdData3.setAdCost(ksDrawAd.getECPM());
                        }
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
                    NestKsProvider.this.onNestAdLoad(nestAdData);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
                public void onError(int code, String msg) {
                    EventReporter eventReporter2 = EventReporter.INSTANCE;
                    NestAdData nestAdData2 = nestAdData;
                    EventParams.Builder builder2 = builder;
                    Intrinsics.checkExpressionValueIsNotNull(builder2, "builder");
                    eventReporter2.reportNoRespDi(nestAdData2, builder2, String.valueOf(code), msg);
                    WifiLog.d("NestKsProvider getDrawVideoAd onError code = " + code + " message = " + msg);
                    IStrategyListener iStrategyListener = listenerStrategy;
                    if (iStrategyListener != null) {
                        iStrategyListener.onAdFailed(nestAdData, msg, code);
                    }
                    NestKsProvider.this.onNestAdUnLoad(nestAdData);
                }
            });
        }
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void getInterstitialAd(@NonNull ActivityPacker packer, @NonNull final NestAdData nestAdData, @NonNull final IStrategyListener listenerStrategy) {
        String nestType;
        WifiLog.d("NestKsProvider 开始请求InterstitialAd ");
        listenerStrategy.onStart(nestAdData);
        EventParams.Builder renderStyle = new EventParams.Builder().setDspName(DSP_NAME).setNestSid(nestAdData.getNestSid()).setMediaId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.KS))).setSrcId(String.valueOf(nestAdData.getAdCode())).setRenderStyle(nestAdData.getRenderStyle());
        AdParams adParams = nestAdData.getAdParams();
        if (adParams == null || (nestType = adParams.getNestType()) == null) {
            nestType = "";
        }
        final EventParams.Builder builder = renderStyle.setNestType(nestType).setInventoryId(nestAdData.getInventoryId()).setSdkFrom(SDK_FROM);
        EventReporter eventReporter = EventReporter.INSTANCE;
        Intrinsics.checkExpressionValueIsNotNull(builder, "builder");
        eventReporter.reportReqDi(nestAdData, builder);
        String adCode = nestAdData.getAdCode();
        final Long lValueOf = adCode != null ? Long.valueOf(Long.parseLong(adCode)) : null;
        KsScene ksSceneBuild = lValueOf != null ? new KsScene.Builder(lValueOf.longValue()).adNum(1).build() : null;
        KsLoadManager loadManager = KsAdSDK.getLoadManager();
        if (ksSceneBuild == null || loadManager == null) {
            listenerStrategy.onAdFailed(nestAdData, "ksLoadManager or scene is null", 30200);
        } else {
            loadManager.loadInterstitialAd(ksSceneBuild, new KsLoadManager.InterstitialAdListener() { // from class: com.wifi.ks.ad.NestKsProvider.getInterstitialAd.1
                @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
                public void onError(int code, String msg) {
                    EventReporter eventReporter2 = EventReporter.INSTANCE;
                    NestAdData nestAdData2 = nestAdData;
                    EventParams.Builder builder2 = builder;
                    Intrinsics.checkExpressionValueIsNotNull(builder2, "builder");
                    eventReporter2.reportNoRespDi(nestAdData2, builder2, String.valueOf(code), msg);
                    WifiLog.d("NestKsProvider getInterstitialAd onError code = " + code + " message = " + msg);
                    IStrategyListener iStrategyListener = listenerStrategy;
                    if (iStrategyListener != null) {
                        iStrategyListener.onAdFailed(nestAdData, msg, code);
                    }
                    NestKsProvider.this.onNestAdUnLoad(nestAdData);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
                public void onInterstitialAdLoad(List<? extends KsInterstitialAd> adList) {
                    if (adList == null || adList.isEmpty()) {
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
                    if (!adList.isEmpty()) {
                        int testPriceSwitchEcpm = NestKsProvider.this.getTestPriceSwitchEcpm(adList.get(0).getECPM(), nestAdData);
                        WifiLog.d("NestKsProvider requestInterstitialAd onADLoaded priceSwitch price " + testPriceSwitchEcpm + " code " + nestAdData.getAdCode());
                        NestKsProvider nestKsProvider = NestKsProvider.this;
                        NestAdData nestAdData3 = nestAdData;
                        EventParams.Builder builder3 = builder;
                        Intrinsics.checkExpressionValueIsNotNull(builder3, "builder");
                        if (nestKsProvider.checkAdEcpmDone(testPriceSwitchEcpm, nestAdData3, builder3, listenerStrategy)) {
                            return;
                        }
                        NestKsProvider nestKsProvider2 = NestKsProvider.this;
                        NestAdData nestAdData4 = nestAdData;
                        EventParams.Builder builder4 = builder;
                        Intrinsics.checkExpressionValueIsNotNull(builder4, "builder");
                        if (nestKsProvider2.checkAdPriceSwitch(testPriceSwitchEcpm, nestAdData4, builder4, listenerStrategy)) {
                            return;
                        }
                    }
                    NestKsProvider nestKsProvider3 = NestKsProvider.this;
                    Long l = lValueOf;
                    AdParams adParams2 = nestAdData.getAdParams();
                    nestKsProvider3.catchKSSensitiveInfo(adList, l, adParams2 != null ? adParams2.getExt() : null, nestAdData.getAdLevel());
                    ArrayList arrayList = new ArrayList();
                    for (KsInterstitialAd ksInterstitialAd : adList) {
                        NestAdData nestAdData5 = nestAdData;
                        nestAdData5.setDspName(NestKsProvider.DSP_NAME);
                        nestAdData5.setAppId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.KS)));
                        nestAdData5.setSdkFrom(NestKsProvider.SDK_FROM);
                        nestAdData5.setAdData(ksInterstitialAd);
                        nestAdData5.setSensitiveInfo(KsSensitiveCatcher.INSTANCE.catchKsInterstitialAd(ksInterstitialAd, nestAdData.getAdLevel()));
                        NestKsProvider.this.getAdEcpm(ksInterstitialAd.getECPM(), nestAdData);
                        arrayList.add(nestAdData);
                    }
                    EventReporter eventReporter3 = EventReporter.INSTANCE;
                    NestAdData nestAdData6 = nestAdData;
                    EventParams.Builder builder5 = builder;
                    Intrinsics.checkExpressionValueIsNotNull(builder5, "builder");
                    eventReporter3.reportRespDi(nestAdData6, builder5, adList.size());
                    IStrategyListener iStrategyListener2 = listenerStrategy;
                    if (iStrategyListener2 != null) {
                        iStrategyListener2.onAdLoaded(arrayList);
                    }
                    NestKsProvider.this.onNestAdLoadReport(nestAdData);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
                public void onRequestResult(int adNumber) {
                }
            });
        }
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void getNativeDrawVideoAd(ActivityPacker packer, NestAdData nestAdData, IStrategyListener listenerStrategy) {
        WifiLog.d("NestKsProvider getNativeDrawVideoAd adLevelName = " + nestAdData.getAdLevelName() + " adCode = " + nestAdData.getAdCode() + " adLevel = " + nestAdData.getAdLevel() + " adType = " + nestAdData.getAdType());
        getNativeAd(packer, nestAdData, LoadScene.DRAWAD, listenerStrategy);
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void getNativeFeedAd(ActivityPacker packer, NestAdData nestAdData, IStrategyListener listenerStrategy) {
        WifiLog.d("NestKsProvider getNativeFeedAd adLevelName = " + nestAdData.getAdLevelName() + " adCode = " + nestAdData.getAdCode() + " adLevel = " + nestAdData.getAdLevel() + " adType = " + nestAdData.getAdType());
        getNativeAd(packer, nestAdData, LoadScene.FEED, listenerStrategy);
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider
    public BaseNativeView getNativeView(String adProviderType) {
        WifiLog.d("getDrawVideoAdView adProviderType = " + adProviderType);
        if (Intrinsics.areEqual(SDKAlias.KS.getType(), adProviderType)) {
            return new NestKsNativeView();
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v16, types: [T, java.lang.CharSequence, java.lang.String] */
    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void getSplashAd(final ActivityPacker packer, final NestAdData nestAdData, final IStrategyListener listener) {
        String nestType;
        try {
            WifiLog.d("kssplashAd getSplashAd");
            EventParams.Builder nestSid = new EventParams.Builder().setDspName(DSP_NAME).setNestSid(nestAdData.getNestSid());
            Map<SDKAlias, String> appIds = WifiNestAd.INSTANCE.getAppIds();
            SDKAlias sDKAlias = SDKAlias.KS;
            EventParams.Builder renderStyle = nestSid.setMediaId(String.valueOf(appIds.get(sDKAlias))).setSrcId(String.valueOf(nestAdData.getAdCode())).setRenderStyle(nestAdData.getRenderStyle());
            AdParams adParams = nestAdData.getAdParams();
            if (adParams == null || (nestType = adParams.getNestType()) == null) {
                nestType = "";
            }
            final EventParams.Builder builder = renderStyle.setNestType(nestType).setInventoryId(nestAdData.getInventoryId()).setSdkFrom(SDK_FROM);
            EventReporter eventReporter = EventReporter.INSTANCE;
            Intrinsics.checkExpressionValueIsNotNull(builder, "builder");
            eventReporter.reportReqDi(nestAdData, builder);
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = sDKAlias.getType();
            SplashAdExtraData splashAdExtraData = new SplashAdExtraData();
            splashAdExtraData.setDisableShakeStatus(true);
            final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            ?? adCode = nestAdData.getAdCode();
            objectRef2.element = adCode;
            if (TextUtils.isEmpty(adCode)) {
                return;
            }
            String str = (String) objectRef2.element;
            if (str == null) {
                Intrinsics.throwNpe();
            }
            KsScene ksSceneBuild = new KsScene.Builder(Long.parseLong(str)).setSplashExtraData(splashAdExtraData).build();
            if (KsAdSDK.getLoadManager() != null) {
                WifiLog.d("kssplashAd loadSplashScreenAd adCode " + ((String) objectRef2.element));
                KsAdSDK.getLoadManager().loadSplashScreenAd(ksSceneBuild, new KsLoadManager.SplashScreenAdListener() { // from class: com.wifi.ks.ad.NestKsProvider.getSplashAd.1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
                    public void onError(int p0, String p1) {
                        WifiLog.d("kssplashAd onError adCode " + ((String) objectRef2.element) + " code " + p0 + " msg " + p1);
                        EventReporter eventReporter2 = EventReporter.INSTANCE;
                        NestAdData nestAdData2 = nestAdData;
                        EventParams.Builder builder2 = builder;
                        Intrinsics.checkExpressionValueIsNotNull(builder2, "builder");
                        eventReporter2.reportNoRespDi(nestAdData2, builder2, String.valueOf(p0), p1);
                        IStrategyListener iStrategyListener = listener;
                        if (iStrategyListener != null) {
                            iStrategyListener.onAdFailed(nestAdData, Intrinsics.stringPlus(p1, ""), p0);
                        }
                        NestKsProvider.this.onNestAdUnLoad(nestAdData);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
                    public void onSplashScreenAdLoad(KsSplashScreenAd splashAd) {
                        if (splashAd == null) {
                            EventReporter eventReporter2 = EventReporter.INSTANCE;
                            NestAdData nestAdData2 = nestAdData;
                            EventParams.Builder builder2 = builder;
                            Intrinsics.checkExpressionValueIsNotNull(builder2, "builder");
                            eventReporter2.reportNoRespDi(nestAdData2, builder2, "请求成功，但是返回的广告为null", "");
                            IStrategyListener iStrategyListener = listener;
                            if (iStrategyListener != null) {
                                iStrategyListener.onAdFailed(nestAdData, "请求成功，但是返回的广告为null", 10001);
                            }
                            NestKsProvider.this.onNestAdUnLoad(nestAdData);
                            return;
                        }
                        int testPriceSwitchEcpm = NestKsProvider.this.getTestPriceSwitchEcpm(splashAd.getECPM(), nestAdData);
                        WifiLog.d("NestKsProvider onSplashScreenAdLoad onADLoaded priceSwitch price " + testPriceSwitchEcpm + " code " + nestAdData.getAdCode());
                        NestKsProvider nestKsProvider = NestKsProvider.this;
                        NestAdData nestAdData3 = nestAdData;
                        EventParams.Builder builder3 = builder;
                        Intrinsics.checkExpressionValueIsNotNull(builder3, "builder");
                        if (nestKsProvider.checkAdEcpmDone(testPriceSwitchEcpm, nestAdData3, builder3, listener)) {
                            return;
                        }
                        NestKsProvider nestKsProvider2 = NestKsProvider.this;
                        NestAdData nestAdData4 = nestAdData;
                        EventParams.Builder builder4 = builder;
                        Intrinsics.checkExpressionValueIsNotNull(builder4, "builder");
                        if (nestKsProvider2.checkAdPriceSwitch(testPriceSwitchEcpm, nestAdData4, builder4, listener)) {
                            return;
                        }
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(splashAd);
                        NestKsProvider nestKsProvider3 = NestKsProvider.this;
                        String str2 = (String) objectRef2.element;
                        if (str2 == null) {
                            Intrinsics.throwNpe();
                        }
                        Long lValueOf = Long.valueOf(Long.parseLong(str2));
                        AdParams adParams2 = nestAdData.getAdParams();
                        nestKsProvider3.catchKSSensitiveInfo(arrayList, lValueOf, adParams2 != null ? adParams2.getExt() : null, nestAdData.getAdLevel());
                        ArrayList arrayList2 = new ArrayList();
                        NestAdData nestAdData5 = nestAdData;
                        nestAdData5.setDspName(NestKsProvider.DSP_NAME);
                        nestAdData5.setAppId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.CSJ)));
                        nestAdData5.setSdkFrom(NestKsProvider.SDK_FROM);
                        nestAdData5.setAdData(splashAd);
                        NestKsProvider nestKsProvider4 = NestKsProvider.this;
                        Context appContext = packer.getAppContext();
                        Intrinsics.checkExpressionValueIsNotNull(appContext, "packer.appContext");
                        nestAdData5.setSplashView(nestKsProvider4.createKsSplashView(splashAd, appContext, nestAdData, (String) objectRef.element));
                        nestAdData5.setSensitiveInfo(KsSensitiveCatcher.INSTANCE.catchSplashInterstitialAd(splashAd, nestAdData.getAdLevel()));
                        NestKsProvider.this.getAdEcpm(splashAd.getECPM(), nestAdData);
                        arrayList2.add(nestAdData);
                        EventReporter eventReporter3 = EventReporter.INSTANCE;
                        NestAdData nestAdData6 = nestAdData;
                        EventParams.Builder builder5 = builder;
                        Intrinsics.checkExpressionValueIsNotNull(builder5, "builder");
                        eventReporter3.reportRespDi(nestAdData6, builder5, 1);
                        IStrategyListener iStrategyListener2 = listener;
                        if (iStrategyListener2 != null) {
                            iStrategyListener2.onAdLoaded(arrayList2);
                        }
                        NestKsProvider.this.onNestAdLoad(nestAdData);
                    }

                    @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
                    public void onRequestResult(int p0) {
                    }
                });
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void getTemplateFeedAd(ActivityPacker packer, NestAdData nestAdData, IStrategyListener listenerStrategy) {
        String nestType;
        float ksWidth;
        float ksHeight;
        AdSize adSize;
        WifiLog.d("NestKsProvider getTemplateFeedAd adLevelName = " + nestAdData.getAdLevelName() + " adCode = " + nestAdData.getAdCode() + " adLevel = " + nestAdData.getAdLevel() + " adType = " + nestAdData.getAdType());
        listenerStrategy.onStart(nestAdData);
        EventParams.Builder renderStyle = new EventParams.Builder().setDspName(DSP_NAME).setNestSid(nestAdData.getNestSid()).setMediaId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.KS))).setSrcId(String.valueOf(nestAdData.getAdCode())).setRenderStyle(nestAdData.getRenderStyle());
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
            ksWidth = 640.0f;
            ksHeight = 0.0f;
        } else {
            ksWidth = adSize.getKsWidth();
            ksHeight = adSize.getKsHeight();
        }
        String adCode = nestAdData.getAdCode();
        Long lValueOf = adCode != null ? Long.valueOf(Long.parseLong(adCode)) : null;
        if (lValueOf != null) {
            KsScene.Builder builderAdNum = new KsScene.Builder(lValueOf.longValue()).adNum(1);
            ScreenUtil screenUtil = ScreenUtil.INSTANCE;
            Context appContext = packer.getAppContext();
            Intrinsics.checkExpressionValueIsNotNull(appContext, "packer.appContext");
            KsScene.Builder builderWidth = builderAdNum.width(screenUtil.dp2px(appContext, ksWidth));
            Intrinsics.checkExpressionValueIsNotNull(builderWidth, "KsScene.Builder(codeId)\n…ppContext, expressWidth))");
            if (ksHeight != 0.0f) {
                Context appContext2 = packer.getAppContext();
                Intrinsics.checkExpressionValueIsNotNull(appContext2, "packer.appContext");
                builderWidth = builderWidth.height(screenUtil.dp2px(appContext2, ksHeight));
                Intrinsics.checkExpressionValueIsNotNull(builderWidth, "ksbuild.height(ScreenUti…pContext, expressHeight))");
            }
            KsScene ksSceneBuild = builderWidth != null ? builderWidth.build() : null;
            KsLoadManager loadManager = KsAdSDK.getLoadManager();
            if (loadManager != null) {
                loadManager.loadConfigFeedAd(ksSceneBuild, new AnonymousClass2(nestAdData, builder, listenerStrategy, lValueOf, packer));
            }
        }
    }

    public final void initRewardListener(KsRewardVideoAd ad, final NestAdData nestAdData, final IStrategyListener listenerStrategy) {
        ad.setRewardAdInteractionListener(new KsRewardVideoAd.RewardAdInteractionListener() { // from class: com.wifi.ks.ad.NestKsProvider.initRewardListener.1
            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onAdClicked() throws JSONException {
                WifiLog.d("NestKsProvider requestRewardAd 激励视频广告点击");
                IStrategyListener iStrategyListener = listenerStrategy;
                if (iStrategyListener != null) {
                    iStrategyListener.onAdClicked(nestAdData, SDKAlias.KS.getType());
                }
                InnerRewardShowListener rewardShowListener = nestAdData.getRewardShowListener();
                if (rewardShowListener != null) {
                    rewardShowListener.onAdClicked(SDKAlias.KS.getType(), nestAdData);
                }
                NestKsNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_CLICK);
            }

            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onPageDismiss() {
                WifiLog.d("NestKsProvider requestRewardAd 激励视频广告关闭");
                IStrategyListener iStrategyListener = listenerStrategy;
                if (iStrategyListener != null) {
                    iStrategyListener.onAdClose(nestAdData, SDKAlias.KS.getType());
                }
                InnerRewardShowListener rewardShowListener = nestAdData.getRewardShowListener();
                if (rewardShowListener != null) {
                    rewardShowListener.onAdClose(SDKAlias.KS.getType(), nestAdData);
                }
            }

            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onRewardVerify(Map<String, Object> p0) {
            }

            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onVideoPlayEnd() throws JSONException {
                WifiLog.d("NestKsProvider requestRewardAd 激励视频广告播放完成");
                IStrategyListener iStrategyListener = listenerStrategy;
                if (iStrategyListener != null) {
                    iStrategyListener.onAdVideoComplete(nestAdData);
                }
                InnerRewardShowListener rewardShowListener = nestAdData.getRewardShowListener();
                if (rewardShowListener != null) {
                    rewardShowListener.onVideoComplete(SDKAlias.KS.getType(), nestAdData);
                }
                NestKsNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_VIDEOE);
            }

            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onVideoPlayError(int code, int extra) throws JSONException {
                WifiLog.d("NestKsProvider requestRewardAd 激励视频广告播放出错");
                NestKsNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_VIDEOT);
            }

            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onVideoPlayStart() throws JSONException {
                WifiLog.d("NestKsProvider requestRewardAd 激励视频广告播放开始");
                IStrategyListener iStrategyListener = listenerStrategy;
                if (iStrategyListener != null) {
                    iStrategyListener.onAdExpose(nestAdData, SDKAlias.KS.getType());
                }
                InnerRewardShowListener rewardShowListener = nestAdData.getRewardShowListener();
                if (rewardShowListener != null) {
                    rewardShowListener.onAdExpose(SDKAlias.KS.getType(), nestAdData);
                }
                NestKsNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_VIDEOS);
            }

            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onRewardVerify() throws JSONException {
                WifiLog.d("NestKsProvider requestRewardAd 激励视频广告获取激励");
                IStrategyListener iStrategyListener = listenerStrategy;
                if (iStrategyListener != null) {
                    iStrategyListener.onAdRewardVerify(nestAdData, SDKAlias.KS.getType());
                }
                InnerRewardShowListener rewardShowListener = nestAdData.getRewardShowListener();
                if (rewardShowListener != null) {
                    rewardShowListener.onAdRewardVerify(SDKAlias.KS.getType(), nestAdData);
                }
                NestKsNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_REWARDARRIVED);
            }

            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onExtraRewardVerify(int p0) {
            }

            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onVideoSkipToEnd(long p0) {
            }

            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onRewardStepVerify(int p0, int p1) {
            }
        });
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public boolean interstitialAdIsBelongTheProvider(NestAdData adObject) {
        return adObject.getAdData() instanceof KsInterstitialAd;
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
        if (nestAdData.getNativeView() instanceof NestKsNativeView) {
            BaseNativeView nativeView = nestAdData.getNativeView();
            if (nativeView == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.wifi.ks.ad.NestKsNativeView");
            }
            View drawVideoView = ((NestKsNativeView) nativeView).getDrawVideoView();
            if (drawVideoView != null) {
                drawVideoView.setVisibility(8);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("pauseAd() ksNativeView = ");
            sb.append(nestAdData.getNativeView());
            sb.append(" drawVideoView=");
            BaseNativeView nativeView2 = nestAdData.getNativeView();
            if (nativeView2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.wifi.ks.ad.NestKsNativeView");
            }
            sb.append(((NestKsNativeView) nativeView2).getDrawVideoView());
            sb.append(" visibility = ");
            BaseNativeView nativeView3 = nestAdData.getNativeView();
            if (nativeView3 == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.wifi.ks.ad.NestKsNativeView");
            }
            View drawVideoView2 = ((NestKsNativeView) nativeView3).getDrawVideoView();
            sb.append(drawVideoView2 != null ? Integer.valueOf(drawVideoView2.getVisibility()) : null);
            WifiLog.d(sb.toString());
        }
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void requestRewardAd(ActivityPacker packer, final NestAdData nestAdData, final IStrategyListener listenerStrategy) {
        String nestType;
        super.requestRewardAd(packer, nestAdData, listenerStrategy);
        WifiLog.d("NestKsProvider getTemplateFeedAd adLevelName = " + nestAdData.getAdLevelName() + " adCode = " + nestAdData.getAdCode() + " adLevel = " + nestAdData.getAdLevel() + " adType = " + nestAdData.getAdType());
        listenerStrategy.onStart(nestAdData);
        EventParams.Builder renderStyle = new EventParams.Builder().setDspName(DSP_NAME).setNestSid(nestAdData.getNestSid()).setMediaId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.KS))).setSrcId(String.valueOf(nestAdData.getAdCode())).setRenderStyle(nestAdData.getRenderStyle());
        AdParams adParams = nestAdData.getAdParams();
        if (adParams == null || (nestType = adParams.getNestType()) == null) {
            nestType = "";
        }
        final EventParams.Builder builder = renderStyle.setNestType(nestType).setInventoryId(nestAdData.getInventoryId()).setSdkFrom(SDK_FROM);
        EventReporter eventReporter = EventReporter.INSTANCE;
        Intrinsics.checkExpressionValueIsNotNull(builder, "builder");
        eventReporter.reportReqDi(nestAdData, builder);
        String adCode = nestAdData.getAdCode();
        final Long lValueOf = adCode != null ? Long.valueOf(Long.parseLong(adCode)) : null;
        KsScene ksSceneBuild = lValueOf != null ? new KsScene.Builder(lValueOf.longValue()).adNum(1).build() : null;
        KsLoadManager loadManager = KsAdSDK.getLoadManager();
        if (loadManager != null) {
            loadManager.loadRewardVideoAd(ksSceneBuild, new KsLoadManager.RewardVideoAdListener() { // from class: com.wifi.ks.ad.NestKsProvider.requestRewardAd.1
                @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
                public void onError(int code, String msg) {
                    EventReporter eventReporter2 = EventReporter.INSTANCE;
                    NestAdData nestAdData2 = nestAdData;
                    EventParams.Builder builder2 = builder;
                    Intrinsics.checkExpressionValueIsNotNull(builder2, "builder");
                    eventReporter2.reportNoRespDi(nestAdData2, builder2, String.valueOf(code), msg);
                    WifiLog.d("NestKsProvider requestRewardAd onError code = " + code + " message = " + msg);
                    IStrategyListener iStrategyListener = listenerStrategy;
                    NestAdData nestAdData3 = nestAdData;
                    if (msg == null) {
                        msg = "";
                    }
                    iStrategyListener.onAdFailed(nestAdData3, msg, code);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
                public void onRewardVideoAdLoad(List<KsRewardVideoAd> adList) {
                    if (adList == null || adList.isEmpty()) {
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
                    if (!adList.isEmpty()) {
                        int testPriceSwitchEcpm = NestKsProvider.this.getTestPriceSwitchEcpm(adList.get(0).getECPM(), nestAdData);
                        WifiLog.d("NestKsProvider requestRewardAd onADLoaded priceSwitch price " + testPriceSwitchEcpm + " code " + nestAdData.getAdCode());
                        NestKsProvider nestKsProvider = NestKsProvider.this;
                        NestAdData nestAdData3 = nestAdData;
                        EventParams.Builder builder3 = builder;
                        Intrinsics.checkExpressionValueIsNotNull(builder3, "builder");
                        if (nestKsProvider.checkAdEcpmDone(testPriceSwitchEcpm, nestAdData3, builder3, listenerStrategy)) {
                            return;
                        }
                        NestKsProvider nestKsProvider2 = NestKsProvider.this;
                        NestAdData nestAdData4 = nestAdData;
                        EventParams.Builder builder4 = builder;
                        Intrinsics.checkExpressionValueIsNotNull(builder4, "builder");
                        if (nestKsProvider2.checkAdPriceSwitch(testPriceSwitchEcpm, nestAdData4, builder4, listenerStrategy)) {
                            return;
                        }
                    }
                    NestKsProvider nestKsProvider3 = NestKsProvider.this;
                    Long l = lValueOf;
                    AdParams adParams2 = nestAdData.getAdParams();
                    nestKsProvider3.catchKSSensitiveInfo(adList, l, adParams2 != null ? adParams2.getExt() : null, nestAdData.getAdLevel());
                    KsRewardVideoAd ksRewardVideoAd = adList.get(0);
                    if (!ksRewardVideoAd.isAdEnable()) {
                        WifiLog.d("NestKsProvider requestRewardAd 暂⽆无可⽤用激励视频⼴广告，请等待缓存加载或者重新刷新");
                        onError(-1, "暂⽆无可⽤用激励视频⼴广告");
                        return;
                    }
                    NestKsProvider.this.initRewardListener(ksRewardVideoAd, nestAdData, listenerStrategy);
                    ArrayList arrayList = new ArrayList();
                    for (KsRewardVideoAd ksRewardVideoAd2 : adList) {
                        NestAdData nestAdData5 = nestAdData;
                        nestAdData5.setDspName(NestKsProvider.DSP_NAME);
                        nestAdData5.setAppId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.KS)));
                        nestAdData5.setSdkFrom(NestKsProvider.SDK_FROM);
                        nestAdData5.setAdData(ksRewardVideoAd2);
                        nestAdData5.setSensitiveInfo(KsSensitiveCatcher.INSTANCE.catchKsRewardAd(ksRewardVideoAd2, nestAdData.getAdLevel()));
                        if (ksRewardVideoAd2.getECPM() > 0) {
                            nestAdData5.setAdCost(ksRewardVideoAd2.getECPM());
                        }
                        arrayList.add(nestAdData);
                    }
                    EventReporter eventReporter3 = EventReporter.INSTANCE;
                    NestAdData nestAdData6 = nestAdData;
                    EventParams.Builder builder5 = builder;
                    Intrinsics.checkExpressionValueIsNotNull(builder5, "builder");
                    eventReporter3.reportRespDi(nestAdData6, builder5, adList.size());
                    IStrategyListener iStrategyListener2 = listenerStrategy;
                    if (iStrategyListener2 != null) {
                        iStrategyListener2.onAdLoaded(arrayList);
                    }
                    IStrategyListener iStrategyListener3 = listenerStrategy;
                    if (iStrategyListener3 != null) {
                        iStrategyListener3.onAdVideoCached(nestAdData);
                    }
                    NestKsProvider.this.onNestAdLoadReport(nestAdData);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
                public void onRewardVideoResult(List<KsRewardVideoAd> p0) {
                }
            });
        }
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void resumeAd(NestAdData nestAdData) {
        if (nestAdData.getNativeView() instanceof NestKsNativeView) {
            BaseNativeView nativeView = nestAdData.getNativeView();
            if (nativeView == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.wifi.ks.ad.NestKsNativeView");
            }
            View drawVideoView = ((NestKsNativeView) nativeView).getDrawVideoView();
            if (drawVideoView != null) {
                drawVideoView.setVisibility(0);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("resumeAd() ksNativeView = ");
            sb.append(nestAdData.getNativeView());
            sb.append(" drawVideoView=");
            BaseNativeView nativeView2 = nestAdData.getNativeView();
            if (nativeView2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.wifi.ks.ad.NestKsNativeView");
            }
            sb.append(((NestKsNativeView) nativeView2).getDrawVideoView());
            sb.append(" visibility = ");
            BaseNativeView nativeView3 = nestAdData.getNativeView();
            if (nativeView3 == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.wifi.ks.ad.NestKsNativeView");
            }
            View drawVideoView2 = ((NestKsNativeView) nativeView3).getDrawVideoView();
            sb.append(drawVideoView2 != null ? Integer.valueOf(drawVideoView2.getVisibility()) : null);
            WifiLog.d(sb.toString());
        }
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public boolean rewardAdIsBelongTheProvider(NestAdData adObject) {
        return adObject.getAdData() instanceof KsRewardVideoAd;
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void showInterstitialAd(Activity activity, final NestAdData nestAdData, final PopShowListener showListener) throws JSONException {
        Object adData = nestAdData.getAdData();
        if (adData == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.kwad.sdk.api.KsInterstitialAd");
        }
        KsInterstitialAd ksInterstitialAd = (KsInterstitialAd) adData;
        NestKsNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_TOSHOW);
        ksInterstitialAd.setAdInteractionListener(new KsInterstitialAd.AdInteractionListener() { // from class: com.wifi.ks.ad.NestKsProvider.showInterstitialAd.1
            @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
            public void onAdClicked() throws JSONException {
                WifiLog.d("NestKsProvider onAdClicked");
                PopShowListener popShowListener = showListener;
                if (popShowListener != null) {
                    popShowListener.onAdClicked(SDKAlias.KS.getType(), nestAdData);
                }
                NestKsNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_CLICK);
            }

            @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
            public void onAdClosed() throws JSONException {
                WifiLog.d("NestKsProvider onAdClosed");
                PopShowListener popShowListener = showListener;
                if (popShowListener != null) {
                    popShowListener.onAdClose(SDKAlias.KS.getType(), nestAdData);
                }
                NestKsNativeView.INSTANCE.onEvent(nestAdData, "nest_sdk_cancle_click");
            }

            @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
            public void onAdShow() throws JSONException {
                WifiLog.d("NestKsProvider onAdShow");
                PopShowListener popShowListener = showListener;
                if (popShowListener != null) {
                    popShowListener.onAdExpose(SDKAlias.KS.getType(), nestAdData);
                }
                NestKsNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_SHOW);
            }

            @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
            public void onSkippedAd() {
                WifiLog.d("NestKsProvider onSkippedAd");
                PopShowListener popShowListener = showListener;
                if (popShowListener != null) {
                    popShowListener.onAdSkipClick(SDKAlias.KS.getType(), nestAdData);
                }
            }

            @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
            public void onVideoPlayEnd() throws JSONException {
                WifiLog.d("NestKsProvider onVideoComplete");
                PopShowListener popShowListener = showListener;
                if (popShowListener != null) {
                    popShowListener.onVideoComplete(SDKAlias.KS.getType(), nestAdData);
                }
                NestKsNativeView.Companion companion = NestKsNativeView.INSTANCE;
                companion.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_VIDEOE);
                companion.onEvent(nestAdData, WifiNestConst.EventKey.NEST_SDK_ENDPLAY_SHOW);
            }

            @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
            public void onVideoPlayError(int code, int extra) throws JSONException {
                WifiLog.d("NestKsProvider onVideoPlayError errorCode = " + code + " + ; Extra = " + extra);
                PopShowListener popShowListener = showListener;
                if (popShowListener != null) {
                    popShowListener.onVideoStart(SDKAlias.KS.getType(), nestAdData);
                }
                NestKsNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_VIDEOT);
            }

            @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
            public void onVideoPlayStart() throws JSONException {
                WifiLog.d("NestKsProvider onVideoPlayStart");
                PopShowListener popShowListener = showListener;
                if (popShowListener != null) {
                    popShowListener.onVideoStart(SDKAlias.KS.getType(), nestAdData);
                }
                NestKsNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_VIDEOS);
            }

            @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
            public void onPageDismiss() {
            }
        });
        ksInterstitialAd.showInterstitialAd(activity, new KsVideoPlayConfig.Builder().videoSoundEnable(false).showLandscape(activity.getRequestedOrientation() == 0).build());
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void showRewardAd(Activity activity, NestAdData nestAdData, InnerRewardShowListener showListener) throws JSONException {
        Object adData = nestAdData.getAdData();
        if (adData == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.kwad.sdk.api.KsRewardVideoAd");
        }
        KsRewardVideoAd ksRewardVideoAd = (KsRewardVideoAd) adData;
        NestKsNativeView.Companion companion = NestKsNativeView.INSTANCE;
        companion.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_TOSHOW);
        KsVideoPlayConfig ksVideoPlayConfigBuild = new KsVideoPlayConfig.Builder().videoSoundEnable(false).showLandscape(false).build();
        if (!ksRewardVideoAd.isAdEnable()) {
            WifiLog.d("NestKsProvider requestRewardAd 暂⽆无可⽤用激励视频⼴广告，请等待缓存加载或者重新刷新");
            NestAdData.AdRenderListener adRenderListener = nestAdData.getAdRenderListener();
            if (adRenderListener != null) {
                adRenderListener.onRenderFail(SDKAlias.KS.getType(), nestAdData, -1, "暂⽆无可⽤用激励视频⼴广告，请等待缓存加载或者重新刷新");
                return;
            }
            return;
        }
        nestAdData.setRewardShowListener(showListener);
        ksRewardVideoAd.showRewardVideoAd(activity, ksVideoPlayConfigBuild);
        NestAdData.AdRenderListener adRenderListener2 = nestAdData.getAdRenderListener();
        if (adRenderListener2 != null) {
            adRenderListener2.onRenderSuccess(SDKAlias.KS.getType(), nestAdData);
        }
        companion.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_SHOW);
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void showSplashAd(Activity activity, final NestAdData adData, final ViewGroup container, SplashShowListener splashShowListener) throws JSONException {
        NestKsNativeView.INSTANCE.onEvent(adData, WifiNestConst.EventKey.UNIFIEDAD_SDK_TOSHOW);
        if (activity.isFinishing()) {
            WifiLog.d("splashAd ks showSplashAd activity is error");
        } else {
            WifiLog.d("splashAd ks showSplashAd");
            activity.runOnUiThread(new Runnable() { // from class: com.wifi.ks.ad.NestKsProvider.showSplashAd.1
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
        return adObject.getAdData() instanceof KsSplashScreenAd;
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void startAd(NestAdData nestAdData) {
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void stopAd(NestAdData nestAdData) {
    }
}
