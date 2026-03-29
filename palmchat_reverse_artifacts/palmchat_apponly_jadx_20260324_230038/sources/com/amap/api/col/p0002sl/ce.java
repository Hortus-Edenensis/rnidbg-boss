package com.amap.api.col.p0002sl;

import com.amap.api.col.p0002sl.bi;
import com.amap.api.maps2d.AMapException;
import com.amap.api.maps2d.MapsInitializer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class ce extends q<cb, cb> implements ck {
    private aw c;
    private av d;

    public ce(bi biVar, aw awVar) {
        super(biVar);
        this.d = new av();
        this.c = awVar;
        this.f3043a = new ca();
        this.b.c.a(this);
        a();
    }

    private void c(ArrayList<cb> arrayList) {
        int size;
        if (arrayList == null || this.d == null || (size = arrayList.size()) == 0) {
            return;
        }
        for (int i = 0; i < size; i++) {
            this.d.a(arrayList.get(i));
        }
    }

    private void d(ArrayList<cb> arrayList) {
        if (this.f3043a == null || arrayList == null || arrayList.size() == 0) {
            return;
        }
        this.f3043a.a((List) arrayList, true);
    }

    private boolean g() {
        bi.a aVar;
        bw<aw> bwVar;
        bi biVar = this.b;
        if (biVar == null || (aVar = biVar.e) == null || (bwVar = aVar.f2641a) == null || bwVar.size() <= 0) {
            return false;
        }
        return this.c.a();
    }

    @Override // com.amap.api.col.p0002sl.q
    public final ArrayList<cb> a(ArrayList<cb> arrayList) throws AMapException {
        bi biVar;
        bi.a aVar;
        bi.a aVar2;
        ArrayList<cb> arrayList2 = null;
        if (arrayList != null && arrayList.size() != 0 && (biVar = this.b) != null && (aVar = biVar.e) != null && aVar.f2641a != null) {
            a((List<cb>) arrayList);
            if (arrayList.size() == 0) {
                return null;
            }
            aw awVar = this.c;
            if (awVar.j != null || awVar.k != null) {
                cf cfVar = new cf(arrayList, awVar.k);
                cfVar.a(this.c);
                ArrayList<cb> arrayListA = cfVar.a();
                cfVar.a((aw) null);
                arrayList2 = arrayListA;
            }
            c(arrayList);
            bi biVar2 = this.b;
            if (biVar2 != null && (aVar2 = biVar2.e) != null) {
                aVar2.b();
            }
        }
        return arrayList2;
    }

    @Override // com.amap.api.col.p0002sl.q, com.amap.api.col.p0002sl.bf
    public final void b() {
        bi.c cVar;
        super.b();
        this.d.clear();
        bi biVar = this.b;
        if (biVar != null && (cVar = biVar.c) != null) {
            cVar.b(this);
        }
        this.b = null;
    }

    @Override // com.amap.api.col.p0002sl.bf
    public final void f() {
        a(false);
    }

    @Override // com.amap.api.col.p0002sl.q
    public final ArrayList<cb> b(ArrayList<cb> arrayList) {
        int size;
        bi.a aVar;
        bw<aw> bwVar;
        if (arrayList == null || (size = arrayList.size()) == 0) {
            return null;
        }
        int i = 0;
        ArrayList<cb> arrayList2 = null;
        int iA = -1;
        while (i < size) {
            cb cbVar = arrayList.get(i);
            if (cbVar != null) {
                bi biVar = this.b;
                if (biVar == null || (aVar = biVar.e) == null || (bwVar = aVar.f2641a) == null) {
                    return null;
                }
                bwVar.size();
                if (this.c.f) {
                    try {
                        iA = (MapsInitializer.getUpdateDataActiveEnable() && z.b()) ? -1 : this.c.o.a(cbVar);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    if (iA >= 0) {
                        arrayList.remove(i);
                        size--;
                        i--;
                        bw<cb> bwVar2 = this.c.p;
                        if (bwVar2 != null) {
                            synchronized (bwVar2) {
                                Iterator<cb> it = bwVar2.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    cb next = it.next();
                                    if (next != null && next.equals(cbVar)) {
                                        next.h = iA;
                                        this.b.e.b();
                                        break;
                                    }
                                }
                            }
                        } else {
                            continue;
                        }
                    } else {
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList<>();
                        }
                        cb cbVar2 = new cb(cbVar);
                        cbVar2.f2667a = -1;
                        arrayList2.add(cbVar2);
                    }
                } else {
                    continue;
                }
            }
            i++;
        }
        return arrayList2;
    }

    private void a(List<cb> list) {
        int size;
        if (list == null || (size = list.size()) == 0) {
            return;
        }
        int i = 0;
        while (i < size) {
            if (!this.d.b(list.get(i))) {
                list.remove(i);
                i--;
                size--;
            }
            i++;
        }
    }

    private ArrayList<cb> a(ArrayList<cb> arrayList, aw awVar, float f, boolean z) {
        bw<cb> bwVar;
        int size;
        ArrayList<cb> arrayList2 = new ArrayList<>();
        if (arrayList == null || awVar == null || !awVar.a() || (bwVar = awVar.p) == null) {
            return null;
        }
        bwVar.clear();
        if (f > awVar.c || f < awVar.d || (size = arrayList.size()) <= 0) {
            return null;
        }
        for (int i = 0; i < size; i++) {
            try {
                cb cbVar = arrayList.get(i);
                if (cbVar != null) {
                    int iA = awVar.n.a(cbVar.b());
                    cb cbVar2 = new cb(cbVar.b, cbVar.c, cbVar.d, awVar.l);
                    cbVar2.h = iA;
                    cbVar2.g = cbVar.g;
                    awVar.p.add(cbVar2);
                    if (a(cbVar2) && !z && !this.d.contains(cbVar2)) {
                        if (!awVar.f) {
                            cbVar2.f2667a = -1;
                        }
                        arrayList2.add(cbVar2);
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return arrayList2;
    }

    @Override // com.amap.api.col.p0002sl.ck
    public final void a(boolean z) {
        if (g()) {
            be beVar = this.b.h;
            af afVar = beVar.l;
            beVar.b();
            ArrayList<cb> arrayListA = beVar.a(afVar, bi.c.c(), bi.c.d());
            if (arrayListA.size() <= 0) {
                return;
            }
            ArrayList<cb> arrayListA2 = a(arrayListA, this.c, this.b.c.e(), z);
            if (arrayListA2 != null) {
                d(arrayListA2);
                arrayListA2.clear();
            }
            arrayListA.clear();
            this.b.c.g().postInvalidate();
        }
    }

    private static boolean a(cb cbVar) {
        return cbVar.h < 0;
    }
}
