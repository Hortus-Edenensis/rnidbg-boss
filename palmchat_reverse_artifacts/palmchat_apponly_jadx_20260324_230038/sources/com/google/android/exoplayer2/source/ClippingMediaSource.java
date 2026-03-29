package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.e0;
import com.google.android.exoplayer2.source.i;
import defpackage.g86;
import defpackage.vh;
import defpackage.w9;
import defpackage.z12;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class ClippingMediaSource extends t {
    public final long m;
    public final long n;
    public final boolean o;
    public final boolean p;
    public final boolean q;
    public final ArrayList<b> r;
    public final e0.d s;

    @Nullable
    public a t;

    @Nullable
    public IllegalClippingException u;
    public long v;
    public long w;

    /* JADX INFO: compiled from: SearchBox */
    public static final class IllegalClippingException extends IOException {
        public static final int REASON_INVALID_PERIOD_COUNT = 0;
        public static final int REASON_NOT_SEEKABLE_TO_START = 1;
        public static final int REASON_START_EXCEEDS_END = 2;
        public final int reason;

        public IllegalClippingException(int i) {
            super("Illegal clipping: " + getReasonDescription(i));
            this.reason = i;
        }

        private static String getReasonDescription(int i) {
            return i != 0 ? i != 1 ? i != 2 ? "unknown" : "start exceeds end" : "not seekable to start" : "invalid period count";
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends z12 {
        public final long g;
        public final long h;
        public final long i;
        public final boolean j;

        public a(e0 e0Var, long j, long j2) throws IllegalClippingException {
            super(e0Var);
            boolean z = false;
            if (e0Var.m() != 1) {
                throw new IllegalClippingException(0);
            }
            e0.d dVarR = e0Var.r(0, new e0.d());
            long jMax = Math.max(0L, j);
            if (!dVarR.l && jMax != 0 && !dVarR.h) {
                throw new IllegalClippingException(1);
            }
            long jMax2 = j2 == Long.MIN_VALUE ? dVarR.n : Math.max(0L, j2);
            long j3 = dVarR.n;
            if (j3 != -9223372036854775807L) {
                jMax2 = jMax2 > j3 ? j3 : jMax2;
                if (jMax > jMax2) {
                    throw new IllegalClippingException(2);
                }
            }
            this.g = jMax;
            this.h = jMax2;
            this.i = jMax2 == -9223372036854775807L ? -9223372036854775807L : jMax2 - jMax;
            if (dVarR.i && (jMax2 == -9223372036854775807L || (j3 != -9223372036854775807L && jMax2 == j3))) {
                z = true;
            }
            this.j = z;
        }

        @Override // defpackage.z12, com.google.android.exoplayer2.e0
        public e0.b k(int i, e0.b bVar, boolean z) {
            this.f.k(0, bVar, z);
            long jQ = bVar.q() - this.g;
            long j = this.i;
            return bVar.v(bVar.f5870a, bVar.b, 0, j == -9223372036854775807L ? -9223372036854775807L : j - jQ, jQ);
        }

        @Override // defpackage.z12, com.google.android.exoplayer2.e0
        public e0.d s(int i, e0.d dVar, long j) {
            this.f.s(0, dVar, 0L);
            long j2 = dVar.q;
            long j3 = this.g;
            dVar.q = j2 + j3;
            dVar.n = this.i;
            dVar.i = this.j;
            long j4 = dVar.m;
            if (j4 != -9223372036854775807L) {
                long jMax = Math.max(j4, j3);
                dVar.m = jMax;
                long j5 = this.h;
                if (j5 != -9223372036854775807L) {
                    jMax = Math.min(jMax, j5);
                }
                dVar.m = jMax - this.g;
            }
            long jM1 = g86.m1(this.g);
            long j6 = dVar.e;
            if (j6 != -9223372036854775807L) {
                dVar.e = j6 + jM1;
            }
            long j7 = dVar.f;
            if (j7 != -9223372036854775807L) {
                dVar.f = j7 + jM1;
            }
            return dVar;
        }
    }

    public ClippingMediaSource(i iVar, long j, long j2, boolean z, boolean z2, boolean z3) {
        super((i) vh.e(iVar));
        vh.a(j >= 0);
        this.m = j;
        this.n = j2;
        this.o = z;
        this.p = z2;
        this.q = z3;
        this.r = new ArrayList<>();
        this.s = new e0.d();
    }

    @Override // com.google.android.exoplayer2.source.t
    public void J(e0 e0Var) {
        if (this.u != null) {
            return;
        }
        N(e0Var);
    }

    public final void N(e0 e0Var) {
        long j;
        long j2;
        e0Var.r(0, this.s);
        long jG = this.s.g();
        if (this.t == null || this.r.isEmpty() || this.p) {
            long j3 = this.m;
            long j4 = this.n;
            if (this.q) {
                long jE = this.s.e();
                j3 += jE;
                j4 += jE;
            }
            this.v = jG + j3;
            this.w = this.n != Long.MIN_VALUE ? jG + j4 : Long.MIN_VALUE;
            int size = this.r.size();
            for (int i = 0; i < size; i++) {
                this.r.get(i).l(this.v, this.w);
            }
            j = j3;
            j2 = j4;
        } else {
            long j5 = this.v - jG;
            j2 = this.n != Long.MIN_VALUE ? this.w - jG : Long.MIN_VALUE;
            j = j5;
        }
        try {
            a aVar = new a(e0Var, j, j2);
            this.t = aVar;
            u(aVar);
        } catch (IllegalClippingException e) {
            this.u = e;
            for (int i2 = 0; i2 < this.r.size(); i2++) {
                this.r.get(i2).j(this.u);
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.i
    public h c(i.b bVar, w9 w9Var, long j) {
        b bVar2 = new b(this.k.c(bVar, w9Var, j), this.o, this.v, this.w);
        this.r.add(bVar2);
        return bVar2;
    }

    @Override // com.google.android.exoplayer2.source.i
    public void f(h hVar) {
        vh.g(this.r.remove(hVar));
        this.k.f(((b) hVar).f5933a);
        if (!this.r.isEmpty() || this.p) {
            return;
        }
        N(((a) vh.e(this.t)).f);
    }

    @Override // com.google.android.exoplayer2.source.c, com.google.android.exoplayer2.source.i
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        IllegalClippingException illegalClippingException = this.u;
        if (illegalClippingException != null) {
            throw illegalClippingException;
        }
        super.maybeThrowSourceInfoRefreshError();
    }

    @Override // com.google.android.exoplayer2.source.c, com.google.android.exoplayer2.source.a
    public void v() {
        super.v();
        this.u = null;
        this.t = null;
    }
}
