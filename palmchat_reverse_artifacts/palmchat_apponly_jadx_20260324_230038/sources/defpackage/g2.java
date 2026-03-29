package defpackage;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m;
import defpackage.h2;
import defpackage.j26;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class g2 implements gl1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fc4 f17636a;
    public final gc4 b;

    @Nullable
    public final String c;
    public String d;
    public c06 e;
    public int f;
    public int g;
    public boolean h;
    public long i;
    public m j;
    public int k;
    public long l;

    public g2() {
        this(null);
    }

    @Override // defpackage.gl1
    public void a(gc4 gc4Var) {
        vh.i(this.e);
        while (gc4Var.a() > 0) {
            int i = this.f;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        int iMin = Math.min(gc4Var.a(), this.k - this.g);
                        this.e.d(gc4Var, iMin);
                        int i2 = this.g + iMin;
                        this.g = i2;
                        int i3 = this.k;
                        if (i2 == i3) {
                            long j = this.l;
                            if (j != -9223372036854775807L) {
                                this.e.e(j, 1, i3, 0, null);
                                this.l += this.i;
                            }
                            this.f = 0;
                        }
                    }
                } else if (c(gc4Var, this.b.e(), 128)) {
                    d();
                    this.b.U(0);
                    this.e.d(this.b, 128);
                    this.f = 2;
                }
            } else if (e(gc4Var)) {
                this.f = 1;
                this.b.e()[0] = 11;
                this.b.e()[1] = 119;
                this.g = 2;
            }
        }
    }

    @Override // defpackage.gl1
    public void b(qs1 qs1Var, j26.d dVar) {
        dVar.a();
        this.d = dVar.b();
        this.e = qs1Var.track(dVar.c(), 1);
    }

    public final boolean c(gc4 gc4Var, byte[] bArr, int i) {
        int iMin = Math.min(gc4Var.a(), i - this.g);
        gc4Var.l(bArr, this.g, iMin);
        int i2 = this.g + iMin;
        this.g = i2;
        return i2 == i;
    }

    public final void d() {
        this.f17636a.p(0);
        h2.b bVarF = h2.f(this.f17636a);
        m mVar = this.j;
        if (mVar == null || bVarF.d != mVar.y || bVarF.c != mVar.z || !g86.c(bVarF.f17855a, mVar.l)) {
            m.b bVarB0 = new m.b().U(this.d).g0(bVarF.f17855a).J(bVarF.d).h0(bVarF.c).X(this.c).b0(bVarF.g);
            if ("audio/ac3".equals(bVarF.f17855a)) {
                bVarB0.I(bVarF.g);
            }
            m mVarG = bVarB0.G();
            this.j = mVarG;
            this.e.b(mVarG);
        }
        this.k = bVarF.e;
        this.i = (((long) bVarF.f) * 1000000) / ((long) this.j.z);
    }

    public final boolean e(gc4 gc4Var) {
        while (true) {
            if (gc4Var.a() <= 0) {
                return false;
            }
            if (this.h) {
                int iH = gc4Var.H();
                if (iH == 119) {
                    this.h = false;
                    return true;
                }
                this.h = iH == 11;
            } else {
                this.h = gc4Var.H() == 11;
            }
        }
    }

    @Override // defpackage.gl1
    public void packetStarted(long j, int i) {
        if (j != -9223372036854775807L) {
            this.l = j;
        }
    }

    @Override // defpackage.gl1
    public void seek() {
        this.f = 0;
        this.g = 0;
        this.h = false;
        this.l = -9223372036854775807L;
    }

    public g2(@Nullable String str) {
        fc4 fc4Var = new fc4(new byte[128]);
        this.f17636a = fc4Var;
        this.b = new gc4(fc4Var.f17507a);
        this.f = 0;
        this.l = -9223372036854775807L;
        this.c = str;
    }

    @Override // defpackage.gl1
    public void packetFinished() {
    }
}
