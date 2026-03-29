package org.apache.cordova.jssdk;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.lantern.auth.server.WkParams;
import com.squareup.okhttp.internal.Base64;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.location.d;
import com.zenmen.palmchat.utils.MdidSdkConfigHelper;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.ac1;
import defpackage.eb4;
import defpackage.hx3;
import defpackage.k86;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class PublicUtilsPlugin extends CordovaPlugin {
    private void getDeviceInfo(CallbackContext callbackContext) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(WkParams.IMEI, ac1.i);
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
            jSONObject.put("oaid", MdidSdkConfigHelper.getInstance().getOAID());
            jSONObject.put("nt", hx3.f());
            jSONObject.put("isp", hx3.j(AppContext.getContext()));
            LocationEx locationExI = d.g().i(Long.MAX_VALUE);
            if (locationExI != null) {
                jSONObject.put("lo", locationExI.getLongitude());
                jSONObject.put("la", locationExI.getLatitude());
            }
            jSONObject.put("al", Build.VERSION.SDK_INT);
            jSONObject.put("dt", ac1.F(AppContext.getContext()) ? 2 : 1);
            jSONObject.put("dvd", Build.MANUFACTURER);
            jSONObject.put("dv", Build.MODEL);
            jSONObject.put("aid", eb4.b());
            jSONObject.put("an", "连信");
            jSONObject.put("am", ac1.m);
            PackageInfo packageInfo = AppContext.getContext().getPackageManager().getPackageInfo(AppContext.getContext().getPackageName(), 0);
            if (packageInfo != null) {
                jSONObject.put(CmcdData.OBJECT_TYPE_MUXED_AUDIO_AND_VIDEO, packageInfo.versionCode);
                jSONObject.put("avn", packageInfo.versionName);
            }
            jSONObject.put("apn", AppContext.getContext().getPackageId());
            jSONObject.put("nid", ac1.o(AppContext.getContext()));
            jSONObject.put("lalo_t", "a");
            jSONObject.put("cu", ac1.h);
            jSONObject.put(WkParams.UHID, strP);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        LogUtil.i("PublicUtilsPlugin", "result.toString()" + jSONObject.toString());
        try {
            String strEncrypt = AESUtil.encrypt(jSONObject.toString(), new String(Base64.decode("QSFKcWhaI0ZaZnJHS2RuOA==".getBytes())), new String(Base64.decode("RG9UOSpwTWdFU1EwdVJyQA==".getBytes())));
            LogUtil.i("PublicUtilsPlugin", "encrypt " + strEncrypt);
            callbackContext.success("AES:0:" + strEncrypt);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    private void openApp(String str, String str2, CallbackContext callbackContext) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(str2));
            intent.setPackage(str);
            this.cordova.getOwnerActivity2().startActivity(intent);
        }
        callbackContext.success();
    }

    @Override // org.apache.cordova.CordovaPlugin
    public boolean execute(String str, JSONArray jSONArray, CallbackContext callbackContext) throws JSONException {
        if (str.equals("getDeviceInfo")) {
            getDeviceInfo(callbackContext);
            return true;
        }
        if (str.equals(RedPacketPullNewPlugin.ACTION_OPENAPP)) {
            openApp(jSONArray.optString(0), jSONArray.optString(1), callbackContext);
            return true;
        }
        if (str.equals("isAppInstalled")) {
            callbackContext.success(k86.F(this.cordova.getOwnerActivity2(), jSONArray.optString(0)) ? 1 : 0);
            return true;
        }
        if (!str.equals("getUserInfoForAds")) {
            return super.execute(str, jSONArray, callbackContext);
        }
        getUserInfoForAds(callbackContext);
        return true;
    }
}
