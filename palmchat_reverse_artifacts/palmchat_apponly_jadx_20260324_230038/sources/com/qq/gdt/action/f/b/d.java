package com.qq.gdt.action.f.b;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f10503a;
    public int b;
    public Executor c;
    public Executor d;

    public d() {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.f10503a = (int) timeUnit.toMillis(30L);
        this.b = (int) timeUnit.toMillis(30L);
        this.c = new ThreadPoolExecutor(3, 10, 60L, timeUnit, new LinkedBlockingQueue());
        this.d = new Executor() { // from class: com.qq.gdt.action.f.b.d.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Handler f10504a = new Handler(Looper.getMainLooper());

            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                this.f10504a.post(runnable);
            }
        };
    }
}
