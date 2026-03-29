package a.a.c.a.d;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.Nullable;
import j$.util.Objects;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final class o<SERVICE, RESULT> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CountDownLatch f1118a = new CountDownLatch(1);
    public final Intent b;
    public final b<SERVICE, RESULT> c;
    public final Context d;

    /* JADX INFO: compiled from: SearchBox */
    public interface b<T, RESULT> {
        T a(IBinder iBinder);

        RESULT a(T t);
    }

    public o(Context context, Intent intent, b<SERVICE, RESULT> bVar) {
        this.d = context;
        this.b = intent;
        this.c = bVar;
    }

    public RESULT a() {
        Throwable th;
        o<SERVICE, RESULT>.a aVar;
        try {
            aVar = new a(this, this.f1118a, this.c);
        } catch (Throwable th2) {
            th = th2;
            aVar = null;
        }
        try {
            if (!this.d.bindService(this.b, aVar, 1)) {
                a(null);
                return null;
            }
            this.f1118a.await();
            try {
                return this.c.a(aVar.c);
            } catch (Throwable th3) {
                th = th3;
            }
            th.getMessage();
            return null;
        } finally {
            a(aVar);
        }
    }

    public final void a(o<SERVICE, RESULT>.a aVar) {
        if (aVar != null) {
            try {
                this.d.unbindService(aVar);
            } catch (Throwable th) {
                th.getMessage();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CountDownLatch f1119a;
        public final b<SERVICE, RESULT> b;

        @Nullable
        public SERVICE c;

        public a(o oVar, CountDownLatch countDownLatch, b<SERVICE, RESULT> bVar) {
            this.f1119a = countDownLatch;
            this.b = bVar;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Objects.toString(componentName);
            try {
                try {
                    this.c = this.b.a(iBinder);
                    this.f1119a.countDown();
                } catch (Throwable th) {
                    try {
                        th.getMessage();
                        this.f1119a.countDown();
                    } catch (Throwable th2) {
                        try {
                            this.f1119a.countDown();
                        } catch (Exception e) {
                            e.getMessage();
                        }
                        throw th2;
                    }
                }
            } catch (Exception e2) {
                e2.getMessage();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Objects.toString(componentName);
            try {
                this.f1119a.countDown();
            } catch (Exception e) {
                e.getMessage();
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
