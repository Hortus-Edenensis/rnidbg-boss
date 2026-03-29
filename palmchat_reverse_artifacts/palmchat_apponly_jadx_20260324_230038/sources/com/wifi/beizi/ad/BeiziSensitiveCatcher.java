package com.wifi.beizi.ad;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.beizi.fusion.InterstitialAd;
import com.beizi.fusion.NativeAd;
import com.beizi.fusion.SplashAd;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.wifi.ad.core.entity.SensitiveInfo;
import com.wifi.ad.core.utils.ReflectUtils;
import com.wifi.ad.core.utils.WifiLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J'\u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ'\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\f2\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\rJ'\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u0010J!\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00012\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/wifi/beizi/ad/BeiziSensitiveCatcher;", "", "()V", "catchInterstitialAds", "", "Lcom/wifi/ad/core/entity/SensitiveInfo;", "ad", "Lcom/beizi/fusion/InterstitialAd;", "adLevel", "", "(Lcom/beizi/fusion/InterstitialAd;Ljava/lang/Integer;)Ljava/util/List;", "catchSplashAds", "Lcom/beizi/fusion/SplashAd;", "(Lcom/beizi/fusion/SplashAd;Ljava/lang/Integer;)Ljava/util/List;", "catchTempNativeAds", "Lcom/beizi/fusion/NativeAd;", "(Lcom/beizi/fusion/NativeAd;Ljava/lang/Integer;)Ljava/util/List;", "createSensitiveInfo", "serverResponse", "(Ljava/lang/Object;Ljava/lang/Integer;)Lcom/wifi/ad/core/entity/SensitiveInfo;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
public final class BeiziSensitiveCatcher {
    public static final BeiziSensitiveCatcher INSTANCE = new BeiziSensitiveCatcher();

    private BeiziSensitiveCatcher() {
    }

    private final SensitiveInfo createSensitiveInfo(Object serverResponse, Integer adLevel) {
        SensitiveInfo sensitiveInfo = new SensitiveInfo();
        if (serverResponse != null) {
            sensitiveInfo.setContentSourceId(String.valueOf(sensitiveInfo.getCONTENT_RESOURCE_BEIZI_AD()));
            sensitiveInfo.setAdLevel(adLevel);
            ReflectUtils reflectUtils = ReflectUtils.INSTANCE;
            Object value = reflectUtils.getValue(serverResponse, serverResponse.getClass(), "aw");
            if (value instanceof String) {
                sensitiveInfo.setDesc((String) value);
            }
            Object value2 = reflectUtils.getValue(serverResponse, serverResponse.getClass(), CmcdData.OBJECT_TYPE_MUXED_AUDIO_AND_VIDEO);
            if (value2 instanceof String) {
                sensitiveInfo.setTitle((String) value2);
            }
            Object value3 = reflectUtils.getValue(serverResponse, serverResponse.getClass(), "ax");
            if (value3 instanceof String) {
                sensitiveInfo.setVideoUrl((String) value3);
            }
            Object value4 = reflectUtils.getValue(serverResponse, serverResponse.getClass(), ExifInterface.LATITUDE_SOUTH);
            if (value4 instanceof String) {
                sensitiveInfo.setPackageName((String) value4);
            }
            Object value5 = reflectUtils.getValue(serverResponse, serverResponse.getClass(), LiveConfigKey.AUDIO);
            if (value5 instanceof String) {
                sensitiveInfo.setH5Url((String) value5);
            }
            Object value6 = reflectUtils.getValue(serverResponse, serverResponse.getClass(), "ap");
            if (value6 instanceof String) {
                sensitiveInfo.setDeepUrl((String) value6);
            }
            Object value7 = reflectUtils.getValue(serverResponse, serverResponse.getClass(), "U");
            if (value7 instanceof String) {
                sensitiveInfo.setDownloadUrl((String) value7);
            }
            if (TextUtils.isEmpty(sensitiveInfo.getCoverUrl())) {
                Object value8 = reflectUtils.getValue(serverResponse, serverResponse.getClass(), "F");
                if (value8 instanceof String) {
                    sensitiveInfo.setCoverUrl((String) value8);
                }
            }
        }
        return sensitiveInfo;
    }

