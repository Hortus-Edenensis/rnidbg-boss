package defpackage;

import java.nio.ShortBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class ig5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f18161a;
    public final int b;
    public final float c;
    public final float d;
    public final float e;
    public final int f;
    public final int g;
    public final int h;
    public final short[] i;
    public short[] j;
    public int k;
    public short[] l;
    public int m;
    public short[] n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;

    public ig5(int i, int i2, float f, float f2, int i3) {
        this.f18161a = i;
        this.b = i2;
        this.c = f;
        this.d = f2;
        this.e = i / i3;
        this.f = i / 400;
        int i4 = i / 65;
        this.g = i4;
        int i5 = i4 * 2;
        this.h = i5;
        this.i = new short[i5];
        this.j = new short[i5 * i2];
        this.l = new short[i5 * i2];
        this.n = new short[i5 * i2];
    }

    public static void p(int i, int i2, short[] sArr, int i3, short[] sArr2, int i4, short[] sArr3, int i5) {
        for (int i6 = 0; i6 < i2; i6++) {
            int i7 = (i3 * i2) + i6;
            int i8 = (i5 * i2) + i6;
            int i9 = (i4 * i2) + i6;
            for (int i10 = 0; i10 < i; i10++) {
                sArr[i7] = (short) (((sArr2[i9] * (i - i10)) + (sArr3[i8] * i10)) / i);
                i7 += i2;
                i9 += i2;
                i8 += i2;
            }
        }
    }

    public final void a(float f, int i) {
        int i2;
        int i3;
        if (this.m == i) {
            return;
        }
        int i4 = this.f18161a;
        int i5 = (int) (i4 / f);
        while (true) {
            if (i5 <= 16384 && i4 <= 16384) {
                break;
            }
            i5 /= 2;
            i4 /= 2;
        }
        o(i);
        int i6 = 0;
        while (true) {
            int i7 = this.o;
            if (i6 >= i7 - 1) {
                u(i7 - 1);
                return;
            }
            while (true) {
                i2 = this.p;
                int i8 = (i2 + 1) * i5;
                i3 = this.q;
                if (i8 <= i3 * i4) {
                    break;
                }
                this.l = f(this.l, this.m, 1);
                int i9 = 0;
                while (true) {
                    int i10 = this.b;
                    if (i9 < i10) {
                        this.l[(this.m * i10) + i9] = n(this.n, (i10 * i6) + i9, i4, i5);
                        i9++;
                    }
                }
                this.q++;
                this.m++;
            }
            int i11 = i2 + 1;
            this.p = i11;
            if (i11 == i4) {
                this.p = 0;
                vh.g(i3 == i5);
                this.q = 0;
            }
            i6++;
        }
    }

    public final void b(float f) {
        int iW;
        int i = this.k;
        if (i < this.h) {
            return;
        }
        int i2 = 0;
        do {
            if (this.r > 0) {
                iW = c(i2);
            } else {
                int iG = g(this.j, i2);
                iW = ((double) f) > 1.0d ? iG + w(this.j, i2, f, iG) : m(this.j, i2, f, iG);
            }
            i2 += iW;
        } while (this.h + i2 <= i);
        v(i2);
    }

    public final int c(int i) {
        int iMin = Math.min(this.h, this.r);
        d(this.j, i, iMin);
        this.r -= iMin;
        return iMin;
    }

    public final void d(short[] sArr, int i, int i2) {
        short[] sArrF = f(this.l, this.m, i2);
        this.l = sArrF;
        int i3 = this.b;
        System.arraycopy(sArr, i * i3, sArrF, this.m * i3, i3 * i2);
        this.m += i2;
    }

    public final void e(short[] sArr, int i, int i2) {
        int i3 = this.h / i2;
        int i4 = this.b;
        int i5 = i2 * i4;
        int i6 = i * i4;
        for (int i7 = 0; i7 < i3; i7++) {
            int i8 = 0;
            for (int i9 = 0; i9 < i5; i9++) {
                i8 += sArr[(i7 * i5) + i6 + i9];
            }
            this.i[i7] = (short) (i8 / i5);
        }
    }

    public final short[] f(short[] sArr, int i, int i2) {
        int length = sArr.length;
        int i3 = this.b;
        int i4 = length / i3;
        return i + i2 <= i4 ? sArr : Arrays.copyOf(sArr, (((i4 * 3) / 2) + i2) * i3);
    }

    public final int g(short[] sArr, int i) {
        int iH;
        int i2 = this.f18161a;
        int i3 = i2 > 4000 ? i2 / 4000 : 1;
        if (this.b == 1 && i3 == 1) {
            iH = h(sArr, i, this.f, this.g);
        } else {
            e(sArr, i, i3);
            int iH2 = h(this.i, 0, this.f / i3, this.g / i3);
            if (i3 != 1) {
                int i4 = iH2 * i3;
                int i5 = i3 * 4;
                int i6 = i4 - i5;
                int i7 = i4 + i5;
                int i8 = this.f;
                if (i6 < i8) {
                    i6 = i8;
                }
                int i9 = this.g;
                if (i7 > i9) {
                    i7 = i9;
                }
                if (this.b == 1) {
                    iH = h(sArr, i, i6, i7);
                } else {
                    e(sArr, i, 1);
                    iH = h(this.i, 0, i6, i7);
                }
            } else {
                iH = iH2;
            }
        }
        int i10 = q(this.u, this.v) ? this.s : iH;
        this.t = this.u;
        this.s = iH;
        return i10;
    }

    public final int h(short[] sArr, int i, int i2, int i3) {
        int i4 = i * this.b;
        int i5 = 255;
        int i6 = 1;
        int i7 = 0;
        int i8 = 0;
        while (i2 <= i3) {
            int iAbs = 0;
            for (int i9 = 0; i9 < i2; i9++) {
                iAbs += Math.abs(sArr[i4 + i9] - sArr[(i4 + i2) + i9]);
            }
            if (iAbs * i7 < i6 * i2) {
                i7 = i2;
                i6 = iAbs;
            }
            if (iAbs * i5 > i8 * i2) {
                i5 = i2;
                i8 = iAbs;
            }
            i2++;
        }
        this.u = i6 / i7;
        this.v = i8 / i5;
        return i7;
    }

    public void i() {
        this.k = 0;
        this.m = 0;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.u = 0;
        this.v = 0;
    }

    public void j(ShortBuffer shortBuffer) {
        int iMin = Math.min(shortBuffer.remaining() / this.b, this.m);
        shortBuffer.put(this.l, 0, this.b * iMin);
        int i = this.m - iMin;
        this.m = i;
        short[] sArr = this.l;
        int i2 = this.b;
        System.arraycopy(sArr, iMin * i2, sArr, 0, i * i2);
    }

    public int k() {
        return this.m * this.b * 2;
    }

    public int l() {
        return this.k * this.b * 2;
    }

    public final int m(short[] sArr, int i, float f, int i2) {
        int i3;
        if (f < 0.5f) {
            i3 = (int) ((i2 * f) / (1.0f - f));
        } else {
            this.r = (int) ((i2 * ((2.0f * f) - 1.0f)) / (1.0f - f));
            i3 = i2;
        }
        int i4 = i2 + i3;
        short[] sArrF = f(this.l, this.m, i4);
        this.l = sArrF;
        int i5 = this.b;
        System.arraycopy(sArr, i * i5, sArrF, this.m * i5, i5 * i2);
        p(i3, this.b, this.l, this.m + i2, sArr, i + i2, sArr, i);
        this.m += i4;
        return i3;
    }

    public final short n(short[] sArr, int i, int i2, int i3) {
        short s = sArr[i];
        short s2 = sArr[i + this.b];
        int i4 = this.q * i2;
        int i5 = this.p;
        int i6 = i5 * i3;
        int i7 = (i5 + 1) * i3;
        int i8 = i7 - i4;
        int i9 = i7 - i6;
        return (short) (((s * i8) + ((i9 - i8) * s2)) / i9);
    }

    public final void o(int i) {
        int i2 = this.m - i;
        short[] sArrF = f(this.n, this.o, i2);
        this.n = sArrF;
        short[] sArr = this.l;
        int i3 = this.b;
        System.arraycopy(sArr, i * i3, sArrF, this.o * i3, i3 * i2);
        this.m = i;
        this.o += i2;
    }

    public final boolean q(int i, int i2) {
        return i != 0 && this.s != 0 && i2 <= i * 3 && i * 2 > this.t * 3;
    }

    public final void r() {
        int i = this.m;
        float f = this.c;
        float f2 = this.d;
        float f3 = f / f2;
        float f4 = this.e * f2;
        double d = f3;
        if (d > 1.00001d || d < 0.99999d) {
            b(f3);
        } else {
            d(this.j, 0, this.k);
            this.k = 0;
        }
        if (f4 != 1.0f) {
            a(f4, i);
        }
    }

    public void s() {
        int i;
        int i2 = this.k;
        float f = this.c;
        float f2 = this.d;
        int i3 = this.m + ((int) ((((i2 / (f / f2)) + this.o) / (this.e * f2)) + 0.5f));
        this.j = f(this.j, i2, (this.h * 2) + i2);
        int i4 = 0;
        while (true) {
            i = this.h;
            int i5 = this.b;
            if (i4 >= i * 2 * i5) {
                break;
            }
            this.j[(i5 * i2) + i4] = 0;
            i4++;
        }
        this.k += i * 2;
        r();
        if (this.m > i3) {
            this.m = i3;
        }
        this.k = 0;
        this.r = 0;
        this.o = 0;
    }

    public void t(ShortBuffer shortBuffer) {
        int iRemaining = shortBuffer.remaining();
        int i = this.b;
        int i2 = iRemaining / i;
        short[] sArrF = f(this.j, this.k, i2);
        this.j = sArrF;
        shortBuffer.get(sArrF, this.k * this.b, ((i * i2) * 2) / 2);
        this.k += i2;
        r();
    }

    public final void u(int i) {
        if (i == 0) {
            return;
        }
        short[] sArr = this.n;
        int i2 = this.b;
        System.arraycopy(sArr, i * i2, sArr, 0, (this.o - i) * i2);
        this.o -= i;
    }

    public final void v(int i) {
        int i2 = this.k - i;
        short[] sArr = this.j;
        int i3 = this.b;
        System.arraycopy(sArr, i * i3, sArr, 0, i3 * i2);
        this.k = i2;
    }

    public final int w(short[] sArr, int i, float f, int i2) {
        int i3;
        if (f >= 2.0f) {
            i3 = (int) (i2 / (f - 1.0f));
        } else {
            this.r = (int) ((i2 * (2.0f - f)) / (f - 1.0f));
            i3 = i2;
        }
        short[] sArrF = f(this.l, this.m, i3);
        this.l = sArrF;
        p(i3, this.b, sArrF, this.m, sArr, i, sArr, i + i2);
        this.m += i3;
        return i3;
    }
}
