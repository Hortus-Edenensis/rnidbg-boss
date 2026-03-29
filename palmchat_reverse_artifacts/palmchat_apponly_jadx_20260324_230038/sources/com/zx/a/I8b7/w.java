package com.zx.a.I8b7;

import java.lang.Thread;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class w implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AtomicInteger f16876a = new AtomicInteger(0);

    public w(x xVar) {
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        StringBuilder sbA = f3.a("ZXHttpClient dispatcher's thread");
        sbA.append(this.f16876a.getAndIncrement());
        thread.setName(sbA.toString());
        thread.setUncaughtExceptionHandler(new a(this));
        return thread;
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Thread.UncaughtExceptionHandler {
        public a(w wVar) {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
        }
    }
}
