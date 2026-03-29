package org.apache.cordova.jssdk;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.amap.api.services.district.DistrictSearchQuery;
import com.huawei.openalliance.ad.constant.az;
import com.huawei.openalliance.ad.constant.be;
import com.lantern.auth.server.WkParams;
import com.umeng.ccg.a;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.activity.webview.CordovaWebActivity;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.location.d;
import com.zenmen.palmchat.utils.EncryptUtils;
import com.zenmen.palmchat.utils.SmidHelper;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.ac1;
import defpackage.ap3;
import defpackage.az2;
import defpackage.dn0;
import defpackage.eb4;
import defpackage.hx3;
import defpackage.jo6;
import defpackage.n86;
import defpackage.sy5;
import defpackage.v4;
import java.util.Locale;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.jssdk.general.Action;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class UserInfoPlugin extends CordovaPlugin {
    private static final String ACTION_CANCEL_ACCOUNT = "cancelAccount";
    private static final String ACTION_TOAST = "toast";
    private static String ERROR_PATH = "file:///android_asset/zzb/error/error.html";
    private static String OA_URL = "https://m.zenmen.com";

    private void closeWebView(CallbackContext callbackContext) {
        CordovaInterface cordovaInterface = this.cordova;
        if (cordovaInterface instanceof CordovaWebActivity) {
            ((CordovaWebActivity) cordovaInterface).E2(OA_URL);
        }
    }

    private void getDeviceInfo(CallbackContext callbackContext) {
        JSONObject jSONObject = new JSONObject();
        Object objP = AccountUtils.p(AppContext.getContext());
        Object objO = AccountUtils.o(AppContext.getContext());
        String ssid = ((WifiManager) AppContext.getContext().getApplicationContext().getSystemService("wifi")).getConnectionInfo().getSSID();
        if (ssid.startsWith("\"") && ssid.endsWith("\"")) {
            ssid = ssid.substring(1, ssid.length() - 1);
        }
        Object obj = ac1.k;
        Object obj2 = ac1.i;
        Object obj3 = ac1.h;
        try {
            jSONObject.put(DeviceInfoUtil.UID_TAG, objP);
            jSONObject.put(WkParams.SESSIONID, objO);
            jSONObject.put("ssid", ssid);
            jSONObject.put("bssid", "unknown");
            jSONObject.put("dhid", obj3);
            jSONObject.put(WkParams.IMEI, obj2);
            jSONObject.put("mac", obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        LogUtil.i("UserInfoPlugin", "getDeviceInfo = " + jSONObject.toString());
        callbackContext.success(jSONObject);
    }

    private void getShuzilmId(CallbackContext callbackContext) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("szlmId", SmidHelper.o());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        LogUtil.i("UserInfoPlugin", "getSzlmId = " + jSONObject.toString());
        callbackContext.success(jSONObject);
    }

    private void getToken(CallbackContext callbackContext) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("token", EncryptUtils.generateMessageToken());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        LogUtil.i("UserInfoPlugin", "getToken = " + jSONObject.toString());
        callbackContext.success(jSONObject);
    }

    private void getUid(CallbackContext callbackContext) {
        String strP = AccountUtils.p(AppContext.getContext());
        if (TextUtils.isEmpty(strP)) {
            callbackContext.error("no account yet");
        } else {
            callbackContext.success(strP);
        }
    }

    private void getUserAgent(CallbackContext callbackContext) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("manufacturer", Build.MANUFACTURER);
            jSONObject.put("deviceName", Build.MODEL);
            jSONObject.put("os", AnalyticsConstants.SDK_TYPE);
            jSONObject.put("osVersion", Build.VERSION.RELEASE);
            jSONObject.put("background", n86.a());
            PackageInfo packageInfo = AppContext.getContext().getPackageManager().getPackageInfo(AppContext.getContext().getPackageName(), 0);
            jSONObject.put(az.aW, packageInfo.versionCode);
            jSONObject.put("versionName", packageInfo.versionName);
            jSONObject.put("locale", Locale.getDefault().toString());
            float f = AppContext.getContext().getResources().getDisplayMetrics().density;
            int i = (int) f;
            if (f - i > 0.0f) {
                jSONObject.put(be.ar, String.format("%fx", Float.valueOf(f)));
            } else {
                jSONObject.put(be.ar, String.format("%dx", Integer.valueOf(i)));
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        callbackContext.success(jSONObject);
    }

    private void getUserInfo(CallbackContext callbackContext) {
        JSONObject jSONObject = new JSONObject();
        Object objP = AccountUtils.p(AppContext.getContext());
        Object objGenerateMessageToken = EncryptUtils.generateMessageToken();
        Object objO = AccountUtils.o(AppContext.getContext());
        String ssid = ((WifiManager) AppContext.getContext().getApplicationContext().getSystemService("wifi")).getConnectionInfo().getSSID();
        if (ssid.startsWith("\"") && ssid.endsWith("\"")) {
            ssid = ssid.substring(1, ssid.length() - 1);
        }
        try {
            jSONObject.put(DeviceInfoUtil.UID_TAG, objP);
            jSONObject.put("token", objGenerateMessageToken);
            jSONObject.put(WkParams.SESSIONID, objO);
            jSONObject.put("ssid", ssid);
            jSONObject.put("bssid", "unknown");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        callbackContext.success(jSONObject);
    }

    private void getUserInfoForAds(CallbackContext callbackContext) {
        JSONObject jSONObject = new JSONObject();
        String strP = AccountUtils.p(AppContext.getContext());
        try {
            jSONObject.put("cm", ac1.k);
            jSONObject.put("ci", ac1.i);
            jSONObject.put("nt", hx3.f());
            jSONObject.put("isp", hx3.j(AppContext.getContext()));
            LocationEx locationExI = d.g().i(Long.MAX_VALUE);
            if (locationExI != null) {
                jSONObject.put("lo", locationExI.getLongitude());
                jSONObject.put("la", locationExI.getLatitude());
            }
            jSONObject.put("ss", hx3.l());
            jSONObject.put(CmcdConfiguration.KEY_BUFFER_STARVATION, hx3.k());
            jSONObject.put("al", Build.VERSION.SDK_INT);
            jSONObject.put("dt", ac1.F(AppContext.getContext()) ? 2 : 1);
            jSONObject.put("dvd", Build.MANUFACTURER);
            jSONObject.put("dv", Build.MODEL);
            jSONObject.put("aid", eb4.b());
            jSONObject.put("an", "连信");
            PackageInfo packageInfo = AppContext.getContext().getPackageManager().getPackageInfo(AppContext.getContext().getPackageName(), 0);
            if (packageInfo != null) {
                jSONObject.put(CmcdData.OBJECT_TYPE_MUXED_AUDIO_AND_VIDEO, packageInfo.versionCode);
                jSONObject.put("avn", packageInfo.versionName);
            }
            jSONObject.put("apn", AppContext.getContext().getPackageId());
            jSONObject.put("nid", ac1.o(AppContext.getContext()));
            jSONObject.put("lalo_t", "a");
            jSONObject.put("cu", ac1.h);
            jSONObject.put(DeviceInfoUtil.UID_TAG, strP);
            jSONObject.put("channelId", ac1.m);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        callbackContext.success(jSONObject);
    }

    private void getUserInfoForPay(CallbackContext callbackContext) {
        JSONObject jSONObject = new JSONObject();
        String strP = AccountUtils.p(AppContext.getContext());
        String strGenerateMessageToken = EncryptUtils.generateMessageToken();
        String strO = AccountUtils.o(AppContext.getContext());
        try {
            jSONObject.put(DeviceInfoUtil.UID_TAG, strP);
            jSONObject.put("token", strGenerateMessageToken);
            jSONObject.put(WkParams.SESSIONID, strO);
            jSONObject.put("deviceId", ac1.h);
            jSONObject.put("appId", eb4.b());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        callbackContext.success(jSONObject);
    }

    private void getUserProfile(CallbackContext callbackContext) {
        JSONObject jSONObject = new JSONObject();
        String strE = v4.e(c.b());
        ContactInfoItem contactInfoItemA = dn0.a(strE);
        try {
            jSONObject.put("id", strE);
            jSONObject.put("name", contactInfoItemA != null ? contactInfoItemA.getNickName() : "");
            jSONObject.put("headimgurl", contactInfoItemA != null ? contactInfoItemA.getIconURL() : "");
            jSONObject.put("gender", contactInfoItemA != null ? contactInfoItemA.getGender() : 0);
            jSONObject.put(DistrictSearchQuery.KEYWORDS_DISTRICT, ap3.a().s(contactInfoItemA));
            jSONObject.put(a.A, contactInfoItemA != null ? contactInfoItemA.getSignature() : "");
            jSONObject.put("hobby", contactInfoItemA != null ? contactInfoItemA.getHobby() : "");
            jSONObject.put("birthday", contactInfoItemA != null ? contactInfoItemA.getBirthday() : "");
            if (contactInfoItemA != null && contactInfoItemA.getExt() != null) {
                jSONObject.put("ext", new JSONObject(az2.c(contactInfoItemA.getExt())));
                if (contactInfoItemA.getExt().getIncome() > 0) {
                    jSONObject.put("income", contactInfoItemA.getExt().getIncome());
                }
                if (contactInfoItemA.getExt().getOccupation() > 0) {
                    jSONObject.put("occupation", contactInfoItemA.getExt().getOccupation());
                }
                if (contactInfoItemA.getExt().getIntention() != null) {
                    jSONObject.put("intention", new JSONArray(contactInfoItemA.getExt().getIntention()));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        callbackContext.success(jSONObject);
    }

    private void loadErrorView(String str) {
        CordovaInterface cordovaInterface = this.cordova;
        if (cordovaInterface instanceof CordovaWebActivity) {
            ((CordovaWebActivity) cordovaInterface).E2(ERROR_PATH + str);
        }
    }

    private void reloadWebView(CallbackContext callbackContext, String str) {
        CordovaInterface cordovaInterface = this.cordova;
        if (cordovaInterface instanceof CordovaWebActivity) {
            ((CordovaWebActivity) cordovaInterface).E2(str);
        }
    }

    @Override // org.apache.cordova.CordovaPlugin
    public boolean execute(String str, JSONArray jSONArray, CallbackContext callbackContext) throws JSONException {
        if (str.equals("getUid")) {
            getUid(callbackContext);
            return true;
        }
        if (str.equals("getUserAgent")) {
            getUserAgent(callbackContext);
            return true;
        }
        if (str.equals(Action.ACTION_GET_USERINFO)) {
            getUserInfo(callbackContext);
        } else if (str.equals("getUserInfoForPay")) {
            getUserInfoForPay(callbackContext);
        } else if (str.equals("getUserInfoForAds")) {
            getUserInfoForAds(callbackContext);
        } else {
            if (str.equals("getUserProfile")) {
                getUserProfile(callbackContext);
                return true;
            }
            if (str.equals("getDeviceInfo")) {
                getDeviceInfo(callbackContext);
                return true;
            }
            if (str.equals("getToken")) {
                getToken(callbackContext);
                return true;
            }
            if (str.equals("closeWebView")) {
                closeWebView(callbackContext);
                return true;
            }
            if (str.equals("reloadWebView")) {
                reloadWebView(callbackContext, jSONArray.optString(0));
                return true;
            }
            if (str.equals("loadErrorView")) {
                loadErrorView(jSONArray.optString(0));
                return true;
            }
            if (str.equals("getSzlmId")) {
                getShuzilmId(callbackContext);
                return true;
            }
            if (str.equals("cancelAccount")) {
                AppContext.getContext().logout();
            } else if (str.equals(ACTION_TOAST)) {
                Activity ownerActivity2 = this.cordova.getOwnerActivity2();
                if (ownerActivity2 != null) {
                    sy5.f(ownerActivity2, jSONArray.optString(0), (jSONArray.optInt(1, 0) == 0 ? 1 : 0) ^ 1).g();
                }
            } else if (str.equals("getTaiChiInfo")) {
                callbackContext.success(jo6.c(jSONArray.optString(0), ""));
                return true;
            }
        }
        return false;
    }
}
