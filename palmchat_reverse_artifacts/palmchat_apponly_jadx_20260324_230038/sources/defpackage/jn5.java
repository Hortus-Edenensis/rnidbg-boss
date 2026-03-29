package defpackage;

import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public abstract class jn5 extends mw0 implements dn5 {

    @Nullable
    public dn5 d;
    public long e;

    @Override // defpackage.yu
    public void b() {
        super.b();
        this.d = null;
    }

    @Override // defpackage.dn5
    public List<pr0> getCues(long j) {
        return ((dn5) vh.e(this.d)).getCues(j - this.e);
    }

    @Override // defpackage.dn5
    public long getEventTime(int i) {
        return ((dn5) vh.e(this.d)).getEventTime(i) + this.e;
    }

    @Override // defpackage.dn5
    public int getEventTimeCount() {
        return ((dn5) vh.e(this.d)).getEventTimeCount();
    }

    @Override // defpackage.dn5
    public int getNextEventTimeIndex(long j) {
        return ((dn5) vh.e(this.d)).getNextEventTimeIndex(j - this.e);
    }

    public void m(long j, dn5 dn5Var, long j2) {
        this.b = j;
        this.d = dn5Var;
        if (j2 != Long.MAX_VALUE) {
            j = j2;
        }
        this.e = j;
    }
}
