package defpackage;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import androidx.annotation.Nullable;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.model.layer.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class ql5 extends vr {
    public final a r;
    public final String s;
    public final boolean t;
    public final sq<Integer, Integer> u;

    @Nullable
    public sq<ColorFilter, ColorFilter> v;

    public ql5(u83 u83Var, a aVar, ShapeStroke shapeStroke) {
        super(u83Var, aVar, shapeStroke.b().toPaintCap(), shapeStroke.e().toPaintJoin(), shapeStroke.g(), shapeStroke.i(), shapeStroke.j(), shapeStroke.f(), shapeStroke.d());
        this.r = aVar;
        this.s = shapeStroke.h();
        this.t = shapeStroke.k();
        sq<Integer, Integer> sqVarA = shapeStroke.c().a();
        this.u = sqVarA;
        sqVarA.a(this);
        aVar.i(sqVarA);
    }

    @Override // defpackage.vr, defpackage.ah1
    public void d(Canvas canvas, Matrix matrix, int i) {
        if (this.t) {
            return;
        }
        this.i.setColor(((yg0) this.u).p());
        sq<ColorFilter, ColorFilter> sqVar = this.v;
        if (sqVar != null) {
            this.i.setColorFilter(sqVar.h());
        }
        super.d(canvas, matrix, i);
    }

    @Override // defpackage.ko0
    public String getName() {
        return this.s;
    }

    @Override // defpackage.vr, defpackage.c03
    public <T> void h(T t, @Nullable i93<T> i93Var) {
        super.h(t, i93Var);
        if (t == d93.b) {
            this.u.n(i93Var);
            return;
        }
        if (t == d93.K) {
            sq<ColorFilter, ColorFilter> sqVar = this.v;
            if (sqVar != null) {
                this.r.G(sqVar);
            }
            if (i93Var == null) {
                this.v = null;
                return;
            }
            f96 f96Var = new f96(i93Var);
            this.v = f96Var;
            f96Var.a(this);
            this.r.i(this.u);
        }
    }
}
