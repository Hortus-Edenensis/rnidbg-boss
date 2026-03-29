package com.opos.mobad.f.a.a;

import com.opos.mobad.ad.b;
import com.opos.mobad.c.a.d;
import com.opos.mobad.f.a.a.v;
import com.opos.mobad.f.a.c.a;
import com.opos.mobad.f.a.o;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class h<T extends com.opos.mobad.ad.b> extends com.opos.mobad.m.j implements p<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f8808a;
    protected Map<Integer, T> b;
    private List<String> c;
    private String d;
    private int g;
    private int h;
    private int i;
    private com.opos.mobad.f.a.o<a.C0743a> j;
    private com.opos.mobad.f.a.p k;
    private v<d.a> l;
    private Map<Integer, Boolean> m;
    private Map<Integer, d.a> n;
    private d.a o;
    private com.opos.mobad.f.a.c.a p;
    private x q;
    private int r;
    private String s;

    public h(String str, int i, com.opos.mobad.f.a.c.a aVar, List<d.a> list, d.a aVar2, long j, com.opos.mobad.f.a.b.a<T> aVar3, b.a aVar4) {
        this(str, i, aVar, list, aVar2, j, aVar3, aVar4, null);
    }

    private void g() {
        this.i = -1;
        this.k.a();
    }

    public void f(int i) {
        com.opos.cmn.an.f.a.a("BasePercentDispatcher", "percent select:" + i);
        g();
        this.q.a(i);
        this.m.put(Integer.valueOf(i), Boolean.FALSE);
        this.h = i;
    }

    @Override // com.opos.mobad.f.a.a.p
    public T h() {
        return this.b.get(Integer.valueOf(d.a.f8585a));
    }

    @Override // com.opos.mobad.f.a.a.p
    public T i() {
        return this.b.get(Integer.valueOf(this.h));
    }

    @Override // com.opos.mobad.f.a.a.p
    public int j() {
        int i;
        if (2 != c() || (i = this.h) == -1) {
            return -1;
        }
        return i;
    }

    @Override // com.opos.mobad.f.a.a.p
    public d.a k() {
        return this.n.get(Integer.valueOf(j()));
    }

    @Override // com.opos.mobad.m.j
    public void l() {
        a(new Callable<Boolean>() { // from class: com.opos.mobad.f.a.a.h.3
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean call() throws Exception {
                h.this.j.a();
                h.this.k.a();
                if (h.this.i != -1) {
                    h.this.q.a(h.this.i, -2);
                }
                h.this.j(-2);
                return Boolean.TRUE;
            }
        });
    }

    public h(final String str, int i, com.opos.mobad.f.a.c.a aVar, List<d.a> list, d.a aVar2, long j, com.opos.mobad.f.a.b.a<T> aVar3, b.a aVar4, x xVar) {
        super(aVar4);
        this.h = -1;
        this.i = -1;
        this.d = str;
        this.g = i;
        this.p = aVar;
        if (xVar == null) {
            this.q = new x(str, j);
        } else {
            this.q = xVar;
        }
        this.j = new com.opos.mobad.f.a.o<>(new o.a<a.C0743a>() { // from class: com.opos.mobad.f.a.a.h.1
            @Override // com.opos.mobad.f.a.o.a
            public void a(a.C0743a c0743a) {
                if (c0743a == null) {
                    return;
                }
                h.this.c(c0743a.b, "" + c0743a.c);
            }
        });
        this.k = new com.opos.mobad.f.a.p(new Runnable() { // from class: com.opos.mobad.f.a.a.h.2
            @Override // java.lang.Runnable
            public void run() {
                com.opos.cmn.an.f.a.a("BasePercentDispatcher", "timeout for next =" + str);
                if (1 != h.this.c()) {
                    com.opos.cmn.an.f.a.b("BasePercentDispatcher", "start with error state");
                } else {
                    h.this.q.a(h.this.i, -2);
                    h.this.a(-1, com.opos.mobad.ad.a.a(-1), h.this.c);
                }
            }
        });
        this.b = new ConcurrentHashMap(list.size());
        this.m = new ConcurrentHashMap(list.size());
        this.n = new HashMap(list.size());
        a(list, aVar3);
        if (aVar2 != null) {
            a(aVar2, aVar3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(final int i) {
        this.j.a();
        this.k.a();
        a.C0743a c0743aA = this.p.a(this.d, i, this.c != null);
        if (c0743aA.f8841a) {
            c(new Callable<Boolean>() { // from class: com.opos.mobad.f.a.a.h.5
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Boolean call() {
                    h.this.f(i);
                    return Boolean.TRUE;
                }
            });
        } else {
            c(c0743aA.b, c0743aA.c);
            j(c0743aA.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i) {
        g();
        this.q.b(i);
    }

    public final void a(int i, String str, List<String> list) {
        if (1 != c()) {
            com.opos.cmn.an.f.a.b("BasePercentDispatcher", "start with error state");
        } else {
            b(i, str, list);
        }
    }

    @Override // com.opos.mobad.m.j, com.opos.mobad.ad.b
    public void b() {
        this.j.b();
        this.k.b();
        g();
        if (this.q != null && c() == 1) {
            this.q.b(-6);
        }
        this.l.b();
        super.b();
        Iterator<Integer> it = this.b.keySet().iterator();
        while (it.hasNext()) {
            this.b.get(it.next()).b();
        }
    }

    @Override // com.opos.mobad.m.j
    public boolean c(String str) {
        return a(str, (List<String>) null);
    }

    @Override // com.opos.mobad.f.a.a.p
    public final void d(int i) {
        com.opos.cmn.an.f.a.a("BasePercentDispatcher", "onChannelPercentSucc :" + i + ",cur:" + this.i);
        this.m.put(Integer.valueOf(i), Boolean.TRUE);
        if (c() == 1 && i == this.i && !a(i, this.r, this.s)) {
            i(i);
        }
    }

    @Override // com.opos.mobad.f.a.a.p
    public void e(int i) {
        if (i == j()) {
            n();
        }
    }

    public boolean g(int i) {
        return a(this.b.get(Integer.valueOf(i)), i);
    }

    public void h(int i) {
        this.m.put(Integer.valueOf(i), Boolean.FALSE);
    }

    private void a(d.a aVar, com.opos.mobad.f.a.b.a<T> aVar2) {
        if (this.b.containsKey(Integer.valueOf(aVar.f))) {
            this.o = aVar;
            return;
        }
        T tB = aVar2.b(aVar, this);
        if (tB == null) {
            com.opos.cmn.an.f.a.d("BasePercentDispatcher", "disable reserve");
        } else {
            this.b.put(Integer.valueOf(aVar.f), tB);
            this.o = aVar;
        }
    }

    private void b(int i, String str, List<String> list) {
        this.r = i;
        this.s = str;
        d.a aVarA = this.l.a();
        if (aVarA == null) {
            com.opos.cmn.an.f.a.b("BasePercentDispatcher", "reserve:" + this.o + ",current:" + this.i);
            aVarA = this.o;
            if (aVarA == null || this.i == aVarA.f) {
                c(i, str);
                j(-7);
                return;
            }
        }
        int i2 = aVarA.f;
        this.i = i2;
        a.C0743a c0743aA = this.p.a(i2, list != null);
        if (c0743aA != null && !c0743aA.f8841a) {
            this.q.a(aVarA.f, c0743aA.b);
            b(i, str, list);
            return;
        }
        com.opos.cmn.an.f.a.b("BasePercentDispatcher", "start:" + aVarA.f);
        int i3 = aVarA.f;
        if (i3 != d.a.f8585a && this.m.containsKey(Integer.valueOf(i3)) && this.m.get(Integer.valueOf(aVarA.f)).booleanValue() && g(aVarA.f)) {
            final int i4 = aVarA.f;
            com.opos.cmn.an.f.a.b("BasePercentDispatcher", "cache");
            com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.f.a.a.h.4
                @Override // java.lang.Runnable
                public void run() {
                    h.this.i(i4);
                }
            });
        } else {
            a(this.f8808a, aVarA, list);
            com.opos.cmn.an.f.a.b("BasePercentDispatcher", "timeout:" + aVarA.h);
            this.k.a(aVarA.h);
        }
    }

    @Override // com.opos.mobad.m.j, com.opos.mobad.ad.b
    public boolean d() {
        return a(this.b.get(Integer.valueOf(this.h)), this.h);
    }

    @Override // com.opos.mobad.m.j, com.opos.mobad.ad.b
    public void b(String str) {
        a(str, this.g);
    }

    @Override // com.opos.mobad.f.a.a.p
    public final void a(m mVar) {
        com.opos.cmn.an.f.a.a("BasePercentDispatcher", "onChannelPercentFailed :", mVar, "curChannel:" + this.i);
        if (mVar == null || mVar.f8821a != this.i) {
            return;
        }
        if (1 != c()) {
            com.opos.cmn.an.f.a.b("BasePercentDispatcher", "start with error state");
        } else {
            this.q.a(mVar.b, mVar.d);
            a(mVar.c, mVar.e, this.c);
        }
    }

    public void a(String str, d.a aVar, List<String> list) {
        T t = this.b.get(Integer.valueOf(aVar.f));
        if (aVar.f != d.a.f8585a) {
            t.b(str);
        } else if (list == null) {
            t.a(str, (int) aVar.h);
        } else {
            t.a(str, (int) aVar.h, list);
        }
    }

    private void a(List<d.a> list, com.opos.mobad.f.a.b.a<T> aVar) {
        StringBuilder sb;
        v.a aVar2 = new v.a();
        com.opos.cmn.an.f.a.b("BasePercentDispatcher", "channel size:" + list.size());
        for (int i = 0; i < list.size(); i++) {
            d.a aVar3 = list.get(i);
            this.n.put(Integer.valueOf(aVar3.f), aVar3);
            if (aVar3.k <= 0) {
                sb = new StringBuilder();
                sb.append("percent fail with channel:");
                sb.append(aVar3.f);
            } else {
                T tB = aVar.b(aVar3, this);
                if (tB == null) {
                    sb = new StringBuilder();
                    sb.append("ad null with channel:");
                    sb.append(aVar3);
                } else {
                    this.b.put(Integer.valueOf(aVar3.f), tB);
                    aVar2.a(aVar3, aVar3.k);
                }
            }
            com.opos.cmn.an.f.a.a("BasePercentDispatcher", sb.toString());
        }
        this.l = aVar2.a();
    }

    public boolean a(int i, int i2, String str) {
        return false;
    }

    public boolean a(T t, int i) {
        if (t == null) {
            return false;
        }
        return t.d();
    }

    @Override // com.opos.mobad.m.j
    public boolean a(String str, List<String> list) {
        return a(str, list, "");
    }

    @Override // com.opos.mobad.m.j
    public boolean a(String str, List<String> list, String str2) {
        com.opos.cmn.an.f.a.b("BasePercentDispatcher", "doload:" + str);
        a.C0743a c0743aA = this.p.a(this.d);
        this.q.a(str, str2);
        this.q.a();
        if (c0743aA.f8841a) {
            this.h = -1;
            this.i = -1;
            this.f8808a = str;
            this.c = list;
            this.j.a();
            this.k.a();
            this.l.b();
            b(-1, com.opos.mobad.ad.a.a(-1), list);
            return true;
        }
        com.opos.cmn.an.f.a.b("BasePercentDispatcher", "intercept " + c0743aA.c);
        this.j.a(500L, c0743aA);
        int i = c0743aA.b;
        if (i == -4) {
            return true;
        }
        this.q.c(i);
        return true;
    }
}
