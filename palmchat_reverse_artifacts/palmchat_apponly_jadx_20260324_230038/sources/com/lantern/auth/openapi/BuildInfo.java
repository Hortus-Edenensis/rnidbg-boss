package com.lantern.auth.openapi;

import com.lantern.auth.core.BLLog;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class BuildInfo {
    public static final String VERSION = "V_I20230223";
    private static boolean isDebuggable = false;

    public static boolean getDebuggable() {
        return isDebuggable;
    }

    public static void setDebuggable(boolean z) {
        isDebuggable = z;
    }

    public static void setLogEnable(boolean z) {
        if (z) {
            BLLog.mLevel = 0;
        } else {
            BLLog.mLevel = 5;
        }
    }
}
