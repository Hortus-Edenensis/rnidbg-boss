package org.apache.cordova.jssdk;

import android.app.Activity;
import android.text.TextUtils;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.zenmen.openapi.share.OpenShare;
import com.zenmen.openapi.webapp.MainActivity;
import defpackage.ka3;
import defpackage.ma3;
import defpackage.p75;
import defpackage.z84;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class LxSharePlugin extends CordovaPlugin {
    private int getShareType(JSONObject jSONObject) throws JSONException {
        return jSONObject.optInt("shareType", 0) == 1 ? 1 : 0;
    }

    private void shareImage(String str, CallbackContext callbackContext) {
        CordovaWebView cordovaWebView = this.webView;
        if (TextUtils.isEmpty(p75.d(cordovaWebView.pluginManager.getAppInfo(cordovaWebView.loadedUrl), str, this.cordova.getActivity()))) {
            callbackContext.success();
        } else {
            callbackContext.error("Data format error!");
        }
    }

    private void shareNameCard(String str, CallbackContext callbackContext) {
        CordovaWebView cordovaWebView = this.webView;
        String strE = p75.e(cordovaWebView.pluginManager.getAppInfo(cordovaWebView.loadedUrl), str, this.cordova.getActivity());
        if (TextUtils.isEmpty(strE)) {
            callbackContext.success();
        } else {
            callbackContext.error(strE);
        }
    }

    private void shareSVideo(String str, CallbackContext callbackContext) {
        CordovaWebView cordovaWebView = this.webView;
        String strF = p75.f(cordovaWebView.pluginManager.getAppInfo(cordovaWebView.loadedUrl), str, this.cordova.getActivity());
        if (TextUtils.isEmpty(strF)) {
            callbackContext.success();
        } else {
            callbackContext.error(strF);
        }
    }

    private void shareText(String str, CallbackContext callbackContext) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int shareType = getShareType(jSONObject);
            z84 z84Var = new z84(jSONObject.getString(RXScreenCaptureService.KEY_CONTENT_TEXT));
            CordovaWebView cordovaWebView = this.webView;
            ka3.b appInfo = cordovaWebView.pluginManager.getAppInfo(cordovaWebView.loadedUrl);
            z84Var.f(appInfo.c);
            z84Var.g(appInfo.b);
            z84Var.d(jSONObject.optString("authorIcon"));
            z84Var.e(jSONObject.optString("authorName"));
            new OpenShare.a().f(appInfo.f21948a).g(this.cordova.getActivity()).h(shareType).l(z84Var).e().share();
            callbackContext.success();
        } catch (JSONException e) {
            ma3.c(e);
            callbackContext.error("Data format error!");
        }
    }

    private void shareWeb(String str, CallbackContext callbackContext) {
        CordovaWebView cordovaWebView = this.webView;
        if (TextUtils.isEmpty(p75.g(cordovaWebView.pluginManager.getAppInfo(cordovaWebView.loadedUrl), str, this.cordova.getActivity()))) {
            callbackContext.success();
        } else {
            callbackContext.error("Data format error!");
        }
    }

    @Override // org.apache.cordova.CordovaPlugin
    public boolean execute(String str, String str2, CallbackContext callbackContext) throws JSONException {
        if (str.equals("lx_shareText")) {
            shareText(str2, callbackContext);
            return true;
        }
        if (str.equals("lx_shareWeb")) {
            shareWeb(str2, callbackContext);
            return true;
        }
        if (str.equals("lx_shareImage")) {
            shareImage(str2, callbackContext);
            return true;
        }
        if (str.equals("lx_shareNameCard")) {
            shareNameCard(str2, callbackContext);
            return true;
        }
        if (str.equals("lx_shareSVideo")) {
            shareSVideo(str2, callbackContext);
            return true;
        }
        if (str.equals("lx_shareApp")) {
            shareApp(str2, callbackContext);
            return true;
        }
        if (!str.equals("lx_shareWebApp")) {
            return false;
        }
        shareWebApp(str2, callbackContext);
        return true;
    }

    public void shareApp(String str, CallbackContext callbackContext) {
        CordovaWebView cordovaWebView = this.webView;
        String strC = p75.c(cordovaWebView.pluginManager.getAppInfo(cordovaWebView.loadedUrl), str, this.cordova.getActivity());
        if (TextUtils.isEmpty(strC)) {
            callbackContext.success();
        } else {
            callbackContext.error(strC);
        }
    }

    public void shareWebApp(String str, CallbackContext callbackContext) {
        CordovaWebView cordovaWebView = this.webView;
        ka3.b appInfo = cordovaWebView.pluginManager.getAppInfo(cordovaWebView.loadedUrl);
        Activity activity = this.cordova.getActivity();
        String strH = p75.h(appInfo, str, this.cordova.getActivity(), activity instanceof MainActivity ? ((MainActivity) activity).N1() : null);
        if (TextUtils.isEmpty(strH)) {
            callbackContext.success();
        } else {
            callbackContext.error(strH);
        }
    }
}
