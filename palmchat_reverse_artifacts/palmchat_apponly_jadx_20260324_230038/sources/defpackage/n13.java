package defpackage;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.m;
import defpackage.f0;
import defpackage.j26;
import java.util.Collections;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class n13 implements gl1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final String f19413a;
    public final gc4 b;
    public final fc4 c;
    public c06 d;
    public String e;
    public m f;
    public int g;
    public int h;
    public int i;
    public int j;
    public long k;
    public boolean l;
    public int m;
    public int n;
    public int o;
    public boolean p;
    public long q;
    public int r;
    public long s;
    public int t;

    @Nullable
    public String u;

    public n13(@Nullable String str) {
        this.f19413a = str;
        gc4 gc4Var = new gc4(1024);
        this.b = gc4Var;
        this.c = new fc4(gc4Var.e());
        this.k = -9223372036854775807L;
    }

    public static long c(fc4 fc4Var) {
        return fc4Var.h((fc4Var.h(2) + 1) * 8);
    }

    @Override // defpackage.gl1
    public void a(gc4 gc4Var) throws ParserException {
        vh.i(this.d);
        while (gc4Var.a() > 0) {
            int i = this.g;
            if (i != 0) {
                if (i == 1) {
                    int iH = gc4Var.H();
                    if ((iH & 224) == 224) {
                        this.j = iH;
                        this.g = 2;
                    } else if (iH != 86) {
                        this.g = 0;
                    }
                } else if (i == 2) {
                    int iH2 = ((this.j & (-225)) << 8) | gc4Var.H();
                    this.i = iH2;
                    if (iH2 > this.b.e().length) {
                        j(this.i);
                    }
                    this.h = 0;
                    this.g = 3;
                } else {
                    if (i != 3) {
                        throw new IllegalStateException();
                    }
                    int iMin = Math.min(gc4Var.a(), this.i - this.h);
                    gc4Var.l(this.c.f17507a, this.h, iMin);
                    int i2 = this.h + iMin;
                    this.h = i2;
                    if (i2 == this.i) {
                        this.c.p(0);
                        d(this.c);
                        this.g = 0;
                    }
                }
            } else if (gc4Var.H() == 86) {
                this.g = 1;
            }
        }
    }

    @Override // defpackage.gl1
    public void b(qs1 qs1Var, j26.d dVar) {
        dVar.a();
        this.d = qs1Var.track(dVar.c(), 1);
        this.e = dVar.b();
    }

    public final void d(fc4 fc4Var) throws ParserException {
        if (!fc4Var.g()) {
            this.l = true;
            i(fc4Var);
        } else if (!this.l) {
            return;
        }
        if (this.m != 0) {
            throw ParserException.createForMalformedContainer(null, null);
        }
        if (this.n != 0) {
            throw ParserException.createForMalformedContainer(null, null);
        }
        h(fc4Var, g(fc4Var));
        if (this.p) {
            fc4Var.r((int) this.q);
        }
    }

    public final int e(fc4 fc4Var) throws ParserException {
        int iB = fc4Var.b();
        f0.b bVarD = f0.d(fc4Var, true);
        this.u = bVarD.c;
        this.r = bVarD.f17401a;
        this.t = bVarD.b;
        return iB - fc4Var.b();
    }

    public final void f(fc4 fc4Var) {
        int iH = fc4Var.h(3);
        this.o = iH;
        if (iH == 0) {
            fc4Var.r(8);
            return;
        }
        if (iH == 1) {
            fc4Var.r(9);
            return;
        }
        if (iH == 3 || iH == 4 || iH == 5) {
            fc4Var.r(6);
        } else {
            if (iH != 6 && iH != 7) {
                throw new IllegalStateException();
            }
            fc4Var.r(1);
        }
    }

    public final int g(fc4 fc4Var) throws ParserException {
        int iH;
        if (this.o != 0) {
            throw ParserException.createForMalformedContainer(null, null);
        }
        int i = 0;
        do {
            iH = fc4Var.h(8);
            i += iH;
        } while (iH == 255);
        return i;
    }

    public final void h(fc4 fc4Var, int i) {
        int iE = fc4Var.e();
        if ((iE & 7) == 0) {
            this.b.U(iE >> 3);
        } else {
            fc4Var.i(this.b.e(), 0, i * 8);
            this.b.U(0);
        }
        this.d.d(this.b, i);
        long j = this.k;
        if (j != -9223372036854775807L) {
            this.d.e(j, 1, i, 0, null);
            this.k += this.s;
        }
    }

    public final void i(fc4 fc4Var) throws ParserException {
        boolean zG;
        int iH = fc4Var.h(1);
        int iH2 = iH == 1 ? fc4Var.h(1) : 0;
        this.m = iH2;
        if (iH2 != 0) {
            throw ParserException.createForMalformedContainer(null, null);
        }
        if (iH == 1) {
            c(fc4Var);
        }
        if (!fc4Var.g()) {
            throw ParserException.createForMalformedContainer(null, null);
        }
        this.n = fc4Var.h(6);
        int iH3 = fc4Var.h(4);
        int iH4 = fc4Var.h(3);
        if (iH3 != 0 || iH4 != 0) {
            throw ParserException.createForMalformedContainer(null, null);
        }
        if (iH == 0) {
            int iE = fc4Var.e();
            int iE2 = e(fc4Var);
            fc4Var.p(iE);
            byte[] bArr = new byte[(iE2 + 7) / 8];
            fc4Var.i(bArr, 0, iE2);
            m mVarG = new m.b().U(this.e).g0("audio/mp4a-latm").K(this.u).J(this.t).h0(this.r).V(Collections.singletonList(bArr)).X(this.f19413a).G();
            if (!mVarG.equals(this.f)) {
                this.f = mVarG;
                this.s = 1024000000 / ((long) mVarG.z);
                this.d.b(mVarG);
            }
        } else {
            fc4Var.r(((int) c(fc4Var)) - e(fc4Var));
        }
        f(fc4Var);
        boolean zG2 = fc4Var.g();
        this.p = zG2;
        this.q = 0L;
        if (zG2) {
            if (iH == 1) {
                this.q = c(fc4Var);
            } else {
                do {
                    zG = fc4Var.g();
                    this.q = (this.q << 8) + ((long) fc4Var.h(8));
                } while (zG);
            }
        }
        if (fc4Var.g()) {
            fc4Var.r(8);
        }
    }

    public final void j(int i) {
        this.b.Q(i);
        this.c.n(this.b.e());
    }

    @Override // defpackage.gl1
    public void packetStarted(long j, int i) {
        if (j != -9223372036854775807L) {
            this.k = j;
        }
    }

    @Override // defpackage.gl1
    public void seek() {
        this.g = 0;
        this.k = -9223372036854775807L;
        this.l = false;
    }

    @Override // defpackage.gl1
    public void packetFinished() {
    }
}
