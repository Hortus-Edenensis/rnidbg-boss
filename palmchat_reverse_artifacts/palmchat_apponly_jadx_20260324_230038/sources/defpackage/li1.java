package defpackage;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m;
import defpackage.j26;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class li1 implements gl1 {

    @Nullable
    public final String b;
    public String c;
    public c06 d;
    public int f;
    public int g;
    public long h;
    public m i;
    public int j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gc4 f19009a = new gc4(new byte[18]);
    public int e = 0;
    public long k = -9223372036854775807L;

    public li1(@Nullable String str) {
        this.b = str;
    }

    @Override // defpackage.gl1
    public void a(gc4 gc4Var) {
        vh.i(this.d);
        while (gc4Var.a() > 0) {
            int i = this.e;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException();
                    }
                    int iMin = Math.min(gc4Var.a(), this.j - this.f);
                    this.d.d(gc4Var, iMin);
                    int i2 = this.f + iMin;
                    this.f = i2;
                    int i3 = this.j;
                    if (i2 == i3) {
                        long j = this.k;
                        if (j != -9223372036854775807L) {
                            this.d.e(j, 1, i3, 0, null);
                            this.k += this.h;
                        }
                        this.e = 0;
                    }
                } else if (c(gc4Var, this.f19009a.e(), 18)) {
                    d();
                    this.f19009a.U(0);
                    this.d.d(this.f19009a, 18);
                    this.e = 2;
                }
            } else if (e(gc4Var)) {
                this.e = 1;
            }
        }
    }

    @Override // defpackage.gl1
    public void b(qs1 qs1Var, j26.d dVar) {
        dVar.a();
        this.c = dVar.b();
        this.d = qs1Var.track(dVar.c(), 1);
    }

    public final boolean c(gc4 gc4Var, byte[] bArr, int i) {
        int iMin = Math.min(gc4Var.a(), i - this.f);
        gc4Var.l(bArr, this.f, iMin);
        int i2 = this.f + iMin;
        this.f = i2;
        return i2 == i;
    }

    public final void d() {
        byte[] bArrE = this.f19009a.e();
        if (this.i == null) {
            m mVarG = mi1.g(bArrE, this.c, this.b, null);
            this.i = mVarG;
            this.d.b(mVarG);
        }
        this.j = mi1.a(bArrE);
        this.h = (int) ((((long) mi1.f(bArrE)) * 1000000) / ((long) this.i.z));
    }

    public final boolean e(gc4 gc4Var) {
        while (gc4Var.a() > 0) {
            int i = this.g << 8;
            this.g = i;
            int iH = i | gc4Var.H();
            this.g = iH;
            if (mi1.d(iH)) {
                byte[] bArrE = this.f19009a.e();
                int i2 = this.g;
                bArrE[0] = (byte) ((i2 >> 24) & 255);
                bArrE[1] = (byte) ((i2 >> 16) & 255);
                bArrE[2] = (byte) ((i2 >> 8) & 255);
                bArrE[3] = (byte) (i2 & 255);
                this.f = 4;
                this.g = 0;
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.gl1
    public void packetStarted(long j, int i) {
        if (j != -9223372036854775807L) {
            this.k = j;
        }
    }

    @Override // defpackage.gl1
    public void seek() {
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.k = -9223372036854775807L;
    }

    @Override // defpackage.gl1
    public void packetFinished() {
    }
}