    public final List<SensitiveInfo> catchInterstitialAds(InterstitialAd ad, Integer adLevel) {
        try {
            ArrayList arrayList = new ArrayList();
            ReflectUtils reflectUtils = ReflectUtils.INSTANCE;
            Object value = reflectUtils.getValue(ad, ad.getClass(), "a");
            if (value == null) {
                Intrinsics.throwNpe();
            }
            Object value2 = reflectUtils.getValue(value, value.getClass().getSuperclass(), "i");
            if (value2 == null) {
                Intrinsics.throwNpe();
            }
            Object value3 = reflectUtils.getValue(value2, value2.getClass(), "s");
            if (value3 == null) {
                Intrinsics.throwNpe();
            }
            Object value4 = reflectUtils.getValue(value3, value3.getClass().getSuperclass(), "a");
            if (value4 == null) {
                Intrinsics.throwNpe();
            }
            arrayList.add(createSensitiveInfo(reflectUtils.getValue(value4, value4.getClass().getSuperclass(), "c"), adLevel));
            return arrayList;
        } catch (Exception e) {
            WifiLog.d("beizi catchSensitiveInfo splash Exception " + e.toString());
            return null;
        }
    }

    public final List<SensitiveInfo> catchSplashAds(SplashAd ad, Integer adLevel) {
        try {
            ArrayList arrayList = new ArrayList();
            ReflectUtils reflectUtils = ReflectUtils.INSTANCE;
            Object value = reflectUtils.getValue(ad, ad.getClass(), "a");
            if (value == null) {
                Intrinsics.throwNpe();
            }
            Object value2 = reflectUtils.getValue(value, value.getClass().getSuperclass(), "i");
            if (value2 == null) {
                Intrinsics.throwNpe();
            }
            Object value3 = reflectUtils.getValue(value2, value2.getClass(), "v");
            if (value3 == null) {
                Intrinsics.throwNpe();
            }
            Object value4 = reflectUtils.getValue(value3, value3.getClass().getSuperclass(), "a");
            if (value4 == null) {
                Intrinsics.throwNpe();
            }
            arrayList.add(createSensitiveInfo(reflectUtils.getValue(value4, value4.getClass().getSuperclass(), "c"), adLevel));
            return arrayList;
        } catch (Exception e) {
            WifiLog.d("beizi catchSensitiveInfo splash Exception " + e.toString());
            return null;
        }
    }

    public final List<SensitiveInfo> catchTempNativeAds(NativeAd ad, Integer adLevel) {
        try {
            ArrayList arrayList = new ArrayList();
            ReflectUtils reflectUtils = ReflectUtils.INSTANCE;
            Object value = reflectUtils.getValue(ad, ad.getClass(), "a");
            if (value == null) {
                Intrinsics.throwNpe();
            }
            Object value2 = reflectUtils.getValue(value, value.getClass().getSuperclass(), "i");
            if (value2 == null) {
                Intrinsics.throwNpe();
            }
            Object value3 = reflectUtils.getValue(value2, value2.getClass(), "t");
            if (value3 == null) {
                Intrinsics.throwNpe();
            }
            Object value4 = reflectUtils.getValue(value3, value3.getClass().getSuperclass(), "a");
            if (value4 == null) {
                Intrinsics.throwNpe();
            }
            arrayList.add(createSensitiveInfo(reflectUtils.getValue(value4, value4.getClass().getSuperclass(), "c"), adLevel));
            return arrayList;
        } catch (Exception e) {
            WifiLog.d("beizi catchSensitiveInfo splash Exception " + e.toString());
            return null;
        }
    }
}
