package com.zenmen.palmchat.deamon.AccountStubProvider;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import defpackage.um;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class AccountAuthenticatorService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public um f13918a;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f13918a.getIBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f13918a = new um(getApplicationContext());
    }
}
