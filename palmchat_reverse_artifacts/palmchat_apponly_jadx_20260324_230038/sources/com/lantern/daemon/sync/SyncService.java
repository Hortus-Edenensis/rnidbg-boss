package com.lantern.daemon.sync;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import defpackage.bq5;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class SyncService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static bq5 f7541a;
    public static final Object b = new Object();

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return f7541a.getSyncAdapterBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        synchronized (b) {
            if (f7541a == null) {
                f7541a = new bq5(getApplicationContext(), true);
            }
        }
    }
}
