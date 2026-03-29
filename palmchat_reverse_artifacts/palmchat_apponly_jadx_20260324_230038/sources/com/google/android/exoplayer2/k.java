package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.AudioTrack;
import android.media.MediaFormat;
import android.media.metrics.LogSessionId;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.b;
import com.google.android.exoplayer2.c;
import com.google.android.exoplayer2.c0;
import com.google.android.exoplayer2.e0;
import com.google.android.exoplayer2.i;
import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.k;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.s;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.v;
import com.google.android.exoplayer2.video.spherical.SphericalGLSurfaceView;
import com.google.android.exoplayer2.w;
import com.google.common.collect.ImmutableList;
import defpackage.bi6;
import defpackage.bk4;
import defpackage.db6;
import defpackage.dl6;
import defpackage.dp;
import defpackage.ed0;
import defpackage.g86;
import defpackage.ga5;
import defpackage.gd6;
import defpackage.gv5;
import defpackage.hm3;
import defpackage.ij4;
import defpackage.jr1;
import defpackage.k06;
import defpackage.kc;
import defpackage.lk;
import defpackage.lw0;
import defpackage.mg2;
import defpackage.ml0;
import defpackage.ne5;
import defpackage.o06;
import defpackage.oc;
import defpackage.oe6;
import defpackage.or1;
import defpackage.ow0;
import defpackage.p06;
import defpackage.po1;
import defpackage.pr0;
import defpackage.qx1;
import defpackage.ry;
import defpackage.te6;
import defpackage.to3;
import defpackage.tv4;
import defpackage.uj3;
import defpackage.vh;
import defpackage.vz5;
import defpackage.w45;
import defpackage.xr0;
import defpackage.y53;
import defpackage.yb6;
import defpackage.z33;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class k extends com.google.android.exoplayer2.d implements j {
    public final com.google.android.exoplayer2.c A;

    @Nullable
    public final c0 B;
    public final bi6 C;
    public final dl6 D;
    public final long E;
    public int F;
    public boolean G;
    public int H;
    public int I;
    public boolean J;
    public int K;
    public w45 L;
    public ga5 M;
    public boolean N;
    public v.b O;
    public q P;
    public q Q;

    @Nullable
    public m R;

    @Nullable
    public m S;

    @Nullable
    public AudioTrack T;

    @Nullable
    public Object U;

    @Nullable
    public Surface V;

    @Nullable
    public SurfaceHolder W;

    @Nullable
    public SphericalGLSurfaceView X;
    public boolean Y;

    @Nullable
    public TextureView Z;
    public int a0;
    public final p06 b;
    public int b0;
    public final v.b c;
    public ne5 c0;
    public final ml0 d;

    @Nullable
    public lw0 d0;
    public final Context e;

    @Nullable
    public lw0 e0;
    public final v f;
    public int f0;
    public final z[] g;
    public com.google.android.exoplayer2.audio.a g0;
    public final o06 h;
    public float h0;
    public final mg2 i;
    public boolean i0;
    public final l.f j;
    public xr0 j0;
    public final l k;
    public boolean k0;
    public final z33<v.d> l;
    public boolean l0;
    public final CopyOnWriteArraySet<j.a> m;

    @Nullable
    public PriorityTaskManager m0;
    public final e0.b n;
    public boolean n0;
    public final List<e> o;
    public boolean o0;
    public final boolean p;
    public i p0;
    public final i.a q;
    public te6 q0;
    public final kc r;
    public q r0;
    public final Looper s;
    public ij4 s0;
    public final dp t;
    public int t0;
    public final long u;
    public int u0;
    public final long v;
    public long v0;
    public final ed0 w;
    public final c x;
    public final d y;
    public final com.google.android.exoplayer2.b z;

    /* JADX INFO: compiled from: SearchBox */
    @RequiresApi(31)
    public static final class b {
        @DoNotInline
        public static bk4 a(Context context, k kVar, boolean z) {
            uj3 uj3VarW0 = uj3.w0(context);
            if (uj3VarW0 == null) {
                y53.i("ExoPlayerImpl", "MediaMetricsService unavailable.");
                return new bk4(LogSessionId.LOG_SESSION_ID_NONE);
            }
            if (z) {
                kVar.q0(uj3VarW0);
            }
            return new bk4(uj3VarW0.D0());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class d implements yb6, ry, w.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public yb6 f5882a;

        @Nullable
        public ry b;

        @Nullable
        public yb6 c;

        @Nullable
        public ry d;

        public d() {
        }

        @Override // defpackage.yb6
        public void a(long j, long j2, m mVar, @Nullable MediaFormat mediaFormat) {
            yb6 yb6Var = this.c;
            if (yb6Var != null) {
                yb6Var.a(j, j2, mVar, mediaFormat);
            }
            yb6 yb6Var2 = this.f5882a;
            if (yb6Var2 != null) {
                yb6Var2.a(j, j2, mVar, mediaFormat);
            }
        }

        @Override // com.google.android.exoplayer2.w.b
        public void handleMessage(int i, @Nullable Object obj) {
            if (i == 7) {
                this.f5882a = (yb6) obj;
                return;
            }
            if (i == 8) {
                this.b = (ry) obj;
                return;
            }
            if (i != 10000) {
                return;
            }
            SphericalGLSurfaceView sphericalGLSurfaceView = (SphericalGLSurfaceView) obj;
            if (sphericalGLSurfaceView == null) {
                this.c = null;
                this.d = null;
            } else {
                this.c = sphericalGLSurfaceView.getVideoFrameMetadataListener();
                this.d = sphericalGLSurfaceView.getCameraMotionListener();
            }
        }

        @Override // defpackage.ry
        public void onCameraMotion(long j, float[] fArr) {
            ry ryVar = this.d;
            if (ryVar != null) {
                ryVar.onCameraMotion(j, fArr);
            }
            ry ryVar2 = this.b;
            if (ryVar2 != null) {
                ryVar2.onCameraMotion(j, fArr);
            }
        }

        @Override // defpackage.ry
        public void onCameraMotionReset() {
            ry ryVar = this.d;
            if (ryVar != null) {
                ryVar.onCameraMotionReset();
            }
            ry ryVar2 = this.b;
            if (ryVar2 != null) {
                ryVar2.onCameraMotionReset();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class e implements hm3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f5883a;
        public e0 b;

        public e(Object obj, e0 e0Var) {
            this.f5883a = obj;
            this.b = e0Var;
        }

        @Override // defpackage.hm3
        public e0 getTimeline() {
            return this.b;
        }

        @Override // defpackage.hm3
        public Object getUid() {
            return this.f5883a;
        }
    }

    static {
        jr1.a("goog.exo.exoplayer");
    }

    @SuppressLint({"HandlerLeak"})
    public k(j.b bVar, @Nullable v vVar) {
        ml0 ml0Var = new ml0();
        this.d = ml0Var;
        try {
            y53.f("ExoPlayerImpl", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.19.1] [" + g86.e + "]");
            Context applicationContext = bVar.f5880a.getApplicationContext();
            this.e = applicationContext;
            kc kcVarApply = bVar.i.apply(bVar.b);
            this.r = kcVarApply;
            this.m0 = bVar.k;
            this.g0 = bVar.l;
            this.a0 = bVar.r;
            this.b0 = bVar.s;
            this.i0 = bVar.p;
            this.E = bVar.z;
            c cVar = new c();
            this.x = cVar;
            d dVar = new d();
            this.y = dVar;
            Handler handler = new Handler(bVar.j);
            z[] zVarArrA = bVar.d.get2().a(handler, cVar, cVar, cVar, cVar);
            this.g = zVarArrA;
            vh.g(zVarArrA.length > 0);
            o06 o06Var = bVar.f.get2();
            this.h = o06Var;
            this.q = bVar.e.get2();
            dp dpVar = bVar.h.get2();
            this.t = dpVar;
            this.p = bVar.t;
            this.L = bVar.u;
            this.u = bVar.v;
            this.v = bVar.w;
            this.N = bVar.A;
            Looper looper = bVar.j;
            this.s = looper;
            ed0 ed0Var = bVar.b;
            this.w = ed0Var;
            v vVar2 = vVar == null ? this : vVar;
            this.f = vVar2;
            this.l = new z33<>(looper, ed0Var, new z33.b() { // from class: jq1
                @Override // z33.b
                public final void a(Object obj, qx1 qx1Var) {
                    this.f18477a.N0((v.d) obj, qx1Var);
                }
            });
            this.m = new CopyOnWriteArraySet<>();
            this.o = new ArrayList();
            this.M = new ga5.a(0);
            p06 p06Var = new p06(new tv4[zVarArrA.length], new or1[zVarArrA.length], f0.b, null);
            this.b = p06Var;
            this.n = new e0.b();
            v.b bVarE = new v.b.a().c(1, 2, 3, 13, 14, 15, 16, 17, 18, 19, 31, 20, 30, 21, 22, 24, 27, 28, 32).d(29, o06Var.h()).d(23, bVar.q).d(25, bVar.q).d(33, bVar.q).d(26, bVar.q).d(34, bVar.q).e();
            this.c = bVarE;
            this.O = new v.b.a().b(bVarE).a(4).a(10).e();
            this.i = ed0Var.createHandler(looper, null);
            l.f fVar = new l.f() { // from class: oq1
                @Override // com.google.android.exoplayer2.l.f
                public final void a(l.e eVar) {
                    this.f19808a.P0(eVar);
                }
            };
            this.j = fVar;
            this.s0 = ij4.k(p06Var);
            kcVarApply.o(vVar2, looper);
            int i = g86.f17680a;
            l lVar = new l(zVarArrA, o06Var, p06Var, bVar.g.get2(), dpVar, this.F, this.G, kcVarApply, this.L, bVar.x, bVar.y, this.N, looper, ed0Var, fVar, i < 31 ? new bk4() : b.a(applicationContext, this, bVar.B), bVar.C);
            this.k = lVar;
            this.h0 = 1.0f;
            this.F = 0;
            q qVar = q.J;
            this.P = qVar;
            this.Q = qVar;
            this.r0 = qVar;
            this.t0 = -1;
            if (i < 21) {
                this.f0 = L0(0);
            } else {
                this.f0 = g86.F(applicationContext);
            }
            this.j0 = xr0.c;
            this.k0 = true;
            e(kcVarApply);
            dpVar.e(new Handler(looper), kcVarApply);
            r0(cVar);
            long j = bVar.c;
            if (j > 0) {
                lVar.t(j);
            }
            com.google.android.exoplayer2.b bVar2 = new com.google.android.exoplayer2.b(bVar.f5880a, handler, cVar);
            this.z = bVar2;
            bVar2.b(bVar.o);
            com.google.android.exoplayer2.c cVar2 = new com.google.android.exoplayer2.c(bVar.f5880a, handler, cVar);
            this.A = cVar2;
            cVar2.m(bVar.m ? this.g0 : null);
            if (bVar.q) {
                c0 c0Var = new c0(bVar.f5880a, handler, cVar);
                this.B = c0Var;
                c0Var.h(g86.h0(this.g0.c));
            } else {
                this.B = null;
            }
            bi6 bi6Var = new bi6(bVar.f5880a);
            this.C = bi6Var;
            bi6Var.a(bVar.n != 0);
            dl6 dl6Var = new dl6(bVar.f5880a);
            this.D = dl6Var;
            dl6Var.a(bVar.n == 2);
            this.p0 = w0(this.B);
            this.q0 = te6.e;
            this.c0 = ne5.c;
            o06Var.l(this.g0);
            q1(1, 10, Integer.valueOf(this.f0));
            q1(2, 10, Integer.valueOf(this.f0));
            q1(1, 3, this.g0);
            q1(2, 4, Integer.valueOf(this.a0));
            q1(2, 5, Integer.valueOf(this.b0));
            q1(1, 9, Boolean.valueOf(this.i0));
            q1(2, 7, dVar);
            q1(6, 8, dVar);
            ml0Var.e();
        } catch (Throwable th) {
            this.d.e();
            throw th;
        }
    }

    public static int F0(boolean z, int i) {
        return (!z || i == 1) ? 1 : 2;
    }

    public static long J0(ij4 ij4Var) {
        e0.d dVar = new e0.d();
        e0.b bVar = new e0.b();
        ij4Var.f18178a.l(ij4Var.b.f18710a, bVar);
        return ij4Var.c == -9223372036854775807L ? ij4Var.f18178a.r(bVar.c, dVar).e() : bVar.q() + ij4Var.c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N0(v.d dVar, qx1 qx1Var) {
        dVar.D(this.f, new v.c(qx1Var));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P0(final l.e eVar) {
        this.i.post(new Runnable() { // from class: lq1
            @Override // java.lang.Runnable
            public final void run() {
                this.f19054a.O0(eVar);
            }
        });
    }

    public static /* synthetic */ void Q0(v.d dVar) {
        dVar.s(ExoPlaybackException.createForUnexpected(new ExoTimeoutException(1), 1003));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V0(v.d dVar) {
        dVar.w(this.O);
    }

    public static /* synthetic */ void W0(ij4 ij4Var, int i, v.d dVar) {
        dVar.m(ij4Var.f18178a, i);
    }

    public static /* synthetic */ void X0(int i, v.e eVar, v.e eVar2, v.d dVar) {
        dVar.onPositionDiscontinuity(i);
        dVar.l(eVar, eVar2, i);
    }

    public static /* synthetic */ void Z0(ij4 ij4Var, v.d dVar) {
        dVar.p(ij4Var.f);
    }

    public static /* synthetic */ void a1(ij4 ij4Var, v.d dVar) {
        dVar.s(ij4Var.f);
    }

    public static /* synthetic */ void b1(ij4 ij4Var, v.d dVar) {
        dVar.B(ij4Var.i.d);
    }

    public static /* synthetic */ void d1(ij4 ij4Var, v.d dVar) {
        dVar.onLoadingChanged(ij4Var.g);
        dVar.onIsLoadingChanged(ij4Var.g);
    }

    public static /* synthetic */ void e1(ij4 ij4Var, v.d dVar) {
        dVar.onPlayerStateChanged(ij4Var.l, ij4Var.e);
    }

    public static /* synthetic */ void f1(ij4 ij4Var, v.d dVar) {
        dVar.onPlaybackStateChanged(ij4Var.e);
    }

    public static /* synthetic */ void g1(ij4 ij4Var, int i, v.d dVar) {
        dVar.onPlayWhenReadyChanged(ij4Var.l, i);
    }

    public static /* synthetic */ void h1(ij4 ij4Var, v.d dVar) {
        dVar.onPlaybackSuppressionReasonChanged(ij4Var.m);
    }

    public static /* synthetic */ void i1(ij4 ij4Var, v.d dVar) {
        dVar.onIsPlayingChanged(ij4Var.n());
    }

    public static /* synthetic */ void j1(ij4 ij4Var, v.d dVar) {
        dVar.g(ij4Var.n);
    }

    public static i w0(@Nullable c0 c0Var) {
        return new i.b(0).g(c0Var != null ? c0Var.d() : 0).f(c0Var != null ? c0Var.c() : 0).e();
    }

    public final Pair<Boolean, Integer> A0(ij4 ij4Var, ij4 ij4Var2, boolean z, int i, boolean z2, boolean z3) {
        e0 e0Var = ij4Var2.f18178a;
        e0 e0Var2 = ij4Var.f18178a;
        if (e0Var2.u() && e0Var.u()) {
            return new Pair<>(Boolean.FALSE, -1);
        }
        int i2 = 3;
        if (e0Var2.u() != e0Var.u()) {
            return new Pair<>(Boolean.TRUE, 3);
        }
        if (e0Var.r(e0Var.l(ij4Var2.b.f18710a, this.n).c, this.f5848a).f5871a.equals(e0Var2.r(e0Var2.l(ij4Var.b.f18710a, this.n).c, this.f5848a).f5871a)) {
            return (z && i == 0 && ij4Var2.b.d < ij4Var.b.d) ? new Pair<>(Boolean.TRUE, 0) : (z && i == 1 && z3) ? new Pair<>(Boolean.TRUE, 2) : new Pair<>(Boolean.FALSE, -1);
        }
        if (z && i == 0) {
            i2 = 1;
        } else if (z && i == 1) {
            i2 = 2;
        } else if (!z2) {
            throw new IllegalStateException();
        }
        return new Pair<>(Boolean.TRUE, Integer.valueOf(i2));
    }

    public final void A1(boolean z, int i, int i2) {
        int i3 = 0;
        boolean z2 = z && i != -1;
        if (z2 && i != 1) {
            i3 = 1;
        }
        ij4 ij4VarA = this.s0;
        if (ij4VarA.l == z2 && ij4VarA.m == i3) {
            return;
        }
        this.H++;
        if (ij4VarA.o) {
            ij4VarA = ij4VarA.a();
        }
        ij4 ij4VarE = ij4VarA.e(z2, i3);
        this.k.Q0(z2, i3);
        B1(ij4VarE, 0, i2, false, 5, -9223372036854775807L, -1, false);
    }

    public boolean B0() {
        E1();
        return this.s0.o;
    }

    public final void B1(final ij4 ij4Var, final int i, final int i2, boolean z, final int i3, long j, int i4, boolean z2) {
        ij4 ij4Var2 = this.s0;
        this.s0 = ij4Var;
        boolean z3 = !ij4Var2.f18178a.equals(ij4Var.f18178a);
        Pair<Boolean, Integer> pairA0 = A0(ij4Var, ij4Var2, z, i3, z3, z2);
        boolean zBooleanValue = ((Boolean) pairA0.first).booleanValue();
        final int iIntValue = ((Integer) pairA0.second).intValue();
        q qVarT0 = this.P;
        if (zBooleanValue) {
            pVar = ij4Var.f18178a.u() ? null : ij4Var.f18178a.r(ij4Var.f18178a.l(ij4Var.b.f18710a, this.n).c, this.f5848a).c;
            this.r0 = q.J;
        }
        if (zBooleanValue || !ij4Var2.j.equals(ij4Var.j)) {
            this.r0 = this.r0.b().L(ij4Var.j).H();
            qVarT0 = t0();
        }
        boolean z4 = !qVarT0.equals(this.P);
        this.P = qVarT0;
        boolean z5 = ij4Var2.l != ij4Var.l;
        boolean z6 = ij4Var2.e != ij4Var.e;
        if (z6 || z5) {
            D1();
        }
        boolean z7 = ij4Var2.g;
        boolean z8 = ij4Var.g;
        boolean z9 = z7 != z8;
        if (z9) {
            C1(z8);
        }
        if (z3) {
            this.l.i(0, new z33.a() { // from class: pq1
                @Override // z33.a
                public final void invoke(Object obj) {
                    k.W0(ij4Var, i, (v.d) obj);
                }
            });
        }
        if (z) {
            final v.e eVarI0 = I0(i3, ij4Var2, i4);
            final v.e eVarH0 = H0(j);
            this.l.i(11, new z33.a() { // from class: uq1
                @Override // z33.a
                public final void invoke(Object obj) {
                    k.X0(i3, eVarI0, eVarH0, (v.d) obj);
                }
            });
        }
        if (zBooleanValue) {
            this.l.i(1, new z33.a() { // from class: wq1
                @Override // z33.a
                public final void invoke(Object obj) {
                    ((v.d) obj).I(pVar, iIntValue);
                }
            });
        }
        if (ij4Var2.f != ij4Var.f) {
            this.l.i(10, new z33.a() { // from class: zp1
                @Override // z33.a
                public final void invoke(Object obj) {
                    k.Z0(ij4Var, (v.d) obj);
                }
            });
            if (ij4Var.f != null) {
                this.l.i(10, new z33.a() { // from class: aq1
                    @Override // z33.a
                    public final void invoke(Object obj) {
                        k.a1(ij4Var, (v.d) obj);
                    }
                });
            }
        }
        p06 p06Var = ij4Var2.i;
        p06 p06Var2 = ij4Var.i;
        if (p06Var != p06Var2) {
            this.h.i(p06Var2.e);
            this.l.i(2, new z33.a() { // from class: bq1
                @Override // z33.a
                public final void invoke(Object obj) {
                    k.b1(ij4Var, (v.d) obj);
                }
            });
        }
        if (z4) {
            final q qVar = this.P;
            this.l.i(14, new z33.a() { // from class: cq1
                @Override // z33.a
                public final void invoke(Object obj) {
                    ((v.d) obj).n(qVar);
                }
            });
        }
        if (z9) {
            this.l.i(3, new z33.a() { // from class: dq1
                @Override // z33.a
                public final void invoke(Object obj) {
                    k.d1(ij4Var, (v.d) obj);
                }
            });
        }
        if (z6 || z5) {
            this.l.i(-1, new z33.a() { // from class: eq1
                @Override // z33.a
                public final void invoke(Object obj) {
                    k.e1(ij4Var, (v.d) obj);
                }
            });
        }
        if (z6) {
            this.l.i(4, new z33.a() { // from class: fq1
                @Override // z33.a
                public final void invoke(Object obj) {
                    k.f1(ij4Var, (v.d) obj);
                }
            });
        }
        if (z5) {
            this.l.i(5, new z33.a() { // from class: qq1
                @Override // z33.a
                public final void invoke(Object obj) {
                    k.g1(ij4Var, i2, (v.d) obj);
                }
            });
        }
        if (ij4Var2.m != ij4Var.m) {
            this.l.i(6, new z33.a() { // from class: rq1
                @Override // z33.a
                public final void invoke(Object obj) {
                    k.h1(ij4Var, (v.d) obj);
                }
            });
        }
        if (ij4Var2.n() != ij4Var.n()) {
            this.l.i(7, new z33.a() { // from class: sq1
                @Override // z33.a
                public final void invoke(Object obj) {
                    k.i1(ij4Var, (v.d) obj);
                }
            });
        }
        if (!ij4Var2.n.equals(ij4Var.n)) {
            this.l.i(12, new z33.a() { // from class: tq1
                @Override // z33.a
                public final void invoke(Object obj) {
                    k.j1(ij4Var, (v.d) obj);
                }
            });
        }
        z1();
        this.l.f();
        if (ij4Var2.o != ij4Var.o) {
            Iterator<j.a> it = this.m.iterator();
            while (it.hasNext()) {
                it.next().onExperimentalSleepingForOffloadChanged(ij4Var.o);
            }
        }
    }

    public final long C0(ij4 ij4Var) {
        if (!ij4Var.b.b()) {
            return g86.m1(D0(ij4Var));
        }
        ij4Var.f18178a.l(ij4Var.b.f18710a, this.n);
        return ij4Var.c == -9223372036854775807L ? ij4Var.f18178a.r(E0(ij4Var), this.f5848a).d() : this.n.p() + g86.m1(ij4Var.c);
    }

    public final void C1(boolean z) {
        PriorityTaskManager priorityTaskManager = this.m0;
        if (priorityTaskManager != null) {
            if (z && !this.n0) {
                priorityTaskManager.a(0);
                this.n0 = true;
            } else {
                if (z || !this.n0) {
                    return;
                }
                priorityTaskManager.c(0);
                this.n0 = false;
            }
        }
    }

    public final long D0(ij4 ij4Var) {
        if (ij4Var.f18178a.u()) {
            return g86.H0(this.v0);
        }
        long jM = ij4Var.o ? ij4Var.m() : ij4Var.r;
        return ij4Var.b.b() ? jM : n1(ij4Var.f18178a, ij4Var.b, jM);
    }

    public final void D1() {
        int playbackState = getPlaybackState();
        if (playbackState != 1) {
            if (playbackState == 2 || playbackState == 3) {
                this.C.b(getPlayWhenReady() && !B0());
                this.D.b(getPlayWhenReady());
                return;
            } else if (playbackState != 4) {
                throw new IllegalStateException();
            }
        }
        this.C.b(false);
        this.D.b(false);
    }

    public final int E0(ij4 ij4Var) {
        return ij4Var.f18178a.u() ? this.t0 : ij4Var.f18178a.l(ij4Var.b.f18710a, this.n).c;
    }

    public final void E1() {
        this.d.b();
        if (Thread.currentThread() != getApplicationLooper().getThread()) {
            String strC = g86.C("Player is accessed on the wrong thread.\nCurrent thread: '%s'\nExpected thread: '%s'\nSee https://developer.android.com/guide/topics/media/issues/player-accessed-on-wrong-thread", Thread.currentThread().getName(), getApplicationLooper().getThread().getName());
            if (this.k0) {
                throw new IllegalStateException(strC);
            }
            y53.j("ExoPlayerImpl", strC, this.l0 ? null : new IllegalStateException());
            this.l0 = true;
        }
    }

    @Override // com.google.android.exoplayer2.v
    @Nullable
    /* JADX INFO: renamed from: G0, reason: merged with bridge method [inline-methods] */
    public ExoPlaybackException getPlayerError() {
        E1();
        return this.s0.f;
    }

    public final v.e H0(long j) {
        Object obj;
        p pVar;
        Object obj2;
        int iF;
        int currentMediaItemIndex = getCurrentMediaItemIndex();
        if (this.s0.f18178a.u()) {
            obj = null;
            pVar = null;
            obj2 = null;
            iF = -1;
        } else {
            ij4 ij4Var = this.s0;
            Object obj3 = ij4Var.b.f18710a;
            ij4Var.f18178a.l(obj3, this.n);
            iF = this.s0.f18178a.f(obj3);
            obj2 = obj3;
            obj = this.s0.f18178a.r(currentMediaItemIndex, this.f5848a).f5871a;
            pVar = this.f5848a.c;
        }
        long jM1 = g86.m1(j);
        long jM12 = this.s0.b.b() ? g86.m1(J0(this.s0)) : jM1;
        i.b bVar = this.s0.b;
        return new v.e(obj, currentMediaItemIndex, pVar, obj2, iF, jM1, jM12, bVar.b, bVar.c);
    }

    public final v.e I0(int i, ij4 ij4Var, int i2) {
        int i3;
        Object obj;
        p pVar;
        Object obj2;
        int i4;
        long jJ0;
        long jJ02;
        e0.b bVar = new e0.b();
        if (ij4Var.f18178a.u()) {
            i3 = i2;
            obj = null;
            pVar = null;
            obj2 = null;
            i4 = -1;
        } else {
            Object obj3 = ij4Var.b.f18710a;
            ij4Var.f18178a.l(obj3, bVar);
            int i5 = bVar.c;
            int iF = ij4Var.f18178a.f(obj3);
            Object obj4 = ij4Var.f18178a.r(i5, this.f5848a).f5871a;
            pVar = this.f5848a.c;
            obj2 = obj3;
            i4 = iF;
            obj = obj4;
            i3 = i5;
        }
        if (i == 0) {
            if (ij4Var.b.b()) {
                i.b bVar2 = ij4Var.b;
                jJ0 = bVar.e(bVar2.b, bVar2.c);
                jJ02 = J0(ij4Var);
            } else {
                jJ0 = ij4Var.b.e != -1 ? J0(this.s0) : bVar.e + bVar.d;
                jJ02 = jJ0;
            }
        } else if (ij4Var.b.b()) {
            jJ0 = ij4Var.r;
            jJ02 = J0(ij4Var);
        } else {
            jJ0 = bVar.e + ij4Var.r;
            jJ02 = jJ0;
        }
        long jM1 = g86.m1(jJ0);
        long jM12 = g86.m1(jJ02);
        i.b bVar3 = ij4Var.b;
        return new v.e(obj, i3, pVar, obj2, i4, jM1, jM12, bVar3.b, bVar3.c);
    }

    /* JADX INFO: renamed from: K0, reason: merged with bridge method [inline-methods] */
    public final void O0(l.e eVar) {
        long j;
        boolean z;
        long jN1;
        int i = this.H - eVar.c;
        this.H = i;
        boolean z2 = true;
        if (eVar.d) {
            this.I = eVar.e;
            this.J = true;
        }
        if (eVar.f) {
            this.K = eVar.g;
        }
        if (i == 0) {
            e0 e0Var = eVar.b.f18178a;
            if (!this.s0.f18178a.u() && e0Var.u()) {
                this.t0 = -1;
                this.v0 = 0L;
                this.u0 = 0;
            }
            if (!e0Var.u()) {
                List<e0> listJ = ((x) e0Var).J();
                vh.g(listJ.size() == this.o.size());
                for (int i2 = 0; i2 < listJ.size(); i2++) {
                    this.o.get(i2).b = listJ.get(i2);
                }
            }
            if (this.J) {
                if (eVar.b.b.equals(this.s0.b) && eVar.b.d == this.s0.r) {
                    z2 = false;
                }
                if (z2) {
                    if (e0Var.u() || eVar.b.b.b()) {
                        jN1 = eVar.b.d;
                    } else {
                        ij4 ij4Var = eVar.b;
                        jN1 = n1(e0Var, ij4Var.b, ij4Var.d);
                    }
                    j = jN1;
                } else {
                    j = -9223372036854775807L;
                }
                z = z2;
            } else {
                j = -9223372036854775807L;
                z = false;
            }
            this.J = false;
            B1(eVar.b, 1, this.K, z, this.I, j, -1, false);
        }
    }

    public final int L0(int i) {
        AudioTrack audioTrack = this.T;
        if (audioTrack != null && audioTrack.getAudioSessionId() != i) {
            this.T.release();
            this.T = null;
        }
        if (this.T == null) {
            this.T = new AudioTrack(3, 4000, 4, 2, 2, 0, i);
        }
        return this.T.getAudioSessionId();
    }

    @Override // com.google.android.exoplayer2.v
    public void a(v.d dVar) {
        E1();
        this.l.k((v.d) vh.e(dVar));
    }

    @Override // com.google.android.exoplayer2.v
    public void b(u uVar) {
        E1();
        if (uVar == null) {
            uVar = u.d;
        }
        if (this.s0.n.equals(uVar)) {
            return;
        }
        ij4 ij4VarG = this.s0.g(uVar);
        this.H++;
        this.k.S0(uVar);
        B1(ij4VarG, 0, 1, false, 5, -9223372036854775807L, -1, false);
    }

    @Override // com.google.android.exoplayer2.v
    public void c(final k06 k06Var) {
        E1();
        if (!this.h.h() || k06Var.equals(this.h.c())) {
            return;
        }
        this.h.m(k06Var);
        this.l.l(19, new z33.a() { // from class: nq1
            @Override // z33.a
            public final void invoke(Object obj) {
                ((v.d) obj).r(k06Var);
            }
        });
    }

    @Override // com.google.android.exoplayer2.v
    public void clearVideoSurfaceView(@Nullable SurfaceView surfaceView) {
        E1();
        v0(surfaceView == null ? null : surfaceView.getHolder());
    }

    @Override // com.google.android.exoplayer2.v
    public void clearVideoTextureView(@Nullable TextureView textureView) {
        E1();
        if (textureView == null || textureView != this.Z) {
            return;
        }
        u0();
    }

    @Override // com.google.android.exoplayer2.v
    public void e(v.d dVar) {
        this.l.c((v.d) vh.e(dVar));
    }

    @Override // com.google.android.exoplayer2.v
    public Looper getApplicationLooper() {
        return this.s;
    }

    @Override // com.google.android.exoplayer2.v
    public v.b getAvailableCommands() {
        E1();
        return this.O;
    }

    @Override // com.google.android.exoplayer2.v
    public long getContentBufferedPosition() {
        E1();
        if (this.s0.f18178a.u()) {
            return this.v0;
        }
        ij4 ij4Var = this.s0;
        if (ij4Var.k.d != ij4Var.b.d) {
            return ij4Var.f18178a.r(getCurrentMediaItemIndex(), this.f5848a).f();
        }
        long j = ij4Var.p;
        if (this.s0.k.b()) {
            ij4 ij4Var2 = this.s0;
            e0.b bVarL = ij4Var2.f18178a.l(ij4Var2.k.f18710a, this.n);
            long jI = bVarL.i(this.s0.k.b);
            j = jI == Long.MIN_VALUE ? bVarL.d : jI;
        }
        ij4 ij4Var3 = this.s0;
        return g86.m1(n1(ij4Var3.f18178a, ij4Var3.k, j));
    }

    @Override // com.google.android.exoplayer2.v
    public long getContentPosition() {
        E1();
        return C0(this.s0);
    }

    @Override // com.google.android.exoplayer2.v
    public int getCurrentAdGroupIndex() {
        E1();
        if (isPlayingAd()) {
            return this.s0.b.b;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.v
    public int getCurrentAdIndexInAdGroup() {
        E1();
        if (isPlayingAd()) {
            return this.s0.b.c;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.v
    public xr0 getCurrentCues() {
        E1();
        return this.j0;
    }

    @Override // com.google.android.exoplayer2.v
    public int getCurrentMediaItemIndex() {
        E1();
        int iE0 = E0(this.s0);
        if (iE0 == -1) {
            return 0;
        }
        return iE0;
    }

    @Override // com.google.android.exoplayer2.v
    public int getCurrentPeriodIndex() {
        E1();
        if (this.s0.f18178a.u()) {
            return this.u0;
        }
        ij4 ij4Var = this.s0;
        return ij4Var.f18178a.f(ij4Var.b.f18710a);
    }

    @Override // com.google.android.exoplayer2.v
    public long getCurrentPosition() {
        E1();
        return g86.m1(D0(this.s0));
    }

    @Override // com.google.android.exoplayer2.v
    public e0 getCurrentTimeline() {
        E1();
        return this.s0.f18178a;
    }

    @Override // com.google.android.exoplayer2.v
    public f0 getCurrentTracks() {
        E1();
        return this.s0.i.d;
    }

    @Override // com.google.android.exoplayer2.v
    public long getDuration() {
        E1();
        if (!isPlayingAd()) {
            return getContentDuration();
        }
        ij4 ij4Var = this.s0;
        i.b bVar = ij4Var.b;
        ij4Var.f18178a.l(bVar.f18710a, this.n);
        return g86.m1(this.n.e(bVar.b, bVar.c));
    }

    @Override // com.google.android.exoplayer2.v
    public long getMaxSeekToPreviousPosition() {
        E1();
        return 3000L;
    }

    @Override // com.google.android.exoplayer2.v
    public q getMediaMetadata() {
        E1();
        return this.P;
    }

    @Override // com.google.android.exoplayer2.v
    public boolean getPlayWhenReady() {
        E1();
        return this.s0.l;
    }

    @Override // com.google.android.exoplayer2.v
    public u getPlaybackParameters() {
        E1();
        return this.s0.n;
    }

    @Override // com.google.android.exoplayer2.v
    public int getPlaybackState() {
        E1();
        return this.s0.e;
    }

    @Override // com.google.android.exoplayer2.v
    public int getPlaybackSuppressionReason() {
        E1();
        return this.s0.m;
    }

    @Override // com.google.android.exoplayer2.v
    public int getRepeatMode() {
        E1();
        return this.F;
    }

    @Override // com.google.android.exoplayer2.v
    public long getSeekBackIncrement() {
        E1();
        return this.u;
    }

    @Override // com.google.android.exoplayer2.v
    public long getSeekForwardIncrement() {
        E1();
        return this.v;
    }

    @Override // com.google.android.exoplayer2.v
    public boolean getShuffleModeEnabled() {
        E1();
        return this.G;
    }

    @Override // com.google.android.exoplayer2.v
    public long getTotalBufferedDuration() {
        E1();
        return g86.m1(this.s0.q);
    }

    @Override // com.google.android.exoplayer2.v
    public k06 getTrackSelectionParameters() {
        E1();
        return this.h.c();
    }

    @Override // com.google.android.exoplayer2.v
    public te6 getVideoSize() {
        E1();
        return this.q0;
    }

    @Override // com.google.android.exoplayer2.v
    public boolean isPlayingAd() {
        E1();
        return this.s0.b.b();
    }

    @Override // com.google.android.exoplayer2.d
    public void j(int i, long j, int i2, boolean z) {
        E1();
        vh.a(i >= 0);
        this.r.notifySeekStarted();
        e0 e0Var = this.s0.f18178a;
        if (e0Var.u() || i < e0Var.t()) {
            this.H++;
            if (isPlayingAd()) {
                y53.i("ExoPlayerImpl", "seekTo ignored because an ad is playing");
                l.e eVar = new l.e(this.s0);
                eVar.b(1);
                this.j.a(eVar);
                return;
            }
            ij4 ij4VarH = this.s0;
            int i3 = ij4VarH.e;
            if (i3 == 3 || (i3 == 4 && !e0Var.u())) {
                ij4VarH = this.s0.h(2);
            }
            int currentMediaItemIndex = getCurrentMediaItemIndex();
            ij4 ij4VarK1 = k1(ij4VarH, e0Var, l1(e0Var, i, j));
            this.k.A0(e0Var, i, g86.H0(j));
            B1(ij4VarK1, 0, 1, true, 1, D0(ij4VarK1), currentMediaItemIndex, z);
        }
    }

    public final ij4 k1(ij4 ij4Var, e0 e0Var, @Nullable Pair<Object, Long> pair) {
        vh.a(e0Var.u() || pair != null);
        e0 e0Var2 = ij4Var.f18178a;
        long jC0 = C0(ij4Var);
        ij4 ij4VarJ = ij4Var.j(e0Var);
        if (e0Var.u()) {
            i.b bVarL = ij4.l();
            long jH0 = g86.H0(this.v0);
            ij4 ij4VarC = ij4VarJ.d(bVarL, jH0, jH0, jH0, 0L, vz5.d, this.b, ImmutableList.of()).c(bVarL);
            ij4VarC.p = ij4VarC.r;
            return ij4VarC;
        }
        Object obj = ij4VarJ.b.f18710a;
        boolean z = !obj.equals(((Pair) g86.j(pair)).first);
        i.b bVar = z ? new i.b(pair.first) : ij4VarJ.b;
        long jLongValue = ((Long) pair.second).longValue();
        long jH02 = g86.H0(jC0);
        if (!e0Var2.u()) {
            jH02 -= e0Var2.l(obj, this.n).q();
        }
        if (z || jLongValue < jH02) {
            vh.g(!bVar.b());
            ij4 ij4VarC2 = ij4VarJ.d(bVar, jLongValue, jLongValue, jLongValue, 0L, z ? vz5.d : ij4VarJ.h, z ? this.b : ij4VarJ.i, z ? ImmutableList.of() : ij4VarJ.j).c(bVar);
            ij4VarC2.p = jLongValue;
            return ij4VarC2;
        }
        if (jLongValue == jH02) {
            int iF = e0Var.f(ij4VarJ.k.f18710a);
            if (iF == -1 || e0Var.j(iF, this.n).c != e0Var.l(bVar.f18710a, this.n).c) {
                e0Var.l(bVar.f18710a, this.n);
                long jE = bVar.b() ? this.n.e(bVar.b, bVar.c) : this.n.d;
                ij4VarJ = ij4VarJ.d(bVar, ij4VarJ.r, ij4VarJ.r, ij4VarJ.d, jE - ij4VarJ.r, ij4VarJ.h, ij4VarJ.i, ij4VarJ.j).c(bVar);
                ij4VarJ.p = jE;
            }
        } else {
            vh.g(!bVar.b());
            long jMax = Math.max(0L, ij4VarJ.q - (jLongValue - jH02));
            long j = ij4VarJ.p;
            if (ij4VarJ.k.equals(ij4VarJ.b)) {
                j = jLongValue + jMax;
            }
            ij4VarJ = ij4VarJ.d(bVar, jLongValue, jLongValue, jLongValue, jMax, ij4VarJ.h, ij4VarJ.i, ij4VarJ.j);
            ij4VarJ.p = j;
        }
        return ij4VarJ;
    }

    @Nullable
    public final Pair<Object, Long> l1(e0 e0Var, int i, long j) {
        if (e0Var.u()) {
            this.t0 = i;
            if (j == -9223372036854775807L) {
                j = 0;
            }
            this.v0 = j;
            this.u0 = 0;
            return null;
        }
        if (i == -1 || i >= e0Var.t()) {
            i = e0Var.e(this.G);
            j = e0Var.r(i, this.f5848a).d();
        }
        return e0Var.n(this.f5848a, this.n, i, g86.H0(j));
    }

    public final void m1(final int i, final int i2) {
        if (i == this.c0.b() && i2 == this.c0.a()) {
            return;
        }
        this.c0 = new ne5(i, i2);
        this.l.l(24, new z33.a() { // from class: yp1
            @Override // z33.a
            public final void invoke(Object obj) {
                ((v.d) obj).onSurfaceSizeChanged(i, i2);
            }
        });
        q1(2, 14, new ne5(i, i2));
    }

    public final long n1(e0 e0Var, i.b bVar, long j) {
        e0Var.l(bVar.f18710a, this.n);
        return j + this.n.q();
    }

    public final void o1(int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            this.o.remove(i3);
        }
        this.M = this.M.cloneAndRemove(i, i2);
    }

    public final void p1() {
        if (this.X != null) {
            z0(this.y).n(10000).m(null).l();
            this.X.removeVideoSurfaceListener(this.x);
            this.X = null;
        }
        TextureView textureView = this.Z;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != this.x) {
                y53.i("ExoPlayerImpl", "SurfaceTextureListener already unset or replaced.");
            } else {
                this.Z.setSurfaceTextureListener(null);
            }
            this.Z = null;
        }
        SurfaceHolder surfaceHolder = this.W;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.x);
            this.W = null;
        }
    }

    @Override // com.google.android.exoplayer2.v
    public void prepare() {
        E1();
        boolean playWhenReady = getPlayWhenReady();
        int iP = this.A.p(playWhenReady, 2);
        A1(playWhenReady, iP, F0(playWhenReady, iP));
        ij4 ij4Var = this.s0;
        if (ij4Var.e != 1) {
            return;
        }
        ij4 ij4VarF = ij4Var.f(null);
        ij4 ij4VarH = ij4VarF.h(ij4VarF.f18178a.u() ? 4 : 2);
        this.H++;
        this.k.h0();
        B1(ij4VarH, 1, 1, false, 5, -9223372036854775807L, -1, false);
    }

    public void q0(oc ocVar) {
        this.r.G((oc) vh.e(ocVar));
    }

    public final void q1(int i, int i2, @Nullable Object obj) {
        for (z zVar : this.g) {
            if (zVar.getTrackType() == i) {
                z0(zVar).n(i2).m(obj).l();
            }
        }
    }

    public void r0(j.a aVar) {
        this.m.add(aVar);
    }

    public final void r1() {
        q1(1, 2, Float.valueOf(this.h0 * this.A.g()));
    }

    @Override // com.google.android.exoplayer2.v
    public void release() {
        AudioTrack audioTrack;
        y53.f("ExoPlayerImpl", "Release " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.19.1] [" + g86.e + "] [" + jr1.b() + "]");
        E1();
        if (g86.f17680a < 21 && (audioTrack = this.T) != null) {
            audioTrack.release();
            this.T = null;
        }
        this.z.b(false);
        c0 c0Var = this.B;
        if (c0Var != null) {
            c0Var.g();
        }
        this.C.b(false);
        this.D.b(false);
        this.A.i();
        if (!this.k.j0()) {
            this.l.l(10, new z33.a() { // from class: hq1
                @Override // z33.a
                public final void invoke(Object obj) {
                    k.Q0((v.d) obj);
                }
            });
        }
        this.l.j();
        this.i.removeCallbacksAndMessages(null);
        this.t.d(this.r);
        ij4 ij4Var = this.s0;
        if (ij4Var.o) {
            this.s0 = ij4Var.a();
        }
        ij4 ij4VarH = this.s0.h(1);
        this.s0 = ij4VarH;
        ij4 ij4VarC = ij4VarH.c(ij4VarH.b);
        this.s0 = ij4VarC;
        ij4VarC.p = ij4VarC.r;
        this.s0.q = 0L;
        this.r.release();
        this.h.j();
        p1();
        Surface surface = this.V;
        if (surface != null) {
            surface.release();
            this.V = null;
        }
        if (this.n0) {
            ((PriorityTaskManager) vh.e(this.m0)).c(0);
            this.n0 = false;
        }
        this.j0 = xr0.c;
        this.o0 = true;
    }

    public final List<s.c> s0(int i, List<com.google.android.exoplayer2.source.i> list) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            s.c cVar = new s.c(list.get(i2), this.p);
            arrayList.add(cVar);
            this.o.add(i2 + i, new e(cVar.b, cVar.f5931a.Q()));
        }
        this.M = this.M.cloneAndInsert(i, arrayList.size());
        return arrayList;
    }

    public void s1(List<com.google.android.exoplayer2.source.i> list, boolean z) {
        E1();
        t1(list, -1, -9223372036854775807L, z);
    }

    @Override // com.google.android.exoplayer2.v
    public void setMediaItems(List<p> list, boolean z) {
        E1();
        s1(y0(list), z);
    }

    @Override // com.google.android.exoplayer2.v
    public void setPlayWhenReady(boolean z) {
        E1();
        int iP = this.A.p(z, getPlaybackState());
        A1(z, iP, F0(z, iP));
    }

    @Override // com.google.android.exoplayer2.v
    public void setRepeatMode(final int i) {
        E1();
        if (this.F != i) {
            this.F = i;
            this.k.U0(i);
            this.l.i(8, new z33.a() { // from class: kq1
                @Override // z33.a
                public final void invoke(Object obj) {
                    ((v.d) obj).onRepeatModeChanged(i);
                }
            });
            z1();
            this.l.f();
        }
    }

    @Override // com.google.android.exoplayer2.v
    public void setShuffleModeEnabled(final boolean z) {
        E1();
        if (this.G != z) {
            this.G = z;
            this.k.X0(z);
            this.l.i(9, new z33.a() { // from class: gq1
                @Override // z33.a
                public final void invoke(Object obj) {
                    ((v.d) obj).onShuffleModeEnabledChanged(z);
                }
            });
            z1();
            this.l.f();
        }
    }

    @Override // com.google.android.exoplayer2.v
    public void setVideoSurfaceView(@Nullable SurfaceView surfaceView) {
        E1();
        if (surfaceView instanceof db6) {
            p1();
            w1(surfaceView);
            u1(surfaceView.getHolder());
        } else {
            if (!(surfaceView instanceof SphericalGLSurfaceView)) {
                x1(surfaceView == null ? null : surfaceView.getHolder());
                return;
            }
            p1();
            this.X = (SphericalGLSurfaceView) surfaceView;
            z0(this.y).n(10000).m(this.X).l();
            this.X.addVideoSurfaceListener(this.x);
            w1(this.X.getVideoSurface());
            u1(surfaceView.getHolder());
        }
    }

    @Override // com.google.android.exoplayer2.v
    public void setVideoTextureView(@Nullable TextureView textureView) {
        E1();
        if (textureView == null) {
            u0();
            return;
        }
        p1();
        this.Z = textureView;
        if (textureView.getSurfaceTextureListener() != null) {
            y53.i("ExoPlayerImpl", "Replacing existing SurfaceTextureListener.");
        }
        textureView.setSurfaceTextureListener(this.x);
        SurfaceTexture surfaceTexture = textureView.isAvailable() ? textureView.getSurfaceTexture() : null;
        if (surfaceTexture == null) {
            w1(null);
            m1(0, 0);
        } else {
            v1(surfaceTexture);
            m1(textureView.getWidth(), textureView.getHeight());
        }
    }

    @Override // com.google.android.exoplayer2.v
    public void setVolume(float f) {
        E1();
        final float fP = g86.p(f, 0.0f, 1.0f);
        if (this.h0 == fP) {
            return;
        }
        this.h0 = fP;
        r1();
        this.l.l(22, new z33.a() { // from class: iq1
            @Override // z33.a
            public final void invoke(Object obj) {
                ((v.d) obj).onVolumeChanged(fP);
            }
        });
    }

    @Override // com.google.android.exoplayer2.v
    public void stop() {
        E1();
        this.A.p(getPlayWhenReady(), 1);
        y1(null);
        this.j0 = new xr0(ImmutableList.of(), this.s0.r);
    }

    public final q t0() {
        e0 currentTimeline = getCurrentTimeline();
        if (currentTimeline.u()) {
            return this.r0;
        }
        return this.r0.b().J(currentTimeline.r(getCurrentMediaItemIndex(), this.f5848a).c.e).H();
    }

    public final void t1(List<com.google.android.exoplayer2.source.i> list, int i, long j, boolean z) {
        int iE;
        long j2;
        int iE0 = E0(this.s0);
        long currentPosition = getCurrentPosition();
        this.H++;
        if (!this.o.isEmpty()) {
            o1(0, this.o.size());
        }
        List<s.c> listS0 = s0(0, list);
        e0 e0VarX0 = x0();
        if (!e0VarX0.u() && i >= e0VarX0.t()) {
            throw new IllegalSeekPositionException(e0VarX0, i, j);
        }
        if (z) {
            j2 = -9223372036854775807L;
            iE = e0VarX0.e(this.G);
        } else if (i == -1) {
            iE = iE0;
            j2 = currentPosition;
        } else {
            iE = i;
            j2 = j;
        }
        ij4 ij4VarK1 = k1(this.s0, e0VarX0, l1(e0VarX0, iE, j2));
        int i2 = ij4VarK1.e;
        if (iE != -1 && i2 != 1) {
            i2 = (e0VarX0.u() || iE >= e0VarX0.t()) ? 4 : 2;
        }
        ij4 ij4VarH = ij4VarK1.h(i2);
        this.k.N0(listS0, iE, g86.H0(j2), this.M);
        B1(ij4VarH, 0, 1, (this.s0.b.f18710a.equals(ij4VarH.b.f18710a) || this.s0.f18178a.u()) ? false : true, 4, D0(ij4VarH), -1, false);
    }

    public void u0() {
        E1();
        p1();
        w1(null);
        m1(0, 0);
    }

    public final void u1(SurfaceHolder surfaceHolder) {
        this.Y = false;
        this.W = surfaceHolder;
        surfaceHolder.addCallback(this.x);
        Surface surface = this.W.getSurface();
        if (surface == null || !surface.isValid()) {
            m1(0, 0);
        } else {
            Rect surfaceFrame = this.W.getSurfaceFrame();
            m1(surfaceFrame.width(), surfaceFrame.height());
        }
    }

    public void v0(@Nullable SurfaceHolder surfaceHolder) {
        E1();
        if (surfaceHolder == null || surfaceHolder != this.W) {
            return;
        }
        u0();
    }

    public final void v1(SurfaceTexture surfaceTexture) {
        Surface surface = new Surface(surfaceTexture);
        w1(surface);
        this.V = surface;
    }

    public final void w1(@Nullable Object obj) {
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (z zVar : this.g) {
            if (zVar.getTrackType() == 2) {
                arrayList.add(z0(zVar).n(1).m(obj).l());
            }
        }
        Object obj2 = this.U;
        if (obj2 != null && obj2 != obj) {
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((w) it.next()).a(this.E);
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (TimeoutException unused2) {
                z = true;
            }
            Object obj3 = this.U;
            Surface surface = this.V;
            if (obj3 == surface) {
                surface.release();
                this.V = null;
            }
        }
        this.U = obj;
        if (z) {
            y1(ExoPlaybackException.createForUnexpected(new ExoTimeoutException(3), 1003));
        }
    }

    public final e0 x0() {
        return new x(this.o, this.M);
    }

    public void x1(@Nullable SurfaceHolder surfaceHolder) {
        E1();
        if (surfaceHolder == null) {
            u0();
            return;
        }
        p1();
        this.Y = true;
        this.W = surfaceHolder;
        surfaceHolder.addCallback(this.x);
        Surface surface = surfaceHolder.getSurface();
        if (surface == null || !surface.isValid()) {
            w1(null);
            m1(0, 0);
        } else {
            w1(surface);
            Rect surfaceFrame = surfaceHolder.getSurfaceFrame();
            m1(surfaceFrame.width(), surfaceFrame.height());
        }
    }

    public final List<com.google.android.exoplayer2.source.i> y0(List<p> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(this.q.c(list.get(i)));
        }
        return arrayList;
    }

    public final void y1(@Nullable ExoPlaybackException exoPlaybackException) {
        ij4 ij4Var = this.s0;
        ij4 ij4VarC = ij4Var.c(ij4Var.b);
        ij4VarC.p = ij4VarC.r;
        ij4VarC.q = 0L;
        ij4 ij4VarH = ij4VarC.h(1);
        if (exoPlaybackException != null) {
            ij4VarH = ij4VarH.f(exoPlaybackException);
        }
        this.H++;
        this.k.h1();
        B1(ij4VarH, 0, 1, false, 5, -9223372036854775807L, -1, false);
    }

    public final w z0(w.b bVar) {
        int iE0 = E0(this.s0);
        l lVar = this.k;
        return new w(lVar, bVar, this.s0.f18178a, iE0 == -1 ? 0 : iE0, this.w, lVar.A());
    }

    public final void z1() {
        v.b bVar = this.O;
        v.b bVarH = g86.H(this.f, this.c);
        this.O = bVarH;
        if (bVarH.equals(bVar)) {
            return;
        }
        this.l.i(13, new z33.a() { // from class: mq1
            @Override // z33.a
            public final void invoke(Object obj) {
                this.f19291a.V0((v.d) obj);
            }
        });
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class c implements oe6, com.google.android.exoplayer2.audio.d, gv5, to3, SurfaceHolder.Callback, TextureView.SurfaceTextureListener, SphericalGLSurfaceView.b, c.b, b.InterfaceC0350b, c0.b, j.a {
        public c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void w(v.d dVar) {
            dVar.n(k.this.P);
        }

        @Override // com.google.android.exoplayer2.audio.d
        public void a(m mVar, @Nullable ow0 ow0Var) {
            k.this.S = mVar;
            k.this.r.a(mVar, ow0Var);
        }

        @Override // defpackage.oe6
        public void b(lw0 lw0Var) {
            k.this.d0 = lw0Var;
            k.this.r.b(lw0Var);
        }

        @Override // com.google.android.exoplayer2.audio.d
        public void c(lw0 lw0Var) {
            k.this.r.c(lw0Var);
            k.this.S = null;
            k.this.e0 = null;
        }

        @Override // defpackage.gv5
        public void d(final xr0 xr0Var) {
            k.this.j0 = xr0Var;
            k.this.l.l(27, new z33.a() { // from class: cr1
                @Override // z33.a
                public final void invoke(Object obj) {
                    ((v.d) obj).d(xr0Var);
                }
            });
        }

        @Override // com.google.android.exoplayer2.audio.d
        public void e(lw0 lw0Var) {
            k.this.e0 = lw0Var;
            k.this.r.e(lw0Var);
        }

        @Override // com.google.android.exoplayer2.c.b
        public void executePlayerCommand(int i) {
            boolean playWhenReady = k.this.getPlayWhenReady();
            k.this.A1(playWhenReady, i, k.F0(playWhenReady, i));
        }

        @Override // defpackage.to3
        public void f(final Metadata metadata) {
            k kVar = k.this;
            kVar.r0 = kVar.r0.b().K(metadata).H();
            q qVarT0 = k.this.t0();
            if (!qVarT0.equals(k.this.P)) {
                k.this.P = qVarT0;
                k.this.l.i(14, new z33.a() { // from class: xq1
                    @Override // z33.a
                    public final void invoke(Object obj) {
                        this.f22035a.w((v.d) obj);
                    }
                });
            }
            k.this.l.i(28, new z33.a() { // from class: yq1
                @Override // z33.a
                public final void invoke(Object obj) {
                    ((v.d) obj).f(metadata);
                }
            });
            k.this.l.f();
        }

        @Override // com.google.android.exoplayer2.j.a
        public /* synthetic */ void g(boolean z) {
            po1.a(this, z);
        }

        @Override // com.google.android.exoplayer2.audio.d
        public /* synthetic */ void h(m mVar) {
            lk.a(this, mVar);
        }

        @Override // defpackage.oe6
        public void i(final te6 te6Var) {
            k.this.q0 = te6Var;
            k.this.l.l(25, new z33.a() { // from class: er1
                @Override // z33.a
                public final void invoke(Object obj) {
                    ((v.d) obj).i(te6Var);
                }
            });
        }

        @Override // defpackage.oe6
        public void j(lw0 lw0Var) {
            k.this.r.j(lw0Var);
            k.this.R = null;
            k.this.d0 = null;
        }

        @Override // defpackage.oe6
        public void k(m mVar, @Nullable ow0 ow0Var) {
            k.this.R = mVar;
            k.this.r.k(mVar, ow0Var);
        }

        @Override // defpackage.oe6
        public /* synthetic */ void l(m mVar) {
            gd6.a(this, mVar);
        }

        @Override // com.google.android.exoplayer2.b.InterfaceC0350b
        public void onAudioBecomingNoisy() {
            k.this.A1(false, -1, 3);
        }

        @Override // com.google.android.exoplayer2.audio.d
        public void onAudioCodecError(Exception exc) {
            k.this.r.onAudioCodecError(exc);
        }

        @Override // com.google.android.exoplayer2.audio.d
        public void onAudioDecoderInitialized(String str, long j, long j2) {
            k.this.r.onAudioDecoderInitialized(str, j, j2);
        }

        @Override // com.google.android.exoplayer2.audio.d
        public void onAudioDecoderReleased(String str) {
            k.this.r.onAudioDecoderReleased(str);
        }

        @Override // com.google.android.exoplayer2.audio.d
        public void onAudioPositionAdvancing(long j) {
            k.this.r.onAudioPositionAdvancing(j);
        }

        @Override // com.google.android.exoplayer2.audio.d
        public void onAudioSinkError(Exception exc) {
            k.this.r.onAudioSinkError(exc);
        }

        @Override // com.google.android.exoplayer2.audio.d
        public void onAudioUnderrun(int i, long j, long j2) {
            k.this.r.onAudioUnderrun(i, j, j2);
        }

        @Override // defpackage.gv5
        public void onCues(final List<pr0> list) {
            k.this.l.l(27, new z33.a() { // from class: zq1
                @Override // z33.a
                public final void invoke(Object obj) {
                    ((v.d) obj).onCues(list);
                }
            });
        }

        @Override // defpackage.oe6
        public void onDroppedFrames(int i, long j) {
            k.this.r.onDroppedFrames(i, j);
        }

        @Override // com.google.android.exoplayer2.j.a
        public void onExperimentalSleepingForOffloadChanged(boolean z) {
            k.this.D1();
        }

        @Override // defpackage.oe6
        public void onRenderedFirstFrame(Object obj, long j) {
            k.this.r.onRenderedFirstFrame(obj, j);
            if (k.this.U == obj) {
                k.this.l.l(26, new z33.a() { // from class: dr1
                    @Override // z33.a
                    public final void invoke(Object obj2) {
                        ((v.d) obj2).onRenderedFirstFrame();
                    }
                });
            }
        }

        @Override // com.google.android.exoplayer2.audio.d
        public void onSkipSilenceEnabledChanged(final boolean z) {
            if (k.this.i0 == z) {
                return;
            }
            k.this.i0 = z;
            k.this.l.l(23, new z33.a() { // from class: fr1
                @Override // z33.a
                public final void invoke(Object obj) {
                    ((v.d) obj).onSkipSilenceEnabledChanged(z);
                }
            });
        }

        @Override // com.google.android.exoplayer2.c0.b
        public void onStreamTypeChanged(int i) {
            final i iVarW0 = k.w0(k.this.B);
            if (iVarW0.equals(k.this.p0)) {
                return;
            }
            k.this.p0 = iVarW0;
            k.this.l.l(29, new z33.a() { // from class: ar1
                @Override // z33.a
                public final void invoke(Object obj) {
                    ((v.d) obj).x(iVarW0);
                }
            });
        }

        @Override // com.google.android.exoplayer2.c0.b
        public void onStreamVolumeChanged(final int i, final boolean z) {
            k.this.l.l(30, new z33.a() { // from class: br1
                @Override // z33.a
                public final void invoke(Object obj) {
                    ((v.d) obj).onDeviceVolumeChanged(i, z);
                }
            });
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            k.this.v1(surfaceTexture);
            k.this.m1(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            k.this.w1(null);
            k.this.m1(0, 0);
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            k.this.m1(i, i2);
        }

        @Override // defpackage.oe6
        public void onVideoCodecError(Exception exc) {
            k.this.r.onVideoCodecError(exc);
        }

        @Override // defpackage.oe6
        public void onVideoDecoderInitialized(String str, long j, long j2) {
            k.this.r.onVideoDecoderInitialized(str, j, j2);
        }

        @Override // defpackage.oe6
        public void onVideoDecoderReleased(String str) {
            k.this.r.onVideoDecoderReleased(str);
        }

        @Override // defpackage.oe6
        public void onVideoFrameProcessingOffset(long j, int i) {
            k.this.r.onVideoFrameProcessingOffset(j, i);
        }

        @Override // com.google.android.exoplayer2.video.spherical.SphericalGLSurfaceView.b
        public void onVideoSurfaceCreated(Surface surface) {
            k.this.w1(surface);
        }

        @Override // com.google.android.exoplayer2.video.spherical.SphericalGLSurfaceView.b
        public void onVideoSurfaceDestroyed(Surface surface) {
            k.this.w1(null);
        }

        @Override // com.google.android.exoplayer2.c.b
        public void setVolumeMultiplier(float f) {
            k.this.r1();
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            k.this.m1(i2, i3);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            if (k.this.Y) {
                k.this.w1(surfaceHolder.getSurface());
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            if (k.this.Y) {
                k.this.w1(null);
            }
            k.this.m1(0, 0);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }
}
