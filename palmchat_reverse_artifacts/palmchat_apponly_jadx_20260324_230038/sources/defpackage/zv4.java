package defpackage;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.model.layer.a;
import defpackage.sq;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class zv4 implements ah1, rc4, nd2, sq.b, d03 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Matrix f22527a = new Matrix();
    public final Path b = new Path();
    public final u83 c;
    public final a d;
    public final String e;
    public final boolean f;
    public final sq<Float, Float> g;
    public final sq<Float, Float> h;
    public final w06 i;
    public mo0 j;

    public zv4(u83 u83Var, a aVar, yv4 yv4Var) {
        this.c = u83Var;
        this.d = aVar;
        this.e = yv4Var.c();
        this.f = yv4Var.f();
        sq<Float, Float> sqVarA = yv4Var.b().a();
        this.g = sqVarA;
        aVar.i(sqVarA);
        sqVarA.a(this);
        sq<Float, Float> sqVarA2 = yv4Var.d().a();
        this.h = sqVarA2;
        aVar.i(sqVarA2);
        sqVarA2.a(this);
        w06 w06VarB = yv4Var.e().b();
        this.i = w06VarB;
        w06VarB.a(aVar);
        w06VarB.b(this);
    }

    @Override // defpackage.ah1
    public void a(RectF rectF, Matrix matrix, boolean z) {
        this.j.a(rectF, matrix, z);
    }

    @Override // defpackage.nd2
    public void b(ListIterator<ko0> listIterator) {
        if (this.j != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add(listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        this.j = new mo0(this.c, this.d, "Repeater", this.f, arrayList, null);
    }

    @Override // defpackage.c03
    public void c(b03 b03Var, int i, List<b03> list, b03 b03Var2) {
        sp3.k(b03Var, i, list, b03Var2, this);
    }

    @Override // defpackage.ah1
    public void d(Canvas canvas, Matrix matrix, int i) {
        float fFloatValue = this.g.h().floatValue();
        float fFloatValue2 = this.h.h().floatValue();
        float fFloatValue3 = this.i.i().h().floatValue() / 100.0f;
        float fFloatValue4 = this.i.e().h().floatValue() / 100.0f;
        for (int i2 = ((int) fFloatValue) - 1; i2 >= 0; i2--) {
            this.f22527a.set(matrix);
            float f = i2;
            this.f22527a.preConcat(this.i.g(f + fFloatValue2));
            this.j.d(canvas, this.f22527a, (int) (i * sp3.i(fFloatValue3, fFloatValue4, f / fFloatValue)));
        }
    }

    @Override // sq.b
    public void e() {
        this.c.invalidateSelf();
    }

    @Override // defpackage.ko0
    public void f(List<ko0> list, List<ko0> list2) {
        this.j.f(list, list2);
    }

    @Override // defpackage.ko0
    public String getName() {
        return this.e;
    }

    @Override // defpackage.rc4
    public Path getPath() {
        Path path = this.j.getPath();
        this.b.reset();
        float fFloatValue = this.g.h().floatValue();
        float fFloatValue2 = this.h.h().floatValue();
        for (int i = ((int) fFloatValue) - 1; i >= 0; i--) {
            this.f22527a.set(this.i.g(i + fFloatValue2));
            this.b.addPath(path, this.f22527a);
        }
        return this.b;
    }

    @Override // defpackage.c03
    public <T> void h(T t, @Nullable i93<T> i93Var) {
        if (this.i.c(t, i93Var)) {
            return;
        }
        if (t == d93.u) {
            this.g.n(i93Var);
        } else if (t == d93.v) {
            this.h.n(i93Var);
        }
    }
}
