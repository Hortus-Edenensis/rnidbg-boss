package com.wifi.feisuo.ad;

import android.text.TextUtils;
import com.kuaishou.weapon.p0.t;
import com.wifi.ad.core.entity.SensitiveInfo;
import com.wifi.ad.core.utils.ReflectUtils;
import com.zm.fissionsdk.api.interfaces.IFissionInterstitial;
import com.zm.fissionsdk.api.interfaces.IFissionNative;
import com.zm.fissionsdk.api.interfaces.IFissionRewardVideo;
import com.zm.fissionsdk.api.interfaces.IFissionSplash;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J'\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ'\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00102\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u0011J'\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00132\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u0014J'\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00162\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/wifi/feisuo/ad/FeiSuoSensitiveCatcher;", "", "()V", "catchAdInfo", "", "CV", "sensitiveInfo", "Lcom/wifi/ad/core/entity/SensitiveInfo;", "catchExpressInterstitialAds", "", "ad", "Lcom/zm/fissionsdk/api/interfaces/IFissionInterstitial;", "adLevel", "", "(Lcom/zm/fissionsdk/api/interfaces/IFissionInterstitial;Ljava/lang/Integer;)Ljava/util/List;", "catchExpressNativeAds", "Lcom/zm/fissionsdk/api/interfaces/IFissionNative;", "(Lcom/zm/fissionsdk/api/interfaces/IFissionNative;Ljava/lang/Integer;)Ljava/util/List;", "catchExpressSplashAds", "Lcom/zm/fissionsdk/api/interfaces/IFissionSplash;", "(Lcom/zm/fissionsdk/api/interfaces/IFissionSplash;Ljava/lang/Integer;)Ljava/util/List;", "catchRewardAd", "Lcom/zm/fissionsdk/api/interfaces/IFissionRewardVideo;", "(Lcom/zm/fissionsdk/api/interfaces/IFissionRewardVideo;Ljava/lang/Integer;)Ljava/util/List;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
public final class FeiSuoSensitiveCatcher {
    public static final FeiSuoSensitiveCatcher INSTANCE = new FeiSuoSensitiveCatcher();

    private FeiSuoSensitiveCatcher() {
    }

    private final void catchAdInfo(Object CV, SensitiveInfo sensitiveInfo) {
        if (CV != null) {
            ReflectUtils reflectUtils = ReflectUtils.INSTANCE;
            Object value = reflectUtils.getValue(CV, CV.getClass(), "d");
            if (value != null && (value instanceof List)) {
                List list = (List) value;
                if (list.size() > 0) {
                    Object obj = list.get(0);
                    if (obj == null) {
                        Intrinsics.throwNpe();
                    }
                    Object value2 = reflectUtils.getValue(obj, obj.getClass(), "a");
                    if (value2 instanceof String) {
                        sensitiveInfo.setCoverUrl((String) value2);
                    }
                }
            }
            Object value3 = reflectUtils.getValue(CV, CV.getClass(), "e");
            if (value3 != null) {
                Object value4 = reflectUtils.getValue(value3, value3.getClass(), "a");
                if (value4 instanceof String) {
                    sensitiveInfo.setVideoUrl((String) value4);
                }
            }
            Object value5 = reflectUtils.getValue(CV, CV.getClass(), "n");
            if (value5 instanceof String) {
                sensitiveInfo.setDeepUrl((String) value5);
            }
            Object value6 = reflectUtils.getValue(CV, CV.getClass(), "p");
            if (value6 instanceof String) {
                sensitiveInfo.setDownloadUrl((String) value6);
            }
            if (TextUtils.isEmpty(sensitiveInfo.getTitle())) {
                Object value7 = reflectUtils.getValue(CV, CV.getClass(), "g");
                if (value7 instanceof String) {
                    sensitiveInfo.setTitle((String) value7);
                }
            }
            if (TextUtils.isEmpty(sensitiveInfo.getDesc())) {
                Object value8 = reflectUtils.getValue(CV, CV.getClass(), "h");
                if (value8 instanceof String) {
                    sensitiveInfo.setDesc((String) value8);
                }
            }
            Object value9 = reflectUtils.getValue(CV, CV.getClass(), "p");
            if (value9 instanceof String) {
                sensitiveInfo.setDeepUrl((String) value9);
            }
            Object value10 = reflectUtils.getValue(CV, CV.getClass(), "q");
            if (value10 instanceof String) {
                sensitiveInfo.setH5Url((String) value10);
            }
            Object value11 = reflectUtils.getValue(CV, CV.getClass(), "f");
            if (value11 != null) {
                Object value12 = reflectUtils.getValue(value11, value11.getClass(), "e");
                if (value12 instanceof String) {
                    sensitiveInfo.setPackageName((String) value12);
                }
                Object value13 = reflectUtils.getValue(value11, value11.getClass(), t.l);
                if (value13 instanceof String) {
                    sensitiveInfo.setAppName((String) value13);
                }
            }
        }
    }

