package defpackage;

import java.lang.Thread;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class xq0 implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f22034a;
    public a b;
    public boolean c = true;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void handleException(Throwable th);
    }

    public xq0() {
        if (Thread.getDefaultUncaughtExceptionHandler() == this) {
            return;
        }
        this.f22034a = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public void a(a aVar) {
        this.b = aVar;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (thread.getName().equals("FinalizerWatchdogDaemon") && (th instanceof TimeoutException)) {
            return;
        }
        a aVar = this.b;
        if (aVar != null && this.c) {
            aVar.handleException(th);
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f22034a;
        if (uncaughtExceptionHandler == null || uncaughtExceptionHandler == Thread.getDefaultUncaughtExceptionHandler()) {
            return;
        }
        this.f22034a.uncaughtException(thread, th);
    }
}
