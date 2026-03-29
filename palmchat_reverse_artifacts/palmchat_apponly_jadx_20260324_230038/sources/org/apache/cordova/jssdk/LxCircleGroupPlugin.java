package org.apache.cordova.jssdk;

import defpackage.m70;
import defpackage.ma3;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class LxCircleGroupPlugin extends CordovaPlugin {
    private void openCircleGroup(String str, final CallbackContext callbackContext) throws JSONException {
        m70.b(this.cordova.getActivity(), new JSONObject(str), new m70.b() { // from class: org.apache.cordova.jssdk.LxCircleGroupPlugin.1
            @Override // m70.b
            public void onFinish(int i, String str2, JSONObject jSONObject) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("code", i);
                    jSONObject2.put("msg", str2);
                    jSONObject2.put("data", jSONObject);
                } catch (JSONException e) {
                    ma3.c(e);
                }
                callbackContext.success(jSONObject2);
            }

            @Override // m70.b
            public void onStart() {
            }
        });
    }

    @Override // org.apache.cordova.CordovaPlugin
    public boolean execute(String str, String str2, CallbackContext callbackContext) throws JSONException {
        if (!"lx_addCircleGroup".equals(str)) {
            return super.execute(str, str2, callbackContext);
        }
        openCircleGroup(str2, callbackContext);
        return true;
    }
}
