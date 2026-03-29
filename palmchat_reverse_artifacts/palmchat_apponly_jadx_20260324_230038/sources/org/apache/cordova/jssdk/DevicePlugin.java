package org.apache.cordova.jssdk;

import android.util.Log;
import defpackage.hx3;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.jssdk.general.Action;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class DevicePlugin extends CordovaPlugin {
    private static final String TAG = "DevicePlugin";
    private CallbackContext mCallbackContext;

    private void getNetworkInfo() {
        this.mCallbackContext.success(hx3.g());
    }

    @Override // org.apache.cordova.CordovaPlugin
    public boolean execute(String str, JSONArray jSONArray, CallbackContext callbackContext) throws JSONException {
        Log.i(TAG, str + "-" + jSONArray.toString());
        this.mCallbackContext = callbackContext;
        if (!Action.ACTION_GET_NETWORK_INFO.equals(str)) {
            return false;
        }
        getNetworkInfo();
        return true;
    }
}
