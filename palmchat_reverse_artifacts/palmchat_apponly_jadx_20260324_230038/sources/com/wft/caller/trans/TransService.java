package com.wft.caller.trans;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import defpackage.c27;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class TransService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c27 f11329a;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f11329a = new c27(this);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        try {
            String stringExtra = intent.getStringExtra("from_packageName");
            Intent intent2 = new Intent();
            intent2.setAction("action.wfc.lifecycle");
            intent2.putExtra("from_packageName", stringExtra);
            sendBroadcast(intent2);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
    }
}
