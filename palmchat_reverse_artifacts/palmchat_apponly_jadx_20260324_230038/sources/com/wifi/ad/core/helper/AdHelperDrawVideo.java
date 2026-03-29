package com.wifi.ad.core.helper;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.huawei.openalliance.ad.constant.bq;
import com.wifi.ad.core.TogetherAd;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.config.AdParams;
import com.wifi.ad.core.config.AdProviderLoader;
import com.wifi.ad.core.config.EventParams;
import com.wifi.ad.core.custom.flow.BaseNativeView;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.listener.DrawLoadListener;
import com.wifi.ad.core.listener.DrawShowListener;
import com.wifi.ad.core.listener.NativeViewListener;
import com.wifi.ad.core.p001const.WifiNestConst;
import com.wifi.ad.core.provider.BaseAdProvider;
import com.wifi.ad.core.reporter.EventReporter;
import com.wifi.ad.core.spstrategy.SPCacheManager;
import com.wifi.ad.core.strategy.AbsStrategy;
import com.wifi.ad.core.strategy.LoadScene;
import com.wifi.ad.core.strategy.StrategyManager;
import com.wifi.ad.core.utils.SpMaterialFilterUtil;
import com.wifi.ad.core.utils.WifiLog;
import com.wifi.ad.core.view.AdRootViewWrapper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\b\u001a\u00020\u0005J&\u0010\u000b\u001a\u00020\n2\b\b\u0001\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\u000f2\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0011J&\u0010\u0012\u001a\u00020\n2\b\b\u0001\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\u000f2\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u0013\u001a\u00020\n2\b\b\u0001\u0010\b\u001a\u00020\u0005J\u0010\u0010\u0014\u001a\u00020\n2\b\b\u0001\u0010\b\u001a\u00020\u0005J\u0010\u0010\u0015\u001a\u00020\n2\b\b\u0001\u0010\b\u001a\u00020\u0005J\u0010\u0010\u0016\u001a\u00020\n2\b\b\u0001\u0010\b\u001a\u00020\u0005J\u001e\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u001bJ\u001e\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u001bJ\u0010\u0010\u001d\u001a\u00020\n2\b\b\u0001\u0010\b\u001a\u00020\u0005J\u0010\u0010\u001e\u001a\u00020\n2\b\b\u0001\u0010\b\u001a\u00020\u0005J8\u0010\u001f\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020!H\u0002R*\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/wifi/ad/core/helper/AdHelperDrawVideo;", "Lcom/wifi/ad/core/helper/BaseHelper;", "()V", "allOldAndNewDataMap", "Ljava/util/HashMap;", "Lcom/wifi/ad/core/data/NestAdData;", "Lkotlin/collections/HashMap;", "changeCheckNewData", "adData", "destroyAd", "", "getDrawVideo", "activity", "Landroid/app/Activity;", "adParams", "Lcom/wifi/ad/core/config/AdParams;", bq.f.s, "Lcom/wifi/ad/core/listener/DrawLoadListener;", "getNativeDrawVideo", "onNestAdLoad", "onNestAdUnLoad", "pauseAd", "resumeAd", "showDrawAdVideo", "nestAdData", "videoLayout", "Landroid/view/ViewGroup;", "Lcom/wifi/ad/core/listener/DrawShowListener;", "showNativeDrawAdVideo", "startAd", "stopAd", "updateData", "pauseIcon", "", EventParams.KEY_CT_SDK_POSITION, "showAdButtonTime", "changeAdBtnColorTime", "showAdCardTime", "core_release"}, k = 1, mv = {1, 1, 16})
public final class AdHelperDrawVideo extends BaseHelper {
    public static final AdHelperDrawVideo INSTANCE = new AdHelperDrawVideo();
    private static HashMap<NestAdData, NestAdData> allOldAndNewDataMap = new HashMap<>();

    private AdHelperDrawVideo() {
    }

    private final NestAdData changeCheckNewData(NestAdData adData) {
        if (adData != null && adData.getAdSPStrategy() && allOldAndNewDataMap.containsKey(adData) && (adData = allOldAndNewDataMap.get(adData)) == null) {
            Intrinsics.throwNpe();
        }
        return adData;
    }

    public static /* synthetic */ void getNativeDrawVideo$default(AdHelperDrawVideo adHelperDrawVideo, Activity activity, AdParams adParams, DrawLoadListener drawLoadListener, int i, Object obj) {
        if ((i & 4) != 0) {
            drawLoadListener = null;
        }
        adHelperDrawVideo.getNativeDrawVideo(activity, adParams, drawLoadListener);
    }

