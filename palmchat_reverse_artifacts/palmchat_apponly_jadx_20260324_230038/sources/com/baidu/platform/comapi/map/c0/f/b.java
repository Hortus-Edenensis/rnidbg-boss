package com.baidu.platform.comapi.map.c0.f;

import android.util.Pair;
import android.view.MotionEvent;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.c0.a;
import com.baidu.platform.comapi.map.c0.e.b;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b implements b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LinkedList<a.C0104a> f4199a = new LinkedList<>();
    private com.baidu.platform.comapi.map.c0.d b;
    private MapController c;
    private boolean d;
    private a e;
    private int f;

    public b(MapController mapController) {
        com.baidu.platform.comapi.map.c0.d dVar = new com.baidu.platform.comapi.map.c0.d();
        this.b = dVar;
        this.d = false;
        this.c = mapController;
        this.f = dVar.c / 3;
    }

    private void c(com.baidu.platform.comapi.map.c0.e.b bVar) {
        if (this.c.isOverlookGestureEnable()) {
            this.e.a(bVar, (Pair<a.d, a.d>) null);
            c cVar = new c(this.c);
            this.e = cVar;
            cVar.a(bVar);
        }
    }

    private void d(com.baidu.platform.comapi.map.c0.e.b bVar) {
        if (this.f4199a.size() < 5) {
            this.f4199a.addLast(bVar.c);
            this.b.a(bVar.d);
        } else if (!this.d && this.f4199a.size() == 5 && a()) {
            c(bVar);
        }
    }

    @Override // com.baidu.platform.comapi.map.c0.e.b.a
    public boolean a(com.baidu.platform.comapi.map.c0.e.b bVar, MotionEvent motionEvent) {
        d(bVar);
        if (this.f4199a.size() == 1) {
            this.e.a(bVar);
        }
        this.e.a(bVar, motionEvent);
        return true;
    }

    @Override // com.baidu.platform.comapi.map.c0.e.b.a
    public boolean b(com.baidu.platform.comapi.map.c0.e.b bVar) {
        this.f4199a.clear();
        this.b.b();
        this.e = new d(this.c);
        this.d = false;
        return true;
    }

    @Override // com.baidu.platform.comapi.map.c0.e.b.a
    public boolean a(com.baidu.platform.comapi.map.c0.e.b bVar) {
        Pair<a.d, a.d> pairC = this.b.c();
        this.b.a();
        this.e.a(bVar, pairC);
        return true;
    }

    private boolean a() {
        int iA;
        double dA;
        this.d = true;
        Iterator<a.C0104a> it = this.f4199a.iterator();
        while (it.hasNext()) {
            Double dValueOf = Double.valueOf(a.d.a(com.baidu.platform.comapi.map.c0.a.f4185a.c(), it.next().c()));
            if (Math.abs(dValueOf.doubleValue()) > 45.0d && Math.abs(dValueOf.doubleValue()) < 135.0d) {
                return false;
            }
        }
        Pair<a.d, a.d> pairC = this.b.c();
        a.d dVar = (a.d) pairC.first;
        a.d dVar2 = (a.d) pairC.second;
        boolean z = Math.abs(dVar.b) > ((double) this.f) && Math.abs(dVar2.b) > ((double) this.f);
        a.C0104a first = this.f4199a.getFirst();
        a.C0104a last = this.f4199a.getLast();
        a.C0104a c0104a = new a.C0104a(last.f4186a, first.f4186a);
        a.C0104a c0104a2 = new a.C0104a(last.b, first.b);
        if (dVar.b > 0.0d && dVar2.b > 0.0d) {
            a.d dVarC = c0104a.c();
            a.C0104a c0104a3 = com.baidu.platform.comapi.map.c0.a.c;
            iA = (int) a.d.a(dVarC, c0104a3.c());
            dA = a.d.a(c0104a2.c(), c0104a3.c());
        } else {
            a.d dVarC2 = c0104a.c();
            a.C0104a c0104a4 = com.baidu.platform.comapi.map.c0.a.b;
            iA = (int) a.d.a(dVarC2, c0104a4.c());
            dA = a.d.a(c0104a2.c(), c0104a4.c());
        }
        return z && (Math.abs(iA) < 40 && Math.abs((int) dA) < 40);
    }
}
