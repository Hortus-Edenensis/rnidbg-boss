package com.beizi.fusion.sm.b.a;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class m implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f4687a;
    private final com.beizi.fusion.sm.b.b b;
    private final a c;

    /* JADX INFO: compiled from: SearchBox */
    @FunctionalInterface
    public interface a {
        String a(IBinder iBinder) throws com.beizi.fusion.sm.b.d, RemoteException;
    }

    private m(Context context, com.beizi.fusion.sm.b.b bVar, a aVar) {
        if (context instanceof Application) {
            this.f4687a = context;
        } else {
            this.f4687a = context.getApplicationContext();
        }
        this.b = bVar;
        this.c = aVar;
    }

    public static void a(Context context, Intent intent, com.beizi.fusion.sm.b.b bVar, a aVar) {
        new m(context, bVar, aVar).a(intent);
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        com.beizi.fusion.sm.b.e.a("Service has been connected: " + componentName.getClassName());
        try {
            try {
                try {
                    String strA = this.c.a(iBinder);
                    if (strA == null || strA.length() == 0) {
                        throw new com.beizi.fusion.sm.b.d("OAID acquire failed");
                    }
                    com.beizi.fusion.sm.b.e.a("OAID acquire success: " + strA);
                    this.b.a(strA);
                    this.f4687a.unbindService(this);
                    com.beizi.fusion.sm.b.e.a("Service has been unbound: " + componentName.getClassName());
                } catch (Exception e) {
                    com.beizi.fusion.sm.b.e.a(e);
                }
            } catch (Exception e2) {
                com.beizi.fusion.sm.b.e.a(e2);
                this.b.a(e2);
                this.f4687a.unbindService(this);
                com.beizi.fusion.sm.b.e.a("Service has been unbound: " + componentName.getClassName());
            }
        } catch (Throwable th) {
            try {
                this.f4687a.unbindService(this);
                com.beizi.fusion.sm.b.e.a("Service has been unbound: " + componentName.getClassName());
            } catch (Exception e3) {
                com.beizi.fusion.sm.b.e.a(e3);
            }
            throw th;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        com.beizi.fusion.sm.b.e.a("Service has been disconnected: " + componentName.getClassName());
    }

    private void a(Intent intent) {
        try {
            if (!this.f4687a.bindService(intent, this, 1)) {
                throw new com.beizi.fusion.sm.b.d("Service binding failed");
            }
            com.beizi.fusion.sm.b.e.a("Service has been bound: " + intent);
        } catch (Exception e) {
            this.b.a(e);
        }
    }
}
