package defpackage;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.e0;
import com.google.android.exoplayer2.p;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class xd5 extends e0 {
    public static final Object s = new Object();
    public static final p t = new p.c().d("SinglePeriodTimeline").i(Uri.EMPTY).a();
    public final long f;
    public final long g;
    public final long h;
    public final long i;
    public final long j;
    public final long k;
    public final long l;
    public final boolean m;
    public final boolean n;
    public final boolean o;

    @Nullable
    public final Object p;

    @Nullable
    public final p q;

    @Nullable
    public final p.g r;

    public xd5(long j, boolean z, boolean z2, boolean z3, @Nullable Object obj, p pVar) {
        this(j, j, 0L, 0L, z, z2, z3, obj, pVar);
    }

    @Override // com.google.android.exoplayer2.e0
    public int f(Object obj) {
        return s.equals(obj) ? 0 : -1;
    }

    @Override // com.google.android.exoplayer2.e0
    public e0.b k(int i, e0.b bVar, boolean z) {
        vh.c(i, 0, 1);
        return bVar.v(null, z ? s : null, 0, this.i, -this.k);
    }

    @Override // com.google.android.exoplayer2.e0
    public int m() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.e0
    public Object q(int i) {
        vh.c(i, 0, 1);
        return s;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002e A[PHI: r1
      0x002e: PHI (r1v2 long) = (r1v1 long), (r1v1 long), (r1v1 long), (r1v6 long) binds: [B:3:0x000d, B:5:0x0011, B:7:0x0017, B:12:0x002b] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.exoplayer2.e0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public e0.d s(int i, e0.d dVar, long j) {
        long j2;
        vh.c(i, 0, 1);
        long j3 = this.l;
        boolean z = this.n;
        if (!z || this.o || j == 0) {
            j2 = j3;
        } else {
            long j4 = this.j;
            if (j4 != -9223372036854775807L) {
                j3 += j;
                if (j3 > j4) {
                }
            }
            j2 = -9223372036854775807L;
        }
        return dVar.i(e0.d.r, this.q, this.p, this.f, this.g, this.h, this.m, z, this.r, j2, this.j, 0, 0, this.k);
    }

    @Override // com.google.android.exoplayer2.e0
    public int t() {
        return 1;
    }

    public xd5(long j, long j2, long j3, long j4, boolean z, boolean z2, boolean z3, @Nullable Object obj, p pVar) {
        this(-9223372036854775807L, -9223372036854775807L, -9223372036854775807L, j, j2, j3, j4, z, z2, false, obj, pVar, z3 ? pVar.d : null);
    }

    public xd5(long j, long j2, long j3, long j4, long j5, long j6, long j7, boolean z, boolean z2, boolean z3, @Nullable Object obj, p pVar, @Nullable p.g gVar) {
        this.f = j;
        this.g = j2;
        this.h = j3;
        this.i = j4;
        this.j = j5;
        this.k = j6;
        this.l = j7;
        this.m = z;
        this.n = z2;
        this.o = z3;
        this.p = obj;
        this.q = (p) vh.e(pVar);
        this.r = gVar;
    }
}
