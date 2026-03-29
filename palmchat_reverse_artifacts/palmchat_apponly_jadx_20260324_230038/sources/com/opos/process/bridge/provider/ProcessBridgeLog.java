package com.opos.process.bridge.provider;

import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ProcessBridgeLog {
    private static final int MAX_LENGTH = 1100;
    private static final String TAG = "ProcessBridge";
    private static IProcessBridgeLog iLog;

    public static void d(String str, String str2) {
        log(3, str, str2, null);
    }

    public static void e(String str, String str2) {
        log(6, str, str2, null);
    }

    private static String getTagMessage(String str, String str2) {
        return "[" + str + "]:" + str2;
    }

    public static void i(String str, String str2) {
        log(4, str, str2, null);
    }

    private static void log(int i, String str, String str2, Throwable th) {
        if (iLog == null || TextUtils.isEmpty(str2)) {
            return;
        }
        String tagMessage = getTagMessage(str, str2);
        if (th != null) {
            tagMessage = tagMessage + '\n' + Log.getStackTraceString(th);
        }
        int length = tagMessage.length();
        int i2 = length / 1100;
        if (i2 <= 0) {
            iLog.println(i, TAG, tagMessage);
            return;
        }
        int i3 = 1100;
        iLog.println(i, TAG, tagMessage.substring(0, 1100));
        int i4 = 1;
        while (i4 < i2) {
            int i5 = i3 + 1100;
            iLog.println(i, TAG, tagMessage.substring(i3, i5));
            i4++;
            i3 = i5;
        }
        if (i3 != length) {
            iLog.println(i, TAG, tagMessage.substring(i3, length));
        }
    }

    public static void setLog(IProcessBridgeLog iProcessBridgeLog) {
        iLog = iProcessBridgeLog;
    }

    public static void v(String str, String str2) {
        log(2, str, str2, null);
    }

    public static void w(String str, String str2) {
        log(5, str, str2, null);
    }

    public static void d(String str, String str2, Throwable th) {
        log(3, str, str2, th);
    }

    public static void e(String str, String str2, Throwable th) {
        log(6, str, str2, th);
    }

    public static void i(String str, String str2, Throwable th) {
        log(4, str, str2, th);
    }

    public static void v(String str, String str2, Throwable th) {
        log(2, str, str2, th);
    }

    public static void w(String str, String str2, Throwable th) {
        log(5, str, str2, th);
    }
}
