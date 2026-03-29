package com.lantern.daemon.dp3.account;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class AccountSyncService extends AccountSyncServiceBase {
    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.syncAdapterStub = new SyncAdapterStub(getApplicationContext());
    }
}
