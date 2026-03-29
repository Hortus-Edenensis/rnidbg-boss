package defpackage;

import android.graphics.PointF;
import androidx.annotation.Nullable;
import java.util.Collections;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class hh5 extends sq<PointF, PointF> {
    public final PointF i;
    public final PointF j;
    public final sq<Float, Float> k;
    public final sq<Float, Float> l;

    @Nullable
    public i93<Float> m;

    @Nullable
    public i93<Float> n;

    public hh5(sq<Float, Float> sqVar, sq<Float, Float> sqVar2) {
        super(Collections.emptyList());
        this.i = new PointF();
        this.j = new PointF();
        this.k = sqVar;
        this.l = sqVar2;
        m(f());
    }

    @Override // defpackage.sq
    public void m(float f) {
        this.k.m(f);
        this.l.m(f);
        this.i.set(this.k.h().floatValue(), this.l.h().floatValue());
        for (int i = 0; i < this.f20803a.size(); i++) {
            this.f20803a.get(i).e();
        }
    }

    @Override // defpackage.sq
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public PointF h() {
        return i(null, 0.0f);
    }

    @Override // defpackage.sq
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public PointF i(h03<PointF> h03Var, float f) {
        Float fB;
        h03<Float> h03VarB;
        h03<Float> h03VarB2;
        Float fB2 = null;
        if (this.m == null || (h03VarB2 = this.k.b()) == null) {
            fB = null;
        } else {
            float fD = this.k.d();
            Float f2 = h03VarB2.h;
            i93<Float> i93Var = this.m;
            float f3 = h03VarB2.g;
            fB = i93Var.b(f3, f2 == null ? f3 : f2.floatValue(), h03VarB2.b, h03VarB2.c, f, f, fD);
        }
        if (this.n != null && (h03VarB = this.l.b()) != null) {
            float fD2 = this.l.d();
            Float f4 = h03VarB.h;
            i93<Float> i93Var2 = this.n;
            float f5 = h03VarB.g;
            fB2 = i93Var2.b(f5, f4 == null ? f5 : f4.floatValue(), h03VarB.b, h03VarB.c, f, f, fD2);
        }
        if (fB == null) {
            this.j.set(this.i.x, 0.0f);
        } else {
            this.j.set(fB.floatValue(), 0.0f);
        }
        if (fB2 == null) {
            PointF pointF = this.j;
            pointF.set(pointF.x, this.i.y);
        } else {
            PointF pointF2 = this.j;
            pointF2.set(pointF2.x, fB2.floatValue());
        }
        return this.j;
    }

    public void r(@Nullable i93<Float> i93Var) {
        i93<Float> i93Var2 = this.m;
        if (i93Var2 != null) {
            i93Var2.c(null);
        }
        this.m = i93Var;
        if (i93Var != null) {
            i93Var.c(this);
        }
    }

    public void s(@Nullable i93<Float> i93Var) {
        i93<Float> i93Var2 = this.n;
        if (i93Var2 != null) {
            i93Var2.c(null);
        }
        this.n = i93Var;
        if (i93Var != null) {
            i93Var.c(this);
        }
    }
}
