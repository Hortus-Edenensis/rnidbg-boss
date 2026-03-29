package com.wifi.ad.core.reporter;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.wifi.ad.core.SDKAlias;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.config.AdParams;
import com.wifi.ad.core.config.EventParams;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.p001const.WifiNestConst;
import com.wifi.ad.core.spstrategy.SPCacheManager;
import com.wifi.ad.core.spstrategy.SPCacheTimeModel;
import com.wifi.ad.core.spstrategy.SPCachecfgModel;
import com.wifi.ad.core.spstrategy.SPModel;
import com.wifi.ad.core.spstrategy.SPPriceEventManager;
import com.wifi.ad.core.spstrategy.SPStrategyManager;
import com.wifi.ad.core.utils.WifiLog;
import com.wifi.csj.ad.NestCsjProvider;
import com.wifi.ks.ad.NestKsProvider;
import com.wifi.self.ad.NestWifiProvider;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\bJ(\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\bJ\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u0016\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\nJ\u001e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\nJ\u000e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J.\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\nJ\u001e\u0010\"\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006#"}, d2 = {"Lcom/wifi/ad/core/reporter/EventReporter;", "", "()V", "reportDefaultViewEvent", "", "nestAdData", "Lcom/wifi/ad/core/data/NestAdData;", "eventKey", "", "errorCode", "", "(Lcom/wifi/ad/core/data/NestAdData;Ljava/lang/String;Ljava/lang/Integer;)V", "reportNoResp", "adParams", "Lcom/wifi/ad/core/config/AdParams;", "reportNoRespDi", "builder", "Lcom/wifi/ad/core/config/EventParams$Builder;", "errCode", MediationConstant.KEY_ERROR_MSG, "reportReq", "reportReqDi", "reportResp", "successList", "reportRespDi", EventParams.KEY_PARAM_NUMBER, "reportSdkLoad", "reportUpdateCacheEvent", "sdkConfig", "Lcom/wifi/ad/core/spstrategy/SPModel;", "timeMdaModel", "Lcom/wifi/ad/core/spstrategy/SPCacheTimeModel;", "requestId", "adScene", "reportViewEvent", "core_release"}, k = 1, mv = {1, 1, 16})
public final class EventReporter {
    public static final EventReporter INSTANCE = new EventReporter();

    private EventReporter() {
    }

