package defpackage;

import java.lang.Thread;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public abstract class xw2 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f22065a;
    public Thread.UncaughtExceptionHandler b;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Thread.UncaughtExceptionHandler {
        public a() {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("name: ");
            sb.append(xw2.this.f22065a);
            sb.append(", thread id:");
            sb.append(thread != null ? thread.getName() : "");
            sb.append("-");
            sb.append(thread != null ? Long.valueOf(thread.getId()) : "");
            sb.append("\n e:");
            sb.append(th);
            k63.c("JCoreRunnable", sb.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Thread.UncaughtExceptionHandler {
        public b() {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("name: ");
            sb.append(xw2.this.f22065a);
            sb.append(", thread id: ");
            sb.append(thread != null ? thread.getName() : "");
            sb.append("-");
            sb.append(thread != null ? Long.valueOf(thread.getId()) : "");
            sb.append("\n e:");
            sb.append(th);
            k63.c("JCoreRunnable", sb.toString());
        }
    }

    public xw2() {
        this.b = new a();
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public void run() {
        Thread.currentThread().setUncaughtExceptionHandler(this.b);
        a();
        Thread.currentThread().setUncaughtExceptionHandler(null);
    }

    public xw2(String str) {
        this.f22065a = str;
        this.b = new b();
    }
}
