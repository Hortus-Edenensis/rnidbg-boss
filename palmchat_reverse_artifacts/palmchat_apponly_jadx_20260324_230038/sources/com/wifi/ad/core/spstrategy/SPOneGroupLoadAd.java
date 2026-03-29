package com.wifi.ad.core.spstrategy;

import android.os.Handler;
import android.os.Looper;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.config.AdParams;
import com.wifi.ad.core.config.AdProviderLoader;
import com.wifi.ad.core.config.EventParams;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.helper.ActivityPacker;
import com.wifi.ad.core.listener.SPTimeOutListener;
import com.wifi.ad.core.p001const.WifiNestConst;
import com.wifi.ad.core.provider.BaseAdProvider;
import com.wifi.ad.core.reporter.AbstractReporter;
import com.wifi.ad.core.spstrategy.SPStrategyManager;
import com.wifi.ad.core.strategy.IStrategyListener;
import com.wifi.ad.core.strategy.LoadScene;
import com.wifi.ad.core.utils.WifiLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;
import org.json.JSONException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001BQ\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\t\u0012\u0006\u0010\u000e\u001a\u00020\u0007¢\u0006\u0002\u0010\u000fJ\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\fH\u0002J\u0010\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020\fH\u0002J\"\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\f2\b\u0010*\u001a\u0004\u0018\u00010\u00072\u0006\u0010+\u001a\u00020\u0005H\u0002J\"\u0010,\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\f2\b\u0010*\u001a\u0004\u0018\u00010\u00072\u0006\u0010+\u001a\u00020\u0005H\u0002J*\u0010-\u001a\u00020#2\b\u0010*\u001a\u0004\u0018\u00010\u00072\u0006\u0010+\u001a\u00020\u00052\u0006\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u00020(H\u0002J*\u00100\u001a\u00020(2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u00052\b\u0010*\u001a\u0004\u0018\u00010\u00072\u0006\u0010+\u001a\u00020\u0005H\u0002J\"\u00102\u001a\u00020#2\b\u0010*\u001a\u0004\u0018\u00010\u00072\u0006\u0010+\u001a\u00020\u00052\u0006\u0010/\u001a\u00020(H\u0002J*\u00103\u001a\u00020#2\b\u0010*\u001a\u0004\u0018\u00010\u00072\u0006\u0010+\u001a\u00020\u00052\u0006\u00104\u001a\u00020(2\u0006\u00105\u001a\u00020(H\u0002J\u0010\u00106\u001a\u00020\u00052\u0006\u00107\u001a\u00020\u0005H\u0002J\u0006\u00108\u001a\u00020\u0005J\u0006\u00109\u001a\u00020\u0005J\"\u0010:\u001a\u00020(2\b\u0010*\u001a\u0004\u0018\u00010\u00072\u0006\u0010+\u001a\u00020\u00052\u0006\u0010.\u001a\u00020(H\u0002J\u0018\u0010;\u001a\u00020(2\u0006\u0010&\u001a\u00020\f2\u0006\u0010<\u001a\u00020\u0005H\u0002J \u0010=\u001a\u00020#2\u0006\u0010>\u001a\u00020\u00072\b\u0010*\u001a\u0004\u0018\u00010\u00072\u0006\u0010+\u001a\u00020\u0005J0\u0010?\u001a\u00020#2\b\u0010&\u001a\u0004\u0018\u00010\f2\u0006\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u00052\u0006\u0010/\u001a\u00020(J\"\u0010B\u001a\u00020#2\b\u0010&\u001a\u0004\u0018\u00010\f2\b\u0010*\u001a\u0004\u0018\u00010\u00072\u0006\u0010+\u001a\u00020\u0005J\u0006\u0010C\u001a\u00020#J\u001a\u0010D\u001a\u00020#2\b\u0010*\u001a\u0004\u0018\u00010\u00072\u0006\u0010+\u001a\u00020\u0005H\u0002Jh\u0010E\u001a\u00020#2\u0010\u0010F\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\t2\b\u0010G\u001a\u0004\u0018\u00010H2\b\u0010I\u001a\u0004\u0018\u00010J2\b\u0010*\u001a\u0004\u0018\u00010\u00072\u0006\u0010+\u001a\u00020\u00052\b\u0010K\u001a\u0004\u0018\u00010L2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020\u00052\u0006\u0010P\u001a\u00020\u00052\u0006\u0010Q\u001a\u00020\u0005R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\f0\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\f0\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\f0\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006R"}, d2 = {"Lcom/wifi/ad/core/spstrategy/SPOneGroupLoadAd;", "", "spStrategyManager", "Lcom/wifi/ad/core/spstrategy/SPStrategyManager;", "curGroupNum", "", "curStrategyId", "", "allAdsAds", "", "Lcom/wifi/ad/core/spstrategy/SPGroupAdData;", "allFailAds", "Lcom/wifi/ad/core/data/NestAdData;", "allSuccessAds", "advanceRequest", "(Lcom/wifi/ad/core/spstrategy/SPStrategyManager;ILjava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "allAdNum", "", "allCallEd", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getAllCallEd", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "setAllCallEd", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "allFailList", "allSuccessList", "curGroupMaxCost", "curGroupMinCost", "failMixList", "groupTimeOutRequestId", "groupTimeOutSceneId", "mAdvanceRequest", "needWaitAdList", "successMixList", "addFailAdToList", "", "adData", "addSuccessAdToList", "nestAdData", "allFreezetime", "", "mixAdData", "requestId", "adScene", "allowRequestAd", "checkAllAdEnd", "loadSuccess", "allAdFail", "checkAllBackAd", "curMaxEcpm", "checkAllowCall", "findCacheMaxAd", "timeOut", "finishRequest", "findMaxInGroup", "maxEcpm", "getCurGroupMax", "getCurGroupNum", "isAnswerAdLoad", "isNeedWaitAd", "adCost", "needWaitAds", "strategyId", "onAdFailed", "failedMsg", "code", "onAdLoad", "onDestroy", "printAd", "requestGroupAds", "adDatas", "adCurParams", "Lcom/wifi/ad/core/config/AdParams;", "packer", "Lcom/wifi/ad/core/helper/ActivityPacker;", "curScene", "Lcom/wifi/ad/core/strategy/LoadScene;", "listenerStrategy", "Lcom/wifi/ad/core/strategy/IStrategyListener;", "groupTimeOut", "groupMaxCost", "groupMinCost", "core_release"}, k = 1, mv = {1, 1, 16})
public final class SPOneGroupLoadAd {
    private int allAdNum;
    private List<SPGroupAdData> allAdsAds;
    private List<NestAdData> allFailList;
    private List<NestAdData> allSuccessList;
    private int curGroupMaxCost;
    private int curGroupMinCost;
    private int curGroupNum;
    private String curStrategyId;
    private int groupTimeOutSceneId;
    private String mAdvanceRequest;
    private SPStrategyManager spStrategyManager;
    private List<NestAdData> successMixList = new ArrayList();
    private List<NestAdData> failMixList = new ArrayList();
    private List<NestAdData> needWaitAdList = new ArrayList();
    private AtomicBoolean allCallEd = new AtomicBoolean(false);
    private String groupTimeOutRequestId = "";