    private final void updateData(NestAdData adData, int pauseIcon, int position, int showAdButtonTime, int changeAdBtnColorTime, int showAdCardTime) {
        adData.setPauseIcon(pauseIcon);
        adData.setPosition(position);
        adData.setShowAdButtonTime(showAdButtonTime);
        adData.setChangeAdBtnColorTime(changeAdBtnColorTime);
        adData.setShowAdCardTime(showAdCardTime);
    }

    public final void destroyAd(@NonNull NestAdData adData) {
        NestAdData nestAdDataChangeCheckNewData = changeCheckNewData(adData);
        if (nestAdDataChangeCheckNewData != null) {
            Iterator<T> it = TogetherAd.INSTANCE.getMProviders().entrySet().iterator();
            while (it.hasNext()) {
                BaseAdProvider baseAdProviderLoadAdProvider = AdProviderLoader.INSTANCE.loadAdProvider((String) ((Map.Entry) it.next()).getKey());
                if (baseAdProviderLoadAdProvider != null) {
                    baseAdProviderLoadAdProvider.destroyAd(nestAdDataChangeCheckNewData);
                }
            }
        }
    }

    public final synchronized void getDrawVideo(@NonNull Activity activity, @NonNull final AdParams adParams, @NonNull final DrawLoadListener listener) {
        WifiLog.d("getDrawVideo");
        ActivityPacker activityPacker = new ActivityPacker(activity);
        if (!Intrinsics.areEqual(adParams.getNestType(), WifiNestConst.NestTypeConst.NEST_DRAW_NATIVE_AD)) {
            adParams.setNestType(WifiNestConst.NestTypeConst.NEST_DRAW_AD);
        }
        StrategyManager strategyManager = StrategyManager.INSTANCE;
        Context appContext = activityPacker.getAppContext();
        Intrinsics.checkExpressionValueIsNotNull(appContext, "packer.appContext");
        AbsStrategy currentStrategy = strategyManager.getCurrentStrategy(adParams, listener, appContext);
        if (currentStrategy != null) {
            currentStrategy.setLoadListener(new DrawLoadListener() { // from class: com.wifi.ad.core.helper.AdHelperDrawVideo.getDrawVideo.1
                @Override // com.wifi.ad.core.listener.DrawLoadListener, com.wifi.ad.core.listener.BaseListener
                public void onAdFailed(String errorCode, String message) {
                    WifiLog.d("drawVideo onAdFailed");
                    DrawLoadListener drawLoadListener = listener;
                    if (drawLoadListener != null) {
                        drawLoadListener.onAdFailed(errorCode, message);
                    }
                }

                @Override // com.wifi.ad.core.listener.DrawLoadListener, com.wifi.ad.core.listener.BaseListener
                public void onAdLoaded(String providerType, List<NestAdData> adList) {
                    WifiLog.d("drawVideo onAdLoaded " + adList);
                    DrawLoadListener drawLoadListener = listener;
                    if (drawLoadListener != null) {
                        drawLoadListener.onAdLoaded(providerType, adList);
                    }
                }

                @Override // com.wifi.ad.core.listener.DrawLoadListener, com.wifi.ad.core.listener.BaseListener
                public void onStart() {
                    WifiLog.d("drawVideo onStart");
                    DrawLoadListener drawLoadListener = listener;
                    if (drawLoadListener != null) {
                        drawLoadListener.onStart();
                    }
                    EventReporter.INSTANCE.reportReq(adParams);
                }
            });
            currentStrategy.loadAd(activityPacker, adParams, LoadScene.DRAWAD);
        }
    }

    public final synchronized void getNativeDrawVideo(@NonNull Activity activity, @NonNull AdParams adParams, @NonNull DrawLoadListener listener) {
        adParams.setNestType(WifiNestConst.NestTypeConst.NEST_DRAW_NATIVE_AD);
        adParams.setRenderStyle$core_release(1);
        getDrawVideo(activity, adParams, listener);
    }

    public final void onNestAdLoad(@NonNull NestAdData adData) {
        NestAdData nestAdDataChangeCheckNewData = changeCheckNewData(adData);
        if (nestAdDataChangeCheckNewData != null) {
            Iterator<T> it = TogetherAd.INSTANCE.getMProviders().entrySet().iterator();
            while (it.hasNext()) {
                BaseAdProvider baseAdProviderLoadAdProvider = AdProviderLoader.INSTANCE.loadAdProvider((String) ((Map.Entry) it.next()).getKey());
                if (baseAdProviderLoadAdProvider != null) {
                    baseAdProviderLoadAdProvider.onNestAdLoad(nestAdDataChangeCheckNewData);
                }
            }
        }
    }

