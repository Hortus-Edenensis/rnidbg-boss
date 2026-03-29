package defpackage;

import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class fd2 extends i03<ed2> {
    public final ed2 i;

    public fd2(List<h03<ed2>> list) {
        super(list);
        ed2 ed2Var = list.get(0).b;
        int iC = ed2Var != null ? ed2Var.c() : 0;
        this.i = new ed2(new float[iC], new int[iC]);
    }

    @Override // defpackage.sq
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public ed2 i(h03<ed2> h03Var, float f) {
        this.i.d(h03Var.b, h03Var.c, f);
        return this.i;
    }
}
