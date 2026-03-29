package cn.fly.verify;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class em extends Thread {
    private Looper c;
    private int b = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f2246a = 0;

    public static Handler a(String str, Handler.Callback callback) {
        return a(str, null, callback);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            b();
            this.b = Process.myTid();
            Looper.prepare();
            synchronized (this) {
                this.c = Looper.myLooper();
                notifyAll();
            }
            Process.setThreadPriority(this.f2246a);
            a(this.c);
            a();
            Looper.loop();
            this.b = -1;
        } catch (Throwable th) {
            en.a().a(th);
        }
    }

    public static Handler a(String str, final Runnable runnable, final Handler.Callback callback) {
        final Handler[] handlerArr = new Handler[1];
        em emVar = new em() { // from class: cn.fly.verify.em.1
            @Override // cn.fly.verify.em
            public void a(Looper looper) {
                synchronized (handlerArr) {
                    handlerArr[0] = new Handler(looper, callback);
                    handlerArr.notifyAll();
                }
            }

            @Override // cn.fly.verify.em, java.lang.Thread, java.lang.Runnable
            public void run() {
                Runnable runnable2 = runnable;
                if (runnable2 != null) {
                    runnable2.run();
                }
                super.run();
            }
        };
        synchronized (handlerArr) {
            if (str != null) {
                try {
                    emVar.setName(str);
                    emVar.start();
                    handlerArr.wait();
                } finally {
                }
            } else {
                emVar.start();
                handlerArr.wait();
            }
        }
        return handlerArr[0];
    }

    public void a() {
    }

    public void a(Looper looper) {
    }

    @Deprecated
    public void b() {
    }
}