    public final void onNestAdUnLoad(@NonNull NestAdData adData) {
        NestAdData nestAdDataChangeCheckNewData = changeCheckNewData(adData);
        if (nestAdDataChangeCheckNewData != null) {
            Iterator<T> it = TogetherAd.INSTANCE.getMProviders().entrySet().iterator();
            while (it.hasNext()) {
                BaseAdProvider baseAdProviderLoadAdProvider = AdProviderLoader.INSTANCE.loadAdProvider((String) ((Map.Entry) it.next()).getKey());
                if (baseAdProviderLoadAdProvider != null) {
                    baseAdProviderLoadAdProvider.onNestAdUnLoad(nestAdDataChangeCheckNewData);
                }
            }
        }
    }

    public final void pauseAd(@NonNull NestAdData adData) {
        NestAdData nestAdDataChangeCheckNewData = changeCheckNewData(adData);
        if (nestAdDataChangeCheckNewData != null) {
            Iterator<T> it = TogetherAd.INSTANCE.getMProviders().entrySet().iterator();
            while (it.hasNext()) {
                BaseAdProvider baseAdProviderLoadAdProvider = AdProviderLoader.INSTANCE.loadAdProvider((String) ((Map.Entry) it.next()).getKey());
                if (baseAdProviderLoadAdProvider != null) {
                    baseAdProviderLoadAdProvider.pauseAd(nestAdDataChangeCheckNewData);
                }
            }
        }
    }

