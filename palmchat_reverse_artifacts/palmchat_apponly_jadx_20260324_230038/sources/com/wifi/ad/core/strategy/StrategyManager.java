package com.wifi.ad.core.strategy;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.huawei.openalliance.ad.constant.bq;
import com.wifi.ad.core.SDKAlias;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.config.AdParams;
import com.wifi.ad.core.config.EventParams;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import com.wifi.ad.core.config.adx.model.WkAdConfigModel;
import com.wifi.ad.core.data.BlackListFilterData;
import com.wifi.ad.core.data.FilterConfigBean;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.data.NestMixAdLevel;
import com.wifi.ad.core.data.WhiteFilterConfigBean;
import com.wifi.ad.core.entity.SensitiveInfo;
import com.wifi.ad.core.listener.BaseListener;
import com.wifi.ad.core.p001const.WifiNestConst;
import com.wifi.ad.core.reporter.AbstractReporter;
import com.wifi.ad.core.spstrategy.SPModel;
import com.wifi.ad.core.spstrategy.SPStrategyManager;
import com.wifi.ad.core.spstrategy.SPTaiChiManager;
import com.wifi.ad.core.utils.JsonUtil;
import com.wifi.ad.core.utils.WifiLog;
import com.wifi.csj.ad.NestCsjProvider;
import com.wifi.ks.ad.NestKsProvider;
import com.wifi.self.ad.NestWifiProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J.\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0006\u0010\u0018\u001a\u00020\u00042\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001aH\u0002J&\u0010\u001b\u001a\u0004\u0018\u00010\u00112\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00110\u000e2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u000eH\u0002J(\u0010\u001f\u001a\u0004\u0018\u00010\u00142\b\b\u0001\u0010\u0015\u001a\u00020\u00162\n\b\u0001\u0010 \u001a\u0004\u0018\u00010!2\b\b\u0001\u0010\"\u001a\u00020#J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0011H\u0002J\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ*\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00110\u000e2\u0006\u0010\u0018\u001a\u00020\u00042\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001aJ\u000e\u0010)\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0011J\b\u0010*\u001a\u0004\u0018\u00010\u0004J\u0010\u0010+\u001a\u00020,2\u0006\u0010&\u001a\u00020\u0011H\u0002J\u001e\u0010-\u001a\u00020,2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00110\u000e2\u0006\u0010/\u001a\u00020\u0011H\u0002J>\u00100\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000e2\u0006\u00101\u001a\u00020\u001e2\u0006\u00102\u001a\u00020\u001e2\u0006\u00103\u001a\u0002042\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001aH\u0002J\"\u00105\u001a\u0002062\u0006\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010\u00042\b\u0010:\u001a\u0004\u0018\u00010;J\"\u0010<\u001a\u0002062\u0006\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010\u00042\b\u0010:\u001a\u0004\u0018\u00010=J \u0010>\u001a\u00020?2\u0006\u00107\u001a\u0002082\b\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010&\u001a\u00020\u0011J \u0010@\u001a\u00020?2\u0006\u00107\u001a\u0002082\b\u0010:\u001a\u0004\u0018\u00010=2\u0006\u0010&\u001a\u00020\u0011R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/wifi/ad/core/strategy/StrategyManager;", "", "()V", "AD_FROM_CSJ", "", "getAD_FROM_CSJ", "()Ljava/lang/String;", "AD_FROM_KUAISHOU", "getAD_FROM_KUAISHOU", "AD_FROM_WIFI", "getAD_FROM_WIFI", "allfilterTaiChi", "getAllfilterTaiChi", "mixAdLevels", "", "Lcom/wifi/ad/core/data/NestMixAdLevel;", "mixAdList", "Lcom/wifi/ad/core/data/NestAdData;", "calculateStrategy", "createStrategy", "Lcom/wifi/ad/core/strategy/AbsStrategy;", "adParams", "Lcom/wifi/ad/core/config/AdParams;", "decodeAdList", "adStrs", "ext", "", "determineAdPosition", "adPositions", "ratios", "", "getCurrentStrategy", bq.f.s, "Lcom/wifi/ad/core/listener/BaseListener;", "context", "Landroid/content/Context;", "getEventParams", "Lcom/wifi/ad/core/config/EventParams;", "ad", "getMixAdLevels", "getMixAds", "getNestAdInfo", "getTaichikeys", "isNullOrEmpty", "", "isValidAd", "adLevelDatas", "adData", "parserStrategy", "adLevel", "ecpm", "strategyJson", "Lorg/json/JSONArray;", "setFilterData", "", "filterOn", "Ljava/util/concurrent/atomic/AtomicBoolean;", "taiChiKey", "filterConfig", "Lcom/wifi/ad/core/data/FilterConfigBean;", "setWhiteFilterData", "Lcom/wifi/ad/core/data/WhiteFilterConfigBean;", "shouldFilter", "Lcom/wifi/ad/core/data/BlackListFilterData;", "shouldFilterWhiteList", "core_release"}, k = 1, mv = {1, 1, 16})
public final class StrategyManager {
    public static final StrategyManager INSTANCE = new StrategyManager();
    private static List<NestMixAdLevel> mixAdLevels = new ArrayList();
    private static List<NestAdData> mixAdList = new ArrayList();
    private static final String allfilterTaiChi = "LX-28151";
    private static final String AD_FROM_WIFI = NestWifiProvider.SDK_FROM;
    private static final String AD_FROM_KUAISHOU = NestKsProvider.SDK_FROM;
    private static final String AD_FROM_CSJ = NestCsjProvider.SDK_FROM;

