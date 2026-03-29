package defpackage;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class vw2 implements RejectedExecutionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f21545a;
    public String b;
    public ThreadPoolExecutor c;
    public LinkedBlockingQueue<Runnable> d;

    public vw2(String str, int i) {
        this.b = str;
        if (i <= 0) {
            this.f21545a = 3;
        }
        this.f21545a = i;
    }

    @Override // java.util.concurrent.RejectedExecutionHandler
    public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        k63.l("JRejectedExecutionHandler", "poolName: " + this.b + ", Exceeded ThreadPoolExecutor pool size");
        synchronized (this) {
            if (this.c == null) {
                this.d = new LinkedBlockingQueue<>();
                int i = this.f21545a;
                ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(i, i, 3L, TimeUnit.SECONDS, this.d, new cx2(this.b + "_rjt"));
                this.c = threadPoolExecutor2;
                threadPoolExecutor2.allowCoreThreadTimeOut(true);
            }
        }
        this.c.execute(runnable);
    }
}
