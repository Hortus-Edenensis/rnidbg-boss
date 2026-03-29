package defpackage;

import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class fb3 implements RejectedExecutionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f17497a;
    public String b;
    public ThreadPoolExecutor c;
    public LinkedBlockingQueue<Runnable> d;

    public fb3(String str, int i) {
        this.b = str;
        this.f17497a = i;
    }

    @Override // java.util.concurrent.RejectedExecutionHandler
    public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        LogUtil.w("LxRejectedExecutionHandler", "poolName: " + this.b + ", Exceeded ThreadPoolExecutor pool size");
        synchronized (this) {
            if (this.c == null) {
                LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>();
                this.d = linkedBlockingQueue;
                int i = this.f17497a;
                ThreadPoolExecutor threadPoolExecutorF = vw5.f(i, i, 3L, TimeUnit.SECONDS, linkedBlockingQueue, this.b + "_reject_");
                this.c = threadPoolExecutorF;
                threadPoolExecutorF.allowCoreThreadTimeOut(true);
            }
        }
        this.c.execute(runnable);
    }
}
