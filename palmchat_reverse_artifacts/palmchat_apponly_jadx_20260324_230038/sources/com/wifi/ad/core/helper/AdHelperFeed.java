package com.wifi.ad.core.helper;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.heytap.msp.mobad.api.params.INativeAdvanceData;
import com.huawei.openalliance.ad.constant.bq;
import com.wifi.ad.core.R;
import com.wifi.ad.core.SDKAlias;
import com.wifi.ad.core.TogetherAd;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.compliance.AdDownViVoConfig;
import com.wifi.ad.core.config.AdParams;
import com.wifi.ad.core.config.AdProviderLoader;
import com.wifi.ad.core.custom.flow.BaseNativeView;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.feedbanner.ClearLogoNativeAdContainer;
import com.wifi.ad.core.feedbanner.NestHuaWeiNativeAdContainer;
import com.wifi.ad.core.feedbanner.NestOppoNativeAdContainer;
import com.wifi.ad.core.listener.DislikeListener;
import com.wifi.ad.core.listener.FeedLoadListener;
import com.wifi.ad.core.listener.NativeViewListener;
import com.wifi.ad.core.p001const.WifiNestConst;
import com.wifi.ad.core.provider.BaseAdProvider;
import com.wifi.ad.core.reporter.EventReporter;
import com.wifi.ad.core.spstrategy.SPCacheManager;
import com.wifi.ad.core.spstrategy.SPStrategyManager;
import com.wifi.ad.core.strategy.AbsStrategy;
import com.wifi.ad.core.strategy.LoadScene;
import com.wifi.ad.core.strategy.StrategyManager;
import com.wifi.ad.core.utils.AdComplianceUtil;
import com.wifi.ad.core.utils.SpMaterialFilterUtil;
import com.wifi.ad.core.utils.WifiLog;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006J&\u0010\b\u001a\u00020\u00042\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\f2\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u000eJ:\u0010\b\u001a\u00020\u00042\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\f2\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J&\u0010\u0013\u001a\u00020\u00042\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\f2\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u0014\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0015\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0016\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006JI\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010 Je\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0005\u001a\u00020\u00062\u001a\u0010!\u001a\u0016\u0012\u0004\u0012\u00020\u001b\u0018\u00010\"j\n\u0012\u0004\u0012\u00020\u001b\u0018\u0001`#¢\u0006\u0002\u0010$J$\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001b0&2\u0006\u0010\u0005\u001a\u00020\u0006J>\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00192\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010&2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001b0&2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0010\u0010'\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006J&\u0010(\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020*J\u001e\u0010-\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010.\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006J\u0010\u0010/\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006J\u0016\u00100\u001a\u00020\u00192\u0006\u00101\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u00102\u001a\u00020\u00192\u0006\u00101\u001a\u00020\u0019J\u0016\u00103\u001a\u00020\u00192\u0006\u00101\u001a\u00020\u00192\u0006\u00104\u001a\u00020\u0006J\u000e\u00105\u001a\u00020\u00192\u0006\u00101\u001a\u00020\u0019¨\u00066"}, d2 = {"Lcom/wifi/ad/core/helper/AdHelperFeed;", "Lcom/wifi/ad/core/helper/BaseHelper;", "()V", "adClose", "", "nestAdData", "Lcom/wifi/ad/core/data/NestAdData;", "destroyAd", "getFeedAd", "activity", "Landroid/app/Activity;", "adParams", "Lcom/wifi/ad/core/config/AdParams;", bq.f.s, "Lcom/wifi/ad/core/listener/FeedLoadListener;", "dislikeListener", "Lcom/wifi/ad/core/listener/DislikeListener;", "interactionListener", "Lcom/wifi/ad/core/data/NestAdData$AdInteractionListener;", "getNativeFeedAd", "onNestAdLoad", "onNestAdUnLoad", "pauseAd", "registerViewAndAction", "container", "Landroid/view/ViewGroup;", "actionBtn", "Landroid/view/View;", "clickViews", "", "privacyView", "permissionsView", "(Landroid/view/ViewGroup;Landroid/view/View;[Landroid/view/View;Landroid/view/View;Landroid/view/View;Lcom/wifi/ad/core/data/NestAdData;)V", "clickAllowAdViews", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "(Landroid/view/ViewGroup;Landroid/view/View;[Landroid/view/View;Landroid/view/View;Landroid/view/View;Lcom/wifi/ad/core/data/NestAdData;Ljava/util/ArrayList;)V", "creativeViews", "", "resumeAd", "setOppoComInfoViews", "oppoPrivacyView", "Landroid/widget/TextView;", "oppoPermissionsView", "oppoDescView", "showTemplateFeedAd", "startAd", "stopAd", "wrapDecorationIfGDT", "content", "wrapDecorationIfHuawei", "wrapDecorationIfLxAd", "adData", "wrapDecorationIfOppo", "core_release"}, k = 1, mv = {1, 1, 16})
public final class AdHelperFeed extends BaseHelper {
    public static final AdHelperFeed INSTANCE = new AdHelperFeed();

