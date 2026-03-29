package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.media3.exoplayer.MediaPeriodQueue;
import com.google.android.exoplayer2.a0;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.e0;
import com.google.android.exoplayer2.h;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.s;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.h;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.android.exoplayer2.w;
import com.google.android.exoplayer2.z;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.k0;
import defpackage.bk4;
import defpackage.d25;
import defpackage.dp;
import defpackage.ed0;
import defpackage.g86;
import defpackage.ga5;
import defpackage.hv5;
import defpackage.hz5;
import defpackage.i43;
import defpackage.ij4;
import defpackage.jk3;
import defpackage.kc;
import defpackage.lk3;
import defpackage.mg2;
import defpackage.o06;
import defpackage.or1;
import defpackage.p06;
import defpackage.qo5;
import defpackage.tv4;
import defpackage.vh;
import defpackage.vz5;
import defpackage.w45;
import defpackage.y53;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class l implements Handler.Callback, h.a, o06.a, s.d, h.a, w.a {
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean E;
    public int F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public int K;

    @Nullable
    public h L;
    public long M;
    public int N;
    public boolean O;

    @Nullable
    public ExoPlaybackException P;
    public long Q;
    public long R = -9223372036854775807L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z[] f5884a;
    public final Set<z> b;
    public final a0[] c;
    public final o06 d;
    public final p06 e;
    public final i43 f;
    public final dp g;
    public final mg2 h;

    @Nullable
    public final HandlerThread i;
    public final Looper j;
    public final e0.d k;
    public final e0.b l;
    public final long m;
    public final boolean n;
    public final com.google.android.exoplayer2.h o;
    public final ArrayList<d> p;
    public final ed0 q;
    public final f r;
    public final r s;
    public final s t;
    public final o u;
    public final long v;
    public w45 w;
    public ij4 x;
    public e y;
    public boolean z;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements z.a {
        public a() {
        }

        @Override // com.google.android.exoplayer2.z.a
        public void onSleep() {
            l.this.I = true;
        }

        @Override // com.google.android.exoplayer2.z.a
        public void onWakeup() {
            l.this.h.sendEmptyMessage(2);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<s.c> f5886a;
        public final ga5 b;
        public final int c;
        public final long d;

        public /* synthetic */ b(List list, ga5 ga5Var, int i, long j, a aVar) {
            this(list, ga5Var, i, j);
        }

        public b(List<s.c> list, ga5 ga5Var, int i, long j) {
            this.f5886a = list;
            this.b = ga5Var;
            this.c = i;
            this.d = j;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f5887a;
        public final int b;
        public final int c;
        public final ga5 d;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class d implements Comparable<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final w f5888a;
        public int b;
        public long c;

        @Nullable
        public Object d;

        public d(w wVar) {
            this.f5888a = wVar;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(d dVar) {
            Object obj = this.d;
            if ((obj == null) != (dVar.d == null)) {
                return obj != null ? -1 : 1;
            }
            if (obj == null) {
                return 0;
            }
            int i = this.b - dVar.b;
            return i != 0 ? i : g86.o(this.c, dVar.c);
        }

        public void b(int i, long j, Object obj) {
            this.b = i;
            this.c = j;
            this.d = obj;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f5889a;
        public ij4 b;
        public int c;
        public boolean d;
        public int e;
        public boolean f;
        public int g;

        public e(ij4 ij4Var) {
            this.b = ij4Var;
        }

        public void b(int i) {
            this.f5889a |= i > 0;
            this.c += i;
        }

        public void c(int i) {
            this.f5889a = true;
            this.f = true;
            this.g = i;
        }

        public void d(ij4 ij4Var) {
            this.f5889a |= this.b != ij4Var;
            this.b = ij4Var;
        }

        public void e(int i) {
            if (this.d && this.e != 5) {
                vh.a(i == 5);
                return;
            }
            this.f5889a = true;
            this.d = true;
            this.e = i;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface f {
        void a(e eVar);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i.b f5890a;
        public final long b;
        public final long c;
        public final boolean d;
        public final boolean e;
        public final boolean f;

        public g(i.b bVar, long j, long j2, boolean z, boolean z2, boolean z3) {
            this.f5890a = bVar;
            this.b = j;
            this.c = j2;
            this.d = z;
            this.e = z2;
            this.f = z3;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e0 f5891a;
        public final int b;
        public final long c;

        public h(e0 e0Var, int i, long j) {
            this.f5891a = e0Var;
            this.b = i;
            this.c = j;
        }
    }

    public l(z[] zVarArr, o06 o06Var, p06 p06Var, i43 i43Var, dp dpVar, int i, boolean z, kc kcVar, w45 w45Var, o oVar, long j, boolean z2, Looper looper, ed0 ed0Var, f fVar, bk4 bk4Var, Looper looper2) {
        this.r = fVar;
        this.f5884a = zVarArr;
        this.d = o06Var;
        this.e = p06Var;
        this.f = i43Var;
        this.g = dpVar;
        this.F = i;
        this.G = z;
        this.w = w45Var;
        this.u = oVar;
        this.v = j;
        this.Q = j;
        this.A = z2;
        this.q = ed0Var;
        this.m = i43Var.getBackBufferDurationUs();
        this.n = i43Var.retainBackBufferFromKeyframe();
        ij4 ij4VarK = ij4.k(p06Var);
        this.x = ij4VarK;
        this.y = new e(ij4VarK);
        this.c = new a0[zVarArr.length];
        a0.a aVarD = o06Var.d();
        for (int i2 = 0; i2 < zVarArr.length; i2++) {
            zVarArr[i2].d(i2, bk4Var);
            this.c[i2] = zVarArr[i2].getCapabilities();
            if (aVarD != null) {
                this.c[i2].e(aVarD);
            }
        }
        this.o = new com.google.android.exoplayer2.h(this, ed0Var);
        this.p = new ArrayList<>();
        this.b = k0.i();
        this.k = new e0.d();
        this.l = new e0.b();
        o06Var.e(this, dpVar);
        this.O = true;
        mg2 mg2VarCreateHandler = ed0Var.createHandler(looper, null);
        this.s = new r(kcVar, mg2VarCreateHandler);
        this.t = new s(this, kcVar, mg2VarCreateHandler, bk4Var);
        if (looper2 != null) {
            this.i = null;
            this.j = looper2;
        } else {
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:Playback", -16);
            this.i = handlerThread;
            handlerThread.start();
            this.j = handlerThread.getLooper();
        }
        this.h = ed0Var.createHandler(this.j, this);
    }

    public static boolean N(boolean z, i.b bVar, long j, i.b bVar2, e0.b bVar3, long j2) {
        if (!z && j == j2 && bVar.f18710a.equals(bVar2.f18710a)) {
            return (bVar.b() && bVar3.u(bVar.b)) ? (bVar3.k(bVar.b, bVar.c) == 4 || bVar3.k(bVar.b, bVar.c) == 2) ? false : true : bVar2.b() && bVar3.u(bVar2.b);
        }
        return false;
    }

    public static boolean P(z zVar) {
        return zVar.getState() != 0;
    }

    public static boolean R(ij4 ij4Var, e0.b bVar) {
        i.b bVar2 = ij4Var.b;
        e0 e0Var = ij4Var.f18178a;
        return e0Var.u() || e0Var.l(bVar2.f18710a, bVar).f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean S() {
        return Boolean.valueOf(this.z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T(w wVar) {
        try {
            m(wVar);
        } catch (ExoPlaybackException e2) {
            y53.d("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e2);
            throw new RuntimeException(e2);
        }
    }

    public static void t0(e0 e0Var, d dVar, e0.d dVar2, e0.b bVar) {
        int i = e0Var.r(e0Var.l(dVar.d, bVar).c, dVar2).p;
        Object obj = e0Var.k(i, bVar, true).b;
        long j = bVar.d;
        dVar.b(i, j != -9223372036854775807L ? j - 1 : Long.MAX_VALUE, obj);
    }

    public static boolean u0(d dVar, e0 e0Var, e0 e0Var2, int i, boolean z, e0.d dVar2, e0.b bVar) {
        Object obj = dVar.d;
        if (obj == null) {
            Pair<Object, Long> pairX0 = x0(e0Var, new h(dVar.f5888a.h(), dVar.f5888a.d(), dVar.f5888a.f() == Long.MIN_VALUE ? -9223372036854775807L : g86.H0(dVar.f5888a.f())), false, i, z, dVar2, bVar);
            if (pairX0 == null) {
                return false;
            }
            dVar.b(e0Var.f(pairX0.first), ((Long) pairX0.second).longValue(), pairX0.first);
            if (dVar.f5888a.f() == Long.MIN_VALUE) {
                t0(e0Var, dVar, dVar2, bVar);
            }
            return true;
        }
        int iF = e0Var.f(obj);
        if (iF == -1) {
            return false;
        }
        if (dVar.f5888a.f() == Long.MIN_VALUE) {
            t0(e0Var, dVar, dVar2, bVar);
            return true;
        }
        dVar.b = iF;
        e0Var2.l(dVar.d, bVar);
        if (bVar.f && e0Var2.r(bVar.c, dVar2).o == e0Var2.f(dVar.d)) {
            Pair<Object, Long> pairN = e0Var.n(dVar2, bVar, e0Var.l(dVar.d, bVar).c, dVar.c + bVar.q());
            dVar.b(e0Var.f(pairN.first), ((Long) pairN.second).longValue(), pairN.first);
        }
        return true;
    }

    public static m[] w(or1 or1Var) {
        int length = or1Var != null ? or1Var.length() : 0;
        m[] mVarArr = new m[length];
        for (int i = 0; i < length; i++) {
            mVarArr[i] = or1Var.getFormat(i);
        }
        return mVarArr;
    }

    public static g w0(e0 e0Var, ij4 ij4Var, @Nullable h hVar, r rVar, int i, boolean z, e0.d dVar, e0.b bVar) {
        int i2;
        i.b bVar2;
        long jLongValue;
        int i3;
        boolean z2;
        boolean z3;
        boolean z4;
        int iE;
        int iE2;
        boolean z5;
        r rVar2;
        long j;
        int i4;
        boolean z6;
        int iE3;
        boolean z7;
        boolean z8;
        if (e0Var.u()) {
            return new g(ij4.l(), 0L, -9223372036854775807L, false, true, false);
        }
        i.b bVar3 = ij4Var.b;
        Object obj = bVar3.f18710a;
        boolean zR = R(ij4Var, bVar);
        long j2 = (ij4Var.b.b() || zR) ? ij4Var.c : ij4Var.r;
        if (hVar != null) {
            i2 = -1;
            Pair<Object, Long> pairX0 = x0(e0Var, hVar, true, i, z, dVar, bVar);
            if (pairX0 == null) {
                iE3 = e0Var.e(z);
                jLongValue = j2;
                z6 = false;
                z7 = false;
                z8 = true;
            } else {
                if (hVar.c == -9223372036854775807L) {
                    iE3 = e0Var.l(pairX0.first, bVar).c;
                    jLongValue = j2;
                    z6 = false;
                } else {
                    obj = pairX0.first;
                    jLongValue = ((Long) pairX0.second).longValue();
                    z6 = true;
                    iE3 = -1;
                }
                z7 = ij4Var.e == 4;
                z8 = false;
            }
            z4 = z6;
            z2 = z7;
            z3 = z8;
            i3 = iE3;
            bVar2 = bVar3;
        } else {
            i2 = -1;
            if (ij4Var.f18178a.u()) {
                iE = e0Var.e(z);
            } else if (e0Var.f(obj) == -1) {
                Object objY0 = y0(dVar, bVar, i, z, obj, ij4Var.f18178a, e0Var);
                if (objY0 == null) {
                    iE2 = e0Var.e(z);
                    z5 = true;
                } else {
                    iE2 = e0Var.l(objY0, bVar).c;
                    z5 = false;
                }
                i3 = iE2;
                z3 = z5;
                jLongValue = j2;
                bVar2 = bVar3;
                z2 = false;
                z4 = false;
            } else if (j2 == -9223372036854775807L) {
                iE = e0Var.l(obj, bVar).c;
            } else if (zR) {
                bVar2 = bVar3;
                ij4Var.f18178a.l(bVar2.f18710a, bVar);
                if (ij4Var.f18178a.r(bVar.c, dVar).o == ij4Var.f18178a.f(bVar2.f18710a)) {
                    Pair<Object, Long> pairN = e0Var.n(dVar, bVar, e0Var.l(obj, bVar).c, j2 + bVar.q());
                    obj = pairN.first;
                    jLongValue = ((Long) pairN.second).longValue();
                } else {
                    jLongValue = j2;
                }
                i3 = -1;
                z2 = false;
                z3 = false;
                z4 = true;
            } else {
                bVar2 = bVar3;
                jLongValue = j2;
                i3 = -1;
                z2 = false;
                z3 = false;
                z4 = false;
            }
            i3 = iE;
            jLongValue = j2;
            bVar2 = bVar3;
            z2 = false;
            z3 = false;
            z4 = false;
        }
        if (i3 != i2) {
            Pair<Object, Long> pairN2 = e0Var.n(dVar, bVar, i3, -9223372036854775807L);
            obj = pairN2.first;
            jLongValue = ((Long) pairN2.second).longValue();
            rVar2 = rVar;
            j = -9223372036854775807L;
        } else {
            rVar2 = rVar;
            j = jLongValue;
        }
        i.b bVarF = rVar2.F(e0Var, obj, jLongValue);
        int i5 = bVarF.e;
        boolean z9 = bVar2.f18710a.equals(obj) && !bVar2.b() && !bVarF.b() && (i5 == i2 || ((i4 = bVar2.e) != i2 && i5 >= i4));
        i.b bVar4 = bVar2;
        boolean zN = N(zR, bVar2, j2, bVarF, e0Var.l(obj, bVar), j);
        if (z9 || zN) {
            bVarF = bVar4;
        }
        if (bVarF.b()) {
            if (bVarF.equals(bVar4)) {
                jLongValue = ij4Var.r;
            } else {
                e0Var.l(bVarF.f18710a, bVar);
                jLongValue = bVarF.c == bVar.n(bVarF.b) ? bVar.j() : 0L;
            }
        }
        return new g(bVarF, jLongValue, j, z2, z3, z4);
    }

    @Nullable
    public static Pair<Object, Long> x0(e0 e0Var, h hVar, boolean z, int i, boolean z2, e0.d dVar, e0.b bVar) {
        Pair<Object, Long> pairN;
        Object objY0;
        e0 e0Var2 = hVar.f5891a;
        if (e0Var.u()) {
            return null;
        }
        e0 e0Var3 = e0Var2.u() ? e0Var : e0Var2;
        try {
            pairN = e0Var3.n(dVar, bVar, hVar.b, hVar.c);
        } catch (IndexOutOfBoundsException unused) {
        }
        if (e0Var.equals(e0Var3)) {
            return pairN;
        }
        if (e0Var.f(pairN.first) != -1) {
            return (e0Var3.l(pairN.first, bVar).f && e0Var3.r(bVar.c, dVar).o == e0Var3.f(pairN.first)) ? e0Var.n(dVar, bVar, e0Var.l(pairN.first, bVar).c, hVar.c) : pairN;
        }
        if (z && (objY0 = y0(dVar, bVar, i, z2, pairN.first, e0Var3, e0Var)) != null) {
            return e0Var.n(dVar, bVar, e0Var.l(objY0, bVar).c, -9223372036854775807L);
        }
        return null;
    }

    @Nullable
    public static Object y0(e0.d dVar, e0.b bVar, int i, boolean z, Object obj, e0 e0Var, e0 e0Var2) {
        int iF = e0Var.f(obj);
        int iM = e0Var.m();
        int iH = iF;
        int iF2 = -1;
        for (int i2 = 0; i2 < iM && iF2 == -1; i2++) {
            iH = e0Var.h(iH, bVar, dVar, i, z);
            if (iH == -1) {
                break;
            }
            iF2 = e0Var2.f(e0Var.q(iH));
        }
        if (iF2 == -1) {
            return null;
        }
        return e0Var2.q(iF2);
    }

    public Looper A() {
        return this.j;
    }

    public void A0(e0 e0Var, int i, long j) {
        this.h.obtainMessage(3, new h(e0Var, i, j)).sendToTarget();
    }

    public final long B() {
        return C(this.x.p);
    }

    public final void B0(boolean z) throws ExoPlaybackException {
        i.b bVar = this.s.r().f.f19020a;
        long jE0 = E0(bVar, this.x.r, true, false);
        if (jE0 != this.x.r) {
            ij4 ij4Var = this.x;
            this.x = K(bVar, jE0, ij4Var.c, ij4Var.d, z, 5);
        }
    }

    public final long C(long j) {
        jk3 jk3VarL = this.s.l();
        if (jk3VarL == null) {
            return 0L;
        }
        return Math.max(0L, j - jk3VarL.y(this.M));
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00ab A[Catch: all -> 0x0146, TryCatch #1 {all -> 0x0146, blocks: (B:22:0x00a1, B:24:0x00ab, B:27:0x00b1, B:29:0x00b7, B:30:0x00ba, B:32:0x00c0, B:34:0x00ca, B:36:0x00d2, B:40:0x00da, B:42:0x00e4, B:44:0x00f4, B:48:0x00fe, B:52:0x0110, B:56:0x0119), top: B:74:0x00a1 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void C0(h hVar) throws Throwable {
        long jLongValue;
        long j;
        boolean z;
        i.b bVar;
        long j2;
        long j3;
        long j4;
        long jA;
        long j5;
        ij4 ij4Var;
        int i;
        this.y.b(1);
        Pair<Object, Long> pairX0 = x0(this.x.f18178a, hVar, true, this.F, this.G, this.k, this.l);
        try {
            if (pairX0 == null) {
                Pair<i.b, Long> pairZ = z(this.x.f18178a);
                bVar = (i.b) pairZ.first;
                jLongValue = ((Long) pairZ.second).longValue();
                z = !this.x.f18178a.u();
                j = -9223372036854775807L;
            } else {
                Object obj = pairX0.first;
                jLongValue = ((Long) pairX0.second).longValue();
                long j6 = hVar.c == -9223372036854775807L ? -9223372036854775807L : jLongValue;
                i.b bVarF = this.s.F(this.x.f18178a, obj, jLongValue);
                if (bVarF.b()) {
                    this.x.f18178a.l(bVarF.f18710a, this.l);
                    j2 = this.l.n(bVarF.b) == bVarF.c ? this.l.j() : 0L;
                    j3 = j6;
                    z = true;
                    bVar = bVarF;
                    if (!this.x.f18178a.u()) {
                        this.L = hVar;
                    } else {
                        if (pairX0 != null) {
                            if (bVar.equals(this.x.b)) {
                                jk3 jk3VarR = this.s.r();
                                jA = (jk3VarR == null || !jk3VarR.d || j2 == 0) ? j2 : jk3VarR.f18425a.a(j2, this.w);
                                if (g86.m1(jA) == g86.m1(this.x.r) && ((i = (ij4Var = this.x).e) == 2 || i == 3)) {
                                    long j7 = ij4Var.r;
                                    this.x = K(bVar, j7, j3, j7, z, 2);
                                    return;
                                }
                            } else {
                                jA = j2;
                            }
                            long jD0 = D0(bVar, jA, this.x.e == 4);
                            z |= j2 != jD0;
                            try {
                                ij4 ij4Var2 = this.x;
                                e0 e0Var = ij4Var2.f18178a;
                                o1(e0Var, bVar, e0Var, ij4Var2.b, j3, true);
                                j5 = jD0;
                                this.x = K(bVar, j5, j3, j5, z, 2);
                                return;
                            } catch (Throwable th) {
                                th = th;
                                j4 = jD0;
                                this.x = K(bVar, j4, j3, j4, z, 2);
                                throw th;
                            }
                        }
                        if (this.x.e != 1) {
                            a1(4);
                        }
                        q0(false, true, false, true);
                    }
                    j5 = j2;
                    this.x = K(bVar, j5, j3, j5, z, 2);
                    return;
                }
                j = j6;
                z = hVar.c == -9223372036854775807L;
                bVar = bVarF;
            }
            if (!this.x.f18178a.u()) {
            }
            j5 = j2;
            this.x = K(bVar, j5, j3, j5, z, 2);
            return;
        } catch (Throwable th2) {
            th = th2;
            j4 = j2;
        }
        j2 = jLongValue;
        j3 = j;
    }

    public final void D(com.google.android.exoplayer2.source.h hVar) {
        if (this.s.y(hVar)) {
            this.s.C(this.M);
            U();
        }
    }

    public final long D0(i.b bVar, long j, boolean z) throws ExoPlaybackException {
        return E0(bVar, j, this.s.r() != this.s.s(), z);
    }

    public final void E(IOException iOException, int i) {
        ExoPlaybackException exoPlaybackExceptionCreateForSource = ExoPlaybackException.createForSource(iOException, i);
        jk3 jk3VarR = this.s.r();
        if (jk3VarR != null) {
            exoPlaybackExceptionCreateForSource = exoPlaybackExceptionCreateForSource.copyWithMediaPeriodId(jk3VarR.f.f19020a);
        }
        y53.d("ExoPlayerImplInternal", "Playback error", exoPlaybackExceptionCreateForSource);
        i1(false, false);
        this.x = this.x.f(exoPlaybackExceptionCreateForSource);
    }

    public final long E0(i.b bVar, long j, boolean z, boolean z2) throws ExoPlaybackException {
        j1();
        this.C = false;
        if (z2 || this.x.e == 3) {
            a1(2);
        }
        jk3 jk3VarR = this.s.r();
        jk3 jk3VarJ = jk3VarR;
        while (jk3VarJ != null && !bVar.equals(jk3VarJ.f.f19020a)) {
            jk3VarJ = jk3VarJ.j();
        }
        if (z || jk3VarR != jk3VarJ || (jk3VarJ != null && jk3VarJ.z(j) < 0)) {
            for (z zVar : this.f5884a) {
                n(zVar);
            }
            if (jk3VarJ != null) {
                while (this.s.r() != jk3VarJ) {
                    this.s.b();
                }
                this.s.D(jk3VarJ);
                jk3VarJ.x(MediaPeriodQueue.INITIAL_RENDERER_POSITION_OFFSET_US);
                q();
            }
        }
        if (jk3VarJ != null) {
            this.s.D(jk3VarJ);
            if (!jk3VarJ.d) {
                jk3VarJ.f = jk3VarJ.f.b(j);
            } else if (jk3VarJ.e) {
                long jSeekToUs = jk3VarJ.f18425a.seekToUs(j);
                jk3VarJ.f18425a.discardBuffer(jSeekToUs - this.m, this.n);
                j = jSeekToUs;
            }
            s0(j);
            U();
        } else {
            this.s.f();
            s0(j);
        }
        F(false);
        this.h.sendEmptyMessage(2);
        return j;
    }

    public final void F(boolean z) {
        jk3 jk3VarL = this.s.l();
        i.b bVar = jk3VarL == null ? this.x.b : jk3VarL.f.f19020a;
        boolean z2 = !this.x.k.equals(bVar);
        if (z2) {
            this.x = this.x.c(bVar);
        }
        ij4 ij4Var = this.x;
        ij4Var.p = jk3VarL == null ? ij4Var.r : jk3VarL.i();
        this.x.q = B();
        if ((z2 || z) && jk3VarL != null && jk3VarL.d) {
            l1(jk3VarL.f.f19020a, jk3VarL.n(), jk3VarL.o());
        }
    }

    public final void F0(w wVar) throws ExoPlaybackException {
        if (wVar.f() == -9223372036854775807L) {
            G0(wVar);
            return;
        }
        if (this.x.f18178a.u()) {
            this.p.add(new d(wVar));
            return;
        }
        d dVar = new d(wVar);
        e0 e0Var = this.x.f18178a;
        if (!u0(dVar, e0Var, e0Var, this.F, this.G, this.k, this.l)) {
            wVar.k(false);
        } else {
            this.p.add(dVar);
            Collections.sort(this.p);
        }
    }

    /* JADX WARN: Not initialized variable reg: 25, insn: 0x013c: MOVE (r5 I:??[long, double]) = (r25 I:??[long, double]) (LINE:317), block:B:70:0x013b */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void G(e0 e0Var, boolean z) throws Throwable {
        h hVar;
        long j;
        long j2;
        long j3;
        long jD0;
        g gVarW0 = w0(e0Var, this.x, this.L, this.s, this.F, this.G, this.k, this.l);
        i.b bVar = gVarW0.f5890a;
        long j4 = gVarW0.c;
        boolean z2 = gVarW0.d;
        long j5 = gVarW0.b;
        int i = 1;
        boolean z3 = (this.x.b.equals(bVar) && j5 == this.x.r) ? false : true;
        try {
            if (gVarW0.e) {
                if (this.x.e != 1) {
                    a1(4);
                }
                q0(false, false, false, true);
            }
            try {
                if (!z3) {
                    try {
                        i = -1;
                        j3 = j5;
                        if (!this.s.J(e0Var, this.M, y())) {
                            B0(false);
                        }
                        jD0 = j3;
                        ij4 ij4Var = this.x;
                        o1(e0Var, bVar, ij4Var.f18178a, ij4Var.b, !gVarW0.f ? jD0 : -9223372036854775807L, false);
                        if (!z3 || j4 != this.x.c) {
                            ij4 ij4Var2 = this.x;
                            Object obj = ij4Var2.b.f18710a;
                            e0 e0Var2 = ij4Var2.f18178a;
                            this.x = K(bVar, jD0, j4, this.x.d, (z3 || !z || e0Var2.u() || e0Var2.l(obj, this.l).f) ? false : true, e0Var.f(obj) != i ? 4 : 3);
                        }
                        r0();
                        v0(e0Var, this.x.f18178a);
                        this.x = this.x.j(e0Var);
                        if (!e0Var.u()) {
                            this.L = null;
                        }
                        F(false);
                    } catch (Throwable th) {
                        th = th;
                        i = -1;
                        hVar = null;
                        ij4 ij4Var3 = this.x;
                        j = j5;
                        o1(e0Var, bVar, ij4Var3.f18178a, ij4Var3.b, gVarW0.f ? j5 : -9223372036854775807L, false);
                        if (!z3 || j4 != this.x.c) {
                            ij4 ij4Var4 = this.x;
                            Object obj2 = ij4Var4.b.f18710a;
                            e0 e0Var3 = ij4Var4.f18178a;
                            this.x = K(bVar, j, j4, this.x.d, (z3 || !z || e0Var3.u() || e0Var3.l(obj2, this.l).f) ? false : true, e0Var.f(obj2) != i ? 4 : 3);
                        }
                        r0();
                        v0(e0Var, this.x.f18178a);
                        this.x = this.x.j(e0Var);
                        if (!e0Var.u()) {
                            this.L = hVar;
                        }
                        F(false);
                        throw th;
                    }
                }
                j3 = j5;
                i = -1;
                if (e0Var.u()) {
                    jD0 = j3;
                } else {
                    try {
                        for (jk3 jk3VarR = this.s.r(); jk3VarR != null; jk3VarR = jk3VarR.j()) {
                            if (jk3VarR.f.f19020a.equals(bVar)) {
                                jk3VarR.f = this.s.t(e0Var, jk3VarR.f);
                                jk3VarR.A();
                            }
                        }
                        j5 = j3;
                        try {
                            jD0 = D0(bVar, j5, z2);
                        } catch (Throwable th2) {
                            th = th2;
                            hVar = null;
                            ij4 ij4Var32 = this.x;
                            j = j5;
                            o1(e0Var, bVar, ij4Var32.f18178a, ij4Var32.b, gVarW0.f ? j5 : -9223372036854775807L, false);
                            if (!z3) {
                                ij4 ij4Var42 = this.x;
                                Object obj22 = ij4Var42.b.f18710a;
                                e0 e0Var32 = ij4Var42.f18178a;
                                if (z3) {
                                    this.x = K(bVar, j, j4, this.x.d, (z3 || !z || e0Var32.u() || e0Var32.l(obj22, this.l).f) ? false : true, e0Var.f(obj22) != i ? 4 : 3);
                                }
                            }
                            r0();
                            v0(e0Var, this.x.f18178a);
                            this.x = this.x.j(e0Var);
                            if (!e0Var.u()) {
                            }
                            F(false);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        j5 = j3;
                    }
                }
                ij4 ij4Var5 = this.x;
                o1(e0Var, bVar, ij4Var5.f18178a, ij4Var5.b, !gVarW0.f ? jD0 : -9223372036854775807L, false);
                if (!z3) {
                    ij4 ij4Var22 = this.x;
                    Object obj3 = ij4Var22.b.f18710a;
                    e0 e0Var22 = ij4Var22.f18178a;
                    if (z3) {
                        this.x = K(bVar, jD0, j4, this.x.d, (z3 || !z || e0Var22.u() || e0Var22.l(obj3, this.l).f) ? false : true, e0Var.f(obj3) != i ? 4 : 3);
                    }
                }
                r0();
                v0(e0Var, this.x.f18178a);
                this.x = this.x.j(e0Var);
                if (!e0Var.u()) {
                }
                F(false);
            } catch (Throwable th4) {
                th = th4;
                hVar = null;
                j5 = j2;
            }
        } catch (Throwable th5) {
            th = th5;
            hVar = null;
            i = -1;
        }
    }

    public final void G0(w wVar) throws ExoPlaybackException {
        if (wVar.c() != this.j) {
            this.h.obtainMessage(15, wVar).sendToTarget();
            return;
        }
        m(wVar);
        int i = this.x.e;
        if (i == 3 || i == 2) {
            this.h.sendEmptyMessage(2);
        }
    }

    public final void H(com.google.android.exoplayer2.source.h hVar) throws ExoPlaybackException {
        if (this.s.y(hVar)) {
            jk3 jk3VarL = this.s.l();
            jk3VarL.p(this.o.getPlaybackParameters().f5989a, this.x.f18178a);
            l1(jk3VarL.f.f19020a, jk3VarL.n(), jk3VarL.o());
            if (jk3VarL == this.s.r()) {
                s0(jk3VarL.f.b);
                q();
                ij4 ij4Var = this.x;
                i.b bVar = ij4Var.b;
                long j = jk3VarL.f.b;
                this.x = K(bVar, j, ij4Var.c, j, false, 5);
            }
            U();
        }
    }

    public final void H0(final w wVar) {
        Looper looperC = wVar.c();
        if (looperC.getThread().isAlive()) {
            this.q.createHandler(looperC, null).post(new Runnable() { // from class: hr1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f18033a.T(wVar);
                }
            });
        } else {
            y53.i("TAG", "Trying to send message on a dead thread.");
            wVar.k(false);
        }
    }

    public final void I(u uVar, float f2, boolean z, boolean z2) throws ExoPlaybackException {
        if (z) {
            if (z2) {
                this.y.b(1);
            }
            this.x = this.x.g(uVar);
        }
        p1(uVar.f5989a);
        for (z zVar : this.f5884a) {
            if (zVar != null) {
                zVar.setPlaybackSpeed(f2, uVar.f5989a);
            }
        }
    }

    public final void I0(long j) {
        for (z zVar : this.f5884a) {
            if (zVar.getStream() != null) {
                J0(zVar, j);
            }
        }
    }

    public final void J(u uVar, boolean z) throws ExoPlaybackException {
        I(uVar, uVar.f5989a, true, z);
    }

    public final void J0(z zVar, long j) {
        zVar.setCurrentStreamFinal();
        if (zVar instanceof hv5) {
            ((hv5) zVar).K(j);
        }
    }

    @CheckResult
    public final ij4 K(i.b bVar, long j, long j2, long j3, boolean z, int i) {
        List<Metadata> listOf;
        vz5 vz5Var;
        p06 p06Var;
        this.O = (!this.O && j == this.x.r && bVar.equals(this.x.b)) ? false : true;
        r0();
        ij4 ij4Var = this.x;
        vz5 vz5Var2 = ij4Var.h;
        p06 p06Var2 = ij4Var.i;
        List<Metadata> list = ij4Var.j;
        if (this.t.t()) {
            jk3 jk3VarR = this.s.r();
            vz5 vz5VarN = jk3VarR == null ? vz5.d : jk3VarR.n();
            p06 p06VarO = jk3VarR == null ? this.e : jk3VarR.o();
            ImmutableList<Metadata> immutableListU = u(p06VarO.c);
            if (jk3VarR != null) {
                lk3 lk3Var = jk3VarR.f;
                if (lk3Var.c != j2) {
                    jk3VarR.f = lk3Var.a(j2);
                }
            }
            vz5Var = vz5VarN;
            p06Var = p06VarO;
            listOf = immutableListU;
        } else if (bVar.equals(this.x.b)) {
            listOf = list;
            vz5Var = vz5Var2;
            p06Var = p06Var2;
        } else {
            vz5Var = vz5.d;
            p06Var = this.e;
            listOf = ImmutableList.of();
        }
        if (z) {
            this.y.e(i);
        }
        return this.x.d(bVar, j, j2, j3, B(), vz5Var, p06Var, listOf);
    }

    public final void K0(boolean z, @Nullable AtomicBoolean atomicBoolean) {
        if (this.H != z) {
            this.H = z;
            if (!z) {
                for (z zVar : this.f5884a) {
                    if (!P(zVar) && this.b.remove(zVar)) {
                        zVar.reset();
                    }
                }
            }
        }
        if (atomicBoolean != null) {
            synchronized (this) {
                atomicBoolean.set(true);
                notifyAll();
            }
        }
    }

    public final boolean L(z zVar, jk3 jk3Var) {
        jk3 jk3VarJ = jk3Var.j();
        return jk3Var.f.f && jk3VarJ.d && ((zVar instanceof hv5) || (zVar instanceof com.google.android.exoplayer2.metadata.a) || zVar.getReadingPositionUs() >= jk3VarJ.m());
    }

    public final void L0(u uVar) {
        this.h.removeMessages(16);
        this.o.b(uVar);
    }

    public final boolean M() {
        jk3 jk3VarS = this.s.s();
        if (!jk3VarS.d) {
            return false;
        }
        int i = 0;
        while (true) {
            z[] zVarArr = this.f5884a;
            if (i >= zVarArr.length) {
                return true;
            }
            z zVar = zVarArr[i];
            d25 d25Var = jk3VarS.c[i];
            if (zVar.getStream() != d25Var || (d25Var != null && !zVar.hasReadStreamToEnd() && !L(zVar, jk3VarS))) {
                break;
            }
            i++;
        }
        return false;
    }

    public final void M0(b bVar) throws Throwable {
        this.y.b(1);
        if (bVar.c != -1) {
            this.L = new h(new x(bVar.f5886a, bVar.b), bVar.c, bVar.d);
        }
        G(this.t.D(bVar.f5886a, bVar.b), false);
    }

    public void N0(List<s.c> list, int i, long j, ga5 ga5Var) {
        this.h.obtainMessage(17, new b(list, ga5Var, i, j, null)).sendToTarget();
    }

    public final boolean O() {
        jk3 jk3VarL = this.s.l();
        return (jk3VarL == null || jk3VarL.k() == Long.MIN_VALUE) ? false : true;
    }

    public final void O0(boolean z) {
        if (z == this.J) {
            return;
        }
        this.J = z;
        if (z || !this.x.o) {
            return;
        }
        this.h.sendEmptyMessage(2);
    }

    public final void P0(boolean z) throws ExoPlaybackException {
        this.A = z;
        r0();
        if (!this.B || this.s.s() == this.s.r()) {
            return;
        }
        B0(true);
        F(false);
    }

    public final boolean Q() {
        jk3 jk3VarR = this.s.r();
        long j = jk3VarR.f.e;
        return jk3VarR.d && (j == -9223372036854775807L || this.x.r < j || !d1());
    }

    public void Q0(boolean z, int i) {
        this.h.obtainMessage(1, z ? 1 : 0, i).sendToTarget();
    }

    public final void R0(boolean z, int i, boolean z2, int i2) throws ExoPlaybackException {
        this.y.b(z2 ? 1 : 0);
        this.y.c(i2);
        this.x = this.x.e(z, i);
        this.C = false;
        e0(z);
        if (!d1()) {
            j1();
            n1();
            return;
        }
        int i3 = this.x.e;
        if (i3 == 3) {
            g1();
            this.h.sendEmptyMessage(2);
        } else if (i3 == 2) {
            this.h.sendEmptyMessage(2);
        }
    }

    public void S0(u uVar) {
        this.h.obtainMessage(4, uVar).sendToTarget();
    }

    public final void T0(u uVar) throws ExoPlaybackException {
        L0(uVar);
        J(this.o.getPlaybackParameters(), true);
    }

    public final void U() {
        boolean zC1 = c1();
        this.E = zC1;
        if (zC1) {
            this.s.l().d(this.M);
        }
        k1();
    }

    public void U0(int i) {
        this.h.obtainMessage(11, i, 0).sendToTarget();
    }

    public final void V() {
        this.y.d(this.x);
        if (this.y.f5889a) {
            this.r.a(this.y);
            this.y = new e(this.x);
        }
    }

    public final void V0(int i) throws ExoPlaybackException {
        this.F = i;
        if (!this.s.K(this.x.f18178a, i)) {
            B0(true);
        }
        F(false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:70:0x0045, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0074, code lost:
    
        r3 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void W(long j, long j2) throws ExoPlaybackException {
        d dVar;
        d dVar2;
        if (this.p.isEmpty() || this.x.b.b()) {
            return;
        }
        if (this.O) {
            j--;
            this.O = false;
        }
        ij4 ij4Var = this.x;
        int iF = ij4Var.f18178a.f(ij4Var.b.f18710a);
        int iMin = Math.min(this.N, this.p.size());
        if (iMin > 0) {
            dVar = this.p.get(iMin - 1);
            while (dVar != null) {
                int i = dVar.b;
                if (i <= iF && (i != iF || dVar.c <= j)) {
                    break;
                }
                iMin--;
                if (iMin > 0) {
                    dVar = this.p.get(iMin - 1);
                }
            }
            if (iMin < this.p.size()) {
                dVar2 = this.p.get(iMin);
                while (dVar2 != null && dVar2.d != null) {
                    int i2 = dVar2.b;
                    if (i2 >= iF && (i2 != iF || dVar2.c > j)) {
                        break;
                    }
                    iMin++;
                    if (iMin < this.p.size()) {
                        dVar2 = this.p.get(iMin);
                    }
                }
                while (dVar2 != null && dVar2.d != null && dVar2.b == iF) {
                    long j3 = dVar2.c;
                    if (j3 <= j || j3 > j2) {
                        break;
                    }
                    try {
                        G0(dVar2.f5888a);
                        if (dVar2.f5888a.b() || dVar2.f5888a.j()) {
                            this.p.remove(iMin);
                        } else {
                            iMin++;
                        }
                        dVar2 = iMin < this.p.size() ? this.p.get(iMin) : null;
                    } catch (Throwable th) {
                        if (dVar2.f5888a.b() || dVar2.f5888a.j()) {
                            this.p.remove(iMin);
                        }
                        throw th;
                    }
                }
                this.N = iMin;
                return;
            }
            dVar2 = null;
        }
        dVar = null;
    }

    public final void W0(w45 w45Var) {
        this.w = w45Var;
    }

    public final void X() throws ExoPlaybackException {
        lk3 lk3VarQ;
        this.s.C(this.M);
        if (this.s.H() && (lk3VarQ = this.s.q(this.M, this.x)) != null) {
            jk3 jk3VarG = this.s.g(this.c, this.d, this.f.getAllocator(), this.t, lk3VarQ, this.e);
            jk3VarG.f18425a.g(this, lk3VarQ.b);
            if (this.s.r() == jk3VarG) {
                s0(lk3VarQ.b);
            }
            F(false);
        }
        if (!this.E) {
            U();
        } else {
            this.E = O();
            k1();
        }
    }

    public void X0(boolean z) {
        this.h.obtainMessage(12, z ? 1 : 0, 0).sendToTarget();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Y() throws ExoPlaybackException {
        boolean z;
        boolean z2 = false;
        while (b1()) {
            if (z2) {
                V();
            }
            jk3 jk3Var = (jk3) vh.e(this.s.b());
            if (this.x.b.f18710a.equals(jk3Var.f.f19020a.f18710a)) {
                i.b bVar = this.x.b;
                if (bVar.b == -1) {
                    i.b bVar2 = jk3Var.f.f19020a;
                    z = bVar2.b == -1 && bVar.e != bVar2.e;
                }
            }
            lk3 lk3Var = jk3Var.f;
            i.b bVar3 = lk3Var.f19020a;
            long j = lk3Var.b;
            this.x = K(bVar3, j, lk3Var.c, j, !z, 0);
            r0();
            n1();
            z2 = true;
        }
    }

    public final void Y0(boolean z) throws ExoPlaybackException {
        this.G = z;
        if (!this.s.L(this.x.f18178a, z)) {
            B0(true);
        }
        F(false);
    }

    public final void Z() throws ExoPlaybackException {
        jk3 jk3VarS = this.s.s();
        if (jk3VarS == null) {
            return;
        }
        int i = 0;
        if (jk3VarS.j() != null && !this.B) {
            if (M()) {
                if (jk3VarS.j().d || this.M >= jk3VarS.j().m()) {
                    p06 p06VarO = jk3VarS.o();
                    jk3 jk3VarC = this.s.c();
                    p06 p06VarO2 = jk3VarC.o();
                    e0 e0Var = this.x.f18178a;
                    o1(e0Var, jk3VarC.f.f19020a, e0Var, jk3VarS.f.f19020a, -9223372036854775807L, false);
                    if (jk3VarC.d && jk3VarC.f18425a.readDiscontinuity() != -9223372036854775807L) {
                        I0(jk3VarC.m());
                        return;
                    }
                    for (int i2 = 0; i2 < this.f5884a.length; i2++) {
                        boolean zC = p06VarO.c(i2);
                        boolean zC2 = p06VarO2.c(i2);
                        if (zC && !this.f5884a[i2].isCurrentStreamFinal()) {
                            boolean z = this.c[i2].getTrackType() == -2;
                            tv4 tv4Var = p06VarO.b[i2];
                            tv4 tv4Var2 = p06VarO2.b[i2];
                            if (!zC2 || !tv4Var2.equals(tv4Var) || z) {
                                J0(this.f5884a[i2], jk3VarC.m());
                            }
                        }
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (!jk3VarS.f.i && !this.B) {
            return;
        }
        while (true) {
            z[] zVarArr = this.f5884a;
            if (i >= zVarArr.length) {
                return;
            }
            z zVar = zVarArr[i];
            d25 d25Var = jk3VarS.c[i];
            if (d25Var != null && zVar.getStream() == d25Var && zVar.hasReadStreamToEnd()) {
                long j = jk3VarS.f.e;
                J0(zVar, (j == -9223372036854775807L || j == Long.MIN_VALUE) ? -9223372036854775807L : jk3VarS.l() + jk3VarS.f.e);
            }
            i++;
        }
    }

    public final void Z0(ga5 ga5Var) throws Throwable {
        this.y.b(1);
        G(this.t.E(ga5Var), false);
    }

    @Override // o06.a
    public void a(z zVar) {
        this.h.sendEmptyMessage(26);
    }

    public final void a0() throws ExoPlaybackException {
        jk3 jk3VarS = this.s.s();
        if (jk3VarS == null || this.s.r() == jk3VarS || jk3VarS.g || !n0()) {
            return;
        }
        q();
    }

    public final void a1(int i) {
        ij4 ij4Var = this.x;
        if (ij4Var.e != i) {
            if (i != 2) {
                this.R = -9223372036854775807L;
            }
            this.x = ij4Var.h(i);
        }
    }

    @Override // com.google.android.exoplayer2.w.a
    public synchronized void b(w wVar) {
        if (!this.z && this.j.getThread().isAlive()) {
            this.h.obtainMessage(14, wVar).sendToTarget();
            return;
        }
        y53.i("ExoPlayerImplInternal", "Ignoring messages sent after release.");
        wVar.k(false);
    }

    public final void b0() throws Throwable {
        G(this.t.i(), true);
    }

    public final boolean b1() {
        jk3 jk3VarR;
        jk3 jk3VarJ;
        return d1() && !this.B && (jk3VarR = this.s.r()) != null && (jk3VarJ = jk3VarR.j()) != null && this.M >= jk3VarJ.m() && jk3VarJ.g;
    }

    public final void c0(c cVar) throws Throwable {
        this.y.b(1);
        G(this.t.w(cVar.f5887a, cVar.b, cVar.c, cVar.d), false);
    }

    public final boolean c1() {
        if (!O()) {
            return false;
        }
        jk3 jk3VarL = this.s.l();
        long jC = C(jk3VarL.k());
        long jY = jk3VarL == this.s.r() ? jk3VarL.y(this.M) : jk3VarL.y(this.M) - jk3VarL.f.b;
        boolean zShouldContinueLoading = this.f.shouldContinueLoading(jY, jC, this.o.getPlaybackParameters().f5989a);
        if (zShouldContinueLoading || jC >= 500000) {
            return zShouldContinueLoading;
        }
        if (this.m <= 0 && !this.n) {
            return zShouldContinueLoading;
        }
        this.s.r().f18425a.discardBuffer(this.x.r, false);
        return this.f.shouldContinueLoading(jY, jC, this.o.getPlaybackParameters().f5989a);
    }

    public final void d0() {
        for (jk3 jk3VarR = this.s.r(); jk3VarR != null; jk3VarR = jk3VarR.j()) {
            for (or1 or1Var : jk3VarR.o().c) {
                if (or1Var != null) {
                    or1Var.onDiscontinuity();
                }
            }
        }
    }

    public final boolean d1() {
        ij4 ij4Var = this.x;
        return ij4Var.l && ij4Var.m == 0;
    }

    public final void e0(boolean z) {
        for (jk3 jk3VarR = this.s.r(); jk3VarR != null; jk3VarR = jk3VarR.j()) {
            for (or1 or1Var : jk3VarR.o().c) {
                if (or1Var != null) {
                    or1Var.onPlayWhenReadyChanged(z);
                }
            }
        }
    }

    public final boolean e1(boolean z) {
        if (this.K == 0) {
            return Q();
        }
        if (!z) {
            return false;
        }
        if (!this.x.g) {
            return true;
        }
        jk3 jk3VarR = this.s.r();
        long targetLiveOffsetUs = f1(this.x.f18178a, jk3VarR.f.f19020a) ? this.u.getTargetLiveOffsetUs() : -9223372036854775807L;
        jk3 jk3VarL = this.s.l();
        return (jk3VarL.q() && jk3VarL.f.i) || (jk3VarL.f.f19020a.b() && !jk3VarL.d) || this.f.b(this.x.f18178a, jk3VarR.f.f19020a, B(), this.o.getPlaybackParameters().f5989a, this.C, targetLiveOffsetUs);
    }

    @Override // com.google.android.exoplayer2.source.h.a
    public void f(com.google.android.exoplayer2.source.h hVar) {
        this.h.obtainMessage(8, hVar).sendToTarget();
    }

    public final void f0() {
        for (jk3 jk3VarR = this.s.r(); jk3VarR != null; jk3VarR = jk3VarR.j()) {
            for (or1 or1Var : jk3VarR.o().c) {
                if (or1Var != null) {
                    or1Var.onRebuffer();
                }
            }
        }
    }

    public final boolean f1(e0 e0Var, i.b bVar) {
        if (bVar.b() || e0Var.u()) {
            return false;
        }
        e0Var.r(e0Var.l(bVar.f18710a, this.l).c, this.k);
        if (!this.k.h()) {
            return false;
        }
        e0.d dVar = this.k;
        return dVar.i && dVar.f != -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.h.a
    public void g(u uVar) {
        this.h.obtainMessage(16, uVar).sendToTarget();
    }

    @Override // com.google.android.exoplayer2.source.q.a
    /* JADX INFO: renamed from: g0, reason: merged with bridge method [inline-methods] */
    public void c(com.google.android.exoplayer2.source.h hVar) {
        this.h.obtainMessage(9, hVar).sendToTarget();
    }

    public final void g1() throws ExoPlaybackException {
        this.C = false;
        this.o.f();
        for (z zVar : this.f5884a) {
            if (P(zVar)) {
                zVar.start();
            }
        }
    }

    public void h0() {
        this.h.obtainMessage(0).sendToTarget();
    }

    public void h1() {
        this.h.obtainMessage(6).sendToTarget();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) throws Throwable {
        jk3 jk3VarS;
        try {
            switch (message.what) {
                case 0:
                    i0();
                    break;
                case 1:
                    R0(message.arg1 != 0, message.arg2, true, 1);
                    break;
                case 2:
                    o();
                    break;
                case 3:
                    C0((h) message.obj);
                    break;
                case 4:
                    T0((u) message.obj);
                    break;
                case 5:
                    W0((w45) message.obj);
                    break;
                case 6:
                    i1(false, true);
                    break;
                case 7:
                    k0();
                    return true;
                case 8:
                    H((com.google.android.exoplayer2.source.h) message.obj);
                    break;
                case 9:
                    D((com.google.android.exoplayer2.source.h) message.obj);
                    break;
                case 10:
                    o0();
                    break;
                case 11:
                    V0(message.arg1);
                    break;
                case 12:
                    Y0(message.arg1 != 0);
                    break;
                case 13:
                    K0(message.arg1 != 0, (AtomicBoolean) message.obj);
                    break;
                case 14:
                    F0((w) message.obj);
                    break;
                case 15:
                    H0((w) message.obj);
                    break;
                case 16:
                    J((u) message.obj, false);
                    break;
                case 17:
                    M0((b) message.obj);
                    break;
                case 18:
                    k((b) message.obj, message.arg1);
                    break;
                case 19:
                    c0((c) message.obj);
                    break;
                case 20:
                    m0(message.arg1, message.arg2, (ga5) message.obj);
                    break;
                case 21:
                    Z0((ga5) message.obj);
                    break;
                case 22:
                    b0();
                    break;
                case 23:
                    P0(message.arg1 != 0);
                    break;
                case 24:
                    O0(message.arg1 == 1);
                    break;
                case 25:
                    l();
                    break;
                case 26:
                    p0();
                    break;
                default:
                    return false;
            }
        } catch (ExoPlaybackException e2) {
            e = e2;
            if (e.type == 1 && (jk3VarS = this.s.s()) != null) {
                e = e.copyWithMediaPeriodId(jk3VarS.f.f19020a);
            }
            if (e.isRecoverable && this.P == null) {
                y53.j("ExoPlayerImplInternal", "Recoverable renderer error", e);
                this.P = e;
                mg2 mg2Var = this.h;
                mg2Var.a(mg2Var.obtainMessage(25, e));
            } else {
                ExoPlaybackException exoPlaybackException = this.P;
                if (exoPlaybackException != null) {
                    exoPlaybackException.addSuppressed(e);
                    e = this.P;
                }
                y53.d("ExoPlayerImplInternal", "Playback error", e);
                if (e.type == 1 && this.s.r() != this.s.s()) {
                    while (this.s.r() != this.s.s()) {
                        this.s.b();
                    }
                    lk3 lk3Var = ((jk3) vh.e(this.s.r())).f;
                    i.b bVar = lk3Var.f19020a;
                    long j = lk3Var.b;
                    this.x = K(bVar, j, lk3Var.c, j, true, 0);
                }
                i1(true, false);
                this.x = this.x.f(e);
            }
        } catch (ParserException e3) {
            int i = e3.dataType;
            if (i == 1) {
                i = e3.contentIsMalformed ? 3001 : 3003;
            } else if (i == 4) {
                i = e3.contentIsMalformed ? 3002 : 3004;
            }
            E(e3, i);
        } catch (DrmSession.DrmSessionException e4) {
            E(e4, e4.errorCode);
        } catch (BehindLiveWindowException e5) {
            E(e5, 1002);
        } catch (DataSourceException e6) {
            E(e6, e6.reason);
        } catch (IOException e7) {
            E(e7, 2000);
        } catch (RuntimeException e8) {
            ExoPlaybackException exoPlaybackExceptionCreateForUnexpected = ExoPlaybackException.createForUnexpected(e8, ((e8 instanceof IllegalStateException) || (e8 instanceof IllegalArgumentException)) ? 1004 : 1000);
            y53.d("ExoPlayerImplInternal", "Playback error", exoPlaybackExceptionCreateForUnexpected);
            i1(true, false);
            this.x = this.x.f(exoPlaybackExceptionCreateForUnexpected);
        }
        V();
        return true;
    }

    public final void i0() {
        this.y.b(1);
        q0(false, false, false, true);
        this.f.onPrepared();
        a1(this.x.f18178a.u() ? 4 : 2);
        this.t.x(this.g.getTransferListener());
        this.h.sendEmptyMessage(2);
    }

    public final void i1(boolean z, boolean z2) {
        q0(z || !this.H, false, true, false);
        this.y.b(z2 ? 1 : 0);
        this.f.onStopped();
        a1(1);
    }

    public synchronized boolean j0() {
        if (!this.z && this.j.getThread().isAlive()) {
            this.h.sendEmptyMessage(7);
            q1(new qo5() { // from class: gr1
                @Override // defpackage.qo5
                /* JADX INFO: renamed from: get */
                public final Object get2() {
                    return this.f17775a.S();
                }
            }, this.v);
            return this.z;
        }
        return true;
    }

    public final void j1() throws ExoPlaybackException {
        this.o.g();
        for (z zVar : this.f5884a) {
            if (P(zVar)) {
                s(zVar);
            }
        }
    }

    public final void k(b bVar, int i) throws Throwable {
        this.y.b(1);
        s sVar = this.t;
        if (i == -1) {
            i = sVar.r();
        }
        G(sVar.f(i, bVar.f5886a, bVar.b), false);
    }

    public final void k0() {
        q0(true, false, true, false);
        l0();
        this.f.onReleased();
        a1(1);
        HandlerThread handlerThread = this.i;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        synchronized (this) {
            this.z = true;
            notifyAll();
        }
    }

    public final void k1() {
        jk3 jk3VarL = this.s.l();
        boolean z = this.E || (jk3VarL != null && jk3VarL.f18425a.isLoading());
        ij4 ij4Var = this.x;
        if (z != ij4Var.g) {
            this.x = ij4Var.b(z);
        }
    }

    public final void l() throws ExoPlaybackException {
        p0();
    }

    public final void l0() {
        for (int i = 0; i < this.f5884a.length; i++) {
            this.c[i].clearListener();
            this.f5884a[i].release();
        }
    }

    public final void l1(i.b bVar, vz5 vz5Var, p06 p06Var) {
        this.f.a(this.x.f18178a, bVar, this.f5884a, vz5Var, p06Var.c);
    }

    public final void m(w wVar) throws ExoPlaybackException {
        if (wVar.j()) {
            return;
        }
        try {
            wVar.g().handleMessage(wVar.i(), wVar.e());
        } finally {
            wVar.k(true);
        }
    }

    public final void m0(int i, int i2, ga5 ga5Var) throws Throwable {
        this.y.b(1);
        G(this.t.B(i, i2, ga5Var), false);
    }

    public final void m1() throws ExoPlaybackException {
        if (this.x.f18178a.u() || !this.t.t()) {
            return;
        }
        X();
        Z();
        a0();
        Y();
    }

    public final void n(z zVar) throws ExoPlaybackException {
        if (P(zVar)) {
            this.o.a(zVar);
            s(zVar);
            zVar.disable();
            this.K--;
        }
    }

    public final boolean n0() throws ExoPlaybackException {
        jk3 jk3VarS = this.s.s();
        p06 p06VarO = jk3VarS.o();
        int i = 0;
        boolean z = false;
        while (true) {
            z[] zVarArr = this.f5884a;
            if (i >= zVarArr.length) {
                return !z;
            }
            z zVar = zVarArr[i];
            if (P(zVar)) {
                boolean z2 = zVar.getStream() != jk3VarS.c[i];
                if (!p06VarO.c(i) || z2) {
                    if (!zVar.isCurrentStreamFinal()) {
                        zVar.c(w(p06VarO.c[i]), jk3VarS.c[i], jk3VarS.m(), jk3VarS.l());
                    } else if (zVar.isEnded()) {
                        n(zVar);
                    } else {
                        z = true;
                    }
                }
            }
            i++;
        }
    }

    public final void n1() throws ExoPlaybackException {
        jk3 jk3VarR = this.s.r();
        if (jk3VarR == null) {
            return;
        }
        long discontinuity = jk3VarR.d ? jk3VarR.f18425a.readDiscontinuity() : -9223372036854775807L;
        if (discontinuity != -9223372036854775807L) {
            s0(discontinuity);
            if (discontinuity != this.x.r) {
                ij4 ij4Var = this.x;
                this.x = K(ij4Var.b, discontinuity, ij4Var.c, discontinuity, true, 5);
            }
        } else {
            long jH = this.o.h(jk3VarR != this.s.s());
            this.M = jH;
            long jY = jk3VarR.y(jH);
            W(this.x.r, jY);
            this.x.o(jY);
        }
        this.x.p = this.s.l().i();
        this.x.q = B();
        ij4 ij4Var2 = this.x;
        if (ij4Var2.l && ij4Var2.e == 3 && f1(ij4Var2.f18178a, ij4Var2.b) && this.x.n.f5989a == 1.0f) {
            float adjustedPlaybackSpeed = this.u.getAdjustedPlaybackSpeed(v(), B());
            if (this.o.getPlaybackParameters().f5989a != adjustedPlaybackSpeed) {
                L0(this.x.n.d(adjustedPlaybackSpeed));
                I(this.x.n, this.o.getPlaybackParameters().f5989a, false, false);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x017e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void o() throws ExoPlaybackException, IOException {
        boolean z;
        boolean z2;
        boolean z3;
        int i;
        long jUptimeMillis = this.q.uptimeMillis();
        this.h.removeMessages(2);
        m1();
        int i2 = this.x.e;
        if (i2 == 1 || i2 == 4) {
            return;
        }
        jk3 jk3VarR = this.s.r();
        if (jk3VarR == null) {
            z0(jUptimeMillis, 10L);
            return;
        }
        hz5.a("doSomeWork");
        n1();
        if (jk3VarR.d) {
            long jElapsedRealtime = SystemClock.elapsedRealtime() * 1000;
            jk3VarR.f18425a.discardBuffer(this.x.r - this.m, this.n);
            int i3 = 0;
            z = true;
            z2 = true;
            while (true) {
                z[] zVarArr = this.f5884a;
                if (i3 >= zVarArr.length) {
                    break;
                }
                z zVar = zVarArr[i3];
                if (P(zVar)) {
                    zVar.render(this.M, jElapsedRealtime);
                    z = z && zVar.isEnded();
                    boolean z4 = jk3VarR.c[i3] != zVar.getStream();
                    boolean z5 = z4 || (!z4 && zVar.hasReadStreamToEnd()) || zVar.isReady() || zVar.isEnded();
                    z2 = z2 && z5;
                    if (!z5) {
                        zVar.maybeThrowStreamError();
                    }
                }
                i3++;
            }
        } else {
            jk3VarR.f18425a.maybeThrowPrepareError();
            z = true;
            z2 = true;
        }
        long j = jk3VarR.f.e;
        boolean z6 = z && jk3VarR.d && (j == -9223372036854775807L || j <= this.x.r);
        if (z6 && this.B) {
            this.B = false;
            R0(false, this.x.m, false, 5);
        }
        if (z6 && jk3VarR.f.i) {
            a1(4);
            j1();
        } else if (this.x.e == 2 && e1(z2)) {
            a1(3);
            this.P = null;
            if (d1()) {
                g1();
            }
        } else if (this.x.e == 3 && (this.K != 0 ? !z2 : !Q())) {
            this.C = d1();
            a1(2);
            if (this.C) {
                f0();
                this.u.notifyRebuffer();
            }
            j1();
        }
        if (this.x.e == 2) {
            int i4 = 0;
            while (true) {
                z[] zVarArr2 = this.f5884a;
                if (i4 >= zVarArr2.length) {
                    break;
                }
                if (P(zVarArr2[i4]) && this.f5884a[i4].getStream() == jk3VarR.c[i4]) {
                    this.f5884a[i4].maybeThrowStreamError();
                }
                i4++;
            }
            ij4 ij4Var = this.x;
            z3 = !ij4Var.g && ij4Var.q < 500000 && O();
        }
        if (!z3) {
            this.R = -9223372036854775807L;
        } else if (this.R == -9223372036854775807L) {
            this.R = this.q.elapsedRealtime();
        } else if (this.q.elapsedRealtime() - this.R >= 4000) {
            throw new IllegalStateException("Playback stuck buffering and not loading");
        }
        boolean z7 = d1() && this.x.e == 3;
        boolean z8 = this.J && this.I && z7;
        ij4 ij4Var2 = this.x;
        if (ij4Var2.o != z8) {
            this.x = ij4Var2.i(z8);
        }
        this.I = false;
        if (!z8 && (i = this.x.e) != 4) {
            if (z7 || i == 2) {
                z0(jUptimeMillis, 10L);
            } else if (i == 3 && this.K != 0) {
                z0(jUptimeMillis, 1000L);
            }
        }
        hz5.c();
    }

    public final void o0() throws ExoPlaybackException {
        float f2 = this.o.getPlaybackParameters().f5989a;
        jk3 jk3VarS = this.s.s();
        boolean z = true;
        for (jk3 jk3VarR = this.s.r(); jk3VarR != null && jk3VarR.d; jk3VarR = jk3VarR.j()) {
            p06 p06VarV = jk3VarR.v(f2, this.x.f18178a);
            if (!p06VarV.a(jk3VarR.o())) {
                if (z) {
                    jk3 jk3VarR2 = this.s.r();
                    boolean zD = this.s.D(jk3VarR2);
                    boolean[] zArr = new boolean[this.f5884a.length];
                    long jB = jk3VarR2.b(p06VarV, this.x.r, zD, zArr);
                    ij4 ij4Var = this.x;
                    boolean z2 = (ij4Var.e == 4 || jB == ij4Var.r) ? false : true;
                    ij4 ij4Var2 = this.x;
                    this.x = K(ij4Var2.b, jB, ij4Var2.c, ij4Var2.d, z2, 5);
                    if (z2) {
                        s0(jB);
                    }
                    boolean[] zArr2 = new boolean[this.f5884a.length];
                    int i = 0;
                    while (true) {
                        z[] zVarArr = this.f5884a;
                        if (i >= zVarArr.length) {
                            break;
                        }
                        z zVar = zVarArr[i];
                        boolean zP = P(zVar);
                        zArr2[i] = zP;
                        d25 d25Var = jk3VarR2.c[i];
                        if (zP) {
                            if (d25Var != zVar.getStream()) {
                                n(zVar);
                            } else if (zArr[i]) {
                                zVar.resetPosition(this.M);
                            }
                        }
                        i++;
                    }
                    r(zArr2);
                } else {
                    this.s.D(jk3VarR);
                    if (jk3VarR.d) {
                        jk3VarR.a(p06VarV, Math.max(jk3VarR.f.b, jk3VarR.y(this.M)), false);
                    }
                }
                F(true);
                if (this.x.e != 4) {
                    U();
                    n1();
                    this.h.sendEmptyMessage(2);
                    return;
                }
                return;
            }
            if (jk3VarR == jk3VarS) {
                z = false;
            }
        }
    }

    public final void o1(e0 e0Var, i.b bVar, e0 e0Var2, i.b bVar2, long j, boolean z) throws ExoPlaybackException {
        if (!f1(e0Var, bVar)) {
            u uVar = bVar.b() ? u.d : this.x.n;
            if (this.o.getPlaybackParameters().equals(uVar)) {
                return;
            }
            L0(uVar);
            I(this.x.n, uVar.f5989a, false, false);
            return;
        }
        e0Var.r(e0Var.l(bVar.f18710a, this.l).c, this.k);
        this.u.a((p.g) g86.j(this.k.k));
        if (j != -9223372036854775807L) {
            this.u.setTargetLiveOffsetOverrideUs(x(e0Var, bVar.f18710a, j));
            return;
        }
        if (!g86.c(!e0Var2.u() ? e0Var2.r(e0Var2.l(bVar2.f18710a, this.l).c, this.k).f5871a : null, this.k.f5871a) || z) {
            this.u.setTargetLiveOffsetOverrideUs(-9223372036854775807L);
        }
    }

    @Override // com.google.android.exoplayer2.s.d
    public void onPlaylistUpdateRequested() {
        this.h.sendEmptyMessage(22);
    }

    @Override // o06.a
    public void onTrackSelectionsInvalidated() {
        this.h.sendEmptyMessage(10);
    }

    public final void p(int i, boolean z) throws ExoPlaybackException {
        z zVar = this.f5884a[i];
        if (P(zVar)) {
            return;
        }
        jk3 jk3VarS = this.s.s();
        boolean z2 = jk3VarS == this.s.r();
        p06 p06VarO = jk3VarS.o();
        tv4 tv4Var = p06VarO.b[i];
        m[] mVarArrW = w(p06VarO.c[i]);
        boolean z3 = d1() && this.x.e == 3;
        boolean z4 = !z && z3;
        this.K++;
        this.b.add(zVar);
        zVar.f(tv4Var, mVarArrW, jk3VarS.c[i], this.M, z4, z2, jk3VarS.m(), jk3VarS.l());
        zVar.handleMessage(11, new a());
        this.o.c(zVar);
        if (z3) {
            zVar.start();
        }
    }

    public final void p0() throws ExoPlaybackException {
        o0();
        B0(true);
    }

    public final void p1(float f2) {
        for (jk3 jk3VarR = this.s.r(); jk3VarR != null; jk3VarR = jk3VarR.j()) {
            for (or1 or1Var : jk3VarR.o().c) {
                if (or1Var != null) {
                    or1Var.onPlaybackSpeed(f2);
                }
            }
        }
    }

    public final void q() throws ExoPlaybackException {
        r(new boolean[this.f5884a.length]);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00a5 A[PHI: r4 r5 r7
      0x00a5: PHI (r4v3 com.google.android.exoplayer2.source.i$b) = (r4v2 com.google.android.exoplayer2.source.i$b), (r4v7 com.google.android.exoplayer2.source.i$b) binds: [B:30:0x0079, B:32:0x009e] A[DONT_GENERATE, DONT_INLINE]
      0x00a5: PHI (r5v2 long) = (r5v1 long), (r5v15 long) binds: [B:30:0x0079, B:32:0x009e] A[DONT_GENERATE, DONT_INLINE]
      0x00a5: PHI (r7v3 long) = (r7v2 long), (r7v5 long) binds: [B:30:0x0079, B:32:0x009e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ef A[PHI: r3
      0x00ef: PHI (r3v3 com.google.android.exoplayer2.e0) = 
      (r3v2 com.google.android.exoplayer2.e0)
      (r3v2 com.google.android.exoplayer2.e0)
      (r3v6 com.google.android.exoplayer2.e0)
      (r3v6 com.google.android.exoplayer2.e0)
     binds: [B:36:0x00b4, B:38:0x00b8, B:40:0x00c9, B:42:0x00e0] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void q0(boolean z, boolean z2, boolean z3, boolean z4) {
        long j;
        long j2;
        boolean z5;
        e0 e0Var;
        i.b bVar;
        this.h.removeMessages(2);
        this.P = null;
        this.C = false;
        this.o.g();
        this.M = MediaPeriodQueue.INITIAL_RENDERER_POSITION_OFFSET_US;
        for (z zVar : this.f5884a) {
            try {
                n(zVar);
            } catch (ExoPlaybackException | RuntimeException e2) {
                y53.d("ExoPlayerImplInternal", "Disable failed.", e2);
            }
        }
        if (z) {
            for (z zVar2 : this.f5884a) {
                if (this.b.remove(zVar2)) {
                    try {
                        zVar2.reset();
                    } catch (RuntimeException e3) {
                        y53.d("ExoPlayerImplInternal", "Reset failed.", e3);
                    }
                }
            }
        }
        this.K = 0;
        ij4 ij4Var = this.x;
        i.b bVar2 = ij4Var.b;
        long jLongValue = ij4Var.r;
        long j3 = (this.x.b.b() || R(this.x, this.l)) ? this.x.c : this.x.r;
        if (z2) {
            this.L = null;
            Pair<i.b, Long> pairZ = z(this.x.f18178a);
            bVar2 = (i.b) pairZ.first;
            jLongValue = ((Long) pairZ.second).longValue();
            j3 = -9223372036854775807L;
            if (bVar2.equals(this.x.b)) {
                j = jLongValue;
                j2 = j3;
                z5 = false;
            } else {
                z5 = true;
                j = jLongValue;
                j2 = -9223372036854775807L;
            }
        }
        this.s.f();
        this.E = false;
        e0 e0VarI = this.x.f18178a;
        if (z3 && (e0VarI instanceof x)) {
            e0VarI = ((x) e0VarI).I(this.t.q());
            if (bVar2.b != -1) {
                e0VarI.l(bVar2.f18710a, this.l);
                if (e0VarI.r(this.l.c, this.k).h()) {
                    e0Var = e0VarI;
                    bVar = new i.b(bVar2.f18710a, bVar2.d);
                }
            }
        } else {
            e0Var = e0VarI;
            bVar = bVar2;
        }
        ij4 ij4Var2 = this.x;
        int i = ij4Var2.e;
        ExoPlaybackException exoPlaybackException = z4 ? null : ij4Var2.f;
        vz5 vz5Var = z5 ? vz5.d : ij4Var2.h;
        p06 p06Var = z5 ? this.e : ij4Var2.i;
        List listOf = z5 ? ImmutableList.of() : ij4Var2.j;
        ij4 ij4Var3 = this.x;
        this.x = new ij4(e0Var, bVar, j2, j, i, exoPlaybackException, false, vz5Var, p06Var, listOf, bVar, ij4Var3.l, ij4Var3.m, ij4Var3.n, j, 0L, j, 0L, false);
        if (z3) {
            this.t.z();
        }
    }

    public final synchronized void q1(qo5<Boolean> qo5Var, long j) {
        long jElapsedRealtime = this.q.elapsedRealtime() + j;
        boolean z = false;
        while (!qo5Var.get2().booleanValue() && j > 0) {
            try {
                this.q.onThreadBlocked();
                wait(j);
            } catch (InterruptedException unused) {
                z = true;
            }
            j = jElapsedRealtime - this.q.elapsedRealtime();
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    public final void r(boolean[] zArr) throws ExoPlaybackException {
        jk3 jk3VarS = this.s.s();
        p06 p06VarO = jk3VarS.o();
        for (int i = 0; i < this.f5884a.length; i++) {
            if (!p06VarO.c(i) && this.b.remove(this.f5884a[i])) {
                this.f5884a[i].reset();
            }
        }
        for (int i2 = 0; i2 < this.f5884a.length; i2++) {
            if (p06VarO.c(i2)) {
                p(i2, zArr[i2]);
            }
        }
        jk3VarS.g = true;
    }

    public final void r0() {
        jk3 jk3VarR = this.s.r();
        this.B = jk3VarR != null && jk3VarR.f.h && this.A;
    }

    public final void s(z zVar) {
        if (zVar.getState() == 2) {
            zVar.stop();
        }
    }

    public final void s0(long j) throws ExoPlaybackException {
        jk3 jk3VarR = this.s.r();
        long jZ = jk3VarR == null ? j + MediaPeriodQueue.INITIAL_RENDERER_POSITION_OFFSET_US : jk3VarR.z(j);
        this.M = jZ;
        this.o.d(jZ);
        for (z zVar : this.f5884a) {
            if (P(zVar)) {
                zVar.resetPosition(this.M);
            }
        }
        d0();
    }

    public void t(long j) {
        this.Q = j;
    }

    public final ImmutableList<Metadata> u(or1[] or1VarArr) {
        ImmutableList.a aVar = new ImmutableList.a();
        boolean z = false;
        for (or1 or1Var : or1VarArr) {
            if (or1Var != null) {
                Metadata metadata = or1Var.getFormat(0).j;
                if (metadata == null) {
                    aVar.a(new Metadata(new Metadata.Entry[0]));
                } else {
                    aVar.a(metadata);
                    z = true;
                }
            }
        }
        return z ? aVar.e() : ImmutableList.of();
    }

    public final long v() {
        ij4 ij4Var = this.x;
        return x(ij4Var.f18178a, ij4Var.b.f18710a, ij4Var.r);
    }

    public final void v0(e0 e0Var, e0 e0Var2) {
        if (e0Var.u() && e0Var2.u()) {
            return;
        }
        for (int size = this.p.size() - 1; size >= 0; size--) {
            if (!u0(this.p.get(size), e0Var, e0Var2, this.F, this.G, this.k, this.l)) {
                this.p.get(size).f5888a.k(false);
                this.p.remove(size);
            }
        }
        Collections.sort(this.p);
    }

    public final long x(e0 e0Var, Object obj, long j) {
        e0Var.r(e0Var.l(obj, this.l).c, this.k);
        e0.d dVar = this.k;
        if (dVar.f != -9223372036854775807L && dVar.h()) {
            e0.d dVar2 = this.k;
            if (dVar2.i) {
                return g86.H0(dVar2.c() - this.k.f) - (j + this.l.q());
            }
        }
        return -9223372036854775807L;
    }

    public final long y() {
        jk3 jk3VarS = this.s.s();
        if (jk3VarS == null) {
            return 0L;
        }
        long jL = jk3VarS.l();
        if (!jk3VarS.d) {
            return jL;
        }
        int i = 0;
        while (true) {
            z[] zVarArr = this.f5884a;
            if (i >= zVarArr.length) {
                return jL;
            }
            if (P(zVarArr[i]) && this.f5884a[i].getStream() == jk3VarS.c[i]) {
                long readingPositionUs = this.f5884a[i].getReadingPositionUs();
                if (readingPositionUs == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                jL = Math.max(readingPositionUs, jL);
            }
            i++;
        }
    }

    public final Pair<i.b, Long> z(e0 e0Var) {
        if (e0Var.u()) {
            return Pair.create(ij4.l(), 0L);
        }
        Pair<Object, Long> pairN = e0Var.n(this.k, this.l, e0Var.e(this.G), -9223372036854775807L);
        i.b bVarF = this.s.F(e0Var, pairN.first, 0L);
        long jLongValue = ((Long) pairN.second).longValue();
        if (bVarF.b()) {
            e0Var.l(bVarF.f18710a, this.l);
            jLongValue = bVarF.c == this.l.n(bVarF.b) ? this.l.j() : 0L;
        }
        return Pair.create(bVarF, Long.valueOf(jLongValue));
    }

    public final void z0(long j, long j2) {
        this.h.sendEmptyMessageAtTime(2, j + j2);
    }
}
