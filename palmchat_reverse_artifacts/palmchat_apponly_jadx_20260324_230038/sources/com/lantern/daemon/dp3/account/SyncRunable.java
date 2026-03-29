package com.lantern.daemon.dp3.account;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class SyncRunable implements Runnable {
    public final SyncAdapterStub syncAdapterStub;

    public SyncRunable(SyncAdapterStub syncAdapterStub) {
        this.syncAdapterStub = syncAdapterStub;
    }

    @Override // java.lang.Runnable
    public void run() {
        SyncAdapterStub.onPeriodicStart(this.syncAdapterStub);
    }
}
