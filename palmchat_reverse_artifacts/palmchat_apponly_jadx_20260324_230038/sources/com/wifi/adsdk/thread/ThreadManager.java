package com.wifi.adsdk.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ThreadManager {
    private static final int DEFAULT_QUEUE_SIZE = 100;
    private static final int KEEP_ALIVE_TIME = 10;
    private static ThreadPool mThreadPool;
    private static final TimeUnit KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS;
    private static int CORE_NUM_POOL_SIZE = 10;

    /* JADX INFO: compiled from: SearchBox */
    public static class ThreadPool {
        private int corePoolSize;
        private long keepAliveTime;
        private ThreadPoolExecutor mExecutor;
        private int maximumPoolSize;
        private TimeUnit timeUnit;

        public void cancel(Runnable runnable) {
            ThreadPoolExecutor threadPoolExecutor = this.mExecutor;
            if (threadPoolExecutor != null) {
                threadPoolExecutor.getQueue().remove(runnable);
            }
        }

        public void execute(Runnable runnable) {
            if (runnable == null) {
                return;
            }
            if (this.mExecutor == null) {
                this.mExecutor = new ThreadPoolExecutor(this.corePoolSize, this.maximumPoolSize, this.keepAliveTime, this.timeUnit, new LinkedBlockingDeque(100), Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardOldestPolicy());
            }
            this.mExecutor.execute(runnable);
        }

        public void shutdown() {
            ThreadPoolExecutor threadPoolExecutor = this.mExecutor;
            if (threadPoolExecutor != null) {
                threadPoolExecutor.shutdown();
            }
        }

        public void shutdownNow() {
            ThreadPoolExecutor threadPoolExecutor = this.mExecutor;
            if (threadPoolExecutor != null) {
                threadPoolExecutor.shutdownNow();
            }
        }

        private ThreadPool(int i, int i2, long j, TimeUnit timeUnit) {
            this.corePoolSize = i;
            this.maximumPoolSize = i2;
            this.keepAliveTime = j;
            this.timeUnit = timeUnit;
        }
    }

    public static ThreadPool getThreadPool() {
        if (mThreadPool == null) {
            synchronized (ThreadManager.class) {
                if (mThreadPool == null) {
                    int iAvailableProcessors = (Runtime.getRuntime().availableProcessors() * 2) + 1;
                    CORE_NUM_POOL_SIZE = iAvailableProcessors;
                    mThreadPool = new ThreadPool(iAvailableProcessors, iAvailableProcessors * 2, 10L, KEEP_ALIVE_TIME_UNIT);
                }
            }
        }
        return mThreadPool;
    }
}
