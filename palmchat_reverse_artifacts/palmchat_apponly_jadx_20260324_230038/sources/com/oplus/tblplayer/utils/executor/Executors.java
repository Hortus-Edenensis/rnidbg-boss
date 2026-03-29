package com.oplus.tblplayer.utils.executor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class Executors {
    public static Executor newExecutor(int i, int i2, long j, int i3, String str) {
        return newExecutor(i, i2, j, new ArrayBlockingQueue(i3), new DefaultThreadFactory(str), new DefaultDiscardPolicy());
    }

    public static Executor newExecutor(int i, int i2, long j, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        return new ThreadPoolExecutor(i, i2, j, TimeUnit.SECONDS, blockingQueue, threadFactory, rejectedExecutionHandler);
    }
}
