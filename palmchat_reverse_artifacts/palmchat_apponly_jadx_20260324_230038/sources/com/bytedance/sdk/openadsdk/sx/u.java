package com.bytedance.sdk.openadsdk.sx;

import android.os.Handler;
import android.os.HandlerThread;
import com.bytedance.sdk.openadsdk.api.iz;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class u {
    private static volatile u u;
    private final Handler fx;
    private volatile ThreadPoolExecutor nr = null;

    private u() {
        HandlerThread handlerThread = new HandlerThread("csj_api_main");
        handlerThread.start();
        this.fx = new Handler(handlerThread.getLooper());
    }

    public static u u() {
        if (u == null) {
            synchronized (u.class) {
                u = new u();
            }
        }
        return u;
    }

    public ExecutorService fx() {
        if (this.nr == null) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, Integer.MAX_VALUE, 1000L, TimeUnit.MILLISECONDS, new SynchronousQueue());
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            this.nr = threadPoolExecutor;
        }
        return this.nr;
    }

    public Handler nr() {
        return this.fx;
    }

    public void u(Runnable runnable) {
        if (runnable != null) {
            try {
                this.fx.post(runnable);
            } catch (Throwable th) {
                iz.u(th);
            }
        }
    }

    public void u(ThreadPoolExecutor threadPoolExecutor) {
        if (threadPoolExecutor != null) {
            if (this.nr != null) {
                iz.nr("ApiThread", "setPluginExecutor: 释放掉api层的线程池");
                u(threadPoolExecutor, this.nr);
            }
            this.nr = threadPoolExecutor;
        }
    }

    private void u(ExecutorService executorService, final ThreadPoolExecutor threadPoolExecutor) {
        executorService.execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.sx.u.1
            @Override // java.lang.Runnable
            public void run() {
                ThreadPoolExecutor threadPoolExecutor2 = threadPoolExecutor;
                if (threadPoolExecutor2 == null) {
                    return;
                }
                try {
                    threadPoolExecutor2.setKeepAliveTime(1L, TimeUnit.MILLISECONDS);
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    while (true) {
                        try {
                            Thread.sleep(100L);
                        } catch (InterruptedException unused) {
                        }
                        if (threadPoolExecutor.getQueue().size() <= 0 && threadPoolExecutor.getActiveCount() == 0) {
                            threadPoolExecutor.shutdown();
                            return;
                        }
                    }
                } catch (Throwable unused2) {
                }
            }
        });
    }
}
