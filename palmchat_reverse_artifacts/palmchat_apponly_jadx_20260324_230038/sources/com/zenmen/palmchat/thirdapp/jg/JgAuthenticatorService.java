package com.zenmen.palmchat.thirdapp.jg;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import defpackage.by2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class JgAuthenticatorService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f15571a = new Object();
    public static by2 b;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return b.getIBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        synchronized (f15571a) {
            if (b == null) {
                b = new by2(getApplicationContext());
            }
        }
    }
}
