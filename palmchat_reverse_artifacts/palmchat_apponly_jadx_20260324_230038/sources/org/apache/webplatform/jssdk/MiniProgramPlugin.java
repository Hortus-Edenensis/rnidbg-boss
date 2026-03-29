package org.apache.webplatform.jssdk;

import org.apache.cordovaNew.CallbackContext;
import org.apache.cordovaNew.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class MiniProgramPlugin extends CordovaPlugin {
    @Override // org.apache.cordovaNew.CordovaPlugin
    public boolean execute(String str, JSONArray jSONArray, CallbackContext callbackContext) throws JSONException {
        if (!"launch".equals(str)) {
            return super.execute(str, jSONArray, callbackContext);
        }
        jSONArray.optString(0);
        return true;
    }
}
