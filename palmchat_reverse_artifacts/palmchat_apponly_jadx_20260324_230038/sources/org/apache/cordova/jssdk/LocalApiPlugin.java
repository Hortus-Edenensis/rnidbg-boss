package org.apache.cordova.jssdk;

import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.android.volley.NetworkError;
import com.android.volley.NetworkResponse;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import defpackage.nl0;
import defpackage.yw4;
import defpackage.yy2;
import defpackage.zw4;
import java.util.HashMap;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.jssdk.general.Action;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class LocalApiPlugin extends CordovaPlugin {
    private static String TAG = "LocalApiPlugin";

    private void showToast(String str, int i, int i2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Toast toastMakeText = Toast.makeText(this.cordova.getActivity(), str, i);
        if (i2 == 1) {
            toastMakeText.setGravity(17, 0, 0);
        } else if (i2 == 2) {
            toastMakeText.setGravity(49, 0, 0);
        }
        toastMakeText.show();
    }

    @Override // org.apache.cordova.CordovaPlugin
    public boolean execute(String str, JSONArray jSONArray, final CallbackContext callbackContext) throws JSONException {
        Log.i(TAG, str + "-" + jSONArray.toString());
        if (str.equals(Action.ACTION_LOCAL_API)) {
            zw4.f(jSONArray.optString(0), jSONArray.optInt(1), jSONArray.optJSONObject(2), new yw4() { // from class: org.apache.cordova.jssdk.LocalApiPlugin.1
                @Override // defpackage.yw4
                public void onFail(Exception exc) {
                    callbackContext.error(exc.toString());
                }

                @Override // defpackage.yw4
                public void onSuccess(JSONObject jSONObject, yy2 yy2Var) {
                    callbackContext.success(jSONObject);
                }
            });
            return true;
        }
        if (str.equals(Action.ACTION_LOCAL_API_LXSERVER)) {
            zw4.f(nl0.b + jSONArray.optString(0), jSONArray.optInt(1), jSONArray.optJSONObject(2), new yw4() { // from class: org.apache.cordova.jssdk.LocalApiPlugin.2
                /* JADX WARN: Removed duplicated region for block: B:16:0x003c  */
                @Override // defpackage.yw4
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onFail(Exception exc) {
                    int i;
                    HashMap map = new HashMap();
                    Log.i(LocalApiPlugin.TAG, exc.toString());
                    String string = "";
                    if (exc instanceof VolleyError) {
                        VolleyError volleyError = (VolleyError) exc;
                        NetworkResponse networkResponse = volleyError.networkResponse;
                        if (networkResponse != null) {
                            i = networkResponse.statusCode;
                            try {
                                string = new String(networkResponse.data);
                            } catch (Exception unused) {
                            }
                        } else if (volleyError instanceof NetworkError) {
                            i = -1009;
                            string = "似乎已断开与互联网的连接。";
                        } else if (volleyError instanceof TimeoutError) {
                            i = -1001;
                            string = "请求超时。";
                        }
                    } else {
                        i = 0;
                    }
                    if (i == 0) {
                        i = -123456;
                    }
                    if (TextUtils.isEmpty(string)) {
                        string = exc.toString();
                    }
                    map.put("resultCode", Integer.valueOf(i));
                    map.put(MediationConstant.KEY_ERROR_MSG, string);
                    callbackContext.success(new JSONObject(map));
                }

                @Override // defpackage.yw4
                public void onSuccess(JSONObject jSONObject, yy2 yy2Var) {
                    Log.i(LocalApiPlugin.TAG, jSONObject.toString());
                    callbackContext.success(jSONObject);
                }
            });
            return true;
        }
        if (!str.equals(Action.ACTION_SHOW_TOAST)) {
            return false;
        }
        showToast(jSONArray.optString(0), jSONArray.optInt(1, 0), jSONArray.optInt(2, 0));
        callbackContext.success();
        return true;
    }
}
