package defpackage;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.upstream.a;
import com.google.android.exoplayer2.upstream.b;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public abstract class fr extends te3 {
    public final long k;
    public final long l;
    public hr m;
    public int[] n;

    public fr(a aVar, b bVar, m mVar, int i, @Nullable Object obj, long j, long j2, long j3, long j4, long j5) {
        super(aVar, bVar, mVar, i, obj, j, j2, j5);
        this.k = j3;
        this.l = j4;
    }

    public final int g(int i) {
        return ((int[]) vh.i(this.n))[i];
    }

    public final hr h() {
        return (hr) vh.i(this.m);
    }

    public void i(hr hrVar) {
        this.m = hrVar;
        this.n = hrVar.a();
    }
}
