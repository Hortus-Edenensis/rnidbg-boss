package com.wifi.ad.core.spstrategy;

import com.heytap.mcssdk.constant.b;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.utils.WifiLog;
import java.util.List;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b#\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u00100\u001a\u000201J\u001a\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u00042\b\u00105\u001a\u0004\u0018\u00010\u0004J\u0010\u00106\u001a\u0002012\u0006\u00107\u001a\u00020\u0004H\u0002J\u0010\u00108\u001a\u0002032\u0006\u00109\u001a\u00020\u0004H\u0002J,\u0010:\u001a\u0002032\u0006\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010>2\b\u0010?\u001a\u0004\u0018\u00010>2\b\u0010@\u001a\u0004\u0018\u00010\u0004J\"\u0010A\u001a\u0002032\b\u0010B\u001a\u0004\u0018\u00010\u00042\u0006\u00107\u001a\u00020*2\b\u0010?\u001a\u0004\u0018\u00010>J\"\u0010C\u001a\u0002032\b\u0010B\u001a\u0004\u0018\u00010\u00042\u0006\u00107\u001a\u00020*2\b\u0010=\u001a\u0004\u0018\u00010>J\"\u0010D\u001a\u0002032\b\u0010B\u001a\u0004\u0018\u00010\u00042\u0006\u0010;\u001a\u00020<2\b\u0010?\u001a\u0004\u0018\u00010>J\"\u0010E\u001a\u0002032\b\u0010B\u001a\u0004\u0018\u00010\u00042\u0006\u00107\u001a\u00020*2\b\u0010?\u001a\u0004\u0018\u00010>J\u0018\u0010F\u001a\u00020>2\u0006\u00107\u001a\u00020*2\b\u00104\u001a\u0004\u0018\u00010\u0004J\u0014\u0010G\u001a\u0004\u0018\u00010H2\b\u0010;\u001a\u0004\u0018\u00010<H\u0002J\u001e\u0010I\u001a\u0002032\u0006\u0010J\u001a\u00020\u00042\u0006\u0010K\u001a\u00020\u00042\u0006\u0010L\u001a\u00020\u0004J\u001c\u0010M\u001a\u0002032\b\u0010N\u001a\u0004\u0018\u00010\u00042\b\u0010O\u001a\u0004\u0018\u00010\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010+\u001a\u00020*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u0006P"}, d2 = {"Lcom/wifi/ad/core/spstrategy/SPPriceEventManager;", "", "()V", "KEY_45488TAI", "", "KEY_ADCOST", "KEY_ALLOWSCENES", "KEY_ALLOWUIDS", "KEY_CACHEEND", "KEY_CACHESEC", "KEY_CACHESTART", "KEY_CACHE_SIZE", "KEY_CREATE_REQUESTID", "KEY_ECPM_LOW_PRICE", "KEY_ECPM_RATIO", "KEY_GROUP", "KEY_INVENTORYID", "KEY_LOADTIME", "KEY_NESTADDATA", "KEY_PARAM_DSPNAME", "KEY_PARAM_REQUESTID", "KEY_PARAM_SCENE", "KEY_PARAM_SRCID", "KEY_PRICE_RESPONSE", "KEY_PRICE_SWITCH", "KEY_STRATEGY_ID", "KEY_STRATEGY_VER", "KEY_USE_REQUESTID", "LX_45488_TAI", "getLX_45488_TAI", "()Ljava/lang/String;", "setLX_45488_TAI", "(Ljava/lang/String;)V", "PRICE_PULL_CACHE", "PRICE_PUSH_CACHE", "PRICE_REQUEST_END_CACHE", "PRICE_REQUEST_START_CACHE", "PRICE_SHENGCHU", "PRICE_STAY_CACHE", SPPriceEventManager.KEY_ALLOWSCENES, "", "eventAllowUid", "", "randomInt_num", "getRandomInt_num", "()I", "setRandomInt_num", "(I)V", "allow45488", "", "changeAllCacheAdUseRequestId", "", "strategyId", "newUseRequestId", "checkAllEvent", "scene", "eventLog", "res", "eventPushCache", SPPriceEventManager.KEY_NESTADDATA, "Lcom/wifi/ad/core/data/NestAdData;", SPPriceEventManager.KEY_CACHESTART, "Lorg/json/JSONArray;", SPPriceEventManager.KEY_CACHEEND, "curRequestId", "eventRequestEndCache", "requestId", "eventRequestStartCache", "eventShengchuCache", "eventStayCache", "findAllCacheAd", "getEventParamsByAdData", "Lorg/json/JSONObject;", "initConfig", "ext", DeviceInfoUtil.UID_TAG, "deviceId", "onEvent", b.k, "paramsJson", "core_release"}, k = 1, mv = {1, 1, 16})
public final class SPPriceEventManager {
    private static final String KEY_45488TAI = "45488Tai";
    private static final String KEY_ADCOST = "adcost";
    private static final String KEY_ALLOWSCENES = "eventAllowScenes";
    private static final String KEY_ALLOWUIDS = "eventAllowUids";
    private static final String KEY_CACHEEND = "cacheEnd";
    private static final String KEY_CACHESEC = "cacheSec";
    private static final String KEY_CACHESTART = "cacheStart";
    private static final String KEY_CACHE_SIZE = "cache_size";
    private static final String KEY_CREATE_REQUESTID = "createrequestid";
    private static final String KEY_ECPM_LOW_PRICE = "ecpm_low_price";
    private static final String KEY_ECPM_RATIO = "ecpm_ratio";
    private static final String KEY_GROUP = "group";
    private static final String KEY_INVENTORYID = "inventoryId";
    private static final String KEY_LOADTIME = "loadAdTime";
    private static final String KEY_NESTADDATA = "nestAdData";
    private static final String KEY_PARAM_DSPNAME = "dspname";
    private static final String KEY_PARAM_REQUESTID = "requestId";
    private static final String KEY_PARAM_SCENE = "scene";
    private static final String KEY_PARAM_SRCID = "srcid";
    private static final String KEY_PRICE_RESPONSE = "price_response";
    private static final String KEY_PRICE_SWITCH = "price_switch";
    private static final String KEY_STRATEGY_ID = "strategy_id";
    private static final String KEY_STRATEGY_VER = "strategy_ver";
    private static final String KEY_USE_REQUESTID = "userequestid";
    private static final String PRICE_PULL_CACHE = "nest_sdk_price_pull_cache";
    private static final String PRICE_PUSH_CACHE = "nest_sdk_price_push_cache";
    private static final String PRICE_REQUEST_END_CACHE = "nest_sdk_price_request_end_cache";
    private static final String PRICE_REQUEST_START_CACHE = "nest_sdk_price_request_start_cache";
    private static final String PRICE_SHENGCHU = "nest_sdk_price_shengchu";
    private static final String PRICE_STAY_CACHE = "nest_sdk_price_stay_cache";
    private static List<String> eventAllowScenes;
    public static final SPPriceEventManager INSTANCE = new SPPriceEventManager();
    private static int eventAllowUid = -1;
    private static String LX_45488_TAI = "";
    private static int randomInt_num = 1000;

