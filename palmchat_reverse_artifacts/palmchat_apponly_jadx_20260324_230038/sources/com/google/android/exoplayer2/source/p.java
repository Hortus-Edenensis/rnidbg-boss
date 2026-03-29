package com.google.android.exoplayer2.source;

import androidx.annotation.CallSuper;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.b;
import com.google.android.exoplayer2.drm.c;
import com.google.android.exoplayer2.source.p;
import defpackage.c06;
import defpackage.f12;
import defpackage.fp3;
import defpackage.g86;
import defpackage.gc4;
import defpackage.pg5;
import defpackage.ru0;
import defpackage.vh;
import defpackage.w9;
import defpackage.y53;
import defpackage.ym0;
import defpackage.zz5;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public class p implements c06 {

    @Nullable
    public com.google.android.exoplayer2.m A;

    @Nullable
    public com.google.android.exoplayer2.m B;
    public long C;
    public boolean D;
    public boolean E;
    public long F;
    public boolean G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f5982a;

    @Nullable
    public final com.google.android.exoplayer2.drm.c d;

    @Nullable
    public final b.a e;

    @Nullable
    public d f;

    @Nullable
    public com.google.android.exoplayer2.m g;

    @Nullable
    public DrmSession h;
    public int p;
    public int q;
    public int r;
    public int s;
    public boolean w;
    public boolean z;
    public final b b = new b();
    public int i = 1000;
    public long[] j = new long[1000];
    public long[] k = new long[1000];
    public long[] n = new long[1000];
    public int[] m = new int[1000];
    public int[] l = new int[1000];
    public c06.a[] o = new c06.a[1000];
    public final pg5<c> c = new pg5<>(new ym0() { // from class: c25
        @Override // defpackage.ym0
        public final void accept(Object obj) {
            p.L((p.c) obj);
        }
    });
    public long t = Long.MIN_VALUE;
    public long u = Long.MIN_VALUE;
    public long v = Long.MIN_VALUE;
    public boolean y = true;
    public boolean x = true;

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f5983a;
        public long b;

        @Nullable
        public c06.a c;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.google.android.exoplayer2.m f5984a;
        public final c.b b;

        public c(com.google.android.exoplayer2.m mVar, c.b bVar) {
            this.f5984a = mVar;
            this.b = bVar;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d {
        void c(com.google.android.exoplayer2.m mVar);
    }

    public p(w9 w9Var, @Nullable com.google.android.exoplayer2.drm.c cVar, @Nullable b.a aVar) {
        this.d = cVar;
        this.e = aVar;
        this.f5982a = new o(w9Var);
    }

    public static /* synthetic */ void L(c cVar) {
        cVar.b.release();
    }

    public static p k(w9 w9Var, com.google.android.exoplayer2.drm.c cVar, b.a aVar) {
        return new p(w9Var, (com.google.android.exoplayer2.drm.c) vh.e(cVar), (b.a) vh.e(aVar));
    }

    public static p l(w9 w9Var) {
        return new p(w9Var, null, null);
    }

    public final synchronized long A() {
        return Math.max(this.u, B(this.s));
    }

    public final long B(int i) {
        long jMax = Long.MIN_VALUE;
        if (i == 0) {
            return Long.MIN_VALUE;
        }
        int iD = D(i - 1);
        for (int i2 = 0; i2 < i; i2++) {
            jMax = Math.max(jMax, this.n[iD]);
            if ((this.m[iD] & 1) != 0) {
                break;
            }
            iD--;
            if (iD == -1) {
                iD = this.i - 1;
            }
        }
        return jMax;
    }

    public final int C() {
        return this.q + this.s;
    }

    public final int D(int i) {
        int i2 = this.r + i;
        int i3 = this.i;
        return i2 < i3 ? i2 : i2 - i3;
    }

    public final synchronized int E(long j, boolean z) {
        int iD = D(this.s);
        if (H() && j >= this.n[iD]) {
            if (j > this.v && z) {
                return this.p - this.s;
            }
            int iV = v(iD, this.p - this.s, j, true);
            if (iV == -1) {
                return 0;
            }
            return iV;
        }
        return 0;
    }

    @Nullable
    public final synchronized com.google.android.exoplayer2.m F() {
        return this.y ? null : this.B;
    }

    public final int G() {
        return this.q + this.p;
    }

    public final boolean H() {
        return this.s != this.p;
    }

    public final void I() {
        this.z = true;
    }

    public final synchronized boolean J() {
        return this.w;
    }

    @CallSuper
    public synchronized boolean K(boolean z) {
        com.google.android.exoplayer2.m mVar;
        boolean z2 = true;
        if (H()) {
            if (this.c.e(C()).f5984a != this.g) {
                return true;
            }
            return M(D(this.s));
        }
        if (!z && !this.w && ((mVar = this.B) == null || mVar == this.g)) {
            z2 = false;
        }
        return z2;
    }

    public final boolean M(int i) {
        DrmSession drmSession = this.h;
        return drmSession == null || drmSession.getState() == 4 || ((this.m[i] & 1073741824) == 0 && this.h.playClearSamplesWithoutKeys());
    }

    @CallSuper
    public void N() throws IOException {
        DrmSession drmSession = this.h;
        if (drmSession != null && drmSession.getState() == 1) {
            throw ((DrmSession.DrmSessionException) vh.e(this.h.getError()));
        }
    }

    public final void O(com.google.android.exoplayer2.m mVar, f12 f12Var) {
        com.google.android.exoplayer2.m mVar2 = this.g;
        boolean z = mVar2 == null;
        DrmInitData drmInitData = z ? null : mVar2.o;
        this.g = mVar;
        DrmInitData drmInitData2 = mVar.o;
        com.google.android.exoplayer2.drm.c cVar = this.d;
        f12Var.b = cVar != null ? mVar.c(cVar.d(mVar)) : mVar;
        f12Var.f17409a = this.h;
        if (this.d == null) {
            return;
        }
        if (z || !g86.c(drmInitData, drmInitData2)) {
            DrmSession drmSession = this.h;
            DrmSession drmSessionB = this.d.b(this.e, mVar);
            this.h = drmSessionB;
            f12Var.f17409a = drmSessionB;
            if (drmSession != null) {
                drmSession.a(this.e);
            }
        }
    }

    public final synchronized int P(f12 f12Var, DecoderInputBuffer decoderInputBuffer, boolean z, boolean z2, b bVar) {
        decoderInputBuffer.d = false;
        if (!H()) {
            if (!z2 && !this.w) {
                com.google.android.exoplayer2.m mVar = this.B;
                if (mVar == null || (!z && mVar == this.g)) {
                    return -3;
                }
                O((com.google.android.exoplayer2.m) vh.e(mVar), f12Var);
                return -5;
            }
            decoderInputBuffer.k(4);
            return -4;
        }
        com.google.android.exoplayer2.m mVar2 = this.c.e(C()).f5984a;
        if (!z && mVar2 == this.g) {
            int iD = D(this.s);
            if (!M(iD)) {
                decoderInputBuffer.d = true;
                return -3;
            }
            decoderInputBuffer.k(this.m[iD]);
            if (this.s == this.p - 1 && (z2 || this.w)) {
                decoderInputBuffer.a(536870912);
            }
            long j = this.n[iD];
            decoderInputBuffer.e = j;
            if (j < this.t) {
                decoderInputBuffer.a(Integer.MIN_VALUE);
            }
            bVar.f5983a = this.l[iD];
            bVar.b = this.k[iD];
            bVar.c = this.o[iD];
            return -4;
        }
        O(mVar2, f12Var);
        return -5;
    }

    public final synchronized long Q() {
        return H() ? this.j[D(this.s)] : this.C;
    }

    @CallSuper
    public void R() {
        r();
        U();
    }

    @CallSuper
    public int S(f12 f12Var, DecoderInputBuffer decoderInputBuffer, int i, boolean z) {
        int iP = P(f12Var, decoderInputBuffer, (i & 2) != 0, z, this.b);
        if (iP == -4 && !decoderInputBuffer.g()) {
            boolean z2 = (i & 1) != 0;
            if ((i & 4) == 0) {
                if (z2) {
                    this.f5982a.f(decoderInputBuffer, this.b);
                } else {
                    this.f5982a.m(decoderInputBuffer, this.b);
                }
            }
            if (!z2) {
                this.s++;
            }
        }
        return iP;
    }

    @CallSuper
    public void T() {
        W(true);
        U();
    }

    public final void U() {
        DrmSession drmSession = this.h;
        if (drmSession != null) {
            drmSession.a(this.e);
            this.h = null;
            this.g = null;
        }
    }

    public final void V() {
        W(false);
    }

    @CallSuper
    public void W(boolean z) {
        this.f5982a.n();
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.x = true;
        this.t = Long.MIN_VALUE;
        this.u = Long.MIN_VALUE;
        this.v = Long.MIN_VALUE;
        this.w = false;
        this.c.b();
        if (z) {
            this.A = null;
            this.B = null;
            this.y = true;
        }
    }

    public final synchronized void X() {
        this.s = 0;
        this.f5982a.o();
    }

    public final synchronized boolean Y(int i) {
        X();
        int i2 = this.q;
        if (i >= i2 && i <= this.p + i2) {
            this.t = Long.MIN_VALUE;
            this.s = i - i2;
            return true;
        }
        return false;
    }

    public final synchronized boolean Z(long j, boolean z) {
        X();
        int iD = D(this.s);
        if (H() && j >= this.n[iD] && (j <= this.v || z)) {
            int iV = v(iD, this.p - this.s, j, true);
            if (iV == -1) {
                return false;
            }
            this.t = j;
            this.s += iV;
            return true;
        }
        return false;
    }

    @Override // defpackage.c06
    public final void a(gc4 gc4Var, int i, int i2) {
        this.f5982a.q(gc4Var, i);
    }

    public final void a0(long j) {
        if (this.F != j) {
            this.F = j;
            I();
        }
    }

    @Override // defpackage.c06
    public final void b(com.google.android.exoplayer2.m mVar) {
        com.google.android.exoplayer2.m mVarW = w(mVar);
        this.z = false;
        this.A = mVar;
        boolean zC0 = c0(mVarW);
        d dVar = this.f;
        if (dVar == null || !zC0) {
            return;
        }
        dVar.c(mVarW);
    }

    public final void b0(long j) {
        this.t = j;
    }

    @Override // defpackage.c06
    public /* synthetic */ int c(ru0 ru0Var, int i, boolean z) {
        return zz5.a(this, ru0Var, i, z);
    }

    public final synchronized boolean c0(com.google.android.exoplayer2.m mVar) {
        this.y = false;
        if (g86.c(mVar, this.B)) {
            return false;
        }
        if (this.c.g() || !this.c.f().f5984a.equals(mVar)) {
            this.B = mVar;
        } else {
            this.B = this.c.f().f5984a;
        }
        com.google.android.exoplayer2.m mVar2 = this.B;
        this.D = fp3.a(mVar2.l, mVar2.i);
        this.E = false;
        return true;
    }

    @Override // defpackage.c06
    public /* synthetic */ void d(gc4 gc4Var, int i) {
        zz5.b(this, gc4Var, i);
    }

    public final void d0(@Nullable d dVar) {
        this.f = dVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0054  */
    @Override // defpackage.c06
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e(long j, int i, int i2, int i3, @Nullable c06.a aVar) {
        int i4;
        if (this.z) {
            b((com.google.android.exoplayer2.m) vh.i(this.A));
        }
        int i5 = i & 1;
        boolean z = i5 != 0;
        if (this.x) {
            if (!z) {
                return;
            } else {
                this.x = false;
            }
        }
        long j2 = this.F + j;
        if (!this.D) {
            i4 = i;
        } else {
            if (j2 < this.t) {
                return;
            }
            if (i5 == 0) {
                if (!this.E) {
                    y53.i("SampleQueue", "Overriding unexpected non-sync sample for format: " + this.B);
                    this.E = true;
                }
                i4 = i | 1;
            }
        }
        if (this.G) {
            if (!z || !h(j2)) {
                return;
            } else {
                this.G = false;
            }
        }
        i(j2, i4, (this.f5982a.e() - ((long) i2)) - ((long) i3), i2, aVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x000e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void e0(int i) {
        boolean z;
        if (i >= 0) {
            try {
                z = this.s + i <= this.p;
            } catch (Throwable th) {
                throw th;
            }
        }
        vh.a(z);
        this.s += i;
    }

    @Override // defpackage.c06
    public final int f(ru0 ru0Var, int i, boolean z, int i2) throws IOException {
        return this.f5982a.p(ru0Var, i, z);
    }

    public final void f0(long j) {
        this.C = j;
    }

    public final void g0() {
        this.G = true;
    }

    public final synchronized boolean h(long j) {
        if (this.p == 0) {
            return j > this.u;
        }
        if (A() >= j) {
            return false;
        }
        t(this.q + j(j));
        return true;
    }

    public final synchronized void i(long j, int i, long j2, int i2, @Nullable c06.a aVar) {
        int i3 = this.p;
        if (i3 > 0) {
            int iD = D(i3 - 1);
            vh.a(this.k[iD] + ((long) this.l[iD]) <= j2);
        }
        this.w = (536870912 & i) != 0;
        this.v = Math.max(this.v, j);
        int iD2 = D(this.p);
        this.n[iD2] = j;
        this.k[iD2] = j2;
        this.l[iD2] = i2;
        this.m[iD2] = i;
        this.o[iD2] = aVar;
        this.j[iD2] = this.C;
        if (this.c.g() || !this.c.f().f5984a.equals(this.B)) {
            com.google.android.exoplayer2.drm.c cVar = this.d;
            this.c.a(G(), new c((com.google.android.exoplayer2.m) vh.e(this.B), cVar != null ? cVar.c(this.e, this.B) : c.b.f5862a));
        }
        int i4 = this.p + 1;
        this.p = i4;
        int i5 = this.i;
        if (i4 == i5) {
            int i6 = i5 + 1000;
            long[] jArr = new long[i6];
            long[] jArr2 = new long[i6];
            long[] jArr3 = new long[i6];
            int[] iArr = new int[i6];
            int[] iArr2 = new int[i6];
            c06.a[] aVarArr = new c06.a[i6];
            int i7 = this.r;
            int i8 = i5 - i7;
            System.arraycopy(this.k, i7, jArr2, 0, i8);
            System.arraycopy(this.n, this.r, jArr3, 0, i8);
            System.arraycopy(this.m, this.r, iArr, 0, i8);
            System.arraycopy(this.l, this.r, iArr2, 0, i8);
            System.arraycopy(this.o, this.r, aVarArr, 0, i8);
            System.arraycopy(this.j, this.r, jArr, 0, i8);
            int i9 = this.r;
            System.arraycopy(this.k, 0, jArr2, i8, i9);
            System.arraycopy(this.n, 0, jArr3, i8, i9);
            System.arraycopy(this.m, 0, iArr, i8, i9);
            System.arraycopy(this.l, 0, iArr2, i8, i9);
            System.arraycopy(this.o, 0, aVarArr, i8, i9);
            System.arraycopy(this.j, 0, jArr, i8, i9);
            this.k = jArr2;
            this.n = jArr3;
            this.m = iArr;
            this.l = iArr2;
            this.o = aVarArr;
            this.j = jArr;
            this.r = 0;
            this.i = i6;
        }
    }

    public final int j(long j) {
        int i = this.p;
        int iD = D(i - 1);
        while (i > this.s && this.n[iD] >= j) {
            i--;
            iD--;
            if (iD == -1) {
                iD = this.i - 1;
            }
        }
        return i;
    }

    public final synchronized long m(long j, boolean z, boolean z2) {
        int i;
        int i2 = this.p;
        if (i2 != 0) {
            long[] jArr = this.n;
            int i3 = this.r;
            if (j >= jArr[i3]) {
                if (z2 && (i = this.s) != i2) {
                    i2 = i + 1;
                }
                int iV = v(i3, i2, j, z);
                if (iV == -1) {
                    return -1L;
                }
                return p(iV);
            }
        }
        return -1L;
    }

    public final synchronized long n() {
        int i = this.p;
        if (i == 0) {
            return -1L;
        }
        return p(i);
    }

    public synchronized long o() {
        int i = this.s;
        if (i == 0) {
            return -1L;
        }
        return p(i);
    }

    @GuardedBy("this")
    public final long p(int i) {
        this.u = Math.max(this.u, B(i));
        this.p -= i;
        int i2 = this.q + i;
        this.q = i2;
        int i3 = this.r + i;
        this.r = i3;
        int i4 = this.i;
        if (i3 >= i4) {
            this.r = i3 - i4;
        }
        int i5 = this.s - i;
        this.s = i5;
        if (i5 < 0) {
            this.s = 0;
        }
        this.c.d(i2);
        if (this.p != 0) {
            return this.k[this.r];
        }
        int i6 = this.r;
        if (i6 == 0) {
            i6 = this.i;
        }
        int i7 = i6 - 1;
        return this.k[i7] + ((long) this.l[i7]);
    }

    public final void q(long j, boolean z, boolean z2) {
        this.f5982a.b(m(j, z, z2));
    }

    public final void r() {
        this.f5982a.b(n());
    }

    public final void s() {
        this.f5982a.b(o());
    }

    public final long t(int i) {
        int iG = G() - i;
        boolean z = false;
        vh.a(iG >= 0 && iG <= this.p - this.s);
        int i2 = this.p - iG;
        this.p = i2;
        this.v = Math.max(this.u, B(i2));
        if (iG == 0 && this.w) {
            z = true;
        }
        this.w = z;
        this.c.c(i);
        int i3 = this.p;
        if (i3 == 0) {
            return 0L;
        }
        int iD = D(i3 - 1);
        return this.k[iD] + ((long) this.l[iD]);
    }

    public final void u(int i) {
        this.f5982a.c(t(i));
    }

    public final int v(int i, int i2, long j, boolean z) {
        int i3 = -1;
        for (int i4 = 0; i4 < i2; i4++) {
            long j2 = this.n[i];
            if (j2 > j) {
                return i3;
            }
            if (!z || (this.m[i] & 1) != 0) {
                if (j2 == j) {
                    return i4;
                }
                i3 = i4;
            }
            i++;
            if (i == this.i) {
                i = 0;
            }
        }
        return i3;
    }

    @CallSuper
    public com.google.android.exoplayer2.m w(com.google.android.exoplayer2.m mVar) {
        return (this.F == 0 || mVar.p == Long.MAX_VALUE) ? mVar : mVar.b().k0(mVar.p + this.F).G();
    }

    public final int x() {
        return this.q;
    }

    public final synchronized long y() {
        return this.p == 0 ? Long.MIN_VALUE : this.n[this.r];
    }

    public final synchronized long z() {
        return this.v;
    }
}
