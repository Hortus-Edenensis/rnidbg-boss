package com.wifi.ad.core.strategy;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.huawei.openalliance.ad.constant.h;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.config.AdParams;
import com.wifi.ad.core.config.AdProviderLoader;
import com.wifi.ad.core.config.EventParams;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import com.wifi.ad.core.data.BlackListFilterData;
import com.wifi.ad.core.data.FilterConfigBean;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.data.NestMixAdLevel;
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
import com.wifi.self.ad.NestWifiProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\tH\u0002J&\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eH\u0002J.\u0010 \u001a\u0004\u0018\u00010\t2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J.\u0010#\u001a\u0004\u0018\u00010\t2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010$\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020\u001fH\u0002J \u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0016J \u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\u001f2\u0006\u00100\u001a\u000201H\u0016J\u0016\u00102\u001a\u00020\u001a2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\t04H\u0016J\b\u00105\u001a\u00020\u001aH\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/wifi/ad/core/strategy/ParallelStrategy;", "Lcom/wifi/ad/core/strategy/AbsStrategy;", "()V", "calculateStrategy", "", "Lcom/wifi/ad/core/data/NestMixAdLevel;", WiseOpenHianalyticsData.UNION_COSTTIME, "", "failMixList", "Lcom/wifi/ad/core/data/NestAdData;", "filterConfig", "Lcom/wifi/ad/core/data/FilterConfigBean;", "filterOn", "Ljava/util/concurrent/atomic/AtomicBoolean;", "filtered", "isShow", "mContext", "Landroid/content/Context;", "mixAdsData", "successMixList", "whiteFilterConfig", "Lcom/wifi/ad/core/data/WhiteFilterConfigBean;", "whiteFilterOn", "applyRealLevelName", "adData", "checkResultSet", "", "isTimeout", "", "ext", "", "", "getShowData", "successList", "failList", "getShowDataWithFilter", "isContainsLetter", "input", h.Code, "packer", "Lcom/wifi/ad/core/helper/ActivityPacker;", "adParams", "Lcom/wifi/ad/core/config/AdParams;", "scene", "Lcom/wifi/ad/core/strategy/LoadScene;", "onAdFailed", "nestAdData", "failedMsg", "code", "", "onAdLoaded", "adList", "", "reset", "core_release"}, k = 1, mv = {1, 1, 16})
public final class ParallelStrategy extends AbsStrategy {
    private long costTime;
    private FilterConfigBean filterConfig;
    private Context mContext;
    private WhiteFilterConfigBean whiteFilterConfig;
    private List<NestAdData> mixAdsData = new ArrayList();
    private List<NestMixAdLevel> calculateStrategy = new ArrayList();
    private List<NestAdData> successMixList = new ArrayList();
    private List<NestAdData> failMixList = new ArrayList();
    private AtomicBoolean isShow = new AtomicBoolean(false);
    private AtomicBoolean filterOn = new AtomicBoolean(false);
    private AtomicBoolean filtered = new AtomicBoolean(false);
    private AtomicBoolean whiteFilterOn = new AtomicBoolean(false);