    public final List<SensitiveInfo> catchExpressInterstitialAds(IFissionInterstitial ad, Integer adLevel) {
        ArrayList arrayList = new ArrayList();
        SensitiveInfo sensitiveInfo = new SensitiveInfo();
        try {
            sensitiveInfo.setContentSourceId(String.valueOf(sensitiveInfo.getCONTENT_RESOURCE_FEISUO_AD()));
            sensitiveInfo.setAdLevel(adLevel);
            String sid = ad.getSid();
            Intrinsics.checkExpressionValueIsNotNull(sid, "ad.sid");
            sensitiveInfo.setShenheSdkId(sid);
            ReflectUtils reflectUtils = ReflectUtils.INSTANCE;
            Object value = reflectUtils.getValue(ad, ad.getClass(), t.l);
            if (value != null) {
                catchAdInfo(reflectUtils.getValue(value, value.getClass().getSuperclass(), "t"), sensitiveInfo);
            }
        } catch (Exception unused) {
        }
        arrayList.add(sensitiveInfo);
        return arrayList;
    }

    public final List<SensitiveInfo> catchExpressNativeAds(IFissionNative ad, Integer adLevel) {
        ArrayList arrayList = new ArrayList();
        SensitiveInfo sensitiveInfo = new SensitiveInfo();
        try {
            sensitiveInfo.setContentSourceId(String.valueOf(sensitiveInfo.getCONTENT_RESOURCE_FEISUO_AD()));
            sensitiveInfo.setAdLevel(adLevel);
            if (ad.getTitle() instanceof String) {
                String title = ad.getTitle();
                Intrinsics.checkExpressionValueIsNotNull(title, "ad.title");
                sensitiveInfo.setTitle(title);
            }
            if (ad.getAppName() instanceof String) {
                String appName = ad.getAppName();
                Intrinsics.checkExpressionValueIsNotNull(appName, "ad.appName");
                sensitiveInfo.setAppName(appName);
            }
            Intrinsics.checkExpressionValueIsNotNull(ad.getImageList(), "ad.imageList");
            if (!r6.isEmpty()) {
                String str = ad.getImageList().get(0);
                Intrinsics.checkExpressionValueIsNotNull(str, "ad.imageList[0]");
                sensitiveInfo.setCoverUrl(str);
            }
            if (ad.getPackageName() instanceof String) {
                String packageName = ad.getPackageName();
                Intrinsics.checkExpressionValueIsNotNull(packageName, "ad.packageName");
                sensitiveInfo.setPackageName(packageName);
            }
            if (ad.getSid() instanceof String) {
                String sid = ad.getSid();
                Intrinsics.checkExpressionValueIsNotNull(sid, "ad.sid");
                sensitiveInfo.setShenheSdkId(sid);
            }
            ReflectUtils reflectUtils = ReflectUtils.INSTANCE;
            Object value = reflectUtils.getValue(ad, ad.getClass(), t.l);
            if (value != null) {
                catchAdInfo(reflectUtils.getValue(value, value.getClass().getSuperclass(), "t"), sensitiveInfo);
            }
        } catch (Exception unused) {
        }
        arrayList.add(sensitiveInfo);
        return arrayList;
    }

    public final List<SensitiveInfo> catchExpressSplashAds(IFissionSplash ad, Integer adLevel) {
        ArrayList arrayList = new ArrayList();
        SensitiveInfo sensitiveInfo = new SensitiveInfo();
        try {
            sensitiveInfo.setContentSourceId(String.valueOf(sensitiveInfo.getCONTENT_RESOURCE_FEISUO_AD()));
            sensitiveInfo.setAdLevel(adLevel);
            String sid = ad.getSid();
            Intrinsics.checkExpressionValueIsNotNull(sid, "ad.sid");
            sensitiveInfo.setShenheSdkId(sid);
            ReflectUtils reflectUtils = ReflectUtils.INSTANCE;
            Object value = reflectUtils.getValue(ad, ad.getClass(), t.l);
            if (value != null) {
                catchAdInfo(reflectUtils.getValue(value, value.getClass().getSuperclass(), "t"), sensitiveInfo);
            }
        } catch (Exception unused) {
        }
        arrayList.add(sensitiveInfo);
        return arrayList;
    }

    public final List<SensitiveInfo> catchRewardAd(IFissionRewardVideo ad, Integer adLevel) {
        ArrayList arrayList = new ArrayList();
        SensitiveInfo sensitiveInfo = new SensitiveInfo();
        try {
            sensitiveInfo.setContentSourceId(String.valueOf(sensitiveInfo.getCONTENT_RESOURCE_FEISUO_AD()));
            sensitiveInfo.setAdLevel(adLevel);
            String sid = ad.getSid();
            Intrinsics.checkExpressionValueIsNotNull(sid, "ad.sid");
            sensitiveInfo.setShenheSdkId(sid);
            ReflectUtils reflectUtils = ReflectUtils.INSTANCE;
            Object value = reflectUtils.getValue(ad, ad.getClass(), t.l);
            if (value != null) {
                catchAdInfo(reflectUtils.getValue(value, value.getClass().getSuperclass(), "t"), sensitiveInfo);
            }
        } catch (Exception unused) {
        }
        arrayList.add(sensitiveInfo);
        return arrayList;
    }
}
