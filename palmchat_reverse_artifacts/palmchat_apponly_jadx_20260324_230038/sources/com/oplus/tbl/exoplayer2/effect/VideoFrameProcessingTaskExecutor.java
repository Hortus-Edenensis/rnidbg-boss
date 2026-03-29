package com.oplus.tbl.exoplayer2.effect;

import androidx.annotation.GuardedBy;
import com.oplus.tbl.exoplayer2.VideoFrameProcessingException;
import com.oplus.tbl.exoplayer2.util.GlUtil;
import com.oplus.tbl.exoplayer2.util.UnstableApi;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@UnstableApi
final class VideoFrameProcessingTaskExecutor {
    private static final long RELEASE_WAIT_TIME_MS = 500;
    private final ErrorListener errorListener;

    @GuardedBy("lock")
    private boolean shouldCancelTasks;
    private final boolean shouldShutdownExecutorService;
    private final ExecutorService singleThreadExecutorService;
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

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$flush$1(CountDownLatch countDownLatch) throws VideoFrameProcessingException, GlUtil.GlException {
        synchronized (this.lock) {
            this.shouldCancelTasks = false;
        }
        countDownLatch.countDown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$wrapTaskAndSubmitToExecutorService$2(boolean z, Task task) {
        Task taskPoll;
        try {
            synchronized (this.lock) {
                if (this.shouldCancelTasks && !z) {
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
        return this.singleThreadExecutorService.submit(new Runnable() { // from class: com.oplus.tbl.exoplayer2.effect.f1
            @Override // java.lang.Runnable
            public final void run() {
                this.f7600a.lambda$wrapTaskAndSubmitToExecutorService$2(z, task);
            }
        });
    }

    public void flush() throws InterruptedException {
        synchronized (this.lock) {
            this.shouldCancelTasks = true;
            this.highPriorityTasks.clear();
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        wrapTaskAndSubmitToExecutorService(new Task() { // from class: com.oplus.tbl.exoplayer2.effect.e1
            @Override // com.oplus.tbl.exoplayer2.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                this.f7597a.lambda$flush$1(countDownLatch);
            }
        }, true);
        countDownLatch.await();
    }

    public void release(Task task) throws InterruptedException {
        synchronized (this.lock) {
            this.shouldCancelTasks = true;
            this.highPriorityTasks.clear();
        }
        wrapTaskAndSubmitToExecutorService(task, true);
        if (this.shouldShutdownExecutorService) {
            this.singleThreadExecutorService.shutdown();
            if (this.singleThreadExecutorService.awaitTermination(500L, TimeUnit.MILLISECONDS)) {
                return;
            }
            this.errorListener.onError(new VideoFrameProcessingException("Release timed out. OpenGL resources may not be cleaned up properly."));
        }
    }

    public void submit(Task task) {
        synchronized (this.lock) {
            if (this.shouldCancelTasks) {
                return;
            }
            try {
                wrapTaskAndSubmitToExecutorService(task, false);
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
            submit(new Task() { // from class: com.oplus.tbl.exoplayer2.effect.g1
                @Override // com.oplus.tbl.exoplayer2.effect.VideoFrameProcessingTaskExecutor.Task
                public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                    VideoFrameProcessingTaskExecutor.lambda$submitWithHighPriority$0();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$submitWithHighPriority$0() throws VideoFrameProcessingException, GlUtil.GlException {
    }
}
