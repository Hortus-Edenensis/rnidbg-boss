package com.xiaomi.push.service;

import android.os.SystemClock;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f11759a;
    private static long b;
    private static long c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final a f993a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final c f994a;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c f11760a;

        public a(c cVar) {
            this.f11760a = cVar;
        }

        public void finalize() throws Throwable {
            try {
                synchronized (this.f11760a) {
                    this.f11760a.c = true;
                    this.f11760a.notify();
                }
            } finally {
                super.finalize();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected int f11761a;

        public b(int i) {
            this.f11761a = i;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c extends Thread {

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        private boolean f997b;
        private boolean c;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private volatile long f11762a = 0;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private volatile boolean f996a = false;
        private long b = 50;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private a f995a = new a();

        /* JADX INFO: compiled from: SearchBox */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private int f11763a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            private d[] f998a;
            private int b;
            private int c;

            private a() {
                this.f11763a = 256;
                this.f998a = new d[256];
                this.b = 0;
                this.c = 0;
            }

            private void c() {
                int i = this.b - 1;
                int i2 = (i - 1) / 2;
                while (true) {
                    d[] dVarArr = this.f998a;
                    d dVar = dVarArr[i];
                    long j = dVar.f999a;
                    d dVar2 = dVarArr[i2];
                    if (j >= dVar2.f999a) {
                        return;
                    }
                    dVarArr[i] = dVar2;
                    dVarArr[i2] = dVar;
                    int i3 = i2;
                    i2 = (i2 - 1) / 2;
                    i = i3;
                }
            }

            public void b(int i) {
                int i2;
                if (i < 0 || i >= (i2 = this.b)) {
                    return;
                }
                d[] dVarArr = this.f998a;
                int i3 = i2 - 1;
                this.b = i3;
                dVarArr[i] = dVarArr[i3];
                dVarArr[i3] = null;
                c(i);
            }

            public d a() {
                return this.f998a[0];
            }

            /* JADX INFO: renamed from: a, reason: collision with other method in class */
            public boolean m762a() {
                return this.b == 0;
            }

            /* JADX INFO: renamed from: a, reason: collision with other method in class */
            public void m761a(d dVar) {
                d[] dVarArr = this.f998a;
                int length = dVarArr.length;
                int i = this.b;
                if (length == i) {
                    d[] dVarArr2 = new d[i * 2];
                    System.arraycopy(dVarArr, 0, dVarArr2, 0, i);
                    this.f998a = dVarArr2;
                }
                d[] dVarArr3 = this.f998a;
                int i2 = this.b;
                this.b = i2 + 1;
                dVarArr3[i2] = dVar;
                c();
            }

            public void b() {
                int i = 0;
                while (i < this.b) {
                    if (this.f998a[i].f1002a) {
                        this.c++;
                        b(i);
                        i--;
                    }
                    i++;
                }
            }

            private void c(int i) {
                int i2 = (i * 2) + 1;
                while (true) {
                    int i3 = this.b;
                    if (i2 >= i3 || i3 <= 0) {
                        return;
                    }
                    int i4 = i2 + 1;
                    if (i4 < i3) {
                        d[] dVarArr = this.f998a;
                        if (dVarArr[i4].f999a < dVarArr[i2].f999a) {
                            i2 = i4;
                        }
                    }
                    d[] dVarArr2 = this.f998a;
                    d dVar = dVarArr2[i];
                    long j = dVar.f999a;
                    d dVar2 = dVarArr2[i2];
                    if (j < dVar2.f999a) {
                        return;
                    }
                    dVarArr2[i] = dVar2;
                    dVarArr2[i2] = dVar;
                    int i5 = i2;
                    i2 = (i2 * 2) + 1;
                    i = i5;
                }
            }

            /* JADX INFO: renamed from: a, reason: collision with other method in class */
            public boolean m763a(int i) {
                for (int i2 = 0; i2 < this.b; i2++) {
                    if (this.f998a[i2].f11764a == i) {
                        return true;
                    }
                }
                return false;
            }

            public void a(int i) {
                for (int i2 = 0; i2 < this.b; i2++) {
                    d dVar = this.f998a[i2];
                    if (dVar.f11764a == i) {
                        dVar.a();
                    }
                }
                b();
            }

            public void a(int i, b bVar) {
                for (int i2 = 0; i2 < this.b; i2++) {
                    d dVar = this.f998a[i2];
                    if (dVar.f1000a == bVar) {
                        dVar.a();
                    }
                }
                b();
            }

            /* JADX INFO: renamed from: a, reason: collision with other method in class */
            public void m760a() {
                this.f998a = new d[this.f11763a];
                this.b = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public int a(d dVar) {
                int i = 0;
                while (true) {
                    d[] dVarArr = this.f998a;
                    if (i >= dVarArr.length) {
                        return -1;
                    }
                    if (dVarArr[i] == dVar) {
                        return i;
                    }
                    i++;
                }
            }
        }

        public c(String str, boolean z) {
            setName(str);
            setDaemon(z);
            start();
        }

        /* JADX WARN: Code restructure failed: missing block: B:53:0x0092, code lost:
        
            r10.f11762a = android.os.SystemClock.uptimeMillis();
            r10.f996a = true;
            r2.f1000a.run();
            r10.f996a = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x00a3, code lost:
        
            r1 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00a4, code lost:
        
            monitor-enter(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x00a5, code lost:
        
            r10.f997b = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x00a8, code lost:
        
            throw r1;
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            while (true) {
                synchronized (this) {
                    if (this.f997b) {
                        return;
                    }
                    if (!this.f995a.m762a()) {
                        long jA = n.a();
                        d dVarA = this.f995a.a();
                        synchronized (dVarA.f1001a) {
                            if (dVarA.f1002a) {
                                this.f995a.b(0);
                            } else {
                                long j = dVarA.f999a - jA;
                                if (j > 0) {
                                    long j2 = this.b;
                                    if (j > j2) {
                                        j = j2;
                                    }
                                    long j3 = j2 + 50;
                                    this.b = j3;
                                    if (j3 > 500) {
                                        this.b = 500L;
                                    }
                                    try {
                                        wait(j);
                                    } catch (InterruptedException unused) {
                                    }
                                } else {
                                    this.b = 50L;
                                    synchronized (dVarA.f1001a) {
                                        int iA = this.f995a.a().f999a != dVarA.f999a ? this.f995a.a(dVarA) : 0;
                                        if (dVarA.f1002a) {
                                            a aVar = this.f995a;
                                            aVar.b(aVar.a(dVarA));
                                        } else {
                                            dVarA.a(dVarA.f999a);
                                            this.f995a.b(iA);
                                            dVarA.f999a = 0L;
                                        }
                                    }
                                }
                            }
                        }
                    } else if (this.c) {
                        return;
                    } else {
                        try {
                            wait();
                        } catch (InterruptedException unused2) {
                        }
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(d dVar) {
            this.f995a.m761a(dVar);
            notify();
        }

        public synchronized void a() {
            this.f997b = true;
            this.f995a.m760a();
            notify();
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public boolean m759a() {
            return this.f996a && SystemClock.uptimeMillis() - this.f11762a > 600000;
        }
    }

    static {
        long jElapsedRealtime = SystemClock.elapsedRealtime() > 0 ? SystemClock.elapsedRealtime() : 0L;
        f11759a = jElapsedRealtime;
        b = jElapsedRealtime;
    }

    public n(String str, boolean z) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        c cVar = new c(str, z);
        this.f994a = cVar;
        this.f993a = new a(cVar);
    }

    public static synchronized long a() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = b;
        if (jElapsedRealtime > j) {
            f11759a += jElapsedRealtime - j;
        }
        b = jElapsedRealtime;
        return f11759a;
    }

    private static synchronized long b() {
        long j;
        j = c;
        c = 1 + j;
        return j;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public void m757b() {
        synchronized (this.f994a) {
            this.f994a.f995a.m760a();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f11764a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        long f999a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        b f1000a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        final Object f1001a = new Object();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        boolean f1002a;
        private long b;

        public void a(long j) {
            synchronized (this.f1001a) {
                this.b = j;
            }
        }

        public boolean a() {
            boolean z;
            synchronized (this.f1001a) {
                z = !this.f1002a && this.f999a > 0;
                this.f1002a = true;
            }
            return z;
        }
    }

    public n(String str) {
        this(str, false);
    }

    private void b(b bVar, long j) {
        synchronized (this.f994a) {
            if (!this.f994a.f997b) {
                long jA = j + a();
                if (jA >= 0) {
                    d dVar = new d();
                    dVar.f11764a = bVar.f11761a;
                    dVar.f1000a = bVar;
                    dVar.f999a = jA;
                    this.f994a.a(dVar);
                } else {
                    throw new IllegalArgumentException("Illegal delay to start the TimerTask: " + jA);
                }
            } else {
                throw new IllegalStateException("Timer was canceled");
            }
        }
    }

    public n(boolean z) {
        this("Timer-" + b(), z);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m754a() {
        com.xiaomi.channel.commonutils.logger.b.m74a("quit. finalizer:" + this.f993a);
        this.f994a.a();
    }

    public n() {
        this(false);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m756a(int i) {
        boolean zM763a;
        synchronized (this.f994a) {
            zM763a = this.f994a.f995a.m763a(i);
        }
        return zM763a;
    }

    public void a(int i) {
        synchronized (this.f994a) {
            this.f994a.f995a.a(i);
        }
    }

    public void a(int i, b bVar) {
        synchronized (this.f994a) {
            this.f994a.f995a.a(i, bVar);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m755a() {
        return this.f994a.m759a();
    }

    public void a(b bVar) {
        if (com.xiaomi.channel.commonutils.logger.b.a() < 1 && Thread.currentThread() != this.f994a) {
            com.xiaomi.channel.commonutils.logger.b.d("run job outside job job thread");
            throw new RejectedExecutionException("Run job outside job thread");
        }
        bVar.run();
    }

    public void a(b bVar, long j) {
        if (j >= 0) {
            b(bVar, j);
            return;
        }
        throw new IllegalArgumentException("delay < 0: " + j);
    }
}
