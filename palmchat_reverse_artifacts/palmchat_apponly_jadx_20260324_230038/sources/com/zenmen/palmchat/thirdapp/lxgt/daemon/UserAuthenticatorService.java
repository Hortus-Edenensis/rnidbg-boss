package com.zenmen.palmchat.thirdapp.lxgt.daemon;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import defpackage.c66;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class UserAuthenticatorService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f15572a = new Object();
    public static c66 b;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return b.getIBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        synchronized (f15572a) {
            if (b == null) {
                b = new c66(getApplicationContext());
            }
        }
    }
}
