package defpackage;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.a;
import defpackage.sq;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class cu4 implements sq.b, d03, rc4 {
    public final String c;
    public final boolean d;
    public final u83 e;
    public final sq<?, PointF> f;
    public final sq<?, PointF> g;
    public final sq<?, Float> h;
    public boolean k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f16918a = new Path();
    public final RectF b = new RectF();
    public final uk0 i = new uk0();

    @Nullable
    public sq<Float, Float> j = null;

    public cu4(u83 u83Var, a aVar, du4 du4Var) {
        this.c = du4Var.c();
        this.d = du4Var.f();
        this.e = u83Var;
        sq<PointF, PointF> sqVarA = du4Var.d().a();
        this.f = sqVarA;
        sq<PointF, PointF> sqVarA2 = du4Var.e().a();
        this.g = sqVarA2;
        sq<Float, Float> sqVarA3 = du4Var.b().a();
        this.h = sqVarA3;
        aVar.i(sqVarA);
        aVar.i(sqVarA2);
        aVar.i(sqVarA3);
        sqVarA.a(this);
        sqVarA2.a(this);
        sqVarA3.a(this);
    }

    public final void b() {
        this.k = false;
        this.e.invalidateSelf();
    }

    @Override // defpackage.c03
    public void c(b03 b03Var, int i, List<b03> list, b03 b03Var2) {
        sp3.k(b03Var, i, list, b03Var2, this);
    }

    @Override // sq.b
    public void e() {
        b();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    @Override // defpackage.ko0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f(List<ko0> list, List<ko0> list2) {
        for (int i = 0; i < list.size(); i++) {
            ko0 ko0Var = list.get(i);
            if (ko0Var instanceof q16) {
                q16 q16Var = (q16) ko0Var;
                if (q16Var.j() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.i.a(q16Var);
                    q16Var.b(this);
                } else if (ko0Var instanceof xy4) {
                    this.j = ((xy4) ko0Var).h();
                }
            }
        }
    }

    @Override // defpackage.ko0
    public String getName() {
        return this.c;
    }

    @Override // defpackage.rc4
    public Path getPath() {
        sq<Float, Float> sqVar;
        if (this.k) {
            return this.f16918a;
        }
        this.f16918a.reset();
        if (this.d) {
            this.k = true;
            return this.f16918a;
        }
        PointF pointFH = this.g.h();
        float f = pointFH.x / 2.0f;
        float f2 = pointFH.y / 2.0f;
        sq<?, Float> sqVar2 = this.h;
        float fP = sqVar2 == null ? 0.0f : ((ux1) sqVar2).p();
        if (fP == 0.0f && (sqVar = this.j) != null) {
            fP = Math.min(sqVar.h().floatValue(), Math.min(f, f2));
        }
        float fMin = Math.min(f, f2);
        if (fP > fMin) {
            fP = fMin;
        }
        PointF pointFH2 = this.f.h();
        this.f16918a.moveTo(pointFH2.x + f, (pointFH2.y - f2) + fP);
        this.f16918a.lineTo(pointFH2.x + f, (pointFH2.y + f2) - fP);
        if (fP > 0.0f) {
            RectF rectF = this.b;
            float f3 = pointFH2.x;
            float f4 = fP * 2.0f;
            float f5 = pointFH2.y;
            rectF.set((f3 + f) - f4, (f5 + f2) - f4, f3 + f, f5 + f2);
            this.f16918a.arcTo(this.b, 0.0f, 90.0f, false);
        }
        this.f16918a.lineTo((pointFH2.x - f) + fP, pointFH2.y + f2);
        if (fP > 0.0f) {
            RectF rectF2 = this.b;
            float f6 = pointFH2.x;
            float f7 = pointFH2.y;
            float f8 = fP * 2.0f;
            rectF2.set(f6 - f, (f7 + f2) - f8, (f6 - f) + f8, f7 + f2);
            this.f16918a.arcTo(this.b, 90.0f, 90.0f, false);
        }
        this.f16918a.lineTo(pointFH2.x - f, (pointFH2.y - f2) + fP);
        if (fP > 0.0f) {
            RectF rectF3 = this.b;
            float f9 = pointFH2.x;
            float f10 = pointFH2.y;
            float f11 = fP * 2.0f;
            rectF3.set(f9 - f, f10 - f2, (f9 - f) + f11, (f10 - f2) + f11);
            this.f16918a.arcTo(this.b, 180.0f, 90.0f, false);
        }
        this.f16918a.lineTo((pointFH2.x + f) - fP, pointFH2.y - f2);
        if (fP > 0.0f) {
            RectF rectF4 = this.b;
            float f12 = pointFH2.x;
            float f13 = fP * 2.0f;
            float f14 = pointFH2.y;
            rectF4.set((f12 + f) - f13, f14 - f2, f12 + f, (f14 - f2) + f13);
            this.f16918a.arcTo(this.b, 270.0f, 90.0f, false);
        }
        this.f16918a.close();
        this.i.b(this.f16918a);
        this.k = true;
        return this.f16918a;
    }

    @Override // defpackage.c03
    public <T> void h(T t, @Nullable i93<T> i93Var) {
        if (t == d93.l) {
            this.g.n(i93Var);
        } else if (t == d93.n) {
            this.f.n(i93Var);
        } else if (t == d93.m) {
            this.h.n(i93Var);
        }
    }
}
