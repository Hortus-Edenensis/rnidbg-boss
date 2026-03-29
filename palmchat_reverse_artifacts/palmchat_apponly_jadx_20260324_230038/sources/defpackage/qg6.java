package defpackage;

import android.os.AsyncTask;
import android.os.Build;
import java.lang.reflect.Field;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class qg6 {

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements Executor {
        public static final int c;
        public static final int d;
        public static final int e;
        public static final BlockingQueue<Runnable> f;
        public static final Executor g;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayDeque<Runnable> f20247a;
        public Runnable b;

        /* JADX INFO: renamed from: qg6$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class RunnableC1268a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Runnable f20248a;

            public RunnableC1268a(Runnable runnable) {
                this.f20248a = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    try {
                        this.f20248a.run();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } finally {
                    a.this.a();
                }
            }
        }

        static {
            int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
            c = iAvailableProcessors;
            int iMax = Math.max(2, Math.min(iAvailableProcessors - 1, 4));
            d = iMax;
            int i = (iAvailableProcessors * 2) + 1;
            e = i;
            LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(128);
            f = linkedBlockingQueue;
            ThreadPoolExecutor threadPoolExecutorF = vw5.f(iMax, i, 30L, TimeUnit.SECONDS, linkedBlockingQueue, qg6.class.getSimpleName());
            threadPoolExecutorF.allowCoreThreadTimeOut(true);
            g = threadPoolExecutorF;
        }

        public synchronized void a() {
            Runnable runnablePoll = this.f20247a.poll();
            this.b = runnablePoll;
            if (runnablePoll != null) {
                g.execute(runnablePoll);
            }
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(Runnable runnable) {
            this.f20247a.offer(new RunnableC1268a(runnable));
            if (this.b == null) {
                a();
            }
        }

        public a() {
            this.f20247a = new ArrayDeque<>();
        }
    }

    public static void a() {
        if (b()) {
            try {
                c(AsyncTask.class.getDeclaredField("SERIAL_EXECUTOR"), new a());
                Field declaredField = AsyncTask.class.getDeclaredField("sDefaultExecutor");
                declaredField.setAccessible(true);
                declaredField.set(null, AsyncTask.SERIAL_EXECUTOR);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean b() {
        String str = Build.MODEL;
        return "5.1.1".equals(Build.VERSION.RELEASE) && str != null && str.contains("vivo V3Max");
    }

    public static void c(Field field, Object obj) throws Exception {
        field.setAccessible(true);
        Field declaredField = Field.class.getDeclaredField("artField");
        declaredField.setAccessible(true);
        Object obj2 = declaredField.get(field);
        Field declaredField2 = obj2.getClass().getDeclaredField("accessFlags");
        declaredField2.setAccessible(true);
        declaredField2.setInt(obj2, field.getModifiers() & (-17));
        field.set(null, obj);
    }
}
