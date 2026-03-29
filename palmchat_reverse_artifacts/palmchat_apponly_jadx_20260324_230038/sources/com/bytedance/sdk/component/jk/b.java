package com.bytedance.sdk.component.jk;

import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b {
    public static final b u = new b();
    private u b;
    private nr fx;
    private final List<WeakReference<ThreadPoolExecutor>> nr = new ArrayList();

    /* JADX INFO: compiled from: SearchBox */
    public interface nr {
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
    }

    private b() {
        nr().schedule(new Runnable() { // from class: com.bytedance.sdk.component.jk.b.4
            @Override // java.lang.Runnable
            public void run() {
            }
        }, 1L, TimeUnit.MINUTES);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fx() {
        List<ThreadPoolExecutor> listU = u(null, false, false);
        if (listU == null || listU.size() == 0) {
            return;
        }
        if (this.fx != null) {
            pn.u();
        }
        HashMap map = new HashMap();
        for (ThreadPoolExecutor threadPoolExecutor : listU) {
            if (threadPoolExecutor != null) {
                ThreadFactory threadFactory = threadPoolExecutor.getThreadFactory();
                if (threadFactory instanceof jk) {
                    map.put(((jk) threadFactory).u + "_" + threadPoolExecutor.hashCode(), Integer.valueOf(threadPoolExecutor.getPoolSize()));
                } else if (threadFactory instanceof com.bytedance.sdk.component.jk.u.b) {
                    map.put(((com.bytedance.sdk.component.jk.u.b) threadFactory).u() + "_" + threadPoolExecutor.hashCode(), Integer.valueOf(threadPoolExecutor.getPoolSize()));
                } else {
                    map.put(threadFactory.getClass().getName() + "_" + threadPoolExecutor.hashCode(), Integer.valueOf(threadPoolExecutor.getPoolSize()));
                }
                u(threadPoolExecutor);
            }
        }
        if (this.fx != null) {
            pn.u();
        }
    }

    private ScheduledExecutorService nr() {
        return t.nr.l();
    }

    public synchronized void nr(com.bytedance.sdk.component.jk.b.b bVar) {
        Iterator<WeakReference<ThreadPoolExecutor>> it = this.nr.iterator();
        while (it.hasNext()) {
            if (it.next().get() == bVar) {
                it.remove();
            }
        }
    }

    public synchronized void u(com.bytedance.sdk.component.jk.b.b bVar) {
        nr(bVar);
        this.nr.add(new WeakReference<>(bVar));
    }

    public String u(BlockingQueue blockingQueue) {
        if (blockingQueue instanceof com.bytedance.sdk.component.jk.u.u) {
            return ((com.bytedance.sdk.component.jk.u.u) blockingQueue).u();
        }
        return blockingQueue.getClass().getName();
    }

    public ThreadPoolExecutor u(String str, String str2) {
        List<ThreadPoolExecutor> listU = u(str2, false, true);
        u(listU, str);
        ThreadPoolExecutor threadPoolExecutor = listU.size() > 0 ? listU.get(0) : null;
        u();
        return threadPoolExecutor;
    }

    private synchronized List<ThreadPoolExecutor> u(String str, boolean z, boolean z2) {
        ArrayList arrayList;
        ThreadPoolExecutor threadPoolExecutor;
        boolean z3;
        arrayList = new ArrayList();
        for (WeakReference<ThreadPoolExecutor> weakReference : this.nr) {
            if (weakReference != null && (threadPoolExecutor = weakReference.get()) != null) {
                BlockingQueue<Runnable> queue = threadPoolExecutor.getQueue();
                if (queue instanceof com.bytedance.sdk.component.jk.u.u) {
                    z3 = ((com.bytedance.sdk.component.jk.u.u) queue).nr() instanceof PriorityBlockingQueue;
                } else {
                    z3 = queue instanceof PriorityBlockingQueue;
                }
                if (!threadPoolExecutor.isShutdown() && !threadPoolExecutor.isTerminated() && !threadPoolExecutor.isTerminating() && threadPoolExecutor.getQueue().isEmpty() && (str == null || !z3)) {
                    if (threadPoolExecutor.getActiveCount() < threadPoolExecutor.getPoolSize()) {
                        arrayList.add(threadPoolExecutor);
                        if (z) {
                            break;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        if (z2 && !z) {
            try {
                Collections.sort(arrayList, new Comparator<ThreadPoolExecutor>() { // from class: com.bytedance.sdk.component.jk.b.1
                    @Override // java.util.Comparator
                    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
                    public int compare(ThreadPoolExecutor threadPoolExecutor2, ThreadPoolExecutor threadPoolExecutor3) {
                        int poolSize = threadPoolExecutor2.getPoolSize() - threadPoolExecutor2.getActiveCount();
                        int poolSize2 = threadPoolExecutor3.getPoolSize() - threadPoolExecutor3.getActiveCount();
                        if (poolSize2 > poolSize) {
                            return 1;
                        }
                        return poolSize > poolSize2 ? -1 : 0;
                    }
                });
            } catch (Exception unused) {
            }
        }
        arrayList.size();
        this.nr.size();
        return arrayList;
    }

    public void u() {
        if (t.nr.u()) {
            nr().schedule(new Runnable() { // from class: com.bytedance.sdk.component.jk.b.2
                @Override // java.lang.Runnable
                public void run() {
                    b.this.fx();
                }
            }, 100L, TimeUnit.MILLISECONDS);
        }
    }

    private void u(final ThreadPoolExecutor threadPoolExecutor) {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        final long keepAliveTime = threadPoolExecutor.getKeepAliveTime(timeUnit);
        final boolean zAllowsCoreThreadTimeOut = threadPoolExecutor.allowsCoreThreadTimeOut();
        threadPoolExecutor.setKeepAliveTime(1L, timeUnit);
        if (zAllowsCoreThreadTimeOut) {
            threadPoolExecutor.allowCoreThreadTimeOut(false);
        }
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        nr().schedule(new Runnable() { // from class: com.bytedance.sdk.component.jk.b.3
            @Override // java.lang.Runnable
            public void run() {
                ThreadPoolExecutor threadPoolExecutor2 = threadPoolExecutor;
                long j = keepAliveTime;
                if (j == 0) {
                    j = 60;
                }
                threadPoolExecutor2.setKeepAliveTime(j, TimeUnit.NANOSECONDS);
                threadPoolExecutor.allowCoreThreadTimeOut(zAllowsCoreThreadTimeOut);
            }
        }, 10L, TimeUnit.MILLISECONDS);
    }

    private void u(List<ThreadPoolExecutor> list, String str) {
        if (list == null || list.size() == 0 || this.b == null) {
            return;
        }
        HashMap map = new HashMap();
        for (ThreadPoolExecutor threadPoolExecutor : list) {
            if (threadPoolExecutor != null) {
                ThreadFactory threadFactory = threadPoolExecutor.getThreadFactory();
                if (threadFactory instanceof jk) {
                    map.put(((jk) threadFactory).u + "_" + threadPoolExecutor.hashCode(), Integer.valueOf(threadPoolExecutor.getPoolSize()));
                } else if (threadFactory instanceof com.bytedance.sdk.component.jk.u.b) {
                    map.put(((com.bytedance.sdk.component.jk.u.b) threadFactory).u() + "_" + threadPoolExecutor.hashCode(), Integer.valueOf(threadPoolExecutor.getPoolSize()));
                } else {
                    map.put(threadFactory.getClass().getName() + "_" + threadPoolExecutor.hashCode(), Integer.valueOf(threadPoolExecutor.getPoolSize()));
                }
            }
        }
        HashMap map2 = new HashMap();
        ThreadGroup threadGroupNr = pn.nr();
        int iActiveCount = threadGroupNr.activeCount();
        Thread[] threadArr = new Thread[iActiveCount + (iActiveCount / 2)];
        int iEnumerate = threadGroupNr.enumerate(threadArr);
        for (int i = 0; i < iEnumerate; i++) {
            Thread thread = threadArr[i];
            Thread.State state = thread.getState();
            if (state == Thread.State.BLOCKED || state == Thread.State.WAITING || state == Thread.State.TIMED_WAITING) {
                String strReplaceAll = thread.getName().replaceAll("[0-9]", "");
                Integer num = (Integer) map2.get(strReplaceAll);
                map2.put(strReplaceAll, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
            }
        }
    }

    public void u(String str) {
        List<ThreadPoolExecutor> listU = u(null, false, true);
        if (listU == null || listU.size() == 0) {
            return;
        }
        u(listU, str);
        listU.size();
        ThreadPoolExecutor threadPoolExecutor = listU.get(0);
        if (threadPoolExecutor != null) {
            u(threadPoolExecutor);
        }
        u();
    }
}
