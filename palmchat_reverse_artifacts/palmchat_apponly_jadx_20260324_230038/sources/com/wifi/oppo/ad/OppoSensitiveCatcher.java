package com.wifi.oppo.ad;

import com.amap.api.col.p0002sl.hb;
import com.heytap.msp.mobad.api.ad.HotSplashAd;
import com.heytap.msp.mobad.api.ad.InterstitialAd;
import com.heytap.msp.mobad.api.params.INativeAdFile;
import com.heytap.msp.mobad.api.params.INativeAdvanceData;
import com.heytap.msp.mobad.api.params.INativeTempletAdView;
import com.kuaishou.weapon.p0.t;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.data.MaterialFileData;
import com.wifi.ad.core.entity.SensitiveInfo;
import com.wifi.ad.core.utils.ReflectUtils;
import com.wifi.ad.core.utils.WifiLog;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J'\u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ-\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u000fJ'\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00112\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u0012J-\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00140\r2\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u000fJ\u001d\u0010\u0015\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/wifi/oppo/ad/OppoSensitiveCatcher;", "", "()V", "catchInterstitialAds", "", "Lcom/wifi/ad/core/entity/SensitiveInfo;", "ad", "Lcom/heytap/msp/mobad/api/ad/InterstitialAd;", "adLevel", "", "(Lcom/heytap/msp/mobad/api/ad/InterstitialAd;Ljava/lang/Integer;)Ljava/util/List;", "catchNativeAds", "ads", "", "Lcom/heytap/msp/mobad/api/params/INativeAdvanceData;", "(Ljava/util/List;Ljava/lang/Integer;)Ljava/util/List;", "catchSplashAds", "Lcom/heytap/msp/mobad/api/ad/HotSplashAd;", "(Lcom/heytap/msp/mobad/api/ad/HotSplashAd;Ljava/lang/Integer;)Ljava/util/List;", "catchTemplateAds", "Lcom/heytap/msp/mobad/api/params/INativeTempletAdView;", "createSensitiveInfoByInfo", "infoData", "Lcom/opos/mobad/model/data/MaterialData;", "(Ljava/lang/Integer;Lcom/opos/mobad/model/data/MaterialData;)Lcom/wifi/ad/core/entity/SensitiveInfo;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
public final class OppoSensitiveCatcher {
    public static final OppoSensitiveCatcher INSTANCE = new OppoSensitiveCatcher();

    private OppoSensitiveCatcher() {
    }

    public final List<SensitiveInfo> catchInterstitialAds(InterstitialAd ad, Integer adLevel) {
        ReflectUtils reflectUtils;
        Object value;
        ConcurrentHashMap concurrentHashMap;
        Object obj;
        Object value2;
        try {
            ArrayList arrayList = new ArrayList();
            Field declaredFieldF = ad.getClass().getDeclaredField("mInterstitialAdImpl");
            Intrinsics.checkExpressionValueIsNotNull(declaredFieldF, "declaredFieldF");
            declaredFieldF.setAccessible(true);
            Object obj2 = declaredFieldF.get(ad);
            if (obj2 != null && (value = (reflectUtils = ReflectUtils.INSTANCE).getValue(obj2, obj2.getClass(), t.l)) != null && (concurrentHashMap = (ConcurrentHashMap) reflectUtils.getValue(value, value.getClass().getSuperclass(), t.l)) != null && (obj = concurrentHashMap.get(1)) != null && (value2 = reflectUtils.getValue(obj, obj.getClass(), "i")) != null) {
                Object value3 = reflectUtils.getValue(value2, value2.getClass().getSuperclass(), "d");
                if (value3 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.opos.mobad.model.data.MaterialData");
                }
                arrayList.add(createSensitiveInfoByInfo(adLevel, (MaterialData) value3));
            }
            return arrayList;
        } catch (Exception e) {
            WifiLog.d("oppo catchSensitiveInfo Exception " + e.toString());
            return null;
        }
    }

    public final List<SensitiveInfo> catchNativeAds(List<INativeAdvanceData> ads, Integer adLevel) {
        ArrayList arrayList = new ArrayList();
        try {
            for (INativeAdvanceData iNativeAdvanceData : ads) {
                SensitiveInfo sensitiveInfo = new SensitiveInfo();
                sensitiveInfo.setContentSourceId(String.valueOf(sensitiveInfo.getCONTENT_RESOURCE_OPPO_AD()));
                sensitiveInfo.setAdLevel(adLevel);
                String title = iNativeAdvanceData.getTitle();
                Intrinsics.checkExpressionValueIsNotNull(title, "ad.title");
                sensitiveInfo.setTitle(title);
                if (iNativeAdvanceData.getImgFiles() != null && iNativeAdvanceData.getImgFiles().size() > 0) {
                    INativeAdFile iNativeAdFile = iNativeAdvanceData.getImgFiles().get(0);
                    Intrinsics.checkExpressionValueIsNotNull(iNativeAdFile, "ad.imgFiles[0]");
                    String url = iNativeAdFile.getUrl();
                    Intrinsics.checkExpressionValueIsNotNull(url, "ad.imgFiles[0].url");
                    sensitiveInfo.setCoverUrl(url);
                }
                ReflectUtils reflectUtils = ReflectUtils.INSTANCE;
                Object value = reflectUtils.getValue(iNativeAdvanceData, iNativeAdvanceData.getClass(), "mData");
                Object value2 = reflectUtils.getValue(value, value != null ? value.getClass() : null, "a");
                Object value3 = reflectUtils.getValue(value2, value2 != null ? value2.getClass() : null, t.l);
                if (value3 != null) {
                    arrayList.add(INSTANCE.createSensitiveInfoByInfo(adLevel, (MaterialData) value3));
                } else {
                    arrayList.add(sensitiveInfo);
                }
            }
        } catch (Exception e) {
            WifiLog.d("oppo catchNativeAds Exception " + e.toString());
        }
        return arrayList;
    }

