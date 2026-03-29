package org.apache.cordova;

import android.webkit.JavascriptInterface;
import org.json.JSONException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
class ExposedJsApi {
    private CordovaBridge bridge;

    public ExposedJsApi(CordovaBridge cordovaBridge) {
        this.bridge = cordovaBridge;
    }

    @JavascriptInterface
    public String exec(int i, String str, String str2, String str3, String str4) throws JSONException, IllegalAccessException {
        return this.bridge.jsExec(i, str, str2, str3, str4);
    }

    @JavascriptInterface
    public String retrieveJsMessages(int i, boolean z) throws IllegalAccessException {
        return this.bridge.jsRetrieveJsMessages(i, z);
    }

    @JavascriptInterface
    public void setNativeToJsBridgeMode(int i, int i2) throws IllegalAccessException {
        this.bridge.jsSetNativeToJsBridgeMode(i, i2);
    }
}
