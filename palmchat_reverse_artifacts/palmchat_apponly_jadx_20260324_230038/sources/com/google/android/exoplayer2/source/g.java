package com.google.android.exoplayer2.source;

import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.e0;
import com.google.android.exoplayer2.source.i;
import defpackage.g86;
import defpackage.s6;
import defpackage.vh;
import defpackage.w9;
import defpackage.z12;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class g extends t {
    public final boolean m;
    public final e0.d n;
    public final e0.b o;
    public a p;

    @Nullable
    public f q;
    public boolean r;
    public boolean s;
    public boolean t;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends z12 {
        public static final Object i = new Object();

        @Nullable
        public final Object g;

        @Nullable
        public final Object h;

        public a(e0 e0Var, @Nullable Object obj, @Nullable Object obj2) {
            super(e0Var);
            this.g = obj;
            this.h = obj2;
        }

        public static a y(com.google.android.exoplayer2.p pVar) {
            return new a(new b(pVar), e0.d.r, i);
        }

        public static a z(e0 e0Var, @Nullable Object obj, @Nullable Object obj2) {
            return new a(e0Var, obj, obj2);
        }

        @Override // defpackage.z12, com.google.android.exoplayer2.e0
        public int f(Object obj) {
            Object obj2;
            e0 e0Var = this.f;
            if (i.equals(obj) && (obj2 = this.h) != null) {
                obj = obj2;
            }
            return e0Var.f(obj);
        }

        @Override // defpackage.z12, com.google.android.exoplayer2.e0
        public e0.b k(int i2, e0.b bVar, boolean z) {
            this.f.k(i2, bVar, z);
            if (g86.c(bVar.b, this.h) && z) {
                bVar.b = i;
            }
            return bVar;
        }

        @Override // defpackage.z12, com.google.android.exoplayer2.e0
        public Object q(int i2) {
            Object objQ = this.f.q(i2);
            return g86.c(objQ, this.h) ? i : objQ;
        }

        @Override // defpackage.z12, com.google.android.exoplayer2.e0
        public e0.d s(int i2, e0.d dVar, long j) {
            this.f.s(i2, dVar, j);
            if (g86.c(dVar.f5871a, this.g)) {
                dVar.f5871a = e0.d.r;
            }
            return dVar;
        }

        public a x(e0 e0Var) {
            return new a(e0Var, this.g, this.h);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @VisibleForTesting
    public static final class b extends e0 {
        public final com.google.android.exoplayer2.p f;

        public b(com.google.android.exoplayer2.p pVar) {
            this.f = pVar;
        }

        @Override // com.google.android.exoplayer2.e0
        public int f(Object obj) {
            return obj == a.i ? 0 : -1;
        }

        @Override // com.google.android.exoplayer2.e0
        public e0.b k(int i, e0.b bVar, boolean z) {
            bVar.w(z ? 0 : null, z ? a.i : null, 0, -9223372036854775807L, 0L, s6.g, true);
            return bVar;
        }

        @Override // com.google.android.exoplayer2.e0
        public int m() {
            return 1;
        }

        @Override // com.google.android.exoplayer2.e0
        public Object q(int i) {
            return a.i;
        }

        @Override // com.google.android.exoplayer2.e0
        public e0.d s(int i, e0.d dVar, long j) {
            dVar.i(e0.d.r, this.f, null, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, false, true, null, 0L, -9223372036854775807L, 0, 0, 0L);
            dVar.l = true;
            return dVar;
        }

        @Override // com.google.android.exoplayer2.e0
        public int t() {
            return 1;
        }
    }

    public g(i iVar, boolean z) {
        super(iVar);
        this.m = z && iVar.isSingleWindow();
        this.n = new e0.d();
        this.o = new e0.b();
        e0 initialTimeline = iVar.getInitialTimeline();
        if (initialTimeline == null) {
            this.p = a.y(iVar.getMediaItem());
        } else {
            this.p = a.z(initialTimeline, null, null);
            this.t = true;
        }
    }

    @Override // com.google.android.exoplayer2.source.t
    @Nullable
    public i.b D(i.b bVar) {
        return bVar.c(O(bVar.f18710a));
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    @Override // com.google.android.exoplayer2.source.t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void J(e0 e0Var) {
        i.b bVarC;
        if (this.s) {
            this.p = this.p.x(e0Var);
            f fVar = this.q;
            if (fVar != null) {
                R(fVar.h());
            }
        } else {
            if (!e0Var.u()) {
                e0Var.r(0, this.n);
                long jE = this.n.e();
                Object obj = this.n.f5871a;
                f fVar2 = this.q;
                if (fVar2 != null) {
                    long jI = fVar2.i();
                    this.p.l(this.q.f5956a.f18710a, this.o);
                    long jQ = this.o.q() + jI;
                    long j = jQ != this.p.r(0, this.n).e() ? jQ : jE;
                    Pair<Object, Long> pairN = e0Var.n(this.n, this.o, 0, j);
                    Object obj2 = pairN.first;
                    long jLongValue = ((Long) pairN.second).longValue();
                    this.p = this.t ? this.p.x(e0Var) : a.z(e0Var, obj, obj2);
                    f fVar3 = this.q;
                    if (fVar3 != null) {
                        R(jLongValue);
                        i.b bVar = fVar3.f5956a;
                        bVarC = bVar.c(P(bVar.f18710a));
                    }
                }
                this.t = true;
                this.s = true;
                u(this.p);
                if (bVarC == null) {
                    ((f) vh.e(this.q)).d(bVarC);
                    return;
                }
                return;
            }
            this.p = this.t ? this.p.x(e0Var) : a.z(e0Var, e0.d.r, a.i);
        }
        bVarC = null;
        this.t = true;
        this.s = true;
        u(this.p);
        if (bVarC == null) {
        }
    }

    @Override // com.google.android.exoplayer2.source.t
    public void M() {
        if (this.m) {
            return;
        }
        this.r = true;
        L();
    }

    @Override // com.google.android.exoplayer2.source.i
    /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
    public f c(i.b bVar, w9 w9Var, long j) {
        f fVar = new f(bVar, w9Var, j);
        fVar.n(this.k);
        if (this.s) {
            fVar.d(bVar.c(P(bVar.f18710a)));
        } else {
            this.q = fVar;
            if (!this.r) {
                this.r = true;
                L();
            }
        }
        return fVar;
    }

    public final Object O(Object obj) {
        return (this.p.h == null || !this.p.h.equals(obj)) ? obj : a.i;
    }

    public final Object P(Object obj) {
        return (this.p.h == null || !obj.equals(a.i)) ? obj : this.p.h;
    }

    public e0 Q() {
        return this.p;
    }

    public final void R(long j) {
        f fVar = this.q;
        int iF = this.p.f(fVar.f5956a.f18710a);
        if (iF == -1) {
            return;
        }
        long j2 = this.p.j(iF, this.o).d;
        if (j2 != -9223372036854775807L && j >= j2) {
            j = Math.max(0L, j2 - 1);
        }
        fVar.l(j);
    }

    @Override // com.google.android.exoplayer2.source.i
    public void f(h hVar) {
        ((f) hVar).m();
        if (hVar == this.q) {
            this.q = null;
        }
    }

    @Override // com.google.android.exoplayer2.source.c, com.google.android.exoplayer2.source.a
    public void v() {
        this.s = false;
        this.r = false;
        super.v();
    }

    @Override // com.google.android.exoplayer2.source.c, com.google.android.exoplayer2.source.i
    public void maybeThrowSourceInfoRefreshError() {
    }
}
