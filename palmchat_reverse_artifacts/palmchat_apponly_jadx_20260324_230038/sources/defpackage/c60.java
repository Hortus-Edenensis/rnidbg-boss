package defpackage;

import defpackage.v45;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class c60 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c06 f1898a;
    public final int b;
    public final int c;
    public final long d;
    public final int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public long[] k;
    public int[] l;

    public c60(int i, int i2, long j, int i3, c06 c06Var) {
        boolean z = true;
        if (i2 != 1 && i2 != 2) {
            z = false;
        }
        vh.a(z);
        this.d = j;
        this.e = i3;
        this.f1898a = c06Var;
        this.b = d(i, i2 == 2 ? 1667497984 : 1651965952);
        this.c = i2 == 2 ? d(i, 1650720768) : -1;
        this.k = new long[512];
        this.l = new int[512];
    }

    public static int d(int i, int i2) {
        return (((i % 10) + 48) << 8) | ((i / 10) + 48) | i2;
    }

    public void a() {
        this.h++;
    }

    public void b(long j) {
        if (this.j == this.l.length) {
            long[] jArr = this.k;
            this.k = Arrays.copyOf(jArr, (jArr.length * 3) / 2);
            int[] iArr = this.l;
            this.l = Arrays.copyOf(iArr, (iArr.length * 3) / 2);
        }
        long[] jArr2 = this.k;
        int i = this.j;
        jArr2[i] = j;
        this.l[i] = this.i;
        this.j = i + 1;
    }

    public void c() {
        this.k = Arrays.copyOf(this.k, this.j);
        this.l = Arrays.copyOf(this.l, this.j);
    }

    public final long e(int i) {
        return (this.d * ((long) i)) / ((long) this.e);
    }

    public long f() {
        return e(this.h);
    }

    public long g() {
        return e(1);
    }

    public final x45 h(int i) {
        return new x45(((long) this.l[i]) * g(), this.k[i]);
    }

    public v45.a i(long j) {
        int iG = (int) (j / g());
        int iH = g86.h(this.l, iG, true, true);
        if (this.l[iH] == iG) {
            return new v45.a(h(iH));
        }
        x45 x45VarH = h(iH);
        int i = iH + 1;
        return i < this.k.length ? new v45.a(x45VarH, h(i)) : new v45.a(x45VarH);
    }

    public boolean j(int i) {
        return this.b == i || this.c == i;
    }

    public void k() {
        this.i++;
    }

    public boolean l() {
        return Arrays.binarySearch(this.l, this.h) >= 0;
    }

    public boolean m(ps1 ps1Var) throws IOException {
        int i = this.g;
        int iC = i - this.f1898a.c(ps1Var, i, false);
        this.g = iC;
        boolean z = iC == 0;
        if (z) {
            if (this.f > 0) {
                this.f1898a.e(f(), l() ? 1 : 0, this.f, 0, null);
            }
            a();
        }
        return z;
    }

    public void n(int i) {
        this.f = i;
        this.g = i;
    }

    public void o(long j) {
        if (this.j == 0) {
            this.h = 0;
        } else {
            this.h = this.l[g86.i(this.k, j, true, true)];
        }
    }
}
