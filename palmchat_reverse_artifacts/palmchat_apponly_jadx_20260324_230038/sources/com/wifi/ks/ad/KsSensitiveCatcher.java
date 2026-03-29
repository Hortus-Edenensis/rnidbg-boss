package com.wifi.ks.ad;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.openalliance.ad.constant.be;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.entity.SensitiveInfo;
import com.wifi.ad.core.utils.WifiLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010\bJ/\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\fJ\u001f\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0010J\u001f\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u00122\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0013J\u001f\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u00152\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0016J\u001f\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u001aJ\u001f\u0010\u001b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u001c2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u001dJ\u001f\u0010\u001e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001f\u001a\u00020 2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010!¨\u0006\""}, d2 = {"Lcom/wifi/ks/ad/KsSensitiveCatcher;", "", "()V", "catchKsAdTemplateSensitive", "Lcom/wifi/ad/core/entity/SensitiveInfo;", "instanceA", "adLevel", "", "(Ljava/lang/Object;Ljava/lang/Integer;)Lcom/wifi/ad/core/entity/SensitiveInfo;", "catchKsDrawVideoAds", "", "adList", "(Ljava/util/List;Ljava/lang/Integer;)Ljava/util/List;", "catchKsExpressTemplateAd", "ad", "Lcom/kwad/sdk/api/KsDrawAd;", "(Lcom/kwad/sdk/api/KsDrawAd;Ljava/lang/Integer;)Lcom/wifi/ad/core/entity/SensitiveInfo;", "catchKsFeedTemplateAd", "Lcom/kwad/sdk/api/KsFeedAd;", "(Lcom/kwad/sdk/api/KsFeedAd;Ljava/lang/Integer;)Lcom/wifi/ad/core/entity/SensitiveInfo;", "catchKsInterstitialAd", "Lcom/kwad/sdk/api/KsInterstitialAd;", "(Lcom/kwad/sdk/api/KsInterstitialAd;Ljava/lang/Integer;)Lcom/wifi/ad/core/entity/SensitiveInfo;", "catchKsNativeTemplateAd", be.aU, "Lcom/kwad/sdk/api/KsNativeAd;", "(Lcom/kwad/sdk/api/KsNativeAd;Ljava/lang/Integer;)Lcom/wifi/ad/core/entity/SensitiveInfo;", "catchKsRewardAd", "Lcom/kwad/sdk/api/KsRewardVideoAd;", "(Lcom/kwad/sdk/api/KsRewardVideoAd;Ljava/lang/Integer;)Lcom/wifi/ad/core/entity/SensitiveInfo;", "catchSplashInterstitialAd", "splashAd", "Lcom/kwad/sdk/api/KsSplashScreenAd;", "(Lcom/kwad/sdk/api/KsSplashScreenAd;Ljava/lang/Integer;)Lcom/wifi/ad/core/entity/SensitiveInfo;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
public final class KsSensitiveCatcher {
    public static final KsSensitiveCatcher INSTANCE = new KsSensitiveCatcher();

    private KsSensitiveCatcher() {
    }

    private final SensitiveInfo catchKsAdTemplateSensitive(Object instanceA, Integer adLevel) {
        try {
            if (instanceA instanceof AdTemplate) {
                List<AdInfo> list = ((AdTemplate) instanceA).adInfoList;
                List<AdInfo> list2 = list;
                if (!(list2 == null || list2.isEmpty())) {
                    SensitiveInfo sensitiveInfo = new SensitiveInfo();
                    sensitiveInfo.setContentSourceId(String.valueOf(sensitiveInfo.getCONTENT_RESOURCE_KS_AD()));
                    sensitiveInfo.setAdLevel(adLevel);
                    AdInfo adInfo = list.get(0);
                    if (adInfo == null) {
                        return null;
                    }
                    AdInfo.AdConversionInfo adConversionInfo = adInfo.adConversionInfo;
                    Intrinsics.checkExpressionValueIsNotNull(adConversionInfo, "adInfo!!.adConversionInfo");
                    String appDownloadUrl = adConversionInfo.appDownloadUrl;
                    Intrinsics.checkExpressionValueIsNotNull(appDownloadUrl, "appDownloadUrl");
                    sensitiveInfo.setDownloadUrl(appDownloadUrl);
                    AdInfo.AdConversionInfo adConversionInfo2 = adInfo.adConversionInfo;
                    String str = adConversionInfo2 != null ? adConversionInfo2.h5Url : null;
                    Intrinsics.checkExpressionValueIsNotNull(str, "adInfo?.adConversionInfo?.h5Url");
                    sensitiveInfo.setH5Url(str);
                    AdInfo.AdMaterialInfo adMaterialInfo = adInfo.adMaterialInfo;
                    Intrinsics.checkExpressionValueIsNotNull(adMaterialInfo, "adInfo.adMaterialInfo");
                    List<AdInfo.AdMaterialInfo.MaterialFeature> list3 = adMaterialInfo.materialFeatureList;
                    Intrinsics.checkExpressionValueIsNotNull(list3, "adMaterialInfo.materialFeatureList");
                    if (list3 != null && list3.size() > 0) {
                        AdInfo.AdMaterialInfo.MaterialFeature materialFeature = list3.get(0);
                        String str2 = materialFeature.materialUrl;
                        Intrinsics.checkExpressionValueIsNotNull(str2, "materialFeature.materialUrl");
                        sensitiveInfo.setVideoUrl(str2);
                        String str3 = materialFeature.coverUrl;
                        Intrinsics.checkExpressionValueIsNotNull(str3, "materialFeature.coverUrl");
                        sensitiveInfo.setCoverUrl(str3);
                    }
                    sensitiveInfo.setAdId(String.valueOf(adInfo.adBaseInfo.creativeId));
                    String appName = adInfo.adBaseInfo.appName;
                    Intrinsics.checkExpressionValueIsNotNull(appName, "appName");
                    sensitiveInfo.setAppName(appName);
                    String str4 = adInfo.adBaseInfo.productName;
                    if (str4 == null) {
                        str4 = "";
                    }
                    Intrinsics.checkExpressionValueIsNotNull(str4, "adInfo.adBaseInfo.productName ?: \"\"");
                    sensitiveInfo.setTitle(str4);
                    String desc = adInfo.adBaseInfo.adDescription;
                    Intrinsics.checkExpressionValueIsNotNull(desc, "desc");
                    sensitiveInfo.setDesc(desc);
                    String authorName = adInfo.advertiserInfo.userName;
                    Intrinsics.checkExpressionValueIsNotNull(authorName, "authorName");
                    sensitiveInfo.setAuthorName(authorName);
                    String authorPortrait = adInfo.advertiserInfo.portraitUrl;
                    Intrinsics.checkExpressionValueIsNotNull(authorPortrait, "authorPortrait");
                    sensitiveInfo.setAuthorUrl(authorPortrait);
                    String appPackageName = adInfo.adBaseInfo.appPackageName;
                    Intrinsics.checkExpressionValueIsNotNull(appPackageName, "appPackageName");
                    sensitiveInfo.setPackageName(appPackageName);
                    if (TextUtils.isEmpty(appDownloadUrl)) {
                        String appDownloadUrl2 = adInfo.adConversionInfo.marketUrl;
                        Intrinsics.checkExpressionValueIsNotNull(appDownloadUrl2, "appDownloadUrl");
                        sensitiveInfo.setDownloadUrl(appDownloadUrl2);
                    }
                    WifiLog.d("catchKsExpressTemplateAd " + sensitiveInfo);
                    if (WifiNestAd.INSTANCE.getBackDoorResult()) {
                        try {
                            sensitiveInfo.setShenheSdkId(new Gson().toJson(adInfo).toString());
                        } catch (Exception unused) {
                        }
                    }
                    return sensitiveInfo;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public final List<SensitiveInfo> catchKsDrawVideoAds(List<? extends Object> adList, Integer adLevel) {
        SensitiveInfo sensitiveInfoCatchSplashInterstitialAd;
        List<? extends Object> list = adList;
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : adList) {
            if (obj instanceof KsNativeAd) {
                KsNativeAd ksNativeAd = (KsNativeAd) obj;
                SensitiveInfo sensitiveInfoCatchKsNativeTemplateAd = catchKsNativeTemplateAd(ksNativeAd, adLevel);
                if (sensitiveInfoCatchKsNativeTemplateAd != null) {
                    if (ksNativeAd.getInteractionType() == 1) {
                        sensitiveInfoCatchKsNativeTemplateAd.setInteractionType(1);
                    } else {
                        sensitiveInfoCatchKsNativeTemplateAd.setInteractionType(2);
                    }
                    arrayList.add(sensitiveInfoCatchKsNativeTemplateAd);
                }
            } else if (obj instanceof KsDrawAd) {
                SensitiveInfo sensitiveInfoCatchKsExpressTemplateAd = catchKsExpressTemplateAd((KsDrawAd) obj, adLevel);
                if (sensitiveInfoCatchKsExpressTemplateAd != null) {
                    arrayList.add(sensitiveInfoCatchKsExpressTemplateAd);
                }
            } else if (obj instanceof KsFeedAd) {
                SensitiveInfo sensitiveInfoCatchKsFeedTemplateAd = catchKsFeedTemplateAd((KsFeedAd) obj, adLevel);
                if (sensitiveInfoCatchKsFeedTemplateAd != null) {
                    arrayList.add(sensitiveInfoCatchKsFeedTemplateAd);
                }
            } else if (obj instanceof KsRewardVideoAd) {
                SensitiveInfo sensitiveInfoCatchKsRewardAd = catchKsRewardAd((KsRewardVideoAd) obj, adLevel);
                if (sensitiveInfoCatchKsRewardAd != null) {
                    arrayList.add(sensitiveInfoCatchKsRewardAd);
                }
            } else if (obj instanceof KsInterstitialAd) {
                SensitiveInfo sensitiveInfoCatchKsInterstitialAd = catchKsInterstitialAd((KsInterstitialAd) obj, adLevel);
                if (sensitiveInfoCatchKsInterstitialAd != null) {
                    arrayList.add(sensitiveInfoCatchKsInterstitialAd);
                }
            } else if ((obj instanceof KsSplashScreenAd) && (sensitiveInfoCatchSplashInterstitialAd = catchSplashInterstitialAd((KsSplashScreenAd) obj, adLevel)) != null) {
                arrayList.add(sensitiveInfoCatchSplashInterstitialAd);
            }
        }
        return arrayList;
    }

    public final SensitiveInfo catchKsExpressTemplateAd(KsDrawAd ad, Integer adLevel) {
        try {
            Field declaredFieldA = ad.getClass().getDeclaredField("mAdTemplate");
            Intrinsics.checkExpressionValueIsNotNull(declaredFieldA, "declaredFieldA");
            declaredFieldA.setAccessible(true);
            Object instanceA = declaredFieldA.get(ad);
            WifiLog.d("catchSensitiveInfo instanceA " + instanceA);
            Intrinsics.checkExpressionValueIsNotNull(instanceA, "instanceA");
            return catchKsAdTemplateSensitive(instanceA, adLevel);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final SensitiveInfo catchKsFeedTemplateAd(KsFeedAd ad, Integer adLevel) {
        try {
            Field declaredFieldF = ad.getClass().getDeclaredField("mAdTemplate");
            Intrinsics.checkExpressionValueIsNotNull(declaredFieldF, "declaredFieldF");
            declaredFieldF.setAccessible(true);
            Object instanceF = declaredFieldF.get(ad);
            WifiLog.d("catchSensitiveInfo instanceF " + instanceF);
            Intrinsics.checkExpressionValueIsNotNull(instanceF, "instanceF");
            return catchKsAdTemplateSensitive(instanceF, adLevel);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final SensitiveInfo catchKsInterstitialAd(KsInterstitialAd ad, Integer adLevel) {
        try {
            Field declaredFieldF = ad.getClass().getDeclaredField("mAdTemplate");
            Intrinsics.checkExpressionValueIsNotNull(declaredFieldF, "declaredFieldF");
            declaredFieldF.setAccessible(true);
            Object instanceF = declaredFieldF.get(ad);
            WifiLog.d("catchSensitiveInfo instanceF " + instanceF);
            Intrinsics.checkExpressionValueIsNotNull(instanceF, "instanceF");
            return catchKsAdTemplateSensitive(instanceF, adLevel);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final SensitiveInfo catchKsNativeTemplateAd(KsNativeAd nativeAd, Integer adLevel) {
        try {
            Field declaredFieldA = nativeAd.getClass().getDeclaredField("mAdTemplate");
            Intrinsics.checkExpressionValueIsNotNull(declaredFieldA, "declaredFieldA");
            declaredFieldA.setAccessible(true);
            Object instanceA = declaredFieldA.get(nativeAd);
            WifiLog.d("catchSensitiveInfo instanceA " + instanceA);
            Intrinsics.checkExpressionValueIsNotNull(instanceA, "instanceA");
            return catchKsAdTemplateSensitive(instanceA, adLevel);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final SensitiveInfo catchKsRewardAd(KsRewardVideoAd ad, Integer adLevel) {
        try {
            Field declaredFieldF = ad.getClass().getDeclaredField("mAdTemplate");
            Intrinsics.checkExpressionValueIsNotNull(declaredFieldF, "declaredFieldF");
            declaredFieldF.setAccessible(true);
            Object instanceF = declaredFieldF.get(ad);
            WifiLog.d("catchSensitiveInfo instanceF " + instanceF);
            Intrinsics.checkExpressionValueIsNotNull(instanceF, "instanceF");
            return catchKsAdTemplateSensitive(instanceF, adLevel);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final SensitiveInfo catchSplashInterstitialAd(KsSplashScreenAd splashAd, Integer adLevel) {
        try {
            Field declaredFieldF = splashAd.getClass().getDeclaredField("mAdTemplate");
            Intrinsics.checkExpressionValueIsNotNull(declaredFieldF, "declaredFieldF");
            declaredFieldF.setAccessible(true);
            Object instanceF = declaredFieldF.get(splashAd);
            WifiLog.d("catchSensitiveInfo instanceF " + instanceF);
            Intrinsics.checkExpressionValueIsNotNull(instanceF, "instanceF");
            return catchKsAdTemplateSensitive(instanceF, adLevel);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
