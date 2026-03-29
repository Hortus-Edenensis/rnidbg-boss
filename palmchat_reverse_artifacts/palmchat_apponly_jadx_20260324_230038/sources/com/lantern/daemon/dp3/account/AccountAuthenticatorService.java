package com.lantern.daemon.dp3.account;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class AccountAuthenticatorService extends Service {
    public Authenticator authenticator;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.authenticator.getIBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.authenticator = new Authenticator(getApplicationContext());
    }
}
