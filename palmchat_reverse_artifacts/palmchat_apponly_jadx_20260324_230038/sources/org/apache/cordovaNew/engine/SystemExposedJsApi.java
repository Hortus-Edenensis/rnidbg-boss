package org.apache.cordovaNew.engine;

import android.webkit.JavascriptInterface;
import org.apache.cordovaNew.CordovaBridge;
import org.apache.cordovaNew.ExposedJsApi;
import org.json.JSONException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
class SystemExposedJsApi implements ExposedJsApi {
    private final CordovaBridge bridge;

    public SystemExposedJsApi(CordovaBridge cordovaBridge) {
        this.bridge = cordovaBridge;
    }

    @Override // org.apache.cordovaNew.ExposedJsApi
    @JavascriptInterface
    public String exec(int i, String str, String str2, String str3, String str4) throws JSONException, IllegalAccessException {
        return this.bridge.jsExec(i, str, str2, str3, str4);
    }

    @Override // org.apache.cordovaNew.ExposedJsApi
    @JavascriptInterface
    public String retrieveJsMessages(int i, boolean z) throws IllegalAccessException {
        return this.bridge.jsRetrieveJsMessages(i, z);
    }

    @Override // org.apache.cordovaNew.ExposedJsApi
    @JavascriptInterface
    public void setNativeToJsBridgeMode(int i, int i2) throws IllegalAccessException {
        this.bridge.jsSetNativeToJsBridgeMode(i, i2);
    }
}
