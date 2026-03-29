package com.opos.mobad.f.a.a;

import android.content.Context;
import com.opos.mobad.ad.b;
import com.opos.mobad.c.a.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class f<T extends com.opos.mobad.ad.b> extends h<T> implements n<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.opos.mobad.f.a.b.a<T> f8806a;
    private List<T> c;
    private T d;
    private int g;
    private int h;
    private Context i;
    private AtomicBoolean j;

    public f(Context context, String str, int i, com.opos.mobad.f.a.c.a aVar, List<d.a> list, d.a aVar2, long j, com.opos.mobad.f.a.b.b<T> bVar, b.a aVar3) {
        super(str, i, aVar, list, aVar2, j, bVar, aVar3);
        this.d = null;
        this.g = 0;
        this.h = 0;
        this.j = new AtomicBoolean(false);
        this.i = context;
        this.f8806a = bVar;
        this.c = new ArrayList(list.size());
        this.g = com.opos.cmn.an.h.f.a.b(context);
        this.h = com.opos.cmn.an.h.f.a.a(context, 57.0f);
    }

    private void g() {
        com.opos.cmn.an.f.a.b("BasePercentDispatcher", "clearCacheDestroyAd size =" + this.c.size());
        if (this.c.isEmpty()) {
            return;
        }
        Iterator<T> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
        this.c.clear();
    }

    private boolean i(int i) {
        return i == d.a.b && this.j.get();
    }

    @Override // com.opos.mobad.f.a.a.n
    public void a(int i, int i2) {
        if (i == this.g && i2 == this.h) {
            return;
        }
        this.h = i2;
        this.g = i;
        this.j.compareAndSet(false, true);
        h(d.a.b);
    }

    @Override // com.opos.mobad.f.a.a.h, com.opos.mobad.m.j, com.opos.mobad.ad.b
    public void b() {
        super.b();
        this.f8806a = null;
        g();
    }

    @Override // com.opos.mobad.f.a.a.h
    public void f(int i) {
        g();
        T t = this.d;
        if (t != null) {
            this.c.add(t);
        }
        this.d = ((h) this).b.get(Integer.valueOf(i));
        super.f(i);
    }

    @Override // com.opos.mobad.f.a.a.h
    public void a(String str, d.a aVar, List<String> list) {
        com.opos.cmn.an.f.a.b("SyncStateController", "loadChannelAd channel =" + aVar.f);
        T tB = ((h) this).b.get(Integer.valueOf(aVar.f));
        if (tB == null || c() == 5) {
            com.opos.cmn.an.f.a.b("BasePercentDispatcher", "loadChannelAd but null ad:" + tB);
            return;
        }
        if (i(aVar.f) || tB.c() == 2) {
            com.opos.cmn.an.f.a.b("SyncStateController", "channel =" + aVar.f + " has loaded, need to reNew:" + this.f8806a);
            com.opos.mobad.f.a.b.a<T> aVar2 = this.f8806a;
            if (aVar2 == null) {
                return;
            }
            tB = aVar2.b(aVar, this);
            if (aVar.f == d.a.b && (tB instanceof com.opos.mobad.ad.a.b)) {
                this.j.compareAndSet(true, false);
                ((com.opos.mobad.ad.a.b) tB).a(com.opos.cmn.an.h.f.a.b(this.i, this.g), com.opos.cmn.an.h.f.a.b(this.i, this.h));
            }
            ((h) this).b.put(Integer.valueOf(aVar.f), tB);
        }
        if (aVar.f != d.a.f8585a) {
            tB.b(str);
        } else if (list == null) {
            tB.a(str, (int) aVar.h);
        } else {
            tB.a(str, (int) aVar.h, list);
        }
    }

    @Override // com.opos.mobad.f.a.a.h
    public boolean a(int i, int i2, String str) {
        if (!i(i)) {
            return super.a(i, i2, str);
        }
        com.opos.cmn.an.f.a.a("BasePercentDispatcher", "interceptToStartNext :" + i + ",code: " + i2 + ", msg:" + str);
        a(m.a(i, i, i2, str));
        return true;
    }

    @Override // com.opos.mobad.f.a.a.h
    public boolean a(T t, int i) {
        if (!i(i)) {
            return super.a(t, i);
        }
        com.opos.cmn.an.f.a.b("SyncStateController", "is channel enable but size change");
        return false;
    }
}
