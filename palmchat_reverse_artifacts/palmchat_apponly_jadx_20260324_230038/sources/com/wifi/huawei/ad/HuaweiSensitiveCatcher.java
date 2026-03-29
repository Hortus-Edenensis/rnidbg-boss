package com.wifi.huawei.ad;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.ads.InterstitialAd;
import com.huawei.hms.ads.nativead.NativeAd;
import com.huawei.hms.ads.splash.SplashAd;
import com.huawei.hms.ads.splash.SplashView;
import com.huawei.openalliance.ad.beans.metadata.ApkInfo;
import com.huawei.openalliance.ad.beans.metadata.ImageInfo;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.beans.metadata.VideoInfo;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import com.wifi.ad.core.entity.SensitiveInfo;
import com.wifi.ad.core.utils.ReflectUtils;
import com.wifi.ad.core.utils.WifiLog;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J'\u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ'\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\f2\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\rJ'\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u0010J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J!\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0002\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/wifi/huawei/ad/HuaweiSensitiveCatcher;", "", "()V", "catchInterAds", "", "Lcom/wifi/ad/core/entity/SensitiveInfo;", "ad", "Lcom/huawei/hms/ads/InterstitialAd;", "adLevel", "", "(Lcom/huawei/hms/ads/InterstitialAd;Ljava/lang/Integer;)Ljava/util/List;", "catchSplashAds", "Lcom/huawei/hms/ads/splash/SplashAd;", "(Lcom/huawei/hms/ads/splash/SplashAd;Ljava/lang/Integer;)Ljava/util/List;", "catchTemplateAds", "Lcom/huawei/hms/ads/nativead/NativeAd;", "(Lcom/huawei/hms/ads/nativead/NativeAd;Ljava/lang/Integer;)Ljava/util/List;", "codeHwString", "", "res", "getAdInfo", "adData", "Lcom/huawei/openalliance/ad/inter/data/AdContentData;", "(Lcom/huawei/openalliance/ad/inter/data/AdContentData;Ljava/lang/Integer;)Lcom/wifi/ad/core/entity/SensitiveInfo;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
public final class HuaweiSensitiveCatcher {
    public static final HuaweiSensitiveCatcher INSTANCE = new HuaweiSensitiveCatcher();

    private HuaweiSensitiveCatcher() {
    }

    private final String codeHwString(String res) {
        try {
            if (TextUtils.isEmpty(res)) {
                return "";
            }
            String value = URLDecoder.decode(res, "utf-8");
            Intrinsics.checkExpressionValueIsNotNull(value, "value");
            return value;
        } catch (Exception unused) {
            return "";
        }
    }

    private final SensitiveInfo getAdInfo(AdContentData adData, Integer adLevel) {
        if (adData == null) {
            return null;
        }
        try {
            SensitiveInfo sensitiveInfo = new SensitiveInfo();
            MetaData metaDataS = adData.S();
            if (!TextUtils.isEmpty(adData.i())) {
                String strI = adData.i();
                Intrinsics.checkExpressionValueIsNotNull(strI, "adData.i()");
                sensitiveInfo.setH5Url(strI);
            }
            if (metaDataS != null) {
                sensitiveInfo.setContentSourceId(String.valueOf(sensitiveInfo.getCONTENT_RESOURCE_HUAWEI_AD()));
                sensitiveInfo.setAdLevel(adLevel);
                if (!TextUtils.isEmpty(metaDataS.Z())) {
                    sensitiveInfo.setTitle(codeHwString(metaDataS.Z()));
                }
                ApkInfo apkInfoE = metaDataS.e();
                if (apkInfoE != null) {
                    if (!TextUtils.isEmpty(apkInfoE.Code())) {
                        sensitiveInfo.setPackageName(codeHwString(apkInfoE.Code()));
                    }
                    if (!TextUtils.isEmpty(apkInfoE.D())) {
                        sensitiveInfo.setAppName(codeHwString(apkInfoE.D()));
                    }
                    if (!TextUtils.isEmpty(apkInfoE.k())) {
                        sensitiveInfo.setDesc(codeHwString(apkInfoE.k()));
                    }
                    if (!TextUtils.isEmpty(apkInfoE.B())) {
                        String strB = apkInfoE.B();
                        Intrinsics.checkExpressionValueIsNotNull(strB, "apkInfo.B()");
                        sensitiveInfo.setDownloadUrl(strB);
                    }
                }
                List<ImageInfo> listD = metaDataS.d();
                if (listD != null && listD.size() > 0) {
                    ImageInfo imageInfo = listD.get(0);
                    if (!TextUtils.isEmpty(imageInfo.I())) {
                        String strI2 = imageInfo.I();
                        Intrinsics.checkExpressionValueIsNotNull(strI2, "img.I()");
                        sensitiveInfo.setCoverUrl(strI2);
                    }
                }
                VideoInfo videoInfoV = metaDataS.V();
                if (videoInfoV != null && !TextUtils.isEmpty(videoInfoV.Code())) {
                    String strCode = videoInfoV.Code();
                    Intrinsics.checkExpressionValueIsNotNull(strCode, "videoInfo.Code()");
                    sensitiveInfo.setVideoUrl(strCode);
                }
                if (!TextUtils.isEmpty(metaDataS.a())) {
                    String strA = metaDataS.a();
                    Intrinsics.checkExpressionValueIsNotNull(strA, "data.a()");
                    sensitiveInfo.setDeepUrl(strA);
                }
            }
            return sensitiveInfo;
        } catch (Exception e) {
            WifiLog.d("hw getAdInfo Exception " + e.toString());
            return null;
        }
    }

