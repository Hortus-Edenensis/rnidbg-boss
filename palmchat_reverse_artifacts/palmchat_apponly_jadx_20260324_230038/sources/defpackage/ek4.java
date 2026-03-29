package defpackage;

import android.graphics.PointF;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class ek4 extends i03<PointF> {
    public final PointF i;

    public ek4(List<h03<PointF>> list) {
        super(list);
        this.i = new PointF();
    }

    @Override // defpackage.sq
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public PointF i(h03<PointF> h03Var, float f) {
        return j(h03Var, f, f, f);
    }

    @Override // defpackage.sq
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public PointF j(h03<PointF> h03Var, float f, float f2, float f3) {
        PointF pointF;
        PointF pointF2;
        PointF pointF3 = h03Var.b;
        if (pointF3 == null || (pointF = h03Var.c) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF4 = pointF3;
        PointF pointF5 = pointF;
        i93<A> i93Var = this.e;
        if (i93Var != 0 && (pointF2 = (PointF) i93Var.b(h03Var.g, h03Var.h.floatValue(), pointF4, pointF5, f, e(), f())) != null) {
            return pointF2;
        }
        PointF pointF6 = this.i;
        float f4 = pointF4.x;
        float f5 = f4 + (f2 * (pointF5.x - f4));
        float f6 = pointF4.y;
        pointF6.set(f5, f6 + (f3 * (pointF5.y - f6)));
        return this.i;
    }
}
