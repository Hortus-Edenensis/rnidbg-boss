package com.wifi.ad.core.strategy;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.huawei.openalliance.ad.constant.h;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.config.AdParams;
import com.wifi.ad.core.config.AdProviderLoader;
import com.wifi.ad.core.config.EventParams;
import com.wifi.ad.core.data.BlackListFilterData;
import com.wifi.ad.core.data.FilterConfigBean;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.data.WhiteFilterConfigBean;
import com.wifi.ad.core.helper.ActivityPacker;
import com.wifi.ad.core.listener.BaseListener;
import com.wifi.ad.core.monitor.WkAdConfigManager;
import com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigManager;
import com.wifi.ad.core.p001const.WifiNestConst;
import com.wifi.ad.core.provider.BaseAdProvider;
import com.wifi.ad.core.reporter.AbstractReporter;
import com.wifi.ad.core.reporter.EventReporter;
import com.wifi.ad.core.utils.WifiLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0018\u001a\u0004\u0018\u00010\tH\u0002J \u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J \u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0004H\u0016J\u0016\u0010&\u001a\u00020\u001a2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\t0(H\u0016J\b\u0010)\u001a\u00020\u001aH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/wifi/ad/core/strategy/SerialStrategy;", "Lcom/wifi/ad/core/strategy/AbsStrategy;", "()V", "adsIndex", "", WiseOpenHianalyticsData.UNION_COSTTIME, "", "failMixList", "", "Lcom/wifi/ad/core/data/NestAdData;", "filterConfig", "Lcom/wifi/ad/core/data/FilterConfigBean;", "filterOn", "Ljava/util/concurrent/atomic/AtomicBoolean;", "filtered", "handler", "Landroid/os/Handler;", "isShow", "mixAdsData", "successAdData", "successMixList", "whiteFilterConfig", "Lcom/wifi/ad/core/data/WhiteFilterConfigBean;", "whiteFilterOn", "getNextAdData", h.Code, "", "packer", "Lcom/wifi/ad/core/helper/ActivityPacker;", "adParams", "Lcom/wifi/ad/core/config/AdParams;", "scene", "Lcom/wifi/ad/core/strategy/LoadScene;", "onAdFailed", "nestAdData", "failedMsg", "", "code", "onAdLoaded", "adList", "", "reset", "core_release"}, k = 1, mv = {1, 1, 16})
public final class SerialStrategy extends AbsStrategy {
    private int adsIndex;
    private long costTime;
    private FilterConfigBean filterConfig;
    private NestAdData successAdData;
    private WhiteFilterConfigBean whiteFilterConfig;
    private List<NestAdData> mixAdsData = new ArrayList();
    private List<NestAdData> failMixList = new ArrayList();
    private List<NestAdData> successMixList = new ArrayList();
    private AtomicBoolean isShow = new AtomicBoolean(false);
    private final Handler handler = new Handler();
    private AtomicBoolean filterOn = new AtomicBoolean(false);
    private AtomicBoolean filtered = new AtomicBoolean(false);
    private AtomicBoolean whiteFilterOn = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: private */
    public final NestAdData getNextAdData() {
        int size = this.mixAdsData.size();
        int i = this.adsIndex;
        if (i < 0 || size <= i) {
            return null;
        }
        WifiLog.d("serial getNextAdData");
        NestAdData nestAdData = this.mixAdsData.get(this.adsIndex);
        this.adsIndex++;
        return nestAdData;
    }

    private final void reset() {
        this.successAdData = null;
        this.failMixList.clear();
        this.successMixList.clear();
        this.handler.removeCallbacksAndMessages(null);
        this.adsIndex = 0;
    }

