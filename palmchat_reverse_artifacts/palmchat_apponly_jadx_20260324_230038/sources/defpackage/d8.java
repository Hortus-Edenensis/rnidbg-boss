package defpackage;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.m;
import defpackage.f0;
import defpackage.j26;
import java.util.Arrays;
import java.util.Collections;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class d8 implements gl1 {
    public static final byte[] v = {73, 68, 51};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f16993a;
    public final fc4 b;
    public final gc4 c;

    @Nullable
    public final String d;
    public String e;
    public c06 f;
    public c06 g;
    public int h;
    public int i;
    public int j;
    public boolean k;
    public boolean l;
    public int m;
    public int n;
    public int o;
    public boolean p;
    public long q;
    public int r;
    public long s;
    public c06 t;
    public long u;

    public d8(boolean z) {
        this(z, null);
    }

    public static boolean j(int i) {
        return (i & 65526) == 65520;
    }

    @Override // defpackage.gl1
    public void a(gc4 gc4Var) throws ParserException {
        c();
        while (gc4Var.a() > 0) {
            int i = this.h;
            if (i == 0) {
                g(gc4Var);
            } else if (i == 1) {
                d(gc4Var);
            } else if (i != 2) {
                if (i == 3) {
                    if (f(gc4Var, this.b.f17507a, this.k ? 7 : 5)) {
                        k();
                    }
                } else {
                    if (i != 4) {
                        throw new IllegalStateException();
                    }
                    m(gc4Var);
                }
            } else if (f(gc4Var, this.c.e(), 10)) {
                l();
            }
        }
    }

    @Override // defpackage.gl1
    public void b(qs1 qs1Var, j26.d dVar) {
        dVar.a();
        this.e = dVar.b();
        c06 c06VarTrack = qs1Var.track(dVar.c(), 1);
        this.f = c06VarTrack;
        this.t = c06VarTrack;
        if (!this.f16993a) {
            this.g = new pi1();
            return;
        }
        dVar.a();
        c06 c06VarTrack2 = qs1Var.track(dVar.c(), 5);
        this.g = c06VarTrack2;
        c06VarTrack2.b(new m.b().U(dVar.b()).g0("application/id3").G());
    }

    public final void c() {
        vh.e(this.f);
        g86.j(this.t);
        g86.j(this.g);
    }

    public final void d(gc4 gc4Var) {
        if (gc4Var.a() == 0) {
            return;
        }
        this.b.f17507a[0] = gc4Var.e()[gc4Var.f()];
        this.b.p(2);
        int iH = this.b.h(4);
        int i = this.n;
        if (i != -1 && iH != i) {
            n();
            return;
        }
        if (!this.l) {
            this.l = true;
            this.m = this.o;
            this.n = iH;
        }
        q();
    }

    public final boolean e(gc4 gc4Var, int i) {
        gc4Var.U(i + 1);
        if (!t(gc4Var, this.b.f17507a, 1)) {
            return false;
        }
        this.b.p(4);
        int iH = this.b.h(1);
        int i2 = this.m;
        if (i2 != -1 && iH != i2) {
            return false;
        }
        if (this.n != -1) {
            if (!t(gc4Var, this.b.f17507a, 1)) {
                return true;
            }
            this.b.p(2);
            if (this.b.h(4) != this.n) {
                return false;
            }
            gc4Var.U(i + 2);
        }
        if (!t(gc4Var, this.b.f17507a, 4)) {
            return true;
        }
        this.b.p(14);
        int iH2 = this.b.h(13);
        if (iH2 < 7) {
            return false;
        }
        byte[] bArrE = gc4Var.e();
        int iG = gc4Var.g();
        int i3 = i + iH2;
        if (i3 >= iG) {
            return true;
        }
        byte b = bArrE[i3];
        if (b == -1) {
            int i4 = i3 + 1;
            if (i4 == iG) {
                return true;
            }
            return i((byte) -1, bArrE[i4]) && ((bArrE[i4] & 8) >> 3) == iH;
        }
        if (b != 73) {
            return false;
        }
        int i5 = i3 + 1;
        if (i5 == iG) {
            return true;
        }
        if (bArrE[i5] != 68) {
            return false;
        }
        int i6 = i3 + 2;
        return i6 == iG || bArrE[i6] == 51;
    }

    public final boolean f(gc4 gc4Var, byte[] bArr, int i) {
        int iMin = Math.min(gc4Var.a(), i - this.i);
        gc4Var.l(bArr, this.i, iMin);
        int i2 = this.i + iMin;
        this.i = i2;
        return i2 == i;
    }

    public final void g(gc4 gc4Var) {
        byte[] bArrE = gc4Var.e();
        int iF = gc4Var.f();
        int iG = gc4Var.g();
        while (iF < iG) {
            int i = iF + 1;
            int i2 = bArrE[iF] & UByte.MAX_VALUE;
            if (this.j == 512 && i((byte) -1, (byte) i2) && (this.l || e(gc4Var, i - 2))) {
                this.o = (i2 & 8) >> 3;
                this.k = (i2 & 1) == 0;
                if (this.l) {
                    q();
                } else {
                    o();
                }
                gc4Var.U(i);
                return;
            }
            int i3 = this.j;
            int i4 = i2 | i3;
            if (i4 == 329) {
                this.j = 768;
            } else if (i4 == 511) {
                this.j = 512;
            } else if (i4 == 836) {
                this.j = 1024;
            } else if (i4 == 1075) {
                r();
                gc4Var.U(i);
                return;
            } else if (i3 != 256) {
                this.j = 256;
                i--;
            }
            iF = i;
        }
        gc4Var.U(iF);
    }

    public long h() {
        return this.q;
    }

    public final boolean i(byte b, byte b2) {
        return j(((b & UByte.MAX_VALUE) << 8) | (b2 & UByte.MAX_VALUE));
    }

    public final void k() throws ParserException {
        this.b.p(0);
        if (this.p) {
            this.b.r(10);
        } else {
            int iH = this.b.h(2) + 1;
            if (iH != 2) {
                y53.i("AdtsReader", "Detected audio object type: " + iH + ", but assuming AAC LC.");
                iH = 2;
            }
            this.b.r(5);
            byte[] bArrA = f0.a(iH, this.n, this.b.h(3));
            f0.b bVarE = f0.e(bArrA);
            m mVarG = new m.b().U(this.e).g0("audio/mp4a-latm").K(bVarE.c).J(bVarE.b).h0(bVarE.f17401a).V(Collections.singletonList(bArrA)).X(this.d).G();
            this.q = 1024000000 / ((long) mVarG.z);
            this.f.b(mVarG);
            this.p = true;
        }
        this.b.r(4);
        int iH2 = (this.b.h(13) - 2) - 5;
        if (this.k) {
            iH2 -= 2;
        }
        s(this.f, this.q, 0, iH2);
    }

    public final void l() {
        this.g.d(this.c, 10);
        this.c.U(6);
        s(this.g, 0L, 10, this.c.G() + 10);
    }

    public final void m(gc4 gc4Var) {
        int iMin = Math.min(gc4Var.a(), this.r - this.i);
        this.t.d(gc4Var, iMin);
        int i = this.i + iMin;
        this.i = i;
        int i2 = this.r;
        if (i == i2) {
            long j = this.s;
            if (j != -9223372036854775807L) {
                this.t.e(j, 1, i2, 0, null);
                this.s += this.u;
            }
            p();
        }
    }

    public final void n() {
        this.l = false;
        p();
    }

    public final void o() {
        this.h = 1;
        this.i = 0;
    }

    public final void p() {
        this.h = 0;
        this.i = 0;
        this.j = 256;
    }

    @Override // defpackage.gl1
    public void packetStarted(long j, int i) {
        if (j != -9223372036854775807L) {
            this.s = j;
        }
    }

    public final void q() {
        this.h = 3;
        this.i = 0;
    }

    public final void r() {
        this.h = 2;
        this.i = v.length;
        this.r = 0;
        this.c.U(0);
    }

    public final void s(c06 c06Var, long j, int i, int i2) {
        this.h = 4;
        this.i = i;
        this.t = c06Var;
        this.u = j;
        this.r = i2;
    }

    @Override // defpackage.gl1
    public void seek() {
        this.s = -9223372036854775807L;
        n();
    }

    public final boolean t(gc4 gc4Var, byte[] bArr, int i) {
        if (gc4Var.a() < i) {
            return false;
        }
        gc4Var.l(bArr, 0, i);
        return true;
    }

    public d8(boolean z, @Nullable String str) {
        this.b = new fc4(new byte[7]);
        this.c = new gc4(Arrays.copyOf(v, 10));
        p();
        this.m = -1;
        this.n = -1;
        this.q = -9223372036854775807L;
        this.s = -9223372036854775807L;
        this.f16993a = z;
        this.d = str;
    }

    @Override // defpackage.gl1
    public void packetFinished() {
    }
}
