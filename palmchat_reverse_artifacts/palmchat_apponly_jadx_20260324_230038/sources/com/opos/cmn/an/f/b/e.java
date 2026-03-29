package com.opos.cmn.an.f.b;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ThreadPoolExecutor f7770a;
    private int b;
    private BlockingQueue<Runnable> c;

    public e() {
        c.b();
        this.b = 2000;
        this.c = new LinkedBlockingQueue(this.b);
        this.f7770a = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, this.c, new com.opos.cmn.an.f.c.e("adLoganThread"), new com.opos.cmn.an.f.c.a());
    }

    public void a(Runnable runnable) {
        try {
            this.f7770a.execute(runnable);
        } catch (Throwable unused) {
        }
    }
}
