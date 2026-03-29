package com.umeng.analytics.pro;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.cdo.oaps.ad.OapsKey;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.lantern.auth.server.WkParams;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.umcrash.custommapping.UAPMCustomMapping;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ao {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static JSONObject f10854a;

    public static JSONObject a(Context context, JSONArray jSONArray, String str) {
        JSONObject jSONObject = f10854a;
        if (jSONObject != null && jSONObject.length() > 0) {
            return f10854a;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("os", AnalyticsConstants.SDK_TYPE);
            jSONObject2.put(com.kuaishou.weapon.p0.t.v, Build.MODEL);
            jSONObject2.put(CmcdData.OBJECT_TYPE_MUXED_AUDIO_AND_VIDEO, DeviceConfig.getAppVersionName(context));
            jSONObject2.put(bt.g, UMUtils.getUMId(context));
            jSONObject2.put("ov", Build.VERSION.RELEASE);
            jSONObject2.put("chn", UMUtils.getChannel(context));
            jSONObject2.put(bt.af, UMUtils.getZid(context));
            jSONObject2.put("sv", "9.8.8");
            jSONObject2.put("ak", UMUtils.getAppkey(context));
            String idfa = DeviceConfig.getIdfa(context);
            if (!TextUtils.isEmpty(idfa)) {
                jSONObject2.put("tk_idfa", idfa);
            }
            jSONObject2.put("db", Build.BRAND);
            jSONObject2.put("tk_aid", DeviceConfig.getAndroidId(context));
            String oaid = DeviceConfig.getOaid(context);
            if (!TextUtils.isEmpty(oaid)) {
                jSONObject2.put("tk_oaid", oaid);
            }
            String imeiNew = DeviceConfig.getImeiNew(context);
            if (!TextUtils.isEmpty(imeiNew)) {
                jSONObject2.put("tk_imei", imeiNew);
            }
            jSONObject2.put("boa", Build.BOARD);
            jSONObject2.put("mant", Build.TIME);
            String[] localeInfo = DeviceConfig.getLocaleInfo(context);
            jSONObject2.put("ct", localeInfo[0]);
            jSONObject2.put(WkParams.LANG, localeInfo[1]);
            jSONObject2.put("tz", DeviceConfig.getTimeZone(context));
            jSONObject2.put("pkg", DeviceConfig.getPackageName(context));
            jSONObject2.put("disn", DeviceConfig.getAppName(context));
            String[] networkAccessMode = DeviceConfig.getNetworkAccessMode(context);
            if ("Wi-Fi".equals(networkAccessMode[0])) {
                jSONObject2.put(OapsKey.KEY_ACTIVE_CODE, "wifi");
            } else if ("2G/3G".equals(networkAccessMode[0])) {
                jSONObject2.put(OapsKey.KEY_ACTIVE_CODE, "2G/3G");
            } else {
                jSONObject2.put(OapsKey.KEY_ACTIVE_CODE, "unknown");
            }
            if (!"".equals(networkAccessMode[1])) {
                jSONObject2.put("ast", networkAccessMode[1]);
            }
            jSONObject2.put("nt", DeviceConfig.getNetworkType(context));
            String deviceToken = UMUtils.getDeviceToken(context);
            if (!TextUtils.isEmpty(deviceToken)) {
                jSONObject2.put(bt.f10889a, deviceToken);
            }
            int[] resolutionArray = DeviceConfig.getResolutionArray(context);
            if (resolutionArray != null) {
                jSONObject2.put("rl", resolutionArray[1] + "*" + resolutionArray[0]);
            }
            jSONObject2.put("car", DeviceConfig.getNetworkOperatorName(context));
            jSONObject2.put(bt.b, "9.8.8");
            if (DeviceConfig.isHarmony(context)) {
                jSONObject2.put("oos", "harmony");
            } else {
                jSONObject2.put("oos", AnalyticsConstants.SDK_TYPE);
            }
            jSONObject2.put(com.umeng.ccg.a.u, str);
            jSONObject2.put(com.umeng.ccg.a.x, jSONArray);
            f10854a = jSONObject2;
        } catch (Throwable unused) {
        }
        return f10854a;
    }

    public static JSONObject a(Context context, JSONObject jSONObject) {
        JSONObject jSONObject2 = null;
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("ekv", jSONArray);
                return jSONObject3;
            } catch (Throwable unused) {
                jSONObject2 = jSONObject3;
                return jSONObject2;
            }
        } catch (Throwable unused2) {
        }
    }

    public static JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("header", jSONObject);
            jSONObject3.put("analytics", jSONObject2);
        } catch (Throwable unused) {
        }
        return jSONObject3;
    }

    public static JSONObject a(Context context, String str) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = null;
        try {
            an anVar = new an();
            String uMId = UMUtils.getUMId(context);
            if (TextUtils.isEmpty(uMId)) {
                return null;
            }
            anVar.a(uMId);
            String appkey = UMUtils.getAppkey(context);
            if (TextUtils.isEmpty(appkey)) {
                return null;
            }
            anVar.b(appkey);
            anVar.c(UMUtils.getAppVersionName(context));
            anVar.d("9.8.8");
            anVar.e(UMUtils.getChannel(context));
            anVar.f(Build.VERSION.SDK_INT + "");
            anVar.g(Build.BRAND);
            anVar.h(Build.MODEL);
            String[] localeInfo = DeviceConfig.getLocaleInfo(context);
            anVar.i(localeInfo[1]);
            anVar.j(localeInfo[0]);
            int[] resolutionArray = DeviceConfig.getResolutionArray(context);
            anVar.b(Integer.valueOf(resolutionArray[1]));
            anVar.a(Integer.valueOf(resolutionArray[0]));
            anVar.k(as.a(context, "install_datetime", ""));
            try {
                jSONObject = new JSONObject();
            } catch (JSONException e) {
                e = e;
            }
            try {
                jSONObject.put(an.f10853a, anVar.a());
                jSONObject.put(an.c, anVar.c());
                jSONObject.put(an.b, anVar.b());
                jSONObject.put(an.d, anVar.d());
                jSONObject.put(an.e, anVar.e());
                jSONObject.put(an.f, anVar.f());
                jSONObject.put(an.g, anVar.g());
                jSONObject.put(an.h, anVar.h());
                jSONObject.put(an.k, anVar.k());
                jSONObject.put(an.j, anVar.j());
                jSONObject.put(an.l, anVar.l());
                jSONObject.put(an.i, anVar.i());
                jSONObject.put(an.m, anVar.m());
                jSONObject.put(bt.af, UMUtils.getZid(context));
                jSONObject.put("platform", "android");
                jSONObject.put("optional", new JSONObject(as.a()));
                String[] strArrSplit = str.split("@");
                if (strArrSplit.length == 4) {
                    try {
                        long j = Long.parseLong(strArrSplit[0]);
                        String str2 = strArrSplit[1];
                        jSONObject.put(UAPMCustomMapping.STRING_PARAM_1, j);
                        jSONObject.put(UAPMCustomMapping.STRING_PARAM_2, str2);
                    } catch (Throwable unused) {
                    }
                }
                try {
                    String str3 = Build.BRAND;
                    String strA = at.a(str3);
                    String strB = at.b(str3);
                    if (!TextUtils.isEmpty(strA) && !TextUtils.isEmpty(strB)) {
                        jSONObject.put(an.n, strA);
                        jSONObject.put(an.o, strB);
                    } else {
                        jSONObject.put(an.n, AnalyticsConstants.SDK_TYPE);
                        jSONObject.put(an.o, Build.VERSION.RELEASE);
                    }
                } catch (Throwable unused2) {
                }
                return jSONObject;
            } catch (JSONException e2) {
                e = e2;
                jSONObject2 = jSONObject;
                UMRTLog.e(UMRTLog.RTLOG_TAG, "[getCloudConfigParam] error " + e.getMessage());
                return jSONObject2;
            } catch (Throwable th) {
                th = th;
                jSONObject2 = jSONObject;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        UMRTLog.e(UMRTLog.RTLOG_TAG, "[getCloudConfigParam] error " + th.getMessage());
        return jSONObject2;
    }

    public static JSONObject a(Context context, int i, JSONArray jSONArray, String str, boolean z) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = null;
        try {
            jSONObject = new JSONObject();
        } catch (Throwable unused) {
        }
        try {
            String zid = UMUtils.getZid(context);
            if (TextUtils.isEmpty(zid)) {
                return jSONObject;
            }
            jSONObject.put("atoken", zid);
            jSONObject.put("oaid", DeviceConfig.getOaid(context));
            jSONObject.put(bt.g, UMEnvelopeBuild.imprintProperty(context, bt.g, ""));
            jSONObject.put(bt.F, Build.BRAND);
            String deviceToken = UMUtils.getDeviceToken(context);
            if (!TextUtils.isEmpty(deviceToken)) {
                jSONObject.put(RemoteMessageConst.DEVICE_TOKEN, deviceToken);
            }
            jSONObject.put(WkParams.MODEL, Build.MODEL);
            jSONObject.put("os", "android");
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("appkey", UMConfigure.sAppkey);
            jSONObject.put("app_version", DeviceConfig.getAppVersionName(context));
            jSONObject.put("packagename", DeviceConfig.getPackageName(context));
            jSONObject.put("app_display_name", DeviceConfig.getAppName(context));
            String[] networkAccessMode = DeviceConfig.getNetworkAccessMode(context);
            if ("Wi-Fi".equals(networkAccessMode[0])) {
                jSONObject.put(bt.Q, "wifi");
            } else if ("2G/3G".equals(networkAccessMode[0])) {
                jSONObject.put(bt.Q, "2G/3G");
            } else {
                jSONObject.put(bt.Q, "unknow");
            }
            if (!"".equals(networkAccessMode[1])) {
                jSONObject.put("sub_access", networkAccessMode[1]);
            }
            jSONObject.put("sdkType", AnalyticsConstants.SDK_TYPE);
            jSONObject.put("sdk_version", "9.8.8");
            jSONObject.put("session_id", aa.a().d(context));
            jSONObject.put(bt.an, DeviceConfig.getRingerMode(context));
            jSONObject.put(com.umeng.ccg.a.u, str);
            jSONObject.put(com.umeng.ccg.a.x, jSONArray);
            if (z) {
                jSONObject.put("am", DeviceConfig.isAirplaneModeOn(context));
            }
            jSONObject.put("e", i);
            return jSONObject;
        } catch (Throwable unused2) {
            jSONObject2 = jSONObject;
            return jSONObject2;
        }
    }
}