    public final List<SensitiveInfo> catchSplashAds(HotSplashAd ad, Integer adLevel) {
        ReflectUtils reflectUtils;
        Object value;
        Object value2;
        ConcurrentHashMap concurrentHashMap;
        Object obj;
        Object value3;
        try {
            ArrayList arrayList = new ArrayList();
            Field declaredFieldF = ad.getClass().getDeclaredField("mSplashAdImpl");
            Intrinsics.checkExpressionValueIsNotNull(declaredFieldF, "declaredFieldF");
            declaredFieldF.setAccessible(true);
            Object obj2 = declaredFieldF.get(ad);
            if (obj2 != null && (value = (reflectUtils = ReflectUtils.INSTANCE).getValue(obj2, obj2.getClass(), hb.j)) != null && (value2 = reflectUtils.getValue(value, value.getClass(), t.l)) != null && (concurrentHashMap = (ConcurrentHashMap) reflectUtils.getValue(value2, value2.getClass().getSuperclass(), t.l)) != null && (obj = concurrentHashMap.get(1)) != null && (value3 = reflectUtils.getValue(obj, obj.getClass(), t.l)) != null) {
                Object value4 = reflectUtils.getValue(value3, value3.getClass().getSuperclass(), "g");
                if (value4 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.opos.mobad.model.data.MaterialData");
                }
                arrayList.add(createSensitiveInfoByInfo(adLevel, (MaterialData) value4));
            }
            return arrayList;
        } catch (Exception e) {
            WifiLog.d("oppo catchSensitiveInfo Exception " + e.toString());
            return null;
        }
    }

    public final List<SensitiveInfo> catchTemplateAds(List<INativeTempletAdView> ads, Integer adLevel) {
        ArrayList arrayList = new ArrayList();
        try {
        } catch (Exception e) {
            WifiLog.d("oppo catchTemplateAds Exception " + e.toString());
        }
        for (INativeTempletAdView iNativeTempletAdView : ads) {
            ReflectUtils reflectUtils = ReflectUtils.INSTANCE;
            Object value = reflectUtils.getValue(iNativeTempletAdView, iNativeTempletAdView != null ? iNativeTempletAdView.getClass() : null, "mAdView");
            Object value2 = reflectUtils.getValue(value, value != null ? value.getClass() : null, "e");
            Object value3 = reflectUtils.getValue(value2, value2 != null ? value2.getClass() : null, "c");
            if (value3 == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.opos.mobad.model.data.MaterialData");
            }
            arrayList.add(INSTANCE.createSensitiveInfoByInfo(adLevel, (MaterialData) value3));
            return arrayList;
        }
        return arrayList;
    }

    public final SensitiveInfo createSensitiveInfoByInfo(Integer adLevel, MaterialData infoData) {
        SensitiveInfo sensitiveInfo = new SensitiveInfo();
        sensitiveInfo.setContentSourceId(String.valueOf(sensitiveInfo.getCONTENT_RESOURCE_OPPO_AD()));
        sensitiveInfo.setAdLevel(adLevel);
        List<MaterialFileData> listE = infoData.e();
        if (listE != null && listE.size() > 0) {
            String strA = listE.get(0).a();
            Intrinsics.checkExpressionValueIsNotNull(strA, "imgList[0].a()");
            sensitiveInfo.setCoverUrl(strA);
        }
        String strF = infoData.f();
        Intrinsics.checkExpressionValueIsNotNull(strF, "infoData.f()");
        sensitiveInfo.setTitle(strF);
        String strI = infoData.i();
        Intrinsics.checkExpressionValueIsNotNull(strI, "infoData.i()");
        sensitiveInfo.setPackageName(strI);
        String strU = infoData.u();
        Intrinsics.checkExpressionValueIsNotNull(strU, "infoData.u()");
        sensitiveInfo.setH5Url(strU);
        String strJ = infoData.J();
        Intrinsics.checkExpressionValueIsNotNull(strJ, "infoData.J()");
        sensitiveInfo.setDeepUrl(strJ);
        if (infoData.D() != null && infoData.D().size() > 0) {
            String strA2 = infoData.D().get(0).a();
            Intrinsics.checkExpressionValueIsNotNull(strA2, "infoData.D()[0].a()");
            sensitiveInfo.setVideoUrl(strA2);
        }
        return sensitiveInfo;
    }
}
