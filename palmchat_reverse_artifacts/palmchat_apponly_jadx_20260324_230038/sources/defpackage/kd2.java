package defpackage;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.layer.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class kd2 extends vr {
    public final sq<PointF, PointF> A;

    @Nullable
    public f96 B;
    public final String r;
    public final boolean s;
    public final LongSparseArray<LinearGradient> t;
    public final LongSparseArray<RadialGradient> u;
    public final RectF v;
    public final GradientType w;
    public final int x;
    public final sq<ed2, ed2> y;
    public final sq<PointF, PointF> z;

    public kd2(u83 u83Var, a aVar, com.airbnb.lottie.model.content.a aVar2) {
        super(u83Var, aVar, aVar2.b().toPaintCap(), aVar2.g().toPaintJoin(), aVar2.i(), aVar2.k(), aVar2.m(), aVar2.h(), aVar2.c());
        this.t = new LongSparseArray<>();
        this.u = new LongSparseArray<>();
        this.v = new RectF();
        this.r = aVar2.j();
        this.w = aVar2.f();
        this.s = aVar2.n();
        this.x = (int) (u83Var.L().d() / 32.0f);
        sq<ed2, ed2> sqVarA = aVar2.e().a();
        this.y = sqVarA;
        sqVarA.a(this);
        aVar.i(sqVarA);
        sq<PointF, PointF> sqVarA2 = aVar2.l().a();
        this.z = sqVarA2;
        sqVarA2.a(this);
        aVar.i(sqVarA2);
        sq<PointF, PointF> sqVarA3 = aVar2.d().a();
        this.A = sqVarA3;
        sqVarA3.a(this);
        aVar.i(sqVarA3);
    }

    @Override // defpackage.vr, defpackage.ah1
    public void d(Canvas canvas, Matrix matrix, int i) {
        if (this.s) {
            return;
        }
        a(this.v, matrix, false);
        Shader shaderL = this.w == GradientType.LINEAR ? l() : m();
        shaderL.setLocalMatrix(matrix);
        this.i.setShader(shaderL);
        super.d(canvas, matrix, i);
    }

    @Override // defpackage.ko0
    public String getName() {
        return this.r;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.vr, defpackage.c03
    public <T> void h(T t, @Nullable i93<T> i93Var) {
        super.h(t, i93Var);
        if (t == d93.L) {
            f96 f96Var = this.B;
            if (f96Var != null) {
                this.f.G(f96Var);
            }
            if (i93Var == null) {
                this.B = null;
                return;
            }
            f96 f96Var2 = new f96(i93Var);
            this.B = f96Var2;
            f96Var2.a(this);
            this.f.i(this.B);
        }
    }

    public final int[] j(int[] iArr) {
        f96 f96Var = this.B;
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

    public final int k() {
        int iRound = Math.round(this.z.f() * this.x);
        int iRound2 = Math.round(this.A.f() * this.x);
        int iRound3 = Math.round(this.y.f() * this.x);
        int i = iRound != 0 ? 527 * iRound : 17;
        if (iRound2 != 0) {
            i = i * 31 * iRound2;
        }
        return iRound3 != 0 ? i * 31 * iRound3 : i;
    }

    public final LinearGradient l() {
        long jK = k();
        LinearGradient linearGradient = this.t.get(jK);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF pointFH = this.z.h();
        PointF pointFH2 = this.A.h();
        ed2 ed2VarH = this.y.h();
        LinearGradient linearGradient2 = new LinearGradient(pointFH.x, pointFH.y, pointFH2.x, pointFH2.y, j(ed2VarH.a()), ed2VarH.b(), Shader.TileMode.CLAMP);
        this.t.put(jK, linearGradient2);
        return linearGradient2;
    }

    public final RadialGradient m() {
        long jK = k();
        RadialGradient radialGradient = this.u.get(jK);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF pointFH = this.z.h();
        PointF pointFH2 = this.A.h();
        ed2 ed2VarH = this.y.h();
        int[] iArrJ = j(ed2VarH.a());
        float[] fArrB = ed2VarH.b();
        RadialGradient radialGradient2 = new RadialGradient(pointFH.x, pointFH.y, (float) Math.hypot(pointFH2.x - r7, pointFH2.y - r8), iArrJ, fArrB, Shader.TileMode.CLAMP);
        this.u.put(jK, radialGradient2);
        return radialGradient2;
    }
}
