package com.opos.mobad.f.a.a;

import android.os.SystemClock;
import com.opos.mobad.c.a.d;
import com.opos.mobad.f.a.a.p;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class c<T extends p> extends com.opos.mobad.m.j implements n, p, q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f8801a;
    private T b;
    private volatile T c;
    private volatile boolean d;
    private volatile boolean g;
    private a<T> h;
    private int i;

    /* JADX INFO: compiled from: SearchBox */
    public interface a<T extends p> {
        int a(int i);

        T a(List<d.a> list, d.a aVar, long j);

        T a(List<d.a> list, d.a aVar, long j, int i);
    }

    public c(String str, int i, a<T> aVar) {
        super(null);
        this.d = false;
        this.g = false;
        this.f8801a = str;
        this.i = i;
        this.h = aVar;
        this.b = (T) r();
        q();
    }

    private static d.a a(String str, List<d.a> list, d.a aVar, long j) {
        boolean z;
        boolean z2 = false;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        loop0: while (true) {
            for (d.a aVar2 : list) {
                i2 = aVar2.i;
                i3 = aVar2.j;
                int i4 = aVar2.k;
                i += i4;
                z2 = z2 || d.a.f8585a == aVar2.f;
                z = z || (aVar != null && aVar.f == aVar2.f && i4 > 0);
            }
        }
        if (!z2 && i < 100) {
            list.add(new d.a(d.a.f8585a, str, 100 - i, j, i2, i3));
            z2 = true;
        }
        if (!z && aVar != null) {
            return aVar;
        }
        if (z2) {
            return null;
        }
        return new d.a(d.a.f8585a, str, 100, j, i2, i3);
    }

    private void m() {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.f.a.a.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.q();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        d.b bVarA = a(0L);
        if (bVarA != null) {
            c(bVarA);
        }
    }

    private T r() {
        return (T) this.h.a(new ArrayList(), d(this.f8801a), 0L);
    }

    @Override // com.opos.mobad.f.a.a.p
    public void e(int i) {
        this.b.e(i);
    }

    @Override // com.opos.mobad.f.a.a.q
    public List g() {
        T t = this.b;
        if (!(t instanceof q)) {
            return null;
        }
        ((q) t).g();
        return null;
    }

    @Override // com.opos.mobad.f.a.a.p
    public com.opos.mobad.ad.b h() {
        return this.b.h();
    }

    @Override // com.opos.mobad.f.a.a.p
    public com.opos.mobad.ad.b i() {
        return this.b.i();
    }

    @Override // com.opos.mobad.f.a.a.p
    public int j() {
        return this.b.j();
    }

    @Override // com.opos.mobad.f.a.a.p
    public d.a k() {
        return this.b.k();
    }

    private static d.a a(List<d.a> list, String str, long j) {
        if (list == null) {
            list = new ArrayList<>();
        }
        d.a aVar = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (d.a aVar2 : list) {
            if (d.a.f8585a == aVar2.f) {
                aVar = aVar2;
            }
            i2 = aVar2.i;
            i3 = aVar2.j;
            i += aVar2.k;
        }
        if (aVar != null) {
            return aVar;
        }
        d.a aVar3 = new d.a(d.a.f8585a, str, Math.max(0, 100 - i), j, i2, i3);
        list.add(aVar3);
        return aVar3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d.b b(d.b bVar) {
        if (bVar == null) {
            return null;
        }
        List<d.a> list = bVar.f8586a;
        if (list == null || list.size() <= 0) {
            return bVar;
        }
        ArrayList arrayList = new ArrayList();
        a<T> aVar = this.h;
        if (aVar != null) {
            for (d.a aVar2 : bVar.f8586a) {
                if (aVar2 != null && aVar.a(aVar2.f) == 0) {
                    arrayList.add(aVar2);
                }
            }
        }
        return new d.b(arrayList, bVar.e, bVar.b, bVar.c, bVar.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c(d.b bVar) {
        T t;
        com.opos.cmn.an.f.a.b("dispatcherW", "initDispatcher:" + this.g + "," + this.d, bVar);
        if (this.g) {
            return;
        }
        if (this.d) {
            return;
        }
        List<d.a> list = bVar.f8586a;
        if (list != null && list.size() > 0) {
            a<T> aVar = this.h;
            if (aVar == null) {
                t = null;
            } else if (1 != bVar.e) {
                d.a aVarA = a(bVar.f8586a, this.f8801a, bVar.c);
                com.opos.cmn.an.f.a.b("dispatcherW", "create ssp:", this.f8801a, bVar.f8586a, aVarA);
                t = (T) aVar.a(bVar.f8586a, aVarA, bVar.d, bVar.e);
            } else {
                d.a aVarA2 = a(this.f8801a, bVar.f8586a, bVar.b, bVar.c);
                com.opos.cmn.an.f.a.b("dispatcherW", "create serial:", this.f8801a, bVar.f8586a, aVarA2);
                t = (T) aVar.a(bVar.f8586a, aVarA2, bVar.d);
            }
            this.d = true;
            com.opos.cmn.an.f.a.b("dispatcherW", "dispatcher succ");
            this.c = t;
            if (this.g && t != null) {
                t.b();
            }
            return;
        }
        com.opos.cmn.an.f.a.b("dispatcherW", "strategy size 0 ");
        this.d = true;
    }

    private static d.a d(String str) {
        return new d.a(d.a.f8585a, str, 100, 30000L, 0, 0);
    }

    private void c(String str, int i, List<String> list, String str2) {
        T t = this.c;
        if (t != null) {
            com.opos.cmn.an.f.a.b("dispatcherW", "reset to target");
            T t2 = this.b;
            this.b = t;
            t2.b();
            this.c = null;
        }
        this.b.a(str, i, list, str2);
    }

    public d.b a(long j) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        d.b bVarA = com.opos.mobad.c.b.a().a(this.f8801a, true);
        com.opos.cmn.an.f.a.b("dispatcherW", "channelStrategy = " + bVarA);
        if (bVarA != null && a(bVarA)) {
            return bVarA;
        }
        if (j <= 0) {
            return null;
        }
        for (int i = 0; i < 10; i++) {
            bVarA = com.opos.mobad.c.b.a().a(this.f8801a, true);
            if (bVarA != null && a(bVarA)) {
                return bVarA;
            }
            int iElapsedRealtime = ((int) (j - (SystemClock.elapsedRealtime() - jElapsedRealtime))) / (10 - i);
            if (iElapsedRealtime <= 0) {
                return null;
            }
            try {
                Thread.sleep(iElapsedRealtime);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.b("dispatcherW", "sleep timeout", e);
            }
        }
        return b(bVarA);
    }

    @Override // com.opos.mobad.m.j, com.opos.mobad.ad.b
    public void b() {
        com.opos.cmn.an.f.a.b("dispatcherW", "destroy");
        this.g = true;
        super.b();
        this.h = null;
        T t = this.b;
        if (t != null) {
            t.b();
        }
        if (this.c != null) {
            this.c.b();
        }
    }

    @Override // com.opos.mobad.f.a.a.p
    public void d(int i) {
        this.b.d(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, int i, List<String> list, String str2) {
        try {
            c(str, i, list, str2);
        } finally {
            p();
        }
    }

    @Override // com.opos.mobad.m.j
    public boolean c(String str) {
        return false;
    }

    @Override // com.opos.mobad.f.a.a.n
    public void a(int i, int i2) {
        T t = this.b;
        if (t instanceof n) {
            ((n) t).a(i, i2);
        }
    }

    @Override // com.opos.mobad.m.j
    public boolean b(String str, int i) {
        return b(str, i, null);
    }

    @Override // com.opos.mobad.m.j
    public boolean b(String str, int i, List<String> list) {
        return b(str, i, list, "");
    }

    @Override // com.opos.mobad.f.a.a.p
    public void a(m mVar) {
        this.b.a(mVar);
    }

    @Override // com.opos.mobad.m.j
    public boolean b(final String str, final int i, final List<String> list, final String str2) {
        if (!this.d) {
            if (this.i > 0) {
                com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.f.a.a.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.b bVarB;
                        com.opos.cmn.an.f.a.b("dispatcherW", "init and load ad");
                        if (!c.this.d) {
                            FutureTask futureTask = new FutureTask(new Callable<d.b>() { // from class: com.opos.mobad.f.a.a.c.1.1
                                @Override // java.util.concurrent.Callable
                                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                                public d.b call() throws Exception {
                                    return c.this.a(r0.i);
                                }
                            });
                            com.opos.cmn.an.j.b.c(futureTask);
                            try {
                                bVarB = (d.b) futureTask.get(c.this.i, TimeUnit.MILLISECONDS);
                            } catch (Exception unused) {
                                com.opos.cmn.an.f.a.b("dispatcherW", "init timeout");
                                bVarB = c.this.b(com.opos.mobad.c.b.a().a(c.this.f8801a, true));
                            }
                            if (bVarB != null) {
                                c.this.c(bVarB);
                            }
                        }
                        ((com.opos.mobad.m.j) c.this).e.post(new Runnable() { // from class: com.opos.mobad.f.a.a.c.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                c.this.d(str, i, list, str2);
                            }
                        });
                    }
                });
                return true;
            }
            m();
        }
        d(str, i, list, str2);
        return true;
    }

    private boolean a(d.b bVar) {
        String str;
        a<T> aVar = this.h;
        if (aVar != null) {
            for (d.a aVar2 : bVar.f8586a) {
                if (aVar2 != null) {
                    int iA = aVar.a(aVar2.f);
                    if (iA == 0 || 2 == iA || 3 == iA) {
                        com.opos.cmn.an.f.a.b("dispatcherW", "has channel init " + aVar2.f);
                    } else {
                        str = "has channel not init " + aVar2.f;
                    }
                }
            }
            return true;
        }
        str = "check but has destroy";
        com.opos.cmn.an.f.a.b("dispatcherW", str);
        return false;
    }
}
