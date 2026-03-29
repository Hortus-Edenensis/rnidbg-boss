package defpackage;

import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class ti1 implements dn5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<pr0> f20998a;

    public ti1(List<pr0> list) {
        this.f20998a = list;
    }

    @Override // defpackage.dn5
    public List<pr0> getCues(long j) {
        return this.f20998a;
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
