package defpackage;

import android.graphics.Matrix;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.model.layer.a;
import defpackage.sq;
import java.util.Collections;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class w06 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Matrix f21579a = new Matrix();
    public final Matrix b;
    public final Matrix c;
    public final Matrix d;
    public final float[] e;

    @Nullable
    public sq<PointF, PointF> f;

    @Nullable
    public sq<?, PointF> g;

    @Nullable
    public sq<m25, m25> h;

    @Nullable
    public sq<Float, Float> i;

    @Nullable
    public sq<Integer, Integer> j;

    @Nullable
    public ux1 k;

    @Nullable
    public ux1 l;

    @Nullable
    public sq<?, Float> m;

    @Nullable
    public sq<?, Float> n;

    public w06(pd pdVar) {
        this.f = pdVar.c() == null ? null : pdVar.c().a();
        this.g = pdVar.f() == null ? null : pdVar.f().a();
        this.h = pdVar.h() == null ? null : pdVar.h().a();
        this.i = pdVar.g() == null ? null : pdVar.g().a();
        ux1 ux1Var = pdVar.i() == null ? null : (ux1) pdVar.i().a();
        this.k = ux1Var;
        if (ux1Var != null) {
            this.b = new Matrix();
            this.c = new Matrix();
            this.d = new Matrix();
            this.e = new float[9];
        } else {
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
        }
        this.l = pdVar.j() == null ? null : (ux1) pdVar.j().a();
        if (pdVar.e() != null) {
            this.j = pdVar.e().a();
        }
        if (pdVar.k() != null) {
            this.m = pdVar.k().a();
        } else {
            this.m = null;
        }
        if (pdVar.d() != null) {
            this.n = pdVar.d().a();
        } else {
            this.n = null;
        }
    }

    public void a(a aVar) {
        aVar.i(this.j);
        aVar.i(this.m);
        aVar.i(this.n);
        aVar.i(this.f);
        aVar.i(this.g);
        aVar.i(this.h);
        aVar.i(this.i);
        aVar.i(this.k);
        aVar.i(this.l);
    }

    public void b(sq.b bVar) {
        sq<Integer, Integer> sqVar = this.j;
        if (sqVar != null) {
            sqVar.a(bVar);
        }
        sq<?, Float> sqVar2 = this.m;
        if (sqVar2 != null) {
            sqVar2.a(bVar);
        }
        sq<?, Float> sqVar3 = this.n;
        if (sqVar3 != null) {
            sqVar3.a(bVar);
        }
        sq<PointF, PointF> sqVar4 = this.f;
        if (sqVar4 != null) {
            sqVar4.a(bVar);
        }
        sq<?, PointF> sqVar5 = this.g;
        if (sqVar5 != null) {
            sqVar5.a(bVar);
        }
        sq<m25, m25> sqVar6 = this.h;
        if (sqVar6 != null) {
            sqVar6.a(bVar);
        }
        sq<Float, Float> sqVar7 = this.i;
        if (sqVar7 != null) {
            sqVar7.a(bVar);
        }
        ux1 ux1Var = this.k;
        if (ux1Var != null) {
            ux1Var.a(bVar);
        }
        ux1 ux1Var2 = this.l;
        if (ux1Var2 != null) {
            ux1Var2.a(bVar);
        }
    }

    public <T> boolean c(T t, @Nullable i93<T> i93Var) {
        if (t == d93.f) {
            sq<PointF, PointF> sqVar = this.f;
            if (sqVar == null) {
                this.f = new f96(i93Var, new PointF());
                return true;
            }
            sqVar.n(i93Var);
            return true;
        }
        if (t == d93.g) {
            sq<?, PointF> sqVar2 = this.g;
            if (sqVar2 == null) {
                this.g = new f96(i93Var, new PointF());
                return true;
            }
            sqVar2.n(i93Var);
            return true;
        }
        if (t == d93.h) {
            sq<?, PointF> sqVar3 = this.g;
            if (sqVar3 instanceof hh5) {
                ((hh5) sqVar3).r(i93Var);
                return true;
            }
        }
        if (t == d93.i) {
            sq<?, PointF> sqVar4 = this.g;
            if (sqVar4 instanceof hh5) {
                ((hh5) sqVar4).s(i93Var);
                return true;
            }
        }
        if (t == d93.o) {
            sq<m25, m25> sqVar5 = this.h;
            if (sqVar5 == null) {
                this.h = new f96(i93Var, new m25());
                return true;
            }
            sqVar5.n(i93Var);
            return true;
        }
        if (t == d93.p) {
            sq<Float, Float> sqVar6 = this.i;
            if (sqVar6 == null) {
                this.i = new f96(i93Var, Float.valueOf(0.0f));
                return true;
            }
            sqVar6.n(i93Var);
            return true;
        }
        if (t == d93.c) {
            sq<Integer, Integer> sqVar7 = this.j;
            if (sqVar7 == null) {
                this.j = new f96(i93Var, 100);
                return true;
            }
            sqVar7.n(i93Var);
            return true;
        }
        if (t == d93.C) {
            sq<?, Float> sqVar8 = this.m;
            if (sqVar8 == null) {
                this.m = new f96(i93Var, Float.valueOf(100.0f));
                return true;
            }
            sqVar8.n(i93Var);
            return true;
        }
        if (t == d93.D) {
            sq<?, Float> sqVar9 = this.n;
            if (sqVar9 == null) {
                this.n = new f96(i93Var, Float.valueOf(100.0f));
                return true;
            }
            sqVar9.n(i93Var);
            return true;
        }
        if (t == d93.q) {
            if (this.k == null) {
                this.k = new ux1(Collections.singletonList(new h03(Float.valueOf(0.0f))));
            }
            this.k.n(i93Var);
            return true;
        }
        if (t != d93.r) {
            return false;
        }
        if (this.l == null) {
            this.l = new ux1(Collections.singletonList(new h03(Float.valueOf(0.0f))));
        }
        this.l.n(i93Var);
        return true;
    }

    public final void d() {
        for (int i = 0; i < 9; i++) {
            this.e[i] = 0.0f;
        }
    }

    @Nullable
    public sq<?, Float> e() {
        return this.n;
    }

    public Matrix f() {
        PointF pointFH;
        this.f21579a.reset();
        sq<?, PointF> sqVar = this.g;
        if (sqVar != null && (pointFH = sqVar.h()) != null) {
            float f = pointFH.x;
            if (f != 0.0f || pointFH.y != 0.0f) {
                this.f21579a.preTranslate(f, pointFH.y);
            }
        }
        sq<Float, Float> sqVar2 = this.i;
        if (sqVar2 != null) {
            float fFloatValue = sqVar2 instanceof f96 ? sqVar2.h().floatValue() : ((ux1) sqVar2).p();
            if (fFloatValue != 0.0f) {
                this.f21579a.preRotate(fFloatValue);
            }
        }
        if (this.k != null) {
            float fCos = this.l == null ? 0.0f : (float) Math.cos(Math.toRadians((-r3.p()) + 90.0f));
            float fSin = this.l == null ? 1.0f : (float) Math.sin(Math.toRadians((-r5.p()) + 90.0f));
            float fTan = (float) Math.tan(Math.toRadians(r0.p()));
            d();
            float[] fArr = this.e;
            fArr[0] = fCos;
            fArr[1] = fSin;
            float f2 = -fSin;
            fArr[3] = f2;
            fArr[4] = fCos;
            fArr[8] = 1.0f;
            this.b.setValues(fArr);
            d();
            float[] fArr2 = this.e;
            fArr2[0] = 1.0f;
            fArr2[3] = fTan;
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.c.setValues(fArr2);
            d();
            float[] fArr3 = this.e;
            fArr3[0] = fCos;
            fArr3[1] = f2;
            fArr3[3] = fSin;
            fArr3[4] = fCos;
            fArr3[8] = 1.0f;
            this.d.setValues(fArr3);
            this.c.preConcat(this.b);
            this.d.preConcat(this.c);
            this.f21579a.preConcat(this.d);
        }
        sq<m25, m25> sqVar3 = this.h;
        if (sqVar3 != null) {
            m25 m25VarH = sqVar3.h();
            if (m25VarH.b() != 1.0f || m25VarH.c() != 1.0f) {
                this.f21579a.preScale(m25VarH.b(), m25VarH.c());
            }
        }
        sq<PointF, PointF> sqVar4 = this.f;
        if (sqVar4 != null) {
            PointF pointFH2 = sqVar4.h();
            float f3 = pointFH2.x;
            if (f3 != 0.0f || pointFH2.y != 0.0f) {
                this.f21579a.preTranslate(-f3, -pointFH2.y);
            }
        }
        return this.f21579a;
    }

    public Matrix g(float f) {
        sq<?, PointF> sqVar = this.g;
        PointF pointFH = sqVar == null ? null : sqVar.h();
        sq<m25, m25> sqVar2 = this.h;
        m25 m25VarH = sqVar2 == null ? null : sqVar2.h();
        this.f21579a.reset();
        if (pointFH != null) {
            this.f21579a.preTranslate(pointFH.x * f, pointFH.y * f);
        }
        if (m25VarH != null) {
            double d = f;
            this.f21579a.preScale((float) Math.pow(m25VarH.b(), d), (float) Math.pow(m25VarH.c(), d));
        }
        sq<Float, Float> sqVar3 = this.i;
        if (sqVar3 != null) {
            float fFloatValue = sqVar3.h().floatValue();
            sq<PointF, PointF> sqVar4 = this.f;
            PointF pointFH2 = sqVar4 != null ? sqVar4.h() : null;
            this.f21579a.preRotate(fFloatValue * f, pointFH2 == null ? 0.0f : pointFH2.x, pointFH2 != null ? pointFH2.y : 0.0f);
        }
        return this.f21579a;
    }

    @Nullable
    public sq<?, Integer> h() {
        return this.j;
    }

    @Nullable
    public sq<?, Float> i() {
        return this.m;
    }

    public void j(float f) {
        sq<Integer, Integer> sqVar = this.j;
        if (sqVar != null) {
            sqVar.m(f);
        }
        sq<?, Float> sqVar2 = this.m;
        if (sqVar2 != null) {
            sqVar2.m(f);
        }
        sq<?, Float> sqVar3 = this.n;
        if (sqVar3 != null) {
            sqVar3.m(f);
        }
        sq<PointF, PointF> sqVar4 = this.f;
        if (sqVar4 != null) {
            sqVar4.m(f);
        }
        sq<?, PointF> sqVar5 = this.g;
        if (sqVar5 != null) {
            sqVar5.m(f);
        }
        sq<m25, m25> sqVar6 = this.h;
        if (sqVar6 != null) {
            sqVar6.m(f);
        }
        sq<Float, Float> sqVar7 = this.i;
        if (sqVar7 != null) {
            sqVar7.m(f);
        }
        ux1 ux1Var = this.k;
        if (ux1Var != null) {
            ux1Var.m(f);
        }
        ux1 ux1Var2 = this.l;
        if (ux1Var2 != null) {
            ux1Var2.m(f);
        }
    }
}
