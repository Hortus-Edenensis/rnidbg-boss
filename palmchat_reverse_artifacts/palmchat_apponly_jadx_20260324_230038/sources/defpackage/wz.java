package defpackage;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class wz implements dn5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<pr0> f21834a;

    public wz(List<pr0> list) {
        this.f21834a = list;
    }

    @Override // defpackage.dn5
    public List<pr0> getCues(long j) {
        return j >= 0 ? this.f21834a : Collections.emptyList();
    }

    @Override // defpackage.dn5
    public long getEventTime(int i) {
        vh.a(i == 0);
        return 0L;
    }

    @Override // defpackage.dn5
    public int getEventTimeCount() {
        return 1;
    }

    @Override // defpackage.dn5
    public int getNextEventTimeIndex(long j) {
        return j < 0 ? 0 : -1;
    }
}
