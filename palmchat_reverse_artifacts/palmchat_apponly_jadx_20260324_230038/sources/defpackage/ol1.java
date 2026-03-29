package defpackage;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.a;
import defpackage.sq;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class ol1 implements rc4, sq.b, d03 {
    public final String b;
    public final u83 c;
    public final sq<?, PointF> d;
    public final sq<?, PointF> e;
    public final cc0 f;
    public boolean h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f19787a = new Path();
    public final uk0 g = new uk0();

    public ol1(u83 u83Var, a aVar, cc0 cc0Var) {
        this.b = cc0Var.b();
        this.c = u83Var;
        sq<PointF, PointF> sqVarA = cc0Var.d().a();
        this.d = sqVarA;
        sq<PointF, PointF> sqVarA2 = cc0Var.c().a();
        this.e = sqVarA2;
        this.f = cc0Var;
        aVar.i(sqVarA);
        aVar.i(sqVarA2);
        sqVarA.a(this);
        sqVarA2.a(this);
    }

    public final void b() {
        this.h = false;
        this.c.invalidateSelf();
    }

    @Override // defpackage.c03
    public void c(b03 b03Var, int i, List<b03> list, b03 b03Var2) {
        sp3.k(b03Var, i, list, b03Var2, this);
    }

    @Override // sq.b
    public void e() {
        b();
    }

    @Override // defpackage.ko0
    public void f(List<ko0> list, List<ko0> list2) {
        for (int i = 0; i < list.size(); i++) {
            ko0 ko0Var = list.get(i);
            if (ko0Var instanceof q16) {
                q16 q16Var = (q16) ko0Var;
                if (q16Var.j() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.g.a(q16Var);
                    q16Var.b(this);
                }
            }
        }
    }

    @Override // defpackage.ko0
    public String getName() {
        return this.b;
    }

    @Override // defpackage.rc4
    public Path getPath() {
        if (this.h) {
            return this.f19787a;
        }
        this.f19787a.reset();
        if (this.f.e()) {
            this.h = true;
            return this.f19787a;
        }
        PointF pointFH = this.d.h();
        float f = pointFH.x / 2.0f;
        float f2 = pointFH.y / 2.0f;
        float f3 = f * 0.55228f;
        float f4 = 0.55228f * f2;
        this.f19787a.reset();
        if (this.f.f()) {
            float f5 = -f2;
            this.f19787a.moveTo(0.0f, f5);
            float f6 = 0.0f - f3;
            float f7 = -f;
            float f8 = 0.0f - f4;
            this.f19787a.cubicTo(f6, f5, f7, f8, f7, 0.0f);
            float f9 = f4 + 0.0f;
            this.f19787a.cubicTo(f7, f9, f6, f2, 0.0f, f2);
            float f10 = f3 + 0.0f;
            this.f19787a.cubicTo(f10, f2, f, f9, f, 0.0f);
            this.f19787a.cubicTo(f, f8, f10, f5, 0.0f, f5);
        } else {
            float f11 = -f2;
            this.f19787a.moveTo(0.0f, f11);
            float f12 = f3 + 0.0f;
            float f13 = 0.0f - f4;
            this.f19787a.cubicTo(f12, f11, f, f13, f, 0.0f);
            float f14 = f4 + 0.0f;
            this.f19787a.cubicTo(f, f14, f12, f2, 0.0f, f2);
            float f15 = 0.0f - f3;
            float f16 = -f;
            this.f19787a.cubicTo(f15, f2, f16, f14, f16, 0.0f);
            this.f19787a.cubicTo(f16, f13, f15, f11, 0.0f, f11);
        }
        PointF pointFH2 = this.e.h();
        this.f19787a.offset(pointFH2.x, pointFH2.y);
        this.f19787a.close();
        this.g.b(this.f19787a);
        this.h = true;
        return this.f19787a;
    }

    @Override // defpackage.c03
    public <T> void h(T t, @Nullable i93<T> i93Var) {
        if (t == d93.k) {
            this.d.n(i93Var);
        } else if (t == d93.n) {
            this.e.n(i93Var);
        }
    }
}
