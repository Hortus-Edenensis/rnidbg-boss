package com.opos.cmn.an.j;

import com.opos.cmn.an.j.a;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.opos.cmn.an.j.a f7802a;
    private static com.opos.cmn.an.j.a b;
    private static com.opos.cmn.an.j.a c;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final com.opos.cmn.an.j.a f7803a;
        private static final int b;
        private static final int c;
        private static final int d;

        static {
            int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
            b = iAvailableProcessors;
            int iMax = Math.max(2, Math.min(iAvailableProcessors - 1, 4));
            c = iMax;
            int i = (iAvailableProcessors * 2) + 1;
            d = i;
            f7803a = new a.C0647a().a(iMax).b(i).c(30000).a("comp_thread").a();
        }
    }

    /* JADX INFO: renamed from: com.opos.cmn.an.j.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static final class C0648b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static com.opos.cmn.an.j.a f7804a;
        static final com.opos.cmn.an.j.a b;

        static {
            com.opos.cmn.an.j.a aVarA = new a.C0647a().a(2).b(20).c(3000).a(new SynchronousQueue()).a("io_thread").a();
            b = aVarA;
            aVarA.setRejectedExecutionHandler(new RejectedExecutionHandler() { // from class: com.opos.cmn.an.j.b.b.1
                @Override // java.util.concurrent.RejectedExecutionHandler
                public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                    synchronized (this) {
                        if (C0648b.f7804a == null) {
                            com.opos.cmn.an.j.a aVarA2 = new a.C0647a().a(5).b(5).c(3000).a(new LinkedBlockingQueue()).a("io_backup_thread").a();
                            C0648b.f7804a = aVarA2;
                            aVarA2.allowCoreThreadTimeOut(true);
                        }
                    }
                    C0648b.f7804a.execute(runnable);
                }
            });
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final com.opos.cmn.an.j.a f7805a = new a.C0647a().a(1).b(1).a("single_thread").a();
    }

    public static com.opos.cmn.an.j.a a() {
        if (f7802a == null) {
            f7802a = C0648b.b;
        }
        return f7802a;
    }

    public static com.opos.cmn.an.j.a b() {
        if (b == null) {
            b = a.f7803a;
        }
        return b;
    }

    public static com.opos.cmn.an.j.a c() {
        if (c == null) {
            c = c.f7805a;
        }
        return c;
    }

    public static void d(Runnable runnable) {
        try {
            b().execute(runnable);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("ThreadPoolTool", "executeBizTask", e);
        }
    }

    public static void e(Runnable runnable) {
        try {
            a().execute(runnable);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("ThreadPoolTool", "executeDLTask", e);
        }
    }

    public static void a(Runnable runnable) {
        c().execute(runnable);
    }

    public static void b(Runnable runnable) {
        try {
            a().execute(runnable);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("ThreadPoolTool", "executeNetTask", e);
        }
    }

    public static void c(Runnable runnable) {
        try {
            a().execute(runnable);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("ThreadPoolTool", "executeIOTask", e);
        }
    }
}
