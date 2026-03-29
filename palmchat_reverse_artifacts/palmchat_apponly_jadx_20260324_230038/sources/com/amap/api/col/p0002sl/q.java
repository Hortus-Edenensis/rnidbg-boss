package com.amap.api.col.p0002sl;

import com.amap.api.maps2d.AMapException;
import com.amap.api.maps2d.MapsInitializer;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
abstract class q<T, V> extends bf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected bx<T> f3043a;
    private volatile boolean c;
    private Vector<Thread> d;
    private Runnable e;
    private Runnable f;
    private bz g;

    public q(bi biVar) {
        super(biVar);
        this.c = true;
        this.d = null;
        this.e = new Runnable() { // from class: com.amap.api.col.2sl.q.1
            @Override // java.lang.Runnable
            public final void run() {
                bx<T> bxVar;
                Thread threadCurrentThread = Thread.currentThread();
                if (threadCurrentThread != null) {
                    threadCurrentThread.setName("TaskRunDownLoad");
                }
                try {
                    if (q.this.d != null) {
                        q.this.d.add(threadCurrentThread);
                    }
                    ArrayList<T> arrayListA = null;
                    ArrayList<T> arrayListA2 = null;
                    while (q.this.c && !Thread.interrupted()) {
                        q qVar = q.this;
                        if (qVar.b == null) {
                            q.c(qVar);
                        } else if (MapsInitializer.getNetworkEnable()) {
                            bx<T> bxVar2 = q.this.f3043a;
                            if (bxVar2 != null) {
                                arrayListA = bxVar2.a(false);
                            }
                            if (arrayListA == null || arrayListA.size() != 0) {
                                if (!q.this.c) {
                                    return;
                                }
                                if (arrayListA != null) {
                                    if (!q.this.c) {
                                        return;
                                    }
                                    q qVar2 = q.this;
                                    if (qVar2.b != null) {
                                        try {
                                            arrayListA2 = qVar2.a(arrayListA);
                                        } catch (AMapException e) {
                                            ct.a(e, "AsyncServer", "run");
                                        }
                                        if (arrayListA2 != null && (bxVar = q.this.f3043a) != null) {
                                            bxVar.a((List) arrayListA2, false);
                                        }
                                    }
                                }
                                if (q.this.c && !Thread.interrupted()) {
                                    try {
                                        try {
                                            Thread.sleep(50L);
                                        } catch (InterruptedException unused) {
                                            Thread.currentThread().interrupt();
                                        }
                                    } catch (Exception e2) {
                                        ct.a(e2, "AsyncServer", "run");
                                    }
                                }
                            }
                        } else {
                            try {
                                if (!Thread.interrupted()) {
                                    Thread.sleep(200L);
                                }
                            } catch (InterruptedException unused2) {
                                Thread.currentThread().interrupt();
                            } catch (Exception e3) {
                                ct.a(e3, "AsyncServer", "run");
                                Thread.currentThread().interrupt();
                            }
                        }
                    }
                } catch (Throwable th) {
                    ct.a(th, "AsyncServer", "run");
                }
            }
        };
        this.f = new Runnable() { // from class: com.amap.api.col.2sl.q.2
            @Override // java.lang.Runnable
            public final void run() {
                Thread threadCurrentThread = Thread.currentThread();
                if (threadCurrentThread != null) {
                    threadCurrentThread.setName("TaskRunCach");
                }
                try {
                    if (q.this.d != null && threadCurrentThread != null) {
                        q.this.d.add(threadCurrentThread);
                    }
                    ArrayList<T> arrayListA = null;
                    ArrayList<T> arrayListB = null;
                    while (q.this.c && !Thread.interrupted()) {
                        q qVar = q.this;
                        if (qVar.b == null) {
                            q.c(qVar);
                        } else {
                            bx<T> bxVar = qVar.f3043a;
                            if (bxVar != null) {
                                arrayListA = bxVar.a(true);
                            }
                            if (arrayListA == null || arrayListA.size() != 0) {
                                if (!q.this.c) {
                                    return;
                                }
                                try {
                                    arrayListB = q.this.b(arrayListA);
                                } catch (Throwable th) {
                                    ct.a(th, "AsyncServer", "run");
                                }
                                if (arrayListB != null && q.this.f3043a != null && ct.a(ba.f2628a)) {
                                    q.this.f3043a.a((List) arrayListB, false);
                                }
                                if (q.this.c && !Thread.interrupted()) {
                                    try {
                                        Thread.sleep(50L);
                                    } catch (InterruptedException unused) {
                                        Thread.currentThread().interrupt();
                                    } catch (Throwable th2) {
                                        ct.a(th2, "AsyncServer", "run");
                                    }
                                }
                            }
                        }
                    }
                } catch (Throwable th3) {
                    ct.a(th3, "AsyncServer", "run");
                }
            }
        };
    }

    public static /* synthetic */ boolean c(q qVar) {
        qVar.c = false;
        return false;
    }

    public abstract ArrayList<T> a(ArrayList<T> arrayList) throws AMapException;

    public abstract ArrayList<T> b(ArrayList<T> arrayList) throws AMapException;

    @Override // com.amap.api.col.p0002sl.bf
    public final void d() {
        if (this.c) {
            return;
        }
        this.c = true;
        if (this.d == null) {
            this.d = new Vector<>();
        }
        if (this.g == null) {
            bz bzVar = new bz(this.f, this.e);
            this.g = bzVar;
            bzVar.a();
        }
    }

    public final void e() {
        try {
            this.c = false;
            Vector<Thread> vector = this.d;
            if (vector != null) {
                int size = vector.size();
                for (int i = 0; i < size; i++) {
                    Thread thread = this.d.get(0);
                    if (thread != null) {
                        thread.interrupt();
                        this.d.remove(0);
                    }
                }
                this.d = null;
            }
            bz bzVar = this.g;
            if (bzVar != null) {
                bzVar.b();
                this.g = null;
            }
        } catch (Throwable th) {
            ct.a(th, "AsyncServer", "stopThreads");
        }
    }

    public final void a() {
        if (this.d == null) {
            this.d = new Vector<>();
        }
        bz bzVar = new bz(this.f, this.e);
        this.g = bzVar;
        bzVar.a();
    }

    @Override // com.amap.api.col.p0002sl.bf
    public void b() {
        bx<T> bxVar = this.f3043a;
        if (bxVar != null) {
            bxVar.a();
        }
        e();
        bx<T> bxVar2 = this.f3043a;
        if (bxVar2 != null) {
            bxVar2.b();
        }
        this.f3043a = null;
        this.f = null;
        this.e = null;
        this.b = null;
    }

    @Override // com.amap.api.col.p0002sl.bf
    public final void c() {
        super.c();
        e();
    }
}
