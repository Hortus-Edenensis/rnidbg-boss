package defpackage;

import com.igexin.push.g.o;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class wz4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, ExecutorService> f21837a = new HashMap<>();
    public static final HashMap<String, String> b;

    static {
        HashMap<String, String> map = new HashMap<>();
        b = map;
        map.put("SDK_INIT", "ic");
        map.put("SDK_SERVICE_INIT", "mn");
        map.put("TCP_CONN_TASK", "tc");
        map.put("UPLOAD_REPORT", "rp");
        map.put("ONCE_TASK", "oc");
        map.put("SCHEDULE_TASK", o.e);
        map.put("MAJOR_TASK", "mj");
        map.put("NORMAL_TASK", "nr");
        map.put("FUTURE_TASK", "fr");
    }

    public static void a(String str, Runnable runnable) {
        try {
            b(str).execute(runnable);
        } catch (Throwable th) {
            k63.c("SDKWorker_XExecutor", "execute failed, try again e:" + th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0036 A[Catch: all -> 0x013f, TryCatch #0 {, blocks: (B:12:0x0028, B:14:0x0030, B:56:0x013c, B:16:0x0036, B:17:0x003e, B:47:0x009e, B:48:0x00a1, B:54:0x011a, B:55:0x0131, B:49:0x00a5, B:50:0x00c2, B:51:0x00e1, B:52:0x00fd, B:19:0x0042, B:22:0x004d, B:25:0x0057, B:28:0x0061, B:31:0x006b, B:34:0x0075, B:37:0x007f, B:40:0x0089, B:43:0x0093), top: B:62:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ExecutorService b(String str) {
        int i;
        ThreadPoolExecutor threadPoolExecutor;
        ThreadPoolExecutor threadPoolExecutor2;
        ExecutorService executorService;
        HashMap<String, String> map = b;
        String str2 = str;
        if (map.get(str2) == null) {
            str2 = "NORMAL_TASK";
        }
        String str3 = map.get(str2);
        HashMap<String, ExecutorService> map2 = f21837a;
        ExecutorService executorService2 = map2.get(str2);
        if (executorService2 != null && !executorService2.isShutdown()) {
            return executorService2;
        }
        synchronized (wz4.class) {
            ExecutorService executorService3 = map2.get(str2);
            if (executorService3 != null) {
                boolean zIsShutdown = executorService3.isShutdown();
                executorService = executorService3;
                if (zIsShutdown) {
                    i = 3;
                    switch (str2) {
                        case "SDK_INIT":
                        case "SDK_SERVICE_INIT":
                        case "TCP_CONN_TASK":
                        case "MAJOR_TASK":
                            threadPoolExecutor2 = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new cx2(str3));
                            i = 1;
                            threadPoolExecutor = threadPoolExecutor2;
                            break;
                        case "UPLOAD_REPORT":
                        case "SCHEDULE_TASK":
                            ThreadPoolExecutor threadPoolExecutor3 = new ThreadPoolExecutor(1, 1, 10L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new cx2(str3));
                            threadPoolExecutor3.allowCoreThreadTimeOut(true);
                            threadPoolExecutor2 = threadPoolExecutor3;
                            i = 1;
                            threadPoolExecutor = threadPoolExecutor2;
                            break;
                        case "ONCE_TASK":
                            ThreadPoolExecutor threadPoolExecutor4 = new ThreadPoolExecutor(1, 1, 3L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new cx2(str3));
                            threadPoolExecutor4.allowCoreThreadTimeOut(true);
                            threadPoolExecutor2 = threadPoolExecutor4;
                            i = 1;
                            threadPoolExecutor = threadPoolExecutor2;
                            break;
                        case "FUTURE_TASK":
                            ThreadPoolExecutor threadPoolExecutor5 = new ThreadPoolExecutor(3, 3, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(5), new cx2(str3));
                            threadPoolExecutor5.allowCoreThreadTimeOut(true);
                            threadPoolExecutor = threadPoolExecutor5;
                            break;
                        case "NORMAL_TASK":
                        default:
                            threadPoolExecutor2 = new ThreadPoolExecutor(1, 5, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque(2), new cx2(str3));
                            i = 1;
                            threadPoolExecutor = threadPoolExecutor2;
                            break;
                    }
                    threadPoolExecutor.setRejectedExecutionHandler(new vw2(str3, i));
                    map2.put(str2, threadPoolExecutor);
                    executorService = threadPoolExecutor;
                }
            }
        }
        return executorService;
    }

    public static boolean c(String str) {
        try {
            ExecutorService executorServiceB = b(str);
            if (executorServiceB == null || executorServiceB.isShutdown()) {
                return false;
            }
            return !executorServiceB.isTerminated();
        } catch (Throwable th) {
            k63.c("SDKWorker_XExecutor", "check executor " + str + " isAlive error: " + th);
            return false;
        }
    }

    public static void d(String str) {
        try {
            e(b(str));
        } catch (Throwable th) {
            k63.c("SDKWorker_XExecutor", "shutdown executor " + str + "error: " + th);
        }
    }

    public static void e(ExecutorService executorService) {
        if (executorService == null) {
            return;
        }
        try {
            executorService.shutdown();
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            if (executorService.awaitTermination(100L, timeUnit)) {
                return;
            }
            executorService.shutdownNow();
            if (executorService.awaitTermination(100L, timeUnit)) {
                return;
            }
            k63.j("SDKWorker_XExecutor", "executor did not terminate");
        } catch (InterruptedException unused) {
            executorService.shutdownNow();
            k63.j("SDKWorker_XExecutor", "current thread is interrupted by self");
            Thread.currentThread().interrupt();
        } catch (Throwable th) {
            k63.l("SDKWorker_XExecutor", "shutDown e:" + th);
        }
    }
}
