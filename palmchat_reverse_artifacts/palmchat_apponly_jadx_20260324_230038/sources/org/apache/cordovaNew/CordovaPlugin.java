package org.apache.cordovaNew;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.cordovaNew.CordovaResourceApi;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class CordovaPlugin {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public CordovaInterface cordova;
    protected CordovaPreferences preferences;
    private String serviceName;
    public CordovaWebView webView;

    public boolean execute(String str, CordovaArgs cordovaArgs, CallbackContext callbackContext) throws JSONException {
        return false;
    }

    public Uri fromPluginUri(Uri uri) {
        return Uri.parse(uri.getQueryParameter("origUri"));
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public CordovaResourceApi.OpenForReadResult handleOpenForRead(Uri uri) throws IOException {
        throw new FileNotFoundException("Plugin can't handle uri: " + uri);
    }

    public boolean hasPermisssion() {
        return true;
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

    public Bundle onSaveInstanceState() {
        return null;
    }

    public final void privateInitialize(String str, CordovaInterface cordovaInterface, CordovaWebView cordovaWebView, CordovaPreferences cordovaPreferences) {
        this.serviceName = str;
        this.cordova = cordovaInterface;
        this.webView = cordovaWebView;
        this.preferences = cordovaPreferences;
        initialize(cordovaInterface, cordovaWebView);
        pluginInitialize();
    }

    public Uri remapUri(Uri uri) {
        return null;
    }

    public Boolean shouldAllowBridgeAccess(String str) {
        return shouldAllowNavigation(str);
    }

    public Boolean shouldAllowNavigation(String str) {
        return null;
    }

    public Boolean shouldAllowRequest(String str) {
        return null;
    }

    public Boolean shouldOpenExternalUrl(String str) {
        return null;
    }

    public Uri toPluginUri(Uri uri) {
        return new Uri.Builder().scheme(CordovaResourceApi.PLUGIN_URI_SCHEME).authority(this.serviceName).appendQueryParameter("origUri", uri.toString()).build();
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

    public void onStart() {
    }

    public void onStop() {
    }

    public void pluginInitialize() {
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onNewIntent(Intent intent) {
    }

    public void onPause(boolean z) {
    }

    public void onResume(boolean z) {
    }

    public void requestPermissions(int i) {
    }

    public void initialize(CordovaInterface cordovaInterface, CordovaWebView cordovaWebView) {
    }

    public void onRestoreStateForActivityResult(Bundle bundle, CallbackContext callbackContext) {
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    public void onRequestPermissionResult(int i, String[] strArr, int[] iArr) throws JSONException {
    }
}
