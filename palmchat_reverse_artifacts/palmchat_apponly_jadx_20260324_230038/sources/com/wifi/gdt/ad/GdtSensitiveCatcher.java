package com.wifi.gdt.ad;

import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.bh;
import com.kuaishou.weapon.p0.t;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.rewardvideo.RewardVideoAD;
import com.qq.e.ads.splash.SplashAD;
import com.qq.e.comm.pi.AdData;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.entity.SensitiveInfo;
import com.wifi.ad.core.utils.ReflectUtils;
import com.wifi.ad.core.utils.WifiLog;
import com.wifi.adsdk.download.LxAdDLManager;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\bJ\u0010\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\nJ \u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\fJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0011J \u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\fJ\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J\u0018\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J\u0018\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J\u0018\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J\u0018\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J\u0018\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J\u0018\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J\u0018\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J\u001a\u0010 \u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J\u001a\u0010!\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J\u001a\u0010\"\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J\u001a\u0010#\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J\u001a\u0010$\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J\u001a\u0010%\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J\u0018\u0010&\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J\u0019\u0010'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0002¢\u0006\u0002\u0010+J\u0018\u0010,\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J\u0018\u0010-\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J\u0018\u0010.\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J\u0012\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010*H\u0002¨\u00062"}, d2 = {"Lcom/wifi/gdt/ad/GdtSensitiveCatcher;", "", "()V", "catchGdtExpressRewardAdSensitive", "Lcom/wifi/ad/core/entity/SensitiveInfo;", "ad", "Lcom/qq/e/ads/rewardvideo/RewardVideoAD;", "catchGdtInterstitialAd", "Lcom/qq/e/ads/interstitial2/UnifiedInterstitialAD;", "catchGdtNativeTemplateAd", "Lcom/qq/e/ads/nativ/NativeUnifiedADData;", "catchGdtNativeTemplateAds", "", "adList", "catchGdtSplashAd", "Lcom/qq/e/ads/splash/SplashAD;", "catchGdtTemplateAdSensitive", "Lcom/qq/e/ads/nativ/NativeExpressADView;", "catchGdtTemplateAds", "getAppName", "", "extObj", "Lorg/json/JSONObject;", "sensitiveInfo", "getAppName1", "appInfo", "getAuthorName", "getAuthorUrl", "getCoverUrl", "getDesc", "getDomain", "getDownloadUrl", "getGdtCommonFrom4481", "getGdtInterstitialFrom4481", "getGdtNativeFeedFrom4481", "getGdtRewardFrom4481", "getGdtSplashInfoFrom4481", "getGdtTemplateFrom4481", "getH5Url", "getLevel", "", "adRealLevelName", "", "(Ljava/lang/String;)Ljava/lang/Integer;", "getPackageName", "getTitle", "getVideo", "isContainsLetter", "", "input", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
public final class GdtSensitiveCatcher {
    public static final GdtSensitiveCatcher INSTANCE = new GdtSensitiveCatcher();

    private GdtSensitiveCatcher() {
    }

    private final void getAppName(JSONObject extObj, SensitiveInfo sensitiveInfo) {
        if ((extObj != null ? Boolean.valueOf(extObj.has("appname")) : null).booleanValue()) {
            String strOptString = extObj != null ? extObj.optString("appname") : null;
            if (strOptString instanceof String) {
                sensitiveInfo.setAppName(strOptString);
            }
        }
    }

    private final void getAppName1(JSONObject appInfo, SensitiveInfo sensitiveInfo) {
        if ((appInfo != null ? Boolean.valueOf(appInfo.has("appcategoryname")) : null).booleanValue()) {
            Object obj = appInfo != null ? appInfo.get("appcategoryname") : null;
            if (obj instanceof String) {
                sensitiveInfo.setAppName((String) obj);
            }
        }
    }

    private final void getAuthorName(JSONObject appInfo, SensitiveInfo sensitiveInfo) {
        if ((appInfo != null ? Boolean.valueOf(appInfo.has("corporation_name")) : null).booleanValue()) {
            String strOptString = appInfo != null ? appInfo.optString("corporation_name") : null;
            if (strOptString instanceof String) {
                sensitiveInfo.setAuthorName(strOptString);
            }
        }
    }

    private final void getAuthorUrl(JSONObject appInfo, SensitiveInfo sensitiveInfo) {
        if ((appInfo != null ? Boolean.valueOf(appInfo.has("img2")) : null).booleanValue()) {
            Object obj = appInfo != null ? appInfo.get("img2") : null;
            if (obj instanceof String) {
                sensitiveInfo.setAuthorUrl((String) obj);
            }
        }
    }

    private final void getCoverUrl(JSONObject appInfo, SensitiveInfo sensitiveInfo) throws JSONException {
        if ((appInfo != null ? Boolean.valueOf(appInfo.has(bh.Code)) : null).booleanValue()) {
            Object obj = appInfo.get(bh.Code);
            if (obj instanceof String) {
                sensitiveInfo.setCoverUrl((String) obj);
            }
        }
    }

    private final void getDesc(JSONObject appInfo, SensitiveInfo sensitiveInfo) throws JSONException {
        if ((appInfo != null ? Boolean.valueOf(appInfo.has(LxAdDLManager.ITEM_DESC)) : null).booleanValue()) {
            Object obj = appInfo.get(LxAdDLManager.ITEM_DESC);
            if (obj instanceof String) {
                sensitiveInfo.setDesc((String) obj);
            }
        }
    }

    private final void getDomain(JSONObject appInfo, SensitiveInfo sensitiveInfo) {
        if ((appInfo != null ? Boolean.valueOf(appInfo.has("domain")) : null).booleanValue()) {
            Object obj = appInfo != null ? appInfo.get("domain") : null;
            if (obj instanceof String) {
                sensitiveInfo.setPackageName((String) obj);
            }
        }
    }

    private final void getDownloadUrl(JSONObject extObj, SensitiveInfo sensitiveInfo) {
        if ((extObj != null ? Boolean.valueOf(extObj.has("pkgurl")) : null).booleanValue()) {
            String strOptString = extObj != null ? extObj.optString("pkgurl") : null;
            if (strOptString instanceof String) {
                sensitiveInfo.setDownloadUrl(strOptString);
            }
        }
    }

    private final void getGdtCommonFrom4481(Object appInfo, SensitiveInfo sensitiveInfo) throws JSONException {
        JSONObject jSONObjectOptJSONObject;
        if (appInfo != null && (appInfo instanceof JSONObject)) {
            JSONObject jSONObject = (JSONObject) appInfo;
            getCoverUrl(jSONObject, sensitiveInfo);
            getDomain(jSONObject, sensitiveInfo);
            if (TextUtils.isEmpty(sensitiveInfo.getTitle())) {
                getTitle(jSONObject, sensitiveInfo);
            }
            if (TextUtils.isEmpty(sensitiveInfo.getDesc())) {
                getDesc(jSONObject, sensitiveInfo);
            }
            getVideo(jSONObject, sensitiveInfo);
            getAuthorUrl(jSONObject, sensitiveInfo);
            getH5Url(jSONObject, sensitiveInfo);
            getAppName1(jSONObject, sensitiveInfo);
            getAuthorName(jSONObject, sensitiveInfo);
            if (jSONObject.has("ext") && (jSONObjectOptJSONObject = jSONObject.optJSONObject("ext")) != null) {
                getAppName(jSONObjectOptJSONObject, sensitiveInfo);
                getPackageName(jSONObjectOptJSONObject, sensitiveInfo);
                getDownloadUrl(jSONObjectOptJSONObject, sensitiveInfo);
            }
            if (WifiNestAd.INSTANCE.getBackDoorResult()) {
                sensitiveInfo.setShenheSdkId(appInfo.toString());
            }
        }
    }

    private final SensitiveInfo getGdtInterstitialFrom4481(UnifiedInterstitialAD ad, SensitiveInfo sensitiveInfo) {
        Object value;
        Object value2;
        Object value3;
        Object value4;
        if (ad == null) {
            return sensitiveInfo;
        }
        try {
            ReflectUtils reflectUtils = ReflectUtils.INSTANCE;
            Class<? super Object> superclass = ad.getClass().getSuperclass();
            Object value5 = reflectUtils.getValue(ad, superclass != null ? superclass.getSuperclass() : null, "a");
            if (value5 == null || (value = reflectUtils.getValue(value5, "a")) == null || (value2 = reflectUtils.getValue(value, t.l)) == null || (value3 = reflectUtils.getValue(value2, "x")) == null || (value4 = reflectUtils.getValue(value3, value3.getClass().getSuperclass(), "M")) == null) {
                return sensitiveInfo;
            }
            getGdtCommonFrom4481(value4, sensitiveInfo);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sensitiveInfo;
    }

    private final SensitiveInfo getGdtNativeFeedFrom4481(Object ad, SensitiveInfo sensitiveInfo) {
        Object value;
        Object value2;
        if (ad == null) {
            return sensitiveInfo;
        }
        try {
            ReflectUtils reflectUtils = ReflectUtils.INSTANCE;
            Object value3 = reflectUtils.getValue(ad, ad.getClass(), "a");
            if (value3 == null || (value = reflectUtils.getValue(value3, "d")) == null || (value2 = reflectUtils.getValue(value, value.getClass().getSuperclass(), "M")) == null) {
                return sensitiveInfo;
            }
            getGdtCommonFrom4481(value2, sensitiveInfo);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sensitiveInfo;
    }

    private final SensitiveInfo getGdtRewardFrom4481(RewardVideoAD ad, SensitiveInfo sensitiveInfo) {
        Object value;
        Object value2;
        Object value3;
        if (ad == null) {
            return sensitiveInfo;
        }
        try {
            ReflectUtils reflectUtils = ReflectUtils.INSTANCE;
            Class<? super Object> superclass = ad.getClass().getSuperclass();
            Object value4 = reflectUtils.getValue(ad, superclass != null ? superclass.getSuperclass() : null, "a");
            if (value4 == null || (value = reflectUtils.getValue(value4, "c")) == null || (value2 = reflectUtils.getValue(value, "o")) == null || (value3 = reflectUtils.getValue(value2, value2.getClass().getSuperclass(), "L")) == null) {
                return sensitiveInfo;
            }
            getGdtCommonFrom4481(value3, sensitiveInfo);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sensitiveInfo;
    }

    private final SensitiveInfo getGdtSplashInfoFrom4481(SplashAD ad, SensitiveInfo sensitiveInfo) {
        Object value;
        Object value2;
        Object value3;
        Object value4;
        if (ad == null) {
            return sensitiveInfo;
        }
        try {
            ReflectUtils reflectUtils = ReflectUtils.INSTANCE;
            Class superclass = SplashAD.class.getSuperclass();
            Object value5 = reflectUtils.getValue(ad, superclass != null ? superclass.getSuperclass() : null, "a");
            if (value5 == null || (value = reflectUtils.getValue(value5, "a")) == null || (value2 = reflectUtils.getValue(value, "a")) == null || (value3 = reflectUtils.getValue(value2, "t")) == null || (value4 = reflectUtils.getValue(value3, value3.getClass().getSuperclass(), "M")) == null) {
                return sensitiveInfo;
            }
            getGdtCommonFrom4481(value4, sensitiveInfo);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sensitiveInfo;
    }

    private final SensitiveInfo getGdtTemplateFrom4481(NativeExpressADView ad, SensitiveInfo sensitiveInfo) {
        Object value;
        Object value2;
        if (ad == null) {
            return sensitiveInfo;
        }
        try {
            ReflectUtils reflectUtils = ReflectUtils.INSTANCE;
            Object value3 = reflectUtils.getValue(ad, ad.getClass(), "f");
            if (value3 == null || (value = reflectUtils.getValue(value3, value3.getClass().getSuperclass(), t.l)) == null || (value2 = reflectUtils.getValue(value, value.getClass().getSuperclass(), "M")) == null) {
                return sensitiveInfo;
            }
            getGdtCommonFrom4481(value2, sensitiveInfo);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sensitiveInfo;
    }

    private final void getH5Url(JSONObject appInfo, SensitiveInfo sensitiveInfo) {
        if ((appInfo != null ? Boolean.valueOf(appInfo.has("rl")) : null).booleanValue()) {
            Object obj = appInfo != null ? appInfo.get("rl") : null;
            if (obj instanceof String) {
                sensitiveInfo.setH5Url((String) obj);
            }
        }
    }

    private final Integer getLevel(String adRealLevelName) {
        int iIntValue;
        String strSubstring;
        if (TextUtils.isEmpty(adRealLevelName)) {
            return null;
        }
        try {
            if (!isContainsLetter(adRealLevelName)) {
                if (adRealLevelName != null) {
                    return Integer.valueOf(Integer.parseInt(adRealLevelName));
                }
                return null;
            }
            Integer numValueOf = adRealLevelName != null ? Integer.valueOf(adRealLevelName.length()) : null;
            if (numValueOf == null) {
                Intrinsics.throwNpe();
            }
            if (numValueOf.intValue() >= 2) {
                if (adRealLevelName != null) {
                    strSubstring = adRealLevelName.substring(1);
                    Intrinsics.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.String).substring(startIndex)");
                } else {
                    strSubstring = null;
                }
                iIntValue = (strSubstring != null ? Integer.valueOf(Integer.parseInt(strSubstring)) : null).intValue();
            } else {
                iIntValue = -1;
            }
            return Integer.valueOf(iIntValue);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private final void getPackageName(JSONObject extObj, SensitiveInfo sensitiveInfo) {
        if ((extObj != null ? Boolean.valueOf(extObj.has("packagename")) : null).booleanValue()) {
            String strOptString = extObj != null ? extObj.optString("packagename") : null;
            if (strOptString instanceof String) {
                sensitiveInfo.setPackageName(strOptString);
            }
        }
    }

    private final void getTitle(JSONObject appInfo, SensitiveInfo sensitiveInfo) throws JSONException {
        if ((appInfo != null ? Boolean.valueOf(appInfo.has("txt")) : null).booleanValue()) {
            Object obj = appInfo.get("txt");
            if (obj instanceof String) {
                sensitiveInfo.setTitle((String) obj);
            }
        }
    }

    private final void getVideo(JSONObject appInfo, SensitiveInfo sensitiveInfo) {
        if ((appInfo != null ? Boolean.valueOf(appInfo.has("video")) : null).booleanValue()) {
            Object obj = appInfo != null ? appInfo.get("video") : null;
            if (obj instanceof String) {
                sensitiveInfo.setVideoUrl((String) obj);
            }
        }
    }

    private final boolean isContainsLetter(String input) {
        if (TextUtils.isEmpty(input)) {
            return false;
        }
        return Pattern.compile(".*[a-zA-Z]+.*").matcher(input).matches();
    }

    public final SensitiveInfo catchGdtExpressRewardAdSensitive(RewardVideoAD ad) {
        SensitiveInfo sensitiveInfo = new SensitiveInfo();
        try {
            sensitiveInfo.setContentSourceId(String.valueOf(sensitiveInfo.getCONTENT_RESOURCE_GDT_AD()));
            sensitiveInfo.setAdLevel(getLevel(ad.getECPMLevel()));
            getGdtRewardFrom4481(ad, sensitiveInfo);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        WifiLog.d("GdtSensitiveCatcher catchGdtNativeAdSensitive sensitiveInfo = " + sensitiveInfo);
        return sensitiveInfo;
    }

    public final SensitiveInfo catchGdtInterstitialAd(UnifiedInterstitialAD ad) {
        if (ad == null) {
            return null;
        }
        SensitiveInfo sensitiveInfo = new SensitiveInfo();
        try {
            sensitiveInfo.setAdLevel(getLevel(ad.getECPMLevel()));
            sensitiveInfo.setContentSourceId(String.valueOf(sensitiveInfo.getCONTENT_RESOURCE_GDT_AD()));
            getGdtInterstitialFrom4481(ad, sensitiveInfo);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        WifiLog.d("GdtSensitiveCatcher catchGdtInterstitialAd sensitiveInfo = " + sensitiveInfo);
        return sensitiveInfo;
    }

    public final SensitiveInfo catchGdtNativeTemplateAd(NativeUnifiedADData ad) {
        SensitiveInfo sensitiveInfo = new SensitiveInfo();
        try {
            sensitiveInfo.setContentSourceId(String.valueOf(sensitiveInfo.getCONTENT_RESOURCE_GDT_AD()));
            sensitiveInfo.setAdLevel(getLevel(ad.getECPMLevel()));
            String imgUrl = ad.getImgUrl();
            Intrinsics.checkExpressionValueIsNotNull(imgUrl, "ad.imgUrl");
            sensitiveInfo.setCoverUrl(imgUrl);
            String title = ad.getTitle();
            Intrinsics.checkExpressionValueIsNotNull(title, "ad.title");
            sensitiveInfo.setTitle(title);
            String desc = ad.getDesc();
            Intrinsics.checkExpressionValueIsNotNull(desc, "ad.desc");
            sensitiveInfo.setDesc(desc);
            getGdtNativeFeedFrom4481(ad, sensitiveInfo);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        WifiLog.d("GdtSensitiveCatcher catchGdtNativeAdSensitive sensitiveInfo = " + sensitiveInfo);
        return sensitiveInfo;
    }

    public final List<SensitiveInfo> catchGdtNativeTemplateAds(List<? extends Object> adList) {
        NativeUnifiedADData nativeUnifiedADData;
        SensitiveInfo sensitiveInfoCatchGdtNativeTemplateAd;
        List<? extends Object> list = adList;
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : adList) {
            if ((obj instanceof NativeUnifiedADData) && (sensitiveInfoCatchGdtNativeTemplateAd = catchGdtNativeTemplateAd((nativeUnifiedADData = (NativeUnifiedADData) obj))) != null) {
                if (nativeUnifiedADData.isAppAd()) {
                    sensitiveInfoCatchGdtNativeTemplateAd.setInteractionType(1);
                } else {
                    sensitiveInfoCatchGdtNativeTemplateAd.setInteractionType(2);
                }
                arrayList.add(sensitiveInfoCatchGdtNativeTemplateAd);
            }
        }
        return arrayList;
    }

    public final SensitiveInfo catchGdtSplashAd(SplashAD ad) {
        if (ad == null) {
            return null;
        }
        SensitiveInfo sensitiveInfo = new SensitiveInfo();
        try {
            sensitiveInfo.setContentSourceId(String.valueOf(sensitiveInfo.getCONTENT_RESOURCE_GDT_AD()));
            sensitiveInfo.setAdLevel(getLevel(ad.getECPMLevel()));
            getGdtSplashInfoFrom4481(ad, sensitiveInfo);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        WifiLog.d("GdtSensitiveCatcher catchGdtNativeAdSensitive sensitiveInfo = " + sensitiveInfo);
        return sensitiveInfo;
    }

    public final SensitiveInfo catchGdtTemplateAdSensitive(NativeExpressADView ad) {
        SensitiveInfo sensitiveInfo = new SensitiveInfo();
        try {
            sensitiveInfo.setContentSourceId(String.valueOf(sensitiveInfo.getCONTENT_RESOURCE_GDT_AD()));
            AdData boundData = ad.getBoundData();
            sensitiveInfo.setAdLevel(getLevel(boundData != null ? boundData.getECPMLevel() : null));
            AdData boundData2 = ad.getBoundData();
            if (boundData2 != null) {
                String title = boundData2.getTitle();
                Intrinsics.checkExpressionValueIsNotNull(title, "it.title");
                sensitiveInfo.setTitle(title);
                String desc = boundData2.getDesc();
                Intrinsics.checkExpressionValueIsNotNull(desc, "it.desc");
                sensitiveInfo.setDesc(desc);
            }
            getGdtTemplateFrom4481(ad, sensitiveInfo);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        WifiLog.d("GdtSensitiveCatcher catchGdtNativeAdSensitive sensitiveInfo = " + sensitiveInfo);
        return sensitiveInfo;
    }

    public final List<SensitiveInfo> catchGdtTemplateAds(List<? extends NativeExpressADView> adList) {
        SensitiveInfo sensitiveInfoCatchGdtTemplateAdSensitive;
        List<? extends NativeExpressADView> list = adList;
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (NativeExpressADView nativeExpressADView : adList) {
            if ((nativeExpressADView instanceof NativeExpressADView) && (sensitiveInfoCatchGdtTemplateAdSensitive = catchGdtTemplateAdSensitive(nativeExpressADView)) != null) {
                arrayList.add(sensitiveInfoCatchGdtTemplateAdSensitive);
            }
        }
        return arrayList;
    }
}
