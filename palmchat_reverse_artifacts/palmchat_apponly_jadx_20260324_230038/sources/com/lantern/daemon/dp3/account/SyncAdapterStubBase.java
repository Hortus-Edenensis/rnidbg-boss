package com.lantern.daemon.dp3.account;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import defpackage.ap2;
import defpackage.yo2;
import defpackage.zo2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public abstract class SyncAdapterStubBase extends yo2.a {
    public abstract /* synthetic */ void cancelSync(ap2 ap2Var) throws RemoteException;

    public final IBinder getSyncAdapterBinder() {
        return asBinder();
    }

    public abstract /* synthetic */ void onUnsyncableAccount(zo2 zo2Var) throws RemoteException;

    public abstract /* synthetic */ void startSync(ap2 ap2Var, String str, Account account, Bundle bundle) throws RemoteException;
}