    private StrategyManager() {
    }

    private final AbsStrategy createStrategy(AdParams adParams) {
        String fullStrategyJson = adParams.getFullStrategyJson();
        if (!(fullStrategyJson == null || fullStrategyJson.length() == 0)) {
            try {
                JSONObject jSONObject = new JSONObject(adParams.getFullStrategyJson());
                adParams.setTotalTimeout$core_release(jSONObject.optLong("totalTimeout", 3500L));
                adParams.setAdModel$core_release(jSONObject.optInt("mode", 0));
                adParams.setStrategyJson$core_release(jSONObject.optString(WkAdConfigModel.TAG_STRATEGY, ""));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        int iIntValue = Integer.valueOf(adParams.getAdModel()).intValue();
        if (iIntValue == 0) {
            return new SerialStrategy();
        }
        if (iIntValue != 1) {
            return null;
        }
        return new ParallelStrategy();
    }

    private final List<NestMixAdLevel> decodeAdList(String adStrs, Map<String, String> ext) {
        mixAdLevels.clear();
        mixAdList.clear();
        try {
            JSONArray jSONArray = new JSONArray(adStrs);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                NestMixAdLevel nestMixAdLevel = new NestMixAdLevel();
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                nestMixAdLevel.setLevel(jSONObject.optInt("level", -1));
                nestMixAdLevel.getLevel();
                JSONArray jSONArray2 = jSONObject.getJSONArray("ratios");
                ArrayList arrayList = new ArrayList();
                int length2 = jSONArray2.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    arrayList.add(Integer.valueOf(jSONArray2.optInt(i2, 0)));
                }
                nestMixAdLevel.setRatios(arrayList);
                List<Integer> ratios = nestMixAdLevel.getRatios();
                if (ratios == null || ratios.isEmpty()) {
                    return null;
                }
                nestMixAdLevel.setEcpm(jSONObject.optInt("ecpm", AVMDLDataLoader.KeyIsEnableEventInfo));
                StrategyManager strategyManager = INSTANCE;
                int level = nestMixAdLevel.getLevel();
                int ecpm = nestMixAdLevel.getEcpm();
                JSONArray jSONArray3 = jSONObject.getJSONArray("adStrategy");
                Intrinsics.checkExpressionValueIsNotNull(jSONArray3, "jsonObj.getJSONArray(\"adStrategy\")");
                List<NestAdData> list = strategyManager.parserStrategy(level, ecpm, jSONArray3, ext);
                if (list == null) {
                    return null;
                }
                nestMixAdLevel.setAdStrategy(list);
                List<NestMixAdLevel> list2 = mixAdLevels;
                if (list2 != null) {
                    list2.add(nestMixAdLevel);
                }
            }
            WifiLog.d("decodeAdList success");
            return mixAdLevels;
        } catch (Exception e) {
            e.printStackTrace();
            WifiLog.d("decodeAdList fail");
            AbstractReporter reporter = WifiNestAd.INSTANCE.getReporter();
            EventParams eventParamsBuild = new EventParams.Builder().setErrorCode(e.toString()).build();
            Intrinsics.checkExpressionValueIsNotNull(eventParamsBuild, "EventParams.Builder()\n  …                 .build()");
            reporter.onEvent(WifiNestConst.EventKey.NEST_AD_PARSE_STRATEGY_FAIL_ERROR, eventParamsBuild, ext);
            return null;
        }
    }

