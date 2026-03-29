package org.apache.webplatform.jssdk;

import android.util.Log;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.zn6;
import org.apache.cordovaNew.CallbackContext;
import org.apache.cordovaNew.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class LogPlugin extends CordovaPlugin {
    private static String TAG = "LogPlugin";

    /* JADX WARN: Removed duplicated region for block: B:27:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0046 A[PHI: r2
      0x0046: PHI (r2v7 com.zenmen.palmchat.utils.log.LogUtil$LogType) = 
      (r2v2 com.zenmen.palmchat.utils.log.LogUtil$LogType)
      (r2v3 com.zenmen.palmchat.utils.log.LogUtil$LogType)
      (r2v4 com.zenmen.palmchat.utils.log.LogUtil$LogType)
      (r2v5 com.zenmen.palmchat.utils.log.LogUtil$LogType)
      (r2v6 com.zenmen.palmchat.utils.log.LogUtil$LogType)
     binds: [B:8:0x0044, B:11:0x004c, B:14:0x0053, B:17:0x005a, B:20:0x0061] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // org.apache.cordovaNew.CordovaPlugin
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean execute(String str, JSONArray jSONArray, CallbackContext callbackContext) throws JSONException {
        LogUtil.LogType logType;
        Log.i(TAG, str + "-" + jSONArray.toString());
        if (str.equals("commonLog")) {
            int i = jSONArray.getInt(0);
            String string = jSONArray.getString(1);
            String string2 = jSONArray.getString(2);
            int i2 = jSONArray.getInt(3);
            LogUtil.LogType logType2 = LogUtil.LogType.LOG_TYPE_USER_ACTION;
            if (i != logType2.value) {
                LogUtil.LogType logType3 = LogUtil.LogType.LOG_TYPE_BACKGROUP;
                if (i == logType3.value) {
                    logType2 = logType3;
                } else {
                    logType3 = LogUtil.LogType.LOG_TYPE_USER_ACTION_IMMEDIATE;
                    if (i != logType3.value) {
                        logType3 = LogUtil.LogType.LOG_TYPE_QA_NORMAL;
                        if (i != logType3.value) {
                            logType3 = LogUtil.LogType.LOG_TYPE_QA_IMPORTANT;
                            if (i != logType3.value) {
                                logType3 = LogUtil.LogType.LOG_TYPE_QA_SOCKET;
                                if (i == logType3.value) {
                                }
                            }
                        }
                    }
                }
            }
            LogUtil.i(string, string2, (Throwable) null, logType2, i2);
        } else if (str.equals("actionLog")) {
            int iOptInt = jSONArray.optInt(0);
            String strOptString = jSONArray.optString(1);
            String strOptString2 = jSONArray.optString(2);
            String strOptString3 = jSONArray.optString(3);
            String strOptString4 = jSONArray.optString(4);
            String strOptString5 = jSONArray.optString(5);
            LogUtil.LogType logType4 = LogUtil.LogType.LOG_TYPE_USER_ACTION;
            if (iOptInt == logType4.value) {
                logType = logType4;
                LogUtil.onEvent(logType, strOptString, strOptString2, strOptString3, strOptString4, strOptString5);
            } else {
                LogUtil.LogType logType5 = LogUtil.LogType.LOG_TYPE_BACKGROUP;
                if (iOptInt != logType5.value) {
                    logType5 = LogUtil.LogType.LOG_TYPE_USER_ACTION_IMMEDIATE;
                    if (iOptInt != logType5.value) {
                        logType5 = LogUtil.LogType.LOG_TYPE_QA_NORMAL;
                        if (iOptInt != logType5.value) {
                            logType5 = LogUtil.LogType.LOG_TYPE_QA_IMPORTANT;
                            if (iOptInt != logType5.value) {
                                logType5 = LogUtil.LogType.LOG_TYPE_QA_SOCKET;
                                if (iOptInt == logType5.value) {
                                }
                                LogUtil.onEvent(logType, strOptString, strOptString2, strOptString3, strOptString4, strOptString5);
                            }
                        }
                    }
                }
                logType = logType5;
                LogUtil.onEvent(logType, strOptString, strOptString2, strOptString3, strOptString4, strOptString5);
            }
        } else if (str.equals("wkLog")) {
            zn6.e(jSONArray.optString(0), jSONArray.optString(1), jSONArray.optString(2), jSONArray.optString(3));
        }
        return true;
    }
}
