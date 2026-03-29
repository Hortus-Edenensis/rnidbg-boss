package com.zenmen.palmchat.thirdapp.lxgt.daemon;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.igexin.sdk.GTServiceManager;
import defpackage.n52;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class LXGTService extends Service {
    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        GTServiceManager.getInstance().onServiceCreate(this, intent);
        n52.d("newService");
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        GTServiceManager.getInstance().onServiceCreate(this, intent);
        n52.d("newService");
        return 2;
    }
}
