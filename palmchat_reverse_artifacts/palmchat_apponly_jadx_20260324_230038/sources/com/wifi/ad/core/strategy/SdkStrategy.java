package com.wifi.ad.core.strategy;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.huawei.openalliance.ad.constant.bq;
import com.huawei.openalliance.ad.constant.h;
import com.wifi.ad.core.SDKAlias;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.config.AdParams;
import com.wifi.ad.core.config.AdProviderLoader;
import com.wifi.ad.core.config.EventParams;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import com.wifi.ad.core.config.adx.model.WkAdConfigModel;
import com.wifi.ad.core.config.adx.model.WkAdMutliPrice;
import com.wifi.ad.core.config.adx.model.WkAdStrategyModel;
import com.wifi.ad.core.data.BlackListFilterData;
import com.wifi.ad.core.data.FilterConfigBean;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.data.NestMixAdLevel;
import com.wifi.ad.core.data.WhiteFilterConfigBean;
import com.wifi.ad.core.helper.ActivityPacker;
import com.wifi.ad.core.listener.BaseListener;
import com.wifi.ad.core.listener.FeedBannerLoadListener;
import com.wifi.ad.core.listener.H5CallListener;
import com.wifi.ad.core.monitor.WkAdConfigManager;
import com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigManager;
import com.wifi.ad.core.p001const.WifiNestConst;
import com.wifi.ad.core.provider.BaseAdProvider;
import com.wifi.ad.core.reporter.AbstractReporter;
import com.wifi.ad.core.reporter.EventReporter;
import com.wifi.ad.core.utils.WifiLog;
import com.wifi.adsdk.utils.LxAdConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0007\u0018\u0000 I2\u00020\u0001:\u0001IB\u0005¢\u0006\u0002\u0010\u0002J.\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0014\u0010&\u001a\u0010\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020(\u0018\u00010'2\u0006\u0010)\u001a\u00020(H\u0002J\u0018\u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0002J\b\u0010/\u001a\u00020#H\u0002J\u0018\u00100\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u000f2\u0006\u00102\u001a\u00020(H\u0002J.\u00103\u001a\u0004\u0018\u00010\u000f2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u000f0\b2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u000f0\b2\u0006\u0010$\u001a\u00020%H\u0002J.\u00106\u001a\u0004\u0018\u00010\u000f2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u000f0\b2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u000f0\b2\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u00107\u001a\u00020%2\u0006\u00108\u001a\u00020(H\u0002J \u00109\u001a\u00020#2\u0006\u0010:\u001a\u00020;2\u0006\u0010-\u001a\u00020.2\u0006\u0010<\u001a\u00020=H\u0016J \u0010>\u001a\u00020#2\u0006\u00101\u001a\u00020\u000f2\u0006\u0010?\u001a\u00020(2\u0006\u0010@\u001a\u00020\u0006H\u0016J\u0016\u0010A\u001a\u00020#2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u000f0CH\u0016J\b\u0010D\u001a\u00020#H\u0002J\u000e\u0010E\u001a\u00020#2\u0006\u0010F\u001a\u00020\u0004J\u0010\u0010G\u001a\u00020#2\u0006\u0010H\u001a\u00020\u000fH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000f0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000f0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/wifi/ad/core/strategy/SdkStrategy;", "Lcom/wifi/ad/core/strategy/AbsStrategy;", "()V", "bannerlistener", "Lcom/wifi/ad/core/listener/FeedBannerLoadListener;", "bidType", "", "calculateStrategy", "", "Lcom/wifi/ad/core/data/NestMixAdLevel;", WiseOpenHianalyticsData.UNION_COSTTIME, "", "ecpmDone", "Ljava/util/concurrent/atomic/AtomicBoolean;", "failMixList", "Lcom/wifi/ad/core/data/NestAdData;", "filterConfig", "Lcom/wifi/ad/core/data/FilterConfigBean;", "filterOn", "filtered", "gdtAded", "hasGdtAd", "hasWifiAd", "isShow", "mContext", "Landroid/content/Context;", "mixAdsData", "strategySDKManager", "Lcom/wifi/ad/core/strategy/StrategySDKManager;", "successMixList", "whiteFilterConfig", "Lcom/wifi/ad/core/data/WhiteFilterConfigBean;", "whiteFilterOn", "wifiAded", "checkResultSet", "", "isTimeout", "", "ext", "", "", "requestId", "createJsonBySdkData", "sdkConfig", "Lcom/wifi/ad/core/config/adx/model/WkAdConfigModel;", "adParams", "Lcom/wifi/ad/core/config/AdParams;", "ecpmAllAd", "getAdRealEcpm", "nestAdData", "dspName", "getShowData", "successList", "failList", "getShowDataWithFilter", "isContainsLetter", "input", h.Code, "packer", "Lcom/wifi/ad/core/helper/ActivityPacker;", "scene", "Lcom/wifi/ad/core/strategy/LoadScene;", "onAdFailed", "failedMsg", "code", "onAdLoaded", "adList", "", "reset", "setFeedBannerLoadListener", bq.f.s, "setFilterOn", "successData", "Companion", "core_release"}, k = 1, mv = {1, 1, 16})
public final class SdkStrategy extends AbsStrategy {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static HashMap<String, View> allAdAdView = new HashMap<>();
    private static HashMap<String, List<NestAdData>> allAdData = new HashMap<>();
    private static HashMap<String, H5CallListener> allAdLoadListener = new HashMap<>();
    private static HashMap<String, H5CallListener> allAdShowListener = new HashMap<>();
    private FeedBannerLoadListener bannerlistener;
    private int bidType;
    private long costTime;
    private FilterConfigBean filterConfig;
    private Context mContext;
    private StrategySDKManager strategySDKManager;
    private WhiteFilterConfigBean whiteFilterConfig;
    private List<NestAdData> mixAdsData = new ArrayList();
    private List<NestMixAdLevel> calculateStrategy = new ArrayList();
    private List<NestAdData> successMixList = new ArrayList();
    private List<NestAdData> failMixList = new ArrayList();
    private AtomicBoolean isShow = new AtomicBoolean(false);
    private AtomicBoolean filterOn = new AtomicBoolean(false);
    private AtomicBoolean filtered = new AtomicBoolean(false);
    private AtomicBoolean gdtAded = new AtomicBoolean(false);
    private AtomicBoolean wifiAded = new AtomicBoolean(false);
    private AtomicBoolean hasGdtAd = new AtomicBoolean(false);
    private AtomicBoolean hasWifiAd = new AtomicBoolean(false);
    private AtomicBoolean ecpmDone = new AtomicBoolean(false);
    private AtomicBoolean whiteFilterOn = new AtomicBoolean(false);

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0018\u001a\u00020\rR&\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR,\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\b\"\u0004\b\u000f\u0010\nR&\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00110\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR&\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00110\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/wifi/ad/core/strategy/SdkStrategy$Companion;", "", "()V", "allAdAdView", "Ljava/util/HashMap;", "", "Landroid/view/View;", "getAllAdAdView", "()Ljava/util/HashMap;", "setAllAdAdView", "(Ljava/util/HashMap;)V", "allAdData", "", "Lcom/wifi/ad/core/data/NestAdData;", "getAllAdData", "setAllAdData", "allAdLoadListener", "Lcom/wifi/ad/core/listener/H5CallListener;", "getAllAdLoadListener", "setAllAdLoadListener", "allAdShowListener", "getAllAdShowListener", "setAllAdShowListener", "createStringByAdData", "adData", "core_release"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public final String createStringByAdData(NestAdData adData) {
            return adData.toJsonString();
        }

        public final HashMap<String, View> getAllAdAdView() {
            return SdkStrategy.allAdAdView;
        }

        public final HashMap<String, List<NestAdData>> getAllAdData() {
            return SdkStrategy.allAdData;
        }

        public final HashMap<String, H5CallListener> getAllAdLoadListener() {
            return SdkStrategy.allAdLoadListener;
        }

        public final HashMap<String, H5CallListener> getAllAdShowListener() {
            return SdkStrategy.allAdShowListener;
        }

        public final void setAllAdAdView(HashMap<String, View> map) {
            SdkStrategy.allAdAdView = map;
        }

        public final void setAllAdData(HashMap<String, List<NestAdData>> map) {
            SdkStrategy.allAdData = map;
        }

        public final void setAllAdLoadListener(HashMap<String, H5CallListener> map) {
            SdkStrategy.allAdLoadListener = map;
        }

        public final void setAllAdShowListener(HashMap<String, H5CallListener> map) {
            SdkStrategy.allAdShowListener = map;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkResultSet(boolean isTimeout, Map<String, String> ext, String requestId) {
        String nestType;
        String nestType2;
        NestAdData showDataWithFilter = getShowDataWithFilter(this.successMixList, this.failMixList, isTimeout);
        if (showDataWithFilter == null) {
            if (this.failMixList.containsAll(this.mixAdsData) || this.failMixList.size() + this.successMixList.size() == this.mixAdsData.size()) {
                this.isShow.compareAndSet(false, true);
                FeedBannerLoadListener feedBannerLoadListener = this.bannerlistener;
                if (feedBannerLoadListener != null) {
                    feedBannerLoadListener.onAdFailed("30602", "并行请求失败", requestId);
                    return;
                }
                return;
            }
            if (this.successMixList.size() == 0 && isTimeout) {
                this.isShow.compareAndSet(false, true);
                FeedBannerLoadListener feedBannerLoadListener2 = this.bannerlistener;
                if (feedBannerLoadListener2 != null) {
                    feedBannerLoadListener2.onAdFailed("30601", "并行请求超时", requestId);
                    return;
                }
                return;
            }
            return;
        }
        this.isShow.compareAndSet(false, true);
        showDataWithFilter.setWinner(true);
        StringBuilder sb = new StringBuilder();
        sb.append("H5BannerAd checkResultSet parallel win ");
        StrategySDKManager strategySDKManager = this.strategySDKManager;
        if (strategySDKManager == null) {
            Intrinsics.throwNpe();
        }
        sb.append(strategySDKManager.getNestAdInfo(showDataWithFilter));
        WifiLog.d(sb.toString());
        HashMap<String, List<NestAdData>> map = allAdData;
        String requestId2 = showDataWithFilter.getRequestId();
        if (requestId2 == null) {
            Intrinsics.throwNpe();
        }
        map.put(requestId2, CollectionsKt__CollectionsKt.mutableListOf(showDataWithFilter));
        FeedBannerLoadListener feedBannerLoadListener3 = this.bannerlistener;
        if (feedBannerLoadListener3 != null) {
            String adType = showDataWithFilter.getAdType();
            if (adType == null) {
                Intrinsics.throwNpe();
            }
            String requestId3 = showDataWithFilter.getRequestId();
            if (requestId3 == null) {
                Intrinsics.throwNpe();
            }
            feedBannerLoadListener3.onAdLoad(adType, requestId3);
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
        EventParams.Builder realLevel = adMode2.setNestType(nestType).setEcpmRatio(showDataWithFilter.getEcpmRatio()).setEcpmLowPrice(showDataWithFilter.getEcpmLowPrice()).setPriceSwitch(showDataWithFilter.getPriceSwitch()).setPriceResponse(showDataWithFilter.getPriceResponse()).setAdCost(showDataWithFilter.getAdCost()).setRealLevel(showDataWithFilter.getAdRealLevelName());
        Integer adLevel = showDataWithFilter.getAdLevel();
        if (adLevel == null) {
            Intrinsics.throwNpe();
        }
        EventParams eventParams = realLevel.setAdLevel(adLevel.intValue()).build();
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
            EventParams.Builder nestType3 = adMode4.setNestType(str);
            Integer adLevel2 = showDataWithFilter.getAdLevel();
            if (adLevel2 == null) {
                Intrinsics.throwNpe();
            }
            EventParams eventParams2 = nestType3.setAdLevel(adLevel2.intValue()).setCostTime(this.costTime).setRealLevel(showDataWithFilter.getAdRealLevelName()).build();
            AbstractReporter reporter2 = wifiNestAd.getReporter();
            Intrinsics.checkExpressionValueIsNotNull(eventParams2, "eventParams");
            reporter2.onEvent(WifiNestConst.EventKey.NEST_SDK_AD_BLACKLIST_WINNER, eventParams2, ext);
        }
    }

    private final String createJsonBySdkData(WkAdConfigModel sdkConfig, AdParams adParams) {
        if (sdkConfig == null) {
            return "";
        }
        try {
            this.bidType = sdkConfig.getBidType();
            if (sdkConfig.getTimeOut() > 0) {
                adParams.setTotalTimeout$core_release(sdkConfig.getTimeOut());
            }
            List<WkAdStrategyModel> allModels = sdkConfig.getAllModels();
            if (allModels == null) {
                return "";
            }
            JSONArray jSONArray = new JSONArray();
            int size = allModels.size();
            for (int i = 0; i < size; i++) {
                WkAdStrategyModel wkAdStrategyModel = allModels.get(i);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("level", wkAdStrategyModel.getPriority());
                JSONArray jSONArray2 = new JSONArray();
                jSONArray2.put(wkAdStrategyModel.getRatio());
                jSONObject.put("ratios", jSONArray2);
                jSONObject.put("ecpm", wkAdStrategyModel.getEcpm());
                JSONArray jSONArray3 = new JSONArray();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("dspid", wkAdStrategyModel.getDspId());
                jSONObject2.put("di", wkAdStrategyModel.getSlotId());
                jSONObject2.put("block", wkAdStrategyModel.getIsAllBlock());
                jSONObject2.put("src", Intrinsics.stringPlus(wkAdStrategyModel.getDspName(), Integer.valueOf(wkAdStrategyModel.getPriority())));
                jSONObject2.put(WkAdConfigModel.TAG_ECPMMAP, wkAdStrategyModel.getEcpmLevelArray());
                jSONArray3.put(jSONObject2);
                jSONObject.put("adStrategy", jSONArray3);
                jSONArray.put(jSONObject);
            }
            String string = jSONArray.toString();
            Intrinsics.checkExpressionValueIsNotNull(string, "resultStrategy.toString()");
            return string;
        } catch (Exception e) {
            AbstractReporter reporter = WifiNestAd.INSTANCE.getReporter();
            EventParams eventParamsBuild = new EventParams.Builder().setTemplate("SdkP").setErrorCode(e.toString()).build();
            Intrinsics.checkExpressionValueIsNotNull(eventParamsBuild, "EventParams.Builder()\n  …                 .build()");
            reporter.onEvent(WifiNestConst.EventKey.NEST_AD_PARSE_STRATEGY_FAIL_ERROR, eventParamsBuild, adParams.getExt());
            Unit unit = Unit.INSTANCE;
            return "";
        }
    }

    private final void ecpmAllAd() {
        StrategySDKManager strategySDKManager = this.strategySDKManager;
        if (strategySDKManager == null) {
            Intrinsics.throwNpe();
        }
        this.calculateStrategy = strategySDKManager.ecpmAllAd();
    }

    private final NestAdData getAdRealEcpm(NestAdData nestAdData, String dspName) {
        WifiLog.d("H5BannerAd getAdRealEcpm adRealLevelName " + nestAdData.getAdRealLevelName() + " + dsp " + dspName);
        String adRealLevelName = nestAdData.getAdRealLevelName();
        if (!(adRealLevelName == null || adRealLevelName.length() == 0)) {
            try {
                String adRealLevelName2 = nestAdData.getAdRealLevelName();
                if (adRealLevelName2 == null) {
                    Intrinsics.throwNpe();
                }
                if (isContainsLetter(adRealLevelName2)) {
                    List<WkAdMutliPrice> ecpmLevelMap = nestAdData.getEcpmLevelMap();
                    if (ecpmLevelMap != null) {
                        int size = ecpmLevelMap.size();
                        int i = 0;
                        while (true) {
                            if (i >= size) {
                                break;
                            }
                            WkAdMutliPrice wkAdMutliPrice = ecpmLevelMap.get(i);
                            if (StringsKt__StringsJVMKt.equals$default(nestAdData.getAdRealLevelName(), wkAdMutliPrice.getCpmlevel(), false, 2, null)) {
                                nestAdData.setAdCost(wkAdMutliPrice.getEcpm());
                                nestAdData.setRatio(wkAdMutliPrice.getRatio());
                                break;
                            }
                            i++;
                        }
                    }
                } else {
                    String adRealLevelName3 = nestAdData.getAdRealLevelName();
                    if (adRealLevelName3 == null) {
                        Intrinsics.throwNpe();
                    }
                    nestAdData.setAdCost(Integer.parseInt(adRealLevelName3));
                }
            } catch (Exception unused) {
            }
        }
        WifiLog.d("H5BannerAd getAdRealEcpm nestAdData.adCost " + nestAdData.getAdCost());
        return nestAdData;
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
                        WifiLog.d("H5Banner getShowDataWithFilter adData.adLevelName " + nestAdData.getAdLevelName() + " successData.adRealLevelName " + next.getAdRealLevelName() + " block " + next.getBlockAd());
                        if (StringsKt__StringsJVMKt.equals$default(nestAdData.getAdLevelName(), next.getAdRealLevelName(), false, 2, null) && StringsKt__StringsJVMKt.equals$default(next.getAdCode(), nestAdData.getAdCode(), false, 2, null)) {
                            setFilterOn(next);
                            StrategyManager strategyManager = StrategyManager.INSTANCE;
                            BlackListFilterData blackListFilterDataShouldFilter = strategyManager.shouldFilter(this.filterOn, this.filterConfig, next);
                            WifiLog.d("H5Banner getShowDataWithFilter blackListFilterData " + blackListFilterDataShouldFilter);
                            this.costTime = this.costTime + blackListFilterDataShouldFilter.getCostTime();
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
                        WifiLog.d("H5Banner getShowDataWithFilter null");
                        return null;
                    }
                    WifiLog.d("H5Banner getShowDataWithFilter continue");
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

    private final void setFilterOn(NestAdData successData) {
        if (this.filterOn.get()) {
            if (successData.getBlockAd() == 1) {
                this.filterOn.set(true);
            } else {
                this.filterOn.set(false);
            }
        }
    }

    @Override // com.wifi.ad.core.strategy.AbsStrategy
    public void loadAd(ActivityPacker packer, final AdParams adParams, LoadScene scene) throws JSONException {
        String strValueOf;
        WifiLog.d("H5BannerAd SdkStrategy loadAd ");
        this.mContext = packer.getAppContext();
        Map<String, String> ext = adParams.getExt();
        if (ext != null) {
            strValueOf = String.valueOf(ext.get("requestId"));
            String appId = adParams.getAppId();
            if (!(appId == null || appId.length() == 0)) {
                String appId2 = adParams.getAppId();
                if (appId2 == null) {
                    Intrinsics.throwNpe();
                }
                ext.put("appId", appId2);
            }
            ext.put("scene", String.valueOf(adParams.getScene()));
            String adUnitId = adParams.getAdUnitId();
            if (!(adUnitId == null || adUnitId.length() == 0)) {
                String adUnitId2 = adParams.getAdUnitId();
                if (adUnitId2 == null) {
                    Intrinsics.throwNpe();
                }
                ext.put(LxAdConst.EventKeyParams.KEY_PARAM_ADUNITID, adUnitId2);
            }
            Unit unit = Unit.INSTANCE;
        } else {
            strValueOf = "";
        }
        final String str = strValueOf;
        String appId3 = adParams.getAppId();
        if ((appId3 == null || appId3.length() == 0) || adParams.getScene() == 0) {
            AbstractReporter reporter = WifiNestAd.INSTANCE.getReporter();
            EventParams eventParamsBuild = new EventParams.Builder().setErrorCode("50005").setNestType(adParams.getNestType()).build();
            Intrinsics.checkExpressionValueIsNotNull(eventParamsBuild, "EventParams.Builder()\n  …                 .build()");
            reporter.onEvent(WifiNestConst.EventKey.NEST_AD_PARSE_STRATEGY_FAIL, eventParamsBuild, adParams.getExt());
            FeedBannerLoadListener feedBannerLoadListener = this.bannerlistener;
            if (feedBannerLoadListener != null) {
                feedBannerLoadListener.onAdFailed("50005", "AdParams中appId为空或scene为不存在", str);
                Unit unit2 = Unit.INSTANCE;
                return;
            }
            return;
        }
        this.strategySDKManager = new StrategySDKManager();
        WifiNestAd wifiNestAd = WifiNestAd.INSTANCE;
        AbstractReporter reporter2 = wifiNestAd.getReporter();
        EventParams eventParamsBuild2 = new EventParams.Builder().setNestType(adParams.getNestType()).build();
        Intrinsics.checkExpressionValueIsNotNull(eventParamsBuild2, "EventParams.Builder()\n  …dParams.nestType).build()");
        reporter2.onEvent(WifiNestConst.EventKey.NEST_AD_PARSE_STRATEGY, eventParamsBuild2, adParams.getExt());
        WkAdConfigModel adSdkConfig = new WkAdxAdConfigMg(this.mContext).getAdSdkConfig(adParams.getScene(), adParams.getAppId(), str, adParams.getAdUnitId(), wifiNestAd.getAdConfigTais(), adParams);
        WifiLog.d("H5BannerAd SdkStrategy sdkConfig " + adSdkConfig);
        if (adSdkConfig == null) {
            AbstractReporter reporter3 = wifiNestAd.getReporter();
            EventParams eventParamsBuild3 = new EventParams.Builder().setErrorCode("50004").setNestType(adParams.getNestType()).build();
            Intrinsics.checkExpressionValueIsNotNull(eventParamsBuild3, "EventParams.Builder()\n  …                 .build()");
            reporter3.onEvent(WifiNestConst.EventKey.NEST_AD_PARSE_STRATEGY_FAIL, eventParamsBuild3, adParams.getExt());
            FeedBannerLoadListener feedBannerLoadListener2 = this.bannerlistener;
            if (feedBannerLoadListener2 != null) {
                feedBannerLoadListener2.onAdFailed("50004", "sdk策略数据为空", str);
                Unit unit3 = Unit.INSTANCE;
                return;
            }
            return;
        }
        WkWXExtEvent wkWXExtEvent = WkWXExtEvent.INSTANCE;
        String sourceId = adSdkConfig.getSourceId();
        if (sourceId == null) {
            Intrinsics.throwNpe();
        }
        int bidType = adSdkConfig.getBidType();
        Context context = this.mContext;
        if (context == null) {
            Intrinsics.throwNpe();
        }
        String strCreateWxEventMap = wkWXExtEvent.createWxEventMap(sourceId, bidType, adParams, str, context);
        if (ext != null) {
            ext.put(EventParams.KEY_WXEVENTEXT, strCreateWxEventMap);
            Unit unit4 = Unit.INSTANCE;
        }
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
        adParams.setTotalTimeout$core_release(3500L);
        adParams.setStrategyJson$core_release(createJsonBySdkData(adSdkConfig, adParams));
        this.hasGdtAd.set(adSdkConfig.getIsHasGdtAd());
        this.hasWifiAd.set(adSdkConfig.getIsHasWifiAd());
        AbstractReporter reporter4 = wifiNestAd.getReporter();
        EventParams eventParamsBuild4 = new EventParams.Builder().setNestType(adParams.getNestType()).build();
        Intrinsics.checkExpressionValueIsNotNull(eventParamsBuild4, "EventParams.Builder()\n  …dParams.nestType).build()");
        reporter4.onEvent(WifiNestConst.EventKey.NEST_AD_PARSE_STRATEGY_SUCCESS, eventParamsBuild4, adParams.getExt());
        if (TextUtils.isEmpty(adParams.getStrategyJson())) {
            AbstractReporter reporter5 = wifiNestAd.getReporter();
            EventParams eventParamsBuild5 = new EventParams.Builder().setErrorCode("50009").setNestType(adParams.getNestType()).build();
            Intrinsics.checkExpressionValueIsNotNull(eventParamsBuild5, "EventParams.Builder()\n  …                 .build()");
            reporter5.onEvent(WifiNestConst.EventKey.NEST_AD_PARSE_STRATEGY_FAIL, eventParamsBuild5, adParams.getExt());
            BaseListener listener = getListener();
            if (listener != null) {
                listener.onAdFailed("50009", "sdk并行策略数据为null");
                Unit unit5 = Unit.INSTANCE;
                return;
            }
            return;
        }
        StrategySDKManager strategySDKManager = this.strategySDKManager;
        if (strategySDKManager == null) {
            Intrinsics.throwNpe();
        }
        String strategyJson = adParams.getStrategyJson();
        if (strategyJson == null) {
            Intrinsics.throwNpe();
        }
        List<NestAdData> mixAds = strategySDKManager.getMixAds(strategyJson, adParams.getExt(), str);
        this.mixAdsData = mixAds;
        List<NestAdData> list = mixAds;
        if (list == null || list.isEmpty()) {
            AbstractReporter reporter6 = wifiNestAd.getReporter();
            EventParams eventParamsBuild6 = new EventParams.Builder().setErrorCode("50002").setNestType(adParams.getNestType()).build();
            Intrinsics.checkExpressionValueIsNotNull(eventParamsBuild6, "EventParams.Builder()\n  …                 .build()");
            reporter6.onEvent(WifiNestConst.EventKey.NEST_AD_PARSE_STRATEGY_FAIL, eventParamsBuild6, adParams.getExt());
            FeedBannerLoadListener feedBannerLoadListener3 = this.bannerlistener;
            if (feedBannerLoadListener3 != null) {
                feedBannerLoadListener3.onAdFailed("50002", "sdk策略数据解析异常", str);
                Unit unit6 = Unit.INSTANCE;
                return;
            }
            return;
        }
        StrategySDKManager strategySDKManager2 = this.strategySDKManager;
        if (strategySDKManager2 == null) {
            Intrinsics.throwNpe();
        }
        this.calculateStrategy = strategySDKManager2.calculateStrategy();
        WifiLog.d("H5BannerAd parallel calculate adStrs " + this.calculateStrategy);
        List<NestMixAdLevel> list2 = this.calculateStrategy;
        if (list2 == null || list2.isEmpty()) {
            AbstractReporter reporter7 = wifiNestAd.getReporter();
            EventParams eventParamsBuild7 = new EventParams.Builder().setErrorCode("50003").setNestType(adParams.getNestType()).build();
            Intrinsics.checkExpressionValueIsNotNull(eventParamsBuild7, "EventParams.Builder()\n  …                 .build()");
            reporter7.onEvent(WifiNestConst.EventKey.NEST_AD_PARSE_STRATEGY_FAIL, eventParamsBuild7, adParams.getExt());
            FeedBannerLoadListener feedBannerLoadListener4 = this.bannerlistener;
            if (feedBannerLoadListener4 != null) {
                feedBannerLoadListener4.onAdFailed("50003", "sdk策略权重计算异常", str);
                Unit unit7 = Unit.INSTANCE;
                return;
            }
            return;
        }
        reset();
        WifiLog.d("H5BannerAd scrn_ parallel onStart() 需要请求" + this.mixAdsData.size() + "个广告, taiChiKey:" + taichikeys + ", filterOn:" + this.filterOn + ", whiteFilterOn:" + this.whiteFilterOn);
        FeedBannerLoadListener feedBannerLoadListener5 = this.bannerlistener;
        if (feedBannerLoadListener5 != null) {
            feedBannerLoadListener5.onStart(str);
            Unit unit8 = Unit.INSTANCE;
        }
        for (NestAdData nestAdData : this.mixAdsData) {
            String adType = nestAdData.getAdType();
            if (adType != null) {
                WifiLog.d("H5BannerAd parallel request provider adType= " + adType + ' ');
                BaseAdProvider baseAdProviderLoadAdProvider = AdProviderLoader.INSTANCE.loadAdProvider(adType);
                if (baseAdProviderLoadAdProvider != null) {
                    nestAdData.setAdParams(adParams);
                    nestAdData.setRenderStyle(adParams.getRenderStyle());
                    nestAdData.setNestSid(String.valueOf(System.currentTimeMillis()) + "_" + adType);
                    nestAdData.setAdxType(adParams.getAdxType());
                    baseAdProviderLoadAdProvider.getCorrectAd(packer, nestAdData, this, scene);
                    Unit unit9 = Unit.INSTANCE;
                }
            }
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.wifi.ad.core.strategy.SdkStrategy.loadAd.4
            @Override // java.lang.Runnable
            public final void run() {
                if (!SdkStrategy.this.isShow.get()) {
                    SdkStrategy sdkStrategy = SdkStrategy.this;
                    AdParams adParams2 = adParams;
                    sdkStrategy.checkResultSet(true, adParams2 != null ? adParams2.getExt() : null, str);
                }
                if (SdkStrategy.this.successMixList.size() > 0) {
                    EventReporter.INSTANCE.reportResp(adParams, SdkStrategy.this.successMixList.size());
                }
            }
        }, adParams.getTotalTimeout());
    }

    @Override // com.wifi.ad.core.strategy.AbsStrategy, com.wifi.ad.core.strategy.IStrategyListener
    public void onAdFailed(NestAdData nestAdData, String failedMsg, int code) {
        Map<String, String> ext;
        super.onAdFailed(nestAdData, failedMsg, code);
        WifiLog.d("H5BannerAd onAdFailed " + nestAdData + " +  bidType " + this.bidType + "  failedMsg " + failedMsg);
        int i = this.bidType;
        if (i != 3) {
            if (i != 4) {
                this.failMixList.add(nestAdData);
                if (this.isShow.get()) {
                    return;
                }
                AdParams adParams = nestAdData.getAdParams();
                ext = adParams != null ? adParams.getExt() : null;
                String requestId = nestAdData.getRequestId();
                if (requestId == null) {
                    Intrinsics.throwNpe();
                }
                checkResultSet(false, ext, requestId);
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(nestAdData.getAdType(), SDKAlias.GDT.getType())) {
            this.gdtAded.set(true);
            WifiLog.d("H5BannerAd onAdLoaded gdt failed ");
        } else if (Intrinsics.areEqual(nestAdData.getAdType(), SDKAlias.WIFI.getType())) {
            this.wifiAded.set(true);
            WifiLog.d("H5BannerAd onAdLoaded wifi failed ");
        }
        this.failMixList.add(nestAdData);
        WifiLog.d("H5BannerAd onAdFailed gdtAded" + this.gdtAded.get() + " +  wifiAded " + this.wifiAded.get());
        if (this.gdtAded.get() || !this.hasGdtAd.get()) {
            if (this.wifiAded.get() || !this.hasWifiAd.get()) {
                if (!this.ecpmDone.get()) {
                    this.ecpmDone.set(true);
                    ecpmAllAd();
                }
                if (this.isShow.get()) {
                    return;
                }
                AdParams adParams2 = nestAdData.getAdParams();
                ext = adParams2 != null ? adParams2.getExt() : null;
                String requestId2 = nestAdData.getRequestId();
                if (requestId2 == null) {
                    Intrinsics.throwNpe();
                }
                checkResultSet(false, ext, requestId2);
            }
        }
    }

    @Override // com.wifi.ad.core.strategy.AbsStrategy, com.wifi.ad.core.strategy.IStrategyListener
    public void onAdLoaded(List<NestAdData> adList) {
        AdParams adParams;
        super.onAdLoaded(adList);
        NestAdData adRealEcpm = adList.get(0);
        WifiLog.d("H5BannerAd onAdLoaded " + adRealEcpm + " +  bidType " + this.bidType);
        int i = this.bidType;
        if (i != 3) {
            if (i != 4) {
                if (Intrinsics.areEqual(adRealEcpm.getAdType(), SDKAlias.GDT.getType()) || Intrinsics.areEqual(adRealEcpm.getAdType(), SDKAlias.WIFI.getType())) {
                    adRealEcpm.setAdRealLevelName(adRealEcpm.getAdLevelName());
                }
                this.successMixList.add(adRealEcpm);
                if (this.isShow.get() || adList.isEmpty()) {
                    return;
                }
                AdParams adParams2 = adRealEcpm.getAdParams();
                ext = adParams2 != null ? adParams2.getExt() : null;
                String requestId = adRealEcpm.getRequestId();
                if (requestId == null) {
                    Intrinsics.throwNpe();
                }
                checkResultSet(false, ext, requestId);
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(adRealEcpm.getAdType(), SDKAlias.GDT.getType())) {
            WifiLog.d("H5BannerAd onAdLoaded gdt success ");
            this.gdtAded.set(true);
            adRealEcpm = getAdRealEcpm(adRealEcpm, WkAdxAdConfigMg.DSP_NAME_GDT);
        } else if (Intrinsics.areEqual(adRealEcpm.getAdType(), SDKAlias.WIFI.getType())) {
            WifiLog.d("H5BannerAd onAdLoaded wifi success ");
            this.wifiAded.set(true);
            adRealEcpm = getAdRealEcpm(adRealEcpm, "W");
        }
        this.successMixList.add(adRealEcpm);
        WifiLog.d("H5BannerAd onAdLoaded gdtAded" + this.gdtAded.get() + " +  wifiAded " + this.wifiAded.get());
        if (this.gdtAded.get() || !this.hasGdtAd.get()) {
            if (this.wifiAded.get() || !this.hasWifiAd.get()) {
                if (!this.ecpmDone.get()) {
                    this.ecpmDone.set(true);
                    ecpmAllAd();
                }
                if (this.isShow.get() || adList.isEmpty()) {
                    return;
                }
                if (adRealEcpm != null && (adParams = adRealEcpm.getAdParams()) != null) {
                    ext = adParams.getExt();
                }
                String requestId2 = adRealEcpm.getRequestId();
                if (requestId2 == null) {
                    Intrinsics.throwNpe();
                }
                checkResultSet(false, ext, requestId2);
            }
        }
    }

    public final void setFeedBannerLoadListener(FeedBannerLoadListener listener) {
        this.bannerlistener = listener;
    }
}
