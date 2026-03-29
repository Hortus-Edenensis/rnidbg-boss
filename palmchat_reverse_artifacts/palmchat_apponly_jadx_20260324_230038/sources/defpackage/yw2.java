package defpackage;

import java.lang.Thread;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public abstract class yw2 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f22293a;
    public Thread.UncaughtExceptionHandler b = new a();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Thread.UncaughtExceptionHandler {
        public a() {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("name: ");
            sb.append(yw2.this.f22293a);
            sb.append("thread id: ");
            sb.append(thread != null ? thread.getName() : "");
            sb.append("-");
            sb.append(thread != null ? Long.valueOf(thread.getId()) : "");
            sb.append("\n e:");
            sb.append(th);
            p63.c("JCommonRunnable", sb.toString());
        }
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public void run() {
        Thread.currentThread().setUncaughtExceptionHandler(this.b);
        a();
        Thread.currentThread().setUncaughtExceptionHandler(null);
    }
}