    public SPOneGroupLoadAd(SPStrategyManager sPStrategyManager, int i, String str, List<SPGroupAdData> list, List<NestAdData> list2, List<NestAdData> list3, String str2) {
        this.allAdsAds = new ArrayList();
        this.allSuccessList = new ArrayList();
        this.allFailList = new ArrayList();
        this.mAdvanceRequest = "";
        this.spStrategyManager = sPStrategyManager;
        this.curGroupNum = i;
        this.curStrategyId = str;
        this.allAdsAds = TypeIntrinsics.asMutableList(list);
        this.allSuccessList = TypeIntrinsics.asMutableList(list3);
        this.allFailList = TypeIntrinsics.asMutableList(list2);
        this.mAdvanceRequest = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addFailAdToList(NestAdData adData) {
        this.failMixList.add(adData);
        this.allFailList.add(adData);
    }

    private final void addSuccessAdToList(NestAdData nestAdData) {
        this.successMixList.add(nestAdData);
        this.allSuccessList.add(nestAdData);
    }

    private final boolean allFreezetime(NestAdData mixAdData, String requestId, int adScene) {
        if (WifiLog.isDebugMode) {
            StringBuilder sb = new StringBuilder();
            sb.append(requestId);
            sb.append(" scene:");
            sb.append(adScene);
            sb.append(" SPAD Freezetime 判断 ");
            if (mixAdData == null) {
                Intrinsics.throwNpe();
            }
            sb.append(mixAdData.getAdCode());
            sb.append(" 配置的冷冻时间freezetime ");
            sb.append(mixAdData.getFreezetime());
            WifiLog.d(sb.toString());
        }
        if (mixAdData == null || mixAdData.getFreezetime() <= 0) {
            return true;
        }
        SPStrategyManager.Companion companion = SPStrategyManager.INSTANCE;
        if (!companion.getFreezeAdSp().containsKey(mixAdData.getAdCode())) {
            return true;
        }
        Long l = companion.getFreezeAdSp().get(mixAdData.getAdCode());
        if (WifiLog.isDebugMode) {
            WifiLog.d(requestId + " scene:" + adScene + " SPAD Freezetime 判断 " + mixAdData.getAdCode() + " freezetime " + mixAdData.getFreezetime() + " lastTime " + l + " System.currentTimeMillis() " + System.currentTimeMillis());
        }
        long jCurrentTimeMillis = System.currentTimeMillis() / ((long) 1000);
        if (l == null) {
            Intrinsics.throwNpe();
        }
        long jLongValue = jCurrentTimeMillis - l.longValue();
        if (jLongValue >= mixAdData.getFreezetime()) {
            return true;
        }
        mixAdData.setFreezeLastTime(((long) mixAdData.getFreezetime()) - jLongValue);
        if (!WifiLog.isDebugMode) {
            return false;
        }
        WifiLog.d(requestId + " scene:" + adScene + " SPAD mixAdData.freezeLastTime " + mixAdData.getFreezeLastTime());
        return false;
    }

    private final int allowRequestAd(NestAdData mixAdData, String requestId, int adScene) {
        SPCacheManager sPCacheManager = SPCacheManager.INSTANCE;
        String str = this.curStrategyId;
        if (str == null) {
            Intrinsics.throwNpe();
        }
        NestAdData nestAdDataFindCacheAd = sPCacheManager.findCacheAd(str, null, requestId, false);
        int adCost = nestAdDataFindCacheAd != null ? nestAdDataFindCacheAd.getAdCost() : 0;
        if (WifiLog.isDebugMode) {
            WifiLog.d(requestId + " scene:" + adScene + " SPAD allowRequestAd curMaxEcpm " + adCost + " mixAdData.adCost " + mixAdData.getAdCost() + " mAdvanceRequest " + this.mAdvanceRequest + " mixAdData.adCost " + mixAdData.getPreRequest());
        }
        if (Intrinsics.areEqual(this.mAdvanceRequest, "1") && mixAdData.getPreRequest() != 1) {
            return -3;
        }
        int adCost2 = mixAdData.getAdCost();
        if (1 > adCost2 || adCost < adCost2) {
            return !allFreezetime(mixAdData, requestId, adScene) ? -2 : 0;
        }
        if (!WifiNestAd.INSTANCE.getSwitch58414() || mixAdData.getAdCostType() != NestAdData.AdCostType.INSTANCE.getADCOSTTYPE_BIDING()) {
            return -1;
        }
        if (!WifiLog.isDebugMode) {
            return 0;
        }
        WifiLog.d(requestId + " scene:" + adScene + " SPAD allowRequestAd adCostType ADCOSTTYPE_BIDING return 0");
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkAllAdEnd(String requestId, int adScene, boolean loadSuccess, boolean allAdFail) throws JSONException {
        if (WifiLog.isDebugMode) {
            WifiLog.d(requestId + " scene:" + adScene + " SPAD SPOneGroupLoadAd checkAllAdEnd 开始判断是否结束 success.size " + this.successMixList.size() + " fail.size " + this.failMixList.size() + " 该组需请求的广告数allAdNum " + this.allAdNum);
        }
        if (!WifiNestAd.INSTANCE.getSwitch58414()) {
            if (isAnswerAdLoad(requestId, adScene, loadSuccess)) {
                findCacheMaxAd(requestId, adScene, false, false);
            }
            if (this.successMixList.size() + this.failMixList.size() == this.allAdNum) {
                checkAllowCall(requestId, adScene, allAdFail);
                return;
            }
            return;
        }
        if (this.successMixList.size() + this.failMixList.size() == this.allAdNum) {
            checkAllowCall(requestId, adScene, allAdFail);
        }
        if (isAnswerAdLoad(requestId, adScene, loadSuccess)) {
            SPCacheManager sPCacheManager = SPCacheManager.INSTANCE;
            String str = this.curStrategyId;
            if (str == null) {
                Intrinsics.throwNpe();
            }
            NestAdData nestAdDataFindCacheAd = sPCacheManager.findCacheAd(str, null, requestId, false);
            int adCost = (nestAdDataFindCacheAd == null || nestAdDataFindCacheAd.getAdCost() <= 0) ? 0 : nestAdDataFindCacheAd.getAdCost();
            if (WifiLog.isDebugMode) {
                WifiLog.d(requestId + " scene:" + adScene + " SPAD SPOneGroupLoadAd checkAllAdEnd maxEcpm " + adCost + " curGroupMinCost " + this.curGroupMinCost);
            }
            if (adCost >= this.curGroupMinCost) {
                findCacheMaxAd(requestId, adScene, false, false);
            }
        }
    }

    private final boolean checkAllBackAd(int curGroupNum, int curMaxEcpm, String requestId, int adScene) {
        if (WifiLog.isDebugMode) {
            WifiLog.d(requestId + " scene:" + adScene + " SPAD requestOtherAd 开始判断回退 curGroupNum " + curGroupNum + " curMaxEcpm " + curMaxEcpm);
        }
        if (curMaxEcpm == 0) {
            if (WifiLog.isDebugMode) {
                WifiLog.d(requestId + " scene:" + adScene + " SPAD requestOtherAd curMaxEcpm=0 允许回退请求");
            }
            return true;
        }
        int iFindMaxInGroup = findMaxInGroup(curMaxEcpm);
        if (WifiLog.isDebugMode) {
            WifiLog.d(requestId + " scene:" + adScene + " SPAD requestOtherAd 当前max 所在组 groupMax " + iFindMaxInGroup);
        }
        if (iFindMaxInGroup <= curGroupNum) {
            return false;
        }
        if (WifiLog.isDebugMode) {
            WifiLog.d(requestId + " scene:" + adScene + " SPAD requestOtherAd 允许回退请求");
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkAllowCall(String requestId, int adScene, boolean allAdFail) throws JSONException {
        if (this.allCallEd.get()) {
            if (WifiLog.isDebugMode) {
                WifiLog.d(requestId + " scene:" + adScene + " SPAD SPOneGroupLoadAd checkAllowCall not allow");
                return;
            }
            return;
        }
        if (WifiLog.isDebugMode) {
            WifiLog.d(requestId + " scene:" + adScene + " SPAD SPOneGroupLoadAd checkAllowCall start allAdFail " + allAdFail);
        }
        this.allCallEd.set(true);
        SPCacheManager sPCacheManager = SPCacheManager.INSTANCE;
        String str = this.curStrategyId;
        if (str == null) {
            Intrinsics.throwNpe();
        }
        NestAdData nestAdDataFindCacheAd = sPCacheManager.findCacheAd(str, null, requestId, false);
        if (checkAllBackAd(this.curGroupNum, (nestAdDataFindCacheAd == null || nestAdDataFindCacheAd.getAdCost() <= 0) ? 0 : nestAdDataFindCacheAd.getAdCost(), requestId, adScene)) {
            SPStrategyManager sPStrategyManager = this.spStrategyManager;
            if (sPStrategyManager == null) {
                Intrinsics.throwNpe();
            }
            int i = this.curGroupNum + 1;
            String str2 = this.curStrategyId;
            if (str2 == null) {
                Intrinsics.throwNpe();
            }
            boolean zStartRequestAd = sPStrategyManager.startRequestAd(i, str2, requestId, adScene, this.mAdvanceRequest);
            if (WifiNestAd.INSTANCE.getSwitch58414()) {
                if (zStartRequestAd) {
                    return;
                }
                findCacheMaxAd(requestId, adScene, false, true);
                return;
            } else {
                if (zStartRequestAd || !allAdFail) {
                    return;
                }
                findCacheMaxAd(requestId, adScene, false, true);
                return;
            }
        }
        SPPriceEventManager sPPriceEventManager = SPPriceEventManager.INSTANCE;
        String str3 = this.curStrategyId;
        if (str3 == null) {
            Intrinsics.throwNpe();
        }
        sPPriceEventManager.eventRequestEndCache(requestId, adScene, sPPriceEventManager.findAllCacheAd(adScene, str3));
        if (WifiLog.isDebugMode) {
            WifiLog.d(requestId + " scene:" + adScene + " SPAD SPOneGroupLoadAd 不需要回退，已经找到该组中的最大值 MDA 胜出 ");
        }
        AbstractReporter reporter = WifiNestAd.INSTANCE.getReporter();
        EventParams eventParamsByAdData = EventParams.getEventParamsByAdData(nestAdDataFindCacheAd);
        Intrinsics.checkExpressionValueIsNotNull(eventParamsByAdData, "EventParams.getEventParamsByAdData(cacheMaxData)");
        if (nestAdDataFindCacheAd == null) {
            Intrinsics.throwNpe();
        }
        AdParams adParams = nestAdDataFindCacheAd.getAdParams();
        if (adParams == null) {
            Intrinsics.throwNpe();
        }
        reporter.onEvent(WifiNestConst.EventKey.NEST_SDK_AD_SHENGCHU, eventParamsByAdData, adParams.getExt());
    }

    private final void findCacheMaxAd(String requestId, int adScene, boolean timeOut, boolean finishRequest) {
        SPStrategyManager sPStrategyManager = this.spStrategyManager;
        if (sPStrategyManager != null) {
            if (sPStrategyManager == null) {
                Intrinsics.throwNpe();
            }
            if (sPStrategyManager.isAnswerHighPriceOpen()) {
                SPStrategyManager sPStrategyManager2 = this.spStrategyManager;
                if (sPStrategyManager2 == null) {
                    Intrinsics.throwNpe();
                }
                String str = this.curStrategyId;
                if (str == null) {
                    Intrinsics.throwNpe();
                }
                sPStrategyManager2.findCacheMaxAd(requestId, str, adScene, timeOut, finishRequest);
            }
        }
    }

    private final int findMaxInGroup(int maxEcpm) {
        int size = this.allAdsAds.size();
        for (int i = 0; i < size; i++) {
            if (maxEcpm >= this.allAdsAds.get(i).getMinEcpm()) {
                return i + 1;
            }
        }
        return 1;
    }

    private final boolean isAnswerAdLoad(String requestId, int adScene, boolean loadSuccess) {
        try {
            SPStrategyManager sPStrategyManager = this.spStrategyManager;
            if (sPStrategyManager != null) {
                if (sPStrategyManager == null) {
                    Intrinsics.throwNpe();
                }
                if (sPStrategyManager.isAnswerHighPriceOpen()) {
                    List<NestAdData> list = this.needWaitAdList;
                    if (list == null || list.isEmpty()) {
                        if (loadSuccess) {
                            if (WifiLog.isDebugMode) {
                                WifiLog.d(requestId + " scene:" + adScene + " SPAD SPOneGroupLoadAd isAnswerAdLoad needWaitAdList.size = 0 最高价格广告已请求成功，应答onAdLoad");
                            }
                            return true;
                        }
                        if (!WifiLog.isDebugMode) {
                            return false;
                        }
                        WifiLog.d(requestId + " scene:" + adScene + " SPAD SPOneGroupLoadAd isAnswerAdLoad needWaitAdList.size = 0");
                        return false;
                    }
                    int size = this.needWaitAdList.size();
                    for (int i = 0; i < size; i++) {
                        NestAdData nestAdData = this.needWaitAdList.get(i);
                        if (WifiLog.isDebugMode) {
                            WifiLog.d(requestId + " scene:" + adScene + " SPAD SPOneGroupLoadAd isAnswerAdLoad 需等待返回结果的广告 " + nestAdData.getAdRealLevelName() + ' ' + nestAdData.getAdCode());
                        }
                        if (!this.allSuccessList.contains(nestAdData) && !this.allFailList.contains(nestAdData)) {
                            if (WifiLog.isDebugMode) {
                                WifiLog.d(requestId + " scene:" + adScene + " SPAD SPOneGroupLoadAd isAnswerAdLoad " + nestAdData.getAdRealLevelName() + ' ' + nestAdData.getAdCode() + " 请求还未返回结果,继续等待");
                            }
                            return false;
                        }
                    }
                    if (WifiLog.isDebugMode) {
                        WifiLog.d(requestId + " scene:" + adScene + " SPAD SPOneGroupLoadAd isAnswerAdLoad 需等待返回结果的广告都已回来，尝试应答onAdLoad");
                    }
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    private final boolean isNeedWaitAd(NestAdData nestAdData, int adCost) {
        if (nestAdData == null) {
            WifiLog.d("SPAD isNeedWaitAd nestAdData == null  adCost " + adCost + "  return true");
            return true;
        }
        SPStrategyManager sPStrategyManager = this.spStrategyManager;
        if (sPStrategyManager != null) {
            if (sPStrategyManager == null) {
                Intrinsics.throwNpe();
            }
            if (sPStrategyManager.isAnswerMaxPriceSwitch()) {
                WifiLog.d("SPAD isNeedWaitAd spStrategyManager != null && isAnswerMaxPriceSwitch = true adCost " + adCost + " nestAdData " + nestAdData.getAdCode());
                if (nestAdData.getAdCostType() == NestAdData.AdCostType.INSTANCE.getADCOSTTYPE_BIDING()) {
                    WifiLog.d("SPAD isNeedWaitAd ADCOSTTYPE_BIDING adCost " + adCost + " return true nestAdData " + nestAdData.getAdCode());
                    return true;
                }
                if (nestAdData.getAdCost() <= adCost) {
                    WifiLog.d("SPAD isNeedWaitAd adCost " + adCost + " return false nestAdData " + nestAdData.getAdCode());
                    return false;
                }
                WifiLog.d("SPAD isNeedWaitAd nestAdData.adCost > adCost nestAdData.adCost " + nestAdData.getAdCost() + "  adCost " + adCost + " return true nestAdData " + nestAdData.getAdCode());
                return true;
            }
        }
        WifiLog.d("SPAD isNeedWaitAd spStrategyManager == null || isAnswerMaxPriceSwitch = false adCost " + adCost + "  return true nestAdData " + nestAdData.getAdCode());
        return true;
    }

    private final void printAd(String requestId, int adScene) {
        int size = this.allSuccessList.size();
        for (int i = 0; i < size; i++) {
            NestAdData nestAdData = this.allSuccessList.get(i);
            if (WifiLog.isDebugMode) {
                WifiLog.d(requestId + " scene:" + adScene + " SPAD SPOneGroupLoadAd isAnswerAdLoad 成功的广告----- " + nestAdData.getAdRealLevelName() + ' ' + nestAdData.getAdCode() + ' ' + nestAdData);
            }
        }
        int size2 = this.allFailList.size();
        for (int i2 = 0; i2 < size2; i2++) {
            NestAdData nestAdData2 = this.allFailList.get(i2);
            if (WifiLog.isDebugMode) {
                WifiLog.d(requestId + " scene:" + adScene + " SPAD SPOneGroupLoadAd isAnswerAdLoad 失败的广告----- " + nestAdData2.getAdRealLevelName() + ' ' + nestAdData2.getAdCode() + ' ' + nestAdData2);
            }
        }
    }

    public final AtomicBoolean getAllCallEd() {
        return this.allCallEd;
    }

    /* JADX INFO: renamed from: getCurGroupMax, reason: from getter */
    public final int getCurGroupMaxCost() {
        return this.curGroupMaxCost;
    }

    public final int getCurGroupNum() {
        return this.curGroupNum;
    }

    public final void needWaitAds(String strategyId, String requestId, int adScene) {
        List<NestAdData> list;
        try {
            SPStrategyManager sPStrategyManager = this.spStrategyManager;
            if (sPStrategyManager != null) {
                if (sPStrategyManager == null) {
                    Intrinsics.throwNpe();
                }
                if (sPStrategyManager.isAnswerHighPriceOpen()) {
                    List<SPGroupAdData> list2 = this.allAdsAds;
                    if (!(list2 == null || list2.isEmpty()) && (list = this.needWaitAdList) != null) {
                        list.clear();
                        NestAdData nestAdDataFindCacheMaxAd = SPCacheManager.INSTANCE.findCacheMaxAd(strategyId, null, requestId);
                        if (nestAdDataFindCacheMaxAd != null) {
                            int adCost = nestAdDataFindCacheMaxAd.getAdCost();
                            int size = this.allAdsAds.size();
                            int i = this.curGroupNum;
                            if (size > i - 1) {
                                SPGroupAdData sPGroupAdData = this.allAdsAds.get(i - 1);
                                List<NestAdData> adDatas = sPGroupAdData != null ? sPGroupAdData.getAdDatas() : null;
                                if (adDatas != null && (true ^ adDatas.isEmpty())) {
                                    int size2 = adDatas.size();
                                    for (int i2 = 0; i2 < size2; i2++) {
                                        NestAdData nestAdData = adDatas.get(i2);
                                        if (isNeedWaitAd(nestAdData, adCost)) {
                                            this.needWaitAdList.add(nestAdData);
                                            if (WifiLog.isDebugMode) {
                                                WifiLog.d(requestId + " scene:" + adScene + " SPAD needWaitAds 需等返回结果的广告:" + nestAdData.getAdRealLevelName() + ' ' + nestAdData.getAdCode() + " 价格:" + nestAdData.getAdCost() + "  当前返回成功的广告 " + nestAdDataFindCacheMaxAd.getAdCode() + " 的价格 " + adCost);
                                            }
                                        }
                                    }
                                }
                            }
                            if (WifiLog.isDebugMode) {
                                WifiLog.d(requestId + " scene:" + adScene + " SPAD needWaitAds 需等返回结果的广告数：" + this.needWaitAdList.size() + "  当前返回成功的广告 " + nestAdDataFindCacheMaxAd.getAdCode() + " 的价格 " + adCost);
                            }
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public final void onAdFailed(NestAdData nestAdData, String failedMsg, int code, int adScene, boolean allAdFail) {
        String requestId = nestAdData != null ? nestAdData.getRequestId() : null;
        if (nestAdData == null) {
            Intrinsics.throwNpe();
        }
        if (nestAdData.getTimeOutOrResEd().get()) {
            if (WifiLog.isDebugMode) {
                WifiLog.d(requestId + " scene:" + adScene + " SPAD time SPOneGroupLoadAd onAdFailed timeOutOrResEd " + nestAdData.getTimeOutOrResEd() + " code " + nestAdData.getAdCode() + " failedMsg " + failedMsg);
                return;
            }
            return;
        }
        nestAdData.getTimeOutOrResEd().set(true);
        if (WifiLog.isDebugMode) {
            WifiLog.d(requestId + " scene:" + adScene + " SPAD SPOneGroupLoadAd onAdFailed 广告失败 failedMsg " + failedMsg + " code " + code + " srcid " + nestAdData.getAdCode());
        }
        addFailAdToList(nestAdData);
        if (WifiNestAd.INSTANCE.getSwitch58414()) {
            String str = this.curStrategyId;
            if (str == null) {
                Intrinsics.throwNpe();
            }
            needWaitAds(str, requestId, adScene);
        }
        checkAllAdEnd(requestId, adScene, false, allAdFail);
        if (nestAdData.getAdCode() != null) {
            if (WifiLog.isDebugMode) {
                WifiLog.d(requestId + " scene:" + adScene + " SPAD Freeze " + nestAdData.getAdCode() + "请求失败，保存冷却时间");
            }
            HashMap<String, Long> freezeAdSp = SPStrategyManager.INSTANCE.getFreezeAdSp();
            String adCode = nestAdData.getAdCode();
            if (adCode == null) {
                Intrinsics.throwNpe();
            }
            freezeAdSp.put(adCode, Long.valueOf(System.currentTimeMillis() / ((long) 1000)));
        }
    }

    public final void onAdLoad(NestAdData nestAdData, String requestId, int adScene) {
        boolean z;
        if (nestAdData != null) {
            if (nestAdData.getTimeOutOrResEd().get()) {
                if (WifiLog.isDebugMode) {
                    WifiLog.d(requestId + " scene:" + adScene + " SPAD time SPOneGroupLoadAd onAdLoad timeOutOrResEd " + nestAdData.getTimeOutOrResEd() + " code " + nestAdData.getAdCode() + " timeOutRes true");
                }
                z = true;
            } else {
                z = false;
            }
            nestAdData.getTimeOutOrResEd().set(true);
            if (WifiLog.isDebugMode) {
                WifiLog.d(requestId + " scene:" + adScene + " SPAD SPOneGroupLoadAd onAdLoad 广告成功 开始存放缓存 code " + nestAdData.getAdCode() + " adcost " + nestAdData.getAdCost());
            }
            SPCacheManager.INSTANCE.saveCacheAd(nestAdData, requestId, adScene);
            String str = this.curStrategyId;
            if (str == null) {
                Intrinsics.throwNpe();
            }
            needWaitAds(str, requestId, adScene);
            if (z) {
                return;
            }
            addSuccessAdToList(nestAdData);
            checkAllAdEnd(requestId, adScene, true, false);
        }
    }

    public final void onDestroy() {
        if (WifiNestAd.INSTANCE.getSwitch77583()) {
            List<SPGroupAdData> list = this.allAdsAds;
            if (list != null) {
                list.clear();
            }
            List<NestAdData> list2 = this.allSuccessList;
            if (list2 != null) {
                list2.clear();
            }
            List<NestAdData> list3 = this.allFailList;
            if (list3 != null) {
                list3.clear();
            }
            List<NestAdData> list4 = this.needWaitAdList;
            if (list4 != null) {
                list4.clear();
            }
            List<NestAdData> list5 = this.successMixList;
            if (list5 != null) {
                list5.clear();
            }
            List<NestAdData> list6 = this.failMixList;
            if (list6 != null) {
                list6.clear();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v6, types: [T, com.wifi.ad.core.data.NestAdData] */
    public final void requestGroupAds(List<NestAdData> adDatas, final AdParams adCurParams, final ActivityPacker packer, final String requestId, final int adScene, final LoadScene curScene, final IStrategyListener listenerStrategy, int groupTimeOut, int groupMaxCost, int groupMinCost) {
        int i;
        int i2;
        int i3;
        String str;
        String str2;
        String str3;
        BaseAdProvider baseAdProvider;
        Ref.ObjectRef objectRef;
        String str4;
        List<NestAdData> list = adDatas;
        AdParams adParams = adCurParams;
        ActivityPacker activityPacker = packer;
        LoadScene loadScene = curScene;
        if (list != null) {
            this.allAdNum = adDatas.size();
            this.groupTimeOutRequestId = requestId;
            this.groupTimeOutSceneId = adScene;
            this.curGroupMaxCost = groupMaxCost;
            this.curGroupMinCost = groupMinCost;
            String str5 = " scene:";
            if (WifiLog.isDebugMode) {
                WifiLog.d(requestId + " scene:" + adScene + " SPAD SPOneGroupLoadAd requestGroupAds 开始请求并行广告 组curGroupNum " + this.curGroupNum + " 该组需请求的广告数allAdNum " + this.allAdNum + " groupTimeOut " + groupTimeOut + " curGroupMaxCost " + this.curGroupMaxCost + " curGroupMinCost " + this.curGroupMinCost);
            }
            int size = list.size();
            boolean z = false;
            int i4 = 0;
            while (i4 < size) {
                final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                NestAdData nestAdData = list.get(i4);
                objectRef2.element = nestAdData;
                if (nestAdData == 0) {
                    Intrinsics.throwNpe();
                }
                int iAllowRequestAd = allowRequestAd(nestAdData, requestId, adScene);
                if (WifiLog.isDebugMode) {
                    WifiLog.d(requestId + str5 + adScene + " SPAD SPOneGroupLoadAd requestGroupAds 判断是否冷却或者超过最大值Max result " + iAllowRequestAd);
                }
                if (iAllowRequestAd == 0) {
                    final String adType = ((NestAdData) objectRef2.element).getAdType();
                    if (adType != null) {
                        if (WifiLog.isDebugMode) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(requestId);
                            sb.append(str5);
                            sb.append(adScene);
                            str2 = WifiNestConst.EventKey.NEST_SDK_AD_REQ_DI_FAIL;
                            sb.append(" SPAD SPOneGroupLoadAd request provider adType= ");
                            sb.append(adType);
                            sb.append(" code ");
                            sb.append(((NestAdData) objectRef2.element).getAdCode());
                            sb.append(" curGroupNum ");
                            sb.append(this.curGroupNum);
                            WifiLog.d(sb.toString());
                        } else {
                            str2 = WifiNestConst.EventKey.NEST_SDK_AD_REQ_DI_FAIL;
                        }
                        BaseAdProvider baseAdProviderLoadAdProvider = AdProviderLoader.INSTANCE.loadAdProvider(adType);
                        if (baseAdProviderLoadAdProvider != null) {
                            i2 = i4;
                            ((NestAdData) objectRef2.element).setCurGroupNum(this.curGroupNum);
                            ((NestAdData) objectRef2.element).setAdParams(adParams);
                            NestAdData nestAdData2 = (NestAdData) objectRef2.element;
                            if (adParams == null) {
                                Intrinsics.throwNpe();
                            }
                            nestAdData2.setRenderStyle(adCurParams.getRenderStyle());
                            ((NestAdData) objectRef2.element).setNestSid(String.valueOf(System.currentTimeMillis()) + "_" + adType);
                            ((NestAdData) objectRef2.element).setAdxType(adCurParams.getAdxType());
                            ((NestAdData) objectRef2.element).setSplashBottomArea(adCurParams.getSplashBottomArea());
                            ((NestAdData) objectRef2.element).setSplashHuaweiView(adCurParams.getSplashHuaweiView());
                            ((NestAdData) objectRef2.element).setPopRequestTime(adCurParams.getPopRequestTime());
                            SPStrategyManager sPStrategyManager = this.spStrategyManager;
                            if (sPStrategyManager != null) {
                                sPStrategyManager.requestAdCountAdd();
                            }
                            if (activityPacker == null) {
                                Intrinsics.throwNpe();
                            }
                            NestAdData nestAdData3 = (NestAdData) objectRef2.element;
                            if (loadScene == null) {
                                Intrinsics.throwNpe();
                            }
                            baseAdProviderLoadAdProvider.getCorrectAd(activityPacker, nestAdData3, listenerStrategy, loadScene);
                            if (WifiLog.isDebugMode) {
                                WifiLog.d(requestId + str5 + adScene + " SPAD timeout mixAdData adcode " + ((NestAdData) objectRef2.element).getAdCode() + " timeout " + ((NestAdData) objectRef2.element).getTimeOut());
                            }
                            if (((NestAdData) objectRef2.element).getTimeOut() > 0) {
                                baseAdProvider = baseAdProviderLoadAdProvider;
                                str4 = "EventParams.getEventParamsByAdData(mixAdData)";
                                i3 = size;
                                str3 = str2;
                                str = str5;
                                ((NestAdData) objectRef2.element).setTimeOutListener(new SPTimeOutListener() { // from class: com.wifi.ad.core.spstrategy.SPOneGroupLoadAd$requestGroupAds$$inlined$let$lambda$1
                                    /* JADX WARN: Multi-variable type inference failed */
                                    @Override // com.wifi.ad.core.listener.SPTimeOutListener
                                    public void onResult(NestAdData adData) throws JSONException {
                                        WifiLog.d(requestId + " scene:" + adScene + " SPAD timeout 超时了mixAdData adcode " + ((NestAdData) objectRef2.element).getAdCode() + " curGroupNum " + this.curGroupNum + " adData.curGroupNum " + adData.getCurGroupNum());
                                        if (adData.getCurGroupNum() == this.curGroupNum) {
                                            this.addFailAdToList(adData);
                                            this.checkAllAdEnd(requestId, adScene, false, false);
                                        }
                                        AbstractReporter reporter = WifiNestAd.INSTANCE.getReporter();
                                        EventParams eventParamsByAdData = EventParams.getEventParamsByAdData((NestAdData) objectRef2.element);
                                        Intrinsics.checkExpressionValueIsNotNull(eventParamsByAdData, "EventParams.getEventParamsByAdData(mixAdData)");
                                        AdParams adParams2 = ((NestAdData) objectRef2.element).getAdParams();
                                        if (adParams2 == null) {
                                            Intrinsics.throwNpe();
                                        }
                                        reporter.onEvent(WifiNestConst.EventKey.NEST_SDK_AD_OVERTIME_DI, eventParamsByAdData, adParams2.getExt());
                                    }
                                });
                                objectRef = objectRef2;
                                new Handler(Looper.getMainLooper()).postDelayed(((NestAdData) objectRef.element).getTimeoutRunnable(), ((NestAdData) objectRef.element).getTimeOut());
                            } else {
                                str3 = str2;
                                baseAdProvider = baseAdProviderLoadAdProvider;
                                objectRef = objectRef2;
                                str = str5;
                                str4 = "EventParams.getEventParamsByAdData(mixAdData)";
                                i3 = size;
                            }
                        } else {
                            str3 = str2;
                            baseAdProvider = baseAdProviderLoadAdProvider;
                            objectRef = objectRef2;
                            i2 = i4;
                            str4 = "EventParams.getEventParamsByAdData(mixAdData)";
                            i3 = size;
                            str = str5;
                        }
                        if (baseAdProvider == null) {
                            addFailAdToList((NestAdData) objectRef.element);
                            if (WifiLog.isDebugMode) {
                                WifiLog.d(requestId + str + adScene + " SPAD MDA provider == null adcode " + ((NestAdData) objectRef.element).getAdCode());
                            }
                            AbstractReporter reporter = WifiNestAd.INSTANCE.getReporter();
                            EventParams eventParamsByAdData = EventParams.getEventParamsByAdData((NestAdData) objectRef.element);
                            Intrinsics.checkExpressionValueIsNotNull(eventParamsByAdData, str4);
                            AdParams adParams2 = ((NestAdData) objectRef.element).getAdParams();
                            if (adParams2 == null) {
                                Intrinsics.throwNpe();
                            }
                            reporter.onEvent(str3, eventParamsByAdData, adParams2.getExt());
                            checkAllAdEnd(requestId, adScene, false, false);
                        }
                        z = true;
                    } else {
                        i2 = i4;
                        i3 = size;
                        str = str5;
                    }
                    z = true;
                } else {
                    i2 = i4;
                    i3 = size;
                    str = str5;
                    addFailAdToList((NestAdData) objectRef2.element);
                    ((NestAdData) objectRef2.element).setRequestFailReason(iAllowRequestAd);
                    if (WifiLog.isDebugMode) {
                        WifiLog.d(requestId + str + adScene + " SPAD MDA 请求广告失败 nest_sdk_ad_req_di_fail");
                    }
                    AbstractReporter reporter2 = WifiNestAd.INSTANCE.getReporter();
                    EventParams eventParamsByAdData2 = EventParams.getEventParamsByAdData((NestAdData) objectRef2.element);
                    Intrinsics.checkExpressionValueIsNotNull(eventParamsByAdData2, "EventParams.getEventParamsByAdData(mixAdData)");
                    AdParams adParams3 = ((NestAdData) objectRef2.element).getAdParams();
                    if (adParams3 == null) {
                        Intrinsics.throwNpe();
                    }
                    reporter2.onEvent(WifiNestConst.EventKey.NEST_SDK_AD_REQ_DI_FAIL, eventParamsByAdData2, adParams3.getExt());
                    checkAllAdEnd(requestId, adScene, false, false);
                }
                adParams = adCurParams;
                activityPacker = packer;
                loadScene = curScene;
                i4 = i2 + 1;
                str5 = str;
                size = i3;
                list = adDatas;
            }
            String str6 = str5;
            if (WifiLog.isDebugMode) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.groupTimeOutRequestId);
                sb2.append(str6);
                sb2.append(this.groupTimeOutSceneId);
                sb2.append(" SPAD groupTimeoutRunnable groupTimeOut ");
                i = groupTimeOut;
                sb2.append(i);
                sb2.append(" requestAdDone ");
                sb2.append(z);
                WifiLog.d(sb2.toString());
            } else {
                i = groupTimeOut;
            }
            if (!z && WifiNestAd.INSTANCE.getSwitch58414()) {
                findCacheMaxAd(requestId, adScene, false, false);
                checkAllowCall(this.groupTimeOutRequestId, this.groupTimeOutSceneId, false);
            } else if (i > 0) {
                new Timer().schedule(new SPOneGroupLoadAd$requestGroupAds$task$1(this), i);
            }
        }
    }

    public final void setAllCallEd(AtomicBoolean atomicBoolean) {
        this.allCallEd = atomicBoolean;
    }
}
