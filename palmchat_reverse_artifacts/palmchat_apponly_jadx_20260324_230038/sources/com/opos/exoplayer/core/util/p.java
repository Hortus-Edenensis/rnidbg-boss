package com.opos.exoplayer.core.util;

import java.nio.charset.Charset;
import kotlin.UByte;
import okio.Utf8;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f8400a;
    private int b;
    private int c;

    public p() {
    }

    public p(int i) {
        this.f8400a = new byte[i];
        this.c = i;
    }

    public long A() {
        int i;
        int i2;
        long j = this.f8400a[this.b];
        int i3 = 7;
        while (true) {
            if (i3 < 0) {
                break;
            }
            int i4 = 1 << i3;
            if ((((long) i4) & j) != 0) {
                i3--;
            } else if (i3 < 6) {
                j &= (long) (i4 - 1);
                i2 = 7 - i3;
            } else if (i3 == 7) {
                i2 = 1;
            }
        }
        i2 = 0;
        if (i2 == 0) {
            throw new NumberFormatException("Invalid UTF-8 sequence first byte: " + j);
        }
        for (i = 1; i < i2; i++) {
            byte b = this.f8400a[this.b + i];
            if ((b & 192) != 128) {
                throw new NumberFormatException("Invalid UTF-8 sequence continuation byte: " + j);
            }
            j = (j << 6) | ((long) (b & Utf8.REPLACEMENT_BYTE));
        }
        this.b += i2;
        return j;
    }

    public String a(int i, Charset charset) {
        String str = new String(this.f8400a, this.b, i, charset);
        this.b += i;
        return str;
    }

    public int b() {
        return this.c - this.b;
    }

    public int c() {
        return this.c;
    }

    public int d() {
        return this.b;
    }

    public int e() {
        byte[] bArr = this.f8400a;
        if (bArr == null) {
            return 0;
        }
        return bArr.length;
    }

    public char f() {
        byte[] bArr = this.f8400a;
        int i = this.b;
        return (char) ((bArr[i + 1] & UByte.MAX_VALUE) | ((bArr[i] & UByte.MAX_VALUE) << 8));
    }

    public int g() {
        byte[] bArr = this.f8400a;
        int i = this.b;
        this.b = i + 1;
        return bArr[i] & UByte.MAX_VALUE;
    }

    public int h() {
        byte[] bArr = this.f8400a;
        int i = this.b;
        int i2 = i + 1;
        int i3 = (bArr[i] & UByte.MAX_VALUE) << 8;
        this.b = i2 + 1;
        return (bArr[i2] & UByte.MAX_VALUE) | i3;
    }

    public int i() {
        byte[] bArr = this.f8400a;
        int i = this.b;
        int i2 = i + 1;
        int i3 = bArr[i] & UByte.MAX_VALUE;
        this.b = i2 + 1;
        return ((bArr[i2] & UByte.MAX_VALUE) << 8) | i3;
    }

    public short j() {
        byte[] bArr = this.f8400a;
        int i = this.b;
        int i2 = i + 1;
        int i3 = (bArr[i] & UByte.MAX_VALUE) << 8;
        this.b = i2 + 1;
        return (short) ((bArr[i2] & UByte.MAX_VALUE) | i3);
    }

    public int k() {
        byte[] bArr = this.f8400a;
        int i = this.b;
        int i2 = i + 1;
        int i3 = i2 + 1;
        int i4 = ((bArr[i] & UByte.MAX_VALUE) << 16) | ((bArr[i2] & UByte.MAX_VALUE) << 8);
        this.b = i3 + 1;
        return (bArr[i3] & UByte.MAX_VALUE) | i4;
    }

    public int l() {
        byte[] bArr = this.f8400a;
        int i = this.b;
        int i2 = i + 1;
        int i3 = i2 + 1;
        int i4 = (((bArr[i] & UByte.MAX_VALUE) << 24) >> 8) | ((bArr[i2] & UByte.MAX_VALUE) << 8);
        this.b = i3 + 1;
        return (bArr[i3] & UByte.MAX_VALUE) | i4;
    }

    public long m() {
        byte[] bArr = this.f8400a;
        int i = this.b;
        int i2 = i + 1;
        long j = (((long) bArr[i]) & 255) << 24;
        int i3 = i2 + 1;
        int i4 = i3 + 1;
        long j2 = j | ((((long) bArr[i2]) & 255) << 16) | ((((long) bArr[i3]) & 255) << 8);
        this.b = i4 + 1;
        return j2 | (((long) bArr[i4]) & 255);
    }

    public long n() {
        byte[] bArr = this.f8400a;
        int i = this.b;
        int i2 = i + 1;
        long j = ((long) bArr[i]) & 255;
        int i3 = i2 + 1;
        int i4 = i3 + 1;
        long j2 = j | ((((long) bArr[i2]) & 255) << 8) | ((((long) bArr[i3]) & 255) << 16);
        this.b = i4 + 1;
        return j2 | ((((long) bArr[i4]) & 255) << 24);
    }

    public int o() {
        byte[] bArr = this.f8400a;
        int i = this.b;
        int i2 = i + 1;
        int i3 = i2 + 1;
        int i4 = ((bArr[i] & UByte.MAX_VALUE) << 24) | ((bArr[i2] & UByte.MAX_VALUE) << 16);
        int i5 = i3 + 1;
        int i6 = i4 | ((bArr[i3] & UByte.MAX_VALUE) << 8);
        this.b = i5 + 1;
        return (bArr[i5] & UByte.MAX_VALUE) | i6;
    }

    public int p() {
        byte[] bArr = this.f8400a;
        int i = this.b;
        int i2 = i + 1;
        int i3 = i2 + 1;
        int i4 = (bArr[i] & UByte.MAX_VALUE) | ((bArr[i2] & UByte.MAX_VALUE) << 8);
        int i5 = i3 + 1;
        int i6 = i4 | ((bArr[i3] & UByte.MAX_VALUE) << 16);
        this.b = i5 + 1;
        return ((bArr[i5] & UByte.MAX_VALUE) << 24) | i6;
    }

    public long q() {
        byte[] bArr = this.f8400a;
        int i = this.b;
        int i2 = i + 1;
        long j = (((long) bArr[i]) & 255) << 56;
        int i3 = i2 + 1;
        int i4 = i3 + 1;
        long j2 = j | ((((long) bArr[i2]) & 255) << 48) | ((((long) bArr[i3]) & 255) << 40);
        int i5 = i4 + 1;
        long j3 = j2 | ((((long) bArr[i4]) & 255) << 32);
        int i6 = i5 + 1;
        long j4 = j3 | ((((long) bArr[i5]) & 255) << 24);
        int i7 = i6 + 1;
        long j5 = j4 | ((((long) bArr[i6]) & 255) << 16);
        int i8 = i7 + 1;
        long j6 = j5 | ((((long) bArr[i7]) & 255) << 8);
        this.b = i8 + 1;
        return j6 | (((long) bArr[i8]) & 255);
    }

    public long r() {
        byte[] bArr = this.f8400a;
        int i = this.b;
        int i2 = i + 1;
        long j = ((long) bArr[i]) & 255;
        int i3 = i2 + 1;
        int i4 = i3 + 1;
        long j2 = j | ((((long) bArr[i2]) & 255) << 8) | ((((long) bArr[i3]) & 255) << 16);
        int i5 = i4 + 1;
        long j3 = j2 | ((((long) bArr[i4]) & 255) << 24);
        int i6 = i5 + 1;
        long j4 = j3 | ((((long) bArr[i5]) & 255) << 32);
        int i7 = i6 + 1;
        long j5 = j4 | ((((long) bArr[i6]) & 255) << 40);
        int i8 = i7 + 1;
        long j6 = j5 | ((((long) bArr[i7]) & 255) << 48);
        this.b = i8 + 1;
        return j6 | ((((long) bArr[i8]) & 255) << 56);
    }

    public int s() {
        byte[] bArr = this.f8400a;
        int i = this.b;
        int i2 = i + 1;
        int i3 = (bArr[i2] & UByte.MAX_VALUE) | ((bArr[i] & UByte.MAX_VALUE) << 8);
        this.b = i2 + 1 + 2;
        return i3;
    }

    public int t() {
        return (g() << 21) | (g() << 14) | (g() << 7) | g();
    }

    public int u() {
        int iO = o();
        if (iO >= 0) {
            return iO;
        }
        throw new IllegalStateException("Top bit not zero: " + iO);
    }

    public int v() {
        int iP = p();
        if (iP >= 0) {
            return iP;
        }
        throw new IllegalStateException("Top bit not zero: " + iP);
    }

    public long w() {
        long jQ = q();
        if (jQ >= 0) {
            return jQ;
        }
        throw new IllegalStateException("Top bit not zero: " + jQ);
    }

    public double x() {
        return Double.longBitsToDouble(q());
    }

    public String y() {
        if (b() == 0) {
            return null;
        }
        int i = this.b;
        while (i < this.c && this.f8400a[i] != 0) {
            i++;
        }
        byte[] bArr = this.f8400a;
        int i2 = this.b;
        String str = new String(bArr, i2, i - i2);
        this.b = i;
        if (i < this.c) {
            this.b = i + 1;
        }
        return str;
    }

    public String z() {
        if (b() == 0) {
            return null;
        }
        int i = this.b;
        while (i < this.c && !y.a(this.f8400a[i])) {
            i++;
        }
        int i2 = this.b;
        if (i - i2 >= 3) {
            byte[] bArr = this.f8400a;
            if (bArr[i2] == -17 && bArr[i2 + 1] == -69 && bArr[i2 + 2] == -65) {
                this.b = i2 + 3;
            }
        }
        byte[] bArr2 = this.f8400a;
        int i3 = this.b;
        String str = new String(bArr2, i3, i - i3);
        this.b = i;
        int i4 = this.c;
        if (i == i4) {
            return str;
        }
        byte[] bArr3 = this.f8400a;
        if (bArr3[i] == 13) {
            int i5 = i + 1;
            this.b = i5;
            if (i5 == i4) {
                return str;
            }
        }
        int i6 = this.b;
        if (bArr3[i6] == 10) {
            this.b = i6 + 1;
        }
        return str;
    }

    public p(byte[] bArr) {
        this.f8400a = bArr;
        this.c = bArr.length;
    }

    public void a() {
        this.b = 0;
        this.c = 0;
    }

    public void b(int i) {
        a.a(i >= 0 && i <= this.f8400a.length);
        this.c = i;
    }

    public void c(int i) {
        a.a(i >= 0 && i <= this.c);
        this.b = i;
    }

    public void d(int i) {
        c(this.b + i);
    }

    public String e(int i) {
        return a(i, Charset.forName("UTF-8"));
    }

    public String f(int i) {
        if (i == 0) {
            return "";
        }
        int i2 = this.b;
        int i3 = (i2 + i) - 1;
        String str = new String(this.f8400a, i2, (i3 >= this.c || this.f8400a[i3] != 0) ? i : i - 1);
        this.b += i;
        return str;
    }

    public p(byte[] bArr, int i) {
        this.f8400a = bArr;
        this.c = i;
    }

    public void a(int i) {
        a(e() < i ? new byte[i] : this.f8400a, i);
    }

    public void a(o oVar, int i) {
        a(oVar.f8399a, 0, i);
        oVar.a(0);
    }

    public void a(byte[] bArr, int i) {
        this.f8400a = bArr;
        this.c = i;
        this.b = 0;
    }

    public void a(byte[] bArr, int i, int i2) {
        System.arraycopy(this.f8400a, this.b, bArr, i, i2);
        this.b += i2;
    }
}
