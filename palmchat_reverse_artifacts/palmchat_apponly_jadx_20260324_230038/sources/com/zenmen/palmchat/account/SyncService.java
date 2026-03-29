package com.zenmen.palmchat.account;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import defpackage.aq5;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class SyncService extends Service {
    public static final Object b = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public aq5 f12182a = null;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f12182a.getSyncAdapterBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        synchronized (b) {
            if (this.f12182a == null) {
                this.f12182a = new aq5(getApplicationContext(), true);
            }
        }
    }
}
