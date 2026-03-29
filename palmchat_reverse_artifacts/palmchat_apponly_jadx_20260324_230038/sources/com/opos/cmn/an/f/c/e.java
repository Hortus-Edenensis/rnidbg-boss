package com.opos.cmn.an.f.c;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class e implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f7776a;

    public e(String str) {
        this.f7776a = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.f7776a);
        thread.setUncaughtExceptionHandler(d.a());
        thread.setPriority(5);
        return thread;
    }
}
