package defpackage;

import android.util.SparseArray;
import androidx.annotation.Nullable;
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
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public interface oc {

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f19735a;
        public final e0 b;
        public final int c;

        @Nullable
        public final i.b d;
        public final long e;
        public final e0 f;
        public final int g;

        @Nullable
        public final i.b h;
        public final long i;
        public final long j;

        public a(long j, e0 e0Var, int i, @Nullable i.b bVar, long j2, e0 e0Var2, int i2, @Nullable i.b bVar2, long j3, long j4) {
            this.f19735a = j;
            this.b = e0Var;
            this.c = i;
            this.d = bVar;
            this.e = j2;
            this.f = e0Var2;
            this.g = i2;
            this.h = bVar2;
            this.i = j3;
            this.j = j4;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f19735a == aVar.f19735a && this.c == aVar.c && this.e == aVar.e && this.g == aVar.g && this.i == aVar.i && this.j == aVar.j && m54.a(this.b, aVar.b) && m54.a(this.d, aVar.d) && m54.a(this.f, aVar.f) && m54.a(this.h, aVar.h);
        }

        public int hashCode() {
            return m54.b(Long.valueOf(this.f19735a), this.b, Integer.valueOf(this.c), this.d, Long.valueOf(this.e), this.f, Integer.valueOf(this.g), this.h, Long.valueOf(this.i), Long.valueOf(this.j));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final qx1 f19736a;
        public final SparseArray<a> b;

        public b(qx1 qx1Var, SparseArray<a> sparseArray) {
            this.f19736a = qx1Var;
            SparseArray<a> sparseArray2 = new SparseArray<>(qx1Var.d());
            for (int i = 0; i < qx1Var.d(); i++) {
                int iC = qx1Var.c(i);
                sparseArray2.append(iC, (a) vh.e(sparseArray.get(iC)));
            }
            this.b = sparseArray2;
        }

        public boolean a(int i) {
            return this.f19736a.a(i);
        }

        public int b(int i) {
            return this.f19736a.c(i);
        }

        public a c(int i) {
            return (a) vh.e(this.b.get(i));
        }

        public int d() {
            return this.f19736a.d();
        }
    }

    void A(a aVar);

    void B(a aVar, m mVar, @Nullable ow0 ow0Var);

    void C(a aVar, v.b bVar);

    void D(a aVar, @Nullable p pVar, int i);

    void E(a aVar, lw0 lw0Var);

    @Deprecated
    void F(a aVar, boolean z);

    void G(a aVar, int i);

    void H(v vVar, b bVar);

    void I(a aVar);

    void J(a aVar, Exception exc);

    @Deprecated
    void K(a aVar, List<pr0> list);

    void L(a aVar, boolean z);

    void M(a aVar, m43 m43Var, kh3 kh3Var, IOException iOException, boolean z);

    void N(a aVar, long j, int i);

    void O(a aVar, long j);

    void P(a aVar, kh3 kh3Var);

    @Deprecated
    void Q(a aVar, int i, int i2, int i3, float f);

    void R(a aVar, m mVar, @Nullable ow0 ow0Var);

    void S(a aVar, Object obj, long j);

    void T(a aVar, PlaybackException playbackException);

    void U(a aVar, lw0 lw0Var);

    void V(a aVar, xr0 xr0Var);

    void W(a aVar, m43 m43Var, kh3 kh3Var);

    @Deprecated
    void X(a aVar, String str, long j);

    void Y(a aVar, v.e eVar, v.e eVar2, int i);

    void a(a aVar, boolean z);

    void a0(a aVar, String str);

    void b(a aVar, Exception exc);

    void c(a aVar, m43 m43Var, kh3 kh3Var);

    @Deprecated
    void c0(a aVar, m mVar);

    void d(a aVar);

    void d0(a aVar, String str, long j, long j2);

    void e(a aVar, int i, int i2);

    void e0(a aVar, int i);

    void f0(a aVar, Exception exc);

    void g(a aVar, te6 te6Var);

    void g0(a aVar, u uVar);

    void h(a aVar, @Nullable PlaybackException playbackException);

    void h0(a aVar, String str, long j, long j2);

    void i0(a aVar, String str);

    void j(a aVar, f0 f0Var);

    void j0(a aVar, Metadata metadata);

    @Deprecated
    void k(a aVar, int i);

    void k0(a aVar, m43 m43Var, kh3 kh3Var);

    void l(a aVar, q qVar);

    void l0(a aVar, float f);

    void m(a aVar, boolean z);

    void m0(a aVar, int i, long j, long j2);

    void n(a aVar);

    void n0(a aVar, int i, long j, long j2);

    void o(a aVar, int i);

    void o0(a aVar, kh3 kh3Var);

    @Deprecated
    void p(a aVar);

    void p0(a aVar, int i, boolean z);

    @Deprecated
    void q(a aVar);

    void q0(a aVar, int i, long j);

    @Deprecated
    void r(a aVar, m mVar);

    void r0(a aVar, boolean z);

    void s(a aVar, int i);

    void s0(a aVar, boolean z, int i);

    void t(a aVar, lw0 lw0Var);

    void t0(a aVar, Exception exc);

    @Deprecated
    void u(a aVar, boolean z, int i);

    void u0(a aVar);

    @Deprecated
    void v(a aVar, String str, long j);

    void w(a aVar, lw0 lw0Var);

    void x(a aVar, int i);

    void y(a aVar, k06 k06Var);

    void z(a aVar, com.google.android.exoplayer2.i iVar);
}
