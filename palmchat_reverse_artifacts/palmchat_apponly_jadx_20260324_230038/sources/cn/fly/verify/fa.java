package cn.fly.verify;

import java.lang.Thread;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class fa implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Thread.UncaughtExceptionHandler f2346a = null;
    private static volatile boolean b = false;
    private static volatile boolean c = false;

    private fa() {
    }

    public static synchronized void a() {
        if (!b && ec.h && !c) {
            c = true;
            f2346a = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(new fa());
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        try {
            en.a().a("UE handled, processing...", new Object[0]);
            en.a().d(th);
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = f2346a;
            if (uncaughtExceptionHandler == null || (uncaughtExceptionHandler instanceof fa)) {
            }
        } catch (Throwable th2) {
            try {
                en.a().a(th2);
            } finally {
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = f2346a;
                if (uncaughtExceptionHandler2 != null && !(uncaughtExceptionHandler2 instanceof fa)) {
                    uncaughtExceptionHandler2.uncaughtException(thread, th);
                }
            }
        }
    }
}
