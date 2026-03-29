package org.apache.cordova.jssdk;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.widget.Toast;
import com.afollestad.materialdialogs.MaterialDialog;
import com.huawei.openalliance.ad.constant.be;
import com.lantern.auth.server.WkParams;
import com.oplus.tblplayer.Constants;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.wifi.ad.core.config.EventParams;
import com.zenmen.openapi.auth.widget.a;
import com.zenmen.openapi.impl.OADeviceUtils;
import com.zenmen.openapi.jssdk.widget.PermissionDialogView;
import com.zenmen.palmchat.AppContext;
import defpackage.ac1;
import defpackage.an1;
import defpackage.bu3;
import defpackage.bx2;
import defpackage.f84;
import defpackage.g84;
import defpackage.hx3;
import defpackage.ma3;
import defpackage.pt5;
import defpackage.qt5;
import defpackage.tn2;
import defpackage.vy3;
import defpackage.w43;
import defpackage.wa3;
import defpackage.x93;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class LxCommPlugin extends CordovaPlugin {
    private static final String ZX_LOCAL_RES = "/zx_local_res/";
    private String mAppId;
    private String mHost;
    private tn2 mOfflineRes;

    private void aesEncryptRequest(String str, final CallbackContext callbackContext) throws JSONException {
        HashMap map = new HashMap();
        JSONObject jSONObject = new JSONObject(str);
        String strOptString = jSONObject.optString("pid");
        String str2 = (String) jSONObject.remove("url");
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            map.put(next, jSONObject.opt(next) + "");
        }
        vy3.c(strOptString, "JsTask", new pt5<qt5>() { // from class: org.apache.cordova.jssdk.LxCommPlugin.2
            @Override // defpackage.pt5
            public void onPostExecute(qt5 qt5Var) {
                JSONObject jSONObjectB;
                if (qt5Var.f20322a == 1) {
                    jSONObjectB = CordovaUtils.makeNormalJsResult(PluginResult.Status.OK);
                    try {
                        jSONObjectB.put("data", qt5Var.c);
                    } catch (JSONException e) {
                        ma3.c(e);
                    }
                } else {
                    jSONObjectB = wa3.b(PluginResult.Status.ERROR.ordinal() + "", qt5Var.b);
                }
                callbackContext.success(jSONObjectB);
            }

            @Override // defpackage.pt5
            public void onPreExecute(String str3) {
            }
        }, map, str2);
    }

    private Intent checkInnerApp(String str) {
        try {
            String strOptString = new JSONObject(str).optString("originUrl");
            if (TextUtils.isEmpty(strOptString)) {
                return null;
            }
            return bu3.g().e(this.cordova.getOwnerActivity2(), strOptString);
        } catch (JSONException e) {
            ma3.c(e);
            return null;
        }
    }

    private void closeWebView() {
        this.cordova.getOwnerActivity2().finish();
    }

    private void getDeviceId(CallbackContext callbackContext) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("deviceId", OADeviceUtils.getDeviceId());
        } catch (JSONException e) {
            ma3.c(e);
        }
        callbackContext.success(jSONObject);
    }

    private void getDeviceInfos(CallbackContext callbackContext) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(EventParams.KEY_PARAM_NETTYPE, hx3.f());
            jSONObject.put("operator", hx3.i(AppContext.getContext()));
            jSONObject.put(WkParams.OSVER, Build.VERSION.SDK_INT);
            jSONObject.put("isPad", ac1.F(AppContext.getContext()) ? 2 : 1);
            jSONObject.put(WkParams.MANUF, Build.MANUFACTURER);
            jSONObject.put(WkParams.MODEL, Build.MODEL);
            PackageInfo packageInfo = AppContext.getContext().getPackageManager().getPackageInfo(AppContext.getContext().getPackageName(), 0);
            if (packageInfo != null) {
                jSONObject.put("appVerCode", packageInfo.versionCode);
                jSONObject.put("appVerName", packageInfo.versionName);
            }
            jSONObject.put("appPkg", AppContext.getContext().getPackageId());
            jSONObject.put("aid", ac1.o(AppContext.getContext()));
            jSONObject.put("channelId", ac1.m);
        } catch (PackageManager.NameNotFoundException e) {
            ma3.c(e);
        } catch (JSONException e2) {
            ma3.c(e2);
        }
        callbackContext.success(jSONObject);
    }

    private void getPrivDeviceInfos(final CallbackContext callbackContext, String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
            jSONObject = null;
        }
        PermissionDialogView.a aVar = new PermissionDialogView.a();
        CordovaWebView cordovaWebView = this.webView;
        aVar.f12022a = cordovaWebView.pluginManager.getAppInfo(cordovaWebView.loadedUrl);
        aVar.b = "com.zenmen.palmchat.permissions.ACCESS_PRIV_DEVICEINFO";
        aVar.c = jSONObject.optString("requestTarget");
        w43.e(this.cordova.getOwnerActivity2(), aVar, new a.b() { // from class: org.apache.cordova.jssdk.LxCommPlugin.1
            @Override // com.zenmen.openapi.auth.widget.a.b
            public void onConfirmback(int i) {
                if (i != 0) {
                    callbackContext.error("Permission denied");
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("mac", OADeviceUtils.getMac());
                    jSONObject2.put(WkParams.IMEI, OADeviceUtils.getImei());
                    jSONObject2.put("ssid", hx3.l());
                    jSONObject2.put("bssid", hx3.k());
                } catch (JSONException e2) {
                    ma3.c(e2);
                }
                callbackContext.success(jSONObject2);
            }
        });
    }

    private void getUserAgent(CallbackContext callbackContext) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(WkParams.MANUF, Build.MANUFACTURER);
            jSONObject.put(WkParams.MODEL, Build.MODEL);
            jSONObject.put("os", AnalyticsConstants.SDK_TYPE);
            jSONObject.put(WkParams.OSVER, Build.VERSION.SDK_INT + "");
            Activity ownerActivity2 = this.cordova.getOwnerActivity2();
            PackageInfo packageInfo = ownerActivity2.getPackageManager().getPackageInfo(ownerActivity2.getPackageName(), 0);
            jSONObject.put("appVerCode", packageInfo.versionCode);
            jSONObject.put("appVerName", packageInfo.versionName);
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

    private void getWebViewSize(CallbackContext callbackContext) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("widthPixels", this.webView.getWidth());
            jSONObject.put("heightPixels", this.webView.getHeight());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        callbackContext.success(jSONObject);
    }

    private void showAlertDialog(String str, final CallbackContext callbackContext) throws JSONException {
        Activity ownerActivity2 = this.cordova.getOwnerActivity2();
        if (ownerActivity2 == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject(str);
        String strOptString = jSONObject.optString("message");
        String strOptString2 = jSONObject.optString("title");
        String strOptString3 = jSONObject.optString("confirmText");
        String strOptString4 = jSONObject.optString("cancelText");
        boolean zOptBoolean = jSONObject.optBoolean("cancelable");
        final x93.a aVar = new x93.a(ownerActivity2);
        aVar.U(strOptString2).h(zOptBoolean).k(strOptString);
        if (!TextUtils.isEmpty(strOptString3)) {
            aVar.P(strOptString3);
        }
        if (!TextUtils.isEmpty(strOptString4)) {
            aVar.L(strOptString4);
        }
        final JSONObject jSONObjectMakeNormalJsResult = CordovaUtils.makeNormalJsResult(PluginResult.Status.OK);
        aVar.f(new MaterialDialog.e() { // from class: org.apache.cordova.jssdk.LxCommPlugin.3
            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onNegative(MaterialDialog materialDialog) {
                super.onNegative(materialDialog);
                try {
                    jSONObjectMakeNormalJsResult.put("msg", "cancel");
                } catch (JSONException unused) {
                }
                callbackContext.success(jSONObjectMakeNormalJsResult);
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onPositive(MaterialDialog materialDialog) {
                super.onPositive(materialDialog);
                try {
                    jSONObjectMakeNormalJsResult.put("msg", "confirm");
                } catch (JSONException unused) {
                }
                callbackContext.success(jSONObjectMakeNormalJsResult);
            }
        });
        aVar.g(new DialogInterface.OnCancelListener() { // from class: org.apache.cordova.jssdk.LxCommPlugin.4
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                try {
                    jSONObjectMakeNormalJsResult.put("msg", "cancel");
                } catch (JSONException unused) {
                }
                callbackContext.success(jSONObjectMakeNormalJsResult);
            }
        });
        ownerActivity2.runOnUiThread(new Runnable() { // from class: org.apache.cordova.jssdk.LxCommPlugin.5
            @Override // java.lang.Runnable
            public void run() {
                aVar.e().show();
            }
        });
    }

    private void showToast(String str, CallbackContext callbackContext) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            showToast(jSONObject.optString("text", ""), jSONObject.optInt("duration", 0), jSONObject.optInt(EventParams.KEY_CT_SDK_POSITION, 0));
            callbackContext.success();
        } catch (JSONException e) {
            ma3.c(e);
            callbackContext.error("Data format error!");
        }
    }

    @Override // org.apache.cordova.CordovaPlugin
    public boolean execute(String str, String str2, CallbackContext callbackContext) throws JSONException {
        if (str.equals("lx_getUserAgent")) {
            getUserAgent(callbackContext);
            return true;
        }
        if (str.equals("lx_getDeviceInfo")) {
            getDeviceInfos(callbackContext);
            return true;
        }
        if (str.equals("lx_getPrivDeviceInfo")) {
            getPrivDeviceInfos(callbackContext, str2);
            return true;
        }
        if (str.equals("lx_getDeviceId")) {
            getDeviceId(callbackContext);
            return true;
        }
        if (str.equals("lx_getWebViewSize")) {
            getWebViewSize(callbackContext);
            return true;
        }
        if (str.equals("lx_closeWebView")) {
            closeWebView();
            return true;
        }
        if (str.equals("lx_openNativeApp")) {
            Intent intentCheckInnerApp = checkInnerApp(str2);
            if (intentCheckInnerApp != null) {
                this.cordova.getOwnerActivity2().startActivity(intentCheckInnerApp);
                callbackContext.success();
            } else {
                callbackContext.error("error");
            }
            return true;
        }
        if (str.equals("lx_checkNativeApp")) {
            if (checkInnerApp(str2) != null) {
                callbackContext.success();
            } else {
                callbackContext.error("error");
            }
            return true;
        }
        if (str.equals("lx_reportEvent")) {
            CordovaWebView cordovaWebView = this.webView;
            f84.d(cordovaWebView.pluginManager.getAppInfo(cordovaWebView.loadedUrl).f21948a, CordovaUtils.removeQuotation(str2));
            callbackContext.success();
            return true;
        }
        if (str.equals("lx_reportEventExtra")) {
            CordovaWebView cordovaWebView2 = this.webView;
            if (f84.c(cordovaWebView2.pluginManager.getAppInfo(cordovaWebView2.loadedUrl).f21948a, str2)) {
                callbackContext.success();
            } else {
                callbackContext.error("Data format error!");
            }
            return true;
        }
        if (str.equals("lx_reportAppState")) {
            if (f84.a(str2)) {
                callbackContext.success();
            } else {
                callbackContext.error("Data format error!");
            }
            return true;
        }
        if (str.equals("lx_showToast")) {
            showToast(str2, callbackContext);
            return true;
        }
        if (str.equals("dispatchEventToNative")) {
            an1.c().l(new bx2(str2));
            callbackContext.success();
            return true;
        }
        if (str.equals("aesEncryptRequest")) {
            aesEncryptRequest(str2, callbackContext);
            return true;
        }
        if (!str.equals("lx_alert")) {
            return false;
        }
        showAlertDialog(str2, callbackContext);
        return true;
    }

    @Override // org.apache.cordova.CordovaPlugin
    public void initialize(CordovaInterface cordovaInterface, CordovaWebView cordovaWebView) {
        int iLastIndexOf;
        super.initialize(cordovaInterface, cordovaWebView);
        String launchUrl = cordovaInterface.getLaunchUrl();
        if (!TextUtils.isEmpty(launchUrl) && (iLastIndexOf = launchUrl.lastIndexOf("/")) >= 0) {
            this.mHost = cordovaInterface.getLaunchUrl().substring(0, iLastIndexOf);
        }
        this.mAppId = cordovaInterface.getAppId();
        this.mOfflineRes = (tn2) g84.a(tn2.class);
    }

    @Override // org.apache.cordova.CordovaPlugin
    public Uri remapUri(Uri uri) {
        tn2 tn2Var;
        String string = uri.toString();
        if (string.contains("/zx_local_res/")) {
            String strSubstring = string.substring(string.indexOf("/zx_local_res/") + 14);
            try {
                try {
                    this.cordova.getOwnerActivity2().getAssets().open(strSubstring);
                    uri = Uri.parse("file:///android_asset/" + strSubstring);
                    return uri;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else if (!TextUtils.isEmpty(this.mAppId) && !TextUtils.isEmpty(this.mHost) && (tn2Var = this.mOfflineRes) != null && tn2Var.isEnable()) {
            try {
                String strB = this.mOfflineRes.b(this.mAppId);
                if (!TextUtils.isEmpty(strB)) {
                    String strReplace = string.replace(this.mHost, strB);
                    int iIndexOf = strReplace.indexOf(Constants.STRING_VALUE_UNSET);
                    if (iIndexOf != -1) {
                        strReplace = strReplace.substring(0, iIndexOf);
                    }
                    File file = new File(strReplace);
                    if (file.exists()) {
                        return Uri.fromFile(file);
                    }
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        return super.remapUri(uri);
    }

    private void showToast(String str, int i, int i2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Toast toastMakeText = Toast.makeText(this.cordova.getOwnerActivity2(), str, i);
        if (i2 == 1) {
            toastMakeText.setGravity(17, 0, 0);
        } else if (i2 == 2) {
            toastMakeText.setGravity(49, 0, 0);
        }
        toastMakeText.show();
    }
}
