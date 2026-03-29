package com.wifi.ad.core.strategy;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.wifi.ad.core.SDKAlias;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.config.AdParams;
import com.wifi.ad.core.config.EventParams;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import com.wifi.ad.core.config.adx.model.WkAdConfigModel;
import com.wifi.ad.core.config.adx.model.WkAdMutliPrice;
import com.wifi.ad.core.data.BlackListFilterData;
import com.wifi.ad.core.data.FilterConfigBean;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.data.NestMixAdLevel;
import com.wifi.ad.core.entity.SensitiveInfo;
import com.wifi.ad.core.p001const.WifiNestConst;
import com.wifi.ad.core.reporter.AbstractReporter;
import com.wifi.ad.core.utils.JsonUtil;
import com.wifi.ad.core.utils.MyComparator;
import com.wifi.ad.core.utils.WifiLog;
import com.wifi.csj.ad.NestCsjProvider;
import com.wifi.ks.ad.NestKsProvider;
import com.wifi.self.ad.NestWifiProvider;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ8\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0006\u0010\u0014\u001a\u00020\u00042\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u000f2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0002J\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eJ\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ2\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00110\u000e2\u0006\u0010\u0014\u001a\u00020\u00042\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0004J\u000e\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0011J\u001e\u0010!\u001a\u00020\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00110\u000e2\u0006\u0010$\u001a\u00020\u0011H\u0002JH\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000e2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020*2\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004H\u0002J \u0010+\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0002J0\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u0001052\u0006\u00106\u001a\u000201J0\u00107\u001a\u0002082\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\b\u00104\u001a\u0004\u0018\u0001052\u0006\u0010 \u001a\u00020\u00112\u0006\u00106\u001a\u000201R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/wifi/ad/core/strategy/StrategySDKManager;", "", "()V", "AD_FROM_CSJ", "", "getAD_FROM_CSJ", "()Ljava/lang/String;", "AD_FROM_KUAISHOU", "getAD_FROM_KUAISHOU", "AD_FROM_WIFI", "getAD_FROM_WIFI", "filterTaiChi", "getFilterTaiChi", "mixAdLevels", "", "Lcom/wifi/ad/core/data/NestMixAdLevel;", "mixAdList", "Lcom/wifi/ad/core/data/NestAdData;", "calculateStrategy", "decodeAdList", "adStrs", "ext", "", "requestId", "determineECPMAdPosition", "curAdLevels", "ecpmAllAd", "ecpmDone", "allAdLevels", "getMixAdLevels", "getMixAds", "getNestAdInfo", "ad", "isValidAd", "", "adLevelDatas", "adData", "parserStrategy", "adLevel", "", "ecpm", "strategyJson", "Lorg/json/JSONArray;", "ratioAds", "setFilterData", "", "filterOn", "Ljava/util/concurrent/atomic/AtomicBoolean;", "leftFilterCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "adParams", "Lcom/wifi/ad/core/config/AdParams;", "filterConfig", "Lcom/wifi/ad/core/data/FilterConfigBean;", "filterCount", "shouldFilter", "Lcom/wifi/ad/core/data/BlackListFilterData;", "core_release"}, k = 1, mv = {1, 1, 16})
public final class StrategySDKManager {
    private List<NestMixAdLevel> mixAdLevels = new ArrayList();
    private List<NestAdData> mixAdList = new ArrayList();
    private final String filterTaiChi = "LX-23772";
    private final String AD_FROM_WIFI = NestWifiProvider.SDK_FROM;
    private final String AD_FROM_KUAISHOU = NestKsProvider.SDK_FROM;
    private final String AD_FROM_CSJ = NestCsjProvider.SDK_FROM;

