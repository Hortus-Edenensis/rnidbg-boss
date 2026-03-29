package defpackage;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m;
import defpackage.j26;
import defpackage.n2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class m2 implements gl1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fc4 f19127a;
    public final gc4 b;

    @Nullable
    public final String c;
    public String d;
    public c06 e;
    public int f;
    public int g;
    public boolean h;
    public boolean i;
    public long j;
    public m k;
    public int l;
    public long m;

    public m2() {
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
                        int iMin = Math.min(gc4Var.a(), this.l - this.g);
                        this.e.d(gc4Var, iMin);
                        int i2 = this.g + iMin;
                        this.g = i2;
                        int i3 = this.l;
                        if (i2 == i3) {
                            long j = this.m;
                            if (j != -9223372036854775807L) {
                                this.e.e(j, 1, i3, 0, null);
                                this.m += this.j;
                            }
                            this.f = 0;
                        }
                    }
                } else if (c(gc4Var, this.b.e(), 16)) {
                    d();
                    this.b.U(0);
                    this.e.d(this.b, 16);
                    this.f = 2;
                }
            } else if (e(gc4Var)) {
                this.f = 1;
                this.b.e()[0] = -84;
                this.b.e()[1] = (byte) (this.i ? 65 : 64);
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
        this.f19127a.p(0);
        n2.b bVarD = n2.d(this.f19127a);
        m mVar = this.k;
        if (mVar == null || bVarD.c != mVar.y || bVarD.b != mVar.z || !"audio/ac4".equals(mVar.l)) {
            m mVarG = new m.b().U(this.d).g0("audio/ac4").J(bVarD.c).h0(bVarD.b).X(this.c).G();
            this.k = mVarG;
            this.e.b(mVarG);
        }
        this.l = bVarD.d;
        this.j = (((long) bVarD.e) * 1000000) / ((long) this.k.z);
    }

    public final boolean e(gc4 gc4Var) {
        int iH;
        while (true) {
            if (gc4Var.a() <= 0) {
                return false;
            }
            if (this.h) {
                iH = gc4Var.H();
                this.h = iH == 172;
                if (iH == 64 || iH == 65) {
                    break;
                }
            } else {
                this.h = gc4Var.H() == 172;
            }
        }
        this.i = iH == 65;
        return true;
    }

    @Override // defpackage.gl1
    public void packetStarted(long j, int i) {
        if (j != -9223372036854775807L) {
            this.m = j;
        }
    }

    @Override // defpackage.gl1
    public void seek() {
        this.f = 0;
        this.g = 0;
        this.h = false;
        this.i = false;
        this.m = -9223372036854775807L;
    }

    public m2(@Nullable String str) {
        fc4 fc4Var = new fc4(new byte[16]);
        this.f19127a = fc4Var;
        this.b = new gc4(fc4Var.f17507a);
        this.f = 0;
        this.g = 0;
        this.h = false;
        this.i = false;
        this.m = -9223372036854775807L;
        this.c = str;
    }

    @Override // defpackage.gl1
    public void packetFinished() {
    }
}
