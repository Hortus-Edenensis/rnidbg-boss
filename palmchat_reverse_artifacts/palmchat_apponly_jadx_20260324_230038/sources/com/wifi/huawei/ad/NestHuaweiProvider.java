package com.wifi.huawei.ad;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hms.ads.AdListener;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.AppInfo;
import com.huawei.hms.ads.BiddingInfo;
import com.huawei.hms.ads.BiddingParam;
import com.huawei.hms.ads.Image;
import com.huawei.hms.ads.InterstitialAd;
import com.huawei.hms.ads.VideoOperator;
import com.huawei.hms.ads.nativead.NativeAd;
import com.huawei.hms.ads.nativead.NativeAdLoader;
import com.huawei.hms.ads.splash.SplashAd;
import com.huawei.hms.ads.splash.SplashAdDisplayListener;
import com.huawei.hms.ads.splash.SplashView;
import com.huawei.hms.ads.splash.listener.SplashListener;
import com.huawei.hms.ads.splash.listener.SplashLoadListener;
import com.huawei.openalliance.ad.constant.be;
import com.huawei.openalliance.ad.constant.bq;
import com.wifi.ad.core.SDKAlias;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.compliance.RequestSDKConfig;
import com.wifi.ad.core.config.AdParams;
import com.wifi.ad.core.config.AdSDKConfigUtil;
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
import com.wifi.huawei.ad.data.HuaweiFeedDataAdapter;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 D2\u00020\u0001:\u0001DB\u0005¢\u0006\u0002\u0010\u0002JK\u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0002\u0010\u000eJ\u001c\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J4\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0012\u0010\u001e\u001a\u00020\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0012H\u0016J\u0010\u0010#\u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0012H\u0016J(\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020&2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020(H\u0016J\u0012\u0010)\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J \u0010*\u001a\u00020\u00102\u0006\u0010%\u001a\u00020&2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J \u0010+\u001a\u00020\u00102\u0006\u0010%\u001a\u00020&2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0012\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020\tH\u0016J \u0010/\u001a\u00020\u00102\u0006\u0010%\u001a\u00020&2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u00100\u001a\u00020\u001dH\u0016J \u00101\u001a\u00020\u00102\u0006\u0010%\u001a\u00020&2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u00102\u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0012H\u0016J\u0010\u00103\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u00104\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u00105\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u00106\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\"\u00107\u001a\u00020\u00102\u0006\u00108\u001a\u0002092\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J(\u0010<\u001a\u00020\u00102\u0006\u00108\u001a\u0002092\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@H\u0016J\u0010\u0010A\u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0012H\u0016J\u0010\u0010B\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010C\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¨\u0006E"}, d2 = {"Lcom/wifi/huawei/ad/NestHuaweiProvider;", "Lcom/wifi/ad/core/provider/BaseAdProvider;", "()V", "catchHuaweiSensitiveInfo", "", "Lcom/wifi/ad/core/entity/SensitiveInfo;", "ad", "", "codeId", "", "ext", "", "adLevel", "", "(Ljava/lang/Object;Ljava/lang/String;Ljava/util/Map;Ljava/lang/Integer;)Ljava/util/List;", "checkEcpm", "", "nestAdData", "Lcom/wifi/ad/core/data/NestAdData;", "biddingInfo", "Lcom/huawei/hms/ads/BiddingInfo;", "createNativeView", "Landroid/view/View;", be.aU, "Lcom/huawei/hms/ads/nativead/NativeAd;", "context", "Landroid/content/Context;", "strId", "listenerStrategy", "Lcom/wifi/ad/core/strategy/IStrategyListener;", "destroyAd", "requestId", "feedAdIsBelongTheProvider", "", "adObject", "feedNativeAdIsBelongTheProvider", "getCorrectAd", "packer", "Lcom/wifi/ad/core/helper/ActivityPacker;", "scene", "Lcom/wifi/ad/core/strategy/LoadScene;", "getHwEcpm", "getInterstitialAd", "getNativeFeedAd", "getNativeView", "Lcom/wifi/ad/core/custom/flow/BaseNativeView;", "adProviderType", "getSplashAd", bq.f.s, "getTemplateFeedAd", "interstitialAdIsBelongTheProvider", "onNestAdLoad", "onNestAdUnLoad", "pauseAd", "resumeAd", "showInterstitialAd", "activity", "Landroid/app/Activity;", "showListener", "Lcom/wifi/ad/core/listener/PopShowListener;", "showSplashAd", "container", "Landroid/view/ViewGroup;", "splashShowListener", "Lcom/wifi/ad/core/listener/SplashShowListener;", "splashAdIsBelongTheProvider", "startAd", "stopAd", "Companion", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
public final class NestHuaweiProvider extends BaseAdProvider {
    public static final String DSP_NAME = "huawei_out";
    public static final String SDK_FROM = "huawei";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static HashMap<String, InnerRewardShowListener> showListenerMap = new HashMap<>();

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R6\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b`\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/wifi/huawei/ad/NestHuaweiProvider$Companion;", "", "()V", "DSP_NAME", "", "SDK_FROM", "showListenerMap", "Ljava/util/HashMap;", "Lcom/wifi/ad/core/listener/InnerRewardShowListener;", "Lkotlin/collections/HashMap;", "getShowListenerMap", "()Ljava/util/HashMap;", "setShowListenerMap", "(Ljava/util/HashMap;)V", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public final HashMap<String, InnerRewardShowListener> getShowListenerMap() {
            return NestHuaweiProvider.showListenerMap;
        }

        public final void setShowListenerMap(HashMap<String, InnerRewardShowListener> map) {
            NestHuaweiProvider.showListenerMap = map;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<SensitiveInfo> catchHuaweiSensitiveInfo(Object ad, String codeId, Map<String, String> ext, Integer adLevel) {
        if (!WifiNestAd.INSTANCE.isCatchThirdInfo()) {
            return null;
        }
        List<SensitiveInfo> listCatchSplashAds = ad instanceof SplashAd ? HuaweiSensitiveCatcher.INSTANCE.catchSplashAds((SplashAd) ad, adLevel) : ad instanceof NativeAd ? HuaweiSensitiveCatcher.INSTANCE.catchTemplateAds((NativeAd) ad, adLevel) : ad instanceof InterstitialAd ? HuaweiSensitiveCatcher.INSTANCE.catchInterAds((InterstitialAd) ad, adLevel) : null;
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
    public final void checkEcpm(NestAdData nestAdData, BiddingInfo biddingInfo) {
        if (nestAdData == null || biddingInfo == null || biddingInfo.getPrice() == null || Float.compare(biddingInfo.getPrice().floatValue(), 0) <= 0) {
            return;
        }
        getAdEcpm((int) (biddingInfo.getPrice().floatValue() * 100), nestAdData);
        WifiLog.d("checkEcpm biddingInfo.price " + biddingInfo.getPrice() + " code " + nestAdData.getAdCode());
    }

    private final View createNativeView(final NativeAd nativeAd, final Context context, String strId, final NestAdData nestAdData, final IStrategyListener listenerStrategy) {
        int creativeType = nativeAd.getCreativeType();
        WifiLog.d("HWAD NestHwProvider  createNativeView createType " + creativeType + " strId " + strId + " code " + nestAdData.getAdCode() + " nestAdData.adScene " + nestAdData.getAdScene());
        View viewCreateImageOnlyAdView = (creativeType == 2 || creativeType == 102) ? NativeViewFactory.createImageOnlyAdView(nativeAd, context) : (creativeType == 3 || creativeType == 6) ? NativeViewFactory.createMediumAdView(nativeAd, context) : (creativeType == 103 || creativeType == 106) ? NativeViewFactory.createAppDownloadButtonAdView(nativeAd, context) : (creativeType == 7 || creativeType == 107) ? NativeViewFactory.createSmallImageAdView(nativeAd, context) : (creativeType == 8 || creativeType == 108) ? NativeViewFactory.createThreeImagesAdView(nativeAd, context, nestAdData.getAdCode()) : null;
        boolean z = nestAdData.getAdScene() == 51;
        RelativeLayout relativeLayout = new RelativeLayout(context);
        if (viewCreateImageOnlyAdView != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            if (z) {
                ScreenUtil screenUtil = ScreenUtil.INSTANCE;
                layoutParams.topMargin = screenUtil.dp2px(context, 2.5f);
                layoutParams.rightMargin = screenUtil.dp2px(context, 1.0f);
                layoutParams.leftMargin = screenUtil.dp2px(context, 1.0f);
                layoutParams.bottomMargin = screenUtil.dp2px(context, 1.0f);
            }
            relativeLayout.addView(viewCreateImageOnlyAdView, layoutParams);
            ImageView imageView = new ImageView(context);
            ScreenUtil screenUtil2 = ScreenUtil.INSTANCE;
            int iDp2px = screenUtil2.dp2px(context, 20.0f);
            int iDp2px2 = screenUtil2.dp2px(context, 4.0f);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iDp2px, iDp2px);
            imageView.setImageResource(R.drawable.hw_temp_close);
            layoutParams2.addRule(11);
            layoutParams2.topMargin = iDp2px2;
            layoutParams2.rightMargin = iDp2px2 * 3;
            relativeLayout.addView(imageView, layoutParams2);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.wifi.huawei.ad.NestHuaweiProvider.createNativeView.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    IStrategyListener iStrategyListener;
                    WifiLog.d("HWAD temp close click addata " + nestAdData);
                    NestAdData nestAdData2 = nestAdData;
                    if (nestAdData2 == null || (iStrategyListener = listenerStrategy) == null) {
                        return;
                    }
                    iStrategyListener.onDislikeClicked(nestAdData2, "");
                }
            });
            try {
                if (!TextUtils.isEmpty(strId)) {
                    AdSDKConfigUtil adSDKConfigUtil = AdSDKConfigUtil.INSTANCE;
                    if (strId == null) {
                        Intrinsics.throwNpe();
                    }
                    if (adSDKConfigUtil.isAllowShowComp(strId)) {
                        View viewInflate = LayoutInflater.from(context).inflate(R.layout.hw_temp_comp_layout, (ViewGroup) null);
                        WifiLog.d("HWAD temp close strId " + strId + " click " + nativeAd.getAppInfo() + " addata " + nestAdData);
                        if (viewInflate != null && nativeAd.getAppInfo() != null) {
                            AppInfo appInfo = nativeAd.getAppInfo();
                            Intrinsics.checkExpressionValueIsNotNull(appInfo, "nativeAd.appInfo");
                            String developerName = appInfo.getDeveloperName();
                            AppInfo appInfo2 = nativeAd.getAppInfo();
                            Intrinsics.checkExpressionValueIsNotNull(appInfo2, "nativeAd.appInfo");
                            String versionName = appInfo2.getVersionName();
                            WifiLog.d("HWAD temp developerName " + developerName + " version " + versionName + " strId " + strId);
                            if (!TextUtils.isEmpty(developerName) && !TextUtils.isEmpty(versionName)) {
                                TextView textView = (TextView) viewInflate.findViewById(R.id.company);
                                if (textView != null) {
                                    textView.setText(developerName);
                                }
                                TextView textView2 = (TextView) viewInflate.findViewById(R.id.version);
                                if (textView2 != null) {
                                    textView2.setText(versionName);
                                }
                                ((TextView) viewInflate.findViewById(R.id.permission)).setOnClickListener(new View.OnClickListener() { // from class: com.wifi.huawei.ad.NestHuaweiProvider.createNativeView.2
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view) {
                                        nativeAd.getAppInfo().showPermissionPage(context);
                                    }
                                });
                                ((TextView) viewInflate.findViewById(R.id.privacy)).setOnClickListener(new View.OnClickListener() { // from class: com.wifi.huawei.ad.NestHuaweiProvider.createNativeView.3
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view) {
                                        nativeAd.getAppInfo().showPrivacyPolicy(context);
                                    }
                                });
                                LinearLayout linearLayout = new LinearLayout(context);
                                linearLayout.setOrientation(1);
                                linearLayout.addView(relativeLayout, new LinearLayout.LayoutParams(-2, -2));
                                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                                int iDp2px3 = screenUtil2.dp2px(context, 1.0f);
                                if (creativeType == 7 || creativeType == 107 || creativeType == 108) {
                                    iDp2px3 = screenUtil2.dp2px(context, 10.0f);
                                }
                                layoutParams3.leftMargin = iDp2px3;
                                layoutParams3.rightMargin = iDp2px3;
                                layoutParams3.bottomMargin = screenUtil2.dp2px(context, 1.0f);
                                linearLayout.addView(viewInflate, layoutParams3);
                                return linearLayout;
                            }
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        return relativeLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getHwEcpm(BiddingInfo biddingInfo) {
        if (biddingInfo == null || biddingInfo.getPrice() == null || Float.compare(biddingInfo.getPrice().floatValue(), 0) <= 0) {
            return 0;
        }
        return (int) (biddingInfo.getPrice().floatValue() * 100);
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
        return adObject.getAdData() instanceof NativeAd;
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public boolean feedNativeAdIsBelongTheProvider(NestAdData adObject) {
        if (adObject.getAdData() instanceof NativeAd) {
            return true;
        }
        return super.feedNativeAdIsBelongTheProvider(adObject);
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void getCorrectAd(ActivityPacker packer, NestAdData nestAdData, IStrategyListener listenerStrategy, LoadScene scene) {
        if (!NestHuaweiManager.INSTANCE.getInitDone()) {
            listenerStrategy.onAdFailed(nestAdData, "sdk not init", -1001);
            return;
        }
        if (!RequestSDKConfig.INSTANCE.checkAllowRequest(nestAdData.getAdScene(), "hw")) {
            listenerStrategy.onAdFailed(nestAdData, "sdk hw RequestSDKConfig not allow", -1002);
            return;
        }
        if (scene == LoadScene.FEED) {
            if (1 == nestAdData.getRenderStyle()) {
                getNativeFeedAd(packer, nestAdData, listenerStrategy);
                return;
            } else {
                getTemplateFeedAd(packer, nestAdData, listenerStrategy);
                return;
            }
        }
        if (scene == LoadScene.SPLASH) {
            getSplashAd(packer, nestAdData, listenerStrategy);
            return;
        }
        if (scene == LoadScene.INTERSTITIAL) {
            getInterstitialAd(packer, nestAdData, listenerStrategy);
            return;
        }
        listenerStrategy.onAdFailed(nestAdData, "sdk type not allow scene " + scene, -1003);
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void getInterstitialAd(ActivityPacker packer, final NestAdData nestAdData, final IStrategyListener listenerStrategy) {
        String nestType;
        listenerStrategy.onStart(nestAdData);
        EventParams.Builder renderStyle = new EventParams.Builder().setDspName(DSP_NAME).setNestSid(nestAdData.getNestSid()).setMediaId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.HUAWEI))).setSrcId(String.valueOf(nestAdData.getAdCode())).setRenderStyle(nestAdData.getRenderStyle());
        AdParams adParams = nestAdData.getAdParams();
        if (adParams == null || (nestType = adParams.getNestType()) == null) {
            nestType = "";
        }
        final EventParams.Builder builder = renderStyle.setNestType(nestType).setInventoryId(nestAdData.getInventoryId()).setSdkFrom("huawei");
        EventReporter eventReporter = EventReporter.INSTANCE;
        Intrinsics.checkExpressionValueIsNotNull(builder, "builder");
        eventReporter.reportReqDi(nestAdData, builder);
        final InterstitialAd interstitialAd = new InterstitialAd(packer.getAppContext());
        interstitialAd.setAdId(nestAdData.getAdCode());
        interstitialAd.setAdListener(new AdListener() { // from class: com.wifi.huawei.ad.NestHuaweiProvider$getInterstitialAd$adListener$1
            @Override // com.huawei.hms.ads.AdListener
            public void onAdClicked() throws JSONException {
                super.onAdClicked();
                WifiLog.d("HWAD NestHwProvider  getInterstitialAd onAdClicked");
                NestHuaweiNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_CLICK);
                PopShowListener popshowListener = nestAdData.getPopshowListener();
                if (popshowListener != null) {
                    popshowListener.onAdClicked(SDKAlias.HUAWEI.getType(), nestAdData);
                }
            }

            @Override // com.huawei.hms.ads.AdListener
            public void onAdClosed() throws JSONException {
                super.onAdClosed();
                WifiLog.d("HWAD NestHwProvider  getInterstitialAd onAdClosed");
                PopShowListener popshowListener = nestAdData.getPopshowListener();
                if (popshowListener != null) {
                    popshowListener.onAdClose(SDKAlias.HUAWEI.getType(), nestAdData);
                }
                NestHuaweiNativeView.INSTANCE.onEvent(nestAdData, "nest_sdk_cancle_click");
            }

            @Override // com.huawei.hms.ads.AdListener
            public void onAdFailed(int code) {
                super.onAdFailed(code);
                EventReporter eventReporter2 = EventReporter.INSTANCE;
                NestAdData nestAdData2 = nestAdData;
                EventParams.Builder builder2 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder2, "builder");
                eventReporter2.reportNoRespDi(nestAdData2, builder2, String.valueOf(code), String.valueOf(code));
                WifiLog.d("HWAD NestHwProvider  getInterstitialAd onError code = " + String.valueOf(code));
                IStrategyListener iStrategyListener = listenerStrategy;
                if (iStrategyListener != null) {
                    iStrategyListener.onAdFailed(nestAdData, String.valueOf(code), code);
                }
                this.this$0.onNestAdUnLoad(nestAdData);
            }

            @Override // com.huawei.hms.ads.AdListener
            public void onAdImpression() throws JSONException {
                super.onAdImpression();
                WifiLog.d("HWAD NestHwProvider  getInterstitialAd onAdImpression code " + nestAdData.getAdCode());
                NestHuaweiNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_SHOW);
                PopShowListener popshowListener = nestAdData.getPopshowListener();
                if (popshowListener != null) {
                    popshowListener.onAdExpose(SDKAlias.HUAWEI.getType(), nestAdData);
                }
            }

            @Override // com.huawei.hms.ads.AdListener
            public void onAdLeave() {
                super.onAdLeave();
                WifiLog.d("HWAD NestHwProvider  getInterstitialAd onAdLeave");
            }

            @Override // com.huawei.hms.ads.AdListener
            public void onAdLoaded() {
                super.onAdLoaded();
                int testPriceSwitchEcpm = this.this$0.getTestPriceSwitchEcpm(this.this$0.getHwEcpm(interstitialAd.getBiddingInfo()), nestAdData);
                WifiLog.d("HWAD NestHwProvider getInterstitialAd onAdLoaded priceSwitch price " + testPriceSwitchEcpm + " code " + nestAdData.getAdCode());
                if (testPriceSwitchEcpm > 0) {
                    NestHuaweiProvider nestHuaweiProvider = this.this$0;
                    NestAdData nestAdData2 = nestAdData;
                    EventParams.Builder builder2 = builder;
                    Intrinsics.checkExpressionValueIsNotNull(builder2, "builder");
                    if (nestHuaweiProvider.checkAdEcpmDone(testPriceSwitchEcpm, nestAdData2, builder2, listenerStrategy)) {
                        return;
                    }
                }
                NestHuaweiProvider nestHuaweiProvider2 = this.this$0;
                NestAdData nestAdData3 = nestAdData;
                EventParams.Builder builder3 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder3, "builder");
                if (nestHuaweiProvider2.checkAdPriceSwitch(testPriceSwitchEcpm, nestAdData3, builder3, listenerStrategy)) {
                    return;
                }
                NestHuaweiProvider nestHuaweiProvider3 = this.this$0;
                InterstitialAd interstitialAd2 = interstitialAd;
                String adCode = nestAdData.getAdCode();
                AdParams adParams2 = nestAdData.getAdParams();
                List listCatchHuaweiSensitiveInfo = nestHuaweiProvider3.catchHuaweiSensitiveInfo(interstitialAd2, adCode, adParams2 != null ? adParams2.getExt() : null, nestAdData.getAdLevel());
                ArrayList arrayList = new ArrayList();
                NestAdData nestAdData4 = nestAdData;
                nestAdData4.setDspName(NestHuaweiProvider.DSP_NAME);
                nestAdData4.setAppId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.HUAWEI)));
                nestAdData4.setSdkFrom("huawei");
                nestAdData4.setAdData(interstitialAd);
                if (listCatchHuaweiSensitiveInfo != null && (!listCatchHuaweiSensitiveInfo.isEmpty())) {
                    nestAdData4.setSensitiveInfo((SensitiveInfo) listCatchHuaweiSensitiveInfo.get(0));
                }
                this.this$0.checkEcpm(nestAdData, interstitialAd.getBiddingInfo());
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

            @Override // com.huawei.hms.ads.AdListener
            public void onAdOpened() throws JSONException {
                super.onAdOpened();
                WifiLog.d("HWAD NestHwProvider getInterstitialAd onAdOpened");
                NestHuaweiNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_SHOW);
                PopShowListener popshowListener = nestAdData.getPopshowListener();
                if (popshowListener != null) {
                    popshowListener.onAdExpose(SDKAlias.HUAWEI.getType(), nestAdData);
                }
            }
        });
        interstitialAd.loadAd(new AdParam.Builder().addBiddingParamMap(nestAdData.getAdCode(), new BiddingParam()).setTMax(500).build());
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void getNativeFeedAd(final ActivityPacker packer, final NestAdData nestAdData, final IStrategyListener listenerStrategy) {
        String nestType;
        listenerStrategy.onStart(nestAdData);
        EventParams.Builder renderStyle = new EventParams.Builder().setDspName(DSP_NAME).setNestSid(nestAdData.getNestSid()).setMediaId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.HUAWEI))).setSrcId(String.valueOf(nestAdData.getAdCode())).setRenderStyle(nestAdData.getRenderStyle());
        AdParams adParams = nestAdData.getAdParams();
        if (adParams == null || (nestType = adParams.getNestType()) == null) {
            nestType = "";
        }
        final EventParams.Builder builder = renderStyle.setNestType(nestType).setInventoryId(nestAdData.getInventoryId()).setSdkFrom("huawei");
        EventReporter eventReporter = EventReporter.INSTANCE;
        Intrinsics.checkExpressionValueIsNotNull(builder, "builder");
        eventReporter.reportReqDi(nestAdData, builder);
        NativeAdLoader.Builder builder2 = new NativeAdLoader.Builder(packer.getAppContext(), nestAdData.getAdCode());
        builder2.setNativeAdLoadedListener(new NativeAd.NativeAdLoadedListener() { // from class: com.wifi.huawei.ad.NestHuaweiProvider$getNativeFeedAd$nativeAdLoadedListener$1
            @Override // com.huawei.hms.ads.nativead.NativeAd.NativeAdLoadedListener
            public void onNativeAdLoaded(NativeAd ad) {
                if (ad == null) {
                    EventReporter eventReporter2 = EventReporter.INSTANCE;
                    NestAdData nestAdData2 = nestAdData;
                    EventParams.Builder builder3 = builder;
                    Intrinsics.checkExpressionValueIsNotNull(builder3, "builder");
                    eventReporter2.reportNoRespDi(nestAdData2, builder3, "30200", "");
                    IStrategyListener iStrategyListener = listenerStrategy;
                    if (iStrategyListener != null) {
                        iStrategyListener.onAdFailed(nestAdData, "list is empty", -1);
                        return;
                    }
                    return;
                }
                int testPriceSwitchEcpm = this.this$0.getTestPriceSwitchEcpm(this.this$0.getHwEcpm(ad.getBiddingInfo()), nestAdData);
                WifiLog.d("HWAD NestHwProvider getNativeAd onAdLoaded adList.size = 1 priceSwitch price " + testPriceSwitchEcpm + " code " + nestAdData.getAdCode());
                if (testPriceSwitchEcpm > 0) {
                    NestHuaweiProvider nestHuaweiProvider = this.this$0;
                    NestAdData nestAdData3 = nestAdData;
                    EventParams.Builder builder4 = builder;
                    Intrinsics.checkExpressionValueIsNotNull(builder4, "builder");
                    if (nestHuaweiProvider.checkAdEcpmDone(testPriceSwitchEcpm, nestAdData3, builder4, listenerStrategy)) {
                        return;
                    }
                }
                NestHuaweiProvider nestHuaweiProvider2 = this.this$0;
                NestAdData nestAdData4 = nestAdData;
                EventParams.Builder builder5 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder5, "builder");
                if (nestHuaweiProvider2.checkAdPriceSwitch(testPriceSwitchEcpm, nestAdData4, builder5, listenerStrategy)) {
                    return;
                }
                NestHuaweiProvider nestHuaweiProvider3 = this.this$0;
                String adCode = nestAdData.getAdCode();
                AdParams adParams2 = nestAdData.getAdParams();
                List listCatchHuaweiSensitiveInfo = nestHuaweiProvider3.catchHuaweiSensitiveInfo(ad, adCode, adParams2 != null ? adParams2.getExt() : null, nestAdData.getAdLevel());
                builder.setAdTitle(ad.getTitle()).setAdDesc(ad.getDescription());
                ArrayList arrayList = new ArrayList();
                NestAdData nestAdData5 = nestAdData;
                nestAdData5.setDspName(NestHuaweiProvider.DSP_NAME);
                nestAdData5.setAppId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.HUAWEI)));
                nestAdData5.setSdkFrom("huawei");
                nestAdData5.setAdData(ad);
                if (listCatchHuaweiSensitiveInfo != null && (!listCatchHuaweiSensitiveInfo.isEmpty())) {
                    nestAdData5.setSensitiveInfo((SensitiveInfo) listCatchHuaweiSensitiveInfo.get(0));
                }
                int creativeType = ad.getCreativeType();
                WifiLog.d("NestHWProvider getNativeAd creativeType type " + creativeType);
                if (creativeType == 2 || creativeType == 102 || creativeType == 3 || creativeType == 6 || creativeType == 103 || creativeType == 106) {
                    nestAdData5.setNativeAdImgWidth(16);
                    nestAdData5.setNativeAdImgHeight(9);
                } else if (creativeType == 7 || creativeType == 107 || creativeType == 8 || creativeType == 108) {
                    nestAdData5.setNativeAdImgWidth(3);
                    nestAdData5.setNativeAdImgHeight(2);
                }
                if (ad.getAppInfo() != null) {
                    AppInfo appInfo = ad.getAppInfo();
                    Intrinsics.checkExpressionValueIsNotNull(appInfo, "ad.appInfo");
                    nestAdData5.setAdAppName(appInfo.getAppName());
                    AppInfo appInfo2 = ad.getAppInfo();
                    Intrinsics.checkExpressionValueIsNotNull(appInfo2, "ad.appInfo");
                    nestAdData5.setAdAppDeveloperName(appInfo2.getDeveloperName());
                    AppInfo appInfo3 = ad.getAppInfo();
                    Intrinsics.checkExpressionValueIsNotNull(appInfo3, "ad.appInfo");
                    nestAdData5.setAdAppVersion(appInfo3.getVersionName());
                    AppInfo appInfo4 = ad.getAppInfo();
                    Intrinsics.checkExpressionValueIsNotNull(appInfo4, "ad.appInfo");
                    nestAdData5.setAdAppPermissionsUrl(appInfo4.getPermissionUrl());
                    AppInfo appInfo5 = ad.getAppInfo();
                    Intrinsics.checkExpressionValueIsNotNull(appInfo5, "ad.appInfo");
                    nestAdData5.setAdAppPrivacyUrl(appInfo5.getPrivacyLink());
                    AppInfo appInfo6 = ad.getAppInfo();
                    Intrinsics.checkExpressionValueIsNotNull(appInfo6, "ad.appInfo");
                    nestAdData5.setAdAppFunctionDescUrl(appInfo6.getAppDetailUrl());
                }
                Context appContext = packer.getAppContext();
                Intrinsics.checkExpressionValueIsNotNull(appContext, "packer.appContext");
                nestAdData5.setDataAdapter(new HuaweiFeedDataAdapter(ad, appContext));
                try {
                    Integer adMode = nestAdData.getAdMode();
                    if (adMode != null && adMode.intValue() == 4) {
                        VideoOperator videoOperator = ad.getVideoOperator();
                        Intrinsics.checkExpressionValueIsNotNull(videoOperator, "ad.videoOperator");
                        float aspectRatio = videoOperator.getAspectRatio();
                        WifiLog.d("HWAD huawei native video scale " + aspectRatio + "  code " + nestAdData.getAdCode() + " adMode " + nestAdData.getAdMode());
                        nestAdData5.setNativeAdImgHeight(16);
                        nestAdData5.setNativeAdImgWidth((int) (((float) nestAdData5.getNativeAdImgHeight()) * aspectRatio));
                    } else if (ad.getImages() != null && ad.getImages().size() > 0) {
                        Image image = ad.getImages().get(0);
                        Intrinsics.checkExpressionValueIsNotNull(image, "ad.images[0]");
                        nestAdData5.setNativeAdImgWidth(image.getWidth());
                        Image image2 = ad.getImages().get(0);
                        Intrinsics.checkExpressionValueIsNotNull(image2, "ad.images[0]");
                        nestAdData5.setNativeAdImgHeight(image2.getHeight());
                    }
                } catch (Exception unused) {
                }
                this.this$0.checkEcpm(nestAdData, ad.getBiddingInfo());
                arrayList.add(nestAdData);
                WifiLog.d("HWAD huawei native type " + creativeType + " nativeAdImgWidth " + nestAdData5.getNativeAdImgWidth() + " nativeAdImgHeight " + nestAdData5.getNativeAdImgHeight() + " code " + nestAdData.getAdCode() + " adMode " + nestAdData.getAdMode());
                EventReporter eventReporter3 = EventReporter.INSTANCE;
                NestAdData nestAdData6 = nestAdData;
                EventParams.Builder builder6 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder6, "builder");
                eventReporter3.reportRespDi(nestAdData6, builder6, 1);
                IStrategyListener iStrategyListener2 = listenerStrategy;
                if (iStrategyListener2 != null) {
                    iStrategyListener2.onAdLoaded(arrayList);
                }
            }
        });
        builder2.setAdListener(new AdListener() { // from class: com.wifi.huawei.ad.NestHuaweiProvider$getNativeFeedAd$adListener$1
            @Override // com.huawei.hms.ads.AdListener
            public void onAdClicked() throws JSONException {
                super.onAdClicked();
                WifiLog.d("HWAD native NestHwProvider  onAdClicked");
                NestHuaweiNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_CLICK);
                IStrategyListener iStrategyListener = listenerStrategy;
                if (iStrategyListener != null) {
                    iStrategyListener.onAdClicked(nestAdData, SDKAlias.HUAWEI.getType());
                }
            }

            @Override // com.huawei.hms.ads.AdListener
            public void onAdClosed() {
                super.onAdClosed();
                WifiLog.d("HWAD native NestHwProvider  onAdClosed");
            }

            @Override // com.huawei.hms.ads.AdListener
            public void onAdFailed(int code) {
                super.onAdFailed(code);
                EventReporter eventReporter2 = EventReporter.INSTANCE;
                NestAdData nestAdData2 = nestAdData;
                EventParams.Builder builder3 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder3, "builder");
                eventReporter2.reportNoRespDi(nestAdData2, builder3, String.valueOf(code), String.valueOf(code));
                WifiLog.d("HWAD NestOppoProvider getNativeAd onError code = " + String.valueOf(code));
                IStrategyListener iStrategyListener = listenerStrategy;
                if (iStrategyListener != null) {
                    iStrategyListener.onAdFailed(nestAdData, String.valueOf(code), code);
                }
            }

            @Override // com.huawei.hms.ads.AdListener
            public void onAdImpression() throws JSONException {
                super.onAdImpression();
                WifiLog.d("HWAD native NestHwProvider  onAdImpression code " + nestAdData.getAdCode());
                NestHuaweiNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_SHOW);
                IStrategyListener iStrategyListener = listenerStrategy;
                if (iStrategyListener != null) {
                    iStrategyListener.onAdExpose(nestAdData, SDKAlias.HUAWEI.getType());
                }
            }

            @Override // com.huawei.hms.ads.AdListener
            public void onAdLeave() {
                super.onAdLeave();
                WifiLog.d("HWAD native NestHwProvider  onAdLeave");
            }

            @Override // com.huawei.hms.ads.AdListener
            public void onAdLoaded() {
                super.onAdLoaded();
                WifiLog.d("HWAD native NestHwProvider  onAdLoaded");
            }

            @Override // com.huawei.hms.ads.AdListener
            public void onAdOpened() {
                super.onAdOpened();
                WifiLog.d("HWAD native NestHwProvider  onAdOpened");
            }
        });
        builder2.build().loadAd(new AdParam.Builder().addBiddingParamMap(nestAdData.getAdCode(), new BiddingParam()).setTMax(500).build());
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider
    public BaseNativeView getNativeView(String adProviderType) {
        return new NestHuaweiNativeView();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v15, types: [T, com.huawei.hms.ads.splash.SplashAd] */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.String] */
    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void getSplashAd(ActivityPacker packer, final NestAdData nestAdData, final IStrategyListener listener) {
        String nestType;
        WifiLog.d("HWAD splashAd getSplashAd");
        EventParams.Builder nestSid = new EventParams.Builder().setDspName(DSP_NAME).setNestSid(nestAdData.getNestSid());
        Map<SDKAlias, String> appIds = WifiNestAd.INSTANCE.getAppIds();
        SDKAlias sDKAlias = SDKAlias.HUAWEI;
        EventParams.Builder renderStyle = nestSid.setMediaId(String.valueOf(appIds.get(sDKAlias))).setSrcId(String.valueOf(nestAdData.getAdCode())).setRenderStyle(nestAdData.getRenderStyle());
        AdParams adParams = nestAdData.getAdParams();
        if (adParams == null || (nestType = adParams.getNestType()) == null) {
            nestType = "";
        }
        final EventParams.Builder builder = renderStyle.setNestType(nestType).setInventoryId(nestAdData.getInventoryId()).setSdkFrom("huawei");
        EventReporter eventReporter = EventReporter.INSTANCE;
        Intrinsics.checkExpressionValueIsNotNull(builder, "builder");
        eventReporter.reportReqDi(nestAdData, builder);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new SplashAd(packer.getActivityIfExist());
        String adCode = nestAdData.getAdCode();
        AdParam adParamBuild = new AdParam.Builder().addBiddingParamMap(adCode, new BiddingParam()).setTMax(500).build();
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        objectRef2.element = sDKAlias.getType();
        SplashLoadListener splashLoadListener = new SplashLoadListener() { // from class: com.wifi.huawei.ad.NestHuaweiProvider$getSplashAd$splashAdLoadListener$1
            @Override // com.huawei.hms.ads.splash.listener.SplashLoadListener
            public void onAdFailed(int errorCode) {
                WifiLog.d("HWAD splashAd onAdFailedToLoad errorCode " + errorCode);
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
            @Override // com.huawei.hms.ads.splash.listener.SplashLoadListener
            public void onAdLoaded() {
                int testPriceSwitchEcpm = this.this$0.getTestPriceSwitchEcpm(this.this$0.getHwEcpm(((SplashAd) objectRef.element).getBiddingInfo()), nestAdData);
                WifiLog.d("HWAD NestHwProvider splashAd onAdLoaded priceSwitch price " + testPriceSwitchEcpm + " code " + nestAdData.getAdCode());
                if (testPriceSwitchEcpm > 0) {
                    NestHuaweiProvider nestHuaweiProvider = this.this$0;
                    NestAdData nestAdData2 = nestAdData;
                    EventParams.Builder builder2 = builder;
                    Intrinsics.checkExpressionValueIsNotNull(builder2, "builder");
                    if (nestHuaweiProvider.checkAdEcpmDone(testPriceSwitchEcpm, nestAdData2, builder2, listener)) {
                        return;
                    }
                }
                NestHuaweiProvider nestHuaweiProvider2 = this.this$0;
                NestAdData nestAdData3 = nestAdData;
                EventParams.Builder builder3 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder3, "builder");
                if (nestHuaweiProvider2.checkAdPriceSwitch(testPriceSwitchEcpm, nestAdData3, builder3, listener)) {
                    return;
                }
                NestHuaweiProvider nestHuaweiProvider3 = this.this$0;
                SplashAd splashAd = (SplashAd) objectRef.element;
                String adCode2 = nestAdData.getAdCode();
                AdParams adParams2 = nestAdData.getAdParams();
                List listCatchHuaweiSensitiveInfo = nestHuaweiProvider3.catchHuaweiSensitiveInfo(splashAd, adCode2, adParams2 != null ? adParams2.getExt() : null, nestAdData.getAdLevel());
                ArrayList arrayList = new ArrayList();
                NestAdData nestAdData4 = nestAdData;
                nestAdData4.setDspName(NestHuaweiProvider.DSP_NAME);
                nestAdData4.setAppId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.HUAWEI)));
                nestAdData4.setSdkFrom("huawei");
                nestAdData4.setAdData((SplashAd) objectRef.element);
                if (listCatchHuaweiSensitiveInfo != null && (!listCatchHuaweiSensitiveInfo.isEmpty())) {
                    nestAdData4.setSensitiveInfo((SensitiveInfo) listCatchHuaweiSensitiveInfo.get(0));
                }
                this.this$0.checkEcpm(nestAdData, ((SplashAd) objectRef.element).getBiddingInfo());
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
        };
        ((SplashAd) objectRef.element).setSplashListener(new SplashListener() { // from class: com.wifi.huawei.ad.NestHuaweiProvider$getSplashAd$splashListener$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.huawei.hms.ads.splash.listener.SplashListener
            public void onAdDismissed() throws JSONException {
                WifiLog.d("HWAD splashAd onAdDismissed");
                NestHuaweiNativeView.INSTANCE.onEvent(nestAdData, "nest_sdk_cancle_click");
                SplashShowListener splashShowListener = nestAdData.getSplashShowListener();
                if (splashShowListener != null) {
                    splashShowListener.onAdSkip((String) objectRef2.element, nestAdData);
                }
            }

            @Override // com.huawei.hms.ads.splash.listener.SplashListener
            public void onAdError(int p0) {
                WifiLog.d("HWAD splashAd onAdError p0 " + p0);
            }

            @Override // com.huawei.hms.ads.splash.listener.SplashListener
            public void onAdShowStart() {
            }
        });
        ((SplashAd) objectRef.element).setAdParam(adCode, 1, adParamBuild);
        ((SplashAd) objectRef.element).setAudioFocusType(1);
        ((SplashAd) objectRef.element).loadAd(splashLoadListener);
        WifiLog.d("HWAD splashAd load slotId " + adCode);
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void getTemplateFeedAd(ActivityPacker packer, final NestAdData nestAdData, final IStrategyListener listenerStrategy) {
        String nestType;
        AdSize adSize;
        listenerStrategy.onStart(nestAdData);
        EventParams.Builder renderStyle = new EventParams.Builder().setDspName(DSP_NAME).setNestSid(nestAdData.getNestSid()).setMediaId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.HUAWEI))).setSrcId(String.valueOf(nestAdData.getAdCode())).setRenderStyle(nestAdData.getRenderStyle());
        AdParams adParams = nestAdData.getAdParams();
        if (adParams == null || (nestType = adParams.getNestType()) == null) {
            nestType = "";
        }
        final EventParams.Builder builder = renderStyle.setNestType(nestType).setInventoryId(nestAdData.getInventoryId()).setSdkFrom("huawei");
        EventReporter eventReporter = EventReporter.INSTANCE;
        Intrinsics.checkExpressionValueIsNotNull(builder, "builder");
        eventReporter.reportReqDi(nestAdData, builder);
        AdParams adParams2 = nestAdData.getAdParams();
        if (adParams2 != null && (adSize = adParams2.getAdSize()) != null) {
            adSize.getHuaWeiWidth();
            adSize.getHuaWieHeight();
        }
        String adCode = nestAdData.getAdCode();
        WifiLog.d("HWAD HuaWeiView getTemplateFeedAd codeId " + adCode);
        NativeAdLoader.Builder builder2 = new NativeAdLoader.Builder(packer.getAppContext(), adCode);
        builder2.setNativeAdLoadedListener(new NestHuaweiProvider$getTemplateFeedAd$nativeAdLoaderListener$1(this, nestAdData, builder, listenerStrategy, packer));
        builder2.setAdListener(new AdListener() { // from class: com.wifi.huawei.ad.NestHuaweiProvider$getTemplateFeedAd$adListener$1
            @Override // com.huawei.hms.ads.AdListener
            public void onAdClicked() throws JSONException {
                super.onAdClicked();
                WifiLog.d("HWAD NestHwProvider  onAdClicked");
                NestHuaweiNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_CLICK);
                IStrategyListener iStrategyListener = listenerStrategy;
                if (iStrategyListener != null) {
                    iStrategyListener.onAdClicked(nestAdData, SDKAlias.HUAWEI.getType());
                }
            }

            @Override // com.huawei.hms.ads.AdListener
            public void onAdClosed() {
                super.onAdClosed();
                WifiLog.d("HWAD NestHwProvider  onAdClosed");
                IStrategyListener iStrategyListener = listenerStrategy;
                if (iStrategyListener != null) {
                    iStrategyListener.onDislikeClicked(nestAdData, "");
                }
            }

            @Override // com.huawei.hms.ads.AdListener
            public void onAdFailed(int code) {
                super.onAdFailed(code);
                EventReporter eventReporter2 = EventReporter.INSTANCE;
                NestAdData nestAdData2 = nestAdData;
                EventParams.Builder builder3 = builder;
                Intrinsics.checkExpressionValueIsNotNull(builder3, "builder");
                eventReporter2.reportNoRespDi(nestAdData2, builder3, String.valueOf(code), String.valueOf(code));
                WifiLog.d("HWAD NestHwProvider  onError code = " + String.valueOf(code));
                IStrategyListener iStrategyListener = listenerStrategy;
                if (iStrategyListener != null) {
                    iStrategyListener.onAdFailed(nestAdData, String.valueOf(code), code);
                }
            }

            @Override // com.huawei.hms.ads.AdListener
            public void onAdImpression() throws JSONException {
                super.onAdImpression();
                WifiLog.d("HWAD NestHwProvider  onAdImpression code " + nestAdData.getAdCode());
                NestHuaweiNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_SHOW);
                IStrategyListener iStrategyListener = listenerStrategy;
                if (iStrategyListener != null) {
                    iStrategyListener.onAdExpose(nestAdData, SDKAlias.HUAWEI.getType());
                }
            }

            @Override // com.huawei.hms.ads.AdListener
            public void onAdLeave() {
                super.onAdLeave();
                WifiLog.d("HWAD NestHwProvider  onAdLeave");
            }

            @Override // com.huawei.hms.ads.AdListener
            public void onAdLoaded() {
                super.onAdLoaded();
                WifiLog.d("HWAD NestHwProvider  onAdLoaded");
            }

            @Override // com.huawei.hms.ads.AdListener
            public void onAdOpened() {
                super.onAdOpened();
                WifiLog.d("HWAD NestHwProvider  onAdOpened");
            }
        });
        builder2.build().loadAd(new AdParam.Builder().addBiddingParamMap(adCode, new BiddingParam()).setTMax(500).setSupportTemplate(true).build());
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public boolean interstitialAdIsBelongTheProvider(NestAdData adObject) {
        Object adData = adObject.getAdData();
        if (adData != null) {
            return adData instanceof InterstitialAd;
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
    public void showInterstitialAd(Activity activity, NestAdData nestAdData, PopShowListener showListener) throws JSONException {
        NestHuaweiNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_TOSHOW);
        if (activity.isFinishing()) {
            return;
        }
        nestAdData.setPopshowListener(showListener);
        WifiLog.d("HWAD showInterstitialAd " + nestAdData.getAdData());
        if (nestAdData.getAdData() instanceof InterstitialAd) {
            Object adData = nestAdData.getAdData();
            if (adData == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.huawei.hms.ads.InterstitialAd");
            }
            ((InterstitialAd) adData).show(activity);
        }
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [T, java.lang.String] */
    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public void showSplashAd(Activity activity, final NestAdData nestAdData, ViewGroup container, SplashShowListener splashShowListener) throws JSONException {
        WifiLog.d("HWAD splashAd huawei showSplashAd toshow");
        NestHuaweiNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_TOSHOW);
        if (activity.isFinishing()) {
            WifiLog.d("HWAD splashAd huawei showSplashAd activity is error");
            return;
        }
        if (nestAdData.getAdData() instanceof SplashAd) {
            Object adData = nestAdData.getAdData();
            if (adData == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.huawei.hms.ads.splash.SplashAd");
            }
            SplashAd splashAd = (SplashAd) adData;
            SplashView splashView = splashAd.m57getSplashView();
            Intrinsics.checkExpressionValueIsNotNull(splashView, "splashView");
            ViewParent parent = splashView.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(splashView);
            }
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = SDKAlias.HUAWEI.getType();
            splashView.setAdDisplayListener(new SplashAdDisplayListener() { // from class: com.wifi.huawei.ad.NestHuaweiProvider$showSplashAd$adDisplayListener$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.huawei.hms.ads.splash.SplashAdDisplayListener
                public void onAdClick() throws JSONException {
                    WifiLog.d("HWAD splashAd onAdClick");
                    NestHuaweiNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_CLICK);
                    SplashShowListener splashShowListener2 = nestAdData.getSplashShowListener();
                    if (splashShowListener2 != null) {
                        splashShowListener2.onAdClicked((String) objectRef.element, nestAdData);
                    }
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.huawei.hms.ads.splash.SplashAdDisplayListener
                public void onAdShowed() throws JSONException {
                    WifiLog.d("HWAD splashAd onAdShowed");
                    NestHuaweiNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_SHOW);
                    SplashShowListener splashShowListener2 = nestAdData.getSplashShowListener();
                    if (splashShowListener2 != null) {
                        splashShowListener2.onAdExpose((String) objectRef.element, nestAdData);
                    }
                }
            });
            container.addView(splashView, new ViewGroup.LayoutParams(-1, -1));
            container.bringToFront();
            WifiLog.d("HWAD splashAd show load " + splashAd.isLoaded());
            if (splashAd.isLoaded()) {
                splashAd.showAd(false);
            }
        }
    }

    @Override // com.wifi.ad.core.provider.BaseAdProvider, com.wifi.ad.core.provider.IAdProvider
    public boolean splashAdIsBelongTheProvider(NestAdData adObject) {
        return adObject.getAdData() instanceof SplashAd;
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
