package com.opos.mobad.f.a.a;

import com.opos.mobad.ad.b;
import com.opos.mobad.c.a.d;
import com.opos.mobad.f.a.a.v;
import com.opos.mobad.f.a.c.a;
import com.opos.mobad.f.a.o;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class i<T extends com.opos.mobad.ad.b> extends com.opos.mobad.m.j implements p<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f8814a;
    protected Map<Integer, T> b;
    protected HashMap<Integer, d.a> c;
    private int d;
    private int g;
    private v<d.a> h;
    private j i;
    private Map<Integer, d.a> j;
    private d.a k;
    private CountDownLatch l;
    private com.opos.mobad.f.a.c.a m;
    private w n;
    private Map<Integer, m> o;
    private com.opos.mobad.f.a.o<a.C0743a> p;
    private int q;
    private String r;
    private int s;

    public i(String str, int i, com.opos.mobad.f.a.c.a aVar, List<d.a> list, d.a aVar2, long j, int i2, com.opos.mobad.f.a.b.a<T> aVar3, b.a aVar4) {
        super(aVar4);
        this.g = -1;
        this.l = null;
        this.q = -1;
        this.r = "Unknown error. ";
        this.m = aVar;
        this.n = new w(str, i2, j);
        this.o = new HashMap();
        this.f8814a = str;
        this.s = i2;
        this.d = i;
        this.b = new ConcurrentHashMap(list.size());
        this.c = new HashMap<>(list.size());
        this.j = new HashMap(list.size());
        a(list, aVar3);
        if (aVar2 != null) {
            a(aVar2, aVar3);
        }
        this.p = new com.opos.mobad.f.a.o<>(new o.a<a.C0743a>() { // from class: com.opos.mobad.f.a.a.i.1
            @Override // com.opos.mobad.f.a.o.a
            public void a(a.C0743a c0743a) {
                if (c0743a == null) {
                    return;
                }
                i.this.c(c0743a.b, "" + c0743a.c);
            }
        });
    }

    private Map<Integer, T> c(List<String> list) {
        if (this.b == null) {
            return null;
        }
        HashMap map = new HashMap();
        for (Map.Entry<Integer, T> entry : this.b.entrySet()) {
            Integer key = entry.getKey();
            if (b(key.intValue(), list)) {
                map.put(key, entry.getValue());
            }
        }
        return map;
    }

    private d.a d(List<String> list) {
        this.n.b();
        return b(list);
    }

    private d.a g() {
        this.n.a();
        this.h.b();
        for (int i = 0; i < this.b.size(); i++) {
            d.a aVarA = this.h.a();
            if (a(aVarA)) {
                return aVarA;
            }
        }
        return null;
    }

    public d.a b(List<String> list) {
        Map<Integer, T> mapC = c(list);
        if (mapC != null && mapC.size() > 0) {
            return this.i.a(mapC);
        }
        com.opos.cmn.an.f.a.b("BaseRankDispatcher", "doSelectBiding but adMap is null");
        return null;
    }

    @Override // com.opos.mobad.f.a.a.p
    public void e(int i) {
        if (i == j()) {
            n();
        }
    }

    public boolean f(int i) {
        return a(this.b.get(Integer.valueOf(i)), i);
    }

    @Override // com.opos.mobad.f.a.a.p
    public T h() {
        return this.b.get(Integer.valueOf(d.a.f8585a));
    }

    @Override // com.opos.mobad.f.a.a.p
    public T i() {
        return this.b.get(Integer.valueOf(this.g));
    }

    @Override // com.opos.mobad.f.a.a.p
    public int j() {
        int i;
        if (2 != c() || (i = this.g) == -1) {
            return -1;
        }
        return i;
    }

    @Override // com.opos.mobad.f.a.a.p
    public d.a k() {
        return this.j.get(Integer.valueOf(j()));
    }

    private void g(int i) {
        int i2;
        m mVar = this.o.get(Integer.valueOf(i));
        if (mVar != null) {
            i = mVar.b;
            i2 = mVar.d;
        } else {
            i2 = -2;
        }
        this.n.a(i, i2);
    }

    public void a(d.a aVar, T t) {
        this.b.put(Integer.valueOf(aVar.f), t);
    }

    public void c(String str, int i) {
        com.opos.cmn.an.f.a.b("BaseRankDispatcher", "select:" + i);
        this.g = i;
        this.n.a(i);
    }

    @Override // com.opos.mobad.f.a.a.p
    public final void d(int i) {
        com.opos.cmn.an.f.a.b("BaseRankDispatcher", "onChannelRankSucc channel:" + i);
        if (c() == 5) {
            com.opos.cmn.an.f.a.b("BaseRankDispatcher", "channel suc but destroy");
            return;
        }
        CountDownLatch countDownLatch = this.l;
        if (countDownLatch != null) {
            try {
                countDownLatch.countDown();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.b("BaseRankDispatcher", "succ:" + i, e);
            }
        }
    }

    private void a(d.a aVar, com.opos.mobad.f.a.b.a<T> aVar2) {
        if (this.b.containsKey(Integer.valueOf(aVar.f))) {
            this.k = aVar;
            return;
        }
        T tB = aVar2.b(aVar, this);
        if (tB == null) {
            com.opos.cmn.an.f.a.d("BaseRankDispatcher", "disable main");
        } else {
            a(aVar, tB);
            this.k = aVar;
        }
    }

    private void d(final String str, final int i, List<String> list) {
        this.p.a();
        a.C0743a c0743aA = this.m.a(this.f8814a, i, list != null);
        if (c0743aA.f8841a) {
            c(new Callable<Boolean>() { // from class: com.opos.mobad.f.a.a.i.3
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Boolean call() {
                    i.this.c(str, i);
                    return Boolean.TRUE;
                }
            });
        } else {
            c(c0743aA.b, c0743aA.c);
            this.n.b(c0743aA.b);
        }
    }

    @Override // com.opos.mobad.m.j, com.opos.mobad.ad.b
    public void b() {
        if (this.n != null && c() == 1) {
            this.n.b(-6);
        }
        this.h.b();
        super.b();
        Iterator<T> it = this.b.values().iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    public void c(final String str, final int i, final List<String> list) {
        List<Integer> arrayList = new ArrayList<>();
        for (Map.Entry<Integer, T> entry : this.b.entrySet()) {
            T value = entry.getValue();
            if (value == null) {
                com.opos.cmn.an.f.a.b("BaseRankDispatcher", "error disable ad");
            } else if (a(entry, value, list)) {
                com.opos.cmn.an.f.a.a("SyncStateController", "add load ad channel:" + entry.getKey());
                arrayList.add(entry.getKey());
            }
        }
        this.g = -1;
        final int size = arrayList.size();
        if (size <= 0) {
            com.opos.cmn.an.f.a.a("SyncStateController", "not need to load");
            a(str, true, list);
        } else {
            this.l = new CountDownLatch(size);
            a(str, arrayList, i, list);
            com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.f.a.a.i.2
                @Override // java.lang.Runnable
                public void run() {
                    com.opos.cmn.an.f.a.a("SyncStateController", "countdown:" + size + "," + i + ",posid=" + i.this.f8814a);
                    try {
                        if (i.this.c() == 5) {
                            com.opos.cmn.an.f.a.a("SyncStateController", "wait but destroy");
                        } else {
                            final boolean zAwait = i.this.l.await(i, TimeUnit.MILLISECONDS);
                            com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.f.a.a.i.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                    i.this.a(str, zAwait, (List<String>) list);
                                }
                            });
                        }
                    } catch (InterruptedException e) {
                        com.opos.cmn.an.f.a.b("", "", e);
                        com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.f.a.a.i.2.2
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                i.this.a(str, false, (List<String>) list);
                            }
                        });
                    }
                }
            });
        }
    }

    public boolean b(int i, List<String> list) {
        if (f(i)) {
            a.C0743a c0743aA = this.m.a(i, list != null);
            if (c0743aA.f8841a) {
                return true;
            }
            com.opos.cmn.an.f.a.a("BaseRankDispatcher", "rank disable ad:" + i + ", code = " + c0743aA.b);
            this.n.a(i, c0743aA.b);
        } else {
            g(i);
        }
        return false;
    }

    @Override // com.opos.mobad.m.j
    public boolean c(String str) {
        return true;
    }

    @Override // com.opos.mobad.m.j, com.opos.mobad.ad.b
    public boolean d() {
        if (2 != c()) {
            return false;
        }
        return a(this.b.get(Integer.valueOf(this.g)), this.g);
    }

    @Override // com.opos.mobad.m.j
    public boolean b(String str, int i) {
        return b(str, i, null);
    }

    @Override // com.opos.mobad.f.a.a.p
    public final void a(m mVar) {
        com.opos.cmn.an.f.a.a("BaseRankDispatcher", "onChannelRankFailed:", mVar);
        if (mVar == null || c() == 5) {
            com.opos.cmn.an.f.a.b("BaseRankDispatcher", "channel fail but destroy");
            return;
        }
        this.q = mVar.c;
        this.r = mVar.e;
        this.o.put(Integer.valueOf(mVar.f8821a), mVar);
        CountDownLatch countDownLatch = this.l;
        if (countDownLatch != null) {
            try {
                countDownLatch.countDown();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.b("BaseRankDispatcher", "fail:" + mVar.f8821a, e);
            }
        }
    }

    @Override // com.opos.mobad.m.j
    public boolean b(String str, int i, List<String> list) {
        return b(str, i, null, "");
    }

    public void a(String str, List<Integer> list, int i, List<String> list2) {
        if (list == null || list.isEmpty()) {
            com.opos.cmn.an.f.a.a("SyncStateController", "error Map to load");
            return;
        }
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            T t = this.b.get(Integer.valueOf(iIntValue));
            if (t != null) {
                if (iIntValue != d.a.f8585a) {
                    t.b(str);
                } else if (list2 == null) {
                    t.a(str, i);
                } else {
                    t.a(str, i, list2);
                }
            }
        }
    }

    @Override // com.opos.mobad.m.j
    public boolean b(String str, int i, List<String> list, String str2) {
        com.opos.cmn.an.f.a.b("BaseRankDispatcher", "doload:" + str);
        this.n.a(str, str2);
        a.C0743a c0743aA = this.m.a(this.f8814a);
        if (c0743aA.f8841a) {
            this.p.a();
            this.h.b();
            this.o.clear();
            c(str, Math.min(i, this.d), list);
            return true;
        }
        com.opos.cmn.an.f.a.b("BaseRankDispatcher", "intercept " + c0743aA.c);
        this.p.a(500L, c0743aA);
        int i2 = c0743aA.b;
        if (i2 != -4) {
            this.n.c(i2);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z, List<String> list) {
        w wVar;
        int i;
        if (c() == 5) {
            com.opos.cmn.an.f.a.b("BaseRankDispatcher", "dealResult but destroy");
            return;
        }
        d.a aVarD = d(list);
        if (aVarD != null) {
            d(str, aVarD.f, list);
            return;
        }
        com.opos.cmn.an.f.a.a("BaseRankDispatcher", "deal rank but fail,deal percent");
        d.a aVarG = g();
        if (aVarG != null) {
            d(str, aVarG.f, list);
            return;
        }
        com.opos.cmn.an.f.a.a("BaseRankDispatcher", "deal fail ,posid=" + this.f8814a);
        if (z) {
            int i2 = this.q;
            if (i2 == -1) {
                c(11007, this.q + "," + this.r);
            } else {
                c(i2, this.r);
            }
            wVar = this.n;
            i = -7;
        } else {
            l();
            wVar = this.n;
            i = -2;
        }
        wVar.b(i);
    }

    private void a(List<d.a> list, com.opos.mobad.f.a.b.a<T> aVar) {
        StringBuilder sb;
        ArrayList arrayList = new ArrayList();
        v.a aVar2 = new v.a();
        com.opos.cmn.an.f.a.b("BaseRankDispatcher", "channel size:" + list.size());
        for (int i = 0; i < list.size(); i++) {
            d.a aVar3 = list.get(i);
            this.j.put(Integer.valueOf(aVar3.f), aVar3);
            T tB = aVar.b(aVar3, this);
            if (tB == null) {
                sb = new StringBuilder();
                sb.append("ad null with channel:");
                sb.append(aVar3);
            } else {
                a(aVar3, tB);
                arrayList.add(aVar3);
                int i2 = aVar3.k;
                if (i2 <= 0) {
                    sb = new StringBuilder();
                    sb.append("percent fail with channel:");
                    sb.append(aVar3.f);
                } else {
                    aVar2.a(aVar3, i2);
                }
            }
            com.opos.cmn.an.f.a.b("BaseRankDispatcher", sb.toString());
        }
        this.h = aVar2.a();
        this.i = new j(arrayList);
    }

    public boolean a(T t, int i) {
        if (t == null) {
            return false;
        }
        return t.d();
    }

    private boolean a(d.a aVar) {
        if (aVar == null) {
            com.opos.cmn.an.f.a.b("BaseRankDispatcher", "check to select but entity is null");
            return false;
        }
        if (f(aVar.f)) {
            return true;
        }
        g(aVar.f);
        return false;
    }

    public boolean a(Map.Entry<Integer, T> entry, T t, List<String> list) {
        if (entry.getKey().intValue() != d.a.f8585a && this.g != entry.getKey().intValue() && t.c() == 2 && t.d()) {
            return false;
        }
        a.C0743a c0743aA = this.m.a(entry.getKey().intValue(), list != null);
        return c0743aA != null && c0743aA.f8841a;
    }
}
