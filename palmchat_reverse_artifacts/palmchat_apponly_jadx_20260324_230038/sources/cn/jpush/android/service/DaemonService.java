package cn.jpush.android.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import defpackage.p63;
import defpackage.vx2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class DaemonService extends Service {
    private static final String TAG = "DaemonService";

    /* JADX INFO: compiled from: SearchBox */
    public class MyBinder extends Binder {
        public MyBinder() {
        }

        public DaemonService getService() {
            return DaemonService.this;
        }
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        vx2.b(getApplicationContext(), intent != null ? intent.getExtras() : null, 2);
        return new MyBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        p63.a(TAG, "action onCreate");
    }

    @Override // android.app.Service
    public void onDestroy() {
        p63.a(TAG, "action onDestroy");
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        vx2.b(getApplicationContext(), intent != null ? intent.getExtras() : null, 1);
        return super.onStartCommand(intent, i, i2);
    }
}
