package org.apache.cordova.jssdk;

import android.content.Intent;
import android.util.Log;
import com.zenmen.palmchat.chat.MediaPickActivity;
import java.util.Collection;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class ImagePlugin extends CordovaPlugin {
    public static int CORDOVA_IMAGE_PLUGIN_DOWNLOADER = 90;
    public static int CORDOVA_IMAGE_PLUGIN_PICKER = 11;
    public static int CORDOVA_IMAGE_PLUGIN_PREVIEW = 163;
    public static int CORDOVA_IMAGE_PLUGIN_UPLOADER = 211;
    private static String TAG = "ImagePlugin";
    private static String chooseImageParameterSizeType0 = "original";
    private static String chooseImageParameterSizeType1 = "compressed";
    private static String chooseImageParameterSourceType1 = "album";
    private static String chooseImageParameterSourceType2 = "camera";
    private CallbackContext mCallbackContext;

    @Override // org.apache.cordova.CordovaPlugin
    public boolean execute(String str, JSONArray jSONArray, CallbackContext callbackContext) {
        this.mCallbackContext = callbackContext;
        Log.e(TAG, "################action###############" + str);
        if (!str.equals("chooseImage")) {
            if (str.equals("previewImage")) {
                jSONArray.optString(0);
                jSONArray.optJSONObject(1);
                return true;
            }
            if (!str.equals("uploadImage")) {
                str.equals("downloadImage");
            }
            return false;
        }
        jSONArray.optInt(0);
        jSONArray.optString(1);
        String strOptString = jSONArray.optString(2);
        if (strOptString != null && !strOptString.equals(chooseImageParameterSourceType1)) {
            strOptString.equals(chooseImageParameterSourceType2);
        }
        Intent intent = new Intent(this.cordova.getActivity(), (Class<?>) MediaPickActivity.class);
        intent.putExtra("select_mode_key", 0);
        this.cordova.startActivityForResult(this, intent, CORDOVA_IMAGE_PLUGIN_PICKER);
        return true;
    }

    @Override // org.apache.cordova.CordovaPlugin
    public void onActivityResult(int i, int i2, Intent intent) {
        Log.e(TAG, "requestCode = " + i);
        if (i == CORDOVA_IMAGE_PLUGIN_PICKER) {
            if (i2 == -1 && intent != null) {
                this.mCallbackContext.success(new JSONArray((Collection) intent.getStringArrayListExtra("MULTIPLEFILENAMES")));
            } else if (i2 == 0 && intent != null) {
                this.mCallbackContext.error(intent.getStringExtra("ERRORMESSAGE"));
            } else if (i2 != 0) {
                this.mCallbackContext.error("No images selected");
            } else {
                this.mCallbackContext.success(new JSONArray());
            }
        }
    }
}
