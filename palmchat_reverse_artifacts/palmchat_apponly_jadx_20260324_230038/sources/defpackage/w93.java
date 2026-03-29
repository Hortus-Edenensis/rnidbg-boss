package defpackage;

import android.util.Pair;
import android.util.SparseArray;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class w93 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f21642a = 0;
    public SparseArray<Pair<ib3, Integer>> b = new SparseArray<>();

    public synchronized Pair<ib3, Integer> a(int i) {
        Pair<ib3, Integer> pair;
        pair = this.b.get(i);
        this.b.remove(i);
        return pair;
    }

    public synchronized int b(ib3 ib3Var, int i) {
        int i2;
        i2 = this.f21642a;
        this.f21642a = i2 + 1;
        this.b.put(i2, new Pair<>(ib3Var, Integer.valueOf(i)));
        return i2;
    }
}
