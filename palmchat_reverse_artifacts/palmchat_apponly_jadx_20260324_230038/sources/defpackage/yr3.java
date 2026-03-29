package defpackage;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class yr3 implements dn5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<pr0> f22255a;

    public yr3(List<pr0> list) {
        this.f22255a = Collections.unmodifiableList(list);
    }

    @Override // defpackage.dn5
    public List<pr0> getCues(long j) {
        return j >= 0 ? this.f22255a : Collections.emptyList();
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
