package org.apache.webplatform.jssdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import android.webkit.WebView;
import com.zenmen.openapi.config.LxApiProxy;
import defpackage.ab3;
import defpackage.ba3;
import defpackage.ib3;
import defpackage.v93;
import defpackage.w93;
import defpackage.wl2;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import org.apache.cordovaNew.CallbackContext;
import org.apache.cordovaNew.CordovaInterface;
import org.apache.cordovaNew.CordovaPlugin;
import org.apache.cordovaNew.CordovaWebView;
import org.apache.http.HttpHost;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class LxPluginManager extends CordovaPlugin implements ab3, ba3 {
    private ib3 mActivityResultCallback;
    protected int mActivityResultRequestCode;
    private wl2 mPluginImpl;
    private Map<String, CallbackContext> mCallbacks = new HashMap();
    private w93 mCallbackMap = new w93();

    private boolean executeImpl(String str, String str2, CallbackContext callbackContext) throws JSONException {
        if (this.mPluginImpl == null) {
            return false;
        }
        this.mCallbacks.put(callbackContext.getCallbackId(), callbackContext);
        this.mPluginImpl.executeAction(str, str2, new v93(callbackContext.getCallbackId(), this));
        return true;
    }

    public static boolean startActivityForUrl(Context context, String str) {
        Intent uri;
        try {
            uri = Intent.parseUri(str, 1);
        } catch (URISyntaxException | Exception unused) {
        }
        if (context.getPackageManager().resolveActivity(uri, 0) == null) {
            return false;
        }
        if (context instanceof Activity) {
            return ((Activity) context).startActivityIfNeeded(uri, -1);
        }
        context.startActivity(uri);
        return true;
    }

    @Override // org.apache.cordovaNew.CordovaPlugin
    public boolean execute(String str, JSONArray jSONArray, CallbackContext callbackContext) throws JSONException {
        return executeImpl(str, (jSONArray == null || jSONArray.length() <= 0) ? "" : jSONArray.opt(0).toString(), callbackContext);
    }

    @Override // defpackage.ba3
    public Activity getActivity() {
        return this.cordova.getActivity();
    }

    @Override // defpackage.ba3
    public WebView getWebView() {
        return (WebView) this.webView.getView();
    }

    @Override // defpackage.ba3
    public boolean hasPermission(String str) {
        return this.cordova.hasPermission(str);
    }

    @Override // org.apache.cordovaNew.CordovaPlugin
    public void initialize(CordovaInterface cordovaInterface, CordovaWebView cordovaWebView) {
        super.initialize(cordovaInterface, cordovaWebView);
        wl2 wl2VarCreateGeneralPlugin = LxApiProxy.getInstance().getPluginFactory().createGeneralPlugin(cordovaInterface.getActivity(), (WebView) cordovaWebView.getView());
        this.mPluginImpl = wl2VarCreateGeneralPlugin;
        wl2VarCreateGeneralPlugin.initialize(this);
    }

    @Override // org.apache.cordovaNew.CordovaPlugin
    public void onActivityResult(int i, int i2, Intent intent) {
        ib3 ib3Var = this.mActivityResultCallback;
        this.mActivityResultCallback = null;
        if (ib3Var != null) {
            ib3Var.onActivityResult(i, i2, intent);
        }
    }

    @Override // org.apache.cordovaNew.CordovaPlugin
    public boolean onOverrideUrlLoading(String str) {
        if (str.startsWith("file") || str.startsWith("about:blank") || str.toLowerCase().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            return false;
        }
        wl2 wl2Var = this.mPluginImpl;
        if (wl2Var == null || !wl2Var.routerToTargetPage(str)) {
            return startActivityForUrl(this.cordova.getActivity(), str);
        }
        return true;
    }

    @Override // org.apache.cordovaNew.CordovaPlugin
    public void onRequestPermissionResult(int i, String[] strArr, int[] iArr) throws JSONException {
        Pair<ib3, Integer> pairA = this.mCallbackMap.a(i);
        if (pairA != null) {
            ((ib3) pairA.first).onRequestPermissionResult(((Integer) pairA.second).intValue(), strArr, iArr);
        }
    }

    @Override // defpackage.ab3
    public void onResult(String str, JSONObject jSONObject) {
        CallbackContext callbackContextRemove = this.mCallbacks.remove(str);
        if (callbackContextRemove != null) {
            callbackContextRemove.success(jSONObject);
        }
    }

    @Override // defpackage.ba3
    public void requestPermission(ib3 ib3Var, int i, String str) {
        requestPermissions(ib3Var, i, new String[]{str});
    }

    public void requestPermissions(ib3 ib3Var, int i, String[] strArr) {
        this.cordova.requestPermissions(this, this.mCallbackMap.b(ib3Var, i), strArr);
    }

    public void setActivityResultCallback(ib3 ib3Var) {
        ib3 ib3Var2 = this.mActivityResultCallback;
        if (ib3Var2 != null) {
            ib3Var2.onActivityResult(this.mActivityResultRequestCode, 0, null);
        }
        this.mActivityResultCallback = ib3Var;
    }

    @Override // defpackage.ba3
    public void startActivityForResult(ib3 ib3Var, Intent intent, int i) {
        setActivityResultCallback(ib3Var);
        try {
            this.cordova.startActivityForResult(this, intent, i);
        } catch (RuntimeException e) {
            this.mActivityResultCallback = null;
            throw e;
        }
    }
}
