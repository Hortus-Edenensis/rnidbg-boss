package defpackage;

import android.os.Looper;
import android.util.SparseArray;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.e0;
import com.google.android.exoplayer2.f0;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.q;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.u;
import com.google.android.exoplayer2.v;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import defpackage.oc;
import defpackage.z33;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public class b21 implements kc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ed0 f1631a;
    public final e0.b b;
    public final e0.d c;
    public final a d;
    public final SparseArray<oc.a> e;
    public z33<oc> f;
    public v g;
    public mg2 h;
    public boolean i;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e0.b f1632a;
        public ImmutableList<i.b> b = ImmutableList.of();
        public ImmutableMap<i.b, e0> c = ImmutableMap.of();

        @Nullable
        public i.b d;
        public i.b e;
        public i.b f;

        public a(e0.b bVar) {
            this.f1632a = bVar;
        }

        @Nullable
        public static i.b c(v vVar, ImmutableList<i.b> immutableList, @Nullable i.b bVar, e0.b bVar2) {
            e0 currentTimeline = vVar.getCurrentTimeline();
            int currentPeriodIndex = vVar.getCurrentPeriodIndex();
            Object objQ = currentTimeline.u() ? null : currentTimeline.q(currentPeriodIndex);
            int iG = (vVar.isPlayingAd() || currentTimeline.u()) ? -1 : currentTimeline.j(currentPeriodIndex, bVar2).g(g86.H0(vVar.getCurrentPosition()) - bVar2.q());
            for (int i = 0; i < immutableList.size(); i++) {
                i.b bVar3 = immutableList.get(i);
                if (i(bVar3, objQ, vVar.isPlayingAd(), vVar.getCurrentAdGroupIndex(), vVar.getCurrentAdIndexInAdGroup(), iG)) {
                    return bVar3;
                }
            }
            if (immutableList.isEmpty() && bVar != null) {
                if (i(bVar, objQ, vVar.isPlayingAd(), vVar.getCurrentAdGroupIndex(), vVar.getCurrentAdIndexInAdGroup(), iG)) {
                    return bVar;
                }
            }
            return null;
        }

        public static boolean i(i.b bVar, @Nullable Object obj, boolean z, int i, int i2, int i3) {
            if (bVar.f18710a.equals(obj)) {
                return (z && bVar.b == i && bVar.c == i2) || (!z && bVar.b == -1 && bVar.e == i3);
            }
            return false;
        }

        public final void b(ImmutableMap.b<i.b, e0> bVar, @Nullable i.b bVar2, e0 e0Var) {
            if (bVar2 == null) {
                return;
            }
            if (e0Var.f(bVar2.f18710a) != -1) {
                bVar.h(bVar2, e0Var);
                return;
            }
            e0 e0Var2 = this.c.get(bVar2);
            if (e0Var2 != null) {
                bVar.h(bVar2, e0Var2);
            }
        }

        @Nullable
        public i.b d() {
            return this.d;
        }

        @Nullable
        public i.b e() {
            if (this.b.isEmpty()) {
                return null;
            }
            return (i.b) bv2.g(this.b);
        }

        @Nullable
        public e0 f(i.b bVar) {
            return this.c.get(bVar);
        }

        @Nullable
        public i.b g() {
            return this.e;
        }

        @Nullable
        public i.b h() {
            return this.f;
        }

        public void j(v vVar) {
            this.d = c(vVar, this.b, this.e, this.f1632a);
        }

        public void k(List<i.b> list, @Nullable i.b bVar, v vVar) {
            this.b = ImmutableList.copyOf((Collection) list);
            if (!list.isEmpty()) {
                this.e = list.get(0);
                this.f = (i.b) vh.e(bVar);
            }
            if (this.d == null) {
                this.d = c(vVar, this.b, this.e, this.f1632a);
            }
            m(vVar.getCurrentTimeline());
        }

        public void l(v vVar) {
            this.d = c(vVar, this.b, this.e, this.f1632a);
            m(vVar.getCurrentTimeline());
        }

        public final void m(e0 e0Var) {
            ImmutableMap.b<i.b, e0> bVarBuilder = ImmutableMap.builder();
            if (this.b.isEmpty()) {
                b(bVarBuilder, this.e, e0Var);
                if (!m54.a(this.f, this.e)) {
                    b(bVarBuilder, this.f, e0Var);
                }
                if (!m54.a(this.d, this.e) && !m54.a(this.d, this.f)) {
                    b(bVarBuilder, this.d, e0Var);
                }
            } else {
                for (int i = 0; i < this.b.size(); i++) {
                    b(bVarBuilder, this.b.get(i), e0Var);
                }
                if (!this.b.contains(this.d)) {
                    b(bVarBuilder, this.d, e0Var);
                }
            }
            this.c = bVarBuilder.d();
        }
    }

    public b21(ed0 ed0Var) {
        this.f1631a = (ed0) vh.e(ed0Var);
        this.f = new z33<>(g86.P(), ed0Var, new z33.b() { // from class: mz0
            @Override // z33.b
            public final void a(Object obj, qx1 qx1Var) {
                b21.e1((oc) obj, qx1Var);
            }
        });
        e0.b bVar = new e0.b();
        this.b = bVar;
        this.c = new e0.d();
        this.d = new a(bVar);
        this.e = new SparseArray<>();
    }

    public static /* synthetic */ void D1(oc.a aVar, boolean z, oc ocVar) {
        ocVar.F(aVar, z);
        ocVar.r0(aVar, z);
    }

    public static /* synthetic */ void T1(oc.a aVar, int i, v.e eVar, v.e eVar2, oc ocVar) {
        ocVar.k(aVar, i);
        ocVar.Y(aVar, eVar, eVar2, i);
    }

    public static /* synthetic */ void e2(oc.a aVar, String str, long j, long j2, oc ocVar) {
        ocVar.X(aVar, str, j);
        ocVar.h0(aVar, str, j2, j);
    }

    public static /* synthetic */ void h1(oc.a aVar, String str, long j, long j2, oc ocVar) {
        ocVar.v(aVar, str, j);
        ocVar.d0(aVar, str, j2, j);
    }

    public static /* synthetic */ void j2(oc.a aVar, m mVar, ow0 ow0Var, oc ocVar) {
        ocVar.r(aVar, mVar);
        ocVar.B(aVar, mVar, ow0Var);
    }

    public static /* synthetic */ void k2(oc.a aVar, te6 te6Var, oc ocVar) {
        ocVar.g(aVar, te6Var);
        ocVar.Q(aVar, te6Var.f20973a, te6Var.b, te6Var.c, te6Var.d);
    }

    public static /* synthetic */ void l1(oc.a aVar, m mVar, ow0 ow0Var, oc ocVar) {
        ocVar.c0(aVar, mVar);
        ocVar.R(aVar, mVar, ow0Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n2(v vVar, oc ocVar, qx1 qx1Var) {
        ocVar.H(vVar, new oc.b(qx1Var, this.e));
    }

    public static /* synthetic */ void z1(oc.a aVar, int i, oc ocVar) {
        ocVar.p(aVar);
        ocVar.x(aVar, i);
    }

    @Override // com.google.android.exoplayer2.source.j
    public final void A(int i, @Nullable i.b bVar, final kh3 kh3Var) {
        final oc.a aVarA1 = a1(i, bVar);
        p2(aVarA1, 1005, new z33.a() { // from class: vy0
            @Override // z33.a
            public final void invoke(Object obj) {
                ((oc) obj).P(aVarA1, kh3Var);
            }
        });
    }

    @Override // com.google.android.exoplayer2.v.d
    public void B(final f0 f0Var) {
        final oc.a aVarW0 = W0();
        p2(aVarW0, 2, new z33.a() { // from class: by0
            @Override // z33.a
            public final void invoke(Object obj) {
                ((oc) obj).j(aVarW0, f0Var);
            }
        });
    }

    @Override // com.google.android.exoplayer2.drm.b
    public final void C(int i, @Nullable i.b bVar, final Exception exc) {
        final oc.a aVarA1 = a1(i, bVar);
        p2(aVarA1, 1024, new z33.a() { // from class: d01
            @Override // z33.a
            public final void invoke(Object obj) {
                ((oc) obj).t0(aVarA1, exc);
            }
        });
    }

    @Override // com.google.android.exoplayer2.source.j
    public final void E(int i, @Nullable i.b bVar, final m43 m43Var, final kh3 kh3Var) {
        final oc.a aVarA1 = a1(i, bVar);
        p2(aVarA1, 1002, new z33.a() { // from class: px0
            @Override // z33.a
            public final void invoke(Object obj) {
                ((oc) obj).W(aVarA1, m43Var, kh3Var);
            }
        });
    }

    @Override // defpackage.kc
    public final void F(List<i.b> list, @Nullable i.b bVar) {
        this.d.k(list, bVar, (v) vh.e(this.g));
    }

    @Override // defpackage.kc
    @CallSuper
    public void G(oc ocVar) {
        vh.e(ocVar);
        this.f.c(ocVar);
    }

    @Override // com.google.android.exoplayer2.source.j
    public final void H(int i, @Nullable i.b bVar, final m43 m43Var, final kh3 kh3Var) {
        final oc.a aVarA1 = a1(i, bVar);
        p2(aVarA1, 1000, new z33.a() { // from class: b01
            @Override // z33.a
            public final void invoke(Object obj) {
                ((oc) obj).c(aVarA1, m43Var, kh3Var);
            }
        });
    }

    @Override // com.google.android.exoplayer2.v.d
    public final void I(@Nullable final p pVar, final int i) {
        final oc.a aVarW0 = W0();
        p2(aVarW0, 1, new z33.a() { // from class: wx0
            @Override // z33.a
            public final void invoke(Object obj) {
                ((oc) obj).D(aVarW0, pVar, i);
            }
        });
    }

    @Override // com.google.android.exoplayer2.source.j
    public final void J(int i, @Nullable i.b bVar, final m43 m43Var, final kh3 kh3Var, final IOException iOException, final boolean z) {
        final oc.a aVarA1 = a1(i, bVar);
        p2(aVarA1, 1003, new z33.a() { // from class: jz0
            @Override // z33.a
            public final void invoke(Object obj) {
                ((oc) obj).M(aVarA1, m43Var, kh3Var, iOException, z);
            }
        });
    }

    @Override // com.google.android.exoplayer2.drm.b
    public final void K(int i, @Nullable i.b bVar) {
        final oc.a aVarA1 = a1(i, bVar);
        p2(aVarA1, 1027, new z33.a() { // from class: zx0
            @Override // z33.a
            public final void invoke(Object obj) {
                ((oc) obj).A(aVarA1);
            }
        });
    }

    public final oc.a W0() {
        return Y0(this.d.d());
    }

    public final oc.a X0(e0 e0Var, int i, @Nullable i.b bVar) {
        long contentPosition;
        i.b bVar2 = e0Var.u() ? null : bVar;
        long jElapsedRealtime = this.f1631a.elapsedRealtime();
        boolean z = e0Var.equals(this.g.getCurrentTimeline()) && i == this.g.getCurrentMediaItemIndex();
        long jD = 0;
        if (bVar2 != null && bVar2.b()) {
            if (z && this.g.getCurrentAdGroupIndex() == bVar2.b && this.g.getCurrentAdIndexInAdGroup() == bVar2.c) {
                jD = this.g.getCurrentPosition();
            }
        } else {
            if (z) {
                contentPosition = this.g.getContentPosition();
                return new oc.a(jElapsedRealtime, e0Var, i, bVar2, contentPosition, this.g.getCurrentTimeline(), this.g.getCurrentMediaItemIndex(), this.d.d(), this.g.getCurrentPosition(), this.g.getTotalBufferedDuration());
            }
            if (!e0Var.u()) {
                jD = e0Var.r(i, this.c).d();
            }
        }
        contentPosition = jD;
        return new oc.a(jElapsedRealtime, e0Var, i, bVar2, contentPosition, this.g.getCurrentTimeline(), this.g.getCurrentMediaItemIndex(), this.d.d(), this.g.getCurrentPosition(), this.g.getTotalBufferedDuration());
    }

    public final oc.a Y0(@Nullable i.b bVar) {
        vh.e(this.g);
        e0 e0VarF = bVar == null ? null : this.d.f(bVar);
        if (bVar != null && e0VarF != null) {
            return X0(e0VarF, e0VarF.l(bVar.f18710a, this.b).c, bVar);
        }
        int currentMediaItemIndex = this.g.getCurrentMediaItemIndex();
        e0 currentTimeline = this.g.getCurrentTimeline();
        if (!(currentMediaItemIndex < currentTimeline.t())) {
            currentTimeline = e0.f5869a;
        }
        return X0(currentTimeline, currentMediaItemIndex, null);
    }

    public final oc.a Z0() {
        return Y0(this.d.e());
    }

    @Override // defpackage.kc
    public final void a(final m mVar, @Nullable final ow0 ow0Var) {
        final oc.a aVarC1 = c1();
        p2(aVarC1, 1009, new z33.a() { // from class: ty0
            @Override // z33.a
            public final void invoke(Object obj) {
                b21.l1(aVarC1, mVar, ow0Var, (oc) obj);
            }
        });
    }

    public final oc.a a1(int i, @Nullable i.b bVar) {
        vh.e(this.g);
        if (bVar != null) {
            return this.d.f(bVar) != null ? Y0(bVar) : X0(e0.f5869a, i, bVar);
        }
        e0 currentTimeline = this.g.getCurrentTimeline();
        if (!(i < currentTimeline.t())) {
            currentTimeline = e0.f5869a;
        }
        return X0(currentTimeline, i, null);
    }

    @Override // defpackage.kc
    public final void b(final lw0 lw0Var) {
        final oc.a aVarC1 = c1();
        p2(aVarC1, 1015, new z33.a() { // from class: hx0
            @Override // z33.a
            public final void invoke(Object obj) {
                ((oc) obj).w(aVarC1, lw0Var);
            }
        });
    }

    public final oc.a b1() {
        return Y0(this.d.g());
    }

    @Override // defpackage.kc
    public final void c(final lw0 lw0Var) {
        final oc.a aVarB1 = b1();
        p2(aVarB1, 1013, new z33.a() { // from class: rz0
            @Override // z33.a
            public final void invoke(Object obj) {
                ((oc) obj).E(aVarB1, lw0Var);
            }
        });
    }

    public final oc.a c1() {
        return Y0(this.d.h());
    }

    @Override // com.google.android.exoplayer2.v.d
    public void d(final xr0 xr0Var) {
        final oc.a aVarW0 = W0();
        p2(aVarW0, 27, new z33.a() { // from class: hz0
            @Override // z33.a
            public final void invoke(Object obj) {
                ((oc) obj).V(aVarW0, xr0Var);
            }
        });
    }

    public final oc.a d1(@Nullable PlaybackException playbackException) {
        kk3 kk3Var;
        return (!(playbackException instanceof ExoPlaybackException) || (kk3Var = ((ExoPlaybackException) playbackException).mediaPeriodId) == null) ? W0() : Y0(new i.b(kk3Var));
    }

    @Override // defpackage.kc
    public final void e(final lw0 lw0Var) {
        final oc.a aVarC1 = c1();
        p2(aVarC1, 1007, new z33.a() { // from class: xy0
            @Override // z33.a
            public final void invoke(Object obj) {
                ((oc) obj).t(aVarC1, lw0Var);
            }
        });
    }

    @Override // com.google.android.exoplayer2.v.d
    public final void f(final Metadata metadata) {
        final oc.a aVarW0 = W0();
        p2(aVarW0, 28, new z33.a() { // from class: ww0
            @Override // z33.a
            public final void invoke(Object obj) {
                ((oc) obj).j0(aVarW0, metadata);
            }
        });
    }

    @Override // com.google.android.exoplayer2.v.d
    public final void g(final u uVar) {
        final oc.a aVarW0 = W0();
        p2(aVarW0, 12, new z33.a() { // from class: zz0
            @Override // z33.a
            public final void invoke(Object obj) {
                ((oc) obj).g0(aVarW0, uVar);
            }
        });
    }

    @Override // com.google.android.exoplayer2.source.j
    public final void h(int i, @Nullable i.b bVar, final kh3 kh3Var) {
        final oc.a aVarA1 = a1(i, bVar);
        p2(aVarA1, 1004, new z33.a() { // from class: hy0
            @Override // z33.a
            public final void invoke(Object obj) {
                ((oc) obj).o0(aVarA1, kh3Var);
            }
        });
    }

    @Override // com.google.android.exoplayer2.v.d
    public final void i(final te6 te6Var) {
        final oc.a aVarC1 = c1();
        p2(aVarC1, 25, new z33.a() { // from class: x01
            @Override // z33.a
            public final void invoke(Object obj) {
                b21.k2(aVarC1, te6Var, (oc) obj);
            }
        });
    }

    @Override // defpackage.kc
    public final void j(final lw0 lw0Var) {
        final oc.a aVarB1 = b1();
        p2(aVarB1, 1020, new z33.a() { // from class: qy0
            @Override // z33.a
            public final void invoke(Object obj) {
                ((oc) obj).U(aVarB1, lw0Var);
            }
        });
    }

    @Override // defpackage.kc
    public final void k(final m mVar, @Nullable final ow0 ow0Var) {
        final oc.a aVarC1 = c1();
        p2(aVarC1, 1017, new z33.a() { // from class: tz0
            @Override // z33.a
            public final void invoke(Object obj) {
                b21.j2(aVarC1, mVar, ow0Var, (oc) obj);
            }
        });
    }

    @Override // com.google.android.exoplayer2.v.d
    public final void l(final v.e eVar, final v.e eVar2, final int i) {
        if (i == 1) {
            this.i = false;
        }
        this.d.j((v) vh.e(this.g));
        final oc.a aVarW0 = W0();
        p2(aVarW0, 11, new z33.a() { // from class: l01
            @Override // z33.a
            public final void invoke(Object obj) {
                b21.T1(aVarW0, i, eVar, eVar2, (oc) obj);
            }
        });
    }

    @Override // com.google.android.exoplayer2.v.d
    public final void m(e0 e0Var, final int i) {
        this.d.l((v) vh.e(this.g));
        final oc.a aVarW0 = W0();
        p2(aVarW0, 0, new z33.a() { // from class: f01
            @Override // z33.a
            public final void invoke(Object obj) {
                ((oc) obj).s(aVarW0, i);
            }
        });
    }

    @Override // com.google.android.exoplayer2.v.d
    public void n(final q qVar) {
        final oc.a aVarW0 = W0();
        p2(aVarW0, 14, new z33.a() { // from class: k01
            @Override // z33.a
            public final void invoke(Object obj) {
                ((oc) obj).l(aVarW0, qVar);
            }
        });
    }

    @Override // defpackage.kc
    public final void notifySeekStarted() {
        if (this.i) {
            return;
        }
        final oc.a aVarW0 = W0();
        this.i = true;
        p2(aVarW0, -1, new z33.a() { // from class: x11
            @Override // z33.a
            public final void invoke(Object obj) {
                ((oc) obj).q(aVarW0);
            }
        });
    }

    @Override // defpackage.kc
    @CallSuper
    public void o(final v vVar, Looper looper) {
        vh.g(this.g == null || this.d.b.isEmpty());
        this.g = (v) vh.e(vVar);
        this.h = this.f1631a.createHandler(looper, null);
        this.f = this.f.e(looper, new z33.b() { // from class: rx0
            @Override // z33.b
            public final void a(Object obj, qx1 qx1Var) {
                this.f20618a.n2(vVar, (oc) obj, qx1Var);
            }
        });
    }

    public final void o2() {
        final oc.a aVarW0 = W0();
        p2(aVarW0, 1028, new z33.a() { // from class: z01
            @Override // z33.a
            public final void invoke(Object obj) {
                ((oc) obj).d(aVarW0);
            }
        });
        this.f.j();
    }

    @Override // defpackage.kc
    public final void onAudioCodecError(final Exception exc) {
        final oc.a aVarC1 = c1();
        p2(aVarC1, 1029, new z33.a() { // from class: pz0
            @Override // z33.a
            public final void invoke(Object obj) {
                ((oc) obj).b(aVarC1, exc);
            }
        });
    }

    @Override // defpackage.kc
    public final void onAudioDecoderInitialized(final String str, final long j, final long j2) {
        final oc.a aVarC1 = c1();
        p2(aVarC1, 1008, new z33.a() { // from class: nx0
            @Override // z33.a
            public final void invoke(Object obj) {
                b21.h1(aVarC1, str, j2, j, (oc) obj);
            }
        });
    }

    @Override // defpackage.kc
    public final void onAudioDecoderReleased(final String str) {
        final oc.a aVarC1 = c1();
        p2(aVarC1, 1012, new z33.a() { // from class: ux0
            @Override // z33.a
            public final void invoke(Object obj) {
                ((oc) obj).a0(aVarC1, str);
            }
        });
    }

    @Override // defpackage.kc
    public final void onAudioPositionAdvancing(final long j) {
        final oc.a aVarC1 = c1();
        p2(aVarC1, 1010, new z33.a() { // from class: xx0
            @Override // z33.a
            public final void invoke(Object obj) {
                ((oc) obj).O(aVarC1, j);
            }
        });
    }

    @Override // defpackage.kc
    public final void onAudioSinkError(final Exception exc) {
        final oc.a aVarC1 = c1();
        p2(aVarC1, 1014, new z33.a() { // from class: fy0
            @Override // z33.a
            public final void invoke(Object obj) {
                ((oc) obj).J(aVarC1, exc);
            }
        });
    }

    @Override // defpackage.kc
    public final void onAudioUnderrun(final int i, final long j, final long j2) {
        final oc.a aVarC1 = c1();
        p2(aVarC1, 1011, new z33.a() { // from class: p01
            @Override // z33.a
            public final void invoke(Object obj) {
                ((oc) obj).m0(aVarC1, i, j, j2);
            }
        });
    }

    @Override // dp.a
    public final void onBandwidthSample(final int i, final long j, final long j2) {
        final oc.a aVarZ0 = Z0();
        p2(aVarZ0, 1006, new z33.a() { // from class: j11
            @Override // z33.a
            public final void invoke(Object obj) {
                ((oc) obj).n0(aVarZ0, i, j, j2);
            }
        });
    }

    @Override // com.google.android.exoplayer2.v.d
    public void onCues(final List<pr0> list) {
        final oc.a aVarW0 = W0();
        p2(aVarW0, 27, new z33.a() { // from class: i01
            @Override // z33.a
            public final void invoke(Object obj) {
                ((oc) obj).K(aVarW0, list);
            }
        });
    }

    @Override // com.google.android.exoplayer2.v.d
    public void onDeviceVolumeChanged(final int i, final boolean z) {
        final oc.a aVarW0 = W0();
        p2(aVarW0, 30, new z33.a() { // from class: fx0
            @Override // z33.a
            public final void invoke(Object obj) {
                ((oc) obj).p0(aVarW0, i, z);
            }
        });
    }

    @Override // defpackage.kc
    public final void onDroppedFrames(final int i, final long j) {
        final oc.a aVarB1 = b1();
        p2(aVarB1, 1018, new z33.a() { // from class: ny0
            @Override // z33.a
            public final void invoke(Object obj) {
                ((oc) obj).q0(aVarB1, i, j);
            }
        });
    }

    @Override // com.google.android.exoplayer2.v.d
    public final void onIsLoadingChanged(final boolean z) {
        final oc.a aVarW0 = W0();
        p2(aVarW0, 3, new z33.a() { // from class: xz0
            @Override // z33.a
            public final void invoke(Object obj) {
                b21.D1(aVarW0, z, (oc) obj);
            }
        });
    }

    @Override // com.google.android.exoplayer2.v.d
    public void onIsPlayingChanged(final boolean z) {
        final oc.a aVarW0 = W0();
        p2(aVarW0, 7, new z33.a() { // from class: dy0
            @Override // z33.a
            public final void invoke(Object obj) {
                ((oc) obj).a(aVarW0, z);
            }
        });
    }

    @Override // com.google.android.exoplayer2.v.d
    public final void onPlayWhenReadyChanged(final boolean z, final int i) {
        final oc.a aVarW0 = W0();
        p2(aVarW0, 5, new z33.a() { // from class: fz0
            @Override // z33.a
            public final void invoke(Object obj) {
                ((oc) obj).s0(aVarW0, z, i);
            }
        });
    }

    @Override // com.google.android.exoplayer2.v.d
    public final void onPlaybackStateChanged(final int i) {
        final oc.a aVarW0 = W0();
        p2(aVarW0, 4, new z33.a() { // from class: oz0
            @Override // z33.a
            public final void invoke(Object obj) {
                ((oc) obj).o(aVarW0, i);
            }
        });
    }

    @Override // com.google.android.exoplayer2.v.d
    public final void onPlaybackSuppressionReasonChanged(final int i) {
        final oc.a aVarW0 = W0();
        p2(aVarW0, 6, new z33.a() { // from class: jy0
            @Override // z33.a
            public final void invoke(Object obj) {
                ((oc) obj).G(aVarW0, i);
            }
        });
    }

    @Override // com.google.android.exoplayer2.v.d
    public final void onPlayerStateChanged(final boolean z, final int i) {
        final oc.a aVarW0 = W0();
        p2(aVarW0, -1, new z33.a() { // from class: ly0
            @Override // z33.a
            public final void invoke(Object obj) {
                ((oc) obj).u(aVarW0, z, i);
            }
        });
    }

    @Override // com.google.android.exoplayer2.v.d
    public void onRenderedFirstFrame() {
    }

    @Override // com.google.android.exoplayer2.v.d
    public final void onRepeatModeChanged(final int i) {
        final oc.a aVarW0 = W0();
        p2(aVarW0, 8, new z33.a() { // from class: zy0
            @Override // z33.a
            public final void invoke(Object obj) {
                ((oc) obj).e0(aVarW0, i);
            }
        });
    }

    @Override // com.google.android.exoplayer2.v.d
    public final void onShuffleModeEnabledChanged(final boolean z) {
        final oc.a aVarW0 = W0();
        p2(aVarW0, 9, new z33.a() { // from class: dx0
            @Override // z33.a
            public final void invoke(Object obj) {
                ((oc) obj).m(aVarW0, z);
            }
        });
    }

    @Override // com.google.android.exoplayer2.v.d
    public final void onSkipSilenceEnabledChanged(final boolean z) {
        final oc.a aVarC1 = c1();
        p2(aVarC1, 23, new z33.a() { // from class: h11
            @Override // z33.a
            public final void invoke(Object obj) {
                ((oc) obj).L(aVarC1, z);
            }
        });
    }

    @Override // com.google.android.exoplayer2.v.d
    public final void onSurfaceSizeChanged(final int i, final int i2) {
        final oc.a aVarC1 = c1();
        p2(aVarC1, 24, new z33.a() { // from class: dz0
            @Override // z33.a
            public final void invoke(Object obj) {
                ((oc) obj).e(aVarC1, i, i2);
            }
        });
    }

    @Override // defpackage.kc
    public final void onVideoCodecError(final Exception exc) {
        final oc.a aVarC1 = c1();
        p2(aVarC1, 1030, new z33.a() { // from class: g11
            @Override // z33.a
            public final void invoke(Object obj) {
                ((oc) obj).f0(aVarC1, exc);
            }
        });
    }

    @Override // defpackage.kc
    public final void onVideoDecoderInitialized(final String str, final long j, final long j2) {
        final oc.a aVarC1 = c1();
        p2(aVarC1, 1016, new z33.a() { // from class: z11
            @Override // z33.a
            public final void invoke(Object obj) {
                b21.e2(aVarC1, str, j2, j, (oc) obj);
            }
        });
    }

    @Override // defpackage.kc
    public final void onVideoDecoderReleased(final String str) {
        final oc.a aVarC1 = c1();
        p2(aVarC1, 1019, new z33.a() { // from class: bx0
            @Override // z33.a
            public final void invoke(Object obj) {
                ((oc) obj).i0(aVarC1, str);
            }
        });
    }

    @Override // defpackage.kc
    public final void onVideoFrameProcessingOffset(final long j, final int i) {
        final oc.a aVarB1 = b1();
        p2(aVarB1, 1021, new z33.a() { // from class: v11
            @Override // z33.a
            public final void invoke(Object obj) {
                ((oc) obj).N(aVarB1, j, i);
            }
        });
    }

    @Override // com.google.android.exoplayer2.v.d
    public final void onVolumeChanged(final float f) {
        final oc.a aVarC1 = c1();
        p2(aVarC1, 22, new z33.a() { // from class: sy0
            @Override // z33.a
            public final void invoke(Object obj) {
                ((oc) obj).l0(aVarC1, f);
            }
        });
    }

    @Override // com.google.android.exoplayer2.v.d
    public void p(@Nullable final PlaybackException playbackException) {
        final oc.a aVarD1 = d1(playbackException);
        p2(aVarD1, 10, new z33.a() { // from class: yw0
            @Override // z33.a
            public final void invoke(Object obj) {
                ((oc) obj).h(aVarD1, playbackException);
            }
        });
    }

    public final void p2(oc.a aVar, int i, z33.a<oc> aVar2) {
        this.e.put(i, aVar);
        this.f.l(i, aVar2);
    }

    @Override // com.google.android.exoplayer2.source.j
    public final void q(int i, @Nullable i.b bVar, final m43 m43Var, final kh3 kh3Var) {
        final oc.a aVarA1 = a1(i, bVar);
        p2(aVarA1, 1001, new z33.a() { // from class: n01
            @Override // z33.a
            public final void invoke(Object obj) {
                ((oc) obj).k0(aVarA1, m43Var, kh3Var);
            }
        });
    }

    @Override // com.google.android.exoplayer2.v.d
    public void r(final k06 k06Var) {
        final oc.a aVarW0 = W0();
        p2(aVarW0, 19, new z33.a() { // from class: r01
            @Override // z33.a
            public final void invoke(Object obj) {
                ((oc) obj).y(aVarW0, k06Var);
            }
        });
    }

    @Override // defpackage.kc
    @CallSuper
    public void release() {
        ((mg2) vh.i(this.h)).post(new Runnable() { // from class: jx0
            @Override // java.lang.Runnable
            public final void run() {
                this.f18528a.o2();
            }
        });
    }

    @Override // com.google.android.exoplayer2.v.d
    public final void s(final PlaybackException playbackException) {
        final oc.a aVarD1 = d1(playbackException);
        p2(aVarD1, 10, new z33.a() { // from class: lx0
            @Override // z33.a
            public final void invoke(Object obj) {
                ((oc) obj).T(aVarD1, playbackException);
            }
        });
    }

    @Override // com.google.android.exoplayer2.drm.b
    public final void t(int i, @Nullable i.b bVar) {
        final oc.a aVarA1 = a1(i, bVar);
        p2(aVarA1, 1023, new z33.a() { // from class: v01
            @Override // z33.a
            public final void invoke(Object obj) {
                ((oc) obj).I(aVarA1);
            }
        });
    }

    @Override // com.google.android.exoplayer2.drm.b
    public final void u(int i, @Nullable i.b bVar, final int i2) {
        final oc.a aVarA1 = a1(i, bVar);
        p2(aVarA1, 1022, new z33.a() { // from class: vz0
            @Override // z33.a
            public final void invoke(Object obj) {
                b21.z1(aVarA1, i2, (oc) obj);
            }
        });
    }

    @Override // com.google.android.exoplayer2.drm.b
    public final void v(int i, @Nullable i.b bVar) {
        final oc.a aVarA1 = a1(i, bVar);
        p2(aVarA1, 1025, new z33.a() { // from class: e11
            @Override // z33.a
            public final void invoke(Object obj) {
                ((oc) obj).u0(aVarA1);
            }
        });
    }

    @Override // com.google.android.exoplayer2.v.d
    public void w(final v.b bVar) {
        final oc.a aVarW0 = W0();
        p2(aVarW0, 13, new z33.a() { // from class: bz0
            @Override // z33.a
            public final void invoke(Object obj) {
                ((oc) obj).C(aVarW0, bVar);
            }
        });
    }

    @Override // com.google.android.exoplayer2.v.d
    public void x(final com.google.android.exoplayer2.i iVar) {
        final oc.a aVarW0 = W0();
        p2(aVarW0, 29, new z33.a() { // from class: ax0
            @Override // z33.a
            public final void invoke(Object obj) {
                ((oc) obj).z(aVarW0, iVar);
            }
        });
    }

    @Override // com.google.android.exoplayer2.drm.b
    public final void y(int i, @Nullable i.b bVar) {
        final oc.a aVarA1 = a1(i, bVar);
        p2(aVarA1, 1026, new z33.a() { // from class: b11
            @Override // z33.a
            public final void invoke(Object obj) {
                ((oc) obj).n(aVarA1);
            }
        });
    }

    @Override // com.google.android.exoplayer2.drm.b
    public /* synthetic */ void z(int i, i.b bVar) {
        fh1.a(this, i, bVar);
    }

    @Override // defpackage.kc
    public final void onRenderedFirstFrame(final Object obj, final long j) {
        final oc.a aVarC1 = c1();
        p2(aVarC1, 26, new z33.a() { // from class: t01
            @Override // z33.a
            public final void invoke(Object obj2) {
                ((oc) obj2).S(aVarC1, obj, j);
            }
        });
    }

    @Override // com.google.android.exoplayer2.v.d
    public void onLoadingChanged(boolean z) {
    }

    @Override // com.google.android.exoplayer2.v.d
    public void onPositionDiscontinuity(int i) {
    }

    public static /* synthetic */ void e1(oc ocVar, qx1 qx1Var) {
    }

    @Override // com.google.android.exoplayer2.v.d
    public void D(v vVar, v.c cVar) {
    }
}
