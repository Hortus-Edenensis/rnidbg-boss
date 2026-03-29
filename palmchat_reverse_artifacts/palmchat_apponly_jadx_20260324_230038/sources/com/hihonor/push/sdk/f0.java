package com.hihonor.push.sdk;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import com.hihonor.push.framework.aidl.IPushInvoke;
import com.hihonor.push.sdk.b0;
import com.hihonor.push.sdk.bean.RemoteServiceBean;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;
import com.hihonor.push.sdk.z;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class f0 implements ServiceConnection {
    public static final Object e = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RemoteServiceBean f6447a;
    public a b;
    public Handler c = null;
    public boolean d = false;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
    }

    public f0(RemoteServiceBean remoteServiceBean) {
        this.f6447a = remoteServiceBean;
    }

    public final void a(int i) {
        a aVar = this.b;
        if (aVar != null) {
            c0 c0Var = (c0) aVar;
            c0Var.f6441a.f6443a.set(i == HonorPushErrorEnum.ERROR_SERVICE_TIME_OUT.statusCode ? 2 : 1);
            c0Var.f6441a.a(i);
            c0Var.f6441a.b = null;
        }
    }

    public void b() {
        try {
            Log.i("AIDLSrvConnection", "trying to unbind service from " + this);
            l.e.a().unbindService(this);
        } catch (Exception e2) {
            e2.getMessage();
        }
    }

    @Override // android.content.ServiceConnection
    public void onNullBinding(ComponentName componentName) {
        Log.i("AIDLSrvConnection", "enter onNullBinding, than unBind.");
        if (this.d) {
            this.d = false;
            return;
        }
        b();
        a();
        a aVar = this.b;
        if (aVar != null) {
            c0 c0Var = (c0) aVar;
            c0Var.f6441a.f6443a.set(1);
            c0Var.f6441a.a(8002005);
            c0Var.f6441a.b = null;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Log.i("AIDLSrvConnection", "enter onServiceConnected.");
        a();
        a aVar = this.b;
        if (aVar != null) {
            c0 c0Var = (c0) aVar;
            c0Var.f6441a.b = IPushInvoke.Stub.asInterface(iBinder);
            if (c0Var.f6441a.b == null) {
                c0Var.f6441a.d.b();
                c0Var.f6441a.f6443a.set(1);
                c0Var.f6441a.a(8002001);
                return;
            }
            c0Var.f6441a.f6443a.set(3);
            b0.a aVar2 = c0Var.f6441a.c;
            if (aVar2 != null) {
                z.a aVar3 = (z.a) aVar2;
                if (Looper.myLooper() == z.this.f6487a.getLooper()) {
                    aVar3.b();
                } else {
                    z.this.f6487a.post(new x(aVar3));
                }
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Log.i("AIDLSrvConnection", "enter onServiceDisconnected.");
        a aVar = this.b;
        if (aVar != null) {
            c0 c0Var = (c0) aVar;
            c0Var.f6441a.f6443a.set(1);
            c0Var.f6441a.a(8002002);
            c0Var.f6441a.b = null;
        }
    }

    public final void a() {
        synchronized (e) {
            Handler handler = this.c;
            if (handler != null) {
                handler.removeMessages(1001);
                this.c = null;
            }
        }
    }
}
