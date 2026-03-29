package org.apache.webplatform.jssdk;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.amap.api.services.district.DistrictSearchQuery;
import com.huawei.openalliance.ad.constant.az;
import com.huawei.openalliance.ad.constant.be;
import com.lantern.auth.server.WkParams;
import com.umeng.ccg.a;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import defpackage.ac1;
import defpackage.ap3;
import defpackage.az2;
import defpackage.dn0;
import defpackage.r75;
import defpackage.v4;
import java.util.Locale;
import org.apache.cordova.jssdk.RedPacketPullNewPlugin;
import org.apache.cordovaNew.CallbackContext;
import org.apache.cordovaNew.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class UserInfoPlugin extends CordovaPlugin {
    private static final String UPLOAD_IN_MEND_PHOTO = "uploadInMendPhoto";

    private void getUid(CallbackContext callbackContext) {
        String strE = v4.e(c.b());
        if (TextUtils.isEmpty(strE)) {
            callbackContext.error("no account yet");
        } else {
            callbackContext.success(strE);
        }
    }

    private void getUserAgent(CallbackContext callbackContext) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("manufacturer", Build.MANUFACTURER);
            jSONObject.put("deviceName", Build.MODEL);
            jSONObject.put("brand", Build.BRAND);
            jSONObject.put("os", AnalyticsConstants.SDK_TYPE);
            jSONObject.put("osVersion", Build.VERSION.RELEASE);
            PackageInfo packageInfo = this.cordova.getContext().getPackageManager().getPackageInfo(this.cordova.getContext().getPackageName(), 0);
            jSONObject.put(az.aW, packageInfo.versionCode);
            jSONObject.put("versionName", packageInfo.versionName);
            jSONObject.put("channelId", ac1.m);
            jSONObject.put("locale", Locale.getDefault().toString());
            float f = this.cordova.getContext().getResources().getDisplayMetrics().density;
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        callbackContext.success(jSONObject);
    }

    private void getValidateInfo(CallbackContext callbackContext) {
        JSONObject jSONObject = new JSONObject();
        String strE = v4.e(this.cordova.getContext());
        String strC = v4.c(this.cordova.getContext());
        String strD = v4.d();
        try {
            jSONObject.put(DeviceInfoUtil.UID_TAG, strE);
            jSONObject.put(WkParams.SESSIONID, strC);
            jSONObject.put("token", strD);
            jSONObject.put("deviceId", ac1.h);
            jSONObject.put(az.aW, ac1.f);
            jSONObject.put("deviceName", ac1.b);
            jSONObject.put("platform", ac1.c);
            jSONObject.put("osVersion", ac1.e);
            jSONObject.put("channelId", ac1.m);
            jSONObject.put("versionName", ac1.g);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        callbackContext.success(jSONObject);
    }

    private void mendFinished(CallbackContext callbackContext) {
        r75.o(this.cordova.getContext(), v4.e(this.cordova.getContext()) + "profile_mended", true);
        r75.o(this.cordova.getContext(), UPLOAD_IN_MEND_PHOTO, true);
        callbackContext.success();
    }

    @Override // org.apache.cordovaNew.CordovaPlugin
    public boolean execute(String str, JSONArray jSONArray, CallbackContext callbackContext) throws JSONException {
        if (str.equals("getUid")) {
            getUid(callbackContext);
            return true;
        }
        if (str.equals("getUserAgent")) {
            getUserAgent(callbackContext);
            return true;
        }
        if (str.equals("getUserProfile")) {
            getUserProfile(callbackContext);
            return true;
        }
        if (str.equals(RedPacketPullNewPlugin.ACTION_GETVALIDATEINFO)) {
            getValidateInfo(callbackContext);
            return true;
        }
        if (!str.equals("mendFinished")) {
            return false;
        }
        mendFinished(callbackContext);
        return true;
    }
}
