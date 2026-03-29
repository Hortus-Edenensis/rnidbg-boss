package defpackage;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import defpackage.sq;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public abstract class vr implements sq.b, d03, ah1 {
    public final u83 e;
    public final com.airbnb.lottie.model.layer.a f;
    public final float[] h;
    public final Paint i;
    public final sq<?, Float> j;
    public final sq<?, Integer> k;
    public final List<sq<?, Float>> l;

    @Nullable
    public final sq<?, Float> m;

    @Nullable
    public sq<ColorFilter, ColorFilter> n;

    @Nullable
    public sq<Float, Float> o;
    public float p;

    @Nullable
    public ki1 q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PathMeasure f21513a = new PathMeasure();
    public final Path b = new Path();
    public final Path c = new Path();
    public final RectF d = new RectF();
    public final List<b> g = new ArrayList();

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<rc4> f21514a;

        @Nullable
        public final q16 b;

        public b(@Nullable q16 q16Var) {
            this.f21514a = new ArrayList();
            this.b = q16Var;
        }
    }

    public vr(u83 u83Var, com.airbnb.lottie.model.layer.a aVar, Paint.Cap cap, Paint.Join join, float f, fd fdVar, dd ddVar, List<dd> list, dd ddVar2) {
        o03 o03Var = new o03(1);
        this.i = o03Var;
        this.p = 0.0f;
        this.e = u83Var;
        this.f = aVar;
        o03Var.setStyle(Paint.Style.STROKE);
        o03Var.setStrokeCap(cap);
        o03Var.setStrokeJoin(join);
        o03Var.setStrokeMiter(f);
        this.k = fdVar.a();
        this.j = ddVar.a();
        if (ddVar2 == null) {
            this.m = null;
        } else {
            this.m = ddVar2.a();
        }
        this.l = new ArrayList(list.size());
        this.h = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.l.add(list.get(i).a());
        }
        aVar.i(this.k);
        aVar.i(this.j);
        for (int i2 = 0; i2 < this.l.size(); i2++) {
            aVar.i(this.l.get(i2));
        }
        sq<?, Float> sqVar = this.m;
        if (sqVar != null) {
            aVar.i(sqVar);
        }
        this.k.a(this);
        this.j.a(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.l.get(i3).a(this);
        }
        sq<?, Float> sqVar2 = this.m;
        if (sqVar2 != null) {
            sqVar2.a(this);
        }
        if (aVar.v() != null) {
            sq<Float, Float> sqVarA = aVar.v().a().a();
            this.o = sqVarA;
            sqVarA.a(this);
            aVar.i(this.o);
        }
        if (aVar.x() != null) {
            this.q = new ki1(this, aVar, aVar.x());
        }
    }

    @Override // defpackage.ah1
    public void a(RectF rectF, Matrix matrix, boolean z) {
        m03.a("StrokeContent#getBounds");
        this.b.reset();
        for (int i = 0; i < this.g.size(); i++) {
            b bVar = this.g.get(i);
            for (int i2 = 0; i2 < bVar.f21514a.size(); i2++) {
                this.b.addPath(((rc4) bVar.f21514a.get(i2)).getPath(), matrix);
            }
        }
        this.b.computeBounds(this.d, false);
        float fP = ((ux1) this.j).p();
        RectF rectF2 = this.d;
        float f = fP / 2.0f;
        rectF2.set(rectF2.left - f, rectF2.top - f, rectF2.right + f, rectF2.bottom + f);
        rectF.set(this.d);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        m03.b("StrokeContent#getBounds");
    }

    public final void b(Matrix matrix) {
        m03.a("StrokeContent#applyDashPattern");
        if (this.l.isEmpty()) {
            m03.b("StrokeContent#applyDashPattern");
            return;
        }
        float fG = r86.g(matrix);
        for (int i = 0; i < this.l.size(); i++) {
            this.h[i] = this.l.get(i).h().floatValue();
            if (i % 2 == 0) {
                float[] fArr = this.h;
                if (fArr[i] < 1.0f) {
                    fArr[i] = 1.0f;
                }
            } else {
                float[] fArr2 = this.h;
                if (fArr2[i] < 0.1f) {
                    fArr2[i] = 0.1f;
                }
            }
            float[] fArr3 = this.h;
            fArr3[i] = fArr3[i] * fG;
        }
        sq<?, Float> sqVar = this.m;
        this.i.setPathEffect(new DashPathEffect(this.h, sqVar == null ? 0.0f : fG * sqVar.h().floatValue()));
        m03.b("StrokeContent#applyDashPattern");
    }

    @Override // defpackage.c03
    public void c(b03 b03Var, int i, List<b03> list, b03 b03Var2) {
        sp3.k(b03Var, i, list, b03Var2, this);
    }

    public void d(Canvas canvas, Matrix matrix, int i) {
        m03.a("StrokeContent#draw");
        if (r86.h(matrix)) {
            m03.b("StrokeContent#draw");
            return;
        }
        this.i.setAlpha(sp3.c((int) ((((i / 255.0f) * ((pt2) this.k).p()) / 100.0f) * 255.0f), 0, 255));
        this.i.setStrokeWidth(((ux1) this.j).p() * r86.g(matrix));
        if (this.i.getStrokeWidth() <= 0.0f) {
            m03.b("StrokeContent#draw");
            return;
        }
        b(matrix);
        sq<ColorFilter, ColorFilter> sqVar = this.n;
        if (sqVar != null) {
            this.i.setColorFilter(sqVar.h());
        }
        sq<Float, Float> sqVar2 = this.o;
        if (sqVar2 != null) {
            float fFloatValue = sqVar2.h().floatValue();
            if (fFloatValue == 0.0f) {
                this.i.setMaskFilter(null);
            } else if (fFloatValue != this.p) {
                this.i.setMaskFilter(this.f.w(fFloatValue));
            }
            this.p = fFloatValue;
        }
        ki1 ki1Var = this.q;
        if (ki1Var != null) {
            ki1Var.a(this.i);
        }
        for (int i2 = 0; i2 < this.g.size(); i2++) {
            b bVar = this.g.get(i2);
            if (bVar.b != null) {
                i(canvas, bVar, matrix);
            } else {
                m03.a("StrokeContent#buildPath");
                this.b.reset();
                for (int size = bVar.f21514a.size() - 1; size >= 0; size--) {
                    this.b.addPath(((rc4) bVar.f21514a.get(size)).getPath(), matrix);
                }
                m03.b("StrokeContent#buildPath");
                m03.a("StrokeContent#drawPath");
                canvas.drawPath(this.b, this.i);
                m03.b("StrokeContent#drawPath");
            }
        }
        m03.b("StrokeContent#draw");
    }

    @Override // sq.b
    public void e() {
        this.e.invalidateSelf();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0055  */
    @Override // defpackage.ko0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f(List<ko0> list, List<ko0> list2) {
        q16 q16Var = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            ko0 ko0Var = list.get(size);
            if (ko0Var instanceof q16) {
                q16 q16Var2 = (q16) ko0Var;
                if (q16Var2.j() == ShapeTrimPath.Type.INDIVIDUALLY) {
                    q16Var = q16Var2;
                }
            }
        }
        if (q16Var != null) {
            q16Var.b(this);
        }
        b bVar = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            ko0 ko0Var2 = list2.get(size2);
            if (ko0Var2 instanceof q16) {
                q16 q16Var3 = (q16) ko0Var2;
                if (q16Var3.j() == ShapeTrimPath.Type.INDIVIDUALLY) {
                    if (bVar != null) {
                        this.g.add(bVar);
                    }
                    bVar = new b(q16Var3);
                    q16Var3.b(this);
                } else if (ko0Var2 instanceof rc4) {
                    if (bVar == null) {
                        bVar = new b(q16Var);
                    }
                    bVar.f21514a.add((rc4) ko0Var2);
                }
            }
        }
        if (bVar != null) {
            this.g.add(bVar);
        }
    }

    @CallSuper
    public <T> void h(T t, @Nullable i93<T> i93Var) {
        ki1 ki1Var;
        ki1 ki1Var2;
        ki1 ki1Var3;
        ki1 ki1Var4;
        ki1 ki1Var5;
        if (t == d93.d) {
            this.k.n(i93Var);
            return;
        }
        if (t == d93.s) {
            this.j.n(i93Var);
            return;
        }
        if (t == d93.K) {
            sq<ColorFilter, ColorFilter> sqVar = this.n;
            if (sqVar != null) {
                this.f.G(sqVar);
            }
            if (i93Var == null) {
                this.n = null;
                return;
            }
            f96 f96Var = new f96(i93Var);
            this.n = f96Var;
            f96Var.a(this);
            this.f.i(this.n);
            return;
        }
        if (t == d93.j) {
            sq<Float, Float> sqVar2 = this.o;
            if (sqVar2 != null) {
                sqVar2.n(i93Var);
                return;
            }
            f96 f96Var2 = new f96(i93Var);
            this.o = f96Var2;
            f96Var2.a(this);
            this.f.i(this.o);
            return;
        }
        if (t == d93.e && (ki1Var5 = this.q) != null) {
            ki1Var5.b(i93Var);
            return;
        }
        if (t == d93.G && (ki1Var4 = this.q) != null) {
            ki1Var4.f(i93Var);
            return;
        }
        if (t == d93.H && (ki1Var3 = this.q) != null) {
            ki1Var3.c(i93Var);
            return;
        }
        if (t == d93.I && (ki1Var2 = this.q) != null) {
            ki1Var2.d(i93Var);
        } else {
            if (t != d93.J || (ki1Var = this.q) == null) {
                return;
            }
            ki1Var.g(i93Var);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x011f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void i(Canvas canvas, b bVar, Matrix matrix) {
        m03.a("StrokeContent#applyTrimPath");
        if (bVar.b == null) {
            m03.b("StrokeContent#applyTrimPath");
            return;
        }
        this.b.reset();
        for (int size = bVar.f21514a.size() - 1; size >= 0; size--) {
            this.b.addPath(((rc4) bVar.f21514a.get(size)).getPath(), matrix);
        }
        float fFloatValue = bVar.b.i().h().floatValue() / 100.0f;
        float fFloatValue2 = bVar.b.c().h().floatValue() / 100.0f;
        float fFloatValue3 = bVar.b.h().h().floatValue() / 360.0f;
        if (fFloatValue < 0.01f && fFloatValue2 > 0.99f) {
            canvas.drawPath(this.b, this.i);
            m03.b("StrokeContent#applyTrimPath");
            return;
        }
        this.f21513a.setPath(this.b, false);
        float length = this.f21513a.getLength();
        while (this.f21513a.nextContour()) {
            length += this.f21513a.getLength();
        }
        float f = fFloatValue3 * length;
        float f2 = (fFloatValue * length) + f;
        float fMin = Math.min((fFloatValue2 * length) + f, (f2 + length) - 1.0f);
        float f3 = 0.0f;
        for (int size2 = bVar.f21514a.size() - 1; size2 >= 0; size2--) {
            this.c.set(((rc4) bVar.f21514a.get(size2)).getPath());
            this.c.transform(matrix);
            this.f21513a.setPath(this.c, false);
            float length2 = this.f21513a.getLength();
            if (fMin > length) {
                float f4 = fMin - length;
                if (f4 >= f3 + length2 || f3 >= f4) {
                    float f5 = f3 + length2;
                    if (f5 >= f2 && f3 <= fMin) {
                        if (f5 > fMin || f2 >= f3) {
                            r86.a(this.c, f2 < f3 ? 0.0f : (f2 - f3) / length2, fMin > f5 ? 1.0f : (fMin - f3) / length2, 0.0f);
                            canvas.drawPath(this.c, this.i);
                        } else {
                            canvas.drawPath(this.c, this.i);
                        }
                    }
                } else {
                    r86.a(this.c, f2 > length ? (f2 - length) / length2 : 0.0f, Math.min(f4 / length2, 1.0f), 0.0f);
                    canvas.drawPath(this.c, this.i);
                }
            }
            f3 += length2;
        }
        m03.b("StrokeContent#applyTrimPath");
    }
}
