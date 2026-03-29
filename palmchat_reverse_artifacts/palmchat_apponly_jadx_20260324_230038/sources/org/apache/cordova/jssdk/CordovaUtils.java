package org.apache.cordova.jssdk;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import defpackage.wa3;
import java.util.Iterator;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.PluginResult;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class CordovaUtils {
    public static void doStartActivity(Intent intent, CallbackContext callbackContext, CordovaInterface cordovaInterface) {
        try {
            cordovaInterface.getActivity().startActivity(intent);
            callbackContext.success();
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            callbackContext.error(e.toString());
        }
    }

    public static Bundle jsonToBundle(JSONObject jSONObject) {
        Bundle bundle = new Bundle();
        if (jSONObject != null) {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object objOpt = jSONObject.opt(next);
                if (objOpt instanceof String) {
                    bundle.putString(next, (String) objOpt);
                } else if (objOpt instanceof Integer) {
                    bundle.putInt(next, ((Integer) objOpt).intValue());
                } else if (objOpt instanceof Long) {
                    bundle.putLong(next, ((Long) objOpt).longValue());
                } else if (objOpt instanceof Float) {
                    bundle.putFloat(next, ((Float) objOpt).floatValue());
                } else if (objOpt instanceof Double) {
                    bundle.putDouble(next, ((Double) objOpt).doubleValue());
                } else if (objOpt instanceof Boolean) {
                    bundle.putBoolean(next, ((Boolean) objOpt).booleanValue());
                } else if (objOpt instanceof Character) {
                    bundle.putChar(next, ((Character) objOpt).charValue());
                }
            }
        }
        return bundle;
    }

    public static JSONObject makeNormalJsResult(PluginResult.Status status) {
        return wa3.b(status.ordinal() + "", PluginResult.StatusMessages[status.ordinal()]);
    }

    public static String removeQuotation(String str) {
        return (!TextUtils.isEmpty(str) && str.startsWith("\"") && str.endsWith("\"")) ? str.substring(1, str.length() - 1) : str;
    }
}
