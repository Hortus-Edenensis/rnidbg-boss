package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class jk6 implements dn5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<ck6> f18428a;
    public final long[] b;
    public final long[] c;

    public jk6(List<ck6> list) {
        this.f18428a = Collections.unmodifiableList(new ArrayList(list));
        this.b = new long[list.size() * 2];
        for (int i = 0; i < list.size(); i++) {
            ck6 ck6Var = list.get(i);
            int i2 = i * 2;
            long[] jArr = this.b;
            jArr[i2] = ck6Var.b;
            jArr[i2 + 1] = ck6Var.c;
        }
        long[] jArr2 = this.b;
        long[] jArrCopyOf = Arrays.copyOf(jArr2, jArr2.length);
        this.c = jArrCopyOf;
        Arrays.sort(jArrCopyOf);
    }

    public static /* synthetic */ int b(ck6 ck6Var, ck6 ck6Var2) {
        return Long.compare(ck6Var.b, ck6Var2.b);
    }

    @Override // defpackage.dn5
    public List<pr0> getCues(long j) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < this.f18428a.size(); i++) {
            long[] jArr = this.b;
            int i2 = i * 2;
            if (jArr[i2] <= j && j < jArr[i2 + 1]) {
                ck6 ck6Var = this.f18428a.get(i);
                pr0 pr0Var = ck6Var.f2003a;
                if (pr0Var.e == -3.4028235E38f) {
                    arrayList2.add(ck6Var);
                } else {
                    arrayList.add(pr0Var);
                }
            }
        }
        Collections.sort(arrayList2, new Comparator() { // from class: ik6
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return jk6.b((ck6) obj, (ck6) obj2);
            }
        });
        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
            arrayList.add(((ck6) arrayList2.get(i3)).f2003a.b().h((-1) - i3, 1).a());
        }
        return arrayList;
    }

    @Override // defpackage.dn5
    public long getEventTime(int i) {
        vh.a(i >= 0);
        vh.a(i < this.c.length);
        return this.c[i];
    }

    @Override // defpackage.dn5
    public int getEventTimeCount() {
        return this.c.length;
    }

    @Override // defpackage.dn5
    public int getNextEventTimeIndex(long j) {
        int iE = g86.e(this.c, j, false, false);
        if (iE < this.c.length) {
            return iE;
        }
        return -1;
    }
}
