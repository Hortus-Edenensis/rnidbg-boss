package com.opos.mobad.f.a.a;

import android.content.Context;
import com.opos.mobad.ad.b;
import com.opos.mobad.c.a.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class g<T extends com.opos.mobad.ad.b> extends i<T> implements n<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.opos.mobad.f.a.b.a<T> f8807a;
    private List<T> d;
    private T g;
    private int h;
    private int i;
    private Context j;
    private AtomicBoolean k;

    public g(Context context, String str, int i, com.opos.mobad.f.a.c.a aVar, List<d.a> list, d.a aVar2, long j, int i2, com.opos.mobad.f.a.b.b<T> bVar, b.a aVar3) {
        super(str, i, aVar, list, aVar2, j, i2, bVar, aVar3);
        this.h = 0;
        this.i = 0;
        this.k = new AtomicBoolean(false);
        this.j = context;
        this.f8807a = bVar;
        this.d = new ArrayList(list.size());
        this.h = com.opos.cmn.an.h.f.a.b(context);
        this.i = com.opos.cmn.an.h.f.a.a(context, 57.0f);
    }

    private void g() {
        com.opos.cmn.an.f.a.b("BaseRankDispatcher", "clearCacheDestroyAd size =" + this.d.size());
        if (this.d.isEmpty()) {
            return;
        }
        Iterator<T> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
        this.d.clear();
    }

    @Override // com.opos.mobad.f.a.a.n
    public void a(int i, int i2) {
        if (i == this.h && i2 == this.i) {
            return;
        }
        com.opos.cmn.an.f.a.a("SyncStateController", "BannerSizeChange w=" + i + ",h =" + i2);
        this.i = i2;
        this.h = i;
        this.k.compareAndSet(false, true);
    }

    @Override // com.opos.mobad.f.a.a.i, com.opos.mobad.m.j, com.opos.mobad.ad.b
    public void b() {
        super.b();
        this.f8807a = null;
        if (!((i) this).c.isEmpty()) {
            ((i) this).c.clear();
        }
        g();
    }

    @Override // com.opos.mobad.f.a.a.i
    public void c(String str, int i) {
        g();
        T t = this.g;
        if (t != null) {
            this.d.add(t);
        }
        this.g = ((i) this).b.get(Integer.valueOf(i));
        super.c(str, i);
    }

    private boolean g(int i) {
        return i == d.a.b && this.k.get();
    }

    @Override // com.opos.mobad.f.a.a.i
    public void a(d.a aVar, T t) {
        ((i) this).b.put(Integer.valueOf(aVar.f), t);
        ((i) this).c.put(Integer.valueOf(aVar.f), aVar);
    }

    @Override // com.opos.mobad.f.a.a.i
    public void a(String str, List<Integer> list, int i, List<String> list2) {
        if (list == null || list.isEmpty() || c() == 5) {
            com.opos.cmn.an.f.a.a("SyncStateController", "error Map to load");
            return;
        }
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            T tB = ((i) this).b.get(Integer.valueOf(iIntValue));
            if (tB != null) {
                if (g(iIntValue) || tB.c() == 2) {
                    com.opos.cmn.an.f.a.b("SyncStateController", "channel =" + iIntValue + " has loaded, need to reNew, creator:" + this.f8807a);
                    d.a aVar = ((i) this).c.get(Integer.valueOf(iIntValue));
                    com.opos.mobad.f.a.b.a<T> aVar2 = this.f8807a;
                    if (aVar2 != null) {
                        tB = aVar2.b(aVar, this);
                        if (aVar != null && aVar.f == d.a.b && (tB instanceof com.opos.mobad.ad.a.b)) {
                            this.k.compareAndSet(true, false);
                            ((com.opos.mobad.ad.a.b) tB).a(com.opos.cmn.an.h.f.a.b(this.j, this.h), com.opos.cmn.an.h.f.a.b(this.j, this.i));
                        }
                        ((i) this).b.put(Integer.valueOf(iIntValue), tB);
                    }
                }
                if (iIntValue != d.a.f8585a) {
                    tB.b(str);
                } else if (list2 == null) {
                    tB.a(str, i);
                } else {
                    tB.a(str, i, list2);
                }
            }
        }
    }

    @Override // com.opos.mobad.f.a.a.i
    public boolean a(T t, int i) {
        if (!g(i)) {
            return super.a(t, i);
        }
        com.opos.cmn.an.f.a.b("SyncStateController", "is channel enable but size change");
        return false;
    }

    @Override // com.opos.mobad.f.a.a.i
    public boolean a(Map.Entry<Integer, T> entry, T t, List<String> list) {
        if (entry != null) {
            if (!com.opos.mobad.c.b.a().a(entry.getKey().intValue())) {
                return false;
            }
            if (!super.a(entry, t, list) && g(entry.getKey().intValue())) {
                com.opos.cmn.an.f.a.a("SyncStateController", "channel need to load because of size changed ");
                return true;
            }
        }
        return super.a(entry, t, list);
    }
}
