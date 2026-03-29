package com.lantern.daemon;

import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.huawei.openalliance.ad.constant.az;
import com.lantern.daemon.a;
import defpackage.c84;
import defpackage.pt0;
import defpackage.x02;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class PersistentService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a.AbstractBinderC0642a f7530a = new a();

    public final void a() {
        String str = pt0.f20091a;
        String str2 = Build.MANUFACTURER;
        int i = Build.VERSION.SDK_INT;
        Log.i(str, String.format("loadConf: %s, %d", str2, Integer.valueOf(i)));
        if (!str2.equalsIgnoreCase("huawei") || i < 28) {
            c84.a(this);
        }
        x02.a(this, 1);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f7530a;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        a();
    }

    @Override // android.app.Service
    public void onDestroy() {
        try {
            c84.b(this);
        } catch (Exception unused) {
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        pt0.b(intent == null ? "service" : intent.hasExtra(az.at) ? intent.getStringExtra(az.at) : "persistent");
        return super.onStartCommand(intent, i, i2);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a extends a.AbstractBinderC0642a {
        public a() {
        }

        @Override // com.lantern.daemon.a
        public void y() throws RemoteException {
        }
    }
}
