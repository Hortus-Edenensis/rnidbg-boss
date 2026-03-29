package defpackage;

import com.github.mikephil.charting.data.Entry;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class ai0 extends qp<mk2<? extends Entry>> {
    public p23 j;
    public np k;
    public t25 l;
    public hz m;
    public vu n;

    public p23 A() {
        return this.j;
    }

    public t25 B() {
        return this.l;
    }

    @Override // defpackage.h10
    public void a() {
        if (this.i == null) {
            this.i = new ArrayList();
        }
        this.i.clear();
        this.f17848a = -3.4028235E38f;
        this.b = Float.MAX_VALUE;
        this.c = -3.4028235E38f;
        this.d = Float.MAX_VALUE;
        this.e = -3.4028235E38f;
        this.f = Float.MAX_VALUE;
        this.g = -3.4028235E38f;
        this.h = Float.MAX_VALUE;
        for (qp qpVar : u()) {
            qpVar.a();
            this.i.addAll(qpVar.h());
            if (qpVar.p() > this.f17848a) {
                this.f17848a = qpVar.p();
            }
            if (qpVar.r() < this.b) {
                this.b = qpVar.r();
            }
            if (qpVar.n() > this.c) {
                this.c = qpVar.n();
            }
            if (qpVar.o() < this.d) {
                this.d = qpVar.o();
            }
            float f = qpVar.e;
            if (f > this.e) {
                this.e = f;
            }
            float f2 = qpVar.f;
            if (f2 < this.f) {
                this.f = f2;
            }
            float f3 = qpVar.g;
            if (f3 > this.g) {
                this.g = f3;
            }
            float f4 = qpVar.h;
            if (f4 < this.h) {
                this.h = f4;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [kl2] */
    @Override // defpackage.h10
    public Entry j(vh2 vh2Var) {
        if (vh2Var.c() >= u().size()) {
            return null;
        }
        qp qpVarY = y(vh2Var.c());
        if (vh2Var.d() >= qpVarY.f()) {
            return null;
        }
        for (Entry entry : qpVarY.e(vh2Var.d()).p(vh2Var.h())) {
            if (entry.getY() == vh2Var.j() || Float.isNaN(vh2Var.j())) {
                return entry;
            }
        }
        return null;
    }

    @Override // defpackage.h10
    public void t() {
        p23 p23Var = this.j;
        if (p23Var != null) {
            p23Var.t();
        }
        np npVar = this.k;
        if (npVar != null) {
            npVar.t();
        }
        hz hzVar = this.m;
        if (hzVar != null) {
            hzVar.t();
        }
        t25 t25Var = this.l;
        if (t25Var != null) {
            t25Var.t();
        }
        vu vuVar = this.n;
        if (vuVar != null) {
            vuVar.t();
        }
        a();
    }

    public List<qp> u() {
        ArrayList arrayList = new ArrayList();
        p23 p23Var = this.j;
        if (p23Var != null) {
            arrayList.add(p23Var);
        }
        np npVar = this.k;
        if (npVar != null) {
            arrayList.add(npVar);
        }
        t25 t25Var = this.l;
        if (t25Var != null) {
            arrayList.add(t25Var);
        }
        hz hzVar = this.m;
        if (hzVar != null) {
            arrayList.add(hzVar);
        }
        vu vuVar = this.n;
        if (vuVar != null) {
            arrayList.add(vuVar);
        }
        return arrayList;
    }

    public np v() {
        return this.k;
    }

    public vu w() {
        return this.n;
    }

    public hz x() {
        return this.m;
    }

    public qp y(int i) {
        return u().get(i);
    }

    public mk2<? extends Entry> z(vh2 vh2Var) {
        if (vh2Var.c() >= u().size()) {
            return null;
        }
        qp qpVarY = y(vh2Var.c());
        if (vh2Var.d() >= qpVarY.f()) {
            return null;
        }
        return (mk2) qpVarY.h().get(vh2Var.d());
    }
}
