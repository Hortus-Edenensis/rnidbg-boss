package defpackage;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class tc4 extends i03<PointF> {
    public final PointF i;
    public final float[] j;
    public final PathMeasure k;
    public sc4 l;

    public tc4(List<? extends h03<PointF>> list) {
        super(list);
        this.i = new PointF();
        this.j = new float[2];
        this.k = new PathMeasure();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.sq
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public PointF i(h03<PointF> h03Var, float f) {
        PointF pointF;
        sc4 sc4Var = (sc4) h03Var;
        Path pathJ = sc4Var.j();
        if (pathJ == null) {
            return h03Var.b;
        }
        i93<A> i93Var = this.e;
        if (i93Var != 0 && (pointF = (PointF) i93Var.b(sc4Var.g, sc4Var.h.floatValue(), (PointF) sc4Var.b, (PointF) sc4Var.c, e(), f, f())) != null) {
            return pointF;
        }
        if (this.l != sc4Var) {
            this.k.setPath(pathJ, false);
            this.l = sc4Var;
        }
        PathMeasure pathMeasure = this.k;
        pathMeasure.getPosTan(f * pathMeasure.getLength(), this.j, null);
        PointF pointF2 = this.i;
        float[] fArr = this.j;
        pointF2.set(fArr[0], fArr[1]);
        return this.i;
    }
}
