package com.lantern.daemon.sync;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import defpackage.vm;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class AuthenticatorService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public vm f7540a;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f7540a.getIBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        this.f7540a = new vm(this);
    }
}
