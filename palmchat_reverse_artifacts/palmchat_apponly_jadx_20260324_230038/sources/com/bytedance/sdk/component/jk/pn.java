package com.bytedance.sdk.component.jk;

import java.lang.reflect.Field;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class pn {
    public static ThreadGroup nr() {
        try {
            Field declaredField = ThreadGroup.class.getDeclaredField("systemThreadGroup");
            declaredField.setAccessible(true);
            return (ThreadGroup) declaredField.get(ThreadGroup.class);
        } catch (Exception e) {
            u(e);
            return null;
        }
    }

    private static void u(Throwable th) {
        th.getMessage();
    }

    public static int u() {
        ThreadGroup threadGroupNr = nr();
        if (threadGroupNr == null) {
            return 0;
        }
        int iActiveCount = threadGroupNr.activeCount();
        try {
            return threadGroupNr.enumerate(new Thread[(iActiveCount / 2) + iActiveCount]);
        } catch (Throwable unused) {
            return iActiveCount;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void nr(ThreadPoolExecutor threadPoolExecutor) {
        try {
            threadPoolExecutor.setKeepAliveTime(1L, TimeUnit.MILLISECONDS);
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        } catch (Exception e) {
            u(e);
        }
        BlockingQueue<Runnable> queue = threadPoolExecutor.getQueue();
        while (true) {
            if (queue != null) {
                try {
                    if (queue.size() > 0) {
                        while (true) {
                            Runnable runnablePoll = queue.poll(0L, TimeUnit.MILLISECONDS);
                            if (runnablePoll == null) {
                                break;
                            } else {
                                runnablePoll.run();
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
            if (threadPoolExecutor.getActiveCount() == 0) {
                threadPoolExecutor.shutdown();
                return;
            }
            Thread.sleep(1000L);
        }
    }

    public static void u(ExecutorService executorService, final ThreadPoolExecutor threadPoolExecutor) {
        if (threadPoolExecutor != null) {
            try {
                threadPoolExecutor.allowCoreThreadTimeOut(true);
                threadPoolExecutor.setKeepAliveTime(2L, TimeUnit.MILLISECONDS);
            } catch (Exception e) {
                u(e);
            }
            executorService.execute(new Runnable() { // from class: com.bytedance.sdk.component.jk.pn.1
                @Override // java.lang.Runnable
                public void run() {
                    pn.nr(threadPoolExecutor);
                }
            });
        }
    }
}
