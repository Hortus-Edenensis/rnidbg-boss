package org.apache.cordova.jssdk;

import android.content.Intent;
import android.util.Log;
import com.zenmen.palmchat.QRCodeScan.ScannerActivity;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class ScanPlugin extends CordovaPlugin {
    private static final int CORDOVA_SCAN_PLUGIN_SCAN = 4097;
    private static final String TAG = "ScanPlugin";
    private CallbackContext mCallbackContext;

    @Override // org.apache.cordova.CordovaPlugin
    public boolean execute(String str, JSONArray jSONArray, CallbackContext callbackContext) throws JSONException {
        Log.i(TAG, str + "-" + jSONArray.toString());
        this.mCallbackContext = callbackContext;
        if (!"openScan".equals(str)) {
            return false;
        }
        Intent intent = new Intent(this.cordova.getActivity(), (Class<?>) ScannerActivity.class);
        intent.putExtra("from", TAG);
        this.cordova.startActivityForResult(this, intent, 4097);
        return true;
    }

    @Override // org.apache.cordova.CordovaPlugin
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 4097 && i2 == -1 && intent != null) {
            this.mCallbackContext.success(intent.getStringExtra("result"));
        }
    }
}
