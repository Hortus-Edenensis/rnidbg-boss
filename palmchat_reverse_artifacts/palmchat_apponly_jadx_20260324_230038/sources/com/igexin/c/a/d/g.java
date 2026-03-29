package com.igexin.c.a.d;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.PowerManager;
import android.os.Process;
import androidx.core.app.NotificationCompat;
import com.igexin.push.d.c.k;
import com.igexin.push.d.c.o;
import com.igexin.push.g.n;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class g extends BroadcastReceiver implements Comparator<f> {
    public static final long E = TimeUnit.SECONDS.toMillis(2);
    protected static final String F = "AlarmTaskSchedule.";
    protected static final String G = "AlarmTaskScheduleBak.";
    protected static final String H = "AlarmNioTaskSchedule.";
    public static final String h = "TaskService";
    public static final String i = "com.igexin.c.a.d.g";
    static final byte j = -1;
    static final byte k = 0;
    static final byte l = 1;
    static final byte m = 2;
    static final byte n = -128;
    static final byte o = 7;
    public PendingIntent A;
    public String B;
    volatile long C;
    public volatile boolean D;
    public boolean t;
    public PowerManager v;
    public AlarmManager w;
    public Intent x;
    public PendingIntent y;
    public Intent z;
    final ReentrantLock u = new ReentrantLock();
    public boolean I = false;
    final HashMap<Long, com.igexin.c.a.d.a.c> q = new HashMap<>(7);
    public final e<f> s = new e<>(this, this);
    final d r = new d();
    public final b p = new b();

    /* JADX INFO: renamed from: com.igexin.c.a.d.g$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class AnonymousClass1 extends IntentFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f7060a;

        public AnonymousClass1(Context context) {
            this.f7060a = context;
            addAction(g.F + context.getPackageName());
            addAction(g.G + context.getPackageName());
            addAction("android.intent.action.SCREEN_OFF");
            addAction("android.intent.action.SCREEN_ON");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class a {
        volatile int g;
        final ReentrantLock c = new ReentrantLock();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final BlockingQueue<f> f7061a = new SynchronousQueue();
        final HashMap<Integer, RunnableC0464a> b = new HashMap<>();
        volatile long e = TimeUnit.SECONDS.toNanos(60);
        volatile int f = 0;
        ThreadFactory d = new b();
        volatile int h = Integer.MAX_VALUE;

        /* JADX INFO: renamed from: com.igexin.c.a.d.g$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public final class RunnableC0464a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final BlockingQueue<f> f7062a = new LinkedBlockingQueue();
            f b;
            f c;
            volatile int d;
            volatile boolean e;

            public RunnableC0464a(f fVar) {
                this.b = fVar;
            }

            private void a() {
                this.f7062a.clear();
                this.c = null;
            }

            private f b() {
                while (this.d != 0) {
                    try {
                        f fVarPoll = this.f7062a.poll(a.this.e, TimeUnit.NANOSECONDS);
                        if (fVarPoll != null) {
                            return fVarPoll;
                        }
                        if (this.f7062a.isEmpty()) {
                            ReentrantLock reentrantLock = a.this.c;
                            reentrantLock.lock();
                            try {
                                if (this.f7062a.isEmpty()) {
                                    a.this.b.remove(Integer.valueOf(this.d));
                                    this.d = 0;
                                    return null;
                                }
                            } finally {
                                reentrantLock.unlock();
                            }
                        } else {
                            continue;
                        }
                    } catch (InterruptedException e) {
                        com.igexin.c.a.c.a.a(e);
                    }
                }
                return null;
            }

            @Override // java.lang.Runnable
            public final void run() {
                boolean zA = true;
                while (zA) {
                    try {
                        try {
                            f fVarB = this.b;
                            this.b = null;
                            while (true) {
                                if (fVarB == null) {
                                    fVarB = b();
                                    if (fVarB == null && (fVarB = a.this.b()) == null) {
                                        zA = a.this.a(this);
                                        if (!zA) {
                                        }
                                    }
                                }
                                this.c = null;
                                if (this.d == 0) {
                                    this.d = fVarB.C;
                                }
                                f fVar = fVarB;
                                boolean z = true;
                                while (z) {
                                    try {
                                        try {
                                            fVar.b_();
                                            fVar.o();
                                            if (!fVar.v) {
                                                fVar.d_();
                                            }
                                        } catch (Exception e) {
                                            com.igexin.c.a.c.a.a(e);
                                            com.igexin.c.a.c.a.a(g.h + e.toString(), new Object[0]);
                                            fVar.v = true;
                                            fVar.E = e;
                                            fVar.p();
                                            fVar.l();
                                            g.this.a((Object) fVar);
                                            g.this.e();
                                            if (!fVar.v) {
                                                fVar.d_();
                                            }
                                            if (fVar.m || !fVar.p || fVar.w == 0) {
                                            }
                                        }
                                    } catch (Throwable th) {
                                        if (!fVar.v) {
                                            fVar.d_();
                                        }
                                        if (fVar.m || !fVar.p || fVar.w == 0) {
                                            throw th;
                                        }
                                    }
                                    if (fVar.m || !fVar.p || fVar.w == 0) {
                                        fVar = null;
                                        z = false;
                                    }
                                }
                                this.c = fVarB;
                                fVarB = null;
                            }
                            throw th;
                        } catch (Exception e2) {
                            com.igexin.c.a.c.a.a(e2);
                            com.igexin.c.a.c.a.a("TaskService|Worker|run()|error" + e2.toString(), new Object[0]);
                            zA = a.this.a(this);
                            if (!zA) {
                                a();
                            }
                        }
                    } catch (Throwable th2) {
                        if (!a.this.a(this)) {
                            a();
                        }
                        throw th2;
                    }
                }
            }

            private void a(f fVar) {
                if (this.d == 0) {
                    this.d = fVar.C;
                }
                boolean z = true;
                while (z) {
                    try {
                        try {
                            fVar.b_();
                            fVar.o();
                            if (!fVar.v) {
                                fVar.d_();
                            }
                        } catch (Exception e) {
                            com.igexin.c.a.c.a.a(e);
                            com.igexin.c.a.c.a.a(g.h + e.toString(), new Object[0]);
                            fVar.v = true;
                            fVar.E = e;
                            fVar.p();
                            fVar.l();
                            g.this.a((Object) fVar);
                            g.this.e();
                            if (!fVar.v) {
                                fVar.d_();
                            }
                            if (fVar.m || !fVar.p || fVar.w == 0) {
                            }
                        }
                    } finally {
                    }
                    if (fVar.m || !fVar.p || fVar.w == 0) {
                        fVar = null;
                        z = false;
                    }
                }
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public final class b implements ThreadFactory {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final AtomicInteger f7063a = new AtomicInteger(0);

            public b() {
            }

            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, "TS-pool-" + this.f7063a.incrementAndGet());
            }
        }

        public a() {
        }

        private void c(f fVar) {
            fVar.getClass();
            if (fVar.C != 0) {
                ReentrantLock reentrantLock = this.c;
                reentrantLock.lock();
                try {
                    RunnableC0464a runnableC0464a = this.b.get(Integer.valueOf(fVar.C));
                    if (runnableC0464a != null) {
                        runnableC0464a.f7062a.offer(fVar);
                        return;
                    }
                } finally {
                    reentrantLock.unlock();
                }
            }
            if (this.g >= this.f || !a(fVar)) {
                if (!this.f7061a.offer(fVar)) {
                    b(fVar);
                } else if (this.g == 0) {
                    a();
                }
            }
        }

        private void d(f fVar) {
            if (this.g >= this.f || !a(fVar)) {
                if (!this.f7061a.offer(fVar)) {
                    b(fVar);
                } else if (this.g == 0) {
                    a();
                }
            }
        }

        private Thread e(f fVar) {
            int i;
            RunnableC0464a runnableC0464a = new RunnableC0464a(fVar);
            if (fVar != null && (i = fVar.C) != 0) {
                this.b.put(Integer.valueOf(i), runnableC0464a);
            }
            Thread threadNewThread = this.d.newThread(runnableC0464a);
            if (threadNewThread != null) {
                this.g++;
            }
            return threadNewThread;
        }

        public final void a() {
            ReentrantLock reentrantLock = this.c;
            reentrantLock.lock();
            try {
                Thread threadE = null;
                if (this.g < Math.max(this.f, 1) && !this.f7061a.isEmpty()) {
                    threadE = e(null);
                }
                if (threadE != null) {
                    threadE.start();
                }
            } finally {
                reentrantLock.unlock();
            }
        }

        public final f b() {
            f fVarPoll;
            while (true) {
                try {
                    fVarPoll = this.g > this.f ? this.f7061a.poll(this.e, TimeUnit.NANOSECONDS) : this.f7061a.take();
                } catch (InterruptedException e) {
                    com.igexin.c.a.c.a.a(e);
                }
                if (fVarPoll != null) {
                    return fVarPoll;
                }
                if (this.f7061a.isEmpty()) {
                    return null;
                }
            }
        }

        public final boolean a(f fVar) {
            ReentrantLock reentrantLock = this.c;
            reentrantLock.lock();
            try {
                Thread threadE = this.g < this.f ? e(fVar) : null;
                if (threadE == null) {
                    return false;
                }
                threadE.start();
                return true;
            } finally {
                reentrantLock.unlock();
            }
        }

        public final boolean b(f fVar) {
            ReentrantLock reentrantLock = this.c;
            reentrantLock.lock();
            try {
                Thread threadE = this.g < this.h ? e(fVar) : null;
                if (threadE == null) {
                    return false;
                }
                threadE.start();
                return true;
            } finally {
                reentrantLock.unlock();
            }
        }

        public final boolean a(RunnableC0464a runnableC0464a) {
            ReentrantLock reentrantLock = this.c;
            reentrantLock.lock();
            try {
                int i = this.g - 1;
                this.g = i;
                if (i == 0 && !this.f7061a.isEmpty()) {
                    Thread threadE = e(null);
                    if (threadE != null) {
                        threadE.start();
                    }
                } else if (!runnableC0464a.f7062a.isEmpty()) {
                    return true;
                }
                this.b.remove(Integer.valueOf(runnableC0464a.d));
                reentrantLock.unlock();
                return false;
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public g() {
        f.H = this;
    }

    private static int a(f fVar, f fVar2) {
        if (fVar.w < fVar2.w) {
            return -1;
        }
        if (fVar.w > fVar2.w) {
            return 1;
        }
        int i2 = fVar.D;
        int i3 = fVar2.D;
        if (i2 > i3) {
            return -1;
        }
        if (i2 < i3) {
            return 1;
        }
        if (fVar.x < fVar2.x) {
            return -1;
        }
        if (fVar.x > fVar2.x) {
            return 1;
        }
        return fVar.hashCode() - fVar2.hashCode();
    }

    @TargetApi(19)
    private void b(long j2) {
        if (n.l()) {
            return;
        }
        com.igexin.c.a.c.a.a("setnioalarm|" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(j2)), new Object[0]);
        if (j2 < 0) {
            j2 = System.currentTimeMillis() + E;
        }
        try {
            int i2 = Build.VERSION.SDK_INT;
            try {
                if (this.t) {
                    this.w.setExact(0, j2, this.A);
                } else if (i2 > 23) {
                    this.w.setAndAllowWhileIdle(0, j2, this.y);
                } else {
                    this.w.set(0, j2, this.A);
                }
            } catch (Exception unused) {
                this.w.set(0, j2, this.A);
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(h, th.toString());
        }
    }

    @Override // java.util.Comparator
    public /* synthetic */ int compare(f fVar, f fVar2) {
        f fVar3 = fVar;
        f fVar4 = fVar2;
        if (fVar3.w < fVar4.w) {
            return -1;
        }
        if (fVar3.w > fVar4.w) {
            return 1;
        }
        int i2 = fVar3.D;
        int i3 = fVar4.D;
        if (i2 > i3) {
            return -1;
        }
        if (i2 < i3) {
            return 1;
        }
        if (fVar3.x < fVar4.x) {
            return -1;
        }
        if (fVar3.x > fVar4.x) {
            return 1;
        }
        return fVar3.hashCode() - fVar4.hashCode();
    }

    public final void d() {
        try {
            PendingIntent pendingIntent = this.A;
            if (pendingIntent != null) {
                this.w.cancel(pendingIntent);
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(h, th.toString());
        }
    }

    public final void e() {
        b bVar = this.p;
        if (bVar == null || bVar.isInterrupted()) {
            return;
        }
        this.p.interrupt();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ac A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0000 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void f() {
        com.igexin.c.a.d.a.e eVarD;
        boolean zA;
        int iC;
        int iC2;
        boolean zA2;
        int iC3;
        while (!this.r.c() && (eVarD = this.r.d()) != null) {
            eVarD.a(true);
            ReentrantLock reentrantLock = this.u;
            reentrantLock.lock();
            try {
            } catch (Throwable th) {
                th = th;
                zA = false;
            }
            if (!this.q.isEmpty()) {
                long jK = eVarD.k();
                if (jK != 0) {
                    com.igexin.c.a.d.a.c cVar = this.q.get(Long.valueOf(jK));
                    zA2 = cVar != null ? a(eVarD, cVar) : false;
                } else {
                    Iterator<com.igexin.c.a.d.a.c> it = this.q.values().iterator();
                    zA = false;
                    while (it.hasNext() && !(zA = a(eVarD, it.next()))) {
                        try {
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                com.igexin.c.a.c.a.a(th);
                                com.igexin.c.a.c.a.a(h, th.toString());
                                com.igexin.c.a.c.a.a("TaskService|" + th.toString(), new Object[0]);
                                if (!zA && (iC2 = eVarD.c()) > Integer.MIN_VALUE && iC2 < 0) {
                                }
                                reentrantLock.unlock();
                                if (!(eVarD instanceof k)) {
                                }
                            } catch (Throwable th3) {
                                if (!zA && (iC = eVarD.c()) > Integer.MIN_VALUE && iC < 0) {
                                    ((f) eVarD).d_();
                                }
                                reentrantLock.unlock();
                                throw th3;
                            }
                        }
                    }
                    zA2 = zA;
                }
                if (!zA2 && (iC3 = eVarD.c()) > Integer.MIN_VALUE && iC3 < 0) {
                    ((f) eVarD).d_();
                }
            }
            reentrantLock.unlock();
            if (!(eVarD instanceof k)) {
                this.r.b();
                com.igexin.c.a.c.a.a("TaskService|queue -> secondRespQueue", new Object[0]);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
            this.D = true;
            com.igexin.c.a.c.a.a("screenoff", new Object[0]);
            if (this.s.g.get() > 0) {
                a(this.s.g.get());
                return;
            }
            return;
        }
        if ("android.intent.action.SCREEN_ON".equals(intent.getAction())) {
            this.D = false;
            com.igexin.c.a.c.a.a("screenon", new Object[0]);
            return;
        }
        if (intent.getAction().startsWith(F) || intent.getAction().startsWith(G)) {
            Calendar.getInstance().getTime().toLocaleString();
            com.igexin.c.a.c.a.a("receivealarm|" + this.D, new Object[0]);
            e();
            return;
        }
        if (this.B.equals(intent.getAction())) {
            Calendar calendar = Calendar.getInstance();
            com.igexin.c.a.c.a.b(i, "CPU ON + NioAlarmReceiver:-> cTime; " + calendar.getTime().toLocaleString());
            try {
                com.igexin.c.a.c.a.a(h, " alarm time out #######");
                com.igexin.c.a.c.a.a("TaskService|alarm time out #######", new Object[0]);
                com.igexin.c.a.b.a.a.d.a().f();
            } catch (Exception e) {
                com.igexin.c.a.c.a.a(e);
            }
        }
    }

    private void a() {
        try {
            PendingIntent pendingIntent = this.y;
            if (pendingIntent != null) {
                this.w.cancel(pendingIntent);
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(h, th.toString());
        }
    }

    private boolean b() {
        e<f> eVar = this.s;
        if (eVar == null) {
            return false;
        }
        eVar.c.clear();
        return true;
    }

    private void a(int i2, TimeUnit timeUnit) {
        this.p.b = TimeUnit.MILLISECONDS.convert(i2, timeUnit);
    }

    @TargetApi(19)
    public final void a(long j2) {
        if (this.D) {
            com.igexin.c.a.c.a.a("setalarm|" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(j2)), new Object[0]);
            if (j2 < 0) {
                j2 = System.currentTimeMillis() + E;
            }
            try {
                PendingIntent pendingIntent = this.y;
                if (pendingIntent != null) {
                    int i2 = Build.VERSION.SDK_INT;
                    try {
                        if (this.t) {
                            this.w.setExact(0, j2, pendingIntent);
                        } else if (i2 > 23) {
                            this.w.setAndAllowWhileIdle(0, j2, pendingIntent);
                        } else {
                            this.w.set(0, j2, pendingIntent);
                        }
                    } catch (Throwable unused) {
                        this.w.set(0, j2, this.y);
                    }
                }
            } catch (Throwable th) {
                com.igexin.c.a.c.a.a(h, th.toString());
                com.igexin.c.a.c.a.a(h + th.toString(), new Object[0]);
            }
        }
    }

    private void a(Context context) {
        if (this.I) {
            return;
        }
        if (!n.l()) {
            this.v = (PowerManager) context.getSystemService("power");
            this.D = true;
            this.w = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            try {
                if (Build.VERSION.SDK_INT >= 31) {
                    this.t = ((Boolean) AlarmManager.class.getDeclaredMethod("canScheduleExactAlarms", new Class[0]).invoke(this.w, new Object[0])).booleanValue();
                } else {
                    this.t = true;
                }
            } catch (Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(context);
            int i2 = Build.VERSION.SDK_INT;
            if (i2 > 33) {
                context.registerReceiver(this, anonymousClass1, com.igexin.push.core.e.ac, null, 4);
            } else {
                context.registerReceiver(this, anonymousClass1, com.igexin.push.core.e.ac, null);
            }
            this.B = H + context.getPackageName();
            if (i2 > 33) {
                context.registerReceiver(this, new IntentFilter(this.B), com.igexin.push.core.e.ac, null, 4);
            } else {
                context.registerReceiver(this, new IntentFilter(this.B), com.igexin.push.core.e.ac, null);
            }
            int i3 = (n.a(context) < 31 || i2 < 30) ? 134217728 : 201326592;
            this.x = new Intent(F + context.getPackageName());
            this.y = PendingIntent.getBroadcast(context, hashCode(), this.x, i3);
            hashCode();
            this.z = new Intent(this.B);
            this.A = PendingIntent.getBroadcast(context, hashCode() + 2, this.z, i3);
            hashCode();
        }
        this.p.start();
        try {
            Thread.yield();
        } catch (Throwable th2) {
            com.igexin.c.a.c.a.a(th2);
        }
        this.I = true;
    }

    public final boolean a(com.igexin.c.a.d.a.c cVar) {
        ReentrantLock reentrantLock = this.u;
        if (reentrantLock.tryLock()) {
            try {
                if (this.q.containsKey(Long.valueOf(cVar.g()))) {
                    return false;
                }
                this.q.put(Long.valueOf(cVar.g()), cVar);
                reentrantLock.unlock();
                return true;
            } catch (Throwable th) {
                try {
                    com.igexin.c.a.c.a.a(th);
                    com.igexin.c.a.c.a.a("TaskService|" + th.toString(), new Object[0]);
                } finally {
                    reentrantLock.unlock();
                }
            }
        }
        return false;
    }

    private static boolean a(com.igexin.c.a.d.a.e eVar, com.igexin.c.a.d.a.c cVar) {
        int iC = eVar.c();
        if (iC <= Integer.MIN_VALUE || iC >= 0) {
            if (iC < 0 || iC >= Integer.MAX_VALUE) {
                return false;
            }
            return cVar.a(eVar);
        }
        f fVar = (f) eVar;
        boolean zA = fVar.v ? false : cVar.a(eVar);
        if (zA) {
            fVar.d_();
        }
        return zA;
    }

    private boolean a(f fVar) {
        e<f> eVar = this.s;
        return eVar != null && eVar.c(fVar);
    }

    public final boolean a(f fVar, boolean z) {
        fVar.getClass();
        int iIncrementAndGet = 0;
        if (fVar.q || fVar.m) {
            return false;
        }
        e<f> eVar = this.s;
        if ((fVar instanceof com.igexin.c.a.b.f) && (((com.igexin.c.a.b.f) fVar).d instanceof o)) {
            if (z) {
                iIncrementAndGet = Integer.MAX_VALUE;
            }
        } else if (z) {
            iIncrementAndGet = eVar.d.incrementAndGet();
        }
        fVar.D = iIncrementAndGet;
        return eVar.a(fVar);
    }

    private boolean a(f fVar, boolean z, int i2, long j2, byte b2, Object obj, com.igexin.c.a.d.a.d dVar, int i3, com.igexin.c.a.d.a.g gVar) {
        fVar.getClass();
        fVar.A = i2;
        fVar.a((int) b2);
        fVar.F = obj;
        fVar.O = dVar;
        fVar.a(j2, TimeUnit.MILLISECONDS);
        fVar.a(i3, gVar);
        return a(fVar, z);
    }

    public final boolean a(f fVar, boolean z, boolean z2) {
        fVar.getClass();
        boolean z3 = false;
        if (fVar.n) {
            return false;
        }
        if (!z || z2) {
            if (z2 && z) {
                z3 = true;
            }
            return a(fVar, z3);
        }
        fVar.d();
        try {
            try {
                fVar.b_();
                fVar.o();
                if (!fVar.v) {
                    fVar.d_();
                }
                return true;
            } catch (Exception e) {
                com.igexin.c.a.c.a.a(e);
                fVar.v = true;
                fVar.E = e;
                fVar.l();
                fVar.p();
                a((Object) fVar);
                e();
                if (!fVar.v) {
                    fVar.d_();
                }
                return false;
            }
        } catch (Throwable th) {
            if (!fVar.v) {
                fVar.d_();
            }
            throw th;
        }
    }

    private boolean a(Class cls) {
        e<f> eVar = this.s;
        return eVar != null && eVar.a(cls);
    }

    public final boolean a(Object obj) {
        if (obj == null) {
            return false;
        }
        obj.hashCode();
        try {
            if (obj instanceof com.igexin.push.d.c.n) {
                obj.hashCode();
            }
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
        }
        obj.hashCode();
        com.igexin.c.a.c.a.a("TaskService|responseQueue ++ task = " + obj.getClass().getName() + "@" + obj.hashCode(), new Object[0]);
        if (!(obj instanceof com.igexin.c.a.d.a.e)) {
            throw new ClassCastException("response Obj is not a TaskResult ");
        }
        com.igexin.c.a.d.a.e eVar = (com.igexin.c.a.d.a.e) obj;
        if (eVar.j()) {
            return false;
        }
        eVar.a(false);
        if ((obj instanceof com.igexin.push.d.b.a) || (obj instanceof com.igexin.push.d.b.b)) {
            this.r.a();
            com.igexin.c.a.c.a.a("TaskService|change to primaryQueue", new Object[0]);
        }
        this.r.a(eVar);
        return true;
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class b extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        volatile boolean f7064a = true;
        long b;
        long c;
        a d;

        public b() {
            setName("TS-processor");
        }

        /* JADX WARN: Can't wrap try/catch for region: R(11:(4:(2:(3:127|11|(2:133|130)(3:119|79|123))|122)|95|68|(2:72|(4:128|78|131|130)(4:129|77|132|130))(4:120|79|123|122))(6:99|14|(5:117|16|(1:18)|19|(5:21|97|22|121|(4:105|24|25|116)(2:103|26))(1:102))(2:40|(4:118|44|124|122))|3|4|(1:5))|93|46|47|(1:49)|50|(2:52|(1:54))|55|95|68|(0)(0)) */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x006a, code lost:
        
            if (r4.g >= r4.f) goto L106;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0070, code lost:
        
            if (r4.a(r5) != false) goto L112;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0078, code lost:
        
            if (r4.f7061a.offer(r5) == false) goto L108;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x007c, code lost:
        
            if (r4.g != 0) goto L114;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x007e, code lost:
        
            r4.a();
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0082, code lost:
        
            r4.b(r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x00e0, code lost:
        
            r4 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x00e1, code lost:
        
            com.igexin.c.a.c.a.a(r4);
            com.igexin.c.a.c.a.a(com.igexin.c.a.d.g.h, r4.toString());
            com.igexin.c.a.c.a.a("TaskService|SERVICE_PROCESSING|error|" + r4.toString(), new java.lang.Object[0]);
            r5.v = true;
            r5.E = r4;
            r5.p();
            r5.l();
            r13.e.r.a(r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x0113, code lost:
        
            r13.e.f();
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x011a, code lost:
        
            if (r5.v == false) goto L62;
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x011c, code lost:
        
            r5.d_();
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x0121, code lost:
        
            if (r5.m == false) goto L65;
         */
        /* JADX WARN: Removed duplicated region for block: B:120:0x0142 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:72:0x0133  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0012  */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void run() {
            Process.setThreadPriority(-2);
            e<f> eVar = g.this.s;
            while (true) {
                f fVarA = null;
                while (true) {
                    byte b = 1;
                    while (this.f7064a) {
                        try {
                            if (b != -1) {
                                if (b != 0) {
                                    if (b != 1) {
                                        if (b == 2) {
                                            g.this.f();
                                        }
                                    }
                                }
                                fVarA = eVar.a();
                                fVarA.getClass();
                                if (fVarA == null) {
                                    g.this.f();
                                } else if (fVarA.m || fVarA.n) {
                                    fVarA = null;
                                } else {
                                    b = -1;
                                }
                            } else {
                                try {
                                    fVarA.d();
                                    fVarA.hashCode();
                                } catch (Exception e) {
                                    com.igexin.c.a.c.a.a(e);
                                    com.igexin.c.a.c.a.a("TaskService|TASK_INIT|error|" + e.toString(), new Object[0]);
                                }
                                if (fVarA.m()) {
                                    if (this.d == null) {
                                        this.d = g.this.new a();
                                    }
                                    a aVar = this.d;
                                    if (fVarA.C == 0) {
                                        break;
                                    }
                                    ReentrantLock reentrantLock = aVar.c;
                                    reentrantLock.lock();
                                    try {
                                        a.RunnableC0464a runnableC0464a = aVar.b.get(Integer.valueOf(fVarA.C));
                                        if (runnableC0464a != null) {
                                            runnableC0464a.f7062a.offer(fVarA);
                                            reentrantLock.unlock();
                                        } else {
                                            reentrantLock.unlock();
                                        }
                                    } catch (Throwable th) {
                                        reentrantLock.unlock();
                                        throw th;
                                    }
                                } else if (fVarA.p && fVarA.w == 0) {
                                    com.igexin.c.a.c.a.a(g.h, fVarA + "|isBlock = false|cycyle = true|doTime = 0, invalid ###########");
                                    com.igexin.c.a.c.a.a("TaskService|" + fVarA + "|isBlock = false|cycyle = true|doTime = 0, invalid ###########", new Object[0]);
                                }
                                f fVarA2 = null;
                                byte b2 = 1;
                                while (this.f7064a) {
                                }
                            }
                            fVarA2.b_();
                            fVarA2.o();
                            fVarA2 = null;
                            b2 = 1;
                            fVarA2 = eVar.a();
                            fVarA2.getClass();
                            if (fVarA2 == null) {
                            }
                        } finally {
                            g.this.f();
                            if (!fVarA2.v) {
                                fVarA2.d_();
                            }
                            if (!fVarA2.m && !fVarA2.q) {
                                fVarA2.D = 0;
                                eVar.a(fVarA2);
                            }
                        }
                    }
                    eVar.c.clear();
                    return;
                }
            }
        }

        private static void a() {
        }
    }
}
