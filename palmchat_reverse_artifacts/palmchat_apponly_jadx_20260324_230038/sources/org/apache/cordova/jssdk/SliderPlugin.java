package org.apache.cordova.jssdk;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.huawei.openalliance.ad.constant.az;
import com.lantern.auth.server.WkParams;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.MainTabsActivity;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.teenagersmode.TeenagersModeManager;
import com.zenmen.palmchat.utils.EncryptUtils;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.ac1;
import defpackage.r75;
import defpackage.st2;
import defpackage.te5;
import defpackage.u13;
import defpackage.zn6;
import defpackage.zt5;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class SliderPlugin extends CordovaPlugin {
    private static final int CORDOVA_SLIDER_PLUGIN_HOTCHAT = 16385;
    private static final int CORDOVA_SLIDER_PLUGIN_LOGIN = 16387;
    private static final int CORDOVA_SLIDER_PLUGIN_NEARBY = 16386;
    private static final String TAG = "SliderPlugin";
    private CallbackContext mCallbackContext;

    private void getSceneid(int i) {
        this.mCallbackContext.success(i == 1 ? te5.d : i == 2 ? te5.e : i == 3 ? te5.f : i == 4 ? te5.g : i == 5 ? te5.h : i == 6 ? te5.i : null);
    }

    private void getValidateInfo() {
        JSONObject jSONObject = new JSONObject();
        String strP = AccountUtils.p(AppContext.getContext());
        String strO = AccountUtils.o(AppContext.getContext());
        String strGenerateMessageToken = EncryptUtils.generateMessageToken();
        try {
            jSONObject.put(DeviceInfoUtil.UID_TAG, strP);
            jSONObject.put(WkParams.SESSIONID, strO);
            jSONObject.put("token", strGenerateMessageToken);
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
        Log.i(TAG, "getValidateInfo JSON : -" + jSONObject.toString());
        this.mCallbackContext.success(jSONObject);
    }

    private void sliderReponse(String str) {
        String str2;
        if (TextUtils.equals(str, te5.d)) {
            str2 = te5.d;
            this.cordova.startActivityForResult(this, new Intent(this.cordova.getOwnerActivity2(), (Class<?>) MainTabsActivity.class), CORDOVA_SLIDER_PLUGIN_LOGIN);
            this.cordova.getOwnerActivity2().finish();
            r75.o(this.cordova.getOwnerActivity2(), "sp_slider_show_default_login", false);
            r75.o(this.cordova.getOwnerActivity2(), "sp_slider_show_default_upgrade", false);
        } else {
            if (TextUtils.equals(str, te5.e)) {
                r75.o(this.cordova.getOwnerActivity2(), "sp_slider_show_default_register", false);
                this.cordova.getOwnerActivity2().setResult(-1);
                this.cordova.getOwnerActivity2().finish();
            } else if (TextUtils.equals(str, te5.f)) {
                if (TeenagersModeManager.a().d()) {
                    zt5.c();
                } else {
                    u13.b().a();
                    Intent intentC = st2.c();
                    LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), BaseWrapper.ENTER_ID_OAPS_DEMO, "1", null, null);
                    zn6.e(AccountUtils.p(AppContext.getContext()), "lx_client_near_31", null, null);
                    intentC.putExtra("fromType", 3);
                    this.cordova.startActivityForResult(this, intentC, 16386);
                }
                this.cordova.getOwnerActivity2().finish();
            } else if (TextUtils.equals(str, te5.g) || TextUtils.equals(str, te5.h)) {
                this.cordova.getOwnerActivity2().setResult(-1);
                this.cordova.getOwnerActivity2().finish();
            }
            str2 = null;
        }
        this.mCallbackContext.success(str2);
    }

    @Override // org.apache.cordova.CordovaPlugin
    public boolean execute(String str, JSONArray jSONArray, CallbackContext callbackContext) throws JSONException {
        Log.i(TAG, str + "-" + jSONArray.toString());
        this.mCallbackContext = callbackContext;
        if (RedPacketPullNewPlugin.ACTION_GETVALIDATEINFO.equals(str)) {
            getValidateInfo();
            return true;
        }
        if ("getSceneid".equals(str)) {
            getSceneid(jSONArray.optInt(0));
            return true;
        }
        if (!"sliderResponse".equals(str)) {
            return false;
        }
        String strOptString = jSONArray.optString(0);
        if (jSONArray.getInt(1) == 0) {
            sliderReponse(strOptString);
        }
        return true;
    }

    @Override // org.apache.cordova.CordovaPlugin
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == CORDOVA_SLIDER_PLUGIN_HOTCHAT && i2 == -1 && intent != null) {
            this.mCallbackContext.success(intent.getStringExtra("result"));
            return;
        }
        if (i == 16386 && i2 == -1 && intent != null) {
            this.mCallbackContext.success(intent.getStringExtra("result"));
        } else if (i == CORDOVA_SLIDER_PLUGIN_LOGIN && i2 == -1 && intent != null) {
            this.mCallbackContext.success(intent.getStringExtra("result"));
        }
    }
}
