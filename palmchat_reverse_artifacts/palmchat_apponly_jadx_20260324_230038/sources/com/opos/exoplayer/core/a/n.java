package com.opos.exoplayer.core.a;

import java.nio.ShortBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f8107a;
    private final int b;
    private final float c;
    private final float d;
    private final float e;
    private final int f;
    private final int g;
    private final int h;
    private final short[] i;
    private int j;
    private short[] k;
    private int l;
    private short[] m;
    private int n;
    private short[] o;
    private int r;
    private int s;
    private int t;
    private int u;
    private int w;
    private int x;
    private int y;
    private int p = 0;
    private int q = 0;
    private int v = 0;

    public n(int i, int i2, float f, float f2, int i3) {
        this.f8107a = i;
        this.b = i2;
        this.f = i / 400;
        int i4 = i / 65;
        this.g = i4;
        int i5 = i4 * 2;
        this.h = i5;
        this.i = new short[i5];
        this.j = i5;
        int i6 = i2 * i5;
        this.k = new short[i6];
        this.l = i5;
        this.m = new short[i6];
        this.n = i5;
        this.o = new short[i6];
        this.c = f;
        this.d = f2;
        this.e = i / i3;
    }

    private int a(short[] sArr, int i, float f, int i2) {
        int i3;
        if (f >= 2.0f) {
            i3 = (int) (i2 / (f - 1.0f));
        } else {
            this.u = (int) ((i2 * (2.0f - f)) / (f - 1.0f));
            i3 = i2;
        }
        a(i3);
        a(i3, this.b, this.m, this.s, sArr, i, sArr, i + i2);
        this.s += i3;
        return i3;
    }

    private void c() {
        int i = this.s;
        float f = this.c;
        float f2 = this.d;
        float f3 = f / f2;
        float f4 = this.e * f2;
        double d = f3;
        if (d > 1.00001d || d < 0.99999d) {
            a(f3);
        } else {
            a(this.k, 0, this.r);
            this.r = 0;
        }
        if (f4 != 1.0f) {
            a(f4, i);
        }
    }

    private int d(int i) {
        int iMin = Math.min(this.h, this.u);
        a(this.k, i, iMin);
        this.u -= iMin;
        return iMin;
    }

    private void e(int i) {
        int i2 = this.s - i;
        int i3 = this.t + i2;
        int i4 = this.n;
        if (i3 > i4) {
            int i5 = i4 + (i4 / 2) + i2;
            this.n = i5;
            this.o = Arrays.copyOf(this.o, i5 * this.b);
        }
        short[] sArr = this.m;
        int i6 = this.b;
        System.arraycopy(sArr, i * i6, this.o, this.t * i6, i6 * i2);
        this.s = i;
        this.t += i2;
    }

    private void f(int i) {
        if (i == 0) {
            return;
        }
        short[] sArr = this.o;
        int i2 = this.b;
        System.arraycopy(sArr, i * i2, sArr, 0, (this.t - i) * i2);
        this.t -= i;
    }

    public int b() {
        return this.s;
    }

    private int a(short[] sArr, int i, int i2, int i3) {
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
        this.x = i6 / i7;
        this.y = i8 / i5;
        return i7;
    }

    private int b(short[] sArr, int i, float f, int i2) {
        int i3;
        if (f < 0.5f) {
            i3 = (int) ((i2 * f) / (1.0f - f));
        } else {
            this.u = (int) ((i2 * ((2.0f * f) - 1.0f)) / (1.0f - f));
            i3 = i2;
        }
        int i4 = i2 + i3;
        a(i4);
        int i5 = this.b;
        System.arraycopy(sArr, i * i5, this.m, this.s * i5, i5 * i2);
        a(i3, this.b, this.m, this.s + i2, sArr, i + i2, sArr, i);
        this.s += i4;
        return i3;
    }

    private void c(int i) {
        int i2 = this.r - i;
        short[] sArr = this.k;
        int i3 = this.b;
        System.arraycopy(sArr, i * i3, sArr, 0, i3 * i2);
        this.r = i2;
    }

    private int a(short[] sArr, int i, boolean z) {
        int iA;
        int i2 = this.f8107a;
        int i3 = i2 > 4000 ? i2 / 4000 : 1;
        if (this.b == 1 && i3 == 1) {
            iA = a(sArr, i, this.f, this.g);
        } else {
            b(sArr, i, i3);
            int iA2 = a(this.i, 0, this.f / i3, this.g / i3);
            if (i3 != 1) {
                int i4 = iA2 * i3;
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
                    iA = a(sArr, i, i6, i7);
                } else {
                    b(sArr, i, 1);
                    iA = a(this.i, 0, i6, i7);
                }
            } else {
                iA = iA2;
            }
        }
        int i10 = a(this.x, this.y, z) ? this.v : iA;
        this.w = this.x;
        this.v = iA;
        return i10;
    }

    private short b(short[] sArr, int i, int i2, int i3) {
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

    private void b(int i) {
        int i2 = this.r + i;
        int i3 = this.j;
        if (i2 > i3) {
            int i4 = i3 + (i3 / 2) + i;
            this.j = i4;
            this.k = Arrays.copyOf(this.k, i4 * this.b);
        }
    }

    public void a() {
        int i;
        int i2 = this.r;
        float f = this.c;
        float f2 = this.d;
        int i3 = this.s + ((int) ((((i2 / (f / f2)) + this.t) / (this.e * f2)) + 0.5f));
        b((this.h * 2) + i2);
        int i4 = 0;
        while (true) {
            i = this.h * 2;
            int i5 = this.b;
            if (i4 >= i * i5) {
                break;
            }
            this.k[(i5 * i2) + i4] = 0;
            i4++;
        }
        this.r += i;
        c();
        if (this.s > i3) {
            this.s = i3;
        }
        this.r = 0;
        this.u = 0;
        this.t = 0;
    }

    private void a(float f) {
        int iA;
        int i = this.r;
        if (i < this.h) {
            return;
        }
        int i2 = 0;
        do {
            if (this.u > 0) {
                iA = d(i2);
            } else {
                int iA2 = a(this.k, i2, true);
                double d = f;
                short[] sArr = this.k;
                iA = d > 1.0d ? iA2 + a(sArr, i2, f, iA2) : b(sArr, i2, f, iA2);
            }
            i2 += iA;
        } while (this.h + i2 <= i);
        c(i2);
    }

    public void b(ShortBuffer shortBuffer) {
        int iMin = Math.min(shortBuffer.remaining() / this.b, this.s);
        shortBuffer.put(this.m, 0, this.b * iMin);
        int i = this.s - iMin;
        this.s = i;
        short[] sArr = this.m;
        int i2 = this.b;
        System.arraycopy(sArr, iMin * i2, sArr, 0, i * i2);
    }

    private void a(float f, int i) {
        int i2;
        int i3;
        if (this.s == i) {
            return;
        }
        int i4 = this.f8107a;
        int i5 = (int) (i4 / f);
        while (true) {
            if (i5 <= 16384 && i4 <= 16384) {
                break;
            }
            i5 /= 2;
            i4 /= 2;
        }
        e(i);
        int i6 = 0;
        while (true) {
            int i7 = this.t - 1;
            if (i6 >= i7) {
                f(i7);
                return;
            }
            while (true) {
                i2 = this.p + 1;
                int i8 = i2 * i5;
                i3 = this.q;
                if (i8 <= i3 * i4) {
                    break;
                }
                a(1);
                int i9 = 0;
                while (true) {
                    int i10 = this.b;
                    if (i9 < i10) {
                        this.m[(this.s * i10) + i9] = b(this.o, (i10 * i6) + i9, i4, i5);
                        i9++;
                    }
                }
                this.q++;
                this.s++;
            }
            this.p = i2;
            if (i2 == i4) {
                this.p = 0;
                com.opos.exoplayer.core.util.a.b(i3 == i5);
                this.q = 0;
            }
            i6++;
        }
    }

    private void b(short[] sArr, int i, int i2) {
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

    private void a(int i) {
        int i2 = this.s + i;
        int i3 = this.l;
        if (i2 > i3) {
            int i4 = i3 + (i3 / 2) + i;
            this.l = i4;
            this.m = Arrays.copyOf(this.m, i4 * this.b);
        }
    }

    private static void a(int i, int i2, short[] sArr, int i3, short[] sArr2, int i4, short[] sArr3, int i5) {
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

    public void a(ShortBuffer shortBuffer) {
        int iRemaining = shortBuffer.remaining();
        int i = this.b;
        int i2 = iRemaining / i;
        b(i2);
        shortBuffer.get(this.k, this.r * this.b, ((i * i2) * 2) / 2);
        this.r += i2;
        c();
    }

    private void a(short[] sArr, int i, int i2) {
        a(i2);
        int i3 = this.b;
        System.arraycopy(sArr, i * i3, this.m, this.s * i3, i3 * i2);
        this.s += i2;
    }

    private boolean a(int i, int i2, boolean z) {
        if (i == 0 || this.v == 0) {
            return false;
        }
        return z ? i2 <= i * 3 && i * 2 > this.w * 3 : i > this.w;
    }
}
