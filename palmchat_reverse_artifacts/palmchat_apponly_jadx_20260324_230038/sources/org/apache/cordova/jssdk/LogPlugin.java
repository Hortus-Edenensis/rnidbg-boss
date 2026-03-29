package org.apache.cordova.jssdk;

import android.util.Log;
import defpackage.zn6;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class LogPlugin extends CordovaPlugin {
    private static String TAG = "LogPlugin";

    @Override // org.apache.cordova.CordovaPlugin
    public boolean execute(String str, JSONArray jSONArray, CallbackContext callbackContext) throws JSONException {
        Log.i(TAG, str + "-" + jSONArray.toString());
        if (str.equals("wkLog")) {
            zn6.e(jSONArray.optString(0), jSONArray.optString(1), jSONArray.optString(2), jSONArray.optString(3));
        }
        return true;
    }
}
