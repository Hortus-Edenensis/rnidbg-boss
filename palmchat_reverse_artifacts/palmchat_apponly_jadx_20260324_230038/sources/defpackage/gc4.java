package defpackage;

import androidx.annotation.Nullable;
import com.google.common.collect.ImmutableSet;
import java.nio.charset.Charset;
import java.util.Arrays;
import kotlin.UByte;
import okio.Utf8;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class gc4 {
    public static final char[] d = {'\r', '\n'};
    public static final char[] e = {'\n'};
    public static final ImmutableSet<Charset> f = ImmutableSet.of(f10.f17407a, f10.c, f10.f, f10.d, f10.e);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f17708a;
    public int b;
    public int c;

    public gc4() {
        this.f17708a = g86.f;
    }

    public long A() {
        byte[] bArr = this.f17708a;
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

    @Nullable
    public String B() {
        return n((char) 0);
    }

    public String C(int i) {
        if (i == 0) {
            return "";
        }
        int i2 = this.b;
        int i3 = (i2 + i) - 1;
        String strE = g86.E(this.f17708a, i2, (i3 >= this.c || this.f17708a[i3] != 0) ? i : i - 1);
        this.b += i;
        return strE;
    }

    public short D() {
        byte[] bArr = this.f17708a;
        int i = this.b;
        int i2 = i + 1;
        int i3 = (bArr[i] & UByte.MAX_VALUE) << 8;
        this.b = i2 + 1;
        return (short) ((bArr[i2] & UByte.MAX_VALUE) | i3);
    }

    public String E(int i) {
        return F(i, f10.c);
    }

    public String F(int i, Charset charset) {
        String str = new String(this.f17708a, this.b, i, charset);
        this.b += i;
        return str;
    }

    public int G() {
        return (H() << 21) | (H() << 14) | (H() << 7) | H();
    }

    public int H() {
        byte[] bArr = this.f17708a;
        int i = this.b;
        this.b = i + 1;
        return bArr[i] & UByte.MAX_VALUE;
    }

    public int I() {
        byte[] bArr = this.f17708a;
        int i = this.b;
        int i2 = i + 1;
        int i3 = (bArr[i2] & UByte.MAX_VALUE) | ((bArr[i] & UByte.MAX_VALUE) << 8);
        this.b = i2 + 1 + 2;
        return i3;
    }

    public long J() {
        byte[] bArr = this.f17708a;
        int i = this.b;
        int i2 = i + 1;
        long j = (((long) bArr[i]) & 255) << 24;
        int i3 = i2 + 1;
        int i4 = i3 + 1;
        long j2 = j | ((((long) bArr[i2]) & 255) << 16) | ((((long) bArr[i3]) & 255) << 8);
        this.b = i4 + 1;
        return j2 | (((long) bArr[i4]) & 255);
    }

    public int K() {
        byte[] bArr = this.f17708a;
        int i = this.b;
        int i2 = i + 1;
        int i3 = i2 + 1;
        int i4 = ((bArr[i] & UByte.MAX_VALUE) << 16) | ((bArr[i2] & UByte.MAX_VALUE) << 8);
        this.b = i3 + 1;
        return (bArr[i3] & UByte.MAX_VALUE) | i4;
    }

    public int L() {
        int iQ = q();
        if (iQ >= 0) {
            return iQ;
        }
        throw new IllegalStateException("Top bit not zero: " + iQ);
    }

    public long M() {
        long jA = A();
        if (jA >= 0) {
            return jA;
        }
        throw new IllegalStateException("Top bit not zero: " + jA);
    }

    public int N() {
        byte[] bArr = this.f17708a;
        int i = this.b;
        int i2 = i + 1;
        int i3 = (bArr[i] & UByte.MAX_VALUE) << 8;
        this.b = i2 + 1;
        return (bArr[i2] & UByte.MAX_VALUE) | i3;
    }

    public long O() {
        int i;
        int i2;
        long j = this.f17708a[this.b];
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
            byte b = this.f17708a[this.b + i];
            if ((b & 192) != 128) {
                throw new NumberFormatException("Invalid UTF-8 sequence continuation byte: " + j);
            }
            j = (j << 6) | ((long) (b & Utf8.REPLACEMENT_BYTE));
        }
        this.b += i2;
        return j;
    }

    @Nullable
    public Charset P() {
        if (a() >= 3) {
            byte[] bArr = this.f17708a;
            int i = this.b;
            if (bArr[i] == -17 && bArr[i + 1] == -69 && bArr[i + 2] == -65) {
                this.b = i + 3;
                return f10.c;
            }
        }
        if (a() < 2) {
            return null;
        }
        byte[] bArr2 = this.f17708a;
        int i2 = this.b;
        byte b = bArr2[i2];
        if (b == -2 && bArr2[i2 + 1] == -1) {
            this.b = i2 + 2;
            return f10.d;
        }
        if (b != -1 || bArr2[i2 + 1] != -2) {
            return null;
        }
        this.b = i2 + 2;
        return f10.e;
    }

    public void Q(int i) {
        S(b() < i ? new byte[i] : this.f17708a, i);
    }

    public void R(byte[] bArr) {
        S(bArr, bArr.length);
    }

    public void S(byte[] bArr, int i) {
        this.f17708a = bArr;
        this.c = i;
        this.b = 0;
    }

    public void T(int i) {
        vh.a(i >= 0 && i <= this.f17708a.length);
        this.c = i;
    }

    public void U(int i) {
        vh.a(i >= 0 && i <= this.c);
        this.b = i;
    }

    public void V(int i) {
        U(this.b + i);
    }

    public final void W(Charset charset) {
        if (m(charset, d) == '\r') {
            m(charset, e);
        }
    }

    public int a() {
        return this.c - this.b;
    }

    public int b() {
        return this.f17708a.length;
    }

    public void c(int i) {
        if (i > b()) {
            this.f17708a = Arrays.copyOf(this.f17708a, i);
        }
    }

    public final int d(Charset charset) {
        int i;
        if (charset.equals(f10.c) || charset.equals(f10.f17407a)) {
            i = 1;
        } else {
            if (!charset.equals(f10.f) && !charset.equals(f10.e) && !charset.equals(f10.d)) {
                throw new IllegalArgumentException("Unsupported charset: " + charset);
            }
            i = 2;
        }
        int i2 = this.b;
        while (true) {
            int i3 = this.c;
            if (i2 >= i3 - (i - 1)) {
                return i3;
            }
            if ((charset.equals(f10.c) || charset.equals(f10.f17407a)) && g86.A0(this.f17708a[i2])) {
                return i2;
            }
            if (charset.equals(f10.f) || charset.equals(f10.d)) {
                byte[] bArr = this.f17708a;
                if (bArr[i2] == 0 && g86.A0(bArr[i2 + 1])) {
                    return i2;
                }
            }
            if (charset.equals(f10.e)) {
                byte[] bArr2 = this.f17708a;
                if (bArr2[i2 + 1] == 0 && g86.A0(bArr2[i2])) {
                    return i2;
                }
            }
            i2 += i;
        }
    }

    public byte[] e() {
        return this.f17708a;
    }

    public int f() {
        return this.b;
    }

    public int g() {
        return this.c;
    }

    public char h(Charset charset) {
        vh.b(f.contains(charset), "Unsupported charset: " + charset);
        return (char) (i(charset) >> 16);
    }

    public final int i(Charset charset) {
        byte bA;
        char c;
        int i = 1;
        if ((charset.equals(f10.c) || charset.equals(f10.f17407a)) && a() >= 1) {
            bA = (byte) e10.a(v46.b(this.f17708a[this.b]));
        } else {
            if ((charset.equals(f10.f) || charset.equals(f10.d)) && a() >= 2) {
                byte[] bArr = this.f17708a;
                int i2 = this.b;
                c = e10.c(bArr[i2], bArr[i2 + 1]);
            } else {
                if (!charset.equals(f10.e) || a() < 2) {
                    return 0;
                }
                byte[] bArr2 = this.f17708a;
                int i3 = this.b;
                c = e10.c(bArr2[i3 + 1], bArr2[i3]);
            }
            bA = (byte) c;
            i = 2;
        }
        return (e10.a(bA) << 16) + i;
    }

    public int j() {
        return this.f17708a[this.b] & UByte.MAX_VALUE;
    }

    public void k(fc4 fc4Var, int i) {
        l(fc4Var.f17507a, 0, i);
        fc4Var.p(0);
    }

    public void l(byte[] bArr, int i, int i2) {
        System.arraycopy(this.f17708a, this.b, bArr, i, i2);
        this.b += i2;
    }

    public final char m(Charset charset, char[] cArr) {
        int i = i(charset);
        if (i == 0) {
            return (char) 0;
        }
        char c = (char) (i >> 16);
        if (!e10.b(cArr, c)) {
            return (char) 0;
        }
        this.b += i & 65535;
        return c;
    }

    @Nullable
    public String n(char c) {
        if (a() == 0) {
            return null;
        }
        int i = this.b;
        while (i < this.c && this.f17708a[i] != c) {
            i++;
        }
        byte[] bArr = this.f17708a;
        int i2 = this.b;
        String strE = g86.E(bArr, i2, i - i2);
        this.b = i;
        if (i < this.c) {
            this.b = i + 1;
        }
        return strE;
    }

    public double o() {
        return Double.longBitsToDouble(A());
    }

    public float p() {
        return Float.intBitsToFloat(q());
    }

    public int q() {
        byte[] bArr = this.f17708a;
        int i = this.b;
        int i2 = i + 1;
        int i3 = i2 + 1;
        int i4 = ((bArr[i] & UByte.MAX_VALUE) << 24) | ((bArr[i2] & UByte.MAX_VALUE) << 16);
        int i5 = i3 + 1;
        int i6 = i4 | ((bArr[i3] & UByte.MAX_VALUE) << 8);
        this.b = i5 + 1;
        return (bArr[i5] & UByte.MAX_VALUE) | i6;
    }

    public int r() {
        byte[] bArr = this.f17708a;
        int i = this.b;
        int i2 = i + 1;
        int i3 = i2 + 1;
        int i4 = (((bArr[i] & UByte.MAX_VALUE) << 24) >> 8) | ((bArr[i2] & UByte.MAX_VALUE) << 8);
        this.b = i3 + 1;
        return (bArr[i3] & UByte.MAX_VALUE) | i4;
    }

    @Nullable
    public String s() {
        return t(f10.c);
    }

    @Nullable
    public String t(Charset charset) {
        vh.b(f.contains(charset), "Unsupported charset: " + charset);
        if (a() == 0) {
            return null;
        }
        if (!charset.equals(f10.f17407a)) {
            P();
        }
        String strF = F(d(charset) - this.b, charset);
        if (this.b == this.c) {
            return strF;
        }
        W(charset);
        return strF;
    }

    public int u() {
        byte[] bArr = this.f17708a;
        int i = this.b;
        int i2 = i + 1;
        int i3 = i2 + 1;
        int i4 = (bArr[i] & UByte.MAX_VALUE) | ((bArr[i2] & UByte.MAX_VALUE) << 8);
        int i5 = i3 + 1;
        int i6 = i4 | ((bArr[i3] & UByte.MAX_VALUE) << 16);
        this.b = i5 + 1;
        return ((bArr[i5] & UByte.MAX_VALUE) << 24) | i6;
    }

    public long v() {
        byte[] bArr = this.f17708a;
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

    public short w() {
        byte[] bArr = this.f17708a;
        int i = this.b;
        int i2 = i + 1;
        int i3 = bArr[i] & UByte.MAX_VALUE;
        this.b = i2 + 1;
        return (short) (((bArr[i2] & UByte.MAX_VALUE) << 8) | i3);
    }

    public long x() {
        byte[] bArr = this.f17708a;
        int i = this.b;
        int i2 = i + 1;
        long j = ((long) bArr[i]) & 255;
        int i3 = i2 + 1;
        int i4 = i3 + 1;
        long j2 = j | ((((long) bArr[i2]) & 255) << 8) | ((((long) bArr[i3]) & 255) << 16);
        this.b = i4 + 1;
        return j2 | ((((long) bArr[i4]) & 255) << 24);
    }

    public int y() {
        int iU = u();
        if (iU >= 0) {
            return iU;
        }
        throw new IllegalStateException("Top bit not zero: " + iU);
    }

    public int z() {
        byte[] bArr = this.f17708a;
        int i = this.b;
        int i2 = i + 1;
        int i3 = bArr[i] & UByte.MAX_VALUE;
        this.b = i2 + 1;
        return ((bArr[i2] & UByte.MAX_VALUE) << 8) | i3;
    }

    public gc4(int i) {
        this.f17708a = new byte[i];
        this.c = i;
    }

    public gc4(byte[] bArr) {
        this.f17708a = bArr;
        this.c = bArr.length;
    }

    public gc4(byte[] bArr, int i) {
        this.f17708a = bArr;
        this.c = i;
    }
}