    public final void reportDefaultViewEvent(NestAdData nestAdData, String eventKey, Integer errorCode) throws JSONException {
        String str;
        String nestType;
        List<String> imageList;
        List<String> imageList2 = nestAdData.getImageList();
        String str2 = (imageList2 == null || !(imageList2.isEmpty() ^ true) || (imageList = nestAdData.getImageList()) == null) ? null : imageList.get(0);
        SDKAlias sDKAlias = SDKAlias.CSJ;
        if (Intrinsics.areEqual(sDKAlias.getType(), nestAdData.getAdType())) {
            str = NestCsjProvider.SDK_FROM;
        } else {
            sDKAlias = SDKAlias.GDT;
            if (Intrinsics.areEqual(sDKAlias.getType(), nestAdData.getAdType())) {
                str = "guangdiantong";
            } else {
                sDKAlias = SDKAlias.KS;
                if (Intrinsics.areEqual(sDKAlias.getType(), nestAdData.getAdType())) {
                    str = NestKsProvider.SDK_FROM;
                } else {
                    sDKAlias = SDKAlias.WIFI;
                    if (Intrinsics.areEqual(sDKAlias.getType(), nestAdData.getAdType())) {
                        str = NestWifiProvider.SDK_FROM;
                    } else {
                        sDKAlias = SDKAlias.OPPO;
                        if (Intrinsics.areEqual(sDKAlias.getType(), nestAdData.getAdType())) {
                            str = "OPPO";
                        } else {
                            sDKAlias = SDKAlias.HUAWEI;
                            if (Intrinsics.areEqual(sDKAlias.getType(), nestAdData.getAdType())) {
                                str = "huawei";
                            } else {
                                sDKAlias = SDKAlias.BEIZI;
                                if (Intrinsics.areEqual(sDKAlias.getType(), nestAdData.getAdType())) {
                                    str = "beizi";
                                } else {
                                    sDKAlias = SDKAlias.FEISUO;
                                    if (Intrinsics.areEqual(sDKAlias.getType(), nestAdData.getAdType())) {
                                        str = "feisuo";
                                    } else {
                                        sDKAlias = SDKAlias.LXAD;
                                        if (Intrinsics.areEqual(sDKAlias.getType(), nestAdData.getAdType())) {
                                            str = "lxad";
                                        } else {
                                            sDKAlias = null;
                                            str = "";
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        EventParams.Builder srcId = new EventParams.Builder().setDspName(nestAdData.getDspName()).setNestSid(nestAdData.getNestSid()).setPosition(nestAdData.getPosition()).setTmAdBtnShow(nestAdData.getShowAdButtonTime()).setRedAdBtnShow(nestAdData.getChangeAdBtnColorTime()).setCtAdBtnShow(nestAdData.getShowAdCardTime()).setSdkFrom(str).setInventoryId(nestAdData.getInventoryId()).setRenderStyle(nestAdData.getRenderStyle()).setMediaId(sDKAlias != null ? WifiNestAd.INSTANCE.getAppIds().get(sDKAlias) : "").setSrcId(nestAdData.getAdCode());
        AdParams adParams = nestAdData.getAdParams();
        if (adParams == null || (nestType = adParams.getNestType()) == null) {
            nestType = "";
        }
        EventParams.Builder nestType2 = srcId.setNestType(nestType);
        Integer adMode = nestAdData.getAdMode();
        EventParams.Builder params = nestType2.setAdMode((adMode != null ? adMode : "").toString()).setAdTitle(nestAdData.getTitle()).setAdImage(str2).setAdDesc(nestAdData.getDescription());
        if (errorCode != null) {
            params.setErrorCode(String.valueOf(errorCode.intValue()));
        }
        Intrinsics.checkExpressionValueIsNotNull(params, "params");
        reportViewEvent(params, nestAdData, eventKey);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void reportNoResp(AdParams adParams, String errorCode) {
        String strValueOf;
        if (adParams.getExt() == null) {
            strValueOf = "";
        } else {
            Map<String, String> ext = adParams.getExt();
            if (ext == null) {
                Intrinsics.throwNpe();
            }
            if (ext.containsKey("requestId")) {
                Map<String, String> ext2 = adParams.getExt();
                if (ext2 == null) {
                    Intrinsics.throwNpe();
                }
                strValueOf = String.valueOf(ext2.get("requestId"));
            }
        }
        EventParams.Builder createRequestId = new EventParams.Builder().setRenderStyle(adParams.getRenderStyle()).setNestType(adParams.getNestType()).setUseRequestId(strValueOf).setCreateRequestId(strValueOf);
        if (!TextUtils.isEmpty(errorCode)) {
            createRequestId.setErrorCode(errorCode);
        }
        EventParams eventParams = createRequestId.build();
        AbstractReporter reporter = WifiNestAd.INSTANCE.getReporter();
        Intrinsics.checkExpressionValueIsNotNull(eventParams, "eventParams");
        reporter.onEvent(WifiNestConst.EventKey.NEST_SDK_AD_NORESP, eventParams, adParams.getExt());
    }

    public final void reportNoRespDi(NestAdData nestAdData, EventParams.Builder builder, String errCode, String errorMsg) {
        EventParams eventParams = EventParams.addFailedEventParams(builder, nestAdData, errCode.toString(), errorMsg);
        AbstractReporter reporter = WifiNestAd.INSTANCE.getReporter();
        Intrinsics.checkExpressionValueIsNotNull(eventParams, "eventParams");
        AdParams adParams = nestAdData.getAdParams();
        reporter.onEvent(WifiNestConst.EventKey.NEST_SDK_AD_NORESP_DI, eventParams, adParams != null ? adParams.getExt() : null);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void reportReq(AdParams adParams) {
        String strValueOf;
        if (adParams.getExt() == null) {
            strValueOf = "";
        } else {
            Map<String, String> ext = adParams.getExt();
            if (ext == null) {
                Intrinsics.throwNpe();
            }
            if (ext.containsKey("requestId")) {
                Map<String, String> ext2 = adParams.getExt();
                if (ext2 == null) {
                    Intrinsics.throwNpe();
                }
                strValueOf = String.valueOf(ext2.get("requestId"));
            }
        }
        EventParams eventParams = new EventParams.Builder().setNestType(adParams.getNestType()).setRenderStyle(adParams.getRenderStyle()).setUseRequestId(strValueOf).setCreateRequestId(strValueOf).build();
        AbstractReporter reporter = WifiNestAd.INSTANCE.getReporter();
        Intrinsics.checkExpressionValueIsNotNull(eventParams, "eventParams");
        reporter.onEvent(WifiNestConst.EventKey.NEST_SDK_AD_REQ, eventParams, adParams.getExt());
    }

    public final void reportReqDi(NestAdData nestAdData, EventParams.Builder builder) {
        EventParams eventParams = EventParams.addEventParamsByAdData(builder, nestAdData);
        AbstractReporter reporter = WifiNestAd.INSTANCE.getReporter();
        Intrinsics.checkExpressionValueIsNotNull(eventParams, "eventParams");
        AdParams adParams = nestAdData.getAdParams();
        reporter.onEvent(WifiNestConst.EventKey.NEST_SDK_AD_REQ_DI, eventParams, adParams != null ? adParams.getExt() : null);
    }

    public final void reportResp(AdParams adParams) {
        reportResp(adParams, -1);
    }

    public final void reportRespDi(NestAdData nestAdData, EventParams.Builder builder, int number) {
        EventParams.Builder number2 = builder.setNumber(String.valueOf(number));
        Integer adLevel = nestAdData.getAdLevel();
        if (adLevel == null) {
            Intrinsics.throwNpe();
        }
        number2.setAdLevel(adLevel.intValue());
        EventParams eventParams = EventParams.addEventParamsByAdData(builder, nestAdData);
        AbstractReporter reporter = WifiNestAd.INSTANCE.getReporter();
        Intrinsics.checkExpressionValueIsNotNull(eventParams, "eventParams");
        AdParams adParams = nestAdData.getAdParams();
        reporter.onEvent(WifiNestConst.EventKey.NEST_SDK_AD_RESP_DI, eventParams, adParams != null ? adParams.getExt() : null);
    }

    public final void reportSdkLoad(NestAdData nestAdData) {
        String nestType;
        EventParams.Builder renderStyle = new EventParams.Builder().setDspName(nestAdData.getDspName()).setNestSid(nestAdData.getNestSid()).setSdkFrom(nestAdData.getSdkFrom()).setInventoryId(nestAdData.getInventoryId()).setMediaId(nestAdData.getAppId()).setSrcId(nestAdData.getAdCode()).setUseRequestId(nestAdData.getUseRequestId()).setCreateRequestId(nestAdData.getCreateRequestId()).setRenderStyle(nestAdData.getRenderStyle());
        AdParams adParams = nestAdData.getAdParams();
        if (adParams == null || (nestType = adParams.getNestType()) == null) {
            nestType = "";
        }
        EventParams eventParams = EventParams.addEventParamsByAdData(renderStyle.setNestType(nestType), nestAdData);
        AbstractReporter reporter = WifiNestAd.INSTANCE.getReporter();
        Intrinsics.checkExpressionValueIsNotNull(eventParams, "eventParams");
        AdParams adParams2 = nestAdData.getAdParams();
        reporter.onEvent(WifiNestConst.EventKey.UNIFIEDAD_SDK_LOAD, eventParams, adParams2 != null ? adParams2.getExt() : null);
    }

    public final void reportUpdateCacheEvent(SPModel sdkConfig, SPCacheTimeModel timeMdaModel, AdParams adParams, String requestId, int adScene) {
        AbstractReporter reporter = WifiNestAd.INSTANCE.getReporter();
        EventParams.Builder abTypeStatus = new EventParams.Builder().setStrategyId(sdkConfig.getStrategy_id()).setStrategyVer(sdkConfig.getStrategy_ver()).setAbTypeStatus(sdkConfig.getTaiChiId());
        SPCachecfgModel cachecfgModel = sdkConfig.getCachecfgModel();
        if (cachecfgModel == null) {
            Intrinsics.throwNpe();
        }
        EventParams.Builder cacheSuccessSize = abTypeStatus.setCacheSize(cachecfgModel.getCount()).setCacheFailedSize(timeMdaModel.getFailedNum()).setCacheAllNum(timeMdaModel.getAllNum()).setCacheMaxEcpm(timeMdaModel.getMaxEcpm()).setCacheSuccessSize(timeMdaModel.getSuccessNum());
        SPCacheManager sPCacheManager = SPCacheManager.INSTANCE;
        String strategy_id = sdkConfig.getStrategy_id();
        if (strategy_id == null) {
            Intrinsics.throwNpe();
        }
        EventParams eventParamsBuild = cacheSuccessSize.setCacheExt(sPCacheManager.createAllAdJson(strategy_id, requestId, adScene)).build();
        Intrinsics.checkExpressionValueIsNotNull(eventParamsBuild, "EventParams.Builder()\n  …\n                .build()");
        reporter.onEvent(WifiNestConst.EventKey.NEST_AD_UPDATE_CACHE, eventParamsBuild, adParams.getExt());
    }

    public final void reportViewEvent(EventParams.Builder builder, NestAdData nestAdData, String eventKey) throws JSONException {
        if (Intrinsics.areEqual(eventKey, WifiNestConst.EventKey.UNIFIEDAD_SDK_TOSHOW)) {
            SPPriceEventManager sPPriceEventManager = SPPriceEventManager.INSTANCE;
            if (sPPriceEventManager.allow45488() && nestAdData.getUseRequestId() != null) {
                sPPriceEventManager.changeAllCacheAdUseRequestId(nestAdData.getStrategyId(), nestAdData.getUseRequestId());
            }
            sPPriceEventManager.eventShengchuCache(nestAdData.getUseRequestId(), nestAdData, sPPriceEventManager.findAllCacheAd(nestAdData.getAdScene(), nestAdData.getStrategyId()));
            int adScene = nestAdData.getAdScene();
            SPStrategyManager.Companion companion = SPStrategyManager.INSTANCE;
            if (companion.getSceneRequestId().containsKey(Integer.valueOf(adScene))) {
                String str = companion.getSceneRequestId().get(Integer.valueOf(adScene));
                if (!TextUtils.isEmpty(str)) {
                    WifiLog.d("sceneRequestId toShow olduseRequestId " + nestAdData.getUseRequestId() + " newuseRequestId " + str + " scene " + adScene);
                    nestAdData.setUseRequestId(str);
                }
            }
        }
        WifiNestAd wifiNestAd = WifiNestAd.INSTANCE;
        if (wifiNestAd.getSwitch58414()) {
            if (nestAdData.getAdSPStrategy() && Intrinsics.areEqual(eventKey, WifiNestConst.EventKey.UNIFIEDAD_SDK_TOSHOW)) {
                SPCacheManager.INSTANCE.removeShowAd(nestAdData);
            }
        } else if (nestAdData.getAdSPStrategy() && nestAdData.getAdStrategyOptimizeSwitch() == 1 && Intrinsics.areEqual(eventKey, WifiNestConst.EventKey.UNIFIEDAD_SDK_TOSHOW)) {
            SPCacheManager.INSTANCE.removeShowAd(nestAdData);
        }
        if (Intrinsics.areEqual(eventKey, WifiNestConst.EventKey.UNIFIEDAD_SDK_TOSHOW)) {
            SPPriceEventManager sPPriceEventManager2 = SPPriceEventManager.INSTANCE;
            sPPriceEventManager2.eventStayCache(nestAdData.getUseRequestId(), nestAdData.getAdScene(), sPPriceEventManager2.findAllCacheAd(nestAdData.getAdScene(), nestAdData.getStrategyId()));
        }
        if (Intrinsics.areEqual(eventKey, WifiNestConst.EventKey.UNIFIEDAD_SDK_SHOW) || Intrinsics.areEqual(eventKey, WifiNestConst.EventKey.UNIFIEDAD_SDK_CLICK)) {
            Integer adLevel = nestAdData.getAdLevel();
            if (adLevel == null) {
                Intrinsics.throwNpe();
            }
            builder.setAdLevel(adLevel.intValue());
            nestAdData.getInteractiveType();
            builder.setInteractiveType(nestAdData.getInteractiveType());
        }
        if (Intrinsics.areEqual(eventKey, WifiNestConst.EventKey.UNIFIEDAD_SDK_TOSHOW) || Intrinsics.areEqual(eventKey, WifiNestConst.EventKey.UNIFIEDAD_SDK_SHOW) || Intrinsics.areEqual(eventKey, WifiNestConst.EventKey.UNIFIEDAD_SDK_CLICK)) {
            EventParams.addEventParamsByAdData(builder, nestAdData);
        }
        if (Intrinsics.areEqual(eventKey, WifiNestConst.EventKey.UNIFIEDAD_SDK_TOSHOW)) {
            nestAdData.sendWinNotification$core_release();
        }
        if (Intrinsics.areEqual(eventKey, WifiNestConst.EventKey.UNIFIEDAD_SDK_CLICK)) {
            wifiNestAd.eventShenHeShow(nestAdData);
        }
        AbstractReporter reporter = wifiNestAd.getReporter();
        EventParams eventParamsBuild = builder.build();
        Intrinsics.checkExpressionValueIsNotNull(eventParamsBuild, "builder.build()");
        AdParams adParams = nestAdData.getAdParams();
        reporter.onEvent(eventKey, eventParamsBuild, adParams != null ? adParams.getExt() : null);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void reportResp(AdParams adParams, int successList) {
        String strValueOf;
        if (adParams.getExt() == null) {
            strValueOf = "";
        } else {
            Map<String, String> ext = adParams.getExt();
            if (ext == null) {
                Intrinsics.throwNpe();
            }
            if (ext.containsKey("requestId")) {
                Map<String, String> ext2 = adParams.getExt();
                if (ext2 == null) {
                    Intrinsics.throwNpe();
                }
                strValueOf = String.valueOf(ext2.get("requestId"));
            }
        }
        EventParams.Builder builder = new EventParams.Builder();
        EventParams eventParams = builder.setRenderStyle(adParams.getRenderStyle()).setNestType(adParams.getNestType()).setUseRequestId(strValueOf).setCreateRequestId(strValueOf).build();
        if (successList >= 0) {
            builder.setNumber(String.valueOf(successList));
        }
        AbstractReporter reporter = WifiNestAd.INSTANCE.getReporter();
        Intrinsics.checkExpressionValueIsNotNull(eventParams, "eventParams");
        reporter.onEvent(WifiNestConst.EventKey.NEST_SDK_AD_RESP, eventParams, adParams.getExt());
    }
}