    @Override // com.wifi.ad.core.strategy.AbsStrategy
    public void loadAd(final ActivityPacker packer, final AdParams adParams, final LoadScene scene) {
        if (TextUtils.isEmpty(adParams.getStrategyJson())) {
            AbstractReporter reporter = WifiNestAd.INSTANCE.getReporter();
            EventParams eventParamsBuild = new EventParams.Builder().setErrorCode("50008").setNestType(adParams.getNestType()).build();
            Intrinsics.checkExpressionValueIsNotNull(eventParamsBuild, "EventParams.Builder()\n  …                 .build()");
            reporter.onEvent(WifiNestConst.EventKey.NEST_AD_PARSE_STRATEGY_FAIL, eventParamsBuild, adParams.getExt());
            BaseListener listener = getListener();
            if (listener != null) {
                listener.onAdFailed("50008", "串行策略数据为null");
                return;
            }
            return;
        }
        StrategyManager strategyManager = StrategyManager.INSTANCE;
        String strategyJson = adParams.getStrategyJson();
        if (strategyJson == null) {
            Intrinsics.throwNpe();
        }
        this.mixAdsData = strategyManager.getMixAds(strategyJson, adParams.getExt());
        WifiLog.d("serial parser adStrs " + this.mixAdsData);
        Context appContext = packer.getAppContext();
        Intrinsics.checkExpressionValueIsNotNull(appContext, "packer.appContext");
        requestConfig(appContext, adParams.getAppId());
        this.filterConfig = WkAdConfigManager.getLocalFilterConfig(packer.getAppContext(), adParams.getAppId());
        this.whiteFilterConfig = WkWhiteAdConfigManager.getLocalFilterConfig(packer.getAppContext());
        String taichikeys = strategyManager.getTaichikeys();
        strategyManager.setFilterData(this.filterOn, taichikeys, this.filterConfig);
        strategyManager.setWhiteFilterData(this.whiteFilterOn, taichikeys, this.whiteFilterConfig);
        this.costTime = 0L;
        List<NestAdData> list = this.mixAdsData;
        if (list == null || list.isEmpty()) {
            AbstractReporter reporter2 = WifiNestAd.INSTANCE.getReporter();
            EventParams eventParamsBuild2 = new EventParams.Builder().setNestType(adParams.getNestType()).setErrorCode("50002").build();
            Intrinsics.checkExpressionValueIsNotNull(eventParamsBuild2, "EventParams.Builder()\n  …                 .build()");
            reporter2.onEvent(WifiNestConst.EventKey.NEST_AD_PARSE_STRATEGY_FAIL, eventParamsBuild2, adParams.getExt());
            BaseListener listener2 = getListener();
            if (listener2 != null) {
                listener2.onAdFailed("50002", "串行策略数据解析异常");
                return;
            }
            return;
        }
        reset();
        Runnable runnable = new Runnable() { // from class: com.wifi.ad.core.strategy.SerialStrategy$loadAd$runnable$1
            @Override // java.lang.Runnable
            public void run() {
                String adType;
                NestAdData nextAdData = this.this$0.getNextAdData();
                if (nextAdData == null || (adType = nextAdData.getAdType()) == null) {
                    return;
                }
                WifiLog.d("serial request provider adType= " + adType + ' ');
                BaseAdProvider baseAdProviderLoadAdProvider = AdProviderLoader.INSTANCE.loadAdProvider(adType);
                if (baseAdProviderLoadAdProvider != null) {
                    nextAdData.setAdParams(adParams);
                    nextAdData.setNestSid(String.valueOf(System.currentTimeMillis()) + "_" + adType);
                    nextAdData.setRenderStyle(adParams.getRenderStyle());
                    nextAdData.setAdxType(adParams.getAdxType());
                    baseAdProviderLoadAdProvider.getCorrectAd(packer, nextAdData, this.this$0, scene);
                    this.this$0.handler.postDelayed(this, adParams.getSerialSpaceTime());
                }
            }
        };
        WifiLog.d("scrn_ serial onStart() 需要请求" + this.mixAdsData.size() + "个广告, taiChiKey:" + taichikeys + ", filterOn:" + this.filterOn + ", whiteFilterOn:" + this.whiteFilterOn);
        BaseListener listener3 = getListener();
        if (listener3 != null) {
            listener3.onStart();
        }
        this.handler.post(runnable);
        new Handler().postDelayed(new Runnable() { // from class: com.wifi.ad.core.strategy.SerialStrategy.loadAd.1
            @Override // java.lang.Runnable
            public final void run() {
                SerialStrategy.this.handler.removeCallbacksAndMessages(null);
                if (SerialStrategy.this.successMixList.size() > 0) {
                    EventReporter.INSTANCE.reportResp(adParams);
                }
                if (SerialStrategy.this.isShow.get()) {
                    return;
                }
                SerialStrategy.this.isShow.compareAndSet(false, true);
                WifiLog.d("serial timeout");
                BaseListener listener4 = SerialStrategy.this.getListener();
                if (listener4 != null) {
                    listener4.onAdFailed("30601", "串行请求超时");
                }
            }
        }, adParams.getTotalTimeout());
    }

    @Override // com.wifi.ad.core.strategy.AbsStrategy, com.wifi.ad.core.strategy.IStrategyListener
    public void onAdFailed(NestAdData nestAdData, String failedMsg, int code) {
        BaseListener listener;
        super.onAdFailed(nestAdData, failedMsg, code);
        WifiLog.d("scrn_ serial onAdFailed() failedMsg=" + failedMsg + " code=" + code + ' ' + StrategyManager.INSTANCE.getNestAdInfo(nestAdData));
        this.failMixList.add(nestAdData);
        if (!this.failMixList.containsAll(this.mixAdsData) || (listener = getListener()) == null) {
            return;
        }
        listener.onAdFailed("30602", "串行请求失败");
    }

