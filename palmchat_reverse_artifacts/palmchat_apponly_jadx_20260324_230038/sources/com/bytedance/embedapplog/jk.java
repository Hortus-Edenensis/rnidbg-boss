package com.bytedance.embedapplog;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import androidx.annotation.Nullable;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class jk<SERVICE, RESULT> {
    private final Context b;
    private final nr<SERVICE, RESULT> fx;
    private final Intent nr;
    private final CountDownLatch u = new CountDownLatch(1);

    /* JADX INFO: compiled from: SearchBox */
    public interface nr<T, RESULT> {
        T u(IBinder iBinder);

        RESULT u(T t);
    }

    public jk(Context context, Intent intent, nr<SERVICE, RESULT> nrVar) {
        this.b = context;
        this.nr = intent;
        this.fx = nrVar;
    }

    public RESULT u() {
        jk<SERVICE, RESULT>.u uVar;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            ti.fx("Don't do this in ui thread.", null);
            return null;
        }
        try {
            uVar = new u(this.u, this.fx);
            this.b.bindService(this.nr, uVar, 1);
            this.u.await();
            try {
                return this.fx.u(uVar.u);
            } catch (Throwable th) {
                th = th;
                try {
                    ti.u(th);
                    return null;
                } finally {
                    u(uVar);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            uVar = null;
        }
    }

    private void u(jk<SERVICE, RESULT>.u uVar) {
        if (uVar != null) {
            try {
                this.b.unbindService(uVar);
            } catch (Throwable th) {
                ti.u(th);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class u implements ServiceConnection {
        private final nr<SERVICE, RESULT> b;
        private final CountDownLatch fx;

        @Nullable
        SERVICE u;

        public u(CountDownLatch countDownLatch, nr<SERVICE, RESULT> nrVar) {
            this.fx = countDownLatch;
            this.b = nrVar;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            ti.u("ServiceBlockBinder#onServiceConnected ".concat(String.valueOf(componentName)));
            try {
                this.u = this.b.u(iBinder);
            } catch (Throwable th) {
                try {
                    ti.fx("ServiceBlockBinder#onServiceConnected", th);
                    try {
                        this.fx.countDown();
                    } catch (Exception e) {
                        ti.u(e);
                    }
                } finally {
                    try {
                        this.fx.countDown();
                    } catch (Exception e2) {
                        ti.u(e2);
                    }
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            ti.u("ServiceBlockBinder#onServiceDisconnected".concat(String.valueOf(componentName)));
            try {
                this.fx.countDown();
            } catch (Exception e) {
                ti.u(e);
            }
        }

        @Override // android.content.ServiceConnection
        public void onBindingDied(ComponentName componentName) {
        }

        @Override // android.content.ServiceConnection
        public void onNullBinding(ComponentName componentName) {
        }
    }
}
