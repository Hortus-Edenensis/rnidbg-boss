package com.tide.protocol.util;

import android.text.TextUtils;
import android.util.Log;
import java.util.logging.Level;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class TdLogUtils {
    private static boolean IS_LOG = false;
    private static final String LOG = "TD-LOG";

    public static void error(String str) {
        if (!isOpenLog() || TextUtils.isEmpty(str)) {
            return;
        }
        Log.e(LOG, str);
    }

    private static boolean isOpenLog() {
        return IS_LOG || TideDebug.DEBUG_LOG;
    }

    public static void log(Level level, String str, Throwable th) {
        if (!isOpenLog() || TextUtils.isEmpty(str)) {
            return;
        }
        Log.e(LOG, str);
    }

    private static void logDefault(String str, String str2) {
        if (!isOpenLog() || TextUtils.isEmpty(str2)) {
            return;
        }
        Log.d(str, str2);
    }

    private static String mergeTag(String str) {
        return "TD-LOG_" + str;
    }

    public static void w(String str) {
        if (!isOpenLog() || TextUtils.isEmpty(str)) {
            return;
        }
        Log.w(LOG, str);
    }

    public static void error(String str, String str2) {
        if (!isOpenLog() || TextUtils.isEmpty(str2)) {
            return;
        }
        Log.e(mergeTag(str), str2);
    }

    public static void log(String str, String str2) {
        if (!isOpenLog() || TextUtils.isEmpty(str2)) {
            return;
        }
        logDefault(mergeTag(str), str2);
    }
}
