package com.oplus.tblplayer.utils.executor;

import com.oplus.tblplayer.utils.LogUtil;
import com.oplus.tblplayer.utils.executor.DefaultThreadFactory;
import java.lang.Thread;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class DefaultThreadFactory implements ThreadFactory {
    private static final String TAG = "DefaultThreadFactory";
    private final ThreadGroup mThreadGroup;
    private final String mThreadNamePrefix;
    private final AtomicInteger mThreadNumber = new AtomicInteger(1);

    public DefaultThreadFactory(String str) {
        SecurityManager securityManager = System.getSecurityManager();
        this.mThreadGroup = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        this.mThreadNamePrefix = "ThreadPool_" + str + ", thread No.";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$newThread$0(Thread thread, Throwable th) {
        LogUtil.e(TAG, "Running task appeared exception! Thread [" + thread.getName() + "], because : " + th.getCause());
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        String str = this.mThreadNamePrefix + this.mThreadNumber.getAndIncrement();
        LogUtil.d(TAG, "Thread production, name is [" + str + "]");
        Thread thread = new Thread(this.mThreadGroup, runnable, str, 0L);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (thread.getPriority() != 5) {
            thread.setPriority(5);
        }
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: w81
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public final void uncaughtException(Thread thread2, Throwable th) {
                DefaultThreadFactory.lambda$newThread$0(thread2, th);
            }
        });
        return thread;
    }
}
