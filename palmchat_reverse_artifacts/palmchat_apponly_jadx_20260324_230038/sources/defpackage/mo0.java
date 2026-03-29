package defpackage;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.model.layer.a;
import defpackage.sq;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class mo0 implements ah1, rc4, sq.b, c03 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f19279a;
    public final RectF b;
    public final Matrix c;
    public final Path d;
    public final RectF e;
    public final String f;
    public final boolean g;
    public final List<ko0> h;
    public final u83 i;

    @Nullable
    public List<rc4> j;

    @Nullable
    public w06 k;

    public mo0(u83 u83Var, a aVar, e75 e75Var) {
        this(u83Var, aVar, e75Var.c(), e75Var.d(), b(u83Var, aVar, e75Var.b()), i(e75Var.b()));
    }

    public static List<ko0> b(u83 u83Var, a aVar, List<np0> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            ko0 ko0VarA = list.get(i).a(u83Var, aVar);
            if (ko0VarA != null) {
                arrayList.add(ko0VarA);
            }
        }
        return arrayList;
    }

    @Nullable
    public static pd i(List<np0> list) {
        for (int i = 0; i < list.size(); i++) {
            np0 np0Var = list.get(i);
            if (np0Var instanceof pd) {
                return (pd) np0Var;
            }
        }
        return null;
    }

    @Override // defpackage.ah1
    public void a(RectF rectF, Matrix matrix, boolean z) {
        this.c.set(matrix);
        w06 w06Var = this.k;
        if (w06Var != null) {
            this.c.preConcat(w06Var.f());
        }
        this.e.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.h.size() - 1; size >= 0; size--) {
            ko0 ko0Var = this.h.get(size);
            if (ko0Var instanceof ah1) {
                ((ah1) ko0Var).a(this.e, this.c, z);
                rectF.union(this.e);
            }
        }
    }

    @Override // defpackage.c03
    public void c(b03 b03Var, int i, List<b03> list, b03 b03Var2) {
        if (b03Var.g(getName(), i) || "__container".equals(getName())) {
            if (!"__container".equals(getName())) {
                b03Var2 = b03Var2.a(getName());
                if (b03Var.c(getName(), i)) {
                    list.add(b03Var2.i(this));
                }
            }
            if (b03Var.h(getName(), i)) {
                int iE = i + b03Var.e(getName(), i);
                for (int i2 = 0; i2 < this.h.size(); i2++) {
                    ko0 ko0Var = this.h.get(i2);
                    if (ko0Var instanceof c03) {
                        ((c03) ko0Var).c(b03Var, iE, list, b03Var2);
                    }
                }
            }
        }
    }

    @Override // defpackage.ah1
    public void d(Canvas canvas, Matrix matrix, int i) {
        if (this.g) {
            return;
        }
        this.c.set(matrix);
        w06 w06Var = this.k;
        if (w06Var != null) {
            this.c.preConcat(w06Var.f());
            i = (int) (((((this.k.h() == null ? 100 : this.k.h().h().intValue()) / 100.0f) * i) / 255.0f) * 255.0f);
        }
        boolean z = this.i.i0() && l() && i != 255;
        if (z) {
            this.b.set(0.0f, 0.0f, 0.0f, 0.0f);
            a(this.b, this.c, true);
            this.f19279a.setAlpha(i);
            r86.m(canvas, this.b, this.f19279a);
        }
        if (z) {
            i = 255;
        }
        for (int size = this.h.size() - 1; size >= 0; size--) {
            ko0 ko0Var = this.h.get(size);
            if (ko0Var instanceof ah1) {
                ((ah1) ko0Var).d(canvas, this.c, i);
            }
        }
        if (z) {
            canvas.restore();
        }
    }

    @Override // sq.b
    public void e() {
        this.i.invalidateSelf();
    }

    @Override // defpackage.ko0
    public void f(List<ko0> list, List<ko0> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.h.size());
        arrayList.addAll(list);
        for (int size = this.h.size() - 1; size >= 0; size--) {
            ko0 ko0Var = this.h.get(size);
            ko0Var.f(arrayList, this.h.subList(0, size));
            arrayList.add(ko0Var);
        }
    }

    @Override // defpackage.ko0
    public String getName() {
        return this.f;
    }

    @Override // defpackage.rc4
    public Path getPath() {
        this.c.reset();
        w06 w06Var = this.k;
        if (w06Var != null) {
            this.c.set(w06Var.f());
        }
        this.d.reset();
        if (this.g) {
            return this.d;
        }
        for (int size = this.h.size() - 1; size >= 0; size--) {
            ko0 ko0Var = this.h.get(size);
            if (ko0Var instanceof rc4) {
                this.d.addPath(((rc4) ko0Var).getPath(), this.c);
            }
        }
        return this.d;
    }

    @Override // defpackage.c03
    public <T> void h(T t, @Nullable i93<T> i93Var) {
        w06 w06Var = this.k;
        if (w06Var != null) {
            w06Var.c(t, i93Var);
        }
    }

    public List<rc4> j() {
        if (this.j == null) {
            this.j = new ArrayList();
            for (int i = 0; i < this.h.size(); i++) {
                ko0 ko0Var = this.h.get(i);
                if (ko0Var instanceof rc4) {
                    this.j.add((rc4) ko0Var);
                }
            }
        }
        return this.j;
    }

    public Matrix k() {
        w06 w06Var = this.k;
        if (w06Var != null) {
            return w06Var.f();
        }
        this.c.reset();
        return this.c;
    }

    public final boolean l() {
        int i = 0;
        for (int i2 = 0; i2 < this.h.size(); i2++) {
            if ((this.h.get(i2) instanceof ah1) && (i = i + 1) >= 2) {
                return true;
            }
        }
        return false;
    }

    public mo0(u83 u83Var, a aVar, String str, boolean z, List<ko0> list, @Nullable pd pdVar) {
        this.f19279a = new o03();
        this.b = new RectF();
        this.c = new Matrix();
        this.d = new Path();
        this.e = new RectF();
        this.f = str;
        this.i = u83Var;
        this.g = z;
        this.h = list;
        if (pdVar != null) {
            w06 w06VarB = pdVar.b();
            this.k = w06VarB;
            w06VarB.a(aVar);
            this.k.b(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            ko0 ko0Var = list.get(size);
            if (ko0Var instanceof nd2) {
                arrayList.add((nd2) ko0Var);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((nd2) arrayList.get(size2)).b(list.listIterator(list.size()));
        }
    }
}
