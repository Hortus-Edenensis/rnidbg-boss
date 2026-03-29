package defpackage;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
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
public class lv1 implements ah1, sq.b, d03 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f19082a;
    public final Paint b;
    public final a c;
    public final String d;
    public final boolean e;
    public final List<rc4> f;
    public final sq<Integer, Integer> g;
    public final sq<Integer, Integer> h;

    @Nullable
    public sq<ColorFilter, ColorFilter> i;
    public final u83 j;

    @Nullable
    public sq<Float, Float> k;
    public float l;

    @Nullable
    public ki1 m;

    public lv1(u83 u83Var, a aVar, b75 b75Var) {
        Path path = new Path();
        this.f19082a = path;
        this.b = new o03(1);
        this.f = new ArrayList();
        this.c = aVar;
        this.d = b75Var.d();
        this.e = b75Var.f();
        this.j = u83Var;
        if (aVar.v() != null) {
            sq<Float, Float> sqVarA = aVar.v().a().a();
            this.k = sqVarA;
            sqVarA.a(this);
            aVar.i(this.k);
        }
        if (aVar.x() != null) {
            this.m = new ki1(this, aVar, aVar.x());
        }
        if (b75Var.b() == null || b75Var.e() == null) {
            this.g = null;
            this.h = null;
            return;
        }
        path.setFillType(b75Var.c());
        sq<Integer, Integer> sqVarA2 = b75Var.b().a();
        this.g = sqVarA2;
        sqVarA2.a(this);
        aVar.i(sqVarA2);
        sq<Integer, Integer> sqVarA3 = b75Var.e().a();
        this.h = sqVarA3;
        sqVarA3.a(this);
        aVar.i(sqVarA3);
    }

    @Override // defpackage.ah1
    public void a(RectF rectF, Matrix matrix, boolean z) {
        this.f19082a.reset();
        for (int i = 0; i < this.f.size(); i++) {
            this.f19082a.addPath(this.f.get(i).getPath(), matrix);
        }
        this.f19082a.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // defpackage.c03
    public void c(b03 b03Var, int i, List<b03> list, b03 b03Var2) {
        sp3.k(b03Var, i, list, b03Var2, this);
    }

    @Override // defpackage.ah1
    public void d(Canvas canvas, Matrix matrix, int i) {
        if (this.e) {
            return;
        }
        m03.a("FillContent#draw");
        this.b.setColor((sp3.c((int) ((((i / 255.0f) * this.h.h().intValue()) / 100.0f) * 255.0f), 0, 255) << 24) | (((yg0) this.g).p() & 16777215));
        sq<ColorFilter, ColorFilter> sqVar = this.i;
        if (sqVar != null) {
            this.b.setColorFilter(sqVar.h());
        }
        sq<Float, Float> sqVar2 = this.k;
        if (sqVar2 != null) {
            float fFloatValue = sqVar2.h().floatValue();
            if (fFloatValue == 0.0f) {
                this.b.setMaskFilter(null);
            } else if (fFloatValue != this.l) {
                this.b.setMaskFilter(this.c.w(fFloatValue));
            }
            this.l = fFloatValue;
        }
        ki1 ki1Var = this.m;
        if (ki1Var != null) {
            ki1Var.a(this.b);
        }
        this.f19082a.reset();
        for (int i2 = 0; i2 < this.f.size(); i2++) {
            this.f19082a.addPath(this.f.get(i2).getPath(), matrix);
        }
        canvas.drawPath(this.f19082a, this.b);
        m03.b("FillContent#draw");
    }

    @Override // sq.b
    public void e() {
        this.j.invalidateSelf();
    }

    @Override // defpackage.ko0
    public void f(List<ko0> list, List<ko0> list2) {
        for (int i = 0; i < list2.size(); i++) {
            ko0 ko0Var = list2.get(i);
            if (ko0Var instanceof rc4) {
                this.f.add((rc4) ko0Var);
            }
        }
    }

    @Override // defpackage.ko0
    public String getName() {
        return this.d;
    }

    @Override // defpackage.c03
    public <T> void h(T t, @Nullable i93<T> i93Var) {
        ki1 ki1Var;
        ki1 ki1Var2;
        ki1 ki1Var3;
        ki1 ki1Var4;
        ki1 ki1Var5;
        if (t == d93.f16999a) {
            this.g.n(i93Var);
            return;
        }
        if (t == d93.d) {
            this.h.n(i93Var);
            return;
        }
        if (t == d93.K) {
            sq<ColorFilter, ColorFilter> sqVar = this.i;
            if (sqVar != null) {
                this.c.G(sqVar);
            }
            if (i93Var == null) {
                this.i = null;
                return;
            }
            f96 f96Var = new f96(i93Var);
            this.i = f96Var;
            f96Var.a(this);
            this.c.i(this.i);
            return;
        }
        if (t == d93.j) {
            sq<Float, Float> sqVar2 = this.k;
            if (sqVar2 != null) {
                sqVar2.n(i93Var);
                return;
            }
            f96 f96Var2 = new f96(i93Var);
            this.k = f96Var2;
            f96Var2.a(this);
            this.c.i(this.k);
            return;
        }
        if (t == d93.e && (ki1Var5 = this.m) != null) {
            ki1Var5.b(i93Var);
            return;
        }
        if (t == d93.G && (ki1Var4 = this.m) != null) {
            ki1Var4.f(i93Var);
            return;
        }
        if (t == d93.H && (ki1Var3 = this.m) != null) {
            ki1Var3.c(i93Var);
            return;
        }
        if (t == d93.I && (ki1Var2 = this.m) != null) {
            ki1Var2.d(i93Var);
        } else {
            if (t != d93.J || (ki1Var = this.m) == null) {
                return;
            }
            ki1Var.g(i93Var);
        }
    }
}
