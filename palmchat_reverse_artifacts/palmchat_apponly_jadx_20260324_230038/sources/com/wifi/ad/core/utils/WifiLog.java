package com.wifi.ad.core.utils;

import android.util.Log;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class WifiLog {
    public static final int LEVEL_DEBUG = 4;
    public static final int LEVEL_ERROR = 1;
    public static final int LEVEL_INFO = 3;
    public static final int LEVEL_NONE = 0;
    public static final int LEVEL_VERBOSE = 5;
    public static final int LEVEL_WARN = 2;
    public static boolean isDebugMode = false;
    public static int mDebuggable = 5;
    private static String mTag = "wifiNestAd";

    public static void d(String str) {
        if (!isDebugMode || mDebuggable < 4) {
            return;
        }
        Log.d(mTag, str);
    }

    public static void e(String str) {
        if (!isDebugMode || mDebuggable < 1) {
            return;
        }
        Log.e(mTag, str);
    }

    public static void i(String str) {
        if (!isDebugMode || mDebuggable < 3) {
            return;
        }
        Log.i(mTag, str);
    }

    public static void setDebugMode(boolean z) {
        isDebugMode = z;
    }

    public static void v(String str) {
        if (!isDebugMode || mDebuggable < 5) {
            return;
        }
        Log.v(mTag, str);
    }

    public static void w(String str) {
        if (!isDebugMode || mDebuggable < 2) {
            return;
        }
        Log.w(mTag, str);
    }

    public static void e(Throwable th) {
        if (!isDebugMode || mDebuggable < 1) {
            return;
        }
        Log.e(mTag, "", th);
    }

    public static void w(Throwable th) {
        if (!isDebugMode || mDebuggable < 2) {
            return;
        }
        Log.w(mTag, "", th);
    }

    public static void e(String str, Throwable th) {
        if (!isDebugMode || mDebuggable < 1 || str == null) {
            return;
        }
        Log.e(mTag, str, th);
    }

    public static void w(String str, Throwable th) {
        if (!isDebugMode || mDebuggable < 2 || str == null) {
            return;
        }
        Log.w(mTag, str, th);
    }
}