    @Override // com.wifi.ad.core.strategy.AbsStrategy, com.wifi.ad.core.strategy.IStrategyListener
    public void onAdLoaded(List<NestAdData> adList) {
        String nestType;
        String nestType2;
        super.onAdLoaded(adList);
        if (adList.isEmpty()) {
            return;
        }
        StrategyManager strategyManager = StrategyManager.INSTANCE;
        BlackListFilterData blackListFilterDataShouldFilter = strategyManager.shouldFilter(this.filterOn, this.filterConfig, adList.get(0));
        if ((!adList.isEmpty()) && blackListFilterDataShouldFilter.getShouldFilter()) {
            this.failMixList.add(adList.get(0));
            this.costTime += blackListFilterDataShouldFilter.getCostTime();
            return;
        }
        BlackListFilterData blackListFilterDataShouldFilterWhiteList = strategyManager.shouldFilterWhiteList(this.whiteFilterOn, this.whiteFilterConfig, adList.get(0));
        if (blackListFilterDataShouldFilterWhiteList.getShouldFilter()) {
            this.failMixList.add(adList.get(0));
            this.costTime += blackListFilterDataShouldFilterWhiteList.getCostTime();
            return;
        }
        if (this.isShow.compareAndSet(false, true)) {
            NestAdData nestAdData = adList.get(0);
            this.successAdData = nestAdData;
            if (nestAdData != null) {
                nestAdData.setWinner(true);
                WifiLog.d("serial onAdLoaded()");
                WifiLog.d("scrn_ serial win " + strategyManager.getNestAdInfo(nestAdData));
                EventParams.Builder renderStyle = new EventParams.Builder().setDspName(nestAdData.getDspName()).setNestSid(nestAdData.getNestSid()).setMediaId(nestAdData.getAppId()).setSrcId(nestAdData.getAdCode()).setRenderStyle(nestAdData.getRenderStyle());
                AdParams adParams = nestAdData.getAdParams();
                String str = "";
                if (adParams == null || (nestType = adParams.getNestType()) == null) {
                    nestType = "";
                }
                EventParams.Builder nestType3 = renderStyle.setNestType(nestType);
                Object adMode = nestAdData.getAdMode();
                if (adMode == null) {
                    adMode = "";
                }
                EventParams.Builder inventoryId = nestType3.setAdMode(adMode.toString()).setSdkFrom(nestAdData.getSdkFrom()).setInventoryId(nestAdData.getInventoryId());
                Integer adLevel = nestAdData.getAdLevel();
                if (adLevel == null) {
                    Intrinsics.throwNpe();
                }
                EventParams eventParams = inventoryId.setAdLevel(adLevel.intValue()).build();
                WifiNestAd wifiNestAd = WifiNestAd.INSTANCE;
                AbstractReporter reporter = wifiNestAd.getReporter();
                Intrinsics.checkExpressionValueIsNotNull(eventParams, "eventParams");
                AdParams adParams2 = nestAdData.getAdParams();
                reporter.onEvent(WifiNestConst.EventKey.NEST_SDK_AD_SHENGCHU, eventParams, adParams2 != null ? adParams2.getExt() : null);
                if (this.filtered.get()) {
                    EventParams.Builder renderStyle2 = new EventParams.Builder().setNestSid(nestAdData.getNestSid()).setDspName(nestAdData.getDspName()).setMediaId(nestAdData.getAppId()).setSrcId(nestAdData.getAdCode()).setSdkFrom(nestAdData.getSdkFrom()).setInventoryId(nestAdData.getInventoryId()).setRenderStyle(nestAdData.getRenderStyle());
                    Object adMode2 = nestAdData.getAdMode();
                    if (adMode2 == null) {
                        adMode2 = "";
                    }
                    EventParams.Builder adMode3 = renderStyle2.setAdMode(adMode2.toString());
                    AdParams adParams3 = nestAdData.getAdParams();
                    if (adParams3 != null && (nestType2 = adParams3.getNestType()) != null) {
                        str = nestType2;
                    }
                    EventParams.Builder nestType4 = adMode3.setNestType(str);
                    Integer adLevel2 = nestAdData.getAdLevel();
                    if (adLevel2 == null) {
                        Intrinsics.throwNpe();
                    }
                    EventParams eventParams2 = nestType4.setAdLevel(adLevel2.intValue()).setCostTime(this.costTime).build();
                    AbstractReporter reporter2 = wifiNestAd.getReporter();
                    Intrinsics.checkExpressionValueIsNotNull(eventParams2, "eventParams2");
                    AdParams adParams4 = nestAdData.getAdParams();
                    reporter2.onEvent(WifiNestConst.EventKey.NEST_SDK_AD_BLACKLIST_WINNER, eventParams2, adParams4 != null ? adParams4.getExt() : null);
                }
                BaseListener listener = getListener();
                if (listener != null) {
                    String adType = nestAdData.getAdType();
                    if (adType == null) {
                        Intrinsics.throwNpe();
                    }
                    listener.onAdLoaded(adType, CollectionsKt__CollectionsKt.mutableListOf(nestAdData));
                }
                this.handler.removeCallbacksAndMessages(null);
            }
        }
        this.successMixList.add(adList.get(0));
    }
}
