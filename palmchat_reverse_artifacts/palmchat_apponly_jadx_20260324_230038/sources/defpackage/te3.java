package defpackage;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.upstream.a;
import com.google.android.exoplayer2.upstream.b;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public abstract class te3 extends x50 {
    public final long j;

    public te3(a aVar, b bVar, m mVar, int i, @Nullable Object obj, long j, long j2, long j3) {
        super(aVar, bVar, 1, mVar, i, obj, j, j2);
        vh.e(mVar);
        this.j = j3;
    }

    public long e() {
        long j = this.j;
        if (j != -1) {
            return 1 + j;
        }
        return -1L;
    }

    public abstract boolean f();
}
