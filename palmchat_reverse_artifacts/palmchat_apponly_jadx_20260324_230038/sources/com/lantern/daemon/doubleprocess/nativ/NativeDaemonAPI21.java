package com.lantern.daemon.doubleprocess.nativ;

import android.content.Context;
import com.lantern.daemon.doubleprocess.NativeDaemonBase;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class NativeDaemonAPI21 extends NativeDaemonBase {
    static {
        try {
            System.loadLibrary("daemonlib");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public NativeDaemonAPI21(Context context) {
        super(context);
    }

    public native void doDaemon(String str, String str2, String str3, String str4);
}
