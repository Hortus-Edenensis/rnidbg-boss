package com.lantern.daemon.dp3.account;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class AccountSyncServiceBase extends Service {
    public SyncAdapterStubBase syncAdapterStub;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        SyncAdapterStubBase syncAdapterStubBase = this.syncAdapterStub;
        if (syncAdapterStubBase == null) {
            return null;
        }
        return syncAdapterStubBase.getSyncAdapterBinder();
    }
}
