package defpackage;

import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class l25 extends i03<m25> {
    public final m25 i;

    public l25(List<h03<m25>> list) {
        super(list);
        this.i = new m25();
    }

    @Override // defpackage.sq
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public m25 i(h03<m25> h03Var, float f) {
        m25 m25Var;
        m25 m25Var2;
        m25 m25Var3 = h03Var.b;
        if (m25Var3 == null || (m25Var = h03Var.c) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        m25 m25Var4 = m25Var3;
        m25 m25Var5 = m25Var;
        i93<A> i93Var = this.e;
        if (i93Var != 0 && (m25Var2 = (m25) i93Var.b(h03Var.g, h03Var.h.floatValue(), m25Var4, m25Var5, f, e(), f())) != null) {
            return m25Var2;
        }
        this.i.d(sp3.i(m25Var4.b(), m25Var5.b(), f), sp3.i(m25Var4.c(), m25Var5.c(), f));
        return this.i;
    }
}
