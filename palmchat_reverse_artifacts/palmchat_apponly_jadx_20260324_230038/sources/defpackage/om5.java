package defpackage;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class om5 implements dn5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final pr0[] f19796a;
    public final long[] b;

    public om5(pr0[] pr0VarArr, long[] jArr) {
        this.f19796a = pr0VarArr;
        this.b = jArr;
    }

    @Override // defpackage.dn5
    public List<pr0> getCues(long j) {
        pr0 pr0Var;
        int i = g86.i(this.b, j, true, false);
        return (i == -1 || (pr0Var = this.f19796a[i]) == pr0.r) ? Collections.emptyList() : Collections.singletonList(pr0Var);
    }

    @Override // defpackage.dn5
    public long getEventTime(int i) {
        vh.a(i >= 0);
        vh.a(i < this.b.length);
        return this.b[i];
    }

    @Override // defpackage.dn5
    public int getEventTimeCount() {
        return this.b.length;
    }

    @Override // defpackage.dn5
    public int getNextEventTimeIndex(long j) {
        int iE = g86.e(this.b, j, false, false);
        if (iE < this.b.length) {
            return iE;
        }
        return -1;
    }
}
