package org.apache.cordova.jssdk;

import android.content.ClipData;
import android.content.ClipboardManager;
import com.bytedance.bpea.entry.common.DataType;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class ClipboardPlugin extends CordovaPlugin {
    @Override // org.apache.cordova.CordovaPlugin
    public boolean execute(String str, JSONArray jSONArray, CallbackContext callbackContext) throws JSONException {
        ClipboardManager clipboardManager = (ClipboardManager) this.cordova.getActivity().getSystemService(DataType.CLIPBOARD);
        if (str.equals("setTextData")) {
            clipboardManager.setPrimaryClip(ClipData.newPlainText(jSONArray.getString(0), jSONArray.getString(0)));
            callbackContext.success();
            return true;
        }
        if (!str.equals("getTextData")) {
            return super.execute(str, jSONArray, callbackContext);
        }
        callbackContext.success(clipboardManager.getPrimaryClipDescription().hasMimeType(HTTP.PLAIN_TEXT_TYPE) ? clipboardManager.getPrimaryClip().getItemAt(0).getText().toString() : "");
        return true;
    }
}
