package com.wifi.csj.ad;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import com.amap.api.col.p0002sl.hb;
import com.bytedance.sdk.openadsdk.CSJSplashAd;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.core.l.u.jk;
import com.bytedance.sdk.openadsdk.core.nativeexpress.k;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.cdo.oaps.ad.OapsKey;
import com.kuaishou.weapon.p0.t;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.entity.SensitiveInfo;
import com.wifi.ad.core.utils.ReflectUtils;
import com.wifi.ad.core.utils.WifiLog;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ/\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\rJ\u001f\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u0011J/\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\rJ\u001f\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ/\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\rJ\u001f\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u0018J\u001f\u0010\u0019\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u001a2\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u001bJ/\u0010\u001c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u001d2\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\rJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001f\u001a\u00020 J\u001f\u0010!\u001a\u0004\u0018\u00010\u00042\u0006\u0010\"\u001a\u00020#2\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010$J\u0018\u0010%\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u00012\u0006\u0010'\u001a\u00020\u0004H\u0002J\u0018\u0010(\u001a\u00020\u00042\u0006\u0010&\u001a\u00020)2\u0006\u0010'\u001a\u00020\u0004H\u0002J\u0018\u0010*\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u00012\u0006\u0010'\u001a\u00020\u0004H\u0002J\u0018\u0010+\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u00012\u0006\u0010'\u001a\u00020\u0004H\u0002J\u0018\u0010,\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u00012\u0006\u0010'\u001a\u00020\u0004H\u0002J\u0018\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u0010'\u001a\u00020\u0004H\u0002J\u001a\u00101\u001a\u00020.2\b\u00102\u001a\u0004\u0018\u00010\u00012\u0006\u0010'\u001a\u00020\u0004H\u0002J$\u00103\u001a\u00020.2\u0012\u00104\u001a\u000e\u0012\u0002\b\u000305j\u0006\u0012\u0002\b\u0003`62\u0006\u0010'\u001a\u00020\u0004H\u0002J\u0018\u00107\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u0010'\u001a\u00020\u0004H\u0002J\u0018\u00108\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u0004H\u0002J\u0018\u00109\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\u0004H\u0002J\u0018\u0010:\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\u0004H\u0002J\u0018\u0010;\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u0004H\u0002J\u0018\u0010=\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u0004H\u0002J\u0018\u0010>\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\u0004H\u0002J\u0018\u0010?\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u0010'\u001a\u00020\u0004H\u0002J\u001a\u0010@\u001a\u00020.2\b\u0010&\u001a\u0004\u0018\u00010\u00012\u0006\u0010'\u001a\u00020\u0004H\u0002J\u0018\u0010A\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u0004H\u0002J\u0018\u0010B\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u0004H\u0002J\u0018\u0010C\u001a\u00020.2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010D\u001a\u00020.2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\u0004H\u0002J\u0018\u0010E\u001a\u00020.2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010'\u001a\u00020\u0004H\u0002¨\u0006F"}, d2 = {"Lcom/wifi/csj/ad/CsjSensitiveCatcher;", "", "()V", "catchCsjExpressDrawAd", "Lcom/wifi/ad/core/entity/SensitiveInfo;", "expressAd", "Lcom/bytedance/sdk/openadsdk/TTNativeExpressAd;", "adLevel", "", "(Lcom/bytedance/sdk/openadsdk/TTNativeExpressAd;Ljava/lang/Integer;)Lcom/wifi/ad/core/entity/SensitiveInfo;", "catchCsjExpressDrawAds", "", "adList", "(Ljava/util/List;Ljava/lang/Integer;)Ljava/util/List;", "catchCsjExpressNativeAd", "drawNativeAd", "Lcom/bytedance/sdk/openadsdk/TTFeedAd;", "(Lcom/bytedance/sdk/openadsdk/TTFeedAd;Ljava/lang/Integer;)Lcom/wifi/ad/core/entity/SensitiveInfo;", "catchCsjExpressNativeAds", "catchCsjExpressTemplateAd", "catchCsjExpressTemplateAds", "catchCsjInterstitialAd", "fullScreenVideoAd", "Lcom/bytedance/sdk/openadsdk/TTFullScreenVideoAd;", "(Lcom/bytedance/sdk/openadsdk/TTFullScreenVideoAd;Ljava/lang/Integer;)Lcom/wifi/ad/core/entity/SensitiveInfo;", "catchCsjNativeDrawAd", "Lcom/bytedance/sdk/openadsdk/TTDrawFeedAd;", "(Lcom/bytedance/sdk/openadsdk/TTDrawFeedAd;Ljava/lang/Integer;)Lcom/wifi/ad/core/entity/SensitiveInfo;", "catchCsjNativeDrawAds", "", "catchCsjRewardAd", "rewardAd", "Lcom/bytedance/sdk/openadsdk/TTRewardVideoAd;", "catchCsjSplashAd", "splashAd", "Lcom/bytedance/sdk/openadsdk/CSJSplashAd;", "(Lcom/bytedance/sdk/openadsdk/CSJSplashAd;Ljava/lang/Integer;)Lcom/wifi/ad/core/entity/SensitiveInfo;", "createInfoByAd", "instanceO", "sensitiveInfo", "createInfoByAdDown", "Lcom/ss/android/downloadad/api/download/AdDownloadModel;", "createInfoByAllData", "createInfoByAllDataNormal", "createInfoByOppoAllData", "getAppName", "", "aeJson", "Lorg/json/JSONObject;", "getCommonSensitiveFrom4607", "instance", "getCoverUrl", "list", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getDeveloperName", "getExpressDrawFrom4607Version", "getExpressFeedSensitiveFrom4607", "getExpressFeedSensitiveFrom5305", "getInterstitialSensitiveFrom", "ad", "getInterstitialSensitiveFrom4607", "getNativeDrawSensitiveFrom4607", "getPackageName", "getSplashSensitiveFrom5305", "getTemplateFrom4607Version", "getTemplateFromVersion", "initSensitive", "setCoverUrl", "setInteractionType", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
public final class CsjSensitiveCatcher {
    public static final CsjSensitiveCatcher INSTANCE = new CsjSensitiveCatcher();

    private CsjSensitiveCatcher() {
    }

    private final SensitiveInfo createInfoByAd(Object instanceO, SensitiveInfo sensitiveInfo) {
        try {
            WifiLog.d("catchSensitiveInfo instanceO " + instanceO);
            if (instanceO != null) {
                ReflectUtils reflectUtils = ReflectUtils.INSTANCE;
                Object value = reflectUtils.getValue(instanceO, "nk");
                if (value instanceof String) {
                    JSONObject jSONObject = new JSONObject((String) value);
                    String strOptString = jSONObject.optString("app_name");
                    Intrinsics.checkExpressionValueIsNotNull(strOptString, "resObj.optString(\"app_name\")");
                    sensitiveInfo.setAppName(strOptString);
                    String strOptString2 = jSONObject.optString("package_name");
                    Intrinsics.checkExpressionValueIsNotNull(strOptString2, "resObj.optString(\"package_name\")");
                    sensitiveInfo.setPackageName(strOptString2);
                    String strOptString3 = jSONObject.optString(WfConstant.EXTRA_KEY_DEVELOPER_NAME);
                    Intrinsics.checkExpressionValueIsNotNull(strOptString3, "resObj.optString(\"developer_name\")");
                    sensitiveInfo.setAuthorName(strOptString3);
                }
                Object value2 = reflectUtils.getValue(instanceO, "mx");
                if (value2 != null) {
                    Object value3 = reflectUtils.getValue(value2, "lo");
                    if (value3 instanceof String) {
                        sensitiveInfo.setDownloadUrl((String) value3);
                    }
                }
                Object value4 = reflectUtils.getValue(instanceO, "y");
                if (value4 instanceof String) {
                    sensitiveInfo.setTitle((String) value4);
                }
                Object value5 = reflectUtils.getValue(instanceO, "qx");
                if (value5 instanceof String) {
                    sensitiveInfo.setDeepUrl((String) value5);
                }
                Object value6 = reflectUtils.getValue(instanceO, "ku");
                if ((value6 instanceof List) && ((List) value6).size() > 0) {
                    Object obj = ((List) value6).get(0);
                    if (obj == null) {
                        Intrinsics.throwNpe();
                    }
                    Object value7 = reflectUtils.getValue(obj, "lo");
                    if (value7 instanceof String) {
                        sensitiveInfo.setCoverUrl((String) value7);
                    }
                }
                Object value8 = reflectUtils.getValue(instanceO, "pm");
                if (value8 instanceof String) {
                    sensitiveInfo.setH5Url((String) value8);
                }
                Object value9 = reflectUtils.getValue(instanceO, hb.j);
                if (value9 != null) {
                    Object value10 = reflectUtils.getValue(value9, "lo");
                    if (value10 != null) {
                        Object value11 = reflectUtils.getValue(value10, "pm");
                        if (value11 instanceof String) {
                            sensitiveInfo.setCoverUrl((String) value11);
                        }
                        Object value12 = reflectUtils.getValue(value10, CmcdConfiguration.KEY_OBJECT_TYPE);
                        if (value12 instanceof String) {
                            sensitiveInfo.setVideoUrl((String) value12);
                        }
                    } else {
                        Object value13 = reflectUtils.getValue(value9, "wd");
                        if (value13 != null) {
                            Object value14 = reflectUtils.getValue(value13, "pm");
                            if (value14 instanceof String) {
                                sensitiveInfo.setCoverUrl((String) value14);
                            }
                            Object value15 = reflectUtils.getValue(value13, CmcdConfiguration.KEY_OBJECT_TYPE);
                            if (value15 instanceof String) {
                                sensitiveInfo.setVideoUrl((String) value15);
                            }
                        }
                    }
                }
                try {
                    if (WifiNestAd.INSTANCE.getBackDoorResult()) {
                        Object value16 = reflectUtils.getValue(instanceO, "e");
                        if (value16 instanceof JSONObject) {
                            sensitiveInfo.setShenheSdkId(value16.toString());
                        }
                    }
                } catch (Exception unused) {
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sensitiveInfo;
    }

    private final SensitiveInfo createInfoByAdDown(AdDownloadModel instanceO, SensitiveInfo sensitiveInfo) {
        JSONObject jSONObjectOptJSONObject;
        try {
            WifiLog.d("catchSensitiveInfo instanceO " + instanceO);
            if (instanceO != null) {
                String name = instanceO.getName();
                Intrinsics.checkExpressionValueIsNotNull(name, "instanceO.name");
                sensitiveInfo.setAppName(name);
                String packageName = instanceO.getPackageName();
                Intrinsics.checkExpressionValueIsNotNull(packageName, "instanceO.packageName");
                sensitiveInfo.setPackageName(packageName);
                String downloadUrl = instanceO.getDownloadUrl();
                Intrinsics.checkExpressionValueIsNotNull(downloadUrl, "instanceO.downloadUrl");
                sensitiveInfo.setDownloadUrl(downloadUrl);
                JSONObject extra = instanceO.getExtra();
                if (extra != null && (jSONObjectOptJSONObject = extra.optJSONObject(jk.EXTRA_DOWN_INFO_KEY).optJSONObject("material_meta")) != null) {
                    String strOptString = jSONObjectOptJSONObject.optString("target_url");
                    Intrinsics.checkExpressionValueIsNotNull(strOptString, "material_meta.optString(\"target_url\")");
                    sensitiveInfo.setH5Url(strOptString);
                    JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("image");
                    if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                        String strOptString2 = jSONArrayOptJSONArray.optJSONObject(0).optString("url");
                        Intrinsics.checkExpressionValueIsNotNull(strOptString2, "imgOb.optJSONObject(0).optString(\"url\")");
                        sensitiveInfo.setCoverUrl(strOptString2);
                    }
                    String strOptString3 = jSONObjectOptJSONObject.optString("title");
                    Intrinsics.checkExpressionValueIsNotNull(strOptString3, "material_meta.optString(\"title\")");
                    sensitiveInfo.setTitle(strOptString3);
                    String strOptString4 = jSONObjectOptJSONObject.optString("description");
                    Intrinsics.checkExpressionValueIsNotNull(strOptString4, "material_meta.optString(\"description\")");
                    sensitiveInfo.setDesc(strOptString4);
                    JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("app");
                    if (jSONObjectOptJSONObject2 != null) {
                        String strOptString5 = jSONObjectOptJSONObject2.optString("app_name");
                        Intrinsics.checkExpressionValueIsNotNull(strOptString5, "appOb.optString(\"app_name\")");
                        sensitiveInfo.setAppName(strOptString5);
                        String strOptString6 = jSONObjectOptJSONObject2.optString("package_name");
                        Intrinsics.checkExpressionValueIsNotNull(strOptString6, "appOb.optString(\"package_name\")");
                        sensitiveInfo.setPackageName(strOptString6);
                        String strOptString7 = jSONObjectOptJSONObject2.optString(WfConstant.EXTRA_KEY_DOWNLOAD_URL);
                        Intrinsics.checkExpressionValueIsNotNull(strOptString7, "appOb.optString(\"download_url\")");
                        sensitiveInfo.setDownloadUrl(strOptString7);
                    }
                    JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject("video");
                    if (jSONObjectOptJSONObject3 == null) {
                        jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject("h265_video");
                    }
                    if (jSONObjectOptJSONObject3 != null) {
                        String strOptString8 = jSONObjectOptJSONObject3.optString(WfConstant.EXTRA_KEY_VIDEO_URL);
                        Intrinsics.checkExpressionValueIsNotNull(strOptString8, "videoOb.optString(\"video_url\")");
                        sensitiveInfo.setVideoUrl(strOptString8);
                        String strOptString9 = jSONObjectOptJSONObject3.optString("cover_url");
                        Intrinsics.checkExpressionValueIsNotNull(strOptString9, "videoOb.optString(\"cover_url\")");
                        sensitiveInfo.setCoverUrl(strOptString9);
                    }
                    if (!TextUtils.isEmpty(jSONObjectOptJSONObject.optString(WfConstant.EXTRA_KEY_MARKET_URL))) {
                        String strOptString10 = jSONObjectOptJSONObject.optString(WfConstant.EXTRA_KEY_MARKET_URL);
                        Intrinsics.checkExpressionValueIsNotNull(strOptString10, "material_meta.optString(\"market_url\")");
                        sensitiveInfo.setDeepUrl(strOptString10);
                    }
                    JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject.optJSONObject("app_manage");
                    if (jSONObjectOptJSONObject4 != null) {
                        String strOptString11 = jSONObjectOptJSONObject4.optString(WfConstant.EXTRA_KEY_DEVELOPER_NAME);
                        Intrinsics.checkExpressionValueIsNotNull(strOptString11, "app_manageOb.optString(\"developer_name\")");
                        sensitiveInfo.setAuthorName(strOptString11);
                    }
                    try {
                        if (WifiNestAd.INSTANCE.getBackDoorResult()) {
                            String string = jSONObjectOptJSONObject.toString();
                            Intrinsics.checkExpressionValueIsNotNull(string, "material_meta.toString()");
                            sensitiveInfo.setShenheSdkId(string);
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sensitiveInfo;
    }

    private final SensitiveInfo createInfoByAllData(Object instanceO, SensitiveInfo sensitiveInfo) {
        Object value;
        try {
            WifiLog.d("third createInfoByAllData instanceO " + instanceO);
            if (instanceO != null) {
                ReflectUtils reflectUtils = ReflectUtils.INSTANCE;
                Object value2 = reflectUtils.getValue(instanceO, RXScreenCaptureService.KEY_WIDTH);
                if (value2 != null) {
                    Object value3 = reflectUtils.getValue(value2, "yi");
                    if (value3 instanceof String) {
                        sensitiveInfo.setPackageName((String) value3);
                    }
                    Object value4 = reflectUtils.getValue(value2, "y");
                    if (value4 instanceof String) {
                        sensitiveInfo.setAppName((String) value4);
                    }
                    Object value5 = reflectUtils.getValue(value2, "yg");
                    if (value5 instanceof String) {
                        sensitiveInfo.setDownloadUrl((String) value5);
                    }
                }
                Object value6 = reflectUtils.getValue(instanceO, "wz");
                if (value6 instanceof String) {
                    sensitiveInfo.setH5Url((String) value6);
                }
                Object value7 = reflectUtils.getValue(instanceO, "c");
                if (value7 instanceof String) {
                    sensitiveInfo.setTitle((String) value7);
                }
                Object value8 = reflectUtils.getValue(instanceO, "or");
                if (value8 instanceof String) {
                    sensitiveInfo.setDeepUrl((String) value8);
                }
                Object value9 = reflectUtils.getValue(instanceO, "es");
                if ((value9 instanceof ArrayList) && ((ArrayList) value9).size() > 0) {
                    Object value10 = reflectUtils.getValue(((ArrayList) value9).get(0), "yg");
                    if (value10 instanceof String) {
                        sensitiveInfo.setCoverUrl((String) value10);
                    }
                }
                Object value11 = reflectUtils.getValue(instanceO, "qt");
                if (value11 != null && (value = reflectUtils.getValue(value11, "y")) != null) {
                    Object value12 = reflectUtils.getValue(value, WfConstant.EXTRA_KEY_VIDEO_URL);
                    if (value12 instanceof String) {
                        sensitiveInfo.setVideoUrl((String) value12);
                    }
                }
                Object value13 = reflectUtils.getValue(instanceO, "kl");
                if (value13 instanceof String) {
                    JSONObject jSONObject = new JSONObject((String) value13);
                    if (TextUtils.isEmpty(sensitiveInfo.getAppName())) {
                        String strOptString = jSONObject.optString("app_name");
                        Intrinsics.checkExpressionValueIsNotNull(strOptString, "appJSONObject.optString(\"app_name\")");
                        sensitiveInfo.setAppName(strOptString);
                    }
                    if (TextUtils.isEmpty(sensitiveInfo.getPackageName())) {
                        String strOptString2 = jSONObject.optString("package_name");
                        Intrinsics.checkExpressionValueIsNotNull(strOptString2, "appJSONObject.optString(\"package_name\")");
                        sensitiveInfo.setPackageName(strOptString2);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sensitiveInfo;
    }

    private final SensitiveInfo createInfoByAllDataNormal(Object instanceO, SensitiveInfo sensitiveInfo) {
        Object value;
        try {
            WifiLog.d("third createInfoByAllDataNormal instanceO " + instanceO);
            if (instanceO != null) {
                ReflectUtils reflectUtils = ReflectUtils.INSTANCE;
                Object value2 = reflectUtils.getValue(instanceO, "dw");
                if (value2 != null) {
                    Object value3 = reflectUtils.getValue(value2, "fx");
                    if (value3 instanceof String) {
                        sensitiveInfo.setPackageName((String) value3);
                    }
                    Object value4 = reflectUtils.getValue(value2, "nr");
                    if (value4 instanceof String) {
                        sensitiveInfo.setAppName((String) value4);
                    }
                    Object value5 = reflectUtils.getValue(value2, "u");
                    if (value5 instanceof String) {
                        sensitiveInfo.setDownloadUrl((String) value5);
                    }
                }
                Object value6 = reflectUtils.getValue(instanceO, "iz");
                if (value6 instanceof String) {
                    sensitiveInfo.setH5Url((String) value6);
                }
                Object value7 = reflectUtils.getValue(instanceO, "kj");
                if (value7 instanceof String) {
                    sensitiveInfo.setTitle((String) value7);
                }
                Object value8 = reflectUtils.getValue(instanceO, "vz");
                if (value8 instanceof String) {
                    sensitiveInfo.setDeepUrl((String) value8);
                }
                Object value9 = reflectUtils.getValue(instanceO, "t");
                if ((value9 instanceof ArrayList) && ((ArrayList) value9).size() > 0) {
                    Object value10 = reflectUtils.getValue(((ArrayList) value9).get(0), "u");
                    if (value10 instanceof String) {
                        sensitiveInfo.setCoverUrl((String) value10);
                    }
                }
                Object value11 = reflectUtils.getValue(instanceO, "wq");
                if (value11 != null && (value = reflectUtils.getValue(value11, "u")) != null) {
                    Object value12 = reflectUtils.getValue(value, "x");
                    if (value12 instanceof String) {
                        sensitiveInfo.setVideoUrl((String) value12);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sensitiveInfo;
    }

    private final SensitiveInfo createInfoByOppoAllData(Object instanceO, SensitiveInfo sensitiveInfo) {
        Object value;
        try {
            WifiLog.d("third createInfoByOppoAllData instanceO " + instanceO);
            if (instanceO != null) {
                ReflectUtils reflectUtils = ReflectUtils.INSTANCE;
                Object value2 = reflectUtils.getValue(instanceO, "i");
                if (value2 != null) {
                    Object value3 = reflectUtils.getValue(value2, "x");
                    if (value3 instanceof String) {
                        sensitiveInfo.setPackageName((String) value3);
                    }
                    Object value4 = reflectUtils.getValue(value2, "q");
                    if (value4 instanceof String) {
                        sensitiveInfo.setAppName((String) value4);
                    }
                    Object value5 = reflectUtils.getValue(value2, "u");
                    if (value5 instanceof String) {
                        sensitiveInfo.setDownloadUrl((String) value5);
                    }
                }
                Object value6 = reflectUtils.getValue(instanceO, "wy");
                if (value6 instanceof String) {
                    sensitiveInfo.setH5Url((String) value6);
                }
                Object value7 = reflectUtils.getValue(instanceO, "qi");
                if (value7 instanceof String) {
                    sensitiveInfo.setTitle((String) value7);
                }
                Object value8 = reflectUtils.getValue(instanceO, "q");
                if (value8 instanceof String) {
                    sensitiveInfo.setDeepUrl((String) value8);
                }
                Object value9 = reflectUtils.getValue(instanceO, "pa");
                if ((value9 instanceof ArrayList) && ((ArrayList) value9).size() > 0) {
                    Object value10 = reflectUtils.getValue(((ArrayList) value9).get(0), "u");
                    if (value10 instanceof String) {
                        sensitiveInfo.setCoverUrl((String) value10);
                    }
                }
                Object value11 = reflectUtils.getValue(instanceO, t.q);
                if (value11 != null && (value = reflectUtils.getValue(value11, "u")) != null) {
                    Object value12 = reflectUtils.getValue(value, "iq");
                    if (value12 instanceof String) {
                        sensitiveInfo.setVideoUrl((String) value12);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sensitiveInfo;
    }

    private final void getAppName(JSONObject aeJson, SensitiveInfo sensitiveInfo) {
        if ((aeJson != null ? Boolean.valueOf(aeJson.has("app_name")) : null).booleanValue()) {
            String strOptString = aeJson.optString("app_name");
            if (strOptString instanceof String) {
                sensitiveInfo.setAppName(strOptString);
            }
        }
    }

    private final void getCommonSensitiveFrom4607(Object instance, SensitiveInfo sensitiveInfo) throws JSONException {
        if (instance != null) {
            ReflectUtils reflectUtils = ReflectUtils.INSTANCE;
            Object value = reflectUtils.getValue(instance, "bt");
            if (value instanceof String) {
                JSONObject jSONObject = new JSONObject((String) value);
                getAppName(jSONObject, sensitiveInfo);
                getDeveloperName(jSONObject, sensitiveInfo);
                getPackageName(jSONObject, sensitiveInfo);
            }
            if (TextUtils.isEmpty(sensitiveInfo.getTitle())) {
                Object value2 = reflectUtils.getValue(instance, "n");
                if (value2 instanceof String) {
                    sensitiveInfo.setTitle((String) value2);
                }
            }
            if (TextUtils.isEmpty(sensitiveInfo.getDesc())) {
                Object value3 = reflectUtils.getValue(instance, "p");
                if (value3 instanceof String) {
                    sensitiveInfo.setDesc((String) value3);
                }
            }
            Object value4 = reflectUtils.getValue(instance, "f");
            if (value4 instanceof String) {
                sensitiveInfo.setH5Url((String) value4);
            }
            Object value5 = reflectUtils.getValue(instance, hb.j);
            if (value5 instanceof ArrayList) {
                getCoverUrl((ArrayList) value5, sensitiveInfo);
            }
            Object value6 = reflectUtils.getValue(instance, ExifInterface.LONGITUDE_EAST);
            Object value7 = reflectUtils.getValue(value6, "f");
            if (value7 instanceof String) {
                sensitiveInfo.setCoverUrl((String) value7);
            }
            Object value8 = reflectUtils.getValue(value6, "g");
            if (value8 instanceof String) {
                sensitiveInfo.setVideoUrl((String) value8);
            }
            Object value9 = reflectUtils.getValue(value6, "d");
            if (value9 instanceof Double) {
                sensitiveInfo.setVideoDuration(((Number) value9).doubleValue());
            }
            Object value10 = reflectUtils.getValue(value6, "c");
            if (value10 instanceof Long) {
                sensitiveInfo.setVideoSize(((Number) value10).longValue());
            }
            Object value11 = reflectUtils.getValue(instance, "z");
            if (value11 instanceof JSONObject) {
                Object obj = ((JSONObject) value11).get(MediationConstant.EXTRA_ADID);
                if (obj instanceof Long) {
                    sensitiveInfo.setAdId(obj.toString());
                }
            }
            Object value12 = reflectUtils.getValue(reflectUtils.getValue(instance, "t"), "a");
            WifiLog.d("getSensitiveInfoByClassL downloadUrl = " + value12);
            if (value12 instanceof String) {
                sensitiveInfo.setDownloadUrl((String) value12);
            }
            Object value13 = reflectUtils.getValue(instance, "X");
            WifiLog.d("getSensitiveInfoByClassL deepUrl = " + value13);
            if (value13 instanceof String) {
                sensitiveInfo.setDeepUrl((String) value13);
            }
        }
    }

    private final void getCoverUrl(ArrayList<?> list, SensitiveInfo sensitiveInfo) {
        if (list == null || list.size() <= 0) {
            return;
        }
        Object value = ReflectUtils.INSTANCE.getValue(list.get(0), "a");
        if (value instanceof String) {
            sensitiveInfo.setCoverUrl((String) value);
        }
    }

    private final void getDeveloperName(JSONObject aeJson, SensitiveInfo sensitiveInfo) {
        if ((aeJson != null ? Boolean.valueOf(aeJson.has(WfConstant.EXTRA_KEY_DEVELOPER_NAME)) : null).booleanValue()) {
            String strOptString = aeJson.optString(WfConstant.EXTRA_KEY_DEVELOPER_NAME);
            if (strOptString instanceof String) {
                sensitiveInfo.setAuthorName(strOptString);
            }
        }
    }

    private final SensitiveInfo getExpressDrawFrom4607Version(TTNativeExpressAd expressAd, SensitiveInfo sensitiveInfo) {
        Class<? super Object> superclass;
        if (expressAd != null) {
            try {
                Class<? super Object> superclass2 = expressAd.getClass().getSuperclass();
                if (superclass2 != null && (superclass = superclass2.getSuperclass()) != null) {
                    Object value = ReflectUtils.INSTANCE.getValue(expressAd, superclass, "c");
                    WifiLog.d("catchSensitiveInfo instanceC " + value);
                    getCommonSensitiveFrom4607(value, sensitiveInfo);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sensitiveInfo;
    }

    private final SensitiveInfo getExpressFeedSensitiveFrom4607(TTFeedAd drawNativeAd, SensitiveInfo sensitiveInfo) {
        try {
            initSensitive(sensitiveInfo, drawNativeAd);
            Object value = ReflectUtils.INSTANCE.getValue(drawNativeAd, drawNativeAd != null ? drawNativeAd.getClass().getSuperclass() : null, "i");
            WifiLog.d("catchSensitiveInfo instanceI " + value);
            getCommonSensitiveFrom4607(value, sensitiveInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sensitiveInfo;
    }

    private final SensitiveInfo getExpressFeedSensitiveFrom5305(TTFeedAd drawNativeAd, SensitiveInfo sensitiveInfo) {
        ClassLoader classLoader;
        try {
            initSensitive(sensitiveInfo, drawNativeAd);
            ReflectUtils reflectUtils = ReflectUtils.INSTANCE;
            Object value = reflectUtils.getValue(drawNativeAd, "u");
            if (value != null && (classLoader = value.getClass().getClassLoader()) != null) {
                WifiLog.d("third getExpressFeed eClassLoader " + classLoader);
            }
            Object value2 = reflectUtils.getValue(value, "my");
            if (value2 != null) {
                createInfoByAllDataNormal(value2, sensitiveInfo);
            } else {
                Object value3 = reflectUtils.getValue(value, "wd");
                if (value3 != null) {
                    createInfoByAllData(value3, sensitiveInfo);
                } else {
                    Object value4 = reflectUtils.getValue(value, "xx");
                    if (value4 != null) {
                        createInfoByOppoAllData(value4, sensitiveInfo);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sensitiveInfo;
    }

    private final SensitiveInfo getInterstitialSensitiveFrom(TTFullScreenVideoAd ad, SensitiveInfo sensitiveInfo) {
        try {
            ReflectUtils reflectUtils = ReflectUtils.INSTANCE;
            Object value = reflectUtils.getValue(ad, "u");
            if (value != null) {
                ClassLoader classLoader = value.getClass().getClassLoader();
                if (classLoader != null) {
                    WifiLog.d("third getInterstitial eClassLoader " + classLoader);
                }
                Object value2 = reflectUtils.getValue(value, "nr");
                if (value2 != null) {
                    createInfoByAllDataNormal(value2, sensitiveInfo);
                } else {
                    Object value3 = reflectUtils.getValue(value, "y");
                    if (value3 == null || (value3 instanceof Boolean)) {
                        Object value4 = reflectUtils.getValue(value, "q");
                        if (value4 != null) {
                            createInfoByOppoAllData(value4, sensitiveInfo);
                        }
                    } else {
                        createInfoByAllData(value3, sensitiveInfo);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sensitiveInfo;
    }

    private final SensitiveInfo getInterstitialSensitiveFrom4607(TTFullScreenVideoAd ad, SensitiveInfo sensitiveInfo) {
        try {
            Object value = ReflectUtils.INSTANCE.getValue(ad, ad != null ? ad.getClass() : null, t.l);
            WifiLog.d("catchSensitiveInfo instanceB " + value);
            getCommonSensitiveFrom4607(value, sensitiveInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sensitiveInfo;
    }

    private final SensitiveInfo getNativeDrawSensitiveFrom4607(TTFeedAd drawNativeAd, SensitiveInfo sensitiveInfo) {
        ClassLoader classLoader;
        try {
            initSensitive(sensitiveInfo, drawNativeAd);
            ReflectUtils reflectUtils = ReflectUtils.INSTANCE;
            Object value = reflectUtils.getValue(drawNativeAd, "u");
            if (value != null && (classLoader = value.getClass().getClassLoader()) != null) {
                WifiLog.d("third getNativeDraw eClassLoader " + classLoader);
            }
            Object value2 = reflectUtils.getValue(value, "x");
            if (value2 != null) {
                createInfoByAllDataNormal(value2, sensitiveInfo);
            } else {
                Object value3 = reflectUtils.getValue(value, "l");
                if (value3 != null) {
                    createInfoByAllData(value3, sensitiveInfo);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sensitiveInfo;
    }

    private final void getPackageName(JSONObject aeJson, SensitiveInfo sensitiveInfo) {
        if ((aeJson != null ? Boolean.valueOf(aeJson.has("package_name")) : null).booleanValue()) {
            String strOptString = aeJson.optString("package_name");
            if (strOptString instanceof String) {
                sensitiveInfo.setPackageName(strOptString);
            }
        }
    }

    private final void getSplashSensitiveFrom5305(Object instanceO, SensitiveInfo sensitiveInfo) {
        if (instanceO != null) {
            try {
                ReflectUtils reflectUtils = ReflectUtils.INSTANCE;
                Object value = reflectUtils.getValue(instanceO, "ab");
                if (value instanceof String) {
                    JSONObject jSONObject = new JSONObject((String) value);
                    String strOptString = jSONObject.optString("app_name");
                    Intrinsics.checkExpressionValueIsNotNull(strOptString, "resObj.optString(\"app_name\")");
                    sensitiveInfo.setAppName(strOptString);
                    String strOptString2 = jSONObject.optString("package_name");
                    Intrinsics.checkExpressionValueIsNotNull(strOptString2, "resObj.optString(\"package_name\")");
                    sensitiveInfo.setPackageName(strOptString2);
                    String strOptString3 = jSONObject.optString(WfConstant.EXTRA_KEY_DEVELOPER_NAME);
                    Intrinsics.checkExpressionValueIsNotNull(strOptString3, "resObj.optString(\"developer_name\")");
                    sensitiveInfo.setAuthorName(strOptString3);
                }
                Object value2 = reflectUtils.getValue(instanceO, "z");
                if (value2 != null) {
                    Object value3 = reflectUtils.getValue(value2, "dr");
                    if (value3 instanceof String) {
                        sensitiveInfo.setDownloadUrl((String) value3);
                    }
                }
                Object value4 = reflectUtils.getValue(instanceO, "v");
                if (value4 instanceof String) {
                    sensitiveInfo.setTitle((String) value4);
                }
                Object value5 = reflectUtils.getValue(instanceO, "wb");
                if ((value5 instanceof List) && ((List) value5).size() > 0) {
                    Object obj = ((List) value5).get(0);
                    if (obj == null) {
                        Intrinsics.throwNpe();
                    }
                    Object value6 = reflectUtils.getValue(obj, "dr");
                    if (value6 instanceof String) {
                        sensitiveInfo.setCoverUrl((String) value6);
                    }
                }
                Object value7 = reflectUtils.getValue(instanceO, "bn");
                if (value7 instanceof String) {
                    sensitiveInfo.setH5Url((String) value7);
                }
                Object value8 = reflectUtils.getValue(instanceO, t.l);
                if (value8 instanceof String) {
                    sensitiveInfo.setDeepUrl((String) value8);
                }
                Object value9 = reflectUtils.getValue(instanceO, OapsKey.KEY_BG);
                if (value9 != null) {
                    Object value10 = reflectUtils.getValue(value9, "dr");
                    if (value10 != null) {
                        Object value11 = reflectUtils.getValue(value10, "bn");
                        if (value11 instanceof String) {
                            sensitiveInfo.setCoverUrl((String) value11);
                        }
                        Object value12 = reflectUtils.getValue(value10, "rb");
                        if (value12 instanceof String) {
                            sensitiveInfo.setVideoUrl((String) value12);
                            return;
                        }
                        return;
                    }
                    Object value13 = reflectUtils.getValue(value9, "ge");
                    if (value13 != null) {
                        Object value14 = reflectUtils.getValue(value13, "bn");
                        if (value14 instanceof String) {
                            sensitiveInfo.setCoverUrl((String) value14);
                        }
                        Object value15 = reflectUtils.getValue(value13, "rb");
                        if (value15 instanceof String) {
                            sensitiveInfo.setVideoUrl((String) value15);
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    private final SensitiveInfo getTemplateFrom4607Version(TTNativeExpressAd expressAd, SensitiveInfo sensitiveInfo) {
        try {
            Object value = ReflectUtils.INSTANCE.getValue(expressAd, expressAd != null ? expressAd.getClass().getSuperclass() : null, "c");
            WifiLog.d("catchSensitiveInfo instanceC " + value);
            getCommonSensitiveFrom4607(value, sensitiveInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sensitiveInfo;
    }

    private final SensitiveInfo getTemplateFromVersion(TTNativeExpressAd expressAd, SensitiveInfo sensitiveInfo) {
        ClassLoader classLoader;
        try {
            ReflectUtils reflectUtils = ReflectUtils.INSTANCE;
            Object value = reflectUtils.getValue(expressAd, "u");
            if (value != null && (classLoader = value.getClass().getClassLoader()) != null) {
                WifiLog.d("third getTemplate eClassLoader " + classLoader);
            }
            Object value2 = reflectUtils.getValue(value, value != null ? value.getClass().getSuperclass() : null, "fx");
            if (value2 != null) {
                createInfoByAllDataNormal(value2, sensitiveInfo);
            } else {
                Object value3 = reflectUtils.getValue(value, value != null ? value.getClass().getSuperclass() : null, "yi");
                if (value3 != null) {
                    createInfoByAllData(value3, sensitiveInfo);
                } else {
                    Object value4 = reflectUtils.getValue(value, value != null ? value.getClass() : null, "x");
                    if (value4 != null) {
                        createInfoByOppoAllData(value4, sensitiveInfo);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sensitiveInfo;
    }

    private final void initSensitive(SensitiveInfo sensitiveInfo, TTFeedAd drawNativeAd) {
        sensitiveInfo.setVideoDuration(drawNativeAd.getVideoDuration());
        String title = drawNativeAd.getTitle();
        Intrinsics.checkExpressionValueIsNotNull(title, "drawNativeAd.title");
        sensitiveInfo.setTitle(title);
        String description = drawNativeAd.getDescription();
        Intrinsics.checkExpressionValueIsNotNull(description, "drawNativeAd.description");
        sensitiveInfo.setDesc(description);
        TTFeedAd.CustomizeVideo customVideo = drawNativeAd.getCustomVideo();
        if (!TextUtils.isEmpty(customVideo != null ? customVideo.getVideoUrl() : null)) {
            TTFeedAd.CustomizeVideo customVideo2 = drawNativeAd.getCustomVideo();
            Intrinsics.checkExpressionValueIsNotNull(customVideo2, "drawNativeAd.customVideo");
            String videoUrl = customVideo2.getVideoUrl();
            Intrinsics.checkExpressionValueIsNotNull(videoUrl, "drawNativeAd.customVideo.videoUrl");
            sensitiveInfo.setVideoUrl(videoUrl);
        }
        setCoverUrl(drawNativeAd, sensitiveInfo);
    }

    private final void setCoverUrl(TTFeedAd drawNativeAd, SensitiveInfo sensitiveInfo) {
        String imageUrl;
        int imageMode = drawNativeAd.getImageMode();
        String imageUrl2 = null;
        if (imageMode == 5 || imageMode == 15) {
            TTImage videoCoverImage = drawNativeAd.getVideoCoverImage();
            if (videoCoverImage != null && (imageUrl = videoCoverImage.getImageUrl()) != null) {
                imageUrl2 = imageUrl;
            }
        } else {
            List<TTImage> imageList = drawNativeAd.getImageList();
            if (imageList != null) {
                for (TTImage it : imageList) {
                    Intrinsics.checkExpressionValueIsNotNull(it, "it");
                    imageUrl2 = it.getImageUrl();
                }
            }
        }
        if (TextUtils.isEmpty(imageUrl2)) {
            return;
        }
        sensitiveInfo.setCoverUrl(String.valueOf(imageUrl2));
    }

    private final void setInteractionType(TTRewardVideoAd rewardAd, SensitiveInfo sensitiveInfo) {
        if (rewardAd != null) {
            if (rewardAd.getInteractionType() == 4) {
                sensitiveInfo.setInteractionType(1);
            } else {
                sensitiveInfo.setInteractionType(2);
            }
        }
    }

    public final SensitiveInfo catchCsjExpressDrawAd(TTNativeExpressAd expressAd, Integer adLevel) {
        SensitiveInfo sensitiveInfo = new SensitiveInfo();
        sensitiveInfo.setContentSourceId(String.valueOf(sensitiveInfo.getCONTENT_RESOURCE_TT_AD()));
        sensitiveInfo.setAdLevel(adLevel);
        if (expressAd.getInteractionType() == 4) {
            sensitiveInfo.setInteractionType(1);
        } else {
            sensitiveInfo.setInteractionType(2);
        }
        getExpressDrawFrom4607Version(expressAd, sensitiveInfo);
        try {
            Field declaredField = k.class.getDeclaredField("c");
            Intrinsics.checkExpressionValueIsNotNull(declaredField, "kClass.getDeclaredField(\"c\")");
            declaredField.setAccessible(true);
            declaredField.get(expressAd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sensitiveInfo;
    }

    public final List<SensitiveInfo> catchCsjExpressDrawAds(List<? extends TTNativeExpressAd> adList, Integer adLevel) {
        List<? extends TTNativeExpressAd> list = adList;
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<? extends TTNativeExpressAd> it = adList.iterator();
        while (it.hasNext()) {
            SensitiveInfo sensitiveInfoCatchCsjExpressDrawAd = catchCsjExpressDrawAd(it.next(), adLevel);
            if (sensitiveInfoCatchCsjExpressDrawAd != null) {
                arrayList.add(sensitiveInfoCatchCsjExpressDrawAd);
            }
        }
        return arrayList;
    }

    public final SensitiveInfo catchCsjExpressNativeAd(TTFeedAd drawNativeAd, Integer adLevel) {
        SensitiveInfo sensitiveInfo = new SensitiveInfo();
        try {
            sensitiveInfo.setContentSourceId(String.valueOf(sensitiveInfo.getCONTENT_RESOURCE_TT_AD()));
            sensitiveInfo.setAdLevel(adLevel);
            if (drawNativeAd.getInteractionType() == 4) {
                sensitiveInfo.setInteractionType(1);
            } else {
                sensitiveInfo.setInteractionType(2);
            }
            if (Intrinsics.areEqual("4.8.1.7", NestCsjManager.INSTANCE.getVersion())) {
                getExpressFeedSensitiveFrom4607(drawNativeAd, sensitiveInfo);
            } else {
                getExpressFeedSensitiveFrom5305(drawNativeAd, sensitiveInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sensitiveInfo;
    }

    public final List<SensitiveInfo> catchCsjExpressNativeAds(List<? extends TTFeedAd> adList, Integer adLevel) {
        List<? extends TTFeedAd> list = adList;
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<? extends TTFeedAd> it = adList.iterator();
        while (it.hasNext()) {
            SensitiveInfo sensitiveInfoCatchCsjExpressNativeAd = catchCsjExpressNativeAd(it.next(), adLevel);
            if (sensitiveInfoCatchCsjExpressNativeAd != null) {
                arrayList.add(sensitiveInfoCatchCsjExpressNativeAd);
            }
        }
        return arrayList;
    }

    public final SensitiveInfo catchCsjExpressTemplateAd(TTNativeExpressAd expressAd, Integer adLevel) {
        SensitiveInfo sensitiveInfo = new SensitiveInfo();
        try {
            sensitiveInfo.setContentSourceId(String.valueOf(sensitiveInfo.getCONTENT_RESOURCE_TT_AD()));
            sensitiveInfo.setAdLevel(adLevel);
            if (expressAd.getInteractionType() == 4) {
                sensitiveInfo.setInteractionType(1);
            } else {
                sensitiveInfo.setInteractionType(2);
            }
            if (Intrinsics.areEqual("4.8.1.7", NestCsjManager.INSTANCE.getVersion())) {
                getTemplateFrom4607Version(expressAd, sensitiveInfo);
            } else {
                getTemplateFromVersion(expressAd, sensitiveInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sensitiveInfo;
    }

    public final List<SensitiveInfo> catchCsjExpressTemplateAds(List<? extends TTNativeExpressAd> adList, Integer adLevel) {
        List<? extends TTNativeExpressAd> list = adList;
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<? extends TTNativeExpressAd> it = adList.iterator();
        while (it.hasNext()) {
            SensitiveInfo sensitiveInfoCatchCsjExpressTemplateAd = catchCsjExpressTemplateAd(it.next(), adLevel);
            if (sensitiveInfoCatchCsjExpressTemplateAd != null) {
                arrayList.add(sensitiveInfoCatchCsjExpressTemplateAd);
            }
        }
        return arrayList;
    }

    public final SensitiveInfo catchCsjInterstitialAd(TTFullScreenVideoAd fullScreenVideoAd, Integer adLevel) {
        SensitiveInfo sensitiveInfo = new SensitiveInfo();
        try {
            sensitiveInfo.setContentSourceId(String.valueOf(sensitiveInfo.getCONTENT_RESOURCE_TT_AD()));
            sensitiveInfo.setAdLevel(adLevel);
            if (fullScreenVideoAd.getInteractionType() == 4) {
                sensitiveInfo.setInteractionType(1);
            } else {
                sensitiveInfo.setInteractionType(2);
            }
            return Intrinsics.areEqual("4.8.1.7", NestCsjManager.INSTANCE.getVersion()) ? getInterstitialSensitiveFrom4607(fullScreenVideoAd, sensitiveInfo) : getInterstitialSensitiveFrom(fullScreenVideoAd, sensitiveInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return sensitiveInfo;
        }
    }

    public final SensitiveInfo catchCsjNativeDrawAd(TTDrawFeedAd drawNativeAd, Integer adLevel) {
        SensitiveInfo sensitiveInfo = new SensitiveInfo();
        sensitiveInfo.setContentSourceId(String.valueOf(sensitiveInfo.getCONTENT_RESOURCE_TT_AD()));
        sensitiveInfo.setAdLevel(adLevel);
        if (drawNativeAd.getInteractionType() == 4) {
            sensitiveInfo.setInteractionType(1);
        } else {
            sensitiveInfo.setInteractionType(2);
        }
        SensitiveInfo nativeDrawSensitiveFrom4607 = getNativeDrawSensitiveFrom4607(drawNativeAd, sensitiveInfo);
        try {
            Field declaredFieldC = Class.forName("com.bytedance.sdk.openadsdk.core.f.a").getDeclaredField("h");
            Intrinsics.checkExpressionValueIsNotNull(declaredFieldC, "declaredFieldC");
            declaredFieldC.setAccessible(true);
            declaredFieldC.get(drawNativeAd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nativeDrawSensitiveFrom4607;
    }

    public final List<SensitiveInfo> catchCsjNativeDrawAds(List<TTDrawFeedAd> adList, Integer adLevel) {
        List<TTDrawFeedAd> list = adList;
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<TTDrawFeedAd> it = adList.iterator();
        while (it.hasNext()) {
            SensitiveInfo sensitiveInfoCatchCsjNativeDrawAd = catchCsjNativeDrawAd(it.next(), adLevel);
            if (sensitiveInfoCatchCsjNativeDrawAd != null) {
                arrayList.add(sensitiveInfoCatchCsjNativeDrawAd);
            }
        }
        return arrayList;
    }

    public final SensitiveInfo catchCsjRewardAd(TTRewardVideoAd rewardAd) {
        Object value;
        if (!WifiNestAd.INSTANCE.isCatchThirdInfo()) {
            return null;
        }
        SensitiveInfo sensitiveInfo = new SensitiveInfo();
        sensitiveInfo.setContentSourceId(String.valueOf(sensitiveInfo.getCONTENT_RESOURCE_TT_AD()));
        setInteractionType(rewardAd, sensitiveInfo);
        try {
            ReflectUtils reflectUtils = ReflectUtils.INSTANCE;
            Object value2 = reflectUtils.getValue(rewardAd, rewardAd.getClass(), "e");
            if (value2 != null && (value = reflectUtils.getValue(value2, value2.getClass(), "g")) != null) {
                Object value3 = reflectUtils.getValue(value, value.getClass(), "v");
                if (value3 instanceof AdDownloadModel) {
                    createInfoByAdDown((AdDownloadModel) value3, sensitiveInfo);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sensitiveInfo;
    }

    public final SensitiveInfo catchCsjSplashAd(CSJSplashAd splashAd, Integer adLevel) {
        ClassLoader classLoader;
        SensitiveInfo sensitiveInfo = new SensitiveInfo();
        try {
            sensitiveInfo.setContentSourceId(String.valueOf(sensitiveInfo.getCONTENT_RESOURCE_TT_AD()));
            sensitiveInfo.setAdLevel(adLevel);
            if (splashAd.getInteractionType() == 4) {
                sensitiveInfo.setInteractionType(1);
            } else {
                sensitiveInfo.setInteractionType(2);
            }
            if (Intrinsics.areEqual("4.8.1.7", NestCsjManager.INSTANCE.getVersion())) {
                Object value = ReflectUtils.INSTANCE.getValue(splashAd, splashAd.getClass().getSuperclass(), t.l);
                WifiLog.d("catchSensitiveInfo instanceD " + value);
                getCommonSensitiveFrom4607(value, sensitiveInfo);
            } else {
                ReflectUtils reflectUtils = ReflectUtils.INSTANCE;
                Object value2 = reflectUtils.getValue(splashAd, splashAd.getClass(), "u");
                if (value2 != null && (classLoader = value2.getClass().getClassLoader()) != null) {
                    WifiLog.d("third CsjSplashAd eClassLoader " + classLoader);
                }
                Object value3 = reflectUtils.getValue(value2, value2 != null ? value2.getClass().getSuperclass() : null, "nr");
                if (value3 != null) {
                    createInfoByAllDataNormal(value3, sensitiveInfo);
                } else {
                    Object value4 = reflectUtils.getValue(value2, value2 != null ? value2.getClass().getSuperclass() : null, "y");
                    if (value4 == null || (value4 instanceof Boolean)) {
                        Object value5 = reflectUtils.getValue(value2, value2 != null ? value2.getClass().getSuperclass() : null, "q");
                        if (value5 != null) {
                            createInfoByOppoAllData(value5, sensitiveInfo);
                        }
                    } else {
                        createInfoByAllData(value4, sensitiveInfo);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sensitiveInfo;
    }
}
