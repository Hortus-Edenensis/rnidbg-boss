package org.apache.webplatform.jssdk;

import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import defpackage.ap3;
import defpackage.gn2;
import defpackage.ju4;
import defpackage.pt4;
import defpackage.tg4;
import org.apache.cordovaNew.CallbackContext;
import org.apache.cordovaNew.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class RedPacketPlugin extends CordovaPlugin {
    public static final String ACTION_ISCONTACTCLOSE = "isContactClose";
    public static final String ACTION_OPENWALLET = "openWallet";
    public static final String ACTION_UPLOADCONTACTEXT = "uploadContactExt";
    private static final int PERMISSION_REQUEST_SELECT_LOCATION = 1;
    private CallbackContext mCallbackContext;

    private void startRealNameVerification(final CallbackContext callbackContext) {
        ju4.c(this.cordova.getActivity(), new pt4() { // from class: org.apache.webplatform.jssdk.RedPacketPlugin.2
            @Override // defpackage.pt4
            public void failed(int i, String str) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("code", i);
                    jSONObject.put("msg", str);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                callbackContext.error(jSONObject);
            }

            @Override // defpackage.pt4
            public void success() {
                callbackContext.success();
            }
        });
    }

    private void uploadContact(final CallbackContext callbackContext) {
        ap3.a().q(new gn2.b() { // from class: org.apache.webplatform.jssdk.RedPacketPlugin.1
            @Override // gn2.b
            public void onFinish(int i) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("status", i);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                callbackContext.success(jSONObject);
            }
        });
    }

    private void uploadContactExt(CallbackContext callbackContext) {
        try {
            this.mCallbackContext = callbackContext;
            if (this.cordova.hasPermission("android.permission.READ_CONTACTS")) {
                CallbackContext callbackContext2 = this.mCallbackContext;
                if (callbackContext2 != null) {
                    uploadContact(callbackContext2);
                }
            } else {
                this.cordova.requestPermission(this, 1, "android.permission.READ_CONTACTS");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // org.apache.cordovaNew.CordovaPlugin
    public boolean execute(String str, JSONArray jSONArray, CallbackContext callbackContext) throws JSONException {
        if (str.equals("startRealNameVerification")) {
            startRealNameVerification(callbackContext);
            return true;
        }
        if (str.equals(ACTION_OPENWALLET)) {
            ju4.d(this.cordova.getActivity());
            callbackContext.success();
            return true;
        }
        if (str.equals("isContactClose")) {
            callbackContext.success(!tg4.b(this.cordova.getActivity(), BaseActivityPermissionDispatcher.PermissionType.CONTACT.permissionList) ? 1 : 0);
            return true;
        }
        if (!str.equals("uploadContactExt")) {
            return super.execute(str, jSONArray, callbackContext);
        }
        uploadContactExt(callbackContext);
        return true;
    }

    @Override // org.apache.cordovaNew.CordovaPlugin
    public void onRequestPermissionResult(int i, String[] strArr, int[] iArr) throws JSONException {
        super.onRequestPermissionResult(i, strArr, iArr);
        if (i == 1 && iArr.length > 0 && iArr[0] == 0) {
            CallbackContext callbackContext = this.mCallbackContext;
            if (callbackContext != null) {
                uploadContact(callbackContext);
                return;
            }
            return;
        }
        if (this.mCallbackContext != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("status", -2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.mCallbackContext.success(jSONObject);
        }
    }
}
