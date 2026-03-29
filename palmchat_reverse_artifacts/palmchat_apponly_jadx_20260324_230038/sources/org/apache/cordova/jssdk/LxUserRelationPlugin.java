package org.apache.cordova.jssdk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.R;
import defpackage.db3;
import defpackage.f84;
import defpackage.fk2;
import defpackage.jm;
import defpackage.ka3;
import defpackage.m46;
import defpackage.ma3;
import defpackage.n5;
import defpackage.pt5;
import defpackage.qt5;
import defpackage.tn1;
import defpackage.xn4;
import java.util.HashMap;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class LxUserRelationPlugin extends CordovaPlugin {
    private static final int FROM_GROUP_CHAT = 6;
    private xn4 mLoadingDialog;

    /* JADX INFO: Access modifiers changed from: private */
    public void goUserDetailAct(JSONObject jSONObject, CallbackContext callbackContext) {
        if (jSONObject != null) {
            fk2.a aVar = new fk2.a();
            Bundle bundle = new Bundle();
            bundle.putString("json_data", jSONObject.toString());
            bundle.putInt("from", 6);
            aVar.b(bundle);
            Intent intentA = n5.a(this.cordova.getActivity(), aVar);
            intentA.putExtra("from", 32);
            this.cordova.getActivity().startActivity(intentA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoading() {
        Activity activity = this.cordova.getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: org.apache.cordova.jssdk.LxUserRelationPlugin.3
            @Override // java.lang.Runnable
            public void run() {
                if (LxUserRelationPlugin.this.mLoadingDialog != null) {
                    LxUserRelationPlugin.this.mLoadingDialog.dismiss();
                }
            }
        });
    }

    private void showContactDetails(final JSONObject jSONObject, final CallbackContext callbackContext) {
        HashMap map = new HashMap();
        map.put("unionId", jSONObject.optString("unionId"));
        CordovaWebView cordovaWebView = this.webView;
        ka3.b appInfo = cordovaWebView.pluginManager.getAppInfo(cordovaWebView.loadedUrl);
        map.put("thirdAppId", appInfo.f21948a);
        final tn1 tn1Var = new tn1();
        tn1Var.f18275a = appInfo.f21948a;
        tn1Var.f = jSONObject.toString();
        f84.b(tn1Var, "js_sp_sta");
        new m46(new pt5<qt5>() { // from class: org.apache.cordova.jssdk.LxUserRelationPlugin.1
            @Override // defpackage.pt5
            public void onPreExecute(String str) {
                LxUserRelationPlugin.this.showLoading();
            }

            @Override // defpackage.pt5
            public void onPostExecute(qt5 qt5Var) {
                LxUserRelationPlugin.this.hideLoading();
                JSONObject jSONObject2 = new JSONObject();
                int i = qt5Var.f20322a;
                if (i == 1) {
                    try {
                        jSONObject.put(DeviceInfoUtil.UID_TAG, qt5Var.c.optString(DeviceInfoUtil.UID_TAG));
                        LxUserRelationPlugin.this.goUserDetailAct(jSONObject, callbackContext);
                        tn1Var.f = jSONObject.toString();
                        f84.b(tn1Var, "js_sp_suc");
                        callbackContext.success();
                        return;
                    } catch (JSONException e) {
                        ma3.c(e);
                        try {
                            jSONObject2.put("code", 0);
                        } catch (JSONException unused) {
                            ma3.c(e);
                        }
                    }
                } else {
                    try {
                        jSONObject2.put("code", i);
                        jSONObject2.put("msg", qt5Var.b);
                    } catch (JSONException e2) {
                        ma3.c(e2);
                    }
                }
                tn1Var.f = jSONObject2.toString();
                f84.b(tn1Var, "js_sp_err");
                callbackContext.error(jSONObject2);
            }
        }, map).executeOnExecutor(jm.a(), new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoading() {
        final Activity activity = this.cordova.getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: org.apache.cordova.jssdk.LxUserRelationPlugin.2
            @Override // java.lang.Runnable
            public void run() {
                if (LxUserRelationPlugin.this.mLoadingDialog == null) {
                    LxUserRelationPlugin lxUserRelationPlugin = LxUserRelationPlugin.this;
                    Activity activity2 = activity;
                    lxUserRelationPlugin.mLoadingDialog = db3.a(activity2, activity2.getString(R.string.lx_open_api_auth_loading));
                }
                LxUserRelationPlugin.this.mLoadingDialog.show();
            }
        });
    }

    @Override // org.apache.cordova.CordovaPlugin
    public boolean execute(String str, String str2, CallbackContext callbackContext) throws JSONException {
        if (!"lx_showContactDetails".equals(str)) {
            return super.execute(str, str2, callbackContext);
        }
        showContactDetails(new JSONObject(str2), callbackContext);
        return true;
    }
}
