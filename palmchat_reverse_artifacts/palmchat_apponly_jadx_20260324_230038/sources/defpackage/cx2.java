package defpackage;

import android.text.TextUtils;
import com.baidu.platform.comapi.map.MapController;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class cx2 implements ThreadFactory {
    public static final String d = "cx2";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThreadGroup f16944a;
    public final AtomicInteger b = new AtomicInteger(1);
    public final String c;

    public cx2(String str) {
        SecurityManager securityManager = System.getSecurityManager();
        this.f16944a = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        this.c = "jg_" + (TextUtils.isEmpty(str) ? MapController.DEFAULT_LAYER_TAG : str.toLowerCase()) + "_pool_thread";
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread;
        Throwable th;
        Thread thread2;
        try {
            thread = new Thread(this.f16944a, runnable, this.c + this.b.getAndIncrement(), 0L);
            try {
                if (thread.isDaemon()) {
                    thread.setDaemon(false);
                }
                if (thread.getPriority() == 5) {
                    return thread;
                }
                thread.setPriority(5);
                return thread;
            } catch (Throwable th2) {
                th = th2;
                k63.c(d, "JThreadFactory new Thread error, " + th.getMessage());
                try {
                    thread2 = new Thread(this.f16944a, runnable, this.c + this.b.getAndIncrement(), 0L);
                } catch (Throwable th3) {
                    th = th3;
                }
                try {
                    if (thread2.isDaemon()) {
                        thread2.setDaemon(false);
                    }
                    if (thread2.getPriority() != 5) {
                        thread2.setPriority(5);
                    }
                    return thread2;
                } catch (Throwable th4) {
                    th = th4;
                    thread = thread2;
                    k63.c(d, "JThreadFactory new Thread again error, " + th.getMessage());
                    return thread;
                }
            }
        } catch (Throwable th5) {
            thread = null;
            th = th5;
        }
    }
}
