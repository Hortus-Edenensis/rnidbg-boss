package com.tide.protocol.util;

import android.util.Log;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class TideDebug {
    public static final String TAG_TEST_ENV = "TideEnv";
    public static final boolean TEST_ENV = isPropertyEnabled(TAG_TEST_ENV);
    public static final String TAG_TD_SDK = "TideLog";
    public static final boolean DEBUG_LOG = isPropertyEnabled(TAG_TD_SDK);

    private static boolean isPropertyEnabled(String str) {
        try {
            return Log.isLoggable(str, 2);
        } catch (Throwable unused) {
            return false;
        }
    }
}
