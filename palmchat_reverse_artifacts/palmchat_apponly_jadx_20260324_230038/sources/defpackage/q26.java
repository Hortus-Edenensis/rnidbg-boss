package defpackage;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class q26 implements dn5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m26 f20162a;
    public final long[] b;
    public final Map<String, p26> c;
    public final Map<String, n26> d;
    public final Map<String, String> e;

    public q26(m26 m26Var, Map<String, p26> map, Map<String, n26> map2, Map<String, String> map3) {
        this.f20162a = m26Var;
        this.d = map2;
        this.e = map3;
        this.c = map != null ? Collections.unmodifiableMap(map) : Collections.emptyMap();
        this.b = m26Var.j();
    }

    @Override // defpackage.dn5
    public List<pr0> getCues(long j) {
        return this.f20162a.h(j, this.c, this.d, this.e);
    }

    @Override // defpackage.dn5
    public long getEventTime(int i) {
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
