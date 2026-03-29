package com.qiniu.android.utils;

import android.util.Log;
import java.util.Date;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class LogUtil {
    private static boolean enableDate = false;
    private static boolean enableFile = true;
    private static boolean enableFunction = false;
    private static boolean enableLog = false;
    private static int logLevel = 2;

    public static int d(String str) {
        return println(3, null, str, null);
    }

    public static int e(String str) {
        return println(6, null, str, null);
    }

    public static void enableDate(boolean z) {
        enableDate = z;
    }

    public static void enableFile(boolean z) {
        enableFile = z;
    }

    public static void enableFunction(boolean z) {
        enableFunction = z;
    }

    public static void enableLog(boolean z) {
        enableLog = z;
    }

    public static int i(String str) {
        return println(4, null, str, null);
    }

    private static int println(int i, String str, String str2, Throwable th) {
        if (!shouldLog(i, str, str2, th)) {
            return -10000;
        }
        if (i == 2) {
            return th == null ? Log.v(recreateLogTag(str), recreateLogMessage(str2)) : Log.v(recreateLogTag(str), recreateLogMessage(str2), th);
        }
        if (i == 3) {
            return th == null ? Log.d(recreateLogTag(str), recreateLogMessage(str2)) : Log.d(recreateLogTag(str), recreateLogMessage(str2), th);
        }
        if (i == 4) {
            return th == null ? Log.i(recreateLogTag(str), recreateLogMessage(str2)) : Log.i(recreateLogTag(str), recreateLogMessage(str2), th);
        }
        if (i == 5) {
            return th == null ? Log.w(recreateLogTag(str), recreateLogMessage(str2)) : Log.w(recreateLogTag(str), recreateLogMessage(str2), th);
        }
        if (i != 6) {
            return -10001;
        }
        return th == null ? Log.e(recreateLogTag(str), recreateLogMessage(str2)) : Log.e(recreateLogTag(str), recreateLogMessage(str2), th);
    }

    private static String recreateLogMessage(String str) {
        return str != null ? str : "";
    }

    private static String recreateLogTag(String str) {
        String str2;
        String str3;
        StackTraceElement stackTraceElement;
        String str4 = "";
        if (str != null) {
            str2 = str + ":";
        } else {
            str2 = "";
        }
        if (enableDate) {
            str3 = "" + new Date();
        } else {
            str3 = "";
        }
        Thread threadCurrentThread = Thread.currentThread();
        String str5 = StringUtils.toNonnullString(threadCurrentThread.getName()) + ":" + StringUtils.toNonnullString(Long.valueOf(threadCurrentThread.getId())) + " ";
        StackTraceElement[] stackTrace = threadCurrentThread.getStackTrace();
        if (stackTrace.length <= 5 || (stackTraceElement = stackTrace[5]) == null) {
            return str3 + "[QiNiu:" + str5 + str2 + "]";
        }
        String nonnullString = enableFile ? StringUtils.toNonnullString(stackTraceElement.getFileName()) : "";
        if (enableFunction) {
            str4 = "->" + StringUtils.toNonnullString(stackTraceElement.getMethodName());
        }
        return str3 + "[QiNiu:" + str5 + str2 + nonnullString + str4 + ("->" + stackTraceElement.getLineNumber()) + "]";
    }

    public static void setLogLevel(int i) {
        logLevel = i;
    }

    private static boolean shouldLog(int i, String str, String str2, Throwable th) {
        if (!enableLog || i < logLevel) {
            return false;
        }
        return ((str2 == null || str2.length() == 0) && th == null) ? false : true;
    }

    public static int v(String str) {
        return println(2, null, str, null);
    }

    public static int w(String str) {
        return println(5, null, str, null);
    }

    public static int d(String str, String str2) {
        return println(3, str, str2, null);
    }

    public static int e(String str, String str2) {
        return println(6, str, str2, null);
    }

    public static int i(String str, String str2) {
        return println(4, str, str2, null);
    }

    public static int v(String str, String str2) {
        return println(2, str, str2, null);
    }

    public static int w(String str, String str2) {
        return println(5, str, str2, null);
    }

    public static int d(String str, String str2, Throwable th) {
        return println(3, str, str2, th);
    }

    public static int e(String str, String str2, Throwable th) {
        return println(6, str, str2, th);
    }

    public static int i(String str, String str2, Throwable th) {
        return println(4, str, str2, th);
    }

    public static int v(String str, String str2, Throwable th) {
        return println(2, str, str2, th);
    }

    public static int w(String str, String str2, Throwable th) {
        return println(5, str, str2, th);
    }

    public static int w(String str, Throwable th) {
        return println(5, str, null, th);
    }
}
