package defpackage;

import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class uh4 implements dn5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<pr0> f21213a;

    public uh4(List<pr0> list) {
        this.f21213a = list;
    }

    @Override // defpackage.dn5
    public List<pr0> getCues(long j) {
        return this.f21213a;
    }

    @Override // defpackage.dn5
    public long getEventTime(int i) {
        return 0L;
    }

    @Override // defpackage.dn5
    public int getEventTimeCount() {
        return 1;
    }

    @Override // defpackage.dn5
    public int getNextEventTimeIndex(long j) {
        return -1;
    }
}
