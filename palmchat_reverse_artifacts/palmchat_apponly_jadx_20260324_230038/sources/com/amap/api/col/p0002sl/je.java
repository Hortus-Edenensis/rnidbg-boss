package com.amap.api.col.p0002sl;

import com.amap.api.col.p0002sl.jd;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class je {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected ThreadPoolExecutor f2926a;
    private ConcurrentHashMap<jd, Future<?>> c = new ConcurrentHashMap<>();
    protected jd.a b = new jd.a() { // from class: com.amap.api.col.2sl.je.1
        @Override // com.amap.api.col.2sl.jd.a
        public final void a(jd jdVar) {
            je.this.a(jdVar);
        }
    };

    private synchronized void a(jd jdVar, Future<?> future) {
        try {
            this.c.put(jdVar, future);
        } catch (Throwable th) {
            hd.c(th, "TPool", "addQueue");
            th.printStackTrace();
        }
    }

    private synchronized boolean c(jd jdVar) {
        boolean zContainsKey;
        try {
            zContainsKey = this.c.containsKey(jdVar);
        } catch (Throwable th) {
            hd.c(th, "TPool", "contain");
            th.printStackTrace();
            zContainsKey = false;
        }
        return zContainsKey;
    }

    public final void b(jd jdVar) {
        ThreadPoolExecutor threadPoolExecutor;
        if (c(jdVar) || (threadPoolExecutor = this.f2926a) == null || threadPoolExecutor.isShutdown()) {
            return;
        }
        jdVar.e = this.b;
        try {
            Future<?> futureSubmit = this.f2926a.submit(jdVar);
            if (futureSubmit == null) {
                return;
            }
            a(jdVar, futureSubmit);
        } catch (RejectedExecutionException e) {
            hd.c(e, "TPool", "addTask");
        }
    }

    public final synchronized void a(jd jdVar) {
        try {
            this.c.remove(jdVar);
        } catch (Throwable th) {
            hd.c(th, "TPool", "removeQueue");
            th.printStackTrace();
        }
    }

    public final Executor b() {
        return this.f2926a;
    }
}
