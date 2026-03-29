package org.apache.cordova.jssdk;

import android.app.Activity;
import defpackage.e84;
import defpackage.ka3;
import defpackage.ma3;
import defpackage.om;
import defpackage.ua3;
import defpackage.wa3;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class LxLoginPlugin extends CordovaPlugin {
    private void doAuth(final CallbackContext callbackContext) throws JSONException {
        CordovaWebView cordovaWebView = this.webView;
        ka3.b appInfo = cordovaWebView.pluginManager.getAppInfo(cordovaWebView.loadedUrl);
        if (appInfo != null) {
            Activity activity = this.cordova.getActivity();
            if (activity == null) {
                return;
            }
            new ua3(activity, new e84() { // from class: org.apache.cordova.jssdk.LxLoginPlugin.3
                @Override // defpackage.e84
                public void onCallback(int i, String str, Object obj) {
                    JSONObject jSONObjectB;
                    if (i == 1) {
                        jSONObjectB = CordovaUtils.makeNormalJsResult(PluginResult.Status.OK);
                        try {
                            jSONObjectB.put("authCode", str);
                        } catch (JSONException e) {
                            ma3.c(e);
                        }
                    } else {
                        jSONObjectB = wa3.b(PluginResult.Status.ERROR.ordinal() + "", str);
                    }
                    callbackContext.success(jSONObjectB);
                }
            }).h(appInfo);
            return;
        }
        StringBuilder sb = new StringBuilder();
        PluginResult.Status status = PluginResult.Status.PERMISSION_DENIED;
        sb.append(status.ordinal());
        sb.append("");
        callbackContext.error(wa3.b(sb.toString(), PluginResult.StatusMessages[status.ordinal()]));
    }

    private void doLogin(String str, final CallbackContext callbackContext) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        final om omVar = new om();
        omVar.f19789a = jSONObject.getString("appId");
        omVar.d = jSONObject.getString("key");
        omVar.b = jSONObject.getString("scope");
        omVar.c = jSONObject.optString("scene", "from_h5");
        final ua3 ua3Var = new ua3(this.cordova.getActivity(), new e84() { // from class: org.apache.cordova.jssdk.LxLoginPlugin.1
            @Override // defpackage.e84
            public void onCallback(int i, String str2, Object obj) {
                ma3.a("auth object " + obj, new Object[0]);
                JSONObject jSONObject2 = new JSONObject();
                try {
                    if (i == 1) {
                        jSONObject2.put("code", str2);
                        jSONObject2.put("msg", "");
                    } else {
                        jSONObject2.put("code", "");
                        jSONObject2.put("msg", str2);
                    }
                } catch (JSONException e) {
                    ma3.c(e);
                }
                callbackContext.success(jSONObject2);
            }
        });
        this.cordova.getActivity().runOnUiThread(new Runnable() { // from class: org.apache.cordova.jssdk.LxLoginPlugin.2
            @Override // java.lang.Runnable
            public void run() {
                ua3Var.n(omVar);
            }
        });
    }

    private void getUserInfoByScope(final CallbackContext callbackContext, final String str) {
        Activity activity = this.cordova.getActivity();
        if (activity == null) {
            return;
        }
        CordovaWebView cordovaWebView = this.webView;
        final ka3.b appInfo = cordovaWebView.pluginManager.getAppInfo(cordovaWebView.loadedUrl);
        if (appInfo == null) {
            callbackContext.error(CordovaUtils.makeNormalJsResult(PluginResult.Status.PERMISSION_DENIED));
        } else {
            final ua3 ua3Var = new ua3(activity, new e84() { // from class: org.apache.cordova.jssdk.LxLoginPlugin.4
                @Override // defpackage.e84
                public void onCallback(int i, String str2, Object obj) {
                    JSONObject jSONObjectB;
                    if (i == 1) {
                        jSONObjectB = CordovaUtils.makeNormalJsResult(PluginResult.Status.OK);
                        try {
                            jSONObjectB.put("data", str2);
                        } catch (JSONException e) {
                            ma3.c(e);
                        }
                    } else {
                        jSONObjectB = wa3.b(PluginResult.Status.ERROR.ordinal() + "", str2);
                    }
                    callbackContext.success(jSONObjectB);
                }
            });
            activity.runOnUiThread(new Runnable() { // from class: org.apache.cordova.jssdk.LxLoginPlugin.5
                @Override // java.lang.Runnable
                public void run() throws Throwable {
                    if ("USERINFO".equals(str)) {
                        ua3Var.k(appInfo);
                    } else if ("MOBILE".equals(str)) {
                        ua3Var.j(appInfo);
                    }
                }
            });
        }
    }

    @Override // org.apache.cordova.CordovaPlugin
    public boolean execute(String str, String str2, CallbackContext callbackContext) throws JSONException {
        if (this.cordova.getActivity() == null) {
            return false;
        }
        if (str.equals("lx_login")) {
            doLogin(str2, callbackContext);
            return true;
        }
        if (str.equals("lx_auth")) {
            doAuth(callbackContext);
            return true;
        }
        if (str.equals("lx_getUserInfo")) {
            getUserInfoByScope(callbackContext, "USERINFO");
            return true;
        }
        if (!str.equals("lx_getPhoneNumber")) {
            return super.execute(str, str2, callbackContext);
        }
        getUserInfoByScope(callbackContext, "MOBILE");
        return true;
    }
}
