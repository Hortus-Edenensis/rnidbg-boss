package com.lantern.daemon.dp3;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import com.lantern.daemon.dp3.utils.BroadcastReceiverA;
import com.lantern.daemon.dp3.utils.BroadcastReceiverF;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class Assist1ProcessService extends Service {
    private Binder binder = new LocalBinder();

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.binder;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        BroadcastReceiverA.send(this, getPackageName(), Assist1ProcessService.class.getName());
        BroadcastReceiverF.register(this, new Assist1FA(this));
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return 2;
    }
}
