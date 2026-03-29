package defpackage;

import android.os.SystemClock;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.e0;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.u;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class ij4 {
    public static final i.b t = new i.b(new Object());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e0 f18178a;
    public final i.b b;
    public final long c;
    public final long d;
    public final int e;

    @Nullable
    public final ExoPlaybackException f;
    public final boolean g;
    public final vz5 h;
    public final p06 i;
    public final List<Metadata> j;
    public final i.b k;
    public final boolean l;
    public final int m;
    public final u n;
    public final boolean o;
    public volatile long p;
    public volatile long q;
    public volatile long r;
    public volatile long s;

    public ij4(e0 e0Var, i.b bVar, long j, long j2, int i, @Nullable ExoPlaybackException exoPlaybackException, boolean z, vz5 vz5Var, p06 p06Var, List<Metadata> list, i.b bVar2, boolean z2, int i2, u uVar, long j3, long j4, long j5, long j6, boolean z3) {
        this.f18178a = e0Var;
        this.b = bVar;
        this.c = j;
        this.d = j2;
        this.e = i;
        this.f = exoPlaybackException;
        this.g = z;
        this.h = vz5Var;
        this.i = p06Var;
        this.j = list;
        this.k = bVar2;
        this.l = z2;
        this.m = i2;
        this.n = uVar;
        this.p = j3;
        this.q = j4;
        this.r = j5;
        this.s = j6;
        this.o = z3;
    }

    public static ij4 k(p06 p06Var) {
        e0 e0Var = e0.f5869a;
        i.b bVar = t;
        return new ij4(e0Var, bVar, -9223372036854775807L, 0L, 1, null, false, vz5.d, p06Var, ImmutableList.of(), bVar, false, 0, u.d, 0L, 0L, 0L, 0L, false);
    }

    public static i.b l() {
        return t;
    }

    @CheckResult
    public ij4 a() {
        return new ij4(this.f18178a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.p, this.q, m(), SystemClock.elapsedRealtime(), this.o);
    }

    @CheckResult
    public ij4 b(boolean z) {
        return new ij4(this.f18178a, this.b, this.c, this.d, this.e, this.f, z, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.p, this.q, this.r, this.s, this.o);
    }

    @CheckResult
    public ij4 c(i.b bVar) {
        return new ij4(this.f18178a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, bVar, this.l, this.m, this.n, this.p, this.q, this.r, this.s, this.o);
    }

    @CheckResult
    public ij4 d(i.b bVar, long j, long j2, long j3, long j4, vz5 vz5Var, p06 p06Var, List<Metadata> list) {
        return new ij4(this.f18178a, bVar, j2, j3, this.e, this.f, this.g, vz5Var, p06Var, list, this.k, this.l, this.m, this.n, this.p, j4, j, SystemClock.elapsedRealtime(), this.o);
    }

    @CheckResult
    public ij4 e(boolean z, int i) {
        return new ij4(this.f18178a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, z, i, this.n, this.p, this.q, this.r, this.s, this.o);
    }

    @CheckResult
    public ij4 f(@Nullable ExoPlaybackException exoPlaybackException) {
        return new ij4(this.f18178a, this.b, this.c, this.d, this.e, exoPlaybackException, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.p, this.q, this.r, this.s, this.o);
    }

    @CheckResult
    public ij4 g(u uVar) {
        return new ij4(this.f18178a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, uVar, this.p, this.q, this.r, this.s, this.o);
    }

    @CheckResult
    public ij4 h(int i) {
        return new ij4(this.f18178a, this.b, this.c, this.d, i, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.p, this.q, this.r, this.s, this.o);
    }

    @CheckResult
    public ij4 i(boolean z) {
        return new ij4(this.f18178a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.p, this.q, this.r, this.s, z);
    }

    @CheckResult
    public ij4 j(e0 e0Var) {
        return new ij4(e0Var, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.p, this.q, this.r, this.s, this.o);
    }

    public long m() {
        long j;
        long j2;
        if (!n()) {
            return this.r;
        }
        do {
            j = this.s;
            j2 = this.r;
        } while (j != this.s);
        return g86.H0(g86.m1(j2) + ((long) ((SystemClock.elapsedRealtime() - j) * this.n.f5989a)));
    }

    public boolean n() {
        return this.e == 3 && this.l && this.m == 0;
    }

    public void o(long j) {
        this.r = j;
        this.s = SystemClock.elapsedRealtime();
    }
}
