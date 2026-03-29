package defpackage;

import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class yg0 extends i03<Integer> {
    public yg0(List<h03<Integer>> list) {
        super(list);
    }

    public int p() {
        return q(b(), d());
    }

    public int q(h03<Integer> h03Var, float f) {
        Integer num;
        if (h03Var.b == null || h03Var.c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        i93<A> i93Var = this.e;
        return (i93Var == 0 || (num = (Integer) i93Var.b(h03Var.g, h03Var.h.floatValue(), h03Var.b, h03Var.c, f, e(), f())) == null) ? l52.c(sp3.b(f, 0.0f, 1.0f), h03Var.b.intValue(), h03Var.c.intValue()) : num.intValue();
    }

    @Override // defpackage.sq
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public Integer i(h03<Integer> h03Var, float f) {
        return Integer.valueOf(q(h03Var, f));
    }
}
