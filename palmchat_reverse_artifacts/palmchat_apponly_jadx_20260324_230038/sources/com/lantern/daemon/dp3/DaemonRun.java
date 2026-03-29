package com.lantern.daemon.dp3;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class DaemonRun implements Runnable {
    public final DaemonProcessService service;

    public DaemonRun(DaemonProcessService daemonProcessService) {
        this.service = daemonProcessService;
    }

    @Override // java.lang.Runnable
    public void run() {
        DaemonProcessService.send(this.service);
    }
}
