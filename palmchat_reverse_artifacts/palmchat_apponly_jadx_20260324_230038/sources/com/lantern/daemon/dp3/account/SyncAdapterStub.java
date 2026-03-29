package com.lantern.daemon.dp3.account;

import android.accounts.Account;
import android.content.Context;
import android.content.SyncResult;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.util.Log;
import defpackage.ap2;
import defpackage.zo2;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class SyncAdapterStub extends SyncAdapterStubBase {
    public Context context;

    public SyncAdapterStub(Context context) {
        this.context = context;
    }

    public static void onPeriodicStart(SyncAdapterStub syncAdapterStub) {
        syncAdapterStub.onPeriodicStart();
    }

    @Override // com.lantern.daemon.dp3.account.SyncAdapterStubBase, defpackage.yo2
    public void cancelSync(ap2 ap2Var) {
        AccountSync.getInstance().requestSync(true);
    }

    public final void onManualStart() {
        synchronized (this) {
            new HashMap().put("type", "account_manual_start");
        }
    }

    @Override // com.lantern.daemon.dp3.account.SyncAdapterStubBase, defpackage.yo2
    public void onUnsyncableAccount(zo2 zo2Var) throws RemoteException {
        try {
            zo2Var.c(true);
        } catch (Throwable th) {
            Log.i("SyncAdapterStub", "throwable", th);
        }
    }

    @Override // com.lantern.daemon.dp3.account.SyncAdapterStubBase, defpackage.yo2
    public void startSync(ap2 ap2Var, String str, Account account, Bundle bundle) throws RemoteException {
        if (bundle != null) {
            try {
                if (bundle.getBoolean("force", false)) {
                    if (bundle.getBoolean("ignore_backoff", false)) {
                        ap2Var.a(SyncResult.ALREADY_IN_PROGRESS);
                    } else {
                        ap2Var.a(new SyncResult());
                        AccountSync.getInstance().requestSync(true);
                    }
                    onManualStart();
                    return;
                }
            } catch (Throwable th) {
                Log.i("SyncAdapterStub", "throwable", th);
                return;
            }
        }
        new Handler(this.context.getMainLooper()).postDelayed(new SyncRunable(this), 5000L);
        ap2Var.a(new SyncResult());
    }

    public final void onPeriodicStart() {
        synchronized (this) {
            new HashMap().put("type", "account_periodic_start");
        }
    }
}
