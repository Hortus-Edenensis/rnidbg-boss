package defpackage;

import android.util.SparseArray;
import androidx.media3.common.util.TimestampAdjuster;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class ky5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray<jy5> f18856a = new SparseArray<>();

    public jy5 a(int i) {
        jy5 jy5Var = this.f18856a.get(i);
        if (jy5Var != null) {
            return jy5Var;
        }
        jy5 jy5Var2 = new jy5(TimestampAdjuster.MODE_SHARED);
        this.f18856a.put(i, jy5Var2);
        return jy5Var2;
    }

    public void b() {
        this.f18856a.clear();
    }
}