    private final List<NestMixAdLevel> decodeAdList(String adStrs, Map<String, String> ext, String requestId) {
        this.mixAdLevels.clear();
        this.mixAdList.clear();
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
                int level = nestMixAdLevel.getLevel();
                int ecpm = nestMixAdLevel.getEcpm();
                JSONArray jSONArray3 = jSONObject.getJSONArray("adStrategy");
                Intrinsics.checkExpressionValueIsNotNull(jSONArray3, "jsonObj.getJSONArray(\"adStrategy\")");
                List<NestAdData> list = parserStrategy(level, ecpm, jSONArray3, ext, requestId);
                if (list == null) {
                    return null;
                }
                nestMixAdLevel.setAdStrategy(list);
                List<NestMixAdLevel> list2 = this.mixAdLevels;
                if (list2 != null) {
                    list2.add(nestMixAdLevel);
                }
            }
            WifiLog.d("decodeAdList success");
            return this.mixAdLevels;
        } catch (Exception e) {
            e.printStackTrace();
            WifiLog.d("decodeAdList fail");
            AbstractReporter reporter = WifiNestAd.INSTANCE.getReporter();
            EventParams eventParamsBuild = new EventParams.Builder().setTemplate("decodeAdList").setErrorCode(e.toString()).build();
            Intrinsics.checkExpressionValueIsNotNull(eventParamsBuild, "EventParams.Builder()\n  …                 .build()");
            reporter.onEvent(WifiNestConst.EventKey.NEST_AD_PARSE_STRATEGY_FAIL_ERROR, eventParamsBuild, ext);
            return null;
        }
    }

    private final NestMixAdLevel determineECPMAdPosition(List<NestMixAdLevel> curAdLevels) {
        int iNextInt;
        if (curAdLevels == null || curAdLevels.size() <= 0) {
            return null;
        }
        int size = curAdLevels.size();
        if (size == 1) {
            return curAdLevels.get(0);
        }
        int iIntValue = 0;
        for (int i = 0; i < size; i++) {
            try {
                iIntValue += curAdLevels.get(i).getRatios().get(0).intValue();
            } catch (Exception unused) {
            }
        }
        if (iIntValue > 0) {
            Random random = new Random();
            random.nextInt();
            iNextInt = random.nextInt(iIntValue);
        } else {
            iNextInt = 0;
        }
        int iIntValue2 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            try {
                NestMixAdLevel nestMixAdLevel = curAdLevels.get(i2);
                iIntValue2 += nestMixAdLevel.getRatios().get(0).intValue();
                if (iNextInt < iIntValue2) {
                    curAdLevels.remove(i2);
                    return nestMixAdLevel;
                }
            } catch (Exception unused2) {
                return null;
            }
        }
        return null;
    }

    private final boolean isValidAd(List<NestAdData> adLevelDatas, NestAdData adData) {
        for (NestAdData nestAdData : adLevelDatas) {
            if (TextUtils.equals(nestAdData.getAdCode(), adData.getAdCode()) || StringsKt__StringsJVMKt.equals(nestAdData.getAdLevelName(), adData.getAdLevelName(), true)) {
                return false;
            }
        }
        return true;
    }

    private final List<NestAdData> parserStrategy(int adLevel, int ecpm, JSONArray strategyJson, Map<String, String> ext, String requestId) {
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
                    nestAdData.setDspId(jSONObject.optInt("dspid"));
                    nestAdData.setBlockAd(jSONObject.optInt("block"));
                    nestAdData.setRequestId(requestId);
                    nestAdData.setCreateRequestId(requestId);
                    JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(WkAdConfigModel.TAG_ECPMMAP);
                    if (jSONArrayOptJSONArray != null) {
                        ArrayList arrayList2 = new ArrayList();
                        int length2 = jSONArrayOptJSONArray.length();
                        for (int i2 = 0; i2 < length2; i2++) {
                            WkAdMutliPrice wkAdMutliPrice = new WkAdMutliPrice();
                            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
                            wkAdMutliPrice.setCpmlevel(jSONObjectOptJSONObject.optString(WkAdMutliPrice.TAG_CPMLEVEL));
                            wkAdMutliPrice.setEcpm(jSONObjectOptJSONObject.optInt("ecpm"));
                            wkAdMutliPrice.setRatio(jSONObjectOptJSONObject.optInt("ratio"));
                            arrayList2.add(wkAdMutliPrice);
                        }
                        nestAdData.setEcpmLevelMap(arrayList2);
                    }
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
                                if (isValidAd(this.mixAdList, nestAdData) && (list = this.mixAdList) != null) {
                                    list.add(nestAdData);
                                }
                                arrayList.add(nestAdData);
                            }
                            if (isValidAd(this.mixAdList, nestAdData)) {
                                list.add(nestAdData);
                            }
                            arrayList.add(nestAdData);
                        }
                    }
                }
                WifiLog.d("decodeAdList parserStrategy success");
            } catch (Exception e) {
                e.printStackTrace();
                AbstractReporter reporter = WifiNestAd.INSTANCE.getReporter();
                EventParams eventParamsBuild = new EventParams.Builder().setTemplate("parserStrategy").setErrorCode(e.toString()).build();
                Intrinsics.checkExpressionValueIsNotNull(eventParamsBuild, "EventParams.Builder()\n  …                 .build()");
                reporter.onEvent(WifiNestConst.EventKey.NEST_AD_PARSE_STRATEGY_FAIL_ERROR, eventParamsBuild, ext);
                return null;
            }
        }
        return arrayList;
    }

    private final List<NestMixAdLevel> ratioAds(List<NestMixAdLevel> curAdLevels) {
        if (curAdLevels == null || curAdLevels.size() <= 1) {
            return curAdLevels;
        }
        ArrayList arrayList = new ArrayList();
        int size = curAdLevels.size();
        for (int i = 0; i < size; i++) {
            NestMixAdLevel nestMixAdLevelDetermineECPMAdPosition = determineECPMAdPosition(curAdLevels);
            if (nestMixAdLevelDetermineECPMAdPosition != null) {
                arrayList.add(nestMixAdLevelDetermineECPMAdPosition);
            }
        }
        return arrayList;
    }

    public final List<NestMixAdLevel> calculateStrategy() {
        for (NestMixAdLevel nestMixAdLevel : this.mixAdLevels) {
            nestMixAdLevel.getAdSortStrategy().addAll(nestMixAdLevel.getAdStrategy());
        }
        return this.mixAdLevels;
    }

    public final List<NestMixAdLevel> ecpmAllAd() {
        List<NestMixAdLevel> listEcpmDone = ecpmDone(this.mixAdLevels);
        this.mixAdLevels = listEcpmDone;
        return listEcpmDone;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0121  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<NestMixAdLevel> ecpmDone(List<NestMixAdLevel> allAdLevels) {
        List<NestMixAdLevel> list;
        if (allAdLevels != null) {
            List<NestMixAdLevel> list2 = allAdLevels;
            if (!list2.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                int size = list2.size();
                for (int i = 0; i < size; i++) {
                    NestMixAdLevel nestMixAdLevel = allAdLevels.get(i);
                    if (nestMixAdLevel.getAdSortStrategy() != null && nestMixAdLevel.getAdSortStrategy().size() > 0) {
                        int adCost = nestMixAdLevel.getAdSortStrategy().get(0).getAdCost();
                        if (!arrayList.contains(Integer.valueOf(adCost))) {
                            arrayList.add(Integer.valueOf(adCost));
                        }
                    }
                }
                Collections.sort(arrayList, new MyComparator());
                ArrayList arrayList2 = new ArrayList();
                int size2 = arrayList.size();
                int i2 = 0;
                for (int i3 = 0; i3 < size2; i3++) {
                    int iIntValue = ((Number) arrayList.get(i3)).intValue();
                    ArrayList arrayList3 = new ArrayList();
                    int size3 = list2.size();
                    for (int i4 = 0; i4 < size3; i4++) {
                        NestMixAdLevel nestMixAdLevel2 = allAdLevels.get(i4);
                        if (nestMixAdLevel2.getAdSortStrategy() != null && nestMixAdLevel2.getAdSortStrategy().size() > 0 && nestMixAdLevel2.getAdSortStrategy().get(0).getAdCost() == iIntValue) {
                            arrayList3.add(nestMixAdLevel2);
                        }
                    }
                    List<NestMixAdLevel> listRatioAds = ratioAds(arrayList3);
                    if (listRatioAds == null) {
                        Intrinsics.throwNpe();
                    }
                    int size4 = listRatioAds.size();
                    int i5 = 0;
                    while (i5 < size4) {
                        i2++;
                        NestMixAdLevel nestMixAdLevel3 = listRatioAds.get(i5);
                        if (nestMixAdLevel3.getAdSortStrategy() == null || nestMixAdLevel3.getAdSortStrategy().size() <= 0) {
                            list = list2;
                        } else {
                            NestAdData nestAdData = nestMixAdLevel3.getAdSortStrategy().get(0);
                            String adLevelName = nestAdData.getAdLevelName();
                            if (!TextUtils.isEmpty(adLevelName)) {
                                StringBuilder sb = new StringBuilder();
                                if (adLevelName == null) {
                                    Intrinsics.throwNpe();
                                }
                                if (adLevelName == null) {
                                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                                }
                                list = list2;
                                String strSubstring = adLevelName.substring(0, 1);
                                Intrinsics.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                sb.append(strSubstring);
                                sb.append(i2);
                                String string = sb.toString();
                                nestAdData.setAdLevel(Integer.valueOf(i2));
                                nestAdData.setAdLevelName(string);
                                nestAdData.setAdRealLevelName(string);
                            }
                        }
                        arrayList2.add(nestMixAdLevel3);
                        i5++;
                        list2 = list;
                    }
                }
                return arrayList2;
            }
        }
        if (allAdLevels == null) {
            Intrinsics.throwNpe();
        }
        return allAdLevels;
    }

    public final String getAD_FROM_CSJ() {
        return this.AD_FROM_CSJ;
    }

    public final String getAD_FROM_KUAISHOU() {
        return this.AD_FROM_KUAISHOU;
    }

    public final String getAD_FROM_WIFI() {
        return this.AD_FROM_WIFI;
    }

    public final String getFilterTaiChi() {
        return this.filterTaiChi;
    }

    public final List<NestMixAdLevel> getMixAdLevels() {
        return this.mixAdLevels;
    }

    public final List<NestAdData> getMixAds(String adStrs, Map<String, String> ext, String requestId) {
        List<NestMixAdLevel> listDecodeAdList = decodeAdList(adStrs, ext, requestId);
        if (listDecodeAdList == null || listDecodeAdList.isEmpty()) {
            this.mixAdLevels.clear();
            this.mixAdList.clear();
        }
        return this.mixAdList;
    }

    public final String getNestAdInfo(NestAdData ad) {
        return "{title:" + ad.getTitle() + ",adLogo:" + ad.getAdLogo() + ",adIcon:" + ad.getAdIcon() + ",imageList:" + String.valueOf(ad.getImageList()) + ",sensitiveInfo:" + JsonUtil.INSTANCE.toJson(ad.getSensitiveInfo());
    }

    public final void setFilterData(AtomicBoolean filterOn, AtomicInteger leftFilterCount, AdParams adParams, FilterConfigBean filterConfig, AtomicInteger filterCount) {
        if (filterConfig == null) {
            return;
        }
        filterOn.set(filterConfig.getEnbale() != 0);
        if (TextUtils.isEmpty(adParams.getTaiChikeys())) {
            return;
        }
        String taiChikeys = adParams.getTaiChikeys();
        if (taiChikeys == null) {
            Intrinsics.throwNpe();
        }
        String str = "";
        for (String str2 : StringsKt__StringsKt.split$default((CharSequence) taiChikeys, new String[]{","}, false, 0, 6, (Object) null)) {
            if (StringsKt__StringsJVMKt.startsWith$default(str2, this.filterTaiChi, false, 2, null)) {
                str = str2;
            }
        }
        if (TextUtils.isEmpty(str) || filterConfig.getExt_data() == null) {
            return;
        }
        List<FilterConfigBean.ExtDataBean> ext_data = filterConfig.getExt_data();
        Intrinsics.checkExpressionValueIsNotNull(ext_data, "filterConfig.ext_data");
        for (FilterConfigBean.ExtDataBean it : ext_data) {
            Intrinsics.checkExpressionValueIsNotNull(it, "it");
            if (str.equals(it.getKey())) {
                String val = it.getVal();
                Intrinsics.checkExpressionValueIsNotNull(val, "it.`val`");
                if (Integer.parseInt(val) > 0) {
                    String val2 = it.getVal();
                    Intrinsics.checkExpressionValueIsNotNull(val2, "it.`val`");
                    leftFilterCount.set(Integer.parseInt(val2));
                    filterCount.set(leftFilterCount.get());
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x013b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final BlackListFilterData shouldFilter(AtomicBoolean filterOn, AtomicInteger leftFilterCount, FilterConfigBean filterConfig, NestAdData ad, AtomicInteger filterCount) {
        String str;
        String str2;
        String str3;
        String nestType;
        List<String> words;
        String appName;
        String title;
        List<String> urls;
        String downloadUrl;
        String deepUrl;
        String h5Url;
        List<String> pkglist;
        String packageName;
        SensitiveInfo sensitiveInfo;
        String packageName2;
        if (!filterOn.get()) {
            return new BlackListFilterData(false, 0L);
        }
        if (ad.getSensitiveInfo() == null || filterConfig == null) {
            return new BlackListFilterData(false, 0L);
        }
        if (this.AD_FROM_WIFI.equals(ad.getSdkFrom())) {
            return new BlackListFilterData(false, 0L);
        }
        if (leftFilterCount.get() == Integer.MAX_VALUE) {
            return new BlackListFilterData(false, 0L);
        }
        long jCurrentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        boolean z = leftFilterCount.get() <= 0;
        String str4 = "";
        if (z || (sensitiveInfo = ad.getSensitiveInfo()) == null || (packageName2 = sensitiveInfo.getPackageName()) == null || !StringsKt__StringsKt.contains$default((CharSequence) packageName2, (CharSequence) "com.gmlive", false, 2, (Object) null)) {
            str = "";
        } else {
            SensitiveInfo sensitiveInfo2 = ad.getSensitiveInfo();
            String packageName3 = sensitiveInfo2 != null ? sensitiveInfo2.getPackageName() : null;
            if (packageName3 == null) {
                Intrinsics.throwNpe();
            }
            str = packageName3;
            z = true;
        }
        if (!z && (pkglist = filterConfig.getPkglist()) != null) {
            for (String it : pkglist) {
                SensitiveInfo sensitiveInfo3 = ad.getSensitiveInfo();
                if (sensitiveInfo3 != null && (packageName = sensitiveInfo3.getPackageName()) != null && packageName.equals(it)) {
                    Intrinsics.checkExpressionValueIsNotNull(it, "it");
                    str = it;
                    z = true;
                }
            }
        }
        if (z || (urls = filterConfig.getUrls()) == null) {
            str2 = "";
        } else {
            str2 = "";
            for (String it2 : urls) {
                SensitiveInfo sensitiveInfo4 = ad.getSensitiveInfo();
                if (sensitiveInfo4 == null || (h5Url = sensitiveInfo4.getH5Url()) == null) {
                    SensitiveInfo sensitiveInfo5 = ad.getSensitiveInfo();
                    if (sensitiveInfo5 == null || (deepUrl = sensitiveInfo5.getDeepUrl()) == null) {
                        SensitiveInfo sensitiveInfo6 = ad.getSensitiveInfo();
                        if (sensitiveInfo6 != null && (downloadUrl = sensitiveInfo6.getDownloadUrl()) != null) {
                            Intrinsics.checkExpressionValueIsNotNull(it2, "it");
                            if (StringsKt__StringsKt.contains$default((CharSequence) downloadUrl, (CharSequence) it2, false, 2, (Object) null)) {
                                str2 = it2;
                                z = true;
                            }
                        }
                    } else {
                        Intrinsics.checkExpressionValueIsNotNull(it2, "it");
                        if (!StringsKt__StringsKt.contains$default((CharSequence) deepUrl, (CharSequence) it2, false, 2, (Object) null)) {
                        }
                        str2 = it2;
                        z = true;
                    }
                } else {
                    Intrinsics.checkExpressionValueIsNotNull(it2, "it");
                    if (!StringsKt__StringsKt.contains$default((CharSequence) h5Url, (CharSequence) it2, false, 2, (Object) null)) {
                    }
                    str2 = it2;
                    z = true;
                }
            }
        }
        if (z || (words = filterConfig.getWords()) == null) {
            str3 = "";
        } else {
            str3 = "";
            for (String it3 : words) {
                SensitiveInfo sensitiveInfo7 = ad.getSensitiveInfo();
                if (sensitiveInfo7 == null || (title = sensitiveInfo7.getTitle()) == null) {
                    SensitiveInfo sensitiveInfo8 = ad.getSensitiveInfo();
                    if (sensitiveInfo8 != null && (appName = sensitiveInfo8.getAppName()) != null) {
                        Intrinsics.checkExpressionValueIsNotNull(it3, "it");
                        if (StringsKt__StringsKt.contains$default((CharSequence) appName, (CharSequence) it3, false, 2, (Object) null)) {
                            str3 = it3;
                            z = true;
                        }
                    }
                } else {
                    Intrinsics.checkExpressionValueIsNotNull(it3, "it");
                    if (!StringsKt__StringsKt.contains$default((CharSequence) title, (CharSequence) it3, false, 2, (Object) null)) {
                    }
                    str3 = it3;
                    z = true;
                }
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
                str4 = nestType;
            }
            EventParams.Builder pkgname = adMode2.setNestType(str4).setPkgname(str);
            Integer adLevel = ad.getAdLevel();
            if (adLevel == null) {
                Intrinsics.throwNpe();
            }
            EventParams eventParams = pkgname.setAdLevel(adLevel.intValue()).setDomainName(str2).setSensitiveWords(str3).setNumber(filterCount.toString()).build();
            WifiLog.d(String.valueOf(ad.getSensitiveInfo()));
            AbstractReporter reporter = WifiNestAd.INSTANCE.getReporter();
            Intrinsics.checkExpressionValueIsNotNull(eventParams, "eventParams");
            AdParams adParams2 = ad.getAdParams();
            reporter.onEvent(WifiNestConst.EventKey.NEST_SDK_AD_BLACKLIST, eventParams, adParams2 != null ? adParams2.getExt() : null);
        }
        leftFilterCount.decrementAndGet();
        WifiLog.d("scrn_ shouldFilter=" + z + " 剩余过滤次数" + leftFilterCount.get() + (char) 27425);
        return new BlackListFilterData(z, SystemClock.currentThreadTimeMillis() - jCurrentThreadTimeMillis);
    }
}
