package defpackage;

import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import defpackage.kl2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class h10<T extends kl2<? extends Entry>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f17848a;
    public float b;
    public float c;
    public float d;
    public float e;
    public float f;
    public float g;
    public float h;
    public List<T> i;

    public h10() {
        this.f17848a = -3.4028235E38f;
        this.b = Float.MAX_VALUE;
        this.c = -3.4028235E38f;
        this.d = Float.MAX_VALUE;
        this.e = -3.4028235E38f;
        this.f = Float.MAX_VALUE;
        this.g = -3.4028235E38f;
        this.h = Float.MAX_VALUE;
        this.i = new ArrayList();
    }

    public void a() {
        List<T> list = this.i;
        if (list == null) {
            return;
        }
        this.f17848a = -3.4028235E38f;
        this.b = Float.MAX_VALUE;
        this.c = -3.4028235E38f;
        this.d = Float.MAX_VALUE;
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            b(it.next());
        }
        this.e = -3.4028235E38f;
        this.f = Float.MAX_VALUE;
        this.g = -3.4028235E38f;
        this.h = Float.MAX_VALUE;
        kl2 kl2VarK = k(this.i);
        if (kl2VarK != null) {
            this.e = kl2VarK.S();
            this.f = kl2VarK.W();
            for (T t : this.i) {
                if (t.i0() == YAxis.AxisDependency.LEFT) {
                    if (t.W() < this.f) {
                        this.f = t.W();
                    }
                    if (t.S() > this.e) {
                        this.e = t.S();
                    }
                }
            }
        }
        kl2 kl2VarL = l(this.i);
        if (kl2VarL != null) {
            this.g = kl2VarL.S();
            this.h = kl2VarL.W();
            for (T t2 : this.i) {
                if (t2.i0() == YAxis.AxisDependency.RIGHT) {
                    if (t2.W() < this.h) {
                        this.h = t2.W();
                    }
                    if (t2.S() > this.g) {
                        this.g = t2.S();
                    }
                }
            }
        }
    }

    public void b(T t) {
        if (this.f17848a < t.S()) {
            this.f17848a = t.S();
        }
        if (this.b > t.W()) {
            this.b = t.W();
        }
        if (this.c < t.I()) {
            this.c = t.I();
        }
        if (this.d > t.y()) {
            this.d = t.y();
        }
        if (t.i0() == YAxis.AxisDependency.LEFT) {
            if (this.e < t.S()) {
                this.e = t.S();
            }
            if (this.f > t.W()) {
                this.f = t.W();
                return;
            }
            return;
        }
        if (this.g < t.S()) {
            this.g = t.S();
        }
        if (this.h > t.W()) {
            this.h = t.W();
        }
    }

    public void c(float f, float f2) {
        Iterator<T> it = this.i.iterator();
        while (it.hasNext()) {
            it.next().o(f, f2);
        }
        a();
    }

    public void d() {
        List<T> list = this.i;
        if (list != null) {
            list.clear();
        }
        t();
    }

    public T e(int i) {
        List<T> list = this.i;
        if (list == null || i < 0 || i >= list.size()) {
            return null;
        }
        return this.i.get(i);
    }

    public int f() {
        List<T> list = this.i;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public T g(Entry entry) {
        if (entry == null) {
            return null;
        }
        for (int i = 0; i < this.i.size(); i++) {
            T t = this.i.get(i);
            for (int i2 = 0; i2 < t.K0(); i2++) {
                if (entry.equalTo(t.o0(entry.getX(), entry.getY()))) {
                    return t;
                }
            }
        }
        return null;
    }

    public List<T> h() {
        return this.i;
    }

    public int i() {
        Iterator<T> it = this.i.iterator();
        int iK0 = 0;
        while (it.hasNext()) {
            iK0 += it.next().K0();
        }
        return iK0;
    }

    public Entry j(vh2 vh2Var) {
        if (vh2Var.d() >= this.i.size()) {
            return null;
        }
        return this.i.get(vh2Var.d()).o0(vh2Var.h(), vh2Var.j());
    }

    public T k(List<T> list) {
        for (T t : list) {
            if (t.i0() == YAxis.AxisDependency.LEFT) {
                return t;
            }
        }
        return null;
    }

    public T l(List<T> list) {
        for (T t : list) {
            if (t.i0() == YAxis.AxisDependency.RIGHT) {
                return t;
            }
        }
        return null;
    }

    public T m() {
        List<T> list = this.i;
        if (list == null || list.isEmpty()) {
            return null;
        }
        T t = this.i.get(0);
        for (T t2 : this.i) {
            if (t2.K0() > t.K0()) {
                t = t2;
            }
        }
        return t;
    }

    public float n() {
        return this.c;
    }

    public float o() {
        return this.d;
    }

    public float p() {
        return this.f17848a;
    }

    public float q(YAxis.AxisDependency axisDependency) {
        if (axisDependency == YAxis.AxisDependency.LEFT) {
            float f = this.e;
            return f == -3.4028235E38f ? this.g : f;
        }
        float f2 = this.g;
        return f2 == -3.4028235E38f ? this.e : f2;
    }

    public float r() {
        return this.b;
    }

    public float s(YAxis.AxisDependency axisDependency) {
        if (axisDependency == YAxis.AxisDependency.LEFT) {
            float f = this.f;
            return f == Float.MAX_VALUE ? this.h : f;
        }
        float f2 = this.h;
        return f2 == Float.MAX_VALUE ? this.f : f2;
    }

    public void t() {
        a();
    }

    public h10(List<T> list) {
        this.f17848a = -3.4028235E38f;
        this.b = Float.MAX_VALUE;
        this.c = -3.4028235E38f;
        this.d = Float.MAX_VALUE;
        this.e = -3.4028235E38f;
        this.f = Float.MAX_VALUE;
        this.g = -3.4028235E38f;
        this.h = Float.MAX_VALUE;
        this.i = list;
        t();
    }
}
