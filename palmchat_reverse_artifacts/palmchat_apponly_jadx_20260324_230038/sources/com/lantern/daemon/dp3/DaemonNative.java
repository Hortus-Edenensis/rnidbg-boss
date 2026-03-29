package com.lantern.daemon.dp3;

import android.util.Log;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class DaemonNative {
    static {
        try {
            System.loadLibrary("core_daemon");
        } catch (Exception unused) {
            Log.e("daemon", "static initializer: ");
        }
    }

    public static final native int naHoldFileLock(String str);

    public static final native int naSetSid();

    public static final native int naWaitOneFileLock(String str);
}