    private final NestAdData determineAdPosition(List<NestAdData> adPositions, List<Integer> ratios) {
        int iNextInt;
        List<Integer> list = ratios;
        int size = list.size();
        int iIntValue = 0;
        for (int i = 0; i < size; i++) {
            iIntValue += ratios.get(i).intValue();
        }
        if (iIntValue > 0) {
            Random random = new Random();
            random.nextInt();
            iNextInt = random.nextInt(iIntValue);
        } else {
            iNextInt = 0;
        }
        int size2 = list.size();
        int iIntValue2 = 0;
        for (int i2 = 0; i2 < size2; i2++) {
            if (iNextInt < ratios.get(i2).intValue() + iIntValue2) {
                NestAdData nestAdData = adPositions.get(i2);
                adPositions.remove(i2);
                ratios.remove(i2);
                return nestAdData;
            }
            iIntValue2 += ratios.get(i2).intValue();
        }
        return null;
    }

    private final EventParams getEventParams(NestAdData ad) {
        EventParams params = new EventParams.Builder().build();
        SensitiveInfo sensitiveInfo = ad.getSensitiveInfo();
        if (sensitiveInfo != null) {
            JSONArray jSONArray = new JSONArray();
            sensitiveInfo.setAdCode(ad.getAdCode());
            Integer interactionType = ad.getInteractionType();
            if (interactionType != null && interactionType.intValue() == 1) {
                sensitiveInfo.setInteractionType(1);
            } else {
                sensitiveInfo.setInteractionType(2);
            }
            jSONArray.put(sensitiveInfo.toJson());
            if (jSONArray.length() > 0) {
                Intrinsics.checkExpressionValueIsNotNull(params, "params");
                params.setThirdSdkInfo(jSONArray.toString());
            }
        }
        Intrinsics.checkExpressionValueIsNotNull(params, "params");
        return params;
    }

    private final boolean isNullOrEmpty(NestAdData ad) {
        if (ad.getSensitiveInfo() != null) {
            SensitiveInfo sensitiveInfo = ad.getSensitiveInfo();
            if ((sensitiveInfo != null ? sensitiveInfo.getPackageName() : null) != null) {
                SensitiveInfo sensitiveInfo2 = ad.getSensitiveInfo();
                if (!Intrinsics.areEqual(sensitiveInfo2 != null ? sensitiveInfo2.getPackageName() : null, "")) {
                    return false;
                }
            }
        }
        return true;
    }

    private final boolean isValidAd(List<NestAdData> adLevelDatas, NestAdData adData) {
        for (NestAdData nestAdData : adLevelDatas) {
            if (TextUtils.equals(nestAdData.getAdCode(), adData.getAdCode()) || StringsKt__StringsJVMKt.equals(nestAdData.getAdLevelName(), adData.getAdLevelName(), true)) {
                return false;
            }
        }
        return true;
    }

