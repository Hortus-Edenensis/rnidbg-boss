package org.apache.cordova.jssdk;

import android.net.Uri;
import android.util.Log;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.widget.advertisement.WebBanner;
import defpackage.t56;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class AdBannerPlugin extends CordovaPlugin {
    private static String TAG = "AdBannerPlugin";

    @Override // org.apache.cordova.CordovaPlugin
    public boolean execute(String str, JSONArray jSONArray, CallbackContext callbackContext) throws JSONException {
        CordovaWebView cordovaWebView;
        Log.i(TAG, str + "-" + jSONArray.toString());
        if (str.equals("getScreen")) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("widthPixels", AppContext.getContext().getResources().getDisplayMetrics().widthPixels);
            jSONObject.put("heightPixels", AppContext.getContext().getResources().getDisplayMetrics().heightPixels);
            callbackContext.success(jSONObject);
            return true;
        }
        if (!str.equals("setWebViewHeight")) {
            if (!str.equals("actionUrl")) {
                return false;
            }
            t56.a(this.cordova.getOwnerActivity2(), Uri.parse(jSONArray.getString(0)));
            return true;
        }
        int i = (int) Float.parseFloat(jSONArray.getString(0));
        if (i > 0 && (cordovaWebView = this.webView) != null && (cordovaWebView.getParent() instanceof WebBanner)) {
            ((WebBanner) this.webView.getParent()).setHeight(i);
        }
        return true;
    }
}
