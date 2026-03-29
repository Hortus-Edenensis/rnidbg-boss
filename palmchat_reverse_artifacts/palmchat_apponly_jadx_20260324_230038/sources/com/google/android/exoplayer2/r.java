package com.google.android.exoplayer2;

import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.media3.exoplayer.MediaPeriodQueue;
import com.google.android.exoplayer2.e0;
import com.google.android.exoplayer2.source.i;
import com.google.common.collect.ImmutableList;
import defpackage.ij4;
import defpackage.jk3;
import defpackage.kc;
import defpackage.lk3;
import defpackage.mg2;
import defpackage.o06;
import defpackage.p06;
import defpackage.vh;
import defpackage.w9;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e0.b f5927a = new e0.b();
    public final e0.d b = new e0.d();
    public final kc c;
    public final mg2 d;
    public long e;
    public int f;
    public boolean g;

    @Nullable
    public jk3 h;

    @Nullable
    public jk3 i;

    @Nullable
    public jk3 j;
    public int k;

    @Nullable
    public Object l;
    public long m;

    public r(kc kcVar, mg2 mg2Var) {
        this.c = kcVar;
        this.d = mg2Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A(ImmutableList.a aVar, i.b bVar) {
        this.c.F(aVar.e(), bVar);
    }

    public static i.b E(e0 e0Var, Object obj, long j, long j2, e0.d dVar, e0.b bVar) {
        e0Var.l(obj, bVar);
        e0Var.r(bVar.c, dVar);
        Object objE = obj;
        for (int iF = e0Var.f(obj); z(bVar) && iF <= dVar.p; iF++) {
            e0Var.k(iF, bVar, true);
            objE = vh.e(bVar.b);
        }
        e0Var.l(objE, bVar);
        int iH = bVar.h(j);
        return iH == -1 ? new i.b(objE, j2, bVar.g(j)) : new i.b(objE, iH, bVar.n(iH), j2);
    }

    public static boolean z(e0.b bVar) {
        int iF = bVar.f();
        if (iF == 0) {
            return false;
        }
        if ((iF == 1 && bVar.t(0)) || !bVar.u(bVar.r())) {
            return false;
        }
        long jL = 0;
        if (bVar.h(0L) != -1) {
            return false;
        }
        if (bVar.d == 0) {
            return true;
        }
        int i = iF - (bVar.t(iF + (-1)) ? 2 : 1);
        for (int i2 = 0; i2 <= i; i2++) {
            jL += bVar.l(i2);
        }
        return bVar.d <= jL;
    }

    public final void B() {
        final ImmutableList.a aVarBuilder = ImmutableList.builder();
        for (jk3 jk3VarJ = this.h; jk3VarJ != null; jk3VarJ = jk3VarJ.j()) {
            aVarBuilder.a(jk3VarJ.f.f19020a);
        }
        jk3 jk3Var = this.i;
        final i.b bVar = jk3Var == null ? null : jk3Var.f.f19020a;
        this.d.post(new Runnable() { // from class: mk3
            @Override // java.lang.Runnable
            public final void run() {
                this.f19258a.A(aVarBuilder, bVar);
            }
        });
    }

    public void C(long j) {
        jk3 jk3Var = this.j;
        if (jk3Var != null) {
            jk3Var.s(j);
        }
    }

    public boolean D(jk3 jk3Var) {
        boolean z = false;
        vh.g(jk3Var != null);
        if (jk3Var.equals(this.j)) {
            return false;
        }
        this.j = jk3Var;
        while (jk3Var.j() != null) {
            jk3Var = jk3Var.j();
            if (jk3Var == this.i) {
                this.i = this.h;
                z = true;
            }
            jk3Var.t();
            this.k--;
        }
        this.j.w(null);
        B();
        return z;
    }

    public i.b F(e0 e0Var, Object obj, long j) {
        long jG = G(e0Var, obj);
        e0Var.l(obj, this.f5927a);
        e0Var.r(this.f5927a.c, this.b);
        boolean z = false;
        for (int iF = e0Var.f(obj); iF >= this.b.o; iF--) {
            e0Var.k(iF, this.f5927a, true);
            boolean z2 = this.f5927a.f() > 0;
            z |= z2;
            e0.b bVar = this.f5927a;
            if (bVar.h(bVar.d) != -1) {
                obj = vh.e(this.f5927a.b);
            }
            if (z && (!z2 || this.f5927a.d != 0)) {
                break;
            }
        }
        return E(e0Var, obj, j, jG, this.b, this.f5927a);
    }

    public final long G(e0 e0Var, Object obj) {
        int iF;
        int i = e0Var.l(obj, this.f5927a).c;
        Object obj2 = this.l;
        if (obj2 != null && (iF = e0Var.f(obj2)) != -1 && e0Var.j(iF, this.f5927a).c == i) {
            return this.m;
        }
        for (jk3 jk3VarJ = this.h; jk3VarJ != null; jk3VarJ = jk3VarJ.j()) {
            if (jk3VarJ.b.equals(obj)) {
                return jk3VarJ.f.f19020a.d;
            }
        }
        for (jk3 jk3VarJ2 = this.h; jk3VarJ2 != null; jk3VarJ2 = jk3VarJ2.j()) {
            int iF2 = e0Var.f(jk3VarJ2.b);
            if (iF2 != -1 && e0Var.j(iF2, this.f5927a).c == i) {
                return jk3VarJ2.f.f19020a.d;
            }
        }
        long j = this.e;
        this.e = 1 + j;
        if (this.h == null) {
            this.l = obj;
            this.m = j;
        }
        return j;
    }

    public boolean H() {
        jk3 jk3Var = this.j;
        return jk3Var == null || (!jk3Var.f.i && jk3Var.q() && this.j.f.e != -9223372036854775807L && this.k < 100);
    }

    public final boolean I(e0 e0Var) {
        jk3 jk3VarJ = this.h;
        if (jk3VarJ == null) {
            return true;
        }
        int iF = e0Var.f(jk3VarJ.b);
        while (true) {
            iF = e0Var.h(iF, this.f5927a, this.b, this.f, this.g);
            while (jk3VarJ.j() != null && !jk3VarJ.f.g) {
                jk3VarJ = jk3VarJ.j();
            }
            jk3 jk3VarJ2 = jk3VarJ.j();
            if (iF == -1 || jk3VarJ2 == null || e0Var.f(jk3VarJ2.b) != iF) {
                break;
            }
            jk3VarJ = jk3VarJ2;
        }
        boolean zD = D(jk3VarJ);
        jk3VarJ.f = t(e0Var, jk3VarJ.f);
        return !zD;
    }

    public boolean J(e0 e0Var, long j, long j2) {
        lk3 lk3VarT;
        jk3 jk3VarJ = this.h;
        jk3 jk3Var = null;
        while (jk3VarJ != null) {
            lk3 lk3Var = jk3VarJ.f;
            if (jk3Var == null) {
                lk3VarT = t(e0Var, lk3Var);
            } else {
                lk3 lk3VarJ = j(e0Var, jk3Var, j);
                if (lk3VarJ == null) {
                    return !D(jk3Var);
                }
                if (!e(lk3Var, lk3VarJ)) {
                    return !D(jk3Var);
                }
                lk3VarT = lk3VarJ;
            }
            jk3VarJ.f = lk3VarT.a(lk3Var.c);
            if (!d(lk3Var.e, lk3VarT.e)) {
                jk3VarJ.A();
                long j3 = lk3VarT.e;
                return (D(jk3VarJ) || (jk3VarJ == this.i && !jk3VarJ.f.f && ((j2 > Long.MIN_VALUE ? 1 : (j2 == Long.MIN_VALUE ? 0 : -1)) == 0 || (j2 > ((j3 > (-9223372036854775807L) ? 1 : (j3 == (-9223372036854775807L) ? 0 : -1)) == 0 ? Long.MAX_VALUE : jk3VarJ.z(j3)) ? 1 : (j2 == ((j3 > (-9223372036854775807L) ? 1 : (j3 == (-9223372036854775807L) ? 0 : -1)) == 0 ? Long.MAX_VALUE : jk3VarJ.z(j3)) ? 0 : -1)) >= 0))) ? false : true;
            }
            jk3Var = jk3VarJ;
            jk3VarJ = jk3VarJ.j();
        }
        return true;
    }

    public boolean K(e0 e0Var, int i) {
        this.f = i;
        return I(e0Var);
    }

    public boolean L(e0 e0Var, boolean z) {
        this.g = z;
        return I(e0Var);
    }

    @Nullable
    public jk3 b() {
        jk3 jk3Var = this.h;
        if (jk3Var == null) {
            return null;
        }
        if (jk3Var == this.i) {
            this.i = jk3Var.j();
        }
        this.h.t();
        int i = this.k - 1;
        this.k = i;
        if (i == 0) {
            this.j = null;
            jk3 jk3Var2 = this.h;
            this.l = jk3Var2.b;
            this.m = jk3Var2.f.f19020a.d;
        }
        this.h = this.h.j();
        B();
        return this.h;
    }

    public jk3 c() {
        jk3 jk3Var = this.i;
        vh.g((jk3Var == null || jk3Var.j() == null) ? false : true);
        this.i = this.i.j();
        B();
        return this.i;
    }

    public final boolean d(long j, long j2) {
        return j == -9223372036854775807L || j == j2;
    }

    public final boolean e(lk3 lk3Var, lk3 lk3Var2) {
        return lk3Var.b == lk3Var2.b && lk3Var.f19020a.equals(lk3Var2.f19020a);
    }

    public void f() {
        if (this.k == 0) {
            return;
        }
        jk3 jk3VarJ = (jk3) vh.i(this.h);
        this.l = jk3VarJ.b;
        this.m = jk3VarJ.f.f19020a.d;
        while (jk3VarJ != null) {
            jk3VarJ.t();
            jk3VarJ = jk3VarJ.j();
        }
        this.h = null;
        this.j = null;
        this.i = null;
        this.k = 0;
        B();
    }

    public jk3 g(a0[] a0VarArr, o06 o06Var, w9 w9Var, s sVar, lk3 lk3Var, p06 p06Var) {
        jk3 jk3Var = this.j;
        jk3 jk3Var2 = new jk3(a0VarArr, jk3Var == null ? MediaPeriodQueue.INITIAL_RENDERER_POSITION_OFFSET_US : (jk3Var.l() + this.j.f.e) - lk3Var.b, o06Var, w9Var, sVar, lk3Var, p06Var);
        jk3 jk3Var3 = this.j;
        if (jk3Var3 != null) {
            jk3Var3.w(jk3Var2);
        } else {
            this.h = jk3Var2;
            this.i = jk3Var2;
        }
        this.l = null;
        this.j = jk3Var2;
        this.k++;
        B();
        return jk3Var2;
    }

    @Nullable
    public final lk3 h(ij4 ij4Var) {
        return m(ij4Var.f18178a, ij4Var.b, ij4Var.c, ij4Var.r);
    }

    @Nullable
    public final lk3 i(e0 e0Var, jk3 jk3Var, long j) {
        lk3 lk3Var;
        long j2;
        long j3;
        Object obj;
        long j4;
        long j5;
        long j6;
        lk3 lk3Var2 = jk3Var.f;
        int iH = e0Var.h(e0Var.f(lk3Var2.f19020a.f18710a), this.f5927a, this.b, this.f, this.g);
        if (iH == -1) {
            return null;
        }
        int i = e0Var.k(iH, this.f5927a, true).c;
        Object objE = vh.e(this.f5927a.b);
        long j7 = lk3Var2.f19020a.d;
        if (e0Var.r(i, this.b).o == iH) {
            lk3Var = lk3Var2;
            Pair<Object, Long> pairO = e0Var.o(this.b, this.f5927a, i, -9223372036854775807L, Math.max(0L, j));
            if (pairO == null) {
                return null;
            }
            Object obj2 = pairO.first;
            long jLongValue = ((Long) pairO.second).longValue();
            jk3 jk3VarJ = jk3Var.j();
            if (jk3VarJ == null || !jk3VarJ.b.equals(obj2)) {
                j6 = this.e;
                this.e = 1 + j6;
            } else {
                j6 = jk3VarJ.f.f19020a.d;
            }
            j2 = j6;
            j3 = -9223372036854775807L;
            obj = obj2;
            j4 = jLongValue;
        } else {
            lk3Var = lk3Var2;
            j2 = j7;
            j3 = 0;
            obj = objE;
            j4 = 0;
        }
        i.b bVarE = E(e0Var, obj, j4, j2, this.b, this.f5927a);
        if (j3 == -9223372036854775807L || lk3Var.c == -9223372036854775807L) {
            j5 = j4;
        } else {
            boolean zU = u(lk3Var.f19020a.f18710a, e0Var);
            if (bVarE.b() && zU) {
                j3 = lk3Var.c;
            } else if (zU) {
                j5 = lk3Var.c;
            }
            j5 = j4;
        }
        return m(e0Var, bVarE, j3, j5);
    }

    @Nullable
    public final lk3 j(e0 e0Var, jk3 jk3Var, long j) {
        lk3 lk3Var = jk3Var.f;
        long jL = (jk3Var.l() + lk3Var.e) - j;
        return lk3Var.g ? i(e0Var, jk3Var, jL) : k(e0Var, jk3Var, jL);
    }

    @Nullable
    public final lk3 k(e0 e0Var, jk3 jk3Var, long j) {
        lk3 lk3Var = jk3Var.f;
        i.b bVar = lk3Var.f19020a;
        e0Var.l(bVar.f18710a, this.f5927a);
        if (!bVar.b()) {
            int i = bVar.e;
            if (i != -1 && this.f5927a.t(i)) {
                return i(e0Var, jk3Var, j);
            }
            int iN = this.f5927a.n(bVar.e);
            boolean z = this.f5927a.u(bVar.e) && this.f5927a.k(bVar.e, iN) == 3;
            if (iN == this.f5927a.d(bVar.e) || z) {
                return o(e0Var, bVar.f18710a, p(e0Var, bVar.f18710a, bVar.e), lk3Var.e, bVar.d);
            }
            return n(e0Var, bVar.f18710a, bVar.e, iN, lk3Var.e, bVar.d);
        }
        int i2 = bVar.b;
        int iD = this.f5927a.d(i2);
        if (iD == -1) {
            return null;
        }
        int iO = this.f5927a.o(i2, bVar.c);
        if (iO < iD) {
            return n(e0Var, bVar.f18710a, i2, iO, lk3Var.c, bVar.d);
        }
        long jLongValue = lk3Var.c;
        if (jLongValue == -9223372036854775807L) {
            e0.d dVar = this.b;
            e0.b bVar2 = this.f5927a;
            Pair<Object, Long> pairO = e0Var.o(dVar, bVar2, bVar2.c, -9223372036854775807L, Math.max(0L, j));
            if (pairO == null) {
                return null;
            }
            jLongValue = ((Long) pairO.second).longValue();
        }
        return o(e0Var, bVar.f18710a, Math.max(p(e0Var, bVar.f18710a, bVar.b), jLongValue), lk3Var.c, bVar.d);
    }

    @Nullable
    public jk3 l() {
        return this.j;
    }

    @Nullable
    public final lk3 m(e0 e0Var, i.b bVar, long j, long j2) {
        e0Var.l(bVar.f18710a, this.f5927a);
        return bVar.b() ? n(e0Var, bVar.f18710a, bVar.b, bVar.c, j, bVar.d) : o(e0Var, bVar.f18710a, j2, j, bVar.d);
    }

    public final lk3 n(e0 e0Var, Object obj, int i, int i2, long j, long j2) {
        i.b bVar = new i.b(obj, i, i2, j2);
        long jE = e0Var.l(bVar.f18710a, this.f5927a).e(bVar.b, bVar.c);
        long j3 = i2 == this.f5927a.n(i) ? this.f5927a.j() : 0L;
        return new lk3(bVar, (jE == -9223372036854775807L || j3 < jE) ? j3 : Math.max(0L, jE - 1), j, -9223372036854775807L, jE, this.f5927a.u(bVar.b), false, false, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final lk3 o(e0 e0Var, Object obj, long j, long j2, long j3) {
        boolean z;
        long j4;
        long jI;
        long j5;
        long jMax = j;
        e0Var.l(obj, this.f5927a);
        int iG = this.f5927a.g(jMax);
        int i = 1;
        boolean z2 = iG != -1 && this.f5927a.t(iG);
        if (iG == -1) {
            if (this.f5927a.f() > 0) {
                e0.b bVar = this.f5927a;
                z = bVar.u(bVar.r());
            }
        } else {
            if (this.f5927a.u(iG)) {
                long jI2 = this.f5927a.i(iG);
                e0.b bVar2 = this.f5927a;
                if (jI2 == bVar2.d && bVar2.s(iG)) {
                    iG = -1;
                }
            }
        }
        i.b bVar3 = new i.b(obj, j3, iG);
        boolean zV = v(bVar3);
        boolean zX = x(e0Var, bVar3);
        boolean zW = w(e0Var, bVar3, zV);
        boolean z3 = (iG == -1 || !this.f5927a.u(iG) || z2) ? false : true;
        if (iG != -1 && !z2) {
            jI = this.f5927a.i(iG);
        } else {
            if (!z) {
                j4 = -9223372036854775807L;
                j5 = (j4 != -9223372036854775807L || j4 == Long.MIN_VALUE) ? this.f5927a.d : j4;
                if (j5 != -9223372036854775807L && jMax >= j5) {
                    if (!zW && z) {
                        i = 0;
                    }
                    jMax = Math.max(0L, j5 - ((long) i));
                }
                return new lk3(bVar3, jMax, j2, j4, j5, z3, zV, zX, zW);
            }
            jI = this.f5927a.d;
        }
        j4 = jI;
        if (j4 != -9223372036854775807L) {
        }
        if (j5 != -9223372036854775807L) {
            if (!zW) {
                i = 0;
            }
            jMax = Math.max(0L, j5 - ((long) i));
        }
        return new lk3(bVar3, jMax, j2, j4, j5, z3, zV, zX, zW);
    }

    public final long p(e0 e0Var, Object obj, int i) {
        e0Var.l(obj, this.f5927a);
        long jI = this.f5927a.i(i);
        return jI == Long.MIN_VALUE ? this.f5927a.d : jI + this.f5927a.l(i);
    }

    @Nullable
    public lk3 q(long j, ij4 ij4Var) {
        jk3 jk3Var = this.j;
        return jk3Var == null ? h(ij4Var) : j(ij4Var.f18178a, jk3Var, j);
    }

    @Nullable
    public jk3 r() {
        return this.h;
    }

    @Nullable
    public jk3 s() {
        return this.i;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public lk3 t(e0 e0Var, lk3 lk3Var) {
        long jM;
        long j;
        boolean zU;
        int i;
        i.b bVar = lk3Var.f19020a;
        boolean zV = v(bVar);
        boolean zX = x(e0Var, bVar);
        boolean zW = w(e0Var, bVar, zV);
        e0Var.l(lk3Var.f19020a.f18710a, this.f5927a);
        long jI = (bVar.b() || (i = bVar.e) == -1) ? -9223372036854775807L : this.f5927a.i(i);
        if (bVar.b()) {
            jM = this.f5927a.e(bVar.b, bVar.c);
        } else {
            if (jI != -9223372036854775807L && jI != Long.MIN_VALUE) {
                j = jI;
                if (bVar.b()) {
                    int i2 = bVar.e;
                    zU = i2 != -1 && this.f5927a.u(i2);
                } else {
                    zU = this.f5927a.u(bVar.b);
                }
                return new lk3(bVar, lk3Var.b, lk3Var.c, jI, j, zU, zV, zX, zW);
            }
            jM = this.f5927a.m();
        }
        j = jM;
        if (bVar.b()) {
        }
        return new lk3(bVar, lk3Var.b, lk3Var.c, jI, j, zU, zV, zX, zW);
    }

    public final boolean u(Object obj, e0 e0Var) {
        int iF = e0Var.l(obj, this.f5927a).f();
        int iR = this.f5927a.r();
        return iF > 0 && this.f5927a.u(iR) && (iF > 1 || this.f5927a.i(iR) != Long.MIN_VALUE);
    }

    public final boolean v(i.b bVar) {
        return !bVar.b() && bVar.e == -1;
    }

    public final boolean w(e0 e0Var, i.b bVar, boolean z) {
        int iF = e0Var.f(bVar.f18710a);
        return !e0Var.r(e0Var.j(iF, this.f5927a).c, this.b).i && e0Var.v(iF, this.f5927a, this.b, this.f, this.g) && z;
    }

    public final boolean x(e0 e0Var, i.b bVar) {
        if (v(bVar)) {
            return e0Var.r(e0Var.l(bVar.f18710a, this.f5927a).c, this.b).p == e0Var.f(bVar.f18710a);
        }
        return false;
    }

    public boolean y(com.google.android.exoplayer2.source.h hVar) {
        jk3 jk3Var = this.j;
        return jk3Var != null && jk3Var.f18425a == hVar;
    }
}
