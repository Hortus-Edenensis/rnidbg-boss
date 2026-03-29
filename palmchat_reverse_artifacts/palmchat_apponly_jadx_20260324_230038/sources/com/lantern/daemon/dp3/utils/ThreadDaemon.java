package com.lantern.daemon.dp3.utils;

import android.content.Context;
import com.lantern.daemon.dp3.DaemonEntry;
import com.lantern.daemon.dp3.DaemonHelper;
import com.lantern.daemon.dp3.ProcessUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class ThreadDaemon extends Thread {
    public final Context context;
    public final String[] files;

    public ThreadDaemon(Context context, String[] strArr) {
        this.context = context;
        this.files = strArr;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        setPriority(10);
        try {
            DaemonHelper.DaemonParams daemonParams = DaemonHelper.instance().getDaemonParams();
            EntryParam entryParam = new EntryParam();
            entryParam.files = this.files;
            entryParam.broadcastIntent = daemonParams.broadcastIntent;
            entryParam.instrumentationIntent = daemonParams.instrumentationIntent;
            entryParam.serviceIntent = daemonParams.serviceIntent;
            entryParam.processName = ProcessUtils.processName();
            DaemonEntry.main(new String[]{entryParam.toString()});
        } catch (Exception unused) {
        }
        Utils.setDaemonStarted(false);
    }
}