    public final List<SensitiveInfo> catchInterAds(InterstitialAd ad, Integer adLevel) {
        SensitiveInfo adInfo;
        Class<? super Object> superclass;
        ArrayList arrayList = new ArrayList();
        try {
            ReflectUtils reflectUtils = ReflectUtils.INSTANCE;
            Object value = reflectUtils.getValue(ad, ad.getClass(), "Code");
            if (value != null) {
                Object value2 = reflectUtils.getValue(value, value.getClass(), "e");
                if ((value2 instanceof ArrayList) && ((ArrayList) value2).size() > 0) {
                    Object obj = ((ArrayList) value2).get(0);
                    Object value3 = reflectUtils.getValue(obj, (obj == null || (superclass = obj.getClass().getSuperclass()) == null) ? null : superclass.getSuperclass(), "I");
                    if ((value3 instanceof AdContentData) && (adInfo = getAdInfo((AdContentData) value3, adLevel)) != null) {
                        arrayList.add(adInfo);
                    }
                }
            }
        } catch (Exception e) {
            WifiLog.d("hw catchTemplateAds Exception " + e.toString());
        }
        return arrayList;
    }

    public final List<SensitiveInfo> catchSplashAds(SplashAd ad, Integer adLevel) {
        ReflectUtils reflectUtils;
        Object value;
        try {
            ArrayList arrayList = new ArrayList();
            SplashView splashViewM57getSplashView = ad.m57getSplashView();
            if (splashViewM57getSplashView == null || (value = (reflectUtils = ReflectUtils.INSTANCE).getValue(splashViewM57getSplashView, splashViewM57getSplashView.getClass().getSuperclass(), "d")) == null) {
                return null;
            }
            Object value2 = reflectUtils.getValue(value, value.getClass().getSuperclass(), WkAdxAdConfigMg.DSP_NAME_BAIDU);
            if (!(value2 instanceof AdContentData)) {
                return null;
            }
            SensitiveInfo adInfo = getAdInfo((AdContentData) value2, adLevel);
            if (adInfo != null) {
                arrayList.add(adInfo);
            }
            return arrayList;
        } catch (Exception e) {
            WifiLog.d("hw splash catchSensitiveInfo Exception " + e.toString());
            return null;
        }
    }

    public final List<SensitiveInfo> catchTemplateAds(NativeAd ad, Integer adLevel) {
        SensitiveInfo adInfo;
        ArrayList arrayList = new ArrayList();
        try {
            ReflectUtils reflectUtils = ReflectUtils.INSTANCE;
            Object value = reflectUtils.getValue(ad, ad.getClass(), ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
            Object value2 = reflectUtils.getValue(value, value != null ? value.getClass().getSuperclass() : null, "I");
            if ((value2 instanceof AdContentData) && (adInfo = getAdInfo((AdContentData) value2, adLevel)) != null) {
                arrayList.add(adInfo);
            }
        } catch (Exception e) {
            WifiLog.d("hw catchTemplateAds Exception " + e.toString());
        }
        return arrayList;
    }
}