    /* JADX WARN: Removed duplicated region for block: B:25:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final NestAdData applyRealLevelName(NestAdData adData) {
        String str;
        String adRealLevelName;
        if (Intrinsics.areEqual("guangdiantong", adData.getSdkFrom())) {
            String adRealLevelName2 = adData.getAdRealLevelName();
            if (!(adRealLevelName2 == null || adRealLevelName2.length() == 0)) {
                try {
                    adRealLevelName = adData.getAdRealLevelName();
                    if (adRealLevelName == null) {
                        Intrinsics.throwNpe();
                    }
                } catch (Exception unused) {
                }
                if (isContainsLetter(adRealLevelName)) {
                    str = null;
                } else {
                    String adRealLevelName3 = adData.getAdRealLevelName();
                    if (adRealLevelName3 == null) {
                        Intrinsics.throwNpe();
                    }
                    adData.setAdCost(Integer.parseInt(adRealLevelName3));
                    str = WkAdxAdConfigMg.DSP_NAME_GDT;
                }
            }
        } else if (Intrinsics.areEqual(NestWifiProvider.SDK_FROM, adData.getSdkFrom())) {
            str = "W";
        }
        if (str != null) {
            WifiLog.d("ParallelStrategy applyRealLevelName " + adData);
            for (NestMixAdLevel nestMixAdLevel : StrategyManager.INSTANCE.getMixAdLevels()) {
                if (adData.getAdCost() >= nestMixAdLevel.getEcpm()) {
                    adData.setAdRealLevelName(str + nestMixAdLevel.getLevel());
                    return adData;
                }
            }
            StrategyManager strategyManager = StrategyManager.INSTANCE;
            if (true ^ strategyManager.getMixAdLevels().isEmpty()) {
                adData.setAdRealLevelName(str + strategyManager.getMixAdLevels().size());
            }
        }
        return adData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkResultSet(boolean isTimeout, Map<String, String> ext) {
        String nestType;
        String nestType2;
        NestAdData showDataWithFilter = getShowDataWithFilter(this.successMixList, this.failMixList, isTimeout);
        if (showDataWithFilter == null) {
            if (this.failMixList.containsAll(this.mixAdsData) || this.failMixList.size() + this.successMixList.size() == this.mixAdsData.size()) {
                this.isShow.compareAndSet(false, true);
                BaseListener listener = getListener();
                if (listener != null) {
                    listener.onAdFailed("30602", "并行请求失败");
                    return;
                }
                return;
            }
            if (this.successMixList.size() == 0 && isTimeout) {
                this.isShow.compareAndSet(false, true);
                BaseListener listener2 = getListener();
                if (listener2 != null) {
                    listener2.onAdFailed("30601", "并行请求超时");
                    return;
                }
                return;
            }
            return;
        }
        this.isShow.compareAndSet(false, true);
        showDataWithFilter.setWinner(true);
        for (NestAdData nestAdData : this.successMixList) {
            if (!Intrinsics.areEqual(nestAdData, showDataWithFilter)) {
                nestAdData.sendLossNotification$core_release(false, showDataWithFilter.getAdCost());
            }
        }
        WifiLog.d("scrn_ parallel win " + StrategyManager.INSTANCE.getNestAdInfo(showDataWithFilter));
        BaseListener listener3 = getListener();
        if (listener3 != null) {
            String adType = showDataWithFilter.getAdType();
            if (adType == null) {
                Intrinsics.throwNpe();
            }
            listener3.onAdLoaded(adType, CollectionsKt__CollectionsKt.mutableListOf(showDataWithFilter));
        }
        EventParams.Builder renderStyle = new EventParams.Builder().setNestSid(showDataWithFilter.getNestSid()).setDspName(showDataWithFilter.getDspName()).setMediaId(showDataWithFilter.getAppId()).setSrcId(showDataWithFilter.getAdCode()).setSdkFrom(showDataWithFilter.getSdkFrom()).setInventoryId(showDataWithFilter.getInventoryId()).setRenderStyle(showDataWithFilter.getRenderStyle());
        Object adMode = showDataWithFilter.getAdMode();
        String str = "";
        if (adMode == null) {
            adMode = "";
        }
        EventParams.Builder adMode2 = renderStyle.setAdMode(adMode.toString());
        AdParams adParams = showDataWithFilter.getAdParams();
        if (adParams == null || (nestType = adParams.getNestType()) == null) {
            nestType = "";
        }
        EventParams.Builder nestType3 = adMode2.setNestType(nestType);
        Integer adLevel = showDataWithFilter.getAdLevel();
        if (adLevel == null) {
            Intrinsics.throwNpe();
        }
        EventParams eventParams = nestType3.setAdLevel(adLevel.intValue()).build();
        WifiNestAd wifiNestAd = WifiNestAd.INSTANCE;
        AbstractReporter reporter = wifiNestAd.getReporter();
        Intrinsics.checkExpressionValueIsNotNull(eventParams, "eventParams");
        reporter.onEvent(WifiNestConst.EventKey.NEST_SDK_AD_SHENGCHU, eventParams, ext);
        if (this.filtered.get()) {
            EventParams.Builder renderStyle2 = new EventParams.Builder().setNestSid(showDataWithFilter.getNestSid()).setDspName(showDataWithFilter.getDspName()).setMediaId(showDataWithFilter.getAppId()).setSrcId(showDataWithFilter.getAdCode()).setSdkFrom(showDataWithFilter.getSdkFrom()).setInventoryId(showDataWithFilter.getInventoryId()).setRenderStyle(showDataWithFilter.getRenderStyle());
            Object adMode3 = showDataWithFilter.getAdMode();
            if (adMode3 == null) {
                adMode3 = "";
            }
            EventParams.Builder adMode4 = renderStyle2.setAdMode(adMode3.toString());
            AdParams adParams2 = showDataWithFilter.getAdParams();
            if (adParams2 != null && (nestType2 = adParams2.getNestType()) != null) {
                str = nestType2;
            }
            EventParams.Builder nestType4 = adMode4.setNestType(str);
            Integer adLevel2 = showDataWithFilter.getAdLevel();
            if (adLevel2 == null) {
                Intrinsics.throwNpe();
            }
            EventParams eventParams2 = nestType4.setAdLevel(adLevel2.intValue()).setCostTime(this.costTime).build();
            AbstractReporter reporter2 = wifiNestAd.getReporter();
            Intrinsics.checkExpressionValueIsNotNull(eventParams2, "eventParams");
            reporter2.onEvent(WifiNestConst.EventKey.NEST_SDK_AD_BLACKLIST_WINNER, eventParams2, ext);
        }
    }

    private final NestAdData getShowData(List<NestAdData> successList, List<NestAdData> failList, boolean isTimeout) {
        Iterator<NestMixAdLevel> it = this.calculateStrategy.iterator();
        loop0: while (it.hasNext()) {
            for (NestAdData nestAdData : it.next().getAdSortStrategy()) {
                for (NestAdData nestAdData2 : successList) {
                    if (StringsKt__StringsJVMKt.equals$default(nestAdData.getAdLevelName(), nestAdData2.getAdRealLevelName(), false, 2, null) && StringsKt__StringsJVMKt.equals$default(nestAdData2.getAdCode(), nestAdData.getAdCode(), false, 2, null)) {
                        return nestAdData2;
                    }
                }
                if (!successList.contains(nestAdData) && !failList.contains(nestAdData) && !isTimeout) {
                    break loop0;
                }
            }
        }
        return null;
    }

    private final synchronized NestAdData getShowDataWithFilter(List<NestAdData> successList, List<NestAdData> failList, boolean isTimeout) {
        try {
            Iterator<NestMixAdLevel> it = this.calculateStrategy.iterator();
            while (it.hasNext()) {
                for (NestAdData nestAdData : it.next().getAdSortStrategy()) {
                    Iterator<NestAdData> it2 = successList.iterator();
                    while (it2.hasNext()) {
                        NestAdData next = it2.next();
                        if (StringsKt__StringsJVMKt.equals$default(nestAdData.getAdLevelName(), next.getAdRealLevelName(), false, 2, null) && StringsKt__StringsJVMKt.equals$default(next.getAdCode(), nestAdData.getAdCode(), false, 2, null)) {
                            StrategyManager strategyManager = StrategyManager.INSTANCE;
                            BlackListFilterData blackListFilterDataShouldFilter = strategyManager.shouldFilter(this.filterOn, this.filterConfig, next);
                            this.costTime += blackListFilterDataShouldFilter.getCostTime();
                            if (blackListFilterDataShouldFilter.getShouldFilter()) {
                                this.filtered.set(true);
                            } else {
                                BlackListFilterData blackListFilterDataShouldFilterWhiteList = strategyManager.shouldFilterWhiteList(this.whiteFilterOn, this.whiteFilterConfig, next);
                                this.costTime += blackListFilterDataShouldFilterWhiteList.getCostTime();
                                if (!blackListFilterDataShouldFilterWhiteList.getShouldFilter()) {
                                    return next;
                                }
                                this.filtered.set(true);
                            }
                            it2.remove();
                            failList.add(next);
                        }
                    }
                    if (!successList.contains(nestAdData) && !failList.contains(nestAdData) && !isTimeout) {
                        return null;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private final boolean isContainsLetter(String input) {
        if (TextUtils.isEmpty(input)) {
            return false;
        }
        return Pattern.compile(".*[a-zA-Z]+.*").matcher(input).matches();
    }

    private final void reset() {
        this.successMixList.clear();
        this.failMixList.clear();
        this.isShow.compareAndSet(true, false);
    }

    @Override // com.wifi.ad.core.strategy.AbsStrategy
    public void loadAd(ActivityPacker packer, final AdParams adParams, LoadScene scene) {
        this.mContext = packer.getAppContext();
        Context appContext = packer.getAppContext();
        Intrinsics.checkExpressionValueIsNotNull(appContext, "packer.appContext");
        requestConfig(appContext, adParams.getAppId());
        this.filterConfig = WkAdConfigManager.getLocalFilterConfig(packer.getAppContext(), adParams.getAppId());
        this.whiteFilterConfig = WkWhiteAdConfigManager.getLocalFilterConfig(packer.getAppContext());
        StrategyManager strategyManager = StrategyManager.INSTANCE;
        String taichikeys = strategyManager.getTaichikeys();
        strategyManager.setFilterData(this.filterOn, taichikeys, this.filterConfig);
        strategyManager.setWhiteFilterData(this.whiteFilterOn, taichikeys, this.whiteFilterConfig);
        this.costTime = 0L;
        if (TextUtils.isEmpty(adParams.getStrategyJson())) {
            AbstractReporter reporter = WifiNestAd.INSTANCE.getReporter();
            EventParams eventParamsBuild = new EventParams.Builder().setErrorCode("50007").setNestType(adParams.getNestType()).build();
            Intrinsics.checkExpressionValueIsNotNull(eventParamsBuild, "EventParams.Builder()\n  …                 .build()");
            reporter.onEvent(WifiNestConst.EventKey.NEST_AD_PARSE_STRATEGY_FAIL, eventParamsBuild, adParams.getExt());
            BaseListener listener = getListener();
            if (listener != null) {
                listener.onAdFailed("50007", "并行策略数据为null");
                return;
            }
            return;
        }
        String strategyJson = adParams.getStrategyJson();
        if (strategyJson == null) {
            Intrinsics.throwNpe();
        }
        this.mixAdsData = strategyManager.getMixAds(strategyJson, adParams.getExt());
        WifiLog.d("parallel parser adStrs " + this.mixAdsData);
        List<NestAdData> list = this.mixAdsData;
        if (list == null || list.isEmpty()) {
            AbstractReporter reporter2 = WifiNestAd.INSTANCE.getReporter();
            EventParams eventParamsBuild2 = new EventParams.Builder().setErrorCode("50002").setNestType(adParams.getNestType()).build();
            Intrinsics.checkExpressionValueIsNotNull(eventParamsBuild2, "EventParams.Builder()\n  …                 .build()");
            reporter2.onEvent(WifiNestConst.EventKey.NEST_AD_PARSE_STRATEGY_FAIL, eventParamsBuild2, adParams.getExt());
            BaseListener listener2 = getListener();
            if (listener2 != null) {
                listener2.onAdFailed("50002", "并行策略数据解析异常");
                return;
            }
            return;
        }
        this.calculateStrategy = strategyManager.calculateStrategy();
        WifiLog.d("parallel calculate adStrs " + this.calculateStrategy);
        List<NestMixAdLevel> list2 = this.calculateStrategy;
        if (list2 == null || list2.isEmpty()) {
            AbstractReporter reporter3 = WifiNestAd.INSTANCE.getReporter();
            EventParams eventParamsBuild3 = new EventParams.Builder().setErrorCode("50003").setNestType(adParams.getNestType()).build();
            Intrinsics.checkExpressionValueIsNotNull(eventParamsBuild3, "EventParams.Builder()\n  …                 .build()");
            reporter3.onEvent(WifiNestConst.EventKey.NEST_AD_PARSE_STRATEGY_FAIL, eventParamsBuild3, adParams.getExt());
            BaseListener listener3 = getListener();
            if (listener3 != null) {
                listener3.onAdFailed("50003", "并行策略权重计算异常");
                return;
            }
            return;
        }
        reset();
        WifiLog.d("scrn_ parallel onStart() 需要请求" + this.mixAdsData.size() + "个广告, taiChiKey:" + taichikeys + ", filterOn:" + this.filterOn + ", whiteFilterOn:" + this.whiteFilterOn);
        BaseListener listener4 = getListener();
        if (listener4 != null) {
            listener4.onStart();
        }
        for (NestAdData nestAdData : this.mixAdsData) {
            String adType = nestAdData.getAdType();
            if (adType != null) {
                WifiLog.d("parallel request provider adType= " + adType + ' ');
                BaseAdProvider baseAdProviderLoadAdProvider = AdProviderLoader.INSTANCE.loadAdProvider(adType);
                if (baseAdProviderLoadAdProvider != null) {
                    nestAdData.setAdParams(adParams);
                    nestAdData.setRenderStyle(adParams.getRenderStyle());
                    nestAdData.setNestSid(String.valueOf(System.currentTimeMillis()) + "_" + adType);
                    nestAdData.setAdxType(adParams.getAdxType());
                    baseAdProviderLoadAdProvider.getCorrectAd(packer, nestAdData, this, scene);
                }
            }
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.wifi.ad.core.strategy.ParallelStrategy.loadAd.2
            @Override // java.lang.Runnable
            public final void run() {
                if (!ParallelStrategy.this.isShow.get()) {
                    ParallelStrategy parallelStrategy = ParallelStrategy.this;
                    AdParams adParams2 = adParams;
                    parallelStrategy.checkResultSet(true, adParams2 != null ? adParams2.getExt() : null);
                }
                if (ParallelStrategy.this.successMixList.size() > 0) {
                    EventReporter.INSTANCE.reportResp(adParams, ParallelStrategy.this.successMixList.size());
                }
            }
        }, adParams.getTotalTimeout());
    }

    @Override // com.wifi.ad.core.strategy.AbsStrategy, com.wifi.ad.core.strategy.IStrategyListener
    public void onAdFailed(NestAdData nestAdData, String failedMsg, int code) {
        super.onAdFailed(nestAdData, failedMsg, code);
        WifiLog.d("scrn_ parallel onAdFailed() failedMsg=" + failedMsg + " code=" + code + ' ' + StrategyManager.INSTANCE.getNestAdInfo(nestAdData) + ' ');
        this.failMixList.add(nestAdData);
        if (this.isShow.get()) {
            return;
        }
        AdParams adParams = nestAdData.getAdParams();
        checkResultSet(false, adParams != null ? adParams.getExt() : null);
    }

    @Override // com.wifi.ad.core.strategy.AbsStrategy, com.wifi.ad.core.strategy.IStrategyListener
    public void onAdLoaded(List<NestAdData> adList) {
        AdParams adParams;
        super.onAdLoaded(adList);
        NestAdData nestAdDataApplyRealLevelName = applyRealLevelName(adList.get(0));
        WifiLog.d("scrn_ parallel onAdLoaded() " + StrategyManager.INSTANCE.getNestAdInfo(nestAdDataApplyRealLevelName));
        this.successMixList.add(nestAdDataApplyRealLevelName);
        if (this.isShow.get() || adList.isEmpty()) {
            return;
        }
        checkResultSet(false, (nestAdDataApplyRealLevelName == null || (adParams = nestAdDataApplyRealLevelName.getAdParams()) == null) ? null : adParams.getExt());
    }
}
