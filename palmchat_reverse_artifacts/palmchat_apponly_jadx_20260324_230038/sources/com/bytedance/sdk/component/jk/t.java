package com.bytedance.sdk.component.jk;

import com.bytedance.sdk.component.utils.k;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f5148a;
    private volatile ThreadPoolExecutor bg;
    private volatile ScheduledExecutorService bq;
    private int c;
    private volatile boolean gi;
    private boolean kj;
    private com.bytedance.sdk.component.jk.u.pn o;
    private com.bytedance.sdk.component.jk.u.nr qq;
    private volatile ThreadPoolExecutor sx;
    private volatile boolean z;
    public static final int u = x.u;
    public static final t nr = new t();
    public volatile boolean fx = true;
    private long iz = 5000;
    private long x = 20000;
    private volatile boolean n = true;
    private boolean jk = true;
    private long t = 100;
    private long l = 50;
    private long mv = 1000;
    private long s = 3000;
    private boolean k = false;
    private volatile boolean my = true;
    private boolean dw = true;
    private boolean q = true;
    private volatile boolean d = true;
    private volatile boolean h = true;
    private int b = Math.min(u, 4);
    private int pn = 50;

    private t() {
    }

    public ThreadPoolExecutor a() {
        if (this.sx == null) {
            synchronized (this) {
                if (this.sx == null) {
                    this.sx = new com.bytedance.sdk.component.jk.fx.b(this.b, this.pn, this.x, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new jk(10, "a") { // from class: com.bytedance.sdk.component.jk.t.1
                        @Override // com.bytedance.sdk.component.jk.jk
                        public Thread u(ThreadGroup threadGroup, Runnable runnable, String str) {
                            return new Thread(threadGroup, runnable, str);
                        }
                    });
                }
            }
        }
        return this.sx;
    }

    public long b() {
        return this.t;
    }

    public long bg() {
        return this.s;
    }

    public boolean bq() {
        return this.k;
    }

    public com.bytedance.sdk.component.jk.u.nr fx() {
        return this.qq;
    }

    public boolean iz() {
        return this.kj;
    }

    public ThreadPoolExecutor jk() {
        if (this.bg == null) {
            synchronized (this) {
                if (this.bg == null) {
                    this.bg = new com.bytedance.sdk.component.jk.fx.nr(this.b, this.pn, this.iz, TimeUnit.MILLISECONDS, new jk(10, com.kuaishou.weapon.p0.t.l) { // from class: com.bytedance.sdk.component.jk.t.2
                        @Override // com.bytedance.sdk.component.jk.jk
                        public Thread u(ThreadGroup threadGroup, Runnable runnable, String str) {
                            return new Thread(threadGroup, runnable, str);
                        }
                    });
                    if (this.h) {
                        try {
                            this.bg.allowCoreThreadTimeOut(true);
                        } catch (Throwable unused) {
                        }
                    }
                }
            }
        }
        return this.bg;
    }

    public boolean k() {
        return this.gi;
    }

    public ScheduledExecutorService l() {
        if (this.bq == null) {
            synchronized (this) {
                if (this.bq == null) {
                    this.bq = new ScheduledThreadPoolExecutor(1, new ThreadFactory() { // from class: com.bytedance.sdk.component.jk.t.3
                        @Override // java.util.concurrent.ThreadFactory
                        public Thread newThread(Runnable runnable) {
                            return new Thread(runnable, t.this.kj ? "csj-p-wp" : "csj-wp");
                        }
                    }, com.bytedance.sdk.component.jk.b.u.u);
                }
            }
        }
        return this.bq;
    }

    public ThreadPoolExecutor mv() {
        return this.f5148a ? jk() : a();
    }

    public boolean my() {
        return this.d && x.pn();
    }

    public int n() {
        return this.b;
    }

    public boolean nr(int i) {
        return (this.c & i) == i;
    }

    public long o() {
        return this.l;
    }

    public boolean pn() {
        return this.fx;
    }

    public boolean s() {
        return this.z;
    }

    public long sx() {
        return this.mv;
    }

    public int t() {
        return this.pn;
    }

    public com.bytedance.sdk.component.jk.u.pn x() {
        if (this.o == null) {
            this.o = new com.bytedance.sdk.component.jk.u.pn();
        }
        return this.o;
    }

    public void b(boolean z) {
        this.kj = z;
    }

    public void fx(boolean z) {
        this.fx = z;
    }

    public void iz(boolean z) {
        this.n = z;
    }

    public void n(boolean z) {
        if (this.z) {
            return;
        }
        if (this.bg != null) {
            this.bg.allowCoreThreadTimeOut(z);
        }
        this.h = z;
    }

    public boolean nr() {
        return this.dw;
    }

    public void pn(boolean z) {
        this.f5148a = z;
    }

    public void u(int i) {
        this.c = i;
    }

    public void b(int i) {
        this.pn = i;
        a().setMaximumPoolSize(i);
        jk().setMaximumPoolSize(i);
    }

    public void fx(int i) {
        this.b = i;
        a().setCorePoolSize(i);
        jk().setCorePoolSize(i);
    }

    public void nr(boolean z) {
        this.dw = z;
    }

    public boolean u() {
        return this.jk;
    }

    public void nr(ThreadPoolExecutor threadPoolExecutor) {
        if (threadPoolExecutor == null) {
            return;
        }
        ThreadPoolExecutor threadPoolExecutor2 = this.sx;
        this.sx = threadPoolExecutor;
        if (threadPoolExecutor2 == null || threadPoolExecutor2 == threadPoolExecutor) {
            return;
        }
        ((com.bytedance.sdk.component.jk.fx.b) threadPoolExecutor2).fx();
        pn.u(threadPoolExecutor, threadPoolExecutor2);
    }

    public void u(boolean z) {
        this.jk = z;
    }

    public void x(boolean z) {
        if (z) {
            n(false);
            x.u(false);
        }
        this.z = z;
    }

    public void u(com.bytedance.sdk.component.jk.u.nr nrVar) {
        this.qq = nrVar;
    }

    public void b(long j) {
        this.s = j;
    }

    public void fx(long j) {
        this.mv = j;
    }

    public void u(ThreadPoolExecutor threadPoolExecutor) {
        if (threadPoolExecutor == null) {
            return;
        }
        ThreadPoolExecutor threadPoolExecutor2 = this.bg;
        this.bg = threadPoolExecutor;
        if (threadPoolExecutor2 == null || threadPoolExecutor2 == threadPoolExecutor) {
            return;
        }
        pn.u(threadPoolExecutor, threadPoolExecutor2);
    }

    public void a(boolean z) {
        this.k = z;
    }

    public void nr(long j) {
        this.l = j;
    }

    public void u(ScheduledExecutorService scheduledExecutorService) {
        if (scheduledExecutorService == null) {
            return;
        }
        final ScheduledExecutorService scheduledExecutorService2 = this.bq;
        this.bq = scheduledExecutorService;
        if (scheduledExecutorService2 == null || scheduledExecutorService2 == scheduledExecutorService) {
            return;
        }
        this.bq.schedule(new Runnable() { // from class: com.bytedance.sdk.component.jk.t.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    scheduledExecutorService2.shutdown();
                } catch (Exception e) {
                    k.u("ThreadCenter", e);
                }
            }
        }, 5000L, TimeUnit.MILLISECONDS);
    }

    public void u(long j) {
        this.iz = j;
        jk().setKeepAliveTime(j, TimeUnit.MILLISECONDS);
    }
}
