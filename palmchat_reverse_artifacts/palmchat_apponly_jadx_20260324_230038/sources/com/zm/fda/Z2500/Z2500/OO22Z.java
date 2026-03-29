package com.zm.fda.Z2500.Z2500;

import com.zm.fda.Z2500.Z0225;
import com.zm.fda.Z2500.Z25O0;
import com.zm.fda.utils.EventLog;
import java.lang.Thread;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class OO22Z implements Thread.UncaughtExceptionHandler, Z25O0 {
    public static final String c = "ExcepCol";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f16699a;
    public Z0225 b;

    @Override // com.zm.fda.Z2500.Z25O0
    public void a() {
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        EventLog.d(c, "uncaughtException e:", th.getMessage());
        if (thread.getName().equals("FinalizerWatchdogDaemon") && (th instanceof TimeoutException)) {
            return;
        }
        a(th);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f16699a;
        if (uncaughtExceptionHandler == null || uncaughtExceptionHandler == Thread.getDefaultUncaughtExceptionHandler()) {
            return;
        }
        this.f16699a.uncaughtException(thread, th);
    }

    @Override // com.zm.fda.Z2500.Z25O0
    public void a(Z0225 z0225) {
        this.b = z0225;
        this.f16699a = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    private void a(Throwable th) {
        Z0225 z0225 = this.b;
        if (z0225 != null) {
            z0225.a(th);
        }
    }
}
