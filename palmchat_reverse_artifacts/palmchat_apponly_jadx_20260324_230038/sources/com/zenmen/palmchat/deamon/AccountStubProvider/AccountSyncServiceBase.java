package com.zenmen.palmchat.deamon.AccountStubProvider;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import defpackage.dq5;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class AccountSyncServiceBase extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public dq5 f13919a;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        dq5 dq5Var = this.f13919a;
        if (dq5Var == null) {
            return null;
        }
        return dq5Var.getSyncAdapterBinder();
    }
}
