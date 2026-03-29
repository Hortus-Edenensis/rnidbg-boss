package org.apache.webplatform.jssdk;

import android.util.Log;
import defpackage.nl0;
import defpackage.yw4;
import defpackage.yy2;
import defpackage.zw4;
import org.apache.cordova.jssdk.general.Action;
import org.apache.cordovaNew.CallbackContext;
import org.apache.cordovaNew.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class LocalApiPlugin extends CordovaPlugin {
    private static String TAG = "LocalApiPlugin";

    @Override // org.apache.cordovaNew.CordovaPlugin
    public boolean execute(String str, JSONArray jSONArray, final CallbackContext callbackContext) throws JSONException {
        Log.i(TAG, str + "-" + jSONArray.toString());
        if (str.equals(Action.ACTION_LOCAL_API)) {
            zw4.f(jSONArray.optString(0), jSONArray.optInt(1), jSONArray.optJSONObject(2), new yw4() { // from class: org.apache.webplatform.jssdk.LocalApiPlugin.1
                @Override // defpackage.yw4
                public void onFail(Exception exc) {
                    Log.i(LocalApiPlugin.TAG, exc.toString());
                    callbackContext.error(exc.toString());
                }

                @Override // defpackage.yw4
                public void onSuccess(JSONObject jSONObject, yy2 yy2Var) {
                    Log.i(LocalApiPlugin.TAG, jSONObject.toString());
                    callbackContext.success(jSONObject);
                }
            });
            return true;
        }
        if (str.equals(Action.ACTION_LOCAL_API_LXSERVER)) {
            zw4.f(nl0.b + jSONArray.optString(0), jSONArray.optInt(1), jSONArray.optJSONObject(2), new yw4() { // from class: org.apache.webplatform.jssdk.LocalApiPlugin.2
                @Override // defpackage.yw4
                public void onFail(Exception exc) {
                    Log.i(LocalApiPlugin.TAG, exc.toString());
                    callbackContext.error(exc.toString());
                }

                @Override // defpackage.yw4
                public void onSuccess(JSONObject jSONObject, yy2 yy2Var) {
                    Log.i(LocalApiPlugin.TAG, jSONObject.toString());
                    callbackContext.success(jSONObject);
                }
            });
            return true;
        }
        if (str.equals(Action.ACTION_LOCAL_API_BEFORE_LOGIN)) {
            zw4.h(nl0.b + jSONArray.optString(0), jSONArray.optString(1), jSONArray.optString(2), jSONArray.optInt(3), jSONArray.optJSONObject(4), new yw4() { // from class: org.apache.webplatform.jssdk.LocalApiPlugin.3
                @Override // defpackage.yw4
                public void onFail(Exception exc) {
                    Log.i(LocalApiPlugin.TAG, exc.toString());
                    callbackContext.error(exc.toString());
                }

                @Override // defpackage.yw4
                public void onSuccess(JSONObject jSONObject, yy2 yy2Var) {
                    Log.i(LocalApiPlugin.TAG, jSONObject.toString());
                    callbackContext.success(jSONObject);
                }
            });
            return true;
        }
        if (str.equals("uploadPortrait")) {
            String str2 = nl0.b + jSONArray.optString(0);
            String string = jSONArray.getString(1);
            Log.i(TAG, "url is " + str2 + " file url :" + string);
            zw4.n(str2, string, "headImg", new yw4() { // from class: org.apache.webplatform.jssdk.LocalApiPlugin.4
                @Override // defpackage.yw4
                public void onFail(Exception exc) {
                    Log.i(LocalApiPlugin.TAG, exc.toString());
                    callbackContext.error(exc.toString());
                }

                @Override // defpackage.yw4
                public void onSuccess(JSONObject jSONObject, yy2 yy2Var) {
                    Log.i(LocalApiPlugin.TAG, jSONObject.toString());
                    callbackContext.success(jSONObject);
                }
            });
            return true;
        }
        if (!str.equals("uploadPortraitBeforeLogin")) {
            return false;
        }
        String str3 = nl0.b + jSONArray.optString(0);
        String strOptString = jSONArray.optString(1);
        String strOptString2 = jSONArray.optString(2);
        String string2 = jSONArray.getString(3);
        Log.i(TAG, "url is " + str3 + " file url :" + string2);
        zw4.o(str3, strOptString, strOptString2, string2, "headImg", new yw4() { // from class: org.apache.webplatform.jssdk.LocalApiPlugin.5
            @Override // defpackage.yw4
            public void onFail(Exception exc) {
                Log.i(LocalApiPlugin.TAG, exc.toString());
                callbackContext.error(exc.toString());
            }

            @Override // defpackage.yw4
            public void onSuccess(JSONObject jSONObject, yy2 yy2Var) {
                Log.i(LocalApiPlugin.TAG, jSONObject.toString());
                callbackContext.success(jSONObject);
            }
        });
        return true;
    }
}