    public final void resumeAd(@NonNull NestAdData adData) {
        NestAdData nestAdDataChangeCheckNewData = changeCheckNewData(adData);
        if (nestAdDataChangeCheckNewData != null) {
            Iterator<T> it = TogetherAd.INSTANCE.getMProviders().entrySet().iterator();
            while (it.hasNext()) {
                BaseAdProvider baseAdProviderLoadAdProvider = AdProviderLoader.INSTANCE.loadAdProvider((String) ((Map.Entry) it.next()).getKey());
                if (baseAdProviderLoadAdProvider != null) {
                    baseAdProviderLoadAdProvider.resumeAd(nestAdDataChangeCheckNewData);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v17, types: [T, com.wifi.ad.core.data.NestAdData, java.lang.Object] */
    public final void showDrawAdVideo(final NestAdData nestAdData, final ViewGroup videoLayout, final DrawShowListener listener) {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = nestAdData;
        if (nestAdData.getAdSPStrategy()) {
            int pauseIcon = ((NestAdData) objectRef.element).getPauseIcon();
            int position = ((NestAdData) objectRef.element).getPosition();
            int showAdButtonTime = ((NestAdData) objectRef.element).getShowAdButtonTime();
            int changeAdBtnColorTime = ((NestAdData) objectRef.element).getChangeAdBtnColorTime();
            int showAdCardTime = ((NestAdData) objectRef.element).getShowAdCardTime();
            T t = objectRef.element;
            NestAdData nestAdData2 = (NestAdData) t;
            ?? ChangeCheckMaxAd = SPCacheManager.INSTANCE.changeCheckMaxAd((NestAdData) t);
            objectRef.element = ChangeCheckMaxAd;
            if (ChangeCheckMaxAd != 0 && (!Intrinsics.areEqual(nestAdData2, (Object) ChangeCheckMaxAd))) {
                allOldAndNewDataMap.put(nestAdData2, (NestAdData) objectRef.element);
            }
            updateData((NestAdData) objectRef.element, pauseIcon, position, showAdButtonTime, changeAdBtnColorTime, showAdCardTime);
        }
        Iterator<T> it = TogetherAd.INSTANCE.getMProviders().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            BaseAdProvider baseAdProviderLoadAdProvider = AdProviderLoader.INSTANCE.loadAdProvider((String) entry.getKey());
            boolean z = false;
            if (1 != ((NestAdData) objectRef.element).getRenderStyle() ? !(baseAdProviderLoadAdProvider == null || !baseAdProviderLoadAdProvider.drawAdIsBelongTheProvider((NestAdData) objectRef.element)) : !(baseAdProviderLoadAdProvider == null || !baseAdProviderLoadAdProvider.drawNativeAdIsBelongTheProvider((NestAdData) objectRef.element))) {
                z = true;
            }
            if (z) {
                BaseNativeView nativeView = baseAdProviderLoadAdProvider != null ? baseAdProviderLoadAdProvider.getNativeView((String) entry.getKey()) : null;
                ((NestAdData) objectRef.element).setNativeView(nativeView);
                NativeViewListener nativeViewListener = new NativeViewListener() { // from class: com.wifi.ad.core.helper.AdHelperDrawVideo$showDrawAdVideo$$inlined$forEach$lambda$1
                    @Override // com.wifi.ad.core.listener.NativeViewListener
                    public void onAdClicked(String providerType, NestAdData adObject) {
                        DrawShowListener drawShowListener = listener;
                        if (drawShowListener != null) {
                            drawShowListener.onAdClicked(providerType, adObject);
                        }
                    }

                    @Override // com.wifi.ad.core.listener.NativeViewListener
                    public void onAdClose(String providerType, NestAdData adObject) {
                        DrawShowListener drawShowListener = listener;
                        if (drawShowListener != null) {
                            drawShowListener.onAdClose(providerType, adObject);
                        }
                        WifiLog.d("onAdClose callback");
                    }

                    @Override // com.wifi.ad.core.listener.NativeViewListener
                    public void onAdExposed(String providerType, NestAdData adObject) {
                        if (adObject.getAdSPStrategy()) {
                            SpMaterialFilterUtil spMaterialFilterUtil = SpMaterialFilterUtil.INSTANCE;
                            ViewGroup viewGroup = videoLayout;
                            spMaterialFilterUtil.saveMaterialFrequencyInfo(viewGroup != null ? viewGroup.getContext() : null, adObject);
                            if (!WifiNestAd.INSTANCE.getSwitch58414() && nestAdData.getAdStrategyOptimizeSwitch() != 1) {
                                SPCacheManager.INSTANCE.removeShowAd(adObject);
                            }
                        }
                        DrawShowListener drawShowListener = listener;
                        if (drawShowListener != null) {
                            drawShowListener.onAdExposed(providerType, adObject);
                        }
                    }

                    @Override // com.wifi.ad.core.listener.NativeViewListener
                    public void onDisLikeDialogDismiss(String providerType, NestAdData adData) {
                        DrawShowListener drawShowListener = listener;
                        if (drawShowListener != null) {
                            drawShowListener.onDisLikeDialogDismiss(providerType, adData);
                        }
                        WifiLog.d("onAdClose callback");
                    }

                    @Override // com.wifi.ad.core.listener.NativeViewListener
                    public void onDisLikeDialogShow(String providerType, NestAdData adData) {
                        DrawShowListener drawShowListener = listener;
                        if (drawShowListener != null) {
                            drawShowListener.onDisLikeDialogShow(providerType, adData);
                        }
                        WifiLog.d("onAdClose callback");
                    }

                    @Override // com.wifi.ad.core.listener.NativeViewListener
                    public void onDownloadComplete(String providerType, NestAdData adObject) {
                        DrawShowListener drawShowListener = listener;
                        if (drawShowListener != null) {
                            drawShowListener.onDownloadComplete(providerType, adObject);
                        }
                    }

                    @Override // com.wifi.ad.core.listener.NativeViewListener
                    public void onDownloadFailed(String providerType, NestAdData adObject) {
                        DrawShowListener drawShowListener = listener;
                        if (drawShowListener != null) {
                            drawShowListener.onDownloadFailed(providerType, adObject);
                        }
                    }

                    @Override // com.wifi.ad.core.listener.NativeViewListener
                    public void onDownloadInstalled(String providerType, NestAdData adObject) {
                        DrawShowListener drawShowListener = listener;
                        if (drawShowListener != null) {
                            drawShowListener.onDownloadInstalled(providerType, adObject);
                        }
                    }

                    @Override // com.wifi.ad.core.listener.NativeViewListener
                    public void onDownloadProgress(String str, NestAdData nestAdData3, int i) {
                        AdDownHelper.INSTANCE.setNativeDownClickDone(nestAdData3);
                    }

                    @Override // com.wifi.ad.core.listener.NativeViewListener
                    public void onDownloadStart(String providerType, NestAdData adObject) {
                        DrawShowListener drawShowListener = listener;
                        if (drawShowListener != null) {
                            drawShowListener.onDownloadStart(providerType, adObject);
                        }
                    }

                    @Override // com.wifi.ad.core.listener.NativeViewListener
                    public void onRenderFail(String str, NestAdData nestAdData3, int i, String str2) {
                        DrawShowListener drawShowListener = listener;
                        if (drawShowListener != null) {
                            drawShowListener.onRenderFail(str, nestAdData3, i, str2);
                        }
                    }

                    @Override // com.wifi.ad.core.listener.NativeViewListener
                    public void onRenderSuccess(String providerType, NestAdData adObject) {
                        DrawShowListener drawShowListener = listener;
                        if (drawShowListener != null) {
                            drawShowListener.onRenderSuccess(providerType, adObject);
                        }
                    }

                    @Override // com.wifi.ad.core.listener.NativeViewListener
                    public void onVideoComplete(String providerType, NestAdData adObject) {
                        DrawShowListener drawShowListener = listener;
                        if (drawShowListener != null) {
                            drawShowListener.onVideoComplete(providerType, adObject);
                        }
                    }

                    @Override // com.wifi.ad.core.listener.NativeViewListener
                    public void onVideoError(String providerType, NestAdData adObject) {
                        DrawShowListener drawShowListener = listener;
                        if (drawShowListener != null) {
                            drawShowListener.onVideoError(providerType, adObject);
                        }
                        Toast.makeText(videoLayout.getContext(), "请稍等，正在努力加载精彩视频...", 1).show();
                    }

                    @Override // com.wifi.ad.core.listener.NativeViewListener
                    public void onVideoPause(String providerType, NestAdData adObject) {
                        DrawShowListener drawShowListener = listener;
                        if (drawShowListener != null) {
                            drawShowListener.onVideoPause(providerType, adObject);
                        }
                    }

                    @Override // com.wifi.ad.core.listener.NativeViewListener
                    public void onVideoStart(String providerType, NestAdData adObject) {
                        DrawShowListener drawShowListener = listener;
                        if (drawShowListener != null) {
                            drawShowListener.onVideoStart(providerType, adObject);
                        }
                    }

                    @Override // com.wifi.ad.core.listener.NativeViewListener
                    public void onAdCreativeClicked(String providerType, NestAdData adData) {
                    }

                    @Override // com.wifi.ad.core.listener.NativeViewListener
                    public void onDislikeClicked(String providerType, NestAdData adData) {
                    }

                    @Override // com.wifi.ad.core.listener.NativeViewListener
                    public void onDownloadPause(String providerType, NestAdData adData) {
                    }
                };
                if (1 == ((NestAdData) objectRef.element).getRenderStyle()) {
                    AdRootViewWrapper adRootViewWrapper = new AdRootViewWrapper(videoLayout.getContext(), videoLayout, nestAdData, nativeViewListener);
                    if (nativeView != null) {
                        nativeView.showNativeDrawVideoAd((String) entry.getKey(), (NestAdData) objectRef.element, adRootViewWrapper, nativeViewListener);
                    }
                } else if (nativeView != null) {
                    nativeView.showDrawVideoAd((String) entry.getKey(), (NestAdData) objectRef.element, videoLayout, nativeViewListener);
                }
            }
        }
    }

    public final void showNativeDrawAdVideo(NestAdData nestAdData, ViewGroup videoLayout, DrawShowListener listener) {
        showDrawAdVideo(nestAdData, videoLayout, listener);
    }

    public final void startAd(@NonNull NestAdData adData) {
        NestAdData nestAdDataChangeCheckNewData = changeCheckNewData(adData);
        if (nestAdDataChangeCheckNewData != null) {
            Iterator<T> it = TogetherAd.INSTANCE.getMProviders().entrySet().iterator();
            while (it.hasNext()) {
                BaseAdProvider baseAdProviderLoadAdProvider = AdProviderLoader.INSTANCE.loadAdProvider((String) ((Map.Entry) it.next()).getKey());
                if (baseAdProviderLoadAdProvider != null) {
                    baseAdProviderLoadAdProvider.startAd(nestAdDataChangeCheckNewData);
                }
            }
        }
    }

    public final void stopAd(@NonNull NestAdData adData) {
        NestAdData nestAdDataChangeCheckNewData = changeCheckNewData(adData);
        if (nestAdDataChangeCheckNewData != null) {
            Iterator<T> it = TogetherAd.INSTANCE.getMProviders().entrySet().iterator();
            while (it.hasNext()) {
                BaseAdProvider baseAdProviderLoadAdProvider = AdProviderLoader.INSTANCE.loadAdProvider((String) ((Map.Entry) it.next()).getKey());
                if (baseAdProviderLoadAdProvider != null) {
                    baseAdProviderLoadAdProvider.stopAd(nestAdDataChangeCheckNewData);
                }
            }
        }
    }
}
