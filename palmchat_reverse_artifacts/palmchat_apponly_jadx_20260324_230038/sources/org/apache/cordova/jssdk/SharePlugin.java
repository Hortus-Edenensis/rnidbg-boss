package org.apache.cordova.jssdk;

import android.content.Intent;
import android.util.Log;
import com.zenmen.palmchat.publish.PublishActivity;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class SharePlugin extends CordovaPlugin {
    private static final String ACTION_SHARE_WEB_MOMENT = "shareWebLinkToMoments";
    private static final String TAG = "SharePlugin";
    private CallbackContext mCallbackContext;

    private void shareWebMoment(JSONArray jSONArray) {
        String strOptString = jSONArray.optString(0);
        String strOptString2 = jSONArray.optString(1);
        String strOptString3 = jSONArray.optString(2);
        Intent intent = new Intent(this.cordova.getActivity(), (Class<?>) PublishActivity.class);
        intent.putExtra("key_from", 50);
        intent.putExtra("key_publish_type", 4);
        intent.putExtra("key_publish_subject", strOptString);
        intent.putExtra("key_publish_url", strOptString3);
        intent.putExtra("key_publish_shortcut_icon", strOptString2);
        this.cordova.getActivity().startActivity(intent);
        this.mCallbackContext.success();
    }

    @Override // org.apache.cordova.CordovaPlugin
    public boolean execute(String str, JSONArray jSONArray, CallbackContext callbackContext) throws JSONException {
        Log.i(TAG, str + "-" + jSONArray.toString());
        this.mCallbackContext = callbackContext;
        if (!ACTION_SHARE_WEB_MOMENT.equals(str)) {
            return false;
        }
        shareWebMoment(jSONArray);
        return true;
    }
}
