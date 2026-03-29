package defpackage;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.layer.a;
import defpackage.sq;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class id2 implements ah1, sq.b, d03 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final String f18150a;
    public final boolean b;
    public final a c;
    public final LongSparseArray<LinearGradient> d = new LongSparseArray<>();
    public final LongSparseArray<RadialGradient> e = new LongSparseArray<>();
    public final Path f;
    public final Paint g;
    public final RectF h;
    public final List<rc4> i;
    public final GradientType j;
    public final sq<ed2, ed2> k;
    public final sq<Integer, Integer> l;
    public final sq<PointF, PointF> m;
    public final sq<PointF, PointF> n;

    @Nullable
    public sq<ColorFilter, ColorFilter> o;

    @Nullable
    public f96 p;
    public final u83 q;
    public final int r;

    @Nullable
    public sq<Float, Float> s;
    public float t;

    @Nullable
    public ki1 u;

    public id2(u83 u83Var, a aVar, hd2 hd2Var) {
        Path path = new Path();
        this.f = path;
        this.g = new o03(1);
        this.h = new RectF();
        this.i = new ArrayList();
        this.t = 0.0f;
        this.c = aVar;
        this.f18150a = hd2Var.f();
        this.b = hd2Var.i();
        this.q = u83Var;
        this.j = hd2Var.e();
        path.setFillType(hd2Var.c());
        this.r = (int) (u83Var.L().d() / 32.0f);
        sq<ed2, ed2> sqVarA = hd2Var.d().a();
        this.k = sqVarA;
        sqVarA.a(this);
        aVar.i(sqVarA);
        sq<Integer, Integer> sqVarA2 = hd2Var.g().a();
        this.l = sqVarA2;
        sqVarA2.a(this);
        aVar.i(sqVarA2);
        sq<PointF, PointF> sqVarA3 = hd2Var.h().a();
        this.m = sqVarA3;
        sqVarA3.a(this);
        aVar.i(sqVarA3);
        sq<PointF, PointF> sqVarA4 = hd2Var.b().a();
        this.n = sqVarA4;
        sqVarA4.a(this);
        aVar.i(sqVarA4);
        if (aVar.v() != null) {
            sq<Float, Float> sqVarA5 = aVar.v().a().a();
            this.s = sqVarA5;
            sqVarA5.a(this);
            aVar.i(this.s);
        }
        if (aVar.x() != null) {
            this.u = new ki1(this, aVar, aVar.x());
        }
    }

    @Override // defpackage.ah1
    public void a(RectF rectF, Matrix matrix, boolean z) {
        this.f.reset();
        for (int i = 0; i < this.i.size(); i++) {
            this.f.addPath(this.i.get(i).getPath(), matrix);
        }
        this.f.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    public final int[] b(int[] iArr) {
        f96 f96Var = this.p;
        if (f96Var != null) {
            Integer[] numArr = (Integer[]) f96Var.h();
            int i = 0;
            if (iArr.length == numArr.length) {
                while (i < iArr.length) {
                    iArr[i] = numArr[i].intValue();
                    i++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i < numArr.length) {
                    iArr[i] = numArr[i].intValue();
                    i++;
                }
            }
        }
        return iArr;
    }

    @Override // defpackage.c03
    public void c(b03 b03Var, int i, List<b03> list, b03 b03Var2) {
        sp3.k(b03Var, i, list, b03Var2, this);
    }

    @Override // defpackage.ah1
    public void d(Canvas canvas, Matrix matrix, int i) {
        if (this.b) {
            return;
        }
        m03.a("GradientFillContent#draw");
        this.f.reset();
        for (int i2 = 0; i2 < this.i.size(); i2++) {
            this.f.addPath(this.i.get(i2).getPath(), matrix);
        }
        this.f.computeBounds(this.h, false);
        Shader shaderJ = this.j == GradientType.LINEAR ? j() : k();
        shaderJ.setLocalMatrix(matrix);
        this.g.setShader(shaderJ);
        sq<ColorFilter, ColorFilter> sqVar = this.o;
        if (sqVar != null) {
            this.g.setColorFilter(sqVar.h());
        }
        sq<Float, Float> sqVar2 = this.s;
        if (sqVar2 != null) {
            float fFloatValue = sqVar2.h().floatValue();
            if (fFloatValue == 0.0f) {
                this.g.setMaskFilter(null);
            } else if (fFloatValue != this.t) {
                this.g.setMaskFilter(new BlurMaskFilter(fFloatValue, BlurMaskFilter.Blur.NORMAL));
            }
            this.t = fFloatValue;
        }
        ki1 ki1Var = this.u;
        if (ki1Var != null) {
            ki1Var.a(this.g);
        }
        this.g.setAlpha(sp3.c((int) ((((i / 255.0f) * this.l.h().intValue()) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.f, this.g);
        m03.b("GradientFillContent#draw");
    }

    @Override // sq.b
    public void e() {
        this.q.invalidateSelf();
    }

    @Override // defpackage.ko0
    public void f(List<ko0> list, List<ko0> list2) {
        for (int i = 0; i < list2.size(); i++) {
            ko0 ko0Var = list2.get(i);
            if (ko0Var instanceof rc4) {
                this.i.add((rc4) ko0Var);
            }
        }
    }

    @Override // defpackage.ko0
    public String getName() {
        return this.f18150a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.c03
    public <T> void h(T t, @Nullable i93<T> i93Var) {
        ki1 ki1Var;
        ki1 ki1Var2;
        ki1 ki1Var3;
        ki1 ki1Var4;
        ki1 ki1Var5;
        if (t == d93.d) {
            this.l.n(i93Var);
            return;
        }
        if (t == d93.K) {
            sq<ColorFilter, ColorFilter> sqVar = this.o;
            if (sqVar != null) {
                this.c.G(sqVar);
            }
            if (i93Var == null) {
                this.o = null;
                return;
            }
            f96 f96Var = new f96(i93Var);
            this.o = f96Var;
            f96Var.a(this);
            this.c.i(this.o);
            return;
        }
        if (t == d93.L) {
            f96 f96Var2 = this.p;
            if (f96Var2 != null) {
                this.c.G(f96Var2);
            }
            if (i93Var == null) {
                this.p = null;
                return;
            }
            this.d.clear();
            this.e.clear();
            f96 f96Var3 = new f96(i93Var);
            this.p = f96Var3;
            f96Var3.a(this);
            this.c.i(this.p);
            return;
        }
        if (t == d93.j) {
            sq<Float, Float> sqVar2 = this.s;
            if (sqVar2 != null) {
                sqVar2.n(i93Var);
                return;
            }
            f96 f96Var4 = new f96(i93Var);
            this.s = f96Var4;
            f96Var4.a(this);
            this.c.i(this.s);
            return;
        }
        if (t == d93.e && (ki1Var5 = this.u) != null) {
            ki1Var5.b(i93Var);
            return;
        }
        if (t == d93.G && (ki1Var4 = this.u) != null) {
            ki1Var4.f(i93Var);
            return;
        }
        if (t == d93.H && (ki1Var3 = this.u) != null) {
            ki1Var3.c(i93Var);
            return;
        }
        if (t == d93.I && (ki1Var2 = this.u) != null) {
            ki1Var2.d(i93Var);
        } else {
            if (t != d93.J || (ki1Var = this.u) == null) {
                return;
            }
            ki1Var.g(i93Var);
        }
    }

    public final int i() {
        int iRound = Math.round(this.m.f() * this.r);
        int iRound2 = Math.round(this.n.f() * this.r);
        int iRound3 = Math.round(this.k.f() * this.r);
        int i = iRound != 0 ? 527 * iRound : 17;
        if (iRound2 != 0) {
            i = i * 31 * iRound2;
        }
        return iRound3 != 0 ? i * 31 * iRound3 : i;
    }

    public final LinearGradient j() {
        long jI = i();
        LinearGradient linearGradient = this.d.get(jI);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF pointFH = this.m.h();
        PointF pointFH2 = this.n.h();
        ed2 ed2VarH = this.k.h();
        LinearGradient linearGradient2 = new LinearGradient(pointFH.x, pointFH.y, pointFH2.x, pointFH2.y, b(ed2VarH.a()), ed2VarH.b(), Shader.TileMode.CLAMP);
        this.d.put(jI, linearGradient2);
        return linearGradient2;
    }

    public final RadialGradient k() {
        long jI = i();
        RadialGradient radialGradient = this.e.get(jI);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF pointFH = this.m.h();
        PointF pointFH2 = this.n.h();
        ed2 ed2VarH = this.k.h();
        int[] iArrB = b(ed2VarH.a());
        float[] fArrB = ed2VarH.b();
        float f = pointFH.x;
        float f2 = pointFH.y;
        float fHypot = (float) Math.hypot(pointFH2.x - f, pointFH2.y - f2);
        RadialGradient radialGradient2 = new RadialGradient(f, f2, fHypot <= 0.0f ? 0.001f : fHypot, iArrB, fArrB, Shader.TileMode.CLAMP);
        this.e.put(jI, radialGradient2);
        return radialGradient2;
    }
}
