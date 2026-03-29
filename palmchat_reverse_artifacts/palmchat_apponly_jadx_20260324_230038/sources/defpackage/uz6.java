package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import defpackage.qu6;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class uz6 {
    public static String d = "OpenDeviceId library";
    public static boolean e = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f21329a = null;
    public qu6 b;
    public ServiceConnection c;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            uz6.this.b = qu6.a.g(iBinder);
            uz6.c(uz6.this);
            uz6.this.g("Service onServiceConnected");
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            uz6.this.b = null;
            uz6.this.g("Service onServiceDisconnected");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b<T> {
    }

    public static /* synthetic */ b c(uz6 uz6Var) {
        uz6Var.getClass();
        return null;
    }

    public int a(Context context, b<String> bVar) {
        if (context == null) {
            throw new NullPointerException("Context can not be null.");
        }
        this.f21329a = context;
        this.c = new a();
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        if (this.f21329a.bindService(intent, this.c, 1)) {
            g("bindService Successful!");
            return 1;
        }
        g("bindService Failed!");
        return -1;
    }

    public final void e(String str) {
        if (e) {
            Log.e(d, str);
        }
    }

    public String f() {
        if (this.f21329a == null) {
            e("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        try {
            qu6 qu6Var = this.b;
            if (qu6Var != null) {
                return qu6Var.a();
            }
            return null;
        } catch (RemoteException e2) {
            e("getOAID error, RemoteException!");
            e2.printStackTrace();
            return null;
        }
    }

    public final void g(String str) {
        if (e) {
            Log.i(d, str);
        }
    }

    public boolean h() {
        try {
            if (this.b == null) {
                return false;
            }
            g("Device support opendeviceid");
            return this.b.c();
        } catch (RemoteException unused) {
            e("isSupport error, RemoteException!");
            return false;
        }
    }
}
