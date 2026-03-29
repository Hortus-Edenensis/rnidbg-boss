package com.lantern.core.network;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class ThreadManager {
    static final String TAG = "ThreadManager";

    /* JADX INFO: compiled from: SearchBox */
    public static class EventHandlerThreadHolder {
        private static Handler mHandler;
        private static HandlerThread mHandlerThread;

        static {
            HandlerThread handlerThread = new HandlerThread("event-thread");
            mHandlerThread = handlerThread;
            handlerThread.start();
            mHandler = new Handler(mHandlerThread.getLooper());
        }

        private EventHandlerThreadHolder() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class ExecutorHolder {
        private static ExecutorService mExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 30, TimeUnit.SECONDS, new SynchronousQueue());

        private ExecutorHolder() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class ScheduledExecutorHolder {
        private static ScheduledExecutorService mScheduledExecutor = Executors.newSingleThreadScheduledExecutor();

        private ScheduledExecutorHolder() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class SerialExecutor implements Executor {
        Runnable mActive;
        final Queue<Runnable> mTasks;

        private SerialExecutor() {
            this.mTasks = new LinkedList();
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(final Runnable runnable) {
            this.mTasks.offer(new Runnable() { // from class: com.lantern.core.network.ThreadManager.SerialExecutor.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        SerialExecutor.this.scheduleNext();
                    }
                }
            });
            if (this.mActive == null) {
                scheduleNext();
            }
        }

        public synchronized void scheduleNext() {
            Runnable runnablePoll = this.mTasks.poll();
            this.mActive = runnablePoll;
            if (runnablePoll != null) {
                ThreadManager.getExecutor().execute(this.mActive);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class SingleExecutorHolder {
        private static ExecutorService mSingleExecutor = Executors.newSingleThreadExecutor();
        private static ExecutorService mDecryptSingleExecutor = Executors.newSingleThreadExecutor();

        private SingleExecutorHolder() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class TimerHandlerThreadHolder {
        private static Handler mHandler;
        private static HandlerThread mHandlerThread;

        static {
            HandlerThread handlerThread = new HandlerThread("globle_timer");
            mHandlerThread = handlerThread;
            handlerThread.start();
            mHandler = new Handler(mHandlerThread.getLooper());
        }

        private TimerHandlerThreadHolder() {
        }
    }

    private ThreadManager() {
    }

    public static final void execute(Runnable runnable) {
        getExecutor().execute(runnable);
    }

    public static void executeInBackground(Runnable runnable) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            execute(runnable);
        } else {
            runnable.run();
        }
    }

    public static void executeInDbWriteThread(Runnable runnable) {
        executeInSingle(runnable);
    }

    public static void executeInDecryptSingle(Runnable runnable) {
        getDecryptSingleExecutor().execute(runnable);
    }

    public static void executeInSingle(Runnable runnable) {
        getSingleExecutor().execute(runnable);
    }

    private static ExecutorService getDecryptSingleExecutor() {
        return SingleExecutorHolder.mDecryptSingleExecutor;
    }

    private static Handler getEventThreadHandler() {
        return EventHandlerThreadHolder.mHandler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ExecutorService getExecutor() {
        return ExecutorHolder.mExecutor;
    }

    private static ScheduledExecutorService getScheduledExecutor() {
        return ScheduledExecutorHolder.mScheduledExecutor;
    }

    private static ExecutorService getSingleExecutor() {
        return SingleExecutorHolder.mSingleExecutor;
    }

    private static Handler getTimerThreadHandler() {
        return TimerHandlerThreadHolder.mHandler;
    }

    public static Executor newSerialExecutor() {
        return new SerialExecutor();
    }

    public static void postAtTime(Runnable runnable, long j) {
        getTimerThreadHandler().postAtTime(runnable, j);
    }

    public static void postDelayed(Runnable runnable, long j) {
        getTimerThreadHandler().postDelayed(runnable, j);
    }

    public static void postDelayedAndRemoveBefore(Runnable runnable, long j) {
        getTimerThreadHandler().removeCallbacks(runnable);
        getTimerThreadHandler().postDelayed(runnable, j);
    }

    public static void runInEventThread(Runnable runnable) {
        getEventThreadHandler().post(runnable);
    }

    public static final ScheduledFuture<?> schedule(Runnable runnable, long j) {
        return getScheduledExecutor().schedule(runnable, j, TimeUnit.MILLISECONDS);
    }

    public static final ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j, long j2) {
        return getScheduledExecutor().scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS);
    }

    public static ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j, long j2) {
        return getScheduledExecutor().scheduleWithFixedDelay(runnable, j, j2, TimeUnit.MILLISECONDS);
    }

    public static final <T> Future<T> submit(Runnable runnable, T t) {
        return getExecutor().submit(runnable, t);
    }

    public static <T> Future<T> submitInSingle(Runnable runnable, T t) {
        return getSingleExecutor().submit(runnable, t);
    }

    public static final <T> ScheduledFuture<T> schedule(Callable<T> callable, long j) {
        return getScheduledExecutor().schedule(callable, j, TimeUnit.MILLISECONDS);
    }

    public static final Future<?> submit(Runnable runnable) {
        return getExecutor().submit(runnable);
    }

    public static Future<?> submitInSingle(Runnable runnable) {
        return getSingleExecutor().submit(runnable);
    }

    public static final <T> Future<T> submit(Callable<T> callable) {
        return getExecutor().submit(callable);
    }

    public static <T> Future<T> submitInSingle(Callable<T> callable) {
        return getSingleExecutor().submit(callable);
    }
}
