package com.umeng.analytics.pro;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.umeng.analytics.pro.dx;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class bk implements be {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f10882a = "Lenovo";
    private static final String b = "com.zui.deviceidservice";
    private static final String c = "com.zui.deviceidservice.DeviceidService";
    private volatile String d = "";
    private CountDownLatch e;
    private Context f;

    @Override // com.umeng.analytics.pro.be
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        this.f = context.getApplicationContext();
        this.e = new CountDownLatch(1);
        ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.umeng.analytics.pro.bk.1
            @Override // android.content.ServiceConnection
            public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                CountDownLatch countDownLatch;
                dx dxVarA = dx.b.a(iBinder);
                if (dxVarA != null) {
                    try {
                        bk.this.d = dxVarA.a();
                        Log.d(bk.f10882a, "Service onServiceConnected oaid = " + bk.this.d);
                        countDownLatch = bk.this.e;
                    } catch (RemoteException unused) {
                        countDownLatch = bk.this.e;
                    } catch (Throwable th) {
                        bk.this.e.countDown();
                        throw th;
                    }
                    countDownLatch.countDown();
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                Log.i(bk.f10882a, "Service onServiceDisconnected");
            }
        };
        try {
            Intent intent = new Intent();
            intent.setClassName(b, c);
            this.f.bindService(intent, serviceConnection, 1);
            if (!this.e.await(500L, TimeUnit.MILLISECONDS)) {
                Log.e(f10882a, "getOAID time-out");
            }
            return this.d;
        } catch (Throwable th) {
            try {
                Log.e(f10882a, "getOAID interrupted. e=" + th.getMessage());
                return null;
            } finally {
                this.f.unbindService(serviceConnection);
            }
        }
    }
}
