package org.apache.webplatform.jssdk;

import android.text.TextUtils;
import com.umeng.analytics.pro.bd;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.ap3;
import org.apache.cordovaNew.CallbackContext;
import org.apache.cordovaNew.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class LxChatPlugin extends CordovaPlugin {
    @Override // org.apache.cordovaNew.CordovaPlugin
    public boolean execute(String str, JSONArray jSONArray, CallbackContext callbackContext) throws JSONException {
        if (!TextUtils.equals(str, "jumpToPrivateChatPage")) {
            return super.execute(str, jSONArray, callbackContext);
        }
        LogUtil.d("test_tag", "data:" + jSONArray.toString());
        JSONObject jSONObject = jSONArray.getJSONObject(0);
        if (jSONObject == null) {
            return true;
        }
        String strOptString = jSONObject.optString(bd.h);
        int iOptInt = jSONObject.optInt("fromType");
        if (iOptInt == 3) {
            ap3.k(this.cordova.getActivity(), strOptString, 66);
            return true;
        }
        if (iOptInt != 2) {
            return true;
        }
        ap3.k(this.cordova.getActivity(), strOptString, 67);
        return true;
    }
}
