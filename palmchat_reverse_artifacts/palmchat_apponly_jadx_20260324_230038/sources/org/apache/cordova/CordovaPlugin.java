package org.apache.cordova;

import android.content.Intent;
import android.net.Uri;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class CordovaPlugin {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public CordovaInterface cordova;

    @Deprecated
    public String id;
    protected CordovaPreferences preferences;
    public CordovaWebView webView;

    public boolean execute(String str, CordovaArgs cordovaArgs, CallbackContext callbackContext) throws JSONException {
        return false;
    }

    public Object onMessage(String str, Object obj) {
        return null;
    }

    public boolean onOverrideUrlLoading(String str) {
        return false;
    }

    public boolean onReceivedClientCertRequest(CordovaWebView cordovaWebView, ICordovaClientCertRequest iCordovaClientCertRequest) {
        return false;
    }

    public boolean onReceivedHttpAuthRequest(CordovaWebView cordovaWebView, ICordovaHttpAuthHandler iCordovaHttpAuthHandler, String str, String str2) {
        return false;
    }

    public final void privateInitialize(CordovaInterface cordovaInterface, CordovaWebView cordovaWebView, CordovaPreferences cordovaPreferences) {
        this.cordova = cordovaInterface;
        this.webView = cordovaWebView;
        this.preferences = cordovaPreferences;
        initialize(cordovaInterface, cordovaWebView);
        pluginInitialize();
    }

    public Uri remapUri(Uri uri) {
        return null;
    }

    public boolean execute(String str, String str2, CallbackContext callbackContext) throws JSONException {
        return execute(str, new JSONArray(str2), callbackContext);
    }

    public boolean execute(String str, JSONArray jSONArray, CallbackContext callbackContext) throws JSONException {
        return execute(str, new CordovaArgs(jSONArray), callbackContext);
    }

    public void onDestroy() {
    }

    public void onReset() {
    }

    public void pluginInitialize() {
    }

    public void onNewIntent(Intent intent) {
    }

    public void onPause(boolean z) {
    }

    public void onResume(boolean z) {
    }

    public void initialize(CordovaInterface cordovaInterface, CordovaWebView cordovaWebView) {
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    public void onRequestPermissionResult(int i, String[] strArr, int[] iArr) throws JSONException {
    }
}
