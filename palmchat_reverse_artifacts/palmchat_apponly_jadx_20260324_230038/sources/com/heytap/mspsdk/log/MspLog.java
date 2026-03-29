package com.heytap.mspsdk.log;

import android.util.Log;
import com.heytap.mspsdk.util.e;
import com.huawei.hms.ads.ex;
import com.igexin.push.core.b;
import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class MspLog {
    private static boolean IS_SYS_OPEN = false;
    private static final String TAG = "MSP-LOG-SDK-";
    private static DefaultLog defaultLog = new DefaultLog();
    private static boolean isDebug = false;

    /* JADX INFO: compiled from: SearchBox */
    public interface LogInfoCallBack {
        String toLogStr();
    }

    static {
        init();
    }

    public static void d(String str, LogInfoCallBack logInfoCallBack) {
        if (getDebug()) {
            defaultLog.d(TAG + str, logInfoCallBack == null ? b.m : logInfoCallBack.toLogStr());
        }
    }

    public static void e(String str, String str2) {
        defaultLog.e(TAG + str, str2);
    }

    public static boolean getDebug() {
        return isDebug || IS_SYS_OPEN;
    }

    public static String getStackTrace(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        try {
            th.printStackTrace(printWriter);
            return stringWriter.toString();
        } finally {
            printWriter.close();
        }
    }

    public static void i(String str, String str2) {
        if (getDebug()) {
            defaultLog.i(TAG + str, str2);
        }
    }

    public static void iIgnore(String str, String str2) {
        defaultLog.i(TAG + str, str2);
    }

    public static void init() {
        boolean z = Boolean.parseBoolean(e.a("persist.sys.assert.panic", ex.V));
        boolean z2 = Boolean.parseBoolean(e.a("persist.sys.assert.enable", ex.V));
        if (z || z2) {
            IS_SYS_OPEN = true;
        }
        iIgnore(TAG, "isDebug=" + isDebug + " ,IS_SYSOPEN=" + IS_SYS_OPEN);
    }

    public static void setDebug(boolean z) {
        iIgnore(TAG, "setDebug, isDebug=" + z);
        isDebug = z;
    }

    public static void v(String str, String str2) {
        if (getDebug()) {
            defaultLog.v(TAG + str, str2);
        }
    }

    public static void w(String str, String str2) {
        if (getDebug()) {
            defaultLog.w(TAG + str, str2);
        }
    }

    public static void d(String str, String str2) {
        if (getDebug()) {
            defaultLog.d(TAG + str, str2);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        defaultLog.e(TAG + str, str2, th);
    }

    public static void i(String str, Throwable th) {
        defaultLog.i(TAG + str, getStackTrace(th));
    }

    public static void w(String str, Throwable th) {
        defaultLog.w(TAG + str, getStackTrace(th));
    }

    public static void e(String str, Throwable th) {
        defaultLog.e(TAG + str, getStackTrace(th));
    }

    public static void e(Throwable th) {
        Log.e(TAG, getStackTrace(th));
    }
}
