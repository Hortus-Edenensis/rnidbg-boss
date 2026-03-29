package com.bytedance.sdk.openadsdk.core.multipro.aidl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.jk;
import com.bytedance.sdk.openadsdk.core.multipro.aidl.u.b;
import com.bytedance.sdk.openadsdk.core.multipro.aidl.u.fx;
import com.bytedance.sdk.openadsdk.core.multipro.aidl.u.iz;
import com.bytedance.sdk.openadsdk.core.multipro.aidl.u.nr;
import com.bytedance.sdk.openadsdk.core.multipro.aidl.u.pn;
import com.bytedance.sdk.openadsdk.core.multipro.aidl.u.x;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private static volatile u fx;
    private CountDownLatch b;
    private jk nr;
    private Context u;
    private final Object pn = new Object();
    private long iz = 0;
    private ServiceConnection x = new ServiceConnection() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.u.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            u.this.nr = jk.u.u(iBinder);
            try {
                u.this.nr.asBinder().linkToDeath(u.this.n, 0);
            } catch (RemoteException e) {
                k.u("MultiProcess", "onServiceConnected throws :", e);
            }
            u.this.b.countDown();
            System.currentTimeMillis();
            long unused = u.this.iz;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };
    private IBinder.DeathRecipient n = new IBinder.DeathRecipient() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.u.2
        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            u.this.nr.asBinder().unlinkToDeath(u.this.n, 0);
            u.this.nr = null;
            u.this.u();
        }
    };

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.multipro.aidl.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class BinderC0272u extends jk.u {
        @Override // com.bytedance.sdk.openadsdk.core.jk
        public IBinder u(int i) throws RemoteException {
            if (i == 0) {
                return x.nr();
            }
            if (i == 1) {
                return pn.nr();
            }
            if (i == 2) {
                return fx.nr();
            }
            if (i == 3) {
                return nr.nr();
            }
            if (i == 4) {
                return b.nr();
            }
            if (i != 5) {
                return null;
            }
            return iz.nr();
        }
    }

    private u(Context context) {
        this.u = context.getApplicationContext();
        u();
    }

    public static u u(Context context) {
        if (fx == null) {
            synchronized (u.class) {
                if (fx == null) {
                    fx = new u(context);
                }
            }
        }
        return fx;
    }

    public IBinder u(int i) {
        try {
            jk jkVar = this.nr;
            if (jkVar != null) {
                return jkVar.u(i);
            }
            return null;
        } catch (RemoteException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void u() {
        this.b = new CountDownLatch(1);
        try {
            this.u.bindService(new Intent(this.u, (Class<?>) BinderPoolService.class), this.x, 1);
            this.iz = System.currentTimeMillis();
            this.b.await();
        } catch (Exception e) {
            k.u("MultiProcess", "connectBinderPoolService throws: ", e);
        }
    }
}
