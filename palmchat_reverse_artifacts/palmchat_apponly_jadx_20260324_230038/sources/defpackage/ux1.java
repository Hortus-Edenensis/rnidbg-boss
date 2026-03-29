package defpackage;

import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class ux1 extends i03<Float> {
    public ux1(List<h03<Float>> list) {
        super(list);
    }

    public float p() {
        return q(b(), d());
    }

    public float q(h03<Float> h03Var, float f) {
        Float f2;
        if (h03Var.b == null || h03Var.c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        i93<A> i93Var = this.e;
        return (i93Var == 0 || (f2 = (Float) i93Var.b(h03Var.g, h03Var.h.floatValue(), h03Var.b, h03Var.c, f, e(), f())) == null) ? sp3.i(h03Var.f(), h03Var.c(), f) : f2.floatValue();
    }

    @Override // defpackage.sq
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public Float i(h03<Float> h03Var, float f) {
        return Float.valueOf(q(h03Var, f));
    }
}
