package defpackage;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import defpackage.j26;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class ph4 implements j26 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gl1 f20018a;
    public final fc4 b = new fc4(new byte[10]);
    public int c = 0;
    public int d;
    public jy5 e;
    public boolean f;
    public boolean g;
    public boolean h;
    public int i;
    public int j;
    public boolean k;
    public long l;

    public ph4(gl1 gl1Var) {
        this.f20018a = gl1Var;
    }

    @Override // defpackage.j26
    public final void a(gc4 gc4Var, int i) throws ParserException {
        vh.i(this.e);
        if ((i & 1) != 0) {
            int i2 = this.c;
            if (i2 != 0 && i2 != 1) {
                if (i2 == 2) {
                    y53.i("PesReader", "Unexpected start indicator reading extended header");
                } else {
                    if (i2 != 3) {
                        throw new IllegalStateException();
                    }
                    if (this.j != -1) {
                        y53.i("PesReader", "Unexpected start indicator: expected " + this.j + " more bytes");
                    }
                    this.f20018a.packetFinished();
                }
            }
            f(1);
        }
        while (gc4Var.a() > 0) {
            int i3 = this.c;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        if (c(gc4Var, this.b.f17507a, Math.min(10, this.i)) && c(gc4Var, null, this.i)) {
                            e();
                            i |= this.k ? 4 : 0;
                            this.f20018a.packetStarted(this.l, i);
                            f(3);
                        }
                    } else {
                        if (i3 != 3) {
                            throw new IllegalStateException();
                        }
                        int iA = gc4Var.a();
                        int i4 = this.j;
                        int i5 = i4 != -1 ? iA - i4 : 0;
                        if (i5 > 0) {
                            iA -= i5;
                            gc4Var.T(gc4Var.f() + iA);
                        }
                        this.f20018a.a(gc4Var);
                        int i6 = this.j;
                        if (i6 != -1) {
                            int i7 = i6 - iA;
                            this.j = i7;
                            if (i7 == 0) {
                                this.f20018a.packetFinished();
                                f(1);
                            }
                        }
                    }
                } else if (c(gc4Var, this.b.f17507a, 9)) {
                    f(d() ? 2 : 0);
                }
            } else {
                gc4Var.V(gc4Var.a());
            }
        }
    }

    @Override // defpackage.j26
    public void b(jy5 jy5Var, qs1 qs1Var, j26.d dVar) {
        this.e = jy5Var;
        this.f20018a.b(qs1Var, dVar);
    }

    public final boolean c(gc4 gc4Var, @Nullable byte[] bArr, int i) {
        int iMin = Math.min(gc4Var.a(), i - this.d);
        if (iMin <= 0) {
            return true;
        }
        if (bArr == null) {
            gc4Var.V(iMin);
        } else {
            gc4Var.l(bArr, this.d, iMin);
        }
        int i2 = this.d + iMin;
        this.d = i2;
        return i2 == i;
    }

    public final boolean d() {
        this.b.p(0);
        int iH = this.b.h(24);
        if (iH != 1) {
            y53.i("PesReader", "Unexpected start code prefix: " + iH);
            this.j = -1;
            return false;
        }
        this.b.r(8);
        int iH2 = this.b.h(16);
        this.b.r(5);
        this.k = this.b.g();
        this.b.r(2);
        this.f = this.b.g();
        this.g = this.b.g();
        this.b.r(6);
        int iH3 = this.b.h(8);
        this.i = iH3;
        if (iH2 == 0) {
            this.j = -1;
        } else {
            int i = ((iH2 + 6) - 9) - iH3;
            this.j = i;
            if (i < 0) {
                y53.i("PesReader", "Found negative packet payload size: " + this.j);
                this.j = -1;
            }
        }
        return true;
    }

    public final void e() {
        this.b.p(0);
        this.l = -9223372036854775807L;
        if (this.f) {
            this.b.r(4);
            long jH = ((long) this.b.h(3)) << 30;
            this.b.r(1);
            long jH2 = jH | ((long) (this.b.h(15) << 15));
            this.b.r(1);
            long jH3 = jH2 | ((long) this.b.h(15));
            this.b.r(1);
            if (!this.h && this.g) {
                this.b.r(4);
                long jH4 = ((long) this.b.h(3)) << 30;
                this.b.r(1);
                long jH5 = jH4 | ((long) (this.b.h(15) << 15));
                this.b.r(1);
                long jH6 = jH5 | ((long) this.b.h(15));
                this.b.r(1);
                this.e.b(jH6);
                this.h = true;
            }
            this.l = this.e.b(jH3);
        }
    }

    public final void f(int i) {
        this.c = i;
        this.d = 0;
    }

    @Override // defpackage.j26
    public final void seek() {
        this.c = 0;
        this.d = 0;
        this.h = false;
        this.f20018a.seek();
    }
}