    private SPPriceEventManager() {
    }

    private final boolean checkAllEvent(String scene) {
        List<String> list;
        if (!(scene == null || scene.length() == 0) && (list = eventAllowScenes) != null) {
            if (list == null) {
                Intrinsics.throwNpe();
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                List<String> list2 = eventAllowScenes;
                if (list2 == null) {
                    Intrinsics.throwNpe();
                }
                if (Intrinsics.areEqual(scene, list2.get(i).toString())) {
                    eventLog("checkAllEvent scene " + scene + " return true");
                    return true;
                }
            }
        }
        return false;
    }

    private final void eventLog(String res) {
        WifiLog.d("SPPriceEventManager:" + res);
    }

    private final JSONObject getEventParamsByAdData(NestAdData nestAdData) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (nestAdData != null) {
            jSONObject.put("requestId", nestAdData.getRequestId());
            jSONObject.put("dspname", nestAdData.getDspName());
            jSONObject.put("adcost", nestAdData.getAdCost());
            jSONObject.put("ecpm_ratio", Float.valueOf(nestAdData.getEcpmRatio()));
            jSONObject.put("ecpm_low_price", nestAdData.getEcpmLowPrice());
            jSONObject.put("price_switch", nestAdData.getPriceSwitch());
            jSONObject.put("price_response", nestAdData.getPriceResponse());
            jSONObject.put("srcid", nestAdData.getAdCode());
            jSONObject.put("strategy_ver", nestAdData.getStrategyVer());
            jSONObject.put("strategy_id", nestAdData.getStrategyId());
            jSONObject.put("group", nestAdData.getGroupId());
            jSONObject.put("cache_size", nestAdData.getCacheCount());
            jSONObject.put("createrequestid", nestAdData.getCreateRequestId());
            jSONObject.put("scene", nestAdData.getAdScene());
            jSONObject.put("userequestid", nestAdData.getUseRequestId());
            jSONObject.put(KEY_CACHESEC, nestAdData.getCacheSec() * 60);
            jSONObject.put(KEY_LOADTIME, nestAdData.getLoadAdTime());
            jSONObject.put("inventoryId", nestAdData.getInventoryId());
            jSONObject.put(KEY_45488TAI, LX_45488_TAI);
        }
        return jSONObject;
    }

    private final void onEvent(String eventId, String paramsJson) {
        if (eventAllowUid != 1 || eventId == null || paramsJson == null) {
            return;
        }
        eventLog("onEvent eventId " + eventId + " paramsJson " + paramsJson);
        WifiNestAd.INSTANCE.getReporter().onEvent(eventId, paramsJson);
    }

    public final boolean allow45488() {
        return Intrinsics.areEqual("A", LX_45488_TAI) ^ true;
    }

    public final void changeAllCacheAdUseRequestId(String strategyId, String newUseRequestId) {
        if (newUseRequestId == null || strategyId == null) {
            return;
        }
        SPCacheManager sPCacheManager = SPCacheManager.INSTANCE;
        if (sPCacheManager.getAllCacheAd().containsKey(strategyId)) {
            SPCacheModel sPCacheModel = sPCacheManager.getAllCacheAd().get(strategyId);
            if (sPCacheModel == null) {
                Intrinsics.throwNpe();
            }
            List<NestAdData> allAds = sPCacheModel.getAllAds();
            if (allAds != null) {
                int size = allAds.size();
                for (int i = 0; i < size; i++) {
                    allAds.get(i).setUseRequestId(newUseRequestId);
                }
            }
        }
    }

    public final void eventPushCache(NestAdData nestAdData, JSONArray cacheStart, JSONArray cacheEnd, String curRequestId) throws JSONException {
        if (checkAllEvent(String.valueOf(nestAdData.getAdScene()))) {
            JSONObject eventParamsByAdData = getEventParamsByAdData(nestAdData);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("scene", String.valueOf(nestAdData.getAdScene()));
            jSONObject.put("requestId", curRequestId);
            jSONObject.put(KEY_NESTADDATA, eventParamsByAdData);
            jSONObject.put(KEY_CACHESTART, cacheStart);
            jSONObject.put(KEY_CACHEEND, cacheEnd);
            onEvent(PRICE_PUSH_CACHE, jSONObject.toString());
        }
    }

    public final void eventRequestEndCache(String requestId, int scene, JSONArray cacheEnd) throws JSONException {
        if (checkAllEvent(String.valueOf(scene))) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("scene", String.valueOf(scene));
            jSONObject.put("requestId", requestId);
            jSONObject.put(KEY_CACHEEND, cacheEnd);
            onEvent(PRICE_REQUEST_END_CACHE, jSONObject.toString());
        }
    }

    public final void eventRequestStartCache(String requestId, int scene, JSONArray cacheStart) throws JSONException {
        if (checkAllEvent(String.valueOf(scene))) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("scene", String.valueOf(scene));
            jSONObject.put("requestId", requestId);
            jSONObject.put(KEY_CACHESTART, cacheStart);
            onEvent(PRICE_REQUEST_START_CACHE, jSONObject.toString());
        }
    }

    public final void eventShengchuCache(String requestId, NestAdData nestAdData, JSONArray cacheEnd) throws JSONException {
        if (checkAllEvent(String.valueOf(nestAdData.getAdScene()))) {
            JSONObject eventParamsByAdData = getEventParamsByAdData(nestAdData);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("scene", String.valueOf(nestAdData.getAdScene()));
            jSONObject.put("requestId", requestId);
            jSONObject.put(KEY_NESTADDATA, eventParamsByAdData);
            jSONObject.put(KEY_CACHEEND, cacheEnd);
            onEvent(PRICE_SHENGCHU, jSONObject.toString());
        }
    }

    public final void eventStayCache(String requestId, int scene, JSONArray cacheEnd) throws JSONException {
        if (checkAllEvent(String.valueOf(scene))) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("scene", String.valueOf(scene));
            jSONObject.put("requestId", requestId);
            jSONObject.put(KEY_CACHEEND, cacheEnd);
            onEvent(PRICE_STAY_CACHE, jSONObject.toString());
        }
    }

    public final synchronized JSONArray findAllCacheAd(int scene, String strategyId) {
        JSONArray jSONArray = new JSONArray();
        if (!checkAllEvent(String.valueOf(scene))) {
            return jSONArray;
        }
        if (strategyId != null) {
            SPCacheManager sPCacheManager = SPCacheManager.INSTANCE;
            if (sPCacheManager.getAllCacheAd().containsKey(strategyId)) {
                SPCacheModel sPCacheModel = sPCacheManager.getAllCacheAd().get(strategyId);
                if (sPCacheModel == null) {
                    Intrinsics.throwNpe();
                }
                List<NestAdData> allAds = sPCacheModel.getAllAds();
                if (allAds != null) {
                    int size = allAds.size();
                    for (int i = 0; i < size; i++) {
                        jSONArray.put(getEventParamsByAdData(allAds.get(i)));
                    }
                    return jSONArray;
                }
            }
        }
        return jSONArray;
    }

    public final String getLX_45488_TAI() {
        return LX_45488_TAI;
    }

    public final int getRandomInt_num() {
        return randomInt_num;
    }

    public final void initConfig(String ext, String uid, String deviceId) {
        if (eventAllowUid == -1) {
            Random random = new Random();
            random.nextInt();
            eventAllowUid = random.nextInt(randomInt_num) == 1 ? 1 : 0;
        }
        if (ext.length() == 0) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(ext);
            String strOptString = jSONObject.optString(KEY_ALLOWUIDS);
            if (strOptString != null && StringsKt__StringsKt.contains$default((CharSequence) strOptString, (CharSequence) uid, false, 2, (Object) null)) {
                eventAllowUid = 1;
            }
            String resScene = jSONObject.optString(KEY_ALLOWSCENES);
            Intrinsics.checkExpressionValueIsNotNull(resScene, "resScene");
            eventAllowScenes = StringsKt__StringsKt.split$default((CharSequence) resScene, new String[]{","}, false, 0, 6, (Object) null);
        } catch (Exception unused) {
        }
    }

    public final void setLX_45488_TAI(String str) {
        LX_45488_TAI = str;
    }

    public final void setRandomInt_num(int i) {
        randomInt_num = i;
    }
}