    private AdHelperFeed() {
    }

    public final void adClose(NestAdData nestAdData) {
        try {
            WifiLog.d("adType adClose nestAdData");
            if (Intrinsics.areEqual(SDKAlias.OPPO.getType(), nestAdData.getAdType()) && (nestAdData.getAdData() instanceof INativeAdvanceData)) {
                Object adData = nestAdData.getAdData();
                if (adData == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.heytap.msp.mobad.api.params.INativeAdvanceData");
                }
                ((INativeAdvanceData) adData).release();
            }
        } catch (Exception unused) {
        }
    }

    public final void destroyAd(@NonNull NestAdData nestAdData) {
        Iterator<T> it = TogetherAd.INSTANCE.getMProviders().entrySet().iterator();
        while (it.hasNext()) {
            BaseAdProvider baseAdProviderLoadAdProvider = AdProviderLoader.INSTANCE.loadAdProvider((String) ((Map.Entry) it.next()).getKey());
            if (baseAdProviderLoadAdProvider != null) {
                baseAdProviderLoadAdProvider.destroyAd(nestAdData);
            }
        }
    }

    public final synchronized void getFeedAd(@NonNull Activity activity, @NonNull AdParams adParams, @NonNull FeedLoadListener listener) {
        INSTANCE.getFeedAd(activity, adParams, listener, null, null);
    }

    public final synchronized void getNativeFeedAd(@NonNull Activity activity, @NonNull AdParams adParams, @NonNull FeedLoadListener listener) {
        adParams.setNestType(WifiNestConst.NestTypeConst.NEST_FEED_NATIVE_AD);
        adParams.setRenderStyle$core_release(1);
        getFeedAd(activity, adParams, listener);
    }

    public final void onNestAdLoad(@NonNull NestAdData nestAdData) {
        Iterator<T> it = TogetherAd.INSTANCE.getMProviders().entrySet().iterator();
        while (it.hasNext()) {
            BaseAdProvider baseAdProviderLoadAdProvider = AdProviderLoader.INSTANCE.loadAdProvider((String) ((Map.Entry) it.next()).getKey());
            if (baseAdProviderLoadAdProvider != null) {
                baseAdProviderLoadAdProvider.onNestAdLoad(nestAdData);
            }
        }
    }

    public final void onNestAdUnLoad(@NonNull NestAdData nestAdData) {
        Iterator<T> it = TogetherAd.INSTANCE.getMProviders().entrySet().iterator();
        while (it.hasNext()) {
            BaseAdProvider baseAdProviderLoadAdProvider = AdProviderLoader.INSTANCE.loadAdProvider((String) ((Map.Entry) it.next()).getKey());
            if (baseAdProviderLoadAdProvider != null) {
                baseAdProviderLoadAdProvider.onNestAdUnLoad(nestAdData);
            }
        }
    }

    public final void pauseAd(@NonNull NestAdData nestAdData) {
        Iterator<T> it = TogetherAd.INSTANCE.getMProviders().entrySet().iterator();
        while (it.hasNext()) {
            BaseAdProvider baseAdProviderLoadAdProvider = AdProviderLoader.INSTANCE.loadAdProvider((String) ((Map.Entry) it.next()).getKey());
            if (baseAdProviderLoadAdProvider != null) {
                baseAdProviderLoadAdProvider.pauseAd(nestAdData);
            }
        }
    }

