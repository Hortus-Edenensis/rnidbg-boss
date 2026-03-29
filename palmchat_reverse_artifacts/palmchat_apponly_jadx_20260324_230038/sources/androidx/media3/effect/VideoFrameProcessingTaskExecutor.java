package androidx.media3.effect;

import androidx.annotation.GuardedBy;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.GlUtil;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
final class VideoFrameProcessingTaskExecutor {
    private static final long EXECUTOR_SERVICE_TIMEOUT_MS = 500;
    private final ErrorListener errorListener;

    @GuardedBy("lock")
    private boolean shouldCancelTasks;
    private final boolean shouldShutdownExecutorService;
    private final ExecutorService singleThreadExecutorService;
    private final Future<Thread> threadFuture;
    private final Object lock = new Object();

    @GuardedBy("lock")
    private final Queue<Task> highPriorityTasks = new ArrayDeque();

    /* JADX INFO: compiled from: SearchBox */
    public interface ErrorListener {
        void onError(VideoFrameProcessingException videoFrameProcessingException);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface Task {
        void run() throws VideoFrameProcessingException, GlUtil.GlException;
    }

    public VideoFrameProcessingTaskExecutor(ExecutorService executorService, boolean z, ErrorListener errorListener) {
        this.singleThreadExecutorService = executorService;
        this.threadFuture = executorService.submit(new Callable() { // from class: zb6
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Thread.currentThread();
            }
        });
        this.shouldShutdownExecutorService = z;
        this.errorListener = errorListener;
    }

    private void handleException(Exception exc) {
        synchronized (this.lock) {
            if (this.shouldCancelTasks) {
                return;
            }
            this.shouldCancelTasks = true;
            this.errorListener.onError(VideoFrameProcessingException.from(exc));
        }
    }

    private boolean isRunningOnVideoFrameProcessingThread() throws InterruptedException {
        try {
            return Thread.currentThread() == this.threadFuture.get(500L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw e;
        } catch (Exception e2) {
            handleException(e2);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$flush$2(CountDownLatch countDownLatch) throws VideoFrameProcessingException, GlUtil.GlException {
        synchronized (this.lock) {
            this.shouldCancelTasks = false;
        }
        countDownLatch.countDown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$invoke$0(Task task) {
        try {
            task.run();
        } catch (Exception e) {
            handleException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$wrapTaskAndSubmitToExecutorService$3(boolean z, Task task) {
        Task taskPoll;
        try {
            synchronized (this.lock) {
                if (this.shouldCancelTasks && z) {
                    return;
                }
                while (true) {
                    synchronized (this.lock) {
                        taskPoll = this.highPriorityTasks.poll();
                    }
                    if (taskPoll == null) {
                        task.run();
                        return;
                    }
                    taskPoll.run();
                }
            }
        } catch (Exception e) {
            handleException(e);
        }
    }

    private Future<?> wrapTaskAndSubmitToExecutorService(final Task task, final boolean z) {
        return this.singleThreadExecutorService.submit(new Runnable() { // from class: androidx.media3.effect.u1
            @Override // java.lang.Runnable
            public final void run() {
                this.f1356a.lambda$wrapTaskAndSubmitToExecutorService$3(z, task);
            }
        });
    }

    public void flush() throws InterruptedException {
        synchronized (this.lock) {
            this.shouldCancelTasks = true;
            this.highPriorityTasks.clear();
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        wrapTaskAndSubmitToExecutorService(new Task() { // from class: androidx.media3.effect.r1
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                this.f1348a.lambda$flush$2(countDownLatch);
            }
        }, false);
        countDownLatch.await();
    }

    public void invoke(final Task task) throws InterruptedException {
        if (isRunningOnVideoFrameProcessingThread()) {
            try {
                task.run();
                return;
            } catch (Exception e) {
                handleException(e);
                return;
            }
        }
        try {
            this.singleThreadExecutorService.submit(new Runnable() { // from class: androidx.media3.effect.t1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f1353a.lambda$invoke$0(task);
                }
            }).get(500L, TimeUnit.MILLISECONDS);
        } catch (RuntimeException | ExecutionException | TimeoutException e2) {
            handleException(e2);
        }
    }

    public void release(Task task) throws InterruptedException {
        Assertions.checkState(!isRunningOnVideoFrameProcessingThread());
        synchronized (this.lock) {
            this.shouldCancelTasks = true;
            this.highPriorityTasks.clear();
        }
        wrapTaskAndSubmitToExecutorService(task, false);
        if (this.shouldShutdownExecutorService) {
            this.singleThreadExecutorService.shutdown();
            if (this.singleThreadExecutorService.awaitTermination(500L, TimeUnit.MILLISECONDS)) {
                return;
            }
            this.errorListener.onError(new VideoFrameProcessingException("Release timed out. OpenGL resources may not be cleaned up properly."));
        }
    }

    public void submit(Task task, boolean z) {
        synchronized (this.lock) {
            if (this.shouldCancelTasks && z) {
                return;
            }
            try {
                wrapTaskAndSubmitToExecutorService(task, z);
                e = null;
            } catch (RejectedExecutionException e) {
                e = e;
            }
            if (e != null) {
                handleException(e);
            }
        }
    }

    public void submitWithHighPriority(Task task) {
        synchronized (this.lock) {
            if (this.shouldCancelTasks) {
                return;
            }
            this.highPriorityTasks.add(task);
            submit(new Task() { // from class: androidx.media3.effect.s1
                @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
                public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                    VideoFrameProcessingTaskExecutor.lambda$submitWithHighPriority$1();
                }
            });
        }
    }

    public void verifyVideoFrameProcessingThread() {
        try {
            Assertions.checkState(isRunningOnVideoFrameProcessingThread());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            handleException(e);
        }
    }

    public void submit(Task task) {
        submit(task, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$submitWithHighPriority$1() throws VideoFrameProcessingException, GlUtil.GlException {
    }
}