    private final List<NestAdData> parserStrategy(int adLevel, int ecpm, JSONArray strategyJson, Map<String, String> ext) {
        List<NestAdData> list;
        ArrayList arrayList = new ArrayList();
        if (strategyJson != null) {
            try {
                int length = strategyJson.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject = strategyJson.getJSONObject(i);
                    NestAdData nestAdData = new NestAdData();
                    nestAdData.setAdLevel(Integer.valueOf(adLevel));
                    nestAdData.setAdCost(ecpm);
                    nestAdData.setAdCode(jSONObject.optString("di", ""));
                    nestAdData.setAdLevelName(jSONObject.optString("src", ""));
                    nestAdData.setAdRealLevelName(nestAdData.getAdLevelName());
                    String adLevelName = nestAdData.getAdLevelName();
                    boolean z = true;
                    if (!(adLevelName == null || adLevelName.length() == 0)) {
                        String adCode = nestAdData.getAdCode();
                        if (adCode != null && adCode.length() != 0) {
                            z = false;
                        }
                        if (!z) {
                            if (StringsKt__StringsJVMKt.startsWith$default(adLevelName, WkAdxAdConfigMg.DSP_NAME_CSJ, false, 2, null)) {
                                nestAdData.setAdType(SDKAlias.CSJ.getType());
                            } else if (StringsKt__StringsJVMKt.startsWith$default(adLevelName, "K", false, 2, null)) {
                                nestAdData.setAdType(SDKAlias.KS.getType());
                            } else if (StringsKt__StringsJVMKt.startsWith$default(adLevelName, "W", false, 2, null)) {
                                nestAdData.setAdType(SDKAlias.WIFI.getType());
                            } else if (StringsKt__StringsJVMKt.startsWith$default(adLevelName, WkAdxAdConfigMg.DSP_NAME_GDT, false, 2, null)) {
                                nestAdData.setAdType(SDKAlias.GDT.getType());
                            } else if (StringsKt__StringsJVMKt.startsWith$default(adLevelName, "O", false, 2, null)) {
                                nestAdData.setAdType(SDKAlias.OPPO.getType());
                            } else if (StringsKt__StringsJVMKt.startsWith$default(adLevelName, "H", false, 2, null)) {
                                nestAdData.setAdType(SDKAlias.HUAWEI.getType());
                            } else if (StringsKt__StringsJVMKt.startsWith$default(adLevelName, ExifInterface.LONGITUDE_EAST, false, 2, null)) {
                                nestAdData.setAdType(SDKAlias.BEIZI.getType());
                            } else if (StringsKt__StringsJVMKt.startsWith$default(adLevelName, "F", false, 2, null)) {
                                nestAdData.setAdType(SDKAlias.FEISUO.getType());
                            } else {
                                if (!StringsKt__StringsJVMKt.startsWith$default(adLevelName, "L", false, 2, null)) {
                                    return null;
                                }
                                nestAdData.setAdType(SDKAlias.LXAD.getType());
                            }
                            if (INSTANCE.isValidAd(mixAdList, nestAdData) && (list = mixAdList) != null) {
                                list.add(nestAdData);
                            }
                            if (ext != null && ext.containsKey("requestId")) {
                                nestAdData.setRequestId(ext.get("requestId"));
                                nestAdData.setCreateRequestId(ext.get("requestId"));
                            }
                            arrayList.add(nestAdData);
                        }
                    }
                }
                WifiLog.d("decodeAdList parserStrategy success");
            } catch (Exception e) {
                e.printStackTrace();
                WifiLog.d("decodeAdList parserStrategy fail");
                AbstractReporter reporter = WifiNestAd.INSTANCE.getReporter();
                EventParams eventParamsBuild = new EventParams.Builder().setErrorCode(e.toString()).build();
                Intrinsics.checkExpressionValueIsNotNull(eventParamsBuild, "EventParams.Builder()\n  …                 .build()");
                reporter.onEvent(WifiNestConst.EventKey.NEST_AD_PARSE_STRATEGY_FAIL_ERROR, eventParamsBuild, ext);
                return null;
            }
        }
        return arrayList;
    }

    public final List<NestMixAdLevel> calculateStrategy() {
        try {
            for (NestMixAdLevel nestMixAdLevel : mixAdLevels) {
                ArrayList arrayList = new ArrayList();
                nestMixAdLevel.getAdSortStrategy().clear();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                arrayList2.addAll(nestMixAdLevel.getAdStrategy());
                arrayList3.addAll(nestMixAdLevel.getRatios());
                int size = nestMixAdLevel.getAdStrategy().size();
                for (int i = 0; i < size; i++) {
                    NestAdData nestAdDataDetermineAdPosition = INSTANCE.determineAdPosition(arrayList2, arrayList3);
                    if (nestAdDataDetermineAdPosition != null) {
                        WifiLog.d("calculate strategy adData " + nestAdDataDetermineAdPosition);
                        arrayList.add(nestAdDataDetermineAdPosition);
                    }
                }
                nestMixAdLevel.getAdSortStrategy().addAll(arrayList);
            }
        } catch (Exception unused) {
            mixAdLevels.clear();
        }
        return mixAdLevels;
    }

    public final String getAD_FROM_CSJ() {
        return AD_FROM_CSJ;
    }

    public final String getAD_FROM_KUAISHOU() {
        return AD_FROM_KUAISHOU;
    }

    public final String getAD_FROM_WIFI() {
        return AD_FROM_WIFI;
    }

    public final String getAllfilterTaiChi() {
        return allfilterTaiChi;
    }

    public final AbsStrategy getCurrentStrategy(@NonNull AdParams adParams, @NonNull BaseListener listener, @NonNull Context context) {
        WifiLog.d("adParams " + adParams);
        WifiNestAd wifiNestAd = WifiNestAd.INSTANCE;
        AbstractReporter reporter = wifiNestAd.getReporter();
        EventParams eventParamsBuild = new EventParams.Builder().setNestType(adParams.getNestType()).build();
        Intrinsics.checkExpressionValueIsNotNull(eventParamsBuild, "EventParams.Builder()\n  …dParams.nestType).build()");
        reporter.onEvent(WifiNestConst.EventKey.NEST_AD_PARSE_STRATEGY, eventParamsBuild, adParams.getExt());
        SPModel sPModelIsAllSPStrategyAd = SPTaiChiManager.INSTANCE.isAllSPStrategyAd(context, adParams);
        if (sPModelIsAllSPStrategyAd != null) {
            SPStrategyManager sPStrategyManager = new SPStrategyManager();
            sPStrategyManager.setSdkConfig(sPModelIsAllSPStrategyAd);
            return sPStrategyManager;
        }
        AbsStrategy absStrategyCreateStrategy = createStrategy(adParams);
        if (absStrategyCreateStrategy == null) {
            AbstractReporter reporter2 = wifiNestAd.getReporter();
            EventParams eventParamsBuild2 = new EventParams.Builder().setErrorCode("50000").setNestType(adParams.getNestType()).build();
            Intrinsics.checkExpressionValueIsNotNull(eventParamsBuild2, "EventParams.Builder()\n  …                 .build()");
            reporter2.onEvent(WifiNestConst.EventKey.NEST_AD_PARSE_STRATEGY_FAIL, eventParamsBuild2, adParams.getExt());
            if (listener != null) {
                listener.onAdFailed("50000", "策略模式为空");
            }
            return null;
        }
        String strategyJson = adParams.getStrategyJson();
        if (!(strategyJson == null || strategyJson.length() == 0)) {
            AbstractReporter reporter3 = wifiNestAd.getReporter();
            EventParams eventParamsBuild3 = new EventParams.Builder().setNestType(adParams.getNestType()).build();
            Intrinsics.checkExpressionValueIsNotNull(eventParamsBuild3, "EventParams.Builder()\n  …dParams.nestType).build()");
            reporter3.onEvent(WifiNestConst.EventKey.NEST_AD_PARSE_STRATEGY_SUCCESS, eventParamsBuild3, adParams.getExt());
            return absStrategyCreateStrategy;
        }
        AbstractReporter reporter4 = wifiNestAd.getReporter();
        EventParams eventParamsBuild4 = new EventParams.Builder().setErrorCode("50001").setNestType(adParams.getNestType()).build();
        Intrinsics.checkExpressionValueIsNotNull(eventParamsBuild4, "EventParams.Builder()\n  …                 .build()");
        reporter4.onEvent(WifiNestConst.EventKey.NEST_AD_PARSE_STRATEGY_FAIL, eventParamsBuild4, adParams.getExt());
        if (listener != null) {
            listener.onAdFailed("50001", "策略数据为空");
        }
        return null;
    }

    public final List<NestMixAdLevel> getMixAdLevels() {
        return mixAdLevels;
    }

    public final List<NestAdData> getMixAds(String adStrs, Map<String, String> ext) {
        List<NestMixAdLevel> listDecodeAdList = decodeAdList(adStrs, ext);
        if (listDecodeAdList == null || listDecodeAdList.isEmpty()) {
            mixAdLevels.clear();
            mixAdList.clear();
        }
        return mixAdList;
    }

    public final String getNestAdInfo(NestAdData ad) {
        return "{title:" + ad.getTitle() + ",adLogo:" + ad.getAdLogo() + ",adIcon:" + ad.getAdIcon() + ",imageList:" + String.valueOf(ad.getImageList()) + ",sensitiveInfo:" + JsonUtil.INSTANCE.toJson(ad.getSensitiveInfo());
    }

    public final String getTaichikeys() {
        WifiNestAd wifiNestAd = WifiNestAd.INSTANCE;
        if (TextUtils.isEmpty(wifiNestAd.getTaiChikeys$core_release())) {
            return null;
        }
        String taiChikeys$core_release = wifiNestAd.getTaiChikeys$core_release();
        if (taiChikeys$core_release == null) {
            Intrinsics.throwNpe();
        }
        String str = "";
        for (String str2 : StringsKt__StringsKt.split$default((CharSequence) taiChikeys$core_release, new String[]{","}, false, 0, 6, (Object) null)) {
            if (StringsKt__StringsJVMKt.startsWith$default(str2, allfilterTaiChi, false, 2, null)) {
                str = str2;
            }
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str;
    }

    public final void setFilterData(AtomicBoolean filterOn, String taiChiKey, FilterConfigBean filterConfig) {
        if (TextUtils.isEmpty(taiChiKey) || filterConfig == null) {
            return;
        }
        filterOn.set(filterConfig.getEnbale() != 0);
    }

    public final void setWhiteFilterData(AtomicBoolean filterOn, String taiChiKey, WhiteFilterConfigBean filterConfig) {
        if (TextUtils.isEmpty(taiChiKey) || filterConfig == null) {
            return;
        }
        filterOn.set(filterConfig.getEnbale() != 0);
    }

    public final BlackListFilterData shouldFilter(AtomicBoolean filterOn, FilterConfigBean filterConfig, NestAdData ad) {
        String packageName;
        boolean z;
        String nestType;
        SensitiveInfo sensitiveInfo;
        SensitiveInfo sensitiveInfo2;
        SensitiveInfo sensitiveInfo3;
        String deepUrl;
        String h5Url;
        String downloadUrl;
        List<String> words;
        SensitiveInfo sensitiveInfo4;
        SensitiveInfo sensitiveInfo5;
        SensitiveInfo sensitiveInfo6;
        SensitiveInfo sensitiveInfo7;
        String authorName;
        String desc;
        String title;
        String appName;
        List<String> pkglist;
        String packageName2;
        String packageName3;
        try {
            if (Intrinsics.areEqual(SDKAlias.HUAWEI.getType(), ad.getAdType())) {
                return new BlackListFilterData(false, 0L);
            }
        } catch (Exception unused) {
        }
        if (!filterOn.get()) {
            return new BlackListFilterData(false, 0L);
        }
        if (ad.getSensitiveInfo() == null || filterConfig == null) {
            return new BlackListFilterData(false, 0L);
        }
        if (AD_FROM_WIFI.equals(ad.getSdkFrom())) {
            return new BlackListFilterData(false, 0L);
        }
        long jCurrentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        SensitiveInfo sensitiveInfo8 = ad.getSensitiveInfo();
        String str = "";
        boolean z2 = true;
        if (sensitiveInfo8 == null || (packageName3 = sensitiveInfo8.getPackageName()) == null || !StringsKt__StringsKt.contains$default((CharSequence) packageName3, (CharSequence) "com.gmlive", false, 2, (Object) null)) {
            packageName = "";
            z = false;
        } else {
            SensitiveInfo sensitiveInfo9 = ad.getSensitiveInfo();
            packageName = sensitiveInfo9 != null ? sensitiveInfo9.getPackageName() : null;
            if (packageName == null) {
                Intrinsics.throwNpe();
            }
            z = true;
        }
        if (!z && (pkglist = filterConfig.getPkglist()) != null) {
            Iterator<T> it = pkglist.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String it2 = (String) it.next();
                SensitiveInfo sensitiveInfo10 = ad.getSensitiveInfo();
                if (sensitiveInfo10 != null && (packageName2 = sensitiveInfo10.getPackageName()) != null && packageName2.equals(it2)) {
                    Intrinsics.checkExpressionValueIsNotNull(it2, "it");
                    packageName = it2;
                    z = true;
                    break;
                }
            }
        }
        if (z || (words = filterConfig.getWords()) == null) {
            it = "";
        } else {
            for (String it3 : words) {
                if (!TextUtils.isEmpty(it3)) {
                    Intrinsics.checkExpressionValueIsNotNull(it3, "it");
                    if (it3 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                    }
                    if ((StringsKt__StringsKt.trim((CharSequence) it3).toString().length() > 0) && (((sensitiveInfo4 = ad.getSensitiveInfo()) != null && (appName = sensitiveInfo4.getAppName()) != null && appName.equals(it3)) || (((sensitiveInfo5 = ad.getSensitiveInfo()) != null && (title = sensitiveInfo5.getTitle()) != null && StringsKt__StringsKt.contains$default((CharSequence) title, (CharSequence) it3, false, 2, (Object) null)) || (((sensitiveInfo6 = ad.getSensitiveInfo()) != null && (desc = sensitiveInfo6.getDesc()) != null && StringsKt__StringsKt.contains$default((CharSequence) desc, (CharSequence) it3, false, 2, (Object) null)) || ((sensitiveInfo7 = ad.getSensitiveInfo()) != null && (authorName = sensitiveInfo7.getAuthorName()) != null && authorName.equals(it3)))))) {
                        z = true;
                        break;
                    }
                }
            }
            it3 = "";
        }
        if (z) {
            it = "";
        } else {
            List<String> urls = filterConfig.getUrls();
            if (urls != null) {
                for (String it4 : urls) {
                    if (!TextUtils.isEmpty(it4)) {
                        Intrinsics.checkExpressionValueIsNotNull(it4, "it");
                        if (it4 == null) {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                        }
                        if ((StringsKt__StringsKt.trim((CharSequence) it4).toString().length() > 0) && (((sensitiveInfo = ad.getSensitiveInfo()) != null && (downloadUrl = sensitiveInfo.getDownloadUrl()) != null && StringsKt__StringsKt.contains$default((CharSequence) downloadUrl, (CharSequence) it4, false, 2, (Object) null)) || (((sensitiveInfo2 = ad.getSensitiveInfo()) != null && (h5Url = sensitiveInfo2.getH5Url()) != null && StringsKt__StringsKt.contains$default((CharSequence) h5Url, (CharSequence) it4, false, 2, (Object) null)) || ((sensitiveInfo3 = ad.getSensitiveInfo()) != null && (deepUrl = sensitiveInfo3.getDeepUrl()) != null && StringsKt__StringsKt.contains$default((CharSequence) deepUrl, (CharSequence) it4, false, 2, (Object) null))))) {
                            break;
                        }
                    }
                }
                it4 = "";
                z2 = z;
                z = z2;
            } else {
                it4 = "";
                z2 = z;
                z = z2;
            }
        }
        if (z) {
            EventParams.Builder renderStyle = new EventParams.Builder().setNestSid(ad.getNestSid()).setDspName(ad.getDspName()).setMediaId(ad.getAppId()).setSrcId(ad.getAdCode()).setSdkFrom(ad.getSdkFrom()).setInventoryId(ad.getInventoryId()).setRenderStyle(ad.getRenderStyle());
            Object adMode = ad.getAdMode();
            if (adMode == null) {
                adMode = "";
            }
            EventParams.Builder adMode2 = renderStyle.setAdMode(adMode.toString());
            AdParams adParams = ad.getAdParams();
            if (adParams != null && (nestType = adParams.getNestType()) != null) {
                str = nestType;
            }
            EventParams.Builder pkgname = adMode2.setNestType(str).setPkgname(packageName);
            Integer adLevel = ad.getAdLevel();
            if (adLevel == null) {
                Intrinsics.throwNpe();
            }
            EventParams eventParams = pkgname.setAdLevel(adLevel.intValue()).setDomainName(it4).setSensitiveWords(it3).build();
            WifiLog.d(String.valueOf(ad.getSensitiveInfo()));
            AbstractReporter reporter = WifiNestAd.INSTANCE.getReporter();
            Intrinsics.checkExpressionValueIsNotNull(eventParams, "eventParams");
            AdParams adParams2 = ad.getAdParams();
            reporter.onEvent(WifiNestConst.EventKey.NEST_SDK_AD_BLACKLIST, eventParams, adParams2 != null ? adParams2.getExt() : null);
        }
        return new BlackListFilterData(z, SystemClock.currentThreadTimeMillis() - jCurrentThreadTimeMillis);
    }

    public final BlackListFilterData shouldFilterWhiteList(AtomicBoolean filterOn, WhiteFilterConfigBean filterConfig, NestAdData ad) {
        Set<String> fullList;
        String packageName;
        String packageName2;
        String nestType;
        boolean z = false;
        if (!filterOn.get()) {
            return new BlackListFilterData(false, 0L);
        }
        if (ad.getSensitiveInfo() == null || filterConfig == null) {
            return new BlackListFilterData(false, 0L);
        }
        if (AD_FROM_WIFI.equals(ad.getSdkFrom())) {
            return new BlackListFilterData(false, 0L);
        }
        long jCurrentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        if (!isNullOrEmpty(ad) && (fullList = filterConfig.getFullList()) != null) {
            Iterator<T> it = fullList.iterator();
            packageName = "";
            boolean z2 = false;
            while (true) {
                if (!it.hasNext()) {
                    z = z2;
                    break;
                }
                String str = (String) it.next();
                SensitiveInfo sensitiveInfo = ad.getSensitiveInfo();
                if (sensitiveInfo != null && (packageName2 = sensitiveInfo.getPackageName()) != null && packageName2.equals(str)) {
                    break;
                }
                SensitiveInfo sensitiveInfo2 = ad.getSensitiveInfo();
                packageName = sensitiveInfo2 != null ? sensitiveInfo2.getPackageName() : null;
                z2 = true;
            }
        } else {
            packageName = "";
        }
        if (z) {
            EventParams.Builder renderStyle = new EventParams.Builder().setNestSid(ad.getNestSid()).setDspName(ad.getDspName()).setMediaId(ad.getAppId()).setSrcId(ad.getAdCode()).setSdkFrom(ad.getSdkFrom()).setInventoryId(ad.getInventoryId()).setRenderStyle(ad.getRenderStyle());
            Object adMode = ad.getAdMode();
            if (adMode == null) {
                adMode = "";
            }
            EventParams.Builder adMode2 = renderStyle.setAdMode(adMode.toString());
            AdParams adParams = ad.getAdParams();
            if (adParams == null || (nestType = adParams.getNestType()) == null) {
                nestType = "";
            }
            EventParams.Builder pkgname = adMode2.setNestType(nestType).setPkgname(packageName != null ? packageName : "");
            Integer adLevel = ad.getAdLevel();
            if (adLevel == null) {
                Intrinsics.throwNpe();
            }
            EventParams eventParams = pkgname.setAdLevel(adLevel.intValue()).build();
            WifiNestAd wifiNestAd = WifiNestAd.INSTANCE;
            AbstractReporter reporter = wifiNestAd.getReporter();
            Intrinsics.checkExpressionValueIsNotNull(eventParams, "eventParams");
            AdParams adParams2 = ad.getAdParams();
            reporter.onEvent(WifiNestConst.EventKey.NEST_SDK_AD_WHITE_BLACK_NOAD, eventParams, adParams2 != null ? adParams2.getExt() : null);
            SensitiveInfo sensitiveInfo3 = ad.getSensitiveInfo();
            WifiLog.d(sensitiveInfo3 != null ? sensitiveInfo3.toString() : null);
            AbstractReporter reporter2 = wifiNestAd.getReporter();
            EventParams eventParams2 = getEventParams(ad);
            AdParams adParams3 = ad.getAdParams();
            reporter2.onEvent(WifiNestConst.EventKey.NEST_SDK_MATERIAL_SHENHE, eventParams2, adParams3 != null ? adParams3.getExt() : null);
        }
        return new BlackListFilterData(z, SystemClock.currentThreadTimeMillis() - jCurrentThreadTimeMillis);
    }
}
