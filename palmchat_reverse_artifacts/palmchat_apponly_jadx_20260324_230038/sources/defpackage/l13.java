package defpackage;

import com.zenmen.palmchat.peoplematch.bean.PeopleMatchCardBean;
import com.zenmen.palmchat.thread.worker.TaskType;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class l13 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<TaskType, ExecutorService> f18885a = new HashMap<>();

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18886a;

        static {
            int[] iArr = new int[TaskType.values().length];
            f18886a = iArr;
            try {
                iArr[TaskType.LOG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18886a[TaskType.CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f18886a[TaskType.ONCE_TASK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f18886a[TaskType.SQLITE_IO_SINGLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f18886a[TaskType.NORMAL_TASK.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static void a(TaskType taskType, Runnable runnable) {
        try {
            b(taskType).execute(runnable);
        } catch (Throwable th) {
            LogUtil.e("LXWorker", "execute failed, try again e:" + th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0021 A[Catch: all -> 0x00a7, TryCatch #0 {, blocks: (B:8:0x0013, B:10:0x001b, B:27:0x00a4, B:12:0x0021, B:18:0x0035, B:23:0x008e, B:25:0x0092, B:26:0x00a1, B:20:0x005b, B:19:0x0047, B:21:0x0062, B:22:0x0069), top: B:33:0x0013 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ExecutorService b(TaskType taskType) {
        ExecutorService executorServiceA;
        ExecutorService executorService;
        HashMap<TaskType, ExecutorService> map = f18885a;
        ExecutorService executorService2 = map.get(taskType);
        if (executorService2 != null && !executorService2.isShutdown()) {
            return executorService2;
        }
        synchronized (l13.class) {
            ExecutorService executorService3 = map.get(taskType);
            if (executorService3 != null) {
                boolean zIsShutdown = executorService3.isShutdown();
                executorService = executorService3;
                if (zIsShutdown) {
                    int i = a.f18886a[taskType.ordinal()];
                    if (i == 1) {
                        int iMax = Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4));
                        ThreadPoolExecutor threadPoolExecutorF = vw5.f(iMax, iMax * 2, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), "log");
                        threadPoolExecutorF.allowCoreThreadTimeOut(true);
                        executorServiceA = threadPoolExecutorF;
                    } else if (i != 2) {
                        if (i == 3) {
                            vw5.f(1, 1, 3L, TimeUnit.SECONDS, new LinkedBlockingDeque(), "onece").allowCoreThreadTimeOut(true);
                        } else if (i != 4) {
                            executorServiceA = vw5.f(2, 6, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque(), PeopleMatchCardBean.RECOMMEND_TYPE_NORMAL);
                        }
                        executorServiceA = vw5.d("signle");
                    } else {
                        executorServiceA = vw5.a("cache");
                    }
                    if (executorServiceA instanceof ThreadPoolExecutor) {
                        ((ThreadPoolExecutor) executorServiceA).setRejectedExecutionHandler(new fb3(taskType.name(), 1));
                    }
                    map.put(taskType, executorServiceA);
                    executorService = executorServiceA;
                }
            }
        }
        return executorService;
    }
}
