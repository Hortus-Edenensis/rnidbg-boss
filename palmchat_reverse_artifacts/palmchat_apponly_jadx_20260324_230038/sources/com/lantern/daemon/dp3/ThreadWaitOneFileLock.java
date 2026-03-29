package com.lantern.daemon.dp3;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class ThreadWaitOneFileLock extends Thread {
    public final DaemonEntry entry;
    public final int index;

    public ThreadWaitOneFileLock(DaemonEntry daemonEntry, int i) {
        this.entry = daemonEntry;
        this.index = i;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        setPriority(10);
        DaemonNative.naWaitOneFileLock(this.entry.param.files[this.index]);
        this.entry.startInstrumentationByAmsBinder();
        this.entry.startServiceByAmsBinder();
        this.entry.startByAmsBinder();
    }
}
