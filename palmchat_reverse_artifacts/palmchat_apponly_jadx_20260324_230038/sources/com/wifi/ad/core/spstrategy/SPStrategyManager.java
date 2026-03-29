package com.wifi.ad.core.spstrategy;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.huawei.openalliance.ad.constant.h;
import com.wifi.ad.core.SDKAlias;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.callback.AdRequestCallBack;
import com.wifi.ad.core.config.AdParams;
import com.wifi.ad.core.config.EventParams;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import com.wifi.ad.core.data.BlackListFilterData;
import com.wifi.ad.core.data.FilterConfigBean;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.data.WhiteFilterConfigBean;
import com.wifi.ad.core.helper.ActivityPacker;
import com.wifi.ad.core.interactive.WkInteractiveManager;
import com.wifi.ad.core.listener.BaseListener;
import com.wifi.ad.core.monitor.WkAdConfigManager;
import com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigManager;
import com.wifi.ad.core.p001const.WifiNestConst;
import com.wifi.ad.core.reporter.AbstractReporter;
import com.wifi.ad.core.reporter.EventReporter;
import com.wifi.ad.core.strategy.AbsStrategy;
import com.wifi.ad.core.strategy.LoadScene;
import com.wifi.ad.core.strategy.StrategyManager;
import com.wifi.ad.core.strategy.WkWXExtEvent;
import com.wifi.ad.core.utils.SpMaterialFilterUtil;
import com.wifi.ad.core.utils.WifiLog;
import com.wifi.adsdk.utils.LxAdConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u001c\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 s2\u00020\u0001:\u0001sB\u0005¢\u0006\u0002\u0010\u0002J\u001a\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u00122\b\u00106\u001a\u0004\u0018\u00010\fH\u0002J\u001a\u00107\u001a\u0002042\u0006\u00105\u001a\u00020\u00122\b\u00106\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u00108\u001a\u0002042\u0006\u00109\u001a\u00020\u0012H\u0002J(\u0010:\u001a\u0002042\u0006\u0010;\u001a\u00020<2\u0006\u00106\u001a\u00020\f2\u0006\u0010=\u001a\u00020\b2\u0006\u0010>\u001a\u00020\u0004H\u0002J\u0018\u0010?\u001a\u0002042\u0006\u0010@\u001a\u00020\f2\u0006\u0010A\u001a\u00020\fH\u0002J6\u0010B\u001a\u0002042\u0014\u0010C\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010D2\u0006\u00106\u001a\u00020\f2\u0006\u0010E\u001a\u00020\f2\u0006\u0010=\u001a\u00020\bH\u0002J6\u0010F\u001a\u0002042\u0014\u0010C\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010D2\u0006\u0010G\u001a\u00020\f2\u0006\u0010E\u001a\u00020\f2\u0006\u0010=\u001a\u00020\bH\u0002J \u0010H\u001a\u0004\u0018\u00010\u00122\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00120\u000f2\u0006\u0010J\u001a\u00020\u0012H\u0002J0\u0010K\u001a\u0002042\b\u00106\u001a\u0004\u0018\u00010\f2\u0006\u0010E\u001a\u00020\f2\u0006\u0010=\u001a\u00020\b2\u0006\u0010L\u001a\u00020$2\u0006\u0010M\u001a\u00020$J\u0006\u0010N\u001a\u00020\bJ\u0006\u0010O\u001a\u00020\fJ\u0010\u0010P\u001a\u00020$2\u0006\u0010J\u001a\u00020\u0012H\u0002J\u0006\u0010Q\u001a\u00020$J\u0006\u0010R\u001a\u00020$J\u0006\u0010S\u001a\u00020$J \u0010T\u001a\u0002042\u0006\u0010U\u001a\u00020'2\u0006\u0010>\u001a\u00020\u00042\u0006\u0010V\u001a\u00020\u001eH\u0016J*\u0010W\u001a\u0002042\b\u00106\u001a\u0004\u0018\u00010\f2\u0006\u0010=\u001a\u00020\b2\u0006\u0010@\u001a\u00020\f2\u0006\u0010A\u001a\u00020\fH\u0002J*\u0010X\u001a\u0002042\b\u00106\u001a\u0004\u0018\u00010\f2\u0006\u0010=\u001a\u00020\b2\u0006\u00109\u001a\u00020\u00122\u0006\u0010Y\u001a\u00020$H\u0002J\u0018\u0010Z\u001a\u0002042\u0006\u00105\u001a\u00020\u00122\u0006\u0010[\u001a\u00020\fH\u0016J \u0010\\\u001a\u0002042\u0006\u00105\u001a\u00020\u00122\u0006\u0010]\u001a\u00020\f2\u0006\u0010^\u001a\u00020\bH\u0016J\u0016\u0010_\u001a\u0002042\f\u0010`\u001a\b\u0012\u0004\u0012\u00020\u00120aH\u0016J\u0006\u0010b\u001a\u000204J$\u0010c\u001a\u0002042\b\u0010d\u001a\u0004\u0018\u00010+2\b\u00106\u001a\u0004\u0018\u00010\f2\u0006\u0010V\u001a\u00020\bH\u0002J\u0006\u0010e\u001a\u000204J\b\u0010f\u001a\u000204H\u0002J\u0010\u0010g\u001a\u0002042\u0006\u0010h\u001a\u00020\u0012H\u0002J*\u0010i\u001a\u0002042\u0006\u0010J\u001a\u00020\u00122\b\u0010j\u001a\u0004\u0018\u00010k2\u0006\u0010l\u001a\u00020\b2\u0006\u0010m\u001a\u00020\fH\u0002J\u0010\u0010n\u001a\u0002042\u0006\u0010h\u001a\u00020\u0012H\u0002J0\u0010o\u001a\u00020$2\u0006\u0010p\u001a\u00020\b2\u0006\u0010E\u001a\u00020\f2\b\u00106\u001a\u0004\u0018\u00010\f2\u0006\u0010V\u001a\u00020\b2\u0006\u0010q\u001a\u00020\fJ\u0010\u0010r\u001a\u0002042\u0006\u0010J\u001a\u00020\u0012H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010*\u001a\u0004\u0018\u00010+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006t"}, d2 = {"Lcom/wifi/ad/core/spstrategy/SPStrategyManager;", "Lcom/wifi/ad/core/strategy/AbsStrategy;", "()V", "adCurParams", "Lcom/wifi/ad/core/config/AdParams;", "adLoadListenerEd", "Ljava/util/concurrent/atomic/AtomicBoolean;", "adLoadSeq", "", "adSuccess", "adSuccessEd", LxAdConst.EventKeyParams.KEY_PARAM_ADUNITID, "", "allAdCount", "allAdsAds", "", "Lcom/wifi/ad/core/spstrategy/SPGroupAdData;", "allFailList", "Lcom/wifi/ad/core/data/NestAdData;", "allFailedCount", "allGroupNum", "allSuccessList", WiseOpenHianalyticsData.UNION_COSTTIME, "", "curAdScene", "curCjsMaxEcpm", "curGroupLoadAdMg", "Lcom/wifi/ad/core/spstrategy/SPOneGroupLoadAd;", "curInventoryId", "curScene", "Lcom/wifi/ad/core/strategy/LoadScene;", "filterConfig", "Lcom/wifi/ad/core/data/FilterConfigBean;", "filterOn", "filtered", "hasFindCsjMaxEcpm", "", "isShow", "mPacker", "Lcom/wifi/ad/core/helper/ActivityPacker;", "nestType", "renderStyle", "sdkConfig", "Lcom/wifi/ad/core/spstrategy/SPModel;", "getSdkConfig", "()Lcom/wifi/ad/core/spstrategy/SPModel;", "setSdkConfig", "(Lcom/wifi/ad/core/spstrategy/SPModel;)V", "whiteFilterConfig", "Lcom/wifi/ad/core/data/WhiteFilterConfigBean;", "whiteFilterOn", "adFailedCache", "", "nestAdData", "requestId", "adLoadCache", "adLoadMda", "curAdData", "answerAdLoaded", "timeMdaModel", "Lcom/wifi/ad/core/spstrategy/SPCacheTimeModel;", "adScene", "adParams", "callbackAdFailed", "errorCode", "msg", "checkAdLoad", "ext", "", "strategyId", "checkAdLoadTimeOut", "fRequestId", "checkGdtAd", "adDatas", "adData", "findCacheMaxAd", "timeOut", "finishRequest", "getAdLoadSeq", "getCurCsjMaxEcpm", "getShowDataWithFilter", "isAnswerHighPriceOpen", "isAnswerHighPriceOpenOld", "isAnswerMaxPriceSwitch", h.Code, "packer", "scene", "loadAdFailed", "loadSuccess", "adDispatchEd", "onAdExpose", "providerType", "onAdFailed", "failedMsg", "code", "onAdLoaded", "adList", "", "onDestroy", "parserAllAds", "spModel", "requestAdCountAdd", "resetAd", "setFilterOn", "successData", "setSdkCfg", "sdkCfg", "Lcom/wifi/ad/core/spstrategy/SPSdkcfgModel;", "defTimeOut", "sdkType", "setWhiteFilterOn", "startRequestAd", "curIndexNum", "mAdvanceRequest", "updateFilterOn", "Companion", "core_release"}, k = 1, mv = {1, 1, 16})
public final class SPStrategyManager extends AbsStrategy {
    public static final int SP_MODE = 6;
    private AdParams adCurParams;
    private int adLoadSeq;
    private int allAdCount;
    private int allFailedCount;
    private int allGroupNum;
    private long costTime;
    private int curAdScene;
    private SPOneGroupLoadAd curGroupLoadAdMg;
    private LoadScene curScene;
    private FilterConfigBean filterConfig;
    private boolean hasFindCsjMaxEcpm;
    private ActivityPacker mPacker;
    private int renderStyle;
    private SPModel sdkConfig;
    private WhiteFilterConfigBean whiteFilterConfig;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static HashMap<String, Long> freezeAdSp = new HashMap<>();
    private static HashMap<Integer, String> sceneRequestId = new HashMap<>();
    private final List<SPGroupAdData> allAdsAds = new ArrayList();
    private List<NestAdData> allSuccessList = new ArrayList();
    private List<NestAdData> allFailList = new ArrayList();
    private AtomicBoolean isShow = new AtomicBoolean(false);
    private AtomicBoolean filterOn = new AtomicBoolean(false);
    private AtomicBoolean filtered = new AtomicBoolean(false);
    private String curInventoryId = "";
    private AtomicBoolean adSuccessEd = new AtomicBoolean(false);
    private AtomicBoolean adLoadListenerEd = new AtomicBoolean(false);
    private AtomicBoolean adSuccess = new AtomicBoolean(false);
    private AtomicBoolean whiteFilterOn = new AtomicBoolean(false);
    private String curCjsMaxEcpm = "";
    private String nestType = "";
    private String adUnitId = "";

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R6\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR6\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007`\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/wifi/ad/core/spstrategy/SPStrategyManager$Companion;", "", "()V", "SP_MODE", "", "freezeAdSp", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getFreezeAdSp", "()Ljava/util/HashMap;", "setFreezeAdSp", "(Ljava/util/HashMap;)V", "sceneRequestId", "getSceneRequestId", "setSceneRequestId", "core_release"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public final HashMap<String, Long> getFreezeAdSp() {
            return SPStrategyManager.freezeAdSp;
        }

        public final HashMap<Integer, String> getSceneRequestId() {
            return SPStrategyManager.sceneRequestId;
        }

        public final void setFreezeAdSp(HashMap<String, Long> map) {
            SPStrategyManager.freezeAdSp = map;
        }

        public final void setSceneRequestId(HashMap<Integer, String> map) {
            SPStrategyManager.sceneRequestId = map;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void adFailedCache(NestAdData nestAdData, String requestId) {
        nestAdData.getTimeOutOrResEd().set(true);
        if (WifiLog.isDebugMode) {
            WifiLog.d(requestId + " scene:" + this.curAdScene + " SPAD onAdFailed nestAdData.curGroupNum " + nestAdData.getCurGroupNum());
        }
        if (nestAdData.getAdCode() != null) {
            if (WifiLog.isDebugMode) {
                WifiLog.d(requestId + " scene:" + this.curAdScene + " SPAD Freeze " + nestAdData.getAdCode() + "请求失败，保存冷却时间");
            }
            HashMap<String, Long> map = freezeAdSp;
            String adCode = nestAdData.getAdCode();
            if (adCode == null) {
                Intrinsics.throwNpe();
            }
            map.put(adCode, Long.valueOf(System.currentTimeMillis() / ((long) 1000)));
        }
    }

    private final void adLoadCache(NestAdData nestAdData, String requestId) {
        nestAdData.getTimeOutOrResEd().set(true);
        if (WifiLog.isDebugMode) {
            WifiLog.d(requestId + " scene:" + this.curAdScene + " SPAD onAdLoaded nestAdData.curGroupNum " + nestAdData.getCurGroupNum());
        }
        SPCacheManager.INSTANCE.saveCacheAd(nestAdData, requestId, this.curAdScene);
    }

    private final void adLoadMda(NestAdData curAdData) {
        if (curAdData == null || curAdData.getAdParams() == null) {
            return;
        }
        AbstractReporter reporter = WifiNestAd.INSTANCE.getReporter();
        EventParams eventParamsByAdData = EventParams.getEventParamsByAdData(curAdData);
        Intrinsics.checkExpressionValueIsNotNull(eventParamsByAdData, "EventParams.getEventParamsByAdData(curAdData)");
        AdParams adParams = curAdData.getAdParams();
        if (adParams == null) {
            Intrinsics.throwNpe();
        }
        reporter.onEvent(WifiNestConst.EventKey.NEST_SDK_AD_GET, eventParamsByAdData, adParams.getExt());
    }

    private final void answerAdLoaded(SPCacheTimeModel timeMdaModel, String requestId, int adScene, AdParams adParams) {
        if (isAnswerHighPriceOpen()) {
            if (WifiLog.isDebugMode) {
                WifiLog.d(requestId + " scene:" + adScene + " SPAD 应答逻辑优化开关开启,不立即应答");
                return;
            }
            return;
        }
        SPCacheManager sPCacheManager = SPCacheManager.INSTANCE;
        SPModel sPModel = this.sdkConfig;
        if (sPModel == null) {
            Intrinsics.throwNpe();
        }
        String strategy_id = sPModel.getStrategy_id();
        if (strategy_id == null) {
            Intrinsics.throwNpe();
        }
        sPCacheManager.removeHWAdByCache(requestId, strategy_id);
        SPModel sPModel2 = this.sdkConfig;
        if (sPModel2 == null) {
            Intrinsics.throwNpe();
        }
        String strategy_id2 = sPModel2.getStrategy_id();
        if (strategy_id2 == null) {
            Intrinsics.throwNpe();
        }
        NestAdData nestAdDataFindAndDispatchCacheAd = sPCacheManager.findAndDispatchCacheAd(strategy_id2, timeMdaModel, requestId, null);
        if (nestAdDataFindAndDispatchCacheAd == null) {
            if (WifiLog.isDebugMode) {
                WifiLog.d(requestId + " scene:" + adScene + " SPAD 应答逻辑优化开关关闭，应立即应答，但缓存无广告可以应答");
                return;
            }
            return;
        }
        if (WifiLog.isDebugMode) {
            WifiLog.d(requestId + " scene:" + adScene + " SPAD MDA 应答逻辑优化开关关闭，缓存有广告可以应答 nest_sdk_ad_cache_answer，curAdData " + nestAdDataFindAndDispatchCacheAd);
        }
        AbstractReporter reporter = WifiNestAd.INSTANCE.getReporter();
        EventParams eventParamsByAdData = EventParams.getEventParamsByAdData(nestAdDataFindAndDispatchCacheAd);
        Intrinsics.checkExpressionValueIsNotNull(eventParamsByAdData, "EventParams.getEventParamsByAdData(curAdData)");
        reporter.onEvent(WifiNestConst.EventKey.NEST_AD_CACHE_ANSWER, eventParamsByAdData, adParams.getExt());
        nestAdDataFindAndDispatchCacheAd.setUseRequestId(requestId);
        loadSuccess(requestId, adScene, nestAdDataFindAndDispatchCacheAd, false);
    }

    private final void callbackAdFailed(String errorCode, String msg) {
        BaseListener listener = getListener();
        if (listener != null) {
            listener.onAdFailed(errorCode, msg);
        }
    }

    private final void checkAdLoad(Map<String, String> ext, String requestId, String strategyId, int adScene) {
        if (SPCacheManager.INSTANCE.findCacheAdSize(strategyId, null, requestId) <= 0) {
            loadAdFailed(requestId, adScene, "30601", "并行请求超时");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkAdLoadTimeOut(Map<String, String> ext, String fRequestId, String strategyId, int adScene) {
        if (isAnswerHighPriceOpen()) {
            findCacheMaxAd(fRequestId, strategyId, adScene, true, false);
        } else {
            checkAdLoad(ext, fRequestId, strategyId, adScene);
        }
    }

    private final NestAdData checkGdtAd(List<NestAdData> adDatas, NestAdData adData) {
        if (adData == null || adData.getAdCode() == null || adDatas == null) {
            return null;
        }
        int size = adDatas.size();
        for (int i = 0; i < size; i++) {
            if (Intrinsics.areEqual(adData.getAdCode(), adDatas.get(i).getAdCode())) {
                return adDatas.get(i);
            }
        }
        return null;
    }

    private final boolean getShowDataWithFilter(NestAdData adData) {
        updateFilterOn(adData);
        StrategyManager strategyManager = StrategyManager.INSTANCE;
        BlackListFilterData blackListFilterDataShouldFilter = strategyManager.shouldFilter(this.filterOn, this.filterConfig, adData);
        this.costTime += blackListFilterDataShouldFilter.getCostTime();
        if (blackListFilterDataShouldFilter.getShouldFilter()) {
            this.filtered.set(true);
            return false;
        }
        BlackListFilterData blackListFilterDataShouldFilterWhiteList = strategyManager.shouldFilterWhiteList(this.whiteFilterOn, this.whiteFilterConfig, adData);
        this.costTime += blackListFilterDataShouldFilterWhiteList.getCostTime();
        if (!blackListFilterDataShouldFilterWhiteList.getShouldFilter()) {
            return true;
        }
        this.filtered.set(true);
        return false;
    }

    private final void loadAdFailed(String requestId, int adScene, String errorCode, String msg) {
        if (WifiLog.isDebugMode) {
            WifiLog.d(requestId + " scene:" + adScene + " SPAD 总的超时计数结束 adLoadListenerEd：" + this.adLoadListenerEd.get());
        }
        if (this.adLoadListenerEd.get()) {
            return;
        }
        if (WifiLog.isDebugMode) {
            WifiLog.d(requestId + " scene:" + adScene + " SPAD 应答上游-广告请求失败 【errorCode:" + errorCode + " msg:" + msg + (char) 12305);
        }
        this.adLoadListenerEd.set(true);
        callbackAdFailed(errorCode, msg);
    }

    private final void loadSuccess(String requestId, int adScene, NestAdData curAdData, boolean adDispatchEd) {
        BaseListener listener;
        if (this.adLoadListenerEd.get()) {
            return;
        }
        if (WifiLog.isDebugMode) {
            WifiLog.d(requestId + " scene:" + adScene + " SPAD 应答上游-广告请求成功, curAdData:" + curAdData);
        }
        this.adLoadListenerEd.set(true);
        adLoadMda(curAdData);
        if (adDispatchEd) {
            curAdData.setAdDispatchEd(Boolean.TRUE);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(curAdData);
        String adType = curAdData.getAdType();
        if (adType == null || (listener = getListener()) == null) {
            return;
        }
        listener.onAdLoaded(adType, arrayList);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0461  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0492  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0548  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0558  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x05ae  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x05b1  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x088c  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x0893  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x091b  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01bc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void parserAllAds(SPModel spModel, String requestId, int scene) {
        int whiteSwitch;
        int blackSwitch;
        int adHighPrioritySwitch;
        int adStrategyOptimizeSwitch;
        int primeRitSwitch;
        int shakeSwitch;
        int shakeSwitchLxad;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        Object obj;
        SPSdkcfgModel sPSdkcfgModel;
        SPSdkcfgModel sPSdkcfgModel2;
        SPSdkcfgModel sPSdkcfgModel3;
        SPSdkcfgModel sPSdkcfgModel4;
        SPSdkcfgModel sPSdkcfgModel5;
        SPSdkcfgModel sPSdkcfgModel6;
        SPSdkcfgModel sPSdkcfgModel7;
        SPSdkcfgModel sPSdkcfgModel8;
        SPSdkcfgModel sPSdkcfgModel9;
        String str;
        String str2;
        SPGroupAdData sPGroupAdData;
        int i;
        String str3;
        String str4;
        int i2;
        int i3;
        JSONObject jSONObject3;
        SPSdkcfgModel sPSdkcfgModel10;
        String str5;
        String str6;
        SPSdkcfgModel sPSdkcfgModel11;
        ArrayList arrayList;
        String str7;
        String str8;
        NestAdData nestAdData;
        int i4;
        String dspName;
        int i5;
        String str9;
        HashMap map;
        HashMap map2;
        List<SPSdkcfgModel> list;
        JSONObject jSONObject4;
        resetAd();
        if (spModel != null) {
            if (spModel.getPkCfgObject() != null && spModel.getStrategy_id() != null) {
                SPPkManager sPPkManager = SPPkManager.INSTANCE;
                String strategy_id = spModel.getStrategy_id();
                if (strategy_id == null) {
                    Intrinsics.throwNpe();
                }
                JSONArray pkCfgObject = spModel.getPkCfgObject();
                if (pkCfgObject == null) {
                    Intrinsics.throwNpe();
                }
                sPPkManager.savePkcfg(strategy_id, pkCfgObject);
            }
            SPSwitchModel switchModel = spModel.getSwitchModel();
            if (switchModel != null) {
                whiteSwitch = switchModel.getWhiteSwitch();
                blackSwitch = switchModel.getBlackSwitch();
                adHighPrioritySwitch = switchModel.getAdHighPrioritySwitch();
                adStrategyOptimizeSwitch = switchModel.getAdStrategyOptimizeSwitch();
                primeRitSwitch = switchModel.getPrimeRitSwitch();
                shakeSwitch = switchModel.getShakeSwitch();
                shakeSwitchLxad = switchModel.getShakeSwitchLxad();
                int adMaxPriceSwitch = switchModel.getAdMaxPriceSwitch();
                jSONObject = !TextUtils.isEmpty(switchModel.getInteractSettings()) ? new JSONObject(switchModel.getInteractSettings()) : null;
                if (WifiLog.isDebugMode) {
                    WifiLog.d("SPStrategyManager shakeSwitch is " + shakeSwitch + " primeRitSwitch " + primeRitSwitch + " maxPriceSwitch " + adMaxPriceSwitch + " shakeSwitchLxad " + shakeSwitchLxad);
                }
            } else {
                whiteSwitch = 0;
                blackSwitch = 0;
                adHighPrioritySwitch = 0;
                adStrategyOptimizeSwitch = 0;
                primeRitSwitch = 0;
                shakeSwitch = 0;
                shakeSwitchLxad = 0;
                jSONObject = null;
            }
            SPCachecfgModel cachecfgModel = spModel.getCachecfgModel();
            int defTime = (cachecfgModel == null || cachecfgModel.getDefTime() <= 0) ? 0 : cachecfgModel.getDefTime();
            List<SPSdkcfgModel> sdkCfgModels = spModel.getSdkCfgModels();
            String str10 = "Q";
            String str11 = "O";
            int i6 = defTime;
            String str12 = "K";
            int i7 = shakeSwitchLxad;
            int i8 = shakeSwitch;
            String str13 = WkAdxAdConfigMg.DSP_NAME_GDT;
            int i9 = primeRitSwitch;
            int i10 = adStrategyOptimizeSwitch;
            int i11 = adHighPrioritySwitch;
            String str14 = WkAdxAdConfigMg.DSP_NAME_CSJ;
            int i12 = blackSwitch;
            String str15 = WkAdxAdConfigMg.DSP_NAME_BAIDU;
            int i13 = whiteSwitch;
            if (sdkCfgModels != null) {
                List<SPSdkcfgModel> list2 = sdkCfgModels;
                if (!list2.isEmpty()) {
                    int size = list2.size();
                    int i14 = 0;
                    sPSdkcfgModel5 = null;
                    SPSdkcfgModel sPSdkcfgModel12 = null;
                    SPSdkcfgModel sPSdkcfgModel13 = null;
                    SPSdkcfgModel sPSdkcfgModel14 = null;
                    SPSdkcfgModel sPSdkcfgModel15 = null;
                    SPSdkcfgModel sPSdkcfgModel16 = null;
                    SPSdkcfgModel sPSdkcfgModel17 = null;
                    SPSdkcfgModel sPSdkcfgModel18 = null;
                    SPSdkcfgModel sPSdkcfgModel19 = null;
                    while (i14 < size) {
                        SPSdkcfgModel sPSdkcfgModel20 = sdkCfgModels.get(i14);
                        int i15 = size;
                        String dspName2 = sPSdkcfgModel20.getDspName();
                        if (dspName2 == null) {
                            jSONObject4 = jSONObject;
                            list = sdkCfgModels;
                        } else {
                            list = sdkCfgModels;
                            int iHashCode = dspName2.hashCode();
                            jSONObject4 = jSONObject;
                            if (iHashCode == 66) {
                                dspName2.equals(WkAdxAdConfigMg.DSP_NAME_BAIDU);
                            } else if (iHashCode != 67) {
                                if (iHashCode != 75) {
                                    if (iHashCode != 76) {
                                        if (iHashCode != 79) {
                                            if (iHashCode == 81) {
                                                dspName2.equals("Q");
                                            } else if (iHashCode != 87) {
                                                switch (iHashCode) {
                                                    case 69:
                                                        if (dspName2.equals(ExifInterface.LONGITUDE_EAST)) {
                                                            sPSdkcfgModel17 = sPSdkcfgModel20;
                                                        }
                                                        break;
                                                    case 70:
                                                        if (dspName2.equals("F")) {
                                                            sPSdkcfgModel18 = sPSdkcfgModel20;
                                                        }
                                                        break;
                                                    case 71:
                                                        if (dspName2.equals(WkAdxAdConfigMg.DSP_NAME_GDT)) {
                                                            sPSdkcfgModel12 = sPSdkcfgModel20;
                                                        }
                                                        break;
                                                    case 72:
                                                        if (dspName2.equals("H")) {
                                                            sPSdkcfgModel16 = sPSdkcfgModel20;
                                                        }
                                                        break;
                                                }
                                            } else if (dspName2.equals("W")) {
                                                sPSdkcfgModel14 = sPSdkcfgModel20;
                                            }
                                        } else if (dspName2.equals("O")) {
                                            sPSdkcfgModel15 = sPSdkcfgModel20;
                                        }
                                    } else if (dspName2.equals("L")) {
                                        sPSdkcfgModel19 = sPSdkcfgModel20;
                                    }
                                } else if (dspName2.equals("K")) {
                                    sPSdkcfgModel13 = sPSdkcfgModel20;
                                }
                            } else if (dspName2.equals(WkAdxAdConfigMg.DSP_NAME_CSJ)) {
                                sPSdkcfgModel5 = sPSdkcfgModel20;
                            }
                        }
                        i14++;
                        size = i15;
                        sdkCfgModels = list;
                        jSONObject = jSONObject4;
                    }
                    jSONObject2 = jSONObject;
                    sPSdkcfgModel2 = sPSdkcfgModel12;
                    sPSdkcfgModel6 = sPSdkcfgModel15;
                    sPSdkcfgModel = sPSdkcfgModel16;
                    sPSdkcfgModel3 = sPSdkcfgModel17;
                    sPSdkcfgModel9 = sPSdkcfgModel19;
                    sPSdkcfgModel8 = sPSdkcfgModel13;
                    sPSdkcfgModel7 = sPSdkcfgModel14;
                    obj = "W";
                    sPSdkcfgModel4 = sPSdkcfgModel18;
                } else {
                    jSONObject2 = jSONObject;
                    obj = "W";
                    sPSdkcfgModel = null;
                    sPSdkcfgModel2 = null;
                    sPSdkcfgModel3 = null;
                    sPSdkcfgModel4 = null;
                    sPSdkcfgModel5 = null;
                    sPSdkcfgModel6 = null;
                    sPSdkcfgModel7 = null;
                    sPSdkcfgModel8 = null;
                    sPSdkcfgModel9 = null;
                }
            }
            List<SPGroupcfgModel> groupcfgModels = spModel.getGroupcfgModels();
            SPSdkcfgModel sPSdkcfgModel21 = sPSdkcfgModel3;
            HashMap map3 = new HashMap();
            SPSdkcfgModel sPSdkcfgModel22 = sPSdkcfgModel4;
            ArrayList arrayList2 = new ArrayList();
            if (groupcfgModels != null) {
                List<SPGroupcfgModel> list3 = groupcfgModels;
                if (!list3.isEmpty()) {
                    ArrayList arrayList3 = arrayList2;
                    this.allGroupNum = groupcfgModels.size();
                    int size2 = list3.size();
                    HashMap map4 = map3;
                    int i16 = 0;
                    while (i16 < size2) {
                        SPGroupcfgModel sPGroupcfgModel = groupcfgModels.get(i16);
                        List<SPGroupcfgModel> list4 = groupcfgModels;
                        List<SPSlotcfgModel> slotcfgModels = sPGroupcfgModel.getSlotcfgModels();
                        int i17 = size2;
                        SPGroupAdData sPGroupAdData2 = new SPGroupAdData();
                        SPSdkcfgModel sPSdkcfgModel23 = sPSdkcfgModel2;
                        sPGroupAdData2.setGroupId(sPGroupcfgModel.getGroupId());
                        sPGroupAdData2.setMaxEcpm(sPGroupcfgModel.getMaxEcpm());
                        sPGroupAdData2.setMinEcpm(sPGroupcfgModel.getMinEcpm());
                        sPGroupAdData2.setTimeOut(sPGroupcfgModel.getTimeOut());
                        if (slotcfgModels != null) {
                            List<SPSlotcfgModel> list5 = slotcfgModels;
                            if (!list5.isEmpty()) {
                                int size3 = list5.size();
                                sPGroupAdData = sPGroupAdData2;
                                int i18 = 0;
                                while (i18 < size3) {
                                    SPSlotcfgModel sPSlotcfgModel = slotcfgModels.get(i18);
                                    int i19 = size3;
                                    String dspName3 = sPSlotcfgModel.getDspName();
                                    List<SPSlotcfgModel> list6 = slotcfgModels;
                                    if (Intrinsics.areEqual(str14, dspName3)) {
                                        WifiNestAd wifiNestAd = WifiNestAd.INSTANCE;
                                        if (wifiNestAd.getCsjInit()) {
                                            i = i18;
                                            str3 = str14;
                                            if (WifiLog.isDebugMode) {
                                                WifiLog.d("parserAllAds allAdCount " + this.allAdCount + " interactionListener " + getInteractionListener());
                                            }
                                            nestAdData = new NestAdData();
                                            if (Intrinsics.areEqual(this.nestType, WifiNestConst.NestTypeConst.NEST_FEED_AD) && this.renderStyle == 2 && ((Intrinsics.areEqual(str10, dspName3) || Intrinsics.areEqual(str15, dspName3)) && getInteractionListener() != null)) {
                                                nestAdData.setAdInteractionListener(getInteractionListener());
                                            }
                                            jSONObject3 = jSONObject2;
                                            nestAdData.setInteractSettings(jSONObject3);
                                            nestAdData.setAdUnitId(this.adUnitId);
                                            nestAdData.setInventoryId(this.curInventoryId);
                                            nestAdData.setCreateRequestId(requestId);
                                            nestAdData.setUseRequestId(requestId);
                                            nestAdData.setAdParams(this.adCurParams);
                                            nestAdData.setStrategyId(spModel.getStrategy_id());
                                            nestAdData.setStrategyVer(spModel.getStrategy_ver());
                                            nestAdData.setStartegyTaiChi(spModel.getTaiChiId());
                                            nestAdData.setSourceId(spModel.getSourceId());
                                            nestAdData.setAdMode(6);
                                            nestAdData.setGroupId(sPGroupcfgModel.getGroupId());
                                            nestAdData.setAdSPStrategy(true);
                                            str4 = str10;
                                            nestAdData.setAdRealLevelName(Intrinsics.stringPlus(sPSlotcfgModel.getDspName(), Integer.valueOf(sPGroupcfgModel.getGroupId())));
                                            int i20 = i16 + 1;
                                            nestAdData.setAdLevelName(String.valueOf(i20));
                                            nestAdData.setAdLevel(Integer.valueOf(i20));
                                            nestAdData.setRequestId(requestId);
                                            nestAdData.setWhiteAd(i13);
                                            int i21 = i12;
                                            nestAdData.setBlockAd(i21);
                                            nestAdData.setHighPrioritySwitch(i11);
                                            nestAdData.setAdStrategyOptimizeSwitch(i10);
                                            nestAdData.setPrimeRitSwitch(i9);
                                            nestAdData.setShakeSwitch(i8);
                                            i4 = i7;
                                            nestAdData.setShakeSwitchLxad(i4);
                                            if (cachecfgModel != null || cachecfgModel.getCount() <= 0) {
                                                i7 = i4;
                                            } else {
                                                i7 = i4;
                                                nestAdData.setCacheCount(cachecfgModel.getCount());
                                            }
                                            nestAdData.setMaterialModel(spModel.getMaterialModel());
                                            nestAdData.setAdScene(this.curAdScene);
                                            nestAdData.setAdCost(sPSlotcfgModel.getEcpm());
                                            nestAdData.setPreRequest(sPSlotcfgModel.getPreRequest());
                                            nestAdData.setFreezetime(sPSlotcfgModel.getFreezetime());
                                            nestAdData.setAdCostType(sPSlotcfgModel.getAdCostType());
                                            nestAdData.setEcpmLowPrice(sPSlotcfgModel.getEcpmLowPrice());
                                            nestAdData.setPriceSwitch(sPSlotcfgModel.getPriceSwitch());
                                            nestAdData.setEcpmRatio(sPSlotcfgModel.getEcpmRatio());
                                            nestAdData.setAdCode(sPSlotcfgModel.getSlotid());
                                            nestAdData.setAdName(sPSlotcfgModel.getDspName());
                                            nestAdData.setStrategyListener(this);
                                            dspName = sPSlotcfgModel.getDspName();
                                            if (dspName != null) {
                                                str5 = str15;
                                            } else {
                                                int iHashCode2 = dspName.hashCode();
                                                str5 = str15;
                                                if (iHashCode2 == 67) {
                                                    str6 = str13;
                                                    i5 = i6;
                                                    sPSdkcfgModel11 = sPSdkcfgModel22;
                                                    arrayList = arrayList3;
                                                    sPSdkcfgModel10 = sPSdkcfgModel;
                                                    String str16 = str3;
                                                    if (dspName.equals(str16)) {
                                                        str3 = str16;
                                                        SPSdkcfgModel sPSdkcfgModel24 = sPSdkcfgModel5;
                                                        setSdkCfg(nestAdData, sPSdkcfgModel24, i5, SDKAlias.CSJ.getType());
                                                        sPGroupAdData.getAdDatas().add(nestAdData);
                                                        try {
                                                            if (this.hasFindCsjMaxEcpm || sPSlotcfgModel.getSlotid() == null) {
                                                                sPSdkcfgModel5 = sPSdkcfgModel24;
                                                            } else {
                                                                String strValueOf = String.valueOf(System.currentTimeMillis());
                                                                sPSdkcfgModel5 = sPSdkcfgModel24;
                                                                if (strValueOf == null) {
                                                                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                                                                }
                                                                try {
                                                                    String strSubstring = strValueOf.substring(4);
                                                                    Intrinsics.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.String).substring(startIndex)");
                                                                    this.adLoadSeq = Integer.parseInt(strSubstring);
                                                                    String slotid = sPSlotcfgModel.getSlotid();
                                                                    if (slotid == null) {
                                                                        Intrinsics.throwNpe();
                                                                    }
                                                                    this.curCjsMaxEcpm = slotid;
                                                                    this.hasFindCsjMaxEcpm = true;
                                                                    if (WifiLog.isDebugMode) {
                                                                        WifiLog.d("SPStrategyManager curMaxEcpm: " + nestAdData.getAdCost() + " adcode: " + this.curCjsMaxEcpm + " adLoadSeq: " + this.adLoadSeq);
                                                                    }
                                                                } catch (Exception unused) {
                                                                }
                                                            }
                                                            if (WifiLog.isDebugMode) {
                                                                WifiLog.d("SPStrategyManager curEcpm: " + nestAdData.getAdCost());
                                                            }
                                                        } catch (Exception unused2) {
                                                            sPSdkcfgModel5 = sPSdkcfgModel24;
                                                        }
                                                    } else {
                                                        str3 = str16;
                                                    }
                                                } else if (iHashCode2 == 79) {
                                                    str6 = str13;
                                                    i5 = i6;
                                                    sPSdkcfgModel11 = sPSdkcfgModel22;
                                                    arrayList = arrayList3;
                                                    sPSdkcfgModel10 = sPSdkcfgModel;
                                                    SPSdkcfgModel sPSdkcfgModel25 = sPSdkcfgModel7;
                                                    if (dspName.equals(str11)) {
                                                        sPSdkcfgModel7 = sPSdkcfgModel25;
                                                        setSdkCfg(nestAdData, sPSdkcfgModel6, i5, SDKAlias.OPPO.getType());
                                                        sPGroupAdData.getAdDatas().add(nestAdData);
                                                    } else {
                                                        sPSdkcfgModel7 = sPSdkcfgModel25;
                                                    }
                                                } else if (iHashCode2 == 87) {
                                                    str6 = str13;
                                                    i5 = i6;
                                                    sPSdkcfgModel11 = sPSdkcfgModel22;
                                                    arrayList = arrayList3;
                                                    sPSdkcfgModel10 = sPSdkcfgModel;
                                                    Object obj2 = obj;
                                                    if (dspName.equals(obj2)) {
                                                        obj = obj2;
                                                        setSdkCfg(nestAdData, sPSdkcfgModel7, i5, SDKAlias.WIFI.getType());
                                                        sPGroupAdData.getAdDatas().add(nestAdData);
                                                    } else {
                                                        obj = obj2;
                                                    }
                                                } else if (iHashCode2 == 75) {
                                                    str6 = str13;
                                                    i5 = i6;
                                                    sPSdkcfgModel11 = sPSdkcfgModel22;
                                                    arrayList = arrayList3;
                                                    sPSdkcfgModel10 = sPSdkcfgModel;
                                                    SPSdkcfgModel sPSdkcfgModel26 = sPSdkcfgModel9;
                                                    if (dspName.equals(str12)) {
                                                        sPSdkcfgModel9 = sPSdkcfgModel26;
                                                        setSdkCfg(nestAdData, sPSdkcfgModel8, i5, SDKAlias.KS.getType());
                                                        sPGroupAdData.getAdDatas().add(nestAdData);
                                                    } else {
                                                        sPSdkcfgModel9 = sPSdkcfgModel26;
                                                    }
                                                } else if (iHashCode2 != 76) {
                                                    switch (iHashCode2) {
                                                        case 69:
                                                            str6 = str13;
                                                            i5 = i6;
                                                            sPSdkcfgModel11 = sPSdkcfgModel22;
                                                            arrayList = arrayList3;
                                                            sPSdkcfgModel10 = sPSdkcfgModel;
                                                            map = map4;
                                                            if (!dspName.equals(ExifInterface.LONGITUDE_EAST)) {
                                                                map4 = map;
                                                            } else {
                                                                map4 = map;
                                                                setSdkCfg(nestAdData, sPSdkcfgModel21, i5, SDKAlias.BEIZI.getType());
                                                                sPGroupAdData.getAdDatas().add(nestAdData);
                                                            }
                                                            break;
                                                        case 70:
                                                            str6 = str13;
                                                            i5 = i6;
                                                            arrayList = arrayList3;
                                                            sPSdkcfgModel10 = sPSdkcfgModel;
                                                            map = map4;
                                                            if (dspName.equals("F")) {
                                                                sPSdkcfgModel11 = sPSdkcfgModel22;
                                                                setSdkCfg(nestAdData, sPSdkcfgModel11, i5, SDKAlias.FEISUO.getType());
                                                                sPGroupAdData.getAdDatas().add(nestAdData);
                                                            } else {
                                                                sPSdkcfgModel11 = sPSdkcfgModel22;
                                                            }
                                                            map4 = map;
                                                            break;
                                                        case 71:
                                                            i5 = i6;
                                                            if (dspName.equals(str13)) {
                                                                SPSdkcfgModel sPSdkcfgModel27 = sPSdkcfgModel23;
                                                                setSdkCfg(nestAdData, sPSdkcfgModel27, i5, SDKAlias.GDT.getType());
                                                                if (TextUtils.isEmpty(sPSlotcfgModel.getEcpmTag()) || sPSlotcfgModel.getEcpm() < 0) {
                                                                    sPSdkcfgModel10 = sPSdkcfgModel;
                                                                    sPSdkcfgModel23 = sPSdkcfgModel27;
                                                                    str6 = str13;
                                                                    map2 = map4;
                                                                } else {
                                                                    sPSdkcfgModel10 = sPSdkcfgModel;
                                                                    map2 = map4;
                                                                    if (map2.containsKey(nestAdData.getAdCode())) {
                                                                        HashMap<String, Integer> map5 = (HashMap) map2.get(nestAdData.getAdCode());
                                                                        sPSdkcfgModel23 = sPSdkcfgModel27;
                                                                        if (map5 != null) {
                                                                            String ecpmTag = sPSlotcfgModel.getEcpmTag();
                                                                            if (ecpmTag == null) {
                                                                                Intrinsics.throwNpe();
                                                                            }
                                                                            str6 = str13;
                                                                            map5.put(ecpmTag, Integer.valueOf(sPSlotcfgModel.getEcpm()));
                                                                            Unit unit = Unit.INSTANCE;
                                                                            nestAdData.setEcpmMap(map5);
                                                                        } else {
                                                                            str6 = str13;
                                                                        }
                                                                    } else {
                                                                        sPSdkcfgModel23 = sPSdkcfgModel27;
                                                                        str6 = str13;
                                                                        HashMap<String, Integer> ecpmMap = nestAdData.getEcpmMap();
                                                                        String ecpmTag2 = sPSlotcfgModel.getEcpmTag();
                                                                        if (ecpmTag2 == null) {
                                                                            Intrinsics.throwNpe();
                                                                        }
                                                                        ecpmMap.put(ecpmTag2, Integer.valueOf(sPSlotcfgModel.getEcpm()));
                                                                        String adCode = nestAdData.getAdCode();
                                                                        if (adCode == null) {
                                                                            Intrinsics.throwNpe();
                                                                        }
                                                                        map2.put(adCode, nestAdData.getEcpmMap());
                                                                    }
                                                                }
                                                                arrayList = arrayList3;
                                                                NestAdData nestAdDataCheckGdtAd = checkGdtAd(arrayList, nestAdData);
                                                                if (nestAdDataCheckGdtAd != null) {
                                                                    String adCode2 = nestAdData.getAdCode();
                                                                    if (adCode2 == null) {
                                                                        Intrinsics.throwNpe();
                                                                    }
                                                                    Object obj3 = map2.get(adCode2);
                                                                    if (obj3 == null) {
                                                                        Intrinsics.throwNpe();
                                                                    }
                                                                    nestAdDataCheckGdtAd.setEcpmMap((HashMap) obj3);
                                                                } else {
                                                                    arrayList.add(nestAdData);
                                                                    sPGroupAdData.getAdDatas().add(nestAdData);
                                                                }
                                                                map4 = map2;
                                                            } else {
                                                                sPSdkcfgModel10 = sPSdkcfgModel;
                                                                str6 = str13;
                                                                arrayList = arrayList3;
                                                            }
                                                            sPSdkcfgModel11 = sPSdkcfgModel22;
                                                            break;
                                                        case 72:
                                                            if (dspName.equals("H")) {
                                                                i5 = i6;
                                                                setSdkCfg(nestAdData, sPSdkcfgModel, i5, SDKAlias.HUAWEI.getType());
                                                                sPGroupAdData.getAdDatas().add(nestAdData);
                                                            } else {
                                                                i5 = i6;
                                                            }
                                                            sPSdkcfgModel10 = sPSdkcfgModel;
                                                            str6 = str13;
                                                            sPSdkcfgModel11 = sPSdkcfgModel22;
                                                            arrayList = arrayList3;
                                                            break;
                                                    }
                                                } else {
                                                    str6 = str13;
                                                    i5 = i6;
                                                    sPSdkcfgModel11 = sPSdkcfgModel22;
                                                    arrayList = arrayList3;
                                                    sPSdkcfgModel10 = sPSdkcfgModel;
                                                    SPSdkcfgModel sPSdkcfgModel28 = sPSdkcfgModel21;
                                                    if (dspName.equals("L")) {
                                                        sPSdkcfgModel21 = sPSdkcfgModel28;
                                                        setSdkCfg(nestAdData, sPSdkcfgModel9, i5, SDKAlias.LXAD.getType());
                                                        sPGroupAdData.getAdDatas().add(nestAdData);
                                                        str9 = "adx";
                                                        if (!TextUtils.isEmpty(str9)) {
                                                            WkInteractiveManager.setInteractiveValue(nestAdData, str9);
                                                        }
                                                        if (WifiLog.isDebugMode) {
                                                            WifiLog.d("parser priceSwitch " + nestAdData.getPriceSwitch() + "  adcode " + nestAdData.getAdCode());
                                                        }
                                                        str7 = str12;
                                                        str8 = str11;
                                                        i2 = i5;
                                                        i3 = i21;
                                                    } else {
                                                        sPSdkcfgModel21 = sPSdkcfgModel28;
                                                    }
                                                }
                                                str9 = "";
                                                if (!TextUtils.isEmpty(str9)) {
                                                }
                                                if (WifiLog.isDebugMode) {
                                                }
                                                str7 = str12;
                                                str8 = str11;
                                                i2 = i5;
                                                i3 = i21;
                                            }
                                            str6 = str13;
                                            i5 = i6;
                                            sPSdkcfgModel11 = sPSdkcfgModel22;
                                            arrayList = arrayList3;
                                            sPSdkcfgModel10 = sPSdkcfgModel;
                                            str9 = "";
                                            if (!TextUtils.isEmpty(str9)) {
                                            }
                                            if (WifiLog.isDebugMode) {
                                            }
                                            str7 = str12;
                                            str8 = str11;
                                            i2 = i5;
                                            i3 = i21;
                                        } else {
                                            if (WifiLog.isDebugMode) {
                                                StringBuilder sb = new StringBuilder();
                                                i = i18;
                                                sb.append("parserAllAds WifiNestAd.csjInit ");
                                                sb.append(wifiNestAd.getCsjInit());
                                                sb.append(" not allow parser");
                                                WifiLog.d(sb.toString());
                                            } else {
                                                i = i18;
                                            }
                                            str4 = str10;
                                            str3 = str14;
                                            i2 = i6;
                                            i3 = i12;
                                            jSONObject3 = jSONObject2;
                                            sPSdkcfgModel10 = sPSdkcfgModel;
                                            str5 = str15;
                                            str6 = str13;
                                            sPSdkcfgModel11 = sPSdkcfgModel22;
                                            arrayList = arrayList3;
                                            str7 = str12;
                                            str8 = str11;
                                        }
                                    } else {
                                        i = i18;
                                        if (Intrinsics.areEqual(str13, dspName3)) {
                                            WifiNestAd wifiNestAd2 = WifiNestAd.INSTANCE;
                                            if (!wifiNestAd2.getGdtInit()) {
                                                if (WifiLog.isDebugMode) {
                                                    StringBuilder sb2 = new StringBuilder();
                                                    str3 = str14;
                                                    sb2.append("parserAllAds WifiNestAd.gdtInit ");
                                                    sb2.append(wifiNestAd2.getGdtInit());
                                                    sb2.append(" not allow parser");
                                                    WifiLog.d(sb2.toString());
                                                } else {
                                                    str3 = str14;
                                                }
                                            }
                                            str3 = str14;
                                            if (WifiLog.isDebugMode) {
                                            }
                                            nestAdData = new NestAdData();
                                            if (Intrinsics.areEqual(this.nestType, WifiNestConst.NestTypeConst.NEST_FEED_AD)) {
                                                nestAdData.setAdInteractionListener(getInteractionListener());
                                            }
                                            jSONObject3 = jSONObject2;
                                            nestAdData.setInteractSettings(jSONObject3);
                                            nestAdData.setAdUnitId(this.adUnitId);
                                            nestAdData.setInventoryId(this.curInventoryId);
                                            nestAdData.setCreateRequestId(requestId);
                                            nestAdData.setUseRequestId(requestId);
                                            nestAdData.setAdParams(this.adCurParams);
                                            nestAdData.setStrategyId(spModel.getStrategy_id());
                                            nestAdData.setStrategyVer(spModel.getStrategy_ver());
                                            nestAdData.setStartegyTaiChi(spModel.getTaiChiId());
                                            nestAdData.setSourceId(spModel.getSourceId());
                                            nestAdData.setAdMode(6);
                                            nestAdData.setGroupId(sPGroupcfgModel.getGroupId());
                                            nestAdData.setAdSPStrategy(true);
                                            str4 = str10;
                                            nestAdData.setAdRealLevelName(Intrinsics.stringPlus(sPSlotcfgModel.getDspName(), Integer.valueOf(sPGroupcfgModel.getGroupId())));
                                            int i202 = i16 + 1;
                                            nestAdData.setAdLevelName(String.valueOf(i202));
                                            nestAdData.setAdLevel(Integer.valueOf(i202));
                                            nestAdData.setRequestId(requestId);
                                            nestAdData.setWhiteAd(i13);
                                            int i212 = i12;
                                            nestAdData.setBlockAd(i212);
                                            nestAdData.setHighPrioritySwitch(i11);
                                            nestAdData.setAdStrategyOptimizeSwitch(i10);
                                            nestAdData.setPrimeRitSwitch(i9);
                                            nestAdData.setShakeSwitch(i8);
                                            i4 = i7;
                                            nestAdData.setShakeSwitchLxad(i4);
                                            if (cachecfgModel != null) {
                                                i7 = i4;
                                                nestAdData.setMaterialModel(spModel.getMaterialModel());
                                                nestAdData.setAdScene(this.curAdScene);
                                                nestAdData.setAdCost(sPSlotcfgModel.getEcpm());
                                                nestAdData.setPreRequest(sPSlotcfgModel.getPreRequest());
                                                nestAdData.setFreezetime(sPSlotcfgModel.getFreezetime());
                                                nestAdData.setAdCostType(sPSlotcfgModel.getAdCostType());
                                                nestAdData.setEcpmLowPrice(sPSlotcfgModel.getEcpmLowPrice());
                                                nestAdData.setPriceSwitch(sPSlotcfgModel.getPriceSwitch());
                                                nestAdData.setEcpmRatio(sPSlotcfgModel.getEcpmRatio());
                                                nestAdData.setAdCode(sPSlotcfgModel.getSlotid());
                                                nestAdData.setAdName(sPSlotcfgModel.getDspName());
                                                nestAdData.setStrategyListener(this);
                                                dspName = sPSlotcfgModel.getDspName();
                                                if (dspName != null) {
                                                }
                                                str6 = str13;
                                                i5 = i6;
                                                sPSdkcfgModel11 = sPSdkcfgModel22;
                                                arrayList = arrayList3;
                                                sPSdkcfgModel10 = sPSdkcfgModel;
                                                str9 = "";
                                                if (!TextUtils.isEmpty(str9)) {
                                                }
                                                if (WifiLog.isDebugMode) {
                                                }
                                                str7 = str12;
                                                str8 = str11;
                                                i2 = i5;
                                                i3 = i212;
                                            }
                                        } else {
                                            str3 = str14;
                                            if (Intrinsics.areEqual(str11, dspName3)) {
                                                WifiNestAd wifiNestAd3 = WifiNestAd.INSTANCE;
                                                if (!wifiNestAd3.getOppoInit()) {
                                                    if (WifiLog.isDebugMode) {
                                                        WifiLog.d("parserAllAds WifiNestAd.oppoInit " + wifiNestAd3.getOppoInit() + " not allow parser");
                                                    }
                                                }
                                                if (WifiLog.isDebugMode) {
                                                }
                                                nestAdData = new NestAdData();
                                                if (Intrinsics.areEqual(this.nestType, WifiNestConst.NestTypeConst.NEST_FEED_AD)) {
                                                }
                                                jSONObject3 = jSONObject2;
                                                nestAdData.setInteractSettings(jSONObject3);
                                                nestAdData.setAdUnitId(this.adUnitId);
                                                nestAdData.setInventoryId(this.curInventoryId);
                                                nestAdData.setCreateRequestId(requestId);
                                                nestAdData.setUseRequestId(requestId);
                                                nestAdData.setAdParams(this.adCurParams);
                                                nestAdData.setStrategyId(spModel.getStrategy_id());
                                                nestAdData.setStrategyVer(spModel.getStrategy_ver());
                                                nestAdData.setStartegyTaiChi(spModel.getTaiChiId());
                                                nestAdData.setSourceId(spModel.getSourceId());
                                                nestAdData.setAdMode(6);
                                                nestAdData.setGroupId(sPGroupcfgModel.getGroupId());
                                                nestAdData.setAdSPStrategy(true);
                                                str4 = str10;
                                                nestAdData.setAdRealLevelName(Intrinsics.stringPlus(sPSlotcfgModel.getDspName(), Integer.valueOf(sPGroupcfgModel.getGroupId())));
                                                int i2022 = i16 + 1;
                                                nestAdData.setAdLevelName(String.valueOf(i2022));
                                                nestAdData.setAdLevel(Integer.valueOf(i2022));
                                                nestAdData.setRequestId(requestId);
                                                nestAdData.setWhiteAd(i13);
                                                int i2122 = i12;
                                                nestAdData.setBlockAd(i2122);
                                                nestAdData.setHighPrioritySwitch(i11);
                                                nestAdData.setAdStrategyOptimizeSwitch(i10);
                                                nestAdData.setPrimeRitSwitch(i9);
                                                nestAdData.setShakeSwitch(i8);
                                                i4 = i7;
                                                nestAdData.setShakeSwitchLxad(i4);
                                                if (cachecfgModel != null) {
                                                }
                                            } else if (Intrinsics.areEqual(str15, dspName3)) {
                                                WifiNestAd wifiNestAd4 = WifiNestAd.INSTANCE;
                                                if (!wifiNestAd4.getBdInit()) {
                                                    if (WifiLog.isDebugMode) {
                                                        WifiLog.d("parserAllAds WifiNestAd.bdInit " + wifiNestAd4.getBdInit() + " not allow parser");
                                                    }
                                                }
                                                if (WifiLog.isDebugMode) {
                                                }
                                                nestAdData = new NestAdData();
                                                if (Intrinsics.areEqual(this.nestType, WifiNestConst.NestTypeConst.NEST_FEED_AD)) {
                                                }
                                                jSONObject3 = jSONObject2;
                                                nestAdData.setInteractSettings(jSONObject3);
                                                nestAdData.setAdUnitId(this.adUnitId);
                                                nestAdData.setInventoryId(this.curInventoryId);
                                                nestAdData.setCreateRequestId(requestId);
                                                nestAdData.setUseRequestId(requestId);
                                                nestAdData.setAdParams(this.adCurParams);
                                                nestAdData.setStrategyId(spModel.getStrategy_id());
                                                nestAdData.setStrategyVer(spModel.getStrategy_ver());
                                                nestAdData.setStartegyTaiChi(spModel.getTaiChiId());
                                                nestAdData.setSourceId(spModel.getSourceId());
                                                nestAdData.setAdMode(6);
                                                nestAdData.setGroupId(sPGroupcfgModel.getGroupId());
                                                nestAdData.setAdSPStrategy(true);
                                                str4 = str10;
                                                nestAdData.setAdRealLevelName(Intrinsics.stringPlus(sPSlotcfgModel.getDspName(), Integer.valueOf(sPGroupcfgModel.getGroupId())));
                                                int i20222 = i16 + 1;
                                                nestAdData.setAdLevelName(String.valueOf(i20222));
                                                nestAdData.setAdLevel(Integer.valueOf(i20222));
                                                nestAdData.setRequestId(requestId);
                                                nestAdData.setWhiteAd(i13);
                                                int i21222 = i12;
                                                nestAdData.setBlockAd(i21222);
                                                nestAdData.setHighPrioritySwitch(i11);
                                                nestAdData.setAdStrategyOptimizeSwitch(i10);
                                                nestAdData.setPrimeRitSwitch(i9);
                                                nestAdData.setShakeSwitch(i8);
                                                i4 = i7;
                                                nestAdData.setShakeSwitchLxad(i4);
                                                if (cachecfgModel != null) {
                                                }
                                            } else if (Intrinsics.areEqual(str12, dspName3)) {
                                                WifiNestAd wifiNestAd5 = WifiNestAd.INSTANCE;
                                                if (!wifiNestAd5.getKsInit()) {
                                                    if (WifiLog.isDebugMode) {
                                                        WifiLog.d("parserAllAds WifiNestAd.ksInit " + wifiNestAd5.getKsInit() + " not allow parser");
                                                    }
                                                }
                                                if (WifiLog.isDebugMode) {
                                                }
                                                nestAdData = new NestAdData();
                                                if (Intrinsics.areEqual(this.nestType, WifiNestConst.NestTypeConst.NEST_FEED_AD)) {
                                                }
                                                jSONObject3 = jSONObject2;
                                                nestAdData.setInteractSettings(jSONObject3);
                                                nestAdData.setAdUnitId(this.adUnitId);
                                                nestAdData.setInventoryId(this.curInventoryId);
                                                nestAdData.setCreateRequestId(requestId);
                                                nestAdData.setUseRequestId(requestId);
                                                nestAdData.setAdParams(this.adCurParams);
                                                nestAdData.setStrategyId(spModel.getStrategy_id());
                                                nestAdData.setStrategyVer(spModel.getStrategy_ver());
                                                nestAdData.setStartegyTaiChi(spModel.getTaiChiId());
                                                nestAdData.setSourceId(spModel.getSourceId());
                                                nestAdData.setAdMode(6);
                                                nestAdData.setGroupId(sPGroupcfgModel.getGroupId());
                                                nestAdData.setAdSPStrategy(true);
                                                str4 = str10;
                                                nestAdData.setAdRealLevelName(Intrinsics.stringPlus(sPSlotcfgModel.getDspName(), Integer.valueOf(sPGroupcfgModel.getGroupId())));
                                                int i202222 = i16 + 1;
                                                nestAdData.setAdLevelName(String.valueOf(i202222));
                                                nestAdData.setAdLevel(Integer.valueOf(i202222));
                                                nestAdData.setRequestId(requestId);
                                                nestAdData.setWhiteAd(i13);
                                                int i212222 = i12;
                                                nestAdData.setBlockAd(i212222);
                                                nestAdData.setHighPrioritySwitch(i11);
                                                nestAdData.setAdStrategyOptimizeSwitch(i10);
                                                nestAdData.setPrimeRitSwitch(i9);
                                                nestAdData.setShakeSwitch(i8);
                                                i4 = i7;
                                                nestAdData.setShakeSwitchLxad(i4);
                                                if (cachecfgModel != null) {
                                                }
                                            } else if (Intrinsics.areEqual("H", dspName3)) {
                                                WifiNestAd wifiNestAd6 = WifiNestAd.INSTANCE;
                                                if (!wifiNestAd6.getHwInit()) {
                                                    if (WifiLog.isDebugMode) {
                                                        WifiLog.d("parserAllAds WifiNestAd.hwInit " + wifiNestAd6.getHwInit() + " not allow parser");
                                                    }
                                                }
                                                if (WifiLog.isDebugMode) {
                                                }
                                                nestAdData = new NestAdData();
                                                if (Intrinsics.areEqual(this.nestType, WifiNestConst.NestTypeConst.NEST_FEED_AD)) {
                                                }
                                                jSONObject3 = jSONObject2;
                                                nestAdData.setInteractSettings(jSONObject3);
                                                nestAdData.setAdUnitId(this.adUnitId);
                                                nestAdData.setInventoryId(this.curInventoryId);
                                                nestAdData.setCreateRequestId(requestId);
                                                nestAdData.setUseRequestId(requestId);
                                                nestAdData.setAdParams(this.adCurParams);
                                                nestAdData.setStrategyId(spModel.getStrategy_id());
                                                nestAdData.setStrategyVer(spModel.getStrategy_ver());
                                                nestAdData.setStartegyTaiChi(spModel.getTaiChiId());
                                                nestAdData.setSourceId(spModel.getSourceId());
                                                nestAdData.setAdMode(6);
                                                nestAdData.setGroupId(sPGroupcfgModel.getGroupId());
                                                nestAdData.setAdSPStrategy(true);
                                                str4 = str10;
                                                nestAdData.setAdRealLevelName(Intrinsics.stringPlus(sPSlotcfgModel.getDspName(), Integer.valueOf(sPGroupcfgModel.getGroupId())));
                                                int i2022222 = i16 + 1;
                                                nestAdData.setAdLevelName(String.valueOf(i2022222));
                                                nestAdData.setAdLevel(Integer.valueOf(i2022222));
                                                nestAdData.setRequestId(requestId);
                                                nestAdData.setWhiteAd(i13);
                                                int i2122222 = i12;
                                                nestAdData.setBlockAd(i2122222);
                                                nestAdData.setHighPrioritySwitch(i11);
                                                nestAdData.setAdStrategyOptimizeSwitch(i10);
                                                nestAdData.setPrimeRitSwitch(i9);
                                                nestAdData.setShakeSwitch(i8);
                                                i4 = i7;
                                                nestAdData.setShakeSwitchLxad(i4);
                                                if (cachecfgModel != null) {
                                                }
                                            } else if (Intrinsics.areEqual(ExifInterface.LONGITUDE_EAST, dspName3)) {
                                                WifiNestAd wifiNestAd7 = WifiNestAd.INSTANCE;
                                                if (!wifiNestAd7.getBeiziInit()) {
                                                    if (WifiLog.isDebugMode) {
                                                        WifiLog.d("parserAllAds WifiNestAd.beiziInit " + wifiNestAd7.getBeiziInit() + " not allow parser");
                                                    }
                                                }
                                                if (WifiLog.isDebugMode) {
                                                }
                                                nestAdData = new NestAdData();
                                                if (Intrinsics.areEqual(this.nestType, WifiNestConst.NestTypeConst.NEST_FEED_AD)) {
                                                }
                                                jSONObject3 = jSONObject2;
                                                nestAdData.setInteractSettings(jSONObject3);
                                                nestAdData.setAdUnitId(this.adUnitId);
                                                nestAdData.setInventoryId(this.curInventoryId);
                                                nestAdData.setCreateRequestId(requestId);
                                                nestAdData.setUseRequestId(requestId);
                                                nestAdData.setAdParams(this.adCurParams);
                                                nestAdData.setStrategyId(spModel.getStrategy_id());
                                                nestAdData.setStrategyVer(spModel.getStrategy_ver());
                                                nestAdData.setStartegyTaiChi(spModel.getTaiChiId());
                                                nestAdData.setSourceId(spModel.getSourceId());
                                                nestAdData.setAdMode(6);
                                                nestAdData.setGroupId(sPGroupcfgModel.getGroupId());
                                                nestAdData.setAdSPStrategy(true);
                                                str4 = str10;
                                                nestAdData.setAdRealLevelName(Intrinsics.stringPlus(sPSlotcfgModel.getDspName(), Integer.valueOf(sPGroupcfgModel.getGroupId())));
                                                int i20222222 = i16 + 1;
                                                nestAdData.setAdLevelName(String.valueOf(i20222222));
                                                nestAdData.setAdLevel(Integer.valueOf(i20222222));
                                                nestAdData.setRequestId(requestId);
                                                nestAdData.setWhiteAd(i13);
                                                int i21222222 = i12;
                                                nestAdData.setBlockAd(i21222222);
                                                nestAdData.setHighPrioritySwitch(i11);
                                                nestAdData.setAdStrategyOptimizeSwitch(i10);
                                                nestAdData.setPrimeRitSwitch(i9);
                                                nestAdData.setShakeSwitch(i8);
                                                i4 = i7;
                                                nestAdData.setShakeSwitchLxad(i4);
                                                if (cachecfgModel != null) {
                                                }
                                            } else if (Intrinsics.areEqual(str10, dspName3)) {
                                                WifiNestAd wifiNestAd8 = WifiNestAd.INSTANCE;
                                                if (!wifiNestAd8.getQumengInit()) {
                                                    if (WifiLog.isDebugMode) {
                                                        WifiLog.d("parserAllAds WifiNestAd.qumengInit " + wifiNestAd8.getQumengInit() + " not allow parser");
                                                    }
                                                }
                                                if (WifiLog.isDebugMode) {
                                                }
                                                nestAdData = new NestAdData();
                                                if (Intrinsics.areEqual(this.nestType, WifiNestConst.NestTypeConst.NEST_FEED_AD)) {
                                                }
                                                jSONObject3 = jSONObject2;
                                                nestAdData.setInteractSettings(jSONObject3);
                                                nestAdData.setAdUnitId(this.adUnitId);
                                                nestAdData.setInventoryId(this.curInventoryId);
                                                nestAdData.setCreateRequestId(requestId);
                                                nestAdData.setUseRequestId(requestId);
                                                nestAdData.setAdParams(this.adCurParams);
                                                nestAdData.setStrategyId(spModel.getStrategy_id());
                                                nestAdData.setStrategyVer(spModel.getStrategy_ver());
                                                nestAdData.setStartegyTaiChi(spModel.getTaiChiId());
                                                nestAdData.setSourceId(spModel.getSourceId());
                                                nestAdData.setAdMode(6);
                                                nestAdData.setGroupId(sPGroupcfgModel.getGroupId());
                                                nestAdData.setAdSPStrategy(true);
                                                str4 = str10;
                                                nestAdData.setAdRealLevelName(Intrinsics.stringPlus(sPSlotcfgModel.getDspName(), Integer.valueOf(sPGroupcfgModel.getGroupId())));
                                                int i202222222 = i16 + 1;
                                                nestAdData.setAdLevelName(String.valueOf(i202222222));
                                                nestAdData.setAdLevel(Integer.valueOf(i202222222));
                                                nestAdData.setRequestId(requestId);
                                                nestAdData.setWhiteAd(i13);
                                                int i212222222 = i12;
                                                nestAdData.setBlockAd(i212222222);
                                                nestAdData.setHighPrioritySwitch(i11);
                                                nestAdData.setAdStrategyOptimizeSwitch(i10);
                                                nestAdData.setPrimeRitSwitch(i9);
                                                nestAdData.setShakeSwitch(i8);
                                                i4 = i7;
                                                nestAdData.setShakeSwitchLxad(i4);
                                                if (cachecfgModel != null) {
                                                }
                                            } else if (Intrinsics.areEqual("F", dspName3)) {
                                                WifiNestAd wifiNestAd9 = WifiNestAd.INSTANCE;
                                                if (!wifiNestAd9.getFeisuoInit()) {
                                                    if (WifiLog.isDebugMode) {
                                                        WifiLog.d("parserAllAds WifiNestAd.feisuoInit " + wifiNestAd9.getFeisuoInit() + " not allow parser");
                                                    }
                                                }
                                                if (WifiLog.isDebugMode) {
                                                }
                                                nestAdData = new NestAdData();
                                                if (Intrinsics.areEqual(this.nestType, WifiNestConst.NestTypeConst.NEST_FEED_AD)) {
                                                }
                                                jSONObject3 = jSONObject2;
                                                nestAdData.setInteractSettings(jSONObject3);
                                                nestAdData.setAdUnitId(this.adUnitId);
                                                nestAdData.setInventoryId(this.curInventoryId);
                                                nestAdData.setCreateRequestId(requestId);
                                                nestAdData.setUseRequestId(requestId);
                                                nestAdData.setAdParams(this.adCurParams);
                                                nestAdData.setStrategyId(spModel.getStrategy_id());
                                                nestAdData.setStrategyVer(spModel.getStrategy_ver());
                                                nestAdData.setStartegyTaiChi(spModel.getTaiChiId());
                                                nestAdData.setSourceId(spModel.getSourceId());
                                                nestAdData.setAdMode(6);
                                                nestAdData.setGroupId(sPGroupcfgModel.getGroupId());
                                                nestAdData.setAdSPStrategy(true);
                                                str4 = str10;
                                                nestAdData.setAdRealLevelName(Intrinsics.stringPlus(sPSlotcfgModel.getDspName(), Integer.valueOf(sPGroupcfgModel.getGroupId())));
                                                int i2022222222 = i16 + 1;
                                                nestAdData.setAdLevelName(String.valueOf(i2022222222));
                                                nestAdData.setAdLevel(Integer.valueOf(i2022222222));
                                                nestAdData.setRequestId(requestId);
                                                nestAdData.setWhiteAd(i13);
                                                int i2122222222 = i12;
                                                nestAdData.setBlockAd(i2122222222);
                                                nestAdData.setHighPrioritySwitch(i11);
                                                nestAdData.setAdStrategyOptimizeSwitch(i10);
                                                nestAdData.setPrimeRitSwitch(i9);
                                                nestAdData.setShakeSwitch(i8);
                                                i4 = i7;
                                                nestAdData.setShakeSwitchLxad(i4);
                                                if (cachecfgModel != null) {
                                                }
                                            } else if (Intrinsics.areEqual("L", dspName3)) {
                                                WifiNestAd wifiNestAd10 = WifiNestAd.INSTANCE;
                                                if (!wifiNestAd10.getLxAdInit()) {
                                                    if (WifiLog.isDebugMode) {
                                                        WifiLog.d("parserAllAds WifiNestAd.lxAdInit " + wifiNestAd10.getLxAdInit() + " not allow parser");
                                                    }
                                                }
                                                if (WifiLog.isDebugMode) {
                                                }
                                                nestAdData = new NestAdData();
                                                if (Intrinsics.areEqual(this.nestType, WifiNestConst.NestTypeConst.NEST_FEED_AD)) {
                                                }
                                                jSONObject3 = jSONObject2;
                                                nestAdData.setInteractSettings(jSONObject3);
                                                nestAdData.setAdUnitId(this.adUnitId);
                                                nestAdData.setInventoryId(this.curInventoryId);
                                                nestAdData.setCreateRequestId(requestId);
                                                nestAdData.setUseRequestId(requestId);
                                                nestAdData.setAdParams(this.adCurParams);
                                                nestAdData.setStrategyId(spModel.getStrategy_id());
                                                nestAdData.setStrategyVer(spModel.getStrategy_ver());
                                                nestAdData.setStartegyTaiChi(spModel.getTaiChiId());
                                                nestAdData.setSourceId(spModel.getSourceId());
                                                nestAdData.setAdMode(6);
                                                nestAdData.setGroupId(sPGroupcfgModel.getGroupId());
                                                nestAdData.setAdSPStrategy(true);
                                                str4 = str10;
                                                nestAdData.setAdRealLevelName(Intrinsics.stringPlus(sPSlotcfgModel.getDspName(), Integer.valueOf(sPGroupcfgModel.getGroupId())));
                                                int i20222222222 = i16 + 1;
                                                nestAdData.setAdLevelName(String.valueOf(i20222222222));
                                                nestAdData.setAdLevel(Integer.valueOf(i20222222222));
                                                nestAdData.setRequestId(requestId);
                                                nestAdData.setWhiteAd(i13);
                                                int i21222222222 = i12;
                                                nestAdData.setBlockAd(i21222222222);
                                                nestAdData.setHighPrioritySwitch(i11);
                                                nestAdData.setAdStrategyOptimizeSwitch(i10);
                                                nestAdData.setPrimeRitSwitch(i9);
                                                nestAdData.setShakeSwitch(i8);
                                                i4 = i7;
                                                nestAdData.setShakeSwitchLxad(i4);
                                                if (cachecfgModel != null) {
                                                }
                                            } else {
                                                str4 = str10;
                                                i2 = i6;
                                                i3 = i12;
                                                jSONObject3 = jSONObject2;
                                                sPSdkcfgModel10 = sPSdkcfgModel;
                                                str5 = str15;
                                                str6 = str13;
                                                sPSdkcfgModel11 = sPSdkcfgModel22;
                                                arrayList = arrayList3;
                                                if (WifiLog.isDebugMode) {
                                                    str7 = str12;
                                                    StringBuilder sb3 = new StringBuilder();
                                                    str8 = str11;
                                                    sb3.append("parserAllAds not find  dspName ");
                                                    sb3.append(dspName3);
                                                    sb3.append(" not allow parser");
                                                    WifiLog.d(sb3.toString());
                                                }
                                            }
                                            str7 = str12;
                                            str8 = str11;
                                        }
                                        str4 = str10;
                                        i2 = i6;
                                        i3 = i12;
                                        jSONObject3 = jSONObject2;
                                        sPSdkcfgModel10 = sPSdkcfgModel;
                                        str5 = str15;
                                        str6 = str13;
                                        sPSdkcfgModel11 = sPSdkcfgModel22;
                                        arrayList = arrayList3;
                                        str7 = str12;
                                        str8 = str11;
                                    }
                                    sPSdkcfgModel = sPSdkcfgModel10;
                                    str11 = str8;
                                    size3 = i19;
                                    slotcfgModels = list6;
                                    arrayList3 = arrayList;
                                    i6 = i2;
                                    str15 = str5;
                                    str14 = str3;
                                    i12 = i3;
                                    str10 = str4;
                                    JSONObject jSONObject5 = jSONObject3;
                                    i18 = i + 1;
                                    str12 = str7;
                                    sPSdkcfgModel22 = sPSdkcfgModel11;
                                    str13 = str6;
                                    jSONObject2 = jSONObject5;
                                }
                                str = str10;
                                str2 = str14;
                            } else {
                                str = str10;
                                str2 = str14;
                                sPGroupAdData = sPGroupAdData2;
                            }
                        }
                        int i22 = i12;
                        JSONObject jSONObject6 = jSONObject2;
                        this.allAdsAds.add(sPGroupAdData);
                        i16++;
                        sPSdkcfgModel = sPSdkcfgModel;
                        str12 = str12;
                        str11 = str11;
                        groupcfgModels = list4;
                        sPSdkcfgModel2 = sPSdkcfgModel23;
                        arrayList3 = arrayList3;
                        i6 = i6;
                        sPSdkcfgModel22 = sPSdkcfgModel22;
                        str15 = str15;
                        str13 = str13;
                        str14 = str2;
                        i12 = i22;
                        jSONObject2 = jSONObject6;
                        size2 = i17;
                        str10 = str;
                    }
                    if (WifiLog.isDebugMode) {
                        WifiLog.d(requestId + " scene:" + scene + " SPAD allAdCount共有 " + this.allAdCount + " 个广告");
                    }
                }
            }
        }
    }

    private final void resetAd() {
        this.allAdsAds.clear();
        this.allGroupNum = 0;
        this.isShow.compareAndSet(true, false);
        this.adSuccessEd.compareAndSet(true, false);
        this.adSuccess.compareAndSet(true, false);
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

    private final void setSdkCfg(NestAdData adData, SPSdkcfgModel sdkCfg, int defTimeOut, String sdkType) {
        adData.setAdType(sdkType);
        if (sdkCfg != null) {
            int timeOut = sdkCfg.getTimeOut();
            if (timeOut > 0 || defTimeOut <= 0) {
                defTimeOut = timeOut;
            }
            adData.setTimeOut(defTimeOut);
            adData.setCacheSec(sdkCfg.getCaschSes());
            adData.setDspId(sdkCfg.getDspId());
        }
    }

    private final void setWhiteFilterOn(NestAdData successData) {
        if (this.whiteFilterOn.get()) {
            if (successData.getWhiteAd() == 1) {
                this.whiteFilterOn.set(true);
            } else {
                this.whiteFilterOn.set(false);
            }
        }
    }

    private final void updateFilterOn(NestAdData adData) {
        setFilterOn(adData);
        setWhiteFilterOn(adData);
        String requestId = adData != null ? adData.getRequestId() : null;
        if (WifiLog.isDebugMode) {
            WifiLog.d(requestId + " SPAD  white&black 黑名单是否开启 " + this.filterOn + " 白名单是否开启 " + this.whiteFilterOn);
        }
    }

    public final void findCacheMaxAd(String requestId, String strategyId, int adScene, boolean timeOut, boolean finishRequest) {
        NestAdData nestAdDataFindAndDispatchCacheAdNew = null;
        if (!this.adLoadListenerEd.get()) {
            nestAdDataFindAndDispatchCacheAdNew = SPCacheManager.INSTANCE.findAndDispatchCacheAdNew(strategyId, null, requestId, null);
            if (WifiLog.isDebugMode) {
                WifiLog.d(requestId + " scene:" + adScene + " SPAD findCacheMaxAd，adLoadListenerEd:" + this.adLoadListenerEd.get() + ", timeOut:" + timeOut + " finishRequest:" + finishRequest + " curAdData:" + nestAdDataFindAndDispatchCacheAdNew);
            }
        }
        if (nestAdDataFindAndDispatchCacheAdNew != null) {
            loadSuccess(requestId, adScene, nestAdDataFindAndDispatchCacheAdNew, false);
        } else if (timeOut) {
            loadAdFailed(requestId, adScene, "30601", "并行请求超时");
        } else if (finishRequest) {
            loadAdFailed(requestId, adScene, "50007", "请求全部结束，没有广告");
        }
    }

    public final int getAdLoadSeq() {
        return this.adLoadSeq;
    }

    /* JADX INFO: renamed from: getCurCsjMaxEcpm, reason: from getter */
    public final String getCurCjsMaxEcpm() {
        return this.curCjsMaxEcpm;
    }

    public final SPModel getSdkConfig() {
        return this.sdkConfig;
    }

    public final boolean isAnswerHighPriceOpen() {
        SPSwitchModel switchModel;
        SPModel sPModel = this.sdkConfig;
        if (sPModel == null) {
            return false;
        }
        Integer numValueOf = null;
        if ((sPModel != null ? sPModel.getSwitchModel() : null) == null) {
            return false;
        }
        SPModel sPModel2 = this.sdkConfig;
        if (sPModel2 != null && (switchModel = sPModel2.getSwitchModel()) != null) {
            numValueOf = Integer.valueOf(switchModel.getAdStrategyOptimizeSwitch());
        }
        return numValueOf != null && numValueOf.intValue() == 1;
    }

    public final boolean isAnswerHighPriceOpenOld() {
        SPSwitchModel switchModel;
        SPModel sPModel = this.sdkConfig;
        if (sPModel == null) {
            return false;
        }
        Integer numValueOf = null;
        if ((sPModel != null ? sPModel.getSwitchModel() : null) == null) {
            return false;
        }
        SPModel sPModel2 = this.sdkConfig;
        if (sPModel2 != null && (switchModel = sPModel2.getSwitchModel()) != null) {
            numValueOf = Integer.valueOf(switchModel.getAdHighPrioritySwitch());
        }
        return numValueOf != null && numValueOf.intValue() == 1;
    }

    public final boolean isAnswerMaxPriceSwitch() {
        SPSwitchModel switchModel;
        SPModel sPModel = this.sdkConfig;
        if (sPModel == null) {
            return false;
        }
        Integer numValueOf = null;
        if ((sPModel != null ? sPModel.getSwitchModel() : null) == null) {
            return false;
        }
        SPModel sPModel2 = this.sdkConfig;
        if (sPModel2 != null && (switchModel = sPModel2.getSwitchModel()) != null) {
            numValueOf = Integer.valueOf(switchModel.getAdMaxPriceSwitch());
        }
        WifiLog.d("adMaxPriceSwitch is " + numValueOf);
        return numValueOf != null && numValueOf.intValue() == 1;
    }

    @Override // com.wifi.ad.core.strategy.AbsStrategy
    public void loadAd(ActivityPacker packer, final AdParams adParams, LoadScene scene) {
        final String str;
        String str2;
        String parError;
        String str3;
        try {
            this.mPacker = packer;
            this.nestType = adParams.getNestType();
            this.renderStyle = adParams.getRenderStyle();
            Map<String, String> ext = adParams.getExt();
            if (ext != null) {
                String strValueOf = String.valueOf(ext.get("requestId"));
                String strValueOf2 = String.valueOf(ext.get("advanceRequest"));
                if (ext.containsKey(EventParams.KEY_INVENTORYID) && (str3 = ext.get(EventParams.KEY_INVENTORYID)) != null) {
                    this.curInventoryId = str3;
                }
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
                    String adUnitId3 = adParams.getAdUnitId();
                    if (adUnitId3 == null) {
                        Intrinsics.throwNpe();
                    }
                    this.adUnitId = adUnitId3;
                }
                SPModel sPModel = this.sdkConfig;
                if (sPModel != null) {
                    if (sPModel == null) {
                        Intrinsics.throwNpe();
                    }
                    if (!TextUtils.isEmpty(sPModel.getTaiChiId())) {
                        SPModel sPModel2 = this.sdkConfig;
                        if (sPModel2 == null) {
                            Intrinsics.throwNpe();
                        }
                        String taiChiId = sPModel2.getTaiChiId();
                        if (taiChiId == null) {
                            Intrinsics.throwNpe();
                        }
                        ext.put(EventParams.KEY_TYPE_STATUS, taiChiId);
                    }
                    SPModel sPModel3 = this.sdkConfig;
                    if (sPModel3 == null) {
                        Intrinsics.throwNpe();
                    }
                    if (!TextUtils.isEmpty(sPModel3.getStrategy_ver())) {
                        SPModel sPModel4 = this.sdkConfig;
                        if (sPModel4 == null) {
                            Intrinsics.throwNpe();
                        }
                        String strategy_ver = sPModel4.getStrategy_ver();
                        if (strategy_ver == null) {
                            Intrinsics.throwNpe();
                        }
                        ext.put(EventParams.KEY_STRATEGY_VER, strategy_ver);
                    }
                }
                ext.put("cfgfrom", "new_sdk_config");
                Unit unit = Unit.INSTANCE;
                str = strValueOf;
                str2 = strValueOf2;
            } else {
                str = "";
                str2 = str;
            }
            WifiNestAd wifiNestAd = WifiNestAd.INSTANCE;
            if (wifiNestAd.getMAdRequestCallBack() != null) {
                AdRequestCallBack mAdRequestCallBack = wifiNestAd.getMAdRequestCallBack();
                if (mAdRequestCallBack == null) {
                    Intrinsics.throwNpe();
                }
                mAdRequestCallBack.onAdRequest();
            }
            final Ref.IntRef intRef = new Ref.IntRef();
            int scene2 = adParams.getScene();
            intRef.element = scene2;
            this.curAdScene = scene2;
            sceneRequestId.put(Integer.valueOf(scene2), str);
            WifiLog.d("sceneRequestId save curAdScene:" + this.curAdScene + " requestId " + str + ' ');
            if (WifiLog.isDebugMode) {
                WifiLog.d(str + " scene:" + intRef.element + " SPAD SPStrategyManager loadAd ");
            }
            SPModel sPModel5 = this.sdkConfig;
            if (sPModel5 == null) {
                parError = "Sp is error";
            } else {
                if (sPModel5 == null) {
                    Intrinsics.throwNpe();
                }
                parError = sPModel5.getParError();
            }
            if (WifiLog.isDebugMode) {
                WifiLog.d(str + " scene:" + intRef.element + " SPAD SPStrategyManager errorMsg " + parError);
            }
            if (!(parError == null || parError.length() == 0)) {
                callbackAdFailed("50004", "sdk策略数据为空");
                return;
            }
            SPModel sPModel6 = this.sdkConfig;
            if (sPModel6 != null) {
                if (sPModel6 == null) {
                    Intrinsics.throwNpe();
                }
                if (sPModel6.getStrategy_id() != null) {
                    SPModel sPModel7 = this.sdkConfig;
                    if (sPModel7 == null) {
                        Intrinsics.throwNpe();
                    }
                    if (sPModel7.getAllowRequestAd() == 0) {
                        if (WifiLog.isDebugMode) {
                            WifiLog.d(str + " scene:" + intRef.element + " SPAD MDA 请求广告开关为关不允许请求广告 nest_sdk_ad_no_req_ad");
                        }
                        AbstractReporter reporter = wifiNestAd.getReporter();
                        EventParams.Builder builder = new EventParams.Builder();
                        SPModel sPModel8 = this.sdkConfig;
                        if (sPModel8 == null) {
                            Intrinsics.throwNpe();
                        }
                        EventParams.Builder strategyId = builder.setStrategyId(sPModel8.getStrategy_id());
                        SPModel sPModel9 = this.sdkConfig;
                        if (sPModel9 == null) {
                            Intrinsics.throwNpe();
                        }
                        EventParams.Builder nestType = strategyId.setAbTypeStatus(sPModel9.getTaiChiId()).setNestType(adParams.getNestType());
                        SPModel sPModel10 = this.sdkConfig;
                        if (sPModel10 == null) {
                            Intrinsics.throwNpe();
                        }
                        SPCachecfgModel cachecfgModel = sPModel10.getCachecfgModel();
                        if (cachecfgModel == null) {
                            Intrinsics.throwNpe();
                        }
                        EventParams eventParamsBuild = nestType.setCacheSize(cachecfgModel.getCount()).build();
                        Intrinsics.checkExpressionValueIsNotNull(eventParamsBuild, "EventParams.Builder()\n  …                 .build()");
                        reporter.onEvent(WifiNestConst.EventKey.NEST_AD_PARSE_REQUEST_FAIL, eventParamsBuild, adParams.getExt());
                        callbackAdFailed("50005", "sdk配置不允许请求广告");
                        return;
                    }
                    adParams.setAdModel$core_release(6);
                    this.adCurParams = adParams;
                    this.curScene = scene;
                    SPModel sPModel11 = this.sdkConfig;
                    if (sPModel11 == null) {
                        Intrinsics.throwNpe();
                    }
                    if (sPModel11.getStrategy_id() != null) {
                        HashMap<String, Integer> mdaLodSp = SPMdaLogUtil.INSTANCE.getMdaLodSp();
                        SPModel sPModel12 = this.sdkConfig;
                        if (sPModel12 == null) {
                            Intrinsics.throwNpe();
                        }
                        String strategy_id = sPModel12.getStrategy_id();
                        if (strategy_id == null) {
                            Intrinsics.throwNpe();
                        }
                        SPModel sPModel13 = this.sdkConfig;
                        if (sPModel13 == null) {
                            Intrinsics.throwNpe();
                        }
                        mdaLodSp.put(strategy_id, Integer.valueOf(sPModel13.getMdaLogType()));
                        AdParams adParams2 = this.adCurParams;
                        if (adParams2 == null) {
                            Intrinsics.throwNpe();
                        }
                        Map<String, String> ext2 = adParams2.getExt();
                        if (ext2 == null) {
                            Intrinsics.throwNpe();
                        }
                        SPModel sPModel14 = this.sdkConfig;
                        if (sPModel14 == null) {
                            Intrinsics.throwNpe();
                        }
                        String strategy_id2 = sPModel14.getStrategy_id();
                        if (strategy_id2 == null) {
                            Intrinsics.throwNpe();
                        }
                        ext2.put("strategyId", strategy_id2);
                    }
                    SPModel sPModel15 = this.sdkConfig;
                    if (sPModel15 == null) {
                        Intrinsics.throwNpe();
                    }
                    if (sPModel15.getExPids() != null) {
                        AdParams adParams3 = this.adCurParams;
                        if (adParams3 == null) {
                            Intrinsics.throwNpe();
                        }
                        Map<String, String> ext3 = adParams3.getExt();
                        if (ext3 == null) {
                            Intrinsics.throwNpe();
                        }
                        SPModel sPModel16 = this.sdkConfig;
                        if (sPModel16 == null) {
                            Intrinsics.throwNpe();
                        }
                        String exPids = sPModel16.getExPids();
                        if (exPids == null) {
                            Intrinsics.throwNpe();
                        }
                        ext3.put("exPids", exPids);
                        if (WifiLog.isDebugMode) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(str);
                            sb.append(" scene:");
                            sb.append(intRef.element);
                            sb.append(" SPAD SPStrategyManager sdkConfig.exPids ");
                            SPModel sPModel17 = this.sdkConfig;
                            if (sPModel17 == null) {
                                Intrinsics.throwNpe();
                            }
                            sb.append(sPModel17.getExPids());
                            sb.append(' ');
                            WifiLog.d(sb.toString());
                        }
                    }
                    WkWXExtEvent wkWXExtEvent = WkWXExtEvent.INSTANCE;
                    SPModel sPModel18 = this.sdkConfig;
                    if (sPModel18 == null) {
                        Intrinsics.throwNpe();
                    }
                    String sourceId = sPModel18.getSourceId();
                    if (sourceId == null) {
                        Intrinsics.throwNpe();
                    }
                    int adModel = adParams.getAdModel();
                    ActivityPacker activityPacker = this.mPacker;
                    Context appContext = activityPacker != null ? activityPacker.getAppContext() : null;
                    if (appContext == null) {
                        Intrinsics.throwNpe();
                    }
                    String strCreateWxEventMap = wkWXExtEvent.createWxEventMap(sourceId, adModel, adParams, str, appContext);
                    if (ext != null) {
                        ext.put(EventParams.KEY_WXEVENTEXT, strCreateWxEventMap);
                        Unit unit2 = Unit.INSTANCE;
                    }
                    Context appContext2 = packer.getAppContext();
                    Intrinsics.checkExpressionValueIsNotNull(appContext2, "packer.appContext");
                    requestConfig(appContext2, adParams.getAppId());
                    this.filterConfig = WkAdConfigManager.getLocalFilterConfig(packer.getAppContext(), adParams.getAppId());
                    this.whiteFilterConfig = WkWhiteAdConfigManager.getLocalFilterConfig(packer.getAppContext());
                    StrategyManager strategyManager = StrategyManager.INSTANCE;
                    String taichikeys = strategyManager.getTaichikeys();
                    strategyManager.setFilterData(this.filterOn, taichikeys, this.filterConfig);
                    strategyManager.setWhiteFilterData(this.whiteFilterOn, taichikeys, this.whiteFilterConfig);
                    this.costTime = 0L;
                    adParams.setTotalTimeout$core_release(4000L);
                    SPModel sPModel19 = this.sdkConfig;
                    if (sPModel19 == null) {
                        Intrinsics.throwNpe();
                    }
                    if (sPModel19.getAllTimeOut() > 0) {
                        if (this.sdkConfig == null) {
                            Intrinsics.throwNpe();
                        }
                        adParams.setTotalTimeout$core_release(r1.getAllTimeOut());
                    }
                    BaseListener listener = getListener();
                    if (listener != null) {
                        listener.onStart();
                        Unit unit3 = Unit.INSTANCE;
                    }
                    if (WifiLog.isDebugMode) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str);
                        sb2.append(" scene:");
                        sb2.append(intRef.element);
                        sb2.append(" SPAD SPStrategyManager sdkConfig.strategy_id ");
                        SPModel sPModel20 = this.sdkConfig;
                        if (sPModel20 == null) {
                            Intrinsics.throwNpe();
                        }
                        sb2.append(sPModel20.getStrategy_id());
                        sb2.append("  taiChiKey ");
                        sb2.append(taichikeys);
                        sb2.append("  whiteFilterOn ");
                        sb2.append(this.whiteFilterOn);
                        sb2.append("  filterOn ");
                        sb2.append(this.filterOn);
                        sb2.append(" MDA 开始检查缓存广告 nest_sdk_ad_check_cache");
                        WifiLog.d(sb2.toString());
                    }
                    AbstractReporter reporter2 = wifiNestAd.getReporter();
                    EventParams.Builder builder2 = new EventParams.Builder();
                    SPModel sPModel21 = this.sdkConfig;
                    if (sPModel21 == null) {
                        Intrinsics.throwNpe();
                    }
                    EventParams.Builder strategyId2 = builder2.setStrategyId(sPModel21.getStrategy_id());
                    SPModel sPModel22 = this.sdkConfig;
                    if (sPModel22 == null) {
                        Intrinsics.throwNpe();
                    }
                    EventParams.Builder strategyVer = strategyId2.setStrategyVer(sPModel22.getStrategy_ver());
                    SPModel sPModel23 = this.sdkConfig;
                    if (sPModel23 == null) {
                        Intrinsics.throwNpe();
                    }
                    EventParams.Builder abTypeStatus = strategyVer.setAbTypeStatus(sPModel23.getTaiChiId());
                    SPModel sPModel24 = this.sdkConfig;
                    if (sPModel24 == null) {
                        Intrinsics.throwNpe();
                    }
                    SPCachecfgModel cachecfgModel2 = sPModel24.getCachecfgModel();
                    if (cachecfgModel2 == null) {
                        Intrinsics.throwNpe();
                    }
                    EventParams.Builder cacheSize = abTypeStatus.setCacheSize(cachecfgModel2.getCount());
                    SPCacheManager sPCacheManager = SPCacheManager.INSTANCE;
                    SPModel sPModel25 = this.sdkConfig;
                    if (sPModel25 == null) {
                        Intrinsics.throwNpe();
                    }
                    String strategy_id3 = sPModel25.getStrategy_id();
                    if (strategy_id3 == null) {
                        Intrinsics.throwNpe();
                    }
                    EventParams.Builder cacheAllNum = cacheSize.setCacheAllNum(sPCacheManager.findAllCacheAdSie(strategy_id3));
                    SPModel sPModel26 = this.sdkConfig;
                    if (sPModel26 == null) {
                        Intrinsics.throwNpe();
                    }
                    String strategy_id4 = sPModel26.getStrategy_id();
                    if (strategy_id4 == null) {
                        Intrinsics.throwNpe();
                    }
                    EventParams eventParamsBuild2 = cacheAllNum.setCacheExt(sPCacheManager.createAllAdJson(strategy_id4, str, intRef.element)).build();
                    Intrinsics.checkExpressionValueIsNotNull(eventParamsBuild2, "EventParams.Builder()\n  …                 .build()");
                    reporter2.onEvent(WifiNestConst.EventKey.NEST_AD_CHECK_CACHE, eventParamsBuild2, adParams.getExt());
                    SPPriceEventManager sPPriceEventManager = SPPriceEventManager.INSTANCE;
                    SPModel sPModel27 = this.sdkConfig;
                    if (sPModel27 == null) {
                        Intrinsics.throwNpe();
                    }
                    sPPriceEventManager.changeAllCacheAdUseRequestId(sPModel27.getStrategy_id(), str);
                    int i = intRef.element;
                    SPModel sPModel28 = this.sdkConfig;
                    if (sPModel28 == null) {
                        Intrinsics.throwNpe();
                    }
                    sPPriceEventManager.eventRequestStartCache(str, i, sPPriceEventManager.findAllCacheAd(i, sPModel28.getStrategy_id()));
                    SPModel sPModel29 = this.sdkConfig;
                    if (sPModel29 == null) {
                        Intrinsics.throwNpe();
                    }
                    if (sPModel29.getStrategy_id() != null) {
                        SPCacheTimeModel sPCacheTimeModel = new SPCacheTimeModel();
                        if (WifiLog.isDebugMode) {
                            WifiLog.d(str + " scene:" + intRef.element + " SPAD MDA 完成缓存广告过期过滤 nest_sdk_ad_update_cache");
                        }
                        EventReporter eventReporter = EventReporter.INSTANCE;
                        SPModel sPModel30 = this.sdkConfig;
                        if (sPModel30 == null) {
                            Intrinsics.throwNpe();
                        }
                        eventReporter.reportUpdateCacheEvent(sPModel30, sPCacheTimeModel, adParams, str, intRef.element);
                        answerAdLoaded(sPCacheTimeModel, str, intRef.element, adParams);
                    }
                    parserAllAds(this.sdkConfig, str, intRef.element);
                    SPModel sPModel31 = this.sdkConfig;
                    if (sPModel31 == null) {
                        Intrinsics.throwNpe();
                    }
                    String strategy_id5 = sPModel31.getStrategy_id();
                    if (strategy_id5 == null) {
                        Intrinsics.throwNpe();
                    }
                    startRequestAd(1, strategy_id5, str, intRef.element, str2);
                    if (WifiLog.isDebugMode) {
                        WifiLog.d(str + " scene:" + intRef.element + " SPAD allTime adParams.totalTimeout " + adParams.getTotalTimeout());
                    }
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.wifi.ad.core.spstrategy.SPStrategyManager.loadAd.3
                        @Override // java.lang.Runnable
                        public final void run() {
                            SPStrategyManager sPStrategyManager = SPStrategyManager.this;
                            Map<String, String> ext4 = adParams.getExt();
                            String str4 = str;
                            SPModel sdkConfig = SPStrategyManager.this.getSdkConfig();
                            if (sdkConfig == null) {
                                Intrinsics.throwNpe();
                            }
                            String strategy_id6 = sdkConfig.getStrategy_id();
                            if (strategy_id6 == null) {
                                Intrinsics.throwNpe();
                            }
                            sPStrategyManager.checkAdLoadTimeOut(ext4, str4, strategy_id6, intRef.element);
                        }
                    }, adParams.getTotalTimeout());
                    if (wifiNestAd.getSwitch77583()) {
                        sPCacheManager.getAllSpSM().put(Integer.valueOf(this.curAdScene), this);
                        return;
                    }
                    return;
                }
            }
            if (WifiLog.isDebugMode) {
                WifiLog.d(str + " scene:" + intRef.element + " SPAD 策略id为空");
            }
            callbackAdFailed("50008", "策略id为空");
        } catch (Exception e) {
            callbackAdFailed("50104", "loadException:" + e);
        }
    }

    @Override // com.wifi.ad.core.strategy.AbsStrategy, com.wifi.ad.core.strategy.IStrategyListener
    public void onAdExpose(NestAdData nestAdData, String providerType) {
        super.onAdExpose(nestAdData, providerType);
        SpMaterialFilterUtil spMaterialFilterUtil = SpMaterialFilterUtil.INSTANCE;
        ActivityPacker activityPacker = this.mPacker;
        spMaterialFilterUtil.saveMaterialFrequencyInfo(activityPacker != null ? activityPacker.getAppContext() : null, nestAdData);
        String requestId = nestAdData.getRequestId();
        if (WifiLog.isDebugMode) {
            WifiLog.d(requestId + " SPAD onAdExpose nestAdData code " + nestAdData.getAdCode());
        }
        if (WifiNestAd.INSTANCE.getSwitch58414() || nestAdData.getAdStrategyOptimizeSwitch() == 1) {
            return;
        }
        SPCacheManager.INSTANCE.removeShowAd(nestAdData);
    }

    @Override // com.wifi.ad.core.strategy.AbsStrategy, com.wifi.ad.core.strategy.IStrategyListener
    public void onAdFailed(NestAdData nestAdData, String failedMsg, int code) {
        boolean z;
        try {
            super.onAdFailed(nestAdData, failedMsg, code);
            this.allFailedCount++;
            String requestId = nestAdData.getRequestId();
            if (WifiLog.isDebugMode) {
                WifiLog.d(requestId + " scene:" + this.curAdScene + " SPAD onAdFailed allFailedCount " + this.allFailedCount);
            }
            if (this.allFailedCount == this.allAdCount) {
                if (WifiLog.isDebugMode) {
                    WifiLog.d(requestId + " scene:" + this.curAdScene + " SPAD MDA 所有广告都失败 nest_sdk_ad_noresp");
                }
                EventReporter eventReporter = EventReporter.INSTANCE;
                AdParams adParams = this.adCurParams;
                if (adParams == null) {
                    Intrinsics.throwNpe();
                }
                eventReporter.reportNoResp(adParams, null);
                z = true;
            } else {
                z = false;
            }
            if (this.curGroupLoadAdMg == null) {
                adFailedCache(nestAdData, requestId);
                return;
            }
            int curGroupNum = nestAdData.getCurGroupNum();
            SPOneGroupLoadAd sPOneGroupLoadAd = this.curGroupLoadAdMg;
            if (sPOneGroupLoadAd == null) {
                Intrinsics.throwNpe();
            }
            if (curGroupNum != sPOneGroupLoadAd.getCurGroupNum()) {
                adFailedCache(nestAdData, requestId);
                return;
            }
            SPOneGroupLoadAd sPOneGroupLoadAd2 = this.curGroupLoadAdMg;
            if (sPOneGroupLoadAd2 == null) {
                Intrinsics.throwNpe();
            }
            sPOneGroupLoadAd2.onAdFailed(nestAdData, failedMsg, code, this.curAdScene, z);
        } catch (Exception unused) {
        }
    }

    @Override // com.wifi.ad.core.strategy.AbsStrategy, com.wifi.ad.core.strategy.IStrategyListener
    public void onAdLoaded(List<NestAdData> adList) {
        super.onAdLoaded(adList);
        NestAdData nestAdData = adList.get(0);
        nestAdData.setLoadAdTime(System.currentTimeMillis() / ((long) 1000));
        String requestId = nestAdData.getRequestId();
        if (!getShowDataWithFilter(nestAdData)) {
            onAdFailed(nestAdData, "black or white not allow", 10001);
            if (WifiLog.isDebugMode) {
                WifiLog.d(requestId + " scene:" + this.curAdScene + " SPAD MDA " + nestAdData.getAdCode() + "黑白名单被过滤 scrn_filterend");
            }
            AbstractReporter reporter = WifiNestAd.INSTANCE.getReporter();
            EventParams eventParamsByAdData = EventParams.getEventParamsByAdData(nestAdData);
            Intrinsics.checkExpressionValueIsNotNull(eventParamsByAdData, "EventParams.getEventParamsByAdData(nestAdData)");
            AdParams adParams = nestAdData.getAdParams();
            if (adParams == null) {
                Intrinsics.throwNpe();
            }
            reporter.onEvent(WifiNestConst.EventKey.NEST_SDK_AD_BLACKLIST_WINNER, eventParamsByAdData, adParams.getExt());
            return;
        }
        SpMaterialFilterUtil spMaterialFilterUtil = SpMaterialFilterUtil.INSTANCE;
        ActivityPacker activityPacker = this.mPacker;
        if (!spMaterialFilterUtil.materialFilter(activityPacker != null ? activityPacker.getAppContext() : null, nestAdData)) {
            onAdFailed(nestAdData, "material control not allow", 10004);
            AbstractReporter reporter2 = WifiNestAd.INSTANCE.getReporter();
            EventParams eventParamsByAdData2 = EventParams.getEventParamsByAdData(nestAdData);
            Intrinsics.checkExpressionValueIsNotNull(eventParamsByAdData2, "EventParams.getEventParamsByAdData(nestAdData)");
            AdParams adParams2 = nestAdData.getAdParams();
            if (adParams2 == null) {
                Intrinsics.throwNpe();
            }
            reporter2.onEvent(WifiNestConst.EventKey.NEST_SDK_AD_MATERIAL_CONTROL, eventParamsByAdData2, adParams2.getExt());
            return;
        }
        nestAdData.setWinner(true);
        if (WifiLog.isDebugMode) {
            WifiLog.d(requestId + " scene:" + this.curAdScene + " SPAD onAdLoaded adLoadListenerEd:" + this.adLoadListenerEd.get());
        }
        WifiNestAd wifiNestAd = WifiNestAd.INSTANCE;
        if (!wifiNestAd.getSwitch58414() && !isAnswerHighPriceOpen()) {
            loadSuccess(requestId, this.curAdScene, nestAdData, true);
        }
        if (!this.adSuccessEd.get()) {
            this.adSuccessEd.set(true);
            EventReporter eventReporter = EventReporter.INSTANCE;
            AdParams adParams3 = this.adCurParams;
            if (adParams3 == null) {
                Intrinsics.throwNpe();
            }
            eventReporter.reportResp(adParams3);
        }
        if (this.curGroupLoadAdMg != null) {
            int curGroupNum = nestAdData.getCurGroupNum();
            SPOneGroupLoadAd sPOneGroupLoadAd = this.curGroupLoadAdMg;
            if (sPOneGroupLoadAd == null) {
                Intrinsics.throwNpe();
            }
            if (curGroupNum != sPOneGroupLoadAd.getCurGroupNum()) {
                adLoadCache(nestAdData, requestId);
            } else {
                SPOneGroupLoadAd sPOneGroupLoadAd2 = this.curGroupLoadAdMg;
                if (sPOneGroupLoadAd2 == null) {
                    Intrinsics.throwNpe();
                }
                sPOneGroupLoadAd2.onAdLoad(nestAdData, requestId, this.curAdScene);
            }
        } else {
            adLoadCache(nestAdData, requestId);
        }
        if (!wifiNestAd.getSwitch58414() || isAnswerHighPriceOpen()) {
            return;
        }
        loadSuccess(requestId, this.curAdScene, nestAdData, true);
    }

    public final void onDestroy() {
        if (WifiNestAd.INSTANCE.getSwitch77583()) {
            WifiLog.d("SPStrategyManager clearCacheAd onDestroy scene " + this.curAdScene);
            this.allAdsAds.clear();
            int size = this.allSuccessList.size();
            for (int i = 0; i < size; i++) {
                SPCacheManager.INSTANCE.destroyOneAd(this.allSuccessList.get(i));
            }
            this.allSuccessList.clear();
            int size2 = this.allFailList.size();
            for (int i2 = 0; i2 < size2; i2++) {
                SPCacheManager.INSTANCE.destroyOneAd(this.allFailList.get(i2));
            }
            this.allFailList.clear();
            SPOneGroupLoadAd sPOneGroupLoadAd = this.curGroupLoadAdMg;
            if (sPOneGroupLoadAd != null) {
                sPOneGroupLoadAd.onDestroy();
            }
            setInteractionListener(null);
            setDislikeListener(null);
            setDislikeListenerYWF(null);
            this.mPacker = null;
        }
    }

    public final void requestAdCountAdd() {
        this.allAdCount++;
        if (WifiLog.isDebugMode) {
            WifiLog.d("requestAdCountAdd allAdCount " + this.allAdCount + ' ');
        }
    }

    public final void setSdkConfig(SPModel sPModel) {
        this.sdkConfig = sPModel;
    }

    public final boolean startRequestAd(int curIndexNum, String strategyId, String requestId, int scene, String mAdvanceRequest) throws JSONException {
        if (WifiLog.isDebugMode) {
            WifiLog.d(requestId + " scene:" + scene + " SPAD startRequestAd curIndexNum " + curIndexNum + "  共有 " + this.allGroupNum + " 组");
        }
        if (curIndexNum <= this.allGroupNum) {
            this.curGroupLoadAdMg = new SPOneGroupLoadAd(this, curIndexNum, strategyId, this.allAdsAds, this.allFailList, this.allSuccessList, mAdvanceRequest);
            if (this.allAdsAds.size() < curIndexNum) {
                return false;
            }
            SPOneGroupLoadAd sPOneGroupLoadAd = this.curGroupLoadAdMg;
            if (sPOneGroupLoadAd == null) {
                Intrinsics.throwNpe();
            }
            int i = curIndexNum - 1;
            sPOneGroupLoadAd.requestGroupAds(this.allAdsAds.get(i).getAdDatas(), this.adCurParams, this.mPacker, requestId, scene, this.curScene, this, this.allAdsAds.get(i).getTimeOut(), this.allAdsAds.get(i).getMaxEcpm(), this.allAdsAds.get(i).getMinEcpm());
            return true;
        }
        if (WifiLog.isDebugMode) {
            WifiLog.d(requestId + " scene:" + scene + " SPAD startRequestAd 不允许请求广告 轮回请求结束 " + strategyId);
        }
        this.allAdsAds.clear();
        this.allSuccessList.clear();
        this.allFailList.clear();
        SPPriceEventManager sPPriceEventManager = SPPriceEventManager.INSTANCE;
        sPPriceEventManager.eventRequestEndCache(requestId, scene, sPPriceEventManager.findAllCacheAd(scene, strategyId));
        this.curGroupLoadAdMg = null;
        return false;
    }
}
