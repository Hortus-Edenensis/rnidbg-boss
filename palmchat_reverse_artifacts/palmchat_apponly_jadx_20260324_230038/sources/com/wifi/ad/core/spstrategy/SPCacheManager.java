package com.wifi.ad.core.spstrategy;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.InterstitialAd;
import com.beizi.fusion.NativeAd;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.heytap.msp.mobad.api.ad.HotSplashAd;
import com.heytap.msp.mobad.api.ad.NativeAdvanceAd;
import com.heytap.msp.mobad.api.ad.NativeTempletAd;
import com.huawei.hms.ads.splash.SplashAd;
import com.huawei.hms.ads.splash.SplashView;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.wifi.ad.core.SDKAlias;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.config.AdParams;
import com.wifi.ad.core.config.EventParams;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.p001const.WifiNestConst;
import com.wifi.ad.core.reporter.AbstractReporter;
import com.wifi.ad.core.spstrategy.all.SPAdAllConfigMg;
import com.wifi.ad.core.utils.WifiLog;
import com.zm.fissionsdk.api.interfaces.IFission;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b'\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001MB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0005J\u000e\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u000fJ\u001c\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u000f2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\r0 J\u001c\u0010!\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u000f2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\r0 J*\u0010\"\u001a\u00020#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000f0%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010\u0005H\u0002J\u000e\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020\rJ,\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000f0%2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000f0%2\u0006\u0010-\u001a\u00020\r2\u0006\u0010.\u001a\u00020\u000fH\u0002J\u001c\u0010/\u001a\u00020\u00182\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u000f0%2\u0006\u0010.\u001a\u00020\u000fJ\u001c\u00101\u001a\u00020\u00182\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u000f0%2\u0006\u0010.\u001a\u00020\u000fJ \u00102\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010\u00052\u0006\u0010*\u001a\u00020\rJ\u0012\u00103\u001a\u00020#2\b\u00104\u001a\u0004\u0018\u00010\u0006H\u0002J\u000e\u00105\u001a\u00020#2\u0006\u00106\u001a\u00020\u000fJ\u0010\u00107\u001a\u00020#2\u0006\u0010*\u001a\u00020\rH\u0002J\u001c\u00108\u001a\u00020#2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u000f0%2\u0006\u0010.\u001a\u00020\u000fJ\u000e\u00109\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u0005J.\u0010:\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001b\u001a\u00020\u00052\b\u0010;\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u000fJ.\u0010<\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001b\u001a\u00020\u00052\b\u0010;\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u000fJ,\u0010=\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001b\u001a\u00020\u00052\b\u0010;\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010\u00052\u0006\u0010>\u001a\u00020\u0018J\"\u0010?\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00052\b\u0010;\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010\u0005J$\u0010@\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001b\u001a\u00020\u00052\b\u0010;\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010\u0005J\u0010\u0010A\u001a\u0004\u0018\u00010\u000f2\u0006\u0010*\u001a\u00020\rJ\u000e\u0010B\u001a\u00020\r2\u0006\u0010*\u001a\u00020\rJ\u0010\u0010C\u001a\u00020\u00182\u0006\u0010D\u001a\u00020\u0005H\u0002J\u001a\u0010E\u001a\u00020#2\b\u0010F\u001a\u0004\u0018\u00010\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005J\u000e\u0010G\u001a\u00020#2\u0006\u0010.\u001a\u00020\u000fJ \u0010H\u001a\u00020#2\u0006\u0010.\u001a\u00020\u000f2\b\u0010(\u001a\u0004\u0018\u00010\u00052\u0006\u0010I\u001a\u00020\rJ\u0010\u0010J\u001a\u00020#2\u0006\u0010K\u001a\u00020\u000fH\u0002J\u0012\u0010L\u001a\u00020#2\b\u0010.\u001a\u0004\u0018\u00010\u000fH\u0002R6\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR1\u0010\f\u001a\"\u0012\u0004\u0012\u00020\r\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u00100\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\tR6\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00130\u0004j\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0013`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\t\"\u0004\b\u0015\u0010\u000bR*\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0005`\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006N"}, d2 = {"Lcom/wifi/ad/core/spstrategy/SPCacheManager;", "", "()V", "allCacheAd", "Ljava/util/HashMap;", "", "Lcom/wifi/ad/core/spstrategy/SPCacheModel;", "Lkotlin/collections/HashMap;", "getAllCacheAd", "()Ljava/util/HashMap;", "setAllCacheAd", "(Ljava/util/HashMap;)V", "allShowAd", "", "Ljava/util/ArrayList;", "Lcom/wifi/ad/core/data/NestAdData;", "Lkotlin/collections/ArrayList;", "getAllShowAd", "allSpSM", "Lcom/wifi/ad/core/spstrategy/SPStrategyManager;", "getAllSpSM", "setAllSpSM", "allStrategyIdKey", "canShowDhRedDot", "", "context", "Landroid/content/Context;", "strategyId", "changeCheckMaxAd", "oldAdData", "changeFeedCheckMaxAd", "supportModes", "", "changeFeedCheckMaxAdNew", "checkCacheAd", "", "allAds", "", "timeModel", "Lcom/wifi/ad/core/spstrategy/SPCacheTimeModel;", "requestId", "clearCacheAd", "scene", "collectionAd", "oldAds", "cacheCount", "adData", "containsData", "cacheAds", "containsDataNew", "createAllAdJson", "destroyCacheAd", "spModel", "destroyOneAd", "adNestData", "destroyShowAd", "eventCacheExt", "findAllCacheAdSie", "findAndDispatchCacheAd", "timeMdaModel", "findAndDispatchCacheAdNew", "findCacheAd", "allowDispatch", "findCacheAdSize", "findCacheMaxAd", "findCacheMaxAdByScene", "findCacheSizeAdByScene", "isContainsLetter", "input", "removeHWAdByCache", "useRequestId", "removeShowAd", "saveCacheAd", "adScene", "saveRealEcpm", "nestAdData", "saveShowAd", "ADComparator", "core_release"}, k = 1, mv = {1, 1, 16})
public final class SPCacheManager {
    public static final SPCacheManager INSTANCE = new SPCacheManager();
    private static HashMap<Integer, SPStrategyManager> allSpSM = new HashMap<>();
    private static HashMap<String, SPCacheModel> allCacheAd = new HashMap<>();
    private static HashMap<Integer, String> allStrategyIdKey = new HashMap<>();
    private static final HashMap<Integer, ArrayList<NestAdData>> allShowAd = new HashMap<>();

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0002`\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"Lcom/wifi/ad/core/spstrategy/SPCacheManager$ADComparator;", "Ljava/util/Comparator;", "Lcom/wifi/ad/core/data/NestAdData;", "Lkotlin/Comparator;", "()V", "compare", "", "o1", "o2", "core_release"}, k = 1, mv = {1, 1, 16})
    public static final class ADComparator implements Comparator<NestAdData> {
        @Override // java.util.Comparator
        public int compare(NestAdData o1, NestAdData o2) {
            if (o1 == null) {
                Intrinsics.throwNpe();
            }
            int adCost = o1.getAdCost();
            if (o2 == null) {
                Intrinsics.throwNpe();
            }
            if (adCost > o2.getAdCost()) {
                return -1;
            }
            if (o1.getAdCost() < o2.getAdCost()) {
                return 1;
            }
            if (o1.getAdCost() != o2.getAdCost()) {
                return 0;
            }
            List<SPSDKDspModel> pkcfgById = SPPkManager.INSTANCE.getPkcfgById(o1.getStrategyId(), o1.getAdCost());
            if (pkcfgById == null) {
                return -1;
            }
            List<SPSDKDspModel> list = pkcfgById;
            if (!(!list.isEmpty())) {
                return -1;
            }
            int size = list.size();
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                if (Intrinsics.areEqual(pkcfgById.get(i3).getDspName(), o1.getAdName())) {
                    i = i3;
                } else if (Intrinsics.areEqual(pkcfgById.get(i3).getDspName(), o2.getAdName())) {
                    i2 = i3;
                }
            }
            return i < i2 ? -1 : 1;
        }
    }

    private SPCacheManager() {
    }

    private final void checkCacheAd(List<NestAdData> allAds, SPCacheTimeModel timeModel, String requestId) {
        if (!allAds.isEmpty()) {
            int size = allAds.size();
            if (timeModel != null) {
                timeModel.setAllNum(allAds.size());
            }
            ArrayList arrayList = new ArrayList();
            int size2 = allAds.size();
            for (int i = 0; i < size2; i++) {
                NestAdData nestAdData = allAds.get(i);
                if ((System.currentTimeMillis() / ((long) 1000)) - nestAdData.getLoadAdTime() > nestAdData.getCacheSec() * 60) {
                    arrayList.add(nestAdData);
                    nestAdData.sendLossNotification$core_release(true, 0);
                    WifiLog.d(requestId + " SPAD checkCacheAd 广告过期 需要删除 " + nestAdData.getAdCode());
                }
            }
            if (timeModel != null) {
                timeModel.setFailedNum(arrayList.size());
            }
            allAds.removeAll(arrayList);
            if (timeModel != null) {
                timeModel.setSuccessNum(allAds.size());
            }
            if (allAds.size() > 0 && timeModel != null) {
                timeModel.setMaxEcpm(allAds.get(0).getAdCost());
            }
            WifiLog.d(requestId + " SPAD checkCacheAd 判断广告过期前[缓存池总数] " + size + "  判断广告过期后[缓存池总数] " + allAds.size());
        }
    }

    private final List<NestAdData> collectionAd(List<NestAdData> oldAds, int cacheCount, NestAdData adData) {
        if (oldAds == null) {
            return oldAds;
        }
        Collections.sort(oldAds, new ADComparator());
        eventCacheExt(oldAds, adData);
        ArrayList arrayList = new ArrayList();
        int size = oldAds.size();
        if (oldAds.size() <= cacheCount) {
            cacheCount = size;
        }
        for (int i = 0; i < cacheCount; i++) {
            arrayList.add(oldAds.get(i));
        }
        int size2 = oldAds.size();
        while (cacheCount < size2) {
            oldAds.get(cacheCount).sendLossNotification$core_release(true, 0);
            WifiLog.d("SPAD clearCacheAd SPCacheManager collectionAd 缓存未成功排入该广告 code " + oldAds.get(cacheCount).getAdCode());
            destroyOneAd(oldAds.get(cacheCount));
            cacheCount++;
        }
        return arrayList;
    }

    private final void destroyCacheAd(SPCacheModel spModel) {
        if ((spModel != null ? spModel.getAllAds() : null) != null) {
            int size = (spModel != null ? spModel.getAllAds() : null).size();
            for (int i = 0; i < size; i++) {
                destroyOneAd((spModel != null ? spModel.getAllAds() : null).get(i));
            }
        }
    }

    private final void destroyShowAd(int scene) {
        try {
            HashMap<Integer, ArrayList<NestAdData>> map = allShowAd;
            if (map.containsKey(Integer.valueOf(scene))) {
                ArrayList<NestAdData> arrayList = map.get(Integer.valueOf(scene));
                if (arrayList == null) {
                    Intrinsics.throwNpe();
                }
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    NestAdData nestAdData = arrayList.get(i);
                    Intrinsics.checkExpressionValueIsNotNull(nestAdData, "adList!![i]");
                    destroyOneAd(nestAdData);
                }
                arrayList.clear();
                allShowAd.remove(Integer.valueOf(scene));
            }
        } catch (Exception unused) {
        }
    }

    private final boolean isContainsLetter(String input) {
        if (TextUtils.isEmpty(input)) {
            return false;
        }
        return Pattern.compile(".*[a-zA-Z]+.*").matcher(input).matches();
    }

    private final void saveRealEcpm(NestAdData nestAdData) {
        Boolean boolValueOf;
        if (nestAdData != null && Intrinsics.areEqual(nestAdData.getAdType(), SDKAlias.GDT.getType())) {
            String adRealLevelName = nestAdData.getAdRealLevelName();
            if (adRealLevelName == null || adRealLevelName.length() == 0) {
                return;
            }
            try {
                String adRealLevelName2 = nestAdData.getAdRealLevelName();
                if (adRealLevelName2 == null) {
                    Intrinsics.throwNpe();
                }
                if (isContainsLetter(adRealLevelName2)) {
                    HashMap<String, Integer> ecpmMap = nestAdData.getEcpmMap();
                    Integer num = null;
                    if (ecpmMap != null) {
                        String adRealLevelName3 = nestAdData.getAdRealLevelName();
                        if (adRealLevelName3 == null) {
                            Intrinsics.throwNpe();
                        }
                        boolValueOf = Boolean.valueOf(ecpmMap.containsKey(adRealLevelName3));
                    } else {
                        boolValueOf = null;
                    }
                    if (boolValueOf.booleanValue()) {
                        HashMap<String, Integer> ecpmMap2 = nestAdData.getEcpmMap();
                        if (ecpmMap2 != null) {
                            String adRealLevelName4 = nestAdData.getAdRealLevelName();
                            if (adRealLevelName4 == null) {
                                Intrinsics.throwNpe();
                            }
                            num = ecpmMap2.get(adRealLevelName4);
                        }
                        if (num == null) {
                            Intrinsics.throwNpe();
                        }
                        nestAdData.setAdCost(num.intValue());
                        return;
                    }
                }
                String adRealLevelName5 = nestAdData.getAdRealLevelName();
                if (adRealLevelName5 == null) {
                    Intrinsics.throwNpe();
                }
                nestAdData.setAdCost(Integer.parseInt(adRealLevelName5));
            } catch (Exception unused) {
            }
        }
    }

    private final void saveShowAd(NestAdData adData) {
        if (adData != null) {
            try {
                int adScene = adData.getAdScene();
                WifiLog.d("$ SPAD clearCacheAd SPCacheManager saveShowAd scene " + adScene + " code " + adData.getAdCode());
                HashMap<Integer, ArrayList<NestAdData>> map = allShowAd;
                if (!map.containsKey(Integer.valueOf(adScene))) {
                    ArrayList<NestAdData> arrayList = new ArrayList<>();
                    arrayList.add(adData);
                    map.put(Integer.valueOf(adScene), arrayList);
                } else {
                    ArrayList<NestAdData> arrayList2 = map.get(Integer.valueOf(adScene));
                    if (arrayList2 == null) {
                        Intrinsics.throwNpe();
                    }
                    if (arrayList2.contains(adData)) {
                        return;
                    }
                    arrayList2.add(adData);
                }
            } catch (Exception unused) {
            }
        }
    }

    public final boolean canShowDhRedDot(Context context, String strategyId) {
        try {
            String dhRedDotStrategy = new SPAdAllConfigMg(context).getDhRedDotStrategy();
            Intrinsics.checkExpressionValueIsNotNull(dhRedDotStrategy, "dhRedDotStrategy");
            if (dhRedDotStrategy.length() > 0) {
                String dhStrategyId = new JSONObject(dhRedDotStrategy).optString(EventParams.KEY_STRATEGY_ID);
                Intrinsics.checkExpressionValueIsNotNull(dhStrategyId, "dhStrategyId");
                if (dhStrategyId.length() > 0) {
                    if (strategyId.length() > 0) {
                        return !Intrinsics.areEqual(dhRedDotStrategy, strategyId);
                    }
                }
            }
        } catch (Exception unused) {
        }
        return true;
    }

    public final NestAdData changeCheckMaxAd(NestAdData oldAdData) {
        AdParams adParams;
        Map<String, String> ext;
        NestAdData nestAdDataFindAndDispatchCacheAd;
        AdParams adParams2;
        Map<String, String> ext2;
        removeHWAdByCache(oldAdData.getUseRequestId(), oldAdData.getStrategyId());
        String requestId = oldAdData.getRequestId();
        if (oldAdData.getAdSPStrategy() && oldAdData.getStrategyId() != null) {
            String useRequestId = oldAdData.getUseRequestId();
            if (oldAdData.getAdStrategyOptimizeSwitch() == 1) {
                String strategyId = oldAdData.getStrategyId();
                if (strategyId == null) {
                    Intrinsics.throwNpe();
                }
                nestAdDataFindAndDispatchCacheAd = findAndDispatchCacheAdNew(strategyId, null, requestId, oldAdData);
            } else {
                String strategyId2 = oldAdData.getStrategyId();
                if (strategyId2 == null) {
                    Intrinsics.throwNpe();
                }
                nestAdDataFindAndDispatchCacheAd = findAndDispatchCacheAd(strategyId2, null, requestId, oldAdData);
            }
            if (nestAdDataFindAndDispatchCacheAd != null && (!Intrinsics.areEqual(nestAdDataFindAndDispatchCacheAd, oldAdData))) {
                nestAdDataFindAndDispatchCacheAd.setChangeType(1);
                if (requestId != null && (adParams2 = nestAdDataFindAndDispatchCacheAd.getAdParams()) != null && (ext2 = adParams2.getExt()) != null) {
                    ext2.put("newRequestId", requestId);
                }
                if (SPPriceEventManager.INSTANCE.allow45488() && !TextUtils.isEmpty(useRequestId)) {
                    nestAdDataFindAndDispatchCacheAd.setUseRequestId(useRequestId);
                }
                WifiLog.d(requestId + " SPAD changeCheckMaxAd 更换完成 老nestAdData " + oldAdData.getAdCode() + " 新adData " + nestAdDataFindAndDispatchCacheAd.getAdCode());
                return nestAdDataFindAndDispatchCacheAd;
            }
        }
        WifiLog.d(requestId + " SPAD changeCheckMaxAd 更换失败，使用 老nestAdData " + oldAdData.getAdCode());
        if (requestId != null && (adParams = oldAdData.getAdParams()) != null && (ext = adParams.getExt()) != null) {
            ext.put("newRequestId", requestId);
        }
        return oldAdData;
    }

    public final NestAdData changeFeedCheckMaxAd(NestAdData oldAdData, List<Integer> supportModes) {
        Map<String, String> ext;
        Map<String, String> ext2;
        String requestId = oldAdData.getRequestId();
        WifiLog.d(requestId + " SPAD changeFeedCheckMaxAd 更换supportModes " + supportModes);
        if (oldAdData.getAdStrategyOptimizeSwitch() == 1) {
            return changeFeedCheckMaxAdNew(oldAdData, supportModes);
        }
        if (oldAdData.getAdSPStrategy() && oldAdData.getStrategyId() != null) {
            String useRequestId = oldAdData.getUseRequestId();
            HashMap<String, SPCacheModel> map = allCacheAd;
            String strategyId = oldAdData.getStrategyId();
            if (strategyId == null) {
                Intrinsics.throwNpe();
            }
            if (map.containsKey(strategyId)) {
                HashMap<String, SPCacheModel> map2 = allCacheAd;
                String strategyId2 = oldAdData.getStrategyId();
                if (strategyId2 == null) {
                    Intrinsics.throwNpe();
                }
                SPCacheModel sPCacheModel = map2.get(strategyId2);
                if (sPCacheModel != null && sPCacheModel.getAllAds() != null) {
                    if (sPCacheModel.getAllAds() == null) {
                        Intrinsics.throwNpe();
                    }
                    if (!r5.isEmpty()) {
                        List<NestAdData> allAds = sPCacheModel.getAllAds();
                        if (allAds == null) {
                            Intrinsics.throwNpe();
                        }
                        checkCacheAd(allAds, null, requestId);
                        WifiLog.d(requestId + " SPAD SPCacheManager changeFeedCheckMaxAd 缓存池现有个数 " + sPCacheModel.getAllAds().size());
                        List<NestAdData> allAds2 = sPCacheModel.getAllAds();
                        if (allAds2 == null) {
                            Intrinsics.throwNpe();
                        }
                        int size = allAds2.size();
                        for (int i = 0; i < size; i++) {
                            List<NestAdData> allAds3 = sPCacheModel.getAllAds();
                            if (allAds3 == null) {
                                Intrinsics.throwNpe();
                            }
                            NestAdData nestAdData = allAds3.get(i);
                            WifiLog.d(requestId + " SPAD changeFeedCheckMaxAd 更换newAdData adMode " + nestAdData.getAdMode() + " i " + i);
                            if ((!Intrinsics.areEqual(nestAdData, oldAdData)) && CollectionsKt___CollectionsKt.contains(supportModes, nestAdData.getAdMode())) {
                                nestAdData.setChangeType(1);
                                WifiLog.d(requestId + " SPAD changeFeedCheckMaxAd 更换完成 老nestAdData " + oldAdData.getAdCode() + " 新adData " + nestAdData.getAdCode());
                                AdParams adParams = nestAdData.getAdParams();
                                if (adParams != null && (ext2 = adParams.getExt()) != null) {
                                    if (requestId == null) {
                                        Intrinsics.throwNpe();
                                    }
                                    ext2.put("newRequestId", requestId);
                                }
                                if (SPPriceEventManager.INSTANCE.allow45488() && !TextUtils.isEmpty(useRequestId)) {
                                    nestAdData.setUseRequestId(useRequestId);
                                }
                                return nestAdData;
                            }
                        }
                    }
                }
            }
        }
        WifiLog.d(requestId + " SPAD changeFeedCheckMaxAd 更换失败，使用 老nestAdData " + oldAdData.getAdCode());
        AdParams adParams2 = oldAdData.getAdParams();
        if (adParams2 != null && (ext = adParams2.getExt()) != null) {
            if (requestId == null) {
                Intrinsics.throwNpe();
            }
            ext.put("newRequestId", requestId);
        }
        return oldAdData;
    }

    public final NestAdData changeFeedCheckMaxAdNew(NestAdData oldAdData, List<Integer> supportModes) {
        AdParams adParams;
        Map<String, String> ext;
        AdParams adParams2;
        Map<String, String> ext2;
        String requestId = oldAdData.getRequestId();
        WifiLog.d(requestId + " SPAD changeFeedCheckMaxAdNew 更换supportModes " + supportModes);
        if (oldAdData.getAdSPStrategy() && oldAdData.getStrategyId() != null) {
            String useRequestId = oldAdData.getUseRequestId();
            HashMap<String, SPCacheModel> map = allCacheAd;
            String strategyId = oldAdData.getStrategyId();
            if (strategyId == null) {
                Intrinsics.throwNpe();
            }
            if (map.containsKey(strategyId)) {
                HashMap<String, SPCacheModel> map2 = allCacheAd;
                String strategyId2 = oldAdData.getStrategyId();
                if (strategyId2 == null) {
                    Intrinsics.throwNpe();
                }
                SPCacheModel sPCacheModel = map2.get(strategyId2);
                if (sPCacheModel != null && sPCacheModel.getAllAds() != null) {
                    if (sPCacheModel.getAllAds() == null) {
                        Intrinsics.throwNpe();
                    }
                    if (!r4.isEmpty()) {
                        List<NestAdData> allAds = sPCacheModel.getAllAds();
                        if (allAds == null) {
                            Intrinsics.throwNpe();
                        }
                        checkCacheAd(allAds, null, requestId);
                        WifiLog.d(requestId + " SPAD SPCacheManager changeFeedCheckMaxAdNew 缓存池现有个数 " + sPCacheModel.getAllAds().size());
                        List<NestAdData> allAds2 = sPCacheModel.getAllAds();
                        if (allAds2 == null) {
                            Intrinsics.throwNpe();
                        }
                        int size = allAds2.size();
                        for (int i = 0; i < size; i++) {
                            List<NestAdData> allAds3 = sPCacheModel.getAllAds();
                            if (allAds3 == null) {
                                Intrinsics.throwNpe();
                            }
                            NestAdData nestAdData = allAds3.get(i);
                            WifiLog.d(requestId + " SPAD changeFeedCheckMaxAdNew 更换newAdData adMode " + nestAdData.getAdMode() + " i " + i);
                            if (CollectionsKt___CollectionsKt.contains(supportModes, nestAdData.getAdMode())) {
                                nestAdData.setChangeType(1);
                                WifiLog.d(requestId + " SPAD changeFeedCheckMaxAdNew 更换完成 老nestAdData " + oldAdData.getAdCode() + " 新adData " + nestAdData.getAdCode());
                                if (requestId != null && (adParams2 = nestAdData.getAdParams()) != null && (ext2 = adParams2.getExt()) != null) {
                                    ext2.put("newRequestId", requestId);
                                }
                                if (SPPriceEventManager.INSTANCE.allow45488() && !TextUtils.isEmpty(useRequestId)) {
                                    nestAdData.setUseRequestId(useRequestId);
                                }
                                return nestAdData;
                            }
                        }
                    }
                }
            }
        }
        WifiLog.d(requestId + " SPAD changeFeedCheckMaxAdNew 更换失败，使用 老nestAdData " + oldAdData.getAdCode());
        if (requestId != null && (adParams = oldAdData.getAdParams()) != null && (ext = adParams.getExt()) != null) {
            ext.put("newRequestId", requestId);
        }
        return oldAdData;
    }

    public final synchronized void clearCacheAd(int scene) {
        try {
            if (WifiNestAd.INSTANCE.getSwitch77583() && allSpSM.containsKey(Integer.valueOf(scene))) {
                SPStrategyManager sPStrategyManager = allSpSM.get(Integer.valueOf(scene));
                if (sPStrategyManager != null) {
                    sPStrategyManager.onDestroy();
                }
                allSpSM.remove(Integer.valueOf(scene));
            }
            if (allStrategyIdKey.containsKey(Integer.valueOf(scene))) {
                String str = allStrategyIdKey.get(Integer.valueOf(scene));
                HashMap<String, SPCacheModel> map = allCacheAd;
                if (map == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
                }
                if (map.containsKey(str)) {
                    destroyCacheAd(allCacheAd.get(str));
                    destroyShowAd(scene);
                    HashMap<String, SPCacheModel> map2 = allCacheAd;
                    if (map2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
                    }
                    TypeIntrinsics.asMutableMap(map2).remove(str);
                    WifiLog.d("clearCacheAd SPAD SPCacheManager scene " + scene + " strategyId " + str + ' ');
                }
            }
        } catch (Exception unused) {
        }
    }

    public final boolean containsData(List<NestAdData> cacheAds, NestAdData adData) {
        int size = cacheAds.size();
        for (int i = 0; i < size; i++) {
            if (Intrinsics.areEqual(adData, cacheAds.get(i))) {
                WifiLog.d("SPAD MDA containsData 不允许加入缓存池");
                return false;
            }
        }
        WifiLog.d("SPAD MDA containsData 允许加入缓存池");
        return true;
    }

    public final boolean containsDataNew(List<NestAdData> cacheAds, NestAdData adData) {
        int size = cacheAds.size();
        for (int i = 0; i < size; i++) {
            if (adData.getRequestId() != null && cacheAds.get(i).getRequestId() != null) {
                String requestId = adData.getRequestId();
                if (requestId == null) {
                    Intrinsics.throwNpe();
                }
                String requestId2 = cacheAds.get(i).getRequestId();
                if (requestId2 == null) {
                    Intrinsics.throwNpe();
                }
                if (Intrinsics.areEqual(requestId, requestId2) && adData.getAdCode() != null && cacheAds.get(i).getAdCode() != null) {
                    String adCode = adData.getAdCode();
                    if (adCode == null) {
                        Intrinsics.throwNpe();
                    }
                    String adCode2 = cacheAds.get(i).getAdCode();
                    if (adCode2 == null) {
                        Intrinsics.throwNpe();
                    }
                    if (Intrinsics.areEqual(adCode, adCode2)) {
                        WifiLog.d("SPAD MDA containsDataNew 不允许加入缓存池 adData.requestId = " + adData.getRequestId() + "; adData.requestId = " + adData.getRequestId() + "; cacheAds[i].requestId = " + cacheAds.get(i).getAdCode() + "; cacheAds[i].requestId = " + cacheAds.get(i).getAdCode());
                        return false;
                    }
                }
            }
        }
        WifiLog.d("SPAD MDA containsDataNew 允许加入缓存池");
        return true;
    }

    public final String createAllAdJson(String strategyId, String requestId, int scene) throws JSONException {
        if (allCacheAd.containsKey(strategyId)) {
            SPCacheModel sPCacheModel = allCacheAd.get(strategyId);
            if (sPCacheModel == null) {
                Intrinsics.throwNpe();
            }
            List<NestAdData> allAds = sPCacheModel.getAllAds();
            if (allAds.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                int size = allAds.size();
                for (int i = 0; i < size; i++) {
                    NestAdData nestAdData = allAds.get(i);
                    JSONObject jSONObject = new JSONObject();
                    if (Intrinsics.areEqual(nestAdData.getZhiboAd(), Boolean.TRUE)) {
                        jSONObject.put(EventParams.KEY_PARAM_BUDGETTYPE, 1);
                    }
                    jSONObject.put(EventParams.KEY_GROUP, nestAdData.getGroupId());
                    jSONObject.put("dspname", nestAdData.getDspName());
                    jSONObject.put("srcid", nestAdData.getAdCode());
                    jSONObject.put("adcost", nestAdData.getAdCost());
                    jSONObject.put(EventParams.KEY_ECPM_RATIO, Float.valueOf(nestAdData.getEcpmRatio()));
                    jSONObject.put(EventParams.KEY_ECPM_LOW_PRICE, nestAdData.getEcpmLowPrice());
                    jSONObject.put(EventParams.KEY_PRICE_SWITCH, nestAdData.getPriceSwitch());
                    jSONObject.put(EventParams.KEY_PRICE_RESPONSE, nestAdData.getPriceResponse());
                    jSONObject.put(EventParams.KEY_LOADAD_TIME, nestAdData.getLoadAdTime());
                    jSONObject.put(EventParams.KEY_USE_REQUESTID, nestAdData.getUseRequestId());
                    jSONObject.put(EventParams.KEY_CREATE_REQUESTID, nestAdData.getCreateRequestId());
                    jSONArray.put(jSONObject);
                }
                String string = jSONArray.toString();
                Intrinsics.checkExpressionValueIsNotNull(string, "adArray.toString()");
                WifiLog.d(requestId + " scene:" + scene + " SPAD SPStrategyManager cache_ext " + string);
                return string;
            }
        }
        return "";
    }

    public final void destroyOneAd(NestAdData adNestData) {
        try {
            WifiLog.d("clearCacheAd destroyOneAd code " + adNestData.getAdCode());
            Object adData = adNestData.getAdData();
            if (adData instanceof IFission) {
                Object adData2 = adNestData.getAdData();
                if (adData2 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.zm.fissionsdk.api.interfaces.IFission");
                }
                ((IFission) adData2).destroy();
            } else if (adData instanceof NativeAd) {
                WifiLog.d("clearCacheAd destroyOneAd beizi NativeAd destroy");
                Object adData3 = adNestData.getAdData();
                if (adData3 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.beizi.fusion.NativeAd");
                }
                ((NativeAd) adData3).destroy();
            } else if (adData instanceof SplashAd) {
                if (WifiNestAd.INSTANCE.getSwitch77583()) {
                    Object adData4 = adNestData.getAdData();
                    if (adData4 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type com.huawei.hms.ads.splash.SplashAd");
                    }
                    SplashView splashViewM57getSplashView = ((SplashAd) adData4).m57getSplashView();
                    if (splashViewM57getSplashView != null) {
                        splashViewM57getSplashView.destroyView();
                    }
                }
            } else if (adData instanceof com.huawei.hms.ads.nativead.NativeAd) {
                if (WifiNestAd.INSTANCE.getSwitch77583()) {
                    Object adData5 = adNestData.getAdData();
                    if (adData5 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type com.huawei.hms.ads.nativead.NativeAd");
                    }
                    ((com.huawei.hms.ads.nativead.NativeAd) adData5).destroy();
                }
            } else if (adData instanceof InterstitialAd) {
                Object adData6 = adNestData.getAdData();
                if (adData6 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.beizi.fusion.InterstitialAd");
                }
                ((InterstitialAd) adData6).destroy();
            } else if (adData instanceof com.huawei.hms.ads.nativead.NativeAd) {
                Object adData7 = adNestData.getAdData();
                if (adData7 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.huawei.hms.ads.nativead.NativeAd");
                }
                ((com.huawei.hms.ads.nativead.NativeAd) adData7).destroy();
            } else if (!(adData instanceof SplashAd)) {
                if (adData instanceof TTNativeExpressAd) {
                    Object adData8 = adNestData.getAdData();
                    if (adData8 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.sdk.openadsdk.TTNativeExpressAd");
                    }
                    ((TTNativeExpressAd) adData8).destroy();
                } else if (adData instanceof TTFeedAd) {
                    Object adData9 = adNestData.getAdData();
                    if (adData9 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.sdk.openadsdk.TTFeedAd");
                    }
                    ((TTFeedAd) adData9).destroy();
                } else if (adData instanceof NativeAdvanceAd) {
                    Object adData10 = adNestData.getAdData();
                    if (adData10 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type com.heytap.msp.mobad.api.ad.NativeAdvanceAd");
                    }
                    ((NativeAdvanceAd) adData10).destroyAd();
                } else if (adData instanceof HotSplashAd) {
                    Object adData11 = adNestData.getAdData();
                    if (adData11 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type com.heytap.msp.mobad.api.ad.HotSplashAd");
                    }
                    ((HotSplashAd) adData11).destroyAd();
                } else if (adData instanceof com.heytap.msp.mobad.api.ad.InterstitialAd) {
                    Object adData12 = adNestData.getAdData();
                    if (adData12 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type com.heytap.msp.mobad.api.ad.InterstitialAd");
                    }
                    ((com.heytap.msp.mobad.api.ad.InterstitialAd) adData12).destroyAd();
                } else if (adData instanceof NativeTempletAd) {
                    Object adData13 = adNestData.getAdData();
                    if (adData13 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type com.heytap.msp.mobad.api.ad.NativeTempletAd");
                    }
                    ((NativeTempletAd) adData13).destroyAd();
                } else if (adData instanceof NativeUnifiedADData) {
                    Object adData14 = adNestData.getAdData();
                    if (adData14 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type com.qq.e.ads.nativ.NativeUnifiedADData");
                    }
                    ((NativeUnifiedADData) adData14).destroy();
                } else if (adData instanceof UnifiedInterstitialAD) {
                    Object adData15 = adNestData.getAdData();
                    if (adData15 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type com.qq.e.ads.interstitial2.UnifiedInterstitialAD");
                    }
                    ((UnifiedInterstitialAD) adData15).destroy();
                } else if (adData instanceof NativeExpressADView) {
                    Object adData16 = adNestData.getAdData();
                    if (adData16 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type com.qq.e.ads.nativ.NativeExpressADView");
                    }
                    ((NativeExpressADView) adData16).destroy();
                }
            }
            adNestData.setAdData(null);
            if (WifiNestAd.INSTANCE.getSwitch77583()) {
                adNestData.setSplashBottomArea(null);
                adNestData.setSplashHuaweiView(null);
                adNestData.setOppoPermissionsView(null);
                adNestData.setOppoPrivacyView(null);
                adNestData.setOppoDescView(null);
                adNestData.setAdDownTextView(null);
                adNestData.setAdView(null);
                adNestData.setDataAdapter(null);
                adNestData.setSplashShowListener(null);
                adNestData.setPopshowListener(null);
            }
        } catch (Exception unused) {
        }
    }

    public final void eventCacheExt(List<NestAdData> cacheAds, NestAdData adData) {
        if (cacheAds.size() > 0) {
            try {
                JSONArray jSONArray = new JSONArray();
                int size = cacheAds.size();
                for (int i = 0; i < size; i++) {
                    NestAdData nestAdData = cacheAds.get(i);
                    JSONObject jSONObject = new JSONObject();
                    if (Intrinsics.areEqual(nestAdData.getZhiboAd(), Boolean.TRUE)) {
                        jSONObject.put(EventParams.KEY_PARAM_BUDGETTYPE, 1);
                    }
                    jSONObject.put("dspname", nestAdData.getDspName());
                    jSONObject.put("srcid", nestAdData.getAdCode());
                    jSONObject.put("adcost", nestAdData.getAdCost());
                    jSONObject.put(EventParams.KEY_PRICE_SWITCH, nestAdData.getPriceSwitch());
                    jSONObject.put(EventParams.KEY_PRICE_RESPONSE, nestAdData.getPriceResponse());
                    jSONObject.put(EventParams.KEY_CREATE_REQUESTID, nestAdData.getCreateRequestId());
                    jSONArray.put(jSONObject);
                }
                String string = jSONArray.toString();
                Intrinsics.checkExpressionValueIsNotNull(string, "adArray.toString()");
                AbstractReporter reporter = WifiNestAd.INSTANCE.getReporter();
                EventParams eventParamsBuild = new EventParams.Builder().setCreateRequestId(adData.getCreateRequestId()).setSdkFrom(adData.getSdkFrom()).setInventoryId(adData.getInventoryId()).setScene(String.valueOf(adData.getAdScene())).setSrcId(adData.getAdCode()).setCacheSize(adData.getCacheCount()).setFreezeTime(adData.getFreezetime()).setAdCost(adData.getAdCost()).setStrategyId(adData.getStrategyId()).setRequestId(adData.getRequestId()).setUseRequestId(adData.getUseRequestId()).setCacheExt(string).build();
                Intrinsics.checkExpressionValueIsNotNull(eventParamsBuild, "EventParams.Builder()\n  …cheExt(cache_ext).build()");
                AdParams adParams = adData.getAdParams();
                reporter.onEvent(WifiNestConst.EventKey.NEST_SDK_AD_INCACHE, eventParamsBuild, adParams != null ? adParams.getExt() : null);
                WifiLog.d("SPAD SPStrategyManager eventCacheExt nest_sdk_ad_incache cache_ext " + string);
            } catch (Exception unused) {
            }
        }
    }

    public final int findAllCacheAdSie(String strategyId) {
        if (!allCacheAd.containsKey(strategyId)) {
            return 0;
        }
        SPCacheModel sPCacheModel = allCacheAd.get(strategyId);
        if (sPCacheModel == null) {
            Intrinsics.throwNpe();
        }
        return sPCacheModel.getAllAds().size();
    }

    public final synchronized NestAdData findAndDispatchCacheAd(String strategyId, SPCacheTimeModel timeMdaModel, String requestId, NestAdData oldAdData) {
        SPCacheModel sPCacheModel;
        int adCost = 0;
        NestAdData nestAdData = null;
        if (allCacheAd.containsKey(strategyId) && (sPCacheModel = allCacheAd.get(strategyId)) != null && sPCacheModel.getAllAds() != null) {
            if (sPCacheModel.getAllAds() == null) {
                Intrinsics.throwNpe();
            }
            if (!r0.isEmpty()) {
                WifiLog.d(requestId + " SPAD SPCacheManager findAndDispatchCacheAd 缓存池现有个数 " + sPCacheModel.getAllAds().size());
                List<NestAdData> allAds = sPCacheModel.getAllAds();
                if (allAds == null) {
                    Intrinsics.throwNpe();
                }
                checkCacheAd(allAds, timeMdaModel, requestId);
                List<NestAdData> allAds2 = sPCacheModel.getAllAds();
                if (allAds2 == null) {
                    Intrinsics.throwNpe();
                }
                int size = allAds2.size();
                if (size > 0) {
                    List<NestAdData> allAds3 = sPCacheModel.getAllAds();
                    if (allAds3 == null) {
                        Intrinsics.throwNpe();
                    }
                    int size2 = allAds3.size();
                    int i = 0;
                    while (true) {
                        if (i >= size2) {
                            break;
                        }
                        List<NestAdData> allAds4 = sPCacheModel.getAllAds();
                        if (allAds4 == null) {
                            Intrinsics.throwNpe();
                        }
                        NestAdData nestAdData2 = allAds4.get(i);
                        if (nestAdData2 != null) {
                            Boolean adDispatchEd = nestAdData2.getAdDispatchEd();
                            if (adDispatchEd == null) {
                                Intrinsics.throwNpe();
                            }
                            WifiLog.d(requestId + " SPAD SPCacheManager findAndDispatchCacheAd  adCode " + nestAdData2.getAdCode() + " adDispatchEd " + adDispatchEd.booleanValue());
                        }
                        if (nestAdData2 != null) {
                            Boolean adDispatchEd2 = nestAdData2.getAdDispatchEd();
                            if (adDispatchEd2 == null) {
                                Intrinsics.throwNpe();
                            }
                            if (!adDispatchEd2.booleanValue()) {
                                int i2 = i + 1;
                                if (i2 < size) {
                                    List<NestAdData> allAds5 = sPCacheModel.getAllAds();
                                    if (allAds5 == null) {
                                        Intrinsics.throwNpe();
                                    }
                                    NestAdData nestAdData3 = allAds5.get(i2);
                                    if (nestAdData3 != null) {
                                        adCost = nestAdData3.getAdCost();
                                    }
                                }
                                nestAdData = nestAdData2;
                            }
                        }
                        i++;
                    }
                }
            }
        }
        if (nestAdData == null) {
            return oldAdData;
        }
        if (oldAdData == null) {
            nestAdData.setAdDispatchEd(Boolean.TRUE);
            nestAdData.setSecondAdCost$core_release(adCost);
            return nestAdData;
        }
        if (oldAdData.getAdCost() >= nestAdData.getAdCost()) {
            return oldAdData;
        }
        oldAdData.setAdDispatchEd(Boolean.FALSE);
        nestAdData.setAdDispatchEd(Boolean.TRUE);
        nestAdData.setSecondAdCost$core_release(adCost);
        return nestAdData;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ac A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ae A[Catch: all -> 0x00b8, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x000a, B:7:0x0014, B:9:0x001a, B:11:0x0020, B:12:0x0023, B:14:0x002d, B:16:0x0052, B:17:0x0055, B:19:0x005e, B:20:0x0061, B:22:0x0067, B:24:0x006d, B:25:0x0070, B:27:0x0078, B:29:0x007e, B:30:0x0081, B:32:0x0089, B:33:0x008d, B:39:0x00ae), top: B:45:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized NestAdData findAndDispatchCacheAdNew(String strategyId, SPCacheTimeModel timeMdaModel, String requestId, NestAdData oldAdData) {
        NestAdData nestAdData;
        SPCacheModel sPCacheModel;
        int adCost = 0;
        if (!allCacheAd.containsKey(strategyId) || (sPCacheModel = allCacheAd.get(strategyId)) == null || sPCacheModel.getAllAds() == null) {
            nestAdData = null;
            if (nestAdData != null) {
                return oldAdData;
            }
            nestAdData.setAdDispatchEd(Boolean.TRUE);
            nestAdData.setSecondAdCost$core_release(adCost);
            return nestAdData;
        }
        if (sPCacheModel.getAllAds() == null) {
            Intrinsics.throwNpe();
        }
        if (!r0.isEmpty()) {
            WifiLog.d(requestId + " SPAD SPCacheManager findAndDispatchCacheAdNew 缓存池现有个数 " + sPCacheModel.getAllAds().size());
            List<NestAdData> allAds = sPCacheModel.getAllAds();
            if (allAds == null) {
                Intrinsics.throwNpe();
            }
            checkCacheAd(allAds, timeMdaModel, requestId);
            List<NestAdData> allAds2 = sPCacheModel.getAllAds();
            if (allAds2 == null) {
                Intrinsics.throwNpe();
            }
            int size = allAds2.size();
            if (size > 0) {
                List<NestAdData> allAds3 = sPCacheModel.getAllAds();
                if (allAds3 == null) {
                    Intrinsics.throwNpe();
                }
                nestAdData = allAds3.get(0);
                if (size > 1) {
                    List<NestAdData> allAds4 = sPCacheModel.getAllAds();
                    if (allAds4 == null) {
                        Intrinsics.throwNpe();
                    }
                    NestAdData nestAdData2 = allAds4.get(1);
                    if (nestAdData2 != null) {
                        adCost = nestAdData2.getAdCost();
                    }
                }
                WifiLog.d(requestId + " SPAD SPCacheManager findAndDispatchCacheAdNew  adCode " + nestAdData.getAdCode());
            }
            if (nestAdData != null) {
            }
        }
    }

    public final synchronized NestAdData findCacheAd(String strategyId, SPCacheTimeModel timeMdaModel, String requestId, boolean allowDispatch) {
        SPCacheModel sPCacheModel;
        if (allCacheAd.containsKey(strategyId) && (sPCacheModel = allCacheAd.get(strategyId)) != null && sPCacheModel.getAllAds() != null) {
            if (sPCacheModel.getAllAds() == null) {
                Intrinsics.throwNpe();
            }
            if (!r0.isEmpty()) {
                List<NestAdData> allAds = sPCacheModel.getAllAds();
                if (allAds == null) {
                    Intrinsics.throwNpe();
                }
                checkCacheAd(allAds, timeMdaModel, requestId);
                int count = sPCacheModel.getCount();
                if (count == 0) {
                    count = 2;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(requestId);
                sb.append(" SPAD SPCacheManager findCacheAd 缓存池现有个数 ");
                sb.append(sPCacheModel.getAllAds().size());
                sb.append("   缓存池大小 ");
                sb.append(count);
                sb.append(" 58414 ");
                WifiNestAd wifiNestAd = WifiNestAd.INSTANCE;
                sb.append(wifiNestAd.getSwitch58414());
                WifiLog.d(sb.toString());
                if (wifiNestAd.getSwitch58414()) {
                    if (allowDispatch) {
                        List<NestAdData> allAds2 = sPCacheModel.getAllAds();
                        if (allAds2 == null) {
                            Intrinsics.throwNpe();
                        }
                        int size = allAds2.size();
                        for (int i = 0; i < size; i++) {
                            List<NestAdData> allAds3 = sPCacheModel.getAllAds();
                            if (allAds3 == null) {
                                Intrinsics.throwNpe();
                            }
                            Boolean adDispatchEd = allAds3.get(i).getAdDispatchEd();
                            if (adDispatchEd == null) {
                                Intrinsics.throwNpe();
                            }
                            if (!adDispatchEd.booleanValue()) {
                                List<NestAdData> allAds4 = sPCacheModel.getAllAds();
                                if (allAds4 == null) {
                                    Intrinsics.throwNpe();
                                }
                                NestAdData nestAdData = allAds4.get(i);
                                WifiLog.d(requestId + " SPAD SPCacheManager data " + nestAdData + " ii");
                                return nestAdData;
                            }
                        }
                    } else {
                        List<NestAdData> allAds5 = sPCacheModel.getAllAds();
                        if (allAds5 == null) {
                            Intrinsics.throwNpe();
                        }
                        if (allAds5.size() > 0) {
                            List<NestAdData> allAds6 = sPCacheModel.getAllAds();
                            if (allAds6 == null) {
                                Intrinsics.throwNpe();
                            }
                            NestAdData nestAdData2 = allAds6.get(0);
                            WifiLog.d(requestId + " SPAD SPCacheManager data " + nestAdData2);
                            return nestAdData2;
                        }
                    }
                } else {
                    List<NestAdData> allAds7 = sPCacheModel.getAllAds();
                    if (allAds7 == null) {
                        Intrinsics.throwNpe();
                    }
                    int i2 = count - 1;
                    if (allAds7.size() > i2) {
                        List<NestAdData> allAds8 = sPCacheModel.getAllAds();
                        if (allAds8 == null) {
                            Intrinsics.throwNpe();
                        }
                        NestAdData nestAdData3 = allAds8.get(i2);
                        WifiLog.d(requestId + " SPAD SPCacheManager data " + nestAdData3 + " nnnn");
                        return nestAdData3;
                    }
                }
            }
        }
        return null;
    }

    public final synchronized int findCacheAdSize(String strategyId, SPCacheTimeModel timeMdaModel, String requestId) {
        SPCacheModel sPCacheModel;
        if (allCacheAd.containsKey(strategyId) && (sPCacheModel = allCacheAd.get(strategyId)) != null && sPCacheModel.getAllAds() != null) {
            if (sPCacheModel.getAllAds() == null) {
                Intrinsics.throwNpe();
            }
            if (!r0.isEmpty()) {
                WifiLog.d(requestId + " SPAD SPCacheManager findCacheAdSize 缓存池现有个数 " + sPCacheModel.getAllAds().size());
                List<NestAdData> allAds = sPCacheModel.getAllAds();
                if (allAds == null) {
                    Intrinsics.throwNpe();
                }
                checkCacheAd(allAds, timeMdaModel, requestId);
                List<NestAdData> allAds2 = sPCacheModel.getAllAds();
                if (allAds2 == null) {
                    Intrinsics.throwNpe();
                }
                return allAds2.size();
            }
        }
        return 0;
    }

    public final synchronized NestAdData findCacheMaxAd(String strategyId, SPCacheTimeModel timeMdaModel, String requestId) {
        SPCacheModel sPCacheModel;
        if (allCacheAd.containsKey(strategyId) && (sPCacheModel = allCacheAd.get(strategyId)) != null && sPCacheModel.getAllAds() != null) {
            if (sPCacheModel.getAllAds() == null) {
                Intrinsics.throwNpe();
            }
            if (!r0.isEmpty()) {
                List<NestAdData> allAds = sPCacheModel.getAllAds();
                if (allAds == null) {
                    Intrinsics.throwNpe();
                }
                checkCacheAd(allAds, timeMdaModel, requestId);
                List<NestAdData> allAds2 = sPCacheModel.getAllAds();
                if (allAds2 == null) {
                    Intrinsics.throwNpe();
                }
                if (allAds2.size() > 0) {
                    List<NestAdData> allAds3 = sPCacheModel.getAllAds();
                    if (allAds3 == null) {
                        Intrinsics.throwNpe();
                    }
                    return allAds3.get(0);
                }
            }
        }
        return null;
    }

    public final NestAdData findCacheMaxAdByScene(int scene) {
        try {
            if (allStrategyIdKey.containsKey(Integer.valueOf(scene))) {
                String str = allStrategyIdKey.get(Integer.valueOf(scene));
                WifiLog.d("findCacheMaxAdByScene SPAD SPCacheManager scene " + scene + " strategyId " + str + ' ');
                HashMap<String, SPCacheModel> map = allCacheAd;
                if (map == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
                }
                if (map.containsKey(str)) {
                    SPCacheModel sPCacheModel = allCacheAd.get(str);
                    if ((sPCacheModel != null ? sPCacheModel.getAllAds() : null) != null) {
                        if ((sPCacheModel != null ? sPCacheModel.getAllAds() : null).size() > 0) {
                            return (sPCacheModel != null ? sPCacheModel.getAllAds() : null).get(0);
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public final int findCacheSizeAdByScene(int scene) {
        try {
            if (!allStrategyIdKey.containsKey(Integer.valueOf(scene))) {
                return 0;
            }
            String str = allStrategyIdKey.get(Integer.valueOf(scene));
            WifiLog.d("findCacheSizeAdByScene SPAD SPCacheManager scene " + scene + " strategyId " + str + ' ');
            HashMap<String, SPCacheModel> map = allCacheAd;
            if (map == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
            }
            if (!map.containsKey(str)) {
                return 0;
            }
            SPCacheModel sPCacheModel = allCacheAd.get(str);
            if ((sPCacheModel != null ? sPCacheModel.getAllAds() : null) != null) {
                return (sPCacheModel != null ? sPCacheModel.getAllAds() : null).size();
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    public final HashMap<String, SPCacheModel> getAllCacheAd() {
        return allCacheAd;
    }

    public final HashMap<Integer, ArrayList<NestAdData>> getAllShowAd() {
        return allShowAd;
    }

    public final HashMap<Integer, SPStrategyManager> getAllSpSM() {
        return allSpSM;
    }

    public final void removeHWAdByCache(String useRequestId, String strategyId) {
        SPCacheModel sPCacheModel;
        if (!WifiNestAd.INSTANCE.getSwitch70647() || useRequestId == null || strategyId == null || !allCacheAd.containsKey(strategyId) || (sPCacheModel = allCacheAd.get(strategyId)) == null || sPCacheModel.getAllAds() == null) {
            return;
        }
        if (sPCacheModel.getAllAds() == null) {
            Intrinsics.throwNpe();
        }
        if (!r0.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            WifiLog.d("useRequestId " + useRequestId + " SPAD SPCacheManager removeHWAdByCache 缓存池现有个数 " + sPCacheModel.getAllAds().size());
            List<NestAdData> allAds = sPCacheModel.getAllAds();
            if (allAds == null) {
                Intrinsics.throwNpe();
            }
            int size = allAds.size();
            for (int i = 0; i < size; i++) {
                List<NestAdData> allAds2 = sPCacheModel.getAllAds();
                if (allAds2 == null) {
                    Intrinsics.throwNpe();
                }
                NestAdData nestAdData = allAds2.get(i);
                if (Intrinsics.areEqual(nestAdData.getAdType(), SDKAlias.HUAWEI.getType()) && (!Intrinsics.areEqual(useRequestId, nestAdData.getCreateRequestId()))) {
                    WifiLog.d("useRequestId " + useRequestId + " SPAD SPCacheManager removeHWAdByCache 找到该华为缓存广告 " + nestAdData);
                    arrayList.add(nestAdData);
                }
            }
            if (arrayList.size() <= 0) {
                WifiLog.d("useRequestId " + useRequestId + " SPAD SPCacheManager removeHWAdByCache 无华为缓存广告可以删除 ");
                return;
            }
            sPCacheModel.getAllAds().removeAll(arrayList);
            WifiLog.d("useRequestId " + useRequestId + " SPAD SPCacheManager removeHWAdByCache 删除华为缓存广告成功 size " + arrayList.size());
        }
    }

    public final synchronized void removeShowAd(NestAdData adData) {
        if (adData.getStrategyId() != null) {
            HashMap<String, SPCacheModel> map = allCacheAd;
            String strategyId = adData.getStrategyId();
            if (strategyId == null) {
                Intrinsics.throwNpe();
            }
            if (map.containsKey(strategyId)) {
                String requestId = adData.getRequestId();
                HashMap<String, SPCacheModel> map2 = allCacheAd;
                String strategyId2 = adData.getStrategyId();
                if (strategyId2 == null) {
                    Intrinsics.throwNpe();
                }
                SPCacheModel sPCacheModel = map2.get(strategyId2);
                StringBuilder sb = new StringBuilder();
                sb.append(requestId);
                sb.append(" SPAD SPCacheManager removeShowAd 缓存池原先个数 ");
                if (sPCacheModel == null) {
                    Intrinsics.throwNpe();
                }
                sb.append(sPCacheModel.getAllAds().size());
                WifiLog.d(sb.toString());
                if (sPCacheModel.getAllAds().contains(adData)) {
                    sPCacheModel.getAllAds().remove(adData);
                    WifiLog.d(requestId + " SPAD removeShowAd clearCacheAd 删除缓存Ad adData.strategyId " + adData.getStrategyId() + " adData.code " + adData.getAdCode());
                    saveShowAd(adData);
                }
                WifiLog.d(requestId + " SPAD SPCacheManager removeShowAd 缓存池删除后 " + sPCacheModel.getAllAds().size());
            }
        }
    }

    public final synchronized void saveCacheAd(NestAdData adData, String requestId, int adScene) {
        SPCacheManager sPCacheManager = INSTANCE;
        sPCacheManager.saveRealEcpm(adData);
        String strategyId = adData.getStrategyId();
        if (strategyId == null) {
            Intrinsics.throwNpe();
        }
        String strCreateAllAdJson = sPCacheManager.createAllAdJson(strategyId, requestId, adScene);
        String strategyId2 = adData.getStrategyId();
        WifiLog.d(requestId + " scene:" + adScene + " SPAD clearCacheAd SPCacheManager saveCacheAd strategyId " + strategyId2 + " code " + adData.getAdCode());
        int adCost = 0;
        if (!(strategyId2 == null || strategyId2.length() == 0)) {
            JSONArray jSONArrayFindAllCacheAd = SPPriceEventManager.INSTANCE.findAllCacheAd(adScene, strategyId2);
            if (allCacheAd.containsKey(strategyId2)) {
                WifiLog.d(requestId + " scene:" + adScene + " SPAD SPCacheManager saveCacheAd 缓存中有该策略ID");
                SPCacheModel sPCacheModel = allCacheAd.get(strategyId2);
                if (sPCacheModel != null) {
                    int count = sPCacheModel.getCount();
                    WifiLog.d(requestId + " scene:" + adScene + " SPAD SPCacheManager saveCacheAd 该策略id允许缓存的广告数 " + count);
                    List<NestAdData> allAds = sPCacheModel.getAllAds();
                    if (allAds != null) {
                        if (adData.getAdStrategyOptimizeSwitch() == 1 ? sPCacheManager.containsDataNew(allAds, adData) : sPCacheManager.containsData(allAds, adData)) {
                            allAds.add(adData);
                            sPCacheModel.setAllAds(sPCacheManager.collectionAd(allAds, count, adData));
                            WifiLog.d(requestId + " scene:" + adScene + " SPAD SPCacheManager saveCacheAd 缓存重新排序后总个数为 " + sPCacheModel.getAllAds().size());
                            int size = sPCacheModel.getAllAds().size();
                            for (int i = 0; i < size; i++) {
                                WifiLog.d(requestId + " scene:" + adScene + " SPAD SPCacheManager saveCacheAd 缓存后重新排序为adcode  " + sPCacheModel.getAllAds().get(i).getAdCode() + " ecpm " + sPCacheModel.getAllAds().get(i).getAdCost());
                            }
                        }
                    }
                }
            } else {
                WifiLog.d(requestId + " scene:" + adScene + " strategyId " + strategyId2 + " SPAD SPCacheManager saveCacheAd 缓存中无该策略ID 创建新的");
                SPCacheModel sPCacheModel2 = new SPCacheModel();
                sPCacheModel2.setCount(adData.getCacheCount());
                sPCacheModel2.setStrategyId(adData.getStrategyId());
                ArrayList arrayList = new ArrayList();
                arrayList.add(adData);
                sPCacheModel2.setAllAds(arrayList);
                allCacheAd.put(strategyId2, sPCacheModel2);
                allStrategyIdKey.put(Integer.valueOf(adScene), strategyId2);
            }
            SPPriceEventManager sPPriceEventManager = SPPriceEventManager.INSTANCE;
            sPPriceEventManager.eventPushCache(adData, jSONArrayFindAllCacheAd, sPPriceEventManager.findAllCacheAd(adScene, strategyId2), requestId);
        }
        if (allCacheAd.get(adData.getStrategyId()) != null) {
            SPCacheModel sPCacheModel3 = allCacheAd.get(adData.getStrategyId());
            if (sPCacheModel3 == null) {
                Intrinsics.throwNpe();
            }
            if (sPCacheModel3.getAllAds().size() > 0) {
                SPCacheModel sPCacheModel4 = allCacheAd.get(adData.getStrategyId());
                if (sPCacheModel4 == null) {
                    Intrinsics.throwNpe();
                }
                adCost = sPCacheModel4.getAllAds().get(0).getAdCost();
            }
        }
        boolean zAreEqual = Intrinsics.areEqual(adData.getZhiboAd(), Boolean.TRUE);
        WifiLog.d(requestId + " scene:" + adScene + " SPAD MDA saveCacheAd nest_sdk_ad_pk_update_cache");
        AbstractReporter reporter = WifiNestAd.INSTANCE.getReporter();
        EventParams.Builder cacheExt = new EventParams.Builder().setStrategyId(adData.getStrategyId()).setStrategyVer(adData.getStrategyVer()).setAbTypeStatus(adData.getStartegyTaiChi()).setCacheSize(adData.getCacheCount()).setFreezeTime(adData.getFreezetime()).setGroup(adData.getGroupId()).setDspName(adData.getDspName()).setBudgetType(zAreEqual ? 1 : 0).setEcpmLowPrice(adData.getEcpmLowPrice()).setPriceSwitch(adData.getPriceSwitch()).setPriceResponse(adData.getPriceResponse()).setEcpmRatio(adData.getEcpmRatio()).setUseRequestId(adData.getUseRequestId()).setCreateRequestId(adData.getCreateRequestId()).setAdCost(adData.getAdCost()).setSrcId(adData.getAdCode()).setCacheExt(strCreateAllAdJson);
        SPCacheManager sPCacheManager2 = INSTANCE;
        String strategyId3 = adData.getStrategyId();
        if (strategyId3 == null) {
            Intrinsics.throwNpe();
        }
        EventParams eventParamsBuild = cacheExt.setCacheExtNew(sPCacheManager2.createAllAdJson(strategyId3, requestId, adScene)).setCacheMaxEcpm(adCost).build();
        Intrinsics.checkExpressionValueIsNotNull(eventParamsBuild, "EventParams.Builder()\n  …                 .build()");
        AdParams adParams = adData.getAdParams();
        if (adParams == null) {
            Intrinsics.throwNpe();
        }
        reporter.onEvent(WifiNestConst.EventKey.NEST_AD_PK_UPDATE_CACHE, eventParamsBuild, adParams.getExt());
    }

    public final void setAllCacheAd(HashMap<String, SPCacheModel> map) {
        allCacheAd = map;
    }

    public final void setAllSpSM(HashMap<Integer, SPStrategyManager> map) {
        allSpSM = map;
    }
}