    public final void registerViewAndAction(final ViewGroup container, View actionBtn, View[] clickViews, View privacyView, View permissionsView, final NestAdData nestAdData, ArrayList<View> clickAllowAdViews) {
        int i = 0;
        if (Intrinsics.areEqual(SDKAlias.GDT.getType(), nestAdData.getAdType())) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (actionBtn != null) {
                arrayList2.add(actionBtn);
                actionBtn.setTag(WifiNestConst.OtherConst.TAG_AD_BUTTON);
                arrayList.add(actionBtn);
            }
            if (clickViews != null) {
                int length = clickViews.length;
                while (i < length) {
                    arrayList.add(clickViews[i]);
                    i++;
                }
            }
            if (privacyView != null) {
                privacyView.setOnClickListener(new View.OnClickListener() { // from class: com.wifi.ad.core.helper.AdHelperFeed.registerViewAndAction.3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        String adAppPrivacyUrl = nestAdData.getAdAppPrivacyUrl();
                        if (TextUtils.isEmpty(adAppPrivacyUrl)) {
                            return;
                        }
                        AdComplianceUtil.startCommonWebView(adAppPrivacyUrl, container.getContext().getString(R.string.adsdk_generic_ad_info_privacy), container.getContext());
                    }
                });
            }
            if (permissionsView != null) {
                permissionsView.setOnClickListener(new View.OnClickListener() { // from class: com.wifi.ad.core.helper.AdHelperFeed.registerViewAndAction.4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        String adAppPermissionsUrl = nestAdData.getAdAppPermissionsUrl();
                        if (TextUtils.isEmpty(adAppPermissionsUrl)) {
                            return;
                        }
                        AdComplianceUtil.startCommonWebView(adAppPermissionsUrl, container.getContext().getString(R.string.adsdk_generic_ad_info_permission), container.getContext());
                    }
                });
            }
            ArrayList<View> arrayListCreateClickView = AdDownViVoConfig.createClickView(arrayList, arrayList2, nestAdData, clickAllowAdViews);
            Intrinsics.checkExpressionValueIsNotNull(arrayListCreateClickView, "AdDownViVoConfig.createC…llowAdViews\n            )");
            registerViewAndAction(container, arrayListCreateClickView, nestAdData);
            return;
        }
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        if (actionBtn != null) {
            arrayList4.add(actionBtn);
            actionBtn.setTag(WifiNestConst.OtherConst.TAG_AD_BUTTON);
            arrayList3.add(actionBtn);
        }
        if (clickViews != null) {
            int length2 = clickViews.length;
            while (i < length2) {
                arrayList3.add(clickViews[i]);
                i++;
            }
        }
        if (privacyView != null) {
            arrayList3.add(privacyView);
        }
        if (permissionsView != null) {
            arrayList3.add(permissionsView);
        }
        ArrayList<View> arrayListCreateClickView2 = AdDownViVoConfig.createClickView(arrayList3, arrayList4, nestAdData, clickAllowAdViews);
        Intrinsics.checkExpressionValueIsNotNull(arrayListCreateClickView2, "AdDownViVoConfig.createC…llowAdViews\n            )");
        registerViewAndAction(container, arrayListCreateClickView2, nestAdData);
    }

    public final void resumeAd(@NonNull NestAdData nestAdData) {
        Iterator<T> it = TogetherAd.INSTANCE.getMProviders().entrySet().iterator();
        while (it.hasNext()) {
            BaseAdProvider baseAdProviderLoadAdProvider = AdProviderLoader.INSTANCE.loadAdProvider((String) ((Map.Entry) it.next()).getKey());
            if (baseAdProviderLoadAdProvider != null) {
                baseAdProviderLoadAdProvider.resumeAd(nestAdData);
            }
        }
    }

    public final void setOppoComInfoViews(NestAdData nestAdData, TextView oppoPrivacyView, TextView oppoPermissionsView, TextView oppoDescView) {
        try {
            WifiLog.d("OPPOCOMINFO setOppoComInfoViews oppoPrivacyView " + oppoPrivacyView + " oppoPermissionsView " + oppoPermissionsView + " oppoDescView " + oppoDescView + " data " + nestAdData);
            if (Intrinsics.areEqual(nestAdData.getAdType(), SDKAlias.OPPO.getType())) {
                nestAdData.setOppoPrivacyView(oppoPrivacyView);
                nestAdData.setOppoPermissionsView(oppoPermissionsView);
                nestAdData.setOppoDescView(oppoDescView);
            }
        } catch (Exception unused) {
        }
    }

    public final void showTemplateFeedAd(ViewGroup container, NestAdData nestAdData, Activity activity) {
        INSTANCE.registerViewAndAction(container, new ArrayList(), new ArrayList(), nestAdData, activity);
    }

    public final void startAd(@NonNull NestAdData nestAdData) {
        Iterator<T> it = TogetherAd.INSTANCE.getMProviders().entrySet().iterator();
        while (it.hasNext()) {
            BaseAdProvider baseAdProviderLoadAdProvider = AdProviderLoader.INSTANCE.loadAdProvider((String) ((Map.Entry) it.next()).getKey());
            if (baseAdProviderLoadAdProvider != null) {
                baseAdProviderLoadAdProvider.startAd(nestAdData);
            }
        }
    }

    public final void stopAd(@NonNull NestAdData nestAdData) {
        Iterator<T> it = TogetherAd.INSTANCE.getMProviders().entrySet().iterator();
        while (it.hasNext()) {
            BaseAdProvider baseAdProviderLoadAdProvider = AdProviderLoader.INSTANCE.loadAdProvider((String) ((Map.Entry) it.next()).getKey());
            if (baseAdProviderLoadAdProvider != null) {
                baseAdProviderLoadAdProvider.stopAd(nestAdData);
            }
        }
    }

    public final ViewGroup wrapDecorationIfGDT(ViewGroup content, NestAdData nestAdData) {
        try {
            if (Intrinsics.areEqual(SDKAlias.OPPO.getType(), nestAdData.getAdType())) {
                return wrapDecorationIfOppo(content);
            }
            if (Intrinsics.areEqual(SDKAlias.HUAWEI.getType(), nestAdData.getAdType())) {
                return wrapDecorationIfHuawei(content);
            }
            if (Intrinsics.areEqual(SDKAlias.LXAD.getType(), nestAdData.getAdType())) {
                return wrapDecorationIfLxAd(content, nestAdData);
            }
            if (!Intrinsics.areEqual(SDKAlias.GDT.getType(), nestAdData.getAdType())) {
                return content;
            }
            ViewParent parent = content.getParent();
            if (parent != null && !(parent instanceof ViewGroup)) {
                return content;
            }
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(content);
            }
            ClearLogoNativeAdContainer clearLogoNativeAdContainer = new ClearLogoNativeAdContainer(content.getContext());
            clearLogoNativeAdContainer.addView(content, new ViewGroup.LayoutParams(-1, -1));
            return clearLogoNativeAdContainer;
        } catch (Exception unused) {
            return content;
        }
    }

    public final ViewGroup wrapDecorationIfHuawei(ViewGroup content) {
        ViewParent parent = content.getParent();
        WifiLog.d("OppoAd wrapDecorationIfHuawei parent " + parent);
        if (parent != null && !(parent instanceof ViewGroup)) {
            return content;
        }
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(content);
        }
        NestHuaWeiNativeAdContainer nestHuaWeiNativeAdContainer = new NestHuaWeiNativeAdContainer(content.getContext());
        nestHuaWeiNativeAdContainer.addView(content, new ViewGroup.LayoutParams(-1, -1));
        return nestHuaWeiNativeAdContainer;
    }

    public final ViewGroup wrapDecorationIfLxAd(ViewGroup content, NestAdData adData) {
        ViewParent parent = content.getParent();
        WifiLog.d("LxAd wrapDecorationIfLxAd parent " + parent);
        if ((parent == null || (parent instanceof ViewGroup)) && adData.getAdData() != null) {
            try {
                Object adData2 = adData.getAdData();
                if (adData2 == null) {
                    Intrinsics.throwNpe();
                }
                Method declaredMethod = adData2.getClass().getDeclaredMethod("createLxAdNativeContainer", NestAdData.class);
                Intrinsics.checkExpressionValueIsNotNull(declaredMethod, "adData.adData!!.javaClas…ava\n                    )");
                declaredMethod.setAccessible(true);
                Object objInvoke = declaredMethod.invoke(adData.getAdData(), adData);
                WifiLog.d("LxAd wrapDecorationIfLxAd adNativeContainer " + objInvoke);
                if (objInvoke instanceof ViewGroup) {
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).removeView(content);
                    }
                    ((ViewGroup) objInvoke).addView(content, new ViewGroup.LayoutParams(-1, -1));
                    return (ViewGroup) objInvoke;
                }
            } catch (Exception unused) {
            }
        }
        return content;
    }

    public final ViewGroup wrapDecorationIfOppo(ViewGroup content) {
        ViewParent parent = content.getParent();
        WifiLog.d("OppoAd wrapDecorationIfOppo parent " + parent);
        if (parent != null && !(parent instanceof ViewGroup)) {
            return content;
        }
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(content);
        }
        NestOppoNativeAdContainer nestOppoNativeAdContainer = new NestOppoNativeAdContainer(content.getContext());
        nestOppoNativeAdContainer.addView(content, new ViewGroup.LayoutParams(-1, -1));
        return nestOppoNativeAdContainer;
    }

    public final synchronized void getFeedAd(@NonNull Activity activity, @NonNull final AdParams adParams, @NonNull final FeedLoadListener listener, final DislikeListener dislikeListener, final NestAdData.AdInteractionListener interactionListener) {
        WifiLog.d("getFeedAd");
        ActivityPacker activityPacker = new ActivityPacker(activity);
        if (!Intrinsics.areEqual(adParams.getNestType(), WifiNestConst.NestTypeConst.NEST_FEED_NATIVE_AD)) {
            adParams.setNestType(WifiNestConst.NestTypeConst.NEST_FEED_AD);
        }
        if (adParams.getRenderStyle() != 1) {
            adParams.setRenderStyle$core_release(2);
        }
        StrategyManager strategyManager = StrategyManager.INSTANCE;
        Context appContext = activityPacker.getAppContext();
        Intrinsics.checkExpressionValueIsNotNull(appContext, "packer.appContext");
        final AbsStrategy currentStrategy = strategyManager.getCurrentStrategy(adParams, listener, appContext);
        if (currentStrategy != null) {
            currentStrategy.setLoadListener(new FeedLoadListener() { // from class: com.wifi.ad.core.helper.AdHelperFeed.getFeedAd.1
                @Override // com.wifi.ad.core.listener.FeedLoadListener, com.wifi.ad.core.listener.BaseListener
                public void onAdFailed(String errorCode, String message) {
                    WifiLog.d("FeedAd onAdFailed errorCode = " + errorCode + " message = " + message);
                    FeedLoadListener feedLoadListener = listener;
                    if (feedLoadListener != null) {
                        feedLoadListener.onAdFailed(errorCode, message);
                    }
                }

                @Override // com.wifi.ad.core.listener.FeedLoadListener, com.wifi.ad.core.listener.BaseListener
                public void onAdLoaded(String providerType, List<NestAdData> adList) {
                    WifiLog.d("FeedAd onAdLoaded " + adList);
                    FeedLoadListener feedLoadListener = listener;
                    if (feedLoadListener != null) {
                        feedLoadListener.onAdLoaded(providerType, adList);
                    }
                }

                @Override // com.wifi.ad.core.listener.FeedLoadListener, com.wifi.ad.core.listener.BaseListener
                public void onStart() {
                    WifiLog.d("FeedAd onStart");
                    FeedLoadListener feedLoadListener = listener;
                    if (feedLoadListener != null) {
                        feedLoadListener.onStart();
                    }
                    EventReporter.INSTANCE.reportReq(adParams);
                }
            });
            if (dislikeListener != null) {
                currentStrategy.setAdDislikeListenerYWF(dislikeListener);
            }
            currentStrategy.setAdDislikeListener(new DislikeListener() { // from class: com.wifi.ad.core.helper.AdHelperFeed.getFeedAd.2
                @Override // com.wifi.ad.core.listener.DislikeListener
                public void onDislikeClicked(NestAdData nestAdData, String reason) {
                    if (!(currentStrategy instanceof SPStrategyManager)) {
                        DislikeListener dislikeListener2 = dislikeListener;
                        if (dislikeListener2 != null) {
                            dislikeListener2.onDislikeClicked(nestAdData, reason);
                            return;
                        }
                        return;
                    }
                    AbsStrategy strategyListener = nestAdData.getStrategyListener();
                    DislikeListener dislikeListenerYWF = strategyListener != null ? strategyListener.getDislikeListenerYWF() : null;
                    if (dislikeListenerYWF != null) {
                        dislikeListenerYWF.onDislikeClicked(nestAdData, reason);
                        return;
                    }
                    DislikeListener dislikeListener3 = dislikeListener;
                    if (dislikeListener3 != null) {
                        dislikeListener3.onDislikeClicked(nestAdData, reason);
                    }
                }
            });
            currentStrategy.setAdInteractionListener(new NestAdData.AdInteractionListener() { // from class: com.wifi.ad.core.helper.AdHelperFeed.getFeedAd.3
                @Override // com.wifi.ad.core.data.NestAdData.AdInteractionListener
                public void onAdClicked(NestAdData adData) {
                    NestAdData.AdInteractionListener adInteractionListener = interactionListener;
                    if (adInteractionListener != null) {
                        adInteractionListener.onAdClicked(adData);
                    }
                    NestAdData.AdInteractionListener adInteractionListener2 = adData.getAdInteractionListener();
                    if (adInteractionListener2 != null) {
                        adInteractionListener2.onAdClicked(adData);
                    }
                }

                @Override // com.wifi.ad.core.data.NestAdData.AdInteractionListener
                public void onAdExposed(NestAdData adData) {
                    NestAdData.AdInteractionListener adInteractionListener = interactionListener;
                    if (adInteractionListener != null) {
                        adInteractionListener.onAdExposed(adData);
                    }
                    NestAdData.AdInteractionListener adInteractionListener2 = adData.getAdInteractionListener();
                    if (adInteractionListener2 != null) {
                        adInteractionListener2.onAdExposed(adData);
                    }
                }
            });
            currentStrategy.loadAd(activityPacker, adParams, LoadScene.FEED);
        }
    }

    public final void registerViewAndAction(final ViewGroup container, View actionBtn, View[] clickViews, View privacyView, View permissionsView, final NestAdData nestAdData) {
        int i = 0;
        if (Intrinsics.areEqual(SDKAlias.GDT.getType(), nestAdData.getAdType())) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (actionBtn != null) {
                arrayList2.add(actionBtn);
                actionBtn.setTag(WifiNestConst.OtherConst.TAG_AD_BUTTON);
                arrayList.add(actionBtn);
            }
            if (clickViews != null) {
                int length = clickViews.length;
                while (i < length) {
                    arrayList.add(clickViews[i]);
                    i++;
                }
            }
            if (privacyView != null) {
                privacyView.setOnClickListener(new View.OnClickListener() { // from class: com.wifi.ad.core.helper.AdHelperFeed.registerViewAndAction.11
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        String adAppPrivacyUrl = nestAdData.getAdAppPrivacyUrl();
                        if (TextUtils.isEmpty(adAppPrivacyUrl)) {
                            return;
                        }
                        AdComplianceUtil.startCommonWebView(adAppPrivacyUrl, container.getContext().getString(R.string.adsdk_generic_ad_info_privacy), container.getContext());
                    }
                });
            }
            if (permissionsView != null) {
                permissionsView.setOnClickListener(new View.OnClickListener() { // from class: com.wifi.ad.core.helper.AdHelperFeed.registerViewAndAction.12
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        String adAppPermissionsUrl = nestAdData.getAdAppPermissionsUrl();
                        if (TextUtils.isEmpty(adAppPermissionsUrl)) {
                            return;
                        }
                        AdComplianceUtil.startCommonWebView(adAppPermissionsUrl, container.getContext().getString(R.string.adsdk_generic_ad_info_permission), container.getContext());
                    }
                });
            }
            ArrayList<View> arrayListCreateClickView = AdDownViVoConfig.createClickView(arrayList, arrayList2, nestAdData, null);
            Intrinsics.checkExpressionValueIsNotNull(arrayListCreateClickView, "AdDownViVoConfig.createC…kViews, nestAdData, null)");
            registerViewAndAction(container, arrayListCreateClickView, nestAdData);
            return;
        }
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        if (actionBtn != null) {
            arrayList4.add(actionBtn);
            actionBtn.setTag(WifiNestConst.OtherConst.TAG_AD_BUTTON);
            arrayList3.add(actionBtn);
        }
        if (clickViews != null) {
            int length2 = clickViews.length;
            while (i < length2) {
                arrayList3.add(clickViews[i]);
                i++;
            }
        }
        if (privacyView != null) {
            arrayList3.add(privacyView);
        }
        if (permissionsView != null) {
            arrayList3.add(permissionsView);
        }
        ArrayList<View> arrayListCreateClickView2 = AdDownViVoConfig.createClickView(arrayList3, arrayList4, nestAdData, null);
        Intrinsics.checkExpressionValueIsNotNull(arrayListCreateClickView2, "AdDownViVoConfig.createC…kViews, nestAdData, null)");
        registerViewAndAction(container, arrayListCreateClickView2, nestAdData);
    }

    public final void registerViewAndAction(ViewGroup container, List<View> creativeViews, NestAdData nestAdData) {
        registerViewAndAction(container, null, creativeViews, nestAdData, null);
    }

    public final void registerViewAndAction(final ViewGroup container, final List<View> clickViews, final List<View> creativeViews, final NestAdData nestAdData, final Activity activity) {
        Iterator<T> it = TogetherAd.INSTANCE.getMProviders().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            BaseAdProvider baseAdProviderLoadAdProvider = AdProviderLoader.INSTANCE.loadAdProvider((String) entry.getKey());
            boolean z = false;
            if (1 != nestAdData.getRenderStyle() ? !(baseAdProviderLoadAdProvider == null || !baseAdProviderLoadAdProvider.feedAdIsBelongTheProvider(nestAdData)) : !(baseAdProviderLoadAdProvider == null || !baseAdProviderLoadAdProvider.feedNativeAdIsBelongTheProvider(nestAdData))) {
                z = true;
            }
            if (z) {
                BaseNativeView nativeView = baseAdProviderLoadAdProvider != null ? baseAdProviderLoadAdProvider.getNativeView((String) entry.getKey()) : null;
                nestAdData.setNativeView(nativeView);
                NativeViewListener nativeViewListener = new NativeViewListener() { // from class: com.wifi.ad.core.helper.AdHelperFeed$registerViewAndAction$$inlined$forEach$lambda$1
                    @Override // com.wifi.ad.core.listener.NativeViewListener
                    public void onAdClicked(String providerType, NestAdData adObject) {
                        NestAdData.AdInteractionListener adInteractionListener = nestAdData.getAdInteractionListener();
                        if (adInteractionListener != null) {
                            adInteractionListener.onAdClicked(adObject);
                        }
                    }

                    @Override // com.wifi.ad.core.listener.NativeViewListener
                    public void onAdExposed(String providerType, NestAdData adObject) {
                        if (adObject.getAdSPStrategy()) {
                            SpMaterialFilterUtil spMaterialFilterUtil = SpMaterialFilterUtil.INSTANCE;
                            ViewGroup viewGroup = container;
                            spMaterialFilterUtil.saveMaterialFrequencyInfo(viewGroup != null ? viewGroup.getContext() : null, adObject);
                            if (!WifiNestAd.INSTANCE.getSwitch58414() && nestAdData.getAdStrategyOptimizeSwitch() != 1) {
                                SPCacheManager.INSTANCE.removeShowAd(adObject);
                            }
                        }
                        NestAdData.AdInteractionListener adInteractionListener = nestAdData.getAdInteractionListener();
                        if (adInteractionListener != null) {
                            adInteractionListener.onAdExposed(adObject);
                        }
                    }

                    @Override // com.wifi.ad.core.listener.NativeViewListener
                    public void onDislikeClicked(String providerType, NestAdData adData) {
                        NestAdData.DislikeListener dislikeListener = nestAdData.getDislikeListener();
                        if (dislikeListener != null) {
                            dislikeListener.onDislikeClicked(nestAdData);
                        }
                    }

                    @Override // com.wifi.ad.core.listener.NativeViewListener
                    public void onDownloadComplete(String providerType, NestAdData adObject) {
                        NestAdData.AppDownloadListener appDownloadListener = nestAdData.getAppDownloadListener();
                        if (appDownloadListener != null) {
                            appDownloadListener.onDownloadComplete(adObject);
                        }
                    }

                    @Override // com.wifi.ad.core.listener.NativeViewListener
                    public void onDownloadFailed(String providerType, NestAdData adObject) {
                        NestAdData.AppDownloadListener appDownloadListener = nestAdData.getAppDownloadListener();
                        if (appDownloadListener != null) {
                            appDownloadListener.onDownloadFailed(adObject);
                        }
                    }

                    @Override // com.wifi.ad.core.listener.NativeViewListener
                    public void onDownloadInstalled(String providerType, NestAdData adObject) {
                        NestAdData.AppDownloadListener appDownloadListener = nestAdData.getAppDownloadListener();
                        if (appDownloadListener != null) {
                            appDownloadListener.onDownloadInstalled(adObject);
                        }
                    }

                    @Override // com.wifi.ad.core.listener.NativeViewListener
                    public void onDownloadPause(String providerType, NestAdData adData) {
                        NestAdData.AppDownloadListener appDownloadListener = nestAdData.getAppDownloadListener();
                        if (appDownloadListener != null) {
                            appDownloadListener.onDownloadPause(adData);
                        }
                    }

                    @Override // com.wifi.ad.core.listener.NativeViewListener
                    public void onDownloadProgress(String str, NestAdData nestAdData2, int i) {
                        NestAdData.AppDownloadListener appDownloadListener = nestAdData.getAppDownloadListener();
                        if (appDownloadListener != null) {
                            appDownloadListener.onDownloadProgress(nestAdData2, i);
                        }
                        AdDownHelper.INSTANCE.setNativeDownClickDone(nestAdData2);
                    }

                    @Override // com.wifi.ad.core.listener.NativeViewListener
                    public void onDownloadStart(String providerType, NestAdData adObject) {
                        NestAdData.AppDownloadListener appDownloadListener = nestAdData.getAppDownloadListener();
                        if (appDownloadListener != null) {
                            appDownloadListener.onDownloadStart(adObject);
                        }
                    }

                    @Override // com.wifi.ad.core.listener.NativeViewListener
                    public void onRenderFail(String str, NestAdData nestAdData2, int i, String str2) {
                        NestAdData.AdRenderListener adRenderListener = nestAdData.getAdRenderListener();
                        if (adRenderListener != null) {
                            adRenderListener.onRenderFail(str, nestAdData2, i, str2);
                        }
                    }

                    @Override // com.wifi.ad.core.listener.NativeViewListener
                    public void onRenderSuccess(String providerType, NestAdData adObject) {
                        NestAdData.AdRenderListener adRenderListener = nestAdData.getAdRenderListener();
                        if (adRenderListener != null) {
                            adRenderListener.onRenderSuccess(providerType, adObject);
                        }
                    }

                    @Override // com.wifi.ad.core.listener.NativeViewListener
                    public void onVideoComplete(String providerType, NestAdData adObject) {
                        NestAdData.VideoAdListener videoAdListener = nestAdData.getVideoAdListener();
                        if (videoAdListener != null) {
                            videoAdListener.onVideoComplete(adObject);
                        }
                    }

                    @Override // com.wifi.ad.core.listener.NativeViewListener
                    public void onVideoError(String providerType, NestAdData adObject) {
                        NestAdData.VideoAdListener videoAdListener = nestAdData.getVideoAdListener();
                        if (videoAdListener != null) {
                            videoAdListener.onVideoError(adObject);
                        }
                    }

                    @Override // com.wifi.ad.core.listener.NativeViewListener
                    public void onVideoPause(String providerType, NestAdData adObject) {
                        NestAdData.VideoAdListener videoAdListener = nestAdData.getVideoAdListener();
                        if (videoAdListener != null) {
                            videoAdListener.onVideoPause(adObject);
                        }
                    }

                    @Override // com.wifi.ad.core.listener.NativeViewListener
                    public void onVideoStart(String providerType, NestAdData adObject) {
                        NestAdData.VideoAdListener videoAdListener = nestAdData.getVideoAdListener();
                        if (videoAdListener != null) {
                            videoAdListener.onVideoStart(adObject);
                        }
                    }

                    @Override // com.wifi.ad.core.listener.NativeViewListener
                    public void onAdClose(String providerType, NestAdData adData) {
                    }

                    @Override // com.wifi.ad.core.listener.NativeViewListener
                    public void onAdCreativeClicked(String providerType, NestAdData adData) {
                    }

                    @Override // com.wifi.ad.core.listener.NativeViewListener
                    public void onDisLikeDialogDismiss(String providerType, NestAdData adData) {
                    }

                    @Override // com.wifi.ad.core.listener.NativeViewListener
                    public void onDisLikeDialogShow(String providerType, NestAdData adData) {
                    }
                };
                if (1 == nestAdData.getRenderStyle()) {
                    if (nativeView != null) {
                        nativeView.registerViewAndActionFeedAd((String) entry.getKey(), container, clickViews, creativeViews, nestAdData, nativeViewListener);
                    }
                } else if (nativeView != null) {
                    nativeView.showTemplateFeedAd((String) entry.getKey(), nestAdData, container, nativeViewListener, activity);
                }
            }
        }
    }
}
