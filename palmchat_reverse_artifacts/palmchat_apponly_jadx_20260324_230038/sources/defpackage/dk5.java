package defpackage;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class dk5 implements dn5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<List<pr0>> f17061a;
    public final List<Long> b;

    public dk5(List<List<pr0>> list, List<Long> list2) {
        this.f17061a = list;
        this.b = list2;
    }

    @Override // defpackage.dn5
    public List<pr0> getCues(long j) {
        int iG = g86.g(this.b, Long.valueOf(j), true, false);
        return iG == -1 ? Collections.emptyList() : this.f17061a.get(iG);
    }

    @Override // defpackage.dn5
    public long getEventTime(int i) {
        vh.a(i >= 0);
        vh.a(i < this.b.size());
        return this.b.get(i).longValue();
    }

    @Override // defpackage.dn5
    public int getEventTimeCount() {
        return this.b.size();
    }

    @Override // defpackage.dn5
    public int getNextEventTimeIndex(long j) {
        int iD = g86.d(this.b, Long.valueOf(j), false, false);
        if (iD < this.b.size()) {
            return iD;
        }
        return -1;
    }
}
