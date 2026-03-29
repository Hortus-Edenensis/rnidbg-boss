package defpackage;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class s26 implements dn5 {
    public static final s26 b = new s26();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<pr0> f20655a;

    public s26(pr0 pr0Var) {
        this.f20655a = Collections.singletonList(pr0Var);
    }

    @Override // defpackage.dn5
    public List<pr0> getCues(long j) {
        return j >= 0 ? this.f20655a : Collections.emptyList();
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

    public s26() {
        this.f20655a = Collections.emptyList();
    }
}
