package defpackage;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.a0;
import com.google.android.exoplayer2.e0;
import com.google.android.exoplayer2.s;
import com.google.android.exoplayer2.source.b;
import com.google.android.exoplayer2.source.h;
import com.google.android.exoplayer2.source.i;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class jk3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f18425a;
    public final Object b;
    public final d25[] c;
    public boolean d;
    public boolean e;
    public lk3 f;
    public boolean g;
    public final boolean[] h;
    public final a0[] i;
    public final o06 j;
    public final s k;

    @Nullable
    public jk3 l;
    public vz5 m;
    public p06 n;
    public long o;

    public jk3(a0[] a0VarArr, long j, o06 o06Var, w9 w9Var, s sVar, lk3 lk3Var, p06 p06Var) {
        this.i = a0VarArr;
        this.o = j;
        this.j = o06Var;
        this.k = sVar;
        i.b bVar = lk3Var.f19020a;
        this.b = bVar.f18710a;
        this.f = lk3Var;
        this.m = vz5.d;
        this.n = p06Var;
        this.c = new d25[a0VarArr.length];
        this.h = new boolean[a0VarArr.length];
        this.f18425a = e(bVar, sVar, w9Var, lk3Var.b, lk3Var.d);
    }

    public static h e(i.b bVar, s sVar, w9 w9Var, long j, long j2) {
        h hVarH = sVar.h(bVar, w9Var, j);
        return j2 != -9223372036854775807L ? new b(hVarH, true, 0L, j2) : hVarH;
    }

    public static void u(s sVar, h hVar) {
        try {
            if (hVar instanceof b) {
                sVar.A(((b) hVar).f5933a);
            } else {
                sVar.A(hVar);
            }
        } catch (RuntimeException e) {
            y53.d("MediaPeriodHolder", "Period release failed.", e);
        }
    }

    public void A() {
        h hVar = this.f18425a;
        if (hVar instanceof b) {
            long j = this.f.d;
            if (j == -9223372036854775807L) {
                j = Long.MIN_VALUE;
            }
            ((b) hVar).l(0L, j);
        }
    }

    public long a(p06 p06Var, long j, boolean z) {
        return b(p06Var, j, z, new boolean[this.i.length]);
    }

    public long b(p06 p06Var, long j, boolean z, boolean[] zArr) {
        int i = 0;
        while (true) {
            boolean z2 = true;
            if (i >= p06Var.f19911a) {
                break;
            }
            boolean[] zArr2 = this.h;
            if (z || !p06Var.b(this.n, i)) {
                z2 = false;
            }
            zArr2[i] = z2;
            i++;
        }
        g(this.c);
        f();
        this.n = p06Var;
        h();
        long jB = this.f18425a.b(p06Var.c, this.h, this.c, zArr, j);
        c(this.c);
        this.e = false;
        int i2 = 0;
        while (true) {
            d25[] d25VarArr = this.c;
            if (i2 >= d25VarArr.length) {
                return jB;
            }
            if (d25VarArr[i2] != null) {
                vh.g(p06Var.c(i2));
                if (this.i[i2].getTrackType() != -2) {
                    this.e = true;
                }
            } else {
                vh.g(p06Var.c[i2] == null);
            }
            i2++;
        }
    }

    public final void c(d25[] d25VarArr) {
        int i = 0;
        while (true) {
            a0[] a0VarArr = this.i;
            if (i >= a0VarArr.length) {
                return;
            }
            if (a0VarArr[i].getTrackType() == -2 && this.n.c(i)) {
                d25VarArr[i] = new cm1();
            }
            i++;
        }
    }

    public void d(long j) {
        vh.g(r());
        this.f18425a.continueLoading(y(j));
    }

    public final void f() {
        if (!r()) {
            return;
        }
        int i = 0;
        while (true) {
            p06 p06Var = this.n;
            if (i >= p06Var.f19911a) {
                return;
            }
            boolean zC = p06Var.c(i);
            or1 or1Var = this.n.c[i];
            if (zC && or1Var != null) {
                or1Var.disable();
            }
            i++;
        }
    }

    public final void g(d25[] d25VarArr) {
        int i = 0;
        while (true) {
            a0[] a0VarArr = this.i;
            if (i >= a0VarArr.length) {
                return;
            }
            if (a0VarArr[i].getTrackType() == -2) {
                d25VarArr[i] = null;
            }
            i++;
        }
    }

    public final void h() {
        if (!r()) {
            return;
        }
        int i = 0;
        while (true) {
            p06 p06Var = this.n;
            if (i >= p06Var.f19911a) {
                return;
            }
            boolean zC = p06Var.c(i);
            or1 or1Var = this.n.c[i];
            if (zC && or1Var != null) {
                or1Var.enable();
            }
            i++;
        }
    }

    public long i() {
        if (!this.d) {
            return this.f.b;
        }
        long bufferedPositionUs = this.e ? this.f18425a.getBufferedPositionUs() : Long.MIN_VALUE;
        return bufferedPositionUs == Long.MIN_VALUE ? this.f.e : bufferedPositionUs;
    }

    @Nullable
    public jk3 j() {
        return this.l;
    }

    public long k() {
        if (this.d) {
            return this.f18425a.getNextLoadPositionUs();
        }
        return 0L;
    }

    public long l() {
        return this.o;
    }

    public long m() {
        return this.f.b + this.o;
    }

    public vz5 n() {
        return this.m;
    }

    public p06 o() {
        return this.n;
    }

    public void p(float f, e0 e0Var) throws ExoPlaybackException {
        this.d = true;
        this.m = this.f18425a.getTrackGroups();
        p06 p06VarV = v(f, e0Var);
        lk3 lk3Var = this.f;
        long jMax = lk3Var.b;
        long j = lk3Var.e;
        if (j != -9223372036854775807L && jMax >= j) {
            jMax = Math.max(0L, j - 1);
        }
        long jA = a(p06VarV, jMax, false);
        long j2 = this.o;
        lk3 lk3Var2 = this.f;
        this.o = j2 + (lk3Var2.b - jA);
        this.f = lk3Var2.b(jA);
    }

    public boolean q() {
        return this.d && (!this.e || this.f18425a.getBufferedPositionUs() == Long.MIN_VALUE);
    }

    public final boolean r() {
        return this.l == null;
    }

    public void s(long j) {
        vh.g(r());
        if (this.d) {
            this.f18425a.reevaluateBuffer(y(j));
        }
    }

    public void t() {
        f();
        u(this.k, this.f18425a);
    }

    public p06 v(float f, e0 e0Var) throws ExoPlaybackException {
        p06 p06VarK = this.j.k(this.i, n(), this.f.f19020a, e0Var);
        for (or1 or1Var : p06VarK.c) {
            if (or1Var != null) {
                or1Var.onPlaybackSpeed(f);
            }
        }
        return p06VarK;
    }

    public void w(@Nullable jk3 jk3Var) {
        if (jk3Var == this.l) {
            return;
        }
        f();
        this.l = jk3Var;
        h();
    }

    public void x(long j) {
        this.o = j;
    }

    public long y(long j) {
        return j - l();
    }

    public long z(long j) {
        return j + l();
    }
}
