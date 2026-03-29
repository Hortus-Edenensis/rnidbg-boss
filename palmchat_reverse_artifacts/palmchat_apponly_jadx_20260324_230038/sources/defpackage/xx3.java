package defpackage;

import defpackage.x25;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.schedulers.ScheduledAction;
import rx.internal.util.RxThreadFactory;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class xx3 extends x25.a {
    public static final boolean c;
    public static volatile Object g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f22077a;
    public volatile boolean b;
    public static final Object h = new Object();
    public static final ConcurrentHashMap<ScheduledThreadPoolExecutor, ScheduledThreadPoolExecutor> e = new ConcurrentHashMap<>();
    public static final AtomicReference<ScheduledExecutorService> f = new AtomicReference<>();
    public static final int d = Integer.getInteger("rx.scheduler.jdk6.purge-frequency-millis", 1000).intValue();

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            xx3.e();
        }
    }

    static {
        boolean z = Boolean.getBoolean("rx.scheduler.jdk6.purge-force");
        int iA = ej4.a();
        c = !z && (iA == 0 || iA >= 21);
    }

    public xx3(ThreadFactory threadFactory) {
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        if (!j(scheduledExecutorServiceNewScheduledThreadPool) && (scheduledExecutorServiceNewScheduledThreadPool instanceof ScheduledThreadPoolExecutor)) {
            f((ScheduledThreadPoolExecutor) scheduledExecutorServiceNewScheduledThreadPool);
        }
        this.f22077a = scheduledExecutorServiceNewScheduledThreadPool;
    }

    public static void c(ScheduledExecutorService scheduledExecutorService) {
        e.remove(scheduledExecutorService);
    }

    public static Method d(ScheduledExecutorService scheduledExecutorService) {
        for (Method method : scheduledExecutorService.getClass().getMethods()) {
            if (method.getName().equals("setRemoveOnCancelPolicy")) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1 && parameterTypes[0] == Boolean.TYPE) {
                    return method;
                }
            }
        }
        return null;
    }

    public static void e() {
        try {
            Iterator<ScheduledThreadPoolExecutor> it = e.keySet().iterator();
            while (it.hasNext()) {
                ScheduledThreadPoolExecutor next = it.next();
                if (next.isShutdown()) {
                    it.remove();
                } else {
                    next.purge();
                }
            }
        } catch (Throwable th) {
            yn1.d(th);
            kz4.g(th);
        }
    }

    public static void f(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        while (true) {
            AtomicReference<ScheduledExecutorService> atomicReference = f;
            if (atomicReference.get() != null) {
                break;
            }
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, new RxThreadFactory("RxSchedulerPurge-"));
            if (g23.a(atomicReference, null, scheduledExecutorServiceNewScheduledThreadPool)) {
                a aVar = new a();
                int i = d;
                scheduledExecutorServiceNewScheduledThreadPool.scheduleAtFixedRate(aVar, i, i, TimeUnit.MILLISECONDS);
                break;
            }
            scheduledExecutorServiceNewScheduledThreadPool.shutdownNow();
        }
        e.putIfAbsent(scheduledThreadPoolExecutor, scheduledThreadPoolExecutor);
    }

    public static boolean j(ScheduledExecutorService scheduledExecutorService) {
        Method methodD;
        if (c) {
            if (scheduledExecutorService instanceof ScheduledThreadPoolExecutor) {
                Object obj = g;
                Object obj2 = h;
                if (obj == obj2) {
                    return false;
                }
                if (obj == null) {
                    methodD = d(scheduledExecutorService);
                    if (methodD != null) {
                        obj2 = methodD;
                    }
                    g = obj2;
                } else {
                    methodD = (Method) obj;
                }
            } else {
                methodD = d(scheduledExecutorService);
            }
            if (methodD != null) {
                try {
                    methodD.invoke(scheduledExecutorService, Boolean.TRUE);
                    return true;
                } catch (IllegalAccessException e2) {
                    kz4.g(e2);
                } catch (IllegalArgumentException e3) {
                    kz4.g(e3);
                } catch (InvocationTargetException e4) {
                    kz4.g(e4);
                }
            }
        }
        return false;
    }

    @Override // x25.a
    public zm5 a(b5 b5Var) {
        return b(b5Var, 0L, null);
    }

    @Override // x25.a
    public zm5 b(b5 b5Var, long j, TimeUnit timeUnit) {
        return this.b ? cn5.c() : g(b5Var, j, timeUnit);
    }

    public ScheduledAction g(b5 b5Var, long j, TimeUnit timeUnit) {
        ScheduledAction scheduledAction = new ScheduledAction(kz4.m(b5Var));
        scheduledAction.add(j <= 0 ? this.f22077a.submit(scheduledAction) : this.f22077a.schedule(scheduledAction, j, timeUnit));
        return scheduledAction;
    }

    public ScheduledAction h(b5 b5Var, long j, TimeUnit timeUnit, hk0 hk0Var) {
        ScheduledAction scheduledAction = new ScheduledAction(kz4.m(b5Var), hk0Var);
        hk0Var.a(scheduledAction);
        scheduledAction.add(j <= 0 ? this.f22077a.submit(scheduledAction) : this.f22077a.schedule(scheduledAction, j, timeUnit));
        return scheduledAction;
    }

    public ScheduledAction i(b5 b5Var, long j, TimeUnit timeUnit, bn5 bn5Var) {
        ScheduledAction scheduledAction = new ScheduledAction(kz4.m(b5Var), bn5Var);
        bn5Var.a(scheduledAction);
        scheduledAction.add(j <= 0 ? this.f22077a.submit(scheduledAction) : this.f22077a.schedule(scheduledAction, j, timeUnit));
        return scheduledAction;
    }

    @Override // defpackage.zm5
    public boolean isUnsubscribed() {
        return this.b;
    }

    @Override // defpackage.zm5
    public void unsubscribe() {
        this.b = true;
        this.f22077a.shutdownNow();
        c(this.f22077a);
    }
}
