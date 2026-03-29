package org.apache.cordova.jssdk;

import org.apache.cordova.CallbackContext;
import org.json.JSONException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class LxRewardVideoPlugin extends LxBaseAdPlugin {
    @Override // org.apache.cordova.CordovaPlugin
    public boolean execute(String str, String str2, CallbackContext callbackContext) throws JSONException {
        if (!str.equals("lx_createRewardedVideoAd")) {
            return super.execute(str, str2, callbackContext);
        }
        requestH5Banner(str2, callbackContext);
        return true;
    }
}
